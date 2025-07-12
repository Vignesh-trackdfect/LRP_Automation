package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_057 extends Keywords{
	
	public void DG_Creation_SC_057(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_057";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String PluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String PluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String PluginStatus = Excel_data.get("PluginStatus");		
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");
		String Gross_Net_Popup_Exp = Excel_data.get("Gross_Net_Popup_Exp");
		
		
		
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
		Step_Start(4, "enter net weight greater than gross weight", test, test1);

		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_End(4, "enter net weight greater than gross weight", test, test1);
		
		Step_Start(5, "click multi apply  button", test, test1);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		
		
		waitForPopup(driver, popup_Message, Gross_Net_Popup_Exp);
		String Actual_Popup = getText(driver, popup_Message);
	
		if (Gross_Net_Popup_Exp.equals(Gross_Net_Popup_Exp)) {
			System.out.println("Matched || Expected popup : "+ Gross_Net_Popup_Exp + " || Actual popup : " + Actual_Popup);
			Extent_pass_New(driver, "Matched || Expected popup : "+ Gross_Net_Popup_Exp + " || Actual popup : " + Actual_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected popup : "+ Gross_Net_Popup_Exp + " || Actual popup : " + Actual_Popup);
			Extent_fail(driver, "Not Matched || Expected popup : "+ Gross_Net_Popup_Exp + " || Actual popup : " + Actual_Popup, test, test1);
		}

		Step_End(5, "click multi apply  button", test, test1);
		
		
		Extent_completed(testCaseName, test, test1);		
		

}
}