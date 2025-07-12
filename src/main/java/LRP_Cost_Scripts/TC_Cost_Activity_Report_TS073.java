package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS073 extends Keywords{

	public void  Cost_Activity_Report_TS073(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS073";
		
		
		
		

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
		
		String Activity_Quantity_values = Excel_data.get("Activity_Quantity_values");
		String Activity_details_Condition = Excel_data.get("Activity_details_Condition");
		String Select_Activity_Value = Excel_data.get("Select_Activity_Value");
		String Eqp_type_Select = Excel_data.get("Eqp_type_Select");
		String Vendor_Code_Select = Excel_data.get("Vendor_Code_Select");
		String Activity_Amount_List = Excel_data.get("Activity_Amount_List");
		String Activity_Saved_Popup = Excel_data.get("Activity_Saved_Popup");
		
		String Equipement_Header = Excel_data.get("Equipement_Header");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		
		String Select_Activity_To_Approve = Excel_data.get("Select_Activity_To_Approve");
		String Submitted_popup_text = Excel_data.get("Submitted_popup_text");
		String User_CAR_Approval_Module = Excel_data.get("User_CAR_Approval_Module");
		String Expense_Approved_Popup = Excel_data.get("Expense_Approved_Popup");
		String Expense_Approve_Limit_Error_Popup = Excel_data.get("Expense_Approve_Limit_Error_Popup");
		
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
		
		Step_Start(3, ".Click on the Contract type field and Select the drop down as \"MSC\"  ", test, test1);
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
		Step_End(3, ".Click on the Contract type field and Select the drop down as \"MSC\"  ", test, test1);
		
		Step_Start(4, "Click on the Service search button and select the required service code.   ", test, test1);
		waitForElement(driver, Service_Search_Btn_CAR);
		click(driver,Service_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Service_Header,Service_details_Codition,Service_Code);
		Step_End(4, "Click on the Service search button and select the required service code.   ", test, test1);
		
		Step_Start(5, "Click on the Vessel search button and select the required vessel code.  ", test, test1);
		waitForElement(driver, Vessel_Search_Btn_CAR);
		click(driver,Vessel_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Vessel_Header,Service_details_Codition,Vessel_Code);
		Step_End(5, "Click on the Vessel search button and select the required vessel code.  ", test, test1);
		
		Step_Start(6, "Click on the Port search button and select the required port code.", test, test1);
		waitForElement(driver, Port_Search_Btn_CAR);
		click(driver,Port_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Port_Header,Service_details_Codition,Port_Code);
		Step_End(6, "Click on the Port search button and select the required port code.", test, test1);
		
		Step_Start(7, "Click on the Terminal search button and select the required terminal code.", test, test1);
		waitForElement(driver, Terminal_Search_Btn_CAR);
		click(driver,Terminal_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Terminal_Header,Service_details_Codition,Terminal_Code);
		Step_End(7, "Click on the Terminal search button and select the required terminal code.", test, test1);
		
		Step_Start(8, ".Click on the Arrival date search button and select the required date.", test, test1);
		waitForElement(driver, Arrival_Date_Search_Btn_CAR);
		click(driver,Arrival_Date_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Arrival_Date_Header,Arrival_Date_Condition,Arrival_Date_Value);
		Step_End(8, ".Click on the Arrival date search button and select the required date.", test, test1);
		
		Step_Start(9, "Click on the Show button ", test, test1);
		waitForElement(driver, Show_Button_CAR);
		click(driver,Show_Button_CAR);
		Step_End(9, "Click on the Show button", test, test1);
		
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
		
		Step_Start(10, "Click on the Add button and system will list down the activities in new window", test, test1);
		waitForElement(driver, ADD_button_MSC_CAR);
		click(driver,ADD_button_MSC_CAR);
		Step_End(10, "Click on the Add button and system will list down the activities in new window", test, test1);

		List<String> Activities=splitAndExpand(Select_Activity_Value);
		
		Step_Start(11, "Select the activities by clicking on the check box.", test, test1);
		for(String act:Activities) {
			String SelectActivity=String.format(Select_Activity_Column_CAR, act);
			waitForElement(driver, SelectActivity);
			click(driver,SelectActivity);
		}
		Step_End(11, "Select the activities by clicking on the check box.", test, test1);
		
		Step_Start(12, "Click on the select button", test, test1);
		waitForElement(driver, Select_button_MSC_CAR);
		click(driver,Select_button_MSC_CAR);
		Step_End(12, "Click on the select button", test, test1);

		Step_Start(13, "The selected activities will set in the AG Grid", test, test1);
		for(String act:Activities) {
			String UpdatedActivity=String.format(MSC_table_Activity_Column_CAR, act);
			if(isDisplayed(driver, UpdatedActivity)) {
				System.out.println("Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is Updated in the Table");
				Extent_pass_New(driver, "Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is Updated in the Table", test, test1);
			}else {
				System.out.println("Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is not Updated in the Table");
				Extent_fail(driver, "Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is not Updated in the Table", test, test1);
			}
		}
		Step_End(13, "The selected activities will set in the AG Grid", test, test1);
		List<String> EqpTypeList=splitAndExpand(Eqp_type_Select);
		List<String> QuantityList=splitAndExpand(Activity_Quantity_values);
		List<String> Vendor_Code_List=splitAndExpand(Vendor_Code_Select);
		List<String> Amount_List=splitAndExpand(Activity_Amount_List);
		
		for(int i=0;i<Activities.size();i++) {
			Step_Start(14, "Then select the activities in AG grid and Enter the required quantity", test, test1);
			String UpdatedActivityQuantColumn=String.format(MSC_table_Quantity_Column_CAR, Activities.get(i));
			waitForElement(driver, UpdatedActivityQuantColumn);
			doubleClick(driver, UpdatedActivityQuantColumn);
			
			String UpdatedActivityQuan=String.format(MSC_table_Quantity_input_CAR, Activities.get(i));
			waitForElement(driver, UpdatedActivityQuan);
			sendKeys(driver, UpdatedActivityQuan, QuantityList.get(i));
			Step_End(14, "Then select the activities in AG grid and Enter the required quantity", test, test1);
			
			Step_Start(15, "Click on the Eqp. type button and system will list down the activities in new window", test, test1);
			String UpdatedActivity=String.format(MSC_table_Activity_Column_CAR, Activities.get(i));
			waitForElement(driver, UpdatedActivity);
			click(driver,UpdatedActivity);
			
			waitForElement(driver, MSC_Equipment_Type_Button_CAR);
			click(driver,MSC_Equipment_Type_Button_CAR);
			Step_End(15, "Click on the Eqp. type button and system will list down the activities in new window", test, test1);

			Step_Start(16, ".Select the required Equipment type and click on the select button", test, test1);
			twoColumnSearchWindow(driver,Equipement_Header,Activity_details_Condition,EqpTypeList.get(i));
			Step_End(16, ".Select the required Equipment type and click on the select button", test, test1);

			Step_Start(17, "Check whether the equipment type is set in the activity and click on the vendor code button,system will listdown the vendor details in new window", test, test1);
			String Selected_EqpType=String.format(MSC_Table_EqpType_Column_CAR, Activities.get(i));
			waitForElement(driver, Selected_EqpType);
			String Updated_EpqType=getText(driver, Selected_EqpType);
			if(Updated_EpqType.equals(EqpTypeList.get(i))) {
				System.out.println("Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is updated Correctly in the Table");
				Extent_pass_New(driver, "Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is updated Correctly in the Table", test, test1);
			}else {
				System.out.println("Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is not updated Correctly in the Table");
				Extent_fail(driver, "Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is not updated Correctly in the Table", test, test1);
			}
			
			waitForElement(driver, MSC_Vendor_Code_Button_CAR);
			click(driver,MSC_Vendor_Code_Button_CAR);
			Step_End(17, "Check whether the equipment type is set in the activity and click on the vendor code button,system will listdown the vendor details in new window", test, test1);

			Step_Start(18, "Select the required vendor code", test, test1);
			twoColumnSearchWindow(driver,Vendor_Code_Header,Activity_details_Condition,Vendor_Code_List.get(i));
			Step_End(18, "Select the required vendor code", test, test1);

			Step_Start(19, "Enter the required amount by selecting each activity one by one", test, test1);
			String Selected_VendorCode=String.format(MSC_Table_Vendor_Code_Column_CAR, Activities.get(i));
			waitForElement(driver, Selected_VendorCode);
			String Updated_VendorCode=getText(driver, Selected_VendorCode);
			if(Updated_VendorCode.equals(Vendor_Code_List.get(i))) {
				System.out.println("Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is updated Correctly in the Table");
				Extent_pass_New(driver, "Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is updated Correctly in the Table", test, test1);
			}else {
				System.out.println("Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is not updated Correctly in the Table");
				Extent_fail(driver, "Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is not updated Correctly in the Table", test, test1);
			}
			
			String Activity_Amount_Col=String.format(MSC_Table_Amount_Column_CAR, Activities.get(i));
			waitForElement(driver, Activity_Amount_Col);
			doubleClick(driver,Activity_Amount_Col);
			
			String Activity_Amount_Input=String.format(MSC_Table_Amount_Input_CAR, Activities.get(i));
			System.out.println("Amount_List : "+Amount_List.get(i));
			waitForElement(driver, Activity_Amount_Input);
			clear(driver,Activity_Amount_Input);
			waitForElement(driver, Activity_Amount_Input);
			sendKeys(driver, Activity_Amount_Input,Amount_List.get(i));
		    UpdatedActivityQuantColumn=String.format(MSC_table_Quantity_Column_CAR, Activities.get(i));
			waitForElement(driver, UpdatedActivityQuantColumn);
			click(driver,UpdatedActivityQuantColumn);
			Step_End(19, "Enter the required amount by selecting each activity one by one", test, test1);

		}
		
		Step_Start(20, "Click on the tool bar save button and check whether the system shows the information message as \"Container Activity Report Saved\".", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Activity_Saved_Popup);
		String Popup_Text_Act=getText(driver, popup_Message);
		
		if(Popup_Text_Act.equals(Activity_Saved_Popup)) {
			System.out.println("Popup Matched  ||   Expected : "+Activity_Saved_Popup+"   ||   Actual   : "+Popup_Text_Act);
			Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Activity_Saved_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected : "+Activity_Saved_Popup+"   ||   Actual   : "+Popup_Text_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Activity_Saved_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		Step_End(20, "Click on the tool bar save button and check whether the system shows the information message as \"Container Activity Report Saved\".", test, test1);

		Step_Start(21, "Select the activities and click on the approve option.System validates as \"Approved amount should be less than or equal to 30000.0\".Click on the ok option", test, test1);

		String UpdatedActivity=String.format(MSC_table_Activity_Column_CAR, Select_Activity_To_Approve);
		waitForElement(driver, UpdatedActivity);
		click(driver,UpdatedActivity);
		
		String Activity_Amount_Col=String.format(MSC_Table_Amount_Column_CAR, Select_Activity_To_Approve);
		waitForElement(driver, Activity_Amount_Col);
		String Amount_Actvity=getText(driver, Activity_Amount_Col);
		double Activity_Amount=getNumberValue1(Amount_Actvity);
		
		waitForElement(driver, MSC_Submit_button_CAR);
		click(driver,MSC_Submit_button_CAR);
	
		waitForPopup(driver, popup_Message, Submitted_popup_text);
		String Popup_Submit_Text_Act=getText(driver, popup_Message);
		
		if(Popup_Submit_Text_Act.equals(Submitted_popup_text)) {
			System.out.println("Popup Matched  ||   Expected : "+Submitted_popup_text+"   ||   Actual   : "+Popup_Submit_Text_Act);
			Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Submitted_popup_text+"   ||   Actual   : "+Popup_Submit_Text_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected : "+Submitted_popup_text+"   ||   Actual   : "+Popup_Submit_Text_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Submitted_popup_text+"   ||   Actual   : "+Popup_Submit_Text_Act, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		moduleNavigate(driver, User_CAR_Approval_Module);
		String userName_Table=username.toLowerCase();
		
		waitForElement(driver, UserName_Filter_Input_UCA);
		sendKeys(driver, UserName_Filter_Input_UCA, userName_Table);
		
		waitForElement(driver, Approval_LimitTable_UCA);
				
		String user_Select_Column=String.format(Select_Row_UCA, userName_Table);
		waitForElement(driver, user_Select_Column);
		doubleClick(driver, user_Select_Column);
		
		waitForElement(driver, Approval_Limit_Input_UCA);
		String Approval_Value_User=getAttribute(driver, Approval_Limit_Input_UCA, "value");
		double Approval_Amount=getNumberValue1(Approval_Value_User);
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		String ApproveActivity=String.format(MSC_table_Activity_Column_CAR, Select_Activity_To_Approve);
		waitForElement(driver, ApproveActivity);
		click(driver,ApproveActivity);
		
		String CurrencyActivity=String.format(MSC_Table_Cuurency_Column_CAR, Select_Activity_To_Approve);
		waitForElement(driver, CurrencyActivity);
		String Currency_Value=getText(driver, CurrencyActivity);
		
		waitForElement(driver, MSC_Approve_button_CAR);
		click(driver,MSC_Approve_button_CAR);
		Step_End(21, "Select the activities and click on the approve option.System validates as \"Approved amount should be less than or equal to 30000.0\".Click on the ok option", test, test1);

		if(Currency_Value.equalsIgnoreCase("USD") && Approval_Amount<Activity_Amount) {
			Step_Start(22, "Enter the screen name as \"User CAR approval limit\" in the module search field.", test, test1);
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
			
			moduleNavigate(driver, User_CAR_Approval_Module);
			Step_End(22, "Enter the screen name as \"User CAR approval limit\" in the module search field.", test, test1);

			userName_Table=username.toLowerCase();
			Step_Start(23, "Select the required details and verify the Approval limit amount", test, test1);

			waitForElement(driver, UserName_Filter_Input_UCA);
			sendKeys(driver, UserName_Filter_Input_UCA, userName_Table);
			
			waitForElement(driver, Approval_LimitTable_UCA);
			user_Select_Column=String.format(Select_Row_UCA, userName_Table);
			waitForElement(driver, user_Select_Column);
			doubleClick(driver, user_Select_Column);
			Step_End(23, "Select the required details and verify the Approval limit amount", test, test1);

			Step_Start(24, "Click on the edit option and update it", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver,Edit_Button_toolBar);
			
			double newAmount=Activity_Amount+100;
			String New_Amount_Value=String.valueOf(newAmount);
			
			waitForElement(driver, Approval_Limit_Input_UCA);
			clear(driver,Approval_Limit_Input_UCA);
			sendKeys(driver, Approval_Limit_Input_UCA, New_Amount_Value);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
			
			Step_End(24, "Click on the edit option and update it", test, test1);
			
			Step_Start(25, "Then again go to the CAR screen and go to the expense report and click on approve option and check whether the system shows the information message as \"Expenses are Approved\".Click on the ok option", test, test1);
			
			waitForElement(driver, Close_Current_tab);
			click(driver,Close_Current_tab);
			
		    ApproveActivity=String.format(MSC_table_Activity_Column_CAR, Select_Activity_To_Approve);
			waitForElement(driver, ApproveActivity);
			click(driver,ApproveActivity);
			
			waitForElement(driver, MSC_Approve_button_CAR);
			click(driver,MSC_Approve_button_CAR);
			
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
			Step_End(25, "Then again go to the CAR screen and go to the expense report and click on approve option and check whether the system shows the information message as \"Expenses are Approved\".Click on the ok option", test, test1);

		}else {
			Step_Start(25, "Then again go to the CAR screen and go to the expense report and click on approve option and check whether the system shows the information message as \"Expenses are Approved\".Click on the ok option", test, test1);

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
			Step_End(25, "Then again go to the CAR screen and go to the expense report and click on approve option and check whether the system shows the information message as \"Expenses are Approved\".Click on the ok option", test, test1);

		}
	
		Extent_completed(tc_Name, test, test1);		
		
	}
	
}
