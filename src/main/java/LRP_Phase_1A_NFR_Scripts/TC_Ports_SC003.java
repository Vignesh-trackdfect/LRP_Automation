package LRP_Phase_1A_NFR_Scripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ports_SC003 extends Keywords {
	
	public void Ports_SC003(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws IOException {

		String testCaseName = "TC_Ports_SC003";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Ports_Module = Excel_data.get("Ports_Module");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Global_Loc_Search_Header = Excel_data.get("Global_Loc_Search_Header");
		String Port_Loc_Code = Excel_data.get("Port_Loc_Code");
		String Loc_Type_Dropdown = Excel_data.get("Loc_Type_Dropdown");
		String Port_Loc_Updated_popup = Excel_data.get("Port_Loc_Updated_popup");
		String Sea_Port_Code_Header = Excel_data.get("Sea_Port_Code_Header");
		String Sea_Port_Code_Field = Excel_data.get("Sea_Port_Code_Field");
		String Agency_Code_Header = Excel_data.get("Agency_Code_Header");
		String Agency_Code_Field = Excel_data.get("Agency_Code_Field");
		
		String Dropdown_Sel = String.format(Port_Dropdown_Select, Loc_Type_Dropdown);

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login the application.", test, test1);

		LRP_Login(driver, username, pass_word);

		Step_End(1, "Login the application..", test, test1);

		Step_Start(2, " Navigate to Ports Screen.", test, test1);

		verifyMainMenu(driver);

		moduleNavigate(driver, Ports_Module);

		Step_End(2, " Navigate to Ports Screen.", test, test1);
		
		Step_Start(3, ".Retrieve the data from ports screen.", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition1, Global_Loc_Search_Header, Port_Loc_Code, "", "", "", "");

		Step_End(3, ".Retrieve the data from ports screen.", test, test1);

		Step_Start(4, "Click on edit button.", test, test1);

		waitForElement(driver,Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(4, "Click on edit button.", test, test1);

		Step_Start(5, ".Enter the agency code ", test, test1);

		waitForElement(driver, Agency_Search_Btn);
		click(driver, Agency_Search_Btn);
		
     twoColumnSearchWindow(driver, Agency_Code_Header, Search_Condition1, Agency_Code_Field);

		Step_End(5, ".Enter the agency code ", test, test1);
		
		Step_Start(6, "Change Type as Inland.", test, test1);

		waitForElement(driver, Port_Loc_Type_Dropdown);
		click(driver, Port_Loc_Type_Dropdown);

		waitForElement(driver, Dropdown_Sel);
		click(driver, Dropdown_Sel);

		Step_End(6, "Change Type as Inland.", test, test1);
		
		
		Step_Start(7, "Select Sea port from the list", test, test1);

		waitForElement(driver, Sea_Port_Checkbox);
		click(driver, Sea_Port_Checkbox);

		waitForElement(driver, Sea_Port_Search_Btn);
		click(driver, Sea_Port_Search_Btn);
		
		globalValueSearchWindow(driver, Search_Condition1, Sea_Port_Code_Header, Sea_Port_Code_Field, "", "", "", "");
		
		Step_End(7, "Select Sea port from the list.", test, test1);
		
		Step_Start(8, "Click on Save button.", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(8, "Click on Save button.", test, test1);
		
		Step_Start(9, "System prompt Location Updated", test, test1);
		
		waitForPopup(driver, popup_Message, Port_Loc_Updated_popup);
		String Updated_popup = getText(driver, popup_Message);
		System.out.println("Updated_popup is :" + Updated_popup);

		if (Port_Loc_Updated_popup.equals(Updated_popup)) {
			Extent_pass_New(driver, "Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup value was is display : " + Updated_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup value was is display: " + Updated_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup value was not display: " + Updated_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup value was not display: " + Updated_popup, test, test1);

		}

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(9, "System prompt Location Updated", test, test1);
		
		Step_Start(10,
				"To verify the result whether updated informations are reflecting from the ports screen",
				test, test1);

		moduleNavigate(driver, Ports_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition1, Global_Loc_Search_Header, Port_Loc_Code, "", "", "", "");

		
		String Actual_Loc_Code = getAttribute(driver, Ports_Loc_Code_Field,"value");
		System.out.println("Actual Location code is :"+ Actual_Loc_Code);
		
		if (Port_Loc_Code.equals(Actual_Loc_Code)) {

			System.out.println(
					"Matched || Excepted : Before Editing the Location Details, The Location code is :" +Port_Loc_Code+"|| Actual : After Editing the Location Details,The location cde which we are getting is :"+Actual_Loc_Code);
			Extent_pass_New(driver,
					"Matched || Excepted : Before Editing the Location Details, The Location code is :" +Port_Loc_Code+ " || Actual : After Editing the Location Details,The location cde which we are getting is :" +Actual_Loc_Code ,test, test1);
		}

		else {
			System.out.println(
					"NotMatched || Excepted : Before Editing the Location Details, The Location code is :" +Port_Loc_Code+"|| Actual : After Editing the Location Details,The location cde which we are getting is :"+Actual_Loc_Code);
			Extent_fail(driver,
					"NotMatched || Excepted : Before Editing the Location Details, The Location code is :" +Port_Loc_Code+ "|| Actual : After Editing the Location Details,The location cde which we are getting is :" +Actual_Loc_Code ,test, test1);
		}

		Step_End(10,
				"To verify the result whether updated informations are reflecting from the ports screen",
				test, test1);

		Extent_completed(testCaseName, test, test1);

		
		
	}
}


