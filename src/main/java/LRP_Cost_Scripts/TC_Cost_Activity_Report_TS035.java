package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS035 extends Keywords{
	
	public void  Cost_Activity_Report_TS035(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS035";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");

		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		String MSC_Headers_Names = Excel_data.get("MSC_Headers_Names");

		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		
		Step_Start(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		
		Step_Start(3, "Click on the global search option which is available in the tool bar.", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(3, "Click on the global search option which is available in the tool bar.", test, test1);
		
		Step_Start(4, "Check whether it opens a new search window. ", test, test1);
		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button. ", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button ", test, test1);

		globalValueSearchWindow(driver,CAR_Retrieve_Condition,CAR_Retrieve_Type,CAR_Number_Retrieve,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);

		Step_End(7, "System will show the CAR No. and Click on the select button ", test, test1);
		Step_End(6, "Then click on the search button. ", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_End(4, "Check whether it opens a new search window. ", test, test1);
		
		Step_Start(8, "System will retrieve the CAR", test, test1);
		waitForElement(driver, MSC_Column_Filt_CAR);
		Step_End(8, "System will retrieve the CAR", test, test1);
		
		Step_Start(9, "Check whether the submitted/rejected/approved by username and date column is present in the grid.", test, test1);
		click(driver, MSC_Column_Filt_CAR);
		waitForElement(driver, MSC_Filter_input_CAR);
		jsClick(driver, MSC_SelectAll_Checkbox_CAR);
		
		List<String> ExpensiveTable_Headers=splitAndExpand(MSC_Headers_Names);
		for(String FilterHeader : ExpensiveTable_Headers) {
			waitForElement(driver, MSC_Filter_input_CAR);
			clear(driver, MSC_Filter_input_CAR);
			waitForElement(driver, MSC_Filter_input_CAR);
			sendKeys(driver, MSC_Filter_input_CAR,FilterHeader);
		
			String checkbox=String.format(Select_Column_MSC_CAR,FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}
		
		jsClick(driver, MSC_Column_Filt_CAR);
		Step_End(9, "Check whether the submitted/rejected/approved by username and date column is present in the grid.", test, test1);
		
		Step_Start(10, "Ensure that the submitted/rejected/approved by username and date will be shown based on the last status of the activity.", test, test1);
		waitForElement(driver, MSC_Table_CAR);
		
		List<Map<String, String>> MSC_TableData = extractTableDataByColumnWithoutScroll(driver, MSC_Table_CAR);
		System.out.println("MSC_TableData : "+MSC_TableData);
		
		List<String> UserNameValues=getValuesByHeader(MSC_TableData, "User Name");
		List<String> Date_Values=getValuesByHeader(MSC_TableData, "Date");
		List<String> Status_Values=getValuesByHeader(MSC_TableData, "Status");

		boolean status=true;
		for(int i=0;i<Status_Values.size();i++) {
			String StatusColumn=Status_Values.get(i);
			String Usernameval=UserNameValues.get(i);
			String DateVal=Date_Values.get(i);
			
			if(!StatusColumn.equals("Draft")) {
				if(Usernameval.equals("")||DateVal.equals("")) {
					System.out.println("Expected : if status is other than 'Draft then Username and Date values should be present || Acual : Username and Date values are not present when the status is other than 'Draft'");
					Extent_fail(driver, "Expected : if status is other than 'Draft then Username and Date values should be present || Acual : Username and Date values are not present when the status is other than 'Draft'", test, test1);
					status=false;
				}
			}else {
				if(!Usernameval.equals("")||!DateVal.equals("")) {
					System.out.println("Expected : if status is 'Draft then Username and Date values should not be present || Acual : Username and Date values are present when the status is 'Draft'");
					Extent_fail(driver, "Expected : if status is 'Draft then Username and Date values should not be present || Acual : Username and Date values are present when the status is 'Draft'", test, test1);
				}
			}
		}
		
		if(status) {
			System.out.println("Expected : if status is other than 'Draft then Username and Date values should be present || Acual : Username and Date values are present when the status is other than 'Draft'");
			Extent_pass_New(driver, "Expected : if status is other than 'Draft then Username and Date values should be present || Acual : Username and Date values are present when the status is other than 'Draft'", test, test1);
		}
		Step_End(10, "Ensure that the submitted/rejected/approved by username and date will be shown based on the last status of the activity.", test, test1);

		Extent_completed(tc_Name, test, test1);
	}
}
