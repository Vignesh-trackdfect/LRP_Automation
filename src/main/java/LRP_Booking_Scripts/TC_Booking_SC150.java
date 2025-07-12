package LRP_Booking_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC150 extends Keywords{

	public void Booking_SC150 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String tc_Name="TC_Booking_SC150";

		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");	
		String search_module = Excel_data.get("search_module");
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
		String ship_opt = Excel_data.get("ship_opt");
		String Search_input_OP = Excel_data.get("Search_input_OP");
		String grpbtn1 = Excel_data.get("grpbtn1");
		String cargo_wt = Excel_data.get("cargo_wt");
		String wisebtn = Excel_data.get("wisebtn");
		String book_action = Excel_data.get("book_action");
		String Search_input_SB = Excel_data.get("Search_input_SB");
		String vesselinp = Excel_data.get("vesselinp");
		String cargotype_inp = Excel_data.get("cargotype_inp");
		String pod_inp = Excel_data.get("pod_inp");
		String sztp_inp = Excel_data.get("sztp_inp");
		String container_inp = Excel_data.get("container_inp");
		String carrierseal_inp = Excel_data.get("carrierseal_inp");
		String remarks_inp = Excel_data.get("remarks_inp");
		String save_status = Excel_data.get("save_status");
		String valid_Days_Input = Excel_data.get("valid_Days_Input");
		String select_by_book_number = Excel_data.get("select_by_book_number");
		String dd1_condition = Excel_data.get("dd1_condition");
		String select_by_size_type = Excel_data.get("select_by_size_type");
		String condition = Excel_data.get("condition");
		String globalSearchFilterOption2=Excel_data.get("GlobalSearchFilterOption2");
		String globalSearchFilterOption3=Excel_data.get("GlobalSearchFilterOption3");
		String searchValue2=Excel_data.get("searchValue2");
		String searchValue3=Excel_data.get("searchValue3");
		String globalSearchFilterOption2_B=Excel_data.get("GlobalSearchFilterOption2_B");
		String globalSearchFilterOption3_B=Excel_data.get("GlobalSearchFilterOption3_B");
		String searchValue2_B=Excel_data.get("searchValue2_B");
		String searchValue3_B=Excel_data.get("searchValue3_B");
		String globalSearchFilterOption2_SB=Excel_data.get("GlobalSearchFilterOption2_SB");
		String globalSearchFilterOption3_SB=Excel_data.get("GlobalSearchFilterOption3_SB");
		String searchValue3_SB=Excel_data.get("searchValue3_SB");
		String Vin_Chassis_Header=Excel_data.get("Vin_Chassis_Header");
		String service_Search_Header=Excel_data.get("Service_Search_Header");
		String vessel_Search_Header=Excel_data.get("Vessel_Search_Header");
		String POD_Search_Header=Excel_data.get("POD_Search_Header");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		//locators
		String ship_type =String.format(Booking_Locators.ship_type, ship_opt);
		
		String select_grpbtn1 =String.format(Booking_Locators.select_grpbtn1, grpbtn1);
		String select_grpbtn2 =String.format(Booking_Locators.select_grpbtn2, wisebtn);
		String op_action=String.format(Booking_Locators.op_action, book_action);
		String cargotype =String.format(Booking_Locators.cargotype, cargotype_inp);
		String SB_savestatus =String.format(Booking_Locators.SB_savestatus, save_status);


		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1,"**Switch the Profile Start**");

		
		SwitchProfile(driver, agencyUser);

		Extent_cal(test, test1,"** Enter Booking Module **");

				moduleNavigate(driver, search_module);

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
		
		editSchedule(driver, first_service_data);
		
		Step_Start(6, "Save the booking in Draft", test, test1);

		waitForElement(driver, Draft_Button);
		safeclick(driver, Draft_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

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

		Step_End(6, "Save the booking in Draft", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);
scrollTop(driver);
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
		jsClick(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		waitForElement(driver, booking_no);	
		String actualConfirmedColorCode=getTextBackgroundColor(driver, Booking_No_Field);
		String submit_bookingColor=getColorName(actualConfirmedColorCode);

		if(submit_bookingColor.equals(booking_confirmed_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + submit_bookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		}  


		Step_End(7, "Save the booking in Confirmed", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, noncon_tab);
		click(driver, noncon_tab);

		waitForElement(driver, non_Containerized_Table_Row);

		List<Map<String, String>> non_Containerized_Details_Table = getTableData(driver, non_Containerized_Table_Header, non_Containerized_Table_Row);
		List<String> vin_Chassis_No = getValuesByHeader(non_Containerized_Details_Table, "VIN/Chassis No.");
		
		System.out.println("vin_Chassis_No : "+vin_Chassis_No);
		String actual_Vin_Chassis_No=vin_Chassis_No.get(0);
		
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
		if(isDisplayed(driver, popup_Message)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);

			waitForElement(driver, Charges_tab);
			click(driver, Charges_tab);

			waitForElement(driver, AutoRated);
			click(driver, AutoRated);
		}
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		//operationreset module
				moduleNavigate(driver, Search_input_OP);

		waitForElement(driver, group_btn1);
		waitForElement(driver, select_grpbtn1);
		click(driver, select_grpbtn1);

		if(!wisebtn.equals("")) {
			waitForElement(driver, group_btn1);
			waitForElement(driver, select_grpbtn2);
			click(driver, select_grpbtn2);
		}
		waitForElement(driver, OP_bookno);
		sendKeys(driver, OP_bookno, booknum);

		waitForElement(driver, OP_vin_searchicon);
		click(driver, OP_vin_searchicon);
		
		twoColumnSearchWindow(driver, Vin_Chassis_Header, condition, actual_Vin_Chassis_No);


		waitForElement(driver, OP_loadbtn);
		click(driver, OP_loadbtn);
		waitForElement(driver, OP_datagrid);
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
		if(isDisplayed(driver, popup_Message_Ok_Button)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		//stuff booking
		
		Step_Start(9, " 9.click save button stuff confirmed and Auto MCN Created   ", test, test1);
				moduleNavigate(driver, Search_input_SB);
				
		waitForElement(driver, SB_service_searchbtn);
		click(driver, SB_service_searchbtn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, first_service_data);
		
		waitForElement(driver, SB_vessel_searchbtn);
		click(driver, SB_vessel_searchbtn);
		
		twoColumnSearchWindow(driver, vessel_Search_Header, condition, vesselinp);

		
		waitForElement(driver, SB_voyage_field);
		sendKeys(driver, SB_voyage_field, Voyagenumber1);
		waitForElement(driver, SB_schedule_selbtn);
		click(driver, SB_schedule_selbtn);
		
		waitForElement(driver, SB_pod_searchbtn);
		click(driver, SB_pod_searchbtn);
		
		twoColumnSearchWindow(driver, POD_Search_Header, condition, pod_inp);

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
		sendKeys(driver, bookNo_Filter, booknum);

		String SB_datagrid =String.format(Booking_Locators.SB_datagrid80, booknum);
		waitForElement(driver, SB_datagrid);
		click(driver, SB_datagrid);

		waitForElement(driver, SB_container_searchicon);
		click(driver, SB_container_searchicon);
		
		globalValueSearchWindow(driver, condition, select_by_size_type, sztp_inp, globalSearchFilterOption2_SB, container_inp, globalSearchFilterOption3_SB, searchValue3_SB);

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
		sendKeys(driver, bookNo_Filter, booknum);
		String SB_booknum =String.format(Booking_Locators.SB_booknum, booknum);
		waitForElement(driver, SB_booknum);

		String stuff_booknum=getText(driver, SB_booknum);
		System.out.println("stuff book num: "+stuff_booknum);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		Step_End(9, " 9.click save button stuff confirmed and Auto MCN Created   ", test, test1);

		//booking
		Step_Start(10, "Weight and QTY details carryforward    ", test, test1);

				moduleNavigate(driver, search_module);
				
				
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dd1_condition, select_by_book_number, booknum, globalSearchFilterOption2_B, searchValue2_B, globalSearchFilterOption3_B, searchValue3_B);

		waitForElement(driver, noncon_tab);
		click(driver, noncon_tab);

		waitForElement(driver, Non_Container_Quantity);
		scrollUsingElement(driver, Non_Container_Quantity);
		String Booking_Quantity=getText(driver, Non_Container_Quantity);

		waitForElement(driver, Non_Container_Weight);
		scrollUsingElement(driver, Non_Container_Weight);
		String Booking_Weight=getText(driver, Non_Container_Weight);

		waitForElement(driver, Non_Container_Unit);
		scrollUsingElement(driver, Non_Container_Weight);
		String Booking_Unit=getText(driver, Non_Container_Unit);

		scrollUsingElement(driver, Non_Container_Volume);
		waitForElement(driver, Non_Container_Volume);
		String Booking_Volume=getText(driver, Non_Container_Volume);
		scrollTop(driver);
		
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dd1_condition, select_by_book_number, stuff_booknum, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

		
		waitForElement(driver, Commodity_Quantity);
		scrollUsingElement(driver, Commodity_Quantity);
		String Stuff_Booking_Quantity=getText(driver, Commodity_Quantity);

		waitForElement(driver, Commodity_Weight);
		scrollUsingElement(driver, Commodity_Weight);
		String Stuff_Booking_Weight=getText(driver, Commodity_Weight);

		waitForElement(driver, Commodity_Unit);
		scrollUsingElement(driver, Commodity_Unit);
		String Stuff_Booking_Unit=getText(driver, Commodity_Unit);

		waitForElement(driver, Commodity_Volume);
		scrollUsingElement(driver, Commodity_Volume);
		String Stuff_Booking_Volume=getText(driver, Commodity_Volume);

		if(Booking_Quantity.contains(Stuff_Booking_Quantity)) {                                                                                                                  
			System.out.println("Matched || " + "Expected The Booking Non-Contranized Detail tab Grid Quantity value is : " + Booking_Quantity + " || Actual The Booking Commodity tab Grid Quantity value is : " + Stuff_Booking_Quantity);            
			Extent_pass_New(driver, "Matched || " + "Expected The Booking Non-Contranized Detail tab Grid Quantity value is : " + Booking_Quantity + " ||Actual The Booking Commodity tab Grid Quantity value is : " + Stuff_Booking_Quantity, test,test1);     
			System.out.println("Matched || " + " Expected The Booking Non-Contranized Detail tab Grid Weight value is : " + Booking_Weight + " || ActualThe Booking Commodity tab Grid Weight value is : " + Stuff_Booking_Weight);            
			Extent_pass_New(driver, "Matched || " + " Expected The Booking Non-Contranized Detail tab Grid Weight value is : " + Booking_Weight + " || ActualThe Booking Commodity tab Grid Weight value is : " + Stuff_Booking_Weight, test,test1);  
			System.out.println("Matched || " + " Expected The Booking Non-Contranized Detail tab Grid Volume value is : " + Booking_Volume + " || ActualThe Booking Commodity tab Grid Volume value is : " + Stuff_Booking_Volume);            
			Extent_pass_New(driver, "Matched || " + " Expected The Booking Non-Contranized Detail tab Grid Volume value is : " + Booking_Volume + " || ActualThe Booking Commodity tab Grid Volume value is : " + Stuff_Booking_Volume, test,test1);     
		}
		else {     
			System.out.println("Not Matched || " + " Expected The Booking Non-Contranized Detail tab Grid Quantity value is : " + Booking_Weight + " || Actual The Booking Commodity tab Grid Weight value is : " + Stuff_Booking_Weight);        
			System.out.println("Not Matched || " + " Expected The Booking Non-Contranized Detail tab Grid Unit value is : " + Booking_Unit + " || Actual The Booking Commodity tab Grid Unit value is : " + Stuff_Booking_Unit);        
			System.out.println("Not Matched || " + " Expected The Booking Non-Contranized Detail tab Grid Volume value is : " + Booking_Volume + " || Actual The Booking Commodity tab Grid Volume value is : " + Stuff_Booking_Volume);        
			System.out.println("Not Matched || " + " Expected The Booking Non-Contranized Detail tab Grid Quantity value is : " + Booking_Quantity + " || Actual The Booking Commodity tab Grid Quantity value is : " + Stuff_Booking_Quantity);        
			Extent_fail(driver, "Not Matched || " + " Expected The Booking Non-Contranized Detail tab Grid Quantity value is : " + Booking_Quantity + " || Actual The Booking Commodity tab Grid Quantity value is : " + Stuff_Booking_Quantity, test,test1); 
					} 
		
		Step_End(10, "Weight and QTY details carryforward    ", test, test1);


		Extent_completed(tc_Name, test, test1);
	}
}