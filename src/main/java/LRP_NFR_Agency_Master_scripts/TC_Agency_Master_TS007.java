package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS007 extends Keywords {

	public void Agency_Master_TS007(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Agency_Master_TS007";
		
		


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
		String Warning_popup = Excel_data.get("Warning_popup");
		String BranchCode = Excel_data.get("BranchCode");
		String Branchname = Excel_data.get("Branchname");
		String BranchCode_WarningpopupMessage = Excel_data.get("BranchCode_WarningpopupMessage");
		String BranchCodeNew = Excel_data.get("BranchCodeNew");
		String UNPortOld = Excel_data.get("UNPortOld");
		String Agency_type = Excel_data.get("Agency_type");
		String Carrier_Code = Excel_data.get("Carrier_Code");
		String Country_Code = Excel_data.get("Country_Code");
		String UN_Port_Code = Excel_data.get("UN_Port_Code");
		String Currency_Code = Excel_data.get("Currency_ Code");
		String Agency_Code = Excel_data.get("Agency_Code");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "Click on the New button in the above tool bar", test, test1);

		newButton(driver);

		Step_End(1, "Click on the New button in the above tool bar", test, test1);

		Step_Start(2, "Enter the  BRANCH CODE as existing data and enter all other mandatory fields ", test, test1);

		waitForElement(driver, TypeDropdown);
		click(driver, TypeDropdown);

		waitForElement(driver, SelectBranch);
		click(driver, SelectBranch);

		waitForElement(driver, BranchCodeInput);
		sendKeys(driver, BranchCodeInput, BranchCode);

		Step_Start(2, "Enter the  BRANCH CODE as existing data and enter all other mandatory fields ", test, test1);

		waitForElement(driver, Search_Agency);
		click(driver, Search_Agency);

		twoColumnSearchWindow(driver, Agency_type, Filter_Condition, AgencyType);

		waitForElement(driver, BranchAgencyCode_Search);
		click(driver, BranchAgencyCode_Search);

		twoColumnSearchWindow(driver, Agency_Code, Filter_Condition, AgencyCode);

		waitForElement(driver, CorporateNameInput);
		click(driver, CarrierCode_search);
		twoColumnSearchWindow(driver, Carrier_Code, Filter_Condition, CarrierCode);

		waitForElement(driver, Address_Input);
		sendKeys(driver, Address_Input, Address);

		waitForElement(driver, City_Input);
		sendKeys(driver, City_Input, City);

		waitForElement(driver, CountrySearch);
		click(driver, CountrySearch);

		twoColumnSearchWindow(driver, Country_Code, Filter_Condition, CountryCode);

		waitForElement(driver, UNPort_Search);
		click(driver, UNPort_Search);

		twoColumnSearchWindow(driver, UN_Port_Code, Filter_Condition, UNPort);

		waitForElement(driver, CurrencyCode_Search);
		click(driver, CurrencyCode_Search);

		twoColumnSearchWindow(driver, Currency_Code, Filter_Condition, CurrencyCode);

		waitForElement(driver, Ph_countryCode);
		sendKeys(driver, Ph_countryCode, Countryphonecode);

		waitForElement(driver, PhoneNumber_input);
		sendKeys(driver, PhoneNumber_input, Phonenumber);

		waitForElement(driver, FaxCode_input);
		sendKeys(driver, FaxCode_input, CountryFaxcode);

		waitForElement(driver, Fax_input);
		sendKeys(driver, Fax_input, Faxnumber);

		waitForElement(driver, Email_input);
		sendKeys(driver, Email_input, EmailAddress);

		waitForElement(driver, BranchName_Input);
		sendKeys(driver, BranchName_Input, Branchname);

		Step_End(2, "Enter the  BRANCH CODE as existing data and enter all other mandatory fields ", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, BranchCode_WarningpopupMessage);
		String BranchCode_Warningpopup = getText(driver, popup_Message);

		if (BranchCode_Warningpopup.equals(BranchCode_WarningpopupMessage)) {

			System.out.println(
					"Matched || Expected :After click on save  button User should get the error message as Agency Code was already exist: "
							+ BranchCode_WarningpopupMessage
							+ " Actual Popup Message : After click on save  button User should got the error message as Agency Code was already exist"
							+ BranchCode_Warningpopup);
			Extent_pass_New(driver,
					"Matched || Expected :After click on save  button User should get the error message as Agency Code was already exist: "
							+ BranchCode_WarningpopupMessage
							+ " Actual Popup Message :After click on save  button User  got the error message as Agency Code was already exist "
							+ BranchCode_Warningpopup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected :After click on save  button User should get the error message as Agency Code was already exist: "
							+ BranchCode_WarningpopupMessage
							+ " Actual Popup Message :After click on save  button User  didn't got the error message as Agency Code was already exist "
							+ BranchCode_Warningpopup);
			Extent_fail(driver,
					"Not Matched || Expected :After click on save  button User should get the error message as Agency Code was already exist: "
							+ BranchCode_WarningpopupMessage
							+ " Actual Popup Message : After click on save  button User didn't got the error message as Agency Code was already exist"
							+ BranchCode_Warningpopup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(3,
				"Click the save button and the error message of 'This Agency Code is already Exist' will be displayed",
				test, test1);

		Step_Start(4,
				"Enter a unique  corporate code  ,Click the UN PORT  CODE  and select a already selected port code and enter all the mandatory fields",
				test, test1);

		waitForElement(driver, BranchCodeInput);
		clearAndType(driver, BranchCodeInput, BranchCodeNew);

		waitForElement(driver, UNPort_Search);
		click(driver, UNPort_Search);
		twoColumnSearchWindow(driver, UN_Port_Code, Filter_Condition, UNPortOld);

		Step_End(4,
				"Enter a unique  corporate code  ,Click the UN PORT  CODE  and select a already selected port code and enter all the mandatory fields",
				test, test1);

		Step_Start(5, "click the save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(5, "click the save button", test, test1);

		Step_Start(6, "The error message of 'UN Portcode is already exist' will be displayed", test, test1);

		waitForPopup(driver, popup_Message, Warning_popup);
		String Warningpopup = getText(driver, popup_Message);

		if (Warningpopup.equals(Warning_popup)) {

			System.out.println(
					"Matched || Expected result:After clicking save button User should get the error message as: "
							+ Warning_popup
							+ " Actual result : After clicking save button User got the error message as"
							+ Warningpopup);
			Extent_pass_New(driver,
					"Matched || Expected :After clicking save button User should get  the error message as: "
							+ Warning_popup
							+ " Actual Popup Message :  After clicking save button User got the error message as"
							+ Warningpopup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected result:After clicking save button User should get  the error message as: "
							+ Warning_popup
							+ " Actual result : After clicking save button User didn't got the error message as"
							+ Warningpopup);
			Extent_fail(driver,
					"Not Matched || Expected :After clicking save button User should didn't get  the error message as: "
							+ Warning_popup
							+ " Actual Popup Message :  After clicking save button User didn't got the error message as"
							+ Warningpopup,
					test, test1);
		}

		Step_End(6, "The error message of 'UN Portcode is already exist' will be displayed", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
