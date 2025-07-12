package LRP_VSS_Integration_Scripts_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS03_IP extends Keywords {

	public void coastalSchedule03_Integration(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS03_IP";



		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String ModuleSearch = Excel_data.get("Module_Search");
		String ServiceCode = Excel_data.get("Service_Code");
		String TimeZ = Excel_data.get("Time_Zone");
		String DistNPort = Excel_data.get("Distance");
		String SpNport = Excel_data.get("Speed");
		String BuffTime = Excel_data.get("Buffer_Time");
		String voyage_num = Excel_data.get("Voyage_Num");
		String portcode_value = Excel_data.get("Port_CodeE");
		String negativeSpeed = Excel_data.get("NegativeSpeed");
		String speedChange = Excel_data.get("SpeedChange");

		String vessel_Code = Excel_data.get("Vessel_Code");
		String columnOption = Excel_data.get("ColumnOption");
		String date_Picker = Excel_data.get("date_Picker");
		String ArrPilot_Date_Input = Excel_data.get("ArrPilot_Date_Input");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		String table_Name = Excel_data.get("Table_Name");
		
		
		String voyage = String.format(Coastal_Schedule_Locators.voyage_Select, voyage_num);

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		LRP_Login(driver, Username, Password);

		Step_Start(1, "Open Coastal Schedulde ", test, test1);
		
		moduleNavigate(driver, ModuleSearch);

		Step_End(1, "Open Coastal Schedulde", test, test1);
// Coastal Schedule
		Step_Start(2, "Retreive any schedule", test, test1);
		
//		Retrieve a record
		
		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode);

		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, vessel_Code);
		
		Step_End(2, "Enter_Service_code", test, test1);
// Edit
		Step_Start(3, "Click on Edit Button", test, test1);
		
		 waitForElement(driver, Edit_Button_toolBar);
		 click(driver, Edit_Button_toolBar);
		 
		Step_End(3, "Click on Edit Button", test, test1);
		Step_Start(4, "Click on Any port call", test, test1);
		waitForElement(driver, voyage);
		safeclick(driver, voyage);
		
		Step_End(4, "Click on Any port call", test, test1);
		Step_Start(5, "Double click on the voyage ", test, test1);
		
//	Arrange the table
		
		String next_row_Select = String.format(selectPortRow, portcode_value);
		waitForElement(driver, next_row_Select);
		doubleClick(driver, next_row_Select);

		Step_End(5, "Double click on the voyage ", test, test1);
		Step_Start(6, "Click on Distance, Speed, Buffer Time,Time Zone", test, test1);

		waitForDisplay(driver, VoyageDetails_Temp_Remove);
		if(isdisplayed(driver, VoyageDetails_Temp_Remove)){
			waitForElement(driver, VoyageDetails_Temp_Remove);
			click(driver, VoyageDetails_Temp_Remove);
		}
		
		reArrangeAG_GridColumns_VoyageWindow(driver, columnOption);
		
		List<String> columns = splitAndExpand(columnOption);


		waitForElement(driver, edit_Grid_Total_Records);
		String getTotalRecords=getText(driver, edit_Grid_Total_Records);
		int row_Count=Integer.parseInt(getTotalRecords);
		
		List<Map<String, String>> voyage_Details_Before = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String beforeTableValue=TableDataForReport(driver, voyage_Details_Before, table_Name, columns);
		
		
		
		ArrayList<String> beforeAdjDistance = new ArrayList<String>();
		try {
			String arrPilotDates_list=String.format(arrPilot_Dates, portcode_value);
			List<WebElement> bfDates = listOfElements(driver, arrPilotDates_list);
			for (WebElement beforeDate : bfDates) {

				String bDates = beforeDate.getText();
				beforeAdjDistance.add(bDates);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Adjust Distance

		int count = 0;
		try {
			String distance_List=String.format(distance_VoyageDetails, portcode_value);
			List<WebElement> distanceElements = listOfElements(driver, distance_List);
			count=distanceElements.size();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Count:" + count);

//	Current Row distance


		String currentRowDistance = String.format(currentRow_Distance, portcode_value);
		String currentRowDistance_Edit = String.format(currentRow_Distance_InputCell, portcode_value);

		waitForElement(driver, currentRowDistance);

			waitForElement(driver, currentRowDistance);
			doubleClick(driver, currentRowDistance);
			waitForElement(driver, currentRowDistance_Edit);
			clearAndType(driver, currentRowDistance_Edit, DistNPort);

		waitForElement(driver, arrival_Pilot_Date1);

		safeclick(driver, arrival_Pilot_Date1);
		waitForElement(driver, arrival_Pilot_Date1);

		String currentRowDist = getText(driver, currentRowDistance);
		System.out.println("currentRowDist:" + currentRowDist);

		// Date After Adjust Distance

		ArrayList<String> afterAdjDistance = new ArrayList<String>();
		try {

			String afterAdjustDistance=String.format(arrPilot_Dates, portcode_value);
			List<WebElement> afDates =listOfElements(driver, afterAdjustDistance);
			for (WebElement afterDate : afDates) {

				String aftDates = afterDate.getText();
				afterAdjDistance.add(aftDates);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DistNPort : " + DistNPort);

		System.out.println("Distance After adjust :" +

				getText(driver, distance1val));

		Step_End(6, "Click on Distance, Speed, Buffer Time,Time Zone", test, test1);
		Step_Start(7, "Enter any numerical Value", test, test1);
//	Current row speed

		String currentRowSpeed = String.format(currentRow_Speed, portcode_value);
		String currentRowSpeed_Edit = String.format(currentRow_Speed_InputCell, portcode_value);

		waitForElement(driver, currentRowSpeed);

			waitForElement(driver, currentRowSpeed);
			doubleClick(driver, currentRowSpeed);
			waitForElement(driver, currentRowSpeed_Edit);
			clearAndType(driver, currentRowSpeed_Edit, SpNport);


		waitForElement(driver, arrival_Pilot_Date1);

		safeclick(driver, arrival_Pilot_Date1);
		waitForElement(driver, arrival_Pilot_Date1);

		String currentRowSpd = getText(driver, currentRowSpeed);
		System.out.println("currentRowSpd:" + currentRowSpd);

		// Date After Adjust Speed

		ArrayList<String> afterSpeed = new ArrayList<String>();
		try {
			String afterAdjustSpeed=String.format(arrPilot_Dates, portcode_value);

			List<WebElement> afDates = listOfElements(driver, afterAdjustSpeed);
			for (WebElement afterDate : afDates) {

				String aftDates = afterDate.getText();
				afterSpeed.add(aftDates);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("SpNport : " + SpNport);


		System.out.println("Before Adjust Speed :" + afterAdjDistance);

		System.out.println("After Adjust Speed :" + afterSpeed);

		

//	Current row Time zone

		String currentRowTimeZone = String.format(currentRow_TimeZone, portcode_value);
		String currentRowTimeZone_Edit = String.format(currentRow_TimeZone_InputCell, portcode_value);

		waitForElement(driver, currentRowTimeZone);

		if (isDisplayed(driver, currentRowTimeZone)) {
			waitForElement(driver, currentRowTimeZone);
			doubleClick(driver, currentRowTimeZone);
			waitForElement(driver, currentRowTimeZone_Edit);
			clearAndType(driver, currentRowTimeZone_Edit, TimeZ);

			waitForElement(driver, arrival_Pilot_Date1);
			safeclick(driver, arrival_Pilot_Date1);
		}
		waitForElement(driver, arrival_Pilot_Date1);

		String currentRowTmZn = getText(driver, currentRowTimeZone);
		System.out.println("currentRowTmZn;" + currentRowTmZn);

		// Date After Adjust Time Zone

		ArrayList<String> afterTimeZone = new ArrayList<String>();
		try {
			String afterAdjustTimeZone=String.format(arrPilot_Dates, portcode_value);
			waitForElement(driver, afterAdjustTimeZone);
			List<WebElement> afDates = listOfElements(driver, afterAdjustTimeZone);
			for (WebElement afterDate : afDates) {

				String aftDates = afterDate.getText();
				afterTimeZone.add(aftDates);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Time Zone : " + TimeZ);

		System.out.println("Time Zone After adjust :" +getText(driver, timeZone1val));

	
//	Current row Buffer time

		String currentRowBufferTime = String.format(currentRow_BufferTime, portcode_value);
		String currentRowBufferTime_Edit = String.format(currentRow_BufferTime_InputCell, portcode_value);

		waitForElement(driver, currentRowBufferTime);

			waitForElement(driver, currentRowBufferTime);
			doubleClick(driver, currentRowBufferTime);
			waitForElement(driver, currentRowBufferTime_Edit);
			clearAndType(driver, currentRowBufferTime_Edit, BuffTime);

			waitForElement(driver, arrival_Pilot_Date1);
			safeclick(driver, arrival_Pilot_Date1);
		waitForElement(driver, arrival_Pilot_Date1);

		String currentRowBuffTime = getText(driver, currentRowBufferTime);
		System.out.println("currentRowBuffTime;" + currentRowBuffTime);

		// Date After Adjust Buffer Time

		ArrayList<String> afterBufferTime = new ArrayList<String>();
		try {
			String afterAdjustBuffTime=String.format(arrPilot_Dates, portcode_value);

			List<WebElement> afDates = listOfElements(driver, afterAdjustBuffTime);
			for (WebElement afterDate : afDates) {

				String aftDates = afterDate.getText();
				afterBufferTime.add(aftDates);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Buffer Time : " + BuffTime);

		System.out.println("Buffer Time After adjust :" + getText(driver, bufferTime1val));

		System.out.println("Before Adjust Buffer Time :" + afterTimeZone);

		System.out.println("After Adjust Buffer Time :" + afterBufferTime);

		Step_End(7, "Enter any numerical Value", test, test1);

//// previous dept pilot date

		// int prevCount=count-1;
		System.out.println("count:" + count);

		String next_Port = String.format(nextPort, portcode_value);
		String actualNextPort = getText(driver, next_Port);
		
		String previousDeptPilot = String.format(previuosRow_DepPilot,portcode_value);
		waitForElement(driver, previousDeptPilot);
		String prevDeptPilot = getText(driver, previousDeptPilot);

		System.out.println("prevDeptPilot_String :" + prevDeptPilot);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"); // convert date time format
		LocalDateTime dateTime = LocalDateTime.parse(prevDeptPilot, formatter);

		System.out.println("prevDeptPilot_Format ;" + dateTime);

//	Previous port distance

		String pevPortDistance = String.format(currentRow_Distance, portcode_value);

		String prevPortDist = getText(driver, pevPortDistance);
		double previousPortDistance = Double.parseDouble(prevPortDist);
		System.out.println("prevPortDistance: " + previousPortDistance);

//	Previous port speed

		String pevPortSpeed =String.format(currentRow_Speed, portcode_value);

		String prevPortspd = getText(driver, pevPortSpeed);
		double previousPortSpeed = Double.parseDouble(prevPortspd);
		System.out.println("previousPortSpeed: " + previousPortSpeed);

//		Previous port Time zone

		String pevPortTimeZone = String.format(currentRow_TimeZone, portcode_value);

		String prevPortTmZn = getText(driver, pevPortTimeZone);
		double previousPortTimeZone = Double.parseDouble(prevPortTmZn);
		System.out.println("previousPortTimeZone: " + previousPortTimeZone);

//		Previous port Bufffer Time 

		String pevPortBufferTime = String.format(currentRow_BufferTime, portcode_value);

		String prevPortBuffTime = getText(driver, pevPortBufferTime);
		double previousPortBufferTime = Double.parseDouble(prevPortBuffTime);
		System.out.println("previousPortBufferTime: " + previousPortBufferTime);

//		Next port Bufffer Time 	

		String nextPortTmZn = String.format(nextRow_TimeZone, actualNextPort);

///// Next Row Arrival Pilot = (Previous Row Dep Pilot + Distance % Speed + Buffer Time) (+/-) (Next Row Time zone - Previous Row Time Zone)

		String nextPortTimeZn = getText(driver, nextPortTmZn);
		double nextPortTimezone = Double.parseDouble(nextPortTimeZn);
		System.out.println("nextPortTimezone: " + nextPortTimezone);

//	 Distance / Speed + Buffer Time
		double value1 = (previousPortDistance / previousPortSpeed) + previousPortBufferTime;
		System.out.println("value1; " + value1);

//	Next Row Time zone - Previous Row Time Zone
		double timeZonesValue = nextPortTimezone - previousPortTimeZone;
		System.out.println("timeZonesValue; " + timeZonesValue);

//	Hours Minutes Sec format for Distance,Speed,Buffer Time	of previous port
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

//	    Hours Minutes Sec format for Time Zone	next and previous port

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

//	    (Distance / Speed + Buffer Time) (+/-) (Next Row Time zone - Previous Row Time Zone)

		int hours3 = hours + hours2;
		int minutes3 = minutes + minutes2;
		int seconds3 = seconds + seconds2;

		System.out.println("hours3:" + hours3);
		System.out.println("minutes3:" + minutes3);
		System.out.println("seconds3:" + seconds3);

		// Convert to Duration

		String[] dateHrs = prevDeptPilot.split(" ");
		String[] dateFormat = dateHrs[0].split("/");
		String[] timeFormat = dateHrs[1].split(":");

		int Date = Integer.parseInt(dateFormat[1]);
		int Month = Integer.parseInt(dateFormat[0]);
		int Year = Integer.parseInt(dateFormat[2]);
		int Hour = Integer.parseInt(timeFormat[0]);
		int Minute = Integer.parseInt(timeFormat[1]);

		// Input Date
		LocalDateTime initialDateTime = LocalDateTime.of(Year, Month, Date, Hour, Minute);

		// Add day, hours, and minute
		LocalDateTime updatedDateTime = initialDateTime.plusHours(hours3).plusMinutes(minutes3);

		// Define the desired format
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");

		// Format the updated date and time
		String formattedUpdatedDateTime = updatedDateTime.format(formatter1);

		// Output the formatted updated date and time
		System.out.println("formattedUpdatedDateTime" + formattedUpdatedDateTime);

		String expectedNextPortArrPilotDate = formattedUpdatedDateTime.replace("-", "/");
		System.out.println("expectedNextPortArrPilotDate:" + expectedNextPortArrPilotDate);

//		Adjust Next port ArrPilot Date	
		
		String nextPortArrPilotDate = String.format(nextPort_arrPilot, actualNextPort);
		String actNextPortArrPilotDate = getText(driver, nextPortArrPilotDate);

		System.out.println("actualNextPort: " + actualNextPort);
		System.out.println("actNextPortArrPilotDate: " + actNextPortArrPilotDate);


		if (actNextPortArrPilotDate.equals(expectedNextPortArrPilotDate)) {
			waitForElement(driver, nextPortArrPilotDate);
			doubleClick(driver, nextPortArrPilotDate);

			System.out.println("Matched || Next Port Code: " + actualNextPort + " || Expected ArrPilot Date :"
					+ expectedNextPortArrPilotDate + " || Actual ArrPilot Date : " + actNextPortArrPilotDate);
			Extent_pass_New(driver,
					"Matched || Next Port Code: " + actualNextPort + " || Expected ArrPilot Date :"
							+ expectedNextPortArrPilotDate + " || Actual ArrPilot Date : " + actNextPortArrPilotDate,
					test, test1);

			waitForElement(driver, arrival_Pilot_Date1);
			safeclick(driver, arrival_Pilot_Date1);

		} else {
			waitForElement(driver, nextPortArrPilotDate);
			doubleClick(driver, nextPortArrPilotDate);

		
			System.out.println("Not Matched || Next Port Code: " + actualNextPort + " || Expected ArrPilot Date :"
					+ expectedNextPortArrPilotDate + " || Actual ArrPilot Date : " + actNextPortArrPilotDate);
			Extent_fail(driver,
					"Not Matched || Next Port Code: " + actualNextPort + " || Expected ArrPilot Date :"
							+ expectedNextPortArrPilotDate + " || Actual ArrPilot Date : " + actNextPortArrPilotDate,
					test, test1);
			

		}
		waitForElement(driver, Voyage_Details_Table);


		List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String afterTableValue=TableDataForReport(driver, voyage_Details_After, table_Name, columns);
		
		if (!afterTableValue.equals(beforeTableValue)) {
			Extent_pass_New(driver, "Not Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + beforeTableValue+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+afterTableValue+"</div>"+ "</pre>", test,test1);
		} else {
			Extent_fail(driver, "Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + beforeTableValue+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+afterTableValue+"</div>"+ "</pre>", test,test1);
		}

		
		Step_Start(8, "Adjust the Date +/-", test, test1);
		if (isDisplayed(driver, nextPortArrPilotDate)) {

			waitForElement(driver, nextPortArrPilotDate);
			safeclick(driver, nextPortArrPilotDate);
			doubleClick(driver, nextPortArrPilotDate);

			waitForElement(driver, nextPortArrPilotDate);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, nextPortArrPilotDate, ArrPilot_Date_Input);

			} else {

				waitForElement(driver, nextPortArrPilotDate);
				clearAndType(driver, nextPortArrPilotDate, ArrPilot_Date_Input);
				
				waitForDisplay(driver, calender_close);
				click(driver,calender_close);
			}
			
			
		}
		waitForElement(driver, arrival_Pilot_Date1);
		safeclick(driver, arrival_Pilot_Date1);
		waitForElement(driver, arrival_Pilot_Date1);

		

		Step_End(8, "Adjust the Date +/-", test, test1);

		// Current port speed After adjust Next port ArrPilot Date
		String afterCurrentPortSpeed = String.format(currentRow_Speed, portcode_value,count);
			
		waitForElement(driver, afterCurrentPortSpeed);
		String actCurrentPortSpeed = getText(driver, afterCurrentPortSpeed);
		System.out.println("actCurrentPortSpeed: " + actCurrentPortSpeed);
		if (!actCurrentPortSpeed.contains(SpNport)) {
			Extent_pass_New(driver, " Not Matched || Speed before : " + SpNport + " Speed after : " + actCurrentPortSpeed, test, test1);
			Extent_pass_New(driver, " Not Matched || Adjusting the Next port Arrival date,The speed of the previous port adjusted ", test,
					test1);
			System.out.println(" Not Matched || Speed before : " + SpNport + " Speed after : " + actCurrentPortSpeed);
			System.out.println(" Not Matched || Adjusting the Next port Arrival date,The speed of the previous port adjusted ");
		} else {
			System.out.println(" Matched || Speed before : " + SpNport + " Speed after : " + actCurrentPortSpeed);
			System.out.println(" Matched || Adjusting the Next port Arrival date,The speed of the previous port not adjusted ");
		
			Extent_fail(driver, " Matched || Speed before : " + SpNport + " Speed after : " + actCurrentPortSpeed, test, test1);
			Extent_fail(driver, " Matched || Adjusting the Next port Arrival date,The speed of the previous port not adjusted ",
					test, test1);
			
		}
		
		Extent_call(test, test1, "Giving Negative value to Speed should make it as 0");
			
			waitForElement(driver, currentRowSpeed);
			doubleClick(driver, currentRowSpeed);
			waitForElement(driver, currentRowSpeed_Edit);
			clearAndType(driver, currentRowSpeed_Edit, negativeSpeed);
			
			waitForElement(driver, arrival_Pilot_Date1);
			safeclick(driver, arrival_Pilot_Date1);
			
			waitForElement(driver, currentRowSpeed);

			String actSpeed=getText(driver, currentRowSpeed);
			if(actSpeed.equals(speedChange)) {
				Extent_pass_New(driver, "Matched || After give the negative value the actual speed : "+actSpeed, test, test1);
				System.out.println("Matched || After give the negative value the actual speed : "+actSpeed);
			}else {
				System.out.println("Not Matched || After give the negative value the actual speed : "+actSpeed);
				Extent_fail(driver, "Not Matched || After give the negative value the actual speed : "+actSpeed, test, test1);
			}
				
		
		List<Map<String, String>> voyage_Details_AfterSpeed = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String afterTableValue2=TableDataForReport(driver, voyage_Details_AfterSpeed, table_Name, columns);

	
		if (!afterTableValue2.equals(afterTableValue)) {
			Extent_pass_New(driver, "Not Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + afterTableValue+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+afterTableValue2+"</div>"+ "</pre>", test,test1);
		} else {
			Extent_fail(driver, "Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + afterTableValue+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+afterTableValue2+"</div>"+ "</pre>", test,test1);
		}
		
		waitForElement(driver, moveToCoastalSchedule_Voyage);

		click(driver, moveToCoastalSchedule_Voyage);	
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Ok_Button);
		}
		
		
		Extent_completed(testCaseName, test, test1);

	}

}
