package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS006 extends Keywords {

	public void Agency_Master_TS006(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Agency_Master_TS006";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String BranchCode_PopupMessage = Excel_data.get("BranchCode_PopupMessage");
		String BranchCode = Excel_data.get("BranchCode");
		String CarrierCode_PopupMessage = Excel_data.get("CarrierCode_PopupMessage");
		String AgencyType = Excel_data.get("AgencyType");
		String AgencyCode_PopupMessage = Excel_data.get("AgencyCode_PopupMessage");
		String Agency_code = Excel_data.get("Agency_code");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String CarrierCode = Excel_data.get("CarrierCode");
		String AgencyType_PopupMessage = Excel_data.get("AgencyType_PopupMessage");
		String Address_PopupMessage = Excel_data.get("Address_PopupMessage");
		String Address = Excel_data.get("Address");
		String City_PopupMessage = Excel_data.get("City_PopupMessage");
		String City = Excel_data.get("City");
		String CountryCode_PopupMessage = Excel_data.get("CountryCode_PopupMessage");
		String CountryCode = Excel_data.get("CountryCode");
		String UNPort_PopupMessage = Excel_data.get("UNPort_PopupMessage");
		String UNPort = Excel_data.get("UNPort");
		String CurrencyCode_PopupMessage = Excel_data.get("CurrencyCode_PopupMessage");
		String CurrencyCode = Excel_data.get("CurrencyCode");
		String Countyphonecode_PopupMessage = Excel_data.get("Countryphonecode_PopupMessage");
		String Countryphonecode = Excel_data.get("Countryphonecode");
		String Phonenumber = Excel_data.get("Phonenumber");
		String CountryFax_PopupMessage = Excel_data.get("CountryFax_PopupMessage");
		String Faxnumber = Excel_data.get("Faxnumber");
		String CountryFaxcode = Excel_data.get("CountryFaxcode");
		String EmailAddress_PopupMessage = Excel_data.get("EmailAddress_PopupMessage");
		String Agency_Type_Header = Excel_data.get("Agency_Type_Header");
		String Carrier_Code_Header = Excel_data.get("Carrier_Code_Header");
		String Country_Code_header = Excel_data.get("Country_Code_header");
		String UN_Port_Code_Header = Excel_data.get("UN_Port_Code_Header");
		String Currency_Code_header = Excel_data.get("Currency_Code_header");
		String Agency_Code_header = Excel_data.get("Agency_Code_header");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "Click on the New button in the above tool bar", test, test1);

		newButton(driver);

		Step_End(1, "Click on the New button in the above tool bar", test, test1);

		Step_Start(2,
				"If user left the BRANCH CODE field as blank and click on save button, the validation message  of 'Enter the Corporate Code' should be shown",
				test, test1);

		waitForElement(driver, TypeDropdown);
		click(driver, TypeDropdown);

		waitForElement(driver, SelectBranch);
		click(driver, SelectBranch);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, BranchCode_PopupMessage);

		String BranchCode_popup = getText(driver, popup_Message);

		if (BranchCode_PopupMessage.equals(BranchCode_popup)) {

			System.out.println(
					"Matched || Expected :After clicking save and leaving the Branch code Field blank, User should get  the error message as : "
							+ BranchCode_PopupMessage
							+ " Actual error message : After clicking save and leaving the Branch code Field blank, User got the error message as"
							+ BranchCode_popup);
			Extent_pass_New(driver,
					"Matched || Expected :After clicking save and leaving the Branch code Field blank, User should get  the error message as  "
							+ BranchCode_PopupMessage
							+ " Actual error message : After clicking save and leaving the Branch code Field blank, User got the error message as"
							+ BranchCode_popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected :After clicking save and leaving the Branch code Field blank, User should get  the error message as : "
							+ BranchCode_PopupMessage
							+ " Actual error message :After clicking save and leaving the Branch code Field blank, User didn't got the error message as "
							+ BranchCode_popup);
			Extent_fail(driver,
					"Not Matched || Expected :After clicking save and leaving the Branch code Field blank, User should get  the error message as :  "
							+ BranchCode_PopupMessage
							+ " Actual error message :After clicking save and leaving the Branch code Field blank, User didn't got the error message as "
							+ BranchCode_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(2,
				"If user left the BRANCH CODE field as blank and click on save button, the validation message  of 'Enter the Corporate Code' should be shown",
				test, test1);

		Step_Start(3,
				"If user left the AGENCY Type field as blank and click on save button, the validation message  of 'Kindly select the Agency type' should be shown",
				test, test1);

		waitForElement(driver, BranchCodeInput);
		sendKeys(driver, BranchCodeInput, BranchCode);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, AgencyType_PopupMessage);
		String AgencyType_popup = getText(driver, popup_Message);

		if (AgencyType_PopupMessage.equals(AgencyType_popup)) {

			System.out.println(
					"Matched || Expected :After clicking save and leaving the Agency Type Field blank, the user should get error message: "
							+ AgencyType_PopupMessage
							+ " Actual error message was :After clicking save and leaving the Agency Type Field blank, the user  got the error message"
							+ AgencyType_popup);
			Extent_pass_New(driver,
					"Matched || Expected :After clicking save and leaving the Agency Type Field blank, the user should get error message: "
							+ AgencyType_PopupMessage
							+ " Actual error message was :After clicking save and leaving the Agency Type Field blank, the user  got the error message"
							+ AgencyType_popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected :After clicking save and leaving the Agency Type Field blank, the user should get error message: "
							+ AgencyType_PopupMessage
							+ " Actual error message was :After clicking save and leaving the Agency Type Field blank, the user didn't get error message"
							+ AgencyType_popup);
			Extent_fail(driver,
					"Not Matched || Expected :After clicking save and leaving the Agency Type Field blank, the user should get error message: "
							+ AgencyType_PopupMessage
							+ " Actual error message was :After clicking save and leaving the Agency Type Field blank, the user didn't get error message"
							+ AgencyType_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(3,
				"If user left the AGENCY Type field as blank and click on save button, the validation message  of 'Kindly select the Agency type' should be shown",
				test, test1);

		Step_Start(4,
				"If user left the AGENCY CODE field as blank and click on save button, the validation message  of 'Kindly select the Agency code' should be shown",
				test, test1);

		waitForElement(driver, Search_Agency);
		click(driver, Search_Agency);

		twoColumnSearchWindow(driver, Agency_Type_Header, Filter_Condition, AgencyType);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, AgencyCode_PopupMessage);
		String AgencyCode_popup = getText(driver, popup_Message);

		if (AgencyCode_PopupMessage.equals(AgencyCode_popup)) {

			System.out.println(
					"Matched || Expected:If user left the AGENCY CODE field as blank and click on save button, the validation message  of 'Kindly select the Agency code' should be shown: "
							+ AgencyCode_PopupMessage
							+ " Actual error message was :If user left the AGENCY CODE field as blank and click on save button,user got the validation message is"
							+ AgencyCode_popup);
			Extent_pass_New(driver,
					"Matched || Expected :If user left the AGENCY CODE field as blank and click on save button, the validation message  of 'Kindly select the Agency code' should be shown: "
							+ AgencyCode_PopupMessage
							+ " Actual error message was :If user left the AGENCY CODE field as blank and click on save button,user got the validation message is"
							+ AgencyCode_popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected :If user left the AGENCY CODE field as blank and click on save button, the validation message  of 'Kindly select the Agency code' should be shown: "
							+ AgencyCode_PopupMessage
							+ " Actual error message was :If user left the AGENCY CODE field as blank and click on save button,user didn't get the validation message is"
							+ AgencyCode_popup);
			Extent_fail(driver,
					"Not Matched || Expected: If user left the AGENCY CODE field as blank and click on save button, the validation message  of 'Kindly select the Agency code' should be shown "
							+ AgencyCode_PopupMessage
							+ " Actual error message was :If user left the AGENCY CODE field as blank and click on save button,user didn't get the validation message is"
							+ AgencyCode_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4,
				"If user left the AGENCY CODE field as blank and click on save button, the validation message  of 'Kindly select the Agency code' should be shown",
				test, test1);

		Step_Start(5,
				"If user left the Carrier code  field as blank and click on save button, the validation message  of 'Enter the Carrier Code' should be shown",
				test, test1);

		waitForElement(driver, BranchAgencyCode_Search);
		click(driver, BranchAgencyCode_Search);

		twoColumnSearchWindow(driver, Agency_Code_header, Filter_Condition, Agency_code);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, CarrierCode_PopupMessage);
		String CarrierCode_popup = getText(driver, popup_Message);

		if (CarrierCode_PopupMessage.equals(CarrierCode_popup)) {

			System.out.println(
					"Matched || Expected : After clicking save and leaving the Carrier Code Field blank, the user should get error message: "
							+ CarrierCode_PopupMessage
							+ "Actual error message :After clicking save and leaving the Carrier Code Field blank, the user  got the error message:"
							+ CarrierCode_popup);
			Extent_pass_New(driver,
					"Matched || Expected : After clicking save and leaving the Carrier Code Field blank, the user received an error message and the expected error message: "
							+ CarrierCode_PopupMessage
							+ "Actual error message :After clicking save and leaving the Carrier Code Field blank, the user  got the error message:"
							+ CarrierCode_popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected:  After clicking save and leaving the Carrier Code Field blank, the user should get error message: "
							+ CarrierCode_PopupMessage
							+ "Actual error message :After clicking save and leaving the Carrier Code Field blank, the user didn't got the error message"
							+ CarrierCode_popup);
			Extent_fail(driver,
					"Not Matched || Expected: After clicking save and leaving the Carrier Code Field blank, the user should get error message: "
							+ CarrierCode_PopupMessage
							+ "Actual error message :After clicking save and leaving the Carrier Code Field blank, the user didn't got the error message"
							+ CarrierCode_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, CorporateNameInput);
		click(driver, CarrierCode_search);

		twoColumnSearchWindow(driver, Carrier_Code_Header, Filter_Condition, CarrierCode);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Address_PopupMessage);
		String Address_popup = getText(driver, popup_Message);

		if (Address_popup.equals(Address_PopupMessage)) {

			System.out.println(
					"Matched || Expected: After clicking save and leaving the Address Field blank, the user should recieve an error message: "
							+ Address_PopupMessage
							+ "Actual error message :After clicking save and leaving the Carrier Code Field blank, the user recieved the error message"
							+ Address_popup);
			Extent_pass_New(driver,
					"Matched || Expected: After clicking save and leaving the Address Field blank, the user should recieve an error message: "
							+ Address_PopupMessage
							+ "Actual error message :After clicking save and leaving the Carrier Code Field blank, the user recieved the error message"
							+ Address_popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Address_PopupMessage :After clicking save and leaving the Address Field blank, the user should recieve an error message: "
							+ Address_PopupMessage
							+ "Actual error message :After clicking save and leaving the Carrier Code Field blank, the user didn't recieve the error message"
							+ Address_popup);
			Extent_fail(driver,
					"Not Matched || Expected :After clicking save and leaving the Address Field blank, the user should recieve an error message: "
							+ Address_PopupMessage
							+ "Actual error message :After clicking save and leaving the Carrier Code Field blank, the user didn't recieve the error message"
							+ Address_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(6,
				"If user left the Address  field as blank and click on save button, the validation message  of 'Enter the Address' should be shown",
				test, test1);

		Step_Start(7,
				"If user left the CITY  field as blank and click on save button, the validation message  of 'Enter the City Name' should be shown",
				test, test1);

		waitForElement(driver, Address_Input);
		sendKeys(driver, Address_Input, Address);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, City_PopupMessage);
		String City_Popup = getText(driver, popup_Message);

		if (City_Popup.equals(City_PopupMessage)) {

			System.out.println(
					"Matched || Expected: After clicking save and leaving the City Field blank, user should recieve an error messagee: "
							+ City_PopupMessage
							+ " Actual message was :After clicking save and leaving the City Field blank, user  recieved an error message: "
							+ City_Popup);
			Extent_pass_New(driver,
					"Matched || Expected :After clicking save and leaving the City Field blank, user should recieve an error message: "
							+ City_PopupMessage
							+ " Actual message was :After clicking save and leaving the City Field blank, user  recieved an error message "
							+ City_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected: After clicking save and leaving the City Field blank,user should recieve an error message: "
							+ City_PopupMessage
							+ " Actual message was : After clicking save and leaving the City Field blank, user didn't recieved an error message"
							+ City_Popup);
			Extent_fail(driver,
					"Not Matched || Expected :After clicking save and leaving the City Field blank, user should recieve an error message: "
							+ City_PopupMessage
							+ " Actual message was : After clicking save and leaving the City Field blank, user didn't recieved an error message"
							+ City_Popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(7,
				"If user left the CITY  field as blank and click on save button, the validation message  of 'Enter the City Name' should be shown",
				test, test1);

		Step_Start(8,
				"If user left the COUNTRY  field as blank and click on save button, the validation message  of 'Enter the Country Code' should be shown",
				test, test1);

		waitForElement(driver, City_Input);
		sendKeys(driver, City_Input, City);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, CountryCode_PopupMessage);
		String Country_Code = getText(driver, popup_Message);

		if (Country_Code.equals(CountryCode_PopupMessage)) {

			System.out.println(
					"Matched || Expected: After clicking save and leaving the Country_Code Field blank, user should recieve an error message: "
							+ CountryCode_PopupMessage
							+ " Actual message :After clicking save and leaving the Country_Code Field blank, user should got an error message "
							+ Country_Code);
			Extent_pass_New(driver,
					"Matched || Expected :After clicking save and leaving the Country_Code Field blank, user should recieve an error message: "
							+ CountryCode_PopupMessage
							+ " Actual message : After clicking save and leaving the Country_Code Field blank, user should got an error message"
							+ Country_Code,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected : After clicking save and leaving the Country_Code Field blank, user should recieve an error message: "
							+ CountryCode_PopupMessage
							+ " Actual message :After clicking save and leaving the Country_Code Field blank, user didn't get an error message "
							+ Country_Code);
			Extent_fail(driver,
					"Not Matched || Expected :After clicking save and leaving the Country_Code Field blank, user should recieve an error message: "
							+ CountryCode_PopupMessage
							+ " Actual message :After clicking save and leaving the Country_Code Field blank, user didn't get an error message "
							+ Country_Code,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(9,
				"If user left the Currency code  field as blank and click on save button, the validation message  of 'Enter the Currency Code' should be shown",
				test, test1);

		Step_Start(10,
				"If user left the UN Port Code  field as blank and click on save button, the validation message  of 'Enter the UN Port Code' should be shown.",
				test, test1);

		waitForElement(driver, CountrySearch);
		click(driver, CountrySearch);

		twoColumnSearchWindow(driver, Country_Code_header, Filter_Condition, CountryCode);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, UNPort_PopupMessage);
		String UNPortpopup = getText(driver, popup_Message);

		if (UNPortpopup.equals(UNPort_PopupMessage)) {

			System.out.println(
					"Matched || Expected :After clicking save and leaving the UN Port Code Field blank, user should recieve an error message: "
							+ " Actual error message :After clicking save and leaving the UN Port Code Field blank, user recieve an error message:"
							+ UNPortpopup);
			Extent_pass_New(driver,
					"Matched || Expected :After clicking save and leaving the UN Port Code Field blank, user should recieve an error message: "
							+ " Actual error message :After clicking save and leaving the UN Port Code Field blank, user recieve an error message:"
							+ UNPortpopup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected: After clicking save and leaving the UN Port Code Field blank,user should recieve an error message: "
							+ " Actual error message :After clicking save and leaving the UN Port Code Field blank, user didn't recieved an error message:"
							+ UNPortpopup);
			Extent_fail(driver,
					"Not Matched || Expected: After clicking save and leaving the UN Port Code Field blank, user should recieve an error message: "
							+ " Actual error message :After clicking save and leaving the UN Port Code Field blank, user didn't recieved an error message:"
							+ UNPortpopup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(10,
				"If user left the UN Port Code  field as blank and click on save button, the validation message  of 'Enter the UN Port Code' should be shown.",
				test, test1);

		Step_Start(11,
				"If user left the Currency code  field as blank and click on save button, the validation message  of 'Enter the Currency Code' should be shown",
				test, test1);

		waitForElement(driver, UNPort_Search);
		click(driver, UNPort_Search);

		twoColumnSearchWindow(driver, UN_Port_Code_Header, Filter_Condition, UNPort);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, CurrencyCode_PopupMessage);
		String CurrecyCode_Popup = getText(driver, popup_Message);

		if (CurrecyCode_Popup.equals(CurrencyCode_PopupMessage)) {

			System.out.println(
					"Matched || Expected: After clicking save and leaving the CurrencyCode Field blank, user should recieve an error message: "
							+ CurrencyCode_PopupMessage
							+ " Actual popup message :After clicking save and leaving the CurrencyCode Field blank, user recieved error message:"
							+ CurrecyCode_Popup);
			Extent_pass_New(driver,
					"Matched || Expected: After clicking save and leaving the CurrencyCode Field blank, user should recieve an error message: "
							+ CurrencyCode_PopupMessage
							+ " Actual popup message :After clicking save and leaving the CurrencyCode Field blank, user recieved error message"
							+ CurrecyCode_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected: After clicking save and leaving the CurrencyCode Field blank, user should recieve an error message: "
							+ CurrencyCode_PopupMessage
							+ " Actual popup message :After clicking save and leaving the CurrencyCode Field blank, user didn't recieve error message:"
							+ CurrecyCode_Popup);
			Extent_fail(driver,
					"Not Matched || Expected: After clicking save and leaving the CurrencyCode Field blank, user should recieve an error message: "
							+ CurrencyCode_PopupMessage
							+ " Actual popup message :After clicking save and leaving the CurrencyCode Field blank, user didn't recieve error message:"
							+ CurrecyCode_Popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(11,
				"If user left the Currency code  field as blank and click on save button, the validation message  of 'Enter the Currency Code' should be shown",
				test, test1);

		Step_Start(12,
				".If user left the  Phone+  field as blank and click on save button, the validation message  of 'Enter the Country Code (Phone)' should be shown",
				test, test1);

		waitForElement(driver, CurrencyCode_Search);
		click(driver, CurrencyCode_Search);

		twoColumnSearchWindow(driver, Currency_Code_header, Filter_Condition, CurrencyCode);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Countyphonecode_PopupMessage);
		String CountryPhonecode_popup = getText(driver, popup_Message);

		if (CountryPhonecode_popup.equals(Countyphonecode_PopupMessage)) {

			System.out.println(
					"Matched || Expected:After clicking save and leaving the Country Phone Code Field blank, the user should recieve error message: "
							+ Countyphonecode_PopupMessage
							+ " Actual error message :After clicking save and leaving the Country Phone Code Field blank, the user got the error message as"
							+ CountryPhonecode_popup);
			Extent_pass_New(driver,
					"Matched || Expected:After clicking save and leaving the Country Phone Code Field blank, the user should recieve error message: "
							+ CountryPhonecode_popup
							+ " Actual error message :After clicking save and leaving the Country Phone Code Field blank, the user got the error message as"
							+ CountryPhonecode_popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected:After clicking save and leaving the Country Phone Code Field blank, the user should recieve error message: "
							+ Countyphonecode_PopupMessage
							+ " Actual error message :After clicking save and leaving the Country Phone Code Field blank, the user didn't get the error message as"
							+ CountryPhonecode_popup);
			Extent_fail(driver,
					"Not Matched || Expected:After clicking save and leaving the Country Phone Code Field blank, the user should recieve error message: "
							+ Countyphonecode_PopupMessage
							+ " Actual error message :After clicking save and leaving the Country Phone Code Field blank, the user didn't get the error message as"
							+ CountryPhonecode_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(12,
				".If user left the  Phone+  field as blank and click on save button, the validation message  of 'Enter the Country Code (Phone)' should be shown",
				test, test1);

		Step_Start(13,
				"..If user left the Fax+  field as blank and click on save button, the validation message  of 'Enter the Country Code (FAX)' should be shown.",
				test, test1);

		waitForElement(driver, Ph_countryCode);
		sendKeys(driver, Ph_countryCode, Countryphonecode);

		waitForElement(driver, PhoneNumber_input);
		sendKeys(driver, PhoneNumber_input, Phonenumber);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, CountryFax_PopupMessage);
		String Fax_popup = getText(driver, popup_Message);

		if (Fax_popup.equals(CountryFax_PopupMessage)) {

			System.out.println(
					"Matched || Expected:After clicking save and leaving the Country Fax Code Field blank, the user should recieve error message: "
							+ CountryFax_PopupMessage
							+ " Acutal error message :After clicking save and leaving the Country Fax Code Field blank, the user got the error message:"
							+ Fax_popup);
			Extent_pass_New(driver,
					"Matched || Expected:After clicking save and leaving the Country Fax Code Field blank, the user should recieve error message: "
							+ CountryFax_PopupMessage
							+ " Acutal error message :After clicking save and leaving the Country Fax Code Field blank, the user got the error message: "
							+ Fax_popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected:After clicking save and leaving the Country Fax Code Field blank, the user should recieve error message: "
							+ CountryFax_PopupMessage
							+ " Acutal error message :After clicking save and leaving the Country Fax Code Field blank, the user didn't got the error message "
							+ Fax_popup);
			Extent_fail(driver,
					"Not Matched || Expected:After clicking save and leaving the Country Fax Code Field blank,the user should recieve error message: "
							+ CountryFax_PopupMessage
							+ " Acutal error message :After clicking save and leaving the Country Fax Code Field blank, the user didn't got the error message "
							+ Fax_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(13,
				"..If user left the Fax+  field as blank and click on save button, the validation message  of 'Enter the Country Code (FAX)' should be shown.",
				test, test1);

		Step_Start(14,
				"If user left the Email field as blank and click on save button, the validation message  of 'Enter the Email Address' should be shown",
				test, test1);

		waitForElement(driver, FaxCode_input);
		sendKeys(driver, FaxCode_input, CountryFaxcode);

		waitForElement(driver, Fax_input);
		sendKeys(driver, Fax_input, Faxnumber);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, EmailAddress_PopupMessage);
		String Email_popup = getText(driver, popup_Message);

		if (Email_popup.equals(EmailAddress_PopupMessage)) {

			System.out.println(
					"Matched || Expected:After clicking save and leaving the Email field blank, the user should recieve error message: "
							+ EmailAddress_PopupMessage
							+ " Actual error message :After clicking save and leaving the Email field blank, the user got the error message"
							+ Email_popup);
			Extent_pass_New(driver,
					"Matched || Expected:After clicking save and leaving the Email field blank, the user should recieve error message: "
							+ EmailAddress_PopupMessage
							+ " Actual error message :After clicking save and leaving the Email field blank, the user got the error message"
							+ Email_popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected:After clicking save and leaving the Email field blank,the user should recieve error message: "
							+ EmailAddress_PopupMessage
							+ " Actual error message :After clicking save and leaving the Email field blank, the user didn't got the error message"
							+ Email_popup);
			Extent_fail(driver,
					"Not Matched || Expected:After clicking save and leaving the Email field blank, the user should recieve error message: "
							+ EmailAddress_PopupMessage
							+ " Actual error message :After clicking save and leaving the Email field blank, the user didn't got the error message"
							+ Email_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(14,
				"If user left the Email field as blank and click on save button, the validation message  of 'Enter the Email Address' should be shown",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
