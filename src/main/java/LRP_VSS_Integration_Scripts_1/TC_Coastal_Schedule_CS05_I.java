package LRP_VSS_Integration_Scripts_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS05_I extends Keywords {

	public void coastalShedule05_I(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Coastal_Schedule_CS05_I";
		
		

		String search2 = Excel_data.get("Search_Input_2");
		String search3 = Excel_data.get("Search_Input_3");
		String Ports_Status = Excel_data.get("Ports_Status");

		String Popforupdate = Excel_data.get("PopForUpdated");
		String Username_CS05 =Excel_data.get("Username");
		String Password_CS05 =Excel_data.get("Password");
		String ModuleSearch_CS05 =Excel_data.get("Module_Search");
		String ServiceCode_CS05 =Excel_data.get("Service_Code"); 
		String VesselCode_CS05 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS05 =Excel_data.get("Voyage_Number");
		String portName_CS05 =Excel_data.get("Port_Name");
		String Remove_Voyage_page_Txt_CS05 = Excel_data.get("Remove_Voyage_page");
		String EnterReason_Popup_Exp_CS05= Excel_data.get("Enter_the_Reason_Popup");
		String enterReason_TxtField_Inuput_CS05= Excel_data.get("enterReason_TxtField_Inuput");
		String moveToCoastal_PopUp_Txt_Exp_CS05= Excel_data.get("MoveToCoastal_PopUp_Txt");
		String updateCoastal_PopUp_Exp_CS05= Excel_data.get("UpdateCoastal_PopUp");
		String removed_Port_Color_Txt_CS05= Excel_data.get("Removed_Port_Color");
		String remove_Button_CS05 =Excel_data.get("Button");
		String Roll_Back_Btn_CS05 =Excel_data.get("Roll_Back_Btn");
		String Remove_CS05 =Excel_data.get("Do_You_Want_Remove");
		String blackcolorcode_CS05=Excel_data.get("Blackcolor_Code");
		String Select_Columns = Excel_data.get("Select_Columns");
		String arr_Dock_Date = Excel_data.get("arr_Dock_Date");
		String Dept_Dock_Date = Excel_data.get("Dept_Dock_Date");
		String Dept_PilotDate = Excel_data.get("Dept_PilotDate");
		String arrPilotDate = Excel_data.get("ArrPilotDate");
		String date_Picker = Excel_data.get("date_Picker");
		String Time_Adjustment = Excel_data.get("Time_Adjustment");
		
		String table_Name = Excel_data.get("Table_Name");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String searchBy_From_Port = Excel_data.get("SearchBy_From_Port");
		String searchBy_To_Port = Excel_data.get("SearchBy_To_Port");
		String searchBy_Port = Excel_data.get("SearchBy_Port");

		String  Voyage_Toggler = String.format(Coastal_Schedule_Locators.voyageToggler, voyageNumber_CS05);
		String  Add_Select = String.format(Coastal_Schedule_Locators.addOption, remove_Button_CS05);
		String  Port_Select = String.format(Coastal_Schedule_Locators.port_Select, voyageNumber_CS05,portName_CS05);
		String Roll_Back = String.format(Coastal_Schedule_Locators.rollBack_Option, Roll_Back_Btn_CS05);
		String Next_Element = String.format(Coastal_Schedule_Locators.Next_Element, portName_CS05);
		String Previous_Element = String.format(Coastal_Schedule_Locators.Previous_Element,portName_CS05);
		String Remove_Element =String.format(Coastal_Schedule_Locators.removeElement, portName_CS05,portName_CS05);
		String element_Select = String.format(Coastal_Schedule_Locators.selectElement, portName_CS05,portName_CS05);
		String Voyage =  String.format(Coastal_Schedule_Locators.Voyage_Selec, voyageNumber_CS05);

		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		
		LRP_Login(driver, Username_CS05, Password_CS05);
		
		moduleNavigate(driver, ModuleSearch_CS05);
		

		Step_Start(1, "Enter the Service Code in the service code field", test, test1);
		
		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS05);
		
		Step_End(1, "Enter the Service Code in the service code field", test, test1);
		Step_Start(2, "Enter the Vessel ", test, test1);
		
		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS05);
		
		
		Step_End(2, "Enter the Vessel ", test, test1);
		Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Tree_Structure);
		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		if(Remove_CS05.equalsIgnoreCase("Yes")) {
			Step_Start(4, "Choose the first voyage", test, test1);
			waitForElement(driver, Voyage_Toggler);
			String status = getAttribute(driver, Voyage_Toggler, "class");
			if(!status.contains("s")) {
				click(driver, Voyage_Toggler);
			}
			Step_End(4, "Choose the first voyage", test, test1);
			Step_Start(5, "CLick on the port after which the port needed to be Removed from the voyage ", test, test1);
			waitForElement(driver, Port_Select);
			click(driver, Port_Select);	
			Step_End(5, "CLick on the port after which the port needed to be Removed from the voyage ", test, test1);
			Step_Start(6,"Right click on it ", test, test1);
			waitForElement(driver, Port_Select);
			RightClick(driver, Port_Select);
			Step_End(6,"Right click on it ", test, test1);
			Step_Start(7, "Choose Remove(Omit) Option from the menu ", test, test1);
			waitForElement(driver, Add_Select);
			click(driver, Add_Select);
			Step_End(7, "Choose Remove(Omit) Option from the menu ", test, test1);
			Step_Start(8, "Remove(omit) window appears", test, test1);

			waitForElement(driver, remove_Voyage_Page);
			String text=getText(driver, remove_Voyage_Page);
			if(Remove_Voyage_page_Txt_CS05.equals(text)) {

				System.out.println("Matched || " + " Expected window is : " + Remove_Voyage_page_Txt_CS05 + " || Actual window is : " + text);
				Extent_pass_New(driver, "Matched || " + " Expected window is : " + Remove_Voyage_page_Txt_CS05 + " || Actual window is : " + text, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected window is : " + Remove_Voyage_page_Txt_CS05 + " || Actual window is : " + text);
				Extent_fail(driver, "Not Matched || " + " Expected window is : " + Remove_Voyage_page_Txt_CS05 + " || Actual window is : " + text, test,test1);
			}
			Step_End(8, "Remove(omit) window appears", test, test1);
			Step_Start(9, "Select the port row that needed to be removed", test, test1);
			waitForElement(driver, Remove_Element);
			click(driver, Remove_Element);
			Step_End(9, "Select the port row that needed to be removed", test, test1);
			Step_Start(10, "Click on Remove button", test, test1);

			waitForElement(driver, remove_Voyage_Page_Btn);
			click(driver, remove_Voyage_Page_Btn);
			waitForPopup(driver, enterReason_PopUP, EnterReason_Popup_Exp_CS05);
			String reasonPopupText=getText(driver, enterReason_PopUP);
			if(EnterReason_Popup_Exp_CS05.equals(reasonPopupText)) {
				System.out.println("Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS05 + " || Actual Popup is : " + reasonPopupText);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS05 + " || Actual Popup is : " + reasonPopupText, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS05 + " || Actual Popup is : " + reasonPopupText);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS05 + " || Actual Popup is : " + reasonPopupText, test,test1);
			}
			waitForElement(driver, enterReason_TxtField);
			sendKeys(driver, enterReason_TxtField, enterReason_TxtField_Inuput_CS05);
			waitForElement(driver, enterReason_OkBtn);
			click(driver, enterReason_OkBtn);
			elementnotvisible(driver, enterReason_OkBtn);
			Step_End(10, "Click on Remove button", test, test1);
			waitForElement(driver, remove_Voyage_Page);
			if(isDisplayed(driver, Next_Element)) {
				click(driver, Next_Element);
				Step_Start(11, "The removed row should be change the font color to Red ", test, test1);
				waitForElement(driver, Remove_Element);
				String elementColor_Code=getTextColor(driver, Remove_Element);
				String elementColor=getColorName(elementColor_Code);
				if(removed_Port_Color_Txt_CS05.equalsIgnoreCase(elementColor)) {
					System.out.println("Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + elementColor);
					Extent_pass_New(driver, "Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + elementColor, test,test1);
				}
				else {
					System.out.println("Not Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + elementColor);
					Extent_fail(driver, "Not Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + elementColor, test,test1);
				}
				Step_End(11, "The removed row should be change the font color to Red ", test, test1);

			}else if(isDisplayed(driver, Previous_Element)){
				click(driver, Previous_Element);
				Step_Start(11, "The removed row should be change the font color to Red ", test, test1);
				waitForElement(driver, Remove_Element);
				String elementColor_Code=getTextColor(driver, Remove_Element);
				String elementColor=getColorName(elementColor_Code);
				if(removed_Port_Color_Txt_CS05.equalsIgnoreCase(elementColor)) {
					System.out.println("Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + elementColor);
					Extent_pass_New(driver, "Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + elementColor, test,test1);
				}
				else {
					System.out.println("Not Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + elementColor);
					Extent_fail(driver, "Not Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + elementColor, test,test1);
				}
				Step_End(11, "The removed row should be change the font color to Red ", test, test1);

			}else {
				String element_Colour = getAttribute(driver, Remove_Element, "class");
				if(element_Colour.contains("red")) {
					System.out.println("Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + "red");
					Extent_pass_New(driver, "Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + "red", test,test1);
				}
				else {
					System.out.println("Not Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + "red");
					Extent_fail(driver, "Not Matched || " + " Expected Color is : " + removed_Port_Color_Txt_CS05 + " || Actual Color is : " + "red", test,test1);
				}
			}
			Step_Start(12, "Click on Move to Coastal Schedule button", test, test1);
			waitForElement(driver, moveTOCoastalSchedule_Btn);
			click(driver, moveTOCoastalSchedule_Btn);

			Step_End(12, "Click on Move to Coastal Schedule button", test, test1);
			Step_Start(13, "System should remove the omitted port from the voyage", test, test1);
			waitForPopup(driver, popup_Message, moveToCoastal_PopUp_Txt_Exp_CS05);
			String moveToCostalMsg=getText(driver, popup_Message);
			if(moveToCostalMsg.equals(moveToCoastal_PopUp_Txt_Exp_CS05)) {
				click(driver, popup_Message_Yes_Button);
				System.out.println("Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS05 + " || Actual Popup is : " + moveToCostalMsg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS05 + " || Actual Popup is : " + moveToCostalMsg, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS05 + " || Actual Popup is : " + moveToCostalMsg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS05 + " || Actual Popup is : " + moveToCostalMsg, test,test1);
			}
			waitForPopup(driver, popup_Message, updateCoastal_PopUp_Exp_CS05);
			String updatePopupMsg=getText(driver, popup_Message);
			if(updateCoastal_PopUp_Exp_CS05.equals(updatePopupMsg)) {
				click(driver, popup_Message_Ok_Button);
				System.out.println("Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS05 + " || Actual Popup is : " + updatePopupMsg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS05 + " || Actual Popup is : " + updatePopupMsg, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS05 + " || Actual Popup is : " + updatePopupMsg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS05 + " || Actual Popup is : " + updatePopupMsg, test,test1);
			}
			Step_End(13, "System should remove the omitted port from the voyage", test, test1);
		}
		Step_Start(14, "Choose “Deleted(Omit) calls” button", test, test1);
		waitForElement(driver, deletedOmitted);
		click(driver, deletedOmitted);
		Step_End(14, "Choose “Deleted(Omit) calls” button", test, test1);
		Step_Start(15, "System should Turn the “Deleted(omit) calls” button name to “Normal Mode”", test, test1);

		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);
		}
		Step_End(15, "System should Turn the “Deleted(omit) calls” button name to “Normal Mode”", test, test1);
		Step_Start(16, "Right Click on the Omitted Port ", test, test1);

		waitForElement(driver, Voyage_Toggler);
		String status1 = getAttribute(driver, Voyage_Toggler, "class");
		if(!status1.contains("s")) {
			click(driver, Voyage_Toggler);
		}
		waitForElement(driver, Port_Select);
		click(driver, Port_Select);			
		waitForElement(driver, Port_Select);
		RightClick(driver, Port_Select);
		Step_End(16, "Right Click on the Omitted Port ", test, test1);
		Step_Start(17, "Choose Rollback Option from the menu ", test, test1);

		waitForElement(driver, Roll_Back);
		click(driver, Roll_Back);
		Step_End(17, "Choose Rollback Option from the menu ", test, test1);
		Step_Start(18, "Rollback window appears", test, test1);
		Step_Start(19, "Choose the omitted port ", test, test1);
		waitForElement(driver, element_Select);
		click(driver, element_Select);
		Step_End(19, "Choose the omitted port ", test, test1);
		Step_End(18, "Rollback window appears", test, test1);
		Step_Start(20, "Click on Rollback button ", test, test1);
		waitForElement(driver, rollLast);
		click(driver, rollLast);
		Step_End(20, "Click on Rollback button ", test, test1);
		Step_Start(21, "Click on Move to Coastal Button", test, test1);
		waitForElement(driver, moveToCoastalLast);
		click(driver, moveToCoastalLast);
		Step_End(21, "Click on Move to Coastal Button", test, test1);

		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
		}
		Step_Start(22, "System should Rollback the Removed port in the same place the port is omitted", test, test1);

		waitForPopup(driver, popup_Message, updateCoastal_PopUp_Exp_CS05);
		String	costalShedulePopup3 = getText(driver, popup_Message);
		if (costalShedulePopup3.equals(updateCoastal_PopUp_Exp_CS05)) {
			System.out.println("Matched || Expected Popup : " +updateCoastal_PopUp_Exp_CS05+"|| Actual Popup :"  +costalShedulePopup3 );
			Extent_pass_New(driver, "Matched || Expected Popup : " +updateCoastal_PopUp_Exp_CS05+"|| Actual Popup :"  +costalShedulePopup3,test,test1);
			click(driver,popup_Message_Ok_Button);

		} else {
			System.out.println("NotMatched || Expected Popup : "+updateCoastal_PopUp_Exp_CS05+" || Actual Popup : "+costalShedulePopup3);
			Extent_fail(driver,  "NotMatched || Expected Popup : "+updateCoastal_PopUp_Exp_CS05+" || Actual Popup : "+costalShedulePopup3, test,test1);
		}
		String status2 = getAttribute(driver, Voyage_Toggler, "class");
		if(!status2.contains("s")) {
			click(driver, Voyage_Toggler);
		}
		waitForElement(driver, Port_Select);
		String Portcode_Color_Code = getTextColor(driver,Port_Select);
		String Portcode_Color = getColorName(Portcode_Color_Code);
		
		System.out.println("Deleted port code color was : "+Portcode_Color);
		if (Portcode_Color.equals(blackcolorcode_CS05)) {
			System.out.println("Matched || Expected Color : " +blackcolorcode_CS05+"|| Actual Color :"  +Portcode_Color );
			Extent_pass_New(driver, "Matched || Expected Color : " +blackcolorcode_CS05+"|| Actual Color :"  +Portcode_Color,test,test1);
			System.out.println("Matched || The Selected Port Was Roll Backed");
			Extent_pass_New(driver, "Matched || The Selected Port Was Roll Backed",test,test1);
		} else {
			System.out.println("NotMatched || Expected Color : "+blackcolorcode_CS05+" || Actual Color : "+Portcode_Color+" || The Selected Port Was Not Roll Backed");
			Extent_fail(driver,  "NotMatched || Expected Color : "+blackcolorcode_CS05+" || Actual Color : "+Portcode_Color+" || The Selected Port Was Not Roll Backed", test,test1);
		}
		Step_End(22, "System should Rollback the Removed port in the same place the port is omitted", test, test1);
		if(Time_Adjustment.equalsIgnoreCase("Yes")) {
			Step_Start(23, "Adjust the next port(s) dates ", test, test1);
			waitForElement(driver, Voyage_Toggler);
			String toggler = getAttribute(driver, Voyage_Toggler, "class");
			if(!toggler.contains("s")) {
				click(driver, Voyage_Toggler);
			}
			waitForElement(driver, Port_Select);
			click(driver, Port_Select);	
			String next_row_Select = String.format(Coastal_Schedule_Locators.selectPortRow, portName_CS05);
			waitForElement(driver, next_row_Select);
			doubleClick(driver, next_row_Select);

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
			String beforeTableValue=TableDataForReport(driver, voyage_Details_Before, table_Name, columns);


			String PortArrPilotDate=String.format(Coastal_Schedule_Locators.currentRow_ArrPilot, portName_CS05);
			waitForElement(driver, PortArrPilotDate);
			doubleClick(driver, PortArrPilotDate);

			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, PortArrPilotDate, arrPilotDate);

			} else {
				waitForElement(driver, PortArrPilotDate);
				clearAndType(driver, PortArrPilotDate, arrPilotDate);
				waitForDisplay(driver, calender_close);
				click(driver,calender_close);
			}

			waitForElement(driver, port_Click);
			click(driver, port_Click);
			waitForElement(driver, port_Click);

			String arrival_Dock_Date=String.format(Coastal_Schedule_Locators.currentRow_ArrDock, portName_CS05);
			waitForElement(driver, arrival_Dock_Date);
			doubleClick(driver, arrival_Dock_Date);

			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, arrival_Dock_Date, arr_Dock_Date);

			} else {
				waitForElement(driver, arrival_Dock_Date);
				clearAndType(driver, arrival_Dock_Date, arr_Dock_Date);
				waitForDisplay(driver, calender_close);
				click(driver,calender_close);
			}
			
			waitForElement(driver, port_Click);
			click(driver, port_Click);
			waitForElement(driver, port_Click);

			String Departur_Dock_Date=String.format(Coastal_Schedule_Locators.currentRow_DepDock, portName_CS05);
			waitForElement(driver, Departur_Dock_Date);
			doubleClick(driver, Departur_Dock_Date);

			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, Departur_Dock_Date, Dept_Dock_Date);
			} else {
				waitForElement(driver, Departur_Dock_Date);
				clearAndType(driver, Departur_Dock_Date, Dept_Dock_Date);
				waitForDisplay(driver, calender_close);
				click(driver,calender_close);
			}
			
			waitForElement(driver, port_Click);
			click(driver, port_Click);
			waitForElement(driver, port_Click);

			String Departur_Pilot_Date=String.format(Coastal_Schedule_Locators.currentRow_DepPilot, portName_CS05);
			waitForElement(driver, Departur_Pilot_Date);
			doubleClick(driver, Departur_Pilot_Date);

			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, Departur_Pilot_Date, Dept_PilotDate);
				
			} else {
				waitForElement(driver, Departur_Pilot_Date);
				clearAndType(driver, Departur_Pilot_Date, Dept_PilotDate);
			
				waitForDisplay(driver, calender_close);
				click(driver,calender_close);
			}
			waitForElement(driver, port_Click);
			click(driver, port_Click);

			waitForElement(driver, Voyage_Details_Table);

			List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
			String afterTableValue=TableDataForReport(driver, voyage_Details_After, table_Name, columns);


			if (!afterTableValue.equals(beforeTableValue)) {
				Extent_pass_New(driver, "Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + beforeTableValue+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+afterTableValue+"</div>"+ "</pre>", test,test1);
			} else {
				Extent_fail(driver, "Not Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + beforeTableValue+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+afterTableValue+"</div>"+ "</pre>", test,test1);
			}


			waitForElement(driver, Movetocoastal);
			click(driver, Movetocoastal);

			waitForDisplay(driver, popup_Message);
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

			Step_End(23, "Adjust the next port(s) dates ", test, test1);
		}

		waitForElement(driver, Tree_Structure);
		waitForElement(driver, Voyage_Toggler);
		String status11 = getAttribute(driver, Voyage_Toggler, "class");
		if(!status11.contains("s")) {
			waitForElement(driver, Voyage_Toggler);
			safeclick(driver, Voyage_Toggler);
		}
		waitForElement(driver, Voyage);
		safeclick(driver, Voyage);						

		waitForDisplay(driver, Temp_Remove);
		if(isDisplayed(driver, Temp_Remove)){
			waitForElement(driver, Temp_Remove);
			click(driver, Temp_Remove);
		}
		reArrangeAG_Grid_Outer_Column_CS(driver, Select_Columns);

		List<WebElement> Ports_code = listOfElements(driver, portCodes_OuterGrid_CS);
		ArrayList<String> portName = new ArrayList<String> ();

		for(WebElement Ports : Ports_code) {
			String name = Ports.getText();
			if(!name.equals("")) {
			System.out.println(name);
			portName.add(name);
			}else {
				break;
			}
		}
		List<WebElement> Distance_code = listOfElements(driver, distanceList);

		ArrayList<String> Distance = new ArrayList<String> ();
		for(WebElement distance : Distance_code) {
			String name = distance.getText();
			if(!name.equals("")) {
			int dotIndex1 = name.indexOf('.');
			String Dist_Value= name.substring(0, dotIndex1);
			System.out.println(Dist_Value);
			Distance.add(Dist_Value);
			}else {
				break;
			}
		}
		
		
		Step_Start(24, "Check the Distance in Marine Distance module", test, test1);
		

		// Marine distance
				moduleNavigate(driver, search2);
				
				for(int k=0 ;k<portName.size();k++) {
					if(k+1 >= portName.size()) {
						break;
					}
					scrollTop(driver);
					
					waitForElement(driver, SearchButton_Toolbar);
					safeclick(driver, SearchButton_Toolbar);
					globalValueSearchWindow1(driver, dropdownCondition, searchBy_From_Port, portName.get(k), searchBy_To_Port, portName.get(k+1), "", "");
					
					
					waitForDisplay(driver, retrivedGlobalValue);
					if(isdisplayed(driver, retrivedGlobalValue)) {
					click(driver, retrivedGlobalValue);
					waitForElement(driver, SelectButton);
					click(driver, SelectButton);
					elementnotvisible1(driver, SelectButton);
					
					waitForElement(driver, Distance_GRidcell_MD);
					String distance_value=getText(driver, Distance_GRidcell_MD);
					System.out.println(" Port Distance : " + distance_value);

					System.out.println(Distance.get(k));
					if(Distance.get(k).equals(distance_value)) {
						System.out.println("Matched || Distance Value taken from Coastal Schedule :  "+Distance.get(k)+" || Distance Values taken from Marine Distance : "+distance_value);
						Extent_pass_New(driver, "Matched || Distance Value taken from Coastal Schedule :  "+Distance.get(k)+" || Distance Values taken from Marine Distance : "+distance_value, test, test1);
					}else {
						System.out.println("Not Matched || Distance Value taken from Coastal Schedule :  "+Distance.get(k)+" || Distance Values taken from Marine Distance : "+distance_value);
						Extent_pass_New(driver, "Not Matched || Distance Value taken from Coastal Schedule :  "+Distance.get(k)+" || Distance Values taken from Marine Distance : "+distance_value, test, test1);
					}
					
				}else if(isdisplayed(driver, Popup_Message)) {
						System.out.println("***distance was not found for***" + portName.get(k) + "***" + portName.get(k + 1));
						Extent_pass_New(driver, "***distance is not available for the port pair ***" + portName.get(k) + "***"
								+ portName.get(k + 1), test, test1);
						
						click(driver, globalSearchCloseIcon_L);

					}
				}
		Step_End(24, "Check the Distance in Marine Distance module", test, test1);

		Step_Start(25, "Check the ports in Ports module", test, test1);
		

//		Ports
			moduleNavigate(driver, search3);

			for(int D=0 ;D<portName.size();D++) {
				if(D+1 >= portName.size()) {
					break;
				}

				waitForElement(driver, SearchButton_Toolbar);
				safeclick(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, dropdownCondition, searchBy_Port, portName.get(D), "", "", "", "");

				waitForElement(driver, Statusforport);
				String Port_status=getText(driver, Statusforport);
				if(Port_status.equals(Ports_Status)){
					System.out.println( "Matched || The Port code "+portName.get(D)+" Status shown as "+Port_status);
					Extent_pass_New(driver, "Matched || The Port code "+portName.get(D)+" Status shown as "+Port_status , test, test1);
				}else {
					System.out.println("Not Matched || The Port code "+portName.get(D)+" Status not shown as "+Port_status);
					Extent_fail(driver, "Not Matched || The Port code "+portName.get(D)+" Status not shown as "+Port_status, test, test1);
				}
			}
		Step_End(25, "Check the ports in Ports module", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
