package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD52 extends Keywords {
	public void Discharge_Reconciliation_MD52(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Discharge_Reconciliation_MD52";

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
		String Bl_Number = Excel_data.get("Bl_Number");
		String Plan_Type = Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Type);
		String Switch_BL_POP = Excel_data.get("Switch_BL_POP");
		String GlobalSearch_DropDown_condition = Excel_data.get("Global_Search_Condition");
		String GlobalSearch_type = Excel_data.get("Select_Search_Type_Switch_BL");
		String Dis_recorn_System_Bl_Type = Excel_data.get("Dis_recorn_System_Bl_Type");
		
		String Switch_Bl_module_Name = Excel_data.get("Switch_Bl_module");
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency,", test, test1);

		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);

		moduleNavigate(driver, Dis_Recon_Module);

		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on New button if New Button is not Available Go to Next Step", test, test1);
		newButton(driver);

		Step_End(3, "Click on New button if New Button is not Available Go to Next Step", test, test1);

		Step_Start(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);


		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
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
		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
		Step_Start(5, " Select the Plan as ALL/Local/Transhipment", test, test1);

		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(5, " Select the Plan as ALL/Local/Transhipment", test, test1);
		Step_Start(6, "Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, "Click on Download BL Button.", test, test1);
		Step_Start(7, " Fileter the BL NO which is given as Test data,", test, test1);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		sendKeys(driver, BL_Number_Filter_Input, Bl_Number);
		
		Step_End(7, " Fileter the BL NO which is given as Test data,", test, test1);
		
		
		Step_Start(8, "Verify that filter BL has systm BL Type has Switch BL.", test, test1);
		waitForElement(driver, DR_System_Bl_Type);
		String DR_System_Bl_Value = getText(driver,DR_System_Bl_Type);
		if (Dis_recorn_System_Bl_Type.equals(DR_System_Bl_Value)) {
			System.out.println(
					"Pass:The Expected is  Discharge reconciliation Switch BL typeL Type should is: "+ Dis_recorn_System_Bl_Type+"|| The Actual Discharge reconciliation  switch BL system BL Type is:"+ DR_System_Bl_Value);
			Extent_pass(driver,
					"Pass:The Expected is  Discharge reconciliation Switch BL typeL Type should is: "+ Dis_recorn_System_Bl_Type+"|| The Actual   Discharge reconciliation switch BL system BL Type is:"+ DR_System_Bl_Value,
					test, test1);
	
			
		} else {
			System.out.println(
					"Fail:The Expected is Discharge reconciliation Switch BL typeL Type should is: "+ Dis_recorn_System_Bl_Type+"|| The Actual switch BL system BL Type is:"+ DR_System_Bl_Value);
			Extent_pass(driver,
					"Fail:The Expected is  Discharge reconciliation Switch BL typeL Type should is: "+ Dis_recorn_System_Bl_Type+"|| The Actual switch BL system BL Type is:"+ DR_System_Bl_Value,
					test, test1);
	

		}
		
		Step_End(8, "Verify that filter BL has systm BL Type has Switch BL.", test, test1);
	Step_Start(9, "Open Switch BL Module", test, test1);
		moduleNavigate(driver, Switch_Bl_module_Name);
		Step_End(9, "Open Switch BL Module", test, test1);
	Step_Start(10, "  clikc on search button and load the BL NO", test, test1);
	waitForElement(driver, cancel_Common_btn);
	click(driver, cancel_Common_btn);
	waitForElement(driver, SearchButton_Toolbar);
	click(driver, SearchButton_Toolbar);
	globalValueSearchWindow(driver, GlobalSearch_DropDown_condition, GlobalSearch_type, Bl_Number, "", "", "", "");
		
		
		waitForElement(driver, popup_Message_Ok_Button);
		
		waitForPopup(driver, popup_Message, Switch_BL_POP);
   		String Popup_Text_Act=getText(driver, popup_Message);
		
		if(Switch_BL_POP.equals(Popup_Text_Act)) {
			System.out.println("Popup Matched  ||   Expected is  : "+ Switch_BL_POP+"   ||   Actual   : "+Popup_Text_Act);
			Extent_pass(driver, "Popup Matched  ||   Expected is : "+ Switch_BL_POP+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected is : "+ Switch_BL_POP+"   ||   Actual   : "+Popup_Text_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected is : "+ Switch_BL_POP+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
 
		Step_End(10, "clikc on search button and load the BL NO", test, test1);
		
		Step_Start(11, "Go to system BL Type text Area, capture the Value", test, test1);
		waitForElement(driver, S_BL_System_Bl_Type);
		String S_BL_System_Bl_value = getText(driver, S_BL_System_Bl_Type);
		Step_End(11, "Go to system BL Type text Area, capture the Value", test, test1);
		
		Step_Start(12, " verify that switch BL system BL Type and Discharge reconciliation Switch BL type Matched.", test, test1);
		
		if (DR_System_Bl_Value.equals(S_BL_System_Bl_value)) {
			System.out.println(
					"Pass:The Expected is switch Discharge reconciliation Switch BL typeL Type should is: "+ DR_System_Bl_Value+"|| The Actual switch BL system BL Type is:"+ S_BL_System_Bl_value);
			Extent_pass(driver,
					"Pass:The Expected is switch Discharge reconciliation Switch BL typeL Type should is: "+ DR_System_Bl_Value+"|| The Actual switch BL system BL Type is:"+ S_BL_System_Bl_value,
					test, test1);
	
			
		} else {
			System.out.println(
					"Fail:The Expected is switch Discharge reconciliation Switch BL typeL Type should is: "+ DR_System_Bl_Value+"|| The Actual switch BL system BL Type is:"+ S_BL_System_Bl_value);
			Extent_pass(driver,
					"Fail:The Expected is switch Discharge reconciliation Switch BL typeL Type should is: "+ DR_System_Bl_Value+"|| The Actual switch BL system BL Type is:"+ S_BL_System_Bl_value,
					test, test1);
	

		}
		
		Step_End(12, " verify that switch BL system BL Type and Discharge reconciliation Switch BL type Matched.", test, test1);

		
		Extent_completed(testcase_Name, test, test1);
		
		
		
	}

}
