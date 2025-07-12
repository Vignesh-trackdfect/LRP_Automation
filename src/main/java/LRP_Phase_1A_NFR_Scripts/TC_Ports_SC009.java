package LRP_Phase_1A_NFR_Scripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ports_SC009 extends Keywords {

	public void Ports_SC009(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws IOException {

		String testCaseName = "TC_Ports_SC009";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Ports_Module = Excel_data.get("Ports_Module");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Global_Loc_Search_Header = Excel_data.get("Global_Loc_Search_Header");
		String Port_Loc_Code = Excel_data.get("Port_Loc_Code");
		String Status_Port = Excel_data.get("Status_Port");
		String Port_Loc_Updated_popup = Excel_data.get("Port_Loc_Updated_popup");
		String Booking_Module = Excel_data.get("Booking_Module");
		String Booking_Agency_Code = Excel_data.get("Booking_Agency_Code");
		String Origin_Invalid_Popup = Excel_data.get("Origin_Invalid_Popup");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login the application..", test, test1);

		LRP_Login(driver, username, pass_word);

		Step_End(1, "Login the application.", test, test1);

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

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(4, "Click on edit button.", test, test1);

		Step_Start(5, "Select Inactive button.", test, test1);

		if (!Status_Port.trim().equals("")) {
			waitForElement(driver, Status_for_port);
			click(driver, Status_for_port);
			formatLocatorClick(driver, Status_for_port_Dropdown_Select, Status_Port);

		}

		Step_End(5, "Select Inactive button.", test, test1);

		Step_Start(6, "Select Save button.", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(6, "Select Save button.", test, test1);

		Step_Start(7, "System prompt Location Updated", test, test1);

		waitForPopup(driver, popup_Message, Port_Loc_Updated_popup);
		String Updated_popup = getText(driver, popup_Message);
		System.out.println("Updated_popup is :" + Updated_popup);

		if (Port_Loc_Updated_popup.equals(Updated_popup)) {
			Extent_pass_New(driver, "Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup was  displayed : " + Updated_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup was displayed: " + Updated_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup  was not displayed: " + Updated_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Port_Loc_Updated_popup
					+ " || Actual popup  was not displayed: " + Updated_popup, test, test1);

		}

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(7, "System prompt Location Updated", test, test1);
		
		
		Step_Start(8, ".Open Booking screen.", test, test1);

		moduleNavigate(driver, Booking_Module);

		Step_End(8, ".Open Booking screen.", test, test1);

		Step_Start(9, "Enter Ag.party", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Booking_Agency_Code);
		
		waitForElement(driver, Booking_Agency_Party_Field);
		doubleClick(driver, Booking_Agency_Party_Field);
		

		Step_End(9, "Enter Ag.party", test, test1);


		Step_Start(10, " Enter the port code in orgin field.", test, test1);

	
		
		waitForElement(driver, Booking_Origin_Field);
		sendKeys(driver, Booking_Origin_Field, Port_Loc_Code);
		

		Step_End(10, " Enter the port code in orgin field.", test, test1);

		Step_Start(11, " Click on tab on keyboard.", test, test1);

		Tab(driver);

		Step_End(11, " Click on tab on keyboard.", test, test1);
		
       Step_Start(12, "Verify the result whether system showing Invalid Port code", test, test1);

       
       waitForPopup(driver, popup_Message, Origin_Invalid_Popup);

       String Actual_Origin_Popup = getText(driver, popup_Message);
		System.out.println("Actual Origin Popup is :"+ Actual_Origin_Popup);
		
		if (Origin_Invalid_Popup.equals(Actual_Origin_Popup)) {

			System.out.println(
					"Matched || Excepted :Origin Invalid popup is :" +Origin_Invalid_Popup+"|| Actual : Origin Invalid popup is :"+Actual_Origin_Popup);
			Extent_pass_New(driver,
					"Matched || Excepted :Origin Invalid popup is :" +Origin_Invalid_Popup+"|| Actual : Origin Invalid popup is :"+Actual_Origin_Popup,test, test1);
		}

		else {
			System.out.println(
					"NotMatched || Excepted :Origin Invalid popup is :" +Origin_Invalid_Popup+"|| Actual : Origin Invalid popup is :"+Actual_Origin_Popup);
			Extent_fail(driver,
					"NotMatched || Excepted :Origin Invalid popup is :" +Origin_Invalid_Popup+"|| Actual : Origin Invalid popup is :"+Actual_Origin_Popup ,test, test1);
		}

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);
		

		Step_End(12, "Verify the result whether system showing Invalid Port code", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
