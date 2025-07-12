package LRP_Finance_Recurring_Journal_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Recurring_Journal_RJ14 extends Keywords{
	public void Recurring_Journal_RJ14(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String testcase_Name="TC_Recurring_Journal_RJ14";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Recurring_Journal_Module = Excel_data.get("Recurring_Journal_Module");
		String Select_search_recurring_journal = Excel_data.get("Select_search_recurring_journal");
		String Condition = Excel_data.get("Condition");
		String Transaction_number = Excel_data.get("Transaction_number");
		String date_Picker = Excel_data.get("date_Picker");
		String Start_Date_Input = Excel_data.get("Start_Date_Input");
		String BatchNotGenrated_Popup = Excel_data.get("BatchNotGenrated_Popup");
		String Count_Of_Year = Excel_data.get("Count_Of_Year");
		String Month_input_for_Year = Excel_data.get("Month_input_for_Year");
		String Day_input_for_Year = Excel_data.get("Day_input_for_Year");
		String year_Day_Selectt = Excel_data.get("year_Day_Selectt");
		String Year_day_Perform = Excel_data.get("Year_day_Perform");
		String month_Selectt = Excel_data.get("month_Selectt");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, Username, Password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, Recurring_Journal_Module);
		Step_Start(1, "Click new on toolbar", test, test1);
		Step_Start(2, " Pop message will appear . Click yes to continue", test, test1);
		waitForDisplay(driver, popup_Message);
		if(isDisplayed(driver, popup_Message)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}else {
			newButton(driver);
		}
		Step_End(1, "Click new on toolbar", test, test1);
		Step_End(2, " Pop message will appear . Click yes to continue", test, test1);
		Step_Start(3, "Select the Transaction number using search field ", test, test1);
		waitForElement(driver, Transaction_No_searchBtn_RJ);
		click(driver,Transaction_No_searchBtn_RJ);
		globalValueSearchWindow(driver, Condition, Select_search_recurring_journal, Transaction_number, "", "", "", "");
		Step_End(3, "Select the Transaction number using search field ", test, test1);
		Step_Start(4, " Click Create Batch button . Popup window will appear .", test, test1);
		waitForElement(driver, create_batch);
		click(driver,create_batch);
		Step_End(4, " Click Create Batch button . Popup window will appear .", test, test1);
		Step_Start(8, "Select the  No End date Option", test, test1);
		waitForElement(driver, No_end_date_radio_button);
		click(driver, No_end_date_radio_button);
		Step_End(8, "Select the  No End date Option", test, test1);
		Step_Start(7, "Select the start date from the date picker", test, test1);
		waitForElement(driver, start_date);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, start_date, Start_Date_Input);
		} else {
			waitForElement(driver, start_date);
			clearAndType(driver, start_date, Start_Date_Input);
		}
		Step_End(7, "Select the start date from the date picker", test, test1);	
		Step_Start(5, "Select the \"Year\" option", test, test1);
		waitForElement(driver, Year_Click_RJ);
		click(driver, Year_Click_RJ);
		Step_End(5, "Select the \"Year\" option", test, test1);
		Step_Start(6, "Enter the  count of year in that text field", test, test1);
		waitForElement(driver, year_input);
		sendKeys(driver, year_input, Count_Of_Year);
		if(Year_day_Perform.equalsIgnoreCase("YES")) {
			String monthclick = String.format(year_days_click,year_Day_Selectt);
			waitForElement(driver, monthclick);
			click(driver, monthclick);
			if(year_Day_Selectt.equalsIgnoreCase("Day")) {
				waitForElement(driver, day_drop_click);
				click(driver, day_drop_click);
				String dayselectyear = String.format(day_drop_click_year, Day_input_for_Year);
				waitForElement(driver, dayselectyear);
				click(driver, dayselectyear);
			}
		}
		if(month_Selectt.equalsIgnoreCase("YES")) {
			waitForElement(driver, year_month_click_drop);
			click(driver, year_month_click_drop);
			String monthselectyear = String.format(day_drop_select_click1, Month_input_for_Year);
			waitForElement(driver, monthselectyear);
			click(driver, monthselectyear);
		}
		Step_End(6, "Enter the  count of year in that text field", test, test1);
		Step_Start(9, "Click Generate Button", test, test1);
		waitForElement(driver, Generate_Button_RJ);
		click(driver, Generate_Button_RJ);
		Step_End(9, "Click Generate Button", test, test1);
		Step_Start(10, "It showing Validation \" Batch Cannot be created for Selected Period", test, test1);
		waitForPopup(driver, popup_Message,BatchNotGenrated_Popup);
		String Batch_Not_Generated_Popup=getText(driver, popup_Message);
		if(BatchNotGenrated_Popup.equals(Batch_Not_Generated_Popup)) {
			System.out.println("Matched || Expected Pop-up Value Should be  : " + BatchNotGenrated_Popup + " || Actual Pop-up Value is : " + Batch_Not_Generated_Popup);
			Extent_pass_New(driver,"Matched || Expected Pop-up Value Should be  : " + BatchNotGenrated_Popup + " || Actual Pop-up Value is : " + Batch_Not_Generated_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up Value Should be  : " + BatchNotGenrated_Popup + " || But The Actual Pop-up Value is : " + Batch_Not_Generated_Popup);
			Extent_fail(driver,"Not Matched || Expected Pop-up Value Should be  : " + BatchNotGenrated_Popup + " || But The Actual Pop-up Value is : " + Batch_Not_Generated_Popup,test, test1);
		}	
		Step_End(10, "It showing Validation \" Batch Cannot be created for Selected Period", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}