package LRP_CRO_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_CRO_SC005 extends Keywords {

	public void CRO_SC005(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC005";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String TerminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String condition_Filter = Excel_data.get("condition_Filter");
		String ReleaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String CRO_Saved_Popup = Excel_data.get("CRO_Saved_Popup");
		String Booking_Popup = Excel_data.get("Booking_Popup");
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");
		String Booking_No_Header = Excel_data.get("Booking_No_Header");

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

		
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		
		waitForElement(driver, CRO_Tab_Verify);
		String Act_CRO_Tab = getText(driver, CRO_Tab_Verify);
		System.out.println("opened tab :" + Act_CRO_Tab);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver, CRO_Booking_No);
		String BookingNo = getAttribute(driver, CRO_Booking_No, "value");
		System.out.println("Booking No :" + BookingNo);

		
		waitForElement(driver, CRO_Release_Terminal_Search_Btn);
		click(driver, CRO_Release_Terminal_Search_Btn);
		
		twoColumnMultipleSearchWindow(driver, TerminalDetails_Filter, condition_Filter, ReleaseDepTerminal);
		click(driver, SaveButton_ToolBar);

		String saved_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + saved_popup);


		if(CRO_Saved_Popup.equals(saved_popup)) {
			Extent_pass(driver,"Matched || Expected CRO saved popup displayed : "+CRO_Saved_Popup+" ||  Actual CRO saved popup displayed : "+ saved_popup, test,test1);
			System.out.println("Matched || Expected CRO saved popup displayed : "+CRO_Saved_Popup+" || Actual CRO saved popup displayed: "+ saved_popup);
		}else {
			System.out.println("Not Matched || Expected CRO saved popup displayed : "+CRO_Saved_Popup+" || Actual CRO saved popup displayed: "+ saved_popup);
			Extent_fail(driver,"Not Matched || Expected CRO saved popup displayed : "+CRO_Saved_Popup+" || Actual CRO saved popup displayed: "+ saved_popup, test,test1);
						
		}
		
		Step_Start(1, "Close the CRO module..", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Step_End(1, "Close the CRO module..", test, test1);
		
		Step_Start(2, "Go to Booking module.", test, test1);

		moduleNavigate(driver, Booking_Module_Name);
		
		Step_End(2, "Go to Booking module.", test, test1);
		
		Step_Start(3, "Retrive the book number in booking module..", test, test1);
		
		waitForElement(driver, Booking_Search_Btn);
		click(driver, Booking_Search_Btn);
		globalValueSearchWindow(driver, condition_Filter, Booking_No_Header, BookingNo, "", "", "", "");
		
		Step_End(3, "Retrive the book number in booking module..", test, test1);

		
		Step_Start(4, "Navigate CRO from booking using CRO button.", test, test1);

		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		
		Step_End(4, "Navigate CRO from booking using CRO button.", test, test1);

		Step_Start(5, "All containers are released for this Booking\" message shown.", test, test1);

		waitForPopup(driver, popup_Message, Booking_Popup);
		String actualPopup=getText(driver, popup_Message);
		
		if (actualPopup.contains(Booking_Popup)) {
			System.out.println("Matched || Expected Popup 'All Containers are released for this Booking' displayed  : " + Booking_Popup + "|| Actual Popup 'All Containers are released for this Booking':" + actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup 'All Containers are released for this Booking' : " + Booking_Popup + "|| Actual Popup  'All Containers are released for this Booking':" + actualPopup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Popup 'All Containers are released for this Booking': " + Booking_Popup + "|| Actual Popup 'All Containers are released for this Booking' :" + actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup 'All Containers are released for this Booking':" + Booking_Popup + "|| Actual Popup :'All Containers are released for this Booking':" + actualPopup, test,test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(5, "All containers are released for this Booking\" message shown.", test, test1);

		
		Extent_completed(testCaseName, test, test1);
		
	}
	}
