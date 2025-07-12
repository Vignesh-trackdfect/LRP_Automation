package LRP_Import_Invoice_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Invoice_Status_Report_SC038A extends Keywords {

	public void Invoice_Status_Report_SC038A(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Invoice_Status_Report_SC038A";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Select_Invoice_Mode = Excel_data.get("Select_Invoice_Mode");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Invoice_GlobalSearch_Type1 = Excel_data.get("Invoice_GlobalSearch_Type1");
		String Invoice_GlobalSearch_Value1 = Excel_data.get("Invoice_GlobalSearch_Value1");
		String Invoice_GlobalSearch_Type2 = Excel_data.get("Invoice_GlobalSearch_Type2");
		String Invoice_GlobalSearch_Value2 = Excel_data.get("Invoice_GlobalSearch_Value2");
		String Invoice_GlobalSearch_Type3 = Excel_data.get("Invoice_GlobalSearch_Type3");
		String Invoice_GlobalSearch_Value3 = Excel_data.get("Invoice_GlobalSearch_Value3");
		String Invoice_Validation_Row = Excel_data.get("Invoice_Validation_Row");
		String Invoice_Headers_Validate = Excel_data.get("Invoice_Headers_Validate");
		String Invoice_Status_Module = Excel_data.get("Invoice_Status_Module");
		String Invoice_Status_Table_Headers = Excel_data.get("Invoice_Status_Table_Headers");
		String Invoice_ModuleType = Excel_data.get("Invoice_ModuleType");
		String Invoice_Status_Report_StartDate = Excel_data.get("Invoice_Status_Report_StartDate");
		String Invoice_Status_Report_EndDate = Excel_data.get("Invoice_Status_Report_EndDate");
		
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

		Extent_cal(test, test1, "Get All the Details from Invoice Module  - start");
		
		List<String> InvoiceSelectRow = splitAndExpand(Invoice_Validation_Row);
		Map<String, Map<String, String>> InvoiceTableValues = new HashMap<String, Map<String, String>>();

		waitForElement(driver, BL_Number_Input_All);
		String BL_Number_input = getAttribute(driver, BL_Number_Input_All, "value");
		List<String> ROE_Values = new ArrayList<String>();

		List<String> columnHeaders = splitAndExpand(Invoice_Headers_Validate);
		for (String rowCount : InvoiceSelectRow) {
			String SelectRowValidate = String.format(Invoice_Row_AllPage, rowCount);
			waitForElement(driver, Invoice_Table_Header_All);
			List<Map<String, String>> tabledata1 = getTableData(driver, Invoice_Table_Header_All, SelectRowValidate);
			Map<String, Map<String, String>> rowValues = getRowValuesByHeaders(tabledata1, columnHeaders, rowCount);

			if(BL_Number_input.equals("-")) {
				BL_Number_input="";
			}
			if (!Select_Invoice_Mode.equals("Manifest Corrector Invoice")) {
				rowValues.get(rowCount).put("BL Number", BL_Number_input);
			} else {
				rowValues.get(rowCount).put("MCN Number", BL_Number_input);
			}
			
			
			String ROE_Value = getFirstValueByHeader(tabledata1, "ROE Type");
			ROE_Values.add(ROE_Value);
			InvoiceTableValues.putAll(rowValues);
		}

		String StartDate = InvoiceTableValues.get(InvoiceSelectRow.get(0)).get("Inv Date");
		
	    String Inv_Sts_Rep_StartDate=beforeDaysToDate(StartDate, Invoice_Status_Report_StartDate);
	    String Inv_Sts_Rep_EndDate=addDaysToDate(StartDate, Invoice_Status_Report_EndDate);
		
		Extent_cal(test, test1, "Get All the Details from Invoice Module  - End");

		Step_Start(5, "Go to Invoice status Report", test, test1);
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

		Step_End(7, "click on show Button", test, test1);

		Step_Start(8, "Verify that below Invoice Number,\r\n" + "Invoice Date,\r\n" + "Invoice Status\r\n"
				+ "Customer Code,\r\n" + "Customer Name\r\n" + "Vessel,Voyage,Bound,\r\n" + "Invoice Due Date\r\n"
				+ "BL Number\r\n" + "ETD\r\n" + "ETA\r\n" + "Invoice Currency\r\n" + "Invoice Amount", test, test1);
		waitForElement(driver, TableGrid_ISR);
		
		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);

		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);
		
		waitForElement(driver, II_Status_Column);
		click(driver, II_Status_Column);
		waitForElement(driver, Column_Search_Input);
		click(driver, SelectAll_Column_CheckBox);
		
		List<String> columns = splitAndExpand(Invoice_Status_Table_Headers);
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

		for (Map.Entry<String, Map<String, String>> entry : InvoiceTableValues.entrySet()) {
			String key = entry.getKey();
			Map<String, String> expectedList = entry.getValue();

			List<String> filterdetailHeader = splitAndExpand(Invoice_Status_Table_Headers);
			for (String head : filterdetailHeader) {
				if (head.equals("Invoice Number")) {
					String InvoiceNumber = InvoiceTableValues.get(key).get("Inv Number");
					if(InvoiceNumber!=null&&!InvoiceNumber.equals("-")) {
						waitForElement(driver, InVoiceNumber_FilterInput);
						Newclear(driver, InVoiceNumber_FilterInput);
						sendKeys(driver, InVoiceNumber_FilterInput, InvoiceNumber);
					}
				} else if (head.equals("BL Number")) {
					if(BL_Number_input!=null&&!BL_Number_input.equals("-")) {
						waitForElement(driver, BL_Search_input);
						Newclear(driver, BL_Search_input);
						sendKeys(driver, BL_Search_input, BL_Number_input);
					}
				} else if (Select_Invoice_Mode.equals("Manifest Corrector Invoice")) {
					if(BL_Number_input!=null&&!BL_Number_input.equals("-")) {
						waitForElement(driver, MCN_NumberFilter_Input);
						Newclear(driver, MCN_NumberFilter_Input);
						sendKeys(driver, MCN_NumberFilter_Input, BL_Number_input);
					}
				}
			}
			waitForElement(driver, TableGrid_ISR);
			waitForElement(driver, statusReporttableRow);
			List<Map<String, String>> StatusReport_TableData = extractTableDataByColumn(driver, TableGrid_ISR);
			System.out.println("StatusReport_TableData : " + StatusReport_TableData);
			
			Map<String, String> headerMapping = new HashMap<>();
			headerMapping.put("Inv Number", "Invoice Number");
			headerMapping.put("Category", "Invoice Category");
			headerMapping.put("Inv Due Date", "Invoice Due Date");
			headerMapping.put("Inv Currency", "Invoice Currency");
			headerMapping.put("Inv Date", "Invoice Date");

			headerMapping.put("Amount", "Invoice Amount");
			headerMapping.put("Balance", "Balance Amount");
			headerMapping.put("Customer Name", "Customer Name");
			headerMapping.put("Customer Code", "Customer Code");
			headerMapping.put("Invoice Status", "Invoice Status");
			headerMapping.put("BL Number", "BL Number");
			headerMapping.put("MCN Number", "Invoiced MCN Reference");
			

			Map<String, String> Act = StatusReport_TableData.get(0);
			System.out.println("Exp Status rowValues  : " + expectedList);
			System.out.println("Act Status rowValues  : " + Act);

			String ExpectedTable=ReportTable(expectedList,"Invoice Table data");
			String ActualTable=ReportTable(Act,"Status Report Table");
			
			if (compareMapsNew(expectedList, Act, headerMapping)) {
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

		Step_End(8, "Verify that below Invoice Number,\r\n" + "Invoice Date,\r\n" + "Invoice Status\r\n"
				+ "Customer Code,\r\n" + "Customer Name\r\n" + "Vessel,Voyage,Bound,\r\n" + "Invoice Due Date\r\n"
				+ "BL Number\r\n" + "ETD\r\n" + "ETA\r\n" + "Invoice Currency\r\n" + "Invoice Amount", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}

}
