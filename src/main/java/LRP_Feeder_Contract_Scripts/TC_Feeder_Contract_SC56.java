package LRP_Feeder_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC56 extends Keywords {

	public void Feeder_Contract_SC56(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC56";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String ModuleName = Excel_data.get("ModuleName");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Feeder_Contract_No = Excel_data.get("Feeder_Contract_No");
		String POL_Header = Excel_data.get("POL_Header");
		String POD_Header = Excel_data.get("POD_Header");
		String Load_terminal_Header = Excel_data.get("Load_terminal_Header");
		String Discharge_terminal_Header = Excel_data.get("Discharge_terminal_Header");
		String Load_Term_Header = Excel_data.get("Load_Term_Header");
		String Discharge_Term_Header = Excel_data.get("Discharge_Term_Header");
		String Fields_Currency_Header = Excel_data.get("Fields_Currency_Header");
		String Fields_Service_Header = Excel_data.get("Fields_Service_Header");
		String Edit_POLValue = Excel_data.get("Edit_POLValue");
		String POL_value = Excel_data.get("POL_value");
		String POD_value = Excel_data.get("POD_value");
		String Load_terminal = Excel_data.get("Load_terminal");
		String Discharge_terminal = Excel_data.get("Discharge_terminal");
		String Load_Term = Excel_data.get("Load_Term");
		String Discharge_Term = Excel_data.get("Discharge_Term");
		String Equipment = Excel_data.get("Equipment");
		String Eqp_status = Excel_data.get("Eqp_status");
		String Fields_Service = Excel_data.get("Fields_Service");
		String Fields_Currency = Excel_data.get("Fields_Currency");
		String Negotiated_on = Excel_data.get("Negotiated_on");
		String Negotiated_by = Excel_data.get("Negotiated_by");
		String Valid_From = Excel_data.get("Valid_From");
		String Duration_Type = Excel_data.get("Duration_Type");
		String Saved_popup = Excel_data.get("Saved_popup");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		moduleNavigate(driver, ModuleName);

		Step_End(1, "Enter the  screen name as 'Feeder contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the global search and select the Existing record ", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Search_Condition, Select_field, Feeder_Contract_No, "", "", "", "");

		Step_End(2, "Click on the global search and select the Existing record ", test, test1);

		Step_Start(3, "Click the Edit button ", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		String Feeder_Contract = String.format(FC_Columan_grid_select, Edit_POLValue);
		waitForElement(driver, Feeder_Contract);
		click(driver, Feeder_Contract);

		waitForElement(driver, FC_Edit_Input_Fields);
		click(driver, FC_Edit_Input_Fields);

		Step_End(3, "Click the Edit button ", test, test1);

		Step_Start(4, "Click on the POL and select the Location or else double click the POL  and edit the field ",
				test, test1);

		waitForElement(driver, FC_Edit_Input_Fields_POL);
		click(driver, FC_Edit_Input_Fields_POL);

		twoColumnSearchWindow(driver, POL_Header, Search_Condition, POL_value);

		Step_End(4, "Click on the POL and select the Location or else double click the POL  and edit the field ", test,
				test1);

		Step_Start(5,
				"Click on the POD and select the Location or else double click the POD in grid and edit the field ",
				test, test1);

		waitForElement(driver, FC_Edit_Input_Fields_POD);
		click(driver, FC_Edit_Input_Fields_POD);

		twoColumnSearchWindow(driver, POD_Header, Search_Condition, POD_value);

		Step_End(5, "Click on the POD and select the Location or else double click the POD in grid and edit the field",
				test, test1);

		Step_Start(6,
				"Click on the Load terminal and select the Location or else Double click the field in grid and edit the field.",
				test, test1);

		waitForElement(driver, FC_Edit_Input_Fields_lo_ter);
		click(driver, FC_Edit_Input_Fields_lo_ter);

		twoColumnSearchWindow(driver, Load_terminal_Header, Search_Condition, Load_terminal);

		Step_End(6,
				"Click on the Load terminal and select the Location or else Double click the field in grid and edit the field.",
				test, test1);

		Step_Start(7,
				"Click on the Discharge terminal and select the Location or else Double click the field in grid and edit the field",
				test, test1);

		waitForElement(driver, FC_Edit_Input_Fields_Discharge_Terminal);
		click(driver, FC_Edit_Input_Fields_Discharge_Terminal);

		twoColumnSearchWindow(driver, Discharge_terminal_Header, Search_Condition, Discharge_terminal);

		Step_End(7,
				"Click on the Discharge terminal and select the Location or else Double click the field in grid and edit the field",
				test, test1);

		Step_Start(8,
				"Click on the Load term and select the value or else Double click the field in grid and edit the field.",
				test, test1);

		waitForElement(driver, FC_Edit_Input_Fields_Load_Term);
		click(driver, FC_Edit_Input_Fields_Load_Term);

		twoColumnSearchWindow(driver, Load_Term_Header, Search_Condition, Load_Term);

		Step_End(8,
				"Click on the Load term and select the value or else Double click the field in grid and edit the field.",
				test, test1);

		Step_Start(9,
				"Click on the Discharge term and select the value or else Double click the field in grid and edit the field.",
				test, test1);

		waitForElement(driver, FC_Edit_Input_Fields_Discharge_Term);
		click(driver, FC_Edit_Input_Fields_Discharge_Term);

		twoColumnSearchWindow(driver, Discharge_Term_Header, Search_Condition, Discharge_Term);

		Step_End(9,
				"Click on the Discharge term and select the value or else Double click the field in grid and edit the field.",
				test, test1);

		Step_Start(10,
				"Click on the equipment and select the type or else Double click the Equipment field in grid and Edit the field",
				test, test1);

		if (!Equipment.trim().equals("")) {
			waitForElement(driver, FC_Edit_Input_Fields_Equipment);
			click(driver, FC_Edit_Input_Fields_Equipment);
			formatLocatorClick(driver, DropDown_Select, Equipment);

		}

		Step_End(10,
				"Click on the equipment and select the type or else Double click the Equipment field in grid and Edit the field",
				test, test1);

		Step_Start(11,
				"Click on the Eqp status and select the status or else Double click the Eqp status in grid and edit the Field",
				test, test1);

		if (!Eqp_status.trim().equals("")) {
			waitForElement(driver, FC_Edit_Input_Fields_Eqp_Status);
			click(driver, FC_Edit_Input_Fields_Eqp_Status);
			formatLocatorClick(driver, DropDown_Select, Eqp_status);

		}

		Step_End(11,
				"Click on the Eqp status and select the status or else Double click the Eqp status in grid and edit the Field",
				test, test1);

		Step_Start(12,
				"Click on the Currency and select the currency or else Double click the Currency in grid and edit the field.",
				test, test1);

		waitForElement(driver, FC_Edit_Input_Fields_Currency);
		click(driver, FC_Edit_Input_Fields_Currency);

		twoColumnSearchWindow(driver, Fields_Currency_Header, Search_Condition, Fields_Currency);

		Step_End(12,
				"Click on the Currency and select the currency or else Double click the Currency in grid and edit the field.",
				test, test1);

		Step_Start(13,
				"Click on the Service and select the service or else Double click the Service in grid and Edit the field.",
				test, test1);

		waitForElement(driver, FC_Edit_Input_Fields_Service);
		click(driver, FC_Edit_Input_Fields_Service);

		twoColumnSearchWindow(driver, Fields_Service_Header, Search_Condition, Fields_Service);

		Step_End(13,
				"Click on the Service and select the service or else Double click the Service in grid and Edit the field.",
				test, test1);

		Step_Start(14,
				"Click on negotiated on field and select the date or else Double click the field in grid and change the date",
				test, test1);

		waitForElement(driver, FC_Edit_Input_Fields_Negotiated_on);
		selectDatePicker(driver, FC_Edit_Input_Fields_Negotiated_on, Negotiated_on);

		Step_End(14,
				"Click on negotiated on field and select the date or else Double click the field in grid and change the date",
				test, test1);

		Step_Start(15,
				"Click on Negotiated by and select the value or else Double click the field in grid and edit the field",
				test, test1);

		if (!Negotiated_by.trim().equals("")) {
			waitForElement(driver, FC_Edit_Input_Fields_Negotiated_By);
			click(driver, FC_Edit_Input_Fields_Negotiated_By);
			formatLocatorClick(driver, DropDown_Select, Negotiated_by);

		}

		Step_End(15,
				"Click on Negotiated by and select the value or else Double click the field in grid and edit the field",
				test, test1);

		Step_Start(16, "Click on the valid from and valid to date and able to change the date.", test, test1);

		waitForElement(driver, FC_Edit_Input_Fields_Valid_From);
		selectDatePicker(driver, FC_Edit_Input_Fields_Valid_From, Valid_From);

		Step_End(16, "Click on the valid from and valid to date and able to change the date.", test, test1);

		Step_Start(17,
				"Click on the Duration type and selct the duration or else double the field in grid and Edit the field.",
				test, test1);

		if (!Duration_Type.trim().equals("")) {
			waitForElement(driver, FC_Edit_Input_Fields_Duration_Type);
			click(driver, FC_Edit_Input_Fields_Duration_Type);
			formatLocatorClick(driver, DropDown_Select, Duration_Type);

		}

		Step_End(17,
				"Click on the Duration type and selct the duration or else double the field in grid and Edit the field.",
				test, test1);

		Step_Start(24, "Click on the Save button in Tool bar ,It shows \"Feeder Contract Updated", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Saved_popup);
		String verified_popup = getText(driver, popup_Message);

		if (verified_popup.equals(Saved_popup)) {
			Extent_pass(driver,
					"Matched || Expected value is : After click on save  button the popup  message should be : "
							+ Saved_popup + " || Actual value is : After click on save  button the popup  message is : "
							+ verified_popup,
					test, test1);

			System.out.println(
					"Matched || Expected value is : After click on save  button the popup  message should be : "
							+ Saved_popup + " || Actual value is : After click on save  button the popup  message is : "
							+ verified_popup);
		} else {
			System.out.println(
					"Not Matched || Expected value is : After click on save  button the popup  message should be : "
							+ Saved_popup
							+ " || Actual value is : After click on save  button the popup  message is not display :"
							+ verified_popup);
			Extent_fail(driver,
					"Not Matched || Expected value is : After click on save  button the popup  message should be : "
							+ Saved_popup
							+ " || Actual value is : After click on save  button the popup  message is not display : "
							+ verified_popup,
					test, test1);

		}

		waitForDisplay(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(24,
				"Click on Negotiated by and select the value or else Double click the field in grid and edit the field",
				test, test1);

	}
}
