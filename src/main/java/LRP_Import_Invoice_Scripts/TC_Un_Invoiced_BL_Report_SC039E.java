package LRP_Import_Invoice_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Un_Invoiced_BL_Report_SC039E extends Keywords {

	public void Un_Invoiced_BL_Report_SC039E(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {
		
		String testcase_Name = "TC_Un_Invoiced_BL_Report_SC039E";

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
		String Select_Search_Type_IMD = Excel_data.get("Select_Search_Type_IMD");
		String globalSearchCondition = Excel_data.get("GlobalSearchCondition");
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
		
		String Import_DocumentModule = Excel_data.get("Import_DocumentModule");
		String Collect_ChargesHeaders = Excel_data.get("Collect_ChargesHeaders");
		String Agency_Roe_Module = Excel_data.get("Agency_Roe_Module");
		String Agency_Roe_FilterType = Excel_data.get("Agency_Roe_FilterType");
		String Agency_ROE_Currency_Header = Excel_data.get("Agency_ROE_Currency_Header");
		String Agency_ROE_Header = Excel_data.get("Agency_ROE_Header");		
		
		
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
		Step_Start(5, "Select the Date (Refer from Test Data- if Date Not Give do pass Any date)", test, test1);
		waitForElement(driver, date_UIB);
		if (!date_Input.equals("")) {
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

		Step_End(6,"Select BL/MCN Radio button(refer from Test data, Which is Applicable for only Export and Import if nothing entered to click anything)",
				test, test1);
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

		if (blType.endsWith("All")) {
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

		String actualInvoiceType = "";
		String actual_BL_MCN_Number = "";
		
		Step_End(5, "Filter the BL NO in BL/MCN NO Column.", test, test1);
		Step_Start(6,	"go to Columns Shipment type, Line Revenue–OFR,Line Revenue–Others,Agency Revenue, Total Revenue and Customer Code ,Copy the Details.",
				test, test1);

		waitForElement(driver, unInvoiced_BL_Grid_Rows);
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
		
		waitForElement(driver, agencyRevenue_GridCell_UIB);
		String actual_AgencyRevenue = getText(driver, agencyRevenue_GridCell_UIB);
		System.out.println("actual_AgencyRevenue : " + actual_AgencyRevenue);
		String actual_Agency_Revenue_STR = actual_AgencyRevenue.replace(",", "");
		double actual_Agency_Revenue = getNumberValue(actual_Agency_Revenue_STR);

		
		Step_End(6,
				"go to Columns Shipment type, Line Revenue–OFR,Line Revenue–Others,Agency Revenue, Total Revenue and Customer Code ,Copy the Details.",
				test, test1);
		
		moduleNavigate(driver, Import_DocumentModule);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, globalSearchCondition, Select_Search_Type_IMD, bl_Number, "", "", "", "");
		
		
		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);

		scrollBottom(driver);
		waitForElement(driver, collectChargersTab_Manifest_Rows);
		List<Map<String, String>> collect_Chareges_Tabledata = getTableData(driver, collectChargersTab_Coloumns, collectChargersTab_Manifest_Rows);
		List<String> headersCollect=splitAndExpand(Collect_ChargesHeaders);
		String CollectTable=TableDataForReport(driver,collect_Chareges_Tabledata,"Collect Charges Table Data",headersCollect);
		
		Map<String,List<String>> Collect_ChargesValues=getColumnValuesByHeaders1(collect_Chareges_Tabledata,"Type","Agency",headersCollect);
		
		List<String> Currency_Values=Collect_ChargesValues.get("Currency");
		List<String> Amount_Values=Collect_ChargesValues.get("Amount");

		scrollTop(driver);
		waitForElement(driver, Actual_Eta_Date);
		String ETA_DateValue=getText(driver, Actual_Eta_Date);
		
		moduleNavigate(driver, Agency_Roe_Module);
		waitForElement(driver, SearchButton_Toolbar);
		scrollTop(driver);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			waitForDisplay(driver, popup_Message_Ok_Button);
			jsClick(driver, popup_Message_Ok_Button);
			waitForElement(driver, SearchButton_Toolbar);
		}
		
		click(driver, SearchButton_Toolbar);
		
		waitForElement(driver, type_Select1);
		click(driver, type_Select1);
		waitForElement(driver, type_Select1);
		selectByText(driver, type_Select1, Agency_Roe_FilterType);
		waitForElement(driver, Date_Condition);
		selectByText(driver, Date_Condition, globalSearchCondition);
		waitForElement(driver, Date_Input_);
		sendKeys(driver, Date_Input_, ETA_DateValue);

		waitForElement(driver, globalSearch_Frame_SearchButton);
		click(driver, globalSearch_Frame_SearchButton);
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
				
		waitForElement(driver, Corporate_Option_AgencyROE);
		click(driver,Corporate_Option_AgencyROE);
		
		waitForElement(driver, AgencyRoe_TableRow);
		List<Map<String, String>> AgencyROE_TableFul = getTableData(driver, AgencyRoe_TableHeader,
				AgencyRoe_TableRow);
		
		
		Map<String,String> Roe_ValuesMap=new HashMap<String, String>();
		
		List<String> uniqueValues = Currency_Values.stream()
		        .distinct()
		        .collect(Collectors.toList());
		
		for(String Cur:uniqueValues) {
			String Cur_Value = getValueByFirstColumnAndHeader(AgencyROE_TableFul, Agency_ROE_Currency_Header,
					Cur, Agency_ROE_Header);
			Roe_ValuesMap.put(Cur, Cur_Value);
		}
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		String Roe_ValueTable=ReportTable(Roe_ValuesMap,"Roe Table");//
		
		waitForElement(driver, collectChargersTab_Manifest_Rows);
		double Exp_AgencyRevenue=0;
		for(int i=0;i<Amount_Values.size();i++) {
			
			String ActAmount=Amount_Values.get(i);
			String RoeVal=Roe_ValuesMap.get(Currency_Values.get(i));
			
			double AmountNum=getNumberValue1(ActAmount);
			double RoeNum=getNumberValue1(RoeVal);
			Exp_AgencyRevenue=Exp_AgencyRevenue+(AmountNum/RoeNum);
		}
		
		Extent_call(test, test1, "Un Invoiced BL Report Table Data: "+UnInvoiced_Table_Data);
		Extent_call(test, test1, "Collect Charges Table Data : "+CollectTable);
		Extent_call(test, test1, "Roe Charges Table : "+Roe_ValueTable);
		
		Exp_AgencyRevenue=Double.parseDouble(String.format("%.2f", Exp_AgencyRevenue));
		
		double a = Math.round(actual_Agency_Revenue * 10) / 10.0;  // Rounds to 472.5
        double b = Math.round(Exp_AgencyRevenue * 10) / 10.0;
		
        
		if(a==b) {
			
			System.out.println("Matched || Agency Revenue Import Documentation  : " + Exp_AgencyRevenue
					+ " || Agency Revevenue in Uninvoiced BL Report : " + actual_Agency_Revenue);
			Extent_pass_New(driver,"Matched || Agency Revenue Import Documentation  : " + Exp_AgencyRevenue
					+ " || Agency Revevenue in Uninvoiced BL Report : " + actual_Agency_Revenue,
					test, test1);
		} else {
			System.out.println("Not Matched || Agency Revenue Import Documentation  : " + Exp_AgencyRevenue
					+ " || Agency Revevenue in Uninvoiced BL Report : " + actual_Agency_Revenue);
			Extent_fail(driver,"Not Matched || Agency Revenue Import Documentation  : " + Exp_AgencyRevenue
					+ " || Agency Revevenue in Uninvoiced BL Report : " + actual_Agency_Revenue,
					test, test1);
		}		
		
		
		Extent_completed(testcase_Name, test, test1);
		
	}
}
