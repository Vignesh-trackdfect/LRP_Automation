package LRP_NFR_Agency_Master_scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Agency_Master_TS014 extends Keywords {

	public void Agency_Master_TS014(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Agency_Master_TS014";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String Agency_Filter_Type = Excel_data.get("Agency_Filter_Type");
		String Agency_Filter_Condition = Excel_data.get("Agency_Filter_Condition");
		String Agency_Filter_Value = Excel_data.get("Agency_Filter_Value");
		String Change_Agency_Name = Excel_data.get("Change_Agency_Name");
		String Change_Agency_Type_value = Excel_data.get("Change_Agency_Type_value");
		String Change_Address_Value = Excel_data.get("Change_Address_Value");
		String Change_City = Excel_data.get("Change_City");
		String Change_Country = Excel_data.get("Change_Country");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Change_UN_Port_Code = Excel_data.get("Change_UN_Port_Code");
		String Change_Currency_Code = Excel_data.get("Change_Currency_Code");
		String Change_Phone_Code = Excel_data.get("Change_Phone_Code");
		String Change_Phone_Number = Excel_data.get("Change_Phone_Number");
		String Change_Fax_Code = Excel_data.get("Change_Fax_Code");
		String Change_Fax_Number = Excel_data.get("Change_Fax_Number");
		String Change_email_id = Excel_data.get("Change_email_id");
		String Agency_updated_Popup = Excel_data.get("Agency_updated_Popup");
		String Country_Code_header = Excel_data.get("Country_Code_header");
		String UN_Port_Code_Header = Excel_data.get("UN_Port_Code_Header");
		String Currency_Code_header = Excel_data.get("Currency_Code_header");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Agency_Master_Module);

		Step_Start(1, ".Retrive the Agency Code", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Agency_Filter_Condition, Agency_Filter_Type, Agency_Filter_Value, "", "", "",
				"");

		Step_End(1, ".Retrive the Agency Code", test, test1);

		Step_Start(2, "Click the EDIT buton in the  above tool bar.", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(2, "Click the EDIT buton in the  above tool bar.", test, test1);

		Step_Start(3, "Edit the AGENCY NAME input field ", test, test1);
		waitForElement(driver, Agency_Name_Input_AM);
		clear(driver, Agency_Name_Input_AM);
		sendKeys(driver, Agency_Name_Input_AM, Change_Agency_Name);
		Step_End(3, "Edit the AGENCY NAME input field ", test, test1);

		Step_Start(4, "EdIt the AGENCY Type.", test, test1);
		waitForElement(driver, Agency_Type_Input_AM);
		click(driver, Agency_Type_Input_AM);

		formatLocatorClick(driver, AgencyType_option_AM, Change_Agency_Type_value);
	
		Step_End(4, "EdIt the AGENCY Type.", test, test1);

		Step_Start(5, "Edit  the data int the ADDRESS field.", test, test1);
		waitForElement(driver, Address_Input);
		clearAndType(driver, Address_Input, Change_Address_Value);
		Step_End(5, "Edit  the data int the ADDRESS field.", test, test1);

		Step_Start(6, "Edit the data int the CITY field", test, test1);
		waitForElement(driver, City_Input);
		clearAndType(driver, City_Input, Change_City);
		Step_End(6, "Edit the data int the CITY field", test, test1);

		Step_Start(8, "Edit the COUNTRY", test, test1);
		waitForElement(driver, CountrySearch);
		click(driver, CountrySearch);

		twoColumnSearchWindow(driver, Country_Code_header, Filter_Condition, Change_Country);

		Step_End(8, "Edit the COUNTRY", test, test1);

		Step_Start(7, "Edit the UN PORT CODE ", test, test1);
		waitForElement(driver, UNPort_Search);
		click(driver, UNPort_Search);

		twoColumnSearchWindow(driver, UN_Port_Code_Header, Filter_Condition, Change_UN_Port_Code);

		Step_End(7, "Edit the UN PORT CODE", test, test1);

		Step_Start(9, "Edit the CURRENCY CODE", test, test1);
		waitForElement(driver, CurrencyCode_Search);
		click(driver, CurrencyCode_Search);

		twoColumnSearchWindow(driver, Currency_Code_header, Filter_Condition, Change_Currency_Code);

		Step_End(9, "Edit the CURRENCY CODE", test, test1);

		Step_Start(10, "Edit the data int the PHONE+  field.", test, test1);
		waitForElement(driver, Ph_countryCode);
		clearAndType(driver, Ph_countryCode, Change_Phone_Code);

		waitForElement(driver, PhoneNumber_input);
		clearAndType(driver, PhoneNumber_input, Change_Phone_Number);
		Step_End(10, "Edit the data int the PHONE+  field.", test, test1);

		Step_Start(11, "Edit the data int the FAX field.", test, test1);
		waitForElement(driver, FaxCode_input);
		clearAndType(driver, FaxCode_input, Change_Fax_Code);

		waitForElement(driver, Fax_input);
		clearAndType(driver, Fax_input, Change_Fax_Number);
		Step_End(11, "Edit the data int the FAX field.", test, test1);

		Step_Start(12, "Edit the data int the EMAIL field.", test, test1);
		waitForElement(driver, Email_input);
		clearAndType(driver, Email_input, Change_email_id);
		Step_End(12, "Edit the data int the EMAIL field.", test, test1);

		Step_Start(13, "Click the SAVE button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(13, "Click the SAVE button", test, test1);

		Step_Start(14, " A message of 'Agency Details Updated' will be displayed", test, test1);

		waitForPopup(driver, popup_Message, Agency_updated_Popup);

		String act_Popup = getText(driver, popup_Message);

		if (act_Popup.contains(Agency_updated_Popup)) {
			System.out.println("Agency Details Updated ||  Expected popup : " + Agency_updated_Popup
					+ "  ||  Actual popup : " + act_Popup);
			Extent_pass_New(driver, "Agency Details Updated ||  Expected popup : " + Agency_updated_Popup
					+ "  ||  Actual popup : " + act_Popup, test, test1);
		} else {
			System.out.println("Agency Details not Updated ||  Expected popup : " + Agency_updated_Popup
					+ "  ||  Actual popup : " + act_Popup);
			Extent_fail(driver, "Agency Details not Updated||  Expected popup : " + Agency_updated_Popup
					+ "  ||  Actual popup : " + act_Popup, test, test1);
		}
		Step_End(14, " A message of 'Agency Details Updated' will be displayed", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
