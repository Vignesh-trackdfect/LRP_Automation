package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Invoice_Registration_SC13  extends Keywords{
	public void Vendor_Invoice_Registration_SC13(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Vendor_Invoice_Registration_SC13";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String Agency = Excel_data.get("Agency");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Vendor_Code_Search = Excel_data.get("Vendor_Code_Search");
		String Condition = Excel_data.get("Condition");
		String Inv_Receiving_Date = Excel_data.get("Inv_Receiving_Date");
		String Inv_Registration_Date = Excel_data.get("Inv_Registration_Date");
		String Inv_Date = Excel_data.get("Inv_Date");
		String Factor_payee_search = Excel_data.get("Factor_payee_search");
		String Two_Condition = Excel_data.get("Two_Condition");
		String Factor_payee_Input = Excel_data.get("Factor_payee_Input");
		String Invoice_Number_Input = Excel_data.get("Invoice_Number_Input");
		String Inv_Amount = Excel_data.get("Inv_Amount");
		String Act_Expensive_amount = Excel_data.get("Act_Expensive_amount");
		String total_bal_Amount = Excel_data.get("total_bal_Amount");
		String netpaid_Amount = Excel_data.get("netpaid_Amount");
		String invoice_ROE = Excel_data.get("invoice_ROE");
		String Disbusement_ROE_Input = Excel_data.get("Disbusement_ROE_Input");
		String Disbusse_currency = Excel_data.get("Disbusse_currency");
		String Disbusement_Amount_Input = Excel_data.get("Disbusement_Amount_Input");
		String Payment_method = Excel_data.get("Payment_method");
		String Home_ROE = Excel_data.get("Home_ROE");
		String total_Dispute_AMT = Excel_data.get("total_Dispute_AMT");
		String activity_Dispute = Excel_data.get("activity_Dispute");
		String other_Dispute = Excel_data.get("other_Dispute");
		String total_Tolerance_Amt = Excel_data.get("total_Tolerance_Amt");
		String disputeNumber = Excel_data.get("disputeNumber");
		String Activity_Type = Excel_data.get("Activity_Type");
		String Service_Search = Excel_data.get("Service_Search");
		String Vessel_Search = Excel_data.get("Vessel_Search");
		String Terminal_code_search = Excel_data.get("Terminal_code_search");
		String Port_code_search = Excel_data.get("Port_code_search");
		String Voyage_code_Search = Excel_data.get("Voyage_code_Search");
		String Service_Search_Input = Excel_data.get("Service_Search_Input");
		String Vessel_Search_Input = Excel_data.get("Vessel_Search_Input");
		String Voyage_code_Input = Excel_data.get("Voyage_code_Input");
		String Port_code_Input = Excel_data.get("Port_code_Input");
		String Terminal_code_ = Excel_data.get("Terminal_code_");
		String Contract_Type = Excel_data.get("Contract_Type");
		String Cost_Module = Excel_data.get("Cost_Module");
		String Car_num_Search = Excel_data.get("Car_num_Search");
		String Saved_Popup_Expected = Excel_data.get("Saved_Popup_Expected");
		String Invoice_Currency_Select = Excel_data.get("Invoice_Currency_Select");
		String datePicker = Excel_data.get("datePicker");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Expense_Header =Excel_data.get("Expense_Header");
		String Columns_header =Excel_data.get("Columns_header");


		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		 verifyMainMenu(driver);
		Extent_call(test, test1,"**Switch the Profile Start**");

		Step_Start(1, "Once login the application,select the required agency.\r\n"
				+ "", test, test1);

		SwitchProfile(driver, Agency);
		Step_End(1, "Once login the application,select the required agency.\r\n"
				+ "", test, test1);
		//

		Step_Start(2, "Enter the module name as \"\"Vendor Invoice Registration\"\" in the search.\r\n"
				+ "", test, test1);
		moduleNavigate(driver, Module_Name);
		Step_End(2, "Enter the module name as \"\"Vendor Invoice Registration\"\" in the search.\r\n"
				+ "", test, test1);
		Step_Start(3, "Select the required Vendor code.\r\n"
				+ "", test, test1);
		waitForElement(driver, Vedor_Code_Search_Button_VIR);
		click(driver, Vedor_Code_Search_Button_VIR);


		globalValueSearchWindow(driver, Condition, Vendor_Code_Search, Vendor_Code, "","", "","");
		Step_End(3, "Select the required Vendor code.\r\n"
				+ "", test, test1);


		if(!Inv_Registration_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Inv_Registration_Date_VIR);
			if (datePicker.trim().equalsIgnoreCase("Yes")) {
				waitForElement(driver, Inv_Registration_Date_VIR);
				selectDatePicker(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);

			} else {
				waitForElement(driver, Inv_Registration_Date_VIR);
				clearAndType(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);
			}
		}
		if(!Inv_Receiving_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Inv_Receiving_Date_VIR);
			if (datePicker.trim().equalsIgnoreCase("Yes")) {
				waitForElement(driver, Inv_Receiving_Date_VIR);
				selectDatePicker(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);

			} else {
				waitForElement(driver, Inv_Receiving_Date_VIR);
				clearAndType(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);

			}}
		if(!Inv_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, vendor_Inv_Date_VIR);
			if (datePicker.trim().equalsIgnoreCase("Yes")) {
				waitForElement(driver, vendor_Inv_Date_VIR);
				selectDatePicker(driver, vendor_Inv_Date_VIR, Inv_Date);

			} else {
				waitForElement(driver, vendor_Inv_Date_VIR);
				clearAndType(driver, vendor_Inv_Date_VIR, Inv_Date);

			}
		}
		if(!Invoice_Currency_Select.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_currency_dd_VIR);
			click(driver, Vendorinvoice_currency_dd_VIR);
			formatLocatorClick(driver, DropDown_Select, Invoice_Currency_Select);
		}

		if(!Disbusse_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			formatLocatorClick(driver, DropDown_Select, Disbusse_currency);

		}

		if(!Payment_method.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Payment_method_dd_VIR);
			click(driver, Vendorinvoice_Payment_method_dd_VIR);
			formatLocatorClick(driver, DropDown_Select, Payment_method);


		}

		if(!Factor_payee_Input.trim().equals("")) {
			waitForElement(driver, factor_Payee_SearchButton_VIR);
			click(driver, factor_Payee_SearchButton_VIR);
			twoColumnSearchWindow(driver, Factor_payee_search, Condition_Filter, Factor_payee_Input);
		}
		
		if(!Inv_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_Inv_Amount_VIR);
			clearAndType(driver, Vendor_Inv_Amount_VIR, Inv_Amount);
		}


		if(!Act_Expensive_amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Act_Expensive_amount_VIR);
			clearAndType(driver, Act_Expensive_amount_VIR, Act_Expensive_amount);
		}
		if(!total_bal_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_total_bal_Amount_VIR);
			clearAndType(driver, Vendor_total_bal_Amount_VIR, total_bal_Amount);
		}

		if(!total_bal_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_Difference_Amount_VIR);
			clearAndType(driver, Vendor_Difference_Amount_VIR,total_bal_Amount);
		}

		if(!netpaid_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_netpaid_Amount_VIR);
			clearAndType(driver, Vendor_netpaid_Amount_VIR, netpaid_Amount);
		}




		if(!invoice_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_ROE_Input_VIR);
			clearAndType(driver, Vendorinvoice_ROE_Input_VIR, invoice_ROE);
		}

		if(!Disbusement_ROE_Input.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusement_ROE_Input_VIR);
			clearAndType(driver, Vendorinvoice_Disbusement_ROE_Input_VIR, Disbusement_ROE_Input);
		}

		if(!Disbusement_Amount_Input.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusement_Amount_Input_VIR);
			clearAndType(driver, Vendorinvoice_Disbusement_Amount_Input_VIR, Disbusement_Amount_Input);
		}



		if(!Home_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, home_ROE_Textfield_VIR);
			clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
		}


		if(!total_Dispute_AMT.trim().equalsIgnoreCase("")) {
			waitForElement(driver, total_Dispute_Amt_Textfield_VIR);
			clearAndType(driver, total_Dispute_Amt_Textfield_VIR, total_Dispute_AMT);
		}

		if(!activity_Dispute.trim().equalsIgnoreCase("")) {
			waitForElement(driver, activity_Dispute_Textfield_VIR);
			clearAndType(driver, activity_Dispute_Textfield_VIR, activity_Dispute);
		}


		if(!other_Dispute.trim().equalsIgnoreCase("")) {
			waitForElement(driver, other_Dispute_Textfield_VIR);
			clearAndType(driver, other_Dispute_Textfield_VIR, other_Dispute);
		}


		if(!total_Tolerance_Amt.trim().equalsIgnoreCase("")) {
			waitForElement(driver, total_Tolerance_Amt_Textfield_VIR);
			clearAndType(driver, total_Tolerance_Amt_Textfield_VIR, total_Tolerance_Amt);
		}
		if(!disputeNumber.trim().equalsIgnoreCase("")) {
			waitForElement(driver, disputeNumber_Textfield_VIR);
			clearAndType(driver, disputeNumber_Textfield_VIR, disputeNumber);
		}



		if(!Activity_Type.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_activity_type);
			click(driver, Vendor_activity_type);
			formatLocatorClick(driver, DropDown_Select, Activity_Type);
		}
		Step_Start(5, "Select the Contract type as PTC.\r\n"
				+ "", test, test1);
		if(!Contract_Type.trim().equalsIgnoreCase("")) {
			waitForElement(driver, vendor_Contract_Typedd);
			click(driver, vendor_Contract_Typedd);
			formatLocatorClick(driver, DropDown_Select, Contract_Type);
		}
		Step_End(5, "Select the Contract type as PTC.\r\n"
				+ "", test, test1);
		Step_Start(4, "Enter the Paper Invoice no. at Vendor Invoice No. field.\r\n"
				+ "", test, test1);
		waitForElement(driver, Vendor_Invoice_Number_Input_VIR1);
		clearAndType(driver, Vendor_Invoice_Number_Input_VIR1,Invoice_Number_Input);
		Step_End(4, "Enter the Paper Invoice no. at Vendor Invoice No. field.\r\n"
				+ "", test, test1);
		Step_Start(6, ".Select the required Service,Vessel,Voyage,Port and Terminal.\r\n"
				+ "", test, test1);
		waitForElement(driver, service_SearchButton_VIR);
		click(driver, service_SearchButton_VIR);

		twoColumnSearchWindow(driver, Service_Search, Two_Condition, Service_Search_Input);



		waitForElement(driver, vessel_SearchButton_VIR);
		click(driver, vessel_SearchButton_VIR);

		twoColumnSearchWindow(driver, Vessel_Search, Two_Condition, Vessel_Search_Input);



		waitForElement(driver, voyage_SearchButton_VIR);
		click(driver, voyage_SearchButton_VIR);

		twoColumnSearchWindow(driver, Voyage_code_Search, Two_Condition, Voyage_code_Input);



		waitForElement(driver, port_SearchButton_VIR);
		click(driver, port_SearchButton_VIR);

		twoColumnSearchWindow(driver, Port_code_search, Two_Condition, Port_code_Input);




		waitForElement(driver, terminal_SearchButton_VIR);
		click(driver, terminal_SearchButton_VIR);

		twoColumnSearchWindow(driver, Terminal_code_search, Two_Condition, Terminal_code_);
		Step_End(6, ".Select the required Service,Vessel,Voyage,Port and Terminal.\r\n"
				+ "", test, test1);
		Step_Start(7, ".Click on the Add button."
				+ "", test, test1);
		waitForElement(driver, add_Button_VIR);
		click(driver, add_Button_VIR);
		Step_End(7, ".Click on the Add button."
				+ "", test, test1);
		Step_Start(8, ".Check whether the records are added into the AG grid.\r\n"
				+ "", test, test1);
		waitForDisplay(driver, vendor_Gird_add);
		if(isdisplayed(driver, vendor_Gird_add)) {

			Extent_pass_New(driver, "Matched || Expected Result is : Data should be added into gird || Actual Result is : Data  was added into gird", test, test1);
			System.out.println("Matched || Expected Result is : Data should be added into gird || Actual Result is :Data  was added into gird");
		}else {
			System.out.println("Not Matched || Expected Result is : Data should be added into gird || Actual Result is : Data  was not added into gird");
			Extent_fail(driver,"Not Matched || Expected Result is : Data should be added into gird|| Actual Result is : Data  was not added into gird", test, test1);
		}
		Step_End(8, ".Check whether the records are added into the AG grid.\r\n"
				+ "", test, test1);


		Step_Start(9, ".Copy the Activity No. form the AG grid by referring the Activity No. column."
				+ "", test, test1);
		
		reArrangeAG_GridColumns(driver, Columns_header);
		
		waitForDisplay(driver, vendor_Activity_ref_number);
		String Ref_Number=getText(driver, vendor_Activity_ref_number);    
		System.out.println(Ref_Number);

		Step_End(9, ".Copy the Activity No. form the AG grid by referring the Activity No. column."
				+ "", test, test1);

		String[] parts = Ref_Number.split("-");  // Split by the hyphen "-"
		String Reference_number_vendor = parts[0] + "-" + parts[1];  // Combine the first two parts
		System.out.println(Reference_number_vendor);
		Step_Start(10, ".Open the Cost Activity Reporting module by using the module search.\r\n"
				+ "", test, test1);
		moduleNavigate(driver, Cost_Module);
		Step_End(10, ".Open the Cost Activity Reporting module by using the module search.\r\n"
				+ "", test, test1);
		Step_Start(11, ".Click on the Global search button,a new tab will open.\r\n"
				+ "", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(11, ".Click on the Global search button,a new tab will open.\r\n"
				+ "", test, test1);
		Step_Start(12, "Paste the copied CAR No. in the CAR No. field and click on the search button.\r\n"
				+ "", test, test1);
		Step_Start(13, "..Our CAR no. will be automatically select in the tab.\r\n"
				+ "", test, test1);
		Step_Start(14, "..Click on the select button.\r\n"
				+ ""
				+ "", test, test1);



		globalValueSearchWindow(driver, Condition, Car_num_Search, Reference_number_vendor, "","", "","");
		Step_End(12, "Paste the copied CAR No. in the CAR No. field and click on the search button.\r\n"
				+ "", test, test1);
		Step_End(13, "..Our CAR no. will be automatically select in the tab.\r\n"
				+ "", test, test1);
		Step_End(14, "..Click on the select button.\r\n"
				+ "", test, test1);

		Step_Start(15, ".Click on the Expense report tab.\r\n"
				+ "", test, test1);
		waitForElement(driver, ExpenseReport);
		click(driver, ExpenseReport);
		Step_End(15, ".Click on the Expe"
				+ "nse report tab.\r\n"+ "", test, test1);
		Step_Start(16, ".A new will be open and click on the approved expense button.\r\""
				+ "", test, test1);
		waitForElement(driver, vendor_Approved_Expenses_tab);
		click(driver, vendor_Approved_Expenses_tab);
		Step_End(16, ".A new will be open and click on the approved expense button.\r\""
				+ "", test, test1);



		Step_Start(17, "Copy the reference no. in the AG grid for all the records by referring the Reference no. column and also it should not invoiced by referring the Invoice No. column.\r\n"
				+ "", test, test1);
		
		reArrangeAG_GridColumns_Expense_Report(driver, Expense_Header);

		
		waitForDisplay(driver, Car_Reference_number_text);
		String Ref_Number_car=getText(driver, Car_Reference_number_text);    
		System.out.println(Ref_Number_car);

		Step_End(17, "Copy the reference no. in the AG grid for all the records by referring the Reference no. column and also it should not invoiced by referring the Invoice No. column.\r\n"
				+ "", test, test1);

		Step_Start(18, "Copy the reference no. in the AG grid for all the records by referring the Reference no. column and also it should not invoiced by referring the Invoice No. column.\r\n"
				+ "", test, test1);


		waitForElement(driver, vendor_Approved_Expenses_tab_close);
		click(driver, vendor_Approved_Expenses_tab_close);


		waitForElement(driver, Close_Current_tab);
		jsClick(driver, Close_Current_tab);


		Step_Start(18, "Then click on the Vendor invoice registration module.\r\n"
				+ "", test, test1);
		Step_Start(19, "Check whether the copied reference no. are available in the AG gid,by referring the Activity Ref. No column.\r\n"
				+ "", test, test1);

		scrollTop(driver);

		if(Ref_Number.equals(Ref_Number_car)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Reference number present in invoice: " + Ref_Number + " || Actual Reference number present in car : " + Ref_Number_car);            
			Extent_pass_New(driver, "Matched || " + " Expected Reference number present in invoice : " + Ref_Number + " || Actual Reference number present in car : " + Ref_Number_car, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Reference number present in invoice : " + Ref_Number + " || Actual Reference number present in car : " + Ref_Number_car);        
			Extent_fail(driver, "Not Matched || " + " Expected Reference number present in invoice : " + Ref_Number + " || Actual Reference number present in car: " + Ref_Number_car, test,test1); 

		} 

		Step_End(18, "Then click on the Vendor invoice registration module.\r\n"
				+ "", test, test1);
		Step_End(19, "Check whether the copied reference no. are available in the AG gid,by referring the Activity Ref. No column.\r\n"
				+ "", test, test1);

		Step_Start(20, "Click on the save button which is available in the Tool bar.\r\n"
				+ "", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(20, "Click on the save button which is available in the Tool bar.\r\n"
				+ "", test, test1);
		Step_Start(21, "Check whether the system prompts a message as \"\"Vendor Invoice saved\"\".\"\r\n"
				+ "", test, test1);
		waitForPopup(driver, popup_Message, Saved_Popup_Expected);                                                                                                               
		String saved_pop_act=getText(driver, popup_Message);    
		System.out.println(saved_pop_act);
		if(Saved_Popup_Expected.equals(saved_pop_act)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + Saved_Popup_Expected + " || Actual Report Activity popup is : " + saved_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity popup is : " + Saved_Popup_Expected + " || Actual Report Activity popup is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity popup is : " + Saved_Popup_Expected + " || Actual Report Activity popup is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity popup is : " + Saved_Popup_Expected + " || Actual Report Activity popup is : " + saved_pop_act, test,test1); 

		} 

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(21, "Check whether the system prompts a message as \"\"Vendor Invoice saved\"\".\"\r\n"
				+ "", test, test1);



		waitForElement(driver, vendor_Invoice_Number);
		String actual_Vendor_Reg_No=getAttribute(driver, vendor_Invoice_Number, "value");
		System.out.println("Generarted Vendor Reg No : "+actual_Vendor_Reg_No);
		if(!actual_Vendor_Reg_No.equals("")) {
			System.out.println("Passed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is generated || generated Vendor Reg No : "+actual_Vendor_Reg_No);
			Extent_pass_New(driver, "Passed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is generated || generated Vendor Reg No : "+actual_Vendor_Reg_No, test, test1);
		}else {
			System.out.println("Failed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is not generated || generated Vendor Reg No : "+actual_Vendor_Reg_No);
			Extent_fail(driver, "Failed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is not generated || generated Vendor Reg No : "+actual_Vendor_Reg_No, test, test1);
		}

		Extent_completed(testcase_Name, test, test1);
	}
}
