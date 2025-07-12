package LRP_Finance_Ledger_Report_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Payable_Payment_Locators;

public class TC_Ledger_Report_L01 extends Keywords{
	public void Ledger_Report_L01(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Ledger_Report_L01";
		
		



		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Payable_Payment_Module = Excel_data.get("Payable_Payment_Module");
		String GlobalSearchFilterOption_PPT = Excel_data.get("GlobalSearchFilterOption_PPT");
		String Condition = Excel_data.get("Condition");
		String Date_Picker = Excel_data.get("Date_Picker");
		String Payable_Payment_Number = Excel_data.get("Payable_Payment_Number");
		String Ledger_Report_Module = Excel_data.get("Ledger_Report_Module");
		String activity_Date_RadioBtn = Excel_data.get("activity_Date_RadioBtn");
        String Nominal_Name_header =Excel_data.get("Nominal_Name_header");
	    String dropdownCondition = Excel_data.get("dropdownCondition");
		
		Extent_Start(testcase_Name, test, test1);
		
	

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Open Payable payment module", test, test1);
		moduleNavigate(driver, Payable_Payment_Module);
        Step_End(1, "Open Payable payment module", test, test1);
        
		Step_Start(2, "Retrive payment no", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_PPT, Payable_Payment_Number, "","", "", "");
		

		Step_End(2, "Retrive payment no", test, test1);

		waitForElement(driver, Payment_No_TF_PPT);
		String Payment_No=getAttribute(driver, Payment_No_TF_PPT, "value");
		if(Payable_Payment_Number.equals(Payment_No)) {
			System.out.println("Matched  || Expected Payment Number should be display in the payable payment screen : "+Payable_Payment_Number+" || Expected Payment Number is display in the payable payment screen : "+Payment_No);
			Extent_pass_New(driver,"Matched  || Expected Payment Number should be display in the payable payment screen : "+Payable_Payment_Number+" || Expected Payment Number is display in the payable payment screen : "+Payment_No, test, test1);
		} else {
			System.out.println("Not Matched  || Expected Payment Number should be display in the payable payment screen : "+Payable_Payment_Number+" || Expected Payment Number is display in the payable payment screen : "+Payment_No);
			Extent_fail(driver,"Not Matched  || Expected Payment Number should be display in the payable payment screen : "+Payable_Payment_Number+" || Expected Payment Number is display in the payable payment screen : "+Payment_No, test, test1);
		}
		
		waitForElement(driver, paymentDate_PPT);
		String Payment_Date=getAttribute(driver, paymentDate_PPT, "value");
		System.out.println("Payment Date:" +Payment_Date);
		
		List<Map<String, String>> table_Data = getTableData(driver, post_Tab_Grid_Header, post_Tab_Grid_Row);
		String Nominal_Name = getValueByFirstColumnAndHeader(table_Data, "Dr/Cr","Dr", "Nominal Name");
        System.out.println("Payment_Details:"+ Nominal_Name);
        
        Step_Start(3, "open ledger report module", test, test1);
        
 
        moduleNavigate(driver, Ledger_Report_Module); 
		
		
		Step_End(3, "open ledger report module", test, test1);
		
		Step_Start(4, "click on activity date and select from date ,to date", test, test1);
		
		String Activity_Radio_Btn = String.format(Payable_Payment_Locators.Activity_Date_LRO, activity_Date_RadioBtn);

        waitForElement(driver, Activity_Radio_Btn);
        click(driver, Activity_Radio_Btn);
        
        
        waitForElement(driver, From_Date_LRO);
		if(Date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePicker(driver, From_Date_LRO, Payment_Date);
			
		}
		else {
			waitForElement(driver, From_Date_LRO);
			clearAndType(driver, From_Date_LRO, Payment_Date);
		}
		
		
		waitForElement(driver, To_Date_LRO);
		if(Date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePicker(driver, To_Date_LRO, Payment_Date);
			
		}
		else {
			waitForElement(driver, To_Date_LRO);
			clearAndType(driver, To_Date_LRO, Payment_Date);
		}
		Step_End(4, "click on activity date and select from date ,to date", test, test1);
		Step_Start(5, "select the nominal", test, test1);
		
		waitForElement(driver, nominal_Plus_Button_LRO);
		click(driver, nominal_Plus_Button_LRO);
		
		twoColumnSearchWindow(driver, Nominal_Name_header, dropdownCondition, Nominal_Name);
		
	
		Step_End(5, "select the nominal", test, test1);
		
		Step_Start(6, "click show", test, test1);
		waitForElement(driver, show_Button_LRO);
		click(driver, show_Button_LRO);
		Step_End(6, "click show", test, test1);
		
		waitForElement(driver, tool_Pannel_LRO);
		click(driver, tool_Pannel_LRO);
		waitForElement(driver, condition_Filter_LRO);
		click(driver, condition_Filter_LRO);
		
		
		waitForElement(driver, transaction_No_LRO);
		sendKeys(driver, transaction_No_LRO, Payment_No);
		Step_Start(7, "Created transaction for the selected nominal will display below", test, test1);
		
		String Trans_Number=String.format(grid_Trans_No_LRO, Payment_No);

		waitForDisplay(driver, Trans_Number);
		if(isDisplayed(driver, Trans_Number)) {
			System.out.println("Payment details displayed in ledger report");
			Extent_pass_New(driver, "Payment details displayed in ledger report", test, test1);
			
		}else {
			System.out.println("Payment details not displayed in ledger report");
			extent_fail(driver, "Payment details not displayed in ledger report", test, test1);
		}
		Step_End(7, "Created transaction for the selected nominal will display below", test, test1);
		
       Extent_completed(testcase_Name, test, test1);
	}

}
