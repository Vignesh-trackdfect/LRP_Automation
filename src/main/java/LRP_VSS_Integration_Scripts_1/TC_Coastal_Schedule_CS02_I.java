package LRP_VSS_Integration_Scripts_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS02_I extends Keywords {
	    public void coastalShedule02_I(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

	    	String testcase_Name="TC_Coastal_Schedule_CS02_I";
			
			
	
			
			
			
		String Popforupdate = Excel_data.get("PopForUpdated");
		String Username_CS02 =Excel_data.get("Username");
		String Password_CS02 =Excel_data.get("Password");
		String ModuleSearch_CS02 =Excel_data.get("Module_Search");
		
		String date_Picker= Excel_data.get("date_Picker");
		String Select_Columns = Excel_data.get("Select_Columns");
		String Future_Voyage = Excel_data.get("Future_Voyage");
		String Current_Voyage = Excel_data.get("Current_Voyage");
		String arr_Dock_Date = Excel_data.get("arr_Dock_Date");
		String Dept_Dock_Date = Excel_data.get("Dept_Dock_Date");
		String Dept_PilotDate = Excel_data.get("Dept_PilotDate");
		String arrPilotDate = Excel_data.get("ArrPilotDate");
		
		String ServiceCode_CS02 =Excel_data.get("Service_Code");
		String VesselCode_CS02 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS02 =Excel_data.get("Voyage_Number");
		String portName_CS02 =Excel_data.get("Port_Name");
		String Move_Button = Excel_data.get("Move_Button");
		String search2 = Excel_data.get("Search_Input_2");
		String search3 = Excel_data.get("Search_Input_3");
		String Ports_Status = Excel_data.get("Ports_Status");
		
		String table_Name = Excel_data.get("Table_Name");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String searchBy_From_Port = Excel_data.get("SearchBy_From_Port");
		String searchBy_To_Port = Excel_data.get("SearchBy_To_Port");
		String searchBy_Port = Excel_data.get("SearchBy_Port");
		
		String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler, voyageNumber_CS02);
		String Port_Select1 =  String.format(Coastal_Schedule_Locators.Port_Select1, voyageNumber_CS02,portName_CS02);
		String row_Select =  String.format(Coastal_Schedule_Locators.row_Select, portName_CS02);
		String Move =  String.format(Coastal_Schedule_Locators.Move, Move_Button);
		String PortArrPilotDate =  String.format(Coastal_Schedule_Locators.PortArrPilotDate, portName_CS02);
		String arrival_Dock_Date =  String.format(Coastal_Schedule_Locators.arrival_Dock_Date,portName_CS02 );
		String Departur_Dock_Date =  String.format(Coastal_Schedule_Locators.Departur_Dock_Date, portName_CS02);
		String Departur_Pilot_Date =  String.format(Coastal_Schedule_Locators.Departur_Pilot_Date, portName_CS02);

		
		Extent_Start(testcase_Name, test, test1);

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
		waitForElement(driver, Port_Select1);
		click(driver, Port_Select1);						
		waitForElement(driver, row_Select);
		doubleClick(driver, row_Select);	


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
		
		List<Map<String, String>> voyage_Details_Before = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String voyage_Details_before=TableDataForReport(driver, voyage_Details_Before, table_Name, columns);

		
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
					" Not Matched || Before Table Value : \n"+"<pre>" + voyage_Details_before + "</pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
		}

		waitForElement(driver, Move);
		click(driver, Move);

		waitForElement(driver, Movetocoastal);

		List<Map<String, String>> voyage_Details_After_Move_Table_Value = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String voyage_Details_after_move_Table_Value=TableDataForReport(driver, voyage_Details_After_Move_Table_Value, table_Name, columns);

		if (!voyage_Details_Before.equals(voyage_Details_After_Move_Table_Value)) {
			Extent_pass_New(driver, " Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After move Table Value: \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after_move_Table_Value + "</div></pre>", test,test1);

		} else {
			Extent_fail(driver,
					" Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After move Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after_move_Table_Value + "</div></pre>", test,test1);
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

		waitForElement(driver, Tree_Structure);
		waitForElement(driver, Voyage_Toggler);
		String status11 = getAttribute(driver, Voyage_Toggler, "class");
		if(!status11.contains("s")) {
			waitForElement(driver, Voyage_Toggler);
			safeclick(driver, Voyage_Toggler);
		}
		waitForElement(driver, Port_Select1);
		safeclick(driver, Port_Select1);						

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
		

//				Ports
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
		
		Extent_completed(testcase_Name, test, test1);

	}
}
