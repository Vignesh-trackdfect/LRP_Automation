package LRP_Operations_Discharge_Confirmation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Discharge_Confirmation_SC_DC_03 extends Keywords{


	public void Discharge_Confirmation_SC_DC_03(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testcase_Name="TC_Discharge_Confirmation_SC_DC_03";
		
		




		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String AgencyUser =Excel_data.get("AgencyUser");
		String DischargeConfirmationModule =Excel_data.get("DischargeConfirmationModule");
		String first_service_data =Excel_data.get("first_service_data");
		String vesselCode =Excel_data.get("vesselCode");
		String Voyagenumber1 =Excel_data.get("Voyagenumber1");
		String Boundinput =Excel_data.get("Boundinput");
		String portCode =Excel_data.get("portCode");
		String terminalCode =Excel_data.get("terminalCode");
		String discharge_popup=Excel_data.get("discharge_popup");
		String Book_Num = Excel_data.get("Book_Num");
		String date_Picker = Excel_data.get("date_Picker");
		String Activity_Date=Excel_data.get("Activity_Date");


		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		// Login

		LRP_Login(driver, Username, Password);

		// Switch the Profile

		SwitchProfile(driver, AgencyUser);
		// Load Confirmation module	

		moduleNavigate(driver, DischargeConfirmationModule);

		// Select service
		Step_Start(1, "select the service, vessel, voyage, bound, port code, and terminal using easy search", test, test1);
		selectservice_Discharge(driver, first_service_data, vesselCode, Voyagenumber1, Boundinput, portCode, terminalCode);

		Step_End(1, "select the service, vessel, voyage, bound, port code, and terminal using easy search", test, test1);
		Step_Start(2, "click show button", test, test1);

		waitForElement(driver, Dshow_Button_Discharge);
		click(driver, Dshow_Button_Discharge);

		Step_End(2, "click show button", test, test1);
	if(date_Picker.equalsIgnoreCase("Yes")) {
			
		selectDatePickerWith_Time(driver, Ddischarge_activity_date, Activity_Date);
			
			}

		Step_Start(3, "click book. No button", test, test1);
		waitForElement(driver, DBook_number_btn);
		click(driver, DBook_number_btn);
		Step_End(3, "click book. No button", test, test1);


		Step_Start(4, "paste the book numbers in book number grid", test, test1);
		waitForElement(driver, Dcontainer_no_Discharge);
		sendKeys(driver, Dcontainer_no_Discharge, Book_Num);

		Step_End(4, "paste the book numbers in book number grid", test, test1);

		Step_Start(5, "Give enter", test, test1);
		enter(driver);

		Step_End(5, "Give enter", test, test1);

		Step_Start(6, "Click match button", test, test1);
		waitForElement(driver, Dmatch_button_Discharge);
		click(driver, Dmatch_button_Discharge);	

		Step_End(6, "Click match button", test, test1);
		Step_Start(7, "click discharge confirmation button", test, test1);
		waitForElement(driver, DDischargeconfirmation);
		click(driver, DDischargeconfirmation);	

		Step_End(7, "click discharge confirmation button", test, test1);

		Step_Start(8, "system will display the message as \"discharge is confirmed\"", test, test1);
		waitForPopup(driver, Popup_Message, discharge_popup);
	
		String SaveRate_PopUp2= getText(driver, Popup_Message);			       


	
			if(discharge_popup.equals(SaveRate_PopUp2)) {
				System.out.println("Matched || Expected value POPUP was : "+discharge_popup+" || Actual value POPUP was : "+SaveRate_PopUp2);
				Extent_pass_New(driver, "Matched || Expected value POPUP was : "+discharge_popup+" || Actual value POPUP was : "+SaveRate_PopUp2, test, test1);
			}
			else {
				System.out.println("NotMatched || Expected value POPUP was : "+discharge_popup+" || Actual value POPUP was : "+SaveRate_PopUp2);
				Extent_fail(driver,  "NotMatched || Expected value POPUP was : "+discharge_popup+" || Actual value POPUP was : "+SaveRate_PopUp2, test, test1);
			}
		
		Step_End(8, "system will display the message as \"discharge is confirmed\"", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}				