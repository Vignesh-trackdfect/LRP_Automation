package LRP_Finance_Recurring_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Recurring_Journal_RJ05  extends Keywords{
	public void  Recurring_Journal_RJ05(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){
		String testcase_Name="TC_Recurring_Journal_RJ05";
		
		


		String username = Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String Recurring_Journal_Module =Excel_data.get("Field_Names");
		String Select_search_recurring_journal =Excel_data.get("Select_search_recurring_journal");
		String Condition =Excel_data.get("Condition");
		String Transaction_number =Excel_data.get("Transaction_number");
		String Week_Perform =Excel_data.get("Week_Perform");
		String Week_Input =Excel_data.get("Week_Input");
		String Week_day_click =Excel_data.get("Week_day_click");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String From_date_perform = Excel_data.get("From_date_perform");
		String End_Date_input = Excel_data.get("End_Date_input");
		String End_Date_Perform = Excel_data.get("End_Date_Perform");
		String select_value_gird = Excel_data.get("select_value_gird");
		String savedpopexp = Excel_data.get("savedpopexp");
		String Batch_TYPE = Excel_data.get("Batch_TYPE");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, username, password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, Recurring_Journal_Module);
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver,popup_Message_Yes_Button);
		}else {
			Step_Start(1, "Click new on toolbar", test, test1);
			Step_End(1, "Click new on toolbar", test, test1);
			Step_Start(2, "Pop message will appear . Click yes to continue", test, test1);
			newButton(driver);
			Step_End(2, "Pop message will appear . Click yes to continue", test, test1);
		}
		Step_Start(3, "Select the Transaction number using search field .", test, test1);
		waitForElement(driver, Trans_numner_search);
		click(driver,Trans_numner_search);
		globalValueSearchWindow(driver, Condition, Select_search_recurring_journal, Transaction_number, "", "", "", "");
		Step_End(3, "Select the Transaction number using search field .", test, test1);
		Step_Start(4, "Click Create Batch button . Popup window will appear", test, test1);
		waitForElement(driver, create_batch);
		click(driver,create_batch);
		Step_End(4, "Click Create Batch button . Popup window will appear", test, test1);
		Step_Start(5, "Select the \"Week\" option .", test, test1);
		if(Week_Perform.equalsIgnoreCase("YES")) {
			waitForElement(driver, week_radio_button);
			checkBox(driver, week_radio_button, Week_Perform);
			Step_End(5, "Select the \"Week\" option .", test, test1);
			Step_Start(6, "Enter the count of month in that text field ..", test, test1);
			waitForElement(driver, week_input);
			sendKeys(driver, week_input,Week_Input);
			Step_End(6, "Enter the count of month in that text field ..", test, test1);
			Step_Start(7, "Select the radio button Mon/tue/wed/Thur/Fri/Sat/Sun.", test, test1);
			String weekclick = String.format(week_days_click, Week_day_click);
			waitForElement(driver, weekclick);
			click(driver, weekclick);
			Step_End(7, "Select the radio button Mon/tue/wed/Thur/Fri/Sat/Sun.", test, test1);
		}
		Step_Start(8, "Select the start date from the date picker.", test, test1);
		waitForElement(driver, start_date);
		if (From_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, start_date, From_Date_Input);
		} else {
			waitForElement(driver, start_date);
			clearAndType(driver, start_date, From_Date_Input);
		}
		Step_End(8, "Select the start date from the date picker.", test, test1);
		Step_Start(9, "Select the end date from the date picker .", test, test1);
		waitForElement(driver, end_date);
		if (End_Date_Perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, end_date, End_Date_input);
		} else {
			waitForElement(driver, No_end_date_radio_button);
			click(driver, No_end_date_radio_button);
		}
		Step_End(9, "Select the end date from the date picker .", test, test1);
		Step_Start(10, "Click Generate Button.", test, test1);
		waitForElement(driver, generate_button);
		click(driver, generate_button);
		Step_End(10, "Click Generate Button.", test, test1);
		String gird = String.format(select_row, select_value_gird);
		waitForElement(driver, gird);
		click(driver, gird);
		scrollTop(driver);
		Step_Start(12, " Click Save on toolbar .", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(12, " Click Save on toolbar .", test, test1);
		Step_Start(13, "Recurring Journal saved successfully.", test, test1);
		waitForPopup(driver, popup_Message,savedpopexp);
		String Actualpopmsg = getText(driver, popup_Message);
		System.out.println(Actualpopmsg);
		if (savedpopexp.equals(Actualpopmsg)) {
			System.out.println("Matched || " + " Expected Pop-up value is : " + savedpopexp+ " || Actual Pop-up value is : " + Actualpopmsg);
			Extent_pass_New(driver, "Matched || " + " Expected Pop-up value is : " + savedpopexp+ " || Actual Pop-up value is : " + Actualpopmsg, test, test1);
		} else {
			System.out.println("Not matched || " + " Expected Pop-up value is : " + savedpopexp+ " || Actual Pop-up value is : " + Actualpopmsg);
			Extent_fail(driver, "Not matched || " + " Expected Pop-up value is : " + savedpopexp+ " || Actual Pop-up value is : " + Actualpopmsg, test, test1);
		}
		Step_End(13, " Recurring Journal saved successfully.", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_Start(11, " Batch generated by Week .", test, test1);
		String type = String.format(recurring_journal_batch_type, select_value_gird);
		waitForElement(driver, type);
		String recurring_journal_batchtype = getText(driver, type);
		System.out.println(recurring_journal_batchtype);
		Extent_call(test, test1, "*** Batch type shown in a Recurring_journal tab after click post****"+recurring_journal_batchtype);
		if (Batch_TYPE.equals(recurring_journal_batchtype)) {
			System.out.println("Matched || " + " Expected Batch type is : " + Batch_TYPE+ " || Actual Batch type is : " + recurring_journal_batchtype);
			Extent_pass_New(driver, "Matched || " + " Expected Batch type is : " + Batch_TYPE+ " || Actual Batch type is : " + recurring_journal_batchtype, test, test1);
		} else {
			System.out.println("Not matched || " + " Expected Batch type is : " + Batch_TYPE+ " || Actual Batch type is : " + recurring_journal_batchtype);
			Extent_fail(driver, "Not matched || " + " Expected Batch type is : " + Batch_TYPE+ " || Actual Batch type is : " + recurring_journal_batchtype, test, test1);
		}
		waitForElement(driver, recurring_journal_No);
		String recurring_journal_No_act = getAttribute(driver, recurring_journal_No,"value");
		System.out.println(recurring_journal_No_act);
		Extent_call(test, test1, "***Recurring number was generated By[ WEEK] as***"+recurring_journal_No_act);
		Step_End(11, " Batch generated by Week . ", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}