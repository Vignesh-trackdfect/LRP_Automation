package LRP_EMS_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Ems_Contract_Registration_Locators;

public class EMS_Contract_Registration_IP006 extends Keywords {

	public void emscontractregistrationip006(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String tc_Name="EMS_Contract_Registration_IP006";

		
		
		
		
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search_input = Excel_data.get("Search_input");
		String leasekind = 	Excel_data.get("leasekind");
		String lessor_code = Excel_data.get("lessor_code");
		String lessee_code = Excel_data.get("lessee_code");
		String sizevalue = Excel_data.get("sizevalue");
		String select_leasetype_msg = Excel_data.get("select_leasetype_msg");
		String Contractno6 = Excel_data.get("Contractno6");	
		String ContractType6 = Excel_data.get("ContractType6");	
		String Condition = Excel_data.get("Condition");
		String lease_code_header = Excel_data.get("lease_code_header");
		String lessor_code_header = Excel_data.get("lessor_code_header");
		String lesee_code_header = Excel_data.get("lesee_code_header");

		
		
		 String contype_opt =String.format(Ems_Contract_Registration_Locators.contype_opt, ContractType6);
	     String sizevalue_opt =String.format(DropDown_Select, sizevalue);
			
		Extent_Start(tc_Name, test, test1);
		 
			navigateUrl(driver, url); 

			
			LRP_Login(driver, Username, Password);
			
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

			moduleNavigate(driver, Search_input);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);
			
			Step_Start(2, "Ensure system should validate if user try to click add button without selecting lease charge type from size/type tab ", test, test1);
	    waitForElement(driver, Econtractno_field);
		   sendKeys(driver, Econtractno_field, Contractno6);
		   
		   waitForElement(driver, Econtracttype_field);
		   click(driver, Econtracttype_field);
		   
		   waitForDisplay(driver, contract_types);
			 if(!isDisplayed(driver,contract_types)) {
				  click(driver, Econtracttype_field);
			 }
				
				 waitForElement(driver, contype_opt);
			     click1(driver, contype_opt);
				 
		     waitForElement(driver, Eleasekind_searchicon);
				click(driver,Eleasekind_searchicon);	
				twoColumnSearchWindow(driver, lease_code_header, Condition, leasekind);

		
				
				waitForElement(driver, Elessorcode_searchicon);
				click(driver,Elessorcode_searchicon);
				twoColumnSearchWindow(driver, lessor_code_header, Condition, lessor_code);

				
				waitForElement(driver, Elessee_searchicon);
				click(driver,Elessee_searchicon);		
				twoColumnSearchWindow(driver, lesee_code_header, Condition, lessee_code);

				
				waitForElement(driver, Esizeandtype_tab);
				click(driver, Esizeandtype_tab);
				click(driver,Esizeandtype_Field);		
			
			
				waitForElement(driver, sizevalue_opt);
				click(driver, sizevalue_opt);
				
				Extent_call(test, test1, "Ensure that system should show warning as 'Select the Lease Charge Type");
			 	waitForElement(driver, Esizeaddbutton);
				click(driver, Esizeaddbutton);
				
				Step_End(2, "Ensure system should validate if user try to click add button without selecting lease charge type from size/type tab ", test, test1);

				Step_Start(3, "Ensure that system should show warning as 'Select the Lease Charge Type'", test, test1);
			waitForPopup(driver, Popup_Message, select_leasetype_msg);
				String error_popup_msg4=getText(driver, Popup_Message);
				if(error_popup_msg4.equals(select_leasetype_msg))
				{
					System.out.println("Matched || Expected popup was : "+select_leasetype_msg+" || Actual popup was : "+error_popup_msg4);
					Extent_pass_New(driver, "Matched || Expected popup was : "+select_leasetype_msg+" || Actual popup was : "+error_popup_msg4, test,test1);
				}
				else
				{
					System.out.println("Not Matched || Expected popup was : "+select_leasetype_msg+" || Actual popup was : "+error_popup_msg4);
					Extent_fail(driver,  "Not Matched || Expected popup was : "+select_leasetype_msg+" || Actual popup was : "+error_popup_msg4, test,test1);
				}
				
				Step_End(3, "Ensure that system should show warning as 'Select the Lease Charge Type'", test, test1);

				Extent_completed(tc_Name, test, test1);
}
}