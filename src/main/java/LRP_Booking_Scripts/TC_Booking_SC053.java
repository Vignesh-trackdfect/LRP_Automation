package LRP_Booking_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC053 extends Keywords{

	public void Booking_SC053 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC053";
		
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser=Excel_data.get("agencyUser");
		String arg_party=Excel_data.get("arg_party");
		String origin=Excel_data.get("origin");
		String delivery=Excel_data.get("delivery");
		String booking_draft_Color= Excel_data.get("booking_draft_Color");
		String no_of_booking_data=Excel_data.get("no_of_booking_data");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String rate_no = Excel_data.get("rate_no");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		
		//locators

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
		Step_Start(5, "Save the booking in Draft", test, test1);
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
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println("Book number generated is: "+booknum);

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
		Step_End(5, "Save the booking in Draft", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_Start(6, "Click block number and enter the number of booking", test, test1);

		scrollBottom(driver);
		waitForElement(driver, block_no_btn);
		click(driver, block_no_btn);

		waitForElement(driver, reserved_booking_popup);
		waitForElement(driver, no_of_booking_input);
		clear(driver, no_of_booking_input);
		sendKeys(driver, no_of_booking_input, no_of_booking_data);
		Step_Start(7, "click okey button", test, test1);
		waitForElement(driver, res_booking_ok);
		click(driver, res_booking_ok);

		Step_End(6, "Click block number and enter the number of booking", test, test1);

		waitForElement(driver, res_booking_summary);
		List<WebElement> bookno=listOfElements(driver, BookNo);
		for(WebElement elements:bookno) {
			System.out.println(elements.getText());
		}
		String book_displayed=String.valueOf(bookno.size());
		if(no_of_booking_data.equals(book_displayed)) {
			Extent_pass_New(driver,"Matched || The Excepted booking Numbers Count is :"+ no_of_booking_data+" || The Actual booking Numbers Count is : "+book_displayed, test,test1);
			System.out.println("Matched || The Excepted booking Numbers Count is :"+ no_of_booking_data+" || The Actual booking Numbers Count is : "+book_displayed);
		}
		else {
			System.out.println("Not Matched || The Excepted booking Numbers Count is :"+ no_of_booking_data+" || The Actual booking Numbers Count is : "+book_displayed);
			Extent_fail(driver,"Not Matched || The Excepted booking Numbers Count is :"+ no_of_booking_data+" || The Actual booking Numbers Count is : "+book_displayed, test,test1);
		}
		waitForElement(driver, res_booking_sum_ok);
		click(driver, res_booking_sum_ok);
		Step_End(7, "click okey button", test, test1);
		Extent_completed(test_Case_Name, test, test1);

	}

}
