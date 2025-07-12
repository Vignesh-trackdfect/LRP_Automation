package LRP_Operations_Load_Confirmation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.LoadConfirmation_Locators;

public class TC_Load_Confirmation_SC_LC_09 extends Keywords {

	public void Load_Confirmation_SC_LC_09(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Load_Confirmation_SC_LC_09";
		
		


		
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");	
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String loadConfirmationModule = Excel_data.get("loadConfirmationModule");
		String Confirmation_msg=Excel_data.get("Confirmation_msg");
		String Containerized_Button=Excel_data.get("Containerized_Button");
		String VINChassis_No= Excel_data.get("VINChassis_No");
		String App_Date =Excel_data.get("App_Date");
		String date_Picker =Excel_data.get("date_Picker");
		String Plugin_Configuration = Excel_data.get("Plugin_Configuration");
	
		
		
		
		
		
		//locator
	
		Extent_Start(testcase_Name, test, test1);
		
		
navigateUrl(driver, url);
		
		// Login
LRP_Login(driver, Username, Password);

//			Switch the Profile
			
				SwitchProfile(driver, AgencyUser);
				
			
				
		// Module search
				Step_Start(1, " Create containerized Booking and capture the book number.", test, test1);

			
//				Load Confirmation module
			
			
				moduleNavigate(driver, loadConfirmationModule);
		
		waitForElement(driver, L_loadConfirmation_Tab);
		
		Step_End(1, " Create containerized Booking and capture the book number.", test, test1);
		
		

			
			String Container_click=String.format(LoadConfirmation_Locators.Containerr, Containerized_Button);
			click(driver, Container_click);
			
			

//	Select service
		
		Step_Start(2, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);
		
		waitForElement(driver, L_service_Searchfield);
		selectservice(driver, first_service_data, Vessels, Voyagenumber1, Boundinput, portCode, terminalCode);
		
		
		Step_End(2, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

		
		
		Step_Start(3, "click show button..", test, test1);
waitForElement(driver, L_show_Button);
		click(driver, L_show_Button);
		
		Step_End(3, "click show button..", test, test1);
		
		
if(date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime(driver, activity_date, App_Date);
			
			}
		
		Step_Start(4, "paste the bulk VIN/chassis numbers in VIN/chassis no grid.", test, test1);
		
		waitForElement(driver, VIN_Chassis_No);
	    sendKeys(driver,VIN_Chassis_No ,VINChassis_No);
	    
	    Step_End(4, "paste the bulk VIN/chassis numbers in VIN/chassis no grid.", test, test1);
	    
	   
	    Step_Start(5, "Give Enter", test, test1);
	    
	   enter(driver);
	    
	    Step_End(5, "Give Enter", test, test1);
	    
	    
	    Step_Start(6, "Click match button.", test, test1);
	 waitForElement(driver,Match );
	  click(driver, Match);
	  
	  Step_End(6, "Click match button.", test, test1);
	  
	  
	  
	  
	 
	  
	  Step_Start(7, "click load confirmation button.", test, test1);
	  
	   waitForElement(driver,L_loadConfirmation_Button);
		safeclick(driver, L_loadConfirmation_Button);
		
		
		Step_End(7, "click load confirmation button.", test, test1);
		
		
		
		Step_Start(8, "system will display the message as \"\"load confirmed\".", test, test1);
	
		waitForPopup(driver, popup_Message, Confirmation_msg);    
      String SaveRate_PopUp2= getText(driver, popup_Message);
      
     
      
     
	
			if(Confirmation_msg.contains(SaveRate_PopUp2)) {
				System.out.println("Matched || Expected value POPUP was : "+Confirmation_msg+" || Actual value POPUP was : "+SaveRate_PopUp2);
				Extent_pass_New(driver, "Matched || Expected value POPUP was : "+Confirmation_msg+" || Actual value POPUP was : "+SaveRate_PopUp2, test, test1);
			}
			else {
				System.out.println("NotMatched || Expected value POPUP was : "+Confirmation_msg+" || Actual value POPUP was : "+SaveRate_PopUp2);
				Extent_fail(driver,  "NotMatched || Expected value POPUP was : "+Confirmation_msg+" || Actual value POPUP was : "+SaveRate_PopUp2, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(8, "system will display the message as \"\"load confirmed\".", test, test1);
			
			Extent_completed(testcase_Name, test, test1);
		
		}
	}

	 
	 