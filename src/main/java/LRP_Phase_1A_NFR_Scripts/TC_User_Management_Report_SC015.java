package LRP_Phase_1A_NFR_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_User_Management_Report_SC015 extends Keywords {
	public void User_Management_Report_SC015(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_User_Management_Report_SC015";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Report_Module = Excel_data.get("User_Management_Report_Module");
		String User_Option = Excel_data.get("User_Option");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String User_Name_Input = Excel_data.get("User_Name_Input");

		String Specific_header = Excel_data.get("Specific_header");

		String Grid_Headers_Input = Excel_data.get("Grid_Headers_Input");

		String Filter_Condition = Excel_data.get("Filter_Condition");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login & open user management report screen.", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Report_Module);

		Step_End(1, "Login & open user management report screen.", test, test1);

		Step_Start(2, "Retrieve data by using User Option (By all)", test, test1);

		waitForElement(driver, UMR_User_Option_drop_down);
		click(driver, UMR_User_Option_drop_down);
		formatLocatorClick(driver, DropDown_Select, User_Option);

		waitForElement(driver, UMR_User_Name_Button);
		click(driver, UMR_User_Name_Button);

		twoColumnSearchWindow(driver, User_Name_Header, Dropdown_Condition, User_Name_Input);

		Step_End(2, "Retrieve data by using User Option (By all)", test, test1);

		Step_Start(3, "Click on show button to display the data", test, test1);

		waitForElement(driver, UMR_Show_Button);
		click(driver, UMR_Show_Button);

		waitForElement(driver, UMR_total_records);
		String Exp_Record = getText(driver, UMR_total_records);

		Step_End(3, "Click on show button to display the data", test, test1);

		Step_Start(4, "Find the icon that looks like it might do filtering but with a smug attitude.", test, test1);

		waitForElement(driver, UMR_optionsmenu_button);
		click(driver, UMR_optionsmenu_button);

		Step_End(4, "Find the icon that looks like it might do filtering but with a smug attitude.", test, test1);

		Step_Start(5,
				"Choose city field,Input your filter condition in the provided field, using a comparison operator contains or other operators.Ex: Chennai",
				test, test1);

		waitForElement(driver, UMR_Condition_Filter);
		click(driver, UMR_Condition_Filter);

		Step_End(5,
				"Choose city field,Input your filter condition in the provided field, using a comparison operator contains or other operators.Ex: Chennai",
				test, test1);

		Step_Start(6, "Check that all visible rows in the grid meet the condition.", test, test1);
		Step_Start(7, "Reset the filter and verify that all original rows return to the grid.", test, test1);

		formatLocatorClick(driver, UMR_Grid_Headers, Specific_header);

		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);

		waitForElement(driver, UMR_Filter_Option_Dropdown);
		click(driver, UMR_Filter_Option_Dropdown);

		formatLocatorClick(driver, UMR_Condition_Option, Grid_Headers_Input);

		waitForElement(driver, UMR_Filter_Input_field);
		sendKeys(driver, UMR_Filter_Input_field, Filter_Condition);

		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);

		List<String> headers = splitAndExpand(Specific_header);
		waitForElement(driver, UMR_AG_All_rows);
		List<Map<String, String>> table_data = extractTableDataByColumn(driver, UMR_AG_All_rows);
		List<List<String>> valid_From_Act = getValuesByHeaders(table_data, headers);

		List<String> ActualValues = new ArrayList<String>();

		for (int i = 0; i < valid_From_Act.size(); i++) {

			ActualValues.addAll(valid_From_Act.get(i));
		}

		for (String actvalue : ActualValues) {

			if (actvalue.contains(Filter_Condition)) {

				System.out.println("Matched || Expected || Attribute value : " + Filter_Condition
						+ "|| Actual :  Attribute value  :" + actvalue);
				Extent_pass_New(driver, "Matched || Expected || Attribute value : " + Filter_Condition
						+ "|| Actual :  Attribute value  :" + actvalue, test, test1);

			} else {
				System.out.println("Not Matched || Expected || Attribute value : " + Filter_Condition
						+ "|| Actual :  Attribute value  :" + actvalue);
				Extent_fail(driver, "Not Matched || Expected || Attribute value : " + Filter_Condition
						+ "|| Actual :  Attribute value  :" + actvalue, test, test1);

			}
		}

		waitForElement(driver, UMR_Reset_button);
		click(driver, UMR_Reset_button);

		waitForElement(driver, UMR_total_records);
		String Act_Record = getText(driver, UMR_total_records);

		if (Act_Record.equals(Exp_Record)) {

			System.out.println("Matched || Expected: After clicking the Reset button, the values should : " + Exp_Record
					+ " : reset successfully. || Actual: After clicking the Reset button, the values reset : "
					+ Act_Record + " : successfully.");
			Extent_pass_New(driver,
					"Matched || Expected: After clicking the Reset button, the values should: " + Exp_Record
							+ " : reset successfully. || Actual: After clicking the Reset button, the values reset : "
							+ Act_Record + ": successfully.",
					test, test1);

		} else {
			System.out.println("Not Matched || Expected: After clicking the Reset button, the values should : "
					+ Exp_Record + " :reset successfully. || Actual: After clicking the Reset button, the values : "
					+ Act_Record + " :Not reset.");
			Extent_pass_New(driver,
					"NOt Matched || Expected: After clicking the Reset button, the values should : " + Exp_Record
							+ " :reset successfully. || Actual: After clicking the Reset button, the values : "
							+ Act_Record + " :Not reset.",
					test, test1);

		}

		Step_End(6, "Check that all visible rows in the grid meet the condition..", test, test1);
		Step_End(7, "Reset the filter and verify that all original rows return to the grid.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
