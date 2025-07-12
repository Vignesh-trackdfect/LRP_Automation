package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD57 extends Keywords{
	public void Discharge_Reconciliation_MD57(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) throws AWTException {

		String testcase_Name = "TC_Discharge_Reconciliation_MD57";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String Agency_Config_Module = Excel_data.get("Agency_Config_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Plan_Type = Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Type);
		

		String atribute_value = Excel_data.get("atribute_value");
		String attributeColumn_Header = Excel_data.get("attributeColumn_Header");
		String Agency_condition = Excel_data.get("Agency_condition");
		String agencyColumn_Header = Excel_data.get("agencyColumn_Header");
		String Discription_Value = Excel_data.get("Discription_Value");
		String value = Excel_data.get("value");
		String Reset_Agency_value = Excel_data.get("Reset_Agency_value");
		String Reset_option = Excel_data.get("Reset_option");

		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency,", test, test1);
		Step_Start(2, "Open Agency configuration module", test, test1);
		Step_Start(3, "Click on New button,if new button not available go below steps", test, test1);
		Step_Start(4, "Click on agency code search Button", test, test1);
		Step_Start(5, "Enter the agency code and click on Show Button", test, test1);
		Step_Start(6, " Verify that given configuration is already available if available and make sure that value is Marked as -Y.", test, test1);
		Step_Start(7, " if marked as Y move to next action", test, test1);
		Step_Start(8, " if Configuration marked as N then Double click the row and change the Value to Y and click (+)button", test, test1);
		Step_Start(9, "if Configuration is not added click on (+) button and add the configutation -Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y. and mark as Y", test, test1);

		List<Boolean> newlyAdded = setAgencyConfiguration(driver, Agency_Config_Module, agencyColumn_Header, attributeColumn_Header, Agency_condition, AgencyUser, atribute_value, Discription_Value, value);
	
		Step_End(2, "Open Agency configuration module", test, test1);
		Step_End(3, "Click on New button,if new button not available go below steps", test, test1);
		Step_End(4, "Click on agency code search Button", test, test1);
		Step_End(5, "Enter the agency code and click on Show Button", test, test1);
		Step_End(6, " Verify that given configuration is already available if available and make sure that value is Marked as -Y.", test, test1);
		Step_End(7, " if marked as Y move to next action", test, test1);
		Step_End(8, " if Configuration marked as N then Double click the row and change the Value to Y and click (+)button", test, test1);
		Step_End(9, "if Configuration is not added click on (+) button and add the configutation -Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y. and mark as Y", test, test1);

		
		Step_Start(10, "Open Discharge Reconciliation Module", test, test1);

		moduleNavigate(driver, Dis_Recon_Module);
		
		
		Step_End(10, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(11, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		newButton(driver);

		Step_End(11, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		
		Step_Start(12, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);

		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		waitForElement(driver, grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_bound_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);

				if(!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
				waitForElement(driver, grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC,Terminal_Input);
		
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		
		Step_End(12, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		Step_Start(13, "Select the Plan as ALL/Local/Transhipment.", test, test1);
		
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(13, "Select the Plan as ALL/Local/Transhipment.", test, test1);
		
		Step_Start(14, " Click on Download BL Button", test, test1);
		
	
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(14, " Click on Download BL Button", test, test1);
		
		Step_Start(15, " Verify that DPD Code and Shipment Category Button are enabled in Discharge reconcillation module.", test, test1);
		waitForElement(driver, shipment_catagory_btn);
		if (isElementEnabled(driver, shipment_catagory_btn)) {
			System.out.println(" pass : The Excepted shipment_catagory Button from Discharge Recorn should be Enabled|| The Actual is shipment_catagory Button from Discharge Recorn is Enabled");
			Extent_pass(driver, " pass : The Excepted shipment_catagory Button from Discharge Recorn should be Enabled|| The Actual is shipment_catagory Button from Discharge Recorn is Enabled", test, test1);
		} else {
			System.out.println(" fail : The Excepted shipment_catagory Button from Discharge Recorn should be Enabled|| The Actual is shipment_catagory Button from Discharge Recorn is not Enabled");
			Extent_fail(driver, " fail : The Excepted shipment_catagory Button from Discharge Recorn should be Enabled|| The Actual is shipment_catagory Button from Discharge Recorn is not Enabled", test, test1);
		

		}
		waitForElement(driver, DPD_code_btn);
		if (isElementEnabled(driver, DPD_code_btn)) {
			System.out.println(" pass : The Excepted DPD Button from Discharge Recorn should be Enabled|| The Actual is DPD Button from Discharge Recorn is Enabled");
			Extent_pass(driver, " pass : The Excepted DPD Button from Discharge Recorn should be Enabled|| The Actual is DPD Button from Discharge Recorn is Enabled", test, test1);
		} else {
			System.out.println(" fail : The Excepted DPD Button from Discharge Recorn should be Enabled|| The Actual is DPD Button from Discharge Recorn is not Enabled");
			Extent_fail(driver, " fail : The Excepted DPD Button from Discharge Recorn should be Enabled|| The Actual is DPD Button from Discharge Recorn is not Enabled", test, test1);
		

		}
		Step_End(15, " Verify that DPD Code and Shipment Category Button are enabled in Discharge reconcillation module.", test, test1);
		
		// Reset The AgencyCofiguration
		
		reSetAgencyConfiguration(driver, Agency_Config_Module, agencyColumn_Header, attributeColumn_Header, Agency_condition, AgencyUser,
				 Discription_Value,Reset_Agency_value, newlyAdded,Reset_option);
		
		Extent_completed(testcase_Name, test, test1);
		
		
		

	}

}
