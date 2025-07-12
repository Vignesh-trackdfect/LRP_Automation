package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS030 extends Keywords {

	@SuppressWarnings("deprecation")
	public void Cost_Activity_Report_TS030(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String tc_Name = "TC_Cost_Activity_Report_TS030";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String AgencyUser =Excel_data.get("AgencyUser");

		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Coloum_headers = Excel_data.get("Open_Expenses_Column_Header");
		String BackroundColor = Excel_data.get("BackRoundColor");
		String CAR_Retrieve_Type1 = Excel_data.get("CAR_Retrieve_Type1");
		String CAR_Retrieve_Condition1 = Excel_data.get("CAR_Retrieve_Condition1");
		String CAR_Number_Retrieve_Value1 = Excel_data.get("CAR_Number_Retrieve_Value1");
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		Extent_Start(tc_Name, test, test1);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select the required agency.",
				test, test1);

		navigateUrl(driver, url);

		Step_End(1, "Once login to the application and click on switch profile option and select the required agency",
				test, test1);

		Step_Start(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		LRP_Login(driver, username, password);

		Step_End(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);
		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		waitForElement(driver, seach_Filed);
		click(driver, seach_Filed);

		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);


		Step_Start(4, "Check whether it opens a new search window. ", test, test1);

		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button", test, test1);
		
		globalValueSearchWindow(driver,CAR_Retrieve_Condition1,CAR_Retrieve_Type1,CAR_Number_Retrieve_Value1,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(4, "Check whether it opens a new search window. ", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		Step_End(7, "System will show the CAR No. and Click on the select button", test, test1);

		Step_Start(8, "System will retrieve the CAR", test, test1);

		waitForElement(driver, car_Number_val);
		String Carvalue = getAttribute(driver, car_Number_val, "value");

		System.out.println("Carvalue :" + Carvalue);

		Step_End(8, "System will retrieve the CAR", test, test1);

		Step_Start(9, "Click on the Expense report button and check system opens a new tab", test, test1);

		waitForElement(driver, ExpenseReport);
		click(driver, ExpenseReport);

		waitForDisplay(driver, expensereportpage);
		if (isdisplayed(driver, expensereportpage)) {

			System.out.println("Expected : Click on the Expense Report, and it Should navigate to the Expense Report screen successfully || Actual : After Click on the Expense Report, it navigate to the Expense Report screen successfully");
			Extent_pass_New(driver,
					"Expected : Click on the Expense Report, and it Should navigate to the Expense Report screen successfully || Actual : After Click on the Expense Report, it navigate to the Expense Report screen successfully", test,
					test1);
		} else {

			System.out.println("Expected : Click on the Expense Report, and it Should navigate to the Expense Report screen successfully || Actual : After Click on the Expense Report, it not navigate to the Expense Report screen successfully");
			Extent_fail(driver,
					"Expected : Click on the Expense Report, and it Should navigate to the Expense Report screen successfully || Actual : After Click on the Expense Report, it not navigate to the Expense Report screen successfully",
					test, test1);
		}

		Step_End(9, "Click on the Expense report button and check system opens a new tab", test, test1);

		Step_Start(10,"Ensure that if ops quantity matches with chargeable quantity then the activities will be shown in blue colour and it is applicable for predictable activity alone in both Open expenses and Approved expenses tab",
				test, test1);

		waitForElement(driver, Open_Expenses);
		click(driver, Open_Expenses);

		waitForElement(driver, Open_Expenses_Column);
		if(isdisplayed(driver, Open_Expense_Table_Rows)) {
			waitForElement(driver, Open_Expenses_Column);
			click(driver, Open_Expenses_Column);

			waitForDisplay(driver, Open_Expe_SelectAll_Checkbox);
			click(driver, Open_Expe_SelectAll_Checkbox);
			if(isdisplayed(driver, Open_Expense_Table_Rows)) {
				waitForDisplay(driver, Open_Expe_SelectAll_Checkbox);
				click(driver, Open_Expe_SelectAll_Checkbox);
			}

			List<String> column_Headers = splitAndExpand(Coloum_headers);
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

			List<WebElement> rows = listOfElements(driver, Open_Expense_Table_Rows);
			List<WebElement> invoiceColumns=listOfElements(driver, Invoice_Column_OpenExpense);
			
			for (int i = 1; i <= rows.size(); i++) {

				String num = String.valueOf(i);
				String ChargeValueElement = String.format(ChargeQuantity1, num);
				String ChargeValue = getText(driver, ChargeValueElement);
				double ChargeAmount=Double.parseDouble(ChargeValue);
				
				String OpsValueElement = String.format(Quantity_OpenExpense_CAR, num);
				String OpsValue = getText(driver, OpsValueElement);

				String invoiceValue=invoiceColumns.get(i-1).getText();				
				if(ChargeAmount>=1&&invoiceValue.trim().equals("")) {
					if (ChargeValue.equals(OpsValue)) {
						String PredictableElement = String.format(PredictCheckbox, num);
						if (IsElementSelected(driver, PredictableElement)) {

							String rowClassValue = rows.get(i - 1).getAttribute("class");
							if (rowClassValue.contains(BackroundColor)) {
								System.out.println("Expected :  Quantity and Chargeable Quantity values are equal the color Should be skyblue || Actual :  Quantity and Chargeable Quantity values are equal the color is skyblue");

								Extent_pass_New(driver,"Expected :  Quantity and Chargeable Quantity values are equal the color Should be skyblue || Actual :  Quantity and Chargeable Quantity values are equal the color is skyblue",
										test, test1);
							} else {
								System.out.println("Expected :  Quantity and Chargeable Quantity values are equal the color Should be skyblue || Actual :  Quantity and Chargeable Quantity values are not equal the color is skyblue");

								Extent_fail(driver,"Expected :  Quantity and Chargeable Quantity values are equal the color Should be skyblue || Actual :  Quantity and Chargeable Quantity values are not equal the color is skyblue",
										test, test1);
							}
						}
					}
				}
			}
		}else {
			System.out.println("Expected : values Should present in the open expense tab || Actual : No values Present in the Open Expense Tab, Change the testdata");
		}
		

		waitForElement(driver, ApprovedExpenses);
		click(driver, ApprovedExpenses);

		waitForElement(driver, Column);
		if(isdisplayed(driver, App_Expense_Table_Rows)) {
			waitForElement(driver, Column);
			click(driver, Column);

			waitForDisplay(driver, Approved_Deselect);
			jsClick(driver, Approved_Deselect);
			if(isdisplayed(driver, App_Expense_Table_Rows)) {
				waitForDisplay(driver, Approved_Deselect);
				jsClick(driver, Approved_Deselect);
			}
			
			List<String> column_Headers_val = splitAndExpand(Coloum_headers);
			for (int i = 0; i < column_Headers_val.size(); i++) {
				String column = column_Headers_val.get(i);
				waitForElement(driver, App_Expensive_Filter_input_CAR);
				click(driver, App_Expensive_Filter_input_CAR);
				clear(driver, App_Expensive_Filter_input_CAR);
				sendKeys(driver, App_Expensive_Filter_input_CAR, column);
				waitForDisplay(driver, Approved_Deselect);
				jsClick(driver, Approved_Deselect);				
			}
			
			waitForElement(driver, Column);
			click(driver, Column);
			
			List<WebElement> rows = listOfElements(driver, App_Expense_Table_Rows);
			List<WebElement> invoiceColumns=listOfElements(driver, Invoice_Column_AppExpense);
			for (int i = 1; i <= rows.size(); i++) {

				String num = String.valueOf(i);
				String ChargeValueElement = String.format(Charge_Quantity_AppExpense, num);
				String ChargeValue = getText(driver, ChargeValueElement);
				double ChargeAmount=Double.parseDouble(ChargeValue);
				
				String OpsValueElement = String.format(Quantity_ApprovedExpense, num);
				String OpsValue = getText(driver, OpsValueElement);

				String invoiceValue=invoiceColumns.get(i-1).getText();
				
				if(ChargeAmount>=1&&invoiceValue.trim().equals("")) {
					if (ChargeValue.equals(OpsValue)) {
						String PredictableElement = String.format(PredictCheckbox_AppExpense, num);
						if (IsElementSelected(driver, PredictableElement)) {

							String rowClassValue = rows.get(i - 1).getAttribute("class");
							if (rowClassValue.contains(BackroundColor)) {
								System.out.println("Expected : Quantity and Chargeable Quantity values are equal the color Should be skyblue || Actual :  Quantity and Chargeable Quantity values are equal the color is skyblue");

								Extent_pass_New(driver,"Expected :  Quantity and Chargeable Quantity values are equal the color Should be skyblue || Actual :  Quantity and Chargeable Quantity values are equal the color is skyblue",
										test, test1);
							} else {
								System.out.println("Expected :  Quantity and Chargeable Quantity values are equal the color Should be skyblue || Actual :  Quantity and Chargeable Quantity values are not equal the color is skyblue");

								Extent_fail(driver,"Expected :  Quantity and Chargeable Quantity values are equal the color Should be skyblue || Actual :  Quantity and Chargeable Quantity values are not equal the color is skyblue",
										test, test1);
							}
						}
					}
				}
			}			
		}else {
			System.out.println("Expected : values Should present in the Approved expense tab || Actual : No values Present in the Approved Expense Tab, Change the testdata");
		}
		
		Step_End(10,"Ensure that if ops quantity matches with chargeable quantity then the activities will be shown in blue colour and it is applicable for predictable activity alone in both Open expenses and Approved expenses tab",
				test, test1);

		Extent_completed(tc_Name, test, test1);

	}
}
