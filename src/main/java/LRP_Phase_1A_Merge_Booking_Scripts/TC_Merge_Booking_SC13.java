package LRP_Phase_1A_Merge_Booking_Scripts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Merge_Booking_SC13 extends Keywords {

	public void Merge_Booking_SC13(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_Merge_Booking_SC13";

//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String Shipment_Type = Excel_data.get("Shipment_Type");
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String booking_draft_Color = Excel_data.get("booking_draft_Color");
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String pluginConfiguration_Module_Name = Excel_data.get("pluginConfiguration_Module_Name");
		String pluginID = Excel_data.get("pluginID");
		String plugin_Header = Excel_data.get("plugin_Header");
		String Serach_Condition = Excel_data.get("Serach_Condition");
		String PluginStatus = Excel_data.get("PluginStatus");
		String Merge_Booking_Module_Name = Excel_data.get("Merge_Booking_Module_Name");
		String Vessel_code_Header = Excel_data.get("Vessel_code_Header");
		String Condition = Excel_data.get("Condition");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Voyage_Header = Excel_data.get("Voyage_Header");
		String Origin_Header = Excel_data.get("Origin_Header");
		String POL_Header = Excel_data.get("POL_Header");
		String POD_Header = Excel_data.get("POD_Header");
		String PLD_Header = Excel_data.get("PLD_Header");
		String MB_Agr_Party_Value = Excel_data.get("MB_Agr_Party_Value");
		String Default_PluginStatus = Excel_data.get("Default_PluginStatus");
		String MB_Booking_Status_Select = Excel_data.get("MB_Booking_Status_Select");
		String Container_Number = Excel_data.get("Container_Number");
		String Dummy_Container_Popup_Text = Excel_data.get("Dummy_Container_Popup_Text");
		String Global_Condition = Excel_data.get("Global_Condition");
		String Booking_filter_Type = Excel_data.get("Booking_filter_Type");
		String Merged_Booking_Remarks = Excel_data.get("Merged_Booking_Remarks");
		String pluginreset = Excel_data.get("pluginreset");


		

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		
		Step_Start(1, " Create 2 containerised booking in confirmed status with SOC container", test, test1);


		SwitchProfile(driver, agencyUser);
		moduleNavigate(driver, Booking_Module_Name);

//		Booking module
		Extent_cal(test, test1, Booking_Module_Name);

		List<String> bookingNumbers = new ArrayList<>();

		for (int i = 0; i < 2; i++) {

			System.out.println("Booking Flow : " + (i + 1));

			if (!Shipment_Type.equals("")) {

				waitForElement(driver, shiptype_field);
				click(driver, shiptype_field);
				formatLocatorClick(driver, DropDown_Select, Shipment_Type);

			}

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
			
			List<String> container_No = splitAndExpand(Container_Number);
			
			waitForElement(driver, Container_Tab);
			safeclick(driver, Container_Tab);
			waitForElement(driver, con_editicon);
			safeclick(driver, con_editicon);
			
			waitForElement(driver, con_eqp_id);
			safeclick(driver, con_eqp_id);
			clearAndType(driver, con_eqp_id, container_No.get(i));
			
			waitForElement(driver, Container_Edit_Btn);
			safeclick(driver, Container_Edit_Btn);
			String Value3 = getText(driver, Dummy_container_Popup);
			System.out.println("Actual Dummy_container_Popup text : " + Value3);
			
			String DummyContainer =  String.format(Dummy_Container_Popup_Text, container_No.get(i));
			
			System.out.println("Expected Dummy_container_Popup text : " + DummyContainer);

			waitForElement(driver, dummy_container_yes);
			safeclick(driver, dummy_container_yes);
			
			waitForElement(driver, master_tab);
			safeclick(driver, master_tab);

			waitForElement(driver, Draft_Button);
			click(driver, Draft_Button);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, savedpopEXP);
			String savepopACT = getText(driver, popup_Message);
			System.out.println(savepopACT);

			// Verify saved pop up of draft

			if (savepopACT.contains(savedpopEXP)) {
				System.out.println("Matched || Expected Pop-up value is : " + savedpopEXP
						+ "|| Actual Popup value is  :" + savepopACT);
				Extent_pass_New(driver, "Matched || Expected Pop-up value is : " + savedpopEXP
						+ "|| Actual Popup value is :" + savepopACT, test, test1);
				safeclick(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not Matched || Expected Pop-up value is: " + savedpopEXP
						+ "|| Actual Popup value is :" + savepopACT);
				Extent_fail(driver, "Not Matched || Expected Pop-up value is:" + savedpopEXP
						+ "|| Actual Popup value is:" + savepopACT, test, test1);
			}

			waitForElement(driver, booking_no);
			String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
			String draft_bookingColor = getColorName(draft_bookingColorCode);
			if (draft_bookingColor.equals(booking_draft_Color)) {
				System.out.println(
						"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : "
								+ booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor
								+ " [Booking number input field is changed to yellow colour] ");
				Extent_pass_New(driver,
						"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : "
								+ booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor
								+ " [Booking number input field is changed to yellow colour] ",
						test, test1);
			} else {
				System.out.println(
						"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : "
								+ booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor
								+ " [Booking number input field is Not changed to yellow colour] ");
				Extent_fail(driver,
						"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : "
								+ booking_draft_Color + " || The Actual Report Activity is : " + draft_bookingColor
								+ " [Booking number input field is Not changed to yellow colour] ",
						test, test1);
			}

//		Master tab		
			waitForElement(driver, master_tab);
			click(driver, master_tab);
		

//			Container tab

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

//		Charges tab

			waitForElement(driver, Charges_tab);
			mouseOverToElement(driver, Charges_tab);
			safeclick(driver, Charges_tab);

			waitForElement(driver, AutoRated);
			safeclick(driver, AutoRated);

//		Master tab		
			waitForElement(driver, master_tab);
			click(driver, master_tab);

			waitForElement(driver, Confirmed_Button);
			click(driver, Confirmed_Button);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, bookingUpdatedPopup);
			String saved_conformed_pop_act = getText(driver, popup_Message);
			System.out.println(saved_conformed_pop_act);
			// validate the saved conform popup
			System.out.println("**********Verifting the saved popup **********");
			Extent_call(test, test1, "**********Verifting the saved popup**********");
			if (saved_conformed_pop_act.contains(bookingUpdatedPopup)) {
				System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
						+ " || The Actual Pop-up Value is : " + saved_conformed_pop_act);
				Extent_pass_New(driver, "Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
						+ " || The Actual Pop-up Value is : " + saved_conformed_pop_act, test, test1);
			} else {
				System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
						+ " || But The Actual Pop-up Value is : " + saved_conformed_pop_act);
				Extent_fail(driver, "Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup
						+ " || But The Actual Pop-up Value is : " + saved_conformed_pop_act, test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);

			// validate the colour of booking number field after conform
			Extent_call(test, test1, "**********Verifting the saved booking number colour **********");
			waitForElement(driver, booking_no);
			String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
			String Confirm_bookingColor = getColorName(Confirm_bookingColorCode);
			if (Confirm_bookingColor.equalsIgnoreCase(booking_confirmed_Color)) {
				System.out.println(
						"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
								+ booking_confirmed_Color + " || The Actual Report Activity is : "
								+ Confirm_bookingColor + " [ Booking number input field  changed to green colour ]");
				Extent_pass_New(driver,
						"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
								+ booking_confirmed_Color + " || The Actual Report Activity is : "
								+ Confirm_bookingColor + " [ Booking number input field  changed to green colour ]",
						test, test1);
			} else {
				System.out.println(
						"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
								+ booking_confirmed_Color + " || The Actual Report Activity is : "
								+ Confirm_bookingColor
								+ " [ Booking number input field  Not changed to green colour ]");
				Extent_fail(driver,
						"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : "
								+ booking_confirmed_Color + " || The Actual Report Activity is : "
								+ Confirm_bookingColor + " [ Booking number input field  Not changed to green colour ]",
						test, test1);
			}

			waitForElement(driver, booking_no);
			String Conrfirmed_booknum = getAttribute(driver, booking_no, "value");
			System.out.println("Confirmed booking number " + (i + 1) + " is : " + Conrfirmed_booknum);

			bookingNumbers.add(Conrfirmed_booknum);
		

			if (i != 1) {
				waitForElement(driver, NewButton_ToolBar);
				click(driver, NewButton_ToolBar);
			}

		}
		
		Step_End(1, " Create 2 containerised booking in confirmed status with SOC container", test, test1);

		

		waitForElement(driver, vessleValue);
		String Vessel_Value = getText(driver, vessleValue);
		System.out.println(Vessel_Value);
		
		waitForElement(driver, MD_Service_input);
		String Service_Value = getAttribute(driver, MD_Service_input, "value");
		System.out.println(Service_Value);


		waitForElement(driver, voyageValue);
		String Voyage_Value = getText(driver, voyageValue);
		System.out.println(Voyage_Value);

		waitForElement(driver, BKG_Bound_Value);
		String Bound_Value = getText(driver, BKG_Bound_Value);
		System.out.println(Bound_Value);

		waitForElement(driver, Booking_POL);
		String Act_Booking_POL = getAttribute(driver, Booking_POL, "value");
		System.out.println("view Booking POL :" + Act_Booking_POL);

		waitForElement(driver, Booking_POD);
		String Act_Booking_POD = getAttribute(driver, Booking_POD, "value");
		System.out.println("view Booking_POD :" + Act_Booking_POD);

		int start = Act_Booking_POD.indexOf('(');
		int end = Act_Booking_POD.indexOf(')');

		String Booking_POD1 = "";
		if (start != -1 && end != -1 && start < end) {
			Booking_POD1 = Act_Booking_POD.substring(start + 1, end);
		}

		System.out.println("POD Value: " + Booking_POD1);

		int start1 = Act_Booking_POL.indexOf('(');
		int end1 = Act_Booking_POL.indexOf(')');

		String Booking_POL1 = "";
		if (start1 != -1 && end1 != -1 && start1 < end) {
			Booking_POL1 = Act_Booking_POL.substring(start1 + 1, end);
		}

		System.out.println("POL Value: " + Booking_POL1);
		
		Step_Start(2, " In plugin configuration enable DSC plugin as false", test, test1);


		setPluginConfig(driver, pluginConfiguration_Module_Name, plugin_Header, Serach_Condition, pluginID,
				PluginStatus);
		
		Step_End(2, " In plugin configuration enable DSC plugin as false", test, test1);


		moduleNavigate(driver, Merge_Booking_Module_Name);

		Step_End(2, "Open the Merge Booking module", test, test1);

		Step_Start(3, " Enter input values for service,vessel,voyage,bound,PLA,POL,POD,PLD and agreement party", test,
				test1);
		
		
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
		twoColumnSearchWindow(driver, Origin_Header, Condition, Booking_POL1);

		waitForElement(driver, MB_POL_Search_Button);
		click(driver, MB_POL_Search_Button);
		twoColumnSearchWindow(driver, POL_Header, Condition, Booking_POL1);

		waitForElement(driver, MB_POD_Search_Button);
		click(driver, MB_POD_Search_Button);
		twoColumnSearchWindow(driver, POD_Header, Condition, Booking_POD1);

		waitForElement(driver, MB_PLD_Search_Button);
		click(driver, MB_PLD_Search_Button);
		twoColumnSearchWindow(driver, PLD_Header, Condition, Booking_POD1);

		waitForElement(driver, MB_Agr_Party_Text);
		sendKeys(driver, MB_Agr_Party_Text, MB_Agr_Party_Value);

		formatLocatorClick(driver, MB_Panel_Select, MB_Agr_Party_Value);
		
		Step_End(3, " Enter input values for service,vessel,voyage,bound,PLA,POL,POD,PLD and agreement party", test,
				test1);
		

		Step_Start(4, " Then below the PLA field draft and confirm button is there in that select confirmed option ", test,
				test1);
		
		String Booking_Status = String.format(MB_Booking_status, MB_Booking_Status_Select);
		waitForElement(driver, Booking_Status);
		click(driver, Booking_Status);
		
		Step_End(4, " Then below the PLA field draft and confirm button is there in that select confirmed option ", test,
				test1);
		
		Step_Start(5, " Click on Show button to list available bookings based on input criteria ", test,
				test1);
		
		waitForElement(driver, MB_Show_btn);
		click(driver, MB_Show_btn);
		Step_End(5, "Click on Show button to list available bookings based on input criteria", test, test1);
		
		Step_Start(6, " first select one booking from available booking tab and move the book no to booking to merge tab by clicking on right side button in between the two tab ", test,
				test1);
		
		Step_Start(7, "  again select another booking and same process to move right side  ", test,
				test1);
		
		
		waitForElement(driver, Available_Bookings_NO);
		
		int addedCount = 0;

		while (addedCount < bookingNumbers.size()) {
		    // Always fetch fresh list to avoid stale elements
		    List<WebElement> Booking = listOfElements(driver, Available_Bookings_NO);

		    boolean matchFound = false;

		    for (WebElement book : Booking) {
		        try {
		            scrollToElement(driver, book);
		            String Booking_Number = getText1(driver, book).trim();

		            if (bookingNumbers.contains(Booking_Number)) {
		                System.out.println("Matching booking number found: " + Booking_Number);
		                book.click();

		                waitForElement(driver, MB_ADD_Btn);
		                click(driver, MB_ADD_Btn);

		                scrollTop(driver); // Scroll to top if needed
		                addedCount++;
		                matchFound = true;
		                break; // Break inner loop to re-fetch elements
		            }
		        } catch (StaleElementReferenceException e) {
		            System.out.println("StaleElementReferenceException caught, retrying...");
		            break; // Re-fetch list in next loop
		        }
		    }

		    if (!matchFound) {
		        System.out.println("No matching booking found in this pass. Retrying...");
		    }
		}
		
		Step_End(6, " first select one booking from available booking tab and move the book no to booking to merge tab by clicking on right side button in between the two tab ", test,
				test1);
		
		Step_End(7, "  again select another booking and same process to move right side  ", test,
				test1);
		
		Step_Start(8, " Then on the screen click on merge button .", test,
				test1);
		
		waitForElement(driver, MB_Merged_Btn);
		click(driver, MB_Merged_Btn);
		
		Step_End(8, " Then on the screen click on merge button .", test,
				test1);
		
		Step_Start(9, " then system ask for confirmation for merge booking.", test,
				test1);
		
		
		waitForElement(driver, popup_Message);
		String Popup_Text = getText(driver, popup_Message);
		System.out.println("Popup_Text : "+Popup_Text);
		
		
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		
		Step_End(9, " then system ask for confirmation for merge booking.", test,
				test1);
		
		Step_Start(10, "then merged booking message will be shown ", test,
				test1);
		
		waitForElement(driver, popup_Message);
		String Confirmed_Booking_Popup_Text = getText(driver, popup_Message);
		System.out.println("Confirmed Booking Popup Text : "+Confirmed_Booking_Popup_Text);
		Extent_pass_New(driver, "Confirmed Booking Popup Text : "+Confirmed_Booking_Popup_Text, test, test1);
		
		String Merged_bookingNo = Confirmed_Booking_Popup_Text.split("is ")[1];
		System.out.println("Confirmed Merged Booking No: " + Merged_bookingNo);
		Extent_pass_New(driver, "Confirmed Merged Booking No: "+Merged_bookingNo, test, test1);
		
		if(isDisplayed(driver, popup_Message)) {
			System.out.println("Confirmed Merged booking poup is Displayed : "+Confirmed_Booking_Popup_Text);
			Extent_pass_New(driver, "Confirmed Merged booking poup is Displayed : "+Confirmed_Booking_Popup_Text, test, test1);
			
		}else {
			System.out.println("Confirmed Merged booking poup is not Displayed");
			extent_fail(driver, "Confirmed Merged booking poup is not Displayed", test, test1);
			
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		Step_End(10, "then merged booking message will be shown ", test,
				test1);
		
		
		Step_Start(11, "System allow to merge with dummy SOC container ", test,
				test1);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
	
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
		String Merged_Booking_Remarks_Exp =  String.format(Merged_Booking_Remarks,bookingNumbers.get(0),bookingNumbers.get(1),Merged_bookingNo,UserName,currentDate); 
		
		if(System_Remarks_Act.contains(Merged_Booking_Remarks_Exp)) {
			System.out.println("Matched || Expected Result is : "+Merged_Booking_Remarks_Exp+ " || Actual Result is : "+System_Remarks_Act);
			Extent_pass_New(driver, "Matched || Expected Result is : "+Merged_Booking_Remarks_Exp+ " || Actual Result is : "+System_Remarks_Act, test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : "+Merged_Booking_Remarks_Exp+ " || Actual Result is : "+System_Remarks_Act);
		    Extent_fail(driver, "Not Matched || Expected Result is : "+Merged_Booking_Remarks_Exp+ " || Actual Result is : "+System_Remarks_Act, test, test1);
		}
		
		waitForElement(driver, Container_Tab);
		safeclick(driver, Container_Tab);
		
		List<WebElement> Merge_Booking_value =listOfElements(driver, Merged_Booking_Container);
		
		int Merged_Booking_count = Merge_Booking_value.size();
		
		if(Merged_Booking_count == 2) {
			System.out.println("Passed || Expected Result is : Two contained should be  added  || Actual Result is : Two contained is added");
			Extent_pass_New(driver, "Passed || Expected Result is : Two contained should be  added  || Actual Result is : Two contained is added", test, test1);
			
		}else {
			System.out.println("Failed || Expected Result is : Two contained should be  added  || Actual Result is : Two contained is added");
			Extent_fail(driver, "Failed || Expected Result is : Two contained should be  added  || Actual Result is : Two contained is added", test, test1);

		}
		
		Step_End(11, "System allow to merge with dummy SOC container ", test,
				test1);
		
		//default pluginstatus set
	
		if(pluginreset.equals("yes")) {
		setPluginConfig(driver, pluginConfiguration_Module_Name, plugin_Header, Serach_Condition, pluginID,
				Default_PluginStatus);
		}
		
		Extent_completed(testCaseName, test, test1);

	}
}
