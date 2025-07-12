package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
//check whetherIn Booking, Reference Tab Reference type allowed Maximum 200 characters
public class TC_Booking_SC114 extends Keywords {

	public void Booking_SC114(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC114";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Ref_Type = Excel_data.get("Ref_Type");
		String Ref_Input = Excel_data.get("Ref_Input");
		String Ref_Input1 = Excel_data.get("Ref_Input1");
		String Refrence_Popup = Excel_data.get("Refrence_Popup");
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String bookingUpdatedPopup = Excel_data.get("bookingUpdatedPopup");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearchFilterOption=Excel_data.get("GlobalSearchFilterOption");
		String maximum_Length = Excel_data.get("Maximum_Length");
		String Customer_Name_Input=Excel_data.get("Customer_Name_Input");
		String Customer_Name_Search = Excel_data.get("Customer_Name_Search");
		String Booking_Date_Input = Excel_data.get("Booking_Date_Input");
		String Booking_Date_Search = Excel_data.get("Booking_Date_Search");
		String Draft_Colour = Excel_data.get("Draft_Colour");
		String Confirm_colour = Excel_data.get("Confirm_colour");

		
		Extent_Start(test_Case_Name, test, test1);
		
		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Enter the test URL", test, test1);
		
		navigateUrl(driver, url);
		
		Step_End(1, "Open the browser", test, test1);
		Step_End(2, "Enter the test URL", test, test1);
		Step_Start(3, "Enter valid Username & Password in respective text fields", test, test1);
		Step_Start(4, "Click on Login Button ", test, test1);

		
		// Login
		
		LRP_Login(driver, Username, Password);
		
		Step_End(3, "Enter valid Username & Password in respective text fields", test, test1);
		Step_End(4, "Click on Login Button ", test, test1);
		Step_Start(5, "Switch the agency", test, test1);
		

		SwitchProfile(driver, AgencyUser);


		Step_End(5, "Switch the agency", test, test1);
		Step_Start(6, " Enter \"Booking\" in 'Search Module' Search search box & Select the module", test, test1);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
		moduleNavigate(driver, BookingMoudleSearch);
		

		Step_End(6, " Enter \"Booking\" in 'Search Module' Search search box & Select the module", test, test1);
		
		Step_Start(7, "Enter the agr party", test, test1);
		
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		Step_End(7, "Enter the agr party", test, test1);

		Step_Start(8, "Enter the origin", test, test1);
		
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);

		Step_End(8, "Enter the origin", test, test1);
		Step_Start(9, " Enter the Delivery", test, test1);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(9, " Enter the Delivery", test, test1);

// Rates 
		Step_Start(10, "Click the Rates\r\n"
				+ "", test, test1);
		

		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		Step_Start(12, "Click the draft button and save ", test, test1);

		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		Step_End(12, "Click the draft button and save ", test, test1);
		Step_Start(13, "Validate the pop up after saved [BOOKING SAVED]\r\n"
				+ "", test, test1);
		
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);

		// Verify saved pop up of draft

		if (savepopACT.contains(savedpopEXP)) {
			System.out.println("Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + savepopACT, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savepopACT, test,test1); 
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		Step_End(13, "Validate the pop up after saved [BOOKING SAVED]\r\n"
				+ "", test, test1);
		Step_Start(14, "Validate the colour of Booking number field [Yellow Colour]", test, test1);
		
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

		Step_Start(14, "Validate the colour of Booking number field [Yellow Colour]", test, test1);
		Step_Start(15, "Click the edit Button", test, test1);
		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		System.out.println(" Printing the Booking number ");
		Extent_call(test, test1, " Printing the Booking number ");
		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);
		
		if(!booknum.equals("")) {
			System.out.println("Generated Booking number is " + booknum);
			Extent_call(test, test1, "Generated Booking number is " + booknum);
		}

		Step_End(15, "Click the edit Button", test, test1);

		Step_Start(16, "AutoRate the charges in Charge tab", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

//	charges tab		
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		click(driver, AutoRated);

		Step_End(16, "AutoRate the charges in Charge tab", test, test1);


		Extent_call(test, test1, "**click referece Tab and select reference tab**");
		Step_Start(17, "Switch to the References tab and enter reference number [Enter more then 200 character]\r\n"
				+ "", test, test1);
		waitForElement(driver, Reference_Tab);
		click(driver, Reference_Tab);
		Step_End(17, "Switch to the References tab and enter reference number [Enter more then 200 character]\r\n"
				+ "", test, test1);

		Step_Start(18, "Validate the popup after clicking add button[Reference No Length should be less than or equal to 200]\r\n"
				+ "", test, test1);
		waitForElement(driver, Reference_Type_Dropdown);
		click(driver, Reference_Type_Dropdown);
		String ReferenceType =  String.format(Booking_Locators.ReferenceType,  Ref_Type); 
		waitForElement(driver, ReferenceType);
		click(driver, ReferenceType);
		
		System.out.println("REFERENCE TYPE:" + Ref_Type);
		Step_End(18, "Validate the popup after clicking add button[Reference No Length should be less than or equal to 200]\r\n"
				+ "", test, test1);
		Step_Start(19, "Enter 200 character or less then 200 and click add button.", test, test1);
		waitForElement(driver, Reference_No_TF);
		click(driver, Reference_No_TF);
		
		System.out.println("**Enter the Values in Reference tab**");
		Extent_call(test, test1, "**Enter the Values in Reference tab**");
		
		int givenLength=Ref_Input.length();
		Extent_pass_New(driver, "Given Length : "+givenLength, test, test1);
		System.out.println("Given Length : "+givenLength);
		
		sendKeys(driver, Reference_No_TF, Ref_Input);
		
		System.out.println("Ref_Input:" + Ref_Input);
		
		waitForElement(driver, Ref_AddBtn);
		click(driver, Ref_AddBtn);

		waitForPopup(driver, popup_Message,Refrence_Popup);
		String Popup = getText(driver, popup_Message);
		if (Refrence_Popup.equals(Popup)) {
			System.out.println("Matched || Expected value  popup was : " + Refrence_Popup + " || Actual value popup was : " + Popup);
			Extent_pass_New(driver, "Matched || Expected value popup was : " + Refrence_Popup + " || Actual value popup was : " + Popup,
					test, test1);
			System.out.println("***Reference length is more than 10 system doesn't allow to add grid***");
		} else {
			System.out.println(
					"NotMatched || Expected value popup was : " + Refrence_Popup + " || Actual value popup was : " + Popup);
			Extent_fail(driver,
					"NotMatched || Expected value popup was : " + Refrence_Popup + " || Actual value popup was : " + Popup, test,
					test1);
			Extent_cal(test, test1, "Reference Length is more less than 10 system allow to add grid");
		}

		click(driver, popup_Message_Ok_Button);
		
		waitForElement(driver, Reference_No_TF);
		String actualValue=getAttribute(driver, Reference_No_TF, "value");
		
		int actual_Length=actualValue.length();
		Extent_pass_New(driver, "actual_Length : "+actual_Length, test, test1);
		System.out.println("actual_Length : "+actual_Length);
		
		int maxLength=Integer.parseInt(maximum_Length);
		
		if(actual_Length<=maxLength) {
			System.out.println("Passed || actual_Length of ref no : "+actual_Length +" || Given Length : "+givenLength);
			Extent_pass_New(driver, "Passed || actual_Length of ref no : "+actual_Length+" || Given Length : "+givenLength, test, test1);
		}else {
			System.out.println("Failed || actual_Length of ref no : "+actual_Length+" || Given Length : "+givenLength);
			Extent_fail(driver, "Failed || actual_Length of ref no : "+actual_Length+" || Given Length : "+givenLength, test, test1);
			
		}
		
		click(driver, Reference_No_TF);
		clear(driver, Reference_No_TF);
		sendKeys(driver, Reference_No_TF, Ref_Input1);
		
		System.out.println("New Ref Input:" + Ref_Input1);
		
		waitForElement(driver, Ref_AddBtn);
		click(driver, Ref_AddBtn);

		Step_End(19, "		Step_Start(19, \"Enter 200 character or less then 200 and click add button.\", test, test1);\r\n"
				+ "", test, test1);
		Step_Start(20, "Click on save button", test, test1);
		
		int givenValueLength=Ref_Input1.length();
		Extent_pass_New(driver, "Given value 2 Length : "+givenValueLength, test, test1);
		System.out.println("Given value 2 Length : "+givenValueLength);
	
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		Step_End(20, "Click on save button", test, test1);
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
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_Start(21, "Switch to the master tab and click on conform button", test, test1);
//		Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);

		waitForElement(driver, Confirmed_Button);
		click(driver, Confirmed_Button);
		
		Step_End(21, "Switch to the master tab and click on conform button", test, test1);
		Step_Start(22, "Click on Save Button", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		Step_End(22, "Click on Save Button", test, test1);

		Step_Start(23, "Validate the popup After clicking save button", test, test1);

	// verify the pop up for booking saved

		waitForPopup(driver, popup_Message,bookingUpdatedPopup);
		actualUpdatedPopup = getText(driver, popup_Message);
		if (actualUpdatedPopup.contains(bookingUpdatedPopup)) {
			Extent_pass_New(driver,"Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			System.out.println("Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
			Extent_fail(driver,"Not Matched || Expected popup: " + bookingUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup,test, test1);
		}
		
		Step_End(23, "Validate the popup After clicking save button", test, test1);
		Step_Start(24, "Validate the colour of Booking number field [Green colour]", test, test1);

		waitForElement(driver, booking_no);
		String Confirm_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String Confirm_bookingColor=getColorName(Confirm_bookingColorCode);


		if (Confirm_bookingColor.equalsIgnoreCase(Confirm_colour)) {
			System.out.println("Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_colour + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]");            
			Extent_pass_New(driver,"Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_colour + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  changed to green colour ]", test, test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_colour + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]");        
			Extent_fail(driver,"Not Matched || [ Booking number input field should be change to green colour ] Expected Report Activity is : " + Confirm_colour + " || The Actual Report Activity is : " + Confirm_bookingColor+" [ Booking number input field  Not changed to green colour ]", test, test1); 
		}  

		Step_End(24, "Validate the colour of Booking number field [Green colour]", test, test1);
		Step_Start(25, "Then retrieve the booking and check the rate reference number.", test, test1);

		
		//Retrieve 
		scrollTop(driver);
		waitForDisplay(driver, NewButton_ToolBar);	
		if(isDisplayed(driver, NewButton_ToolBar) && isElementAccessible(driver, NewButton_ToolBar)) {
		click(driver, NewButton_ToolBar);
		
		waitForElement(driver, Cancletopbtn);
		click(driver, Cancletopbtn);			
		}
		
		waitForElement(driver, SearchButton_Toolbar);
		click1(driver, SearchButton_Toolbar);

		waitForDisplay(driver, globalSearch_Frame);
		if(isdisplayed(driver, globalSearch_Frame)) {
		
			globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, booknum, Booking_Date_Search, Booking_Date_Input, Customer_Name_Search, Customer_Name_Input);

			
			
		}
		
		waitForElement(driver, Reference_Tab);
		click(driver, Reference_Tab);
		
		String actual_Grid_RefNo=String.format(refNo_Grid_Value, Ref_Type);
		waitForElement(driver, actual_Grid_RefNo);
		
		String actualRefNo=getText(driver, actual_Grid_RefNo);
		
		int actualLength=actualRefNo.length();
		
		if(actualLength==givenValueLength) {
			System.out.println("Matched || Expected actual_Length of ref no : "+actualLength +" Actual Given value 2 Length : "+givenValueLength);
			Extent_pass_New(driver, "Matched || Expected actual_Length of ref no : "+actualLength+" Actual Given value 2 Length : "+givenValueLength, test, test1);
		}else {
			System.out.println("NotMatched || Expected actual_Length of ref no : "+actualLength+"Actual Given value 2 Length : "+givenValueLength);
			Extent_fail(driver, "NotMatched || Expected actual_Length of ref no : "+actualLength+" ActualGiven value 2 Length : "+givenValueLength, test, test1);
		}
		Step_End(25, "Then retrieve the booking and check the rate reference number.", test, test1);

		Extent_completed(test_Case_Name, test, test1);
	}

}