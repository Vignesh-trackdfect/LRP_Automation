package LRP_VSS_Coastal_Scedule_Scripts;

import java.util.Map;


import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS11 extends Keywords{

	public void Coastal_Schedule_CS11(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS11";

		String CurrentTerminalRenamed =Excel_data.get( "CurrentTerminalRenamed");
		String FutureTerminalRenamed =Excel_data.get( "FutureTerminalRenamed");
		String TerminalInput = Excel_data.get("TerminalInput");
		String Change_Future_Voyages = Excel_data.get("Change_Future_Voyages");
		String Username_CS11 =Excel_data.get("Username");
		String Password_CS11 =Excel_data.get("Password");
		String ModuleSearch_CS11 =Excel_data.get("Module_Search");
		String ServiceCode_CS11 =Excel_data.get("Service_Code"); 
		String VesselCode_CS11 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS11 =Excel_data.get("Voyage_Number");
		String portName_CS11 =Excel_data.get("Port_Name");
		String Change_Terminal_Button_CS11 =Excel_data.get("Button");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		String terminal_Search_Header = Excel_data.get("Terminal_Search_Header");

		
		String future_Voyage = String.format(Coastal_Schedule_Locators.futureVoyage, voyageNumber_CS11);
		String future_VoyageToggler = String.format(Coastal_Schedule_Locators.futureVoyage_Toggler, voyageNumber_CS11);
		String future_VoyagePort = String.format(Coastal_Schedule_Locators.futureVoyage_Port, portName_CS11,portName_CS11);

		String  Voyage_Toggler = String.format(Coastal_Schedule_Locators.voyageToggler, voyageNumber_CS11);
		String  terminal_Change = String.format(Coastal_Schedule_Locators.terminalChangeOption, Change_Terminal_Button_CS11);
		String  Port_Select = String.format(Coastal_Schedule_Locators.port_Select, voyageNumber_CS11,portName_CS11);

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		
		LRP_Login(driver, Username_CS11, Password_CS11);
		
		moduleNavigate(driver, ModuleSearch_CS11);

		Step_Start(1, "Enter the Service Code  in the service code field", test, test1);
		
		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS11);
		
		Step_End(1, "Enter the Service Code  in the service code field", test, test1);

		Step_Start(2, "Enter the Vessel ", test, test1);
		

		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS11);

		Step_End(2, "Enter the Vessel ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForDisplay(driver, Tree_Structure);
		if(isdisplayed(driver,Tree_Structure)) {
			Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
			System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
		}else {
			System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

			Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
		}
		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForElement(driver, Voyage_Toggler);
		String status = getAttribute(driver, Voyage_Toggler, "class");
		if(!status.contains("s")) {
			click(driver, Voyage_Toggler);
		}

		waitForElement(driver, Port_Select);
		click(driver, Port_Select);

		Step_Start(4, "Right click on the port where the terminal has to be Renamed", test, test1);
		waitForElement(driver, Port_Select);
		RightClick(driver, Port_Select);

		Step_End(4, "Right click on the port where the terminal has to be Renamed", test, test1);

		Step_Start(5, "Choose Rename Terminal", test, test1);
		waitForElement(driver, terminal_Change);
		click(driver, terminal_Change);

		waitForElement(driver, Terminal_Search_Btn);
		click(driver,Terminal_Search_Btn);

		twoColumnSearchWindow(driver, terminal_Search_Header, condition, TerminalInput);

		Step_End(5, "Choose Rename Terminal", test, test1);

		Step_Start(6, "Choose Future Voyages", test, test1);
		Step_Start(7, "If the Terminal Should be renamed for all the future cycle of the same port in the same vessel ", test, test1);
		if(Change_Future_Voyages.equalsIgnoreCase("Yes")) {
			waitForElement(driver, Current_Voyage_Btn);

			if(isElementAccessible(driver, futureVoyage_Button)) {
				click(driver, Future_Voyage_Btn);
				System.out.println("Matched || Expected : Future Voyage Button should be Enabled || Actual :  Future Voyage Button Is Enabled");
				Extent_pass_New(driver, "Matched || Expected : Future Voyage Button should be Enabled || Actual :  Future Voyage Button Is Enabled", test, test1);

			}else {
				System.out.println("Not Matched || Expected : Future Voyage Button should be Enabled || Actual :  Future Voyage Button Is  Disabled");
				Extent_fail(driver, "Not Matched || Expected : Future Voyage Button should be Enabled || Actual :  Future Voyage Button Is Disabled", test, test1);
			}
			waitForElement(driver, Termial_Change_Ok);
			click(driver,Termial_Change_Ok);
			waitForPopup(driver, popup_Message, FutureTerminalRenamed);
			String Terminal_Popup= getText(driver, popup_Message);
			if(Terminal_Popup.equals(FutureTerminalRenamed)) {
				System.out.println("Matched || Expected Popup : "+FutureTerminalRenamed+" || Actual Popup : "+Terminal_Popup);
				Extent_pass_New(driver, "Matched || Expected Popup : "+FutureTerminalRenamed+" || Actual Popup : "+Terminal_Popup, test,test1);
			}else {
				System.out.println("NotMatched || Expected Popup : "+FutureTerminalRenamed+" || Actual Popup : "+Terminal_Popup);
				Extent_fail(driver,  "NotMatched || Expected Popup : "+FutureTerminalRenamed+" || Actual Popup : "+Terminal_Popup, test,test1);
			}

			Step_End(6, "Choose Future Voyages", test, test1);

			click(driver,popup_Message_Ok_Button);


			waitForElement(driver, Voyage_Toggler);
			String status1 = getAttribute(driver, Voyage_Toggler, "class");
			if(!status1.contains("s")) {
				click(driver, Voyage_Toggler);
			}
			waitForElement(driver, Port_Select);					
			String terminal = getText(driver, Port_Select);
			if(terminal.contains(TerminalInput)) {
				System.out.println("Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal);
				Extent_pass_New(driver, "Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal, test,test1);
			}else {
				System.out.println("NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal);
				Extent_fail(driver, "NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal, test,test1);
			}
			waitForElement(driver, Tree_Structure);

			if(isDisplayed(driver, future_Voyage)) {
				String status2 = getAttribute(driver, future_VoyageToggler, "class");
				if(!status2.contains("s")) {
					click(driver, future_VoyageToggler);
				}
				waitForElement(driver, future_VoyagePort);
				String terminal1 = getText(driver, future_VoyagePort);
				if(terminal1.contains(TerminalInput)) {
					System.out.println("Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1);
					Extent_pass_New(driver, "Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1, test,test1);
				}else {
					System.out.println("NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1);
					Extent_fail(driver, "NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1, test,test1);
				}
			}
			Step_End(7, "If the Terminal Should be renamed for all the future cycle of the same port in the same vessel ", test, test1);

		}
		else {
			Step_Start(8, "Choose Current voyage ", test, test1);
			Step_Start(9, "If ther terminal should only be renamed for the current voyage", test, test1);
			waitForElement(driver, Current_Voyage_Btn);
			click(driver,Current_Voyage_Btn);
			waitForElement(driver, Termial_Change_Ok);
			click(driver,Termial_Change_Ok);
			waitForPopup(driver, popup_Message, CurrentTerminalRenamed);
			String Terminal_Popup= getText(driver, popup_Message);
			if(Terminal_Popup.equals(CurrentTerminalRenamed)) {
				System.out.println("Matched || Expected Popup : "+CurrentTerminalRenamed+" || Actual Popup : "+Terminal_Popup);
				Extent_pass_New(driver, "Matched || Expected Popup : "+CurrentTerminalRenamed+" || Actual Popup : "+Terminal_Popup, test,test1);
			}else {
				System.out.println("NotMatched || Expected Popup : "+CurrentTerminalRenamed+" || Actual Popup : "+Terminal_Popup);
				Extent_fail(driver,  "NotMatched || Expected Popup : "+CurrentTerminalRenamed+" || Actual Popup : "+Terminal_Popup, test,test1);
			}
			Step_End(8, "Choose Current voyage ", test, test1);
			Step_End(9, "If ther terminal should only be renamed for the current voyage", test, test1);

			click(driver,popup_Message_Ok_Button);
			
			waitForElement(driver, Tree_Structure);
			String status3 = getAttribute(driver, Voyage_Toggler, "class");
			if(!status3.contains("s")) {
				click(driver, Voyage_Toggler);
			}
			waitForElement(driver, Port_Select);
			String terminal = getText(driver, Port_Select);
			if(terminal.contains(TerminalInput)) {
				System.out.println("Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal);
				Extent_pass_New(driver, "Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal, test,test1);
			}else {
				System.out.println("NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal);
				Extent_fail(driver, "NotMatched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal, test,test1);
			}					

			waitForElement(driver, Tree_Structure);

			if(isDisplayed(driver, future_Voyage)) {
				String status2 = getAttribute(driver, future_VoyageToggler, "class");
				if(!status2.contains("s")) {
					click(driver, future_VoyageToggler);
				}
				waitForElement(driver, future_VoyagePort);
				String terminal1 = getText(driver, future_VoyagePort);
				if(!terminal1.contains(TerminalInput)) {
					System.out.println("Not Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1);
					Extent_pass_New(driver, "Not Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1, test,test1);
				}else {
					System.out.println("Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1);
					Extent_fail(driver, "Matched || Expected Terminal : "+TerminalInput+" || Actual Terminal : "+terminal1, test,test1);
				}
			}

		} 
		Extent_completed(testCaseName, test, test1);

	}

}
