package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD19 extends Keywords{
	
	public void Discharge_Reconciliation_MD19(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {
		
		String testcase_Name = "TC_Discharge_Reconciliation_MD19";
		
		
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
		String Plan_Input=Excel_data.get("Plan_Type");
		String BLNo_Input = Excel_data.get("Bl_Number");
		String Filters = Excel_data.get("BOL_Filters_Header");
		
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);
		String Container_No1 = Excel_data.get("Container_No1");
		String BL_No_Header_Lading = Excel_data.get("BL_No_Header_Lading");
		String Bill_Of_Loading_Module = Excel_data.get("Bill_Of_Lading_Module");
	    String Container_No2 = Excel_data.get("Container_No2");
	    String MCN_No_Header = Excel_data.get("MCN_No_Header");
	    String Condition = Excel_data.get("Filter_Condition");
		String Grid_MCN_No = Excel_data.get("Grid_MCN_No");
		String MCN_Module = Excel_data.get("MCN_Module");
	     
		
        Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver ,url);
		
		LRP_Login(driver, Username, Password);
		
		verifyMainMenu(driver);
		
		
		Step_Start(1, "Switch to agency,", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency,", test, test1);
		
		
		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);
		moduleNavigate(driver, Discharge_Recon_Module);
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
		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Filters);

		waitForElement(driver, Filter_btn_DR);
		click(driver, Filter_btn_DR);	

		waitForElement(driver, BL_No_DR);
		sendKeys(driver, BL_No_DR,BLNo_Input);
		Step_End(7, "Filter the BL NO which is given from Test Data", test, test1);
		
		
		Step_Start(8, " Copy the 20s and 40S Container Count", test, test1);
		waitForElement(driver, BL_No_DR);
		click(driver, BL_No_DR);
		
		waitForElement(driver, DR_20s_value);
		String DR_20s_no =getText(driver, DR_20s_value);
		
		waitForElement(driver, DR_40s_value);
		String DR_40s_no =getText(driver, DR_40s_value);
		Step_End(8, " Copy the 20s and 40S Container Count", test, test1);
		
		  Step_Start(9, " Go to MCN No Column if MCN Number is available Open the MCN module  if not Open Bill of lading and  load the BL NO", test, test1);
		    Step_Start(10, "Go to Equipment summary", test, test1);
		    Step_Start(11, "Capture the Count Based on Group 20s and 40s has to be compare ", test, test1);
		    reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Grid_MCN_No);
			
			String MCN_No_Text = getText(driver, Discharge_mcn_gird_value);
			Extent_pass(driver, "MCN NO value Text is :"+MCN_No_Text, test, test1);
		    System.out.println("Discharge Grid value : " +MCN_No_Text);
		    
			if (!MCN_No_Text.equals("")) {
          moduleNavigate(driver, MCN_Module);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				globalValueSearchWindow(driver, Condition, MCN_No_Header, MCN_No_Text, "", "", "", "");
				
				
				    
			      String Equipment1 = String.format(Equipment_MCN_field,Container_No1 );
			     mouseOverToElement(driver, Equipment1);
			       String ContainerNo_DV20_Verify = getText(driver, Equipment1);
					Extent_pass(driver, "DV20 NO value is :"+ContainerNo_DV20_Verify, test, test1);
				    System.out.println(ContainerNo_DV20_Verify);
				    String Equipment2 = String.format(Equipment_MCN_field,Container_No2 );
				       String ContainerNo_DV40_Verify = getText(driver, Equipment2);
				    
				    
					Step_End(9, " Go to MCN No Column if MCN Number is available Open the MCN module  if not Open Bill of lading and  load the BL NO", test, test1);
				    
				       Step_End(10, " Go to Equipment summary", test, test1);
						
				       Step_End(11, " Capture the Count Based on Group 20s and 40s has to be compare ", test, test1);

				       Step_Start(12, "verify that Tues Count should be matched in Discharge recon and BL/MCN. ", test, test1);
				       if (DR_20s_no.equals(ContainerNo_DV20_Verify)) {
							Extent_pass(driver, " Matched || Discharge reconciliation module 20s Value is : "+ DR_20s_no+ " || Total count in MCN  20s value is : "+ContainerNo_DV20_Verify , test, test1);
							System.out.println(" Matched || Discharge reconciliation module 20s Value is :"+ DR_20s_no+ "|| Total count in Bill Lading 20s value is :"+ContainerNo_DV20_Verify );
							
							
						} else {
							Extent_fail(driver, "UnMatched ||Discharge reconciliation module 20s is :"+ DR_20s_no+ "|| Total count in Bill Lading  20s is :"+ContainerNo_DV20_Verify , test, test1);
							System.out.println("UnMatched || Discharge reconciliation module 20s is :"+ DR_20s_no+ "|| Total count in Bill Lading   20s is :"+ContainerNo_DV20_Verify );

						}
				       
					   	if (DR_40s_no.equals(ContainerNo_DV40_Verify)) {
							Extent_pass(driver, " Matched || Discharge reconciliation module is :"+ DR_20s_no+ "||Total count in Bill Lading  BL/MCN  is :"+ContainerNo_DV40_Verify , test, test1);
							System.out.println(" Matched || Discharge reconciliation module is :"+ DR_20s_no+ "|| Total count in Bill Lading   BL/MCN is :"+ContainerNo_DV40_Verify );
							
							
						} else {
							Extent_fail(driver, "UnMatched ||Discharge reconciliation module is :"+ DR_20s_no+ "|| Total count in Bill Lading  BL/MCNis :"+ContainerNo_DV40_Verify , test, test1);
							System.out.println("UnMatched || Discharge reconciliation module  is :"+ DR_20s_no+ "|| Total count in Bill Lading   BL/MCN is :"+ContainerNo_DV40_Verify );

						}  
				       
				       Step_End(12, " verify that Tues Count should be matched in Discharge recon and BL/MCN. ", test, test1);
				       
				    
				
			} else {
				 moduleNavigate(driver, Bill_Of_Loading_Module);

				 waitForElement(driver,SearchButton_Toolbar);
					click(driver, SearchButton_Toolbar);

					globalValueSearchWindow(driver, Condition, BL_No_Header_Lading,BLNo_Input, "", "", "", "");

				
				
				    
			      String Equipment1 = String.format(Equipment_Bill_Of_Lading_field,Container_No1 );
			     mouseOverToElement(driver, Equipment1);
			       String ContainerNo_DV20_Verify = getText(driver, Equipment1);
					Extent_pass(driver, "DV20 NO value is :"+ContainerNo_DV20_Verify, test, test1);
				    System.out.println(ContainerNo_DV20_Verify);
				  
				    String Equipment2 = String.format(Equipment_Bill_Of_Lading_field,Container_No2);
				    String ContainerNo_DV40_Verify = getText(driver, Equipment2);

	    
		Step_End(9, " Go to MCN No Column if MCN Number is available Open the MCN module  if not Open Bill of lading and  load the BL NO", test, test1);
	    
	       Step_End(10, " Go to Equipment summary", test, test1);
			
	       Step_End(11, "Capture the Count Based on Group 20s and 40s has to be compare ", test, test1);

	       Step_Start(12, "verify that Tues Count should be matched in Discharge recon and BL/MCN. ", test, test1);
	       
	   	if (DR_20s_no.equals(ContainerNo_DV20_Verify)) {
			Extent_pass(driver, " Matched || Discharge reconciliation module 20 s value is :"+ DR_20s_no+ "||Total count in Bill Lading  20s  is :"+ContainerNo_DV20_Verify , test, test1);
			System.out.println(" Matched ||Discharge reconciliation module 20 s value is  :"+ DR_20s_no+ "|| Total count in Bill Lading   20s is :"+ContainerNo_DV20_Verify );
			
			
		} else {
			Extent_fail(driver, "UnMatched ||Discharge reconciliation module 20 s value is :"+ DR_20s_no+ "|| Total count in Bill Lading 20s is :"+ContainerNo_DV20_Verify , test, test1);
			System.out.println("UnMatched || Discharge reconciliation module 20 s value is :"+ DR_20s_no+ "|| Total count in Bill Lading  20s is :"+ContainerNo_DV20_Verify );

		}
	   	if (DR_40s_no.equals(ContainerNo_DV40_Verify)) {
			Extent_pass(driver, " Matched || Discharge reconciliation module 40s is :"+ DR_40s_no+ "||Total count in Bill Lading  40s  is :"+ContainerNo_DV40_Verify , test, test1);
			System.out.println(" Matched || Discharge reconciliation module 40s is :"+ DR_40s_no+ "|| Total count in Bill Lading   40s is :"+ContainerNo_DV40_Verify );
			
			
		} else {
			Extent_fail(driver, "UnMatched ||Discharge reconciliation module 40s is :"+ DR_40s_no+ "|| Total count in Bill Lading  40s :"+ContainerNo_DV40_Verify , test, test1);
			System.out.println("UnMatched || Discharge reconciliation module  40s is :"+ DR_40s_no+ "|| Total count in Bill Lading   40s is :"+ContainerNo_DV40_Verify );

		}  
	       Step_End(12, " verify that Tues Count should be matched in Discharge recon and BL/MCN. ", test, test1);
	       Extent_completed(testcase_Name, test, test1);
	       
			}
	      
       }


}

