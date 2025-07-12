package LRP_Phase_1A_NFR_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ports_SC007 extends Keywords{

	public void Ports_SC007(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Ports_SC007";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Ports_Module = Excel_data.get("Ports_Module");
		String Global_Header = Excel_data.get("Global_Header");
		String Dropdown_Condition = Excel_data.get("Dropdown_Condition");
		String Global_Input = Excel_data.get("Global_Input");
		String Agency_code_Header = Excel_data.get("Agency_code_Header");
		String Condition = Excel_data.get("Condition");
		String Agency_code_Input = Excel_data.get("Agency_code_Input");
		String Agency_Master_Module = Excel_data.get("Agency_Master_Module");
		String Agency_Global_Header = Excel_data.get("Agency_Global_Header");
		String Agency_Global_Input = Excel_data.get("Agency_Global_Input");
		String Location_updated_popup = Excel_data.get("Location_updated_popup");
		String Type =Excel_data.get("Type");
		String Type_Header =Excel_data.get("Type_Header");
		
		Extent_Start(testcase_Name, test, test1);
		 
		Step_Start(1, "Login the application.", test, test1);
		
		navigateUrl(driver, url);
		
		LRP_Login(driver, username, pass_word);
//		verifyMainMenu(driver);
		
		Step_End(1, "Login the application.", test, test1);

		Step_Start(2, "Navigate to ports screen", test, test1);

		moduleNavigate(driver, Ports_Module);
		
		Step_End(2, "Navigate to ports screen", test, test1);
		
		Step_Start(3, "Retrieve ports from the global search.Ex: QQQQQ.", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, Dropdown_Condition, Global_Header, Global_Input, "", "", "", "");
		
		Step_End(3, "Retrieve ports from the global search.Ex: QQQQQ.", test, test1);
		
		
		Step_Start(4, "Ensure that agency code which is mapped to ports. Ex: AEESAD.", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		
		waitForElement(driver, Ports_Agency_Button);
		click(driver,Ports_Agency_Button);
		
		
		twoColumnSearchWindow(driver, Agency_code_Header, Condition, Agency_code_Input);
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Location_updated_popup);
		String updated_popup =getText(driver, popup_Message);
		
		
		if(updated_popup.equals(Location_updated_popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Location_updated_popup + " || Actual  POPUP message is : " + updated_popup);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Location_updated_popup + " || Actual  POPUP message is : " + updated_popup, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Location_updated_popup + " || Actual  POPUP message is : " + updated_popup);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Location_updated_popup + " || Actual  POPUP message is : " + updated_popup, test, test1);

		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(4, "Ensure that agency code which is mapped to ports. Ex: AEESAD.", test, test1);
		
		Step_Start(5, ".Open Agency Master Screen.", test, test1);
		
		moduleNavigate(driver, Agency_Master_Module);
		
		Step_End(5, ".Open Agency Master Screen.", test, test1);
		
		
		Step_Start(6, "Retrive the agency Ex: AEESAD.", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		
		
		globalValueSearchWindow(driver, Dropdown_Condition, Agency_Global_Header, Agency_Global_Input, "", "", "", "");
		
		Step_End(6, "Retrive the agency Ex: AEESAD.", test, test1);
		
		
		Step_Start(7, "Navigate to Controlling Ports Tab.", test, test1);

		waitForElement(driver, Controlling_Ports_Tab);
		click(driver,Controlling_Ports_Tab);
		
		Step_End(7, "Navigate to Controlling Ports Tab.", test, test1);
		
		Step_Start(8, "To verify the result that port(Import & Export)  has been added in agency master screen.", test, test1);
		
		
		waitForElement(driver, AM_Click_For_More_Options);
		click(driver,AM_Click_For_More_Options);
		
		waitForElement(driver, AM_Condition_Filter_Button);
		click(driver,AM_Condition_Filter_Button);
		
		
		waitForElement(driver, AM_Port_Code_input);
		sendKeys(driver, AM_Port_Code_input, Global_Input);
		
		waitForElement(driver, AM_Grid_Table);
      List<Map<String, String>> act = extractTableDataByColumn(driver, AM_Grid_Table);
      
      List<String> actvalue = getValuesByHeader(act, Type_Header);
      
    
      
         List<String> exp_type = splitAndExpand(Type);
         int i=0;
         
        for(String Act_type:actvalue) {
        	if(Act_type.equals(exp_type.get(i))) {
        		System.out.println("Matched || Expected Type value was : " + exp_type.get(i)+ " || Actual Type value was is display: " + Act_type);
        		Extent_pass_New(driver, "Matched || Expected Type value was : " + exp_type.get(i)+ " || Actual Type value was is display : " + Act_type, test, test1);
        	}else {
        		
        		System.out.println("Not Matched || Expected Type value was : " + exp_type.get(i)+ " || Actual Type value was is not display: " + Act_type);
        		Extent_fail(driver, "Not Matched || Expected Type value was : " + exp_type.get(i)+ " || Actual Type value was is not display : " + Act_type, test, test1);
        	}
        	i++;
        }
     
		Step_End(8, "To verify the result that port(Import & Export)  has been added in agency master screen.", test, test1);

		Extent_completed(testcase_Name, test, test1);
		
		
}
	
}
