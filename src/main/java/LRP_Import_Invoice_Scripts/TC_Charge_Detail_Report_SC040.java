package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Charge_Detail_Report_SC040 extends Keywords {

	public void Charge_Detail_Report_SC040(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Charge_Detail_Report_SC040";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser").trim();
		String chargeDetailReport_Module = Excel_data.get("ChargeDetailReport_Module");
		String Condition = Excel_data.get("Condition");
		String chargeType = Excel_data.get("ChargeType");
		String shipment = Excel_data.get("Shipment");
		String chargeCategory = Excel_data.get("ChargeCategory");
		String reportType = Excel_data.get("ReportType");
		String fromDate = Excel_data.get("FromDate");
		String scope = Excel_data.get("Scope");
		String toDate = Excel_data.get("ToDate");
		String service_input = Excel_data.get("service_input");
		String vessel_code_input = Excel_data.get("vessel_code_input");
		String voyage_code = Excel_data.get("voyage_code_input");
		String Port_Code = Excel_data.get("Port_Code");

		String Select_Radio_Button_Option = Excel_data.get("Select_Radio_Button_Option");
		
		String exclude_Checkbox = Excel_data.get("Exclude_Checkbox");
		String supressZeroAmount_Checkbox = Excel_data.get("SupressZeroAmount_Checkbox");
		String Verify_In = Excel_data.get("Verify_In");
		String datePicker = Excel_data.get("DatePicker");
		String AgencyCode_Header = Excel_data.get("AgencyCode_Header");
		String Region_Header = Excel_data.get("Region_Header");
		String CorporateAgencyCode_Header = Excel_data.get("CorporateAgencyCode_Header");
		String Select_Scope_Value = Excel_data.get("Select_Scope_Value");

		String ServiceHeader = Excel_data.get("ServiceHeader");
		String VesselHeader = Excel_data.get("VesselHeader");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String PortHeader = Excel_data.get("PortHeader");

		String Grid_Download_Option = Excel_data.get("Grid_Download_Option");

		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		Step_Start(1, "Switch to Agency/Line,", test, test1);

		if (Verify_In.equals("Agency")) {

			SwitchProfile(driver, AgencyUser);

		}

		Step_End(1, "Switch to Agency/Line,", test, test1);

		Step_Start(2, "Open charge Details report", test, test1);

		moduleNavigate(driver, chargeDetailReport_Module);

		Step_End(2, "Open charge Details report", test, test1);

		Step_Start(3, "Input All The Entry from Test Data", test, test1);

		newButton(driver);

		waitForElement(driver, In_reportType_Dropdown);
		click(driver, In_reportType_Dropdown);

		String select_ReportType = String.format(In_reportType_Dropdown_Options, reportType);
		waitForElement(driver, select_ReportType);
		click(driver, select_ReportType);

		waitForElement(driver, CDP_shipment_Dropdown);
		click(driver, CDP_shipment_Dropdown);

		String select_Shipment = String.format(shipment_Dropdown_Options, shipment);
		waitForElement(driver, select_Shipment);
		click(driver, select_Shipment);

		waitForElement(driver, chargeCategory_Dropdown);
		click(driver, chargeCategory_Dropdown);

		String select_ChargeCategory = String.format(chargeCategory_Dropdown_Options, chargeCategory);
		waitForElement(driver, select_ChargeCategory);
		click(driver, select_ChargeCategory);

		waitForElement(driver, chargeType_Dropdown);
		click(driver, chargeType_Dropdown);

		formatLocatorClick(driver, chargeType_Dropdown_Options, chargeType);

		if(!fromDate.trim().equals("")) {
			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, fromDate_CDR, fromDate);
			}else {
				click(driver, fromDate_CDR);
				Newclear(driver, fromDate_CDR);
				waitForElement(driver, fromDate_CDR);
				sendKeys(driver, fromDate_CDR, fromDate);
			}
		}
		
		if(!toDate.trim().equals("")) {
			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, toDate_CDR, toDate);
			}else {
				click(driver, toDate_CDR);
				Newclear(driver, toDate_CDR);
				waitForElement(driver, toDate_CDR);
				sendKeys(driver, toDate_CDR, toDate);
			}
		}
		
		waitForElement(driver, scope_Dropdown);
		click(driver, scope_Dropdown);

		String select_Scope = String.format(scope_Dropdown_Options, scope);
		waitForElement(driver, select_Scope);
		click(driver, select_Scope);

		if (Verify_In.equals("Line")) {
			if (scope.equalsIgnoreCase("Agency")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindowMultipleValue(driver, AgencyCode_Header, Condition, Select_Scope_Value);

			}

			if (scope.equalsIgnoreCase("Region")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindowMultipleValue(driver, Region_Header, Condition, Select_Scope_Value);
			}

			if (scope.equalsIgnoreCase("Corporate Agency")) {
				waitForElement(driver, scope_Add_Button);
				click(driver, scope_Add_Button);
				twoColumnSearchWindowMultipleValue(driver, CorporateAgencyCode_Header, Condition, Select_Scope_Value);
			}
		}

		if (reportType.equalsIgnoreCase("BY VESSEL")) {

			if(!service_input.trim().equals("")) {
				waitForElement(driver, service_Search_CDR);
				click(driver, service_Search_CDR);
				twoColumnSearchWindow(driver, ServiceHeader, Condition, service_input);
			}
			
			if(!vessel_code_input.trim().equals("")) {
				waitForElement(driver, vessel_Search_CDR);
				click(driver, vessel_Search_CDR);
				twoColumnSearchWindow(driver, VesselHeader, Condition, vessel_code_input);
			}
			
			if(!voyage_code.trim().equals("")) {
				waitForElement(driver, voyage_Search_CDR);
				click(driver, voyage_Search_CDR);
				twoColumnSearchWindow(driver, Voyage_Header, Condition, voyage_code);
			}
			
			if (!Port_Code.trim().equals("")) {
				waitForElement(driver, port_Search_CDR);
				click(driver, port_Search_CDR);
				twoColumnSearchWindow(driver, PortHeader, Condition, Port_Code);
			}

		}

		String RadioBtnOption= String.format(Radio_Buttons_CDR, Select_Radio_Button_Option);
		waitForElement(driver, RadioBtnOption);
		click(driver,RadioBtnOption);
		
		if (exclude_Checkbox.equalsIgnoreCase("Yes")) {
			waitForElement(driver, exclude_Reversal_Checkbox);
			click(driver, exclude_Reversal_Checkbox);
		}
		if (supressZeroAmount_Checkbox.equalsIgnoreCase("Yes")) {
			waitForElement(driver, supress_ZeroAmount);
			click(driver, supress_ZeroAmount);
		}
		Step_End(3, "Input All The Entry from Test Data", test, test1);
		Step_Start(4, "Click on Show Button", test, test1);

		waitForElement(driver, show_Button_CDR);
		click(driver, show_Button_CDR);

		Step_End(4, "Click on Show Button", test, test1);
		Step_Start(5, "Get the Rows Count", test, test1);

		Extent_call(test, test1, "Verify that Download file and available data count has to be matched. - Start");
		waitForElement(driver, totalRecords_CDR);
		String TotalRecordValue = getText(driver, totalRecords_CDR);
		int TotalRecords_Application = Integer.parseInt(TotalRecordValue);

		Step_End(5, "Get the Rows Count", test, test1);
		Step_Start(6, "Download the Excel and Verify the same Count", test, test1);

		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);
		String downlaoad_Path="";
		
		if(Grid_Download_Option.equalsIgnoreCase("CSV")) {
			
			waitForElement(driver, Download_CSV_Option);
		    downlaoad_Path = downloadFile(driver, Download_CSV_Option);
		    
		    int row_Count = countNonEmptyCsvRows(downlaoad_Path);
			int TotalRecordsCount_Excel = row_Count - 1;

			if (TotalRecords_Application == TotalRecordsCount_Excel) {
				System.out.println("Matched || Records Count in Application : " + TotalRecords_Application
						+ " ||  Records Count in CSV file : " + TotalRecordsCount_Excel);
				Extent_pass_New(driver, "Matched || Records Count in Application : " + TotalRecords_Application
						+ " || Records Count in CSV file : " + TotalRecordsCount_Excel, test, test1);
			} else {
				System.out.println("Not Matched || Records Count in Application : " + TotalRecords_Application
						+ " ||  Records Count in CSV file : " + TotalRecordsCount_Excel);
				Extent_fail(driver, "Not Matched || Records Count in Application : " + TotalRecords_Application
						+ " || Records Count in CSV file : " + TotalRecordsCount_Excel, test, test1);
			}
			
		}else {
			waitForElement(driver, II_Download_Excel_Xlsx);
		    downlaoad_Path = downloadFile(driver, II_Download_Excel_Xlsx);
		    
		    int row_Count = countNonEmptyRows(downlaoad_Path);
			int TotalRecordsCount_Excel = row_Count - 1;

			if (TotalRecords_Application == TotalRecordsCount_Excel) {
				System.out.println("Matched || Records Count in Application : " + TotalRecords_Application
						+ " ||  Records Count in Excel : " + TotalRecordsCount_Excel);
				Extent_pass_New(driver, "Matched || Records Count in Application : " + TotalRecords_Application
						+ " || Records Count in Excel : " + TotalRecordsCount_Excel, test, test1);
			} else {
				System.out.println("Not Matched || Records Count in Application : " + TotalRecords_Application
						+ " ||  Records Count in Excel : " + TotalRecordsCount_Excel);
				Extent_fail(driver, "Not Matched || Records Count in Application : " + TotalRecords_Application
						+ " || Records Count in Excel : " + TotalRecordsCount_Excel, test, test1);
			}
					
		}
		
		Extent_call(test, test1, "Verify that Download file and available data count has to be matched. - End");

		Step_End(6, "Download the Excel and Verify the same Count", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
