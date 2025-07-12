package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.On_Off_Hire_Locators;

public class TC_Stock_Report_by_Size_Type_Detail_Report_TS_040 extends Keywords{

	public void StockReportbySizeTypeDetailReportTS040 (WebDriver driver,ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String tc_Name="TC_Stock_Report_by_Size_Type_Detail_Report_TS_040";

		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");	
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

		navigateUrl(driver, url); 

		LRP_Login(driver, Username, Password);
		
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
	}



}
