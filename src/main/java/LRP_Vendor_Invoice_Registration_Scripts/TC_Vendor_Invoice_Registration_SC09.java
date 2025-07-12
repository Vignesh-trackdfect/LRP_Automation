package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Invoice_Registration_SC09 extends Keywords{
	
	public void Vendor_Invoice_Registration_SC09(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Vendor_Invoice_Registration_SC09";
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
			String activityTypes = Excel_data.get("ActivityTypes");
			String PaymentModes_VIR = Excel_data.get("PaymentModes_VIR");
			String PaymentModes_VM = Excel_data.get("PaymentModes_VM");
			String activityTypes_RadioButtons = Excel_data.get("ActivityTypes_RadioButtons");

			
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
				status_Of_HQ_RadioButton_VM=paymentMode_RadioButton_Status;
			}
			else if(status_Of_Disbursement_RadioButton_VM.contains(paymentMode_RadioButton_Status)) {
				status_Of_Disbursement_RadioButton_VM=paymentMode_RadioButton_Status;

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
				
				System.out.println("Matched || Expected Radio Button selected in Vendor Master module : "+paymentModes_VM.get(0)+" || Actual Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(0));
				Extent_pass_New(driver, "Matched || Expected Radio Button selected in Vendor Master module : "+paymentModes_VM.get(0)+" || Actual Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(0), test, test1);
			}
			else if(status_Of_disbursment_Payement_Mode_Button_VIR.contains(status_Of_Disbursement_RadioButton_VM)) {
				System.out.println("Matched || Expected Radio Button selected in Vendor Master module : "+paymentModes_VM.get(1)+" || Actual Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(1));
				Extent_pass_New(driver, "Matched || Expected Radio Button selected in Vendor Master module : "+paymentModes_VM.get(1)+" || Actual Radio Button selected in Vendor Invoice Registration module : "+paymentModes_VIR.get(1), test, test1);
			}else {
				System.out.println("Not Matched || Actual : "+paymentModes_VM.get(0) +"/"+paymentModes_VM.get(1)+" Radio Button is not selected in Vendor Master module "+paymentModes_VIR.get(0) +"/"+paymentModes_VIR.get(1)+" Radio Button is not selected in Vendor Invoice registration Module ");
				Extent_fail(driver, "Not Matched || Actual : "+paymentModes_VM.get(0) +"/"+paymentModes_VM.get(1)+" Radio Button is not selected in Vendor Master module "+paymentModes_VIR.get(0) +"/"+paymentModes_VIR.get(1)+" Radio Button is not selected in Vendor Invoice registration Module ", test, test1);
			}
			
			
			Step_End(6, "Based on the Vendor, Payment mode auto fetch from the Vendor master(Type of Vendor).", test, test1);
			Step_Start(7, "Based on the Vendor, Payment Method auto fetch from the Vendor master(Payment Methods).", test, test1);
			waitForElement(driver, Payment_Method_VIR);
			String Payment_Method_Value_VIR=getText(driver, Payment_Method_VIR);
			System.out.println("Payment_Method_Value_VIR :"+Payment_Method_Value_VIR);

			if(Payment_Method_Value.equalsIgnoreCase(Payment_Method_Value_VIR)) {
				System.out.println("Matched ||Payment Method Value Taken from Vendor Master Module :"+Payment_Method_Value + "||Payment Method Value Taken from Vendor Invoice registration Module :"+Payment_Method_Value_VIR);
				Extent_pass_New(driver, "Matched ||Payment Method Value Taken from Vendor Master Module :"+Payment_Method_Value + "||Payment Method Value Taken from Vendor Invoice registration Module :"+Payment_Method_Value_VIR, test, test1);
			}else {
				System.out.println("Not Matched ||Payment Method Value Taken from Vendor Master Module :"+Payment_Method_Value + "||Payment Method Value Taken from Vendor Invoice registration Module :"+Payment_Method_Value_VIR);
				Extent_fail(driver, "Not Matched ||Payment Method Value Taken from Vendor Master Module :"+Payment_Method_Value + "||Payment Method Value Taken from Vendor Invoice registration Module :"+Payment_Method_Value_VIR, test, test1);

			}
			Step_End(7, "Based on the Vendor, Payment Method auto fetch from the Vendor master(Payment Methods).", test, test1);
			
			Step_Start(8, "Click the Activity type drop down and Select the Activity Type.", test, test1);

		
			
			Step_Start(9, "Based on the Activity type, It show the Activity description.", test, test1);

			List<String> activity_Types = splitAndExpand(activityTypes);
			List<String> activityTypeRadioButton = splitAndExpand(activityTypes_RadioButtons);

			for(int i=0;i<activity_Types.size();i++) {
				String activityType=activity_Types.get(i);
				String activityType_RadioButton=activityTypeRadioButton.get(i);

				waitForElement(driver, Vendor_activity_type);
				click(driver, Vendor_activity_type);

				String select_ActivityType=String.format(DropDown_Select, activityType);
				waitForElement(driver, select_ActivityType);
				click(driver, select_ActivityType);
				waitForElement(driver, Vendor_activity_type);
				
				String actualRadioButton=activityTypeRadioButtons_VIR(driver,activityType,activityType_RadioButton);
				if(actualRadioButton.equals(activityType_RadioButton)) {
					System.out.println("Matched || Expected Radio Button for "+activityType+" : "+activityType_RadioButton+" || Actual Radio Button for "+activityType+" : "+actualRadioButton);
					Extent_pass_New(driver, "Matched || Expected Radio Button for "+activityType+" : "+activityType_RadioButton+" || Actual Radio Button for "+activityType+" : "+actualRadioButton, test, test1);
				}else {
					System.out.println("Not Matched || Expected Radio Button for "+activityType+" : "+activityType_RadioButton+" || Actual Radio Button for "+activityType+" : "+actualRadioButton);
					Extent_fail(driver, "Not Matched || Expected Radio Button for "+activityType+" : "+activityType_RadioButton+" || Actual Radio Button for "+activityType+" : "+actualRadioButton, test, test1);
				}
				}
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			Step_End(8, "Click the Activity type drop down and Select the Activity Type.", test, test1);


			Step_End(9, "Based on the Activity type, It show the Activity description.", test, test1);

			Extent_completed(testCaseName, test, test1);
	}

}
