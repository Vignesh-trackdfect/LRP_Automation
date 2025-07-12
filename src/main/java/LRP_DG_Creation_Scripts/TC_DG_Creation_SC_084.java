package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_084 extends Keywords {


	public void DG_Creation_SC_084(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_084";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");

		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");	
		String Certificate_Popup = Excel_data.get("Certificate_Popup");	
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");	

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
			
		Step_Start(1, "Open the DG module", test, test1);

		moduleNavigate(driver, DG_Creation_Module);
		
		Step_End(1, "Open the DG module", test, test1);
		Step_Start(2, "make sure   DG Certificate  button disable  followed by", test, test1);

		newButton(driver);
		Step_Start(5, "enter the manadatory details except DG certificate. ", test, test1);

		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_End(5, "enter the manadatory details except DG certificate. ", test, test1);
		Step_Start(6, "click multi apply  button.", test, test1);

		scrollElementToView(driver, Multi_Apply_Btn);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		
		
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
		
		Step_End(6, "click multi apply  button.", test, test1);
		Step_Start(7, "Click save button ", test, test1);

		
		scrollElementToView(driver, DG_Container_Select);
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
		Step_End(7, "Click save button", test, test1);

		Step_Start(8, "Click sent button", test, test1);

		waitForElement(driver, Send_Btn);
		safeclick(driver, Send_Btn);
		
		waitForPopup(driver, popup_Message,Certificate_Popup);
		String act_Popup = getText(driver, popup_Message);
		System.out.println(act_Popup);
		if(act_Popup.equals(Certificate_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Certificate_Popup + " || Actual Report Activity is : " + act_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Certificate_Popup + " || Actual Report Activity is : " + act_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Certificate_Popup + " || Actual Report Activity is : " + act_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Certificate_Popup + " || Actual Report Activity is : " + act_Popup, test,test1); 
		}
		
		Step_End(8, "Click sent button", test, test1);
		
		Step_End(2, "make sure   DG Certificate  button disable  followed by", test, test1);

		
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
		
		Extent_completed(testCaseName, test, test1);
	}

}
