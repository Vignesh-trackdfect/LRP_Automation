package LRP_PartBL_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC022 extends Keywords {

	public void PartBL_TC022(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String test_Case_Name = "TC_PartBL_TC022";
//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String GlobalSearchDropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String PartBL_SearchOption = Excel_data.get("PartBL_SearchOption");
		String Actual_Container_Popup = Excel_data.get("Actual_Container_Popup");

		navigateUrl(driver, url);
		Extent_Start(test_Case_Name, test, test1);
// Login
		LRP_Login(driver, Username, Password);

//	Switch the Profile
		SwitchProfile(driver, Agency_Name);

		Step_Start(1, "Use step 1- 63 and continue.", test, test1);

		PartBL_Common_Creation partBL_Data_Creation = new PartBL_Common_Creation();
		Map<String, String> BL_MCN_Numbers = partBL_Data_Creation.Common_PartBL(driver, test, test1, Excel_data);

		String Bl_Number = BL_MCN_Numbers.get("BL_Number");
		System.out.println("BL_Number:" + Bl_Number);

		Step_End(1, "Use step 1- 63 and continue.", test, test1);
		Step_Start(2, "Open Part BL module.", test, test1);

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(2, "Open Part BL module.", test, test1);

		Step_Start(3, "Click create icon.", test, test1);

		newButton(driver);

		Step_End(3, "Click create icon.", test, test1);
		Step_Start(4, "Search the BL number.", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, PartBL_SearchOption, Bl_Number, "", "", "", "");

		Step_End(4, "Search the BL number.", test, test1);
		Step_Start(5, "\"Update actual container in master bl and proceed part BL\" message shown.", test, test1);

		waitForPopup(driver, popup_Message, Actual_Container_Popup);

		String actual_Popup = getText(driver, popup_Message);

		if (actual_Popup.equals(Actual_Container_Popup)) {

			System.out.println(
					"Matched || Expected popup  : " + Actual_Container_Popup + " || Actual popup  : " + actual_Popup);
			Extent_pass_New(driver,
					"Matched || Expected popup  : " + Actual_Container_Popup + " || Actual popup  : " + actual_Popup,
					test, test1);

		} else {

			System.out.println("Not Matched || Expected popup  : " + Actual_Container_Popup + " || Actual popup  : "
					+ actual_Popup);
			Extent_fail(driver, "Not Matched || Expected popup  : " + Actual_Container_Popup + " || Actual popup  : "
					+ actual_Popup, test, test1);

		}

		Step_End(5, "\"Update actual container in master bl and proceed part BL\" message shown.", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Extent_completed(test_Case_Name, test, test1);

	}

}
