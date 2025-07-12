package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS004 extends Keywords {

	public void Agency_Master_TS004(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Agency_Master_TS004";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
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
		String AgencyType = Excel_data.get("AgencyType");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String AgencyCode_Search = Excel_data.get("AgencyCode_Search");
		String Agency_type = Excel_data.get("Agency_type");
		String Carrier_Code = Excel_data.get("Carrier_Code");
		String Country_Code = Excel_data.get("Country_Code");
		String UN_Port_Code = Excel_data.get("UN_Port_Code");
		String Currency_Code = Excel_data.get("Currency_ Code");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "Retrive the existing records", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Condition, Select_search_value, AgencyCode_Search, "", "", "", "");

		Step_End(1, "Retrive the existing records", test, test1);

		Step_Start(2, "Click the EDIT buton in the  above tool bar", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(2, "Click the EDIT buton in the  above tool bar", test, test1);

		Step_Start(3, "Edit the CORPORATE CODE input field ", test, test1);

		waitForElement(driver, Search_Agency);
		click(driver, Search_Agency);
		twoColumnSearchWindow(driver, Agency_type, Filter_Condition, AgencyType);

		Step_End(3, "Edit the CORPORATE CODE input field", test, test1);

		Step_Start(4, "Edit the CORPORATE NAME input field", test, test1);

		waitForElement(driver, CorporateNameInput);
		clearAndType(driver, CorporateNameInput, CorporateName);

		waitForElement(driver, CorporateNameInput);
		click(driver, CarrierCode_search);

		twoColumnSearchWindow(driver, Carrier_Code, Filter_Condition, CarrierCode);

		Step_End(4, "Edit the CORPORATE NAME input field", test, test1);

		Step_Start(5, "Edit  the data int the ADDRESS field", test, test1);

		waitForElement(driver, Address_Input);
		clearAndType(driver, Address_Input, Address);

		Step_End(5, "Edit  the data int the ADDRESS field", test, test1);

		Step_Start(6, "Edit the data int the CITY field", test, test1);

		waitForElement(driver, City_Input);
		clearAndType(driver, City_Input, City);

		Step_End(6, "Edit the data int the CITY field", test, test1);

		Step_Start(7, "Edit the COUNTRY", test, test1);

		waitForElement(driver, CountrySearch);
		click(driver, CountrySearch);

		twoColumnSearchWindow(driver, Country_Code, Filter_Condition, CountryCode);

		Step_End(7, "Edit the COUNTRY", test, test1);

		Step_Start(8, "Edit the UN PORT CODE", test, test1);

		waitForElement(driver, UNPort_Search);
		click(driver, UNPort_Search);

		twoColumnSearchWindow(driver, UN_Port_Code, Filter_Condition, UNPort);

		Step_End(8, "Edit the UN PORT CODE", test, test1);

		Step_Start(9, "Edit the CURRENCY CODE", test, test1);

		waitForElement(driver, CurrencyCode_Search);
		click(driver, CurrencyCode_Search);

		twoColumnSearchWindow(driver, Currency_Code, Filter_Condition, CurrencyCode);

		Step_End(9, "Edit the CURRENCY CODE", test, test1);

		Step_Start(10, "Edit the data int the PHONE+  field", test, test1);

		waitForElement(driver, Ph_countryCode);
		clearAndType(driver, Ph_countryCode, Countryphonecode);

		waitForElement(driver, PhoneNumber_input);
		clearAndType(driver, PhoneNumber_input, Phonenumber);

		Step_End(10, "Edit the data int the PHONE+  field", test, test1);

		Step_Start(11, "Edit the data int the FAX field", test, test1);

		waitForElement(driver, FaxCode_input);
		clearAndType(driver, FaxCode_input, CountryFaxcode);

		waitForElement(driver, Fax_input);
		clearAndType(driver, Fax_input, Faxnumber);

		Step_End(11, "Edit the data int the FAX field", test, test1);

		Step_Start(12, "Edit the data int the EMAIL field", test, test1);

		waitForElement(driver, Email_input);
		clearAndType(driver, Email_input, EmailAddress);

		Step_End(12, "Edit the data int the EMAIL field", test, test1);

		Step_Start(13, "Click the SAVE button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(13, "Click the SAVE button", test, test1);

		Step_Start(14, "A message of 'Corporate Agency Details Updated' will be displayed", test, test1);

		waitForPopup(driver, popup_Message, Saved_popup);
		String Save_popup = getText(driver, popup_Message);

		if (Save_popup.equals(Saved_popup)) {

			System.out.println(
					"Matched || Expected :After entered the valid data and details are updated and user should get message as  :"
							+ Saved_popup
							+ "Actual Message :After entered the valid data and details are updated and user  got the  message as "
							+ Save_popup);
			Extent_pass_New(driver,
					"Matched || Expected :After entered the valid data and details are updated and user should get message as Corporate Agency Details Updated  : "
							+ Saved_popup
							+ "Actual Message :After entered the valid data and details are updated and user  got the  message as  "
							+ Save_popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected :After entered the valid data and details are not updated and user should get message as : "
							+ Saved_popup
							+ "Actual Message : After entered the valid data and details are updated and user didn't get the  message as "
							+ Save_popup);
			Extent_fail(driver,
					"Not Matched || Expected :After entered the valid data and details are not updated and user should get message as  : "
							+ Saved_popup
							+ "Actual Message :After entered the valid data and details are updated and user didn't get the  message as   "
							+ Save_popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(14, "A message of 'Corporate Agency Details Updated' will be displayed", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
