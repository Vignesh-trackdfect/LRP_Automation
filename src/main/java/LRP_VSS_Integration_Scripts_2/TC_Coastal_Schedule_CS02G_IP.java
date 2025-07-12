package LRP_VSS_Integration_Scripts_2;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS02G_IP extends Keywords {

	public void integration_CS02G_IP(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS02G_IP";


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Search_input = Excel_data.get("Search_input");
		String service_code = Excel_data.get("service_code");
		String vesselName = Excel_data.get("vesselName");
		String voyage_num = Excel_data.get("voyage_num");
		String portcode_value = Excel_data.get("portcode_value");
		String Select_Columns = Excel_data.get("Select_Columns");
		String man_in_data = Excel_data.get("man_in_data");
		String man_out_data = Excel_data.get("man_out_data");
		String terminal_data = Excel_data.get("terminal_data");
		String negative_value = Excel_data.get("After_negative_value");

		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		String table_Name = Excel_data.get("Table_Name");
		
		String voyage = String.format(Coastal_Schedule_Locators.voyage_CS2G, voyage_num);
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

		Step_Start(5, "Click on Any port call", test, test1);

		waitForElement(driver, port_code);
		doubleClick(driver, port_code);

		Step_End(5, "Click on Any port call", test, test1);

		
		Step_Start(6, "Click on man Time IN, Man time Out, Terminal Time", test, test1);
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
		String before_Table=TableDataForReport(driver, voyage_Details_Before, table_Name, columns);
		
	
		waitForElement(driver, voyage_det_portcode);
		String portcode_row = getAttribute(driver, voyage_det_portcode, "aria-rowindex");
		System.out.println("portcode_row: " + portcode_row);

		int rownum=Integer.parseInt(portcode_row);
		int new_rownum = rownum+1;
		String next_row=Integer.toString(new_rownum);
		String Arr_dock =String.format(Coastal_Schedule_Locators.Arr_dock_CS2G, portcode_row);
		waitForElement(driver, Arr_dock);
		String Before_Arrdock_date = getText(driver, Arr_dock);
		System.out.println("Before_Arrdock_date:" + Before_Arrdock_date);
		String Dep_dock =String.format(Coastal_Schedule_Locators.Dep_dock_CS2G, portcode_row);

		waitForElement(driver, Dep_dock);
		String Before_Depdock_date = getText(driver, Dep_dock);
		System.out.println("Before_Depdock_date:" + Before_Depdock_date);
		String Dep_pilot =String.format(Coastal_Schedule_Locators.Dep_pilot_CS2G, portcode_row);
		waitForElement(driver, Dep_pilot);
		String Before_Deppilot_date = getText(driver, Dep_pilot);
		System.out.println("Before_Deppilot_date:" + Before_Deppilot_date);

		String BOSP =String.format(Coastal_Schedule_Locators.BOSP_CS2G, portcode_row);
		waitForElement(driver, BOSP);
		String Before_BOSP_date = getText(driver, BOSP);
		System.out.println("Before_BOSP_date:" + Before_BOSP_date);
		Step_End(6, "Click on man Time IN, Man time Out, Terminal Time", test, test1);

		Extent_call(test, test1, "When the Man Time in is adjusted, then the Date should be changed in Arr Dock /dep Dock / Dep Pilot / BOSP in the voyage ");

		Step_Start(7, "Enter any numerical Value", test, test1);
		String mantimein =String.format(Coastal_Schedule_Locators.mantimein_CS2G, portcode_row);
		waitForElement(driver, mantimein);
		click(driver, mantimein);
		waitForElement(driver, mantimein);
		doubleClick(driver, mantimein);
		waitForElement(driver, mantimein);
		Actionsendkeys(driver, mantimein, man_in_data);
		enter(driver);
		waitForElement(driver, mantimein);
		String manin_value = getText(driver, mantimein);
		if(man_in_data.contains("-")) {
			if(manin_value.equals(negative_value)) {
				System.out.println("Matched || Expected man time in : " +negative_value+ " || Actual man time in : " + manin_value);
				Extent_pass_New(driver, "Matched || Expected man time in : " +negative_value+ " || Actual man time in : " + manin_value, test, test1);
			}
			else {
				System.out.println("Not Matched || Expected man time in : " +negative_value+ " || Actual man time in : " + manin_value);
				Extent_fail(driver, "Not Matched || Expected man time in : " +negative_value+ " || Actual man time in : " + manin_value, test, test1);
			}
		}


		String nextrow_Arr_dock =String.format(Coastal_Schedule_Locators.nextrow_Arr_dock_CS2G, next_row);
		waitForElement(driver, nextrow_Arr_dock);
		String After_Arrdock_date = getText(driver, nextrow_Arr_dock);
		System.out.println("After_Arrdock_date:" + After_Arrdock_date);

		waitForElement(driver, Dep_dock);
		String After_Depdock_date = getText(driver, Dep_dock);
		System.out.println("After_Depdock_date:" + After_Depdock_date);

		waitForElement(driver, Dep_pilot);
		String After_Deppilot_date = getText(driver, Dep_pilot);
		System.out.println("After_Deppilot_date:" + After_Deppilot_date);

		waitForElement(driver, BOSP);
		String After_BOSP_date = getText(driver, BOSP);
		System.out.println("After_BOSP_date:" + After_BOSP_date);


		if(Before_Arrdock_date.equals(After_Arrdock_date)) {
			System.out.println("Matched || Expected Arrdock date : " + Before_Arrdock_date+ " || Actual Arrdock date : " + After_Arrdock_date);
			Extent_fail(driver, "Matched || Expected Arrdock date : " + Before_Arrdock_date+ " || Actual Arrdock date : " + After_Arrdock_date, test, test1);
		}
		else {
			System.out.println("Not Matched || Expected Arrdock date : " + Before_Arrdock_date+ " || Actual Arrdock date : " + After_Arrdock_date);
			Extent_pass_New(driver, "Not Matched || Expected Arrdock date : " + Before_Arrdock_date+ " || Actual Arrdock date : " + After_Arrdock_date, test, test1);
		}

		if(Before_Depdock_date.equals(After_Depdock_date)) {
			System.out.println("Matched || Expected Depdock date : " + Before_Depdock_date+ " || Actual Depdock date : " + After_Depdock_date);
			Extent_fail(driver, "Matched || Expected Depdock date : " + Before_Depdock_date+ " || Actual Depdock date : " + After_Depdock_date, test, test1);
		}
		else {
			System.out.println("Not Matched || Expected Depdock date : " + Before_Depdock_date+ " || Actual Depdock date : " + After_Depdock_date);
			Extent_pass_New(driver, "Not Matched || Expected Depdock date : " + Before_Depdock_date+ " || Actual Depdock date : " + After_Depdock_date, test, test1);
		}

		if(Before_Deppilot_date.equals(After_Deppilot_date)) {
			System.out.println("Matched || Expected Deppilot date : " + Before_Deppilot_date+ " || Actual Deppilot date : " + After_Deppilot_date);
			Extent_fail(driver, "Matched || Expected Deppilot date : " + Before_Deppilot_date+ " || Actual Deppilot date : " + After_Deppilot_date, test, test1);
		}
		else {
			System.out.println("Not Matched || Expected Deppilot date : " + Before_Deppilot_date+ " || Actual Deppilot date : " + After_Deppilot_date);
			Extent_pass_New(driver, "Not Matched || Expected Deppilot date : " + Before_Deppilot_date+ " || Actual Deppilot date : " + After_Deppilot_date, test, test1);
		}

		if(!Before_BOSP_date.equals(After_BOSP_date)) {

			System.out.println("Not Matched || Expected BOSP date : " + Before_BOSP_date+ " || Actual BOSP date : " + After_BOSP_date);
			Extent_pass_New(driver, "Not Matched || Expected BOSP date : " + Before_BOSP_date+ " || Actual BOSP date : " + After_BOSP_date, test, test1);
	
		}
		else {
			System.out.println("Matched || Expected BOSP date : " + Before_BOSP_date+ " || Actual BOSP date : " + After_BOSP_date);
			Extent_fail(driver, "Matched || Expected BOSP date : " + Before_BOSP_date+ " || Actual BOSP date : " + After_BOSP_date, test, test1);
	}

		Extent_call(test, test1, "When the Man Time Out is adjusted, then the Date should be changed in dep Pilot / BOSP in the voyage");

		String mantimeout =String.format(Coastal_Schedule_Locators.mantimeout_CS2G, portcode_row);
		waitForElement(driver, mantimeout);
		doubleClick(driver, mantimeout);
		waitForElement(driver, mantimeout);
		waitForElement(driver, mantimeout);
		click(driver, mantimeout);
		waitForElement(driver, mantimeout);
		doubleClick(driver, mantimeout);
		waitForElement(driver, mantimeout);
		Actionsendkeys(driver, mantimeout, man_out_data);
		enter(driver);
		waitForElement(driver, mantimeout);
		String manout_value = getText(driver, mantimeout);
		if(man_out_data.contains("-")) {
			if(manout_value.equals(negative_value)) {
				System.out.println("Matched || Expected man time out : " +negative_value+ " || Actual man time out : " + manout_value);
				Extent_pass_New(driver, "Matched || Expected man time out : " +negative_value+ " || Actual man time out : " + manout_value, test, test1);
			}
			else {
				System.out.println("Not Matched || Expected man time out : " +negative_value+ " || Actual man time out : " + manout_value);
				Extent_fail(driver, "Not Matched || Expected man time out : " +negative_value+ " || Actual man time out : " + manout_value, test, test1);
			}
		}


		waitForElement(driver, Dep_pilot);
		String After_Deppilot_date2 = getText(driver, Dep_pilot);
		System.out.println("After_Deppilot_date2:" + After_Deppilot_date2);

		waitForElement(driver, BOSP);
		String After_BOSP_date2 = getText(driver, BOSP);
		System.out.println("After_BOSP_date2:" + After_BOSP_date2);

		if(After_Deppilot_date2.equals(After_Deppilot_date)) {
			System.out.println("Matched || Expected Deppilot date : " + After_Deppilot_date+ " || Actual Deppilot date : " + After_Deppilot_date2);
			Extent_fail(driver, "Matched || Expected Deppilot date : " + After_Deppilot_date+ " || Actual Deppilot date : " + After_Deppilot_date2, test, test1);
		}
		else {
			System.out.println("Not Matched || Expected Deppilot date : " + After_Deppilot_date+ " || Actual Deppilot date : " + After_Deppilot_date2);
			Extent_pass_New(driver, "Not Matched || Expected Deppilot date : " + After_Deppilot_date+ " || Actual Deppilot date : " + After_Deppilot_date2, test, test1);
		}

		if(After_BOSP_date2.equals(After_BOSP_date)) {
			System.out.println("Matched || Expected BOSP date : " + After_BOSP_date+ " || Actual BOSP date : " + After_BOSP_date2);
			Extent_fail(driver, "Matched || Expected BOSP date : " + After_BOSP_date+ " || Actual BOSP date : " + After_BOSP_date2, test, test1);
		}
		else {
			System.out.println("Not Matched || Expected BOSP date : " + After_BOSP_date+ " || Actual BOSP date : " + After_BOSP_date2);
			Extent_pass_New(driver, "Not Matched || Expected BOSP date : " + After_BOSP_date+ " || Actual BOSP date : " + After_BOSP_date2, test, test1);
		}

		Extent_call(test, test1, "When the Terminal  Time  is adjusted, then the Date should be changed in Dep Dock /dep Pilot / BOSP in the voyage");

		String terminaltime =String.format(Coastal_Schedule_Locators.terminaltimeCS2G, portcode_row);
		waitForElement(driver, terminaltime);
		click(driver, terminaltime);
		waitForElement(driver, terminaltime);
		doubleClick(driver, terminaltime);
		waitForElement(driver, terminaltime);
		Actionsendkeys(driver, terminaltime, terminal_data);
		enter(driver);
		waitForElement(driver, terminaltime);

		String terminal_value = getText(driver, terminaltime);
		if(terminal_data.contains("-")) {
			if(terminal_value.equals(negative_value)) {
				System.out.println("Matched || Expected terminal time : " +negative_value+ " || Actual terminal time : " + terminal_value);
				Extent_pass_New(driver, "Matched || Expected terminal time : " +negative_value+ " || Actual terminal time : " + terminal_value, test, test1);
			}
			else {
				System.out.println("Not Matched || Expected terminal time : " +negative_value+ " || Actual terminal time : " + terminal_value);
				Extent_fail(driver, "Not Matched || Expected terminal time : " +negative_value+ " || Actual terminal time : " + terminal_value, test, test1);
			}
		}

		waitForElement(driver, Dep_dock);
		String After_Depdock_date3 = getText(driver, Dep_dock);
		System.out.println("After_Depdock_date3:" + After_Depdock_date3);

		waitForElement(driver, Dep_pilot);
		String After_Deppilot_date3 = getText(driver, Dep_pilot);
		System.out.println("After_Deppilot_date3:" + After_Deppilot_date3);

		waitForElement(driver, BOSP);
		String After_BOSP_date3 = getText(driver, BOSP);
		System.out.println("After_BOSP_date3:" + After_BOSP_date3);

		if(After_Depdock_date3.equals(After_Depdock_date)) {
			System.out.println("Matched || Expected Depdock date : " + After_Depdock_date+ " || Actual Depdock date : " + After_Depdock_date3);
			Extent_fail(driver, "Matched || Expected Depdock date : " + After_Depdock_date+ " || Actual Depdock date : " + After_Depdock_date3, test, test1);
		}
		else {
			System.out.println("Not Matched || Expected Depdock date : " + After_Depdock_date+ " || Actual Depdock date : " + After_Depdock_date3);
			Extent_pass_New(driver, "Not Matched || Expected Depdock date : " + After_Depdock_date+ " || Actual Depdock date : " + After_Depdock_date3, test, test1);
		}

		if(After_Deppilot_date2.equals(After_Deppilot_date3)) {
			System.out.println("Matched || Expected Deppilot date : " + After_Deppilot_date2+ " || Actual Deppilot date : " + After_Deppilot_date3);
			Extent_fail(driver, "Matched || Expected Deppilot date : " + After_Deppilot_date2+ " || Actual Deppilot date : " + After_Deppilot_date3, test, test1);
		}
		else {
			System.out.println("Not Matched || Expected Deppilot date : " + After_Deppilot_date2+ " || Actual Deppilot date : " + After_Deppilot_date3);
			Extent_pass_New(driver, "Not Matched || Expected Deppilot date : " + After_Deppilot_date2+ " || Actual Deppilot date : " + After_Deppilot_date3, test, test1);
		}

		if(After_BOSP_date3.equals(After_BOSP_date2)) {
			System.out.println("Matched || Expected BOSP date : " + After_BOSP_date2+ " || Actual BOSP date : " + After_BOSP_date3);
			Extent_fail(driver, "Matched || Expected BOSP date : " + After_BOSP_date2+ " || Actual BOSP date : " + After_BOSP_date3, test, test1);
		}
		else {
			System.out.println("Not Matched || Expected BOSP date : " + After_BOSP_date2+ " || Actual BOSP date : " + After_BOSP_date3);
			Extent_pass_New(driver, "Not Matched || Expected BOSP date : " + After_BOSP_date2+ " || Actual BOSP date : " + After_BOSP_date3, test, test1);
		}

		waitForElement(driver, Voyage_Details_Table);

		List<Map<String, String>> voyage_Details_After = extractTableDataByRowIndex(driver, Voyage_Details_Table,row_Count);
		String after_Table=TableDataForReport(driver, voyage_Details_After, table_Name, columns);

	
		if (!after_Table.equals(before_Table)) {
			Extent_pass_New(driver, "Not Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + before_Table+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+after_Table+"</div>"+ "</pre>", test,test1);
		} else {
			Extent_fail(driver, "Matched || Before Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>" + before_Table+ "</div>"+ "</pre>"+"<br> After Table Value :  <br>"+"<pre>" +"<div style='overflow-x:auto;'>"+after_Table+"</div>"+ "</pre>", test,test1);
		}
		Step_End(7, "Enter any numerical Value", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}
