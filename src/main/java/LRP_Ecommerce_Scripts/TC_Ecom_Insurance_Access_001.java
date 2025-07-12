package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecom_Insurance_Access_001 extends Keywords {

	public void Ecom_Insurance_Access_001(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecom_Insurance_Access_001";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String Customer_Input = Excel_data.get("Customer_Input");
		String Condition = Excel_data.get("Condition");
		String Customer_search = Excel_data.get("Customer_search");
		String Customer_Name = Excel_data.get("Customer_Name");
		String agencyUser = Excel_data.get("AgencyUser");
		String Saved_popup_Message = Excel_data.get("Saved_popup_Message");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);
		SwitchProfile(driver, agencyUser);
		
		Step_Start(1, " Enter \"Ecom insurance acess\" in the Module Search to access the module.", test, test1);
		moduleNavigate(driver, Module_Name);
		Step_End(1, " Enter \"Ecom insurance acess\" in the Module Search to access the module.", test, test1);

		Step_Start(2, "Line and Agency users can access the  Ecom insurance acess.", test, test1);

		waitForElement(driver, Customer_code_search);
		click(driver, Customer_code_search);

		twoColumnSearchWindow(driver, Customer_search, Condition, Customer_Input);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Saved_popup_Message);
		String Act_popup = getText(driver, Popup_Message);

		if (Act_popup.equals(Saved_popup_Message)) {
			System.out.println("Matched || Expected Popup Message was : " + Saved_popup_Message
					+ " || Actual Popup Message was : " + Act_popup);
			Extent_pass_New(driver, "Matched || Expected Popup Message was : " + Saved_popup_Message
					+ " || Actual Popup Message was : " + Act_popup, test, test1);
		} else {
			System.out.println("NotMatched || Expected Popup Message was : " + Saved_popup_Message
					+ " || Actual Popup Message was : " + Act_popup);
			Extent_fail(driver, "NotMatched || Expected Popup Message was : " + Saved_popup_Message
					+ " || Actual Popup Message was : " + Act_popup, test, test1);
		}

		waitForElement(driver, refresh_button_ecom);
		click(driver, refresh_button_ecom);

		waitForElement(driver, Customer_code_input);
		sendKeys(driver, Customer_code_input, Customer_Input);

		waitForElement(driver, Customer_name_input);
		sendKeys(driver, Customer_name_input, Customer_Name);

		waitForElement(driver, Customer_name_input_text);
		String customer_nme_act = getText(driver, Customer_name_input_text);

		if (customer_nme_act.equals(Customer_Name)) {
			System.out.println("Matched || Expected Customer Name was : " + Customer_Name
					+ " || Actual Customer Name was : " + customer_nme_act);
			Extent_pass_New(driver, "Matched || Expected Customer Name was: " + Customer_Name
					+ " || Actual Customer Name was : " + customer_nme_act, test, test1);
		} else {
			System.out.println("Not Matched || Expected Customer Name was : " + Customer_Name
					+ " || Actual Customer Name was : " + customer_nme_act);
			Extent_fail(driver, "Not Matched || Expected Customer Name was: " + Customer_Name
					+ " || Actual Customer Name was : " + customer_nme_act, test, test1);
		}

		waitForElement(driver, Customer_code_input_text);
		String customer_code_act = getText(driver, Customer_code_input_text);

		if (customer_code_act.equals(Customer_Input)) {
			System.out.println("Matched || Expected Customer Code was : " + customer_code_act
					+ " || Actual Customer Code was : " + Customer_Input);
			Extent_pass_New(driver, "Matched || Expected Customer Code was: " + customer_code_act
					+ " || Actual Customer Code was : " + Customer_Input, test, test1);
		} else {
			System.out.println("Not Matched || Expected Customer Code was : " + customer_code_act
					+ " || Actual Customer Code was : " + Customer_Input);
			Extent_fail(driver, "Not Matched || Expected Customer Code was: " + customer_code_act
					+ " || Actual Customer Code was : " + Customer_Input, test, test1);
		}

		Step_End(2, "Line and Agency users can access the  Ecom insurance acess.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
