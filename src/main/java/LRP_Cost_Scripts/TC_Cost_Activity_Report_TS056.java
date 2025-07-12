package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS056 extends Keywords {

	public void Cost_Activity_Report_TS056(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS056";
	
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String CAR_Retrieve_Type1 = Excel_data.get("CAR_Retrieve_Type1");
		String CAR_Retrieve_Condition1 = Excel_data.get("CAR_Retrieve_Condition1");
		String CAR_Number_Retrieve_Value1 = Excel_data.get("CAR_Number_Retrieve_Value1");
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		String Table_Headers_column = Excel_data.get("Table_Headers_column");
		String MainActivity_Names = Excel_data.get("MainActivity_Names");
		String Contract_Number_Values = Excel_data.get("Contract_Number_Values");
		String Head_Values = Excel_data.get("Head_Values");
		String Version_Number_Values = Excel_data.get("Version_Number_Values");
		String Type_Quantity = Excel_data.get("Type_Quantity");
		String Activity_Report_Updated = Excel_data.get("Activity_Report_Updated");
		String EQP_Type = Excel_data.get("EQP_Type");
		String EQP_Status = Excel_data.get("EQP_Status");
		String Amount_Value = Excel_data.get("Amount_Value");
		String Apply_Variable_popup = Excel_data.get("Apply_Variable_popup");		

		Extent_Start(tc_Name, test, test1);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select the required agency.",test, test1);

		navigateUrl(driver, url);

		Step_End(1, "Once login to the application and click on switch profile option and select the required agency",test, test1);

		Step_Start(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		LRP_Login(driver, username, password);

		SwitchProfile(driver, AgencyUser);

		Step_End(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		verifyMainMenu(driver);

		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		waitForElement(driver, seach_Filed);
		click(driver, seach_Filed);

		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);

		Step_Start(4, "Check whether it opens a new search window. ", test, test1);

		
		Step_Start(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_Start(6, "Then click on the search button", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button", test, test1);
		
		globalValueSearchWindow(driver,CAR_Retrieve_Condition1,CAR_Retrieve_Type1,CAR_Number_Retrieve_Value1,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);
		
		Step_End(4, "Check whether it opens a new search window. ", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field. ", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		Step_End(7, "System will show the CAR No. and Click on the select button", test, test1);
		Step_Start(8, "System will retrieve the CAR", test, test1);

		waitForElement(driver, car_Number_val);
		String Carvalue = getAttribute(driver, car_Number_val, "value");

		System.out.println("Carvalue :" + Carvalue);

		Step_End(8, "System will retrieve the CAR", test, test1);

		Step_Start(9, "Click on the edit option", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		waitForElement(driver, Predictable_Table_CAR);
		
		waitForElement(driver, Predicatble_More_Grid_CAR);
		click(driver,Predicatble_More_Grid_CAR);
		
		waitForElement(driver, Predicatble_ConditionFilter_CAR);
		click(driver,Predicatble_ConditionFilter_CAR);
	
		reArrangeAG_GridColumns(driver, Table_Headers_column);
		
		Step_End(9, "Click on the edit option", test, test1);

		List<String> Table_Activities_Values=splitAndExpand(MainActivity_Names);
		List<String> Un_Predictable_Activities=splitAndExpand(MainActivity_Names);
		
		List<String> Activity_Head_Values=splitAndExpand(Head_Values);
		List<String> Contract_Numbers=splitAndExpand(Contract_Number_Values);
		List<String> Version_Numbers=splitAndExpand(Version_Number_Values);
		List<String> Quantity_Lists=splitAndExpand(Type_Quantity);
		
		List<String> Equipement_Types=splitAndExpand(EQP_Type);
		List<String> Equipement_Status=splitAndExpand(EQP_Status);
		
		for(int i=0;i<Table_Activities_Values.size();i++) {
			String Activity=Table_Activities_Values.get(i);
			String Head =Activity_Head_Values.get(i);
			String Contract_Num =Contract_Numbers.get(i);
			String Version_Num =Version_Numbers.get(i);
			String Quantity =Quantity_Lists.get(i);

			String EquipementType=Equipement_Types.get(i);
			String EquipementStatus=Equipement_Status.get(i);

			
			waitForElement(driver, Activity_Name_CAR);
			Newclear(driver, Activity_Name_CAR);
			sendKeys(driver, Activity_Name_CAR, Activity);
			
			if(!EquipementType.trim().equals("")) {
				waitForElement(driver, EqpType_Filter_input_CAR);
				Newclear(driver, EqpType_Filter_input_CAR);
				sendKeys(driver, EqpType_Filter_input_CAR, EquipementType);
			}
			if(!EquipementStatus.trim().equals("")) {
				waitForElement(driver, EqpStatus_Filter_input_CAR);
				Newclear(driver, EqpStatus_Filter_input_CAR);
				sendKeys(driver, EqpStatus_Filter_input_CAR, EquipementStatus);
			}
			
			if(!Head.trim().equals("")) {
				waitForElement(driver, Head_Filter_input_CAR);
				Newclear(driver, Head_Filter_input_CAR);
				sendKeys(driver, Head_Filter_input_CAR, Head);
			}
			
			if(!Contract_Num.trim().equals("")&&isdisplayed(driver, ContractNo_Filter_Input_CAR)) {
				waitForElement(driver, ContractNo_Filter_Input_CAR);
				Newclear(driver, ContractNo_Filter_Input_CAR);
				sendKeys(driver, ContractNo_Filter_Input_CAR, Contract_Num);
			}
			
			if(!Version_Num.trim().equals("")&&isdisplayed(driver, VersionNo_Filter_Input_CAR)) {
				waitForElement(driver, VersionNo_Filter_Input_CAR);
				Newclear(driver, VersionNo_Filter_Input_CAR);
				sendKeys(driver, VersionNo_Filter_Input_CAR, Version_Num);
			}
			
			
			String ActivityColumn_Predictable=String.format(Predictable_Activity_Column_CAR, Activity);
			if(isdisplayed(driver, ActivityColumn_Predictable)) {

				Un_Predictable_Activities.remove(Activity);
				formatLocatorClick(driver, Quantity_Column_Predicatble, Activity);
				formatLocatorDoubleClick(driver, Quantity_Column_Predicatble, Activity);
				formatLocatorSendKeys(driver, Quantity_Input_Predictable, Activity, Quantity);
				
				waitForElement(driver, ActivityColumn_Predictable);
				click(driver,ActivityColumn_Predictable);
				
				waitForElement(driver, UnPredictable_ChargeRate);
				String chargeRateValueAct=getText(driver, UnPredictable_ChargeRate);
				double chrageRate=getNumberValue(chargeRateValueAct);
				
				waitForElement(driver, Total_Cost_Column_Pred_CAR);
				String totalCostValue=getText(driver, Total_Cost_Column_Pred_CAR);
				double totalcost_Act=getNumberValue(totalCostValue);
				double inputQuantity=getNumberValue(Quantity);
				
				double totalcost_Exp=(inputQuantity*chrageRate);
				Step_Start(13, "After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and ensure that the total cost is shown based on the multiplication of quantity given and its charge rate.", test, test1);
				if(totalcost_Exp==totalcost_Act) {
					System.out.println("Total Cost Matched for "+Activity+" || Expected : "+totalcost_Exp+" || Actual value : "+totalcost_Act);
					Extent_pass_New(driver, "Total Cost Matched for "+Activity+" || Expected : "+totalcost_Exp+" || Actual value : "+totalcost_Act, test, test1);
				}else {
					System.out.println("Total Cost Not Matched for "+Activity+" || Expected : "+totalcost_Exp+" || Actual value : "+totalcost_Act);
					Extent_fail(driver, "Total Cost Not Matched for "+Activity+" || Expected : "+totalcost_Exp+" || Actual value : "+totalcost_Act, test, test1);
				}
				Step_End(13, "After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and ensure that the total cost is shown based on the multiplication of quantity given and its charge rate.", test, test1);

			}
		}
		Step_End(10, "Select the required data in the grid by using the check box selection", test, test1);

		Step_Start(11, "Click on the Unpredictable Reporting tab. ", test, test1);
		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver,UnPredictable_Tab_CAR);
		waitForElement(driver, UnPredictable_Table_CAR);
		
		waitForElement(driver, More_Grid_UnPredictable_CAR);
		click(driver,More_Grid_UnPredictable_CAR);
		
		waitForElement(driver, Condition_UnPredictable_CAR);
		click(driver,Condition_UnPredictable_CAR);
		Step_End(11, "Click on the Unpredictable Reporting tab. ", test, test1);

		Step_Start(12, "Select the required data in the grid by using the check box selection.", test, test1);
		reArrangeAG_GridColumns(driver, Table_Headers_column);
		List<String> Amount_List_values=splitAndExpand(Amount_Value);

		for(int i=0;i<Table_Activities_Values.size();i++) {
			
			String Activity=Table_Activities_Values.get(i);//
			if(!Un_Predictable_Activities.contains(Activity)) {
				continue;
			}
			String Head =Activity_Head_Values.get(i);
			String Contract_Num =Contract_Numbers.get(i);
			String Version_Num =Version_Numbers.get(i);
			String Quantity =Quantity_Lists.get(i);

			String EquipementType=Equipement_Types.get(i);
			String EquipementStatus=Equipement_Status.get(i);
			String Amount =Amount_List_values.get(i);

			
			waitForElement(driver, Activity_Name_CAR);
			Newclear(driver, Activity_Name_CAR);
			sendKeys(driver, Activity_Name_CAR, Activity);
			
			if(!EquipementType.trim().equals("")) {
				waitForElement(driver, EqpType_Filter_input_CAR);
				Newclear(driver, EqpType_Filter_input_CAR);
				sendKeys(driver, EqpType_Filter_input_CAR, EquipementType);
			}
			if(!EquipementStatus.trim().equals("")) {
				waitForElement(driver, EqpStatus_Filter_input_CAR);
				Newclear(driver, EqpStatus_Filter_input_CAR);
				sendKeys(driver, EqpStatus_Filter_input_CAR, EquipementStatus);
			}
			if(!Head.trim().equals("")) {
				waitForElement(driver, Head_Filter_input_CAR);
				Newclear(driver, Head_Filter_input_CAR);
				sendKeys(driver, Head_Filter_input_CAR, Head);
			}
			if(!Contract_Num.trim().equals("")&&isdisplayed(driver, ContractNo_Filter_Input_CAR)) {
				waitForElement(driver, ContractNo_Filter_Input_CAR);
				Newclear(driver, ContractNo_Filter_Input_CAR);
				sendKeys(driver, ContractNo_Filter_Input_CAR, Contract_Num);
			}
			
			if(!Version_Num.trim().equals("")&&isdisplayed(driver, VersionNo_Filter_Input_CAR)) {
				waitForElement(driver, VersionNo_Filter_Input_CAR);
				Newclear(driver, VersionNo_Filter_Input_CAR);
				sendKeys(driver, VersionNo_Filter_Input_CAR, Version_Num);
			}
						
			String ActivityColumn_Predictable=String.format(Predictable_Activity_Column_CAR, Activity);
			waitForElement(driver, ActivityColumn_Predictable);
			String SelectColumn_UnPredictable=String.format(Select_Table_Row_CAR, Activity);
			waitForDisplay(driver, SelectColumn_UnPredictable);
			jsClick(driver, SelectColumn_UnPredictable);
			
			
			waitForElement(driver, UnPredictable_Quantity);
			doubleClick(driver,UnPredictable_Quantity);
			waitForElement(driver, quantity_Input_CAR);
			Newclear(driver, quantity_Input_CAR);
			sendKeys(driver, quantity_Input_CAR, Quantity);
			
			waitForElement(driver, UnPredict_Activity_GridCell_CAR);
			click(driver,UnPredict_Activity_GridCell_CAR);
		
			waitForElement(driver, ActivityColumn_Predictable);
			click(driver,ActivityColumn_Predictable);
			
			waitForElement(driver, UnPredictable_ChargeRate);
			String UP_Chargerate = getText(driver, UnPredictable_ChargeRate).replace(",", "");
			double chrageRate=getNumberValue(UP_Chargerate);
			
			waitForElement(driver, Total_Cost_Column_Pred_CAR);
			String UP_TotalCost = getText(driver, Total_Cost_Column_Pred_CAR).replace(",", "");
			double totalcost_Act=getNumberValue(UP_TotalCost);
			double inputQuantity=getNumberValue(Quantity);
			double totalcost_Exp=(inputQuantity*chrageRate);
			
			Step_Start(13, "After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and ensure that the total cost is shown based on the multiplication of quantity given and its charge rate.", test, test1);

			if(totalcost_Exp==totalcost_Act) {
				System.out.println("Total Cost Matched for "+Activity+" || Expected : "+totalcost_Exp+" || Actual value : "+totalcost_Act);
				Extent_pass_New(driver, "Total Cost Matched for "+Activity+" || Expected : "+totalcost_Exp+" || Actual value : "+totalcost_Act, test, test1);
			}else {
				System.out.println("Total Cost Not Matched for "+Activity+" || Expected : "+totalcost_Exp+" || Actual value : "+totalcost_Act);
				Extent_fail(driver, "Total Cost Not Matched for "+Activity+" || Expected : "+totalcost_Exp+" || Actual value : "+totalcost_Act, test, test1);
			}
			Step_End(13, "After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and ensure that the total cost is shown based on the multiplication of quantity given and its charge rate.", test, test1);
		
		
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
					Step_End(15,	"Check whether the system populates a information message as \"variable(s) applied selected record\"y",
							test, test1);
				}
				
				Step_End(13,	".Incase,if the selected activity contains any formula along with the To be reported(Formula) checkbox selection false means,we have to input the required variable values in the value field and click the simulator option. An information message will be displayed as \"The result for Sample Values along with simulator value\" and click ok option",
						test, test1);
			}
		
		
		}
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Activity_Report_Updated);
		String save_value = getText(driver, popup_Message);
		System.out.println("save_value : " + save_value);

		if (Activity_Report_Updated.equals(save_value)) {

			System.out.println("matched exp value :" + Activity_Report_Updated + "actual value :" + save_value);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Activity_Report_Updated+ " || Actual Report Activity is : " + save_value, test, test1);
		} else {
			System.out.println("Not matched exp value :" + Activity_Report_Updated + "actual value :" + save_value);
			Extent_fail(driver, " NotMatched || " + " Expected Report Activity is : " + Activity_Report_Updated+ " || Actual Report Activity is : " + save_value, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(11,"Select the required activity and change the quantity of that activity and ensure that cost also gets changed only if the activities",
				test, test1);
		Extent_completed(tc_Name, test, test1);

	}
}