package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD16 extends Keywords {


	public void Discharge_REconciliation_MD16(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Discharge_Reconciliation_MD16";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Dis_Recon_Module = Excel_data.get("Discharge_Recon_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Service_Input = Excel_data.get("Service_Input");
		String Vessel_Input = Excel_data.get("Vessel_Input");
		String Voyage_Input = Excel_data.get("Voyage_Input");
		String Bound_Input = Excel_data.get("Bound_Input");
		String Port_Input = Excel_data.get("Port_Input");
		String Plan_Input=Excel_data.get("Plan_Type");
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);	
		
		
		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver ,url);
		
		LRP_Login(driver, Username, Password);
		
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Switch to agency", test, test1);


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
		
		Step_End(4, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);

		Step_Start(5," Select the Plan as ALL/Local/Transhipment",test,test1);
		
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		
		
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		
		Step_End(5,"Select the Plan as ALL/Local/Transhipment",test,test1);
		
		
		Step_Start(6,"Click on Download BL Button",test,test1);
		
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		
		Step_End(6,"Click on Download BL Button",test,test1);
		
		Step_Start(7,"Click on Show Summary button",test,test1);
		
		waitForElement(driver, Show_Summary_Btn_DR);
		click(driver , Show_Summary_Btn_DR);
		
		Step_End(7,"Click on Show Summary button",test,test1);
		
		Step_Start(8,"Click on Show SumClick on MCN Yet to be refreshed button in Discharge reconmary button",test,test1);
		
		waitForElement(driver,MCN_Ref_btn_DR);
		click(driver , MCN_Ref_btn_DR);
		
		Step_End(8,"Click on Show SumClick on MCN Yet to be refreshed button in Discharge reconmary button",test,test1);
		
		Step_Start(9,"Get the Count of it and store it",test,test1);
		
		String MCN_BLs_List=getText(driver, MCN_Total_Records_DR);
        System.out.println("total count"+MCN_BLs_List);
       
        Step_End(9,"Get the Count of it and store it",test,test1);
       
        Step_Start(10,"Close MCN Yet to be refreshed window",test,test1);
       
        waitForElement(driver,Close_btn_DR);
		click(driver , Close_btn_DR);
        
		 Step_End(10,"Close MCN Yet to be refreshed window",test,test1);
		 
		 Step_Start(11,"Go to MCN Yet to Refresh BL'S Text Field area",test,test1);
		 Step_Start(12,"Capture the Text Count",test,test1);
		 waitForElement(driver, Count_No_DR);
		 String MCN_Summery_Bls= getAttribute(driver, Count_No_DR, "value");
		 System.out.println(MCN_Summery_Bls);
		 
		 Step_End(12,"Capture the Text Count",test,test1);
		 Step_End(11,"Go to MCN Yet to Refresh BL'S Text Field area",test,test1);
		 

		 Step_Start(13,"Verify  Step 9 and 13 Count Has to be matched",test,test1);
		 
		 if(MCN_BLs_List.equals(MCN_Summery_Bls)) {
			 System.out.println("Matched || Expected : MCN Yet to Refresh BLs List  "+ MCN_BLs_List + "||   Actual  : Total Records in MCN Yet to Refresh BLs List : " +MCN_Summery_Bls );
			 Extent_pass(driver, "Matched || Expected : MCN Yet to Refresh BLs List  "+ MCN_BLs_List + "||   Actual  : Total Records in MCN Yet to Refresh BLs List : " +MCN_Summery_Bls ,test, test1);
		 }else {
			 System.out.println("Not Matched || Expected : MCN Yet to Refresh BLs List  "+ MCN_BLs_List + "||   Actual  : Total Records in MCN Yet to Refresh BLs List : " +MCN_Summery_Bls);
			 Extent_fail(driver, "Not Matched || Expected : MCN Yet to Refresh BLs List  "+ MCN_BLs_List + "||   Actual  : Total Records in MCN Yet to Refresh BLs List : " +MCN_Summery_Bls ,test, test1);
			 
		 Step_End(13,"Verify  Step 9 and 13 Count Has to be matched",test,test1);
			 
		 }
		 Extent_completed(testcase_Name, test, test1);
	}
}
