package LRP_VSS_Integration_Scripts_1;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS04_I extends Keywords {

	public void coastalShedule04I(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Coastal_Schedule_CS04_I";
		
		


		String search2 = Excel_data.get("Search_Input_2");
		String search3 = Excel_data.get("Search_Input_3");
		String Ports_Status = Excel_data.get("Ports_Status");
		String Popforupdate = Excel_data.get("PopForUpdated");
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
		String removed_Port_Color_Txt_CS04= Excel_data.get("Removed_Port_Color");
		String remove_Button_CS04 =Excel_data.get("Button");
		String Roll_Back_Btn_CS04 =Excel_data.get("Roll_Back_Btn");
		String RollBack_CS04 =Excel_data.get("Do_You_Want_Rollback");
		String blackcolorcode_CS04=Excel_data.get("Blackcolor_Code");
		String Select_Columns = Excel_data.get("Select_Columns");
		String arr_Dock_Date = Excel_data.get("arr_Dock_Date");
		String Dept_Dock_Date = Excel_data.get("Dept_Dock_Date");
		String Dept_PilotDate = Excel_data.get("Dept_PilotDate");
		String arrPilotDate = Excel_data.get("arrPilotDate");
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
		
		String Roll_Back = String.format(Coastal_Schedule_Locators.Roll_Back, Roll_Back_Btn_CS04);
		String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler7,voyageNumber_CS04);
		String Port_Select =  String.format(Coastal_Schedule_Locators.Port_Select4,voyageNumber_CS04,portName_CS04);
		String Add_Select = String.format(Coastal_Schedule_Locators.Add_Select,remove_Button_CS04);
		String Next_Element = String.format(Coastal_Schedule_Locators.Next_Element,portName_CS04);
		String Previous_Element = String.format(Coastal_Schedule_Locators.Previous_Element,portName_CS04);
		String Remove_Element =String.format(Coastal_Schedule_Locators.Remove_Element,portName_CS04,portName_CS04);
		String element_Select = String.format(Coastal_Schedule_Locators.element_Select,portName_CS04,portName_CS04);
		String row_Select = String.format(Coastal_Schedule_Locators.row_Select4,portName_CS04);
		String Voyage =  String.format(Coastal_Schedule_Locators.Voyage_Selec, voyageNumber_CS04);

		Extent_Start(testcase_Name, test, test1);

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
		Step_Start(5, "CLick on the port after which the port needed to be Removed from the voyage ", test, test1);
		waitForElement(driver, Port_Select);
		click(driver, Port_Select);	
		waitForElement(driver, row_Select);
		String next_Port = getText(driver, row_Select);
		System.out.println("next_Port : "+next_Port);
		
		Step_End(5, "CLick on the port after which the port needed to be Removed from the voyage ", test, test1);
		Step_Start(6,"Right click on it ", test, test1);
		
		waitForElement(driver, Port_Select);
		RightClick(driver, Port_Select);
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
		waitForElement(driver, Remove_Element);
		click(driver, Remove_Element);
		
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
		waitForElement(driver, remove_Voyage_Page);
		if(isDisplayed(driver, Next_Element)) {
		click(driver, Next_Element);
		Step_Start(11, "The removed row should be change the font color to Red ", test, test1);
		
		waitForElement(driver, Remove_Element);
		String elementColor_Code=getTextColor(driver, Remove_Element);
		String elementColor=getColorName(elementColor_Code);
		
		if(removed_Port_Color_Txt_CS04.equalsIgnoreCase(elementColor)) {
			System.out.println("Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + elementColor);
			Extent_pass_New(driver, "Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + elementColor, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + elementColor);
			Extent_fail(driver, "Not Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + elementColor, test,test1);
		}
		Step_End(11, "The removed row should be change the font color to Red ", test, test1);
		
		}else if(isDisplayed(driver, Previous_Element)){
			click(driver, Previous_Element);
			Step_Start(11, "The removed row should be change the font color to Red ", test, test1);
			waitForElement(driver, Remove_Element);
			String elementColor_Code=getTextColor(driver, Remove_Element);
			String elementColor=getColorName(elementColor_Code);
			if(removed_Port_Color_Txt_CS04.equalsIgnoreCase(elementColor)) {
				System.out.println("Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + elementColor);
				Extent_pass_New(driver, "Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + elementColor, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + elementColor);
				Extent_fail(driver, "Not Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + elementColor, test,test1);
			}
			Step_End(11, "The removed row should be change the font color to Red ", test, test1);
			
		}else {
			String element_Colour = getAttribute(driver, Remove_Element, "class");
			if(element_Colour.contains("red")) {
				System.out.println("Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + "red");
				Extent_pass_New(driver, "Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + "red", test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + "red");
				Extent_fail(driver, "Not Matched || " + " Expected Color : " + removed_Port_Color_Txt_CS04 + " || Actual Color : " + "red", test,test1);
			}
		}
		
		
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
		
		if(Time_Adjustment.equalsIgnoreCase("Yes")) {
		Step_Start(14, "Adjust the next port(s) dates ", test, test1);
		String next_row_Select =String.format(Coastal_Schedule_Locators.next_row_Select,next_Port);
		waitForElement(driver, next_row_Select);
		doubleClick(driver, next_row_Select);
		
		
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

		String PortArrPilotDate=String.format(Coastal_Schedule_Locators.currentRow_ArrPilot, next_Port);
	
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

		String arrival_Dock_Date=String.format(Coastal_Schedule_Locators.currentRow_ArrDock, next_Port);
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
		click(driver, port_Click);

		String Departur_Dock_Date=String.format(Coastal_Schedule_Locators.currentRow_DepDock, next_Port);
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

		String Departur_Pilot_Date=String.format(Coastal_Schedule_Locators.currentRow_DepPilot, next_Port);
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
		String voyage_Details_after=TableDataForReport(driver, voyage_Details_After, table_Name, columns);


		if (!voyage_Details_Before.equals(voyage_Details_After)) {
			Extent_pass_New(driver, " Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
			
		} else {
			Extent_fail(driver,
					" Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
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
		}
		
		
		Step_End(14, "Adjust the next port(s) dates ", test, test1);

		

		waitForElement(driver, Tree_Structure);
		waitForElement(driver, Voyage_Toggler);
		String status1 = getAttribute(driver, Voyage_Toggler, "class");
		if(!status1.contains("s")) {
			waitForElement(driver, Voyage_Toggler);
			safeclick(driver, Voyage_Toggler);
		}
		waitForElement(driver, Voyage);
		safeclick(driver, Voyage);						

		waitForDisplay(driver, Temp_Remove);
		if(isdisplayed(driver, Temp_Remove)){
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
		
		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		Step_Start(15, "Check the Distance in Marine Distance module", test, test1);

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
		Step_End(15, "Check the Distance in Marine Distance module", test, test1);


		Step_Start(16, "Check the ports in Ports module", test, test1);

//	Ports
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
		
		
		Step_End(16, "Check the ports in Ports module", test, test1);

//	coastal	

		if(RollBack_CS04.equalsIgnoreCase("Yes")) {
			
			moduleNavigate(driver, ModuleSearch_CS04);


			waitForElement(driver, Service_Search_Btn);
			click(driver, Service_Search_Btn);
			
			twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS04);
			
			waitForElement(driver, Vessel_Search_Btn);
			click(driver, Vessel_Search_Btn);

			twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS04);

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			
			waitForElement(driver, deletedOmitted);
			click(driver, deletedOmitted);
			
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);
			}
			waitForElement(driver, Voyage_Toggler);
			status1 = getAttribute(driver, Voyage_Toggler, "class");
			if(!status1.contains("s")) {
				click(driver, Voyage_Toggler);
			}
			waitForElement(driver, Port_Select);
			click(driver, Port_Select);
			waitForElement(driver, Port_Select);
			RightClick(driver, Port_Select);

			waitForElement(driver, Roll_Back);
			click(driver, Roll_Back);
			waitForElement(driver, element_Select);
			click(driver, element_Select);
			waitForElement(driver, rollLast);
			click(driver, rollLast);
			waitForElement(driver, moveToCoastalLast);
			click(driver, moveToCoastalLast);
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
			waitForPopup(driver, popup_Message, updateCoastal_PopUp_Exp_CS04);
			String	costalShedulePopup3 = getText(driver, popup_Message);
				if (costalShedulePopup3.equals(updateCoastal_PopUp_Exp_CS04)) {
					System.out.println("Matched || Expected Popup : " +updateCoastal_PopUp_Exp_CS04+"|| Actual Popup :"  +costalShedulePopup3 );
					Extent_pass_New(driver, "Matched || Expected Popup : " +updateCoastal_PopUp_Exp_CS04+"|| Actual Popup :"  +costalShedulePopup3,test,test1);
				} else {
					System.out.println("NotMatched || Expected Popup : "+updateCoastal_PopUp_Exp_CS04+" || Actual Popup : "+costalShedulePopup3);
					Extent_fail(driver,  "NotMatched || Expected Popup : "+updateCoastal_PopUp_Exp_CS04+" || Actual Popup : "+costalShedulePopup3, test,test1);
				}
			click(driver,popup_Message_Ok_Button);
			
			String status2 = getAttribute(driver, Voyage_Toggler, "class");
			if(!status2.contains("s")) {
				click(driver, Voyage_Toggler);
			}
			waitForElement(driver, Port_Select);
			String Portcode_Color_Code = getTextColor(driver,Port_Select);
			String Portcode_Color = getColorName(Portcode_Color_Code);
			System.out.println("Deleted port code color was : "+Portcode_Color);
			if (Portcode_Color.equals(blackcolorcode_CS04)) {
				System.out.println("Matched || Expected Color : " +blackcolorcode_CS04+"|| Actual Color :"  +Portcode_Color );
				Extent_pass_New(driver, "Matched || Expected Color : " +blackcolorcode_CS04+"|| Actual Color :"  +Portcode_Color,test,test1);
				System.out.println("Matched || The Selected Port Was Roll Backed");
				Extent_pass_New(driver, "Matched || The Selected Port Was Roll Backed",test,test1);
			} else {
				System.out.println("NotMatched || Expected Color : "+blackcolorcode_CS04+" || Actual Color : "+Portcode_Color+" || The Selected Port Was Not Roll Backed");
				Extent_fail(driver,  "NotMatched || Expected Color : "+blackcolorcode_CS04+" || Actual Color : "+Portcode_Color+" || The Selected Port Was Not Roll Backed", test,test1);
			}
		}
		Extent_completed(testcase_Name, test, test1);


	}

}
