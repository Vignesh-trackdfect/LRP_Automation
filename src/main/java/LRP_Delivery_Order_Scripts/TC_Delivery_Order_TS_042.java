package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

import locators.Delivery_Order_Locators;

public class TC_Delivery_Order_TS_042 extends Keywords {
	public void Delivery_Order_TS_042(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Delivery_Order_TS_042";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String attribute = Excel_data.get("Attribute");
		String description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String bl_Number = Excel_data.get("BL_Number");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String DO_POP_EXP = Excel_data.get("DO_POP_EXP");
		String IGM_EDI_Generation_Module = Excel_data.get("IGM_EDI_Generation_Module");
		String Service_Code = Excel_data.get("Service_Code");
		String Veesels = Excel_data.get("Veesels");
		String Veesels_name = Excel_data.get("Veesels_name");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Port_code = Excel_data.get("Port_code");
		String Terminal = Excel_data.get("Terminal");
		String IGM_POP_EXP = Excel_data.get("IGM_POP_EXP");
		String value_back = Excel_data.get("value_back");
		String globalSearchFilterdelivery = Excel_data.get("globalSearchFilterdelivery");
		String remarks_data = Excel_data.get("remarks_data");
		String igm_Deleted_Popup = Excel_data.get("igm_Deleted_Popup");
		String globalSearchFilterimport = Excel_data.get("globalSearchFilterimport");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String Import_checkbox_status = Excel_data.get("Import_checkbox_status");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String set_As_Default = Excel_data.get("set_As_Default");
		String delete_Option = Excel_data.get("delete_Option");
		String delete_popup_expected = Excel_data.get("delete_popup_expected");
		String deleted_expected = Excel_data.get("deleted_expected");
		String Condition = Excel_data.get("Condition");
		String SenderID_TwoColumn_Header = Excel_data.get("SenderID_TwoColumn_Header");
		String SenderID_Input = Excel_data.get("SenderID_Input");
		String ReceiverID_TwoColumn_Header = Excel_data.get("ReceiverID_TwoColumn_Header");
		String ReceiverID_Input = Excel_data.get("ReceiverID_Input");
		String Basic_Message_TwoColumn_Header = Excel_data.get("Basic_Message_TwoColumn_Header");
		String Basic_Message_Input = Excel_data.get("Basic_Message_Input");
		String Filling_Message_TwoColumn_Header = Excel_data.get("Filling_Message_TwoColumn_Header");
		String Filling_Message_Input = Excel_data.get("Filling_Message_Input");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		// Agency Configuration
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule,
				Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition, AgencyUser, attribute,
				description, value);
		// Import documentation
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(5, "Open import documentation module ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterimport, bl_Number, "", "", "", "");
		waitForElement(driver, importDoc_RemarksTab);
		click(driver, importDoc_RemarksTab);
		waitForElement(driver, Import_receipt_Checkbox);
		String status_check_receipt = getAttribute(driver, Import_receipt_Checkbox, "class");
		System.out.println(status_check_receipt);
		String status_check_import = getAttribute(driver, Import_Invoice_Checkbox, "class");
		System.out.println(status_check_import);
		if (status_check_import.contains(Import_checkbox_status)) {
			System.out.println(
					"Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox was  active");
			Extent_pass_New(driver,
					"Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox was  active",
					test, test1);
		} else {
			System.out.println(
					"Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox was Not active");
			Extent_fail(driver,
					"Expected Result is : Import checkbox Should be active || Actual Result is : Import checkbox was Not active",
					test, test1);
		}
		if (status_check_receipt.contains(Import_checkbox_status)) {
			System.out.println(
					"Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox was active");
			Extent_pass_New(driver,
					"Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox was active",
					test, test1);
		} else {
			System.out.println(
					"Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox was Not active");
			Extent_fail(driver,
					"Expected Result is : Receipt checkbox Should be active || Actual Result is : Receipt checkbox was Not active",
					test, test1);
		}
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		// EDI
		Step_Start(5, "Open IGM EDI generation module", test, test1);
		moduleNavigate(driver, IGM_EDI_Generation_Module);
		Step_End(5, "Open IGM EDI generation module", test, test1);
		Step_Start(6, "Click new and enter the service", test, test1);
		newButton(driver);
		waitForElement(driver, IGM_service_code);
		sendKeys(driver, IGM_service_code, Service_Code);
		waitForElement(driver, IGM_vessel_code);
		sendKeys(driver, IGM_vessel_code, Veesels);
		waitForElement(driver, IGM_vessel_name);
		sendKeys(driver, IGM_vessel_name, Veesels_name);
		waitForElement(driver, IGM_voyage);
		sendKeys(driver, IGM_voyage, Voyage);
		waitForElement(driver, IGM_bound);
		sendKeys(driver, IGM_bound, Bound);
		waitForElement(driver, IGM_port_code);
		sendKeys(driver, IGM_port_code, Port_code);
		waitForElement(driver, IGM_Terminal_code);
		sendKeys(driver, IGM_Terminal_code, Terminal);
		Step_End(6, "Click new and enter the service", test, test1);
		Step_Start(7, "Select the respective schedule", test, test1);
		waitForElement(driver, Select_grid);
		click(driver, Select_grid);
		Step_End(7, "Select the respective schedule", test, test1);
		if (!SenderID_Input.equals("")) {
			waitForElement(driver, SenderID_Search_Button_IGM);
			click(driver, SenderID_Search_Button_IGM);
			twoColumnSearchWindow(driver, SenderID_TwoColumn_Header, Condition, SenderID_Input);
		}
		if (!ReceiverID_Input.equals("")) {
			waitForElement(driver, ReceiverID_Search_Button_IGM);
			click(driver, ReceiverID_Search_Button_IGM);
			twoColumnSearchWindow(driver, ReceiverID_TwoColumn_Header, Condition, ReceiverID_Input);
		}
		if (!Basic_Message_Input.equals("")) {
			waitForElement(driver, BasicMsg_Search_Button_IGM);
			click(driver, BasicMsg_Search_Button_IGM);
			twoColumnSearchWindow(driver, Basic_Message_TwoColumn_Header, Condition, Basic_Message_Input);
		}
		if (!Filling_Message_Input.equals("")) {
			waitForElement(driver, FillingMsg_Search_Button_IGM);
			click(driver, FillingMsg_Search_Button_IGM);
			twoColumnSearchWindow(driver, Filling_Message_TwoColumn_Header, Condition, Filling_Message_Input);
		}
		Step_Start(8, "Click show and select the BL", test, test1);

		waitForElement(driver, Show_Button_IGM);
		click(driver, Show_Button_IGM);
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
		click(driver, popup_Message_Yes_Button);
		}
		List<String> datas = splitAndExpand(bl_Number);
		for (String data : datas) {
			waitForElement(driver, IGM_bl_input);
			sendKeys(driver, IGM_bl_input, data);
			String select_checkbox1 = String.format(Delivery_Order_Locators.IGM_bl_select_box, data);
			waitForElement(driver, select_checkbox1);
			click(driver, select_checkbox1);
		}
		Step_End(8, "Click show and select the BL", test, test1);
		Step_Start(9, "Click save and Make sure IGM FILE NO. generated", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
		click(driver, popup_Message_Yes_Button);
		}
		waitForPopup(driver, popup_Message, IGM_POP_EXP);
		String IGM_POP_ACT = getText(driver, popup_Message);
		if (IGM_POP_EXP.equals(IGM_POP_ACT)) {
			System.out.println("Matched || Expected Pop-up value is : " + IGM_POP_EXP + " || Actual Pop-up value is : "
					+ IGM_POP_ACT);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + IGM_POP_EXP
					+ " || Actual Pop-up value is : " + IGM_POP_ACT, test, test1);
		} else {
			System.out.println("NotMatched || Expected Pop-up value is : " + IGM_POP_EXP
					+ " || Actual Pop-up value is : " + IGM_POP_ACT);
			Extent_fail(driver, "NotMatched || Expected Pop-up value is : " + IGM_POP_EXP
					+ " || Actual Pop-up value is : " + IGM_POP_ACT, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		String IGMfilenum = getAttribute(driver, IGM_file_no, "value");
		System.out.println(IGMfilenum);
		Extent_call(test, test1, "**File number was generated as**" + IGMfilenum);
		Step_End(9, "Click save and Make sure IGM FILE NO. generated", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		// DELIVERY MODULE
		Step_Start(10, "Open Delivery order module ", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(10, "Open Delivery order module ", test, test1);
		Step_Start(11, "Click new button  ", test, test1);
		newButton(driver);
		Step_End(11, "Click new button  ", test, test1);
		Step_Start(12, "Click the \" ADD \" Button  ", test, test1);
		waitForElement(driver, DO_Add_Button);
		click(driver, DO_Add_Button);
		Step_End(12, "Click the \" ADD \" Button  ", test, test1);
		Step_Start(13, "Paste the BL and click search  ", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterdelivery, bl_Number, "", "", "", "");
		Step_End(13, "Paste the BL and click search  ", test, test1);
		Step_Start(14, "Click the SHOW button  ", test, test1);
		waitForElement(driver, DO_show);
		doubleClick(driver, DO_show);
		Step_End(14, "Click the SHOW button  ", test, test1);
		Step_Start(15, "Select the container details in below grid ", test, test1);
		waitForElement(driver, select_All_Checkbox_DO);
		click(driver, select_All_Checkbox_DO);
		Step_End(15, "Select the container details in below grid ", test, test1);
		Step_Start(16, "Click the Save button ", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(16, "Click the Save button ", test, test1);
		Step_Start(17, "Ensure system validated as \" Delivery Order saved\" ", test, test1);
		waitForPopup(driver, Popup_Message, DO_POP_EXP);
		String DO_POP_ACT = getText(driver, Popup_Message);
		if (DO_POP_EXP.equals(DO_POP_ACT)) {
			System.out.println("Matched || Expected Pop-up value is : " + DO_POP_EXP + " || Actual Pop-up value is : "
					+ DO_POP_ACT);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + DO_POP_EXP
					+ " || Actual Pop-up value is : " + DO_POP_ACT, test, test1);
		} else {
			System.out.println("NotMatched || Expected Pop-up value is : " + DO_POP_EXP
					+ " || Actual Pop-up value is : " + DO_POP_ACT);
			Extent_fail(driver, "NotMatched || Expected Pop-up value is : " + DO_POP_EXP
					+ " || Actual Pop-up value is : " + DO_POP_ACT, test, test1);
		}
		Step_End(17, "Ensure system validated as \" Delivery Order saved\" ", test, test1);
		if (delete_Option.equalsIgnoreCase("Yes")) {
			Step_Start(18, "Click the Delete button ", test, test1);
			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			Step_End(18, "Click the Delete button ", test, test1);
			Step_Start(19, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			waitForPopup(driver, popup_Message, delete_popup_expected);
			String delete_Msg_Actual = getText(driver, popup_Message).trim();
			if (delete_Msg_Actual.equals(delete_popup_expected.trim())) {
				System.out.println("MATCHED || EXPECTED DELETE Pop-up value is :" + delete_popup_expected
						+ " ACTUAL DELETE Pop-up value is :" + delete_Msg_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED DELETE Pop-up value is :" + delete_popup_expected
						+ " ACTUAL DELETE Pop-up value is :" + delete_Msg_Actual, test, test1);
			} else {
				System.out.println("NOT MATCHED || EXPECTED DELETE Pop-up value is :" + delete_popup_expected
						+ " ACTUAL DELETE Pop-up value is :" + delete_Msg_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED DELETE Pop-up value is :" + delete_popup_expected
						+ " ACTUAL DELETE Pop-up value is :" + delete_Msg_Actual, test, test1);
			}
			Step_End(19, "System validated as 'Are you sure want to delete the Delivery Order?'", test, test1);
			Step_Start(20, "Click Yes ", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(20, "Click Yes ", test, test1);
			Step_Start(21, "Ensure system validated as Delivery order deleted \" ", test, test1);
			waitForPopup(driver, Popup_Message, deleted_expected);
			String do_Deleted_Actual = getText(driver, Popup_Message);
			if (deleted_expected.equals(do_Deleted_Actual)) {
				System.out.println("MATCHED || EXPECTED Pop-up value is AFTER DELETE : " + deleted_expected
						+ " ACTUAL Pop-up value is AFTER DELETE " + do_Deleted_Actual);
				Extent_pass_New(driver, "MATCHED || EXPECTED Pop-up value is AFTER DELETE : " + deleted_expected
						+ " ACTUAL Pop-up value is AFTER DELETE " + do_Deleted_Actual, test, test1);
			} else {
				System.out.println("NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : " + deleted_expected
						+ " ACTUAL Pop-up value is AFTER DELETE " + do_Deleted_Actual);
				Extent_fail(driver, "NOT MATCHED || EXPECTED Pop-up value is AFTER DELETE : " + deleted_expected
						+ " ACTUAL Pop-up value is AFTER DELETE " + do_Deleted_Actual, test, test1);
			}
			Step_End(21, "Ensure system validated as Delivery order deleted \" ", test, test1);
		}
		scrollTop(driver);
		Step_Start(22, "Open IGM EDI genaration screen", test, test1);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		moduleNavigate(driver, IGM_EDI_Generation_Module);
		Step_End(22, "Open IGM EDI genaration screen", test, test1);
		Step_Start(23, "Click search and paste the Bl no", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterdelivery, bl_Number, "", "", "", "");
		Step_End(23, "Click search and paste the Bl no", test, test1);
		Step_Start(24, "After fetching the select the row ", test, test1);
		List<String> datas1 = splitAndExpand(bl_Number);
		for (String data : datas1) {
			waitForElement(driver, IGM_bl_input);
			sendKeys(driver, IGM_bl_input, data);
			String select_checkbox1 = String.format(Delivery_Order_Locators.IGM_bl_select_box, data);
			waitForElement(driver, select_checkbox1);
			click(driver, select_checkbox1);
		}
		Step_End(24, "After fetching the select the row ", test, test1);
		Step_Start(25, "Enter the remarks and click delete button", test, test1);
		waitForElement(driver, remarks_Txtfld);
		sendKeys(driver, remarks_Txtfld, remarks_data);
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(25, "Enter the remarks and click delete button", test, test1);
		Step_Start(26, "Click yes and make sure IGM deleted", test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		waitForPopup(driver, popup_Message, igm_Deleted_Popup);
		String igm_Deleted_Popup_Actual = getText(driver, popup_Message);
		if (igm_Deleted_Popup_Actual.equals(igm_Deleted_Popup)) {
			System.out.println("MATCHED || EXPECTED IGM DELETED POP-UP -> " + igm_Deleted_Popup
					+ "|| ACTUAL IGM DELETED POP-UP " + igm_Deleted_Popup_Actual);
			Extent_pass_New(driver, "MATCHED || EXPECTED IGM DELETED POP-UP -> " + igm_Deleted_Popup
					+ "|| ACTUAL IGM DELETED POP-UP " + igm_Deleted_Popup_Actual, test, test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("NOT MATCHED || EXPECTED IGM DELETED POP-UP -> " + igm_Deleted_Popup
					+ "|| ACTUAL IGM DELETED POP-UP " + igm_Deleted_Popup_Actual);
			Extent_fail(driver, "NOT MATCHED || EXPECTED IGM DELETED POP-UP -> " + igm_Deleted_Popup
					+ "|| ACTUAL IGM DELETED POP-UP " + igm_Deleted_Popup_Actual, test, test1);
		}
		Step_End(26, "Click yes and make sure IGM deleted", test, test1);
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		// Agency Configuration
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,
				Attribute_Search_Column_Header, Condition, AgencyUser, description, value_back, newlyadded,
				set_As_Default);
		Extent_completed(testcase_Name, test, test1);
	}
}