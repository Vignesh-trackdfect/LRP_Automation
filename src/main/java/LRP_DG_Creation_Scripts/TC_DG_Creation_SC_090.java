package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_090 extends Keywords {


	public void DG_Creation_SC_090(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_090";
		
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
		String pluginStatus3 = Excel_data.get("PluginStatus3");
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
		String accepted_popup = Excel_data.get("accepted_popup");	
		String Cargo_Status = Excel_data.get("Cargo_Status");	
		
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
			scrollElementToView(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			formatLocatorClick(driver, pluginValue_Select, pluginStatus);
			scrollElementToView(driver, SaveButton_ToolBar);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForElement(driver, pluginIdFilter_Searchbox);
			sendKeys(driver, pluginIdFilter_Searchbox, pluginID2);
			waitForElement(driver, moduleIdFilter_Searchbox);
			sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

			waitForElement(driver, searched_pluginId);


				doubleClick(driver, searched_pluginId);
				waitForElement(driver, Edit_Button_toolBar);
				scrollElementToView(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);

				waitForElement(driver, enable_Status_Dropdown);
				click(driver, enable_Status_Dropdown);

				formatLocatorClick(driver, pluginValue_Select, pluginStatus2);
				scrollElementToView(driver, SaveButton_ToolBar);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				
				waitForElement(driver, pluginIdFilter_Searchbox);
				sendKeys(driver, pluginIdFilter_Searchbox, pluginID3);
				waitForElement(driver, moduleIdFilter_Searchbox);
				sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

				waitForElement(driver, searched_pluginId);


					doubleClick(driver, searched_pluginId);
					waitForElement(driver, Edit_Button_toolBar);
					scrollElementToView(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);

					waitForElement(driver, enable_Status_Dropdown);
					click(driver, enable_Status_Dropdown);

					formatLocatorClick(driver, pluginValue_Select, pluginStatus3);
					scrollElementToView(driver, SaveButton_ToolBar);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);
				
			
			scrollElementToView(driver, Close_Current_tab);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			setGlobalConfiguration(driver, GlobalConfiguration_Module, Global_ID, Global_Value);
			
			
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
			
			
			waitForElement(driver, DG_Accept_Remark_Input);
			sendKeys(driver, DG_Accept_Remark_Input, Remarks);
			
			waitForElement(driver, Remarks_Ok);
			safeclick(driver, Remarks_Ok);
			
			waitForPopup(driver, popup_Message, accepted_popup);
			String act_Accepted_Popup = getText(driver, popup_Message);
			if (act_Accepted_Popup.contains(accepted_popup)) {
				System.out.println("Matched || " + " Expected Report Activity is : " + accepted_popup
						+ " || Actual Report Activity is : " + act_Accepted_Popup);
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + accepted_popup
						+ " || Actual Report Activity is : " + act_Accepted_Popup, test, test1);
				safeclick(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not Matched || " + " Expected Report Activity is : " + accepted_popup
						+ " || Actual Report Activity is : " + act_Accepted_Popup);
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + accepted_popup
						+ " || Actual Report Activity is : " + act_Accepted_Popup, test, test1);
			}
			
			
			waitForElement(driver, Mail_Cancel_Btn);
			safeclick(driver, Mail_Cancel_Btn);
			
			waitForElement(driver, cargo_Status);
			String actualCargoStatus=getText(driver, cargo_Status);
			System.out.println(" actualCargoStatus : "+ actualCargoStatus);

			if(actualCargoStatus.equals(Cargo_Status)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Cargo status is : " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus);            
				Extent_pass_New(driver, "Matched || " + " Expected Cargo status is: " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Cargo status is : " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus);        
				Extent_fail(driver, "Not Matched || " + " Expected Cargo status is : " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus, test,test1); 
			}
			
			Step_End(6, "Click sent button.", test, test1);

		
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
				scrollElementToView(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);

				waitForElement(driver, enable_Status_Dropdown);
				click(driver, enable_Status_Dropdown);

				formatLocatorClick(driver, pluginValue_Select, PluginStatus_Default);
				scrollElementToView(driver, SaveButton_ToolBar);
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
					scrollElementToView(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);

					waitForElement(driver, enable_Status_Dropdown);
					click(driver, enable_Status_Dropdown);

					formatLocatorClick(driver, pluginValue_Select, PluginStatus_Default2);
					scrollElementToView(driver, SaveButton_ToolBar);
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
					scrollElementToView(driver, Edit_Button_toolBar);
					click(driver, Edit_Button_toolBar);

					waitForElement(driver, enable_Status_Dropdown);
					click(driver, enable_Status_Dropdown);

					formatLocatorClick(driver, pluginValue_Select, PluginStatus_Default3);
					scrollElementToView(driver, SaveButton_ToolBar);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);
			}
		
		reSetGlobalConfiguration(driver,Set_Default_Global_Value, GlobalConfiguration_Module, Global_ID, Default_Global_Value);

		Extent_completed(testCaseName, test, test1);
	}

}
