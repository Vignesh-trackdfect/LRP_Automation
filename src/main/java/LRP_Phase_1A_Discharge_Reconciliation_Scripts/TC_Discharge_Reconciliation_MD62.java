package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD62 extends Keywords {
	
	public void Discharge_Reconciliation_MD62(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD62";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Agency_Config_Module = Excel_data.get("Agency_Config_Module");
		String Agency_code_header = Excel_data.get("Agency_code_header");
		String Attribute_code_header = Excel_data.get("Attribute_code_header");
		String Condition = Excel_data.get("Condition");
		String Attribute = Excel_data.get("Attribute");
		String Description = Excel_data.get("Description");
		String Value = Excel_data.get("Value");
		String Dis_Recon_Module = Excel_data.get("Dis_Recon_Module");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);

		SwitchProfile(driver, AgencyUser);
		Step_Start(1, " Switch to agency", test, test1);
		Step_Start(2, " Open Agency configuration module", test, test1);
		Step_Start(3, " Click on New button,if new button not available go below steps", test, test1);
		Step_Start(4, " Click on agency code search Button", test, test1);
		Step_Start(5, "Enter the agency code and click on Show Button,", test, test1);
		Step_Start(6, "Verify that given configuration is already available if available and make sure that value is Marked as -N.Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y'", test, test1);
		Step_Start(7, " if marked as N move to next action", test, test1);
		Step_Start(8, " if Configuration marked as Y then Double click the row and change the Value to N and click (+)button", test, test1);
		Step_Start(9, " if Configuration is not added go to next step,", test, test1);
	
	
		setAgencyConfiguration(driver, Agency_Config_Module, Agency_code_header, Attribute_code_header, Condition,
				AgencyUser, Attribute, Description, Value);
		
		Step_End(1, " Switch to agency", test, test1);
		Step_End(2, " Open Agency configuration module", test, test1);
		Step_End(3, " Click on New button,if new button not available go below steps", test, test1);
		Step_End(4, " Click on agency code search Button", test, test1);
		Step_End(5, "Enter the agency code and click on Show Button,", test, test1);
		Step_End(6, "Verify that given configuration is already available if available and make sure that value is Marked as -N.Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y'", test, test1);
		Step_End(7, " if marked as N move to next action", test, test1);
		Step_End(8, " if Configuration marked as Y then Double click the row and change the Value to N and click (+)button", test, test1);
		Step_End(9, " if Configuration is not added go to next step,", test, test1);

		Step_Start(10, "Open Discharge Reconciliation Module", test, test1);
		moduleNavigate(driver, Dis_Recon_Module);
		
		
		Step_End(10, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(11, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		newButton(driver);

		Step_End(11, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		
	

		Step_Start(12, "Verify that DPD CODE and Shipment Category option is not available in Discharge reconcilliation module", test, test1);
	waitForDisplay(driver, Shipment_Cat_Button);
	if(!isdisplayed(driver, Shipment_Cat_Button)) {
		System.out.println("Matched || Expected Result is : Shipment Category button should not be displayed || Actual Result is : Shipment Category button is not displayed");
		Extent_pass(driver, "Matched || Expected Result is :Shipment Category button should not be displayed || Actual Result is :Shipment Category button is not displayed", test, test1);
	}else {
		System.out.println("Matched || Expected Result is : Shipment Category button should not be displayed || Actual Result is : Shipment Category button is  displayed");
		Extent_fail(driver, "Matched || Expected Result is :Shipment Category button should not be displayed || Actual Result is :Shipment Category button is  displayed", test, test1);
	}
	waitForDisplay(driver, DPD_CODE_BUTTON);
	if(!isdisplayed(driver, DPD_CODE_BUTTON)) {
		System.out.println("Matched || Expected Result is : DPD Code Button button should not be displayed || Actual Result is : DPD Code Button button is not displayed");
		Extent_pass(driver, "Matched || Expected Result is :DPD Code Button button should  not be displayed || Actual Result is :DPD Code Button button is not displayed", test, test1);
	}else {
		System.out.println("Matched || Expected Result is : DPD Code Button button should not be displayed || Actual Result is : DPD Code Button button is  displayed");
		Extent_fail(driver, "Matched || Expected Result is :DPD Code Button button should not be displayed || Actual Result is :SDPD Code Button button is  displayed", test, test1);
	
	}
	Step_End(12, "Verify that DPD CODE and Shipment Category option is not available in Discharge reconcilliation module", test, test1);
Extent_completed(testcase_Name, test, test1);
}}
