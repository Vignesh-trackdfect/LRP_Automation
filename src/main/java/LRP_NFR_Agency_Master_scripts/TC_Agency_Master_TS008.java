package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS008 extends Keywords {

	public void Agency_Master_TS008(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Agency_Master_TS008";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String AgencyCode = Excel_data.get("AgencyCode");
		String AgencyType = Excel_data.get("AgencyType");
		String Filter_Condition = Excel_data.get("Filter_Condition");
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
		String BranchCode = Excel_data.get("BranchCode");
		String Branchname = Excel_data.get("Branchname");
		String Save_popup = Excel_data.get("Save_popup");
		String Agency_type = Excel_data.get("Agency_type");
		String Carrier_Code = Excel_data.get("Carrier_Code");
		String Country_Code = Excel_data.get("Country_Code");
		String UN_Port_Code = Excel_data.get("UN_Port_Code");
		String Currency_Code = Excel_data.get("Currency_Code");
		String Agency_Code = Excel_data.get("Agency_Code");
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "Ensure that whether the TYPE field is set as 'BRANCH'", test, test1);

		newButton(driver);

		waitForElement(driver, TypeDropdown);
		click(driver, TypeDropdown);

		Step_End(1, "Ensure that whether the TYPE field is set as 'BRANCH'", test, test1);

		Step_Start(2, "Enter the BRANCH CODE input field with a valid data(MAX 5 characters and should be unique)",
				test, test1);

		waitForElement(driver, SelectBranch);
		click(driver, SelectBranch);

		waitForElement(driver, BranchCodeInput);
		sendKeys(driver, BranchCodeInput, BranchCode);

		Step_End(2, "Enter the BRANCH CODE input field with a valid data(MAX 5 characters and should be unique)", test,
				test1);

		Step_Start(3, "Enter the BRANCH NAME input field with a valid input", test, test1);

		waitForElement(driver, BranchName_Input);
		sendKeys(driver, BranchName_Input, Branchname);

		Step_End(3, "Enter the BRANCH NAME input field with a valid input", test, test1);

		Step_Start(4, "Click the AGENCY Type search button and select the AGENCY Type from the two column search ",
				test, test1);

		waitForElement(driver, Search_Agency);
		click(driver, Search_Agency);

		twoColumnSearchWindow(driver, Agency_type, Filter_Condition, AgencyType);

		Step_End(4, "Click the AGENCY Type search button and select the AGENCY Type from the two column search ", test,
				test1);

		Step_Start(5, "Enter the data int the ADDRESS field", test, test1);

		waitForElement(driver, BranchAgencyCode_Search);
		click(driver, BranchAgencyCode_Search);

		twoColumnSearchWindow(driver, Agency_Code, Filter_Condition, AgencyCode);

		waitForElement(driver, CorporateNameInput);
		click(driver, CarrierCode_search);

		twoColumnSearchWindow(driver, Carrier_Code, Filter_Condition, CarrierCode);

		waitForElement(driver, Address_Input);
		sendKeys(driver, Address_Input, Address);

		Step_End(5, "Enter the data int the ADDRESS field", test, test1);

		Step_Start(6, "Enter the data int the CITY field", test, test1);

		waitForElement(driver, City_Input);
		sendKeys(driver, City_Input, City);

		Step_End(6, "Enter the data int the CITY field", test, test1);

		Step_Start(7, "Click the UN PORT CODE search button and select the UN PORT CODE from the two column search",
				test, test1);

		waitForElement(driver, CountrySearch);
		click(driver, CountrySearch);

		twoColumnSearchWindow(driver, Country_Code, Filter_Condition, CountryCode);

		waitForElement(driver, UNPort_Search);
		click(driver, UNPort_Search);

		twoColumnSearchWindow(driver, UN_Port_Code, Filter_Condition, UNPort);

		Step_End(7, "Click the UN PORT CODE search button and select the UN PORT CODE from the two column search", test,
				test1);

		Step_Start(8, "Click the COUNTRY search button and select the COUNTRY from the two column search", test, test1);

		waitForElement(driver, CurrencyCode_Search);
		click(driver, CurrencyCode_Search);

		twoColumnSearchWindow(driver, Currency_Code, Filter_Condition, CurrencyCode);

		Step_End(8, "Click the COUNTRY search button and select the COUNTRY from the two column search", test, test1);

		Step_Start(9, "Enter the data int the PHONE+  field", test, test1);

		waitForElement(driver, Ph_countryCode);
		sendKeys(driver, Ph_countryCode, Countryphonecode);

		waitForElement(driver, PhoneNumber_input);
		sendKeys(driver, PhoneNumber_input, Phonenumber);

		Step_End(9, "Enter the data int the PHONE+  field", test, test1);

		Step_Start(10, "Enter the data int the FAX field", test, test1);

		waitForElement(driver, FaxCode_input);
		sendKeys(driver, FaxCode_input, CountryFaxcode);

		waitForElement(driver, Fax_input);
		sendKeys(driver, Fax_input, Faxnumber);

		Step_End(10, "Enter the data int the FAX field", test, test1);

		Step_Start(11, "Enter the data int the EMAIL field", test, test1);

		waitForElement(driver, Email_input);
		sendKeys(driver, Email_input, EmailAddress);

		Step_End(11, "Enter the data int the EMAIL field", test, test1);

		Step_Start(12, "Click the save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(12, "Click the save button", test, test1);

		Step_Start(13, "The message of 'Branch Agency Details Saved' will be displayed", test, test1);

		waitForPopup(driver, popup_Message, Save_popup);
		String SavedPopup = getText(driver, popup_Message);

		if (SavedPopup.equals(Save_popup)) {

			System.out.println(
					"Matched || Expected popup message was :" + Save_popup + "Actual popup message was" + SavedPopup);
			Extent_pass_New(driver,
					"Matched || Expected popup message was :" + Save_popup + "Actual popup message was" + SavedPopup,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was :" + Save_popup + "Actual popup message was"
					+ SavedPopup);
			Extent_fail(driver, "Not Matched || Expected popup message was :" + Save_popup + "Actual popup message was"
					+ SavedPopup, test, test1);
		}

		Step_End(13, "The message of 'Branch Agency Details Saved' will be displayed", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
