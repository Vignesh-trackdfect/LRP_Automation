package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD40 extends Keywords{

	
	public void Discharge_Reconciliation_MD40(WebDriver driver ,ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		
		String testcase_Name="TC_Discharge_Reconciliation_MD40";
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
		String Plan_Input=Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);	
		String BLNo_Input = Excel_data.get("Bl_Number");
		String Bill_Of_Loading_Module = Excel_data.get("Bill_Of_Lading_Module");
		String System_BL_Grid = Excel_data.get("System_BL_Grid");
		String BL_No_Header_Lading = Excel_data.get("BL_No_Header_Lading");
		
		
		
		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver ,url);
		
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
		
				if(!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
				click1(driver,grid_terminal_IMP_DOC);
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
		
      Step_Start(7, "Filter the BL NO which is given from Test Data", test, test1);
		
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, BLNo_Input);
		
				
		waitForElement(driver, Bl_Number_input_re_con_row_click);
		click(driver, Bl_Number_input_re_con_row_click);
		
		
		
		Step_End(7, "Filter the BL NO which is given from Test Data", test, test1);
		
		
		 Step_Start(8, "COpy the System BL Type value", test, test1);
        reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, System_BL_Grid);
		
		String Discharge_Grid_Text_Verify = getText(driver, Text_Get_Yes_No);
		Extent_pass(driver, "System BL Type value Text is :"+Discharge_Grid_Text_Verify, test, test1);
	    System.out.println(Discharge_Grid_Text_Verify);
	    
//	    waitForElement(driver, Close_Current_tab);
//  		click(driver,Close_Current_tab);
  		
	    Step_End(8, "COpy the System BL Type value", test, test1);
	    
	    Step_Start(9, " Go to Bill of lading module", test, test1);

		moduleNavigate(driver, Bill_Of_Loading_Module);
		
		Step_End(9, " Go to Bill of lading module", test, test1);
		
		  Step_Start(10, " load the same BL number", test, test1);
		   
		  
		  waitForElement(driver,SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, Condition, BL_No_Header_Lading, BLNo_Input, "", "", "", "");
			
			Step_End(10, " load the same BL number", test, test1);
			
			Step_Start(11, " If Bl has MCN Open the approved status MCN (else follow BL in BL.)", test, test1);
			
			
			if(isdisplayed(driver, BOL_MCN_NO_Column)) {
				
				 waitForElement(driver,BOL_MCN_NO_Column);
					doubleClick(driver, BOL_MCN_NO_Column);
					
					 waitForElement(driver,MCN_Status_Text);
					String MCN_status = getText(driver, MCN_Status_Text);
					
				System.out.println("MCN NO is available and Status of MCN is Approved"+MCN_status);
				Extent_pass(driver, "MCN NO is available and Status of MCN is Approved"+MCN_status, test, test1);
				
				Step_End(11, " If Bl has MCN Open the approved status MCN (else follow BL in BL.)", test, test1);
				
				
				Step_Start(12, " Go to system BL type place capture the system BL Type", test, test1);
				
				String MCN_Text_Verify = getAttribute(driver, MCN_System_BL_Type,"value");
				Extent_pass(driver, "System BL Type value in MCN Module is :"+MCN_Text_Verify, test, test1);
			    System.out.println(MCN_Text_Verify);
				
			    waitForElement(driver, Close_Current_tab);
		  		click(driver,Close_Current_tab);
		  		
		  		waitForElement(driver, Close_Current_tab);
		  		click(driver,Close_Current_tab);
				
				
				Step_End(12, " Go to system BL type place capture the system BL Type", test, test1);
				
				Step_Start(13, "Verify that system BL type matched with BL/MCN and Discharge reconciliation module", test, test1);
				
				if (Discharge_Grid_Text_Verify.trim().equals(MCN_Text_Verify.trim())) {
					Extent_pass(driver, " Excepted System BL type value in || Discharge reconciliation module is :"+ Discharge_Grid_Text_Verify+ "||Actual system BL type matched with BL/MCN  is :"+MCN_Text_Verify , test, test1);
					System.out.println(" Excepted System BL type value in || Discharge reconciliation module is :"+ Discharge_Grid_Text_Verify+ "|| Actual system BL type matched with BL/MCN is :"+MCN_Text_Verify );
					
					
				} else {
					Extent_fail(driver, "UnExcepted System BL type value in ||Discharge reconciliation module is :"+ Discharge_Grid_Text_Verify+ "|| Actual system BL type matched with BL/MCNis :"+MCN_Text_Verify , test, test1);
					System.out.println("UnExcepted System BL type value in || Discharge reconciliation module  is :"+ Discharge_Grid_Text_Verify+ "|| Actual system BL type matched with BL/MCN is :"+MCN_Text_Verify );

				}
				
			}else {
				
				Extent_pass(driver, "MCN NO is Not available For this BL "+BLNo_Input, test, test1);
				System.out.println("MCN NO is Not available For this BL "+BLNo_Input);
			
			Step_End(11, " If Bl has MCN Open the approved status MCN (else follow BL in BL.)", test, test1);
			
			
			Step_Start(12, " Go to system BL type place capture the system BL Type", test, test1);
			
			String BillOfLading_Text_Verify = getAttribute(driver, System_BL_Type_Field,"value");
			Extent_pass(driver, "System BL Type value in Bill Of Lading Module is :"+BillOfLading_Text_Verify, test, test1);
		    System.out.println(BillOfLading_Text_Verify);
			
		    waitForElement(driver, Close_Current_tab);
	  		click(driver,Close_Current_tab);
	  			
			
			Step_End(12, " Go to system BL type place capture the system BL Type", test, test1);
			
			Step_Start(13, "Verify that system BL type matched with BL/MCN and Discharge reconciliation module", test, test1);
			
			if (Discharge_Grid_Text_Verify.trim().equals(BillOfLading_Text_Verify.trim())) {
				Extent_pass(driver, " Excepted System BL type value in || Discharge reconciliation module is :"+ Discharge_Grid_Text_Verify+ "||Actual system BL type matched with BL/MCN  is :"+BillOfLading_Text_Verify , test, test1);
				System.out.println("Excepted System BL type value in || Discharge reconciliation module is :"+ Discharge_Grid_Text_Verify+ "|| Actual system BL type matched with BL/MCN is :"+BillOfLading_Text_Verify );
				
				
			} else {
				Extent_fail(driver, "UnExcepted System BL type value in ||Discharge reconciliation module is :"+ Discharge_Grid_Text_Verify+ "|| Actual system BL type matched with BL/MCNis :"+BillOfLading_Text_Verify , test, test1);
				System.out.println("UnExcepted System BL type value in || Discharge reconciliation module  is :"+ Discharge_Grid_Text_Verify+ "|| Actual system BL type matched with BL/MCN is :"+BillOfLading_Text_Verify );

			}
			}

			Step_End(13, "Verify that system BL type matched with BL/MCN and Discharge reconciliation module", test, test1);
			
			 Extent_completed(testcase_Name, test, test1);
	}
	
	}	
	

