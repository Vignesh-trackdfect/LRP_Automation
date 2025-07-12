package LRP_EDI_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EDI_Creation_TS_002 extends Keywords {

	public void EDI_Creation_TS_002(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EDI_Creation_TS_002";
		
		

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

		String Agency_Code_Header = Excel_data.get("Agency_Code_Header");
		String Agency_Code_Value = Excel_data.get("Agency_Code_Value");

		String Partner_Id_Required_Popup = Excel_data.get("Partner_Id_Required_Popup");
		String EDI_Name_Required_Popup = Excel_data.get("EDI_Name_Required_Popup");
		String EDI_Type_Required_Popup = Excel_data.get("EDI_Type_Required_Popup");
		String GroupCode_Required_Popup = Excel_data.get("GroupCode_Required_Popup");
		String Format_Required_Popup = Excel_data.get("Format_Required_Popup");
		String Version_Required_Popup = Excel_data.get("Version_Required_Popup");
		String Category_Required_Popup = Excel_data.get("Category_Required_Popup");
		String Agency_Required_Popup = Excel_data.get("Agency_Required_Popup");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		if (!AgencyUser.equals("")) {
			SwitchProfile(driver, AgencyUser);
		}

		moduleNavigate(driver, EDI_Creation_Module);

		Step_Start(1,
				"If user left the PARTNER ID  field as blank and click on save button, the validation message  of \"\" Please enter the Partner\"\" should be shown.",
				test, test1);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForPopup(driver, Popup_Message, Partner_Id_Required_Popup);
		String Partner_Popup = getText(driver, Popup_Message);
		if (Partner_Id_Required_Popup.equals(Partner_Popup)) {
			System.out.println(
					"Popup Matched ||  Expected : " + Partner_Id_Required_Popup + " || Actual : " + Partner_Popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + Partner_Id_Required_Popup + " || Actual : " + Partner_Popup, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + Partner_Id_Required_Popup + " || Actual : " + Partner_Popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + Partner_Id_Required_Popup + " || Actual : " + Partner_Popup,
					test, test1);
		}
		Step_End(1,
				"If user left the PARTNER ID  field as blank and click on save button, the validation message  of \"\" Please enter the Partner\"\" should be shown.",
				test, test1);

		Step_Start(2,
				"If user left the EDI ID field as blank and click on save button, the validation message  of \"\"Enter the EDI Name\"\" should be shown",
				test, test1);

		waitForElement(driver, Partner_ID_Search_Btn_EDI_Creation);
		click(driver, Partner_ID_Search_Btn_EDI_Creation);
		twoColumnMultipleSearchWindow(driver, Partner_ID_Header, Condition_Filter, Partner_ID_Value);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForPopup(driver, Popup_Message, EDI_Name_Required_Popup);
		String EDI_Name_Popup = getText(driver, Popup_Message);
		if (EDI_Name_Required_Popup.equals(EDI_Name_Popup)) {
			System.out.println(
					"Popup Matched ||  Expected : " + EDI_Name_Required_Popup + " || Actual : " + EDI_Name_Popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + EDI_Name_Required_Popup + " || Actual : " + EDI_Name_Popup, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + EDI_Name_Required_Popup + " || Actual : " + EDI_Name_Popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + EDI_Name_Required_Popup + " || Actual : " + EDI_Name_Popup,
					test, test1);
		}

		Step_End(2,
				"If user left the EDI ID field as blank and click on save button, the validation message  of \"\"Enter the EDI Name\"\" should be shown",
				test, test1);

		waitForElement(driver, EDI_ID_Input_EDI_Creation);
		sendKeys(driver, EDI_ID_Input_EDI_Creation, EDI_ID_Input_Value);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForPopup(driver, Popup_Message, EDI_Type_Required_Popup);
		String EDI_Type_Popup = getText(driver, Popup_Message);
		if (EDI_Type_Required_Popup.equals(EDI_Type_Popup)) {
			System.out.println(
					"Popup Matched ||  Expected : " + EDI_Type_Required_Popup + " || Actual : " + EDI_Type_Popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + EDI_Type_Required_Popup + " || Actual : " + EDI_Type_Popup, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + EDI_Type_Required_Popup + " || Actual : " + EDI_Type_Popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + EDI_Type_Required_Popup + " || Actual : " + EDI_Type_Popup,
					test, test1);
		}

		Step_Start(4,
				"If user left the GROUP CODE field as blank and click on save button, the validation message  of \"\"Enter the GROUP CODE\"\" should be shown .",
				test, test1);

		waitForElement(driver, Direction_Input_EDI_Creation);
		click(driver, Direction_Input_EDI_Creation);

		String Select_Direction = String.format(Direction_SelectOptions_EDI_Creation, Direction_Select_Value);
		waitForElement(driver, Select_Direction);
		click(driver, Select_Direction);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForPopup(driver, Popup_Message, GroupCode_Required_Popup);
		String GroupCode_Popup = getText(driver, Popup_Message);
		if (GroupCode_Required_Popup.equals(GroupCode_Popup)) {
			System.out.println(
					"Popup Matched ||  Expected : " + GroupCode_Required_Popup + " || Actual : " + GroupCode_Popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + GroupCode_Required_Popup + " || Actual : " + GroupCode_Popup,
					test, test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + GroupCode_Required_Popup + " || Actual : " + GroupCode_Popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + GroupCode_Required_Popup + " || Actual : " + GroupCode_Popup,
					test, test1);
		}
		Step_End(4,
				"If user left the GROUP CODE field as blank and click on save button, the validation message  of \"\"Enter the GROUP CODE\"\" should be shown .",
				test, test1);

		Step_Start(5,
				"If user left the EDI FORMAT field as blank and click on save button, the validation message  of \"\"Enter the FORMAT\" should be shown.",
				test, test1);

		waitForElement(driver, GroupCode_Input_EDI_Creation);
		click(driver, GroupCode_Input_EDI_Creation);

		String Select_GroupCode = String.format(GroupCode_SelectOptions_EDI_Creation, Group_Code_Value);
		waitForElement(driver, Select_GroupCode);
		click(driver, Select_GroupCode);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForPopup(driver, Popup_Message, Format_Required_Popup);
		String Format_Popup = getText(driver, Popup_Message);
		if (Format_Required_Popup.equals(Format_Popup)) {
			System.out
					.println("Popup Matched ||  Expected : " + Format_Required_Popup + " || Actual : " + Format_Popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + Format_Required_Popup + " || Actual : " + Format_Popup, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + Format_Required_Popup + " || Actual : " + Format_Popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + Format_Required_Popup + " || Actual : " + Format_Popup, test,
					test1);
		}
		Step_End(5,
				"If user left the EDI FORMAT field as blank and click on save button, the validation message  of \"\"Enter the FORMAT\" should be shown.",
				test, test1);

		Step_Start(6,
				"If user left the VERSION field as blank and click on save button, the validation message  of \"\"Enter the Version\" should be shown.",
				test, test1);
		waitForElement(driver, EDI_Format_Input_EDI_Creation);
		click(driver, EDI_Format_Input_EDI_Creation);

		String Select_EDI_Format = String.format(EDI_Format_SelectOptions_EDI_Creation, EDI_Format_Value);
		waitForElement(driver, Select_EDI_Format);
		click(driver, Select_EDI_Format);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForPopup(driver, Popup_Message, Version_Required_Popup);
		String Version_Popup = getText(driver, Popup_Message);
		if (Version_Required_Popup.equals(Version_Popup)) {
			System.out.println(
					"Popup Matched ||  Expected : " + Version_Required_Popup + " || Actual : " + Version_Popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + Version_Required_Popup + " || Actual : " + Version_Popup, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + Version_Required_Popup + " || Actual : " + Version_Popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + Version_Required_Popup + " || Actual : " + Version_Popup,
					test, test1);
		}

		Step_End(6,
				"If user left the VERSION field as blank and click on save button, the validation message  of \"\"Enter the Version\" should be shown.",
				test, test1);

		waitForElement(driver, Version_Input_EDI_Creation);
		click(driver, Version_Input_EDI_Creation);

		String Select_Version = String.format(Version_SelectOption_EDI_Creation, Version_Select_Value);
		waitForElement(driver, Select_Version);
		click(driver, Select_Version);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForPopup(driver, Popup_Message, Category_Required_Popup);
		String Category_Popup = getText(driver, Popup_Message);
		if (Category_Required_Popup.equals(Category_Popup)) {
			System.out.println(
					"Popup Matched ||  Expected : " + Category_Required_Popup + " || Actual : " + Category_Popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + Category_Required_Popup + " || Actual : " + Category_Popup, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + Category_Required_Popup + " || Actual : " + Category_Popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + Category_Required_Popup + " || Actual : " + Category_Popup,
					test, test1);
		}

		Step_Start(3,
				"If user left the Agency code field as blank and click on save button, the validation message  of \"\"Please select the agency(s)\"\" should be shown.",
				test, test1);

		waitForElement(driver, Category_Search_Btn_EDI_Creation);
		click(driver, Category_Search_Btn_EDI_Creation);
		twoColumnMultipleSearchWindow(driver, EDI_Category_Header, Condition_Filter, EDI_Category_Value);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForPopup(driver, Popup_Message, Agency_Required_Popup);
		String Agency_Popup = getText(driver, Popup_Message);
		if (Agency_Required_Popup.equals(Agency_Popup)) {
			System.out
					.println("Popup Matched ||  Expected : " + Agency_Required_Popup + " || Actual : " + Agency_Popup);
			Extent_pass_New(driver,
					"Popup Matched ||  Expected : " + Agency_Required_Popup + " || Actual : " + Agency_Popup, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched ||  Expected : " + Agency_Required_Popup + " || Actual : " + Agency_Popup);
			Extent_fail(driver,
					"Popup Not Matched ||  Expected : " + Agency_Required_Popup + " || Actual : " + Agency_Popup, test,
					test1);
		}

		waitForElement(driver, Agency_Code_Search_Btn_EDI_Creation);
		click(driver, Agency_Code_Search_Btn_EDI_Creation);
		twoColumnMultipleSearchWindow(driver, Agency_Code_Header, Condition_Filter, Agency_Code_Value);
		Step_End(3,
				"If user left the Agency code field as blank and click on save button, the validation message  of \"\"Please select the agency(s)\"\" should be shown.",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
