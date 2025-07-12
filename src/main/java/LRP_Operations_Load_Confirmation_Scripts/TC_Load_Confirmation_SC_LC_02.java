package LRP_Operations_Load_Confirmation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.LoadConfirmation_Locators;

public class TC_Load_Confirmation_SC_LC_02 extends Keywords{
	
public void Load_Confirmation_SC_LC_02(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
	String testcase_Name="TC_Load_Confirmation_SC_LC_02";
	
			
	
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String search_module = Excel_data.get("Module_Search");
		String Servicecode = Excel_data.get("Service_code");
		String vesselCode = Excel_data.get("vesselCode");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String date_Picker =Excel_data.get("date_Picker");
		String App_Date =Excel_data.get("App_Date");
		String Bookingnumber = Excel_data.get("Bookingnumber");
		String Actual_Containerno_1 = Excel_data.get("Actual_Containerno_1");
		String load_confirmation_popup = Excel_data.get("load_confirmation_popup");
	
		
		
	
		
		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		
		// Login
		LRP_Login(driver, Username, Password);

//			Switch the Profile
			
				SwitchProfile(driver, agencyUser);
				
			
				
		// Module search
				Step_Start(1, " Create containerized Booking and capture the book number.", test, test1);

				moduleNavigate(driver, search_module);
			
		
		
		Step_Start(2,"select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

		waitForElement(driver, L_load_servicecode);
		selectservice(driver, Servicecode, vesselCode, Voyagenumber1, Boundinput, portCode, terminalCode);
		
// Select service
		
			
			Step_End(2,"select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

			Step_Start(3,"click show button.", test, test1);
			
			waitForElement(driver, L_show_Button);
		

			click(driver, L_show_Button);
			
			Step_End(3,"click show button.", test, test1);
			

			
			if(date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, activity_date, App_Date);
				
				}
			
			Step_Start(4,"paste the captured book number in the book.no column to filter your booking.", test, test1);

			
			waitForElement(driver, bookingnumber);

			click(driver, bookingnumber);
			sendKeys(driver, bookingnumber, Bookingnumber);
			
			Step_End(4,"paste the captured book number in the book.no column to filter your booking.", test, test1);
			Step_End(1, " Create containerized Booking and capture the book number.", test, test1);
		
			


			List<String> number = splitAndExpand(Actual_Containerno_1);
			for(int i=1; i<=number.size(); i++) {
				String actual_container=String.format(LoadConfirmation_Locators.actual_containerr, i);
				Step_Start(5," Double click on the actual container number field.", test, test1);

				doubleClick(driver, actual_container);
				Step_End(5," Double click on the actual container number field.", test, test1);
				Step_Start(6,"paste the actual container number in actual container number column for booking.", test, test1);
				
				Actionsendkeys(driver, actual_container, number.get(i-1));
				Step_End(6,"paste the actual container number in actual container number column for booking.", test, test1);

				}
 

			
			
			Step_Start(7,"click select all button and make sure all the check box of the booking is selected.", test, test1);

			
			click(driver, selectall);
			
			Step_End(7,"click select all button and make sure all the check box of the booking is selected.", test, test1);

			Step_Start(8,"click load confirmation button.", test, test1);

			
			waitForElement(driver, L_loadConfirmation_Button);
			click(driver, L_loadConfirmation_Button);
			
			Step_End(8,"click load confirmation button.", test, test1);

			Step_Start(9,"system will display the message as \"load confirmed. Container(s) are automatically moved to EMS after 5 mins\".", test, test1);

			waitForPopup(driver, popup_Message, load_confirmation_popup);    
			String loadconfimationpopupmessage = getText(driver, popup_Message);
			System.out.println(loadconfimationpopupmessage);
			
			if(load_confirmation_popup.contains(loadconfimationpopupmessage)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + load_confirmation_popup);   
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + load_confirmation_popup, test, test1);
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + load_confirmation_popup);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + load_confirmation_popup, test,test1); 
			} 
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(9,"system will display the message as \"load confirmed. Container(s) are automatically moved to EMS after 5 mins\".", test, test1);

			Extent_completed(testcase_Name, test, test1);
	
}

}
