package LRP_Feeder_Contract_Scripts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC62 extends Keywords {

	public void Feeder_Contract_SC62(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC62";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Search_By = Excel_data.get("Search_By");
		String FDR_Contract_Number = Excel_data.get("FDR_Contract_Number");
		String FC_AG_Grid_Column_Header = Excel_data.get("FC_AG_Grid_Column_Header");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the global search option which is available in the tool bar.", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(2, "Click on the global search option which is available in the tool bar.", test, test1);
		Step_Start(3, "Check whether the system opens the contract details search window", test, test1);
		Step_Start(4, "Enter the saved Popup in the contract number search field.  ", test, test1);
		Step_Start(5, "Click on the search button", test, test1);
		Step_Start(6, "System will show cotract details based on the Contarct number ", test, test1);
		Step_Start(7, "Double click the Contract detials.  ", test, test1);

		globalValueSearchWindow(driver, Global_Search_Condition, Search_By, FDR_Contract_Number, "", "", "", "");
		Step_End(3, "Check whether the system opens the contract details search window", test, test1);
		Step_End(4, "Enter the saved Popup in the contract number search field.  ", test, test1);
		Step_End(5, "Click on the search button", test, test1);
		Step_End(6, "System will show cotract details based on the Contarct number ", test, test1);
		Step_End(7, "Double click the Contract detials.  ", test, test1);

		Step_Start(8, "Check whether the system retrieves the saved contract number.", test, test1);

		waitForElement(driver, FC_FDR_Contract_No_Textfield);
		String actual_FDR_ContractNumber = getAttribute(driver, FC_FDR_Contract_No_Textfield, "value");

		if (actual_FDR_ContractNumber.equals(FDR_Contract_Number)) {

			System.out.println("Matched || Expected Popup : " + FDR_Contract_Number + " || Actual Popup : "
					+ actual_FDR_ContractNumber);
			Extent_pass_New(driver, "Matched || Expected Popup : " + FDR_Contract_Number + " || Actual Popup : "
					+ actual_FDR_ContractNumber, test, test1);

		} else {

			System.out.println("Not Matched || Expected Popup : " + FDR_Contract_Number + " || Actual Popup : "
					+ actual_FDR_ContractNumber);
			Extent_fail(driver, "Not Matched || Expected Popup : " + FDR_Contract_Number + " || Actual Popup : "
					+ actual_FDR_ContractNumber, test, test1);

		}

		Step_End(8, "Check whether the system retrieves the saved contract number.", test, test1);
		Step_Start(9, "Click show validity only  ,It show the Validity  exsiting detials ", test, test1);

		waitForElement(driver, FC_Show_Valid_Only_Checkbox);
		click(driver, FC_Show_Valid_Only_Checkbox);

		List<String> columnNames = splitAndExpand(FC_AG_Grid_Column_Header);
		reArrangeAG_GridColumns(driver, FC_AG_Grid_Column_Header);

		waitForElement(driver, FC_AG_Grid);
		List<Map<String, String>> table_data = extractTableDataByColumn(driver, FC_AG_Grid);
		String valid_From_Act = getFirstRowValueByHeaderFromTableData(table_data, columnNames.get(0));

		String valid_To_Act = getFirstRowValueByHeaderFromTableData(table_data, columnNames.get(1));

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate validFrom = LocalDate.parse(valid_From_Act, dateTimeFormatter);
		LocalDate validTo = LocalDate.parse(valid_To_Act, dateTimeFormatter);

		LocalDate today = LocalDate.now();

		if ((today.isEqual(validFrom) || today.isAfter(validFrom))
				&& (today.isEqual(validTo) || today.isBefore(validTo))) {
			System.out.println("Current date is within the valid range.   ||From date : " + validFrom
					+ "  || To date  : " + validTo + " || Current Date :" + today);
			Extent_pass_New(driver, "Current date is within the valid range.  ||From date : " + validFrom
					+ "  || To date  : " + validTo + " || Current Date :" + today, test, test1);
		} else {
			System.out.println("Current date is NOT within the valid range.     ||From date : " + validFrom
					+ "  || To date  : " + validTo + " || Current Date :" + today);
			Extent_fail(driver, "Current date is NOT within the valid range.     ||From date : " + validFrom
					+ "  || To date  : " + validTo + " || Current Date :" + today, test, test1);
		}

		Step_End(9, "Click show validity only  ,It show the Validity  exsiting detials ", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
