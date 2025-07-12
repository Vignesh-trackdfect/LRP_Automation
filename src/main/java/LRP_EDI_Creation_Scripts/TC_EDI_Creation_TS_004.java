package LRP_EDI_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EDI_Creation_TS_004 extends Keywords {

	public void EDI_Creation_TS_004(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EDI_Creation_TS_004";
		
		

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

		String Select_Mode_Value = Excel_data.get("Select_Mode_Value");
		String Minute_Value = Excel_data.get("Minute_Value");
		String EDI_Updated_Popup = Excel_data.get("EDI_Updated_Popup");

		String EDI_List_Module = Excel_data.get("EDI_List_Module");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		if (!AgencyUser.equals("")) {
			SwitchProfile(driver, AgencyUser);
		}

		moduleNavigate(driver, EDI_Creation_Module);

		Step_Start(1, "Retreive a record from global search and click the Settins Button", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, EDI_Filter_Condition, EDI_Filter_Type1, EDI_Filter_Value1, EDI_Filter_Type2,
				EDI_Filter_Value2, EDI_Filter_Type3, EDI_Filter_Value3);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, SettingBtn_EDI_Creation);
		click(driver, SettingBtn_EDI_Creation);
		Step_End(1, "Retreive a record from global search and click the Settins Button", test, test1);

		Step_Start(2, "Select the MODE dropdown and enter the Minute field and click apply and Confirm the EDI ID.",
				test, test1);
		waitForElement(driver, ModeSelect_Input_EDI_Creation);
		click(driver, ModeSelect_Input_EDI_Creation);

		String Mode_Select = String.format(ModeSelectOption_EDI_Creation, Select_Mode_Value);
		waitForElement(driver, Mode_Select);
		click(driver, Mode_Select);

		if (Select_Mode_Value.equalsIgnoreCase("Automatic")) {
			waitForElement(driver, Minute_Input_EDI_Creation);
			sendKeys(driver, Minute_Input_EDI_Creation, Minute_Value);
		}

		waitForElement(driver, Apply_Button_EDI_Creation);
		click(driver, Apply_Button_EDI_Creation);

		waitForDisplay(driver, Skip_To_LastCheckbox_EDI_Creation);
		jsClick(driver, Skip_To_LastCheckbox_EDI_Creation);

		waitForElement(driver, Next_Button_EDI_Creation);
		click(driver, Next_Button_EDI_Creation);

		waitForElement(driver, Confirm_Button_EDI_Creation);
		click(driver, Confirm_Button_EDI_Creation);

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
		Step_End(2, "Select the MODE dropdown and enter the Minute field and click apply and Confirm the EDI ID.", test,
				test1);

		Step_Start(3, "Navigate to EDI LIST module and filter the EDI ID Column and search the saved EDI previously.",
				test, test1);
		moduleNavigate(driver, EDI_List_Module);

		waitForElement(driver, Table_EDI_List);

		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);
		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);

		waitForElement(driver, EDI_ID_Filter_Input);
		sendKeys(driver, EDI_ID_Filter_Input, EDI_Filter_Value1);
		Step_End(3, "Navigate to EDI LIST module and filter the EDI ID Column and search the saved EDI previously.",
				test, test1);

		Step_Start(4, ".In MODE column, the mode should be AUTOMATIC", test, test1);

		String EDI_ID_modeColumn = String.format(Mode_Column_EDI_List, EDI_Filter_Value1);
		waitForElement(driver, EDI_ID_modeColumn);
		String Act_Mode = getText(driver, EDI_ID_modeColumn);

		if (Act_Mode.equals(Select_Mode_Value)) {
			System.out.println("Mode Matched ||  Expected : " + Select_Mode_Value + "  ||  Actual : " + Act_Mode);
			Extent_pass_New(driver,
					"Expected result is : In Mode column, The mode should be Automatic Actual result is : In Mode column, the mode is shows as 'AUTOMATIC'",
					test, test1);
			Extent_pass_New(driver, "Mode Matched ||  Expected : " + Select_Mode_Value + "  ||  Actual : " + Act_Mode, test,
					test1);
		} else {
			System.out.println("Mode not selected as AUTOMATIC ||  Expected : " + Select_Mode_Value + "  ||  Actual : "
					+ Act_Mode);
			Extent_fail(driver,
					"Mode not selected as AUTOMATIC ||  Expected : " + Select_Mode_Value + "  ||  Actual : " + Act_Mode,
					test, test1);
		}

		Step_End(4, ".In MODE column, the mode should be AUTOMATIC", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
