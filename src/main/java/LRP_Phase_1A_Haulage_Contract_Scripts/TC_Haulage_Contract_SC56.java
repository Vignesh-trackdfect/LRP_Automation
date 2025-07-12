package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC56 extends Keywords{
	public void Haulage_Contract_SC56(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC56";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Global_Condition = Excel_data.get("Global_Condition");
		String global_Retrive_Type = Excel_data.get("global_Retrive_Type");
		String HC_Number = Excel_data.get("HC_Number");


		
		
		
		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		Step_Start(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);

		moduleNavigate(driver, Haulage_Contract_Module_Name);

		Step_End(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);
		Step_Start(2, "Click on the global search option which is available in the tool bar.", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(2, "Click on the global search option which is available in the tool bar.", test, test1);
		Step_Start(3, "Check whether the system opens the contract details search window.         ", test, test1);
		Step_Start(4, "Enter the saved hlg contract number in the contract number search field.        .", test, test1);
		Step_Start(5, "Click on the search button.     .", test, test1);
		Step_Start(6, "System will show cotract details based on the Contarct number .", test, test1);
		Step_Start(7, "Double click the Contract detials.          .", test, test1);
		
		globalValueSearchWindow(driver, Global_Condition,global_Retrive_Type, HC_Number, "", "", "", "");
		Step_End(3, "Check whether the system opens the contract details search window.         ", test, test1);
		Step_End(4, "Enter the saved hlg contract number in the contract number search field.        .", test, test1);
		Step_End(5, "Click on the search button.     .", test, test1);
		Step_End(6, "System will show cotract details based on the Contarct number .", test, test1);
		Step_End(7, "Double click the Contract detials.          .", test, test1);
		
		Step_Start(8, "Click show validity only  ,It show the Validity  exsiting detials ", test, test1);
		waitForElement(driver, HC_show_Validity_Only_Radio_Button);
		click(driver, HC_show_Validity_Only_Radio_Button);
		
		waitForElement(driver, HC_grid_Table);
		List<Map<String, String>> table_data = extractTableDataByColumn(driver, HC_grid_Table);
		String valid_From_Act = getFirstRowValueByHeaderFromTableData(table_data, "Valid From");
		
		String valid_To_Act = getFirstRowValueByHeaderFromTableData(table_data, "Valid To");
		
		 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		 LocalDate validFrom = LocalDate.parse(valid_From_Act, dateTimeFormatter);
	        LocalDate validTo = LocalDate.parse(valid_To_Act, dateTimeFormatter);
	        
	        
	        LocalDate today = LocalDate.now();
	        
	        if ((today.isEqual(validFrom) || today.isAfter(validFrom)) &&
	                (today.isEqual(validTo) || today.isBefore(validTo))) {
	                System.out.println("Current date is within the valid range.   ||From date : "+ validFrom + "  || To date  : "+validTo + " || Current Date :" +today);
	                Extent_pass_New(driver, "Current date is within the valid range.  ||From date : "+ validFrom + "  || To date  : "+validTo + " || Current Date :" +today, test, test1);
	            } else {
	                System.out.println("Current date is NOT within the valid range.     ||From date : "+ validFrom + "  || To date  : "+validTo + " || Current Date :" +today);
	                Extent_fail(driver, "Current date is NOT within the valid range.     ||From date : "+ validFrom + "  || To date  : "+validTo + " || Current Date :" +today, test, test1);
	            }
	        
	        Step_End(8, "Click show validity only  ,It show the Validity  exsiting detials ", test, test1);
	        Extent_completed(testcase_Name, test, test1);
	}

}
