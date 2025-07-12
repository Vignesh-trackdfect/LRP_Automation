package LRP_EDI_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EDI_Creation_TS_001 extends Keywords {

	public void EDI_Creation_TS_001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EDI_Creation_TS_001";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");

		String EDI_Creation_Module = Excel_data.get("EDI_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");

		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Partner_ID_Value = Excel_data.get("Partner_ID_Value");
		String EDI_ID_Input_Value = Excel_data.get("EDI_ID_Input_Value");

		String Direction_Select_Value = Excel_data.get("Direction_Select_Value");
		String EDI_Format_Value = Excel_data.get("EDI_Format_Value");
		String Group_Code_Value = Excel_data.get("Group_Code_Value");
		String Version_Select_Value = Excel_data.get("Version_Select_Value");
		String EDI_Category_Header = Excel_data.get("EDI_Category_Header");
		String EDI_Category_Value = Excel_data.get("EDI_Category_Value");
		String Office_Type_Values = Excel_data.get("Office_Type_Values");

		String Agency_Code_Header = Excel_data.get("Agency_Code_Header");
		String Agency_Code_Value = Excel_data.get("Agency_Code_Value");
		String Status_Value = Excel_data.get("Status_Value");
		String Prefix_Value = Excel_data.get("Prefix_Value");

		String EDI_Success_Popup = Excel_data.get("EDI_Success_Popup");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		if (!AgencyUser.equals("")) {
			SwitchProfile(driver, AgencyUser);
		}

		moduleNavigate(driver, EDI_Creation_Module);

		Step_Start(1, ".Click the PARTNER ID search button and select a PARTNER from the two column search field. ",
				test, test1);

		waitForElement(driver, Partner_ID_Search_Btn_EDI_Creation);
		click(driver, Partner_ID_Search_Btn_EDI_Creation);
		twoColumnMultipleSearchWindow(driver, Partner_ID_Header, Condition_Filter, Partner_ID_Value);
		Step_End(1, ".Click the PARTNER ID search button and select a PARTNER from the two column search field. ", test,
				test1);

		Step_Start(6, "Enter a EDI name in the EDI ID field", test, test1);
		waitForElement(driver, Partner_Name_Input_EDI_Creation);
		String Partner_Name_Value = getAttribute(driver, Partner_Name_Input_EDI_Creation, "value");
		Step_End(6, "Enter a EDI name in the EDI ID field", test, test1);

		Step_Start(2, "Click the Direction dropdown and select one of the options in the dropdown", test, test1);
		waitForElement(driver, EDI_ID_Input_EDI_Creation);
		sendKeys(driver, EDI_ID_Input_EDI_Creation, EDI_ID_Input_Value);

		waitForElement(driver, Direction_Input_EDI_Creation);
		click(driver, Direction_Input_EDI_Creation);

		formatLocatorClick(driver, Direction_SelectOptions_EDI_Creation, Direction_Select_Value);

		Step_End(2, "Click the Direction dropdown and select one of the options in the dropdown", test, test1);

		Step_Start(3, "Click the GROUP CODE dropdown and select one of the options in the dropdown", test, test1);
		waitForElement(driver, GroupCode_Input_EDI_Creation);
		click(driver, GroupCode_Input_EDI_Creation);

		formatLocatorClick(driver, GroupCode_SelectOptions_EDI_Creation, Group_Code_Value);

		Step_End(3, "Click the GROUP CODE dropdown and select one of the options in the dropdown", test, test1);

		Step_Start(7, "Click the EDI FORMAT dropdown and select one of the options in the dropdown", test, test1);
		waitForElement(driver, EDI_Format_Input_EDI_Creation);
		click(driver, EDI_Format_Input_EDI_Creation);

		formatLocatorClick(driver, EDI_Format_SelectOptions_EDI_Creation, EDI_Format_Value);

		Step_End(7, "Click the EDI FORMAT dropdown and select one of the options in the dropdown", test, test1);

		Step_Start(8, "Click the VERSION dropdown and select one of the options in the dropdown", test, test1);
		waitForElement(driver, Version_Input_EDI_Creation);
		click(driver, Version_Input_EDI_Creation);

		formatLocatorClick(driver, Version_SelectOption_EDI_Creation, Version_Select_Value);

		Step_End(8, "Click the VERSION dropdown and select one of the options in the dropdown", test, test1);

		Step_Start(4,
				"Click the CATEGORY search button and select a CATEGORY from the two column search field. (optional).",
				test, test1);

		waitForElement(driver, Category_Search_Btn_EDI_Creation);
		click(driver, Category_Search_Btn_EDI_Creation);

		twoColumnMultipleSearchWindow(driver, EDI_Category_Header, Condition_Filter, EDI_Category_Value);

		Step_End(4,
				"Click the CATEGORY search button and select a CATEGORY from the two column search field. (optional).",
				test, test1);

		waitForElement(driver, Office_Type_Input_EDI_Creation);
		click(driver, Office_Type_Input_EDI_Creation);

		formatLocatorClick(driver, OffficeType_SelectOption_EDI_Creation, Office_Type_Values);

		Step_Start(9, "Click the AGENCY CODE search button and select a AGENCY from the two column search field. ",
				test, test1);
		waitForElement(driver, Agency_Code_Search_Btn_EDI_Creation);
		click(driver, Agency_Code_Search_Btn_EDI_Creation);

		twoColumnMultipleSearchWindow(driver, Agency_Code_Header, Condition_Filter, Agency_Code_Value);

		Step_End(9, "Click the AGENCY CODE search button and select a AGENCY from the two column search field. ", test,
				test1);

		Step_Start(5, "Click the STATUS dropdown and select one of the STATUS in the dropdown.", test, test1);

		waitForElement(driver, Status_Input_EDI_Creation);
		click(driver, Status_Input_EDI_Creation);

		formatLocatorClick(driver, Status_SelectOption_EDI_Creation, Status_Value);

		Step_End(5, "Click the STATUS dropdown and select one of the STATUS in the dropdown.", test, test1);

		Step_Start(10, ".Click the PREFIX dropdown and select one of the options in the dropdown ", test, test1);

		waitForElement(driver, Prefix_Input_EDI_Creation);
		click(driver, Prefix_Input_EDI_Creation);

		formatLocatorClick(driver, Prefix_SelectOption_EDI_Creation, Prefix_Value);

		Step_End(10, ".Click the PREFIX dropdown and select one of the options in the dropdown ", test, test1);

		Step_Start(11, "Select the SKIP TO LAST  checkbox and click the NEXT button ", test, test1);
		waitForDisplay(driver, Skip_To_LastCheckbox_EDI_Creation);
		jsClick(driver, Skip_To_LastCheckbox_EDI_Creation);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);
		Step_End(11, "Select the SKIP TO LAST  checkbox and click the NEXT button ", test, test1);

		Step_Start(12, "System will navigate to the lat page of the module ", test, test1);

		waitForElement(driver, Confirmation_Section_EDI_Creation);
		waitForElement(driver, PartnerCode_Confirm_EDI_Creation);

		String Act_PartnerCode = getText(driver, PartnerCode_Confirm_EDI_Creation).trim();

		if (Act_PartnerCode.equalsIgnoreCase(Partner_ID_Value)) {
			System.out.println("Partner ID Value Matched  ||  Expected : " + Partner_ID_Value + " ||  Actual : "
					+ Act_PartnerCode);
			Extent_pass_New(driver,
					"Partner ID Value Matched  ||  Expected : " + Partner_ID_Value + " ||  Actual : " + Act_PartnerCode,
					test, test1);
		} else {
			System.out.println("Partner ID Value Not Matched  ||  Expected : " + Partner_ID_Value + " ||  Actual : "
					+ Act_PartnerCode);
			Extent_fail(driver, "Partner ID Value Not Matched  ||  Expected : " + Partner_ID_Value + " ||  Actual : "
					+ Act_PartnerCode, test, test1);
		}

		waitForElement(driver, PartnerName_Confirm_EDI_Creation);
		String Act_PartnerName = getText(driver, PartnerName_Confirm_EDI_Creation).trim();

		if (Act_PartnerName.equalsIgnoreCase(Partner_Name_Value)) {
			System.out.println("Partner Name Value Matched  ||  Expected : " + Partner_Name_Value + " ||  Actual : "
					+ Act_PartnerName);
			Extent_pass_New(driver, "Partner Name Value Matched  ||  Expected : " + Partner_Name_Value + " ||  Actual : "
					+ Act_PartnerName, test, test1);
		} else {
			System.out.println("Partner Name Value Not Matched  ||  Expected : " + Partner_Name_Value + " ||  Actual : "
					+ Act_PartnerName);
			Extent_fail(driver, "Partner Name Value Not Matched  ||  Expected : " + Partner_Name_Value
					+ " ||  Actual : " + Act_PartnerName, test, test1);
		}

		waitForElement(driver, EDIName_Confirm_EDI_Creation);
		String Act_EDIName = getText(driver, EDIName_Confirm_EDI_Creation).trim();
		if (Act_EDIName.equalsIgnoreCase(EDI_ID_Input_Value)) {
			System.out.println(
					"EDI Name Value Matched  ||  Expected : " + EDI_ID_Input_Value + " ||  Actual : " + Act_EDIName);
			Extent_pass_New(driver,
					"EDI Name Value Matched  ||  Expected : " + EDI_ID_Input_Value + " ||  Actual : " + Act_EDIName,
					test, test1);
		} else {
			System.out.println("EDI Name Value Not Matched  ||  Expected : " + EDI_ID_Input_Value + " ||  Actual : "
					+ Act_EDIName);
			Extent_fail(driver,
					"EDI Name Value Not Matched  ||  Expected : " + EDI_ID_Input_Value + " ||  Actual : " + Act_EDIName,
					test, test1);
		}

		waitForElement(driver, Agency_Confirm_EDI_Creation);
		String Act_Agency = getText(driver, Agency_Confirm_EDI_Creation).trim();
		if (Act_Agency.equalsIgnoreCase(Agency_Code_Value)) {
			System.out.println(
					"Agency Value Matched  ||  Expected : " + Agency_Code_Value + " ||  Actual : " + Act_Agency);
			Extent_pass_New(driver,
					"Agency Value Matched  ||  Expected : " + Agency_Code_Value + " ||  Actual : " + Act_Agency, test,
					test1);
		} else {
			System.out.println(
					"Agency Value Not Matched  ||  Expected : " + Agency_Code_Value + " ||  Actual : " + Act_Agency);
			Extent_fail(driver,
					"Agency Value Not Matched  ||  Expected : " + Agency_Code_Value + " ||  Actual : " + Act_Agency,
					test, test1);
		}

		waitForElement(driver, Status_Confirm_EDI_Creation);
		String Act_Status_Value = getText(driver, Status_Confirm_EDI_Creation).trim();
		if (Act_Status_Value.equalsIgnoreCase(Status_Value)) {
			System.out.println(
					"Status Value Matched  ||  Expected : " + Status_Value + " ||  Actual : " + Act_Status_Value);
			Extent_pass_New(driver,
					"Status Value Matched  ||  Expected : " + Status_Value + " ||  Actual : " + Act_Status_Value, test,
					test1);
		} else {
			System.out.println(
					"Status Value Not Matched  ||  Expected : " + Status_Value + " ||  Actual : " + Act_Status_Value);
			Extent_fail(driver,
					"Status Value Not Matched  ||  Expected : " + Status_Value + " ||  Actual : " + Act_Status_Value,
					test, test1);
		}
		Step_End(12, "System will navigate to the lat page of the module ", test, test1);

		Step_Start(13,
				"Click the CONFIRM button. The validation of \"EDI CREATED SUCCESSFULLY\" message will be displayed. ",
				test, test1);

		waitForElement(driver, Confirm_Button_EDI_Creation);
		click(driver, Confirm_Button_EDI_Creation);

		waitForPopup(driver, Popup_Message, EDI_Success_Popup);
		String Act_Popup = getText(driver, Popup_Message);
		if (EDI_Success_Popup.equals(Act_Popup)) {
			System.out.println("Popup Matched ||  Expected : " + EDI_Success_Popup + " || Actual : " + Act_Popup);
			Extent_pass_New(driver, "Popup Matched ||  Expected : " + EDI_Success_Popup + " || Actual : " + Act_Popup, test,
					test1);
		} else {
			System.out.println("Popup Not Matched ||  Expected : " + EDI_Success_Popup + " || Actual : " + Act_Popup);
			Extent_fail(driver, "Popup Not Matched ||  Expected : " + EDI_Success_Popup + " || Actual : " + Act_Popup,
					test, test1);
		}
		Step_End(13,
				"Click the CONFIRM button. The validation of \"EDI CREATED SUCCESSFULLY\" message will be displayed. ",
				test, test1);

		Step_Start(14,
				"A EDI ID will be generated (before it will be blank space, after confirming EDI will be generated. ",
				test, test1);

		waitForElement(driver, EDI_ID_Value_EDI_Creation);
		String EDI_Value_Act = getText(driver, EDI_ID_Value_EDI_Creation).trim();

		if (!EDI_Value_Act.equals("")) {
			System.out.println(
					"Expected result is : After confirming EDI ID should be generated : Actual result is : EDI ID generated after Click the Confirm button,  EDI ID : "
							+ EDI_Value_Act);
			Extent_pass_New(driver,
					"Expected result is : After confirming EDI ID should be generated : Actual result is : EDI ID generated after Click the Confirm button,  EDI ID : "
							+ EDI_Value_Act,
					test, test1);
		} else {
			System.out.println(
					"Expected result is : After confirming EDI ID should be generated : Actual result is : EDI not generated after Click the Confirm button,  EDI ID : "
							+ EDI_Value_Act);
			Extent_fail(driver,
					"Expected result is : After confirming EDI ID should be generated : Actual result is : EDI ID not generated after Click the Confirm button,  EDI ID : "
							+ EDI_Value_Act,
					test, test1);
		}

		Step_End(14,
				"A EDI ID will be generated (before it will be blank space, after confirming EDI will be generated. ",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
