package LRP_Import_Invoice_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Invoice_Status_Report_SC038E extends Keywords {

	public void Invoice_Status_Report_SC038E(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Invoice_Status_Report_SC038E";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Invoice_ModuleType = Excel_data.get("Invoice_ModuleType");
		String Select_Invoice_Mode = Excel_data.get("Select_Invoice_Mode");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Invoice_GlobalSearch_Type1 = Excel_data.get("Invoice_GlobalSearch_Type1");
		String Invoice_GlobalSearch_Value1 = Excel_data.get("Invoice_GlobalSearch_Value1");
		String Invoice_GlobalSearch_Type2 = Excel_data.get("Invoice_GlobalSearch_Type2");
		String Invoice_GlobalSearch_Value2 = Excel_data.get("Invoice_GlobalSearch_Value2");
		String Invoice_GlobalSearch_Type3 = Excel_data.get("Invoice_GlobalSearch_Type3");
		String Invoice_GlobalSearch_Value3 = Excel_data.get("Invoice_GlobalSearch_Value3");
		
		String Service_Details_Headers_Invoice = Excel_data.get("Service_Details_Headers_Invoice");
		String Invoice_Status_Module = Excel_data.get("Invoice_Status_Module");
		String Invoice_Status_Report_StartDate = Excel_data.get("Invoice_Status_Report_StartDate");
		String Invoice_Status_Report_EndDate = Excel_data.get("Invoice_Status_Report_EndDate");
		String Service_Headers_Invoice_Status_Report = Excel_data.get("Service_Headers_Invoice_Status_Report");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);

		Step_Start(1, "Open Invoice Module", test, test1);

		moduleNavigate(driver, Invoice_ModuleType);
		waitForElement(driver, SearchButton_Toolbar);

		Step_End(1, "Open Invoice Module", test, test1);

		Step_Start(2, "Select the Invoice Mode", test, test1);
		waitForElement(driver, Invoice_Mode_Input_All);
		click(driver, Invoice_Mode_Input_All);

		String modeSelect = String.format(DropDown_Select, Select_Invoice_Mode);
		
		waitForElement(driver, modeSelect);
		click(driver, modeSelect);
		Step_End(2, "Select the Invoice Mode", test, test1);

		Step_Start(3, " Click Search Button and Load the BL", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow1(driver, Global_Search_Condition, Invoice_GlobalSearch_Type1, Invoice_GlobalSearch_Value1, Invoice_GlobalSearch_Type2, Invoice_GlobalSearch_Value2,Invoice_GlobalSearch_Type3, Invoice_GlobalSearch_Value3);

		Step_Start(4,
				" Verify that Invoice not in VOID status - If it is VOID Exist and Msg to delivered as Data is not Correct",
				test, test1);

		waitForElement(driver, Invoice_StatusHeader);
		String columnnum = getAttribute(driver, Invoice_StatusHeader, "aria-colindex");
		String statusColum = String.format(Invoice_StatusColumn, columnnum);
		waitForElement(driver, statusColum);
		String StatusValue = getText(driver, statusColum);

		if (StatusValue.equalsIgnoreCase("VOID")) {
			System.out.println("Invoice status is VOID, please check the input ");
			Extent_FailNew(driver, "Invoice status is VOID, please check the input ", test, test1);
		}
		Step_End(4,
				" Verify that Invoice not in VOID status - If it is VOID Exist and Msg to delivered as Data is not Correct",
				test, test1);
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
		Step_End(3, " Click Search Button and Load the BL", test, test1);

		waitForElement(driver, Invoice_Table_Row_All);
		List<Map<String, String>> TabledataFull = getTableData(driver, Invoice_Table_Header_All, Invoice_Table_Row_All);
		String StartDate=getFirstValueByHeader(TabledataFull,"Inv Date");
		String InvoiceNumber=getFirstValueByHeader(TabledataFull,"Inv Number");
		System.out.println("StartDate : "+StartDate);
		System.out.println("Invoice_Status_Report_StartDate : "+Invoice_Status_Report_StartDate);

	    String Inv_Sts_Rep_StartDate=beforeDaysToDate(StartDate, Invoice_Status_Report_StartDate);
	    String Inv_Sts_Rep_EndDate=addDaysToDate(StartDate, Invoice_Status_Report_EndDate);
		
		Map<String, String> ServiceDetails = new HashMap<String, String>();

		String ServiceValue;
		String VesselValue;
		String VoyageValue;
		if (Invoice_ModuleType.equalsIgnoreCase("Export Invoice")) {
			waitForElement(driver, Service_Field_Export);
			ServiceValue = getAttribute(driver, Service_Field_Export, "value");
		} else {
			waitForElement(driver, service_Txtfield_All);
			ServiceValue = getAttribute(driver, service_Txtfield_All, "value");
		}

		if (Invoice_ModuleType.equalsIgnoreCase("Invoice")) {
			waitForElement(driver, Vessel_TxtField_Invoice);
			VesselValue = getAttribute(driver, Vessel_TxtField_Invoice, "value");
		} else {
			waitForElement(driver, vessel_Txtfield_All);
			VesselValue = getAttribute(driver, vessel_Txtfield_All, "value");
		}

		if (Invoice_ModuleType.equalsIgnoreCase("Invoice")) {
			VoyageValue = getAttribute(driver, voyage_Txtfield_Invoice, "value");
		} else {
			VoyageValue = getAttribute(driver, voyage_Txtfield_All, "value");
		}

		String BoundValue = getText(driver, BoundInput_All);
		String POL_Value;
		if (Invoice_ModuleType.equalsIgnoreCase("Invoice")) {
			POL_Value = getAttribute(driver, POL_Input_Invoice, "value");
		} else {
			POL_Value = getText(driver, POL_Input_All);
		}

		String POL_TerminalValue = getText(driver, POLTerminal_Input_All);
		
		
		String PODValue = "";
		if(Invoice_ModuleType.equalsIgnoreCase("Invoice")) {
			PODValue = getAttribute(driver, POD_Input_invoice,"value");
		}else {
			PODValue = getText(driver, POD_Input_All);
		}
		String POD_TerminalValue = getText(driver, PODTerminal_Input_All);
		String Call_IdValue;
		if (Invoice_ModuleType.equalsIgnoreCase("Invoice")) {
			Call_IdValue = getAttribute(driver, Call_Id_Input_Invoice, "value");
		} else {
			Call_IdValue = getText(driver, Call_Id_Input_All);
		}
		String ETAValue = getText(driver, ETA_Date_Input_All);
		String BL_Number_input = getAttribute(driver, BL_Number_Input_All, "value");

		if(BL_Number_input.equals("-")) {
			BL_Number_input="";
		}
		if (!Select_Invoice_Mode.equals("Manifest Corrector Invoice")) {
			ServiceDetails.put("BL Number", BL_Number_input);
		} else {
			ServiceDetails.put("MCN Number", BL_Number_input);
		}
		
		ServiceDetails.put("Invoice Number", InvoiceNumber);
				
		List<String> ServiceHeaders = splitAndExpand(Service_Details_Headers_Invoice);
		for (String head : ServiceHeaders) {
			if (head.equals("Service")) {
				ServiceDetails.put(head, ServiceValue);
			} else if (head.equals("Vessel")) {
				ServiceDetails.put(head, VesselValue);
			} else if (head.equals("Voyage")) {
				ServiceDetails.put(head, VoyageValue);
			} else if (head.equals("Bound")) {
				ServiceDetails.put(head, BoundValue);
			} else if (head.equals("POL")) {
				ServiceDetails.put(head, POL_Value);
			} else if (head.equals("POL~Terminal")) {
				ServiceDetails.put(head, POL_TerminalValue);
			} else if (head.equals("POD")) {
				ServiceDetails.put(head, PODValue);
			} else if (head.equals("POD~Terminal")) {
				ServiceDetails.put(head, POD_TerminalValue);
			} else if (head.equals("Call ID")) {
				ServiceDetails.put(head, Call_IdValue);
			} else if (head.equals("ETA") || head.equals("ETD")) {
				ServiceDetails.put(head, ETAValue);
			}
		}
				
		moduleNavigate(driver, Invoice_Status_Module);
		waitForElement(driver, NewButton_ToolBar);
		Step_End(5, "Go to Invoice status Report", test, test1);

		Step_Start(6, "select from and To date as per Invoice Date", test, test1);

		waitForElement(driver, FromDate_ISR);
		selectDatePicker(driver, FromDate_ISR, Inv_Sts_Rep_StartDate);

		waitForElement(driver, ToDate_ISR);
		selectDatePicker(driver, ToDate_ISR, Inv_Sts_Rep_EndDate);
		
		Step_End(6, "select from and To date as per Invoice Date", test, test1);

		Step_Start(7, "click on show Button", test, test1);

		waitForElement(driver, ShowButton_ISR);
		click(driver, ShowButton_ISR);
	
		waitForElement(driver, TableGrid_ISR);
		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);

		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);

		waitForElement(driver, II_Status_Column);
		click(driver, II_Status_Column);

		waitForElement(driver, Column_Search_Input);
		click(driver, SelectAll_Column_CheckBox);
		
		List<String> columns = splitAndExpand(Service_Headers_Invoice_Status_Report);
		for (String column : columns) {
			
			waitForElement(driver, Column_Search_Input);
			clear(driver, Column_Search_Input);
			waitForElement(driver, Column_Search_Input);
			sendKeys(driver, Column_Search_Input, column);

			String checkbox = String.format(Select_Column_tableHead, column);
			waitForElement(driver, checkbox);
			jsClick(driver, checkbox);
		}

		waitForElement(driver, II_Status_Column);
		click(driver, II_Status_Column);
		
		if(InvoiceNumber!=null&&!InvoiceNumber.equals("-")) {
			waitForElement(driver, InVoiceNumber_FilterInput);
			Newclear(driver, InVoiceNumber_FilterInput);
			sendKeys(driver, InVoiceNumber_FilterInput, InvoiceNumber);
		}
		
		if (Select_Invoice_Mode.equals("Manifest Corrector Invoice")) {
			if(BL_Number_input!=null&&!BL_Number_input.equals("-")) {
				waitForElement(driver, MCN_NumberFilter_Input);
				Newclear(driver, MCN_NumberFilter_Input);
				sendKeys(driver, MCN_NumberFilter_Input, BL_Number_input);
			}
		}else {
			if(BL_Number_input!=null&&!BL_Number_input.equals("-")) {
				waitForElement(driver, BL_Search_input);
				Newclear(driver, BL_Search_input);
				sendKeys(driver, BL_Search_input, BL_Number_input);
			}
		}
		
		waitForElement(driver, TableGrid_ISR);
		waitForElement(driver, statusReporttableRow);
		List<Map<String, String>> StatusReport_TableData = extractTableDataByColumn(driver, TableGrid_ISR);
		System.out.println("StatusReport_TableData : " + StatusReport_TableData);
		
		Map<String,String> Act_ServiceDetails=StatusReport_TableData.get(0);
		String ExpectedTable=ReportTable(ServiceDetails,"Invoice Table data");
		String ActualTable=ReportTable(Act_ServiceDetails,"Status Report Table");
		
		if (CompareMapValues(ServiceDetails, Act_ServiceDetails)) {
			System.out.println(	"Matched || Expected value was : " + ExpectedTable + " || Actual value was : " + ActualTable);
			Extent_pass_New(driver,"Matched || Expected  : \n" + "<pre>" + ExpectedTable
							+ "</pre> \n " + "|| Actual : \n" + "<pre>" + ActualTable
							+ "</pre>",
					test, test1);
		} else {
			System.out.println(	"Not Matched || Expected value was : " + ExpectedTable + " || Actual value was : " + ActualTable);
			Extent_fail(driver,"Not Matched || Expected  : \n" + "<pre>" + ExpectedTable
							+ "</pre> \n " + "|| Actual : \n" + "<pre>" + ActualTable
							+ "</pre>",
					test, test1);
		}
		
		
	
	}
}
