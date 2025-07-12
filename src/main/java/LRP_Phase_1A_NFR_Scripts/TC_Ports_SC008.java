package LRP_Phase_1A_NFR_Scripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ports_SC008 extends Keywords {

	public void Ports_SC008(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws IOException {

		String testCaseName = "TC_Ports_SC008";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Ports_Module = Excel_data.get("Ports_Module");
		String Port_Loc_Code = Excel_data.get("Port_Loc_Code");
		String Port_Loc_Name = Excel_data.get("Port_Loc_Name");
		String Loc_Type_Dropdown = Excel_data.get("Loc_Type_Dropdown");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Country_Code_Header = Excel_data.get("Country_Code_Header");
		String Country_Code_Field = Excel_data.get("Country_Code_Field");
		String Sector_Code_Header = Excel_data.get("Sector_Code_Header");
		String Sector_Code_Field = Excel_data.get("Sector_Code_Field");
		String TCA_Code_Header = Excel_data.get("TCA_Code_Header");
		String TCA_Code_Field = Excel_data.get("TCA_Code_Field");
		String Latitute_field = Excel_data.get("Latitute_field");
		String Longitute_field = Excel_data.get("Longitute_field");
		String Hemispere_Dropdown_field = Excel_data.get("Hemispere_Dropdown_field");
		String Merdian_Dropdown_field = Excel_data.get("Merdian_Dropdown_field");
		String Region_Code_Header = Excel_data.get("Region_Code_Header");
		String Region_Code_Field = Excel_data.get("Region_Code_Field");
		String Time_Zone_Field = Excel_data.get("Time_Zone_Field");
		String Time_Zone_Header = Excel_data.get("Time_Zone_Header");
		String DatePicker = Excel_data.get("DatePicker");
		String Valid_From_date = Excel_data.get("Valid_From_date");
		String Valid_To_date = Excel_data.get("Valid_To_date");
		String Port_Loc_saved_popup = Excel_data.get("Port_Loc_saved_popup");
		String Sea_Port_Checkbox_Option = Excel_data.get("Sea_Port_Checkbox_Option");
		String Budget_Loc_Checkbox_Option = Excel_data.get("Budget_Loc_Checkbox_Option");
		String AgencyMaster_Module = Excel_data.get("AgencyMaster_Module");
		String Agency_Code = Excel_data.get("Agency_Code");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String GlobalSearch_option = Excel_data.get("GlobalSearch_option");
		String Type_Option = Excel_data.get("Type_Option");
		String Portcode_Header = Excel_data.get("Portcode_Header");
		String Agency_Saved_Popup = Excel_data.get("Agency_Saved_Popup");
		String Global_Loc_Search_Header = Excel_data.get("Global_Loc_Search_Header");

		String Meridian_Dropdown_Select = String.format(Meridian_Dropdown_Sel, Merdian_Dropdown_field);
		String Hemisphere_Dropdown_Select = String.format(Hemisphere_Dropdown_Sel, Hemispere_Dropdown_field);
		String Dropdown_Sel = String.format(Port_Dropdown_Select, Loc_Type_Dropdown);

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login the application..", test, test1);

		LRP_Login(driver, username, pass_word);

		Step_End(1, "Login the application..", test, test1);

		Step_Start(2, " Navigate to Ports Screen.", test, test1);

		verifyMainMenu(driver);

		moduleNavigate(driver, Ports_Module);

		Step_End(2, " Navigate to Ports Screen.", test, test1);

		Step_Start(3, "Create new port without agency code.(Follow steps TS01)", test, test1);

		newButton(driver);

		waitForElement(driver, Ports_Loc_Code_Field);
		sendKeys(driver, Ports_Loc_Code_Field, Port_Loc_Code);

		waitForElement(driver, Port_Loc_Name_Field);
		sendKeys(driver, Port_Loc_Name_Field, Port_Loc_Name);

		waitForElement(driver, Port_Loc_Type_Dropdown);
		click(driver, Port_Loc_Type_Dropdown);

		waitForElement(driver, Dropdown_Sel);
		click(driver, Dropdown_Sel);

		waitForElement(driver, Port_Budget_Checkbox);
		checkBox(driver, Port_Budget_Checkbox, Budget_Loc_Checkbox_Option);

		waitForElement(driver, Sea_Port_Checkbox);
		checkBox(driver, Sea_Port_Checkbox, Sea_Port_Checkbox_Option);

		waitForElement(driver, Country_Search_btn);
		click(driver, Country_Search_btn);

		twoColumnSearchWindow(driver, Country_Code_Header, Search_Condition1, Country_Code_Field);

		waitForElement(driver, Sector_Search_Btn);
		click(driver, Sector_Search_Btn);

		twoColumnSearchWindow(driver, Sector_Code_Header, Search_Condition1, Sector_Code_Field);

		waitForElement(driver, TCA_Search_Btn);
		click(driver, TCA_Search_Btn);

		twoColumnSearchWindow(driver, TCA_Code_Header, Search_Condition1, TCA_Code_Field);

		Step_End(11, "Enter the TCA from the list.", test, test1);

		Step_Start(12, "Enter the Latitude & Longitude.", test, test1);

		waitForElement(driver, Latitute_Text_Field);
		sendKeys(driver, Latitute_Text_Field, Latitute_field);

		waitForElement(driver, Longitute_Text_Field);
		sendKeys(driver, Longitute_Text_Field, Longitute_field);

		waitForElement(driver, Hemisphere_Dropdown);
		click(driver, Hemisphere_Dropdown);

		waitForElement(driver, Hemisphere_Dropdown_Select);
		click(driver, Hemisphere_Dropdown_Select);

		waitForElement(driver, Meridian_Dropdown);
		click(driver, Meridian_Dropdown);

		waitForElement(driver, Meridian_Dropdown_Select);
		click(driver, Meridian_Dropdown_Select);

		waitForElement(driver, Region_Search_btn);
		click(driver, Region_Search_btn);

		twoColumnSearchWindow(driver, Region_Code_Header, Search_Condition1, Region_Code_Field);

		waitForElement(driver, Time_Off_Set_Search_Btn);
		click(driver, Time_Off_Set_Search_Btn);

		twoColumnSearchWindow(driver, Time_Zone_Header, Search_Condition1, Time_Zone_Field);

		if (!Valid_From_date.equals("")) {
			if (DatePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Valid_From_date_field);
				click(driver, Valid_From_date_field);
				selectDatePicker(driver, Valid_From_date);
			} else {
				waitForElement(driver, Valid_From_date_field);
				clearAndType(driver, Valid_From_date_field, Valid_From_date);
			}
		}

		if (!Valid_To_date.equals("")) {
			if (DatePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Valid_To_date_field);
				click(driver, Valid_To_date_field);
				selectDatePicker(driver, Valid_To_date);
			} else {
				waitForElement(driver, Valid_To_date_field);
				clearAndType(driver, Valid_To_date_field, Valid_To_date);
			}
		}

		Step_End(3, "Create new port without agency code.(Follow steps TS01)", test, test1);

		Step_Start(4, "Click on save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Port_Loc_saved_popup);
		String saved_popup = getText(driver, popup_Message);
		System.out.println("saved_popup :" + saved_popup);

		if (Port_Loc_saved_popup.equals(saved_popup)) {
			Extent_pass_New(driver, "Matched || Expected popup value was : " + Port_Loc_saved_popup
					+ " || Actual popup value was is display : " + saved_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Port_Loc_saved_popup
					+ " || Actual popup value was is display: " + saved_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Port_Loc_saved_popup
					+ " || Actual popup value was not display: " + saved_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Port_Loc_saved_popup
					+ " || Actual popup value was not display: " + saved_popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(4, "Click on save button", test, test1);

		Step_Start(5, "Go to Agency Master screen", test, test1);

		moduleNavigate(driver, AgencyMaster_Module);

		Step_End(5, "Go to Agency Master screen", test, test1);

		Step_Start(6, "Navigate controlling ports tab", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, GlobalSearch_Condition, GlobalSearch_option, Agency_Code, "", "", "", "");

		waitForElement(driver, ControllingPorts_Tab);
		click(driver, ControllingPorts_Tab);

		Step_End(6, "Navigate controlling ports tab", test, test1);

		Step_Start(7, "Add new Ports to controlling ports tab(import & export)", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, AM_ValidFrom);
		selectDatePicker(driver, AM_ValidFrom, Valid_From_date);

		waitForElement(driver, AM_ValidTo);
		selectDatePicker(driver, AM_ValidTo, Valid_To_date);

		waitForElement(driver, AM_Type);
		click(driver, AM_Type);

		formatLocatorClick(driver, DropDown_Select, Type_Option);

		waitForElement(driver, AM_AddControllingPorts);
		click(driver, AM_AddControllingPorts);

		twoColumnSearchWindow(driver, Portcode_Header, Search_Condition1, Port_Loc_Code);

		Step_End(7, "Add new Ports to controlling ports tab(import & export)", test, test1);

		Step_Start(8, "Click on save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Agency_Saved_Popup);
		String Act_saved_popup = getText(driver, popup_Message);
		System.out.println("saved_popup :" + saved_popup);

		if (Agency_Saved_Popup.equals(Act_saved_popup)) {
			Extent_pass_New(driver, "Matched || Expected popup value was : " + Agency_Saved_Popup
					+ " || Actual popup value was is display : " + Act_saved_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Agency_Saved_Popup
					+ " || Actual popup value was is display: " + Act_saved_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Agency_Saved_Popup
					+ " || Actual popup value was not display: " + Act_saved_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Agency_Saved_Popup
					+ " || Actual popup value was not display: " + Act_saved_popup, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(8, "Click on save button", test, test1);

		Step_Start(9, "Now Open ports screen", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(9, "Now Open ports screen", test, test1);

		Step_Start(10, "Retrieve the port code from ports screen", test, test1);

		Step_Start(11, "To verify the result whether agency code is showing to ports screen", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition1, Global_Loc_Search_Header, Port_Loc_Code, "", "", "", "");

		waitForElement(driver, Ports_Agency_text_Field);
		
		String agencyName = getAttribute(driver, Ports_Agency_text_Field, "value");

		if (agencyName.equals(Agency_Code)) {

			System.out.println("Expected result : The selected agency code : " + Agency_Code
					+ " should be updated in the ports screen || Actual result : The selected agency code : "
					+ Agency_Code + " was updated in the ports screen");
			Extent_pass_New(driver,
					"Expected result : The selected agency code : " + Agency_Code
							+ " should be updated in the ports screen || Actual result : The selected agency code : "
							+ Agency_Code + " was updated in the ports screen",
					test, test1);

		} else {

			System.out.println("Expected result : The selected agency code : " + Agency_Code
					+ " should be updated in the ports screen || Actual result : The selected agency code : "
					+ Agency_Code + " was not updated in the ports screen");
			Extent_fail(driver,
					"Expected result : The selected agency code : " + Agency_Code
							+ " should be updated in the ports screen || Actual result : The selected agency code : "
							+ Agency_Code + " was not updated in the ports screen",
					test, test1);

		}

		Step_End(11, "To verify the result whether agency code is showing to ports screen", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
