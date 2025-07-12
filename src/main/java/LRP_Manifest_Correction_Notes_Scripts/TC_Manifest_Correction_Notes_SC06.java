package LRP_Manifest_Correction_Notes_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Manifest_Correction_Notes_SC06 extends Keywords {
	String Ports_Module = "";
	String Ports_Search_Type_Select ="";
	String DropdownCondition = "";
	String fromDate="";
	String toDate="";
	String module_MCN_Gate="";
	String Manifest_Module ="";
	String Want_To_Accept_Popup ="";
	String Accepted_Popup ="";
	String Want_To_Apporove_Popup ="";
	String MCN_Approved_Remarks_Input ="";
	String Approved_Popup ="";
	String Mail_SignIn_Page_Url="";
	String Mail_Password ="";
	String Approved_Mail_Subject ="";
	String Mail_Id ="";
	String actual_MCN_Number="";
	String datePicker="";
	public void Manifest_Correction_Notes_SC06(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws InterruptedException{
		String testcase_Name="TC_Manifest_Correction_Notes_SC06";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Manifest_Module = Excel_data.get("Manifest_Module");
		String Corection_Type_Option = Excel_data.get("Corection_Type_Option");
		String Select_Search_Type_MCN = Excel_data.get("Select_Search_Type_MCN");
		DropdownCondition = Excel_data.get("DropdownCondition");
		String BL_Number = Excel_data.get("BL_Number");
		String Pending_Popup = Excel_data.get("Pending_Popup");
		String MCN_Submit_Remarks_Input = Excel_data.get("MCN_Submit_Remarks_Input");
		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		Mail_Id = Excel_data.get("Mail_Id");
		String BL_Module = Excel_data.get("BL_Module");
		String Cancelled_Popup = Excel_data.get("Cancelled_Popup");
		Want_To_Accept_Popup = Excel_data.get("Want_To_Accept_Popup");
		Accepted_Popup = Excel_data.get("Accepted_Popup");
		Want_To_Apporove_Popup = Excel_data.get("Want_To_Apporove_Popup");
		Approved_Popup = Excel_data.get("Approved_Popup");
		MCN_Approved_Remarks_Input = Excel_data.get("MCN_Approved_Remarks_Input");
		Mail_SignIn_Page_Url = Excel_data.get("Mail_SignIn_Page_Url");
		Mail_Password = Excel_data.get("Mail_Password");
		String Submit_Mail_Subject = Excel_data.get("Submit_Mail_Subject");
		Approved_Mail_Subject = Excel_data.get("Approved_Mail_Subject");
		Ports_Search_Type_Select = Excel_data.get("Ports_Search_Type_Select");
		Ports_Module = Excel_data.get("Ports_Module");
		String Red_Color_Code_Value = Excel_data.get("Red_Color_Code_Value");
		module_MCN_Gate=Excel_data.get("Module_MCN_Gate");
		fromDate=Excel_data.get("FromDate");
		toDate=Excel_data.get("ToDate");
		String status_Tab_Table_Headers=Excel_data.get("Status_Tab_Table_Headers");
		String Yellow_ColorCode=Excel_data.get("Yellow_ColorCode");
		datePicker=Excel_data.get("DatePicker");

		String correction_Type = String.format(DropDown_Select, Corection_Type_Option);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_Start(2, "Open the Manifest Correction Notes module", test, test1);
		moduleNavigate(driver, Manifest_Module);
		Step_End(2, "Open the Manifest Correction Notes module", test, test1);
		Step_Start(3, "Choose the correction type as 'Cancel BL by MCN'", test, test1);
		waitForElement(driver, Corection_Type_DropDown);
		click(driver, Corection_Type_DropDown);
		waitForElement(driver, correction_Type);
		click(driver, correction_Type);
		Step_End(3, "Choose the correction type as 'Cancel BL by MCN'", test, test1);
		Step_Start(4, "Click save  edit button system will popup  with Pending/Submit/Cancel message.", test, test1);
		waitForElement(driver, BL_Search_Button_MCN);
		click(driver, BL_Search_Button_MCN);
		globalValueSearchWindow(driver,DropdownCondition,Select_Search_Type_MCN,BL_Number,"","","","");
		
		
		
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}
		waitForElement(driver, SaveButton_ToolBar);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(4, "Click save  edit button system will popup  with Pending/Submit/Cancel message.", test, test1);
		Step_Start(5, "Click pending to proceed.", test, test1);
		waitForElement(driver, Manifest_Pending_Button);
		click(driver, Manifest_Pending_Button);
		Step_Start(5, "Click pending to proceed.", test, test1);
		Step_Start(6, "System will save the MCN number in pending status with yellow color", test, test1);
	waitForPopup(driver, popup_Message, Pending_Popup);
		String actual_Continue_Popup = getText(driver, popup_Message);
		if(actual_Continue_Popup.trim().equals(Pending_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+actual_Continue_Popup+" || Actual Pop-up Message is : "+Pending_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+actual_Continue_Popup+" || Actual Pop-up Message is : "+Pending_Popup, test, test1);
			click(driver,popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+actual_Continue_Popup+" || Actual Pop-up Message is : "+Pending_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+actual_Continue_Popup+" || Actual Pop-up Message is : "+Pending_Popup, test, test1);
		}
		String actual_MCN_Textfield_Color_Code=getTextBackgroundColor(driver, MCN_Number_Textfield_MCN_Module);
		String actual_MCN_Textfield_Color = getColorName(actual_MCN_Textfield_Color_Code);
		if(actual_MCN_Textfield_Color.equalsIgnoreCase(Yellow_ColorCode)) {
			System.out.println("Matched || The background color of MCN Textfield is Yellow || Expected MCN Textfield Color is : "+Yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
			Extent_pass_New(driver, "Matched || The background color of MCN Textfield is Yellow || Expected MCN Textfield Color is : "+Yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
		}else {
			System.out.println("Not Matched || The background color of MCN Textfield is not Yellow || Expected MCN Textfield Color is : "+Yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
			Extent_fail(driver, "Not Matched || The background color of MCN Textfield is not Yellow || Expected MCN Textfield Color is : "+Yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
		}
		Step_End(6, "System will save the MCN number in pending status with yellow color", test, test1);
		Step_Start(7, "Now Click edit button in toolbar & click save button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(7, "Now Click edit button in toolbar & click save button", test, test1);
		Step_Start(8, "System will popup  with pending/Submit/Cancel message", test, test1);
		waitForElement(driver, Manifest_Submit_Button);
		Step_End(8, "System will popup  with pending/Submit/Cancel message", test, test1);
		Step_Start(9, "Now click on submit button then system will open MCN remarks window", test, test1);
		click(driver, Manifest_Submit_Button);
		Step_End(9, "Now click on submit button then system will open MCN remarks window", test, test1);
		Step_Start(10, "Enter the remarks and click ok to submit", test, test1);
		waitForElement(driver, Remarks_Field);
		sendKeys(driver, Remarks_Field, MCN_Submit_Remarks_Input);
		click(driver, Remarks_OK_Button);
		Step_End(10, "Enter the remarks and click ok to submit", test, test1);
		Step_Start(11, "Then system will pop up 'Submitted. MCN is moved to approval process' message in that click ok button", test, test1);
	waitForPopup(driver, popup_Message, Submitted_Popup);
		actual_Continue_Popup = getText(driver, popup_Message);
		if(actual_Continue_Popup.trim().equals(Submitted_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+actual_Continue_Popup+" || Actual Pop-up Message is : "+Submitted_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+actual_Continue_Popup+" || Actual Pop-up Message is : "+Submitted_Popup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+actual_Continue_Popup+" || Actual Pop-up Message is : "+Submitted_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+actual_Continue_Popup+" || Actual Pop-up Message is : "+Submitted_Popup, test, test1);
		}
		Step_End(11, "Then system will pop up 'Submitted. MCN is moved to approval process' message in that click ok button", test, test1);
		Step_Start(12, "Then in mail window enter correct mail id and click on send button.", test, test1);
		waitForElement(driver, Mail_To_Field_MCN);
		clearAndType(driver, Mail_To_Field_MCN, Mail_Id);
		waitForElement(driver, Mail_Send_Button_MCN);
		click(driver, Mail_Send_Button_MCN);
		Step_End(12, "Then in mail window enter correct mail id and click on send button.", test, test1);
		Step_Start(13, "Verify whether mail received or not in mail inbox", test, test1);
		waitForElement(driver, MCN_Number_Textfield_MCN_Module);
		actual_MCN_Number=getAttribute(driver, MCN_Number_Textfield_MCN_Module, "value");
		System.out.println("Generarted MCN Number : "+actual_MCN_Number);
		Extent_pass_New(driver, "Generarted MCN Number : "+actual_MCN_Number, test, test1);
		waitForElement(driver, MCN_Number_Textfield_MCN_Module);
		mailinator_Verification(driver, Mail_SignIn_Page_Url, Mail_Id,Submit_Mail_Subject+actual_MCN_Number);
		
		Step_End(13, "Verify whether mail received or not in mail inbox", test, test1);
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
		int no_Of_Rows = entity.size();
		for(int i=1;i<no_Of_Rows;i++) {
			switch (entity.get(i)) {
			case "ORIGIN PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					String agency = portModule(driver,origin_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					agency = portModule(driver,origin_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					approveMCN(driver);
					break;
				}
				break;
			case "FINAL PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					String agency = portModule(driver,final_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					Step_Start(14, "Now in MCN status tab check which are entity are available, if next entity is Final port.", test, test1);
					agency = portModule(driver,final_Port);
					Step_Start(15, "Then switch profile to POD  and open the MCN gate module", test, test1);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					Step_End(15, "Then switch profile to POD  and open the MCN gate module", test, test1);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					Step_End(19, "System will open MCN module in that click edit button in toolbar", test, test1);
					Step_Start(20, "Now system will enable approve button in status tab", test, test1);
					approveMCN(driver);
					Step_End(14, "Now in MCN status tab check which are entity are available, if next entity is Final port.", test, test1);
					break;
				}
				break;
			case "DISCHARGE PORT AGENCY":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					String agency = portModule(driver,discharge_Port);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
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
					SwitchProfile(driver, DOC_Port);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
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
					String agency = portModule(driver,elseWhere_Agency);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					agency = portModule(driver,elseWhere_Agency);
					SwitchProfile(driver, agency);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					approveMCN(driver);
					break;
				}
				break;
			case "LINE COMMERCIAL":
				switch(status.get(i)) {
				case "<<Awaiting For Accept>>":
					ResetProfile(driver);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					acceptMCN(driver);
					break;
				case "<<Awaiting For Approval>>":
					ResetProfile(driver);
					mcnGateModule(driver,actual_MCN_Number);
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					approveMCN(driver);
					break;
				}
				break;
			}
		}		
		Step_Start(27, "Verify whether the BL cancelled or not", test, test1);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		moduleNavigate(driver, BL_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver,DropdownCondition,Select_Search_Type_MCN,BL_Number,"","","","");
		waitForElement(driver, bl_No_TextField_Btn);
		String actual_Color_Code = getTextBackgroundColor(driver, bl_No_TextField_Btn);
		String actual_Color = getColorName(actual_Color_Code);
		if(Red_Color_Code_Value.equals(actual_Color)) {
			System.out.println("Matched || The BL Field Changed into Red Colour || Expected Colour Code Value is : "+Red_Color_Code_Value+" || Actual Colour Code Value is : "+actual_Color);
			Extent_pass_New(driver,"Matched || The BL Field Changed into Red Colour || Expected Colour Code Value is : "+Red_Color_Code_Value+" || Actual Colour Code Value is : "+actual_Color, test, test1);
		}else {
			System.out.println("Not Matched || The BL Field Not Changed in Red Colour || Expected Colour Code Value is : "+Red_Color_Code_Value+" || Actual Colour Code Value is : "+actual_Color);
			Extent_fail(driver,"Not Matched || The BL Field Not Changed in Red Colour || Expected Colour Code Value is : "+Red_Color_Code_Value+" || Actual Colour Code Value is : "+actual_Color, test, test1);
		}
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
	waitForPopup(driver, popup_Message, Cancelled_Popup);
		String actual_Popup = getText(driver, popup_Message);
		if(actual_Popup.trim().equals(Cancelled_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+Cancelled_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Cancelled_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			click(driver,popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+Cancelled_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Cancelled_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}
		Step_End(27, "Verify whether the BL cancelled or not", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
	public String portModule(WebDriver driver,String Port_Location) {
		moduleNavigate(driver, Ports_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver,DropdownCondition,Ports_Search_Type_Select,Port_Location,"","","","");
		waitForElement(driver, Ports_Agency_text_Field);
		String port_Agency = getAttribute(driver, Ports_Agency_text_Field, "value");
		return port_Agency;
	}
	public void mcnGateModule(WebDriver driver,String actual_MCN_Number) {
		moduleNavigate(driver, module_MCN_Gate);
		Step_Start(16, "Choose MCN created date and click show button", test, test1);
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
		Step_End(16, "Choose MCN created date and click show button", test, test1);
		Step_Start(17, "Then select submit folder record", test, test1);
		waitForElement(driver, submitted_Option);
		click(driver, submitted_Option);
		Step_End(17, "Then select submit folder record", test, test1);
		Step_Start(18, "Now using condition filter , filter our MCN number and select then double click in grid", test, test1);
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
		Step_End(18, "Now using condition filter , filter our MCN number and select then double click in grid", test, test1);
		Step_Start(19, "System will open MCN module in that click edit button in toolbar", test, test1);
		waitForElement(driver, MCN_Module);


	}
	public void acceptMCN(WebDriver driver) throws InterruptedException {
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
			waitForDisplay(driver, Mail_To_Field_MCN);
			if(isdisplayed(driver, Mail_To_Field_MCN)) {
				waitForElement(driver, Mail_To_Field_MCN);
				clearAndType(driver, Mail_To_Field_MCN, Mail_Id);
				waitForElement(driver, Mail_Send_Button_MCN);
				click(driver, Mail_Send_Button_MCN);
			}
		}
	}
	public void approveMCN(WebDriver driver) throws InterruptedException {
		waitForElement(driver, Manifest_Approval_Button);
		if(isClickable(driver, Manifest_Approval_Button)) {
			Step_End(20, "Now system will enable approve button in status tab", test, test1);
			Step_Start(21, "Click Approve button system will pop up 'Do you want to approve this MCN?'", test, test1);
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
			Step_End(21, "Click Approve button system will pop up 'Do you want to approve this MCN?'", test, test1);
			Step_Start(22, "Click Yes to procced", test, test1);
			click(driver, popup_Message_Yes_Button);
			Step_End(22, "Click Yes to procced", test, test1);
			Step_Start(23, "System will popup to enter MCN approval remarks", test, test1);
			waitForElement(driver, Remarks_Field);
			Step_End(23, "System will popup to enter MCN approval remarks", test, test1);
			Step_Start(24, "Enter remarks and click ok", test, test1);
			sendKeys(driver, Remarks_Field, MCN_Approved_Remarks_Input);
			click(driver, Remarks_OK_Button);
			Step_End(24, "Enter remarks and click ok", test, test1);
			Step_Start(25, "Now system will pop 'MCN approved' message click ok", test, test1);
		waitForPopup(driver, popup_Message, Approved_Popup);
			actual_Popup = getText(driver, popup_Message);
			if(actual_Popup.trim().equals(Approved_Popup.trim())) {
				System.out.println("Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
				click(driver,popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup);
				Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Approved_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			}
			Step_End(25, "Now system will pop 'MCN approved' message click ok", test, test1);
			Step_Start(26, "Then in mail window enter correct mail id and click on send button", test, test1);
			waitForDisplay(driver, Mail_To_Field_MCN);
			if(isdisplayed(driver, Mail_To_Field_MCN)) {
				waitForElement(driver, Mail_To_Field_MCN);
				clearAndType(driver, Mail_To_Field_MCN, Mail_Id);
				waitForElement(driver, Mail_Send_Button_MCN);
				click(driver, Mail_Send_Button_MCN);
				waitForElement(driver, MCN_Number_Textfield_MCN_Module);
				mailinator_Verification(driver, Mail_SignIn_Page_Url, Mail_Id,Approved_Mail_Subject+actual_MCN_Number);
				Step_End(26, "Then in mail window enter correct mail id and click on send button", test, test1);
			}
		}
	}
}
