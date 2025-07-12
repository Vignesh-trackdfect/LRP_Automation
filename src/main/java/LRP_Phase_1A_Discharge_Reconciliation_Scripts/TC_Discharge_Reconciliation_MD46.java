package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD46 extends Keywords {
	public void Discharge_Reconciliation_MD46(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD46";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Discharge_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Bl_Number = Excel_data.get("Bl_Number");
		String Plan_Type = Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Type);
		String Bill_lading_module = Excel_data.get("Bill_Of_Lading_Module");
		String GlobalSearch_DropDown_condition = Excel_data.get("Global_Search_Condition");
		String GlobalSearch_type = Excel_data.get("Select_Search_Type_Bill_Of_Lading");
		String DR_Cntr_No_Header = Excel_data.get("DR_Cntr_No_Header");
		String DR_Container_type_2 = Excel_data.get("DR_Equp_type_Header");
		String Billoflading_Container_Header1 = Excel_data.get("Billoflading_Eqip_Id_Header");
		String Billoflading_Container_Header2 = Excel_data.get("Billoflading_Eqip_Type_Header");
		String MCN_Container_Header1 = Excel_data.get("MCN_Eqip_Type_Header");
		String MCN_Container_Header2 = Excel_data.get("MCN_Eqip_Id_Header");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency,", test, test1);

		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);

		moduleNavigate(driver, Discharge_Recon_Module);

		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		newButton(driver);

		Step_End(3, "Click on New button if New Button is not Available Go to Next Step", test, test1);

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
		waitForElement(driver, grid_terminal_IMP_DOC);
		sendKeys(driver, grid_terminal_IMP_DOC, Terminal_Input);

		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		Step_Start(5, " Select the Plan as ALL/Local/Transhipment", test, test1);

		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(5, " Select the Plan as ALL/Local/Transhipment", test, test1);
		Step_Start(6, "Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, "Click on Download BL Button.", test, test1);
		Step_Start(7, "Click on show Summary Button", test, test1);
		waitForElement(driver, Show_Summary_Btn);
		click(driver, Show_Summary_Btn);
		Step_End(7, "Click on show Summary Button", test, test1);
		Step_Start(8, ".Click on show Container command Button", test, test1);
		waitForElement(driver, Show_Containers_Btn);
		click(driver, Show_Containers_Btn);
		Step_End(8, ".Click on show Container command Button", test, test1);
		Step_Start(9,
				"Match the BL NO from excel sheet and verify it it is available other wise mark Test data is not right",
				test, test1);
		waitForElement(driver, Toll_Panel);
		click(driver, Toll_Panel);
		waitForElement(driver, Filter_Bttn);
		click(driver, Filter_Bttn);
		waitForElement(driver, BL_Number_Filter_Input);
		sendKeys(driver, BL_Number_Filter_Input, Bl_Number);

		List<Map<String, String>> Discharge_containertable = extractTableDataByColumnWithoutScroll(driver, Table_Name);
		List<String> DR_containerNumber = getValuesByHeader(Discharge_containertable, DR_Cntr_No_Header);
		List<String> DR_EquipType = getValuesByHeader(Discharge_containertable, DR_Container_type_2);
		if (!DR_containerNumber.isEmpty()) {
			
		
		waitForElement(driver, Discharge_Container_Close_Tab);
		click(driver, Discharge_Container_Close_Tab);
		waitForElement(driver, Show_Summary_Close_tab);
		click(driver, Show_Summary_Close_tab);
		} else {
			
System.out.println("The test data is not right");
extent_fail(driver, "The test data is not right", test, test1);
		}
		Step_End(9,
				"Match the BL NO from excel sheet and verify it it is available other wise mark Test data is not right",
				test, test1);
		Step_Start(10,
				" Open Bill of Lading and load the same BL",
				test, test1);
		
		moduleNavigate(driver, Bill_lading_module);
		

		waitForDisplay(driver, billOfLading_Tab);
		if (isdisplayed(driver, billOfLading_Tab)) {
			System.out.println("Expected Result : Bill of lading  module should be Open || Actual result : Bill_lading_module module is opened");
			Extent_pass(driver, "Expected Result :Bill of lading  module should be Open || Actual result :Bill_lading_module module is opened", test, test1);
		} else {
			System.out.println("Expected Result : Bill of lading  module should be Open || Actual result :Bill_lading_module module is not  opened");
			Extent_fail(driver, "Expected Result : Bill of lading  module should be Open || Actual result : Bill_lading_module module is  not opened", test, test1);
		}
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, GlobalSearch_DropDown_condition, GlobalSearch_type, Bl_Number, "", "", "", "");

		Step_End(10,
				" Open Bill of Lading and load the same BL",
				test, test1);
		Step_Start(11," If the BL has MCN Number Open MCN module For BL and MCN has same Flow",test, test1);
		waitForDisplay(driver, Mcn_Container_BillofLading);
		if (isdisplayed(driver, Mcn_Container_BillofLading)) {
			doubleClick(driver, Mcn_Container_BillofLading);
			Step_Start(12,"Go to Container tab Capture all the containers Available in BL/MCN",test, test1);
			waitForElement(driver, Manifest_Container_Tab);
			click(driver, Manifest_Container_Tab);
			Step_End(12,"Go to Container tab Capture all the containers Available in BL/MCN",test, test1);
			Step_Start(13," Verify that BL/MCN container && Container Type are matched with Discharge reconciliation module.",test, test1);
			waitForElement(driver, MCN_Commodity_Table_Headers);
			List<Map<String, String>> container_data_MCN = getTableData(driver, MCN_Commodity_Table_Headers,MCN_Commodity_Table_Rows);
			List<String> MCN_containerNumber = getValuesByHeader(container_data_MCN, MCN_Container_Header1);
			List<String> MCN_EquipType = getValuesByHeader(container_data_MCN, MCN_Container_Header2);
			int containerSize = DR_containerNumber.size();
			for (int i = 0; i < containerSize; i++) {
				if (DR_containerNumber.get(i).equals(MCN_containerNumber.get(i))&& DR_EquipType.get(i).equals(MCN_EquipType.get(i))) {
					System.out.println("Pass: The Container number from discharge reconcilation : "+DR_containerNumber.get(i)+"The Equipment Type from discharge reconciliation is:"+DR_EquipType.get(i)
					+"|| The container number from Bill of Lading is :"+MCN_containerNumber.get(i)+"The Equipment type from  bill of lading is:"+MCN_EquipType.get(i));
					Extent_pass(driver, "Pass: The Container number from discharge reconcilation : "+DR_containerNumber.get(i)+"The Equipment Type from discharge reconciliation is:"+DR_EquipType.get(i)
					+"|| The container number from Bill of Lading is :"+MCN_containerNumber.get(i)+"The Equipment type from  bill of lading is:"+MCN_EquipType.get(i), test, test1);
				
				} else {
					System.out.println("fail: The Container number from discharge reconcilation : "+DR_containerNumber.get(i)+"The Equipment Type from discharge reconciliation is:"+DR_EquipType.get(i)
					+"|| The container number from Bill of Lading is :"+MCN_containerNumber.get(i)+"The Equipment type from  bill of lading is:"+MCN_EquipType.get(i));
					Extent_fail(driver, "fail: The Container number from discharge reconcilation : "+DR_containerNumber.get(i)+"The Equipment Type from discharge reconciliation is:"+DR_EquipType.get(i)
					+"|| The container number from Bill of Lading is :"+MCN_containerNumber.get(i)+"The Equipment type from  bill of lading is:"+MCN_EquipType.get(i), test, test1);
		
			
				}
			
		}
			Step_End(13," Verify that BL/MCN container && Container Type are matched with Discharge reconciliation module.",test, test1);
			
		}else {
			Step_Start(12,"Go to Container tab Capture all the containers Available in BL/MCN",test, test1);
		waitForElement(driver, billOfLading_containerTab);
		click(driver, billOfLading_containerTab);
		Step_End(12,"Go to Container tab Capture all the containers Available in BL/MCN",test, test1);
		Step_Start(13," Verify that BL/MCN container && Container Type are matched with Discharge reconciliation module.",test, test1);
		waitForElement(driver, containerTab_Rows_BOL);
		List<Map<String, String>> Billing_containerTable = getTableDatawithscroll(driver, containerTab_Coloumns_BOL, containerTab_Rows_BOL,billOfLading_containerTab_Scroll, 80, -4500);
		
		List<String> Bill_containerNumber = getValuesByHeader(Billing_containerTable, Billoflading_Container_Header1);
		List<String> Bill_EquipType = getValuesByHeader(Billing_containerTable, Billoflading_Container_Header2);
		
				
		int containerSize = DR_containerNumber.size();
		for (int i = 0; i < containerSize; i++) {
			if (DR_containerNumber.get(i).equals(Bill_containerNumber.get(i))&& DR_EquipType.get(i).equals(Bill_EquipType.get(i))) {
				System.out.println("Pass: The Container number from discharge reconcilation : "+DR_containerNumber.get(i)+"The Equipment Type from discharge reconciliation is:"+DR_EquipType.get(i)
				+"|| The container number from Bill of Lading is :"+Bill_containerNumber.get(i)+"The Equipment type from  bill of lading is:"+Bill_EquipType.get(i));
				Extent_pass(driver, "Pass: The Container number from discharge reconcilation : "+DR_containerNumber.get(i)+"The Equipment Type from discharge reconciliation is:"+DR_EquipType.get(i)
				+"|| The container number from Bill of Lading is :"+Bill_containerNumber.get(i)+"The Equipment type from  bill of lading is:"+Bill_EquipType.get(i), test, test1);
			} else {
				System.out.println("fail: The Container number from discharge reconcilation : "+DR_containerNumber.get(i)+"The Equipment Type from discharge reconciliation is:"+DR_EquipType.get(i)
				+"|| The container number from Bill of Lading is :"+Bill_containerNumber.get(i)+"The Equipment type from  bill of lading is:"+Bill_EquipType.get(i));
				Extent_fail(driver, "fail: The Container number from discharge reconcilation : "+DR_containerNumber.get(i)+"The Equipment Type from discharge reconciliation is:"+DR_EquipType.get(i)
				+"|| The container number from Bill of Lading is :"+Bill_containerNumber.get(i)+"The Equipment type from  bill of lading is:"+Bill_EquipType.get(i), test, test1);
			
				
				
				
		
			}
			

		}
		Step_End(11," If the BL has MCN Number Open MCN module For BL and MCN has same Flow",test, test1);

		Step_End(13," Verify that BL/MCN container && Container Type are matched with Discharge reconciliation module.",test, test1);
		
		} 
		Extent_completed(testcase_Name, test, test1);
	}
}
