package LRP_VSS_Coastal_Scedule_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS02 extends Keywords {
	public void Coastal_Schedule_CS02(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Coastal_Schedule_CS02";
		String Popforupdate = Excel_data.get( "PopForUpdated");
		String Username_CS02 =Excel_data.get("Username");
		String Password_CS02 =Excel_data.get("Password");
		String ModuleSearch_CS02 =Excel_data.get("Module_Search");
		String ServiceCode_CS02 =Excel_data.get("Service_Code");
		String VesselCode_CS02 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS02 =Excel_data.get("Voyage_Number");
		String portName_CS02 =Excel_data.get("Port_Name");
		String date_Picker= Excel_data.get("date_Picker");
		String Select_Columns = Excel_data.get("Select_Columns");
		String Future_Voyage = Excel_data.get("Future_Voyage");
		String Current_Voyage = Excel_data.get("Current_Voyage");
		String Move_Button = Excel_data.get("Move_Button");
		String Move_Button_option = Excel_data.get("Move_Button_option");
		String arr_Dock_Date = Excel_data.get("arr_Dock_Date");
		String Dept_Dock_Date = Excel_data.get("Dept_Dock_Date");
		String Dept_PilotDate = Excel_data.get("Dept_PilotDate");
		String arrPilotDate = Excel_data.get("ArrPilotDate");

		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		String table_Name = Excel_data.get("Table_Name");
		String RightClick_Perform = Excel_data.get("RightClick_Perform");
		String RightClickOptions = Excel_data.get("RightClickOptions");



		String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler, voyageNumber_CS02);



		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username_CS02, Password_CS02);

		moduleNavigate(driver, ModuleSearch_CS02);

		Step_Start(1, "Enter the Service Code in the service code field", test, test1);

		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);

		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS02);

		Step_End(1, "Enter the Service Code in the service code field", test, test1);

		Step_Start(2, "Enter the Vessel ", test, test1);

		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS02);


		Step_End(2, "Enter the Vessel ", test, test1);

		Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, Tree_Structure);
		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForElement(driver, Voyage_Toggler);
		String status = getAttribute(driver, Voyage_Toggler, "class");
		if(!status.contains("s")) {
			waitForElement(driver, Voyage_Toggler);
			click(driver, Voyage_Toggler);
		}
		formatLocatorClick(driver, VoyageFirstPortValue, voyageNumber_CS02);
		waitForElement(driver, AG_Grid_First_Port);
		doubleClick(driver, AG_Grid_First_Port);


		if(Future_Voyage.equalsIgnoreCase("Yes")) {
			waitForElement(driver, FutureVoyage_TimeAdjust);
			click(driver, FutureVoyage_TimeAdjust);
		}else if(Current_Voyage.equalsIgnoreCase("Yes")) {
			waitForElement(driver, CurrentVoyage_TimeAdjust);
			click(driver, CurrentVoyage_TimeAdjust);
		}else {
			waitForElement(driver, currentRow_TimeAdjust);
			click(driver, currentRow_TimeAdjust);
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
		List<String> portNames = splitAndExpand(portName_CS02, ",");
		List<String> arrPilotDates = splitAndExpand(arrPilotDate, ",");
		List<String> arr_Dock_Dates = splitAndExpand(arr_Dock_Date, ",");
		List<String> Dept_Dock_Dates = splitAndExpand(Dept_Dock_Date, ",");
		List<String> Dept_PilotDates = splitAndExpand(Dept_PilotDate, ",");

		for(int i = 0; i<portNames.size();i++) {
			List<Map<String, String>> voyage_Details_Before = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
			String voyage_Details_before=TableDataForReport(driver, voyage_Details_Before, table_Name, columns);
			String PortArrPilotDate =  String.format(Coastal_Schedule_Locators.PortArrPilotDate, portNames.get(i));
			String arrival_Dock_Date =  String.format(Coastal_Schedule_Locators.arrival_Dock_Date,portNames.get(i) );
			String Departur_Dock_Date =  String.format(Coastal_Schedule_Locators.Departur_Dock_Date, portNames.get(i));
			String Departur_Pilot_Date =  String.format(Coastal_Schedule_Locators.Departur_Pilot_Date, portNames.get(i));


			waitForElement(driver, PortArrPilotDate);
			doubleClick(driver, PortArrPilotDate);

			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePickerWithTime_CS(driver, PortArrPilotDate, arrPilotDates.get(i));
			} else {
				waitForElement(driver, PortArrPilotDate);
				clearAndType(driver, PortArrPilotDate, arrPilotDates.get(i));
				waitForDisplay(driver, calender_close);
				click(driver,calender_close);
			}
			waitForElement(driver, port_Click);
			click(driver, port_Click);
			waitForElement(driver, arrival_Dock_Date);
			doubleClick(driver, arrival_Dock_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePickerWithTime_CS(driver, arrival_Dock_Date, arr_Dock_Dates.get(i));
			} else {
				waitForElement(driver, arrival_Dock_Date);
				clearAndType(driver, arrival_Dock_Date, arr_Dock_Dates.get(i));
				waitForDisplay(driver, calender_close);
				click(driver,calender_close);
			}
			formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
			waitForElement(driver, Departur_Dock_Date);
			doubleClick(driver, Departur_Dock_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePickerWithTime_CS(driver, Departur_Dock_Date, Dept_Dock_Dates.get(i));
			} else {
				waitForElement(driver, Departur_Dock_Date);
				clearAndType(driver, Departur_Dock_Date, Dept_Dock_Dates.get(i));
				waitForDisplay(driver, calender_close);
				click(driver,calender_close);
			}
			formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
			waitForElement(driver, Departur_Pilot_Date);
			doubleClick(driver, Departur_Pilot_Date);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePickerWithTime_CS(driver, Departur_Pilot_Date, Dept_PilotDates.get(i));
			} else {
				waitForElement(driver, Departur_Pilot_Date);
				clearAndType(driver, Departur_Pilot_Date, Dept_PilotDates.get(i));
				waitForDisplay(driver, calender_close);
				click(driver,calender_close);
			}
			formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
			waitForElement(driver, Voyage_Details_Table);
			List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
			String voyage_Details_after=TableDataForReport(driver, voyage_Details_After, table_Name, columns);
			if (!voyage_Details_Before.equals(voyage_Details_After)) {
				Extent_pass_New(driver, " Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
			} else {
				Extent_fail(driver,
						" Not Matched || Before Table Value : \n"+"<pre>" + voyage_Details_before + "</pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
			}
		}
		boolean temp=true;
		List<String> Options = splitAndExpand(RightClickOptions, ",");
		List<String> RightClick_Performs = splitAndExpand(RightClick_Perform, ",");
		List<String> Move_Button_options = splitAndExpand(Move_Button_option, ",");
		List<String> Move_Buttons = splitAndExpand(Move_Button, ",");
		for(int i = 0; i<portNames.size();i++) {
			List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
			String voyage_Details_after=TableDataForReport(driver, voyage_Details_After, table_Name, columns);
			if(Move_Button_options.get(i).equalsIgnoreCase("Yes")&& !Move_Buttons.get(i).equals("")) {
				formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
				String Move =  String.format(Coastal_Schedule_Locators.Move, Move_Buttons.get(i));
				waitForElement(driver, Move);
				click(driver, Move);
				waitForElement(driver, Voyage_Details_Table);
				List<Map<String, String>> voyage_Details_After_Move_Table_Value = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
				String voyage_Details_after_move_Table_Value=TableDataForReport(driver, voyage_Details_After_Move_Table_Value, table_Name, columns);
				if (!voyage_Details_After.equals(voyage_Details_After_Move_Table_Value)) {
					Extent_pass_New(driver, " Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>\n"+"After move Table Value: \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after_move_Table_Value + "</div></pre>", test,test1);
				} else {
					Extent_fail(driver," Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>\n"+"After move Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after_move_Table_Value + "</div></pre>", test,test1);
				}

			}else {
				if(Options.get(i).equalsIgnoreCase("Remove/Omit")&&RightClick_Performs.get(i).equalsIgnoreCase("Yes")) {
					formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
					formatRightClick(driver, Voyage_Details_PortName, portNames.get(i));
					formatLocatorClick(driver, Voyage_Details_RightClickOptions, Options.get(i));
					temp=false;
					waitForElement(driver, Voyage_Details_Table);
					List<Map<String, String>> voyage_Details_After_Move_Table_Value = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
					String voyage_Details_after_move_Table_Value=TableDataForReport(driver, voyage_Details_After_Move_Table_Value, table_Name, columns);
					if (!voyage_Details_After.equals(voyage_Details_After_Move_Table_Value)) {
						Extent_pass_New(driver, " Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>\n"+"After move Table Value: \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after_move_Table_Value + "</div></pre>", test,test1);
					} else {
						Extent_fail(driver," Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>\n"+"After move Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after_move_Table_Value + "</div></pre>", test,test1);
					}
				}
				if(!Options.get(i).equalsIgnoreCase("Remove/Omit")&&temp&&RightClick_Performs.get(i).equalsIgnoreCase("Yes")) {
					formatLocatorClick(driver, Voyage_Details_PortName, portNames.get(i));
					formatRightClick(driver, Voyage_Details_PortName, portNames.get(i));
					formatLocatorClick(driver, Voyage_Details_RightClickOptions, Options.get(i));
				}
			}
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
			System.out.println("Matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop);
			Extent_pass_New(driver,"Matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop,test,test1);
		} else {
			System.out.println("Not matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop);
			Extent_fail(driver,"Not matched || " + " Expected Popup : " + Popforupdate + " || Actual Popup : " + Pop,test,test1);
		}
		click(driver, popup_Message_Ok_Button);
		Extent_completed(testCaseName, test, test1);
	}
}
