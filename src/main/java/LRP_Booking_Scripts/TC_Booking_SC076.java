package LRP_Booking_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC076 extends Keywords {

	public void Booking_SC076 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String tc_Name="TC_Booking_SC076";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module").trim();
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
		String shipper_seal=Excel_data.get("shipper_seal");
		String carrier_seal=Excel_data.get("carrier_seal");
		String BL_available_msg=Excel_data.get("BL_available_msg");
		String Select_Options=Excel_data.get("Select_Options");
		String equipment_Id=Excel_data.get("equipment_Id");
		String Package_Input=Excel_data.get("Package_Input");
		String HS_Code_Input=Excel_data.get("HS_Code_Input");
		String cargo_Weight=Excel_data.get("cargo_Weight");
		String Volume=Excel_data.get("Volume");
		String Marks_No=Excel_data.get("Marks_No");
		String BL_Updated_msg=Excel_data.get("BL_Updated_msg");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String select_by_book_number = Excel_data.get("select_by_book_number");
		String dd1_condition = Excel_data.get("dd1_condition");
		String condition = Excel_data.get("condition");
		String select_by_commodity_code = Excel_data.get("select_by_commodity_code");
		String Terminal_Code_Column_Header = Excel_data.get("Terminal_Code_Column_Header");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		
		//locators

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

		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

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
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		if(draft_bookingColor.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + booking_draft_Color + " || Actual Report Activity is : " + draft_bookingColor);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is[Booking number input field want to change Yellow colour] : " + booking_draft_Color + " || Actual Report Activity is [Booking number input field  changed yellow colour] : " + draft_bookingColor, test, test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + booking_draft_Color + " || Actual Report Activity is : " + draft_bookingColor);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is[Booking number input field not  changed Yellow colour] : " + booking_draft_Color + " || Actual Report Activity is[Booking number input field not  changed yellow colour] : " + draft_bookingColor, test, test1); 
		} 
		Step_End(6, "Save the booking in Draft", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println("booking number value is :"+booknum);

		waitForElement(driver, global_Editbtn);
		click(driver, global_Editbtn);

		Step_Start(7, "Save the booking in Confirmed_Button", test, test1);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);

		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);

		waitForElement(driver, AutoRated);
		click(driver, AutoRated);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

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
		String actualConfirmedColorCode=getTextBackgroundColor(driver, Booking_No_Field);
		String submit_bookingColor=getColorName(actualConfirmedColorCode);

		if(submit_bookingColor.equals(booking_confirmed_Color)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + booking_confirmed_Color + " || Actual Report Activity is : " + submit_bookingColor);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is[Booking number input field want to change green colour] : " + booking_confirmed_Color + " || Actual Report Activity is [Booking number input field  changed yellow colour] : " + submit_bookingColor, test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + booking_confirmed_Color + " || Actual Report Activity is : " + submit_bookingColor);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is[Booking number input field not  changed green colour] : " + booking_confirmed_Color + " || Actual Report Activity is[Booking number input field not  changed yellow colour] : " + submit_bookingColor, test, test1); 
		}
		Step_End(7, "Save the booking in Confirmed_Button", test, test1);

		waitForElement(driver, master_tab);
		click(driver, master_tab);

		Step_Start(8, "Create CRO", test, test1);

		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);
		waitForElement(driver, terminal_searchfield);
		twoColumnSearchWindow(driver, Terminal_Code_Column_Header, condition, acc_term_value);
		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForElement(driver, Module_Close);
		click(driver, Module_Close);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dd1_condition, select_by_book_number, booknum, "", "", "", "");
		Step_End(8, "Create CRO", test, test1);

		Step_Start(9, "Create BL", test, test1);

		waitForElement(driver, BL_btn);
		safeclick(driver, BL_btn);

		
		waitForElement(driver, first_tab_inside_click);
		click1(driver, first_tab_inside_click);
		waitForElement(driver, Close_Current_tab);
		click1(driver, Close_Current_tab);
		waitForElement(driver, Customer_Tab);
		safeclick(driver, Customer_Tab);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

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
		Actionsendkeys(driver, act_Equip_Id, equipment_Id);

		waitForElement(driver, career_Seal);
		doubleClick(driver, career_Seal);
		Actionsendkeys(driver, career_Seal, carrier_seal);

		waitForElement(driver, BL_Shipper_Seal);
		doubleClick(driver, BL_Shipper_Seal);
		Actionsendkeys(driver, BL_Shipper_Seal, shipper_seal);
		tab(driver);

		waitForElement(driver, import_Paste);
		safeclick(driver, import_Paste);

		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);
		waitForElement(driver, Commodity_Edit);
		safeclick(driver, Commodity_Edit);
		waitForElement(driver, commodity_Package);
		safeclick(driver, commodity_Package);
		sendKeys(driver, commodity_Package, Package_Input);
		enter(driver);

		waitForElement(driver, HS_Code_Search);
		safeclick(driver, HS_Code_Search);
globalValueSearchWindow(driver, dd1_condition, select_by_commodity_code, HS_Code_Input, "", "", "", "");

		waitForElement(driver, commodity_Cargo_Weight);
		safeclick(driver, commodity_Cargo_Weight);
		clearAndType(driver, commodity_Cargo_Weight, cargo_Weight);

		waitForElement(driver, commodity_Volume);
		safeclick(driver, commodity_Volume);
		clearAndType(driver, commodity_Volume, Volume);

		waitForElement(driver, commodity_MarksNo);
		safeclick(driver, commodity_MarksNo);
		sendKeys(driver, commodity_MarksNo, Marks_No);

		waitForElement(driver, commodity_Desc_Copy);
		safeclick(driver, commodity_Desc_Copy);

		waitForElement(driver, commodity_Add);
		safeclick(driver, commodity_Add);

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

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

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
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			Extent_pass_New(driver,"Matched || Excepted Popup Value is : "+ BL_saved_msg+" Actual Popup Value is : "+saved_popup, test,test1);
			System.out.println("Matched || Excepted Popup Value is : "+ BL_saved_msg+" Actual Popup Value is : "+saved_popup);
		}else {
			System.out.println("Not matched || Excepted Popup Value is : "+ BL_saved_msg+" Actual Popup Value is : "+saved_popup);
			Extent_fail(driver,"Not matched || Excepted Popup Value is : "+ BL_saved_msg+" Actual Popup Value is : "+saved_popup, test,test1);
		}
		waitForElement(driver, BL_no);
		String draft_BL_Color=getTextBackgroundColor(driver,BL_no);
		String Draft_BL_Color=getColorName(draft_BL_Color);
		if(Draft_BL_Color.equals(booking_draft_Color)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is[Booking number input field want to change Yellow colour] : " + booking_draft_Color + " || Actual Report Activity is [Booking number input field  changed yellow colour] : " + Draft_BL_Color);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is[Booking number input field want to change Yellow colour] : " + booking_draft_Color + " || Actual Report Activity is [Booking number input field  changed yellow colour] : " + Draft_BL_Color, test, test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is[Booking number input field not  changed Yellow colour] : " + booking_draft_Color + " || Actual Report Activity is[Booking number input field not  changed yellow colour] : " + Draft_BL_Color);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is[Booking number input field not  changed Yellow colour] : " + booking_draft_Color + " || Actual Report Activity is[Booking number input field not  changed yellow colour] : " + Draft_BL_Color, test, test1); 
		} 
		
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, BL_Confirmed);
		safeclick(driver, BL_Confirmed);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,BL_Updated_msg);
		String updated_popup=getText(driver, popup_Message);
		if(updated_popup.contains(BL_Updated_msg)) {
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			Extent_pass_New(driver,"Matched ||Excepted popup value is:"+ BL_Updated_msg+" Actual popup value is:"+updated_popup, test,test1);
			System.out.println("Matched ||Excepted popup value is:"+ BL_Updated_msg+" Actual popup value is:"+updated_popup);
		}
		else {
			System.out.println("Not matched ||Excepted popup value is:"+ BL_Updated_msg+" Actual popup value is:"+updated_popup);
			Extent_fail(driver,"Not matched ||Excepted popup value is:"+ BL_Updated_msg+" Actual popup value is:"+updated_popup, test,test1);
		}
		waitForElement(driver, BL_no);
		String confirmBL_bookingColorCode = getTextBackgroundColor(driver, BL_no);
		String confirmBL_bookingColor=getColorName(confirmBL_bookingColorCode);
		if(confirmBL_bookingColor.equals(booking_confirmed_Color)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is[Booking number input field want to change green colour] : " + booking_confirmed_Color + " || Actual Report Activity is [Booking number input field  changed Green colour] : " + confirmBL_bookingColor);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is[Booking number input field want to change green colour] : " + booking_confirmed_Color + " || Actual Report Activity is [Booking number input field  changed Green colour] : " + confirmBL_bookingColor, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is[Booking number input field not  changed green colour] : " + booking_confirmed_Color + " || Actual Report Activity is[Booking number input field not  changed Green colour] : " + confirmBL_bookingColor);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is[Booking number input field not  changed green colour] : " + booking_confirmed_Color + " || Actual Report Activity is[Booking number input field not  changed Green colour] : " + confirmBL_bookingColor, test,test1); 
		}
		
		waitForElement(driver, Module_Close);
		safeclick(driver, Module_Close);

		Step_End(9, "Create BL", test, test1);

		scrollTop(driver);
		moduleNavigate(driver, search_module);


		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dd1_condition, select_by_book_number, booknum, "", "", "", "");
		//

		Step_Start(10, "Verify System  doesn't allow to delete the booking", test, test1);

		waitForPopup(driver, popup_Message,BL_available_msg);
		String delete_popup=getText(driver, popup_Message);
		if(delete_popup.contains(BL_available_msg)) {
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Extent_pass_New(driver,"Matched || Excepted Popup Value is : "+ BL_available_msg+" || Actual Popup value is : "+delete_popup, test,test1);
			System.out.println("Matched || Excepted Popup Value is : "+ BL_available_msg+" || Actual Popup value is : "+delete_popup);
		}else {
			System.out.println("Not Matched || Excepted Popup Value is : "+ BL_available_msg+" || Actual Popup value is : "+delete_popup);
			Extent_fail(driver,"Not Matched || Excepted Popup Value is : "+ BL_available_msg+" || Actual Popup value is : "+delete_popup, test,test1);
		}
		waitForElement(driver, Delete_button_toolBar);
		if(!isElementEnabled(driver, Delete_button_toolBar)) {
			Extent_pass_New(driver,"Matched || The Expected Result is : If The BL Having a Confirm Status. The Delete Button Should Disable || The Actual Result is : The BL Having a Confirm Status. The Delete Button is Disabled", test,test1);
			System.out.println("Matched || The Expected Result is : If The BL Having a Confirm Status. The Delete Button Should Disable || The Actual Result is : The BL Having a Confirm Status. The Delete Button is Disabled");
		}
		else {
			System.out.println("Not Matched || The Expected Result is : If The BL Having a Confirm Status. The Delete Button Should Disable || The Actual Result is : The BL Having a Confirm Status. The Delete Button is Enabled");
			Extent_fail(driver,"Not Matched || The Expected Result is : If The BL Having a Confirm Status. The Delete Button Should Disable || The Actual Result is : The BL Having a Confirm Status. The Delete Button is Enabled", test,test1);
		}
		Step_End(10, "Verify System  doesn't allow to delete the booking", test, test1);
		Extent_completed(tc_Name, test, test1);

	}
}

