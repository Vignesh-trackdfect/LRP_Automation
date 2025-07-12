package LRP_Manifest_Correction_Notes_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Manifest_Correction_Notes_SC07 extends Keywords {
	public void Manifest_Correction_Notes_SC07(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws InterruptedException {
		String testcase_Name="TC_Manifest_Correction_Notes_SC07";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Manifest_Module = Excel_data.get("Manifest_Module");
		String Corection_Type_Option = Excel_data.get("Corection_Type_Option");
		String Select_Search_Type_MCN = Excel_data.get("Select_Search_Type_MCN");
		String DropdownCondition = Excel_data.get("DropdownCondition");
		String BL_Number = Excel_data.get("BL_Number");
		String Continue_Popup = Excel_data.get("Continue_Popup");
		String Clause_No = Excel_data.get("Clause_No");
		String Pending_Popup = Excel_data.get("Pending_Popup");
		String MCN_Submit_Remarks_Input = Excel_data.get("MCN_Submit_Remarks_Input");
		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		String Mail_Id = Excel_data.get("Mail_Id");
		String Mail_SignIn_Page_Url = Excel_data.get("Mail_SignIn_Page_Url");
		String Mail_Password = Excel_data.get("Mail_Password");
		String Mail_Subject = Excel_data.get("Mail_Subject");
		String Duplicated_Removed_Popup = Excel_data.get("Duplicated_Removed_Popup");
		String yellow_ColorCode = Excel_data.get("Yellow_ColorCode");

		String correctionType = String.format(DropDown_Select, Corection_Type_Option);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency", test, test1);
		Step_Start(2, "Open the Manifest Correction Notes module", test, test1);
		moduleNavigate(driver, Manifest_Module);
		Step_End(2, "Open the Manifest Correction Notes module", test, test1);
		Step_Start(3, "Choose the correction type as 'Multicorrection'", test, test1);
		waitForElement(driver, Corection_Type_DropDown);
		click(driver, Corection_Type_DropDown);
		waitForElement(driver, correctionType);
		click(driver, correctionType);
		Step_End(3, "Choose the correction type as 'Multicorrection'", test, test1);
		Step_Start(4, "In clauses tab, Select any clause & click add", test, test1);
		waitForElement(driver, BL_Search_Button_MCN);
		click(driver, BL_Search_Button_MCN);
		globalValueSearchWindow(driver,DropdownCondition,Select_Search_Type_MCN,BL_Number,"","","","");
		if(isdisplayed(driver, popup_Message)) {
	waitForPopup(driver, popup_Message, Continue_Popup);
		String actual_Continue_Popup = getText(driver, popup_Message);
		if(actual_Continue_Popup.trim().equals(Continue_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+Continue_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Continue_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup, test, test1);
			click(driver, popup_Message_Yes_Button);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+Continue_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Continue_Popup+" || Actual Pop-up Message is : "+actual_Continue_Popup, test, test1);
		}}
		waitForElement(driver, Clause_Tab_MCN);
		click(driver, Clause_Tab_MCN);
		waitForElement(driver, Clause_Add_Button_MCN);
		click(driver, Clause_Add_Button_MCN);
		Step_End(4, "In clauses tab, Select any clause & click add", test, test1);
		Step_Start(5, "system will list all the clauses", test, test1);
		Step_Start(6, "Select the clauses & click select button", test, test1);
		List<String> clause_Numbers = splitAndExpand(Clause_No);
		for(String clause_Number : clause_Numbers) {
			waitForElement(driver, Clause_Filter_MCN);
			clear(driver, Clause_Filter_MCN);
			sendKeys(driver, Clause_Filter_MCN, clause_Number);
			waitForElement(driver, Clause_Select_Check_Box);
			click(driver, Clause_Select_Check_Box);
		}
		waitForElement(driver, Clause_Select_Button);
		click(driver, Clause_Select_Button);
		Step_End(6, "Select the clauses & click select button", test, test1);
		Step_End(5, "system will list all the clauses", test, test1);
		Step_Start(7, "Click the edit button in body tab System will popup with 'Do you want to edit Body Details? This will be validated in the approval process'", test, test1);
		waitForDisplay(driver, popup_Message);
		if(isDisplayed(driver, popup_Message)) {
			String act_text = getText(driver, popup_Message);
			if(Duplicated_Removed_Popup.equals(act_text)) {
				System.out.println("Matched ||The Expected Pop-up Message is : "+Duplicated_Removed_Popup+" || Actual Pop-up Message is : "+act_text);
				Extent_pass_New(driver, "Matched ||The Expected Pop-up Message is : "+Duplicated_Removed_Popup+" || Actual Pop-up Message is : "+act_text, test, test1);
				click(driver, popup_Message_Ok_Button);
			}
		}
		waitForElement(driver, Body_Tab_MCN);
		click(driver, Body_Tab_MCN);
		waitForElement(driver, Body_Edit_Button);
		click(driver, Body_Edit_Button);

		waitForDisplay(driver, popup_Message);
		if(isDisplayed(driver, popup_Message)) {
			Step_End(7, "Click the edit button in body tab System will popup with 'Do you want to edit Body Details? This will be validated in the approval process'", test, test1);
			Step_Start(8, "Click yes to proceed further", test, test1);
			String act_text = getText(driver, popup_Message);
			System.out.println("Matched || the actual popup value was : "+act_text);
			Extent_pass_New(driver, "Matched || the actual popup value was : "+act_text, test, test1);
			click(driver, popup_Message_Yes_Button);
			Step_End(8, "Click yes to proceed further", test, test1);
		}
		Step_Start(9, "Right click on the body tab and click refresh all", test, test1);
		waitForElement(driver, Text_Area);
		RightClick(driver, Text_Area);
		waitForElement(driver, Refresh_All_Button);
		click(driver, Refresh_All_Button);
		Step_End(9, "Right click on the body tab and click refresh all", test, test1);
		Step_Start(10, "Click save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(10, "Click save button", test, test1);
		Step_Start(11, "System will popup  with Pending/Submit/Cancel message", test, test1);
		waitForElement(driver, Manifest_Pending_Button);
		Step_End(11, "System will popup  with Pending/Submit/Cancel message", test, test1);
		Step_Start(12, "Click pending to proceed", test, test1);
		click(driver, Manifest_Pending_Button);
		Step_End(12, "Click pending to proceed", test, test1);
		Step_Start(13, "System will save the MCN number in pending status with yellow color", test, test1);
	waitForPopup(driver, popup_Message, Pending_Popup);
		String actual_Pending_Popup = getText(driver, popup_Message);
		if(actual_Pending_Popup.trim().contains(Pending_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+Pending_Popup+" || Actual Pop-up Message is : "+actual_Pending_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Pending_Popup+" || Actual Pop-up Message is : "+actual_Pending_Popup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+Pending_Popup+" || Actual Pop-up Message is : "+actual_Pending_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Pending_Popup 	+" || Actual Pop-up Message is : "+actual_Pending_Popup, test, test1);
		}
		waitForElement(driver, MCN_Number_Textfield_MCN_Module);
		String actual_MCN_Number=getAttribute(driver, MCN_Number_Textfield_MCN_Module, "value");
		System.out.println("Generarted MCN Number : "+actual_MCN_Number);
		Extent_pass_New(driver, "Generarted MCN Number : "+actual_MCN_Number, test, test1);
		String actual_MCN_Textfield_Color_Code=getTextBackgroundColor(driver, MCN_Number_Textfield_MCN_Module);
		String actual_MCN_Textfield_Color = getColorName(actual_MCN_Textfield_Color_Code);
		if(actual_MCN_Textfield_Color.equalsIgnoreCase(yellow_ColorCode)) {
			System.out.println("Matched || The Background color of MCN Textfield is Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
			Extent_pass_New(driver, "Matched || The Background color of MCN Textfield is Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
		}else {
			System.out.println("Not Matched || The Background color of MCN Textfield is not Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color);
			Extent_fail(driver, "Not Matched || The Background color of MCN Textfield is not Yellow || Expected MCN Textfield Color is : "+yellow_ColorCode+" || Actual MCN Textfield Color is : "+actual_MCN_Textfield_Color, test, test1);
		}
		Step_End(13, "System will save the MCN number in pending status with yellow color", test, test1);
		Step_Start(14, "Now Click edit button in toolbar & click save button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(14, "Now Click edit button in toolbar & click save button", test, test1);
		Step_Start(15, "System will popup  with pending/Submit/Cancel message", test, test1);
		waitForElement(driver, Manifest_Submit_Button);
		Step_End(15, "System will popup  with pending/Submit/Cancel message", test, test1);
		Step_Start(16, "Now click on submit button then system will open MCN remarks window", test, test1);
		click(driver, Manifest_Submit_Button);
		Step_End(16, "Now click on submit button then system will open MCN remarks window", test, test1);
		Step_Start(17, "Enter the remarks and click ok to submit", test, test1);
		waitForElement(driver, Remarks_Field);
		sendKeys(driver, Remarks_Field, MCN_Submit_Remarks_Input);
		click(driver, Remarks_OK_Button);
		Step_End(17, "Enter the remarks and click ok to submit", test, test1);
		Step_Start(18, "Then system will pop up 'Submitted. MCN is moved to approval process' message in that click ok button", test, test1);
	waitForPopup(driver, popup_Message, Submitted_Popup);
		String actual_Popup = getText(driver, popup_Message);
		if(Submitted_Popup.trim().equals(actual_Popup.trim())) {
			System.out.println("Matched || Expected Pop-up Message is : "+Submitted_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Pop-up Message is : "+Submitted_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Pop-up Message is : "+Submitted_Popup+" || Actual Pop-up Message is : "+actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop-up Message is : "+Submitted_Popup+" || Actual Pop-up Message is : "+actual_Popup, test, test1);
		}
		Step_End(18, "Then system will pop up 'Submitted. MCN is moved to approval process' message in that click ok button", test, test1);
		Step_Start(19, "Based on entity System will auto approve the MCN", test, test1);
		Step_Start(20, "Then in mail window enter correct mail id and click on send button", test, test1);
		waitForElement(driver, Mail_To_Field_MCN);
		clearAndType(driver, Mail_To_Field_MCN, Mail_Id);
		waitForElement(driver, Mail_Send_Button_MCN);
		click(driver, Mail_Send_Button_MCN);
		Step_End(20, "Then in mail window enter correct mail id and click on send button", test, test1);
		Step_Start(21, "Then verify whether mail received or not in mail inbox", test, test1);
		waitForElement(driver, MCN_Number_Textfield_MCN_Module);
		mailinator_Verification(driver, Mail_SignIn_Page_Url, Mail_Id,Mail_Subject+actual_MCN_Number);
		Step_End(21, "Then verify whether mail received or not in mail inbox", test, test1);
		Step_End(19, "Based on entity System will auto approve the MCN", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
