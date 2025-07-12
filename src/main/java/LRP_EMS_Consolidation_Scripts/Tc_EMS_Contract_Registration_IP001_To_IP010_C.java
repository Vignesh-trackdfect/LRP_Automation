package LRP_EMS_Consolidation_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.Ems_Contract_Registration_Locators;

public class Tc_EMS_Contract_Registration_IP001_To_IP010_C extends Keywords {

	public void EMS_Contract_Registration_IP001_To_IP010_C (WebDriver driver,ExtentTest test,ExtentTest test1, String selected_dataset) throws Exception {

		

		int TC1=1;

		if(TC1==1) {
			String tc_Name="EMS_Contract_Registration_IP001";
			String URL = TestNgXml.getdatafromExecution().get(tc_Name);
			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
			String Username = data.get("Username");
			String Password = data.get("Password");	
			String Search_input = data.get("Search_input");	
			String exist_contractno = data.get("exist_contractno");	
			String contract_popup_msg = data.get("contract_popup_msg");	
		
			Extent_Start(tc_Name, test, test1);
			navigateUrl(driver, URL); 

			LRP_Login(driver, Username, Password);
			
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
			
			moduleNavigate(driver, Search_input);

		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		waitForElement(driver, Esave_button);	
		
		Step_Start(2, " Ensure that system should validate if user try to enter contract no which is already saved.", test, test1);

		sendKeys(driver, Econtractno_field, exist_contractno);
		enter(driver);
		Step_End(2, " Ensure that system should validate if user try to enter contract no which is already saved.", test, test1);

		Extent_call(test, test1, "Ensure that system should validate as 'The Contract No. TUE-11 already exists'");
		
		Step_Start(3, " Ensure that system should validate as 'The Contract No. already exists'", test, test1);

		waitForPopup(driver, Popup_Message, contract_popup_msg);
		String error_popup_msg = getText(driver, Popup_Message);
		if(error_popup_msg.contains(contract_popup_msg))
		{
			System.out.println("Matched || Expected Popup was : "+ contract_popup_msg +" || Actual Popup was : "+  error_popup_msg);
			Extent_pass_New(driver, "Matched || Expected Popup was : "+ contract_popup_msg +" || Actual Popup was : "+ error_popup_msg, test,test1);
		}
		else
		{
			System.out.println("Not Matched || Expected Popup was : "+  contract_popup_msg +" || Actual Popup was : "+ error_popup_msg);
			Extent_fail(driver,  "Not Matched || Expected Popup was : "+ contract_popup_msg +" || Actual Popup was : "+ error_popup_msg, test,test1);
		}
		Step_End(3, " Ensure that system should validate as 'The Contract No. already exists'", test, test1);

		Extent_completed(tc_Name, test, test1);
					waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);


		}

		int TC2=1;

		if(TC2==1) {	
			String tc_Name="EMS_Contract_Registration_IP002";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
			String Search_input = data.get("Search_input");
			String enter_contractno_msg = data.get("enter_contractno_msg");
			String Contractno = data.get("Contractno");
			String ContractType2 = data.get("ContractType2");
			
			 String contype_opt =String.format(DropDown_Select, ContractType2);
			
			Extent_Start(tc_Name, test, test1);
			
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

			moduleNavigate(driver, Search_input);

		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		Step_Start(2, "Ensure that system should validate as 'Enter the Contract No.' when user try to select contract type without entering contract no", test, test1);
		 waitForElement(driver, Econtracttype_field);
		   click(driver, Econtracttype_field);
		   waitForDisplay(driver, contract_types);
		   
			 if(!isDisplayed(driver,contract_types)) {
				  click(driver, Econtracttype_field);
			 }
	 
			 waitForElement(driver, contype_opt);
		     click(driver, contype_opt);
	 
		   Extent_call(test, test1, " Ensure that system should validate as 'Enter the Contract No.' when user try to select contract type without entering contract no");
		 	
		   waitForPopup(driver, Popup_Message, enter_contractno_msg);
		 String error_popup_msg1=getText(driver, Popup_Message);
		 if(error_popup_msg1.equals(enter_contractno_msg))
			{
				System.out.println("Matched || Expected popup was : "+enter_contractno_msg+" || Actual popup was : "+error_popup_msg1);
				Extent_pass_New(driver, "Matched || Expected popup was : "+enter_contractno_msg+" || Actual popup was : "+error_popup_msg1, test,test1);
			}
			else
			{
				System.out.println("Not Matched || Expected popup was : "+enter_contractno_msg+" || Actual popup was : "+error_popup_msg1);
				Extent_fail(driver,  "Not Matched || Expected popup was : "+enter_contractno_msg+" || Actual popup was : "+error_popup_msg1, test,test1);
			}
			Step_End(2, "Ensure that system should validate as 'Enter the Contract No.' when user try to select contract type without entering contract no", test, test1);

		 Extent_call(test, test1, "Ensure that system should allow user to enter & save alphanumeric in contract no");
			
		 Step_Start(3, " Ensure that system should allow user to enter & save alphanumeric in contract no", test, test1);
		waitForElement(driver, Econtractno_field);
		 sendKeys(driver, Econtractno_field, Contractno);
		 waitForElement(driver, Econtractno_field);
		 click(driver, Econtractno_field);
		 String entered_contractno=getAttribute(driver, Econtractno_field, "value");
			waitForElement(driver, Econtractno_field);
	  if(!entered_contractno.equals("")){
		 if(entered_contractno.equals(Contractno))
			{
				System.out.println("User can able to enter Alpha numeric values");
				System.out.println("Matched || Expected value was : "+Contractno+" || Actual value was : "+entered_contractno);
				Extent_pass_New(driver, "Matched || Expected value was : "+Contractno+" || Actual value was : "+entered_contractno, test,test1);
			}
			else
			{
				System.out.println("User cannot able to enter Alpha numeric values");
				System.out.println("Not Matched || Expected value was : "+Contractno+" || Actual value was : "+entered_contractno);
				Extent_fail(driver,  "Not Matched || Expected value was : "+Contractno+" || Actual value was : "+entered_contractno, test,test1);
			}
	  }
		 Step_End(3, " Ensure that system should allow user to enter & save alphanumeric in contract no", test, test1);

		 waitForElement(driver, Close_Current_tab);
		 click(driver, Close_Current_tab);
			Extent_completed(tc_Name, test, test1);
		}

		int TC3=1;

		if(TC3==1) {
			String tc_Name="EMS_Contract_Registration_IP003";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
			String Search_input = data.get("Search_input");
			String enter_contracttype_msg = data.get("enter_contracttype_msg");
			String Contractno1 = data.get("Contractno1");
			
			Extent_Start(tc_Name, test, test1);

			
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
		int TC4=1;

		if(TC4==1)	 {
			String tc_Name="EMS_Contract_Registration_IP004";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
			String Search_input = data.get("Search_input");
			String Contractno4 = data.get("contract_no4");
			String ContractType4 = data.get("ContractType4");
			String leasekind = data.get("leasekind");
			String lessor_code = data.get("lessor_code");
			String Condition = data.get("Condition");

			String lease_code_header = data.get("lease_code_header");
			String lessor_code_header = data.get("lessor_code_header");
			
			 String contype_opt =String.format(DropDown_Select, ContractType4);


			Extent_Start(tc_Name, test, test1);
			
			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

			moduleNavigate(driver, Search_input);

			Step_End(1, "Enter module name in searchbox & click the module", test, test1);
			
			Step_Start(2, "  Ensure system should allow user to enter contract no & contract type", test, test1);
			waitForElement(driver, Econtractno_field);
			sendKeys(driver, Econtractno_field, Contractno4);
			Step_End(2, "  Ensure system should allow user to enter contract no & contract type", test, test1);

			
			Step_Start(3, "Ensure that system should enable size/type field only if lessor code is selected from the list", test, test1);
			waitForElement(driver, Econtracttype_field);
			click(driver, Econtracttype_field);
			
			waitForDisplay(driver, contract_types);
			if (!isDisplayed(driver, contract_types)) {
				waitForElement(driver, Econtracttype_field);
				click(driver, Econtracttype_field);
			}
				
				waitForElement(driver, contype_opt);
				click(driver, contype_opt);
				
			waitForElement(driver, Eleasekind_searchicon);
			click(driver, Eleasekind_searchicon);
			twoColumnSearchWindow(driver, lease_code_header, Condition, leasekind);

			waitForElement(driver, Elessorcode_searchicon);
			click(driver, Elessorcode_searchicon);
			twoColumnSearchWindow(driver, lessor_code_header, Condition, lessor_code);
			
			Extent_call(test, test1, "Ensure that system should enable size/type field only if lessor code is selected from the list");
		 	
			waitForElement(driver, Esizeandtype_tab);
			if (IsElementEnabled(driver, Esizeandtype_tab)) {
				System.out.println("Expected Result is: Size/Type tab should be enabled ||Actual Result is :Size/Type tab is enabled ");
				Extent_pass_New(driver, "Expected Result is: Size/Type tab should be enabled ||Actual Result is :Size/Type tab is enabled ", test, test1);
			} else {
				System.out.println("Expected Result is: Size/Type tab should be enabled ||Actual Result is :Size/Type tab is not enabled ");
				Extent_fail(driver, "Expected Result is: Size/Type tab should be enabled ||Actual Result is :Size/Type tab is not enabled ", test, test1);
			}
			
			Step_End(3, "Ensure that system should enable size/type field only if lessor code is selected from the list", test, test1);

			Extent_completed(tc_Name, test, test1);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		
		}
		int TC5=1;

		if(TC5==1)	 {
			String tc_Name="EMS_Contract_Registration_IP005";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
				String Search_input = data.get("Search_input");	
				String leasekind = data.get("leasekind");	
				String lessor_code = data.get("lessor_code");	
				String lessee_code = data.get("lessee_code");	
				String select_sizetype_msg = data.get("select_sizetype_msg");	
				String contract_no5 = data.get("contract_no5");	
				String ContractType5 = data.get("ContractType5");	
				String Condition = data.get("Condition");
				String lease_code_header = data.get("lease_code_header");
				String lessor_code_header = data.get("lessor_code_header");
				String lesee_code_header = data.get("lesee_code_header");

				
				 String contype_opt =String.format(DropDown_Select, ContractType5);

				Extent_Start(tc_Name, test, test1);

				
				
				Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

				moduleNavigate(driver, Search_input);
				
				Step_End(1, "Enter module name in searchbox & click the module", test, test1);
				
				
		    waitForElement(driver, Econtractno_field);
			   sendKeys(driver, Econtractno_field, contract_no5);
			   
			   waitForElement(driver, Econtracttype_field);
			   click(driver, Econtracttype_field);
			   waitForDisplay(driver, contract_types);
				 if(!isDisplayed(driver,contract_types)) {
					  click(driver, Econtracttype_field);
				 }
				
					 
					 waitForElement(driver, contype_opt);
				     click(driver, contype_opt);
					 
				 	
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
				
				Step_Start(2, " Ensure system should validate if user try to click add button without selecting size/type from size/type tab ", test, test1);
				waitForElement(driver, Esizeaddbutton);
				click(driver, Esizeaddbutton);
				Step_End(2, " Ensure system should validate if user try to click add button without selecting size/type from size/type tab ", test, test1);

				
				Step_Start(3, " Ensure that system should validate as 'Select the Sz./Tp'", test, test1);
				waitForPopup(driver, Popup_Message, select_sizetype_msg);
				String error_popup_msg3=getText(driver, Popup_Message);
				
				Extent_call(test, test1, "Ensure that system should validate as 'Select the Sz./Tp");
			 	
				if(error_popup_msg3.equals(select_sizetype_msg))
				{
					System.out.println("Matched || Expected popup was : "+select_sizetype_msg+" || Actual popup was : "+error_popup_msg3);
					Extent_pass_New(driver, "Matched || Expected popup was : "+select_sizetype_msg+" || Actual popup was : "+error_popup_msg3, test,test1);
				}
				else
				{
					System.out.println("Not Matched || Expected popup was : "+select_sizetype_msg+" || Actual popup was : "+error_popup_msg3);
					Extent_fail(driver,  "Not Matched || Expected popup was : "+select_sizetype_msg+" || Actual popup was : "+error_popup_msg3, test,test1);
				}
				
				Step_End(3, " Ensure that system should validate as 'Select the Sz./Tp'", test, test1);

				Extent_completed(tc_Name, test, test1);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		}

		int TC6=1;

		if(TC6==1) {

			String tc_Name="EMS_Contract_Registration_IP006";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
			String Search_input = data.get("Search_input");
			String leasekind = 	data.get("leasekind");
			String lessor_code = data.get("lessor_code");
			String lessee_code = data.get("lessee_code");
			String sizevalue = data.get("sizevalue");
			String select_leasetype_msg = data.get("select_leasetype_msg");
			String Contractno6 = data.get("Contractno6");	
			String ContractType6 = data.get("ContractType6");	
			String Condition = data.get("Condition");
			String lease_code_header = data.get("lease_code_header");
			String lessor_code_header = data.get("lessor_code_header");
			String lesee_code_header = data.get("lesee_code_header");

			
			
			 String contype_opt =String.format(DropDown_Select, ContractType6);
		     String sizevalue_opt =String.format(DropDown_Select, sizevalue);
				
			Extent_Start(tc_Name, test, test1);
			 

				
				
			
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
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		}

		int TC7=1;

		if(TC7==1) {
			
			String tc_Name="EMS_Contract_Registration_IP007";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
				String Search_input = data.get("Search_input");	
				String Contractno7 = data.get("Contractno7");	
				String ContractType7 = data.get("ContractType7");	
				String leasekind = data.get("leasekind");	
				String lessor_code = data.get("lessor_code");	
				String lessee_code = data.get("lessee_code");	
				String sizevalue = data.get("sizevalue");	
				String leasevalue = data.get("leasevalue");	
				String perdiem_msg = data.get("perdiem_msg");
				String date_Picker = data.get("date_Picker");
				String from_date = data.get("from_date");
				String to_date = data.get("to_date");
				String Condition = data.get("Condition");
				String lease_code_header = data.get("lease_code_header");
				String lessor_code_header = data.get("lessor_code_header");
				String lesee_code_header = data.get("lesee_code_header");

				
				 String contype_opt =String.format(DropDown_Select, ContractType7);
			     String sizevalue_opt =String.format(DropDown_Select, sizevalue);
				String leasevalue_opt=String.format(DropDown_Select, leasevalue);
				
				
				Extent_Start(tc_Name, test, test1);
				
					
				Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
				moduleNavigate(driver, Search_input);
				
				Step_End(1, "Enter module name in searchbox & click the module", test, test1);
		    
		    Extent_call(test, test1, "Ensure system should allow user to enter contract no & contract type");
		    
		    Step_Start(2, "Ensure system should allow user to enter contract no & contract type", test, test1);
		    waitForElement(driver, Econtractno_field);
			   sendKeys(driver, Econtractno_field, Contractno7);
			   
			   waitForElement(driver, Econtracttype_field);
			   click(driver, Econtracttype_field);
			   waitForDisplay(driver, contract_types);
				 if(!isDisplayed(driver,contract_types)) {
					  click(driver, Econtracttype_field);
				 }
				 
					 waitForElement(driver, contype_opt);
				     click(driver, contype_opt);
					    Step_End(2, "Ensure system should allow user to enter contract no & contract type", test, test1);
			
			     waitForElement(driver, Eleasekind_searchicon);
					click(driver,Eleasekind_searchicon);	
					twoColumnSearchWindow(driver, lease_code_header, Condition, leasekind);

					Extent_call(test, test1, "Ensure that should allow user to select Lessor & Lessor from that field");	
					Step_Start(3, " Ensure that should allow user to select Lessor & Lessor from that field", test, test1);
					waitForElement(driver, Elessorcode_searchicon);
					click(driver,Elessorcode_searchicon);
					twoColumnSearchWindow(driver, lessor_code_header, Condition, lessor_code);

					
					waitForElement(driver, Elessee_searchicon);
					click(driver,Elessee_searchicon);		
					twoColumnSearchWindow(driver, lesee_code_header, Condition, lessee_code);

					Step_End(3, " Ensure that should allow user to select Lessor & Lessor from that field", test, test1);
		
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
					Step_Start(5, "Ensure that system should able to select size type tab", test, test1);
					Extent_call(test, test1, "Ensure that system should able to click on Size/Type tab");
					waitForElement(driver, Esizeandtype_tab);
					click(driver, Esizeandtype_tab);
					waitForElement(driver, Esizeandtype_Field);
					click(driver,Esizeandtype_Field);
					
					waitForElement(driver, sizevalue_opt);
					click(driver, sizevalue_opt);
					Step_End(5, "Ensure that system should able to select size type tab", test, test1);

					Step_Start(6, "Ensure that system should able to select Lease charge type as 'No banding'", test, test1);
					Extent_call(test, test1, "Ensure that system should able to select Lease charge type as 'No banding'");
					
					waitForElement(driver, Eleasechargetype_Field);
					click(driver,Eleasechargetype_Field);
					waitForElement(driver, leasevalue_opt);
					click(driver, leasevalue_opt);
					Step_End(6, "Ensure that system should able to select Lease charge type as 'No banding'", test, test1);

					
					Step_Start(7, "Ensure that System should validate as 'Do you want to Proceed with perdiem 0.0' when user clicked add button without entering Per Diem", test, test1);
				
					waitForElement(driver, Esizeaddbutton);
					click(driver, Esizeaddbutton);

					waitForPopup(driver, popup_Message, perdiem_msg);
					String error_popup_msg5=getText(driver, popup_Message);
					
					Extent_call(test, test1, "Ensure that System should validate as 'Do you want to Proceed with perdiem 0.0' when user clicked add button without entering Per Diem");
				 	
					if(error_popup_msg5.equals(perdiem_msg))
					{
						System.out.println("Matched || Expected popup was : "+ perdiem_msg +" || Actual popup was : "+ error_popup_msg5);
						Extent_pass_New(driver, "Matched || Expected popup was : "+ perdiem_msg +" || Actual popup was : "+ error_popup_msg5, test,test1);
						click(driver, popup_Message_Yes_Button);

					}
					else
					{
						System.out.println("Not Matched || Expected popup was : "+ perdiem_msg +" || Actual popup was : "+ error_popup_msg5);
						Extent_fail(driver,  "Not Matched || Expected popup was : "+ perdiem_msg +" || Actual popup was : "+ error_popup_msg5, test,test1);
					}
					
					Step_End(7, "Ensure that System should validate as 'Do you want to Proceed with perdiem 0.0' when user clicked add button without entering Per Diem", test, test1);

					Extent_completed(tc_Name, test, test1);	

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		}

		int TC8=1;

		if(TC8==1) {
			
			String tc_Name="EMS_Contract_Registration_IP008";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
				String Search_input = data.get("Search_input");	
				String Contractno8 = data.get("Contractno8");	
				String ContractType8 = data.get("ContractType8");	
				String leasekind = data.get("leasekind");	
				String lessor_code = data.get("lessor_code");	
				String lessee_code = data.get("lessee_code");	
				String sizevalue = data.get("sizevalue");	
				String leasevalue = data.get("leasevalue");	
				String exist_sizetype = data.get("exist_sizetype");	
				String date_Picker = data.get("date_Picker");
				String from_date = data.get("from_date");
				String to_date = data.get("to_date");
				String Condition = data.get("Condition");
				String lease_code_header = data.get("lease_code_header");
				String lessor_code_header = data.get("lessor_code_header");
				String lesee_code_header = data.get("lesee_code_header");

				 String contype_opt =String.format(DropDown_Select, ContractType8);
			     String sizevalue_opt =String.format(DropDown_Select, sizevalue);
				String leasevalue_opt=String.format(DropDown_Select, leasevalue);
				 String sizevalue_opt1=String.format(DropDown_Select, sizevalue);
				 String leasevalue_opt1=String.format(DropDown_Select, leasevalue);
				 
				
				Extent_Start(tc_Name, test, test1);
				
					
				Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

				moduleNavigate(driver, Search_input);

				Step_End(1, "Enter module name in searchbox & click the module", test, test1);

				Extent_call(test, test1, "Ensure system should allow user to enter contract no & contract type");

				Step_Start(2, " Ensure system should allow user to enter contract no & contract type", test, test1);
				waitForElement(driver, Econtractno_field);
				sendKeys(driver, Econtractno_field, Contractno8);

				waitForElement(driver, Econtracttype_field);
				click(driver, Econtracttype_field);

				waitForDisplay(driver, contract_types);
				if(!isDisplayed(driver,contract_types)) {
					waitForElement(driver, Econtracttype_field);
					click(driver, Econtracttype_field);
				}


				waitForElement(driver, contype_opt);
				click(driver, contype_opt);
				Step_End(2, " Ensure system should allow user to enter contract no & contract type", test, test1);
				Step_Start(3, "Ensure that should allow user to select Lessor & Lessor from that field", test, test1);

				waitForElement(driver, Eleasekind_searchicon);
				click(driver,Eleasekind_searchicon);	
				twoColumnSearchWindow(driver, lease_code_header, Condition, leasekind);



				Extent_call(test, test1, " Ensure that should allow user to select Lessor & Lessor from that field");

				waitForElement(driver, Elessorcode_searchicon);
				click(driver,Elessorcode_searchicon);
				twoColumnSearchWindow(driver, lessor_code_header, Condition, lessor_code);


				waitForElement(driver, Elessee_searchicon);
				click(driver,Elessee_searchicon);		
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
				Step_End(5, " Ensure that system should able to click on Size/Type tab", test, test1);
				Step_Start(6, " Ensure that system should able to select size type", test, test1);
				waitForElement(driver, Esizeandtype_Field);
				click(driver,Esizeandtype_Field);
				waitForElement(driver, sizevalue_opt);
				click(driver, sizevalue_opt);
				Step_End(6, " Ensure that system should able to select size type", test, test1);
				Step_Start(7, "Ensure that system should able to select Lease charge type as 'No banding'", test, test1);
				Extent_call(test, test1, "Ensure that system should able to select Lease charge type as 'No banding'");

				waitForElement(driver, Eleasechargetype_Field);
				click(driver,Eleasechargetype_Field);
				waitForElement(driver, leasevalue_opt);
				click(driver, leasevalue_opt);
				Step_End(7, "Ensure that system should able to select Lease charge type as 'No banding'", test, test1);
				waitForElement(driver, Esizeaddbutton);
				click(driver, Esizeaddbutton);

				waitForElement(driver, yes_btn_D);
				click(driver, yes_btn_D);


				waitForElement(driver, Esizeandtype_Field);
				click(driver,Esizeandtype_Field);


				waitForElement(driver, sizevalue_opt1);
				click(driver, sizevalue_opt1);


				waitForElement(driver, Eleasechargetype_Field);
				click(driver,Eleasechargetype_Field);
				waitForElement(driver, leasevalue_opt1);
				click(driver, leasevalue_opt1);
				Step_Start(8, "Ensure that system should allow user to data into grid once 'Yes' option is pressed for 'proceed with per diem' message.", test, test1);
				Extent_call(test, test1, "Ensure that system should allow user to data into grid once 'Yes' option is pressed for 'proceed with per diem' message.");
				waitForElement(driver, Esizeaddbutton);
				click(driver, Esizeaddbutton);

				waitForElement(driver, yes_btn_D);
				click(driver, yes_btn_D);
				Step_End(8, "Ensure that system should allow user to data into grid once 'Yes' option is pressed for 'proceed with per diem' message.", test, test1);

				Extent_call(test, test1, "Ensure that system should validate as 'The Sz./Tp 20DC already exists' when user try to add same size & lease type combination multiple times");
				Step_Start(9, " Ensure that system should validate as 'The Sz./Tp 20DC already exists' when user try to add same size & lease type combination multiple times", test, test1);
				waitForPopup(driver, Popup_Message, exist_sizetype);
				String error_popup_msg6=getText(driver, Popup_Message);
				if(error_popup_msg6.contains(exist_sizetype))
				{
					System.out.println("Matched || Expected popup was : "+exist_sizetype+" || Actual popup was : "+error_popup_msg6);
					Extent_pass_New(driver, "Matched || Expected popup was : "+exist_sizetype+" || Actual popup was : "+error_popup_msg6, test,test1);
				}
				else
				{
					System.out.println("Not Matched || Expected popup was : "+exist_sizetype+" || Actual popup was : "+error_popup_msg6);
					Extent_fail(driver,  "Not Matched || Expected popup was : "+exist_sizetype+" || Actual popup was : "+error_popup_msg6, test,test1);
				}
				Step_End(9, " Ensure that system should validate as 'The Sz./Tp 20DC already exists' when user try to add same size & lease type combination multiple times", test, test1);

				Extent_completed(tc_Name, test, test1);	
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		}

		int TC9=1;

		if(TC9==1) {
			
			String tc_Name="EMS_Contract_Registration_IP009";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
				String Search_input = data.get("Search_input");	
				String ContractType9 = data.get("ContractType9");	
				String Contractno9 = data.get("Contractno9");	
				String leasekind = data.get("leasekind");	
				String lessor_code = data.get("lessor_code");	
				String lessee_code = data.get("lessee_code");	
				String sizevalue = data.get("sizevalue");	
				String leasevalue = data.get("leasevalue");	
				String PerDiem_Value = data.get("PerDiem_Value");	
				String remove_data_msg = data.get("remove_data_msg");	
				String date_Picker = data.get("date_Picker");
				String from_date = data.get("from_date");
				String to_date = data.get("to_date");
				String Condition = data.get("Condition");
				String lease_code_header = data.get("lease_code_header");
				String lessor_code_header = data.get("lessor_code_header");
				String lesee_code_header = data.get("lesee_code_header");

				 String contype_opt =String.format(DropDown_Select, ContractType9);
			     String sizevalue_opt =String.format(DropDown_Select, sizevalue);
				String leasevalue_opt=String.format(DropDown_Select, leasevalue);
			
				Extent_Start(tc_Name, test, test1);
				
					
				Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

				moduleNavigate(driver, Search_input);

				Step_End(1, "Enter module name in searchbox & click the module", test, test1);

				Extent_call(test, test1, "Ensure system should allow user to enter contract no & contract type");

				Step_Start(2, " Ensure system should allow user to enter contract no & contract type", test, test1);
				waitForElement(driver, Econtractno_field);
				sendKeys(driver, Econtractno_field, Contractno9);

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

				Step_Start(6, " Ensure that system should able to select size type", test, test1);
				waitForElement(driver, sizevalue_opt);
				click(driver, sizevalue_opt);
				Step_End(6, " Ensure that system should able to select size type", test, test1);

				Step_Start(7, "Ensure that system should able to select Lease charge type as 'No banding'", test, test1);
				Extent_call(test, test1, "Ensure that system should able to select Lease charge type as 'No banding'");

				waitForElement(driver, Eleasechargetype_Field);
				click(driver, Eleasechargetype_Field);

				Step_End(7, "Ensure that system should able to select Lease charge type as 'No banding'", test, test1);

				waitForElement(driver, leasevalue_opt);
				click(driver, leasevalue_opt);
				Step_Start(8,"Ensure that system should allow user to add data into grid once per diem is entered & add button is pressed",
						test, test1);
				waitForElement(driver, Eperdiem_field);
				clear(driver, Eperdiem_field);
					sendKeys(driver, Eperdiem_field, PerDiem_Value);
				//	enter(driver);
					
					waitForElement(driver, Esizeandtype_Field);
					click(driver, Esizeandtype_Field);
					
					Extent_call(test, test1, " Ensure that system should allow user to add data into grid once per diem is entered & add button is pressed");
					
					
					waitForElement(driver, Esizeaddbutton);
					click(driver, Esizeaddbutton);
					
					waitForElement(driver, grid_data_D);
					click(driver, grid_data_D);
					Step_End(8, "Ensure that system should allow user to add data into grid once per diem is entered & add button is pressed", test, test1);

					Extent_call(test, test1, "Ensure that data must be removed from grid once it is selected & clicked for 'Yes' from confrimation message");
					
					Step_Start(9, "Ensure that system should allow user to remove data once data is select & remove button is pressed", test, test1);
					waitForElement(driver, remove_btn_D);
					click(driver, remove_btn_D);
					Step_End(9, "Ensure that system should allow user to remove data once data is select & remove button is pressed", test, test1);
	               Step_Start(10, "Ensure that system should Validate as '  Are you sure you want to remove?' when user select data & wants to remove from grid", test, test1);
					waitForElement(driver, remove_popup_D);
					String error_popup_msg7=getText(driver, remove_popup_D);
					if(error_popup_msg7.equals(remove_data_msg)){
					
						Extent_call(test, test1, "Ensure that system should Validate as '  Are you sure you want to remove?' when user select data & wants to remove from grid");
						Step_Start(11, "Ensure that data must be removed from grid once it is selected & clicked for 'Yes' from confrimation message", test, test1);
						waitForElement(driver, remove_popup_yes_D);
						click(driver, remove_popup_yes_D);
						Step_End(11, "Ensure that data must be removed from grid once it is selected & clicked for 'Yes' from confrimation message", test, test1);

						System.out.println("Matched || Expected popup was : "+remove_data_msg+" || Actual popup was : "+error_popup_msg7);
						Extent_pass_New(driver, "Matched || Expected popup was : "+remove_data_msg+" || Actual popup was : "+error_popup_msg7, test,test1);
					}
					else
					{
						System.out.println("NotMatched || Expected popup was : "+remove_data_msg+" || Actual popup was : "+error_popup_msg7);
						Extent_fail(driver,  "NotMatched || Expected popup was : "+remove_data_msg+" || Actual popup was : "+error_popup_msg7, test,test1);
					}
					
					Step_End(10, "Ensure that system should Validate as '  Are you sure you want to remove?' when user select data & wants to remove from grid", test, test1);

					Extent_completed(tc_Name, test, test1);	


			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		}

		int TC10=1;

		if(TC10==1) {
			
			String tc_Name="EMS_Contract_Registration_IP010";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
				String Search_input = data.get("Search_input");	
				String Contractno10 = data.get("Contractno10");	
				String ContractType10 = data.get("ContractType10");	
				String leasekind = data.get("leasekind");	
				String lessor_code = data.get("lessor_code");	
				String lessee_code = data.get("lessee_code");	
				String sizevalue = data.get("sizevalue");	
				String leasevalue = data.get("leasevalue");	
				String PerDiem_Value = data.get("PerDiem_Value");	
				String locationhier_value = data.get("locationhier_value");	
				String date_Picker = data.get("date_Picker");
				String from_date = data.get("from_date");
				String to_date = data.get("to_date");
				String Condition = data.get("Condition");
				String lease_code_header = data.get("lease_code_header");
				String lessor_code_header = data.get("lessor_code_header");
				String lesee_code_header = data.get("lesee_code_header");

				 String contype_opt =String.format(DropDown_Select, ContractType10);
			     String sizevalue_opt =String.format(DropDown_Select, sizevalue);
				String leasevalue_opt=String.format(DropDown_Select, leasevalue);
				String locationhier1_value=String.format(Ems_Contract_Registration_Locators.locationhier1_value,locationhier_value);
				
				Extent_Start(tc_Name, test, test1);
					
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
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		}

		
	}
}
