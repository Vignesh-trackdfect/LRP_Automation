package LRP_Cost_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS038 extends Keywords{

	public void  Cost_Activity_Report_TS038(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS038";
		
		
		
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		
		String Select_Contract_type_Value = Excel_data.get("Select_Contract_type_Value");
		String Select_Mode_type = Excel_data.get("Select_Mode_type");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Service_details_Codition = Excel_data.get("Service_details_Codition");
		String Arrival_Date_Condition = Excel_data.get("Arrival_Date_Condition");
		String Arrival_Date_Value = Excel_data.get("Arrival_Date_Value");
		
		String Predictable_table_Headers = Excel_data.get("Predictable_table_Headers");
		String Contract_table_Headers = Excel_data.get("Contract_table_Headers");
		String Service_Header = Excel_data.get("Service_Header");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String Port_Header = Excel_data.get("Port_Header");
		String Terminal_Header = Excel_data.get("Terminal_Header");
		String Arrival_Date_Header = Excel_data.get("Arrival_Date_Header");
		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		
		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		
		Step_Start(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		
		waitForElement(driver, Contract_Type_Input_CAR);
		click(driver,Contract_Type_Input_CAR);
		
		String SelectContract=String.format(Select_Contract_Type_CAR, Select_Contract_type_Value);
		waitForElement(driver, SelectContract);
		click(driver,SelectContract);
		
		waitForElement(driver, Mode_Select_Input_CAR);
		click(driver,Mode_Select_Input_CAR);
		
		String SelectModeValue=String.format(Select_Mode_type_CAR, Select_Mode_type);
		waitForElement(driver, SelectModeValue);
		click(driver,SelectModeValue);
		
		Step_Start(3, "Click on the Service search button and select the required service code. ", test, test1);
		waitForElement(driver, Service_Search_Btn_CAR);
		click(driver,Service_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Service_Header,Service_details_Codition,Service_Code);
		Step_End(3, "Click on the Service search button and select the required service code. ", test, test1);

		Step_Start(4, "Click on the Vessel search button and select the required vessel code.", test, test1);
		waitForElement(driver, Vessel_Search_Btn_CAR);
		click(driver,Vessel_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Vessel_Header,Service_details_Codition,Vessel_Code);
		Step_End(4, "Click on the Vessel search button and select the required vessel code.", test, test1);
		
		Step_Start(5, "Click on the Port search button and select the required port code.", test, test1);
		waitForElement(driver, Port_Search_Btn_CAR);
		click(driver,Port_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Port_Header,Service_details_Codition,Port_Code);
		Step_End(5, "Click on the Port search button and select the required port code.", test, test1);
		
		Step_Start(6, "Click on the Terminal search button and select the required terminal code.", test, test1);
		waitForElement(driver, Terminal_Search_Btn_CAR);
		click(driver,Terminal_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Terminal_Header,Service_details_Codition,Terminal_Code);
		Step_End(6, "Click on the Terminal search button and select the required terminal code.", test, test1);
		
		Step_Start(7, "Click on the Arrival date search button and select the required date.", test, test1);
		waitForElement(driver, Arrival_Date_Search_Btn_CAR);
		click(driver,Arrival_Date_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Arrival_Date_Header,Arrival_Date_Condition,Arrival_Date_Value);
		Step_End(7, "Click on the Arrival date search button and select the required date.", test, test1);
		
		Step_Start(8, "Click on the Show button", test, test1);
		waitForElement(driver, Show_Button_CAR);
		click(driver,Show_Button_CAR);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver,popup_Message_Yes_Button);
		}
		Step_End(8, "Click on the Show button", test, test1);
		
		
		
		Step_Start(9, "Click on the Predictable Reporting tab ", test, test1);
		List<String> Predictable_headers_List=splitAndExpand(Predictable_table_Headers);
		
		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		Step_End(9, "Click on the Predictable Reporting tab ", test, test1);
		
		Step_Start(10, "Copy the Contract No and Version No of all the predictable activities. ", test, test1);
		waitForElement(driver, Predictable_Table_CAR);
		
		waitForElement(driver, Column_SelectMenu);
		click(driver, Column_SelectMenu);
		waitForElement(driver, column_SearchBox_CAR);
		jsClick(driver, SelectAll_Column_CheckBox);
		
		for(String FilterHeader : Predictable_headers_List) {
			waitForElement(driver, column_SearchBox_CAR);
			clear(driver, column_SearchBox_CAR);
			waitForElement(driver, column_SearchBox_CAR);
			sendKeys(driver, column_SearchBox_CAR,FilterHeader);
		
			String checkbox=String.format(Select_Column_Head,FilterHeader);
			waitForElement(driver, checkbox);
			jsClick(driver, checkbox);
		}
		
		jsClick(driver, Column_SelectMenu);
		
		waitForElement(driver, Predictable_Table_CAR);
		Map<String,String> Expected_Contract_Details=new HashMap<String, String>();

		List<Map<String, String>> PredicatableReport_Table = extractTableDataByColumnWithoutScroll(driver,Predictable_Table_CAR);
		Map<String,String> Predictable_Details=getValuesByHeaderMap(PredicatableReport_Table,Predictable_headers_List.get(0),Predictable_headers_List.get(1));
		Expected_Contract_Details.putAll(Predictable_Details);
		Step_End(10, "Copy the Contract No and Version No of all the predictable activities. ", test, test1);

		Step_Start(11, "Click on the Unpredictable Reporting tab", test, test1);
		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver,UnPredictable_Tab_CAR);
		Step_End(11, "Click on the Unpredictable Reporting tab", test, test1);
		
		Step_Start(12, "Copy the Contract No and Version No of all the unpredictable activities.", test, test1);
		waitForElement(driver, UnPredictable_Table_CAR);
		
		waitForElement(driver, Column_SelectMenu);
		click(driver, Column_SelectMenu);
		waitForElement(driver, column_SearchBox_CAR);
		jsClick(driver, SelectAll_Column_CheckBox);
		if(isdisplayed(driver, UnPredict_Activity_GridCell_CAR)) {
			jsClick(driver, SelectAll_Column_CheckBox);
		}
		
		for(String FilterHeader : Predictable_headers_List) {
			waitForElement(driver, column_SearchBox_CAR);
			clear(driver, column_SearchBox_CAR);
			waitForElement(driver, column_SearchBox_CAR);
			sendKeys(driver, column_SearchBox_CAR,FilterHeader);
		
			String checkbox=String.format(Select_Column_CAR,FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}
		
		jsClick(driver, Column_SelectMenu);
		
		waitForElement(driver, UnPredictable_Table_CAR);
		
		List<Map<String, String>> UnPredicatableReport_Table = extractTableDataByColumnWithoutScroll(driver,UnPredictable_Table_CAR);
		Map<String,String> UnPredictable_Details=getValuesByHeaderMap(UnPredicatableReport_Table,Predictable_headers_List.get(0),Predictable_headers_List.get(1));
		Expected_Contract_Details.putAll(UnPredictable_Details);
		Step_End(12, "Copy the Contract No and Version No of all the unpredictable activities.", test, test1);
		
		Step_Start(13, "Click on the Contracts used option. Ensure that a new window is opened with Contract details", test, test1);
		waitForElement(driver, Contracts_Used_Btn_CAR);
		click(driver,Contracts_Used_Btn_CAR);
		
		waitForElement(driver, Contracts_Details_tab_CAR);
		Step_End(13, "Click on the Contracts used option. Ensure that a new window is opened with Contract details", test, test1);
		
		Step_Start(14, "Check whether the Copied Contract No and Version No of both predicatble and unpredictable activities matches with the Contract No and Version No shown in the opened Contract details window", test, test1);
		List<String> Contract_Headers=splitAndExpand(Contract_table_Headers);
		List<Map<String, String>> Contract_Table=getTableData(driver, Contract_Details_Table_Head_CAR, Contract_Details_Table_Row_CAR);
		Map<String,String> ContractTable_Details=getValuesByHeaderMap(Contract_Table,Contract_Headers.get(0),Contract_Headers.get(1));
		
		if(containsAllMaps(Expected_Contract_Details,ContractTable_Details)) {
			System.out.println("Contact Details Matched in Grid ||  Exp : "+Expected_Contract_Details+"    ||   Act : "+ContractTable_Details);
			Extent_pass_New(driver, "Contact Details Matched in Grid ||  Exp : "+Expected_Contract_Details+"    ||   Act : "+ContractTable_Details, test, test1);
		}else {
			System.out.println("Contact Details Not Matched in Grid ||  Exp : "+Expected_Contract_Details+"    ||   Act : "+ContractTable_Details);
			Extent_fail(driver, "Contact Details Not Matched in Grid ||  Exp : "+Expected_Contract_Details+"    ||   Act : "+ContractTable_Details, test, test1);
		}
		Step_End(14, "Check whether the Copied Contract No and Version No of both predicatble and unpredictable activities matches with the Contract No and Version No shown in the opened Contract details window", test, test1);

		Step_Start(15, ".Click on ok option.    ", test, test1);
		waitForElement(driver, Contract_Details_Ok_Btn_CAR);
		click(driver,Contract_Details_Ok_Btn_CAR);
		Step_End(15, ".Click on ok option.    ", test, test1);
		
		Extent_completed(tc_Name, test, test1);
	}
	
}
