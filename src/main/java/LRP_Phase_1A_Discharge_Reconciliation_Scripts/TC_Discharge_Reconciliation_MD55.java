package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.awt.AWTException;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD55 extends Keywords {
	public void Discharge_Reconciliation_MD55(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) throws AWTException {

		String testcase_Name = "TC_Discharge_Reconciliation_MD55";

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
		String AC_ChargeCode_Values = Excel_data.get("Accounting_ChargeCode_Values");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Agency_Code_Header = Excel_data.get("Accounting_Agency_Code_Header");
		String AC_ChargeCode_Header = Excel_data.get("Accounting_ChargeCode_Header");
		String attribute_Header = Excel_data.get("Accounting_Attribute_code_header");
		String AccountingConfiguration = Excel_data.get("Acconting_Config_Module");
		String Attribute_value = Excel_data.get("Accounting__Attribute_Value");
		String Value_checkbox_perform = Excel_data.get("Value_checkbox_perform");
		String Bill_lading_module = Excel_data.get("Bill_lading_module");
		String GlobalSearch_DropDown_condition = Excel_data.get("Global_Search_Condition");
		String GlobalSearch_type = Excel_data.get("Select_Search_Type_Bill_Of_Lading");
		String MCN_HomePage_Title = Excel_data.get("MCN_HomePage_Title");
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver,url);
Extent_Start(testcase_Name, test, test1);
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
		Step_Start(10, ".Make sure that below configuration is marked as add,\r\n"
				+ "IDLF-Discharge Reconciliation – Block BLs based on carriage contract as value as MB &&EL", test, test1);
		Step_Start(11, "system shows updated Message", test, test1);
		
		 setAccountingConfiguration(driver, AccountingConfiguration, Agency_Code_Header,attribute_Header,Condition_Filter,AgencyUser,"",Attribute_value,AC_ChargeCode_Header,AC_ChargeCode_Values,Value_checkbox_perform);
		
		Step_End(9, " Open Accounting Configuration module", test, test1);
		Step_End(10, "Make sure that below configuration is marked as add,\r\n"
				+ "IDLF-Discharge Reconciliation – Block BLs based on carriage contract as value as MB &&EL.", test, test1);
		
		Step_Start(12, "Open Bill of lading module and click on search button", test, test1);
		moduleNavigate(driver, Bill_lading_module);
		
		Step_End(12, "Open Bill of lading module and click on search button", test, test1);
		
		waitForDisplay(driver, billOfLading_Tab);
		if (isDisplayed(driver, billOfLading_Tab)) {
			System.out.println("Expected Result :  module should be Open || Actual result :  module is opened");
			Extent_pass(driver, "Expected Result :  module should be Open || Actual result : module is opened", test, test1);
		} else {
			System.out.println("Expected Result :  module should be Open || Actual result : module is not opened");
			Extent_fail(driver, "Expected Result :  module should be Open || Actual result : module is not opened", test, test1);
		}
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(12, "Open Bill of lading module and click on search button", test, test1);
		Step_Start(13, "Load the BL NO in Bill of Lading Module", test, test1);
		globalValueSearchWindow(driver, GlobalSearch_DropDown_condition, GlobalSearch_type, Bl_Number, "", "", "", "");

		Step_End(13,"Load the BL NO in Bill of Lading Module",test, test1);
		Step_Start(14,"check BL has MCN If yes Find the Approved MCN and Double Click it",test, test1);

		if (isdisplayed(driver, Mcn_Container_BillofLading)) {
			doubleClick(driver, Mcn_Container_BillofLading);
			
			Step_Start(15,"system will open the MCN module",test, test1);
			waitForElement(driver, MCN_Title);
			String Actual_HomePage_Title = getText(driver, MCN_Title);
			if (MCN_HomePage_Title.equals(Actual_HomePage_Title)) {
				System.out.println("pass: The excepted is The MCN Home Page should be Displayed || The Actual is The MCN Home Page is displayed");
				Extent_pass(driver, "pass: The excepted is The MCN Home Page should be Displayed || The Actual is The MCN Home Page is displayed", test, test1);
			} else {
				System.out.println("Fail: The excepted is The MCN Home Page should be Displayed || The Actual is The MCN Home Page is not displayed");
				Extent_fail(driver, "Fail: The excepted is The MCN Home Page should be Displayed || The Actual is The MCN Home Page is Not displayed", test, test1);
			
			}
			
			Step_End(15,"system will open the MCN module",test, test1);
			waitForElement(driver, Mcn_carriage_contract);
			String Carriage_Contract = getAttribute(driver, Mcn_carriage_contract, "value");
			List<String> AC_ChargeCode_Value = splitAndExpand(AC_ChargeCode_Values, ",");
			
				if (AC_ChargeCode_Value.get(0).contains(Carriage_Contract)) {
					System.out.println("pass:The ChargeCode from Accounting configuration module is:"+AC_ChargeCode_Value.get(0)+"|| The Carriage_Contract value from Bill of lading module is : "+Carriage_Contract);
					Extent_pass(driver, "pass:The ChargeCode from Accounting configuration module is:"+AC_ChargeCode_Value.get(0)+"|| The Carriage_Contract value from Bill of lading module is : "+Carriage_Contract, test, test1);
				
				} else{
					System.out.println("Fail:The ChargeCode from Accounting configuration module is:"+AC_ChargeCode_Value.get(0)+"|| The Carriage_Contract value from Bill of lading module is : "+Carriage_Contract);
					Extent_pass(driver, "fail:The ChargeCode from Accounting configuration module is:"+AC_ChargeCode_Value.get(0)+"|| The Carriage_Contract value from Bill of lading module is : "+Carriage_Contract, test, test1);
				} 
		
		
				Step_End(14,"check BL has MCN If yes Find the Approved MCN and Double Click it",test, test1);
		}
		
		else {
			Step_Start(16,".Go to Carriage Contract label place",test, test1);

		waitForElement(driver, bl_Carriage_Contract);
		String Carriage_Contract = getAttribute(driver, bl_Carriage_Contract, "value");
		Step_End(16,".Go to Carriage Contract label place",test, test1);

		Step_Start(17,".Verify that Configuration Defined code and BL/MCN Carriage Contract code matched,",test, test1);

		List<String> AC_ChargeCode_Value = splitAndExpand(AC_ChargeCode_Values, ",");
		
			if (AC_ChargeCode_Value.get(0).contains(Carriage_Contract)) {
				System.out.println("pass:The ChargeCode from Accounting configuration module is : "+AC_ChargeCode_Value.get(0)+"|| The Carriage_Contract value from Bill of lading module is : "+Carriage_Contract);
				Extent_pass(driver, "pass:The ChargeCode from Accounting configuration module is: "+AC_ChargeCode_Value.get(0)+"|| The Carriage_Contract value from Bill of lading module is : "+Carriage_Contract, test, test1);
			
			} else{
				System.out.println("Fail:The ChargeCode from Accounting configuration module is: "+AC_ChargeCode_Value.get(0)+"|| The Carriage_Contract value from Bill of lading module is : "+Carriage_Contract);
				Extent_pass(driver, "fail:The ChargeCode from Accounting configuration module is: "+AC_ChargeCode_Value.get(0)+"|| The Carriage_Contract value from Bill of lading module is : "+Carriage_Contract, test, test1);
			} 
	
		}
		Step_End(17,".Verify that Configuration Defined code and BL/MCN Carriage Contract code matched,",test, test1);

		Step_Start(18,"Open Discharge Reconciliation",test, test1);

     moduleNavigate(driver, Dis_Recon_Module);
		
		
		Step_End(18, "Open Discharge Reconciliation ", test, test1);

		Step_Start(19, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		newButton(driver);

		Step_End(19, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		
		Step_Start(20, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		   

		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		waitForElement(driver, grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_bound_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);

		Step_End(20, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		Step_Start(21, "Select the Plan as ALL/Local/Transhipment.", test, test1);
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
		Step_End(21, "Select the Plan as ALL/Local/Transhipment.", test, test1);
		
		Step_Start(22, "Click on Download BL Button.. Verify that BL NO is not loaded in Discharge reconcilation.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
	
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, BL_Number_Filter_Input);
		sendKeys(driver, BL_Number_Filter_Input, Bl_Number);
	
		if (!isdisplayed(driver, DR_System_Bl_Type)) {
			System.out.println("pass"
					+ "pass: The excepeted is the bl Number should not be displayed || the actual is bl number is not  displayed ");
			Extent_pass(driver, "pass: The excepeted is the bl Number not should be displayed || the actual is bl number is not displayed ", test, test1);
		} else {
			System.out.println("Fail: The excepeted is the bl Number not should be displayed || the actual is bl number is  displayed ");
			Extent_fail(driver, "Fail: The excepeted is the bl Number not should be displayed || the actual is bl number is  displayed ", test, test1);
	
		}
		Step_End(22, "Click on Download BL Button.. Verify that BL NO is not loaded in Discharge reconcilation.", test, test1);
		}
	}
