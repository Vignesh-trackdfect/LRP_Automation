package LRP_VSS_Integration_Scripts_2;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS02C_IP extends Keywords {
	public void integration_CS02C_IP (WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Coastal_Schedule_CS02C_IP";
		  
		
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
		safeclick(driver, voyage);
		
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
		
		waitForElement(driver, voyage_det_portcode);
		click(driver, voyage_det_portcode);
		waitForElement(driver, voyage_det_portcode);

		
		String portcode_row=getAttribute(driver, voyage_det_portcode, "aria-rowindex");
		
		System.out.println("portcode_row: "+portcode_row);

		String arr_pilot = String.format(Coastal_Schedule_Locators.arrPilotDate, portcode_row);
		String start_date = getText(driver, arr_pilot);
	    System.out.println("start_date: "+start_date);

	    	String speed = String.format(Coastal_Schedule_Locators.speed, portcode_row);
				String actSpeed = getText(driver, speed);
				System.out.println("end_time: "+actSpeed);
				
				String arr_pilot1 =String.format(Coastal_Schedule_Locators.arrPilotDate, portcode_row);
				waitForElement(driver, arr_pilot1);
    			click(driver, arr_pilot1);
    			
    			Step_End(5, "Click on Arr Pilot Row ", test, test1);
    			
    			Step_Start(6, "Adjust the Date +/-", test, test1);
    			
				waitForElement(driver, arr_pilot1);
				doubleClick(driver, arr_pilot1);
					
				if (date_Picker.equalsIgnoreCase("Yes")) {
					
					selectDatePickerWithTime(driver, arr_pilot1, arr_pilot_date);

				} else {
					waitForElement(driver, arr_pilot1);
					clearAndType(driver, arr_pilot1, arr_pilot_date);
					waitForDisplay(driver, calender_close);
					click(driver,calender_close);
				}
				
				Step_End(6, "Adjust the Date +/-", test, test1);
				
			waitForElement(driver, arrday);
			safeclick(driver, arrday);
			waitForElement(driver, arrday);

			
			int rownum=Integer.parseInt(portcode_row);
			int new_rownum = rownum-1;
			String next_row=Integer.toString(new_rownum);

			String arr_pilot2 = String.format(Coastal_Schedule_Locators.arrPilotDate, next_row);
			waitForElement(driver, arr_pilot2);

			String latest_rowvalue = getText(driver, arr_pilot2);
			System.out.println("latest_rowvalue: "+latest_rowvalue);
			
			 
			 String speed1 =String.format(Coastal_Schedule_Locators.speed, next_row);
				 String value1 = getText(driver, speed1);
					System.out.println("value1: "+value1);

				if(!start_date.equals(latest_rowvalue)) {
					System.out.println("Not Matched || Expected Arr pilot date : "+start_date+" || Actual Arr pilot date : "+latest_rowvalue);
					Extent_pass_New(driver,  "Not Matched ||Expected Arr pilot date shown before changing the dat : "+start_date+" || Actual Arr pilot date shown After changing the date : "+latest_rowvalue, test, test1);
			
				}else {
					System.out.println("Matched || Expected Arr pilot date : "+start_date+" || Actual Arr pilot date : "+latest_rowvalue);
					Extent_fail(driver, "Matched ||Expected Arr pilot date shown before changing the date : "+start_date+" || Actual Arr pilot date shown After changing the date : "+latest_rowvalue, test, test1);
				
				}  
				Step_Start(7, "Check the Speed of the previous port row ", test, test1);

				if(actSpeed.equals(value1)) {
					System.out.println("Matched || Expected Speed was : "+actSpeed+" || Actual Speed was : "+value1);
					Extent_fail(driver, "Matched || Expected Speed was shown before changing the date : "+start_date+" || Actual Speed was shown After changing the date : "+value1, test, test1);
				}else {
				System.out.println("Not Matched || Expected Speed was : "+actSpeed+" || Actual Speed was : "+value1);
				Extent_pass_New(driver,  "Not Matched || Expected Speed was shown before changing the date : "+actSpeed+" || Actual Speed was shown After changing the date : "+value1, test, test1);
			} 
				Step_End(7, "Check the Speed of the previous port row ", test, test1);
				
				waitForElement(driver, Voyage_Details_Table);

				List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
				String afterTableValue=TableDataForReport(driver, voyage_Details_After, table_Name, columns);

				
				if (!afterTableValue.equals(beforeTableValue)) {
					Extent_pass_New(driver, "Not Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + beforeTableValue+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+afterTableValue+"</div>"+ "</pre>", test,test1);
				} else {
					Extent_fail(driver, "Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + beforeTableValue+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+afterTableValue+"</div>"+ "</pre>", test,test1);
				}			
				
				Extent_Start(testCaseName, test, test1);
		
}
}
