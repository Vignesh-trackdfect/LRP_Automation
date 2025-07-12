package LRP_Finance_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_J08 extends Keywords{
	public void Journal_J08(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Journal_J08";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String journal_Module = Excel_data.get("journal_Module");
		String Global_Search_Option1_Journal = Excel_data.get("Global_Search_Option1_Journal");
		String Global_Search_Option2_Journal = Excel_data.get("Global_Search_Option2_Journal");
		String Global_Search_Option3_Journal = Excel_data.get("Global_Search_Option3_Journal");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String Trans_Number_Input = Excel_data.get("Trans_Number_Input");
		String Doc_Status_Input = Excel_data.get("Doc_Status_Input");
		String Doc_Type_Input = Excel_data.get("Doc_Type_Input");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, journal_Module);
		Step_Start(1, "Click on global search icon in toolbar", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(1, "Click on global search icon in toolbar", test, test1);
		Step_Start(2, "Search transaction should be displayed", test, test1);
		waitForDisplay(driver, search_Transaction_Noti_Jnl);
		if(isDisplayed(driver, search_Transaction_Noti_Jnl)) {
			System.out.println("MATCHED || EXPECTED RESULT IS : SEARCH TRANSACTION PANEL SHOULD BE DISPLAY || ACTUAL RESULT IS : SEARCH TRANSACTION PANEL IS DISPLAYING");
			Extent_pass_New(driver, "MATCHED || EXPECTED RESULT IS : SEARCH TRANSACTION PANEL SHOULD BE DISPLAY || ACTUAL RESULT IS : SEARCH TRANSACTION PANEL IS DISPLAYING", test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED RESULT IS : SEARCH TRANSACTION PANEL SHOULD BE DISPLAY || ACTUAL RESULT IS : SEARCH TRANSACTION PANEL IS Not DISPLAYED");
			Extent_fail(driver, "NOT MATCHED || EXPECTED RESULT IS : SEARCH TRANSACTION PANEL SHOULD BE DISPLAY || ACTUAL RESULT IS : SEARCH TRANSACTION PANEL IS Not DISPLAYED", test, test1);
		}
		Step_End(2, "Search transaction should be displayed", test, test1);
		Step_Start(3, "Search using transaction number, document type, document status", test, test1);
		Step_Start(4, "Selected transaction should be displayed in grid", test, test1);
		Step_Start(5, "Click on the transaction to view it", test, test1);
		globalValueSearchWindow(driver, Dropdown_Condition, Global_Search_Option1_Journal, Trans_Number_Input, Global_Search_Option2_Journal, Doc_Status_Input, Global_Search_Option3_Journal, Doc_Type_Input);
		Step_End(3, "Search using transaction number, document type, document status", test, test1);
		Step_End(4, "Selected transaction should be displayed in grid", test, test1);
		waitForElement(driver, trans_Num_Field_Jnl);
		String trans_Number_Appear = getAttribute(driver, trans_Num_Field_Jnl, "value");
		if(trans_Number_Appear.equals(Trans_Number_Input)) {
			System.out.println("MATCHED || EXPECTED TRANS_NUMBER : "+Trans_Number_Input+" || ACTUAL TRANS_NUMBER :"+trans_Number_Appear);
			Extent_pass_New(driver, "MATCHED || EXPECTED TRANS_NUMBER : "+Trans_Number_Input+" || ACTUAL TRANS_NUMBER :"+trans_Number_Appear, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED TRANS_NUMBER : "+Trans_Number_Input+" || ACTUAL TRANS_NUMBER :"+trans_Number_Appear);
			Extent_fail(driver, "NOT MATCHED || EXPECTED TRANS_NUMBER : "+Trans_Number_Input+" || ACTUAL TRANS_NUMBER :"+trans_Number_Appear, test, test1);
		}
		Step_End(5, "Click on the transaction to view it", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}