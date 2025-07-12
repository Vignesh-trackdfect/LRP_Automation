package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS009 extends Keywords {

	public void Agency_Master_TS009(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Agency_Master_TS009";
		
		


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
		String Branchname = Excel_data.get("Branchname");
		String Save_popup = Excel_data.get("Save_popup");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String BranchCode_Search = Excel_data.get("BranchCode_Search");
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

		Step_Start(1, "Retrive the existing records", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Condition, Select_search_value, BranchCode_Search, "", "", "", "");

		Step_End(1, "Retrive the existing records", test, test1);

		Step_Start(2, "Click the EDIT buton in the  above tool bar", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(2, "Click the EDIT buton in the  above tool bar", test, test1);

		Step_Start(3, "Enter the BRANCH NAME input field with a valid input", test, test1);

		waitForElement(driver, BranchName_Input);
		clearAndType(driver, BranchName_Input, Branchname);

		Step_End(3, "Enter the BRANCH NAME input field with a valid input", test, test1);

		Step_Start(4, "Click the AGENCY Type search button and select the AGENCY Type from the two column search ",
				test, test1);

		waitForElement(driver, Search_Agency);
		click(driver, Search_Agency);

		twoColumnSearchWindow(driver, Agency_Type_Header, Filter_Condition, AgencyType);

		Step_End(4, "Click the AGENCY Type search button and select the AGENCY Type from the two column search ", test,
				test1);

		Step_Start(5, "Enter the data int the ADDRESS field", test, test1);

		waitForElement(driver, BranchAgencyCode_Search);
		click(driver, BranchAgencyCode_Search);
		twoColumnSearchWindow(driver, Agency_Code_header, Filter_Condition, AgencyCode);

		waitForElement(driver, CorporateNameInput);
		click(driver, CarrierCode_search);

		twoColumnSearchWindow(driver, Carrier_Code_Header, Filter_Condition, CarrierCode);

		waitForElement(driver, Address_Input);
		clearAndType(driver, Address_Input, Address);

		Step_End(5, "Enter the data int the ADDRESS field", test, test1);

		Step_Start(6, "Enter the data int the CITY field", test, test1);

		waitForElement(driver, City_Input);
		clearAndType(driver, City_Input, City);

		Step_End(6, "Enter the data int the CITY field", test, test1);

		Step_Start(7, "Click the UN PORT CODE search button and select the UN PORT CODE from the two column search",
				test, test1);

		waitForElement(driver, CountrySearch);
		click(driver, CountrySearch);

		twoColumnSearchWindow(driver, Country_Code_header, Filter_Condition, CountryCode);

		waitForElement(driver, UNPort_Search);
		click(driver, UNPort_Search);

		twoColumnSearchWindow(driver, UN_Port_Code_Header, Filter_Condition, UNPort);

		Step_End(7, "Click the UN PORT CODE search button and select the UN PORT CODE from the two column search", test,
				test1);

		Step_Start(8, "Click the COUNTRY search button and select the COUNTRY from the two column search", test, test1);

		waitForElement(driver, CurrencyCode_Search);
		click(driver, CurrencyCode_Search);

		twoColumnSearchWindow(driver, Currency_Code_header, Filter_Condition, CurrencyCode);

		Step_End(8, "Click the COUNTRY search button and select the COUNTRY from the two column search", test, test1);

		Step_Start(9, "Enter the data int the PHONE+  field", test, test1);

		waitForElement(driver, Ph_countryCode);
		clearAndType(driver, Ph_countryCode, Countryphonecode);

		waitForElement(driver, PhoneNumber_input);
		clearAndType(driver, PhoneNumber_input, Phonenumber);

		Step_End(9, "Enter the data int the PHONE+  field", test, test1);

		Step_Start(10, "Enter the data int the FAX field", test, test1);

		waitForElement(driver, FaxCode_input);
		clearAndType(driver, FaxCode_input, CountryFaxcode);

		waitForElement(driver, Fax_input);
		clearAndType(driver, Fax_input, Faxnumber);

		Step_End(10, "Enter the data int the FAX field", test, test1);

		Step_Start(11, "Enter the data int the EMAIL field", test, test1);

		waitForElement(driver, Email_input);
		clearAndType(driver, Email_input, EmailAddress);

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

		Step_End(13, "The message of 'Branch Agency Details Updated' will be displayed", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
