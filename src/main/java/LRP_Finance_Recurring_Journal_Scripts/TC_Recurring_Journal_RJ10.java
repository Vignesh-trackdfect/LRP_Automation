package LRP_Finance_Recurring_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Recurring_Journal_RJ10  extends Keywords{
	public void  Recurring_Journal_RJ10(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){
		String testcase_Name="TC_Recurring_Journal_RJ10";
		
		


		String username = Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String Recurring_Journal_Module =Excel_data.get("Field_Names");
		String Select_search_recurring_journal =Excel_data.get("Select_search_recurring_journal");
		String Condition =Excel_data.get("Condition");
		String Transaction_number =Excel_data.get("Recurring_number");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, username, password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, Recurring_Journal_Module);
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			waitForElement(driver, popup_Message_No_Button);
			click(driver,popup_Message_No_Button);
		}
		Step_Start(1, "Using module search select Recurring Journal .", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		globalValueSearchWindow(driver, Condition, Select_search_recurring_journal, Transaction_number, "", "", "", "");
		Step_End(1, "Using module search select Recurring Journal .", test, test1);
		waitForElement(driver, recurring_journal_No);
		String actualTransNumber_1=getAttribute(driver, recurring_journal_No, "value");
		Step_Start(2, "Click Navigate icon on toolbar.", test, test1);
		waitForDisplay(driver, first_Common_btn);
		if(isElementAccessible(driver, first_Common_btn)) {
			Step_Start(3, "Click \"Navigate to first \" icon on toolbar able to view the first record of the recurring journal transactions .", test, test1);
			click(driver, first_Common_btn);
			waitForElement(driver, recurring_journal_No);
			String actualTransNumber_2=getAttribute(driver, recurring_journal_No, "value");
			if(!actualTransNumber_2.equals(actualTransNumber_1) && !isElementAccessible(driver, first_Common_btn)) {
				System.out.println("Not Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2);
				Extent_pass_New(driver, "Not Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2, test, test1);
				Extent_call(test, test1, "****Move to first record is navigating***");
			}else {
				System.out.println("Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2);
				Extent_call(test, test1, "****Move to first record is not navigating***");
				Extent_fail(driver, "Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2, test, test1);
			}
			Step_End(3, "Click \"Navigate to first \" icon on toolbar able to view the first record of the recurring journal transactions .", test, test1);
			waitForElement(driver, recurring_journal_No);
			String actualTransNumber_3=getAttribute(driver, recurring_journal_No, "value");
			if(isElementAccessible(driver, next_Common_btn)){
				click(driver, next_Common_btn);
				waitForElement(driver, recurring_journal_No);
				String actualTransNumber_4=getAttribute(driver, recurring_journal_No, "value");
				if(!actualTransNumber_4.equals(actualTransNumber_3)) {
					System.out.println("Not Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4);
					Extent_pass_New(driver, "Not Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4, test, test1);
					Extent_call(test, test1, "****Move to next record is navigating***");
				}else {
					System.out.println("Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4);
					Extent_fail(driver, "Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4, test, test1);
				}
			}
		}
		waitForElement(driver, recurring_journal_No);
		String actualTransNumber_5=getAttribute(driver, recurring_journal_No, "value");
		waitForDisplay(driver, prev_Common_btn);
		if(isElementAccessible(driver, prev_Common_btn)) {
			click(driver, prev_Common_btn);
			waitForElement(driver, recurring_journal_No);
			String actualTransNumber_6=getAttribute(driver, recurring_journal_No, "value");
			if(!actualTransNumber_6.equals(actualTransNumber_5)) {
				System.out.println("Not Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6);
				Extent_pass_New(driver, "Not Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6, test, test1);
				Extent_call(test, test1, "****Move to previous record is navigating***");
			}else {
				System.out.println("Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6);
				Extent_fail(driver, "Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6, test, test1);
			}
		}
		Step_Start(4, "Click \"Navigate to last \" icon on toolbar able to view the last record of the recurring journal transctions .", test, test1);
		waitForElement(driver, recurring_journal_No);
		String actualTransNumber_7=getAttribute(driver, recurring_journal_No, "value");
		waitForDisplay(driver, last_Common_btn);
		if(isElementAccessible(driver, last_Common_btn)) {
			click(driver, last_Common_btn);
			waitForElement(driver, recurring_journal_No);
			Step_End(2, "Click Navigate icon on toolbar.", test, test1);
			String actualTransNumber_8=getAttribute(driver, recurring_journal_No, "value");
			if(!actualTransNumber_8.equals(actualTransNumber_7) && !isElementAccessible(driver, last_Common_btn)) {
				System.out.println("Not Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8);
				Extent_pass_New(driver, "Not Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8, test, test1);
				Extent_call(test, test1, "****Move to last record is navigating***");
			}else {
				System.out.println("Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8);
				Extent_fail(driver, "Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8, test, test1);
			}
			Step_End(4, "Click \"Navigate to last \" icon on toolbar able to view the last record of the recurring journal transctions .", test, test1);
			Extent_completed(testcase_Name, test, test1);
		}
	}
}