package LRP_CRO_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


public class TC_CRO_SC004 extends Keywords {

	public void CRO_SC004(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC004";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String Book_Number_Popup = Excel_data.get("Book_Number_Popup");

		
		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Open the browser", test, test1);

		navigateUrl(driver, url);
		
		Step_End(1, "Open the browser", test, test1);
		Step_End(2, "Open the browser", test, test1);

		Step_Start(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_Start(4, " Click on Login Button", test, test1);

		LRP_Login(driver, Username, Password);
		
		Step_End(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_End(4, " Click on Login Button", test, test1);
		Step_Start(5, "Switch the agency", test, test1);

		SwitchProfile(driver, agencyUser);
		
		Step_End(5, "Switch the agency", test, test1);
		Step_Start(6, "Open the container release order module.", test, test1);

//  CRO 
		
		moduleNavigate(driver, CRO_Module_Name);
		
		Step_End(6, "Open the container release order module.", test, test1);
		Step_Start(7, "Select the Release Depot/Terminal", test, test1);

		scrollElementToView(driver, rel_terminal_searchicon);
		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);
		
		Step_End(7, "Select the Release Depot/Terminal", test, test1);
		Step_Start(8, "\"Enter the Booking Number\" validation message shown.", test, test1);

		waitForPopup(driver, popup_Message, Book_Number_Popup);
		String actualPopup=getText(driver, popup_Message);
		
		if (actualPopup.contains(Book_Number_Popup)) {
			System.out.println("Matched || Expected Popup  : " + Book_Number_Popup + "|| Actual Popup :" + actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup  : " + Book_Number_Popup + "|| Actual Popup  :" + actualPopup, test,test1);

		} else {
			System.out.println("Not Matched || Expected Popup : " + Book_Number_Popup + "|| Actual Popup  :" + actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :" + Book_Number_Popup + "|| Actual Popup :" + actualPopup, test,test1);
		}
		
		Step_End(8, "\"Enter the Booking Number\" validation message shown.", test, test1);
		Step_Start(9, "Click ok button.", test, test1);

		click(driver, popup_Message_Ok_Button);

		Step_End(9, "Click ok button.", test, test1);
		Step_Start(10, "Select the \"Acceptance Terminal\".", test, test1);

		scrollElementToView(driver, acceptance_Terminal_SearchButton_CRO);
		waitForElement(driver, acceptance_Terminal_SearchButton_CRO);
		click(driver, acceptance_Terminal_SearchButton_CRO);
		
		Step_End(10, "Select the \"Acceptance Terminal\".", test, test1);
		Step_Start(11, "\"Enter the Booking Number\" validation message shown.", test, test1);

		waitForPopup(driver, popup_Message, Book_Number_Popup);
		actualPopup=getText(driver, popup_Message);
		
		if (actualPopup.contains(Book_Number_Popup)) {
			System.out.println("Matched || Expected Popup  : " + Book_Number_Popup + "|| Actual Popup :" + actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup  : " + Book_Number_Popup + "|| Actual Popup  :" + actualPopup, test,test1);

		} else {
			System.out.println("Not Matched || Expected Popup : " + Book_Number_Popup + "|| Actual Popup  :" + actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :" + Book_Number_Popup + "|| Actual Popup :" + actualPopup, test,test1);
		}
		
		Step_End(11, "\"Enter the Booking Number\" validation message shown.", test, test1);
		Step_Start(12, "Click ok button.", test, test1);

		click(driver, popup_Message_Ok_Button);

		Step_End(12, "Click ok button.", test, test1);
		Step_Start(13, "Select By type.", test, test1);

		scrollElementToView(driver, BL_Type_SearchButton_CRO);
		waitForElement(driver, BL_Type_SearchButton_CRO);
		click(driver, BL_Type_SearchButton_CRO);
		
		Step_End(13, "Select By type.", test, test1);
		Step_Start(14, "\"Enter the Booking Number\" validation message shown.", test, test1);

		waitForPopup(driver, popup_Message, Book_Number_Popup);
		actualPopup=getText(driver, popup_Message);
		
		if (actualPopup.contains(Book_Number_Popup)) {
			System.out.println("Matched || Expected Popup  : " + Book_Number_Popup + "|| Actual Popup :" + actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup  : " + Book_Number_Popup + "|| Actual Popup  :" + actualPopup, test,test1);

		} else {
			System.out.println("Not Matched || Expected Popup : " + Book_Number_Popup + "|| Actual Popup  :" + actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :" + Book_Number_Popup + "|| Actual Popup :" + actualPopup, test,test1);
		}
		
		Step_End(14, "\"Enter the Booking Number\" validation message shown.", test, test1);
		Step_Start(15, "Click ok button.", test, test1);

		click(driver, popup_Message_Ok_Button);

		Step_End(15, "Click ok button.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
	}
