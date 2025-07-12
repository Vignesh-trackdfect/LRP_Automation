package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC118 extends Keywords{

public void Booking_SC118 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
	
	String tc_Name="TC_Booking_SC118";
		
		
		  
		
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
		    String no_of_rows=Excel_data.get("no_of_rows");
		    String unNo = Excel_data.get("unNo");
			String emergencyContactField1 = Excel_data.get("emergencyContactField1");
			String emergencyContactField2 = Excel_data.get("emergencyContactField2");
			String emergencyContacField3 = Excel_data.get("emergencyContacField3");
			String contactNameField = Excel_data.get("contactNameField");
			String outPackingName = Excel_data.get("outPackingName");
			String noOfOuter = Excel_data.get("noOfOuter");
			String grossWtField = Excel_data.get("grossWtField");
			String netWtField = Excel_data.get("netWtField");
			String appliedPopupExp = Excel_data.get("appliedPopupExp");
			String detailsSavedPopup = Excel_data.get("detailsSavedPopup");
			String dg_status = Excel_data.get("dg_status");
			String Limited_Quant_data = Excel_data.get("Limited_Quant_data");
			String Expected_Quant_data = Excel_data.get("Expected_Quant_data");
			String Reported_Quant_data = Excel_data.get("Reported_Quant_data");
			String Waste_data = Excel_data.get("Waste_data");
			String Select_Columns = Excel_data.get("Select_Columns");
			String act_con_id = Excel_data.get("act_con_id");
			String select_by_book_number = Excel_data.get("select_by_book_number");
			String dd1_condition = Excel_data.get("dd1_condition");
			String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
			String Container_select_input = Excel_data.get("Container_select_input");
			String Header_scroll_number = Excel_data.get("Header_scroll_number");
		 //locators
		String Limited_Quant_value =String.format(Booking_Locators.Limited_Quant_value, Limited_Quant_data);
		String Expected_Quant_value = String.format(Booking_Locators.Expected_Quant_value, Expected_Quant_data);
		String Reported_Quant_value = String.format(Booking_Locators.Reported_Quant_No, Reported_Quant_data);
		String Waste_value =String.format(Booking_Locators.Waste_value, Waste_data);
		String con_click =String.format(Booking_Locators.Container_Select, Container_select_input);
	
			
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
		
			waitForElement(driver, rate_dg_checkbox);
			click(driver, rate_dg_checkbox);
			
			waitForElement(driver, rate_showbtn);
			click(driver, rate_showbtn);
			
			waitForElement(driver, rateref_toolbtn);
			safeclick(driver, rateref_toolbtn);
			
			waitForElement(driver, rateref_cond_filter);
			click(driver, rateref_cond_filter);
			
			waitForElement(driver, rate_filter_inp);
			sendKeys(driver, rate_filter_inp, rate_no);
			
//			waitForElement(driver, Scrollbutton2);
//			
//			int Header_number = Integer.parseInt(Header_scroll_number);
//			horizontalscroll(driver, Scrollbutton2, Header_number);
//			
		
			reArrangeAG_GridColumns(driver, Select_Columns);
			waitForElement(driver, rate_dg_filter);
			sendKeys(driver, rate_dg_filter, dg_status);
			
			waitForElement(driver, Rate_No_Select);
			click(driver, Rate_No_Select);

			Extent_call(test, test1,"********** Create the condition filter in Rates Window **********");
			waitForElement(driver, rateref_toolbtn);
			safeclick(driver, rateref_toolbtn);
			waitForElement(driver, rateref_cond_filter);
			safeclick(driver, rateref_cond_filter);
			waitForElement(driver, DG_Column_Field);
			clearAndType(driver, DG_Column_Field,dg_status);
			waitForElement(driver, rateref_toolbtn);
			safeclick(driver, rateref_toolbtn);
			waitForElement(driver, rateref_cond_filter);
			safeclick(driver, rateref_cond_filter);
			waitForElement(driver, rate_filter_inp);
			clearAndType(driver, rate_filter_inp, rate_no);


			waitForElement(driver, ok_btn);
			safeclick(driver, ok_btn);
			Step_End(4, "Select the Routing", test, test1);
			
			
		
			selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
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
			
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
//			
//			waitForElement(driver, container_tab);
//			safeclick(driver, container_tab);
//			scrollBottom(driver);
//			waitForElement(driver, con_grid);
//			click(driver, con_grid);
//			RightClick(driver, con_grid);
//			
//			waitForElement(driver, copy_con);
//			click(driver, copy_con);
//			
//			waitForElement(driver, enter_row_popup);
//			sendKeys(driver, enter_row_popup, no_of_rows);
//			
//			waitForElement(driver, enter_row_popup_ok);
//			click(driver, enter_row_popup_ok);
//			scrollTop(driver);
//			waitForElement(driver, SaveButton_ToolBar);
//			click(driver, SaveButton_ToolBar);
//			
//
//			waitForElement(driver, popup_Message_Ok_Button);
//			safeclick(driver, popup_Message_Ok_Button);
//			
//			waitForElement(driver, Edit_Button_toolBar);
//			click(driver, Edit_Button_toolBar);
//			
			waitForElement(driver, IMO_tab);
			click(driver, IMO_tab);
			
			waitForElement(driver, req_DG);
			click(driver, req_DG);
			
			waitForElement(driver, UnNo_Search);
			click(driver, UnNo_Search);
			waitForElement(driver, UnNo_Input);
			sendKeys(driver, UnNo_Input, unNo);
		
			String element=String.format(Booking_Locators.element, unNo);

			doubleClick(driver, element);
			
			waitForElement(driver, Emergency_Contact_Field1);
			sendKeys(driver, Emergency_Contact_Field1, emergencyContactField1);
			
			waitForElement(driver, Emergency_Contact_Field2);
			sendKeys(driver, Emergency_Contact_Field2, emergencyContactField2);
			
			waitForElement(driver, Emergency_Contact_Field3);
			sendKeys(driver, Emergency_Contact_Field3, emergencyContacField3);
			
			waitForElement(driver, Limited_Quantity);
			click(driver, Limited_Quantity);
			
			waitForElement(driver, Limited_Quant_value);
			click(driver, Limited_Quant_value);
			
			waitForElement(driver, Expected_Quantity);
			click(driver, Expected_Quantity);
			
			waitForElement(driver, Expected_Quant_value);
			click(driver, Expected_Quant_value);
			
			waitForElement(driver,Reported_Quantity);
			click(driver, Reported_Quantity);
			
			waitForElement(driver,Reported_Quant_value);
			click(driver, Reported_Quant_value);
			
			waitForElement(driver, Waste_Field);
			click(driver, Waste_Field);
			
			waitForElement(driver, Waste_value);
			click(driver, Waste_value);
			
			
			click(driver, Contact_Name_Field);
			waitForElement(driver, Contact_Name_Field);
			sendKeys(driver, Contact_Name_Field, contactNameField);
			
			waitForElement(driver, OutPacking_Name);
			sendKeys(driver, OutPacking_Name,outPackingName);
			enter(driver);
		
			
			waitForElement(driver, No_Of_Outer);
			sendKeys(driver, No_Of_Outer, noOfOuter);
			
			waitForElement(driver, Gross_Wt_Field);
			clearAndType(driver, Gross_Wt_Field, grossWtField);
			click(driver, Gross_Wt_Field);
			
			waitForElement(driver, Net_Wt_Field);
			click(driver, Net_Wt_Field);
			sendKeys(driver, Net_Wt_Field, netWtField);
			
			waitForElement(driver, Multi_Apply_Btn);
			click(driver, Multi_Apply_Btn);
			
			waitForPopup(driver, popup_Message,appliedPopupExp);
			String Applied_Popup = getText(driver, popup_Message);
			System.out.println(Applied_Popup);
			if(Applied_Popup.equals(appliedPopupExp)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity  popup is : " + appliedPopupExp + " || Actual Report Activity is : " + Applied_Popup);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity popup is: " + appliedPopupExp + " || Actual Report Activity is : " + Applied_Popup, test, test1);     
			click(driver, popup_Message_Ok_Button);
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity popup is : " + appliedPopupExp + " || Actual Report Activity popup is : " + Applied_Popup);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity popup is : " + appliedPopupExp + " || Actual Report Activity popup is : " + Applied_Popup, test, test1); 
			} 
			waitForElement(driver, con_click);
			click(driver, con_click);
			
			scrollBottom(driver);
			waitForElement(driver, save_DG);
			click(driver, save_DG);
			

			
			waitForPopup(driver, popup_Message,detailsSavedPopup);
			String Saved_Popup = getText(driver, popup_Message);
			System.out.println(Saved_Popup);
			if(Saved_Popup.equals(detailsSavedPopup)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity  popup is : " + detailsSavedPopup + " || Actual Report Activity is : " + Saved_Popup);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity popup is: " + detailsSavedPopup + " || Actual Report Activity is : " + Saved_Popup, test, test1);     
			click(driver, popup_Message_Ok_Button);
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity  popup is : " + detailsSavedPopup + " || Actual Report Activity popup is : " + Saved_Popup);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity popup is : " + detailsSavedPopup + " || Actual Report Activity popup is : " + Saved_Popup, test, test1); 
			}
			
			waitForElement(driver, DG_no);
			String DG_num=getAttribute(driver, DG_no, "value");
			System.out.println(DG_num);
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			Step_Start(7, "In Smart import option container updated ", test, test1);
			
			waitForElement(driver, Container_Tab);
			click(driver, Container_Tab);
			
			waitForElement(driver, smart_import_btn);
			click(driver, smart_import_btn);
			
			waitForElement(driver, import_tab);
			waitForElement(driver, act_eqp_id);
			click(driver, act_eqp_id);
			Actionsendkeys(driver, act_eqp_id, act_con_id);
			
			waitForElement(driver, import_career_seal);
			click(driver, import_career_seal);
			
			waitForElement(driver, import_paste_btn);
			click(driver, import_paste_btn);
			waitForElement(driver, popokforpayat);
			click(driver, popokforpayat);
			
			
//			waitForElement(driver, con_grid1);
//			click(driver, con_grid1);
//			
//			waitForElement(driver, con_remove_btn);
//			click(driver, con_remove_btn);
//			
//			waitForElement(driver, popup_Message);
//			waitForElement(driver, popup_Message_Yes_Button);
//			click(driver, popup_Message_Yes_Button);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			

			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			
			waitForElement(driver, equipid_grid);
			String book_con_num=getText(driver, equipid_grid);
	
			Step_End(7, "In Smart import option container updated ", test, test1);
			
			 waitForElement(driver, SearchButton_Toolbar);
			 click(driver, SearchButton_Toolbar);
			 globalValueSearchWindow(driver, dd1_condition, select_by_book_number, booknum, "", "", "", "");
			
			 
			   waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
				
				waitForElement(driver, IMO_tab);
				click(driver, IMO_tab);
				
				waitForElement(driver, req_DG);
				click(driver, req_DG);
				
				waitForElement(driver, DG_search_field);
				sendKeys(driver, DG_search_field, DG_num);
				waitForElement(driver, DG_search_btn);
				click(driver, DG_search_btn);
				
				waitForElement(driver, con_click);
				String DG_con_num=getText(driver, con_click);
				if(DG_con_num.contains(book_con_num)) {
					System.out.println("Matched || Expected value booking con was : "+book_con_num+" || Actual value was DG CON NUMBER : "+DG_con_num);
					Extent_pass_New(driver, "Matched || Expected value booking con was : "+book_con_num+" || Actual value was  DG CON NUMBER: "+DG_con_num, test, test1);
				}
				else {
					System.out.println("Not Matched || Expected value  booking con was : "+book_con_num+" || Actual value was DG CON NUMBER: "+DG_con_num);
					Extent_fail(driver,  "Not Matched || Expected value booking con  was : "+book_con_num+" || Actual value was DG CON NUMBER : "+DG_con_num, test, test1);
				}
				
				
				Extent_completed(tc_Name, test, test1);
}
}
