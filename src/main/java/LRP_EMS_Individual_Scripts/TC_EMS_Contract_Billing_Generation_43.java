package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.EMS_Contract_Billing_Generation;

public class TC_EMS_Contract_Billing_Generation_43 extends Keywords {
	public void generatebilling(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		// datas was taken from xlsheet
		String testcase_Name = "TC_EMS_Contract_Billing_Generation_43";
		
		

		
		
	
		
		String Username = Excel_data.get("Username");// 1,2,4-6
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Field_Names");
		String Contaract_No = Excel_data.get("Contaract_No");
		String To_Month = Excel_data.get("Month");
		String To_Year = Excel_data.get("Year");
		String passwordinptdata44 = Excel_data.get("Password_Popup_Input");
		String Bills_Generated_Popup = Excel_data.get("Bills_Generated_Popup");
		String Contract_No_Perform = Excel_data.get("Contract_No_Perform");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Equipment_Type_Search = Excel_data.get("Contract_number_search");
		
		
		String month_select =  String.format(EMS_Contract_Billing_Generation.month_click,To_Month); 

		Extent_Start(testcase_Name, test, test1);
		

		navigateUrl(driver, url);

//login
		LRP_Login(driver, Username, Password);
		moduleNavigate(driver, Search);
		Step_Start(1, " Click add button & select contract no accordingly ",test, test1);
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
			System.out.println("Expected result is : Contract type should not be added || Actual Result is : Contract type is not be added ");
			Extent_fail(driver, "Expected result is : Contract type should not be added || Actual Result is : Contract type is not be added ", test, test1);
		}

		Step_End(1, " Click add button & select contract no accordingly ",test, test1);
		Step_Start(2, " Select Billing period for months & year accordingly ",test, test1);
		// selecting the month and year

		waitForElement(driver, AMonthclick);
		safeclick(driver, AMonthclick);
		if (isDisplayed(driver, Monthdroupdwn)) {
			waitForElement(driver, AMonthclick);
	
				waitForElement(driver, month_select);
				safeclick(driver, month_select);

				waitForElement(driver, yeardroupdwn);
				clearAndType(driver, yeardroupdwn, To_Year);
				Step_End(2, " Select Billing period for months & year accordingly ",test, test1);
				Step_Start(3, "  type should be by default selected as By Contract ",test, test1);
				Step_End(3, "  type should be by default selected as By Contract ",test, test1);
				Step_Start(4, " Click Generate bills button & message will be shown",test, test1);
			// safeclick on generate bill
			waitForElement(driver, Ageneratebill);
			safeclick(driver, Ageneratebill);
			Step_End(4, " Click Generate bills button & message will be shown",test, test1);
	
			// entering the password

			waitForElement(driver, APasswordInput);
			sendKeys(driver, APasswordInput, passwordinptdata44);
		

			waitForElement(driver, APasswordInputOK);
			safeclick(driver, APasswordInputOK);

			waitForElement(driver, popup_Message_Yes_Button);
			safeclick(driver, popup_Message_Yes_Button);
			
 
			waitForDisplay(driver, Popup_Message);
			if (isDisplayed(driver, Popup_Message)) {

				String PopforGENERATINGEXisitingAct = getText(driver, Popup_Message);
				System.out.println(PopforGENERATINGEXisitingAct);

				if (PopforGENERATINGEXisitingAct.contains(Bills_Generated_Popup)) {
					System.out.println("Matched || " + " Expected Activity is : " + Bills_Generated_Popup
							+ " || Actual Activity is : " + PopforGENERATINGEXisitingAct);
					Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Bills_Generated_Popup
							+ " ||Actual Activity is : " + PopforGENERATINGEXisitingAct, test, test1);
					Extent_call(test, test1, PopforGENERATINGEXisitingAct);
				} else {
					System.out.println("Not matched || " + "Expected Activity is : " + Bills_Generated_Popup
							+ " || Actual Activity is : " + PopforGENERATINGEXisitingAct);
					Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Bills_Generated_Popup
							+ " || Lessor Bill not Upload Excel Sheet is uploaded : " + PopforGENERATINGEXisitingAct,
							test, test1);
					
				}
			} else {
				System.out.println("Expected Result is : Bill should already generated || Actual Result is : Bill is already generated");
				Extent_fail(driver, "Expected Result is : Bill should already generated || Actual Result is : Bill is already generated", test, test1);
			}
			Step_Start(5, "-Click show button once generate message shown",test, test1);
			
			// safeclick on show bills

			waitForElement(driver, AShowbills);
			safeclick(driver, AShowbills);
			waitForElement(driver, AGriedContractnumber);

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
					Step_End(5, "-Click show button once generate message shown",test, test1);
					
				}
			}

		}
		Extent_completed(testcase_Name, test, test1);
	}

}
