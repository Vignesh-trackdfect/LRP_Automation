package LRP_EMS_EDI_Configuration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_005 extends Keywords {

	public void EMS_EDI_Configuration_TS_005(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_005";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Format_Value = Excel_data.get("Format_Value");
		String Tab_Option = Excel_data.get("Tab_Option");
		String By_Format_Tab_Table = Excel_data.get("By_Format_Tab_Table");
		String Ag_Grid_Header = Excel_data.get("Ag_Grid_Header");
		
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);
		moduleNavigate(driver, Module);
		Step_Start(1, "By default ' By Format ' tab opens first", test, test1);	
		formatLocatorClick(driver, EEC_Tab_Option, Tab_Option);
		Step_End(1, "By default ' By Format ' tab opens first", test, test1);
		Step_Start(2, "Click the \"Format\" dropdown and select the type of EDI you want to retreive", test, test1);	
		waitForElement(driver, EEC_Format_Dropdown);
		click(driver, EEC_Format_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Format_Value);
		Step_End(2, "Click the \"Format\" dropdown and select the type of EDI you want to retreive", test, test1);
		
		Step_Start(3, "Once Format is selected all the relevant records will be shown in the AG grid", test, test1);
	
		reArrangeAG_GridColumns(driver, Ag_Grid_Header);
		
		waitForElement(driver, EEC_By_Format_Total_Records);
		String total = getText(driver, EEC_By_Format_Total_Records);
		int rowCount = Integer.parseInt(total);
		
		waitForElement(driver, EEC_By_Format_Table);
		
		List<Map<String, String>> table_data = extractTableDataByRowIndex(driver, EEC_By_Format_Table,rowCount);
		List<String> headers = splitAndExpand(Ag_Grid_Header, ",");
		
		String value = TableDataForReport(driver, table_data, By_Format_Tab_Table, headers);
		
		if(!value.equals("")&&!value.equals(null)) {
			System.out.println(
					"Expected result is : Record should be shown in the grid : Actual result is : Records are showing in the grid || Actual Table value is : <pre>"
							+ value + "</pre>");
			Extent_pass_New(driver,
					"Expected result is : Record should be shown in the grid : Actual result is : Records are showing in the grid || Actual Table value is : <pre>"
							+ value + "</pre>",
					test, test1);
		} else {
			System.out.println(
					"Expected result is : Record should be shown in the grid : Actual result is : Records are not showing in the grid || Actual Table value is  missing : <pre>"
							+ value + "</pre>");
			Extent_fail(driver,
					"Expected result is : Record should be shown in the grid : Actual result is : Records are not showing in the grid ",
					test, test1);
		}
	
		Step_End(3, "Once Format is selected all the relevant records will be shown in the AG grid", test, test1);
	
		Extent_completed(testcase_Name, test, test1);
	}
}