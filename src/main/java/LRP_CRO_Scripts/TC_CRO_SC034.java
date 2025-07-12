package LRP_CRO_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


public class TC_CRO_SC034 extends Keywords {

	public void CRO_SC034(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC034";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String PrintOutConfiguration_Module_Name = Excel_data.get("PrintOutConfiguration_Module_Name");
		String Band_Name = Excel_data.get("Band_Name");
		String Band_Name_Select = Excel_data.get("Band_Name_Select");
		String ModuleName_Search = Excel_data.get("ModuleName_Search");
		String Updated_Popup_PC = Excel_data.get("Updated_Popup_PC");
		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String condition_Filter = Excel_data.get("condition_Filter");
		String terminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String Global_Search_Type = Excel_data.get("Global_Search_Type");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");

		
		Extent_Start(testCaseName, test, test1);


		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, agencyUser);

		Step_Start(1, "Open printout configuration module.", test, test1);

		moduleNavigate(driver, PrintOutConfiguration_Module_Name);

		Step_End(1, "Open printout configuration module.", test, test1);
		Step_Start(2, "Search CRO module.", test, test1);

		newButton(driver);

		waitForElement(driver, moduleName_Search_Dropdown);
		click(driver, moduleName_Search_Dropdown);
		
		formatLocatorClick(driver, DropDown_Select, ModuleName_Search);
		
		Step_End(2, "Search CRO module.", test, test1);
		Step_Start(3, "Click edit button.", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_End(3, "Click edit button.", test, test1);
		Step_Start(4, "Click CtnrBand check box.", test, test1);

		String selectBand=String.format(band_Select, Band_Name);
		
		scrollElementToView(driver, selectBand);
		waitForElement(driver, selectBand);
		if(Band_Name_Select.equalsIgnoreCase("Yes")){
			click(driver, selectBand);
			}
		
		Step_End(4, "Click CtnrBand check box.", test, test1);
		Step_Start(5, "Click save btton.", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(5, "Click save btton.", test, test1);
		Step_Start(6, "Printout Configuration updated message shown.", test, test1);

		waitForPopup(driver, popup_Message, Updated_Popup_PC);
		String actualPopup=getText(driver, popup_Message);
		
		if (actualPopup.contains(Updated_Popup_PC)) {
			System.out.println("Matched || Expected Popup  : " + Updated_Popup_PC + "|| Actual Popup :" + actualPopup);
			Extent_pass_New(driver, "Matched || Expected Popup  : " + Updated_Popup_PC + "|| Actual Popup  :" + actualPopup, test,test1);

		} else {
			System.out.println("Not Matched || Expected Popup : " + Updated_Popup_PC + "|| Actual Popup  :" + actualPopup);
			Extent_fail(driver, "Not Matched || Expected Popup :" + Updated_Popup_PC + "|| Actual Popup :" + actualPopup, test,test1);
		}
		Step_End(6, "Printout Configuration updated message shown.", test, test1);

		Step_Start(7, "Click ok button.", test, test1);

		click(driver, popup_Message_Ok_Button);

		Step_End(7, "Click ok button.", test, test1);


//		Booking module

		Confirmed_Booking_Creation createBooking=new Confirmed_Booking_Creation();
		createBooking.confirm_Booking(driver, test, test1, Excel_data);
		

		//	Create CRO

		waitForElement(driver, CRO_btn);
		click(driver, CRO_btn);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, acc_terminal);
		String acc_term_value=getAttribute(driver, acc_terminal, "value");
		System.out.println(acc_term_value);

		waitForElement(driver, rel_terminal_searchicon);
		click(driver, rel_terminal_searchicon);

		if(!releaseDepTerminal.equals("")) {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, releaseDepTerminal);
		}else {
			twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, acc_term_value);
		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForElement(driver, Release_number_Input);
		String CRO_Release_Number = getAttribute(driver, Release_number_Input, "value");
		System.out.println("CRO_Release_NumberBefore :"+CRO_Release_Number);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

//  CRO 
		Step_Start(8, "Go to Container release order module.", test, test1);

		moduleNavigate(driver, CRO_Module_Name);
		

		Step_End(8, "Go to Container release order module.", test, test1);
		Step_Start(9, "Click print button.", test, test1);

		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, GlobalSearch_Condition, Global_Search_Type, CRO_Release_Number, "", "", "", "");
		
		scrollTop(driver);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		
		Step_End(9, "Click print button.", test, test1);
		Step_Start(10, "Check the container details display", test, test1);

		
		Step_End(10, "Check the container details display", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
	}
