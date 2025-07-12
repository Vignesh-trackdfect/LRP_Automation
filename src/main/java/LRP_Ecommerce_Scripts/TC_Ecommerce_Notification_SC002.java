package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Notification_SC002 extends Keywords{

	public void Ecommerce_Notification_SC002(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Notification_SC002";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Ecomm_Notification_Module = Excel_data.get("Ecomm_Notification_Module");

		String ByCustomer_FieldName = Excel_data.get("ByCustomer_FieldName");
		String AllCustomer_FieldName = Excel_data.get("AllCustomer_FieldName");
		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyName);
		
		Step_Start(1,"  The  Ecom notification module contains the following options:",test, test1);

		moduleNavigate(driver, Ecomm_Notification_Module);
		
		Step_End(1,"  The  Ecom notification module contains the following options:",test, test1);

		waitForElement(driver, CustomerSelectOption_EN);
		
		String AllCustomer_RadioBtn=String.format(Select_Customer_Option_EN, AllCustomer_FieldName);
		String ByCustomerType_RadioBtn=String.format(Select_Customer_Option_EN, ByCustomer_FieldName);
		Step_Start(2," All Customers option",test, test1);

		if(IsElementEnabled(driver, AllCustomer_RadioBtn)) {
			System.out.println("Expected : ALL Customer Field should be Accessible ||  Actual : ALL Customer field is Accessible");
			Extent_pass_New(driver, "Expected : ALL Customer Field should be Accessible ||  Actual : ALL Customer field is Accessible", test, test1);
		}else {
			System.out.println("Expected : ALL Customer Field should be Accessible ||  Actual : ALL Customer field is Not Accessible");
			Extent_fail(driver, "Expected : ALL Customer Field should be Accessible ||  Actual : ALL Customer field is Not Accessible", test, test1);
		}
		Step_End(2," All Customers option",test, test1);

		Step_Start(3,"By Customer option",test, test1);

		if(IsElementEnabled(driver, ByCustomerType_RadioBtn)) {
			System.out.println("Expected : BY Customer Field should be Accessible ||  Actual : BY Customer field is Accessible");
			Extent_pass_New(driver, "Expected : BY Customer Field should be Accessible ||  Actual : BY Customer field is Accessible", test, test1);
		}else {
			System.out.println("Expected : BY Customer Field should be Accessible ||  Actual : BY Customer field is Not Accessible");
			Extent_fail(driver, "Expected : BY Customer Field should be Accessible ||  Actual : BY Customer field is Not Accessible", test, test1);
		}
		Step_End(3,"By Customer option",test, test1);

		String CustomerType_Select=String.format(Select_Customer_Option_EN, ByCustomer_FieldName);
		waitForElement(driver, CustomerType_Select);
		click(driver,CustomerType_Select);
		Step_Start(4,"Message box, and Send button",test, test1);

		waitForDisplay(driver, Customer_Add_button_EN);
		if(IsElementEnabled(driver, Customer_Add_button_EN)) {
			System.out.println("Expected : Customer ADD button Should be accesible when select the 'BY Customer' option|| Actual : Customer ADD button is Accessible When select the 'BY Customer' Option");
			Extent_pass_New(driver, "Expected : Customer ADD button Should be accesible when select the 'BY Customer' option|| Actual : Customer ADD button is Accessible When select the 'BY Customer' Option", test, test1);
		}else {
			System.out.println("Expected : Customer ADD button Should be accesible when select the 'BY Customer' option|| Actual : Customer ADD button is Not Accessible When select the 'BY Customer' Option");
			Extent_fail(driver, "Expected : Customer ADD button Should be accesible when select the 'BY Customer' option|| Actual : Customer ADD button is Not Accessible When select the 'BY Customer' Option", test, test1);
		}
		
		waitForElement(driver, Message_Input_Area_EN);
		if(IsElementEnabled(driver, Message_Input_Area_EN)) {
			System.out.println("Expected : Message input Should be Accessible || Actual : Message input is Accessible ");
			Extent_pass_New(driver, "Expected : Message input Should be Accessible || Actual : Message input is Accessible ", test, test1);
		}else {
			System.out.println("Expected : Message input Should be Accessible || Actual : Message input is Not Accessible ");
			Extent_fail(driver, "Expected : Message input Should be Accessible || Actual : Message input is Not Accessible ", test, test1);
		}
		
		waitForElement(driver, Send_Button_EN);
		if(IsElementEnabled(driver, Send_Button_EN)) {
			System.out.println("Expected :  Send Button Should be Accessible || Actual : Send button is Accesible");
			Extent_pass_New(driver, "Expected :  Send Button Should be Accessible || Actual : Send button is Accesible", test, test1);
		}else {
			System.out.println("Expected :  Send Button Should be Accessible || Actual : Send button is not Accesible");
			Extent_fail(driver, "Expected :  Send Button Should be Accessible || Actual : Send button is not Accesible", test, test1);
		}
		Step_End(4,"Message box, and Send button",test, test1);
		
		Extent_completed(testcase_Name, test, test1);

		
	}
}
