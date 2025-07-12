package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC05 extends Keywords {

	public void Vendor_Invoice_Registration_SC05(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String testcase_Name = "TC_Vendor_Invoice_Registration_SC05";
	
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Vendor_Invoice_Registration_Module = Excel_data.get("Vendor_Invoice_Registration_Module");
		String agency_User = Excel_data.get("agency_User");
		String Vendor_Master_Module = Excel_data.get("Vendor_Master_Module");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
		String Condition = Excel_data.get("Condition");
		String Vendor_Code_Search_VIR = Excel_data.get("Vendor_Code_Search_VIR");


		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, agency_User);
		moduleNavigate(driver, Vendor_Master_Module);

		waitForElement(driver, new_Button_VM);
		click(driver, new_Button_VM);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Condition, Vendor_Code_Search_VM, Vendor_Code, "", "", "", "");

		waitForElement(driver, Paymemnt_Method_VM);
		String Payment_Method_Value=getText(driver, Paymemnt_Method_VM);
		System.out.println("Payment_Method_Value VM :"+Payment_Method_Value);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_Start(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

		moduleNavigate(driver, Vendor_Invoice_Registration_Module);
		Step_End(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

		Step_Start(2, "Click the Vendor code search ", test, test1);
		waitForElement(driver, Vedor_Code_Search_Button_VIR);
		click(driver, Vedor_Code_Search_Button_VIR);
		Step_End(2, "Click the Vendor code search ", test, test1);

		Step_Start(3, "Select the required vendor", test, test1);
		globalValueSearchWindow(driver, Condition, Vendor_Code_Search_VIR, Vendor_Code, "", "", "", "");
		Step_End(3, "Select the required vendor", test, test1);

		Step_Start(4, "Based on the Vendor, Payment mode auto fetch from the Vendor master(Type of Vendor)", test, test1);
		waitForElement(driver, Payment_Method_VIR);
		String Payment_Method_Value_VIR=getText(driver, Payment_Method_VIR);
		System.out.println("Payment_Method_Value_VIR :"+Payment_Method_Value_VIR);

		if(Payment_Method_Value.equalsIgnoreCase(Payment_Method_Value_VIR)) {
			System.out.println("Matched || Expected Result is : Payment Method Value Taken from Vendor Master Module :"+ Payment_Method_Value + "|| Actual Result is : Payment Method Value Taken from Vendor Invoice registration Module :"+ Payment_Method_Value_VIR);
			Extent_pass_New(driver, "Matched ||Expected Result is : Payment Method Value Taken from Vendor Master Module :"+ Payment_Method_Value + "|| Actual Result is :Payment Method Value Taken from Vendor Invoice registration Module :"+ Payment_Method_Value_VIR, test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : Payment Method Value Taken from Vendor Master Module :"+ Payment_Method_Value + "|| Actual Result is :Payment Method Value Taken from Vendor Invoice registration Module :"+ Payment_Method_Value_VIR);
			Extent_fail(driver, "Not Matched ||Expected Result is :  Payment Method Value Taken from Vendor Master Module :"+ Payment_Method_Value + "|| Actual Result is : Payment Method Value Taken from Vendor Invoice registration Module :"+ Payment_Method_Value_VIR, test, test1);

		}
		Step_End(4, "Based on the Vendor, Payment mode auto fetch from the Vendor master(Type of Vendor)", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}


}
