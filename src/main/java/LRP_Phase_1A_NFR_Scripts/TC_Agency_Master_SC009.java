package LRP_Phase_1A_NFR_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Agency_Master_SC009 extends Keywords{

	public void Agency_Master_SC009(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		
		String testcase_Name = "TC_Agency_Master_SC009";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Branch_Code = Excel_data.get("Branch_Code");
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		
		Step_Start(1, "Login & Open agency master screen.", test, test1);

		moduleNavigate(driver, Agency_Master_Module);
	
		Step_End(1, "Login & Open agency master screen.", test, test1);
		
		Step_Start(2, "Retrieve Office Agency from the scrreen.", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver,Search_Condition, Select_field, Branch_Code, "", "", "", "");
		
		Step_End(2, "Retrieve Office Agency from the scrreen.", test, test1);
		
		
        Step_Start(3, "Navigate to Controlling Ports tab.", test, test1);
		
        
		waitForElement(driver, AM_Controlling_Ports_Tab);
		click(driver, AM_Controlling_Ports_Tab);
		
		Step_End(3, "Navigate to Controlling Ports tab.", test, test1);
		
		Step_Start(4, "Filter or sort the grid to simulate a user exporting a specific view.", test, test1);
		
		
		waitForElement(driver, AM_Expiry_Status_Filter_btn);
		click(driver, AM_Expiry_Status_Filter_btn);

		waitForElement(driver, AM_Filter_button);
		click(driver, AM_Filter_button);
		
		
		waitForElement(driver, AM_Selectall_checkbox);
		click(driver, AM_Selectall_checkbox);
		
		
		waitForElement(driver, AM_Expier_checkbox);
		click(driver, AM_Expier_checkbox);
		
		String Total_count = getText(driver, Total_Record_Count);
		String[] Record = Total_count.split("of");
		
		int Total_record_count = Integer.parseInt(Record[0].trim());
		System.out.println("Total record count after filtered by expiry : "+ Total_record_count);
		
		List<String> expiryStatuses = new ArrayList<>();
		
		for(int i=0; i<Total_record_count; i++) {
			
			String expiry_col = String.format(AM_Expire_Status_col, i);
			mouseOverToElement(driver, expiry_col);
			scrollToElement(driver, expiry_col);
			String ExpirestatusSelect = getText(driver, expiry_col);
			expiryStatuses.add(ExpirestatusSelect);
			
		}
		String expireStatusSelect = String.join(", ", expiryStatuses);
		System.out.println("All expiry statuses: " + expireStatusSelect);
		
				
		   
		Step_End(4, "Filter or sort the grid to simulate a user exporting a specific view.", test, test1);
		
		
		Step_Start(5, "Click the “CSV” Export Icon.", test, test1);
		
        scrollTop(driver);
		
		waitForElement(driver, AM_Click_For_More_Options);
		click(driver, AM_Click_For_More_Options);
		
		String filePath = downloadFile(driver, AM_CSV_Button_Toolbar);
		
		Step_End(5, "Click the “CSV” Export Icon.", test, test1);
		
		Step_Start(6, "Make sure the file fully downloads.", test, test1);
		
		
		if (!filePath.equals("")) {
			System.out.println("After Clicking the file Name,The File should be downloaded : "
					+ filePath );
			Extent_pass(driver, "After Clicking the file Name,The File should be downloaded :" + filePath,
					test, test1);
 
		} else {
 
			System.out.println("After Clicking the file Name,The File is not downloaded " );
			Extent_fail(driver, "After Clicking the file Name,The File is not downloaded ",test, test1);
			
		}
		
		Step_End(6, "Make sure the file fully downloads.", test, test1);
				
		
		Step_Start(7, "Data in CSV file matches the grid view exactly: same rows, same columns, same values.", test, test1);
		       
    
       int CSVrowcount = countNonEmptyRowsFromCSV(filePath);
        
        int CSV_Row_Count=CSVrowcount-1;
        
        System.out.println("Actual Row count in CSV file is : "+CSV_Row_Count);
        
        if(Total_record_count==CSV_Row_Count) {
        	
        	System.out.println("Excepted || Row count which we are getting in application is :"+Total_record_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count);
        	Extent_pass(driver, "Excepted || Row count which we are getting in application is :"+Total_record_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count, test, test1);
        }
		
        else {
        	System.out.println("Excepted || Row count which we are getting in application is :"+Total_record_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count);
        	Extent_fail(driver, "Excepted || Row count which we are getting in application is :"+Total_record_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count, test, test1);
        }
		
		Step_End(7, "Data in CSV file matches the grid view exactly: same rows, same columns, same values.", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
		
		
	}
}

