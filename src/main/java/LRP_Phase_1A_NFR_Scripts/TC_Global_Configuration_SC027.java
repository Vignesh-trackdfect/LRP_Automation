package LRP_Phase_1A_NFR_Scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Global_Configuration_SC027 extends Keywords{

	public void Global_Configuration_SC027(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		
		String testcase_Name = "TC_Global_Configuration_SC027";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Global_Configuration_Module = Excel_data.get("Global_Configuration_Module");
			
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		
		Step_Start(1, "Login & open global configuration screen.", test, test1);

		moduleNavigate(driver, Global_Configuration_Module);
	
		Step_End(1, "Login & open global configuration screen.", test, test1);
		
		Step_Start(2, "Click on the Grid Settings Icon,Click the “Full Screen” Icon.", test, test1);
		
		waitForElement(driver, GC_Fullscreeen_grid);
		click(driver, GC_Fullscreeen_grid);
			
		Step_End(2, "Click on the Grid Settings Icon,Click the “Full Screen” Icon.", test, test1);
		
		
        Step_Start(3, "verify that the grid expands to occupy full screen.", test, test1);
		
        try {
			 
			String[] values = splitXpath(SearchButton_Toolbar);
 
			WebElement element = driver.findElement(By.xpath(values[1]));
 
			element.click();
 
			System.out.println(
					"fail:The Expected is FullScreen should be displayed || The Actual is FullScreen is not displayed");
			extent_fail(driver,
					"fail:The Expected is FullScreen should be displayed || The Actual is FullScreen is not displayed",
					test, test1);
 
		} catch (Exception e) {
 
			System.out.println(
					"Pass:The Expected is FullScreen should be displayed || The Actual is FullScreen is displayed");
			Extent_pass(driver,
					"Pass:The Expected is FullScreen should be displayed || The Actual is FullScreen is  displayed",
					test, test1);
 
		}	
 
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		
 
		try {
 
			String[] values = splitXpath(GC_Attribut_input);
 
			WebElement element = driver.findElement(By.xpath(values[1]));
 
			element.click();
 
			System.out.println(
					"Pass:The Expected is that system should be back to normal mode || The Actual is that system is back to normal mode");
			Extent_pass(driver,
					"Pass:The Expected is that system should be back to normal mode || The Actual is that system is back to normal mode",
					test, test1);
 
		} catch (Exception e) {
 
			System.out.println(
					"fail:The Expected is that system should be back to normal mode || The Actual is that system is not back to normal mode");
			extent_fail(driver,
					"fail:The Expected is that system should be back to normal mode || The Actual is that system is not back to normal mode",
					test, test1);
 
		}
 
	
		
		Step_End(3, "verify that the grid expands to occupy full screen.", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
	}
}
