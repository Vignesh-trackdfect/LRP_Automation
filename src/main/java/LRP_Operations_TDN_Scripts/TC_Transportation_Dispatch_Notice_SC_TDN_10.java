package LRP_Operations_TDN_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Transportation_Dispatch_Notice_SC_TDN_10 extends Keywords{

	public void Transportation_Dispatch_Notice_SC_TDN_10(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Transportation_Dispatch_Notice_SC_TDN_10";

		
		
		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String moduleTDN=Excel_data.get("ModuleTDN");
		String agencyUser = Excel_data.get("AgencyUser");
		String Booking_Number =Excel_data.get("Booking_Number");
		String Provisional_perform =Excel_data.get("Provisional_perform");
		String Draft_perform =Excel_data.get("Draft_perform");
		String Confirmed_perform =Excel_data.get("Confirmed_perform");
		String Cancelled_perform =Excel_data.get("Cancelled_perform");
		String Shipment_Type =Excel_data.get("Shipment_Type");
		String field_select =Excel_data.get("field_select");
		String TDN_warehouse_popup =Excel_data.get("TDN_warehouse_popup");
		String dropdown_Condition =Excel_data.get("Dropdown_Condition");
		String merchantPopup =Excel_data.get("MerchantPopup");
		String PLD_Input =Excel_data.get("PLD_Input");
		String PLD_Search =Excel_data.get("PLD_Search");
		String PLA_Input =Excel_data.get("PLA_Input");
		String PLA_Search =Excel_data.get("PLA_Search");
		String MerchantPopup_Perform = Excel_data.get("MerchantPopup_Perform");
	navigateUrl(driver,url);
	
	Extent_Start(testCaseName, test, test1);
//	Login
		
	LRP_Login(driver, username, password);

	
	Extent_call(test, test1,"**Switch the Profile Start**");

	SwitchProfile(driver, agencyUser);

	Extent_cal(test, test1, moduleTDN);	
		
	moduleNavigate(driver, moduleTDN);
	
	Step_Start(1, "Select the Export option.", test, test1);

		waitForElement(driver, Tshipment_Dropdown);
		click(driver, Tshipment_Dropdown);
		String select_Shipment=String.format(Tshipmenttype_select, Shipment_Type);
		safeclick(driver, select_Shipment);
		
		Step_End(1, "Select the Export option.", test, test1);
		
		Step_Start(2, "Select the Provisional Check Box.", test, test1);
		
		waitForElement(driver, TProvisional_check_box);
		checkBox(driver, TProvisional_check_box, Provisional_perform);
		waitForElement(driver, TDraft_check_box);
		checkBox(driver, TDraft_check_box, Draft_perform);
		waitForElement(driver, TDraft_check_box);
		checkBox(driver, TConfirmed_check_box, Confirmed_perform);
		checkBox(driver, TCancelled_check_box, Cancelled_perform);
		
		Step_End(2, "Select the Provisional Check Box.", test, test1);

		Step_Start(3, "Click the Plus icon button.", test, test1);
		
		
			List<String> datas = splitAndExpand(Booking_Number);
			for (String data1 : datas) {
				
				Step_Start(3, "Click the Plus icon button.", test, test1);
				waitForElement(driver, BL_Add);
				safeclick(driver, BL_Add);
				Step_End(3, "Click the Plus icon button.", test, test1);
				
				Step_Start(4, "Enter the Book Number.", test, test1);
				
				
				
				Step_Start(5, "Click the search icon.", test, test1);
				
				
				
				Step_Start(6, " Select the booking and click the search icon.", test, test1);
				
				globalValueSearchWindow(driver, dropdown_Condition, field_select, data1, PLA_Search, PLA_Input, PLD_Search, PLD_Input);
				Step_End(4, "Enter the Book Number.", test, test1);

				Step_End(5, "Click the search icon.", test, test1);

				Step_End(6, " Select the booking and click the search icon.", test, test1);

			}
		
		Step_Start(7, "Select the Yes button in TDN ( Haulage ) Message box.", test, test1);
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

		Step_End(7, "Select the Yes button in TDN ( Haulage ) Message box.", test, test1);

		Step_Start(8, "Select the containers.", test, test1);
		
		Step_Start(9, "Move to customer tab.", test, test1);

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
		
		Step_End(8, "Select the containers.", test, test1);
		Step_End(9, "Move to customer tab.", test, test1);
		
		Step_Start(10, "Select the book no in Drop down.", test, test1);
		
		waitForElement(driver, TSelect_Booking_DD);
		click(driver, TSelect_Booking_DD);
		
		String contract_click1=String.format(bookingNumber_Select, Booking_Number);
		waitForElement(driver, contract_click1);
		click(driver, contract_click1);
		
		Step_End(10, "Select the book no in Drop down.", test, test1);
		
		Step_Start(11, "Select the ALL container.", test, test1);
		
		waitForElement(driver, TSelect_Booking_all);
		click(driver, TSelect_Booking_all);
		
		Step_End(11, "Select the ALL container.", test, test1);
		
		Step_Start(12, "Click the ADD button", test, test1);
		
		waitForElement(driver, Customer_Add_Button);
		click(driver, Customer_Add_Button);
		
		Step_End(12, "Click the ADD button", test, test1);
		
		waitForPopup(driver, popup_Message, TDN_warehouse_popup);   
		String actual_warehouse_Popup=getText(driver, popup_Message);
		
		if(actual_warehouse_Popup.equals(TDN_warehouse_popup)) {
			Extent_pass_New(driver, "Matched || Expected Pop up : "+TDN_warehouse_popup +" || Actual Pop up : "+actual_warehouse_Popup, test, test1);
			System.out.println("Matched || Expected Pop up : "+TDN_warehouse_popup +" || Actual Pop up : "+actual_warehouse_Popup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected Pop up : "+TDN_warehouse_popup +" || Actual Pop up : "+actual_warehouse_Popup);
			Extent_fail(driver, "Not Matched || Expected Pop up : "+TDN_warehouse_popup +" || Actual Pop up : "+actual_warehouse_Popup, test, test1);
		}

		Extent_completed(testCaseName, test, test1);

	}

}
