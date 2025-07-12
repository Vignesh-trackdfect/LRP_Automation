package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD13 extends Keywords {
	

	public void Discharge_Reconciliation_MD13(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		
			String test_Case_Name = "TC_Discharge_Reconciliation_MD13";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String imp_doc_Module = Excel_data.get("imp_doc_Module");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Plan_Options= Excel_data.get("Plan_Type");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Bl_Number = Excel_data.get("BL_Number");
		String pop_msg_IDT = Excel_data.get("pop_msg_IDT");
		String confim_pop_msg_IDT = Excel_data.get("confim_pop_msg_IDT");
		String Agency_Config_Module = Excel_data.get("Agency_Config_Module");
		String agencyColumn_Header= Excel_data.get("agencyColumn_Header");
		String Agency_condition = Excel_data.get("Agency_condition");
		String attributeColumn_Header = Excel_data.get("attributeColumn_Header");
		String Agency_value = Excel_data.get("Agency_value");
		String Discription_Value = Excel_data.get("Discription_Value");
		String atribute_value = Excel_data.get("atribute_value");
		String Discharge_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String DC_Column_Header = Excel_data.get("DC_Column_Header");
		String BL_twocoloumn_impdoc = Excel_data.get("BL_twocoloumn_impdoc");
		
		 Extent_Start(test_Case_Name, test, test1);
		   navigateUrl(driver, url);
		   LRP_Login(driver, Username, Password);
		   verifyMainMenu(driver);
				Step_Start(1, "Open Import Documentation transfer module", test, test1);
				SwitchProfile(driver, AgencyUser);
				
				
				moduleNavigate(driver, imp_doc_Module);
				
				Step_End(1, "Open Import Documentation transfer module", test, test1);
				Step_Start(2, "Enter service, vessel, voyage, bound, pod, terminal", test, test1);
				newButton(driver);
				
				waitForElement(driver,Vessel_input_im_doc_tranfer);
				sendKeys(driver, Vessel_input_im_doc_tranfer, Vessel_Input);
				
				waitForElement(driver, Service_filter_input_im_doc_tranfer);
				sendKeys(driver, Service_filter_input_im_doc_tranfer, Service_Input);
			
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
				
				if (!Port_Input.equals("")) {
					
					waitForElement(driver, grid_scroll);
					scrollUsingElement(driver, grid_scroll);
					horizontalscroll(driver, grid_scroll, 300);
					click1(driver, grid_portcodeIMP_DOC);
					sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
				}
				
				waitForElement(driver, grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC,Terminal_Input);
		 
				waitForElement(driver, grid_selectbtn_IMP_DOC);
				click(driver, grid_selectbtn_IMP_DOC);
				Step_End(2, "Enter service, vessel, voyage, bound, pod, terminal", test, test1);
				
				Step_Start(3, "Click the Show BL's button", test, test1);
				waitForElement(driver, Show_bls_im_doc_tranfer);
				click(driver, Show_bls_im_doc_tranfer);
				Step_End(3, "Click the Show BL's button", test, test1);
				Step_Start(4, "select the BL available in TestData if the BL is not Available Skip steps 5,6,7,8,", test, test1);
				String BL_numbers = String.format(Filter_bl_im_doc_tranfer, BL_Number);
			
				if (isdisplayed(driver,BL_Number )) {
					
				
				waitForElement(driver, BL_Number);
				
				doubleClick(driver, BL_numbers);
				
				Step_Start(5, "select the Delete Import Docu check box ", test, test1);
				waitForElement(driver, delete_check_box_IDT);
				click(driver, delete_check_box_IDT);
				Step_End(5, "select the Delete Import Docu check box ", test, test1);
				
				Step_Start(6, "Click the Delete import Doc button", test, test1);
				waitForElement(driver, Delete_btn_IDT);
				click(driver, Delete_btn_IDT);
				Step_End(6, "Click the Delete import Doc button", test, test1);
				
				Step_Start(7, "System shows validation as'Do you want to delete the selected BL(s)? clik Yes", test, test1);
				waitForPopup(driver, popup_Message, pop_msg_IDT);
			String Actual_popup_1 = getText(driver, popup_Message) ;
			if (pop_msg_IDT.equals(Actual_popup_1)) {
				System.out.println("Pass:The Exccepted PopUp is :"+pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_1+"Both are Same");
				
			Extent_pass(driver, "Pass:The Exccepted PopUp is :"+pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_1+"Both are Same", test, test1);
		  waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);	    
			} else {
				System.out.println("Fail:The Exccepted PopUp is :"+pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_1+"Both are Not Same");
				Extent_pass(driver, "Fail:The Exccepted PopUp is :"+pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_1+"Both are Not Same", test, test1);
		 
			}
				Step_End(7, "System shows validation as'Do you want to delete the selected BL(s)? clik Yes", test, test1);
				
			 Step_Start(8, "system shows message as Import Documentation has deleted", test, test1);
			 
				waitForPopup(driver, popup_Message, confim_pop_msg_IDT);
				String Actual_popup_2 = getText(driver, popup_Message) ;
				
				if (confim_pop_msg_IDT.equals(Actual_popup_2)) {
					System.out.println("Pass:The Exccepted PopUp is : "+confim_pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_2+"Both are Same");
					
				Extent_pass(driver, "Pass:The Exccepted PopUp is :"+confim_pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_2+"Both are Same", test, test1);
			  waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);	    
				} else {
					System.out.println("Fail:The Exccepted PopUp is :"+confim_pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_2+"Both are Not Same");
					Extent_pass(driver, "Fail:The Exccepted PopUp is :"+confim_pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_2+"Both are Not Same", test, test1);
		 
				}
			
				}
				Step_End(8, "system shows message as Import Documentation has deleted", test, test1);
				
				
				Step_Start(9,"Open Agency Configuration module,", test, test1);
				Step_Start(10,"Make sure that below configuration is marked as N if enabled or Do not add ISB-Import Documentation Allow to save import documentation for Work order service BL.",test, test1);
			    setAgencyConfiguration(driver, Agency_Config_Module, agencyColumn_Header, attributeColumn_Header, Agency_condition, AgencyUser, atribute_value, Discription_Value, Agency_value);
			    Step_End(9,"Open Agency Configuration module,", test, test1);
			    Step_End(10,"Make sure that below configuration is marked as N if enabled ISB-Import Documentation Allow to save import documentation for Work order service BL.",test, test1);
	            

			    Step_Start(11, "Open Discharge Reconciliation Module", test, test1);
				moduleNavigate(driver, Discharge_Recon_Module);
				Step_End(11, "Open Discharge Reconciliation Module", test, test1);

				Step_Start(12, "Click on new button if new button not available go below,", test, test1);
				newButton(driver);
				Step_End(12, "Click on new button if new button not available go below,", test, test1);

				Step_Start(13, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);
				waitForElement(driver, DisRecServiceInput_DRL);
				sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
				if (!Port_Input.equals("")) {
					waitForElement(driver, Scroll_Discharge_service);
					scrollUsingElement(driver, Scroll_Discharge_service);
					horizontalscroll(driver, Scroll_Discharge_service, 300);
					click1(driver, grid_portcodeIMP_DOC);
					sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
				}
				waitForElement(driver, grid_selectbtn_IMP_DOC);
				click(driver, grid_selectbtn_IMP_DOC);
				
				Step_End(13, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);

				Step_Start(14, "Select the Plan as ALL/Local/Transhipment.,", test, test1);
				waitForElement(driver, Plan_Option);
				click(driver, Plan_Option);

				formatLocatorClick(driver, Plan_Option_Select, Plan_Options);
				Step_End(14, " Select the Plan as ALL/Local/Transhipment.,", test, test1);
				
				Step_Start(15, " Click on Download BL Button.", test, test1);
				waitForElement(driver, DownloadBLs);
				click(driver, DownloadBLs);
				Step_End(15, " Click on Download BL Button.", test, test1);
				
				Step_Start(16, " Verify that service BL is  not loaded in Discharge recon module.", test, test1);
				reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click,DC_Column_Header);
				String GivenBLlisted = getText(driver, Text_Get_Yes_No);
				if (!Bl_Number.equals(GivenBLlisted)) {
				System.out.println("Pass || Expected result: Given Bl should not listed as same in impdoc transfer module " +Bl_Number + "Actual result:Given Bl is not listed as same in impdoc transfer module" + GivenBLlisted);
				Extent_pass(driver,
						"Pass || Expected result: Expected result: Given Bl should not listed as same in impdoc transfer module " +Bl_Number + " Actual result:Given Bl is not listed as same in impdoc transfer module" + GivenBLlisted,
						test, test1);

					
				} else {
					System.out.println("Fail || Expected result: Given Bl should not listed as same in impdoc transfer module" +Bl_Number + "Actual result:Given Bl is  listed as same in impdoc transfer module" + GivenBLlisted);
					Extent_fail(driver,
							"Fail || Expected result: Expected result: Given Bl should not listed as same in impdoc transfer module" +Bl_Number + "Actual result:Given Bl is listed as same in impdoc transfer module" + GivenBLlisted,
							test, test1);
					
					

				}
				
				Step_End(16, "Verify that service BL is not loaded in Discharge recon module. ", test, test1);
				
				Step_Start(17, " Open Import Documentation Load the BL and Verify BL NO should not be loaded.", test, test1);
				
				
				waitForElement(driver, Import_Button);
				click(driver, Import_Button);
				
				
				waitForElement(driver, BL_SearchButton_IMP_DOC);
				click(driver, BL_SearchButton_IMP_DOC);
				
				twoColumnSearchWindow1(driver,BL_twocoloumn_impdoc , Agency_condition,Bl_Number );
				
				waitForDisplay(driver, inside_gird_first_row);
				if(!isdisplayed(driver, inside_gird_first_row)) {
					Extent_pass_New(driver, "Matched || Expected Result is :BL Number should not shown in the gird || Actual Result is :BL Number should not shown in the gird", test, test1);
					System.out.println("Matched || Expected Result is : BL Number should not shown in the gird || Actual Result is : BL Number should not shown in the gird");
				}else {
					System.out.println("Not Matched || Expected Result is :BL Number should not shown in the gird  || Actual Result is : BL Number   shown in the gird");
					Extent_fail(driver,"Not Matched || Expected Result is : BL Number should not shown in the gird  || Actual Result is : BL Number   shown in the gird", test, test1);
				
				}
				

				

		 
				Step_End(17, "17. Open Import Documentation Load the BL and Verify BL NO should not be loaded.", test, test1);
				Extent_completed(test_Case_Name, test, test1);
	
	}
}



