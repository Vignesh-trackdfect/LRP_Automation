package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Master_SC031 extends Keywords {

	public void Vendor_Master_SC031(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Vendor_Master_SC031";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Vendor_Master_Module = Excel_data.get("Vendor_Master_Module");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Status_Active = Excel_data.get("Status_Active");
		String Status_Void = Excel_data.get("Status_Void");
		
		
		Extent_Start(testcase_Name, test, test1);
		
		Step_Start(1, "Open the application", test, test1);
		navigateUrl(driver, url);
		Step_End(1, "Open the application", test, test1);
	
		Step_Start(2, "Go to vendor master Screen.", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Vendor_Master_Module);
		
		Step_End(2, "Go to vendor master Screen.", test, test1);
		
		Step_Start(3, "On landing page click on (action) icon.", test, test1);

		
		formatLocatorClick(driver, VM_Action_Option, Vendor_Code);
		
		Step_End(3, "On landing page click on (action) icon.", test, test1);
		
		Step_Start(4, " It will naviagte to module home page.", test, test1);

         waitForDisplay(driver, VM_Vendor_Code_Input);	
         if(isdisplayed(driver, VM_Vendor_Code_Input)) {
        	 System.out.println("After clicking on the action icon, it navigates to the Vendor Master home page successfully."); 
  		     Extent_pass_New(driver,"After clicking on the action icon, it navigates to the Vendor Master home page successfully.",test, test1);
        	 
        	 }else {
            	 System.out.println("After clicking on the action icon, it navigates to the Vendor Master home page Not display."); 
      		     Extent_fail(driver,"After clicking on the action icon, it navigates to the Vendor Master home page successfully.",test, test1);

        	 }

 		Step_End(4, " It will naviagte to module home page.", test, test1);
 		
		Step_Start(5, " Click Navigate back option.", test, test1);

 		waitForElement(driver, VM_Back_Option_Button);
 		click(driver, VM_Back_Option_Button);
 		
 		
 		Step_End(5, " Click Navigate back option.", test, test1);

		Step_Start(6, " Verify when apply filter for active/Void whether the particular data is getting filtered based on selection.", test, test1);

		waitForElement(driver, VM_Activity);
		String Act_Activity=getText(driver, VM_Activity);
		System.out.println("Act_Activity :"+Act_Activity);
		
		
		waitForElement(driver, VM_Activity);
		click(driver,VM_Activity);
		
		waitForElement(driver, VM_Total_Records);
		String Total_Records_Act =getText(driver, VM_Total_Records);
		String [] activites=Total_Records_Act.split("of");
		String Act_Activity_Count=activites[0].trim();
		
		
		if(Act_Activity_Count.equals(Act_Activity)) {
			
 		   System.out.println("Matched || Expected || Activuty values was : "+Act_Activity+ "|| Actual :  Activuty values was :" + Act_Activity_Count);
		   Extent_pass_New(driver,"Matched || Expected || Activuty values was : "+Act_Activity+ "|| Actual :  Activuty values was :" + Act_Activity_Count,test, test1);
 		   
		}else {
			
	 		   System.out.println("Not Matched || Expected || Activuty values was : "+Act_Activity+ "|| Actual :  Activuty values was :" + Act_Activity_Count);
			   Extent_fail(driver,"Not Matched || Expected || Activuty values was : "+Act_Activity+ "|| Actual :  Activuty values was :" + Act_Activity_Count,test, test1);
		}
		
		
//		reArrangeAG_GridColumns(driver, Grid_Header);
		

		waitForElement(driver, SSC_Status);
		String Status =getText(driver, SSC_Status);
		
		
		if(Status.equals(Status_Active)) {
			
			   System.out.println("Matched || Expected || Status values was : "+Status_Active+ "|| Actual :  Status values was :" + Status);
			   Extent_pass_New(driver,"Matched || Expected || Status values was : "+Status_Active+ "|| Actual :  Status values was :" + Status,test, test1);

		}else {
			
			 System.out.println("Not Matched || Expected || Status values was : "+Status_Active+ "|| Actual :  Status values was :" + Status);
			  Extent_fail(driver,"Not Matched || Expected || Status values was : "+Status_Active+ "|| Actual :  Status values was :" + Status,test, test1);

			
		}
		
		
		waitForElement(driver, VM_Void);
		String Act_Void=getText(driver, VM_Void);
		System.out.println("Act_Activity :"+Act_Activity);
		
		
		waitForElement(driver, VM_Void);
		click(driver,VM_Void);
			
		waitForElement(driver, VM_Total_Records);
		
		String Total_Records_void =getText(driver, VM_Total_Records);
		String [] Voids=Total_Records_void.split("of");
		String Act_Void_Count=Voids[0].trim();
		
		if(Act_Void_Count.equals(Act_Void)) {
			
	 		   System.out.println("Matched || Expected || Void values was : "+Act_Void+ "|| Actual :  Void values was :" + Act_Void_Count);
			   Extent_pass_New(driver,"Matched || Expected || Void values was : "+Act_Void+ "|| Actual :  Void values was :" + Act_Void_Count,test, test1);
	 		   
			}else {
				
		 		   System.out.println("Not Matched || Expected || Void values was : "+Act_Void+ "|| Actual :  Void values was :" + Act_Void_Count);
				   Extent_fail(driver,"Not Matched || Expected || Void values was : "+Act_Void+ "|| Actual :  Void values was :" + Act_Void_Count,test, test1);
			}
			
		
		Step_End(6, " Verify when apply filter for active/Void whether the particular data is getting filtered based on selection.", test, test1);
		
		Step_Start(7, " Verify the result whether functionality is working properly.", test, test1);
       
		
		waitForElement(driver, SSC_Status);
		String Status_Void_act =getText(driver, SSC_Status);
		
		
		if(Status_Void_act.equals(Status_Void)) {
			
			   System.out.println("Matched || Expected || Status values was : "+Status_Void+ "|| Actual :  Status values was :" + Status_Void_act);
			   Extent_pass_New(driver,"Matched || Expected || Status values was : "+Status_Void+ "|| Actual :  Status values was :" + Status_Void_act,test, test1);

		}else {
			
			 System.out.println("Not Matched || Expected || Status values was : "+Status_Void+ "|| Actual :  Status values was :" + Status);
			  Extent_fail(driver,"Not Matched || Expected || Status values was : "+Status_Void+ "|| Actual :  Status values was :" + Status,test, test1);
			
		}
		
		Step_End(7, " Verify the result whether functionality is working properly.", test, test1);

		
		 Extent_completed(testcase_Name, test, test1);

		
		
}
}