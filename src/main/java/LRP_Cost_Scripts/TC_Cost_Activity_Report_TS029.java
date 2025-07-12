package LRP_Cost_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS029 extends Keywords{

	public void Cost_Activity_Report_TS029(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS029";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");

		String Draf = Excel_data.get("Draft_option");
		String Header = Excel_data.get("Column_Header");
		String Submitted = Excel_data.get("Submitted");
		String Approved_Val = Excel_data.get("Approved_val");
		String Rejected = Excel_data.get("Rejected_val");
		String PartlyApproved = Excel_data.get("Partly_Approved");
		String AgencyUser =Excel_data.get("AgencyUser");
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

		waitForElement(driver, seach_Filed);
		click(driver, seach_Filed);

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

		waitForElement(driver, CAR_Expense_Status);
		String Status_values = getText(driver, CAR_Expense_Status);
		System.out.println("Status_values :" + Status_values);

		Step_Start(9, "Click on the Expense report button and check system opens a new tab", test, test1);

		waitForElement(driver, ExpenseReport);
		click(driver, ExpenseReport);

		waitForDisplay(driver, expensereportpage);
		if (isdisplayed(driver, expensereportpage)) {

			System.out.println("Expected : Click on the Expense Report, and it Should navigate to the Expense Report screen successfully || Actual : After Click on the Expense Report, it navigate to the Expense Report screen successfully");
			Extent_pass_New(driver,
					"Expected : Click on the Expense Report, and it Should navigate to the Expense Report screen successfully || Actual : After Click on the Expense Report, it navigate to the Expense Report screen successfully", test,
					test1);
		} else {

			System.out.println("Expected : Click on the Expense Report, and it Should navigate to the Expense Report screen successfully || Actual : After Click on the Expense Report, it not navigate to the Expense Report screen successfully");
			Extent_fail(driver,
					"Expected : Click on the Expense Report, and it Should navigate to the Expense Report screen successfully || Actual : After Click on the Expense Report, it not navigate to the Expense Report screen successfully",
					test, test1);
		}

		Step_End(9, "Click on the Expense report button and check system opens a new tab", test, test1);

		int Total_Records=0;
		waitForElement(driver, Open_Expensive_CAR);
		click(driver,Open_Expensive_CAR);
		
		List<Map<String, String>> open_expenser= new ArrayList<Map<String,String>>();
		List<String> OpenExpenses_status_value=new ArrayList<String>();
		
		waitForDisplay(driver, Open_Expenses_Column);
		if(isdisplayed(driver, Open_Expense_Table_Rows)) {
			waitForElement(driver, Open_Expenses_Column);
			click(driver, Open_Expenses_Column);

			waitForDisplay(driver, Open_Expe_SelectAll_Checkbox);
			click(driver, Open_Expe_SelectAll_Checkbox);
			if(isdisplayed(driver, Open_Expense_Table_Rows)) {
				waitForDisplay(driver, Open_Expe_SelectAll_Checkbox);
				click(driver, Open_Expe_SelectAll_Checkbox);
			}
			
			List<String> column_Headers = splitAndExpand(Header);
			for (int i = 0; i < column_Headers.size(); i++) {
				String column = column_Headers.get(i);
				waitForElement(driver, Open_Expense_column_Searchbox);
				click(driver, Open_Expense_column_Searchbox);
				clear(driver, Open_Expense_column_Searchbox);
				sendKeys(driver, Open_Expense_column_Searchbox, column);

				String checkbox = String.format(Open_Expense_Colum_CheckBox, column);
				waitForDisplay(driver, checkbox);
				jsClick(driver, checkbox);
			}
			waitForElement(driver, Open_Expenses_Column);
			click(driver, Open_Expenses_Column);
				
			waitForElement(driver, Open_TAble_record);
			String  total =getText(driver, Open_TAble_record);
			
		    Total_Records = Integer.parseInt(total);
		    waitForElement(driver, Open_Table);
			open_expenser = extractTableDataByRowIndex(driver, Open_Table, Total_Records);
			
			OpenExpenses_status_value = getColumnValues(open_expenser,Header );
			System.out.println("OpenExpenses_status_value :"+OpenExpenses_status_value);
	    }
		
	
		waitForElement(driver, ApprovedExpenses);
		click(driver, ApprovedExpenses);
		
		int Total_Records1=0;
		List<Map<String, String>> Approved_expenser=new ArrayList<Map<String,String>>();
		List<String> ApprovedExpenses_status_value=new ArrayList<String>();
		
		if(isdisplayed(driver, App_Expense_Table_Rows)) {
			waitForElement(driver, Column);
			click(driver, Column);
				
			waitForDisplay(driver, Approved_Deselect);
			jsClick(driver, Approved_Deselect);
			if(isdisplayed(driver, App_Expense_Table_Rows)) {
				waitForDisplay(driver, Approved_Deselect);
				jsClick(driver, Approved_Deselect);
			}
			
			List<String> column_Headers_val=splitAndExpand(Header);
			for(int i=0;i<column_Headers_val.size();i++) {
				String column=column_Headers_val.get(i);
				waitForElement(driver, App_Expensive_Filter_input_CAR);
				click(driver, App_Expensive_Filter_input_CAR);
				clear(driver, App_Expensive_Filter_input_CAR);
				sendKeys(driver, App_Expensive_Filter_input_CAR, column);
			
				String checkbox=String.format(App_Select_Column_Expensive_CAR, column);
				waitForDisplay(driver, checkbox);
				click(driver, checkbox);
			}
			waitForElement(driver, Column);
			click(driver, Column);
			waitForElement(driver, Approved_Total_CAR_APP);
			String  Exp_total =getText(driver, Approved_Total_CAR_APP);
		    Total_Records1 = Integer.parseInt(Exp_total);
			
		    waitForElement(driver, Approved_table_CAR_APP);
		    Approved_expenser = extractTableDataByRowIndex(driver, Approved_table_CAR_APP, Total_Records1);
		    ApprovedExpenses_status_value = getColumnValues(Approved_expenser,Header );
		}
		
		System.out.println("ApprovedExpenses_status_value :"+ApprovedExpenses_status_value);
		boolean Draft = false;
		boolean submited = false;
		boolean rejected = false;
		boolean approved = false;
		boolean partially_approved = false;
			
		if(!OpenExpenses_status_value.isEmpty()) {
			if(OpenExpenses_status_value.contains("Draft")) {
				Draft = true;
			}else if(OpenExpenses_status_value.contains("Submitted")) {
				submited = true;
			}else {
				rejected = true;
			}
		}
		
		if(!ApprovedExpenses_status_value.isEmpty()) {
			if(!OpenExpenses_status_value.isEmpty()&&rejected) {
				rejected = false;
				partially_approved = true;
			}else {
				approved = true;
			}
		}
		
		
		if(Draft) {
			Step_Start(10, "If the activities are in draft status then ensure that the system shows the car expense status as Draft", test, test1);
			
			Step_Start(14, "If the some of the activities are  draft status and other activities are in approved status means,then ensure that the system shows the car expense status as Draft", test, test1);
			
			if (Draf.equals(Status_values)) {
				System.out.println("Matched || Expected Value :" + Draf + " || Actual value :" + Status_values);
				Extent_pass_New(driver, "Matched || Expected Value is : " + Draf+ " || Actual value is : " + Status_values, test, test1);
			} else {
				System.out.println("Not Matched || Expected Value  :" + Draf + " || Actual value :" + Status_values);
				Extent_fail(driver, "Not Matched || Expected Value is : " +Draf+ " || Actual value is : " + Status_values, test, test1);
			}
				
			Step_End(10, "If the activities are in draft status then ensure that the system shows the car expense status as Draft", test, test1);	
			
			Step_End(14, "If the some of the activities are  draft status and other activities are in approved status means,then ensure that the system shows the car expense status as Draft", test, test1);
		}else if(submited) {
			
              Step_Start(11, "If the actvities are in submitted status then ensure that the system shows the car expense status as Submitted", test, test1);
			
              Step_Start(15, "If the some of the activities are  submitted status and other activities are in approved status means,then ensure that the system shows the car expense status as Submitted", test, test1);
  			
			  if (Submitted.equals(Status_values)) {
				System.out.println("Matched || Expected Value :" + Submitted + " || Actual value :" + Status_values);
				Extent_pass_New(driver, "Matched || Expected Value is : " + Submitted+ " || Actual value is : " + Status_values, test, test1);
			  } else {
				System.out.println("Not Matched || Expected Value :" + Submitted + " || Actual value :" + Status_values);
				Extent_fail(driver, "Not Matched || Expected Value is : " +Submitted+ " || Actual value is : " + Status_values, test, test1);
			  }
				
			Step_End(11, "If the actvities are in submitted status then ensure that the system shows the car expense status as Submitted", test, test1);		
			Step_End(15, "If the some of the activities are  submitted status and other activities are in approved status means,then ensure that the system shows the car expense status as Submitted", test, test1);
			
		}else if(rejected) {
			
			Step_Start(13, "If the activities are in rejected status then ensure that the system shows the car expense status as Rejected", test, test1);
			
			  if (Rejected.equals(Status_values)) {
				System.out.println("Matched || Expected Valuee : " + Rejected + " || Actual value : " + Status_values);
				Extent_pass_New(driver, "Matched || Expected Value is : " + Rejected+ " || Actual value is : " + Status_values, test, test1);
			  } else {
				System.out.println("Not Matched || Expected Value :" + Rejected + " || Actual value :" + Status_values);
				Extent_fail(driver, "Not Matched || Expected Value is : " +Rejected+ " || Actual value is : " + Status_values, test, test1);
			  }
				
			Step_End(13, "If the activities are in rejected status then ensure that the system shows the car expense status as Rejected", test, test1);		
						
		}else if(partially_approved) {
			
			Step_Start(16, "If the some of the activities are  rejected status and other activities are in approved status means,then ensure that the system shows the car expense status as Partially approved", test, test1);
			
			  if (PartlyApproved.equals(Status_values)) {
				System.out.println("Matched || Expected Value :" + PartlyApproved + " || Actual value :" + Status_values);
				Extent_pass_New(driver, "Matched || Expected Value is : " + PartlyApproved+ " || Actual value is : " + Status_values, test, test1);
			  } else {
				System.out.println(" Not Matched || Expected Value :" + PartlyApproved + " || Actual value :" + Status_values);
				Extent_fail(driver, "Not Matched || Expected Value is : " +PartlyApproved+ " || Actual value is : " + Status_values, test, test1);
			  }
				
			Step_End(16, "If the some of the activities are  rejected status and other activities are in approved status means,then ensure that the system shows the car expense status as Partially approved", test, test1);		
			
		}else if(approved){
			
			Step_Start(12, "If the activities are in approved status then ensure that the sytsem shows the car expense status as Approved", test, test1);
			
			  if (Approved_Val.equals(Status_values)) {
				System.out.println("Matched || Expected Value :" + Approved_Val + "actual value :" + Status_values);
				Extent_pass_New(driver, "Matched || Expected Value is : " + Approved_Val+ " || Actual Report Activity is : " + Status_values, test, test1);
			  } else {
				System.out.println("Not Matched || Expected Value :" + Approved_Val + " || Actual value :" + Status_values);
				Extent_fail(driver, "Not Matched || Expected Value is : " +Approved_Val+ " || Actual value is : " + Status_values, test, test1);
			  }
				
			Step_End(12, "If the activities are in approved status then ensure that the sytsem shows the car expense status as Approved", test, test1);		
			
			
		}else {
			Extent_fail(driver, "Not Matched || "+ Status_values, test, test1);
		}
		 Extent_completed(tc_Name, test, test1);		
		
	}
}
