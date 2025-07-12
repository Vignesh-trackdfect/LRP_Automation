package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS068 extends Keywords {

	public void Cost_Activity_Report_TS068(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS068";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		String more_options_menu_List = Excel_data.get("more_options_menu_List");
		String aed_currency = Excel_data.get("aed_currency");
		String usd_currency = Excel_data.get("usd_currency");
		String currency_column = Excel_data.get("currency_column");
		String total_cost_column = Excel_data.get("total_cost_column");
		String total_cost_usd_column = Excel_data.get("total_cost_usd_column");
		String Expensive_Table_Filter_Headers = Excel_data.get("Expensive_Table_Filter_Headers");

		String Search_Type2 =Excel_data.get("Search_Type2");
		String Search_Input2 =Excel_data.get("Search_Input2");
		String Search_Type3 =Excel_data.get("Search_Type3");
		String Search_Input3 =Excel_data.get("Search_Input3");
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select the required agency.",
				test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.",
				test, test1);

		Step_Start(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);

		newButton(driver);
		
		Step_Start(3, "Click on the global search option which is available in the tool bar.    ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(3, "Click on the global search option which is available in the tool bar.    ", test, test1);

		Step_Start(4, "Check whether it opens a new search window. ", test, test1);
		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button. ", test, test1);
		Step_Start(7, "System will show the CAR No ", test, test1);

		globalValueSearchWindow(driver, CAR_Retrieve_Condition, CAR_Retrieve_Type, CAR_Number_Retrieve, Search_Type2, Search_Input2, Search_Type3, Search_Input3);
		Step_End(4, "Check whether it opens a new search window. ", test, test1);

		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);

		Step_End(6, "Then click on the search button. ", test, test1);

		Step_End(7, "System will show the CAR No", test, test1);

		Step_Start(8, "Click on the click for more options above the grid.", test, test1);

		waitForElement(driver, more_options_Car);
		click(driver, more_options_Car);

		Step_End(8, "Click on the click for more options above the grid.", test, test1);

		Step_Start(9, "Select the cost summary option.", test, test1);

		String more_Options_Select = String.format(more_options_menu_Car, more_options_menu_List);
		waitForElement(driver, more_Options_Select);
		click(driver, more_Options_Select);

		Step_End(9, "Select the cost summary option.", test, test1);

		Step_Start(10, "Ensure that a new window gets opened.", test, test1);
		waitForDisplay(driver, total_cost_summary_window_Car);
		if (isdisplayed(driver, total_cost_summary_window_Car)) {

			System.out.println("Expected : Total cost summary window Should opened || Actual : Total cost summary window is opened" );
			Extent_pass_New(driver, "Expected : Total cost summary window Should opened || Actual : Total cost summary window is opened" , test, test1);

		} else {
			System.out.println("Expected : Total cost summary window Should opened || Actual : Total cost summary window is not opened" );
			Extent_fail(driver, "Expected : Total cost summary window Should opened || Actual : Total cost summary window is not opened" , test, test1);

		}
		Step_End(10, "Ensure that a new window gets opened.", test, test1);

		Step_Start(11,
				"Ensure that details are shown based on the status of the activities and currency used and total cost details for the activities collectively based on the details shown in expense report.",
				test, test1);

		waitForElement(driver, total_cost_summary_table_Car);
		List<Map<String, String>> total_Cost_Table_Data = extractTableDataByColumnWithoutScroll(driver,
				total_cost_summary_table_Car);

		System.out.println(total_Cost_Table_Data);
		String aed_total_cost_expected = getValueByFirstColumnAndHeader(total_Cost_Table_Data, currency_column,
				aed_currency, total_cost_column);
		String usd_total_cost_expected = getValueByFirstColumnAndHeader(total_Cost_Table_Data, currency_column,
				usd_currency, total_cost_column);

		String aed_total_cost_usd_expected = getValueByFirstColumnAndHeader(total_Cost_Table_Data, currency_column,
				aed_currency, total_cost_usd_column);
		String usd_total_cost_usd_expected = getValueByFirstColumnAndHeader(total_Cost_Table_Data, currency_column,
				usd_currency, total_cost_usd_column);

		Step_End(11,
				"Ensure that details are shown based on the status of the activities and currency used and total cost details for the activities collectively based on the details shown in expense report.",
				test, test1);

		Step_Start(12, "Click on the ok option.", test, test1);
		waitForElement(driver, summary_ok_btn);
		click(driver, summary_ok_btn);

		Step_End(12, "Click on the ok option.", test, test1);

		Step_Start(13, "Compare the Total Cost and Total Cost(USD) with the expense report tab based on each status.",
				test, test1);
		waitForElement(driver, expense_report_Car);
		click(driver, expense_report_Car);

		waitForElement(driver, approved_expenses_option);
		click(driver, approved_expenses_option);

		waitForElement(driver, expense_report_sidebar_columns);
		click(driver, expense_report_sidebar_columns);
		waitForElement(driver, expense_report_filter_input);
		jsClick(driver, expense_report_select_all_checkbox);

		List<String> ExpensiveTable_Headers = splitAndExpand(Expensive_Table_Filter_Headers);
		for (String FilterHeader : ExpensiveTable_Headers) {
			waitForElement(driver, expense_report_filter_input);
			clear(driver, expense_report_filter_input);
			waitForElement(driver, expense_report_filter_input);
			sendKeys(driver, expense_report_filter_input, FilterHeader);

			if (FilterHeader.equals("Cost as per USD")) {

				String checkbox = String.format(expense_report_select_column_checkbox, total_cost_column);
				waitForDisplay(driver, checkbox);
				jsClick(driver, checkbox);

			} else if (FilterHeader.equals("Currency")) {

				String checkbox = String.format(expense_report_select_column_checkbox, currency_column);
				waitForDisplay(driver, checkbox);
				jsClick(driver, checkbox);

				String checkbox1 = String.format(expense_report_select_column_checkbox, total_cost_column);
				waitForDisplay(driver, checkbox1);
				jsClick(driver, checkbox1);

			} else if (FilterHeader.equals("Cost as per Contract Currency")) {

				String checkbox = String.format(expense_report_select_column_checkbox, FilterHeader);
				waitForDisplay(driver, checkbox);
				jsClick(driver, checkbox);

				String checkbox1 = String.format(expense_report_select_column_checkbox, "Unit Cost");
				waitForDisplay(driver, checkbox1);
				jsClick(driver, checkbox1);
			}else {
				String checkbox = String.format(expense_report_select_column_checkbox, FilterHeader);
				waitForDisplay(driver, checkbox);
				jsClick(driver, checkbox);
			}
		}

		waitForElement(driver, expense_report_sidebar_columns);
		click(driver, expense_report_sidebar_columns);

		List<WebElement> aed_cells = listOfElements(driver, total_cost_contract_currency_columns);
		List<WebElement> aed_cells_usd = listOfElements(driver, total_cost_usd_first_currency_cells);
		List<WebElement> usd_cells_first = listOfElements(driver, total_cost_usd_contract_columns);
		List<WebElement> usd_cells_second = listOfElements(driver, total_cost_usd_columns);

		// 1
		Actions a = new Actions(driver);

		a.keyDown(Keys.CONTROL).perform();

		for (int i = 0; i < aed_cells.size(); i++) {

			WebElement aed_cell = aed_cells.get(i);
			Click(driver, aed_cell);

		}

		a.keyUp(Keys.CONTROL).perform();

		String aed_total_actual = getText(driver, expense_report_sum_amount);

		// 2
		WebElement trial_click = aed_cells_usd.get(0);
		Click(driver, trial_click);

		a.keyDown(Keys.CONTROL).perform();

		for (int i = 0; i < aed_cells_usd.size(); i++) {

			WebElement aed_cell = aed_cells_usd.get(i);
			Click(driver, aed_cell);

		}

		a.keyUp(Keys.CONTROL).perform();

		String aed_total_usd_actual = getText(driver, expense_report_sum_amount);

		// 3

		trial_click = usd_cells_first.get(0);
		Click(driver, trial_click);
		a.keyDown(Keys.CONTROL).perform();

		for (int i = 1; i < usd_cells_first.size(); i++) {

			WebElement usd_cell = usd_cells_first.get(i);
			Click(driver, usd_cell);

		}

		a.keyUp(Keys.CONTROL).perform();

		String usd_cell_contract_actual = getText(driver, expense_report_sum_amount);

		// 4

		trial_click = usd_cells_second.get(0);
		Click(driver, trial_click);
		a.keyDown(Keys.CONTROL).perform();

		for (int i = 1; i < usd_cells_second.size(); i++) {

			WebElement usd_cell = usd_cells_second.get(i);
			Click(driver, usd_cell);

		}

		a.keyUp(Keys.CONTROL).perform();

		waitForElement(driver, expense_report_sum_amount);
		String usd_cell_second_actual = getText(driver, expense_report_sum_amount);

		// 1
		if (aed_total_actual.equals(aed_total_cost_expected)) {

			System.out.println("Matched || Expected currency value : " + aed_total_cost_expected
					+ "|| actual currency value : " + aed_total_actual);
			Extent_pass_New(driver, "Matched || Expected currency value : " + aed_total_cost_expected
					+ "|| actual currency value : " + aed_total_actual, test, test1);
		} else {

			System.out.println("Not Matched || Expected currency value : " + aed_total_cost_expected
					+ "|| actual currency value : " + aed_total_actual);
			Extent_fail(driver, "Not Matched || Expected currency value : " + aed_total_cost_expected
					+ "|| actual currency value : " + aed_total_actual, test, test1);

		}

		// 2
		if (aed_total_usd_actual.equals(aed_total_cost_usd_expected)) {

			System.out.println("Matched || Expected currency value : " + aed_total_usd_actual
					+ "|| actual currency value : " + aed_total_cost_usd_expected);
			Extent_pass_New(driver, "Matched || Expected currency value : " + aed_total_usd_actual
					+ "|| actual currency value : " + aed_total_cost_usd_expected, test, test1);
		} else {

			System.out.println("Not Matched || Expected currency value : " + aed_total_usd_actual
					+ "|| actual currency value : " + aed_total_cost_usd_expected);
			Extent_fail(driver, "Not Matched || Expected currency value : " + aed_total_usd_actual
					+ "|| actual currency value : " + aed_total_cost_usd_expected, test, test1);

		}
//3

		if (usd_cell_contract_actual.equals(usd_total_cost_expected)) {

			System.out.println("Matched || Expected currency value : " + usd_total_cost_expected
					+ "|| actual currency value : " + usd_cell_contract_actual);
			Extent_pass_New(driver, "Matched || Expected currency value : " + usd_total_cost_expected
					+ "|| actual currency value : " + usd_cell_contract_actual, test, test1);
		} else {

			System.out.println("Not Matched || Expected currency value : " + usd_total_cost_expected
					+ "|| actual currency value : " + usd_cell_contract_actual);
			Extent_fail(driver, "Not Matched || Expected currency value : " + usd_total_cost_expected
					+ "|| actual currency value : " + usd_cell_contract_actual, test, test1);

		}

//4

		if (usd_cell_second_actual.equals(usd_total_cost_usd_expected)) {

			System.out.println("Matched || Expected currency value : " + usd_cell_second_actual
					+ "|| actual currency value : " + usd_total_cost_usd_expected);
			Extent_pass_New(driver, "Matched || Expected currency value : " + usd_cell_second_actual
					+ "|| actual currency value : " + usd_total_cost_usd_expected, test, test1);
		} else {

			System.out.println("Not Matched || Expected currency value : " + usd_cell_second_actual
					+ "|| actual currency value : " + usd_total_cost_usd_expected);
			Extent_fail(driver, "Not Matched || Expected currency value : " + usd_cell_second_actual
					+ "|| actual currency value : " + usd_total_cost_usd_expected, test, test1);

		}

		Step_End(13, "Compare the Total Cost and Total Cost(USD) with the expense report tab based on each status.",
				test, test1);

		Extent_completed(tc_Name, test, test1);

	}
}
