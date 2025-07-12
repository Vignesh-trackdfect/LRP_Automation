package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecomm_Hot_Line_Contacts_003 extends Keywords {

	public void Ecomm_Hot_Line_Contacts_003(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecomm_Hot_Line_Contacts_003";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String Contact_Name = Excel_data.get("Contact_Name");
		String Country_Name = Excel_data.get("Country_Name");
		String Email = Excel_data.get("Email");
		String Country_Code = Excel_data.get("Country_Code");
		String Phone = Excel_data.get("Phone");
		String Port_Code_New = Excel_data.get("Port_Code_New");
		String Port_Name_New = Excel_data.get("Port_Name_New");
		String Contact_Name_New = Excel_data.get("Contact_Name_New");
		String Country_Name_New = Excel_data.get("Country_Name_New");
		String Email_New = Excel_data.get("Email");
		String Country_Code_New = Excel_data.get("Country_Code_New");
		String Phone_New = Excel_data.get("Phone_New");
		String Saved_popup_Message = Excel_data.get("Saved_popup_Message");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module_Name);
		Step_Start(1, " The saved contacts are listed below the grid.", test, test1);
		waitForElement(driver, EC_HLC_Condition_Filter);
		click(driver, EC_HLC_Condition_Filter);
		Step_End(1, " The saved contacts are listed below the grid.", test, test1);
		Step_Start(2, "Select a record and double-click it to load its details into the respective fields.", test,
				test1);
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
		waitForElement(driver, EC_HLC_Condition_Phone_Input_Field);
		doubleClick(driver, EC_HLC_Condition_Phone_Input_Field);
		Step_End(2, "Select a record and double-click it to load its details into the respective fields.", test, test1);

		Step_Start(3, "Make any necessary changes..", test, test1);
		if (!Contact_Name_New.equalsIgnoreCase(" ")) {
			waitForElement(driver, EC_HLC_Contact_Name_Input_Field);
			click(driver, EC_HLC_Contact_Name_Input_Field);

			clearAndType(driver, EC_HLC_Contact_Name_Input_Field, Contact_Name_New);
		}

		if (!Country_Name_New.equalsIgnoreCase(" ")) {
			waitForElement(driver, EC_HLC_Country_Name_Input_Field);
			click(driver, EC_HLC_Country_Name_Input_Field);

			clearAndType(driver, EC_HLC_Country_Name_Input_Field, Country_Name_New);
		}

		if (!Country_Code_New.equalsIgnoreCase(" ")) {
			waitForElement(driver, EC_HLC_Country_Code_Input_Field);
			click(driver, EC_HLC_Country_Code_Input_Field);

			clearAndType(driver, EC_HLC_Country_Code_Input_Field, Country_Code_New);

		}
		if (!Phone_New.equalsIgnoreCase(" ")) {
			waitForElement(driver, EC_HLC_Phone_Input_Field);
			click(driver, EC_HLC_Phone_Input_Field);

			clearAndType(driver, EC_HLC_Phone_Input_Field, Phone_New);
		}

		if (!Email_New.equalsIgnoreCase(" ")) {
			waitForElement(driver, EC_HLC_Email_Input_Field);
			click(driver, EC_HLC_Email_Input_Field);

			clearAndType(driver, EC_HLC_Email_Input_Field, Email_New);
		}

		if (!Port_Name_New.equalsIgnoreCase(" ")) {
			waitForElement(driver, EC_HLC_Port_Name_Input_Field);
			click(driver, EC_HLC_Port_Name_Input_Field);

			clearAndType(driver, EC_HLC_Port_Name_Input_Field, Port_Name_New);
		}

		if (!Port_Code_New.equalsIgnoreCase(" ")) {
			waitForElement(driver, EC_HLC_Port_Code_Input_Field);
			click(driver, EC_HLC_Port_Code_Input_Field);

			clearAndType(driver, EC_HLC_Port_Code_Input_Field, Port_Code_New);
		}
		Step_End(3, "Make any necessary changes..", test, test1);
		Step_Start(4, "Click the \"Save\" button.", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(4, "Click the \"Save\" button.", test, test1);

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

		Step_Start(5, "The updated contacts will be displayed in the Ecomm Hot Line Contacts section in eCommerce.",
				test, test1);
		waitForElement(driver, EC_HLC_Condition_Filter);
		click(driver, EC_HLC_Condition_Filter);

		waitForElement(driver, EC_HLC_Condition_Contact_Name_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Contact_Name_Input_Field, Contact_Name_New);

		waitForElement(driver, EC_HLC_Condition_Country_Code_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Country_Code_Input_Field, Country_Code_New);

		waitForElement(driver, EC_HLC_Condition_Country_Name_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Country_Name_Input_Field, Country_Name_New);

		waitForElement(driver, EC_HLC_Condition_Email_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Email_Input_Field, Email_New);

		waitForElement(driver, EC_HLC_Condition_Phone_Input_Field);
		sendKeys(driver, EC_HLC_Condition_Phone_Input_Field, Phone_New);

		waitForElement(driver, EC_HLC_Grid_Contact_Name_Input_Field);
		String Act_Contact_Name = getText(driver, EC_HLC_Grid_Contact_Name_Input_Field);

		if (Act_Contact_Name.equals(Contact_Name_New)) {
			System.out.println("Matched || Expected contact name was : " + Contact_Name_New
					+ " || Actual contact name was : " + Act_Contact_Name);
			Extent_pass_New(driver, "Matched || Expected contact name was: " + Contact_Name_New
					+ " || Actual contact name was : " + Act_Contact_Name, test, test1);
		} else {
			System.out.println("Not Matched || Expected contact name was : " + Contact_Name_New
					+ " || Actual contact name was : " + Act_Contact_Name);
			Extent_fail(driver, "Not Matched || Expected contact name was: " + Contact_Name_New
					+ " || Actual contact name was : " + Act_Contact_Name, test, test1);
		}

		waitForElement(driver, EC_HLC_Grid_Country_Code_Input_Field);
		String Act_Country_Code = getText(driver, EC_HLC_Grid_Country_Code_Input_Field);

		if (Act_Country_Code.equals(Country_Code_New)) {
			System.out.println("Matched || Expected country code was : " + Country_Code_New
					+ " || Actual country code was : " + Act_Country_Code);
			Extent_pass_New(driver, "Matched || Expected country code was: " + Country_Code_New
					+ " || Actual country code was : " + Act_Country_Code, test, test1);
		} else {
			System.out.println("Not Matched || Expected country code was : " + Country_Code_New
					+ " || Actual country code was : " + Act_Country_Code);
			Extent_fail(driver, "Not Matched || Expected country code was: " + Country_Code_New
					+ " || Actual country code was : " + Act_Country_Code, test, test1);
		}

		waitForElement(driver, EC_HLC_Grid_Country_Name_Input_Field);
		String Act_Country_Name = getText(driver, EC_HLC_Grid_Country_Name_Input_Field);

		if (Act_Country_Name.equals(Country_Name_New)) {
			System.out.println("Matched || Expected country name was : " + Country_Name_New
					+ " || Actual country name was : " + Act_Country_Name);
			Extent_pass_New(driver, "Matched || Expected country name was: " + Country_Name_New
					+ " || Actual country name was : " + Act_Country_Name, test, test1);
		} else {
			System.out.println("Not Matched || Expected country name was : " + Country_Name_New
					+ " || Actual country name was : " + Act_Country_Name);
			Extent_fail(driver, "Not Matched || Expected country name was: " + Country_Name_New
					+ " || Actual country name was : " + Act_Country_Name, test, test1);
		}

		waitForElement(driver, EC_HLC_Grid_Email_Input_Field);
		String Act_Gmail = getText(driver, EC_HLC_Grid_Email_Input_Field);

		if (Act_Gmail.equals(Email_New)) {
			System.out.println(
					"Matched || Expected Email ID was : " + Email_New + " || Actual Email ID was : " + Act_Gmail);
			Extent_pass_New(driver,
					"Matched || Expected Email ID was: " + Email_New + " || Actual Email ID was : " + Act_Gmail, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Email ID was : " + Email_New + " || Actual Email ID was : " + Act_Gmail);
			Extent_fail(driver,
					"Not Matched || Expected Email ID was: " + Email_New + " || Actual Email ID was : " + Act_Gmail,
					test, test1);
		}

		waitForElement(driver, EC_HLC_Grid_Phone_Input_Field);
		String Act_Phone = getText(driver, EC_HLC_Grid_Phone_Input_Field);

		if (Act_Phone.equals(Phone_New)) {
			System.out.println("Matched || Expected phone number was : " + Phone_New + " || Actual phone number was : "
					+ Act_Phone);
			Extent_pass_New(driver,
					"Matched || Expected phone number was: " + Phone_New + " || Actual phone number was : " + Act_Phone,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected phone number was : " + Phone_New
					+ " || Actual phone number was : " + Act_Phone);
			Extent_fail(driver, "Not Matched || Expected phone number was: " + Phone_New
					+ " || Actual phone number was : " + Act_Phone, test, test1);
		}

		Step_End(5, "The updated contacts will be displayed in the Ecomm Hot Line Contacts section in eCommerce.", test,
				test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
