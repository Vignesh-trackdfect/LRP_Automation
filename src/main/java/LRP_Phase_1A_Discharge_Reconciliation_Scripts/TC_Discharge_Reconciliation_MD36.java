package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD36 extends Keywords {
public void Discharge_Reconciliation_MD36(WebDriver driver ,ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		
		String testcase_Name="TC_Discharge_Reconciliation_MD36";
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
		String Pol_Header = Excel_data.get("IMP_Pol_Header");
		String Pol_Input = Excel_data.get("IMP_Pol_Input");
		String Pol_Input1 = Excel_data.get("IMP_Pol_Input1");
		String Pol_Button_Input = Excel_data.get("IMP_Pol_Button_Input");
		
		String select_Option_1 = String.format(DropDown_Select, Pol_Input);
		String select_Option_2 = String.format(DropDown_Select, Pol_Input1);
		
		
		
		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver ,url);
		
		LRP_Login(driver, Username, Password);

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
		
		Step_Start(7, "Click on Show Summary button", test, test1);
		waitForElement(driver, Show_Summary_Btn_DR);
		click(driver, Show_Summary_Btn_DR);
		Step_End(7, "Click on Show Summary button", test, test1);
		
		Step_Start(8, "Go to Import Documentation Saved  Label and Capture the Total Count of saved BLs.", test, test1);
		String Count_Saved1 = getAttribute(driver, Count_Saved_Label, "value");
		
		
		Extent_pass(driver, "the Total Count of saved BLs is :"+Count_Saved1, test, test1);
	    System.out.println(Count_Saved1);
	    Step_End(8, "Go to Import Documentation Saved  Label and Capture the Total Count of saved BLs.", test, test1);	
       
        Step_Start(9, " Open Import Documentation module", test, test1);
	    
        waitForElement(driver, importDocumentation_Button_DRC);
		click(driver, importDocumentation_Button_DRC);
	   
	    Step_End(9, " Open Import Documentation module", test, test1);
	    
	    Step_Start(10, "Click on New button if New Button is not Available Go to Next Step", test, test1);
	//doubt clarify with team
	   // boolean enabled = isElementEnabled(driver, NewButton_ToolBar);
	    
		newButton(driver);
		
		Step_End(10, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		
		 Step_Start(11, " Enter the Service, Vessel, Voyage , Port, and Terminal", test, test1);
		 
		 waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service_Input);

				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
				
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
				
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
				
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
				
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 300);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal_Input);
			
				waitForElement(driver, Select_Service_Details);
			click(driver,Select_Service_Details);

			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);

			 Step_End(11, " Enter the Service, Vessel, Voyage , Port, and Terminal", test, test1);
	    
			 Step_Start(12, "Out of 3 select it  as SavedBL option ALL/ SavedBL/ UnSavedBL,(Bring it from Test data)", test, test1);
				if(!Pol_Button_Input.equals("")) {
					waitForElement(driver, POLSearch);
					click(driver, POLSearch);
					twoColumnSearchWindow(driver, Pol_Header, Condition, Pol_Button_Input);
				} 
			 waitForElement(driver, slection_Label_1);
				click(driver, slection_Label_1);
				click(driver, select_Option_1);
				 Step_End(12, "Out of 3 select it  as SavedBL option ALL/ SavedBL/ UnSavedBL,(Bring it from Test data)", test, test1);
				
				 Step_Start(13, "  Out of 3 select it  as ALL option ALL/LOCAL/FIFO/LIFO (Bring it from Test data).", test, test1); 
				 waitForElement(driver, slection_Label_2);
				click(driver, slection_Label_2);
				click(driver, select_Option_2);
				 Step_End(13, "  Out of 3 select it  as ALL option ALL/LOCAL/FIFO/LIFO (Bring it from Test data).", test, test1);
			 
				 Step_Start(14, " Click on SHOW BLs button", test, test1);
				 waitForElement(driver, Show_BL_Button);
					click(driver, Show_BL_Button);
					Step_End(14, " Click on SHOW BLs button", test, test1);
					
					 Step_Start(15, "Go and Find the Count of SAved BL and Capture it", test, test1);
					 waitForElement(driver, BL_Text);
					 String valid2 = getText(driver, BL_Text);
					 System.out.println("Full text: " + valid2);

					 // Ensure the string contains a "/" to avoid ArrayIndexOutOfBoundsException
					 
					 if (valid2.contains("/")) {
					     String[] savedBL = valid2.split("/");
					     String saved_BL_Count = savedBL[1].trim(); 
					     System.out.println("Extracted count: " + saved_BL_Count);
					 
					 
						Extent_pass(driver, "The Total Count of saved BLs in the import document is :"+ saved_BL_Count, test, test1);
					    System.out.println(saved_BL_Count);
					 
					 Step_End(15, "Go and Find the Count of SAved BL and Capture it", test, test1);
			
					 Step_Start(16, " Verify  that saved BL Count in Discharge reconciliation and  IMport Documentation has been matched.", test, test1);
					 

				        if (saved_BL_Count.equals(Count_Saved1.trim())) {
							
				        	System.out.println(" Expected saved BL Count in Discharge reconciliation is :"+Count_Saved1+"   ||Actual Value present in Import Document Saved Column  is : "+saved_BL_Count);
				 			Extent_pass(driver, "Expected saved BL Count in Discharge reconciliation is  :"+Count_Saved1+"   ||Actual Value present in Import Document Saved Column  is: "+saved_BL_Count, test, test1);
				 		}else {
				 			System.out.println("UnExpected saved BL Count in Discharge reconciliation is  : "+Count_Saved1+"   ||Actual Value present in Import Document Saved Column  is   : "+saved_BL_Count);
				 			Extent_fail(driver, "UnExpected saved BL Count in Discharge reconciliation is  :"+Count_Saved1+"   ||Actual Value present in Import Document Saved Column  is   : "+saved_BL_Count, test, test1);
				 		}
					 
					 }
					 else {
						    System.out.println("Unexpected format: " + valid2);
						}
					 Step_End(16, " Verify  that saved BL Count in Discharge reconciliation and  IMport Documentation has been matched.", test, test1);
					 
					 Extent_completed(testcase_Name, test, test1);
}
}

