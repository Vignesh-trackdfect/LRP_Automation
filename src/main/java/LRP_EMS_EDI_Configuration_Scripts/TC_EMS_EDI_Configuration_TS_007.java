package LRP_EMS_EDI_Configuration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_EMS_EDI_Configuration_TS_007 extends Keywords {

	public void EMS_EDI_Configuration_TS_007(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_007";
		

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Tab_Option = Excel_data.get("Tab_Option");
		String Ag_Grid_Header = Excel_data.get("Ag_Grid_Header");
		String By_EDI_Tab_Table = Excel_data.get("By_EDI_Tab_Table");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Partner_ID_input = Excel_data.get("Partner_ID_input");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID_Input = Excel_data.get("EDI_ID_Input");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "Go to the By EDI tab", test, test1);

		formatLocatorClick(driver, EEC_Tab_Option, Tab_Option);

		Step_End(1, "Go to the By EDI tab", test, test1);

		Step_Start(2, "Click the Partner Id search button, and select the partner ID from the two column search", test,
				test1);

		waitForElement(driver, EEC_Partner_Id_Search_Button);
		click(driver, EEC_Partner_Id_Search_Button);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID_input);

		Step_End(2, "Click the Partner Id search button, and select the partner ID from the two column search", test,
				test1);

		Step_Start(3,
				"Click the EDI ID search button, and select the EDI ID from the two column search.Filter using the EDI ID and Partner ID, then click the Search button",
				test, test1);

		waitForElement(driver, EEC_EDI_Id_Search_Button);
		click(driver, EEC_EDI_Id_Search_Button);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID_Input);

		Step_End(3,
				"Click the EDI ID search button, and select the EDI ID from the two column search.Filter using the EDI ID and Partner ID, then click the Search button",
				test, test1);

		Step_Start(4, "Click the show button", test, test1);

		waitForElement(driver, EEC_Show_Button);
		click(driver, EEC_Show_Button);

		Step_End(4, "Click the show button", test, test1);

		Step_Start(5, "Once clicked, records will be shown in the AG grid for the selected conditions", test, test1);

		reArrangeAG_GridColumns(driver, Ag_Grid_Header);
		
		waitForElement(driver, EEC_EDI_ID_Table);
		List<Map<String, String>> table_data = extractTableDataByColumnWithoutScroll(driver, EEC_EDI_ID_Table);

		List<String> headers = splitAndExpand(Ag_Grid_Header, ",");
		String value = TableDataForReport(driver, table_data, By_EDI_Tab_Table, headers);
		if (!value.equals("") && !value.equals(null)) {
			System.out.println(
					"Expected result is : Record should be shown in the grid : Actual result is : Records are showing in the grid || Actual Table value is : <pre>"+ value + "</pre>");
			Extent_pass_New(driver,
					"Expected result is : Record should be shown in the grid : Actual result is : Records are showing in the grid || Actual Table value is : <pre>"+ value + "</pre>",test, test1);
		} else {
			System.out.println(
					"Expected result is : Record should be shown in the grid : Actual result is : Records are not showing in the grid || Actual Table value is  missing : <pre>"
							+ value + "</pre>");
			Extent_fail(driver,
					"Expected result is : Record should be shown in the grid : Actual result is : Records are not showing in the grid ",test, test1);
		}

		Step_End(5, "Once clicked, records will be shown in the AG grid for the selected conditions", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
