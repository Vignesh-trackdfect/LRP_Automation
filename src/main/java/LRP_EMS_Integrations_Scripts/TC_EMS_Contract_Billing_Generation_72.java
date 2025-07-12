package LRP_EMS_Integrations_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.EMS_Contract_Billing_Generation_And_Verification_Locators;

public class TC_EMS_Contract_Billing_Generation_72 extends Keywords {

	public void Billing_Generation_Verification_72(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable {
		String testCase_Name="TC_EMS_Contract_Billing_Generation_72";
		

		String user_Name = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String Contaract_No_input = Excel_data.get("Contaract_No");
		String Password_Popup_Input_Txt = Excel_data.get("Password_Popup_Input");
		String Verification_Popup_Txt_Exp = Excel_data.get("Verification_Popup_Txt");
		String Bills_Generated_Popup_Txt = Excel_data.get("Bills_Generated_Popup");
		String Search_Contract_No_Popup_Txt_Exp = Excel_data.get("Search_Contract_No_Popup_Txt");
		String Month_Select_For72 = Excel_data.get("Month_Select_For72");
		String Year_Select_For72 = Excel_data.get("Year_Select_For72");
		String generate_Button = Excel_data.get("generate_Button");
		String Condition =Excel_data.get("Condition");
		String Search_Contract_No_Column_Header =Excel_data.get("Search_Contract_No_Column_Header");
		//locators
		String month_Select72 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  Month_Select_For72);
		String generatebutton =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  generate_Button);
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

		if (!Year_Select_For72.equals("")) {

			waitForElement(driver, P_Bill_Period_Year_Field);
			System.out.println("Year_Select_For72 : " + Year_Select_For72);
			clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For72);
		}
		if (!Month_Select_For72.equals("")) {

			waitForElement(driver, P_Bill_Period_Month_DD);
			click(driver, P_Bill_Period_Month_DD);

			System.out.println("Month_Select_For72 : " + Month_Select_For72);
			waitForElement(driver, month_Select72);
			click(driver, month_Select72);
		}

		Step_Start(4, "Click on Generate Bills", test, test1);
		waitForElement(driver, generatebutton);
		click(driver, generatebutton);
		Step_Start(4, "Click on Generate Bills", test, test1);
		Step_Start(5, "Ensure that system should show successfull message if user generated billing after clicking 'yes' once valid password is given", test, test1);

		waitForElement(driver, P_Authentication_popup);
		waitForElement(driver, P_Authentication_popup_TxtField);
		click(driver, P_Authentication_popup_TxtField);
		sendKeys(driver, P_Authentication_popup_TxtField, Password_Popup_Input_Txt);
		waitForElement(driver, P_Authentication_popup_OkBtn);
		click(driver, P_Authentication_popup_OkBtn);
		Step_End(5, "Ensure that system should show successfull message if user generated billing after clicking 'yes' once valid password is given", test, test1);

		waitForPopup(driver, popup_Message, Verification_Popup_Txt_Exp);
		String actual_PopUpMsg = getText(driver, popup_Message);
		if (actual_PopUpMsg.contains(Verification_Popup_Txt_Exp)) {
			System.out.println("Matched || " + " Expected Popup is : " + Verification_Popup_Txt_Exp+ " || Actual Popup is : " + actual_PopUpMsg);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Verification_Popup_Txt_Exp + " || Actual Popup is : " + actual_PopUpMsg,test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : " + Verification_Popup_Txt_Exp+ " || Actual Popup is : " + actual_PopUpMsg);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Verification_Popup_Txt_Exp + " || Actual Popup is : " + actual_PopUpMsg,test, test1);
		}
		Step_Start(6, "Ensure that system should show confirmation message as 'Bills Successfully Generated for FEB 2024'.", test, test1);
		click(driver, popup_Message_Yes_Button);
		
		waitForPopup(driver, Popup_Message, Bills_Generated_Popup_Txt);
		String act_popUp_Msg = getText(driver, Popup_Message).trim();

		if (act_popUp_Msg.contains(Bills_Generated_Popup_Txt)) {
			System.out.println("Matched || " + " Expected Popup is : " + Bills_Generated_Popup_Txt+ " || Actual Popup is : " + act_popUp_Msg);
			Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Bills_Generated_Popup_Txt+ " || Actual Popup is : " + act_popUp_Msg,test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : "+ Bills_Generated_Popup_Txt + " || Actual Popup is : "+ act_popUp_Msg);
			Extent_fail(driver,"Not Matched || " + " Expected Popup is : "+ Bills_Generated_Popup_Txt + " || Actual Popup is : "+ act_popUp_Msg,test, test1);
		}
		Step_End(6, "Ensure that system should show confirmation message as 'Bills Successfully Generated for FEB 2024'.", test, test1);
		Extent_completed(testCase_Name, test, test1);	
	}
}
