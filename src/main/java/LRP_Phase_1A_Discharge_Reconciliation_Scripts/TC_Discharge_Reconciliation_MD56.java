package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD56 extends Keywords  {
	public void Discharge_Reconciliation_MD56(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) throws AWTException {

		String testcase_Name = "TC_Discharge_Reconciliation_MD56";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String imp_doc_Module = Excel_data.get("imp_doc_Module");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Terminal_Input = Excel_data.get("Terminal_Input");
		String Plan_Type = Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Type);
		String Bl_Number = Excel_data.get("Bl_Number");
		String pop_msg_IDT = Excel_data.get("pop_msg_IDT");
		String confim_pop_msg_IDT = Excel_data.get("confim_pop_msg_IDT");
		String Attribute_value_1 = Excel_data.get("Accounting__Attribute_Value");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Agency_Code_Header = Excel_data.get("Accounting_Agency_Code_Header");
		String AccountingConfiguration = Excel_data.get("Acconting_Config_Module");
		String accounting_Configuration_Reset = Excel_data.get("accounting_Configuration_Reset");
		Map<String, String> newlyadded = new HashMap<>(); 
		String condition = Excel_data.get("condition");
		String BL_Number_Header = Excel_data.get("Imdoc_BLnumber_Header");
		
		String Saved_popup = Excel_data.get("Saved_popup");
		
		Extent_Start(testcase_Name, test, test1);
		
		
		navigateUrl(driver,url);
		

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		Step_Start(1, "Open Import Documentation transfer module", test, test1);
		SwitchProfile(driver, AgencyUser);
		
		
		moduleNavigate(driver, imp_doc_Module);
		
		Step_End(1, "Open Import Documentation transfer module", test, test1);
		Step_Start(2, "Enter service, vessel, voyage, bound, pod, terminal", test, test1);
		newButton(driver);
		
		waitForElement(driver, Vessel_input_im_doc_tranfer);
		sendKeys(driver, Vessel_input_im_doc_tranfer, Vessel_Input);
		
		waitForElement(driver, Service_filter_input_im_doc_tranfer);
		sendKeys(driver, Service_filter_input_im_doc_tranfer, Service_Input);
	
		waitForElement(driver, grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_bound_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
		
		if (!Port_Input.equals("")) {
			
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
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
		String BL_numbers = String.format(Filter_bl_im_doc_tranfer, Bl_Number);
		if (isdisplayed(driver, BL_numbers)) {
			
		
		waitForElement(driver, BL_numbers);
		
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
		System.out.println("Pass:The Exccepted PopUp is :"+pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_1);
		
	Extent_pass(driver, "Pass:The Exccepted PopUp is :"+pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_1, test, test1);
  waitForElement(driver, popup_Message_Yes_Button);
	click(driver, popup_Message_Yes_Button);	    
	} else {
		System.out.println("Fail:The Exccepted PopUp is :"+pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_1);
		Extent_pass(driver, "Fail:The Exccepted PopUp is :"+pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_1, test, test1);

	}
		
	Step_End(7, "System shows validation as'Do you want to delete the selected BL(s)? clik Yes", test, test1);
		
	Step_Start(8, "system shows message as Import Documentation has deleted", test, test1);
		waitForPopup(driver, popup_Message, confim_pop_msg_IDT);
		String Actual_popup_2 = getText(driver, popup_Message) ;
		
		if (confim_pop_msg_IDT.equals(Actual_popup_2)) {
			System.out.println("Pass:The Exccepted PopUp is : "+confim_pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_2);
			
		Extent_pass(driver, "Pass:The Exccepted PopUp is :"+confim_pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_2, test, test1);
	  waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);	    
		} else {
			System.out.println("Fail:The Exccepted PopUp is :"+confim_pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_2);
			Extent_pass(driver, "Fail:The Exccepted PopUp is :"+confim_pop_msg_IDT+"|| The Actual popUP is"+Actual_popup_2, test, test1);

		}
	
		}
		Step_End(8, "system shows message as Import Documentation has deleted", test, test1);
		Step_End(4, "select the BL available in TestData if the BL is not Available Skip steps 5,6,7,8,", test, test1);
		
		Step_Start(9, " Open Accounting Configuration module", test, test1);
		Step_Start(10, "Make sure that below configuration is marked as add,\r\n"
				+ "IDLF-Discharge Reconciliation – Block BLs based on carriage contract as value as MB &&EL", test, test1);
		Step_Start(11, "system shows removed.", test, test1);
		Step_Start(2, "Open agency configuration screen", test, test1);
		moduleNavigate(driver, AccountingConfiguration);
		Step_End(2, "Open agency configuration screen", test, test1);
		newButton(driver);
		Step_Start(3, "Select the agency ", test, test1);
		waitForElement(driver, agencySearch_Button);
		click(driver, agencySearch_Button);
		twoColumnSearchWindow(driver, Agency_Code_Header, condition, AgencyUser);
		waitForElement(driver, AC_Show_Button);
		click(driver, AC_Show_Button);
		Step_End(3, "Select the agency ", test, test1);
 
		waitForElement(driver, acc_config_filter1);
		click(driver, acc_config_filter1);
		waitForElement(driver, condition_filter1);
		click(driver, condition_filter1);
		waitForElement(driver, Attributr_search);
		sendKeys(driver, Attributr_search, Attribute_value_1);
		waitForDisplay(driver, acc_UD_Config_First_Value);
 
 
		if (isdisplayed(driver, acc_UD_Config_First_Value)) {
			waitForElement(driver, acc_UD_Config_First_Value);
			doubleClick(driver, acc_UD_Config_First_Value);
			waitForElement(driver, attribute_remove);
			click(driver, attribute_remove);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
 
		}
				Step_End(9, " Open Accounting Configuration module", test, test1);
		Step_End(10, "Make sure that below configuration is marked as add,\r\n"
				+ "IDLF-Discharge Reconciliation – Block BLs based on carriage contract as value as MB &&EL.", test, test1);
		Step_End(11, "system shows removed.", test, test1);
		
		

		Step_Start(11.1,"Open Discharge Reconciliation",test, test1);

     moduleNavigate(driver, Dis_Recon_Module);
		
		
		Step_End(11.1, "Open Discharge Reconciliation ", test, test1);

		Step_Start(12, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		newButton(driver);

		Step_End(12, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		
		Step_Start(13, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		   

		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		waitForElement(driver, grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_bound_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);

		Step_End(13, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		Step_Start(14, "Select the Plan as ALL/Local/Transhipment.", test, test1);
				if(!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
				waitForElement(driver, grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC,Terminal_Input);
		
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(14, "Select the Plan as ALL/Local/Transhipment.", test, test1);
		
		Step_Start(15, "Click on Download BL Button", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
	
		Step_End(15, "Click on Download BL Button", test, test1);
		Step_Start(16, "Verify that BL NO is loaded under Discharge reconciliation module", test, test1);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, BL_Number_Filter_Input);
		sendKeys(driver, BL_Number_Filter_Input, Bl_Number);
	
		if (isdisplayed(driver, DR_System_Bl_Type)) {
			System.out.println("pass"
					+ "pass: The excepeted is the bl Number should be displayed || the actual is bl number is  displayed ");
			Extent_pass(driver, "pass: The excepeted is the bl Number  should be displayed || the actual is bl number is displayed ", test, test1);
		} else {
			System.out.println("Fail: The excepeted is the bl Number  should be displayed || the actual is bl number is not displayed ");
			Extent_fail(driver, "Fail: The excepeted is the bl Number  should be displayed || the actual is bl number is not  displayed ", test, test1);
	
		}
		Step_End(16, "Verify that BL NO is loaded under Discharge reconciliation module", test, test1);
		Step_Start(17, "Navigate to Import Documentation module", test, test1);
		waitForElement(driver, importDocumentation_Button_DRC);
		click(driver, importDocumentation_Button_DRC);
		
		Step_End(17, "Navigate to Import Documentation module", test, test1);
		Step_Start(18, "Go to BL No search and search the same BL NO", test, test1);
		waitForElement(driver, BL_SearchButton_IMP_DOC);
		click(driver, BL_SearchButton_IMP_DOC);
		
		twoColumnSearchWindow(driver, BL_Number_Header, condition, Bl_Number);
		Step_End(18, "Go to BL No search and search the same BL NO", test, test1);
		Step_Start(19, "Get the BL number and save the Import  Documentation.", test, test1);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(19, "Get the BL number and save the Import  Documentation.", test, test1);
		Step_Start(20, "Verify that import Documentation saved for FI && LO Bls.", test, test1);
		waitForPopup(driver, popup_Message, Saved_popup);
		String Actual_save_popup = getText(driver, popup_Message);
		if (Saved_popup.equals(Actual_save_popup)) {
			System.out.println("pass: The Excepted popup is : "+Saved_popup+"|| The Actual Popup is : "+Actual_save_popup);
			Extent_pass(driver, "pass: The Excepted popup is : "+Saved_popup+"|| The Actual Popup is : "+Actual_save_popup, test, test1);
			
			click(driver, popup_Message_Ok_Button);
			 
		} else {
			System.out.println("Fail: The Excepted popup is : "+Saved_popup+"|| The Actual Popup is : "+Actual_save_popup);
			Extent_pass(driver, "Fail: The Excepted popup is : "+Saved_popup+"|| The Actual Popup is : "+Actual_save_popup, test, test1);
			

		}
		Step_End(20, "Verify that import Documentation saved for FI && LO Bls.", test, test1);
	Extent_completed(testcase_Name, test, test1);
		
	}
}
