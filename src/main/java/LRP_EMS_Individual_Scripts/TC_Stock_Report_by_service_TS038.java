package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Stock_Report_by_service_TS038 extends Keywords{
	
	public void StockReportbyserviceTS038 (WebDriver driver,ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		
		
		String tc_Name="TC_Stock_Report_by_service_TS038";
		
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");	
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
	navigateUrl(driver, url);
	
	
	LRP_Login(driver, Username, Password);
	
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
	}

}
