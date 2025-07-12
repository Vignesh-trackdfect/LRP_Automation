package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_008 extends Keywords{
	public void Delivery_Order_TS_008(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_008";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String globalSearch_Number=Excel_data.get("GlobalSearch_Number");
		String module_Delivery_Order = Excel_data.get("module_Delivery_Order");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String terminalName = Excel_data.get("TerminalName");
		String DO_UpdatedPopup = Excel_data.get("DO_UpdatedPopup");
		String clearingAgentName = Excel_data.get("ClearingAgentName");
		String depotName = Excel_data.get("DepotName");
		String status_Filer_Data = Excel_data.get("Status_Filer_Data");
		String globalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String doStatus = Excel_data.get("DO_Status");
		String Terminal_Search_Column_Header = Excel_data.get("Terminal_Search_Column_Header");
		String ClearingAgentName_Search_Column_Header = Excel_data.get("ClearingAgentName_Search_Column_Header");
		String EmptyReturnDepot_Search_Column_Header = Excel_data.get("EmptyReturnDepot_Search_Column_Header");
		String Condition = Excel_data.get("Condition");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		Step_Start(2, "open Delivery order Module, click the search button from tool bar", test, test1);
		moduleNavigate(driver, module_Delivery_Order);
		Step_End(2, "open Delivery order Module, click the search button from tool bar", test, test1);
		Step_Start(3, "Paste the BLnumber and click on \"\"Select\"\"", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
		Step_Start(4, "Double click on the selected grid", test, test1);
		globalValueSearchWindowScrollAndSelect(driver,status_Filter_DO,status_Filer_Data);
		Step_End(4, "Double click on the selected grid", test, test1);
		Step_End(3, "Paste the BLnumber and click on \"\"Select\"\"", test, test1);
		Step_Start(5, "Capture the Delivery order status  in Delivery Order module", test, test1);
		waitForElement(driver, DO_Status);
		String actual_Do_Status=getText(driver, DO_Status);
		if(actual_Do_Status.contains(doStatus)) {
			Extent_pass_New(driver, "Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status, test, test1);
			System.out.println("Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status);
		}else {
			System.out.println("Not Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status);
			Extent_fail(driver, "Not Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status, test, test1);
		}
		Step_End(5, "Capture the Delivery order status  in Delivery Order module", test, test1);
		Step_Start(6, "Click Edit on tool bar and  click release terminal search icon from Delivery Order", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, releaseTerminal_SearchButton);
		click(driver, releaseTerminal_SearchButton);
		Step_End(6, "Click Edit on tool bar and  click release terminal search icon from Delivery Order", test, test1);
		Step_Start(7, "select the terminal and click on Select", test, test1);
		twoColumnSearchWindow(driver, Terminal_Search_Column_Header, Condition, terminalName);
		Step_End(7, "select the terminal and click on Select", test, test1);
		Step_Start(8, "Click Name of Clearing Agent search option, select the particular row from the grid", test, test1);
		waitForElement(driver, nameOfClearingAgent_SearchButton);
		click(driver, nameOfClearingAgent_SearchButton);
		Step_End(8, "Click Name of Clearing Agent search option, select the particular row from the grid", test, test1);
		Step_Start(9, "select the clearing agent", test, test1);
		twoColumnSearchWindow(driver, ClearingAgentName_Search_Column_Header, Condition, clearingAgentName);
		Step_End(9, "select the clearing agent", test, test1);
		Step_Start(10, "Click the empty return depot search", test, test1);
		waitForElement(driver, emptyReturnDepot_SearchButton);
		click(driver, emptyReturnDepot_SearchButton);
		Step_End(10, "Click the empty return depot search", test, test1);
		Step_Start(11, "Select the depot and click save", test, test1);
		twoColumnSearchWindow(driver, EmptyReturnDepot_Search_Column_Header, Condition, depotName);
		scrollTop(driver);		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(11, "Select the depot and click save", test, test1);
		Step_Start(12, "Capture the validation \"\" Delivery order updated \"\" and copy the \"\"Release Terminal\"\", \"\"Name of Clearing Agent\"\" and \"\"Empty return depot detail\"\"", test, test1);
		waitForPopup(driver,Popup_Message,DO_UpdatedPopup);
		String actual_Popup = getText(driver, Popup_Message);
		if (actual_Popup.equals(DO_UpdatedPopup)) {
			System.out.println("Matched || Expected Delivery Order Pop-up value is : " + DO_UpdatedPopup + " || Actual Delivery Order Pop-up value is : " + actual_Popup);
			Extent_pass_New(driver,"Matched || Expected Delivery Order Pop-up value is : " + DO_UpdatedPopup + " || Actual Delivery Order Pop-up value is : " + actual_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Delivery Order Pop-up value is : " + DO_UpdatedPopup + " || Actual Delivery Order Pop-up value is : " + actual_Popup);
			Extent_fail(driver,"Not Matched || Expected Delivery Order Pop-up value is : " + DO_UpdatedPopup + " || Actual Delivery Order Pop-up value is : " + actual_Popup,test, test1);
		}
		waitForElement(driver, releaseTerminal_Textfield);
		String actualReleaseTerminal=getAttribute(driver, releaseTerminal_Textfield, "value");
		String actualNameOfClearingAgent=getAttribute(driver, name_Of_Clearing_Agent_Textfield, "value");
		String actualEmptyReturnDepot=getAttribute(driver, emptyReturnDepot_Textfield, "value");
		if(actualReleaseTerminal.equals(terminalName)) {
			System.out.println("Matched || Expected Release Terminal : "+terminalName+" || Actual Release Terminal : "+actualReleaseTerminal);
			Extent_pass_New(driver, "Matched || Expected Release Terminal : "+terminalName+" || Actual Release Terminal : "+actualReleaseTerminal, test, test1);
		}else {
			System.out.println("Not Matched || Expected Release Terminal : "+terminalName+" || Actual Release Terminal : "+actualReleaseTerminal);
			Extent_fail(driver, "Not Matched || Expected Release Terminal : "+terminalName+" || Actual Release Terminal : "+actualReleaseTerminal, test, test1);
		}
		if(actualNameOfClearingAgent.equals(clearingAgentName)) {
			System.out.println("Matched || Expected Name Of Clearing Agent : "+clearingAgentName+" || Actual Name Of Clearing Agent : "+actualNameOfClearingAgent);
			Extent_pass_New(driver, "Matched || Expected Name Of Clearing Agent : "+clearingAgentName+" || Actual Name Of Clearing Agent : "+actualNameOfClearingAgent, test, test1);
		}else {
			System.out.println("Not Matched || Expected Name Of Clearing Agent : "+clearingAgentName+" || Actual Name Of Clearing Agent : "+actualNameOfClearingAgent);
			Extent_fail(driver, "Not Matched || Expected Name Of Clearing Agent : "+clearingAgentName+" || Actual Name Of Clearing Agent : "+actualNameOfClearingAgent, test, test1);
		}
		if(actualEmptyReturnDepot.equals(depotName)) {
			System.out.println("Matched || Expected Empty Return Depot : "+depotName+" || Actual Empty Return Depot : "+actualEmptyReturnDepot);
			Extent_pass_New(driver, "Matched || Expected Empty Return Depot : "+depotName+" || Actual Empty Return Depot : "+actualEmptyReturnDepot, test, test1);
		}else {
			System.out.println("Not Matched || Expected Empty Return Depot : "+depotName+" || Actual Empty Return Depot : "+actualEmptyReturnDepot);
			Extent_fail(driver, "Not Matched || Expected Empty Return Depot : "+depotName+" || Actual Empty Return Depot : "+actualEmptyReturnDepot, test, test1);
		}
		Step_End(12, "Capture the validation \"\" Delivery order updated \"\" and copy the \"\"Release Terminal\"\", \"\"Name of Clearing Agent\"\" and \"\"Empty return depot detail\"\"", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}