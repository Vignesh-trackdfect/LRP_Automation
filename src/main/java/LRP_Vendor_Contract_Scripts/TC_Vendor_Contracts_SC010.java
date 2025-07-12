package LRP_Vendor_Contract_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Contracts_SC010 extends Keywords {

	public void Vendor_Contracts_SC010(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Vendor_Contracts_SC010";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_User = Excel_data.get("Agency_User");
		String Vendor_Contract_Module = Excel_data.get("Vendor_Contract_Module");
		String Global_Search_Type1_VC = Excel_data.get("Global_Search_Type1_VC");
		String Global_Search_Condition_VC = Excel_data.get("Global_Search_Condition_VC");
		String Global_Search_Value1_VC = Excel_data.get("Global_Search_Value1_VC");
		String Global_Search_Type2_VC = Excel_data.get("Global_Search_Type2_VC");
		String Global_Search_Value2_VC = Excel_data.get("Global_Search_Value2_VC");
		String Global_Search_Type3_VC = Excel_data.get("Global_Search_Type3_VC");
		String Global_Search_Value3_VC = Excel_data.get("Global_Search_Value3_VC");
		String Contract_Approved_Popup = Excel_data.get("Contract_Approved_Popup");
		String Contract_Status_Exp = Excel_data.get("Contract_Status_Exp");
		String Contract_Mapping_Module = Excel_data.get("Contract_Mapping_Module");
		String Port_Select_Header_CM = Excel_data.get("Port_Select_Header_CM");
		String Port_Codes_select_CM = Excel_data.get("Port_Codes_select_CM");
		String Portcode_Select_Codition = Excel_data.get("Portcode_Select_Codition");
		String Terminal_Codes_Select_CM = Excel_data.get("Terminal_Codes_Select_CM");
		String Select_All_Services = Excel_data.get("Select_All_Services");
		String Service_Select_Header = Excel_data.get("Service_Select_Header");
		String Service_Codes_Select = Excel_data.get("Service_Codes_Select");
		String Vessel_Select_Header = Excel_data.get("Vessel_Select_Header");
		String Vessel_Codes_Select = Excel_data.get("Vessel_Codes_Select");
		String Select_All_Vessels = Excel_data.get("Select_All_Vessels");
		String Contract_Mapping_Saved_popup = Excel_data.get("Contract_Mapping_Saved_popup");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		// Login
		LRP_Login(driver, username, password);
		SwitchProfile(driver, Agency_User);
		// Vendor Contract
		Step_Start(1, "Enter the  screen name as 'Vendor contracts' in module search field.   ", test, test1);
		moduleNavigate(driver, Vendor_Contract_Module);
		Step_End(1, "Enter the  screen name as 'Vendor contracts' in module search field.   ", test, test1);

		Step_Start(2, "Click on the global search option which is available in the tool bar. ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(2, "Click on the global search option which is available in the tool bar. ", test, test1);

		Step_Start(3, "Check whether the system opens the contract details search window. ", test, test1);
		waitForDisplay(driver, type_Select1);
		if (isDisplayed(driver, type_Select1)) {
			System.out.println(
					"Expected : system should opens the contract details search window after click the global search button||  Actual : system opens the contract details search window after click the global search button");
			Extent_pass_New(driver,
					"Expected : system should opens the contract details search window after click the global search button||  Actual : system opens the contract details search window after click the global search button",
					test, test1);
		} else {
			System.out.println(
					"Expected : system should opens the contract details search window after click the global search button||  Actual : system not opens the contract details search window after click the global search button");
			Extent_fail(driver,
					"Expected : system should opens the contract details search window after click the global search button||  Actual : system not opens the contract details search window after click the global search button",
					test, test1);
		}

		Step_End(3, "Check whether the system opens the contract details search window. ", test, test1);

		Step_Start(4, "Enter the saved contract number in the contract number search field", test, test1);
		Step_Start(5, "Click on the search button. ", test, test1);
		Step_Start(6, "System will show the contract number", test, test1);
		Step_Start(7, "Click on the select button.", test, test1);

		globalValueSearchWindow(driver, Global_Search_Condition_VC, Global_Search_Type1_VC, Global_Search_Value1_VC,
				Global_Search_Type2_VC, Global_Search_Value2_VC, Global_Search_Type3_VC, Global_Search_Value3_VC);

		Step_End(7, "Click on the select button.", test, test1);
		Step_End(6, "System will show the contract number", test, test1);
		Step_End(5, "Click on the search button. ", test, test1);
		Step_End(4, "Enter the saved contract number in the contract number search field", test, test1);

		Step_Start(8, "Check whether the system retrieves the saved contract number.", test, test1);
		waitForElement(driver, contract_No_VC);
		String Act_VendorContractNum = getAttribute(driver, contract_No_VC, "value");
		if (Global_Search_Value1_VC.equals(Act_VendorContractNum)) {
			System.out.println("Expected : System Should retrieves the saved contract number, exp num : "
					+ Global_Search_Value1_VC + "  || Actaul : system retrieves the saved contract number, Act num : "
					+ Act_VendorContractNum);
			Extent_pass_New(driver,
					"Expected : System Should retrieves the saved contract number, exp num : " + Global_Search_Value1_VC
							+ "  || Actaul : system retrieves the saved contract number, Act num : "
							+ Act_VendorContractNum,
					test, test1);
		} else {
			System.out.println(
					"Expected : System Should retrieves the saved contract number, exp num : " + Global_Search_Value1_VC
							+ "  || Actaul : system not retrieves the saved contract number, Act num : "
							+ Act_VendorContractNum);
			Extent_fail(driver,
					"Expected : System Should retrieves the saved contract number, exp num : " + Global_Search_Value1_VC
							+ "  || Actaul : system not retrieves the saved contract number, Act num : "
							+ Act_VendorContractNum,
					test, test1);
		}
		Step_End(8, "Check whether the system retrieves the saved contract number.", test, test1);

		Step_Start(9, "Click on Accept option.  ", test, test1);
		waitForElement(driver, accept_Button_VC);
		click(driver, accept_Button_VC);
		Step_End(9, "Click on Accept option.  ", test, test1);

		Step_Start(10, "System displays the confirmation message and click ok option", test, test1);
		waitForElement(driver, Contract_Status_VC);
		String Act_Contract_status = getText(driver, Contract_Status_VC);
		if (Contract_Status_Exp.equals(Act_Contract_status)) {
			System.out.println("Matched || Expected : Contract should be changed to " + Contract_Status_Exp
					+ " status after accept it || Actual : Contract changed to '" + Act_Contract_status
					+ "' status after accept it");
			Extent_pass_New(driver,
					"Matched || Expected : Contract should be changed to " + Contract_Status_Exp
							+ " status after accept it || Actual : Contract changed to '" + Act_Contract_status
							+ "' status after accept it",
					test, test1);
		} else {
			System.out.println("Not Matched || Expected : Contract should be changed to " + Contract_Status_Exp
					+ " status after accept it || Actual : Contract changed to '" + Act_Contract_status
					+ "' status after accept it");
			Extent_fail(driver,
					"Not Matched || Expected : Contract should be changed to " + Contract_Status_Exp
							+ " status after accept it || Actual : Contract changed to '" + Act_Contract_status
							+ "' status after accept it",
					test, test1);
		}
		Step_End(10, "System displays the confirmation message and click ok option", test, test1);

		Step_Start(11, "System will ask for contract mapping creation.             ", test, test1);
		waitForPopup(driver, popup_Message, Contract_Approved_Popup);
		String Act_ContractMap_Popup = getText(driver, popup_Message);
		if (Act_ContractMap_Popup.equals(Contract_Approved_Popup)) {
			System.out.println("Popup Matched || Expected popup :" + Contract_Approved_Popup + " ||  Actual popup : "
					+ Act_ContractMap_Popup);
			Extent_pass_New(driver, "Popup Matched || Expected popup :" + Contract_Approved_Popup + " ||  Actual popup : "
					+ Act_ContractMap_Popup, test, test1);
		} else {
			System.out.println("Popup Not Matched || Expected popup :" + Contract_Approved_Popup
					+ " ||  Actual popup : " + Act_ContractMap_Popup);
			Extent_fail(driver, "Popup Not Matched || Expected popup :" + Contract_Approved_Popup
					+ " ||  Actual popup : " + Act_ContractMap_Popup, test, test1);
		}
		Step_End(11, "System will ask for contract mapping creation.             ", test, test1);

		Step_Start(12, "Click Yes option. ", test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		Step_End(12, "Click Yes option. ", test, test1);

		Step_Start(13, "Ensure that system navigates to Contract Mapping.  ", test, test1);
		waitForElement(driver, Current_Module_Name);
		String Act_ModuleName = getText(driver, Current_Module_Name);
		if (Contract_Mapping_Module.equals(Act_ModuleName)) {
			System.out.println(
					"Expected : System Should navigates to Contract Mapping module || Actual : system navigates to Contract Mapping module");
			Extent_pass_New(driver,
					"Expected : System Should navigates to Contract Mapping module || Actual : system navigates to Contract Mapping module",
					test, test1);
		} else {
			System.out.println(
					"Expected : System Should navigates to Contract Mapping module || Actual : system not navigated to Contract Mapping module");
			Extent_fail(driver,
					"Expected : System Should navigates to Contract Mapping module || Actual : system not navigated to Contract Mapping module",
					test, test1);
		}
		Step_End(13, "Ensure that system navigates to Contract Mapping.  ", test, test1);

		Step_Start(14, " Select the required port and terminal using add option", test, test1);

		waitForElement(driver, port_Plus_Button_CM);
		click(driver, port_Plus_Button_CM);

		twoColumnMultipleSearchWindow(driver, Port_Select_Header_CM, Portcode_Select_Codition, Port_Codes_select_CM);

		waitForElement(driver, Terminal_Gridcell_ContractMapping);
		List<String> Terminal_List_Select = splitAndExpand(Terminal_Codes_Select_CM, ",");
		for (String TerminalCode : Terminal_List_Select) {
			formatLocatorClick(driver, terminal_Select_Checkbox_CM, TerminalCode);
		}

		waitForElement(driver, terminal_Select_Ok_Button_CM);
		click(driver, terminal_Select_Ok_Button_CM);
		Step_End(14, " Select the required port and terminal using add option", test, test1);

		Step_Start(15, "Select the required services or All services.      ", test, test1);
		if (Select_All_Services.equalsIgnoreCase("Yes")) {
			waitForElement(driver, All_Services_option_CM);
			click(driver, All_Services_option_CM);

		} else {
			waitForElement(driver, Select_Req_Service_condition_CM);
			click(driver, Select_Req_Service_condition_CM);

			waitForElement(driver, Service_Add_button_CM);
			click(driver, Service_Add_button_CM);
			twoColumnSearchWindowMultipleValue(driver, Service_Select_Header, Portcode_Select_Codition,
					Service_Codes_Select);
		}
		Step_End(15, "Select the required services or All services.      ", test, test1);

		Step_Start(16, " Select the required vessel or All vessel. ", test, test1);
		if (Select_All_Vessels.equalsIgnoreCase("Yes")) {
			waitForElement(driver, All_Vessel_Option_CM);
			click(driver, All_Vessel_Option_CM);
		} else {

			waitForElement(driver, Select_Req_Vessel_Option_CM);
			click(driver, Select_Req_Vessel_Option_CM);

			waitForElement(driver, Vessel_Add_button_CM);
			click(driver, Vessel_Add_button_CM);
			twoColumnSearchWindowMultipleValue(driver, Vessel_Select_Header, Portcode_Select_Codition,
					Vessel_Codes_Select);
		}
		Step_End(16, " Select the required vessel or All vessel. ", test, test1);

		Step_Start(17, "Click on save option in the toolbar.  ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Contract_Mapping_Saved_popup);
		String Contract_Mapping_SavePopup_Act = getText(driver, popup_Message);
		if (Contract_Mapping_Saved_popup.equals(Contract_Mapping_SavePopup_Act)) {
			System.out.println("Popup Matched ||  Expected popup : " + Contract_Mapping_Saved_popup
					+ " ||   Actual Popup : " + Contract_Mapping_SavePopup_Act);
			Extent_pass_New(driver, "Popup Matched ||  Expected popup : " + Contract_Mapping_Saved_popup
					+ " ||   Actual Popup : " + Contract_Mapping_SavePopup_Act, test, test1);
		} else {
			System.out.println("Popup Not Matched ||  Expected popup : " + Contract_Mapping_Saved_popup
					+ " ||   Actual Popup : " + Contract_Mapping_SavePopup_Act);
			Extent_fail(driver, "Popup Not Matched ||  Expected popup : " + Contract_Mapping_Saved_popup
					+ " ||   Actual Popup : " + Contract_Mapping_SavePopup_Act, test, test1);
		}
		Step_End(17, "Click on save option in the toolbar.  ", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
