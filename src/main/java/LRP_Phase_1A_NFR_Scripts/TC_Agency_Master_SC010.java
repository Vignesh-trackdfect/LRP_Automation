package LRP_Phase_1A_NFR_Scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Agency_Master_SC010 extends Keywords{

	public void Agency_Master_SC010(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		
		String testcase_Name = "TC_Agency_Master_SC010";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Branch_Code = Excel_data.get("Branch_Code");
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		
		Step_Start(1, "Login & Open agency master screen.", test, test1);

		moduleNavigate(driver, Agency_Master_Module);
	
		Step_End(1, "Login & Open agency master screen.", test, test1);
		
		Step_Start(2, "Retrieve Office Agency from the scrreen.", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver,Search_Condition, Select_field, Branch_Code, "", "", "", "");
		
		Step_End(2, "Retrieve Office Agency from the scrreen.", test, test1);
		
		
        Step_Start(3, "Navigate to Controlling Ports tab.", test, test1);
		
        
		waitForElement(driver, AM_Controlling_Ports_Tab);
		click(driver, AM_Controlling_Ports_Tab);
		
		Step_End(3, "Navigate to Controlling Ports tab.", test, test1);
		
		Step_Start(4, "Click on the Grid Settings Icon,Click the “Full Screen” Icon.", test, test1);
		
		waitForElement(driver, AM_Click_For_More_Options);
		click(driver, AM_Click_For_More_Options);
		
		waitForElement(driver, AM_Fullscreen_Button_toolbar);
		click(driver, AM_Fullscreen_Button_toolbar);
		
		
		Step_End(4, "Click on the Grid Settings Icon,Click the “Full Screen” Icon.", test, test1);
		
		
		Step_Start(5, "verify that the grid expands to occupy full screen.", test, test1);
				
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
 
			String[] values = splitXpath(AM_AgencyDetail_Toolbar);
 
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
 
		
		Step_End(5, "verify that the grid expands to occupy full screen.", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
	}
	
}
