package LRP_Operations_TDN_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Transportation_Dispatch_Notice_SC_TDN_01 extends Keywords{

	public void Transportation_Dispatch_Notice_SC_TDN_01(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {	
		
		String testCaseName="TC_Transportation_Dispatch_Notice_SC_TDN_01";
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String moduleTDN = Excel_data.get("ModuleTDN");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Shipment_Type = Excel_data.get("Shipment_Type");
		String Provisional_perform = Excel_data.get("Provisional_perform");
		String Draft_perform = Excel_data.get("Draft_perform");
		String Confirmed_perform = Excel_data.get("Confirmed_perform");
		String Cancelled_perform = Excel_data.get("Cancelled_perform");
		
		
		String Booking_Number2 = Excel_data.get("Booking_Number2");
		String Booking_Number3 = Excel_data.get("Booking_Number3");
		String Booking_Number_Type_Select2 = Excel_data.get("Booking_Number_Type_Select2");
		String Booking_Number_Type_Select3 = Excel_data.get("Booking_Number_Type_Select3");
		
		String ware_House_Type_Select = Excel_data.get("Ware_House_Type_Select");
		String ware_House_Type_Select2 = Excel_data.get("ware_House_Type_Select2");
		String ware_House_Type_Select3 = Excel_data.get("ware_House_Type_Select3");
		String Ware_House_number = Excel_data.get("Ware_House_number");
		String Ware_House_number2 = Excel_data.get("Ware_House_number2");
		String Ware_House_number3 = Excel_data.get("Ware_House_number3");
		String Trans_select = Excel_data.get("Modeof_Transport");
		String App_Date = Excel_data.get("App_Date");
		String date_Picker = Excel_data.get("date_Picker");
		String tdn_SavedPopup = Excel_data.get("TDN_SavedPopup");
		String merchantPopup = Excel_data.get("MerchantPopup");
		String field_select = Excel_data.get("field_select");
		String dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String MerchantPopup_Perform = Excel_data.get("MerchantPopup_Perform");
		String shipmenttype_select = String.format(Tshipmenttype_select, Shipment_Type);
	navigateUrl(driver,url);
	
	Extent_Start(testCaseName, test, test1);
//	Login
		
	LRP_Login(driver, username, password);

	Extent_call(test, test1,"**Switch the Profile Start**");

	SwitchProfile(driver, agencyUser);
	
	Extent_cal(test, test1, "Transportaion Dispatch Notice");	
		
	moduleNavigate(driver, moduleTDN);
		
		waitForElement(driver, Tshipment_Dropdown);
		click(driver, Tshipment_Dropdown);
		safeclick(driver, shipmenttype_select);
		
		Step_Start(1, "select provisional checkbox.", test, test1);
		
		waitForElement(driver, TProvisional_check_box);
		checkBox(driver, TProvisional_check_box, Provisional_perform);
		waitForElement(driver, TDraft_check_box);
		checkBox(driver, TDraft_check_box, Draft_perform);
		waitForElement(driver, TDraft_check_box);
		checkBox(driver, TConfirmed_check_box, Confirmed_perform);
		checkBox(driver, TCancelled_check_box, Cancelled_perform);
		
		Step_End(1, "select provisional checkbox.", test, test1);

			List<String> datas = splitAndExpand(Booking_Number);
			for (String data1 : datas) {
				
				Step_Start(2, "Click add(+) button in BookNo field.", test, test1);

				waitForElement(driver, TBL_Add);
				safeclick(driver, TBL_Add);
				
				Step_End(2, "Click add(+) button in BookNo field.", test, test1);
				globalValueSearchWindow(driver, dropdown_Condition, field_select, data1,Booking_Number_Type_Select2,Booking_Number2,Booking_Number_Type_Select3,Booking_Number3);

				
				Step_Start(3, "Paste book number and click search button.", test, test1);

			Step_End(3, "Paste book number and click search button.", test, test1);

				Step_Start(4, "Select the book number", test, test1);
				
			Step_End(4, "Select the book number", test, test1);

			}
		
		Step_Start(5, "system will display 'Selected Booking is a Merchant. Do you want to proceed?', click yes.", test, test1);

		
		
		
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
		Step_End(5, "system will display 'Selected Booking is a Merchant. Do you want to proceed?', click yes.", test, test1);
		Step_Start(6, "click customer tab.", test, test1);

		waitForDisplay(driver, Tmaster_Tab_Table_Row_TDN);
		if(isdisplayed(driver, Tmaster_Tab_Table_Row_TDN)) {
			waitForElement(driver, TTDN_Customer_Tab);
			click(driver, TTDN_Customer_Tab);
		}else{
			waitForElement(driver, Tremove_Button_TDN);
			click(driver, Tremove_Button_TDN);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			waitForElement(driver, TTDN_Customer_Tab);
			click(driver, TTDN_Customer_Tab);
		}
		
		Step_End(6, "click customer tab.", test, test1);

		Step_Start(7, "select book number from dropdown.", test, test1);

		waitForElement(driver, TSelect_Booking_DD);
		click(driver, TSelect_Booking_DD);
		
		
		String contract_click1=String.format(bookingNumber_Select, Booking_Number);
		waitForElement(driver, contract_click1);
		click(driver, contract_click1);
		
		Step_End(7, "select book number from dropdown.", test, test1);
		
		Step_Start(8, "click all in the box.", test, test1);

		waitForElement(driver, TSelect_Booking_all);
		click(driver, TSelect_Booking_all);
		
		Step_End(8, "click all in the box.", test, test1);

		Step_Start(9, "click search icon in the warehouse field.", test, test1);

		waitForElement(driver, TAdd_ware_house);
		click(driver, TAdd_ware_house);
		
		globalValueSearchWindow(driver, dropdown_Condition, ware_House_Type_Select, Ware_House_number,ware_House_Type_Select2,Ware_House_number2,ware_House_Type_Select3,Ware_House_number3);

		
		Step_End(9, "click search icon in the warehouse field.", test, test1);

		Step_Start(10, "enter % in warehouse name.", test, test1);

	
		Step_End(10, "enter % in warehouse name.", test, test1);

		Step_Start(11, "click on the warehouse and click select button.", test, test1);

	
		Step_End(11, "click on the warehouse and click select button.", test, test1);

		Step_Start(12, "click in app date field and select the current date.", test, test1);

		if(date_Picker.equalsIgnoreCase("yes")) {
		selectDatePickerWithTime1(driver, Date_click, App_Date);
		}else {
			waitForElement(driver, Date_click);
			clearAndType(driver, Date_click, App_Date);
		}
		
		Step_End(12, "click in app date field and select the current date.", test, test1);

		Step_Start(13, "select mode of transport as truck in dropdown.", test, test1);

		waitForElement(driver, mode_of_Trans);
		click(driver, mode_of_Trans);
		String trans_select=String.format(transport_Select, Trans_select);
		waitForElement(driver, trans_select);
		click(driver, trans_select);

		Step_End(13, "select mode of transport as truck in dropdown.", test, test1);

		Step_Start(14, "click add button.", test, test1);

		click(driver, Customer_Add_Button);
		Step_End(14, "click add button.", test, test1);

		Step_Start(15, "click save icon in tool bar.", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(15, "click save icon in tool bar.", test, test1);

		Step_Start(16, "system will display 'Transportation Dispatch Notice saved', click ok.", test, test1);

		waitForPopup(driver, popup_Message, tdn_SavedPopup);   
		String actual_TDN_SavedPopup=getText(driver, popup_Message);
		if(actual_TDN_SavedPopup.equals(tdn_SavedPopup)) {
			Extent_pass_New(driver, "Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup, test, test1);
			System.out.println("Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			Extent_fail(driver, "Not Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup, test, test1);
			System.out.println("Not Matched || Expected Pop up : "+tdn_SavedPopup +" || Actual Pop up : "+actual_TDN_SavedPopup);
		}
		
		Step_End(16, "system will display 'Transportation Dispatch Notice saved', click ok.", test, test1);

		Extent_completed(testCaseName, test, test1);
		
	}
}	