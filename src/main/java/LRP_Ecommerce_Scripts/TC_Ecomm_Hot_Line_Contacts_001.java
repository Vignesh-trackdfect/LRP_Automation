package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecomm_Hot_Line_Contacts_001 extends Keywords {

	public void Ecomm_Hot_Line_Contacts_001(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecomm_Hot_Line_Contacts_001";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String Contact_Name = Excel_data.get("Contact_Name");
		String Country_Name = Excel_data.get("Country_Name");
		String Email = Excel_data.get("Email");
		String Country_Code = Excel_data.get("Country_Code");
		String Phone = Excel_data.get("Phone");
		String Port_Code = Excel_data.get("Port_Code");
		String Port_Name = Excel_data.get("Port_Name");
		String agencyUser = Excel_data.get("AgencyUser");
		String Saved_popup_Message = Excel_data.get("Saved_popup_Message");
		String AgencyUser_Perform = Excel_data.get("AgencyUser_Perform");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);
		if (AgencyUser_Perform.equalsIgnoreCase("YES")) {
			SwitchProfile(driver, agencyUser);
		}
		Step_Start(1, "  Enter \"Ecomm Hot Line Contacts\" in the Module Search to access the module..", test, test1);
		moduleNavigate(driver, Module_Name);
		Step_End(1, "  Enter \"Ecomm Hot Line Contacts\" in the Module Search to access the module..", test, test1);

		Step_Start(2, " Line and Agency users can access the Ecomm Hot Line Contacts module.", test, test1);
		waitForElement(driver, EC_HLC_Contact_Name_Input_Field);
		click(driver, EC_HLC_Contact_Name_Input_Field);

		sendKeys(driver, EC_HLC_Contact_Name_Input_Field, Contact_Name);

		waitForElement(driver, EC_HLC_Country_Name_Input_Field);
		click(driver, EC_HLC_Country_Name_Input_Field);

		sendKeys(driver, EC_HLC_Country_Name_Input_Field, Country_Name);

		waitForElement(driver, EC_HLC_Country_Code_Input_Field);
		click(driver, EC_HLC_Country_Code_Input_Field);

		sendKeys(driver, EC_HLC_Country_Code_Input_Field, Country_Code);

		waitForElement(driver, EC_HLC_Phone_Input_Field);
		click(driver, EC_HLC_Phone_Input_Field);

		sendKeys(driver, EC_HLC_Phone_Input_Field, Phone);

		waitForElement(driver, EC_HLC_Email_Input_Field);
		click(driver, EC_HLC_Email_Input_Field);

		sendKeys(driver, EC_HLC_Email_Input_Field, Email);

		waitForElement(driver, EC_HLC_Port_Name_Input_Field);
		click(driver, EC_HLC_Port_Name_Input_Field);

		sendKeys(driver, EC_HLC_Port_Name_Input_Field, Port_Name);

		waitForElement(driver, EC_HLC_Port_Code_Input_Field);
		click(driver, EC_HLC_Port_Code_Input_Field);

		sendKeys(driver, EC_HLC_Port_Code_Input_Field, Port_Code);

		Step_Start(8, " Click on the Save button", test, test1);

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

		waitForElement(driver, EC_HLC_Condition_Filter);
		click(driver, EC_HLC_Condition_Filter);

		waitForElement(driver, EC_HLC_Condition_Contact_Name_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Contact_Name_Input_Field, Contact_Name);

		waitForElement(driver, EC_HLC_Condition_Country_Code_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Country_Code_Input_Field, Country_Code);

		waitForElement(driver, EC_HLC_Condition_Country_Name_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Country_Name_Input_Field, Country_Name);

		waitForElement(driver, EC_HLC_Condition_Email_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Email_Input_Field, Email);

		waitForElement(driver, EC_HLC_Condition_Phone_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Phone_Input_Field, Phone);

		waitForElement(driver, EC_HLC_Grid_Contact_Name_Input_Field);
		String Act_Contact_Name = getText(driver, EC_HLC_Grid_Contact_Name_Input_Field);

		if (Act_Contact_Name.equals(Contact_Name)) {
			System.out.println("Matched || Expected contract name was : " + Contact_Name
					+ " || Actual contract name was : " + Act_Contact_Name);
			Extent_pass_New(driver, "Matched || Expected contract name was: " + Contact_Name
					+ " || Actual contract name was : " + Act_Contact_Name, test, test1);
		} else {
			System.out.println("Not Matched || Expected contract name was : " + Contact_Name
					+ " || Actual contract name was : " + Act_Contact_Name);
			Extent_fail(driver, "Not Matched || Expected contract name was: " + Contact_Name
					+ " || Actual contract name was : " + Act_Contact_Name, test, test1);
		}

		waitForElement(driver, EC_HLC_Grid_Country_Code_Input_Field);
		String Act_Country_Code = getText(driver, EC_HLC_Grid_Country_Code_Input_Field);

		if (Act_Country_Code.equals(Country_Code)) {
			System.out.println("Matched || Expected country code was : " + Country_Code
					+ " || Actual country code was : " + Act_Country_Code);
			Extent_pass_New(driver, "Matched || Expected country code was: " + Country_Code
					+ " || Actual country code was : " + Act_Country_Code, test, test1);
		} else {
			System.out.println("Not Matched || Expected country code was : " + Country_Code
					+ " || Actual country code was : " + Act_Country_Code);
			Extent_fail(driver, "Not Matched || Expected country code was: " + Country_Code
					+ " || Actual country code was : " + Act_Country_Code, test, test1);
		}

		waitForElement(driver, EC_HLC_Grid_Country_Name_Input_Field);
		String Act_Country_Name = getText(driver, EC_HLC_Grid_Country_Name_Input_Field);

		if (Act_Country_Name.equals(Country_Name)) {
			System.out.println("Matched || Expected country name was : " + Country_Name
					+ " || Actual country name was : " + Act_Country_Name);
			Extent_pass_New(driver, "Matched || Expected country name was: " + Country_Name
					+ " || Actual country name was : " + Act_Country_Name, test, test1);
		} else {
			System.out.println("Not Matched || Expected country name was : " + Country_Name
					+ " || Actual country name was : " + Act_Country_Name);
			Extent_fail(driver, "Not Matched || Expected country name was: " + Country_Name
					+ " || Actual country name was : " + Act_Country_Name, test, test1);
		}

		waitForElement(driver, EC_HLC_Grid_Email_Input_Field);
		String Act_Gmail = getText(driver, EC_HLC_Grid_Email_Input_Field);

		if (Act_Gmail.equals(Email)) {
			System.out
					.println("Matched || Expected Email ID was : " + Email + " || Actual Email ID was : " + Act_Gmail);
			Extent_pass_New(driver, "Matched || Expected Email ID was: " + Email + " || Actual Email ID was : " + Act_Gmail,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected Email ID was : " + Email + " || Actual Email ID was : " + Act_Gmail);
			Extent_fail(driver,
					"Not Matched || Expected Email ID was: " + Email + " || Actual Email ID was : " + Act_Gmail, test,
					test1);
		}

		waitForElement(driver, EC_HLC_Grid_Phone_Input_Field);
		String Act_Phone = getText(driver, EC_HLC_Grid_Phone_Input_Field);

		if (Act_Phone.equals(Phone)) {
			System.out.println(
					"Matched || Expected phone number was : " + Phone + " || Actual phone number was : " + Act_Phone);
			Extent_pass_New(driver,
					"Matched || Expected phone number was: " + Phone + " || Actual phone number was : " + Act_Phone,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected phone number was : " + Phone + " || Actual phone number was : "
					+ Act_Phone);
			Extent_fail(driver,
					"Not Matched || Expected phone number was: " + Phone + " || Actual phone number was : " + Act_Phone,
					test, test1);
		}

		waitForElement(driver, EC_HLC_Refresh_Button);
		click(driver, EC_HLC_Refresh_Button);

		waitForElement(driver, EC_HLC_Condition_Contact_Name_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Contact_Name_Input_Field, Contact_Name);

		waitForElement(driver, EC_HLC_Condition_Country_Code_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Country_Code_Input_Field, Country_Code);

		waitForElement(driver, EC_HLC_Condition_Country_Name_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Country_Name_Input_Field, Country_Name);

		waitForElement(driver, EC_HLC_Condition_Email_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Email_Input_Field, Email);

		waitForElement(driver, EC_HLC_Condition_Phone_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Phone_Input_Field, Phone);

		waitForElement(driver, EC_HLC_Grid_Contact_Name_Input_Field);
		String Act_Contact_Name1 = getText(driver, EC_HLC_Grid_Contact_Name_Input_Field);

		if (Act_Contact_Name1.equals(Contact_Name)) {
			System.out.println("Matched || Expected contact name was : " + Contact_Name
					+ " || Actual contact name was : " + Act_Contact_Name1);
			Extent_pass_New(driver, "Matched || Expected contact name was: " + Contact_Name
					+ " || Actual contact name was : " + Act_Contact_Name1, test, test1);
		} else {
			System.out.println("Not Matched || Expected contact name was : " + Contact_Name
					+ " || Actual contact name was : " + Act_Contact_Name1);
			Extent_fail(driver, "Not Matched || Expected contact name was: " + Contact_Name
					+ " || Actual contact name was : " + Act_Contact_Name1, test, test1);
		}

		waitForElement(driver, EC_HLC_Grid_Country_Code_Input_Field);
		String Act_Country_Code1 = getText(driver, EC_HLC_Grid_Country_Code_Input_Field);

		if (Act_Country_Code1.equals(Country_Code)) {
			System.out.println("Matched || Expected country code was : " + Country_Code
					+ " || Actual country code was : " + Act_Country_Code1);
			Extent_pass_New(driver, "Matched || Expected country code was: " + Country_Code
					+ " || Actual country code was : " + Act_Country_Code1, test, test1);
		} else {
			System.out.println("Not Matched || Expected country code was : " + Country_Code
					+ " || Actual country code was : " + Act_Country_Code1);
			Extent_fail(driver, "Not Matched || Expected country code was: " + Country_Code
					+ " || Actual country code was : " + Act_Country_Code1, test, test1);
		}

		waitForElement(driver, EC_HLC_Grid_Country_Name_Input_Field);
		String Act_Country_Name1 = getText(driver, EC_HLC_Grid_Country_Name_Input_Field);

		if (Act_Country_Name1.equals(Country_Name)) {
			System.out.println("Matched || Expected country name was : " + Country_Name
					+ " || Actual country name was : " + Act_Country_Name1);
			Extent_pass_New(driver, "Matched || Expected country name was: " + Country_Name
					+ " || Actual country name was : " + Act_Country_Name1, test, test1);
		} else {
			System.out.println("Not Matched || Expected country name was : " + Country_Name
					+ " || Actual country name was : " + Act_Country_Name1);
			Extent_fail(driver, "Not Matched || Expected country name was: " + Country_Name
					+ " || Actual country name was : " + Act_Country_Name1, test, test1);
		}

		waitForElement(driver, EC_HLC_Grid_Email_Input_Field);
		String Act_Gmail1 = getText(driver, EC_HLC_Grid_Email_Input_Field);

		if (Act_Gmail1.equals(Email)) {
			System.out
					.println("Matched || Expected Email ID was : " + Email + " || Actual Email ID was : " + Act_Gmail1);
			Extent_pass_New(driver,
					"Matched || Expected Email ID was: " + Email + " || Actual Email ID was : " + Act_Gmail1, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Email ID was : " + Email + " || Actual Email ID was : " + Act_Gmail1);
			Extent_fail(driver,
					"Not Matched || Expected Email ID was: " + Email + " || Actual Email ID was : " + Act_Gmail1, test,
					test1);
		}

		waitForElement(driver, EC_HLC_Grid_Phone_Input_Field);
		String Act_Phone1 = getText(driver, EC_HLC_Grid_Phone_Input_Field);

		if (Act_Phone1.equals(Phone)) {
			System.out.println(
					"Matched || Expected phone number was : " + Phone + " || Actual phone number was : " + Act_Phone1);
			Extent_pass_New(driver,
					"Matched || Expected phone number was: " + Phone + " || Actual phone number was : " + Act_Phone1,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected phone number was : " + Phone + " || Actual phone number was : "
					+ Act_Phone1);
			Extent_fail(driver, "Not Matched || Expected phone number was: " + Phone + " || Actual phone number was : "
					+ Act_Phone1, test, test1);
		}

		if (AgencyUser_Perform.equalsIgnoreCase("YES")) {
			Extent_call(test, test1, "***Agency users can access the  Ecom commodity restriction***");
		}
		if (AgencyUser_Perform.equalsIgnoreCase("NO")) {
			Extent_call(test, test1, "***Line users can access the  Ecom commodity restriction***");
		}
		Step_End(2, " Line and Agency users can access the Ecomm Hot Line Contacts module.", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
