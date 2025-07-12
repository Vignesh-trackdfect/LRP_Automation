package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS09 extends Keywords {

	public void Endpoint_Configuration_TS09(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS09";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String SharePath_TabName = Excel_data.get("SharePath_TabName");
		String PartnerId = Excel_data.get("PartnerId");
		String ProfileId = Excel_data.get("ProfileId");
		String Select_Status = Excel_data.get("Select_Status");
		String Saved_Popup = Excel_data.get("Saved_Popup");
		String Inactive_Color = Excel_data.get("Inactive_Color");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the share path tab ", test, test1);

		moduleNavigate(driver, ModuleName);

		formatLocatorClick(driver, EC_TabName, SharePath_TabName);

		Step_End(1, "Click the share path tab ", test, test1);

		Step_Start(2, "dobule click any one of the record from the AG gird ", test, test1);

		waitForElement(driver, SP_ConditionFilter);
		click(driver, SP_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, PartnerId);

		waitForElement(driver, SP_ProfileName_Filter);
		sendKeys(driver, SP_ProfileName_Filter, ProfileId);

		waitForElement(driver, SP_GridRow1);
		doubleClick(driver, SP_GridRow1);

		Step_End(2, "dobule click any one of the record from the AG gird ", test, test1);

		Step_Start(3, "Click the edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(3, "Click the edit button", test, test1);

		Step_Start(4, "Change the Status as Inactive", test, test1);

		waitForElement(driver, SP_StatusDrodown);
		click(driver, SP_StatusDrodown);

		formatLocatorClick(driver, DropDown_Select, Select_Status);

		Step_End(4, "Change the Status as Inactive", test, test1);

		Step_Start(5,
				"Click the save button now the popup should show like EDI Transmission profiler details updated and edited record colour should be changed",
				test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Saved_Popup);

		String Actsaved_popup = getText(driver, Popup_Message);

		if (Saved_Popup.equals(Actsaved_popup)) {

			System.out.println("Matched || Expected popup message was : " + Saved_Popup
					+ " || Actual popup message was : " + Actsaved_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Saved_Popup
					+ " || Actual popup message was : " + Actsaved_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Saved_Popup
					+ " || Actual popup message was : " + Actsaved_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Saved_Popup
					+ " || Actual popup message was : " + Actsaved_popup, test, test1);

		}

		waitForElement(driver, SP_ConditionFilter);
		click(driver, SP_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, PartnerId);

		waitForElement(driver, SP_ProfileName_Filter);
		sendKeys(driver, SP_ProfileName_Filter, ProfileId);

		waitForElement(driver, SP_GridRow1);
		String colorcode = getTextBackgroundColor(driver, SP_GridRow1);

		String colorname = getColorName(colorcode);

		if (Inactive_Color.equals(colorname)) {

			System.out
					.println("After inactive the given data, the row color was changed as expected || Expected color : "
							+ Inactive_Color + " || Actual color : " + colorname);
			Extent_pass_New(driver,
					"After inactive the given data, the row color was changed as expected || Expected color : "
							+ Inactive_Color + " || Actual color : " + colorname,
					test, test1);
		} else {

			System.out.println(
					"After inactive the given data, the row color was not changed as expected || Expected color : "
							+ Inactive_Color + " || Actual color : " + colorname);
			Extent_fail(driver,
					"After inactive the given data, the row color was not changed as expected || Expected color : "
							+ Inactive_Color + " || Actual color : " + colorname,
					test, test1);
		}

		Step_End(5,
				"Click the save button now the popup should show like EDI Transmission profiler details updated and edited record colour should be changed",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
