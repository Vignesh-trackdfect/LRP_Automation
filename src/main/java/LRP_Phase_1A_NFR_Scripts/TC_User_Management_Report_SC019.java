package LRP_Phase_1A_NFR_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_User_Management_Report_SC019 extends Keywords {

	public void User_Management_Report_SC019(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_User_Management_Report_SC019";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String User_Management_Report_Module = Excel_data.get("User_Management_Report_Module");
		String User_Option = Excel_data.get("User_Option");
		String User_Name_Header = Excel_data.get("User_Name_Header");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String User_Name_Input = Excel_data.get("User_Name_Input");
		String Grid_Headers = Excel_data.get("Grid_Headers");
		String Grid_Headers_Input = Excel_data.get("Grid_Headers_Input");

		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		
		Step_Start(1, "Login & open user management report screen.", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, User_Management_Report_Module);
		
		Step_End(1, "Login & open user management report screen.", test, test1);
		
		Step_Start(2, "Retrieve data by using User Option (By all)", test, test1);

		
		waitForElement(driver, UMR_User_Option_drop_down);
		click(driver, UMR_User_Option_drop_down);
		formatLocatorClick(driver, DropDown_Select, User_Option);
		
		waitForElement(driver, UMR_User_Name_Button);
		click(driver,UMR_User_Name_Button);
		
		
	    twoColumnSearchWindow(driver, User_Name_Header, Dropdown_Condition, User_Name_Input);
		
		Step_End(2, "Retrieve data by using User Option (By all)", test, test1);

		Step_Start(3, "Click on show button to display the data", test, test1);
		
		
		waitForElement(driver, UMR_Show_Button);
		click(driver,UMR_Show_Button);
	
		
		formatLocatorClick(driver, UMR_Grid_Headers, Grid_Headers);
		
		
		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);
		
		
		waitForElement(driver, UMR_Grid_Select_All_Check_Box);
		click(driver, UMR_Grid_Select_All_Check_Box);
		
		waitForElement(driver, UMR_Grid_Header_Input_Field);
		sendKeys(driver, UMR_Grid_Header_Input_Field, Grid_Headers_Input);//
		
		
		formatLocatorClick(driver, UMR_Grid_Select_Text_Value, Grid_Headers_Input);
		
		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);
		
		
		Step_End(3, "Click on show button to display the data", test, test1);
		
		Step_Start(4, "Filter or sort the grid to simulate a user exporting a specific view.", test, test1);

		Step_Start(5, "Click the “CSV” Export Icon", test, test1);
		
		waitForElement(driver, UMR_Main_Filter_Option);
		click(driver, UMR_Main_Filter_Option);
		
		String downloadFile = downloadFile(driver, UMR_CSV_button);
		System.out.println("DownloadFile in Global Configuration is :"+downloadFile);
		
		Step_End(4, "Filter or sort the grid to simulate a user exporting a specific view.", test, test1);

		Step_End(5, "Click the “CSV” Export Icon", test, test1);
		
		Step_Start(6, ".Make sure the file fully downloads", test, test1);
		
		String Excepted_Total_Row_count = getText(driver, UMR_Total_Records);
		
		String [] activites=Excepted_Total_Row_count.split("of");
		String Act_Activity_Count=activites[0].trim();
		int Application_Row_count= Integer.parseInt(Act_Activity_Count);
		
		System.out.println(" total row count in application is " +Application_Row_count);
		
		if (!downloadFile.equals("")) {
			System.out.println("After Clicking the file Name,The File should be downloaded : "
					+ downloadFile );
			Extent_pass(driver, "After Clicking the file Name,The File should be downloaded :" + downloadFile,
					test, test1);
 
		} else {
 
			System.out.println("After Clicking the file Name,The File is not downloaded " );
			Extent_fail(driver, "After Clicking the file Name,The File is not downloaded ",test, test1);
			
		}
		
	    Step_End(6, ".Make sure the file fully downloads", test, test1);
		
		Step_Start(7, "Data in CSV file matches the grid view exactly: same rows, same columns, same values.", test, test1);
        
        int CSVrowcount = countNonEmptyRowsFromCSV(downloadFile);
        
        int CSV_Row_Count=CSVrowcount-1;
        
        System.out.println("Actual Row count in CSV file is : "+CSV_Row_Count);
        
        if(Application_Row_count==CSV_Row_Count) {
        	
        	System.out.println("Excepted || Row count which we are getting in application is :"+Application_Row_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count);
        	Extent_pass(driver, "Excepted || Row count which we are getting in application is :"+Application_Row_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count, test, test1);
        }
		
        else {
        	System.out.println("Excepted || Row count which we are getting in application is :"+Application_Row_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count);
        	Extent_fail(driver, "Excepted || Row count which we are getting in application is :"+Application_Row_count+ "Actual || the row count which we getting in CSV file is : "+CSV_Row_Count, test, test1);
        }
        	
		Step_End(7, "Data in CSV file matches the grid view exactly: same rows, same columns, same values.", test, test1);

		 Extent_completed(testcase_Name, test, test1);
		
		
}
}