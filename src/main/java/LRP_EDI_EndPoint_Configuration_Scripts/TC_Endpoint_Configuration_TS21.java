package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS21 extends Keywords {

	public void Endpoint_Configuration_TS21(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS21";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String WebService_TabName = Excel_data.get("WebService_TabName");
		String PartnerId = Excel_data.get("PartnerId");
		String ProfileID = Excel_data.get("ProfileID");
		String Attribute = Excel_data.get("Attribute");
		String Value = Excel_data.get("Value");
		String DeleteOption = Excel_data.get("DeleteOption");
		String Deleted_Popup = Excel_data.get("Deleted_Popup");
		String Deleted_Color = Excel_data.get("Deleted_Color");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the Web service tab", test, test1);

		moduleNavigate(driver, ModuleName);

		formatLocatorClick(driver, EC_TabName, WebService_TabName);

		Step_End(1, "Click the Web service tab", test, test1);

		Step_Start(2, "dobule click any one of the record from the AG gird", test, test1);

		waitForElement(driver, WS_ConditionFilter);
		click(driver, WS_ConditionFilter);

		if (!PartnerId.isEmpty()) {

			waitForElement(driver, EC_PartnerID_Filter);
			sendKeys(driver, EC_PartnerID_Filter, PartnerId);

		}

		if (!ProfileID.isEmpty()) {

			waitForElement(driver, WS_ProfileID_Filter);
			sendKeys(driver, WS_ProfileID_Filter, ProfileID);

		}

		if (!Attribute.isEmpty()) {

			waitForElement(driver, WS_Attribute_Filter);
			sendKeys(driver, WS_Attribute_Filter, Attribute);

		}

		if (!Value.isEmpty()) {

			waitForElement(driver, WS_Value_Filter);
			sendKeys(driver, WS_Value_Filter, Value);

		}

		Step_End(2, "dobule click any one of the record from the AG gird", test, test1);

		Step_Start(3, "Click the delete button", test, test1);

		if (DeleteOption.equals("Delete")) {

			waitForElement(driver, WS_Row1);
			doubleClick(driver, WS_Row1);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

		} else {

			waitForElement(driver, WS_Row1);
			click(driver, WS_Row1);
			RightClick(driver, WS_Row1);

			waitForElement(driver, EC_RemoveButton);
			click(driver, EC_RemoveButton);
		}

		Step_End(3, "Click the delete button", test, test1);

		Step_Start(4,
				"The record as been inactive status and popup should show like EDI Transmission profiler deleted successfully ",
				test, test1);

		waitForPopup(driver, Popup_Message, Deleted_Popup);

		String ActDeleted_popup = getText(driver, Popup_Message);

		if (Deleted_Popup.equals(ActDeleted_popup)) {

			System.out.println("Matched || Expected popup message was : " + Deleted_Popup
					+ " || Actual popup message was : " + ActDeleted_popup);
			Extent_pass_New(driver, "Matched || Expected popup message was : " + Deleted_Popup
					+ " || Actual popup message was : " + ActDeleted_popup, test, test1);

		} else {

			System.out.println("Not Matched || Expected popup message was : " + Deleted_Popup
					+ " || Actual popup message was : " + ActDeleted_popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Deleted_Popup
					+ " || Actual popup message was : " + ActDeleted_popup, test, test1);

		}

		waitForElement(driver, WS_ConditionFilter);
		click(driver, WS_ConditionFilter);

		if (!PartnerId.isEmpty()) {

			waitForElement(driver, EC_PartnerID_Filter);
			sendKeys(driver, EC_PartnerID_Filter, PartnerId);

		}

		if (!ProfileID.isEmpty()) {

			waitForElement(driver, WS_ProfileID_Filter);
			sendKeys(driver, WS_ProfileID_Filter, ProfileID);

		}

		if (!Attribute.isEmpty()) {

			waitForElement(driver, WS_Attribute_Filter);
			sendKeys(driver, WS_Attribute_Filter, Attribute);

		}

		if (!Value.isEmpty()) {

			waitForElement(driver, WS_Value_Filter);
			sendKeys(driver, WS_Value_Filter, Value);

		}

		waitForElement(driver, WS_Row1);
		String colorcode = getTextBackgroundColor(driver, WS_Row1);

		String colorname = getColorName(colorcode);

		if (Deleted_Color.equals(colorname)) {

			System.out.println("After Delete the given data, the row color was changed as expected || Expected color : "
					+ Deleted_Color + " || Actual color : " + colorname);
			Extent_pass_New(driver,
					"After Delete the given data, the row color was changed as expected || Expected color : "
							+ Deleted_Color + " || Actual color : " + colorname,
					test, test1);
		} else {

			System.out.println(
					"After Delete the given data, the row color was not changed as expected || Expected color : "
							+ Deleted_Color + " || Actual color : " + colorname);
			Extent_fail(driver,
					"After Delete the given data, the row color was not changed as expected || Expected color : "
							+ Deleted_Color + " || Actual color : " + colorname,
					test, test1);
		}

		Step_Start(4,
				"The record as been inactive status and popup should show like EDI Transmission profiler deleted successfully ",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
