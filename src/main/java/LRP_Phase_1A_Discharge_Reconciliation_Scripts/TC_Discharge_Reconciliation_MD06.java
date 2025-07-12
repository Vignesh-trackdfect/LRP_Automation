package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD06 extends Keywords {
	public void Discharge_Reconciliation_MD06(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException {

		String test_Case_Name = "TC_Discharge_Reconciliation_MD06";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Plan_Options = Excel_data.get("Plan_Type");

		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Step_Start(1, " Switch to Agency,", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, " Switch to Agency,", test, test1);

		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);
		moduleNavigate(driver, Dis_Recon_Module);
		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on new button if new button not available go below,", test, test1);
		newButton(driver);
		Step_End(3, "Click on new button if new button not available go below,", test, test1);

		Step_Start(4, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
		if (!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		Step_End(4, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);

		Step_Start(5, "Select the Plan as ALL/Local/Transhipment.,", test, test1);
		waitForElement(driver, Plan_Option);
		click(driver, Plan_Option);

		formatLocatorClick(driver, Plan_Option_Select, Plan_Options);
		Step_End(5, " Select the Plan as ALL/Local/Transhipment.,", test, test1);
		Step_Start(6, " Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, " Click on Download BL Button.", test, test1);

		Step_Start(7, "Click for More option Button that 9 dots at right side corner,", test, test1);
		waitForElement(driver, MoreOption_Button_DR);
		click(driver, MoreOption_Button_DR);
		Step_End(7, "Click for More option Button that 9 dots at right side corner,", test, test1);

		Step_Start(8, "Click on excel Button and download it.", test, test1);
		waitForElement(driver, ExcelButton_DR);
		
		Step_End(8, "Click on excel Button and download it.", test, test1);

		Step_Start(9, "Open the Excel sheet ", test, test1);
		String downloadfile_path1 = downloadFile(driver, ExcelButton_DR);
		Step_End(9, "Open the Excel sheet ", test, test1);

		Step_Start(10, "Capture the total records count in Excel", test, test1);
		
		
		int row_Count = countNonEmptyRows(downloadfile_path1);
		int TotalRecordsCount_Excel = row_Count - 1;
		System.out.println("TotalExcelRecords =  " + TotalRecordsCount_Excel);
		
		Step_End(10, "Capture the total records count in Excel", test, test1);
		
		
		Step_Start(11, "Verify that All Column header should be matched and it has to compare one by one. if all fine make it Pass.", test, test1);
		  

		waitForElement(driver, GridColumnCount_DR);

		
		String columncounts = getAttribute(driver, GridColumnCount_DR, "aria-colcount");
		int HeaderCount = Integer.parseInt(columncounts);

		
		List<String> ExpectedHeaders = new ArrayList<>();

		for (int i = 1; i <= HeaderCount; i++) {

		    String columnheaders = String.format(GridHeaders_DR, i);

		    if (!isDisplayed(driver, columnheaders)) {
		        horizontalscroll(driver, GridScroll_DR, 1500); // Scroll to try to reveal the header
		    }

		    if (isDisplayed(driver, columnheaders)) {
		        String headername = getText(driver, columnheaders).trim();
		        System.out.println("Header " + i + ": " + headername);
		        ExpectedHeaders.add(headername); // Add to expected headers list
		    } else {
		        System.out.println("Header " + i + " is still not visible after scroll.");
		    }
		}

		System.out.println("ExpectedHeaders: " + ExpectedHeaders);

		List<String> ActualHeaders = getExcelHeaders(downloadfile_path1, "Discharge Reconciliation");
		System.out.println("ActualHeaders: " + ActualHeaders);
		
		if (ActualHeaders.equals(ExpectedHeaders)) {
		    System.out.println("Pass || Expected result:  coloumn headers should be matched" + ExpectedHeaders + " records || Actual: coloumn headers should be matched" + ExpectedHeaders + " records ");
		    Extent_pass(driver, "Pass || Expected result: coloumn headers should be matched"  + ExpectedHeaders + " records || Actual:coloumn headers should be matched" + ExpectedHeaders + "records", test, test1);
		} else {
		    System.out.println("Fail || Expected: coloumn headers should be matched " + ExpectedHeaders + " records || Actual: " + TotalRecordsCount_Excel + " records");
		    Extent_fail(driver, "fail || Expected: coloumn headers should be matched" + ExpectedHeaders + " records || Actual: " + TotalRecordsCount_Excel + " records ", test, test1);

	
	}
		Step_End(11, "Verify that All Column header should be matched and it has to compare one by one. if all fine make it Pass.", test, test1);
		
		Extent_completed(test_Case_Name, test, test1);

	}
}
