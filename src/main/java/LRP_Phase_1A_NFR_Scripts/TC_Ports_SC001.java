package LRP_Phase_1A_NFR_Scripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ports_SC001 extends Keywords {

	public void Ports_SC001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws IOException {

		String testCaseName = "TC_Ports_SC001";

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
		String Global_Loc_Search_Header = Excel_data.get("Global_Loc_Search_Header");
		String Sea_Port_Checkbox_Option = Excel_data.get("Sea_Port_Checkbox_Option");
		String Budget_Loc_Checkbox_Option = Excel_data.get("Budget_Loc_Checkbox_Option");

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

		Step_Start(3, ".Click on New button, system will pop-up like Do you want create the new location Click yes.",
				test, test1);

		newButton(driver);

		Step_End(3, ".Click on New button, system will pop-up like Do you want create the new location Click yes.",
				test, test1);

		Step_Start(4, "Enter the Location Code.", test, test1);

		waitForElement(driver, Ports_Loc_Code_Field);
		clear(driver,Ports_Loc_Code_Field);
		sendKeys(driver, Ports_Loc_Code_Field, Port_Loc_Code);

		Step_End(4, "Enter the Location Code", test, test1);

		Step_Start(5, "Enter the Location Name.", test, test1);

		waitForElement(driver, Port_Loc_Name_Field);
		clear(driver,Port_Loc_Name_Field);
		sendKeys(driver, Port_Loc_Name_Field, Port_Loc_Name);

		Step_End(5, "Enter the Location Name.", test, test1);

		Step_Start(6, "Enter the Location Type.", test, test1);

		waitForElement(driver, Port_Loc_Type_Dropdown);
		click(driver, Port_Loc_Type_Dropdown);

		waitForElement(driver, Dropdown_Sel);
		click(driver, Dropdown_Sel);

		Step_End(6, "Enter the Location Type.", test, test1);

		Step_Start(7, "Enter the budget Location or select same as check box.", test, test1);
		
		Step_Start(8, "Enter the seaports or it will choose automatically.", test, test1);

		 checkBox(driver, Port_Budget_Checkbox, Budget_Loc_Checkbox_Option);
		 
		 checkBox(driver, Sea_Port_Checkbox, Sea_Port_Checkbox_Option);
		
		Step_End(7, "Enter the budget Location or select same as check box.", test, test1);

		Step_End(8, "Enter the seaports or it will choose automatically.", test, test1);

		Step_Start(9, ".Enter the country.", test, test1);

		waitForElement(driver, Country_Search_btn);
		click(driver, Country_Search_btn);

		twoColumnSearchWindow(driver, Country_Code_Header, Search_Condition1, Country_Code_Field);

		Step_End(9, ".Enter the country.", test, test1);

		Step_Start(10, "Enter the Sector from the list.", test, test1);

		waitForElement(driver, Sector_Search_Btn);
		click(driver, Sector_Search_Btn);

		twoColumnSearchWindow(driver, Sector_Code_Header, Search_Condition1, Sector_Code_Field);

		Step_End(10, "Enter the Sector from the list.", test, test1);

		Step_Start(11, "Enter the TCA from the list.", test, test1);

		waitForElement(driver, TCA_Search_Btn);
		click(driver, TCA_Search_Btn);

		twoColumnSearchWindow(driver, TCA_Code_Header, Search_Condition1, TCA_Code_Field);

		Step_End(11, "Enter the TCA from the list.", test, test1);

		Step_Start(12, "Enter the Latitude & Longitude.", test, test1);

		waitForElement(driver, Latitute_Text_Field);
		sendKeys(driver, Latitute_Text_Field, Latitute_field);

		waitForElement(driver, Longitute_Text_Field);
		sendKeys(driver, Longitute_Text_Field, Longitute_field);

		Step_End(12, "Enter the Latitude & Longitude.", test, test1);

		Step_Start(13, "Enter Hemisphere and Median.", test, test1);

		waitForElement(driver, Hemisphere_Dropdown);
		click(driver, Hemisphere_Dropdown);

		waitForElement(driver, Hemisphere_Dropdown_Select);
		click(driver, Hemisphere_Dropdown_Select);

		waitForElement(driver, Meridian_Dropdown);
		click(driver, Meridian_Dropdown);

		waitForElement(driver, Meridian_Dropdown_Select);
		click(driver, Meridian_Dropdown_Select);

		Step_End(13, "Enter Hemisphere and Median.", test, test1);

		Step_Start(14, "Enter the Region.", test, test1);

		waitForElement(driver, Region_Search_btn);
		click(driver, Region_Search_btn);

		twoColumnSearchWindow(driver, Region_Code_Header, Search_Condition1, Region_Code_Field);

		Step_End(14, "Enter the Region.", test, test1);

		Step_Start(15, ".Enter the Timeoffset.", test, test1);

		waitForElement(driver, Time_Off_Set_Search_Btn);
		click(driver, Time_Off_Set_Search_Btn);

		twoColumnSearchWindow(driver, Time_Zone_Header, Search_Condition1, Time_Zone_Field);

		Step_End(15, ".Enter the Timeoffset", test, test1);

		Step_Start(16, "Enter the valid from date.", test, test1);

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

		Step_End(16, "Enter the valid from date.", test, test1);

		Step_Start(17, "Enter the valid to Date.", test, test1);

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

		Step_End(17, "Enter the valid to Date.", test, test1);

		Step_Start(18, "Click on Save button.", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(18, "Click on Save button.", test, test1);
		
		Step_Start(19, "System Prompt Location Saved", test, test1);
		
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

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(19, "System Prompt Location Saved", test, test1);

		Step_Start(20,
				"To verify the result whether created ports can able to retrieve from the ports screen with all data..",
				test, test1);

		moduleNavigate(driver, Ports_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition1, Global_Loc_Search_Header, Port_Loc_Code, "", "", "", "");

		String Actual_Loc_Code = getAttribute(driver, Ports_Loc_Code_Field,"value");
		System.out.println("Actual Location code is :"+ Actual_Loc_Code);
		
		if (Port_Loc_Code.equals(Actual_Loc_Code)) {

			System.out.println(
					"Matched || Excepted :The Newly Created Location details, The Location code is :" +Port_Loc_Code+"|| Actual : After retrieve from the ports screen ,The location code which we are getting is :"+Actual_Loc_Code);
			Extent_pass_New(driver,
					"Matched || Excepted :The Newly Created Location details, The Location code is :" +Port_Loc_Code+ " || Actual : After retrieve from the ports screen ,The location code which we are getting is :" +Actual_Loc_Code ,test, test1);
		}

		else {
			System.out.println(
					"NotMatched || Excepted :The Newly Created Location details, The Location code is :" +Port_Loc_Code+"|| Actual : After  After retrieve from the ports screen ,The location code which we are getting is :"+Actual_Loc_Code);
			Extent_fail(driver,
					"NotMatched || Excepted :The Newly Created Location details, The Location code is :" +Port_Loc_Code+ "|| Actual : After retrieve from the ports screen ,The location code which we are getting is :" +Actual_Loc_Code ,test, test1);
		}


		Step_End(20,
				"To verify the result whether created ports can able to retrieve from the ports screen with all data.",
				test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
