package LRP_Finance_Recurring_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Recurring_Journal_RJ08  extends Keywords{
	public void  Recurring_Journal_RJ08(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){
		String testcase_Name="TC_Recurring_Journal_RJ08";
		
		


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
		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		Step_End(3, "Selected journal appear in recurring journal screen ..", test, test1);
		String girdselect = String.format(recurring_journal_select_checkbox, Recurring_JV);
		waitForElement(driver, girdselect);
		click(driver, girdselect);
		Step_Start(4, " Click \"Remove\" button . .", test, test1);
		waitForElement(driver, recurring_journal_remove_button);
		click(driver, recurring_journal_remove_button);
		Step_End(4, " Click \"Remove\" button . .", test, test1);
		Step_Start(5, "Journal removed in that screen.", test, test1);
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
		waitForDisplay(driver, girdselect);
		if(!isDisplayed(driver, girdselect)) {
			System.out.println("Matched || Expected Result is : Journal  Should be Remove || Actual Result is : Journal was Removed");
			Extent_pass_New(driver,"Matched || Expected Result is : Journal  Should be Remove || Actual Result is : Journal was Removed", test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : Journal  Should be Remove || But Actual Result is : Journal was Not Removed");
			Extent_fail(driver,"Not Matched || Expected Result is : Journal  Should be Remove || But Actual Result is : Journal was Not Removed", test, test1);
		}
		Step_End(5, "Journal removed in that screen.", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}