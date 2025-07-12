package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS082 extends Keywords{

	public void  Cost_Activity_Report_TS082(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		
		String tc_Name = "TC_Cost_Activity_Report_TS082";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		
		String cost_Inbox_Module = Excel_data.get("Cost_Inbox_Module");
		String Service_details_Codition = Excel_data.get("Service_details_Codition");
		String Arrival_Date_Condition = Excel_data.get("Arrival_Date_Condition");
		String Select_Predicatble_Sub_Activity_Name = Excel_data.get("Select_Predicatble_Sub_Activity_Name");
		String Un_Predictable_Vendor_Code = Excel_data.get("Un_Predictable_Vendor_Code");
		String car_Number = Excel_data.get("Car_Number");
		String vesselType_Cost_Inbox = Excel_data.get("VesselType_Cost_Inbox");
		String columnHeaders = Excel_data.get("ColumnHeaders");
		String Un_Predictable_Activate_Name = Excel_data.get("Un_Predictable_Activate_Name");
		String Type_Quantity = Excel_data.get("Type_Quantity");

		String port_code_header = Excel_data.get("port_code_header");
		String service_header = Excel_data.get("service_header");
		String vessel_code_header = Excel_data.get("vessel_code_header");
		String terminal_code_header = Excel_data.get("terminal_code_header");
		String arrival_date_header = Excel_data.get("arrival_date_header");
		String Contract_Number_Values = Excel_data.get("Contract_Number_Values");
		String Head_Values = Excel_data.get("Head_Values");
		String Version_Number_Values = Excel_data.get("Version_Number_Values");
		String EQP_Type = Excel_data.get("EQP_Type");
		String EQP_Status = Excel_data.get("EQP_Status");
		String Cost_Inbox_Date = Excel_data.get("Cost_Inbox_Date");

		String Table_Headers_column =Excel_data.get("Table_Headers_column");


		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		
		Step_Start(1, "Once login to the application and click on switch profile option and select for the required agency.", test, test1);
		
		SwitchProfile(driver, AgencyUser);

		Step_End(1, "Once login to the application and click on switch profile option and select for the required agency.", test, test1);


		
		Step_Start(2, "Enter the screen name as 'Cost Inbox' in module search field.", test, test1);
		
		moduleNavigate(driver, cost_Inbox_Module);
		
		Step_End(2, "Enter the screen name as 'Cost Inbox' in module search field.", test, test1);
		Step_Start(3, "Select the required date in the Date field.", test, test1);

		waitForElement(driver, date_cost_Inbox);
		click(driver,date_cost_Inbox);
		
		selectDatePicker(driver, date_cost_Inbox, Cost_Inbox_Date);
		
		Step_End(3, "Select the required date in the Date field.", test, test1);
		Step_Start(4, "Click on the Show button.", test, test1);

		String select_VesselType=String.format(vessel_Type_CI, vesselType_Cost_Inbox);
		waitForElement(driver, select_VesselType);
		click(driver,select_VesselType);
		
		waitForElement(driver, show_Button_CI);
		click(driver,show_Button_CI);
		
		Step_End(4, "Click on the Show button.", test, test1);
		Step_Start(5, "Click on the Arrow mark which is available at Approved folder.", test, test1);
		
		waitForElement(driver, approved_Toggler_CI);
		click(driver,approved_Toggler_CI);
		
		Step_End(5, "Click on the Arrow mark which is available at Approved folder.", test, test1);
		Step_Start(6, "Click on the CAR node.", test, test1);

		waitForElement(driver, car_Tree_Item_CI);
		click(driver,car_Tree_Item_CI);
		
		Step_End(6, "Click on the CAR node.", test, test1);
		Step_Start(7, "System will show the Approved CAR's in the AG grid.", test, test1);

		waitForElement(driver, ag_Grid_ToolPanel_Button_CI);
		click(driver,ag_Grid_ToolPanel_Button_CI);
		
		
		waitForElement(driver, conditionFilter_AG_Grid_CI);
		click(driver,conditionFilter_AG_Grid_CI);
	
		
		Step_End(7, "System will show the Approved CAR's in the AG grid.", test, test1);
		Step_Start(8, "Select any open CAR based on the CAR status column which is available in the AG grid.", test, test1);

		waitForElement(driver, report_ID_Filter_CI);
		sendKeys(driver, report_ID_Filter_CI, car_Number);
		
	
		waitForElement(driver, columns_Button_CI);
		click(driver, columns_Button_CI);
		
		waitForElement(driver, column_All_Select_CheckBox_CAR);
		click(driver, column_All_Select_CheckBox_CAR);
		
		List<String> column_Headers=splitAndExpand(columnHeaders);
		for(int i=0;i<column_Headers.size();i++) {
		String column=column_Headers.get(i);
		click(driver, column_SearchBox_CAR);
		clear(driver, column_SearchBox_CAR);
		sendKeys(driver, column_SearchBox_CAR, column);
		String checkbox=String.format(column_CheckBox_CAR, column);
		click(driver, checkbox);
		
		}
		waitForElement(driver, columns_Button_CI);
		click(driver, columns_Button_CI);
		
		
		Step_Start(17, "Copy the Service, Vessel, Port, Terminal, Arrival date, voyage and bound informations.", test, test1);

		String portCode_Value=String.format(portCode_Gridcell_CI, car_Number);
		waitForElement(driver, portCode_Value);
		click(driver, portCode_Value);
		waitForElement(driver, portCode_Value);
		String actual_PortCode=getText(driver, portCode_Value);
		System.out.println("actual_PortCode : "+actual_PortCode);
		
		String serviceCode_Value=String.format(serviceCode_Gridcell_CI, car_Number);
		waitForElement(driver, serviceCode_Value);
		String actual_ServiceCode=getText(driver, serviceCode_Value);
		System.out.println("actual_ServiceCode : "+actual_ServiceCode);
		
		String vesselCode_Value=String.format(vesselCode_Gridcell_CI, car_Number);
		waitForElement(driver, vesselCode_Value);
		String actual_VesselCode=getText(driver, vesselCode_Value);
		System.out.println("actual_VesselCode : "+actual_VesselCode);
		
		String terminalCode_Value=String.format(terminalCode_Gridcell_CI, car_Number);
		waitForElement(driver, terminalCode_Value);
		String actual_terminalCode=getText(driver, terminalCode_Value);
		System.out.println("actual_terminalCode : "+actual_terminalCode);
		
		String contractType_Value=String.format(contractType_Gridcell_CI, car_Number);
		waitForElement(driver, contractType_Value);
		String actual_ContractType=getText(driver, contractType_Value);
		System.out.println("actual_ContractType : "+actual_ContractType);
		
		String mode_Value=String.format(mode_Gridcell_CI, car_Number);
		waitForElement(driver, mode_Value);
		String actual_Mode=getText(driver, mode_Value);
		System.out.println("actual_Mode : "+actual_Mode);
		
		String arraivalDate_Value=String.format(arrivalDate_Gridcell_CI, car_Number);
		waitForElement(driver, arraivalDate_Value);
		String actual_ArrivalDate=getText(driver, arraivalDate_Value);
		System.out.println("actual_ArrivalDate : "+actual_ArrivalDate);
		
	
		 DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        
	        // Parse the input string to a LocalDate
	        LocalDate date = LocalDate.parse(actual_ArrivalDate, inputFormatter);
	        
	        // Define the desired output format
	        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        
	        // Format the LocalDate object
	        String act_ArrDate = date.format(outputFormatter);
	
	        System.out.println("act_ArrDate : "+act_ArrDate);
	        
	        
			Step_End(17, "Copy the Service, Vessel, Port, Terminal, Arrival date, voyage and bound informations.", test, test1);

			Step_End(8, "Select any open CAR based on the CAR status column which is available in the AG grid.", test, test1);

			Step_Start(13, "Click on the 'Enable Supplementary' option.", test, test1);

			waitForElement(driver, enable_Supplementary_Button_CI);
		click(driver, enable_Supplementary_Button_CI);

		Step_End(13, "Click on the 'Enable Supplementary' option.", test, test1);
		Step_Start(14, "Check whether the system shows an information message as 'Supplementary CAR is enabled successfully'.", test, test1);

		waitForPopup(driver, popup_Message, "Supplementary CAR is enabled successfully");
		if(isdisplayed(driver, popup_Message)) {
			String actualPopup=getText(driver, popup_Message);
			System.out.println("actualPopup : "+actualPopup);
			Extent_pass_New(driver, "actualPopup : "+actualPopup, test, test1);
		}
		
		Step_End(14, "Check whether the system shows an information message as 'Supplementary CAR is enabled successfully'.", test, test1);
		Step_Start(15, "Click on ok.", test, test1);
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(15, "Click on ok.", test, test1);

		Step_Start(16, "Check the Enable supplementary checkbox should be selected(True) for that row.", test, test1);
		
		waitForElement(driver, enable_Supplementary_Button_CI);

		Step_End(16, "Check the Enable supplementary checkbox should be selected(True) for that row.", test, test1);

		Step_Start(18, "Enter the screen name as 'Cost Activity report' in module search field.", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(18, "Enter the screen name as 'Cost Activity report' in module search field.", test, test1);

		Step_Start(12, "Then confirm the CAR status is changed as 'CLOSED' for that row.", test, test1);

		
		waitForElement(driver, Contract_Type_Input_CAR);
		
		Step_End(12, "Then confirm the CAR status is changed as 'CLOSED' for that row.", test, test1);
		Step_Start(19, "Select the required contract type and mode.", test, test1);
		
		click(driver,Contract_Type_Input_CAR);


		String SelectContract=String.format(DropDown_Select, actual_ContractType);
		waitForElement(driver, SelectContract);
		click(driver,SelectContract);
		
		waitForElement(driver, Mode_Select_Input_CAR);
		click(driver,Mode_Select_Input_CAR);
		
		if(actual_Mode.contains("Main")) {
			actual_Mode="Mainline";
		}
		String SelectModeValue=String.format(DropDown_Select, actual_Mode);
		waitForElement(driver, SelectModeValue);
		click(driver,SelectModeValue);
		
		Step_End(19, "Select the required contract type and mode.", test, test1);
		Step_Start(20, "Paste the Service, Vessel, Port, Terminal, Arrival date, voyage and bound informations.", test, test1);

		waitForElement(driver, Service_Search_Btn_CAR);
		click(driver,Service_Search_Btn_CAR);
		twoColumnSearchWindow(driver, service_header, Service_details_Codition, actual_ServiceCode);
		waitForElement(driver, Vessel_Search_Btn_CAR);
		click(driver,Vessel_Search_Btn_CAR);
		twoColumnSearchWindow(driver, vessel_code_header, Service_details_Codition, actual_VesselCode);

		waitForElement(driver, Port_Search_Btn_CAR);
		click(driver,Port_Search_Btn_CAR);
		twoColumnSearchWindow(driver, port_code_header, Service_details_Codition, actual_PortCode);

		waitForElement(driver, Terminal_Search_Btn_CAR);
		click(driver,Terminal_Search_Btn_CAR);
		twoColumnSearchWindow(driver, terminal_code_header, Service_details_Codition, actual_terminalCode);

		waitForElement(driver, Arrival_Date_Search_Btn_CAR);
		click(driver,Arrival_Date_Search_Btn_CAR);
		twoColumnSearchWindow(driver, arrival_date_header, Arrival_Date_Condition, act_ArrDate);

		Step_End(20, "Paste the Service, Vessel, Port, Terminal, Arrival date, voyage and bound informations.", test, test1);
		Step_Start(21, "Click on Show button.", test, test1);

		waitForElement(driver, Show_Button_CAR);
		click(driver,Show_Button_CAR);
		
		Step_End(21, "Click on Show button.", test, test1);
		Step_Start(22, "System shows a confirmation message as 'CAR is closed for this Carrier/Vessel/Voyage. Do you want to create a Supplementary CAR?'.", test, test1);

		waitForPopup(driver, popup_Message, "Do you want to create a Supplementary CAR?");
		Step_End(22, "System shows a confirmation message as 'CAR is closed for this Carrier/Vessel/Voyage. Do you want to create a Supplementary CAR?'.", test, test1);

		Step_Start(23, "Click on 'Yes'.", test, test1);
		
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(23, "Click on 'Yes'.", test, test1);
		Step_Start(24, "Click on the Predictable reporting tab and select the required activities.", test, test1);

		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		
		String PredictableActivity_Column=String.format(Predictable_Activity_Column_CAR, Select_Predicatble_Sub_Activity_Name);
		waitForElement(driver, PredictableActivity_Column);
		click(driver,PredictableActivity_Column);
		
		Step_End(24, "Click on the Predictable reporting tab and select the required activities.", test, test1);
		Step_Start(25, "Click on the Unpredictable reporting tab and select the required activities and enter the quantities for those activities.", test, test1);

		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver,UnPredictable_Tab_CAR);
		waitForElement(driver, UnPredictable_Table_CAR);
		
		waitForElement(driver, More_Grid_UnPredictable_CAR);
		click(driver,More_Grid_UnPredictable_CAR);
		
		waitForElement(driver, Condition_UnPredictable_CAR);
		click(driver,Condition_UnPredictable_CAR);

		
		reArrangeAG_GridColumns(driver, Table_Headers_column);
		
		waitForElement(driver, Activity_Name_CAR);
		sendKeys(driver, Activity_Name_CAR, Un_Predictable_Activate_Name);
		
		if(!EQP_Type.trim().equals("")) {
			waitForElement(driver, EqpType_Filter_input_CAR);
			Newclear(driver, EqpType_Filter_input_CAR);
			sendKeys(driver, EqpType_Filter_input_CAR, EQP_Type);
		}
		if(!EQP_Status.trim().equals("")) {
			waitForElement(driver, EqpStatus_Filter_input_CAR);
			Newclear(driver, EqpStatus_Filter_input_CAR);
			sendKeys(driver, EqpStatus_Filter_input_CAR, EQP_Status);
		}
		horizontalscroll(driver, Un_Pre_Tab_Scroll,1000);
		if(!Head_Values.trim().equals("")) {
			waitForElement(driver, Head_Filter_input_CAR);
			Newclear(driver, Head_Filter_input_CAR);
			sendKeys(driver, Head_Filter_input_CAR, Head_Values);
		}
		
		if(!Contract_Number_Values.trim().equals("")) {
			waitForElement(driver, ContractNo_Filter_Input_CAR);
			Newclear(driver, ContractNo_Filter_Input_CAR);
			sendKeys(driver, ContractNo_Filter_Input_CAR, Contract_Number_Values);
		}
		
		if(!Version_Number_Values.trim().equals("")) {
			waitForElement(driver, VersionNo_Filter_Input_CAR);
			Newclear(driver, VersionNo_Filter_Input_CAR);
			sendKeys(driver, VersionNo_Filter_Input_CAR, Version_Number_Values);
		}
		horizontalscroll(driver, Un_Pre_Tab_Scroll,-1000);
		
		mouseOverToElement(driver, Vendor_Code_Input_CAR);
		waitForElement(driver, Vendor_Code_Input_CAR);
		sendKeys(driver, Vendor_Code_Input_CAR, Un_Predictable_Vendor_Code);
		
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);

		
	
		waitForElement(driver, Quantity_Column_CAR);
		doubleClick(driver,Quantity_Column_CAR);
		
		waitForElement(driver, quantity_Input_CAR);
		sendKeys(driver, quantity_Input_CAR, Type_Quantity);
		enter(driver);
		
		Step_End(25, "Click on the Unpredictable reporting tab and select the required activities and enter the quantities for those activities.", test, test1);
		Step_Start(26, "Click on the Tool bar save button.", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_End(26, "Click on the Tool bar save button.", test, test1);
		Step_Start(27, "Check whether the system shows an information message as 'Container Activity Report Saved'.", test, test1);

		waitForPopup(driver, popup_Message, "Container Activity Report Saved");
		if(isdisplayed(driver, popup_Message)) {
			String actualPopup=getText(driver, popup_Message);
			System.out.println("actualPopup : "+actualPopup);
		}
		Step_End(27, "Check whether the system shows an information message as 'Container Activity Report Saved'.", test, test1);
		Step_Start(28, "Click on ok.", test, test1);
		
		click(driver, popup_Message_Ok_Button);

		Step_End(28, "Click on ok.", test, test1);
		
		
		Extent_completed(tc_Name, test, test1);
	}
	
	
}
