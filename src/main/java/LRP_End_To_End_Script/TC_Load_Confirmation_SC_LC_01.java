
package LRP_End_To_End_Script;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;




public class TC_Load_Confirmation_SC_LC_01 extends Keywords{

	public void Load_Confirmation_SC_LC_01(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Load_Confirmation_SC_LC_01";
		
		


		
		
//		String Username = Excel_data.get("Username");
//		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("Agency_user");
		String search_module = Excel_data.get("Module_Search_LC");
		String Servicecode = Excel_data.get("Service_Code_new");
		String Add_Vessels = Excel_data.get("Add_Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("origin");
		String terminalCode = Excel_data.get("POL_Terminal_Input_Routing");
		String App_Date =Excel_data.get("StartDate");
		String date_Picker =Excel_data.get("DatePicker");
		String Bookingnumber = Excel_data.get("New_Booking_Number");
		String load_confirmation_popup = Excel_data.get("load_confirmation_popup");
	
	
	
		
		Extent_Start(testcase_Name, test, test1);
//		navigateUrl(driver, url);
		
// Login
		
		

//		LRP_Login(driver, Username, Password);



//	Switch the Profile
	
		SwitchProfile(driver, agencyUser);
		
	
		
// Module search
		Step_Start(1, " Create containerized Booking and capture the book number.", test, test1);

		moduleNavigate(driver, search_module);

		
		
	
		Step_Start(2,"select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);
////	Select service
		waitForElement(driver, L_load_servicecode);
		List<String> vesselCodes = splitAndExpand(Add_Vessels, ",");
		selectservice(driver, Servicecode, vesselCodes.get(0), Voyagenumber1, Boundinput, portCode, terminalCode);

		
			Step_End(2,"select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

			Step_Start(3,"click show button.", test, test1);

			waitForElement(driver, L_show_Button);
			waitForElement(driver, L_show_Button);
			click(driver, L_show_Button);
			
			Step_End(3,"click show button.", test, test1);

			
		if(date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime_CS(driver, activity_date, App_Date);
			
			}
				
			Step_Start(4,"paste the captured book number in the book.no column to filter your booking.", test, test1);

			
			waitForElement(driver, bookingnumber);

			click(driver, bookingnumber);
			sendKeys(driver, bookingnumber, Bookingnumber);
			
			Step_End(4,"paste the captured book number in the book.no column to filter your booking.", test, test1);
			
			Step_End(1, " Create containerized Booking and capture the book number.", test, test1);
			Step_Start(5,"click select all button and make sure all the check box of the booking is selected.", test, test1);
			waitForElement(driver, selectall);
			click(driver, selectall);
			
			Step_End(5,"click select all button and make sure all the check box of the booking is selected.", test, test1);

			Step_Start(6,"click load confirmation button.", test, test1);

			
			waitForElement(driver, L_loadConfirmation_Button);
			click(driver, L_loadConfirmation_Button);
			
			Step_End(6,"click load confirmation button.", test, test1);

			Step_Start(7,"system will display the message as load confirmed. Container(s) are automatically moved to EMS after 5 mins", test, test1);

			waitForPopup(driver, popup_Message, load_confirmation_popup);     
			String loadconfimationpopupmessage = getText(driver, popup_Message);
			System.out.println(loadconfimationpopupmessage);
			
			if(load_confirmation_popup.contains(loadconfimationpopupmessage)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + load_confirmation_popup);   
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + load_confirmation_popup, test, test1);
			Extent_call(test, test1, loadconfimationpopupmessage);
			
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + load_confirmation_popup);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity popup is : " + loadconfimationpopupmessage + " || Actual Report Activity popup is : " + load_confirmation_popup, test,test1); 
			} 
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(7,"system will display the message as load confirmed. Container(s) are automatically moved to EMS after 5 mins", test, test1);

			Extent_completed(testcase_Name, test, test1);

	}
	

	
}
