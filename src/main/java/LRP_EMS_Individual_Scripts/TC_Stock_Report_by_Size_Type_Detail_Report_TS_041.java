package LRP_EMS_Individual_Scripts;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



import locators.On_Off_Hire_Locators;

import java.io.BufferedReader;
import java.io.IOException;
public class TC_Stock_Report_by_Size_Type_Detail_Report_TS_041 extends Keywords{
	
	public void StockReportbySizeTypeDetailReportTS041 (WebDriver driver, ExtentTest test1, ExtentTest test,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String tc_Name="TC_Stock_Report_by_Size_Type_Detail_Report_TS_041";

		
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");	
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
		String lease_code_header = Excel_data.get("lease_code_header");
		String lessor_code_header = Excel_data.get("lessor_code_header");
		String lease_kind_header = Excel_data.get("lease_kind_header");
		String sup_con_header = Excel_data.get("sup_con_header");
		String cus_con_header = Excel_data.get("cus_con_header");
		String Column_Values = Excel_data.get("Column_Values");


		
		String sz_tp_btn =String.format(On_Off_Hire_Locators.sz_tp_btn, sz_tp_buttons);


		String sizetype_type1 =String.format(On_Off_Hire_Locators.sizetype_type1, Sizeandtype_value41);
		String location_hierarchy_type7 = String.format(On_Off_Hire_Locators.location_hierarchy_type7,Location_hierachy41);
		
		
		Extent_Start(tc_Name, test, test1);
		
		
		navigateUrl(driver, url); 
		
		LRP_Login(driver, Username, Password);
	    
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
		
		
		
}}
