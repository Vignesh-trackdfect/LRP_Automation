package LRP_VSS_Consolidation_Scripts;


import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.Coastal_Schedule_Locators;

public class TC_CoastalSchedule_CS4ToCS6 extends Keywords{

	public void CoastalSchedule_CS4ToCS6(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset) {
		int a=1;

		if(a==1) {
			String testCaseName="TC_Coastal_Schedule_CS04";
			String File_Path_CS04 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_CS04 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
			String url = TestNgXml.getdatafromExecution().get(testCaseName);
			Map<String, String> Excel_data_04 = Utils.GetAllData(Sheet_Name_CS04, testCaseName, "Dataset"+selected_dataset, File_Path_CS04);

			String Popforupdate = Excel_data_04.get( "PopForUpdated");
			String Username_CS04 =Excel_data_04.get("Username");
			String Password_CS04 =Excel_data_04.get("Password");
			String ModuleSearch_CS04 =Excel_data_04.get("Module_Search");
			String ServiceCode_CS04 =Excel_data_04.get("Service_Code"); 
			String VesselCode_CS04 =Excel_data_04.get("Vessel_Code");
			String voyageNumber_CS04 =Excel_data_04.get("Voyage_Number");
			String portName_CS04 =Excel_data_04.get("Port_Name");
			String Remove_Voyage_page_Txt_CS04 = Excel_data_04.get("Remove_Voyage_page");
			String EnterReason_Popup_Exp_CS04= Excel_data_04.get("Enter_the_Reason_Popup");
			String enterReason_TxtField_Inuput_CS04= Excel_data_04.get("enterReason_TxtField_Inuput");
			String moveToCoastal_PopUp_Txt_Exp_CS04= Excel_data_04.get("MoveToCoastal_PopUp_Txt");
			String updateCoastal_PopUp_Exp_CS04= Excel_data_04.get("UpdateCoastal_PopUp");
			String remove_Button_CS04 =Excel_data_04.get("Button");
			String Select_Columns = Excel_data_04.get("Select_Columns");
			String table_Name = Excel_data_04.get("Table_Name");
			String condition = Excel_data_04.get("Condition");
			String service_Search_Header = Excel_data_04.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data_04.get("Vessel_Search_Header");


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
			String Remove_Element1 ="";
			for(int i =0;i<portNames.size();i++) {
				Remove_Element1=String.format(Coastal_Schedule_Locators.Remove_Element,portNames.get(i),portNames.get(i));
				waitForElement(driver, Remove_Element1);
				click(driver, Remove_Element1);
				
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
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}

		int b=2;

		if(b==2) {
			String testCaseName="TC_Coastal_Schedule_CS06";
			String File_Path_CS06 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_CS06 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
			Map<String, String> Excel_data_06 = Utils.GetAllData(Sheet_Name_CS06, testCaseName, "Dataset"+selected_dataset, File_Path_CS06);

			String permanentDeleteText=Excel_data_06.get("PermanentDeleteText");
			String ExpectedCA =Excel_data_06.get("ExpectedCA");
			String PermanentdelePopup=Excel_data_06.get("DeletedPopup");
			String ModuleSearch_CS06 =Excel_data_06.get("Module_Search");
			String ServiceCode_CS06 =Excel_data_06.get("Service_Code"); 
			String VesselCode_CS06 =Excel_data_06.get("Vessel_Code");
			String voyageNumber_CS06 =Excel_data_06.get("Voyage_Number");
			String portName_CS06 =Excel_data_06.get("Port_Name");
			String Remove_Voyage_page_Txt_CS06 = Excel_data_06.get("Remove_Voyage_page");
			String EnterReason_Popup_Exp_CS06= Excel_data_06.get("Enter_the_Reason_Popup");
			String enterReason_TxtField_Inuput_CS06= Excel_data_06.get("enterReason_TxtField_Inuput");
			String moveToCoastal_PopUp_Txt_Exp_CS06= Excel_data_06.get("MoveToCoastal_PopUp_Txt");
			String updateCoastal_PopUp_Exp_CS06= Excel_data_06.get("UpdateCoastal_PopUp");
			String remove_Button_CS06 =Excel_data_06.get("Button");
			String Per_Delete_Btn_CS06 =Excel_data_06.get("Per_Delete_Btn");
			String RollBack_CS06 =Excel_data_06.get("Do_You_Want_Rollback");
			String add_Button_CS06 =Excel_data_06.get("Add_Button");
			String speed_Pre_port= Excel_data_06.get("Speed_Pre_port");
			String distance_nextport= Excel_data_06.get("distance_nextport");
			String condition = Excel_data_06.get("Condition");
			String service_Search_Header = Excel_data_06.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data_06.get("Vessel_Search_Header");
			String Cycle_Number = Excel_data_06.get("Cycle_Number");
			String Cycle_Search_Header = Excel_data_06.get("Cycle_Search_Header");



			String Voyage_Toggler =String.format(Coastal_Schedule_Locators.Voyage_Toggler, voyageNumber_CS06);
			String Port_Select =String.format(Coastal_Schedule_Locators.Port_Select6,voyageNumber_CS06,portName_CS06);
			String remove_Select =String.format(Coastal_Schedule_Locators.remove_Select,remove_Button_CS06);
			String port_select =String.format(Coastal_Schedule_Locators.port_select6,portName_CS06);
			String Voyage =String.format(Coastal_Schedule_Locators.Voyage6,voyageNumber_CS06);
			String Permenent_Delete = String.format(Coastal_Schedule_Locators.Permenent_Delete,Per_Delete_Btn_CS06);
			String Select_Port = String.format(Coastal_Schedule_Locators.Select_Port6,portName_CS06);
			String button_Select =String.format(Coastal_Schedule_Locators.button_Select6,add_Button_CS06);

			Extent_Start(testCaseName, test, test1);

			
			moduleNavigate(driver, ModuleSearch_CS06);
			
			
			Step_Start(1, "Enter the Service Code in the service code field", test, test1);

			waitForElement(driver, Service_Search_Btn);
			click(driver, Service_Search_Btn);
			
			twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS06);
			
			Step_End(1, "Enter the Service Code in the service code field", test, test1);

			Step_Start(2, "Enter the Vessel ", test, test1);

			waitForElement(driver, Vessel_Search_Btn);
			click(driver, Vessel_Search_Btn);

			twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS06);
			
			Step_End(2, "Enter the Vessel ", test, test1);

			Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			waitForDisplay(driver, Tree_Structure);
			if(isdisplayed(driver,Tree_Structure)) {
				Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
				System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
			}else {
				System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

				Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
			}
			Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
			Step_Start(4, "Choose the first voyage", test, test1);
			waitForElement(driver, Voyage_Toggler);
			String status = getAttribute(driver, Voyage_Toggler, "class");
			if(!status.contains("s")) {
				click(driver, Voyage_Toggler);
			}
			Step_End(4, "Choose the first voyage", test, test1);
			Step_Start(5, "click on the port after which the port needed to be Removed from the voyage ", test, test1);
			waitForElement(driver, Port_Select);
			click(driver, Port_Select);	

			Step_End(5, "click on the port after which the port needed to be Removed from the voyage ", test, test1);
			Step_Start(6,"Right click on it ", test, test1);
			waitForElement(driver, Port_Select);
			RightClick(driver, Port_Select);
			Step_End(6,"Right click on it ", test, test1);
			Step_Start(7, "Choose Remove(Omit) Option from the menu ", test, test1);
			waitForElement(driver, remove_Select);
			click(driver, remove_Select);
			Step_End(7, "Choose Remove(Omit) Option from the menu ", test, test1);
			Step_Start(8, "Remove(omit) window appears", test, test1);


			waitForElement(driver, remove_Voyage_Page);
			String text=getText(driver, remove_Voyage_Page);
			if(Remove_Voyage_page_Txt_CS06.equals(text)) {

				System.out.println("Matched || " + " Expected Text is : " + Remove_Voyage_page_Txt_CS06 + " || Actual Text is : " + text);
				Extent_pass_New(driver, "Matched || " + " Expected Text is : " + Remove_Voyage_page_Txt_CS06 + " || Actual Text is : " + text, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Text is : " + Remove_Voyage_page_Txt_CS06 + " || Actual Text is : " + text);
				Extent_fail(driver, "Not Matched || " + " Expected Text is : " + Remove_Voyage_page_Txt_CS06 + " || Actual Text is : " + text, test,test1);
			}

			Step_End(8, "Remove(omit) window appears", test, test1);

			Step_Start(9, "Select the port row that needed to be removed", test, test1);
			waitForElement(driver, Remove_Element);
			click(driver, Remove_Element);

			Step_End(9, "Select the port row that needed to be removed", test, test1);
			Step_Start(10, "click on Remove button", test, test1);

			waitForElement(driver, remove_Voyage_Page_Btn);
			click(driver, remove_Voyage_Page_Btn);

			waitForPopup(driver, enterReason_PopUP, EnterReason_Popup_Exp_CS06);
			String reasonPopupText=getText(driver, enterReason_PopUP);
			if(EnterReason_Popup_Exp_CS06.equals(reasonPopupText)) {
				System.out.println("Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS06 + " || Actual Popup is : " + reasonPopupText);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS06 + " || Actual Popup is : " + reasonPopupText, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS06 + " || Actual Popup is : " + reasonPopupText);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS06 + " || Actual Popup is : " + reasonPopupText, test,test1);
			}
			waitForElement(driver, enterReason_TxtField);
			sendKeys(driver, enterReason_TxtField, enterReason_TxtField_Inuput_CS06);
			waitForElement(driver, enterReason_OkBtn);
			click(driver, enterReason_OkBtn);
			elementnotvisible(driver, enterReason_OkBtn);
			Step_End(10, "click on Remove button", test, test1);
			Step_Start(12, "click on Move to Coastal Schedule button", test, test1);
			waitForElement(driver, moveTOCoastalSchedule_Btn);
			click(driver, moveTOCoastalSchedule_Btn);
			
			Step_End(12, "click on Move to Coastal Schedule button", test, test1);
			Step_Start(13, "System should remove the omitted port from the voyage", test, test1);

			waitForPopup(driver, popup_Message, moveToCoastal_PopUp_Txt_Exp_CS06);

			String moveToCostalMsg=getText(driver, popup_Message);
			if(moveToCoastal_PopUp_Txt_Exp_CS06.equals(moveToCostalMsg)) {
				click(driver, popup_Message_Yes_Button);
				System.out.println("Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS06 + " || Actual Popup is : " + moveToCostalMsg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS06 + " || Actual Popup is : " + moveToCostalMsg, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS06 + " || Actual Popup is : " + moveToCostalMsg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS06 + " || Actual Popup is : " + moveToCostalMsg, test,test1);
			}

			waitForPopup(driver, popup_Message, updateCoastal_PopUp_Exp_CS06);
			String updatePopupMsg=getText(driver, popup_Message);
			if(updateCoastal_PopUp_Exp_CS06.equals(updatePopupMsg)) {
				click(driver, popup_Message_Ok_Button);
				System.out.println("Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS06 + " || Actual Popup is : " + updatePopupMsg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS06 + " || Actual Popup is : " + updatePopupMsg, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS06 + " || Actual Popup is : " + updatePopupMsg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS06 + " || Actual Popup is : " + updatePopupMsg, test,test1);
			}
			Step_End(13, "System should remove the omitted port from the voyage", test, test1);
			waitForElement(driver, Voyage);
			click(driver, Voyage);
			Step_Start(14, "Right click either on the port or In the voyage", test, test1);
			waitForElement(driver, Voyage);
			RightClick(driver, Voyage);
			Step_End(14, "Right click either on the port or In the voyage", test, test1);
			Step_Start(15, "Choose permanently delete option from the menu", test, test1);
			waitForElement(driver, Permenent_Delete);
			click(driver, Permenent_Delete);
			Step_End(15, "Choose permanently delete option from the menu", test, test1);
			Step_Start(16, "Choose the voyage from From Voyage field ", test, test1);
			waitForElement(driver, permanentDeleteFrame);
			String frameText=getText(driver,permanentDeleteFrame);
			if(frameText.equals(permanentDeleteText)) {
				System.out.println("Matched || " + " Expected Text : " + permanentDeleteText + " || Actual Text : " + frameText);
				Extent_pass_New(driver,"Matched || " + " Expected Text : " + permanentDeleteText + " || ActualText : " + frameText,test,test1);
				Extent_pass_New(driver, "Permanent delete frame is displayed", test,test1);
				
				waitForElement(driver, fromVoyageSearchButton);
				click(driver, fromVoyageSearchButton);
				
				twoColumnSearchWindow(driver, Cycle_Search_Header, condition, Cycle_Number);

				Step_End(16, "Choose the voyage from From Voyage field", test, test1);
				Step_Start(17, "Choose To Voyage value", test, test1);
				waitForElement(driver, toVoyageSearchButton);
				click(driver, toVoyageSearchButton);
				
				twoColumnSearchWindow(driver, Cycle_Search_Header, condition, Cycle_Number);

				Step_End(17, "Choose To Voyage value", test, test1);
				Step_Start(18, "Click on Show deleted Calls", test, test1);
				waitForElement(driver, showDelCallsButton);
				click(driver, showDelCallsButton);
				Step_End(18, "Click on Show deleted Calls", test, test1);
				Step_Start(19, "System should list out the Deleted calls from the Voyage range selected in From and To voyage", test, test1);
				Step_Start(20, "Select the Port Row which needed to be deleted", test, test1);
				waitForElement(driver, port_select);
				click(driver, port_select);
				Step_End(19, "System should list out the Deleted calls from the Voyage range selected in From and To voyage", test, test1);
				Step_End(20, "Select the Port Row which needed to be deleted", test, test1);
				Step_Start(21, "Click on permanently delete button", test, test1);

				waitForElement(driver, permanentDelButton);
				click(driver, permanentDelButton);
				Step_End(21, "Click on permanently delete button", test, test1);
				Step_Start(22, "Now Clicking on the “Deleted(omit) calls “ button should not show the Omitted ports", test, test1);


				waitForPopup(driver, popup_Message, "Permanent delete");
				if(isdisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Yes_Button);
				}
			}else {
				System.out.println("Not matched || " + " Expected Text : " + permanentDeleteText + " || Actual Text : " + frameText+" || Permanent delete frame is not displayed");
				Extent_fail(driver,"Not matched || " + " Expected Text : " + permanentDeleteText + " || Actual Text : " + frameText+" || Permanent delete frame is not displayed",test,test1);
			}
			waitForPopup(driver, popup_Message, PermanentdelePopup);
			String actText=getText(driver, popup_Message);
			if(actText.equals(PermanentdelePopup)) {
				System.out.println("Matched || " + " Expected Popup : " + PermanentdelePopup + " || Actual Popup : " + actText);
				Extent_pass_New(driver,"Matched || " + " Expected Popup : " + PermanentdelePopup + " || ActualPopup : " + actText,test,test1);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not matched || " + " Expected Popup : " + PermanentdelePopup + " || Actual Value  is : " + actText+" || Selected Call(s) Deleted. popup is not displayed");
				Extent_fail(driver,"Not matched || " + " Expected Popup : " + PermanentdelePopup + " || Actual Popup : " + actText+" || Selected Call(s) Deleted. popup is not displayed",test,test1);
			}
			Step_End(22, "Now Clicking on the “Deleted(omit) calls “ button should not show the Omitted ports", test, test1);

			if(RollBack_CS06.equalsIgnoreCase("Yes")) {

				waitForElement(driver, Voyage);
				click(driver, Voyage);
				waitForElement(driver, Voyage);
				RightClick(driver, Voyage);
				waitForElement(driver, button_Select);
				click(driver, button_Select);

				waitForElement(driver, Select_Port);
				click(driver, Select_Port);
				waitForElement(driver, Roll_Back_Btn);
				click(driver, Roll_Back_Btn);

				waitForElement(driver,speed_PreviousPort_P);
				if(isClickable(driver, speed_PreviousPort_P)) {
					click(driver,speed_PreviousPort_P);
					waitForElement(driver,speed_PreviousPort_P);
					clear(driver,speed_PreviousPort_P);
					sendKeys(driver, speed_PreviousPort_P, speed_Pre_port);
					
				}
				waitForElement(driver,distance_NextPort_P);
				if(isClickable(driver, distance_NextPort_P)) {
					click(driver,distance_NextPort_P);
					waitForElement(driver,distance_NextPort_P);
					clear(driver,distance_NextPort_P);
					sendKeys(driver, distance_NextPort_P, distance_nextport);
					
				}
				waitForElement(driver, Coastal_Schedule_Move);
				click(driver,Coastal_Schedule_Move);
				waitForDisplay(driver, popup_Message_Yes_Button);
				if(isdisplayed(driver, popup_Message_Yes_Button)) {
					click(driver, popup_Message_Yes_Button);
				}
				waitForPopup(driver, popup_Message, ExpectedCA);
					String ActualCA = getText(driver,popup_Message);
					System.out.println(ExpectedCA);
					System.out.println(ActualCA);
					if(ExpectedCA.equals(ActualCA)) {
						System.out.println("Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
						Extent_pass_New(driver, "Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
						click(driver,popup_Message_Ok_Button);

					}else {
						System.out.println("NotMatched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
						Extent_fail(driver,  "NotMatched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
					}
				}

				
				scrollTop(driver);

				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			
			Extent_completed(testCaseName, test, test1);
			
		}
	}
}
