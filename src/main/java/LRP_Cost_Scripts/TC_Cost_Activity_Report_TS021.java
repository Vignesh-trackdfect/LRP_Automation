package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS021 extends Keywords {

	public void Cost_Activity_Report_TS021(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS021";
	

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_search_value = Excel_data.get("Select_search_value");
		String Condition = Excel_data.get("Condition");
		String CAR_No = Excel_data.get("CAR_No");
		String Reject_PopupMessage = Excel_data.get("Reject_PopupMessage");
		String Updated_PopupMessage = Excel_data.get("Updated_PopupMessage");
		String Agency = Excel_data.get("Agency");

		
		String Open_Expenses_TableHeader = Excel_data.get("Open_Expenses_TableHeader");
		String Activity_Name = Excel_data.get("Activity_Name");
		String Head = Excel_data.get("Head");
		String EquipmentType = Excel_data.get("EquipmentType");
		String EquipmentStatus = Excel_data.get("EquipmentStatus");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Contract_Number = Excel_data.get("Contract_Number");
		String Remark_Values = Excel_data.get("Remark_Values");

		
		
		
		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, username, password);
		
		if (!Agency.equals("")) {

			SwitchProfile(driver, Agency);

		}

		Step_Start(1, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		verifyMainMenu(driver);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(1, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		Step_Start(2, "Click on the global search option which is available in the tool bar", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(2, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(3, "Check whether it opens a new search window", test, test1);

		if (isdisplayed(driver, type_Select1)) {

			System.out.println("Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully");
			Extent_pass_New(driver, "Expected : System Should opens the search window Successfully || Actual : System opens the search window Successfully" , test, test1);
			
		}else {
			System.out.println("Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully");
			Extent_fail(driver, "Expected : System Should opens the search window Successfully || Actual : System not opens the search window Successfully" , test, test1);
		}

		Step_End(3, "Check whether it opens a new search window", test, test1);

		Step_Start(4, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_Start(5, "Then click on the search button", test, test1);

		Step_Start(6, "System will show the CAR No", test, test1);

		Step_Start(7, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		globalValueSearchWindow(driver, Condition, Select_search_value, CAR_No, "", "", "", "");

		Step_End(4, "Enter the CTL CAR No. in the CAR No search field", test, test1);

		Step_End(5, "Then click on the search button", test, test1);

		Step_End(6, "System will show the CAR No", test, test1);

		Step_Start(7, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		waitForElement(driver, CAR_Input);
		String retrived_Number = getAttribute(driver, CAR_Input, "value");

		if (retrived_Number.equals(CAR_No)) {

			System.out.println("The given CAR No was retrived || Expected CAR No : " + CAR_No + " || Actual CAR No : "
					+ retrived_Number);
			Extent_pass_New(driver, "The given CAR No was retrived || Expected CAR No : " + CAR_No + " || Actual CAR No : "
					+ retrived_Number, test, test1);
		} else {
			System.out.println("The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number);
			Extent_fail(driver, "The given CAR No was not retrived || Expected CAR No : " + CAR_No
					+ " || Actual CAR No : " + retrived_Number, test, test1);
		}

		Step_End(7, "Click on the select button.Ensure that the system retrieves the saved CAR", test, test1);

		Step_Start(8, "Then click on the expense report, a new window will be opened", test, test1);

		waitForElement(driver, Expense_report);
		click(driver, Expense_report);

		waitForElement(driver, Open_Expensive_CAR);
		click(driver,Open_Expensive_CAR);
		
		Step_End(8, "Then click on the expense report, a new window will be opened", test, test1);

		Step_Start(9, "Select the required activities from the open expense tab", test, test1);

		List<String> GivenActivities = splitAndExpand(Activity_Name,",");
		List<String> HeadValues = splitAndExpand(Head,",");
		List<String> EquipmentTypes = splitAndExpand(EquipmentType,",");
		List<String> EquipmentStatusValues = splitAndExpand(EquipmentStatus+",");
		List<String> Vendor_CodeValues = splitAndExpand(Vendor_Code,",");
		List<String> Contract_Numbers = splitAndExpand(Contract_Number,",");
		List<String> Remarks_Values = splitAndExpand(Remark_Values,",");

		
		
		for(int i=0;i<GivenActivities.size();i++) {
			
			String Activity=GivenActivities.get(i);
			String HeadVal=HeadValues.get(i);
			String EqpType=EquipmentTypes.get(i);
			String EqpValues=EquipmentStatusValues.get(i);
			String Ven_Code=Vendor_CodeValues.get(i);
			String ContractNo=Contract_Numbers.get(i);

			//ActivityName_Filter
			
			waitForElement(driver, Expensive_More_Option_CAR);
			click(driver,Expensive_More_Option_CAR);
			
			waitForElement(driver, Filter_Option_Expensive_CAR);
			click(driver,Filter_Option_Expensive_CAR);
			
			waitForElement(driver, Expensive_Column_Filt_CAR);
			click(driver, Expensive_Column_Filt_CAR);
			waitForElement(driver, Expensive_Filter_input_CAR);
			jsClick(driver, SelectAll_Checkbox_Expensive_CAR);
			
			List<String> ExpensiveTable_Headers=splitAndExpand(Open_Expenses_TableHeader);
			for(String FilterHeader : ExpensiveTable_Headers) {
				waitForElement(driver, Expensive_Filter_input_CAR);
				Newclear(driver, Expensive_Filter_input_CAR);
				sendKeys(driver, Expensive_Filter_input_CAR,FilterHeader);
			
				String checkbox=String.format(Select_Column_Expensive_CAR,FilterHeader);
				waitForDisplay(driver, checkbox);
				jsClick(driver, checkbox);
			}			
			
			jsClick(driver, Expensive_Column_Filt_CAR);
			waitForElement(driver, Expensive_Table_CAR);
			
			
			AG_Grid_FilterInputs(driver,"Activity Name",Activity);
			AG_Grid_FilterInputs(driver,"Eqp Type",EqpType);
			AG_Grid_FilterInputs(driver,"Eqp Status",EqpValues);
			AG_Grid_FilterInputs(driver,"Head",HeadVal);
			AG_Grid_FilterInputs(driver,"Contract No",ContractNo);
			AG_Grid_FilterInputs(driver,"Vendor Code",Ven_Code);
			
			
			waitForElement(driver, Activity_Columns_OpenExpense_CAR);
			click(driver,Activity_Columns_OpenExpense_CAR);
			
			
			waitForElement(driver, Reject_expense);
			click(driver, Reject_expense);

			Step_End(10, "Click on the Reject button", test, test1);

			Step_Start(11, "Check whether the system shows an information message as Expenses are rejected", test, test1);

			waitForPopup(driver, popup_Message, Reject_PopupMessage);

			String Actual_popup = getText(driver, popup_Message);

			if (Actual_popup.equals(Reject_PopupMessage)) {

				System.out.println("Selected Activity got rejected || Expected Popup message : " + Reject_PopupMessage
						+ " || Actual popup message : " + Actual_popup);
				Extent_pass_New(driver, "Selected Activity got rejected || Expected Popup message : " + Reject_PopupMessage
						+ " || Actual popup message : " + Actual_popup, test, test1);
			} else {

				System.out.println("Selected Activity not rejected || Expected Popup message : " + Reject_PopupMessage
						+ " || Actual popup message : " + Actual_popup);
				Extent_fail(driver, "Selected Activity not rejected || Expected Popup message : " + Reject_PopupMessage
						+ " || Actual popup message : " + Actual_popup, test, test1);
			}

			Step_End(11, "Check whether the system shows an information message as Expenses are rejected", test, test1);

			Step_Start(12, "Click on ok", test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			Step_End(12, "Click on ok", test, test1);

			waitForDisplay(driver, Selected_Row_Grid);
			if(isdisplayed(driver, Selected_Row_Grid)) {
				click(driver,Selected_Row_Grid);
			}
		}
		
		waitForElement(driver, Open_Expensive_CAR);
		click(driver,Open_Expensive_CAR);
		
		Step_Start(13, "Click on the Edit button", test, test1);

		waitForElement(driver, Edit_Openexpense);
		click(driver, Edit_Openexpense);

		Step_End(13, "Click on the Edit button", test, test1);		
		
		for(int i=0;i<GivenActivities.size();i++) {
			
			String Activity=GivenActivities.get(i);
			String HeadVal=HeadValues.get(i);
			String EqpType=EquipmentTypes.get(i);
			String EqpValues=EquipmentStatusValues.get(i);
			String Ven_Code=Vendor_CodeValues.get(i);
			String ContractNo=Contract_Numbers.get(i);
			String Remark=Remarks_Values.get(i);

			//ActivityName_Filter
			
			waitForElement(driver, Expensive_More_Option_CAR);
			click(driver,Expensive_More_Option_CAR);
			
			waitForElement(driver, Filter_Option_Expensive_CAR);
			click(driver,Filter_Option_Expensive_CAR);
			
			waitForElement(driver, Expensive_Column_Filt_CAR);
			click(driver, Expensive_Column_Filt_CAR);
			waitForElement(driver, Expensive_Filter_input_CAR);
			jsClick(driver, SelectAll_Checkbox_Expensive_CAR);
			
			List<String> ExpensiveTable_Headers=splitAndExpand(Open_Expenses_TableHeader);
			for(String FilterHeader : ExpensiveTable_Headers) {
				waitForElement(driver, Expensive_Filter_input_CAR);
				Newclear(driver, Expensive_Filter_input_CAR);
				sendKeys(driver, Expensive_Filter_input_CAR,FilterHeader);
			
				String checkbox=String.format(Select_Column_Expensive_CAR,FilterHeader);
				waitForDisplay(driver, checkbox);
				jsClick(driver, checkbox);
			}			
			
			jsClick(driver, Expensive_Column_Filt_CAR);
			waitForElement(driver, Expensive_Table_CAR);
			
			
			AG_Grid_FilterInputs(driver,"Activity Name",Activity);
			AG_Grid_FilterInputs(driver,"Eqp Type",EqpType);
			AG_Grid_FilterInputs(driver,"Eqp Status",EqpValues);
			AG_Grid_FilterInputs(driver,"Head",HeadVal);
			AG_Grid_FilterInputs(driver,"Contract No",ContractNo);
			AG_Grid_FilterInputs(driver,"Vendor Code",Ven_Code);

			Step_Start(14, "Then select the required activity one by one and right on it", test, test1);

			Step_Start(15, "System will show an remarks option and click on it", test, test1);

			Step_Start(16, "System will open a new tab and enter our required remarks in it", test, test1);

			Step_Start(17, "Click on ok", test, test1);
			
			waitForElement(driver, Activity_Columns_OpenExpense_CAR);
			click(driver,Activity_Columns_OpenExpense_CAR);
			RightClick(driver,Activity_Columns_OpenExpense_CAR);
			
			
			waitForElement(driver, Remarks_option);
			click(driver, Remarks_option);

			waitForElement(driver, CAR_Remarks_Input);
			clear(driver, CAR_Remarks_Input);
			sendKeys(driver, CAR_Remarks_Input, Remark);

			waitForElement(driver, CAR_Remark_Ok);
			click(driver, CAR_Remark_Ok);
		
			Step_End(14, "Then select the required activity one by one and right on it", test, test1);

			Step_End(15, "System will show an remarks option and click on it", test, test1);

			Step_End(16, "System will open a new tab and enter our required remarks in it", test, test1);

			Step_End(17, "Click on ok", test, test1);
			
			waitForDisplay(driver, Selected_Row_Grid);
			if(isdisplayed(driver, Selected_Row_Grid)) {
				click(driver,Selected_Row_Grid);
			}		
		}
	
		
		Step_Start(19, "Click on the update button", test, test1);

		waitForElement(driver, Update_OpenExpense);
		click(driver, Update_OpenExpense);

		Step_End(19, "Click on the update button", test, test1);

		Step_Start(20, "Check whether the system shows the information message as Expense Report updated", test, test1);

		waitForPopup(driver, popup_Message, Updated_PopupMessage);

		String Actual_updatedpopup = getText(driver, popup_Message);

		if (Actual_updatedpopup.equals(Updated_PopupMessage)) {

			System.out.println("Selected Activity got updated || Expected Popup message : " + Reject_PopupMessage
					+ " || Actual popup message : " + Actual_updatedpopup);
			Extent_pass_New(driver, "Selected Activity got rejected || Expected Popup message : " + Reject_PopupMessage
					+ " || Actual popup message : " + Actual_updatedpopup, test, test1);
		} else {

			System.out.println("Selected Activity not updated || Expected Popup message : " + Reject_PopupMessage
					+ " || Actual popup message : " + Actual_updatedpopup);
			Extent_fail(driver, "Selected Activity not updated || Expected Popup message : " + Reject_PopupMessage
					+ " || Actual popup message : " + Actual_updatedpopup, test, test1);
		}

		Step_End(20, "Check whether the system shows the information message as Expense Report updated", test, test1);

		Step_Start(21, "Click on ok", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(21, "Click on ok", test, test1);

		
		Step_Start(18, "Check whether the remarks checkbox is selected for that activity", test, test1);
		Step_Start(24,
				"System will open a new window and Select the activities for which we have already provided remarks and right click on it  and click on the remarks option",
				test, test1);

		Step_Start(25,
				"System will open a new window and Select the activities for which we have already provided remarks and right click on it  and click on the remarks option",
				test, test1);

		Step_Start(26, "Click on ok button", test, test1);
		
		for(int i=0;i<GivenActivities.size();i++) {
			
			String Activity=GivenActivities.get(i);
			String HeadVal=HeadValues.get(i);
			String EqpType=EquipmentTypes.get(i);
			String EqpValues=EquipmentStatusValues.get(i);
			String Ven_Code=Vendor_CodeValues.get(i);
			String ContractNo=Contract_Numbers.get(i);
			String Remark=Remarks_Values.get(i);

			//ActivityName_Filter
			
			waitForElement(driver, Expensive_More_Option_CAR);
			click(driver,Expensive_More_Option_CAR);
			
			waitForElement(driver, Filter_Option_Expensive_CAR);
			click(driver,Filter_Option_Expensive_CAR);
			
			waitForElement(driver, Expensive_Column_Filt_CAR);
			click(driver, Expensive_Column_Filt_CAR);
			waitForElement(driver, Expensive_Filter_input_CAR);
			jsClick(driver, SelectAll_Checkbox_Expensive_CAR);
			
			List<String> ExpensiveTable_Headers=splitAndExpand(Open_Expenses_TableHeader);
			for(String FilterHeader : ExpensiveTable_Headers) {
				waitForElement(driver, Expensive_Filter_input_CAR);
				Newclear(driver, Expensive_Filter_input_CAR);
				sendKeys(driver, Expensive_Filter_input_CAR,FilterHeader);
			
				String checkbox=String.format(Select_Column_Expensive_CAR,FilterHeader);
				waitForDisplay(driver, checkbox);
				jsClick(driver, checkbox);
			}			
			
			jsClick(driver, Expensive_Column_Filt_CAR);
			waitForElement(driver, Expensive_Table_CAR);
			
			
			AG_Grid_FilterInputs(driver,"Activity Name",Activity);
			AG_Grid_FilterInputs(driver,"Eqp Type",EqpType);
			AG_Grid_FilterInputs(driver,"Eqp Status",EqpValues);
			AG_Grid_FilterInputs(driver,"Head",HeadVal);
			AG_Grid_FilterInputs(driver,"Contract No",ContractNo);
			AG_Grid_FilterInputs(driver,"Vendor Code",Ven_Code);


			if (isdisplayed(driver, Remarks_Checkbox_Open)) {

				System.out.println("Expected : Remark checkbox Should be enabled for the given ativity "+Activity+" || Actual : Remark checkbox is enabled for the given ativity");
				Extent_pass_New(driver, "Expected : Remark checkbox Should be enabled for the given ativity "+Activity+" || Actual : Remark checkbox is enabled for the given ativity", test, test1);
			} else {
				System.out.println("Expected : Remark checkbox Should be enabled for the given ativity "+Activity+" || Actual : Remark checkbox is not enabled for the given ativity");
				Extent_fail(driver, "Expected : Remark checkbox Should be enabled for the given ativity "+Activity+" || Actual : Remark checkbox is not enabled for the given ativity", test, test1);
			}
			
			waitForElement(driver, Activity_Columns_OpenExpense_CAR);
			click(driver,Activity_Columns_OpenExpense_CAR);
			RightClick(driver,Activity_Columns_OpenExpense_CAR);
			
			waitForElement(driver, Remarks_option);
			click(driver, Remarks_option);

			waitForElement(driver, CAR_Remarks_Input);

			String UpdatedRemark = getText(driver, CAR_Remarks_Input);
			if (UpdatedRemark.equals(Remark)) {

				System.out.println("Given remarks are updated in the selected activity || Expected remark : "
						+ Remark + " || Actual remark : " + UpdatedRemark);
				Extent_pass_New(driver, "Given remarks are updated in the selected activity || Expected remark : "
						+ Remark + " || Actual remark : " + UpdatedRemark, test, test1);

			} else {

				System.out.println("Given remarks are not updated in the selected activity || Expected remark : "
						+ Remark + " || Actual remark : " + UpdatedRemark);
				Extent_fail(driver, "Given remarks are not updated in the selected activity || Expected remark : "
						+ Remark + " || Actual remark : " + UpdatedRemark, test, test1);

			}

			waitForElement(driver, CAR_Remark_Ok);
			click(driver, CAR_Remark_Ok);
			
			waitForDisplay(driver, Selected_Row_Grid);
			if(isdisplayed(driver, Selected_Row_Grid)) {
				click(driver,Selected_Row_Grid);
			}
		}

		Step_End(18, "Check whether the remarks checkbox is selected for that activity", test, test1);
		Step_End(24,
				"System will open a new window and Select the activities for which we have already provided remarks and right click on it  and click on the remarks option",
				test, test1);

		Step_End(25,
				"System will open a new window and Select the activities for which we have already provided remarks and right click on it  and click on the remarks option",
				test, test1);

		Step_End(26, "Click on ok button", test, test1);	

		Extent_completed(tc_Name, test, test1);

	}

}
