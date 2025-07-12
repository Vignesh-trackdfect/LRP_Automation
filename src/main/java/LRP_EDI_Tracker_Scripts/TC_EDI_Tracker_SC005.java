package LRP_EDI_Tracker_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Tracker_SC005 extends Keywords {
	public void EDI_Tracker_SC005(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Tracker_SC005";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String edi_tracker_module = Excel_data.get("edi_tracker_module");
		String Direction_Option = Excel_data.get("Direction_Option");
		String from_date = Excel_data.get("from_date");
		String to_date = Excel_data.get("to_date");
		String EDI_Status_value = Excel_data.get("EDI_Status_value");

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

		Step_Start(3, "select the Status Dropdown ", test, test1);
		waitForElement(driver, EDI_Status_Dropdown);
		click(driver, EDI_Status_Dropdown);
		formatLocatorClick(driver, DropDown_Select, EDI_Status_value);
		Step_End(3, "select the Status Dropdown ", test, test1);

		Step_Start(4, "click the show button and verify we given Status only shown in the AG Grid", test, test1);
		click(driver, EDI_show_button);

		waitForElement(driver, EDI_Total_Records);
		String totalCount = getText(driver, EDI_Total_Records);

		waitForElement(driver, Status_List_ET);

		List<WebElement> statuses_Ele = listOfElements(driver, Status_List_ET);

		List<String> Grid_Statuses = new ArrayList<String>();

		for (WebElement ele : statuses_Ele) {

			String grid_status = ele.getText();

			Grid_Statuses.add(grid_status);

		}

		boolean flag = true;

		List<String> changed_statuses = new ArrayList<String>();

		for (String statuses : Grid_Statuses) {

			if (statuses.equals(EDI_Status_value)) {

				flag = true;

			} else {

				changed_statuses.add(statuses);
				flag = false;
			}

		}

		if (flag) {
			System.out.println("Matched || Expected The Status value is : " + EDI_Status_value
					+ " || Actual The Status value is : " + EDI_Status_value);
			Extent_pass_New(driver, ("Matched || Expected The Status value is : " + EDI_Status_value
					+ " || Actual The Status value is : " + EDI_Status_value), test, test1);

		} else {
			System.out.println("Not Matching|| Expected The Status value is : " + EDI_Status_value
					+ " ||Actual The Status value is : " + changed_statuses);
			Extent_fail(driver, ("Not Matching|| Expected The Status value is : " + EDI_Status_value
					+ " ||Actual The Status value is : " + changed_statuses), test, test1);

		}

		Step_End(4, "Click the show button and verify we given Status only shown in the AG Grid ", test, test1);

		Step_Start(5, "Print the Total no.of records in the AG Grid ", test, test1);

		System.out.println("Total number of record in AG Grid is " + totalCount);
		Extent_pass_New(driver, ("Total number of record in AG Grid is " + totalCount), test, test1);

		Step_End(5, "Print the Total no.of records in the AG Grid ", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
