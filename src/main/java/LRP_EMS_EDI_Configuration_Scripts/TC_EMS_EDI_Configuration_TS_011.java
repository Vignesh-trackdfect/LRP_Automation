package LRP_EMS_EDI_Configuration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_011 extends Keywords {

	public void EMS_EDI_Configuration_TS_011(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_011";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Ag_Grid_Header = Excel_data.get("Ag_Grid_Header");
		String General_Tab_Table = Excel_data.get("General_Tab_Table");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "go to the GENERAL tab", test, test1);

		waitForElement(driver, EEC_General_Button);
		click(driver, EEC_General_Button);

		Step_End(1, "go to the GENERAL tab", test, test1);

		Step_Start(2, "The configured values will show in the AG grid", test, test1);

		reArrangeAG_GridColumns(driver, Ag_Grid_Header);
		waitForElement(driver, EEC_GENERAL_Ag_Grid_Table);
		List<Map<String, String>> table_data = extractTableDataByColumnWithoutScroll(driver, EEC_GENERAL_Ag_Grid_Table);

		List<String> headers = splitAndExpand(Ag_Grid_Header, ",");
		String value = TableDataForReport(driver, table_data, General_Tab_Table, headers);
		if (!value.equals("") && !value.equals(null)) {
			Extent_pass_New(driver, "Expected result is : The configured value should displayed in the grid || Actual result is : The configured value was displayed in the grid", test, test1);
			Extent_pass_New(driver, "Matched || Actual Table value is  : <pre>" + value + "</pre>", test, test1);
		} else {
			Extent_fail1(test, "Expected result is : The configured value should displayed in the grid || Actual result is : The configured value was not displayed in the grid");
			Extent_fail(driver, "Matched Actual Table value is Not Showed :" + value + "", test, test1);
		}

		Step_End(2, "The configured values will show in the AG grid", test, test1);
		
		Extent_completed(testcase_Name, test, test1);

	}
}