package LRP_Phase_1A_NFR_Scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_User_Management_Report_SC020 extends Keywords {

	public void User_Management_Report_SC020(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_User_Management_Report_SC020";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Report_Module = Excel_data.get("User_Management_Report_Module");
		String User_Option = Excel_data.get("User_Option");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String User_Name_Input = Excel_data.get("User_Name_Input");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login & open user management report screen.", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Report_Module);

		Step_End(1, "Login & open user management report screen.", test, test1);

		Step_Start(2, "Retrieve data by using User Option (By all)", test, test1);

		waitForElement(driver, UMR_User_Option_drop_down);
		click(driver, UMR_User_Option_drop_down);
		formatLocatorClick(driver, DropDown_Select, User_Option);

		waitForElement(driver, UMR_User_Name_Button);
		click(driver, UMR_User_Name_Button);

		twoColumnSearchWindow(driver, User_Name_Header, Dropdown_Condition, User_Name_Input);

		Step_End(2, "Retrieve data by using User Option (By all)", test, test1);

		Step_Start(3, "Click on show button to display the data", test, test1);

		waitForElement(driver, UMR_Show_Button);
		click(driver, UMR_Show_Button);

		Step_End(3, "Click on show button to display the data", test, test1);

    	Step_Start(4, "Click on the Grid Settings Icon,Click the “Full Screen” Icon.", test, test1);

		
		waitForElement(driver, UMS_Grid_ToolBar);
		click(driver, UMS_Grid_ToolBar);
		
    	waitForElement(driver, UMS_Grid_FullScreen_Btn);
		click(driver, UMS_Grid_FullScreen_Btn);
		
		Step_End(4, "Click on the Grid Settings Icon,Click the “Full Screen” Icon.", test, test1);
		
    	Step_Start(5, "verify that the grid expands to occupy full screen..", test, test1);
    	

		try {

			String[] values = splitXpath(UMS_Grid_ToolBar);

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
			Extent_pass_New(driver,
					"Pass:The Expected is FullScreen should be displayed || The Actual is FullScreen is  displayed",
					test, test1);

		}	

		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		

		try {

			String[] values = splitXpath(UMS_Grid_ToolBar);

			WebElement element = driver.findElement(By.xpath(values[1]));

			element.click();

			System.out.println(
					"Pass:The Expected is that system should be back to normal mode || The Actual is that system is back to normal mode");
			Extent_pass_New(driver,
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
    	
    	Extent_completed(testCaseName, test, test1);

	}
	
}
