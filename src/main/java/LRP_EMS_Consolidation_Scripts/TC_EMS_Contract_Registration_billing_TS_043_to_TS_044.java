package LRP_EMS_Consolidation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.EMS_Contract_Billing_Generation;

public class TC_EMS_Contract_Registration_billing_TS_043_to_TS_044 extends Keywords {
	public void Ems_billing_044_045(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset)
			throws Exception {
 int LT1=1;
	     
	     if(LT1==1) {
		// datas was taken from xlsheet
		String testcase_Name1 = "TC_EMS_Contract_Billing_Generation_43";
		String URL = TestNgXml.getdatafromExecution().get(testcase_Name1);
		String File_Path1 = TestNgXml.getfilePath_FromExecution().get(testcase_Name1);
		String Sheet_Name1 = TestNgXml.getsheetName_FromExecution().get(testcase_Name1);
		System.out.println(Sheet_Name1);

		Map<String, String> data1 = Utils.GetAllData(Sheet_Name1, testcase_Name1, "Dataset" + selected_dataset, File_Path1);
		
		
	
		
		String Username = data1.get("Username");// 1,2,4-6
		String Password = data1.get("Password");
		String Condition_Filter = data1.get("Condition_Filter");
		
	    	 String Search = data1.get("Field_Names");
	 		String Contaract_No = data1.get("Contaract_No");
	 		String To_Month = data1.get("Month");
	 		String To_Year = data1.get("Year");
	 		String passwordinptdata44 = data1.get("Password_Popup_Input");
	 		String Bills_Generated_Popup = data1.get("Bills_Generated_Popup");
	 		String Contract_No_Perform = data1.get("Contract_No_Perform");
	 		String month_select =  String.format(EMS_Contract_Billing_Generation.month_click,To_Month); 
	 		String Equipment_Type_Search = data1.get("Contract_number_search");
	 		Extent_Start(testcase_Name1, test, test1);
	 		


			navigateUrl(driver, URL);

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
				waitForDisplay(driver, File_Path1);
		
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
				
//				if (isDisplayed(driver, popup_Message_Ok_Button)) {
//					waitForElement(driver, popup_Message_Ok_Button);
//					System.out.println("Expected Result is : Bill should already generated || Actual Result is : Bill is already generated");
//					safeclick(driver, popup_Message_Ok_Button);
//				} else {
//					System.out.println("Expected Result is : Bill should already generated || Actual Result is : Bill is  generated newly");
//				}
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
			Extent_completed(testcase_Name1, test, test1);
	     
			}

		
			     scrollTop(driver);
			  
			     click(driver, Close_Current_tab); 		

		 int LT2=2;
			     
			     if(LT2==2) {
			    	 
			    	 String testcase_Name = "TC_EMS_Contract_Billing_Generation_44";
			 		String File_Path = TestNgXml.getfilePath_FromExecution().get(testcase_Name);
			 		String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testcase_Name);
			 		System.out.println(Sheet_Name);

			 		Map<String, String> data1 = Utils.GetAllData(Sheet_Name, testcase_Name, "Dataset" + selected_dataset,
			 				File_Path);

			 		String Search = data1.get("Field_Names");
			 		String Contaract_No = data1.get("Contaract_No");
			 		String To_Month = data1.get("Month");
			 		String To_Year = data1.get("Year");
			 		String Condition_Filter = data1.get("Condition_Filter");
			 		String Contract_No_Perform = data1.get("Contract_No_Perform");
			 		String Equipment_Type_Search = data1.get("Contract_number_search");
			 		String month_select = String.format(EMS_Contract_Billing_Generation.month_click, To_Month);

			 		Extent_Start(testcase_Name, test, test1);

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
						
						System.out.println("Expected Result is : Contract type should not be added  || Actual Result is : Contract type is not  added ");
						Extent_pass_New(driver, "Expected Result is : Contract type should not be added  || Actual Result is : Contract type is not  added ", test, test1);
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

							String contract_select = String.format(EMS_Contract_Billing_Generation.contract_se, data);
							if (isDisplayed(driver, contract_select)) {
								System.out.println("contract number was displayed in gird as" + data);
								Extent_pass_New(driver, "**contract number was displayed in gird as**" + data, test, test1);

								scrollUsingElement(driver, Approved);

								// searching the contract number in the normal billing

								String Reference_number = String.format(EMS_Contract_Billing_Generation.ref_num, data);
								
								if (isDisplayed(driver, Reference_number)) {
									System.out.println("Expected Result is : contract number should be displayed in gird as Reference number as" + data+" Actual Result is :contract number is  displayed in gird as Reference number as" + data);
									Extent_pass_New(driver,
											"Expected Result is : contract number should be displayed in gird as Reference number as" + data+" Actual Result is :contract number is  displayed in gird as Reference number as" + data,
											test, test1);
									Extent_pass_New(driver, "****Contract No was Present in reference  coloum ****", test, test1);
									Extent_call(test, test1, "****contract number was displayed in the  Reference field in the gird  as***" + data);
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
 
			 
	}