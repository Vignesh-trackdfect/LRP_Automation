package LRP_VSS_Integration_Scripts_2;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_CoastalSchedule_TS_02F_IP extends Keywords {

	public void Coastal_Schedule_CS02F_IP(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Throwable {
		String testCaseName="TC_CoastalSchedule_TS_02F_IP";

		// Get data from excel sheet
		
		



		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search_Module_Name = Excel_data.get("Search_Module_Name");
		String ServiceCode = Excel_data.get("ServiceCode");
		String vesselName = Excel_data.get("vesselName");
		String voyage_num = Excel_data.get("voyage_num");
		String PortCode_Value = Excel_data.get("PortCode_Value");
		String date_Picker = Excel_data.get("date_Picker");
		String Dep_Pilot_Date = Excel_data.get("Dep_Pilot_Date");
		String Select_Columns = Excel_data.get("Select_Columns");
		String table_Name = Excel_data.get("table_Name");
		String Vessel_code_Header_CS = Excel_data.get("Vessel_code_Header_CS");
		String Service_Code_Header_CS = Excel_data.get("Service_Code_Header_CS");
		String Condition_Filter = Excel_data.get("Condition_Filter");



	
		Extent_Start(testCaseName, test, test1);
		// Login
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Open Coastal Schedulde", test, test1);
		moduleNavigate(driver, Search_Module_Name);

		Step_End(1, "Open Coastal Schedulde", test, test1);

		Step_Start(2, "Retreive any schedule", test, test1);
		waitForElement(driver, Service_Search_Btn);
		safeclick(driver, Service_Search_Btn);

		twoColumnSearchWindow(driver, Service_Code_Header_CS, Condition_Filter, ServiceCode);
	
		waitForElement(driver, Vessel_Search_Btn);
		safeclick(driver, Vessel_Search_Btn);
		twoColumnSearchWindow(driver, Vessel_code_Header_CS, Condition_Filter, vesselName);

		Step_End(2, "Retreive any schedule", test, test1);
		Step_Start(3, "Click on Edit Button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		Step_End(3, "Click on Edit Button", test, test1);

		Step_Start(4, "Click on Any port call", test, test1);
		waitForElement(driver, CS_Control_Pannel);
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
			waitForElement(driver, Voyage_Details_Table);

			List<Map<String, String>> voyage_Details_Before = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
			String voyage_Details_before=TableDataForReport(driver, voyage_Details_Before, table_Name, columns);

		String moved_portcode =  String.format(moved_portcode_,PortCode_Value );
		waitForElement(driver, moved_portcode);
		String portcode_row = getAttribute(driver, moved_portcode, "aria-rowindex");
		System.out.println("portcode_row: " + portcode_row);


		String Dep_dock =  String.format(Dep_dock_,portcode_row );

		waitForElement(driver, Dep_dock);
		String departure_Dock_Date = getText(driver, Dep_dock);
		System.out.println("departure dock date:" + departure_Dock_Date);


		String Man_time =  String.format(Man_time_,portcode_row );
		waitForElement(driver, Man_time);
		String mantime = getText(driver, Man_time);
		System.out.println("man time out:" + mantime);
		Step_Start(6, "Click on Dep  Pilot  Row", test, test1);

		String dep_Pilot =  String.format(dep_Pilot_,portcode_row );
		String departure_Pilot_Date = getText(driver, dep_Pilot);
		System.out.println("departure pilot date Before:" + departure_Pilot_Date);
		safeclick(driver, dep_Pilot);


		String dep_Pilot1 =  String.format(dep_Pilot_,portcode_row );


		safeclick(driver, dep_Pilot1);
		Step_End(6, "Click on Dep  Pilot  Row", test, test1);
		Step_Start(7, "Adjust the Date +/-", test, test1);

		waitForElement(driver, dep_Pilot1);
		

		if (date_Picker.equalsIgnoreCase("Yes")) {
			doubleClick(driver, dep_Pilot1);
		
		selectDatePickerWithTime(driver, dep_Pilot1, Dep_Pilot_Date);
		}
		
		
		
		Step_End(7, "Adjust the Date +/-", test, test1);
		String Distance_Val =  String.format(Distance_Val_, PortCode_Value);
		waitForElement(driver, Distance_Val);
		safeclick(driver, Distance_Val);

		String Dep_dock1 =  String.format(Dep_dock_, portcode_row);

		waitForElement(driver, Dep_dock1);
		String departure_Dock_Date1 = getText(driver, Dep_dock1);
		System.out.println("departure dock date:" + departure_Dock_Date1);



		String dep_Pilot2 =  String.format(dep_Pilot_,portcode_row );


		waitForElement(driver, dep_Pilot2);
		String departure_Pilot_Date1 = getText(driver, dep_Pilot2);
		System.out.println("departure pilot date After:" + departure_Pilot_Date1);

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Date d1 = format.parse(departure_Dock_Date1);
		Date d2 = format.parse(departure_Pilot_Date1);

		long diff = d2.getTime() - d1.getTime();

		long diffMinutes = diff / (60 * 1000);

		long diffHours = diffMinutes / 60;
		long remainingMinutes = diffMinutes % 60;

		System.out.println("Time in minutes: " + diffMinutes + " minutes.");
		System.out.println("Time in hours: " + diffHours + " hours.");

		String remaining_time = String.format("%02d:%02d", diffHours, remainingMinutes);
		System.out.println("Time difference: " + remaining_time);

		double doubleNumber = diffHours;
		System.out.println(doubleNumber);
		DecimalFormat decfor = new DecimalFormat("0.00");

		String hours = decfor.format(diffHours);
		System.out.println("Double Number: " + hours);
		String Calculation_Val = hours;
		waitForElement(driver, Man_time);
		String mantime1 = getText(driver, Man_time);
		System.out.println("man time out:" + mantime1);

		Extent_call(test, test1, "Verifying before adjusting depature pilot and After Depature pilot");

		if (!departure_Pilot_Date.equals(departure_Pilot_Date1)) {
			System.out
			.println("Not Matched || " + " Before Adjusting Departure Pilot Date value   : " + departure_Pilot_Date
					+ " ||After Adjusting Departure Pilot Date value is changed: " + departure_Pilot_Date1);
			Extent_pass_New(driver,
					"Not Matched || " + " Before Adjusting  Departure Pilot Date value : " + departure_Pilot_Date
					+ " || After Adjusting Departure Pilot Date value is changed : " + departure_Pilot_Date1,
					test, test1);
		} else {
			System.out.println("matched || " + " Expected Activity is : " + departure_Pilot_Date
					+ " || Actual Activity is : " + departure_Pilot_Date1);
			Extent_fail(driver, "matched || " + " Expected Activity is : " + departure_Pilot_Date
					+ " || Actual Activity is : " + departure_Pilot_Date1, test, test1);
		}

		String ManTime_Value[] = mantime1.split("\\.");
		String Terminal_Calculation[] = Calculation_Val.split("\\.");
		System.out.println("splitvalue1[0] " + ManTime_Value[0]);
		System.out.println("splitvalue2[0] " + Terminal_Calculation[0]);

		if ((ManTime_Value[0]).trim().equals(Terminal_Calculation[0].trim())) {
			System.out.println(
					"Matched || " + " Before Adjusting date and time the value is changed   : " + ManTime_Value[0]
							+ " ||After Adjusting date and time the value is changed: " + Terminal_Calculation[0]);
			Extent_pass_New(driver,
					"Matched || " + " Before Adjusting date and time the value is changed : " + ManTime_Value[0]
							+ " || After Adjusting date and time the value is changed : " + Terminal_Calculation[0],
							test, test1);
		} else {
			System.out.println("Not matched || " + " Expected Activity is : " + ManTime_Value[0]
					+ " || Actual Activity is : " + Terminal_Calculation[0]);
			Extent_fail(driver, "Not matched || " + " Expected Activity is : " + ManTime_Value[0]
					+ " || Actual Activity is : " + Terminal_Calculation[0], test, test1);
		}
		waitForElement(driver, Voyage_Details_Table);

		List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String voyage_Details_after=TableDataForReport(driver, voyage_Details_After, table_Name, columns);

	


		if (!voyage_Details_Before.equals(voyage_Details_After)) {
			Extent_pass_New(driver, "Not Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
		} else {
			Extent_fail(driver,
					"  Matched || Before Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_before + "</div></pre>\n"+"After Table Value : \n"+"<pre> <div style='overflow-x:auto;'>" + voyage_Details_after + "</div></pre>", test,test1);
		}
		Extent_completed(testCaseName, test, test1);
	}
}