package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC55 extends Keywords{
	public void Haulage_Contract_SC55(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC55";
		
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
		
		
		Step_Start(8, "Click show all ,It show the all exsiting detials ", test, test1);
		waitForElement(driver, HC_show_All_Radio_Button);
		click(driver, HC_show_All_Radio_Button);
		
		waitForDisplay(driver, HC_Add_Gird_Table);
		if(isdisplayed(driver, HC_Add_Gird_Table)) {
			System.out.println("Expected Result is : Records should display || Actual Result is : Records is displayed");
			Extent_pass_New(driver, "Expected Result is : Records should display || Actual Result is : Records is displayed", test, test1);
		}else {
			System.out.println("Expected Result is : Records should display || Actual Result is : Records is not displayed");
			Extent_fail(driver, "Expected Result is : Records should display || Actual Result is : Records is not displayed", test, test1);
		}
		
		Step_End(8, "Click show all ,It show the all exsiting detials ", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
		
		
		
		
	}
}
