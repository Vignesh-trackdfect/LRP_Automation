package LRP_Cost_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS025 extends Keywords {

	public void Cost_Activity_Report_TS025(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS025";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String Service_Tax_Module = Excel_data.get("Service_Tax_Module");
		String Condition2 = Excel_data.get("Condition2");
		String TypeOFTax_Option = Excel_data.get("TypeOFTax_Option");
		String ChargeType_Option = Excel_data.get("ChargeType_Option");
		String PercentageValue = Excel_data.get("PercentageValue");
		String Activity = Excel_data.get("Activity");
		String filtercolumns = Excel_data.get("filtercolumns");
		String ExpectedpopupMessage = Excel_data.get("ExpectedpopupMessage");
		String DeleteCondition = Excel_data.get("DeleteCondition");
		String Contract_Type_Code_Headers = Excel_data.get("Contract_Type_Code_Headers");
		String Port_Filter_Header = Excel_data.get("Port_Filter_Header");
		String Terminal_Filter_Header = Excel_data.get("Terminal_Filter_Header");
		String Agency = Excel_data.get("Agency");
		String contractType = Excel_data.get("contractType");
		String Validfrom = Excel_data.get("Validfrom");
		String validto = Excel_data.get("validto");
		String ST_Portcode = Excel_data.get("ST_Portcode");
		String TerminalName = Excel_data.get("TerminalName");

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

		Step_Start(2, "Enter the screen name as \"Service tax\" in the module search field", test, test1);

		verifyMainMenu(driver);

		moduleNavigate(driver, Service_Tax_Module);

		Step_End(2, "Enter the screen name as \"Service tax\" in the module search field", test, test1);

		Step_Start(3,
				"Select the required type(Service tax/GST),contract type, valid from, valid to, type, port ,terminal, contract number or vendor.",
				test, test1);

		waitForElement(driver, Type_Search_CAR);
		click(driver, Type_Search_CAR);

		twoColumnSearchWindow(driver, Contract_Type_Code_Headers, Condition2, contractType);

		if (!Validfrom.equals("")) {

			waitForElement(driver, TaxDate_CAR);
			selectDatePicker(driver, TaxDate_CAR, Validfrom);

		}

		if (!validto.equals("")) {

			waitForElement(driver, Tax_ValidTo_CAR);
			selectDatePicker(driver, Tax_ValidTo_CAR, validto);

		}

		waitForElement(driver, Tax_Port_Search_CAR);
		click(driver, Tax_Port_Search_CAR);

		twoColumnSearchWindow(driver, Port_Filter_Header, Condition2, ST_Portcode);

		if (isdisplayed(driver, Tax_Terminal_Search_CAR) && isElementEnabled(driver, Tax_Terminal_Search_CAR)) {

			waitForElement(driver, Tax_Terminal_Search_CAR);
			click(driver, Tax_Terminal_Search_CAR);
			twoColumnSearchWindow(driver, Terminal_Filter_Header, Condition2, TerminalName);

		}

		Step_End(3,
				"Select the required type(Service tax/GST),contract type, valid from, valid to, type, port ,terminal, contract number or vendor.",
				test, test1);

		Step_Start(4,
				"Then click the show option.Records will be shown in the Ag grid.Select a record and right click it and select the create service tax option",
				test, test1);

		waitForElement(driver, Tax_Show_CAR);
		click(driver, Tax_Show_CAR);

		waitForElement(driver, ServiceTax_Count);
		String totalcount = getText(driver, ServiceTax_Count);

		boolean flag = true;

		for (int i = 0; i < Integer.parseInt(totalcount); i++) {

			String gridcolumn = String.format(ServiceTax_Grid, i);

			waitForElement(driver, gridcolumn);
			click(driver, gridcolumn);
			RightClick(driver, gridcolumn);

			waitForElement(driver, CreateTax_CAR);
			click(driver, CreateTax_CAR);

			Step_End(4,
					"Then click the show option.Records will be shown in the Ag grid.Select a record and right click it and select the create service tax option",
					test, test1);

			if (isdisplayed(driver, popup_Message)) {

				String popupmessage = getText(driver, popup_Message);

				String activityCode = getText(driver, gridcolumn);

				System.out.println("Unable to create Service tax for the selected activity" + activityCode
						+ " and the popup message is " + popupmessage);
				Extent_call(test, test1, "Unable to create Service tax for the selected activity" + activityCode
						+ " and the popup message is " + popupmessage);

				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);

				continue;
			} else {

				Step_Start(5,
						"Then select the type of tax,charge type and give the values in percentage column and select the activity/port code",
						test, test1);

				waitForElement(driver, Tax_Show_CAR);
				jsClick(driver, TypeOfTax_CAR);

				String TypeofTax_Option = String.format(DropDown_Select, TypeOFTax_Option);
				waitForElement(driver, TypeofTax_Option);
				click(driver, TypeofTax_Option);

				waitForElement(driver, Tax_Show_CAR);
				jsClick(driver, ChargeType_CAR);

				String ChargeTypes_Option = String.format(DropDown_Select, ChargeType_Option);
				waitForElement(driver, ChargeTypes_Option);
				click(driver, ChargeTypes_Option);

				if (ChargeType_Option.equals("Percentage")) {

					waitForElement(driver, Tax_Show_CAR);
					jsClick(driver, PercentageInputField);

					sendKeysUsingActions(driver, PercentageInputField, PercentageValue);

				}

				waitForElement(driver, Tax_Show_CAR);
				jsClick(driver, Activity_Dropdown_click);

				waitForElement(driver, Tax_Show_CAR);

				wait(driver, "2");
				jsClick(driver, Activity_Dropdown);

				String ActivityOption = String.format(DropDown_Select, Activity);
				waitForElement(driver, ActivityOption);
				click(driver, ActivityOption);

				waitForElement(driver, Tax_Show_CAR);
				jsClick(driver, TypeOfTax_CAR);

				Step_End(5,
						"Then select the type of tax,charge type and give the values in percentage column and select the activity/port code",
						test, test1);

				Step_Start(6, "Then click the apply option", test, test1);

				waitForElement(driver, ApplyTax_CAR);
				click(driver, ApplyTax_CAR);

				Step_End(6, "Then click the apply option", test, test1);

				waitForElement(driver, gridcolumn);
				RightClick(driver, gridcolumn);

				waitForElement(driver, CopyTaxDetail);
				click(driver, CopyTaxDetail);

				flag = true;

			}

			if (flag == true) {

				for (int j = i + 1; j < Integer.parseInt(totalcount); j++) {

					String gridcolumn2 = String.format(ServiceTax_Grid, j);

					mouseOverToElement(driver, gridcolumn2);

					waitForElement(driver, gridcolumn2);
					click(driver, gridcolumn2);
					RightClick(driver, gridcolumn2);

					waitForElement(driver, PasteTaxDetail);
					click(driver, PasteTaxDetail);

					if (isdisplayed(driver, popup_Message)) {

						waitForElement(driver, popup_Message_Ok_Button);
						click(driver, popup_Message_Ok_Button);

					}
				}

				break;

			}

		}

		Step_Start(7,
				"Click on the save option in the toolbar and system validates as Service tax saved Click ok option.Ensure that service tax number is generated",
				test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, ExpectedpopupMessage);
		String savedpopupMessage = getText(driver, popup_Message);

		if (savedpopupMessage.equals(ExpectedpopupMessage)) {

			System.out.println(
					"Expected : Service tax Should be created successfully || Actual : Service tax was created successfully");
			Extent_pass_New(driver,
					"Expected : Service tax Should be created successfully || Actual : Service tax was created successfully",
					test, test1);
		} else {
			System.out.println(
					"Expected : Service tax Should be created successfully || Actual : Service tax was not created successfully");
			Extent_fail(driver,
					"Expected : Service tax Should be created successfully || Actual : Service tax was not created successfully",
					test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, STXNo_CAR);
		String Tx_no = getAttribute(driver, STXNo_CAR, "value");

		System.out.println("Tx_no : " + Tx_no);

		Step_End(7,
				"Click on the save option in the toolbar and system validates as Service tax saved Click ok option.Ensure that service tax number is generated",
				test, test1);

		Step_Start(8, "Enter the screen name as \"Cost Activity Report\" in module search field", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(8, "Enter the screen name as \"Cost Activity Report\" in module search field", test, test1);

		Step_Start(9, "Click on the global search option which is available in the tool bar.", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(9, "Click on the global search option which is available in the tool bar.", test, test1);

		Step_Start(10, "Check whether it opens a new search window", test, test1);

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

		Step_End(10, "Check whether it opens a new search window", test, test1);

		Step_Start(11, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_Start(12, "Then click on the search button", test, test1);

		Step_Start(13, "System will show the CAR No", test, test1);

		Step_Start(14, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		globalValueSearchWindow(driver, Condition, Select_search_value, CAR_No, "", "", "", "");

		Step_End(11, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_End(12, "Then click on the search button", test, test1);

		Step_End(13, "System will show the CAR No", test, test1);

		Step_End(14, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		Step_Start(15, "System will retrieve the CAR", test, test1);

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

		Step_End(15, "System will retrieve the CAR", test, test1);

		Step_Start(16, "Click on the Expense report button and check system opens a new tab.", test, test1);

		waitForElement(driver, Expense_report);
		click(driver, Expense_report);

		Step_End(16, "Click on the Expense report button and check system opens a new tab.", test, test1);

		Step_Start(17,
				"Check whether the generated service tax number is shown in Service tax/GST No. column along with the tax details with proper tax amount which is defined in the service tax based on the percentange",
				test, test1);

		waitForElement(driver, TotalExpenses_Column);
		click(driver, TotalExpenses_Column);

		waitForElement(driver, TotalExpenses_input);
		jsClick(driver, TotalExpenses_Deselect);

		List<String> filter_columns = splitAndExpand(filtercolumns);

		for (String columnname : filter_columns) {

			waitForElement(driver, TotalExpenses_input);
			Newclear(driver, TotalExpenses_input);
			sendKeys(driver, TotalExpenses_input, columnname);

			waitForElement(driver, TotalExpenses_input);
			jsClick(driver, TotalExpenses_Deselect);
		}

		waitForElement(driver, TotalExpenses_Column);
		click(driver, TotalExpenses_Column);

		List<WebElement> TotalCosts = listOfElements1(driver, CAR_TotalcostList);
		List<WebElement> Service_Tax = listOfElements1(driver, CAR_servicetax_no);

		List<String> total_Cost = new ArrayList<String>();

		for (WebElement cost : TotalCosts) {

			String getcost = cost.getText();

			total_Cost.add(getcost);
		}

		for (WebElement Tax : Service_Tax) {

			String TaxNo = Tax.getText();

			if (TaxNo.equals(Tx_no)) {
				System.out.println("Created tax no was updated in the expense report || Expected : " + Tx_no
						+ " || Actual : " + TaxNo);
				Extent_pass_New(driver, ("Created tax no was updated in the expense report || Expected : " + Tx_no
						+ " || Actual : " + TaxNo), test, test1);

			} else {
				System.out.println("Created tax no was not updated in the expense report || Expected : " + Tx_no
						+ " || Actual : " + TaxNo);
				Extent_fail(driver, ("Created tax no was not updated in the expense report || Expected : " + Tx_no
						+ " || Actual : " + TaxNo), test, test1);

			}

		}

		for (int i = 0; i < TotalCosts.size(); i++) {

			String taxamount = String.format(CAR_Expense_Taxvalue, i, TypeOFTax_Option);

			String expenseTax = getText(driver, taxamount);

			String convertedtax = String.format("%.2f", Double.valueOf(expenseTax));

			String totalcost = total_Cost.get(i);

			// Convert the string to a double
			double convertedCost = getNumberValue(totalcost);

			// Convert percentage string to a double
			double convertedPercentage = getNumberValue(PercentageValue);

			// Calculate the result by applying the percentage to the cost
			double result = (convertedCost * convertedPercentage) / 100;

			// Convert the result to an integer (removing decimals)

			String expectedTax = String.format("%.2f", result);

			// Output the result
			System.out.println("Expected Tax: " + expectedTax);

			if (convertedtax.equals(expectedTax)) {

				System.out.println("Taxes are calculated as per the service tax || Expected : " + expectedTax
						+ " || Actual : " + convertedtax);
				Extent_pass_New(driver, "Taxes are calculated as per the service tax || Expected : " + expectedTax
						+ " || Actual : " + convertedtax, test, test1);
			} else {
				System.out.println("Taxes are not calculated as per the service tax || Expected : " + expectedTax
						+ " || Actual : " + convertedtax);
				Extent_fail(driver, "Taxes are not calculated as per the service tax || Expected : " + expectedTax
						+ " || Actual : " + convertedtax, test, test1);
			}

		}

		Step_End(17,
				"Check whether the generated service tax number is shown in Service tax/GST No. column along with the tax details with proper tax amount which is defined in the service tax based on the percentange",
				test, test1);

		if (DeleteCondition.equals("Yes")) {

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);
			waitForPopup(driver, popup_Message, "Deleted message");
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}

		Extent_completed(tc_Name, test, test1);

	}

}
