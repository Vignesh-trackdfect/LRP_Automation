package LRP_Finance_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_J12 extends Keywords{
	public void Journal_J12(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Journal_J12";
		// Get data from test data
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String module_Journal = Excel_data.get("Module_Journal");
		String globalSearchFilterOption_Journal = Excel_data.get("GlobalSearchFilterOption_Journal");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String Global_Search_Option2_Journal = Excel_data.get("Global_Search_Option2_Journal");
		String Global_Search_Option3_Journal = Excel_data.get("Global_Search_Option3_Journal");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");
		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);
		// Login
		LRP_Login(driver, username, password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, module_Journal);
		//	Journal
		Step_Start(1, "Using module search  select Journal", test, test1);
		Extent_cal(test, test1, module_Journal);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Journal, globalSearch_Number, Global_Search_Option2_Journal, searchValue2, Global_Search_Option3_Journal, searchValue3);
		Step_End(1, "Using module search  select Journal", test, test1);
		Step_Start(2, "Click Navigate icon on toolbar.", test, test1);
		waitForElement(driver, trans_Num_Field_Jnl);
		String actualTransNumber_1=getAttribute(driver, trans_Num_Field_Jnl, "value");
		Step_Start(3, "Click \"Navigate to first \" icon on toolbar able to view the first record of the journal transactions .", test, test1);
		waitForDisplay(driver, first_Common_btn);
		if(isElementAccessible(driver, first_Common_btn)) {
			click(driver, first_Common_btn);
			waitForElement(driver, trans_Num_Field_Jnl);
			String actualTransNumber_2=getAttribute(driver, trans_Num_Field_Jnl, "value");
			if(!actualTransNumber_2.equals(actualTransNumber_1) && !isElementAccessible(driver, first_Common_btn)) {
				System.out.println("Not Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2);
				Extent_pass_New(driver, "Not Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2, test, test1);
			}else {
				System.out.println("Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2);
				Extent_fail(driver, "Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2, test, test1);
			}
			waitForElement(driver, trans_Num_Field_Jnl);
			String actualTransNumber_3=getAttribute(driver, trans_Num_Field_Jnl, "value");
			if(isElementAccessible(driver, next_Common_btn)){
				click(driver, next_Common_btn);
				waitForElement(driver, trans_Num_Field_Jnl);
				String actualTransNumber_4=getAttribute(driver, trans_Num_Field_Jnl, "value");
				if(!actualTransNumber_4.equals(actualTransNumber_3)) {
					System.out.println("Not Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4);
					Extent_pass_New(driver, "Not Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4, test, test1);
				}else {
					System.out.println("Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4);
					Extent_fail(driver, "Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4, test, test1);
				}
			}
		}
		Step_End(2, "Click Navigate icon on toolbar.", test, test1);
		Step_End(3, "Click \"Navigate to first \" icon on toolbar able to view the first record of the journal transactions .", test, test1);
		Step_Start(4, "Click \"Navigate to last \" icon on toolbar able to view the last record of the transctions", test, test1);
		waitForElement(driver, trans_Num_Field_Jnl);
		String actualTransNumber_5=getAttribute(driver, trans_Num_Field_Jnl, "value");
		waitForDisplay(driver, prev_Common_btn);
		if(isElementAccessible(driver, prev_Common_btn)) {
			click(driver, prev_Common_btn);
			waitForElement(driver, trans_Num_Field_Jnl);
			String actualTransNumber_6=getAttribute(driver, trans_Num_Field_Jnl, "value");
			if(!actualTransNumber_6.equals(actualTransNumber_5)) {
				System.out.println("Not Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6);
				Extent_pass_New(driver, "Not Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6, test, test1);
			}else {
				System.out.println("Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6);
				Extent_fail(driver, "Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6, test, test1);
			}
		}
		waitForElement(driver, trans_Num_Field_Jnl);
		String actualTransNumber_7=getAttribute(driver, trans_Num_Field_Jnl, "value");
		waitForDisplay(driver, last_Common_btn);
		if(isElementAccessible(driver, last_Common_btn)) {
			click(driver, last_Common_btn);
			waitForElement(driver, trans_Num_Field_Jnl);
			String actualTransNumber_8=getAttribute(driver, trans_Num_Field_Jnl, "value");

			if(!actualTransNumber_8.equals(actualTransNumber_7) && !isElementAccessible(driver, last_Common_btn)) {
				System.out.println("Not Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8);
				Extent_pass_New(driver, "Not Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8, test, test1);

			}else {
				System.out.println("Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8);
				Extent_fail(driver, "Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8, test, test1);
			}
		}
		Step_End(4, "Click \"Navigate to last \" icon on toolbar able to view the last record of the transctions", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
