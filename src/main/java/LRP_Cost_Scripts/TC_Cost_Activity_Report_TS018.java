package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS018 extends Keywords{

	public void  Cost_Activity_Report_TS018(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS018";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		
		String AgencyUser = Excel_data.get("AgencyUser");
		String Select_Contract_type_Value = Excel_data.get("Select_Contract_type_Value");
		String Select_Mode_type = Excel_data.get("Select_Mode_type");
		
		String Service_Header = Excel_data.get("Service_Header");
		String Service_Code = Excel_data.get("Service_Code");
		
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		
		String Port_Header = Excel_data.get("Port_Header");
		String Port_Code = Excel_data.get("Port_Code");
		
		String Terminal_Header = Excel_data.get("Terminal_Header");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		
		String Service_details_Codition = Excel_data.get("Service_details_Codition");
		
		String Arrival_Date_Header = Excel_data.get("Arrival_Date_Header");
		String Arrival_Date_Condition = Excel_data.get("Arrival_Date_Condition");
		String Arrival_Date_Value = Excel_data.get("Arrival_Date_Value");
		
		String Head_Name_Table = Excel_data.get("Head_Name_Table");
		String Predictable_Table_Headers = Excel_data.get("Predictable_Table_Headers");

		String Predictable_Activity_Module = Excel_data.get("Predictable_Activity_Module");
		String Predictable_Select_Type = Excel_data.get("Predictable_Select_Type");
		String Predictable_Select_Codition = Excel_data.get("Predictable_Select_Codition");
		String Head_Name_Activity_table = Excel_data.get("Head_Name_Activity_table");

		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		
		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		
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
		
		Step_Start(3, "Click on the Service search button and select the required service code.", test, test1);
		waitForElement(driver, Service_Search_Btn_CAR);
		click(driver,Service_Search_Btn_CAR);
		
		twoColumnSearchWindow(driver,Service_Header,Service_details_Codition,Service_Code);
		Step_End(3, "Click on the Service search button and select the required service code.", test, test1);
		
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
		
		Step_Start(7, "Click on the Arrival date search button and select the required date. ", test, test1);
		waitForElement(driver, Arrival_Date_Search_Btn_CAR);
		click(driver,Arrival_Date_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Arrival_Date_Header,Arrival_Date_Condition,Arrival_Date_Value);
		Step_End(7, "Click on the Arrival date search button and select the required date. ", test, test1);
		
		Step_Start(8, "Click on the Show button. ", test, test1);
		waitForElement(driver, Show_Button_CAR);
		click(driver,Show_Button_CAR);
		
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver,popup_Message_Yes_Button);
		}
		Step_End(8, "Click on the Show button. ", test, test1);
		
		Step_Start(9, "Click on the Predictable Reporting tab ", test, test1);
		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		waitForElement(driver, Predictable_Table_CAR);

		Step_End(9, "Click on the Predictable Reporting tab ", test, test1);
		
		Step_Start(10, "Copy the Head which is available in the AG Grid from Head column. ", test, test1);
	
		reArrangeAG_GridColumns(driver, Predictable_Table_Headers);
		
//		waitForElement(driver, Column_SelectMenu);
//		click(driver, Column_SelectMenu);
//		waitForElement(driver, column_SearchBox_CAR);
//		jsClick(driver, SelectAll_Column_CheckBox);
//		
//		List<String> predictable_Headers=splitAndExpand(Predictable_Table_Headers);
//		for(String FilterHeader : predictable_Headers) {
//			waitForElement(driver, column_SearchBox_CAR);
//			clear(driver, column_SearchBox_CAR);
//			waitForElement(driver, column_SearchBox_CAR);
//			sendKeys(driver, column_SearchBox_CAR,FilterHeader);
//		
//			String checkbox=String.format(Select_Column_tableHead,FilterHeader);
//			waitForElement(driver, checkbox);
//			jsClick(driver, checkbox);
//		}
//		
//		jsClick(driver, Column_SelectMenu);
		
		waitForElement(driver, Predictable_Table_CAR);
		
		List<Map<String, String>> PredicatableReport_Table = extractTableDataByColumnWithoutScroll(driver,Predictable_Table_CAR);
		
		List<String>  GetHead_Values_Predictable=getValuesByHeader(PredicatableReport_Table,Head_Name_Table);
		
		GetHead_Values_Predictable=removeDuplicates(GetHead_Values_Predictable);
		Step_End(10, "Copy the Head which is available in the AG Grid from Head column. ", test, test1);
		
		Step_Start(11, ".Click on the Contract Used button. ", test, test1);
		waitForElement(driver, Contracts_Used_Btn_CAR);
		click(driver,Contracts_Used_Btn_CAR);
		Step_End(11, ".Click on the Contract Used button. ", test, test1);
		
		Step_Start(12, "System opens a new tab,copy the Activity Behaviour Template ID from that tab.", test, test1);
		waitForElement(driver, Contracts_Details_tab_CAR);
		waitForElement(driver, Activity_Behaviour_ID_CAR);
		String Activity_ID_Full=getText(driver, Activity_Behaviour_ID_CAR);
		
		List<String>  Activity_ID_Split=splitAndExpand(Activity_ID_Full, ":");
		String Activity_ID_CAR=Activity_ID_Split.get(1);
		Step_End(12, "System opens a new tab,copy the Activity Behaviour Template ID from that tab.", test, test1);
		
		Step_Start(13, ".Click on ok.", test, test1);
		waitForElement(driver, Contract_Details_Ok_Btn_CAR);
		click(driver,Contract_Details_Ok_Btn_CAR);
		Step_End(13, ".Click on ok.", test, test1);
		
		Step_Start(14, "Enter the screen name as 'Predictable Activity Behaviour' in module search field.", test, test1);
		moduleNavigate(driver, Predictable_Activity_Module);
		Step_End(14, "Enter the screen name as 'Predictable Activity Behaviour' in module search field.", test, test1);
		
		Step_Start(15, "Click on the global search button", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(15, "Click on the global search button", test, test1);
		
		Step_Start(16, "System opens a new window and paste the Template No. in the Template No. field.", test, test1);
		Step_Start(17, "Click on the search button.", test, test1);
		Step_Start(18, "Select the respective template No. which we have copied.", test, test1);
		Step_Start(19, "Click on the select button.", test, test1);

		globalValueSearchWindow(driver,Predictable_Select_Codition,Predictable_Select_Type,Activity_ID_CAR,"","","","");
		
		Step_End(19, "Click on the select button.", test, test1);
		Step_End(18, "Select the respective template No. which we have copied.", test, test1);
		Step_End(17, "Click on the search button.", test, test1);
		Step_End(16, "System opens a new window and paste the Template No. in the Template No. field.", test, test1);
		
		Step_Start(20, "Click on the AG grid condition filter option and search the copied Head from the CAR in the Head column", test, test1);
		waitForElement(driver, Predictable_Activity_Table_PAB);
		List<Map<String, String>> PredicatableActivity_Table = extractTableDataByColumnWithoutScroll(driver,Predictable_Activity_Table_PAB);
		List<String>  GetHead_Values_Activity=getValuesByHeader(PredicatableActivity_Table,Head_Name_Activity_table);
		Step_End(20, "Click on the AG grid condition filter option and search the copied Head from the CAR in the Head column", test, test1);

		Step_Start(21, "Our copied Head should be avialable in the Predictable activity behaviour screen.", test, test1);
		if(containsAllValues(GetHead_Values_Predictable,GetHead_Values_Activity)) {
			System.out.println("Predicatble Head Values Matched ||   Expected  : "+GetHead_Values_Predictable+"   ||   Actual   : "+GetHead_Values_Activity);
			Extent_pass_New(driver, "Predicatble Head Values Matched ||   Expected  : "+GetHead_Values_Predictable+"   ||   Actual   : "+GetHead_Values_Activity, test, test1);
		}else {
			System.out.println("Predicatble Head Values Not Matched ||   Expected  : "+GetHead_Values_Predictable+"   ||   Actual   : "+GetHead_Values_Activity);
			Extent_fail(driver, "Predicatble Head Values Not Matched ||   Expected  : "+GetHead_Values_Predictable+"   ||   Actual   : "+GetHead_Values_Activity, test, test1);
		}		
		
		Step_End(21, "Our copied Head should be avialable in the Predictable activity behaviour screen.", test, test1);
		
		Extent_completed(tc_Name, test, test1);
		
		
	}
	
}
