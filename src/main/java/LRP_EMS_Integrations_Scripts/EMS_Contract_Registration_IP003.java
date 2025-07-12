package LRP_EMS_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class EMS_Contract_Registration_IP003 extends Keywords {

	public void emscontractregistrationip003(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String tc_Name="EMS_Contract_Registration_IP003";

		
		
		
		
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search_input = Excel_data.get("Search_input");
		String enter_contracttype_msg = Excel_data.get("enter_contracttype_msg");
		String Contractno1 = Excel_data.get("Contractno1");
		
		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

		moduleNavigate(driver, Search_input);
		
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		Step_Start(2, "Ensure that system should allow user to enter contract & contract type", test, test1);
		waitForElement(driver, Econtractno_field);
		sendKeys(driver, Econtractno_field, Contractno1);
		Step_End(2, "Ensure that system should allow user to enter contract & contract type", test, test1);

		Step_Start(3, "Ensure that system should validate as 'Enter Contract type' when user try to select Lease kind with selecting Contract type", test, test1);
		Extent_call(test, test1, "Ensure that system should validate as 'Enter Contract type' when user try to select Lease kind with selecting Contract type");
		waitForElement(driver, Eleasekind_searchicon);
		click(driver, Eleasekind_searchicon);
		
		waitForPopup(driver, Popup_Message, enter_contracttype_msg);
		String error_popup_msg2 = getText(driver, Popup_Message);
		if (error_popup_msg2.equals(enter_contracttype_msg)) {
			System.out.println("Matched || Expected popup was : " + enter_contracttype_msg + " || Actual popup was : "
					+ error_popup_msg2);
			Extent_pass_New(driver, "Matched || Expected popup was : " + enter_contracttype_msg + " || Actual popup was : "
					+ error_popup_msg2, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup was : " + enter_contracttype_msg+ " || Actual popup was : " + error_popup_msg2);
			Extent_fail(driver, "Not Matched || Expected popup was : " + enter_contracttype_msg+ " || Actual popup was : " + error_popup_msg2, test, test1);
		}
		Step_End(3, "Ensure that system should validate as 'Enter Contract type' when user try to select Lease kind with selecting Contract type", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Extent_completed(tc_Name, test, test1);
	}

}
