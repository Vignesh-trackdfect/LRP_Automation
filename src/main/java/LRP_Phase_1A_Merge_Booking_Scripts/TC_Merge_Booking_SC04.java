package LRP_Phase_1A_Merge_Booking_Scripts;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Merge_Booking_SC04 extends Keywords {

	public void Merge_Booking_SC04(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_Merge_Booking_SC04";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Merge_Booking_Module_Name = Excel_data.get("Merge_Booking_Module_Name");
		String Condition = Excel_data.get("Condition");
		String Vessel_code_Header = Excel_data.get("Vessel_code_Header");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Origin_Header = Excel_data.get("Origin_Header");
		String POL_Header = Excel_data.get("POL_Header");
		String POD_Header = Excel_data.get("POD_Header");
		String PLD_Header = Excel_data.get("PLD_Header");
		String Booking_filter_Type = Excel_data.get("Booking_filter_Type");
		String Global_Condition = Excel_data.get("Global_Condition");
		String Merged_Booking_Remarks = Excel_data.get("Merged_Booking_Remarks");
		String Shipment_Type = Excel_data.get("Shipment_Type");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String weight_Input = Excel_data.get("weight_Input");
		String Cancelled_Colour = Excel_data.get("Cancelled_Colour");









		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		//	Switch the Profile
		SwitchProfile(driver, agencyUser);






		Step_Start(1, "Create two non-containerised bookings in Confirmed status", test, test1);
		moduleNavigate(driver, Booking_Module_Name);
		
		waitForElement(driver, shiptype_field);
		click(driver, shiptype_field);
		formatLocatorClick(driver, DropDown_Select, Shipment_Type);


		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		// Rates 	
		bookingRatesSelect_Updated(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verify saved pop up of draft

		if (savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is  :" + savepopACT);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is :" + savepopACT, test,test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is: " + savedpopEXP + "|| Actual Popup value is :" + savepopACT);
			Extent_fail(driver, "Not Matched || Expected Pop-up value is:" + savedpopEXP + "|| Actual Popup value is:" + savepopACT, test,test1);
		}

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
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver, noncon_tab);
		click(driver, noncon_tab);
		
		waitForElement(driver, noncon_editicon);
		doubleClick(driver, noncon_editicon);
		
		waitForElement(driver, noncon_cargo);
		clear(driver, noncon_cargo);
		sendKeys(driver, noncon_cargo, weight_Input);
		waitForElement(driver, noncon_editbtn);
		click(driver, noncon_editbtn);
		
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

//	Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		
		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);
	
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);


		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String saved_conformed_pop_act1 = getText(driver, popup_Message);
		System.out.println(saved_conformed_pop_act1);
		// validate the saved conform popup
		System.out.println("**********Verifting the saved popup **********");
		Extent_call(test, test1,"**********Verifting the saved popup**********");
		if (saved_conformed_pop_act1.contains(bookingUpdatedPopup)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act1);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act1, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act1);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act1, test,test1); 
		} 
		
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver,popup_Message_Ok_Button);
		
		// validate the colour of booking number field after conform
		Extent_call(test, test1,"**********Verifting the saved booking number colour **********");
		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode1 = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor1=getColorName(Confirm_bookingColorCode1);
		if (Confirm_bookingColor1.equalsIgnoreCase(booking_confirmed_Color)) {
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor1+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor1+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor1+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor1+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		} 
		
		//	Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);

		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

		waitForElement(driver, NewButton_ToolBar);
		click(driver, NewButton_ToolBar);
		
		
			

		waitForElement(driver, shiptype_field);
		click(driver, shiptype_field);
		formatLocatorClick(driver, DropDown_Select, Shipment_Type);


		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		// Rates 	
		bookingRatesSelect_Updated(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT1 = getText(driver, popup_Message);
		System.out.println(savepopACT1);

		// Verify saved pop up of draft

		if (savepopACT1.contains(savedpopEXP)) {
			System.out.println("Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is  :" + savepopACT1);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + savedpopEXP + "|| Actual Popup value is :" + savepopACT1, test,test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Pop-up value is: " + savedpopEXP + "|| Actual Popup value is :" + savepopACT1);
			Extent_fail(driver, "Not Matched || Expected Pop-up value is:" + savedpopEXP + "|| Actual Popup value is:" + savepopACT1, test,test1);
		}

		waitForElement(driver, booking_no);
		String draft_bookingColorCode1 = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor1=getColorName(draft_bookingColorCode1);
		if(draft_bookingColor1.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor1+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor1+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor1+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor1+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		}
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, noncon_tab);
		click(driver, noncon_tab);
		
		waitForElement(driver, noncon_editicon);
		doubleClick(driver, noncon_editicon);
		
		waitForElement(driver, noncon_cargo);
		clear(driver, noncon_cargo);
		sendKeys(driver, noncon_cargo, weight_Input);
		waitForElement(driver, noncon_editbtn);
		click(driver, noncon_editbtn);
		
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

//	Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		
		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);
	
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);


		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String saved_conformed_pop_act_ = getText(driver, popup_Message);
		System.out.println(saved_conformed_pop_act_);
		// validate the saved conform popup
		System.out.println("**********Verifting the saved popup **********");
		Extent_call(test, test1,"**********Verifting the saved popup**********");
		if (saved_conformed_pop_act_.contains(bookingUpdatedPopup)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act_);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act_, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act_);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act_, test,test1); 
		} 
		
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver,popup_Message_Ok_Button);
		
		// validate the colour of booking number field after conform
		Extent_call(test, test1,"**********Verifting the saved booking number colour **********");
		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode11 = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor11=getColorName(Confirm_bookingColorCode11);
		if (Confirm_bookingColor11.equalsIgnoreCase(booking_confirmed_Color)) {
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor11+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor11+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor11+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + booking_confirmed_Color + " || The Actual Report Activity is : " + Confirm_bookingColor11+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		} 
		
		//	Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		System.out.println(" Printing the Booking number ");
		Extent_call(test, test1, " Printing the Booking number ");

		waitForElement(driver, booking_no);
		String booknum1 = getAttribute(driver, booking_no, "value");
		System.out.println(booknum1);
		
		
		waitForElement(driver, Booking_Servicecode);
		String Service_Value = getAttribute(driver, Booking_Servicecode, "value");
		System.out.println(Service_Value);
		
		waitForElement(driver, vessleValue);
		String Vessel_Value=getText(driver, vessleValue);
		System.out.println(Vessel_Value);
		
		waitForElement(driver, voyageValue);
		String Voyage_Value=getText(driver, voyageValue);
		System.out.println(Voyage_Value);
		
		
		waitForElement(driver, BKG_Bound_Value);
		String Bound_Value=getText(driver, BKG_Bound_Value);
		System.out.println(Bound_Value);
		
		waitForElement(driver, Booking_POL);
		String Act_Booking_POL=getAttribute(driver, Booking_POL,"value");
		System.out.println("view Booking POL :" + Act_Booking_POL);
		

		waitForElement(driver, Booking_POD);
		String Act_Booking_POD=getAttribute(driver, Booking_POD,"value");
		System.out.println("view Booking_POD :" + Act_Booking_POD);
		
		int start = Act_Booking_POD.indexOf('(');
		int end = Act_Booking_POD.indexOf(')');

		String Booking_POD = "";
		if (start != -1 && end != -1 && start < end) {
			Booking_POD = Act_Booking_POD.substring(start + 1, end);
		}

		System.out.println("POD Value: "+ Booking_POD);
		
		
		int start1 = Act_Booking_POL.indexOf('(');
		int end1= Act_Booking_POL.indexOf(')');

		String Booking_POL = "";
		if (start1 != -1 && end1 != -1 && start1 < end) {
			Booking_POL = Act_Booking_POL.substring(start1 + 1, end);
		}

		System.out.println("POL Value: "+ Booking_POL);

	

		Step_End(1, "Create two non-containerised bookings in Confirmed status", test, test1);

		Step_Start(2, "Open the Merge Booking module", test, test1);
       moduleNavigate(driver, Merge_Booking_Module_Name);

		Step_End(2, "Open the Merge Booking module", test, test1);


		waitForElement(driver, MB_Un_Containerized_Radio_Button);
		click(driver, MB_Un_Containerized_Radio_Button);
		Step_Start(3, "Enter input values: Service, Vessel, Voyage, Bound, PLA, POL, POD, PLD, and Agreement Party", test, test1);
		
		waitForElement(driver, MB_Vessel_Search_Button);
		click(driver, MB_Vessel_Search_Button);
		twoColumnSearchWindow(driver, Vessel_code_Header, Condition, Vessel_Value);
		
		waitForElement(driver, MB_Service_search_Button);
		click(driver, MB_Service_search_Button);
		twoColumnSearchWindow(driver, Service_Code_Header, Condition, Service_Value);
		
		
		
		waitForElement(driver, MB_Voyage_Search_Button);
		click(driver, MB_Voyage_Search_Button);
		twoColumnSearchWindow(driver, Voyage_Header, Condition, Voyage_Value);
		
		waitForElement(driver, MB_PLA_Search_Button);
		click(driver, MB_PLA_Search_Button);
		twoColumnSearchWindow(driver, Origin_Header, Condition, Booking_POL);
		
		waitForElement(driver, MB_POL_Search_Button);
		click(driver, MB_POL_Search_Button);
		twoColumnSearchWindow(driver, POL_Header, Condition, Booking_POL);
		
		waitForElement(driver, MB_POD_Search_Button);
		click(driver, MB_POD_Search_Button);
		twoColumnSearchWindow(driver, POD_Header, Condition, Booking_POD);
		
		
		waitForElement(driver, MB_PLD_Search_Button);
		click(driver, MB_PLD_Search_Button);
		twoColumnSearchWindow(driver, PLD_Header, Condition, Booking_POD);
		
		
		
		waitForElement(driver, MB_Agr_Party_Text);
		sendKeys(driver, MB_Agr_Party_Text, arg_party);

		formatLocatorClick(driver, MB_Panel_Select, arg_party);
		
		
		Step_End(3, "Enter input values: Service, Vessel, Voyage, Bound, PLA, POL, POD, PLD, Agreement Party", test, test1);

		Step_Start(4, "Select Draft option below the PLA field", test, test1);
		waitForElement(driver, MB_Confirm_Button);
		click(driver, MB_Confirm_Button);
		Step_End(4, "Select Draft option below the PLA field", test, test1);

		Step_Start(5, "Click on Show button to list available bookings based on input criteria", test, test1);
		
		waitForElement(driver, MB_Show_btn);
		click(driver, MB_Show_btn);
		Step_End(5, "Click on Show button to list available bookings based on input criteria", test, test1);

		Step_Start(6, "Select first booking from Available Booking tab and move it to Booking to Merge tab using right arrow button", test, test1);
		
		formatLocatorClick(driver, MB_BookNum_Select, booknum);
		waitForElement(driver, MB_Next_Button);
		click(driver, MB_Next_Button);
		Step_End(6, "Select first booking from Available Booking tab and move it to Booking to Merge tab using right arrow button", test, test1);

		Step_Start(7, "Select second booking and move it to Booking to Merge tab using right arrow button", test, test1);
		formatLocatorClick(driver, MB_BookNum_Select, booknum1);
		waitForElement(driver, MB_Next_Button);
		click(driver, MB_Next_Button);
		Step_End(7, "Select second booking and move it to Booking to Merge tab using right arrow button", test, test1);

		Step_Start(8, "Click on Merge button", test, test1);
		waitForElement(driver, MD_Merge_btn);
		click(driver, MD_Merge_btn);
		Step_End(8, "Click on Merge button", test, test1);

		Step_Start(9, "Confirm the merge action in the confirmation popup", test, test1);
		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Yes_Button);
		Step_End(9, "Confirm the merge action in the confirmation popup", test, test1);

		Step_Start(10, "Merged booking message is shown", test, test1);
		waitForElement(driver, popup_Message);
	  String Merged_Booking_Popup = getText(driver, popup_Message);
	  System.out.println(Merged_Booking_Popup);
	  String Merged_bookingNo = Merged_Booking_Popup.split("is ")[1];
	  System.out.println("Booking No: " + Merged_bookingNo);
	  
	  waitForElement(driver, popup_Message_Ok_Button);
	  click(driver, popup_Message_Ok_Button);
	  
		Step_End(10, "Merged booking message is shown", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Step_Start(11, "Original draft bookings get cancelled and a new merged booking is created", test, test1);
		moduleNavigate(driver, Booking_Module_Name);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Global_Condition, Booking_filter_Type, Merged_bookingNo, "", "", "", "");
		
		waitForElement(driver, remarks_Tab);
		click(driver, remarks_Tab);
		
		scrollBottom(driver);
		String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());

		waitForElement(driver, System_Remarks_Field);
		String System_Remarks_Act = getText(driver, System_Remarks_Field);
	      String UserName = Username.toUpperCase();
		String Merged_Booking_Remarks_Exp =  String.format(Merged_Booking_Remarks,booknum,booknum1,Merged_bookingNo,UserName,currentDate); 
		
		if(System_Remarks_Act.contains(Merged_Booking_Remarks_Exp)) {
			System.out.println("Matched || Expected Result is : "+Merged_Booking_Remarks_Exp+ " || Actual Result is : "+System_Remarks_Act);
			Extent_pass_New(driver, "Matched || Expected Result is : "+Merged_Booking_Remarks_Exp+ " || Actual Result is : "+System_Remarks_Act, test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : "+Merged_Booking_Remarks_Exp+ " || Actual Result is : "+System_Remarks_Act);
		    Extent_fail(driver, "Not Matched || Expected Result is : "+Merged_Booking_Remarks_Exp+ " || Actual Result is : "+System_Remarks_Act, test, test1);
		}
		
		
		scrollTop(driver);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Global_Condition, Booking_filter_Type, booknum, "", "", "", "");
		
		waitForElement(driver, booking_no);
		String draft_bookingColorCode2 = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor11=getColorName(draft_bookingColorCode2);
		if(draft_bookingColor11.equals(Cancelled_Colour)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to Red colour for First Booking] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor11+" [Booking number input field is changed to Red colour for First Booking] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to Red colour for First Booking] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor11+" [Booking number input field is changed to Red colour for First Booking] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to Red colour for First Booking] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor11+" [Booking number input field is Not changed to Red colour for First Booking] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to Red colour for First Booking] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor11+" [Booking number input field is Not changed to Red colour for First Booking] ", test, test1); 
		}
		
		
		//2
		waitForElement(driver, NewButton_ToolBar);
		click(driver, NewButton_ToolBar);
		
		waitForElement(driver, cancel_Common_btn);
	  	  click(driver, cancel_Common_btn);
		
		  
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Global_Condition, Booking_filter_Type, booknum1, "", "", "", "");
		
		waitForElement(driver, booking_no);
		String draft_bookingColorCode11 = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor2=getColorName(draft_bookingColorCode11);
		if(draft_bookingColor2.equals(Cancelled_Colour)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to Red colour for Second Booking] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor2+" [Booking number input field is changed to Red colour for Second Booking] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to Red colour for Second Booking] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor2+" [Booking number input field is changed to Red colour for Second Booking] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to Red colour for Second Booking] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor2+" [Booking number input field is Not changed to Red colour for Second Booking] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to Red colour for Second Booking] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor2+" [Booking number input field is Not changed to Red colour for Second Booking] ", test, test1); 
		}
		
		Step_End(11, "Original draft bookings get cancelled and a new merged booking is created", test, test1);
		
		Extent_completed(testCaseName, test, test1);
	}

}
