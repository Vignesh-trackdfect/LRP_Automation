package LRP_DG_Creation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_052 extends Keywords {


	public void DG_Creation_SC_052(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_052";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");

		String booking_number = Excel_data.get("Booking_No_Input");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");	

		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String pluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String pluginStatus = Excel_data.get("PluginStatus");	
		String Set_Default_Plugin_Status = Excel_data.get("Set_Default_Plugin_Status");	
		String PluginStatus_Default = Excel_data.get("PluginStatus_Default");	

		String Search_By_Book_No = Excel_data.get("Search_By_Book_No");	
		String Booking_Module = Excel_data.get("Booking_Module");	
		String VIN_Chassis_Header = Excel_data.get("VIN_Chassis_Header");	
		String Eqp_Type_Header = Excel_data.get("Eqp_Type_Header");	
		
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

			moduleNavigate(driver, Booking_Module);

			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, GlobalSearch_Condition, Search_By_Book_No, booking_number, "", "", "", "");

			waitForElement(driver, noncon_tab);
			safeclick(driver, noncon_tab);
			
			waitForElement(driver, non_Containerized_Table_Row);
			List<Map<String, String>> non_Containerized_Details = getTableData(driver, non_Containerized_Table_Header, non_Containerized_Table_Row);
			List<String> VIN_Chassis_Number = getValuesByHeader(non_Containerized_Details, VIN_Chassis_Header);
			String actual_VIN_Chassis_Num=VIN_Chassis_Number.get(0);
			
			waitForElement(driver, Non_con_tab);
			safeclick(driver, Non_con_tab);
			
			waitForElement(driver, Non_Containerized_Table_Rows);
			List<Map<String, String>> non_Containerized_Table = getTableData(driver, Non_Containerized_Table_Columns, Non_Containerized_Table_Rows);
			List<String> Eqp_Types = getValuesByHeader(non_Containerized_Table, Eqp_Type_Header);
			String Eqp_Type=Eqp_Types.get(0);
			
			
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
			
			scrollElementToView(driver, amendment_Dropdown);
			waitForElement(driver, amendment_Dropdown);
			String amendmentNumber=getText(driver, amendment_Dropdown);
			System.out.println(" amendmentNumber : "+amendmentNumber);
			
		scrollElementToView(driver, DG_Container_Select);
		waitForElement(driver, container_Number_Value);
		String containerNumber_After=getText(driver, container_Number_Value);
		System.out.println(" containerNumber_After : "+containerNumber_After);
		
		if(containerNumber_After.contains(actual_VIN_Chassis_Num)) {
			System.out.println("Matched || " + " VIN Chassis Number in Booking : " + actual_VIN_Chassis_Num + " ||  VIN Chassis Number in DG Creation : " + containerNumber_After);            
			Extent_pass_New(driver, "Matched || " + " VIN Chassis Number in Booking : " + actual_VIN_Chassis_Num + " ||  VIN Chassis Number in DG Creation : " + containerNumber_After, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " VIN Chassis Number in Booking : " + actual_VIN_Chassis_Num + " ||  VIN Chassis Number in DG Creation : " + containerNumber_After);        
			Extent_fail(driver, "Not Matched || " + " VIN Chassis Number in Booking : " + actual_VIN_Chassis_Num + " ||  VIN Chassis Number in DG Creation : " + containerNumber_After, test,test1); 
		}
		
		
		if(containerNumber_After.contains(amendmentNumber)) {
			System.out.println("Matched || " + "Expected Amendment Number : " + amendmentNumber + " ||  Actual Amendment Number in Container number : " + containerNumber_After);            
			Extent_pass_New(driver, "Matched || " + "Expected Amendment Number : " + amendmentNumber + " ||  Actual Amendment Number in Container number : " + containerNumber_After, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + "Expected Amendment Number : " + amendmentNumber + " ||  Actual Amendment Number in Container number : " + containerNumber_After);        
			Extent_fail(driver, "Not Matched || " + "Expected Amendment Number : " + amendmentNumber + " ||  Actual Amendment Number in Container number : " + containerNumber_After, test,test1); 
		}
		
		if(containerNumber_After.contains(Eqp_Type)) {
			System.out.println("Matched || " + " Eqp Type in Booking : " + Eqp_Type + " ||  Eqp Type in DG Creation : " + containerNumber_After);            
			Extent_pass_New(driver, "Matched || " + " Eqp Type in Booking : " + Eqp_Type + " ||  Eqp Type in DG Creation : " + containerNumber_After, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Eqp Type in Booking : " + Eqp_Type + " ||  Eqp Type in DG Creation : " + containerNumber_After);        
			Extent_fail(driver, "Not Matched || " + " Eqp Type in Booking : " + Eqp_Type + " ||  Eqp Type in DG Creation : " + containerNumber_After, test,test1); 
		}
		
		if(Set_Default_Plugin_Status.equalsIgnoreCase("Yes")) {
//		Plugin Configuration
			
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
