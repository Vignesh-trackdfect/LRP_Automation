package LRP_Phase_1A_NFR_Scripts;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ports_SC011 extends Keywords {
	
	public void Ports_SC011(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws IOException {

		String testCaseName = "TC_Ports_SC011";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Ports_Module = Excel_data.get("Ports_Module");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Global_Loc_Search_Header = Excel_data.get("Global_Loc_Search_Header");
		String Port_Loc_Code = Excel_data.get("Port_Loc_Code");
		String Time_Day_Light_TextField = Excel_data.get("Time_Day_Light_TextField");
		String valid_From_date_TextField1 = Excel_data.get("valid_From_date_TextField1");
		String Valid_From_date_pop = Excel_data.get("Valid_From_date_pop");
		String Region_Code_Header = Excel_data.get("Region_Code_Header");
		String Region_Code_Field = Excel_data.get("Region_Code_Field");
		String valid_From_date_TextField2 = Excel_data.get("valid_From_date_TextField2");
		String validTo_date_TextField2 = Excel_data.get("validTo_date_TextField2");
		String Valid_To_Date_POPup = Excel_data.get("Valid_To_Date_POPup");
		String valid_From_date_TextField3 = Excel_data.get("valid_From_date_TextField3");
		String validTo_date_TextField3 = Excel_data.get("validTo_date_TextField3");
		String To_Date_exp_Popup = Excel_data.get("To_Date_exp_Popup");
		String Change_From_date_TextField1 = Excel_data.get("Change_From_date_TextField1");
		String Change_To_date_TextField1 = Excel_data.get("Change_To_date_TextField1");
		String Change_From_date_popup = Excel_data.get("Change_From_date_popup");
		String Change_From_date_TextField2 = Excel_data.get("Change_From_date_TextField2");
		String Change_To_date_TextField2 = Excel_data.get("Change_To_date_TextField2");
		String Change_To_Date_popup = Excel_data.get("Change_To_Date_popup");
		String Change_From_date_TextField3 = Excel_data.get("Change_From_date_TextField3");
		String Change_To_date_TextField3 = Excel_data.get("Change_To_date_TextField3");
		String Change_exp_popup = Excel_data.get("Change_exp_popup");
		String validTo_date_TextField1 = Excel_data.get("validTo_date_TextField1");
		
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login the application.", test, test1);

		LRP_Login(driver, username, pass_word);

		Step_End(1, "Login the application.", test, test1);

		Step_Start(2, " Navigate to Ports Screen.", test, test1);

		// verifyMainMenu(driver);

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
		
		Step_Start(5, " the Valid From Date as Future date system should prompt \"Valid From Date should not be greater than valid To Date\".", test, test1);
		
		
		waitForElement(driver, Region_Search_btn);
		click(driver, Region_Search_btn);

		twoColumnSearchWindow(driver, Region_Code_Header, Search_Condition1, Region_Code_Field);
		
		
				waitForElement(driver, Valid_From_date_field);
				click(driver, Valid_From_date_field);
				selectDatePicker(driver, valid_From_date_TextField1);
			
				waitForElement(driver, Valid_To_date_field);
				click(driver, Valid_To_date_field);
				selectDatePicker(driver, validTo_date_TextField1);
				
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				
				waitForPopup(driver, popup_Message, Valid_From_date_pop);
		        String From_popup=getText(driver, popup_Message);
		        
		        
		        
		        if(From_popup.equals(Valid_From_date_pop)) {
					System.out.println("Matched || " + " Expected POPUP is : " + Valid_From_date_pop + " || Actual  POPUP message is : " + From_popup);
					Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Valid_From_date_pop + " || Actual  POPUP message is : " + From_popup, test, test1);

				}else {
					System.out.println("Not Matched || " + " Expected POPUP is : " + Valid_From_date_pop + " || Actual  POPUP message is : " + From_popup);
					Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Valid_From_date_pop + " || Actual  POPUP message is : " + From_popup, test, test1);

				}
		
		        
		        waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);	
				
				
				Step_End(5, "the Valid From Date as Future date system should prompt \"Valid From Date should not be greater than valid To Date\".", test, test1);
	
				Step_Start(6, "If Valid To date Less than the current Date System should prompt \"Valid To Date should not be less than Current Date..", test, test1);

				
				waitForElement(driver, Valid_From_date_field);
				clear(driver, Valid_From_date_field);
				selectDatePicker(driver, valid_From_date_TextField2);
				
		
				waitForElement(driver, Valid_To_date_field);
				clear(driver, Valid_To_date_field);
				selectDatePicker(driver, validTo_date_TextField2);
				
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				
				waitForPopup(driver, popup_Message, Valid_To_Date_POPup);
		        String To_popup=getText(driver, popup_Message);
		
		        
		        if(To_popup.equals(Valid_To_Date_POPup)) {
					System.out.println("Matched || " + " Expected POPUP is : " + Valid_To_Date_POPup + " || Actual  POPUP message is : " + To_popup);
					Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Valid_To_Date_POPup + " || Actual  POPUP message is : " + To_popup, test, test1);

				}else {
					System.out.println("Not Matched || " + " Expected POPUP is : " + Valid_To_Date_POPup + " || Actual  POPUP message is : " + To_popup);
					Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Valid_To_Date_POPup + " || Actual  POPUP message is : " + To_popup, test, test1);

				}
		
		        
		        waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);	
				
				Step_End(6, "If Valid To date Less than the current Date System should prompt \"Valid To Date should not be less than Current Date..", test, test1);
	
				Step_Start(7, "If Valid from & Valid To is Equal Date system should prompt \"Valid From Date and valid To Date should not be equal.\"", test, test1);

				waitForElement(driver, Valid_From_date_field);
				clear(driver, Valid_From_date_field);
				selectDatePicker(driver, valid_From_date_TextField3);
		
				waitForElement(driver, Valid_To_date_field);
				clear(driver, Valid_To_date_field);
				selectDatePicker(driver, validTo_date_TextField3);
				
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				
				waitForPopup(driver, popup_Message, To_Date_exp_Popup);
		        String From_Date_popup=getText(driver, popup_Message);
		
		        
		        if(From_Date_popup.equals(To_Date_exp_Popup)) {
					System.out.println("Matched || " + " Expected POPUP is : " + To_Date_exp_Popup + " || Actual  POPUP message is : " + From_Date_popup);
					Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + To_Date_exp_Popup + " || Actual  POPUP message is : " + From_Date_popup, test, test1);

				}else {
					System.out.println("Not Matched || " + " Expected POPUP is : " + To_Date_exp_Popup + " || Actual  POPUP message is : " + From_Date_popup);
					Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + To_Date_exp_Popup + " || Actual  POPUP message is : " + From_Date_popup, test, test1);

				}
		        waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);	
				
				
				Step_End(7, "If Valid from & Valid To is Equal Date system should prompt \"Valid From Date and valid To Date should not be equal.\"", test, test1);
	             
				Step_Start(8, "If the Change From Date as Future date system should prompt \" Change From Date of time zone should not be greater than Change To Date of time zone.\"", test, test1);

				waitForElement(driver, Valid_To_date_field);
				clear(driver, Valid_To_date_field);
				selectDatePicker(driver, valid_From_date_TextField1);
				
				waitForElement(driver, Time_Day_Light_Field);
				clear(driver,Time_Day_Light_Field);
				sendKeys(driver, Time_Day_Light_Field, Time_Day_Light_TextField);
			
			
		
				waitForElement(driver, Change_From_date_Field);
				click(driver, Change_From_date_Field);
				clear(driver, Change_From_date_Field);
				selectDatePicker(driver, Change_From_date_TextField1);
				
				
				waitForElement(driver, Change_To_date_Field);
				click(driver, Change_To_date_Field);
				clear(driver, Change_To_date_Field);
				selectDatePicker(driver, Change_To_date_TextField1);
				
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				
				waitForPopup(driver, popup_Message, Change_From_date_popup);
		        String Change_Date_popup=getText(driver, popup_Message);
		
		        
		        if(Change_Date_popup.equals(Change_From_date_popup)) {
					System.out.println("Matched || " + " Expected POPUP is : " + Change_From_date_popup + " || Actual  POPUP message is : " + Change_Date_popup);
					Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Change_From_date_popup + " || Actual  POPUP message is : " + Change_Date_popup, test, test1);

				}else {
					System.out.println("Not Matched || " + " Expected POPUP is : " + Change_From_date_popup + " || Actual  POPUP message is : " + Change_Date_popup);
					Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Change_From_date_popup + " || Actual  POPUP message is : " + Change_Date_popup, test, test1);

				}
		        waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);	
				
				
				Step_End(8, "If the Change From Date as Future date system should prompt \" Change From Date of time zone should not be greater than Change To Date of time zone.\"", test, test1);
  
				Step_Start(9, "If Change To date Less than the current Date System should prompt \"Change To Date of time zone should not be less than Current Date.\"", test, test1);

				
				waitForElement(driver, Change_From_date_Field);
				clear(driver, Change_From_date_Field);
				selectDatePicker(driver, Change_From_date_TextField2);
				
				
				waitForElement(driver, Change_To_date_Field);
				clear(driver, Change_To_date_Field);
				selectDatePicker(driver, Change_To_date_TextField2);
				
				
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				
				waitForPopup(driver, popup_Message, Change_To_Date_popup);
		        String Change_ToDate_popup=getText(driver, popup_Message);
		
		        
		        if(Change_ToDate_popup.equals(Change_To_Date_popup)) {
					System.out.println("Matched || " + " Expected POPUP is : " + Change_From_date_popup + " || Actual  POPUP message is : " + Change_ToDate_popup);
					Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Change_From_date_popup + " || Actual  POPUP message is : " + Change_ToDate_popup, test, test1);

				}else {
					System.out.println("Not Matched || " + " Expected POPUP is : " + Change_From_date_popup + " || Actual  POPUP message is : " + Change_ToDate_popup);
					Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Change_From_date_popup + " || Actual  POPUP message is : " + Change_ToDate_popup, test, test1);

				}
		        waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);	
				
				
				Step_End(9, "If Change To date Less than the current Date System should prompt \"Change To Date of time zone should not be less than Current Date.\"", test, test1);
				Step_Start(10, "If Change from & Change To is Equal Date system should prompt \"Change From Date and Change To Date of time zone should not be equal.\"", test, test1);

				waitForElement(driver, Change_From_date_Field);
				clear(driver, Change_From_date_Field);
				selectDatePicker(driver, Change_From_date_TextField3);
				
				waitForElement(driver, Change_To_date_Field);
				clear(driver, Change_To_date_Field);
				selectDatePicker(driver, Change_To_date_TextField3);
				
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				
				waitForPopup(driver, popup_Message, Change_exp_popup);
		        String Change_popup=getText(driver, popup_Message);
				
		        
		        if(Change_popup.equals(Change_exp_popup)) {
					System.out.println("Matched || " + " Expected POPUP is : " + Change_exp_popup + " || Actual  POPUP message is : " + Change_popup);
					Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Change_exp_popup + " || Actual  POPUP message is : " + Change_popup, test, test1);

				}else {
					System.out.println("Not Matched || " + " Expected POPUP is : " + Change_exp_popup + " || Actual  POPUP message is : " + Change_popup);
					Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Change_exp_popup + " || Actual  POPUP message is : " + Change_popup, test, test1);

				}
		        waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);	
				
				Step_End(10, "If Change from & Change To is Equal Date system should prompt \"Change From Date and Change To Date of time zone should not be equal.\"", test, test1);
				Extent_completed(testCaseName, test, test1);
				

	}
}
