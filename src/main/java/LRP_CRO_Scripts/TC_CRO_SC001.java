package LRP_CRO_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_CRO_SC001 extends Keywords {

	public void CRO_SC001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC001";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String condition_Filter = Excel_data.get("condition_Filter");
		String terminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String CRO_Saved_Popup = Excel_data.get("CRO_Saved_Popup");

		
		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

// Login
	LRP_Login(driver, Username, Password);

//	Switch the Profile
		SwitchProfile(driver, agencyUser);


//		Booking module

		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
	

		//	Create CRO
		
		Step_Start(1, "Navigate CRO from booking screen..", test, test1);


		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		Step_End(1, "Navigate CRO from booking screen..", test, test1);
		
		
		Step_Start(2, "Click \"edit\" button...", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_End(2, "Click \"edit\" button...", test, test1);

		Step_Start(3, "Select \"Release Depot/Terminal\".", test, test1);
		
		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);
		
		Step_End(3, "Select \"Release Depot/Terminal\".", test, test1);

		Step_Start(4, "Select \"Acceptance Terminal\"..", test, test1);

		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		

		if(!releaseDepTerminal.equals("")) {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, releaseDepTerminal);
		}else {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, acc_term_value);
		}
		
		Step_End(4, "Select \"Acceptance Terminal\"..", test, test1);
		
		
		Step_Start(5, "Click \"save\" button.", test, test1);


		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(5, "Click \"save\" button.", test, test1);
		
		Step_Start(6, "CRO is saved message shown.", test, test1);

		String saved_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + saved_popup);


		if(CRO_Saved_Popup.equals(saved_popup)) {
			Extent_pass(driver,"Matched || Expected CRO saved popup displayed : "+CRO_Saved_Popup+" ||  Actual CRO saved popup displayed : "+ saved_popup, test,test1);
			System.out.println("Matched || Expected CRO saved popup displayed : "+CRO_Saved_Popup+" || Actual CRO saved popup displayed: "+ saved_popup);
		}else {
			System.out.println("Not Matched || Expected CRO saved popup displayed : "+CRO_Saved_Popup+" || Actual CRO saved popup displayed: "+ saved_popup);
			Extent_fail(driver,"Not Matched || Expected CRO saved popup displayed : "+CRO_Saved_Popup+" || Actual CRO saved popup displayed: "+ saved_popup, test,test1);
						
		}


		Step_End(6, "CRO is saved message shown.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
	}
