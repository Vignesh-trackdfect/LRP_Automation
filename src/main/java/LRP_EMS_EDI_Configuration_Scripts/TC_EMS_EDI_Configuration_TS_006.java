package LRP_EMS_EDI_Configuration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_006 extends Keywords {

	public void EMS_EDI_Configuration_TS_006(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_006";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Ag_Grid_Header = Excel_data.get("Ag_Grid_Header");
		String By_EDI_Tab_Table = Excel_data.get("By_EDI_Tab_Table");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Global_Search_Type1 = Excel_data.get("Global_Search_Type1");
		String Global_Search_Value1 = Excel_data.get("Global_Search_Value1");
		String Global_Search_Type2 = Excel_data.get("Global_Search_Type2");
		String Global_Search_Value2 = Excel_data.get("Global_Search_Value2");
		String Global_Search_Type3 = Excel_data.get("Global_Search_Type3");
		String Global_Search_Value3 = Excel_data.get("Global_Search_Value3");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "Click the \"Global Search\" option", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(1, "Click the \"Global Search\" option", test, test1);

		Step_Start(2, "Filter using the EDI ID and Partner ID, then click the \"Search\" button", test, test1);
		Step_Start(3, "After that, select the grid you want to retrieve", test, test1);

		globalValueSearchWindow(driver, Filter_Condition, Global_Search_Type1, Global_Search_Value1,
				Global_Search_Type2, Global_Search_Value2, Global_Search_Type3, Global_Search_Value3);
		Step_End(3, "After that, select the grid you want to retrieve", test, test1);
		Step_End(2, "Filter using the EDI ID and Partner ID, then click the \"Search\" button", test, test1);

		Step_Start(4,
				"Once selected, the system navigates to the \"By EDI\" tab, and the filtered records will show based on the EDI and Partner details",
				test, test1);

//		reArrangeAG_GridColumns(driver, Ag_Grid_Header);
		waitForElement(driver, EEC_By_EDI_Total_Records);
		String total = getText(driver, EEC_By_EDI_Total_Records);
		int rowCount = Integer.parseInt(total);
		waitForElement(driver, EEC_EDI_ID_Table);
		List<Map<String, String>> table_data = extractTableDataByRowIndex(driver, EEC_EDI_ID_Table, rowCount);
		List<String> headers = splitAndExpand(Ag_Grid_Header, ",");
		String value = TableDataForReport(driver, table_data, By_EDI_Tab_Table, headers);
		if (!value.equals("") && !value.equals(null)) {
			System.out.println(
					"Expected result is : Filtered Record should be shown in the grid : Actual result is : Filtered Record are showing in the grid || Actual Table value is : <pre>"
							+ value + "</pre>");
			Extent_pass_New(driver,
					"Expected result is : Filtered Record should be shown in the grid : Actual result is : Filtered Record are showing in the grid || Actual Table value is : <pre>"
							+ value + "</pre>",
					test, test1);
		} else {
			System.out.println(
					"Expected result is : Filtered Record should be shown in the grid : Actual result is : Filtered Record are not showing in the grid || Actual Table value is  missing : <pre>"
							+ value + "</pre>");
			Extent_fail(driver,
					"Expected result is : Filtered Record should be shown in the grid : Actual result is : Filtered Record are not showing in the grid ",
					test, test1);
		}

		Step_End(4,
				"Once selected, the system navigates to the \"By EDI\" tab, and the filtered records will show based on the EDI and Partner details",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}