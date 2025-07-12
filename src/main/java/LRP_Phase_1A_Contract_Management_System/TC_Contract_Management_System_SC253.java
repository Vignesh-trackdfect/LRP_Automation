package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Contract_Management_System_SC253 extends Keywords{


	public void Contract_Management_System_SC253(WebDriver driver, ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Contract_Management_System_SC253";
		
		String username=Excel_data.get("username");
		String password=Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Expected_Tab_Name = Excel_data.get("Expected_Tab_Name");

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		moduleNavigate(driver, Contract_Management_System_Module);
		
		Step_Start(1, "select FMC check box", test, test1);
		Step_Start(2, "select Non - containerized check box", test, test1);
 
		waitForElement(driver, Contract_Management_System_Non_Containerized);
		click(driver, Contract_Management_System_Non_Containerized);
 
		waitForElement(driver, Contract_Management_System_Fmc);
		click(driver, Contract_Management_System_Fmc);
 
		Step_End(1, "select FMC check box", test, test1);
		Step_End(2, "select Non containerized check box", test, test1);
		
		Step_Start(3, "Enter the customer name", test, test1);

		waitForElement(driver, Contract_Management_System_CustomerName);
		sendKeys(driver, Contract_Management_System_CustomerName, Customer_code_Value);
		
		String select_code=String.format(Select_CustomerCode_value, Customer_code_Value);
		waitForElement(driver, select_code);
		safeclick(driver, select_code);
	
		Step_End(3, "Enter the customer name", test, test1);
		
		Step_Start(4, "click on the customer profile button.", test, test1);

		
		waitForElement(driver, CMS_Customer_Profile_Btn);
		click(driver, CMS_Customer_Profile_Btn);
		
		waitForElement(driver, CMS_Verify_Tab); 
		String Actual_Tab_Name = getText(driver, CMS_Verify_Tab);
		
		if(Actual_Tab_Name.equals(Expected_Tab_Name)) {
			
			System.out.println("Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name);
			Extent_pass_New(driver, "Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name, test, test1);
			
		}else {
			System.out.println("Not Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name);
			Extent_fail(driver, "Not Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name, test, test1);
		}

		Step_End(4, "click on the customer profile button", test, test1);
		
		
		
		Extent_completed(testCaseName, test, test1);
		
		
		

	}

}


