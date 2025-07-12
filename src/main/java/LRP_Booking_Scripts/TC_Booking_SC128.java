package LRP_Booking_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC128 extends Keywords{
	public void Booking_SC128(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC128";
		
		
		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String Search =Excel_data.get("Search_input");
		String delivery =Excel_data.get("Delivery");
		String Agt =Excel_data.get("AGR_Party");
		String orgin =Excel_data.get("Orgin");
		String agencyUser = Excel_data.get("AgencyUser");
		String Commodity_Chk_Box_Exp = Excel_data.get("Commodity_Chk_Box");
		String DG_Chk_Box_Exp = Excel_data.get("DG_Chk_Box");
		String Tar_Chk_Box_Exp = Excel_data.get("Tar_Chk_Box");
		String AFF_Chk_Box_Exp = Excel_data.get("AFF_Chk_Box");
		String restricted_pop = Excel_data.get( "restricted_pop");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String Prohibited_Commodity=Excel_data.get("Prohibited_Commodity");
		String bookingYelloecolour = Excel_data.get( "Yelloecolour");
		String savedpopEXP = Excel_data.get( "savedpop");
		String valid_Days_Input = Excel_data.get("valid_Days_Input");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Global_Search_Type1 = Excel_data.get("Global_Search_Type1");
		String Global_Search_Type2=Excel_data.get("Global_Search_Type2");
		String Global_Search_Type3 = Excel_data.get( "Global_Search_Type3");
		String Global_Search_Value2 = Excel_data.get( "Global_Search_Value2");
		String Global_Search_Value3 = Excel_data.get("Global_Search_Value3");
		
		//locators
		Extent_Start(test_Case_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);

		Extent_call(test, test1,"********** Enter Booking Module **********");
//		waitForElement(driver,Search_Input);
//		sendKeys(driver, Search_Input, Search);	
//		waitForElement(driver, Booking_click);
//		safeclick(driver, Booking_click);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
				moduleNavigate(driver, Search);
		//select the shipment type
		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);
		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);
		waitForElement(driver, DeliveryInput);
		clearAndType(driver, DeliveryInput, delivery);
		tab(driver);
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
		waitForElement(driver,Valid_Days);
		clearAndType(driver, Valid_Days, valid_Days_Input);	

		Extent_call(test, test1,"********** Select the Check Box in Rates Window **********");
		waitForElement(driver, Commodity_Chk_Box);
		checkBox(driver, Commodity_Chk_Box,Commodity_Chk_Box_Exp);
		waitForElement(driver, DG_Chk_Box);
		checkBox(driver, DG_Chk_Box,DG_Chk_Box_Exp);
		waitForElement(driver, Tar_Chk_Box);
		checkBox(driver, Tar_Chk_Box,Tar_Chk_Box_Exp);
		waitForElement(driver, AFF_Chk_Box);
		checkBox(driver, AFF_Chk_Box,AFF_Chk_Box_Exp);
		waitForElement(driver, Rates_Show_Btn);
		safeclick(driver, Rates_Show_Btn);
		Step_End(2, "Enter the POL and POD and select the Rates using Rates window",test, test1);

		Step_Start(3, "Select the Routing & Select the Schedule", test, test1);
		waitForElement(driver, rateref_toolbtn);
		click(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		click(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
		waitForElement(driver, Rate_No_Select);
		click(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		click(driver, ok_btn);
		Step_End(3, "Select the Routing & Select the Schedule", test, test1);
	
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_Start(4, "Add the Restricted commodity in the commodity tab", test, test1);
		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);

		waitForElement(driver, Commodity_Edit);
		safeclick(driver, Commodity_Edit);

		waitForElement(driver, comm_Group);
		safeclick(driver, comm_Group);
		globalValueSearchWindow(driver, Global_Search_Condition, Global_Search_Type1, Prohibited_Commodity, Global_Search_Type2, Global_Search_Value2, Global_Search_Type3, Global_Search_Value3);

		waitForElement(driver, Commodity_Add);
		safeclick(driver, Commodity_Add);
		Step_End(4, "Add the Restricted commodity in the commodity tab", test, test1);
		Step_Start(5,"save the booking in Draft", test, test1);
scrollTop(driver);
waitForElement(driver, SaveButton_ToolBar);
click1(driver, SaveButton_ToolBar);
//waitForPopup(driver, popup_Message,savedpopEXP);
//		String savepopACT = getText(driver, popup_Message);
//		System.out.println(savepopACT);
//		if(savepopACT.contains(savedpopEXP)) {                                                                                                                  
//			System.out.println("Matched || " + " Actual Report Activity POPUP SHOWN is : " + savepopACT + " || Expected Report Activity POPUP SHOWN is : " + savedpopEXP);            
//			Extent_pass_New(driver, "Matched || " + " Actual Report Activity POPUP SHOWN is : " + savepopACT + " || Expected Report Activity POPUP SHOWN is : " + savedpopEXP,test,test1);     
//		}                                                                                                                                                                        
//		else {                                                                                                                                                                   
//			System.out.println("Matched || " + " Actual Report Activity POPUP SHOWN is : " + savepopACT + " || Expected Report Activity POPUP SHOWN is : " + savedpopEXP);            
//			Extent_fail(driver, "Matched || " + " Actual Report Activity POPUP SHOWN is : " + savepopACT + " || Expected Report Activity POPUP SHOWN is : " + savedpopEXP,test,test1);
//		} 
//		waitForElement(driver, popup_Message_Ok_Button);
//		safeclick(driver, popup_Message_Ok_Button);
		
		Step_Start(6, "select confirm button and System shoud validate the Restrictrd Popup", test, test1);

		waitForPopup(driver, popup_Message,restricted_pop);
		String Restricted_Popup = getText(driver, popup_Message);
		System.out.println(Restricted_Popup);
		if(Restricted_Popup.contains(restricted_pop)) {                                                                                                                  
			System.out.println("Matched || " + " Actual Report Activity popup is : " + Restricted_Popup + " || Expected Report Activity popup is : " + restricted_pop);            
			Extent_pass_New(driver, "Matched || " + " Actual Report Activity popup is : " + Restricted_Popup + " || Expected Report Activity popup is : " + restricted_pop, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Actual Report Activity  popup is : " + Restricted_Popup + " || Expected Report Activity popup is : " + restricted_pop);        
			Extent_fail(driver, "Not Matched || " + " Actual Report Activity  popup is : " + Restricted_Popup + " || Expected Report Activity popup is : " + restricted_pop, test,test1); 
		} 
		Step_End(6, "select confirm button and System shoud validate the Restrictrd Popup", test, test1);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		
//		String booknum = getAttribute(driver, booking_no,"value");
//		System.out.println(booknum);
//		waitForElement(driver, booking_no);
//		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
//		String draft_bookingColor=getColorName(draft_bookingColorCode);
//		
//		if(draft_bookingColor.equals(bookingYelloecolour)) {                                                                                                                  
//			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
//			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
//		}else {                                                                                                                                                                   
//			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
//			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
//		} 

		Step_End(5,"save the booking in Draft", test, test1);
		Extent_completed(test_Case_Name, test, test1);

	}
}
