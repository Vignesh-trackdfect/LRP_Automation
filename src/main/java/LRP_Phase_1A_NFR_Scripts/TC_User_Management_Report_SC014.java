package LRP_Phase_1A_NFR_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_User_Management_Report_SC014 extends Keywords {
	public void User_Management_Report_SC014(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_User_Management_Report_SC014";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Report_Module = Excel_data.get("User_Management_Report_Module");
		String User_Option = Excel_data.get("User_Option");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String User_Name_Input = Excel_data.get("User_Name_Input");

		String Specific_header = Excel_data.get("Specific_header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Column_Header = Excel_data.get("Column_Header");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login & open user management report screen.", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Report_Module);

		Step_End(1, "Login & open user management report screen.", test, test1);

		Step_Start(2, "Retrieve data by using User Option (By all)", test, test1);

		waitForElement(driver, UMR_User_Option_drop_down);
		click(driver, UMR_User_Option_drop_down);
		formatLocatorClick(driver, DropDown_Select, User_Option);

		waitForElement(driver, UMR_User_Name_Button);
		click(driver, UMR_User_Name_Button);

		twoColumnSearchWindow(driver, User_Name_Header, Dropdown_Condition, User_Name_Input);

		Step_End(2, "Retrieve data by using User Option (By all)", test, test1);

		Step_Start(3, "Click on show button to display the data", test, test1);

		waitForElement(driver, UMR_Show_Button);
		click(driver, UMR_Show_Button);

		Step_End(3, "Click on show button to display the data", test, test1);

		Step_Start(4,
				"Scroll through a specific column (e.g., \"User Code\") and identify that it contains duplicate values (e.g., multiple \"AEESCD\" entries).",
				test, test1);

		
		Step_Start(5, "Click on the Grid Settings Icon,Click the “Distinct Filter” Icon", test, test1);
		Step_Start(6, "A dropdown or selection list will appear. Choose a column like \"PortCode\".", test, test1);

		formatLocatorClick(driver, UMR_Grid_Headers, Specific_header);

		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);

		waitForElement(driver, UMR_selectAll_checkbox);
		click(driver, UMR_selectAll_checkbox);

		waitForElement(driver, UMR_search_input_condition);
		sendKeys(driver, UMR_search_input_condition, Filter_Condition);

		enter(driver);

		waitForElement(driver, UMR_optionsmenu_button);
		click(driver, UMR_optionsmenu_button);
		Step_End(4,
				"Scroll through a specific column (e.g., \"User Code\") and identify that it contains duplicate values (e.g., multiple \"AEESCD\" entries).",
				test, test1);
		Step_End(5, "Click on the Grid Settings Icon,Click the “Distinct Filter” Icon", test, test1);

		Step_End(6, "A dropdown or selection list will appear. Choose a column like \"PortCode\".", test, test1);

		Step_Start(7, "Apply the Filter.", test, test1);

		waitForElement(driver, UMR_Distint_Filter);
		click(driver, UMR_Distint_Filter);

		Step_End(7, "Apply the Filter.", test, test1);

		Step_Start(8, "Check that the grid now only displays one row per unique value in the selected column", test,
				test1);

		String Record = getText(driver, UMR_total_records);

		String[] count = Record.split("of");

		int Record_Count = Integer.parseInt(count[0].trim());
		System.out.println("Record_Count: " + Record_Count);

		for (int i = 0; i < Record_Count; i++) {

			String GridHeader = String.format(UMR_select_Header, i, Column_Header);
			mouseOverToElement(driver, GridHeader);
			scrollToElement(driver, GridHeader);
			String Col_Text = getText(driver, GridHeader);

			if (Col_Text.equalsIgnoreCase(Filter_Condition)) {

				System.out.println("Matched || grid   displays one row per unique value " + i + "Actual:  unique Values are matching  with the grid");
				Extent_pass_New(driver,"Matched || grid  displays one row per unique value " + i + "Actual:  unique Values are matching  with the grid",
						test, test1);


			} else {

				System.out.println("Not Matched || grid  displays one row per unique value " + i + "Actual:  unique Values  are not matching with the grid ");
			Extent_fail(driver,"Not Matched || grid now  displays one row per unique value " + i + "Actual:  unique Values  are not matching with the grid " , test, test1);
			}
		}

		Step_End(8, "Check that the grid now only displays one row per unique value in the selected column", test,
				test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
