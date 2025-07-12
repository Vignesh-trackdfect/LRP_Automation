package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Invoice_Registration_SC23  extends Keywords{
	
	public void Vendor_Invoice_Registration_SC23(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Vendor_Invoice_Registration_SC23";
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

		
			Extent_Start(testCaseName, test, test1);
			navigateUrl(driver, url);

			// Login
			
			LRP_Login(driver, username, password);
			verifyMainMenu(driver);
			SwitchProfile(driver, agencyCode);

//			Vendor Invoice Registration
			
			Step_Start(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);
			
			moduleNavigate(driver, moduleName);

			Step_End(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);
			Step_Start(2, "Click the Vendor code search button", test, test1);

			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver, Vedor_Code_Search_Button_VIR);
			Step_End(2, "Click the Vendor code search button", test, test1);
			Step_Start(3, "It shows the approved vendor based on the vendor master", test, test1);
		   Step_Start(4, "Select the Required vendor code and name", test, test1);
			
			globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
		
			Step_End(2, "Select the required Vendor code.", test, test1);
			Step_End(3, "It shows the approved vendor based on the vendor master", test, test1);
            Step_End(4, "Select the Required vendor code and name", test, test1);

            
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
				if(!Factor_payee_Input.trim().equals("")) {
					waitForElement(driver, factor_Payee_SearchButton_VIR);
					click(driver, factor_Payee_SearchButton_VIR);
					twoColumnSearchWindow(driver, Factor_payee_search, condition, Factor_payee_Input);
				}
		
		// Vendor invoice number
				Step_Start(5, "Click the Vendor invoice field", test, test1);

			waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
            Step_End(5, "Click the Vendor invoice field", test, test1);
            Step_Start(6, "Enter the value up to 25 characters", test, test1);
			sendKeys(driver, Vendor_Invoice_Number_Input_VIR, vendorInvoiceNumber);
			Step_End(6, "Enter the value up to 25 characters", test, test1);


			
				
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
				
				Step_Start(7, "Click the Disburse currency dropdown", test, test1);

				if(!Disbusse_currency.trim().equalsIgnoreCase("")) {
					waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
					click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
					Step_End(7, "Click the Disburse currency dropdown", test, test1);
					
					Step_Start(8, "Select the Require currency", test, test1);
					String invoice_select =  String.format(DropDown_Select, Disbusse_currency); 
					click(driver, invoice_select);
					Step_End(8, "Select the Require currency", test, test1);
					
					}
				Step_Start(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
	               Step_Start(10, "Payment method is auto fetch from vendor master based on the Payment method", test, test1);

				if(!Payment_method.trim().equalsIgnoreCase("")) {
					waitForElement(driver, Vendorinvoice_Payment_method_dd_VIR);
					click(driver, Vendorinvoice_Payment_method_dd_VIR);
					formatLocatorClick(driver, DropDown_Select, Payment_method);
					
					
					}

				Step_End(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
				
			Step_End(10, "Payment method is auto fetch from vendor master based on the Payment method", test, test1);
               if(!Home_ROE.trim().equalsIgnoreCase("")) {
					waitForElement(driver, home_ROE_Textfield_VIR);
					clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
					}
               
              Step_Start(11, "In the Activity details, Click Activity type dropdown and select the activity type as a \"STC\"", test, test1); 
               
			waitForElement(driver, Vendor_activity_type);
			click(driver, Vendor_activity_type);

			String select_ActivityType=String.format(DropDown_Select, activityType);
			waitForElement(driver, select_ActivityType);
			click(driver, select_ActivityType);
			Step_End(11, "In the Activity details, Click Activity type dropdown and select the activity type as a \"STC\"", test, test1);
			
			Step_Start(12, "Select the Manual activity", test, test1);
			waitForElement(driver, stc_Manual_Activity_Button_VIR);
			click(driver, stc_Manual_Activity_Button_VIR);
			Step_End(12, "Select the Manual activity", test, test1);
			
			Step_Start(13, "Click the Main activity and select the Required activity", test, test1);
			waitForElement(driver, stc_Main_Activity_Search_Button);
			click(driver, stc_Main_Activity_Search_Button);
			
			twoColumnSearchWindow(driver, main_Activity_Header, condition, mainActivity);
			Step_End(13, "Click the Main activity and select the Required activity", test, test1);

			Step_Start(14, "Click the Sub activity\"+\" and select the Required Activity", test, test1);
			waitForElement(driver, stc_Sub_Activity_Plus_Button_VIR);
			click(driver, stc_Sub_Activity_Plus_Button_VIR);
			
			twoColumnSearchWindow(driver, sub_Activity_Header, condition, subActivity_Code);
			Step_End(14, "Click the Sub activity\"+\" and select the Required Activity", test, test1);
			
			Step_Start(15, "Click the Eqp Type search and select the Required Eqp Type", test, test1);
			waitForElement(driver, stc_Eqp_Type_Search_Button_VIR);
			click(driver, stc_Eqp_Type_Search_Button_VIR);
			
			twoColumnSearchWindow(driver, equipment_Type_Header, condition, Equipment_Type);

			Step_End(15, "Click the Eqp Type search and select the Required Eqp Type", test, test1);
		Step_Start(16, "Click the Port code search and select the Required POL Port code", test, test1);
			waitForElement(driver, stc_Ports_Search_Button_VIR);
			click(driver, stc_Ports_Search_Button_VIR);
			
			twoColumnSearchWindow(driver, Port_Header, condition, Port_Code);
			Step_End(16, "Click the Port code search and select the Required POL Port code", test, test1);

			Step_Start(17, "Click the \"+ADD\" button, Details added in the Grid", test, test1);

			waitForElement(driver, stc_Manual_Activity_Add_Button);
			click(driver, stc_Manual_Activity_Add_Button);
			
			Step_End(17, "Click the \"+ADD\" button, Details added in the Grid", test, test1);
			Step_Start(18, "Here the invoice quantity and invoice amount based on Main activity code and Sub activity code.", test, test1);

			scrollTop(driver);
			reArrangeAG_GridColumns(driver, AG_Grid_Column_Headers);
			
			waitForDisplay(driver, manualActivity_Table_Gridcell_VIR);
			if(isdisplayed(driver, manualActivity_Table_Gridcell_VIR)) {
				System.out.println("Matched || Expected Result is : Records should be added into the AG grid || Actual Result is  : Records are added into the AG grid");
				Extent_pass_New(driver, "Matched || Expected Result is  : Records should be added into the AG grid || Actual Result is  : Records are added into the AG grid", test, test1);
			}else {
				System.out.println("Not Matched || Expected Result is  : Records should be added into the AG grid || Actual Result is  : Records are added not into the AG grid");
				Extent_fail(driver, "Not Matched || Expected Result is  : Records should be added into the AG grid || Actual Result is  : Records are added not into the AG grid", test, test1);
			}
			

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
			
			scrollTop(driver);

			Step_End(18, "Here the invoice quantity and invoice amount based on Main activity code and Sub activity code.", test, test1);
			Step_Start(19, "Click the save", test, test1);
			
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			Step_Start(19, "Click the save", test, test1);
			
			
			
			List<WebElement> popup_message = listOfElements(driver, popup_Message_Ok_Button);
			if(popup_message.size()>1) {
				waitForElement(driver, popup_Message_Ok_Button);
				jsClick(driver, popup_Message_Ok_Button);
			}
			
			waitForPopup(driver, popup_Message, invoiceSaved_Popup);
			String actualPopup=getText(driver, popup_Message);
			
			if(actualPopup.trim().equals(invoiceSaved_Popup)) {
				System.out.println("Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
				Extent_pass_New(driver, "Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
				Extent_fail(driver, "Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
			}
			
			click(driver, popup_Message_Ok_Button);
			
			
			Step_End(20, "It auto generate the Invoice Reg No", test, test1);
			
			waitForElement(driver, invoice_Reg_No_Textfield_VIR);
			String actual_Vendor_Reg_No=getAttribute(driver, invoice_Reg_No_Textfield_VIR, "value");
			System.out.println("Generarted Vendor Reg No : "+actual_Vendor_Reg_No);
			if(!actual_Vendor_Reg_No.trim().equals("")) {
				System.out.println("Passed || Expected Result is : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No);
				Extent_pass_New(driver, "Passed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No, test, test1);
			}else {
				System.out.println("Failed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is not generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No);
				Extent_fail(driver, "Failed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is not generated || generated Vendor Reg No  is : "+actual_Vendor_Reg_No, test, test1);
			}
			
			Step_End(20, "It auto generate the Invoice Reg No", test, test1);
			Extent_completed(testCaseName, test, test1);
			
	}
}
