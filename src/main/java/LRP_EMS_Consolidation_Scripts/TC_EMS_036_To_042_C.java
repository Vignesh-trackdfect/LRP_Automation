package LRP_EMS_Consolidation_Scripts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.On_Off_Hire_Locators;

public class TC_EMS_036_To_042_C extends Keywords{

	public void EMS_036_To_042_C(WebDriver driver,ExtentTest test,ExtentTest test1, String selected_dataset) throws Exception {


		int TC1=1;

		if(TC1==1) {

			String tc_Name="TC_On_Off_hire_status_TS036";

			String URL = TestNgXml.getdatafromExecution().get(tc_Name);
			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
			String Username = Excel_data.get("Username");
			String Password = Excel_data.get("Password");	
			String Search_input = Excel_data.get("Search_input");	
			String Location_hierachy36 = Excel_data.get("Location_hierachy36");	
			String Country_Code_value36 = Excel_data.get("Country_Code_value36");	
			String Sizeandtype_value36 = Excel_data.get("Sizeandtype_value36");	
			String service_input36 = Excel_data.get("service_input36");	
			String lessor_input36 = Excel_data.get("lessor_input36");	
			String condt_input36 = Excel_data.get("condt_input36");	
			String reportype_input36 = Excel_data.get("reportype_input36");	
			String lessorcontract_input36 = Excel_data.get("lessorcontract_input36");	
			String leasekind_input36 = Excel_data.get("leasekind_input36");	
			String lessee_input36 = Excel_data.get("lessee_input36");	
			String activity_input36 = Excel_data.get("activity_input36");	
			String sz_tp_buttons36 = Excel_data.get("sz_tp_buttons36");	
			String sum_det_input36 = Excel_data.get("sum_det_input36");	
			String detail_request = Excel_data.get("detail_request");	
			String date_Picker = Excel_data.get("date_Picker");
			String From_Date = Excel_data.get("From_Date");
			String To_Date = Excel_data.get("To_Date");	
			String Perform_ToDate = Excel_data.get("Perform_ToDate");	
			String equipment_first_cell = Excel_data.get("equipment_first_cell");	
			String equipment_last_cell = Excel_data.get("equipment_last_cell");	
			String condition = Excel_data.get("condition");	
			String service_code_header = Excel_data.get("service_code_header");
			String lessor_code_header = Excel_data.get("lessor_code_header");
			String contract_number_header = Excel_data.get("contract_number_header");
			String lesee_code_header = Excel_data.get("lesee_code_header");
			String activity_code_header = Excel_data.get("activity_code_header");
			String equipment_type_header = Excel_data.get("equipment_type_header");
			
			String country_code_header = Excel_data.get("country_code_header");
			

			
			String condt_input =String.format(On_Off_Hire_Locators.condt_input, condt_input36);
			String reportype_input =String.format(On_Off_Hire_Locators.reportype_input, reportype_input36);
			String leasekind_input =String.format(On_Off_Hire_Locators.leasekind_input, leasekind_input36);
			String sz_tp_btn =String.format(On_Off_Hire_Locators.sz_tp_btn, sz_tp_buttons36);
			String sum_det_btn =String.format(On_Off_Hire_Locators.sum_det_btn, sum_det_input36);
			String location_hierarchy_type =String.format(On_Off_Hire_Locators.location_hierarchy_type, Location_hierachy36);

			Extent_Start(tc_Name, test, test1);
			
			Step_Start(1, "open chrome browser ", test, test1);
			Step_Start(2, "Enter the url", test, test1);
			navigateUrl(driver, URL); 
			Step_End(2, "Enter the url", test, test1);
			Step_End(1, "open chrome browser ", test, test1);

			LRP_Login(driver, Username, Password);
		    
			Step_Start(6, "click on search field", test, test1);
			Step_Start(7, "Enter the Stock Report by on/off hire status field in search box", test, test1);
		
			moduleNavigate(driver, Search_input);

		    Step_End(7, "Enter the Stock Report by on/off hire status field in search box", test, test1);
			Step_End(6, "click on search field", test, test1);
		    
		    if(!service_input36.equals("")) {
					waitForElement(driver, Service_searchicon);
					click(driver, Service_searchicon);
					twoColumnSearchWindow(driver, service_code_header, condition, Sizeandtype_value36);
				}else {
					System.out.println("service_input36 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!lessor_input36.equals("")) {
				
					waitForElement(driver, lessor_searchicon);
					click(driver, lessor_searchicon);
					twoColumnSearchWindow(driver, lessor_code_header, condition, lessor_input36);

					
				
				}else {
					System.out.println("lessor_input36 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!condt_input36.equals("")) {
		    	waitForElement(driver, Condt_field);
		    	click(driver, Condt_field);
					waitForElement(driver, condt_input);
		    		click(driver, condt_input);
				
				}else {
					System.out.println("condt_input36 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!reportype_input36.equals("")) {
		    	waitForElement(driver, report_type_field);
		    	click(driver, report_type_field);
					waitForElement(driver, reportype_input);
		    		click(driver, reportype_input);
				
				}else {
					System.out.println("reportype_input36 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!lessorcontract_input36.equals("")) {
					waitForElement(driver, lessorcontract_searchicon);
					click(driver, lessorcontract_searchicon);
					twoColumnSearchWindow(driver, contract_number_header, condition, lessorcontract_input36);


				
				}else {
					System.out.println("lessorcontract_input36 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!leasekind_input36.equals("")) {
		    	waitForElement(driver, Leasekind_field);
		    	click(driver, Leasekind_field);
					waitForElement(driver, leasekind_input);
		    		click(driver, leasekind_input);
				
				}else {
					System.out.println("leasekind_input36 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!lessee_input36.equals("")) {
					waitForElement(driver, lessee_searchicon);
					click(driver, lessee_searchicon);
					twoColumnSearchWindow(driver, lesee_code_header, condition, lessee_input36);

				
				}else {
					System.out.println("lessee_input36 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!activity_input36.equals("")) {
					waitForElement(driver, activity_Addicon);
					click(driver, activity_Addicon);
					twoColumnSearchWindow(driver, activity_code_header, condition, activity_input36);

				
				}else {
					System.out.println("activity_input36 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!sz_tp_buttons36.equals("")) {
		    		waitForElement(driver, sz_tp_btn);
		    		click(driver, sz_tp_btn);
				}else {
					System.out.println("sz_tp_buttons36 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!sum_det_input36.equals("")) {
		    		waitForElement(driver, sum_det_btn);
		    		click(driver, sum_det_btn);
				
				}else {
					System.out.println("sum_det_input36 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(detail_request.equals("YES")) {
		    		waitForElement(driver, detail_Requestbtn);
		    		click(driver, detail_Requestbtn);
				
				}else {
					System.out.println("detail_request "+"Input Not Available in : "+File_Path);
				}
		    
			Step_Start(8, "Click locational hierarchy drop menu", test, test1);
			waitForElement(driver, locations_inputfield);
			click(driver,locations_inputfield);
			
			waitForElement(driver, location_hierarchy_type);
			click(driver, location_hierarchy_type);
			
			
			waitForElement(driver, location_Dropdownoption);
			String locationDropdown_option4 = getText(driver, location_Dropdownoption);
			System.out.println("locationDropdown_option4: "+locationDropdown_option4);
			if(locationDropdown_option4.equals(Location_hierachy36)) {
				System.out.println("MATCHED || EXPECTED DROPDOWN VALUE IS: "+Location_hierachy36+ " || ACTUAL DROPDOWN VALUE IS :"+locationDropdown_option4 );
				Extent_pass_New(driver, "MATCHED || EXPECTED DROPDOWN VALUE IS: "+Location_hierachy36+ " || ACTUAL DROPDOWN VALUE IS :"+locationDropdown_option4, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED DROPDOWN VALUE IS: "+Location_hierachy36+ " || ACTUAL DROPDOWN VALUE IS :"+locationDropdown_option4 );
				Extent_fail(driver, "NOT MATCHED || EXPECTED DROPDOWN VALUE IS: "+Location_hierachy36+ " || ACTUAL DROPDOWN VALUE IS :" +locationDropdown_option4, test, test1);
			}  
			Step_End(8, "Click locational hierarchy drop menu", test, test1);

			Step_Start(9, "Click search icon & select country accordingly", test, test1);
			waitForElement(driver, country_searchicon36);
			click(driver,country_searchicon36);
			twoColumnSearchWindow(driver, country_code_header, condition, Country_Code_value36);
			
			Step_End(9, "Click search icon & select country accordingly", test, test1);	
			
			Step_Start(10, "Click Size/type from drop menu then select option accrodingly", test, test1);
			waitForElement(driver, add_sizetype);
			click(driver,add_sizetype);
			twoColumnSearchWindow(driver, equipment_type_header, condition, Sizeandtype_value36);
			
			Step_End(10, "Click Size/type from drop menu then select option accrodingly", test, test1);

			Step_Start(11, "Select date from & to range accordingly ", test, test1);
			waitForElement(driver, fromdate36);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePicker(driver, fromdate36, From_Date);
	
			} else {
				waitForElement(driver, fromdate36);
				clearAndType(driver, fromdate36, From_Date);
			}
			
			if(Perform_ToDate.equals("YES")) {
			waitForElement(driver, To_Date_New);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePicker(driver, To_Date_New, To_Date);
				
			} else {
				waitForElement(driver, To_Date_New);
				clearAndType(driver, To_Date_New, To_Date);
			}
			}
			Step_End(11, "Select date from & to range accordingly ", test, test1);
	
			Step_Start(12, "Click show button & it will show data in grid accordingly", test, test1);
			waitForElement(driver, click_showbtn);
			click(driver,click_showbtn);   
			Step_End(12, "Click show button & it will show data in grid accordingly", test, test1);

			Step_Start(12, "verify it show the data in the grid or not", test, test1);
			
			int first_cell = Integer.parseInt(equipment_first_cell);
			int last_cell = Integer.parseInt(equipment_last_cell);
	
			
			for(int i=first_cell;i<=last_cell;i++ ) {
				
				String cell_click=String.format(gridvalue_by_index, Sizeandtype_value36,i);
				
				String cellvalue = getText(driver, cell_click);
				Step_Start(13, "double the respective size/type count to get equipment listed detials", test, test1);

				click(driver, cell_click);
				
				Step_End(13, "double the respective size/type count to get equipment listed detials", test, test1);

				Step_Start(14, "verify after showing the grid double click on size/type that same count showing on the popup or not", test, test1);

				waitForElement(driver, ems_page_on_off_hire);
				String total_records_count = getText(driver, total_records36);
				
				if(cellvalue.equals(total_records_count)) {
					
					System.out.println("Expected equipment details count "+cellvalue+"|| actual equipment details count "+total_records_count);
					Extent_pass_New(driver, "Expected equipment details count "+cellvalue+"|| actual equipment details count "+total_records_count, test, test1);
				click(driver, ems_panel_close);
				
				}
				else {
					
					System.out.println("Expected equipment details count "+cellvalue+"|| actual equipment details count "+total_records_count);
					Extent_fail(driver, "Expected equipment details count "+cellvalue+"|| actual equipment details count "+total_records_count, test, test1);
					
				}
				Step_End(14, "verify after showing the grid double click on size/type that same count showing on the popup or not", test, test1);

			}
			

		
			Extent_completed(tc_Name, test, test1);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}

		int TC2=1;

		if(TC2==1) {

			String tc_Name="TC_On_Off_hire_status_TS037";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
		String Search_input = Excel_data.get("Search_input");	
		String Location_hierachy37= Excel_data.get("Location_hierachy37");	
		String Country_Code_value37= Excel_data.get("Country_Code_value37");	
		String Sizeandtype_value37 = Excel_data.get("Sizeandtype_value37");	
		String Perform_ToDate = Excel_data.get("Perform_ToDate");	
		String Request_Sent37 = Excel_data.get("Request_Sent37");	
		String service_input37 = Excel_data.get("service_input37");	
		String lessor_input37 = Excel_data.get("lessor_input37");	
		String condt_input37 = Excel_data.get("condt_input37");	
		String reportype_input37 = Excel_data.get("reportype_input37");	
		String lessorcontract_input37 = Excel_data.get("lessorcontract_input37");	
		String leasekind_input37 = Excel_data.get("leasekind_input37");	
		String lessee_input37 = Excel_data.get("lessee_input37");	
		String activity_input37 = Excel_data.get("activity_input37");	
		String sz_tp_buttons37 = Excel_data.get("sz_tp_buttons37");	
		String sum_det_button37 = Excel_data.get("sum_det_button37");	
		String detail_request = Excel_data.get("detail_request");	
		String date_Picker = Excel_data.get("date_Picker");
		String From_Date = Excel_data.get("From_Date");
		String To_Date = Excel_data.get("To_Date");	
		String condition = Excel_data.get("condition");	
		String service_code_header = Excel_data.get("service_code_header");
		String lessor_code_header = Excel_data.get("lessor_code_header");
		String contract_number_header = Excel_data.get("contract_number_header");
		String lesee_code_header = Excel_data.get("lesee_code_header");
		String activity_code_header = Excel_data.get("activity_code_header");
		String equipment_type_header = Excel_data.get("equipment_type_header");
		String country_code_header = Excel_data.get("country_code_header");

		String condt_input =String.format(On_Off_Hire_Locators.condt_input, condt_input37);
		String reportype_input =String.format(On_Off_Hire_Locators.reportype_input, reportype_input37);
		String leasekind_input =String.format(On_Off_Hire_Locators.leasekind_input, leasekind_input37);
		String sz_tp_btn =String.format(On_Off_Hire_Locators.sz_tp_btn, sz_tp_buttons37);
		String sum_det_btn =String.format(On_Off_Hire_Locators.sum_det_btn, sum_det_button37);
		String location_hierarchy_type1 =String.format(On_Off_Hire_Locators.location_hierarchy_type1, Location_hierachy37);
		
		Extent_Start(tc_Name, test, test1);
		
	

			Step_Start(6, "click on search field", test, test1);
			Step_Start(7, "Enter the Stock Report by on/off hire status field in search box", test, test1);
			
			moduleNavigate(driver, Search_input);
			
		    Step_End(7, "Enter the Stock Report by on/off hire status field in search box", test, test1);
			Step_End(6, "click on search field", test, test1);
		    
		    if(!service_input37.equals("")) {
					waitForElement(driver, service_searchicon);
					click(driver, service_searchicon);
					twoColumnSearchWindow(driver, service_code_header, condition, service_input37);

				
				}else {
					System.out.println("service_input37 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!lessor_input37.equals("")) {
					waitForElement(driver, lessor_searchicon);
					click(driver, lessor_searchicon);
					twoColumnSearchWindow(driver, lessor_code_header, condition, lessor_input37);

				
				}else {
					System.out.println("lessor_input37 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!condt_input37.equals("")) {
		    	waitForElement(driver, Condt_field);
		    	click(driver, Condt_field);
					waitForElement(driver, condt_input);
		    		click(driver, condt_input);
				}else {
					System.out.println("condt_input37 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!reportype_input37.equals("")) {
		    	waitForElement(driver, report_type_field);
		    	click(driver, report_type_field);
					waitForElement(driver, reportype_input);
		    		click(driver, reportype_input);
				}else {
					System.out.println("reportype_input37 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!lessorcontract_input37.equals("")) {
					waitForElement(driver, lessorcontract_searchicon);
					click(driver, lessorcontract_searchicon);
					twoColumnSearchWindow(driver, contract_number_header, condition, lessorcontract_input37);

				
				}else {
					System.out.println("lessorcontract_input37 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!leasekind_input37.equals("")) {
		    	waitForElement(driver, Leasekind_field);
		    	click(driver, Leasekind_field);
					waitForElement(driver, leasekind_input);
		    		click(driver, leasekind_input);
				
				}else {
					System.out.println("leasekind_input37 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!lessee_input37.equals("")) {
					waitForElement(driver, lessee_searchicon);
					click(driver, lessee_searchicon);
					twoColumnSearchWindow(driver, lesee_code_header, condition, lessee_input37);

				
				}else {
					System.out.println("lessee_input37 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!activity_input37.equals("")) {
					waitForElement(driver, activity_Addicon);
					click(driver, activity_Addicon);
					twoColumnSearchWindow(driver, activity_code_header, condition, activity_input37);

				
				}else {
					System.out.println("activity_input37 "+"Input Not Available in : "+File_Path);
				}
		    
		    if(!sz_tp_buttons37.equals("")) {
		    		waitForElement(driver, sz_tp_btn);
		    		click(driver, sz_tp_btn);
				}else {
					System.out.println("sz_tp_buttons37 "+"Input Not Available in : "+File_Path);
				}
		    
			Step_Start(14, "Click show button by selecting detail option & it will show data in grid accordingly", test, test1);
		    if(!sum_det_button37.equals("")) {
		    		waitForElement(driver, sum_det_btn);
		    		click(driver, sum_det_btn);
				
				}else {
					System.out.println("sum_det_button37 "+"Input Not Available in : "+File_Path);
				}
			Step_End(14, "Click show button by selecting detail option & it will show data in grid accordingly", test, test1);

		    if(detail_request.equals("YES")) {
		    		waitForElement(driver, detail_Requestbtn);
		    		click(driver, detail_Requestbtn);
				
				}else {
					System.out.println("detail_request "+"Input Not Available in : "+File_Path);
				}
		    
			Step_Start(8, "Click locational hierarchy drop menu", test, test1);
			waitForElement(driver, locations_inputfield);
			click(driver,locations_inputfield);
			waitForElement(driver, location_hierarchy_type1);
			click(driver, location_hierarchy_type1);
			
			
			waitForElement(driver, location_dropdown37);
			String locationDropdownoption41 = getText(driver, location_dropdown37);
			if(locationDropdownoption41.equals(Location_hierachy37)) {
				System.out.println("Matched || Expected location value :"+Location_hierachy37+" Actual location value : "+locationDropdownoption41);
				Extent_pass_New(driver, "Matched || Expected location value :"+Location_hierachy37+" Actual location value : "+locationDropdownoption41, test, test1);
			}else {
				System.out.println("Not Matched || Expected location value :"+Location_hierachy37+" Actual location value : "+locationDropdownoption41);
				Extent_fail(driver, "Not Matched || Expected location value :"+Location_hierachy37+" Actual location value : "+locationDropdownoption41, test, test1);
			}  
			Step_End(8, "Click locational hierarchy drop menu", test, test1);
			
			Step_Start(9, "Click search icon & select country accordingly", test, test1);
			waitForElement(driver, country_searchicon36);
			click(driver,country_searchicon36);
			twoColumnSearchWindow(driver, country_code_header, condition, Country_Code_value37);

			Step_End(9, "Click search icon & select country accordingly", test, test1);	

			Step_Start(10, "Click Size/type from drop menu then select option accrodingly", test, test1);
			waitForElement(driver, add_sizetype);
			click(driver,add_sizetype);
			twoColumnSearchWindow(driver, equipment_type_header, condition, Sizeandtype_value37);
			Step_End(10, "Click Size/type from drop menu then select option accrodingly", test, test1);

			Step_Start(11, "Select date from & to range accordingly ", test, test1);			
			waitForElement(driver, fromdate36);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePicker(driver, fromdate36, From_Date);
			} else {
				waitForElement(driver, fromdate36);
				clearAndType(driver, fromdate36, From_Date);
			}
			
			if(Perform_ToDate.equals("YES")) {
			waitForElement(driver, To_Date_New);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePicker(driver, To_Date_New, To_Date);
			} else {
				waitForElement(driver, To_Date_New);
				clearAndType(driver, To_Date_New, To_Date);
			}
			}
			Step_End(11, "Select date from & to range accordingly ", test, test1);
			
			Step_Start(12, "Click show button & it will show data in grid accordingly", test, test1);
//			
			waitForElement(driver, click_showbtn);
			click(driver,click_showbtn);  
			Step_End(12, "Click show button & it will show data in grid accordingly", test, test1);

			Step_Start(15, "message shown as report request sent", test, test1);
			Step_Start(16, "verify the report request sent message or not", test, test1);
			waitForDisplay(driver, request_sent);
			if(isDisplayed(driver, request_sent)) {
			
			String report_request =getText(driver, request_sent);
			if(report_request.equals(Request_Sent37)) {
				System.out.println("Matched || EXPECTED POPUP: "+Request_Sent37+"ACTUAL POPUP: "+report_request);
				Extent_pass_New(driver, "Matched || EXPECTED POPUP: "+Request_Sent37+"ACTUAL POPUP: "+report_request, test, test1);
			}else {
				System.out.println("Not Matched || EXPECTED POPUP: "+Request_Sent37+"ACTUAL POPUP: "+report_request);
				Extent_fail(driver, "Not Matched || EXPECTED POPUP: "+Request_Sent37+"ACTUAL POPUP: "+report_request, test, test1);
			} 
			
			}else {
				
				System.out.println("Either Expected Popup is not displayed or Quickly disappear");
				Extent_Warning(driver, "Either Expected Popup is not displayed or Quickly disappear", test, test1);
				
			}
			Step_End(16, "verify the report request sent message or not", test, test1);
			Step_End(15, "message shown as report request sent", test, test1);
			
			Step_Start(17, "click download icon button & click the id once processed", test, test1);
			Step_Start(18, "Export sheet will be downloaded once clicked the processed id", test, test1);
		waitForElement(driver, download_btn)	;
	   click(driver, download_btn);
			
	   waitForDownload(driver, process);
			
			String processed_number=getText(driver, process_no);
			System.out.println("processed_number: "+processed_number);
			click(driver,process_no);
			
			Step_End(18, "Export sheet will be downloaded once clicked the processed id", test, test1);
			Step_End(17, "click download icon button & click the id once processed", test, test1);
			
			Step_Start(19, "verify the downloaded the sheet showing local file or not", test, test1);
			String path_for_downloaded = Downloadedfile(driver, processed_number);
			
			int count_in_excel = countRowsWithColumnNameForCsvFile(path_for_downloaded, "containerno");
			System.out.println(count_in_excel);
			
			waitForElement(driver, close_btn);
			click(driver, close_btn);
			
			waitForElement(driver, summary_option);
			click(driver, summary_option);
			
			waitForElement(driver, click_showbtn);
			click(driver,click_showbtn); 
			
			
			String grand_total_page=String.format(grand_total_in_page, Sizeandtype_value37);
			waitForElement(driver, grand_total_page);
			String total_count_expected = getText(driver, grand_total_page);
			int total_count_exp = Integer.parseInt(total_count_expected);
			System.out.println("Expected total count : "+total_count_exp);
			
			if(total_count_exp==count_in_excel) {
				
				System.out.println("Passed ||Both the excel and the grid values are same ");
				System.out.println("Matched || Containers in excel : "+count_in_excel+" || actual containers in grid : "+total_count_exp);
				Extent_pass_New(driver, "Matched || Containers in excel : "+count_in_excel+" || actual containers in grid : "+total_count_exp, test, test1);
			
			}else {
				
				System.out.println("failed ||Both the excel and the grid values are not same ");
				System.out.println("Not Matched || Containers in excel : "+count_in_excel+" || actual containers in grid : "+total_count_exp);
				Extent_fail(driver, "Not Matched || Containers in excel : "+count_in_excel+" || actual containers in grid : "+total_count_exp, test, test1);
			}
			Step_End(19, "verify the downloaded the sheet showing local file or not", test, test1);

			
			
			Extent_completed(tc_Name, test, test1);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		}

		int TC3=1;

		if(TC3==1) {


			String tc_Name="TC_Stock_Report_by_service_TS038";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
			String Search_input = Excel_data.get("Search_input");	
			String service_checkbox_click = Excel_data.get("service_checkbox_click");	
			String condition = Excel_data.get("condition");	
			String service_value = Excel_data.get("service_value");	
			String location_hierarchy_value = Excel_data.get("location_hierarchy_value");	
			String location_hierarchy_textfield_value = Excel_data.get("location_hierarchy_textfield_value");	
			String mty_full_indicator_value = Excel_data.get("mty_full_indicator_value");	
			String size_type_option_value = Excel_data.get("size_type_option_value");	
			String size_type_header = Excel_data.get("size_type_header");	
			String equipment_types_rows = Excel_data.get("equipment_types_rows");	
			String service_value_Header = Excel_data.get("service_value_Header");	
			String columns_to_select = Excel_data.get("columns_to_select");	
			String service_code_header = Excel_data.get("service_code_header");
			String different_headers = Excel_data.get("different_headers");
			String Selected_Columns = Excel_data.get("Selected_Columns");

			Extent_Start(tc_Name, test, test1);
		
		
			moduleNavigate(driver, Search_input);
			
			
			if(service_checkbox_click.equalsIgnoreCase("yes")) {
				
				Extent_call(test, test1, "Execution when the service checkbox is clicked ");
				
				Step_Start(1, "click the service checkbox", test, test1);
				
				waitForElement(driver, service_checkbox_SR);
				click(driver, service_checkbox_SR);
				
				Step_End(1, "click the service checkbox", test, test1);

				Step_Start(2, "click the service search icon", test, test1);
				
				
				waitForElement(driver, service_search_icon_SR);
				click(driver, service_search_icon_SR);
				twoColumnSearchWindow(driver, service_code_header, condition, service_value);

				Step_End(2, "click the service search icon", test, test1);

				Step_Start(3, "choose the option from location hierarchy dropdown", test, test1);
			
				waitForElement(driver, location_hierarchy_dd_SR);
				click(driver, location_hierarchy_dd_SR);
				
				String location_hie_dd = String.format(location_hierarchy_dd_Options_SR, location_hierarchy_value);
				
				waitForElement(driver, location_hie_dd);
				click(driver, location_hie_dd);
				
				Step_End(3, "choose the option from location hierarchy dropdown", test, test1);

				waitForElement(driver, location_hierarchy_search_icon);
				click(driver, location_hierarchy_search_icon);
				twoColumnSearchWindow(driver, different_headers, condition, location_hierarchy_textfield_value);


				Step_Start(4, "choose an option from mty/full indicator dropdown", test, test1);
				
				//mty/indicator
				waitForElement(driver, mty_full_indicator_SR);
				click(driver, mty_full_indicator_SR);
				
				String mty_full_option = String.format(mty_full_indicator_options_SR, mty_full_indicator_value);
				waitForElement(driver, mty_full_option);
				click(driver, mty_full_option);
				
				Step_End(4, "choose an option from mty/full indicator dropdown", test, test1);

				Step_Start(5, "click on size/type options", test, test1);
			
				//4size/type options
				
				String size_type_four_options = String.format(size_type_options_SR, size_type_option_value);
				waitForElement(driver, size_type_four_options);
				click(driver, size_type_four_options);
				
				Step_End(5, "click on size/type options", test, test1);

				Step_Start(6, "click on show button", test, test1);
				
				waitForElement(driver, show_btn_SR);
				click(driver, show_btn_SR);
				
				Step_End(6, "click on show button", test, test1);

				Step_Start(7, "Now get the value[service data and header] which is received from the test data", test, test1);
				
				reArrangeAG_GridColumnsWithoutCheckbox(driver, Selected_Columns);	

				waitForElement(driver, SR_module_table);
				
				List<Map<String, String>> SR_module_tabledata = extractTableDataByColumn(driver, SR_module_table);
				
				List<String> equipment_types_row = splitAndExpand(equipment_types_rows);
				
				for(String equipment_type:equipment_types_row) {
				
				String grid_value_to_check = getValueByFirstColumnAndHeader(SR_module_tabledata, size_type_header, equipment_type, service_value);
				
				System.out.println("grid_value_to_check "+grid_value_to_check);
				String firstHeader = String.format(service_column_header, service_value);
				waitForElement(driver, firstHeader);
				mouseOverToElement(driver, firstHeader);
				String firstColumnColId = getAttribute(driver, firstHeader, "col-id");
					
				Step_End(7, "Now get the value[service data and header] which is received from the test data", test, test1);

					String target_cell_click = String.format(Targeting_cell_Size_Type_value_SR, equipment_type,firstColumnColId,grid_value_to_check);
				String cell_count = getText(driver, target_cell_click);
				int cell_count_expected = Integer.parseInt(cell_count);
				

				Step_Start(8, "Get the count from the grid and double click on it", test, test1);
				
					click(driver,target_cell_click);
				
					Step_End(8, "Get the count from the grid and double click on it", test, test1);

					
				waitForElement(driver, stock_report_panel);
				
				scrollUsingElement(driver, bottom_panel);
				int total_Rows = 0;

				String status = getAttribute(driver, Last_Page_Button_Stock_Service_Grid,"class");
				
				if(!status.contains("disabled")) {
					waitForElement(driver, Last_Page_Button_Stock_Service_Grid);
					click(driver, Last_Page_Button_Stock_Service_Grid);
				}
				
				waitForElement(driver, Serial_Number_Gridcell_Service_Stock_Grid);
				String lastRow=getText(driver, Serial_Number_Gridcell_Service_Stock_Grid);
				total_Rows=Integer.parseInt(lastRow);
				
				waitForElement(driver, Last_Page_Button_Stock_Service_Grid);
				status = getAttribute(driver, Last_Page_Button_Stock_Service_Grid,"class");
				
				
				Step_Start(9, "And now the records in the service count should be match with the outer value which is taken from the grid", test, test1);

				
				if(cell_count_expected == total_Rows) {
					
					System.out.println("Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows);
					Extent_pass_New(driver, "Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows, test, test1);
				}else {
					
					System.out.println("Not Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows);
					Extent_fail(driver, "Not Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows, test, test1);
				
					
				}
				
				if(status.contains("disabled")) {
					waitForElement(driver, Stock_Service_Grid_Close_Button);
					click(driver, Stock_Service_Grid_Close_Button);
				}
					
				Step_End(9, "And now the records in the service count should be match with the outer value which is taken from the grid", test, test1);

				
				}
			
			}else {
				
				
				Step_Start(1, "click on location hierarchy dropdown", test, test1);
				waitForElement(driver, location_hierarchy_dd_SR);
				click(driver, location_hierarchy_dd_SR);
				

				String location_hie_dd = String.format(location_hierarchy_dd_Options_SR, location_hierarchy_value);
				
				waitForElement(driver, location_hie_dd);
				click(driver, location_hie_dd);
				
				Step_End(1, "click on location hierarchy dropdown", test, test1);


		Step_Start(2, "click the service search icon", test, test1);

				waitForElement(driver, location_hierarchy_search_icon);
				click(driver, location_hierarchy_search_icon);
				twoColumnSearchWindow(driver, different_headers, condition, location_hierarchy_textfield_value);
				Step_End(2, "click the service search icon", test, test1);

				Step_Start(3, "choose an option from mty/full indicator dropdown", test, test1);
			
				//mty/indicator
				waitForElement(driver, mty_full_indicator_SR);
				click(driver, mty_full_indicator_SR);
				String mty_full_option = String.format(mty_full_indicator_options_SR, mty_full_indicator_value);
				waitForElement(driver, mty_full_option);
				click(driver, mty_full_option);
			
				Step_End(3, "choose an option from mty/full indicator dropdown", test, test1);


		Step_Start(4, "click on size/type options", test, test1);

				//4size/type options
				
				String size_type_four_options = String.format(size_type_options_SR, size_type_option_value);
				waitForElement(driver, size_type_four_options);
				click(driver, size_type_four_options);
				Step_End(4, "click on size/type options", test, test1);

				Step_Start(5, "click on show button", test, test1);

				waitForElement(driver, show_btn_SR);
				click(driver, show_btn_SR);
				
				Step_End(5, "click on show button", test, test1);

				Step_Start(6, "Now get the value[service data and header] which is received from the test data", test, test1);

				waitForElement(driver, SR_module_table);
				
				List<Map<String, String>> SR_module_tabledata = extractCompleteTableData1(driver, SR_module_table);
				
				List<String> equipment_types_row = splitAndExpand(equipment_types_rows);
				List<String> service_value_Head = splitAndExpand(service_value_Header);

				for(String equipment_type:equipment_types_row) {
					
					for(String service_values:service_value_Head) {
				
				String grid_value_to_check = getValueByFirstColumnAndHeader(SR_module_tabledata, size_type_header, equipment_type, service_values);
				
				System.out.println("grid_value_to_check "+grid_value_to_check);
				
				List<String> FilterHeadersName=splitAndExpand(columns_to_select);

				waitForElement(driver, Column_SelectMenu);
				click(driver, Column_SelectMenu);
				waitForElement(driver, Column_Search_Input);
				jsClick(driver, SelectAll_Column_CheckBox);
				
				for(String FilterHeader : FilterHeadersName) {
					waitForElement(driver, Column_Search_Input);
					clear(driver, Column_Search_Input);
					sendKeys(driver, Column_Search_Input,FilterHeader);
				
					String checkbox=String.format(Select_Column_tableHead,FilterHeader);
					waitForElement(driver, checkbox);
					jsClick(driver, checkbox);
				}
				waitForElement(driver, Column_SelectMenu);
				click(driver, Column_SelectMenu);
			
				
				String firstHeader = String.format(service_column_header, service_values);
				waitForElement(driver, firstHeader);
				mouseOverToElement(driver, firstHeader);
				String firstColumnColId = getAttribute(driver, firstHeader, "col-id");

					String target_cell_click = String.format(Targeting_cell_Size_Type_value_SR, equipment_type,firstColumnColId,grid_value_to_check);
				String cell_count = getText(driver, target_cell_click);
				int cell_count_expected = Integer.parseInt(cell_count);
				

		Step_Start(7, "Get the count from the grid and double click on it", test, test1);
				if(cell_count_expected != 0) {
					click(driver,target_cell_click);
				
					Step_End(7, "Get the count from the grid and double click on it", test, test1);

				waitForElement(driver, stock_report_panel);
				
				scrollUsingElement(driver, bottom_panel);
				int total_Rows = 0;
				
		String status = getAttribute(driver, Last_Page_Button_Stock_Service_Grid,"class");
				
				if(!status.contains("disabled")) {
					waitForElement(driver, Last_Page_Button_Stock_Service_Grid);
					click(driver, Last_Page_Button_Stock_Service_Grid);
				}
				
				waitForElement(driver, Serial_Number_Gridcell_Service_Stock_Grid);
				String lastRow=getText(driver, Serial_Number_Gridcell_Service_Stock_Grid);
				total_Rows=Integer.parseInt(lastRow);
				
				waitForElement(driver, Last_Page_Button_Stock_Service_Grid);
				status = getAttribute(driver, Last_Page_Button_Stock_Service_Grid,"class");
				
				
				
				Step_Start(8, "And now the records in the service should be match with the outer value which is taken from the grid", test, test1);

				
				if(cell_count_expected == total_Rows) {
					
					System.out.println("Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows);
					Extent_pass_New(driver, "Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows, test, test1);
				}else {
					
					System.out.println("Not Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows);
					Extent_fail(driver, "Not Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows, test, test1);
				
					
				}
				Step_End(8, "And now the records in the service should be match with the outer value which is taken from the grid", test, test1);

				if(status.contains("disabled")) {
					waitForElement(driver, Stock_Service_Grid_Close_Button);
					click(driver, Stock_Service_Grid_Close_Button);
				}
					
				}else {
					System.out.println("The cell count is :"+cell_count_expected+" || FOR "+equipment_type+"|| AND THE SERVICE IS :"+service_values);
					
					Extent_fail(driver, "The cell count is :"+cell_count_expected+" || FOR "+equipment_type+"|| AND THE SERVICE IS :"+service_values, test, test1);
				}
				
				}
			
				
				
				}	
				Step_End(6, "Now get the value[service data and header] which is received from the test data", test, test1);

			}
			
			
					Extent_completed(tc_Name, test, test1);	

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		}

		int TC4=1;

		if(TC4==1) {

			
			String tc_Name="TC_Stock_Report_by_Size_Type_TS039";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
			String Search_input = Excel_data.get("Search_input");	
			String viewbyport = Excel_data.get("viewbyport");
			String Size_Type_Button = Excel_data.get("Size_Type_Button");
			String conditionFilter = Excel_data.get("conditionFilter");
			String carrier_Code = Excel_data.get("carrier_Code");
			String Location_Heirachy_input = Excel_data.get("Location_Heirachy_input");
			String location_Search_Input_Select = Excel_data.get("location_Search_Input_Select");
			String service_Checkbox = Excel_data.get("service_Checkbox");
			String service_code_Input = Excel_data.get("service_code_Input");
			String size_type_header = Excel_data.get("size_type_header");
			String service_value = Excel_data.get("service_value");
			String location = Excel_data.get("location");
			String equipment_type = Excel_data.get("equipment_type");
			String carrier_code_header = Excel_data.get("carrier_code_header");
			String different_headers = Excel_data.get("different_headers");
			String service_code_header = Excel_data.get("service_code_header");
			String Selected_Columns = Excel_data.get("Selected_Columns");

			String location_hierarchy_type =String.format(On_Off_Hire_Locators.location_hierarchy_type39, Location_Heirachy_input);
			String siez_type_btn =String.format(On_Off_Hire_Locators.size_Type_Select, Size_Type_Button);
			
			
			Extent_Start(tc_Name, test, test1);
			
			Step_Start(1, "open Module", test, test1);
			moduleNavigate(driver, Search_input);
			Step_End(1, "open Module", test, test1);
			
			if(carrier_Code.equals("")) {
			waitForElement(driver, carrier_Search_Button);
			click(driver, carrier_Search_Button);
			twoColumnSearchWindow(driver, carrier_code_header, conditionFilter, service_value);
			}
			Step_Start(2, "Select Location heirachy", test, test1);
			waitForElement(driver, location_Dropdwn_Label);
			click(driver, location_Dropdwn_Label);
			
			waitForElement(driver, location_hierarchy_type);
			click(driver, location_hierarchy_type);
			
			waitForElement(driver, Location_Heirachy_Search_Btn);
			click(driver, Location_Heirachy_Search_Btn);
			twoColumnSearchWindow(driver, different_headers, conditionFilter, location_Search_Input_Select);
			
			Step_End(2, "Select Location heirachy", test, test1);
			
			checkBox(driver, service_Checkbox_Click, service_Checkbox);
			if(!service_code_Input.equals("")) {
			waitForElement(driver, service_search_Button);
			click(driver, service_search_Button);
			twoColumnSearchWindow(driver, service_code_header, conditionFilter, service_code_Input);
			
			}
			
			waitForElement(driver, view_by_Port_CheckBox);
			checkBox(driver, view_by_Port_CheckBox, viewbyport);
			
			Step_Start(3, "select Size type", test, test1);
			waitForElement(driver, siez_type_btn);
			click(driver, siez_type_btn);
			Step_End(3, "select Size type", test, test1);
			
			
			Step_Start(4, "click show button", test, test1);
			waitForElement(driver, Size_Type_show_Button);
			click(driver, Size_Type_show_Button);
			Step_End(4, "click show button", test, test1);
			
			waitForElement(driver, toolPannel);
			click(driver, toolPannel);
			waitForElement(driver, Condition_Filter_EMS);
			click(driver, Condition_Filter_EMS);
			
			waitForElement(driver, location_TF);
			sendKeys(driver, location_TF, location);
			
			waitForElement(driver, Equipment_type_TF);
			sendKeys(driver, Equipment_type_TF, equipment_type);
			
			reArrangeAG_GridColumnsWithoutCheckbox(driver, Selected_Columns);

			
			Step_Start(5, "compare the stock report ", test, test1);
			
	       waitForElement(driver, stock_Report_Size_Type_Table);
			
			List<Map<String, String>> tabledata = extractTableDataByColumn(driver, stock_Report_Size_Type_Table);
			
			String grid_value_to_check = getValueByFirstColumnAndHeader(tabledata, size_type_header, equipment_type, service_value);
			
			System.out.println("grid_value_to_check "+grid_value_to_check);
			String firstHeader = String.format(ST_service_column_header, service_value);
			waitForElement(driver, firstHeader);
			mouseOverToElement(driver, firstHeader);
			String firstColumnColId = getAttribute(driver, firstHeader, "col-id");
				String target_cell_click = String.format(targeting_cell_stock_type_value_check, equipment_type,firstColumnColId,grid_value_to_check);
			String cell_count = getText(driver, target_cell_click);
			int cell_count_expected = Integer.parseInt(cell_count);
			
			waitForElement(driver, target_cell_click);
			doubleClick(driver,target_cell_click);
			
			
			int total_Rows = 0;
			boolean flag = true;
			waitForElement(driver, Next_Button);
			while(flag) {
				waitForElement(driver, Size_Type_Table_Rows);
				List<WebElement> rows = listOfElements(driver, Size_Type_Table_Rows);
				total_Rows=total_Rows+rows.size();
				String status = getAttribute(driver, Next_Button,"class");
				if(status.contains("disabled")) {
					waitForElement(driver, pannel_Close_Click);
					click(driver, pannel_Close_Click);
					flag=false;
				}
				if(!status.contains("disabled")) {
					waitForElement(driver, Next_Button);
					click(driver, Next_Button);
				}
			}
			if(cell_count_expected == total_Rows) {
				
				System.out.println("Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows);
				Extent_pass_New(driver, "Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows, test, test1);
			}else {
				
				System.out.println("Not Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows);
				Extent_fail(driver, "Not Matched || Expected number of rows : "+cell_count_expected+"||actual number of rows : "+total_Rows, test, test1);
			
				
			}
			waitForDisplay(driver, pannel_Close_Click);
			if(isdisplayed(driver, pannel_Close_Click)) {
			click(driver, pannel_Close_Click);
			}
				
				Step_End(5, "compare the stock report ", test, test1);

			
			Extent_completed(tc_Name, test, test1);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		}

		int TC5=1;

		if(TC5==1) {
			String tc_Name="TC_Stock_Report_by_Size_Type_Detail_Report_TS_040";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);


			String Search_input = Excel_data.get("Search_input");	
			String Location_hierachy40 = Excel_data.get("Location_hierachy40");	
			String Country_Code_value40 = Excel_data.get("Country_Code_value40");	
			String Sizeandtype_value40 = Excel_data.get("Sizeandtype_value40");
			String folder1 = Excel_data.get("folder1");
			String folder2 = Excel_data.get("folder2");
			String lessor_data = Excel_data.get("lessor_data");
			String lessee_data = Excel_data.get("lessee_data");
			String leasekind_data = Excel_data.get("leasekind_data");
			String supcon_data = Excel_data.get("supcon_data");
			String cuscon_data = Excel_data.get("cuscon_data");
			String sz_tp_buttons = Excel_data.get("sz_tp_buttons");
			String sum_det_buttons = Excel_data.get("sum_det_buttons");
			String condition = Excel_data.get("condition");	
			String different_headers = Excel_data.get("different_headers");
			String lessor_code_header = Excel_data.get("lessor_code_header");
			String lesee_code_header = Excel_data.get("lesee_code_header");
			String lease_code_header = Excel_data.get("lease_code_header");
			String sup_con_header = Excel_data.get("sup_con_header");
			String cus_con_header = Excel_data.get("cus_con_header");
			String Selected_Columns = Excel_data.get("Selected_Columns");
			String Stock_Count_Select = Excel_data.get("Stock_Count_Select");

			
			String location_hierarchy_type6 =String.format(On_Off_Hire_Locators.location_hierarchy_type6, Location_hierachy40);
			String folder11 =String.format(On_Off_Hire_Locators.folder11, folder1);
			String folder_drop = String.format(On_Off_Hire_Locators.folder_drop, folder2);


			Extent_Start(tc_Name, test, test1);

			
			Extent_call(test, test1, "Enter module name in searchbox & click the module");

			moduleNavigate(driver, Search_input);

			Step_Start(1, "Click locational hierarchy drop menu", test, test1); 
			Step_Start(2, "Click search icon & select country accordingly", test, test1);
			waitForElement(driver, locations_inputfield);
			click(driver,locations_inputfield);


			waitForElement(driver, location_hierarchy_type6);
			click(driver, location_hierarchy_type6);

			waitForElement(driver, locationDropdownoption6);
			String locationDropdown_option6 = getText(driver, locationDropdownoption6);
			System.out.println(locationDropdown_option6);
			if(locationDropdown_option6.equals(Location_hierachy40)) {
				System.out.println("MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy40+"|| ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option6);
				Extent_pass_New(driver, "MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy40+"|| ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option6, test,test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy40+"|| ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option6);
				Extent_fail(driver, "NOT MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy40+"|| ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option6, test,test1);
			}  

			waitForElement(driver, countrysearchicon);
			click(driver,countrysearchicon);
			twoColumnSearchWindow(driver, different_headers, condition, Country_Code_value40);
			
			Step_End(1, "Click locational hierarchy drop menu", test, test1);
			Step_End(2, "Click search icon & select country accordingly", test, test1);

			Step_Start(3, "Click Size/type Ungroup tab then select option accrodingly", test, test1);
			waitForElement(driver, sizetype_dropdown);
			click(driver,sizetype_dropdown);

			formatLocatorClick(driver, sizetype_type, Sizeandtype_value40);
		


			waitForElement(driver, SizeandtypeDropdownoption);
			String SizeandtypeDropdown_option = getText(driver, SizeandtypeDropdownoption);
			System.out.println(SizeandtypeDropdown_option);
			if(SizeandtypeDropdown_option.equals(Sizeandtype_value40)) {
				System.out.println("MATCHED || EXPECTED SIZE_AND_TYPE DROPDOWN LABEL VALUE: "+ Sizeandtype_value40 +" ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+ SizeandtypeDropdown_option);
				Extent_pass_New(driver, "MATCHED || EXPECTED SIZE_AND_TYPE DROPDOWN LABEL VALUE: "+ Sizeandtype_value40 +" ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+ SizeandtypeDropdown_option, test,test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED SIZE_AND_TYPE DROPDOWN LABEL VALUE: "+ Sizeandtype_value40 +" ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+ SizeandtypeDropdown_option);
				Extent_fail(driver, "NOT MATCHED || EXPECTED SIZE_AND_TYPE DROPDOWN LABEL VALUE: "+ Sizeandtype_value40 +" ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+ SizeandtypeDropdown_option, test,test1);
			}  

			Step_End(3, "Click Size/type Ungroup tab then select option accrodingly", test, test1);

			Step_Start(4, "Select in-transit checkbox accordingly", test, test1);

			if(!lessor_data.equals("")) {

				List<String> datas = splitAndExpand(lessor_data);
				for(String data :datas) {
					waitForElement(driver, lessor_add_icon);
					click(driver, lessor_add_icon);
					twoColumnSearchWindow(driver, lessor_code_header, condition, data);

				}

			}else {
				System.out.println("lessor_data "+"Input Not Available in test data");
			}

			if(!lessee_data.equals("")) {

				List<String> datas = splitAndExpand(lessee_data);
				for(String data :datas) {
					waitForElement(driver, lessee_Add_icon);
					click(driver, lessee_Add_icon);
					twoColumnSearchWindow(driver, lesee_code_header, condition, data);

					
				}

			}else {
				System.out.println("lessee_data "+"Input Not Available in test data");
			}

			if(!leasekind_data.equals("")) {

				List<String> datas = splitAndExpand(leasekind_data);
				for(String data :datas) {
					waitForElement(driver, leasekind_Add_icon);
					click(driver, leasekind_Add_icon);
					twoColumnSearchWindow(driver, lease_code_header, condition, data);

				}

			}else {
				System.out.println("leasekind_data "+"Input Not Available in test data");
			}

			if(!supcon_data.equals("")) {

				List<String> datas = splitAndExpand(supcon_data);
				for(String data :datas) {
					waitForElement(driver, supcon_add_icon);
					click(driver, supcon_add_icon);
					twoColumnSearchWindow(driver, sup_con_header, condition, data);

				}

			}else {
				System.out.println("supcon_data "+"Input Not Available in test data");
			}

			if(!cuscon_data.equals("")) {

				List<String> datas = splitAndExpand(cuscon_data);
				for(String data :datas) {
					waitForElement(driver, cuscon_add_icon);
					click(driver, cuscon_add_icon);
					twoColumnSearchWindow(driver, cus_con_header, condition, data);

				}

			}else {
				System.out.println("cuscon_data "+"Input Not Available in test data");
			}


			if(!sz_tp_buttons.equals("")) {

				String sz_tp_btn =String.format(On_Off_Hire_Locators.sz_tp_btn, sz_tp_buttons);
				waitForElement(driver, sz_tp_btn);
				click(driver, sz_tp_btn);

			}else {
				System.out.println("sz_tp_buttons "+"Input Not Available in test data");
			}

			if(!sum_det_buttons.equals("")) {

				String sum_det_btn =String.format(On_Off_Hire_Locators.sum_det_btn, sum_det_buttons);
				waitForElement(driver, sum_det_btn);
				click(driver, sum_det_btn);

			}else {
				System.out.println("sum_det_buttons "+"Input Not Available in test data");
			}


			Step_End(4, "Select in-transit checkbox accordingly", test, test1);

			Step_Start(5, "Click show button & it will show data in grid accordingly", test, test1); 

			waitForElement(driver, click_showbtn40);
			click(driver,click_showbtn40);

			String total_Records_In_The_Table = getText(driver, total_Records);

			int total_Records_Count = Integer.parseInt(total_Records_In_The_Table);

			System.out.println("total records count :"+total_Records_Count);

			for(int i3=2;i3<=total_Records_Count;i3++) {
				String grid_Check40=String.format(On_Off_Hire_Locators.grid_Check40, i3);
				if(grid_Check40!=null) {

					System.out.println("Location list "+i3+" is displayed in the grid");
					Extent_pass_New(driver, "Location list "+i3+" is displayed in the grid", test,test1);

				}else {
					System.out.println("Location list "+i3+" is not displayed in the grid");
					Extent_fail(driver, "Location list "+i3+" is not displayed in the grid", test,test1);
				}

			}
			Step_End(5, "Click show button & it will show data in grid accordingly", test, test1);

			Step_Start(6, "Click node for folder wise to get equipment list count after clicking exact terminal then double click", test, test1);

			scrollElementToView(driver, folder11);
			waitForElement(driver, folder11);
			click(driver,folder11);	

			scrollElementToView(driver, folder_drop);
			waitForElement(driver, folder_drop);
			click(driver,folder_drop);	
			Step_End(6, "Click node for folder wise to get equipment list count after clicking exact terminal then double click", test, test1);
			reArrangeAG_GridColumnsWithoutCheckbox(driver, Selected_Columns);
			
			Step_Start(7, "system will pop-up for container details once clicked", test, test1);
			String term_grid = getText(driver, term_detail);	
			System.out.println("termgrid "+term_grid);
			
			

			String term_Grid_Check=String.format(On_Off_Hire_Locators.term_Grid_Check, term_grid);
			waitForElement(driver, term_Grid_Check);
			
			if(term_Grid_Check != null) {
				System.out.println("Activity "+term_grid+" is present in the Stock Report By Size/Type Detail Report");
				Extent_pass_New(driver, "Activity "+term_grid+" is present in the Stock Report By Size/Type Detail Report",test,test1);
			}else {
				System.out.println("Activity "+term_grid+" is not present in the Stock Report By Size/Type Detail Report");
				Extent_fail(driver, "Activity "+term_grid+" is present in the Stock Report By Size/Type Detail Report",test,test1);
			}
			waitForElement(driver, container_Check_Click);
			
			String equipment_count = getText(driver, container_Check_Click);
			
			int total_equip_count = Integer.parseInt(equipment_count);
			int totalRowCount=0;
			
			click(driver, container_Check_Click);

			waitForDisplay(driver, ems_stock_count_select);
			if(isdisplayed(driver, ems_stock_count_select)) {
			selectByText(driver, ems_stock_count_select, Stock_Count_Select);
			
			waitForElement(driver, ems_total_pages);
			String total_page_turn = getText(driver, ems_total_pages);
			
			 String secondNumberString = total_page_turn.replaceAll(".*of (\\d+).*", "$1");
			 
			 int secondNumber = Integer.parseInt(secondNumberString);
			System.out.println("second number value is: "+secondNumber);
			
			 for (int pageNum = 1; pageNum <= secondNumber; pageNum++) {
	             // If it's not the first page, click on the "Next" button
	             if (pageNum > 1) {
	            	 click(driver, ems_next_page);// Adjust the locator for the 'Next' button
	            	 waitForElement(driver, ems_page_heading);
	             }

	             // Step 5: Get the row count for the current page
	     		List<WebElement> total_count_pagewise = listOfElements(driver, ems_equip_details_count);
	             int rowsOnCurrentPageCount = total_count_pagewise.size();
	             System.out.println("Rows on page " + pageNum + ": " + rowsOnCurrentPageCount);
	             
	             // Add the current page row count to the total row count
	             totalRowCount += rowsOnCurrentPageCount;
	         }
			}else {
			waitForElement(driver, EMS_Size_Type_Stock_Report_Total_Records);
			String totalRecords=getText(driver, EMS_Size_Type_Stock_Report_Total_Records).trim();
			totalRowCount = Integer.parseInt(totalRecords);
			}
			waitForElement(driver, Size_Type_Grid_Close_Button);
			click(driver, Size_Type_Grid_Close_Button);
			
			
	         // Step 6: Compare the calculated total row count with the expected total count
	         if (totalRowCount == total_equip_count) {

	        	 System.out.println("Matched || Expected equipment details count "+total_equip_count+"|| actual equipment details count "+totalRowCount);
	             Extent_pass_New(driver, "Matched || Expected equipment details count "+total_equip_count+"|| actual equipment details count "+totalRowCount, test, test1);
	         
	         } else {

	        	 System.out.println("Not Matched || Expected equipment details count "+total_equip_count+"|| actual equipment details count "+totalRowCount);
	             Extent_fail(driver, "Not Matched || Expected equipment details count "+total_equip_count+"|| actual equipment details count "+totalRowCount, test, test1);
	         
	         }

	 		Step_End(7, "system will pop-up for container details once clicked", test, test1);
			Extent_completed(tc_Name, test, test1);
				
			scrollTop(driver);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
				
		}

		int TC6=1;

		if(TC6==1) {
			String tc_Name="TC_Stock_Report_by_Size_Type_Detail_Report_TS_041";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);
			
			String Search_input = Excel_data.get("Search_input");	
			String Location_hierachy41 = Excel_data.get("Location_hierachy41");	
			String Country_Code_value41 = Excel_data.get("Country_Code_value41");	
			String Sizeandtype_value41 = Excel_data.get("Sizeandtype_value41");
			String lessor_data = Excel_data.get("lessor_data");
			String lessee_data = Excel_data.get("lessee_data");
			String leasekind_data = Excel_data.get("leasekind_data");
			String supcon_data = Excel_data.get("supcon_data");
			String cuscon_data = Excel_data.get("cuscon_data");
			String sz_tp_buttons = Excel_data.get("sz_tp_buttons");
			String First_Column_Header =Excel_data.get("First_Column_Header");
			String First_Column_Values =Excel_data.get("First_Column_Values");
			String Stock_Column_Value_Headers =Excel_data.get("Stock_Column_Value_Headers");
			String Value_present_in_excel =Excel_data.get("Value_present_in_excel");
			String different_headers = Excel_data.get("different_headers");
			String condition = Excel_data.get("condition");
			String lessor_code_header = Excel_data.get("lessor_code_header");
			String lease_kind_header = Excel_data.get("lease_kind_header");
			String sup_con_header = Excel_data.get("sup_con_header");
			String cus_con_header = Excel_data.get("cus_con_header");
			String lease_code_header = Excel_data.get("lease_code_header");
			String Column_Values = Excel_data.get("Column_Values");

			
			String sz_tp_btn =String.format(On_Off_Hire_Locators.sz_tp_btn, sz_tp_buttons);


			String sizetype_type1 =String.format(On_Off_Hire_Locators.sizetype_type1, Sizeandtype_value41);
			String location_hierarchy_type7 = String.format(On_Off_Hire_Locators.location_hierarchy_type7,Location_hierachy41);
			
			
			Extent_Start(tc_Name, test, test1);
			
			
			
		    
			 Extent_call(test, test1, "Enter module name in searchbox & click the module");
				moduleNavigate(driver, Search_input);
			    
			    Step_Start(1, "Click locational hierarchy drop menu", test, test1);
			    Step_Start(2, "Click search icon & select country accordingly", test, test1);
			    waitForElement(driver, locations_inputfield);
				click(driver,locations_inputfield);
				
				
				waitForElement(driver, location_hierarchy_type7);
				click(driver, location_hierarchy_type7);
				
				
				waitForElement(driver, locationDropdownoption7);
				String locationDropdown_option7 = getText(driver, locationDropdownoption7);
				System.out.println(locationDropdown_option7);
				if(locationDropdown_option7.equals(Location_hierachy41)) {
					System.out.println("MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy41+"ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option7);
					Extent_pass_New(driver, "MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy41+"ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option7, test, test1);
				}else {
					System.out.println("NOT MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy41+"ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option7);
					Extent_fail(driver, "NOT MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy41+"ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option7, test, test1);
				}  
				
				waitForElement(driver, countrysearchicon);
				click(driver,countrysearchicon);
				twoColumnSearchWindow(driver, different_headers, condition, Country_Code_value41);
				 Step_End(1, "Click locational hierarchy drop menu", test, test1);
				 Step_End(2, "Click search icon & select country accordingly", test, test1);
				 
				 Step_Start(3, "Click Size/type from drop menu then select option accrodingly", test, test1);
				waitForElement(driver, sizetype_dropdown);
				click(driver,sizetype_dropdown);
				
				
				waitForElement(driver, sizetype_type1);
				click(driver, sizetype_type1);
				
				
				waitForElement(driver, SizeandtypeDropdownoption1);
				String SizeandtypeDropdown_option1 = getText(driver, SizeandtypeDropdownoption1);
				System.out.println(SizeandtypeDropdown_option1);
				if(SizeandtypeDropdown_option1.equals(Sizeandtype_value41)) {
					System.out.println("MATCHED || EXPECTED Sizeandtype DROPDOWN LABEL VALUE: "+Sizeandtype_value41+"ACTUAL Sizeandtype DROPDOWN LABEL VALUE IS: "+SizeandtypeDropdown_option1);
					Extent_pass_New(driver, "MATCHED || EXPECTED Sizeandtype DROPDOWN LABEL VALUE: "+Sizeandtype_value41+"ACTUAL Sizeandtype DROPDOWN LABEL VALUE IS: "+SizeandtypeDropdown_option1, test, test1);
				}else {
					System.out.println("NOT MATCHED || EXPECTED Sizeandtype DROPDOWN LABEL VALUE: "+Sizeandtype_value41+"ACTUAL Sizeandtype DROPDOWN LABEL VALUE IS: "+SizeandtypeDropdown_option1);
					Extent_fail(driver, "NOT MATCHED || EXPECTED Sizeandtype DROPDOWN LABEL VALUE: "+Sizeandtype_value41+"ACTUAL Sizeandtype DROPDOWN LABEL VALUE IS: "+SizeandtypeDropdown_option1, test, test1);
				
				}
				Step_End(3, "Click Size/type from drop menu then select option accrodingly", test, test1);
				
				
				Step_Start(4, " Select in-transit checkbox accordingly", test, test1);
				if(!lessor_data.equals("")) {
					
						List<String> datas = splitAndExpand(lessor_data);
						for(String data :datas) {
							waitForElement(driver, lessor_add_icon);
							click(driver, lessor_add_icon);
							
							twoColumnSearchWindow(driver, lessor_code_header, condition, data);
							
						}
					
					}else {
						System.out.println("lessor_data "+"Input Not Available in test data");
					}
				 
				 if(!lessee_data.equals("")) {
						
							List<String> datas = splitAndExpand(lessee_data);
							for(String data :datas) {
								waitForElement(driver, lessee_Add_Icon);
								click(driver, lessee_Add_Icon);
								
								twoColumnSearchWindow(driver, lease_code_header, condition, data);
							
							}
						
						
						}else {
							System.out.println("lessee_data "+"Input Not Available in test data");
						}
				 
				 if(!leasekind_data.equals("")) {
						
							List<String> datas = splitAndExpand(leasekind_data);
							for(String data :datas) {
								waitForElement(driver, leasekind_Add_icon);
								click(driver, leasekind_Add_icon);
								
								twoColumnSearchWindow(driver, lease_kind_header, condition, data);
								
							}
						
						}else {
							System.out.println("leasekind_data "+"Input Not Available in test data");
						}
				
				 if(!supcon_data.equals("")) {
							List<String> datas = splitAndExpand(supcon_data);
							for(String data :datas) {
								waitForElement(driver, supcon_add_icon);
								click(driver, supcon_add_icon);
								
								twoColumnSearchWindow(driver, sup_con_header, condition, data);
							}
						
						}else {
							System.out.println("supcon_data "+"Input Not Available in test data");
						}
				 
				 if(!cuscon_data.equals("")) {
					
							List<String> datas = splitAndExpand(cuscon_data);
							for(String data :datas) {
								waitForElement(driver, cuscon_add_icon);
								click(driver, cuscon_add_icon);
								twoColumnSearchWindow(driver, cus_con_header, condition, data);
					
							}
						
						}else {
							System.out.println("cuscon_data "+"Input Not Available in test data");
						}
				
				
				 if(!sz_tp_buttons.equals("")) {
				    	
				    		
				    		waitForElement(driver, sz_tp_btn);
				    		click(driver, sz_tp_btn);
						
						}else {
							System.out.println("sz_tp_buttons "+"Input Not Available in test data");
						}
				
				
				 
				 Step_End(4, " Select in-transit checkbox accordingly", test, test1);
				 
				 
				 
				 Step_Start(5, "Click show button & it will show data in grid accordingly", test, test1);
				 
					waitForElement(driver, summary);
					click(driver,summary);
				 
					waitForElement(driver, click_showbtn40);
					click(driver,click_showbtn40);
					 Step_End(5, "Click show button & it will show data in grid accordingly", test, test1);
					
					
					 reArrangeAG_GridColumnsWithoutCheckbox(driver, Column_Values);
					 Step_Start(6, "capture the count in the application", test, test1);
					
					int count=0;
					
							List<String> stockColumnValueHeaders = splitAndExpand(Stock_Column_Value_Headers,",");
					List<String> firstColumnValues = splitAndExpand(First_Column_Values,",");
					waitForElement(driver, Stock_Report_Table1);
					List<Map<String, String>> table_Data = extractTableDataByColumn(driver, Stock_Report_Table1);
					for(int i =0;i<stockColumnValueHeaders.size();i++) {
						for(int j =0;j<firstColumnValues.size();j++) {
							String actual_Count = getValueByFirstColumnAndHeader(table_Data,First_Column_Header,firstColumnValues.get(j),stockColumnValueHeaders.get(i));
							 count = Integer.parseInt(actual_Count);
							System.out.println(actual_Count);
							
							
							if(!First_Column_Values.equalsIgnoreCase("Total")) {
							String firstHeader = String.format(Stock_Column_Header1, First_Column_Header);
							waitForElement(driver, firstHeader);
							String firstColumnColId = getAttribute(driver, firstHeader, "col-id");

							String stockHeader = String.format(Stock_Column_Header1, stockColumnValueHeaders.get(i));
							waitForElement(driver, stockHeader);
							mouseOverToElement(driver, stockHeader);
							String stockColumnColId = getAttribute(driver, stockHeader, "col-id");

							String select_Stock_Table_Value = String.format(select_Stock_Table, firstColumnColId,firstColumnValues.get(j),stockColumnColId,actual_Count);
							waitForElement(driver, select_Stock_Table_Value);
							doubleClick(driver,select_Stock_Table_Value);
							
							int total_Rows = 0;
							
							waitForDisplay(driver, Strock_Summary_Next_Page_Button);
							if(isdisplayed(driver, Strock_Summary_Next_Page_Button)) {
							boolean flag = true;
							while(flag) {
								List<WebElement> rows = listOfElements(driver, Strock_Summary_Table_Rows1);
								total_Rows=total_Rows+rows.size();
								String status = getAttribute(driver, Strock_Summary_Next_Page_Button,"class");
								if(status.contains("disabled")) {
									waitForElement(driver, panel_Close1);
									click(driver, panel_Close1);
									flag=false;
								}
								if(!status.contains("disabled")) {
									waitForElement(driver, Strock_Summary_Next_Page_Button);
									click(driver, Strock_Summary_Next_Page_Button);
								}
							}
							}else {
							
							waitForElement(driver, EMS_Size_Type_Stock_Report_Total_Records);
							String totalRecords=getText(driver, EMS_Size_Type_Stock_Report_Total_Records).trim();
							total_Rows = Integer.parseInt(totalRecords);
							
							waitForElement(driver, Size_Type_Grid_Close_Button);
							click(driver, Size_Type_Grid_Close_Button);
							}
							if(count==total_Rows) {
								System.out.println("Matched || The Expected "+firstColumnValues.get(j)+" Rows "+stockColumnValueHeaders.get(i)+" Column Value is : "+count+" || The Actual Stock By Report Panel Rows Count is "+total_Rows);
								Extent_pass_New(driver,"Matched || The Expected "+firstColumnValues.get(j)+" Rows "+stockColumnValueHeaders.get(i)+" Column Value is : "+count+" || The Actual Stock By Report Panel Rows Count is "+total_Rows, test, test1);
							}else {
								System.out.println("Not Matched || The Expected "+firstColumnValues.get(j)+" Rows "+stockColumnValueHeaders.get(i)+" Column Value is : "+count+" || The Actual Stock By Report Panel Rows Count is "+total_Rows);
								Extent_fail(driver,"Not Matched || The Expected "+firstColumnValues.get(j)+" Rows "+stockColumnValueHeaders.get(i)+" Column Value is : "+count+" || The Actual Stock By Report Panel Rows Count is "+total_Rows, test, test1);
							}
							
						}
					}
					}
					
					 Step_End(6, "capture the count in the application", test, test1);
					
					if(!First_Column_Header.equalsIgnoreCase("Term./Depot")){
					waitForElement(driver, detail);
					click(driver,detail);
				 
					waitForElement(driver, click_showbtn);
					click(driver,click_showbtn);
					Step_Start(7, "click download icon button & click the id once processed", test, test1);
				waitForElement(driver, report_downloadbtn);
				click(driver, report_downloadbtn);
				Step_End(7, "click download icon button & click the id once processed", test, test1);
				
				Step_Start(8, "Export sheet will be downloaded once clicked the processed id", test, test1);
				waitForDownload(driver, process);
				String processed_number1 = getText(driver, process_num);
				click(driver, process_num);
				
				String Application_count = Downloadedfile(driver,processed_number1);
				System.out.println(Application_count);
				Step_End(8, "Export sheet will be downloaded once clicked the processed id", test, test1);
				
				scrollTop(driver);
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
				
				Step_Start(9, "Compare the values count present in application and excel", test, test1);
				
				String filePath = Application_count;
		        String targetValue = Value_present_in_excel; // value to search for
		        int count1= 0; // to store the count of targetValue occurrences

		        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		            String line;
		            while ((line = br.readLine()) != null) {
		                // Split the line by commas (or any delimiter used in the CSV file)
		                String[] values = line.split(",");
		                
		                // Check if any of the values in this line match the target value
		                for (String value : values) {
		                    if (value.equals(targetValue)) {
		                        count1++; // Increment count if the value matches
		                    }
		                }
		            }
		            
		            System.out.println("Total count of '" + targetValue + "': " +count1);
		            
		        } catch (IOException e) {
		            e.printStackTrace();
					Extent_fail(driver, "total value is not present  "+ e.getLocalizedMessage(), test,test1);

		        }
				
				
				
		        if(count==count1) {
					System.out.println("MATCHED || EXPECTED COUNT PRESENT IN APPLICATION GRID: "+count+"ACTUAL COUNT PRESENT IN EXCEL GRID: "+count1);
					Extent_pass_New(driver, "MATCHED || EXPECTED COUNT PRESENT IN APPLICATION GRID: "+count+"ACTUAL COUNT PRESENT IN EXCEL GRID: "+count1, test, test1);
				}else {
					System.out.println("NOT MATCHED || EXPECTED COUNT PRESENT IN APPLICATION GRID: "+count+"ACTUAL COUNT PRESENT IN EXCEL GRID: "+count1);
					Extent_fail(driver, "NOT MATCHED || EXPECTED COUNT PRESENT IN APPLICATION GRID: "+count+"ACTUAL COUNT PRESENT IN EXCEL GRID: "+count1, test, test1);
				
				}
				
					}
					Step_End(9, "Compare the values count present in application and excel", test, test1);
			
				
				
				Extent_completed(tc_Name, test, test1);
				
			scrollTop(driver);	
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

		}

		int TC7=1;

		if(TC7==1) {
			String tc_Name="TC_Stock_Report_by_Stock_Status_TS042";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(tc_Name);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(tc_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, tc_Name, "Dataset" + selected_dataset,File_Path);


			String Search_input =Excel_data.get("Search_input");	
			String Location_hierachy =Excel_data.get("Location_hierachy");	
			String Sizeandtype_value42 =Excel_data.get("Sizeandtype_value");
			String service_data =Excel_data.get("service_data");
			String lessor_data =Excel_data.get("lessor_data");
			String lessee_data =Excel_data.get("lessee_data");
			String leasekind_data =Excel_data.get("leasekind_data");
			String supcon_data =Excel_data.get("supcon_data");
			String cuscon_data =Excel_data.get("cuscon_data");
			String sz_tp_buttons =Excel_data.get("sz_tp_buttons");
			String service_checkbox =Excel_data.get("service_checkbox");
			String First_Column_Header =Excel_data.get("First_Column_Header");
			String First_Column_Values =Excel_data.get("First_Column_Values");
			String Stock_Column_Value_Headers =Excel_data.get("Stock_Column_Value_Headers");
			String location_Hierachy_Code_value =Excel_data.get("location_Hierachy_Code_value");
			String Total_Records_Verify_Row_Name =Excel_data.get("Total_Records_Verify_Row_Name");
			String Total_Records_Verification_Without_Rows =Excel_data.get("Total_Records_Verification_Without_Rows");
			String Condition =Excel_data.get("Condition");
			String different_headers = Excel_data.get("different_headers");
			String service_code_header = Excel_data.get("service_code_header");
			String lesse_header = Excel_data.get("lesse_header");
			String lessor_code_header = Excel_data.get("lessor_code_header");
			String lease_kind_header = Excel_data.get("lease_kind_header");
			String sup_con_header = Excel_data.get("sup_con_header");
			String cus_con_header = Excel_data.get("cus_con_header");
			String Selected_columns = Excel_data.get("Selected_columns");

			
			
			
			String sz_tp_btn =String.format(On_Off_Hire_Locators.sz_tp_btn, sz_tp_buttons);


			Extent_Start(tc_Name, test, test1);


			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Search_input);
			Step_Start(1, "Click locational hierarchy drop menu", test, test1);
			Step_Start(2, "Click search icon & select country accordingly", test, test1);
			waitForElement(driver, locations_inputfield);
			click(driver,locations_inputfield);

			String location_hierarchy_type =String.format(DropDown_Select, Location_hierachy);
			waitForElement(driver, location_hierarchy_type);
			click(driver, location_hierarchy_type);

			waitForElement(driver, location_Dropdownoption4);
			String locationDropdown_option4 = getText(driver, location_Dropdownoption4);
			System.out.println(locationDropdown_option4);
			if(locationDropdown_option4.equals(Location_hierachy)) {
				System.out.println("MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy+"ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option4);
				Extent_pass_New(driver, "MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy+"ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option4, test, test1);
			}else {
				System.out.println("Not MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy+"ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option4);
				Extent_fail(driver, "NOT MATCHED || EXPECTED LOCATION DROPDOWN LABEL VALUE: "+Location_hierachy+"ACTUAL LOCATION DROPDOWN LABEL VALUE IS: "+locationDropdown_option4, test, test1);
			}  

			waitForElement(driver, countrysearch_icon);
			click(driver,countrysearch_icon);
			twoColumnSearchWindow(driver, different_headers, Condition, location_Hierachy_Code_value);
			Step_End(1, "Click locational hierarchy drop menu", test, test1);
			Step_End(2, "Click search icon & select country accordingly", test, test1);

			Step_Start(3, "Click Size/type from drop menu then select option accrodingly", test, test1);
			waitForElement(driver, sizetype_dropdown);
			click(driver,sizetype_dropdown);

			String sizetype_type = String.format(DropDown_Select, Sizeandtype_value42);
			waitForElement(driver, sizetype_type);
			click(driver, sizetype_type);

			waitForElement(driver, Sizeandtype_Dropdownoption);
			String SizeandtypeDropdown_option = getText(driver, Sizeandtype_Dropdownoption);
			System.out.println(SizeandtypeDropdown_option);
			if(SizeandtypeDropdown_option.equals(Sizeandtype_value42)) {
				System.out.println("MATCHED || EXPECTED SIZEANDTYPE DROPDOWN VALUE IS: "+Sizeandtype_value42+" ACTUAL SIZEANDTYPE DROPDOWN VALUE IS :"+SizeandtypeDropdown_option);
				Extent_pass_New(driver, "MATCHED || EXPECTED SIZEANDTYPE DROPDOWN VALUE IS: "+Sizeandtype_value42+" ACTUAL SIZEANDTYPE DROPDOWN VALUE IS :"+SizeandtypeDropdown_option, test, test1);
			}else {
				System.out.println("NOT MATCHED || EXPECTED SIZEANDTYPE DROPDOWN VALUE IS: "+Sizeandtype_value42+" ACTUAL SIZEANDTYPE DROPDOWN VALUE IS :"+SizeandtypeDropdown_option);
				Extent_fail(driver, "NOT MATCHED || EXPECTED SIZEANDTYPE DROPDOWN VALUE IS: "+Sizeandtype_value42+" ACTUAL SIZEANDTYPE DROPDOWN VALUE IS :"+SizeandtypeDropdown_option, test, test1);
			}  
			if(!service_data.equals("")) {
				waitForElement(driver, service_Checkbox);
				checkBox(driver, service_Checkbox, service_checkbox);
				
				twoColumnSearchWindow(driver, service_code_header, Condition, service_data);

			}else {
				System.out.println("service_data "+"Input Not Available in test data");
			}
			Step_End(3, "Click Size/type from drop menu then select option accrodingly", test, test1);

			Step_Start(4, " Select in-transit checkbox accordingly", test, test1);
			if(!lessor_data.equals("")) {
				List<String> datas = splitAndExpand(lessor_data);
				for(String data :datas) {
					waitForElement(driver, lessor_Add_icon);
					click(driver, lessor_Add_icon);
					twoColumnSearchWindow(driver, lessor_code_header, Condition, data);
					
				}
			}else {
				System.out.println("lessor_data "+"Input Not Available in test data");
			}

			if(!lessee_data.equals("")) {

				List<String> datas = splitAndExpand(lessee_data);
				for(String data :datas) {
					waitForElement(driver, lessee_Add_Icon);
					click(driver, lessee_Add_Icon);
					
					twoColumnSearchWindow(driver, lesse_header, Condition, data);
				}
			}else {
				System.out.println("lessee_data "+"Input Not Available in test data");
			}

			if(!leasekind_data.equals("")) {

				List<String> datas = splitAndExpand(leasekind_data);
				for(String data :datas) {
					waitForElement(driver, leasekind_Add_Icon);
					click(driver, leasekind_Add_Icon);
					twoColumnSearchWindow(driver, lease_kind_header, Condition, data);

				}

			}else {
				System.out.println("leasekind_data "+"Input Not Available in test data");
			}

			if(!supcon_data.equals("")) {

				List<String> datas = splitAndExpand(supcon_data);
				for(String data :datas) {
					waitForElement(driver, supcon_Add_Icon);
					click(driver, supcon_Add_Icon);
					twoColumnSearchWindow(driver, sup_con_header, Condition, data);

				}

			}else {
				System.out.println("supcon_data "+"Input Not Available in test data");
			}

			if(!cuscon_data.equals("")) {

				List<String> datas = splitAndExpand(cuscon_data);
				for(String data :datas) {
					waitForElement(driver, cuscon_Add_Icon);
					click(driver, cuscon_Add_Icon);
					twoColumnSearchWindow(driver, cus_con_header, Condition, data);

				}

			}else {
				System.out.println("cuscon_data "+"Input Not Available in test data");
			}

			if(!sz_tp_buttons.equals("")) {
				waitForElement(driver, sz_tp_btn);
				click(driver, sz_tp_btn);

			}else {
				System.out.println("sz_tp_buttons "+"Input Not Available in test data");
			}
			Step_End(4, " Select in-transit checkbox accordingly", test, test1);

			Step_Start(5, "Click show button & it will show data in grid accordingly", test, test1);

			waitForElement(driver, click_showbtn_stock_status);
			click(driver,click_showbtn_stock_status);

			reArrangeAG_GridColumnsWithoutCheckbox(driver, Selected_columns);
			Step_End(5, "Click show button & it will show data in grid accordingly", test, test1);
			List<String> stockColumnValueHeaders = splitAndExpand(Stock_Column_Value_Headers,",");
			List<String> firstColumnValues = splitAndExpand(First_Column_Values,",");
			waitForElement(driver, Stock_Report_Table);
			List<Map<String, String>> table_Data = extractTableDataByColumn(driver, Stock_Report_Table);
			for(int i =0;i<stockColumnValueHeaders.size();i++) {
				for(int j =0;j<firstColumnValues.size();j++) {
					Step_Start(6, "Get the value Based on the First Column Header , First Column value and Stock Status By Report Column Header From the Test Data", test, test1);
					String actual_Count = getValueByFirstColumnAndHeader(table_Data,First_Column_Header,firstColumnValues.get(j),stockColumnValueHeaders.get(i));
					int count = Integer.parseInt(actual_Count);
					Step_End(6, "Get the value Based on the First Column Header , First Column value and Stock Status By Report Column Header From the Test Data", test, test1);
					Step_Start(7, "By Using the Test datas values Double Click the Cell and open the Stock Report Panel", test, test1);
					String firstHeader = String.format(Stock_Column_Header, First_Column_Header);
					waitForElement(driver, firstHeader);
					String firstColumnColId = getAttribute(driver, firstHeader, "col-id");

					String stockHeader = String.format(Stock_Column_Header, stockColumnValueHeaders.get(i));
					waitForElement(driver, stockHeader);
					mouseOverToElement(driver, stockHeader);
					String stockColumnColId = getAttribute(driver, stockHeader, "col-id");

					String select_Stock_Table_Value = String.format(select_Stock_Table, firstColumnColId,firstColumnValues.get(j),stockColumnColId,actual_Count);
					waitForElement(driver, select_Stock_Table_Value);
					doubleClick(driver,select_Stock_Table_Value);
					Step_End(7, "By Using the Test datas values Double Click the Cell and open the Stock Report Panel", test, test1);
					Step_Start(8, "Count All the Rows in the Stock Report Panel", test, test1);
					int total_Rows = 0;
					waitForElement(driver, Last_Page_Button_Stock_Status_Grid);
						waitForElement(driver, Strock_Summary_Table_Rows);

					
						String status = getAttribute(driver, Last_Page_Button_Stock_Status_Grid,"class");
						
						if(!status.contains("disabled")) {
							waitForElement(driver, Last_Page_Button_Stock_Status_Grid);
							click(driver, Last_Page_Button_Stock_Status_Grid);
						}
						
						waitForElement(driver, Serial_Number_Gridcell);
						String lastRow=getText(driver, Serial_Number_Gridcell);
						total_Rows=Integer.parseInt(lastRow);
						
						waitForElement(driver, Last_Page_Button_Stock_Status_Grid);
						status = getAttribute(driver, Last_Page_Button_Stock_Status_Grid,"class");
						
						if(status.contains("disabled")) {
							waitForElement(driver, Panel_Close);
							click(driver, Panel_Close);
						}
						
					Step_End(8, "Count All the Rows in the Stock Report Panel", test, test1);
					Step_Start(9, "Verify the Both Cell value and the Panlel Count is Same or Not", test, test1);
					if(count==total_Rows) {
						System.out.println("Matched || The Expected "+firstColumnValues.get(j)+" Rows "+stockColumnValueHeaders.get(i)+" Column Value is : "+count+" || The Actual Stock By Report Panel Rows Count is "+total_Rows);
						Extent_pass_New(driver,"Matched || The Expected "+firstColumnValues.get(j)+" Rows "+stockColumnValueHeaders.get(i)+" Column Value is : "+count+" || The Actual Stock By Report Panel Rows Count is "+total_Rows, test, test1);
					}else {
						System.out.println("Not Matched || The Expected "+firstColumnValues.get(j)+" Rows "+stockColumnValueHeaders.get(i)+" Column Value is : "+count+" || The Actual Stock By Report Panel Rows Count is "+total_Rows);
						Extent_fail(driver,"Not Matched || The Expected "+firstColumnValues.get(j)+" Rows "+stockColumnValueHeaders.get(i)+" Column Value is : "+count+" || The Actual Stock By Report Panel Rows Count is "+total_Rows, test, test1);
					}
					Step_End(9, "Verify the Both Cell value and the Panlel Count is Same or Not", test, test1);
					Step_Start(10, "Get the value All the row value from the given Stock Peport Column Header in Test data and get the total count value from the Table", test, test1);
					List<String> ignoredRows = splitAndExpand(Total_Records_Verification_Without_Rows,",");
					List<String> totalvalues = getFilteredValuesByHeader(table_Data,stockColumnValueHeaders.get(i),First_Column_Header, ignoredRows);
					double total_Sum_Value = getSumOfListValues(driver,totalvalues);
					String Total_Count = getValueByFirstColumnAndHeader(table_Data,First_Column_Header,Total_Records_Verify_Row_Name,stockColumnValueHeaders.get(i));
					double Total_Table_Value = Double.parseDouble(Total_Count);
					Step_End(10, "Get the value All the row value from the given Stock Peport Column Header in Test data and get the total count value from the Table", test, test1);
					Step_Start(11, "Verifing the Table's TOTAL value and the  Column values total count is mattched or not", test, test1);
					if(total_Sum_Value==Total_Table_Value) {
						System.out.println("Matched || The Expected "+stockColumnValueHeaders.get(i)+" Column Total Value is : "+total_Sum_Value+" || The Actual Table TOTAL Count is "+Total_Table_Value);
						Extent_pass_New(driver,"Matched || The Expected "+stockColumnValueHeaders.get(i)+" Column Total Value is : "+total_Sum_Value+" || The Actual Table TOTAL Count is "+Total_Table_Value, test, test1);
					}else {
						System.out.println("Not Matched || The Expected "+stockColumnValueHeaders.get(i)+" Column Total Value is : "+total_Sum_Value+" || The Actual Table TOTAL Count is "+Total_Table_Value);
						Extent_fail(driver,"Not Matched || The Expected "+stockColumnValueHeaders.get(i)+" Column Total Value is : "+total_Sum_Value+" || The Actual Table TOTAL Count is "+Total_Table_Value, test, test1);
					}
					Step_End(11, "Verifing the Table's TOTAL value and the  Column values total count is mattched or not", test, test1);
				}
			}
			Extent_completed(tc_Name, test, test1);
		}


	}

}




