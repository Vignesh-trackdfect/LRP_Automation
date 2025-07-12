package LRP_End_To_End_Script;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.Utils;

public class TC_Proforma_Service_Creation_PC01 extends Keywords {

	public void Proforma_Service_Creation_PC01(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		//		Get data from excel sheet
		String tc_name = "TC_Proforma_Service_Creation_PC01";
		// TC_Proforma_Service_Creation_PC01[Reference]
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Servicecode = Excel_data.get("Service_Code_new");
		String date_Picker = Excel_data.get("DatePicker");
		String startDate = Excel_data.get("StartDate");
		String type = Excel_data.get("ProformaType");
		String greenColor = Excel_data.get("GreenColor");
		String yellowColor = Excel_data.get("YellowColor");
		String capacity = Excel_data.get("Capacity");
		String proformaSavedPopup = Excel_data.get("ProformaSavedPopup");
		String terminal_Search_Header = Excel_data.get("Terminal_Search_Header");
		String condition = Excel_data.get("Condition");
		String proforma_Status = Excel_data.get("ProformaStatus");
		String ModuleSearch = Excel_data.get("Module_Search_Proforma");
		String port_Search_Header = Excel_data.get("Port_Search_Header");
		String Export_All_Columns_Checkbox = Excel_data.get("Export_All_Columns_Checkbox");
		String Auto_Save_Split_Bound_Checkbox = Excel_data.get("Auto_Save_Split_Bound_Checkbox");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String status_Sel = Excel_data.get("ProformaStatus_Draft");
		String bound = Excel_data.get("bound");
		String remarks1 = Excel_data.get("Remarks");
		String PortCodes = Excel_data.get("PortCodes");
		String TerminalCodes = Excel_data.get("TerminalCodes");
		String ColumnHeaders = Excel_data.get("ColumnHeaders");
		String Arrival_Date = Excel_data.get("Arrival_Date");
		String Departure_Date = Excel_data.get("Departure_Date");
		String date_perform = Excel_data.get("date_perform");
			
	       
		Extent_Start(tc_name, test, test1);
//		 navigateUrl(driver, url);
//	        LRP_Login(driver, Username, Password);
		// TC_Proforma_Service_Creation_PC01
		moduleNavigate(driver, ModuleSearch);
		// Create proforma service
		Step_Start(1, "Click on the new button in the toolbar", test, test1);
		newButton(driver);
		Step_End(1, "Click on the new button in the toolbar", test, test1);
		Step_Start(2, "Enter the service code in the service field via autocomplete", test, test1);
		waitForElement(driver, service_Search_Icon_Psc);
		click(driver, service_Search_Icon_Psc);
		twoColumnSearchWindow(driver, service_Search_Header, condition, Servicecode);
		Step_End(2, "Enter the service code in the service field via autocomplete", test, test1);
		Step_Start(3, "Enter the remarks", test, test1);
		waitForElement(driver, remark_field);
		click(driver, remark_field);
		waitForElement(driver, remark_field);
		sendKeys(driver, remark_field, remarks1);
		Step_End(3, "Enter the remarks", test, test1);
		waitForDisplay(driver, Proforma_Temp_Remove);
		if (isdisplayed(driver, Proforma_Temp_Remove)) {
			waitForElement(driver, Proforma_Temp_Remove);
			click(driver, Proforma_Temp_Remove);
		}
		// Proforma Date
		Step_Start(4, "Select the respective date from the proforma start date field ", test, test1);
		waitForElement(driver, proforma_Date);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePickerWithTime_CS(driver, proforma_Date, startDate);
		} else {
			if (startDate.contains("-")) {
				String startDate1 = startDate.replace("-", "/");
				clearAndType(driver, proforma_Date, startDate1);
				waitForElement(driver, calenderclosebutton_SPF);
				click(driver, calenderclosebutton_SPF);
			} else {
				clearAndType(driver, proforma_Date, startDate);
				waitForElement(driver, calenderclosebutton_SPF);
				click(driver, calenderclosebutton_SPF);
			}
		}
		Step_End(4, "Select the respective date from the proforma start date field ", test, test1);
		if (!status_Sel.equals("")) {
			waitForElement(driver, status_Dropdown_SPF);
			click(driver, status_Dropdown_SPF);
			String select_Status1 = String.format(DropDown_Select, status_Sel);
			waitForElement(driver, select_Status1);
			click(driver, select_Status1);
		}
		if (!proforma_Status.equals("")) {
			waitForElement(driver, status_Dropdown_SPF);
			click(driver, status_Dropdown_SPF);
			String select_Status1 = String.format(DropDown_Select, proforma_Status);
			waitForElement(driver, select_Status1);
			click(driver, select_Status1);
		}
		if (!type.equals("")) {
			waitForElement(driver, type_Dropdown);
			click(driver, type_Dropdown);
			String select_Type = String.format(DropDown_Select, type);
			waitForElement(driver, select_Type);
			click(driver, select_Type);
		}
		if (!capacity.equals("")) {
			waitForElement(driver, capacity_Textfield);
			click(driver, capacity_Textfield);
			waitForElement(driver, capacity_Textfield);
			clearAndType(driver, capacity_Textfield, capacity);
		}
		waitForDisplay(driver, Proforma_Temp_Remove);
		if(isdisplayed(driver, Proforma_Temp_Remove)){
			waitForElement(driver, Proforma_Temp_Remove);
			click(driver, Proforma_Temp_Remove);
		}
		Step_End(2, "Click on the edit button ", test, test1);  

		Step_Start(5, "Click on the Plus icon from the AGgrid below ", test, test1);
		// Add multiple ports & Terminal in grid
		List<String> port_CodeValues = splitAndExpand(PortCodes, ",");
		List<String> terminalCode_Values = splitAndExpand(TerminalCodes, ",");
		for (int i = 1; i <= port_CodeValues.size(); i++) {
			
			String portSearchButtonIteration = String.format(portSearchButton_Iteration, i);
			waitForDisplay(driver, portSearchButtonIteration);
			click(driver, portSearchButtonIteration);
			twoColumnSearchWindow(driver, port_Search_Header, condition, port_CodeValues.get(i-1));
			Extent_call(test, test1, "Select the port using port search icon");
			waitForDisplay(driver, marineDistance_Frame);
			if (isdisplayed(driver, marineDistance_Frame)) {
				waitForElement(driver, marineDistance_Ok_Button);
				click(driver, marineDistance_Ok_Button);
			}
			String terminalSearchButtonIteration = String.format(terminalSearchButton_Iteration, i);
			waitForDisplay(driver, terminalSearchButtonIteration);
			click(driver, terminalSearchButtonIteration);
			Extent_call(test, test1, "Select the terminal Using the terminal Search Icon");
			twoColumnSearchWindow(driver, terminal_Search_Header, condition, terminalCode_Values.get(i-1));
			
			if (i != port_CodeValues.size()) {
				String agGrid_PlusIconIteration = String.format(agGrid_PlusIcon_Iteration, i);
				waitForElement(driver, agGrid_PlusIconIteration);
				click(driver, agGrid_PlusIconIteration);
			}
		}
		
		if(date_perform.equals("YES")) {
		reArrangeAG_GridColumnsWithoutCheckbox(driver, ColumnHeaders);
		List<String> Arrival_Dates = splitAndExpand(Arrival_Date, ",");
		List<String> Departure_Dates = splitAndExpand(Departure_Date, ",");

		for (int i = 1; i <= port_CodeValues.size(); i++) {
			String arrivalField = String.format(Proforma_Grid_Arrival_Pilot_Date_Field, i-1);
			waitForElement(driver, arrivalField);
			doubleClick(driver, arrivalField);
			String actualArrivalDate = Arrival_Dates.get(i-1);
			if(date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, arrivalField, actualArrivalDate);
			}else {
				if(actualArrivalDate.contains("-")) {
					String arr_DockDate1=actualArrivalDate.replace("-", "/");
					waitForElement(driver, arrivalField);
					click(driver,arrivalField);
					waitForElement(driver, arrivalField);
					clearAndType(driver, arrivalField, arr_DockDate1);
				}else {
					click(driver,arrivalField);
					waitForElement(driver, arrivalField);
					clearAndType(driver, arrivalField, actualArrivalDate);	
				}
				waitForElement(driver, calenderclosebutton_SPF);
				click(driver, calenderclosebutton_SPF);
			}

			String departureField = String.format(Proforma_Grid_Departure_Dock_Date_Field, i-1);
			waitForElement(driver, departureField);
			click(driver, departureField);
			waitForDisplay(driver, popup_Message_Ok_Button);
			if(isdisplayed(driver, popup_Message_Ok_Button)) {
				click(driver, popup_Message_Ok_Button);
			}
			waitForElement(driver, departureField);
			doubleClick(driver, departureField);
			String actualDepartureDate = Departure_Dates.get(i-1);
			if(date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePickerWithTime(driver, departureField, actualDepartureDate);
			}else {
				if(actualDepartureDate.contains("-")) {
					String arr_DockDate1=actualDepartureDate.replace("-", "/");
					waitForElement(driver, departureField);
					click(driver,departureField);
					waitForElement(driver, departureField);
					clearAndType(driver, departureField, arr_DockDate1);
				}else {
					click(driver,departureField);
					waitForElement(driver, departureField);
					clearAndType(driver, departureField, actualDepartureDate);	
				}
				waitForElement(driver, calenderclosebutton_SPF);
				click(driver, calenderclosebutton_SPF);
			}
			waitForElement(driver, arrivalField);
			click(driver, arrivalField);
			waitForDisplay(driver, popup_Message_Ok_Button);
			if(isdisplayed(driver, popup_Message_Ok_Button)) {
				click(driver, popup_Message_Ok_Button);
			}
		}}
		Step_End(5, "Click on the Plus icon from the AGgrid below ", test, test1);
		waitForDisplay(driver, export_All_Columns_Checkbox);
		checkBox(driver, export_All_Columns_Checkbox, Export_All_Columns_Checkbox);
		waitForDisplay(driver, autoSave_Split_Bound_Checkbox);
		checkBox(driver, autoSave_Split_Bound_Checkbox, Auto_Save_Split_Bound_Checkbox);
		waitForElement(driver, bound_Gridcell);
		doubleClick(driver, bound_Gridcell);
		String selectBound1 = String.format(select_Bound, bound);
		waitForElement(driver, selectBound1);
		click(driver, selectBound1);
		Step_Start(6, "Click on save button ", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(6, "Click on save button ", test, test1);
		waitForPopup(driver, popup_Message, proformaSavedPopup);
		String saveproforma = getText(driver, popup_Message);
		if (saveproforma.equals(proformaSavedPopup)) {
			Extent_pass_New(driver,
					"Matched || Expected popup :" + proformaSavedPopup + " || Actual popup :" + saveproforma, test,
					test1);
			System.out
			.println("Matched || Expected popup :" + proformaSavedPopup + " || Actual popup :" + saveproforma);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println(
					"Not Matched || Expected popup :" + proformaSavedPopup + " || Actual popup :" + saveproforma);

			Extent_fail(driver,
					"Not Matched || Expected popup :" + proformaSavedPopup + " || Actual popup :" + saveproforma, test,
					test1);
		}
		// Background Color Verification of Proforma code textfield
		Step_Start(7,
				"System should save the record in Draft highlighting the Service Code is Yellow Background color ",
				test, test1);
		waitForElement(driver, proformaStatus);
		String StatusDropdownoption = getText(driver, proformaStatus);
		System.out.println(StatusDropdownoption);

		waitForElement(driver, proforma_code);
		String textcolorCode = getTextBackgroundColor(driver, proforma_code);
		String textcolor = getColorName(textcolorCode);
		if (StatusDropdownoption.equals(status)) {
			if (textcolor.equals(yellowColor)) {
				Extent_pass_New(driver, "Matched || Expected :" + yellowColor + " || Actual :" + textcolor, test, test1);
				System.out.println("Matched || Expected :" + yellowColor + " || Actual :" + textcolor);
				Extent_pass_New(driver, "The background color of Proforma code textfield is Yellow", test, test1);
				System.out.println("The background color of Proforma code textfield is Yellow");
			} else {
				System.out.println("Not Matched || Expected :" + yellowColor + " || Actual :" + textcolor);

				Extent_fail(driver, "Not Matched || Expected :" + yellowColor + " || Actual :" + textcolor, test,
						test1);
			}
		} else if (StatusDropdownoption.equals(proforma_Status)) {
			if (textcolor.equals(greenColor)) {
				Extent_pass_New(driver, "Matched || Expected color :" + greenColor + " || Actual color :" + textcolor, test,
						test1);
				System.out.println("Matched || Expected color :" + greenColor + " || Actual color :" + textcolor);
				Extent_pass_New(driver, "The background color of Proforma code textfield is Green", test, test1);
				System.out.println("The background color of Proforma code textfield is Green");
			} else {
				System.out.println("Not Matched || Expected color :" + greenColor + " || Actual color :" + textcolor);

				Extent_fail(driver, "Not Matched || Expected color :" + greenColor + " || Actual color :" + textcolor,
						test, test1);
			}
		}
		Step_End(7, "System should save the record in Draft highlighting the Service Code is Yellow Background color ",
				test, test1);
		String newproforma_code = getAttribute(driver, proforma_code, "value");
		Extent_pass_New(driver, " Generated :Proforma Code :: " + newproforma_code, test, test1);
		System.out.println(" Generated :Proforma Code :: " + newproforma_code);
		Excel_data.put("New_Proforma_code", newproforma_code);
		Utils.writeOrUpdateExcelValue("TestData_End_to_End", "End_To_End_SC001", "TC_End_To_End_SC001", "Dataset1", "New_Proforma_code",newproforma_code);
		Extent_completed(tc_name, test, test1);
	}
}