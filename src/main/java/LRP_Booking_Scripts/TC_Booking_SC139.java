package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


//Check whether in Booking, while reselect the Carriage contract system clear the Rates and charges
public class TC_Booking_SC139 extends Keywords {

	public void Booking_SC139(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Booking_SC139";

		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String agencyUser = Excel_data.get("AgencyUser");
		String first_service_data = Excel_data.get("first_service_data");
		String Boundinput = Excel_data.get("Boundinput");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String rate_no = Excel_data.get("rate_no");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String Clear_Reset_Popup = Excel_data.get("Clear_Reset_Popup");
		String Contract_Name = Excel_data.get("Contract_Name");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String Dstatus = Excel_data.get("Draftstatus");
		String gridStatus = Excel_data.get("GridStatus");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		
		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

		// Login
				LRP_Login(driver, Username, Password);

//			Switch the Profile
			SwitchProfile(driver, agencyUser);
				
		// Module search
				
				//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
				
				moduleNavigate(driver, Search);
				
	
		Step_Start(1, "Enter the Agreement Party", test, test1);
		
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		
		Step_End(1, "Enter the Agreement Party", test, test1);
		Step_Start(2, "Enter the POL and POD ", test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		

		Step_End(2, "Enter the POL and POD", test, test1);
		Step_Start(3, "Select the Routing ", test, test1);
		
	
	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		Step_End(4, "Select the Schedule ", test, test1);

		Step_Start(5, "save the booking in Draft", test, test1);
		
		waitForElement(driver, booking_status_field);
		String draft_status = String.format(booking_Status_Button, Dstatus);
		click(driver, draft_status);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verify saved pop up of draft

		if (savepopACT.contains(savedpopEXP)) {
			Extent_pass_New(driver,"Matched || Expected Po-pup value is : "+savepopACT+" || Actual Pop-up value is : "+savedpopEXP, test,test1);
			System.out.println("Matched || Expected Po-pup value is : "+savepopACT+" || Actual Pop-up value is : "+savedpopEXP);
			safeclick(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Po-pup value is : "+savepopACT+" || But Actual Pop-up value is : "+savedpopEXP);
			Extent_fail(driver,"Not Matched || Expected Po-pup value is : "+savepopACT+" || But Actual Pop-up value is : "+savedpopEXP, test,test1);
		}	


		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		
		if (draft_bookingColor.equals(booking_draft_Color)) {
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		} 


		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

		if(!booknum.equals("")) {
			System.out.println("Generated Booking number is " + booknum);
			Extent_pass_New(driver, "Generated Booking number is " + booknum, test, test1);
		
			}
		
		Step_End(5, "save the booking in Draft", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_Start(6, "AutoRate the charges in Charge tab", test, test1);
		
		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);

		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		click(driver, AutoRated);

		waitForDisplay(driver, ChargesTab_Grid);
		if (isdisplayed(driver, ChargesTab_Grid)) {
			
			
			System.out.println("*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges   not cleared");            
			Extent_pass_New(driver,"*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges   not cleared", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges  cleared");        
			Extent_fail(driver, "*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges  cleared", test,test1); 
		
		}
			
	
		Step_End(6, "AutoRate the charges in Charge tab", test, test1);

		waitForElement(driver, container_tab);
		click(driver, container_tab);
		
		waitForElement(driver, Rate_No_Grid);
		String RateNo1 = getText(driver, Rate_No_Grid);
		System.out.println("Rate No before :" + RateNo1);
		Step_Start(7, "select confirm button and click Save button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String actualUpdatedPopup = getText(driver, popup_Message);
		if (actualUpdatedPopup.contains(bookingUpdatedPopup)) {
			Extent_pass_New(driver,"Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			System.out.println("Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
			Extent_fail(driver,"Not Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup,test, test1);
		}
		
		waitForElement(driver, Booking_No_Field);
		String actualConfirmedColorCode=getTextBackgroundColor(driver, Booking_No_Field);
		String actualConfirmedColor=getColorName(actualConfirmedColorCode);

		if(actualConfirmedColor.equalsIgnoreCase(booking_confirmed_Color)) {
			Extent_pass_New(driver,"Matched || The background color of confirmed Booking number textfield is green|| Expected color code:" +booking_confirmed_Color+" || Actual color code:"+actualConfirmedColor, test,test1);
			System.out.println("Matched || The background color of confirmed Booking number textfield is green");
		}else {
			System.out.println("Not Matched || The background color of confirmed Booking number textfield is not green");
			Extent_fail(driver,"Not Matched || The background color of confirmed Booking number textfield is not green|| Expected color code:" +booking_confirmed_Color+" || Actual color code:"+actualConfirmedColor, test,test1);
		}
		
		Step_End(7, "select confirm button and click Save button", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, master_tab);

		Step_Start(8, "Change the carriage contract in Booking", test, test1);
		
		if(isDisplayed(driver, rateReference_Details)) {
			
			System.out.println("*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges   not cleared");            
			Extent_pass_New(driver,"*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges   not cleared", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges  cleared");        
			Extent_fail(driver, "*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges  cleared", test,test1); 
		
		}
		
		
		waitForElement(driver, chargesSummary);
		String actualStatus=getAttribute(driver, chargesSummary, "class");
		if(!actualStatus.contains(gridStatus)) {
			System.out.println("*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges   not cleared");            
			Extent_pass_New(driver,"*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges   not cleared", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges  cleared");        
			Extent_fail(driver, "*The Expected Result is : Before reselect the Carriage  contract charges  should not cleared || The Actual Result is : Before reselect the Carriage  contract charges  cleared", test,test1); 
		
		}
		
		waitForElement(driver, Carriage_Contract_SearchBtn);
		click(driver, Carriage_Contract_SearchBtn);
		waitForElement(driver, Contract_Name_TF);
		sendKeys(driver, Contract_Name_TF, Contract_Name);
		waitForElement(driver, Carriage_Contract_SelectBtn);
		click(driver, Carriage_Contract_SelectBtn);

		waitForPopup(driver, popup_Message,Clear_Reset_Popup);
		String Reset_Popup = getText(driver, popup_Message);
		System.out.println(Reset_Popup);
		if (Clear_Reset_Popup.equals(Reset_Popup)) {
			System.out.println(
					"Matched || Expected Popup : " + Clear_Reset_Popup + " || Actual Popup : " + Reset_Popup);
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + Clear_Reset_Popup + " || Actual Popup : " + Reset_Popup,
					test, test1);

		} else {
			System.out.println("NotMatched || Expected Popup : " + Clear_Reset_Popup + " || Actual Popup : "
					+ Reset_Popup);
			Extent_fail(driver,
					"NotMatched || Expected Popup : " + Clear_Reset_Popup + " || Actual Popup : " + Reset_Popup,
					test, test1);
		}

		click(driver, popup_Message_Yes_Button);
		
		Step_End(8, "Change the carriage contract in Booking", test, test1);
		
		waitForElement(driver, master_tab);
waitForDisplay(driver, rateReference_Details);
		if(!isDisplayed(driver, rateReference_Details)) {
			System.out.println("*The Expected Result is : After reselect the Carriage  contract charges  should  cleared || The Actual Result is : After reselect the Carriage  contract charges    cleared");            
			Extent_pass_New(driver,"*The Expected Result is : After reselect the Carriage  contract charges  should  cleared || The Actual Result is : After reselect the Carriage  contract charges    cleared", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : After reselect the Carriage  contract charges  should not cleared || The Actual Result is : After reselect the Carriage  contract charges  not cleared");        
			Extent_fail(driver, "*The Expected Result is : After reselect the Carriage  contract charges  should not cleared || The Actual Result is : After reselect the Carriage  contract charges not  cleared", test,test1); 
		
		}
		
		
		waitForElement(driver, chargesSummary);
		String actualStatusAfter=getAttribute(driver, chargesSummary, "class");
		if(actualStatusAfter.contains(gridStatus)) {
			System.out.println("*The Expected Result is : After reselect the Carriage  contract charges  should  cleared || The Actual Result is : After reselect the Carriage  contract charges    cleared");            
			Extent_pass_New(driver,"*The Expected Result is : After reselect the Carriage  contract charges  should  cleared || The Actual Result is : After reselect the Carriage  contract charges    cleared", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : After reselect the Carriage  contract charges  should not cleared || The Actual Result is : After reselect the Carriage  contract charges  not cleared");        
			Extent_fail(driver, "*The Expected Result is : After reselect the Carriage  contract charges  should not cleared || The Actual Result is : After reselect the Carriage  contract charges not  cleared", test,test1); 
		
		}
		
		waitForElement(driver, container_tab);
		click(driver, container_tab);
		
		waitForElement(driver, Rate_No_Grid);
		String RateNo2 = getText(driver, Rate_No_Grid);
		if (RateNo1.equals(RateNo2)) {
			System.out.println("Matched || Expected value nuumber was : " + RateNo1 + " || Actual value nuumber was : " + RateNo2);
			Extent_fail(driver, "Matched || Expected value nuumber was : " + RateNo1 + " || Actual value nuumber was : " + RateNo2,
					test, test1);
		} else {
			System.out.println("NotMatched || Expected value nuumber was : " + RateNo1 + " || Actual value nuumber was : " + RateNo2);
			Extent_pass_New(driver, "NotMatched || Expected value nuumber was : " + RateNo1 + " || Actual value nuumber was : " + RateNo2,
					test, test1);
		}
		
		Step_Start(9, "System clear the Rates and Charges", test, test1);
		
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);

		waitForElement(driver, Charges_tab);

		if (!isdisplayed(driver, ChargesTab_Grid)) {
			System.out.println("*The Expected Result is : After reselect the Carriage  contract charges  should  cleared || The Actual Result is : After reselect the Carriage  contract charges    cleared");            
			Extent_pass_New(driver,"*The Expected Result is : After reselect the Carriage  contract charges  should  cleared || The Actual Result is : After reselect the Carriage  contract charges    cleared", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("*The Expected Result is : After reselect the Carriage  contract charges  should not cleared || The Actual Result is : After reselect the Carriage  contract charges  not cleared");        
			Extent_fail(driver, "*The Expected Result is : After reselect the Carriage  contract charges  should not cleared || The Actual Result is : After reselect the Carriage  contract charges not  cleared", test,test1); 
		
		}
		
		Step_End(9, "System clear the Rates and Charges", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}
