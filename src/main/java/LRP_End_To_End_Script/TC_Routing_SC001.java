package LRP_End_To_End_Script;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Routing_SC001 extends Keywords{
	public void Routing_SC001(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		//	Get data from excel sheet

		String tc_name="TC_Routing_SC001";

		String ModuleRouting = Excel_data.get("ModuleRouting");
		String Origin_Header = Excel_data.get("Origin_Header_Routing");
		String Condition = Excel_data.get("Condition");
		String origin = Excel_data.get("origin");
		String Delivery_Header = Excel_data.get("Delivery_Header_Routing");
		String delivery = Excel_data.get("delivery");
		String POL_Header = Excel_data.get("POL_Header_Routing");
		String POL_Terminal_Header = Excel_data.get("POL_Terminal_Header_Routing");
		String POL_Terminal_Input = Excel_data.get("POL_Terminal_Input_Routing");
		String Service_Header = Excel_data.get("Service_Header_Routing");
		String Service_Code_new = Excel_data.get("Service_Code_new");
		String POD_Terminal_Header = Excel_data.get("POD_Terminal_Header_Routing");
		String POD_Terminal_Input = Excel_data.get("POD_Terminal_Input_Routing");
		String Route_Saved_Popup = Excel_data.get("Route_Saved_Popup_Routing");
//		String ModuleSearch = Excel_data.get("Module_Search_Service");
		
		Extent_Start(tc_name, test, test1);
		moduleNavigate(driver, ModuleRouting);
		newButton(driver);
		waitForElement(driver, Routing_Origin_Search);
		click(driver, Routing_Origin_Search);
		twoColumnSearchWindow(driver, Origin_Header, Condition, origin);
		waitForElement(driver, Routing_Delivery_Search);
		click(driver, Routing_Delivery_Search);
		twoColumnSearchWindow(driver, Delivery_Header, Condition, delivery);
		waitForElement(driver, Routing_Existing_Route_Button);
		click(driver, Routing_Existing_Route_Button);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver, Routing_POL_Search_Button);
		click(driver, Routing_POL_Search_Button);
		twoColumnSearchWindow(driver, POL_Header, Condition, origin);
		waitForElement(driver, Routing_POL_Terminal_Search_Button);
		click(driver, Routing_POL_Terminal_Search_Button);
		twoColumnSearchWindow(driver, POL_Terminal_Header, Condition, POL_Terminal_Input);
		
		waitForElement(driver, Routing_Service_Search_Button);
		click(driver, Routing_Service_Search_Button);
		twoColumnSearchWindow(driver, Service_Header, Condition, Service_Code_new);
		waitForElement(driver, Routing_POD_Terminal_Search_Button);
		click(driver, Routing_POD_Terminal_Search_Button);
		twoColumnSearchWindow(driver, POD_Terminal_Header, Condition, POD_Terminal_Input);
		waitForElement(driver, Routing_Add_Button);
		click(driver, Routing_Add_Button);
		
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message, Route_Saved_Popup);
		String actual_Message = getText(driver, popup_Message);
		if(Route_Saved_Popup.equals(actual_Message)) {
			System.out.println("Matched || Expected Pop-up value is : "+Route_Saved_Popup+" || The Actual Pop-up value is : "+actual_Message);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+Route_Saved_Popup+" || The Actual Pop-up value is : "+actual_Message, test, test1);
		}else {
			System.out.println("Not Matched || Expected Pop-up value is : "+Route_Saved_Popup+" || The Actual Pop-up value is : "+actual_Message);
			Extent_fail(driver, "NotMatched || Expected Pop-up value is : "+Route_Saved_Popup+" || The Actual Pop-up value is : "+actual_Message, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
	}
}
