package LRP_EDI_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EDI_Creation_TS_003 extends Keywords {

	public void EDI_Creation_TS_003(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EDI_Creation_TS_003";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");

		String EDI_Creation_Module = Excel_data.get("EDI_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");

		String EDI_Filter_Type1 = Excel_data.get("EDI_Filter_Type1");
		String EDI_Filter_Condition = Excel_data.get("EDI_Filter_Condition");
		String EDI_Filter_Value1 = Excel_data.get("EDI_Filter_Value1");
		String EDI_Filter_Type2 = Excel_data.get("EDI_Filter_Type2");
		String EDI_Filter_Value2 = Excel_data.get("EDI_Filter_Value2");
		String EDI_Filter_Type3 = Excel_data.get("EDI_Filter_Type3");
		String EDI_Filter_Value3 = Excel_data.get("EDI_Filter_Value3");
		String EDI_Format_Value = Excel_data.get("EDI_Format_Value");
		String Agency_Code_Header = Excel_data.get("Agency_Code_Header");
		String Agency_Code_Value = Excel_data.get("Agency_Code_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Version_Select_Value = Excel_data.get("Version_Select_Value");
		String EDI_Updated_Popup = Excel_data.get("EDI_Updated_Popup");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		if (!AgencyUser.equals("")) {
			SwitchProfile(driver, AgencyUser);
		}

		moduleNavigate(driver, EDI_Creation_Module);

		Step_Start(1,
				"Retreive a record from global search and edit the EDI FORMAT and VERSION fields and select the SKIP  TO LAST check box.",
				test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, EDI_Filter_Condition, EDI_Filter_Type1, EDI_Filter_Value1, EDI_Filter_Type2,
				EDI_Filter_Value2, EDI_Filter_Type3, EDI_Filter_Value3);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, EDI_Format_Input_EDI_Creation);
		click(driver, EDI_Format_Input_EDI_Creation);

		String Select_EDI_Format = String.format(EDI_Format_SelectOptions_EDI_Creation, EDI_Format_Value);
		waitForElement(driver, Select_EDI_Format);
		click(driver, Select_EDI_Format);

		waitForElement(driver, Version_Input_EDI_Creation);
		click(driver, Version_Input_EDI_Creation);

		String Select_Version = String.format(Version_SelectOption_EDI_Creation, Version_Select_Value);
		waitForElement(driver, Select_Version);
		click(driver, Select_Version);

		waitForElement(driver, Agency_Code_Search_Btn_EDI_Creation);
		click(driver, Agency_Code_Search_Btn_EDI_Creation);
		twoColumnMultipleSearchWindow(driver, Agency_Code_Header, Condition_Filter, Agency_Code_Value);

		waitForDisplay(driver, Skip_To_LastCheckbox_EDI_Creation);
		jsClick(driver, Skip_To_LastCheckbox_EDI_Creation);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		Step_End(1,
				"Retreive a record from global search and edit the EDI FORMAT and VERSION fields and select the SKIP  TO LAST check box.",
				test, test1);

		Step_Start(2, ".Then click the confirm button .", test, test1);

		waitForElement(driver, Confirm_Button_EDI_Creation);
		click(driver, Confirm_Button_EDI_Creation);
		Step_End(2, ".Then click the confirm button .", test, test1);

		Step_Start(3, "Validation of \" EDI Updated Successfully\" will be displayed", test, test1);

		waitForPopup(driver, popup_Message, EDI_Updated_Popup);
		String Act_Popup = getText(driver, popup_Message);
		if (EDI_Updated_Popup.equals(Act_Popup)) {
			System.out.println("Popup Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup);
			Extent_pass_New(driver, "Popup Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup, test,
					test1);
		} else {
			System.out.println("Popup Not Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup);
			Extent_fail(driver, "Popup Not Matched ||  Expected : " + EDI_Updated_Popup + " || Actual : " + Act_Popup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(3, "Validation of \" EDI Updated Successfully\" will be displayed", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
