package LRP_Operations_Load_Confirmation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Load_Confirmation_SC_LC_03 extends Keywords{
	public void Load_Confirmation_SC_LC_03(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Load_Confirmation_SC_LC_03";
		
		


		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String AgencyUser =Excel_data.get("AgencyUser");
		String loadConfirmationModule =Excel_data.get("loadConfirmationModule");
		String first_service_data =Excel_data.get("first_service_data");
		String vesselCode =Excel_data.get("vesselCode");
		String Voyagenumber1 =Excel_data.get("Voyagenumber1");
		String Boundinput =Excel_data.get("Boundinput");
		String portCode =Excel_data.get("portCode");
		String terminalCode =Excel_data.get("terminalCode");
		String Container_num = Excel_data.get("Container_num");
		String loadconfimationpopupmessage = Excel_data.get("loadconfimationpopupmessage");
		String App_Date =Excel_data.get("App_Date");
		String date_Picker =Excel_data.get("date_Picker");
		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		
		// Login
		LRP_Login(driver, Username, Password);

//			Switch the Profile
			
				SwitchProfile(driver, AgencyUser);
				
			
				
		// Module search
				Step_Start(1, " Create containerized Booking and capture the book number.", test, test1);

				moduleNavigate(driver, loadConfirmationModule);
			
		
		waitForElement(driver, L_loadConfirmation_Tab);
		
		
// Search Module
		Step_End(1, "For container button need to add one method based on plugin RRO", test, test1);


		Step_Start(2, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);
//	Select service
		waitForElement(driver, L_service_Searchfield);
		selectservice(driver, first_service_data, vesselCode, Voyagenumber1, Boundinput, portCode, terminalCode);
		
		
		Step_End(2, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);
		
	
		Step_Start(3, " click show button.", test, test1);
		
		waitForElement(driver, L_show_Button);
		click(driver, L_show_Button);
		
		Step_End(3, "click show button.", test, test1);
if(date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime(driver, activity_date, App_Date);
			
			}
		
		Step_Start(4, " paste the bulk Container numbers in container number no grid.", test, test1);

		sendKeys(driver, container_no, Container_num);
		
		Step_End(4, "paste the bulk Container numbers in container number no grid.", test, test1);
		
		Step_Start(5, " Give enter", test, test1);
		
		enter(driver);
		
		Step_End(5, "Give enter", test, test1);
		
		Step_Start(6, " Click match button.", test, test1);
		
		
		
		
		waitForElement(driver, match_button);
		click(driver, match_button);
		
		Step_End(6, " Click match button.", test, test1);
			
		Step_Start(7, " click load confirmation button.", test, test1);
		waitForElement(driver, L_loadConfirmation_Button);
		click(driver, L_loadConfirmation_Button);
		waitForPopup(driver, popup_Message, loadconfimationpopupmessage);    
        String SaveRate_PopUp2= getText(driver, popup_Message);
		Step_End(7, "click load confirmation button.", test, test1);
       
		Step_Start(8, "system will display the message as \"load confirmed. Container(s) are automatically moved to EMS after 5 mins\".", test, test1);
		if(loadconfimationpopupmessage.contains(SaveRate_PopUp2)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + SaveRate_PopUp2);   
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + SaveRate_PopUp2, test, test1);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + SaveRate_PopUp2);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + SaveRate_PopUp2, test,test1); 
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
				
				Step_End(8, "system will display the message as \"load confirmed. Container(s) are automatically moved to EMS after 5 mins\".", test, test1);
			
				Extent_completed(testcase_Name, test, test1);
	
	
	}
		
	}


