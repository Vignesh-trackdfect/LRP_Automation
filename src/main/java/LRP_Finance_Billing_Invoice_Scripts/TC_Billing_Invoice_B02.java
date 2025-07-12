package LRP_Finance_Billing_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Billing_Invoice_B02  extends Keywords{
	public void  Billing_Invoice_B02(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Billing_Invoice_B02";
		


		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("Password");
		String Field_Names =Excel_data.get("Field_Names");
		String Activity_date_perform =Excel_data.get("Activity_date_perform");
		String activity_Date_Input =Excel_data.get("activity_Date_Input");
		String invoice_date_perform =Excel_data.get("invoice_date_perform");
		String invoice_Date_Input =Excel_data.get("invoice_Date_Input");
		String Due_date_perform =Excel_data.get("Due_date_perform");
		String Due_Date_Input =Excel_data.get("Due_Date_Input");
		String customer_name =Excel_data.get("customer_name");
		String Discription_input =Excel_data.get("Discription_input");
		String Nomination_name =Excel_data.get("Nomination_name");
		String Nomination_Amount =Excel_data.get("Nomination_Amount");
		String Currency_code =Excel_data.get("Currency_code");
		String Nomination_name_CR =Excel_data.get("Nomination_name_CR");
		String Nomination_Amount_CR =Excel_data.get("Nomination_Amount_CR");
		String Currency_code_CR =Excel_data.get("Currency_code_CR");
		String Billing_saved_popup =Excel_data.get("Billing_saved_popup");
		String status = Excel_data.get("Status");
		String globalSearchFilterOption_Customer1_Dr = Excel_data.get("GlobalSearchFilterOption_Customer1_Dr");
		String globalSearch_Value2_Dr = Excel_data.get("Inside_customer_Dr");
		String GlobalSearchFilterOption_Bol_Dr = Excel_data.get("GlobalSearchFilterOption_Bol_Dr");
		String GlobalSearch_Value_Bol_Dr = Excel_data.get("GlobalSearch_Value_Bol_Dr");
		String unitPrice_Dr = Excel_data.get("UnitPrice_Dr");
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
		String Customer_Select_Header = Excel_data.get("Customer_Select_Header");
		String Customer_Select_Condition = Excel_data.get("Customer_Select_Condition");
		String Nominal_Select_Header = Excel_data.get("Nominal_Select_Header");
		String Nominal_Select_Condition = Excel_data.get("Nominal_Select_Condition");
		String CurrencyCode_Select_Header = Excel_data.get("CurrencyCode_Select_Header");
		String CurrencyCode_Select_Condition = Excel_data.get("CurrencyCode_Select_Condition");
		String Global_Search_Condition =Excel_data.get("Global_Search_Condition");
		String Main_Service_Select_Condition =Excel_data.get("Main_Service_Select_Condition");
		String Main_Service_Select_Header =Excel_data.get("Main_Service_Select_Header");
		String Main_Service_Code_Dr = Excel_data.get("Main_Service_Code_Dr");
		String Main_Vessel_Select_Header =Excel_data.get("Main_Vessel_Select_Header");
		String Main_Vessel_Select_Condition =Excel_data.get("Main_Vessel_Select_Condition");
		String Main_Vessel_Code_Dr = Excel_data.get("Main_Vessel_Code_Dr");
		String Main_Voyage_Select_Header =Excel_data.get("Main_Voyage_Select_Header");
		String Main_Voyage_Select_Condition =Excel_data.get("Main_Voyage_Select_Condition");
		String Main_Voyage_Dr = Excel_data.get("Main_Voyage_Dr");
		String First_Service_Select_Header =Excel_data.get("First_Service_Select_Header");
		String First_Service_Select_Condition =Excel_data.get("First_Service_Select_Condition");
		String FirstServiceCode_Dr = Excel_data.get("FirstServiceCode_Dr");
		String First_Vessel_Select_Header = Excel_data.get("First_Vessel_Select_Header");
		String First_Vessel_Select_Condition = Excel_data.get("First_Vessel_Select_Condition");
		String FirstVesselCode_Dr = Excel_data.get("FirstVesselCode_Dr");
		String First_Voyage_Select_Condition = Excel_data.get("First_Voyage_Select_Condition");
		String First_Voyage_Select_Header = Excel_data.get("First_Voyage_Select_Header");
		String FirstVoyageBoundCode_Dr = Excel_data.get("FirstVoyageBoundCode_Dr");
		String Last_Service_Select_Header =Excel_data.get("Last_Service_Select_Header");
		String Last_Service_Select_Condition =Excel_data.get("Last_Service_Select_Condition");
		String LastServiceCode_Dr = Excel_data.get("LastServiceCode_Dr");
		String Last_Voyage_Select_Condition = Excel_data.get("Last_Voyage_Select_Condition");
		String Last_Voyage_Select_Header = Excel_data.get("Last_Voyage_Select_Header");
		String LastVoyageBoundCode_Dr = Excel_data.get("LastVoyageBoundCode_Dr");
		String Last_Vessel_Select_Header = Excel_data.get("Last_Vessel_Select_Header");
		String Last_Vessel_Select_Condition = Excel_data.get("Last_Vessel_Select_Condition");
		String LastVesselCode_Dr = Excel_data.get("LastVesselCode_Dr");
		String Discharge_Port_Select_Header = Excel_data.get("Discharge_Port_Select_Header");
		String Discharge_Port_Select_Condition = Excel_data.get("Discharge_Port_Select_Condition");
		String DischargePortCode_Dr = Excel_data.get("DischargePortCode_Dr");
		String Port_Select_Header = Excel_data.get("Port_Select_Header");
		String Port_Select_Condition = Excel_data.get("Port_Select_Condition");
		String PortCode_Dr = Excel_data.get("PortCode_Dr");
		String Depot_Select_Header = Excel_data.get("Depot_Select_Header");
		String Depot_Select_Condition = Excel_data.get("Depot_Select_Condition");
		String Eqp_Select_Header = Excel_data.get("Eqp_Select_Header");
		String Eqp_Select_Condition = Excel_data.get("Eqp_Select_Condition");
		String Quantity_Dr = Excel_data.get("Quantity_Dr");
		String Agency_Select_Header = Excel_data.get("Agency_Select_Header");
		String Agency_Select_Condition = Excel_data.get("Agency_Select_Condition");
		String Agency_Dr = Excel_data.get("Agency_Dr");
		String Employee_Select_Header = Excel_data.get("Employee_Select_Header");
		String Employee_Select_Condition = Excel_data.get("Employee_Select_Condition");
		String Department_Select_Header = Excel_data.get("Department_Select_Header");
		String Department_Select_Condition = Excel_data.get("Department_Select_Condition");
		String Fuel_Select_Header = Excel_data.get("Fuel_Select_Header");
		String Fuel_Select_Condition = Excel_data.get("Fuel_Select_Condition");
		String FuelGrade_Dr = Excel_data.get("FuelGrade_Dr");
		String Contract_Select_Condition = Excel_data.get("Contract_Select_Condition");
		String Contract_Select_Header = Excel_data.get("Contract_Select_Header");
		String Company_Select_Header = Excel_data.get("Company_Select_Header");
		String Company_Select_Condition = Excel_data.get("Company_Select_Condition");
		String Fuel_Type_Select_Header = Excel_data.get("Fuel_Type_Select_Header");
		String Fuel_Type_Select_Condition = Excel_data.get("Fuel_Type_Select_Condition");
		String Flow_Code_Condition = Excel_data.get("Flow_Code_Condition");
		String Flow_Code_Header = Excel_data.get("Flow_Code_Header");
		String Finance_Category_Condition = Excel_data.get("Finance_Category_Condition");
		String Finance_Category_Header = Excel_data.get("Finance_Category_Header");
		String Tax_Code_Header = Excel_data.get("Tax_Code_Header");
		String Tax_Code_Condition = Excel_data.get("Tax_Code_Condition");
		String Reference_Select_Header = Excel_data.get("Reference_Select_Header");
		String Reference_Select_Condition = Excel_data.get("Reference_Select_Condition");

		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Field_Names);
		Step_Start(1, " Click on New button in toolbar ", test, test1);
	newButton(driver);
		Step_End(1, " Click on New button in toolbar ", test, test1);

		Step_Start(2, "Select the Activity date from the date picker .", test, test1);
		waitForElement(driver, billing_invoice_activity_date);
		if (Activity_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, billing_invoice_activity_date, activity_Date_Input);
		} else {
			waitForElement(driver, billing_invoice_activity_date);
			clearAndType(driver, billing_invoice_activity_date, activity_Date_Input);
		}
		Step_End(2, "Select the Activity date from the date picker .", test, test1);

		Step_Start(3, "Select the Invoice date from the date picker. .", test, test1);
		waitForElement(driver, billing_invoice_invoice_date);
		if (invoice_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, billing_invoice_invoice_date, invoice_Date_Input);
		} else {
			waitForElement(driver, billing_invoice_invoice_date);
			clearAndType(driver, billing_invoice_invoice_date, invoice_Date_Input);
		}
		Step_End(3, "Select the Invoice date from the date picker. .", test, test1);
		Step_Start(4, "Select the Due date from the date picker.", test, test1);
		waitForElement(driver, billing_invoice_Due_date);
		if (Due_date_perform.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, billing_invoice_Due_date, Due_Date_Input);
		} else {
			waitForElement(driver, billing_invoice_Due_date);
			clearAndType(driver, billing_invoice_Due_date, Due_Date_Input);
		}
		Step_End(4, "Select the Due date from the date picker.", test, test1);
		Step_Start(5, "Select the customer.", test, test1);
		
		
		waitForDisplay(driver, billing_customer_search_button);
		if(isdisplayed(driver, billing_customer_search_button)&&!customer_name.equals("")) {
		waitForElement(driver, billing_customer_search_button);
		click(driver,billing_customer_search_button);
		twoColumnSearchWindow(driver, Customer_Select_Header, Customer_Select_Condition, customer_name);
		}

		Step_End(5, "Select the customer.", test, test1);
		Step_Start(6, "Based on your activity date open period will automatically changed. ", test, test1);
		waitForElement(driver, open_peroid);
		String open_period_value = getText(driver, open_peroid);
		System.out.println(open_period_value);
		Extent_call(test, test1, "**open period shows***"+open_period_value);
		Step_End(6, "Based on your activity date open period will automatically changed. ", test, test1);
		Step_Start(7, "Enter Alphanumeric characters in description field ", test, test1);

		waitForDisplay(driver, billing_Discription_input);
		if(isdisplayed(driver, billing_Discription_input)&&!Discription_input.equals("")) {
		waitForElement(driver, billing_Discription_input);
		sendKeys(driver, billing_Discription_input, Discription_input);
		
		}
		
		Step_End(7, "Enter Alphanumeric characters in description field ", test, test1);
		Step_Start(8, "Select the dr/cr in that dropdown list ", test, test1);
		waitForElement(driver, billing_Dr_cr_droupdwn);
		click(driver,billing_Dr_cr_droupdwn);
		waitForElement(driver, select_dr);
		click(driver,select_dr);
		Step_End(8, "Select the dr/cr in that dropdown list ", test, test1);
		Step_Start(9, "Select the nominal from the search button for Dr. ", test, test1);

		waitForDisplay(driver, nomination_search);
		if(isdisplayed(driver, nomination_search)&&!Nomination_name.equals("")) {
		waitForElement(driver, nomination_search);
		click(driver,nomination_search);
		twoColumnSearchWindow(driver, Nominal_Select_Header, Nominal_Select_Condition, Nomination_name);
		}
		
		Step_End(9, "Select the nominal from the search button for Dr. ", test, test1);
		Step_Start(11, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change.. ", test, test1);
		
		waitForDisplay(driver, currency_search);
		if(isdisplayed(driver, currency_search)&&!Currency_code.equals("")) {
		waitForElement(driver, currency_search);
		click(driver,currency_search);
		twoColumnSearchWindow(driver, CurrencyCode_Select_Header, CurrencyCode_Select_Condition, Currency_code);
		}
		
		Step_End(11, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change.. ", test, test1);
	
		Step_Start(10, "Enter the valid amount in amount text field for Dr. ", test, test1);
		waitForDisplay(driver, nominal_amount_field);
		if(isdisplayed(driver, nominal_amount_field)&&!Nomination_Amount.equals("")) {
		waitForElement(driver, nominal_amount_field);
		doubleClick(driver, nominal_amount_field);
		Actionsendkeys(driver, nominal_amount_field, Nomination_Amount);
		click(driver, Home_amount);
		}
		
		Step_End(10, "Enter the valid amount in amount text field for Dr. ", test, test1);
	
		Step_Start(12, "Click + button to add the nominals in the grid.", test, test1);
		waitForElement(driver, Gird_add_button);
		click(driver,Gird_add_button);
		Step_End(12, "Click + button to add the nominals in the grid.", test, test1);
		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);

		}
		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);

		}

		//bill of lading
		if(isdisplayed(driver, billOfLading_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, billOfLading_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, billOfLading_SearchButton_BL);

				globalValueSearchWindow(driver, Global_Search_Condition, GlobalSearchFilterOption_Bol_Dr, GlobalSearch_Value_Bol_Dr, "", "", "", "");
				waitForElement(driver, accountTransElements1);

			}
		}

		//main line service
		if(isdisplayed(driver, mainLineService_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineService_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineService_SearchButton_BL);
				twoColumnSearchWindow(driver, Main_Service_Select_Header, Main_Service_Select_Condition, Main_Service_Code_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//main line vessel

		if(isdisplayed(driver, mainLineVessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVessel_SearchButton_BL);
				twoColumnSearchWindow(driver, Main_Vessel_Select_Header, Main_Vessel_Select_Condition, Main_Vessel_Code_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//  main line voyage bound
		if(isdisplayed(driver, mainLineVoyageBound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVoyageBound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVoyageBound_SearchButton_BL);
				twoColumnSearchWindow(driver, Main_Voyage_Select_Header, Main_Voyage_Select_Condition, Main_Voyage_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//  First Service
		if(isdisplayed(driver, first_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstService_SearchButton_BL);
				twoColumnSearchWindow(driver, First_Service_Select_Header, First_Service_Select_Condition, FirstServiceCode_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//  First Vessel

		if(isdisplayed(driver, first_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstVessel_SearchButton_BL);
				twoColumnSearchWindow(driver, First_Vessel_Select_Header, First_Vessel_Select_Condition, FirstVesselCode_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//  First Voyage/Bound

		if(isdisplayed(driver, first_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstVoyage_Bound_SearchButton1);
				twoColumnSearchWindow(driver, First_Voyage_Select_Header, First_Voyage_Select_Condition, FirstVoyageBoundCode_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//  Last Service

		if(isdisplayed(driver, last_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastService_SearchButton_BL);
				twoColumnSearchWindow(driver, Last_Service_Select_Header, Last_Service_Select_Condition, LastServiceCode_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//  Last Voyage/Bound

		if(isdisplayed(driver, last_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVoyage_Bound_SearchButton_BL);
				twoColumnSearchWindow(driver, Last_Voyage_Select_Header, Last_Voyage_Select_Condition, LastVoyageBoundCode_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//  Location/Port Of Origin	

		if(isdisplayed(driver, location_PortOfOrigin_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_PortOfOrigin_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_PortOfOrigin_SearchButton_BL);
				twoColumnSearchWindow(driver, Port_Select_Header, Port_Select_Condition, PortCode_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//  Location/Port Of Discharge	
		if(isdisplayed(driver, location_Pod_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_Pod_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_Port_Of_Discharge_SearchButton_BL);
				twoColumnSearchWindow(driver, Discharge_Port_Select_Header, Discharge_Port_Select_Condition, DischargePortCode_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//depot_cfs
		if(isdisplayed(driver, depot_Cfs_Terminal_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, depot_Cfs_Terminal_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, depot_CFS_Terminal_SearchButton_BL);
				twoColumnSearchWindow(driver, Depot_Select_Header, Depot_Select_Condition, depot_Cfs_Terminal_Data_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//eqp_type
		if(isdisplayed(driver, eqpType_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, eqpType_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, eqpType_SearchButton_BL);
				twoColumnSearchWindow(driver, Eqp_Select_Header, Eqp_Select_Condition, eqp_Type_Data_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//				Quantity

		if(isdisplayed(driver, quantity_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, quantity_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				waitForElement(driver, quantity_Textfield_JNL);
				sendKeys(driver, quantity_Textfield_JNL, Quantity_Dr);

				waitForElement(driver, accountTransElements1);

			}
		}


		//				Agency

		if(isdisplayed(driver, Bill_agency_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, Bill_agency_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, agency_SearchButton_BL);
				twoColumnSearchWindow(driver, Agency_Select_Header, Agency_Select_Condition, Agency_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//vendor
		if(isdisplayed(driver, vendor_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, vendor_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, vendor_SearchButton_BL);
				globalValueSearchWindow(driver, Global_Search_Condition, global_Search_Option1_Vendor_Dr, global_Search_Value1_Vendor_Code_Dr, "", "", "", "");
				waitForElement(driver, accountTransElements1);

			}
		}

		// Customer			
		if(isdisplayed(driver, customer_Checkbox)) {
			String actualStatus=getAttribute(driver, customer_Checkbox, "class");
			if(actualStatus.contains(status)) {
				click(driver, customerSearchButton1);
				globalValueSearchWindow(driver, Global_Search_Condition, globalSearchFilterOption_Customer1_Dr, globalSearch_Value2_Dr, "", "", "", "");
				waitForElement(driver, accountTransElements1);
			}
		}
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);

		}

		//employee
		if(isdisplayed(driver, employee_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, employee_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, employee_SearchButton_BL);
				twoColumnSearchWindow(driver, Employee_Select_Header, Employee_Select_Condition, employee_Data_Dr);
				waitForElement(driver, accountTransElements1);
			}
		}


		//departments
		if(isdisplayed(driver, departments_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, departments_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, departments_SearchButton_BL);
				twoColumnSearchWindow(driver, Department_Select_Header, Department_Select_Condition, department_Data_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//	Fuel Grade

		if(isdisplayed(driver,fuel_Grade_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Grade_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, fuelGrade_SearchButton_BL);
				twoColumnSearchWindow(driver, Fuel_Select_Header, Fuel_Select_Condition, FuelGrade_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//  Last Vessel

		if(isdisplayed(driver, last_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVessel_SearchButton_BL);
				twoColumnSearchWindow(driver, Last_Vessel_Select_Header, Last_Vessel_Select_Condition, LastVesselCode_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//contract_number
		if(isdisplayed(driver, contract_Num_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, contract_Num_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, contractNumber_SearchButton_BL);
				twoColumnSearchWindow(driver, Contract_Select_Header, Contract_Select_Condition, contract_Num_Data_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//inter company
		if(isdisplayed(driver, inter_Company_Codes_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, inter_Company_Codes_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, interCompanyCodes_SearchButton_BL);
				twoColumnSearchWindow(driver, Company_Select_Header, Company_Select_Condition, company_Code_Data_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//fuel type
		if(isdisplayed(driver, fuel_Type_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Type_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, fuelType_SearchButton_BL);
				twoColumnSearchWindow(driver, Fuel_Type_Select_Header, Fuel_Type_Select_Condition, fuel_Type_Data_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//flow element
		if(isdisplayed(driver, flow_Element_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, flow_Element_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, flowElement_SearchButton_BL);
				twoColumnSearchWindow(driver, Flow_Code_Header, Flow_Code_Condition, flow_Code_Data_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//financial category
		if(isdisplayed(driver, financialCategory_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, financialCategory_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, financialCategory_SearchButton_BL);
				twoColumnSearchWindow(driver, Finance_Category_Header, Finance_Category_Condition, financial_Category_Data_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//Unit Price

		if(isdisplayed(driver,unitprice_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, unitprice_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				waitForElement(driver, unitPrice_Textfield_JNL);
				sendKeys(driver, unitPrice_Textfield_JNL, unitPrice_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//taxcode
		if(isdisplayed(driver, taxcode_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, taxcode_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, taxCode_SearchButton_BL);
				twoColumnSearchWindow(driver, Tax_Code_Header, Tax_Code_Condition, tax_Code_Data_Dr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//reference
		if(isdisplayed(driver, reference_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, reference_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				twoColumnSearchWindow(driver, Reference_Select_Header, Reference_Select_Condition, reference_Data_Dr);
			}
		}

		waitForElement(driver, vendor_search_ok);
		click(driver, vendor_search_ok);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);

		}

		waitForElement(driver, billing_Dr_cr_droupdwn);
		click(driver,billing_Dr_cr_droupdwn);
		waitForElement(driver, select_cr);
		click(driver,select_cr);

		Step_Start(13, "Select the nominal from the search button for Cr.", test, test1);

		waitForDisplay(driver, currency_search);
		if(isdisplayed(driver, currency_search)&&!Nomination_name_CR.equals("")){
		waitForElement(driver, nomination_search);
		click(driver,nomination_search);
		twoColumnSearchWindow(driver, Nominal_Select_Header, Nominal_Select_Condition, Nomination_name_CR);
		}
		
		
		Step_End(13, "Select the nominal from the search button for Cr.", test, test1);
		Step_Start(14, "Enter the valid amount in amount text field for Cr.", test, test1);
		
		waitForDisplay(driver, nominal_amount_field);
		if(isdisplayed(driver, nominal_amount_field)&&!Nomination_Amount_CR.equals("")){
		
		waitForElement(driver, nominal_amount_field);
		doubleClick(driver, nominal_amount_field);
		Actionsendkeys(driver, nominal_amount_field, Nomination_Amount_CR);
		click(driver, Home_amount);
		
		}

		Step_End(14, "Enter the valid amount in amount text field for Cr.", test, test1);
		Step_Start(15, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change..", test, test1);

		waitForDisplay(driver, currency_search);
		if(isdisplayed(driver, currency_search)&&!Currency_code_CR.equals("")){
		waitForElement(driver, currency_search);
		click(driver,currency_search);
		twoColumnSearchWindow(driver, CurrencyCode_Select_Header, CurrencyCode_Select_Condition, Currency_code_CR);

		}
		
		Step_End(15, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change..", test, test1);
		Step_Start(16, "Click + button to add the nominals in the grid .", test, test1);

		waitForElement(driver, Gird_add_button);
		click(driver,Gird_add_button);
		Step_End(16, "Click + button to add the nominals in the grid .", test, test1);

		waitForElement(driver, accountTransElements1);

		//bill of lading
		if(isdisplayed(driver, billOfLading_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, billOfLading_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, billOfLading_SearchButton_BL);
				globalValueSearchWindow(driver, Global_Search_Condition, globalSearchFilterOption_Bol_Cr, globalSearch_Value_Bol_Cr, "", "", "", "");
				waitForElement(driver, accountTransElements1);

			}
		}

		//main line service
		if(isdisplayed(driver, mainLineService_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineService_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineService_SearchButton_BL);
				twoColumnSearchWindow(driver, Main_Service_Select_Header, Main_Service_Select_Condition, service_Code_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//main line vessel

		if(isdisplayed(driver, mainLineVessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVessel_SearchButton_BL);
				twoColumnSearchWindow(driver, Main_Vessel_Select_Header, Main_Vessel_Select_Condition, vessel_Code_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//  main line voyage bound
		if(isdisplayed(driver, mainLineVoyageBound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVoyageBound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVoyageBound_SearchButton_BL);
				twoColumnSearchWindow(driver, Main_Voyage_Select_Header, Main_Voyage_Select_Condition, voyage_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//  First Service
		if(isdisplayed(driver, first_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstService_SearchButton_BL);
				twoColumnSearchWindow(driver, First_Service_Select_Header, First_Service_Select_Condition, firstServiceCode_Cr);
				waitForElement(driver, accountTransElements1);
			}
		}


		//  First Vessel

		if(isdisplayed(driver, first_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstVessel_SearchButton_BL);
				twoColumnSearchWindow(driver, First_Vessel_Select_Header, First_Vessel_Select_Condition, firstVesselCode_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//  First Voyage/Bound

		if(isdisplayed(driver, first_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, first_line_bound_search);
				twoColumnSearchWindow(driver, First_Voyage_Select_Header, First_Voyage_Select_Condition, firstVoyageBoundCode_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//Last Service

		if(isdisplayed(driver, last_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastService_SearchButton_BL);
				twoColumnSearchWindow(driver, Last_Service_Select_Header, Last_Service_Select_Condition, lastServiceCode_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//Last Voyage/Bound

		if(isdisplayed(driver, last_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVoyage_Bound_SearchButton_BL);
				twoColumnSearchWindow(driver, Last_Voyage_Select_Header, Last_Voyage_Select_Condition, lastVoyageBoundCode_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//  Location/Port Of Origin	

		if(isdisplayed(driver, location_PortOfOrigin_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_PortOfOrigin_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_PortOfOrigin_SearchButton_BL);
				twoColumnSearchWindow(driver, Port_Select_Header, Port_Select_Condition, portCode_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//  Location/Port Of Discharge	
		if(isdisplayed(driver, location_Pod_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_Pod_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_Port_Of_Discharge_SearchButton_BL);
				twoColumnSearchWindow(driver, Discharge_Port_Select_Header, Discharge_Port_Select_Condition, dischargePortCode_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//depot_cfs
		if(isdisplayed(driver, depot_Cfs_Terminal_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, depot_Cfs_Terminal_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, depot_CFS_Terminal_SearchButton_BL);
				twoColumnSearchWindow(driver, Depot_Select_Header, Depot_Select_Condition, depot_Cfs_Terminal_Data_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//eqp_type
		if(isdisplayed(driver, eqpType_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, eqpType_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, eqpType_SearchButton_BL);
				twoColumnSearchWindow(driver, Eqp_Select_Header, Eqp_Select_Condition, eqp_Type_Data_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//	Quantity

		if(isdisplayed(driver, quantity_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, quantity_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				waitForElement(driver, quantity_Textfield_JNL);
				sendKeys(driver, quantity_Textfield_JNL, quantity_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//	Agency

		if(isdisplayed(driver, Bill_agency_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, Bill_agency_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, agency_SearchButton_BL);
				twoColumnSearchWindow(driver, Agency_Select_Header, Agency_Select_Condition, agency_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//vendor
		if(isdisplayed(driver, vendor_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, vendor_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, vendor_SearchButton_BL);
				globalValueSearchWindow(driver, Global_Search_Condition, global_Search_Option1_Vendor_Cr, global_Search_Value1_Vendor_Code_Cr, "", "", "", "");
				waitForElement(driver, accountTransElements1);

			}
		}

		//Customer			
		if(isdisplayed(driver, customer_Checkbox)) {
			String actualStatus=getAttribute(driver, customer_Checkbox, "class");
			if(actualStatus.contains(status)) {
				click(driver, customerSearchButton1);
				globalValueSearchWindow(driver, Global_Search_Condition, globalSearchFilterOption_Customer1_Cr, globalSearch_Value1_Cr, "", "", "", "");
				waitForElement(driver, accountTransElements1);

			}
		}
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			click(driver, popup_Message_Ok_Button);

		}


		//employee
		if(isdisplayed(driver, employee_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, employee_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, employee_SearchButton_BL);
				twoColumnSearchWindow(driver, Employee_Select_Header, Employee_Select_Condition, employee_Data_Cr);

				waitForElement(driver, accountTransElements1);

			}
		}


		//departments
		if(isdisplayed(driver, departments_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, departments_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, departments_SearchButton_BL);
				twoColumnSearchWindow(driver, Department_Select_Header, Department_Select_Condition, department_Data_Cr);

				waitForElement(driver, accountTransElements1);

			}
		}


		//	Fuel Grade

		if(isdisplayed(driver,fuel_Grade_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Grade_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				click(driver, fuelGrade_SearchButton_BL);
			    twoColumnSearchWindow(driver, Fuel_Select_Header, Fuel_Select_Condition, fuelGrade_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//  Last Vessel

		if(isdisplayed(driver, last_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVessel_SearchButton_BL);
				twoColumnSearchWindow(driver, Last_Vessel_Select_Header, Last_Vessel_Select_Condition, lastVesselCode_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//contract_number
		if(isdisplayed(driver, contract_Num_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, contract_Num_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, contractNumber_SearchButton_BL);
				twoColumnSearchWindow(driver, Contract_Select_Header, Contract_Select_Condition, contract_Num_Data_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//intercompany
		if(isdisplayed(driver, inter_Company_Codes_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, inter_Company_Codes_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, interCompanyCodes_SearchButton_BL);
				twoColumnSearchWindow(driver, Company_Select_Header, Company_Select_Condition, company_Code_Data_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//fueltype
		if(isdisplayed(driver, fuel_Type_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Type_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, fuelType_SearchButton_BL);
				twoColumnSearchWindow(driver, Fuel_Type_Select_Header, Fuel_Type_Select_Condition, fuel_Type_Data_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//flowelement
		if(isdisplayed(driver, flow_Element_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, flow_Element_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, flowElement_SearchButton_BL);
				twoColumnSearchWindow(driver, Flow_Code_Header, Flow_Code_Condition, flow_Code_Data_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//financial category
		if(isdisplayed(driver, financialCategory_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, financialCategory_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, financialCategory_SearchButton_BL);
				twoColumnSearchWindow(driver, Finance_Category_Header, Finance_Category_Condition, financial_Category_Data_Cr);
				waitForElement(driver, accountTransElements1);
			

			}
		}

		//Unit Price

		if(isdisplayed(driver,unitprice_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, unitprice_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {

				waitForElement(driver, unitPrice_Textfield_JNL);
				sendKeys(driver, unitPrice_Textfield_JNL, unitPrice_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}


		//taxcode
		if(isdisplayed(driver, taxcode_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, taxcode_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, taxCode_SearchButton_BL);
				twoColumnSearchWindow(driver, Tax_Code_Header, Tax_Code_Condition, tax_Code_Data_Cr);
				waitForElement(driver, accountTransElements1);

			}
		}

		//reference
		if(isdisplayed(driver, reference_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, reference_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				twoColumnSearchWindow(driver, Reference_Select_Header, Reference_Select_Condition, reference_Data_Cr);
			}
		}

		waitForElement(driver, vendor_search_ok);
		click(driver,vendor_search_ok);
		
		
		Step_Start(17, "Click save button in toolbar .", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		Step_End(17, "Click save button in toolbar .", test, test1);
		Step_Start(18, "System will not allow to save with Total Cr and Dr will mismatch.", test, test1);
		waitForPopup(driver, popup_Message,Billing_saved_popup);
		String Actualpopmsg = getText(driver, popup_Message);
		System.out.println(Actualpopmsg);

		if (Billing_saved_popup.equals(Actualpopmsg)) {
			System.out.println("Matched ||  Expected : After click on save button Popup value should be display in the Billing Invoice Screen : " + Billing_saved_popup+ " || Actual : After click on save button Popup value is display in the Billing Invoice Screen : " + Actualpopmsg);
			Extent_pass_New(driver, "Matched || Expected : After click on save button Popup value should be display in the Billing Invoice Screen : " + Billing_saved_popup+ " || Actual : After click on save button Popup value is display in the Billing Invoice Screen : " + Actualpopmsg, test, test1);
			Extent_call(test, test1, Actualpopmsg);
		} else {
			System.out.println("Not matched || Expected : After click on save button Popup value should be display in the Billing Invoice Screen : " + Billing_saved_popup+ " || Actual : After click on save button Popup value is display in the Billing Invoice Screen : " + Actualpopmsg);
			Extent_fail(driver, "Not matched || Expected : After click on save button Popup value should be display in the Billing Invoice Screen : " + Billing_saved_popup+ " || Actual : After click on save button Popup value is display in the Billing Invoice Screen : " + Actualpopmsg, test, test1);

		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);


		Step_End(18, "System will not allow to save with Total Cr and Dr will mismatch", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
	
}
