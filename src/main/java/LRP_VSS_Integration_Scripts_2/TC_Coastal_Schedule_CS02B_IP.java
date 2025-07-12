package LRP_VSS_Integration_Scripts_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS02B_IP extends Keywords {
	public void integration_CS02B_IP(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Coastal_Schedule_CS02B_IP";
		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search_input = Excel_data.get("Search_input");
		String service_code = Excel_data.get("service_code");
		String vesselName = Excel_data.get("vesselName");
		String voyage_num = Excel_data.get("voyage_num");
		String portcode_value = Excel_data.get("portcode_value");
		String Select_Columns = Excel_data.get("Select_Columns");
		String date_Picker = Excel_data.get("date_Picker");
		String arr_pilot_date = Excel_data.get("arr_pilot_date");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		String table_Name = Excel_data.get("Table_Name");
		

		String voyage = String.format(Coastal_Schedule_Locators.voyage_Select, voyage_num);
		String port_code =  String.format(Coastal_Schedule_Locators.portCode_Select, portcode_value);
		String voyage_det_portcode =  String.format(Coastal_Schedule_Locators.voyageDetails_PortCode, portcode_value);

		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);
		

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
		

		Step_Start(5, "Click on Arr Pilot Row ", test, test1);
		
		String portcode_row = getAttribute(driver, voyage_det_portcode, "aria-rowindex");
		System.out.println("portcode_row: " + portcode_row);

		
		String arr_pilot = String.format(Coastal_Schedule_Locators.arrPilotDate, portcode_row);
		String arr_pilotdate = getText(driver, arr_pilot);
		System.out.println("arr_pilotdate: " + arr_pilotdate);
		waitForElement(driver, arr_pilot);

		click(driver, arr_pilot);
		
		waitForElement(driver, arr_pilot);
		doubleClick(driver, arr_pilot);
		
		
		if (date_Picker.equalsIgnoreCase("Yes")) {
			
			selectDatePickerWithTime(driver, arr_pilot, arr_pilot_date);
			
		} else {
			waitForElement(driver, arr_pilot);
			clearAndType(driver, arr_pilot, arr_pilot_date);
			
			waitForDisplay(driver, calender_close);
			click(driver,calender_close);
		}
		
		
		Step_End(5, "Click on Arr Pilot Row ", test, test1);
		
		waitForElement(driver, voyage_det_portcode);
		click(driver, voyage_det_portcode);

		String dept_pilot = String.format(Coastal_Schedule_Locators.deptPilot, portcode_row);
		waitForElement(driver, dept_pilot);

		String dept_pilotdate = getText(driver, dept_pilot);
		System.out.println("dept_pilotdate: " + dept_pilotdate);

		String distance = String.format(Coastal_Schedule_Locators.distance, portcode_row);
		String distance_value = getText(driver, distance);
		System.out.println("distance: " + distance_value);
		double distance_data = Double.parseDouble(distance_value);

		String speed = String.format(Coastal_Schedule_Locators.speed, portcode_row);
		String speed_value = getText(driver, speed);
		System.out.println("speed: " + speed_value);
		double speed_data = Double.parseDouble(speed_value);

		String buffer = String.format(Coastal_Schedule_Locators.bufferTime, portcode_row);
		String buffer_date = getText(driver, buffer);
		System.out.println("buffer_date: " + buffer_date);
		double buffer_data = Double.parseDouble(buffer_date);

		String pre_timezone =String.format(Coastal_Schedule_Locators.timeZone, portcode_row);

		String pre_timezone_value = getText(driver, pre_timezone);
		double oldtimezone = Double.parseDouble(pre_timezone_value);
		System.out.println("oldtimezone: " + oldtimezone);

		int rownum = Integer.parseInt(portcode_row);
		int new_rownum = rownum + 1;
		String next_row = Integer.toString(new_rownum);

		String next_timezone =String.format(Coastal_Schedule_Locators.nextPort_TimeZone, next_row);
		String next_timezone_value = getText(driver, next_timezone);
		double newtimezone = Double.parseDouble(next_timezone_value);
		System.out.println("newtimezone: " + newtimezone);
		
		Step_Start(6, "Adjust the Date +/-", test, test1);

//		 Distance / Speed + Buffer Time
		double value1 = (distance_data / speed_data) + buffer_data;
		System.out.println("value1; " + value1);

//		Next Row Time zone - Previous Row Time Zone
		double timeZonesValue = newtimezone - oldtimezone;
		System.out.println("timeZonesValue; " + timeZonesValue);

//		Hours Minutes Sec format for Distance,Speed,Buffer Time	of previous port
		double totalHours = value1;

		// Convert hours to hours, minutes, seconds
		int hours = (int) totalHours; // Get the whole hours
		double fractionalHours = totalHours - hours; // Get the fractional part

		int minutes = (int) (fractionalHours * 60); // Convert fractional hours to minutes
		double fractionalMinutes = (fractionalHours * 60) - minutes; // Get the fractional part of minutes

		int seconds = (int) (fractionalMinutes * 60); // Convert fractional minutes to seconds

		if (seconds > 30) {
			minutes = minutes + 1;
		}
		// Output the result
		System.out.printf("Time: %d hours, %d minutes, %d seconds%n", hours, minutes, seconds);

//		    Hours Minutes Sec format for Time Zone	next and previous port

		double totalHours2 = timeZonesValue;

		// Convert hours to hours, minutes, seconds
		int hours2 = (int) totalHours2; // Get the whole hours
		double fractionalHours2 = totalHours2 - hours2; // Get the fractional part

		int minutes2 = (int) (fractionalHours2 * 60); // Convert fractional hours to minutes
		double fractionalMinutes2 = (fractionalHours2 * 60) - minutes; // Get the fractional part of minutes

		int seconds2 = (int) (fractionalMinutes2 * 60); // Convert fractional minutes to seconds

		if (seconds2 > 30) {
			minutes2 = minutes2 + 1;
		}
		// Output the result
		System.out.printf("Time: %d hours2, %d minutes2, %d seconds2%n", hours2, minutes2, seconds2);

//		    (Distance / Speed + Buffer Time) (+/-) (Next Row Time zone - Previous Row Time Zone)

		int hours3 = hours + hours2;
		int minutes3 = minutes + minutes2;
		int seconds3 = seconds + seconds2;

		System.out.println("hours3:" + hours3);
		System.out.println("minutes3:" + minutes3);
		System.out.println("seconds3:" + seconds3);

		// Calculate number of full days
//	        long days = duration.toDays();

		// Calculate remaining time within the current day
//	        long remainingMinutes = duration.toMinutes() % (24 * 60);
//	        LocalTime localTime = LocalTime.of((int) (remainingMinutes / 60), (int) (remainingMinutes % 60));

		String[] dateHrs = dept_pilotdate.split(" ");
		String[] dateFormat = dateHrs[0].split("/");
		String[] timeFormat = dateHrs[1].split(":");

		int Date = Integer.parseInt(dateFormat[0]);
		int Month = Integer.parseInt(dateFormat[1]);
		int Year = Integer.parseInt(dateFormat[2]);
		int Hour = Integer.parseInt(timeFormat[0]);
		int Minute = Integer.parseInt(timeFormat[1]);

		// Input Date
		LocalDateTime initialDateTime = LocalDateTime.of(Year, Month, Date, Hour, Minute);

		// Add day, hours, and minute
		LocalDateTime updatedDateTime = initialDateTime.plusHours(hours3).plusMinutes(minutes3);

		// Define the desired format
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		// Format the updated date and time
		String formattedUpdatedDateTime = updatedDateTime.format(formatter1);

		// Output the formatted updated date and time
		System.out.println("formattedUpdatedDateTime" + formattedUpdatedDateTime);

		String expectedNextPortArrPilotDate = formattedUpdatedDateTime.replace("-", "/");
		System.out.println("expectedNextPortArrPilotDate:" + expectedNextPortArrPilotDate);
		
		Step_End(6, "Adjust the Date +/-", test, test1);

			String next_arr_pilot =String.format(Coastal_Schedule_Locators.nextPort_ArrPilot, next_row);

			waitForElement(driver, next_arr_pilot);

			String latest_rowvalue =getText(driver, next_arr_pilot);
			System.out.println("latest_rowvalue: " + latest_rowvalue);

			waitForElement(driver, next_arr_pilot);
			doubleClick(driver, next_arr_pilot);
			waitForElement(driver, voyage_det_portcode);

			
			if (expectedNextPortArrPilotDate.equals(latest_rowvalue)) {
				System.out.println("Matched || Expected Arr pilot date : " + expectedNextPortArrPilotDate
						+ " || Actual Arr pilot date : " + latest_rowvalue);
				Extent_pass_New(driver, "Matched || Expected Arr pilot date : " + expectedNextPortArrPilotDate
						+ " || Actual Arr pilot date : " + latest_rowvalue, test,
						test1);
			} else {
				System.out.println("Not Matched || Expected Arr pilot date : " + expectedNextPortArrPilotDate
						+ " || Actual Arr pilot date : " + latest_rowvalue);
				Extent_fail(driver,
						"Not Matched || Expected Arr pilot date : " + expectedNextPortArrPilotDate
						+ " || Actual Arr pilot date : " + latest_rowvalue,
						test, test1);
			}

			waitForDisplay(driver, calender_close);
			click(driver,calender_close);
			
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
