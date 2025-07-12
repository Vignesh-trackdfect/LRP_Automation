package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD67 extends Keywords{
	
	public void Discharge_Reconciliation_MD67(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD67";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Import_Doc_Module = Excel_data.get("ImportDocumentationModule");
		String bl_Number = Excel_data.get("bl_Number");
		String ImportDoc_Select_Type1 = Excel_data.get("ImportDoc_Select_Type1");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String DPD_Code_input_Value = Excel_data.get("DPD_Code_input_Value");
		String SavedPopup = Excel_data.get("SavedPopup");
		String Dis_Recon_Module = Excel_data.get("Dis_Recon_Module");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Plan_Input=Excel_data.get("Plan_Input");
		String Discharge_Header=Excel_data.get("Discharge_Header");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);
		
	
	
		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);
		Step_Start(1, " Switch to agency,", test, test1);
		
		SwitchProfile(driver, AgencyUser);
		Step_End(1, " Switch to agency,", test, test1);
		Step_Start(2, "Open Import Documentation module", test, test1);
		moduleNavigate(driver, Import_Doc_Module);
		Step_End(2, "Open Import Documentation module", test, test1);
		Step_Start(3, "Click BL Search button,", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(3, "Click BL Search button,", test, test1);
		Step_Start(4, "Click && Enter the BL no and load it", test, test1);
		globalValueSearchWindow(driver, dropdownCondition1, ImportDoc_Select_Type1, bl_Number, "", "", "", "");
		Step_End(4, "Click && Enter the BL no and load it", test, test1);

	
	
	Step_Start(4.1, " Go to HBL Summaray tab", test, test1);
	waitForElement(driver, BL_HBL_Summary_Tab);
	click(driver, BL_HBL_Summary_Tab);
	Step_End(4.1, " Go to HBL Summaray tab", test, test1);
	scrollBottom(driver);
	Step_Start(4.2, "Find the DPD code Text Area", test, test1);
	waitForElement(driver, DPD_Code);
	Step_End(4.2, "Find the DPD code Text Area", test, test1);
	Step_Start(4.3, "Enter the DPD code which is presented in Test data,", test, test1);
	clearAndType(driver, DPD_Code, DPD_Code_input_Value);
	Step_End(4.3, "Enter the DPD code which is presented in Test data,", test, test1);
	scrollTop(driver);
	Step_Start(5, "Save the import Documentation click ok after saved import doc", test, test1);
	waitForElement(driver, SaveButton_ToolBar);
	click(driver, SaveButton_ToolBar);
	
	waitForPopup(driver, popup_Message, SavedPopup);

	String BL_Act_Popup= getText(driver, popup_Message);
	
	if(BL_Act_Popup.equals(SavedPopup)) {
		System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + BL_Act_Popup);
		Extent_pass(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + BL_Act_Popup, test,
				test1);

	}else {
		System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + BL_Act_Popup);
		Extent_fail(driver, "NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + BL_Act_Popup,
				test, test1);
	}
	
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver, popup_Message_Ok_Button);
	Step_End(5, "Save the import Documentation click ok after saved import doc", test, test1);
	String Code_DPD_Actual = getAttribute(driver, DPD_Code,"value");
	System.out.println(Code_DPD_Actual);
	
	waitForElement(driver, Close_Current_tab);
	click(driver, Close_Current_tab);
	
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
		waitForElement(driver, grid_scroll);
		scrollUsingElement(driver, grid_scroll);
		horizontalscroll(driver, grid_scroll, 300);
		
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
	Step_Start(15, " Filter the BL Number which is saved the import doc,,", test, test1);
	reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Discharge_Header);
	waitForElement(driver, Filter_Button_Re_Con);
	click(driver, Filter_Button_Re_Con);
	waitForElement(driver, Bl_Number_input_re_con);
	sendKeys(driver, Bl_Number_input_re_con, bl_Number);
	Step_End(15, " Filter the BL Number which is saved the import doc,,", test, test1);
	Step_Start(16, " Go to DPD COde Column,", test, test1);
	waitForElement(driver, DPD_Code_text_Gird);
	Step_End(16, " Go to DPD COde Column,", test, test1);
	Step_Start(21, " Verify that add DPD Code listed in Discharge recon for the same BL.,", test, test1);
	String DPD_Code_Actual= getText(driver, DPD_Code_text_Gird);
	System.out.println(DPD_Code_Actual);
	Step_End(21, " Verify that add DPD Code listed in Discharge recon for the same BL.,", test, test1);
	
	Step_Start(22, " Verify that Discharge Recon DPD Code has same details.,", test, test1);
	if (Code_DPD_Actual.trim().equals(DPD_Code_Actual.trim())) {
		System.out.println(
				"Matched || Expected DPD Value given in the Discharge Reconciliation module  : " + DPD_Code_Actual + " || Actual DPD Value present in the import documentation: " + Code_DPD_Actual);
		Extent_pass(driver,
				"Matched || Expected DPD Value given in the Discharge Reconciliation module : " + DPD_Code_Actual + " || Actual DPD Value present in the import documentation : " + Code_DPD_Actual, test,
				test1);
	} else {
		System.out.println(
				"Not Matched || Expected DPD Value given in the Discharge Reconciliation module  : " + DPD_Code_Actual + " || Actual DPD Value present in the import documentation : " + Code_DPD_Actual);
		Extent_fail(driver,
				"Not Matched || Expected DPD Value given in the Discharge Reconciliation module  : " + DPD_Code_Actual + " || Actual DPD Value present in the import documentation  : " + Code_DPD_Actual,
				test, test1);
	}
	
	Step_End(22, " Verify that Discharge Recon DPD Code has same details.,", test, test1);
	
	Extent_completed(testcase_Name, test, test1);
	
	
	
	
	

}}
