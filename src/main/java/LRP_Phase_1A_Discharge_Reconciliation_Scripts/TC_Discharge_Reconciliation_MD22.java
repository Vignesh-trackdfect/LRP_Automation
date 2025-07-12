package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD22 extends Keywords{

public void Discharge_Reconciliation_MD22(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Discharge_Reconciliation_MD22";
		
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
		String BL_No = Excel_data.get("Bl_Number");
		String Search_By = Excel_data.get("BOL_BL_No_Header");
		String global_Search_Condition = Excel_data.get("global_Search_Condition");
		String bill_of_landing_module = Excel_data.get("Bill_Of_Lading_Module");
		String Service_Header = Excel_data.get("Service_Header");
		String Plan_Input = Excel_data.get("Plan_Type");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Vessel_Header = Excel_data.get("Vessel_Header");
//	    String Bl_wi_MF_Filters = Excel_data.get("Bl_wi_MF_Filters");
		String Status = Excel_data.get("Status");
//		String Manifest_Closed = Excel_data.get("Manifest_Closed");
		
		
		
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);	
		Extent_Start(testcase_Name, test, test1);	
		navigateUrl(driver ,url);
		LRP_Login(driver, Username, Password);
	
		Step_Start(1,"Switch to agency",test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency",test, test1);

		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);
		moduleNavigate(driver, Dis_Recon_Module);
		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on New Button", test, test1);
		newButton(driver);
		Step_End(3, "Click on New Button", test, test1);

		Step_Start(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		waitForElement(driver, Service_Option);
		click(driver, Service_Option);
		twoColumnSearchWindow(driver, Service_Header, Filter_Condition, Service_Input);
		

		waitForElement(driver, Vessele_Option);
		click(driver, Vessele_Option);
		twoColumnSearchWindow(driver, Vessel_Header, Filter_Condition, Vessel_Input);
		
		waitForElement(driver, DR_Voyage_Option);
		sendKeys(driver, DR_Voyage_Option, Voyage_Input);

		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);

		if (!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		
		click1(driver,grid_terminal_IMP_DOC);
		sendKeys(driver, grid_terminal_IMP_DOC, Terminal_Input);
		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);

		Step_Start(5, " Select the Plan as ALL/Local/Transhipment", test, test1);
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);

		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);

		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);

		Step_End(5, "Select the Plan as ALL/Local/Transhipment", test, test1);

		Step_Start(6, "Click on Download BL Button", test, test1);

		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);

		Step_End(6, "Click on Download BL Button", test, test1);
		
		Step_Start(7, "Click on Summary Button", test, test1);
		
		waitForElement(driver, Show_Summary_Btn_DR);
		click(driver , Show_Summary_Btn_DR);
		
		Step_End(7, "Click on Summary Button", test, test1);
		
		Step_Start(8, "Click on BL(s) Without MF Closed Command Button", test, test1);
		
		waitForElement(driver, Bl_Without_MF_btn);
		click(driver , Bl_Without_MF_btn);
		
		Step_End(8, "Click on BL(s) Without MF Closed Command Button", test, test1);
		
		Step_Start(9, "Window will be open Verify that the BL NO which is passed via Excel Sheet that is available", test, test1);
		
	//	reArrangeAG_GridColumnsNew(driver, Bl_without_Mf_cocloum_click , Bl_wi_MF_Filters);
		
		  waitForElement(driver, Filter_btn_Without_Mf);
		  click(driver, Filter_btn_Without_Mf);	
		  
		   // waitForElement(driver, BL_No_DR);
			//sendKeys(driver, BL_No_DR,BL_No);
		
		    waitForElement(driver, Bl_No_Without_MF);
			String Bl_No_Without_MF_value =getText(driver, Bl_No_Without_MF);
			click(driver, Bl_No_Without_MF);
			
			if(Bl_No_Without_MF_value.equals(BL_No)) {
				 System.out.println("Matched || Expected : BL(s) Without MF Closed  BL NO  "+BL_No+ " || Actual  :  The BL NO which is passed via Excel Sheet that is available : "+ Bl_No_Without_MF_value);
				 Extent_pass(driver,"Matched || Expected : BL(s) Without MF Closed  BL NO "+BL_No+ " || Actual  : The BL NO which is passed via Excel Sheet that is available : "+ Bl_No_Without_MF_value,test, test1);
			 }else {
				 System.out.println("Not Matched || Expected : BL(s) Without MF Closed  BL NO "+BL_No+ " || Actual  :The BL NO which is : "+ Bl_No_Without_MF_value);
				 Extent_fail(driver,"Not Matched || Expected : BL(s) Without MF Closed  BL NO "+BL_No+ " || Actual  : The BL NO which is : "+ Bl_No_Without_MF_value,test, test1);
			 }
			
			waitForElement(driver, Bl_without_Mf_close_btn);
			click(driver, Bl_without_Mf_close_btn);
			
		Step_End(9, "Window will be open Verify that the BL NO which is passed via Excel Sheet that is available", test, test1);
		
		Step_Start(10, "Open Bill of lading module", test, test1);
		
		moduleNavigate(driver, bill_of_landing_module);
		
		Step_End(10, "Open Bill of lading module", test, test1);
		
		Step_Start(11, "load the same BL number", test, test1);
		
		 waitForElement(driver,SearchButton_Toolbar);
		 click(driver, SearchButton_Toolbar);
			
		 globalValueSearchWindow(driver, global_Search_Condition, Search_By,BL_No, "", "", "", "");
			
		Step_End(11, "load the same BL number", test, test1);
		
		Step_Start(12, "Go to Ref and status column", test, test1);
		
		waitForElement(driver,DR_Ref_Status_tab );
		click(driver, DR_Ref_Status_tab);
		
		Step_End(12, "Go to Ref and status column", test, test1);
		
		Step_Start(13, "Verify that Manifest closed checkbox is Un-Tick if  discharge reconciliation module has BL Number values defined under BL(s) Without MF Closed", test, test1);
		
		waitForElement(driver, DR_Manifest_Checkbox);
		String manifest_checkbox =getAttribute(driver, DR_Manifest_Checkbox,"class");
		
		 if(manifest_checkbox.contains(Status)) {
			 System.out.println("Matched || Expected : Manifest closed checkbox Should be Unticked if  discharge reconciliation module has BL Number values defined under BL(s) Without MF Closed  || Actual  : Manifest closed checkbox is : " +Status+" , The  discharge reconciliation module has BL Number values defined under BL(s) Without MF Closed as : "+ Bl_No_Without_MF_value);
			 Extent_pass(driver,"Matched || Expected : Manifest closed checkbox Should be Unticked if  discharge reconciliation module has BL Number values defined under BL(s) Without MF Closed  || Actual  : Manifest closed checkbox is : " +Status+" , The  discharge reconciliation module has BL Number values defined under BL(s) Without MF Closed as : "+ Bl_No_Without_MF_value,test, test1);
		 }else {
			 System.out.println("Not Matched || Expected : Manifest closed checkbox Should be Unticked if  discharge reconciliation module has BL Number values defined under BL(s) Without MF Closed  || Actual  : Manifest closed checkbox is : In " +Status+" , The  discharge reconciliation module has BL Number values defined under BL(s) Without MF Closed as : "+ Bl_No_Without_MF_value);
			 Extent_fail(driver,"Not Matched || Expected : Manifest closed checkbox Should be Unticked if  discharge reconciliation module has BL Number values defined under BL(s) Without MF Closed || Actual  : Manifest closed checkbox is : In " +Status+" , The  discharge reconciliation module has BL Number values defined under BL(s) Without MF Closed as : "+ Bl_No_Without_MF_value,test, test1);
		 }
	
		 Step_End(13, "Verify that Manifest closed checkbox is Un-Tick if discharge reconciliation module has BL Number values defined under BL(s) Without MF Closed", test, test1);
  
Extent_completed(testcase_Name, test, test1);

}
}
