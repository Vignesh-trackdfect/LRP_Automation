package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS001 extends Keywords {

	public void Agency_Master_TS001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Agency_Master_TS001";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String CorporateCode_PopupMessage = Excel_data.get("CorporateCode_PopupMessage");
		String AgencyCode = Excel_data.get("AgencyCode");
		String AgencyType_PopupMessage = Excel_data.get("AgencyType_PopupMessage");
		String Agency_Type_Header = Excel_data.get("Agency_Type_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String AgencyType = Excel_data.get("AgencyType");
		String CorporateName_PopupMessage = Excel_data.get("CorporateName_PopupMessage");
		String CorporateName = Excel_data.get("CorporateName");
		String CarrierCode_PopupMessage = Excel_data.get("CarrierCode_PopupMessage");
		String Carrier_Code_Header = Excel_data.get("Carrier_Code_Header");
		String CarrierCode = Excel_data.get("CarrierCode");
		String Address_PopupMessage = Excel_data.get("Address_PopupMessage");
		String Address = Excel_data.get("Address");
		String City_PopupMessage = Excel_data.get("City_PopupMessage");
		String City = Excel_data.get("City");
		String CountryCode_PopupMessage = Excel_data.get("CountryCode_PopupMessage");
		String Country_Code_header = Excel_data.get("Country_Code_header");
		String CountryCode = Excel_data.get("CountryCode");
		String UNPort_PopupMessage = Excel_data.get("UNPort_PopupMessage");
		String UN_Port_Code_Header = Excel_data.get("UN_Port_Code_Header");
		String UNPort = Excel_data.get("UNPort");
		String CurrencyCode_PopupMessage = Excel_data.get("CurrencyCode_PopupMessage");
		String Currency_Code_header = Excel_data.get("Currency_Code_header");
		String CurrencyCode = Excel_data.get("CurrencyCode");
		String Countyphonecode_PopupMessage = Excel_data.get("Countryphonecode_PopupMessage");
		String Countryphonecode = Excel_data.get("Countryphonecode");
		String Phonenumber = Excel_data.get("Phonenumber");
		String CountryFax_PopupMessage = Excel_data.get("CountryFax_PopupMessage");
		String Faxnumber = Excel_data.get("Faxnumber");
		String CountryFaxcode = Excel_data.get("CountryFaxcode");
		String EmailAddress_PopupMessage = Excel_data.get("EmailAddress_PopupMessage");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "Click on the New button in the above tool bar", test, test1);

		newButton(driver);

		Step_End(1, "Click on the New button in the above tool bar", test, test1);

		Step_Start(2,
				"If user left the CORPORATE CODE field as blank and click on save button, the validation message  of  Enter the Corporate Code should be shown",
				test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, CorporateCode_PopupMessage);

		String CorporateCode_popup = getText(driver, popup_Message);

		if (CorporateCode_PopupMessage.equals(CorporateCode_popup)) {

			System.out.println(
					"Matched || Expected result is :  After clicking save and leaving the CORPORATE CODE Field blank, the user should receive an error message and the error message is : "
							+ CorporateCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CORPORATE CODE Field blank, the user received an error message and the error message is : "
							+ CorporateCode_popup);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the CORPORATE CODE Field blank, the user should receive an error message and the error message is : "
							+ CorporateCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CORPORATE CODE Field blank, the user received an error message and the error message is : "
							+ CorporateCode_popup,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the CORPORATE CODE Field blank, the user should receive an error message and the error message is : "
							+ CorporateCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CORPORATE CODE Field blank, the user received an error message and the error message is : "
							+ CorporateCode_popup);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the CORPORATE CODE Field blank, the user should receive an error message and the error message is : "
							+ CorporateCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CORPORATE CODE Field blank, the user didn't received the expected error message and the error message is : "
							+ CorporateCode_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(2,
				"If user left the CORPORATE CODE field as blank and click on save button, the validation message  of  Enter the Corporate Code should be shown",
				test, test1);

		Step_Start(3,
				"If user left the AGENCY Type field as blank and click on save button, the validation message  of Kindly select the Agency Type should be shown",
				test, test1);

		waitForElement(driver, AgencyCodeInput);
		sendKeys(driver, AgencyCodeInput, AgencyCode);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, AgencyType_PopupMessage);

		String AgencyType_popup = getText(driver, popup_Message);

		if (AgencyType_PopupMessage.equals(AgencyType_popup)) {

			System.out.println(
					"Matched || Expected result is :  After clicking save and leaving the AGENCY TYPE Field is not selected, the user should receive an error message and the error message is : "
							+ AgencyType_PopupMessage
							+ " Actual result is :  After clicking save and leaving the AGENCY TYPE Field is not selected, the user received an error message and the error message is : "
							+ AgencyType_popup);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the AGENCY TYPE Field is not selected, the user should receive an error message and the error message is : "
							+ AgencyType_PopupMessage
							+ " Actual result is :  After clicking save and leaving the AGENCY TYPE Field is not selected, the user received an error message and the error message is : "
							+ AgencyType_popup,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the AGENCY TYPE Field is not selected, the user should receive an error message and the error message is : "
							+ AgencyType_PopupMessage
							+ " Actual result is :  After clicking save and leaving the AGENCY TYPE Field is not selected, the user received an error message and the error message is : "
							+ AgencyType_popup);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the AGENCY TYPE is not selected blank, the user should receive an error message and the error message is : "
							+ AgencyType_PopupMessage
							+ " Actual result is :  After clicking save and leaving the AGENCY TYPE Field is not selected, the user didn't received the expected error message and the error message is : "
							+ AgencyType_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(3,
				"If user left the AGENCY Type field as blank and click on save button, the validation message  of Kindly select the Agency Type should be shown",
				test, test1);

		Step_Start(4,
				"If user left the CORPORATE Name  field as blank and click on save button, the validation message  of Enter the Corporate Name should be shown",
				test, test1);

		waitForElement(driver, Search_Agency);
		click(driver, Search_Agency);

		twoColumnSearchWindow(driver, Agency_Type_Header, Filter_Condition, AgencyType);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, CorporateName_PopupMessage);

		String CorporateName_popup = getText(driver, popup_Message);

		if (CorporateName_PopupMessage.equals(CorporateName_popup)) {

			System.out.println(
					"Matched || Expected result is :  After clicking save and leaving the CORPORATE NAME Field blank, the user should receive an error message and the error message is : "
							+ CorporateName_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CORPORATE NAME Field blank, the user received an error message and the error message is : "
							+ CorporateName_popup);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the CORPORATE NAME Field blank, the user should receive an error message and the error message is : "
							+ CorporateName_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CORPORATE NAME Field blank, the user received an error message and the error message is : "
							+ CorporateName_popup,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the CORPORATE NAME Field blank, the user should receive an error message and the error message is : "
							+ CorporateName_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CORPORATE NAME Field blank, the user received an error message and the error message is : "
							+ CorporateName_popup);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the CORPORATE NAME Field blank, the user should receive an error message and the error message is : "
							+ CorporateName_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CORPORATE NAME Field blank, the user didn't received the expected error message and the error message is : "
							+ CorporateName_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4,
				"If user left the CORPORATE Name  field as blank and click on save button, the validation message  of Enter the Corporate Name should be shown",
				test, test1);

		Step_Start(5,
				"If user left the Carrier code  field as blank and click on save button, the validation message of Enter the Carrier Code should be shown",
				test, test1);

		waitForElement(driver, CorporateNameInput);
		sendKeys(driver, CorporateNameInput, CorporateName);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, CarrierCode_PopupMessage);

		String CarrierCode_popup = getText(driver, popup_Message);

		if (CarrierCode_PopupMessage.equals(CarrierCode_popup)) {

			System.out.println(
					"Matched || Expected result is :  After clicking save and leaving the Carrier Code Field blank, the user should receive an error message and the error message is : "
							+ CarrierCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Carrier Code Field blank, the user received an error message and the error message is : "
							+ CarrierCode_popup);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the Carrier Code Field blank, the user should receive an error message and the error message is : "
							+ CarrierCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Carrier Code Field blank, the user received an error message and the error message is : "
							+ CarrierCode_popup,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the Carrier Code Field blank, the user should receive an error message and the error message is : "
							+ CarrierCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Carrier Code Field blank, the user received an error message and the error message is : "
							+ CarrierCode_popup);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the Carrier Code Field blank, the user should receive an error message and the error message is : "
							+ CarrierCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Carrier Code Field blank, the user didn't received the expected error message and the error message is : "
							+ CarrierCode_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(5,
				"If user left the Carrier code  field as blank and click on save button, the validation message of Enter the Carrier Code should be shown",
				test, test1);

		Step_Start(6,
				"If user left the Address  field as blank and click on save button, the validation message of  Enter the Address should be shown",
				test, test1);

		waitForElement(driver, CorporateNameInput);
		click(driver, CarrierCode_search);

		twoColumnSearchWindow(driver, Carrier_Code_Header, Filter_Condition, CarrierCode);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Address_PopupMessage);

		String Address_popup = getText(driver, popup_Message);

		if (Address_popup.equals(Address_PopupMessage)) {

			System.out.println(
					"Matched || Expected result is :  After clicking save and leaving the Address Field blank, the user should receive an error message and the error message is : "
							+ Address_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Address Field blank, the user received an error message and the error message is : "
							+ Address_popup);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the Address Field blank, the user should receive an error message and the error message is : "
							+ Address_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Address Field blank, the user received an error message and the error message is : "
							+ Address_popup,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the Address Field blank, the user should receive an error message and the error message is : "
							+ Address_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Address Field blank, the user received an error message and the error message is : "
							+ Address_popup);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the Address Field blank, the user should receive an error message and the error message is : "
							+ Address_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Address Field blank, the user didn't received the expected error message and the error message is : "
							+ Address_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(6,
				"If user left the Address  field as blank and click on save button, the validation message of  Enter the Address should be shown",
				test, test1);

		Step_Start(7,
				"If user left the CITY  field as blank and click on save button, the validation message  of Enter the City Name should be shown",
				test, test1);

		waitForElement(driver, Address_Input);
		sendKeys(driver, Address_Input, Address);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, City_PopupMessage);

		String City_Popup = getText(driver, popup_Message);

		if (City_Popup.equals(City_PopupMessage)) {

			System.out.println(
					"Matched || Expected result is :  After clicking save and leaving the CITY Field blank, the user should receive an error message and the error message is : "
							+ City_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CITY Field blank, the user received an error message and the error message is : "
							+ City_Popup);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the CITY Field blank, the user should receive an error message and the error message is : "
							+ City_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CITY Field blank, the user received an error message and the error message is : "
							+ City_Popup,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the CITY Field blank, the user should receive an error message and the error message is : "
							+ City_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CITY Field blank, the user received an error message and the error message is : "
							+ City_Popup);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the CITY Field blank, the user should receive an error message and the error message is : "
							+ City_PopupMessage
							+ " Actual result is :  After clicking save and leaving the CITY Field blank, the user didn't received the expected error message and the error message is : "
							+ City_Popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(7,
				"If user left the CITY  field as blank and click on save button, the validation message  of Enter the City Name should be shown",
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
					"Matched || Expected result is :  After clicking save and leaving the COUNTRY Field blank, the user should receive an error message and the error message is : "
							+ CountryCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the COUNTRY Field blank, the user received an error message and the error message is : "
							+ Country_Code);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the COUNTRY Field blank, the user should receive an error message and the error message is : "
							+ CountryCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the COUNTRY Field blank, the user received an error message and the error message is : "
							+ Country_Code,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the COUNTRY Field blank, the user should receive an error message and the error message is : "
							+ CountryCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the COUNTRY Field blank, the user received an error message and the error message is : "
							+ Country_Code);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the COUNTRY Field blank, the user should receive an error message and the error message is : "
							+ CountryCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the COUNTRY Field blank, the user didn't received the expected error message and the error message is : "
							+ Country_Code,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(8,
				"If user left the COUNTRY  field as blank and click on save button, the validation message  of 'Enter the Country Code' should be shown",
				test, test1);

		Step_Start(9,
				"If user left the UN Port Code  field as blank and click on save button, the validation message  of ' Enter the UN Port Code' should be shown",
				test, test1);

		waitForElement(driver, CountrySearch);
		click(driver, CountrySearch);

		twoColumnSearchWindow(driver, Country_Code_header, Filter_Condition, CountryCode);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Country_Code);
		String UNPortpopup = getText(driver, popup_Message);

		if (UNPortpopup.equals(UNPort_PopupMessage)) {

			System.out.println(
					"Matched || Expected result is :  After clicking save and leaving the UN Port Code Field blank, the user should receive an error message and the error message is : "
							+ UNPort_PopupMessage
							+ " Actual result is :  After clicking save and leaving the UN Port Code Field blank, the user received an error message and the error message is : "
							+ UNPortpopup);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the UN Port Code Field blank, the user should receive an error message and the error message is : "
							+ UNPort_PopupMessage
							+ " Actual result is :  After clicking save and leaving the UN Port Code Field blank, the user received an error message and the error message is : "
							+ UNPortpopup,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the UN Port Code Field blank, the user should receive an error message and the error message is : "
							+ UNPort_PopupMessage
							+ " Actual result is :  After clicking save and leaving the UN Port Code Field blank, the user received an error message and the error message is : "
							+ UNPortpopup);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the UN Port Code Field blank, the user should receive an error message and the error message is : "
							+ UNPort_PopupMessage
							+ " Actual result is :  After clicking save and leaving the UN Port Code Field blank, the user didn't received the expected error message and the error message is : "
							+ UNPortpopup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(9,
				"If user left the UN Port Code  field as blank and click on save button, the validation message  of ' Enter the UN Port Code' should be shown",
				test, test1);

		Step_Start(10,
				"If user left the Currency code  field as blank and click on save button, the validation message  of ' Enter the Currency Code' should be shown",
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
					"Matched || Expected result is :  After clicking save and leaving the Currency code  Field blank, the user should receive an error message and the error message is : "
							+ CurrencyCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Currency code  Field blank, the user received an error message and the error message is : "
							+ CurrecyCode_Popup);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the Currency code  Field blank, the user should receive an error message and the error message is : "
							+ CurrencyCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Currency code  Field blank, the user received an error message and the error message is : "
							+ CurrecyCode_Popup,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the Currency code  Field blank, the user should receive an error message and the error message is : "
							+ CurrencyCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Currency code  Field blank, the user received an error message and the error message is : "
							+ CurrecyCode_Popup);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the Currency code  Field blank, the user should receive an error message and the error message is : "
							+ CurrencyCode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Currency code  Field blank, the user didn't received the expected error message and the error message is : "
							+ CurrecyCode_Popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(10,
				"If user left the Currency code  field as blank and click on save button, the validation message  of ' Enter the Currency Code' should be shown",
				test, test1);

		Step_Start(11,
				"If user left the  Phone+  field as blank and click on save button, the validation message  of ' Enter the Country Code (Phone)' should be shown",
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
					"Matched || Expected result is :  After clicking save and leaving the Country Phone code  Field blank, the user should receive an error message and the error message is : "
							+ Countyphonecode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Country Phone code  Field blank, the user received an error message and the error message is : "
							+ CountryPhonecode_popup);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the Country Phone code  Field blank, the user should receive an error message and the error message is : "
							+ Countyphonecode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Country Phone code  Field blank, the user received an error message and the error message is : "
							+ CountryPhonecode_popup,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the Country Phone code  Field blank, the user should receive an error message and the error message is : "
							+ Countyphonecode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Country Phone code  Field blank, the user received an error message and the error message is : "
							+ CountryPhonecode_popup);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the Country Phone code  Field blank, the user should receive an error message and the error message is : "
							+ Countyphonecode_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Country Phone code  Field blank, the user didn't received the expected error message and the error message is : "
							+ CountryPhonecode_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(11,
				"If user left the  Phone+  field as blank and click on save button, the validation message  of ' Enter the Country Code (Phone)' should be shown",
				test, test1);

		Step_Start(12,
				".If user left the Fax+  field as blank and click on save button, the validation message  of ' Enter the Country Code (FAX)' should be shown",
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
					"Matched || Expected result is :  After clicking save and leaving the Country Fax code  Field blank, the user should receive an error message and the error message is : "
							+ CountryFax_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Country Fax code  Field blank, the user received an error message and the error message is : "
							+ Fax_popup);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the Country Fax code  Field blank, the user should receive an error message and the error message is : "
							+ CountryFax_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Country Fax code  Field blank, the user received an error message and the error message is : "
							+ Fax_popup,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the Country Fax code  Field blank, the user should receive an error message and the error message is : "
							+ CountryFax_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Country Fax code  Field blank, the user received an error message and the error message is : "
							+ Fax_popup);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the Country Fax code  Field blank, the user should receive an error message and the error message is : "
							+ CountryFax_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Country Fax code  Field blank, the user didn't received the expected error message and the error message is : "
							+ Fax_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(12,
				".If user left the Fax+  field as blank and click on save button, the validation message  of ' Enter the Country Code (FAX)' should be shown",
				test, test1);

		Step_Start(13,
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
					"Matched || Expected result is :  After clicking save and leaving the Email Address  Field blank, the user should receive an error message and the error message is : "
							+ EmailAddress_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Email Address  Field blank, the user received an error message and the error message is : "
							+ Email_popup);
			Extent_pass_New(driver,
					"Matched || Expected result is :  After clicking save and leaving the Email Address  Field blank, the user should receive an error message and the error message is : "
							+ EmailAddress_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Email Address  Field blank, the user received an error message and the error message is : "
							+ Email_popup,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected result is :  After clicking save and leaving the Email Address Field blank, the user should receive an error message and the error message is : "
							+ EmailAddress_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Email Address Field blank, the user received an error message and the error message is : "
							+ Email_popup);
			Extent_fail(driver,
					"Not Matched || Expected result is :  After clicking save and leaving the Email Address Field blank, the user should receive an error message and the error message is : "
							+ EmailAddress_PopupMessage
							+ " Actual result is :  After clicking save and leaving the Email Address Field blank, the user didn't received the expected error message and the error message is : "
							+ Email_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(13,
				"If user left the Email field as blank and click on save button, the validation message  of 'Enter the Email Address' should be shown",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
