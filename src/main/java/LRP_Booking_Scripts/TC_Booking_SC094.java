package LRP_Booking_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC094 extends Keywords{
	public void Booking_SC094(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		//		Get data from excel sheet
		String test_Case_Name = "TC_Booking_SC094";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String delivery = Excel_data.get("Delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("BookingUpdatedPopup");
		String Base_Rate = Excel_data.get("Base_Rate");
		String baseRateQuantity_Exp = Excel_data.get("baseRateQuantity_Exp");
		String charge_Txt_Input = Excel_data.get("charge_Txt_Input");
		String Base_Rate_Unit_SearchField_Input = Excel_data.get("Base_Rate_Unit_SearchField_Input");
		String Currency_SearchField_Input = Excel_data.get("Currency_SearchField_Input");
		String EquipType_Input = Excel_data.get("EquipType_Input");
		String Search =Excel_data.get("Search_input");
		String Agt =Excel_data.get("AGR_Party");
		String orgin =Excel_data.get("Orgin");
		String Commodity_Chk_Box_Exp = Excel_data.get("Commodity_Chk_Box");
		String DG_Chk_Box_Exp = Excel_data.get("DG_Chk_Box");
		String Tar_Chk_Box_Exp = Excel_data.get("Tar_Chk_Box");
		String AFF_Chk_Box_Exp = Excel_data.get("AFF_Chk_Box");
		String bookingYelloecolour = Excel_data.get( "Yelloecolour");
		String confirmedBookingColor = Excel_data.get("GreenColor");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Charge_Column_Header =Excel_data.get("Charge_Column_Header");
		String Unit_Column_Header = Excel_data.get("Unit_Column_Header");
		String Condition = Excel_data.get("Condition");
		String Currency_Column_Header = Excel_data.get("Currency_Column_Header");
		String EquipTypeValue=String.format(Booking_Locators.equipTypeValue,EquipType_Input);
		Extent_Start(test_Case_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);

		Extent_call(test, test1,"********** Enter Booking Module **********");
			
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
		moduleNavigate(driver, Search);

		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);
		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
	tab(driver);
		waitForElement(driver, DeliveryInput);
		safeclick(driver, DeliveryInput);
		clearAndType(driver, DeliveryInput, delivery);
		tab(driver);
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
		Extent_call(test, test1,"********** Select the Check Box in Rates Window **********");
		waitForElement(driver, Commodity_Chk_Box);
		checkBox(driver, Commodity_Chk_Box,Commodity_Chk_Box_Exp);
		waitForElement(driver, DG_Chk_Box);
		checkBox(driver, DG_Chk_Box,DG_Chk_Box_Exp);
		waitForElement(driver, Tar_Chk_Box);
		checkBox(driver, Tar_Chk_Box,Tar_Chk_Box_Exp);
		waitForElement(driver, AFF_Chk_Box);
		checkBox(driver, AFF_Chk_Box,AFF_Chk_Box_Exp);
		waitForElement(driver, Rates_Show_Btn);
		safeclick(driver, Rates_Show_Btn);
		
		Step_End(2, "Enter the POL and POD and select the Rates using Rates window",test, test1);

		Step_Start(3, "Select the Routing & Select the Schedule", test, test1);
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);
		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);
		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		Step_End(3, "Select the Routing & Select the Schedule", test, test1);
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		Step_Start(4, "save the booking in Draft", test, test1);
		waitForElement(driver, Draft_Button);
		safeclick(driver, Draft_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
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
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);
		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		
		if(draft_bookingColor.equals(bookingYelloecolour)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + bookingYelloecolour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		} 
		Step_End(4,"save the booking in Draft", test, test1);

		Step_Start(5,"AutoRate the charges in Charge tab", test, test1);
		waitForElement(driver, Charges_tab);
		mouseOverToElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		Step_End(5,"AutoRate the charges in Charge tab", test, test1);

		Step_Start(6,"select confirm button and click Save button", test, test1);
		waitForElement(driver, master_tab);
		safeclick(driver, master_tab);
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		String actualUpdatedPopup2=getText(driver, popup_Message);
		if(actualUpdatedPopup2.contains(bookingUpdatedPopup)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + actualUpdatedPopup2);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || The Actual Pop-up Value is : " + actualUpdatedPopup2, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + actualUpdatedPopup2);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + bookingUpdatedPopup + " || But The Actual Pop-up Value is : " + actualUpdatedPopup2, test,test1); 

		}
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		waitForElement(driver, booking_no);	
		String actualConfirmedColorCode=getTextBackgroundColor(driver, Booking_No_Field);
		String submit_bookingColor=getColorName(actualConfirmedColorCode);

		if(submit_bookingColor.equals(confirmedBookingColor)) {                                                                                                                  
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + submit_bookingColor + " || The Actual Report Activity is : " + confirmedBookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + submit_bookingColor + " || The Actual Report Activity is : " + confirmedBookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + submit_bookingColor + " || The Actual Report Activity is : " + confirmedBookingColor+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + submit_bookingColor + " || The Actual Report Activity is : " + confirmedBookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		}
		Step_End(6, "select confirm button and click Save button", test, test1);
		Step_Start(7, "In Booking charge tab while select base unit as Tues for 20's container then system calculated the base rate Quantity (1)correctly", test, test1);
		//		charges tab		
		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);

		waitForElement(driver, charge_Search_Icon);
		safeclick(driver, charge_Search_Icon);
		twoColumnSearchWindow(driver, Charge_Column_Header, Condition, charge_Txt_Input);

		waitForElement(driver, Base_Rate_Unit_Searchbtn);
		safeclick(driver, Base_Rate_Unit_Searchbtn);
		twoColumnSearchWindow(driver, Unit_Column_Header, Condition, Base_Rate_Unit_SearchField_Input);
		
		waitForElement(driver, Currency_SearchBtn);
		safeclick(driver, Currency_SearchBtn);
		twoColumnSearchWindow(driver, Currency_Column_Header, Condition, Currency_SearchField_Input);
		
		waitForElement(driver, EquipmentType_Dropdown);
		safeclick(driver, EquipmentType_Dropdown);
		waitForElement(driver, EquipTypeValue);
		safeclick(driver, EquipTypeValue);

		waitForElement(driver, Base_Rate_TF);
		safeclick(driver, Base_Rate_TF);
		//		Newclear_Type(driver);
		waitForElement(driver, Base_Rate_TF);
		clearAndType(driver, Base_Rate_TF, Base_Rate);

		waitForElement(driver, Base_Rate_Quantity);
		String baseRateQuantity = getAttribute(driver, Base_Rate_Quantity, "value");
		System.out.println(baseRateQuantity);
		if(baseRateQuantity_Exp.equals(baseRateQuantity)) {                                                                                                                  
			System.out.println("Matched || " + " Actual Base Rate Quantity is : " + baseRateQuantity + " || Expected Base Rate Quantity is : " + baseRateQuantity_Exp);            
			Extent_pass_New(driver, "Matched || " + " Actual Base Rate Quantity is " + baseRateQuantity + " || Expected Base Rate Quantity is : " + baseRateQuantity_Exp, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Actual Report Activity is : " + baseRateQuantity + " || Expected Base Rate Quantity is : " + baseRateQuantity_Exp);        
			Extent_fail(driver, "Not Matched || " + " Actual Base Rate Quantity is: " + baseRateQuantity + " || Expected Base Rate Quantity is : " + baseRateQuantity_Exp, test,test1); 
		}
		Step_End(7, "In Booking charge tab while select base unit as Tues for 20's container then system calculated the base rate Quantity (1)correctly", test, test1);
		Extent_completed(test_Case_Name,test, test1);
	}
}