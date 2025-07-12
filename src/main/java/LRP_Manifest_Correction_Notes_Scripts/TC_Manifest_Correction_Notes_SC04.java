package LRP_Manifest_Correction_Notes_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Manifest_Correction_Notes_SC04 extends Keywords {

	String Ports_Module = "";
	String Ports_Search_Type_Select ="";
	String dropdownCondition = "";
	String fromDate="";
	String toDate="";
	String module_MCN_Gate="";
	String module_MCN="";
	String Want_To_Accept_Popup ="";
	String Accepted_Popup ="";
	String Want_To_Apporove_Popup ="";
	String MCN_Approval_Remarks_Input ="";
	String Approved_Popup ="";
	String datePicker="";
	
	public void Manifest_Correction_Notes_SC04(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws InterruptedException {

		//		Get Excel_data from test Excel_data
		String testcase_Name="TC_Manifest_Correction_Notes_SC04";


		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		module_MCN=Excel_data.get("Module_MCN");
		String module_ManifestClosure=Excel_data.get("Module_ManifestClosure");
		String correction_Type=Excel_data.get("CorrectionType");
		String globalSearchFilterOption_MCN=Excel_data.get("GlobalSearchFilterOption_MCN");
		dropdownCondition=Excel_data.get("GlobalSearchDropdownCondition");
		String globalSearch_Value=Excel_data.get("GlobalSearch_Value");
		String Charge_Code_Input_For_Add=Excel_data.get("Charge_Code_Input_For_Add");
		String Charge_Code_Input_For_Remove=Excel_data.get("Charge_Code_Input_For_Remove");
		String base_Rate_Unit_Input=Excel_data.get("Base_Rate_Unit_Input");
		String curency_Code_Input=Excel_data.get("Curency_Code_Input");
		String charge_Code_Input_Search_Column_Header=Excel_data.get("Charge_Code_Input_Search_Column_Header");
		String base_Rate_Unit_Input_Search_Column_Header=Excel_data.get("Base_Rate_Unit_Input_Search_Column_Header");
		String curency_Code_Input_Search_Column_Header=Excel_data.get("Curency_Code_Input_Search_Column_Header");
		String equipment_Type_Input=Excel_data.get("Equipment_Type_Input");
		String base_Rate_Input=Excel_data.get("Base_Rate_Input");
		String payment_Mode_Input=Excel_data.get("Payment_Mode_Input");
		Want_To_Accept_Popup=Excel_data.get("Want_To_Accept_Popup");
		Accepted_Popup=Excel_data.get("Accepted_Popup");
		Want_To_Apporove_Popup=Excel_data.get("Want_To_Apporove_Popup");
		Approved_Popup=Excel_data.get("Approved_Popup");
		MCN_Approval_Remarks_Input=Excel_data.get("MCN_Approval_Remarks_Input");
		String payBy=Excel_data.get("PayBy");
		String globalSearchFilterOption_MCN_Closure=Excel_data.get("GlobalSearchFilterOption_MCN_Closure");
		String want_To_Save_Popup=Excel_data.get("Want_To_Save_Popup");
		String pendingSaved_Popup=Excel_data.get("PendingSaved_Popup");
		String submitted_Saved_Popup=Excel_data.get("Submitted_Saved_Popup");
		String mail_Id=Excel_data.get("Mail_Id");
		String mail_Password=Excel_data.get("Mail_Password");
		String mail_Subject=Excel_data.get("Mail_Subject");
		String approved_Mail_Subject=Excel_data.get("Approved_Mail_Subject");
		String mail_SignIn_Page_Url=Excel_data.get("Mail_SignIn_Page_Url");
		Ports_Module=Excel_data.get("Ports_Module");
		Ports_Search_Type_Select=Excel_data.get("Ports_Search_Type_Select");
		module_MCN_Gate=Excel_data.get("Module_MCN_Gate");
		String MCN_Submit_Remarks_Input=Excel_data.get("MCN_Submit_Remarks_Input");
		String import_Documentation_Popup=Excel_data.get("Import_Documentation_Popup");
		String yellow_ColorCode=Excel_data.get("Yellow_ColorCode");
		fromDate=Excel_data.get("FromDate");
		toDate=Excel_data.get("ToDate");
		String want_To_Close_Manifest_Popup=Excel_data.get("Want_To_Close_Manifest_Popup");
		String bl_Closed_Popup=Excel_data.get("BL_Closed_Popup");
		String status_Tab_Table_Headers=Excel_data.get("Status_Tab_Table_Headers");
		String closure_Status_Header=Excel_data.get("Closure_Status_Header");
		String closure_Status=Excel_data.get("Closure_Status");
		datePicker=Excel_data.get("DatePicker");

		navigateUrl(driver,url);
		
		Extent_Start(testcase_Name, test, test1);
//		Login
		LRP_Login(driver, username, password);
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "switch to agency", test, test1);
//		Manifest Closure
			Extent_cal(test, test1, module_ManifestClosure);
			Step_Start(2, "Retrieve the BL using BL No. or Service/Vessel/Voyage/Bound in manifest closure module.", test, test1);
			moduleNavigate(driver, module_ManifestClosure);
			waitForElement(driver, by_BL_RadioButton_MCN);
			click(driver, by_BL_RadioButton_MCN);
			waitForDisplay(driver, bl_SearchButon_MCN);
			click(driver, bl_SearchButon_MCN);
			Step_Start(3, "Select the BL No. in the grid", test, test1);
globalValueSearchWindow(driver,dropdownCondition,globalSearchFilterOption_MCN_Closure,globalSearch_Value,"","","","");
Step_End(3, "Select the BL No. in the grid", test, test1);
Step_End(2, "Retrieve the BL using BL No. or Service/Vessel/Voyage/Bound in manifest closure module.", test, test1);
			Step_Start(4, "Click Manifest button to close  manifest.", test, test1);
			waitForElement(driver, MCN_Closure_Table_Row);
			List<Map<String, String>> mcn_Closure_TableData = getTableData(driver, MCN_Closure_Table_Column, MCN_Closure_Table_Row);
			List<String> closureStatus = getValuesByHeader(mcn_Closure_TableData, closure_Status_Header);
			if(!closureStatus.get(0).equals(closure_Status)) {
			waitForElement(driver, select_Checkbox_MCN);
			checkBox(driver, select_Checkbox_MCN, "Yes");
			waitForDisplay(driver, closeManifest_Button_MCN);
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
			waitForPopup(driver, popup_Message, bl_Closed_Popup);
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
			waitForElement(driver, manifest_Closure_Module);
		click(driver, manifest_Closure_Module);
		click(driver, Module_Close);
		Step_End(4, "Click Manifest button to close  manifest.", test, test1);
//	MCN
		Extent_cal(test, test1, module_MCN);
		Step_Start(5, "Open the Manifest Correction Notes module.", test, test1);
		moduleNavigate(driver, module_MCN);
		Step_End(5, "Open the Manifest Correction Notes module.", test, test1);
		Step_Start(6, "Choose the correction type as Freight Related Correction Note\".", test, test1);
		waitForElement(driver, Corection_Type_DropDown);
		click(driver, Corection_Type_DropDown);
		String select_Correction_Type=String.format(DropDown_Select, correction_Type);
		waitForElement(driver, select_Correction_Type);
		click(driver, select_Correction_Type);
		Step_End(6, "Choose the correction type as Freight Related Correction Note\".", test, test1);
		Step_Start(7, "Retrieve the BL No. using Local search.", test, test1);
		waitForElement(driver, BL_Search_Button_MCN);
		click(driver, BL_Search_Button_MCN);
		globalValueSearchWindow(driver,dropdownCondition,globalSearchFilterOption_MCN,globalSearch_Value,"","","","");
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
		Step_Start(8, "Select any prepaid charge in charges tab & click remove.", test, test1);
		waitForElement(driver, Manifest_Charges_Tab);
		click(driver, Manifest_Charges_Tab);
		String cargeCode_Select =  String.format(chargeCode_Row, Charge_Code_Input_For_Remove);
		waitForElement(driver, cargeCode_Select);
		click(driver, cargeCode_Select); 
		waitForElement(driver, charges_Remove_Button_MCN);
		click(driver, charges_Remove_Button_MCN);
		Step_End(8, "Select the Shipper customer in customer tab & click remove", test, test1);
		Step_Start(9, "Add that charge as collect using Easy search.", test, test1);
		waitForElement(driver, Charge_Code_Search);
		click(driver, Charge_Code_Search);
		twoColumnSearchWindow(driver, charge_Code_Input_Search_Column_Header, dropdownCondition, Charge_Code_Input_For_Add);
		Step_End(9, "Add that charge as collect using Easy search.", test, test1);
		Step_Start(10, "Add the base rate unit using Two column search", test, test1);
		waitForElement(driver, BaseRate_Unit_Search_MCN);
		click(driver, BaseRate_Unit_Search_MCN);
		twoColumnSearchWindow(driver, base_Rate_Unit_Input_Search_Column_Header, dropdownCondition, base_Rate_Unit_Input);
		Step_End(10, "Add the base rate unit using Two column search", test, test1);
		Step_Start(11, "Add the currency using Easy search.", test, test1);

		waitForElement(driver, Currency_Search);
		click(driver, Currency_Search);
		twoColumnSearchWindow(driver, curency_Code_Input_Search_Column_Header, dropdownCondition, curency_Code_Input);
		Step_End(11, "Add the currency using Easy search.", test, test1);
		Step_Start(12, "Select the Eqp type.", test, test1);
		waitForElement(driver, Eqp_Type_Dropdown);
		click(driver, Eqp_Type_Dropdown);
		String Eqp_Type_select = String.format(DropDown_Select, equipment_Type_Input);
		waitForElement(driver, Eqp_Type_select);
		click(driver, Eqp_Type_select);
		Step_End(12, "Select the Eqp type.", test, test1);
		Step_Start(13, "Enter the base rate.", test, test1);
		waitForElement(driver, Base_Rate_Field);
		clear(driver, Base_Rate_Field);
		sendKeys(driver, Base_Rate_Field, base_Rate_Input);
		Step_End(13, "Enter the base rate.", test, test1);
		Step_Start(14, "Select the payment mode & Click add button.", test, test1);
		waitForElement(driver, Payment_Mode_Dropdown);
		click(driver, Payment_Mode_Dropdown);
		String payment_Mode_select = String.format(DropDown_Select,payment_Mode_Input);
		waitForElement(driver, payment_Mode_select);
		click(driver, payment_Mode_select);
		waitForElement(driver, payBy_Dropdown_MCN);
		click(driver, payBy_Dropdown_MCN);
		if(!payBy.equals(" ")) {
		String select_PayBy=String.format(payBy_Dropdown_Option_MCN, payBy);
		waitForDisplay(driver, select_PayBy);
		click(driver, select_PayBy);
		}
		waitForElement(driver, add_Button_ChargesTab_MCN);
		click(driver, add_Button_ChargesTab_MCN);
		Step_End(14, "Select the payment mode & Click add button.", test, test1);
		Step_Start(15, "Click save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(15, "Click save button", test, test1);
		Step_Start(16, "System will popup  with Pending/Submit/Cancel message", test, test1);
		waitForPopup(driver, popup_Message_MCN, want_To_Save_Popup);
		String actual_Popup = getText(driver, popup_Message_MCN);
		if(actual_Popup.trim().equals(want_To_Save_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}
		Step_End(16, "System will popup  with Pending/Submit/Cancel message", test, test1);
		Step_Start(17, "Click pending to proceed", test, test1);
		click(driver, Manifest_Pending_Button);
		Step_End(17, "Click pending to proceed", test, test1);
		Step_Start(18, "System will save the MCN number in pending status with yellow color", test, test1);
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
		Step_End(18, "System will save the MCN number in pending status with yellow color", test, test1);
		Step_Start(19, "Now Click edit button in toolbar & click save button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(19, "Now Click edit button in toolbar & click save button", test, test1);
		Step_Start(20, "System will popup  with pending/Submit/Cancel message", test, test1);
		waitForPopup(driver, popup_Message_MCN, want_To_Save_Popup);
		String actual_Popup1 = getText(driver, popup_Message_MCN);
		if(actual_Popup1.trim().equals(want_To_Save_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup1);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup1, test, test1);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup1);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+want_To_Save_Popup+" || Actual Pop-up Message is : "+actual_Popup1, test, test1);
		}
		Step_End(20, "System will popup  with pending/Submit/Cancel message", test, test1);
		Step_Start(21, "Now click on submit button then system will open mcn remarks window", test, test1);
		click(driver, Manifest_Submit_Button);
		waitForElement(driver, Remarks_Field);
		Step_End(21, "Now click on submit button then system will open mcn remarks window", test, test1);
		Step_Start(22, "Enter the remarks and click ok to submit.", test, test1);
		sendKeys(driver, Remarks_Field, MCN_Submit_Remarks_Input);
		click(driver, Remarks_OK_Button);
		Step_End(22, "Enter the remarks and click ok to submit.", test, test1);
		Step_Start(23, "Then system will pop up \"Submitted. MCN is moved to approval process\" message in that click ok button.", test, test1);
	waitForPopup(driver, popup_Message, submitted_Saved_Popup);
		String actual_Submitted_Popup = getText(driver, popup_Message);
		if(actual_Submitted_Popup.trim().equals(submitted_Saved_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else if(actual_Submitted_Popup.trim().equals(Approved_Popup.trim())){
				System.out.println("Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup, test, test1);
				click(driver, popup_Message_Ok_Button);
		}
		else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+submitted_Saved_Popup+" || Actual Pop-up Message is : "+actual_Submitted_Popup, test, test1);
		}
		Step_End(23, "Then system will pop up \"Submitted. MCN is moved to approval process\" message in that click ok button.", test, test1);
		Step_Start(24, "Then in mail window enter correct mail id and click on send button.", test, test1);
		waitForElement(driver, Mail_To_Field_MCN);
		clearAndType(driver, Mail_To_Field_MCN, mail_Id);
		waitForElement(driver, Mail_Send_Button_MCN);
		click(driver, Mail_Send_Button_MCN);
		Step_End(24, "Then in mail window enter correct mail id and click on send button.", test, test1);
		Step_Start(25, "Then verify whether mail received or not in mail inbox", test, test1);
		waitForElement(driver, MCN_Number_Textfield_MCN_Module);
		if(actual_Submitted_Popup.trim().equals(submitted_Saved_Popup.trim())) {
			mailinator_Verification(driver, mail_SignIn_Page_Url, mail_Id,mail_Subject+actual_MCN_Number);
		}else if(actual_Submitted_Popup.trim().equals(Approved_Popup.trim())){
			mailinator_Verification(driver, mail_SignIn_Page_Url, mail_Id,approved_Mail_Subject+actual_MCN_Number);
		}
		Step_End(25, "Then verify whether mail received or not in mail inbox", test, test1);
		Step_Start(26, "Now in MCN status tab check which are entity are available, if next entity is final port agency.", test, test1);
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
		List<Map<String, String>> MCN_Chareges_Tabledata = getTableData(driver, MCN_Charges_Table_Headers,MCN_Charges_Table_Rows);
		String elseWhere_Agency = getValueByFirstColumnPartialValueAndHeader(MCN_Chareges_Tabledata, "Payment Mode", "PayAt", "Pay Location");
		waitForElement(driver, cancel_Button_MCN);
		click(driver, cancel_Button_MCN);
		click(driver, MCN_Module);
		click(driver, Module_Close);
		Step_End(26, "Now in MCN status tab check which are entity are available, if next entity is final port agency.", test, test1);
		int no_Of_Rows = entity.size();
		for(int i=1;i<no_Of_Rows;i++) {
			switch (entity.get(i)) {
			case "ORIGIN PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					Extent_call(test, test1, "Follow Step 28 to Step 31");
					String agency = portModule(driver,origin_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Extent_call(test, test1, "Follow Step 28 to Step 31");
					agency = portModule(driver,origin_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					approveMCN(driver);
					break;
				}
				break;
			case "FINAL PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					String agency = portModule(driver,final_Port);
					Step_Start(27, "Then switch profile to new pod agency", test, test1);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					Step_End(27, "Then switch profile to new pod agency", test, test1);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Step_Start(27, "Then switch profile to new pod agency", test, test1);
					agency = portModule(driver,final_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					Step_End(27, "Then switch profile to new pod agency", test, test1);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					approveMCN(driver);
					break;
				}
				break;
			case "DISCHARGE PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					Extent_call(test, test1, "Follow Step 28 to Step 31");
					String agency = portModule(driver,discharge_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Extent_call(test, test1, "Follow Step 28 to Step 31");
					agency = portModule(driver,discharge_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					approveMCN(driver);
					break;
				}
				break;
			case "DOCUMENTATION AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					Extent_call(test, test1, "Follow Step 28 to Step 31");
					SwitchProfile(driver, DOC_Port);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Extent_call(test, test1, "Follow Step 28 to Step 31");
					SwitchProfile(driver, DOC_Port);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					approveMCN(driver);
					break;
				}
				break;
			case "ELSE WHERE AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					Extent_call(test, test1, "Follow Step 28 to Step 31");
					String agency = portModule(driver,elseWhere_Agency);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Extent_call(test, test1, "Follow Step 28 to Step 31");
					agency = portModule(driver,elseWhere_Agency);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					approveMCN(driver);
					break;
				}
				break;
			case "LINE COMMERCIAL":
				
				Step_Start(35, "Now in MCN status tab check which are entity are available, if next entity is Line Commercial.", test, test1);

				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					Step_Start(36, "Then switch profile to Line", test, test1);
					ResetProfile(driver);
					Step_End(36, "Then switch profile to Line", test, test1);
					Step_Start(37, "Follow Step 28 to Step 31.", test, test1);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					Step_End(37, "Follow Step 28 to Step 31.", test, test1);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Step_Start(36, "Then switch profile to Line", test, test1);
					ResetProfile(driver);
					Step_End(36, "Then switch profile to Line", test, test1);
					Step_Start(37, "Follow Step 28 to Step 31.", test, test1);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					Step_End(37, "Follow Step 28 to Step 31.", test, test1);
					approveMCN(driver);
					break;
				}
				Step_End(35, "Now in MCN status tab check which are entity are available, if next entity is Line Commercial.", test, test1);
				break;
			}
		}
		Step_Start(44, "Then in mail window enter correct mail id and click on send button", test, test1);
		waitForDisplay(driver, Mail_To_Field_MCN);
		if(isdisplayed(driver, Mail_To_Field_MCN)) {
		waitForElement(driver, Mail_To_Field_MCN);
		clearAndType(driver, Mail_To_Field_MCN, mail_Id);
		waitForElement(driver, Mail_Send_Button_MCN);
		click(driver, Mail_Send_Button_MCN);
		Step_End(44, "Then in mail window enter correct mail id and click on send button", test, test1);
		Step_Start(45, "Verify whether mail received or not in mail inbox", test, test1);
		waitForElement(driver, MCN_Number_Textfield_MCN_Module);
		mailinator_Verification(driver, mail_SignIn_Page_Url, mail_Id,approved_Mail_Subject+actual_MCN_Number);
		Step_End(45, "Verify whether mail received or not in mail inbox", test, test1);
		}
		Extent_completed(testcase_Name, test, test1);
	}
	public String portModule(WebDriver driver,String Port_Location) {
		moduleNavigate(driver, Ports_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver,dropdownCondition,Ports_Search_Type_Select,Port_Location,"","","","");
		waitForElement(driver, Ports_Agency_text_Field);
		String port_Agency = getAttribute(driver, Ports_Agency_text_Field, "value");
		return port_Agency;
	}
//	MCN Gate
	public void mcnGateModule(WebDriver driver,String actual_MCN_Number) {
		Step_Start(28, "Open MCN gate module and Choose MCN created date and click show button.", test, test1);
		moduleNavigate(driver, module_MCN_Gate);
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
		Step_End(28, "Open MCN gate module and Choose MCN created date and click show button.", test, test1);
		Step_Start(29, "Then select submit folder record.", test, test1);
		waitForElement(driver, submitted_Option);
		click(driver, submitted_Option);
		Step_End(29, "Then select submit folder record.", test, test1);
		Step_Start(30, "Now using condition filter , filter our MCN number and select then double click in grid.", test, test1);
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
		Step_End(30, "Now using condition filter , filter our MCN number and select then double click in grid.", test, test1);
		Step_Start(31, "System will open MCN module in that click edit button in toolbar", test, test1);
		waitForElement(driver, MCN_Module);
	
		Step_End(31, "System will open MCN module in that click edit button in toolbar", test, test1);
	}
	public void acceptMCN(WebDriver driver) {
		Step_Start(32, "Now system will enable accept button in status tab.", test, test1);
		waitForElement(driver, Accept_Button_MCN);
		if(isClickable(driver, Accept_Button_MCN)) {
			Step_End(32, "Now system will enable accept button in status tab.", test, test1);
			Step_Start(33, "Click accept button system will pop up \"Do you want to accept this MCN?\"", test, test1);
			waitForElement(driver, Accept_Button_MCN);
			click(driver, Accept_Button_MCN);
		waitForPopup(driver, popup_Message, Want_To_Accept_Popup);
			String actual_Popup = getText(driver, popup_Message);
			if(actual_Popup.trim().equals(Want_To_Accept_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
				Step_End(33, "Click accept button system will pop up \"Do you want to accept this MCN?\"", test, test1);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Want_To_Accept_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}
			Step_Start(34, "Click Yes to procced", test, test1);
			click(driver, popup_Message_Yes_Button);
			Step_End(34, "Click Yes to procced", test, test1);
		waitForPopup(driver, popup_Message, Accepted_Popup);
			actual_Popup = getText(driver, popup_Message);
			if(actual_Popup.trim().equals(Accepted_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
				click(driver,popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Accepted_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}
		}
	}
	public void approveMCN(WebDriver driver) {
		Step_Start(38, "Now system will enable approve button in status tab.", test, test1);
		waitForElement(driver, Manifest_Approval_Button);
		if(isClickable(driver, Manifest_Approval_Button)) {
			Step_End(38, "Now system will enable approve button in status tab.", test, test1);
			Step_Start(39, "Click accept button system will pop up \"Do you want to approve this MCN?", test, test1);
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
			Step_End(39, "Click accept button system will pop up \"Do you want to approve this MCN?", test, test1);
			Step_Start(40, "Click Yes to procced.", test, test1);
			click(driver, popup_Message_Yes_Button);
			Step_End(40, "Click Yes to procced.", test, test1);
			Step_Start(41, "System will popup to enter MCN approval remarks.", test, test1);
			waitForElement(driver, Remarks_Field);
			sendKeys(driver, Remarks_Field, MCN_Approval_Remarks_Input);
			Step_End(41, "System will popup to enter MCN approval remarks.", test, test1);
			Step_Start(42, "Enter remarks and click ok", test, test1);
			click(driver, Remarks_OK_Button);
			Step_End(42, "Enter remarks and click ok", test, test1);
			Step_Start(43, "Now system will pop \"MCN approved\" message click ok.", test, test1);
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
			Step_End(43, "Now system will pop \"MCN approved\" message click ok.", test, test1);
		}
	}
}