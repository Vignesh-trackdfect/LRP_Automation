package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC15 extends Keywords{
	
	public void Vendor_Invoice_Registration_SC15(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Vendor_Invoice_Registration_SC15";
		//  Get data from excel sheet	
			
	        String username = Excel_data.get("Username");
	        String password = Excel_data.get("Password");
	        String moduleName = Excel_data.get("Module_Name");
	        String agencyCode = Excel_data.get("AgencyCode");

	        String dropdownCondition = Excel_data.get("DropdownCondition");
			String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
			String vendorCode = Excel_data.get("VendorCode");
			String vendorInvoiceNumber = Excel_data.get("VendorInvoiceNumber");
			String activityType = Excel_data.get("ActivityType");
			String contractType = Excel_data.get("ContractType");
			String mainActivity = Excel_data.get("MainActivity_Code");
			String condition = Excel_data.get("Condition");
			String main_Activity_Header = Excel_data.get("Main_Activity_Header");
			
			String subActivity_Code = Excel_data.get("SubActivity_Code");
			String sub_Activity_Header = Excel_data.get("Sub_Activity_Header");
			String Equipment_Type = Excel_data.get("Equipment_Type");
			String equipment_Type_Header = Excel_data.get("Equipment_Type_Header");
			String Port_Header = Excel_data.get("Port_Header");
			String Port_Code = Excel_data.get("Port_Code");
			String AG_Grid_Column_Headers = Excel_data.get("AG_Grid_Column_Headers");
			String invoiceQuantity = Excel_data.get("InvoiceQuantity");
			String invoiceAmount = Excel_data.get("InvoiceAmount");
			String invoiceSaved_Popup = Excel_data.get("InvoiceSaved_Popup");

			String Inv_Registration_Date = Excel_data.get("Inv_Registration_Date");
			String Inv_Receiving_Date = Excel_data.get("Inv_Receiving_Date");
			String Inv_Date = Excel_data.get("Inv_Date");
			String datePicker = Excel_data.get("datePicker");

			String Factor_payee_search = Excel_data.get("Factor_payee_search");
			String Factor_payee_Input = Excel_data.get("Factor_payee_Input");
			String Inv_Amount = Excel_data.get("Inv_Amount");
			String Disbusse_currency = Excel_data.get("Disbusse_currency");
			String invoice_ROE = Excel_data.get("invoice_ROE");
			String Payment_method = Excel_data.get("Payment_method");
			String invoice_currency = Excel_data.get("Invoice_currency");
			String Home_ROE = Excel_data.get("Home_ROE");

		
			navigateUrl(driver, url);
			
			Extent_Start(testCaseName, test, test1);

			// Login
			
			Step_Start(1, "Once login the application,select the required agency.", test, test1);

			LRP_Login(driver, username, password);
			verifyMainMenu(driver);
			
			SwitchProfile(driver, agencyCode);
			
			Step_End(1, "Once login the application,select the required agency.", test, test1);

//			Vendor Invoice Registration
			
			Step_Start(2, "Enter the module name as 'Vendor Invoice Registration' in the search.", test, test1);
			
			moduleNavigate(driver, moduleName);

			Step_End(2, "Enter the module name as 'Vendor Invoice Registration' in the search.", test, test1);
			Step_Start(3, "Select the required Vendor code.", test, test1);

			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver, Vedor_Code_Search_Button_VIR);
			
			globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
		
			Step_End(3, "Select the required Vendor code.", test, test1);
			Step_Start(4, "Enter the Paper Invoice no. at Vendor Invoice No. field.", test, test1);
			
			if(!Inv_Registration_Date.equalsIgnoreCase("")) {
				waitForElement(driver, Inv_Registration_Date_VIR);
				if (datePicker.equalsIgnoreCase("Yes")) {
					waitForElement(driver, Inv_Registration_Date_VIR);
					selectDatePicker(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);
			
				} else {
					waitForElement(driver, Inv_Registration_Date_VIR);
					clearAndType(driver, Inv_Registration_Date_VIR, Inv_Registration_Date);
				}
			}
			if(!Inv_Receiving_Date.trim().equalsIgnoreCase("")) {
				waitForElement(driver, Inv_Receiving_Date_VIR);
				if (datePicker.equalsIgnoreCase("Yes")) {
					waitForElement(driver, Inv_Receiving_Date_VIR);
					selectDatePicker(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);
			
				} else {
					waitForElement(driver, Inv_Receiving_Date_VIR);
					clearAndType(driver, Inv_Receiving_Date_VIR, Inv_Receiving_Date);
			
				}
			}
			if(!Inv_Date.trim().equalsIgnoreCase("")) {
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
				waitForDisplay(driver, factor_Payee_SearchButton_VIR);
				if(isdisplayed(driver, factor_Payee_SearchButton_VIR)) {
					click(driver, factor_Payee_SearchButton_VIR);
					twoColumnSearchWindow(driver, Factor_payee_search, condition, Factor_payee_Input);
				}
			}
				
			// Vendor invoice number		
			waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
			sendKeys(driver, Vendor_Invoice_Number_Input_VIR, vendorInvoiceNumber);
			
			if(!Inv_Amount.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendor_Inv_Amount_VIR);
			clearAndType(driver, Vendor_Inv_Amount_VIR, Inv_Amount);
			}
			
			if(!invoice_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, invoiceCurrency_Dropdown_VIR);
			click(driver, invoiceCurrency_Dropdown_VIR);
			
			String invoiceCurrency_select =  String.format(DropDown_Select, invoice_currency); 
			click(driver, invoiceCurrency_select);
			
			}
			
			
			if(!invoice_ROE.trim().equalsIgnoreCase("")) {
				waitForElement(driver, Vendorinvoice_ROE_Input_VIR);
				clearAndType(driver, Vendorinvoice_ROE_Input_VIR, invoice_ROE);
			}
			

			if(!Disbusse_currency.trim().equalsIgnoreCase("")) {
				waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
				click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
				
				String invoice_select =  String.format(DropDown_Select, Disbusse_currency); 
				click(driver, invoice_select);
				
			}
			
			if(!Payment_method.trim().equalsIgnoreCase("")) {
				waitForElement(driver, Vendorinvoice_Payment_method_dd_VIR);
				click(driver, Vendorinvoice_Payment_method_dd_VIR);
				formatLocatorClick(driver, DropDown_Select, Payment_method);
				
				
			}
			
			if(!Home_ROE.trim().equalsIgnoreCase("")) {
				waitForElement(driver, home_ROE_Textfield_VIR);
				clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
			}
			

			Step_End(4, "Enter the Paper Invoice no. at Vendor Invoice No. field.", test, test1);
			Step_Start(5, "Select the Manual activity option and change the contract type as PTC.", test, test1);
			
			waitForElement(driver, Vendor_activity_type);
			click(driver, Vendor_activity_type);

			String select_ActivityType=String.format(DropDown_Select, activityType);
			waitForElement(driver, select_ActivityType);
			click(driver, select_ActivityType);
			
			waitForElement(driver, vendor_Contract_Typedd);
			click(driver, vendor_Contract_Typedd);

			String select_ContractType=String.format(DropDown_Select, contractType);
			waitForElement(driver, select_ContractType);
			click(driver, select_ContractType);
			
			waitForElement(driver, Manual_Activity_Button_VIR);
			click(driver, Manual_Activity_Button_VIR);
			
			Step_End(5, "Select the Manual activity option and change the contract type as PTC.", test, test1);
			Step_Start(6, "Select the required Main activity, Sub activity, Equipment type, Equipment status and Port.", test, test1);

			waitForElement(driver, mainActivity_Searchbutton_VIR);
			click(driver, mainActivity_Searchbutton_VIR);
			
			twoColumnSearchWindow(driver, main_Activity_Header, condition, mainActivity);
			
			waitForElement(driver, subActivity_Addbutton_VIR);
			click(driver, subActivity_Addbutton_VIR);
			
			twoColumnSearchWindow(driver, sub_Activity_Header, condition, subActivity_Code);

			waitForElement(driver, eqp_Type_SearchButton_VIR);
			click(driver, eqp_Type_SearchButton_VIR);
			
			twoColumnSearchWindow(driver, equipment_Type_Header, condition, Equipment_Type);

			waitForElement(driver, port_SearchButton_Manual_VIR);
			click(driver, port_SearchButton_Manual_VIR);
			
			twoColumnSearchWindow(driver, Port_Header, condition, Port_Code);

			Step_End(6, "Select the required Main activity, Sub activity, Equipment type, Equipment status and Port.", test, test1);
			Step_Start(7, "Click on the Add button.", test, test1);

			waitForElement(driver, add_Button_ManualActivity_VIR);
			click(driver, add_Button_ManualActivity_VIR);
			
			Step_End(7, "Click on the Add button.", test, test1);
			Step_Start(8, "Check whether the records are added into the AG grid.", test, test1);

			scrollBottom(driver);
			reArrangeAG_GridColumns(driver, AG_Grid_Column_Headers);
			
			waitForDisplay(driver, manualActivity_Table_Gridcell_VIR);
			if(isdisplayed(driver, manualActivity_Table_Gridcell_VIR)) {
				System.out.println("Matched || Expected : Records should be added into the AG grid || Actual : Records are added into the AG grid");
				Extent_pass_New(driver, "Matched || Expected : Records should be added into the AG grid || Actual : Records are added into the AG grid", test, test1);
			}else {
				System.out.println("Not Matched || Expected : Records should be added into the AG grid || Actual : Records are not added into the AG grid");
				Extent_fail(driver, "Not Matched || Expected : Records should be added into the AG grid || Actual : Records are not added into the AG grid", test, test1);
			}
			
			Step_End(8, "Check whether the records are added into the AG grid.", test, test1);
			Step_Start(9, "Enter the required Invoice quantity and Invoice amount for the records available in AG grid and here the quantity and amount are based on Main activity code and Sub activity code.", test, test1);

			waitForElement(driver, invoiceQuantity_Gridcell_VIR);
			doubleClick(driver, invoiceQuantity_Gridcell_VIR);
			
			waitForElement(driver, invoiceQuantity_Input_Gridcell_VIR);
			clearAndType(driver, invoiceQuantity_Input_Gridcell_VIR, invoiceQuantity);
			enter(driver);
			
			waitForElement(driver, invoiceAmount_Gridcell_VIR);
			doubleClick(driver, invoiceAmount_Gridcell_VIR);
			
			waitForElement(driver, invoiceAmount_Input_Gridcell_VIR);
			clearAndType(driver, invoiceAmount_Input_Gridcell_VIR, invoiceAmount);
			enter(driver);
			

			Step_End(9, "Enter the required Invoice quantity and Invoice amount for the records available in AG grid and here the quantity and amount are based on Main activity code and Sub activity code.", test, test1);
			Step_Start(10, "Click on the save button which is available in the Tool bar.", test, test1);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			Step_End(10, "Click on the save button which is available in the Tool bar.", test, test1);
			Step_Start(11, "Check whether the system prompts a message as 'Vendor Invoice saved'.", test, test1);
			
			waitForPopup(driver, popup_Message, invoiceSaved_Popup);
			String actualPopup=getText(driver, popup_Message);
			
			if(actualPopup.equals(invoiceSaved_Popup)) {
				System.out.println("Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
				Extent_pass_New(driver, "Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
				Extent_fail(driver, "Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
			}
			
			click(driver, popup_Message_Ok_Button);
			
			
			Step_End(11, "Check whether the system prompts a message as 'Vendor Invoice saved'.", test, test1);
			
			waitForElement(driver, invoice_Reg_No_Textfield_VIR);
			String actual_Vendor_Reg_No=getAttribute(driver, invoice_Reg_No_Textfield_VIR, "value");
			System.out.println("Generarted Vendor Reg No : "+actual_Vendor_Reg_No);
			if(!actual_Vendor_Reg_No.equals("")) {
				System.out.println("Passed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is generated || generated Vendor Reg No : "+actual_Vendor_Reg_No);
				Extent_pass_New(driver, "Passed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is generated || generated Vendor Reg No : "+actual_Vendor_Reg_No, test, test1);
			}else {
				System.out.println("Failed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is not generated || generated Vendor Reg No : "+actual_Vendor_Reg_No);
				Extent_fail(driver, "Failed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is not generated || generated Vendor Reg No : "+actual_Vendor_Reg_No, test, test1);
			}

			Extent_completed(testCaseName, test, test1);
	}

}
