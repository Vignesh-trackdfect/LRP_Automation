package LRP_CRO_Scripts;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class Confirmed_Booking_Creation extends Keywords {

	public void confirm_Booking(WebDriver driver, ExtentTest test, ExtentTest test1,Map<String, String> Excel_data) throws Exception {

		String testCaseName="Confirmed_Booking_Creation";

		//		Get data from excel sheet

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
		String Equipment_Id = Excel_data.get("Equipment_Id");
		String carrier_seal = Excel_data.get("carrier_seal");
		String shipper_seal = Excel_data.get("shipper_seal");
		String containerRows = Excel_data.get("containerRows");

		
		Extent_Start(testCaseName, test, test1);

		moduleNavigate(driver, Booking_Module_Name);

//	Booking module
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

		// Rates 	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);

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
		
        //	Master tab		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		System.out.println(" Printing the Booking number ");
		Extent_call(test, test1, " Printing the Booking number ");
		
		waitForElement(driver, booking_no);
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);

//
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
//			waitForElement(driver, Edit_Button_toolBar);
//
//			scrollBottom(driver);
//			waitForElement(driver, select_Container);
//			click(driver, select_Container);
//			waitForElement(driver, select_Container);
//			RightClick(driver, select_Container);
//
//			waitForElement(driver, Container_copy);
//			click(driver, Container_copy);
//
//			waitForDisplay(driver, containerCopy_Frame);
//			if(isdisplayed(driver, containerCopy_Frame)) {
//				sendKeys(driver, enterTheRows_Textfield, containerRows);
//				waitForElement(driver, copyOk_Button);
//				click(driver, copyOk_Button);
//
//			}
//			
//		waitForElement(driver, smart_Import_Button_BKG);
//		safeclick(driver, smart_Import_Button_BKG);
//
//		StringSelection eqpID = new StringSelection(Equipment_Id);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(eqpID, null);
//        
//        
//        Actions action = new Actions(driver);
//        
//        waitForElement(driver, actual_Eqp_ID_gridcell);
//		mouseOverToElement(driver, actual_Eqp_ID_gridcell);
//		click(driver, actual_Eqp_ID_gridcell);
//		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
//		
//		StringSelection carrierSeal = new StringSelection(carrier_seal);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(carrierSeal, null);
//        
//        waitForElement(driver, carrierSeal_Gridcell);
//  		mouseOverToElement(driver, carrierSeal_Gridcell);
//  		click(driver, carrierSeal_Gridcell);
//  		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
//  		
//  		StringSelection shipperSeal = new StringSelection(shipper_seal);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(shipperSeal, null);
//        
//        waitForElement(driver, shipperSeal_Gridcell);
//  		mouseOverToElement(driver, shipperSeal_Gridcell);
//  		click(driver, shipperSeal_Gridcell);
//  		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
//  		
//
//		waitForElement(driver, paste_Button_BKG);
//		safeclick(driver, paste_Button_BKG);
//		
//		waitForDisplay(driver, popup_Message_Ok_Button);
//		if(isdisplayed(driver, popup_Message_Ok_Button)) {
//			click(driver, popup_Message_Ok_Button);
//		}
////	Commodity tab
//		
//		waitForElement(driver, commodity_tab);
//		click(driver, commodity_tab);
//
//		scrollBottom(driver);
//
//		int noOfComm=Integer.parseInt(containerRows);
//		for(int i=noOfComm+1; i>1;i--) {
//
//			String commodity_Select=String.format(commodity, i);
//			waitForElement(driver, commodity_Select);
//			click(driver,commodity_Select);
//
//			waitForElement(driver, commidityRemove_Button);
//			click(driver, commidityRemove_Button);
//
//		}
//		
//		
		
//	Charges tab
		
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
		String saved_conformed_pop_act = getText(driver, popup_Message);
		System.out.println(saved_conformed_pop_act);
		// validate the saved conform popup
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
		
		// validate the colour of booking number field after conform
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
		
		Extent_completed(testCaseName, test, test1);

	}
	}
