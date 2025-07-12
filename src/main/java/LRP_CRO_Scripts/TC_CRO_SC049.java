package LRP_CRO_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


public class TC_CRO_SC049 extends Keywords {

	public void CRO_SC049(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC049";

		//		Get data from excel sheet

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");
		String Local_Contacts_Module_Name = Excel_data.get("Local_Contacts_Module_Name");
		String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
		String condition_Filter = Excel_data.get("condition_Filter");
		String terminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
		String Global_Search_Type = Excel_data.get("Global_Search_Type");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");

		
		Extent_Start(testCaseName, test, test1);


		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, agencyUser);

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
		System.out.println("CRO_Release_Number :"+CRO_Release_Number);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Step_Start(1, "Open local contacts module.", test, test1);

		moduleNavigate(driver, Local_Contacts_Module_Name);

		Step_End(1, "Open local contacts module.", test, test1);
		Step_Start(2, "Search Release Depot/Terminal.", test, test1);

		scrollElementToView(driver, LC_Terminal_Filter);
		waitForElement(driver, LC_Terminal_Filter);
		click(driver, LC_Terminal_Filter);
		
		if(!releaseDepTerminal.equals("")) {
		sendKeys(driver, LC_Terminal_Filter, releaseDepTerminal);
		}else {
			sendKeys(driver, LC_Terminal_Filter, acc_term_value);
		}
		
		waitForElement(driver, LC_Terminal_Name_Gridcell);
		String terminalName_LC=getText(driver, LC_Terminal_Name_Gridcell);
		System.out.println("terminalName_LC : "+terminalName_LC);
		
		Step_End(2, "Search Release Depot/Terminal.", test, test1);
		Step_Start(3, "Go to CRO module.", test, test1);

		moduleNavigate(driver, CRO_Module_Name);

		Step_End(3, "Go to CRO module.", test, test1);
		Step_Start(4, "Click print button", test, test1);

		scrollTop(driver);
		waitForElement(driver, cancel_Common_btn);
		click(driver, cancel_Common_btn);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, GlobalSearch_Condition, Global_Search_Type, CRO_Release_Number, "", "", "", "");
		
		waitForElement(driver, CRO_Release_Terminal_Name_Textfield);
		String relTermName=getAttribute(driver, CRO_Release_Terminal_Name_Textfield, "value");
		System.out.println("relTermName : "+relTermName);

		if(relTermName.equals(terminalName_LC)) {
			System.out.println("Matched || Release Termial Name in Local Contacts : "+terminalName_LC+" || Release Termial Name in Local Contacts : "+relTermName);
			Extent_pass_New(driver, "Matched || Release Termial Name in Local Contacts : "+terminalName_LC+" || Release Termial Name in Local Contacts : "+relTermName, test, test1);
		}else {
			System.out.println("Not Matched || Release Termial Name in Local Contacts : "+terminalName_LC+" || Release Termial Name in Local Contacts : "+relTermName);
			Extent_fail(driver, "Not Matched || Release Termial Name in Local Contacts : "+terminalName_LC+" || Release Termial Name in Local Contacts : "+relTermName, test, test1);
		}
		
		scrollTop(driver);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
			
		Step_End(4, "Click print button", test, test1);
		Step_Start(5, "Check Depot/ Terminal address.", test, test1);

		
		
		Step_End(5, "Check Depot/ Terminal address.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
	}
