package LRP_Phase_1A_NFR_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_User_Management_Report_SC011 extends Keywords {
	public void User_Management_Report_SC011(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_User_Management_Report_SC011";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Report_Module = Excel_data.get("User_Management_Report_Module");
		String User_Option = Excel_data.get("User_Option");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String User_Name_Input = Excel_data.get("User_Name_Input");
		String Template_saved = Excel_data.get("Template_saved");
		String Template_name = Excel_data.get("Template_name");
		String Pin_Header = Excel_data.get("Pin_Header");
		String Sort_Header = Excel_data.get("Sort_Header");

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

		Step_End(3, "Click on show button to display the data", test, test1);

		Step_Start(4, "Apply filters, sort columns, or adjust the layout (anything that defines a “template)", test,
				test1);

		waitForElement(driver, UMR_Usercode_menu_Button);
		click(driver, UMR_Usercode_menu_Button);

		waitForElement(driver, UMR_usercode_Pincolumn);
		mouseOverToElement(driver, UMR_usercode_Pincolumn);

		waitForElement(driver, UMR_pin_Left);
		click(driver, UMR_pin_Left);

		if (isColumnPinnedLeft(driver, UMR_column_Header, Pin_Header)) {
			System.out.println("The Column header is been moved to the left");
			Extent_pass(driver, "The Column header is been moved to the left", test, test1);

		} else {
			System.out.println("The Column header is not been moved to the left");
			Extent_FailNew(driver, "The Column header is not been moved to the left", test, test1);

		}

		formatLocatorClick(driver, UMR_column_Header, Sort_Header);

		String totalRecords = getText(driver, UMR_total_records);

		int rowCount = Integer.parseInt(totalRecords);

		System.out.println("Total row count : " + rowCount);

		List<Map<String, String>> AcendingTable = extractTableDataByRowIndex(driver, UMR_AG_Table, rowCount);
		List<String> accendingValues = getValuesByHeader(AcendingTable, Sort_Header);
		System.out.println("Headers = " + accendingValues);

		if (isSortedAscending(accendingValues)) {
			System.out.println("Expected : The Values in the Table should be in the Accending Order"
					+ " || Actual : The values in the Table is in the Accending Order");
			Extent_pass_New(driver, "Expected : The Values in the Table should be in the Accending Order"
					+ " || Actual : The values in the Table is in the Accending Order ", test, test1);
		} else {
			System.out.println("Expected : The Values in the Table should be in the Accending Order"
					+ " || Actual : The values in the Table is not in the Accending Order");
			Extent_fail(driver, "Expected : The Values in the Table should be in the Accending Order"
					+ " || Actual : The values in the Table is not in the Accending Order", test, test1);
		}

		waitForDisplay(driver, UMR_AG_Table);
		scrollGridToTop(driver, UMR_AG_Table);
		formatLocatorClick(driver, UMR_column_Header, Sort_Header);

		List<Map<String, String>> DescendingTable = extractTableDataByRowIndex(driver, UMR_AG_Table, rowCount);
		List<String> descendingValues = getValuesByHeader(DescendingTable, Sort_Header);
		isSortedDescending(descendingValues);
		if (isSortedDescending(descendingValues)) {
			System.out.println("Expected : The Values in the Table should be in the Descending Order"
					+ " || Actual : The values in the Table is in the Descending Order");
			Extent_pass_New(driver, "Expected : The Values in the Table should be in the Descending Order"
					+ " || Actual : The values in the Table is in the Descending Order ", test, test1);
		} else {
			System.out.println("Expected : The Values in the Table should be in the Descending Order"
					+ " || Actual : The values in the Table is not in the Descending Order");
			Extent_fail(driver, totalRecords, test, test1);

		}

		Step_End(4, "Apply filters, sort columns, or adjust the layout (anything that defines a “template)", test,
				test1);

		Step_Start(5, "Locate and click the settings or gear icon that opens the options menu)", test, test1);

		waitForElement(driver, UMR_optionsmenu_button);
		click(driver, UMR_optionsmenu_button);

		Step_End(5, "Locate and click the settings or gear icon that opens the options menu)", test, test1);

		Step_Start(6, "In the pop-up options, click the first icon labeled “Save Template.”)", test, test1);

		waitForElement(driver, UMR_saveTemplate_button);
		click(driver, UMR_saveTemplate_button);

		Step_End(6, "In the pop-up options, click the first icon labeled “Save Template.”)", test, test1);

		Step_Start(7,
				"A dialog or input box should appear.Enter a unique name for the template (e.g., 'TestTemplate001')",
				test, test1);
		Step_Start(8, "Click the Save or OK button.", test, test1);

		Step_Start(9, "Assert that a success message appears e.g., \"Template saved successfully", test, test1);

		waitForElement(driver, UMR_Template_name_field);
		sendKeys(driver, UMR_Template_name_field, Template_name);

		waitForElement(driver, UMR_SaveTemplate_savebutton_Click);
		click(driver, UMR_SaveTemplate_savebutton_Click);

		//waitForPopup(driver, Popup_Message, Template_saved);
		String Template_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + Template_popup);

		if (Template_saved.equals(Template_popup)) {
			Extent_pass_New(driver, Template_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Template_saved
					+ " || Actual popup value was is display: " + Template_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Template_saved
					+ " || Actual popup value was not display: " + Template_popup);
			Extent_fail(driver, Template_popup, test, test1);

		}

		Step_End(7,
				"A dialog or input box should appear.Enter a unique name for the template (e.g., 'TestTemplate001')",
				test, test1);
		Step_End(8, "Click the Save or OK button.", test, test1);

		Step_End(9, "Assert that a success message appears e.g., \"Template saved successfully", test, test1);

		Step_Start(10,
				"Go back to another tab(Contacts) and Check again whether saved template is appear.(\"TestTemplate001\")"
						+ "",
				test, test1);

		waitForElement(driver, UMR_Dashboard_Tab);
		click(driver, UMR_Dashboard_Tab);

		waitForElement(driver, UMR_input_data_tab);
		click(driver, UMR_input_data_tab);

		String saved_template = String.format(UMR_Select_savedtemplate, Template_name);
		if (isdisplayed(driver, saved_template)) {
			System.out.println("Expected result || saved template should display  ||"
					+ " Actual result : saved template is displayed ");
			Extent_pass_New(driver, "Expected result || saved template should display  ||"
					+ " Actual result : saved template is displayed", test, test1);
		} else {

			System.out.println("Expected result || saved template should display  ||"
					+ " Actual result : saved template is not displayed ");
			Extent_fail(driver, "Expected result || saved template should display  ||"
					+ " Actual result : saved template is not displayed", test, test1);

		}

		Step_End(10,
				"Go back to another tab(Contacts) and Check again whether saved template is appear.(\"TestTemplate001\")"
						+ "",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
