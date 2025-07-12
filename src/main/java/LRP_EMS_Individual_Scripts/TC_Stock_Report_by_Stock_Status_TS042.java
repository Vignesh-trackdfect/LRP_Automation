package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.On_Off_Hire_Locators;

public class TC_Stock_Report_by_Stock_Status_TS042 extends Keywords{

	public void StockReportbyStockStatusTS042 (WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String tc_Name="TC_Stock_Report_by_Stock_Status_TS042";

		


		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");	
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

		navigateUrl(driver, url); 
		LRP_Login(driver, Username, Password);

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