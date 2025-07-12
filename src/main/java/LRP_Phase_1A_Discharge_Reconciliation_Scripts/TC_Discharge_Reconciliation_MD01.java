package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD01 extends Keywords {

	public void Discharge_Reconciliation_MD01(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String test_Case_Name = "TC_Discharge_Reconciliation_MD01";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String Service_records_count = Excel_data.get("Service_records_count");
		String Service_Input = Excel_data.get("Service_Input");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Plan_Options = Excel_data.get("Plan_Type");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		

		Extent_Start(test_Case_Name, test, test1);
		Step_Start(1, "Open application", test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
        Step_End(1, "Open application", test, test1);

		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);
		moduleNavigate(driver, Dis_Recon_Module);
		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on new button if new button not available go below,", test, test1);
		newButton(driver);
		Step_End(3, "Click on new button if new button not available go below,", test, test1);

		Step_Start(4, "Enter the service code", test, test1);
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		Step_End(4, "Enter the service code", test, test1);
		Step_Start(5, "Verify  that No service details listed in Line Profile", test, test1);
		waitForElement(driver, Service_records_count_DR);
		String datacount = getText(driver, Service_records_count_DR);

		if (datacount.equals(Service_records_count)) {

			System.out.println(
					"Pass || Expected result : No records should be found || Actual result : No records found");
			Extent_pass(driver,
					"Pass || Expected result : No records should be found || Actual result : No records found", test,
					test1);
		} else {

			System.out.println("Fail || Expected result : No records should be found || Actual result : " + datacount
					+ " records are found");
			Extent_fail(driver, "Pass || Expected result : No records should be found || Actual result : " + datacount
					+ " records are found", test, test1);

		}

		Step_End(5, "Verify  that No service details listed in Line Profile", test, test1);

		Step_Start(6, " Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
	    Step_End(6, "Switch to agency", test, test1);
	    Step_Start(7, "Open Discharge Reconciliation Module", test, test1);
		moduleNavigate(driver, Dis_Recon_Module);
		Step_End(7, "Open Discharge Reconciliation Module", test, test1);
		Step_Start(8, "Click on new button if new button not available go below,", test, test1);
		newButton(driver);
		Step_End(8, "Click on new button if new button not available go below,", test, test1);
		
		Step_Start(9, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver,grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
				if(!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
				waitForElement(driver, grid_selectbtn_IMP_DOC);
				click(driver, grid_selectbtn_IMP_DOC);
				
		Step_End(9, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);
		Step_Start(10, "Select the Plan as ALL/Local/Transhipment.,", test, test1);
		waitForElement(driver,Plan_Option);
		click(driver, Plan_Option);
		
		formatLocatorClick(driver, Plan_Option_Select,Plan_Options);
		
		Step_End(10, " Select the Plan as ALL/Local/Transhipment.,", test, test1);
		Step_Start(11, " Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(11, " Click on Download BL Button.", test, test1);
		Step_Start(12, "Verify that Data is presented in Agency ", test, test1);
		if(isdisplayed(driver, AG_Grid_First_Row)) {
			System.out.println(
					"Pass || Expected result : After switching the agency, Datas should be present in agency || Actual result : After switching the agency, Data is presented in Agency");
			Extent_pass(driver,"Pass || Expected result : Datas should be present in agency  || Actual result : After switching the agency, Data is presented in Agency", test,
					test1);
		} else {

			System.out.println("Fail || Expected result : After switching the agency, Datas should be present in agency || Actual result : " 
	+  " After switching the agency,  Data is not presented in Agency");
			Extent_fail(driver, "Fail || Expected result : After switching the agency,  Datas should be present in agency || Actual result : " 
					+ " After switching the agency, Data is not presented in Agency", test, test1);

		}
		Step_End(12, "Verify that Data is presented in Agency ", test, test1);
		  Extent_completed(test_Case_Name, test, test1);
		   

	}

}
