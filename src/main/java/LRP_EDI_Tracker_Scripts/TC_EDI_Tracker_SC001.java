package LRP_EDI_Tracker_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Tracker_SC001 extends Keywords {

	public void EDI_Tracker_SC001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Tracker_SC001";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String edi_tracker_module = Excel_data.get("edi_tracker_module");
		String Direction_Option = Excel_data.get("Direction_Option");
		String from_date = Excel_data.get("from_date");
		String to_date = Excel_data.get("to_date");
		String Column_header = Excel_data.get("Column_header");
		String Condition = Excel_data.get("Condition");
		String Reference_Id_value = Excel_data.get("Reference_Id_value");

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

		Step_Start(3, "click the show button", test, test1);
		click(driver, EDI_show_button);
		Step_Start(3, "click the show button", test, test1);

		Step_Start(4, "print the Total no.of records in the AG Grid", test, test1);
		
		waitForElement(driver, EDI_show_button);
		
		AGGridValueFilter(driver, Column_header, Condition, Reference_Id_value);
		
		waitForElement(driver, EDI_Total_Records);
		String Act_Total_Record = getText(driver, EDI_Total_Records);
		System.out.println("Actual Total Record of AG Grid is :" + Act_Total_Record);
		Extent_pass_New(driver, "Actual Total Record of AG Grid is :" + Act_Total_Record, test, test1);
		
		Step_End(4, "print the Total no.of records in the AG Grid", test, test1);

		Step_Start(5, "5.Select any record with completed status in AG Grid and click Download \r\n"
				+ "If any record with requested status in AG Grid and click download, pop up message should appear",
				test, test1);
		
		waitForElement(driver, EDI_PartnerId_Grid);
		click(driver, EDI_PartnerId_Grid);
		
		String dowloadedFilePath = downloadFile(driver, EDI_download_button);
		System.out.println("dowloadedFilePath : " + dowloadedFilePath);
		
		if (dowloadedFilePath.contains("File not found")) {
			System.out.println(
					"Not Matched : Expected The file should be download from the ag grid records || Actual The record is not having the completed status it might be requested and the actual popup msg is "
							+ dowloadedFilePath);
			Extent_fail(driver,
					"Not Matched : Expected The file should be download from the ag grid records || Actual The record is not having the completed status it might be requested and the actual popup msg is "
							+ dowloadedFilePath,
					test, test1);
		} else if (!dowloadedFilePath.equals("")) {
			System.out.println(
					"Matched : Expected The file should be download from the ag grid records || Actual The file is downloaded from the ag grid records and the file path is : "
							+ dowloadedFilePath);
			Extent_pass_New(driver,
					"Matched : Expected The file should be download from the ag grid records || Actual The file is downloaded from the ag grid records and the file path is : "
							+ dowloadedFilePath,
					test, test1);
		} else {
			System.out.println(
					"Not Matched : Expected The file should be download from the ag grid records || Actual The file is Not downloaded from the ag grid records ");
			Extent_fail(driver,
					"Not Matched : Expected The file should be download from the ag grid records || Actual The file is Not downloaded from the ag grid records "
							+ dowloadedFilePath,
					test, test1);
		}
		
		Step_End(5, "5.Select any record with completed status in AG Grid and click Download \r\n"
				+ "If any record with requested status in AG Grid and click download, pop up message should appear",
				test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}