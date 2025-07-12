package LRP_EDI_EndPoint_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Endpoint_Configuration_TS06 extends Keywords {

	public void Endpoint_Configuration_TS06(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Endpoint_Configuration_TS06";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Partner_Id = Excel_data.get("Partner_Id");
		String ProfileName = Excel_data.get("ProfileName");
		String DeleteOption = Excel_data.get("DeleteOption");
		String Deleted_Popup = Excel_data.get("Deleted_Popup");
		String Deleted_Color = Excel_data.get("Deleted_Color");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Click the FTP tab", test, test1);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Click the FTP tab", test, test1);

		Step_Start(2, "dobule click any one of the record from the AG gird", test, test1);

		waitForElement(driver, EC_ConditionFilter);
		click(driver, EC_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, Partner_Id);

		waitForElement(driver, EC_ProfileName_Filter);
		sendKeys(driver, EC_ProfileName_Filter, ProfileName);

		if (DeleteOption.equals("Delete")) {

			waitForElement(driver, FTP_GridRow1);
			doubleClick(driver, FTP_GridRow1);

			waitForElement(driver, Delete_button_toolBar);
			click(driver, Delete_button_toolBar);

		} else {

			waitForElement(driver, FTP_GridRow1);
			click(driver, FTP_GridRow1);
			RightClick(driver, FTP_GridRow1);

			waitForElement(driver, EC_RemoveButton);
			click(driver, EC_RemoveButton);
		}

		Step_End(2, "dobule click any one of the record from the AG gird", test, test1);

		Step_Start(3,
				"Click the delete button and popup should show like 'EDI Transmission profiler deleted successfully'",
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

		Step_End(3,
				"Click the delete button and popup should show like 'EDI Transmission profiler deleted successfully'",
				test, test1);

		Step_Start(4, "verify that colour of the deleted record", test, test1);

		waitForElement(driver, EC_ConditionFilter);
		click(driver, EC_ConditionFilter);

		waitForElement(driver, EC_PartnerID_Filter);
		sendKeys(driver, EC_PartnerID_Filter, Partner_Id);

		waitForElement(driver, EC_ProfileName_Filter);
		sendKeys(driver, EC_ProfileName_Filter, ProfileName);

		waitForElement(driver, FTP_GridRow1);
		String colorcode = getTextBackgroundColor(driver, FTP_GridRow1);

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

		Step_End(4, "verify that colour of the deleted record", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
