package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD08 extends Keywords {
	
	public void Discharge_Reconciliation_MD08(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String test_Case_Name = "TC_Discharge_Reconciliation_MD08";


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
		String Column_Header = Excel_data.get("Discharge_Header");
		String Condition_Filter = Excel_data.get("DC_Condition_Filter");
		String bl_number = Excel_data.get("Bl_Number");
        String Easysearch_BL = Excel_data.get("Easysearch_BL");
        String Columnheader_BL= Excel_data.get("DC_Columnheader_BL");
        String DC_Column_Header= Excel_data.get("DC_Column_Header");

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
			waitForElement(driver, Scroll_Discharge_service);
			scrollUsingElement(driver, Scroll_Discharge_service);
			horizontalscroll(driver, Scroll_Discharge_service, 300);
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
	
	    Step_Start(7, "Select the ROW based on BL NO user wanted to check check box,", test, test1);
		
		reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, DC_Column_Header);
		 AGGridValueFilterMultipleValue(driver, Column_Header,Condition_Filter ,bl_number);
		 
		 Step_End(7, "Select the ROW based on BL NO user wanted to check check box,", test, test1);
		 
		 Step_Start(8, "Click the Check Box,",test, test1);
		 waitForElement(driver, DoHoldStatus_DR);
		 formatLocatorClick(driver, Clickcheckbox_DR, bl_number);

		 
		 Step_End(8, "Click the Check Box,",test, test1);
		 
		 Step_Start(9, "Click on DO Hold Button,",test, test1);
		 
	      waitForElement(driver,DoHoldStatus_DR);
          click(driver,DoHoldStatus_DR);
		 
		 Step_End(9, "Click on DO Hold Button",test, test1);
		 
		    Step_Start(10,"System shows Message  'Do Hold Status updated' and click on Okay button.", test, test1);
		    
		    waitForElement(driver,popup_Message_Ok_Button);
            click(driver,popup_Message_Ok_Button);
		    Step_End(10,"System shows Message  'Do Hold Status updated' and click on Okay button.", test, test1);
		  
		     Step_Start(11,"Open Import Documentation,", test, test1);
			 waitForElement(driver,Import_Button);
	         click(driver,Import_Button);
		     Step_End(11,"Open Import Documentation,", test, test1);
		   
		   Step_Start(12," Load the BL number using Easy search as SG000199300",test, test1);
		   waitForElement(driver,BL_SearchButton_IMP_DOC);
	       click(driver,BL_SearchButton_IMP_DOC);
           twoColumnSearchWindow(driver, Columnheader_BL, Condition_Filter, Easysearch_BL)	;	   
		   Step_End(12," Load the BL number using Easy search as SG000199300",test, test1);
		   
		   
		   Step_Start(13,"Go To HBL /BL summary Tab",test, test1);
		   waitForElement(driver,BL_HBL_Summary_Tab);
		   click(driver,BL_HBL_Summary_Tab);
		   
		   Step_End(13,"Go To HBL /BL summary Tab",test, test1);
			 
		   
           Step_Start(14,"Find the DO Hold Button,",test, test1);
           Step_Start(15,"Verify that DO hold Button is Checked .",test, test1);
           waitForElement(driver,DOhold_Checkbox_ImpDoc);
           String checkboxStatus = getAttribute(driver, DOhold_Checkbox_ImpDoc, "class");
          boolean actualStatus = extractstatus(checkboxStatus);
           if(actualStatus) {
        	   System.out.println("Matched || Expected Report Activity : In Discharge Reconciliation Module After Selecting the DO Hold Checkbox For The "+bl_number+" In Import Documentation Module HBL /BL summary Tab DO hold Button Should be Checked || The Actual Report Activity : In Discharege Reconciliation Module After Selecting the DO Hold Checkbox For The "+bl_number+" In Import Documentation Module HBL /BL summary Tab DO hold Button is Checked ");
        	   Extent_pass(driver,"Matched || Expected Report Activity : In Discharege Reconciliation Module After Selecting the DO Hold Checkbox For The "+bl_number+" In Import Documentation Module HBL /BL summary Tab DO hold Button Should be Checked || The Actual Report Activity : In Discharege Reconciliation Module After Selecting the DO Hold Checkbox For The "+bl_number+" In Import Documentation Module HBL /BL summary Tab DO hold Button is Checked ", test, test1);
           }else {
        	   System.out.println("Not Matched || Expected Report Activity : In Discharge Reconciliation Module After Selecting the DO Hold Checkbox For The "+bl_number+" In Import Documentaion Module HBL /BL summary Tab DO hold Button Should be Checked || The Actual Report Activity : In Discharege Reconciliation Module After Selecting the DO Hold Checkbox For The "+bl_number+" In Import Documentation Module HBL /BL summary Tab DO hold Button is Not Checked ");
               Extent_fail(driver,"Not Matched || Expected Report Activity : In Discharge Reconciliation Module After Selecting the DO Hold Checkbox For The "+bl_number+" In Import Documentaion Module HBL /BL summary Tab DO hold Button Should be Checked || The Actual Report Activity : In Discharege Reconciliation Module After Selecting the DO Hold Checkbox For The "+bl_number+" In Import Documentation Module HBL /BL summary Tab DO hold Button is Not Checked ", test, test1);
           }
		   Step_End(14,"Find the DO Hold Button,",test, test1);
			 Step_End(15,"Verify that DO hold Button is Checked .",test, test1);
			 Extent_completed(test_Case_Name, test, test1);

	
	}
}
