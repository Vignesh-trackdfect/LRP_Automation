package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC52 extends Keywords{
public void Vendor_Invoice_Registration_SC52(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
	
		
		String testCaseName = "TC_Vendor_Invoice_Registration_SC52";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String Invoice_Number = Excel_data.get("Invoice_Number");
		String Exp_popup = Excel_data.get("Exp_popup");
		String Credit_Exp_popup = Excel_data.get("Credit_Exp_popup");
		String Debit_Exp_popup = Excel_data.get("Debit_Exp_popup");
		String Disbursement_Exp_pop = Excel_data.get("Disbursement_Exp_pop");
		String agencyCode = Excel_data.get("AgencyCode");
		String costConfiguration_Module = Excel_data.get("CostConfiguration_Module");
		String cost_Attribute = Excel_data.get("cost_Attribute");
		String Value_Yes = Excel_data.get("Value_Yes");
		String Value_No = Excel_data.get("Value_No");
		String Updated_Popup = Excel_data.get("Updated_Popup");
		

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		Step_Start(1, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);
		
		Step_Start(7, "It based on the ING configuration,Inthe Cost configration,It change the INVOICE REG NO", test, test1);
		SwitchProfile(driver, agencyCode);

		
		moduleNavigate(driver, costConfiguration_Module);

		SetCostConfiguration(driver, cost_Attribute, Value_Yes);
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		Step_End(7, "It based on the ING configuration,Inthe Cost configration,It change the INVOICE REG NO", test, test1);
		moduleNavigate(driver, moduleName);
		
		Step_End(1, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);
		
		Step_Start(2, "Click the global search ", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		Step_End(2, "Click the global search ", test, test1);
		
		Step_Start(3, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);
		Step_Start(4, "Select the Confirmed Invoice no", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, Invoice_Number, "", "", "", "");
		
		Step_End(4, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);
		Step_End(3, "Select the Confirmed Invoice no", test, test1);
		
	
		Step_Start(5, "Click Invoice Reverse ,It show \" Invoice status reversed\"", test, test1);
		Step_Start(6, "It will happen,When the Disbursement or Credit Or debit Can't done ", test, test1);
	
		waitForElement(driver, VIR_Invoice_Reverse);
		click(driver, VIR_Invoice_Reverse);
		
        waitForPopup(driver, popup_Message, Exp_popup);
		String Act_popup =getText(driver, popup_Message);
		
         if(Exp_popup.equals(Act_popup)) {
			
			System.out.println("Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup);
			Extent_pass(driver, "Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup, test, test1);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
			
			
		}else if(Credit_Exp_popup.equals(Act_popup)) {
			System.out.println("Not Matched || Expected popup was : " + Credit_Exp_popup+ " || Actual popup message was : " + Act_popup);
			Extent_FailNew(driver, "Not Matched || Expected popup was : " + Credit_Exp_popup+ " || Actual popup message was : " + Act_popup, test, test1);
			
		}else if(Debit_Exp_popup.equals(Act_popup)) {
			System.out.println("Not Matched || Expected popup was : " + Debit_Exp_popup+ " || Actual popup message was : " + Act_popup);
			Extent_FailNew(driver, "Not Matched || Expected popup was : " + Debit_Exp_popup+ " || Actual popup message was : " + Act_popup, test, test1);
			
		}else if(Disbursement_Exp_pop.equals(Act_popup)){
			System.out.println("Matched || Expected popup was : " + Disbursement_Exp_pop+ " || Actual popup message was : " + Act_popup);
			Extent_FailNew(driver, "Matched || Expected popup was : " + Disbursement_Exp_pop+ " || Actual popup message was : " + Act_popup, test, test1);
		}else  {
			System.out.println("Not Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup);
			Extent_fail(driver, "Not Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup, test, test1);
		}
         
		Step_End(6, "It will happen,When the Disbursement or Credit Or debit Can't done ", test, test1);	
		Step_End(5, "Click Invoice Reverse ,It show \" Invoice status reversed\"", test, test1);
		
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver, Vendor_Register_Number_VIR);
		String Act_Invoice_Ref_Number =getAttribute(driver, Vendor_Register_Number_VIR,"value");
		
		waitForElement(driver, Confirmed_button_VIR);
		click(driver, Confirmed_button_VIR);
		
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Updated_Popup);	
		String Act_Update_popup =getText(driver, popup_Message);
		
		if(Updated_Popup.equals(Act_Update_popup)) {
			System.out.println("Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Update_popup);
			Extent_pass(driver, "Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Update_popup, test, test1);
			
		}else {
			System.out.println("Not Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Update_popup);
			Extent_fail(driver, "Not Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Update_popup, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		waitForElement(driver, Vendor_Register_Number_VIR);
		String Act_Invoice_Ref_Number_value =getAttribute(driver, Vendor_Register_Number_VIR,"value");
			
		Step_Start(7.1, "While the ING ,Value Is \"Y\" ,After reverse and confirm means,It change the Invoice no.", test, test1);
		
		if(!Act_Invoice_Ref_Number.equals(Act_Invoice_Ref_Number_value)) {
			System.out.println("Matched || Expected result : If the cost configuration 'ING' attribute values is 'Y' before and after confirming the value should be Not same  : Before confirm the invoice Reg no is : "+Act_Invoice_Ref_Number +" || After confim the Invoice reg no is : "+Act_Invoice_Ref_Number_value);
			Extent_pass(driver, "Matched || Expected result : If the cost configuration 'ING' attribute values is 'Y' before and after confirming the value should be Not same  : Before confirm the invoice Reg no is : "+Act_Invoice_Ref_Number +" || After confim the Invoice reg no is : "+Act_Invoice_Ref_Number_value, test, test1);
		}else {
			System.out.println("Not Matched || Expected result : If the cost configuration 'ING' attribute values is 'Y' before and after confirming the value should be Not same  : Before confirm the invoice Reg no is : "+Act_Invoice_Ref_Number +" || After confim the Invoice reg no is : "+Act_Invoice_Ref_Number_value);
			Extent_fail(driver, "Not Matched || Expected result : If the cost configuration 'ING' attribute values is 'Y' before and after confirming the value should be Not same  : Before confirm the invoice Reg no is : "+Act_Invoice_Ref_Number +" || After confim the Invoice reg no is : "+Act_Invoice_Ref_Number_value, test, test1);
		}
		
		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		moduleNavigate(driver, costConfiguration_Module);
		
		SetCostConfiguration(driver, cost_Attribute, Value_No);
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		moduleNavigate(driver, moduleName);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, Act_Invoice_Ref_Number_value, "", "", "", "");
		
		waitForElement(driver, VIR_Invoice_Reverse);
		click(driver, VIR_Invoice_Reverse);
		
        waitForPopup(driver, popup_Message, Exp_popup);
		
		Act_popup =getText(driver, popup_Message);
		
         if(Exp_popup.equals(Act_popup)) {
			
			System.out.println("Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup);
			Extent_pass(driver, "Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup, test, test1);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
		}
		else  {
			System.out.println("Not Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup);
			Extent_fail(driver, "Not Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup, test, test1);
		}
		
		Step_End(6, "It will happen,When the Disbursement or Credit Or debit Can't done ", test, test1);	
		Step_End(5, "Click Invoice Reverse ,It show \" Invoice status reversed\"", test, test1);
		
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
					
		waitForElement(driver, Vendor_Register_Number_VIR);
		Act_Invoice_Ref_Number_value=getAttribute(driver, Vendor_Register_Number_VIR,"value");
		waitForElement(driver, Confirmed_button_VIR);
		click(driver, Confirmed_button_VIR);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Updated_Popup);	
		Act_Update_popup =getText(driver, popup_Message);
		
		if(Updated_Popup.equals(Act_Update_popup)) {
			System.out.println("Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Update_popup);
			Extent_pass(driver, "Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Update_popup, test, test1);
			
		}else {
			System.out.println("Not Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Update_popup);
			Extent_fail(driver, "Not Matched || Expected popup was : " + Updated_Popup+ " || Actual popup message was : " + Act_Update_popup, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		waitForElement(driver, Vendor_Register_Number_VIR);
		String Act_Invoice_Ref_Number_value1 =getAttribute(driver, Vendor_Register_Number_VIR,"value");
		
		if(Act_Invoice_Ref_Number_value.equals(Act_Invoice_Ref_Number_value1)) {
			System.out.println("Matched || Expected result : If the cost configuration 'ING' attribute values is 'N' before and after confirming the value should be same  : Before confirm the invoice Reg no is : "+Act_Invoice_Ref_Number_value +" || After confim the Invoice reg no is : "+Act_Invoice_Ref_Number_value1);
			Extent_pass(driver, "Matched || Expected result : If the cost configuration 'ING' attribute values is 'N' before and after confirming the value should be same  : Before confirm the invoice Reg no is : "+Act_Invoice_Ref_Number_value +" || After confim the Invoice reg no is : "+Act_Invoice_Ref_Number_value1, test, test1);
		}else {
			System.out.println("Not Matched || Expected result : If the cost configuration 'ING' attribute values is 'N' before and after confirming the value should be same  : Before confirm the invoice Reg no is : "+Act_Invoice_Ref_Number_value +" || After confim the Invoice reg no is : "+Act_Invoice_Ref_Number_value1);
			Extent_fail(driver, "Not Matched || Expected result : If the cost configuration 'ING' attribute values is 'N' before and after confirming the value should be same  : Before confirm the invoice Reg no is : "+Act_Invoice_Ref_Number_value +" || After confim the Invoice reg no is : "+Act_Invoice_Ref_Number_value1, test, test1);
		}
		
		Extent_completed(testCaseName, test, test1);	
		

}

}
