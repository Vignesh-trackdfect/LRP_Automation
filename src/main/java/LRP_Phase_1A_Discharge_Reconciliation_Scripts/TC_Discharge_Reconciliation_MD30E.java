package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD30E extends Keywords {
	public void Discharge_Reconciliation_MD30E(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD30E";

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
	

		String Operation_List_view_module = Excel_data.get("Operation_List_view_module");
		
		String Service_Header = Excel_data.get("Service_Header");
		String Plan_Input = Excel_data.get("Plan_Type");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String Port_Header = Excel_data.get("Port_Header");
		String Terminal_Header = Excel_data.get("Terminal_Header");
		String Column_Header = Excel_data.get("Column_Header");
		

		// String select_Option_3 = String.format(DropDown_Select, Plan_Input);
		String OLV_select_Option = String.format(DropDown_Select, Plan_Input);

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
		Step_Start(10, "Capture the BLs List and store it  COMMODITY", test, test1);
		waitForElement(driver, Cargo_Detials_Filter_Btn);
		click(driver, Cargo_Detials_Filter_Btn);

		// reArrangeAG_GridColumnsNew(driver, Cargo_Detials_Column_btn, Column_Header);
		sendKeys(driver, BL_Number_Filter_Input, Bl_Number);
		waitForElement(driver, Cargo_Commodity_Detials);
		String COMMODITY_Code = getText(driver, Cargo_Commodity_Detials);
		// double Dis_COMMODITY_Code=Double.parseDouble(COMMODITY_Code);

		click(driver, Non_Container_Shipment_Summary_Close_Btn);
		waitForElement(driver, Show_Summary_Close_tab);
		click(driver, Show_Summary_Close_tab);

		Step_End(9, "Go to Cargo Section,.", test, test1);
		Step_End(10, "Capture the BLs List and store it  COMMODITY", test, test1);

		// OlV

		Step_Start(10.1, "Open Operation List view Module", test, test1);
		moduleNavigate(driver, Operation_List_view_module);
		Step_End(10.1, "Open Operation List view Module", test, test1);

		Step_Start(11, " Click on Non-Conainerized Button", test, test1);

		waitForElement(driver, Olv_Non_Containerized_btn);
		click(driver, Olv_Non_Containerized_btn);

		Step_End(11, " Click on Non-Conainerized Button", test, test1);

		Step_Start(12, "Click Discharge List Button", test, test1);

		waitForElement(driver, Olv_Discharge_List_btn);
		click(driver, Olv_Discharge_List_btn);

		Step_End(12, "Click Discharge List Button", test, test1);

		Step_Start(13, "Enter the Service, Vessel, Voyage , Port, and Terminal", test, test1);

		waitForElement(driver, OLV_Service_Option);
		click(driver, OLV_Service_Option);
		twoColumnSearchWindow(driver, Service_Header, Filter_Condition, Service_Input);

		waitForElement(driver, OLV_Vessele_Option);
		click(driver, OLV_Vessele_Option);
		twoColumnSearchWindow(driver, Vessel_Header, Filter_Condition, Vessel_Input);

		waitForElement(driver, OLV_Voyage_Option);
		click(driver, OLV_Voyage_Option);
		twoColumnSearchWindow(driver, Voyage_Header, Filter_Condition, Voyage_Input);

		// Plan as ALL/Local/Transhipment
		waitForElement(driver, OLV_grid_selectbtn);
		click(driver, OLV_grid_selectbtn);

		waitForElement(driver, OLV_select_Option);
		click(driver, OLV_select_Option);

		waitForElement(driver, OLV_Port_Option);
		click(driver, OLV_Port_Option);
		twoColumnSearchWindow(driver, Port_Header, Filter_Condition, Port_Input);

		waitForElement(driver, OLV_Terminal_Option);
		click(driver, OLV_Terminal_Option);
		twoColumnSearchWindow(driver, Terminal_Header, Filter_Condition, Terminal_Input);

		Step_End(13, "Enter the Service, Vessel, Voyage , Port, and Terminal", test, test1);

		Step_Start(14, "Click on load Button", test, test1);

		waitForElement(driver, OLV_Load_btn);
		click(driver, OLV_Load_btn);

		Step_End(14, "Click on load Button", test, test1);
		waitForElement(driver, OLV_Grid_Filter_Btn);
		click(driver, OLV_Grid_Filter_Btn);

		Step_Start(15, "Filter Only Row Doesnot has BL Number", test, test1);
		reArrangeAG_GridColumnsNew(driver, OLV_cocloum_click, Column_Header);
		Step_End(15, "Filter Only Row Doesnot has BL Number", test, test1);
		sendKeys(driver, Re_arange_Bl_filter, Bl_Number);
		Step_Start(16, "Verify that Make sure BLs matched these fields- COMMODITY", test, test1);
		List<WebElement> tableCells = driver.findElements(
				By.xpath("//div[@id='OPS-OPS_OpsListGrid_tbl']//div[@col-id='commodityL' and @role='gridcell']"));

		// Loop through the table cells, extract text, convert to int, and add
		for (WebElement cell : tableCells) {
			String cellText = cell.getText().trim(); // Get text and trim whitespace
			if (COMMODITY_Code.equals(cellText)) {

				System.out.println("Pass : The expected Commodity Detials from Discharge Reconciliation is : "
						+ COMMODITY_Code + "|| The actual Commodity Detials from Operetion List View is : " + cellText);
				Extent_pass(
						driver, "Pass : The expected Commodity Detials from Discharge Reconciliation is : "
								+ COMMODITY_Code + " || The actual Commodity Detials from Operetion List View is : " + cellText,
						test, test1);
			} else {
				System.out.println(" Fail : The expected Commodity Detials from Discharge Reconciliation is : "
						+ COMMODITY_Code + " || The actual Commodity Detials from Operetion List View is : " + cellText);
				Extent_fail(
						driver, "Fail : The expected Commodity Detials from Discharge Reconciliation is : "
								+ COMMODITY_Code + " || The actual Commodity Detials from Operetion List View is : " + cellText,
						test, test1);

			}

		}
		Step_End(16, "Verify that Make sure BLs matched these fields- COMMODITY", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
	}

}
