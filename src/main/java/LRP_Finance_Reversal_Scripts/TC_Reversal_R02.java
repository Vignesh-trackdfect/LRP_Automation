package LRP_Finance_Reversal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Reversal_R02 extends Keywords{
	public void Reversal_R02(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Reversal_R02";
		// Get data from test data
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String module_Reversal = Excel_data.get("Module_Reversal");
		String datePicker = Excel_data.get("DatePicker");
		String date_Of_Reversal=Excel_data.get("Date_Of_Reversal");
		String status = Excel_data.get("Status");
		String globalSearchFilterOption_Reversal = Excel_data.get("GlobalSearchFilterOption_Reversal");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String transactionDatePopup = Excel_data.get("TransactionDatePopup");
		String description_Reversal = Excel_data.get("Description_Reversal");
		String financialYear = Excel_data.get("FinancialYear");
		String condition = Excel_data.get("Condition");
		String financialYear_Search_Header = Excel_data.get("FinancialYear_Search_Header");
		String Global_Search_Option2_Journal = Excel_data.get("Global_Search_Option2_Journal");
		String Global_Search_Option3_Journal = Excel_data.get("Global_Search_Option3_Journal");
		String searchValue2 = Excel_data.get("searchValue2");
		String searchValue3 = Excel_data.get("searchValue3");
		
		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);
		// Login
		LRP_Login(driver, username, password);
		Step_Start(1, "Using module search , Select Reversal ", test, test1);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, module_Reversal);
//	Reversal
		Extent_cal(test, test1, module_Reversal);
		Step_End(1, "Using module search , Select Reversal ", test, test1);
		Step_Start(2, "Select Transaction type as Journal ", test, test1);
		waitForElement(driver, journal_Button);
		String actualStatus=getAttribute(driver, journal_Button, "class");
		if(!actualStatus.contains(status)) {
			click(driver, journal_Button);
		}
		if(!financialYear.equals("")) {
			waitForElement(driver, financial_Year_Searchbutton_Reversal);
			click(driver, financial_Year_Searchbutton_Reversal);
			twoColumnSearchWindow(driver, financialYear_Search_Header, condition, financialYear);
			}
		Step_End(2, "Select Transaction type as Journal ", test, test1);
		Step_Start(3, "Select the transaction number using Search field ", test, test1);
		waitForElement(driver, journalNo_SearchButton);
		click(driver, journalNo_SearchButton);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Reversal, globalSearch_Number, Global_Search_Option2_Journal, searchValue2, Global_Search_Option3_Journal, searchValue3);
		Step_End(3, "Select the transaction number using Search field ", test, test1);
		Step_Start(4, "Transaction date will automatically populate based on the selected  transaction number", test, test1);
		waitForElement(driver, transactionDate_Textfield);
		String actualTransDate=getAttribute(driver, transactionDate_Textfield, "value");
		System.out.println("actualTransDate : "+actualTransDate);
		Step_End(4, "Transaction date will automatically populate based on the selected  transaction number", test, test1);
		Step_Start(5, "Select the Date of Reversion from the date picker ", test, test1);
		waitForElement(driver, date_Of_Reverion_Field);
		click(driver, date_Of_Reverion_Field);
		Step_End(5, "Select the Date of Reversion from the date picker ", test, test1);
		Step_Start(6, "Select the date which is lesser than the original transaction date", test, test1);
		if (datePicker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, date_Of_Reverion_Field, date_Of_Reversal);
		} else {
			clearAndType(driver, date_Of_Reverion_Field, date_Of_Reversal);
			waitForElement(driver, description_textArea_Reversal);
			click(driver, description_textArea_Reversal);
		}
		waitForElement(driver, description_textArea_Reversal);
		sendKeys(driver, description_textArea_Reversal, description_Reversal);
		Step_End(6, "Select the date which is lesser than the original transaction date", test, test1);
		Step_Start(7, "Click Reverse button", test, test1);
		waitForElement(driver, reversal_Button);
		click(driver, reversal_Button);
		Step_End(7, "Click Reverse button", test, test1);
		Step_Start(8, "It showing the validation as \"Date of Reversion is always greater than the Original date\"", test, test1);
		waitForPopup(driver, popup_Message,transactionDatePopup);
		String actualPopup=getText(driver, popup_Message);
		if(actualPopup.equals(transactionDatePopup)) {
			System.out.println("Matched || Expected Pop-up Value is : "+transactionDatePopup+" || Actual Pop-up value is : "+actualPopup);
			Extent_pass_New(driver,"Matched || Expected Pop-up Value is : "+transactionDatePopup+" || Actual Pop-up value is : "+actualPopup, test, test1);
			click(driver, popup_Message_Ok_Button);	
		}else {
			System.out.println("Not Matched || Expected Pop-up Value is : "+transactionDatePopup+" || But The Actual Pop-up value is : "+actualPopup);
			Extent_fail(driver,"Not Matched || Expected Pop-up Value is : "+transactionDatePopup+" || But The Actual Pop-up value is : "+actualPopup, test, test1);
		}
		Step_End(8, "It showing the validation as \"Date of Reversion is always greater than the Original date\"", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}