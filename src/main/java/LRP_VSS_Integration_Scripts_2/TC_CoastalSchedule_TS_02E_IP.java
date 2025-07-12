package LRP_VSS_Integration_Scripts_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_CoastalSchedule_TS_02E_IP extends Keywords {

	public void Coastal_Schedule_CS02E_IP(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Throwable {
		String testCaseName="TC_CoastalSchedule_TS_02E_IP";

		// Get data from excel sheet
		
		


		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search_Module_Name = Excel_data.get("Search_Module_Name");
		String ServiceCode = Excel_data.get("ServiceCode");
		String vesselName = Excel_data.get("vesselName");
		String voyage_num = Excel_data.get("voyage_num");
		String PortCode_Value = Excel_data.get("PortCode_Value");
		String Dep_Piock_Date = Excel_data.get("Dep_Piock_Date");
		String date_Picker = Excel_data.get("date_Picker");
		String Select_Columns = Excel_data.get("Select_Columns");
		String table_Name = Excel_data.get("table_Name");
		String Vessel_code_Header_CS = Excel_data.get("Vessel_code_Header_CS");
		String Service_Code_Header_CS = Excel_data.get("Service_Code_Header_CS");
		String Condition_Filter = Excel_data.get("Condition_Filter");


		Extent_Start(testCaseName, test, test1);
		

		// Login
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Step_Start(1, "Open Coastal Schedulde ", test, test1);
		moduleNavigate(driver, Search_Module_Name);

		Step_End(1, "Open Coastal Schedulde ", test, test1);

		Step_Start(2, "Retreive any schedule ", test, test1);
		waitForElement(driver, Service_Search_Btn);
		safeclick(driver, Service_Search_Btn);

		twoColumnSearchWindow(driver, Service_Code_Header_CS, Condition_Filter, ServiceCode);
	
		waitForElement(driver, Vessel_Search_Btn);
		safeclick(driver, Vessel_Search_Btn);
		twoColumnSearchWindow(driver, Vessel_code_Header_CS, Condition_Filter, vesselName);

		Step_End(2, "Retreive any schedule ", test, test1);
		Step_Start(3, "safeclick on Edit Button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		Step_End(3, "safeclick on Edit Button", test, test1);
		Step_Start(4, "Click on Any port call", test, test1);
		String voyage =  String.format(voyage_, voyage_num);
		waitForElement(driver, voyage);
		safeclick(driver, voyage);
		Step_End(4, "Click on Any port call", test, test1);
		Step_Start(5, "Double click on the voyage", test, test1);
		waitForElement(driver, CS_Control_Pannel);
		safeclick(driver, CS_Control_Pannel);
		waitForElement(driver, CS_Condition_filter);
		safeclick(driver, CS_Condition_filter);
		waitForElement(driver, Port_Code_TF);
		sendKeys(driver, Port_Code_TF, PortCode_Value);

		
		String port_code =  String.format(port_code_, PortCode_Value);
		waitForElement(driver, port_code);
		doubleClick(driver, port_code);

		Step_End(5, "Double click on the voyage", test, test1);
		waitForDisplay(driver, VoyageDetails_Temp_Remove);
		if(isDisplayed(driver, VoyageDetails_Temp_Remove)){
			waitForElement(driver, VoyageDetails_Temp_Remove);
			click(driver, VoyageDetails_Temp_Remove);
		}
		
		
	    reArrangeAG_GridColumns_VoyageWindow(driver, Select_Columns);
		
			waitForElement(driver, edit_Grid_Total_Records);
			String getTotalRecords=getText(driver, edit_Grid_Total_Records);
			int row_Count=Integer.parseInt(getTotalRecords);
			List<String> columns = splitAndExpand(Select_Columns);
			List<Map<String, String>> voyage_Details_Before = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
			String voyage_Details_before=TableDataForReport(driver, voyage_Details_Before, table_Name, columns);



		
		String moved_portcode =  String.format(moved_portcode_,PortCode_Value );

        waitForElement(driver, moved_portcode);
		String portcode_row = getAttribute(driver, moved_portcode, "aria-rowindex");
		System.out.println("portcode_row: " + portcode_row);

		Step_Start(6, "Click on Dep  Dock Row", test, test1);
		
		String port4 =  String.format(port4_,portcode_row );

		String departure_Dock_Date = getText(driver, port4);
		System.out.println(departure_Dock_Date);
		Step_End(6, "Click on Dep  Dock Row", test, test1);
		
		String value= String.format(value_, portcode_row);
		waitForElement(driver, value);
		String terminalTime = getText(driver, value);
		System.out.println("Terminal time:" + terminalTime);

		
		String port5 =  String.format(port5_,portcode_row );

		waitForElement(driver, port5);
		String arrival_Dock_Date = getText(driver, port5);
		System.out.println(arrival_Dock_Date);
		
		Step_Start(6, "Click on Dep  Dock Row", test, test1);
		
		String depdock =  String.format(depdock_,portcode_row );

		waitForElement(driver, depdock);
		safeclick(driver, depdock);

		Step_Start(7, "Adjust the Date +/-", test, test1);
		
		
		
		waitForElement(driver, depdock);

		if (date_Picker.equalsIgnoreCase("Yes")) {
			doubleClick(driver, depdock);
		
		selectDatePickerWithTime(driver, depdock, Dep_Piock_Date);
		}
		
		
	
		Step_End(7, "Adjust the Date +/-", test, test1);
		
		
		String Distance_Val =  String.format(Distance_Val_, PortCode_Value);
		safeclick(driver, Distance_Val);

		
		String port6 =  String.format(port6_, portcode_row);
		waitForElement(driver, port6);
		String departure_Dock_Date1 = getText(driver, port6);
		System.out.println(departure_Dock_Date1);
		String port7 =  String.format(port7_, portcode_row);
		waitForElement(driver, port7);
		String arrival_Dock_Date1 = getText(driver, port7);
		System.out.println(arrival_Dock_Date1);
		
		
		List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String voyage_Details_after=TableDataForReport(driver, voyage_Details_After, table_Name, columns);

	
		

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Date d1 = format.parse(departure_Dock_Date1);
		Date d2 = format.parse(arrival_Dock_Date1);

		long diff = d2.getTime() - d1.getTime();

		long diffMinutes = diff / (60 * 1000);

		long diffHours = diffMinutes / 60;
		long remainingMinutes = diffMinutes % 60;

		System.out.println("Time in minutes: " + diffMinutes + " minutes.");
		System.out.println("Time in hours: " + diffHours + " hours.");

		String remaining_time = String.format("%02d:%02d", diffHours, remainingMinutes);
		System.out.println("Time difference: " + remaining_time);
		String[] a4 = remaining_time.split("\\-");
		System.out.println("Splitted string " + a4[1]);

		waitForElement(driver, value);
		String terminalTime1 = getText(driver, value);
		System.out.println("Terminal1:" + terminalTime1);

		if (!departure_Dock_Date.equals(departure_Dock_Date1)) {
			System.out.println("Not Matched || " + " Before click the  Departure Dock Date value   : " + departure_Dock_Date
					+ " ||After safeclick the  edit Departure Dock Date value is changed: " + departure_Dock_Date1);
			Extent_pass_New(driver, "Not Matched || " + " Before click the  Departure Dock Date value : " + departure_Dock_Date
					+ " || After safeclick the  edit Departure Dock Date value is changed : " + departure_Dock_Date1,
					test, test1);
		} else {
			System.out.println("matched || " + " Expected Activity is : " + departure_Dock_Date
					+ " || Actual Activity is : " + departure_Dock_Date1);
			Extent_fail(driver, "matched || " + " Expected Activity is : " + departure_Dock_Date
					+ " || Actual Activity is : " + departure_Dock_Date1, test, test1);
		}

		String Terminal_Value[] = terminalTime1.split("\\.");
		String Terminal_Calculation[] = a4[1].split(":");
		System.out.println("splitvalue1[0] " + Terminal_Value[0]);
		System.out.println("splitvalue2[0] " + Terminal_Calculation[0]);

		if ((Terminal_Value[0]).trim().equals(Terminal_Calculation[0].trim())) {
			System.out
					.println("Matched || " + " Before Adjusting date the  Terminal time value   : " + Terminal_Value[0]
							+ " ||After Adjusting date the  Terminal calculation value: " + Terminal_Calculation[0]);
			Extent_pass_New(driver,
					"Matched || " + " Before Adjusting date the  Terminal time value : " + Terminal_Value[0]
							+ " || After Adjusting date the  Terminal calculation value: " + Terminal_Calculation[0],
					test, test1);
		} else {
			System.out.println(
					"Not matched || " + "  Before Adjusting date the  Terminal time value : " + Terminal_Value[0]
							+ " ||After Adjusting date the  Terminal calculation value: " + Terminal_Calculation[0]);
			Extent_fail(driver,
					"Not matched || " + " Before Adjusting date the  Terminal time value : " + Terminal_Value[0]
							+ " || After Adjusting date the  Terminal calculation value: " + Terminal_Calculation[0],
					test, test1);
		}
		

		if (!voyage_Details_Before.equals(voyage_Details_After)) {
			Extent_pass_New(driver, " Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
			
		} else {
			Extent_fail(driver,
					" Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
			}
		Extent_completed(testCaseName, test, test1);
	}
}