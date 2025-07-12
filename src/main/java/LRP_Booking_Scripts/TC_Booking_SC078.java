package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC078 extends Keywords{
	
public void Booking_SC078 (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
	String tc_Name="TC_Booking_SC078";
		
		
		  
		  
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
			String charge_code1 = Excel_data.get("charge_code1");
			String base_unit = Excel_data.get("base_unit");
			String currency_value = Excel_data.get("currency_value");
			String base_rate_value = Excel_data.get("base_rate_value");
			String payby = Excel_data.get("payby");
			String paymode = Excel_data.get("paymode");
			String equiptype = Excel_data.get("equiptype");
			String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
			String condition = Excel_data.get("condition");
			String Currency_Code_search = Excel_data.get("Currency_Code_search");
			String Unit_Code_search = Excel_data.get("Unit_Code_search");
			String Charge_code_search = Excel_data.get("Charge_code_search");
			String savedpopEXP = Excel_data.get("savedpopEXP");
			
			 //locators
			String equiptype_opt =String.format(Booking_Locators.equiptype_opt, equiptype);
			String paymode_opt =String.format(Booking_Locators.paymode_opt, paymode);
			String payby_opt = String.format(Booking_Locators.payby_opt, payby);
			String addtional_charges =String.format(Booking_Locators.addtional_charges, charge_code1);
			 
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
				
				waitForElement(driver, Draft_Button);
				safeclick(driver, Draft_Button);         
                 scrollTop(driver);

				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				
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
				String draft_bookingColorCode=getTextBackgroundColor(driver,booking_no);
				String draft_bookingColor = getColorName(draft_bookingColorCode);
				if(draft_bookingColor.equals(booking_draft_Color)) {                                                                                                                  
					System.out.println("Matched || " + " Expected Report Activity is : " + booking_draft_Color + " || Actual Report Activity is : " + draft_bookingColor);            
					Extent_pass_New(driver, "Matched || " + " Expected Report Activity is[Booking number input field want to change green colour] : " + booking_confirmed_Color + " || Actual Report Activity is [Booking number input field  changed yellow colour] : " + draft_bookingColor, test, test1);     
				}                                                                                                                                                                        
				else {                                                                                                                                                                   
					System.out.println("Not Matched || " + " Expected Report Activity is : " + booking_draft_Color + " || Actual Report Activity is : " + draft_bookingColor);        
					Extent_fail(driver, "Not Matched || " + " Expected Report Activity is[Booking number input field not  changed green colour] : " + booking_draft_Color + " || Actual Report Activity is[Booking number input field not  changed yellow colour] : " + draft_bookingColor, test, test1); 
				} 
				Step_End(6, "Save the booking in Draft", test, test1);
				
				
				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
				
				waitForElement(driver, master_tab);
				safeclick(driver, master_tab);
				
				String booknum = getAttribute(driver, booking_no,"value");
				System.out.println(booknum);
				waitForElement(driver, Confirmed_Button);
				click(driver, Confirmed_Button);
				
				waitForElement(driver, Charges_tab);
					click(driver, Charges_tab);

					waitForElement(driver, AutoRated);
					click(driver, AutoRated);
					
					waitForElement(driver, charge_Search_Icon);
					click(driver, charge_Search_Icon);
					
					twoColumnSearchWindow(driver, Charge_code_search, condition, charge_code1);
					
					
					waitForElement(driver, base_Rate_Search_Icon);
					click(driver, base_Rate_Search_Icon);
					twoColumnSearchWindow(driver, Unit_Code_search, condition, base_unit);
					
					waitForElement(driver, currency_Search_Icon);
					click(driver, currency_Search_Icon);
					twoColumnSearchWindow(driver, Currency_Code_search, condition, currency_value);
				
					waitForElement(driver, equip_type_field);
					click(driver, equip_type_field);
						waitForElement(driver, equiptype_opt);
						click(driver, equiptype_opt);
						
					waitForElement(driver, baserate);
					clear(driver, baserate);
					sendKeys(driver, baserate, base_rate_value);
					tab(driver);
					
					waitForElement(driver, payment_mode_field);
					click(driver, payment_mode_field);
					waitForElement(driver, paymode_opt);
						click(driver, paymode_opt);
						
					
					waitForElement(driver, payby_field);
					click(driver, payby_field);
					waitForElement(driver, payby_opt);
						click(driver, payby_opt);
						
					waitForElement(driver, charges_add);
					click(driver, charges_add);

					
					waitForDisplay(driver, charges_Tab_Scroll);
					if(isdisplayed(driver, charges_Tab_Scroll)) {
					verticalScroll(driver, charges_Tab_Scroll, 500);
					}
					waitForElement(driver, addtional_charges);
					String attached_charges_value = getText(driver, addtional_charges);
					
					waitForDisplay(driver,addtional_charges);

					if(isDisplayed(driver, addtional_charges)) {                                                                                                                  
						System.out.println("Matched || " + " Expected Chares value is : " + charge_code1 + " || Actual Chares value is : " + attached_charges_value);            
						Extent_pass_New(driver, "Matched || " + " Expected Chares value is : " + charge_code1 + " || Actual Chares value is : " + attached_charges_value, test,test1);     
					}                                                                                                                                                                        
					else {                                                                                                                                                                   
						System.out.println("Not Matched || " + " Expected Chares value is : " + charge_code1 + " || Actual Chares value is : " + attached_charges_value);        
						Extent_fail(driver, "Not Matched || " + " Expected Chares value is : " + charge_code1 + " || Actual Chares value is : " + attached_charges_value, test,test1); 
					} 
					
					Step_Start(7, " select confirm button and click Save button ", test, test1);
					waitForElement(driver, master_tab);
					click(driver, master_tab);
					
					waitForElement(driver, Confirmed_Button);
					click(driver, Confirmed_Button);
					
					scrollTop(driver);
					waitForElement(driver, SaveButton_ToolBar);
					click1(driver, SaveButton_ToolBar);
					waitForDisplay(driver, popup_Message_Ok_Button);
					if(isdisplayed(driver, popup_Message_Ok_Button)) {
						
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver, popup_Message_Ok_Button);
					}
					Step_End(7, " select confirm button and click Save button ", test, test1);

					Extent_completed(tc_Name, test, test1);

}
}
