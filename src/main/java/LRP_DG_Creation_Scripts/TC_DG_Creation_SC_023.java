package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_023 extends Keywords{
	public void DG_Creation_SC_023(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_023";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
		String Request_Sent_Popup = Excel_data.get("Request_Sent_Popup");
		String PluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String PluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String PluginStatus = Excel_data.get("PluginStatus");		
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");	
		String DG_EXP_Pop = Excel_data.get("DG_EXP_Pop");	
		String Exp_Accept_Popup = Excel_data.get("Exp_Accept_Popup");	
		String Set_Default_Plugin_Status = Excel_data.get("Set_Default_Plugin_Status");	
		String PluginStatus_Default = Excel_data.get("PluginStatus_Default");	
		String DG_No_Type = Excel_data.get("DG_No_Type");	


		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		SwitchProfile(driver, AgencyUser);
		
         moduleNavigate(driver, PluginConfigurationModule);
		
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, PluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);
		String actualPluginID=getText(driver, searched_pluginId);

		if(actualPluginID.equals(PluginID)){
			Extent_pass_New(driver, PluginID+" plugin ID is available", test,test1);
			System.out.println(PluginID+" plugin ID is available");

			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			formatLocatorClick(driver, pluginValue_Select, PluginStatus);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForElement(driver, Popup_Message);
			String actualUpdatedPopup=getText(driver, Popup_Message);
			System.out.println("actualUpdatedPopup:"+actualUpdatedPopup);
			if(actualUpdatedPopup.contains(pluginUpdatedPopup)){
				System.out.println("Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
				Extent_pass(driver, "Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			} else {
				System.out.println("Not Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
				Extent_fail(driver, "Not Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			}
		}else {
			System.out.println(PluginID+" plugin ID is unavailable");
			Extent_fail(driver, PluginID+" plugin ID is unavailable", test,test1);
		}
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		

		moduleNavigate(driver, DG_Creation_Module);

		newButton(driver);

		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_Start(4, "click multi apply  button", test, test1);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		waitForPopup(driver, popup_Message, Applied_Popup_Exp);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(Applied_Popup_Exp)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup, test, test1);
		}

		Step_End(4, "click multi apply  button", test, test1);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		Step_Start(5, "Click save button ", test, test1);
		waitForElement(driver, DG_Save_Btn);
		safeclick(driver, DG_Save_Btn);

		waitForPopup(driver, popup_Message, Details_Saved_Popup);
		String Saved_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Saved_Popup.equals(Details_Saved_Popup)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Details_Saved_Popup
					+ " || Actual Report Activity is : " + Saved_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Details_Saved_Popup
					+ " || Actual Report Activity is : " + Saved_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup
					+ " || Actual Report Activity is : " + Saved_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup
					+ " || Actual Report Activity is : " + Saved_Popup, test, test1);
		}
		
		
		Step_End(5, "Click save button ", test, test1);

		Step_Start(6, "Click sent button.", test, test1);

		waitForElement(driver, Send_Btn);
		safeclick(driver, Send_Btn);
		
		waitForPopup(driver, popup_Message, Request_Sent_Popup);
		String act_Popup = getText(driver, popup_Message);
		System.out.println(act_Popup);
		if (act_Popup.equals(Request_Sent_Popup)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Request_Sent_Popup
					+ " || Actual Report Activity is : " + act_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Request_Sent_Popup
					+ " || Actual Report Activity is : " + act_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Request_Sent_Popup
					+ " || Actual Report Activity is : " + act_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Request_Sent_Popup
					+ " || Actual Report Activity is : " + act_Popup, test, test1);
		}
		Step_End(6, "Click sent button.", test, test1);
		

		
		waitForElement(driver, Mail_Cancel_Btn);
		safeclick(driver, Mail_Cancel_Btn);
		
		waitForElement(driver, DGC_Dg_Validation);
		click(driver, DGC_Dg_Validation);
		
		waitForPopup(driver, popup_Message, DG_EXP_Pop);
		String DG_Popup =getText(driver, popup_Message);
		
		if(DG_Popup.equals(DG_EXP_Pop)) {
			
			System.out.println("Matched || " + " Expected DG Validation should be : " + Request_Sent_Popup+ " || Actual DG Validation  is : " + act_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected DG Validation should be : " + Request_Sent_Popup+ " || Actual DG Validation  is : " + act_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
			
		}else {
			
			System.out.println("Not Matched || " + " Expected DG Validation should be : " + Request_Sent_Popup+ " || Actual DG Validation  is : " + act_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected DG Validation should be : " + Request_Sent_Popup+ " || Actual DG Validation  is : " + act_Popup, test, test1);
			
		}
		
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
		ResetProfile(driver);
		
		
		moduleNavigate(driver, DG_Creation_Module);
		Step_Start(7, "click approve button", test, test1);	
		scrollTop(driver);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, GlobalSearch_Condition, DG_No_Type, generated_DG_Number, "", "", "", "");
		
	    scrollBottom(driver);
	   
	    waitForElement(driver, DG_Accept_button);
		click(driver, DG_Accept_button);
		
		waitForPopup(driver, popup_Message, Exp_Accept_Popup);
		String Act_accept_popup =getText(driver, popup_Message);
		
           if(Act_accept_popup.equals(Exp_Accept_Popup)) {
			
			System.out.println("Matched || " + " Expected Accept value should be : " + Exp_Accept_Popup+ " || Actual Accept value  is : " + Act_accept_popup);
			Extent_pass_New(driver, "Matched || " + " Expected Accept value should be : " + Exp_Accept_Popup+ " || Actual Accept value  is : " + Act_accept_popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
			
		}else {
			
			System.out.println("Not Matched || " + "  Expected Accept value should be : " + Exp_Accept_Popup+ " || Actual Accept value  is : " + Act_accept_popup);
			Extent_fail(driver, "Not Matched || " + " Expected Accept value should be : " + Exp_Accept_Popup+ " || Actual Accept value  is : " + Act_accept_popup, test, test1);
			
		}
		
           Step_End(7, "click approve button", test, test1);		
		
       	if(Set_Default_Plugin_Status.equalsIgnoreCase("Yes")) {
//    		Plugin Configuration
    			
    			moduleNavigate(driver, PluginConfigurationModule);
    					
    			Extent_cal(test, test1, PluginConfigurationModule);

    			waitForElement(driver, pluginIdFilter_Searchbox);
    			sendKeys(driver, pluginIdFilter_Searchbox, PluginID);
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