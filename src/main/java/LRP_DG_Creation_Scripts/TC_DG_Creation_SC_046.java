package LRP_DG_Creation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_046 extends Keywords{

	public void DG_Creation_SC_046(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_046";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Plugin_Module = Excel_data.get("Plugin_Module");
		String PluginID = Excel_data.get("PluginID");
		String moduleID = Excel_data.get("ModuleID");
		String PluginStatus = Excel_data.get("PluginStatus");		
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String Remove_Popup_Exp = Excel_data.get("Remove_Popup_Exp");
		
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
			waitForElement(driver, Popup_Message);

			scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		moduleNavigate(driver, DG_Creation_Module);	

		newButton(driver);

		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_Start(4, "click multi apply  button", test, test1);
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

		Step_End(4, "click multi apply  button", test, test1);
		
		Step_Start(5, "select and remove the container in tree", test, test1);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		
		List<WebElement> DG_grid_Rows = listOfElements(driver, DG_Grid);
		for (int k = 1; k <= DG_grid_Rows.size(); k++) {
			String row_Select = String.format(DG_Grid_Row, k);
			waitForElement(driver, row_Select);
			click(driver, row_Select);
		

		
		waitForElement(driver, Remove_Button_DG);
		click(driver, Remove_Button_DG);
		
		waitForPopup(driver, popup_Message,Remove_Popup_Exp);
		String Remove_Popup_ACt = getText(driver, popup_Message);
		if(Remove_Popup_Exp.equals(Remove_Popup_ACt)) {     
			System.out.println("Expected Result is :  If Plugin Congiuration 'TRC' is False ,system should Allow to remove the containers  ||  Actual Result is :  If Plugin Congiuration 'TRC' is False ,system  Allows to remove the containers ");
			System.out.println("Matched || " + " Expected Report Activity is : " + Remove_Popup_Exp + " || Actual Report Activity is : " + Remove_Popup_ACt);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Remove_Popup_Exp + " || Actual Report Activity is : " + Remove_Popup_ACt, test,test1);     
			safeclick(driver, popup_Message_Yes_Button);
		}                                                                                                                                                                        
		else {  
			System.out.println("Expected Result is :  If Plugin Congiuration 'TRC' is False ,system should Allow to remove the containers  ||  Actual Result is :  If Plugin Congiuration 'TRC' is False ,system not  Allows to remove the containers ");
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Remove_Popup_Exp + " || Actual Report Activity is : " + Remove_Popup_ACt);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Remove_Popup_Exp + " || Actual Report Activity is : " + Remove_Popup_ACt, test,test1); 
		} 
		
		
		}
		
		Step_End(5, "select and remove the container in tree", test, test1);
		Extent_completed(testCaseName, test, test1);
	}

}
