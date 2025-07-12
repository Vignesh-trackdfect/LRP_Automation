package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS014 extends Keywords{

	public void  Cost_Activity_Report_TS014(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS014";
		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		
		String CAR_Retrieve_Type1 = Excel_data.get("CAR_Retrieve_Type1");
		String CAR_Retrieve_Condition1 = Excel_data.get("CAR_Retrieve_Condition1");
		String CAR_Number_Retrieve_Value1 = Excel_data.get("CAR_Number_Retrieve_Value1");

		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		String Expense_Table_Headers = Excel_data.get("Expense_Table_Headers");
		String Predictable_table_Headers = Excel_data.get("Predictable_table_Headers");
		
		String Activity_Not_Remove_Popup = Excel_data.get("Activity_Not_Remove_Popup");
		
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
		
		Step_Start(4, "Check whether it opens a new search window.", test, test1);
		waitForElement(driver, type_Select1);
		Step_End(4, "Check whether it opens a new search window.", test, test1);
		
		Step_Start(5, "Enter the saved CAR No in the CAR No search field", test, test1);
		Step_Start(6, "Then click on the search button", test, test1);
		Step_Start(7, "System will show the CAR No", test, test1);
		Step_Start(8, "Click on the select button", test, test1);
		globalValueSearchWindow(driver,CAR_Retrieve_Condition1,CAR_Retrieve_Type1,CAR_Number_Retrieve_Value1,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(8, "Click on the select button", test, test1);
		Step_End(7, "System will show the CAR No", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		Step_End(5, "Enter the saved CAR No in the CAR No search field", test, test1);
		
		Step_Start(9, "System will retrieve the CAR", test, test1);
		waitForElement(driver, CAR_Number_Input_CAR);
		Step_End(9, "System will retrieve the CAR", test, test1);
		
		Step_Start(10, "Click on the tool bar edit option. ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		Step_End(10, "Click on the tool bar edit option. ", test, test1);
		
		Step_Start(11, "Click on the Expense report button and check system opens a new tab", test, test1);
		waitForElement(driver, Expensive_Report_Btn_CAR);
		click(driver,Expensive_Report_Btn_CAR);
		waitForElement(driver, Expense_table_CAR);
		Step_End(11, "Click on the Expense report button and check system opens a new tab", test, test1);
		
		Step_Start(12, "Click on the Approved Expenses tab.", test, test1);
		waitForElement(driver, Approved_Expensive_CAR);
		click(driver,Approved_Expensive_CAR);
		waitForElement(driver, App_Expensive_Table_CAR);
		Step_End(12, "Click on the Approved Expenses tab.", test, test1);

		Step_Start(13, "Copy all the Head which is available in the AG grid at the Head column", test, test1);
		waitForElement(driver, App_Expensive_Column_Filt_CAR);
		click(driver, App_Expensive_Column_Filt_CAR);
		waitForElement(driver, App_Expensive_Filter_input_CAR);
		jsClick(driver, App_SelectAll_Checkbox_Expensive_CAR);
		
		List<String> ExpensiveTable_Headers=splitAndExpand(Expense_Table_Headers);
		for(String FilterHeader : ExpensiveTable_Headers) {
			waitForElement(driver, App_Expensive_Filter_input_CAR);
			clear(driver, App_Expensive_Filter_input_CAR);
			waitForElement(driver, App_Expensive_Filter_input_CAR);
			sendKeys(driver, App_Expensive_Filter_input_CAR,FilterHeader);
		
			String checkbox=String.format(App_Select_Column_Expensive_CAR,FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}
		
		jsClick(driver, App_Expensive_Column_Filt_CAR);
		waitForElement(driver, App_Expensive_Table_CAR);
		
		List<Map<String, String>> App_Expensive_TableData = extractTableDataByColumnWithoutScroll(driver, App_Expensive_Table_CAR);
		System.out.println("App_Expensive_TableData : "+App_Expensive_TableData);
		
		List<String> Activity_names_Expense=getTableHeaderCellList(App_Expensive_TableData,"Activity Name");
		List<String> Activity_Head_Expense=getTableHeaderCellList(App_Expensive_TableData,"Head");
		List<String> Activity_Contract_Expense=getTableHeaderCellList(App_Expensive_TableData,"Contract No");
		List<String> Activity_EqpType_Expense=getTableHeaderCellList(App_Expensive_TableData,"Eqp Type");
		
		Step_End(13, "Copy all the Head which is available in the AG grid at the Head column", test, test1);
		
		Step_Start(14, "Close the expense report tab", test, test1);
		waitForElement(driver, Close_Expense_CAR);
		click(driver,Close_Expense_CAR);
		Step_End(14, "Close the expense report tab", test, test1);
		
		Step_Start(15, ".Select the Predictable reporting tab and search the Head in the AG grid and select the activity", test, test1);
		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		waitForElement(driver, Predictable_Table_CAR);
	
		if(isdisplayed(driver, Predictable_Grid_Cell_CAR)) {
			
			waitForElement(driver, Column_SelectMenu);
			click(driver, Column_SelectMenu);
			waitForElement(driver, column_SearchBox_CAR);
			jsClick(driver, PR_Deselect);
			
			List<String> predictable_Headers=splitAndExpand(Predictable_table_Headers);
			for(String FilterHeader : predictable_Headers) {
				waitForElement(driver, column_SearchBox_CAR);
				clear(driver, column_SearchBox_CAR);
				waitForElement(driver, column_SearchBox_CAR);
				sendKeys(driver, column_SearchBox_CAR,FilterHeader);
			
				String checkbox=String.format(Select_Column_tableHead,FilterHeader);
				waitForElement(driver, checkbox);
				jsClick(driver, checkbox);
			}
			
			jsClick(driver, Column_SelectMenu);
			
			waitForElement(driver, Predictable_Table_CAR);
			
			waitForElement(driver, Predicatble_More_Grid_CAR);
			click(driver,Predicatble_More_Grid_CAR);
			
			waitForElement(driver, Predicatble_ConditionFilter_CAR);
			click(driver,Predicatble_ConditionFilter_CAR);
			
			for(int i=0;i<Activity_names_Expense.size();i++) {
				boolean selctedColumn=false;

				waitForElement(driver, Activity_Name_CAR);
				clear(driver,Activity_Name_CAR);
				sendKeys(driver, Activity_Name_CAR, Activity_names_Expense.get(i));
				
				waitForElement(driver, Head_Filter_input_CAR);
				clear(driver,Head_Filter_input_CAR);
				sendKeys(driver, Head_Filter_input_CAR, Activity_Head_Expense.get(i));
				
				waitForElement(driver, EqpType_Filter_input_CAR);
				clear(driver,EqpType_Filter_input_CAR);
				sendKeys(driver, EqpType_Filter_input_CAR, Activity_EqpType_Expense.get(i));
				
				waitForElement(driver, ContractNo_Filter_Input_CAR);
				clear(driver,ContractNo_Filter_Input_CAR);
				sendKeys(driver, ContractNo_Filter_Input_CAR, Activity_Contract_Expense.get(i));
				
				String checkbox=String.format(Select_CheckBox_Predictable_CAR, Activity_names_Expense.get(i));
				if(isdisplayed(driver, Predictable_Grid_Cell_CAR)) {
					jsClick(driver, checkbox);
					selctedColumn=true;
				}
				
				if(selctedColumn) {
					Step_Start(17, "Click on the Remove_Btn_CAR button which is available at the bottom of the AG grid.", test, test1);
					waitForElement(driver, Predictable_Remove_btn_CAR);
					click(driver,Predictable_Remove_btn_CAR);
					Step_End(17, "Click on the Remove_Btn_CAR button which is available at the bottom of the AG grid.", test, test1);

					Step_Start(18, "Check whether the system prompts the information message as \"Expense is approved for some selected Equipment type / Equipment Status. Cannot change / remove\" along with the OK button.", test, test1);
					
					waitForPopup(driver, popup_Message, Activity_Not_Remove_Popup);
					String Popup_Text_Act=getText(driver, popup_Message);
					
				    if(Popup_Text_Act.equals(Activity_Not_Remove_Popup)) {
						System.out.println("Popup Matched  ||   Expected : "+Activity_Not_Remove_Popup+"   ||   Actual   : "+Popup_Text_Act);
						Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Activity_Not_Remove_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
					}else {
						System.out.println("Popup Not Matched  ||   Expected : "+Activity_Not_Remove_Popup+"   ||   Actual   : "+Popup_Text_Act);
						Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Activity_Not_Remove_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
					}

					waitForElement(driver, popup_Message_Ok_Button);
					click(driver,popup_Message_Ok_Button);
					elementnotvisible(driver, popup_Message_Ok_Button);
					jsClick(driver, checkbox);
					Step_End(18, "Check whether the system prompts the information message as \"Expense is approved for some selected Equipment type / Equipment Status. Cannot change / remove\" along with the OK button.", test, test1);
				}
				
			}
		}
		Step_End(15, ".Select the Predictable reporting tab and search the Head in the AG grid and select the activity", test, test1);

		Step_Start(16, "Click on the Unpredictable reporting tab and search the Head in the AG grid and select the activity", test, test1);

		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver,UnPredictable_Tab_CAR);
		waitForElement(driver, UnPredictable_Table_CAR);
		
		waitForElement(driver, Column_SelectMenu);
		click(driver, Column_SelectMenu);
		waitForElement(driver, column_SearchBox_CAR);
		jsClick(driver, UPR_Deselect);
		
		List<String> Unpredictable_Headers=splitAndExpand(Predictable_table_Headers);
		for(String FilterHeader : Unpredictable_Headers) {
			waitForElement(driver, column_SearchBox_CAR);
			clear(driver, column_SearchBox_CAR);
			waitForElement(driver, column_SearchBox_CAR);
			sendKeys(driver, column_SearchBox_CAR,FilterHeader);
		
			String checkbox=String.format(Select_Column_CAR,FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}
		
		jsClick(driver, Column_SelectMenu);
		
		waitForElement(driver, More_Grid_UnPredictable_CAR);
		click(driver,More_Grid_UnPredictable_CAR);
		
		waitForElement(driver, Condition_UnPredictable_CAR);
		click(driver,Condition_UnPredictable_CAR);
		
		for(int i=0;i<Activity_names_Expense.size();i++) {
			boolean selctedColumn=false;
			waitForElement(driver, Activity_Name_CAR);
			clear(driver,Activity_Name_CAR);
			sendKeys(driver, Activity_Name_CAR, Activity_names_Expense.get(i));
			
			waitForElement(driver, Head_Filter_input_CAR);
			clear(driver,Head_Filter_input_CAR);
			sendKeys(driver, Head_Filter_input_CAR, Activity_Head_Expense.get(i));
			
			waitForElement(driver, EqpType_Filter_input_CAR);
			clear(driver,EqpType_Filter_input_CAR);
			sendKeys(driver, EqpType_Filter_input_CAR, Activity_EqpType_Expense.get(i));
			
			waitForElement(driver, ContractNo_Filter_Input_CAR);
			clear(driver,ContractNo_Filter_Input_CAR);
			sendKeys(driver, ContractNo_Filter_Input_CAR, Activity_Contract_Expense.get(i));			
			
			String checkbox=String.format(Select_Table_Row_CAR, Activity_names_Expense.get(i));
			if(isdisplayed(driver, UnPredictable_Grid_Cell_CAR)) {
				jsClick(driver, checkbox);
				selctedColumn=true;
			}
				
			Step_End(16, "Click on the Unpredictable reporting tab and search the Head in the AG grid and select the activity", test, test1);
			
			if(selctedColumn) {
				Step_Start(17, "Click on the Remove_Btn_CAR button which is available at the bottom of the AG grid.", test, test1);
				waitForElement(driver, Unpredicatble_Remove_btn_CAR);
				click(driver,Unpredicatble_Remove_btn_CAR);
				Step_End(17, "Click on the Remove_Btn_CAR button which is available at the bottom of the AG grid.", test, test1);

				Step_Start(18, "Check whether the system prompts the information message as \"Expense is approved for some selected Equipment type / Equipment Status. Cannot change / remove\" along with the OK button.", test, test1);
				
				waitForPopup(driver, popup_Message, Activity_Not_Remove_Popup);
				String Popup_Text_Act=getText(driver, popup_Message);
				
				if(Popup_Text_Act.equals(Activity_Not_Remove_Popup)) {
					System.out.println("Popup Matched  ||   Expected : "+Activity_Not_Remove_Popup+"   ||   Actual   : "+Popup_Text_Act);
					Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Activity_Not_Remove_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
				}else {
					System.out.println("Popup Not Matched  ||   Expected : "+Activity_Not_Remove_Popup+"   ||   Actual   : "+Popup_Text_Act);
					Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Activity_Not_Remove_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
				}

				waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
				
				elementnotvisible(driver, popup_Message_Ok_Button);
				jsClick(driver, checkbox);
				Step_End(18, "Check whether the system prompts the information message as \"Expense is approved for some selected Equipment type / Equipment Status. Cannot change / remove\" along with the OK button.", test, test1);

			}
			
		}
		
		Extent_completed(tc_Name, test, test1);		

		
	}
	
}
