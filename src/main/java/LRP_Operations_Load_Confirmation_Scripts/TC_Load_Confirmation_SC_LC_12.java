package LRP_Operations_Load_Confirmation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Load_Confirmation_SC_LC_12 extends Keywords{

		public void Load_Confirmation_SC_LC_12(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
			String testcase_Name="TC_Load_Confirmation_SC_LC_12";
			
			
	
	

			
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
			String booking_No= Excel_data.get("Booking_No");
			String load_confirmation_popup=Excel_data.get("load_confirmation_popup");
			String App_Date =Excel_data.get("App_Date");
			String date_Picker =Excel_data.get("date_Picker");
			
			
			
			//locator
		
	  
			
			Extent_Start(testcase_Name, test, test1);
			
			
			navigateUrl(driver, url);

			
			LRP_Login(driver, Username, Password);
		
		
			
			
////		Switch the Profile
			
			SwitchProfile(driver, AgencyUser);
			
//			Load Confirmation module

			
			moduleNavigate(driver, loadConfirmationModule);
			
			
			Step_Start(1, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

			waitForElement(driver, L_service_Searchfield);
			selectservice(driver, first_service_data, Vessels, Voyagenumber1, Boundinput, portCode, terminalCode);
			
			Step_End(1, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

			Step_Start(2, "Clicking show button", test, test1);

			Extent_call(test, test1, "clicking show button");
			waitForElement(driver, L_show_Button);
			click(driver, L_show_Button);
			Step_End(2, "Clicking show button", test, test1);
if(date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, activity_date, App_Date);
				
				}
			
			Step_Start(3, "paste the book number in the book.no column to filter your booking.", test, test1);
waitForElement(driver, bookingnumber);
			sendKeys(driver, bookingnumber, booking_No);
			Step_End(3, "paste the book number in the book.no column to filter your booking.", test, test1);
			Step_Start(4, "click select all button and make sure all the check box of the booking is selected.", test, test1);
			waitForElement(driver, select_All_Btn);
			click(driver, select_All_Btn);
			Step_End(4, "click select all button and make sure all the check box of the booking is selected.", test, test1);

			//add checkbox verifi
			
		//	checkBox(driver, File_Path, load_Confirmed_Expected1);
			Step_End(4, "Sending the book no data and click select all button", test, test1);
			
			Step_Start(5, "click load confirmation button", test, test1);
			waitForElement(driver, L_loadConfirmation_Button);
			click(driver, L_loadConfirmation_Button);
			Step_End(5, "click load confirmation button", test, test1);
			
			
			Step_Start(6, " system will display the message as load confirmed.Container(s) are automatically moved to EMS after 5 mins", test, test1);
			//getting the text from the popup
			waitForPopup(driver, popup_Message, load_confirmation_popup);    
			String loadconfimationpopupmessage = getText(driver, popup_Message);
			System.out.println(loadconfimationpopupmessage);
			
			if(load_confirmation_popup.contains(loadconfimationpopupmessage)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup);   
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup, test, test1);
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP  is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup, test,test1); 
			} 
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(6, " system will display the message as load confirmed.Container(s) are automatically moved to EMS after 5 mins", test, test1);

			

			Extent_completed(testcase_Name, test, test1);


			
			
		}
}
