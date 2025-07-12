package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD49 extends Keywords {
	public void Discharge_Reconciliation_MD49(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD49";

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
		String Global_Configure_Name = Excel_data.get("Global_Config_Module");
		String G_C_Attributr_Value = Excel_data.get("Global__Attribute");
		String Change_Value = Excel_data.get("Global_Value");
		String Change_Value_1 = Excel_data.get("Global_Value_Reset");
		String Reset_Option = Excel_data.get("Reset_Option");
		String Plan_Type = Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Type);

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		// SetGlobal Configuration
		Step_Start(1, "Open GLobal Configuration module,", test, test1);
		Step_Start(2, " filter based on attribute /Description\r\n"
				+ "SNF-Discharge Reconciliation - Show Non-Container Details' if it is enabled.", test, test1);
		Step_Start(3, "Double click the Row,", test, test1);
		Step_Start(3.1, "A. Store the Current Value.", test, test1);
		Step_Start(4, "Check this is marked as Y, if Yes  Close the Module.", test, test1);
		Step_Start(5, "Check this if marked as N, Enable this and close the module.", test, test1);

		setGlobalConfiguration(driver, Global_Configure_Name, G_C_Attributr_Value, Change_Value);
		Step_End(1, "Open GLobal Configuration module,", test, test1);
		Step_End(2, " filter based on attribute /Description\r\n"
				+ "SNF-Discharge Reconciliation - Show Non-Container Details' if it is enabled.", test, test1);
		Step_End(3, "Double click the Row,", test, test1);
		Step_End(3.1, "A. Store the Current Value.", test, test1);
		Step_End(4, "Check this is marked as Y, if Yes  Close the Module.", test, test1);
		Step_End(5, "Check this if marked as N, Enable this and close the module.", test, test1);

		Step_Start(6, "Switch to agency,", test, test1);

		SwitchProfile(driver, AgencyUser);
		Step_End(6, "Switch to agency,", test, test1);

		Step_Start(7, "Open Discharge Reconciliation Module", test, test1);

		moduleNavigate(driver, Dis_Recon_Module);

		Step_End(7, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(8, "Click on New Button", test, test1);
		newButton(driver);

		Step_End(8, "Click on New Button", test, test1);

		Step_Start(9, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);

		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		waitForElement(driver, grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_bound_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);

		Step_End(9, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		Step_Start(10, "Select the Plan as ALL/Local/Transhipment.", test, test1);
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
		Step_End(10, "Select the Plan as ALL/Local/Transhipment.", test, test1);

		Step_Start(11, " Click on Download BL Button", test, test1);

		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(11, " Click on Download BL Button", test, test1);

		Step_Start(12, "CLICK ON SHOW SUMMARY BUTTOM.", test, test1);
		waitForElement(driver, Show_Summary_Btn);
		click(driver, Show_Summary_Btn);
		Step_End(12, "CLICK ON SHOW SUMMARY BUTTOM.", test, test1);

		Step_Start(13, "Verify that Non-Container summary Button is not available.", test, test1);
		waitForDisplay(driver, Non_Container_Shipment_Summary_Btn);
		if (!isdisplayed(driver, Non_Container_Shipment_Summary_Btn)) {
			System.out.println(
					"Expected Result is : Non Container shipment summary button should not be Displayed ||  Actual Result is : Non Container shipment summarey button is not Displayed");
			Extent_pass(driver,
					"Expected Result is : Non Container shipment summary button should not Displayed||  Actual Result is : Non Container shipment summarey button is not Displayed ",
					test, test1);
		} else {
			System.out.println(
					"Expected Result is : Non Container shipment summary button should not be Displayed ||  Actual Result is : Non Container shipment summarey button is  Displayed ");
			Extent_fail(driver,
					"Expected Result is : Non Container shipment summary button should not Displayed ||  Actual Result is : Non Container shipment summarey button is Displayed ",
					test, test1);
		}
		Step_End(13, "Verify that Non-Container summary Button is not available.", test, test1);

		// Reset the GlobalConfiguration
		reSetGlobalConfiguration(driver, Reset_Option, Global_Configure_Name, G_C_Attributr_Value, Change_Value_1);

		Extent_completed(testcase_Name, test, test1);

	}

}
