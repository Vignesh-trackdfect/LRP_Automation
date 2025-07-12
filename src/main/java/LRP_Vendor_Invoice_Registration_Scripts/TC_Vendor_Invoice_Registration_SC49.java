package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


public class TC_Vendor_Invoice_Registration_SC49 extends Keywords{
	public void Vendor_Invoice_Registration_SC49(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
	
		
		String testCaseName = "TC_Vendor_Invoice_Registration_SC49";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String agencyCode = Excel_data.get("AgencyCode");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
		String vendorCode = Excel_data.get("VendorCode");
		String vendorInvoiceNumber = Excel_data.get("VendorInvoiceNumber");
		String Inv_Registration_Date = Excel_data.get("Inv_Registration_Date");
		String Inv_Receiving_Date = Excel_data.get("Inv_Receiving_Date");
		String Inv_Date = Excel_data.get("Inv_Date");
		String datePicker = Excel_data.get("datePicker");
		String Factor_payee_search = Excel_data.get("Factor_payee_search");
		String Factor_payee_Input = Excel_data.get("Factor_payee_Input");
		String Inv_Amount = Excel_data.get("Inv_Amount");
		String Disburse_currency = Excel_data.get("Disburse_currency");
		String invoice_ROE = Excel_data.get("invoice_ROE");
		String Payment_method = Excel_data.get("Payment_method");
		String invoice_currency = Excel_data.get("Invoice_currency");
		String Home_ROE = Excel_data.get("Home_ROE");
		String Vendor_Master_Module = Excel_data.get("Vendor_Master_Module");
		String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
		String paymentMode_RadioButton_Status = Excel_data.get("PaymentMode_RadioButton_Status");
		String PaymentModes_VIR = Excel_data.get("PaymentModes_VIR");
		String PaymentModes_VM = Excel_data.get("PaymentModes_VM");
		String ActivityType = Excel_data.get("ActivityType");
		String InvoiceSaved_Popup = Excel_data.get("InvoiceSaved_Popup");
		String costConfiguration_Module = Excel_data.get("CostConfiguration_Module");
		String cost_Attribute = Excel_data.get("cost_Attribute");
		String value = Excel_data.get("Value");
		String Exp_Diffrent=Excel_data.get("Exp_Diffrent");
		String Attach_popup=Excel_data.get("Attach_popup");
		String Updated_Popup =Excel_data.get("Updated_Popup");
		
		String Two_Column_Search_Condition =Excel_data.get("Two_Column_Search_Condition");

		String Activity_SelectionType = Excel_data.get("Activity_SelectionType");
		String Service_Code_Value = Excel_data.get("Service_Code_Value");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Vessel_Code_Value = Excel_data.get("Vessel_Code_Value");
		String Vessel_Code_Header = Excel_data.get("Vessel_Code_Header");
		String Voyage_Code_Value = Excel_data.get("Voyage_Code_Value");
		String Voyage_Code_Header = Excel_data.get("Voyage_Code_Header");
		String Port_Code_Value = Excel_data.get("Port_Code_Value");
		String Port_Code_Header = Excel_data.get("Port_Code_Header");
		String Terminal_Code_Value = Excel_data.get("Terminal_Code_Value");
		String Terminal_Code_Header = Excel_data.get("Terminal_Code_Header");
		String Discharge_Port_Value = Excel_data.get("Discharge_Port_Value");
		String Discharge_Port_Header = Excel_data.get("Discharge_Port_Header");
		String Discharge_Terminal_Value = Excel_data.get("Discharge_Terminal_Value");
		String Discharge_Terminal_Header = Excel_data.get("Discharge_Terminal_Header");
		String Invoice_Quantity_Value = Excel_data.get("Invoice_Quantity_Value");
		String Invoice_Amount_Value = Excel_data.get("Invoice_Amount_Value");

		//CAR
		String CAR_Contract_Type = Excel_data.get("CAR_Contract_Type");
		String CAR_No_Header = Excel_data.get("CAR_No_Header");
		String CAR_No_Value = Excel_data.get("CAR_No_Value");
		//ACR
		String ACR_No_Header = Excel_data.get("ACR_No_Header");
		String ACR_No_Input = Excel_data.get("ACR_No_Input");
		//FDR
		String FDR_Header = Excel_data.get("FDR_Header");
		String FDR_SumNo = Excel_data.get("FDR_SumNo");
		//HCN
		String Hlg_SumNo_Header = Excel_data.get("Hlg_SumNo_Header");
		String Hlg_SumNo_Value = Excel_data.get("Hlg_SumNo_Value");
		//STC
		String STC_Report_No_Header = Excel_data.get("STC_Report_No_Header");
		String STC_Sum_No = Excel_data.get("STC_Sum_No");
		//STP
		String STP_No_Header = Excel_data.get("STP_No_Header");
		String STP_No_Value = Excel_data.get("STP_No_Value");
		//STP
		String BRQ_No_Header = Excel_data.get("BRQ_No_Header");
		String BRQ_No_Value = Excel_data.get("BRQ_No_Value");
		//STP
		String Bill_Number_Header_CHP = Excel_data.get("Bill_Number_Header_CHP");
		String Bill_No_Value_CHP = Excel_data.get("Bill_No_Value_CHP");
		//STP
		String Bill_Number_Header_EMB = Excel_data.get("Bill_Number_Header_EMB");
		String Bill_No_Value_EMB = Excel_data.get("Bill_No_Value_EMB");
		//STP
		String CMR_No_Header = Excel_data.get("CMR_No_Header");
		String CMR_No_Value = Excel_data.get("CMR_No_Value");
		String DA_Month_Input_CMR = Excel_data.get("DA_Month_Input_CMR");
		String Activity_Month_CMR = Excel_data.get("Activity_Month_CMR");
		//AGY
		String AGY_No_Header = Excel_data.get("AGY_No_Header");
		String AGY_No_Value = Excel_data.get("AGY_No_Value");
		//SOR
		String SOR_No_Header = Excel_data.get("SOR_No_Header");
		String SOR_No_Value = Excel_data.get("SOR_No_Value");
		String DA_Month_Input_SOR = Excel_data.get("DA_Month_Input_SOR");
		String Activity_Month_SOR = Excel_data.get("Activity_Month_SOR");
		//SOR
		String SLO_No_Header = Excel_data.get("SLO_No_Header");
		String SLO_No_Value = Excel_data.get("SLO_No_Value");		

		String Main_Activity_Header = Excel_data.get("Main_Activity_Header");		
		String Main_Activity_Value = Excel_data.get("Main_Activity_Value");		
		String Sub_Activity_Header = Excel_data.get("Sub_Activity_Header");		
		String Sub_Activity_Value = Excel_data.get("Sub_Activity_Value");		
		String Equipment_Type_Header = Excel_data.get("Equipment_Type_Header");	
		String Equipment_Type_Value = Excel_data.get("Equipment_Type_Value");		
		String Equipment_Status_Value = Excel_data.get("Equipment_Status_Value");	
		
		
		Extent_Start(testCaseName, test, test1);
		
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		Step_Start(1, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);

		SwitchProfile(driver, agencyCode);

		Step_Start(21, "Based on the ATT configuration from the Cost configuration screen", test, test1);
		moduleNavigate(driver, costConfiguration_Module);

		waitForElement(driver, cost_Attribute_Filter_CSO);
		sendKeys(driver, cost_Attribute_Filter_CSO, cost_Attribute);

		waitForElement(driver, retrieved_Attribute_Value_CSO);
		doubleClick(driver, retrieved_Attribute_Value_CSO);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, value_Textfield_CSO);
		clearAndType(driver, value_Textfield_CSO, value);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Step_End(21, "Based on the ATT configuration from the Cost configuration screen", test, test1);
		
		moduleNavigate(driver, Vendor_Master_Module);

		waitForElement(driver, new_Button_VM);
		click(driver, new_Button_VM);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");

		List<String> paymentModes_VM = splitAndExpand(PaymentModes_VM);
		List<String> paymentModes_VIR = splitAndExpand(PaymentModes_VIR);

		waitForElement(driver, HQ_RadioButton_VM);
		String status_Of_HQ_RadioButton_VM = getAttribute(driver, HQ_RadioButton_VM, "class");
		String status_Of_Disbursement_RadioButton_VM = getAttribute(driver, Disbursement_RadioButton_VM, "class");

		if (status_Of_HQ_RadioButton_VM.contains(paymentMode_RadioButton_Status)) {
			status_Of_HQ_RadioButton_VM = paymentMode_RadioButton_Status;
		} else if (status_Of_Disbursement_RadioButton_VM.contains(paymentMode_RadioButton_Status)) {
			status_Of_Disbursement_RadioButton_VM = paymentMode_RadioButton_Status;

		}

		waitForElement(driver, Paymemnt_Method_VM);
		String Payment_Method_Value = getText(driver, Paymemnt_Method_VM);
		System.out.println("Payment_Method_Value VM :" + Payment_Method_Value);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		moduleNavigate(driver, moduleName);

		Step_End(1, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);

		Step_Start(2, "Click the Vendor code search button", test, test1);

		waitForElement(driver, Vedor_Code_Search_Button_VIR);
		click(driver, Vedor_Code_Search_Button_VIR);

		Step_End(2, "Click the Vendor code search button", test, test1);
		Step_Start(3, "It shows the approved vendor based on the vendor master.", test, test1);
		Step_Start(4, "Select the Required vendor code and name.", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");

		Step_End(3, "It shows the approved vendor based on the vendor master.", test, test1);
		Step_End(4, "Select the Required vendor code and name.", test, test1);

		if (!Inv_Registration_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Inv_Registration_Date_VIR);
			if (datePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Inv_Registration_Date_VIR);
				selectDatePicker(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);

			} else {
				waitForElement(driver, Inv_Registration_Date_VIR);
				clearAndType(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);
			}
		}
		if (!Inv_Receiving_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Inv_Receiving_Date_VIR);
			if (datePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, Inv_Receiving_Date_VIR);
				selectDatePicker(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);

			} else {
				waitForElement(driver, Inv_Receiving_Date_VIR);
				clearAndType(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);

			}
		}
		if (!Inv_Date.trim().equalsIgnoreCase("")) {
			waitForElement(driver, vendor_Inv_Date_VIR);
			if (datePicker.equalsIgnoreCase("Yes")) {
				waitForElement(driver, vendor_Inv_Date_VIR);
				selectDatePicker(driver, vendor_Inv_Date_VIR, Inv_Date);

			} else {
				waitForElement(driver, vendor_Inv_Date_VIR);
				clearAndType(driver, vendor_Inv_Date_VIR, Inv_Date);
			}
		}
		
		if(!Factor_payee_Input.trim().equals("")) {
			waitForElement(driver, factor_Payee_SearchButton_VIR);
			click(driver, factor_Payee_SearchButton_VIR);
			twoColumnSearchWindow(driver, Factor_payee_search, Two_Column_Search_Condition, Factor_payee_Input);
		}
		
		Step_Start(5, "Click the Vendor invoice field.", test, test1);

		waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
		click(driver, Vendor_Invoice_Number_Input_VIR);

		Step_End(5, "Click the Vendor invoice field.", test, test1);
		Step_Start(6, "Enter the value up to 25 characters.", test, test1);

		sendKeys(driver, Vendor_Invoice_Number_Input_VIR, vendorInvoiceNumber);

		Step_End(6, "Enter the value up to 25 characters.", test, test1);

		if (!Inv_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_Inv_Amount_VIR);
			clearAndType(driver, Vendor_Inv_Amount_VIR, Inv_Amount);
		}

		if (!invoice_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, invoiceCurrency_Dropdown_VIR);
			click(driver, invoiceCurrency_Dropdown_VIR);

			String invoiceCurrency_select = String.format(DropDown_Select, invoice_currency);
			click(driver, invoiceCurrency_select);
		}

		if (!invoice_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_ROE_Input_VIR);
			clearAndType(driver, Vendorinvoice_ROE_Input_VIR, invoice_ROE);
		}

		Step_Start(7, "Click the Disburse currency dropdown", test, test1);

		if (!Disburse_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);

			Step_End(7, "Click the Disburse currency dropdown", test, test1);
			Step_Start(8, "Select the Require currency.", test, test1);

			String currency_select = String.format(DropDown_Select, Disburse_currency);
			waitForElement(driver, currency_select);
			click(driver, currency_select);

			Step_End(8, "Select the Require currency.", test, test1);

		}

		Step_Start(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);

		waitForElement(driver, direct_Payment_Mode_Button_VIR);
		String status_Of_direct_Payment_Mode_Button_VIR = getAttribute(driver, direct_Payment_Mode_Button_VIR, "class");
		String status_Of_disbursment_Payement_Mode_Button_VIR = getAttribute(driver,
				disbursment_Payement_Mode_Button_VIR, "class");

		if (status_Of_direct_Payment_Mode_Button_VIR.contains(status_Of_HQ_RadioButton_VM)) {

			System.out.println(
					"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(0)
							+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
							+ paymentModes_VIR.get(0));
			Extent_pass_New(driver,
					"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(0)
							+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
							+ paymentModes_VIR.get(0),
					test, test1);
		} else if (status_Of_disbursment_Payement_Mode_Button_VIR.contains(status_Of_Disbursement_RadioButton_VM)) {
			System.out.println(
					"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(1)
							+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
							+ paymentModes_VIR.get(1));
			Extent_pass_New(driver,
					"Matched || Expected Radio Button selected in Vendor Master module : " + paymentModes_VM.get(1)
							+ " || Actual Radio Button selected in Vendor Invoice Registration module : "
							+ paymentModes_VIR.get(1),
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected result is : expected radio button should be selected || Actual result is : Expected Radio Button is not selected");
			Extent_fail(driver,
					"Not Matched || Expected result is : expected radio button should be selected || Actual result is : Expected Radio Button is not selected",
					test, test1);
		}

		Step_End(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
		Step_Start(10,
				"Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master.",
				test, test1);

		waitForElement(driver, Payment_Method_VIR);
		String Payment_Method_Value_VIR = getText(driver, Payment_Method_VIR);
		System.out.println("Payment_Method_Value_VIR :" + Payment_Method_Value_VIR);

		if (Payment_Method_Value.equalsIgnoreCase(Payment_Method_Value_VIR)) {
			System.out.println("Matched ||Payment Method Value Taken from Vendor Master Module :" + Payment_Method_Value
					+ "||Payment Method Value Taken from Vendor Invoice registration Module :"
					+ Payment_Method_Value_VIR);
			Extent_pass_New(driver,
					"Matched ||Payment Method Value Taken from Vendor Master Module :" + Payment_Method_Value
							+ "||Payment Method Value Taken from Vendor Invoice registration Module :"
							+ Payment_Method_Value_VIR,
					test, test1);

			Step_End(10,
					"Payment method is auto fetch from vendor master based on the Payment method whether it present in vendor master.",
					test, test1);

		} else {
			Step_Start(11, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);
			if(!Payment_method.trim().equals("")) {
				waitForElement(driver, Payment_Method_VIR);
				click(driver, Payment_Method_VIR);
				formatLocatorClick(driver, DropDown_Select, Payment_method);
			}
			Step_End(11, "Otherwise Click the Payment method dropdown and select the Required Method.", test, test1);
		}

		if (!Home_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, home_ROE_Textfield_VIR);
			clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
		}
		
		Step_Start(12, "In the Activity details, Click Activity type dropdown and select the activity type as a 'FDR'",
				test, test1);

		waitForElement(driver, Vendor_activity_type);
		click(driver, Vendor_activity_type);

		formatLocatorClick(driver, DropDown_Select, ActivityType);

		
		Step_Start(12, "Click the '"+Activity_SelectionType+"' and select the Required Values", test, test1);
		
		String RouteTypeBtn=String.format(ActivityType_Radiobutton_VIR, Activity_SelectionType);
		waitForElement(driver, RouteTypeBtn);
		click(driver,RouteTypeBtn);
		
		if(ActivityType.equalsIgnoreCase("CAR")) {
			
			waitForElement(driver, vendor_Contract_Typedd);
			click(driver,vendor_Contract_Typedd);
			formatLocatorClick(driver, DropDown_Select, CAR_Contract_Type);
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);
			}else if (Activity_SelectionType.equalsIgnoreCase("CAR No")) {
				waitForElement(driver, CAR_No_option_VIR);
				click(driver, CAR_No_option_VIR);
				
				waitForElement(driver, CAR_PLUS_button_VIR);
				click(driver, CAR_PLUS_button_VIR);

				twoColumnSearchWindow(driver, CAR_No_Header, Two_Column_Search_Condition, CAR_No_Value);
						
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);
			
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
		}else if (ActivityType.equalsIgnoreCase("ACR")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);
			
			}else if (Activity_SelectionType.equalsIgnoreCase("ACR No")) {
				waitForElement(driver, ACR_No_SearchButton_VIR);
				click(driver, ACR_No_SearchButton_VIR);
				twoColumnSearchWindow(driver, ACR_No_Header, Two_Column_Search_Condition, ACR_No_Input);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
			
		}else if (ActivityType.equalsIgnoreCase("FDR")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);

				if(IsElementEnabled(driver, DischargePort_SearchBtn_All_VIR)) {
					waitForElement(driver, DischargePort_SearchBtn_All_VIR);
					click(driver,DischargePort_SearchBtn_All_VIR);
					twoColumnSearchWindow(driver, Discharge_Port_Header, Two_Column_Search_Condition, Discharge_Port_Value);
				}
				
				if(IsElementEnabled(driver, DischargeTerminal_SearchBtn_All_VIR)) {
					waitForElement(driver, DischargeTerminal_SearchBtn_All_VIR);
					click(driver,DischargeTerminal_SearchBtn_All_VIR);
					twoColumnSearchWindow(driver, Discharge_Terminal_Header, Two_Column_Search_Condition, Discharge_Terminal_Value);
				}
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Fdr Sum No")) {
				waitForElement(driver, FDR_PLUS_button_VIR);
				click(driver, FDR_PLUS_button_VIR);
				twoColumnSearchWindow(driver, FDR_Header, Two_Column_Search_Condition, FDR_SumNo);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

				if(IsElementEnabled(driver, FDR_POD)) {
					waitForElement(driver, FDR_POD);
					click(driver,FDR_POD);
					twoColumnSearchWindow(driver, Discharge_Terminal_Header, Two_Column_Search_Condition, Discharge_Terminal_Value);
				}
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
		}else if (ActivityType.equalsIgnoreCase("HCN")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);

				waitForElement(driver, DischargePort_SearchBtn_All_VIR);
				click(driver,DischargePort_SearchBtn_All_VIR);
				twoColumnSearchWindow(driver, Discharge_Port_Header, Two_Column_Search_Condition, Discharge_Port_Value);
				
				waitForElement(driver, DischargeTerminal_SearchBtn_All_VIR);
				click(driver,DischargeTerminal_SearchBtn_All_VIR);
				twoColumnSearchWindow(driver, Discharge_Terminal_Header, Two_Column_Search_Condition, Discharge_Terminal_Value);

				
			}else if (Activity_SelectionType.equalsIgnoreCase("Hlg Sum No")) {
				waitForElement(driver, Vendor_Invoice_HCN_Plus);
				click(driver, Vendor_Invoice_HCN_Plus);
				twoColumnSearchWindow(driver, Hlg_SumNo_Header, Two_Column_Search_Condition, Hlg_SumNo_Value);
				
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {

				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

				if(IsElementEnabled(driver, FDR_POD)) {
					waitForElement(driver, FDR_POD);
					click(driver,FDR_POD);
					twoColumnSearchWindow(driver, Discharge_Terminal_Header, Two_Column_Search_Condition, Discharge_Terminal_Value);
				}
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
			
			
		}else if (ActivityType.equalsIgnoreCase("STC")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);
			}else if (Activity_SelectionType.equalsIgnoreCase("STC Sum No")) {
				waitForElement(driver, stc_Sum_No_Plus_Button);
				click(driver, stc_Sum_No_Plus_Button);
				twoColumnSearchWindow(driver, STC_Report_No_Header, Two_Column_Search_Condition, STC_Sum_No);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
			
			
		}else if (ActivityType.equalsIgnoreCase("STP")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);
			}else if (Activity_SelectionType.equalsIgnoreCase("STP No")) {
				waitForElement(driver, stp_Number_Search_button_VIR);
				click(driver, stp_Number_Search_button_VIR);
				twoColumnSearchWindow(driver, STP_No_Header, Two_Column_Search_Condition, STP_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
			
			
		}else if (ActivityType.equalsIgnoreCase("BNK")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);
			}else if (Activity_SelectionType.equalsIgnoreCase("BRQ No")) {
				
				waitForElement(driver, BBQ_Grid_No_Search);
				click(driver, BBQ_Grid_No_Search);
				twoColumnSearchWindow(driver, BRQ_No_Header, Two_Column_Search_Condition, BRQ_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {

				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
			
				
		}else if (ActivityType.equalsIgnoreCase("CHP")) {
			
			 if (Activity_SelectionType.equalsIgnoreCase("Bill No")) {
				waitForElement(driver, VHP_Bill_num_search);
				click(driver, VHP_Bill_num_search);
				twoColumnSearchWindow(driver, Bill_Number_Header_CHP, Two_Column_Search_Condition, Bill_No_Value_CHP);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
			
			
		}else if (ActivityType.equalsIgnoreCase("EMB")) {
			
			if (Activity_SelectionType.equalsIgnoreCase("Bill No")) {
				waitForElement(driver, VHP_Bill_num_search);
				click(driver, VHP_Bill_num_search);
				twoColumnSearchWindow(driver, Bill_Number_Header_EMB, Two_Column_Search_Condition, Bill_No_Value_EMB);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {

				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
			
			
		}else if (ActivityType.equalsIgnoreCase("CMR")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);
	
			}else if (Activity_SelectionType.equalsIgnoreCase("CMR No")) {
				
				waitForElement(driver, cmr_No_Button);
				click(driver, cmr_No_Button);
				
				waitForElement(driver, cmr_No_search_Button);
				click(driver, cmr_No_search_Button);
				twoColumnSearchWindow(driver, CMR_No_Header, Two_Column_Search_Condition, CMR_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {

				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
			
			if(!DA_Month_Input_CMR.equals("")) {
				waitForElement(driver, cmr_manual_Activity_Month_Dropdown);
				click(driver, cmr_manual_Activity_Month_Dropdown);
				formatLocatorClick(driver, DropDown_Select, DA_Month_Input_CMR);
			}
			
			if(!Activity_Month_CMR.equals("")) {
				waitForElement(driver, cmr_manual_DA_Month_Dropdown);
				click(driver, cmr_manual_DA_Month_Dropdown);
				formatLocatorClick(driver, DropDown_Select, Activity_Month_CMR);
			}
			
		}else if (ActivityType.equalsIgnoreCase("AGY")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);				
			}else if (Activity_SelectionType.equalsIgnoreCase("AGY No")) {
				
				waitForElement(driver, Plus_button_All_VIR);
				click(driver,Plus_button_All_VIR);
				twoColumnSearchWindow(driver, AGY_No_Header, Two_Column_Search_Condition, AGY_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
			
		}else if (ActivityType.equalsIgnoreCase("SOR")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);				
			}else if (Activity_SelectionType.equalsIgnoreCase("SOR No")) {
				waitForElement(driver, sor_No_Search_Button);
				click(driver, sor_No_Search_Button);
				twoColumnSearchWindow(driver, SOR_No_Header, Two_Column_Search_Condition, SOR_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {

				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
			
			if(!DA_Month_Input_SOR.trim().equals("")) {
				waitForElement(driver, sor_DA_Month_Dropdown_Select);
				click(driver, sor_DA_Month_Dropdown_Select);
				formatLocatorClick(driver, DropDown_Select, DA_Month_Input_SOR);
			}

			if(!Activity_Month_SOR.trim().equals("")) {
				waitForElement(driver, sor_Activity_Month);
				click(driver, sor_Activity_Month);
				formatLocatorClick(driver, DropDown_Select, Activity_Month_SOR);
			}
			
		}else if (ActivityType.equalsIgnoreCase("SLO")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);				

			}else if (Activity_SelectionType.equalsIgnoreCase("SLO No")) {
				waitForElement(driver, Plus_button_All_VIR);
				click(driver,Plus_button_All_VIR);
				twoColumnSearchWindow(driver, SLO_No_Header, Two_Column_Search_Condition, SLO_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+ActivityType, test, test1);
			}
		}else {
			System.out.println("InValid Activiyt Type : "+ActivityType);
			Extent_fail(driver, "InValid Activiyt Type : "+ActivityType, test, test1);
		}
		Step_End(12, "Click the '"+Activity_SelectionType+"' and select the Required Values", test, test1);
	
		
		Step_Start(13, "Click the \"+ADD\" button, Details added in the Grid", test, test1);
		waitForElement(driver, Add_Button_All_VIR);
		click(driver,Add_Button_All_VIR);
		
		waitForDisplay(driver, vendor_Gird_add);
		if(isdisplayed(driver, vendor_Gird_add)) {
			Extent_pass_New(driver, "Matched || Expected Result is : Data should be added into gird || Actual Result is : Data  was added into gird", test, test1);
			System.out.println("Matched || Expected Result is : Data should be added into gird || Actual Result is :Data  was added into gird");
		}else {
			System.out.println("Not Matched || Expected Result is : Data should be added into gird || Actual Result is : Data  was not added into gird");
			Extent_fail(driver,"Not Matched || Expected Result is : Data should be added into gird|| Actual Result is : Data  was not added into gird", test, test1);
		}	
		
		if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
			
			waitForElement(driver, invoiceQuantity_Gridcell_VIR);
			doubleClick(driver, invoiceQuantity_Gridcell_VIR);
			
			waitForElement(driver, invoiceQuantity_Input_Gridcell_VIR);
			clearAndType(driver, invoiceQuantity_Input_Gridcell_VIR, Invoice_Quantity_Value);
			enter(driver);
			click(driver, invoiceAmount_Gridcell_VIR);
			
			waitForElement(driver, invoiceAmount_Gridcell_VIR);
			doubleClick(driver, invoiceAmount_Gridcell_VIR);
			
			waitForElement(driver, invoiceAmount_Input_Gridcell_VIR);
			clearAndType(driver, invoiceAmount_Input_Gridcell_VIR, Invoice_Amount_Value);
			enter(driver);
			click(driver, invoiceQuantity_Gridcell_VIR);
		}
		Step_End(13, "Click the \"+ADD\" button, Details added in the Grid", test, test1);

		scrollTop(driver);
		Step_Start(16, "Click the save while in draft", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		List<WebElement> popup_message = listOfElements(driver, popup_Message_Ok_Button);
		if(popup_message.size()>1) {
			waitForElement(driver, popup_Message_Ok_Button);
			jsClick(driver, popup_Message_Ok_Button);
		}
		
		
		waitForPopup(driver, popup_Message, InvoiceSaved_Popup);

		String actual_popupmessage = getText(driver, popup_Message);

		if (actual_popupmessage.equals(InvoiceSaved_Popup)) {

			System.out.println("Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage);
			Extent_pass_New(driver, "Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage, test, test1);
		} else {

			System.out.println("Not Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage);
			Extent_fail(driver, "Not Matched || Expected popup was : " + InvoiceSaved_Popup
					+ " || Actual popup message was : " + actual_popupmessage, test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(16, "Click the save while in draft", test, test1);

		Step_Start(17, "It auto generate the Invoice Reg No", test, test1);

		String invoice_register_no = getAttribute(driver, Vendor_Register_Number_VIR, "value");

		if (!invoice_register_no.isEmpty()) {

			System.out.println(
					"Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No is autogenerated and the generated no was : "
							+ invoice_register_no);
			Extent_pass_New(driver,
					"Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No is autogenerated and the generated no was : "
							+ invoice_register_no,
					test, test1);
		} else {
			System.out.println(
					"Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No was not autogenerated ");
			Extent_fail(driver,
					"Expected result is || After save the data, Invoice Reg No should be autogenerated || Actual result is : After save the data, Invoice Reg No was not autogenerated ",
					test, test1);

		}

		Step_End(17, "It auto generate the Invoice Reg No", test, test1);

		Step_Start(18, "Click the edit", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_End(18, "Click the edit", test, test1);
		
		Step_Start(19, "Change the mode Draft to confirm.", test, test1);
		
		waitForElement(driver, Confirmed_button_VIR);
		click(driver, Confirmed_button_VIR);
		
		Step_End(19, "Change the mode Draft to confirm.", test, test1);
		
		Step_Start(20, "The Difference is Zero", test, test1);
		
	   waitForElement(driver, VIR_Diffrent);
	   String Act_Diffrent=getAttribute(driver, VIR_Diffrent,"value");
	   
	   double Actual_Diff = getNumberValue(Act_Diffrent);
	   double Expected_Diff = getNumberValue(Exp_Diffrent);
	    
	   if(Expected_Diff!=Actual_Diff) {
		   waitForElement(driver, Vendor_Invoice_input_VIR);
		   clearAndType(driver, Vendor_Invoice_input_VIR, Act_Diffrent);  
		   click(driver, Vendor_Invoice_input_VIR);
		   waitForElement(driver, Act_Expensive_input_VIR);
		   click(driver, Act_Expensive_input_VIR);
	   }
	  
		Step_Start(21.1, "If value is Y ,It ask to attach the document mandatory", test, test1);
		Step_Start(21.2, "If Value is Document attach is not mandatory", test, test1);
		Step_Start(21.3, "Click the save button while in confirm.", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message, Attach_popup);

		String Act_Attach_pop = getText(driver, popup_Message);
		
		
		if(value.equalsIgnoreCase("N")) {
			
			if (Updated_Popup.equals(Act_Attach_pop)) {

				System.out.println("Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Attach_pop);
				Extent_pass_New(driver, "Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Attach_pop, test, test1);
			} else {

				System.out.println("Not Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Attach_pop);
				Extent_fail(driver, "Not Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Attach_pop, test, test1);

			}
			
		}else if (value.equalsIgnoreCase("Y")){
			
			if (Attach_popup.equals(Act_Attach_pop)) {

				System.out.println("Matched || Expected popup was : " + Attach_popup+ " || Actual popup message was : " + Act_Attach_pop);
				Extent_pass_New(driver, "Matched || Expected popup was : " + Attach_popup+ " || Actual popup message was : " + Act_Attach_pop, test, test1);
			} else {

				System.out.println("Not Matched || Expected popup was : " + Attach_popup+ " || Actual popup message was : " + Act_Attach_pop);
				Extent_fail(driver, "Not Matched || Expected popup was : " + Attach_popup+ " || Actual popup message was : " + Act_Attach_pop, test, test1);

			}
			
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		Step_End(21.3, "Click the save button while in confirm.", test, test1);
		Step_End(21.2, "If Value is Document attach is not mandatory", test, test1);
		Step_End(21.1, "If value is Y ,It ask to attach the document mandatory", test, test1);
		

		
		Extent_completed(testCaseName, test, test1);	

}
}