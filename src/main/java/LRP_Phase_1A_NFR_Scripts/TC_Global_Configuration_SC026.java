package LRP_Phase_1A_NFR_Scripts;

import java.io.IOException;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Global_Configuration_SC026 extends Keywords{

	public void Global_Configuration_SC026(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws IOException {

		String testCaseName = "TC_Global_Configuration_SC026";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Global_Configuration_Module = Excel_data.get("Global_Configuration_Module");
	
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login & open global configuration screen.", test, test1);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Global_Configuration_Module);

		Step_End(1, "Login & open global configuration screen.", test, test1);
		

		Step_Start(2, " Click the “CSV” Export Icon.", test, test1);

		waitForElement(driver, Global_Configuration_CSV_Btn);
		click(driver, Global_Configuration_CSV_Btn);
		
		Step_End(2, " Click the “CSV” Export Icon.", test, test1);

		Step_Start(3, "Make sure the file fully downloads.", test, test1);

		String downloadFile = downloadFile(driver, Global_Configuration_CSV_Btn);
		System.out.println("DownloadFile in Global Configuration is :"+downloadFile);
		
		String Excepted_Total_Row_count = getText(driver, Global_Grid_Count);
		
		int Application_Row_count= Integer.parseInt(Excepted_Total_Row_count);
		
		System.out.println(" total row count in application is " +Application_Row_count);
		
		
		Step_End(3, "Make sure the file fully downloads.", test, test1);
		
        Step_Start(4, "Data in CSV file matches the grid view exactly: same rows, same columns, same values.",test, test1);
        
        int CSVrowcount = countNonEmptyRowsFromCSV(downloadFile);
        
        int CSV_Row_Count=CSVrowcount-1;
        
        System.out.println("Actual Row count in CSV file is : "+CSV_Row_Count);
        
        if(Application_Row_count==CSV_Row_Count) {
        	
        	System.out.println("Matched || Excepted : Row count which we are getting in application is :"+Application_Row_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count);
        	Extent_pass_New(driver, "Matched ||  Excepted : Row count which we are getting in application is :"+Application_Row_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count, test, test1);
        }
		
        else {
        	System.out.println("NotMatched ||  Excepted : Row count which we are getting in application is :"+Application_Row_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count);
        	Extent_fail(driver, "NotMatched ||  Excepted : Row count which we are getting in application is :"+Application_Row_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count, test, test1);
        }
        

		 Step_End(4, "Data in CSV file matches the grid view exactly: same rows, same columns, same values",test, test1);
		 
		 
		 Extent_completed(testCaseName, test, test1);
		 
	}	 
	
	
}
