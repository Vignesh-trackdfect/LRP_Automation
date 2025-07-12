package LRP_Phase_1A_Merge_Booking_Scripts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Merge_Booking_SC06  extends Keywords {
		public void Merge_Booking_SC06(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
				Map<String, String> Excel_data, String url) {
			
			String testCaseName="TC_Merge_Booking_SC06";   
			
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
			String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
			String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
			String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
			String savedpopEXP = Excel_data.get("savedpopEXP");
			String booking_draft_Color = Excel_data.get("booking_draft_Color");
			String pluginConfiguration_Module_Name = Excel_data.get("pluginConfiguration_Module_Name");
			String pluginID = Excel_data.get("pluginID");
			String plugin_Header = Excel_data.get("plugin_Header");
			String Serach_Condition = Excel_data.get("Serach_Condition");
			String PluginStatus = Excel_data.get("PluginStatus");
			String containerised = Excel_data.get("containerised");
			String Vessel_code_Header = Excel_data.get("Vessel_code_Header");
			String Condition = Excel_data.get("Condition");
			String Service_Code_Header = Excel_data.get("Service_Code_Header");
			String Voyage_Header = Excel_data.get("Voyage_Header");
			String Origin_Header = Excel_data.get("Origin_Header");
			String POL_Header = Excel_data.get("POL_Header");
			String POD_Header = Excel_data.get("POD_Header");
			String PLD_Header = Excel_data.get("PLD_Header");
			String Global_Condition = Excel_data.get("Global_Condition");
			String Booking_filter_Type = Excel_data.get("Booking_filter_Type");
			String Merged_Booking_Remarks = Excel_data.get("Merged_Booking_Remarks");
			String reset_status = Excel_data.get("reset_status");
			String pluginreset = Excel_data.get("pluginreset");
			String Merge_Booking_Module_Name = Excel_data.get("Merge_Booking_Module_Name");
			String Cancelled_Colour = Excel_data.get("Cancelled_Colour");

			
			
			
			Extent_Start(testCaseName, test, test1);
			 
			navigateUrl(driver, url);
	 

			LRP_Login(driver, Username, Password);
			verifyMainMenu(driver);
			

			Step_Start(1, "Create 2 containerised booking in confirmed status", test, test1);

			SwitchProfile(driver, agencyUser);
			
			moduleNavigate(driver, Booking_Module_Name);
			
			if(! containerised .trim().equals("Yes")) {
				waitForElement(driver, shiptype_field);
				click(driver,shiptype_field);
				formatLocatorClick(driver, DropDown_Select, containerised);
				
			}

			Extent_cal(test, test1, Booking_Module_Name);

			waitForElement(driver, AgrPartyInput);
			sendKeys(driver, AgrPartyInput, arg_party);
			tab(driver);

			waitForElement(driver, OrginInput);
			sendKeys(driver, OrginInput, origin);
			tab(driver);

			waitForElement(driver, DeliveryInput);
			sendKeys(driver, DeliveryInput, delivery);
			tab(driver);

			bookingRatesSelect_Updated(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

			waitForElement(driver, Draft_Button);
			click(driver, Draft_Button);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message,savedpopEXP);
			String savepopACT = getText(driver, popup_Message);
			System.out.println(savepopACT);


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
			
			waitForElement(driver, master_tab);
			click(driver, master_tab);
			System.out.println(" Printing the Booking number ");
			Extent_call(test, test1, " Printing the Booking number ");
			
			waitForElement(driver, booking_no);
			String booknum = getAttribute(driver, booking_no, "value");
			System.out.println(booknum);
			
			
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
			
	
			waitForElement(driver, Charges_tab);
			mouseOverToElement(driver, Charges_tab);
			safeclick(driver, Charges_tab);
			
			waitForElement(driver, AutoRated);
			safeclick(driver, AutoRated);

			waitForElement(driver, master_tab);
			click(driver, master_tab);
			
			waitForElement(driver, Confirmed_Button);
			click(driver, Confirmed_Button);
		
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			
			


			waitForPopup(driver, popup_Message,bookingUpdatedPopup);
			String saved_conformed_pop_act = getText(driver, popup_Message);
			
			System.out.println(saved_conformed_pop_act);
			System.out.println("**********Verifting the saved popup **********");
			Extent_call(test, test1,"**********Verifting the saved popup**********");
			
			if (saved_conformed_pop_act.contains(bookingUpdatedPopup)) {
				System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act);            
				Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + saved_conformed_pop_act, test,test1);     
			}else {                                                                                                                                                                   
				System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act);        
				Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + saved_conformed_pop_act, test,test1); 
			} 
			
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver,popup_Message_Ok_Button);
			
      		Extent_call(test, test1,"**********Verifting the saved booking number colour **********");
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
			
			waitForElement(driver, booking_no);
			String Conform_booking_containerised_1 = getAttribute(driver, booking_no, "value");
			System.out.println("1 containerised booking in confirmed status No is : "+Conform_booking_containerised_1);
			
			
			waitForElement(driver, NewButton_ToolBar);
			click(driver, NewButton_ToolBar);
			
			waitForElement(driver, AgrPartyInput);
			sendKeys(driver, AgrPartyInput, arg_party);
			tab(driver);

			waitForElement(driver, OrginInput);
			sendKeys(driver, OrginInput, origin);
			tab(driver);

			waitForElement(driver, DeliveryInput);
			sendKeys(driver, DeliveryInput, delivery);
			tab(driver);

			bookingRatesSelect_Updated(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

			waitForElement(driver, Draft_Button);
			click(driver, Draft_Button);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message,savedpopEXP);
			String savepopACT1 = getText(driver, popup_Message);
			System.out.println(savepopACT1);


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
			
			waitForElement(driver, master_tab);
			click(driver, master_tab);
			System.out.println(" Printing the Booking number ");
			Extent_call(test, test1, " Printing the Booking number ");
			
			waitForElement(driver, booking_no);
			String booknum1 = getAttribute(driver, booking_no, "value");
			System.out.println(booknum1);
			
	waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
			
			waitForElement(driver, Charges_tab);
			mouseOverToElement(driver, Charges_tab);
			safeclick(driver, Charges_tab);
			
			waitForElement(driver, AutoRated);
			safeclick(driver, AutoRated);

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
			
			

			waitForElement(driver, FirstserviceInput);
			String Service_Value = getAttribute(driver, FirstserviceInput, "value");
			System.out.println(Service_Value);
			
			waitForElement(driver, vessleValue);
			String Vessel_Value=getText(driver, vessleValue);
			System.out.println(Vessel_Value);
			
			waitForElement(driver, voyageValue);
			String Voyage_Value=getText(driver, voyageValue);
			System.out.println(Voyage_Value);
			
			
			waitForElement(driver, BKG_Bound_Value);
			String Bound_Value=getText(driver, voyageValue);
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
	 
			List<String> bookingNumbers = new ArrayList<>();
			bookingNumbers.add(booknum);
			bookingNumbers.add(booknum1);
			
			Step_End(1, "Create 2 containerised booking in confirmed status", test, test1);
			
			Step_Start(2, "In plugin configuration enable NNB plugin as true", test, test1);
		
		setPluginConfig(driver, pluginConfiguration_Module_Name, plugin_Header, Serach_Condition, pluginID, PluginStatus);
		    
		Step_End(2, "In plugin configuration enable NNB plugin as true", test, test1);


		Step_Start(3, "Then open merge booking now new 2 radio buttons(1.new book no and 2.Nominated book no option) are added to near draft/confirm button", test, test1);
		moduleNavigate(driver, Merge_Booking_Module_Name);
		waitForDisplay(driver, MB_New_Booking_No);
		if (isdisplayed(driver, MB_New_Booking_No)) {
			System.out.println(
					"Expected result : New Booking Number should be displayed || Actual result : New Booking Number is be displayed ");
			Extent_pass_New(driver,
					"Expected result : New Booking Number should be displayed || Actual result : New Booking Number is be displayed ",test, test1);
		} else {

			System.out.println(
					"Expected result : New Booking Number should be displayed || Actual result : New Booking Number is not displayed ");
			Extent_fail(driver,
					"Expected result : New Booking Number should be displayed || Actual result : New Booking Number is not displayed ",
					test, test1);

		}	
		
		waitForDisplay(driver, MB_Nominated_Book_No);

		
		if (isdisplayed(driver, MB_Nominated_Book_No)) {
			System.out.println(
					"Expected result : New Booking Number should be displayed || Actual result : New Booking Number is be displayed ");
			Extent_pass_New(driver,
					"Expected result : New Booking Number should be displayed || Actual result : New Booking Number is be displayed ",test, test1);
		} else {

			System.out.println(
					"Expected result : New Booking Number should be displayed || Actual result : New Booking Number is not displayed ");
			Extent_fail(driver,
					"Expected result : New Booking Number should be displayed || Actual result : New Booking Number is not displayed ",
					test, test1);

		}	

		
		
		Step_End(3, "Then open merge booking now new 2 radio buttons(1.new book no and 2.Nominated book no option) are added to near draft/confirm button", test, test1);

			
		Step_Start(4, "Enter input values for service,vessel,voyage,bound,PLA,POL,POD,PLD and agreement party", test, test1);

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
			
		Step_End(4, "Enter input values for service,vessel,voyage,bound,PLA,POL,POD,PLD and agreement party", test, test1);
	
			
		Step_Start(5, "Then below the PLA field draft and confirm button is there in that select confirmed option ", test, test1);
		
		waitForElement(driver, MB_Confirm_Button);
		click(driver, MB_Confirm_Button);

		Step_End(5, "Then below the PLA field draft and confirm button is there in that select confirmed option ", test, test1);

		
		Step_Start(6, "Then click on show button system will list the available booking based on the input criteria", test, test1);
		
		waitForElement(driver, MB_Show_btn);
		click(driver, MB_Show_btn);
		
		Step_End(6, "Then click on show button system will list the available booking based on the input criteria", test, test1);
	
		Step_Start(7, "Then select new book no option", test, test1);

		 waitForElement(driver, MB_New_Booking_No);
		 click(driver, MB_New_Booking_No);
		Step_End(7, "Then select new book no option", test, test1);
		
		Step_Start(8, "First select one booking from available booking tab and move the book no to booking to merge tab by clicking on right side button in between the two tabs", test, test1);

		formatLocatorClick(driver, MB_BookNum_Select, booknum);
		waitForElement(driver, MB_Next_Button);
		click(driver, MB_Next_Button);
			
		Step_End(8, "First select one booking from available booking tab and move the book no to booking to merge tab by clicking on right side button in between the two tabs", test, test1);

		Step_Start(9, "Again select another booking and same process to move right side ", test, test1);

		formatLocatorClick(driver, MB_BookNum_Select, booknum1);
		waitForElement(driver, MB_Next_Button);
		click(driver, MB_Next_Button);
		
		Step_End(9, "Again select another booking and same process to move right side ", test, test1);

		Step_Start(10, "Then on the screen click on merge button", test, test1);

		waitForElement(driver, MD_Merge_btn);
		click(driver, MD_Merge_btn);
		
		Step_End(10, "Then on the screen click on merge button", test, test1);

		Step_Start(11, "Then system ask for confirmation for merge booking", test, test1);
		waitForElement(driver, popup_Message);
		click(driver, popup_Message_Yes_Button);
		Step_End(11, "Then system ask for confirmation for merge booking", test, test1);
		
		Step_Start(12, "Then merged booking message will be shown", test, test1);

		waitForElement(driver, popup_Message);
		  String Merged_Booking_Popup = getText(driver, popup_Message);
		  System.out.println(Merged_Booking_Popup);
		  String Merged_bookingNo = Merged_Booking_Popup.split("is ")[1];
		  System.out.println("Booking No: " + Merged_bookingNo);
		  
		  waitForElement(driver, popup_Message_Ok_Button);
		  click(driver, popup_Message_Ok_Button);
		  
		  
		
		Step_End(12, "Then merged booking message will be shown", test, test1);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Step_Start(13, " Then 2 draft booking get cancelled and new booking will be created with old booking details", test, test1);
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
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Global_Condition, Booking_filter_Type, booknum, "", "", "", "");
		
		waitForElement(driver, booking_no);
		String draft_bookingColorCode2 = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor11=getColorName(draft_bookingColorCode2);
		if(draft_bookingColor11.equals(Cancelled_Colour)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to Red colour ] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor11+" [Booking number input field is changed to Red colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to Red colour ] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor11+" [Booking number input field is changed to Red colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to Red colour ] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor11+" [Booking number input field is Not changed to Red colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to Red colour ] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor11+" [Booking number input field is Not changed to Red colour] ", test, test1); 
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
			System.out.println("Matched || [ Booking number input field Should be change to Red colour ] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor2+" [Booking number input field is changed to Red colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to Red colour ] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor2+" [Booking number input field is changed to Red colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to Red colour ] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor2+" [Booking number input field is Not changed to Red colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to Red colour ] Expected Report Activity is : " + Cancelled_Colour + " || The Actual Report Activity is : " + draft_bookingColor2+" [Booking number input field is Not changed to Red colour] ", test, test1); 
		}
		
		
		if(pluginreset.equals("yes")) {
			setPluginConfig(driver, pluginConfiguration_Module_Name, plugin_Header, Serach_Condition, pluginID,
					reset_status);
			}
		
		
		
		Step_End(13, " Then 2 draft booking get cancelled and new booking will be created with old booking details", test, test1);

		
		Extent_completed(testCaseName, test, test1);


		}			
}
