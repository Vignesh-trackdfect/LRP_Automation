package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC018 extends Keywords {

	public void PartBL_TC018(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC018";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String ModuleName = Excel_data.get("ModuleName");
		String Column_Header = Excel_data.get("Column_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String value = Excel_data.get("value");
		String EnableStatus = Excel_data.get("EnableStatus");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Select_field = Excel_data.get("Select_field");
		String EnableStatus1 = Excel_data.get("EnableStatus1");
		String Manifest_closure_Popup = Excel_data.get("Manifest_closure_Popup");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);

		PartBL_Common_Creation partBL_Data_Creation = new PartBL_Common_Creation();

		Map<String, String> BL_MCN_Numbers = partBL_Data_Creation.Common_PartBL(driver, test, test1, Excel_data);

		System.out.println("BL_Number:" + BL_MCN_Numbers.get("BL_Number"));

		String BLNumber = BL_MCN_Numbers.get("BL_Number");

		Step_Start(1, "Set PLTM plugin is true", test, test1);

		setPluginConfig(driver, ModuleName, Column_Header, Condition_Filter, value, EnableStatus);

		Step_End(1, "Set PLTM plugin is true", test, test1);

		Step_Start(2, "Open the Part BL module", test, test1);

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(2, "Open the Part BL module", test, test1);

		Step_Start(3, ".Click the Create button.", test, test1);

		newButton(driver);

		Step_End(3, ".Click the Create button.", test, test1);

		Step_Start(4, "Use the BL number search to retrieve the data.", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, Search_Condition, Select_field, BLNumber, "", "", "", "");

		Step_End(4, "Use the BL number search to retrieve the data.", test, test1);

		Step_Start(5, "Manifest closure done for the BL, cannot proceed with Part BL message shown.", test, test1);

		waitForPopup(driver, popup_Message, Manifest_closure_Popup);
		String Actual_Manifest_closure_Popup = getText(driver, popup_Message);
		System.out.println("Actual_PartBL_Created_Popup is :" + Actual_Manifest_closure_Popup);

		if (Manifest_closure_Popup.equals(Actual_Manifest_closure_Popup)) {
			Extent_pass_New(driver, "Matched || Expected popup value was : " + Manifest_closure_Popup
					+ " || Actual popup was  displayed : " + Actual_Manifest_closure_Popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Manifest_closure_Popup
					+ " || Actual popup was displayed: " + Actual_Manifest_closure_Popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Manifest_closure_Popup
					+ " || Actual popup  was not displayed: " + Actual_Manifest_closure_Popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Manifest_closure_Popup
					+ " || Actual popup  was not displayed: " + Actual_Manifest_closure_Popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(5, "Manifest closure done for the BL, cannot proceed with Part BL message shown.", test, test1);

		Step_Start(6, "Set  PLTM plugin is false", test, test1);

		setPluginConfig(driver, ModuleName, Column_Header, Condition_Filter, value, EnableStatus1);

		Step_End(6, "Set PLTM plugin is false", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
