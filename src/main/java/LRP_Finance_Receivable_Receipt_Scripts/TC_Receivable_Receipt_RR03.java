package LRP_Finance_Receivable_Receipt_Scripts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Receivable_Receipt_RR03 extends Keywords{
	
	public void Receivable_Receipt_RR03(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Receivable_Receipt_RR03";
		// Get data from test data

		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String module_ReceivableReceipt = Excel_data.get("Module_ReceivableReceipt");
		String customer_Name=Excel_data.get("Customer_Name");
		String expectedPopup = Excel_data.get("ExpectedPopup");

		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		moduleNavigate(driver, module_ReceivableReceipt);
		//	Receivable Receipt

		Extent_cal(test, test1, module_ReceivableReceipt);

		
		Step_Start(1, "Click on the new button in the tool bar", test, test1);

		newButton(driver);		
		Step_End(1, "Click on the new button in the tool bar", test, test1);
		Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);
		
		LocalDate current_Date = getOnlyCurrentDate();

		waitForElement(driver, RR_Receipt_Date);
		String actual_Receipt_Date = getAttribute(driver, RR_Receipt_Date, "value");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate reciept_Date = LocalDate.parse(actual_Receipt_Date, formatter);

		if (current_Date.equals(reciept_Date)) {
			System.out.println("Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Current Date : "+reciept_Date+" Receipt Date is  Automatically Selected Based On Month");
			Extent_pass_New(driver,"Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Payment Date : "+reciept_Date+"Receipt Date is Automatically Selected Based On Month", test, test1);
		} else {
			System.out.println("Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+reciept_Date+"Receipt Date is Not Automatically Selected Based On Month");
			Extent_fail(driver,"Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+reciept_Date+"Receipt Date is Not Automatically Selected Based On Month", test, test1);
		}
		
		Step_End(2, "Receipt date will be automatically selected based on month", test, test1);
		Step_Start(3, "Open period will get automatically populated based on receipt date", test, test1);

		waitForElement(driver, RR_Open_Period);
		String actual_Open_Period= getText(driver, RR_Open_Period);
		
		
		if(compareMonthAndYear(actual_Receipt_Date, actual_Open_Period)) {
			System.out.println("Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date");
			Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected  Receipt Date iss : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date ", test, test1);
		} else {
			System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date");
			Extent_fail(driver,"Not Matched || Open Period Should be Automatically Populated Based On Receipt Date|| Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date", test, test1);
		}
		
		Step_End(3, "Open period will get automatically populated based on receipt date", test, test1);
		Step_Start(4, " Select the search icon near customer tab, without entering values in customer field", test, test1);

		waitForElement(driver, RR_Customer_Code);
		click(driver, RR_Customer_Code);
		
		waitForElement(driver, RR_Customer_Text_Field);
		sendKeys(driver, RR_Customer_Text_Field,customer_Name);
		click(driver, RR_Customer_Search);

		Step_End(4, " Select the search icon near customer tab, without entering values in customer field", test, test1);
		Step_Start(5, " System should show the validation pop up as \"Enter the First three character of Customer Name\"", test, test1);

		waitForPopup(driver, popup_Message,expectedPopup);
		String actualPopup=getText(driver, popup_Message);
		
		if(expectedPopup.equals(actualPopup)) {
			System.out.println("Matched ||Expected : After click on save button Popup value should be display in the Receivable Receipt Screen : "+expectedPopup+" || Actual : After click on save button Popup value is display in the Receivable Receipt Screen :: "+actualPopup);
			Extent_pass_New(driver, "Matched ||Expected : After click on save button Popup value should be display in the Receivable Receipt Screen :: "+expectedPopup+" || Actual : After click on save button Popup value is display in the Receivable Receipt Screen : : "+actualPopup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected : After click on save button Popup value should be display in the Receivable Receipt Screen :: "+expectedPopup+" || Actual : After click on save button Popup value is display in the Receivable Receipt Screen :p : "+actualPopup);
			Extent_fail(driver, "Not Matched ||Expected : After click on save button Popup value should be display in the Receivable Receipt Screen :: "+expectedPopup+" || Actual : After click on save button Popup value is display in the Receivable Receipt Screen :: "+actualPopup, test, test1);
		}
		
		Step_End(5, " System should show the validation pop up as \"Enter the First three character of Customer Name\"", test, test1);

	
		Extent_completed(testCaseName, test, test1);
		
	}

}
