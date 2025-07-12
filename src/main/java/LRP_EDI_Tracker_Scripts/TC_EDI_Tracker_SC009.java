package LRP_EDI_Tracker_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Tracker_SC009 extends Keywords {
	public void EDI_Tracker_SC009(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Tracker_SC009";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String edi_tracker_module = Excel_data.get("edi_tracker_module");
		String Direction_Option = Excel_data.get("Direction_Option");
		String from_date = Excel_data.get("from_date");
		String to_date = Excel_data.get("to_date");
		String Selectall_Checkbox_Status = Excel_data.get("Selectall_Checkbox_Status");
		String download_filename = Excel_data.get("download_filename");

		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		moduleNavigate(driver, edi_tracker_module);

		Step_Start(1, "Select the Direction as (OutBound)", test, test1);
		waitForElement(driver, EDI_Direction_Dropdown);
		click(driver, EDI_Direction_Dropdown);
		Step_End(1, "Select the from date and to date", test, test1);

		Step_Start(2, " Select the from date and To date", test, test1);
		formatLocatorClick(driver, DropDown_Select, Direction_Option);
		selectDatePicker(driver, EDI_from_date_selecter, from_date);
		selectDatePicker(driver, EDI_to_date_selecter, to_date);
		Step_End(2, " Select the from date and To date", test, test1);

		Step_Start(3, "click the show button", test, test1);
		waitForElement(driver, EDI_show_button);
		click(driver, EDI_show_button);
		Step_End(3, "click the show button", test, test1);

		Step_Start(4, "select all data and click compressed download button", test, test1);

		waitForElement(driver, EDI_Compressed_Download_button);
		checkBox(driver, EDI_Selectall_checkbox, Selectall_Checkbox_Status);

		String filename = Verify_FileDownloaded1(driver, download_filename, EDI_Compressed_Download_button);
		Extent_pass_New(driver, "The new file was downloaded in the " + filename, test, test1);

		Step_End(4, "select all data and click compressed download button", test, test1);

	}
}