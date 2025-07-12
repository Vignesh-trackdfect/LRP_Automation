package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC02 extends Keywords {

	public void Vendor_Invoice_Registration_SC02(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String testcase_Name = "TC_Vendor_Invoice_Registration_SC02";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Vendor_Invoice_Registration_Module = Excel_data.get("Vendor_Invoice_Registration_Module");
		String agency_User = Excel_data.get("agency_User");
		String Vendor_Invoice_No_field_Input = Excel_data.get("Vendor_Invoice_No_field_Input");
		String Limit_Of_Vendor_Invoice_No_Input = Excel_data.get("Limit_Of_Vendor_Invoice_No_Input");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Condition = Excel_data.get("Condition");
		String Vendor_Code_Search_VIR = Excel_data.get("Vendor_Code_Search_VIR");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		SwitchProfile(driver, agency_User);
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

		Step_Start(4, "Click the Vendor invoice no", test, test1);
		waitForElement(driver, Vendor_Invoice_Number_Input_VIR);
		click(driver, Vendor_Invoice_Number_Input_VIR);
		Step_End(4, "Click the Vendor invoice no", test, test1);
		
		Step_Start(5, "Enter the values in the Vendor Invoice No", test, test1);
		sendKeys(driver, Vendor_Invoice_Number_Input_VIR, Vendor_Invoice_No_field_Input);
		String Vendor_Invoice_No_Input = getTextJavascript(driver, Vendor_Invoice_Number_Input_VIR);
		int total_Vendor_Invoice_No_Input = Vendor_Invoice_No_Input.length();
		int exp_Limit_Of_vendor_Invoice_No_Input = Integer.parseInt(Limit_Of_Vendor_Invoice_No_Input);
		
	
		if(exp_Limit_Of_vendor_Invoice_No_Input>=total_Vendor_Invoice_No_Input) {
			System.out.println("Matched || Expected Result is : Once user enter the Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_vendor_Invoice_No_Input+" || Actual Result is : Once user enter the Number of Characters is Accepted In Description Field : "+total_Vendor_Invoice_No_Input);
			Extent_pass_New(driver,"Matched || Expected Result is : Once user enter the Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_vendor_Invoice_No_Input+" || Actual Result is : Once user enter the Number of Characters is Accepted In Description Field : "+total_Vendor_Invoice_No_Input, test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : Once user enter the Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_vendor_Invoice_No_Input+" || Actual Result is : Once user enter the Number of Characters is not Accepted In Description Field : "+total_Vendor_Invoice_No_Input);
			Extent_fail(driver,"Not Matched || Expected Result is : Once user enter the Expected Number of Characters Should be Accept In Description Field : "+exp_Limit_Of_vendor_Invoice_No_Input+" || Actual Result is : Once user enter the Number of Characters is not Accepted In Description Field : "+total_Vendor_Invoice_No_Input, test, test1);
		}
		
		Step_End(5, "Enter the values in the Vendor Invoice No", test, test1);
		Extent_completed(testcase_Name, test, test1);
		
	}
}
