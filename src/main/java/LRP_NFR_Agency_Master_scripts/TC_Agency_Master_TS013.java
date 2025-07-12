package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS013 extends Keywords {

	public void Agency_Master_TS013(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Agency_Master_TS013";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String AgencyCode = Excel_data.get("AgencyCode");
		String AgencyType = Excel_data.get("AgencyType");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String CorporateName = Excel_data.get("CorporateName");
		String CarrierCode = Excel_data.get("CarrierCode");
		String Address = Excel_data.get("Address");
		String City = Excel_data.get("City");
		String CountryCode = Excel_data.get("CountryCode");
		String UNPort = Excel_data.get("UNPort");
		String CurrencyCode = Excel_data.get("CurrencyCode");
		String Countryphonecode = Excel_data.get("Countryphonecode");
		String Phonenumber = Excel_data.get("Phonenumber");
		String Faxnumber = Excel_data.get("Faxnumber");
		String CountryFaxcode = Excel_data.get("CountryFaxcode");
		String EmailAddress = Excel_data.get("EmailAddress");
		String Saved_popup = Excel_data.get("Saved_popup");
		String ExpectedType = Excel_data.get("ExpectedType");
		String Agency_Type_Header = Excel_data.get("Agency_Type_Header");
		String Carrier_Code_Header = Excel_data.get("Carrier_Code_Header");
		String Country_Code_header = Excel_data.get("Country_Code_header");
		String UN_Port_Code_Header = Excel_data.get("UN_Port_Code_Header");
		String Currency_Code_header = Excel_data.get("Currency_Code_header");
		String Type_Dropdown_Value = Excel_data.get("Type_Dropdown_Value");


		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "Click on the New button in the above tool bar", test, test1);

		newButton(driver);

		waitForElement(driver, TypeDropdown);
		click(driver, TypeDropdown);

		formatLocatorClick(driver, DropDown_Select, Type_Dropdown_Value);


		Step_End(1, "Click on the New button in the above tool bar", test, test1);

		Step_Start(2, "Ensure that whether the TYPE field is set as CORPORATE", test, test1);

		waitForElement(driver, TypeDropdown);

		String Type = getText(driver, TypeDropdown);

		if (Type.equals(ExpectedType)) {

			System.out.println(
					"Matched : Expected result is : The type should be defaultly set as Corporate || Actual result is : The Type field is set as Corporate as default");
			Extent_pass_New(driver,
					"Matched : Expected result is : The type should be defaultly set as Corporate || Actual result is : The Type field is set as Corporate as default",
					test, test1);
		} else {
			System.out.println(
					"Not Matched : Expected result is : The type should be defaultly set as Corporate || Actual result is : The Type field is set as Corporate as default");
			Extent_fail(driver,
					"Not Matched : Expected result is : The type should be defaultly set as Corporate || Actual result is : The Type field is set as Corporate as default",
					test, test1);
		}

		Step_End(2, "Ensure that whether the TYPE field is set as CORPORATE", test, test1);

		Step_Start(3, "Enter the CORPORATE CODE input field with a valid data(MAX 5 characters and should be unique)",
				test, test1);

		waitForElement(driver, AgencyCodeInput);
		sendKeys(driver, AgencyCodeInput, AgencyCode);

		Step_End(3, "Enter the CORPORATE CODE input field with a valid data(MAX 5 characters and should be unique)",
				test, test1);

		Step_Start(4, "Click the AGENCY Type search button and select the AGENCY Type from the two column search", test,
				test1);

		waitForElement(driver, Search_Agency);
		click(driver, Search_Agency);

		twoColumnSearchWindow(driver, Agency_Type_Header, Filter_Condition, AgencyType);

		Step_End(4, "Click the AGENCY Type search button and select the AGENCY Type from the two column search", test,
				test1);

		Step_Start(5, "Enter the CORPORATE NAME input field with a valid input", test, test1);

		waitForElement(driver, CorporateNameInput);
		sendKeys(driver, CorporateNameInput, CorporateName);

		waitForElement(driver, CorporateNameInput);
		click(driver, CarrierCode_search);

		twoColumnSearchWindow(driver, Carrier_Code_Header, Filter_Condition, CarrierCode);

		Step_End(5, "Enter the CORPORATE NAME input field with a valid input", test, test1);

		Step_Start(6, "Enter the data int the ADDRESS field", test, test1);

		waitForElement(driver, Address_Input);
		sendKeys(driver, Address_Input, Address);

		Step_End(6, "Enter the data int the ADDRESS field", test, test1);

		Step_Start(7, "Enter the data int the CITY field", test, test1);

		waitForElement(driver, City_Input);
		sendKeys(driver, City_Input, City);

		Step_End(7, "Enter the data int the CITY field", test, test1);

		Step_Start(8, "Click the UN PORT CODE search button and select the UN PORT CODE from the two column search",
				test, test1);

		waitForElement(driver, CountrySearch);
		click(driver, CountrySearch);

		twoColumnSearchWindow(driver, Country_Code_header, Filter_Condition, CountryCode);

		waitForElement(driver, UNPort_Search);
		click(driver, UNPort_Search);

		twoColumnSearchWindow(driver, UN_Port_Code_Header, Filter_Condition, UNPort);

		Step_End(8, "Click the UN PORT CODE search button and select the UN PORT CODE from the two column search", test,
				test1);

		Step_Start(9, "Click the COUNTRY search button and select the COUNTRY from the two column search", test, test1);

		waitForElement(driver, CurrencyCode_Search);
		click(driver, CurrencyCode_Search);

		twoColumnSearchWindow(driver, Currency_Code_header, Filter_Condition, CurrencyCode);

		Step_End(9, "Click the COUNTRY search button and select the COUNTRY from the two column search", test, test1);

		Step_Start(10, "Click the CURRENCY CODE search button and select the CURENCY CODE from the two column search",
				test, test1);

		waitForElement(driver, Ph_countryCode);
		sendKeys(driver, Ph_countryCode, Countryphonecode);

		Step_End(10, "Click the CURRENCY CODE search button and select the CURENCY CODE from the two column search",
				test, test1);

		Step_Start(11, "Enter the data int the PHONE+ field", test, test1);

		waitForElement(driver, PhoneNumber_input);
		sendKeys(driver, PhoneNumber_input, Phonenumber);

		Step_End(11, "Enter the data int the PHONE+ field", test, test1);

		Step_Start(12, "Enter the data int the FAX field", test, test1);

		waitForElement(driver, FaxCode_input);
		sendKeys(driver, FaxCode_input, CountryFaxcode);

		waitForElement(driver, Fax_input);
		sendKeys(driver, Fax_input, Faxnumber);

		Step_End(12, "Enter the data int the FAX field", test, test1);

		Step_Start(13, "Enter the data int the EMAIL field", test, test1);

		waitForElement(driver, Email_input);
		sendKeys(driver, Email_input, EmailAddress);

		Step_End(13, "Enter the data int the EMAIL field", test, test1);

		Step_Start(14, "Click the save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(14, "Click the save button", test, test1);

		Step_Start(15, "The message of 'Agency Details Saved' will be displayed", test, test1);

		waitForPopup(driver, popup_Message, Saved_popup);
		String Save_popup = getText(driver, popup_Message);

		if (Save_popup.equals(Saved_popup)) {

			System.out.println(
					"After entered the valid data and details are saved and user got the expected popup message :"
							+ Saved_popup + "Actual Message : " + Save_popup);
			Extent_pass_New(driver,
					"After entered the valid data and details are saved and user got the expected popup message :"
							+ Saved_popup + "Actual Message : " + Save_popup,
					test, test1);
		} else {
			System.out.println(
					"After entered the valid data and details are not saved and user got the error message Expected Message:"
							+ Saved_popup + "Actual Message : " + Save_popup);
			Extent_fail(driver,
					"After entered the valid data and details are not saved and user got the error message Expected Message:"
							+ Saved_popup + "Actual Message : " + Save_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(15, "The message of 'Agency Details Saved' will be displayed", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
