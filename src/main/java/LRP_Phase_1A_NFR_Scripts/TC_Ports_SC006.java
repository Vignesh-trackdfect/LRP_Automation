package LRP_Phase_1A_NFR_Scripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ports_SC006 extends Keywords {

	public void Ports_SC006(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws IOException {

		String testCaseName = "TC_Ports_SC006";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Ports_Module = Excel_data.get("Ports_Module");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Global_Loc_Search_Header = Excel_data.get("Global_Loc_Search_Header");
		String Port_Loc_Code = Excel_data.get("Port_Loc_Code");
		String Time_Day_Light_TextField = Excel_data.get("Time_Day_Light_TextField");
		String Change_From_date_TextField = Excel_data.get("Change_From_date_TextField");
		String Change_To_date_TextField = Excel_data.get("Change_To_date_TextField");
		String DatePicker = Excel_data.get("DatePicker");
		String Change_From_date_popup = Excel_data.get("Change_From_date_popup"); 
		String Change_To_date_popup = Excel_data.get("Change_To_date_popup");
		String Port_Loc_Updated_popup = Excel_data.get("Port_Loc_Updated_popup");
		String Time_Zone_Module = Excel_data.get("Time_Zone_Module");
		String Time_Loc_Code_Header = Excel_data.get("Time_Loc_Code_Header");
		
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login the application.", test, test1);

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

		waitForElement(driver,Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(4, "Click on edit button.", test, test1);
		
		Step_Start(5, ".Enter timedaylight as 1", test, test1);

		waitForElement(driver, Time_Day_Light_Field);
		Newclear(driver, Time_Day_Light_Field);
		sendKeys(driver, Time_Day_Light_Field, Time_Day_Light_TextField);
		enter(driver);
		
		Step_End(5, ".Enter timedaylight as 1", test, test1);
		
		Step_Start(6, "Click on Save button.", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Change_From_date_popup);
		String Actual_popup = getText(driver, popup_Message);
		System.out.println("Actual_popup is :" + Actual_popup);

		if (Change_From_date_popup.equals(Actual_popup)) {
			Extent_pass_New(driver, "Matched || Expected Change From Date popup was : " + Change_From_date_popup
					+ " || Actual popup was displayed : " + Actual_popup, test, test1);
			System.out.println("Matched || Expected Change From Date popup was : " + Change_From_date_popup
					+ " || Actual popup was displayed: " + Actual_popup);
		} else {
			System.out.println("Not Matched || Expected Change From Date popup was : " + Change_From_date_popup
					+ " || Actual popup was not displayed: " + Actual_popup);
			Extent_fail(driver, "Not Matched ||Expected Change From Date popup was : " + Change_From_date_popup
					+ " || Actual popup was not displayed: " + Actual_popup, test, test1);

		}

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);


		Step_End(6, "Click on Save button.", test, test1);
		
		Step_Start(7, "System prompt Enter the change From Date and Change To Date.", test, test1);

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
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Change_To_date_popup);
		String Actual_popup1 = getText(driver, popup_Message);
		System.out.println("Actual_popup is :" + Actual_popup1);

		if (Change_To_date_popup.equals(Actual_popup1)) {
			Extent_pass_New(driver, "Matched || Expected Change To Date popup was : " + Change_To_date_popup
					+ " || The actual popup was displayed. : " + Actual_popup1, test, test1);
			System.out.println("Matched || Expected Change To Date popup was : " + Change_To_date_popup
					+ " || The actual popup was displayed : " + Actual_popup1);
		} else {
			System.out.println("Not Matched || Expected Change To Date popup was : " + Change_To_date_popup
					+ " || Actual popup value was not displayed: " + Actual_popup1);
			Extent_fail(driver, "Not Matched ||Expected Change To Date popup was : " + Change_To_date_popup
					+ " || Actual popup value was not displayed: " + Actual_popup1, test, test1);

		}

		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Ok_Button);

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
		
		Step_End(7, "System prompt  Enter the change From Date and Change To Date.", test, test1);
		
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

		Step_End(9, "System prompt Location Updated", test, test1);
		
		
		Step_Start(10, "To verify the result  whether timezone updated correctly.", test, test1);
		
		
		moduleNavigate(driver, Time_Zone_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition1, Time_Loc_Code_Header, Port_Loc_Code, "", "", "", "");

		String Actual_TimeDay_light_value = getAttribute(driver, TZ_Time_Day_Light_Field,"value");
		
		double Actual_timeDay_light_value= Double.parseDouble(Actual_TimeDay_light_value);
		
		double Time_Day_light_TextField= Double.parseDouble(Time_Day_Light_TextField);
		
		System.out.println("Actual Time day Light is :"+ Actual_timeDay_light_value);
		
		if (Time_Day_light_TextField==(Actual_timeDay_light_value)) {

			System.out.println(
					"Matched || Excepted : While Editing the Location Details, The TimeDay Light value is :" +Time_Day_light_TextField+"|| Actual : After Updating the Timeday light Details, The value which we are getting is :"+Actual_timeDay_light_value);
			Extent_pass_New(driver,
					"Matched || Excepted : While Editing the Location Details, The TimeDay Light value is :" +Time_Day_light_TextField+"|| Actual : After Updating the Timeday light Details, The value which we are getting is :"+Actual_timeDay_light_value ,test, test1);
		}

		else {
			System.out.println(
					"NotMatched || Excepted : While Editing the Location Details, The TimeDay Light value is :" +Time_Day_light_TextField+"|| Actual : After Updating the Timeday light Details, The value which we are getting is :"+Actual_timeDay_light_value);
			Extent_fail(driver,
					"NotMatched || Excepted : While Editing the Location Details, The TimeDay Light value is :" +Time_Day_light_TextField+"|| Actual : After Updating the Timeday light Details, The value which we are getting is :"+Actual_timeDay_light_value ,test, test1);
		}

	
		Step_End(10, "To verify the result  whether timezone updated correctly.", test, test1);
		
		Extent_completed(testCaseName, test, test1);
	}	
}
