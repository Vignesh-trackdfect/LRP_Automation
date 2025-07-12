package LRP_Booking_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC020 extends Keywords{

	public void Booking_SC020(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String test_Case_Name="TC_Booking_SC020";
		//	Get data from excel sheet
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String bookingModule = Excel_data.get("Module_Search");
		String agencyUser = Excel_data.get("agencyUser");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");

		navigateUrl(driver, url);
		Extent_Start(test_Case_Name, test, test1);
		//Login
		LRP_Login(driver, Username, Password);
		//Switch the Profile
		SwitchProfile(driver, agencyUser);
		//	Module search
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, bookingModule);
		Step_Start(1, "Enter The Agreement Party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(1, "Enter The Agreement Party", test, test1);
		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		keyDown(driver);
		Step_End(2, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		Step_Start(3, "System List The Port Details", test, test1);
		waitForDisplay(driver, Port_Detail);
		if(isDisplayed(driver,Port_Detail)) {
			System.out.println("System Listed the Port Detail");
			Extent_pass_New(driver, "System Listed the Port Detail", test,test1);
			List<WebElement> Port_Codes = listOfElements(driver, portCodes);
			for(WebElement code:Port_Codes) {
				String portCode=code.getText();
				System.out.println("Matched || The Expected Result is The Ports Details Should List || The Actual Result is : The Port Details are Listed. The Listed Port is "+portCode);
				Extent_pass_New(driver,"Matched || The Expected Result is The Ports Details Should List || The Actual Result is : The Port Details are Listed. The Listed Port is "+portCode, test,test1);
			}
			enter(driver);
		}else {
			System.out.println("Not Matched || The Expected Result is The Ports Details Should List || The Actual Result is : The Port Details are Not Listed.");
			Extent_fail(driver,"Not Matched || The Expected Result is The Ports Details Should List || The Actual Result is : The Port Details are Not Listed.", test,test1);
		}
		enter(driver);
		Step_End(3, "System List The Port Details", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}
