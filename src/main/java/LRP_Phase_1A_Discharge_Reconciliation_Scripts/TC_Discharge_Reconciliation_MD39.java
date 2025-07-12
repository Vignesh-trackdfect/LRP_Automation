package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD39 extends Keywords{

	
	public void Discharge_Reconciliation_MD39(WebDriver driver ,ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		
		String testcase_Name="TC_Discharge_Reconciliation_MD39";
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
		String Grid_Select_Hblnumber = Excel_data.get("Grid_Select_Hblnumber");
		String BLNo_Input = Excel_data.get("Bl_Number");
		String Import_Documentation_Saved_popup = Excel_data.get("Import_Documentation_Saved_popup");

		String Import_Documentation_Delete_popup = Excel_data.get("Import_Documentation_Delete_popup");		
		String Import_Deleted_popup = Excel_data.get("Import_Deleted_popup");
		String Delete_Popup = Excel_data.get("Delete_Popup");
		String BL_No_Header_Import = Excel_data.get("BL_No_Header_Import");
		String Import_Documentation_Module = Excel_data.get("Import_Documentation_Module");

		String House_BL_Number = Excel_data.get("House_BL_Number");
		String House_BL_Containers_Select=Excel_data.get("House_BL_Containers_Select");
		String House_BL_Select_All_Container=Excel_data.get("House_BL_Select_All_Container");
		String HBL_Table_Headers=Excel_data.get("HBL_Table_Headers");
		String HBL_Table_Compare_Header=Excel_data.get("HBL_Table_Compare_Header");
		
		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver,url);
		
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
		

		Step_Start(6.1, "Filter your BL NO and HBL Number column make sure that it is Empty as of now.", test, test1);
		
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, BLNo_Input);
				
		waitForElement(driver, Bl_Number_input_re_con_row_click);
		click(driver, Bl_Number_input_re_con_row_click);
		
        reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Grid_Select_Hblnumber);
		
		String valid1 = getText(driver, Text_Get_Yes_No);
		Extent_pass(driver, "HBL Number column make sure that it is Empty Text is :"+valid1, test, test1);
	    System.out.println(valid1);
		
		
		Step_End(6.1, "Filter your BL NO and HBL Number column make sure that it is Empty as of now.", test, test1);
		
		 Step_Start(7, " Click on Import Documentation Navigation Button", test, test1);
		    
		    waitForElement(driver,importDocumentation_Button_DRC);
		    click(driver, importDocumentation_Button_DRC);
		   // 
		    
		    Step_End(7, " Click on Import Documentation Navigation Button", test, test1);
		    
	        Step_Start(8, " Click on BL Number search and select your BL NO", test, test1);
	        waitForElement(driver,cancel_Common_btn);
			click(driver, cancel_Common_btn);
			
	        waitForElement(driver,SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, Condition, BL_No_Header_Import, BLNo_Input, "", "", "", "");
			
		    Step_End(8, "Click on BL Number search and select your BL NO", test, test1);
		    
		    Step_Start(9, "Click on House Button.", test, test1);
		    Step_Start(10, "Go to HBL updation tab.", test, test1);
		    
			waitForElement(driver, House_Button_Imp_DOC);
			click(driver, House_Button_Imp_DOC);
			
			Step_End(9, "Click on House Button.", test, test1);
			 Step_End(10, "Go to HBL updation tab.", test, test1);
			

			 Step_Start(11, "Enter the HBL NO as per the Sequence A,B,C,D as per the Container Count.", test, test1);
			 Step_Start(12, "Select the HBLA and select th COntainers1 Allocate the Container1 by clicking on (+) Button.", test, test1);
			 Step_Start(13, "Select the HBLB and select th COntainers2 Allocate the Container2 by clicking on (+) Button.", test, test1);
			 Step_Start(14, "Select the HBLC and select th COntainers3 Allocate the Container3 by clicking on (+) Button.", test, test1);
			
			Map<String,List<String>> HBL_Updated_Exp=new HashMap<String, List<String>>();//new
			
			List<Map<String, String>> HBL_Tabledatas = getTableData(driver, HBL_Commodity_Table_Header, HBL_Commodity_Table_Row);
			List<String> HBL_columnheaders = splitAndExpand(HBL_Table_Headers);
			
			String headerName="HouseBL No.";
			scrollBottom(driver);
			List<String> HouseBL_NewNumbers=splitAndExpand(House_BL_Number);
			
			List<String> ContainerValues=splitAndExpand(House_BL_Containers_Select,"/");
			Map<String,List<String>> HouseBL_Container=new HashMap<String,List<String>>();
			for(int k=0;k<HouseBL_NewNumbers.size();k++) {
				String HouseBL=HouseBL_NewNumbers.get(k);
				List<String> HouseBLContainer=splitAndExpand(ContainerValues.get(k));
				HouseBL_Container.put(HouseBL, HouseBLContainer);
			}
			
			if(HouseBL_NewNumbers.size()<2) {
				List<String> ContainerLists=splitAndExpand2(House_BL_Containers_Select);
				waitForElement(driver, House_BL_Field);
				sendKeys(driver, House_BL_Field, House_BL_Number);
				click(driver, Add_House_BL_Button);
				
				waitForElement(driver, HBL_No_DropDown1);
				click(driver, HBL_No_DropDown1);
				String DropDown_Select1 = String.format(House_No_Select1,House_BL_Number);
				waitForElement(driver, DropDown_Select1);
				click(driver, DropDown_Select1);
				Map<String, List<String>> HBL_ContainersID_List=getColumnValuesByHeaders(HBL_Tabledatas,HBL_columnheaders);
				List<String> HBL_ContainerID_Exp=HBL_ContainersID_List.get(HBL_Table_Compare_Header);
				if(House_BL_Select_All_Container.equals("Yes")) {
					checkBox(driver, HBL_Check_Box, "Yes");		
					HBL_Updated_Exp.put(House_BL_Number, HBL_ContainerID_Exp);
				}else {
					selectSpecificContainers(driver,ContainerLists);
					HBL_Updated_Exp.put(House_BL_Number, ContainerLists);
				}
				click(driver, Package_Add_Button);
				waitForElement(driver, HBL_Table_Row);
				
			}else {
				for(int i=0;i<HouseBL_NewNumbers.size();i++) {
					String New_BL_Number=HouseBL_NewNumbers.get(i);
					System.out.println("New_BL_Number : "+New_BL_Number);
					waitForElement(driver, House_BL_Field);
					sendKeys(driver, House_BL_Field, New_BL_Number);
					click(driver, Add_House_BL_Button);
					waitForElement(driver, HBL_No_DropDown1);
					click(driver, HBL_No_DropDown1);
					String DropDown_Select1 = String.format(House_No_Select1,New_BL_Number);
					waitForElement(driver, DropDown_Select1);
					click(driver, DropDown_Select1);
					List<String> BL_Containers=HouseBL_Container.get(New_BL_Number);
					selectSpecificContainers(driver,BL_Containers);
					click(driver, Package_Add_Button);
					waitForElement(driver, HBL_Table_Row);
					HBL_Updated_Exp.put(New_BL_Number, BL_Containers);

					List<Map<String, String>> HBL_Tabledatas_Result=getTableData(driver, HBL_Table_Header, HBL_Table_Row);
					Map<String,List<String>> headersValues=getColumnValuesByHeaders1(HBL_Tabledatas_Result,headerName,New_BL_Number,HBL_columnheaders);
					List<String> Act_ContainerNo=headersValues.get(HBL_Table_Compare_Header);
					
					System.out.println("Act_ContainerNo  : " + Act_ContainerNo);
					System.out.println("ContainerLists  : " + BL_Containers);
					
				}
			}
			

			 Step_End(11, "Enter the HBL NO as per the Sequence A,B,C,D as per the Container Count.", test, test1);
			 Step_End(12, "Select the HBLA and select th COntainers1 Allocate the Container1 by clicking on (+) Button.", test, test1);
			 Step_End(13, "Select the HBLB and select th COntainers2 Allocate the Container2 by clicking on (+) Button.", test, test1);
			 Step_End(14, "Select the HBLC and select th COntainers3 Allocate the Container3 by clicking on (+) Button.", test, test1);
			
			
			
				waitForElement(driver, Split_Charges_Tab);
				click(driver, Split_Charges_Tab);

				waitForElement(driver, Select_All_CheckBox_SplitCharges_ID);
				click(driver, Select_All_CheckBox_SplitCharges_ID);
				waitForElement(driver, SplitCharges_Amount_Add_Button);
				click(driver, SplitCharges_Amount_Add_Button);
				
				
				waitForDisplay(driver, Split_Allocate_gird);
				if(isdisplayed(driver, Split_Allocate_gird)) {
					
					Extent_pass_New(driver, "Matched || Expected Result is :The charges should allocated And added in the gird || Actual Result is :The charges is allocated And added in the gird", test, test1);
					System.out.println("Matched || Expected Result is : The charges should allocated And added in the gird|| Actual Result is : The charges is allocated And added in the gird");
				}else {
					System.out.println("Not Matched || Expected Result is :The charges should allocated And added in the gird || Actual Result is : The charges is allocated And not added in the gird");
					Extent_fail(driver,"Not Matched || Expected Result is : The charges should allocated And added in the gird || Actual Result is : The charges is allocated And not added in the gird", test, test1);
				}
					
	
			Step_Start(15, "Click on save button system shows Import Documentaation saved, and click ok button.", test, test1);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
//			
			 
			waitForDisplay(driver, popup_Message);
			while(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
				waitForDisplay(driver, popup_Message_Yes_Button);
			}
			
				waitForPopup(driver, popup_Message, Import_Documentation_Saved_popup);
		   		String Popup_Text_Act=getText(driver, popup_Message);
		 		if(Popup_Text_Act.equals(Import_Documentation_Saved_popup)) {
		 			System.out.println("Popup Matched  ||   Expected : "+Import_Documentation_Saved_popup+"   ||   Actual   : "+Popup_Text_Act);
		 			Extent_pass(driver, "Popup Matched  ||   Expected : "+Import_Documentation_Saved_popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		 		}else {
		 			System.out.println("Popup Not Matched  ||   Expected : "+Import_Documentation_Saved_popup+"   ||   Actual   : "+Popup_Text_Act);
		 			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Import_Documentation_Saved_popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		 		}
		 		
		 		waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
		 	
			 Step_End(15, "Click on save button system shows Import Documentaation saved, and click ok button.", test, test1);  
			    
			 Step_Start(16, " Capture all the HBL Numbers", test, test1);
			    
			 
			 waitForElement(driver, HBL_No_DropDown);
				click(driver, HBL_No_DropDown);
			 
//			    waitForElement(driver,Import_BL_No_Dropdown);
//			   String HBL_No_List = getText(driver, Import_BL_No_Dropdown);
//			  
			   ArrayList<String> HBL_List = new ArrayList<String>();
			   System.out.println(HBL_List);
			 
			   waitForElement(driver,Import_BL_No_Dropdown);
			   	List<WebElement> HBL_list = listOfElements(driver, Import_BL_No_Dropdown);
			   for (int i = 1; i < HBL_list.size(); i++) {
				   String HBL_No = HBL_list.get(i).getText().trim();
				     HBL_List.add(HBL_No);
				   //  System.out.println(blue);
			}
			   System.out.println(HBL_List);
			    
			   waitForElement(driver, Close_Current_tab);
		  		click(driver,Close_Current_tab);
			   
			    Step_End(16, " Capture all the HBL Numbers", test, test1);
			    
			    Step_Start(17, "Move to Discharge Reconciliation module that is already opened", test, test1);
		         
//		         waitForElement(driver, Switch_Discharge_Recon);
//		  		click(driver,Switch_Discharge_Recon);
				 
//				 moduleNavigate(driver, Dis_Recon_Module);
		  		Step_End(17, "Move to Discharge Reconciliation module that is already opened", test, test1);
		  		
		  		Step_Start(18, "Click on Refresh Button,", test, test1);
		  		
		 		 waitForElement(driver, Refresh_Btn_Dis);
		 		  click(driver,Refresh_Btn_Dis);
		 		
		 		Step_End(18, "Click on Refresh Button,", test, test1);
		 		
		 		Step_Start(19, "Filter the BL NO Which is recently saved the import Documentation", test, test1);
		  		
			waitForElement(driver, Filter_Button_Re_Con);
			click(driver, Filter_Button_Re_Con);
			waitForElement(driver, Bl_Number_input_re_con);
			sendKeys(driver, Bl_Number_input_re_con, BLNo_Input);
			    
			Step_End(19, "Filter the BL NO Which is recently saved the import Documentation", test, test1);
			
			
			Step_Start(20, "Go to HBL number Filed", test, test1);
	  		 
        reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Grid_Select_Hblnumber);
        ArrayList<String> HBL_List1 = new ArrayList<String>();
        System.out.println(HBL_List1);
        
			 waitForElement(driver,Dis_Recon_Grid_Row_Select);
				List<WebElement> HBL_list1 = listOfElements(driver, Dis_Recon_Grid_Row_Select);
			 
			   for (int i = 0; i < HBL_list1.size(); i++) {
				   String HBL_No = HBL_list1.get(i).getText().trim();
				     HBL_List1.add(HBL_No);
				   //  System.out.println(blue);
			}
			   System.out.println(HBL_List1);
			    
			  
			  
			 //  System.out.println(HBL_List);
			 
			   String HBLNumbers = getText(driver, Dis_Recon_Grid_Row_Select);
			   System.out.println(HBLNumbers);
			   

//				 
	 		Step_End(20, "Go to HBL number Filed", test, test1);
			
	 		Step_Start(21, "Verify that HBL number listed in Discharge Reconiliation", test, test1);
	  		
	 		
	 		 if (HBL_List1.equals(HBL_List)){
					
		        	System.out.println(" Expected ||HBL No in Import Documentation  Module is"+HBL_List+"   ||Actual Value present in Discharge Reconciliation  is : "+HBL_List1);
		 			Extent_pass(driver, "Expected ||HBL No in Import Documentation  Module is"+HBL_List+"   ||Actual Value present in Discharge Reconciliation  is : "+HBL_List1, test, test1);
		 		}else {
		 			System.out.println("UnExpected ||HBL No in Import Documentation  Module is"+HBL_List+"   ||Actual Value present in Discharge Reconciliation  is : "+HBL_List1);
		 			Extent_fail(driver, "UnExpected ||HBL No in Import Documentation  Module is"+HBL_List+"   ||Actual Value present in Discharge Reconciliation  is : "+HBL_List1, test, test1);
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
	 		 
		 		Step_End(21, "Verify that HBL number listed in Discharge Reconiliation", test, test1);
				

		 		 Extent_completed(testcase_Name, test, test1);
}
}
