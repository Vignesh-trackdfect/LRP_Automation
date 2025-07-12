package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC63 extends Keywords {

	public void Vendor_Invoice_Registration_SC63(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Vendor_Invoice_Registration_SC63";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String agencyCode = Excel_data.get("AgencyCode");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
		String vendorCode = Excel_data.get("VendorCode");
		String vendorInvoiceNumber = Excel_data.get("VendorInvoiceNumber");
		String activityType = Excel_data.get("ActivityType");
		String condition = Excel_data.get("Condition");
		String Treasury_ROE_Module = Excel_data.get("Treasury_ROE_Module");
		String ROE_Date_Header = Excel_data.get("ROE_Date_Header");
		String Inv_Amount = Excel_data.get("Inv_Amount");
		String invoice_ROE = Excel_data.get("invoice_ROE");
		String invoice_currency = Excel_data.get("Invoice_currency");
		String costConfiguration_Module = Excel_data.get("CostConfiguration_Module");
		String cost_Attribute = Excel_data.get("Cost_Attribute");
		String value = Excel_data.get("Value");
		String Filter_Headers = Excel_data.get("Filter_Headers");
		String Disburse_currency = Excel_data.get("Disburse_currency");
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");//NEW
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

// Login

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		Step_Start(1, "Need to switch the require agency", test, test1);

		SwitchProfile(driver, agencyCode);

		Step_End(1, "Need to switch the require agency", test, test1);

//			Vendor Invoice Registration

		Step_Start(2, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

		moduleNavigate(driver, moduleName);

		Step_End(2, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

		Step_Start(3, "Click the Vendor code search button", test, test1);

		waitForElement(driver, Vedor_Code_Search_Button_VIR);
		click(driver, Vedor_Code_Search_Button_VIR);

		Step_End(3, "Click the Vendor code search button", test, test1);
		Step_Start(4, "It shows the approved vendor based on the vendor master.", test, test1);
		Step_Start(5, "Select the Required vendor code and name.", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");

		Step_End(4, "It shows the approved vendor based on the vendor master.", test, test1);
		Step_End(5, "Select the Required vendor code and name.", test, test1);

		if (!invoice_currency.trim().equalsIgnoreCase("")) 
		{
		waitForElement(driver, invoiceCurrency_Dropdown_VIR);
		click(driver, invoiceCurrency_Dropdown_VIR);
		
		
		String newloc = String.format(DropDown_Select, invoice_currency);
		VerticalScroll_Visible(driver, newloc, verticalscroll);
		formatLocatorClick(driver, DropDown_Select, invoice_currency);

		}
		waitForElement(driver, Invoice_Currency_Field_VIR);
		String InvoiceCurrency = getText(driver, Invoice_Currency_Field_VIR);
		
		Step_Start(6, "Click the Vendor invoice field.", test, test1);

		
		
		// Vendor invoice number
		waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
		click(driver, Vendor_Invoice_Number_Input_VIR);

		Step_End(6, "Click the Vendor invoice field.", test, test1);
		Step_Start(7, "Enter the value up to 25 characters.", test, test1);

		sendKeys(driver, Vendor_Invoice_Number_Input_VIR, vendorInvoiceNumber);

		Step_End(7, "Enter the value up to 25 characters.", test, test1);
		
		

		if (!Inv_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_Inv_Amount_VIR);
			clearAndType(driver, Vendor_Inv_Amount_VIR, Inv_Amount);
		}

		if (!invoice_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_ROE_Input_VIR);
			clearAndType(driver, Vendorinvoice_ROE_Input_VIR, invoice_ROE);
		}

	// multiple Activity added
		
		waitForElement(driver, Vendor_activity_type);
		click(driver, Vendor_activity_type);
		formatLocatorClick(driver, DropDown_Select, activityType);
		
		waitForElement(driver, Vendorinvoice_ROE_Input_VIR);
		
		String RouteTypeBtn=String.format(ActivityType_Radiobutton_VIR, Activity_SelectionType);
		waitForElement(driver, RouteTypeBtn);
		click(driver,RouteTypeBtn);
		
		if(activityType.equalsIgnoreCase("CAR")) {
			
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
				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
			}
		}else if (activityType.equalsIgnoreCase("ACR")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);
			
			}else if (Activity_SelectionType.equalsIgnoreCase("ACR No")) {
				waitForElement(driver, ACR_No_SearchButton_VIR);
				click(driver, ACR_No_SearchButton_VIR);
				twoColumnSearchWindow(driver, ACR_No_Header, Two_Column_Search_Condition, ACR_No_Input);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
			}
			
		}else if (activityType.equalsIgnoreCase("FDR")) {
			
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
				
				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

				if(IsElementEnabled(driver, FDR_POD)) {
					waitForElement(driver, FDR_POD);
					click(driver,FDR_POD);
					twoColumnSearchWindow(driver, Discharge_Terminal_Header, Two_Column_Search_Condition, Discharge_Terminal_Value);
				}
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
			}
		}else if (activityType.equalsIgnoreCase("HCN")) {
			
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

				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

				if(IsElementEnabled(driver, FDR_POD)) {
					waitForElement(driver, FDR_POD);
					click(driver,FDR_POD);
					twoColumnSearchWindow(driver, Discharge_Terminal_Header, Two_Column_Search_Condition, Discharge_Terminal_Value);
				}
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
			}
			
			
		}else if (activityType.equalsIgnoreCase("STC")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);
			}else if (Activity_SelectionType.equalsIgnoreCase("STC Sum No")) {
				waitForElement(driver, stc_Sum_No_Plus_Button);
				click(driver, stc_Sum_No_Plus_Button);
				twoColumnSearchWindow(driver, STC_Report_No_Header, Two_Column_Search_Condition, STC_Sum_No);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
			}
			
			
		}else if (activityType.equalsIgnoreCase("STP")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);
			}else if (Activity_SelectionType.equalsIgnoreCase("STP No")) {
				waitForElement(driver, stp_Number_Search_button_VIR);
				click(driver, stp_Number_Search_button_VIR);
				twoColumnSearchWindow(driver, STP_No_Header, Two_Column_Search_Condition, STP_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
			}
			
			
		}else if (activityType.equalsIgnoreCase("BNK")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);
			}else if (Activity_SelectionType.equalsIgnoreCase("BRQ No")) {
				
				waitForElement(driver, BBQ_Grid_No_Search);
				click(driver, BBQ_Grid_No_Search);
				twoColumnSearchWindow(driver, BRQ_No_Header, Two_Column_Search_Condition, BRQ_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {

				Select_Manual_Activity_VIR(driver, DA_Month_Input_SOR, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
			}
			
				
		}else if (activityType.equalsIgnoreCase("CHP")) {
			
			 if (Activity_SelectionType.equalsIgnoreCase("Bill No")) {
				waitForElement(driver, VHP_Bill_num_search);
				click(driver, VHP_Bill_num_search);
				twoColumnSearchWindow(driver, Bill_Number_Header_CHP, Two_Column_Search_Condition, Bill_No_Value_CHP);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
			}
			
			
		}else if (activityType.equalsIgnoreCase("EMB")) {
			
			if (Activity_SelectionType.equalsIgnoreCase("Bill No")) {
				waitForElement(driver, VHP_Bill_num_search);
				click(driver, VHP_Bill_num_search);
				twoColumnSearchWindow(driver, Bill_Number_Header_EMB, Two_Column_Search_Condition, Bill_No_Value_EMB);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {

				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
			}
			
			
		}else if (activityType.equalsIgnoreCase("CMR")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);
	
			}else if (Activity_SelectionType.equalsIgnoreCase("CMR No")) {
				
				waitForElement(driver, cmr_No_Button);
				click(driver, cmr_No_Button);
				
				waitForElement(driver, cmr_No_search_Button);
				click(driver, cmr_No_search_Button);
				twoColumnSearchWindow(driver, CMR_No_Header, Two_Column_Search_Condition, CMR_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {

				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
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
			
		}else if (activityType.equalsIgnoreCase("AGY")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);				
			}else if (Activity_SelectionType.equalsIgnoreCase("AGY No")) {
				
				waitForElement(driver, Plus_button_All_VIR);
				click(driver,Plus_button_All_VIR);
				twoColumnSearchWindow(driver, AGY_No_Header, Two_Column_Search_Condition, AGY_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
			}
			
		}else if (activityType.equalsIgnoreCase("SOR")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);				
			}else if (Activity_SelectionType.equalsIgnoreCase("SOR No")) {
				waitForElement(driver, sor_No_Search_Button);
				click(driver, sor_No_Search_Button);
				twoColumnSearchWindow(driver, SOR_No_Header, Two_Column_Search_Condition, SOR_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {

				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);
				
			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
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
			
		}else if (activityType.equalsIgnoreCase("SLO")) {
			
			if(Activity_SelectionType.equalsIgnoreCase("Route")) {
				Select_Routing_VendorInvoice(driver, Two_Column_Search_Condition, Service_Code_Header, Service_Code_Value, Vessel_Code_Header, Vessel_Code_Value, Voyage_Code_Header, Voyage_Code_Value, Port_Code_Header, Port_Code_Value, Terminal_Code_Header, Terminal_Code_Value);				

			}else if (Activity_SelectionType.equalsIgnoreCase("SLO No")) {
				waitForElement(driver, Plus_button_All_VIR);
				click(driver,Plus_button_All_VIR);
				twoColumnSearchWindow(driver, SLO_No_Header, Two_Column_Search_Condition, SLO_No_Value);
				
			}else if (Activity_SelectionType.equalsIgnoreCase("Manual Activity")) {
				
				Select_Manual_Activity_VIR(driver, Two_Column_Search_Condition, Main_Activity_Header, Main_Activity_Value, Sub_Activity_Header, Sub_Activity_Value, Equipment_Type_Header, Equipment_Type_Value, Equipment_Status_Value, Port_Code_Header, Port_Code_Value);

			}else {
				System.out.println("InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType);
				Extent_fail(driver, "InValid Selection Type  : "+Activity_SelectionType+"  for the Activity Type: "+activityType, test, test1);
			}
		}else {
			System.out.println("InValid Activiyt Type : "+activityType);
			Extent_fail(driver, "InValid Activiyt Type : "+activityType, test, test1);
		}
		
		
		

		waitForElement(driver, Add_Button_VIR);
		click(driver, Add_Button_VIR);

		waitForElement(driver, VIR_Grid_Table);

		reArrangeAG_GridColumns(driver, Filter_Headers);
				
		waitForDisplay(driver, Activity_Table_Gridcell_VIR);
		if (isdisplayed(driver, Activity_Table_Gridcell_VIR)) {
			System.out.println(
					"Matched || Expected : Records should be added into the AG grid || Actual : Records are added into the AG grid");
			Extent_pass(driver,
					"Matched || Expected : Records should be added into the AG grid || Actual : Records are added into the AG grid",
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected : Records should be added into the AG grid || Actual : Records are not added into the AG grid");
			Extent_fail(driver,
					"Not Matched || Expected : Records should be added into the AG grid || Actual : Records are not added into the AG grid",
					test, test1);
		}

		waitForElement(driver, AG_Grid_Table_VIR);
		List<Map<String, String>> VIR_AG_Grid_Data = extractTableDataByColumn(driver, AG_Grid_Table_VIR);
		
		String StatuValues = getFirstRowValueByHeaderFromTableData(VIR_AG_Grid_Data, "Act Date");
		System.out.println("The ACT Date is :  " + StatuValues);
	
		
		Step_Start(8, "Click the Disburse currency dropdown", test, test1);
		Step_Start(9, "It auto fetch the currency and we need Select the Require currency.", test, test1);

		

		if (!Disburse_currency.trim().equalsIgnoreCase("")) 
		{
		waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
		click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
		
		
		String newloc = String.format(DropDown_Select, Disburse_currency);
		VerticalScroll_Visible(driver, newloc, verticalscroll);
		formatLocatorClick(driver, DropDown_Select, Disburse_currency);

		}
		
		Step_End(8, "Click the Disburse currency dropdown", test, test1);
		Step_End(9, "It auto fetch the currency and we need Select the Require currency.", test, test1);

		
		waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
		String DisbursementCurrency = getText(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
		
		waitForElement(driver, Inv_Registration_Date_VIR);
		waitForElement(driver, vendor_Inv_Date_VIR);
		String invoiceDate = getAttribute(driver, Inv_Registration_Date_VIR, "value");
		waitForElement(driver, home_ROE_Textfield_VIR);
		String roeHomeTextFieldValue = getAttribute(driver, Vendorinvoice_Disbusement_ROE_Input_VIR, "value");
		waitForElement(driver, Vendorinvoice_Disbusement_ROE_Input_VIR);
		String roeInvoiceTextFieldValue = getAttribute(driver, Vendorinvoice_ROE_Input_VIR, "value");
		String actual_ActivityDate = StatuValues.replace("/", "-");
		String actual_InvoiceDate = invoiceDate.replace("/", "-");
		
		Step_Start(10, "Based on the VEX configuration", test, test1);

		moduleNavigate(driver, costConfiguration_Module);

		SetCostConfiguration(driver, cost_Attribute, value);

		moduleNavigate(driver, Treasury_ROE_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		if (value.trim().equalsIgnoreCase("I")) {
			twoColumnSearchWindow(driver, ROE_Date_Header, condition, actual_InvoiceDate);
		} else {
			twoColumnSearchWindow(driver, ROE_Date_Header, condition, actual_ActivityDate);
		}
		waitForElement(driver, TreasuryRoe_Column_Headers);
		List<Map<String, String>> ROE_TableData = getTableData(driver, TreasuryRoe_Column_Headers,
				TreasuryRoe_Column_Rows);
		
		Step_End(10, "Based on the VEX configuration", test, test1);

		Step_Start(10.1, "If the value is I,It take the Invoice date ROE", test, test1);
		Step_Start(10.2, "If the value is A,It take the Invoice date ROE", test, test1);
		
		String disbursementValue = getValueByFirstColumnAndHeader(ROE_TableData, "Currency Code", DisbursementCurrency,
				"Rate Of Exchange");
		
		String CurrecnyValue = getValueByFirstColumnAndHeader(ROE_TableData, "Currency Code", InvoiceCurrency,
				"Rate Of Exchange");
		String Invoice_Currency_Value = getValueByFirstColumnAndHeader(ROE_TableData, "Currency Code", DisbursementCurrency,
				"Rate Of Exchange");
		double actual_DisbursementValue = ConvertNumberValue(disbursementValue);
		double actual_CurrecnyValue = ConvertNumberValue(CurrecnyValue);
		System.out.println("actual_CurrecnyValue is :"+actual_CurrecnyValue);
		double actual_InvoiceValue = ConvertNumberValue(Invoice_Currency_Value);
		System.out.println("actual_InvoiceValue is :"+actual_InvoiceValue);
		
		double Actual_value = actual_DisbursementValue / actual_CurrecnyValue;
		System.out.println(Actual_value);
		double Excepted_roeHomeTextFieldValue = getNumberValue1(roeHomeTextFieldValue);
		System.out.println("Excepted_roeHomeTextFieldValue is :"+Excepted_roeHomeTextFieldValue);
		double Excepted_roeInvoiceTextFieldValue = getNumberValue1(roeInvoiceTextFieldValue);
		System.out.println("Excepted_roeInvoiceTextFieldValue is :"+Excepted_roeInvoiceTextFieldValue);
		
		double Actual_Value = roundToSameDecimals(Excepted_roeHomeTextFieldValue,Actual_value);  
		
		System.out.println("The value we get is :"+Actual_Value);

		if (value.trim().equalsIgnoreCase("I")) {
			if (Double.compare(Excepted_roeHomeTextFieldValue, Actual_Value) == 0) {
				System.out.println("Matched || The Expected Treasury ROE Value is : "+Excepted_roeHomeTextFieldValue+" || The Actual Vendor Invoice Registration Invoice ROE value is : "+Actual_Value);
			Extent_pass_New(driver, "Matched || The Expected Treasury ROE Value is : "+Excepted_roeHomeTextFieldValue+" || The Actual Vendor Invoice Registration Invoice ROE value is : "+Actual_Value, test, test1);
			}
			else {
				System.out.println("Not Matched || The Expected Treasury ROE Value is : "+Excepted_roeHomeTextFieldValue+" || The Actual Vendor Invoice Registration Invoice ROE value is : "+Actual_Value);
				Extent_fail(driver, "Not Matched || The Expected Treasury ROE Value is : "+Excepted_roeHomeTextFieldValue+" || The Actual Vendor Invoice Registration Invoice ROE value is : "+Actual_Value, test, test1);
				
			}
		} else if(value.trim().equalsIgnoreCase("A")) {
			if (Double.compare(Excepted_roeHomeTextFieldValue, Actual_Value) == 0) {
				System.out.println("Matched || The Expected Treasury ROE Value is : "+Excepted_roeHomeTextFieldValue+" || The Actual Vendor Invoice Registration Home ROE value is : "+Actual_Value);
				Extent_pass_New(driver, "Matched || The Expected Treasury ROE Value is : "+Excepted_roeHomeTextFieldValue+" || The Actual Vendor Invoice Registration Home ROE value is : "+Actual_Value, test, test1);
			}else {
				System.out.println("Not Matched || The Expected Treasury ROE Value is : "+Excepted_roeHomeTextFieldValue+" || The Actual Vendor Invoice Registration Home ROE value is : "+Actual_Value);
				Extent_fail(driver, "Not Matched || The Expected Treasury ROE Value is : "+Excepted_roeHomeTextFieldValue+" || The Actual Vendor Invoice Registration Home ROE value is : "+Actual_Value, test, test1);
					
			}
		}
		Step_End(10.1, "If the value is I,It take the Invoice date ROE", test, test1);
		Step_End(10.2, "If the value is A,It take the Invoice date ROE", test, test1);
		
		
		Extent_completed(testCaseName, test, test1);
	}

}
