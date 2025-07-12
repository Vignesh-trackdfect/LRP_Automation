package LRP_Booking_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC141  extends Keywords{


	public void Booking_SC141(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {


		// Values are taken from data sheet

		String test_Case_Name01 = "TC_Booking_SC141";

		String Username = Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String delivery =Excel_data.get("Delivery");
		String agencyUser =Excel_data.get("AgencyUser");	
		String Boundinput =Excel_data.get("Boundinput");
		String pluginID =Excel_data.get("pluginID");
		String Port_code_payat =Excel_data.get("Port_code_payat");
		String Search1 =Excel_data.get("Search1");
		String Moduleidinput =Excel_data.get("Moduleidinput");
		String Paymode_select =Excel_data.get("Paymode_select");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String rate_no = Excel_data.get("Rates_click");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String search_module = Excel_data.get("search_module");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String savedpopEXP = Excel_data.get("saved_draft_pop");

		Extent_Start(test_Case_Name01, test, test1);



		// Login

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		// switching the profile
		System.out.println("***Switch the Profile Start ***");
		Extent_call(test, test1,"********** Switch the Profile Start **********");
		SwitchProfile(driver, agencyUser);
		System.out.println("***Switch the Profile end ***");
		Extent_call(test, test1,"********** Switch the Profile end **********");
		Step_Start(6, "set RIC plugin true ",test, test1);
		// searching the module of booking

		moduleNavigate(driver, Search1);

		waitForElement(driver, pluginConfiguration_Tab);
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);

		waitForElement(driver, Moduleid);
		sendKeys(driver, Moduleid, Moduleidinput);
		doubleClick(driver, first_PluginID_Row2);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);


		waitForDisplay(driver, Truedisplay);
		if(isdisplayed(driver, Truedisplay)) {
			String status = getText(driver, truegettext);
			System.out.println("enable status shown as"+status);
			Extent_pass_New(driver, "enable status shown as"+status, test,test1);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);

		}else {

			waitForElement(driver, truegettext);
			safeclick(driver, truegettext);

			waitForElement(driver, True_Condition);
			safeclick(driver, True_Condition);

			String status = getText(driver, truegettext);
			System.out.println(status);
			Extent_pass_New(driver, "enable status shown as"+status, test,test1);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
		}

		Step_End(6, "set RIC plugin true",test, test1);


		// Searching the module name

		moduleNavigate(driver, search_module);
		Step_Start(1, " Enter the Agreement Party",test, test1);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);

		Step_Start(2, " Enter the POL and POD and select the Rates using Rates window.",test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);
		System.out.println("********** Enter the Orgin Input End **********");
		Extent_call(test, test1,"********** Enter the Orgin Input End  **********");

		System.out.println("********** Enter the Delivery Input Start **********");
		Extent_call(test, test1,"********** Enter the Delivery Input Start  **********");

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		System.out.println("********** Enter the Delivery Input End **********");
		Extent_call(test, test1,"********** Enter the Delivery Input End  **********");




		Step_End(2, " Enter the POL and POD and select the Rates using Rates window.",test, test1);

		Step_Start(3, "Select the Routing ",test, test1);
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		waitForElement(driver, Draft_Button);

		safeclick(driver, Draft_Button);

		Step_Start(5, "save the booking in Draft ",test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verification of saved popup of draft
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


		Step_End(5, "save the booking in Draft",test, test1);



		waitForElement(driver, booking_no);
		String draft_bookingColor1=getTextBackgroundColor(driver,booking_no);
		String draft_bookingColor=getColorName(draft_bookingColor1);
		if(draft_bookingColor.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		} 




		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);
		System.out.println("********** Pinting the Booking number **********");
		Extent_call(test, test1,"********** Pinting the Booking number*******");
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);
		Extent_pass_New(driver, "****Booking number was generated as****"+booknum, test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);


		waitForElement(driver, booking_status_field);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);


		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);



		Step_Start(7, "change the OFR paymode and system change ALLIN Y paymode",test, test1);		

		waitForElement(driver, selectofr);
		safeclick(driver, selectofr);
		RightClick(driver, selectofr);
		waitForElement(driver, Paymode);
		mouseOverToElement(driver, Paymode);


		String Paymode_select_type =  String.format(Booking_Locators.Paymode_select_typeee,Paymode_select);
		if(isdisplayed(driver, Paymode_select_type)) {
			mouseOverToElement(driver, Paymode_select_type);
			
			
			Extent_pass_New(driver,"Matched || Expected Pay mode should selected as  : "+Paymode_select+" || Actual  Pay mode  selected as : "+Paymode_select, test,test1);
			System.out.println("Matched || Expected Pay mode should selected as  : "+Paymode_select+" || Actual  Pay mode  selected as : "+Paymode_select);
			safeclick(driver, Paymode_select_type);
		}else {
			System.out.println("Not Matched || Expected Pay mode should selected as : "+Paymode_select+" || But Actual  Pay mode  selected as : "+Paymode_select);
			Extent_fail(driver,"Not Matched || Expected Pay mode should selected as : "+Paymode_select+" || But Actual  Pay mode  selected as : "+Paymode_select, test,test1);
		}	
			
			




		waitForElement(driver, portcodefilter);
		sendKeys(driver, portcodefilter, Port_code_payat);
		waitForElement(driver, BKGASEarchSelect);
		safeclick(driver, BKGASEarchSelect);

		List<WebElement> Allinvalues = listOfElements(driver, Allinvaluess);
	
		for(int i=0; i<Allinvalues.size();i++) {
String alvalue =  String.format(Booking_Locators.Paylocation_List,i);
		
			
			String value = getText(driver, alvalue);
			System.out.println( value);
			if(value.equals("Y")) {
				int i1 = (i+1);
				String num = String.valueOf(i1);
				String Paymentmode =  String.format(Booking_Locators.Paymentmodee,num);
				String Paymode= getText(driver, Paymentmode);
				System.out.println(Paymode);
				Extent_pass_New(driver,"**Payment mode shown as**"+ Paymode, test, test1);
				String Payby =  String.format(Booking_Locators.Paybyy,num);
				String Pay= getText(driver, Payby);
				System.out.println(Pay);
				click(driver, Payby);
				Extent_pass_New(driver,"**Pay_By mode shown as**"+ Pay, test, test1);
				String Paylocation =  String.format(Booking_Locators.Paylocationn,num);
				String Payloc= getText(driver, Paylocation);
				System.out.println(Payloc);
				Extent_pass_New(driver,"**Pay_Location  shown as**"+ Payloc, test, test1);
				System.out.println("y is presemt");	






				String Payofr= getText(driver, Paybyofrr);
				click(driver, Paybyofrr);
				Extent_pass_New(driver, "**Pay_By was shown in OFR as**"+Payofr, test, test1);


				String Paymodeofr= getText(driver, Paymentmodeofrr);
				click(driver, Paymentmodeofrr);
				Extent_pass_New(driver, "**Payment_mode was shown in OFR as**"+Paymodeofr, test, test1);



				String Paylocofr= getText(driver, Paylocationofrr);
				click(driver, Paylocationofrr);
				Extent_pass_New(driver, "**Payment_location was shown in OFR as**"+Paylocofr, test, test1);


				if(Pay.equals(Payofr)) {
					System.out.println(
							"Matched || " + " Expected Activity is Pay By was  changed as in given OFR Coloum: " + Pay + " || Actual Activity Pay By was  changed as in given OFR Coloumis : " + Payofr);
					Extent_pass_New(driver,
							"Matched || " + " Expected Activity is Pay By was  changed as in given OFR Coloum: " + Pay + " || Actual Activity Pay By was  changed as in given OFR Coloum is : " + Payofr, test,test1);
					Extent_pass_New(driver, "**Pay By was  changed as in given OFR Coloum**", test, test1);
				} else {
					System.out.println(
							"Not matched || " + " Expected Activity is Pay By was  changed as in given OFR Coloum: " + Pay + " || Actual Activity Pay By was  not changed as in given OFR Coloum is : " + Payofr);
					Extent_fail(driver,
							"Not matched || " + " Expected Activity is Pay By was  changed as in given OFR Coloum: " + Pay + " || Actual Activity is Pay By was not changed as in given OFR Coloum: " + Payofr,
							test,test1);
				}



				if(Paymode.equals(Paymodeofr)) {
					System.out.println(
							"Matched || " + " Expected Activity Pay Mode was  changed as in given OFR Coloum : " + Paymode + " || Actual Activity Pay Mode was  changed as in given OFR Coloum : " + Paymodeofr);
					Extent_pass_New(driver,
							"Matched || " + " Expected Activity Pay Mode was  changed as in given OFR Coloum : " + Paymode + " || Actual Activity Pay Mode was  changed as in given OFR Coloum : " + Paymodeofr, test,test1);
					Extent_pass_New(driver, "**Pay Mode was  changed as in given OFR Coloum**", test, test1);
				} else {
					System.out.println(
							"Not matched || " + " Expected Activity Pay Mode was  changed as in given OFR Coloum : " + Paymode + " || Actual Activity Pay Mode was  not changed as in given OFR Coloum : " + Paymodeofr);
					Extent_fail(driver,
							"Not matched || " + " Expected Activity Pay Mode was  changed as in given OFR Coloum : " + Paymode + " || Actual Activity Pay Mode was not  changed as in given OFR Coloum : " + Paymodeofr,
							test,test1);
				}



				if(Payloc.equals(Paylocofr)) {
					System.out.println(
							"Matched || " + " Expected Activity Pay location was  changed as in given OFR Coloum : " + Payloc + " || Actual Activity Pay location was  changed as in given OFR Coloum : " + Paylocofr);
					Extent_pass_New(driver,
							"Matched || " + " Expected Activity Pay location was  changed as in given OFR Coloum : " + Payloc + " || Actual Activity Pay location was  changed as in given OFR Coloum : " + Paylocofr, test,test1);
					Extent_pass_New(driver, "**Pay location was  changed as in given OFR Coloum**", test, test1);
				} else {
					System.out.println(
							"Not matched || " + " Expected Activity Pay location was  changed as in given OFR Coloum : " + Payloc + " || Actual Activity Pay location was not changed as in given OFR Coloum : " + Paylocofr);
					Extent_fail(driver,
							"Not matched || " + " Expected Activity Pay location was  changed as in given OFR Coloum : " + Payloc + " || Actual Activity Pay location was not changed as in given OFR Coloum : " + Paylocofr,
							test,test1);
				}


				Step_End(7, "change the OFR paymode and system change ALLIN Y paymode",test, test1);

			}


		}

		Extent_completed(test_Case_Name01, test, test1);

	}}
