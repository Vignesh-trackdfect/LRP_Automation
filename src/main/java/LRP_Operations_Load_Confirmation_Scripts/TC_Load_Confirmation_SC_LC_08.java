package LRP_Operations_Load_Confirmation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.LoadConfirmation_Locators;

public class TC_Load_Confirmation_SC_LC_08 extends Keywords {

	public void Load_Confirmation_SC_LC_08(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		
		String testcase_Name="TC_Load_Confirmation_SC_LC_08";
		
		


		
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
		String Booking_id= Excel_data.get("Booking_id");
		String Confirmation_msg=Excel_data.get("Confirmation_msg");
		String Containerized_Button=Excel_data.get("Containerized_Button");
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

	
	
//		Load Confirmation module
		System.out.println("********** Enter Load Confirmation module **********");
		Extent_call(test, test1,"********** Enter Load Confirmation module **********");
		Step_Start(1, " Create containerized Booking and capture the book number.", test, test1);
		
		
		

		moduleNavigate(driver, loadConfirmationModule);
		
		waitForElement(driver, L_loadConfirmation_Tab);
		
		

		
		Step_End(1, " Create containerized Booking and capture the book number.", test, test1);
		
		Step_Start(2, "select non-containerized button.", test, test1);
	
		
		
		
			String Container_click=String.format(LoadConfirmation_Locators.Containerr, Containerized_Button);
			click(driver, Container_click);
			
			
		
		Step_End(2, "select non-containerized button.", test, test1);

//	Select service
		
		Step_Start(3, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);
		waitForElement(driver, L_service_Searchfield);
		selectservice(driver, first_service_data, Vessels, Voyagenumber1, Boundinput, portCode, terminalCode);
		
		
		
		
		Step_End(3, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

		
		
		Step_Start(4, "click show button..", test, test1);
		waitForElement(driver, bookingnumber);
		click(driver, L_show_Button);
		
		Step_End(4, "click show button..", test, test1);
if(date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime(driver, activity_date, App_Date);
			
			}
		
		Step_Start(5, "paste the book number in the book.no column to filter your booking.", test, test1);
		
		
		
		waitForElement(driver, bookingnumber);
		sendKeys(driver, bookingnumber, Booking_id);	
		
		Step_End(5, "paste the book number in the book.no column to filter your booking.", test, test1);
		
		
		
		Step_Start(6, "click select all button and make sure all the check box of the booking is selected.", test, test1);

		
		
		waitForElement(driver, selectall);
		click(driver, selectall);
		
		
		
	
		
		Step_End(6, "click select all button and make sure all the check box of the booking is selected.", test, test1);

		
		
		
		Step_Start(7, "click load confirmation button.", test, test1);

		waitForElement(driver,L_loadConfirmation_Button);
		safeclick(driver, L_loadConfirmation_Button);
		
		
		Step_End(7, "click load confirmation button.", test, test1);
		
		
		
		Step_Start(8, "system will display the message as \"\"load confirmed\".", test, test1);
	
		
		waitForPopup(driver, popup_Message, Confirmation_msg);    
        String SaveRate_PopUp2= getText(driver, popup_Message);
        
       
        
       
	
			if(Confirmation_msg.contains(SaveRate_PopUp2)) {
				System.out.println("Matched || Expected value popup was : "+Confirmation_msg+" || Actual value popup was : "+SaveRate_PopUp2);
				Extent_pass_New(driver, "Matched || Expected value popup was : "+Confirmation_msg+" || Actual value popup was : "+SaveRate_PopUp2, test, test1);
		           //System.out.println("Submit button clicked");
			}
			else {
				System.out.println("NotMatched || Expected value popup was : "+Confirmation_msg+" || Actual value popup was : "+SaveRate_PopUp2);
				Extent_fail(driver,  "NotMatched || Expected value popup was : "+Confirmation_msg+" || Actual value popup was : "+SaveRate_PopUp2, test, test1);
			}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(8, "system will display the message as \"\"load confirmed\".", test, test1);
			
			Extent_completed(testcase_Name, test, test1);
		
		}
	}



