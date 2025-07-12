package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC041 extends Keywords{
	
	public void CRO_SC041(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC041";
			
			String Username = Excel_data.get("Username");
			String Password = Excel_data.get("Password");
			String Printout_Configuration_Module= Excel_data.get("Printout_Configuration_Module");
			String ModuleName_Search = Excel_data.get("ModuleName_Search");
			String CRO_Module_Name= Excel_data.get("CRO_Module_Name");
			String Band_Name = Excel_data.get("Band_Name");
			String Updated_Popup_PC = Excel_data.get("Updated_Popup_PC");
			String agencyUser = Excel_data.get("agencyUser");
			String Search_Condition = Excel_data.get("Search_Condition");
			String Search_By = Excel_data.get("Search_By");
			String terminalDetails_Filter = Excel_data.get("TerminalDetails_Filter");
			String releaseDepTerminal = Excel_data.get("ReleaseDepTerminal");
			String condition_Filter = Excel_data.get("condition_Filter");
			
			
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
	 
			if(!releaseDepTerminal.equals("")) {
				twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, releaseDepTerminal);
			}else {
				twoColumnSearchWindow(driver, terminalDetails_Filter, condition_Filter, acc_term_value);
			}
	 
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForElement(driver, Release_No_CRO);
			String CRO_Release_Number = getAttribute(driver, Release_No_CRO, "value");
			System.out.println("CRO_Release_NumberBefore :"+CRO_Release_Number);
			
			Step_Start(1, "Open printout configuration module", test, test1);

			moduleNavigate(driver,Printout_Configuration_Module);
				
			Step_End(1, "Open printout configuration module", test, test1);
			
			Step_Start(2, "Search CRO module and type F", test, test1);
			
			newButton(driver);
			 
			waitForElement(driver, moduleName_Search_Dropdown);
			click(driver, moduleName_Search_Dropdown);
			
			formatLocatorClick(driver, DropDown_Select, ModuleName_Search);
			
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
			 String selectBand=String.format(band_Select, Band_Name);
				
				waitForDisplay(driver, selectBand);
				scrollElementToView(driver, selectBand);
				waitForElement(driver, selectBand);
				click(driver, selectBand);
				

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
			

			Step_Start(2, "Search CRO module and type F", test, test1);
			
			Step_Start(3, "Go to Container release order module", test, test1);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
			moduleNavigate(driver, CRO_Module_Name);
			
			waitForElement(driver,cancel_Common_btn);
			click(driver, cancel_Common_btn);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver,Search_Condition, Search_By , CRO_Release_Number, "", "", "", "");
			 
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			
			Step_End(3, "Go to Container release order module", test, test1);
			
			Step_Start(4, "Click print button", test, test1);
			
			waitForElement(driver,Print_Button_toolBar);
			click(driver, Print_Button_toolBar);
			
			Step_End(4, "Click print button", test, test1);
			
			Step_Start(5, "Check the footer details in print.", test, test1);
			
			
			

			Step_End(5, "Check the footer details in print.", test, test1);
			
			Extent_completed(testCaseName, test, test1);

		}
	}

