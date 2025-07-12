package LRP_Phase_1A_NFR_Scripts;


import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Agency_Master_SC007 extends Keywords{

	public void Agency_Master_SC007(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		
		String testcase_Name = "TC_Agency_Master_SC007";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Branch_Code = Excel_data.get("Branch_Code");
		String Port_Name_Inputs = Excel_data.get("Port_Name_Inputs");

		
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
		
		
        Step_Start(4, "Sort 'Name' column alphabetically, or 'Date' in descending order(Verify Total number of records)", test, test1);
		
        String Grid_filter_Total_count_Befor_reset = getText(driver, AM_Grid_filter_Total_count);
        int Grid_filter_Total_count_Befor_reset_no= Integer.parseInt(Grid_filter_Total_count_Befor_reset);
	    System.out.println("Paste_Group_Code is :"+ Grid_filter_Total_count_Befor_reset_no);
        
    	waitForElement(driver, AM_Grid_Filter);
		click(driver, AM_Grid_Filter);
		
		waitForElement(driver, AM_Grid_Filter_input_field);
		sendKeys(driver, AM_Grid_Filter_input_field, Port_Name_Inputs);
		
		
		
		String Total_Record = getText(driver, AM_Grid_filter_Total_count);
		String[] Record = Total_Record.split("of");
		int Total_record_count = Integer.parseInt(Record[0].trim());
		
		System.out.println("Total record count after filtered by expiry : "+ Total_record_count);
		
		if(Total_record_count != Grid_filter_Total_count_Befor_reset_no) {
			
			Extent_pass(driver,"Matched || Expected : After Filter the Port Name and the Totalcount is  "+Total_record_count+" || Actual : All filters should be cleared,Column order should return to default count is : "+ Grid_filter_Total_count_Befor_reset_no, test,test1);
			System.out.println("Matched || Expected : After Filter the Port Name and the Totalcount is  : "+Total_record_count+" || Actual : All filters should be cleared,Column order should return to default count is : "+ Grid_filter_Total_count_Befor_reset_no);
			
		}else {
			
			Extent_pass(driver,"Not Matched || Expected : After Filter the Port Name and the Totalcount is  "+Total_record_count+" || Actual : All filters should be cleared,Column order should return to default count is : "+ Grid_filter_Total_count_Befor_reset_no, test,test1);
			System.out.println("Not Matched || Expected : After Filter the Port Name and the Totalcount is  : "+Total_record_count+" || Actual : All filters should be cleared,Column order should return to default count is : "+ Grid_filter_Total_count_Befor_reset_no);
			
			
		}
		
		
		String Grid_filter_Total_count_after_reset = getText(driver, AM_Grid_filter_Total_count);
	    System.out.println("Paste_Group_Code is :"+ Grid_filter_Total_count_after_reset);
				
	   Step_End(4, "Sort 'Name' column alphabetically, or 'Date' in descending order(Verify Total number of records)", test, test1);
	   
	   
	   Step_Start(5, "Open the settings menu and click the “Reset” icon", test, test1);
	   
	    waitForElement(driver, AM_Click_For_More_Options);
		click(driver, AM_Click_For_More_Options);
	   
	    waitForElement(driver, AM_Rest_btn);
		click(driver, AM_Rest_btn);
		 
	   Step_End(5, "Open the settings menu and click the “Reset” icon", test, test1);
	   
	   Step_Start(6, "All filters should be cleared.Column order should return to default", test, test1);
	   
	   
	   String Grid_filter_Total_count_default_count = getText(driver, AM_Grid_filter_Total_count);
	   System.out.println("Paste_Group_Code is :"+ Grid_filter_Total_count_default_count);
	         
	   
	   if(Grid_filter_Total_count_Befor_reset.equals(Grid_filter_Total_count_default_count)) {
			Extent_pass(driver,"Matched || Expected : Befor Reset button Total count of records is "+Grid_filter_Total_count_Befor_reset+" || Actual : All filters should be cleared,Column order should return to default count is : "+ Grid_filter_Total_count_default_count, test,test1);
			System.out.println("Matched || Expected : Befor Reset button Total count of records is : "+Grid_filter_Total_count_Befor_reset+" || Actual : All filters should be cleared,Column order should return to default count is : "+ Grid_filter_Total_count_default_count);
		}else {
			System.out.println("Not Matched || Expected : Befor Reset button Total count of records is : "+Grid_filter_Total_count_Befor_reset+" || Actual : All filters should be cleared,Column order should return to default count is : "+ Grid_filter_Total_count_default_count);
			Extent_fail(driver,"Not Matched || Expected : Befor Reset button Total count of records is : "+Grid_filter_Total_count_Befor_reset+" || Actual : All filters should be cleared,Column order should return to default count is : "+ Grid_filter_Total_count_default_count, test,test1);
						
		}	
	   
	   Step_End(6, "All filters should be cleared.Column order should return to default", test, test1);
	   
	   Extent_completed(testcase_Name, test, test1);
	   
	}
}
