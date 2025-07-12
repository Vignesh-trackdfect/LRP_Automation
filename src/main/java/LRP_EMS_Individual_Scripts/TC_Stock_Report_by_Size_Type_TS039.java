package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



import locators.On_Off_Hire_Locators;

public class TC_Stock_Report_by_Size_Type_TS039 extends Keywords{
	
	public void StockReportbySizeTypeTS039 (WebDriver driver,ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		
		
		String tc_Name="TC_Stock_Report_by_Size_Type_TS039";

		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");	
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
		
		
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
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
}
	}