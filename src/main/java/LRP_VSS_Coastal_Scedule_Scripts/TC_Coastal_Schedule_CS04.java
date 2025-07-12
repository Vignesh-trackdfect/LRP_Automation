package LRP_VSS_Coastal_Scedule_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS04 extends Keywords {

	public void Coastal_Schedule_CS04(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS04";

		String Popforupdate = Excel_data.get( "PopForUpdated");
		String Username_CS04 =Excel_data.get("Username");
		String Password_CS04 =Excel_data.get("Password");
		String ModuleSearch_CS04 =Excel_data.get("Module_Search");
		String ServiceCode_CS04 =Excel_data.get("Service_Code"); 
		String VesselCode_CS04 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS04 =Excel_data.get("Voyage_Number");
		String portName_CS04 =Excel_data.get("Port_Name");
		String Remove_Voyage_page_Txt_CS04 = Excel_data.get("Remove_Voyage_page");
		String EnterReason_Popup_Exp_CS04= Excel_data.get("Enter_the_Reason_Popup");
		String enterReason_TxtField_Inuput_CS04= Excel_data.get("enterReason_TxtField_Inuput");
		String moveToCoastal_PopUp_Txt_Exp_CS04= Excel_data.get("MoveToCoastal_PopUp_Txt");
		String updateCoastal_PopUp_Exp_CS04= Excel_data.get("UpdateCoastal_PopUp");
		String remove_Button_CS04 =Excel_data.get("Button");
		String Select_Columns = Excel_data.get("Select_Columns");
		String table_Name = Excel_data.get("Table_Name");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");


		String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler7,voyageNumber_CS04);
		String Add_Select = String.format(Coastal_Schedule_Locators.Add_Select,remove_Button_CS04);

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username_CS04, Password_CS04);

		moduleNavigate(driver, ModuleSearch_CS04);

		Step_Start(1, "Enter the Service Code in the service code field", test, test1);

		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);

		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS04);

		Step_End(1, "Enter the Service Code in the service code field", test, test1);

		Step_Start(2, "Enter the Vessel ", test, test1);

		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS04);

		Step_End(2, "Enter the Vessel ", test, test1);

		Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Tree_Structure);
		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

		Step_Start(4, "Choose the first voyage", test, test1);
		waitForElement(driver, Voyage_Toggler);
		String status = getAttribute(driver, Voyage_Toggler, "class");
		if(!status.contains("s")) {
			click(driver, Voyage_Toggler);
		}
		Step_End(4, "Choose the first voyage", test, test1);
		formatLocatorClick(driver, VoyageFirstPortValue, voyageNumber_CS04);
		waitForElement(driver, AG_Grid_First_Port);
		doubleClick(driver, AG_Grid_First_Port);


		waitForDisplay(driver, AG_Grid_Columns_Button);
		if(!isdisplayed(driver, AG_Grid_Columns_Button)){
			waitForElement(driver, next_row_Select);
			doubleClick(driver, next_row_Select);
		}
		waitForDisplay(driver, VoyageDetails_Temp_Remove);
		if(isdisplayed(driver, VoyageDetails_Temp_Remove)){
			waitForElement(driver, VoyageDetails_Temp_Remove);
			click(driver, VoyageDetails_Temp_Remove);
		}

		reArrangeAG_GridColumns_VoyageWindow(driver, Select_Columns);

		List<String> columns = splitAndExpand(Select_Columns);


		waitForElement(driver, edit_Grid_Total_Records);
		String getTotalRecords=getText(driver, edit_Grid_Total_Records);
		int row_Count=Integer.parseInt(getTotalRecords);

		List<Map<String, String>> voyage_Details_Before = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String voyage_Details_before=TableDataForReport(driver, voyage_Details_Before, table_Name, columns);

		waitForElement(driver, Voyage_Details_Close_Button);
		click(driver, Voyage_Details_Close_Button);
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}
		Step_Start(5, "CLick on the port after which the port needed to be Removed from the voyage ", test, test1);
		
		waitForElement(driver, Voyage_Toggler);
		waitForElement(driver, Voyage_Toggler);

		 status = getAttribute(driver, Voyage_Toggler, "class");
		if(!status.contains("s")) {
			click(driver, Voyage_Toggler);
		}
		formatLocatorClick(driver, VoyageFirstPortValue, voyageNumber_CS04);


		Step_End(5, "CLick on the port after which the port needed to be Removed from the voyage ", test, test1);
		Step_Start(6,"Right click on it ", test, test1);
	
		formatRightClick(driver, VoyageFirstPortValue, voyageNumber_CS04);
		Step_End(6,"Right click on it ", test, test1);
		Step_Start(7, "Choose Remove(Omit) Option from the menu ", test, test1);
		waitForElement(driver, Add_Select);
		scrollUsingElement(driver, Add_Select);
		click(driver, Add_Select);
		Step_End(7, "Choose Remove(Omit) Option from the menu ", test, test1);
		Step_Start(8, "Remove(omit) window appears", test, test1);

		waitForElement(driver, remove_Voyage_Page);
		String text=getText(driver, remove_Voyage_Page);
		if(Remove_Voyage_page_Txt_CS04.equals(text)) {
			System.out.println("Matched || " + " Expected  Popup : " + Remove_Voyage_page_Txt_CS04 + " || Actual  Popup : " + text);
			Extent_pass_New(driver, "Matched || " + " Expected  Popup : " + Remove_Voyage_page_Txt_CS04 + " || Actual  Popup : " + text, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected  Popup : " + Remove_Voyage_page_Txt_CS04 + " || Actual  Popup : " + text);
			Extent_fail(driver, "Not Matched || " + " Expected  Popup : " + Remove_Voyage_page_Txt_CS04 + " || Actual  Popup : " + text, test,test1);
		}

		Step_End(8, "Remove(omit) window appears", test, test1);

		Step_Start(9, "Select the port row that needed to be removed", test, test1);
		Actions action = new Actions(driver);
		boolean click=false;
		List<String> portNames = splitAndExpand(portName_CS04, ",");
		String Remove_Element ="";
		for(int i =0;i<portNames.size();i++) {
			Remove_Element=String.format(Coastal_Schedule_Locators.Remove_Element,portNames.get(i),portNames.get(i));
			waitForElement(driver, Remove_Element);
			click(driver, Remove_Element);
			
			if(click==false) {
			action.keyDown(Keys.SHIFT).build().perform();
			click=true;
			}
		}
		action.keyUp(Keys.SHIFT).build().perform();
		Step_End(9, "Select the port row that needed to be removed", test, test1);
		Step_Start(10, "Click on Remove button", test, test1);

		waitForElement(driver, remove_Voyage_Page_Btn);
		click(driver, remove_Voyage_Page_Btn);

		waitForPopup(driver, enterReason_PopUP, EnterReason_Popup_Exp_CS04);
		String reasonPopupText=getText(driver, enterReason_PopUP);
		if(EnterReason_Popup_Exp_CS04.equals(reasonPopupText)) {
			System.out.println("Matched || " + " Expected Popup : " + EnterReason_Popup_Exp_CS04 + " || Actual Popup : " + reasonPopupText);
			Extent_pass_New(driver, "Matched || " + " Expected Popup : " + EnterReason_Popup_Exp_CS04 + " || Actual Popup : " + reasonPopupText, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected Popup : " + EnterReason_Popup_Exp_CS04 + " || Actual Popup : " + reasonPopupText);
			Extent_fail(driver, "Not Matched || " + " Expected Popup : " + EnterReason_Popup_Exp_CS04 + " || Actual Popup : " + reasonPopupText, test,test1);
		}
		waitForElement(driver, enterReason_TxtField);
		sendKeys(driver, enterReason_TxtField, enterReason_TxtField_Inuput_CS04);
		waitForElement(driver, enterReason_OkBtn);
		click(driver, enterReason_OkBtn);
		elementnotvisible(driver, enterReason_OkBtn);
		Step_End(10, "Click on Remove button", test, test1);


		Step_Start(12, "Click on Move to Coastal Schedule button", test, test1);
		waitForElement(driver, moveTOCoastalSchedule_Btn);
		click(driver, moveTOCoastalSchedule_Btn);

		Step_End(12, "Click on Move to Coastal Schedule button", test, test1);
		Step_Start(13, "System should remove the omitted port from the voyage", test, test1);

		waitForPopup(driver, popup_Message, moveToCoastal_PopUp_Txt_Exp_CS04);
		String moveToCostalMsg=getText(driver, popup_Message);
		if(moveToCoastal_PopUp_Txt_Exp_CS04.equals(moveToCostalMsg)) {
			click(driver, popup_Message_Yes_Button);
			System.out.println("Matched || " + " Expected  Popup : " + moveToCoastal_PopUp_Txt_Exp_CS04 + " || Actual  Popup : " + moveToCostalMsg);
			Extent_pass_New(driver, "Matched || " + " Expected  Popup : " + moveToCoastal_PopUp_Txt_Exp_CS04 + " || Actual  Popup : " + moveToCostalMsg, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected  Popup : " + moveToCoastal_PopUp_Txt_Exp_CS04 + " || Actual  Popup : " + moveToCostalMsg);
			Extent_fail(driver, "Not Matched || " + " Expected  Popup : " + moveToCoastal_PopUp_Txt_Exp_CS04 + " || Actual  Popup : " + moveToCostalMsg, test,test1);
		}

		waitForPopup(driver, popup_Message, updateCoastal_PopUp_Exp_CS04);
		String updatePopupMsg=getText(driver, popup_Message);
		if(updateCoastal_PopUp_Exp_CS04.equals(updatePopupMsg)) {
			click(driver, popup_Message_Ok_Button);
			System.out.println("Matched || " + " Expected  Popup : " + updateCoastal_PopUp_Exp_CS04 + " || Actual  Popup : " + updatePopupMsg);
			Extent_pass_New(driver, "Matched || " + " Expected  Popup : " + updateCoastal_PopUp_Exp_CS04 + " || Actual  Popup : " + updatePopupMsg, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected  Popup : " + updateCoastal_PopUp_Exp_CS04 + " || Actual  Popup : " + updatePopupMsg);
			Extent_fail(driver, "Not Matched || " + " Expected  Popup : " + updateCoastal_PopUp_Exp_CS04 + " || Actual  Popup : " + updatePopupMsg, test,test1);
		}
		Step_End(13, "System should remove the omitted port from the voyage", test, test1);

		Step_Start(14, "Adjust the next port(s) dates ", test, test1);
		
		waitForElement(driver, Voyage_Toggler);
		 status = getAttribute(driver, Voyage_Toggler, "class");
		if(!status.contains("s")) {
			click(driver, Voyage_Toggler);
		}
		
		formatLocatorClick(driver, VoyageFirstPortValue, voyageNumber_CS04);

		waitForElement(driver, AG_Grid_First_Port);
		doubleClick(driver, AG_Grid_First_Port);


		waitForDisplay(driver, AG_Grid_Columns_Button);
		if(!isdisplayed(driver, AG_Grid_Columns_Button)){
			waitForElement(driver, next_row_Select);
			doubleClick(driver, next_row_Select);
		}
		waitForDisplay(driver, VoyageDetails_Temp_Remove);
		if(isdisplayed(driver, VoyageDetails_Temp_Remove)){
			waitForElement(driver, VoyageDetails_Temp_Remove);
			click(driver, VoyageDetails_Temp_Remove);
		}

		reArrangeAG_GridColumns_VoyageWindow(driver, Select_Columns);

		getTotalRecords=getText(driver, edit_Grid_Total_Records);
		row_Count=Integer.parseInt(getTotalRecords);

		waitForElement(driver, Voyage_Details_Table);

		List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String voyage_Details_after=TableDataForReport(driver, voyage_Details_After, table_Name, columns);
		if (!voyage_Details_Before.equals(voyage_Details_After)) {
			Extent_pass_New(driver, " Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
		} else {
			Extent_fail(driver,
					" Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
		}
		waitForElement(driver, Movetocoastal);
		click(driver, Movetocoastal);
		
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			
		}
		
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}
		waitForPopup(driver, popup_Message, Popforupdate);
		String Pop = getText(driver, popup_Message);
		System.out.println(Pop);
		if (Popforupdate.equals(Pop)) {
			System.out.println(
					"Matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop);
			Extent_pass_New(driver,
					"Matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop,
					test,test1);
		} else {
			System.out.println(
					"Not matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop);
			Extent_fail(driver,
					"Not matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop,
					test,test1);
		}
		click(driver, popup_Message_Ok_Button);

		
		Step_End(14, "Adjust the next port(s) dates ", test, test1);
		Extent_completed(testCaseName, test, test1);
	}

}
