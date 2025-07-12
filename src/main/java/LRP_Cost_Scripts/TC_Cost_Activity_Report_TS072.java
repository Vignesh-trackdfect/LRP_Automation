package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS072 extends Keywords{

	public void  Cost_Activity_Report_TS072(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS072";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		
		String Select_Contract_type_Value = Excel_data.get("Select_Contract_type_Value");
		String Select_Mode_type = Excel_data.get("Select_Mode_type");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Service_details_Codition = Excel_data.get("Service_details_Codition");
		String Arrival_Date_Condition = Excel_data.get("Arrival_Date_Condition");
		String Arrival_Date_Value = Excel_data.get("Arrival_Date_Value");
		
		String Service_Header = Excel_data.get("Service_Header");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String Port_Header = Excel_data.get("Port_Header");
		String Terminal_Header = Excel_data.get("Terminal_Header");
		String Arrival_Date_Header = Excel_data.get("Arrival_Date_Header");
		
		String Select_Predicatble_Sub_Activity_Name = Excel_data.get("Select_Predicatble_Sub_Activity_Name");
		String Un_Predictable_Table_Filter_Headers = Excel_data.get("Un_Predictable_Table_Filter_Headers");
		String Un_Predictable_Vendor_Code = Excel_data.get("Un_Predictable_Vendor_Code");
		String Container_Activity_report_Saved_popup = Excel_data.get("Container_Activity_report_Saved_popup");
		String Un_Predictable_Activate_Name = Excel_data.get("Un_Predictable_Activate_Name");
		String Value_Amount = Excel_data.get("Value_Amount");
		String Type_Quantity = Excel_data.get("Type_Quantity");
		
		String Expensive_Table_Filter_Headers = Excel_data.get("Expensive_Table_Filter_Headers");
		String Expensive_Submitted_Popup = Excel_data.get("Expensive_Submitted_Popup");
		String Expense_Approved_Popup = Excel_data.get("Expense_Approved_Popup");
		String Expense_Approve_Limit_Error_Popup = Excel_data.get("Expense_Approve_Limit_Error_Popup");

		String User_CAR_Approval_Module = Excel_data.get("User_CAR_Approval_Module");
		String CAR_Already_Created = Excel_data.get("CAR_Already_Created");

		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		
		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		
		waitForElement(driver, Contract_Type_Input_CAR);
		click(driver,Contract_Type_Input_CAR);
		
		String SelectContract=String.format(Select_Contract_Type_CAR, Select_Contract_type_Value);
		waitForElement(driver, SelectContract);
		click(driver,SelectContract);
		
		waitForElement(driver, Mode_Select_Input_CAR);
		click(driver,Mode_Select_Input_CAR);
		
		String SelectModeValue=String.format(Select_Mode_type_CAR, Select_Mode_type);
		waitForElement(driver, SelectModeValue);
		click(driver,SelectModeValue);
		
		Step_Start(3, "Click on the Service search button and select the required service code.   ", test, test1);
		waitForElement(driver, Service_Search_Btn_CAR);
		click(driver,Service_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Service_Header,Service_details_Codition,Service_Code);
		Step_End(3, "Click on the Service search button and select the required service code.   ", test, test1);
		
		Step_Start(4, "Click on the Vessel search button and select the required vessel code.  ", test, test1);
		waitForElement(driver, Vessel_Search_Btn_CAR);
		click(driver,Vessel_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Vessel_Header,Service_details_Codition,Vessel_Code);
		Step_End(4, "Click on the Vessel search button and select the required vessel code.  ", test, test1);
		
		Step_Start(5, "Click on the Port search button and select the required port code.", test, test1);
		waitForElement(driver, Port_Search_Btn_CAR);
		click(driver,Port_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Port_Header,Service_details_Codition,Port_Code);
		Step_End(5, "Click on the Port search button and select the required port code.", test, test1);
		
		Step_Start(6, "Click on the Terminal search button and select the required terminal code.", test, test1);
		waitForElement(driver, Terminal_Search_Btn_CAR);
		click(driver,Terminal_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Terminal_Header,Service_details_Codition,Terminal_Code);
		Step_End(6, "Click on the Terminal search button and select the required terminal code.", test, test1);
		
		Step_Start(7, ".Click on the Arrival date search button and select the required date.", test, test1);
		waitForElement(driver, Arrival_Date_Search_Btn_CAR);
		click(driver,Arrival_Date_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Arrival_Date_Header,Arrival_Date_Condition,Arrival_Date_Value);
		Step_End(7, ".Click on the Arrival date search button and select the required date.", test, test1);
		
		Step_Start(8, "Click on the Show button ", test, test1);
		waitForElement(driver, Show_Button_CAR);
		click(driver,Show_Button_CAR);
		Step_End(8, "Click on the Show button", test, test1);
		
		if(isDisplayed(driver, popup_Message)) {
			String popup_Act=getText(driver, popup_Message);
			if(CAR_Already_Created.equals(popup_Act)) {
				System.out.println("Expected : CAR should not Already Created for the given inputs || Actual : CAR Already created for the given inputs");
				Extent_FailNew(driver, "Expected : CAR should not Already Created for the given inputs || Actual : CAR Already created for the given inputs", test, test1);
			}else {
				System.out.println("Expected : Popup Should not Displayed when click the CAR Show button || Actual : Popup displayed When click the CAR Show button , Error : "+popup_Act );
				Extent_fail(driver, "Expected : Popup Should not Displayed when click the CAR Show button || Actual : Popup displayed When click the CAR Show button , Error : "+popup_Act , test, test1);
			}
		}
		
		
		Step_Start(9, "Click on the Predictable Reporting tab  ", test, test1);
		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		Step_End(9, "Click on the Predictable Reporting tab  ", test, test1);
		
		Step_Start(10, "Select the required data in the grid by using the check box selection", test, test1);
		String PredictableActivity_Column=String.format(Predictable_Activity_Column_CAR, Select_Predicatble_Sub_Activity_Name);
		waitForElement(driver, PredictableActivity_Column);
		click(driver,PredictableActivity_Column);
		Step_End(10, "Select the required data in the grid by using the check box selection", test, test1);
		
		Step_Start(11, "Click on the Unpredictable Reporting tab", test, test1);
		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver,UnPredictable_Tab_CAR);
		waitForElement(driver, UnPredictable_Table_CAR);
		Step_End(11, "Click on the Unpredictable Reporting tab", test, test1);
		
		Step_Start(12, "Select the required data in the grid by using the check box selection", test, test1);
		waitForElement(driver, Column_SelectMenu);
		click(driver, Column_SelectMenu);
		waitForElement(driver, column_SearchBox_CAR);
		
		jsClick(driver, UnPredictable_All_Checkbox_CAR);
		jsClick(driver, UnPredictable_All_Checkbox_CAR);
		
		List<String> Unpredictable_Headers=splitAndExpand(Un_Predictable_Table_Filter_Headers);
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

		waitForElement(driver, Activity_Name_CAR);
		sendKeys(driver, Activity_Name_CAR, Un_Predictable_Activate_Name);
		
		waitForElement(driver, Vendor_Code_Input_CAR);
		sendKeys(driver, Vendor_Code_Input_CAR, Un_Predictable_Vendor_Code);
		Step_End(12, "Select the required data in the grid by using the check box selection", test, test1);
		
		Step_Start(13, "After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and check whether the activity has any variables in formula column", test, test1);
		waitForElement(driver, Quantity_Column_CAR);
		doubleClick(driver,Quantity_Column_CAR);
		waitForElement(driver, quantity_Input_CAR);
		clear(driver,quantity_Input_CAR);
		sendKeys(driver, quantity_Input_CAR, Type_Quantity);
		
		waitForElement(driver, Formula_Column_CAR);
		String Formula_Value=getText(driver, Formula_Column_CAR);
		Step_End(13, "After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and check whether the activity has any variables in formula column", test, test1);

		if(!Formula_Value.equals("")) {
			Step_Start(15, "Incase,if the selected activity contains any formula means,input the required variable values and click on the apply variable button", test, test1);
			String UnPredictableActivity_Column=String.format(UnPredictable_Activity_Column_CAR, Un_Predictable_Activate_Name);
			waitForElement(driver, UnPredictableActivity_Column);
			click(driver,UnPredictableActivity_Column);
			
			waitForDisplay(driver, IsPredictable_Check_CAR);
			String predictableCheck=getAttribute1(driver, IsPredictable_Check_CAR, "aria-label");
			if(!predictableCheck.equals("checked")) {
				waitForElement(driver, Value_Input_Column_CAR);
				doubleClick(driver, Value_Input_Column_CAR);
				clear(driver,Value_Input_Column_CAR);
				sendKeys(driver, Value_Input_Column_CAR, Value_Amount);
				
				waitForElement(driver, Apply_Button_CAR);
				click(driver, Apply_Button_CAR);
			}
			Step_End(15, "Incase,if the selected activity contains any formula means,input the required variable values and click on the apply variable button", test, test1);

			Step_Start(17, "Click on the tool bar save button. System validates as \"Container activity report saved\" and click on the ok option.Go to expense report and click the open expenses and select the activities and click the approve option.System validates as \"Approved amount should be less than or equal to 30000.0\".Click on the ok option.", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, Container_Activity_report_Saved_popup);
			String Popup_Text_Act=getText(driver, popup_Message);
			
			if(Popup_Text_Act.equals(Container_Activity_report_Saved_popup)) {
				System.out.println("Popup Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act);
				Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
			}else {
				System.out.println("Popup Not Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act);
				Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
			
		}else {
			
			Step_Start(14, "Click on the tool bar save button,if the selected activity does not contains any formula", test, test1);
			String UnPredictableActivity_Column=String.format(UnPredictable_Activity_Column_CAR, Un_Predictable_Activate_Name);
			waitForElement(driver, UnPredictableActivity_Column);
			click(driver,UnPredictableActivity_Column);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
			Step_End(14, "Click on the tool bar save button,if the selected activity does not contains any formula", test, test1);

			Step_Start(17, "Click on the tool bar save button. System validates as \"Container activity report saved\" and click on the ok option.Go to expense report and click the open expenses and select the activities and click the approve option.System validates as \"Approved amount should be less than or equal to 30000.0\".Click on the ok option.", test, test1);
			waitForPopup(driver, popup_Message, Container_Activity_report_Saved_popup);
			String Popup_Text_Act=getText(driver, popup_Message);
			
			if(Popup_Text_Act.equals(Container_Activity_report_Saved_popup)) {
				System.out.println("Popup Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act);
				Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
			}else {
				System.out.println("Popup Not Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act);
				Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
		}

		moduleNavigate(driver, User_CAR_Approval_Module);

		String userName_Table=username.toLowerCase();
		
		waitForElement(driver, UserName_Filter_Input_UCA);
		sendKeys(driver, UserName_Filter_Input_UCA, username);
		
		waitForElement(driver, Approval_LimitTable_UCA);
				
		String user_Select_Column=String.format(Select_Row_UCA, username);
		if(isdisplayed(driver, user_Select_Column)) {
			
		}else {
			user_Select_Column=String.format(Select_Row_UCA, userName_Table);
			waitForElement(driver, user_Select_Column);
			doubleClick(driver, user_Select_Column);
		}
		
		waitForElement(driver, Approval_Limit_Input_UCA);
		String Approval_Value_User=getAttribute(driver, Approval_Limit_Input_UCA, "value");
		double Approval_Amount=getNumberValue1(Approval_Value_User);
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		waitForElement(driver, Expensive_Report_Btn_CAR);
		click(driver,Expensive_Report_Btn_CAR);
		
		waitForElement(driver, Expensive_Table_CAR);
		
		waitForElement(driver, Expensive_Column_Filt_CAR);
		click(driver, Expensive_Column_Filt_CAR);
		waitForElement(driver, Expensive_Filter_input_CAR);
		jsClick(driver, SelectAll_Checkbox_Expensive_CAR);
		
		List<String> ExpensiveTable_Headers=splitAndExpand(Expensive_Table_Filter_Headers);
		for(String FilterHeader : ExpensiveTable_Headers) {
			waitForElement(driver, Expensive_Filter_input_CAR);
			clear(driver, Expensive_Filter_input_CAR);
			waitForElement(driver, Expensive_Filter_input_CAR);
			sendKeys(driver, Expensive_Filter_input_CAR,FilterHeader);
		
			String checkbox=String.format(Select_Column_Expensive_CAR,FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}
		
		waitForElement(driver, Expensive_Column_Filt_CAR);
		click(driver, Expensive_Column_Filt_CAR);
		
		waitForElement(driver, Expensive_Table_CAR);
		String Expensive_Cost_Column=String.format(Expensive_Total_Cost_CAR, Un_Predictable_Vendor_Code);
		waitForElement(driver, Expensive_Cost_Column);
		String Expensive_Cost_value=getText(driver, Expensive_Cost_Column);
		double Expensive_Cost=Double.parseDouble(Expensive_Cost_value);
		click(driver,Expensive_Cost_Column);
		
		String Expensive_Currency_Column=String.format(Expensive_Currency_CAR, Un_Predictable_Vendor_Code);
		waitForElement(driver, Expensive_Currency_Column);
		String Currency_value=getText(driver, Expensive_Currency_Column);
		
		waitForElement(driver, Submit_Button_CAR);
		click(driver,Submit_Button_CAR);
		
		waitForPopup(driver, popup_Message, Expensive_Submitted_Popup);
		String Popup_Text_Act=getText(driver, popup_Message);
		
		if(Popup_Text_Act.equals(Expensive_Submitted_Popup)) {
			System.out.println("Popup Matched  ||   Expected : "+Expensive_Submitted_Popup+"   ||   Actual   : "+Popup_Text_Act);
			Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Expensive_Submitted_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected : "+Expensive_Submitted_Popup+"   ||   Actual   : "+Popup_Text_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Expensive_Submitted_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		String Expensive_Vendor_Column=String.format(Expensive_Vendor_Column_CAR, Un_Predictable_Vendor_Code);
		waitForElement(driver, Expensive_Vendor_Column);
		click(driver,Expensive_Vendor_Column);
		
		waitForElement(driver, Approve_button_CAR);
		click(driver,Approve_button_CAR);
		Step_End(17, "Click on the tool bar save button. System validates as \"Container activity report saved\" and click on the ok option.Go to expense report and click the open expenses and select the activities and click the approve option.System validates as \"Approved amount should be less than or equal to 30000.0\".Click on the ok option.", test, test1);

		if(Currency_value.equalsIgnoreCase("USD")&& Approval_Amount<Expensive_Cost) {
			
			waitForPopup(driver, popup_Message, Expense_Approve_Limit_Error_Popup);
			String PopupApproved_Text_Act=getText(driver, popup_Message);
			
			if(PopupApproved_Text_Act.contains(Expense_Approve_Limit_Error_Popup)) {
				System.out.println("Popup Matched  ||   Expected : "+Expense_Approve_Limit_Error_Popup+"   ||   Actual   : "+PopupApproved_Text_Act);
				Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Expense_Approve_Limit_Error_Popup+"   ||   Actual   : "+PopupApproved_Text_Act, test, test1);
			}else {
				System.out.println("Popup Not Matched  ||   Expected : "+Expense_Approve_Limit_Error_Popup+"   ||   Actual   : "+PopupApproved_Text_Act);
				Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Expense_Approve_Limit_Error_Popup+"   ||   Actual   : "+PopupApproved_Text_Act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
			waitForElement(driver, Close_Expense_CAR);
			click(driver,Close_Expense_CAR);
			
			Step_Start(18, "Enter the screen name as \"User CAR approval limit\" in the module search field", test, test1);
			moduleNavigate(driver, User_CAR_Approval_Module);
			Step_End(18, "Enter the screen name as \"User CAR approval limit\" in the module search field", test, test1);
	
			userName_Table=username.toLowerCase();
			Step_Start(19, "Select the required details and verify the Approval limit amount", test, test1);
			waitForElement(driver, UserName_Filter_Input_UCA);
			sendKeys(driver, UserName_Filter_Input_UCA, userName_Table);
			
			waitForElement(driver, Approval_LimitTable_UCA);
			user_Select_Column=String.format(Select_Row_UCA, userName_Table);
			waitForElement(driver, user_Select_Column);
			doubleClick(driver, user_Select_Column);
			Step_End(19, "Select the required details and verify the Approval limit amount", test, test1);

			Step_Start(20, "Click on the edit option and update it", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver,Edit_Button_toolBar);
			
			double newAmount=Expensive_Cost+100;
			String New_Amount_Value=String.valueOf(newAmount);
			
			waitForElement(driver, Approval_Limit_Input_UCA);
			clear(driver,Approval_Limit_Input_UCA);
			sendKeys(driver, Approval_Limit_Input_UCA, New_Amount_Value);
			Step_End(20, "Click on the edit option and update it", test, test1);
			
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
			
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
			Step_Start(21, "Then again go to the CAR screen and go to the expense report and click on approve option and check whether the system shows the information message as \"Expenses are Approved\".Click on the ok option", test, test1);
			waitForElement(driver, Expensive_Report_Btn_CAR);
			click(driver,Expensive_Report_Btn_CAR);
			
			waitForElement(driver, Expensive_Table_CAR);
			
			Expensive_Vendor_Column=String.format(Expensive_Vendor_Column_CAR, Un_Predictable_Vendor_Code);
			waitForElement(driver, Expensive_Vendor_Column);
			click(driver,Expensive_Vendor_Column);
			
			waitForElement(driver, Approve_button_CAR);
			click(driver,Approve_button_CAR);
			
			waitForPopup(driver, popup_Message, Expense_Approved_Popup);
			PopupApproved_Text_Act=getText(driver, popup_Message);
			
			if(PopupApproved_Text_Act.equals(Expense_Approved_Popup)) {
				System.out.println("Popup Matched  ||   Expected : "+Expense_Approved_Popup+"   ||   Actual   : "+PopupApproved_Text_Act);
				Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Expense_Approved_Popup+"   ||   Actual   : "+PopupApproved_Text_Act, test, test1);
			}else {
				System.out.println("Popup Not Matched  ||   Expected : "+Expense_Approved_Popup+"   ||   Actual   : "+PopupApproved_Text_Act);
				Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Expense_Approved_Popup+"   ||   Actual   : "+PopupApproved_Text_Act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			Step_End(21, "Then again go to the CAR screen and go to the expense report and click on approve option and check whether the system shows the information message as \"Expenses are Approved\".Click on the ok option", test, test1);

		}else {
			
			Step_Start(21, "Then again go to the CAR screen and go to the expense report and click on approve option and check whether the system shows the information message as \"Expenses are Approved\".Click on the ok option", test, test1);

			waitForPopup(driver, popup_Message, Expense_Approved_Popup);
			String PopupApproved_Text_Act=getText(driver, popup_Message);
			
			if(PopupApproved_Text_Act.equals(Expense_Approved_Popup)) {
				System.out.println("Popup Matched  ||   Expected : "+Expense_Approved_Popup+"   ||   Actual   : "+PopupApproved_Text_Act);
				Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Expense_Approved_Popup+"   ||   Actual   : "+PopupApproved_Text_Act, test, test1);
			}else {
				System.out.println("Popup Not Matched  ||   Expected : "+Expense_Approved_Popup+"   ||   Actual   : "+PopupApproved_Text_Act);
				Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Expense_Approved_Popup+"   ||   Actual   : "+PopupApproved_Text_Act, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			Step_End(21, "Then again go to the CAR screen and go to the expense report and click on approve option and check whether the system shows the information message as \"Expenses are Approved\".Click on the ok option", test, test1);

		}
		
		Extent_completed(tc_Name, test, test1);

	}
}
