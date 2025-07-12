package LRP_CRO_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC008 extends Keywords {

	public void CRO_SC008(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC008";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String Agency_Configuration_Module = Excel_data.get("Agency_Configuration_Module");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Condition = Excel_data.get("Condition");
		String Agency_Attribute_Data = Excel_data.get("Agency_Attribute_Data");
		String Agency_Description_Data = Excel_data.get("Agency_Description_Data");
		String value = Excel_data.get("value");
		String default_value = Excel_data.get("default_value");
		String reset = Excel_data.get("reset");
		String CRO_Popup = Excel_data.get("CRO_Popup");
		
		
		
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		//	Switch the Profile
		
		SwitchProfile(driver, agencyUser);
		
		Step_Start(1, "Open the Agency Configuration", test, test1);	
		Step_Start(2, "Click Create icon", test, test1);
		Step_Start(3, "Validate message 'Do you want to Create an Agency Configuration?' is shown", test, test1);
		Step_Start(4, "Click 'Yes' button", test, test1);
		Step_Start(5, "Search the Agency", test, test1);
		Step_Start(6, "Click Show button", test, test1);
		Step_Start(7, "Search 'Booking – CRO should not be Mandatory' in Description field", test, test1);
		Step_Start(8, "If available, click the record in the grid", test, test1);
		Step_Start(9, "Set the value as 'Y'", test, test1);
		Step_Start(10, "Click '+' button", test, test1);
		Step_Start(11, "Validate message 'Agency configuration property(s) updated' is shown", test, test1);
		Step_Start(12, "Click OK button", test, test1);
		Step_Start(13, "If not available in search, click '+' button", test, test1);
		Step_Start(14, "Search 'BCO attribute' in search field", test, test1);
		Step_Start(15, "Click Select button", test, test1);
		Step_Start(16, "Validate message 'Agency configuration property(s) saved' is shown and record added to grid", test, test1);
		Step_Start(17, "Click OK button", test, test1);
		Step_Start(18, "Search 'Booking – CRO should not be Mandatory' in Description", test, test1);
		Step_Start(19, "Click the record in the grid", test, test1);
		Step_Start(20, "Enter the value as 'Y'", test, test1);
		Step_Start(21, "Click '+' button", test, test1);
		Step_Start(22, "Validate message 'Agency configuration property(s) saved' is shown and record added to grid", test, test1);
		Step_Start(23, "Click OK button", test, test1);


		List<Boolean> newlyAdded = setAgencyConfiguration(driver, Agency_Configuration_Module, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, agencyUser, Agency_Attribute_Data, Agency_Description_Data, value);
		Step_End(23, "Click OK button", test, test1);
		Step_End(22, "Validate message 'Agency configuration property(s) saved' is shown and record added to grid", test, test1);
		Step_End(21, "Click '+' button", test, test1);
		Step_End(20, "Enter the value as 'Y'", test, test1);
		Step_End(19, "Click the record in the grid", test, test1);
		Step_End(18, "Search 'Booking – CRO should not be Mandatory' in Description", test, test1);
		Step_End(17, "Click OK button", test, test1);
		Step_End(16, "Validate message 'Agency configuration property(s) saved' is shown and record added to grid", test, test1);
		Step_End(15, "Click Select button", test, test1);
		Step_End(14, "Search 'BCO attribute' in search field", test, test1);
		Step_End(13, "If not available in search, click '+' button", test, test1);
		Step_End(12, "Click OK button", test, test1);
		Step_End(11, "Validate message 'Agency configuration property(s) updated' is shown", test, test1);
		Step_End(10, "Click '+' button", test, test1);
		Step_End(9, "Set the value as 'Y'", test, test1);
		Step_End(8, "If available, click the record in the grid", test, test1);
		Step_End(7, "Search 'Booking – CRO should not be Mandatory' in Description field", test, test1);
		Step_End(6, "Click Show button", test, test1);
		Step_End(5, "Search the Agency", test, test1);
		Step_End(4, "Click 'Yes' button", test, test1);
		Step_End(3, "Validate message 'Do you want to Create an Agency Configuration?' is shown", test, test1);
		Step_End(2, "Click Create icon", test, test1);
		Step_End(1, "Open the Agency Configuration", test, test1);

		Step_Start(24, "Open Booking module", test, test1);
		Step_Start(25, "Retrieve the Booking number", test, test1);

		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
		Step_End(25, "Retrieve the Booking number", test, test1);
		Step_End(24, "Open Booking module", test, test1);

		Step_Start(26, "Click CRO button", test, test1);

		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		Step_End(26, "Click CRO button", test, test1);


		Step_Start(27, "Validate message 'CRO is not applicable for this agency' is shown", test, test1);

		waitForPopup(driver, popup_Message, CRO_Popup);
		String actual_Popup = getText(driver, popup_Message);
		System.out.println(actual_Popup);
		if(CRO_Popup.equals(actual_Popup)) {
			System.out.println("Matched || Expected Result is : "+CRO_Popup + " ||   Actual Result is : "+actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Result is : "+CRO_Popup + " ||   Actual Result is : "+actual_Popup, test, test1);
		     waitForElement(driver, popup_Message_Ok_Button);
		     click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Matched || Expected Result is : "+CRO_Popup + " ||   Actual Result is : "+actual_Popup);
			Extent_fail(driver, "Matched || Expected Result is : "+CRO_Popup + " ||   Actual Result is : "+actual_Popup, test, test1);
		}
		Step_End(27, "Validate message 'CRO is not applicable for this agency' is shown", test, test1);

		Step_Start(28, "Go to Agency Configuration", test, test1);
		Step_Start(29, "Search 'Booking – CRO should not be Mandatory' in Description", test, test1);
		Step_Start(30, "Click the record in the grid", test, test1);
		Step_Start(31, "Enter the value as 'N'", test, test1);
		Step_Start(32, "Click '+' button", test, test1);
		Step_Start(33, "Validate message 'Agency configuration property(s) updated' is shown", test, test1);
		Step_Start(34, "Click OK button", test, test1);
		reSetAgencyConfiguration(driver, Agency_Configuration_Module, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, agencyUser, Agency_Description_Data, default_value, newlyAdded, reset);
		Step_End(34, "Click OK button", test, test1);
		Step_End(33, "Validate message 'Agency configuration property(s) updated' is shown", test, test1);
		Step_End(32, "Click '+' button", test, test1);
		Step_End(31, "Enter the value as 'N'", test, test1);
		Step_End(30, "Click the record in the grid", test, test1);
		Step_End(29, "Search 'Booking – CRO should not be Mandatory' in Description", test, test1);
		Step_End(28, "Go to Agency Configuration", test, test1);

		
		Extent_completed(testCaseName, test, test1);
		
	}

}
