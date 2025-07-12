package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC009 extends Keywords {

	public void CRO_SC009(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC009";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String Quantity_Value = Excel_data.get("Quantity_Value");
		String Quantity_Exceeds_Popup = Excel_data.get("Quantity_Exceeds_Popup");






		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		//	Switch the Profile
		SwitchProfile(driver, agencyUser);


		//		Booking module

		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);

	
		//	Create CRO

Step_Start(1, "Navigate CRO from booking.", test, test1);
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		Step_End(1, "Navigate CRO from booking.", test, test1);

		
		Step_Start(2, ":Click edit icon", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_End(2, "Click edit icon.", test, test1);
		
		Step_Start(3, "Click the container details in grid.", test, test1);

		waitForElement(driver, Container_Grid_First_row);
		doubleClick(driver, Container_Grid_First_row);
		
		Step_End(3, "Click the container details in grid.", test, test1);
		
		Step_Start(4, "Add quantity more then the booking quantity", test, test1);
		
		waitForElement(driver, Quantity_TF_CRO); 
		clear(driver, Quantity_TF_CRO);
		sendKeys(driver, Quantity_TF_CRO, Quantity_Value);
		
		Step_End(4, "Add quantity more then the booking quantity", test, test1);
		
		Step_Start(5, "Click edit button", test, test1);
		waitForElement(driver, Add_Button_CRO);
		click(driver, Add_Button_CRO);
		Step_End(5, "Click edit button", test, test1);
		
		Step_Start(6, "\"CRO quantity Exceeds the Booking quantity for selected Equipment Type\" message shown", test, test1);
		
		waitForPopup(driver, popup_Message, Quantity_Exceeds_Popup);
		
		String Quantity_Popup_act = getText(driver, popup_Message);
		if(Quantity_Exceeds_Popup.equals(Quantity_Popup_act)) {
			System.out.println("Matched || Expected Result is : " +Quantity_Exceeds_Popup + " ||  Actual Result is : "+Quantity_Popup_act);
			Extent_pass_New(driver, " Matched || Expected Result is : " +Quantity_Exceeds_Popup + " ||  Actual Result is : "+Quantity_Popup_act, test, test1);
		      waitForElement(driver, popup_Message_Ok_Button);
		      click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Expected Result is : " +Quantity_Exceeds_Popup + " ||  Actual Result is : "+Quantity_Popup_act);
			Extent_fail(driver, "Not Expected Result is : " +Quantity_Exceeds_Popup + " ||  Actual Result is : "+Quantity_Popup_act, test, test1);
		}
		
		Step_End(6, "\"CRO quantity Exceeds the Booking quantity for selected Equipment Type\" message shown", test, test1);
		Extent_completed(testCaseName, test, test1);
	}

}
