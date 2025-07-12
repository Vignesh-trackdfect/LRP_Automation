package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD45 extends Keywords {
	public void Discharge_Reconciliation_MD45(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD45";
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
		String Container_No_Header_Grid = Excel_data.get("Container_No_Header_Grid");
//	
		String BL_No_Header_Grid = Excel_data.get("BL_No_Header_Grid");
		String BL_No_Header_Operation = Excel_data.get("BL_No_Header_Operation");
		String Operation_Details_Module = Excel_data.get("Operation_Details_Module");

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
			waitForElement(driver, grid_scroll);
			scrollUsingElement(driver, grid_scroll);
			horizontalscroll(driver, grid_scroll, 300);

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
		waitForElement(driver, Show_Summary_Btn);
		click(driver, Show_Summary_Btn);
		Step_End(7, "Click on Show Summary button", test, test1);

		Step_Start(8, "Click on Shot ship Contr List command Button,", test, test1);
		waitForElement(driver, Discharge_recon_Short_Shipment_Btn);
		click(driver, Discharge_recon_Short_Shipment_Btn);
		Step_End(8, "Click on Shot ship Contr List command Button,", test, test1);
		
Step_Start(9, "Capture the BL NO and Container Number", test, test1);
		
		String Record = getText(driver, Shipment_Grid_Row_Count);
//		
		int num = Integer.parseInt(Record);
		List<Map<String, String>> TableValue = extractTableDataByRowIndex(driver, shipment_Grid_select_Tble, num);
		String Container_number = getFirstValueByHeader(TableValue, Container_No_Header_Grid);
		System.out.println( "Container No captured in shipment column is " + Container_number);
		Extent_pass(driver, "Container No captured in shipment column is " + Container_number, test, test1);
		
		List<Map<String, String>> TableValue1 = extractTableDataByRowIndex(driver, shipment_Grid_select_Tble, num);
		String BL_number = getFirstValueByHeader(TableValue1, BL_No_Header_Grid);
		System.out.println( "BL No captured in shipment column is " + BL_number);
		Extent_pass(driver, "BL No captured in shipment column is " + BL_number, test, test1);
		

		waitForElement(driver, Dis_Shipment_Btn_Close);
		click(driver, Dis_Shipment_Btn_Close);
		
		waitForElement(driver, Show_Summary_Close_tab);
		click(driver, Show_Summary_Close_tab);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(9, "Capture the BL NO and Container Number", test, test1);
		
		Step_Start(10, "Open Operation details tracking module", test, test1);
		moduleNavigate(driver, Operation_Details_Module);
		// newButton(driver);
		Step_End(10, "Open Operation details tracking module", test, test1);

		Step_Start(11, "select Search By BL No option", test, test1);
		
		waitForElement(driver, Select_BL_Button_Operation);
		click(driver, Select_BL_Button_Operation);

		Step_End(11, "select Search By BL No option", test, test1);

		Step_Start(12, "enter the BL number which is captured from  Shot ship Contr List in discharge reconciliation module,", test, test1);

		globalValueSearchWindow(driver, Condition, BL_No_Header_Operation, BL_number, "", "", "", "");

		waitForElement(driver, Operation_Module_Show_Btn);
		click(driver, Operation_Module_Show_Btn);
		
		
		Step_End(12, "enter the BL number which is captured from  Shot ship Contr List in discharge reconciliation module,", test, test1);
		
		Step_Start(13, "Scrool Down, and check that particular container has which status in the operation status field", test, test1);

		scrollBottom(driver);
		mouseOverToElement(driver, Operation_Detail_tracking_Filter_Btn);
		
		waitForElement(driver, Operation_Detail_tracking_Filter_Btn);
		click(driver, Operation_Detail_tracking_Filter_Btn);
		
		
		String container_select = String.format(operations_Con_num_find, Container_number);
		String container_select_row = String.format(operations_Con_num_find_status, Container_number);
		
		waitForDisplay(driver, container_select);
		if(!isdisplayed(driver, container_select)) {
			System.out.println("Container number was  not shown in the gird");
			Extent_pass(driver,"Container number was not  shown in the gird"+ container_select, test, test1);
		}else {
			System.out.println("Container number was shown in the gird");
			Extent_pass(driver,"Container number was shown in the gird"+ container_select, test, test1);
			String operation_status;
			waitForDisplay(driver, container_select_row);
			if(isdisplayed(driver, container_select_row)) {
			 operation_status = getText(driver, container_select_row);
			System.out.println(operation_status);
			if (operation_status.contains("Local Discharge Planned") || operation_status.contains("Local Load Confirmed")) {
			    System.out.println("Both Local Discharge Planned and Local Load Confirmed was listed in the gird");
			    Extent_pass(driver, "Both Local Discharge Planned and Local Load Confirmed was listed in the gird"+operation_status, test, test1);
			    
			    
			    
			    
			}
			    
			
			    
			} else {
				   System.out.println("Both Local Discharge Planned and Local Load Confirmed was not listed in the gird");
				    Extent_pass(driver, "Both Local Discharge Planned and Local Load Confirmed was not listed in the gird", test, test1);
			}
			
			
		}
		
		
	Step_End(13, "Scrool Down, and check that particular container has which status in the operation status field", test, test1);
		
		
	 Extent_completed(testcase_Name, test, test1);
		
		
}
}
