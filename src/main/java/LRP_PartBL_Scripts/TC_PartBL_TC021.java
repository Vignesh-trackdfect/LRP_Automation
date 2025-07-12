package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC021 extends Keywords {
	public void PartBL_TC021(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC021";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String Plugin_Module_Name = Excel_data.get("Plugin_Module_Name");
		String Plugin_Header = Excel_data.get("Plugin_Header");
		String Plugin_Value = Excel_data.get("Plugin_Value");
		String Plugin_condition_Filter = Excel_data.get("Plugin_condition_Filter");
		String Plugin_Status = Excel_data.get("Plugin_Status");
		String Part_BL_Module_Name = Excel_data.get("Part_BL_Module_Name");
		String Excepted_Part_BL_popup = Excel_data.get("Excepted_Part_BL_popup");
		String Global_BL_Search_Header = Excel_data.get("Global_BL_Search_Header");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);
		PartBL_Common_Creation partBL_Data_Creation = new PartBL_Common_Creation();
		Map<String, String> BL_MCN_Numbers = partBL_Data_Creation.Common_PartBL(driver, test, test1, Excel_data);

		String BL_Number = BL_MCN_Numbers.get("BL_Number");

		Step_Start(1, "Set PLTM plugin is false", test, test1);
		setPluginConfig(driver, Plugin_Module_Name, Plugin_Header, Plugin_condition_Filter, Plugin_Value,
				Plugin_Status);

		Step_End(1, "Set PLTM plugin is false", test, test1);

		Step_Start(2, "Open the Part BL module.", test, test1);

		moduleNavigate(driver, Part_BL_Module_Name);

		Step_End(2, "Open the Part BL module.", test, test1);

		Step_Start(3, "Click the \"\"Create\"\" button", test, test1);

		waitForElement(driver, NewButton_ToolBar);
		click(driver, NewButton_ToolBar);

		Step_End(3, "Click the \"\"Create\"\" button", test, test1);

		Step_Start(4, "Use the BL number search to retrieve the data", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Global_BL_Search_Header, BL_Number, "", "", "",
				"");
		Step_End(4, "Use the BL number search to retrieve the data", test, test1);
		Step_Start(5, "Already one MCN is in Pending/Submit Status. Part BL cannot be done\"\" message shown.", test,
				test1);
		waitForPopup(driver, popup_Message, Excepted_Part_BL_popup);
		String Part_Bl_pop_act = getText(driver, popup_Message);
		System.out.println(Part_Bl_pop_act);

		if (Excepted_Part_BL_popup.contains(Part_Bl_pop_act)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + Excepted_Part_BL_popup
					+ " || The Actual Pop-up Value is : " + Part_Bl_pop_act);
			Extent_pass_New(driver, "Matched || The Expected Pop-up Value is : " + Excepted_Part_BL_popup
					+ " || The Actual Pop-up Value is : " + Part_Bl_pop_act, test, test1);
		} else {
			System.out.println("Not Matched || The Expected Pop-up Value is : " + Excepted_Part_BL_popup
					+ " || But The Actual Pop-up Value is : " + Part_Bl_pop_act);
			Extent_fail(driver, "Not Matched || The Expected Pop-up Value is : " + Excepted_Part_BL_popup
					+ " || But The Actual Pop-up Value is : " + Part_Bl_pop_act, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		Step_End(5, "Already one MCN is in Pending/Submit Status. Part BL cannot be done\"\" message shown.", test,
				test1);

		Extent_completed(testCaseName, test, test1);

	}
}
