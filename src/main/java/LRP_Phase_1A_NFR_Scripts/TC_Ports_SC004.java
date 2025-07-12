package LRP_Phase_1A_NFR_Scripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Ports_SC004 extends Keywords {
	public void Ports_SC004(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws IOException {

		String testCaseName = "TC_Ports_SC004";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Ports_Module = Excel_data.get("Ports_Module");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Global_Loc_Search_Header = Excel_data.get("Global_Loc_Search_Header");
		String Port_Loc_Code = Excel_data.get("Port_Loc_Code");

		String Change_From_date_TextField = Excel_data.get("Change_From_date_TextField");
		String Change_To_date_TextField = Excel_data.get("Change_To_date_TextField");
		String DatePicker = Excel_data.get("DatePicker");

		String Port_Loc_Updated_popup = Excel_data.get("Port_Loc_Updated_popup");
		String Time_Zone_Module = Excel_data.get("Time_Zone_Module");
		String Time_Loc_Code_Header = Excel_data.get("Time_Loc_Code_Header");

		String Timezone_Header = Excel_data.get("Timezone_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Timezone_value = Excel_data.get("Timezone_value");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login the application.", test, test1);

		LRP_Login(driver, username, pass_word);

		Step_End(1, "Login the application.", test, test1);

		Step_Start(2, " Navigate to Ports Screen.", test, test1);

		// verifyMainMenu(driver);

		moduleNavigate(driver, Ports_Module);

		Step_End(2, " Navigate to Ports Screen.", test, test1);

		Step_Start(3, ".Retrieve the data from ports screen.", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition1, Global_Loc_Search_Header, Port_Loc_Code, "", "", "", "");

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Timeoffst_search);
		click(driver, Timeoffst_search);

		twoColumnSearchWindow(driver, Timezone_Header, Search_Condition, Timezone_value);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(3, ".Retrieve the data from ports screen.", test, test1);

		Step_Start(4, "Enter the Change From Date.;", test, test1);

		if (!Change_From_date_TextField.equals("")) {
			if (DatePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Change_From_date_Field);
				click(driver, Change_From_date_Field);
				selectDatePicker(driver, Change_From_date_TextField);
			} else {
				waitForElement(driver, Change_From_date_Field);
				clearAndType(driver, Change_From_date_Field, Change_From_date_TextField);
			}
		}

		Step_End(4, "Enter the Change From Date.;", test, test1);

		Step_Start(5, "Enter the Change To Date.;", test, test1);

		if (!Change_To_date_TextField.equals("")) {
			if (DatePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Change_To_date_Field);
				click(driver, Change_To_date_Field);
				selectDatePicker(driver, Change_To_date_TextField);
			} else {
				waitForElement(driver, Change_To_date_Field);
				clearAndType(driver, Change_To_date_Field, Change_To_date_TextField);
			}
		}

		Step_End(5, "Enter the Change To Date.;", test, test1);

		Step_Start(6, "Click on Save button.System Prompt \" Location Updated\".", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Port_Loc_Updated_popup);
		String Updated_popup = getText(driver, popup_Message);
		System.out.println("Updated_popup is :" + Updated_popup);

		if (Port_Loc_Updated_popup.equals(Updated_popup)) {
			Extent_pass_New(driver, "Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup was  displayed : " + Updated_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup was displayed: " + Updated_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup  was not displayed: " + Updated_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup  was not displayed: " + Updated_popup, test, test1);

		}

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		String Timezone_port = getAttribute(driver, Timezone_Textfield, "value");
		System.out.println("Timezone in port : " + Timezone_port);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(6, "Click on Save button.System Prompt \" Location Updated\".", test, test1);

		Step_Start(7, "Open Timezone screen..", test, test1);

		moduleNavigate(driver, Time_Zone_Module);

		Step_End(7, "Open Timezone screen..", test, test1);

		Step_Start(8, "Search the ports from timezone screen.Ex:QQQQQ.", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition1, Time_Loc_Code_Header, Port_Loc_Code, "", "", "", "");

		Step_End(8, "Search the ports from timezone screen.Ex:QQQQQ.", test, test1);

		Step_Start(9, "To verify the result whether time zone is reflecting on screen.", test, test1);

		String Actual_TimeZone_value = getAttribute(driver, Timezone_timezonemodule, "value");
		System.out.println("Actual Time day Light is :" + Actual_TimeZone_value);

		if (Timezone_port.equals(Actual_TimeZone_value)) {

			System.out.println(
					"Matched || Expected : after updated the time zone in port, The Timezone is :" + Timezone_port
							+ "|| Actual : after updated the time zone in time zone module, but The Timezone is :"
							+ Actual_TimeZone_value);
			Extent_pass_New(driver,
					"Matched || Excepted :  after updated the time zone in port, The Timezone is :" + Timezone_port
							+ "|| Actual :  after updated the time zone in time zone module, but The Timezone  is :"
							+ Actual_TimeZone_value,
					test, test1);
		}

		else {
			System.out.println("NotMatched || Excepted : after updated the time zone in port module, The Timezone  is :"
					+ Timezone_port + "|| Actual : after updated the time zone in time zone module, The Timezone is :"
					+ Actual_TimeZone_value);
			Extent_fail(driver,
					"NotMatched || Excepted : after updated the time zone in port module, The TimeDay Ligh"
							+ "the timezone in port value is :" + Timezone_port
							+ "|| Actual : after updated the time zone in time zone module, The time zone in port  is :"
							+ Actual_TimeZone_value,
					test, test1);
		}

		Step_End(9, "To verify the result whether time zone is reflecting on screen..", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
