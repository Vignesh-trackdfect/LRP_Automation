package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS001 extends Keywords {
	
	public void  Cost_Activity_Report_TS001(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS001";
		
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
		String Arrival_Date_Value = Excel_data.get("Arrival_Date_Value");
		String Container_Activity_report_Saved_popup = Excel_data.get("Container_Activity_report_Saved_popup");
		String Container_Variable_report_Saved_popup =Excel_data.get("Container_Variable_report_Saved_popup");
		
		String Service_Header = Excel_data.get("Service_Header");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String Port_Header = Excel_data.get("Port_Header");
		String Terminal_Header = Excel_data.get("Terminal_Header");
		String Arrival_Date_Header = Excel_data.get("Arrival_Date_Header");
		
		String CAR_Already_Created = Excel_data.get("CAR_Already_Created");

		String Table_Filter_Headers = Excel_data.get("Table_Filter_Headers");
		String Sub_Activities_Name = Excel_data.get("Sub_Activities_Name");
		String Head_Values = Excel_data.get("Head_Values");
		String Contract_Number_Values = Excel_data.get("Contract_Number_Values");
		String Version_Number_Values = Excel_data.get("Version_Number_Values");
		String Value_Amount = Excel_data.get("Value_Amount");
		String Type_Quantity = Excel_data.get("Type_Quantity");

		String Equipement_Type = Excel_data.get("Equipement_Type");
		String Equipement_Status = Excel_data.get("Equipement_Status");
		String Delete_CAR = Excel_data.get("Delete_CAR");
		
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
		
		twoColumnSearchWindow(driver,Arrival_Date_Header,Service_details_Codition,Arrival_Date_Value);

		Step_End(7, "Click on the Arrival date search button and select the required date. ", test, test1);
		
		Step_Start(8, "Click on the Show button. ", test, test1);
		waitForElement(driver, Show_Button_CAR);
		click(driver,Show_Button_CAR);
		Step_End(8, "Click on the Show button. ", test, test1);
		
		if(isdisplayed(driver, popup_Message)) {
			String popup_Act=getText(driver, popup_Message);
			if(CAR_Already_Created.equals(popup_Act)) {
				System.out.println("Expected : CAR should not Already Created for the given inputs || Actual : CAR Already created for the given inputs");
				Extent_FailNew(driver, "Expected : CAR should not Already Created for the given inputs || Actual : CAR Already created for the given inputs", test, test1);
			}else {
				System.out.println("Expected : Popup Should not Displayed when click the CAR Show button || Actual : Popup displayed When click the CAR Show button , Error : "+popup_Act );
				Extent_fail(driver, "Expected : Popup Should not Displayed when click the CAR Show button || Actual : Popup displayed When click the CAR Show button , Error : "+popup_Act , test, test1);
			}
		}

		
		Step_Start(9, "Click on the Predictable Reporting tab ", test, test1);
		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		waitForElement(driver, Predictable_Table_CAR);

		Step_End(9, "Click on the Predictable Reporting tab ", test, test1);
		
		Step_Start(10, "Select the required activities in the grid by using the check box selection", test, test1);
		
		waitForElement(driver, Predicatble_More_Grid_CAR);
		click(driver,Predicatble_More_Grid_CAR);
		
		waitForElement(driver, Predicatble_ConditionFilter_CAR);
		click(driver,Predicatble_ConditionFilter_CAR);
		
		reArrangeAG_GridColumns(driver, Table_Filter_Headers);
		
		
		List<String> Table_Activities_Values=splitAndExpand(Sub_Activities_Name);
		List<String> Un_Predictable_Activities=splitAndExpand(Sub_Activities_Name);
		
		List<String> Activity_Head_Values=splitAndExpand(Head_Values);
		List<String> Contract_Numbers=splitAndExpand(Contract_Number_Values);
		List<String> Version_Numbers=splitAndExpand(Version_Number_Values);
		List<String> Amount_List_values=splitAndExpand(Value_Amount);
		List<String> Quantity_Lists=splitAndExpand(Type_Quantity);
		
		List<String> EquipmentTypeList=splitAndExpand(Equipement_Type);
		List<String> EquipmentStatusList=splitAndExpand(Equipement_Status);		
		
		for(int i=0;i<Table_Activities_Values.size();i++) {
			String Activity=Table_Activities_Values.get(i);
			String Head =Activity_Head_Values.get(i);
			String Contract_Num =Contract_Numbers.get(i);
			String Version_Num =Version_Numbers.get(i);
			String Quantity =Quantity_Lists.get(i);
			String EqpType=EquipmentTypeList.get(i);
			String EqpStatus=EquipmentStatusList.get(i);

			waitForElement(driver, Activity_Name_CAR);
			Newclear(driver, Activity_Name_CAR);
			sendKeys(driver, Activity_Name_CAR, Activity);
			
			if(!Head.trim().equals("")) {
				waitForElement(driver, Head_Filter_input_CAR);
				Newclear(driver, Head_Filter_input_CAR);
				sendKeys(driver, Head_Filter_input_CAR, Head);
			}
			
			if(!Contract_Num.trim().equals("")) {
				waitForElement(driver, ContractNo_Filter_Input_CAR);
				Newclear(driver, ContractNo_Filter_Input_CAR);
				sendKeys(driver, ContractNo_Filter_Input_CAR, Contract_Num);
			}
			
			if(!Version_Num.trim().equals("")) {
				waitForElement(driver, VersionNo_Filter_Input_CAR);
				Newclear(driver, VersionNo_Filter_Input_CAR);
				sendKeys(driver, VersionNo_Filter_Input_CAR, Version_Num);
			}
			
			if(!EqpType.trim().equals("")) {
				waitForElement(driver, EqpType_Filter_input_CAR);
				Newclear(driver, EqpType_Filter_input_CAR);
				sendKeys(driver, EqpType_Filter_input_CAR, EqpType);
			}
			
			
			if(!EqpStatus.trim().equals("")) {
				waitForElement(driver, EqpStatus_Filter_input_CAR);
				Newclear(driver, EqpStatus_Filter_input_CAR);
				sendKeys(driver, EqpStatus_Filter_input_CAR, EqpStatus);
			}
			
			String ActivityColumn_Predictable=String.format(Predictable_Activity_Column_CAR, Activity);
			if(isdisplayed(driver, ActivityColumn_Predictable)) {
				Un_Predictable_Activities.remove(Activity);
				click(driver,ActivityColumn_Predictable);
				formatLocatorClick(driver, Quantity_Column_Predicatble, Activity);
				formatLocatorDoubleClick(driver, Quantity_Column_Predicatble, Activity);
				formatLocatorSendKeys(driver, Quantity_Input_Predictable, Activity, Quantity);
				
				waitForElement(driver, ActivityColumn_Predictable);
				click(driver,ActivityColumn_Predictable);
				
			}
		}
		
		Step_End(10, "Select the required activities in the grid by using the check box selection", test, test1);
		
		Step_Start(11, "Click on the Unpredictable Reporting tab", test, test1);
		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver,UnPredictable_Tab_CAR);
		waitForElement(driver, UnPredictable_Table_CAR);
		Step_End(11, "Click on the Unpredictable Reporting tab", test, test1);
		
		Step_Start(12, "Select the required data in the grid by using the check box selection", test, test1);
		waitForElement(driver, More_Grid_UnPredictable_CAR);
		click(driver,More_Grid_UnPredictable_CAR);
		
		waitForElement(driver, Condition_UnPredictable_CAR);
		click(driver,Condition_UnPredictable_CAR);
		reArrangeAG_GridColumns(driver, Table_Filter_Headers);

		for(int i=0;i<Table_Activities_Values.size();i++) {
			
			String Activity=Table_Activities_Values.get(i);//
			if(!Un_Predictable_Activities.contains(Activity)) {
				continue;
			}
			String Head =Activity_Head_Values.get(i);
			String Contract_Num =Contract_Numbers.get(i);
			String Version_Num =Version_Numbers.get(i);
			String Amount =Amount_List_values.get(i);
			String Quantity =Quantity_Lists.get(i);

			String EqpType=EquipmentTypeList.get(i);
			String EqpStatus=EquipmentStatusList.get(i);
			
			waitForElement(driver, Activity_Name_CAR);
			Newclear(driver, Activity_Name_CAR);
			sendKeys(driver, Activity_Name_CAR, Activity);
			
			if(!Head.trim().equals("")) {
				waitForElement(driver, Head_Filter_input_CAR);
				Newclear(driver, Head_Filter_input_CAR);
				sendKeys(driver, Head_Filter_input_CAR, Head);
			}
			
			if(!Contract_Num.trim().equals("")) {
				waitForElement(driver, ContractNo_Filter_Input_CAR);
				Newclear(driver, ContractNo_Filter_Input_CAR);
				sendKeys(driver, ContractNo_Filter_Input_CAR, Contract_Num);
			}
			
			if(!Version_Num.trim().equals("")) {
				waitForElement(driver, VersionNo_Filter_Input_CAR);
				Newclear(driver, VersionNo_Filter_Input_CAR);
				sendKeys(driver, VersionNo_Filter_Input_CAR, Version_Num);
			}
						
			if(!EqpType.trim().equals("")) {
				waitForElement(driver, EqpType_Filter_input_CAR);
				Newclear(driver, EqpType_Filter_input_CAR);
				sendKeys(driver, EqpType_Filter_input_CAR, EqpType);
			}
			
			
			if(!EqpStatus.trim().equals("")) {
				waitForElement(driver, EqpStatus_Filter_input_CAR);
				Newclear(driver, EqpStatus_Filter_input_CAR);
				sendKeys(driver, EqpStatus_Filter_input_CAR, EqpStatus);
			}
			
			String ActivityColumn_Predictable=String.format(Predictable_Activity_Column_CAR, Activity);
			waitForElement(driver, ActivityColumn_Predictable);
			String SelectColumn_UnPredictable=String.format(Select_Table_Row_CAR, Activity);
			waitForDisplay(driver, SelectColumn_UnPredictable);
			jsClick(driver, SelectColumn_UnPredictable);
			
			Step_Start(13, "After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and check whether the activity has any variables in formula column", test, test1);

			waitForElement(driver, Quantity_Column_CAR);
			doubleClick(driver,Quantity_Column_CAR);
			waitForElement(driver, quantity_Input_CAR);
			Newclear(driver, quantity_Input_CAR);
			sendKeys(driver, quantity_Input_CAR, Quantity);
			waitForElement(driver, ActivityColumn_Predictable);
			click(driver,ActivityColumn_Predictable);
			
			Step_End(13, "After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and check whether the activity has any variables in formula column", test, test1);

			waitForElement(driver, Formula_Column_CAR);
			String Formula_Value=getText(driver, Formula_Column_CAR);
			
			if(!Formula_Value.equals("")) {
				waitForDisplay(driver, IsPredictable_Check_CAR);
				String predictableCheck=getAttribute1(driver, IsPredictable_Check_CAR, "aria-label");
				if(!predictableCheck.equals("checked")) {
					
					waitForElement(driver, Value_Input_Column_CAR);
					click(driver, Value_Input_Column_CAR);
					Newclear(driver,Value_Input_CAR);
					sendKeys(driver, Value_Input_CAR, Amount);
					
					waitForElement(driver, Quantity_Column_CAR);
					click(driver,Quantity_Column_CAR);
					
					waitForElement(driver, Apply_Button_CAR);
					click(driver, Apply_Button_CAR);
					
					Step_Start(16, "Check whether the system populates a information message as variable(s) applied selected record", test, test1);	
					
					waitForPopup(driver, Popup_Message, Container_Variable_report_Saved_popup);
					String Popup_Text_Act_val=getText(driver, Popup_Message);
					
					if(Popup_Text_Act_val.equals(Container_Variable_report_Saved_popup)) {
						System.out.println("Popup Matched  ||   Expected : "+Container_Variable_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act_val);
						Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Container_Variable_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act_val, test, test1);
					}else {
						System.out.println("Popup Not Matched  ||   Expected : "+Container_Variable_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act_val);
						Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Container_Variable_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act_val, test, test1);
					}
					
					Step_End(16, "Check whether the system populates a information message as variable(s) applied selected record", test, test1);	
				}
			}
		}
		
	
		Step_End(12, "Select the required data in the grid by using the check box selection", test, test1);
		Step_Start(17, ".Click on the tool bar save button and check whether the system shows the information message as Container Activity Report Saved", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Container_Activity_report_Saved_popup);
		String Popup_Text_Act=getText(driver, popup_Message);
		
		if(Popup_Text_Act.equals(Container_Activity_report_Saved_popup)) {
			System.out.println("Popup Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act);
			Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Container_Activity_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(17, ".Click on the tool bar save button and check whether the system shows the information message as Container Activity Report Saved", test, test1);
		
		if(Delete_CAR.equalsIgnoreCase("Yes")) {
			scrollTop(driver);
			waitForElement(driver, Delete_button_toolBar);
			click(driver,Delete_button_toolBar);
			
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver,popup_Message_Yes_Button);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
		}
		
		
		Extent_completed(tc_Name, test, test1);	
		

}
}