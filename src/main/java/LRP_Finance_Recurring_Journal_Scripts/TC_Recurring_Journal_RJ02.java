package LRP_Finance_Recurring_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Recurring_Journal_RJ02 extends Keywords {
	public void  Recurring_Journal_RJ02(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){
		String testcase_Name="TC_Recurring_Journal_RJ02";
		
		


		String username = Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String Recurring_Journal_Module =Excel_data.get("Field_Names");
		String Select_search_recurring_journal =Excel_data.get("Select_search_recurring_journal");
		String Condition =Excel_data.get("Condition");
		String Transaction_number =Excel_data.get("Recurring_number");
		String Recurring_JV =Excel_data.get("Recurring_JV");
		String savedpopexp = Excel_data.get("savedpopexp");

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
		Step_Start(1, "Click Global search ,serach the recurring no ", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		globalValueSearchWindow(driver, Condition, Select_search_recurring_journal, Transaction_number, "", "", "", "");
		Step_End(2, "Select the transactions.", test, test1);
		Step_Start(3, "Selected journal appear in recurring journal screen ..", test, test1);
		Step_Start(4, "Click edit on toolbar .", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		Step_End(4, "Click edit on toolbar .", test, test1);
		Step_End(3, "Selected journal appear in recurring journal screen ..", test, test1);
		String girdselect = String.format(recurring_journal_select_checkbox, Recurring_JV);
		waitForElement(driver, girdselect);
		click(driver, girdselect);
		String status = String.format(recurring_journal_status, Recurring_JV);
		waitForElement(driver, status);
		String recurring_journal_statuss = getText(driver, status);
		System.out.println(recurring_journal_statuss);
		Extent_call(test, test1, "*** Batch status shown in a Recurring_journal tab before click post****"+recurring_journal_statuss);
		Step_Start(5, "Select the batch status and click post button .", test, test1);
		String postselect = String.format(recurring_journal_post_button, Recurring_JV);
		waitForElement(driver, postselect);
		click(driver, postselect);
		Step_End(5, "Select the batch status and click post button .", test, test1);
		Step_Start(6, "Selected batch posted in Journal .", test, test1);
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
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		String account_user = String.format(recurring_journal_user_tab, Recurring_JV);
		waitForElement(driver, account_user);
		String recurring_journal_user = getText(driver, account_user);
		System.out.println(recurring_journal_user);
		Extent_call(test, test1, "*** posted by shown in a Recurring_journal tab****"+recurring_journal_user);
		String posted_date= String.format(recurring_journal_posted_date, Recurring_JV);
		waitForElement(driver, posted_date);
		String recurring_journal_date = getText(driver, posted_date);
		System.out.println(recurring_journal_date);
		Extent_call(test, test1, "*** posted date shown in a Recurring_journal tab****"+recurring_journal_date);
		String dateformat = DateFormatConversion(driver, recurring_journal_date);
		System.out.println(dateformat);
		String account_num = String.format(recurring_journal_account_book_num, Recurring_JV);
		waitForElement(driver, account_num);
		String recurring_journal_No_act = getText(driver, account_num);
		System.out.println(recurring_journal_No_act);
		Extent_call(test, test1, "*** ACC_book_number shown in a Recurring_journal tab****"+recurring_journal_No_act);
		String status1 = String.format(recurring_journal_status, Recurring_JV);
		waitForElement(driver, status1);
		String recurring_journal_statuss1 = getText(driver, status1);
		System.out.println(recurring_journal_statuss1);
		Extent_call(test, test1, "*** Batch status shown in a Recurring_journal tab after click post****"+recurring_journal_statuss1);
		waitForElement(driver, recurring_journal_clicksecount_tab);
		click(driver, recurring_journal_clicksecount_tab);
		waitForElement(driver, recurring_journal_trans_tab);
		String recurring_journal_trans_num = getAttribute(driver, recurring_journal_trans_tab,"value");
		System.out.println(recurring_journal_trans_num);
		Extent_call(test, test1, "*** trans_number shown in a journal tab****"+recurring_journal_trans_num);
		if (recurring_journal_No_act.equals(recurring_journal_trans_num)) {
			System.out.println("Matched || " + " Expected trans_number is : " + recurring_journal_No_act+ " || Actual trans_number is : " + recurring_journal_trans_num);
			Extent_pass_New(driver, "Matched || " + " Expected trans_number is : " + recurring_journal_No_act+ " || Actual trans_number is : " + recurring_journal_trans_num, test, test1);
		} else {
			System.out.println("Not matched || " + " Expected trans_number is : " + recurring_journal_No_act+ " || Actual trans_number is : " + recurring_journal_trans_num);
			Extent_fail(driver, "Not matched || " + " Expected trans_number is : " + recurring_journal_No_act+ " || Actual trans_number is : " + recurring_journal_trans_num, test, test1);
		}
		waitForElement(driver, recurring_journal_userr);
		String recurring_journal_user_date= getText(driver, recurring_journal_userr);
		System.out.println(recurring_journal_user_date);
		// Find the index of the hyphen
		int hyphenIndex = recurring_journal_user_date.indexOf(" - ");
		// Get the part before the hyphen
		String beforeHyphen = recurring_journal_user_date.substring(0, hyphenIndex);
		// Get the part after the hyphen
		String afterHyphen = recurring_journal_user_date.substring(hyphenIndex + 3);  
		// Print the results
		System.out.println("Before hyphen: " + beforeHyphen);
		System.out.println("After hyphen: " + afterHyphen);    
		String recurring_journal_user_time = DateFormatConversion1(driver, afterHyphen);
		System.out.println(recurring_journal_user_time);
		if (recurring_journal_user.contains(beforeHyphen)) {
			System.out.println("Matched || " + " Expected user is : " + recurring_journal_user+ " || Actual user is : " + beforeHyphen);
			Extent_pass_New(driver, "Matched || " + " Expected user is : " + recurring_journal_user+ " || Actual user is : " + beforeHyphen, test, test1);
		} else {
			System.out.println("Not matched || " + " Expected user is : " + recurring_journal_user+ " || Actual user is : " + beforeHyphen);
			Extent_fail(driver, "Not matched || " + " Expected user is : " + recurring_journal_user+ " || Actual user is : " + beforeHyphen, test, test1);
		}
		if (dateformat.trim().contains(recurring_journal_user_time.trim())) {
			System.out.println("Matched || " + " Expected  date and time is : " + dateformat+ " || Actual date and time is : " + recurring_journal_user_time);
			Extent_pass_New(driver, "Matched || " + " Expected  date and time is : " + dateformat+ " || Actual  date and time is : " + recurring_journal_user_time, test, test1);
		} else {
			System.out.println("Not matched || " + " Expected  date and time is : " + dateformat+ " || Actual  date and time is : " + recurring_journal_user_time);
			Extent_fail(driver, "Not matched || " + " Expected  date and time is : " + dateformat+ " || Actual  date and time is : " + recurring_journal_user_time, test, test1);
		}
		if (!recurring_journal_statuss.equals(recurring_journal_statuss1)) {
			System.out.println("Matched || " + " Expected Batch status before post is : " + recurring_journal_statuss+ " || Actual Batch status after post is : " + recurring_journal_statuss1);
			Extent_pass_New(driver, "Matched || " + " Expected Batch status before post  is : " + recurring_journal_statuss+ " || Actual Batch status after post is : " + recurring_journal_statuss1, test, test1);
		} else {
			System.out.println("Not matched || " + " Expected Batch status before post is : " + recurring_journal_statuss+ " || Actual Batch status after post is : " + recurring_journal_statuss1);
			Extent_fail(driver, "Not matched || " + " Expected Batch status before post is : " + recurring_journal_statuss+ " || Actual Batch status after post is : " + recurring_journal_statuss1, test, test1);
		}
		Step_End(6, "Selected batch posted in Journal .", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}