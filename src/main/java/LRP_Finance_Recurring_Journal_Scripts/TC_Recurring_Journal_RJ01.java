package LRP_Finance_Recurring_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Recurring_Journal_RJ01 extends Keywords{
	public void  Recurring_Journal_RJ01(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){
		String testcase_Name="TC_Recurring_Journal_RJ01";
		
		


		String username = Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String Recurring_Journal_Module =Excel_data.get("Field_Names");
		String Select_search_recurring_journal =Excel_data.get("Select_search_recurring_journal");
		String Condition =Excel_data.get("Condition");
		String Transaction_number =Excel_data.get("Transaction_number");
		String Day_Perform =Excel_data.get("Day_Perform");
		String Day_Input =Excel_data.get("Day_Input");
		String Week_Perform =Excel_data.get("Week_Perform");
		String Week_Input =Excel_data.get("Week_Input");
		String Week_day_click =Excel_data.get("Week_day_click");
		String Month_Day_Select =Excel_data.get("Month_Day_Select");
		String Month_Perform =Excel_data.get("Month_Perform");
		String Day_input_for_month =Excel_data.get("Day_input_for_month");
		String Year_Perform =Excel_data.get("Year_Perform");
		String Year_Input = Excel_data.get("Year_Input");
		String year_Day_Selectt = Excel_data.get("year_Day_Selectt");
		String Day_input_for_Year = Excel_data.get("Day_input_for_Year");
		String Month_input_for_Year = Excel_data.get("Month_input_for_Year");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String From_date_perform = Excel_data.get("From_date_perform");
		String End_Date_input = Excel_data.get("End_Date_input");
		String End_Date_Perform = Excel_data.get("End_Date_Perform");
		String select_value_gird = Excel_data.get("select_value_gird");
		String savedpopexp = Excel_data.get("savedpopexp");
		String Month_Input = Excel_data.get("Month_Input");

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
		Step_Start(5, "Select the day or week or month or year option .", test, test1);
		if(Day_Perform.equalsIgnoreCase("YES")) {
			Step_Start(6, "Enter the count of days", test, test1);
			waitForElement(driver, Day_input);
			sendKeys(driver, Day_input,Day_Input);
		}
		if(Week_Perform.equalsIgnoreCase("YES")) {
			checkBox(driver, week_radio_button, Week_Perform);
			waitForElement(driver, week_input);
			sendKeys(driver, week_input,Week_Input);
			String weekclick = String.format(week_days_click, Week_day_click);
			waitForElement(driver, weekclick);
			click(driver, weekclick);
		}
		if(Month_Perform.equalsIgnoreCase("YES")) {
			checkBox(driver, month_radio_button, Month_Perform);
			waitForElement(driver, month_input);
			sendKeys(driver, month_input,Month_Input);
			String monthclick = String.format(month_days_click, Month_Day_Select);
			waitForElement(driver, monthclick);
			click(driver, monthclick);
			if(Month_Day_Select.equalsIgnoreCase("Day")) {
				waitForElement(driver, day_drop_click);
				click(driver, day_drop_click);
				String dayselect = String.format(day_drop_select_click, Day_input_for_month);
				waitForElement(driver, dayselect);
				click(driver, dayselect);

			}
		}
		if(Year_Perform.equalsIgnoreCase("YES")) {
			checkBox(driver, year_radio_button, Year_Perform);
			waitForElement(driver, year_input);
			sendKeys(driver, year_input,Year_Input);
			Step_End(6, "Enter the count of days", test, test1);
			String monthclick = String.format(year_days_click,year_Day_Selectt);
			waitForElement(driver, monthclick);
			click(driver, monthclick);
			if(year_Day_Selectt.equalsIgnoreCase("Day")) {
				waitForElement(driver, day_drop_click);
				click(driver, day_drop_click);
				String dayselectyear = String.format(day_drop_click_year, Day_input_for_Year);
				waitForElement(driver, dayselectyear);
				click(driver, dayselectyear);
				waitForElement(driver, year_month_click_drop);
				click(driver, year_month_click_drop);
				String monthselectyear = String.format(day_drop_select_click1, Month_input_for_Year);
				waitForElement(driver, monthselectyear);
				click(driver, monthselectyear);
			}
		}
		Step_Start(7, "Select the start date from the date picker.", test, test1);
		waitForElement(driver, start_date);
		if (From_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, start_date, From_Date_Input);
		} else {
			waitForElement(driver, start_date);
			clearAndType(driver, start_date, From_Date_Input);
		}
		Step_End(7, "Select the start date from the date picker.", test, test1);
		Step_Start(8, "Select the end date from the date picker .", test, test1);
		waitForElement(driver, end_date);
		if (End_Date_Perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, end_date, End_Date_input);
		} else {
			waitForElement(driver, No_end_date_radio_button);
			click(driver, No_end_date_radio_button);
		}
		Step_End(8, "Select the end date from the date picker .", test, test1);
		Step_End(5, "Select the day or week or month or year option .", test, test1);
		Step_Start(9, "Click Generate Button.", test, test1);
		waitForElement(driver, generate_button);
		click(driver, generate_button);
		Step_End(9, "Click Generate Button.", test, test1);
		String gird = String.format(select_row, select_value_gird);
		waitForElement(driver, gird);
		click(driver, gird);
		scrollTop(driver);
		Step_Start(11, " Click Save on toolbar .", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(11, " Click Save on toolbar .", test, test1);
		Step_Start(12, " Saved successfully ..", test, test1);
		waitForPopup(driver, popup_Message,savedpopexp);
		String Actualpopmsg = getText(driver, popup_Message);
		System.out.println(Actualpopmsg);
		if (savedpopexp.equals(Actualpopmsg)) {
			System.out.println("Matched || " + " Expected Pop-up value is : " + savedpopexp+ " || Actual Pop-up value is : " + Actualpopmsg);
			Extent_pass_New(driver, "Matched || " + " Expected Pop-up value is : " + savedpopexp+ " || Actual Pop-up value is : " + Actualpopmsg, test, test1);
			Extent_call(test, test1, Actualpopmsg);
		} else {
			System.out.println("Not matched || " + " Expected Pop-up value is : " + savedpopexp+ " || Actual Pop-up value is : " + Actualpopmsg);
			Extent_fail(driver, "Not matched || " + " Expected Pop-up value is : " + savedpopexp+ " || Actual Pop-up value is : " + Actualpopmsg, test, test1);
		}
		Step_End(12, " Saved successfully ..", test, test1);
		click(driver, popup_Message_Ok_Button);
		Step_Start(10, " batch generated in recurring journal screen ", test, test1);
		waitForElement(driver, recurring_journal_No);
		String recurring_journal_No_act = getAttribute(driver, recurring_journal_No,"value");
		System.out.println(recurring_journal_No_act);
		Extent_call(test, test1, "***Recurring number was generated as***"+recurring_journal_No_act);
		Step_End(10, " batch generated in recurring journal screen ", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}