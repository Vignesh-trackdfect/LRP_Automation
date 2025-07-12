package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS054 extends Keywords {

	public void Cost_Activity_Report_TS054(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS054";
		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String filtercolumns = Excel_data.get("filtercolumns");
		String Agency = Excel_data.get("Agency");

		Extent_Start(tc_Name, test, test1);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		Step_End(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		verifyMainMenu(driver);
		SwitchProfile(driver, Agency);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, "Check whether it opens a new search window", test, test1);

		if (isdisplayed(driver, type_Select1)) {

			System.out.println("Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver, "Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully" , test, test1);
			
		}else {
			System.out.println("Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver, "Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully" , test, test1);
		}

		Step_End(4, "Check whether it opens a new search window", test, test1);

		Step_Start(5, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_Start(6, "Then click on the search button", test, test1);

		Step_Start(7, "System will show the CAR No", test, test1);

		Step_Start(8, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		globalValueSearchWindow(driver, Condition, Select_search_value, CAR_No, "", "", "", "");

		Step_End(5, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_End(6, "Then click on the search button", test, test1);

		Step_End(7, "System will show the CAR No", test, test1);

		waitForElement(driver, CAR_Input);
		String retrived_Number = getAttribute(driver, CAR_Input, "value");

		if (retrived_Number.equals(CAR_No)) {

			System.out.println("The given CAR No was retrived || Expected CAR No : " + CAR_No + " || Actual CAR No : "
					+ retrived_Number);
			Extent_pass_New(driver, "The given CAR No was retrived || Expected CAR No : " + CAR_No + " || Actual CAR No : "
					+ retrived_Number, test, test1);
		} else {
			System.out.println("The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number);
			Extent_fail(driver, "The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number, test, test1);
		}
		
		Step_End(8, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		Step_Start(9,
				"Ensure that the total approved cost is shown in screen and compare the cost with Sum of the Total cost which is available in the Cost as per USD column in Expense report Approved Expenses tab",
				test, test1);

		waitForElement(driver, Total_ApprovedCost);
		String total_cost = getText(driver, Total_ApprovedCost);

		String splitcost[] = total_cost.split(" ");
		String Displayed_totalCost = splitcost[0].replace(",", "");

		waitForElement(driver, Expense_report);
		click(driver, Expense_report);

		waitForElement(driver, ApprovedExpenses);
		click(driver, ApprovedExpenses);

		waitForElement(driver, Approved_Columns);
		click(driver, Approved_Columns);

		waitForDisplay(driver, Approved_Deselect);
		jsClick(driver, Approved_Deselect);

		List<String> filter_columns2 = splitAndExpand(filtercolumns);

		for (String columnname : filter_columns2) {

			waitForElement(driver, Approved_FilterInput);
			clear(driver, Approved_FilterInput);
			sendKeys(driver, Approved_FilterInput, columnname);

			waitForElement(driver, Approved_FilterInput);
			jsClick(driver, Approved_Deselect);
		}

		waitForElement(driver, CAR_totalCostUSDList);
		List<WebElement> AE_Head_field = listOfElements(driver, CAR_totalCostUSDList);

		double Converted_TotalCost = 0.00;

		for (WebElement element : AE_Head_field) {

			String cost = element.getText().replace(",", "");

			double onecost = Double.parseDouble(cost);

			Converted_TotalCost = Converted_TotalCost + onecost;

		}

		String Expected_TotalCost = String.valueOf(Converted_TotalCost);

		if (Expected_TotalCost.equals(Displayed_totalCost)) {

			System.out.println("System shows the total approved cost as per the expense Tab || Expected cost : "
					+ Expected_TotalCost + " Actual Cost: " + Displayed_totalCost);
			Extent_pass_New(driver, "System shows the total approved cost as per the expense Tab || Expected cost : "
					+ Expected_TotalCost + " Actual Cost: " + Displayed_totalCost, test, test1);

		} else {

			System.out.println("System shows the total approved cost not as per the expense Tab || Expected cost : "
					+ Expected_TotalCost + " Actual Cost: " + Displayed_totalCost);
			Extent_fail(driver, "System shows the total approved cost not as per the expense Tab || Expected cost : "
					+ Expected_TotalCost + " Actual Cost: " + Displayed_totalCost, test, test1);

		}
		
		Step_End(9,
				"Ensure that the total approved cost is shown in screen and compare the cost with Sum of the Total cost which is available in the Cost as per USD column in Expense report Approved Expenses tab",
				test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
