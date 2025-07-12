package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC18 extends Keywords {
	public void Feeder_Contract_SC18(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_Excel_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC18";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Feeder_Contract_Module_Name = Excel_data.get("Feeder_Contract_Module_Name");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Vendor_Code_Value = Excel_data.get("Vendor_Code_Value");
		String Conditon = Excel_data.get("Conditon");
		String FC_Input_details_Port_Header = Excel_data.get("FC_Input_details_Port_Header");
		String FC_Input_details_Port_Value = Excel_data.get("FC_Input_details_Port_Value");
		String EquipmentType = Excel_data.get("EquipmentType");
		String POD_Input_Value = Excel_data.get("POD_Input_Value");
		String POD_Header = Excel_data.get("POD_Header");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String LoadTerm_Value = Excel_data.get("LoadTerm_Value");
		String LoadTerm_Header = Excel_data.get("LoadTerm_Header");
		String EquipmentStatus = Excel_data.get("EquipmentStatus");
		String Pickup_Header = Excel_data.get("Pickup_Header");
		String Pickup_Value = Excel_data.get("Pickup_Value");
		String Drop_Header = Excel_data.get("Drop_Header");
		String Drop_Value = Excel_data.get("Drop_Value");
		String DischargeTerm_Header = Excel_data.get("DischargeTerm_Header");
		String DischargeTerm_Value = Excel_data.get("DischargeTerm_Value");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field", test, test1);
		moduleNavigate(driver, Feeder_Contract_Module_Name);
		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field", test, test1);

		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master",
				test, test1);
		waitForElement(driver, FC_Vendor_Search_Button);
		click(driver, FC_Vendor_Search_Button);
		twoColumnSearchWindow(driver, Vendor_Code_Header, Conditon, Vendor_Code_Value);
		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master",
				test, test1);

		Step_Start(3, "Click on the '+' Button to add the all details", test, test1);
		waitForElement(driver, FC_AddPortPair);
		click(driver, FC_AddPortPair);
		Step_End(3, "Click on the '+' Button to add the all details", test, test1);

		Step_Start(4, "It show the Feeder Contract input details page", test, test1);
		waitForDisplay(driver, FC_Feeder_Contract_Input_Details);
		if (isdisplayed(driver, FC_Feeder_Contract_Input_Details)) {
			System.out.println(
					"Expected Result is : Feeder Contract Input Details Page should be opened || Actual Result is : Feeder Contract Input Details page is opened ");
			Extent_pass_New(driver,
					"Expected Result is : Feeder Contract Input Details Page should be opened || Actual Result is : Feeder Contract Input Details page is opened ",
					test, test1);
		} else {
			System.out.println(
					"Expected Result is : Feeder Contract Input Details Page should be opened || Actual Result is : Feeder Contract Input Details page is not opened ");
			Extent_fail(driver,
					"Expected Result is : Feeder Contract Input Details Page should be opened || Actual Result is : Feeder Contract Input Details page is not opened ",
					test, test1);
		}
		Step_End(4, "It show the Feeder Contract input details page", test, test1);

		Step_Start(5, "Select the Discharge term using the Drop down", test, test1);
		waitForElement(driver, FC_POL_Search);
		click(driver, FC_POL_Search);
		twoColumnSearchWindow(driver, FC_Input_details_Port_Header, Conditon, FC_Input_details_Port_Value);

		waitForElement(driver, FC_POD_Search);
		click(driver, FC_POD_Search);
		twoColumnSearchWindow(driver, POD_Header, Two_Column_Condition, POD_Input_Value);

		waitForElement(driver, FC_EquipmentDropdown);
		click(driver, FC_EquipmentDropdown);
		formatLocatorClick(driver, DropDown_Select, EquipmentType);

		waitForElement(driver, FC_EqpStatusDropdown);
		click(driver, FC_EqpStatusDropdown);
		formatLocatorClick(driver, DropDown_Select, EquipmentStatus);

		waitForElement(driver, FC_PickupTerminal);
		click(driver, FC_PickupTerminal);
		twoColumnSearchWindow(driver, Pickup_Header, Two_Column_Condition, Pickup_Value);

		waitForElement(driver, FC_DropTerminal);
		click(driver, FC_DropTerminal);
		twoColumnSearchWindow(driver, Drop_Header, Two_Column_Condition, Drop_Value);

		waitForElement(driver, FC_Load_Term);
		click(driver, FC_Load_Term);
		twoColumnSearchWindow(driver, LoadTerm_Header, Two_Column_Condition, LoadTerm_Value);

		waitForElement(driver, FC_DischargeTerm);
		click(driver, FC_DischargeTerm);
		twoColumnSearchWindow(driver, DischargeTerm_Header, Two_Column_Condition, DischargeTerm_Value);

		waitForElement(driver, FC_DischargeTerm_Input);
		String Actual_DischargeTerm_Value = getAttribute(driver, FC_DischargeTerm_Input, "value");

		if (DischargeTerm_Value.equals(Actual_DischargeTerm_Value)) {
			System.out.println(" Matched || The Expected Discharge Term value should be : " + DischargeTerm_Value
					+ " || The Actual Discharge Term value is : " + Actual_DischargeTerm_Value);
			Extent_pass_New(driver, " Matched || The Expected Discharge Term value should be : " + DischargeTerm_Value
					+ " || The Actual Discharge Term valueis : " + Actual_DischargeTerm_Value, test, test1);
		} else {
			System.out.println(" Not Matched || The Expected Discharge Term value should be : " + DischargeTerm_Value
					+ " || The Actual Discharge Term value is : " + Actual_DischargeTerm_Value);
			Extent_fail(driver, " Not Matched || The Expected Discharge Term value should be : " + DischargeTerm_Value
					+ " || The Actual Discharge Term value is : " + Actual_DischargeTerm_Value, test, test1);
		}

		Step_End(5, "Select the Discharge term using the Drop down", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}