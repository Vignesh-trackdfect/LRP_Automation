package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC04 extends Keywords {
	public void EDI_Code_Mapping_SC04(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC04";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID_Input = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_Value = Excel_data.get("EDI_ID_Value");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_Port_Code_Value = Excel_data.get("EDI_Port_Code_Value");
		String Status_value = Excel_data.get("Status_value");
		String EDI_Code_Saved_Popup = Excel_data.get("EDI_Code_Saved_Popup");
		String Colour_Code = Excel_data.get("Colour_Code");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		moduleNavigate(driver, moduleName);

		Step_Start(1, "Click the port tab", test, test1);
		waitForElement(driver, Port_Tab_ECM);
		click(driver, Port_Tab_ECM);
		Step_End(1, "Click the port tab", test, test1);

		Step_Start(2, "Select the partner id", test, test1);
		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);
		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID_Input);
		Step_End(2, "Select the partner id", test, test1);

		Step_Start(3, "Select the EDI ID", test, test1);
		waitForElement(driver, EDI_ID_Search);
		click(driver, EDI_ID_Search);
		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID_Value);
		Step_End(3, "Select the EDI ID", test, test1);

		Step_Start(4, "Click the show button", test, test1);

		waitForElement(driver, EDI_Code_Show_Btn);
		click(driver, EDI_Code_Show_Btn);
		Step_End(4, "Click the show button", test, test1);

		Step_Start(5, "Double click the record", test, test1);
		waitForElement(driver, Filter_btn_Port);
		click(driver, Filter_btn_Port);

		waitForElement(driver, EDI_Port_Code_Filter_Input);
		safeclick(driver, EDI_Port_Code_Filter_Input);
		sendKeys(driver, EDI_Port_Code_Filter_Input, EDI_Port_Code_Value);

		waitForElement(driver, Port_firstrow_ECM);
		doubleClick(driver, Port_firstrow_ECM);

		Step_End(5, "Double click the record", test, test1);

		Step_Start(6, "Click on edit button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(6, "Click on edit button", test, test1);

		Step_Start(7, "Change the status as (IN-active)", test, test1);
		waitForElement(driver, Port_Status_dropdown_ECM);
		click(driver, Port_Status_dropdown_ECM);
		formatLocatorClick(driver, DropDown_Select, Status_value);
		Step_End(7, "Change the status as (IN-active)", test, test1);

		Step_Start(8, "Click the save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(8, "Click save button ", test, test1);

		Step_Start(9, "Now Edi Code Mapping Details Updated popup as been show and datas colour as been changed", test,
				test1);

		waitForPopup(driver, Popup_Message, EDI_Code_Saved_Popup);
		String Applied_Popup = getText(driver, Popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(EDI_Code_Saved_Popup)) {
			System.out.println("Matched || " + " Expected saved poup : " + EDI_Code_Saved_Popup
					+ " || Actual saved popup : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + EDI_Code_Saved_Popup
					+ " || Actual saved popup is : " + Applied_Popup, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + EDI_Code_Saved_Popup
					+ " || Actual saved popup : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved popup: " + EDI_Code_Saved_Popup
					+ " || Actual saved popup is : " + Applied_Popup, test, test1);

		}

		waitForElement(driver, Filter_btn_Port);
		click(driver, Filter_btn_Port);

		waitForElement(driver, EDI_Port_Code_Filter_Input);
		safeclick(driver, EDI_Port_Code_Filter_Input);
		sendKeys(driver, EDI_Port_Code_Filter_Input, EDI_Port_Code_Value);

		if (isdisplayed(driver, Port_firstrow_ECM)) {

			System.out.println("Expected result : The given EDI Port Code value : " + EDI_Port_Code_Value
					+ " should be added in the grid || Actual result :The given EDI Port Code value : "
					+ EDI_Port_Code_Value + " was added in the grid");
			Extent_pass_New(driver,
					"Expected result : The given EDI Port Code value : " + EDI_Port_Code_Value
							+ " should be added in the grid || Actual result :The given EDI Port Code value : "
							+ EDI_Port_Code_Value + " was added in the grid",
					test, test1);

		} else {

			System.out.println("Expected result : The given EDI Port Code value : " + EDI_Port_Code_Value
					+ " should be added in the grid || Actual result :The given EDI Port Code value : "
					+ EDI_Port_Code_Value + " was not added in the grid");
			Extent_fail(driver,
					"Expected result : The given EDI Port Code value : " + EDI_Port_Code_Value
							+ " should be added in the grid || Actual result :The given EDI Port Code value : "
							+ EDI_Port_Code_Value + " was not added in the grid",
					test, test1);

		}

		String Inactive_colour_code = getTextBackgroundColor(driver, Port_firstrow_ECM);
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

		Step_End(9, "Now Edi Code Mapping Details Updated popup as been show and datas colour as been changed", test,
				test1);

		Extent_completed(testCaseName, test, test1);

	}
}
