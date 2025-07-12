package LRP_Operations_Discharge_Confirmation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Discharge_Confirmation_SC_DC_01 extends Keywords{
	
	public void Discharge_Confirmation_SC_DC_01(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		

		String testcase_Name="TC_Discharge_Confirmation_SC_DC_01";
		
		



		
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
		String Bookingnumber = Excel_data.get("Bookingnumber");
		String discharge_popup=Excel_data.get("discharge_popup");
		String date_Picker = Excel_data.get("date_Picker");
		String Activity_Date=Excel_data.get("Activity_Date");
		

		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login
		LRP_Login(driver, Username, Password);
      // Switch the Profile

//				Switch the Profile
		SwitchProfile(driver, agencyUser);
				
		// Module search
				
		moduleNavigate(driver, search_module);
				
				
				
        //	Select service
				
				Step_Start(1,"select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

				selectservice_Discharge(driver, Servicecode, vesselCode, Voyagenumber1, Boundinput, portCode, terminalCode);
				
					Step_End(1,"select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

					
					Step_Start(2,"click show button.", test, test1);

					
					waitForElement(driver, Ddischargeshow_Button);
					click(driver, Ddischargeshow_Button);
		
					
					Step_End(2,"click show button.", test, test1);

					if(date_Picker.equalsIgnoreCase("Yes")) {
						
						selectDatePickerWith_Time(driver, Ddischarge_activity_date, Activity_Date);
						
						}
					Step_Start(3,"paste the captured book number in the book.no column to filter your booking.", test, test1);

					
					waitForElement(driver, Ddischarge_bookingnumber);

					click(driver, Ddischarge_bookingnumber);
					sendKeys(driver, Ddischarge_bookingnumber, Bookingnumber);
					
					Step_End(3,"paste the captured book number in the book.no column to filter your booking.", test, test1);

					
					Step_Start(4,"click select all button and make sure all the check box of the booking is selected.", test, test1);

					
					waitForElement(driver, Ddischargeselectall);
					click(driver, Ddischargeselectall);
					
					Step_End(4,"click select all button and make sure all the check box of the booking is selected.", test, test1);

					Step_Start(5,"click discharge confirmation button.", test, test1);

					waitForElement(driver, Ddischargeconfirmation_btn);
					click(driver, Ddischargeconfirmation_btn);
					
					Step_End(5,"click discharge confirmation button.", test, test1);

					Step_Start(6,"system will display the message as 'discharge is confirmed'.", test, test1);

					waitForPopup(driver, Popup_Message, discharge_popup);    
					String dischargeconfimationpopupmessage = getText(driver, Popup_Message);
					System.out.println(dischargeconfimationpopupmessage);
					
					if(discharge_popup.contains(dischargeconfimationpopupmessage)) {                                                                                                                  
						System.out.println("Matched || " + " Expected Report Activity POPUP is : " + dischargeconfimationpopupmessage + " || Actual Report Activity POPUP is : " + discharge_popup);   
						Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + dischargeconfimationpopupmessage + " || Actual Report Activity POPUP is : " + discharge_popup, test, test1);
					}                                                                                                                                                                        
					else {                                                                                                                                                                   
						System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + dischargeconfimationpopupmessage + " || Actual Report Activity POPUP is : " + discharge_popup);        
						Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + dischargeconfimationpopupmessage + " || Actual Report Activity POPUP is : " + discharge_popup, test,test1); 
					} 
						
					Step_End(6,"system will display the message as 'discharge is confirmed'.", test, test1);

					Extent_completed(testcase_Name, test, test1);
	}

}
