package LRP_Cost_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS016 extends Keywords{

	public void  Cost_Activity_Report_TS016(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		
		String tc_Name = "TC_Cost_Activity_Report_TS016";
		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String CAR_Approval_Module = Excel_data.get("CAR_Approval_Module");
		
		String UserName_Header = Excel_data.get("UserName_Header");
		String Expense_Type_Header = Excel_data.get("Expense_Type_Header");
		
		Extent_Start(tc_Name, test, test1);
		
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		
		Step_Start(1, "Once login to the application, Enter the screen name as 'User CAR Approval limit' in module search field", test, test1);
		moduleNavigate(driver, CAR_Approval_Module);
		Step_End(1, "Once login to the application, Enter the screen name as 'User CAR Approval limit' in module search field", test, test1);
		
		Step_Start(2, "Enter the our login username in the AG grid.", test, test1);
		waitForElement(driver, UserName_Filter_Input_UCA);
		sendKeys(driver, UserName_Filter_Input_UCA, username);
		Step_End(2, "Enter the our login username in the AG grid.", test, test1);
		
		
		Step_Start(3, "Check which are the expense types are mapped to the our login user by refering the expense type column.Copy all the expense type which is mapped for the our user.", test, test1);
		waitForElement(driver, Approval_LimitTable_UCA);
		List<Map<String, String>> Car_Approval_Table = extractTableDataByColumnWithoutScroll(driver,Approval_LimitTable_UCA);
		System.out.println("Car_Approval_Table : "+Car_Approval_Table);
		String Expense_Type_valueTable=getValueByFirstColumnAndHeader(Car_Approval_Table,UserName_Header,username.toLowerCase(),Expense_Type_Header);
		List<String> Expense_Types_Approval=splitAndExpand(Expense_Type_valueTable);
		Step_End(3, "Check which are the expense types are mapped to the our login user by refering the expense type column.Copy all the expense type which is mapped for the our user.", test, test1);

		
		Step_Start(4, "Then enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(4, "Then enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		
		Step_Start(5, "Check the contract type field and ensure that whether only the mapped expenses alone list down in CAR or not based on user car approval limit mapping.", test, test1);
		waitForElement(driver, Contract_Type_Input_CAR);
		click(driver,Contract_Type_Input_CAR);
		
		waitForElement(driver, Contract_Type_Options_CAR);
		List<WebElement>  ContarctOptionsList=listOfElements(driver, Contract_Type_Options_CAR);
		List<String> Contract_Types_Options=new ArrayList<String>();
		for(WebElement col:ContarctOptionsList) {
			Contract_Types_Options.add(col.getText());
		}
		
		if(compareLists(Expense_Types_Approval,Contract_Types_Options)) {
			System.out.println("Contract Type Options Matched ||   Expected  : "+Expense_Types_Approval+"   ||   Actual   : "+Contract_Types_Options);
			Extent_pass_New(driver, "Contract Type Options Matched ||   Expected  : "+Expense_Types_Approval+"   ||   Actual   : "+Contract_Types_Options, test, test1);
		}else {
			System.out.println("Contract Type Options Not Matched ||   Expected  : "+Expense_Types_Approval+"   ||   Actual   : "+Contract_Types_Options);
			Extent_fail(driver, "Contract Type Options Not Matched ||   Expected  : "+Expense_Types_Approval+"   ||   Actual   : "+Contract_Types_Options, test, test1);
		}
		Step_End(5, "Check the contract type field and ensure that whether only the mapped expenses alone list down in CAR or not based on user car approval limit mapping.", test, test1);

		Extent_completed(tc_Name, test, test1);
		
	}
	
}
