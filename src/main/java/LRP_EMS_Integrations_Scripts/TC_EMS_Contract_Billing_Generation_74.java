package LRP_EMS_Integrations_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.EMS_Contract_Billing_Generation_And_Verification_Locators;

public class TC_EMS_Contract_Billing_Generation_74 extends Keywords {

	public void Billing_Generation_Verification_74(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable {
		String testCase_Name="TC_EMS_Contract_Billing_Generation_74";
		String user_Name = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String Contaract_No_input = Excel_data.get("Contaract_No");
		String Search_Contract_No_Popup_Txt_Exp = Excel_data.get("Search_Contract_No_Popup_Txt");
		String Add_Remarks_Popup_Txt = Excel_data.get("Add_Remarks_Popup");
		String Remark_Txt_Field_input = Excel_data.get("Remark_Txt_Field");
		String Enter_Verify_Remarks_Popup_Txt_Exp = Excel_data.get("Enter_Verify_Remarks_Popup_Txt");
		String Month_Select_For74 = Excel_data.get("Month_Select_For74");
		String Year_Select_For74 = Excel_data.get("Year_Select_For74");
		String show_Bills_Button = Excel_data.get("show_Bills_Button");
		String ContractNo_CheckBox_Select = Excel_data.get("ContractNo_CheckBox_Select");
		String Condition =Excel_data.get("Condition");
		String Search_Contract_No_Column_Header =Excel_data.get("Search_Contract_No_Column_Header");

		String month_Select74 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  Month_Select_For74);
		String show_Bills =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  show_Bills_Button);
		String ContractNo_Select_CheckBox =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.ContractNo_Select_ChkBox,  Contaract_No_input);

		Extent_Start(testCase_Name, test, test1);
		navigateUrl(driver, url);
		// Login
		LRP_Login(driver, user_Name, pass_word);
		Extent_call(test, test1, "Enter module name in searchbox & click the module");
		moduleNavigate(driver, Field_Names);
		Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
		waitForDisplay(driver, P_Contract_Module_Page);
		if (isdisplayed(driver, P_Contract_Module_Page)) {
			System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
			Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
		} else {
			System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
			Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
		}
		Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
		Step_Start(2, "Click (+) button from Contract No field", test, test1);
		//wait(driver, "3");
		waitForElement(driver, P_Contact_No_Plus_Btn);
		click(driver, P_Contact_No_Plus_Btn);
		Step_End(2, "Click (+) button from Contract No field", test, test1);

		waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
		String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
		if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
			System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
			Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
			Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
		}
		Step_Start(3, "Select required contract no from the field", test, test1);
		twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
		Step_End(3, "Select required contract no from the field", test, test1);

		if (!Year_Select_For74.equals("")) {
			waitForElement(driver, P_Bill_Period_Year_Field);
			System.out.println("Year_Select_For74 : " + Year_Select_For74);
			clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For74);
		}
		if (!Month_Select_For74.equals("")) {
			waitForElement(driver, P_Bill_Period_Month_DD);
			click(driver, P_Bill_Period_Month_DD);
			System.out.println("Month_Select_For74 : " + Month_Select_For74);
			waitForElement(driver, month_Select74);
			click(driver, month_Select74);
		}
		Step_Start(4, "Click on Show bills", test, test1);
		waitForElement(driver, show_Bills);
		click(driver, show_Bills);
		Step_End(4, "Click on Show bills", test, test1);
		Step_Start(5, "Select the checkbox from the contract summary for required contract", test, test1);
		waitForElement(driver, ContractNo_Select_CheckBox);
		checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
		Step_End(5, "Select the checkbox from the contract summary for required contract", test, test1);
		Step_Start(6, "Click verify button", test, test1);
		waitForElement(driver, P_Verify_Btn);
		click(driver, P_Verify_Btn);
		Step_End(6, "Click verify button", test, test1);
		Step_Start(7, "Ensure that system should validate if user try to click 'ok' for verify button when remarks given blank.", test, test1);
		waitForElement(driver, P_Add_Remark_Title);
		String Act_Popup_Msg = getText(driver, P_Add_Remark_Title);
		if (Add_Remarks_Popup_Txt.equals(Act_Popup_Msg)) {
			System.out.println("Matched || " + " Expected Popup is : " + Add_Remarks_Popup_Txt+ " || Actual Popup is : " + Act_Popup_Msg);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
		}
		waitForElement(driver, P_Remark_Txt_Field);
		click(driver, P_Remark_Txt_Field);
		waitForElement(driver, P_Remark_Txt_Field);
		sendKeys(driver, P_Remark_Txt_Field, Remark_Txt_Field_input);
		waitForElement(driver, P_Remark_Ok_Btn);
		click(driver, P_Remark_Ok_Btn);
		Step_End(7, "Ensure that system should validate if user try to click 'ok' for verify button when remarks given blank.", test, test1);
		Step_Start(8, "Ensure that system should show confirmation message as 'Enter the verify Remarks'.", test, test1);
		waitForPopup(driver, Popup_Message, Search_Contract_No_Popup_Txt_Exp);
		String Enter_verify_Remark = getText(driver, Popup_Message);
		if (Enter_Verify_Remarks_Popup_Txt_Exp.equals(Enter_verify_Remark)) {
			System.out.println("Matched || " + " Expected Popup is : "+ Enter_Verify_Remarks_Popup_Txt_Exp + " || Actual Popup is : "+ Enter_verify_Remark);
			Extent_pass_New(driver,"Matched || " + " Expected Popup is : "+ Enter_Verify_Remarks_Popup_Txt_Exp+ " || Actual Popup is : " + Enter_verify_Remark,test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : "+ Enter_Verify_Remarks_Popup_Txt_Exp + " || Actual Popup is : "+ Enter_verify_Remark);
			Extent_fail(driver,"Not Matched || " + " Expected Popup is : "+ Enter_Verify_Remarks_Popup_Txt_Exp+ " || Actual Popup is : " + Enter_verify_Remark,test, test1);
		}
		Step_End(8, "Ensure that system should show confirmation message as 'Enter the verify Remarks'.", test, test1);
		Extent_completed(testCase_Name, test, test1);
	}
}
