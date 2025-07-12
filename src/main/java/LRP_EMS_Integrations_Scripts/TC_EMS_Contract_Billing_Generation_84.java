package LRP_EMS_Integrations_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.EMS_Contract_Billing_Generation_And_Verification_Locators;

public class TC_EMS_Contract_Billing_Generation_84 extends Keywords {
	public void Billing_Generation_Verification_84(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable {
		String testCase_Name="TC_EMS_Contract_Billing_Generation_84";
		String user_Name = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String Contaract_No_input = Excel_data.get("Contaract_No");
		String Search_Contract_No_Popup_Txt_Exp = Excel_data.get("Search_Contract_No_Popup_Txt");		
		String Month_Select_For84 = Excel_data.get("Month_Select_For84");
		String Year_Select_For84 = Excel_data.get("Year_Select_For84");
		String regenerate_Button = Excel_data.get("regenerate_Button");
		String Password_Popup_Input_Txt = Excel_data.get("Password_Popup_Input");
		String Already_Exist_Bill_Gate_Txt = Excel_data.get("Already_Exist_Bill_Gate").trim();
		String Condition =Excel_data.get("Condition");
		String Search_Contract_No_Column_Header =Excel_data.get("Search_Contract_No_Column_Header");
		//locators
		String regenerateButton =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  regenerate_Button);
		String month_Select84 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  Month_Select_For84);
		
		Extent_Start(testCase_Name, test, test1);
		navigateUrl(driver, url);
		// Login
		LRP_Login(driver, user_Name, pass_word);
		Step_Start(1, "Open EMS Contract BIlling screen", test, test1);
		//Enter EMS Contract Billing Generation and Verification  
		moduleNavigate(driver, Field_Names);
		waitForDisplay(driver, P_Contract_Module_Page);
		if (isdisplayed(driver, P_Contract_Module_Page)) {
			System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
			Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
		} else {
			System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
			Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
		}
		Step_End(1, "Open EMS Contract BIlling screen", test, test1);
		Step_Start(2, "Select Contract no which is already uploaded in lessor bill & in error node for bill upload gate", test, test1);
		waitForElement(driver, P_Contact_No_Plus_Btn);
		click(driver, P_Contact_No_Plus_Btn);

		waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
		if(Search_Contract_No_Popup_Txt_Exp.equals(getText(driver, P_Search_Contract_No_Popup))) {
			System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup));
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup), test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup));
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup), test,test1);
		}
		twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
		Step_End(2, "Select Contract no which is already uploaded in lessor bill & in error node for bill upload gate", test, test1);
		Step_Start(3, "click regenerate & enter valid password for the same period as upload in bill upload gate", test, test1);
		waitForElement(driver, P_Bill_Period_Year_Field);
		clearAndType(driver, P_Bill_Period_Year_Field,Year_Select_For84);
		waitForElement(driver, P_Bill_Period_Month_DD);
		click(driver, P_Bill_Period_Month_DD);
		System.out.println("Month_Select_For84 : "+Month_Select_For84);
		waitForElement(driver, month_Select84);
		click(driver, month_Select84);

		waitForElement(driver, regenerateButton);
		click(driver, regenerateButton);
		waitForElement(driver, P_Regenaration_Pass_TxtField);
		click(driver, P_Regenaration_Pass_TxtField);
		sendKeys(driver, P_Regenaration_Pass_TxtField, Password_Popup_Input_Txt);
		waitForElement(driver, P_Regenaration_Pass_OkBtn);
		click(driver, P_Regenaration_Pass_OkBtn);
		Step_End(3, "click regenerate & enter valid password for the same period as upload in bill upload gate", test, test1);
		Step_Start(4, "Ensure that system should show warning message as 'This Contract is Already Exist in Bill Upload Gate'.", test, test1);
		waitForPopup(driver, P_Bill_Already_Exist_Popup_Msg, Already_Exist_Bill_Gate_Txt);
		String Exist_Popup_Msg= getText(driver, P_Bill_Already_Exist_Popup_Msg);
		System.out.println("Exist_Popup_Msg : "+Exist_Popup_Msg);
		if(Already_Exist_Bill_Gate_Txt.equals(Exist_Popup_Msg)) {
			System.out.println("Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg, test,test1);
		}
		Step_End(4, "Ensure that system should show warning message as 'This Contract is Already Exist in Bill Upload Gate'.", test, test1);
		Extent_completed(testCase_Name, test, test1);
	}
}
