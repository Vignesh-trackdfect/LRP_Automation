package LRP_Booking_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


//Check whether in Booking, Non containerized shipment system list the Cargo type instead of Contianer details
public class TC_Booking_SC138 extends Keywords {

	public void Booking_SC138(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_Booking_SC138";

		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String AgencyUser = Excel_data.get("AgencyUser");
		String shipment_Type = Excel_data.get("ShipmentType");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String rate_no = Excel_data.get("rate_no");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String Boundinput = Excel_data.get("Boundinput");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String first_service_data = Excel_data.get("first_service_data");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String cargo_Type = Excel_data.get("CargoType");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Header_scroll_number = Excel_data.get("Header_scroll_number");
		navigateUrl(driver, url);
		
		Extent_Start(testCaseName, test, test1);

		String Shipment_Select = String.format(BKGshipmentType, shipment_Type);
		
		// Login
		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyUser);

		// Module search

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, Search);
		
		// select the shipment type
		
		Step_Start(1, "Select the Noncontainerized shipment type in Booking Module ", test, test1);

		waitForElement(driver, Shipment_Type);
		safeclick(driver, Shipment_Type);

		waitForElement(driver, Shipment_Select);
		safeclick(driver, Shipment_Select);

		
		waitForElement(driver, Shipment_Type);
		
		Step_End(1, "Select the Noncontainerized shipment type in Booking Module ", test, test1);

		Step_Start(2, "System enable non contianerized and non containerized detail tab", test, test1);

		if(isdisplayed(driver, nonContainerized_Tab) && isdisplayed(driver, non_Containerized_Detail_Tab)) {
			Extent_pass_New(driver, "Matched || Expected Result is : System enabled non contianerized and non containerized detail tab || Actual Result is : System enabled non contianerized and non containerized detail tab", test, test1);
			System.out.println("Matched || Expected Result is : System enabled non contianerized and non containerized detail tab || Actual Result is :System enabled non contianerized and non containerized detail tab");
		}else {
			System.out.println("Not Matched || Expected Result is :System enabled non contianerized and non containerized detail tab || Actual Result is : System NOT enabled non contianerized and non containerized detail tab");
			Extent_fail(driver,"Not Matched || Expected Result is :System enabled non contianerized and non containerized detail tab || Actual Result is : System NOT  enabled non contianerized and non containerized detail tab", test, test1);
		}
				Step_End(2, "System enable non contianerized and non containerized detail tab", test, test1);
		Step_Start(3, "Enter the Agreement Party", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);

		Step_End(3, "Enter the Agreement Party", test, test1);
		
		Step_Start(4, "Enter the POL and POD and select the Rates using Rates window", test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		Step_End(4, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		Step_Start(5, ".Select the Routing and schedules", test, test1);

		waitForDisplay(driver, Rate_Grid);
		if(isdisplayed(driver, Rate_Grid)) {
			System.out.println("*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed");            
			Extent_pass_New(driver,"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			waitForElement(driver, RatedBtn);
			safeclick(driver, RatedBtn);
			Step_End(2, "Enter the POL and POD and select the Rates using Rates window.",test, test1);
			waitForElement(driver, $Rates);
			safeclick(driver, $Rates);
		} 
		waitForElement(driver, Rates_control_Pannel);
		safeclick(driver, Rates_control_Pannel);
		waitForElement(driver, Rated_condition_Filter);
		safeclick(driver, Rated_condition_Filter);
		sendKeys(driver, RateNo_TF, rate_no);
		waitForElement(driver, ratesWindow_Horizontal_Scrollbar);
		int Header_number = Integer.parseInt(Header_scroll_number);
		horizontalscroll(driver, ratesWindow_Horizontal_Scrollbar, Header_number);

		waitForElement(driver, Rate_No_Select);
		click(driver, Rate_No_Select);

		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_End(5, "Select the Routing and schedules", test, test1);
		Step_Start(6, "select the cargo type in Non containerized tab ", test, test1);
		
		waitForElement(driver, nonContainerized_Tab);
		safeclick(driver, nonContainerized_Tab);
		
		waitForElement(driver, CargoType);
		safeclick(driver, CargoType);
		waitForElement(driver, nonContainerized_Tab);

		
		ArrayList<String> cargoTypesList=new ArrayList<String>();
		List<WebElement> cargoTypes =listOfElements(driver, CargoTypes);
		for (WebElement cargoType : cargoTypes) {
			String CargoTypelist = getText1(driver, cargoType);
			cargoTypesList.add(CargoTypelist);
			if(!CargoTypelist.equals("")) {
				
				Extent_pass_New(driver,"Matched || Expected Listed Cargo Type should be: "+CargoTypelist+" || Actual Listed Cargo Type  : "+CargoTypelist, test,test1);
				System.out.println("Not Matched || Expected Listed Cargo Type should be: "+CargoTypelist+" || Actual Listed Cargo Type : "+CargoTypelist);

			}else {
				System.out.println("Not Matched || Expected Listed Cargo Type should be: "+CargoTypelist+" || But Actual Listed Cargo Type : "+CargoTypelist);
				Extent_fail(driver,"Not Matched || Expected Listed Cargo Type should be : "+CargoTypelist+" || But Actual Listed Cargo Type : "+CargoTypelist, test,test1);
			}	
				
			
		}
		
		
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			safeclick(driver, popup_Message_Ok_Button);
		}
		String cargoType_Select=String.format(select_CargoType, cargo_Type);
		waitForElement(driver, cargoType_Select);
		click(driver, cargoType_Select);
		
		Step_End(6, "select the cargo type in Non containerized tab ", test, test1);
		
		Step_Start(7, "save the booking in Draft", test, test1);
	
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);

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
		}
		
		Step_End(7, "save the booking in Draft", test, test1);
		Step_Start(8, "AutoRate the charges in Charge tab", test, test1);

		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

		Step_End(8, "AutoRate the charges in Charge tab", test, test1);
		
		Step_Start(9, "select Confirmed button and click Save button", test, test1);
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);
	
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);


		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String actualUpdatedPopup = getText(driver, popup_Message);
		if (actualUpdatedPopup.contains(bookingUpdatedPopup)) {
			Extent_pass_New(driver,"Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			System.out.println("Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
			click(driver, popup_Message_Ok_Button);
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
		
		
		Step_End(9, "select Confirmed button and click Save button", test, test1);
		
		Extent_completed(testCaseName, test, test1);
	}
}
