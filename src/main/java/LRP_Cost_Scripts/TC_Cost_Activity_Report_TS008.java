package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS008 extends Keywords {

	public void Cost_Activity_Report_TS008(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS008";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String GivenContract_Type = Excel_data.get("GivenContract_Type");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal");
		String Arrival_Date = Excel_data.get("Arrival_Date");
		String Condition1 = Excel_data.get("Condition1");
		String GivenMode = Excel_data.get("GivenMode");
		String Save_Popup = Excel_data.get("Save_Popup");
		String Apply_Variable_popup = Excel_data.get("Apply_Variable_popup");
		String Service_Filter_Header = Excel_data.get("Service_Filter_Header");
		String Vessel_Filter_Header = Excel_data.get("Vessel_Filter_Header");
		String Port_Filter_Header = Excel_data.get("Port_Filter_Header");
		String Terminal_Filter_Header = Excel_data.get("Terminal_Filter_Header");
		String ArrivalDate_Filter_Header = Excel_data.get("ArrivalDate_Filter_Header");
		String Agency = Excel_data.get("Agency");

		String Table_Filter_Headers = Excel_data.get("Table_Filter_Headers");
		String Sub_Activities_Name = Excel_data.get("Sub_Activities_Name");
		String Head_Values = Excel_data.get("Head_Values");
		String Contract_Number_Values = Excel_data.get("Contract_Number_Values");
		String Version_Number_Values = Excel_data.get("Version_Number_Values");
		String Value_Amount = Excel_data.get("Value_Amount");
		String Type_Quantity = Excel_data.get("Type_Quantity");
		String CAR_Already_Created = Excel_data.get("CAR_Already_Created");

		String Contract_option = String.format(Select_ContractType, GivenContract_Type);
		String Mode_option = String.format(Select_ModeOption, GivenMode);
	
		String Equipement_Type = Excel_data.get("Equipement_Type");
		String Equipement_Status = Excel_data.get("Equipement_Status");
		String Delete_CAR = Excel_data.get("Delete_CAR");
		
		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, Agency);

		verifyMainMenu(driver);

		Step_End(1,
				"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);
		Step_Start(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		Step_Start(3, "Click on the Service search button and select the required service code", test, test1);

		waitForElement(driver, Contract_type);
		click(driver, Contract_type);

		waitForElement(driver, Contract_option);
		click(driver, Contract_option);

		waitForElement(driver, Select_Mode);
		click(driver, Select_Mode);

		waitForElement(driver, Mode_option);
		click(driver, Mode_option);

		waitForElement(driver, Service_Search);
		click(driver, Service_Search);

		twoColumnSearchWindow(driver, Service_Filter_Header, Condition1, Service);

		Step_End(3, "Click on the Service search button and select the required service code", test, test1);

		Step_Start(4, "Click on the Vessel search button and select the required vessel code", test, test1);

		waitForElement(driver, Vessel_Search);
		click(driver, Vessel_Search);

		twoColumnSearchWindow(driver, Vessel_Filter_Header, Condition1, Vessel);

		Step_End(4, "Click on the Vessel search button and select the required vessel code", test, test1);

		Step_Start(5, "Click on the Port search button and select the required port code", test, test1);

		waitForElement(driver, port_Search);
		click(driver, port_Search);

		twoColumnSearchWindow(driver, Port_Filter_Header, Condition1, Port);

		Step_End(5, "Click on the Port search button and select the required port code", test, test1);

		Step_Start(6, "Click on the Terminal search button and select the required terminal code", test, test1);

		waitForElement(driver, CAR_Terminal_Search);
		click(driver, CAR_Terminal_Search);

		twoColumnSearchWindow(driver, Terminal_Filter_Header, Condition1, Terminal);

		Step_End(6, "Click on the Terminal search button and select the required terminal code", test, test1);

		Step_Start(7, "Click on the Arrival date search button and select the required date", test, test1);

		waitForElement(driver, ArrivalDate_Search);
		click(driver, ArrivalDate_Search);

		twoColumnSearchWindow(driver, ArrivalDate_Filter_Header, Condition1, Arrival_Date);

		Step_End(7, "Click on the Arrival date search button and select the required date", test, test1);

		Step_Start(8, "Click on the Show button", test, test1);

		waitForElement(driver, Show_Button_CAR);
		click(driver, Show_Button_CAR);

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

		Step_End(8, "Click on the Show button", test, test1);

		Step_Start(9, "Click on the Predictable Reporting tab", test, test1);

		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		waitForElement(driver, Predictable_Table_CAR);
		
		Step_End(9, "Click on the Predictable Reporting tab", test, test1);

		Step_Start(10, "Select the required data in the grid by using the check box selection", test, test1);

		waitForElement(driver, MoreOption_Grid);
		click(driver,MoreOption_Grid);
		
		waitForElement(driver, FilterOption_Menu);
		click(driver,FilterOption_Menu);
		
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
				waitForElement(driver, ActivityColumn_Predictable);
				click(driver,ActivityColumn_Predictable);
			}
		}
		Step_End(10, "Select the required data in the grid by using the check box selection", test, test1);

		Step_Start(11,
				"After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and check whether the activity has any variables in formula colomn",
				test, test1);

		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver,UnPredictable_Tab_CAR);
		waitForElement(driver, UnPredictable_Table_CAR);
		
		reArrangeAG_GridColumns(driver, Table_Filter_Headers);

		waitForElement(driver, More_Grid_UnPredictable_CAR);
		click(driver,More_Grid_UnPredictable_CAR);
		
		waitForElement(driver, Condition_UnPredictable_CAR);
		click(driver,Condition_UnPredictable_CAR);
		
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
			
			waitForElement(driver, Quantity_Column_CAR);
			doubleClick(driver,Quantity_Column_CAR);
			waitForElement(driver, quantity_Input_CAR);
			Newclear(driver, quantity_Input_CAR);
			sendKeys(driver, quantity_Input_CAR, Quantity);
			waitForElement(driver, ActivityColumn_Predictable);
			click(driver,ActivityColumn_Predictable);
			
			waitForElement(driver, Formula_Column_CAR);
			String Formula_Value=getText(driver, Formula_Column_CAR);
			
			if(!Formula_Value.equals("")) {
				Step_Start(13,
						".Incase,if the selected activity contains any formula along with the To be reported(Formula) checkbox selection false means,we have to input the required variable values in the value field and click the simulator option. An information message will be displayed as \"The result for Sample Values along with simulator value\" and click ok option",
						test, test1);
				waitForDisplay(driver, IsPredictable_Check_CAR);
				String predictableCheck=getAttribute1(driver, IsPredictable_Check_CAR, "aria-label");
				if(!predictableCheck.equals("checked")) {
					
					Step_Start(14,
							"Incase,if the selected activity contains a formula means,input the required variable values and click on the apply variable bttton",
							test, test1);
					waitForElement(driver, Value_Input_Column_CAR);
					doubleClick(driver, Value_Input_Column_CAR);
					Newclear(driver, Value_Input_CAR);
					sendKeys(driver, Value_Input_CAR, Amount);
					click(driver,ActivityColumn_Predictable);
					waitForElement(driver, Apply_Button_CAR);
					click(driver, Apply_Button_CAR);
					Step_End(14,
							"Incase,if the selected activity contains a formula means,input the required variable values and click on the apply variable bttton",
							test, test1);
					
					Step_Start(15,
							"Check whether the system populates a information message as \"variable(s) applied selected record\"y",
							test, test1);
					String Popup_Text_Act_val=getText(driver, Popup_Message);
					
					if(Popup_Text_Act_val.equals(Apply_Variable_popup)) {
						System.out.println("Popup Matched  ||   Expected : "+Apply_Variable_popup+"   ||   Actual   : "+Popup_Text_Act_val);
						Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Apply_Variable_popup+"   ||   Actual   : "+Popup_Text_Act_val, test, test1);
					}else {
						System.out.println("Popup Not Matched  ||   Expected : "+Apply_Variable_popup+"   ||   Actual   : "+Popup_Text_Act_val);
						Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Apply_Variable_popup+"   ||   Actual   : "+Popup_Text_Act_val, test, test1);
					}
					Step_End(15,
							"Check whether the system populates a information message as \"variable(s) applied selected record\"y",
							test, test1);
				}
				
				Step_End(13,
						".Incase,if the selected activity contains any formula along with the To be reported(Formula) checkbox selection false means,we have to input the required variable values in the value field and click the simulator option. An information message will be displayed as \"The result for Sample Values along with simulator value\" and click ok option",
						test, test1);
			}
		}
		
		Step_Start(16,
				"Click on the tool bar save button and check whether the system shows the information message as \"Container Activity Report Saved\"",
				test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Save_Popup);
		String Popup_Text_Act=getText(driver, popup_Message);
		
		if(Popup_Text_Act.equals(Save_Popup)) {
			System.out.println("Popup Matched  ||   Expected : "+Save_Popup+"   ||   Actual   : "+Popup_Text_Act);
			Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Save_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected : "+Save_Popup+"   ||   Actual   : "+Popup_Text_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Save_Popup+"   ||   Actual   : "+Popup_Text_Act, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(16,
				"Click on the tool bar save button and check whether the system shows the information message as \"Container Activity Report Saved\"",
				test, test1);

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
