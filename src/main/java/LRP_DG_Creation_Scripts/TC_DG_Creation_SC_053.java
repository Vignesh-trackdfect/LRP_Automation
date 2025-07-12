package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_053 extends Keywords{

	public void DG_Creation_SC_053(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_053";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Plugin_Module = Excel_data.get("Plugin_Module");
		String PluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String PluginStatus = Excel_data.get("PluginStatus");		
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String flash_Point_Input = Excel_data.get("flash_Point_Input");
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		SwitchProfile(driver, AgencyUser);
		
		moduleNavigate(driver, Plugin_Module);
	
		waitForElement(driver, pluginIdFilter_Searchbox);
		sendKeys(driver, pluginIdFilter_Searchbox, PluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, moduleID);

		waitForElement(driver, searched_pluginId);

			doubleClick(driver, searched_pluginId);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForElement(driver, enable_Status_Dropdown);
			click(driver, enable_Status_Dropdown);

			formatLocatorClick(driver, pluginValue_Select, PluginStatus);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		moduleNavigate(driver, DG_Creation_Module);	

		newButton(driver);

		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_Start(4, "flashpoint editable", test, test1);
		
		waitForElement(driver, Flash_Point_TF);
		if(isClickable(driver, Flash_Point_TF)) {
			System.out.println("Expected Result : Flash Point field should be Editable || Actual Result is : Flash point field is Editable");
			Extent_pass_New(driver, "Expected Result : Flash Point field should be Editable || Actual Result is : Flash point field is Editable", test, test1);
		       sendKeys(driver, Flash_Point_TF, flash_Point_Input);

		}else {
		System.out.println("Expected Result : Flash Point field should be Editable || Actual Result is : Flash point field is not Editable");
		Extent_fail(driver, "Expected Result : Flash Point field should be Editable || Actual Result is : Flash point field is not Editable", test, test1);
		}
		
		Step_End(4, "flashpoint editable", test, test1);
		
		scrollBottom(driver);
		Step_Start(5, "click multi apply  button", test, test1);
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

		Step_End(5, "click multi apply  button", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
