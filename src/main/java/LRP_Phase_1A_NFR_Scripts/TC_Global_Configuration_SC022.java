package LRP_Phase_1A_NFR_Scripts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Global_Configuration_SC022 extends Keywords {

	public void Global_Configuration_SC022(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_User_Management_Report_SC022";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Global_Configuration_Module = Excel_data.get("Global_Configuration_Module");
		String Type_Input = Excel_data.get("Type_Input");
		String Grid_Headers = Excel_data.get("Grid_Headers");
		String Grid_Headers_Input = Excel_data.get("Grid_Headers_Input");
		String Grid_Headers_inputs = Excel_data.get("Grid_Headers_inputs");
		String Value_Input = Excel_data.get("Value_Input");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Login & open user management report screen.", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Global_Configuration_Module);

		Step_End(1, "Login & open user management report screen.", test, test1);

		Step_Start(2,"Scroll through a specific column (e.g., \"Type\") and identify that it contains duplicate values (e.g., multiple \"Varchar\" entries)..",test, test1);
	  
		waitForElement(driver, GC_Total_Records);
		String Exp_Record = getText(driver, GC_Total_Records);
 
		List<String> AllValues = new ArrayList<String>();
 
		for (int i = 0; i < Integer.parseInt(Exp_Record); i++) {
 
			String Gridcolumn = String.format(GC_AttributeList, i);
 
			mouseOverToElement(driver, Gridcolumn);
 
			String GridValues = getText(driver, Gridcolumn);
 
			AllValues.add(GridValues);
 
		}
 
		Set<String> uniqueItems = new HashSet<>();
		Set<String> duplicates = new HashSet<>();
 
		for (String item : AllValues) {
			if (!uniqueItems.add(item)) {
				duplicates.add(item); // Already exists → it's a duplicate
			}
		}
 
		System.out.println("Duplicate values: " + duplicates);
 
		System.out.println(
				"Expected result : Duplicate values should not present in the grid || Actual result : Duplicate values are present in the grid and the duplicate values are - "
						+ duplicates);
		Extent_cal(test, test1,
				"Expected result : Duplicate values should not present in the grid || Actual result : Duplicate values are present in the grid and the duplicate values are - "
						+ duplicates);
		
		waitForElement(driver, GC_Refresh_button_option);
		click(driver, GC_Refresh_button_option);
 
		Step_End(2,
				"Scroll through a specific column (e.g., \"Type\") and identify that it contains duplicate values (e.g., multiple \"Varchar\" entries)",
				test, test1);
		
		
		Step_Start(3, "Click the “Condition Filter” Icon on tool bar header.", test, test1);

		
		waitForElement(driver, GC_Condition_Filter);
		click(driver, GC_Condition_Filter);

		Step_End(3, "Click the “Condition Filter” Icon on tool bar header.", test, test1);

		Step_Start(4, "Choose Type field,Input your filter condition in the provided field, using a comparison operator contains or other operators.Ex: IN", test, test1);

		formatLocatorClick(driver, GC_Grid_Header, Grid_Headers);

		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);

		waitForElement(driver, UMR_Filter_Option_Dropdown);
		click(driver, UMR_Filter_Option_Dropdown);

		formatLocatorClick(driver, UMR_Condition_Option, Grid_Headers_Input);

		waitForElement(driver, GC_Filter_Input_field);
		sendKeys(driver, GC_Filter_Input_field, Grid_Headers_inputs);

		waitForElement(driver, GC_Type_Input);
		sendKeys(driver, GC_Type_Input, Type_Input);

		waitForElement(driver, GC_Value_Input);
		sendKeys(driver, GC_Value_Input, Value_Input);

		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);

		List<String> ActualValues = new ArrayList<String>();

		waitForElement(driver, GC_Grid_All_Rows);
		List<WebElement> actRows = listOfElements(driver, GC_Grid_All_Rows);

		for (WebElement Ele : actRows) {

			String val = Ele.getText().toLowerCase();
			ActualValues.add(val);
		}
		Step_End(4, "Choose Type field,Input your filter condition in the provided field, using a comparison operator contains or other operators.Ex: IN", test, test1);

		Step_Start(5, "Check that all visible rows in the grid meet the condition", test, test1);

		for (String actvalue : ActualValues) {

			if (actvalue.contains(Grid_Headers_inputs.toLowerCase())) {

     		   System.out.println("Matched || Expected || Attribute value : "+Grid_Headers_inputs+ "|| Actual :  Attribute value  :" + actvalue);
    		   Extent_pass_New(driver,"Matched || Expected || Attribute value : "+Grid_Headers_inputs+ "|| Actual :  Attribute value  :" + actvalue,test, test1);
     		   
			} else {
				  System.out.println("Not Matched || Expected || Attribute value : "+Grid_Headers_inputs+ "|| Actual :  Attribute value  :" + actvalue);
	    		   Extent_fail(driver,"Not Matched || Expected || Attribute value : "+Grid_Headers_inputs+ "|| Actual :  Attribute value  :" + actvalue,test, test1);
	     		   
			}
		}
		Step_End(5, "Check that all visible rows in the grid meet the condition", test, test1);
	
		Step_Start(6, "Reset the filter and verify that all original rows return to the grid.", test, test1);

		waitForElement(driver, GC_Reset_Button);
		click(driver, GC_Reset_Button);
		
		
		waitForElement(driver, GC_Total_Records);
		String Act_Record= getText(driver, GC_Total_Records);
		
		 
		 if(Act_Record.equals(Exp_Record)) {
			
			 System.out.println("Matched || Expected: After clicking the Reset button, the values should : "+Exp_Record+" : reset successfully. || Actual: After clicking the Reset button, the values reset : "+Act_Record+" : successfully.");  		   
			 Extent_pass_New(driver,"Matched || Expected: After clicking the Reset button, the values should: "+Exp_Record+" : reset successfully. || Actual: After clicking the Reset button, the values reset : "+Act_Record+": successfully.",test, test1);
			 
		 }else {
			 System.out.println("Not Matched || Expected: After clicking the Reset button, the values should : "+Exp_Record+" :reset successfully. || Actual: After clicking the Reset button, the values : "+Act_Record+" :Not reset.");  		   
			 Extent_pass_New(driver,"NOt Matched || Expected: After clicking the Reset button, the values should : "+Exp_Record+" :reset successfully. || Actual: After clicking the Reset button, the values : "+Act_Record+" :Not reset.",test, test1);
			 

		 }
		 
		Step_End(6, "Reset the filter and verify that all original rows return to the grid.", test, test1);

		 Extent_completed(testcase_Name, test, test1);



	}
}