package LRP_Operations_Load_Confirmation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Load_Confirmation_SC_LC_10 extends Keywords {
	
public void Load_Confirmation_SC_LC_10(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

	String testcase_Name="TC_Load_Confirmation_SC_LC_10";
	
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("Module_Search");
		String agencyUser = Excel_data.get("agencyUser");
		String Servicecode = Excel_data.get("Service_code");
		String vesselCode = Excel_data.get("vesselCode");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String filepath = Excel_data.get("filepath");
		String load_confirmation_popup = Excel_data.get("load_confirmation_popup");
		String App_Date =Excel_data.get("App_Date");
		String date_Picker =Excel_data.get("date_Picker");
	
	
		
	
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		
		// Login
		LRP_Login(driver, Username, Password);

//			Switch the Profile
			
				SwitchProfile(driver, agencyUser);
				
			
				
		// Module search
				Step_Start(1, " Create containerized Booking and capture the book number.", test, test1);

				moduleNavigate(driver, search_module);
			
		
		
	
//				Select service
	  Step_Start(1," Enter the service, vessel, voyage and terminal details.", test, test1);
		waitForElement(driver, L_load_servicecode);
		selectservice(driver, Servicecode, vesselCode, Voyagenumber1, Boundinput, portCode, terminalCode);
		
		

		
		
		
			 Step_End(1," Enter the service, vessel, voyage and terminal details.", test, test1);
			 Step_Start(2," Click show button.", test, test1);
			waitForElement(driver, L_show_Button);
			click(driver, L_show_Button);
			waitForElement(driver, L_show_Button);
			 Step_End(2," Click show button.", test, test1);
			 if(date_Picker.equalsIgnoreCase("Yes")) {
					
					selectDatePickerWithTime(driver, activity_date, App_Date);
					
					}
		    
		    Step_Start(3,"click import template button", test, test1);
		    Step_Start(4," import the file.", test, test1);
		    uploadfile(driver, import_template,filepath);
		 
		    
		    Step_End(3,"click import template button", test, test1);
		    Step_End(4," import the file.", test, test1);
		  

		 
		   
			

			Step_Start(5," if pop-up window is displayed, close it and click load confirmation button.", test, test1);

			
				
			isdisplayed(driver, close_button);
			if(isDisplayed(driver, close_button)) {
				
				click(driver, close_button);	
					
			}
			Step_End(5," if pop-up window is displayed, close it and click load confirmation button.", test, test1);

			
			
			   waitForElement(driver, L_loadConfirmation_Button);
				click(driver, L_loadConfirmation_Button);
				
				
				waitForDisplay(driver, close_button);
				if(isDisplayed(driver, close_button)) {
					
					click(driver, close_button);

					   waitForElement(driver, L_loadConfirmation_Button);
						click(driver, L_loadConfirmation_Button);
						
						
				}
				

			
			Step_Start(6,"system will display the message as 'load confirmed. Container(s) are automatically moved to EMS after 5 mins'.", test, test1);

			waitForPopup(driver, popup_Message, load_confirmation_popup);    
			String loadconfimationpopupmessage = getText(driver, popup_Message);
			System.out.println(loadconfimationpopupmessage);
			
			if(load_confirmation_popup.contains(loadconfimationpopupmessage)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup);   
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup, test, test1);
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup, test,test1); 
			} 
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(6,"system will display the message as 'load confirmed. Container(s) are automatically moved to EMS after 5 mins'.", test, test1);

			Extent_completed(testcase_Name, test, test1);

}


}
