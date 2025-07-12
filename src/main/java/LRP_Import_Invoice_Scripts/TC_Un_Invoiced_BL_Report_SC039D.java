package LRP_Import_Invoice_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Un_Invoiced_BL_Report_SC039D extends Keywords {

	public void Un_Invoiced_BL_Report_SC039D(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testcase_Name = "TC_Un_Invoiced_BL_Report_SC039D";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String uninvoiced_BL_Report_Module = Excel_data.get("Uninvoiced_BL_Report_Module");
		String Condition = Excel_data.get("Condition");
		String blType = Excel_data.get("BL_Type");
		String date_Input = Excel_data.get("Date");
		String scope = Excel_data.get("Scope");
		String service_input = Excel_data.get("service_input");
		String vessel_code_input = Excel_data.get("vessel_code_input");
		String voyage_code = Excel_data.get("voyage_code_input");
		String bl_RadioButton = Excel_data.get("BL_RadioButton");
		String MCN_RadioButton = Excel_data.get("MCN_RadioButton");
		String exclude_Checkbox = Excel_data.get("Exclude_Checkbox");
		String datePicker = Excel_data.get("DatePicker");

		String PLA_Code = Excel_data.get("PLA_Code");
		String POL_Code = Excel_data.get("POL_Code");
		String POD_code = Excel_data.get("POD_code");
		String PLD_Code = Excel_data.get("PLD_Code");
		String bl_Number = Excel_data.get("BL_Number");
		String columnHeaders = Excel_data.get("ColumnHeaders_All");
		String module_BillOfLading = Excel_data.get("Module_BillOfLading");
		String MCN_Module = Excel_data.get("MCN_Module");
		String Select_Search_Type_MCN = Excel_data.get("Select_Search_Type_MCN");
		String Select_Search_Type_BOL = Excel_data.get("Select_Search_Type_BOL");
		String globalSearchCondition = Excel_data.get("GlobalSearchCondition");
		String BOL_Customer_Table_Headers_For_Report = Excel_data.get("BOL_Customer_Table_Headers_For_Report");
		String MCN_Customer_Table_Headers_For_Report = Excel_data.get("MCN_Customer_Table_Headers_For_Report");
		String ServiceCode_Header = Excel_data.get("ServiceCode_Header");
		String VesselCode_Header = Excel_data.get("VesselCode_Header");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String PLA_Header = Excel_data.get("PLA_Header");
		String POL_Header = Excel_data.get("POL_Header");
		String POD_Header = Excel_data.get("POD_Header");
		String PLD_Header = Excel_data.get("PLD_Header");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String Region_Header = Excel_data.get("Region_Header");
		String CorporateAgencyCode_Header = Excel_data.get("CorporateAgencyCode_Header");
		String Scope_Value = Excel_data.get("Scope_Value");
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		if(!AgencyUser.trim().equals("")) {
	    	 Step_Start(1, "If it is Agency Switch the agency mentioned in Test Data  then follow below steps,", test,
						test1);

	    	 SwitchProfile(driver, AgencyUser);

	    	 Step_End(1, "If it is Agency Switch the agency mentioned in Test Data  then follow below steps,", test,
						test1);
	    }else {
	    	Step_Start(1, "if it is Line No need to switch agency u can Directly Open Module and go below", test,
					test1);

			System.out.println("Switched to Line");
			Extent_pass_New(driver, "Switched to Line", test, test1);

			Step_End(1, "if it is Line No need to switch agency u can Directly Open Module and go below", test, test1);
	    }

		Step_Start(2, "Open Uninvoiced BL Report", test, test1);

		moduleNavigate(driver, uninvoiced_BL_Report_Module);

		Step_End(2, "Open Uninvoiced BL Report", test, test1);

		Step_Start(3, "CLick on New Button,", test, test1);

		newButton(driver);

		Step_End(3, "CLick on New Button,", test, test1);
		Step_Start(4, "Select BL type (ALL/Export/Import) it has to be from Test Data,", test, test1);

		waitForElement(driver, bl_Type_Dropdown_UIB);
		click(driver, bl_Type_Dropdown_UIB);

		String select_blType = String.format(bl_Type_Dropdown_Option_UIB, blType);
		waitForElement(driver, select_blType);
		click(driver, select_blType);

		Step_End(4, "Select BL type (ALL/Export/Import) it has to be from Test Data,", test, test1);
		
		Step_Start(6,
				"Select BL/MCN Radio button(refer from Test data, Which is Applicable for only Export and Import if nothing entered to click anything)",
				test, test1);

		if (!blType.equalsIgnoreCase("All")) {

			if (bl_RadioButton.equalsIgnoreCase("Yes")) {

				waitForElement(driver, bl_RadioButton_UIB);
				click(driver, bl_RadioButton_UIB);

			} else if (MCN_RadioButton.equalsIgnoreCase("Yes")) {

				waitForElement(driver, mcn_RadioButton_UIB);
				click(driver, mcn_RadioButton_UIB);
			}
		}

		Step_End(6,
				"Select BL/MCN Radio button(refer from Test data, Which is Applicable for only Export and Import if nothing entered to click anything)",
				test, test1);
		
		Step_Start(5, "Select the Date (Refer from Test Data- if Date Not Give do pass Any date)", test, test1);
		waitForElement(driver, date_UIB);
		if (!date_Input.trim().equals("")) {
			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, date_UIB, date_Input);

			} else {
				click(driver, date_UIB);
				Newclear(driver, date_UIB);
				waitForElement(driver, date_UIB);
				sendKeys(driver, date_UIB, date_Input);
			}
		}

		Step_End(5, "Select the Date (Refer from Test Data- if Date Not Give do pass Any date)", test, test1);
		
		Step_Start(7, "Select Agency Scope(refer from test data-ALL/Region/Corporate Agency/Agency)", test, test1);

		waitForElement(driver, scope_Dropdown_UIB);
		click(driver, scope_Dropdown_UIB);

		String select_Scope = String.format(scope_Dropdown_Options_UIB, scope);
		waitForElement(driver, select_Scope);
		click(driver, select_Scope);

		Step_End(7, "Select Agency Scope(refer from test data-ALL/Region/Corporate Agency/Agency)", test, test1);
		Step_Start(8,
				"Select(+)Button, keep multiple selection as well, (For ALL option No need to Pass any code//Region/Corporate Agency/Agency then pass the code that has to be refer)",
				test, test1);

		if (AgencyUser.trim().equals("")) {
			if (scope.equalsIgnoreCase("Agency")) {
				waitForElement(driver, scope_Add_Button_UIB);
				click(driver, scope_Add_Button_UIB);
				twoColumnSearchWindowMultipleValue(driver, AgencyCode_Header, Condition, Scope_Value);
			}
			if (scope.equalsIgnoreCase("Region")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindowMultipleValue(driver, Region_Header, Condition, Scope_Value);
			}

			if (scope.equalsIgnoreCase("Corporate Agency")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindowMultipleValue(driver, CorporateAgencyCode_Header, Condition, Scope_Value);
			}
		}


		Step_End(8,
				"Select(+)Button, keep multiple selection as well, (For ALL option No need to Pass any code//Region/Corporate Agency/Agency then pass the code that has to be refer)",
				test, test1);
		Step_Start(9,
				"Keep below is optional,(But need in Test Data)\r\n" + "Service,Vessel,Voyage,Bound,PLA,,POL,POD,PLD",
				test, test1);

		if (!service_input.trim().equals("")) {
			waitForElement(driver, service_search_uninvoiced);
			click(driver, service_search_uninvoiced);
			twoColumnSearchWindow(driver, ServiceCode_Header, Condition, service_input);
		}
		if (!vessel_code_input.trim().equals("")) {
			waitForElement(driver, vessels_search_uninvoiced);
			click(driver, vessels_search_uninvoiced);
			twoColumnSearchWindow(driver, VesselCode_Header, Condition, vessel_code_input);

		}
		if (!voyage_code.trim().equals("")) {
			waitForElement(driver, voyage_search_uninvoiced);
			click(driver, voyage_search_uninvoiced);
			twoColumnSearchWindow(driver, Voyage_Header, Condition, voyage_code);
		}

		if (blType.equalsIgnoreCase("Export")) {
			if (!PLA_Code.trim().equals("")) {
				waitForElement(driver, PLA_SearchButton_UIB);
				click(driver, PLA_SearchButton_UIB);
				twoColumnSearchWindow(driver, PLA_Header, Condition, PLA_Code);
			}
			if (!POL_Code.equals("")) {
				waitForElement(driver, POL_SearchButton_UIB);
				click(driver, POL_SearchButton_UIB);

				twoColumnSearchWindow(driver, POL_Header, Condition, POL_Code);
			}
		}
		if (blType.equalsIgnoreCase("Import")) {
			if (!POD_code.equals("")) {
				waitForElement(driver, POD_SearchButton_UIB);
				click(driver, POD_SearchButton_UIB);
				twoColumnSearchWindow(driver, POD_Header, Condition, POD_code);
			}
			if (!PLD_Code.equals("")) {
				waitForElement(driver, PLD_SearchButton_UIB);
				click(driver, PLD_SearchButton_UIB);
				twoColumnSearchWindow(driver, PLD_Header, Condition, PLD_Code);
			}
		}

		Step_End(9,"Keep below is optional,(But need in Test Data)\r\n" + "Service,Vessel,Voyage,Bound,PLA,,POL,POD,PLD",
				test, test1);

		if (exclude_Checkbox.equalsIgnoreCase("Yes")) {
			waitForElement(driver, exclude_Reversal_Checkbox_UIB);
			click(driver, exclude_Reversal_Checkbox_UIB);
		}

		Step_Start(4, "Click on show button,", test, test1);

		waitForElement(driver, show_button_uninvoiced);
		click(driver, show_button_uninvoiced);

		waitForElement(driver, bl_Type_Field);
		String actualBL_Type = getText(driver, bl_Type_Field);
		System.out.println("actualBL_Type : " + actualBL_Type);

		Step_End(4, "Click on show button,", test, test1);
		Step_Start(5, "Filter the BL NO in BL/MCN NO Column.", test, test1);

		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);

		waitForElement(driver, conditionFilter_UIB);
		click(driver, conditionFilter_UIB);

		if (actualBL_Type.equalsIgnoreCase("All")) {
			waitForElement(driver, bl_MCN_Filter_UIB);
			sendKeys(driver, bl_MCN_Filter_UIB, bl_Number);

		} else {
			if (bl_RadioButton.equalsIgnoreCase("Yes")) {
				waitForElement(driver, bl_Number_Filter_UIB);
				sendKeys(driver, bl_Number_Filter_UIB, bl_Number);
			} else if (MCN_RadioButton.equalsIgnoreCase("Yes")) {
				waitForElement(driver, MCN_Filter_UIB);
				sendKeys(driver, MCN_Filter_UIB, bl_Number);
			}
		}

		
		Step_End(5, "Filter the BL NO in BL/MCN NO Column.", test, test1);
		Step_Start(6,	"go to Columns Shipment type, Line Revenue–OFR,Line Revenue–Others,Agency Revenue, Total Revenue and Customer Code ,Copy the Details.",
				test, test1);

		waitForElement(driver, unInvoiced_BL_Grid_Rows);
		String actualInvoiceType = "";
		String actual_BL_MCN_Number = "";

		
		if(!actualBL_Type.equals("All")) {
			actualInvoiceType=actualBL_Type;

			if (bl_RadioButton.equalsIgnoreCase("Yes")) {
				waitForElement(driver, MCN_Column_Grid_UIB);
				actual_BL_MCN_Number = getText(driver, MCN_Column_Grid_UIB);
				System.out.println("actual_BL_MCN_Number : " + actual_BL_MCN_Number);
			} else if (MCN_RadioButton.equalsIgnoreCase("Yes")) {
				waitForElement(driver, MCN_Column_Grid_UIB);
				actual_BL_MCN_Number = getText(driver, MCN_Column_Grid_UIB);
				System.out.println("actual_BL_MCN_Number : " + actual_BL_MCN_Number);
			}
		}else {
			waitForElement(driver, BL_MCN_Column_UIB);
			actual_BL_MCN_Number = getText(driver, BL_MCN_Column_UIB);
			System.out.println("actual_BL_MCN_Number : " + actual_BL_MCN_Number);
			waitForElement(driver, invoiceType_GridCell_UIB);
			actualInvoiceType = getText(driver, invoiceType_GridCell_UIB);
			System.out.println("actualInvoiceType : " + actualInvoiceType);
			
		}
		
		reArrangeAG_GridColumnsNew(driver, grid_Columns_Button_UIB, columnHeaders);
		
		List<String> tableHeaders=splitAndExpand(columnHeaders,",");
		waitForElement(driver, Uninvoiced_BL_Report_Table);
		List<Map<String, String>> UnInvoiced_TableData = extractTableDataByColumn(driver, Uninvoiced_BL_Report_Table);
		String UnInvoiced_Table_Data=TableDataForReport(driver,UnInvoiced_TableData,"UnInvoiced Table Data",tableHeaders);
		
		
		String actual_CustomerCode="";
		if(isdisplayed(driver, customerCode_GridCell_UIB)) {
			waitForElement(driver, customerCode_GridCell_UIB);
			actual_CustomerCode = getText(driver, customerCode_GridCell_UIB);
			System.out.println("actual_CustomerCode : " + actual_CustomerCode);
		}
		
		
		String CustomerName_UIBL="";
		if(isdisplayed(driver, Customer_Name_Column_UIB)) {
			waitForElement(driver, Customer_Name_Column_UIB);
			CustomerName_UIBL = getText(driver, Customer_Name_Column_UIB);
			System.out.println("CustomerName_UIBL : " + CustomerName_UIBL);
		}
		
		
		Step_End(6,	"go to Columns Shipment type, Line Revenue–OFR,Line Revenue–Others,Agency Revenue, Total Revenue and Customer Code ,Copy the Details.",
				test, test1);

		Extent_call(test, test1, "In BL/MCN No column has Only the BL NO then Open BL of lading module,");

		if (!actual_BL_MCN_Number.contains("<-->")) { // AE00216200<-->AE00216200CV3

			scrollTop(driver);

			Step_Start(7, "Open Bill of Lading module", test, test1);

			Extent_cal(test, test1, module_BillOfLading);
			moduleNavigate(driver, module_BillOfLading);

			Step_End(7, "Open Bill of Lading module", test, test1);
			Step_Start(8, "Load the same BL Number", test, test1);

			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, globalSearchCondition, Select_Search_Type_BOL, bl_Number, "", "", "", "");

			Step_End(8, "Load the same BL Number", test, test1);
			Step_Start(9, "Go to Customer Tab,", test, test1);

			waitForElement(driver, blNo_Textfield_BOL);
			String actual_BL_Number_BOL = getAttribute(driver, blNo_Textfield_BOL, "value");
			System.out.println("actual_BL_Number_BOL : " + actual_BL_Number_BOL);

			waitForElement(driver, bookNo_Textfield_BOL);
			String actual_Book_Number_BOL = getAttribute(driver, bookNo_Textfield_BOL, "value");
			System.out.println("actual_Book_Number_BOL : " + actual_Book_Number_BOL);

			waitForElement(driver, BL_customerTab);
			click1(driver, BL_customerTab);

			Step_End(9, "Go to Customer Tab,", test, test1);
			Step_Start(10, "Compare Values Customer Code Code of AP. and uninvoiced BL Report", test, test1);

			waitForElement(driver, BL_Customer_Table_Row);
			waitForElement(driver, BL_Customer_Table_Header);
			List<Map<String, String>> BL_Customer_Tabledata = getTableData(driver, BL_Customer_Table_Header,
					BL_Customer_Table_Row);
			List<String> BL_columnheaders = splitAndExpand(BOL_Customer_Table_Headers_For_Report);
			String BL_Tabledata = TableDataForReport(driver, BL_Customer_Tabledata, "BOL Customer Table", BL_columnheaders);
			
			List<String> customerCode_AP = getValuesByFirstColumnAndHeader(BL_Customer_Tabledata, "Customer Type", "AP",
					"Customer code");

			List<String> customerName_AP = getValuesByFirstColumnAndHeader(BL_Customer_Tabledata, "Customer Type", "AP",
					"Name");
			
			String AP_Customer_Code = customerCode_AP.get(0);
			String AP_Customer_Name = customerName_AP.get(0);
			
			System.out.println("AP_Customer_Code : " + AP_Customer_Code);
			System.out.println("AP_Customer_Name : " + AP_Customer_Name);

			Extent_pass_New(driver, "Bill of Lading Customer Table "+BL_Tabledata, test, test1);
			Extent_pass_New(driver,"Un Invoiced BL Report Table"+UnInvoiced_Table_Data,test,test1);
			if (AP_Customer_Code.equals(actual_CustomerCode)) {
				System.out.println("Matched || AP Customer Code in Uninvoiced BL Report : " + actual_CustomerCode
						+ " || AP Customer Code in Bill of Lading : " + AP_Customer_Code);
				Extent_pass_New(driver, "Matched || AP Customer Code in Uninvoiced BL Report : " + actual_CustomerCode
						+ " || AP Customer Code in Bill of Lading : " + AP_Customer_Code, test, test1);
			} else {
				System.out.println("Not Matched || AP Customer Code in Uninvoiced BL Report : " + actual_CustomerCode
						+ " || AP Customer Code in Bill of Lading : " + AP_Customer_Code);
				Extent_fail(driver, "Not Matched || AP Customer Code in Uninvoiced BL Report : " + actual_CustomerCode
						+ " || AP Customer Code in Bill of Lading : " + AP_Customer_Code, test, test1);
			}

			if (AP_Customer_Name.equals(CustomerName_UIBL)) {
				System.out.println("Matched || AP Customer Name in Uninvoiced BL Report : " + CustomerName_UIBL
						+ " || AP Customer Code in Bill of Lading : " + AP_Customer_Name);
				Extent_pass_New(driver, "Matched || AP Customer Name in Uninvoiced BL Report : " + CustomerName_UIBL
						+ " || AP Customer Code in Bill of Lading : " + AP_Customer_Name, test, test1);
			} else {
				System.out.println("Not Matched || AP Customer Name in Uninvoiced BL Report : " + CustomerName_UIBL
						+ " || AP Customer Name in Bill of Lading : " + AP_Customer_Name);
				Extent_fail(driver, "Not Matched || AP Customer Name in Uninvoiced BL Report : " + CustomerName_UIBL
						+ " || AP Customer Name in Bill of Lading : " + AP_Customer_Name, test, test1);
			}
			
			Step_End(10, "Compare Values Customer Code Code of AP. and uninvoiced BL Report", test, test1);

			
		} else if (actual_BL_MCN_Number.contains("<-->") || MCN_RadioButton.equalsIgnoreCase("Yes")) {

			Extent_call(test, test1, "\r\n"
					+ "In BL/MCN No Column has Both BL and MCN No then Open MCN Module(In-case of multiple MCN system has to go to latest MCN");

			String actual_Number[] = actual_BL_MCN_Number.split(">");
			String actual_BL_MCN_Number_UIB = actual_Number[1];
			System.out.println("actual_BL_MCN_Number_UIB : " + actual_BL_MCN_Number_UIB);

			scrollTop(driver);
			Extent_cal(test, test1, MCN_Module);
			moduleNavigate(driver, MCN_Module);

			waitForElement(driver, SearchButton_Toolbar);

			click(driver, SearchButton_Toolbar);
			waitForElement(driver, globalSearch_Condition_Dropdown1);

			globalValueSearchWindow(driver, globalSearchCondition, Select_Search_Type_MCN, actual_BL_MCN_Number_UIB, "",
					"", "", "");

			Step_Start(7, "Go to Customer Tab,", test, test1);

			waitForElement(driver, customer_Tab_MCN);
			click(driver, customer_Tab_MCN);

			Step_End(7, "Go to Customer Tab,", test, test1);
			Step_Start(8, "Compare Values Customer Code Code of AP. and uninvoiced BL Report", test, test1);

			waitForElement(driver, MCN_Customer_Table_Rows);

			List<Map<String, String>> MCN_Customer_Tabledata = getTableData(driver, MCN_Customer_Table_Headers,
					MCN_Customer_Table_Rows);
			List<String> MCN_columnheaders = splitAndExpand(MCN_Customer_Table_Headers_For_Report);
			String MCN_Tabledata = TableDataForReport(driver, MCN_Customer_Tabledata, "MCN Customer Table",
					MCN_columnheaders);// Assuming you have these lists

			List<String> customerCode_AP = getValuesByFirstColumnAndHeader(MCN_Customer_Tabledata, "Customer Type",
					"AP", "Customer Code");

			List<String> customerName_AP = getValuesByFirstColumnAndHeader(MCN_Customer_Tabledata, "Customer Type",
					"AP", "Name");

			String AP_Customer_Code = customerCode_AP.get(0);
			String AP_Customer_Name = customerName_AP.get(0);
			System.out.println("AP_Customer_Code : " + AP_Customer_Code);
			System.out.println("AP_Customer_Name : " + AP_Customer_Name);

			Extent_pass_New(driver, "MCN Customer Table : "+MCN_Tabledata, test, test1);
			Extent_pass_New(driver,"Un Invoiced BL Report Table"+UnInvoiced_Table_Data,test,test1);
			if (AP_Customer_Code.equals(actual_CustomerCode)) {
				System.out.println("Matched || AP Customer Code in Uninvoiced BL Report : " + actual_CustomerCode
						+ " || AP Customer Code in MCN : " + AP_Customer_Code);
				Extent_pass_New(driver, "Matched || AP Customer Code in Uninvoiced BL Report : " + actual_CustomerCode
						+ " || AP Customer Code in MCN : " + AP_Customer_Code, test, test1);
			} else {
				System.out.println("Not Matched || AP Customer Code in Uninvoiced BL Report : " + actual_CustomerCode
						+ " || AP Customer Code in MCN : " + AP_Customer_Code);
				Extent_fail(driver, "Not Matched || AP Customer Code in Uninvoiced BL Report : " + actual_CustomerCode
						+ " || AP Customer Code in MCN : " + AP_Customer_Code, test, test1);
			}

			
			if (AP_Customer_Name.equals(CustomerName_UIBL)) {
				System.out.println("Matched || AP Customer Name in Uninvoiced BL Report : " + CustomerName_UIBL
						+ " || AP Customer Code in MCN : " + AP_Customer_Name);
				Extent_pass_New(driver, "Matched || AP Customer Name in Uninvoiced BL Report : " + CustomerName_UIBL
						+ " || AP Customer Code in MCN : " + AP_Customer_Name, test, test1);
			} else {
				System.out.println("Not Matched || AP Customer Name in Uninvoiced BL Report : " + CustomerName_UIBL
						+ " || AP Customer Name in MCN : " + AP_Customer_Name);
				Extent_fail(driver, "Not Matched || AP Customer Name in Uninvoiced BL Report : " + CustomerName_UIBL
						+ " || AP Customer Name in MCN : " + AP_Customer_Name, test, test1);
			}
			
			Step_End(8, "Compare Values Customer Code Code of AP. and uninvoiced BL Report", test, test1);
		}

		Extent_completed(testcase_Name, test, test1);
		
	}
}
