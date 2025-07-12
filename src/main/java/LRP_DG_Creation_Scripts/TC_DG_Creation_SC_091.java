package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_091 extends Keywords {
	
	public void DG_Creation_SC_091(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_091";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");
		String GlobalConfiguration_Module = Excel_data.get("GlobalConfiguration_Module");
		String Global_ID = Excel_data.get("Global_ID");
		String Default_Global_Value = Excel_data.get("Default_Global_Value");
		String Global_Value = Excel_data.get("Global_Value");
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
		String Request_Sent_Popup = Excel_data.get("Request_Sent_Popup");
		String pluginStatus2 = Excel_data.get("PluginStatus2");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");	
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String PluginID2 = Excel_data.get("PluginID2");
		String PluginID3 = Excel_data.get("PluginID3");
		String pluginID2 = Excel_data.get("PluginID2");
		String pluginID3 = Excel_data.get("PluginID3");
		String moduleID = Excel_data.get("ModuleID");
		String PluginStatus_Default2 = Excel_data.get("PluginStatus_Default2");
		String pluginStatus = Excel_data.get("PluginStatus");
		String PluginStatus_Default3 = Excel_data.get("PluginStatus_Default3");
		String Set_Default_Plugin_Status = Excel_data.get("Set_Default_Plugin_Status");	
		String PluginStatus_Default = Excel_data.get("PluginStatus_Default");	
		String Set_Default_Plugin_Status2 = Excel_data.get("Set_Default_Plugin_Status2");	
		String Set_Default_Plugin_Status3 = Excel_data.get("Set_Default_Plugin_Status3");	
		String Set_Default_Global_Value = Excel_data.get("Set_Default_Global_Value");	
		String Remarks = Excel_data.get("Remarks");	
		String DG_No_Type = Excel_data.get("DG_No_Type");	
		String Exp_partial_accept_popup = Excel_data.get("Exp_partial_accept_popup");	
		String Details_Checked_Popup = Excel_data.get("Details_Checked_Popup");	
		
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
			
			waitForElement(driver, pluginIdFilter_Searchbox);
			sendKeys(driver, pluginIdFilter_Searchbox, pluginID2);
			waitForElement(driver, moduleIdFilter_Searchbox);
			sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

			waitForElement(driver, searched_pluginId);


				doubleClick(driver, searched_pluginId);
				waitForElement(driver, Edit_Button_toolBar);
				scrollTop(driver);
				click(driver, Edit_Button_toolBar);

				waitForElement(driver, enable_Status_Dropdown);
				click(driver, enable_Status_Dropdown);

				formatLocatorClick(driver, pluginValue_Select, pluginStatus2);
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				
				waitForElement(driver, pluginIdFilter_Searchbox);
				sendKeys(driver, pluginIdFilter_Searchbox, pluginID3);
				waitForElement(driver, moduleIdFilter_Searchbox);
				sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

				waitForElement(driver, searched_pluginId);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			setGlobalConfiguration(driver, GlobalConfiguration_Module, Global_ID, Global_Value);
//		Module Search

			moduleNavigate(driver, DG_Creation_Module);

			newButton(driver);
			
			DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
			input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
			
			Step_Start(4, "click multi apply  button.", test, test1);

			waitForElement(driver, Multi_Apply_Btn);
			safeclick(driver, Multi_Apply_Btn);
			
			Step_End(4, "click multi apply  button.", test, test1);

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
			
			Step_End(4, "click multi apply  button.", test, test1);
			Step_Start(5, "Click save button", test, test1);
	 
			waitForElement(driver, DG_Save_Btn);
			safeclick(driver, DG_Save_Btn);
			waitForPopup(driver, popup_Message,Details_Saved_Popup);
			String Saved_Popup = getText(driver, popup_Message);
			System.out.println(Applied_Popup);
			if(Saved_Popup.equals(Details_Saved_Popup)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Popup is : " + Details_Saved_Popup + " || Actual Popup is : " + Saved_Popup);            
				Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + Details_Saved_Popup + " || Actual Popup is : " + Saved_Popup, test,test1);     
				safeclick(driver, popup_Message_Ok_Button);
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Popup is : " + Details_Saved_Popup + " || Actual Popup is : " + Saved_Popup);        
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Details_Saved_Popup + " || Actual Popup is : " + Saved_Popup, test,test1);
			}
			
			Step_End(5, "Click save button", test, test1);
			Step_Start(6, "Click sent button.", test, test1);
	 
			waitForElement(driver, Send_Btn);
			safeclick(driver, Send_Btn);
			
			waitForPopup(driver, popup_Message,Request_Sent_Popup);
			String act_Popup = getText(driver, popup_Message);
			System.out.println(act_Popup);
			if(act_Popup.equals(Request_Sent_Popup)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Popup is : " + Request_Sent_Popup + " || Actual Popup is : " + act_Popup);            
				Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + Request_Sent_Popup + " || Actual Popup is : " + act_Popup, test,test1);     
				safeclick(driver, popup_Message_Ok_Button);
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Popup is : " + Request_Sent_Popup + " || Actual Popup is : " + act_Popup);        
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Request_Sent_Popup + " || Actual Popup is : " + act_Popup, test,test1);
			}
			
			
			Step_End(6, "Click sent button.", test, test1);
			
			waitForElement(driver, Mail_Cancel_Btn);
			safeclick(driver, Mail_Cancel_Btn);
			
			scrollTop(driver);
			waitForElement(driver, DG_no);
			String generated_DG_Number=getAttribute(driver, DG_no,"value");
			System.out.println(" generated_DG_Number : "+ generated_DG_Number);
			
			Step_Start(7, "switch into line Agency", test, test1);		
			
			ResetProfile(driver);
			Step_End(7, "switch into line agency", test, test1);
			
			Step_Start(8, "click multichecklist", test, test1);
			
			moduleNavigate(driver, DG_Creation_Module);
			
			scrollTop(driver);
			
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			
	       globalValueSearchWindow(driver, GlobalSearch_Condition, DG_No_Type, generated_DG_Number, "", "", "", "");
			
			scrollBottom(driver);
			
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
			
			Step_End(8, "click multichecklist", test, test1);	
			
			Step_Start(9, "Click Approve button.", test, test1);
			
			waitForElement(driver, DG_Accept_button);
			safeclick(driver, DG_Accept_button);
			
			waitForElement(driver, DG_Accept_Remark_Input);
			sendKeys(driver, DG_Accept_Remark_Input, Remarks);
			
			waitForElement(driver, Rejected_Remarks_Ok_Button);
			click(driver, Rejected_Remarks_Ok_Button);
			
			waitForPopup(driver, popup_Message, Exp_partial_accept_popup);
			String act_Popup1 = getText(driver, popup_Message);
			System.out.println(act_Popup1);
			if (act_Popup1.contains(Exp_partial_accept_popup)) {
				System.out.println("Matched || Expected: When EMf is TRUE, sdg is FALSE, and ADG = N, the system should follow the manual process: "  + Exp_partial_accept_popup + " || Actual: The system followed the manual process: " + act_Popup1);
				Extent_pass_New(driver, "Matched || Expected: When EMf is TRUE, sdg is FALSE, and ADG = N, the system should follow the manual process: "  + Exp_partial_accept_popup + " || Actual: The system followed the manual process: " + act_Popup1, test, test1);
				safeclick(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not Matched || Expected: When EMf is TRUE, sdg is FALSE, and ADG = N, the system should follow the manual process: "  + Exp_partial_accept_popup + " || Actual: The system not followed the manual process: " + act_Popup1);
				Extent_fail(driver, "Not Matched || Expected: When EMf is TRUE, sdg is FALSE, and ADG = N, the system should follow the manual process: "  + Exp_partial_accept_popup + " || Actual: The system not followed the manual process: " + act_Popup1, test, test1);
			}
			
			
			waitForElement(driver, Mail_Cancel_Btn);
			safeclick(driver, Mail_Cancel_Btn);
			
			Step_End(9, "Click Approve button.", test, test1);

		
		if(Set_Default_Plugin_Status.equalsIgnoreCase("Yes")) {
//		Plugin Configuration
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

				formatLocatorClick(driver, pluginValue_Select, PluginStatus_Default);
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
		}
		
		if(Set_Default_Plugin_Status2.equalsIgnoreCase("Yes")) {
//			Plugin Configuration
				Extent_cal(test, test1, "Plugin Configuration");
						
				Extent_cal(test, test1, pluginConfigurationModule);

				waitForElement(driver, pluginIdFilter_Searchbox);
				sendKeys(driver, pluginIdFilter_Searchbox, PluginID2);
				waitForElement(driver, moduleIdFilter_Searchbox);
				sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

				waitForElement(driver, searched_pluginId);

					doubleClick(driver, searched_pluginId);
					waitForElement(driver, Edit_Button_toolBar);
					scrollTop(driver);
					click(driver, Edit_Button_toolBar);

					waitForElement(driver, enable_Status_Dropdown);
					click(driver, enable_Status_Dropdown);

					formatLocatorClick(driver, pluginValue_Select, PluginStatus_Default2);
					scrollTop(driver);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);
			}
		
		if(Set_Default_Plugin_Status3.equalsIgnoreCase("Yes")) {
//			Plugin Configuration
				Extent_cal(test, test1, "Plugin Configuration");
				
						
				Extent_cal(test, test1, pluginConfigurationModule);

				waitForElement(driver, pluginIdFilter_Searchbox);
				sendKeys(driver, pluginIdFilter_Searchbox, PluginID3);
				waitForElement(driver, moduleIdFilter_Searchbox);
				sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

				waitForElement(driver, searched_pluginId);


					doubleClick(driver, searched_pluginId);
					waitForElement(driver, Edit_Button_toolBar);
					scrollTop(driver);
					click(driver, Edit_Button_toolBar);

					waitForElement(driver, enable_Status_Dropdown);
					click(driver, enable_Status_Dropdown);

					formatLocatorClick(driver, pluginValue_Select, PluginStatus_Default3);
					scrollTop(driver);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);
			}
		
		reSetGlobalConfiguration(driver,Set_Default_Global_Value, GlobalConfiguration_Module, Global_ID, Default_Global_Value);

		Extent_completed(testCaseName, test, test1);
	}


}
