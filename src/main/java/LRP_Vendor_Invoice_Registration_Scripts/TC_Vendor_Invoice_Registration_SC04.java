package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC04 extends Keywords{
	
	public void Vendor_Invoice_Registration_SC04(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Vendor_Invoice_Registration_SC04";
		//  Get data from excel sheet				
			String username = Excel_data.get("Username");
	        String password = Excel_data.get("Password");
	        String moduleName = Excel_data.get("Module_Name");
	        String agencyCode = Excel_data.get("AgencyCode");
	        String dropdownCondition = Excel_data.get("DropdownCondition");
			String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
			String vendorCode = Excel_data.get("VendorCode");
			String Vendor_Master_Module = Excel_data.get("Vendor_Master_Module");
			String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
			String paymentMode_RadioButton_Status = Excel_data.get("PaymentMode_RadioButton_Status");
			String PaymentModes_VIR = Excel_data.get("PaymentModes_VIR");
			String PaymentModes_VM = Excel_data.get("PaymentModes_VM");

			
			Extent_Start(testCaseName, test, test1);
			navigateUrl(driver, url);

			// Login
			
			LRP_Login(driver, username, password);
			verifyMainMenu(driver);
			
			SwitchProfile(driver, agencyCode);
//	Vendor Master
			
			moduleNavigate(driver, Vendor_Master_Module);

			waitForElement(driver, new_Button_VM);
			click(driver, new_Button_VM);

			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");

			List<String>paymentModes_VM=splitAndExpand(PaymentModes_VM);
			List<String>paymentModes_VIR=splitAndExpand(PaymentModes_VIR);

			waitForElement(driver, HQ_RadioButton_VM);
			String status_Of_HQ_RadioButton_VM=getAttribute(driver, HQ_RadioButton_VM, "class");
			String status_Of_Disbursement_RadioButton_VM=getAttribute(driver, Disbursement_RadioButton_VM, "class");

			if(status_Of_HQ_RadioButton_VM.contains(paymentMode_RadioButton_Status)) {
				System.out.println("Expected Result is : HQ Radio button status should be "+ paymentMode_RadioButton_Status + "||  Actual Result is : HQ Radio button status is "+ paymentMode_RadioButton_Status);
				Extent_pass_New(driver, "Expected Result is : HQ Radio button status should be "+ paymentMode_RadioButton_Status + "||  Actual Result is : HQ Radio button status is "+ paymentMode_RadioButton_Status, test, test1);
				status_Of_HQ_RadioButton_VM=paymentMode_RadioButton_Status;
			}
			else if(status_Of_Disbursement_RadioButton_VM.contains(paymentMode_RadioButton_Status)) {
				System.out.println("Expected Result is : Disbursement Radio button status should be "+ paymentMode_RadioButton_Status + "||  Actual Result is : Disbursement Radio button status is "+ paymentMode_RadioButton_Status);
				Extent_pass_New(driver, "Expected Result is : Disbursement Radio button status should be "+ paymentMode_RadioButton_Status + "||  Actual Result is : Disbursement Radio button status is "+ paymentMode_RadioButton_Status, test, test1);
				status_Of_Disbursement_RadioButton_VM=paymentMode_RadioButton_Status;

			}else {
				System.out.println("Expected Result is : Disbursement Radio button status should be "+ paymentMode_RadioButton_Status + "||  Actual Result is : Disbursement Radio button status is not "+ paymentMode_RadioButton_Status);
			    Extent_fail(driver, "Expected Result is : Disbursement Radio button status should be "+ paymentMode_RadioButton_Status + "||  Actual Result is : Disbursement Radio button status is not "+ paymentMode_RadioButton_Status, test, test1);
			}
			
			waitForElement(driver, Paymemnt_Method_VM);
			String Payment_Method_Value=getText(driver, Paymemnt_Method_VM);
			System.out.println("Payment_Method_Value VM :"+Payment_Method_Value);


			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			
			Step_Start(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

//			Vendor Invoice Registration
			
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);
			Step_Start(2, "Click the Vendor code search ", test, test1);

			waitForElement(driver, Vedor_Code_Search_Button_VIR);
			click(driver, Vedor_Code_Search_Button_VIR);
			
			Step_End(2, "Click the Vendor code search ", test, test1);

			Step_Start(3, "Select the required vendor", test, test1);
			Step_Start(4, "Click the Vendor invoice no", test, test1);
			Step_Start(5, "Enter the values in the Vendor Invoice No", test, test1);

			globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");
		
			Step_End(3, "Select the required vendor", test, test1);
			Step_End(4, "Click the Vendor invoice no", test, test1);
			Step_End(5, "Enter the values in the Vendor Invoice No", test, test1);

			Step_Start(6, "Based on the Vendor, Payment mode auto fetch from the Vendor master(Type of Vendor).", test, test1);

			
			waitForElement(driver, direct_Payment_Mode_Button_VIR);
			String status_Of_direct_Payment_Mode_Button_VIR=getAttribute(driver, direct_Payment_Mode_Button_VIR, "class");
			String status_Of_disbursment_Payement_Mode_Button_VIR=getAttribute(driver, disbursment_Payement_Mode_Button_VIR, "class");

			if(status_Of_direct_Payment_Mode_Button_VIR.contains(status_Of_HQ_RadioButton_VM)) {
				
				
				System.out.println("Matched || Expected Result is : Radio Button selected in Vendor Master module : "+paymentModes_VM.get(0)+" || Actual Result is :  Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(0));
				Extent_pass_New(driver, "Matched || Expected Result is :  Radio Button selected in Vendor Master module : "+paymentModes_VM.get(0)+" || Actual Result is : Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(0), test, test1);
			}
			else if(status_Of_disbursment_Payement_Mode_Button_VIR.contains(status_Of_Disbursement_RadioButton_VM)) {
				System.out.println("Matched || Expected Result is :  Radio Button selected in Vendor Master module : "+paymentModes_VM.get(1)+" || Actual Result is : Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(1));
				Extent_pass_New(driver, "Matched || Expected Result is :  Radio Button selected in Vendor Master module : "+paymentModes_VM.get(1)+" || Actual Result is : Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(1), test, test1);
			}else {
				System.out.println("Not Matched || Expected Result is :  Radio Button should be selected || Actual Result is :   Radio Button is not  selected");
				Extent_fail(driver, "Not Matched || Expected Result is :  Radio Button should be selected || Actual Result is :   Radio Button is not  selected", test, test1);
			}
			
			
			Step_End(6, "Based on the Vendor, Payment mode auto fetch from the Vendor master(Type of Vendor).", test, test1);
			
			Extent_completed(testCaseName, test, test1);
	}

}
