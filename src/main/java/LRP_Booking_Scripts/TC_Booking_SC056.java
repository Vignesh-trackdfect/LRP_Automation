package LRP_Booking_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC056 extends Keywords {

	public void Booking_SC056(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC056";

		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String search_module =Excel_data.get("Search_input");
		String delivery =Excel_data.get("Delivery");
		String arg_party =Excel_data.get("AGR_Party");
		String origin =Excel_data.get("Orgin");
		String agencyUser = Excel_data.get("AgencyUser");
		String Commodity_Chk_Box_Exp = Excel_data.get("Commodity_Chk_Box");
		String DG_Chk_Box_Exp = Excel_data.get("DG_Chk_Box");
		String Tar_Chk_Box_Exp = Excel_data.get("Tar_Chk_Box");
		String AFF_Chk_Box_Exp = Excel_data.get("AFF_Chk_Box");
		String booking_draft_Color = Excel_data.get("Yellowcolour");
		String savedpopEXP = Excel_data.get("savedpop");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_confirmed_Color = Excel_data.get("GreenColor");
		String bookingUpdatedPopup = Excel_data.get("BookingUpdatedPopup");
		String Container_grid_Color = Excel_data.get("Container_grid_Color");
		String Reset_Agr_Popopup = Excel_data.get("Reset_Agr_Popopup");
		String Agr_Reseted_Popup_Msg = Excel_data.get("Agr_Reseted_Popup_Msg").trim();
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		Extent_Start(test_Case_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);

		Extent_call(test, test1,"********** Switch the Profile  - End **********");

		System.out.println("********** Enter Booking Module **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
				moduleNavigate(driver, search_module);

		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);

		Step_Start(2, "Enter the POL and POD ",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		keyDown(driver);
		enter(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the POL and POD ",test, test1);
		Step_Start(3, "Enter the Rates", test, test1);
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

		Step_End(3, "Enter the Rates", test, test1);

		Step_Start(4, "Select the Routing", test, test1);
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
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		Step_End(4, "Select the Routing", test, test1);

		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_Start(6, "save the booking in Draft", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		// Verification of saved popup of draft
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		Extent_cal(test, test1,"**********Verifting the saved popup**********");
		if(savepopACT.contains(savedpopEXP)) {                                                                                                                  
			System.out.println("Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT, test,test1); 
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println("Book number generated is: "+booknum);
		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		if(draft_bookingColor.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		} 
		Step_End(5, "save the booking in Draft ", test, test1);
		Step_Start(6, "select confirm button and safeclick Save button ", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		waitForElement(driver, Charges_tab);
		click1(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		click1(driver, AutoRated);
		waitForElement(driver, master_tab);
		click1(driver, master_tab);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String UpdatedpopACT = getText(driver, popup_Message);
		System.out.println(UpdatedpopACT);
		if(UpdatedpopACT.contains(bookingUpdatedPopup)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + UpdatedpopACT);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + UpdatedpopACT, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + UpdatedpopACT);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + UpdatedpopACT, test,test1); 
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor=getColorName(Confirm_bookingColorCode);
		if (Confirm_bookingColor.equalsIgnoreCase(booking_confirmed_Color)) {
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		}  
		Step_End(8, "select confirm button and click Save button", test, test1);

		Extent_call(test, test1,"********** Fetching the Values Berfore Reset the Agreement Party - Start **********");
		waitForElement(driver, AgrPartyInput); 
		String Agr_Field_value=getAttribute(driver, AgrPartyInput,"value");
		waitForDisplay(driver, AgrPartyInput);
		if(isDisplayed(driver,AgrPartyInput)) {
			Extent_pass_New(driver,"Matched || Before Reseting the Agreement party the Agr party Text field value is :" +Agr_Field_value, test,test1);
			System.out.println("Matched || Before Reseting the Agreement party the Agr party Text field value is : " +Agr_Field_value);
		}else {
			System.out.println("Not Matched || Before Reseting the Agreement party the Commodity Gruop value is not displayed");
			Extent_fail(driver,"Not Matched || Before Reseting the Agreement party the Commodity Gruop value is not displayed", test,test1);
		}
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		scrollTop(driver);
		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		scrollBottom(driver);
		waitForDisplay(driver, chargesGrid);
		if(isDisplayed(driver,Charges_Grid_edit)) {
			Extent_pass_New(driver,"Matched || Before Reseting the Agreement party the Charges Grid is displayed ", test,test1);
			System.out.println("Matched || Before Reseting the Agreement party the Charges Grid is displayed");
			Extent_pass_New(driver, "Charges Grid is displayed", test,test1);
		}else {
			System.out.println("Not Matched || Before Reseting the Agreement party the Charges Grid value is not displayed || Charges Grid is not displayed");
			Extent_fail(driver,"Not Matched || Before Reseting the Agreement party the Charges Grid value is not displayed || Charges Grid is not displayed", test,test1);
		}
		scrollTop(driver);
		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);
		waitForElement(driver, Commodity_Gruop);
		String Commodity_Gruop_value=getText(driver, Commodity_Gruop);
		waitForDisplay(driver, Commodity_Gruop);

		if(isDisplayed(driver,Commodity_Gruop)) {
			Extent_pass_New(driver,"Matched || Before Reseting the Agreement party the Commodity Gruop value is :" +Commodity_Gruop_value, test,test1);
			System.out.println("Matched || Before Reseting the Agreement party the Commodity Gruop value is : " +Commodity_Gruop_value);
		}else {
			System.out.println("Not Matched || Before Reseting the Agreement party the Commodity Gruop value is not displayed");
			Extent_fail(driver,"Not Matched || Before Reseting the Agreement party the Commodity Gruop value is not displayed", test,test1);
		}
		scrollTop(driver);
		waitForElement(driver, Container_Tab);
		safeclick(driver, Container_Tab);
		waitForElement(driver, Container_Grid);
		String act_ContainerGrid_colourCode =getTextBackgroundColor(driver, Container_Color);
		String act_ContainerGrid_colour = getColorName(act_ContainerGrid_colourCode);
		if(Container_grid_Color.equals(act_ContainerGrid_colour)) {
			Extent_pass_New(driver,"Matched || Before Reseting the container tab colour is Yellow Color : " +act_ContainerGrid_colour, test,test1);
			System.out.println("Matched || Before Reseting the container tab colour is Yellow Color : " +act_ContainerGrid_colour);

		}else {
			System.out.println("Not Matched || Before Reseting the container tab colour is Not Yellow Color : "+act_ContainerGrid_colour);
			Extent_fail(driver,"Not Matched || Before Reseting the container tab colour is Not Yellow Color : "+act_ContainerGrid_colour, test,test1);
		}
		scrollUsingElement(driver, Rate_No_Value);
		waitForElement(driver, Rate_No_Value);
		String Act_Rate_No = getText(driver, Rate_No_Value);
		waitForDisplay(driver, Rate_No_Value);		
		if(isDisplayed(driver, Rate_No_Value)) {
			Extent_pass_New(driver,"Matched || Before Reseting the container tab Rate No is :" +Act_Rate_No, test,test1);
			System.out.println("Matched || Before Reseting the container tab Rate No is : " +Act_Rate_No);

		}else {
			System.out.println("Not Matched || Before Reseting the container tab Rate No is : " +Act_Rate_No);		
			Extent_fail(driver, "Not Matched || Before Reseting the container tab Rate No is : " +Act_Rate_No, test,test1);
		}
		Extent_call(test, test1,"********** Fetching the Values Berfore Reset the Agreement Party - End **********");

		Step_Start(9, "Reset the Agreement party", test, test1);
		scrollTop(driver);
		waitForElement(driver, Reset_Btn);
		safeclick(driver, Reset_Btn);
		waitForElement(driver, Reset_Agreement);
		safeclick(driver, Reset_Agreement);
		waitForElement(driver, popup_Message);
		String Actual_Popup=getText(driver, popup_Message);
		if(Reset_Agr_Popopup.equals(Actual_Popup)) {
			Extent_pass_New(driver, "Matched || Expected  Pop-up value is : "+Reset_Agr_Popopup+"|| Actual Pop-up Value is:"+Actual_Popup , test,test1);
			System.out.println("Matched || Expected  Pop-up value is : "+Reset_Agr_Popopup+"|| Actual Pop-up Value is:"+Actual_Popup);
			safeclick(driver,popup_Message_Yes_Button);
		}else {
			System.out.println("Not Matched || Expected  Pop-up value is : "+Reset_Agr_Popopup+"|| Actual Pop-up Value is:"+Actual_Popup);
			Extent_fail(driver, "Not Matched || Expected  Pop-up value is : "+Reset_Agr_Popopup+"|| Actual Pop-up Value is:"+Actual_Popup , test,test1);
		}
		waitForElement(driver, popup_Message);
		String Act_Popup=getText(driver, popup_Message);
		if(Agr_Reseted_Popup_Msg.equals(Act_Popup)) {
			Extent_pass_New(driver, "Matched || Expected  Pop-up value is : "+Agr_Reseted_Popup_Msg+"|| Actual Pop-up Value is:"+Act_Popup , test,test1);
			System.out.println("Matched || Expected  Pop-up value is : "+Agr_Reseted_Popup_Msg+"|| Actual Pop-up Value is:"+Act_Popup);

		}else {
			System.out.println("Not Matched || Expected popup: "+Agr_Reseted_Popup_Msg+"|| Actual Pop-up Value is:"+Act_Popup);
			Extent_fail(driver, "Not Matched || Expected popup: "+Agr_Reseted_Popup_Msg+"|| Actual Pop-up Value is:"+Act_Popup , test,test1);
		}
		safeclick(driver, popup_Message_Ok_Button);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		Step_End(9, "Reset the Agreement party", test, test1);

		Extent_call(test, test1,"********** Fetching the Values After Reset the Agreement Party - Start **********");
		waitForElement(driver, AgrPartyInput);
		String Agr_Field_value1=getAttribute(driver, AgrPartyInput,"value");
		if(!Agr_Field_value.equals(Agr_Field_value1)) {
			Extent_pass_New(driver,"Matched || After Reseting the Agreement party the Commodity Gruop value is not displayed", test,test1);
			System.out.println("Matched || After Reseting the Agreement party the Commodity Gruop value is not displayed");
		}else {
			System.out.println("Not Matched || After Reseting the Agreement party the Agr party Text field value is :" +Agr_Field_value1);
			Extent_fail(driver,"Not Matched || After Reseting the Agreement party the Agr party Text field value is :" +Agr_Field_value1, test,test1);
		}
		scrollTop(driver);
		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);
		waitForElement(driver, Commodity_Gruop);
		String Commodity_Gruop_value1=getText(driver, Commodity_Gruop);
		if(!Commodity_Gruop_value.equals(Commodity_Gruop_value1)) {
			Extent_pass_New(driver,"Matched || After Reseting the Agreement party the Commodity Gruop value is not displayed "+Commodity_Gruop_value1, test,test1);
			System.out.println("Matched || After Reseting the Agreement party the Commodity Gruop value is not displayed "+Commodity_Gruop_value1);
		}else {
			Extent_fail(driver,"Not Matched || After Reseting the Agreement party the Commodity Gruop value is displayed "+Commodity_Gruop_value1, test,test1);
			System.out.println("Not Matched || After Reseting the Agreement party the Commodity Gruop value is displayed "+Commodity_Gruop_value1);
		}
		scrollTop(driver);
		waitForElement(driver, Container_Tab);
		safeclick(driver, Container_Tab);
		waitForElement(driver, Container_Grid);
		String act_ContainerGrid_colour1 =getTextBackgroundColor(driver, Container_Color);
		if(!act_ContainerGrid_colour.equals(act_ContainerGrid_colour1)) {
			Extent_pass_New(driver,"Matched || After Reseting the Agreement party the container tab colour is Pink Color : " +act_ContainerGrid_colour1, test,test1);
			System.out.println("Matched || After Reseting the Agreement party the container tab colour is Pink Color : " +act_ContainerGrid_colour1);		
		}else {
			System.out.println("Not Matched || After Reseting the Agreement party the container tab colour is Not Pink Color : "+act_ContainerGrid_colour1);
			Extent_fail(driver,"Not Matched || After Reseting the Agreement party the container tab colour is Not Pink Color : "+act_ContainerGrid_colour1, test,test1);
		}
		scrollUsingElement(driver, Rate_No_Value);
		waitForElement(driver, Rate_No_Value);
		String Act_Rate_No1 = getText(driver, Rate_No_Value);
		if(!Act_Rate_No.equals(Act_Rate_No1)) {
			Extent_pass_New(driver,"Matched || After Reseting the Agreement party the container tab Rate No is Not displayed"+Act_Rate_No1, test,test1);
			System.out.println("Matched || After Reseting the Agreement party the container tab Rate No is Not displayed" +Act_Rate_No1);

		}else {
			System.out.println("Not Matched || After Reseting the Agreement party the container tab Rate No is : " +Act_Rate_No1);		
			Extent_fail(driver, "Not Matched || After Reseting the Agreement party the container tab Rate No is : " +Act_Rate_No1, test,test1);
		}
		scrollTop(driver);
		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForDisplay(driver, Charges_Grid_edit);
		if(!isDisplayed(driver, Charges_Grid_edit)) {
			Extent_pass_New(driver,"Matched || After Reseting the Agreement party the Charges Grid value is not displayed", test,test1);
			System.out.println("Matched || After Reseting the Agreement party the Charges Grid value is not displayed");
			Extent_pass_New(driver, "Charges Grid is not displayed ", test,test1);	
		}else {
			waitForElement(driver, chargesGrid);
			String chargesGrid_value1=getText(driver, chargesGrid);
			System.out.println("Not Matched || After Reseting the Agreement party the Charges Grid value is : "+chargesGrid_value1+" || Charges Grid is displayed");
			Extent_fail(driver,"Not Matched || After Reseting the Agreement party the Charges Grid value is :" +chargesGrid_value1+" || Charges Grid is displayed", test,test1);
		}
		Extent_call(test, test1,"********** Fetching the Values After Reset the Agreement Party - End **********");
		Extent_completed(test_Case_Name, test, test1);

	}
}

