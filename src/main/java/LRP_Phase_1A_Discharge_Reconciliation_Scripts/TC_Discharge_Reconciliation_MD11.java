package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD11 extends Keywords{
	public void Discharge_Reconciliation_MD11(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String test_Case_Name = "TC_Discharge_Reconciliation_MD11";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Discharge_planning_DP = Excel_data.get("Discharge_Recon_Module");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Plan_Options= Excel_data.get("Plan_Type");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Expected_Reconciliation_Selected = Excel_data.get("Expected_Reconciliation_Selected");

		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		Step_Start(1, " Switch to Agency,", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, " Switch to Agency,", test, test1);

		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);
		moduleNavigate(driver, Discharge_planning_DP);
		Step_End(2, "Open Discharge Reconciliation Module", test, test1);
		
		Step_Start(3, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);
		waitForElement(driver, Service_input_field_DP);
		sendKeys(driver, Service_input_field_DP, Service_Input);
	    waitForElement(driver, Vessel_input_field_DP);
	    sendKeys(driver, Vessel_input_field_DP, Vessel_Input);
	    waitForElement(driver, Voyage_input_field_DP);
        sendKeys(driver, Voyage_input_field_DP, Voyage_Input);
        waitForElement(driver, Bound_input_field_DP);
        sendKeys(driver, Bound_input_field_DP, Bound_Input);
		if (!Port_Input.equals("")) {
		waitForElement(driver, Grid_scroll_DP);
	    scrollUsingElement(driver, Grid_scroll_DP);
	    horizontalscroll(driver, Grid_scroll_DP, 300);
	    click1(driver, Grid_scroll_port_DP);
		sendKeys(driver, Grid_scroll_port_DP, Port_Input);
		waitForElement(driver,Grid_terminal_DP);
		sendKeys(driver,Grid_terminal_DP,Terminal_Input );
		
		}
 	  waitForElement(driver, Grid_selectbutton_DP);
	  click(driver, Grid_selectbutton_DP);
     	Step_End(3, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);

     	Step_Start(4, "Select the Plan as ALL/Local/Transhipment.,", test, test1);
	   waitForElement(driver,Plan_option_DP);
 	   click(driver, Plan_option_DP);
       formatLocatorClick(driver,Plan_optionSelect_DP ,Plan_Options );
	   Step_End(4, " Select the Plan as ALL/Local/Transhipment.,", test, test1);
	   
	   Step_Start(5, "Click on Reconciliation Command Button,", test, test1);
	   
	   waitForElement(driver,ReconcilationButton_DP);
 	   click(driver, ReconcilationButton_DP);
	   
	   
	   Step_End(5, "Click on Reconciliation Command Button,", test, test1);
	   
	   Step_Start(6, "Verify that Discharge Reconciliation module Got Opened,", test, test1);
	   scrollTop(driver);
	   waitForElement(driver, Dischargerecon_header_DP);
	   String Actual_Disreconciliation = getAttribute(driver,Dischargerecon_header_DP, "aria-expanded");
	   System.out.println("Actual Disreconciliation selected : " + Actual_Disreconciliation);
	    
	    if (Actual_Disreconciliation.equals(Expected_Reconciliation_Selected)) {
			System.out.println(
					"Matched || Expected result : Reconciliation module should be opened "  + Expected_Reconciliation_Selected + "|| Actual result :Reconciliation module is opened  " +  Actual_Disreconciliation );
			Extent_pass(driver,
					"Matched || Expected result: result :Reconciliation module should be opened  " + Expected_Reconciliation_Selected  + " || Actual result: Reconciliation module is opened" +  Actual_Disreconciliation , test,
					test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected result :Reconciliation module should be opened   "+ Expected_Reconciliation_Selected  +  "|| Actual result :Reconciliation is not opened  " +  Actual_Disreconciliation );
			Extent_fail(driver,
					"Not Matched ||  Expected result : Reconciliation module should be opened "+ Expected_Reconciliation_Selected +  " || Actual result : Reconciliation is not opened" +  Actual_Disreconciliation 
					,test, test1);
		}
	   Step_End(6, "Verify that Discharge Reconciliation module Got Opened,", test, test1);

	   Step_Start(7, "Verify that BLs are listed in Grid,", test, test1);
	   
	 
//	   waitForElement(driver,download_BL_Button_DRCnavfromDP);
//	   click(driver, download_BL_Button_DRCnavfromDP);
	   waitForDisplay(driver, BLnumbers_listed_DP);
	   if(isdisplayed(driver, BLnumbers_listed_DP)) {
			System.out.println(
					"Pass || Expected result :BLs should be listed in Grid  || Actual result :BLs are listed in Grid ");
			Extent_pass(driver,"Pass || Expected result : BLs should be listed in Grid   || Actual result :BLs are listed in Grid", test,
					test1);
		} else {

			System.out.println("Fail || Expected result : BLs should be listed in Grid || Actual result :BLs are not listed in Grid " );
			
			Extent_fail(driver, "Fail || Expected result :  BLs should be listed in Grid || Actual result : BLs are not listed in Grid", test, test1);

		}
	   
	   
	   
	   Step_End(7, "Verify that BLs are listed in Grid,", test, test1);
Extent_completed(test_Case_Name, test, test1);
	
		}
	}


