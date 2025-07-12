package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD44 extends Keywords {

	public void Discharge_Reconciliation_MD44(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD44";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Condition = Excel_data.get("Condition");
		String Plan_Input = Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);
		String Container_No_Header_Grid = Excel_data.get("Dis_Container_No_Header_Grid");
//	
		String Book_No_Input = Excel_data.get("Book_No_Input");
//		
		String Book_No_Header_Booking = Excel_data.get("Book_No_Header_Booking");
		String Booking_Module = Excel_data.get("Booking_Module");
		
		String Commodity_Id_Header_Grid = Excel_data.get("Booking_Header_Grid");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);
		Step_Start(1, "Switch to agency,", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency,", test, test1);
		
		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);

		moduleNavigate(driver, Dis_Recon_Module);

		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on New Button", test, test1);
		newButton(driver);

		Step_End(3, "Click on New Button", test, test1);

		Step_Start(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);

		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);

		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);

		waitForElement(driver, grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);

		waitForElement(driver, grid_bound_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);

		if (!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);

			click1(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		click1(driver, grid_terminal_IMP_DOC);
		sendKeys(driver, grid_terminal_IMP_DOC, Terminal_Input);

		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);

		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);

		Step_Start(5, "Select the Plan as ALL/Local/Transhipment", test, test1);

		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(5, "Select the Plan as ALL/Local/Transhipment", test, test1);

		Step_Start(6, "Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, "Click on Download BL Button.", test, test1);

		Step_Start(7, "Click on Show Summary button", test, test1);
		waitForElement(driver, Show_Summary_Btn_DR);
		click(driver, Show_Summary_Btn_DR);
		Step_End(7, "Click on Show Summary button", test, test1);

		Step_Start(8, " Click on Cntrs.Without BL(s) Button", test, test1);
		waitForElement(driver, Con_Summary_WithoutBL_Button);
		click(driver, Con_Summary_WithoutBL_Button);
		Step_End(8, " Click on Cntrs.Without BL(s) Button", test, test1);

		Step_Start(9, "Verify that Book No is available in grid which is passed from Test Data", test, test1);

		
		
		waitForElement(driver, Grid_Discharge_W_O_Container_Field);
		click(driver, Grid_Discharge_W_O_Container_Field);
		waitForElement(driver, Book_Number_input_re_con);
		sendKeys(driver, Book_Number_input_re_con, Book_No_Input);

		if (!isdisplayed(driver, Book_Number_input_re_con_row_click)) {
			System.out.println("Book NO is Not available in the application");
			Extent_fail(driver, "Book NO is Not available in the application " + Book_No_Input, test, test1);
		} else {
			System.out.println("Continue the remaining steps given in testcases");
		}
		Step_End(9, "Verify that Book No is available in grid which is passed from Test Data", test, test1);
		
		Step_Start(9.1, "Capture the Container Number in Cntrs.Without BL(s) and store it", test, test1);
		
		reArrangeAG_GridColumnsNewfeeder(driver, Discharge_recon_IGMcocloum_click, Container_No_Header_Grid);
		
		
		String Record = getText(driver, IGMGrid_records_Count);
		String[] split_Value = Record.split("of");
		String ExtractValue = split_Value[0].trim();
		int num = Integer.parseInt(ExtractValue);
		List<String> DischargeHeaders = splitAndExpand(Container_No_Header_Grid, ",");
		List<Map<String, String>> TableValue = extractTableDataByRowIndex(driver, Book_Number_W_O_row_click, num);
		List<List<String>> ExpectedValue = getValuesByHeaders(TableValue, DischargeHeaders);
		String DischargeTable = TableDataForReport(driver, TableValue, "Discharge Reconciliation Commodity Tab Table",
				DischargeHeaders);
 

		waitForElement(driver, Discharge_Recon_Close_Button);
		click(driver, Discharge_Recon_Close_Button);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(9.1, "Capture the Container Number in Cntrs.Without BL(s) and store it", test, test1);

		Step_Start(9.2, "Open Booking module", test, test1);
		moduleNavigate(driver, Booking_Module);
		// newButton(driver);
		Step_End(9.2, "Open Booking module", test, test1);

		Step_Start(10, "Click on Booking search Select the Book NO option and enter the same Book NO", test, test1);
		Step_Start(11, "Load the data in Booking Module", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Condition, Book_No_Header_Booking, Book_No_Input, "", "", "", "");

		Step_End(10, "Click on Booking search Select the Book NO option and enter the same Book NO", test, test1);
		Step_End(11, "Load the data in Booking Module", test, test1);

		Step_Start(12, " Go to Commodity tab", test, test1);

		waitForElement(driver, Booking_Commodity_tab);
		click(driver, Booking_Commodity_tab);

		waitForElement(driver, Commodity_Tab_Grid_Row);
		List<Map<String, String>> Billing_containerTable = getTableData(driver, Booking_Grid_Commodity_Header,
				Booking_Grid_Commodity_Row);
		List<String> bookingHeaders = splitAndExpand(Commodity_Id_Header_Grid, ",");
		List<List<String>> ActualValue = getValuesByHeaders(Billing_containerTable, bookingHeaders);
		String bookingTable = TableDataForReport(driver, Billing_containerTable, "Booking Commodity Tab Table",
				bookingHeaders);
		
		Step_End(12, " Go to Commodity tab", test, test1);

		Step_Start(13,
				"Pass COntainer NO1 And Verify weight( in Weight column) and Commodity( in commodity Code)fields", test,
				test1);
		
		
		if (compareTableData(ExpectedValue, ActualValue)) {
			Extent_pass(driver,
					"Matched || Expected Table Value is : /n <pre> " + DischargeTable
							+ "</pre> /n || The Actual Table Value is /n <pre> " + bookingTable + "</pre>",
					test, test1);
		}else {
			Extent_fail(driver,
					"Not Matched || Expected Table Value is : /n <pre> " + DischargeTable
							+ "</pre> /n || The Actual Table Value is /n <pre> " + bookingTable + "</pre>",
					test, test1);
		}
		

		Step_End(13, " Pass COntainer NO1 And Verify weight( in Weight column) and Commodity( in commodity Code)fields",
				test, test1);
		 
	       Extent_completed(testcase_Name, test, test1);
		
	}
}
