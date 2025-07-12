package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD29 extends Keywords {

	public void Discharge_Reconciliation_MD29(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD29";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Plan_Type = Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Type);
		String Bl_Number = Excel_data.get("Bl_Number");
		String Bill_Of_Loading_Module = Excel_data.get("Bill_Of_Lading_Module");
		String Condition = Excel_data.get("Condition");
		String BL_No_Header_Lading = Excel_data.get("BL_No_Header_Lading");
		String Bill_Of_Lading_Header_List = Excel_data.get("Bill_Of_Lading_Header_List");

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

		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		Step_Start(5, "Select the Plan as ALL/Local/Transhipment.", test, test1);
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

		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(5, "Select the Plan as ALL/Local/Transhipment.", test, test1);

		Step_Start(6, " Click on Download BL Button", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, " Click on Download BL Button", test, test1);

		Step_Start(7, "CLICK ON SHOW SUMMARY BUTTOM.", test, test1);
		waitForElement(driver, Show_Summary_Btn);
		click(driver, Show_Summary_Btn);
		Step_End(7, "CLICK ON SHOW SUMMARY BUTTOM.", test, test1);
		Step_Start(8, "click Non-Containerized Shipment summary.", test, test1);
		waitForElement(driver, Non_Container_Shipment_Summary_Btn);
		click(driver, Non_Container_Shipment_Summary_Btn);
		Step_End(8, "click Non-Containerized Shipment summary.", test, test1);

		Step_Start(9, "Go to Cargo Section,", test, test1);
		Step_Start(10, "Capture the BLs List and store it -POL,", test, test1);
		waitForElement(driver, Cargo_Detials_Filter_Btn);
		click(driver, Cargo_Detials_Filter_Btn);

		// reArrangeAG_GridColumnsNew(driver, Cargo_Detials_Column_btn, Column_Header);
		sendKeys(driver, BL_Number_Filter_Input, Bl_Number);
		waitForElement(driver, Cargo_Pol_Detials);
		String Pol_Code = getText(driver, Cargo_Pol_Detials);
		System.out.println(Pol_Code);
		String WT_Code = getText(driver, Cargo_WT_Detials);
		double Dis_WT_Code = Double.parseDouble(WT_Code);
		System.out.println(Dis_WT_Code);
		String QT_Code = getText(driver, Cargo_QTY_Detials);
		double Dis_QT_Code = Double.parseDouble(QT_Code);
		System.out.println(Dis_QT_Code);
		waitForElement(driver, Cargo_Commodity_Detials);
		String COMMODITY_Code = getText(driver, Cargo_Commodity_Detials);
		System.out.println(COMMODITY_Code);

		horizontalscroll(driver, Non_Cargo_Scroll, 1000);
		String CBM_Code = getText(driver, Cargo_Cbm_Detials);
		double Dis_CBM_Code = Double.parseDouble(CBM_Code);
		System.out.println(Dis_CBM_Code);

		click(driver, Non_Container_Shipment_Summary_Close_Btn);
		waitForElement(driver, Show_Summary_Close_tab);
		click(driver, Show_Summary_Close_tab);

		moduleNavigate(driver, Bill_Of_Loading_Module);

		Step_End(9, " Go to Bill of lading module", test, test1);

		Step_Start(10, " load the same BL number", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Condition, BL_No_Header_Lading, Bl_Number, "", "", "", "");

		Step_End(10, " load the same BL number", test, test1);

		Step_Start(11, " If Bl has MCN Open the approved status MCN (else follow BL in BL.)", test, test1);
		waitForDisplay(driver, BOL_MCN_NO_Column);
		if (isdisplayed(driver, BOL_MCN_NO_Column)) {

			waitForElement(driver, BOL_MCN_NO_Column);
			doubleClick(driver, BOL_MCN_NO_Column);
			
			
			

		} else {

			waitForElement(driver, Pol_Value_Bill_of_Lading);
			String POL_Code = getText(driver, Pol_Value_Bill_of_Lading);
			System.out.println(POL_Code);

			waitForElement(driver, Un_Containerized_Tab);
			click(driver, Un_Containerized_Tab);
			List<String> Bill_Of_Lading_Header1 = splitAndExpand(Bill_Of_Lading_Header_List, ",");
			List<Map<String, String>> Billing_containerTable = getTableData(driver, Non_Conti_Tab_Header,
					Non_Conti_Tab_Row);
			List<List<String>> ActualValue = getValuesByHeaders(Billing_containerTable, Bill_Of_Lading_Header1);
			System.out.println(ActualValue);


			for (int i = 0; i < ActualValue.size(); i++) {
				List<String> row = ActualValue.get(i);
				System.out.println("---- Row " + (i + 1) + " ----");
				
				double totalWeight = 0;
				String totalWeightUnit = null;
				
				for (int j = 0; j < row.size(); j++) {
					String header = Bill_Of_Lading_Header1.get(j);
					String value = row.get(j);
					System.out.println(header + " = " + value);

					if (header.equalsIgnoreCase("Qty.")) {
						double actualValue = Double.parseDouble(value);
						if (actualValue == Dis_QT_Code) {
							System.out.println("Expected: Actual Value " + actualValue + " matches with Dis_QT_Code "
									+ Dis_QT_Code);
						} else {
							System.out.println("Expected: Actual Value " + actualValue + " matches with Dis_QT_Code "
									+ Dis_QT_Code);
						}
					} 
//						else if (header.equalsIgnoreCase("Total CBM")){
//						double actualValue = Double.parseDouble(value);
//						if (actualValue == Dis_QT_Code) {
//							System.out.println("Expected: Actual Value " + actualValue + " matches with Dis_QT_Code " + Dis_QT_Code);
//						} else {
//							System.out.println("Expected: Actual Value " + actualValue + " matches with Dis_QT_Code " + Dis_QT_Code);
//						}
//					}else if (header.equalsIgnoreCase("Total CBM")){
//						double actualValue = Double.parseDouble(value);
//						if (actualValue == Dis_QT_Code) {
//							System.out.println("Expected: Actual Value " + actualValue + " matches with Dis_QT_Code " + Dis_QT_Code);
//						} else {
//							System.out.println("Expected: Actual Value " + actualValue + " matches with Dis_QT_Code " + Dis_QT_Code);
//						}
//					}
					else if (header.equalsIgnoreCase("Total weight")) {
			            totalWeight = Double.parseDouble(value);
			        } else if (header.equalsIgnoreCase("Total weight Unit")) {
			            totalWeightUnit = value;
			        }
				}
				
				if (totalWeightUnit.equalsIgnoreCase("k")) {
			        try {
			            double finalamt = totalWeight / 1000;
			            System.out.println("Converted Total Weight in tons: " + finalamt);
			        } catch (NumberFormatException e) {
			            System.out.println("ERROR: Invalid number format in Total weight = " + totalWeight);
			        }
			    }
			}
			
		}
		
		
		

		Step_End(9, "Go to Cargo Section,.", test, test1);
		Step_End(10, "Capture the BLs List and store it -POL,", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
