package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC012 extends Keywords {

	public void PartBL_TC012(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC012";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String Plugin_Module = Excel_data.get("Plugin_Module");
		String pluginID = Excel_data.get("pluginID");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String PartBL_SearchOption = Excel_data.get("PartBL_SearchOption");
		String Plugin_faalse = Excel_data.get("Plugin_False");
		String Warning_Popup = Excel_data.get("Warning_Popup");

		String Plugin_Flase = String.format(PluginFalse, Plugin_faalse);

		PartBL_Common_Creation commonCreation = new PartBL_Common_Creation();

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);

		Map<String, String> BL_MCN_Numbers = commonCreation.Common_PartBL(driver, test, test1, Excel_data);

		String BLNumber = BL_MCN_Numbers.get("BL_Number");

		System.out.println("BLNumber : " + BLNumber);

		Step_Start(1, "Set PLC plugin is false", test, test1);

		moduleNavigate(driver, Plugin_Module);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);

		waitForElement(driver, Plugin_Flase);
		safeclick(driver, Plugin_Flase);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);

		Step_End(1, "Set PLC plugin is false", test, test1);

		Step_Start(2, "Open the Part BL module", test, test1);

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(2, "Open the Part BL module", test, test1);

		Step_Start(3, "Click the \"new\" button", test, test1);

		newButton(driver);

		Step_End(3, "Click the \"new\" button", test, test1);

		Step_Start(4, "Use the BL number search to retrieve the data.", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, PartBL_SearchOption, BLNumber, "", "", "", "");

		Step_End(4, "Use the BL number search to retrieve the data.", test, test1);

		Step_Start(5, "\"No charges exist in Master BL to proceed part BL\" message shown.", test, test1);

		waitForPopup(driver, popup_Message, Warning_Popup);

		String Actual_popup = getText(driver, popup_Message);

		if (Actual_popup.equals(Warning_Popup)) {

			System.out.println(
					"Expected popup message was : " + Warning_Popup + " Actual popup message was : " + Actual_popup);
			Extent_pass_New(driver,
					"Expected popup message was : " + Warning_Popup + " Actual popup message was : " + Actual_popup,
					test, test1);

		} else {

			System.out.println(
					"Expected popup message was : " + Warning_Popup + " Actual popup message was : " + Actual_popup);
			Extent_fail(driver,
					"Expected popup message was : " + Warning_Popup + " Actual popup message was : " + Actual_popup,
					test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		newButton(driver);

		Step_End(5, "\"No charges exist in Master BL to proceed part BL\" message shown.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
