package LRP_Booking_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC098 extends Keywords {

	public void Booking_SC098(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name = "TC_Booking_SC098";
		
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser = Excel_data.get("agencyUser");
		String no_of_booking = Excel_data.get("no_of_booking");
		String ship_opt = Excel_data.get("ship_opt");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String rate_no = Excel_data.get("rate_no");
		String Search_input_OP = Excel_data.get("Search_input_OP");
		String grpbtn1 = Excel_data.get("grpbtn1");
		String grpbtn2 = Excel_data.get("grpbtn2");
		String cargo_wt = Excel_data.get("cargo_wt");
		String wisebtn = Excel_data.get("wisebtn");
		String Search_input_SB = Excel_data.get("Search_input_SB");
		String vesselinp = Excel_data.get("vesselinp");
		String cargotype_inp = Excel_data.get("cargotype_inp");
		String pod_inp = Excel_data.get("pod_inp");
		String sztp_inp = Excel_data.get("sztp_inp");
		String container_inp = Excel_data.get("container_inp");
		String carrierseal_inp = Excel_data.get("carrierseal_inp");
		String remarks_inp = Excel_data.get("remarks_inp");
		String save_status = Excel_data.get("save_status");
		String condition = Excel_data.get("condition");
		String select_by_size_type = Excel_data.get("select_by_size_type");
		String select_by_book_number = Excel_data.get("select_by_book_number");
		String dd1_condition = Excel_data.get("dd1_condition");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
        String Service_header =Excel_data.get("Service_header");
        String Service_header_filter =Excel_data.get("Service_Filter");
        String Service_header_value =Excel_data.get("Service_header_Value");
        String PortCode_header =Excel_data.get("PortCode_header");
        String VIN_Number_header =Excel_data.get("VIN_Number_header");
        String VIN_Number_condition =Excel_data.get("VIN_Number_condition");
        String VIN_Number_header_value =Excel_data.get("VIN_Number_header_value");
        String vessel_header =Excel_data.get("vessel_header");
      
     
        
        
		// locators

		String ship_type = String.format(Booking_Locators.ship_type, ship_opt);
		String select_grpbtn1 = String.format(Booking_Locators.select_grpbtn1, grpbtn1);
		String select_grpbtn2 = String.format(Booking_Locators.select_grpbtn2, grpbtn2);
		String cargotype = String.format(Booking_Locators.cargotype, cargotype_inp);
		String SB_savestatus = String.format(Booking_Locators.SB_savestatus, save_status);
		

		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		Extent_call(test, test1, "**Switch the Profile Start**");

		SwitchProfile(driver, agencyUser);

		Extent_cal(test, test1, "** Enter Booking Module **");

		// Instead of clicking the first module dropdown , this method select the module
		// name by using excel test data
		moduleNavigate(driver, search_module);
		int num_of_booking = Integer.parseInt(no_of_booking);
		List<String> bookNumbers = new ArrayList<String>();
		for (int i = 1; i <= num_of_booking; i++) {
			waitForElement(driver, shiptype_field);
			click(driver, shiptype_field);
			waitForElement(driver, ship_type);
			click(driver, ship_type);

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
			
			Step_Start(6, "Save the booking in Draft", test, test1);

			waitForElement(driver, Draft_Button);
			safeclick(driver, Draft_Button);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			mouseOverToElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);
			
			

			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			

			waitForElement(driver, booking_no);

			String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
			String draft_bookingColor = getColorName(draft_bookingColorCode);

			if (draft_bookingColor.equals(booking_draft_Color)) {
				System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
				Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
			}else {                                                                                                                                                                   
				System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
				Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
			} 
			Step_End(6, "Save the booking in Draft", test, test1);

			waitForElement(driver, master_tab);
			click(driver, master_tab);

			String booknum = getAttribute(driver, booking_no, "value");
			bookNumbers.add(booknum);
			System.out.println(bookNumbers);

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			Step_Start(7, "Save the booking in Confirmed", test, test1);
			waitForElement(driver, Confirmed_Button);
			safeclick(driver, Confirmed_Button);

			waitForElement(driver, Charges_tab);
			click(driver, Charges_tab);

			waitForElement(driver, AutoRated);
			click(driver, AutoRated);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click1(driver, SaveButton_ToolBar);

			waitForElement(driver, popup_Message);
			click(driver, popup_Message_Ok_Button);

			waitForElement(driver, booking_no);
			String actualConfirmedColorCode = getTextBackgroundColor(driver, Booking_No_Field);
			String submit_bookingColor = getColorName(actualConfirmedColorCode);

			
			if (submit_bookingColor.equals(booking_confirmed_Color)) {
					System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + submit_bookingColor + " || The Actual Report Activity is : " + booking_confirmed_Color+" [ Booking number input field  changed to green colour ]");            
					Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + submit_bookingColor + " || The Actual Report Activity is : " + booking_confirmed_Color+" [ Booking number input field  changed to green colour ]", test, test1);     
				}else {                                                                                                                                                                   
					System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + submit_bookingColor + " || The Actual Report Activity is : " + booking_confirmed_Color+" [ Booking number input field  Not changed to green colour ]");        
					Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + submit_bookingColor + " || The Actual Report Activity is : " + booking_confirmed_Color+" [ Booking number input field  Not changed to green colour ]", test, test1); 
				}
			Step_End(7, "Save the booking in Confirmed", test, test1);
			scrollTop(driver);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, noncon_tab);
			click(driver, noncon_tab);
           scrollBottom(driver);
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

			waitForDisplay(driver, popup_Message);
			if (isDisplayed(driver, popup_Message)) {
				
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
             scrollTop(driver);
				mouseOverToElement(driver, Charges_tab);
				waitForElement(driver, Charges_tab);
				
				click(driver, Charges_tab);

				waitForElement(driver, AutoRated);
				click(driver, AutoRated);
			}
			 scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			mouseOverToElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForElement(driver, popup_Message);
			waitForElement(driver, popup_Message_Ok_Button);

			click(driver, popup_Message_Ok_Button);

			Step_End(7, "Save the booking in Confirmed", test, test1);

			waitForElement(driver, master_tab);
			click(driver, master_tab);

			newButton(driver);
		}
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_Start(2, "Revert Plan in Operation reset module", test, test1);

		moduleNavigate(driver, Search_input_OP);

		waitForElement(driver, group_btn1);
		waitForElement(driver, select_grpbtn1);
		click(driver, select_grpbtn1);

		if (!wisebtn.equals("")) {
			waitForElement(driver, group_btn1);
			waitForElement(driver, select_grpbtn2);
			click(driver, select_grpbtn2);
		} else {
			System.out.println("wisebtn " + "Input Not Available in : " );
		}
		for (String bookNumber : bookNumbers) {
			waitForElement(driver, OP_bookno);
			clear(driver, OP_bookno);
			waitForElement(driver, OP_bookno);
			sendKeys(driver, OP_bookno, bookNumber);

			waitForElement(driver, OP_vin_searchicon);
			click(driver, OP_vin_searchicon);
			
			twoColumnSearchWindow(driver, VIN_Number_header, VIN_Number_condition, VIN_Number_header_value);

			waitForElement(driver, OP_loadbtn);
			click(driver, OP_loadbtn);

			waitForElement(driver, OP_datagrid);
			click(driver, OP_datagrid);

			waitForElement(driver, OP_icon);
			click(driver, OP_icon);

			waitForElement(driver, op_action);
			click(driver, op_action);

			waitForElement(driver, popup_Message);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			waitForDisplay(driver, popup_Message_Ok_Button);
			if (isDisplayed(driver, popup_Message_Ok_Button)) {
				waitForElement(driver, popup_Message_Ok_Button);
				click(driver, popup_Message_Ok_Button);
			}
		}
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		// stuff booking
		moduleNavigate(driver, Search_input_SB);

		waitForElement(driver, SB_service_searchbtn);
		click(driver, SB_service_searchbtn);
		
	    twoColumnSearchWindow(driver, Service_header, Service_header_filter, Service_header_value);
		
	    waitForElement(driver, SB_vessel_searchbtn);
		click(driver, SB_vessel_searchbtn);
	    
	    twoColumnSearchWindow(driver, vessel_header, condition, vesselinp);
		  
	    
	    
	    waitForElement(driver, SB_voyage_field);
		sendKeys(driver, SB_voyage_field, Voyagenumber1);
		waitForElement(driver, SB_schedule_selbtn);
		click(driver, SB_schedule_selbtn);
		
		waitForElement(driver, SB_pod_searchbtn);
		click(driver, SB_pod_searchbtn);
		twoColumnSearchWindow(driver, PortCode_header, condition, pod_inp);
	    
		

		waitForElement(driver, SB_cargopanel);
		waitForElement(driver, cargotype);
		click(driver, cargotype);

		waitForElement(driver, SB_showbtn);
		click(driver, SB_showbtn);
		waitForElement(driver, Stuff_Tool_Panel);
		click(driver, Stuff_Tool_Panel);
		waitForElement(driver, Filter);
		click(driver, Filter);
		waitForElement(driver, bookNo_Filter);
		click(driver, bookNo_Filter);
		for (String bookNumber : bookNumbers) {
			waitForElement(driver, bookNo_Filter);
			sendKeys(driver, bookNo_Filter, bookNumber);
			waitForElement(driver, SB_datagrid);
			String SB_datagrid = String.format(Booking_Locators.SB_datagrid98, bookNumber);
			waitForElement(driver, SB_datagrid);
			click(driver, SB_datagrid);
			waitForElement(driver, bookNo_Filter);
			clear(driver, bookNo_Filter);
		}
		waitForElement(driver, SB_container_searchicon);
		click(driver, SB_container_searchicon);
		
		
		globalValueSearchWindow1(driver, condition, select_by_size_type, sztp_inp, "","", "", "");

		waitForElement(driver, SB_container_serachfield);
		sendKeys(driver, SB_container_serachfield, container_inp);

		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
		
		waitForElement(driver, SB_carrierseal);
		sendKeys(driver, SB_carrierseal, carrierseal_inp);

		waitForElement(driver, SB_remarks);
		sendKeys(driver, SB_remarks, remarks_inp);

		waitForElement(driver, SB_savestatus);
		click(driver, SB_savestatus);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		waitForElement(driver, Stuff_Tool_Panel);
		click(driver, Stuff_Tool_Panel);
		waitForElement(driver, Filter);
		click(driver, Filter);
		waitForElement(driver, bookNo_Filter);
		click(driver, bookNo_Filter);
		sendKeys(driver, bookNo_Filter, bookNumbers.get(0));
		String SB_booknum = String.format(Booking_Locators.SB_booknum, bookNumbers.get(0));

		waitForElement(driver, SB_booknum);
		String stuff_booknum = getText(driver, SB_booknum);
		System.out.println("stuff book num: " + stuff_booknum);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		// booking

		// Instead of clicking the first module dropdown , this method select the module
		// name by using excel test data
		moduleNavigate(driver, search_module);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dd1_condition, select_by_book_number, stuff_booknum, "","", "", "");

		waitForElement(driver, remarks_Tab );
		click(driver, remarks_Tab );
		waitForElement(driver, System_Remarks);
		String system_Remarks = getText(driver, System_Remarks);
		if (system_Remarks.contains(bookNumbers.get(0))) {
			
			System.out.println(
					"Matched || " + "   The Expected System Remarks is : " +bookNumbers.get(0) + " || The Actual System Remarks is : " + system_Remarks);
			Extent_pass_New(driver,
					"Matched || " + "  The Expected System Remarks is : " +bookNumbers.get(0) + " || The Actual System Remarks is : " + system_Remarks, test,test1);
		} else {
			System.out.println(
					"NotMatched || " + "   The Expected System Remarks is : " +bookNumbers.get(0) + " || The Actual System Remarks is : " + system_Remarks);
			Extent_fail(driver,
					"NotMatched || " + "  The Expected System Remarks is : " +bookNumbers.get(0) + " || The Actual System Remarks is : " + system_Remarks, test,test1);
		}
	

		Extent_completed(tc_Name, test, test1);

	}

}
