package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD10 extends Keywords {
	
	public void Discharge_Reconciliation_MD10(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String test_Case_Name = "TC_Discharge_Reconciliation_MD10";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Plan_Options = Excel_data.get("Plan_Type");
		String Column_Header = Excel_data.get("DC_Column_Header");
		String Condition_Filter = Excel_data.get("DC_Condition_Filter");
		String bl_number = Excel_data.get("BL_Number");
        String Delivery_Type = Excel_data.get("Delivery_Type");
        String Discharge_Header = Excel_data.get("Discharge_Header");
        String Columnheader_BL= Excel_data.get("Columnheader_BL");

		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Step_Start(1, " Switch to Agency,", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, " Switch to Agency,", test, test1);

		Step_Start(2, "Open Discharge Reconciliation Module", test, test1);
		moduleNavigate(driver, Dis_Recon_Module);
		Step_End(2, "Open Discharge Reconciliation Module", test, test1);

		Step_Start(3, "Click on new button if new button not available go below,", test, test1);
		newButton(driver);
		Step_End(3, "Click on new button if new button not available go below,", test, test1);

		Step_Start(4, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage_Input);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound_Input);
		if (!Port_Input.equals("")) {
			waitForElement(driver, grid_scroll);
			scrollUsingElement(driver, grid_scroll);
			horizontalscroll(driver, grid_scroll, 300);
			click1(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port_Input);
		}
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		Step_End(4, " Enter the service,Vessel, Voyage, Bound, Port and Terminal.", test, test1);

		Step_Start(5, "Select the Plan as ALL/Local/Transhipment.,", test, test1);
		waitForElement(driver, Plan_Option);
		click(driver, Plan_Option);

		formatLocatorClick(driver, Plan_Option_Select, Plan_Options);
		Step_End(5, " Select the Plan as ALL/Local/Transhipment.,", test, test1);
		Step_Start(6, " Click on Download BL Button.", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(6, " Click on Download BL Button.", test, test1);
		
		Step_Start(7,"Select the ROW based on BL NO",test,test1);
		waitForElement(driver, Filter_Button_Re_Con);
		click(driver, Filter_Button_Re_Con);
		waitForElement(driver, Bl_Number_input_re_con);
		sendKeys(driver, Bl_Number_input_re_con, bl_number);
		Step_End(7,"Select the ROW based on BL NO",test,test1);
		
		Step_Start(8,"Right Click and select as 'Change Delivery Type' option",test,test1);
		Step_Start(9,"System will open Delivery Type Window,",test,test1);
		Step_Start(10,"Enter the Delivery type which user wanted to select under Filter,",test,test1);
		Step_Start(11,"select the Delivery Type,",test,test1);
		
		waitForElement(driver, Bl_Number_input_re_con_row_click);
		click(driver, Bl_Number_input_re_con_row_click);
		RightClick(driver, Bl_Number_input_re_con_row_click);
		
		waitForElement(driver,Changedeliverytype_DR);
		click(driver,Changedeliverytype_DR);
		
		waitForElement(driver,Deliverytype_fieldinput_DR);
		sendKeys(driver,Deliverytype_fieldinput_DR ,Delivery_Type );
		

		waitForElement(driver,Deliverytype_fieldinput_DR);
		formatLocatorjsClick(driver,Select_deliverytype_DR , Delivery_Type);
		
		
		Step_End(8,"Right Click and select as 'Change Delivery Type' option",test,test1);

		
		Step_End(9,"System will open Delivery Type Window,",test,test1);
		Step_End(10,"Enter the Delivery type which user wanted to select under Filter,",test,test1);
		Step_End(11,"select the Delivery Type,",test,test1);
		
		Step_Start(12,"Click on Update Button.,",test,test1);
		waitForElement(driver,Updateclick_DR);
		click(driver,Updateclick_DR);
		Step_End(12,"Click on Update Button.,",test,test1);
		
		Step_Start(13,"After that Click on Change Delivery Type Button,",test,test1);
		waitForElement(driver,Changedeliverytype_button_DR);
		click(driver,Changedeliverytype_button_DR);

		Step_End(13,"After that Click on Change Delivery Type Button,",test,test1);
		Step_Start(14,"system says  Message as Delivery Type updated and click on Okay.",test,test1);
		waitForElement(driver,popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		Step_End(14,"system says  Message as Delivery Type updated and click on Okay.",test,test1);
		Step_Start(15,"Verify that selected Delivery Type updated for the BL in same Discharge Recon module" ,test,test1);
		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click,Discharge_Header);
		 AGGridValueFilterMultipleValue(driver, Column_Header,Condition_Filter ,bl_number);
		 
		 String deliverytypeverifyDisRec = getText(driver,verify_deliverytype_DR);
		 System.out.println("delivery type in discharge reconciliation:" +deliverytypeverifyDisRec);
		
		if (Delivery_Type.equals(deliverytypeverifyDisRec)) {
			System.out.println(
					"Matched || Expected result :   delivery type should be updated "  + Delivery_Type + "|| Actual result : delivery type updated " + deliverytypeverifyDisRec);
			Extent_pass(driver,
					"Matched || Expected result: result : delivery type should be updated " + Delivery_Type + " || Actualdelivery type updated " + deliverytypeverifyDisRec, test,
					test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected result :   delivery type should be updated "+ Delivery_Type +  "|| Actual result : delivery type not updated after changed the status " + deliverytypeverifyDisRec);
			Extent_fail(driver,
					"Not Matched ||  Expected result :   delivery type should be updated "+ Delivery_Type +  " || Actual result : delivery type not updated after changed the status " + deliverytypeverifyDisRec
					,test, test1);
		}
     
		Step_End(15,"Verify that selected Delivery Type updated for the BL in same Discharge Recon module" ,test,test1);
     
		
		Step_Start(16,"Open Import Documentation,", test, test1);
		 waitForElement(driver,Import_Button);
        click(driver,Import_Button);
	     Step_End(16,"Open Import Documentation,", test, test1);
	     

	   Step_Start(17," Click on BL search and Load the BL NO,",test, test1);
	   waitForElement(driver,BL_SearchButton_IMP_DOC);
       click(driver,BL_SearchButton_IMP_DOC);
       twoColumnSearchWindow(driver, Columnheader_BL, Condition_Filter, bl_number)	;	   
	   Step_End(17,"Click on BL search and Load the BL NO ",test, test1);
	   
	   
	   Step_Start(18,"Go To HBL /BL summary Tab",test, test1);
	   waitForElement(driver,BL_HBL_Summary_Tab);
	   click(driver,BL_HBL_Summary_Tab);
	   
	   Step_End(18,"Go To HBL /BL summary Tab",test, test1);
	   
	   Step_Start(19,"go to Discharge status Field and Verify that selected Delivery Type code is updated Correctly.",test,test1);
	   String dischargestatusImpdoc = getAttribute(driver,Dischargestatus_field_ImpDoc ,"value");
	   System.out.println("Discharge status in Import documentation:" +dischargestatusImpdoc);
	   
	   if (dischargestatusImpdoc.equals(deliverytypeverifyDisRec)) {
			System.out.println(
					"Matched || Expected result : delivery status field in IMP DOCUMENTATION should be matched with selected Delivery Type code in DIS RECONCILIATION  "  + dischargestatusImpdoc + "|| Actual result : delivery status field in IMP DOCUMENTATION IS matched with selected Delivery Type code in DIS RECONCILIATION" + deliverytypeverifyDisRec);
			Extent_pass(driver,
					"Matched || Expected result: result :delivery status field in IMP DOCUMENTATION should be matched with selected  Delivery Type code in DIS RECONCILIATION " + dischargestatusImpdoc + " ||  Actual result : delivery status field in IMP DOCUMENTATION IS matched with selected Delivery Type code in DIS RECONCILIATION " + deliverytypeverifyDisRec, test,
					test1);
		} else {
			System.out.println(
					"Not Matched ||  Expected result :delivery status field in IMP DOCUMENTATION should be matched with selected Delivery Type code in DIS RECONCILIATION  "+ dischargestatusImpdoc +  "|| Actual result :delivery status field in IMP DOCUMENTATION IS NOT matched with selected Delivery Type code in DIS RECONCILIATION " + deliverytypeverifyDisRec);
			Extent_fail(driver,
					"Not Matched ||  Expected result : delivery status field in IMP DOCUMENTATION should be matched with selected Delivery Type code in DIS RECONCILIATION "+ dischargestatusImpdoc +  " || Actual result : delivery status field in IMP DOCUMENTATION IS NOT matched with selected Delivery Type code in DIS RECONCILIATION" + deliverytypeverifyDisRec
					,test, test1);
		}

		Step_End(19,"go to Discharge status Field and Verify that selected Delivery Type code is updated Correctly.",test,test1);
		Extent_completed(test_Case_Name, test, test1);

	
	}
}
