package LRP_EMS_Integrations_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_EMS_Contract_Billing_Generation_68 extends Keywords {

	public void Billing_Generation_Verification_68(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable {
		String testCase_Name="TC_EMS_Contract_Billing_Generation_68";
		String user_Name = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String Values_Should_Be_Selected_Popup_Txt = Excel_data.get("Values_Should_Be_Selected_Popup");
		String Search_Contract_No_Popup_Txt_Exp = Excel_data.get("Search_Contract_No_Popup_Txt");
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
		Step_Start(3, "Ensure that system should validate if user try to click select button without selecting any checkbox from Search Contract No list", test, test1);

	
		waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
		String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
		if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
			System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
			Extent_pass_New(driver,
					"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
			Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
		}
		waitForElement(driver, P_Search_Contract_No_Popup_SelBtn);
		click(driver, P_Search_Contract_No_Popup_SelBtn);
	
		Step_End(3, "Ensure that system should validate if user try to click select button without selecting any checkbox from Search Contract No list", test, test1);
		Step_Start(4, "Ensure that system should validate as 'Values should be selected'.", test, test1);
		waitForPopup(driver, P_Search_Contract_Alert_Msg, Values_Should_Be_Selected_Popup_Txt);
		String alertMsg = getText(driver, P_Search_Contract_Alert_Msg);
		if (Values_Should_Be_Selected_Popup_Txt.equals(alertMsg)) {
			System.out.println("Matched || " + " Expected Popup is : "+ Values_Should_Be_Selected_Popup_Txt + " || Actual Popup is : " + alertMsg);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Values_Should_Be_Selected_Popup_Txt + " || Actual Popup is : " + alertMsg, test,test1);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : "+ Values_Should_Be_Selected_Popup_Txt + " || Actual Popup is : " + alertMsg);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Values_Should_Be_Selected_Popup_Txt + " || Actual Popup is : " + alertMsg,test, test1);
		}
		Step_End(4, "Ensure that system should validate as 'Values should be selected'.", test, test1);
		Extent_completed(testCase_Name, test, test1);
	}
}
