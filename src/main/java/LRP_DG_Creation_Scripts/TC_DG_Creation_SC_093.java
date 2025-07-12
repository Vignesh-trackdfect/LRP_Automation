package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_093 extends Keywords {
	
	public void DG_Creation_SC_093(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_093";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
		String Excel_File_Path = Excel_data.get("Excel_File_Path");
		String Exp_File_upload_popup = Excel_data.get("Exp_File_upload_popup");
		String Request_Sent_Popup = Excel_data.get("Request_Sent_Popup");
		String PluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String PluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String PluginStatus = Excel_data.get("PluginStatus");		
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");
		String Remarks = Excel_data.get("Remarks");
		String Exp_partial_accept_popup = Excel_data.get("Exp_partial_accept_popup");
		
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
				Extent_pass_New(driver, "Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			} else {
				System.out.println("Not Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup);
				Extent_fail(driver, "Not Matched || Expected popup: " + pluginUpdatedPopup + "|| Actual Popup:" + actualUpdatedPopup, test,test1);
			}
		}else {
			System.out.println(PluginID+" plugin ID is unavailable");
			Extent_fail(driver, PluginID+" plugin ID is unavailable", test,test1);
		}
		
		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		moduleNavigate(driver, DG_Creation_Module);

		newButton(driver);

		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_Start(4, "click multi apply  button", test, test1);
		scrollElementToView(driver, Multi_Apply_Btn);
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
		scrollElementToView(driver, DG_Container_Select);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		Step_Start(5, "Click save button ", test, test1);
		waitForElement(driver, DG_Save_Btn);
		safeclick(driver, DG_Save_Btn);

		waitForPopup(driver, popup_Message, Details_Saved_Popup);
		String Saved_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Saved_Popup.equals(Details_Saved_Popup)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Details_Saved_Popup+ " || Actual Report Activity is : " + Saved_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Details_Saved_Popup+ " || Actual Report Activity is : " + Saved_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup
					+ " || Actual Report Activity is : " + Saved_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup
					+ " || Actual Report Activity is : " + Saved_Popup, test, test1);
		}
		Step_End(5, "Click save button ", test, test1);
		
		Step_Start(6, "Click file upload and upload the file. ", test, test1);

		uploadfile_new(driver, File_Chooser, Excel_File_Path);
		
		waitForPopup(driver, popup_Message, Exp_File_upload_popup);
		String Act_File_upload_popup =getText(driver, popup_Message);
		if(Act_File_upload_popup.equals(Exp_File_upload_popup)) {
			System.out.println("Matched || Expected: File uploaded popup message should be displayed: " + Details_Saved_Popup + " || Actual: File uploaded popup message is displayed: " + Saved_Popup);
			Extent_pass_New(driver, "Matched || Expected: File uploaded popup message should be displayed: " + Details_Saved_Popup + " || Actual: File uploaded popup message is displayed: " + Saved_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected: File uploaded popup message should be displayed: " + Details_Saved_Popup + " || Actual: File uploaded popup message is NOt  displayed: " + Saved_Popup);
			Extent_fail(driver, "Not Matched || Expected: File uploaded popup message should be displayed: " + Details_Saved_Popup + " || Actual: File uploaded popup message is Not displayed: " + Saved_Popup, test, test1);
		}
		
		
		waitForElement(driver, File_Upload_Name_text);
		String Act_File_name =getText(driver, File_Upload_Name_text);
		
		if(Excel_File_Path.equals(Act_File_name)) {
			
			System.out.println("Matched || Expected: File uploaded Name should be displayed: " + Excel_File_Path + " || Actual: File uploaded Name is displayed: " + Act_File_name);
			Extent_pass_New(driver, "Matched || Expected: File uploaded Name should be displayed: " + Excel_File_Path + " || Actual: File uploaded Name is displayed: " + Act_File_name, test, test1);
		}else {
			System.out.println("Not Matched || Expected: File uploaded Name should be displayed: " + Excel_File_Path + " || Actual: File uploaded Name is Not displayed: " + Act_File_name);
			Extent_fail(driver, "Not Matched || Expected: File uploaded Name should be displayed: " + Excel_File_Path + " || Actual: File uploaded Name is Not displayed: " + Act_File_name, test, test1);
		}
		
		
		Step_End(6, "Click file upload and upload the file. ", test, test1);
		
		Step_Start(7, "click Sent button ", test, test1);
		
		
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
		Step_End(7, "Click sent button.", test, test1);
		
		
		
		if(isdisplayed(driver, DG_Accept_Remark_Input)) {
			
		sendKeys(driver, DG_Accept_Remark_Input, Remarks);
		
		waitForElement(driver, Rejected_Remarks_Ok_Button);
		click(driver, Rejected_Remarks_Ok_Button);
		
		waitForPopup(driver, popup_Message, Exp_partial_accept_popup);
		String act_Popup1 = getText(driver, popup_Message);
		System.out.println(act_Popup1);
		if (act_Popup1.contains(Exp_partial_accept_popup)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1, test, test1);
		}
		
	}
		
		waitForElement(driver, DG_Mail_Attachment_input);
		
		if(isEmpty(driver, DG_Mail_Attachment_input)) {
			
			System.out.println("Matched || Expected: ADM = false — when clicking the 'Send' button, the file should not be attached in the DG mail template || Actual: DM = false — when clicking the 'Send' button, the file is not attached in the DG mail template");
			Extent_pass_New(driver, "Matched || Expected: ADM = false — when clicking the 'Send' button, the file should not be attached in the DG mail template || Actual: DM = false — when clicking the 'Send' button, the file is not attached in the DG mail template", test, test1);
			
		}else {
			
			System.out.println("Not Matched || Expected: ADM = false — when clicking the 'Send' button, the file should  be attached in the DG mail template || Actual: DM = false — when clicking the 'Send' button, the file is  attached in the DG mail template");
			Extent_fail(driver, "Not Matched || Expected: ADM = false — when clicking the 'Send' button, the file should  be attached in the DG mail template || Actual: DM = false — when clicking the 'Send' button, the file is  attached in the DG mail template", test, test1);
		
		}
	
		Extent_completed(testCaseName, test, test1);
		
		
		
	

}
}