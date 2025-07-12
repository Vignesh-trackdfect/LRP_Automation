package LRP_Finance_Reversal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Reversal_R01 extends Keywords{
	public void Reversal_R01(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Reversal_R01";
		// Get data from test data
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String module_Journal = Excel_data.get("Module_Journal");
		String module_Reversal = Excel_data.get("Module_Reversal");
		String datePicker = Excel_data.get("DatePicker");
		String date_Of_Reversal=Excel_data.get("Date_Of_Reversal");
		String status = Excel_data.get("Status");
		String globalSearchFilterOption_Reversal = Excel_data.get("GlobalSearchFilterOption_Reversal");
		String globalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String reversal_Status = Excel_data.get("ReversalStatus");
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
		Step_End(2, "Select Transaction type as Journal ", test, test1);
		Step_Start(3, "Select the transaction number using Search field ", test, test1);
		if(!financialYear.equals("")) {
		waitForElement(driver, financial_Year_Searchbutton_Reversal);
		click(driver, financial_Year_Searchbutton_Reversal);
		twoColumnSearchWindow(driver, financialYear_Search_Header, condition, financialYear);
		}
		waitForElement(driver, journalNo_SearchButton);
		click(driver, journalNo_SearchButton);
		globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Reversal, globalSearch_Number, Global_Search_Option2_Journal, searchValue2, Global_Search_Option3_Journal, searchValue3);
		Step_End(3, "Select the transaction number using Search field ", test, test1);
		Step_Start(4, "Transaction date will automatically populate based on the selected  transaction number", test, test1);
		waitForElement(driver, transactionNo_Textfield);
		String actualTransNo_Reversal=getAttribute(driver, transactionNo_Textfield, "value");
		waitForElement(driver, transactionDate_Textfield);
		String actualTransDate=getAttribute(driver, transactionDate_Textfield, "value");
		System.out.println("actualTransDate : "+actualTransDate);
		Step_End(4, "Transaction date will automatically populate based on the selected  transaction number", test, test1);
		Step_Start(5, "Select the Date of Reversion from the date picker ", test, test1);
		waitForElement(driver, date_Of_Reverion_Field);
		if (datePicker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, date_Of_Reverion_Field, date_Of_Reversal);
		} else {
			clearAndType(driver, date_Of_Reverion_Field, date_Of_Reversal);
			waitForElement(driver, description_textArea_Reversal);
			click(driver, description_textArea_Reversal);
		}
		waitForElement(driver, description_textArea_Reversal);
		sendKeys(driver, description_textArea_Reversal, description_Reversal);
		Step_End(5, "Select the Date of Reversion from the date picker ", test, test1);
		Step_Start(6, "Click Reverse button ", test, test1);
		waitForElement(driver, reversal_Button);
		click(driver, reversal_Button);
		Step_End(6, "Click Reverse button ", test, test1);
		Step_Start(7, "Transaction will reverse on Jouranl screen", test, test1);
//		Journal
			Extent_cal(test, test1, module_Journal);
			waitForDisplay(driver, journal_Module);
			if (isDisplayed(driver, journal_Module)) {
				Extent_pass_New(driver,"Matched || Expected Result is : "+module_Journal + " module Should be is open || Actual Result is : "+module_Journal + " module is Opened", test, test1);
				System.out.println("Matched || Expected Result is : "+module_Journal + " module Should be is open || Actual Result is : "+module_Journal + " module is Opened");
			} else {
				System.out.println("Not Matched || Expected Result is : "+module_Journal + " module Should be is open || But The Actual Result is : "+module_Journal + " module is Not Opened");
				Extent_fail(driver,"Not Matched || Expected Result is : "+module_Journal + " module Should be is open || But The Actual Result is : "+module_Journal + " module is Not Opened", test, test1);
			}
			waitForElement(driver, originalRef_Textfield);
			String actualOriginalRef=getAttribute(driver, originalRef_Textfield, "value");
			if(actualOriginalRef.equals(actualTransNo_Reversal)) {
				System.out.println("Matched || Expected Transaction Number in Reversal Module : "+actualTransNo_Reversal+" || Actual Original Ref Number in Journal Module : "+actualOriginalRef);
				Extent_pass_New(driver,"Matched || Expected Transaction Number in Reversal Module : "+actualTransNo_Reversal+" || Actual Original Ref Number in Journal Module : "+actualOriginalRef, test, test1);
			}else {
				System.out.println("Not Matched || Expected Transaction Number in Reversal Module : "+actualTransNo_Reversal+" || But The Actual Original Ref Number in Journal Module : "+actualOriginalRef);
				Extent_fail(driver,"Not Matched || Expected Transaction Number in Reversal Module : "+actualTransNo_Reversal+" || But The Actual Original Ref Number in Journal Module : "+actualOriginalRef, test, test1);
			}
			waitForElement(driver, reversalStatus);
			String actualReversalStatus=getText(driver, reversalStatus);
			if(actualReversalStatus.equals(reversal_Status)) {
				System.out.println("Matched || Expected Status Should be : "+reversal_Status+" || Actual Status is : "+actualReversalStatus);
				Extent_pass_New(driver,"Matched || Expected Status Should be : "+reversal_Status+" || Actual Status is : "+actualReversalStatus, test, test1);
			}else {
				System.out.println("Not Matched || Expected Status Should be : "+reversal_Status+" || But The Actual Status is : "+actualReversalStatus);
				Extent_fail(driver,"Not Matched || Expected Status Should be : "+reversal_Status+" || But The Actual Status is : "+actualReversalStatus, test, test1);
			}
		Step_End(7, "Transaction will reverse on Jouranl screen", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}