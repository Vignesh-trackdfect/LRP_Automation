package LRP_Booking_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;
import locators.Plugin_Configuration_Locators;
//check whetherIn Booking, Charge tab spl plugin configuration true and PPA plugin false then system setprepaid location as document Agency location
public class TC_Booking_SC103 extends Keywords {

	public void Booking_SC103(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String test_Case_Name = "TC_Booking_SC103";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String BookingMoudleSearch = Excel_data.get("Search_input");
		String orgin = Excel_data.get("Orgin");
		String delivery = Excel_data.get("Delivery");
		String Agt = Excel_data.get("AGR_Party");
		String AgencyUser = Excel_data.get("AgencyUser");
		String first_service_data = Excel_data.get("first_service_data");
		String Boundinput = Excel_data.get("Boundinput");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String rate_no = Excel_data.get("rate_no");
		String Operator_Code_value = Excel_data.get("Operator_Code_value");
		String Checkbox_Select_3PL = Excel_data.get("Checkbox_Select_3PL");
		String TOS_Value = Excel_data.get("TOS_Value");
		String Agency_RefNo_Value = Excel_data.get("Agency_RefNo_Value");
		String Priority_Value = Excel_data.get("Priority_Value");
		String SCAC_Code_Value = Excel_data.get("SCAC_Code_Value");
		String Container_Popup = Excel_data.get("Container_Popup");
		String pluginConfigurationModule = Excel_data.get("pluginConfigurationModule");
		String PluginID = Excel_data.get("PluginID");
		String pluginStatusTrue = Excel_data.get("pluginStatusTrue");
		String pluginStatusFalse = Excel_data.get("pluginStatusFalse");
		String PluginID1 = Excel_data.get("PluginID1");
		String AgencyDocTF = Excel_data.get("AgencyDocTF");
		String ModuleID = Excel_data.get("ModuleID");
		String PayLoc = Excel_data.get("PayLoc");
		String DocumentValue = Excel_data.get("DocumentValue");
		String conditionFilter=Excel_data.get("ConditionFilter");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String dropdownCondition1=Excel_data.get("GlobalSearchDropdownCondition1");
		String globalSearchFilterOption=Excel_data.get("GlobalSearchFilterOption");
		String savedpopEXP = Excel_data.get("savedpopEXP");
		String Draft_Colour = Excel_data.get("Draft_Colour");
		String Port_Code_Header = Excel_data.get("Port_Code_Header");
		String Customer_Name_Input=Excel_data.get("Customer_Name_Input");
		String Customer_Name_Search = Excel_data.get("Customer_Name_Search");
		String Booking_Date_Input = Excel_data.get("Booking_Date_Input");
		String Booking_Date_Search = Excel_data.get("Booking_Date_Search");
		


		String Priority =  String.format(Booking_Locators.Priority,  Priority_Value); 
		String Code_Val =  String.format(Booking_Locators.Code_Val,  Operator_Code_value); 
		String PluginTrue =  String.format(Plugin_Configuration_Locators.PluginTrue,  pluginStatusTrue); 
		String PluginFalse =  String.format(Plugin_Configuration_Locators.PluginFalse,  pluginStatusFalse); 
		
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
		Step_End(1, "Enter the Agreement Party", test, test1);

		Step_Start(2, "Enter the POL and POD ", test, test1);
		Extent_call(test, test1, "*****Enter Origin*****");
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);
		System.out.println("Origin:" + orgin);
		Extent_call(test, test1, "*****Enter Delivery*****");

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		System.out.println("delivery:" + delivery);
		if (!SCAC_Code_Value.equals("")) {
			waitForElement(driver, SCAC_code_TF);
			sendKeys(driver, SCAC_code_TF, SCAC_Code_Value);
		}

		if (!Priority_Value.equals("")) {
			safeclick(driver, Priority);
		}
		if (!Agency_RefNo_Value.equals("")) {
			waitForElement(driver, Agency_RefNo_TF);
			sendKeys(driver, Agency_RefNo_TF, Agency_RefNo_Value);
		}
		if (!TOS_Value.equals("")) {
			safeclick(driver, TOS);
			if (Checkbox_Select_3PL.equals("YES")) {
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
		}

		Step_End(2, "Enter the POL and POD", test, test1);
		Step_Start(3, "Select the Routing ", test, test1);
	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		
		Step_Start(5, "save the booking in Draft", test, test1);


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
		String booknum = getAttribute(driver, booking_no, "value");
		System.out.println(booknum);
		Step_End(5, "save the booking in Draft", test, test1);
		Step_Start(6, "SPL plugin as True", test, test1);
		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data
		moduleNavigate(driver, pluginConfigurationModule);

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, PluginID);
		waitForElement(driver, ModuleID_Filterbox);
		sendKeys(driver, ModuleID_Filterbox, ModuleID);

		waitForElement(driver, first_Plugin_Row);
		String actualPluginID = getText(driver, first_Plugin_Row);
		if (actualPluginID.equals(PluginID)) {
			Extent_pass_New(driver, PluginID + " plugin ID is available", test, test1);
			System.out.println(PluginID + " plugin ID is available");
		}
		doubleClick(driver, first_Plugin_Row);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);
		waitForElement(driver, PluginTrue);
		safeclick(driver, PluginTrue);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		Step_End(6, "SPL plugin as True", test, test1);
		Step_Start(7, "PPA plugin as false", test, test1);
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, PluginID1);

		waitForElement(driver, first_Plugin_Row);
		doubleClick(driver, first_Plugin_Row);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, enable_Status_Dropdown);
		safeclick(driver, enable_Status_Dropdown);
		waitForElement(driver, PluginFalse);
		click(driver, PluginFalse);

		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);
		Step_End(7, "PPA plugin as false", test, test1);

		moduleNavigate(driver, BookingMoudleSearch);
				
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, booknum, Booking_Date_Search, Booking_Date_Input, Customer_Name_Search, Customer_Name_Input);

		
		
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		Step_Start(8, "system setprepaid location as document Agency location", test, test1);
		waitForElement(driver, Agency_Documentation_TF);
		clear(driver, Agency_Documentation_TF);
		sendKeys(driver, Agency_Documentation_TF, AgencyDocTF);
		System.out.println(AgencyDocTF);
		String DocumentLoc =  String.format(Booking_Locators.DocumentLoc,  DocumentValue); 
		safeclick(driver, DocumentLoc);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click1(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		waitForElement(driver, close_first_Tab);
		safeclick(driver, close_first_Tab);

		moduleNavigate(driver, BookingMoudleSearch);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, dropdownCondition1, globalSearchFilterOption, booknum, Booking_Date_Search, Booking_Date_Input, Customer_Name_Search, Customer_Name_Input);

		
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);
		waitForElement(driver, Commodity_Grid_EditBtn);
		safeclick(driver, Commodity_Grid_EditBtn);
		waitForElement(driver, Commodity_Add_Btn);
		safeclick(driver, Commodity_Add_Btn);
waitForDisplay(driver, popup_Message);
		if (isDisplayed(driver, popup_Message)) {
			String value3 = getText(driver, popup_Message);
			if (value3.contains(Container_Popup)) {
				System.out.println(
						"Matched || Expected value popup was : " + value3 + " || Actual value popup was : " + Container_Popup);
				Extent_pass_New(driver,
						"Matched || Expected value popup  was : " + value3 + " || Actual value popup was : " + Container_Popup, test,
						test1);

			} else {
				System.out.println(
						"NotMatched || Expected value popup was : " + value3 + " || Actual value popup was : " + Container_Popup);
				Extent_fail(driver,
						"NotMatched || Expected value popup was : " + value3 + " || Actual value popup was : " + Container_Popup,
						test, test1);

			}
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);

		}

		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		
		scrollBottom(driver);
		waitForElement(driver, Pay_Loc_Value);
		RightClick(driver, Pay_Loc_Value);
		waitForElement(driver, PayMode_Option);
		click1(driver, PayMode_Option);
		waitForElement(driver, Prepaid);
		safeclick(driver, Prepaid);
		waitForElement(driver, PortCodeTf);
		
		twoColumnSearchWindow(driver, Port_Code_Header, conditionFilter, PayLoc);


		waitForElement(driver, Pay_Loc_Value);
		String value_1 = getText(driver, Pay_Loc_Value);
		System.out.println(value_1);
		if (!AgencyDocTF.equals(value_1)) {

			System.out.println("Matched || Expected value SHOULD BE SHOWN was : " + AgencyDocTF + " || Actual value was : " + value_1);
			Extent_pass_New(driver, "Matched || Expected value SHOULD BE SHOWN was : " + AgencyDocTF + " || Actual value was : " + value_1,
					test, test1);

		} else {
			System.out.println("NotMatched || Expected value  SHOULD BE SHOWN was : " + AgencyDocTF + " || Actual value  SHOWN was : " + value_1);
			Extent_fail(driver,"NotMatched || Expected value SHOULD BE SHOWN  was : " + AgencyDocTF + " || Actual value  SHOWN  was : " + value_1, test,
					test1);
		}
		Step_End(8, "system set prepaid location as document Agency location", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}

