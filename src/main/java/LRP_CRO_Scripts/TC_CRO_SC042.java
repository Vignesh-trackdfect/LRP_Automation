package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC042 extends Keywords {

	public void CRO_SC042(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC042";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String TerminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String condition_Filter = Excel_data.get("condition_Filter");
		String ReleaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String CRO_Popup_Exp = Excel_data.get("CRO_Popup_Exp");
		String PrintOutConfiguration_Module_Name = Excel_data.get("PrintOutConfiguration_Module_Name");
		String Updated_Popup_PC = Excel_data.get("Updated_Popup_PC");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String Global_Search_Type = Excel_data.get("Global_Search_Type");
		String ModuleName_Search = Excel_data.get("ModuleName_Search");
		String Description_Text_Input = Excel_data.get("Description_Text_Input");

		Extent_Start(testCaseName, test, test1);
		
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		SwitchProfile(driver, agencyUser);

		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);

		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);

		if(!ReleaseDepTerminal.equals("")) {
			twoColumnSearchWindow(driver, TerminalDetails_Filter, condition_Filter, ReleaseDepTerminal);
		}else {
			twoColumnSearchWindow(driver, TerminalDetails_Filter, condition_Filter, acc_term_value);
		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		String CRO_Popup_Act = getText(driver, Popup_Message);
		System.out.println(CRO_Popup_Act);
		if(CRO_Popup_Exp.equals(CRO_Popup_Act)) {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_pass_New(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}else {
			System.out.println("Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act);
			Extent_fail(driver, "Matched || Expected Popup : "+CRO_Popup_Exp+ " || Actual Popup :" +CRO_Popup_Act, test, test1);
		}


		waitForElement(driver, Booking_No_Field_CRO);
		String Booking_Number = getAttribute(driver, Booking_No_Field_CRO, "value");
		System.out.println("CRO Booking Number : "+Booking_Number);

		waitForElement(driver, Release_No_CRO);
		String CRO_Release_Number = getAttribute(driver, Release_No_CRO, "value");
		System.out.println("CRO_Release_NumberBefore :"+CRO_Release_Number);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		waitForElement(driver,Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_Start(1, "Open printout configuration module.", test, test1);
		 
		moduleNavigate(driver, PrintOutConfiguration_Module_Name);
 
		Step_End(1, "Open printout configuration module.", test, test1);
		Step_Start(2, "Search CRO module.", test, test1);
 
		newButton(driver);
 
		waitForElement(driver, moduleName_Search_Dropdown);
		click(driver, moduleName_Search_Dropdown);
		
		formatLocatorClick(driver, DropDown_Select, ModuleName_Search);
		
		Step_End(2, "Search CRO module.", test, test1);
 
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
 
		waitForElement(driver, Remark_Button);
		click(driver, Remark_Button);
		
		scrollTop(driver);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver, Description_Text);
		sendKeys(driver, Description_Text, Description_Text_Input);
			
		waitForElement(driver, Description_Add_Button);
		click(driver, Description_Add_Button);
		
 
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
 
		waitForPopup(driver, popup_Message, Updated_Popup_PC);
		String actualPopup=getText(driver, popup_Message);
		
		if (actualPopup.contains(Updated_Popup_PC)) {
			System.out.println("Matched || Expected Popup  : " + Updated_Popup_PC + "|| Actual Popup :" + actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup  : " + Updated_Popup_PC + "|| Actual Popup  :" + actualPopup, test,test1);
 
		} else {
			System.out.println("Not Matched || Expected Popup : " + Updated_Popup_PC + "|| Actual Popup  :" + actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :" + Updated_Popup_PC + "|| Actual Popup :" + actualPopup, test,test1);
		}
 
 
		click(driver, popup_Message_Ok_Button);
 
		Step_Start(3, "Go to Container release order module", test, test1);

		moduleNavigate(driver, CRO_Module_Name);
		Step_End(3, "Go to Container release order module", test, test1);

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, GlobalSearch_Condition,  Global_Search_Type, CRO_Release_Number, "", "", "", "");
		
		Step_Start(4, "Click print button", test, test1);

		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		Step_End(4, "Click print button", test, test1);

}
}
