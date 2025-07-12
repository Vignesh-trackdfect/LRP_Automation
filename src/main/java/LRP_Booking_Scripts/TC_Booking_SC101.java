package LRP_Booking_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
//Check whether in booking, system allow to multiple containers in container tab copy option
public class TC_Booking_SC101 extends Keywords {

	public void Booking_SC101(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String test_Case_Name = "TC_Booking_SC101";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String AgencyUser = Excel_data.get("AgencyUser");
		String orgin = Excel_data.get("orgin");
		String delivery = Excel_data.get("delivery");
		String Boundinput = Excel_data.get("Boundinput");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Container_rows = Excel_data.get("Container_rows");
		String Operator_Code_value = Excel_data.get("Operator_Code_value");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String Checkbox_Select_3PL = Excel_data.get("Checkbox_Select_3PL");
		String TOS_Value = Excel_data.get("TOS_Value");
		String Agt = Excel_data.get("AGR_Party");
		String Voyagenumber1 = Excel_data.get("Voyagenumber");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String Draft_Colour = Excel_data.get("Draft_Colour");
		String Header_scroll_number = Excel_data.get("Header_scroll_number");
		
		
		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String TOS =  String.format(Booking_Locators.TOS,  TOS_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 

		
		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");
	
		Extent_call(test, test1, "********** Enter Booking Module **********");
		moduleNavigate(driver, BookingMoudleSearch);

		Step_Start(1, "Enter the Agreement Party", test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		waitForElement(driver, Agr_Party_TF);
		String value1 = getAttribute(driver, Agr_Party_TF, "value");
		System.out.println(value1);
		Step_End(1, "Enter the Agreement Party", test, test1);

		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		Extent_call(test, test1, "*****Enter Origin*****");

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);
		System.out.println("Origin:" + orgin);

		Extent_call(test, test1, "*****Enter Delivery*****");

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);

		if (!SCAC_Code_Value.equals("")) {
			waitForElement(driver, SCAC_code_TF);
			sendKeys(driver, SCAC_code_TF, SCAC_Code_Value);
		}

		if (!Priority_Value.equals("")) {
			waitForElement(driver, Priority);
			safeclick(driver, Priority);
		}

		if (!Agency_RefNo_Value.equals("")) {
			waitForElement(driver, Agency_RefNo_TF);
			sendKeys(driver, Agency_RefNo_TF, Agency_RefNo_Value);
		}
		if (!TOS_Value.equals("")) {
			waitForElement(driver, TOS);
			safeclick(driver, TOS);
		}
		if (Operator_Code_value.equals("YES")) {
			checkBox(driver, CheckBox_3PL, Checkbox_Select_3PL);
			waitForElement(driver, Operator_Code_3PL_searchBtn);
			safeclick(driver, Operator_Code_3PL_searchBtn);
			waitForElement(driver, Operator_Code_TF);
			sendKeys(driver, Operator_Code_TF, Operator_Code_value);
			waitForElement(driver, Code_Val);
			safeclick(driver, Code_Val);
			waitForElement(driver, Popup_selectBtn);
			safeclick(driver, Popup_selectBtn);

		}
		Step_End(2, "Enter the POL and POD and select the Rates using Rates window", test, test1);
		Step_Start(3, "Select the Routing ", test, test1);
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

		waitForElement(driver, Rates_control_Pannel);
		safeclick(driver, Rates_control_Pannel);
		waitForElement(driver, Rated_condition_Filter);
		safeclick(driver, Rated_condition_Filter);
		sendKeys(driver, RateNo_TF, rate_no);
		
		waitForElement(driver, ratesWindow_Horizontal_Scrollbar);
		int Header_number = Integer.parseInt(Header_scroll_number);
		horizontalscroll(driver, ratesWindow_Horizontal_Scrollbar, Header_number);

		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		Step_End(3, "Select the Routing ", test, test1);
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
	
		Step_Start(5, "save the booking in Draft ", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		if(savepopACT.equals(savedpopEXP)) {
			System.out.println("Matched || Expected saved Popup :"+savedpopEXP +"|| Actual Saved Popup :"+savepopACT );
			Extent_pass_New(driver, "Matched || Expected saved Popup :"+savedpopEXP +"|| Actual Saved Popup :"+savepopACT , test, test1);
		}else {
			System.out.println("Not Matched || Expected saved Popup :"+savedpopEXP +"|| Actual Saved Popup :"+savepopACT );
			Extent_pass_New(driver, "Not Matched || Expected saved Popup :"+savedpopEXP +"|| Actual Saved Popup :"+savepopACT , test, test1);

		}

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);


		if (draft_bookingColor.equalsIgnoreCase(Draft_Colour)) {
			System.out.println("Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ");            
			Extent_pass_New(driver,"Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is changed to yellow colour] ", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ");        
			Extent_fail(driver,"Not Matched || [ Booking number input field Should be change to yellow colour ] Expected Report Activity is : " + Draft_Colour + " || The Actual Report Activity is : " + draft_bookingColor+" [Booking number input field is Not changed to yellow colour] ", test, test1); 
		} 
		Step_End(5, "save the booking in Draft ", test, test1);

		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);
		Step_Start(6, "system allow to multiple containers in container tab copy option", test, test1);
		waitForElement(driver, container_tab);
		click(driver, container_tab);

		// to update
		List<WebElement> initial_Columns = listOfElements(driver, Container_columns);
		int count_Before_Copy = initial_Columns.size();

		System.out.println("count of rows before copy is: " + count_Before_Copy);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		
		waitForElement(driver, Container_Grid_editBt);
		RightClick(driver, Container_Grid_editBt);
		waitForElement(driver, Container_copy);
		click(driver, Container_copy);

		waitForElement(driver, Copy_Rows_Value);
		sendKeys(driver, Copy_Rows_Value, Container_rows);
		int CopuNum = Integer.parseInt(Container_rows);

		waitForElement(driver, Copy_OkBtn);
		click(driver, Copy_OkBtn);

		System.out.println("the passing value: " + CopuNum);

		
		scrollBottom(driver);
		// to update
		waitForElement(driver, CopiedRows);
		List<WebElement> After_Copy = listOfElements(driver, CopiedRows);

		int count_After_Copy = After_Copy.size();

		System.out.println("count after copy: " + count_After_Copy);
		int CopyAndGridCount= count_Before_Copy + CopuNum;
		System.out.println(CopyAndGridCount);
	
		if(count_After_Copy == CopyAndGridCount) {
			System.out.println("Matched || Expected Count After Copy Rows : " + count_After_Copy + " || Actual Count After Copy Rows : " + CopyAndGridCount);
			Extent_pass_New(driver, "Matched || Expected Count After Copy Rows : " + count_After_Copy + " || Actual Count After Copy Rows : " + CopyAndGridCount, test,
					test1);

		} else {
			System.out.println("NotMatched || Expected Count After Copy Rows : " + count_After_Copy + " || Actual Count After Copy Rows : " + CopyAndGridCount);
			Extent_fail(driver, "NotMatched || Expected Count After Copy Rows : " + count_After_Copy + " || Actual Count After Copy Rows : " + CopyAndGridCount,
					test, test1);
		}

		Step_End(6, "system allow to multiple containers in container tab copy option", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}
