package LRP_Cost_Scripts;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS024 extends Keywords {

	public void Cost_Activity_Report_TS024(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS024";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String FilterColumn1 = Excel_data.get("FilterColumn1");
		String FilterColumn2 = Excel_data.get("FilterColumn2");
		String FilterColumn3 = Excel_data.get("FilterColumn3");
		String Agency = Excel_data.get("Agency");
		String No_records_Message = Excel_data.get("No_records_Message");

		Extent_Start(tc_Name, test, test1);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		if (!Agency.equals("")) {

			SwitchProfile(driver, Agency);

		}

		Step_End(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		verifyMainMenu(driver);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field", test, test1);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, "Check whether it opens a new search window", test, test1);

		waitForDisplay(driver, type_Select1);

		if (isdisplayed(driver, type_Select1)) {

			System.out.println(
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver,
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully",
					test, test1);

		} else {
			System.out.println(
					"Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver,
					"Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully",
					test, test1);
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

		Step_End(8, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		Step_Start(9, "System will retrieve the CAR", test, test1);

		waitForElement(driver, CAR_Input);
		String retrived_Number = getAttribute(driver, CAR_Input, "value");

		if (retrived_Number.equals(CAR_No)) {

			System.out.println("The given CAR No was retrived || Expected CAR No : " + CAR_No + " || Actual CAR No : "
					+ retrived_Number);
			Extent_pass_New(driver, "The given CAR No was retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number, test, test1);
		} else {
			System.out.println("The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number);
			Extent_fail(driver, "The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number, test, test1);
		}

		Step_End(9, "System will retrieve the CAR", test, test1);

		Step_Start(10, "Click on the Expense report button and check system opens a new tab", test, test1);

		waitForElement(driver, Expense_report);
		click(driver, Expense_report);

		waitForElement(driver, Open_Expensive_CAR);
		click(driver, Open_Expensive_CAR);

		Step_End(10, "Click on the Expense report button and check system opens a new tab", test, test1);

		Step_Start(11,
				"Next click the Show total summary option in open expense tab for the Draft,Submitted and Rejected records.If the activities are approved , then go to the  approved expense tab and click the show total summary option",
				test, test1);

		waitForElement(driver, Show_TotalCurrency);
		click(driver, Show_TotalCurrency);

		if (isdisplayed(driver, popup_Message)) {
			String popAct = getText(driver, popup_Message);
			if (No_records_Message.equals(popAct)) {
				System.out.println(
						"Expected : Total Summary table should be display || Actual : Error popup displayed , popupText : "
								+ popAct);
				Extent_FailNew(driver,
						"Expected : Total Summary table should be display || Actual : Error popup displayed , popupText : "
								+ popAct,
						test, test1);
			} else {
				System.out.println(
						"Expected : Total Summary table should be display || Actual : Error popup displayed , popupText : "
								+ popAct);
				Extent_fail(driver,
						"Expected : Total Summary table should be display || Actual : Error popup displayed , popupText : "
								+ popAct,
						test, test1);
			}
		}

		Step_End(11,
				"Next click the Show total summary option in open expense tab for the Draft,Submitted and Rejected records.If the activities are approved , then go to the  approved expense tab and click the show total summary option",
				test, test1);

		Step_Start(12, "Select the required split by option such as Currency,Vendor and Main activity", test, test1);

		waitForElement(driver, CAR_currencylist);
		List<WebElement> CurrencyList = listOfElements(driver, CAR_currencylist);

		int cur_count = 0;
		List<String> Currency_value = new ArrayList<>();
		List<String> Currency_Amount = new ArrayList<>();

		for (int m = 0; m < CurrencyList.size(); m++) {

			String currencygrid = String.format(CAR_Currencygrid, cur_count);
			String currencyAmount = String.format(CAR_CurrencyAmountgrid, cur_count);
			String Currency_Value = getText(driver, currencygrid);
			String CurrencyAmount = getAttribute(driver, currencyAmount, "value").replace(",", "");
			Currency_value.add(Currency_Value);

			Currency_Amount.add(CurrencyAmount);
			cur_count++;
		}

		waitForElement(driver, Ventor);
		click(driver, Ventor);

		waitForElement(driver, Totalexpense_Currencyheader);

		List<String> Ventor_Currency = new ArrayList<>();

		List<String> Ventor_Amount = new ArrayList<>();

		waitForElement(driver, CAR_currencylist);
		List<WebElement> CurrencyList2 = listOfElements(driver, CAR_currencylist);
		cur_count = 0;
		for (int m = 0; m < CurrencyList2.size(); m++) {
			String currencygrid = String.format(CAR_CurrecnyGrid, cur_count);
			String currencyAmount = String.format(CAR_CurrecnyGridamount, cur_count);
			String Currency_Value = getText(driver, currencygrid);
			String CurrencyAmount = getAttribute(driver, currencyAmount, "value").replace(",", "");
			Ventor_Currency.add(Currency_Value);
			Ventor_Amount.add(CurrencyAmount);
			cur_count++;
		}

		waitForElement(driver, MainActivity);
		click(driver, MainActivity);

		waitForElement(driver, Totalexpense_Currencyheader);

		List<String> Main_Activities = new ArrayList<>();

		List<String> Main_Currency = new ArrayList<>();

		List<String> Main_Amount = new ArrayList<>();

		waitForElement(driver, CAR_currencylist);
		List<WebElement> CurrencyList3 = listOfElements(driver, CAR_currencylist);
		cur_count = 0;
		for (int m = 0; m < CurrencyList3.size(); m++) {

			String currencygrid = String.format(CAR_CurrecnyGrid, cur_count);
			String currencyAmount = String.format(CAR_CurrecnyGridamount, cur_count);
			String currencyname = String.format(OE_SummaryCurrency, cur_count);

			String Currency_Value = getText(driver, currencygrid);
			String currencynames = getText(driver, currencyname);
			String CurrencyAmount = getAttribute(driver, currencyAmount, "value").replace(",", "");

			Main_Activities.add(Currency_Value);

			Main_Currency.add(currencynames);

			Main_Amount.add(CurrencyAmount);
			cur_count++;
		}

		waitForElement(driver, TotalSummary_Ok);
		click(driver, TotalSummary_Ok);

		Step_End(12, "Select the required split by option such as Currency,Vendor and Main activity", test, test1);

		Step_Start(13,
				"Ensure that the total cost in expense report(open expense or approved expense) shows based on the AG grid which is available in Open expense and Approved expense tab",
				test, test1);

		waitForElement(driver, TotalExpenses_Column);
		click(driver, TotalExpenses_Column);

		waitForDisplay(driver, TotalExpenses_Deselect);
		jsClick(driver, TotalExpenses_Deselect);

		waitForElement(driver, TotalExpenses_input);
		clear(driver, TotalExpenses_input);
		sendKeys(driver, TotalExpenses_input, FilterColumn1);
		jsClick(driver, TotalExpenses_Deselect);

		int h = 0;

		for (String currencies : Currency_value) {

			String currencyamount = Currency_Amount.get(h);

			waitForElement(driver, OE_ConditionFilter);
			click(driver, OE_ConditionFilter);

			waitForElement(driver, OE_Currency_Filter);
			Newclear(driver, OE_Currency_Filter);
			sendKeys(driver, OE_Currency_Filter, currencies);

			waitForElement(driver, CAR_concurrencylist);
			List<WebElement> openExpenses = listOfElements(driver, CAR_concurrencylist);

			int i = 1;
			double TotalAmount = 0;
			for (WebElement openexpense : openExpenses) {
				String expense_currency = openexpense.getText();
				if (Currency_value.contains(expense_currency)) {
					String totalexpensefield = String.format(CAR_Totalexpense, i);
					String total = getText(driver, totalexpensefield).replace(",", "");
					double totalamount = Double.parseDouble(total);
					TotalAmount = TotalAmount + totalamount;
				}
				i++;
			}

			DecimalFormat df = new DecimalFormat("0.00");
			String Expected_CurrencyAmount = df.format(TotalAmount);

			if (currencyamount.equals(Expected_CurrencyAmount)) {

				System.out.println("Expected : Total Cost in expense report " + currencyamount
						+ " Should be Shows based on the ag grid Currency : " + Expected_CurrencyAmount
						+ " || Actual : Total Cost in expense report " + currencyamount
						+ " is Shows based on the ag grid Currency , Act : " + Expected_CurrencyAmount);
				Extent_pass_New(driver,
						"Expected : Total Cost in expense report " + currencyamount
								+ " Should be Shows based on the ag grid Currency : " + Expected_CurrencyAmount
								+ " || Actual : Total Cost in expense report " + currencyamount
								+ " is Shows based on the ag grid Currency , Act : " + Expected_CurrencyAmount,
						test, test1);

			} else {

				System.out.println("Expected : Total Cost in expense report " + currencyamount
						+ " Should be Shows based on the ag grid Currency : " + Expected_CurrencyAmount
						+ " || Actual : Total Cost in expense report " + currencyamount
						+ " is not Shows based on the ag grid Currency , Act : " + Expected_CurrencyAmount);
				Extent_fail(driver,
						"Expected : Total Cost in expense report " + currencyamount
								+ " Should be Shows based on the ag grid Currency : " + Expected_CurrencyAmount
								+ " || Actual : Total Cost in expense report " + currencyamount
								+ " is not Shows based on the ag grid Currency , Act : " + Expected_CurrencyAmount,
						test, test1);

			}

			h++;

		}

		waitForElement(driver, OE_ResetFilter);
		click(driver, OE_ResetFilter);

		waitForElement(driver, TotalExpenses_input);
		Newclear(driver, TotalExpenses_input);

		waitForDisplay(driver, TotalExpenses_Deselect);
		jsClick(driver, TotalExpenses_Deselect);

		List<String> filtercolumns = splitAndExpand(FilterColumn2);

		for (String columnname : filtercolumns) {
			waitForElement(driver, TotalExpenses_input);
			Newclear(driver, TotalExpenses_input);
			sendKeys(driver, TotalExpenses_input, columnname);
			jsClick(driver, TotalExpenses_Deselect);
			wait(driver, "1");
		}

		int o = 0;

		for (String vendorcodes : Ventor_Currency) {

			String VendorTotal = Ventor_Amount.get(o);

			waitForElement(driver, vendorCode_Filter_CAR);
			Newclear(driver, vendorCode_Filter_CAR);
			sendKeys(driver, vendorCode_Filter_CAR, vendorcodes);

			List<WebElement> Vendor_openExpenses = listOfElements(driver, CAR_Vendorlist);
			int j = 1;
			double VendorTotalAmount = 0;
			for (WebElement openexpense : Vendor_openExpenses) {
				String expense_currency = openexpense.getText();
				if (Ventor_Currency.contains(expense_currency)) {
					String totalexpensefield = String.format(CAR_Totalexpense, j);
					String total = getText(driver, totalexpensefield).replace(",", "");
					double totalamount = Double.parseDouble(total);
					VendorTotalAmount = VendorTotalAmount + totalamount;
				}
				j++;
			}

			DecimalFormat df = new DecimalFormat("0.00");
			String formattedVendorTotal = df.format(VendorTotalAmount);
			if (VendorTotal.equals(formattedVendorTotal)) {
				System.out.println(
						"Expected : Total Cost in expense report Should Shows based on the ag grid vendor data || Actual : Total Cost in expense report is Shows based on the ag grid vendor data, Act : "
								+ formattedVendorTotal);
				Extent_pass_New(driver,
						"Expected : Total Cost in expense report Should Shows based on the ag grid vendor data || Actual : Total Cost in expense report is Shows based on the ag grid vendor data, Act : "
								+ formattedVendorTotal,
						test, test1);
			} else {
				System.out.println(
						"Expected : Total Cost in expense report Should Shows based on the ag grid vendor data || Actual : Total Cost in expense report is not Shows based on the ag grid vendor data, Act : "
								+ formattedVendorTotal);
				Extent_fail(driver,
						"Expected : Total Cost in expense report Should Shows based on the ag grid vendor data || Actual : Total Cost in expense report is not Shows based on the ag grid vendor data, Act : "
								+ formattedVendorTotal,
						test, test1);
			}

			clear(driver, vendorCode_Filter_CAR);

			o++;

		}

		waitForElement(driver, OE_ResetFilter);
		click(driver, OE_ResetFilter);

		waitForElement(driver, TotalExpenses_input);
		Newclear(driver, TotalExpenses_input);

		waitForDisplay(driver, TotalExpenses_Deselect);
		jsClick(driver, TotalExpenses_Deselect);

		List<String> filtercolumns3 = splitAndExpand(FilterColumn3);
		for (String columnname : filtercolumns3) {
			waitForElement(driver, TotalExpenses_input);
			Newclear(driver, TotalExpenses_input);
			sendKeys(driver, TotalExpenses_input, columnname);
			jsClick(driver, TotalExpenses_Deselect);
			wait(driver, "1");
		}

		int p = 0;

		for (String mainactiv : Main_Activities) {

			String ActivityAmount = Main_Amount.get(p);

			waitForElement(driver, OE_Currency_Filter);
			Newclear(driver, OE_Currency_Filter);
			sendKeys(driver, OE_Currency_Filter, Main_Currency.get(p));

			waitForElement(driver, Main_Activity_Input_OpenExp_CAR);
			Newclear(driver, Main_Activity_Input_OpenExp_CAR);
			sendKeys(driver, Main_Activity_Input_OpenExp_CAR, mainactiv);

			waitForElement(driver, CAR_Mainactivitylist);
			List<WebElement> Activity_openExpenses = listOfElements(driver, CAR_Mainactivitylist);

			int k = 1;
			double ActivityTotalAmount = 0;
			for (WebElement openexpense : Activity_openExpenses) {
				waitForElement(driver, openexpense);
				String totalexpensefield = String.format(CAR_Totalexpense, k);
				String total = getText(driver, totalexpensefield).replace(",", "");
				double totalamount = Double.parseDouble(total);
				ActivityTotalAmount = ActivityTotalAmount + totalamount;
				k++;
			}

			DecimalFormat df = new DecimalFormat("0.00");
			String Expected_ActivityAmount = df.format(ActivityTotalAmount);

			if (ActivityAmount.equals(Expected_ActivityAmount)) {
				System.out.println(
						"Expected : Total Cost in expense report Should Shows based on the ag grid Activity  data || Actual : Total Cost in expense report is Shows based on the ag grid Activity data, Act : "
								+ Expected_ActivityAmount);
				Extent_pass_New(driver,
						"Expected : Total Cost in expense report Should Shows based on the ag grid Activity data || Actual : Total Cost in expense report is Shows based on the ag grid Activity data, Act : "
								+ Expected_ActivityAmount,
						test, test1);
			} else {
				System.out.println(
						"Expected : Total Cost in expense report Should Shows based on the ag grid Activity data || Actual : Total Cost in expense report is not Shows based on the ag grid vendor data, Act : "
								+ Expected_ActivityAmount);
				Extent_fail(driver,
						"Expected : Total Cost in expense report Should Shows based on the ag grid Activity  data || Actual : Total Cost in expense report is not Shows based on the ag grid vendor data, Act : "
								+ Expected_ActivityAmount,
						test, test1);
			}

			p++;

		}

		waitForElement(driver, Expensive_More_Option_CAR);
		click(driver, Expensive_More_Option_CAR);

		waitForElement(driver, OE_DistinctFilter);
		click(driver, OE_DistinctFilter);

		waitForElement(driver, Approved_Expensive);
		click(driver, Approved_Expensive);

		waitForElement(driver, Show_Total_Summary_AppExpense_CAR);
		click(driver, Show_Total_Summary_AppExpense_CAR);

		if (isdisplayed(driver, popup_Message)) {
			String popAct = getText(driver, popup_Message);
			if (No_records_Message.equals(popAct)) {
				System.out.println(
						"Expected : Total Summary table should be display || Actual : Error popup displayed , popupText : "
								+ popAct);
				Extent_FailNew(driver,
						"Expected : Total Summary table should be display || Actual : Error popup displayed , popupText : "
								+ popAct,
						test, test1);
			} else {
				System.out.println(
						"Expected : Total Summary table should be display || Actual : Error popup displayed , popupText : "
								+ popAct);
				Extent_fail(driver,
						"Expected : Total Summary table should be display || Actual : Error popup displayed , popupText : "
								+ popAct,
						test, test1);
			}
		}

		List<WebElement> CurrencyListAE = listOfElements(driver, CAR_currencylist);

		int AEcur_count = 0;
		List<String> Currency_value1 = new ArrayList<>();
		List<String> Currency_Amount1 = new ArrayList<>();

		for (int m = 0; m < CurrencyListAE.size(); m++) {

			String currencygrid = String.format(CAR_Currencygrid, AEcur_count);
			String currencyAmount = String.format(CAR_CurrencyAmountgrid, AEcur_count);
			String Currency_Value = getText(driver, currencygrid);
			String CurrencyAmount = getAttribute(driver, currencyAmount, "value").replace(",", "");
			Currency_value1.add(Currency_Value);

			Currency_Amount1.add(CurrencyAmount);
			AEcur_count++;
		}

		waitForElement(driver, Ventor);
		click(driver, Ventor);

		waitForElement(driver, Totalexpense_Currencyheader);
		List<String> AE_Ventor_Currency = new ArrayList<>();
		List<String> AE_Ventor_Amount = new ArrayList<>();

		waitForElement(driver, CAR_currencylist);
		List<WebElement> CurrencyList_AE = listOfElements(driver, CAR_currencylist);
		cur_count = 0;
		for (int m = 0; m < CurrencyList_AE.size(); m++) {
			String currencygrid = String.format(CAR_CurrecnyGrid, cur_count);
			String currencyAmount = String.format(CAR_CurrecnyGridamount, cur_count);
			String Currency_Value = getText(driver, currencygrid);
			String CurrencyAmount = getAttribute(driver, currencyAmount, "value").replace(",", "");
			AE_Ventor_Currency.add(Currency_Value);
			AE_Ventor_Amount.add(CurrencyAmount);
			cur_count++;
		}

		waitForElement(driver, MainActivity);
		click(driver, MainActivity);

		waitForElement(driver, Totalexpense_Currencyheader);
		List<String> AE_Main_Currency = new ArrayList<>();
		List<String> AE_Main_Amount = new ArrayList<>();
		List<String> AE_Main_Act = new ArrayList<>();

		waitForElement(driver, CAR_currencylist);
		List<WebElement> CurrencyList5 = listOfElements(driver, CAR_currencylist);
		int cur_counts = 0;
		for (int m = 0; m < CurrencyList5.size(); m++) {
			String currencygrid = String.format(CAR_CurrecnyGrid, cur_counts);
			String currencyAmount = String.format(CAR_CurrecnyGridamount, cur_counts);
			String currencyMain = String.format(CAR_MainCurrecnyGrid, cur_counts);
			String Currency_names = getText(driver, currencyMain);
			String Currency_Value = getText(driver, currencygrid);
			String CurrencyAmount = getAttribute(driver, currencyAmount, "value").replace(",", "");
			AE_Main_Act.add(Currency_Value);
			AE_Main_Currency.add(Currency_names);
			AE_Main_Amount.add(CurrencyAmount);
			cur_counts++;
		}

		waitForElement(driver, TotalSummary_Ok);
		click(driver, TotalSummary_Ok);

		waitForElement(driver, Approved_Columns);
		click(driver, Approved_Columns);

		waitForElement(driver, Approved_FilterInput);
		jsClick(driver, Approved_Deselect);

		Newclear(driver, Approved_FilterInput);
		sendKeys(driver, Approved_FilterInput, FilterColumn1);
		jsClick(driver, Approved_Deselect);

		waitForElement(driver, Approved_Columns);
		click(driver, Approved_Columns);

		int w = 0;

		for (String currencies : Currency_value1) {

			String currencyamount = Currency_Amount1.get(w);

			waitForElement(driver, AE_ConditionFilter);
			click(driver, AE_ConditionFilter);

			waitForElement(driver, OE_Currency_Filter);
			Newclear(driver, OE_Currency_Filter);
			sendKeys(driver, OE_Currency_Filter, currencies);

			waitForElement(driver, Appexpense_concurrencylist_CAR);
			List<WebElement> openExpenses = listOfElements(driver, Appexpense_concurrencylist_CAR);

			int i = 1;
			double TotalAmount = 0;
			for (WebElement openexpense : openExpenses) {
				String expense_currency = openexpense.getText();
				if (Currency_value1.contains(expense_currency)) {
					String totalexpensefield = String.format(CAR_Total_Appexpense, i);
					String total = getText(driver, totalexpensefield).replace(",", "");
					double totalamount = Double.parseDouble(total);
					TotalAmount = TotalAmount + totalamount;
				}
				i++;
			}

			DecimalFormat df = new DecimalFormat("0.00");
			String Expected_CurrencyAmount = df.format(TotalAmount);

			if (currencyamount.equals(Expected_CurrencyAmount)) {

				System.out.println("Expected : Total Cost in expense report " + currencyamount
						+ " Should be Shows based on the ag grid Currency : " + Expected_CurrencyAmount
						+ " || Actual : Total Cost in expense report " + currencyamount
						+ " is Shows based on the ag grid Currency , Act : " + Expected_CurrencyAmount);
				Extent_pass_New(driver,
						"Expected : Total Cost in expense report " + currencyamount
								+ " Should be Shows based on the ag grid Currency : " + Expected_CurrencyAmount
								+ " || Actual : Total Cost in expense report " + currencyamount
								+ " is Shows based on the ag grid Currency , Act : " + Expected_CurrencyAmount,
						test, test1);

			} else {

				System.out.println("Expected : Total Cost in expense report " + currencyamount
						+ " Should be Shows based on the ag grid Currency : " + Expected_CurrencyAmount
						+ " || Actual : Total Cost in expense report " + currencyamount
						+ " is not Shows based on the ag grid Currency , Act : " + Expected_CurrencyAmount);
				Extent_fail(driver,
						"Expected : Total Cost in expense report " + currencyamount
								+ " Should be Shows based on the ag grid Currency : " + Expected_CurrencyAmount
								+ " || Actual : Total Cost in expense report " + currencyamount
								+ " is not Shows based on the ag grid Currency , Act : " + Expected_CurrencyAmount,
						test, test1);

			}

			Newclear(driver, OE_Currency_Filter);

			w++;

		}

		waitForElement(driver, AE_ResetFilter);
		click(driver, AE_ResetFilter);

		waitForElement(driver, Approved_Columns);
		click(driver, Approved_Columns);

		waitForElement(driver, Approved_FilterInput);
		Newclear(driver, Approved_FilterInput);
		jsClick(driver, Approved_Deselect);

		List<String> filterLists2 = splitAndExpand(FilterColumn2);

		for (String input : filterLists2) {
			Newclear(driver, Approved_FilterInput);
			sendKeys(driver, Approved_FilterInput, input);
			jsClick(driver, Approved_Deselect);
		}

		waitForElement(driver, Approved_Columns);
		click(driver, Approved_Columns);

		int x = 0;

		for (String vendorcodes : AE_Ventor_Currency) {

			String VendorTotal = AE_Ventor_Amount.get(x);

			waitForElement(driver, Vendor_Code_Input_CAR);
			Newclear(driver, Vendor_Code_Input_CAR);
			sendKeys(driver, Vendor_Code_Input_CAR, vendorcodes);

			List<WebElement> Vendor_openExpenses = listOfElements(driver, CAR_AEVendorcode);
			int j = 1;
			double VendorTotalAmount = 0;
			for (WebElement openexpense : Vendor_openExpenses) {
				String expense_currency = openexpense.getText();
				if (AE_Ventor_Currency.contains(expense_currency)) {
					String totalexpensefield = String.format(CAR_Total_Appexpense, j);
					String total = getText(driver, totalexpensefield).replace(",", "");
					double totalamount = Double.parseDouble(total);
					VendorTotalAmount = VendorTotalAmount + totalamount;
				}
				j++;
			}

			DecimalFormat df = new DecimalFormat("0.00");
			String formattedVendorTotal = df.format(VendorTotalAmount);
			if (VendorTotal.equals(formattedVendorTotal)) {
				System.out.println(
						"Expected : Total Cost in expense report Should Shows based on the ag grid vendor data || Actual : Total Cost in expense report is Shows based on the ag grid vendor data, Act : "
								+ formattedVendorTotal);
				Extent_pass_New(driver,
						"Expected : Total Cost in expense report Should Shows based on the ag grid vendor data || Actual : Total Cost in expense report is Shows based on the ag grid vendor data, Act : "
								+ formattedVendorTotal,
						test, test1);
			} else {
				System.out.println(
						"Expected : Total Cost in expense report Should Shows based on the ag grid vendor data || Actual : Total Cost in expense report is not Shows based on the ag grid vendor data, Act : "
								+ formattedVendorTotal);
				Extent_fail(driver,
						"Expected : Total Cost in expense report Should Shows based on the ag grid vendor data || Actual : Total Cost in expense report is not Shows based on the ag grid vendor data, Act : "
								+ formattedVendorTotal,
						test, test1);
			}

			Newclear(driver, vendorCode_Filter_CAR);

			x++;

		}

		waitForElement(driver, AE_ResetFilter);
		click(driver, AE_ResetFilter);

		waitForElement(driver, Approved_Columns);
		click(driver, Approved_Columns);

		waitForElement(driver, Approved_FilterInput);
		Newclear(driver, Approved_FilterInput);
		jsClick(driver, Approved_Deselect);

		List<String> filterLists3 = splitAndExpand(FilterColumn3);

		for (String input : filterLists3) {
			Newclear(driver, Approved_FilterInput);
			sendKeys(driver, Approved_FilterInput, input);
			jsClick(driver, Approved_Deselect);
		}

		waitForElement(driver, Approved_Columns);
		click(driver, Approved_Columns);

		waitForElement(driver, Appexpense_Mainactivitylist_CAR);

		int y = 0;

		for (String mainactiv : AE_Main_Act) {

			String ActivityAmount = AE_Main_Amount.get(y);

			waitForElement(driver, OE_Currency_Filter);
			Newclear(driver, OE_Currency_Filter);
			sendKeys(driver, OE_Currency_Filter, AE_Main_Currency.get(y));

			waitForElement(driver, Main_Activity_Input_OpenExp_CAR);
			Newclear(driver, Main_Activity_Input_OpenExp_CAR);
			sendKeys(driver, Main_Activity_Input_OpenExp_CAR, mainactiv);

			waitForElement(driver, Appexpense_Mainactivitylist_CAR);
			List<WebElement> Activity_openExpenses = listOfElements(driver, Appexpense_Mainactivitylist_CAR);

			int k = 1;
			double ActivityTotalAmount = 0;
			for (WebElement openexpense : Activity_openExpenses) {
				waitForElement(driver, openexpense);
				String totalexpensefield = String.format(CAR_Total_Appexpense, k);
				String total = getText(driver, totalexpensefield).replace(",", "");
				double totalamount = Double.parseDouble(total);
				ActivityTotalAmount = ActivityTotalAmount + totalamount;
				k++;
			}

			DecimalFormat df = new DecimalFormat("0.00");
			String Expected_ActivityAmount = df.format(ActivityTotalAmount);

			if (ActivityAmount.equals(Expected_ActivityAmount)) {
				System.out.println(
						"Expected : Total Cost in expense report Should Shows based on the ag grid Activity  data || Actual : Total Cost in expense report is Shows based on the ag grid Activity data, Act : "
								+ Expected_ActivityAmount);
				Extent_pass_New(driver,
						"Expected : Total Cost in expense report Should Shows based on the ag grid Activity data || Actual : Total Cost in expense report is Shows based on the ag grid Activity data, Act : "
								+ Expected_ActivityAmount,
						test, test1);
			} else {
				System.out.println(
						"Expected : Total Cost in expense report Should Shows based on the ag grid Activity data || Actual : Total Cost in expense report is not Shows based on the ag grid vendor data, Act : "
								+ Expected_ActivityAmount);
				Extent_fail(driver,
						"Expected : Total Cost in expense report Should Shows based on the ag grid Activity  data || Actual : Total Cost in expense report is not Shows based on the ag grid vendor data, Act : "
								+ Expected_ActivityAmount,
						test, test1);
			}

			y++;

		}

		Step_End(13,
				"Ensure that the total cost in expense report(open expense or approved expense) shows based on the AG grid which is available in Open expense and Approved expense tab",
				test, test1);

		Extent_completed(tc_Name, test, test1);

	}
}
