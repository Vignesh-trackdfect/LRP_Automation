package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ports_SC012 extends Keywords{
	
	public void Ports_SC012(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Ports_SC012";
		
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
		String Sea_Port_Checkbox_Option = Excel_data.get("Sea_Port_Checkbox_Option");
		String Budget_Loc_Checkbox_Option = Excel_data.get("Budget_Loc_Checkbox_Option");
		String Change_To_date_TextField = Excel_data.get("Change_To_date_TextField");
		String Change_From_date_TextField = Excel_data.get("Change_From_date_TextField");
		String Agency_code_Header = Excel_data.get("Agency_code_Header");
		String Condition = Excel_data.get("Condition");
		String Agency_code_Input = Excel_data.get("Agency_code_Input");
		String Exp_popup = Excel_data.get("Exp_popup");
		
		
		
		
		
		String Meridian_Dropdown_Select = String.format(Meridian_Dropdown_Sel, Merdian_Dropdown_field);
		String Hemisphere_Dropdown_Select = String.format(Hemisphere_Dropdown_Sel, Hemispere_Dropdown_field);
		String Dropdown_Sel = String.format(Port_Dropdown_Select, Loc_Type_Dropdown);
		
		
		Extent_Start(testcase_Name, test, test1);
		 
		Step_Start(1, "Login the application.", test, test1);
		
		navigateUrl(driver, url);
		
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);
		
		Step_End(1, "Login the application.", test, test1);

		Step_Start(2, "Navigate to ports screen", test, test1);

		moduleNavigate(driver, Ports_Module);
		
		Step_End(2, "Navigate to ports screen", test, test1);
		
		Step_Start(3, "Click on new button", test, test1);
		
		newButton(driver);
		
		Step_End(3, "Click on new button", test, test1);
		
		
		Step_Start(4, "Create a new Port with Existing Port Code Ex:QQQQQ (Follow TS01).", test, test1);
		

		waitForElement(driver, Ports_Loc_Code_Field);
		sendKeys(driver, Ports_Loc_Code_Field, Port_Loc_Code);


		waitForElement(driver, Port_Loc_Name_Field);
		sendKeys(driver, Port_Loc_Name_Field, Port_Loc_Name);


		waitForElement(driver, Port_Loc_Type_Dropdown);
		click(driver, Port_Loc_Type_Dropdown);

		waitForElement(driver, Dropdown_Sel);
		click(driver, Dropdown_Sel);


		 checkBox(driver, Port_Budget_Checkbox, Budget_Loc_Checkbox_Option);
		 
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

		Step_Start(4, "Create a new Port with Existing Port Code Ex:QQQQQ (Follow TS01).", test, test1);
		


		
		if (!Change_To_date_TextField.equals("")) {
			if (DatePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Change_To_date_Field);
				click(driver, Change_To_date_Field);
				selectDatePicker(driver, Change_To_date_TextField);
			} else {
				waitForElement(driver, Change_To_date_Field);
				clearAndType(driver, Change_To_date_Field, Change_To_date_TextField);
			}
		}
		
		
		if (!Change_From_date_TextField.equals("")) {
			if (DatePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Change_From_date_Field);
				click(driver, Change_From_date_Field);
				selectDatePicker(driver, Change_From_date_TextField);
			} else {
				waitForElement(driver, Change_From_date_Field);
				clearAndType(driver, Change_From_date_Field, Change_From_date_TextField);
			}
		}
		
		
		waitForElement(driver, Ports_Agency_Button);
		click(driver,Ports_Agency_Button);
		
		
		twoColumnSearchWindow(driver, Agency_code_Header, Condition, Agency_code_Input);
		
		Step_Start(5, "Click on save button.", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(5, "Click on save button.", test, test1);
		
		Step_Start(5, "To verify the result system should be validate Prompt \"Location code already exists\".", test, test1);
		
		waitForPopup(driver, popup_Message, Exp_popup);
		String saved_popup = getText(driver, popup_Message);
		System.out.println("saved_popup :" + saved_popup);
		
		
		if (saved_popup.equals(Exp_popup)) {
			Extent_pass_New(driver, "Matched || Expected popup value was : " + Exp_popup
					+ " || Actual popup value was is display : " + saved_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Exp_popup
					+ " || Actual popup value was is display: " + saved_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Exp_popup
					+ " || Actual popup value was not display: " + saved_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Exp_popup
					+ " || Actual popup value was not display: " + saved_popup, test, test1);

		}
		
		
		Step_End(5, "To verify the result system should be validate Prompt \"Location code already exists\".", test, test1);
		
		
		Extent_completed(testcase_Name, test, test1);
		
		
		
}
}