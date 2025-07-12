package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.EMS_Contract_Billing_Generation;

public class TC_EMS_Contract_Billing_Generation_44 extends Keywords {

	public void Resetbilling(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		// datas was taken from xlsheet
		String testcase_Name = "TC_EMS_Contract_Billing_Generation_44";
		


		String Username = Excel_data.get("Username");// 1,2,4-6
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Field_Names");
		String Contaract_No = Excel_data.get("Contaract_No");
		String To_Month = Excel_data.get("Month");
		String To_Year = Excel_data.get("Year");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Contract_No_Perform = Excel_data.get("Contract_No_Perform");
		String Equipment_Type_Search = Excel_data.get("Contract_number_search");
		
		
		
		String month_select = String.format(EMS_Contract_Billing_Generation.month_click, To_Month);

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		
		// login
		LRP_Login(driver, Username, Password);
		moduleNavigate(driver, Search);
		Step_Start(1, " Click add button & select contract no accordingly", test, test1);

		// Adding the contract number

		if (Contract_No_Perform.equals("YES")) {

			List<String> datas = splitAndExpand1(Contaract_No);
			for (String data : datas) {
				waitForElement(driver, Aaddbuttonforcontract);
				safeclick(driver, Aaddbuttonforcontract);
				waitForElement(driver, Ainputcontractnum);
				twoColumnSearchWindow(driver, Equipment_Type_Search, Condition_Filter, data);
			}
		} else {
			
			System.out.println("If Contract_No_Perform is No ||  Expected Result is : Contract type should not be added  || Actual Result is : Contract type is not  added ");
			Extent_pass_New(driver, "If Contract_No_Perform is No ||  Expected Result is : Contract type should not be added  || Actual Result is : Contract type is not  added ", test, test1);
		}
		Step_End(1, " Click add button & select contract no accordingly", test, test1);
		Step_Start(2, " Select Billing period for months & year accordingly", test, test1);
		// selecting the month and year

		waitForElement(driver, AMonthclick);
		safeclick(driver, AMonthclick);
		if (isDisplayed(driver, Monthdroupdwn)) {
			waitForElement(driver, AMonthclick);
			waitForElement(driver, month_select);
			safeclick(driver, month_select);

			waitForElement(driver, yeardroupdwn);
			clearAndType(driver, yeardroupdwn, To_Year);

			Step_End(2, " Select Billing period for months & year accordingly", test, test1);
			Step_Start(3, "type should be by default selected as By Contract", test, test1);
			
			Step_End(3, "type should be by default selected as By Contract", test, test1);

			Step_Start(5, "Click show button once generate message shown", test, test1);
			// safeclick on show bills

			waitForElement(driver, AShowbills);
			safeclick(driver, AShowbills);
			waitForElement(driver, AGriedContractnumber);
			Step_End(5, "Click show button once generate message shown", test, test1);
			Step_Start(6, "System should listing billing details once required button is pressed", test, test1);
			waitForElement(driver, contractnumbersearch);
			// searching the contract number in the gird

			List<String> datas = splitAndExpand1(Contaract_No);

			for (String data : datas) {
				waitForElement(driver, contractnumbersearch);
				clearAndType(driver, contractnumbersearch, data);

				if (formatLocatorIsDisplayed(driver, contract_se, data)) {
					System.out.println("Expected Result is : Contract Number should display in the grid :"+  data + " Actula Result is : Contract Number should display in the grid :"+  data  );
					Extent_pass_New(driver, "Expected Result is : Contract Number should display in the grid :"+  data + " Actula Result is : Contract Number should display in the grid :"+  data  , test, test1);

					scrollUsingElement(driver, Approved);

					// searching the contract number in the normal billing

					if (formatLocatorIsDisplayed(driver, ref_num, data)) {
						System.out.println("Expected Result is : contract number should be displayed in gird as Reference number as" + data+" Actual Result is :contract number is  displayed in gird as Reference number as" + data);
						Extent_pass_New(driver,
								"Expected Result is : contract number should be displayed in gird as Reference number as" + data+" Actual Result is :contract number is  displayed in gird as Reference number as" + data,
								test, test1);
					} else {
						System.out.println("Expected Result is : contract number should be displayed in gird as Reference number as" + data+" Actual Result is :contract number is  not displayed in gird as Reference number as" + data);
						Extent_fail(driver, "Expected Result is : contract number should be displayed in gird as Reference number as" + data+" Actual Result is :contract number is  not displayed in gird as Reference number as" + data, test, test1);
						
					}
					
				}
			}
			Step_End(6, "System should listing billing details once required button is pressed", test, test1);
			scrollTop(driver);
			Step_Start(7, "Click reset button & grid details should be get cleared", test, test1);
			waitForElement(driver, ResetButton);
			safeclick(driver, ResetButton);

			waitForDisplay(driver, Girdtable);
			if (isDisplayed(driver, Girdtable)) {
				System.out.println("Expected Result is : Grid Values should not be cleared after clicking the reset button || Actual Result is :  Grid Values is not cleared after clicking the reset button");
				Extent_fail(driver, "Expected Result is : Grid Values should not be cleared after clicking the reset button || Actual Result is :  Grid Values is not cleared after clicking the reset button", test, test1);

			} else {
				System.out.println("Expected Result is : Grid Values should not be cleared after clicking the reset button || Actual Result is :  Grid Values is  cleared after clicking the reset button");
				Extent_pass_New(driver, "Expected Result is : Grid Values should not be cleared after clicking the reset button || Actual Result is :  Grid Values is  cleared after clicking the reset button", test, test1);

			}
			Step_End(7, "Click reset button & grid details should be get cleared", test, test1);
			Extent_completed(testcase_Name, test, test1);
		}
	}

}
