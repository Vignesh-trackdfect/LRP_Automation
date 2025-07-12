package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD38 extends Keywords{

public void Discharge_Reconciliation_MD38(WebDriver driver ,ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		
		String testcase_Name="TC_Discharge_Reconciliation_MD38";
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
		String BLNo_Header_Input = Excel_data.get("BLNo_Header_Input");
		String Plan_Input=Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);	
		String IGM_Saved_Text = Excel_data.get("IGM_Saved_Text");
		String IGM_Deleting_popup = Excel_data.get("IGM_Deleting_popup");
		String System_BL_Input_Text = Excel_data.get("System_BL_Input_Text");
		String Import_Documentation_Module = Excel_data.get("Import_Documentation_Module");
		String BLNo_Input = Excel_data.get("Bl_Number");
		String IGM_Filling_Column_Input = Excel_data.get("Imp_IGM_Filling_Column_Input");
		String BL_No_Header_IGM = Excel_data.get("BL_No_Header_IGM");
		String Import_Documentation_Saved_popup = Excel_data.get("Import_Documentation_Saved_popup");
		String IGM_Generation_Module = Excel_data.get("IGM_Generation_Module");
		String IGM_Saved_popup = Excel_data.get("IGM_Saved_popup");
		String Import_Documentation_Delete_popup = Excel_data.get("Import_Documentation_Delete_popup");		
		String Import_Deleted_popup = Excel_data.get("Import_Deleted_popup");
		String IGM_Deleted_popup = Excel_data.get("IGM_Deleted_popup");
		String Delete_Popup = Excel_data.get("Delete_Popup");
		String BL_No_Header_Import = Excel_data.get("BL_No_Header_Import");
		
		String Remarks_Input = Excel_data.get("IGM_Remarks_Input");
		
		
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
		
		Step_Start(6.1, "Filter your BL NO and IGM Filling Column", test, test1);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, BLNo_Input);
		
				
		waitForElement(driver, Bl_Number_input_re_con_row_click);
		click(driver, Bl_Number_input_re_con_row_click);
		Step_End(6.1, "Filter your BL NO and IGM Filling Column", test, test1);


		Step_Start(6.2, " Verify  that  column has NO value for the BL.", test, test1);
		

		
		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, IGM_Filling_Column_Input);
		
	     String ColumnValue = getText(driver, Text_Get_Yes_No);
		Extent_pass(driver, "IGM Filling Column Text is :"+ColumnValue, test, test1);
	    System.out.println(ColumnValue);

	    Step_End(6.2, " Verify  that  column has NO value for the BL.", test, test1);
	    
      Step_Start(7, " Click on Import Documentation Navigation Button", test, test1);
	    
	    waitForElement(driver,importDocumentation_Button_DRC);
	    click(driver, importDocumentation_Button_DRC);
	   // 
	    
	    Step_End(7, " Click on Import Documentation Navigation Button", test, test1);
	    
        Step_Start(8, " Click on BL Number search and select your BL NO", test, test1);
        waitForElement(driver, BlNoSearchButton);
      		click(driver, BlNoSearchButton);
      		twoColumnSearchWindow(driver,BLNo_Header_Input, Condition, BLNo_Input);
      	    
      
	    Step_End(8, "Click on BL Number search and select your BL NO", test, test1);
	    
       Step_Start(9, " save the Import Documentation system will says \" Import Documentation saved \" message ", test, test1);
	    
        waitForElement(driver,SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Import_Documentation_Saved_popup);
   		String Popup_Text_Act=getText(driver, popup_Message);
// 		
 		if(Popup_Text_Act.equals(Import_Documentation_Saved_popup)) {
 			System.out.println("Popup Matched  ||   Expected : "+Import_Documentation_Saved_popup+"   ||   Actual   : "+Popup_Text_Act);
 			Extent_pass(driver, "Popup Matched  ||   Expected : "+Import_Documentation_Saved_popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
 		}else {
 			System.out.println("Popup Not Matched  ||   Expected : "+Import_Documentation_Saved_popup+"   ||   Actual   : "+Popup_Text_Act);
 			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Import_Documentation_Saved_popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
 		}
 	
	   Step_End(9, "save the Import Documentation system will says \" Import Documentation saved \" message ", test, test1);   
	    
	   Step_Start(10, "then click on Ok button,", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		 waitForElement(driver, Close_Current_tab);
	  		click(driver,Close_Current_tab);
		
		 Step_End(10, "then click on Ok button,", test, test1);
		 
		 
		 Step_Start(11, "Open IGM EDI Generation Module", test, test1);
		 moduleNavigate(driver, IGM_Generation_Module);
		 newButton(driver);
		 Step_End(11, "Open IGM EDI Generation Module", test, test1);
		 
       Step_Start(12, " Enter the Service, Vessel, Voyage , Port, and Terminal", test, test1);
		 
        waitForElement(driver, IGM_service_code);
		sendKeys(driver, IGM_service_code, Service_Input);
		
		waitForElement(driver, IGM_vessel_code);
		sendKeys(driver, IGM_vessel_code, Vessel_Input);
		
		waitForElement(driver, IGM_voyage);
		sendKeys(driver, IGM_voyage, Voyage_Input);
		
		waitForElement(driver, IGM_bound);
		sendKeys(driver, IGM_bound, Bound_Input);
		
				if(!Port_Input.equals("")) {
			waitForElement(driver, grid_scroll);
			scrollUsingElement(driver, grid_scroll);
			horizontalscroll(driver, grid_scroll, 300);
			
			click1(driver,IGM_port_code);
			sendKeys(driver, IGM_port_code, Port_Input);
		}
				click1(driver,IGM_Terminal_code);
				sendKeys(driver, IGM_Terminal_code, Terminal_Input);
				
				waitForElement(driver, grid_selectbtn_IMP_DOC);
				click(driver, grid_selectbtn_IMP_DOC);
				
				

			 Step_End(12, " Enter the Service, Vessel, Voyage , Port, and Terminal", test, test1);
			 
			 Step_Start(13, " Click on SHOW BLs button", test, test1);
			   waitForElement(driver, Show_Button_IGM);
				click(driver, Show_Button_IGM);
				
				waitForDisplay(driver, popup_Message);
				if(isdisplayed(driver, popup_Message)) {
				 waitForElement(driver, popup_Message_Yes_Button);
	           		click(driver,popup_Message_Yes_Button);
				}
				Step_End(13, " Click on SHOW BLs button", test, test1);
	   
				Step_Start(14, " Filter your BL Number that is available from Test Data", test, test1);
				
				click1(driver,BL_Filter_input_IGM_grid);
				sendKeys(driver, BL_Filter_input_IGM_grid, BLNo_Input);
				
				Step_End(14, " Filter your BL Number that is available from Test Data", test, test1);

              Step_Start(15, "Select only that BL NO", test, test1);
				

				formatLocatorClick(driver, Select_BL_NumCheck_IGM, BLNo_Input);
				Step_End(15, " Select only that BL NO", test, test1);
				
               Step_Start(16, "Click on save Button", test, test1);
				
               waitForElement(driver,SaveButton_ToolBar);
       		click(driver, SaveButton_ToolBar);
				
				Step_End(16, "Click on save Button", test, test1);
				
				Step_Start(17, " system shows Message \" Saved successfully. Click Generate IGM File to generate IGM\"", test, test1);
				
				waitForPopup(driver, popup_Message, IGM_Saved_popup);
		   		String Popup_Text_Act1=getText(driver, popup_Message);
//		 		
		 		if(Popup_Text_Act1.equals(IGM_Saved_popup)) {
		 			System.out.println("Popup Matched  ||   Expected popup : "+IGM_Saved_popup+"   ||   Actual   : "+Popup_Text_Act1);
		 			Extent_pass(driver, "Popup Matched  ||   Expected popup: "+IGM_Saved_popup+"   ||   Actual   : "+Popup_Text_Act1, test, test1);
		 		}else {
		 			System.out.println("Popup Not Matched  ||   Expected popup : "+IGM_Saved_popup+"   ||   Actual   : "+Popup_Text_Act1);
		 			Extent_fail(driver, "Popup Not Matched  ||   Expected popup: "+IGM_Saved_popup+"   ||   Actual   : "+Popup_Text_Act1, test, test1);
		 		}
				
		 		Step_End(17, " system shows Message \" Saved successfully. Click Generate IGM File to generate IGM\"", test, test1);
                
		 		waitForElement(driver, popup_Message_Ok_Button);
				click(driver,popup_Message_Ok_Button);
				
				  waitForElement(driver, Close_Current_tab);
			  		click(driver,Close_Current_tab);
				
				
				 Step_Start(18, "Move to Discharge Reconciliation module that is already opened", test, test1);
		         
		         waitForElement(driver, Switch_Discharge_Recon);
		  		click(driver,Switch_Discharge_Recon);
				 
//				 moduleNavigate(driver, Dis_Recon_Module);
		  		Step_End(18, "Move to Discharge Reconciliation module that is already opened", test, test1);
		  		
		  		Step_Start(19, "Click on Refresh Button,", test, test1);
		  		
		 		 waitForElement(driver, Refresh_Btn_Dis);
		 		  click(driver,Refresh_Btn_Dis);
		 		
		 		Step_End(19, "Click on Refresh Button,", test, test1);
		 		
		 		Step_Start(20, "Filter the BL NO Which is recently saved the import Documentation", test, test1);
		  		
			waitForElement(driver, Filter_Button_Re_Con);
			click(driver, Filter_Button_Re_Con);
			waitForElement(driver, Bl_Number_input_re_con);
			sendKeys(driver, Bl_Number_input_re_con, BLNo_Input);
			
			waitForElement(driver, System_BL_Input);
			sendKeys(driver, System_BL_Input, System_BL_Input_Text);

			
			waitForElement(driver, Bl_Number_input_re_con_row_click);
			click(driver, Bl_Number_input_re_con_row_click);
			
				Step_End(20, "Filter the BL NO Which is recently saved the import Documentation", test, test1);
				
				Step_Start(21, "Go to IGM FILLING column", test, test1);

				reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, IGM_Filling_Column_Input);
				
			    Step_End(21, "Go to IGM FILLING column", test, test1);
				
			    
			    Step_Start(22, "Verify that IGM FILLING marked as Yes in Discharge Reconiliation.", test, test1);
			    
			    String ActualText = getText(driver,Text_Get_Yes_No);
				Extent_pass(driver, "IGM Filling Column Text is :"+ActualText, test, test1);
			    System.out.println(ActualText);
			    
				if (ActualText.equals(IGM_Saved_Text)) {
					Extent_pass(driver, " Excepted IGM Filling column  || In Discharge reconciliation module is :"+IGM_Saved_Text+ "Actual IGM Filling column  || In Discharge reconciliation module  is :"+ActualText , test, test1);
					System.out.println(" Excepted IGM Filling column || In Discharge reconciliation module is :"+IGM_Saved_Text+ "Actual IGM Filling column  || In Discharge reconciliation module is :"+ActualText );
					
				} else {
					Extent_fail(driver, "UnExcepted IGM Filling column  || In Discharge reconciliation module is :"+IGM_Saved_Text+ "Actual IGM Filling column  || In Discharge reconciliation module  is :"+ActualText, test, test1);
				}
			    
			    waitForElement(driver, Close_Current_tab);
		  		click(driver,Close_Current_tab);
		  		
		  		
		  		//IGM Delete
		  		if (Delete_Popup.equalsIgnoreCase("Yes")) {
		  		
		  			moduleNavigate(driver, IGM_Generation_Module);
		  			
		  			 waitForElement(driver, SearchButton_Toolbar);
				  		click(driver,SearchButton_Toolbar);
				  		
				  		
				  		globalValueSearchWindow(driver, Condition, BL_No_Header_IGM, BLNo_Input, "", "", "", "");
				  		
				  		waitForElement(driver, remarks_Txtfld);
						sendKeys(driver, remarks_Txtfld, Remarks_Input);
		  			
						click(driver,BL_Filter_input_IGM_grid);
						sendKeys(driver, BL_Filter_input_IGM_grid, BLNo_Input);
						
//						waitForElement(driver, Select_BL_NumCheck_IGM);
//						click(driver, Select_BL_NumCheck_IGM);
						formatLocatorClick(driver, Select_BL_NumCheck_IGM, BLNo_Input);
						
						

				  		 waitForElement(driver, Delete_button_toolBar);
				   		click(driver,Delete_button_toolBar);
				        
				   	   waitForPopup(driver, popup_Message, IGM_Deleting_popup);
				 		String Popup_Text_Act3=getText(driver, popup_Message);
				 		
				 		if(Popup_Text_Act3.equals(IGM_Deleting_popup)) {
				 			System.out.println("Popup Matched  ||   Expected : "+IGM_Deleting_popup+"   ||   Actual   : "+Popup_Text_Act3);
				 			Extent_pass(driver, "Popup Matched  ||   Expected : "+IGM_Deleting_popup+"   ||   Actual   : "+Popup_Text_Act3, test, test1);
				 		}else {
				 			System.out.println("Popup Not Matched  ||   Expected : "+IGM_Deleting_popup+"   ||   Actual   : "+Popup_Text_Act3);
				 			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+IGM_Deleting_popup+"   ||   Actual   : "+Popup_Text_Act3, test, test1);
				 		}
				 		waitForElement(driver, popup_Message_Yes_Button);
			    		click(driver,popup_Message_Yes_Button);
				         
//			    		IGM_Delete_Confirmed
			    		
			    		waitForPopup(driver, popup_Message, IGM_Deleted_popup);
			 		String Popup_Text_act=getText(driver, popup_Message);
			 		
			 		if(Popup_Text_act.equals(IGM_Deleted_popup)) {
			 			System.out.println("Popup Matched  ||   Expected : "+IGM_Deleted_popup+"   ||   Actual   : "+Popup_Text_act);
			 			Extent_pass(driver, "Popup Matched  ||   Expected : "+IGM_Deleted_popup+"   ||   Actual   : "+Popup_Text_act, test, test1);
			 		}else {
			 			System.out.println("Popup Not Matched  ||   Expected : "+IGM_Deleted_popup+"   ||   Actual   : "+Popup_Text_act);
			 			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+IGM_Deleted_popup+"   ||   Actual   : "+Popup_Text_act, test, test1);
			 		}
			         
			 		waitForElement(driver, popup_Message_Ok_Button);
			    		click(driver,popup_Message_Ok_Button);
			    		
			    		
				  		}
			    
			    //Import_Documentation_Delete
		  		
		  		if (Delete_Popup.equalsIgnoreCase("Yes")) {
					
				
		  		 moduleNavigate(driver, Import_Documentation_Module);
		  		 
			    waitForElement(driver, SearchButton_Toolbar);
		  		click(driver,SearchButton_Toolbar);
		  		
		  		globalValueSearchWindow(driver, Condition, BL_No_Header_Import, BLNo_Input, "", "", "", "");
		        
				
		  		 waitForElement(driver, Delete_button_toolBar);
		   		click(driver,Delete_button_toolBar);
		        
		   	   waitForPopup(driver, popup_Message, Import_Documentation_Delete_popup);
		 		String Popup_Text_Act2=getText(driver, popup_Message);
		 		
		 		if(Popup_Text_Act2.equals(Import_Documentation_Delete_popup)) {
		 			System.out.println("Popup Matched  ||   Expected : "+Import_Documentation_Delete_popup+"   ||   Actual   : "+Popup_Text_Act2);
		 			Extent_pass(driver, "Popup Matched  ||   Expected : "+Import_Documentation_Delete_popup+"   ||   Actual   : "+Popup_Text_Act2, test, test1);
		 		}else {
		 			System.out.println("Popup Not Matched  ||   Expected : "+Import_Documentation_Delete_popup+"   ||   Actual   : "+Popup_Text_Act2);
		 			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Import_Documentation_Delete_popup+"   ||   Actual   : "+Popup_Text_Act2, test, test1);
		 		}
		 		waitForElement(driver, popup_Message_Yes_Button);
	    		click(driver,popup_Message_Yes_Button);
		         
//	    		Import_Documentation_Delete_Confirmed
	    		
	    		waitForPopup(driver, popup_Message, Import_Deleted_popup);
	 		String Popup_Text_Act4=getText(driver, popup_Message);
	 		
	 		if(Popup_Text_Act4.equals(Import_Deleted_popup)) {
	 			System.out.println("Popup Matched  ||   Expected : "+Import_Deleted_popup+"   ||   Actual   : "+Popup_Text_Act4);
	 			Extent_pass(driver, "Popup Matched  ||   Expected : "+Import_Deleted_popup+"   ||   Actual   : "+Popup_Text_Act4, test, test1);
	 		}else {
	 			System.out.println("Popup Not Matched  ||   Expected : "+Import_Deleted_popup+"   ||   Actual   : "+Popup_Text_Act4);
	 			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Import_Deleted_popup+"   ||   Actual   : "+Popup_Text_Act4, test, test1);
	 		}
	         
	 		waitForElement(driver, popup_Message_Ok_Button);
	    		click(driver,popup_Message_Ok_Button);
		  		}
		 		//IGM DELETE
			    
		  		
		  	  Step_End(22, "Verify that IGM FILLING marked as Yes in Discharge Reconiliation.", test, test1);
		  		
			    Extent_completed(testcase_Name, test, test1);
			    
			    
			  
				}
}
