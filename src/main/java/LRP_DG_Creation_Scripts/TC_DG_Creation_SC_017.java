package LRP_DG_Creation_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_017 extends Keywords {


	public void DG_Creation_SC_017(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_017";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");

		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String UN_No = Excel_data.get("UN_No");
		String DG_Creation_Save_Popup = Excel_data.get("DG_Creation_Save_Popup");
		
		String pluginConfigurationModule = Excel_data.get("PluginConfigurationModule");
		String PluginID = Excel_data.get("PluginID");
		String ModuleID = Excel_data.get("ModuleID");
		String pluginStatus = Excel_data.get("PluginStatus");	
		String Set_Default_Plugin_Status = Excel_data.get("Set_Default_Plugin_Status");	
		String PluginStatus_Default = Excel_data.get("PluginStatus_Default");	
		String Delete_Popup = Excel_data.get("Delete_Popup");
		String Delete_Confirm_Popup = Excel_data.get("Delete_Confirm_Popup");
		String DG_Deleted_Popup = Excel_data.get("DG_Deleted_Popup");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String DG_No_Type = Excel_data.get("DG_No_Type");
		
		
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
		sendKeys(driver, pluginIdFilter_Searchbox, PluginID);
		waitForElement(driver, moduleIdFilter_Searchbox);
		sendKeys(driver, moduleIdFilter_Searchbox, ModuleID);

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
			
		
		moduleNavigate(driver, DG_Creation_Module);
		
		newButton(driver);
		
		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_Start(4, "click multi apply  button..)", test, test1);
		

		scrollElementToView(driver, DG_Container_Select);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		
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
		
	
		waitForElement(driver, DG_UN_number_Values_grid);
		String act_Un_number=getText(driver, DG_UN_number_Values_grid);
		
		if(act_Un_number.equals(UN_No)) {
			System.out.println("Matched || " + " Expected UN NO Should be display  : " + UN_No+ " || Actual UN NO is display : " + act_Un_number);
			Extent_pass(driver, "Matched || " + " Expected UN NO Should be display : " + UN_No+ " || Actual UN NO is display : " + act_Un_number, test, test1);
		}else{
			System.out.println("Not Matched || " + " Expected UN NO Should be display  : " + UN_No+ " || Actual UN NO is Not display : " + act_Un_number);
			Extent_fail(driver, "Not Matched || " + " Expected UN NO Should be display  : " + UN_No+ " || Actual UN NO is Not display : " + act_Un_number, test, test1);
		}
		
		Step_End(4, "click multi apply  button..)", test, test1);

		
		Step_Start(5, "Click save button.)", test, test1);
		
		waitForElement(driver, DG_Save_Btn);
		safeclick(driver, DG_Save_Btn);
		waitForPopup(driver, popup_Message, DG_Creation_Save_Popup);
		String Saved_Popup = getText(driver, popup_Message);
		System.out.println(Saved_Popup);
		if (Saved_Popup.equals(DG_Creation_Save_Popup)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + DG_Creation_Save_Popup
					+ " || Actual Report Activity is : " + Saved_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + DG_Creation_Save_Popup
					+ " || Actual Report Activity is : " + Saved_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + DG_Creation_Save_Popup
					+ " || Actual Report Activity is : " + Saved_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + DG_Creation_Save_Popup
					+ " || Actual Report Activity is : " + Saved_Popup, test, test1);
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
		Step_End(5, "Click save button.)", test, test1);

		Step_Start(6, "Select the container in Grid.)", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, GlobalSearch_Condition, DG_No_Type, generated_DG_Number, "", "", "", "");

		scrollElementToView(driver, DG_Container_Select);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		
		waitForElement(driver, Select_Row);
		click(driver, Select_Row);
		
		Step_End(6, "Select the container in Grid.)", test, test1);
		Step_Start(7, "Click remove button.)", test, test1);
		waitForElement(driver, DG_Remove);
		safeclick(driver, DG_Remove);
		waitForPopup(driver, popup_Message, Delete_Popup);
		String DG_Remove_Popup1 = getText(driver, popup_Message);
		if (DG_Remove_Popup1.equals(Delete_Popup)) {
			System.out.println(
					"Matched || " + " Expected Popup is : " + Delete_Popup + " || Actual Popup is : " + DG_Remove_Popup1);
			Extent_pass_New(driver,
					"Matched || " + " Expected Popup is: " + Delete_Popup + " || Actual Popup is : " + DG_Remove_Popup1,
					test, test1);
			
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : " + Delete_Popup + " || Actual Popup is : "
					+ DG_Remove_Popup1);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Delete_Popup + " || Actual Popup is : "
					+ DG_Remove_Popup1, test, test1);
			
		}
		click(driver, popup_Message_Yes_Button);
		
		waitForPopup(driver, popup_Message, Delete_Confirm_Popup);
		 DG_Remove_Popup1 = getText(driver, popup_Message);
		if (DG_Remove_Popup1.equals(Delete_Confirm_Popup)) {
			System.out.println(
					"Matched || " + " Expected Popup is : " + Delete_Confirm_Popup + " || Actual Popup is : " + DG_Remove_Popup1);
			Extent_pass_New(driver,
					"Matched || " + " Expected Popup is: " + Delete_Confirm_Popup + " || Actual Popup is : " + DG_Remove_Popup1,
					test, test1);
			
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : " + Delete_Confirm_Popup + " || Actual Popup is : "
					+ DG_Remove_Popup1);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Delete_Confirm_Popup + " || Actual Popup is : "
					+ DG_Remove_Popup1, test, test1);
			
		}
		click(driver, popup_Message_Yes_Button);
		
		waitForPopup(driver, popup_Message, DG_Deleted_Popup);
		 DG_Remove_Popup1 = getText(driver, popup_Message);
		if (DG_Remove_Popup1.equals(DG_Deleted_Popup)) {
			System.out.println(
					"Matched || " + " Expected Popup is : " + DG_Deleted_Popup + " || Actual Popup is : " + DG_Remove_Popup1);
			Extent_pass_New(driver,
					"Matched || " + " Expected Popup is: " + DG_Deleted_Popup + " || Actual Popup is : " + DG_Remove_Popup1,
					test, test1);
			
		} else {
			System.out.println("Not Matched || " + " Expected Popup is : " + DG_Deleted_Popup + " || Actual Popup is : "
					+ DG_Remove_Popup1);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + DG_Deleted_Popup + " || Actual Popup is : "
					+ DG_Remove_Popup1, test, test1);
			
		}
		click(driver, popup_Message_Ok_Button);
		
		Step_End(7, "Click remove button.)", test, test1);
		
		if(Set_Default_Plugin_Status.equalsIgnoreCase("Yes")) {
//			Plugin Configuration
				Extent_cal(test, test1, "Plugin Configuration");
				
				moduleNavigate(driver, pluginConfigurationModule);
						
				Extent_cal(test, test1, pluginConfigurationModule);
	 
				waitForElement(driver, pluginIdFilter_Searchbox);
				sendKeys(driver, pluginIdFilter_Searchbox, PluginID);
				waitForElement(driver, moduleIdFilter_Searchbox);
				sendKeys(driver, moduleIdFilter_Searchbox, ModuleID);
	 
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
		}}
