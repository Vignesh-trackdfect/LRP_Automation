package LRP_Finance_Supplier_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Supplier_Invoice_S14  extends Keywords{

	public void Supplier_Invoice_S14 (WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Supplier_Invoice_S14";
		// Get data from test data

		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String module_Name = Excel_data.get("Field_Names");
		String GlobalSearchFilterOption_Billing_Invoice = Excel_data.get("GlobalSearchFilterOption_Billing_Invoice");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String globalSearch_Number = Excel_data.get("Transaction_number");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);

		moduleNavigate(driver, module_Name);

		Step_Start(1, "Using module search  select  supplier invoice", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);


		
		globalValueSearchWindow(driver, dropdownCondition, GlobalSearchFilterOption_Billing_Invoice, globalSearch_Number, "","", "", "");

		Step_End(1, "Using module search  select  supplier invoice", test, test1);
		Step_Start(2, "Click Navigate icon on toolbar", test, test1);

		waitForElement(driver, supplier_trans_number);
		String actualTransNumber_1=getAttribute(driver, supplier_trans_number, "value");



		Step_Start(3, "Click Navigate to first  icon on toolbar able to view the firsr record of the supplier invoice transactions ", test, test1);


		waitForDisplay(driver, navigate_Button_First_SI);
		if(isElementAccessible(driver, navigate_Button_First_SI)) {
			click(driver, navigate_Button_First_SI);
			waitForElement(driver, supplier_trans_number);
			String actualTransNumber_2=getAttribute(driver, supplier_trans_number, "value");

			if(!actualTransNumber_2.equals(actualTransNumber_1) && !isElementAccessible(driver, navigate_Button_First_SI)) {
				System.out.println("Not Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2);
				Extent_pass_New(driver, "Not Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2, test, test1);
			}else {
				System.out.println("Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2);
				Extent_fail(driver, "Matched || Trans Number before navigate to First : "+actualTransNumber_1+" || Trans Number after navigate to First : "+actualTransNumber_2, test, test1);
			}
			waitForElement(driver, supplier_trans_number);
			String actualTransNumber_3=getAttribute(driver, supplier_trans_number, "value");

			if(isElementAccessible(driver, navigate_Next_Button_SI)){
				click(driver, navigate_Next_Button_SI);
				waitForElement(driver, supplier_trans_number);
				String actualTransNumber_4=getAttribute(driver, supplier_trans_number, "value");

				if(!actualTransNumber_4.equals(actualTransNumber_3)) {
					System.out.println("Not Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4);
					Extent_pass_New(driver, "Not Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4, test, test1);
				}else {
					System.out.println("Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4);
					Extent_fail(driver, "Matched || Trans Number before navigate to next : "+actualTransNumber_3+" || Trans Number after navigate to next : "+actualTransNumber_4, test, test1);
				}
			}
		}


		Step_End(3, "Click Navigate to first  icon on toolbar able to view the firsr record of the supplier invoice transactions ", test, test1);
		Step_Start(4, "Click Navigate to last  icon on toolbar able to view the last record of the transctions", test, test1);

		waitForElement(driver, supplier_trans_number);
		String actualTransNumber_5=getAttribute(driver, supplier_trans_number, "value");

		waitForDisplay(driver, navigate_Previous_Button_SI);
		if(isElementAccessible(driver, navigate_Previous_Button_SI)) {
			click(driver, navigate_Previous_Button_SI);
			waitForElement(driver, supplier_trans_number);
			String actualTransNumber_6=getAttribute(driver, supplier_trans_number, "value");

			if(!actualTransNumber_6.equals(actualTransNumber_5)) {
				System.out.println("Not Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6);
				Extent_pass_New(driver, "Not Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6, test, test1);
			}else {
				System.out.println("Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6);
				Extent_fail(driver, "Matched || Trans Number before navigate to previous : "+actualTransNumber_5+" || Trans Number after navigate to previous : "+actualTransNumber_6, test, test1);
			}
		}
		waitForElement(driver, supplier_trans_number);
		String actualTransNumber_7=getAttribute(driver, supplier_trans_number, "value");

		waitForDisplay(driver, navigate_Button_Last_SI);
		if(isElementAccessible(driver, navigate_Button_Last_SI)) {
			click(driver, navigate_Button_Last_SI);
			waitForElement(driver, supplier_trans_number);
			String actualTransNumber_8=getAttribute(driver, supplier_trans_number, "value");

			if(!actualTransNumber_8.equals(actualTransNumber_7) && !isElementAccessible(driver, navigate_Button_Last_SI)) {
				System.out.println("Not Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8);
				Extent_pass_New(driver, "Not Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8, test, test1);
			}else {
				System.out.println("Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8);
				Extent_fail(driver, "Matched || Trans Number before navigate to Last : "+actualTransNumber_7+" || Trans Number after navigate to Last : "+actualTransNumber_8, test, test1);
			}
		}
		Step_End(4, "Click \"Navigate to last \" icon on toolbar able to view the last record of the transctions", test, test1);
		Step_End(2, "Click Navigate icon on toolbar", test, test1);
		Extent_completed(testCaseName, test, test1);
	}

}
