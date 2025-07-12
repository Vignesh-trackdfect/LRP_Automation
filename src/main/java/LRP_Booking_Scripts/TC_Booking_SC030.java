package LRP_Booking_Scripts;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC030 extends Keywords{
	public void Booking_SC030(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC030";
		

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
		String booking_confirmed_Color = Excel_data.get("booking_confirmed_Color");
		String BL_saved_msg=Excel_data.get("BL_saved_msg");
		String BL_Updated_msg=Excel_data.get("BL_Updated_msg");
		String carrier_seal=Excel_data.get("carrier_seal");
		String shipper_seal=Excel_data.get("shipper_seal");
		String BL_available_msg=Excel_data.get("BL_available_msg");
		String Select_Options=Excel_data.get("Select_Options");
		String equipment_Id=Excel_data.get("equipment_Id");
		String Package_Input=Excel_data.get("Package_Input");
		String HS_Code_Input=Excel_data.get("HS_Code_Input");
		String cargo_Weight=Excel_data.get("cargo_Weight");
		String Volume=Excel_data.get("Volume");
		String Marks_No=Excel_data.get("Marks_No");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Select_Search_Type_Booking=Excel_data.get("Select_Search_Type_Booking");
		String Commodity_Select_Type = Excel_data.get("Commodity_Select_Type");
		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String condition_Filter = Excel_data.get("condition_Filter");
		String terminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String globalSearchFilterOption2=Excel_data.get("GlobalSearchFilterOption2");
		String globalSearchFilterOption3=Excel_data.get("GlobalSearchFilterOption3");
		String searchValue2=Excel_data.get("searchValue2");
		String searchValue3=Excel_data.get("searchValue3");
		String GlobalSearchDropdownCondition=Excel_data.get("GlobalSearchDropdownCondition");
		String globalSearchFilterOption2_HS=Excel_data.get("GlobalSearchFilterOption2_HS");
		String globalSearchFilterOption3_HS=Excel_data.get("GlobalSearchFilterOption3_HS");
		String searchValue2_HS=Excel_data.get("searchValue2_HS");
		String searchValue3_HS=Excel_data.get("searchValue3_HS");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String BOL_Commodity_Desc_Field = Excel_data.get("BOL_Commodity_Desc_Field");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		
		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);
		Extent_call(test, test1,"********** Switch the Profile  - End **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		moduleNavigate(driver, search_module);

		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);

		Step_Start(2, "Enter the POL and POD ",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		keyDown(driver);
		enter(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the POL and POD ",test, test1);
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_Start(6, "Save the booking in Draft", test, test1);
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
		System.out.println("Pinting the Booking number");
		Extent_call(test, test1," Pinting the Booking number ");
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);

		if(!booknum.equals("")) {
			System.out.println("Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number Generated Successfully. The Newly Generated Booking number is : " + booknum);
			Extent_pass_New(driver,"Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number Generated Successfully. The Newly Generated Booking number is : " + booknum, test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number is Not Generated");
			Extent_fail(driver,"Not Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number is Not Generated", test, test1);
		}
		Step_End(5, "Save the booking in Draft", test, test1);
		Step_Start(6, "AutoRate the charges in Charge tab", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		Step_End(6, "AutoRate the charges in Charge tab", test, test1);
		Step_Start(7, "Select confirm button and click Save button(Confirm the Booking)", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);	
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		// verify the popup for booking saved
		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String actualUpdatedPopup=getText(driver, popup_Message);
		if(actualUpdatedPopup.contains(bookingUpdatedPopup)) {
			Extent_pass_New(driver,"Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || Actual Pop-up value is : "+actualUpdatedPopup, test,test1);
			System.out.println("Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || Actual Pop-up value is : "+actualUpdatedPopup);
			safeclick(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || But Actual Pop-up value is : "+actualUpdatedPopup);
			Extent_fail(driver,"Not Matched || Expected Po-pup value is : "+bookingUpdatedPopup+" || But Actual Pop-up value is : "+actualUpdatedPopup, test,test1);
		}		
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

		Step_End(7, "Select confirm button and click Save button(Confirm the Booking)", test, test1);

		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);

		Step_Start(8, "Create CRO", test, test1);

		waitForElement(driver, CRO_btn);
		safeclick(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		safeclick(driver, rel_terminal_searchicon);
		if(!releaseDepTerminal.equals("")) {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, releaseDepTerminal);
		}else {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, acc_term_value);
		}
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		waitForElement(driver, Close_Current_tab);
		click1(driver, Close_Current_tab);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Select_Search_Type_Booking, booknum, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);
		Step_End(8, "Create CRO", test, test1);
		Step_Start(9, "Create BL", test, test1);
		waitForElement(driver, BL_btn);
		safeclick(driver, BL_btn);
		waitForElement(driver, first_tab_inside_click);
		safeclick(driver, first_tab_inside_click);
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		waitForElement(driver, Customer_Tab);
		safeclick(driver, Customer_Tab);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, Customer_Tab);
		safeclick(driver, Customer_Tab);
		waitForElement(driver, customer_Grid);
		safeclick(driver, customer_Grid);
		waitForElement(driver, customer_Grid);
		RightClick(driver, customer_Grid);
		waitForElement(driver, customer_Grid_Copy);
		safeclick(driver, customer_Grid_Copy);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		List<String> options = splitAndExpand(Select_Options);
		for(String option : options) {
			formatLocatorClick(driver, Booking_Locators.select_Paste_Option, option);
		}
		action.keyUp(Keys.CONTROL).build().perform();
		waitForElement(driver, customer_Paste);
		safeclick(driver, customer_Paste);
		waitForElement(driver, BL_containertab);
		safeclick(driver, BL_containertab);
		waitForElement(driver, smart_Import);
		safeclick(driver, smart_Import);
		waitForElement(driver, act_Equip_Id);
		doubleClick(driver, act_Equip_Id);
		waitForElement(driver, act_Equip_Id);
		Actionsendkeys(driver, act_Equip_Id, equipment_Id);
		waitForElement(driver, career_Seal);
		doubleClick(driver, career_Seal);
		waitForElement(driver, career_Seal);
		Actionsendkeys(driver, career_Seal, carrier_seal);
		waitForElement(driver, BL_Shipper_Seal);
		doubleClick(driver, BL_Shipper_Seal);
		waitForElement(driver, BL_Shipper_Seal);
		Actionsendkeys(driver, BL_Shipper_Seal, shipper_seal);
		tab(driver);
		waitForElement(driver, import_Paste);
		safeclick(driver, import_Paste);
		
		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);
		waitForElement(driver, Commodity_Edit);
		safeclick(driver, Commodity_Edit);
		waitForElement(driver, bl_package_txtfld);
		safeclick(driver, bl_package_txtfld);
		sendKeys(driver, bl_package_txtfld, Package_Input);
		enter(driver);
		waitForElement(driver, hs_search);
		safeclick(driver, hs_search);
		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Commodity_Select_Type, HS_Code_Input, globalSearchFilterOption2_HS, searchValue2_HS, globalSearchFilterOption3_HS, searchValue3_HS);
		waitForElement(driver, MCN_CargoWeight);
		safeclick(driver, MCN_CargoWeight);
		clearAndType(driver, MCN_CargoWeight, cargo_Weight);
		waitForElement(driver, billoflading_volume);
		safeclick(driver, billoflading_volume);
		clearAndType(driver, billoflading_volume, Volume);
		waitForElement(driver, mark_number);
		safeclick(driver, mark_number);
		sendKeys(driver, mark_number, Marks_No);
		waitForElement(driver, BOL_Commodity_Desc_TextField);
		safeclick(driver, BOL_Commodity_Desc_TextField);
		sendKeys(driver, BOL_Commodity_Desc_TextField, BOL_Commodity_Desc_Field);
		waitForElement(driver, bl_commodity_add_button);
		safeclick(driver, bl_commodity_add_button);
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		waitForElement(driver, Charges_First);
		safeclick(driver, Charges_First);
		action.keyDown(Keys.SHIFT).build().perform();
		waitForElement(driver, charges_Last);
		safeclick(driver, charges_Last);
		action.keyUp(Keys.SHIFT).build().perform();
		waitForElement(driver, Charges_First);
		mouseOverToElement(driver, Charges_First);
		RightClick(driver, Charges_First);
		waitForElement(driver, payBy_Charges);
		mouseOverToElement(driver, payBy_Charges);
		waitForElement(driver, payBy_Agreement_Party);
		safeclick(driver, payBy_Agreement_Party);
		waitForDisplay(driver, OFR_Popup);
		if (isDisplayed(driver, OFR_Popup)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
		}
		
		waitForElement(driver, body_Tab_BL);
		safeclick(driver, body_Tab_BL);
		waitForElement(driver, BL_body);
		RightClick(driver, BL_body);
		waitForElement(driver, refresh_all);
		safeclick(driver, refresh_all);
		waitForElement(driver, BL_Master);
		safeclick(driver, BL_Master);
		scrollTop(driver);
		
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

	waitForPopup(driver, popup_Message,BL_saved_msg);
		String saved_popup=getText(driver, popup_Message);
		if(saved_popup.contains(BL_saved_msg)) {
			safeclick(driver, popup_Message_Ok_Button);
			Extent_pass_New(driver,"Matched || The Excepted Pop-up Value is : "+ BL_saved_msg+" || The Actual Pop-up Value is : "+saved_popup, test,test1);
			System.out.println("Matched || The Excepted Pop-up Value is : "+ BL_saved_msg+" || The Actual Pop-up Value is : "+saved_popup);
		}
		else {
			System.out.println("Not Matched || The Excepted Pop-up Value is : "+ BL_saved_msg+" || But The Actual Pop-up Value is : "+saved_popup);
			Extent_fail(driver,"Not Matched || The Excepted Pop-up Value is : "+ BL_saved_msg+" || But The Actual Pop-up Value is : "+saved_popup, test,test1);

		}
		waitForElement(driver, BL_no);
		 draft_bookingColorCode = getTextBackgroundColor(driver, BL_no);
		String draftBL_bookingColor=getColorName(draft_bookingColorCode);
		if(draftBL_bookingColor.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || [ Bill Of Lading number input field Should be change Yellow colour] The Expected Report Activity is : " + booking_draft_Color + " || Actual Report Activity is : " + draftBL_bookingColor+" [ Bill Of Lading number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Bill Of Lading number input field Should be change Yellow colour] The Expected Report Activity is : " + booking_draft_Color + " || Actual Report Activity is : " + draftBL_bookingColor+" [ Bill Of Lading number input field is changed to yellow colour] ", test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Bill Of Lading number input field Should be change Yellow colour] The Expected Report Activity is : " + booking_draft_Color + " || Actual Report Activity is : " + draftBL_bookingColor+" [ Bill Of Lading number input field is not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Bill Of Lading number input field Should be change Yellow colour] The Expected Report Activity is : " + booking_draft_Color + " || Actual Report Activity is : " + draftBL_bookingColor+" [ Bill Of Lading number input field is not changed to yellow colour] ", test,test1); 
		} 
		moduleNavigate(driver, search_module);
		Step_End(9, "Create BL", test, test1);

		scrollTop(driver);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Select_Search_Type_Booking, booknum, globalSearchFilterOption2, searchValue2, globalSearchFilterOption2, searchValue2);
		waitForElement(driver, Edit_Button_toolBar);
		if(IsElementEnabled(driver, Edit_Button_toolBar)) {
			Extent_pass_New(driver,"Matched || The Expected Result is : ' BL Having a Draft Status The Edit Button Should be Enabled ' || The Actual Result is : ' BL Having a Draft Status The Edit Button is Enabled '", test,test1);
			System.out.println("Matched || The Expected Result is : ' BL Having a Draft Status The Edit Button Should be Enabled ' || The Actual Result is : ' BL Having a Draft Status The Edit Button is Enabled '");
		}
		else {
			System.out.println("Not Matched || The Expected Result is : ' BL Having a Draft Status The Edit Button Should be Enabled ' || The Actual Result is : ' BL Having a Draft Status The Edit Button is Disabled '");
			Extent_fail(driver,"Not Matched || The Expected Result is : ' BL Having a Draft Status The Edit Button Should be Enabled ' || The Actual Result is : ' BL Having a Draft Status The Edit Button is Disabled '", test,test1);
				}
		scrollTop(driver);
		waitForElement(driver, BL_Tab);
		safeclick(driver, BL_Tab);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		waitForElement(driver, BL_Confirmed);
		safeclick(driver, BL_Confirmed);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message,BL_Updated_msg);
		String updated_popup=getText(driver, popup_Message);
		if(updated_popup.contains(BL_Updated_msg)) {
			safeclick(driver, popup_Message_Ok_Button);
			Extent_pass_New(driver,"Matched || The Excepted Pop-up  is : "+ BL_Updated_msg+" || The Actual Pop-up  is : :"+updated_popup, test,test1);
			System.out.println("Matched || The Excepted Pop-up  is : "+ BL_Updated_msg+" || The Actual Pop-up  is : :"+updated_popup);
		}
		else {
			System.out.println("Not Matched || The Excepted Pop-up  is : "+ BL_Updated_msg+" ||  The Actual Pop-up  is : :"+updated_popup);
			Extent_fail(driver,"Not Matched || The Excepted Pop-up  is : "+ BL_Updated_msg+" ||  The Actual Pop-up  is : :"+updated_popup, test,test1);

		}
		waitForElement(driver, BL_no);
		String confirmBL_bookingColorCode=getTextBackgroundColor(driver, BL_no);
		String confirmBL_bookingColor=getColorName(confirmBL_bookingColorCode);
		if(confirmBL_bookingColor.equals(booking_confirmed_Color)) {                                                                                                                  
			System.out.println("Matched || [ Bill Of Lading number input field Should be change Green colour] The Expected Report Activity is : " + booking_confirmed_Color + " || Actual Report Activity is : " + confirmBL_bookingColor+" [ Bill Of Lading number input field is changed to Green colour] ");            
			Extent_pass_New(driver,"Matched || [ Bill Of Lading number input field Should be change Green colour] The Expected Report Activity is : " + booking_confirmed_Color + " || Actual Report Activity is : " + confirmBL_bookingColor+" [ Bill Of Lading number input field is changed to Green colour] ", test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Bill Of Lading number input field Should be change Green colour] The Expected Report Activity is : " + booking_confirmed_Color + " || Actual Report Activity is : " + confirmBL_bookingColor+" [ Bill Of Lading number input field is not changed to Green colour] ");        
			Extent_fail(driver,"Not Matched || [ Bill Of Lading number input field Should be change Green colour] The Expected Report Activity is : " + booking_confirmed_Color + " || Actual Report Activity is : " + confirmBL_bookingColor+" [ Bill Of Lading number input field is not changed to Green colour] ", test,test1); 
		} 
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		Step_End(9, "Create BL", test, test1);
		scrollTop(driver);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, GlobalSearchDropdownCondition, Select_Search_Type_Booking, booknum, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

		waitForPopup(driver, popup_Message,BL_available_msg);
		String actual_BL_available_msg=getText(driver, popup_Message);
		if(actual_BL_available_msg.contains(BL_available_msg)) {
			click(driver, popup_Message_Ok_Button);
			Extent_pass_New(driver,"Matched || Excepted Pop-up value is :"+ BL_available_msg+" || Actual Pop-up value is :"+actual_BL_available_msg, test,test1);
			System.out.println("Matched || Excepted Pop-up value is :"+ BL_available_msg+" || Actual Pop-up value is :"+actual_BL_available_msg);
		}else {
			System.out.println("Not Matched || Excepted Pop-up value is :"+ BL_available_msg+" || Actual Pop-up value is :"+actual_BL_available_msg);
			Extent_fail(driver,"Not Matched || Excepted Pop-up value is :"+ BL_available_msg+" || Actual Pop-up value is :"+actual_BL_available_msg, test,test1);
		}

		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		if(!isClickable(driver, Edit_Button_toolBar)) {
			Extent_pass_New(driver,"Matched || The Expected Result is : ' BL Having a Confirm Status The Edit Button Should be Disable ' || The Actual Result is : ' BL Having a Confirm Status The Edit Button is Disabled '", test,test1);
			System.out.println("Matched || The Expected Result is : ' BL Having a Confirm Status The Edit Button Should be Disable ' || The Actual Result is : ' BL Having a Confirm Status The Edit Button is Disabled '");
		}else {
			System.out.println("Not Matched || The Expected Result is : ' BL Having a Confirm Status The Edit Button Should be Disable ' || The Actual Result is : ' BL Having a Confirm Status The Edit Button is Enabled '");
			Extent_fail(driver,"Not Matched || The Expected Result is : ' BL Having a Confirm Status The Edit Button Should be Disable ' || The Actual Result is : ' BL Having a Confirm Status The Edit Button is Enabled '", test,test1);
		}
		Step_End(10, "Verify System  doesn't allow to delete the booking", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}