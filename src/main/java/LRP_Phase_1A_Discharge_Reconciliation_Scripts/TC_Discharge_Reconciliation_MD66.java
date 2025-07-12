package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD66 extends Keywords {
	
	public void Discharge_Reconciliation_MD66(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD66";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Agency_Config_Module = Excel_data.get("Agency_Config_Module");
		String Agency_code_header = Excel_data.get("Agency_code_header");
		String Attribute_code_header = Excel_data.get("Attribute_code_header");
		String Condition = Excel_data.get("Condition");
		String Attribute = Excel_data.get("Attribute");
		String Description = Excel_data.get("Description");
		String Value = Excel_data.get("Value");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Dis_Recon_Module = Excel_data.get("Dis_Recon_Module");
		String Service_Input = Excel_data.get("Service_Input");
		String Plan_Input=Excel_data.get("Plan_Input");
		String bl_Number = Excel_data.get("bl_Number");
		String Saved_pop_expected = Excel_data.get("Saved_pop_expected");
		String DPD_Code_input_Value = Excel_data.get("DPD_Code_input_Value");
		String condition = Excel_data.get("Condition");
		String BL_Number_Header = Excel_data.get("BL_Number_Header");
		String Discharge_Header = Excel_data.get("Discharge_Header");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);
		
		
		

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);

		SwitchProfile(driver, AgencyUser);
	
	
		Step_Start(1, " Switch to agency", test, test1);
		Step_Start(2, " Open Agency configuration module", test, test1);
		Step_Start(3, " Click on New button,if new button not available go below steps", test, test1);
		Step_Start(4, " Click on agency code search Button", test, test1);
		Step_Start(5, "Enter the agency code and click on Show Button,", test, test1);
		Step_Start(6, "Verify that given configuration is already available if available and make sure that value is Marked as -N.Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y'", test, test1);
		Step_Start(7, " if marked as N move to next action", test, test1);
		Step_Start(8, " if Configuration marked as Y then Double click the row and change the Value to N and click (+)button", test, test1);
		Step_Start(9, " if Configuration is not added go to next step,", test, test1);
		setAgencyConfiguration(driver, Agency_Config_Module, Agency_code_header, Attribute_code_header, Condition,
				AgencyUser, Attribute, Description, Value);
		Step_End(1, " Switch to agency", test, test1);
		Step_End(2, " Open Agency configuration module", test, test1);
		Step_End(3, " Click on New button,if new button not available go below steps", test, test1);
		Step_End(4, " Click on agency code search Button", test, test1);
		Step_End(5, "Enter the agency code and click on Show Button,", test, test1);
		Step_End(6, "Verify that given configuration is already available if available and make sure that value is Marked as -N.Agency configuration (DRCBD - Discharge Reconciliation). To enable these buttons, the Shipment Category and DPD Code set to 'Y'", test, test1);
		Step_End(7, " if marked as N move to next action", test, test1);
		Step_End(8, " if Configuration marked as Y then Double click the row and change the Value to N and click (+)button", test, test1);
		Step_End(9, " if Configuration is not added go to next step,", test, test1);
        
		Step_Start(10, "Open Discharge Reconciliation Module", test, test1);
moduleNavigate(driver, Dis_Recon_Module);
		
		
		Step_End(10, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(11, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		newButton(driver);

		Step_End(11, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		
		Step_Start(12, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		   
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
		
				if(!Port_Input.equals("")) {
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
			
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		Step_End(12, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		
		Step_Start(13, "Select the Plan as ALL/Local/Transhipment", test, test1);
		
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(13, "Select the Plan as ALL/Local/Transhipment", test, test1);
	
		Step_Start(14, "Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(14, "Click on Download BL Button.", test, test1);
		Step_Start(15, "select the BLs listed under Test Data,", test, test1);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, bl_Number);
		waitForElement(driver, Bl_Number_input_re_con_row_click);
		click(driver, Bl_Number_input_re_con_row_click);
		Step_End(15, "select the BLs listed under Test Data,", test, test1);
		Step_Start(16, "select the Row and right click it", test, test1);
		RightClick(driver, Bl_Number_input_re_con_row_click);
		Step_End(16, "select the Row and right click it", test, test1);
		Step_Start(17, "select as change DPD Code option ", test, test1);
		waitForElement(driver, Change_dpd_code);
		click(driver, Change_dpd_code);
		Step_End(17, "select as change DPD Code option ", test, test1);
		Step_Start(18, "system will be open new window, user can select the Enter the DPD Code ", test, test1);
		waitForElement(driver, DPD_Code_input);
		sendKeys(driver, DPD_Code_input, DPD_Code_input_Value);
		Step_End(18, "system will be open new window, user can select the Enter the DPD Code ", test, test1);
		Step_Start(19, " and click on Update Button,", test, test1);
		waitForElement(driver, DPD_Code_select_update);
		click(driver, DPD_Code_select_update);
		Step_End(19, " and click on Update Button,", test, test1);
		Step_Start(20, "and Click on DPD code Button and system shows \"\"DPD Code Updated\"\" and click ok,", test, test1);
		waitForElement(driver, DPD_CODE_BUTTON);
		click(driver, DPD_CODE_BUTTON);
		waitForPopup(driver, popup_Message,Saved_pop_expected);
		String popact1 = getText(driver, popup_Message);

		if (Saved_pop_expected.equals(popact1)) {
			System.out.println(
					"Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was : " + popact1);
			Extent_pass(driver,
					"Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was : " + popact1, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was : " + popact1);
			Extent_fail(driver,
					"Not Matched || Expected popup message was : " + Saved_pop_expected + " || Actual popup message was  : " + popact1,
					test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Discharge_Header);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, bl_Number);
		waitForElement(driver, DPD_Code_text_Gird);
	    String DPD_Code_re_con = getText(driver, DPD_Code_text_Gird);
		
		
		
		Step_End(20, "and Click on DPD code Button and system shows \"\"DPD Code Updated\"\" and click ok,", test, test1);


		Step_Start(21, " navgigate into Import Documentation module", test, test1);
		
		waitForElement(driver, importDocumentation_Button_DRC);
		click(driver, importDocumentation_Button_DRC);
		Step_End(21, " navgigate into Import Documentation module", test, test1);
		Step_Start(22, " Filter the BL number using BL search", test, test1);
		waitForElement(driver, BL_SearchButton_IMP_DOC);
		click(driver, BL_SearchButton_IMP_DOC);
		
		twoColumnSearchWindow(driver, BL_Number_Header, condition, bl_Number);
		Step_End(22, " Filter the BL number using BL search", test, test1);
		Step_Start(23, " Go to BL/HBL summary", test, test1);
		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver, BL_HBL_Summary_Tab);
		Step_End(23, " Go to BL/HBL summary", test, test1);
		scrollBottom(driver);
		Step_Start(24, "Find the DPD code label and Verify that Discharge Recon && Import Documentation DPD Code has same details", test, test1);
		waitForElement(driver, DPD_Code);
		String Code_DPD_Actual = getAttribute(driver, DPD_Code,"value");
		System.out.println(Code_DPD_Actual);
		
		if (!DPD_Code_input_Value.equals(Code_DPD_Actual)) {
			System.out.println(
					"Not Matched|| Expected DPD Value given in the Discharge Reconciliation module from Test Data  : " + DPD_Code_input_Value + " || Actual DPD Value present in the import documentation: " + Code_DPD_Actual);
			Extent_pass(driver,
					"Not Matched || Expected DPD Value given in the Discharge Reconciliation module from Test Data : " + DPD_Code_input_Value + " || Actual DPD Value present in the import documentation : " + Code_DPD_Actual, test,
					test1);
		} else {
			System.out.println(
					" Matched || Expected DPD Value given in the Discharge Reconciliation module from Test Data : " + DPD_Code_input_Value + " || Actual DPD Value present in the import documentation : " + Code_DPD_Actual);
			Extent_fail(driver,
					" Matched || Expected DPD Value given in the Discharge Reconciliation module from Test Data : " + DPD_Code_input_Value + " || Actual DPD Value present in the import documentation  : " + Code_DPD_Actual,
					test, test1);
		}
		
		
		
		
		if (DPD_Code_re_con.trim().equals(Code_DPD_Actual.trim())) {
			System.out.println(
					"Matched || Expected DPD Value given in the Discharge Reconciliation module  : " + DPD_Code_re_con + " || Actual DPD Value present in the import documentation: " + Code_DPD_Actual);
			Extent_pass(driver,
					"Matched || Expected DPD Value given in the Discharge Reconciliation module : " + DPD_Code_re_con + " || Actual DPD Value present in the import documentation : " + Code_DPD_Actual, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected DPD Value given in the Discharge Reconciliation module  : " + DPD_Code_re_con + " || Actual DPD Value present in the import documentation : " + Code_DPD_Actual);
			Extent_fail(driver,
					"Not Matched || Expected DPD Value given in the Discharge Reconciliation module  : " + DPD_Code_re_con + " || Actual DPD Value present in the import documentation  : " + Code_DPD_Actual,
					test, test1);
		}
		
		
		
		
		
		
		
		
		
		
		
		Extent_completed(testcase_Name, test, test1);
		
		
		

	
	
}}
