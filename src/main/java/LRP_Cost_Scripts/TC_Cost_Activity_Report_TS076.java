package LRP_Cost_Scripts;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import java.util.Map;
import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS076 extends Keywords {

	public void Cost_Activity_Report_TS076(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS076";
		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		String final_popup_expected = Excel_data.get("final_popup_expected");
		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");

		String AgencyUser = Excel_data.get("AgencyUser");

		String Search_Type2 =Excel_data.get("Search_Type2");
		String Search_Input2 =Excel_data.get("Search_Input2");
		String Search_Type3 =Excel_data.get("Search_Type3");
		String Search_Input3 =Excel_data.get("Search_Input3");
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select the required agency.",
				test, test1);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.",
				test, test1);

		Step_Start(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);

		Step_Start(3, ".Click on the global search option which is available in the tool bar.", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(3, ".Click on the global search option which is available in the tool bar.", test, test1);

		Step_Start(4, "Check whether it opens a new search window", test, test1);
		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button.", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button.", test, test1);

		globalValueSearchWindow(driver, CAR_Retrieve_Condition, CAR_Retrieve_Type, CAR_Number_Retrieve, Search_Type2, Search_Input2, Search_Type3, Search_Input3);

		Step_End(4, "Check whether it opens a new search window", test, test1);

		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);

		Step_End(6, "Then click on the search button.", test, test1);

		Step_End(7, "System will show the CAR No. and Click on the select button.", test, test1);

		Step_Start(8,
				"If the CAR is closed, Clicking on the edit option in the toolbar, System validates as \"Closed CAR cannot be edited\"",
				test, test1);

		waitForDisplay(driver, car_close_Btn);
		if (isdisplayed(driver, car_close_Btn)) {
			click(driver, car_close_Btn);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

		}

		scrollTop(driver);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForPopup(driver, popup_Message, final_popup_expected);
		String final_popup_actual = getText(driver, popup_Message);

		if (final_popup_expected.equals(final_popup_actual)) {

			System.out.println("Matched || Expected final popup after clicking edit button -> " + final_popup_expected
					+ "|| actual final popup after clicking edit button -> " + final_popup_actual);
			Extent_pass_New(driver, "Matched || Expected final popup after clicking edit button -> " + final_popup_expected
					+ "|| actual final popup after clicking edit button -> " + final_popup_actual, test, test1);

		} else {

			System.out
					.println("Not Matched || Expected final popup after clicking edit button -> " + final_popup_expected
							+ "|| actual final popup after clicking edit button -> " + final_popup_actual);
			Extent_fail(driver,
					"Not Matched || Expected final popup after clicking edit button -> " + final_popup_expected
							+ "|| actual final popup after clicking edit button -> " + final_popup_actual,
					test, test1);

		}

		Step_End(8,
				"If the CAR is closed, Clicking on the edit option in the toolbar, System validates as \\\"Closed CAR cannot be edited\\\"",
				test, test1);

		Step_Start(9, "Click on the ok option.  ", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(9, "Click on the ok option.  ", test, test1);

		Extent_completed(tc_Name, test, test1);

	}

}
