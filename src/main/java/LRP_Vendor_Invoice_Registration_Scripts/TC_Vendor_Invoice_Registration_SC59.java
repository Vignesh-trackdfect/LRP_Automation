package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Invoice_Registration_SC59 extends Keywords{
	
	public void Vendor_Invoice_Registration_SC59(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Vendor_Invoice_Registration_SC59";
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
			String condition = Excel_data.get("Condition");
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
			String invoiceUpdated_Popup = Excel_data.get("InvoiceUpdated_Popup");
			String AG_Grid_Column_Headers = Excel_data.get("AG_Grid_Column_Headers");
			String CAR_No_Header = Excel_data.get("CAR_No_Header");
			String CAR_No_Input = Excel_data.get("CAR_No_Input");
			String refNo_Values = Excel_data.get("RefNo_Values");
			String status_Of_Route_RadioButton = Excel_data.get("Status_Of_Route_RadioButton");
			String RadioButtonDescription = Excel_data.get("RadioButtonDescription");
			String CAR_module = Excel_data.get("CAR_module");
			String searchBy_CAR = Excel_data.get("SearchBy_CAR");
			String confirmed_Mode = Excel_data.get("Confirmed_Mode");		
			String costConfiguration_Module = Excel_data.get("CostConfiguration_Module");
			String cost_Attribute = Excel_data.get("Cost_Attribute");
			String value = Excel_data.get("Value");
			String default_Value = Excel_data.get("Default_Value");
			String Grid_header = Excel_data.get("Grid_header");
						
			Extent_Start(testCaseName, test, test1);
			navigateUrl(driver, url);

			// Login
			
			Step_Start(1, "Once login the application,select the required agency.", test, test1);

			LRP_Login(driver, username, password);
			verifyMainMenu(driver);
			
			SwitchProfile(driver, agencyCode);
			
			Step_End(1, "Once login the application,select the required agency.", test, test1);

//		CAR 
			
			moduleNavigate(driver, CAR_module);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition, searchBy_CAR, CAR_No_Input, "", "", "", "");

			waitForDisplay(driver, CAR_Closed_Label);
			if(!isdisplayed(driver, CAR_Closed_Label)) {
				System.out.println("Matched || Expected : CAR No should be opened || Actual : CAR No is opend");
				Extent_pass_New(driver, "Matched || Expected : CAR No should be opened || Actual : CAR No is opend", test, test1);
			}else {
				System.out.println("Not Matched || Expected : CAR No should be opened || Actual : CAR No is closed");
				Extent_fail(driver, "Not Matched || Expected : CAR No should be opened || Actual : CAR No is closed", test, test1);
			}
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
//		Cost Config
			
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
			jsClick(driver, SaveButton_ToolBar);
			
			waitForElement(driver, Close_Current_tab);
			jsClick(driver, Close_Current_tab);
			
			
//			Vendor Invoice Registration
			
			Step_Start(2, "Enter the module name as 'Vendor Invoice Registration' in the search.", test, test1);
			
			moduleNavigate(driver, moduleName);

			Step_End(2, "Enter the module name as 'Vendor Invoice Registration' in the search.", test, test1);
			Step_Start(3, "Select the required Vendor code.", test, test1);

			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver, Vedor_Code_Search_Button_VIR);
			
			globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
		
			Step_End(3, "Select the required Vendor code.", test, test1);
			
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
				
				Step_Start(4, "Enter the Paper Invoice no. at Vendor Invoice No. field.", test, test1);

		// Vendor invoice number		
			waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
			sendKeys(driver, Vendor_Invoice_Number_Input_VIR, vendorInvoiceNumber);
			
			Step_End(4, "Enter the Paper Invoice no. at Vendor Invoice No. field.", test, test1);
	
				if(!Inv_Amount.trim().equalsIgnoreCase("")) {
				waitForElement(driver, Vendor_Inv_Amount_VIR);
				clearAndType(driver, Vendor_Inv_Amount_VIR, Inv_Amount);
				}
				
				if(!invoice_currency.trim().equalsIgnoreCase("")) {
				waitForElement(driver, invoiceCurrency_Dropdown_VIR);
				click(driver, invoiceCurrency_Dropdown_VIR);
				
				formatLocatorClick(driver, DropDown_Select, invoice_currency);
				
				}
				
				
				if(!invoice_ROE.trim().equalsIgnoreCase("")) {
					waitForElement(driver, Vendorinvoice_ROE_Input_VIR);
					clearAndType(driver, Vendorinvoice_ROE_Input_VIR, invoice_ROE);
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
				
				if(!Home_ROE.trim().equalsIgnoreCase("")) {
					waitForElement(driver, home_ROE_Textfield_VIR);
					clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
					}
				

			Step_Start(5, "Select the CAR NO", test, test1);
			
			waitForElement(driver, Vendor_activity_type);
			click(driver, Vendor_activity_type);

			formatLocatorClick(driver, DropDown_Select, activityType);

			waitForElement(driver, vendor_Contract_Typedd);
			click(driver, vendor_Contract_Typedd);

			
			formatLocatorClick(driver, DropDown_Select, contractType);

			String actualDescription=String.format(ActivityType_Radiobutton_VIR, RadioButtonDescription);
			waitForElement(driver, actualDescription);
			
			String actualStatus=getAttribute(driver, actualDescription, "class");

			if(!actualStatus.contains(status_Of_Route_RadioButton)) {
				click(driver, actualDescription);
			}
			
			
			Step_End(5, "Select the CAR NO", test, test1);
			Step_Start(6, "Click on the Add button.", test, test1);

			waitForElement(driver, CAR_PLUS_button_VIR);
			click(driver, CAR_PLUS_button_VIR);
			
			twoColumnSearchWindow(driver, CAR_No_Header, condition, CAR_No_Input);


			waitForElement(driver, Add_Button_VIR);
			click(driver, Add_Button_VIR);
			
			Step_End(6, "Click on the Add button.", test, test1);
			Step_Start(7, "Check whether the records are added into the AG grid.", test, test1);

			scrollBottom(driver);
			reArrangeAG_GridColumns(driver, AG_Grid_Column_Headers);
			
			waitForDisplay(driver, Activity_Table_Gridcell_VIR);
			if(isdisplayed(driver, Activity_Table_Gridcell_VIR)) {
				System.out.println("Matched || Expected : Records should be added into the AG grid || Actual : Records are added into the AG grid");
				Extent_pass_New(driver, "Matched || Expected : Records should be added into the AG grid || Actual : Records are added into the AG grid", test, test1);
			}else {
				System.out.println("Not Matched || Expected : Records should be added into the AG grid || Actual : Records are not added into the AG grid");
				Extent_fail(driver, "Not Matched || Expected : Records should be added into the AG grid || Actual : Records are not added into the AG grid", test, test1);
			}
			
			List<String> ref_No_Value=splitAndExpand(refNo_Values);
			
			waitForElement(driver, AG_Grid_Table_VIR);
			List<Map<String, String>> VIR_AG_Grid_Data = extractTableDataByColumn(driver, AG_Grid_Table_VIR);
			
			List<String> RefNo_Values_VIR = getValuesByHeader(VIR_AG_Grid_Data, ref_No_Value.get(0));
			System.out.println("RefNo_Values_VIR : "+RefNo_Values_VIR);
			
			Step_End(7, "Check whether the records are added into the AG grid.", test, test1);
			Step_Start(8, "Copy the Activity No. form the AG grid by referring the Activity No. column", test, test1);

			String activityNo_VIR=getText(driver, activity_No_Gridcell_VIR);
			System.out.println("activityNo_VIR : "+activityNo_VIR);
			
			Step_End(8, "Copy the Activity No. form the AG grid by referring the Activity No. column", test, test1);
			Step_Start(9, "Open the Cost Activity Reporting module by using the module search.", test, test1);

			scrollTop(driver);
			moduleNavigate(driver, CAR_module);
			
			Step_End(9, "Open the Cost Activity Reporting module by using the module search.", test, test1);
			Step_Start(10, "Click on the Global search button,a new tab will open", test, test1);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			Step_End(10, "Click on the Global search button,a new tab will open", test, test1);
			Step_Start(11, "Paste the CAR No. in the CAR No. field and click on the search button", test, test1);
			Step_Start(12, "Our CAR no. will be automatically select in the tab.", test, test1);
			Step_Start(13, "Click on the select button.", test, test1);

			globalValueSearchWindow(driver, dropdownCondition, searchBy_CAR, CAR_No_Input, "", "", "", "");
			
			Step_End(11, "Paste the CAR No. in the CAR No. field and click on the search button", test, test1);
			Step_End(12, "Our CAR no. will be automatically select in the tab.", test, test1);
			Step_End(13, "Click on the select button.", test, test1);
			Step_Start(14, "Click on the Expense report tab.", test, test1);

			waitForElement(driver, Expense_report);
			click(driver, Expense_report);
			
			Step_End(14, "Click on the Expense report tab.", test, test1);
			Step_Start(15, "A new will be open and click on the approved expense button.", test, test1);

			waitForElement(driver, ApprovedExpenses);
			click(driver, ApprovedExpenses);
			
			reArrangeAG_GridColumns_Expense_Report(driver, Grid_header);
			
			waitForElement(driver, expenseReport_FilterIcon_CAR);
			click(driver, expenseReport_FilterIcon_CAR);
			
			
			waitForElement(driver, vendorCode_Filter_CAR);
			sendKeys(driver, vendorCode_Filter_CAR, vendorCode);
			
			Step_End(15, "A new will be open and click on the approved expense button.", test, test1);
			Step_Start(16, "Copy the reference no. in the AG grid for all the records by referring the Reference no. column and also it should not invoiced by referring the Invoice No. column.", test, test1);

 
			
			waitForElement(driver, expense_Table_Ref_No_CAR);
			String RefNo_Values_CAR=getText(driver, expense_Table_Ref_No_CAR);
			System.out.println("RefNo_Values_CAR : "+RefNo_Values_CAR);
			
			
			waitForElement(driver, CAR_Number_Input_CAR);
			String CAR_No=getAttribute(driver, CAR_Number_Input_CAR, "value");
			
			if(CAR_No.contains(activityNo_VIR)) {
				System.out.println("Matched || CAR No in Cost Activity Report module : "+CAR_No+" || Activity No in Vendor Invoice Registration : "+activityNo_VIR);
				Extent_pass_New(driver, "Matched || CAR No in Cost Activity Report module : "+CAR_No+" || Activity No in Vendor Invoice Registration : "+activityNo_VIR, test, test1);
			}else {
				System.out.println("Not Matched || CAR No in Cost Activity Report module : "+CAR_No+" || Activity No in Vendor Invoice Registration : "+activityNo_VIR);
				Extent_fail(driver, "Not Matched || CAR No in Cost Activity Report module : "+CAR_No+" || Activity No in Vendor Invoice Registration : "+activityNo_VIR, test, test1);
			
			}
			
			Step_End(16, "Copy the reference no. in the AG grid for all the records by referring the Reference no. column and also it should not invoiced by referring the Invoice No. column.", test, test1);

			scrollTop(driver);

			Step_Start(15, "Then click on the Vendor invoice registration module.", test, test1);
			Step_Start(17, "Then click on the Vendor invoice registration module.", test, test1);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			Step_End(17, "Then click on the Vendor invoice registration module.", test, test1);
			Step_Start(18, "Check whether the copied reference no. are available in the AG gid,by referring the Activity Ref. No column.", test, test1);

			for(int i=0;i<RefNo_Values_VIR.size();i++) {
				
			if(RefNo_Values_CAR.contains(RefNo_Values_VIR.get(i))) {
				if(i==RefNo_Values_VIR.size()-1) {
				System.out.println("Matched || Ref No in Cost Activity Report module : "+RefNo_Values_CAR+" || Activity Ref No in Vendor Invoice Registration : "+RefNo_Values_VIR);
				Extent_pass_New(driver, "Matched || Ref No in Cost Activity Report module : "+RefNo_Values_CAR+" || Activity Ref No in Vendor Invoice Registration : "+RefNo_Values_VIR, test, test1);
				}
			}else {
				System.out.println("Not Matched || Ref No in Cost Activity Report module : "+RefNo_Values_CAR+" || Activity Ref No in Vendor Invoice Registration : "+RefNo_Values_VIR);
				Extent_fail(driver, "Not Matched || Ref No in Cost Activity Report module : "+RefNo_Values_CAR+" || Activity Ref No in Vendor Invoice Registration : "+RefNo_Values_VIR, test, test1);
			
			}
			}
			Step_End(18, "Check whether the copied reference no. are available in the AG gid,by referring the Activity Ref. No column.", test, test1);
			Step_Start(19, "Click on the save button which is available in the Tool bar.", test, test1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			Step_End(19, "Click on the save button which is available in the Tool bar.", test, test1);
			Step_Start(20, "Check whether the system prompts a message as \"Vendor Invoice saved\".", test, test1);

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
			
			Step_End(20, "Check whether the system prompts a message as \"Vendor Invoice saved\".", test, test1);

			waitForElement(driver, invoice_Reg_No_Textfield_VIR);
			String actual_Vendor_Reg_No=getAttribute(driver, invoice_Reg_No_Textfield_VIR, "value");
			System.out.println("Generarted Vendor Reg No : "+actual_Vendor_Reg_No);
			if(!actual_Vendor_Reg_No.trim().equals("")) {
				System.out.println("Passed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is generated || generated Vendor Reg No : "+actual_Vendor_Reg_No);
				Extent_pass_New(driver, "Passed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is generated || generated Vendor Reg No : "+actual_Vendor_Reg_No, test, test1);
			}else {
				System.out.println("Failed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is not generated || generated Vendor Reg No : "+actual_Vendor_Reg_No);
				Extent_fail(driver, "Failed || Expected : Vendor Reg No should be generated || Actual : Vendor Reg No is not generated || generated Vendor Reg No : "+actual_Vendor_Reg_No, test, test1);
			}
			

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
			waitForElement(driver, Act_Expensive_input_VIR);
			String act_Expense_Amount=getAttribute(driver, Act_Expensive_input_VIR, "value");
			
			waitForElement(driver, Vendor_Invoice_input_VIR);
			clearAndType(driver, Vendor_Invoice_input_VIR, act_Expense_Amount);

			waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
			click(driver, Vendor_Invoice_Number_Input_VIR);
			
			formatLocatorClick(driver, mode_RadioButton_VIR, confirmed_Mode);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message, invoiceUpdated_Popup);
			String actualUpdatedPopup=getText(driver, popup_Message);
			
			if(actualUpdatedPopup.trim().equals(invoiceUpdated_Popup)) {
				System.out.println("Matched || Expected Popup : "+invoiceUpdated_Popup+" || Actual Popup : "+actualUpdatedPopup);
				Extent_pass_New(driver, "Matched || Expected Popup : "+invoiceUpdated_Popup+" || Actual Popup : "+actualUpdatedPopup, test, test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+invoiceUpdated_Popup+" || Actual Popup : "+actualUpdatedPopup);
				Extent_fail(driver, "Not Matched || Expected Popup : "+invoiceUpdated_Popup+" || Actual Popup : "+actualUpdatedPopup, test, test1);
			}
			
			click(driver, popup_Message_Ok_Button);

			

//			CAR 
			Step_Start(21, "Intially the CAR will open,Once save the Invoice ", test, test1);
			Step_Start(22, "It close the car based on the Configration", test, test1);

				moduleNavigate(driver, CAR_module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, dropdownCondition, searchBy_CAR, CAR_No_Input, "", "", "", "");

				waitForDisplay(driver, CAR_Closed_Label);
				if(isdisplayed(driver, CAR_Closed_Label)) {
					System.out.println("Matched || Expected : CAR No should be closed || Actual : CAR No is closed");
					Extent_pass_New(driver, "Matched || Expected : CAR No should be closed || Actual : CAR No is closed", test, test1);
				}else {
					System.out.println("Not Matched || Expected : CAR No should be closed || Actual : CAR No is opened");
					Extent_fail(driver, "Not Matched || Expected : CAR No should be closed || Actual : CAR No is opened", test, test1);
				}
			
				Step_End(21, "Intially the CAR will open,Once save the Invoice ", test, test1);
				Step_End(22, "It close the car based on the Configration", test, test1);

//				Cost Config
					
			moduleNavigate(driver, costConfiguration_Module);
					
					waitForElement(driver, cost_Attribute_Filter_CSO);
					sendKeys(driver, cost_Attribute_Filter_CSO, cost_Attribute);

					waitForElement(driver, retrieved_Attribute_Value_CSO);
					doubleClick(driver, retrieved_Attribute_Value_CSO);
					
					waitForElement(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);
					
					waitForElement(driver, value_Textfield_CSO);
					clearAndType(driver, value_Textfield_CSO, default_Value);

					scrollTop(driver);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);
					
					
			Extent_completed(testCaseName, test, test1);
	}

}
