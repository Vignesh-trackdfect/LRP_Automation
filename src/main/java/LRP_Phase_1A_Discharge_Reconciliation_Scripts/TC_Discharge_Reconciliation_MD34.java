package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD34 extends Keywords {
public void Discharge_Reconciliation_MD34(WebDriver driver ,ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		
		
		String testcase_Name="TC_Discharge_Reconciliation_MD34";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String BLNo_Input = Excel_data.get("Bl_Number");
		String BLNo_Header_Input = Excel_data.get("BLNo_Header_Input");
		String Condition = Excel_data.get("Condition");
		String Discharge_Code_Input = Excel_data.get("Discharge_Code_Input");
		String Discharge_Code_Header = Excel_data.get("Discharge_Code_Header");
		String Import_Documentation_Saved_popup = Excel_data.get("Import_Documentation_Saved_popup");
		String Import_Documentation_Delete_popup = Excel_data.get("Import_Documentation_Delete_popup");
		String Import_Deleted_popup = Excel_data.get("Import_Deleted_popup");
		String Import_Documentation_Update_popup = Excel_data.get("Import_Documentation_Update_popup");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Master_Valid1 = Excel_data.get("Imp_Doc_Master_Verify");
		String Delivery_Type_Input = Excel_data.get("Discharge_Recon_Delivery_Type_Grid");
		
		
		
		String Plan_Input=Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);	
		
		
		
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
		
		
		Step_Start(7, "Click on Import Documentation Navigation Button", test, test1);
		
		waitForElement(driver, Import_Button);
		click(driver, Import_Button);
		
		Step_End(7, "Click on Import Documentation Navigation Button", test, test1);
		
	
		Step_Start(8, "Click on BL Number search and select your BL that we wanted to chnage for DeliveryType", test, test1);
		
		waitForElement(driver, BlNoSearchButton);
		click(driver, BlNoSearchButton);
		twoColumnSearchWindow(driver,BLNo_Header_Input, Condition, BLNo_Input);
		
		Step_Start(8, "Click on BL Number search and select your BL that we wanted to chnage for DeliveryType", test, test1);
		
        Step_Start(9, "Go to BL/HBL summary Tab", test, test1);
		 Step_Start(9.1, "If Import Documentation is already saved Click on Edit Button", test, test1);
        
        String valid = getText(driver, BL_status_IMP_DOC);
         if(valid.equals(Master_Valid1)){
         waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
        }
       
		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver, BL_HBL_Summary_Tab);
		
		Step_End(9, "Go to BL/HBL summary Tab", test, test1);
		Step_End(9.1, "If Import Documentation is already saved Click on Edit Button", test, test1);
		
		 Step_Start(10, "go to Discharge Status Select that given under test Data", test, test1);
		waitForElement(driver, Discharge_status_search_button);
		click(driver, Discharge_status_search_button);
		twoColumnSearchWindow(driver,Discharge_Code_Header, Condition, Discharge_Code_Input);
		 Step_End(10, "go to Discharge Status Select that given under test Data", test, test1);
		
		 Step_Start(11, " save the Import Documentation system will says \" Import Documentation saved  or Import Documentation updated(this is for already saved BL)\" message then click on Ok button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
         click(driver, SaveButton_ToolBar);
         
         waitForElement(driver, popup_Message);
  		String Popup_Text_Act=getText(driver, popup_Message);
  		if (Popup_Text_Act.equals(Import_Documentation_Saved_popup)) {
  		    System.out.println("Popup Matched  ||   Expected : " + Import_Documentation_Saved_popup + "   ||   Actual   : " + Popup_Text_Act);
  		    Extent_pass(driver, "Popup Matched  ||   Expected : " + Import_Documentation_Saved_popup + "   ||   Actual   : " + Popup_Text_Act, test, test1);
  		} else if (Popup_Text_Act.equals(Import_Documentation_Update_popup)) {
  		    System.out.println("Popup Matched  ||   Expected : " + Import_Documentation_Update_popup + "   ||   Actual   : " + Popup_Text_Act);
  		    Extent_pass(driver, "Popup Matched  ||   Expected : " + Import_Documentation_Update_popup + "   ||   Actual   : " + Popup_Text_Act, test, test1);
  		} else {
  		    System.out.println("Popup Not Matched  ||   Expected : " + Import_Documentation_Saved_popup + "   ||   Actual   : " + Popup_Text_Act);
  		    Extent_fail(driver, "Popup Not Matched  ||   Expected : " + Import_Documentation_Saved_popup + "   ||   Actual   : " + Popup_Text_Act, test, test1);
  		}
		
	
 		waitForElement(driver, popup_Message_Ok_Button);
 		click(driver,popup_Message_Ok_Button);
 		
         
         Step_End(11, " save the Import Documentation system will says \" Import Documentation saved  or Import Documentation updated(this is for already saved BL)\" message then click on Ok button", test, test1);


         Step_Start(12, "Move to Discharge Reconciliation module that is already opened", test, test1);
         
         waitForElement(driver, Switch_Discharge_Recon);
  		click(driver,Switch_Discharge_Recon);
  		
  		Step_End(12, "Move to Discharge Reconciliation module that is already opened", test, test1);

  		Step_Start(13, "Click on Refresh Button,", test, test1);
  		
  		 waitForElement(driver, Refresh_Btn_Dis);
  		  click(driver,Refresh_Btn_Dis);
  		
  		
  		Step_End(13, "Click on Refresh Button,", test, test1);
  		
  		Step_Start(14, "Filter the BL NO Which is recently saved the import Documentation", test, test1);
  		
		
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, BLNo_Input);
		
		waitForElement(driver, Bl_Number_input_re_con_row_click);
		click(driver, Bl_Number_input_re_con_row_click);
		
  		Step_End(14, "Filter the BL NO Which is recently saved the import Documentation", test, test1);

  		Step_Start(15, "Go to Delivery Type Column", test, test1);
  		
  		waitForElement(driver, Switch_Import_Document);
  		click(driver,Switch_Import_Document);
  		
  		waitForElement(driver, Import_Discharge_Value);
  		String Import_Actual_Discharge_text = getAttribute(driver, Import_Discharge_Value,"value");
  		
  		Step_End(15, "Go to Delivery Type Column", test, test1);
  		
  		
  		
  		Step_Start(16, "Verify that Import Documentation saved and column value marked as Yes in Discharge Reconiliation.", test, test1);
  		
  		 waitForElement(driver, Switch_Discharge_Recon);
   		click(driver,Switch_Discharge_Recon);
   		
   		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Delivery_Type_Input);
  		       String Actual_text = getText(driver, Discharge_Value_select);
                
                if (Actual_text.equals(Import_Actual_Discharge_text)) {
					
                	System.out.println(" Expected column value: "+Import_Actual_Discharge_text+" ||Actual Value listed in Discharge recon  is : "+Actual_text);
         			Extent_pass(driver, "Expected column value: "+Import_Actual_Discharge_text+" ||Actual Value listed in Discharge recon  is   : "+Actual_text, test, test1);
         		}else {
         			System.out.println("UnExpected column value : "+Import_Actual_Discharge_text+"||Actual Value listed in Discharge recon  is   : "+Actual_text);
         			Extent_fail(driver, "UnExpected column value: "+Import_Actual_Discharge_text+"||Actual Value listed in Discharge recon  is   : "+Actual_text, test, test1);
         		}
				
                waitForElement(driver, Switch_Import_Document);
          		click(driver,Switch_Import_Document);
                
          		 waitForElement(driver, Delete_button_toolBar);
           		click(driver,Delete_button_toolBar);
          		
          	//Import_Documentation_Delete	
          	   waitForPopup(driver, popup_Message, Import_Documentation_Delete_popup);
        		String Popup_Text_Act1=getText(driver, popup_Message);
        		
        		if(Popup_Text_Act1.equals(Import_Documentation_Delete_popup)) {
        			System.out.println("Popup Matched  || Expected : "+Import_Documentation_Delete_popup+"   ||   Actual   : "+Popup_Text_Act1);
        			Extent_pass(driver, "Popup Matched  || Expected : "+Import_Documentation_Delete_popup+"   ||   Actual   : "+Popup_Text_Act1, test, test1);
        		}else {
        			System.out.println("Popup Not Matched  || Expected : "+Import_Documentation_Delete_popup+"   ||   Actual   : "+Popup_Text_Act1);
        			Extent_fail(driver, "Popup Not Matched  || Expected : "+Import_Documentation_Delete_popup+"   ||   Actual   : "+Popup_Text_Act1, test, test1);
        		}
                
        		waitForElement(driver, popup_Message_Yes_Button);
           		click(driver,popup_Message_Yes_Button);
        		
        	//	Import_Documentation_Delete_Confirmed
           		
           		waitForPopup(driver, popup_Message, Import_Deleted_popup);
        		String Popup_Text_Act2=getText(driver, popup_Message);
        		
        		if(Popup_Text_Act2.equals(Import_Deleted_popup)) {
        			System.out.println("Popup Matched  ||   Expected : "+Import_Deleted_popup+"   ||   Actual   : "+Popup_Text_Act2);
        			Extent_pass(driver, "Popup Matched  ||   Expected : "+Import_Deleted_popup+"   ||   Actual   : "+Popup_Text_Act2, test, test1);
        		}else {
        			System.out.println("Popup Not Matched  ||   Expected : "+Import_Deleted_popup+"   ||   Actual   : "+Popup_Text_Act2);
        			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Import_Deleted_popup+"   ||   Actual   : "+Popup_Text_Act2, test, test1);
        		}
                
        		waitForElement(driver, popup_Message_Ok_Button);
           		click(driver,popup_Message_Ok_Button);
           		
           		
           		
           Step_End(16, "Verify that Import Documentation saved and column value marked as Yes in Discharge Reconiliation.", test, test1);

           Extent_completed(testcase_Name, test, test1);
}

}
