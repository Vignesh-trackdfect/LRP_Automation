package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC41  extends Keywords{
	
	
	public void Vendor_Invoice_Registration_SC41(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

	String testcase_Name="TC_Vendor_Invoice_Registration_SC41";

	String Username = Excel_data.get("Username");
	String Password = Excel_data.get("Password");
	String Module_Name = Excel_data.get("Module_Name");
	String Agency = Excel_data.get("Agency");
	String Vendor_Code = Excel_data.get("Vendor_Code");
	String Vendor_Code_Search = Excel_data.get("Vendor_Code_Search");
	String Inv_Receiving_Date = Excel_data.get("Inv_Receiving_Date");
	String Inv_Registration_Date = Excel_data.get("Inv_Registration_Date");
	String Inv_Date = Excel_data.get("Inv_Date");
	String Factor_payee_search = Excel_data.get("Factor_payee_search");
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
	String Saved_Popup_Expected = Excel_data.get("Saved_Popup_Expected");
	String Invoice_Currency_Select = Excel_data.get("Invoice_Currency_Select");
	String datePicker = Excel_data.get("datePicker");
	String Vendor_Quantity_input = Excel_data.get("Vendor_Quantity_input");
	String Vendor_invoice_amount_input = Excel_data.get("Vendor_invoice_amount_input");
	String Condition_Filter = Excel_data.get("Condition_Filter");
	String mainActivity = Excel_data.get("MainActivity_Code");
	String condition = Excel_data.get("Condition");
	String main_Activity_Header = Excel_data.get("Main_Activity_Header");
	String subActivity_Code = Excel_data.get("SubActivity_Code");
	String sub_Activity_Header = Excel_data.get("Sub_Activity_Header");
	String Equipment_Type = Excel_data.get("Equipment_Type");
	String equipment_Type_Header = Excel_data.get("Equipment_Type_Header");
	String Port_Header = Excel_data.get("Port_Header");
	String Port_Code = Excel_data.get("Port_Code");
	String Filter_Headers = Excel_data.get("Filter_Headers");
	
	
	

	Extent_Start(testcase_Name, test, test1);

	navigateUrl(driver, url);
	LRP_Login(driver, Username, Password);

	Extent_call(test, test1,"**Switch the Profile Start**");


	SwitchProfile(driver, Agency);
	//

	Step_Start(1, "Enter the screen name as a \"\"Vendor Invoice Registration\"\" in the Search.", test, test1);
	moduleNavigate(driver, Module_Name);
	Step_End(1, "Enter the screen name as a \"\"Vendor Invoice Registration\"\" in the Search.", test, test1);
		
	Step_Start(2, "Click the Vendor code search button", test, test1);
	waitForElement(driver, Vedor_Code_Search_Button_VIR);
	click(driver, Vedor_Code_Search_Button_VIR);
	Step_End(2, "Click the Vendor code search button", test, test1);
	Step_Start(3, "It shows the approved vendor based on the vendor master", test, test1);
	Step_Start(4, "Select the Required vendor code and name.", test, test1);
	globalValueSearchWindow(driver, condition, Vendor_Code_Search, Vendor_Code, "","", "","");
	Step_End(4, "Select the Required vendor code and name.", test, test1);
	Step_End(3, "It shows the approved vendor based on the vendor master", test, test1);
	
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
		Step_Start(7, "Click the Disburse currency dropdown.", test, test1);
		if(!Disbusse_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			Step_End(7, "Click the Disburse currency dropdown.", test, test1);
			Step_Start(8, "Select the Require currency..", test, test1);
			formatLocatorClick(driver, DropDown_Select, Disbusse_currency);
			Step_End(8, "Select the Require currency..", test, test1);
			
			}
			
		Step_Start(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
		Step_Start(10, "Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master.", test, test1);
		waitForElement(driver, Vendorinvoice_Payment_method_dd_VIR);
		String Payment_Method_Value_VIR = getText(driver, Vendorinvoice_Payment_method_dd_VIR);
		System.out.println("Payment_Method_Value_VIR :" + Payment_Method_Value_VIR);

		if (Payment_method.trim().equalsIgnoreCase(Payment_Method_Value_VIR)) {
			System.out.println("Matched ||Payment Method Value Taken from Vendor Master Module :" + Payment_method
					+ "||Payment Method Value Taken from Vendor Invoice registration Module :"
					+ Payment_Method_Value_VIR);
			Extent_pass_New(driver,
					"Matched ||Payment Method Value Taken from Vendor Master Module :" + Payment_method
							+ "||Payment Method Value Taken from Vendor Invoice registration Module :"
							+ Payment_Method_Value_VIR,
					test, test1);

			
			Step_End(10, "Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master.", test, test1);
			Step_End(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
		} else {
			Step_Start(11, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);

			waitForElement(driver, Vendorinvoice_Payment_method_dd_VIR);
			click(driver, Vendorinvoice_Payment_method_dd_VIR);
			formatLocatorClick(driver, DropDown_Select, Payment_method);
			Step_End(11, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);

		}

		if (!Payment_method.isEmpty()) {

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
	

	Step_Start(12, "In the Activity details, Click Activity type dropdown and select the activity type as a \"\"CHP", test, test1);
	if(!Activity_Type.trim().equalsIgnoreCase("")) {
		waitForElement(driver, Vendor_activity_type);
		click(driver, Vendor_activity_type);
		formatLocatorClick(driver, DropDown_Select, Activity_Type);
		}
	Step_End(13, "In the Activity details, Click Activity type dropdown and select the activity type as a \"\"CHP", test, test1);
	
	
	Step_Start(5, "Click the Vendor invoice field", test, test1);
	Step_Start(6, "Enter the value up to 25 characters", test, test1);
	waitForElement(driver, Vendor_Invoice_Number_Input_VIR1);
	clearAndType(driver, Vendor_Invoice_Number_Input_VIR1,Invoice_Number_Input);
	Step_End(6, "Enter the value up to 25 characters", test, test1);
	Step_End(5, "Click the Vendor invoice field", test, test1);
	
	
	
	Step_Start(13, "Default system select the Bill no.", test, test1);
	waitForElement(driver, VHP_Bill_num);
	String FDR_Status = getAttribute(driver, VHP_Bill_num, "class");

	if (extractstatus(FDR_Status)) {

		System.out.println(
				"Expected result is : By default system should select the Bill No Tab || Actual result : Bill No tab is selected as default ");
		Extent_pass_New(driver,
				"Expected result is : By default system should select the Bill No Tab || Actual result : Bill tab is selected as default",
				test, test1);

	} else {

		System.out.println(
				"Expected result is : By default system should select the Bill No Tab || Actual result : Bill No tab is not selected as default ");
		Extent_fail(driver,
				"Expected result is : By default system should select the Bill No Tab || Actual result :Bill No tab is not selected as default",
				test, test1);

	}
	Step_End(13, "Default system select the Bill no.", test, test1);
	
	
	
	waitForElement(driver, Manual_activity_button);
	click(driver, Manual_activity_button);

	Step_Start(14, "Click the Manual activity.", test, test1);
	waitForElement(driver, mainActivity_Searchbutton_VIR);
	click(driver, mainActivity_Searchbutton_VIR);
	Step_End(14, "Click the Manual activity.", test, test1);
	Step_Start(15, "Click the Main activity search and select the Activity.", test, test1);
	twoColumnSearchWindow(driver, main_Activity_Header, condition, mainActivity);
	Step_End(15, "Click the Main activity search and select the Activity.", test, test1);
	
	Step_Start(16, "Click the Sub activity \"\"+\"\" and select the require activity..", test, test1);
	waitForElement(driver, subActivity_Addbutton_VIR);
	click(driver, subActivity_Addbutton_VIR);
	
	twoColumnSearchWindow(driver, sub_Activity_Header, condition, subActivity_Code);
	Step_End(16, "Click the Sub activity \"\"+\"\" and select the require activity..", test, test1);
	Step_Start(17, "Click eqp type search and select the Equipment type.", test, test1);
	waitForElement(driver, eqp_Type_SearchButton_VIR);
	click(driver, eqp_Type_SearchButton_VIR);
	
	twoColumnSearchWindow(driver, equipment_Type_Header, condition, Equipment_Type);
	
	Step_End(17, "Click eqp type search and select the Equipment type.", test, test1);
	Step_Start(18, "Click the Port search and select the required Port", test, test1);
	waitForElement(driver, port_SearchButton_Manual_VIR);
	click(driver, port_SearchButton_Manual_VIR);
	
	twoColumnSearchWindow(driver, Port_Header, condition, Port_Code);
	Step_End(18, "Click the Port search and select the required Port", test, test1);

	Step_Start(19, ".Click the \"\"+ADD\"\" button, Details added in the Grid.", test, test1);

	waitForElement(driver, add_Button_ManualActivity_VIR);
	click(driver, add_Button_ManualActivity_VIR);

	

	waitForDisplay(driver, vendor_Gird_add);
	if(isdisplayed(driver, vendor_Gird_add)) {
		
		Extent_pass_New(driver, "Matched || Expected Result is : Data should be added into gird || Actual Result is : Data  was added into gird", test, test1);
		System.out.println("Matched || Expected Result is : Data should be added into gird || Actual Result is :Data  was added into gird");
	}else {
		System.out.println("Not Matched || Expected Result is : Data should be added into gird || Actual Result is : Data  was not added into gird");
		Extent_fail(driver,"Not Matched || Expected Result is : Data should be added into gird|| Actual Result is : Data  was not added into gird", test, test1);
	}
		
	Step_End(19, ".Click the \"\"+ADD\"\" button, Details added in the Grid.", test, test1);
	reArrangeAG_GridColumns(driver, Filter_Headers);

		
		waitForElement(driver, invoiceQuantity_Gridcell_VIR);
		doubleClick(driver, invoiceQuantity_Gridcell_VIR);
		
		waitForElement(driver, invoiceQuantity_Input_Gridcell_VIR);
		clearAndType(driver, invoiceQuantity_Input_Gridcell_VIR, Vendor_Quantity_input);
		enter(driver);
		
		waitForElement(driver, invoiceAmount_Gridcell_VIR);
		doubleClick(driver, invoiceAmount_Gridcell_VIR);
		
		waitForElement(driver, invoiceAmount_Input_Gridcell_VIR);
		clearAndType(driver, invoiceAmount_Input_Gridcell_VIR, Vendor_invoice_amount_input);
		enter(driver);
		
		
		
		Step_Start(20, "Click the save", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(20, "Click the save", test, test1); 
		
		
		List<WebElement> popup_message = listOfElements(driver, popup_Message_Ok_Button);
		if(popup_message.size()>1) {
			waitForElement(driver, popup_Message_Ok_Button);
			jsClick(driver, popup_Message_Ok_Button);
		}
		
		waitForPopup(driver, popup_Message, Saved_Popup_Expected);                                                                                                               
		String saved_pop_act=getText(driver, popup_Message);    
		System.out.println(saved_pop_act);
		if(Saved_Popup_Expected.trim().equals(saved_pop_act)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity  popup is : " + Saved_Popup_Expected + " || Actual Report Activity popup is : " + saved_pop_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity popup is : " + Saved_Popup_Expected + " || Actual Report Activity popup is : " + saved_pop_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity popup is : " + Saved_Popup_Expected + " || Actual Report Activity popup is : " + saved_pop_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity popup is : " + Saved_Popup_Expected + " || Actual Report Activity popup is : " + saved_pop_act, test,test1); 

		} 
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		reArrangeAG_GridColumns(driver, Filter_Headers);
		
		
		
		waitForElement(driver, Vendor_sub_activity_code);
		String Sub_Activity_code_act=getText(driver, Vendor_sub_activity_code);    
		System.out.println(Sub_Activity_code_act);
		waitForElement(driver, Vendor_main_activity_code);
		String main_Activity_code_act=getText(driver, Vendor_main_activity_code);    
		System.out.println(main_Activity_code_act);
		
		
		
		
		waitForElement(driver, Vendor_invoice_amount_gird);
		String Invoice_amount_act=getText(driver, Vendor_invoice_amount_gird);    
		System.out.println(Invoice_amount_act);
		

		// Remove commas and decimal part
		String amountWithoutCommas = Invoice_amount_act.replace(",", "").split("\\.")[0];

		// Convert it to an integer or double as needed
		int finalAmount = Integer.parseInt(amountWithoutCommas);

		//System.out.println("Amount without commas: " + finalAmount); // 
		String finalAmountAsString = String.valueOf(finalAmount); // or use Integer.toString(finalAmount);

	//	System.out.println("Amount as String: " + finalAmountAsString);
		waitForElement(driver, Vendor_invoice_qty_gird);
		String Invoice_Quantity_act=getText(driver, Vendor_invoice_qty_gird);    
		System.out.println(Invoice_Quantity_act);
		
		// Remove commas and decimal part
				String qtyWithoutCommas = Invoice_Quantity_act.replace(",", "").split("\\.")[0];

				// Convert it to an integer or double as needed
				int finalQTY = Integer.parseInt(qtyWithoutCommas);

				//System.out.println("Amount without commas: " + finalAmount); // 
				String finalQutyAsString = String.valueOf(finalQTY); // or use Integer.toString(finalAmount);
		
		
		

		
		if(Vendor_invoice_amount_input.trim().equals(finalAmountAsString)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Amount was given in gird : " + Vendor_invoice_amount_input + " || Actual Amount was taken from gird : " + finalAmountAsString);            
			Extent_pass_New(driver, "Matched || " + " Expected Amount was given in gird : " + Vendor_invoice_amount_input + " || Actual Amount was taken from gird  : " + finalAmountAsString, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Amount was given in gird : " + Vendor_invoice_amount_input + " || Actual Amount was taken from gird  : " + finalAmountAsString);        
			Extent_fail(driver, "Not Matched || " + " Expected Amount was given in gird : " + Vendor_invoice_amount_input + " || Actual Amount was taken from gird : " + finalAmountAsString, test,test1); 

		} 
		
		if(Vendor_Quantity_input.trim().equals(finalQutyAsString)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Quantity was given in gird : " + Vendor_Quantity_input + " || Actual Quantity was taken from gird : " + finalQutyAsString);            
			Extent_pass_New(driver, "Matched || " + " Expected Quantity was given in gird : " + Vendor_Quantity_input + " || Actual Quantity was taken from gird  : " + finalQutyAsString, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Quantity was given in gird : " + Vendor_Quantity_input + " || Actual Quantity was taken from gird  : " + finalQutyAsString);        
			Extent_fail(driver, "Not Matched || " + " Expected Quantity was given in gird : " + Vendor_Quantity_input + " || Actual Quantity was taken from gird : " + finalQutyAsString, test,test1); 

		} 
		
		
		
		
		if(subActivity_Code.trim().equals(Sub_Activity_code_act)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Sub Activity code  was given in gird : " + subActivity_Code + " || Actual Sub Activity code  was taken from gird : " + Sub_Activity_code_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Sub Activity code  was given in gird : " + subActivity_Code + " || Actual Sub Activity code  was taken from gird  : " + Sub_Activity_code_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Sub Activity code  was given in gird : " + subActivity_Code + " || Actual Sub Activity code  was taken from gird  : " + Sub_Activity_code_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Sub Activity code  was given in gird : " + subActivity_Code + " || Actual Sub Activity code  was taken from gird : " + Sub_Activity_code_act, test,test1); 

		} 
		
		
		
		
		if(mainActivity.trim().equals(main_Activity_code_act)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Main Activity code  was given in gird : " + mainActivity + " || Actual Sub Activity code  was taken from gird : " + main_Activity_code_act);            
			Extent_pass_New(driver, "Matched || " + " Expected Main Activity code  was given in gird : " + mainActivity + " || Actual Sub Activity code  was taken from gird  : " + main_Activity_code_act, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Main Activity code  was given in gird : " + mainActivity + " || Actual Sub Activity code  was taken from gird  : " + main_Activity_code_act);        
			Extent_fail(driver, "Not Matched || " + " Expected Main Activity code  was given in gird : " + mainActivity + " || Actual Sub Activity code  was taken from gird : " + main_Activity_code_act, test,test1); 

		} 
		
		Step_Start(21, ".It auto generate the Invoice Reg No", test, test1);
		waitForElement(driver, vendor_Invoice_Number);
		String actual_Vendor_Reg_No=getAttribute(driver, vendor_Invoice_Number, "value");
		System.out.println("Generarted Vendor Reg No : "+actual_Vendor_Reg_No);
		if(!actual_Vendor_Reg_No.trim().equals("")) {
			System.out.println("Passed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is generated || generated Vendor Reg No : "+actual_Vendor_Reg_No);
			Extent_pass_New(driver, "Passed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is generated || generated Vendor Reg No : "+actual_Vendor_Reg_No, test, test1);
		}else {
			System.out.println("Failed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is not generated || generated Vendor Reg No : "+actual_Vendor_Reg_No);
			Extent_fail(driver, "Failed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is not generated || generated Vendor Reg No : "+actual_Vendor_Reg_No, test, test1);
		}
		Step_End(21, ".It auto generate the Invoice Reg No", test, test1);
		Extent_completed(testcase_Name, test, test1);
		
	
}}
