package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC68 extends Keywords {

	public void Feeder_Contract_SC68(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC68";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Feeder_Contract_Header = Excel_data.get("Feeder_Contract_Header");
		String Feeder_Contract_No = Excel_data.get("Feeder_Contract_No");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String ModuleName1 = Excel_data.get("ModuleName1");
		String Username_Header = Excel_data.get("Username_Header");
		String Username_Input = Excel_data.get("Username_Input");
		String Userlevel_Security_Saved_popup = Excel_data.get("Userlevel_Security_Saved_popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Enter the screen name as \"Feeder contract\" in module search field.", test, test1);

		moduleNavigate(driver, ModuleName);

		waitForElement(driver, FC_Search_Btn);
		click(driver, FC_Search_Btn);

		if (isdisplayed(driver, FC_Search_Window)) {
			System.out.println(
					"Expected result : Feeder contract search window should be displayed || Actual result : Feeder contract search window should be displayed ");
			Extent_pass_New(driver,
					"Expected result : Feeder contract search window should be displayed  || Actual result : Feeder contract search window should be displayed ",
					test, test1);
		} else {

			System.out.println(
					"Expected result :Feeder contract search window should be displayed  || Actual result : Feeder contract search window should be displayed ");
			Extent_fail(driver,
					"Expected result :Feeder contract search window should be displayed  || Actual result : Feeder contract search window should be displayed ",
					test, test1);

		}

		globalValueSearchWindow(driver, Two_Column_Condition, Feeder_Contract_Header, Feeder_Contract_No, "", "", "",
				"");

		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(2, "2.Check the Approve Button present in the Feeder contract.", test, test1);

		waitForElement(driver, FC_Approve_Btn);

		if (isElementEnabled(driver, FC_Approve_Btn)) {
			System.out.println(
					"Expected result : Approve button is present in feeder contract || Actual result : Approve button is present in feeder contract ");
			Extent_pass_New(driver,
					"Expected result : Approve button is present in feeder contract  || Actual result : Approve button is present in feeder contract ",
					test, test1);
		} else {

			System.out.println(
					"Expected result :Approve button is present in feeder contract  || Actual result : Approve button is present in feeder contract ");
			Extent_fail(driver,
					"Expected result :Approve button is present in feeder contract  || Actual result : Approve button is present in feeder contract ",
					test, test1);
		}

		Step_End(2, "2.Check the Approve Button present in the Feeder contract.", test, test1);

		Step_Start(3, "Enter the  screen name as 'user level security' in module search field", test, test1);

		moduleNavigate(driver, ModuleName1);

		Step_End(3, "Enter the  screen name as 'user level security' in module search field", test, test1);

		Step_Start(4, "Select the user name and Click edit .", test, test1);

		waitForElement(driver, FC_Username_Search_Btn);
		click(driver, FC_Username_Search_Btn);

		twoColumnSearchWindow(driver, Username_Header, Two_Column_Condition, Username_Input);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(4, "Select the user name and Click edit .", test, test1);

		Step_Start(5, "Remove the Reject button privilege on the user level security for Feeder contract.", test,
				test1);

		waitForElement(driver, FC_treeActivitysub_filter_Input);
		click(driver, FC_treeActivitysub_filter_Input);
		sendKeys(driver, FC_treeActivitysub_filter_Input, ModuleName);

		waitForElement(driver, FC_Feeder_Contract_FCT_Checkbox);
		click(driver, FC_Feeder_Contract_FCT_Checkbox);

		waitForElement(driver, FC_SubGrid_data_select);
		click(driver, FC_SubGrid_data_select);

		waitForElement(driver, FC_btn_PrivilegeRemove);
		click(driver, FC_btn_PrivilegeRemove);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForDisplay(driver, popup_Message);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(Userlevel_Security_Saved_popup)) {
			System.out.println(
					"Matched || " + " Expected Userlevel_Security details updated : " + Userlevel_Security_Saved_popup
							+ " || Actual Userlevel_Security details updated : " + Applied_Popup);
			Extent_pass_New(driver,
					"Matched || " + " Expected Userlevel_Security details updated " + Userlevel_Security_Saved_popup
							+ " || Actual Userlevel_Security details updated: " + Applied_Popup,
					test, test1);

		}

		else {
			System.out.println("Not Matched || " + " Expected Userlevel_Security details updated : "
					+ Userlevel_Security_Saved_popup + " || Actual Expected Userlevel_Security details updated : "
					+ Applied_Popup);
			Extent_fail(driver,
					"Not Matched || " + " Expected Userlevel_Security details updated: "
							+ Userlevel_Security_Saved_popup
							+ " || Actual Expected Userlevel_Security details updated: " + Applied_Popup,
					test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(5, "Remove the Reject button privilege on the user level security for Feeder contract.", test, test1);

		Step_Start(6, "Once logout and login the Application.", test, test1);

		waitForElement(driver, Logout_Icon);
		click(driver, Logout_Icon);

		waitForElement(driver, Logout_Yes_Btn);
		click(driver, Logout_Yes_Btn);

		LRP_Login(driver, username, pass_word);

		Step_End(6, "Once logout and login the Application.", test, test1);

		Step_Start(7, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		moduleNavigate(driver, ModuleName);

		Step_End(7, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(8, "Check Approve button not present in the Feeder contract.", test, test1);

		waitForElement(driver, FC_Module_Tab);

		if (!isdisplayed(driver, FC_Approve_Btn)) {
			System.out.println(
					"Expected result : Approve button should not present in feeder contract || Actual result : Approve  button is not present in feeder contract ");
			Extent_pass_New(driver,
					"Expected result : Approve button should not present in feeder contract  || Actual result : Approve button is not present in feeder contract ",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Approve button should not present in feeder contract  || Actual result : Approve button is present in feeder contract ");
			Extent_fail(driver,
					"Expected result : Approve button should not present in feeder contract  || Actual result : Approve button is present in feeder contract ",
					test, test1);
		}

		Step_End(8, "Check Approve button not present in the Feeder contract.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
