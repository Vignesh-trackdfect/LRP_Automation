package LRP_Operations_Discharge_Confirmation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Discharge_Confirmation_Locators;

public class TC_Discharge_Confirmation_SC_DC_07 extends Keywords {

	public void Discharge_Confirmation_SC_DC_07(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Discharge_Confirmation_SC_DC_07";
		
		





		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");	
		String first_service_data1 = Excel_data.get("first_service_data1");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String DischargeConfirmationModule = Excel_data.get("DischargeConfirmationModule");
		String Confirmation_msg1=Excel_data.get("Confirmation_msg1");
		String Containerized_Button=Excel_data.get("Containerized_Button");
		String VINChassis_No_Book_No= Excel_data.get("VINChassis_No_Book_No");
		String vinChassis_BookNo_select= Excel_data.get("vinChassis_BookNo_select");
		String Plugin_Configuration= Excel_data.get("Plugin_Configuration");
		String Module_id=Excel_data.get("Module_id");
		String Plugin_ID=Excel_data.get("Plugin_ID");
		String Status_exp=Excel_data.get("Status_exp");
		String date_Picker = Excel_data.get("date_Picker");
		String Activity_Date=Excel_data.get("Activity_Date");







		Extent_Start(testcase_Name, test, test1);


		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyUser);


	
		
		// Plugin configiration



		//		Load Confirmation module
				moduleNavigate(driver, DischargeConfirmationModule);

	

			String Container_click=String.format(Discharge_Confirmation_Locators.DContainer_Select, Containerized_Button);
			click(driver, Container_click);

		

		//	Select service

		Step_Start(1, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);

		selectservice_NonDischarge(driver, first_service_data1, Vessels, Voyagenumber1, Boundinput, portCode, terminalCode);



		Step_End(1, "select the service, vessel, voyage, bound, port code, and terminal using easy search.", test, test1);



		Step_Start(2, "click show button", test, test1);
		waitForElement(driver, DDischarge_Show_Button);
		click(driver, DDischarge_Show_Button);

		Step_End(2, "click show button", test, test1);
	if(date_Picker.equalsIgnoreCase("Yes")) {
			
		selectDatePickerWith_Time(driver, Ddischarge_activity_date, Activity_Date);
			
			}
		Step_Start(3, "click VIN/chassis or book number", test, test1);

		String BookNo_select = String.format(Discharge_Confirmation_Locators.VinChassis_BookNo_Select, vinChassis_BookNo_select);
		waitForElement(driver, BookNo_select);
		click(driver, BookNo_select);

		Step_End(3, "click VIN/chassis or book number", test, test1);


		Step_Start(4, "paste the bulk VIN/chassis numbers in VIN/chassis no grid.", test, test1);

		waitForElement(driver, DDischarge_VIN_Chassis_No);
		sendKeys(driver,DDischarge_VIN_Chassis_No ,VINChassis_No_Book_No);

		Step_End(4, "paste the bulk VIN/chassis numbers in VIN/chassis no grid.", test, test1);


		Step_Start(5, "Give Enter", test, test1);

		enter(driver);

		Step_End(5, "Give Enter", test, test1);


		Step_Start(6, "Click match button.", test, test1);

		waitForElement(driver,DMatch1);
		click(driver, DMatch1);

		Step_End(6, "Click match button.", test, test1);


		Step_Start(7, "click Discharge confirmation button.", test, test1);

		waitForElement(driver,DDischarge_Confirmation);
		safeclick(driver, DDischarge_Confirmation);


		Step_End(7, "click Discharge confirmation button.", test, test1);



		Step_Start(8, "system will display the message as \"discharge is confirmed\".", test, test1);
		
		waitForPopup(driver, Popup_Message, Confirmation_msg1);    
		String SaveRate_PopUp2= getText(driver, Popup_Message);


			if(Confirmation_msg1.equals(SaveRate_PopUp2)) {
				System.out.println("Matched || Expected value POPUP was : "+Confirmation_msg1+" || Actual value POPUP was : "+SaveRate_PopUp2);
				Extent_pass_New(driver, "Matched || Expected value POPUP was : "+Confirmation_msg1+" || Actual value POPUP was : "+SaveRate_PopUp2, test, test1);
			}
			else {
				System.out.println("NotMatched || Expected value POPUP was : "+Confirmation_msg1+" || Actual value POPUP was : "+SaveRate_PopUp2);
				Extent_fail(driver,  "NotMatched || Expected value POPUP was : "+Confirmation_msg1+" || Actual value POPUP  was : "+SaveRate_PopUp2, test, test1);
			}


			Step_End(8, "system will display the message as \"discharge is confirmed\".", test, test1);

			Extent_completed(testcase_Name, test, test1);



			


	}
}


