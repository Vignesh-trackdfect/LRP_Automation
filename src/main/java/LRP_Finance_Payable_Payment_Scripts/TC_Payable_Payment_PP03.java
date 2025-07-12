package LRP_Finance_Payable_Payment_Scripts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Payable_Payment_PP03 extends Keywords{
	
	public void Payable_Payment_PP03(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Payable_Payment_PP03";
		// Get data from test data

		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String module_Payable_Payment = Excel_data.get("Module_Payable_Payment");
		String vendor_Name=Excel_data.get("Vendor_Name");
		String expectedPopup = Excel_data.get("ExpectedPopup");
		String payment_Date=Excel_data.get("Payment_Date");
		String datePicker=Excel_data.get("DatePicker");


		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		moduleNavigate(driver, module_Payable_Payment);
		


		Extent_cal(test, test1, module_Payable_Payment);

		Step_Start(1, "Click on the new button in the tool bar", test, test1);


		newButton(driver);
		
		Step_End(1, "Click on the new button in the tool bar", test, test1);
		
		if(payment_Date.equals("")) {
		Step_Start(2, "Payment date will be automatically selected based on month", test, test1);

		LocalDate current_Date = getOnlyCurrentDate();

		waitForElement(driver, paymentDate_PPT);
		String actual_Payment_Date = getAttribute(driver, paymentDate_PPT, "value");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate paymentDate = LocalDate.parse(actual_Payment_Date, formatter);

		
		if (current_Date.equals(paymentDate)) {
			System.out.println("Matched || Payment Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Current Date : "+paymentDate+" Payment Date Automatically Selected Based On Month");
			Extent_pass_New(driver,"Matched || Payment Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Payment Date Selected Based on Month : "+paymentDate+"Payment Date Automatically Selected Based On Month", test, test1);
		} else {
			System.out.println("Not Matched || Payment Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+paymentDate+"Payment Date Not Automatically Selected Based On Month");
			Extent_fail(driver,"Not Matched || Payment Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+paymentDate+"Payment Date Not Automatically Selected Based On Month", test, test1);
		}
		
		Step_End(2, "Payment date will be automatically selected based on month", test, test1);
		Step_Start(3, "Open period will get automatically populated based on receipt date", test, test1);

		waitForElement(driver, openPeriod_PPT);
		String actual_Open_Period= getText(driver, openPeriod_PPT);
		
		if(compareMonthAndYear(actual_Payment_Date, actual_Open_Period)) {
			System.out.println("Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected Payment Date is : "+actual_Payment_Date+" || The Actual Open Period  Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Payment Date");
			Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected Payment Date is : "+actual_Payment_Date+" || The Actual Open Period  Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Payment Date", test, test1);
		} else {
			System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected Payment Date is : "+actual_Payment_Date+" || The Actual Open Period : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Payment Date");
			Extent_fail(driver,"Not Matched || Open Period Should be  Automatically Populated Based On Payment Date || Expected Payment Date is : "+actual_Payment_Date+" || The Actual Open Period : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Payment Date", test, test1);
		}

		
		
		Step_End(3, "Open period will get automatically populated based on receipt date", test, test1);
		}else {
			Step_Start(2, "Payment date will be automatically selected based on month", test, test1);
			if(datePicker.equalsIgnoreCase("Yes")) {
				
				selectDatePicker(driver, paymentDate_PPT, payment_Date);
				
			}
			else {
				waitForElement(driver, paymentDate_PPT);
				clearAndType(driver, paymentDate_PPT, payment_Date);
			}
			
			waitForElement(driver, paymentDate_PPT);
			String actual_Payment_Date = getAttribute(driver, paymentDate_PPT, "value");

			if (payment_Date.equals(actual_Payment_Date)) {
				System.out.println("Matched || Payment Date Should be Automatically Select Based On Month : "+payment_Date+" || The Actual Payment Date  : "+actual_Payment_Date+"Payment Date Automatically Selected Based On Month");
				Extent_pass_New(driver,"Matched || Payment Date Should be Automatically Select Based On Month : "+payment_Date+" || The Actual Payment Date : "+actual_Payment_Date+"Payment Date Automatically Selected Based On Month", test, test1);
			} else {
				System.out.println("Not Matched || Payment Date Should  be Automatically Select Based On Month || Expected Current Date : "+payment_Date+" || The Actual Payment Date : "+actual_Payment_Date+"Payment Date Not Automatically Selected Based On Month");
				Extent_fail(driver,"Not Matched || Payment Date Should be  Automatically Select Based On Month || Expected Current Date : "+payment_Date+" || The Actual Payment Date : "+actual_Payment_Date+"Payment Date Not Automatically Selected Based On Month", test, test1);
			}

			
			
			Step_End(2, "Payment date will be automatically selected based on month", test, test1);
			Step_Start(3, "Select the search icon near customer tab, without entering values in customer field", test, test1);
			waitForElement(driver, openPeriod_PPT);
			String actual_Open_Period= getText(driver, openPeriod_PPT);
			
			if(compareMonthAndYear(actual_Payment_Date, actual_Open_Period)) {
				System.out.println("Matched || Open Period Should be  Automatically Populated Based On Payment Date || Expected Payment Date is "+actual_Payment_Date+" || The Actual Open Period Date : "+actual_Open_Period+" Open Period  Automatically Populated Based On Payment Date");
				Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected Payment Date is "+actual_Payment_Date+" || The Actual Open Period Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Payment Date", test, test1);
			} else {
				System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected Payment Date is "+actual_Payment_Date+" || The Actual Open Period : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Payment Date");
				Extent_fail(driver,"Not Matched || Open Period Automatically Not Populated Based On Payment Date || Expected The Payment Date is : "+actual_Payment_Date+" || The Actual Open Period : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Payment Date", test, test1);
			}

			
			Step_End(3, "Open period will get automatically populated based on Receipt date", test, test1);
		}
		
		Step_Start(4, " Select the search icon near customer tab, without entering values in customer field", test, test1);

		 waitForElement(driver, PP_Vendor_Radio_Button);
	     click(driver, PP_Vendor_Radio_Button);
		
		waitForElement(driver, vendor_textield_PPT);
		sendKeys(driver, vendor_textield_PPT,vendor_Name);
		click(driver, vendor_SearchButton_PPT);

		Step_End(4, "Select the search icon near customer tab, without entering values in customer field", test, test1);
		Step_Start(5, "System should show the validation pop up as \"Enter the First three character of vendor Name\".", test, test1);

		waitForPopup(driver, popup_Message,expectedPopup);
		
		String actualPopup=getText(driver, popup_Message);
		
		if(expectedPopup.equals(actualPopup)) {
			System.out.println("Matched || Expected popup  value should be display in the Payable Payment Screen : "+expectedPopup+" || Actual popup Display in the Payable Payment Screen : "+actualPopup);
			Extent_pass_New(driver, "Matched || Expected popup  value should be display in the Payable Payment Screen : "+expectedPopup+" || Actual popup Display in the Payable Payment Screen : "+actualPopup, test, test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected popup  value should be display in the Payable Payment Screen : "+expectedPopup+" || Actual popup Display in the Payable Payment Screen : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected popup  value should be display in the Payable Payment Screen : "+expectedPopup+" || Actual popup Display in the Payable Payment Screen : "+actualPopup, test, test1);
		}
		
		Step_End(5, "System should show the validation pop up as \"Enter the First three character of vendor Name\".", test, test1);

	
		Extent_completed(testCaseName, test, test1);
		
	}

}
