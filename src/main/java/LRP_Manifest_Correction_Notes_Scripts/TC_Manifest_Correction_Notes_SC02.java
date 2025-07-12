package LRP_Manifest_Correction_Notes_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Manifest_Correction_Notes_SC02 extends Keywords {

	String Ports_Module = "";
	String Ports_Search_Type_Select ="";
	String dropdownCondition = "";
	String fromDate="";
	String toDate="";
	String module_MCN_Gate="";
	String module_MCN ="";
	String Want_To_Accept_Popup ="";
	String Accepted_Popup ="";
	String Want_To_Apporove_Popup ="";
	String MCN_Approval_Remarks_Input ="";
	String Approved_Popup ="";
	String datePicker="";
	public void Manifest_Correction_Notes_SC02(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws InterruptedException {
		String testcase_Name="TC_Manifest_Correction_Notes_SC02";



		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String module_MCN=Excel_data.get("Module_MCN");
		String module_ManifestClosure=Excel_data.get("Module_ManifestClosure");
		String correction_Type=Excel_data.get("CorrectionType");
		String globalSearchFilterOption_MCN=Excel_data.get("GlobalSearchFilterOption_MCN");
		dropdownCondition=Excel_data.get("GlobalSearchDropdownCondition");
		String globalSearch_Value=Excel_data.get("GlobalSearch_Value");
		String port_Code_POD=Excel_data.get("Port_Code_POD");
		String port_Code_PLD=Excel_data.get("Port_Code_PLD");
		String destination_Haulage=Excel_data.get("Destination_Haulage");
		String want_To_Change_Popup=Excel_data.get("Want_To_Change_Popup");

		String terminal=Excel_data.get("Terminal");
		Want_To_Accept_Popup=Excel_data.get("Want_To_Accept_Popup");
		Accepted_Popup=Excel_data.get("Accepted_Popup");
		Want_To_Apporove_Popup=Excel_data.get("Want_To_Apporove_Popup");
		Approved_Popup=Excel_data.get("Approved_Popup");
		MCN_Approval_Remarks_Input=Excel_data.get("MCN_Approval_Remarks_Input");

		String globalSearchFilterOption_MCN_Closure=Excel_data.get("GlobalSearchFilterOption_MCN_Closure");
		String want_To_Save_Popup=Excel_data.get("Want_To_Save_Popup");
		String pendingSaved_Popup=Excel_data.get("PendingSaved_Popup");
		String submitted_Saved_Popup=Excel_data.get("Submitted_Saved_Popup");
		String mail_Id=Excel_data.get("Mail_Id");
		String mail_Subject=Excel_data.get("Mail_Subject");
		String approved_Mail_Subject=Excel_data.get("Approved_Mail_Subject");

		String mail_SignIn_Page_Url=Excel_data.get("Mail_SignIn_Page_Url");
		Ports_Module=Excel_data.get("Ports_Module");
		Ports_Search_Type_Select=Excel_data.get("Ports_Search_Type_Select");
		module_MCN_Gate=Excel_data.get("Module_MCN_Gate");
		String loadPlanned_Popup=Excel_data.get("LoadPlanned_Popup");

		String MCN_Submit_Remarks_Input=Excel_data.get("MCN_Submit_Remarks_Input");
		String import_Documentation_Popup=Excel_data.get("Import_Documentation_Popup");
		String yellow_ColorCode=Excel_data.get("Yellow_ColorCode");
		fromDate=Excel_data.get("FromDate");
		toDate=Excel_data.get("ToDate");

		String want_To_Close_Manifest_Popup=Excel_data.get("Want_To_Close_Manifest_Popup");
		String bl_Closed_Popup=Excel_data.get("BL_Closed_Popup");
		String status_Tab_Table_Headers=Excel_data.get("Status_Tab_Table_Headers");
		String pod_Details_Popup_Message=Excel_data.get("POD_Details_Popup_Message");
		String ETA_Date=Excel_data.get("ETA_Date");
		datePicker=Excel_data.get("DatePicker");
		String in_Transit_Destination=Excel_data.get("In_Transit_Destination");
		String closure_Status_Header=Excel_data.get("Closure_Status_Header");
		String closure_Status=Excel_data.get("Closure_Status");
		String Port_Code_PLDSearch_Column_Header=Excel_data.get("Port_Code_PLDSearch_Column_Header");
		String Terminal_Search_Column_Header=Excel_data.get("Terminal_Search_Column_Header");
		String In_Transit_Destination_Search_Column_Header=Excel_data.get("In_Transit_Destination_Search_Column_Header");

		navigateUrl(driver,url);

		Extent_Start(testcase_Name, test, test1);
		//		Login
		LRP_Login(driver, username, password);
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "switch to agency", test, test1);
		//	Manifest Closure
		Extent_cal(test, test1, module_ManifestClosure);
		Step_Start(2, "Retrieve the BL using BL No. or Service/Vessel/Voyage/Bound in manifest closure module.", test, test1);
		moduleNavigate(driver, module_ManifestClosure);
		waitForElement(driver, by_BL_RadioButton_MCN);
		click(driver, by_BL_RadioButton_MCN);
		waitForDisplay(driver, bl_SearchButon_MCN);
		click(driver, bl_SearchButon_MCN);
		Step_Start(3, "Select the BL No. in the grid", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_MCN_Closure, globalSearch_Value, "", "", "", "");
		Step_End(3, "Select the BL No. in the grid", test, test1);
		Step_End(2, "Retrieve the BL using BL No. or Service/Vessel/Voyage/Bound in manifest closure module.", test, test1);
		Step_Start(4, "Click Manifest button to close  manifest.", test, test1);
		waitForElement(driver, MCN_Closure_Table_Row);
		List<Map<String, String>> mcn_Closure_TableData = getTableData(driver, MCN_Closure_Table_Column, MCN_Closure_Table_Row);
		List<String> closureStatus = getValuesByHeader(mcn_Closure_TableData, closure_Status_Header);
		if(!closureStatus.get(0).equals(closure_Status)) {
			waitForElement(driver, select_Checkbox_MCN);
			checkBox(driver, select_Checkbox_MCN, "Yes");
			waitForElement(driver, closeManifest_Button_MCN);
			click(driver, closeManifest_Button_MCN);
			waitForPopup(driver, popup_Message, want_To_Close_Manifest_Popup);
			String actual_wantToClose_Popup = getText(driver, popup_Message);
			if(actual_wantToClose_Popup.trim().equals(want_To_Close_Manifest_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+want_To_Close_Manifest_Popup+" || Actual Pop-up Message is : "+actual_wantToClose_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+want_To_Close_Manifest_Popup+" || Actual Pop-up Message is : "+actual_wantToClose_Popup, test, test1);
				click(driver, popup_Message_Yes_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+want_To_Close_Manifest_Popup+" || Actual Pop-up Message is : "+actual_wantToClose_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+want_To_Close_Manifest_Popup+" || Actual Pop-up Message is : "+actual_wantToClose_Popup, test, test1);
			}
			waitForPopup(driver, popup_Message,bl_Closed_Popup);
			String actual_Closed_Popup = getText(driver, popup_Message);
			if(actual_Closed_Popup.trim().equals(bl_Closed_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+bl_Closed_Popup+" || Actual Pop-up Message is : "+actual_Closed_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+bl_Closed_Popup+" || Actual Pop-up Message is : "+actual_Closed_Popup, test, test1);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+bl_Closed_Popup+" || Actual Pop-up Message is : "+actual_Closed_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+bl_Closed_Popup+" || Actual Pop-up Message is : "+actual_Closed_Popup, test, test1);
			}
		}
		click(driver, manifest_Closure_Module);
		click(driver, Close_Current_tab);
		Step_End(4, "Click Manifest button to close  manifest.", test, test1);
		Step_Start(5, "Open the Manifest Correction Notes module.", test, test1);
		//	MCN
		Extent_cal(test, test1, module_MCN);
		moduleNavigate(driver, module_MCN);
		Step_End(5, "Open the Manifest Correction Notes module.", test, test1);
		Step_Start(6, "Choose the correction type as \"\"Change of Destination\"\"", test, test1);
		waitForElement(driver, Corection_Type_DropDown);
		click(driver, Corection_Type_DropDown);
		String select_Correction_Type=String.format(DropDown_Select, correction_Type);
		waitForElement(driver, select_Correction_Type);
		click(driver, select_Correction_Type);
		Step_End(6, "Choose the correction type as \"\"Change of Destination\"\"", test, test1);
		Step_Start(7, "Retrieve the BL No. using Local search.", test, test1);
		waitForElement(driver, BL_Search_Button_MCN);
		click(driver, BL_Search_Button_MCN);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_MCN, globalSearch_Value, "", "", "", "");
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			String actual_Continue_Popup = getText(driver, popup_Message);
			if(actual_Continue_Popup.trim().equals(import_Documentation_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+import_Documentation_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+import_Documentation_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup, test, test1);
				click(driver, popup_Message_Yes_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+import_Documentation_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+import_Documentation_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup, test, test1);
			}
		}
		Step_End(7, "Retrieve the BL No. using Local search.", test, test1);
		Step_Start(8, "Click the edit button in Terminal ETA.", test, test1);
		waitForElement(driver, terminal_ETA_Edit_Button_MCN);
		click(driver, terminal_ETA_Edit_Button_MCN);
		Step_End(8, "Click the edit button in Terminal ETA.", test, test1);
		Step_Start(9, "System will popup to enter new POD details", test, test1);
		
		waitForPopup(driver, pod_Details_Popup_MCN,pod_Details_Popup_Message);
		String actual_POD_Popup = getText(driver, pod_Details_Popup_MCN);
		if(actual_POD_Popup.trim().equals(pod_Details_Popup_Message.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+pod_Details_Popup_Message+" || Actual Pop-up Message is : "+actual_POD_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+pod_Details_Popup_Message+" || Actual Pop-up Message is : "+actual_POD_Popup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+pod_Details_Popup_Message+" || Actual Pop-up Message is : "+actual_POD_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+pod_Details_Popup_Message+" || Actual Pop-up Message is : "+actual_POD_Popup, test, test1);
		}
		Step_End(9, "System will popup to enter new POD details", test, test1);
		Step_Start(10, "By using easy search change the POD", test, test1);
		waitForElement(driver, pod_Searchfield_MCN);
		click(driver, pod_Searchfield_MCN);
		clear(driver, pod_Searchfield_MCN);
		waitForElement(driver, pod_Searchfield_MCN);
		sendKeys(driver, pod_Searchfield_MCN, port_Code_POD);
		String select_POD=String.format(autoComplete_Value, port_Code_POD);
		waitForElement(driver, select_POD);
		click(driver, select_POD);
		Step_End(10, "By using easy search change the POD", test, test1);
		Step_Start(11, "By using two col search change the POD terminal.", test, test1);
		waitForElement(driver, terminal_SearchButton_MCN);
		click(driver, terminal_SearchButton_MCN);
		twoColumnSearchWindow(driver, Terminal_Search_Column_Header, dropdownCondition, terminal);
		if(!ETA_Date.equals("")) {
			waitForElement(driver, pod_ETA_Date_MCN);
			if (datePicker.equalsIgnoreCase("Yes") && isDisplayed(driver, Calender)) {
				selectDatePickerWithTime(driver, pod_ETA_Date_MCN, ETA_Date);
			}else{
				clear(driver, pod_ETA_Date_MCN);
				sendKeys(driver, pod_ETA_Date_MCN, ETA_Date);
				waitForElement(driver, calenderclosebutton);
				click(driver, calenderclosebutton);
			}
		}
		Step_End(11, "By using two col search change the POD terminal.", test, test1);
		Step_Start(12, "By using  two col search  change the PLD which should be different with POD.", test, test1);
		waitForElement(driver, pld_SearchButton_MCN);
		click(driver, pld_SearchButton_MCN);
		twoColumnSearchWindow(driver, Port_Code_PLDSearch_Column_Header, dropdownCondition, port_Code_PLD);
		Step_End(12, "By using  two col search  change the PLD which should be different with POD.", test, test1);
		Step_Start(13, "Select Carrier/Merchant as Destination Haulage & click ok to proceed further", test, test1);
		waitForDisplay(driver, in_Transit_SearchButton_MCN);
		if(!in_Transit_Destination.equals("")) {
			click(driver, in_Transit_SearchButton_MCN);
			twoColumnSearchWindow(driver, In_Transit_Destination_Search_Column_Header, dropdownCondition, in_Transit_Destination);
		}
		String select_Destination_Haulage=String.format(destination_Haulage_Button, destination_Haulage);
		waitForElement(driver, select_Destination_Haulage);
		if(isElementAccessible(driver, select_Destination_Haulage)) {
			click(driver, select_Destination_Haulage);
		}
		waitForElement(driver, pod_Details_Ok_Button);
		click(driver, pod_Details_Ok_Button);
		Step_End(13, "Select Carrier/Merchant as Destination Haulage & click ok to proceed further", test, test1);
		Step_Start(14, "click save button ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(14, "click save button ", test, test1);
		Step_Start(15, "Then click \"\"No\"\" option system will popup  with Pending/Submit/Cancel message.", test, test1);
		waitForDisplay(driver, popupMessage_MCN);
		if(isdisplayed(driver, popupMessage_MCN)) {
			click(driver, popupMessage_MCN_Yes_Button);
		}
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			String actual_wantToChange_Popup = getText(driver, popup_Message);
			if(actual_wantToChange_Popup.trim().equals(want_To_Change_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+want_To_Change_Popup+" || Actual Pop-up Message is : "+actual_wantToChange_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+want_To_Change_Popup+" || Actual Pop-up Message is : "+actual_wantToChange_Popup, test, test1);
				click(driver, popup_Message_No_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+want_To_Change_Popup+" || Actual Pop-up Message is : "+actual_wantToChange_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+want_To_Change_Popup+" || Actual Pop-up Message is : "+actual_wantToChange_Popup, test, test1);
			}
		}
		waitForPopup(driver, popup_Message_MCN, want_To_Save_Popup);
		String actual_Popup = getText(driver, popup_Message_MCN);
		if(actual_Popup.trim().equals(want_To_Save_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}
		Step_End(15, "Then click \"\"No\"\" option system will popup  with Pending/Submit/Cancel message.", test, test1);
		Step_Start(16, "Click pending to proceed", test, test1);
		waitForElement(driver, Manifest_Pending_Button);
		click(driver, Manifest_Pending_Button);
		Step_End(16, "Click pending to proceed", test, test1);
		Step_Start(17, "System will save the MCN number in pending status with yellow color", test, test1);
		waitForPopup(driver, popup_Message, pendingSaved_Popup);
		String actual_Pending_Popup = getText(driver, popup_Message);
		if(actual_Pending_Popup.trim().contains(pendingSaved_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+pendingSaved_Popup+" || Actual Pop-up Message is : "+actual_Pending_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+pendingSaved_Popup+" || Actual Pop-up Message is : "+actual_Pending_Popup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+pendingSaved_Popup+" || Actual Pop-up Message is : "+actual_Pending_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+pendingSaved_Popup+" || Actual Pop-up Message is : "+actual_Pending_Popup, test, test1);
		}
		waitForElement(driver, MCN_Number_Textfield_MCN_Module);
		String actual_MCN_Number=getAttribute(driver, MCN_Number_Textfield_MCN_Module, "value");
		System.out.println("Generarted MCN Number : "+actual_MCN_Number);
		Extent_pass_New(driver, "Generarted MCN Number : "+actual_MCN_Number, test, test1);
		String actual_MCN_Textfield_Color_Code=getTextBackgroundColor(driver, MCN_Number_Textfield_MCN_Module);
		String actual_MCN_Textfield_Color = getColorName(actual_MCN_Textfield_Color_Code);
		if(actual_MCN_Textfield_Color.equalsIgnoreCase(yellow_ColorCode)) {
			System.out.println("Matched || The background color of MCN Textfield is Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
			Extent_pass_New(driver, "Matched || The background color of MCN Textfield is Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
		}else {
			System.out.println("Not Matched || The background color of MCN Textfield is not Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
			Extent_fail(driver, "Not Matched || The background color of MCN Textfield is not Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
		}
		Step_End(17, "System will save the MCN number in pending status with yellow color", test, test1);
		Step_Start(18, "Now Click edit button in toolbar & click save button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(18, "Now Click edit button in toolbar & click save button", test, test1);
		Step_Start(19, "now system validated with \"these containers are Load planned. If MCN is applied, system update the POD and PLD In Load Planning.Do you want to Proceed?\" click yes and proceed", test, test1);
		waitForDisplay(driver, popupMessage_MCN);
		if(isdisplayed(driver, popupMessage_MCN)) {
			String actual_Popup1 = getText(driver, popupMessage_MCN);
			if(actual_Popup1.contains(loadPlanned_Popup)) {
				System.out.println("Matched || Expected Pop-up Message is : "+loadPlanned_Popup+" || Actual Pop-up Message is : "+actual_Popup1);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+loadPlanned_Popup+" || Actual Pop-up Message is : "+actual_Popup1, test, test1);
				click(driver, popupMessage_MCN_Yes_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+loadPlanned_Popup+" || Actual Pop-up Message is : "+actual_Popup1);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+loadPlanned_Popup+" || Actual Pop-up Message is : "+actual_Popup1, test, test1);
			}
		}
		Step_End(19, "now system validated with \"these containers are Load planned. If MCN is applied, system update the POD and PLD In Load Planning.Do you want to Proceed?\" click yes and proceed", test, test1);
		Step_Start(20, "Then system validated with \"\" Destination has been changed. Do you want to change the Consignee in Customer\"\".", test, test1);
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			String actual_wantToChange_Popup = getText(driver, popup_Message);
			if(actual_wantToChange_Popup.trim().equals(want_To_Change_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+want_To_Change_Popup+" || Actual Pop-up Message is : "+actual_wantToChange_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+want_To_Change_Popup+" || Actual Pop-up Message is : "+actual_wantToChange_Popup, test, test1);
				click(driver, popup_Message_No_Button);
				
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+want_To_Change_Popup+" || Actual Pop-up Message is : "+actual_wantToChange_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+want_To_Change_Popup+" || Actual Pop-up Message is : "+actual_wantToChange_Popup, test, test1);
			}
		}
		Step_End(20, "Then system validated with \"\" Destination has been changed. Do you want to change the Consignee in Customer\"\".", test, test1);
		Step_Start(21, "Then click \"\"No\"\" option system will popup  with pending/Submit/Cancel message.", test, test1);
		waitForPopup(driver, popup_Message_MCN, want_To_Save_Popup);
		actual_Popup = getText(driver, popup_Message_MCN);
		if(actual_Popup.trim().equals(want_To_Save_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}
		Step_End(21, "Then click \"\"No\"\" option system will popup  with pending/Submit/Cancel message.", test, test1);
		Step_Start(22, "now click on submit button then system will open mcn remarks window.", test, test1);
		waitForElement(driver, Manifest_Submit_Button);
		click(driver, Manifest_Submit_Button);
		Step_End(22, "now click on submit button then system will open mcn remarks window.", test, test1);
		Step_Start(23, "Enter remarks to submit.", test, test1);
		waitForElement(driver, Remarks_Field);
		sendKeys(driver, Remarks_Field, MCN_Submit_Remarks_Input);
		click(driver, Remarks_OK_Button);
		Step_End(23, "Enter remarks to submit.", test, test1);
		Step_Start(24, "Then system will pop up \"Submitted. MCN is moved to approval process\" message in that click ok button.", test, test1);
		waitForPopup(driver, popup_Message, submitted_Saved_Popup);
		String actual_Submitted_Popup = getText(driver, popup_Message);
		if(actual_Submitted_Popup.trim().equals(submitted_Saved_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup, test, test1);
		}
		Step_End(24, "Then system will pop up \"Submitted. MCN is moved to approval process\" message in that click ok button.", test, test1);
		Step_Start(25, "then in mail window enter correct mail id and click on send button.", test, test1);

		waitForElement(driver, Mail_To_Field_MCN);
		clearAndType(driver, Mail_To_Field_MCN, mail_Id);
		waitForElement(driver, Mail_Send_Button_MCN);
		click(driver, Mail_Send_Button_MCN);

		Step_End(25, "then in mail window enter correct mail id and click on send button.", test, test1);
		Step_Start(26, "then verify whether mail received or not in mail inbox", test, test1);

		waitForElement(driver, MCN_Number_Textfield_MCN_Module);
//		mail_Verification(driver, mail_SignIn_Page_Url, mail_Id, mail_Password,mail_Subject+actual_MCN_Number);
		mailinator_Verification(driver, mail_SignIn_Page_Url, mail_Id, mail_Subject+actual_MCN_Number);
		
		Step_End(26, "then verify whether mail received or not in mail inbox", test, test1);
		Step_Start(27, "Now in MCN status tab check which are entity are available, if next entity is final port agency.", test, test1);

		waitForElement(driver, status_Tab_MCN);
		click(driver, status_Tab_MCN);

		waitForElement(driver, status_Tab_TableRow_MCN);
		List<Map<String, String>> statusTable_Data = getTableData(driver, status_Tab_TableColumn_MCN, status_Tab_TableRow_MCN);
		List<String> statusTableHeader = splitAndExpand(status_Tab_Table_Headers);
		List<String> entity = getValuesByHeader(statusTable_Data, statusTableHeader.get(0));
		List<String> status = getValuesByHeader(statusTable_Data, statusTableHeader.get(1));
		waitForElement(driver, Master_Tab_MCN);
		click(driver, Master_Tab_MCN);
		waitForElement(driver, POL_Value);
		String origin_Port = getText(driver, POL_Value);
		String final_Port = getText(driver, PLD_Location_MCN);
		String discharge_Port=getText(driver, pod_Port_MCN);
		String DOC_Port = getAttribute(driver, Doc_Agency, "value");
		waitForElement(driver, Manifest_Charges_Tab);
		click(driver, Manifest_Charges_Tab);
		waitForElement(driver, MCN_Charges_Table_Headers);
		List<Map<String, String>> MCN_Chareges_Tabledata = getTableData(driver, MCN_Charges_Table_Headers,
				MCN_Charges_Table_Rows);
		String elseWhere_Agency = getValueByFirstColumnPartialValueAndHeader(MCN_Chareges_Tabledata, "Payment Mode", "PayAt", "Pay Location");
		waitForElement(driver, cancel_Button_MCN);
		click(driver, cancel_Button_MCN);
		click(driver, MCN_Module);
		click(driver, Module_Close);
		Step_End(27, "Now in MCN status tab check which are entity are available, if next entity is final port agency.", test, test1);
		int no_Of_Rows = entity.size();
		for(int i=1;i<no_Of_Rows;i++) {
			switch (entity.get(i)) {
			case "ORIGIN PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					Extent_call(test, test1, "Follow Step 29 to Step 32");
					String agency = portModule(driver,origin_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Extent_call(test, test1, "Follow Step 29 to Step 32");
					agency = portModule(driver,origin_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					Extent_call(test, test1, "Follow Step 33 to Step 37");
					approveMCN(driver);
					break;
				}
				break;
			case "FINAL PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					String agency = portModule(driver,final_Port);
					Step_Start(28, "Then switch profile to new pod agency", test, test1);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					Step_End(28, "Then switch profile to new pod agency", test, test1);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Step_Start(28, "Then switch profile to new pod agency", test, test1);
					agency = portModule(driver,final_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					Step_End(28, "Then switch profile to new pod agency", test, test1);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					Extent_call(test, test1, "Follow Step 33 to Step 37");
					approveMCN(driver);
					break;
				}
				break;

			case "DISCHARGE PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					Extent_call(test, test1, "Follow Step 29 to Step 32");
					String agency = portModule(driver,discharge_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Extent_call(test, test1, "Follow Step 29 to Step 32");
					agency = portModule(driver,discharge_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					Extent_call(test, test1, "Follow Step 33 to Step 37");
					approveMCN(driver);
					break;
				}
				break;
			case "DOCUMENTATION AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					Extent_call(test, test1, "Follow Step 29 to Step 32");
					SwitchProfile(driver, DOC_Port);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Extent_call(test, test1, "Follow Step 29 to Step 32");
					SwitchProfile(driver, DOC_Port);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					Extent_call(test, test1, "Follow Step 33 to Step 37");
					approveMCN(driver);
					break;
				}
				break;
			case "ELSE WHERE AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					Extent_call(test, test1, "Follow Step 29 to Step 32");
					String agency = portModule(driver,elseWhere_Agency);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Extent_call(test, test1, "Follow Step 29 to Step 32");
					agency = portModule(driver,elseWhere_Agency);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					Extent_call(test, test1, "Follow Step 33 to Step 37");
					approveMCN(driver);
					break;
				}
				break;
			case "LINE COMMERCIAL":
				Extent_call(test, test1, "Follow Step 29 to Step 32");
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					ResetProfile(driver);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Extent_call(test, test1, "Follow Step 29 to Step 32");
					ResetProfile(driver);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					Extent_call(test, test1, "Follow Step 33 to Step 37");

					approveMCN(driver);
					break;
				}
				break;
			}
		}
		Step_Start(38, "then in mail window enter correct mail id and click on send button.", test, test1);
		waitForDisplay(driver, Mail_To_Field_MCN);
		if(isdisplayed(driver, Mail_To_Field_MCN)) {
			waitForElement(driver, Mail_To_Field_MCN);
			clearAndType(driver, Mail_To_Field_MCN, mail_Id);
			waitForElement(driver, Mail_Send_Button_MCN);
			click(driver, Mail_Send_Button_MCN);
			Step_End(38, "then in mail window enter correct mail id and click on send button.", test, test1);
			Step_Start(39, "then verify whether mail received or not in mail inbox", test, test1);
			waitForElement(driver, MCN_Number_Textfield_MCN_Module);
//			mail_Verification(driver, mail_SignIn_Page_Url, mail_Id, mail_Password,approved_Mail_Subject+actual_MCN_Number);
			mailinator_Verification(driver, mail_SignIn_Page_Url, mail_Id, approved_Mail_Subject+actual_MCN_Number);
			Step_End(39, "then verify whether mail received or not in mail inbox", test, test1);
		}
		Extent_completed(testcase_Name, test, test1);
	}
	public String portModule(WebDriver driver,String Port_Location) {
		Extent_cal(test, test1, Ports_Module);
		moduleNavigate(driver, Ports_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver,dropdownCondition,Ports_Search_Type_Select,Port_Location, "", "", "", "");
		waitForElement(driver, Ports_Agency_text_Field);
		String port_Agency = getAttribute(driver, Ports_Agency_text_Field, "value");
		return port_Agency;
	}
	//	MCN Gate
	public void mcnGateModule(WebDriver driver,String actual_MCN_Number) {
		Step_Start(29, " Open MCN gate module and Choose MCN created date and click show button", test, test1);
		moduleNavigate(driver, module_MCN_Gate);
		Extent_cal(test, test1, module_MCN_Gate);
		waitForElement(driver, fromDate_MCNGate);
		if(datePicker.equalsIgnoreCase("yes")) {
			selectDatePicker(driver, fromDate_MCNGate, fromDate);
		}else {
			waitForElement(driver, fromDate_MCNGate);
			clearAndType(driver, fromDate_MCNGate, fromDate);
		}
		waitForElement(driver, toDate_MCNGate);
		if(datePicker.equalsIgnoreCase("yes")) {
			selectDatePicker(driver, toDate_MCNGate, toDate);
		}else {
			waitForElement(driver, toDate_MCNGate);
			clearAndType(driver, toDate_MCNGate, toDate);
		}
		waitForElement(driver, show_Button_MCNGate);
		click(driver, show_Button_MCNGate);
		Step_End(29, " Open MCN gate module and Choose MCN created date and click show button", test, test1);
		Step_Start(30, "Then select submit folder record.", test, test1);
		waitForElement(driver, submitted_Option);
		click(driver, submitted_Option);
		Step_End(30, "Then select submit folder record.", test, test1);
		Step_Start(31, "Now using condition filter , filter our MCN number and select then double click in grid.", test, test1);
		waitForElement(driver, filter_Options_Button_MCN_Gate);
		click(driver, filter_Options_Button_MCN_Gate);
		waitForElement(driver, condition_Filter_MCN_Gate);
		click(driver, condition_Filter_MCN_Gate);
		waitForElement(driver, MCN_Number_Filter);
		click(driver, MCN_Number_Filter);
		sendKeys(driver, MCN_Number_Filter, actual_MCN_Number);
		waitForElement(driver, select_MCN_Number_Row);
		click(driver, select_MCN_Number_Row);
		waitForElement(driver, select_MCN_Number_Row);
		doubleClick(driver, select_MCN_Number_Row);
		Step_End(31, "Now using condition filter , filter our MCN number and select then double click in grid.", test, test1);
		Step_Start(32, "System will open MCN module in that click edit button in toolbar", test, test1);
		waitForElement(driver, MCN_Module);
		if (isdisplayed(driver, MCN_Module)) {
			Extent_pass_New(driver, module_MCN + " module is opened", test, test1);
			System.out.println(module_MCN + " module is opened");
		} else {
			System.out.println(module_MCN + " module is not opened");
			Extent_fail(driver, module_MCN + " module is not opened", test, test1);
		}
		Step_End(32, "System will open MCN module in that click edit button in toolbar", test, test1);
	}

	//	MCN Accept

	public void acceptMCN(WebDriver driver) {
		waitForElement(driver, Accept_Button_MCN);
		if(isClickable(driver, Accept_Button_MCN)) {
			waitForElement(driver, Accept_Button_MCN);
			click(driver, Accept_Button_MCN);
			waitForPopup(driver, popup_Message, Want_To_Accept_Popup);
			String actual_Popup = getText(driver, popup_Message);
			if(actual_Popup.trim().equals(Want_To_Accept_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);

			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}
			click(driver, popup_Message_Yes_Button);

			waitForPopup(driver, popup_Message, Accepted_Popup);
			actual_Popup = getText(driver, popup_Message);
			if(actual_Popup.trim().equals(Accepted_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}
		}
	}

	//	MCN Approve
	public void approveMCN(WebDriver driver) {
		Step_Start(33, "Now system will enable approve button in status tab.", test, test1);
		waitForElement(driver, Manifest_Approval_Button);
		if(isClickable(driver, Manifest_Approval_Button)) {
			Step_End(33, "Now system will enable approve button in status tab.", test, test1);
			Step_Start(34, "Click accept button system will pop up \"Do you want to approve this MCN?", test, test1);
			click(driver, Manifest_Approval_Button);
			waitForPopup(driver, popup_Message, Want_To_Apporove_Popup);
			String actual_Popup = getText(driver, popup_Message);
			if(actual_Popup.trim().equals(Want_To_Apporove_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+Want_To_Apporove_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Want_To_Apporove_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+Want_To_Apporove_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Want_To_Apporove_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}
			Step_End(34, "Click accept button system will pop up \"Do you want to approve this MCN?", test, test1);
			Step_Start(35, "click Yes, system will popup to enter MCN approval remarks.", test, test1);
			click(driver, popup_Message_Yes_Button);
			waitForElement(driver, Remarks_Field);
			sendKeys(driver, Remarks_Field, MCN_Approval_Remarks_Input);
			Step_End(35, "click Yes, system will popup to enter MCN approval remarks.", test, test1);
			Step_Start(36, "Enter remarks and click ok", test, test1);
			click(driver, Remarks_OK_Button);
			Step_End(36, "Enter remarks and click ok", test, test1);
			Step_Start(37, "Now system will pop \"MCN approved\" message click ok.", test, test1);
			waitForPopup(driver, popup_Message, Approved_Popup);
			actual_Popup = getText(driver, popup_Message);
			if(actual_Popup.trim().equals(Approved_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}
			Step_End(37, "Now system will pop \"MCN approved\" message click ok.", test, test1);
		}
	}
}
