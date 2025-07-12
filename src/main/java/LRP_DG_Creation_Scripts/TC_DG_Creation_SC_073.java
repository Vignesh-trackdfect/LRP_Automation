package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_073 extends Keywords {
	
	public void DG_Creation_SC_073(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_073";
		
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String PluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String PluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String PluginStatus = Excel_data.get("PluginStatus");		
		String pluginUpdatedPopup = Excel_data.get("PluginUpdatedPopup");
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		SwitchProfile(driver, AgencyUser);

		verifyMainMenu(driver);
		
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
		
		scrollToElement(driver, Close_Current_tab);
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		Step_Start(1, "Open the DG module   ",test, test1);
		
		moduleNavigate(driver, DG_Creation_Module);	
		
		Step_End(1, "Open the DG module   ",test, test1);
		
		Step_Start(2, "make sure response button enable  ",test, test1);
		
		
		scrollBottom(driver);
		
		waitForDisplay(driver, DGC_Dg_Validation);
		if(isdisplayed(driver, DGC_Dg_Validation)) {
			System.out.println("Matched || Expected popup : When DVQ plugin is enable, the system should not display the DG Validation Response button || Actual: When DVQ plugin is enable, the system does not display the DG Validation Response button.");
			Extent_pass_New(driver,"Matched || Expected popup : When DVQ plugin is enable, the system should not display the DG Validation Response button || Actual: When DVQ plugin is enable, the system does not display the DG Validation Response button.", test,test1);
			
		}else {
			System.out.println("Not Matched || Expected popup : When DVQ plugin is enable, the system should not display the DG Validation Response button || Actual: When DVQ plugin is enable, the system is display the DG Validation Response button.");
			Extent_fail(driver,"Not Matched || Expected popup : When DVQ plugin is enable, the system should not display the DG Validation Response button || Actual: When DVQ plugin is enable, the system is display the DG Validation Response button.", test,test1);
			
		}
		
		Step_End(2, "make sure   response button enable  ",test, test1);
			
		Extent_completed(testCaseName, test, test1);
		

}
}