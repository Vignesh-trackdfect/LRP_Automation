package LRP_EMS_EDI_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_010 extends Keywords {

	public void EMS_EDI_Configuration_TS_010(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_010";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Partner_ID_input = Excel_data.get("Partner_ID_input");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID_Input = Excel_data.get("EDI_ID_Input");
		String Vessel_Mapping_Dropdown = Excel_data.get("Vessel_Mapping_Dropdown");
		String OPS_Auto_Confirm_Dropdown = Excel_data.get("OPS_Auto_Confirm_Dropdown");
		String Port_Code_Header = Excel_data.get("Port_Code_Header");
		String Port_Code_Value = Excel_data.get("Port_Code_Value");
		String Damage_checkbox_perform = Excel_data.get("Damage_checkbox_perform");
		String VGM_Update_Perform = Excel_data.get("VGM_Update_Perform");
		String Damage_input = Excel_data.get("Damage_input");
		String save_pop_expected = Excel_data.get("save_pop_expected");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "go to the GENERAL tab", test, test1);

		waitForElement(driver, EEC_General_Button);
		click(driver, EEC_General_Button);

		Step_End(1, "go to the GENERAL tab", test, test1);

		Step_Start(2,
				"Click the \"Partner Id\" search button and select the Partner ID from the two-column search field.\r\n"
						+ "",
				test, test1);

		waitForElement(driver, EEC_GENERAL_Partner_Id_Search_Button);
		click(driver, EEC_GENERAL_Partner_Id_Search_Button);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID_input);
		Step_End(2,
				"Click the \"Partner Id\" search button and select the Partner ID from the two-column search field.\r\n"
						+ "",
				test, test1);
		Step_Start(3,
				"Click the \"EDI ID\" search button and select the EDI ID from the two-column search field.\r\n" + "",
				test, test1);
		waitForElement(driver, EEC_GENERAL_EDI_Id__Search_Button);
		click(driver, EEC_GENERAL_EDI_Id__Search_Button);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID_Input);
		Step_End(3,
				"Click the \"EDI ID\" search button and select the EDI ID from the two-column search field.\r\n" + "",
				test, test1);
		Step_Start(4,
				"Click the \"Port Code\" search button and select the Port code and teminal/ depot values from the two-column search field(optional).\r\n"
						+ "",
				test, test1);

		if (!Port_Code_Value.equalsIgnoreCase("")) {
			waitForElement(driver, EEC_GENERAL_Port_Code_Search_Button);
			click(driver, EEC_GENERAL_Port_Code_Search_Button);
		}
		twoColumnSearchWindow(driver, Port_Code_Header, Filter_Condition, Port_Code_Value);

		Step_End(4,
				"Click the \"Port Code\" search button and select the Port code and teminal/ depot values from the two-column search field(optional).\r\n"
						+ "",
				test, test1);
		Step_Start(5, "Click the \"Vessel Mapping\" dropdown and select the vessel type(optional).\r\n" + "", test,
				test1);
		waitForElement(driver, EEC_GENERAL_Vessel_Mapping_Input_Field);
		click(driver, EEC_GENERAL_Vessel_Mapping_Input_Field);

		formatLocatorClick(driver, DropDown_Select, Vessel_Mapping_Dropdown);
		Step_End(5, "Click the \"Vessel Mapping\" dropdown and select the vessel type(optional).\r\n" + "", test,
				test1);

		Step_Start(6, "Click the \"OPS Auto Confirm\" dropdown and select yes or no(optional).\r\n" + "", test, test1);
		waitForElement(driver, EEC_GENERAL_OPS_AURO_CONFORM_DD);
		click(driver, EEC_GENERAL_OPS_AURO_CONFORM_DD);

		formatLocatorClick(driver, DropDown_Select, OPS_Auto_Confirm_Dropdown);
		Step_End(6, "Click the \"OPS Auto Confirm\" dropdown and select yes or no(optional).\r\n" + "", test, test1);
		Step_Start(7, "Click the \"Damage\" checkbox to enable it, and enter the damage condition (optional).\r\n" + "",
				test, test1);
		checkBox(driver, EEC_GENERAL_Damage_Check_Box, Damage_checkbox_perform);
		waitForElement(driver, Damage_checkbox_input);
		sendKeys(driver, Damage_checkbox_input, Damage_input);
		Step_End(7, "Click the \"Damage\" checkbox to enable it, and enter the damage condition (optional).\r\n" + "",
				test, test1);

		Step_Start(8, "Click the \"VGM Update\" checkbox to enable it(optional).\r\n" + "", test, test1);
		checkBox(driver, EEC_GENERAL_VGP_Update_Check_Box, VGM_Update_Perform);
		Step_End(8, "Click the \"VGM Update\" checkbox to enable it(optional).\r\n" + "", test, test1);
		waitForElement(driver, BY_EDI_General_Total_redords);
		String total_before = getText(driver, BY_EDI_General_Total_redords);
		System.out.println(total_before);
		Step_Start(9, "Click the save icon in the toolbar.\r\n" + "", test, test1);
		waitForElement(driver, EEC_Save_Button);
		click(driver, EEC_Save_Button);
		Step_End(9, "Click the save icon in the toolbar.\r\n" + "", test, test1);
		Step_Start(10, "The system show the \"EMS EDI Movementcode configuration saved\" once saved, Click \"OK\"",
				test, test1);

		waitForPopup(driver, popup_Message, save_pop_expected);

		String save_pop_Actual = getText(driver, popup_Message);
		System.out.println(save_pop_Actual);
		if (save_pop_expected.equals(save_pop_Actual)) {
			System.out.println("Matched || Expected popup message was : " + save_pop_expected
					+ " || Actual popup message was : " + save_pop_Actual);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + save_pop_expected
					+ " || Actual popup message was : " + save_pop_Actual, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + save_pop_expected
					+ " || Actual popup message was : " + save_pop_Actual);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + save_pop_expected
					+ " || Actual popup message was  : " + save_pop_Actual, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(10, "The system show the \"EMS EDI Movementcode configuration saved\" once saved, Click \"OK\"", test,
				test1);

		waitForElement(driver, EEC_GENERAL_TotalRecords);
		click(driver, EEC_GENERAL_TotalRecords);

		waitForElement(driver, EEC_GENERAL_Condition_Filter);
		click(driver, EEC_GENERAL_Condition_Filter);

		waitForElement(driver, EEC_GENERAL_Condition_Filter_Partner_id);
		sendKeys(driver, EEC_GENERAL_Condition_Filter_Partner_id, Partner_ID_input);

		waitForElement(driver, EEC_GENERAL_Condition_Filter_EDI_ID_Input_Field);
		sendKeys(driver, EEC_GENERAL_Condition_Filter_EDI_ID_Input_Field, EDI_ID_Input);

		waitForDisplay(driver, EEC_GENERAL_Condition_Filter_Port_code);
		if (isdisplayed(driver, EEC_GENERAL_Condition_Filter_Port_code)) {
			Extent_pass_New(driver,
					"Expected result is : After the movement code was saved, Partner ID Should be shown || Actual result is :  After the Movement code was saved, records are aded in grid and the displayed partnerid was"
							+ Partner_ID_input,
					test, test1);
		} else {
			extent_fail(driver,
					"Expected result is : After the movement code was saved, Partner ID Should be shown || Actual result is :  After the Movement code was saved, records are nota aded in grid and the displayed partnerid was"
							+ Partner_ID_input,
					test, test1);
		}

		if (isdisplayed(driver, EDI_Gridvalue)) {
			System.out.println(
					"Expected result is : Movemnet code should be added in the grid || Actual result is : Movement code was added in the Grid");
			Extent_pass_New(driver,
					"Expected result is : Movemnet code should be added in the grid || Actual result is : Movement code was added in the Grid",
					test, test1);
		} else {
			System.out.println(
					"Expected result is : Movemnet code should be added in the grid || Actual result is : Movement code was not added in the Grid");
			Extent_fail(driver,
					"Expected result is : Movemnet code should be added in the grid || Actual result is : Movement code was not added in the Grid",
					test, test1);
		}

		Extent_completed(testcase_Name, test, test1);

	}

}
