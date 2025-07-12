package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD53 extends Keywords {
	public void Discharge_Reconciliation_MD53(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) throws AWTException {

		String testcase_Name = "TC_Discharge_Reconciliation_MD53";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Plan_Type = Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Type);

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency,", test, test1);

		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);

		moduleNavigate(driver, Dis_Recon_Module);

		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		newButton(driver);

		Step_End(3, "Click on New button if New Button is not Available Go to Next Step", test, test1);

		Step_Start(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);


		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		waitForElement(driver, grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_bound_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
		
		if (!Port_Input.equals("")) {
			
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		
		waitForElement(driver, grid_terminal_IMP_DOC);
		sendKeys(driver, grid_terminal_IMP_DOC,Terminal_Input);

		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		Step_Start(5, " Select the Plan as ALL/Local/Transhipment", test, test1);

		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(5, " Select the Plan as ALL/Local/Transhipment", test, test1);
		Step_Start(6, "Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, "Click on Download BL Button.", test, test1);
		Step_Start(7, "Click on Full Screen Option which before the 9Dots.", test, test1);
		waitForElement(driver, Full_Screen_btn);
		click(driver, Full_Screen_btn);
		Step_End(7, "Click on Full Screen Option which before the 9Dots.", test, test1);
		Step_Start(8, "Verify that system expand the Grid size into Full window", test, test1);

		try {

			String[] values = splitXpath(DownloadBLs);

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
		Step_End(8, "Verify that system expand the Grid size into Full window", test, test1);
		Step_Start(9, " Click on Escape Button in the Keyboard", test, test1);

		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		
		
	
		

		Step_End(9, " Click on Escape Button in the Keyboard", test, test1);

		Step_Start(10, "verify that system back to normal mode", test, test1);

		try {

			String[] values = splitXpath(DownloadBLs);

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
		
		Step_End(10, "verify that system back to normal mode.", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
