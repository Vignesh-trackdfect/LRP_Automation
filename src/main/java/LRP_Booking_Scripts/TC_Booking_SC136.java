package LRP_Booking_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC136 extends Keywords{

	public void Booking_SC136(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {


		String tc_Name="TC_Booking_SC136";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser=Excel_data.get("agencyUser");
		String arg_party=Excel_data.get("arg_party");
		String origin=Excel_data.get("origin");
		String delivery=Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String restricted_pop = Excel_data.get("restricted_pop");
		String Prohibited_Commodity=Excel_data.get("Prohibited_Commodity");
		String bookingYelloecolour = Excel_data.get("Yellowcolour");
		String savedpopEXP = Excel_data.get("savedpop").trim();
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1").trim();
		String globalSearchFilterOption1=Excel_data.get("GlobalSearchFilterOption1");
		String globalSearchFilterOption2=Excel_data.get("GlobalSearchFilterOption2");
		String globalSearchFilterOption3=Excel_data.get("GlobalSearchFilterOption3");
		String searchValue2=Excel_data.get("searchValue2");
		String searchValue3=Excel_data.get("searchValue3");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		//locators


		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1,"**Switch the Profile Start**");

		SwitchProfile(driver, agencyUser);
		
		Extent_cal(test, test1,"** Enter Booking Module **");

				moduleNavigate(driver, search_module);
		Step_Start(1, "Enter the Agr Party Input", test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(1, "Enter the Agr Party Input", test, test1);

		Step_Start(2, "Enter the Orgin and delivery", test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the Orgin and delivery", test, test1);

		Step_Start(3, "Enter the Rates", test, test1);
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		Step_Start(6, "Add the Restricted commodity in the commodity tab", test, test1);
		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);

		waitForElement(driver, Commodity_Edit);
		safeclick(driver, Commodity_Edit);

		waitForElement(driver, comm_Group);
		safeclick(driver, comm_Group);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption1, Prohibited_Commodity, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

		waitForElement(driver, Commodity_Add);
		safeclick(driver, Commodity_Add);
		
		Step_End(6, "Add the Restricted commodity in the commodity tab", test, test1);

		Step_Start(7,"save the booking in Draft", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		
//		waitForPopup(driver, popup_Message,savedpopEXP);
//		String savepopACT = getText(driver, popup_Message);
//		System.out.println(savepopACT);
//		if(savepopACT.contains(savedpopEXP)) {                                                                                                                  
//			System.out.println("Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT);            
//			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT, test,test1);     
//		}else {                                                                                                                                                                   
//			System.out.println("Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT);        
//			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT, test,test1); 
//		} 
//
//		waitForElement(driver, popup_Message_Ok_Button);
//		safeclick(driver, popup_Message_Ok_Button);
		Step_Start(8, "select confirm button and System shoud validate the Restrictrd Popup", test, test1);

		waitForPopup(driver, popup_Message,restricted_pop);
		String Restricted_Popup = getText(driver, popup_Message);
		System.out.println(Restricted_Popup);
		if(Restricted_Popup.contains(restricted_pop)) {                                                                                                                  
			System.out.println("Matched || " + " Actual Report Activity POPUP  is : " + Restricted_Popup + " || Expected Report Activity POPUP is : " + restricted_pop);            
			Extent_pass_New(driver, "Matched || " + " Actual Report Activity  POPUP is : " + Restricted_Popup + " || Expected Report Activity POPUP is : " + restricted_pop, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Actual Report Activity is : " + Restricted_Popup + " || Expected Report Activity POPUP is : " + restricted_pop);        
			Extent_fail(driver, "Not Matched || " + " Actual Report Activity is : " + Restricted_Popup + " || Expected Report Activity POPUP is : " + restricted_pop, test,test1); 
		} 
		Step_End(8, "select confirm button and System shoud validate the Restrictrd Popup", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		
//		waitForElement(driver, booking_no);
//		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
//		String savedbookingnumber=getColorName(draft_bookingColorCode);
//		
//		String booknum = getAttribute(driver, booking_no,"value");
//		System.out.println(booknum);
//		System.out.println(savedbookingnumber);
//		if(bookingYelloecolour.equals(savedbookingnumber)) {                                                                                                                  
//			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + savedbookingnumber+" [Booking number input field is changed to yellow colour] ");            
//			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + savedbookingnumber+" [Booking number input field is changed to yellow colour] ", test, test1);     
//		}else {                                                                                                                                                                   
//			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + savedbookingnumber+" [Booking number input field is Not changed to yellow colour] ");        
//			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + savedbookingnumber+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
//		} 

		Step_End(7,"save the booking in Draft", test, test1);


		Extent_completed(tc_Name, test, test1);

	}
}
