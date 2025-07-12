package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC111 extends Keywords {

public void Booking_SC111 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
	String tc_Name="TC_Booking_SC111";
		
		
		  
		
		    String Username = Excel_data.get("Username");
			String Password = Excel_data.get("Password");
			String search_module = Excel_data.get("search_module");
			String agencyUser = Excel_data.get("agencyUser");
			String arg_party = Excel_data.get("arg_party");
			String origin = Excel_data.get("origin");
			String delivery = Excel_data.get("delivery");
			String rate_no = Excel_data.get("rate_no");
			String first_service_data = Excel_data.get("first_service_data");
			String Voyagenumber1 = Excel_data.get("Voyagenumber1");
			String Boundinput = Excel_data.get("Boundinput");
			String booking_draft_Color = Excel_data.get("booking_draft_Color");
		    String LP_location=Excel_data.get("LP_location");
		    String LP_voyage=Excel_data.get("LP_voyage");
		    String status= Excel_data.get("status");
		    String search_module_LP= Excel_data.get("search_module_LP");
		    String mainline_feeder= Excel_data.get("mainline_feeder");
		    String nextport_data= Excel_data.get("nextport_data");
			String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
			String condition = Excel_data.get("condition");
			String condition1 = Excel_data.get("condition1");
			String select_by_book_number = Excel_data.get("select_by_book_number");
			String dd1_condition = Excel_data.get("dd1_condition");
			String TerminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
			String Location_search = Excel_data.get("Location_search");
		//locators
		String LP_group_btn =String.format(Booking_Locators.LP_group_btn, mainline_feeder);
		String LP_nxtport_value=String.format(Booking_Locators.LP_nxtport_value, nextport_data);
		
	
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
			
			Step_Start(6, "Save the booking in Draft", test, test1);
			
			waitForElement(driver, Draft_Button);
			safeclick(driver, Draft_Button);
scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			

			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);

			
			
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

			Step_End(6, "Save the booking in Draft", test, test1);
			
			waitForElement(driver, master_tab);
			click(driver, master_tab);
			
			waitForElement(driver, booking_no);
			String booknum = getAttribute(driver, booking_no,"value");
			System.out.println(booknum);
			scrollTop(driver);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			//
			
			Step_Start(7, "Save the booking in Confirmed", test, test1);
			waitForElement(driver, Confirmed_Button);
			safeclick(driver, Confirmed_Button);

			//
			waitForElement(driver, Charges_tab);
				click(driver, Charges_tab);

				waitForElement(driver, AutoRated);
				click(driver, AutoRated);
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				waitForElement(driver, popup_Message_Ok_Button);
				safeclick(driver, popup_Message_Ok_Button);
				
				
		

				Step_End(7, "Save the booking in Confirmed", test, test1);
			
			waitForElement(driver, master_tab);
			click(driver, master_tab);
			
			String voyage_data=getText(driver, voyageno);
			System.out.println("voyage_data: "+voyage_data);
			
			Step_Start(8, "Release CRO", test, test1);
			waitForElement(driver, CRO_btn);
			click(driver, CRO_btn);
			scrollTop(driver);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
			waitForElement(driver, acc_terminal);
			String acc_term_value=getAttribute(driver, acc_terminal, "value");
			System.out.println(acc_term_value);
			
			waitForElement(driver, rel_terminal_searchicon);
			click(driver, rel_terminal_searchicon);
			
			twoColumnSearchWindow(driver, TerminalDetails_Filter, condition, acc_term_value);
	scrollTop(driver);
	waitForElement(driver, SaveButton_ToolBar);
	click(driver, SaveButton_ToolBar);
			 waitForElement(driver, Close_Current_tab);
			 click(driver, Close_Current_tab);
			 Step_End(8, "Release CRO", test, test1);
			 
			 waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, dd1_condition, select_by_book_number, booknum, "", "", "", "");
				
			 
			 Step_Start(9, "Auto load plan done", test, test1);
				moduleNavigate(driver, search_module_LP);
					
					waitForElement(driver, LP_group_btn);
					click(driver, LP_group_btn);
					
					waitForElement(driver, LP_location_icon);
					click(driver, LP_location_icon);
					twoColumnSearchWindow(driver, Location_search, condition1, LP_location);
					

					
					waitForElement(driver, LP_show_btn);
					click(driver, LP_show_btn);
					
					waitForElement(driver, LP_toolpanel);
					safeclick(driver, LP_toolpanel);
					
					waitForElement(driver, LP_cond_filter);
					click(driver, LP_cond_filter);
					
					waitForElement(driver, LP_book_filter);
					sendKeys(driver, LP_book_filter, booknum);
					
				String LP_search_grid= String.format(Booking_Locators.LP_search_grid, booknum);
					waitForElement(driver, LP_search_grid);
					click(driver, LP_search_grid);
					
					waitForElement(driver, LP_search_input);
					sendKeys(driver, LP_search_input, first_service_data);
					
					waitForElement(driver, LP_voyagebound_filter);
					sendKeys(driver, LP_voyagebound_filter, LP_voyage);
					
					waitForElement(driver, LP_service_sel_btn);
					click(driver, LP_service_sel_btn);
					
					
					waitForElement(driver, LP_nxtport_icon);
					click(driver, LP_nxtport_icon);
					waitForElement(driver, LP_nxtport_searchfield);
					sendKeys(driver, LP_nxtport_searchfield, nextport_data);
					waitForElement(driver, LP_nxtport_value);
					click(driver, LP_nxtport_value);
					waitForElement(driver, LP_nxtport_sel_btn);
					click(driver, LP_nxtport_sel_btn);
					
					waitForElement(driver, LP_add_btn);
					click(driver, LP_add_btn);
					
					waitForElement(driver, LP_gate_exit);
					click(driver, LP_gate_exit);
					
					waitForDisplay(driver, LP_gate_exit1);
					if(isdisplayed(driver, LP_gate_exit1)) {
						waitForElement(driver, LP_gate_exit1);
						click(driver, LP_gate_exit1);
						
					}
					waitForElement(driver, Close_Current_tab);
					click(driver, Close_Current_tab);
					
					
					Step_End(9, "Auto load plan done", test, test1);	
					
					Step_Start(10, "Verify system not allow to edit the scedule details.", test, test1);
					
					waitForElement(driver, SearchButton_Toolbar);
					 click(driver, SearchButton_Toolbar);
					 globalValueSearchWindow(driver, dd1_condition, select_by_book_number, booknum, "", "", "", "");
					
				
					 
					 waitForElement(driver, FirstserviceInput);
					 String schedule_status = getAttribute(driver, FirstserviceInput, "aria-disabled");
					 if(schedule_status.equals(status)) {
						 Extent_pass_New(driver,"Matched ||Excepted status should be shown:"+ status+" Actual status  shown:"+schedule_status, test, test1);
							System.out.println("Matched ||Excepted status should be shown:"+ status+" Actual status  shown:"+schedule_status); 
					 }else {
							System.out.println("Not Matched ||Excepted status should be shown:"+ status+" Actual status  shown:"+schedule_status);
						 Extent_fail(driver,"Not Matched ||Excepted status should be shown:"+ status+" Actual status  shown:"+schedule_status, test, test1);
					 }
					 Step_End(10, "Verify system not allow to edit the scedule details.", test, test1);
					 
					 
					 Extent_completed(tc_Name, test, test1);
					 
				
				
}
}
