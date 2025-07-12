package LRP_Booking_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Booking_Locators;

public class TC_Booking_SC087 extends Keywords {
	//	check whether in Booking, while change the DG to non dg and remove the  dg container same details will remove in DG too .

	public void Booking_SC087(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Booking_SC087";

		//Get data from excel sheet

		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String Search =Excel_data.get("Search_input");
		String delivery =Excel_data.get("Delivery");
		String orgin =Excel_data.get("Orgin");
		String agencyUser = Excel_data.get("AgencyUser");
		String Commodity_Chk_Box_Exp = Excel_data.get("Commodity_Chk_Box");
		String DG_Chk_Box_Exp = Excel_data.get("DG_Chk_Box");
		String Tar_Chk_Box_Exp = Excel_data.get("Tar_Chk_Box");
		String savedpopEXP = Excel_data.get("BookingSavedpopup");
		String rate_no = Excel_data.get("rate_no");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String Select_Columns = Excel_data.get("Select_Columns");
		String DG_Input =Excel_data.get("DG_Input");
		String random_no =Excel_data.get("random_no");
		String con_cargo_wt_value =Excel_data.get("con_cargo_wt_value");
		String bookingYelloecolour = Excel_data.get("Yellowcolour");
		String Base_Rate = Excel_data.get("Base_Rate");
		String charge_Txt_Input = Excel_data.get("charge_Txt_Input");
		String Base_Rate_Unit_SearchField_Input = Excel_data.get("Base_Rate_Unit_SearchField_Input");
		String Currency_SearchField_Input = Excel_data.get("Currency_SearchField_Input");
		String EquipType_Input = Excel_data.get("EquipType_Input");
		String Limited_Quant_Input = Excel_data.get("Limited_Quant_Input");
		String Expected_Quant_Input = Excel_data.get("Expected_Quant_Input");
		String Reported_Quant_Input = Excel_data.get("Reported_Quant_Input");
		String Waste_Input = Excel_data.get("Waste_Input");
		String Search1 = Excel_data.get("Search_input1");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
		String Request_Sent_Popup = Excel_data.get("Request_Sent_Popup");
		String Details_Checked_Popup = Excel_data.get("Details_Checked_Popup");
		String Remarks_Input = Excel_data.get("Remarks_Input");
		String Request_Accept_Popup = Excel_data.get("Request_Accept_Popup");
		String Attach_DG_Popup = Excel_data.get("Attach_DG_Popup");
		String random_no1 = Excel_data.get("random_no1");
		String Refresh_Leg_Popup = Excel_data.get("Refresh_Leg_Popup");
		String Charges_Removed_Popup = Excel_data.get("Charges_Removed_Popup");
		String Commodity_Adding_Popup = Excel_data.get("Commodity_Adding_Popup");
		String Weight_Changed_Popup = Excel_data.get("Weight_Changed_Popup");
		String Updated_Popup = Excel_data.get("Updated_Popup");
		String unNo = Excel_data.get("UnNo");
		String emergencyContactField1 = Excel_data.get("EmergencyContactField1");
		String emergencyContactField2 = Excel_data.get("EmergencyContactField2");
		String emergencyContacField3 = Excel_data.get("EmergencyContacField3");
		String contactNameField = Excel_data.get("ContactNameField");
		String outPackingName = Excel_data.get("OutPackingName");
		String noOfOuter = Excel_data.get("NoOfOuter");
		String grossWtField = Excel_data.get("GrossWtField");
		String netWtField = Excel_data.get("NetWtField");
		String Pay_By_Input = Excel_data.get("Pay_By_Input");
		String date_Picker = Excel_data.get("date_Picker");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String dgContainerRemovedPopup = Excel_data.get("DGContainerRemovedPopup");
		String valid_Days_Input = Excel_data.get("Valid_Days_Input");
		String Agt =Excel_data.get("AGR_Party");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String Charge_Column_Header =Excel_data.get("Charge_Column_Header");
		String Unit_Column_Header = Excel_data.get("Unit_Column_Header");
		String Condition = Excel_data.get("Condition");
		String Currency_Column_Header = Excel_data.get("Currency_Column_Header");
		String UN_Number_Column_Header = Excel_data.get("UN_Number_Column_Header");
		

		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);


		//locators
		String EquipTypeValue=String.format(Booking_Locators.equipTypeValue,EquipType_Input);
		String Limited_Quant_No=String.format(Booking_Locators.Limited_Quant_Option,Limited_Quant_Input);
		String Expected_Quant_No=String.format(Booking_Locators.Expected_Quant_Option,Expected_Quant_Input);
		String Reported_Quant_No=String.format(Booking_Locators.Reported_Quant_Option,Reported_Quant_Input);
		String Waste_No=String.format(Booking_Locators.Waste_Option,Waste_Input);
		String Pay_By_Select=String.format(Booking_Locators.pay_By_Select,Pay_By_Input);



		// Login
		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, agencyUser);


		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
				moduleNavigate(driver, Search);

		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);
		Step_Start(2, "Enter the POL and POD and select the Rates using Rates window",test, test1);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		keyboardArrowDown(driver);
		enter(driver);

		waitForElement(driver, DeliveryInput);
		safeclick(driver, DeliveryInput);
		clearAndType(driver, DeliveryInput, delivery);
		keyboardArrowDown(driver);
		enter(driver);
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

		Extent_call(test, test1,"********** Select the Check Box in Rates Window **********");
		waitForElement(driver,Valid_Days);
		clearAndType(driver, Valid_Days, valid_Days_Input);	

		waitForElement(driver, Commodity_Chk_Box);
		checkBox(driver, Commodity_Chk_Box,Commodity_Chk_Box_Exp);
		waitForElement(driver, DG_Chk_Box);
		checkBox(driver, DG_Chk_Box,DG_Chk_Box_Exp);
		waitForElement(driver, Tar_Chk_Box);
		checkBox(driver, Tar_Chk_Box,Tar_Chk_Box_Exp);
		waitForElement(driver, Rates_Show_Btn);
		safeclick(driver, Rates_Show_Btn);

		Extent_call(test, test1,"********** Select the Columns in Rates Window **********");
		reArrangeAG_GridColumns(driver, Select_Columns);
		Extent_call(test, test1,"********** Create the condition filter in Rates Window **********");
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);
		waitForElement(driver, DG_Column_Field);
		sendKeys(driver, DG_Column_Field,DG_Input);
		waitForElement(driver, UnNo_Column_Field);
		safeclick(driver, UnNo_Column_Field);
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);

		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);

		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		
		Step_End(2, "Enter the POL and POD and select the Rates using Rates window",test, test1);
		
		selectRatesRouting(driver, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		
		Step_Start(3, "save the booking in Draft", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message,savedpopEXP);
		String savepopACT = getText(driver, popup_Message);
		System.out.println(savepopACT);
		if(savepopACT.contains(savedpopEXP)) {                                                                                                                  
			System.out.println("Matched || " + " Actual Report Activity is : " + savepopACT + " || Expected Report Activity is : " + savedpopEXP);            
			Extent_pass_New(driver, "Matched || " + " Actual Report Activity is[Booking number input field want to change yellow colour] : " + savepopACT + " || Expected Report Activity is [Booking number input field  changed yellow colour] : " + savedpopEXP, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Actual Report Activity is : " + savepopACT + " || Expected Report Activity is : " + savedpopEXP);        
			Extent_fail(driver, "Not Matched || " + " Actual Report Activity is[Booking number input field not  changed yellow colour] : " + savepopACT + " || Expected Report Activity is[Booking number input field not  changed yellow colour] : " + savedpopEXP, test,test1); 
		} 
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);
		waitForElement(driver, booking_no);
		String draft_bookingColorCode = getTextBackgroundColor(driver, booking_no);
		String draft_bookingColor=getColorName(draft_bookingColorCode);
		
		if(draft_bookingColor.equalsIgnoreCase(bookingYelloecolour)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + bookingYelloecolour + " || Actual Report Activity is : " + draft_bookingColor);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is[Booking number input field want to change Yellow colour] : " + bookingYelloecolour + " || Actual Report Activity is [Booking number input field  changed yellow colour] : " + draft_bookingColor, test, test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + bookingYelloecolour + " || Actual Report Activity is : " + draft_bookingColor);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is[Booking number input field not  changed Yellow colour] : " + bookingYelloecolour + " || Actual Report Activity is[Booking number input field not  changed yellow colour] : " + draft_bookingColor, test, test1); 
		} 
		Step_End(3,"save the booking in Draft", test, test1);

		Step_Start(4,"IMO Tab Create DG", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, IMO_Tab);
		safeclick(driver, IMO_Tab);
		waitForElement(driver, Request_DG_Btn);
		safeclick(driver, Request_DG_Btn);

		waitForElement(driver, UnNo_Search);
		safeclick(driver, UnNo_Search);
		twoColumnSearchWindow(driver, UN_Number_Column_Header, Condition, unNo);
		waitForElement(driver, Emergency_Contact_Field1);
		safeclick(driver, Emergency_Contact_Field1);
		sendKeys(driver, Emergency_Contact_Field1, emergencyContactField1);
		waitForElement(driver, Emergency_Contact_Field2);
		safeclick(driver, Emergency_Contact_Field2);
		sendKeys(driver, Emergency_Contact_Field2, emergencyContactField2);
		waitForElement(driver, Emergency_Contact_Field3);
		safeclick(driver, Emergency_Contact_Field3);
		sendKeys(driver, Emergency_Contact_Field3, emergencyContacField3);
		waitForElement(driver, Limited_Quantity);
		safeclick(driver, Limited_Quantity);
		waitForElement(driver, Limited_Quant_No);
		safeclick(driver, Limited_Quant_No);
		waitForElement(driver, Expected_Quantity);
		safeclick(driver, Expected_Quantity);
		waitForElement(driver, Expected_Quant_No);
		safeclick(driver, Expected_Quant_No);
		waitForElement(driver,Reported_Quantity);
		safeclick(driver, Reported_Quantity);
		waitForElement(driver,Reported_Quant_No);
		safeclick(driver, Reported_Quant_No);
		waitForElement(driver, Waste_Field);
		safeclick(driver, Waste_Field);
		waitForElement(driver, Waste_No);
		safeclick(driver, Waste_No);
		waitForElement(driver, Contact_Name_Field);
		sendKeys(driver, Contact_Name_Field, contactNameField);
		waitForElement(driver, OutPacking_Name);
		sendKeys(driver, OutPacking_Name,outPackingName);
		enter(driver);
		waitForElement(driver, No_Of_Outer);
		safeclick(driver, No_Of_Outer);
		sendKeys(driver, No_Of_Outer, noOfOuter);
		waitForElement(driver, Gross_Wt_Field);
		safeclick(driver, Gross_Wt_Field);
		clearAndType(driver, Gross_Wt_Field, grossWtField);
		safeclick(driver, Gross_Wt_Field);
		waitForElement(driver, Net_Wt_Field);
		safeclick(driver, Net_Wt_Field);
		sendKeys(driver, Net_Wt_Field, netWtField);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		waitForPopup(driver, popup_Message,Applied_Popup_Exp);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if(Applied_Popup.equals(Applied_Popup_Exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup, test,test1); 
		} 
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		waitForElement(driver, DG_Save_Btn);
		safeclick(driver, DG_Save_Btn);
		waitForPopup(driver, popup_Message,Details_Saved_Popup);
		String Saved_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if(Saved_Popup.equals(Details_Saved_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup, test,test1); 
		}
		waitForElement(driver, Send_Btn);
		safeclick(driver, Send_Btn);
		waitForPopup(driver, popup_Message,Request_Sent_Popup);
		String act_Popup = getText(driver, popup_Message);
		System.out.println(act_Popup);
		if(act_Popup.equals(Request_Sent_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Request_Sent_Popup + " || Actual Report Activity is : " + act_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Request_Sent_Popup + " || Actual Report Activity is : " + act_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Request_Sent_Popup + " || Actual Report Activity is : " + act_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Request_Sent_Popup + " || Actual Report Activity is : " + act_Popup, test,test1); 
		}
		waitForElement(driver, Mail_Cancel_Btn);
		safeclick(driver, Mail_Cancel_Btn);

		Step_End(4,"IMO Tab Create DG", test, test1);
		Step_Start(5,"Switch the profile to Approve the DG", test, test1);

		ResetProfile(driver);
		

		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
				moduleNavigate(driver, Search1);		
				scrollTop(driver);
				waitForElement(driver, From_Date_Radio_Btn);
				safeclick(driver, From_Date_Radio_Btn);
				waitForElement(driver, FromDate_Field);
				if (date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, FromDate_Field, From_Date_Input);
				} else {
					waitForElement(driver, FromDate_Field);
					clearAndType(driver, FromDate_Field, From_Date_Input);
				}

				waitForElement(driver, ToDate_Field);
				if (date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, ToDate_Field, To_Date_Input);
				} else {
					waitForElement(driver, ToDate_Field);
					clearAndType(driver, ToDate_Field, To_Date_Input);
				}
		waitForElement(driver, DG_Gate_ShowBtn);
		safeclick(driver, DG_Gate_ShowBtn);

		waitForElement(driver, bookNO_Filter_Dg_Gate);
		safeclick(driver, bookNO_Filter_Dg_Gate);
		waitForElement(driver, bookNO_Filter_Dg_Gate);
		sendKeys(driver, bookNO_Filter_Dg_Gate, booknum);

		String bookNo_Select=String.format(select_BookNo, booknum);
		waitForElement(driver, bookNo_Select);
		doubleClick(driver, bookNo_Select);


		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		waitForElement(driver, Multi_ChkList_Btn);
		safeclick(driver, Multi_ChkList_Btn);
		waitForPopup(driver, popup_Message,Details_Checked_Popup);
		String actual_Popup = getText(driver, popup_Message);
		System.out.println(actual_Popup);
		if(Details_Checked_Popup.equals(actual_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Details_Checked_Popup + " || Actual Report Activity is : " + actual_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Details_Checked_Popup + " || Actual Report Activity is : " + actual_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Details_Checked_Popup + " || Actual Report Activity is : " + actual_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Details_Checked_Popup + " || Actual Report Activity is : " + actual_Popup, test,test1); 
		}
		waitForElement(driver, Accept_Btn);
		safeclick(driver, Accept_Btn);
		waitForElement(driver,Remarks_Area);
		sendKeys(driver, Remarks_Area, Remarks_Input);
		waitForElement(driver, Remarks_Ok);
		safeclick(driver, Remarks_Ok);
		waitForPopup(driver, popup_Message,Request_Accept_Popup);
		String Act_Popup = getText(driver, popup_Message);
		System.out.println(Act_Popup);
		if(Act_Popup.equals(Request_Accept_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Request_Accept_Popup + " || Actual Report Activity is : " + Act_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Request_Accept_Popup + " || Actual Report Activity is : " + Act_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Request_Accept_Popup + " || Actual Report Activity is : " + Act_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Request_Accept_Popup + " || Actual Report Activity is : " + Act_Popup, test,test1); 
		}
		waitForElement(driver, Mail_Cancel_Btn);
		safeclick(driver, Mail_Cancel_Btn);
		Step_End(5,"Switch the profile to Approve the DG", test, test1);
		Extent_call(test, test1, "Logout and Login for Switch User");


				

		Step_End(6,"Switch User", test, test1);
		SwitchProfile(driver, agencyUser);
		
		Step_End(6,"Switch User", test, test1);
		Step_Start(7,"Enter Booking MOdule and edith the Booking Value", test, test1);

		
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		
		moduleNavigate(driver, Search);
		scrollTop(driver);
		waitForElement(driver, condition_Filter_Local);
		safeclick(driver, condition_Filter_Local);
		waitForElement(driver, local_Equal_To);
		safeclick(driver, local_Equal_To);
		waitForElement(driver, local_Search_Inputfield);
		clearAndType(driver, local_Search_Inputfield,booknum);
		safeclick(driver, local_SearchButton);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		waitForElement(driver, IMO_Tab);
		safeclick(driver, IMO_Tab);
		waitForElement(driver, Search_Imo_Btn);
		safeclick(driver, Search_Imo_Btn);
		waitForElement(driver, Search_Imo_Close);
		safeclick(driver, Search_Imo_Close);
		waitForElement(driver, Container_Tab);
		safeclick(driver, Container_Tab);

		waitForElement(driver, con_editicon);
		safeclick(driver, con_editicon);

		waitForElement(driver, con_eqp_id);
		safeclick(driver, con_eqp_id);
		sendKeys(driver, con_eqp_id, random_no);
		Step_End(7,"Enter Booking MOdule and edith the Booking Value", test, test1);
		Step_Start(8,"Edit the container", test, test1);

		String eqp_id=getAttribute(driver, con_eqp_id, "value");
		System.out.println(eqp_id);
		waitForElement(driver, con_cargo_wt);
		safeclick(driver, con_cargo_wt);
		clearAndType(driver, con_cargo_wt, con_cargo_wt_value);
		if(!isElementSelected(driver, DG_CheckBox_ContTab)) {
			waitForElement(driver, DG_CheckBox_ContTab);
			safeclick(driver, DG_CheckBox_ContTab);
		}
		waitForElement(driver, con_add_btn);
		safeclick(driver, con_add_btn);
		Step_End(8,"Edit the container", test, test1);
		Step_Start(9,"Edit the Charges Tab and Add Haz Charge Manually", test, test1);

		waitForElement(driver, dummy_container_yes); 
		safeclick(driver, dummy_container_yes);
		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		waitForElement(driver, master_tab);	
		safeclick(driver, master_tab);			
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		waitForDisplay(driver, popup_Message);
		if(!isdisplayed(driver, popup_Message)){
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);

			waitForElement(driver, Charges_tab);
			safeclick(driver, Charges_tab);
			waitForElement(driver, charge_Search_Icon);
			safeclick(driver, charge_Search_Icon);
			twoColumnSearchWindow(driver, Charge_Column_Header, Condition, charge_Txt_Input);

			waitForElement(driver, Base_Rate_Unit_Searchbtn);
			safeclick(driver, Base_Rate_Unit_Searchbtn);
			twoColumnSearchWindow(driver, Unit_Column_Header, Condition, Base_Rate_Unit_SearchField_Input);
			
			waitForElement(driver, Currency_SearchBtn);
			safeclick(driver, Currency_SearchBtn);
			twoColumnSearchWindow(driver, Currency_Column_Header, Condition, Currency_SearchField_Input);

			waitForElement(driver, EquipmentType_Dropdown);
			safeclick(driver, EquipmentType_Dropdown);
			waitForElement(driver, EquipTypeValue);
			safeclick(driver, EquipTypeValue);

			waitForElement(driver, Rate_Ref_No);
			safeclick(driver, Rate_Ref_No);

			waitForElement(driver, Base_Rate_TF);
			safeclick(driver, Base_Rate_TF);
			Newclear_Type(driver);
			sendKeys(driver, Base_Rate_TF, Base_Rate);
			waitForElement(driver, Pay_By_Dropdown);
			safeclick(driver, Pay_By_Dropdown);
			waitForElement(driver, Pay_By_Select);
			safeclick(driver, Pay_By_Select);

			waitForElement(driver, Charges_Add_Btn);
			safeclick(driver, Charges_Add_Btn);
			waitForElement(driver, Containersavebtn);
			safeclick(driver, Containersavebtn);
		}

		Step_End(9,"Edit the Charges Tab and Add Haz Charge Manually", test, test1);
		Step_Start(10,"Verify the  Popup", test, test1);

		waitForPopup(driver, popup_Message,Attach_DG_Popup);
		String Attach_DG = getText(driver, popup_Message);
		System.out.println(Attach_DG);
		if(Attach_DG.contains(Attach_DG_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Attach_DG_Popup + " || Actual Report Activity is : " + Attach_DG);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Attach_DG_Popup + " || Actual Report Activity is : " + Attach_DG, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Attach_DG_Popup + " || Actual Report Activity is : " + Attach_DG);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Attach_DG_Popup + " || Actual Report Activity is : " + Attach_DG, test,test1); 
		}
		Step_End(10,"Verify the Popup", test, test1);
		Step_Start(11,"Auto Apply the DG value in IMO Tab", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		waitForElement(driver, IMO_Tab);
		safeclick(driver, IMO_Tab);
		waitForElement(driver, Search_Imo_Btn);
		safeclick(driver, Search_Imo_Btn);
		waitForElement(driver, AutoMap_Btn);
		safeclick(driver, AutoMap_Btn);
		waitForElement(driver, Apply_Btn);
		safeclick(driver, Apply_Btn);
		waitForPopup(driver, popup_Message,Charges_Removed_Popup);
		String Remove_Popup = getText(driver, popup_Message);
		System.out.println(Remove_Popup);
		if(Charges_Removed_Popup.contains(Remove_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Charges_Removed_Popup + " || Actual Report Activity is : " + Remove_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Charges_Removed_Popup + " || Actual Report Activity is : " + Remove_Popup, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Charges_Removed_Popup + " || Actual Report Activity is : " + Remove_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Charges_Removed_Popup + " || Actual Report Activity is : " + Remove_Popup, test,test1); 
		}
		Step_End(11,"Auto Apply the DG value in IMO Tab", test, test1);
		Step_Start(12,"Refresh the Leg Tab and Verify the Popup", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);

		waitForElement(driver, Leg_tab);
		safeclick(driver, Leg_tab);
		waitForElement(driver, Leg_Refresh);
		safeclick(driver, Leg_Refresh);
		waitForElement(driver, popup_Message);
		String Refresh_Leg = getText(driver, popup_Message);
		System.out.println(Refresh_Leg);
		if(Refresh_Leg_Popup.contains(Refresh_Leg)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Refresh_Leg_Popup + " || Actual Report Activity is : " + Refresh_Leg);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Refresh_Leg_Popup + " || Actual Report Activity is : " + Refresh_Leg, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Refresh_Leg_Popup + " || Actual Report Activity is : " + Refresh_Leg);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Refresh_Leg_Popup + " || Actual Report Activity is : " + Refresh_Leg, test,test1); 
		}
		waitForElement(driver, popup_Message_Yes_Button);
		safeclick(driver, popup_Message_Yes_Button);

		Step_End(12,"Refresh the Leg Tab and Verify the Popup", test, test1);
		Step_Start(13,"Edit the Commodity Tab", test, test1);

		waitForElement(driver, commodity_tab);
		safeclick(driver, commodity_tab);
		waitForElement(driver, Commodity_Edit);
		safeclick(driver, Commodity_Edit);
		waitForElement(driver, Commodity_Add);
		safeclick(driver, Commodity_Add);
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			String Commodity = getText(driver, popup_Message);
			System.out.println(Commodity);
			if(Commodity_Adding_Popup.contains(Commodity)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity is : " + Commodity_Adding_Popup + " || Actual Report Activity is : " + Commodity);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Commodity_Adding_Popup + " || Actual Report Activity is : " + Commodity, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity is : " + Commodity_Adding_Popup + " || Actual Report Activity is : " + Commodity);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Commodity_Adding_Popup + " || Actual Report Activity is : " + Commodity, test,test1); 
			}
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
		}
		Step_End(13,"Edit the Commodity Tab", test, test1);

		waitForElement(driver, Container_Tab);
		safeclick(driver, Container_Tab);

		waitForElement(driver, con_editicon);
		safeclick(driver, con_editicon);

		waitForElement(driver, con_eqp_id);
		safeclick(driver, con_eqp_id);
		sendKeys(driver, con_eqp_id, random_no1);

		String eqp_id1=getAttribute(driver, con_eqp_id, "value");
		System.out.println(eqp_id1);
		waitForElement(driver, con_cargo_wt);
		safeclick(driver, con_cargo_wt);
		clearAndType(driver, con_cargo_wt, con_cargo_wt_value);
		if(!isElementSelected(driver, DG_CheckBox_ContTab)) {
			waitForElement(driver, DG_CheckBox_ContTab);
			safeclick(driver, DG_CheckBox_ContTab);
		}
		waitForElement(driver, con_add_btn);
		safeclick(driver, con_add_btn);
		waitForElement(driver, dummy_container_yes);
		safeclick(driver, dummy_container_yes);

		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			String Weigt_Popup = getText(driver, popup_Message);
			System.out.println(Weigt_Popup);
			if(Weight_Changed_Popup.contains(Weigt_Popup)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity is : " + Weight_Changed_Popup + " || Actual Report Activity is : " + Weigt_Popup);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Weight_Changed_Popup + " || Actual Report Activity is : " + Weigt_Popup, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity is : " + Weight_Changed_Popup + " || Actual Report Activity is : " + Weigt_Popup);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Weight_Changed_Popup + " || Actual Report Activity is : " + Weigt_Popup, test,test1); 
			}
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
		}
		waitForElement(driver, Charges_tab);
		safeclick(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);

		Step_Start(14, "System should validate the Popup", test, test1);

		waitForPopup(driver, popup_Message,Updated_Popup);
		String DG_Saved_Popup = getText(driver, popup_Message);
		System.out.println(DG_Saved_Popup);
		if(DG_Saved_Popup.contains(Updated_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Updated_Popup + " || Actual Report Activity is : " + DG_Saved_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Updated_Popup + " || Actual Report Activity is : " + DG_Saved_Popup, test,test1);     
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Updated_Popup + " || Actual Report Activity is : " + DG_Saved_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Updated_Popup + " || Actual Report Activity is : " + DG_Saved_Popup, test,test1); 
		}


		Step_End(14, "System should validate the Popup", test, test1);

		//	Remove DG

		Step_Start(15, "Remove DG Container", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, IMO_Tab);
		click(driver, IMO_Tab);
		waitForElement(driver, Search_Imo_Btn);
		click(driver, Search_Imo_Btn);
		waitForElement(driver, dgContainerGrid);
		click(driver, dgContainerGrid);
		waitForElement(driver, dgContainer_Checkbox);
		click(driver, dgContainer_Checkbox);
		waitForElement(driver, dgRemove_Button);
		click(driver, dgRemove_Button);

		waitForPopup(driver, popup_Message,dgContainerRemovedPopup);
		String Removed_Popup = getText(driver, popup_Message);
		System.out.println(Removed_Popup);
		if(Removed_Popup.equals(dgContainerRemovedPopup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + dgContainerRemovedPopup + " || Actual Report Activity is : " + Removed_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + dgContainerRemovedPopup + " || Actual Report Activity is : " + Removed_Popup, test,test1);     
			Extent_pass_New(driver, dgContainerRemovedPopup+" popup is displayed", test,test1);
			System.out.println(dgContainerRemovedPopup+" popup is displayed");

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, bookingPopupOK);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + dgContainerRemovedPopup + " || Actual Report Activity is : " + Removed_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + dgContainerRemovedPopup + " || Actual Report Activity is : " + Removed_Popup, test,test1); 
		}


		waitForElement(driver, dgCancel_Button);
		click(driver, dgCancel_Button);

		waitForElement(driver, Request_DG_Btn);
		click(driver, Request_DG_Btn);
		waitForElement(driver, UnNo_Search);

		scrollBottom(driver);
		waitForDisplay(driver,Booking_Locators.Container_Select);
		if(! isDisplayed(driver, Booking_Locators.Container_Select)) {
			Extent_pass_New(driver, "Matched || Expected result is : DG container Should be Remove || The Actual Result is : DG container Removed", test,test1);
			System.out.println("Matched || Expected result is : DG container Should be Remove || The Actual Result is : DG container Removed");
		}else {
			System.out.println("Not Matched || Expected result is : DG container Should be Remove || The Actual Result is : DG container Not Removed");
			Extent_fail(driver,"Not Matched || Expected result is : DG container Should be Remove || The Actual Result is : DG container Not Removed", test,test1);

		}
		Step_End(15, "Remove DG Container", test, test1);
		Extent_completed(testCaseName, test, test1);


	}
}
