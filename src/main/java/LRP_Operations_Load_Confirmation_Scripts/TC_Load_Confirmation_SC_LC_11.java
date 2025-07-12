package LRP_Operations_Load_Confirmation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Load_Confirmation_SC_LC_11 extends Keywords {


		public void Load_Confirmation_SC_LC_11(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

			String testcase_Name="TC_Load_Confirmation_SC_LC_11";
			
			
	
	
			
			
			String Username = Excel_data.get("Username");
			String Password = Excel_data.get("Password");
			String AgencyUser = Excel_data.get("AgencyUser");	
			String search_module = Excel_data.get("search_module");
			String first_service_data = Excel_data.get("first_service_data");
			String Vessels = Excel_data.get("Vessels");
			String Voyagenumber1 = Excel_data.get("Voyagenumber1");
			String Boundinput = Excel_data.get("Boundinput");
			String portCode = Excel_data.get("portCode");
			String terminalCode = Excel_data.get("terminalCode");
			String booking_No= Excel_data.get("Booking_No");
			String Pop_Up_Validation=Excel_data.get("Pop_Up_Validation");
			String agencyConfiguration=Excel_data.get("AgencyConfiguration");
			String description=Excel_data.get("AgencyDescription");
			String App_Date =Excel_data.get("App_Date");
			String date_Picker =Excel_data.get("date_Picker");
			String value =Excel_data.get("value");
			String Agency_search =Excel_data.get("Agency_Code_search");
			String Attribute_search =Excel_data.get("Attribute_search");
			String Attribute =Excel_data.get("Attribute");
			String Condition_Filter =Excel_data.get("Condition_Filter");
			String Agency_Configuration_Perform =Excel_data.get("Agency_Configuration_Perform");
			String load_confirmation_popup =Excel_data.get("load_confirmation_popup");
			
		
			//locator
		
	        
			
			
			Extent_Start(testcase_Name, test, test1);
			
			
			navigateUrl(driver, url);

			

			LRP_Login(driver, Username, Password);
		
////		Switch the Profile
			
			SwitchProfile(driver, AgencyUser);
			
			
			Step_Start(1," Ensure \"VGO\" configuration value is given as 2/1 in agency configuration.", test, test1);
			
			// Agency Configuration
					Extent_cal(test, test1, "Agency Configuration");

					
					
					if(Agency_Configuration_Perform.equalsIgnoreCase("YES")) {
					setAgencyConfiguration(driver, agencyConfiguration, Agency_search, Attribute_search, Condition_Filter, AgencyUser, Attribute, description, value);
					}else {
						
						System.out.println("Agency Configuration was not changed");
						Extent_call(test, test1, "Agency Configuration was not changed");
						
					}
					
					
					
					
					Step_End(1," Ensure \"VGO\" configuration value is given as 2/1 in agency configuration.", test, test1);
					
			
					
					


			

//			Load Confirmation module
		
			
					moduleNavigate(driver, search_module);
			
		
	
			
			Step_Start(2, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);
			
			waitForElement(driver, L_service_Searchfield);
			selectservice(driver, first_service_data, Vessels, Voyagenumber1, Boundinput, portCode, terminalCode);
			
			Step_End(2, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);
	
			Step_Start(3, "click show button.", test, test1);
			
			waitForElement(driver, L_show_Button);
			click(driver, L_show_Button);
			Step_End(3, "click show button.", test, test1);
			if(date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, activity_date, App_Date);
				
				}
			Step_Start(4, "paste the book number in the book.no column to filter your booking.", test, test1);
			
			waitForElement(driver, bookingnumber);
			sendKeys(driver, bookingnumber, booking_No);
			Step_End(4, "paste the book number in the book.no column to filter your booking.", test, test1);
			Step_Start(5, "click select all button and make sure all the check box of the booking is selected.", test, test1);
			waitForElement(driver, select_All_Btn);
			click(driver, select_All_Btn);
			Step_End(5, "click select all button and make sure all the check box of the booking is selected.", test, test1);
			

			Step_Start(6, "click load confirmation button.", test, test1);
	waitForElement(driver, L_loadConfirmation_Button);
			click(driver, L_loadConfirmation_Button);
			Step_End(6, "click load confirmation button.", test, test1);
			
			
			//getting the text from the popup
			if(value.equals("1")) {
				Step_Start(7," For configuration value 1, system will display the warning message \"VGM Not verified for below container(s).Could not proceed for Load confirmation\", close the message window and click load confirmation..", test, test1);
				waitForElement(driver, load_close);
				click(driver, load_close);
				waitForPopup(driver, popup_Message, load_confirmation_popup);    
				String loadconfimationpopupmessage = getText(driver, popup_Message);
				System.out.println(loadconfimationpopupmessage);
				
				if(load_confirmation_popup.contains(loadconfimationpopupmessage)) {                                                                                                                  
					System.out.println("Matched || " + " Expected Report Activity POPUP  is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup);   
					Extent_pass_New(driver, "Matched || " + " Expected Report Activity POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup, test, test1);
				Extent_call(test, test1, loadconfimationpopupmessage);
				
				}                                                                                                                                                                        
				else {                                                                                                                                                                   
					System.out.println("Not Matched || " + " Expected Report Activity POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup);        
					Extent_fail(driver, "Not Matched || " + " Expected Report Activity POPUP is : " + loadconfimationpopupmessage + " || Actual Report Activity POPUP is : " + load_confirmation_popup, test,test1); 
				} 
				
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
				Step_End(7," For configuration value 1, system will display the warning message \"VGM Not verified for below container(s).Could not proceed for Load confirmation\", close the message window and click load confirmation..", test, test1);
				}
		
		
			
			if(value.equals("2")) {
				Step_Start(8," For configuration; value 2, system will display the warning message \"VGM Not verified for below container(s).Could not proceed for Load confirmation\", close the message window and click load confirmation..", test, test1);
waitForDisplay(driver, error_validation);
waitForPopup(driver, error_validation, Pop_Up_Validation);    
			String loadconfimationpopupmessage = getText(driver, error_validation);
			System.out.println(loadconfimationpopupmessage);
			
	
			//comparing the expected and actual popup,
			if(loadconfimationpopupmessage.contains(Pop_Up_Validation)) {
				Extent_pass_New(driver,loadconfimationpopupmessage +"Popup is displayed", test, test1);
				Extent_pass_New(driver, "Matched || Expected popup: "+Pop_Up_Validation + "Actual  popup||"+loadconfimationpopupmessage, test, test1);
				System.out.println("Matched || Expected popup: "+Pop_Up_Validation + "Actual  popup||"+loadconfimationpopupmessage);
			}
			else {
				System.out.println( "Matched || Expected popup: "+Pop_Up_Validation + "Actual popup ||"+loadconfimationpopupmessage);
				Extent_fail(driver, "Matched || Expected popup: "+Pop_Up_Validation + "Actual popup ||"+loadconfimationpopupmessage, test, test1);
				
			}
			Step_End(8," For configuration value 2, system will display the warning message \"VGM Not verified for below container(s).Could not proceed for Load confirmation\", close the message window and click load confirmation..", test, test1);
			waitForElement(driver, ID_Ok_Button_ERR);
			click(driver, ID_Ok_Button_ERR);
		
			}
			Extent_completed(testcase_Name, test, test1);
		
		
		
}}