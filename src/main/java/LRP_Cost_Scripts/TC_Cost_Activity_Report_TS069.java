package LRP_Cost_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS069 extends Keywords {

	public void Cost_Activity_Report_TS069(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS069";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		String OperationList_MoreOption = Excel_data.get("OperationList_MoreOption");
		String columns_to_filter = Excel_data.get("columns_to_filter");
		String Load_Confirmed_Status = Excel_data.get("Load_Confirmed_Status");
		String operation_list_module = Excel_data.get("operation_list_module");
		String condition = Excel_data.get("condition");
		String columns_filter_opl = Excel_data.get("columns_filter_opl");

		String Search_Type2 =Excel_data.get("Search_Type2");
		String Search_Input2 =Excel_data.get("Search_Input2");
		String Search_Type3 =Excel_data.get("Search_Type3");
		String Search_Input3 =Excel_data.get("Search_Input3");
		
		String terminal_header =Excel_data.get("terminal_header");
		String port_header =Excel_data.get("port_header");
		String voyage_header =Excel_data.get("voyage_header");
		String vessel_header =Excel_data.get("vessel_header");
		String service_header =Excel_data.get("service_header");
		String AgencyUser = Excel_data.get("AgencyUser");

		String Load_Activity = Excel_data.get("Load_Activity");
		String Discharge_Activity = Excel_data.get("Discharge_Activity");
		String Discharge_Confirmed_Status = Excel_data.get("Discharge_Confirmed_Status");
		String Plan_Value_OperationListView = Excel_data.get("Plan_Value_OperationListView");
		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		Step_Start(1,"Once login to the application and click on switch profile option and select the required agency.",
				test, test1);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.",
				test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		
		newButton(driver);
		
		Step_Start(3, "Click on the global search option which is available in the tool bar.", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(3, "Click on the global search option which is available in the tool bar.", test, test1);

		Step_Start(4, "Check whether it opens a new search window.", test, test1);
	
		Step_Start(5, "Enter the required CAR No. in the CAR No search field.", test, test1);

		Step_Start(6, "Then click on the search button.", test, test1);

		Step_Start(7, "System will show the CAR No.", test, test1);

		globalValueSearchWindow(driver, CAR_Retrieve_Condition, CAR_Retrieve_Type, CAR_Number_Retrieve, Search_Type2, Search_Input2, Search_Type3, Search_Input3);
		Step_End(4, "Check whether it opens a new search window.", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field.", test, test1);
		Step_End(6, "Then click on the search button.", test, test1);
		Step_End(7, "System will show the CAR No.", test, test1);

		waitForElement(driver, CAR_Input);

		waitForElement(driver, MoreOption_Grid);
		click(driver,MoreOption_Grid);
		
		waitForElement(driver, FilterOption_Menu);
		click(driver,FilterOption_Menu);
		
		boolean LoadVal=false;
		waitForElement(driver, Main_Activity_FilterInput_CAR_Summary);
		sendKeys(driver, Main_Activity_FilterInput_CAR_Summary, Load_Activity);
		if(isdisplayed(driver, CAR_Summary_TableColumn)) {
			LoadVal=true;
		}
		
		boolean DischargeVal=false;
		waitForElement(driver, Main_Activity_FilterInput_CAR_Summary);
		Newclear(driver, Main_Activity_FilterInput_CAR_Summary);
		sendKeys(driver, Main_Activity_FilterInput_CAR_Summary, Discharge_Activity);
		if(isdisplayed(driver, CAR_Summary_TableColumn)) {
			DischargeVal=true;
		}else {
			waitForElement(driver, Main_Activity_FilterInput_CAR_Summary);
			Newclear(driver, Main_Activity_FilterInput_CAR_Summary);
			sendKeys(driver, Main_Activity_FilterInput_CAR_Summary, "DISHARGE");
			if(isdisplayed(driver, CAR_Summary_TableColumn)) {
				DischargeVal=true;
			}
		}
		
		Step_Start(8, "Click on the click for more options above the grid.", test, test1);

		waitForElement(driver, more_options_Car);
		click(driver, more_options_Car);

		Step_End(8, "Click on the click for more options above the grid.", test, test1);

		Step_Start(9, "Select the operation list option.", test, test1);

		String more_Options_Select = String.format(more_options_menu_Car, OperationList_MoreOption);
		waitForElement(driver, more_Options_Select);
		click(driver, more_Options_Select);

		Step_End(9, "Select the operation list option.", test, test1);

		Step_Start(10, "Ensure that a new window gets opened.", test, test1);

		waitForElement(driver, load_discharge_window);
		if (isdisplayed(driver, load_discharge_window)) {
			System.out.println("Expected : Load discharge window Should opened || Actual : Load discharge window is opened ");
			Extent_pass_New(driver, "Expected : Load discharge window Should opened || Actual : Load discharge window is opened ", test, test1);
		} else {
			System.out.println("Expected : Load discharge window Should opened || Actual : Load discharge window is not opened ");
			Extent_fail(driver, "Expected : Load discharge window Should opened || Actual : Load discharge window is not opened ", test, test1);
		}

		Step_End(10, "Ensure that a new window gets opened.", test, test1);

		Step_Start(11, "Check whether the details of the containers used are shown.", test, test1);
		
		waitForElement(driver, More_Option_Load_Table_CAR);
		click(driver,More_Option_Load_Table_CAR);
		
		waitForElement(driver, Condition_Filter_Load_Table);
		click(driver,Condition_Filter_Load_Table);
		
		waitForElement(driver, load_window_sidebar_columns);
		click(driver, load_window_sidebar_columns);
		waitForDisplay(driver, load_window_select_all);
		jsClick(driver, load_window_select_all);

		List<String> ExpensiveTable_Headers = splitAndExpand(columns_to_filter);
		for (String FilterHeader : ExpensiveTable_Headers) {
			waitForElement(driver, load_window_search_input);
			clear(driver, load_window_search_input);
			waitForElement(driver, load_window_search_input);
			sendKeys(driver, load_window_search_input, FilterHeader);

			String checkbox = String.format(load_window_select_column, FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}

		waitForElement(driver, load_window_sidebar_columns);
		click(driver, load_window_sidebar_columns);
		
		List<String> Load_Confirmed_ContainerNo=new ArrayList<String>();
		List<String> Load_Confirmed_BookNo=new ArrayList<String>();
		
		//extractDataByHeader
		List<String> Discharge_Confirmed_ContainerNo=new ArrayList<String>();
		List<String> Discharge_Confirmed_BookNo=new ArrayList<String>();

		if(LoadVal) {
			waitForElement(driver, load_window_move_status_filter);
			click(driver, load_window_move_status_filter);
			sendKeys(driver, load_window_move_status_filter, Load_Confirmed_Status);
			
			waitForElement(driver, load_window_table);
			
			int k=0;
			String container=String.format(Container_Numbers_Load_CAR, k);
			while(isdisplayed(driver, container)) {
				mouseOverToElement(driver, container);
				String book=String.format(Book_Numbers_Load_CAR, k);
				String containerNum=getText(driver, container);
				String bookNum=getText(driver, book);
				Load_Confirmed_ContainerNo.add(containerNum);
				Load_Confirmed_BookNo.add(bookNum);
				k++;
				container=String.format(Container_Numbers_Load_CAR, k);
			}
				
		}
		
		if(DischargeVal) {
			waitForElement(driver, load_window_move_status_filter);
			Newclear(driver, load_window_move_status_filter);
			sendKeys(driver, load_window_move_status_filter, Discharge_Confirmed_Status);
			waitForElement(driver, load_window_table);
			
			int k=0;
			String container=String.format(Container_Numbers_Load_CAR, k);
			while(isdisplayed(driver, container)) {
				mouseOverToElement(driver, container);
				String book=String.format(Book_Numbers_Load_CAR, k);
				String containerNum=getText(driver, container);
				String bookNum=getText(driver, book);
				Discharge_Confirmed_ContainerNo.add(containerNum);
				Discharge_Confirmed_BookNo.add(bookNum);
				k++;
				container=String.format(Container_Numbers_Load_CAR, k);
			}
		}

		waitForElement(driver, load_window_ok_btn);
		click(driver, load_window_ok_btn);

		Step_End(11, "Check whether the details of the containers used are shown.", test, test1);

		Step_Start(12, "Note the service, vessel, voyage and bound details from CAR.", test, test1);

		waitForElement(driver, service_textfld_Car);
		String service_car = getAttribute(driver, service_textfld_Car, "value");

		waitForElement(driver, vessel_textfld_Car);
		String vessel_car = getAttribute(driver, vessel_textfld_Car, "value");

		waitForElement(driver, port_textfld_Car);
		String port_car = getAttribute(driver, port_textfld_Car, "value");

		waitForElement(driver, terminal_textfld_Car);
		String terminal_car = getAttribute(driver, terminal_textfld_Car, "value");

		waitForElement(driver, voyage_textfld_Car);
		String voyage_car = getAttribute(driver, voyage_textfld_Car, "value");

		Step_End(12, "Note the service, vessel, voyage and bound details from CAR.", test, test1);

		Step_Start(13,
				"To check these details, enter the screen name as 'Operation list view' in the module search field.",
				test, test1);

		moduleNavigate(driver, operation_list_module);

		newButton(driver);

		Step_End(13,"To check these details, enter the screen name as 'Operation list view' in the module search field.",
				test, test1);

		Step_Start(14, "Give the service, vessel, voyage, bound, port and terminal details and click the load option.",
				test, test1);

		waitForElement(driver, service_search_OpL);
		click(driver, service_search_OpL);
		twoColumnSearchWindow(driver, service_header, condition, service_car);
		
		waitForElement(driver, vessel_search_OpL);
		click(driver, vessel_search_OpL);
		twoColumnSearchWindow(driver, vessel_header, condition, vessel_car);
		
		waitForElement(driver, voyage_search_OpL);
		click(driver, voyage_search_OpL);
		if (voyage_car.matches(".*\\d.*[a-zA-Z].*")) {
			String[] parts = voyage_car.split("(?<=\\d)(?=\\D)"); // Split after digits and before non-digits

			String numberPart = parts[0];
			String letterPart = parts[1];

			String VoyageValue=numberPart+","+letterPart;
			System.out.println("Number part: " + numberPart);
			System.out.println("Letter part: " + letterPart);
			twoColumnMultipleSearchWindow(driver, voyage_header, condition, VoyageValue);
		} else {
			twoColumnSearchWindow(driver, voyage_header, condition, voyage_car);
		}
		
		waitForElement(driver, port_search_OpL);
		click(driver, port_search_OpL);
		twoColumnSearchWindow(driver, port_header, condition, port_car);

		waitForElement(driver, terminal_search_OpL);
		click(driver, terminal_search_OpL);
		twoColumnSearchWindow(driver, terminal_header, condition, terminal_car);
		
		waitForElement(driver, Plan_OperationList);
		click(driver,Plan_OperationList);
		formatLocatorClick(driver, DropDown_Select, Plan_Value_OperationListView);
		
		Step_End(14, "Give the service, vessel, voyage, bound, port and terminal details and click the load option.",
				test, test1);
		Step_Start(15,
				"Filter the required details(load confirmed and Discharge confirmed) and check whether the same container details are shown.",
				test, test1);

		if(LoadVal) {
			waitForElement(driver, Load_List_OperationList);
			click(driver,Load_List_OperationList);
			
			waitForElement(driver, load_btn_opl);
			click(driver, load_btn_opl);
			
			waitForElement(driver, opl_sidebar_columns);
			click(driver, opl_sidebar_columns);
			waitForDisplay(driver, opl_select_all);
			jsClick(driver, opl_select_all);

			List<String> operation_list_headers = splitAndExpand(columns_filter_opl);
			for (String FilterHeader : operation_list_headers) {
				waitForElement(driver, opl_search_input);
				clear(driver, opl_search_input);
				waitForElement(driver, opl_search_input);
				sendKeys(driver, opl_search_input, FilterHeader);

				String checkbox = String.format(opl_select_column, FilterHeader);
				waitForDisplay(driver, checkbox);
				jsClick(driver, checkbox);
			}

			waitForElement(driver, opl_sidebar_columns);
			click(driver, opl_sidebar_columns);

			waitForElement(driver, funnel_icon_opl);
			click(driver, funnel_icon_opl);

			waitForElement(driver, operation_list_move_status_filter);
			click(driver, operation_list_move_status_filter);
			sendKeys(driver, operation_list_move_status_filter, Load_Confirmed_Status);
			
			List<String> Load_Confirmed_ContainerNo_OL=new ArrayList<String>();
			List<String> Load_Confirmed_BookNo_OL=new ArrayList<String>();

			int k=0;
			waitForElement(driver, opl_table);
			String container=String.format(Container_Number_OperationList, k);
			while(isdisplayed(driver, container)) {
				mouseOverToElement(driver, container);
				String book=String.format(Book_Number_OperationList, k);
				String containerNum=getText(driver, container);
				String bookNum=getText(driver, book);
				Load_Confirmed_ContainerNo_OL.add(containerNum);
				Load_Confirmed_BookNo_OL.add(bookNum);
				k++;
				container=String.format(Container_Number_OperationList, k);
			}
			
			if(CompareListvalues(Load_Confirmed_ContainerNo_OL,Load_Confirmed_ContainerNo)) {
				System.out.println("Load Container Number Matched || Expected in Cost Activity "+Load_Confirmed_ContainerNo+"      ||       Actual in Operation List View  : "+Load_Confirmed_ContainerNo_OL);
				Extent_pass_New(driver, "Load Container Number Matched || Expected in Cost Activity "+Load_Confirmed_ContainerNo+"      ||       Actual in Operation List View  : "+Load_Confirmed_ContainerNo_OL, test, test1);
			}else {
				System.out.println("Load Container Number Not Matched || Expected in Cost Activity "+Load_Confirmed_ContainerNo+"      ||       Actual in Operation List View  : "+Load_Confirmed_ContainerNo_OL);
				Extent_fail(driver, "Load Container Number Not Matched || Expected in Cost Activity "+Load_Confirmed_ContainerNo+"      ||       Actual in Operation List View  : "+Load_Confirmed_ContainerNo_OL, test, test1);
			}
			
			if(CompareListvalues(Load_Confirmed_BookNo_OL,Load_Confirmed_BookNo)) {
				System.out.println("Load Book Number Matched || Expected in Cost Activity "+Load_Confirmed_BookNo+"      ||       Actual in Operation List View  : "+Load_Confirmed_BookNo_OL);
				Extent_pass_New(driver, "Load Book Number Matched || Expected in Cost Activity "+Load_Confirmed_BookNo+"      ||       Actual in Operation List View  : "+Load_Confirmed_BookNo_OL, test, test1);
			}else {
				System.out.println("Load Book Number Not Matched || Expected in Cost Activity "+Load_Confirmed_BookNo+"      ||       Actual in Operation List View  : "+Load_Confirmed_BookNo_OL);
				Extent_fail(driver, "Load Book Number Not Matched || Expected in Cost Activity "+Load_Confirmed_BookNo+"      ||       Actual in Operation List View  : "+Load_Confirmed_BookNo_OL, test, test1);
			}
		}
		
		if(DischargeVal) {
			waitForElement(driver, Discharge_List_OperationList);
			click(driver,Discharge_List_OperationList);
			
			
			
			
			
			
			
			waitForElement(driver, service_search_OpL);
			click(driver, service_search_OpL);
			twoColumnSearchWindow(driver, service_header, condition, service_car);
			
			waitForElement(driver, vessel_search_OpL);
			click(driver, vessel_search_OpL);
			twoColumnSearchWindow(driver, vessel_header, condition, vessel_car);
			
			waitForElement(driver, voyage_search_OpL);
			click(driver, voyage_search_OpL);
			if (voyage_car.matches(".*\\d.*[a-zA-Z].*")) {
				String[] parts = voyage_car.split("(?<=\\d)(?=\\D)"); // Split after digits and before non-digits

				String numberPart = parts[0];
				String letterPart = parts[1];

				String VoyageValue=numberPart+","+letterPart;
				System.out.println("Number part: " + numberPart);
				System.out.println("Letter part: " + letterPart);
				twoColumnMultipleSearchWindow(driver, voyage_header, condition, VoyageValue);
			} else {
				twoColumnSearchWindow(driver, voyage_header, condition, voyage_car);
			}
			
			waitForElement(driver, port_search_OpL);
			click(driver, port_search_OpL);
			twoColumnSearchWindow(driver, port_header, condition, port_car);

			waitForElement(driver, terminal_search_OpL);
			click(driver, terminal_search_OpL);
			twoColumnSearchWindow(driver, terminal_header, condition, terminal_car);
			
			waitForElement(driver, Plan_OperationList);
			click(driver,Plan_OperationList);
			formatLocatorClick(driver, DropDown_Select, Plan_Value_OperationListView);
			
			
			
			
			
			
			
			
			waitForElement(driver, load_btn_opl);
			click(driver, load_btn_opl);
			
			waitForElement(driver, opl_sidebar_columns);
			click(driver, opl_sidebar_columns);
			waitForDisplay(driver, opl_select_all);
			jsClick(driver, opl_select_all);

			List<String> operation_list_headers = splitAndExpand(columns_filter_opl);
			for (String FilterHeader : operation_list_headers) {
				waitForElement(driver, opl_search_input);
				clear(driver, opl_search_input);
				waitForElement(driver, opl_search_input);
				sendKeys(driver, opl_search_input, FilterHeader);

				String checkbox = String.format(opl_select_column, FilterHeader);
				waitForDisplay(driver, checkbox);
				jsClick(driver, checkbox);
			}

			waitForElement(driver, opl_sidebar_columns);
			click(driver, opl_sidebar_columns);

			waitForElement(driver, funnel_icon_opl);
			click(driver, funnel_icon_opl);

			waitForElement(driver, operation_list_move_status_filter);
			click(driver, operation_list_move_status_filter);
			sendKeys(driver, operation_list_move_status_filter, Discharge_Confirmed_Status);

			List<String> Discharge_Confirmed_ContainerNo_OL=new ArrayList<String>();
			List<String> Discharge_Confirmed_BookNo_OL=new ArrayList<String>();
			
			int k=0;
			waitForElement(driver, opl_table);
			String container=String.format(Container_Number_OperationList, k);
			while(isdisplayed(driver, container)) {
				mouseOverToElement(driver, container);
				String book=String.format(Book_Number_OperationList, k);
				String containerNum=getText(driver, container);
				String bookNum=getText(driver, book);
				Discharge_Confirmed_ContainerNo_OL.add(containerNum);
				Discharge_Confirmed_BookNo_OL.add(bookNum);
				k++;
				container=String.format(Container_Number_OperationList, k);
			}
			
			if(CompareListvalues(Discharge_Confirmed_ContainerNo_OL,Discharge_Confirmed_ContainerNo)) {
				System.out.println("Discharge Container Number Matched || Expected in Cost Activity "+Discharge_Confirmed_ContainerNo+"      ||       Actual in Operation List View  : "+Discharge_Confirmed_ContainerNo_OL);
				Extent_pass_New(driver, "Discharge Container Number Matched || Expected in Cost Activity "+Discharge_Confirmed_ContainerNo+"      ||       Actual in Operation List View  : "+Discharge_Confirmed_ContainerNo_OL, test, test1);
			}else {
				System.out.println("Discharge Container Number Not Matched || Expected in Cost Activity "+Discharge_Confirmed_ContainerNo+"      ||       Actual in Operation List View  : "+Discharge_Confirmed_ContainerNo_OL);
				Extent_fail(driver, "Discharge Container Number Not Matched || Expected in Cost Activity "+Discharge_Confirmed_ContainerNo+"      ||       Actual in Operation List View  : "+Discharge_Confirmed_ContainerNo_OL, test, test1);
			}
			
			if(CompareListvalues(Discharge_Confirmed_BookNo_OL,Discharge_Confirmed_BookNo)) {
				System.out.println("Discharge Book Number Matched || Expected in Cost Activity "+Discharge_Confirmed_BookNo+"      ||       Actual in Operation List View  : "+Discharge_Confirmed_BookNo_OL);
				Extent_pass_New(driver, "Discharge Book Number Matched || Expected in Cost Activity "+Discharge_Confirmed_BookNo+"      ||       Actual in Operation List View  : "+Discharge_Confirmed_BookNo_OL, test, test1);
			}else {
				System.out.println("Discharge Book Number Not Matched || Expected in Cost Activity "+Discharge_Confirmed_BookNo+"      ||       Actual in Operation List View  : "+Discharge_Confirmed_BookNo_OL);
				Extent_fail(driver, "Discharge Book Number Not Matched || Expected in Cost Activity "+Discharge_Confirmed_BookNo+"      ||       Actual in Operation List View  : "+Discharge_Confirmed_BookNo_OL, test, test1);
			}
		}
		
		Step_End(15,
				"Filter the required details(load confirmed and Discharge confirmed) and check whether the same container details are shown.",
				test, test1);

		Extent_completed(tc_Name, test, test1);

	}
}
