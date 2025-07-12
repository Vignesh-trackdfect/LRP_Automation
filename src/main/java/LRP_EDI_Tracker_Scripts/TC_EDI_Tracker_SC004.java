package LRP_EDI_Tracker_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Tracker_SC004 extends Keywords {
	public void EDI_Tracker_SC004(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Tracker_SC004";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String edi_tracker_module = Excel_data.get("edi_tracker_module");
		String Direction_Option = Excel_data.get("Direction_Option");
		String from_date = Excel_data.get("from_date");
		String to_date = Excel_data.get("to_date");
		String edi_id_header = Excel_data.get("edi_id_header");
		String ed_id_value = Excel_data.get("ed_id_value");
		String Condition = Excel_data.get("Condition");

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

		Step_Start(3, "Enter the EDIID", test, test1);
		click(driver, Edi_code_search);
		twoColumnSearchWindow(driver, edi_id_header, Condition, ed_id_value);
		Step_End(3, "Enter the EDIID", test, test1);

		Step_Start(4, "Click the show button and verify we given EDI ID only", test, test1);

		click(driver, EDI_show_button);

		List<WebElement> element = listOfElements(driver, EDI_grid);

		List<String> partnerIds = new ArrayList<String>();

		for (WebElement ele : element) {

			String id = ele.getText();

			partnerIds.add(id);

		}

		List<String> false_list = new ArrayList<String>();

		boolean flag = true;

		for (String partnerid : partnerIds) {

			if (partnerid.equals(ed_id_value)) {

				flag = true;

			} else {
				false_list.add(partnerid);
				flag = false;
			}

		}

		if (flag == true) {

			System.out.println("Expected result : The given EDI ID " + ed_id_value
					+ " only should show in the grid || Actual result is : The given EDI ID only showing in the grid");
			Extent_pass_New(driver, "Expected result : The given EDI ID " + ed_id_value
					+ " only should show in the grid || Actual result is : The given EDI ID only showing in the grid",
					test, test1);
		} else {

			System.out.println("Expected result : The given EDI ID " + ed_id_value
					+ " only should show in the grid || Actual result is : Some other EDI ID's : " + false_list
					+ " are showing in the grid");
			Extent_fail(driver,
					"Expected result : The given EDI ID " + ed_id_value
							+ " only should show in the grid || Actual result is : Some other EDI ID's : " + false_list
							+ " are showing in the grid",
					test, test1);

		}

		Step_End(4, "Click the show button and verify we given EDIID only", test, test1);

		Step_Start(5, "print the Total no.of records in the AG Grid", test, test1);

		waitForElement(driver, EDI_Total_Records);
		String Act_Total_Record = getText(driver, EDI_Total_Records);
		System.out.println("The Total Record of AG Grid is :" + Act_Total_Record);
		Extent_pass_New(driver, "The Total Record of AG Grid is :" + Act_Total_Record, test, test1);

		Step_End(5, "print the Total no.of records in the AG Grid", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
