package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_DnS_Report_SC035 extends Keywords {

	public void DnS_Report_SC035(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_DnS_Report_SC035";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Search_Module_Name = Excel_data.get("Search_Module_Name");
		String Load_Module_Name = Excel_data.get("Load_Module_Name");
		String AgencyUser = Excel_data.get("AgencyUser");

		String Corporate_Code = Excel_data.get("Corporate_Code");
		String Agency_Code = Excel_data.get("Agency_Code");
		String Code_Filter_Condition = Excel_data.get("Code_Filter_Condition");

		String Select_Report_By = Excel_data.get("Select_Report_By");
		String VoyageOptionName = Excel_data.get("VoyageOptionName");
		String DateOptionName = Excel_data.get("DateOptionName");

		String Select_Shipment = Excel_data.get("Select_Shipment");
		String Select_Report_Type = Excel_data.get("Select_Report_Type");

		String Voyage_Filter_Condition = Excel_data.get("Voyage_Filter_Condition");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Voyage_Code = Excel_data.get("Voyage_Code");
		String POLCode = Excel_data.get("POLCode");

		String POD_Header = Excel_data.get("POD_Header");
		String PODCode = Excel_data.get("PODCode");

		
		String Corporate_Header = Excel_data.get("Corporate_Header");
		String Agency_Header = Excel_data.get("Agency_Header");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String Service_Header = Excel_data.get("Service_Header");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String POL_Header = Excel_data.get("POL_Header");

		String Date_Select_Type = Excel_data.get("Date_Select_Type");
		String From_Date_Value = Excel_data.get("From_Date_Value");
		String To_Date_Value = Excel_data.get("To_Date_Value");

		String Supress_Zero_Balance = Excel_data.get("Supress_Zero_Balance");
		String Use_Report_Date = Excel_data.get("Use_Report_Date");
		String Use_ETD_Date = Excel_data.get("Use_ETD_Date");

		String SelectVoyageOption = String.format(Select_ReportOption, VoyageOptionName);
		String SelectDateOption = String.format(Select_ReportOption, DateOptionName);

		String SelectShipmentOption = String.format(ShipmentType, Select_Shipment);
		String SelectReportOption = String.format(ReportInput, Select_Report_Type);

		String Grid_Download_Option = Excel_data.get("Grid_Download_Option");
		String Include_Import_Documentation = Excel_data.get("Include_Import_Documentation");
		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		if (Load_Module_Name.equalsIgnoreCase("Line Profile")) {
			Extent_cal(test, test1, "If Line Profile  - Start");

			Step_Start(1, " Open Detention Storage Report", test, test1);
			moduleNavigate(driver, Search_Module_Name);
			Step_End(1, " Open Detention Storage Report", test, test1);

			Step_Start(2, " Click on New Button", test, test1);
			newButton(driver);
			Step_End(2, " Click on New Button", test, test1);

			Step_Start(3, " Select the Corporate Code", test, test1);
			waitForElement(driver, CorporateAgency_SearchBtn);
			click(driver, CorporateAgency_SearchBtn);

			twoColumnSearchWindow(driver, Corporate_Header, Code_Filter_Condition, Corporate_Code);

			Step_End(3, " Select the Corporate Code", test, test1);

			Step_Start(4, " Select the agency Code", test, test1);
			waitForElement(driver, Agency_SearchBtn);
			click(driver, Agency_SearchBtn);

			twoColumnSearchWindow(driver, Agency_Header, Code_Filter_Condition, Agency_Code);

			Step_End(4, " Select the agency Code", test, test1);

			Extent_cal(test, test1, "If Line Profile  - End");

		} else {

			Extent_cal(test, test1, "If Agency Profile  - Start");
			SwitchProfile(driver, AgencyUser);
			Step_Start(1, " Open Detention Storage Report", test, test1);
			moduleNavigate(driver, Search_Module_Name);
			Step_End(1, " Open Detention Storage Report", test, test1);

			Step_Start(2, " Click on New Button", test, test1);
			newButton(driver);
			Step_End(2, " Click on New Button", test, test1);
			Extent_cal(test, test1, "If Agency Profile  - End");
		}

		Extent_cal(test, test1, "Select Shipment  Type  - Start");
		waitForElement(driver, ShipmentInput);
		click(driver, ShipmentInput);

		waitForElement(driver, SelectShipmentOption);
		click(driver, SelectShipmentOption);
		Extent_cal(test, test1, "Select Shipment Type  - End");

		Extent_cal(test, test1, "Select Report Type  - Start");
		waitForElement(driver, ReportTypeInput);
		click(driver, ReportTypeInput);

		waitForElement(driver, SelectReportOption);
		click(driver, SelectReportOption);

		waitForElement(driver, ReportTypeInput);
		if(isdisplayed(driver, Value_checkbox)) {
			checkBox(driver, Value_checkbox, Include_Import_Documentation);
		}
		Extent_cal(test, test1, "Select Report Type  - End");

		Step_Start(5,
				" Select report By Voyage/Date Option has to refer from Excel\r\n" + "If Date option follow below",
				test, test1);

		if (Select_Report_By.equalsIgnoreCase("By Voyage")) {

			waitForElement(driver, SelectVoyageOption);
			click(driver, SelectVoyageOption);

			Step_Start(6, " Select the Service,Vessel, Voyage, Bound,POL, POD, ", test, test1);

			waitForElement(driver, ServiceSearchButton_);
			click(driver, ServiceSearchButton_);
			twoColumnMultipleSearchWindow(driver, Service_Header, Voyage_Filter_Condition, Service_Code);

			waitForElement(driver, VesselSearchButton_);
			click(driver, VesselSearchButton_);
			twoColumnMultipleSearchWindow(driver, Vessel_Header, Voyage_Filter_Condition, Vessel_Code);

			waitForElement(driver, VoyageSearchButton_);
			click(driver, VoyageSearchButton_);

			twoColumnMultipleSearchWindow(driver, Voyage_Header, Voyage_Filter_Condition, Voyage_Code);

			if (SelectShipmentOption.equalsIgnoreCase("EXPORT")) {
				waitForElement(driver, POL_SearchButton_);
				click(driver, POL_SearchButton_);

				twoColumnMultipleSearchWindow(driver, POL_Header, Voyage_Filter_Condition, POLCode);
			} else {
				if(!PODCode.trim().equals("")) {
					waitForElement(driver, POD_searchbutton_);
					click(driver,POD_searchbutton_);
					twoColumnMultipleSearchWindow(driver, POD_Header, Voyage_Filter_Condition, PODCode);					
				}
				//
			}

			Step_End(6, " Select the Service,Vessel, Voyage, Bound,POL, POD, ", test, test1);
		
		}else {
			waitForElement(driver, SelectDateOption);
			click(driver, SelectDateOption);
			Step_Start(6,
					"Check SHipment Date as ETA/EMS start/EMS END option,\r\n" + "accouding to tht go and click it ",
					test, test1);
			if (Date_Select_Type.equalsIgnoreCase("Shipment Date")) {
				waitForElement(driver, ShipmentDateOption);
				click(driver, ShipmentDateOption);

				Step_Start(6, "  Pass From and TO Date, ", test, test1);
				selectDatePicker(driver, Shipment_FromDateInput, From_Date_Value);
				selectDatePicker(driver, Shipment_ToDateInput, To_Date_Value);
				Step_End(6, "  Pass From and TO Date,", test, test1);

			} else if (Date_Select_Type.equalsIgnoreCase("EMS Start activty")) {
				waitForElement(driver, EMS_StartActivityOption);
				click(driver, EMS_StartActivityOption);

				Step_Start(6, "  Pass From and TO Date, ", test, test1);
				selectDatePicker(driver, EMS_Start_FromDate, From_Date_Value);
				selectDatePicker(driver, EMS_Start_ToDate, To_Date_Value);
				Step_End(6, "  Pass From and TO Date,", test, test1);
			} else {
				waitForElement(driver, EMS_EndActivityOption);
				click(driver, EMS_EndActivityOption);

				Step_Start(6, "  Pass From and TO Date, ", test, test1);
				selectDatePicker(driver, EMS_End_FromDate, From_Date_Value);
				selectDatePicker(driver, EMS_End_ToDate, To_Date_Value);
				Step_End(6, " Pass From and TO Date, ", test, test1);

			}
			Step_End(6,
					"Check SHipment Date as ETA/EMS start/EMS END option,\r\n" + "accouding to tht go and click it ",
					test, test1);

		}

		Step_End(5, " Select report By Voyage/Date Option has to refer from Excel\r\n" + "If Date option follow below",
				test, test1);

		waitForElement(driver, SuperZeroInput);
		checkBox(driver, SuperZeroInput, Supress_Zero_Balance);
		checkBox(driver, UseReportDateCheckBox, Use_Report_Date);
		checkBox(driver, UseETD_DateCheckBox, Use_ETD_Date);
		

		Step_Start(7, " click on SHow button, ", test, test1);
		waitForElement(driver, ShowButton_);
		click(driver, ShowButton_);

		if (isdisplayed(driver, popup_Message)) {
			String popText = getText(driver, popup_Message);
			Extent_fail(driver,
					"Expected result is : No popup should be shown || Actual result is : Popup Displayed after select Show Button : "
							+ popText,
					test, test1);
		}
		Step_End(7, " click on SHow button, ", test, test1);

		Extent_call(test, test1, "Verify that Download file and available data count has to be matched. - Start");

		waitForElement(driver, Total_Record);
		String TotalRecordValue = getText(driver, Total_Record);
		int TotalRecords_Application = Integer.parseInt(TotalRecordValue);

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
						+ " ||  Records Count in CSV : " + TotalRecordsCount_Excel);
				Extent_pass_New(driver, "Matched || Records Count in Application : " + TotalRecords_Application
						+ " || Records Count in CSV : " + TotalRecordsCount_Excel, test, test1);
			} else {
				System.out.println("Not Matched || Records Count in Application : " + TotalRecords_Application
						+ " ||  Records Count in CSV : " + TotalRecordsCount_Excel);
				Extent_fail(driver, "Not Matched || Records Count in Application : " + TotalRecords_Application
						+ " || Records Count in CSV : " + TotalRecordsCount_Excel, test, test1);
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

		Extent_completed(testcase_Name, test, test1);
	}
}