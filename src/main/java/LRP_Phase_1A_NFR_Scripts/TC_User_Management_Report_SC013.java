package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_User_Management_Report_SC013 extends Keywords {

	public void User_Management_Report_SC013(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_User_Management_Report_SC013";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Report_Module = Excel_data.get("User_Management_Report_Module");
		String User_Option = Excel_data.get("User_Option");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String User_Name_Input = Excel_data.get("User_Name_Input");
		String Template_deleted = Excel_data.get("Template_deleted");
		String Saved_Template_name = Excel_data.get("Saved_Template_name");

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

		Step_Start(4, "Access the saved templates list Choose an existing template, e.g., \"TestTemplate001\".", test,
				test1);

		formatLocatorClick(driver, UMR_Select_savedtemplate, Saved_Template_name);
		

		Step_End(4, "Access the saved templates list Choose an existing template, e.g., \"TestTemplate001\".", test,
				test1);
		Step_Start(5, "Click the third icon labeled “Delete Template.”", test, test1);
		Step_Start(6, "Check for a message like \"Template deleted successfully\"", test, test1);

		waitForElement(driver, UMR_optionsmenu_button);
		click(driver, UMR_optionsmenu_button);

		waitForElement(driver, UMR_DeleteTemplate_Button);
		click(driver, UMR_DeleteTemplate_Button);

		waitForPopup(driver, Popup_Message, Template_deleted);
		String Template_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + Template_popup);

		if (Template_deleted.equals(Template_popup)) {
			Extent_pass_New(driver, Template_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Template_deleted
					+ " || Actual popup value was is display: " + Template_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Template_deleted
					+ " || Actual popup value was not display: " + Template_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Template_deleted
					+ " || Actual popup value was not display: " + Template_popup, test, test1);

		}

		Step_End(5, "Click the third icon labeled “Delete Template.”", test, test1);
		Step_End(6, "Check for a message like \"Template deleted successfully\"", test, test1);

		Step_Start(7, "Confirm that \"TestTemplate001\" is no longer in the list.", test, test1);

		String deleted_template = String.format(UMR_Select_savedtemplate, Saved_Template_name);

		if (!isdisplayed(driver, deleted_template)) {

			System.out.println(
					"Pass || Expected result : Saved template should be deleted || Actual result : Saved template is deleted ");
			Extent_pass_New(driver, deleted_template, test, test1);
		} else {

			System.out.println(
					"Fail || Expected result : Saved template should  be deleted || Actual result : Saved template is not deleted ");
			Extent_pass(driver,
					"Fail || Expected result : Saved template should  be deleted  || Actual result : Saved template is not deleted",
					test, test1);
		}

		Step_End(7, "Confirm that \"TestTemplate001\" is no longer in the list.", test, test1);
		
		Extent_completed(testcase_Name, test, test1);

	}

}
