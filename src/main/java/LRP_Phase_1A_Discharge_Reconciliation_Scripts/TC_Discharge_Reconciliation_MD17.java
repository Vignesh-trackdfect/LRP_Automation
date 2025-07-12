package LRP_Phase_1A_Discharge_Reconciliation_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD17 extends Keywords{

public void Discharge_Reconciliation_MD17(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Discharge_Reconciliation_MD17";
		
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
		String BL_No=Excel_data.get("Bl_Number");
		String Search_By=Excel_data.get("BOL_BL_No_Header");
		String global_Search_Condition=Excel_data.get("global_Search_Condition");
		String bill_of_landing_module=Excel_data.get("Bill_Of_Lading_Module");
		String MCN_No_Status=Excel_data.get("MCN_No_Status");
		String Filters = Excel_data.get("BOL_Filters_Header");
		String Plan_Input=Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);	
		
		
		
		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver ,url);
		
		LRP_Login(driver, Username, Password);
		
		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
	
		SwitchProfile(driver, AgencyUser);
		
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);


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
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
		
				if(!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal_Input);
				
		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);

		Step_Start(5," Select the Plan as ALL/Local/Transhipment",test,test1);
		
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		
		
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		
		Step_End(5,"Select the Plan as ALL/Local/Transhipment",test,test1);
		
		
		Step_Start(6,"Click on Download BL Button",test,test1);
		
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		
		Step_End(6,"Click on Download BL Button",test,test1);
		
		Step_Start(7,"Filter the BL and Capture the MCN No for the respective BL",test,test1);
		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Filters);

		

		waitForElement(driver, Filter_btn_DR);
		click(driver, Filter_btn_DR);
		
		waitForElement(driver, BL_No_DR);
		click(driver, BL_No_DR);
		
		
		sendKeys(driver, BL_No_DR, BL_No);
		click(driver, BL_No_DR);
		

		String MCN_Numbers =getText(driver, Discharge_mcn_gird_value);
		Step_End(7,"Filter the BL and Capture the MCN No for the respective BL",test,test1);
		
		System.out.println("MCN Numbers :"+MCN_Numbers);
		
		Step_Start(8,"Open Bill of lading module",test,test1);
		
		
		moduleNavigate(driver, bill_of_landing_module);
		
		Step_End(8,"Open Bill of lading module",test,test1);
		
		Step_Start(9,"load the BL no from same BL module",test,test1);
		
		waitForElement(driver,SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
			
		
		globalValueSearchWindow(driver, global_Search_Condition, Search_By,BL_No, "", "", "", "");
		
		Step_End(9,"load the BL no from same BL module",test,test1);
		
		Step_Start(10,"Go to MCN number text Field ares",test,test1);
		
		Step_Start(11,"Find the Apporved MCN Row and Double Click on it",test,test1);
		
		String select_MCN=String.format(BOL_pgMcnNo_content, MCN_No_Status);
		waitForElement(driver,select_MCN);
		doubleClick(driver, select_MCN);
		
		Step_End(11,"Find the Apporved MCN Row and Double Click on it",test,test1);
		
		Step_End(10,"Go to MCN number text Field ares",test,test1);
		
		Step_Start(12,"system will open MCN module along with same MCN Number",test,test1);
	
		waitForElement(driver,MCN_No_MR_DR);
		String MCN_NO_MR=getAttribute(driver,MCN_No_MR_DR,"value");
		System.out.println(MCN_NO_MR);
		
		Step_End(12,"system will open MCN module along with same MCN Number",test,test1);
		
		Step_Start(13,"Verify that same Captured MCN from Discharge recon has to matched now",test,test1);
		
		if(MCN_Numbers.equals(MCN_NO_MR)) {
			 System.out.println("Matched || Expected : Discharge_Reconciliation MCN Numbers is "+ MCN_Numbers + "||   Actual  : Manifest Correction Notes (MCN)  Number is: " +MCN_NO_MR );
			 Extent_pass(driver, "Matched || Expected : Discharge_Reconciliation MCN Numbers  is "+ MCN_Numbers + "||   Actual  : Manifest Correction Notes (MCN) Number is : " +MCN_NO_MR ,test, test1);
		 }else {
			 System.out.println("Not Matched || Expected : Discharge_Reconciliation MCN Numbers is  "+ MCN_Numbers + "||   Actual  : Manifest Correction Notes (MCN)  Number is : " +MCN_NO_MR);
			 Extent_fail(driver, "Not Matched || Expected : Discharge_Reconciliation MCN Numbers  is "+ MCN_Numbers + "||   Actual  :Manifest Correction Notes (MCN)  Number is : " +MCN_NO_MR ,test, test1);
		
		 }
		Step_End(13,"Verify that same Captured MCN from Discharge recon has to matched now",test,test1);
		 Extent_completed(testcase_Name, test, test1);
   }
}
