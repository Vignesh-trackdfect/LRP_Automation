package LRP_Booking_Scripts;

import java.util.Map;


import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC080 extends Keywords{

	public void Booking_SC080 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		
		String tc_Name="TC_Booking_SC080";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");	
		String search_module = Excel_data.get("search_module").trim();
		String agencyUser = Excel_data.get("agencyUser");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String rate_no = Excel_data.get("rate_no");
		String ship_opt = Excel_data.get("shipment_opt");
		String Search_input_OP = Excel_data.get("Search_input_OP");
		String grpbtn1 = Excel_data.get("grpbtn1");
		String cargo_wt = Excel_data.get("cargo_wt");
		String wisebtn = Excel_data.get("wisebtn");
		String book_action = Excel_data.get("book_action");
		String Search_input_SB = Excel_data.get("Search_input_SB").trim();
		String cargotype_inp = Excel_data.get("cargotype_inp");
		String Port_inp = Excel_data.get("Port_inp");
		String sztp_inp = Excel_data.get("sztp_inp");
		String container_inp = Excel_data.get("container_inp");
		String carrierseal_inp = Excel_data.get("carrierseal_inp");
		String remarks_inp = Excel_data.get("remarks_inp");
		String save_status = Excel_data.get("save_status");
		String NORdata = Excel_data.get("NORdata");
		String valid_Days_Input = Excel_data.get("valid_Days_Input");
		String select_by_size_type = Excel_data.get("select_by_size_type");
		String condition = Excel_data.get("condition");
		String select_by_book_number = Excel_data.get("select_by_book_number");
		String dd1_condition = Excel_data.get("dd1_condition");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Vessel_code_search = Excel_data.get("Vessel_code_search");
		String Service_code_search = Excel_data.get("Service_code_search");
		String Port_code_search = Excel_data.get("Port_code_search");
		String Containe_No_Input = Excel_data.get("Containe_No_Input");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		
		//locators

	

		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1,"**Switch the Profile Start**");

		SwitchProfile(driver, agencyUser);

		Extent_cal(test, test1,"** Enter Booking Module **");


		
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
		moduleNavigate(driver, search_module);

		waitForElement(driver, shiptype_field);
		click(driver, shiptype_field);
		formatLocatorClick(driver, ship_type, ship_opt);
		
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
		waitForElement(driver,Valid_Days);
		clearAndType(driver, Valid_Days, valid_Days_Input);	
		waitForElement(driver, Rates_Show_Btn);
		safeclick(driver, Rates_Show_Btn);
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		click(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
		waitForElement(driver, Rate_No_Select);
		click(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		click(driver, ok_btn);
		Step_End(4, "Select the Routing", test, test1);

		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_Start(6, "Save the booking in Draft", test, test1);
		waitForElement(driver, FirstserviceInput);
		String service_Value = getAttribute(driver, FirstserviceInput, "value");
		String vessle_Value = getText(driver, vessleValue);
		String voyage_Value = getText(driver, voyageValue);
		
		waitForElement(driver, Draft_Button);
		safeclick(driver, Draft_Button);
scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verify saved pop up of draft

		if (savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT);
			Extent_pass_New(driver, "Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT, test,test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT);
			Extent_fail(driver, "Not Matched || Expected popup: " + savedpopEXP + "|| Actual Popup:" + savepopACT, test,test1);
		}

		waitForElement(driver, booking_no);
		String draft_bookingColor_Code=getTextBackgroundColor(driver,booking_no);
		String draft_bookingColor = getColorName(draft_bookingColor_Code);
		if(draft_bookingColor.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + booking_draft_Color + " || Actual Report Activity is : " + draft_bookingColor);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is[Booking number input field want to change green colour] : " + booking_confirmed_Color + " || Actual Report Activity is [Booking number input field  changed yellow colour] : " + draft_bookingColor, test, test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + booking_draft_Color + " || Actual Report Activity is : " + draft_bookingColor);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is[Booking number input field not  changed green colour] : " + booking_draft_Color + " || Actual Report Activity is[Booking number input field not  changed yellow colour] : " + draft_bookingColor, test, test1); 
		} 
		Step_End(6, "Save the booking in Draft", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_Start(7, "Save the booking in Confirmed_Button", test, test1);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);

		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		click(driver, AutoRated);

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

		waitForElement(driver, booking_no);	
		String submit_bookingColorCode=getTextBackgroundColor(driver,booking_no);
		String submit_bookingColor = getColorName(submit_bookingColorCode);
		if(submit_bookingColor.equals(booking_confirmed_Color)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + booking_confirmed_Color + " || Actual Report Activity is : " + submit_bookingColor);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is[Booking number input field want to change green colour] : " + booking_confirmed_Color + " || Actual Report Activity is [Booking number input field  changed yellow colour] : " + submit_bookingColor, test, test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + booking_confirmed_Color + " || Actual Report Activity is : " + submit_bookingColor);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is[Booking number input field not  changed green colour] : " + booking_confirmed_Color + " || Actual Report Activity is[Booking number input field not  changed yellow colour] : " + submit_bookingColor, test, test1); 
		} 
		Step_End(7, "Save the booking in Confirmed_Button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, noncon_tab);
		click(driver, noncon_tab);

		waitForElement(driver, noncon_editicon);
		click(driver, noncon_editicon);

		waitForElement(driver, noncon_cargo);
		clear(driver, noncon_cargo);
		waitForElement(driver, noncon_cargo);
		sendKeys(driver, noncon_cargo, cargo_wt);
		waitForElement(driver, volume);
		click(driver, volume);
		waitForElement(driver, noncon_editbtn);
		click(driver, noncon_editbtn);

		waitForDisplay(driver, weight_changed_popup);
		if(isDisplayed(driver, weight_changed_popup)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			waitForElement(driver, Charges_tab);
			click(driver, Charges_tab);

			waitForElement(driver, AutoRated);
			click(driver, AutoRated);
		}
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		//operationreset module
		moduleNavigate(driver, Search_input_OP);
		formatLocatorClick(driver, select_grpbtn1, grpbtn1);
		if(!wisebtn.equals("")) {
			formatLocatorClick(driver, select_grpbtn2, wisebtn);
			}
		waitForElement(driver, OP_bookno);
		sendKeys(driver, OP_bookno, booknum);
		
		waitForElement(driver, OP_vin_searchicon);
		click(driver, OP_vin_searchicon);
		waitForElement(driver, select_Button);
		click(driver, select_Button);

		waitForElement(driver, OP_loadbtn);
		click(driver, OP_loadbtn);

		waitForElement(driver, OP_datagrid);
		click(driver, OP_datagrid);

		waitForElement(driver, OP_icon);
		click(driver, OP_icon);

		formatLocatorClick(driver, op_action, book_action);

		waitForElement(driver, popup_Message_Yes_Button);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		//stuff booking
		waitForElement(driver, Search_Input);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
		moduleNavigate(driver, Search_input_SB);


		waitForElement(driver, SB_service_searchbtn);
		click(driver, SB_service_searchbtn);
		twoColumnSearchWindow(driver, Service_code_search, condition, service_Value);


		waitForElement(driver, SB_vessel_searchbtn);
		click(driver, SB_vessel_searchbtn);
		twoColumnSearchWindow(driver, Vessel_code_search, condition, vessle_Value);

		

		waitForElement(driver, SB_voyage_field);
		sendKeys(driver, SB_voyage_field, voyage_Value);
		waitForElement(driver, SB_schedule_selbtn);
		click(driver, SB_schedule_selbtn);
		waitForElement(driver, SB_pod_searchbtn);
		click(driver, SB_pod_searchbtn);
		twoColumnSearchWindow(driver, Port_code_search, condition, Port_inp);

		formatLocatorClick(driver, Booking_Locators.cargotype, cargotype_inp);
		
		waitForElement(driver, SB_showbtn);
		click(driver, SB_showbtn);
		waitForElement(driver, Stuff_Tool_Panel);
		click(driver, Stuff_Tool_Panel);
		waitForElement(driver, Filter);
		click(driver, Filter);
		waitForElement(driver, bookNo_Filter);
		click(driver, bookNo_Filter);
		sendKeys(driver, bookNo_Filter, booknum);
		waitForElement(driver, SB_datagrid);
		String SB_datagrid =String.format(Booking_Locators.SB_datagrid80, booknum);
		waitForElement(driver, SB_datagrid);
		click(driver, SB_datagrid);

		waitForElement(driver, SB_container_searchicon);
		click(driver, SB_container_searchicon);
		//
		globalValueSearchWindow(driver, dd1_condition, select_by_size_type, sztp_inp, Containe_No_Input, container_inp, "", "");
		
		//
		
	

		waitForElement(driver, SB_carrierseal);
		sendKeys(driver, SB_carrierseal, carrierseal_inp);

		waitForElement(driver, SB_remarks);
		sendKeys(driver, SB_remarks, remarks_inp);

		formatLocatorClick(driver, SB_savestatus, save_status);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		waitForElement(driver, Stuff_Tool_Panel);
		click(driver, Stuff_Tool_Panel);
		waitForElement(driver, Filter);
		click(driver, Filter);
		waitForElement(driver, bookNo_Filter);
		click(driver, bookNo_Filter);
		sendKeys(driver, bookNo_Filter, booknum);
		String SB_booknum =String.format(Booking_Locators.SB_booknum, booknum);
		waitForElement(driver, SB_booknum);
		String stuff_booknum=getText(driver, SB_booknum);
		System.out.println("stuff book num: "+stuff_booknum);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		//booking


		moduleNavigate(driver, search_module);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		//
		globalValueSearchWindow(driver, dd1_condition, select_by_book_number, stuff_booknum, "", "", "", "");
		
		waitForElement(driver, container_tab);
		click(driver, container_tab);

		waitForElement(driver, NOR_valuegrid);
		String NORvalue=getText(driver, NOR_valuegrid);
		if(NORvalue.equals(NORdata)) {
			Extent_pass_New(driver,"Matched || Excepted Result is :"+ NORdata+" || Actual Result is :"+NORvalue, test,test1);
			System.out.println("Matched || Excepted Result is :"+ NORdata+" || Actual Result is :"+NORvalue); 
		} else {
			System.out.println("Not Matched || Excepted Result is :"+ NORdata+" || Actual Result is :"+NORvalue);
			Extent_fail(driver,"Not Matched || Excepted Result is :"+ NORdata+" || Actual Result is :"+NORvalue, test,test1);
		}
		Extent_completed(tc_Name, test, test1);
	}
}
