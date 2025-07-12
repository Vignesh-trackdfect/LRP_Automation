package LRP_Operations_Load_Confirmation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import locators.LoadConfirmation_Locators;



public class TC_Load_Confirmation_SC_LC_13 extends Keywords {
	
	public void Load_Confirmation_SC_LC_13(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Load_Confirmation_SC_LC_13";
		
		


		
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
		String expected_Popup=Excel_data.get("Pop_Up_Validation");
		String base_Book_no=Excel_data.get("Base_Book_no");
		String dest_Book_no=Excel_data.get("Dest_Book_no");
		String App_Date =Excel_data.get("App_Date");
		String date_Picker =Excel_data.get("date_Picker");
		
	
		
        Extent_Start(testcase_Name, test, test1);
		
		
		navigateUrl(driver, url);

		

		LRP_Login(driver, Username, Password);

	
	
		
		//	Switch the Profile
		SwitchProfile(driver, AgencyUser);
		
				
		// Module search
		Step_Start(1, " Create containerized Booking and capture the book number.", test, test1);
		moduleNavigate(driver, loadConfirmationModule);
		
			
				
				Step_End(1, " Create containerized Booking and capture the book number.", test, test1);
		Step_Start(2, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

		waitForElement(driver, L_service_Searchfield);
		selectservice(driver, first_service_data, Vessels, Voyagenumber1, Boundinput, portCode, terminalCode);
		
		
		Step_End(2, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

		Step_Start(3, "Clicking show button", test, test1);

		Extent_call(test, test1, "clicking show button");
		waitForElement(driver, L_show_Button);
		safeclick(driver, L_show_Button);
		Step_End(3, "Clicking show button", test, test1);
		if(date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime(driver, activity_date, App_Date);
			
			}
		
	
		
		Step_Start(4, "paste the book number in the book.no column to filter your booking.", test, test1);
		waitForElement(driver, bookingnumber);
		sendKeys(driver, bookingnumber, base_Book_no);
		Step_End(4, "paste the book number in the book.no column to filter your booking.", test, test1);
		Step_Start(5, " Double click on the actual container number field..", test, test1);
	
		
		
		
		List<String> number = splitAndExpand(dest_Book_no);
		for(int i=1; i<=number.size(); i++) {
			String actual_container=String.format(LoadConfirmation_Locators.actual_containerr, i);

			doubleClick(driver, actual_container);
			
			Actionsendkeys(driver, actual_container, number.get(i-1));

			}

		
		
		
		
		
		
		
		
//		waitForElement(driver, base_Container_Field);
//		doubleClick(driver, base_Container_Field);
		Step_End(5, " Double click on the actual container number field..", test, test1);
		Step_Start(6, " paste the actual container number in actual container number column for booking.", test, test1);
	//	Actionsendkeys(driver, base_Container_Field, dest_Book_no);
		Step_End(6, " paste the actual container number in actual container number column for booking.", test, test1);

	Extent_call(test, test1, "clicking on the checkbox");
	Step_Start(7, "click select all button and make sure all the check box of the booking is selected.", test, test1);
        waitForElement(driver, selectall);
        safeclick(driver, selectall);
    	Step_End(7, "click select all button and make sure all the check box of the booking is selected.", test, test1);
        Step_Start(8, "click load confirmation button", test, test1);
		safeclick(driver, L_loadConfirmation_Button);
		Step_End(8, "click load confirmation button", test, test1);
		Step_Start(9, "system will display the message as \"The Following Container No(s) had already planned for the Same Service, Vessel, Voyage, Bound.\"", test, test1);
		waitForPopup(driver, gettextpop, expected_Popup);    
		String actual_Popup = getText(driver, gettextpop);
		System.out.println(actual_Popup);
		
		
		if(expected_Popup.equals(actual_Popup)) {
			
			Extent_pass_New(driver, "Matched: Expected "+expected_Popup+"and actual popup|| "+actual_Popup+"are same", test, test1);
			System.out.println("Matched: Expected "+expected_Popup+"and actual popup|| "+actual_Popup+"are same");
		}
		else {
			System.out.println("Not Matched: Expected "+expected_Popup+"and actual popup|| "+actual_Popup+"are not same");
			Extent_fail(driver, "Not Matched: Expected "+expected_Popup+"and actual popup|| "+actual_Popup+"are not same", test, test1);
		
			
		}
		Step_End(9, "system will display the message as \"The Following Container No(s) had already planned for the Same Service, Vessel, Voyage, Bound.\"", test, test1);
		Extent_completed(testcase_Name, test, test1);
		

	
	}
}
