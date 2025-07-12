package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS005 extends Keywords{

	public void  Cost_Activity_Report_TS005(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS005";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		
		String CAR_Retrieve_Type1 = Excel_data.get("CAR_Retrieve_Type1");
		String CAR_Retrieve_Condition1 = Excel_data.get("CAR_Retrieve_Condition1");
		String CAR_Number_Retrieve_Value1 = Excel_data.get("CAR_Number_Retrieve_Value1");

		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		String Activity_updated_Popup = Excel_data.get("Activity_updated_Popup");

		String Table_Filter_Headers = Excel_data.get("Table_Filter_Headers");
		String Sub_Activities_Name = Excel_data.get("Sub_Activities_Name");
		String Head_Values = Excel_data.get("Head_Values");
		String Contract_Number_Values = Excel_data.get("Contract_Number_Values");
		String Version_Number_Values = Excel_data.get("Version_Number_Values");
		String Value_Amount = Excel_data.get("Value_Amount");
		String Type_Quantity = Excel_data.get("Type_Quantity");
		String Container_Variable_report_Saved_popup =Excel_data.get("Container_Variable_report_Saved_popup");

		String Equipement_Type = Excel_data.get("Equipement_Type");
		String Equipement_Status = Excel_data.get("Equipement_Status");
		
		
		
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
		
		Step_Start(3, "Retrive the CAR number using global search", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		
		waitForElement(driver, type_Select1);
		
		globalValueSearchWindow(driver,CAR_Retrieve_Condition1,CAR_Retrieve_Type1,CAR_Number_Retrieve_Value1,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		waitForElement(driver, CAR_Number_Input_CAR);
		Step_End(3, "Retrive the CAR number using global search", test, test1);
		
		Step_Start(4, "Click on the tool bar \"Edit\" button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		Step_End(4, "Click on the tool bar \"Edit\" button", test, test1);
		
		Step_Start(5, "Click on the Predictable reporting tab", test, test1);
		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		waitForElement(driver, Predictable_Table_CAR);
		Step_End(5, "Click on the Predictable reporting tab", test, test1);
		
		
		Step_Start(6, "Select any of the not reported activity in it(without pink color indication).Reported activities are highlighted with pink color", test, test1);

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
		
		
		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver,UnPredictable_Tab_CAR);
		waitForElement(driver, UnPredictable_Table_CAR);
		
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
					
					waitForPopup(driver, Popup_Message, Container_Variable_report_Saved_popup);
					String Popup_Text_Act_val=getText(driver, Popup_Message);
					
					if(Popup_Text_Act_val.equals(Container_Variable_report_Saved_popup)) {
						System.out.println("Popup Matched  ||   Expected : "+Container_Variable_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act_val);
						Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Container_Variable_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act_val, test, test1);
					}else {
						System.out.println("Popup Not Matched  ||   Expected : "+Container_Variable_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act_val);
						Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Container_Variable_report_Saved_popup+"   ||   Actual   : "+Popup_Text_Act_val, test, test1);
					}
					
				}
			}
		}
		
		Step_End(6, "Select any of the not reported activity in it(without pink color indication).Reported activities are highlighted with pink color", test, test1);		
		
		
		Step_Start(7, "Click on the tool bar save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		Step_End(7, "Click on the tool bar save button", test, test1);
		
		Step_Start(8, "Check whether the system populates the information message as \"Container Activity Report Updated\"", test, test1);
		waitForPopup(driver, popup_Message, Activity_updated_Popup);
		String Popup_Text_Act=getText(driver, popup_Message);
		
		if(Popup_Text_Act.equalsIgnoreCase(Activity_updated_Popup)) {
			System.out.println("Popup Matched  ||   Expected Popup : "+Activity_updated_Popup+"   ||   Actual Popup  : "+Popup_Text_Act);
			Extent_pass_New(driver, "Popup Matched  ||   Expected Popup : "+Activity_updated_Popup+"   ||   Actual  Popup : "+Popup_Text_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected Popup : "+Activity_updated_Popup+"   ||   Actual  Popup : "+Popup_Text_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected Popup : "+Activity_updated_Popup+"   ||   Actual Popup  : "+Popup_Text_Act, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		Step_End(8, "Check whether the system populates the information message as \"Container Activity Report Updated\"", test, test1);

		
		Step_Start(9, "Check whether the selected activity is reported or not,if it reported means it should show along with pink color indication", test, test1);
		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		waitForElement(driver, Predictable_Table_CAR);
		
		waitForElement(driver, Predicatble_More_Grid_CAR);
		click(driver,Predicatble_More_Grid_CAR);
		
		waitForElement(driver, Predicatble_ConditionFilter_CAR);
		click(driver,Predicatble_ConditionFilter_CAR);
		
		reArrangeAG_GridColumns(driver, Table_Filter_Headers);
		
		
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
				String UpdatedColumn=String.format(Updated_Activity_Row_CAR, Activity);
				waitForElement(driver, UpdatedColumn);
				String updatedColumn_value=getAttribute(driver, UpdatedColumn, "class");
				if(updatedColumn_value.contains("pink")) {
					System.out.println("Expected : Updated Acivity '"+Activity+"' Column Should be Highlight in pink color || Actual : Updated Acivity '"+Activity+"' Column Highlighted in pink color");
					Extent_pass_New(driver, "Expected : Updated Acivity '"+Activity+"' Column Should be Highlight in pink color || Actual : Updated Acivity '"+Activity+"' Column Highlighted in pink color", test, test1);
				}else {
					System.out.println("Expected : Updated Acivity '"+Activity+"' Column Should be Highlight in pink color || Actual : Updated Acivity '"+Activity+"' Column not Highlighted in pink color");
					Extent_fail(driver, "Expected : Updated Acivity '"+Activity+"' Column Should be Highlight in pink color || Actual : Updated Acivity '"+Activity+"' Column not Highlighted in pink color", test, test1);
				}
			}
		}
		
		
		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver,UnPredictable_Tab_CAR);
		waitForElement(driver, UnPredictable_Table_CAR);
		
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
			
			String UpdatedColumn=String.format(Updated_Activity_Row_CAR, Activity);
			waitForElement(driver, UpdatedColumn);
			String updatedColumn_value=getAttribute(driver, UpdatedColumn, "class");
			if(updatedColumn_value.contains("pink")) {
				System.out.println("Expected : Updated Acivity '"+Activity+"' Column Should be Highlight in pink color || Actual : Updated Acivity '"+Activity+"' Column Highlighted in pink color");
				Extent_pass_New(driver, "Expected : Updated Acivity '"+Activity+"' Column Should be Highlight in pink color || Actual : Updated Acivity '"+Activity+"' Column Highlighted in pink color", test, test1);
			}else {
				System.out.println("Expected : Updated Acivity '"+Activity+"' Column Should be Highlight in pink color || Actual : Updated Acivity '"+Activity+"' Column not Highlighted in pink color");
				Extent_fail(driver, "Expected : Updated Acivity '"+Activity+"' Column Should be Highlight in pink color || Actual : Updated Acivity '"+Activity+"' Column not Highlighted in pink color", test, test1);
			}
			
		}
		
		Step_End(9, "Check whether the selected activity is reported or not,if it reported means it should show along with pink color indication", test, test1);		
		
		Extent_completed(tc_Name, test, test1);
		
	}
}
