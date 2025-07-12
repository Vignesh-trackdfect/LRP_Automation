package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC54 extends Keywords{
public void Vendor_Invoice_Registration_SC54(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
	
		
		String testCaseName = "TC_Vendor_Invoice_Registration_SC54";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String vendorCode = Excel_data.get("VendorCode");
		String Filter_Headers = Excel_data.get("Filter_Headers");
		String Disbursement_module = Excel_data.get("Disbursement_module");
		String SearchBy_Disbursement = Excel_data.get("SearchBy_Disbursement");
		

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		
		Step_Start(1, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);
		
		moduleNavigate(driver, moduleName);
		
		Step_End(1, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);
		
		Step_Start(2, "Click the global search ", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		Step_End(2, "Click the global search ", test, test1);
		
		Step_Start(3, "Enter the Vendor invoice Reg no in the Vendor invoice Reg no field.", test, test1);
		Step_Start(4, "Select the Confirmed Invoice no.", test, test1);
		
		globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
		
		Step_End(4, "Select the Confirmed Invoice no.", test, test1);
		Step_End(3, "Enter the Vendor invoice Reg no in the Vendor invoice Reg no field.", test, test1);
		
		Step_Start(5, "Disbursement done for the Invoice in the Dsibursement screen", test, test1);	
		
		reArrangeAG_GridColumns(driver, Filter_Headers);
		
		waitForElement(driver, FDR_Disbursement_No);
		String Exp_value =getText(driver, FDR_Disbursement_No);
		
		
		Step_End(5, "Disbursement done for the Invoice in the Dsibursement screen", test, test1);	
		
		Step_Start(6, "Disbursement no should show in the Activity details grid", test, test1);	
		
		moduleNavigate(driver, Disbursement_module);
		
		waitForElement(driver, SearchButton_Toolbar);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		
		waitForElement(driver, SearchButton_Toolbar);
		jsClick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition, SearchBy_Disbursement, Exp_value, "", "", "", "");
		
		waitForElement(driver, Disbursement_No);
		String Act_Disbursement_No =getAttribute(driver, Disbursement_No, "value");
		
		if(Exp_value.equals(Act_Disbursement_No)) {
			
			System.out.println("Matched || Expected result : If the Disbursement   values is  before and after confirming the value should be same  : Before confirm the Disbursement no is : "+Exp_value +" || After confim the Disbursement no is : "+Act_Disbursement_No);
			Extent_pass_New(driver,"Matched || Expected result : If the Disbursement   values is  before and after confirming the value should be same  : Before confirm the Disbursement no is : "+Exp_value +" || After confim the Disbursement no is : "+Act_Disbursement_No,test, test1);
		}else {
			System.out.println("Not Matched || Expected result : If the Disbursement   values is  before and after confirming the value should be same  : Before confirm the Disbursement no is : "+Exp_value +" || After confim the Disbursement no is not same : "+Act_Disbursement_No);
			Extent_fail(driver,"Not Matched || Expected result : If the Disbursement   values is  before and after confirming the value should be same  : Before confirm the Disbursement no is : "+Exp_value +" || After confim the Disbursement no is not same : "+Act_Disbursement_No,test, test1);
		}
		
		Step_End(6, "Disbursement no should show in the Activity details grid", test, test1);	
		Extent_completed(testCaseName, test, test1);
		
}
}
