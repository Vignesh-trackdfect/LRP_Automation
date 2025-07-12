package LRP_EMS_Integrations_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.EMS_Contract_Billing_Generation_And_Verification_Locators;

public class TC_EMS_Contract_Billing_Generation_81 extends Keywords {

	public void Billing_Generation_Verification_81(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable {
		String testCase_Name="TC_EMS_Contract_Billing_Generation_81";
		
		String user_Name = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String Contaract_No_input = Excel_data.get("Contaract_No");
		String Search_Contract_No_Popup_Txt_Exp = Excel_data.get("Search_Contract_No_Popup_Txt");
		String Add_Remarks_Popup_Txt = Excel_data.get("Add_Remarks_Popup");
		String Verified_Popup_Txt = Excel_data.get("Verified_Popup");
		String Remark_Txt_Field_input = Excel_data.get("Remark_Txt_Field");
		String Highlighted_RedColor_txt_Exp = Excel_data.get("Highlighted_RedColor_txt");
		String Approved_Popup_Txt_Exp = Excel_data.get("Approved_Popup_Txt");
		String Highlighted_GreenColor_Txt_Exp = Excel_data.get("Highlighted_GreenColor_txt");
		String Invalid_Terms_Msg_Txt_Exp = Excel_data.get("Invalid_Terms_Msg_Txt");
		String Month_Select_For81 = Excel_data.get("Month_Select_For81");
		String Year_Select_For81 = Excel_data.get("Year_Select_For81");
		String show_Bills_Button = Excel_data.get("show_Bills_Button");
		String reGenerate_Button = Excel_data.get("reGenerate_Button");
		String ContractNo_CheckBox_Select = Excel_data.get("ContractNo_CheckBox_Select");
		String approve_Remark_Txt_Field_input = Excel_data.get("approve_Remark_Txt_Field_input");
		String Condition =Excel_data.get("Condition");
		String Search_Contract_No_Column_Header =Excel_data.get("Search_Contract_No_Column_Header");
		//locators
		String month_Select81 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  Month_Select_For81);
		String show_Bills =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  show_Bills_Button);
		String ContractNo_Select_CheckBox =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.ContractNo_Select_ChkBox,  Contaract_No_input);
		String verrified_Row =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.verified_Row,  Contaract_No_input);
		String regenerate_Button = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  reGenerate_Button);
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

		if (!Year_Select_For81.equals("")) {
			waitForElement(driver, P_Bill_Period_Year_Field);
			System.out.println("Year_Select_For81 : " + Year_Select_For81);
			clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For81);
		}
		if (!Month_Select_For81.equals("")) {
			waitForElement(driver, P_Bill_Period_Month_DD);
			click(driver, P_Bill_Period_Month_DD);
			System.out.println("Month_Select_For81 : " + Month_Select_For81);
			waitForElement(driver, month_Select81);
			click(driver, month_Select81);
		}
		Step_Start(4, "Click on Show bills", test, test1);
		waitForElement(driver, show_Bills);
		click(driver, show_Bills);
		Step_End(4, "Click on Show bills", test, test1);
		Step_Start(5, "Select the checkbox from the contract summary for required contract", test, test1);
		waitForElement(driver, ContractNo_Select_CheckBox);
		checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
		Step_End(5, "Select the checkbox from the contract summary for required contract", test, test1);
		Step_Start(6, "Click verify button after entering remarks", test, test1);
		waitForElement(driver, P_Verify_Btn);
		click(driver, P_Verify_Btn);
		Step_End(6, "Click verify button after entering remarks", test, test1);
		Step_Start(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
		waitForPopup(driver, P_Add_Remark_Title, Add_Remarks_Popup_Txt);
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
		Step_End(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
		Step_Start(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
		waitForPopup(driver, Popup_Message, Verified_Popup_Txt);
		String act_Popup_Msg = getText(driver, Popup_Message);
		if (Verified_Popup_Txt.equals(act_Popup_Msg)) {
			System.out.println("Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
		}
		Step_End(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
		Step_Start(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
		waitForElement(driver, verrified_Row);
		String red_Colour_Code = getTextBackgroundColor(driver, verrified_Row);
		String red_Colour = getColorName(red_Colour_Code);
		System.out.println("red_Colour : "+red_Colour);
		if(Highlighted_RedColor_txt_Exp.equals(red_Colour)) {
			System.out.println("Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
			Extent_pass_New(driver, "Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
			Extent_fail(driver, "Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
		}
		Step_End(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
		Step_Start(10, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
		waitForElement(driver, ContractNo_Select_CheckBox);
		checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
		waitForElement(driver, P_ApproveBill_Btn);
		click(driver, P_ApproveBill_Btn);
		waitForPopup(driver, P_Approve_Remark_Title, Add_Remarks_Popup_Txt);
		String Popup_Message1 = getText(driver, P_Approve_Remark_Title);
		if (Add_Remarks_Popup_Txt.equals(Popup_Message1)) {
			System.out.println("Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
		}
		waitForElement(driver, P_Approve_Remarks_TxtFiled);
		click(driver, P_Approve_Remarks_TxtFiled);
		waitForElement(driver, P_Approve_Remarks_TxtFiled);
		sendKeys(driver, P_Approve_Remarks_TxtFiled, approve_Remark_Txt_Field_input);
		waitForElement(driver, P_Approve_Remarks_OkBtn);
		click(driver, P_Approve_Remarks_OkBtn);
		Step_End(10, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
		Step_Start(11, "Ensure that system should show confirmation message as 'Approved Successfully'.", test, test1);
		waitForPopup(driver, Popup_Message, Approved_Popup_Txt_Exp);
		String approved_Message = getText(driver, Popup_Message);
		if (Approved_Popup_Txt_Exp.equals(approved_Message)) {
			System.out.println("Matched || " + " Expected Popup is : " + Approved_Popup_Txt_Exp+ " || Actual Popup is : " + approved_Message);
			Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Approved_Popup_Txt_Exp+ " || Actual Popup is : " + approved_Message,test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : "+ Approved_Popup_Txt_Exp + " || Actual Popup is : "+ approved_Message);
			Extent_fail(driver,"Not Matched || " + " Expected Popup is : "+ Approved_Popup_Txt_Exp + " || Actual Popup is : "+ approved_Message,test, test1);
		}
		Step_End(11, "Ensure that system should show confirmation message as 'Approved Successfully'.", test, test1);
		Step_Start(12, "Ensure that system should Highlighted Total by contract row in green color once approved", test, test1);
		waitForElement(driver, verrified_Row);
		String green_ColourCode = getTextBackgroundColor(driver, verrified_Row);
		String green_Colour = getColorName(green_ColourCode);
		System.out.println("green_Colour : " + Highlighted_GreenColor_Txt_Exp);
		if (Highlighted_GreenColor_Txt_Exp.equals(green_Colour)) {
			System.out.println("Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp + " || Actual Color is : "+ green_Colour);
			Extent_pass_New(driver,"Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp+ " || Actual Color is : " + green_Colour,test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp + " || Actual Color is : "+ green_Colour);
			Extent_fail(driver,"Not Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp+ " || Actual Color is : " + green_Colour,test, test1);
		}
		Step_End(12, "Ensure that system should Highlighted Total by contract row in green color once approved", test, test1);

		Step_Start(13, "Ensure that system should show warning message if user try to click regenerate button ", test, test1);
		waitForElement(driver, P_Reset_Btn);
		click(driver, P_Reset_Btn);
		Step_End(13, "Ensure that system should show warning message if user try to click regenerate button ", test, test1);
		
		waitForElement(driver, regenerate_Button);
		click(driver, regenerate_Button);
		
		Step_Start(14, "Ensure that system should show warning message as 'Bill for approved contract cannot be regenerated'.", test, test1);
		waitForPopup(driver, P_Invalid_Terms_Popup_Msg, Invalid_Terms_Msg_Txt_Exp);
		String actualTerms_Msg = getText(driver, P_Invalid_Terms_Popup_Msg);
		System.out.println("actualTerms_Msg : " + actualTerms_Msg);
		if (Invalid_Terms_Msg_Txt_Exp.equals(actualTerms_Msg)) {
			System.out.println("Matched || " + " Expected Popup is : "+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg);
			Extent_pass_New(driver,"Matched || " + " Expected Popup is : "+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg,test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : "+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg);
			Extent_fail(driver,"Not Matched || " + " Expected Popup is : "	+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg,test, test1);
		}
		Step_End(14, "Ensure that system should show warning message as 'Bill for approved contract cannot be regenerated'.", test, test1);
		Extent_completed(testCase_Name, test, test1);
	}
}
