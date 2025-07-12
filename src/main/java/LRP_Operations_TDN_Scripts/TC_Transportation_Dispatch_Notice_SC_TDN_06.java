package LRP_Operations_TDN_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Transportation_Dispatch_Notice_SC_TDN_06 extends Keywords {

	public void Transportation_Dispatch_Notice_SC_TDN_06(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Transportation_Dispatch_Notice_SC_TDN_06";

//		Get data from test data

		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleTDN = Excel_data.get("ModuleTDN");
		String agencyUser = Excel_data.get("AgencyUser");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Provisional_perform = Excel_data.get("Provisional_perform");
		String Draft_perform = Excel_data.get("Draft_perform");
		String Confirmed_perform = Excel_data.get("Confirmed_perform");
		String Cancelled_perform = Excel_data.get("Cancelled_perform");
		String Shipment_Type = Excel_data.get("Shipment_Type");
		String field_select = Excel_data.get("field_select");
		String Ware_House_number = Excel_data.get("Ware_House_number");
		String Confirmation_msg = Excel_data.get("Confirmation_msg");
		String ware_House_Type_Select = Excel_data.get("Ware_House_Type_Select");
		String dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String merchantPopup =Excel_data.get("MerchantPopup");
		String PLD_Input =Excel_data.get("PLD_Input");
		String PLD_Search =Excel_data.get("PLD_Search");
		String PLA_Input =Excel_data.get("PLA_Input");
		String PLA_Search =Excel_data.get("PLA_Search");
		String Address1_Search =Excel_data.get("Address1_Search");
		String Address1_Input =Excel_data.get("Address1_Input");
		String Address2_Search =Excel_data.get("Address2_Search");
		String Address2_Input =Excel_data.get("Address2_Input");
		String MerchantPopup_Perform = Excel_data.get("MerchantPopup_Perform");


		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);
//	Login

	LRP_Login(driver, username, password);

		Extent_call(test, test1, "**Switch the Profile Start**");

		SwitchProfile(driver, agencyUser);

		Extent_cal(test, test1, moduleTDN);

		moduleNavigate(driver, moduleTDN);

		waitForElement(driver, Tshipment_Dropdown);
		click(driver, Tshipment_Dropdown);
		String select_Shipment = String.format(Tshipmenttype_select, Shipment_Type);
		safeclick(driver, select_Shipment);

		Step_Start(1, "select provisional checkbox.", test, test1);

		waitForElement(driver, TProvisional_check_box);
		checkBox(driver, TProvisional_check_box, Provisional_perform);
		waitForElement(driver, TProvisional_check_box);
		checkBox(driver, TDraft_check_box, Draft_perform);
		checkBox(driver, TConfirmed_check_box, Confirmed_perform);
		checkBox(driver, TCancelled_check_box, Cancelled_perform);

		Step_End(1, "select provisional checkbox.", test, test1);
		Step_Start(2, "Click add(+) button in BookNo field.", test, test1);

		List<String> datas = splitAndExpand(Booking_Number);
		for (String data1 : datas) {
			waitForElement(driver, BL_Add);
			safeclick(driver, BL_Add);

			Step_End(2, "Click add(+) button in BookNo field.", test, test1);

			Step_Start(3, "Paste book number and click search button.", test, test1);

			Step_Start(4, "Select the book number", test, test1);

			globalValueSearchWindow(driver, dropdown_Condition, field_select, data1, PLA_Search, PLA_Input, PLD_Search, PLD_Input);
			
			
			Step_End(3, "Paste book number and click search button.", test, test1);


		
			Step_End(4, "Select the book number", test, test1);
			
		}

		Step_Start(5, "system will display 'Selected Booking is a Merchant. Do you want to proceed?', click yes.", test,
				test1);

		if(MerchantPopup_Perform.equalsIgnoreCase("YES")) {
			waitForDisplay(driver, popup_Message);   
			if (isdisplayed(driver, popup_Message)) {
				String actualPopup=getText(driver, popup_Message);
				if(actualPopup.equals(merchantPopup)) {
					System.out.println("Matched || Expected popup : "+merchantPopup+" || Actual popup : "+actualPopup);
					Extent_pass_New(driver, "Matched || Expected popup : "+merchantPopup+" || Actual popup : "+actualPopup, test, test1);
					click(driver,popup_Message_Yes_Button);
				}
			}
			}
		Step_End(5, "system will display 'Selected Booking is a Merchant. Do you want to proceed?', click yes.", test,
				test1);
		Step_Start(6, "click customer tab.", test, test1);

		waitForDisplay(driver, master_Tab_Table_Row_TDN);
		if(isdisplayed(driver, master_Tab_Table_Row_TDN)) {
			waitForElement(driver, TDN_Customer_Tab);
			click(driver, TDN_Customer_Tab);
		}else{
			waitForElement(driver, remove_Button_TDN);
			click(driver, remove_Button_TDN);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			waitForElement(driver, TDN_Customer_Tab);
			click(driver, TDN_Customer_Tab);
		}
		

		Step_End(6, "click customer tab.", test, test1);

		Step_Start(7, "select book number from dropdown.", test, test1);

		waitForElement(driver, TSelect_Booking_DD);
		click(driver, TSelect_Booking_DD);

		String contract_click1 = String.format(bookingNumber_Select, Booking_Number);
		waitForElement(driver, contract_click1);
		click(driver, contract_click1);

		Step_End(7, "select book number from dropdown.", test, test1);
		Step_Start(8, "click all in the box.", test, test1);

		waitForElement(driver, TSelect_Booking_all);
		click(driver, TSelect_Booking_all);

		Step_End(8, "click all in the box.", test, test1);

		Step_Start(9, "click search icon in the warehouse field.", test, test1);
		Step_Start(9, "click search icon in the warehouse field.", test, test1);
		waitForElement(driver, TAdd_ware_house);
		click(driver, TAdd_ware_house);
		
		Step_End(9, "click search icon in the warehouse field.", test, test1);

		Step_Start(10, "enter % in warehouse name.", test, test1);
		Step_Start(11, "click on the warehouse and click select button.", test, test1);

		globalValueSearchWindow(driver, dropdown_Condition, ware_House_Type_Select, Ware_House_number, Address1_Search, Address1_Input, Address2_Search, Address2_Input);

		
		Step_End(10, "enter % in warehouse name.", test, test1);


		Step_End(11, "click on the warehouse and click select button.", test, test1);
		Step_Start(12, "click add button.", test, test1);

		waitForElement(driver, Customer_Add_Button);
		click(driver, Customer_Add_Button);

		Step_End(12, "click add button.", test, test1);

		Step_Start(13, "system will display \"Select the Appointment Date\", click ok.", test, test1);

		waitForPopup(driver, popup_Message, Confirmation_msg);   
		String SaveRate_PopUp2 = getText(driver, popup_Message);

		if (Confirmation_msg.equals(SaveRate_PopUp2)) {
			System.out.println("Matched || Expected value POPUP  was : " + Confirmation_msg + " || Actual value POPUP was : "
					+ SaveRate_PopUp2);
			Extent_pass_New(driver,
					"Matched || Expected value POPUP was : " + Confirmation_msg + " || Actual value POPUP was : " + SaveRate_PopUp2,
					test, test1);
			click(driver, popup_Message_Ok_Button);

		} else {
			System.out.println("NotMatched || Expected value POPUP was : " + Confirmation_msg + " || Actual value POPUP was : "
					+ SaveRate_PopUp2);
			Extent_fail(driver, "NotMatched || Expected value POPUP was : " + Confirmation_msg + " || Actual value POPUP was : "
					+ SaveRate_PopUp2, test, test1);
		}

		Step_End(13, "system will display \"Select the Appointment Date\", click ok.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
