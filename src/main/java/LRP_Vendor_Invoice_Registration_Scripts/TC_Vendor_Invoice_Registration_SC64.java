package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Invoice_Registration_SC64 extends Keywords{

	public void Vendor_Invoice_Registration_SC64(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Vendor_Invoice_Registration_SC64";
		//  Get data from excel sheet	
	

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String agencyCode = Excel_data.get("AgencyCode");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String vendorCode = Excel_data.get("VendorCode");
		String Vendor_Invoice_No_Char = Excel_data.get("Vendor_Invoice_No_Char");
		String activityType = Excel_data.get("ActivityType");
		String condition = Excel_data.get("Condition");
		String invoiceSaved_Popup = Excel_data.get("InvoiceSaved_Popup");
		String Inv_Registration_Date = Excel_data.get("Inv_Registration_Date");
		String Inv_Receiving_Date = Excel_data.get("Inv_Receiving_Date");
		String Inv_Date = Excel_data.get("Inv_Date");
		String datePicker = Excel_data.get("datePicker");
		String Inv_Amount = Excel_data.get("Inv_Amount");
		String invoice_ROE = Excel_data.get("invoice_ROE");
		String Payment_method = Excel_data.get("Payment_method");
		String invoice_currency = Excel_data.get("Invoice_currency");
		String Home_ROE = Excel_data.get("Home_ROE");
		String Activity_Input = Excel_data.get("Activity_Input");
		String DA_Month_Input = Excel_data.get("DA_Month_Input");
		String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
		String Invoice_Report_Header = Excel_data.get("Invoice_Report_Header");
		String Invoice_Report_Module = Excel_data.get("Invoice_Report_Module");
		String MNR_No_Value = Excel_data.get("MNR_No_Value");
		String MNR_No_Header = Excel_data.get("MNR_No_Header");
		String Grid_value = Excel_data.get("Grid_value");

		String Factor_payee_Input = Excel_data.get("Factor_payee_Input");
		String Factor_payee_search = Excel_data.get("Factor_payee_search");
		String Disbusse_currency = Excel_data.get("Disbusse_currency");

		
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
		Step_Start(3, "It shows the approved vendor based on the vendor master", test, test1);

		Step_End(2, "Click the Vendor code search button", test, test1);
		Step_Start(4, "Select the Required vendor code and name", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");
		Step_End(4, "Select the Required vendor code and name", test, test1);

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
		sendKeys(driver, Vendor_Invoice_Number_Input_VIR, Vendor_Invoice_No_Char);
		Step_End(6, "Enter the value up to 25 characters", test, test1);

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

		Step_Start(7, "Click the Disburse currency dropdown", test, test1);

		if(!Disbusse_currency.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
			Step_End(7, "Click the Disburse currency dropdown", test, test1);

			Step_Start(8, "Select the Require currency", test, test1);
			formatLocatorClick(driver, DropDown_Select, Disbusse_currency);

			Step_End(8, "Select the Require currency", test, test1);

		}
		Step_Start(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);
		Step_Start(10, "Payment method is auto fetch from vendor master based on the Payment method", test, test1);

		if(!Payment_method.trim().equalsIgnoreCase("")) {
			waitForElement(driver, Vendorinvoice_Payment_method_dd_VIR);
			click(driver, Vendorinvoice_Payment_method_dd_VIR);
			formatLocatorClick(driver, DropDown_Select, Payment_method);


		}
		Step_End(10, "Payment method is auto fetch from vendor master based on the Payment method", test, test1);

		Step_End(9, "Payment mode is auto fetch from vendor master based on the Type of vendor", test, test1);



		if(!Home_ROE.trim().equalsIgnoreCase("")) {
			waitForElement(driver, home_ROE_Textfield_VIR);
			clearAndType(driver, home_ROE_Textfield_VIR, Home_ROE);
		}		

		Step_Start(11, "In the Activity details, Click Activity type dropdown and select the activity type as a CMR", test, test1);
		waitForElement(driver, Vendor_activity_type);
		click(driver, Vendor_activity_type);
		formatLocatorClick(driver, DropDown_Select, activityType);
		
		Step_End(11, "In the Activity details, Click Activity type dropdown and select the activity type as a CMR", test, test1);

		waitForElement(driver, cmr_No_Button);
		click(driver, cmr_No_Button);
		
		Step_Start(12, "Click the CMR no search and select the Required no", test, test1);
		waitForElement(driver, cmr_No_search_Button);
		click(driver, cmr_No_search_Button);
		
		twoColumnSearchWindow(driver, MNR_No_Header, condition, MNR_No_Value);
		Step_End(12, "Click the CMR no search and select the Required no", test, test1);
		
		Step_Start(13, "Select the DA month ,It based on the DA master setup", test, test1);
		if(!DA_Month_Input.trim().equals("")) {
			waitForElement(driver, cmr_manual_Activity_Month_Dropdown);
			click(driver, cmr_manual_Activity_Month_Dropdown);
			formatLocatorClick(driver, DropDown_Select, DA_Month_Input);
		}
		Step_End(13, "Select the DA month ,It based on the DA master setup", test, test1);
		
		Step_Start(14, "Select the Activity Month", test, test1);
		if(!Activity_Input.trim().equals("")) {
			waitForElement(driver, cmr_manual_DA_Month_Dropdown);
			click(driver, cmr_manual_DA_Month_Dropdown);
			formatLocatorClick(driver, DropDown_Select, Activity_Input);
		}
		
		Step_End(14, "Select the Activity Month", test, test1);
		
		
		Step_Start(15, "Click the \"+ADD\" button, Details added in the Grid", test, test1);
		waitForElement(driver, sor_No_Add_Button);
		click(driver, sor_No_Add_Button);
		
		Step_End(15, "Click the \"+ADD\" button, Details added in the Grid", test, test1);
		
		reArrangeAG_GridColumns(driver, Grid_value);

        List<Map<String, String>> Table_Data = extractTableDataByColumnWithoutScroll(driver, sor_No_Table);	
        String ActivityNo_Value = getFirstValueByHeader(Table_Data, "Activity No");     
        String DA_Month_Value = getFirstValueByHeader(Table_Data, "DA/Activity Month"); 
        String [] DA_Month_Values=DA_Month_Value.split("-");
        String DA_Month_VIR=DA_Month_Values[0];
        String DA_Year_VIR=DA_Month_Values[1];
        System.out.println("ActivityNo_Value  :"+ ActivityNo_Value);
        System.out.println("DA Month : "+DA_Month_VIR);
        System.out.println("DA_Year_VIR : "+DA_Year_VIR);
        scrollTop(driver);

		Step_Start(16, "Click the save", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		Step_Start(16, "Click the save", test, test1);
		
		List<WebElement> popup_message = listOfElements(driver, popup_Message_Ok_Button);
		if(popup_message.size()>1) {
			waitForElement(driver, popup_Message_Ok_Button);
			jsClick(driver, popup_Message_Ok_Button);
		}
		
		waitForPopup(driver, popup_Message, invoiceSaved_Popup);
		String actualPopup=getText(driver, popup_Message);
		
		if(actualPopup.trim().equals(invoiceSaved_Popup)) {
			System.out.println("Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
			Extent_pass(driver, "Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
		}else {
			System.out.println("Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup : "+invoiceSaved_Popup+" || Actual Popup : "+actualPopup, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		
		Step_End(17, "It auto generate the Invoice Reg No", test, test1);
		
		waitForElement(driver, invoice_Reg_No_Textfield_VIR);
		String actual_Vendor_Reg_No=getAttribute(driver, invoice_Reg_No_Textfield_VIR, "value");
		System.out.println("Generarted Vendor Reg No : "+actual_Vendor_Reg_No);
		if(!actual_Vendor_Reg_No.trim().equals("")) {
			System.out.println("Passed || Expected Result is : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No);
			Extent_pass(driver, "Passed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No, test, test1);
		}else {
			System.out.println("Failed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is not generated || generated Vendor Reg No is : "+actual_Vendor_Reg_No);
			Extent_fail(driver, "Failed || Expected Result is  : Vendor Reg No should be generated || Actual Result is  : Vendor Reg No is not generated || generated Vendor Reg No  is : "+actual_Vendor_Reg_No, test, test1);
		}
		
		Step_End(17, "It auto generate the Invoice Reg No", test, test1);
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		moduleNavigate(driver, Invoice_Report_Module);
		
		waitForElement(driver, billing_Period_IR);
		click(driver,billing_Period_IR);
		
		DA_Month_VIR=getFullMonthName(DA_Month_VIR);
		formatLocatorClick(driver, DropDown_Select, DA_Month_VIR);
		
		waitForElement(driver, Billing_Period_Year_Input_IR);
		String yearValue=getAttribute(driver, Billing_Period_Year_Input_IR, "value");
		int Year_Act=Integer.parseInt(yearValue);
		int Year_Exp=Integer.parseInt(DA_Year_VIR);
		click(driver,Billing_Period_Year_Input_IR);
		Actions action=new Actions(driver);
		if(Year_Exp>Year_Act) {
			while(Year_Act==Year_Exp) {
				action.sendKeys(Keys.UP).build().perform();
				waitForDisplay(driver, Billing_Period_Year_Input_IR);
				yearValue=getAttribute(driver, Billing_Period_Year_Input_IR, "value");
				Year_Act=Integer.parseInt(yearValue);
			}
		}else if(Year_Exp<Year_Act) {
			while(Year_Act==Year_Exp) {
				action.sendKeys(Keys.DOWN).build().perform();
				waitForDisplay(driver, Billing_Period_Year_Input_IR);
				yearValue=getAttribute(driver, Billing_Period_Year_Input_IR, "value");
				Year_Act=Integer.parseInt(yearValue);
			}
		}
		
		waitForElement(driver, show_Button_IR);	
		click(driver, show_Button_IR);
	
		waitForElement(driver, MoreOption_Grid_V2);
		click(driver,MoreOption_Grid_V2);
		
		waitForElement(driver, FilterOption_Menu_V2);
		click(driver,FilterOption_Menu_V2);
		
		waitForElement(driver, AG_Grid_Columns_Button_DW);
		click(driver,AG_Grid_Columns_Button_DW);
		waitForElement(driver, AG_Grid_Column_All_Select_Checkbox_DW);
		click(driver, AG_Grid_Column_All_Select_Checkbox_DW);
		String actualStatus = getAttribute(driver, AG_Grid_Column_All_Select_Checkbox_DW, "class");
		if (actualStatus.contains("checked")) {
			click(driver, AG_Grid_Column_All_Select_Checkbox_DW);
		}
		
		List<String> columns = splitAndExpand(Invoice_Report_Header, ",");
		for (String column : columns) {
			waitForElement(driver, AG_Grid_Column_Searchbox_DW);
			Newclear(driver, AG_Grid_Column_Searchbox_DW);
			sendKeys(driver, AG_Grid_Column_Searchbox_DW, column);
			formatLocatorClick(driver, Select_Column_tableHead, column);
		}
	
		waitForElement(driver, Vendor_Code_Filter_Input_IR);
		Newclear(driver, Vendor_Code_Filter_Input_IR);
		sendKeys(driver, Vendor_Code_Filter_Input_IR, vendorCode);
		
		waitForElement(driver, report_Table);
		List<Map<String, String>> Table_Data1 = extractTableDataByColumnWithoutScroll(driver, report_Table);	
		String Line_Invoice_Ref_Value = getFirstValueByHeader(Table_Data1, "Line-Invoice Ref. No.");              
		System.out.println("Line_Invoice_Ref_Value :"+ Line_Invoice_Ref_Value);
   
		if(ActivityNo_Value.trim().equals(Line_Invoice_Ref_Value)) {
			System.out.println("Matched || Expected Activity No :" +ActivityNo_Value + " || Actual Ref No :" + Line_Invoice_Ref_Value);
			Extent_pass(driver, "Matched || Expected Activity No :" +ActivityNo_Value + " || Actual Ref No :" + Line_Invoice_Ref_Value, test, test1);
		}else {
			System.out.println("Not Matched || Expected Activity No :" +ActivityNo_Value + " || Actual Ref No :" + Line_Invoice_Ref_Value);
			extent_fail(driver, "Not Matched || Expected Activity No :" +ActivityNo_Value + " || Actual Ref No :" + Line_Invoice_Ref_Value, test, test1);
		}
		Extent_completed(testCaseName, test, test1);
		
		
	}
}
