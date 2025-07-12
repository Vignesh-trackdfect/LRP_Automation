package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC16 extends Keywords {
	public void EDI_Code_Mapping_SC16(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC16";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Size_Type_Header = Excel_data.get("Size_Type_Header");
		String Size_Type_value = Excel_data.get("Size_Type");
		String EDI_Eqp_Type_Popup = Excel_data.get("EDI_Eqp_Type_Popup");
		String EDI_Liner_Eqp_Type_Popop = Excel_data.get("EDI_Liner_Eqp_Type_Popop");
		String Filter_Condition = Excel_data.get("Filter_Condition");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Select the partner Id and click ISO tab", test, test1);

		waitForElement(driver, Click_ISO_Tab);
		click(driver, Click_ISO_Tab);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		Step_End(1, "Select the partner Id and click ISO tab", test, test1);

		Step_Start(2, "And click the save button now\" Enter The Liner Eqp.Type\" popup should show", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, EDI_Liner_Eqp_Type_Popop);
		String Saved_Popup6 = getText(driver, popup_Message);
		System.out.println(EDI_Liner_Eqp_Type_Popop);
		if (Saved_Popup6.equals(EDI_Liner_Eqp_Type_Popop)) {
			System.out.println("Matched || " + " Expected Liner Eqp.Type poup : " + EDI_Liner_Eqp_Type_Popop
					+ " || Actual Liner Eqp.Type poup : " + Saved_Popup6);
			Extent_pass_New(driver, "Matched || " + " Expected Liner Eqp.Type poup: " + EDI_Liner_Eqp_Type_Popop
					+ " || Actual Liner Eqp.Type poup : " + Saved_Popup6, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Liner Eqp.Type poup : " + EDI_Liner_Eqp_Type_Popop
					+ " || Actual Liner Eqp.Type poup : " + Saved_Popup6);
			Extent_fail(driver, "Not Matched || " + " Expected Liner Eqp.Type poup : " + EDI_Liner_Eqp_Type_Popop
					+ " || Actual Liner Eqp.Type poup : " + Saved_Popup6, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(2, "And click the save button now\" Enter The Liner Eqp.Type\" popup should show", test, test1);

		Step_Start(3, "Select any data in the liner eqp.types", test, test1);

		waitForElement(driver, Liner_Eqp_Type);
		click(driver, Liner_Eqp_Type);

		twoColumnSearchWindow(driver, Size_Type_Header, Filter_Condition, Size_Type_value);

		Step_End(3, "Select any data in the liner eqp.types", test, test1);

		Step_Start(4, "And click the save button now\"Enter The EDI Eqp.Type\" popup should show", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, EDI_Eqp_Type_Popup);
		String Saved_Popup1 = getText(driver, popup_Message);
		System.out.println(EDI_Eqp_Type_Popup);
		if (Saved_Popup1.equals(EDI_Eqp_Type_Popup)) {
			System.out.println("Matched || " + " Expected EDI Eqp.Type poup : " + EDI_Eqp_Type_Popup
					+ " || Actual EDI Eqp.Type poup : " + Saved_Popup1);
			Extent_pass_New(driver, "Matched || " + " Expected EDI Eqp.Type poup: " + EDI_Eqp_Type_Popup
					+ " || Actual EDI Eqp.Type poup : " + Saved_Popup1, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI Eqp.Type poup : " + EDI_Eqp_Type_Popup
					+ " || Actual EDI Eqp.Type poup : " + Saved_Popup1);
			Extent_fail(driver, "Not Matched || " + " Expected EDI Eqp.Type poup : " + EDI_Eqp_Type_Popup
					+ " || Actual EDI Eqp.Type poup : " + Saved_Popup1, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4, "And click the save button now\"Enter The EDI Eqp.Type\" popup should show", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}