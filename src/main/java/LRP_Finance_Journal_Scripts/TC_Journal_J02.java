package LRP_Finance_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_J02 extends Keywords{
	public void Journal_J02(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Journal_J02";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String journal_Module = Excel_data.get("journal_Module");
		String Global_Search_Option1_Journal = Excel_data.get("Global_Search_Option1_Journal");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String Doc_Type_Input = Excel_data.get("Doc_Type_Input");
		String amount_Txtfield_Data = Excel_data.get("amount_Txtfield_Data");
		String updated_Popup_Expected = Excel_data.get("updated_Popup_Expected");
		String Global_Search_Option2_Journal = Excel_data.get("Global_Search_Option2_Journal");
		String Global_Search_Option3_Journal = Excel_data.get("Global_Search_Option3_Journal");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Retrieve the record to be edited", test, test1);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, journal_Module);
		Step_Start(3, "Double click the saved record from the grid that you are going to edit", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Dropdown_Condition, Global_Search_Option1_Journal, Doc_Type_Input, Global_Search_Option2_Journal, searchValue2, Global_Search_Option3_Journal, searchValue3);
		Step_End(1, "Retrieve the record to be edited", test, test1);
		Step_End(3, "Double click the saved record from the grid that you are going to edit", test, test1);
		Step_Start(2, "Click edit on toolbar", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(2, "Click edit on toolbar", test, test1);
		Step_Start(4, "Edit the fields except the trans number", test, test1);
		// 1st row
		waitForElement(driver, journal_Table_First_Row_Fourth_Cell);
		doubleClick(driver, journal_Table_First_Row_Fourth_Cell);
		waitForElement(driver, amount_Txtfield_Jnl);
		click(driver, amount_Txtfield_Jnl);
		clearAndType(driver, amount_Txtfield_Jnl, amount_Txtfield_Data);
		waitForElement(driver, plus_Btn_Jnl);
		click(driver, plus_Btn_Jnl);
		
		waitForDisplay(driver, ok_Btn_Jnl);
		if(isdisplayed(driver, ok_Btn_Jnl)) {
			click(driver, ok_Btn_Jnl);
			
		}
		// 2nd row
		waitForElement(driver, journal_Table_Second_Row_Fourth_Cell);
		doubleClick(driver, journal_Table_Second_Row_Fourth_Cell);
		waitForElement(driver, amount_Txtfield_Jnl);
		click(driver, amount_Txtfield_Jnl);
		clearAndType(driver, amount_Txtfield_Jnl, amount_Txtfield_Data);
		waitForElement(driver, plus_Btn_Jnl);
		click(driver, plus_Btn_Jnl);
		
		waitForDisplay(driver, ok_Btn_Jnl);
		if(isdisplayed(driver, ok_Btn_Jnl)) {
			click(driver, ok_Btn_Jnl);
			
		}
	
		
		Step_End(4, "Edit the fields except the trans number", test, test1);
		Step_Start(5, "Check whether the sum of debit and credit should be the same", test, test1);
		waitForElement(driver, debit_Value_Jnl);
		String debit_Value = getText(driver, debit_Value_Jnl);
		waitForElement(driver, credit_Value_Jnl);
		String credit_Value = getText(driver, credit_Value_Jnl);
		if (debit_Value.equals(credit_Value)) {
			System.out.println("MATCHED || DEBIT VALUE : " + debit_Value + " || CREDIT VALUE : " + credit_Value);
			Extent_pass_New(driver, "MATCHED || DEBIT VALUE : " + debit_Value + " || CREDIT VALUE : " + credit_Value,test, test1);
		} else {
			System.out.println("NOT MATCHED || DEBIT VALUE : " + debit_Value + " || CREDIT VALUE : " + credit_Value);
			Extent_fail(driver,"NOT MATCHED || DEBIT VALUE : " + debit_Value + " || CREDIT VALUE : " + credit_Value, test,test1);
		}
		Step_End(5, "Check whether the sum of debit and credit should be the same", test, test1);
		Step_Start(6, "Click save on toolbar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(6, "Click save on toolbar", test, test1);
		Step_Start(7, "Now edited records should be saved", test, test1);
		waitForPopup(driver, popup_Message,updated_Popup_Expected);
		String updated_Popup_Actual = getText(driver, popup_Message);
		if (updated_Popup_Actual.equals(updated_Popup_Expected)) {
			System.out.println("MATCHED ||EXPECTED UPDATED Pop-up value is : " + updated_Popup_Expected+ " || ACTUAL UPDATED Pop-up value is: " + updated_Popup_Actual);
			Extent_pass_New(driver, "MATCHED ||EXPECTED UPDATED Pop-up value is : " + updated_Popup_Expected+ " || ACTUAL UPDATED Pop-up value is: " + updated_Popup_Actual, test, test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("NOT MATCHED ||EXPECTED UPDATED Pop-up value is : " + updated_Popup_Expected+ " || ACTUAL UPDATED Pop-up value is: " + updated_Popup_Actual);
			Extent_fail(driver, "NOT MATCHED ||EXPECTED UPDATED Pop-up value is : " + updated_Popup_Expected+ " || ACTUAL UPDATED Pop-up value is: " + updated_Popup_Actual, test, test1);
		}
		Step_End(7, "Now edited records should be saved", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}