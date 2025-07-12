package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_User_Management_Report_SC012 extends Keywords {

	public void User_Management_Report_SC012(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_User_Management_Report_SC012";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String UserOption = Excel_data.get("UserOption");
		String Username_Header = Excel_data.get("Username_Header");
		String Twocolumn_Condition = Excel_data.get("Twocolumn_Condition");
		String Username_Input = Excel_data.get("Username_Input");
		String ExistingTemplate_Name = Excel_data.get("ExistingTemplate_Name");
		String Usercode_ColumnName = Excel_data.get("Usercode_ColumnName");
		String Usercode = Excel_data.get("Usercode");
		String NewTemplate_Name = Excel_data.get("NewTemplate_Name");
		String Saved_Popup = Excel_data.get("Saved_Popup");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login user management report screen", test, test1);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Login user management report screen", test, test1);

		Step_Start(2, "Retrieve data by using User Option (By all)", test, test1);

		waitForElement(driver, UMR_User_Option_drop_down);
		click(driver, UMR_User_Option_drop_down);

		formatLocatorClick(driver, DropDown_Select, UserOption);

		waitForElement(driver, UMR_User_Name_Button);
		click(driver, UMR_User_Name_Button);

		twoColumnSearchWindow(driver, Username_Header, Twocolumn_Condition, Username_Input);

		Step_End(2, "Retrieve data by using User Option (By all)", test, test1);

		Step_Start(3, "Click on show button to display the data.", test, test1);

		waitForElement(driver, UMR_Show_Button);
		click(driver, UMR_Show_Button);

		Step_End(3, "Click on show button to display the data.", test, test1);

		Step_Start(4, "Open the saved templates list.Select and apply an existing template like \"DefaultTemplate\".",
				test, test1);

		formatLocatorClick(driver, UMR_Select_Template, ExistingTemplate_Name);

		Step_End(4, "Open the saved templates list.Select and apply an existing template like \"DefaultTemplate\".",
				test, test1);

		Step_Start(5,
				"Change column visibility, apply different filters, or rearrange the layout to simulate user modifications.",
				test, test1);

		AG_DistinctFilter(driver, Usercode_ColumnName, Usercode);

		Step_End(5,
				"Change column visibility, apply different filters, or rearrange the layout to simulate user modifications.",
				test, test1);

		Step_Start(6, "Locate and click the settings or gear icon that opens the options menu.", test, test1);

		waitForElement(driver, UMR_Treetable);
		click(driver, UMR_Treetable);

		Step_End(6, "Locate and click the settings or gear icon that opens the options menu.", test, test1);

		Step_Start(7, "Click the second icon labeled “Save as Template.”", test, test1);

		waitForElement(driver, UMR_SaveasTemplate);
		click(driver, UMR_SaveasTemplate);

		Step_End(7, "Click the second icon labeled “Save as Template.”", test, test1);

		Step_Start(8, "In the input box that appears, type a new, unique template name", test, test1);

		waitForElement(driver, UMR_TemplateNameInput);
		sendKeys(driver, UMR_TemplateNameInput, NewTemplate_Name);

		Step_End(8, "In the input box that appears, type a new, unique template name", test, test1);

		Step_Start(9, "Submit the form using the Save or OK button", test, test1);

		waitForElement(driver, UMR_Save_templateInput);
		click(driver, UMR_Save_templateInput);

		Step_Start(9, "Submit the form using the Save or OK button", test, test1);

		Step_Start(10, "Confirm that a message appears saying \"Template saved successfully\"", test, test1);

		waitForPopup(driver, Popup_Message, Saved_Popup);

		String actual_popup = getText(driver, Popup_Message);

		if (Saved_Popup.equals(actual_popup)) {

			System.out.println("Expected saved template popup was : " + Saved_Popup
					+ " || Actual saved templated popup message was : " + actual_popup);
			Extent_pass_New(driver, "Expected saved template popup was : " + Saved_Popup
					+ " || Actual saved templated popup message was : " + actual_popup, test, test1);

		} else {

			System.out.println("Expected saved template popup was : " + Saved_Popup
					+ " || Actual saved templated popup message was : " + actual_popup);
			Extent_fail(driver, "Expected saved template popup was : " + Saved_Popup
					+ " || Actual saved templated popup message was : " + actual_popup, test, test1);

		}

		String newtemplate = String.format(UMR_Select_Template, NewTemplate_Name);

		waitForDisplay(driver, newtemplate);

		if (isdisplayed(driver, newtemplate)) {

			System.out.println(
					"Expected result : Newly create template should be added in the screen || Actual result : Newly create template was added in the screen");

			Extent_pass_New(driver,
					"Expected result : Newly create template should be added in the screen || Actual result : Newly create template was added in the screen",
					test, test1);
		} else {

			System.out.println(
					"Expected result : Newly create template should be added in the screen || Actual result : Newly create template was not added in the screen");

			Extent_fail(driver,
					"Expected result : Newly create template should be added in the screen || Actual result : Newly create template was not added in the screen",
					test, test1);
		}

		Step_End(10, "Confirm that a message appears saying \"Template saved successfully\"", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
