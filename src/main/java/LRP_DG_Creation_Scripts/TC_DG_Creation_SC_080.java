package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


public class TC_DG_Creation_SC_080 extends Keywords {


	public void DG_Creation_SC_080(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_080";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");
		String Limited_Quantity_Input = Excel_data.get("Limited_Quantity_Input");
		String Expected_Quantity_Input = Excel_data.get("Expected_Quantity_Input");
		String Reported_Quantity_Input = Excel_data.get("Reported_Quantity_Input");
		String Waste_Input = Excel_data.get("Waste_Input");
		String unNo = Excel_data.get("UN_No");
		String emergencyContactField1 = Excel_data.get("emergencyContactField1");
		String emergencyContactField2 = Excel_data.get("emergencyContactField2");
		String emergencyContactField3 = Excel_data.get("emergencyContactField3");
		String contactNameField = Excel_data.get("ContactNameField");
		String grossWtField = Excel_data.get("GrossWtField");
		String netWtField = Excel_data.get("NetWtField");
		String Column_condition = Excel_data.get("Column_condition");
		String UN_Number_Column_Header = Excel_data.get("UN_Number_Column_Header");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String Technical_Name = Excel_data.get("Technical_Name");
		String Marine_Pollutant = Excel_data.get("Marine_Pollutant");
		String Non_Operated_reefer_Dropdown = Excel_data.get("Non_Operated_reefer_Dropdown");
		String Unit_Input_Values = Excel_data.get("Unit_Input_Values");
		String Inner_Packing_Size_Input = Excel_data.get("Inner_Packing_Size_Input");
		String Net_Explosive_Weight = Excel_data.get("Net_Explosive_Weight");
		String Amendment = Excel_data.get("Amendment");
		String Flash_Point_C = Excel_data.get("Flash_Point_C");
		String Flash_Point_F = Excel_data.get("Flash_Point_F");
		String Segregation_Group = Excel_data.get("Segregation_Group");
		String No_Of_InnerPacking = Excel_data.get("No_Of_InnerPacking");
		String No_Of_OuterPacking = Excel_data.get("No_Of_OuterPacking");
		String Full_Packaging_Code = Excel_data.get("Full_Packaging_Code");

		String Inner_Package_Code_Input = Excel_data.get("Inner_Package_Code_Input");
		String Outer_Package_Code_Input = Excel_data.get("Outer_Package_Code_Input");
		String Outer_Package_Code_Header = Excel_data.get("Outer_Package_Code_Header");
		String Inner_Package_Code_Header = Excel_data.get("Inner_Package_Code_Header");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");

		String DG_No_Type = Excel_data.get("DG_No_Type");
		String terminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");

		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String Details_Checked_Popup = Excel_data.get("Details_Checked_Popup");
		String Search_By_Book_No = Excel_data.get("Search_By_Book_No");	
		String Booking_Module = Excel_data.get("Booking_Module");	
		
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");	
		String Request_Sent_Popup = Excel_data.get("Request_Sent_Popup");	
		String Remarks = Excel_data.get("Remarks");	
		String accepted_popup = Excel_data.get("accepted_popup");	
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String pluginStatus = Excel_data.get("PluginStatus");	
		String Set_Default_Plugin_Status = Excel_data.get("Set_Default_Plugin_Status");	
		String PluginStatus_Default = Excel_data.get("PluginStatus_Default");	
		String arg_party = Excel_data.get("arg_party");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String rate_no = Excel_data.get("rate_no");
		String No_Schedule_Popup = Excel_data.get("No_Schedule_Popup");
		String first_service_data = Excel_data.get("first_service_data");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String globalSearchFilterOption_DG = Excel_data.get("GlobalSearchFilterOption_DG");
		String unNo2 = Excel_data.get("UN_No2");

		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, agencyUser);

		
				
//	Booking 
		
		moduleNavigate(driver, Booking_Module);

		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, arg_party);
		tab(driver);

		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, origin);
		tab(driver);
		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		waitForDisplay(driver, DeliveryInput);

// Rates 	
		bookingRatesSelect(driver, rate_no, No_Schedule_Popup, first_service_data, Voyagenumber1, Boundinput);
		Step_End(4, "Select the Schedule ", test, test1);

		waitForElement(driver, Draft_Button);
		click(driver, Draft_Button);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		waitForElement(driver, popup_Message);
		safeclick(driver, popup_Message_Ok_Button);

		
		waitForElement(driver, master_tab);
		click(driver, master_tab);
		System.out.println("Pinting the Booking number");
		Extent_call(test, test1," Pinting the Booking number ");
		String booknum = getAttribute(driver, booking_no,"value");
		System.out.println(booknum);

		if(!booknum.equals("")) {
			System.out.println("Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number Generated Successfully. The Newly Generated Booking number is : " + booknum);
			Extent_pass_New(driver,"Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number Generated Successfully. The Newly Generated Booking number is : " + booknum, test, test1);
		}else {
			System.out.println("Not Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number is Not Generated");
			Extent_fail(driver,"Not Matched || Expected Result is : Booking Number Shoud be Generate || The Actual Result is : Booking Number is Not Generated", test, test1);
		}

			
//		DG Creation
		
		moduleNavigate(driver, DG_Creation_Module);
		
		newButton(driver);
		
Step_Start(1, "Retrieve the Book number", test, test1);

		
		waitForElement(driver, Booking_No_Search_DG);
		click(driver, Booking_No_Search_DG);
		globalValueSearchWindow(driver, GlobalSearch_Condition, globalSearchFilterOption1, booknum, "", "", "", "");
		
		Step_End(1, "Retrieve the Book number", test, test1);
		Step_Start(2, "Select the unno", test, test1);

		waitForElement(driver, UN_NO_Search_DG);
		click(driver, UN_NO_Search_DG);
	
		twoColumnSearchWindow(driver, UN_Number_Column_Header, Column_condition, unNo);
		
		Step_End(2, "Select the unno", test, test1);
		Step_Start(3, "enter the manadatory details.", test, test1);

		if(!Amendment.equals("")) {
			waitForElement(driver, amendment_Dropdown);
			safeclick(driver, amendment_Dropdown);
			formatLocatorClick(driver, DropDown_Select, Amendment);
			}
		
		if(!Non_Operated_reefer_Dropdown.equals("")) {
		waitForElement(driver, DG_Non_Operated_Reefer);
		safeclick(driver, DG_Non_Operated_Reefer);
		formatLocatorClick(driver, DropDown_Select, Non_Operated_reefer_Dropdown);
		}
		
		waitForElement(driver, Technical_Name_Textfield);
		sendKeys(driver, Technical_Name_Textfield, Technical_Name);
		
		if(!Flash_Point_C.equals("") && !Flash_Point_F.equals("")) {

		waitForElement(driver, DG_Flash_Point_C_Input);
		sendKeys(driver, DG_Flash_Point_C_Input, Flash_Point_C);
		waitForElement(driver, DG_Flash_Point_F_Input);
		sendKeys(driver, DG_Flash_Point_F_Input, Flash_Point_F);
		}
		
		if(!Segregation_Group.equals("")) {

			waitForElement(driver, DG_Flash_Point_C_Input);
			sendKeys(driver, DG_Flash_Point_C_Input, Segregation_Group);
			}
		
		waitForElement(driver, Emergency_Contact_Field1);
		safeclick(driver, Emergency_Contact_Field1);
		sendKeys(driver, Emergency_Contact_Field1, emergencyContactField1);
		
		waitForElement(driver, Emergency_Contact_Field2);
		safeclick(driver, Emergency_Contact_Field2);
		sendKeys(driver, Emergency_Contact_Field2, emergencyContactField2);
		
		waitForElement(driver, Emergency_Contact_Field3);
		safeclick(driver, Emergency_Contact_Field3);
		sendKeys(driver, Emergency_Contact_Field3, emergencyContactField3);
		
		waitForElement(driver, Limited_Quantity);
		safeclick(driver, Limited_Quantity);
		formatLocatorClick(driver, DropDown_Select, Limited_Quantity_Input);
		
		waitForElement(driver, Expected_Quantity);
		safeclick(driver, Expected_Quantity);
		formatLocatorClick(driver, DropDown_Select, Expected_Quantity_Input);

		
		waitForElement(driver,Reported_Quantity);
		safeclick(driver, Reported_Quantity);
		formatLocatorClick(driver, DropDown_Select, Reported_Quantity_Input);

		waitForElement(driver, Waste_Field);
		safeclick(driver, Waste_Field);
		formatLocatorClick(driver, DropDown_Select, Waste_Input);

		waitForElement(driver, marine_Pollutant_Dropdown);
		safeclick(driver, marine_Pollutant_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Marine_Pollutant);

		
		waitForElement(driver, Contact_Name_Field);
		sendKeys(driver, Contact_Name_Field, contactNameField);
		
		waitForElement(driver, Outer_Packing_Search_Button);
		click(driver, Outer_Packing_Search_Button);
		twoColumnSearchWindow(driver, Outer_Package_Code_Header, Column_condition, Outer_Package_Code_Input);
 
		waitForElement(driver, No_Of_Outer);
		safeclick(driver, No_Of_Outer);
		sendKeys(driver, No_Of_Outer, No_Of_OuterPacking);
		
		if(!Inner_Package_Code_Input.equals("")) {
		waitForElement(driver, Inner_Packing_Search_Button);
		click(driver, Inner_Packing_Search_Button);
		twoColumnSearchWindow(driver, Inner_Package_Code_Header, Column_condition, Inner_Package_Code_Input);
		}
		
		waitForElement(driver, No_Of_Inner_Packing_Textfield);
		safeclick(driver, No_Of_Inner_Packing_Textfield);
		sendKeys(driver, No_Of_Inner_Packing_Textfield, No_Of_InnerPacking);
		
		waitForElement(driver, DG_Inner_Packing_Size_Input);
		sendKeys(driver, DG_Inner_Packing_Size_Input, Inner_Packing_Size_Input);
		
		waitForElement(driver, DG_Net_Explosive_Weight);
		sendKeys(driver, DG_Net_Explosive_Weight, Net_Explosive_Weight);
		
		waitForElement(driver, Gross_Wt_Field);
		safeclick(driver, Gross_Wt_Field);
		clearAndType(driver, Gross_Wt_Field, grossWtField);
		safeclick(driver, Gross_Wt_Field);
		waitForElement(driver, Net_Wt_Field);
		safeclick(driver, Net_Wt_Field);
		sendKeys(driver, Net_Wt_Field, netWtField);
		
		waitForElement(driver, Gross_Wt_Field);
		safeclick(driver, Gross_Wt_Field);
		
		if(!Unit_Input_Values.equals("")) {
		waitForElement(driver, DG_Unit_Input);
		safeclick(driver, DG_Unit_Input);
		formatLocatorClick(driver, DropDown_Select, Unit_Input_Values);
		}
		
		if(!Full_Packaging_Code.equals("")) {

			waitForElement(driver, full_Packaging_Code_Textfield);
			sendKeys(driver, full_Packaging_Code_Textfield, Full_Packaging_Code);
			}
		
		scrollUsingElement(driver, Multi_Apply_Btn);
		waitForElement(driver, Multi_Apply_Btn);
		
		Step_End(3, "enter the manadatory details.", test, test1);
		
		Step_Start(4, "click multi apply  button.", test, test1);

		scrollElementToView(driver, Multi_Apply_Btn);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		
		Step_End(4, "click multi apply  button.", test, test1);
		Step_Start(5, "Click save button ", test, test1);

		waitForPopup(driver, popup_Message,Applied_Popup_Exp);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if(Applied_Popup.equals(Applied_Popup_Exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Popup is : " + Applied_Popup_Exp + " || Actual Popup is : " + Applied_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + Applied_Popup_Exp + " || Actual Popup is : " + Applied_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Popup is : " + Applied_Popup_Exp + " || Actual Popup is : " + Applied_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Applied_Popup_Exp + " || Actual Popup is : " + Applied_Popup, test,test1); 
		} 
		
		scrollElementToView(driver, DG_Container_Select);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		
		Step_Start(5, "Click save button", test, test1);

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
		
		Step_End(5, "Click save button ", test, test1);
		Step_Start(6, "Click sent button", test, test1);

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
		
		scrollTop(driver);
		waitForElement(driver, DG_no);
		String generated_DG_Number=getAttribute(driver, DG_no,"value");
		System.out.println(" generated_DG_Number : "+ generated_DG_Number);
		
		if(!generated_DG_Number.equals("")) {
			
			System.out.println("Matched || Expected : DG Number should be generated || Actual : Generated DG Number : "+generated_DG_Number);            
			Extent_pass_New(driver, "Matched || Expected : DG Number should be generated || Actual : Generated DG Number : "+generated_DG_Number, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || Expected : DG Number should be generated || Actual : Generated DG Number : "+generated_DG_Number);        
			Extent_fail(driver, "Not Matched || Expected : DG Number should be generated || Actual : Generated DG Number : "+generated_DG_Number, test,test1);
		}
		
		Step_End(6, "Click sent button", test, test1);
		Step_Start(7, "switch into line Agency", test, test1);
		
		ResetProfile(driver);
		
		Step_End(7,"switch into line agency .", test, test1);

		moduleNavigate(driver, DG_Creation_Module);	

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, GlobalSearch_Condition, DG_No_Type, generated_DG_Number, "", "", "", "");

		scrollElementToView(driver, DG_Container_Select);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		
		Step_Start(8,"click multichecklist", test, test1);

		waitForDisplay(driver, DG_Container_Select);

		scrollElementToView(driver, Multi_ChkList_Btn);
		waitForElement(driver, Multi_ChkList_Btn);
		safeclick(driver, Multi_ChkList_Btn);
		
		waitForPopup(driver, popup_Message,Details_Checked_Popup);
		String actual_Popup = getText(driver, popup_Message);
		System.out.println(actual_Popup);
		if(Details_Checked_Popup.equals(actual_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Popup is : " + Details_Checked_Popup + " || Actual Popup is : " + actual_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + Details_Checked_Popup + " || Actual Popup is : " + actual_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Popup is : " + Details_Checked_Popup + " || Actual Popup is : " + actual_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Details_Checked_Popup + " || Actual Popup is : " + actual_Popup, test,test1); 
		}
		
		Step_End(8,"click multichecklist", test, test1);
		Step_Start(9,"Click Approve button.", test, test1);
		
		waitForElement(driver, DG_Accept_button);
		safeclick(driver, DG_Accept_button);
		
		
		waitForElement(driver, DG_Accept_Remark_Input);
		sendKeys(driver, DG_Accept_Remark_Input, Remarks);
		
		waitForElement(driver, Remarks_Ok);
		safeclick(driver, Remarks_Ok);
		
		waitForPopup(driver, popup_Message, accepted_popup);
		String act_Accepted_Popup = getText(driver, popup_Message);
		if (act_Accepted_Popup.contains(accepted_popup)) {
			System.out.println("Matched || " + " Expected Popup is : " + accepted_popup
					+ " || Actual Popup is : " + act_Accepted_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + accepted_popup
					+ " || Actual Popup is : " + act_Accepted_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : " + accepted_popup
					+ " || Actual Popup is : " + act_Accepted_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + accepted_popup
					+ " || Actual Popup is : " + act_Accepted_Popup, test, test1);
		}
 
		waitForElement(driver, Mail_Cancel_Btn);
		safeclick(driver, Mail_Cancel_Btn);
		
		Step_End(9,"Click Approve button.", test, test1);


		Step_Start(10,"Switch into agency", test, test1);
		SwitchProfile(driver, agencyUser);

// Booking
		
		moduleNavigate(driver, Booking_Module);
		
		Step_End(10,"Switch into agency", test, test1);

		scrollTop(driver);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, GlobalSearch_Condition, Search_By_Book_No, booknum, "", "", "", "");

		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click1(driver, Edit_Button_toolBar);
		

		waitForElement(driver, IMO_tab);
		safeclick(driver, IMO_tab);
		
		waitForElement(driver, Search_Imo_Btn);
		safeclick(driver, Search_Imo_Btn);
		
		waitForElement(driver, AutoMap_Btn);
		safeclick(driver, AutoMap_Btn);
		
		waitForElement(driver, Apply_Btn);
		safeclick(driver, Apply_Btn);
		
		waitForElement(driver, Charges_tab);
		click(driver, Charges_tab);
		waitForElement(driver, AutoRated);
		safeclick(driver, AutoRated);

		waitForElement(driver, master_tab);
		click(driver, master_tab);	
		waitForElement(driver, Confirmed_Button);
		safeclick(driver, Confirmed_Button);
		scrollTop(driver);
		
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		waitForElement(driver, popup_Message);
		safeclick(driver, popup_Message_Ok_Button);
		
		//	Create CRO

		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);

		if(!releaseDepTerminal.equals("")) {
			twoColumnSearchWindow(driver, terminalDetails_Filter, Column_condition, releaseDepTerminal);
		}else {
			twoColumnSearchWindow(driver, terminalDetails_Filter, Column_condition, acc_term_value);
		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
	
		//	Plugin Configuration
	Extent_cal(test, test1, pluginConfigurationModule);
		
		moduleNavigate(driver, pluginConfigurationModule);
				

		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);


			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			scrollTop(driver);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			formatLocatorClick(driver, pluginValue_Select, pluginStatus);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			
			Step_Start(11,"Retrieve the DG number", test, test1);

//			DG Creation
			
			moduleNavigate(driver, DG_Creation_Module);
			
			scrollTop(driver);
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, GlobalSearch_Condition, globalSearchFilterOption_DG, booknum, "", "", "", "");
			
			Step_End(11,"Retrieve the DG number", test, test1);
			Step_Start(12,"edit the grid and makesure the value set in the screen and try to change the unno", test, test1);

			scrollElementToView(driver, DG_Container_Select);
			waitForElement(driver, DG_Container_Select);
			safeclick(driver, DG_Container_Select);

			waitForElement(driver, Grid_Edit_Icon);
			safeclick(driver, Grid_Edit_Icon);

			scrollTop(driver);
			waitForElement(driver, UN_NO_Search_DG);
			click(driver, UN_NO_Search_DG);
		
			twoColumnSearchWindow(driver, UN_Number_Column_Header, Column_condition, unNo2);

			waitForElement(driver, DG_UN_No_Textfield);
			String edited_UNNO=getAttribute(driver, DG_UN_No_Textfield, "value");
			
			if(edited_UNNO.equals(unNo2)) {                                                                                                                  
				System.out.println("Matched || " + " Expected UNNO is : " + unNo2 + " || Actual UNNO is : " + edited_UNNO);            
				Extent_pass_New(driver, "Matched || " + " Expected UNNO is: " + unNo2 + " || Actual UNNO is : " + edited_UNNO, test,test1);     
				
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected UNNO is : " + unNo2 + " || Actual UNNO is : " + edited_UNNO);        
				Extent_fail(driver, "Not Matched || " + " Expected UNNO is : " + unNo2 + " || Actual UNNO is : " + edited_UNNO, test,test1); 
			} 
			
			Step_End(12,"edit the grid and makesure the value set in the screen and try to change the unno", test, test1);

			
		if(Set_Default_Plugin_Status.equalsIgnoreCase("Yes")) {
//			Plugin Configuration
				Extent_cal(test, test1, "Plugin Configuration");
				
				moduleNavigate(driver, pluginConfigurationModule);
						
				waitForElement(driver, pluginIdFilter_Searchbox);
				sendKeys(driver, pluginIdFilter_Searchbox, pluginID);
				waitForElement(driver, moduleIdFilter_Searchbox);
				sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

				waitForElement(driver, searched_pluginId);


					doubleClick(driver, searched_pluginId);
					waitForElement(driver, Edit_Button_toolBar);
					scrollTop(driver);
					click(driver, Edit_Button_toolBar);

					waitForElement(driver, enable_Status_Dropdown);
					click(driver, enable_Status_Dropdown);

					formatLocatorClick(driver, pluginValue_Select, PluginStatus_Default);
					scrollTop(driver);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);
			}
		Extent_completed(testCaseName, test, test1);
	}

}
