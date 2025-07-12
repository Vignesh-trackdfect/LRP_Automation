package LRP_Finance_Receivable_Receipt_Scripts;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Receivable_Receipt_RR22 extends Keywords{
	public void Receivable_Receipt_RR22(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Receivable_Receipt_RR22";
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Receivable_Receipt_Module = Excel_data.get("Receivable_Receipt_Module");
		String Customer_Popup = Excel_data.get("Customer_Popup");
		String Customer_Name = Excel_data.get("Customer_Name");
		String Receipt_Date_Input = Excel_data.get("Receipt_Date_Input");
		String Date_Picker = Excel_data.get("Date_Picker");
		
		

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, Username, Password);


		moduleNavigate(driver, Receivable_Receipt_Module);
		Step_Start(1, "Click on the new button in the tool bar", test, test1);
	    newButton(driver);
		Step_End(1, "Click on the new button in the tool bar", test, test1);
		
		if(Receipt_Date_Input.equals("")) {
			Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);
			LocalDate current_Date = getOnlyCurrentDate();

			waitForElement(driver, RR_Receipt_Date);
			String actual_Receipt_Date = getAttribute(driver, RR_Receipt_Date, "value");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate Receipt_Date = LocalDate.parse(actual_Receipt_Date, formatter);

			if (current_Date.equals(Receipt_Date)) {
				System.out.println("Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Current Date : "+Receipt_Date+" Receipt Date is  Automatically Selected Based On Month");
				Extent_pass_New(driver,"Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date : "+current_Date+" || The Actual Payment Date : "+Receipt_Date+"Receipt Date is Automatically Selected Based On Month", test, test1);
			} else {
				System.out.println("Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+Receipt_Date+"Receipt Date is Not Automatically Selected Based On Month");
				Extent_fail(driver,"Not Matched || Receipt Date Should be Automatically Select Based On Month || Expected Current Date || Expected Current Date : "+current_Date+" || The Actual Current Date  : "+Receipt_Date+"Receipt Date is Not Automatically Selected Based On Month", test, test1);
			}
			
			Step_End(2, "Receipt date will be automatically selected based on month", test, test1);
			Step_Start(3, "Open period will get automatically populated based on Receipt date", test, test1);
			waitForElement(driver, RR_Open_Period);
			String actual_Open_Period= getText(driver, RR_Open_Period);
			
		
			if(compareMonthAndYear(actual_Receipt_Date, actual_Open_Period)) {
				System.out.println("Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date  : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date");
				Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Payment Date || Expected  Receipt Date iss : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date ", test, test1);
			} else {
				System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date");
				Extent_fail(driver,"Not Matched || Open Period Should be Automatically Populated Based On Receipt Date|| Expected  Receipt Date is : "+actual_Receipt_Date+" || The Actual Receipt Date : "+actual_Open_Period+"Open Period  Not Automatically Populated Based On Receipt Date", test, test1);
			}

			Step_End(3, "Open period will get automatically populated based on Receipt date", test, test1);
		}else {
			Step_Start(2, "Receipt date will be automatically selected based on month", test, test1);
			if(Date_Picker.equalsIgnoreCase("Yes")) {
				
			selectDatePicker(driver, RR_Receipt_Date, Receipt_Date_Input);
			}
			else {
				waitForElement(driver, RR_Receipt_Date);
				clearAndType(driver, RR_Receipt_Date, Receipt_Date_Input);
			}
			waitForElement(driver, RR_Receipt_Date);
			String actual_Receipt_Date = getAttribute(driver, RR_Receipt_Date, "value");

		
			
			if (Receipt_Date_Input.equals(actual_Receipt_Date)) {
				System.out.println("Matched || Receipt Date should be Automatically Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || The Actual Receipt Date  : "+actual_Receipt_Date+"Receipt Date is Automatically Selected Based On Month ");
				Extent_pass_New(driver,"Matched || Receipt Date should be Automatically Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || The Actual Receipt Date  : "+actual_Receipt_Date+"Receipt Date is Automatically Selected Based On Month", test, test1);
			} else {
				System.out.println("Not Matched || Receipt Date should be Automatically Not Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || The Actual Receipt Date : "+actual_Receipt_Date+"Receipt Date is Not Automatically Selected Based On Month");
				Extent_fail(driver,"Not Matched || Receipt Date should be Automatically Not Selected Based On Month || Expected Current Date : "+Receipt_Date_Input+" || The Actual Receipt Date : "+actual_Receipt_Date+"Receipt Date is Not Automatically Selected Based On Month", test, test1);
			}
			Step_End(2, "Receipt date will be automatically selected based on month", test, test1);
			Step_Start(3, "Open period will get automatically populated based on Receipt date", test, test1);
			waitForElement(driver, RR_Open_Period);
			String actual_Open_Period= getText(driver, RR_Open_Period);
		
			if(compareMonthAndYear(actual_Receipt_Date, actual_Open_Period)) {
				System.out.println("Matched || Open Period Should be  Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" ||  Actual Open Receipt Date : "+actual_Open_Period+" Open Period  Automatically Populated Based On Receipt Date");
				Extent_pass_New(driver,"Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period  Automatically Populated Based On Receipt Date", test, test1);
			} else {
				System.out.println("Not Matched || Open Period Should be Automatically Populated Based On Receipt Date || Expected Receipt Date is "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Receipt Date");
				Extent_fail(driver,"Not Matched || Open Period Automatically Not Populated Based On Receipt Date || Expected The Receipt Date is : "+actual_Receipt_Date+" || Actual Open Receipt Date : "+actual_Open_Period+"Open Period Not Automatically Populated Based On Receipt Date", test, test1);
			}
			Step_End(3, "Open period will get automatically populated based on Receipt date", test, test1);
		}
		
		Step_Start(4, "Cick on Customer Name tab and enter negative value in customer tab", test, test1);
		
		waitForElement(driver, RR_Customer_Code);
		click(driver, RR_Customer_Code);
		
		waitForElement(driver, RR_Customer_Text_Field);
		sendKeys(driver, RR_Customer_Text_Field,Customer_Name);
		click(driver, RR_Customer_Search);
		Step_End(4, "Cick on Customer Name tab and enter negative value in customer tab", test, test1);
		
		
		Step_Start(5, "Once we click on search icon in customer tab, it should display \"No records found\"", test, test1);
		
		waitForPopup(driver, Customer_search_Popup,Customer_Popup);
		String Popup=getText(driver, Customer_search_Popup);
		if(Customer_Popup.equals(Popup)) {
			System.out.println("Matched || Expected : Once we click on search icon in customer tab, it should be display No records found : " + Customer_Popup + " || Actual : Once we click on search icon in customer tab,the popup message  is display  : " + Popup);
    		Extent_pass_New(driver,"Matched || Expected : Once we click on search icon in customer tab, it should be  display No records found " + Customer_Popup + " || Actual : Once we click on search icon in customer tab,he popup message is  display  : " + Popup, test,test1);
       
     } else {
			System.out.println("Not Matched ||Expected : Once we click on search icon in customer tab, it should be  display No records found : " + Customer_Popup + " || Actual  Once we click on search icon in customer tab, the popup message is  not display : " + Popup);
			Extent_fail(driver,"Not Matched ||Expected : Once we click on search icon in customer tab, it should be  display No records found : " + Customer_Popup + " || Actual  Once we click on search icon in customer tab, the popup messageis  not display  : " + Popup,test, test1);
		}

		Step_End(5, "Once we click on search icon in customer tab, it should display \"No records found\"", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
		
		
	}

}
