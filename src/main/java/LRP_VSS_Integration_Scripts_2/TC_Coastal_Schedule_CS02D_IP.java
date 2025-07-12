package LRP_VSS_Integration_Scripts_2;

import commonMethods.Keywords;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;


import locators.Coastal_Schedule_Locators;
public class TC_Coastal_Schedule_CS02D_IP extends Keywords {

	public void integration_CS02D_IP (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Coastal_Schedule_CS02D_IP";
		
		  
		  String Username = Excel_data.get("Username");
			String Password = Excel_data.get("Password");	
			String Search_input = Excel_data.get("Search_input");
			String service_code = Excel_data.get("service_code");
			String vesselName = Excel_data.get("vesselName");
			String voyage_num = Excel_data.get("voyage_num");
			String portcode_value = Excel_data.get("portcode_value");
			String date_Picker = Excel_data.get("date_Picker");
			String arr_pilot_date = Excel_data.get("arr_pilot_date");
			String Select_Columns = Excel_data.get("Select_Columns");
			String condition = Excel_data.get("Condition");
			String service_Search_Header = Excel_data.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
			String table_Name = Excel_data.get("Table_Name");
			
			String voyage = String.format(Coastal_Schedule_Locators.voyage_Select, voyage_num);
			String port_code =  String.format(Coastal_Schedule_Locators.portCode_Select, portcode_value);
			String voyage_det_portcode =  String.format(Coastal_Schedule_Locators.voyageDetails_PortCode, portcode_value);
			
	
			Extent_Start(testCaseName, test, test1);
		
			navigateUrl(driver, url); 

			LRP_Login(driver, Username, Password);
		   
			Step_Start(1, "Open Coastal Schedulde ", test, test1);
			
			moduleNavigate(driver, Search_input);
			
			Step_End(1, "Open Coastal Schedulde ", test, test1);
			
			Step_Start(2, "Retreive any Service", test, test1);
			
			waitForElement(driver, Service_Search_Btn);
			click(driver, Service_Search_Btn);
			
			twoColumnSearchWindow(driver, service_Search_Header, condition, service_code);

			waitForElement(driver, Vessel_Search_Btn);
			click(driver, Vessel_Search_Btn);

			twoColumnSearchWindow(driver, vessel_Search_Header, condition, vesselName);
			 
			 Step_End(2, "Retreive any Service", test, test1);
			 
			 Step_Start(3, "Click on Edit Button", test, test1);
			 
			 waitForElement(driver, Edit_Button_toolBar);
			 click(driver, Edit_Button_toolBar);
			 
			Step_End(3, "Click on Edit Button", test, test1);
			
			Step_Start(4, "Double click on the voyage", test, test1);

			waitForElement(driver, voyage);
			click(driver, voyage);
			
			Step_End(4, "Double click on the voyage", test, test1);
			
			
			waitForElement(driver, port_code);
			doubleClick(driver, port_code);
			
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
			
			
			Step_Start(5, "Click on Arr Dock Row", test, test1);
			
			waitForElement(driver, voyage_det_portcode);
			String portcode_row=getAttribute(driver, voyage_det_portcode, "aria-rowindex");
			System.out.println("portcode_row: "+portcode_row);
			

			 String arr_dockdate = String.format(Coastal_Schedule_Locators.arrDockDate, portcode_row);
			 waitForElement(driver, arr_dockdate);

			 String start_date = getText(driver, arr_dockdate);
				System.out.println("arr_dockdate: "+start_date);
				
				String arr_pilot = String.format(Coastal_Schedule_Locators.arrPilotDate, portcode_row);
				String end_date = getText(driver, arr_pilot);
				System.out.println("arr_pilot: "+end_date);
			
				waitForElement(driver, arr_dockdate);
				click(driver, arr_dockdate);
				
				Step_End(5, "Click on Arr Dock Row", test, test1);
				
				Step_Start(6, "Adjust the Date +/-", test, test1);
				
				doubleClick(driver, arr_dockdate);
				if (date_Picker.equalsIgnoreCase("Yes")) {
					
					selectDatePickerWithTime(driver, arr_dockdate, arr_pilot_date);

				} else {
					waitForElement(driver, arr_dockdate);
					clearAndType(driver, arr_dockdate, arr_pilot_date);
					
					waitForDisplay(driver, calender_close);
					click(driver,calender_close);
				}
			
				
				Step_End(6, "Adjust the Date +/-", test, test1);
				


			String arr_pilot_day = String.format(Coastal_Schedule_Locators.arrDay, portcode_row);

			waitForElement(driver, arr_pilot_day);
			click(driver, arr_pilot_day);
			
			Extent_call(test, test1, "The Difference between Arr Dock - Arr Pilot ");

			String arr_dockdate1 =  String.format(Coastal_Schedule_Locators.arrDockDate, portcode_row);
			waitForElement(driver, arr_dockdate1);
			 String end_date1 = getText(driver, arr_dockdate1);
				System.out.println("arr_dockdate1: "+end_date1);
			
				
				String arr_pilot1 = String.format(Coastal_Schedule_Locators.arrPilotDate, portcode_row);
				waitForElement(driver, arr_pilot1);
				String start_date1 = getText(driver, arr_pilot1);
				System.out.println("arr_pilot1: "+start_date1);
				
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		        Date d1 = null;
		        Date d2 = null;

		        try {
		            // Parse the dates
		            d1 = format.parse(start_date1);
		            d2 = format.parse(end_date1);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		        // Calculate the time difference in milliseconds
		        long diffInMillis = d2.getTime() - d1.getTime();

		        // Convert the time difference from milliseconds to hours
		        double diffInHours = diffInMillis / (1000.0 * 60 * 60);

		        // Format the result to 2 decimal places
		        DecimalFormat decfor = new DecimalFormat("0.00");
		        System.out.println("Time difference in hours: " + decfor.format(diffInHours) + " hours");
		        String hours = decfor.format(diffInHours);
			
			String man_timein =String.format(Coastal_Schedule_Locators.manTimeIn, portcode_row);
			waitForElement(driver, man_timein); 
			String mantime = getText(driver, man_timein);
				System.out.println("mantime: "+mantime);

			if (mantime.contains(hours)) {
				System.out.println("Matched || Expected man time in : " + hours + " || Actual man time in : " + mantime);
				Extent_pass_New(driver, "Matched || Expected man time in shown in the calculation : " + hours
						+ " || Actual man time in shown in the man time row : " + mantime, test, test1);
			} else {
				System.out.println("Not Matched || Expected man time in : " + hours + " || Actual man time in : " + mantime);
				Extent_fail(driver, "Not Matched || Expected man time in shown before changing the date : " + hours
						+ " || Actual man time in shown After changing the date : " + mantime, test, test1);
			}

			if (!start_date.equals(start_date1)) {
				
				System.out.println("Not Matched || Before change ArrDock Date : " + start_date
						+ " || Actual value was shown After change ArrDock Date : " + start_date1);
				Extent_pass_New(driver, "Not Matched || Before change ArrDock Date : " + start_date
						+ " || Actual value was shown After change ArrDock Date : " + start_date1, test, test1);
				
			} else {
				System.out.println("Matched || Before change ArrDock Date : " + start_date
						+ " || Actual value was shown After change ArrDock Date : " + start_date1);
				Extent_fail(driver, "Matched || Before change ArrDock Date : " + start_date
						+ " || Actual value was shown After change ArrDock Date : " + start_date1, test, test1);
			}
			
			waitForElement(driver, Voyage_Details_Table);

			List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
			String afterTableValue=TableDataForReport(driver, voyage_Details_After, table_Name, columns);

		
			if (!afterTableValue.equals(beforeTableValue)) {
				Extent_pass_New(driver, "Not Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + beforeTableValue+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+afterTableValue+"</div>"+ "</pre>", test,test1);
			} else {
				Extent_fail(driver, "Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + beforeTableValue+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+afterTableValue+"</div>"+ "</pre>", test,test1);
			}

			Extent_completed(testCaseName, test, test1);

		}
	}

