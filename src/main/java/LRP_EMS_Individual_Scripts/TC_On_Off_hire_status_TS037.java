package LRP_EMS_Individual_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.On_Off_Hire_Locators;

public class TC_On_Off_hire_status_TS037 extends Keywords{
	
	public void OnOffhirestatusTS037 (WebDriver driver,ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		
		String tc_Name="TC_On_Off_hire_status_TS037";

		
		
	String Username = Excel_data.get("Username");
	String Password = Excel_data.get("Password");	
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
	
	Step_Start(1, "open chrome browser ", test, test1);
	Step_Start(2, "Enter the url", test, test1);
		navigateUrl(driver, url); 
		Step_End(2, "Enter the url", test, test1);
		Step_End(1, "open chrome browser ", test, test1);
		
		LRP_Login(driver, Username, Password);

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
					System.out.println("service_input37 "+"Input Not Available in test data");
				}
		    
		    if(!lessor_input37.equals("")) {
					waitForElement(driver, lessor_searchicon);
					click(driver, lessor_searchicon);
					twoColumnSearchWindow(driver, lessor_code_header, condition, lessor_input37);

				
				}else {
					System.out.println("lessor_input37 "+"Input Not Available in test data");
				}
		    
		    if(!condt_input37.equals("")) {
		    	waitForElement(driver, Condt_field);
		    	click(driver, Condt_field);
					waitForElement(driver, condt_input);
		    		click(driver, condt_input);
				}else {
					System.out.println("condt_input37 "+"Input Not Available in test data");
				}
		    
		    if(!reportype_input37.equals("")) {
		    	waitForElement(driver, report_type_field);
		    	click(driver, report_type_field);
					waitForElement(driver, reportype_input);
		    		click(driver, reportype_input);
				}else {
					System.out.println("reportype_input37 "+"Input Not Available in test data");
				}
		    
		    if(!lessorcontract_input37.equals("")) {
					waitForElement(driver, lessorcontract_searchicon);
					click(driver, lessorcontract_searchicon);
					twoColumnSearchWindow(driver, contract_number_header, condition, lessorcontract_input37);

				
				}else {
					System.out.println("lessorcontract_input37 "+"Input Not Available in test data");
				}
		    
		    if(!leasekind_input37.equals("")) {
		    	waitForElement(driver, Leasekind_field);
		    	click(driver, Leasekind_field);
					waitForElement(driver, leasekind_input);
		    		click(driver, leasekind_input);
				
				}else {
					System.out.println("leasekind_input37 "+"Input Not Available in test data");
				}
		    
		    if(!lessee_input37.equals("")) {
					waitForElement(driver, lessee_searchicon);
					click(driver, lessee_searchicon);
					twoColumnSearchWindow(driver, lesee_code_header, condition, lessee_input37);

				
				}else {
					System.out.println("lessee_input37 "+"Input Not Available in test data");
				}
		    
		    if(!activity_input37.equals("")) {
					waitForElement(driver, activity_Addicon);
					click(driver, activity_Addicon);
					twoColumnSearchWindow(driver, activity_code_header, condition, activity_input37);

				
				}else {
					System.out.println("activity_input37 "+"Input Not Available in test data");
				}
		    
		    if(!sz_tp_buttons37.equals("")) {
		    		waitForElement(driver, sz_tp_btn);
		    		click(driver, sz_tp_btn);
				}else {
					System.out.println("sz_tp_buttons37 "+"Input Not Available in test data");
				}
		    
			Step_Start(14, "Click show button by selecting detail option & it will show data in grid accordingly", test, test1);
		    if(!sum_det_button37.equals("")) {
		    		waitForElement(driver, sum_det_btn);
		    		click(driver, sum_det_btn);
				
				}else {
					System.out.println("sum_det_button37 "+"Input Not Available in test data");
				}
			Step_End(14, "Click show button by selecting detail option & it will show data in grid accordingly", test, test1);

		    if(detail_request.equals("YES")) {
		    		waitForElement(driver, detail_Requestbtn);
		    		click(driver, detail_Requestbtn);
				
				}else {
					System.out.println("detail_request "+"Input Not Available in test data");
				}
		    
			Step_Start(8, "Click locational hierarchy drop menu", test, test1);
			waitForElement(driver, locations_inputfield);
			click(driver,locations_inputfield);
			waitForElement(driver, location_hierarchy_type1);
			click(driver, location_hierarchy_type1);
			
			
			waitForElement(driver, location_dropdown37);
			String locationDropdownoption41 = getText(driver, location_dropdown37);
			if(locationDropdownoption41.equals(Location_hierachy37)) {
				System.out.println("Matched || Expected location value :"+ Location_hierachy37 +" Actual location value : "+ locationDropdownoption41);
				Extent_pass_New(driver, "Matched || Expected location value :"+ Location_hierachy37 +" Actual location value : "+ locationDropdownoption41, test, test1);
			}else {
				System.out.println("Not Matched || Expected location value :"+ Location_hierachy37 +" Actual location value : "+ locationDropdownoption41);
				Extent_fail(driver, "Not Matched || Expected location value :"+ Location_hierachy37 +" Actual location value : "+ locationDropdownoption41, test, test1);
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
				System.out.println("Matched || EXPECTED POPUP: "+ Request_Sent37+"  || ACTUAL POPUP: "+report_request);
				Extent_pass_New(driver, "Matched || EXPECTED POPUP: "+ Request_Sent37+" || ACTUAL POPUP: "+report_request, test, test1);
			}else {
				System.out.println("Not Matched || EXPECTED POPUP: "+ Request_Sent37+" || ACTUAL POPUP: "+report_request);
				Extent_fail(driver, "Not Matched || EXPECTED POPUP: "+ Request_Sent37+" || ACTUAL POPUP: "+report_request, test, test1);
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
				
				System.out.println("Matched || Containers in excel : "+ count_in_excel+" || actual containers in grid : "+ total_count_exp);
				Extent_pass_New(driver, "Matched || Containers in excel : "+ count_in_excel+" || actual containers in grid : "+ total_count_exp, test, test1);
			
			}else {
				
				System.out.println("Not Matched || Containers in excel : "+ count_in_excel+" || actual containers in grid : "+  total_count_exp);
				Extent_fail(driver, "Not Matched || Containers in excel : "+ count_in_excel+" || actual containers in grid : "+ total_count_exp, test, test1);
			}
			Step_End(19, "verify the downloaded the sheet showing local file or not", test, test1);

			
			
			Extent_completed(tc_Name, test, test1);

		
	}
	}
