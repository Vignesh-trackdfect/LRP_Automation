package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC08 extends Keywords {
	public void EDI_Code_Mapping_SC08(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC08";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID = Excel_data.get("EDI_ID");
		String Size_Type_value = Excel_data.get("Size_Type");
		String EDI_Eqp_Type = Excel_data.get("EDI_Eqp_Type_Input");
		String EDI_Code_Saved_Popup = Excel_data.get("EDI_Code_Saved_Popup");
		String Colour_Code = Excel_data.get("Colour_Code");
		String Dropdown_status = Excel_data.get("Dropdown_status");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Click the ISO tab", test, test1);

		waitForElement(driver, Click_ISO_Tab);
		click(driver, Click_ISO_Tab);

		Step_End(1, "Click the ISO tab", test, test1);
		Step_Start(2, "Select the partner id ", test, test1);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		Step_End(2, "Select the partner id ", test, test1);

		Step_Start(3, "Select the EDI ID ", test, test1);

		waitForElement(driver, EDI_ID_Search);
		click(driver, EDI_ID_Search);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID);
		Step_End(3, "Select the EDI ID ", test, test1);

		Step_Start(4, "Select the show button ", test, test1);

		waitForElement(driver, EDI_Code_Show_Btn_ECM);
		click(driver, EDI_Code_Show_Btn_ECM);

		Step_End(4, "Select the show button ", test, test1);

		Step_Start(5, "Double click the data in AG grid which data to inactive ", test, test1);

		waitForElement(driver, Filter_btn_ISO_ECM);
		click(driver, Filter_btn_ISO_ECM);

		waitForElement(driver, Liner_Eqp_Type_Field_ECM);
		safeclick(driver, Liner_Eqp_Type_Field_ECM);
		sendKeys(driver, Liner_Eqp_Type_Field_ECM, Size_Type_value);

		waitForElement(driver, EDI_eqp_Type_field_ECM);
		safeclick(driver, EDI_eqp_Type_field_ECM);
		sendKeys(driver, EDI_eqp_Type_field_ECM, EDI_Eqp_Type);

		formatLocatorDoubleClick(driver, Double_click_Liner_Eqp_Type_ECM, Size_Type_value);

		Step_End(5, "Double click the data in AG grid which data to inactive", test, test1);

		Step_Start(6, "Click Edit button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(6, "Click Edit button", test, test1);

		Step_Start(7, "Change the status as Inactive", test, test1);

		waitForElement(driver, Status_btn_Click_ECM);
		click(driver, Status_btn_Click_ECM);

		formatLocatorClick(driver, DropDown_Select, Dropdown_status);

		Step_End(7, "Change the status as Inactive", test, test1);

		Step_Start(8, "Click the save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, EDI_Code_Saved_Popup);
		String Applied_Popup = getText(driver, Popup_Message);
		System.out.println(Applied_Popup);
		if (EDI_Code_Saved_Popup.equals(Applied_Popup)) {
			System.out.println("Matched || " + " Expected saved popup : " + EDI_Code_Saved_Popup
					+ " || Actual saved popup : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + EDI_Code_Saved_Popup
					+ " || Actual saved popup : " + Applied_Popup, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + EDI_Code_Saved_Popup
					+ " || Actual saved poup : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved poup : " + EDI_Code_Saved_Popup
					+ " || Actual saved poup : " + Applied_Popup, test, test1);

		}

		String Inactive_colour_code = getTextBackgroundColor(driver, Select_Filter_First_Row_ECM);
		String Inactive_colour = getColorName(Inactive_colour_code);
		System.out.println(Inactive_colour);

		if (Colour_Code.equals(Inactive_colour)) {
			System.out.println(
					"Matched || Expected Status is : Inactive and the colour code is : " + Inactive_colour
							+ " || Actual Status is : Inactive and the colour code is : " + Inactive_colour);
			Extent_pass_New(driver,
					"Matched || Expected Status is : Inactive and the colour code is : " + Inactive_colour
							+ " || Actual Status is : Inactive and the colour code is : " + Inactive_colour,
					test, test1);

		} else {
			System.out.println(
					"Not Matched || Expected Status is : Inactive and the colour code is : " + Inactive_colour
							+ " || Actual Status is : Inactive and the colour code is : " + Inactive_colour);
			Extent_fail(driver,
					"Not Matched || Expected Status is : Inactive and the colour code is : " + Inactive_colour
							+ " || Actual Status is : Inactive and the colour code is : " + Inactive_colour,
					test, test1);

		}

		Step_End(8, "Click the save button", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
