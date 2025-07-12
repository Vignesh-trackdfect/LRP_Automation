package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS053 extends Keywords {

	public void Cost_Activity_Report_TS053(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS053";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String Approve_popup = Excel_data.get("Approve_popup");
		String filtercolumns = Excel_data.get("filtercolumns");
		String Status1 = Excel_data.get("Status1");
		String Status2 = Excel_data.get("Status2");
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

		Step_Start(9, "Click on the expense report option", test, test1);

		waitForElement(driver, Expense_report);
		click(driver, Expense_report);

		Step_End(9, "Click on the expense report option", test, test1);

		Step_Start(10, "A new window will be opened with open and approve expenses", test, test1);
		waitForElement(driver, Open_Expensive_CAR);
		Step_End(10, "A new window will be opened with open and approve expenses", test, test1);

		Step_Start(11, "Click on the open expense tab", test, test1);
		click(driver,Open_Expensive_CAR);
		
		waitForElement(driver, Open_Expenses_Column);
		click(driver, Open_Expenses_Column);

		waitForDisplay(driver, Open_Expe_SelectAll_Checkbox);
		click(driver, Open_Expe_SelectAll_Checkbox);
		if(isdisplayed(driver, Open_Expense_Table_Rows)) {
			waitForDisplay(driver, Open_Expe_SelectAll_Checkbox);
			click(driver, Open_Expe_SelectAll_Checkbox);
		}
		
		List<String> column_Headers = splitAndExpand(filtercolumns);
		for (int i = 0; i < column_Headers.size(); i++) {
			String column = column_Headers.get(i);
			waitForElement(driver, Open_Expense_column_Searchbox);
			click(driver, Open_Expense_column_Searchbox);
			clear(driver, Open_Expense_column_Searchbox);
			sendKeys(driver, Open_Expense_column_Searchbox, column);

			String checkbox = String.format(Open_Expense_Colum_CheckBox, column);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}
		waitForElement(driver, Open_Expenses_Column);
		click(driver, Open_Expenses_Column);
		Step_End(11, "Click on the open expense tab", test, test1);

		List<WebElement> OpenExpenses = listOfElements(driver, CAR_InApprovedrows);
		Step_Start(12, "Select the required activities", test, test1);
		Actions act=new Actions(driver);
		act.keyDown(Keys.CONTROL).build().perform();
		for (WebElement expense : OpenExpenses) {
			String status = expense.getText();
			if (status.equals(Status1) || status.equals(Status2)) {
				expense.click();
			}
		}
		act.keyUp(Keys.CONTROL).build().perform();
		Step_End(12, "Select the required activities", test, test1);

		Step_Start(13, "Click on the approve option", test, test1);
		waitForElement(driver, Accept_expense);
		click(driver, Accept_expense);
		Step_End(13, "Click on the approve option", test, test1);

		Step_Start(14, "If the activities are in draft and rejected status, then the system validates as \" Draft / Rejected activities cannot be approved\". ", test, test1);

		waitForPopup(driver, popup_Message, Approve_popup);
		String PopupMEssage = getText(driver, popup_Message);
		
		if (PopupMEssage.contains(Approve_popup)) {
			System.out.println("Matched || Expected popup : " + Approve_popup+ " || Actual popup : " + PopupMEssage);
			Extent_pass_New(driver, "Matched || Expected popup : " + Approve_popup+ " || Actual popup : " + PopupMEssage, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup : " + Approve_popup+ " || Actual popup : " + PopupMEssage);
			Extent_fail(driver, "Not Matched || Expected popup : " + Approve_popup+ " || Actual popup : " + PopupMEssage, test, test1);
		}
		Step_End(14, "If the activities are in draft and rejected status, then the system validates as \" Draft / Rejected activities cannot be approved\". ", test, test1);

		Step_Start(15, "Click on the ok option.", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(15, "Click on the ok option.", test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
