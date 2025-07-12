package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


public class TC_DG_Creation_SC_089 extends Keywords {


	public void DG_Creation_SC_089(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_089";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");

		String unNo = Excel_data.get("UN_No");
		String Column_condition = Excel_data.get("Column_condition");
		String UN_Number_Column_Header = Excel_data.get("UN_Number_Column_Header");

		String booking_number = Excel_data.get("Booking_No_Input");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption");

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
			
		Step_Start(1, "Open the DG module ", test, test1);

		moduleNavigate(driver, DG_Creation_Module);
		
		newButton(driver);
		
		waitForElement(driver, Booking_No_Search_DG);
		click(driver, Booking_No_Search_DG);
		globalValueSearchWindow(driver, GlobalSearch_Condition, globalSearchFilterOption1, booking_number, "", "", "", "");
		

		waitForElement(driver, UN_NO_Search_DG);
		click(driver, UN_NO_Search_DG);
	
		twoColumnSearchWindow(driver, UN_Number_Column_Header, Column_condition, unNo);
		
		Step_End(1, "Open the DG module ", test, test1);
		Step_Start(2, "make sure   file upload   button enable ", test, test1);

		scrollElementToView(driver, Multi_Apply_Btn);
		
		waitForDisplay(driver, File_Chooser_Button);
		if(isdisplayed(driver, File_Chooser_Button)) {
			System.out.println("Matched || " + " Expected : File upload button should be displayed || Actual :  File upload button is displayed ");            
			Extent_pass_New(driver, "Matched || " + " Expected : File upload button should be displayed || Actual :  File upload button is displayed ", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected : File upload button should be displayed || Actual :  File upload button is not displayed ");        
			Extent_fail(driver, "Not Matched || " + " Expected : File upload button should be displayed || Actual :  File upload button is not displayed ", test,test1); 
		} 
		
		
		Step_End(2, "make sure   file upload   button enable ", test, test1);

		if(Set_Default_Plugin_Status.equalsIgnoreCase("Yes")) {
//		Plugin Configuration
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

				formatLocatorClick(driver, pluginValue_Select, PluginStatus_Default);
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
		}
		
		Extent_completed(testCaseName, test, test1);
	}

}
