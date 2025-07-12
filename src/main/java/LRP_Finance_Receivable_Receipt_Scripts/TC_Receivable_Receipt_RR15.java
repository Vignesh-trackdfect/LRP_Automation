package LRP_Finance_Receivable_Receipt_Scripts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Receivable_Receipt_Locators;

public class TC_Receivable_Receipt_RR15 extends Keywords {

	public void Receivable_Receipt_RR15(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Receivable_Receipt_RR15";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String receivable_Receipt_Module = Excel_data.get("receivable_Receipt_Module");
		String Receipt_Date_Input = Excel_data.get("Receipt_Date_Input");
		String customer_Name_Data = Excel_data.get("customer_Data");
		String trans_Number_Data = Excel_data.get("trans_Number_Data").trim();
		String cheque_Drpdwn_Data = Excel_data.get("cheque_Drpdwn_Data");
        String SearchCustomer_Header = Excel_data.get("SearchCustomer_Header");
		String SearchCustomer_value = Excel_data.get("SearchCustomer_value");
		String Search_Condition = Excel_data.get("Search_Condition");
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		moduleNavigate(driver, receivable_Receipt_Module);
		Step_Start(1, "Click on the new button in the tool bar", test, test1);

	    newButton(driver);

		Step_End(1, "Click on the new button in the tool bar", test, test1);

		if (Receipt_Date_Input.equals("")) {
			Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);
			LocalDate current_Date = getOnlyCurrentDate();

			waitForElement(driver, RR_Reciept_Date);
			String actual_Receipt_Date = getAttribute(driver, RR_Reciept_Date, "value");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate Receipt_Date = LocalDate.parse(actual_Receipt_Date, formatter);

			
			if (current_Date.equals(Receipt_Date)) {
				System.out.println("Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Current Date : "+Receipt_Date+" Receipt Date is  Automatically Selected Based On Month");
				Extent_pass_New(driver,"Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Payment Date : "+Receipt_Date+"Receipt Date is Automatically Selected Based On Month", test, test1);
			} else {
				System.out.println("Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+Receipt_Date+"Receipt Date is Not Automatically Selected Based On Month");
				Extent_fail(driver,"Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+Receipt_Date+"Receipt Date is Not Automatically Selected Based On Month", test, test1);
			}
		}
		Step_End(2, "Receipt date will be automatically selected based on month", test, test1);

		Step_Start(3, "Open period will get automatically populated based on receipt date", test, test1);

		waitForElement(driver, RR_Reciept_Date);
		String actual_Reciept_Date = getAttribute(driver, RR_Reciept_Date, "value");

		waitForElement(driver, RR_Open_Period);
		
		String actual_Open_Period = getText(driver, RR_Open_Period);
		
		if(compareMonthAndYear(actual_Reciept_Date, actual_Open_Period)) {
			System.out.println("Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date");
			Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected  Receipt Date iss : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date ", test, test1);
		} else {
			System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date");
			Extent_fail(driver,"Not Matched || Open Period Should be Automatically Populated Based On Receipt Date|| Expected  Receipt Date is : "+actual_Reciept_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date", test, test1);
		}
		

		Step_End(3, "Open period will get automatically populated based on receipt date", test, test1);

		Step_Start(4, "Select the Customer Name from the search icon in the customer tab", test, test1);

		waitForElement(driver, RR_Customer_Code);
		click(driver, RR_Customer_Code);
		
		waitForElement(driver, RR_Customer_Text_Field);
		sendKeys(driver, RR_Customer_Text_Field, customer_Name_Data);

		click(driver, RR_Customer_Search);

		waitForElement(driver, RR_Customer_Code_Text_Field);
		
		twoColumnMultipleSearchWindow(driver, SearchCustomer_Header, Search_Condition, SearchCustomer_value);

		Step_End(4, "Select the Customer Name from the search icon in the customer tab", test, test1);

		Step_Start(5, "Select Get Details and click show invoice", test, test1);

		waitForElement(driver, get_Details_Btn_Rr);
		click(driver, get_Details_Btn_Rr);

		waitForElement(driver, show_Invoice_Btn_Rr);
		click(driver, show_Invoice_Btn_Rr);

		Step_End(5, "Select Get Details and click show invoice", test, test1);

		Step_Start(6, "Select the respective transaction number and select and make full payment", test, test1);
		
		String trans_Number_Select = String.format(RR_Select_Trans_Number_Check_Box, trans_Number_Data);
		waitForElement(driver, trans_Number_Select);
		click(driver, trans_Number_Select);


		Step_End(6, "Select the respective transaction number and select and make full payment", test, test1);

		Step_Start(7, "Click Cash/Bank Detail tab", test, test1);

		waitForElement(driver, cash_Bank_Detail_Tab_Rr);
		click(driver, cash_Bank_Detail_Tab_Rr);

		Step_End(7, "Click Cash/Bank Detail tab", test, test1);

		Step_Start(8, "Once we select cash, the cheque/TT No should disable", test, test1);

		waitForElement(driver, cheque_Drpdwn_Rr);
		click(driver, cheque_Drpdwn_Rr);

		String cheque_Drpdwn_Option_Rr = String.format(Receivable_Receipt_Locators.cheque_Drpdwn_Option_Rr,
				cheque_Drpdwn_Data);

		Extent_cal(test, test1, "selecting cash option");
		waitForElement(driver, cheque_Drpdwn_Option_Rr);
		click(driver, cheque_Drpdwn_Option_Rr);

		waitForElement(driver, chequeTT_No_Txtfld_Rr);

		if (!isClickable(driver, chequeTT_No_Txtfld_Rr)) {

		System.out.println("The expected Result is :  Once user select the cash, The cheque/TT No should be disabled and || Acutal result is : Once user select the cash, The cheque/TT No field is disabled "  );
			Extent_pass_New(driver,"The expected Result is : Once user select the cash, The cheque/TT No should be disabled and || Acutal result is : Once user select the cash, The cheque/TT No field is disabled " , test,test1);
		} else {
			

			System.out.println("The expected Result is : Once user select the cash, The cheque/TT No should be disabled and Acutal result is : Once user select the cash, The cheque/TT No field is disabled");
			Extent_fail(driver,"The expected Result is : Once user select the cash, The cheque/TT No should be disabled and Acutal result is : Once user select the cash, The cheque/TT No field is disabled" , test,test1);

		}

		Step_End(8, "Once we select cash, the cheque/TT No should disable", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
