package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS034 extends Keywords{

	public void  Cost_Activity_Report_TS034(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS034";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		
		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		
		String Expensive_Headers_List = Excel_data.get("Expensive_Headers_List");
		
		String Disbursement_Module = Excel_data.get("Disbursement_Module");
		String Disbursment_Retrieve_Type = Excel_data.get("Disbursment_Retrieve_Type");
		String Disbursment_Retrieve_Condition = Excel_data.get("Disbursment_Retrieve_Condition");
		
		String Vendor_Invoice_Registration_Module = Excel_data.get("Vendor_Invoice_Registration_Module");
		String Vendor_Code_Filter_Type = Excel_data.get("Vendor_Code_Filter_Type");
		String Vendor_Code_Filter_Condition = Excel_data.get("Vendor_Code_Filter_Condition");
		String Vendor_Invoice_Number_value = Excel_data.get("Vendor_Invoice_Number_value");
		String CAR_ADD_Condition = Excel_data.get("CAR_ADD_Condition");
		String Select_Payment_method = Excel_data.get("Select_Payment_method");
		String Vendor_Invoice_Saved_Popup = Excel_data.get("Vendor_Invoice_Saved_Popup");
		String Disbursement_Success_popup = Excel_data.get("Disbursement_Success_popup");
		
		String CAR_ADD_Header_Name = Excel_data.get("CAR_ADD_Header_Name");
		
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
		
		Step_Start(4, "Check whether it opens a new search window", test, test1);
		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button ", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button", test, test1);

		globalValueSearchWindow(driver,CAR_Retrieve_Condition,CAR_Retrieve_Type,CAR_Number_Retrieve,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(7, "System will show the CAR No. and Click on the select button", test, test1);
		Step_End(6, "Then click on the search button ", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_End(4, "Check whether it opens a new search window", test, test1);

		Step_Start(8, "System will retrieve the CAR", test, test1);
		waitForElement(driver, CAR_Number_Input_CAR);
		
		waitForElement(driver, Contract_Type_Input_CAR);
		String ContractType=getText(driver, Contract_Type_Input_CAR);
		
		waitForElement(driver, Arrival_Date_Input_CAR);
		String Arrival_Date_Input_CAR1=getAttribute(driver, Arrival_Date_Input_CAR, "value");
		Step_End(8, "System will retrieve the CAR", test, test1);
		
		Step_Start(9, "Click on the expense report option", test, test1);
		waitForElement(driver, Expensive_Report_Btn_CAR);
		click(driver,Expensive_Report_Btn_CAR);
		
		waitForElement(driver, Approved_Expensive_CAR);
		click(driver,Approved_Expensive_CAR);
		waitForElement(driver, App_Expensive_Table_CAR);
		
		waitForElement(driver, App_Expensive_Column_Filt_CAR);
		click(driver,App_Expensive_Column_Filt_CAR);
		waitForElement(driver, App_Expensive_Filter_input_CAR);
		jsClick(driver, App_SelectAll_Checkbox_Expensive_CAR);
		waitForElement(driver, App_Expensive_Filter_input_CAR);
		if(isdisplayed(driver, App_Expense_table_Data)) {
			jsClick(driver, App_SelectAll_Checkbox_Expensive_CAR);
		}
		
		
		List<String> AppExpensiveTable_Headers=splitAndExpand(Expensive_Headers_List);
		for(String FilterHeader : AppExpensiveTable_Headers) {
			waitForElement(driver, App_Expensive_Filter_input_CAR);
			clear(driver, App_Expensive_Filter_input_CAR);
			waitForElement(driver, App_Expensive_Filter_input_CAR);
			sendKeys(driver, App_Expensive_Filter_input_CAR,FilterHeader);
		
			String checkbox=String.format(App_Select_Column_Expensive_CAR,FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}
		jsClick(driver, App_Expensive_Column_Filt_CAR);
		Step_End(9, "Click on the expense report option", test, test1);
		
		
		if(isDisplayed(driver, Activity_Green_Row_CAR)) {
			Step_Start(10, "Check whether the activities are in green colour. This indicates that for such activities disbursement is done.", test, test1);
			waitForElement(driver, Activity_Green_Row_CAR);
			Step_End(10, "Check whether the activities are in green colour. This indicates that for such activities disbursement is done.", test, test1);

			Step_Start(11, "Then go to the Disbusement No. column.  and copy the disbursement number", test, test1);
			waitForElement(driver, Disbursment_Column_Expense_CAR);
			String Disbursment_Number_Expensive=getText(driver, Disbursment_Column_Expense_CAR);
			waitForElement(driver, Close_Expense_CAR);
			click(driver,Close_Expense_CAR);
			Step_End(11, "Then go to the Disbusement No. column.  and copy the disbursement number", test, test1);
			
			Step_Start(12, "Enter the screen name as \"Disbursement\" in the module search field.", test, test1);
			moduleNavigate(driver, Disbursement_Module);
			Step_End(12, "Enter the screen name as \"Disbursement\" in the module search field.", test, test1);
			
			Step_Start(13, "Click the global search option in the toolbar. ", test, test1);
			waitForElement(driver, SearchButton_Toolbar);
			click(driver,SearchButton_Toolbar);
			Step_End(13, "Click the global search option in the toolbar. ", test, test1);
			
			Step_Start(14, "Paste the disbursement number in search field and click on search. ", test, test1);
			Step_Start(15, "System will show the disbursement number.  and click on the select button ", test, test1);

			globalValueSearchWindow(driver,Disbursment_Retrieve_Condition,Disbursment_Retrieve_Type,Disbursment_Number_Expensive,"","","","");
			Step_End(15, "System will show the disbursement number.  and click on the select button ", test, test1);
			Step_End(14, "Paste the disbursement number in search field and click on search. ", test, test1);
			
			Step_Start(16, "Ensure that the system retrieves the disbursement number", test, test1);
			waitForElement(driver, Disbursement_input_);
			String disbursementNumber=getAttribute(driver, Disbursement_input_, "value");
			Step_End(16, "Ensure that the system retrieves the disbursement number", test, test1);
			
			Step_Start(20, "Go to disbursement number column and verify whether it matches with the Disbursement No. created ", test, test1);
			if(disbursementNumber.equals(Disbursment_Number_Expensive)) {
				System.out.println("Disbursement number Matched ||  Expected : "+Disbursment_Number_Expensive+"  ||  Actual  : "+disbursementNumber);
				Extent_pass_New(driver, "Disbursement number Matched ||  Expected : "+Disbursment_Number_Expensive+"  ||  Actual  : "+disbursementNumber, test, test1);
			}else {
				System.out.println("Disbursement number Not Matched ||  Expected : "+Disbursment_Number_Expensive+"  ||  Actual  : "+disbursementNumber);
				Extent_fail(driver, "Disbursement number Not Matched ||  Expected : "+Disbursment_Number_Expensive+"  ||  Actual  : "+disbursementNumber, test, test1);
			}
			
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			Step_End(20, "Go to disbursement number column and verify whether it matches with the Disbursement No. created ", test, test1);
			
		}else {
			
			waitForElement(driver, Activity_name_Expense_CAR);
			String Activity_NameExpense=getText(driver, Activity_name_Expense_CAR);
			
			List<Map<String, String>> App_Expensive_TableData = extractTableDataByColumnWithoutScroll(driver, App_Expensive_Table_CAR);
			System.out.println("App_Expensive_TableData : "+App_Expensive_TableData);
			
			String App_Exp_UserName_Value=getValueByFirstColumnAndHeader(App_Expensive_TableData,"Activity Name",Activity_NameExpense,"Vendor Code");
			
			waitForElement(driver, Close_Expense_CAR);
			click(driver,Close_Expense_CAR);
			
			Step_Start(17, "If the activities are not in green colour and it is in yellow colour, then enter the screen name as 'Vendor invoice registration' in module search field ", test, test1);
			moduleNavigate(driver, Vendor_Invoice_Registration_Module);
			Step_End(17, "If the activities are not in green colour and it is in yellow colour, then enter the screen name as 'Vendor invoice registration' in module search field ", test, test1);

			Step_Start(18, "Select the required DA type and CAR No. and click on show button", test, test1);
			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver,Vedor_Code_Search_Button_VIR);
			
			globalValueSearchWindow(driver,Vendor_Code_Filter_Condition,Vendor_Code_Filter_Type,App_Exp_UserName_Value,"","","","");

			Step_End(18, "Select the required DA type and CAR No. and click on show button", test, test1);
			
			Step_Start(19, "Then the required details will add to the AG grid and click on tool bar save button", test, test1);
			waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
			clear(driver,Vendor_Invoice_Number_Input_VIR);
			sendKeys(driver, Vendor_Invoice_Number_Input_VIR, Vendor_Invoice_Number_value);
			
			waitForElement(driver, Contract_Type_Input_VIR);
			click(driver,Contract_Type_Input_VIR);
			
			String selectContract=String.format(Select_Contract_Type_VIR,ContractType);
			waitForElement(driver, selectContract);
			click(driver,selectContract);
			
			waitForElement(driver, Payment_Method_Input_VIR);
			click(driver,Payment_Method_Input_VIR);
			
			String selectPayment=String.format(Select_Payment_Method_VIR,Select_Payment_method);
			waitForElement(driver, selectPayment);
			click(driver,selectPayment);
			
			waitForElement(driver, CAR_No_option_VIR);
			click(driver,CAR_No_option_VIR);
			
			waitForElement(driver, CAR_PLUS_button_VIR);
			click(driver,CAR_PLUS_button_VIR);
			twoColumnSearchWindow(driver,CAR_ADD_Header_Name,CAR_ADD_Condition,CAR_Number_Retrieve);
			waitForElement(driver, ADD_button_VIR);
			click(driver,ADD_button_VIR);
			
			waitForElement(driver, Act_Expensive_input_VIR);
			String invoice_Amount=getAttribute(driver, Act_Expensive_input_VIR, "value");
			
			waitForElement(driver, Vendor_Invoice_input_VIR);
			clear(driver,Vendor_Invoice_input_VIR);
			waitForElement(driver, Vendor_Invoice_input_VIR);
			sendKeys(driver, Vendor_Invoice_input_VIR, invoice_Amount);
			
			waitForElement(driver, Confirmed_button_VIR);
			click(driver,Confirmed_button_VIR);
	
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message, Vendor_Invoice_Saved_Popup);
			String Popup_invoice_Text_Act=getText(driver, popup_Message);
			
			if(Popup_invoice_Text_Act.equals(Vendor_Invoice_Saved_Popup)) {
				System.out.println("Popup Matched  ||   Expected : "+Vendor_Invoice_Saved_Popup+"   ||   Actual   : "+Popup_invoice_Text_Act);
				Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Vendor_Invoice_Saved_Popup+"   ||   Actual   : "+Popup_invoice_Text_Act, test, test1);
			}else {
				System.out.println("Popup Not Matched  ||   Expected : "+Vendor_Invoice_Saved_Popup+"   ||   Actual   : "+Popup_invoice_Text_Act);
				Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Vendor_Invoice_Saved_Popup+"   ||   Actual   : "+Popup_invoice_Text_Act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
			waitForElement(driver, Vendor_Register_Number_VIR);
			
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
			moduleNavigate(driver, Disbursement_Module);
			
			waitForElement(driver, By_Date_button_Disbursement);
			click(driver,By_Date_button_Disbursement);
			
			waitForElement(driver, From_Date_input_Disbursement);
			selectDatePicker(driver,From_Date_input_Disbursement,Arrival_Date_Input_CAR1);
			
			waitForElement(driver, Show_button_Disbursment);
			click(driver,Show_button_Disbursment);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message, Disbursement_Success_popup);
			String Popup_disbursement_Text_Act=getText(driver, popup_Message);
			
			if(Popup_disbursement_Text_Act.equals(Disbursement_Success_popup)) {
				System.out.println("Popup Matched  ||   Expected : "+Disbursement_Success_popup+"   ||   Actual   : "+Popup_disbursement_Text_Act);
				Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Disbursement_Success_popup+"   ||   Actual   : "+Popup_disbursement_Text_Act, test, test1);
			}else {
				System.out.println("Popup Not Matched  ||   Expected : "+Disbursement_Success_popup+"   ||   Actual   : "+Popup_disbursement_Text_Act);
				Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Disbursement_Success_popup+"   ||   Actual   : "+Popup_disbursement_Text_Act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
			waitForElement(driver, Disbursement_input_);
			String Disbursement_num_New=getAttribute(driver, Disbursement_input_, "value");
			
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			Step_End(19, "Then the required details will add to the AG grid and click on tool bar save button", test, test1);
			
			Step_Start(20, "Go to disbursement number column and verify whether it matches with the Disbursement No. created", test, test1);
			waitForElement(driver, Expensive_Report_Btn_CAR);
			click(driver,Expensive_Report_Btn_CAR);
			
			waitForElement(driver, Approved_Expensive_CAR);
			click(driver,Approved_Expensive_CAR);
			waitForElement(driver, App_Expensive_Table_CAR);
			
			waitForElement(driver, App_Expensive_Column_Filt_CAR);
			click(driver,App_Expensive_Column_Filt_CAR);
			waitForElement(driver, App_Expensive_Filter_input_CAR);
			jsClick(driver, App_SelectAll_Checkbox_Expensive_CAR);
			waitForElement(driver, App_Expensive_Filter_input_CAR);
			if(isdisplayed(driver, App_Expense_table_Data)) {
				jsClick(driver, App_SelectAll_Checkbox_Expensive_CAR);
			}
			
			for(String FilterHeader : AppExpensiveTable_Headers) {
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
			App_Expensive_TableData = extractTableDataByColumnWithoutScroll(driver, App_Expensive_Table_CAR);
			System.out.println("App_Expensive_TableData : "+App_Expensive_TableData);
			
			String disbursement_number_Act=getValueByFirstColumnAndHeader(App_Expensive_TableData,"Activity Name",Activity_NameExpense,"Disbursement No");
			
			
			if(Disbursement_num_New.equals(disbursement_number_Act)) {
				System.out.println("Disbursement Number Matched ||  Expected  : "+Disbursement_num_New+"   ||   Actual : "+disbursement_number_Act);
				Extent_pass_New(driver, "Disbursement Number Matched ||  Expected  : "+Disbursement_num_New+"   ||   Actual : "+disbursement_number_Act, test, test1);
			}else {
				System.out.println("Disbursement Number Not Matched ||  Expected  : "+Disbursement_num_New+"   ||   Actual : "+disbursement_number_Act);
				Extent_fail(driver, "Disbursement Number Not Matched ||  Expected  : "+Disbursement_num_New+"   ||   Actual : "+disbursement_number_Act, test, test1);
			}
			
			Step_End(20, "Go to disbursement number column and verify whether it matches with the Disbursement No. created", test, test1);

		}
		
		Extent_completed(tc_Name, test, test1);
		
	}
}
