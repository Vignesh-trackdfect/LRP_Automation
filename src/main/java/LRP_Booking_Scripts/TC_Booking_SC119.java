package LRP_Booking_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC119 extends Keywords {


public void Booking_SC119 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
	
	String tc_Name="TC_Booking_SC119";
		
		
		  
		  
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
			String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
			String Draft_Colour = Excel_data.get("Draft_Colour");
			String savedpopEXP = Excel_data.get("savedpopEXP");
			String Port_Code_Header = Excel_data.get("Port_Code_Header");
			String ConditionFilter = Excel_data.get("ConditionFilter");
			String Header_scroll_number = Excel_data.get("Header_scroll_number");

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
		
				Step_End(5, "Enter the schedule details", test, test1);
			
			Step_Start(6, "Save the booking in Draft", test, test1);
			
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

			Step_End(6, "Save the booking in Draft", test, test1);
			waitForElement(driver, master_tab);
			click(driver, master_tab);
			
			String booknum = getAttribute(driver, booking_no,"value");
			System.out.println(booknum);
			scrollTop(driver);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
			waitForElement(driver, Confirmed_Button);
			click(driver, Confirmed_Button);
			
			waitForElement(driver, Charges_tab);
				click(driver, Charges_tab);

				waitForElement(driver, AutoRated);
				click(driver, AutoRated);
				
				scrollBottom(driver);
				Step_Start(7, "Right Click the Manifest charge in charge tab", test, test1);
				waitForElement(driver, autocharges_body);
				int Header_number = Integer.parseInt(Header_scroll_number);
				horizontalscroll(driver, autocharges_body, Header_number);
				waitForElement(driver, chargetype_label);
				
				
				waitForElement(driver, chargesTab_Headers);

				List<Map<String, String>> charges_tab_value = getTableData(driver, chargesTab_Headers, chargesTab_Rows);
				String before_charge_type =getValueByFirstColumnAndHeader(charges_tab_value, "Payment Mode", "Prepaid", "Charge Type");
				
				waitForElement(driver, Pay_Loc_Value);
				RightClick(driver, Pay_Loc_Value);
				waitForElement(driver, PayMode_Option);
				click1(driver, PayMode_Option);
				waitForElement(driver, Prepaid);
				safeclick(driver, Prepaid);
				waitForElement(driver, PortCodeTf);
				
//				
				twoColumnSearchWindow(driver, Port_Code_Header, ConditionFilter, origin);

				waitForElement(driver, chargesTab_Headers);
				charges_tab_value = getTableData(driver, chargesTab_Headers, chargesTab_Rows);
				String after_charge_type =getValueByFirstColumnAndHeader(charges_tab_value, "Payment Mode", "Prepaid", "Charge Type");
				
				if(before_charge_type.equals(after_charge_type)) {                                                                                                                  
					System.out.println("Matched || " + " Expected Shown before charge type : " + before_charge_type + " || Actual Shown After charge type : " + after_charge_type);            
					Extent_pass_New(driver, "Matched || " + " Expected Shown before charge type: " + before_charge_type + " || Actual Shown After charge type : " + after_charge_type, test, test1);     
				}                                                                                                                                                                        
				else {                                                                                                                                                                   
					System.out.println("Not Matched || " + " Expected Shown before charge type: " + before_charge_type + " || Actual Shown After charge type  : " + after_charge_type);   
					Extent_fail(driver, "Not Matched || " + " Expected Shown before charge type: " + before_charge_type + " || Actual  Shown After charge type : " + after_charge_type, test, test1);      
				} 
				Step_End(7, "Right Click the Manifest charge in charge tab", test, test1);
				
				Extent_completed(tc_Name, test, test1);
}
}
