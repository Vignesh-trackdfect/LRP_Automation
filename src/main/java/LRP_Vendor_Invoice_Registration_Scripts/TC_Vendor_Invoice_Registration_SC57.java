package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


public class TC_Vendor_Invoice_Registration_SC57 extends Keywords{

	public void Vendor_Invoice_Registration_SC57(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Vendor_Invoice_Registration_SC57";
				
		 String username = Excel_data.get("Username");
	        String password = Excel_data.get("Password");
	        String moduleName = Excel_data.get("Module_Name");
	        String AgencyCode = Excel_data.get("AgencyCode");
	        String dropdownCondition =Excel_data.get("DropdownCondition");
			String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
	        String vendorCode = Excel_data.get("VendorCode");
	        String cannot_reverse_expected=Excel_data.get("cannot_reverse_expected");

		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyCode);
		Step_Start(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);
	
		moduleNavigate(driver,moduleName);
		
		Step_Start(2, "Click the global search", test, test1);
		Step_Start(3,"Enter the Vendor invoice Reg no in the Vendor invoice Reg no field", test, test1);
		Step_Start(4,"Select the Confirmed Invoice no.", test, test1);	
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");
		Step_End(2, "Click the global search", test, test1);
		Step_End(3,"Enter the Vendor invoice  no in the Vendor invoice  no field", test, test1);
		Step_End(4,"Select the Confirmed Invoice no.", test, test1);
		
		Step_Start(5,"While Debit note is done in the Vendor debit note screen for the Invoice", test, test1);	
	
	   waitForElement(driver, Vendor_Register_Number_VIR);
	   String Vendor_Register_Act =getAttribute(driver, Vendor_Register_Number_VIR, "value");
	   
	   if(vendorCode.equals(Vendor_Register_Act)) {
			System.out.println("Matched || Expected : Invoice Regiter Number should be display is : "+vendorCode+" || Actual : Invoice Regiter Number is display : "+Vendor_Register_Act);
			Extent_pass_New(driver, "Matched || Expected : Invoice Regiter Number should be display is : "+vendorCode+" || Actual : Invoice Regiter Number is display :"+Vendor_Register_Act, test,test1);
			
		}else {
			System.out.println("Not Matched || Expected  : Invoice Regiter Number should be display is : "+vendorCode+" || Actual : Invoice Regiter Number is display : "+Vendor_Register_Act);
			Extent_fail(driver,  "Not Matched || Expected : Invoice Regiter Number should be display is : "+vendorCode+" || Actual : Invoice Regiter Number is display: "+Vendor_Register_Act, test,test1);
		}
	   Step_End(5,"While Debit note is done in the Vendor debit note screen for the Invoice", test, test1);	
		
	   Step_Start(6,"Click Reverse Invoice .", test, test1);	 
	   
		waitForElement(driver,invoice_reverse);
		click(driver,invoice_reverse);
		
		Step_End(6,"Click Reverse Invoice .", test, test1);
		
		  Step_Start(7,"It show like \"Debit note done cannot able to reverse", test, test1);	
		

		waitForElement(driver,popup_Message_Ok_Button);
		String cannot_reverse_actual =getText(driver,popup_Message);
		
		if(cannot_reverse_expected.equals(cannot_reverse_actual)) {
			System.out.println("Matched || Expected Popup Message is : "+cannot_reverse_expected+" || Actual Popup Message is : "+cannot_reverse_actual);
			Extent_pass_New(driver, "Matched || Expected Popup Message is : "+cannot_reverse_expected+" || Actual Popup Message is : "+cannot_reverse_actual, test,test1);
			click(driver,popup_Message_Ok_Button);
		}else {
			System.out.println("NotMatched || Expected Popup Message is : "+cannot_reverse_expected+" || Actual Popup Message is : "+cannot_reverse_actual);
			Extent_fail(driver,  "NotMatched || Expected Popup Message is : "+cannot_reverse_expected+" || Actual Popup Message is : "+cannot_reverse_actual, test,test1);
		}
			
		Step_End(7,"It show like \"Debit note done cannot able to reverse", test, test1);	
		Extent_completed(testCaseName, test, test1);
		
		
		
	}
}
