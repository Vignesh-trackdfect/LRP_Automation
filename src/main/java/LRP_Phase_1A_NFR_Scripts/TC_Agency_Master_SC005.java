package LRP_Phase_1A_NFR_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Agency_Master_SC005 extends Keywords{
	
	public void Agency_Master_SC005(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		
		String testcase_Name = "TC_Agency_Master_SC005";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String Select_field = Excel_data.get("Select_field");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Branch_Code = Excel_data.get("Branch_Code");
		String Grid_Headers = Excel_data.get("Grid_Headers");
		String Grid_Headers_Input = Excel_data.get("Grid_Headers_Input");
		String Grid_Headers_inputs = Excel_data.get("Grid_Headers_inputs");
		String Status_Input = Excel_data.get("Status_Input");
		
		
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
		
		Step_Start(4, "Find the icon that looks like it might do filtering but with a smug attitude.", test, test1);

		
		    waitForElement(driver, AM_Grid_filter_Total_count);

		    String Total_Records_Act =getText(driver, AM_Grid_filter_Total_count);
			String [] activites=Total_Records_Act.split("of");
			String Act_Activity_Count=activites[0].trim();
		
		
		
		
		waitForElement(driver, AM_Click_For_More_Options);
		click(driver, AM_Click_For_More_Options);
		
		waitForElement(driver, AM_Condition_Filter_Button);
		click(driver, AM_Condition_Filter_Button);
		
		Step_End(4, "Find the icon that looks like it might do filtering but with a smug attitude.", test, test1);

		Step_Start(5, "Choose port name field,Input your filter condition in the provided field, using a comparison operator contains or other operators.Ex: AE", test, test1);

		formatLocatorClick(driver, AM_Grid_Header, Grid_Headers);
		
		
		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);

		waitForElement(driver, UMR_Filter_Option_Dropdown);
		click(driver, UMR_Filter_Option_Dropdown);
		
		formatLocatorClick(driver, UMR_Condition_Option, Grid_Headers_Input);
		
		
		waitForElement(driver, GC_Filter_Input_field);
		sendKeys(driver, GC_Filter_Input_field, Grid_Headers_inputs);
		
		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);

		

		waitForElement(driver, AM_status_Input);
		sendKeys(driver, AM_status_Input, Status_Input);
		
		Step_End(5, "Choose port name field,Input your filter condition in the provided field, using a comparison operator contains or other operators.Ex: AE", test, test1);

		Step_Start(6, "Check that all visible rows in the grid meet the condition.", test, test1);

		List<String> ActualValues = new ArrayList<String>();

		waitForElement(driver, AM_Grid_Rows);
		List<WebElement> actRows = listOfElements(driver, AM_Grid_Rows);

		for (WebElement Ele : actRows) {

			String val = Ele.getText().toLowerCase();
			ActualValues.add(val);
		}
		
		for (String actvalue : ActualValues) {

			if (actvalue.contains(Grid_Headers_inputs.toLowerCase())) {

     		   System.out.println("Matched || Expected || Attribute value : "+Grid_Headers_inputs+ "|| Actual :  Attribute value  :" + actvalue);
    		   Extent_pass_New(driver,"Matched || Expected || Attribute value : "+Grid_Headers_inputs+ "|| Actual :  Attribute value  :" + actvalue,test, test1);
     		   
			} else {
				  System.out.println("Not Matched || Expected || Attribute value : "+Grid_Headers_inputs+ "|| Actual :  Attribute value  :" + actvalue);
	    		   Extent_fail(driver,"Not Matched || Expected || Attribute value : "+Grid_Headers_inputs+ "|| Actual :  Attribute value  :" + actvalue,test, test1);
	     		   
			}
		}
		
		Step_End(6, "Check that all visible rows in the grid meet the condition.", test, test1);

		Step_Start(7, "Reset the filter and verify that all original rows return to the grid..", test, test1);

		waitForElement(driver, AM_Click_For_More_Options);
		click(driver, AM_Click_For_More_Options);
		
		waitForElement(driver, AM_Rest_btn);
		click(driver, AM_Rest_btn);
		
		
		
		waitForElement(driver, AM_Grid_filter_Total_count);
		String Act_Record= getText(driver, AM_Grid_filter_Total_count);
		 
		 if(Act_Record.equals(Act_Activity_Count)) {
			
			 System.out.println("Matched || Expected: After clicking the Reset button, the values should : "+Act_Activity_Count+" : reset successfully. || Actual: After clicking the Reset button, the values reset : "+Act_Record+" : successfully.");  		   
			 Extent_pass_New(driver,"Matched || Expected: After clicking the Reset button, the values should: "+Act_Activity_Count+" : reset successfully. || Actual: After clicking the Reset button, the values reset : "+Act_Record+": successfully.",test, test1);
			 
		 }else {
			 System.out.println("Not Matched || Expected: After clicking the Reset button, the values should : "+Act_Activity_Count+" :reset successfully. || Actual: After clicking the Reset button, the values : "+Act_Record+" :Not reset.");  		   
			 Extent_pass_New(driver,"NOt Matched || Expected: After clicking the Reset button, the values should : "+Act_Activity_Count+" :reset successfully. || Actual: After clicking the Reset button, the values : "+Act_Record+" :Not reset.",test, test1);
			 

		 }
		
			Step_End(7, "Reset the filter and verify that all original rows return to the grid..", test, test1);
		
			 Extent_completed(testcase_Name, test, test1);


}
}