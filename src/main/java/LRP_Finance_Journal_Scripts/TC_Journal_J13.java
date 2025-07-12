package LRP_Finance_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_J13 extends Keywords{
	public void Journal_J13(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Journal_J13";
		// Get data from test data
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String module_Journal = Excel_data.get("Module_Journal");
		String datePicker = Excel_data.get("DatePicker");
		String activity_Date=Excel_data.get("Activity_Date");
		String trans_Date = Excel_data.get("Trans_Date");
		String originalRef = Excel_data.get("OriginalRef");
		String no_Of_Characters = Excel_data.get("No_Of_Characters");
		String description = Excel_data.get("Description_Input");
		String cr_Dr_Option1 = Excel_data.get("Cr_Dr_Option1");
		String cr_Dr_Option2 = Excel_data.get("Cr_Dr_Option2");
		String nominalName_Dr = Excel_data.get("Nominal_Name_Code_Dr");
		String currencyCode = Excel_data.get("CurrencyCode");
		String amount = Excel_data.get("Amount");
		String localDescription = Excel_data.get("LocalDescription");
		String journal_Saved_Popup_Expctd = Excel_data.get("Journal_Saved_Popup_Expctd");
		String financialYear = Excel_data.get("FinancialYear");
		String status = Excel_data.get("Status");
		String nominalName_Cr = Excel_data.get("Nominal_Name_Code_Cr");
		String globalSearchFilterOption_Customer1_Dr = Excel_data.get("GlobalSearchFilterOption_Customer1_Dr");
		String globalSearch_Value1_Dr = Excel_data.get("GlobalSearch_Value1_Dr");
		String globalSearchFilterOption_Customer2_Dr = Excel_data.get("GlobalSearchFilterOption_Customer2_Dr");
		String globalSearch_Value2_Dr = Excel_data.get("GlobalSearch_Value2_Dr");
		String dropdownCondition = Excel_data.get("dropdownCondition");
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
		String globalSearchFilterOption_Customer1_Cr = Excel_data.get("GlobalSearchFilterOption_Customer1_Cr");
		String globalSearch_Value1_Cr = Excel_data.get("GlobalSearch_Value1_Cr");
		String globalSearchFilterOption_Customer2_Cr = Excel_data.get("GlobalSearchFilterOption_Customer2_Cr");
		String globalSearch_Value2_Cr = Excel_data.get("GlobalSearch_Value2_Cr");
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
		String nominal_Search_Header = Excel_data.get("Nominal_Search_Header");
		String condition = Excel_data.get("Condition");
		String currency_Search_Header = Excel_data.get("Currency_Search_Header");
		String financialYear_Search_Header = Excel_data.get("FinancialYear_Search_Header");
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
		String financial_Category_Data_Dr = Excel_data.get("financial_Category_Data_Dr");
		String financial_Category_Data_Cr = Excel_data.get("financial_Category_Data_Cr");

		StringBuilder year = new StringBuilder();
		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);
		LRP_Login(driver, username, password);
		Step_Start(1, "Using module search  select Journal", test, test1);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, module_Journal);
		//	Journal
		Extent_cal(test, test1, module_Journal);
		Step_End(1, "Using module search  select Journal", test, test1);
		Step_Start(2, "Click Financial year search field", test, test1);
		waitForElement(driver, financialYear_SearchButton);
		click(driver, financialYear_SearchButton);
		Step_End(2, "Click Financial year search field", test, test1);
		Step_Start(3, "Pop up screen will display . It showing the Financial Year list ", test, test1);
		if(isdisplayed(driver, financialYear_Filter)) {
			System.out.println("Matched || The Expected Result is : Financial Year list Should be show || The Actual result is : Financial Year list has shown");
			Extent_pass_New(driver, "Matched || The Expected Result is : Financial Year list Should be show || The Actual result is : Financial Year list has shown", test, test1);
		}else {
			System.out.println("Not Matched || The Expected Result is : Financial Year list Should be show || The Actual result is : Financial Year list has Not shown");
			Extent_fail(driver, "Not Matched || The Expected Result is : Financial Year list Should be show || The Actual result is : Financial Year list has Not shown", test, test1);
		}
		Step_End(3, "Pop up screen will display . It showing the Financial Year list ", test, test1);
		Step_Start(4, "Select the Previous Year Financial Year and click Select button", test, test1);
		twoColumnSearchWindow(driver, financialYear_Search_Header, condition, financialYear);
		Step_End(4, "Select the Previous Year Financial Year and click Select button", test, test1);
		Step_Start(5, "Previous financial Year  selected and displayed in Journal Screen", test, test1);
		waitForElement(driver, financialYear_Textfield);
		String actual_FinancialYear=getAttribute(driver, financialYear_Textfield, "value");
		if(actual_FinancialYear.equals(financialYear)) {
			System.out.println("Matched || Expected Financial Year : "+financialYear+" || Actual Financial Year : "+actual_FinancialYear);
			Extent_pass_New(driver, "Matched || Expected Financial Year : "+financialYear+" || Actual Financial Year : "+actual_FinancialYear, test, test1);
		}else {
			System.out.println("Not Matched || Expected Financial Year : "+financialYear+" || Actual Financial Year : "+actual_FinancialYear);
			Extent_fail(driver, "Not Matched || Expected Financial Year : "+financialYear+" || Actual Financial Year : "+actual_FinancialYear, test, test1);
		}
		Step_End(5, "Previous financial Year  selected and displayed in Journal Screen", test, test1);
		Step_Start(6, "Click New on toolbar", test, test1);
		newButton(driver);
		Step_End(6, "Click New on toolbar", test, test1);
		Step_Start(7, "Select the Activity date based on that selected financial year  from the date picker", test, test1);
		waitForElement(driver, activityDate_Field);
		if (datePicker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, activityDate_Field, activity_Date);
		} else {
			click(driver, activityDate_Field);
			waitForElement(driver, activityDate_Field);
			clearAndType(driver, activityDate_Field, activity_Date);
			waitForElement(driver, originalRef_Textfield);
			click(driver, originalRef_Textfield);
		}
		Step_End(7, "Select the Activity date based on that selected financial year  from the date picker", test, test1);
		Step_Start(8, "Select the Trans date based on that selected financial year  from the date picker", test, test1);
		waitForElement(driver, transDate_Field);
		if (datePicker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, transDate_Field, trans_Date);
		} else {
			click(driver, transDate_Field);
			waitForElement(driver, transDate_Field);
			clearAndType(driver, transDate_Field, trans_Date);
			waitForElement(driver, originalRef_Textfield);
			click(driver, originalRef_Textfield);
		}
		Step_End(8, "Select the Trans date based on that selected financial year  from the date picker", test, test1);
		Step_Start(9, "Enter  Alphanumeric characters or only numerical values upto (46) characters in that OriginalRef field.", test, test1);
		int length=originalRef.length();
		int expected_No_Of_Characters=Integer.parseInt(no_Of_Characters);
		if(length<=expected_No_Of_Characters) {
			waitForElement(driver, originalRef_Textfield);
			sendKeys(driver, originalRef_Textfield, originalRef);
		}
		Step_End(9, "Enter  Alphanumeric characters or only numerical values upto (46) characters in that OriginalRef field.", test, test1);
		Step_Start(10, " Based on your activity date open period will automatically changed", test, test1);
		waitForElement(driver, openPeriod_Dropdown);
		String open_Period_Text = getText(driver, openPeriod_Dropdown);
		if(open_Period_Text.contains(year)) {
			System.out.println("MATCHED || EXPECTED OPEN PERIOD YEAR -> "+year+" || ACTUAL OPEN PERIOD YEAR -> "+open_Period_Text);
			Extent_pass_New(driver, "MATCHED || EXPECTED OPEN PERIOD YEAR -> "+year+" || ACTUAL OPEN PERIOD YEAR -> "+open_Period_Text, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED OPEN PERIOD YEAR -> "+year+" || ACTUAL OPEN PERIOD YEAR -> "+open_Period_Text);
			Extent_fail(driver, "NOT MATCHED || EXPECTED OPEN PERIOD YEAR -> "+year+" || ACTUAL OPEN PERIOD YEAR -> "+open_Period_Text, test, test1);
		}
		Step_End(10, " Based on your activity date open period will automatically changed", test, test1);
		Step_Start(11, "Enter Alphanumeric characters in description field", test, test1);
		waitForElement(driver, description_TextArea_Jnl);
		sendKeys(driver, description_TextArea_Jnl, description);
		Step_End(11, "Enter Alphanumeric characters in description field", test, test1);
		Step_Start(12, "Select the dr/cr in that dropdown list ", test, test1);
		waitForElement(driver, dr_Cr_Dropdown);
		click(driver, dr_Cr_Dropdown);
		String select_Cr_Dr=String.format(dr_Cr_Dropdown_Option, cr_Dr_Option1);
		waitForElement(driver, select_Cr_Dr);
		click(driver, select_Cr_Dr);
		Step_End(12, "Select the dr/cr in that dropdown list ", test, test1);
		Step_Start(13, "Select the nominal from the search button for Dr ", test, test1);
		waitForElement(driver, dr_Cr_SearchButton);
		click(driver, dr_Cr_SearchButton);	
		twoColumnSearchWindow(driver, nominal_Search_Header, condition, nominalName_Dr);
		Step_End(13, "Select the nominal from the search button for Dr ", test, test1);
		Step_Start(14, "Enter the valid amount in amount text field for Dr ", test, test1);
		waitForElement(driver, amountTextfield);
		click(driver, amountTextfield);
		waitForElement(driver, amountTextfield);
		clearAndType(driver, amountTextfield, amount);
		waitForElement(driver, amountTextfield);
		click(driver, originalRef_Textfield);
		Step_End(14, "Enter the valid amount in amount text field for Dr ", test, test1);
		Step_Start(15, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change", test, test1);
		waitForElement(driver, currencySearchButton);
		click(driver, currencySearchButton);	
		twoColumnSearchWindow(driver, currency_Search_Header, condition, currencyCode);
		waitForElement(driver, localDescription_TextArea);
		sendKeys(driver, localDescription_TextArea, localDescription);
		Step_End(15, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change", test, test1);
		Step_Start(16, "Click + button to add the nominals in the grid", test, test1);
		waitForElement(driver, add_Button_Journal);
		click(driver, add_Button_Journal);	
		waitForDisplay(driver, accountTransElements);
		if(isdisplayed(driver, accountTransElements)) {
		
		
		//bill of lading
		waitForElement(driver, accountTransElements);
		if(isdisplayed(driver, billOfLading_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, billOfLading_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, billOfLading_SearchButton_Jnl);
				globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Bol_Dr, globalSearch_Value_Bol_Dr, "", "", "", "");
				waitForElement(driver, accountTransElements);
			}
		}
		//main line service
		if(isdisplayed(driver, mainLineService_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineService_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineService_SearchButton_Jnl);
				twoColumnSearchWindow(driver, Main_Service_Select_Header, condition, service_Code_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//main line vessel
		if(isdisplayed(driver, mainLineVessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVessel_SearchButton_Jnl);
				twoColumnSearchWindow(driver, Main_Vessel_Select_Header, condition, vessel_Code_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  main line voyage bound
		if(isdisplayed(driver, mainLineVoyageBound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVoyageBound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVoyage_Search_Btn_Jnl);
				twoColumnSearchWindow(driver, Main_Voyage_Select_Header, condition, voyage_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  First Service
		if(isdisplayed(driver, first_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstService_SearchButton_JNL);
				twoColumnSearchWindow(driver, First_Service_Select_Header, condition, firstServiceCode_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  First Vessel
		if(isdisplayed(driver, first_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstVessel_SearchButton_JNL);
				twoColumnSearchWindow(driver, First_Vessel_Select_Header, condition, firstVesselCode_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  First Voyage/Bound
		if(isdisplayed(driver, first_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstVoyage_Bound_SearchButton);
				twoColumnSearchWindow(driver, First_Voyage_Select_Header, condition, firstVoyageBoundCode_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  Last Service
		if(isdisplayed(driver, last_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastService_SearchButton_JNL);
				twoColumnSearchWindow(driver, Last_Service_Select_Header, condition, lastServiceCode_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  Last Voyage/Bound
		if(isdisplayed(driver, last_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVoyage_Bound_SearchButton_JNL);
				twoColumnSearchWindow(driver, Last_Voyage_Select_Header, condition, lastVoyageBoundCode_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  Location/Port Of Origin	
		if(isdisplayed(driver, location_PortOfOrigin_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_PortOfOrigin_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_Port_Search_Btn_Jnl);
				twoColumnSearchWindow(driver, Port_Select_Header, condition, portCode_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  Location/Port Of Discharge	
		if(isdisplayed(driver, location_Pod_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_Pod_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_Port_Of_Discharge_SearchButton_JNL);
				twoColumnSearchWindow(driver, Discharge_Port_Select_Header, condition, dischargePortCode_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//depot_cfs
		if(isdisplayed(driver, depot_Cfs_Terminal_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, depot_Cfs_Terminal_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, depot_CFS_Terminal_SearchButton_JNL);
				twoColumnSearchWindow(driver, Depot_Select_Header, condition, depot_Cfs_Terminal_Data_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//eqp_type
		if(isdisplayed(driver, eqpType_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, eqpType_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, eqpType_SearchButton_JNL);
				twoColumnSearchWindow(driver, Eqp_Select_Header, condition, eqp_Type_Data_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//				Quantity
		if(isdisplayed(driver, quantity_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, quantity_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				waitForElement(driver, quantity_Textfield_JNL);
				sendKeys(driver, quantity_Textfield_JNL, quantity_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//				Agency
		if(isdisplayed(driver, agency_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, agency_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, agency_SearchButton);
				twoColumnSearchWindow(driver, Agency_Select_Header, condition, agency_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//vendor
		if(isdisplayed(driver, vendor_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, vendor_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, vendor_SearchButton_JNL);
				globalValueSearchWindow(driver, dropdownCondition, global_Search_Option1_Vendor_Dr, global_Search_Value1_Vendor_Code_Dr, "", "", "", "");
				waitForDisplay(driver, popup_Message);
				if(isdisplayed(driver, popup_Message)){
					click(driver, popup_Message_Ok_Button);
				}
				waitForElement(driver, accountTransElements);
			}
		}
		// Customer			
		if(isdisplayed(driver, customer_Checkbox)) {
			String actualStatus=getAttribute(driver, customer_Checkbox, "class");
			if(actualStatus.contains(status)) {
				click(driver, customerSearchButton_Ate_Window);
				globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Customer1_Dr, globalSearch_Value1_Dr, globalSearchFilterOption_Customer2_Dr, globalSearch_Value2_Dr, "", "");
				waitForDisplay(driver, popup_Message);
				if(isdisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Ok_Button);
				}
				waitForElement(driver, accountTransElements);
			}
		}
		//employee
		if(isdisplayed(driver, employee_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, employee_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, employee_SearchButton_JNL);
				twoColumnSearchWindow(driver, Employee_Select_Header, condition, employee_Data_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//departments
		if(isdisplayed(driver, departments_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, departments_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, departments_SearchButton_JNL);
				twoColumnSearchWindow(driver, Department_Select_Header, condition, department_Data_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//	Fuel Grade
		if(isdisplayed(driver,fuel_Grade_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Grade_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, fuelGrade_SearchButton_JNL);
				twoColumnSearchWindow(driver, Fuel_Select_Header, condition, fuelGrade_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  Last Vessel
		if(isdisplayed(driver, last_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVessel_SearchButton_JNL);
				twoColumnSearchWindow(driver, Last_Vessel_Select_Header, condition, lastVesselCode_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//contract_number
		if(isdisplayed(driver, contract_Num_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, contract_Num_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, contractNumber_SearchButton_JNL);
				twoColumnSearchWindow(driver, Contract_Select_Header, condition, contract_Num_Data_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//intercompany
		if(isdisplayed(driver, inter_Company_Codes_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, inter_Company_Codes_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, interCompanyCodes_SearchButton_JNL);
				twoColumnSearchWindow(driver, Company_Select_Header, condition, company_Code_Data_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//fueltype
		if(isdisplayed(driver, fuel_Type_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Type_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, fuelType_SearchButton_JNL);
				twoColumnSearchWindow(driver, Fuel_Type_Select_Header, condition, fuel_Type_Data_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//flowelement
		if(isdisplayed(driver, flow_Element_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, flow_Element_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, flowElement_SearchButton_JNL);
				twoColumnSearchWindow(driver, Flow_Code_Header, condition, flow_Code_Data_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//financial category
		if(isdisplayed(driver, financialCategory_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, financialCategory_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, financialCategory_SearchButton_JNL);
				twoColumnSearchWindow(driver, Finance_Category_Header, condition, financial_Category_Data_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//						Unit Price
		if(isdisplayed(driver,unitprice_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, unitprice_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				waitForElement(driver, unitPrice_Textfield_JNL);
				sendKeys(driver, unitPrice_Textfield_JNL, unitPrice_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//taxcode
		if(isdisplayed(driver, taxcode_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, taxcode_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, taxCode_SearchButton_JNL);
				twoColumnSearchWindow(driver, Tax_Code_Header, condition, tax_Code_Data_Dr);
				waitForElement(driver, accountTransElements);
			}
		}
		//reference
		if(isdisplayed(driver, reference_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, reference_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				waitForElement(driver, reference_Txtfld_Jnl);
				sendKeys(driver, reference_Txtfld_Jnl, reference_Data_Dr);
			}
		}
		waitForElement(driver, okButton_AddElements);
		jsClick(driver, okButton_AddElements);
		}
		Step_End(16, "Click + button to add the nominals in the grid", test, test1);
		Step_Start(17, " Select the nominal from the search button for Cr", test, test1);
		waitForElement(driver, dr_Cr_Dropdown);
		click(driver, dr_Cr_Dropdown);
		String select_Cr_Dr2=String.format(dr_Cr_Dropdown_Option, cr_Dr_Option2);
		waitForElement(driver, select_Cr_Dr2);
		click(driver, select_Cr_Dr2);
		waitForElement(driver, dr_Cr_SearchButton);
		click(driver, dr_Cr_SearchButton);	
		twoColumnSearchWindow(driver, nominal_Search_Header, condition, nominalName_Cr);
		Step_End(17, " Select the nominal from the search button for Cr", test, test1);
		Step_Start(18, "Enter the valid amount in amount text field for Cr.", test, test1);
		waitForElement(driver, amountTextfield);
		click(driver, amountTextfield);
		waitForElement(driver, amountTextfield);
		clearAndType(driver, amountTextfield, amount);
		waitForElement(driver, amountTextfield);
		click(driver, originalRef_Textfield);
		Step_End(18, "Enter the valid amount in amount text field for Cr.", test, test1);
		Step_Start(19, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change", test, test1);
		waitForElement(driver, currencySearchButton);
		click(driver, currencySearchButton);	
		twoColumnSearchWindow(driver, currency_Search_Header, condition, currencyCode);
		waitForElement(driver, localDescription_TextArea);
		sendKeys(driver, localDescription_TextArea, localDescription);
		Step_End(19, "Select the document currency using search bar from the currency details list and Based on that selected currency roe amount and home amount will change", test, test1);
		Step_Start(20, "Click + button to add the nominals in the grid ", test, test1);
		waitForElement(driver, add_Button_Journal);
		click(driver, add_Button_Journal);	
		waitForDisplay(driver, accountTransElements);
		if(isdisplayed(driver, accountTransElements)) {
		
		//bill of lading
		if(isdisplayed(driver, billOfLading_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, billOfLading_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, billOfLading_SearchButton_Jnl);
				globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Bol_Cr, globalSearch_Value_Bol_Cr, "", "", "", "");
				waitForElement(driver, accountTransElements);
			}
		}
		//main line service
		if(isdisplayed(driver, mainLineService_Checkbox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineService_Checkbox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineService_SearchButton_Jnl);
				twoColumnSearchWindow(driver, Main_Service_Select_Header, condition, service_Code_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//main line vessel
		if(isdisplayed(driver, mainLineVessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVessel_SearchButton_Jnl);
				twoColumnSearchWindow(driver, Main_Vessel_Select_Header, condition, vessel_Code_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  main line voyage bound
		if(isdisplayed(driver, mainLineVoyageBound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, mainLineVoyageBound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, mainLineVoyage_Search_Btn_Jnl);
				twoColumnSearchWindow(driver, Main_Voyage_Select_Header, condition, voyage_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  First Service
		if(isdisplayed(driver, first_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstService_SearchButton_JNL);
				twoColumnSearchWindow(driver, First_Service_Select_Header, condition, firstServiceCode_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  First Vessel
		if(isdisplayed(driver, first_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstVessel_SearchButton_JNL);
				twoColumnSearchWindow(driver, First_Vessel_Select_Header, condition, firstVesselCode_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  First Voyage/Bound
		if(isdisplayed(driver, first_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, first_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, firstVoyage_Bound_SearchButton);
				twoColumnSearchWindow(driver, First_Voyage_Select_Header, condition, firstVoyageBoundCode_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  Last Service
		if(isdisplayed(driver, last_Service_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Service_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastService_SearchButton_JNL);
				twoColumnSearchWindow(driver, Last_Service_Select_Header, condition, lastServiceCode_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  Last Voyage/Bound
		if(isdisplayed(driver, last_Voyage_Bound_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Voyage_Bound_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVoyage_Bound_SearchButton_JNL);
				twoColumnSearchWindow(driver, Last_Voyage_Select_Header, condition, lastVoyageBoundCode_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  Location/Port Of Origin	
		if(isdisplayed(driver, location_PortOfOrigin_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_PortOfOrigin_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_Port_Search_Btn_Jnl);
				twoColumnSearchWindow(driver, Port_Select_Header, condition, portCode_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  Location/Port Of Discharge	
		if(isdisplayed(driver, location_Pod_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, location_Pod_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, location_Port_Of_Discharge_SearchButton_JNL);
				twoColumnSearchWindow(driver, Discharge_Port_Select_Header, condition, dischargePortCode_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//depot_cfs
		if(isdisplayed(driver, depot_Cfs_Terminal_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, depot_Cfs_Terminal_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, depot_CFS_Terminal_SearchButton_JNL);
				twoColumnSearchWindow(driver, Depot_Select_Header, condition, depot_Cfs_Terminal_Data_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//eqp_type
		if(isdisplayed(driver, eqpType_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, eqpType_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, eqpType_SearchButton_JNL);
				twoColumnSearchWindow(driver, Eqp_Select_Header, condition, eqp_Type_Data_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//				Quantity
		if(isdisplayed(driver, quantity_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, quantity_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				waitForElement(driver, quantity_Textfield_JNL);
				sendKeys(driver, quantity_Textfield_JNL, quantity_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//				Agency
		if(isdisplayed(driver, agency_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, agency_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, agency_SearchButton);
				twoColumnSearchWindow(driver, Agency_Select_Header, condition, agency_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//vendor
		if(isdisplayed(driver, vendor_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, vendor_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, vendor_SearchButton_JNL);
				globalValueSearchWindow(driver, dropdownCondition, global_Search_Option1_Vendor_Cr, global_Search_Value1_Vendor_Code_Cr, "", "", "", "");
				waitForElement(driver, accountTransElements);
			}
		}
		//				customer	
		if(isdisplayed(driver, customer_Checkbox)) {
			String actualStatus=getAttribute(driver, customer_Checkbox, "class");
			if(actualStatus.contains(status)) {
				click(driver, customerSearchButton_Ate_Window);
				globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_Customer1_Cr, globalSearch_Value1_Cr, globalSearchFilterOption_Customer2_Cr, globalSearch_Value2_Cr, "", "");
				waitForDisplay(driver, popup_Message);
				if(isdisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Ok_Button);
				}
				waitForElement(driver, accountTransElements);
			}
		}
		//employee
		if(isdisplayed(driver, employee_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, employee_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, employee_SearchButton_JNL);
				twoColumnSearchWindow(driver, Employee_Select_Header, condition, employee_Data_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//departments
		if(isdisplayed(driver, departments_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, departments_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, departments_SearchButton_JNL);
				twoColumnSearchWindow(driver, Department_Select_Header, condition, department_Data_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//	Fuel Grade
		if(isdisplayed(driver,fuel_Grade_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Grade_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, fuelGrade_SearchButton_JNL);
				twoColumnSearchWindow(driver, Fuel_Select_Header, condition, fuelGrade_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//  Last Vessel
		if(isdisplayed(driver, last_Vessel_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, last_Vessel_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, lastVessel_SearchButton_JNL);
				twoColumnSearchWindow(driver, Last_Vessel_Select_Header, condition, lastVesselCode_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//contract_number
		if(isdisplayed(driver, contract_Num_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, contract_Num_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, contractNumber_SearchButton_JNL);
				twoColumnSearchWindow(driver, Contract_Select_Header, condition, contract_Num_Data_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//intercompany
		if(isdisplayed(driver, inter_Company_Codes_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, inter_Company_Codes_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, interCompanyCodes_SearchButton_JNL);
				twoColumnSearchWindow(driver, Company_Select_Header, condition, company_Code_Data_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//fueltype
		if(isdisplayed(driver, fuel_Type_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, fuel_Type_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, fuelType_SearchButton_JNL);
				twoColumnSearchWindow(driver, Fuel_Type_Select_Header, condition, fuel_Type_Data_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//flowelement
		if(isdisplayed(driver, flow_Element_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, flow_Element_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, flowElement_SearchButton_JNL);
				twoColumnSearchWindow(driver, Flow_Code_Header, condition, flow_Code_Data_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//financial category
		if(isdisplayed(driver, financialCategory_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, financialCategory_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, financialCategory_SearchButton_JNL);
				twoColumnSearchWindow(driver, Finance_Category_Header, condition, financial_Category_Data_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//						Unit Price
		if(isdisplayed(driver,unitprice_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, unitprice_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				waitForElement(driver, unitPrice_Textfield_JNL);
				sendKeys(driver, unitPrice_Textfield_JNL, unitPrice_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//taxcode
		if(isdisplayed(driver, taxcode_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, taxcode_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				click(driver, taxCode_SearchButton_JNL);
				twoColumnSearchWindow(driver, Tax_Code_Header, condition, tax_Code_Data_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		//reference
		if(isdisplayed(driver, reference_CheckBox_Jnl)) {
			String actualStatus=getAttribute(driver, reference_CheckBox_Jnl, "class");
			if(actualStatus.contains(status)) {
				waitForElement(driver, reference_Txtfld_Jnl);
				sendKeys(driver, reference_Txtfld_Jnl, reference_Data_Cr);
				waitForElement(driver, accountTransElements);
			}
		}
		waitForElement(driver, okButton_AddElements);
		jsClick(driver, okButton_AddElements);
		}
		Step_End(20, "Click + button to add the nominals in the grid ", test, test1);
		Step_Start(21, "Click save button in toolbar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message,journal_Saved_Popup_Expctd);
		String actualPopup=getText(driver, popup_Message);
		if(actualPopup.equals(journal_Saved_Popup_Expctd)) {
			System.out.println("Matched || Expected Pop-up value is : "+journal_Saved_Popup_Expctd+" || Actual Pop-up value is : "+actualPopup);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+journal_Saved_Popup_Expctd+" || Actual Pop-up value is : "+actualPopup, test, test1);
			click(driver, popup_Message_Ok_Button);	
		}else {
			System.out.println("Not Matched || Expected Pop-up value is : "+journal_Saved_Popup_Expctd+" || Actual Pop-up value is : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected Pop-up value is : "+journal_Saved_Popup_Expctd+" || Actual Pop-up value is : "+actualPopup, test, test1);
		}
		Step_End(21, "Click save button in toolbar", test, test1);
		Step_Start(22, "Total Cr and Dr will match ,transactions will save successfully .", test, test1);
		waitForElement(driver, debit_Value_Jnl);
		String debit_Value = getText(driver, debit_Value_Jnl);
		waitForElement(driver, credit_Value_Jnl);
		String credit_Value = getText(driver, credit_Value_Jnl);
		if(debit_Value.equals(credit_Value)) {
			System.out.println("MATCHED || DEBIT VALUE : "+debit_Value+ " || ACTUAL CREDIT VALUE : "+credit_Value);
			Extent_pass_New(driver, "MATCHED || DEBIT VALUE : "+debit_Value+ " || ACTUAL CREDIT VALUE : "+credit_Value, test, test1);
		}else {
			System.out.println("NOT MATCHED || DEBIT VALUE : "+debit_Value+ " || ACTUAL CREDIT VALUE : "+credit_Value);
			Extent_fail(driver, "NOT MATCHED || DEBIT VALUE : "+debit_Value+ " || ACTUAL CREDIT VALUE : "+credit_Value, test, test1);
		}
		Step_End(22, "Total Cr and Dr will match ,transactions will save successfully .", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}