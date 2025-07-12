package LRP_Import_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Invoice_Status_Report_SC037 extends Keywords {

	public void Invoice_Status_Report_SC037(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Invoice_Status_Report_SC037";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");

		String Invoice_Status_Module = Excel_data.get("Invoice_Status_Module");
		String From_Date = Excel_data.get("From_Date");
		String To_Date = Excel_data.get("To_Date");
	
		String Grid_Download_Option = Excel_data.get("Grid_Download_Option");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);


		Step_Start(2, "Go to Invoice status Report", test, test1);
		moduleNavigate(driver, Invoice_Status_Module);
		waitForElement(driver, NewButton_ToolBar);
		Step_End(2, "Go to Invoice status Report", test, test1);

		Step_Start(3, "select from and To date as per Invoice Date", test, test1);
		waitForElement(driver, FromDate_ISR);
		selectDatePicker(driver, FromDate_ISR, From_Date);
		waitForElement(driver, ToDate_ISR);
		selectDatePicker(driver, ToDate_ISR, To_Date);
		Step_End(3, "select from and To date as per Invoice Date", test, test1);

		Step_Start(4, "click on show Button", test, test1);
		waitForElement(driver, ShowButton_ISR);
		click(driver, ShowButton_ISR);
		Step_End(4, "click on show Button", test, test1);

		Step_Start(5,
				"Capture the Count and Download as Excel-Open the Excel Match the Count if not matched then it is failed",
				test, test1);

		waitForElement(driver, TableGrid_ISR);
		waitForElement(driver, II_Total_RecordInput);
		String TotalRecordValue = getText(driver, II_Total_RecordInput);
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
		
		Step_End(5,
				"Capture the Count and Download as Excel-Open the Excel Match the Count if not matched then it is failed",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
