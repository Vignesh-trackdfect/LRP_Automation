package LRP_EMS_EDI_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_012 extends Keywords {

	public void EMS_EDI_Configuration_TS_012(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_012";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Partner_ID_input = Excel_data.get("Partner_ID_input");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID_Input = Excel_data.get("EDI_ID_Input");
		String Vessel_Mapping_Dropdown = Excel_data.get("Vessel_Mapping_Dropdown");
		String Port_Code_Header = Excel_data.get("Port_Code_Header");
		String Port_Code_Value = Excel_data.get("Port_Code_Value");
		String Port_Code_Value2 = Excel_data.get("Port_Code_Value2");
		String Popup = Excel_data.get("Popup");

		String Damage_input = Excel_data.get("Damage_input");
		String OPS_Auto_Confirm_Dropdown = Excel_data.get("OPS_Auto_Confirm_Dropdown");
		String Damage_checkbox_perform = Excel_data.get("Damage_checkbox_perform");
		String VGM_Update_Perform = Excel_data.get("VGM_Update_Perform");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "go to the GENERAL tab", test, test1);

		waitForElement(driver, EEC_General_Button);
		click(driver, EEC_General_Button);

		Step_End(1, "go to the GENERAL tab", test, test1);

		Step_Start(2, "By default edit option is enabled =>  Ignored this step As per rajkumar's commands", test,
				test1);
		Step_End(2, "By default edit option is enabled =>  Ignored this step As per rajkumar's commands", test, test1);

		Step_Start(3, "Select the records want to edit in the below AG grid", test, test1);

		waitForElement(driver, EEC_GENERAL_Partner_Id_Search_Button);
		click(driver, EEC_GENERAL_Partner_Id_Search_Button);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID_input);

		waitForElement(driver, EEC_GENERAL_EDI_Id__Search_Button);
		click(driver, EEC_GENERAL_EDI_Id__Search_Button);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID_Input);

		waitForElement(driver, EEC_GENERAL_Port_Code_Search_Button);
		click(driver, EEC_GENERAL_Port_Code_Search_Button);

		twoColumnSearchWindow(driver, Port_Code_Header, Filter_Condition, Port_Code_Value);

		waitForElement(driver, EEC_GENERAL_Vessel_Mapping_Input_Field);
		click(driver, EEC_GENERAL_Vessel_Mapping_Input_Field);

		formatLocatorClick(driver, DropDown_Select, Vessel_Mapping_Dropdown);

		waitForElement(driver, EEC_GENERAL_OPS_AURO_CONFORM_DD);
		click(driver, EEC_GENERAL_OPS_AURO_CONFORM_DD);

		formatLocatorClick(driver, DropDown_Select, OPS_Auto_Confirm_Dropdown);

		checkBox(driver, EEC_GENERAL_Damage_Check_Box, Damage_checkbox_perform);
		waitForElement(driver, Damage_checkbox_input);
		sendKeys(driver, Damage_checkbox_input, Damage_input);

		checkBox(driver, EEC_GENERAL_VGP_Update_Check_Box, VGM_Update_Perform);

		waitForElement(driver, EEC_Save_Button);
		click(driver, EEC_Save_Button);

		waitForPopup(driver, popup_Message, Popup);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(3, "Select the records want to edit in the below AG grid", test, test1);

		Step_Start(4, "Once selected, records will be set in the above fields", test, test1);

		waitForElement(driver, EEC_GENERAL_TotalRecords);
		click(driver, EEC_GENERAL_TotalRecords);

		waitForElement(driver, EEC_GENERAL_Condition_Filter);
		click(driver, EEC_GENERAL_Condition_Filter);

		waitForElement(driver, EEC_GENERAL_Condition_Filter_Partner_id);
		sendKeys(driver, EEC_GENERAL_Condition_Filter_Partner_id, Partner_ID_input);

		waitForElement(driver, EEC_GENERAL_Condition_Filter_EDI_ID_Input_Field);
		sendKeys(driver, EEC_GENERAL_Condition_Filter_EDI_ID_Input_Field, EDI_ID_Input);

		Step_End(4, "Once selected, records will be set in the above fields", test, test1);

		Step_Start(5, "Edit the values to change", test, test1);

		waitForElement(driver, EEC_GENERAL_Condition_Filter_Port_code);
		doubleClick(driver, EEC_GENERAL_Condition_Filter_Port_code);

		waitForElement(driver, EEC_GENERAL_Port_Code_Input_Filed);
		String act_value = getAttribute(driver, EEC_GENERAL_Port_Code_Input_Filed, "value");

		waitForElement(driver, EEC_GENERAL_Port_Code_Search_Button);
		click(driver, EEC_GENERAL_Port_Code_Search_Button);

		twoColumnSearchWindow(driver, Port_Code_Header, Filter_Condition, Port_Code_Value2);

		waitForElement(driver, EEC_GENERAL_Port_Code_Input_Filed);
		String exp_value = getAttribute(driver, EEC_GENERAL_Port_Code_Input_Filed, "value");

		if (!act_value.equals(exp_value)) {
			System.out.println(
					"Matched ||  Expected portcode was : " + act_value + " || Actual  portcode is  : " + exp_value);
			Extent_pass_New(driver,
					"Matched ||  Expected portcode is  : " + act_value + " || Actual portcode is  : " + exp_value, test,
					test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected portcode is : " + act_value + " || Actual portcode is  : " + exp_value);
			Extent_fail(driver,
					"NOt Matched ||  Expected portcode is  : " + act_value + " || Actual portcode is  : " + exp_value,
					test, test1);

		}

		Step_End(5, "Edit the values to change", test, test1);

		Step_Start(6, "Once edited, Click the Save icon", test, test1);

		waitForElement(driver, EEC_Save_Button);
		click(driver, EEC_Save_Button);

		Step_End(6, "Once edited, Click the Save icon", test, test1);

		Step_Start(7, "The system show the EMS EDI Movementcode configuration updated once saved, Click OK", test,
				test1);

		waitForPopup(driver, popup_Message, Popup);
		String act_popup = getText(driver, popup_Message);

		if (Popup.equals(act_popup)) {
			System.out.println(
					"Matched ||  Expected Popup value is : " + Popup + " || Actual Popup value is  : " + act_popup);
			Extent_pass_New(driver,
					"Matched ||  Expected Popup Value is  : " + Popup + " || Actual value Popupis  : " + act_popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected Popup value is : " + Popup + " || Actual Popup value is  : " + act_popup);
			Extent_pass_New(driver,
					"Not Matched ||  Expected Popup Value is  : " + Popup + " || Actual value Popupis  : " + act_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_Start(7, "The system show the EMS EDI Movementcode configuration updated once saved, Click OK", test,
				test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
