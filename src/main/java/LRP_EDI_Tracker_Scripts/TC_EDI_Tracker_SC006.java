package LRP_EDI_Tracker_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Tracker_SC006 extends Keywords {
	public void EDI_Tracker_SC006(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Tracker_SC006";
	
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String edi_tracker_module = Excel_data.get("edi_tracker_module");
		String Direction_Option = Excel_data.get("Direction_Option");
		String from_date = Excel_data.get("from_date");
		String to_date = Excel_data.get("to_date");
		String EDI_Refrence_value = Excel_data.get("EDI_Refrence_value");

		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		moduleNavigate(driver, edi_tracker_module);

		Step_Start(1, "Select the Direction as (OutBound)", test, test1);
		waitForElement(driver, EDI_Direction_Dropdown);
		click(driver, EDI_Direction_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Direction_Option);
		Step_End(1, "Select the Direction as (OutBound)", test, test1);

		Step_Start(2, "Select the from date and to date", test, test1);
		selectDatePicker(driver, EDI_from_date_selecter, from_date);

		selectDatePicker(driver, EDI_to_date_selecter, to_date);
		Step_End(2, "Select the from date and to date", test, test1);

		Step_Start(3, "Enter the RefID in the field", test, test1);
		sendKeys(driver, EDI_Refrence_id, EDI_Refrence_value);
		Step_End(3, "Enter the RefID in the field", test, test1);

		Step_Start(4, "click the show button and verify we given Status only shown in the AG Grid", test, test1);
		click(driver, EDI_show_button);

		waitForElement(driver, EDI_Total_Records);
		String totalCount = getText(driver, EDI_Total_Records);
		int actualCount = Integer.parseInt(totalCount);

		List<Map<String, String>> tableData = extractTableDataByRowIndexMissMatchColumn(driver, EDI_Table, actualCount);
		String StatuValues = getFirstRowValueByHeaderFromTableData(tableData, "Reference Id");
		System.out.println("the value of Reference ID is :  " + StatuValues);

		if (EDI_Refrence_value.equals(StatuValues)) {
			System.out.println("Matched || Expected The Status value is : " + EDI_Refrence_value
					+ " || Actual The Status value is : " + StatuValues);
			Extent_pass_New(driver, " Matched || Expected The Status value is : " + EDI_Refrence_value
					+ " || Actual The Status value is :  " + StatuValues, test, test1);

		} else {
			System.out.println(" Not Matched || Expected The Status value is : " + EDI_Refrence_value
					+ " || Actual The Status value is : " + StatuValues);
			Extent_fail(driver, " Not Matched || Expected The Status value is : " + EDI_Refrence_value
					+ " || Actual The Status value is : " + StatuValues, test, test1);

		}
		
		Step_End(4, "click the show button and verify we given Status only shown in the AG Grid", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}