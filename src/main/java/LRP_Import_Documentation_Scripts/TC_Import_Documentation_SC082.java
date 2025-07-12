package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC082 extends Keywords{

	public void Import_Documentation_SC082(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC082";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String attribute_Data = Excel_data.get("Attribute_Data");
		String global_Value = Excel_data.get("Global_Value");
		String global_Config_Module= Excel_data.get("GlobalConfigurationModule");
		String bill_NO = Excel_data.get("Bill_NO");
		String module_Search_Data=Excel_data.get("Module_Search");
		String customers=Excel_data.get("Customer_List");
		String Select_search_value_import = Excel_data.get("Select_search_value_import");
		String master_BL_Status = Excel_data.get("status_Check_New");
		String customer_search_data = Excel_data.get("customer_search_data");
		String Global_search_value1_Cus_Search = Excel_data.get("Global_search_value1_Cus_Search");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String cust_name_datas = Excel_data.get("cust_name_data");
		String cust_Address1_Datas = Excel_data.get("cust_Address1_Datas");
		String cust_Address2_Datas = Excel_data.get("cust_Address2_Datas");
		String Customer_Po_Box_No_datas = Excel_data.get("Customer_Po_Box_No_datas");
		String city_name_datas = Excel_data.get("city_name_datas");
		String customer_country_datas = Excel_data.get("customer_country_datas");
		String cust_zip_codes_datas = Excel_data.get("cust_zip_codes_datas");
		String cust_fax_numbers_datas = Excel_data.get("cust_fax_numbers_datas");
		String cust_mail_datas = Excel_data.get("cust_mail_datas");
		String cust_ph_numbers_datas = Excel_data.get("cust_ph_numbers_datas");
		String popup_After_Delete_Expected = Excel_data.get("popup_After_Delete_Expected");
		String popup_After_Delete_Expected1 = Excel_data.get("popup_After_Delete_Expected1");
		String default_Value = Excel_data.get("default_Value");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String do_you_want_to_delete = Excel_data.get("do_you_want_to_delete");
		
		String condition_Filter = Excel_data.get("ConditionFilter");
		String columns_to_print = Excel_data.get("columns_to_print");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String table_Name = Excel_data.get("table_Name");
		String country_Search_Header = Excel_data.get("Country_Search_Header");
		
		String all_Dropdown_1 = Excel_data.get("All_Dropdown_1");
		String all_Dropdown_2 = Excel_data.get("All_Dropdown_2");
		String pol_Value = Excel_data.get("POL_Loction");

		 Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		
		LRP_Login(driver, Username, Password);
		
		
		Extent_cal(test, test1, "Checking the visibility of Main menu");
		
		verifyMainMenu(driver);
		Step_Start(1, "switch the agency and open the global configuration", test, test1);
	   	
		SwitchProfile(driver, AgencyUser);
	
	   	Extent_call(test, test1, "********** Switch the Profile - End **********");	

	   	setGlobalConfiguration(driver, global_Config_Module, attribute_Data, global_Value);
	  
	   	Extent_call(test, test1, "********** Enter Import Documentation Module **********");

		moduleNavigate(driver, module_Search_Data);
		
		Step_End(8, "open the Import Documentation and Retrieve the new bill using tool bar search.(saved bill or new bill)", test, test1);

		Step_Start(9, "if the new bill go to the customer tab select and Double click the consignee customer or if the saved bill, click the edit button in tool bar and go to customer tab.", test, test1);
	
		if(BL_Retrive_Option.equals("By Service")) {
			
			newButton(driver);
			
			waitForElement(driver, ServiceInput_IMD );
			sendKeys(driver, ServiceInput_IMD , first_service_data);
			
			if(!Vessels.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC ,Vessels);
			}
			
			if(!Voyagenumber1.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC , Voyagenumber1);
			}
			
			if(!Boundinput.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Boundinput);
			}
			
			if(!portCode.trim().equals("")) {
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC , portCode);
			}
			
			if(!terminalCode.trim().equals("")) {
				horizontalscroll(driver, grid_scroll, 300);		
				click(driver, grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC , terminalCode);
			}
			
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			
			if(!pol_Value.trim().equals("")) {
				scrollTop(driver);
				waitForElement(driver, POLSearch);
				safeclick(driver, POLSearch);
				twoColumnSearchWindow(driver, Pol_Header, condition_Filter, pol_Value);
			}
			

			waitForElement(driver, all_Dropdown_1_IMD);
			click(driver, all_Dropdown_1_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_1);
			
			waitForElement(driver, all_Dropdown_2_IMD);
			click(driver, all_Dropdown_2_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_2);
			
			waitForElement(driver, show_BL_Button_IMD);
			safeclick(driver, show_BL_Button_IMD);
			
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);

			twoColumnSearchWindow(driver, BLNumber_Header, condition_Filter, bill_NO);


		}else if(BL_Retrive_Option.equals("By BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);
	
			globalValueSearchWindow(driver, dropdownCondition, Select_search_value_import, bill_NO, "", "", "", "");
	
		}	

		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
		if(!actual_Master_BL_Status.equals(master_BL_Status)) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			scrollBottom(driver);
		}
		
		waitForElement(driver, Customer_Tab_IMD);
		click(driver, Customer_Tab_IMD);
	
		Step_End(9, "if the new bill go to the customer tab select and Double click the consignee customer or if the saved bill, click the edit button in tool bar and go to customer tab.", test, test1);

		Step_Start(10, "consignee customer details has to be shown in above field.", test, test1);
	
		waitForElement(driver, Customer_Table_Row);
		
		List<String> print_columns = splitAndExpand(columns_to_print);
		
		List<Map<String, String>> cust_table_before = getTableData(driver, Customer_Table_Header, Customer_Table_Row);
		
		String table_before_changes = TableDataForReport(driver, cust_table_before, table_Name, print_columns);
		System.out.println("customer table before changes :"+table_before_changes);
		
		Extent_pass_New(driver, "<pre>"+table_before_changes+"<pre>", test, test1);
		
		Step_End(10, "consignee customer details has to be shown in above field.", test, test1);

		List<String> valid_Customers = splitAndExpand(customers);
		
		for(int i=0;i<valid_Customers.size();i++) {
			
			String select_Cust_Cell=String.format(Customer_Type_IMD,valid_Customers.get(i));
			List<String> customer_search_datas = splitAndExpand(customer_search_data);
			List<String> cust_name_data = splitAndExpand(cust_name_datas);
			List<String> cust_Address1_Data = splitAndExpand(cust_Address1_Datas);
			List<String> cust_Address2_Data = splitAndExpand(cust_Address2_Datas);
			List<String> Customer_Po_Box_No_data = splitAndExpand(Customer_Po_Box_No_datas);
			List<String> city_name_data = splitAndExpand(city_name_datas);
			List<String> customer_country_data = splitAndExpand(customer_country_datas);
			List<String> cust_zip_codes_data = splitAndExpand(cust_zip_codes_datas);
			List<String> cust_fax_numbers_data = splitAndExpand(cust_fax_numbers_datas);
			List<String> cust_mail_data = splitAndExpand(cust_mail_datas);
			List<String> cust_ph_numbers_data = splitAndExpand(cust_ph_numbers_datas);
			
			
			String cus_data = customer_search_datas.get(i);
			String cus_name = cust_name_data.get(i);
			String cust_Address1 = cust_Address1_Data.get(i);
			String cust_Address2 = cust_Address2_Data.get(i);
			String Customer_Po_Box_Number = Customer_Po_Box_No_data.get(i);
			String city_name = city_name_data.get(i);
			String customer_country = customer_country_data.get(i);
			String cust_zip_codes = cust_zip_codes_data.get(i);
			String cust_fax_number = cust_fax_numbers_data.get(i);
			String cust_mail = cust_mail_data.get(i);
			String cust_ph_number = cust_ph_numbers_data.get(i);

			
			doubleClick(driver, select_Cust_Cell);

			//1
			waitForElement(driver, Customer_Search);
			if(isClickable(driver, Customer_Search)) {
				System.out.println("Expected : Customer search icon Should be enable || Actual : Customer search icon is enabled");
				Extent_pass_New(driver, "Expected : Customer search icon Should be enable || Actual : Customer search icon is enabled", test, test1);
				if(!cus_data.trim().equals("")) {
					click(driver, Customer_Search);
					globalValueSearchWindow(driver, Dropdown_Condition, Global_search_value1_Cus_Search, cus_data, "", "", "", "");
				}
				
			} else {
				System.out.println("Expected : Customer search icon Should be enable || Actual : Customer search icon is not enabled");
				Extent_fail(driver, "Expected : Customer search icon Should be enable || Actual : Customer search icon is not enabled", test, test1);
			}
		

		// 2.customer name field
			waitForElement(driver, customer_Name_Field);
		if (isClickable(driver, customer_Name_Field)) {

			System.out.println("Expected : Customer Name field Should be enable || Actual : Customer Name Field is enabled");
			Extent_pass_New(driver, "Expected : Customer Name field Should be enable || Actual : Customer Name Field is enabled", test, test1);
			
			if(!cus_name.trim().equals("")) {
			click(driver, customer_Name_Field);
			clearAndType(driver, customer_Name_Field, cus_name);
			}
		} else {
			System.out.println("Expected : Customer Name field Should be enable || Actual : Customer Name Field is not enabled");
			Extent_fail(driver, "Expected : Customer Name field Should be enable || Actual : Customer Name Field is not enabled", test, test1);

		}
		
		//3.address1
		
		waitForElement(driver, Customer_Address1_TF);
		if(isClickable(driver, Customer_Address1_TF)) {
			
			System.out.println("Expected : Customer Address field1 Should be enable || Actual : Customer Address Field1 is enabled");
			Extent_pass_New(driver, "Expected : Customer Address field1 Should be enable || Actual : Customer Address Field1 is enabled", test, test1);
			
			if(!cust_Address1.trim().equals("")) {
			click(driver, Customer_Address1_TF);
			clearAndType(driver, Customer_Address1_TF, cust_Address1);}
			
		}else {
			
			System.out.println("Expected : Customer Address field1 Should be enable || Actual : Customer Address Field1 is not enabled");
			Extent_fail(driver, "Expected : Customer Address field1 Should be enable || Actual : Customer Address Field1 is not enabled", test, test1);
		}
		
		//4.address2
		waitForElement(driver, Customer_Address2_TF);
		if(isClickable(driver, Customer_Address2_TF)) {
			Extent_pass_New(driver, "Expected : Customer Address field2 Should be enable || Actual : Customer Address Field2 is enabled", test, test1);
			System.out.println("Expected : Customer Address field2 Should be enable || Actual : Customer Address Field2 is enabled");
			if(!cust_Address2.trim().equals("")) {
			click(driver, Customer_Address2_TF);
			clearAndType(driver, Customer_Address2_TF, cust_Address2);}
		}else {
			System.out.println("Expected : Customer Address field2 Should be enable || Actual : Customer Address Field2 is not enabled");
			Extent_fail(driver, "Expected : Customer Address field2 Should be enable || Actual : Customer Address Field2 is not enabled", test, test1);
		}
		
		
		//5.postbox number
		if(isClickable(driver, Customer_Po_Box_No)) {
			System.out.println("Expected : Customer post box number Should be enable || Actual : Customer post box number is enabled");
			Extent_pass_New(driver, "Expected : Customer post box number Should be enable || Actual : Customer post box number is enabled", test, test1);
			if(!Customer_Po_Box_Number.trim().equals("")) {
				click(driver,Customer_Po_Box_No); 
				clearAndType(driver, Customer_Po_Box_No,Customer_Po_Box_Number);
			}
				  
		}else {
			System.out.println("Expected : Customer post box number Should be enable || Actual : Customer post box number is not enabled");
			Extent_fail(driver, "Expected : Customer post box number Should be enable || Actual : Customer post box number is not enabled", test, test1);
		}
		
		
		//6city
		if(isClickable(driver, Customer_City_TF)) { 
			System.out.println("Expected : Customer city field Should be enable || Actual : Customer city field is enabled");
			Extent_pass_New(driver, "Expected : Customer city field Should be enable || Actual : Customer city field is enabled", test, test1);
			if(!city_name.trim().equals("")) {
				click(driver, Customer_City_TF); 
				clearAndType(driver, Customer_City_TF, city_name);
			}
		}else { 
			System.out.println("Expected : Customer city field Should be enable || Actual : Customer city field is not enabled");
			Extent_fail(driver, "Expected : Customer city field Should be enable || Actual : Customer city field is not enabled", test, test1);
		}
		
		
		//7.country
		if(isClickable(driver, Customer_Country_Search_Button)) {
			  System.out.println("Expected : Customer country search field Should be enable || Actual : Customer country search field is enabled");
			  Extent_pass_New(driver, "Expected : Customer country search field Should be enable || Actual : Customer country search field is enabled", test, test1);
		
			  if(!customer_country.trim().equals("")) {
				  waitForElement(driver, Customer_Country_Search_Button);
				  click(driver, Customer_Country_Search_Button);
				  twoColumnSearchWindow(driver, country_Search_Header, condition_Filter, customer_country);
			  }
		}else {
			  System.out.println("Expected : Customer country search field Should be enable || Actual : Customer country search field is not enabled");
			  Extent_fail(driver, "Expected : Customer country search field Should be enable || Actual : Customer country search field is not enabled", test, test1); 
		}
		
		
		//8zip code
		if(isClickable(driver, Customer_Zip_Code)) { 
			
			System.out.println("Expected : zipcode field Should be enable || Actual : zipcode field is enabled");
			Extent_pass_New(driver, "Expected : zipcode field Should be enable || Actual : zipcode field is enabled", test, test1);
				  
			if(!cust_zip_codes.trim().equals("")) {
				click(driver, Customer_Zip_Code); 
				clearAndType(driver, Customer_Zip_Code, cust_zip_codes);
			}
				  
		}else { 
			System.out.println("Expected : zipcode field Should be enable || Actual : zipcode field is not enabled");
			Extent_fail(driver, "Expected : zipcode field Should be enable || Actual : zipcode field is not enabled", test, test1); 
		}
		
		//9.ph no
		if(isClickable(driver, Customer_Phone_TF)) { 
			
			System.out.println("Expected : customer phone number field Should be enable || Actual : customer phone number field is enabled"); 
			Extent_pass_New(driver, "Expected : customer phone number field Should be enable || Actual : customer phone number field is enabled", test, test1);
			if(!cust_ph_number.trim().equals("")) {
				click(driver,Customer_Phone_TF);
				clearAndType(driver, Customer_Phone_TF, cust_ph_number);
			}
		
		}else {
			  System.out.println("Expected : customer phone number field Should be enable || Actual : customer phone number field is not enabled");
			  Extent_fail(driver, "Expected : customer phone number field Should be enable || Actual : customer phone number field is not enabled", test,
			  test1);
		}
			  
		//10mail
		  
		if(isClickable(driver, Customer_Mail_TF)) { 
			  System.out.println("Expected : customer mail field Should be enable || Actual : customer mail field is enabled"); 
			  Extent_pass_New(driver, "Expected : customer mail field Should be enable || Actual : customer mail field is enabled", test, test1);
			  if(!cust_mail.trim().equals("")) {
				  click(driver, Customer_Mail_TF);
				  clearAndType(driver, Customer_Mail_TF, cust_mail);
			  }
		}  else {
			  System.out.println("Expected : customer mail field Should be enable || Actual : customer mail field is not enabled");
			  Extent_fail(driver, "Expected : customer mail field Should be enable || Actual : customer mail field is not enabled", test, test1);
		}
			  
			  
			  //11fax
			  
		  if(isClickable(driver, Customer_Fax_TF)) { 
			  System.out.println("Expected : customer fax number field Should be enable || Actual : customer fax number field is enabled");
			  Extent_pass_New(driver, "Expected : customer fax number field Should be enable || Actual : customer fax number field is enabled", test, test1);
			  if(!cust_fax_number.trim().equals("")) {
				  click(driver, Customer_Fax_TF);
				  clearAndType(driver, Customer_Fax_TF, cust_fax_number);
			  }
		  }else {
			  System.out.println("Expected : customer fax number field Should be enable || Actual : customer fax number field is not enabled");
			  Extent_fail(driver, "Expected : customer fax number field Should be enable || Actual : customer fax number field is not enabled", test,
			  test1);
		  }
		
			  Step_Start(11, "once change the address or customer name or city or phone no. then click the add.", test, test1);

			  waitForElement(driver, Customer_Add);
			  click(driver, Customer_Add);
				
			  Step_End(11, "once change the address or customer name or city or phone no. then click the add.", test, test1);

			  waitForElement(driver, Customer_Table_Header);
			  List<Map<String, String>> tabledata = getTableData(driver, Customer_Table_Header, Customer_Table_Row);
				
	//1			
		if(!cus_data.trim().equals("")){
			String customer_Value = getValueByFirstColumnAndHeader(tabledata, "Customer Type", valid_Customers.get(i), "Customer Code");
			System.out.println("grid Value:"+customer_Value);
			if (cus_data.equals(customer_Value)) {
				System.out.println("Matched || Value taken from Test Data : " + cus_data+ " || Value taken from Commodity Grid : " + customer_Value);
				Extent_pass_New(driver, "Matched || Value taken from Test Data : " + cus_data+ " || Value taken from Commodity Grid : " + customer_Value, test,
						test1);
			} else {
				System.out.println("Not Matched || Value taken from Test Data : " + cus_data+ " || Value taken from Commodity Grid : " + customer_Value);
				Extent_fail(driver, "Not Matched || Value taken from Test Data : " + cus_data+ " || Value taken from Commodity Grid : " + customer_Value,
						test, test1);
			}
		}
		
		//2
		if(!cus_name.trim().equals("")){
			String customer_name_Value = getValueByFirstColumnAndHeader(tabledata, "Customer Type", valid_Customers.get(i), "Name");
			System.out.println("grid Value:"+customer_name_Value);

			if (cus_name.equals(customer_name_Value)) {
				System.out.println("Matched || Value taken from Test Data : " + cus_name+ " || Value taken from Commodity Grid : " + customer_name_Value);
				Extent_pass_New(driver, "Matched || Value taken from Test Data : " + cus_name+ " || Value taken from Commodity Grid : " + customer_name_Value, test,
						test1);
			} else {
				System.out.println("Not Matched || Value taken from Test Data : " + cus_name+ " || Value taken from Commodity Grid : " + customer_name_Value);
				Extent_fail(driver, "Not Matched || Value taken from Test Data : " + cus_name+ " || Value taken from Commodity Grid : " + customer_name_Value,
						test, test1);
			}
		}
		
		//3

		if(!cust_Address1.trim().equals("")){
			String address1_Value = getValueByFirstColumnAndHeader(tabledata, "Customer Type", valid_Customers.get(i), "Address1");
			System.out.println("grid Value:"+address1_Value);
			if (cust_Address1.equals(address1_Value)) {
				System.out.println("Matched || Value taken from Test Data : " + cust_Address1+ " || Value taken from Commodity Grid : " + address1_Value);
				Extent_pass_New(driver, "Matched || Value taken from Test Data : " + cust_Address1+ " || Value taken from Commodity Grid : " + address1_Value, test,
						test1);
			} else {
				System.out.println("NotMatched || Value taken from Test Data : " + cust_Address1+ " || Value taken from Commodity Grid : " + address1_Value);
				Extent_fail(driver, "NotMatched || Value taken from Test Data : " + cust_Address1+ " || Value taken from Commodity Grid : " + address1_Value,
						test, test1);
			}
		}
		
		//4

		if(!cust_Address2.trim().equals("")){
			String address2_Value = getValueByFirstColumnAndHeader(tabledata, "Customer Type", valid_Customers.get(i), "Address2");
			System.out.println("grid Value:"+address2_Value);
			if (cust_Address2.equals(address2_Value)) {
				System.out.println("Matched || Value taken from Test Data : " + cust_Address2+ " || Value taken from Commodity Grid : " + address2_Value);
				Extent_pass_New(driver, "Matched || Value taken from Test Data : " + cust_Address2+ " || Value taken from Commodity Grid : " + address2_Value, test,
						test1);
			} else {
				System.out.println("Not Matched || Value taken from Test Data : " + cust_Address2+ " || Value taken from Commodity Grid : " + address2_Value);
				Extent_fail(driver, "Not Matched || Value taken from Test Data : " + cust_Address2+ " || Value taken from Commodity Grid : " + address2_Value,
						test, test1);
			}
		}
		
		//5

		if(!Customer_Po_Box_Number.trim().equals("")){
			String po_Box_Value = getValueByFirstColumnAndHeader(tabledata, "Customer Type", valid_Customers.get(i), "P.O.Box");
			System.out.println("grid Value:"+po_Box_Value);
			if (Customer_Po_Box_Number.equals(po_Box_Value)) {
				System.out.println("Matched || Value taken from Test Data : " + Customer_Po_Box_Number+ " || Value taken from Commodity Grid : " + po_Box_Value);
				Extent_pass_New(driver, "Matched || Value taken from Test Data : " + Customer_Po_Box_Number+ " || Value taken from Commodity Grid : " + po_Box_Value, test,
						test1);
			} else {
				System.out.println("Not Matched || Value taken from Test Data : " + Customer_Po_Box_Number+ " || Value taken from Commodity Grid : " + po_Box_Value);
				Extent_fail(driver, "Not Matched || Value taken from Test Data : " + Customer_Po_Box_Number+ " || Value taken from Commodity Grid : " + po_Box_Value,
						test, test1);
			}
		}
		
		//6


		if(!city_name.trim().equals("")){
			
			String city_Value = getValueByFirstColumnAndHeader(tabledata, "Customer Type", valid_Customers.get(i), "City");
			System.out.println("grid Value:"+city_Value);
		
			if (city_name.equals(city_Value)) {
				System.out.println("Matched || Value taken from Test Data : " + city_name+ " || Value taken from Commodity Grid : " + city_Value);
				Extent_pass_New(driver, "Matched || Value taken from Test Data : " + city_name+ " || Value taken from Commodity Grid : " + city_Value, test,
						test1);
		
			} else {
				System.out.println("Not Matched || Value taken from Test Data : " + city_name+ " || Value taken from Commodity Grid : " + city_Value);
				Extent_fail(driver, "Not Matched || Value taken from Test Data : " + city_name+ " || Value taken from Commodity Grid : " + city_Value,
						test, test1);
			}
			
		}
		
//7


		if(!customer_country.trim().equals("")){
			
			String country_Value = getValueByFirstColumnAndHeader(tabledata, "Customer Type", valid_Customers.get(i), "Country");
			System.out.println("grid Value:"+country_Value);
		
			if (customer_country.equals(country_Value)) {
				System.out.println("Matched || Value taken from Test Data : " + customer_country+ " || Value taken from Commodity Grid : " + country_Value);
				Extent_pass_New(driver, "Matched || Value taken from Test Data : " + customer_country+ " || Value taken from Commodity Grid : " + country_Value, test,
						test1);
		
			} else {
				System.out.println("Not Matched || Value taken from Test Data : " + customer_country+ " || Value taken from Commodity Grid : " + country_Value);
				Extent_fail(driver, "Not Matched || Value taken from Test Data : " + customer_country+ " || Value taken from Commodity Grid : " + country_Value,
						test, test1);
			}
			
		}
		
//8


		if(!cust_zip_codes.trim().equals("")){
			
			String zip_Value = getValueByFirstColumnAndHeader(tabledata, "Customer Type", valid_Customers.get(i), "Zip");
			System.out.println("grid Value:"+zip_Value);
		
			if (cust_zip_codes.equals(zip_Value)) {
				System.out.println("Matched || Value taken from Test Data : " + cust_zip_codes+ " || Value taken from Commodity Grid : " + zip_Value);
				Extent_pass_New(driver, "Matched || Value taken from Test Data : " + cust_zip_codes+ " || Value taken from Commodity Grid : " + zip_Value, test,
						test1);
		
			} else {
				System.out.println("Not Matched || Value taken from Test Data : " + cust_zip_codes+ " || Value taken from Commodity Grid : " + zip_Value);
				Extent_fail(driver, "Not Matched || Value taken from Test Data : " + cust_zip_codes+ " || Value taken from Commodity Grid : " + zip_Value,
						test, test1);
			}
			
		}
		
		//9

		if(!cust_fax_number.trim().equals("")){
			
			String fax_Value = getValueByFirstColumnAndHeader(tabledata, "Customer Type", valid_Customers.get(i), "Fax");
			System.out.println("grid Value:"+fax_Value );
		
			if (cust_fax_number.equals(fax_Value )) {
				System.out.println("Matched || Value taken from Test Data : " + cust_fax_number+ " || Value taken from Commodity Grid : " + fax_Value );
				Extent_pass_New(driver, "Matched || Value taken from Test Data : " + cust_fax_number+ " || Value taken from Commodity Grid : " + fax_Value , test,
						test1);
		
			} else {
				System.out.println("Not  Matched || Value taken from Test Data : " + cust_fax_number + " || Value taken from Commodity Grid : " + fax_Value );
				Extent_fail(driver, "NotMatched || Value taken from Test Data : " + cust_fax_number + " || Value taken from Commodity Grid : " + fax_Value ,
						test, test1);
			}
			
		}
		
//10

		if(!cust_mail.trim().equals("")){
			
			String mail_Value = getValueByFirstColumnAndHeader(tabledata, "Customer Type", valid_Customers.get(i), "Email");
			System.out.println("grid Value:"+mail_Value );
		
			if (cust_mail.equals(mail_Value )) {
				System.out.println("Matched || Value taken from Test Data : " + cust_mail+ " || Value taken from Commodity Grid : " + mail_Value );
				Extent_pass_New(driver, "Matched || Value taken from Test Data : " + cust_mail+ " || Value taken from Commodity Grid : " + mail_Value , test,
						test1);
		
			} else {
				System.out.println("Not Matched || Value taken from Test Data : " + cust_mail + " || Value taken from Commodity Grid : " + mail_Value );
				Extent_fail(driver, "Not Matched || Value taken from Test Data : " + cust_mail + " || Value taken from Commodity Grid : " + mail_Value ,
						test, test1);
			}
			
		}
		
			
		}
		
		
		Step_Start(17, "save the import documentation.", test, test1);
		
		List<Map<String, String>> cust_table_after1 = getTableData(driver, Customer_Table_Header, Customer_Table_Row);
		
		String table_after_changes = TableDataForReport(driver, cust_table_after1, table_Name, print_columns);
		System.out.println("customer table after changes :"+table_after_changes);
		
		Extent_pass_New(driver, "<pre>"+table_after_changes+"<pre>", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, "Import Documentation Saved");

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		Step_End(17, "save the import documentation.", test, test1);
		Extent_call(test, test1, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar");
	
		Step_Start(18, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar,click the delete icon and system has validate( Do you want to delete import documentation )? -> YES or N0", test, test1);
		Step_Start(19, "click the yes and system has validate import documentation is deleted", test, test1);

		scrollTop(driver);		
		if(do_you_want_to_delete.equalsIgnoreCase("yes")) {
			deleteImportDocument(driver, popup_After_Delete_Expected, popup_After_Delete_Expected1);
		}
		Step_End(18, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar ,click the delete icon and system has validate( Do you want to delete import documentation )? -> YES or N0", test, test1);

		Step_End(19, "click the yes and system has validate import documentation is deleted", test, test1);

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		
		//reset the global data 
		Step_Start(20, "Open the global configuration", test, test1);
				
		reSetGlobalConfiguration(driver, "Yes", global_Config_Module, attribute_Data, default_Value);
		Step_End(20, "Open the global configuration", test, test1);
		Extent_completed(testcase_Name, test, test1);
		
	}
}
