package LRP_Cost_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
public class TC_Cost_Activity_Report_TS060 extends Keywords {

	public void Cost_Activity_Report_TS060(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS060";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Search_Condition_Activity = Excel_data.get("Search_Condition_Activity");
		String AgencyUser = Excel_data.get("AgencyUser");
		String MSC_Headers_Names = Excel_data.get("MSC_Headers_Names");
		String Activity_module = Excel_data.get("Activity_module");
		String Activity_Code = Excel_data.get("Activity_Code");
		String CAR_Retrieve_Type1 = Excel_data.get("CAR_Retrieve_Type1");
		String CAR_Retrieve_Condition1 = Excel_data.get("CAR_Retrieve_Condition1");
		String CAR_Number_Retrieve_Value1 = Excel_data.get("CAR_Number_Retrieve_Value1");
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
	    
    
		Extent_Start(tc_Name, test, test1);

		Step_Start(1,"Once login to the application and click on switch profile option and select the required agency.",test, test1);

		navigateUrl(driver, url);

		Step_End(1, "Once login to the application and click on switch profile option and select the required agency",
				test, test1);

		Step_Start(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		LRP_Login(driver, username, password);

		SwitchProfile(driver, AgencyUser);

		Step_End(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		verifyMainMenu(driver);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, "Check whether it opens a new search window. ", test, test1);

		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button", test, test1);
		
		globalValueSearchWindow(driver,CAR_Retrieve_Condition1,CAR_Retrieve_Type1,CAR_Number_Retrieve_Value1,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(4, "Check whether it opens a new search window. ", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		Step_End(7, "System will show the CAR No. and Click on the select button", test, test1);
		

		Step_Start(8, "System will retrieve the CAR", test, test1);

		waitForElement(driver, car_Number_val);
		String Carvalue = getAttribute(driver, car_Number_val, "value");

		System.out.println("Carvalue :" + Carvalue);


		Step_End(8, "System will retrieve the CAR", test, test1);

		Step_Start(9, "Go to AG grid where activities are added", test, test1);

		waitForElement(driver, Port_Value);
		String Port_val = getAttribute(driver, Port_Value, "value");
		System.out.println("Port_val :" + Port_val);

		
		Step_End(9, "Go to AG grid where activities are added", test, test1);

		Step_Start(10, "Go to status column", test, test1);

		waitForElement(driver, MSC_Column_Filt_CAR);
		click(driver, MSC_Column_Filt_CAR);

		waitForElement(driver, MSC_Filter_input_CAR);
		jsClick(driver, MSC_SelectAll_Checkbox_CAR);

		List<String> ExpensiveTable_Headers = splitAndExpand(MSC_Headers_Names);
		for (String FilterHeader : ExpensiveTable_Headers) {
			waitForElement(driver, MSC_Filter_input_CAR);
			clear(driver, MSC_Filter_input_CAR);
			waitForElement(driver, MSC_Filter_input_CAR);
			sendKeys(driver, MSC_Filter_input_CAR, FilterHeader);

			String checkbox = String.format(Select_Column_MSC_CAR, FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}

		jsClick(driver, MSC_Column_Filt_CAR);

		Step_End(10, "Go to status column", test, test1);

		Step_Start(11, "Check what are the activities are Auto-approved and manually approved", test, test1);


		 Map<String,String> Activity_Amounts_CAR=new HashMap<String, String>();
		 Map<String,String> Activity_Status_CAR=new HashMap<String, String>();
		 Map<String,String> Actitivity_Currency_CAR=new HashMap<String, String>();
    
		 waitForElement(driver, MSC_Table_CAR);
		 List<Map<String, String>> MSC_TableData = extractTableDataByColumnWithoutScroll(driver, MSC_Table_CAR);
		 System.out.println("MSC_TableData : "+MSC_TableData);
			
		 List<String> ActivityCodes_Columns=getValuesByHeader(MSC_TableData, "Activity Code");
		 List<String> Amount_Columns=getValuesByHeader(MSC_TableData, "Amount");
		 List<String> Status_Columns=getValuesByHeader(MSC_TableData, "Status");
		 List<String> Currency_Columns=getValuesByHeader(MSC_TableData, "Currency");

		 for(int i=0;i<ActivityCodes_Columns.size();i++) {
			 String status=Status_Columns.get(i);
			 String Activity=ActivityCodes_Columns.get(i);
			 String Currency=Currency_Columns.get(i);
			 String Amount=Amount_Columns.get(i);

			 if(status.equals("Auto Approved")) {
				 Activity_Status_CAR.put(Activity, status);
				 Activity_Amounts_CAR.put(Activity, Amount);
				 Actitivity_Currency_CAR.put(Activity, Currency);
			 }
		 }
		
		 
		 Step_Start(12, "Copy the activity code and enter the screen name as Activity in the module search field", test,
				test1);

		moduleNavigate(driver, Activity_module);

		Step_End(12, "Copy the activity code and enter the screen name as Activity in the module search field", test,
				test1);

		Step_Start(13, "Click on the global search option and paste the activity code in activity code field", test,
				test1);

		waitForElement(driver, Activity_New_Button);
		click(driver, Activity_New_Button);

		 Map<String,String> Amounts_Activity=new HashMap<String, String>();

		for (Map.Entry<String, String> entry : Actitivity_Currency_CAR.entrySet()) {
		    String key = entry.getKey();
		    String currency = entry.getValue();
		    
		    waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			Step_Start(13, "Click on the global search option and paste the activity code in activity code field", test,
					test1);
		    
			globalValueSearchWindow(driver, Search_Condition_Activity, Activity_Code, key, "Port Code", Port_val, "", "");

			Step_End(13, "Click on the global search option and paste the activity code in activity code field", test,
					test1);
			
			Step_Start(14,"System will retrieve that activity. Check for that activity any amount is defined in Activity screen",
					test, test1);
			
			waitForElement(driver, Activity_port_Value);
			sendKeys(driver, Activity_port_Value, Port_val);

			waitForElement(driver, Activity_Currency_Value);
			sendKeys(driver, Activity_Currency_Value, currency);

			waitForElement(driver, Activity_Amount_Field);
			String Activity_Amount = getAttribute(driver, Activity_Amount_Field, "value");
			Step_End(14,"System will retrieve that activity. Check for that activity any amount is defined in Activity screen",
					test, test1);
			
			Amounts_Activity.put(key, Activity_Amount);
			
			waitForElement(driver, cancel_Common_btn);
			click(driver,cancel_Common_btn);
		}
		
		
		waitForElement(driver, Cost_Activity_Report_Screen_Option);
		click(driver, Cost_Activity_Report_Screen_Option);

		for (Map.Entry<String, String> entry : Activity_Amounts_CAR.entrySet()) {
			
			 String act = entry.getKey();
			 String Amount_CAR = entry.getValue();
			 String Amount_Activity = Amounts_Activity.get(act);
			 String Activity_Status=Activity_Status_CAR.get(act);
			 
			 double Amount_CAR_Table=getNumberValue(Amount_CAR);
			 double Amount_Activity_moduule=getNumberValue(Amount_Activity);
			 
			 if(Activity_Status.equals("Auto Approved")) {
				 if(Amount_CAR_Table<=Amount_Activity_moduule) {
					 System.out.println("Expected : When staus is Auto approved then the Amount in CAR module should less than or equal to with Activity module Amount || Actual : CAR module amount is less than/equal with Activity Amount when it is auto approved for Activity code : "+act+" , CAR Amount : "+Amount_CAR_Table+" Activity module Amt : "+Amount_Activity_moduule);
					 Extent_pass_New(driver, "Expected : When staus is Auto approved then the Amount in CAR module should less than or equal to with Activity module Amount || Actual : CAR module amount is less than/equal with Activity Amount when it is auto approved for Activity code : "+act+" , CAR Amount : "+Amount_CAR_Table+" Activity module Amt : "+Amount_Activity_moduule, test, test1);
				 }else {
					 System.out.println("Expected : When staus is Auto approved then the Amount in CAR module should less than or equal to with Activity module Amount || Actual : CAR module amount is greater than Activity Amount when it is auto approved for Activity code : "+act+" , CAR Amount : "+Amount_CAR_Table+" Activity module Amt : "+Amount_Activity_moduule);
					 Extent_fail(driver, "Expected : When staus is Auto approved then the Amount in CAR module should less than or equal to with Activity module Amount || Actual : CAR module amount is greater than Activity Amount when it is auto approved for Activity code : "+act+" , CAR Amount : "+Amount_CAR_Table+" Activity module Amt : "+Amount_Activity_moduule, test, test1);
				 }
			 }
		}
		
		Extent_completed(tc_Name, test, test1);

	}
}
