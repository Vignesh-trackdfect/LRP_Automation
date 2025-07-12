package LRP_Phase_1A_NFR_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Global_Configuration_SC025 extends Keywords{
	public void Global_Configuration_SC025(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Global_Configuration_SC025";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Global_Configuration_Module = Excel_data.get("Global_Configuration_Module");
		String Grid_Headers = Excel_data.get("Grid_Headers");
		String Grid_Headers_Input = Excel_data.get("Grid_Headers_Input");
		String Grid_Headers_inputs = Excel_data.get("Grid_Headers_inputs");

		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		
		Step_Start(1, "Login & open global configuration screen.", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Global_Configuration_Module);
		
		Step_End(1, "Login & open global configuration screen.", test, test1);
		
		
		Step_Start(2, ".Click the “Excel” Export Icon.", test, test1);
		Step_Start(3, "Make sure the file fully downloads.", test, test1);
		Step_Start(4, "Data in Excel file matches the grid view exactly: same rows, same columns, same values.", test, test1);

		
		formatLocatorClick(driver, GC_Grid_Header, Grid_Headers);
		

		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);
		
		
		waitForElement(driver, UMR_Filter_Option_Dropdown);
		click(driver, UMR_Filter_Option_Dropdown);
		
		
		formatLocatorClick(driver, UMR_Condition_Option, Grid_Headers_Input);
		
		waitForElement(driver, GC_Filter_Input_field);
		
        sendKeys(driver, GC_Filter_Input_field, Grid_Headers_inputs);
		
		
		waitForElement(driver, UMR_Filter_button);
		click(driver, UMR_Filter_button);

		
		
		waitForElement(driver, GC_Grid_Table);
		List <Map <String, String>> grid_data=extractTableDataByColumn(driver, GC_Grid_Table);
		Step_End(4, "Filter or sort the grid to simulate a user exporting a specific view.", test, test1);
		
		
		String downloadFile = downloadFile(driver, GC_Exel_File);
		System.out.println("downloadFile :"+downloadFile);
        List<Map<String, String>> actualExeclData = readSpreadsheet(downloadFile);
        
		if (compareCleanedListOfMaps(grid_data, actualExeclData)) {
			
		    System.out.println("✅ Data matches");
		    
			Extent_pass_New(driver, " values match || Expected: " + grid_data + " || Actual: " + actualExeclData,test, test1);
		} else {
		    System.out.println("❌ Data mismatch");
			Extent_fail(driver, " values match || Expected: " + grid_data + " || Actual: " + actualExeclData,test, test1);

		}
		
		Step_End(4, "Data in Excel file matches the grid view exactly: same rows, same columns, same values.", test, test1);
		Step_End(3, "Make sure the file fully downloads.", test, test1);
		Step_End(2, ".Click the “Excel” Export Icon.", test, test1);

		Extent_completed(testcase_Name, test, test1);

		

}
}