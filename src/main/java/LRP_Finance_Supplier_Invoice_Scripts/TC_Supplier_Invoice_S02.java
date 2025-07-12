package LRP_Finance_Supplier_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Supplier_Invoice_S02  extends Keywords{
	public void  Supplier_Invoice_S02(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Supplier_Invoice_S02";
		
		



		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("Password");
		String Field_Names =Excel_data.get("Field_Names");
		String Activity_date_perform =Excel_data.get("Activity_date_perform");
		String activity_Date_Input =Excel_data.get("activity_Date_Input");
		String invoice_date_perform =Excel_data.get("invoice_date_perform");
		String invoice_Date_Input =Excel_data.get("invoice_Date_Input");
		String Due_date_perform =Excel_data.get("Due_date_perform");
		String Due_Date_Input =Excel_data.get("Due_Date_Input");
		String Discription_input =Excel_data.get("Discription_input");
		String Nomination_name =Excel_data.get("Nomination_name");
		String Nomination_Amount =Excel_data.get("Nomination_Amount");
		String Currency_code =Excel_data.get("Currency_code");
		String dropdownCondition =Excel_data.get("dropdownCondition");
		String Nomination_name_CR =Excel_data.get("Nomination_name_CR");
		String Nomination_Amount_CR =Excel_data.get("Nomination_Amount_CR");
		String Currency_code_CR =Excel_data.get("Currency_code_CR");
		String Billing_saved_popup =Excel_data.get("Billing_saved_popup");
		String status = Excel_data.get("Status");
		String globalSearchFilterOption_Customer1_Dr = Excel_data.get("GlobalSearchFilterOption_Customer1_Dr");
		String globalSearch_Value2_Dr = Excel_data.get("Inside_customer_Dr");
		String globalSearchFilterOption_Bol_Dr = Excel_data.get("GlobalSearchFilterOption_Bol_Dr");
		String globalSearch_Value_Bol_Dr = Excel_data.get("GlobalSearch_Value_Bol_Dr");
		String service_Code_Dr = Excel_data.get("Service_Code_Dr");
		String vessel_Code_Dr = Excel_data.get("Vessel_Code_Dr");
		String voyage_Dr = Excel_data.get("Voyage_Dr");
		String portCode_Dr = Excel_data.get("PortCode_Dr");
		String agency_Dr = Excel_data.get("Agency_Dr");
		String firstServiceCode_Dr = Excel_data.get("FirstServiceCode_Dr");
		String firstVesselCode_Dr = Excel_data.get("FirstVesselCode_Dr");
		String firstVoyageBoundCode_Dr = Excel_data.get("FirstVoyageBoundCode_Dr");
		String lastServiceCode_Dr = Excel_data.get("LastServiceCode_Dr");
		String quantity_Dr = Excel_data.get("Quantity_Dr");
		String fuelGrade_Dr = Excel_data.get("FuelGrade_Dr");
		String unitPrice_Dr = Excel_data.get("UnitPrice_Dr");
		String lastVesselCode_Dr = Excel_data.get("LastVesselCode_Dr");
		String lastVoyageBoundCode_Dr = Excel_data.get("LastVoyageBoundCode_Dr");
		String dischargePortCode_Dr = Excel_data.get("DischargePortCode_Dr");
		String tax_Code_Data_Dr = Excel_data.get("tax_Code_Data_Dr");
		String flow_Code_Data_Dr = Excel_data.get("flow_Code_Data_Dr");
		String fuel_Type_Data_Dr = Excel_data.get("fuel_Type_Data_Dr");
		String company_Code_Data_Dr = Excel_data.get("company_Code_Data_Dr");
		String contract_Num_Data_Dr = Excel_data.get("contract_Num_Data_Dr");
		String reference_Data_Dr = Excel_data.get("reference_Data_Dr");
		String department_Data_Dr = Excel_data.get("department_Data_Dr");
		String employee_Data_Dr = Excel_data.get("employee_Data_Dr");
		String eqp_Type_Data_Dr = Excel_data.get("eqp_Type_Data_Dr");
		String depot_Cfs_Terminal_Data_Dr = Excel_data.get("depot_Cfs_Terminal_Data_Dr");
		String global_Search_Option1_Vendor_Dr = Excel_data.get("global_Search_Option1_Vendor_Dr");
		String global_Search_Value1_Vendor_Code_Dr = Excel_data.get("global_Search_Value1_Vendor_Code_Dr");
		String financial_Category_Data_Dr = Excel_data.get("financial_Category_Data_Dr");
		String globalSearchFilterOption_Customer1_Cr = Excel_data.get("GlobalSearchFilterOption_Customer1_Cr");
		String globalSearch_Value1_Cr = Excel_data.get("inside_customer_Cr");
		String globalSearchFilterOption_Bol_Cr = Excel_data.get("GlobalSearchFilterOption_Bol_Cr");
		String globalSearch_Value_Bol_Cr = Excel_data.get("GlobalSearch_Value_Bol_Cr");
		String service_Code_Cr = Excel_data.get("Service_Code_Cr");
		String vessel_Code_Cr = Excel_data.get("Vessel_Code_Cr");
		String voyage_Cr = Excel_data.get("Voyage_Cr");
		String portCode_Cr = Excel_data.get("PortCode_Cr");
		String agency_Cr = Excel_data.get("Agency_Cr");
		String firstServiceCode_Cr = Excel_data.get("FirstServiceCode_Cr");
		String firstVesselCode_Cr = Excel_data.get("FirstVesselCode_Cr");
		String firstVoyageBoundCode_Cr = Excel_data.get("FirstVoyageBoundCode_Cr");
		String lastServiceCode_Cr = Excel_data.get("LastServiceCode_Cr");
		String quantity_Cr = Excel_data.get("Quantity_Cr");
		String fuelGrade_Cr = Excel_data.get("FuelGrade_Cr");
		String unitPrice_Cr = Excel_data.get("UnitPrice_Cr");
		String lastVesselCode_Cr = Excel_data.get("LastVesselCode_Cr");
		String lastVoyageBoundCode_Cr = Excel_data.get("LastVoyageBoundCode_Cr");
		String dischargePortCode_Cr = Excel_data.get("DischargePortCode_Cr");
		String tax_Code_Data_Cr = Excel_data.get("tax_Code_Data_Cr");
		String flow_Code_Data_Cr = Excel_data.get("flow_Code_Data_Cr");
		String fuel_Type_Data_Cr = Excel_data.get("fuel_Type_Data_Cr");
		String company_Code_Data_Cr = Excel_data.get("company_Code_Data_Cr");
		String contract_Num_Data_Cr = Excel_data.get("contract_Num_Data_Cr");
		String reference_Data_Cr = Excel_data.get("reference_Data_Cr");
		String department_Data_Cr = Excel_data.get("department_Data_Cr");
		String employee_Data_Cr = Excel_data.get("employee_Data_Cr");
		String eqp_Type_Data_Cr = Excel_data.get("eqp_Type_Data_Cr");
		String depot_Cfs_Terminal_Data_Cr = Excel_data.get("depot_Cfs_Terminal_Data_Cr");
		String global_Search_Option1_Vendor_Cr = Excel_data.get("global_Search_Option1_Vendor_Cr");
		String global_Search_Value1_Vendor_Code_Cr = Excel_data.get("global_Search_Value1_Vendor_Code_Cr");
		String financial_Category_Data_Cr = Excel_data.get("financial_Category_Data_Cr");
		String vendor_name = Excel_data.get("vendor_code");
		String supplier_input_value = Excel_data.get("supplier_input_value");
		String SupplierInv_input_value = Excel_data.get("SupplierInv_input_value");
		String supplier_area_input_value = Excel_data.get("supplier_area_input_value");
		String supplier_factor_payee_input_value = Excel_data.get("supplier_factor_payee_input_value");
		String Vendor_Code_Header  = Excel_data.get("Vendor_Code_Header");
		String Payment_Code_Header  = Excel_data.get("Payment_Code_Header");
		String Factor_Payee_Header  = Excel_data.get("Factor_Payee_Header");
		String Area_Master_Header  = Excel_data.get("Area_Master_Header");
		String Search_Nominals_Header  = Excel_data.get("Search_Nominals_Header");
		String Currency_Details_Header  = Excel_data.get("Currency_Details_Header");
		String Main_Service_Select_Header =Excel_data.get("Main_Service_Select_Header");
		String Main_Vessel_Select_Header =Excel_data.get("Main_Vessel_Select_Header");
		String Main_Voyage_Select_Header =Excel_data.get("Main_Voyage_Select_Header");	
		String First_Service_Select_Header =Excel_data.get("First_Service_Select_Header");
		String First_Vessel_Select_Header = Excel_data.get("First_Vessel_Select_Header");
		String First_Voyage_Select_Header = Excel_data.get("First_Voyage_Select_Header");
		String Last_Service_Select_Header =Excel_data.get("Last_Service_Select_Header");
		String Last_Voyage_Select_Header = Excel_data.get("Last_Voyage_Select_Header");
		String Last_Vessel_Select_Header = Excel_data.get("Last_Vessel_Select_Header");
		String Discharge_Port_Select_Header = Excel_data.get("Discharge_Port_Select_Header");
		String Port_Select_Header = Excel_data.get("Port_Select_Header");
		String Depot_Select_Header = Excel_data.get("Depot_Select_Header");
		String Eqp_Select_Header = Excel_data.get("Eqp_Select_Header");
		String Agency_Select_Header = Excel_data.get("Agency_Select_Header");
		String Employee_Select_Header = Excel_data.get("Employee_Select_Header");
		String Department_Select_Header = Excel_data.get("Department_Select_Header");
		String Fuel_Select_Header = Excel_data.get("Fuel_Select_Header");
		String Contract_Select_Header = Excel_data.get("Contract_Select_Header");
		String Company_Select_Header = Excel_data.get("Company_Select_Header");
		String Fuel_Type_Select_Header = Excel_data.get("Fuel_Type_Select_Header");
		String Flow_Code_Header = Excel_data.get("Flow_Code_Header");
		String Finance_Category_Header = Excel_data.get("Finance_Category_Header");
		String Tax_Code_Header = Excel_data.get("Tax_Code_Header");
		String Reference_Select_Header = Excel_data.get("Reference_Select_Header");
		String Two_coloum_condition = Excel_data.get("Two_coloum_condition");
		String Nominal_Select_Header = Excel_data.get("Nominal_Select_Header");
		String CurrencyCode_Select_Header = Excel_data.get("CurrencyCode_Select_Header");
		String Refer_Input = Excel_data.get("Refer_Input");	


		Extent_Start(testcase_Name, test, test1);

		//Login
		navigateUrl(driver, url);                                                                                                  
		LRP_Login(driver, username, pass_word);

		moduleNavigate(driver, Field_Names);
		Step_Start(1, " Click on New button in toolbar ", test, test1);

		newButton(driver);

		Step_End(1, " Click on New button in toolbar ", test, test1);


		Step_Start(2, "Select the Activity date from the date picker .", test, test1);
		waitForElement(driver, supplier_invoice_activity_date);
		if (Activity_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, supplier_invoice_activity_date, activity_Date_Input);

		} else {
			waitForElement(driver, supplier_invoice_activity_date);
			clearAndType(driver, supplier_invoice_activity_date, activity_Date_Input);
		}
		Step_End(2, "Select the Activity date from the date picker .", test, test1);

		Step_Start(3, "Select the Invoice date from the date picker. .", test, test1);
		waitForElement(driver, supplier_invoice_invoice_date);
		if (invoice_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, supplier_invoice_invoice_date, invoice_Date_Input);

		} else {
			waitForElement(driver, supplier_invoice_invoice_date);
			clearAndType(driver, supplier_invoice_invoice_date, invoice_Date_Input);
		}
		Step_End(3, "Select the Invoice date from the date picker. .", test, test1);
		Step_Start(4, "Select the Due date from the date picker.", test, test1);
		waitForElement(driver, supplier_invoice_Due_date);
		if (Due_date_perform.equalsIgnoreCase("Yes")) {

			selectDatePicker(driver, supplier_invoice_Due_date, Due_Date_Input);

		} else {
			waitForElement(driver, supplier_invoice_Due_date);
			clearAndType(driver, supplier_invoice_Due_date, Due_Date_Input);
		}
		Step_End(4, "Select the Due date from the date picker.", test, test1);


		
		waitForDisplay(driver, SupplierInv_input);
		if(isdisplayed(driver, SupplierInv_input)&&!SupplierInv_input_value.equals("")) {
		 waitForElement(driver, SupplierInv_input);
         sendKeys(driver, SupplierInv_input, SupplierInv_input_value);
		}
		
		waitForDisplay(driver, SI_Refernce_Input);
		if(isdisplayed(driver, SI_Refernce_Input)&&!Refer_Input.equals("")) {
			 waitForElement(driver, SI_Refernce_Input);
			 sendKeys(driver, SI_Refernce_Input, Refer_Input);
		}
		
		
		waitForDisplay(driver, Supplier_vendor_search_button);
		if(isdisplayed(driver, Supplier_vendor_search_button)&&!vendor_name.equals("")) {
		Step_Start(5, "Select the vendor.", test, test1);
		
		waitForElement(driver, Supplier_vendor_search_button);
		click(driver,Supplier_vendor_search_button);
		
		twoColumnSearchWindow(driver, Vendor_Code_Header, dropdownCondition, vendor_name);
		
		Step_End(5, "Select the vendor.", test, test1);
		}
		
		
		waitForDisplay(driver, Supplier_payment_search);
		if(isdisplayed(driver, Supplier_payment_search)&&!supplier_input_value.equals("")) {
		waitForElement(driver, Supplier_payment_search);
		click(driver,Supplier_payment_search);
		twoColumnSearchWindow(driver, Payment_Code_Header, dropdownCondition, supplier_input_value);
		}

		
		
		waitForDisplay(driver, Supplier_factor_payee_search);
		if(isdisplayed(driver, Supplier_factor_payee_search)&&!supplier_factor_payee_input_value.equals("")) {
		waitForElement(driver, Supplier_factor_payee_search);
		click(driver,Supplier_factor_payee_search);
		twoColumnSearchWindow(driver, Factor_Payee_Header, dropdownCondition, supplier_factor_payee_input_value);
		}

		waitForDisplay(driver, Supplier_Area_search);
		if(isdisplayed(driver, Supplier_Area_search)&&!supplier_area_input_value.equals("")) {
		waitForElement(driver, Supplier_Area_search);
		click(driver,Supplier_Area_search);
		twoColumnSearchWindow(driver, Area_Master_Header, dropdownCondition, supplier_area_input_value);
		}
		
		Step_Start(6, "Based on your activity date open period will automatically changed. ", test, test1);
		waitForElement(driver, Supplier_open_peroid);
		String open_period_value = getText(driver, Supplier_open_peroid);
		System.out.println(open_period_value);
		Extent_call(test, test1, "**open period shows***"+open_period_value);
		Step_End(6, "Based on your activity date open period will automatically changed. ", test, test1);
		Step_Start(7, "Enter Alphanumeric characters in description field ", test, test1);

		waitForDisplay(driver, Supplier_Discription_input);
		if(isdisplayed(driver, Supplier_Discription_input)&&!Discription_input.equals("")) {
		
		waitForElement(driver, Supplier_Discription_input);
		sendKeys(driver, Supplier_Discription_input, Discription_input);
		
		}
		
		Step_End(7, "Enter Alphanumeric characters in description field ", test, test1);
		Step_Start(8, "Select the dr/cr in that dropdown list ", test, test1);
		waitForElement(driver, Supplier_Dr_cr_droupdwn);
		click(driver,Supplier_Dr_cr_droupdwn);
		waitForElement(driver, select_dr);
		click(driver,select_dr);
		Step_End(8, "Select the dr/cr in that dropdown list ", test, test1);
		Step_Start(9, "Select the nominal from the search button for Dr. ", test, test1);

		
		waitForDisplay(driver, Supplier_nomination_search);
		if(isdisplayed(driver, Supplier_nomination_search)&&!Nomination_name.equals("")) {
			waitForElement(driver, Supplier_nomination_search);
			click(driver,Supplier_nomination_search);
			twoColumnSearchWindow(driver, Search_Nominals_Header, dropdownCondition, Nomination_name);
		}
		

		Step_End(9, "Select the nominal from the search button for Dr. ", test, test1);
		Step_Start(11, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change.. ", test, test1);
		
		waitForDisplay(driver, Supplier_currency_search);
		if(isdisplayed(driver, Supplier_currency_search)&&!Currency_code.equals("")) {
		waitForElement(driver, Supplier_currency_search);
		click(driver,Supplier_currency_search);
		twoColumnSearchWindow(driver, Currency_Details_Header, dropdownCondition, Currency_code);
		}
		
		
		Step_End(11, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change.. ", test, test1);
		Step_Start(10, "Enter the valid amount in amount text field for Dr. ", test, test1);
		waitForElement(driver, Supplier_amount_field);
		doubleClick(driver, Supplier_amount_field);
		Actionsendkeys(driver, Supplier_amount_field, Nomination_Amount);
		click(driver, Home_amount1);
		Step_End(10, "Enter the valid amount in amount text field for Dr. ", test, test1);
		Step_Start(12, "Click + button to add the nominals in the grid.", test, test1);
		waitForElement(driver, Supplier_Gird_add_button);
		click(driver,Supplier_Gird_add_button);
		Step_End(12, "Click + button to add the nominals in the grid.", test, test1);
		if(isdisplayed(driver, ID_Popup_Ok_Button1)) {
			click(driver, ID_Popup_Ok_Button1);

		}
		if(isdisplayed(driver, ID_Popup_Ok_Button2)) {
			click(driver, ID_Popup_Ok_Button2);

		}

		//bill of lading
		if(isdisplayed(driver, billOfLading_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, billOfLading_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, billOfLading_SearchButton_BL1);
				globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Bol_Dr, globalSearch_Value_Bol_Dr, "","", "", "");	

				waitForElement(driver, accountTransElements11);

			}
		}

		//main line service
		if(isdisplayed(driver, mainLineService_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineService_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineService_SearchButton_BL1);
				twoColumnSearchWindow(driver, Main_Service_Select_Header, Two_coloum_condition, service_Code_Dr);
				waitForElement(driver, accountTransElements11);

			}
		}

		//main line vessel

		if(isdisplayed(driver, mainLineVessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVessel_SearchButton_BL1);
				twoColumnSearchWindow(driver, Main_Vessel_Select_Header, Two_coloum_condition, vessel_Code_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//  main line voyage bound

		if(isdisplayed(driver, mainLineVoyageBound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVoyageBound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVoyageBound_SearchButton_BL1);
				twoColumnSearchWindow(driver, Main_Voyage_Select_Header, Two_coloum_condition, voyage_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//  First Service

		if(isdisplayed(driver, first_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstService_SearchButton_BL1);
				twoColumnSearchWindow(driver, First_Service_Select_Header, Two_coloum_condition, firstServiceCode_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//  First Vessel

		if(isdisplayed(driver, first_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstVessel_SearchButton_BL1);
				twoColumnSearchWindow(driver, First_Vessel_Select_Header, Two_coloum_condition, firstVesselCode_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//  First Voyage/Bound

		if(isdisplayed(driver, first_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstVoyage_Bound_SearchButton11);
				twoColumnSearchWindow(driver, First_Voyage_Select_Header, Two_coloum_condition, firstVoyageBoundCode_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//  Last Service

		if(isdisplayed(driver, last_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastService_SearchButton_BL1);
				twoColumnSearchWindow(driver, Last_Service_Select_Header, Two_coloum_condition, lastServiceCode_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//  Last Voyage/Bound

		if(isdisplayed(driver, last_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVoyage_Bound_SearchButton_BL1);
				twoColumnSearchWindow(driver, Last_Voyage_Select_Header, Two_coloum_condition, lastVoyageBoundCode_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//  Location/Port Of Origin	

		if(isdisplayed(driver, location_PortOfOrigin_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_PortOfOrigin_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_PortOfOrigin_SearchButton_BL1);
				twoColumnSearchWindow(driver, Port_Select_Header, Two_coloum_condition, portCode_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//  Location/Port Of Discharge	
		if(isdisplayed(driver, location_Pod_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_Pod_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_Port_Of_Discharge_SearchButton_BL1);
				twoColumnSearchWindow(driver, Discharge_Port_Select_Header, Two_coloum_condition, dischargePortCode_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//depot_cfs
		if(isdisplayed(driver, depot_Cfs_Terminal_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, depot_Cfs_Terminal_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, depot_CFS_Terminal_SearchButton_BL1);
				twoColumnSearchWindow(driver, Depot_Select_Header, Two_coloum_condition, depot_Cfs_Terminal_Data_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//eqp_type
		if(isdisplayed(driver, eqpType_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, eqpType_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, eqpType_SearchButton_BL1);
				twoColumnSearchWindow(driver, Eqp_Select_Header, Two_coloum_condition, eqp_Type_Data_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//				Quantity

		if(isdisplayed(driver, quantity_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, quantity_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				waitForElement(driver, quantity_Textfield_JNL);
				sendKeys(driver, quantity_Textfield_JNL, quantity_Dr);
				waitForElement(driver, accountTransElements11);

			}
		}


		//				Agency

		if(isdisplayed(driver, SI_agency_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, SI_agency_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, agency_SearchButton_BL1);
				twoColumnSearchWindow(driver, Agency_Select_Header, Two_coloum_condition, agency_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//vendor
		if(isdisplayed(driver, vendor_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, vendor_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, vendor_SearchButton_BL1);
				globalValueSearchWindow(driver, dropdownCondition, global_Search_Option1_Vendor_Dr, global_Search_Value1_Vendor_Code_Dr, "", "", "", "");

				waitForElement(driver, accountTransElements11);

			}
		}

		// Customer			
		if(isdisplayed(driver, customer_Checkbox)) {
			String actualStatus=getAttribute(driver, customer_Checkbox, "class");
			if(actualStatus.contains(status)) {
				click(driver, customerSearchButton11);
				globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Customer1_Dr, globalSearch_Value2_Dr, "", "", "", "");

				waitForElement(driver, accountTransElements11);


			}
		}
		if(isdisplayed(driver, ID_Popup_Ok_Button3)) {
			click(driver, ID_Popup_Ok_Button3);

		}



		//employee
		if(isdisplayed(driver, employee_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, employee_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, employee_SearchButton_BL1);
				twoColumnSearchWindow(driver, Employee_Select_Header, Two_coloum_condition, employee_Data_Dr);
				waitForElement(driver, accountTransElements11);

			}
		}


		//departments
		if(isdisplayed(driver, departments_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, departments_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, departments_SearchButton_BL1);
				twoColumnSearchWindow(driver, Department_Select_Header, Two_coloum_condition, department_Data_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//	Fuel Grade

		if(isdisplayed(driver,fuel_Grade_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Grade_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, fuelGrade_SearchButton_BL1);
				twoColumnSearchWindow(driver, Fuel_Select_Header, Two_coloum_condition, fuelGrade_Dr);
				waitForElement(driver, accountTransElements11);

			}
		}

		//  Last Vessel

		if(isdisplayed(driver, last_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVessel_SearchButton_BL1);
				twoColumnSearchWindow(driver, Last_Vessel_Select_Header, Two_coloum_condition, lastVesselCode_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//contract_number
		if(isdisplayed(driver, contract_Num_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, contract_Num_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, contractNumber_SearchButton_BL1);
				twoColumnSearchWindow(driver, Contract_Select_Header, Two_coloum_condition, contract_Num_Data_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//inter company
		if(isdisplayed(driver, inter_Company_Codes_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, inter_Company_Codes_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, interCompanyCodes_SearchButton_BL1);
				twoColumnSearchWindow(driver, Company_Select_Header, Two_coloum_condition, company_Code_Data_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//fuel type
		if(isdisplayed(driver, fuel_Type_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Type_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, fuelType_SearchButton_BL1);
				twoColumnSearchWindow(driver, Fuel_Type_Select_Header, Two_coloum_condition, fuel_Type_Data_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//flow element
		if(isdisplayed(driver, flow_Element_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, flow_Element_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, flowElement_SearchButton_BL1);
				twoColumnSearchWindow(driver, Flow_Code_Header, Two_coloum_condition, flow_Code_Data_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//financial category
		if(isdisplayed(driver, financialCategory_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, financialCategory_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, financial_Category_Txtfld_Jnl);
				twoColumnSearchWindow(driver, Finance_Category_Header, Two_coloum_condition, financial_Category_Data_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//						Unit Price

		if(isdisplayed(driver,unitprice_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, unitprice_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				waitForElement(driver, unitPrice_Textfield_JNL);
				sendKeys(driver, unitPrice_Textfield_JNL, unitPrice_Dr);
				waitForElement(driver, accountTransElements11);

			}
		}


		//taxcode
		if(isdisplayed(driver, taxcode_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, taxcode_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, taxCode_SearchButton_BL1);
				twoColumnSearchWindow(driver, Tax_Code_Header, Two_coloum_condition, tax_Code_Data_Dr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//reference
		if(isdisplayed(driver, reference_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, reference_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				twoColumnSearchWindow(driver, Reference_Select_Header, Two_coloum_condition, reference_Data_Dr);
			}
		}


		waitForElement(driver, vendor_search_ok1);
		click(driver, vendor_search_ok1);
		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);

		}

		waitForElement(driver, Supplier_Dr_cr_droupdwn);
		click(driver,Supplier_Dr_cr_droupdwn);
		waitForElement(driver, select_cr);
		click(driver,select_cr);

		Step_Start(13, "Select the nominal from the search button for Cr.", test, test1);

		waitForElement(driver, Supplier_nomination_search);
		click(driver,Supplier_nomination_search);
		twoColumnSearchWindow(driver, Nominal_Select_Header, Two_coloum_condition, Nomination_name_CR);

		Step_End(13, "Select the nominal from the search button for Cr.", test, test1);
		Step_Start(14, "Enter the valid amount in amount text field for Cr.", test, test1);
		waitForElement(driver, Supplier_amount_field);
		doubleClick(driver, Supplier_amount_field);
		Actionsendkeys(driver, Supplier_amount_field, Nomination_Amount_CR);
		click(driver, Home_amount1);

		Step_End(14, "Enter the valid amount in amount text field for Cr.", test, test1);
		Step_Start(15, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change..", test, test1);

		waitForElement(driver, Supplier_currency_search);
		click(driver,Supplier_currency_search);
		twoColumnSearchWindow(driver, CurrencyCode_Select_Header, Two_coloum_condition, Currency_code_CR);

		Step_End(15, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change..", test, test1);
		Step_Start(16, "Click + button to add the nominals in the grid .", test, test1);

		waitForElement(driver, Supplier_Gird_add_button);
		click(driver,Supplier_Gird_add_button);
		Step_End(16, "Click + button to add the nominals in the grid .", test, test1);

		waitForElement(driver, accountTransElements11);

		//bill of lading
		if(isdisplayed(driver, billOfLading_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, billOfLading_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, billOfLading_SearchButton_BL1);

				globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Bol_Cr, globalSearch_Value_Bol_Cr, "", "", "", "");
				waitForElement(driver, accountTransElements11);

			}
		}

		//main line service
		if(isdisplayed(driver, mainLineService_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineService_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineService_SearchButton_BL1);
				twoColumnSearchWindow(driver, Main_Service_Select_Header, Two_coloum_condition, service_Code_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//main line vessel

		if(isdisplayed(driver, mainLineVessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVessel_SearchButton_BL1);
				twoColumnSearchWindow(driver, Main_Vessel_Select_Header, Two_coloum_condition, vessel_Code_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//  main line voyage bound

		if(isdisplayed(driver, mainLineVoyageBound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVoyageBound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVoyageBound_SearchButton_BL1);
				twoColumnSearchWindow(driver, Main_Voyage_Select_Header, Two_coloum_condition, voyage_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//  First Service

		if(isdisplayed(driver, first_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstService_SearchButton_BL1);
				twoColumnSearchWindow(driver, First_Service_Select_Header, Two_coloum_condition, firstServiceCode_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//  First Vessel

		if(isdisplayed(driver, first_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstVessel_SearchButton_BL1);
				twoColumnSearchWindow(driver, First_Vessel_Select_Header, Two_coloum_condition, firstVesselCode_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//  First Voyage/Bound

		if(isdisplayed(driver, first_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, first_line_bound_search);
				twoColumnSearchWindow(driver, First_Voyage_Select_Header, Two_coloum_condition, firstVoyageBoundCode_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//Last Service

		if(isdisplayed(driver, last_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastService_SearchButton_BL1);
				twoColumnSearchWindow(driver, Last_Service_Select_Header, Two_coloum_condition, lastServiceCode_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//Last Voyage/Bound

		if(isdisplayed(driver, last_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVoyage_Bound_SearchButton_BL1);
				twoColumnSearchWindow(driver, Last_Voyage_Select_Header, Two_coloum_condition, lastVoyageBoundCode_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//  Location/Port Of Origin	

		if(isdisplayed(driver, location_PortOfOrigin_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_PortOfOrigin_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_PortOfOrigin_SearchButton_BL1);
				twoColumnSearchWindow(driver, Port_Select_Header, Two_coloum_condition, portCode_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//  Location/Port Of Discharge	
		if(isdisplayed(driver, location_Pod_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_Pod_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_Port_Of_Discharge_SearchButton_BL1);
				twoColumnSearchWindow(driver, Discharge_Port_Select_Header, Two_coloum_condition, dischargePortCode_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//depot_cfs
		if(isdisplayed(driver, depot_Cfs_Terminal_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, depot_Cfs_Terminal_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, depot_CFS_Terminal_SearchButton_BL1);
				twoColumnSearchWindow(driver, Depot_Select_Header, Two_coloum_condition, depot_Cfs_Terminal_Data_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//eqp_type
		if(isdisplayed(driver, eqpType_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, eqpType_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, eqpType_SearchButton_BL1);
				twoColumnSearchWindow(driver, Eqp_Select_Header, Two_coloum_condition, eqp_Type_Data_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//	Quantity

		if(isdisplayed(driver, quantity_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, quantity_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				waitForElement(driver, quantity_Textfield_JNL);
				sendKeys(driver, quantity_Textfield_JNL, quantity_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//	Agency

		if(isdisplayed(driver, SI_agency_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, SI_agency_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, agency_SearchButton_BL1);
				twoColumnSearchWindow(driver, Agency_Select_Header, Two_coloum_condition, agency_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//vendor
		if(isdisplayed(driver, vendor_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, vendor_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, vendor_SearchButton_BL1);
				globalValueSearchWindow(driver, dropdownCondition, global_Search_Option1_Vendor_Cr, global_Search_Value1_Vendor_Code_Cr, "", "", "", "");

				waitForElement(driver, accountTransElements11);

			}
		}

		//Customer			
		if(isdisplayed(driver, customer_Checkbox)) {
			String actualStatus=getAttribute(driver, customer_Checkbox, "class");
			if(actualStatus.contains(status)) {
				click(driver, customerSearchButton11);

				globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Customer1_Cr, globalSearch_Value1_Cr, "", "", "", "");
				waitForElement(driver, accountTransElements11);

			}
		}
		if(isdisplayed(driver, ID_Popup_Ok_Button3)) {
			click(driver, ID_Popup_Ok_Button3);

		}


		//employee
		if(isdisplayed(driver, employee_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, employee_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, employee_SearchButton_BL1);
				twoColumnSearchWindow(driver, Employee_Select_Header, Two_coloum_condition, employee_Data_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//departments
		if(isdisplayed(driver, departments_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, departments_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, departments_SearchButton_BL1);
				twoColumnSearchWindow(driver, Department_Select_Header, Two_coloum_condition, department_Data_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//	Fuel Grade

		if(isdisplayed(driver,fuel_Grade_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Grade_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, fuelGrade_SearchButton_BL1);
				twoColumnSearchWindow(driver, Fuel_Select_Header, Two_coloum_condition, fuelGrade_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//  Last Vessel

		if(isdisplayed(driver, last_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVessel_SearchButton_BL1);
				twoColumnSearchWindow(driver, Last_Vessel_Select_Header, Two_coloum_condition, lastVesselCode_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//contract_number
		if(isdisplayed(driver, contract_Num_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, contract_Num_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, contractNumber_SearchButton_BL1);
				twoColumnSearchWindow(driver, Contract_Select_Header, Two_coloum_condition, contract_Num_Data_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//intercompany
		if(isdisplayed(driver, inter_Company_Codes_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, inter_Company_Codes_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, interCompanyCodes_SearchButton_BL1);
				twoColumnSearchWindow(driver, Company_Select_Header, Two_coloum_condition, company_Code_Data_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//fueltype
		if(isdisplayed(driver, fuel_Type_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Type_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, fuelType_SearchButton_BL1);
				twoColumnSearchWindow(driver, Fuel_Type_Select_Header, Two_coloum_condition, fuel_Type_Data_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}


		//flowelement
		if(isdisplayed(driver, flow_Element_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, flow_Element_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, flowElement_SearchButton_BL1);
				twoColumnSearchWindow(driver, Flow_Code_Header, Two_coloum_condition, flow_Code_Data_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//financial category
		if(isdisplayed(driver, financialCategory_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, financialCategory_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, financial_Category_Txtfld_Jnl);
				twoColumnSearchWindow(driver, Finance_Category_Header, Two_coloum_condition, financial_Category_Data_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//			Unit Price

		if(isdisplayed(driver,unitprice_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, unitprice_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				waitForElement(driver, unitPrice_Textfield_JNL);
				sendKeys(driver, unitPrice_Textfield_JNL, unitPrice_Cr);
				waitForElement(driver, accountTransElements11);

			}
		}


		//taxcode
		if(isdisplayed(driver, taxcode_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, taxcode_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, taxCode_SearchButton_BL1);
				twoColumnSearchWindow(driver, Tax_Code_Header, Two_coloum_condition, tax_Code_Data_Cr);

				waitForElement(driver, accountTransElements11);

			}
		}

		//reference
		if(isdisplayed(driver, reference_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, reference_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				twoColumnSearchWindow(driver, Reference_Select_Header, Two_coloum_condition, reference_Data_Cr);
			}
		}




		waitForElement(driver, vendor_search_ok1);
		click(driver,vendor_search_ok1);

		Step_Start(17, "Click save button in toolbar .", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);

		Step_End(17, "Click save button in toolbar .", test, test1);
		Step_Start(18, "System will not allow to save with Total Cr and Dr will mismatch", test, test1);


		waitForPopup(driver, popup_Message,Billing_saved_popup);

		String Actualpopmsg = getText(driver, popup_Message);
		System.out.println(Actualpopmsg);

		if (Billing_saved_popup.equals(Actualpopmsg)) {
			System.out.println("Matched || " + " Expected popup  value should be display in the Suplier invoice Screen : " + Billing_saved_popup+ " || Actual popup Dispaly in the Suplier invoice Screen  : " + Actualpopmsg);
			Extent_pass_New(driver, "Matched || " + " Expected popup  value should be display in the Suplier invoice Screen : " + Billing_saved_popup+ " || Actual popup Dispaly in the Suplier invoice Screen : " + Actualpopmsg, test, test1);
			Extent_call(test, test1, Actualpopmsg);
		} else {
			System.out.println("Not matched || " + "Expected popup  value should be display in the Suplier invoice Screen : " + Billing_saved_popup+ " || Actual popup not Dispaly in the Suplier invoice Screen : " + Actualpopmsg);
			Extent_fail(driver, "Not matched || " + " Expected popup  value should be display in the Suplier invoice Screen : " + Billing_saved_popup+ " || Actual popup not Dispaly in the Suplier invoice Screen  : " + Actualpopmsg, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);




		Step_End(18, "System will not allow to save with Total Cr and Dr will mismatch", test, test1);

		Extent_completed(testcase_Name, test, test1);



	}
}