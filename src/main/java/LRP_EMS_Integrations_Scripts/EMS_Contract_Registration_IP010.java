package LRP_EMS_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Ems_Contract_Registration_Locators;

public class EMS_Contract_Registration_IP010 extends Keywords {
public void emscontractregistrationip010 (WebDriver driver,ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		
	String tc_Name="EMS_Contract_Registration_IP010";

	
	
	
	
	
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");	
		String Search_input = Excel_data.get("Search_input");	
		String Contractno10 = Excel_data.get("Contractno10");	
		String ContractType10 = Excel_data.get("ContractType10");	
		String leasekind = Excel_data.get("leasekind");	
		String lessor_code = Excel_data.get("lessor_code");	
		String lessee_code = Excel_data.get("lessee_code");	
		String sizevalue = Excel_data.get("sizevalue");	
		String leasevalue = Excel_data.get("leasevalue");	
		String PerDiem_Value = Excel_data.get("PerDiem_Value");	
		String locationhier_value = Excel_data.get("locationhier_value");	
		String date_Picker = Excel_data.get("date_Picker");
		String from_date = Excel_data.get("from_date");
		String to_date = Excel_data.get("to_date");
		String Condition = Excel_data.get("Condition");
		String lease_code_header = Excel_data.get("lease_code_header");
		String lessor_code_header = Excel_data.get("lessor_code_header");
		String lesee_code_header = Excel_data.get("lesee_code_header");

		 String contype_opt =String.format(Ems_Contract_Registration_Locators.contype_opt, ContractType10);
	     String sizevalue_opt =String.format(DropDown_Select, sizevalue);
		String leasevalue_opt=String.format(DropDown_Select, leasevalue);
		String locationhier1_value=String.format(Ems_Contract_Registration_Locators.locationhier1_value,locationhier_value);
		
		Extent_Start(tc_Name, test, test1);
			navigateUrl(driver, url); 

			
			LRP_Login(driver, Username, Password);
			
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
			moduleNavigate(driver, Search_input);
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

	    
	    Extent_call(test, test1, "Ensure system should allow user to enter contract no & contract type");
	    
	    Step_Start(2, " Ensure system should allow user to enter contract no & contract type", test, test1);
		waitForElement(driver, Econtractno_field);
		sendKeys(driver, Econtractno_field, Contractno10);

		waitForElement(driver, Econtracttype_field);
		click(driver, Econtracttype_field);
		waitForDisplay(driver, contract_types);
		if (!isDisplayed(driver, contract_types)) {
			waitForElement(driver, Econtracttype_field);
			click(driver, Econtracttype_field);
		}

		waitForElement(driver, contype_opt);
		click(driver, contype_opt);
		Step_End(2, " Ensure system should allow user to enter contract no & contract type", test, test1);

		waitForElement(driver, Eleasekind_searchicon);
		click(driver, Eleasekind_searchicon);
		twoColumnSearchWindow(driver, lease_code_header, Condition, leasekind);

	
		Step_Start(3, "Ensure that should allow user to select Lessor & Lessor from that field", test, test1);

		Extent_call(test, test1, " Ensure that should allow user to select Lessor & Lessor from that field");

		waitForElement(driver, Elessorcode_searchicon);
		click(driver, Elessorcode_searchicon);
		twoColumnSearchWindow(driver, lessor_code_header, Condition, lessor_code);


		waitForElement(driver, Elessee_searchicon);
		click(driver, Elessee_searchicon);
		twoColumnSearchWindow(driver, lesee_code_header, Condition, lessee_code);

		Step_End(3, "Ensure that should allow user to select Lessor & Lessor from that field", test, test1);

		Step_Start(4, "Ensure that system should allow user to select valid From & To Period", test, test1);
		waitForElement(driver, Evaild_from);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, Evaild_from, from_date);

		} else {
			waitForElement(driver, Evaild_from);
			clearAndType(driver, Evaild_from, from_date);
		}

		waitForElement(driver, Evaild_to);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, Evaild_to, to_date);

		} else {
			waitForElement(driver, Evaild_to);
			clearAndType(driver, Evaild_to, to_date);
		}
		Step_End(4, "Ensure that system should allow user to select valid From & To Period", test, test1);

		Step_Start(5, " Ensure that system should able to click on Size/Type tab", test, test1);

		Extent_call(test, test1, "Ensure that system should able to select size type tab");
		waitForElement(driver, Esizeandtype_tab);
		click(driver, Esizeandtype_tab);
		waitForElement(driver, Esizeandtype_Field);
		click(driver, Esizeandtype_Field);

		Step_End(5, " Ensure that system should able to click on Size/Type tab", test, test1);

				waitForElement(driver, sizevalue_opt);
				click(driver, sizevalue_opt);
				
				Step_Start(6, "Ensure that system should able to select Lease charge type as 'No banding'", test, test1);
				Extent_call(test, test1, "Ensure that system should able to select Lease charge type as 'No banding'");
				waitForElement(driver, Eleasechargetype_Field);
				click(driver,Eleasechargetype_Field);		
				
				Step_End(6, "Ensure that system should able to select Lease charge type as 'No banding'", test, test1);

				waitForElement(driver, leasevalue_opt);
				click(driver, leasevalue_opt);
				
				waitForElement(driver, Eperdiem_field);
				clear(driver, Eperdiem_field);		
				sendKeys(driver, Eperdiem_field, PerDiem_Value);
				
				Step_Start(7, "Ensure that system should allow user to add data into grid once per diem is entered & add button is pressed", test, test1);
				Extent_call(test, test1, "Ensure that system should allow user to add data into grid once per diem is entered & add button is pressed");
				waitForElement(driver, Esizeaddbutton);
				click(driver, Esizeaddbutton);
				
				Step_End(7, "Ensure that system should allow user to add data into grid once per diem is entered & add button is pressed", test, test1);

				Extent_call(test, test1, " Ensure that system should able to select Terms & Charges tab");
				Step_Start(8, " Ensure that system should able to select Terms & Charges tab", test, test1);
				waitForElement(driver, Etermandcharges);
				click(driver, Etermandcharges);
				System.out.println("termcharges tab opened");
				Step_End(8, " Ensure that system should able to select Terms & Charges tab", test, test1);
Step_Start(9, "Ensure that system should be enable location field only when location hierarchy is selected", test, test1);
				
waitForElement(driver, Elocationaddbutton);
if(!isClickable(driver, Elocationaddbutton)){
					waitForElement(driver, ELocationhierarchy_field);
					click(driver,ELocationhierarchy_field);	
					
					waitForElement(driver, locationhier1_value);
					click(driver, locationhier1_value);
					
					Extent_call(test, test1, "Ensure that system should be enable location field only when location hierarchy is selected");
					
					waitForDisplay(driver, Elocationaddbutton);
					if(IsElementEnabled(driver, Elocationaddbutton)){
						System.out.println("Expected Result is : Location add button should be enabled || Actual Result is :Location add button is enabled");
						Extent_pass_New(driver, "Expected Result is : Location add button should be enabled || Actual Result is :Location add button is enabled", test, test1);
					}
					else{
						System.out.println("Expected Result is : Location add button should be enabled || Actual Result is :Location add button is not enabled");
						Extent_fail(driver, "Expected Result is : Location add button should be enabled || Actual Result is :Location add button is not enabled", test, test1);
					}
				}
				else{
					System.out.println("Expected Result is : Location add button should not be enabled before giving input to location hierarchy || Actual Result is : Location add button is enabled before giving input to location hierarchy");
					Extent_fail(driver, "Expected Result is : Location add button should not be enabled before giving input to location hierarchy || Actual Result is : Location add button is enabled before giving input to location hierarchy", test, test1);
				}
				Step_End(9, "Ensure that system should be enable location field only when location hierarchy is selected", test, test1);

				Extent_completed(tc_Name, test, test1);	
}
}
