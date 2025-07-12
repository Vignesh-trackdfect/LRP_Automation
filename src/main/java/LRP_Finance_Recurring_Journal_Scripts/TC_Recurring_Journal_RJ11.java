package LRP_Finance_Recurring_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Recurring_Journal_RJ11  extends Keywords{
	public void  Recurring_Journal_RJ11(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){
		String testcase_Name="TC_Recurring_Journal_RJ11";
		
		


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
		Step_Start(4, "Select the Batch status as Open which is created by Day ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		Step_End(3, "Selected journal appear in recurring journal screen ..", test, test1);
		String girdselect = String.format(recurring_journal_select_checkbox, Recurring_JV);
		waitForElement(driver, girdselect);
		click(driver, girdselect);
		String status = String.format(recurring_journal_status, Recurring_JV);
		waitForElement(driver, status);
		String recurring_journal_statuss = getText(driver, status);
		System.out.println(recurring_journal_statuss);
		Extent_call(test, test1, "*** Batch status shown in a Recurring_journal tab before click post****"+recurring_journal_statuss);
		Step_End(4, "Select the Batch status as Open which is created by Day ", test, test1);
		Step_Start(5, "Click Post button ..", test, test1);
		String postselect = String.format(recurring_journal_post_button, Recurring_JV);
		waitForElement(driver, postselect);
		click(driver, postselect);
		Step_End(5, "Click Post button ..", test, test1);
		Step_Start(6, " Journal Posted and status changed as Closed", test, test1);
		waitForPopup(driver, popup_Message,savedpopexp);
		String Actualpopmsg = getText(driver, popup_Message);
		System.out.println(Actualpopmsg);
		if (savedpopexp.equals(Actualpopmsg)) {
			System.out.println("Matched || " + " Expected Pop-up Value Should be : " + savedpopexp+ " || Actual Pop-up value is : " + Actualpopmsg);
			Extent_pass_New(driver,"Matched || " + " Expected Pop-up Value Should be : " + savedpopexp+ " || Actual Pop-up value is : " + Actualpopmsg, test, test1);
		} else {
			System.out.println("Not Matched || " + " Expected Pop-up Value Should be : " + savedpopexp+ " || But the Actual Pop-up value is : " + Actualpopmsg);
			Extent_fail(driver,"Not Matched || " + " Expected Pop-up Value Should be : " + savedpopexp+ " || But the Actual Pop-up value is : " + Actualpopmsg, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
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
		if (!recurring_journal_statuss.equals(recurring_journal_statuss1)) {
			System.out.println("Matched || " + " Expected Batch status before post is : " + recurring_journal_statuss+ " || Actual Batch status after post is : " + recurring_journal_statuss1);
			Extent_pass_New(driver, "Matched || " + " Expected Batch status before post  is : " + recurring_journal_statuss+ " || Actual Batch status after post is : " + recurring_journal_statuss1, test, test1);
		} else {
			System.out.println("Not matched || " + " Expected Batch status before post is : " + recurring_journal_statuss+ " || Actual Batch status after post is : " + recurring_journal_statuss1);
			Extent_fail(driver, "Not matched || " + " Expected Batch status before post is : " + recurring_journal_statuss+ " || Actual Batch status after post is : " + recurring_journal_statuss1, test, test1);
		}
		Step_End(6, " Journal Posted and status changed as Closed.", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}