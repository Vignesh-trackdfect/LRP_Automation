package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC059 extends Keywords{
	public void Booking_SC059(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC059";
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
		String savedpopEXP = Excel_data.get("savedpop");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String Select_Columns = Excel_data.get("Select_Columns");
		String DG_Input =Excel_data.get("DG_Input");
		String IMO_Popup_Details1 =Excel_data.get("IMO_Popup_Details_AddContact");
		String IMO_Popup_Details2 =Excel_data.get("IMO_Popup_Telephone_Details");
		String booking_draft_Color = Excel_data.get("Yellowcolour");
		String HazContact_Input = Excel_data.get("HazContact_Input");
		String valid_Days_Input = Excel_data.get("valid_Days_Input");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");

		Extent_Start(test_Case_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);

		Extent_call(test, test1,"********** Switch the Profile  - End **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
				moduleNavigate(driver, Search);
		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);

		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		keyboardArrowDown(driver);
		enter(driver);
		waitForElement(driver, DeliveryInput);
		safeclick(driver, DeliveryInput);
		clearAndType(driver, DeliveryInput, delivery);
		keyboardArrowDown(driver);
		enter(driver);
		Step_End(2, "Enter the POL and POD and select the Rates using Rates window",test, test1);
		Step_Start(3, "Select the routing", test, test1);
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

		Extent_call(test, test1,"********** Select the Check Box in Rates Window **********");

		waitForElement(driver,Valid_Days);
		clearAndType(driver, Valid_Days, valid_Days_Input);	

		waitForElement(driver, Commodity_Chk_Box);
		checkBox(driver, Commodity_Chk_Box,Commodity_Chk_Box_Exp);
		waitForElement(driver, DG_Chk_Box);
		checkBox(driver, DG_Chk_Box,DG_Chk_Box_Exp);
		waitForElement(driver, Tar_Chk_Box);
		checkBox(driver, Tar_Chk_Box,Tar_Chk_Box_Exp);
		waitForElement(driver, Rates_Show_Btn);
		safeclick(driver, Rates_Show_Btn);

		Extent_call(test, test1,"********** Select the Columns in Rates Window **********");
		reArrangeAG_GridColumns(driver, Select_Columns);
		Extent_call(test, test1,"********** Create the condition filter in Rates Window **********");
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);
		waitForElement(driver, DG_Column_Field);
		sendKeys(driver, DG_Column_Field,DG_Input);
		waitForElement(driver, UnNo_Column_Field);
		safeclick(driver, UnNo_Column_Field);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);

		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);

		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		
		Step_End(3,"Select the routing", test, test1);
										Step_Start(4, "save the booking in Draft", test, test1);
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

		waitForElement(driver, Draft_Button);
		safeclick(driver, Draft_Button);
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
		Step_End(4,"save the booking in Draft", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		Step_Start(5, "attached container DG ",test, test1);
		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);
		waitForElement(driver, Commodity_Edit);
		safeclick(driver, Commodity_Edit);
		waitForElement(driver, Hazard_Togler);
		safeclick(driver, Hazard_Togler);
		waitForElement(driver, Commodity_Add);
		safeclick(driver, Commodity_Add);
		Step_End(5, "attached container DG ",test, test1);

		Step_Start(6, "Verify the Imo Popups",test, test1);
		waitForElement(driver, IMO_Popup);
		String actualUpdatedPopup=getText(driver, IMO_Popup);
		if(actualUpdatedPopup.contains(IMO_Popup_Details1)) {
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+IMO_Popup_Details1+"|| Actual Pop-up value is :"+actualUpdatedPopup , test,test1);
			System.out.println("Matched || Expected Pop-up value is : "+IMO_Popup_Details1+"|| Actual Pop-up value is :"+actualUpdatedPopup);
		}else {
			System.out.println("Not Matched || Expected Pop-up value is : "+IMO_Popup_Details1+"|| Actual Pop-up value is :"+actualUpdatedPopup);
			Extent_fail(driver,"Not Matched || Expected Pop-up value is : "+IMO_Popup_Details1+"|| Actual Pop-up value is :"+actualUpdatedPopup, test,test1);
		}
		waitForElement(driver, IMO_Popup_Close);
		click1(driver, IMO_Popup_Close);
		waitForElement(driver, Hazard_Togler);
		safeclick(driver, Hazard_Togler);
		waitForElement(driver, HazContact_Field);
		sendKeys(driver, HazContact_Field, HazContact_Input);
		waitForElement(driver, Commodity_Add);
		safeclick(driver, Commodity_Add);
		waitForElement(driver, IMO_Popup);
		String actualUpdatedPopup1=getText(driver, IMO_Popup);
		if(actualUpdatedPopup1.contains(IMO_Popup_Details2)) {
			Extent_pass_New(driver,"Matched || Expected Pop-up value is : "+IMO_Popup_Details2+"|| Actual Pop-up value is :"+actualUpdatedPopup1, test,test1);
			System.out.println("Matched || Expected Pop-up value is : "+IMO_Popup_Details2+"|| Actual Pop-up value is :"+actualUpdatedPopup1);
		}else {
			System.out.println("Not Matched || Expected Pop-up value is : "+IMO_Popup_Details2+"|| Actual Pop-up value is :"+actualUpdatedPopup1);
			Extent_fail(driver,"Not Matched || Expected Pop-up value is : "+IMO_Popup_Details2+"|| Actual Pop-up value is :"+actualUpdatedPopup1, test,test1);
		}
		Step_End(6, "Verify the Imo Popups",test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}
