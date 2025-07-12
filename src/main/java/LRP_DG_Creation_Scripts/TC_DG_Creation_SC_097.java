package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_097 extends Keywords {


	public void DG_Creation_SC_097(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_097";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");

		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String DG_No_Type = Excel_data.get("DG_No_Type");

		String booking_number = Excel_data.get("Booking_No_Input");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
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
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, agencyUser);

		//	Plugin Configuration
		Extent_cal(test, test1, "Plugin Configuration");
		
		moduleNavigate(driver, pluginConfigurationModule);
				
		Extent_cal(test, test1, pluginConfigurationModule);

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

//		Module Search
		
		moduleNavigate(driver, DG_Creation_Module);
		
		newButton(driver);
		
		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
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

		SwitchProfile(driver, agencyUser);

		Step_Start(10,"Open the Booking module", test, test1);

		moduleNavigate(driver, Booking_Module);
		
		Step_End(10,"Open the Booking module", test, test1);
		Step_Start(11,"DG Details attached in the booking imo tab.", test, test1);

		scrollTop(driver);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, GlobalSearch_Condition, Search_By_Book_No, booking_number, "", "", "", "");

		waitForElement(driver, IMO_tab);
		safeclick(driver, IMO_tab);
		
		if(verifyElementHasNoText(driver, IMO_Tab_Row)) {
			System.out.println("Matched || Expected : DG Details should not be added in IMO Tab Grid || Actual :  DG Details are not added in IMO Tab Grid ");
			Extent_pass_New(driver, "Matched || Expected : DG Details should not be added in IMO Tab Grid || Actual :  DG Details are not added in IMO Tab Grid ", test, test1);
		} else {
			System.out.println("Not Matched || Expected : DG Details should not be added in IMO Tab Grid || Actual :  DG Details are added in IMO Tab Grid ");
			Extent_fail(driver, "Not Matched || Expected : DG Details should not be added in IMO Tab Grid || Actual :  DG Details are added in IMO Tab Grid ", test, test1);
		}
		
		Step_End(11,"DG Details attached in the booking imo tab.", test, test1);

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
