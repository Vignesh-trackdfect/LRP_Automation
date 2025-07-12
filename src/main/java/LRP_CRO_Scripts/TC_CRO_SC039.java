package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC039 extends Keywords{

	public void CRO_SC039(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC039";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String ModuleName_Search = Excel_data.get("ModuleName_Search");
		String Updated_Popup_PC = Excel_data.get("Updated_Popup_PC");
		String Booking_Module_Name = Excel_data.get("Booking_Module_Name");
		String Band_Name = Excel_data.get("Band_Name");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Search_By = Excel_data.get("Search_By");
		String PrintOutConfiguration_Module_Name = Excel_data.get("PrintOutConfiguration_Module_Name");
		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String condition_Filter = Excel_data.get("condition_Filter");
		String terminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		
		
		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Open the browser", test, test1);

		navigateUrl(driver, url);
		
		Step_End(1, "Open the browser", test, test1);
		Step_End(2, "Open the browser", test, test1);

		Step_Start(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_Start(4, " Click on Login Button", test, test1);

		LRP_Login(driver, Username, Password);
		
		Step_End(3, "Enter valid Username & Password in respective textfields", test, test1);
		Step_End(4, " Click on Login Button", test, test1);
		Step_Start(5, "Switch the agency", test, test1);

		SwitchProfile(driver, agencyUser);
		
		Step_End(5, "Switch the agency", test, test1);


		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
		// cro button 
		
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
         
     	waitForElement(driver, Booking_No_Field_CRO);
		String CRO_Booking_number =getAttribute(driver, Booking_No_Field_CRO, "value");
		
		//booking number get text
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
	
		
		Step_Start(23, "Open printout configuration module.", test, test1);
		 
		moduleNavigate(driver, PrintOutConfiguration_Module_Name);
 
		Step_End(23, "Open printout configuration module.", test, test1);
		
		Step_Start(24, "Search CRO module.", test, test1);
 
		newButton(driver);
 
		waitForElement(driver, moduleName_Search_Dropdown);
		click(driver, moduleName_Search_Dropdown);
		
		formatLocatorClick(driver, DropDown_Select, ModuleName_Search);
		
		Step_End(24, "Search CRO module.", test, test1);
		
		Step_Start(25, "Click edit button.", test, test1);
 
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_End(25, "Click edit button.", test, test1);
		
		Step_Start(26, "Click ldportfree band check box.", test, test1);
		
        String selectBand=String.format(band_Select, Band_Name);
		
		waitForDisplay(driver, selectBand);
		scrollElementToView(driver, selectBand);
		waitForElement(driver, selectBand);
		click(driver, selectBand);
		
		 
		Step_Start(26, "Click ldportfree band check box.", test, test1);
		
		
		Step_Start(27, "Click save btton.", test, test1);
 
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(27, "Click save btton.", test, test1);
		
		Step_Start(28, "Printout Configuration updated message shown.", test, test1);
 
		waitForPopup(driver, popup_Message, Updated_Popup_PC);
		String actualPopup=getText(driver, popup_Message);
		
		if (actualPopup.contains(Updated_Popup_PC)) {
			System.out.println("Matched || Expected Popup  : " + Updated_Popup_PC + "|| Actual Popup :" + actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup  : " + Updated_Popup_PC + "|| Actual Popup  :" + actualPopup, test,test1);
 
		} else {
			System.out.println("Not Matched || Expected Popup : " + Updated_Popup_PC + "|| Actual Popup  :" + actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :" + Updated_Popup_PC + "|| Actual Popup :" + actualPopup, test,test1);
		}
		Step_End(28, "Printout Configuration updated message shown.", test, test1);
 
		Step_Start(29, "Click ok button.", test, test1);
 
		click(driver, popup_Message_Ok_Button);
		
		Step_End(29, "Click ok button.", test, test1);
 
		Step_Start(30, "Go to booking module.", test, test1);
		
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		moduleNavigate(driver, Booking_Module_Name);

		Step_End(30, "Go to booking module.", test, test1);
		
		
		Step_Start(31, " Navigate CRO module.", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver,Search_Condition, Search_By , CRO_Booking_number, "", "", "", "");
		 
		
		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);
		
		
		Step_End(31, " Navigate CRO module.", test, test1);
		 
		Step_Start(32, "Select Release Depot/Terminal", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);
		
		Step_End(32, "Select Release Depot/Terminal", test, test1);
		
		
		Step_Start(33, "Select Acceptance Terminal.", test, test1);
		
		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);

		if(!releaseDepTerminal.equals("")) {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, releaseDepTerminal);
		}else {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, acc_term_value);
		}

		Step_End(33, "Select Acceptance Terminal.", test, test1);
		
		Step_Start(34, "Click save button", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(34, "Click save button", test, test1);
		
		Step_Start(35, "Clcik print button.", test, test1);
		
		waitForElement(driver,Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		
		Step_End(35, "Clcik print button.", test, test1);
		
		
		Step_Start(36, "Check Load port free time in print.", test, test1);
		
		
		Step_Start(36, "Check Load port free time in print.", test, test1);
		

		Extent_completed(testCaseName, test, test1);
		
		
		
		
	}
}
