package commonMethods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.net.URL;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Config extends Keywords {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private String headless = Utils.getDataFromTestConfig("Headless");

	public static WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver webDriver) {
		driver.set(webDriver);
	}

	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();
		}
	}

	public WebDriver getWebDriver1(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("download.prompt_for_download", false); // Disable download prompts
			prefs.put("download.directory_upgrade", true); // Automatically download to the specified directory
			prefs.put("safebrowsing.enabled", true); // Disable Safe Browsing
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);
			 prefs.put("profile.default_content_setting_values.clipboard", 1); // 1 = Allow, 2 = Block
		        // Configure Chrome options
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-notifications"); // Disable notifications
			options.addArguments("--ignore-certificate-errors"); // Ignore SSL errors
			options.addArguments("--password-store=basic");
			options.setAcceptInsecureCerts(true); // Accept insecure certificates
			options.addArguments("--disable-popup-blocking"); // Disable popup blocking
			if (headless.equalsIgnoreCase("Yes")) {
				options.addArguments("--headless");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-gpu");
				options.addArguments("window-size=1920,1080");
			}
			options.addArguments("--disable-password-manager-reauthentication");
			options.addArguments("--disable-save-password-bubble");
			options.addArguments("--profile.password_manager_enabled=false ");
			options.addArguments("--disable-password-generation");
			options.addArguments("--disable-infobars"); // Disable info bars
			options.addArguments("--disable-extensions"); // Disable browser extensions
			options.addArguments("--disable-application-cache"); // Disable app cache
			options.addArguments("--force-device-scale-factor=0.8");
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.ALL);
			options.setCapability("goog:loggingPrefs", logPrefs);
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			 // Suppress CDP warning logs
	        Logger.getLogger("org.openqa.selenium.devtools").setLevel(Level.OFF);

	        // Optional: suppress all Selenium logs
	        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

	        System.setProperty("webdriver.chrome.silentOutput", "true");

			setDriver(new ChromeDriver(options));
			System.out.println("Chrome Browser launched...");
			getDriver().manage().window().maximize();
//			Dimension size = new Dimension(1366, 768);
//			getDriver().manage().window().setSize(size);
		} else if (browserName.equalsIgnoreCase("Edge")) {
			EdgeOptions options = new EdgeOptions();

			setDriver(new EdgeDriver(options));
			System.out.println("Edge Browser launched...");
			getDriver().manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();

			options.addPreference("dom.webnotifications.enabled", false);

			setDriver(new FirefoxDriver(options));
			System.out.println("Firefox Browser launched...");
			getDriver().manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("IE")) {
			setDriver(new InternetExplorerDriver());
			System.out.println("Internet Explorer Browser launched...");
			getDriver().manage().window().maximize();
		}

		return getDriver();
	}

	public WebDriver remoteWebDriver(String browserName) {
		String gridUrl = "http://192.168.1.11:4444";

		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				ChromeOptions options = new ChromeOptions();

				options.addArguments("disable-notifications");
				options.addArguments("--force-device-scale-factor=0.9");
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-application-cache");
				options.addArguments("--safebrowsing-disable-download-protection");
				options.addArguments("ignore-certificate-errors");
				options.addArguments("--disable-popup-blocking");

				if (headless.equalsIgnoreCase("Yes")) {
					options.addArguments("--headless");
					options.addArguments("--no-sandbox");
					options.addArguments("--disable-dev-shm-usage");
					options.addArguments("--disable-gpu");
					options.addArguments("window-size=1920,1080");
				}

				LoggingPreferences logPrefs = new LoggingPreferences();
				logPrefs.enable(LogType.BROWSER, Level.ALL);
				options.setCapability("goog:loggingPrefs", logPrefs);
				options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				setDriver(new RemoteWebDriver(new URL(gridUrl), capabilities));
				System.out.println("Remote Chrome Browser launched...");
				getDriver().manage().window().maximize();

			} else if (browserName.equalsIgnoreCase("Edge")) {
				EdgeOptions options = new EdgeOptions();

				setDriver(new RemoteWebDriver(new URL(gridUrl), options));
				System.out.println("Remote Edge Browser launched...");
				getDriver().manage().window().maximize();

			} else if (browserName.equalsIgnoreCase("Firefox")) {
				FirefoxOptions options = new FirefoxOptions();

				options.addPreference("dom.webnotifications.enabled", false);

				setDriver(new RemoteWebDriver(new URL(gridUrl), options));
				System.out.println("Remote Firefox Browser launched...");
				getDriver().manage().window().maximize();

			} else if (browserName.equalsIgnoreCase("IE")) {
				InternetExplorerOptions options = new InternetExplorerOptions();

				setDriver(new RemoteWebDriver(new URL(gridUrl), options));
				System.out.println("Remote Internet Explorer Browser launched...");
				getDriver().manage().window().maximize();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid Grid URL: " + gridUrl);
		}

		return getDriver();
	}

	public void consoleLogs(String userFlow) throws IOException, InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String currentDate = "./Console-Logs/" + dateFormat.format(date) + "_Logs";

		File file = new File(currentDate);
		file.mkdir();

		try (FileWriter fileWriter = new FileWriter(currentDate + "/" + userFlow + ".txt")) {
			fileWriter.write("\n");
			fileWriter.write(
					"====================================== TRACKDFECT || Solverminds CONSOLE LOGS ===================================");
			fileWriter.write("\n");

			Thread.sleep(3000);
			LogEntries entry = getDriver().manage().logs().get(LogType.BROWSER);
			List<LogEntry> log = entry.getAll();

			for (LogEntry logs : log) {
				fileWriter.write("\n");
				fileWriter.write(
						"[" + new Date(logs.getTimestamp()) + "] [" + logs.getLevel() + "] " + logs.getMessage());
				fileWriter.write("\n");
			}
		}
	}
}
