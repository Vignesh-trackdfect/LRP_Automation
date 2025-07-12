package LRP_Cost_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS020 extends Keywords {

	public void Cost_Activity_Report_TS020(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS020";
		
		
		
		

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
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String Arrival_Date_Value = Excel_data.get("Arrival_Date_Value");
		String UnPredictable_Table_Filter_Headers = Excel_data.get("UnPredictable_Table_Filter_Headers");

		String Service_Header = Excel_data.get("Service_Header");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String Port_Header = Excel_data.get("Port_Header");
		String Terminal_Header = Excel_data.get("Terminal_Header");
		String Arrival_Date_Header = Excel_data.get("Arrival_Date_Header");
		
		String Table_Filter_Headers_Quantity = Excel_data.get("Table_Filter_Headers_Quantity");
		String Quantity_Add_Column = Excel_data.get("Quantity_Add_Column");
		String Quantity_Value = Excel_data.get("Quantity_Value");
		String Amount_Value = Excel_data.get("Amount_Value");
		String Apply_Variable_popup = Excel_data.get("Apply_Variable_popup");

		String Container_Activity_report_Saved_popup = Excel_data.get("Container_Activity_report_Saved_popup");

		String Predictable_Activity_Module = Excel_data.get("Predictable_Activity_Module");
		String Main_Activity_Name = Excel_data.get("Main_Activity_Name");
		String Sub_Activity_Name = Excel_data.get("Sub_Activity_Name");
		String Sub_Activities_Codes_PAB = Excel_data.get("Sub_Activities_Codes_PAB");
		
		String Popup_Text_Exp = Excel_data.get("Popup_Text_Exp");

		String Port_Header_Predictable = Excel_data.get("Port_Header_Predictable");
		String Terminal_Header_Predictable = Excel_data.get("Terminal_Header_Predictable");
		String Activity_Header_Predictable = Excel_data.get("Activity_Header_Predictable");

		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		Step_Start(1,
				"Once login to the application and click on switch profile option and select the required agency.",
				test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.",
				test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);

		waitForElement(driver, Contract_Type_Input_CAR);
		click(driver, Contract_Type_Input_CAR);

		String SelectContract = String.format(Select_Contract_Type_CAR, Select_Contract_type_Value);
		waitForElement(driver, SelectContract);
		click(driver, SelectContract);

		waitForElement(driver, Mode_Select_Input_CAR);
		click(driver, Mode_Select_Input_CAR);

		String SelectModeValue = String.format(Select_Mode_type_CAR, Select_Mode_type);
		waitForElement(driver, SelectModeValue);
		click(driver, SelectModeValue);

		Step_Start(3, "Click on the Service search button and select the required service code.", test, test1);
		waitForElement(driver, Service_Search_Btn_CAR);
		click(driver, Service_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Service_Header,Two_Column_Search_Condition,Service_Code);
		Step_End(3, "Click on the Service search button and select the required service code.", test, test1);

		Step_Start(4, "Click on the Vessel search button and select the required vessel code. ", test, test1);
		waitForElement(driver, Vessel_Search_Btn_CAR);
		click(driver, Vessel_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Vessel_Header,Two_Column_Search_Condition,Vessel_Code);
		Step_End(4, "Click on the Vessel search button and select the required vessel code. ", test, test1);

		Step_Start(5, "Click on the Port search button and select the required port code.", test, test1);
		waitForElement(driver, Port_Search_Btn_CAR);
		click(driver, Port_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Port_Header,Two_Column_Search_Condition,Port_Code);
		Step_End(5, "Click on the Port search button and select the required port code.", test, test1);

		Step_Start(6, "Click on the Terminal search button and select the required terminal code.", test, test1);
		waitForElement(driver, Terminal_Search_Btn_CAR);
		click(driver, Terminal_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Terminal_Header,Two_Column_Search_Condition,Terminal_Code);
		Step_End(6, "Click on the Terminal search button and select the required terminal code.", test, test1);

		Step_Start(7, "Click on the Arrival date search button and select the required date.  ", test, test1);
		waitForElement(driver, Arrival_Date_Search_Btn_CAR);
		click(driver, Arrival_Date_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Arrival_Date_Header,Two_Column_Search_Condition,Arrival_Date_Value);
		Step_End(7, "Click on the Arrival date search button and select the required date.  ", test, test1);

		Step_Start(8, "Click on the Show button and Click on the Predictable Reporting tab.  ", test, test1);
		waitForElement(driver, Show_Button_CAR);
		click(driver, Show_Button_CAR);
		Step_End(8, "Click on the Show button and Click on the Predictable Reporting tab.  ", test, test1);

		Step_Start(9,
				"Check whether the required activity is present in the predictable reporting tab. If none of the activities are not mapped, Then enter the screen name as \"Predictable activity behaviour\" in module search field.     ",
				test, test1);
		waitForElement(driver, Arrival_Date_Input_CAR);
		String ArrivalDate = getAttribute(driver, Arrival_Date_Input_CAR, "value");

		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver, UnPredictable_Tab_CAR);
		waitForElement(driver, UnPredictable_Table_CAR);

		waitForElement(driver, More_Grid_CAR);
		click(driver, More_Grid_CAR);

		waitForElement(driver, Condition_Filter_CAR);
		click(driver, Condition_Filter_CAR);
		
		reArrangeAG_GridColumns(driver, UnPredictable_Table_Filter_Headers);

		List<String> mainActivities=splitAndExpand(Main_Activity_Name);
		List<String> subActivities=splitAndExpandNew(Sub_Activity_Name,"|");
		List<String> Sub_ActCode_List=splitAndExpandNew(Sub_Activities_Codes_PAB,"|");
		
		Map<String,Map<String,String>> Main_Activity_ValuesLists=new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> Parent_Activity_ValuesLists=new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> Activity_Codes_ValuesLists=new HashMap<String,Map<String,String>>();

		//Storing the Sub_Activity Codes for Each Main Actitvity from the test data sheet.
		int count=0;
		Map<String,Map<String,List<String>>> Sub_Activity_Codes_Lists= new HashMap<String, Map<String,List<String>>>();
		for(int h=0;h<mainActivities.size();h++) {
			String mainAct=mainActivities.get(h);
			Map<String,List<String>> SubAct_Codes_allocate=new HashMap<String,List<String>>();
			List<String>  Sub_ActNames_List=splitAndExpand(subActivities.get(h));
			for(int Cont=0;Cont<Sub_ActNames_List.size();Cont++) {
				String Commodity=Sub_ActNames_List.get(Cont);
				try {
					List<String> ActPackage=splitAndExpand(Sub_ActCode_List.get(count));
					SubAct_Codes_allocate.put(Commodity, ActPackage);
					Sub_Activity_Codes_Lists.put(mainAct, SubAct_Codes_allocate);
				}catch(Exception e) {
					
				}
				count++;
			}
		}	
		//Storing the Parent code,Main Activity and  Activity code for each Main Activity Name from the Un predictable Table
		for(int i=0;i<mainActivities.size();i++) {
			String MainAct=mainActivities.get(i);
			List<String> sub_ActivitiesList=splitAndExpand(subActivities.get(i));
			
			waitForElement(driver, Main_Activity_Filter_Input_CAR);
			Newclear(driver, Main_Activity_Filter_Input_CAR);
			sendKeys(driver, Main_Activity_Filter_Input_CAR, MainAct);
			enter(driver);
			waitForElement(driver, UnPredictable_Table_CAR);
			List<Map<String, String>> UnPredictable_TableData = extractTableDataByColumnWithoutScroll(driver, UnPredictable_Table_CAR);
			System.out.println("UnPredictable_TableData : "+UnPredictable_TableData);
			Map<String,String> Main_Activity_Values=new HashMap<String, String>();
			Map<String,String> Parent_Code_Values=new HashMap<String, String>();
			Map<String,String> Activity_Code_Values=new HashMap<String, String>();
			
			for(String Subact:sub_ActivitiesList) {
				String Main_Activity_Value=getValueByFirstColumnAndHeader(UnPredictable_TableData,"Activity Name",Subact,"Main Activity");
				String Parent_Code_Value=getValueByFirstColumnAndHeader(UnPredictable_TableData,"Activity Name",Subact,"Parent Code");
				String Activity_Code_Value=getValueByFirstColumnAndHeader(UnPredictable_TableData,"Activity Name",Subact,"Activity Code");

				Main_Activity_Values.put(Subact, Main_Activity_Value);
				Parent_Code_Values.put(Subact, Parent_Code_Value);
				Activity_Code_Values.put(Subact, Activity_Code_Value);
			}
			
			Main_Activity_ValuesLists.put(MainAct, Main_Activity_Values);
			Parent_Activity_ValuesLists.put(MainAct, Parent_Code_Values);
			Activity_Codes_ValuesLists.put(MainAct, Activity_Code_Values);
		}		
		//Storing the Parent code,Main Activity and  Activity code for each Main Activity Name from the Un predictable Table
		
		moduleNavigate(driver, Predictable_Activity_Module);
		Step_End(9,
				"Check whether the required activity is present in the predictable reporting tab. If none of the activities are not mapped, Then enter the screen name as 'Predictable activity behaviour' in module search field.     ",
				test, test1);

		Step_Start(10, "Select the required contract type, valid from and valid to dates.", test, test1);
		waitForElement(driver, Contract_type_Input_PAB);
		click(driver, Contract_type_Input_PAB);
		String Select_Contract = String.format(Select_Contract_Type_PAB, Select_Contract_type_Value);
		waitForElement(driver, Select_Contract);
		click(driver, Select_Contract);

		waitForElement(driver, From_Date_Input_PAB);
		selectDatePicker(driver, From_Date_Input_PAB, ArrivalDate);
		Step_End(10, "Select the required contract type, valid from and valid to dates.", test, test1);

		Step_Start(11,
				"Click on the port search option and select the required port. Next click on the terminal search option and select the required terminal. Next click on the show option.  ",
				test, test1);
		waitForElement(driver, Port_Input_PAB);
		click(driver, Port_Input_PAB);

		twoColumnSearchWindow(driver,Port_Header_Predictable,Two_Column_Search_Condition,Port_Code);

		waitForElement(driver, Terminal_Port_PAB);
		click(driver, Terminal_Port_PAB);
		twoColumnSearchWindow(driver,Terminal_Header_Predictable,Two_Column_Search_Condition,Terminal_Code);

		waitForElement(driver, Show_Button_PAB);
		click(driver, Show_Button_PAB);
		Step_End(11,
				"Click on the port search option and select the required port. Next click on the terminal search option and select the required terminal. Next click on the show option.  ",
				test, test1);

		Step_Start(12, "Main activities will be shown in the AG grid.  ", test, test1);
		waitForElement(driver, Predictable_Activity_Table_PAB);
		Step_End(12, "Main activities will be shown in the AG grid.  ", test, test1);

		Step_Start(13,
				"click on the required main activity and right click on them and select Add item option and select the check box of the required activity codes and click on the select option.   ",
				test, test1);
		
		for(int p=0;p<mainActivities.size();p++) {
			String Main_Act_Name=mainActivities.get(p);
			waitForElement(driver, Predictable_Activity_Table_Column);
			String MainActivity_Name_Column=String.format(Activity_Name_PAB, Main_Act_Name);
			if(!isdisplayed(driver, MainActivity_Name_Column)) {
				
				waitForElement(driver, Predictable_Activity_Table_Column);
				click(driver,Predictable_Activity_Table_Column);
				RightClick(driver, Predictable_Activity_Table_Column);
				
				waitForElement(driver, Add_Main_Item_PAB);
				click(driver,Add_Main_Item_PAB);
				
				twoColumnSearchWindow(driver, "Activity Name", Two_Column_Search_Condition, Main_Act_Name);
			}
			
			List<String> Activities_names_List=splitAndExpand(subActivities.get(p));
			for(int s=0;s<Activities_names_List.size();s++) {
				
				String MainCode_value=Main_Activity_ValuesLists.get(Main_Act_Name).get(Activities_names_List.get(s));
				String ParentCode_value=Parent_Activity_ValuesLists.get(Main_Act_Name).get(Activities_names_List.get(s));
				String ActCode_value=Activity_Codes_ValuesLists.get(Main_Act_Name).get(Activities_names_List.get(s));

				List<String> SubAct_CodesList=new ArrayList<String>();
				SubAct_CodesList.add(ActCode_value);
				try {
				  SubAct_CodesList.addAll(Sub_Activity_Codes_Lists.get(Main_Act_Name).get(Activities_names_List.get(s)));
				}catch(Exception e) {
					
				}
				SubAct_CodesList=SubAct_CodesList.stream().distinct().collect(Collectors.toList());
				String act_SubCode_List=String.join(",", SubAct_CodesList);
				if(MainCode_value.equals(ParentCode_value)) {
					String Activity_Column=String.format(Activity_Name_PAB, Main_Act_Name);
					waitForElement(driver, Activity_Column);
					click(driver,Activity_Column);
					RightClick(driver, Activity_Column);
					waitForElement(driver, Add_item_PAB);
					click(driver,Add_item_PAB);
					
					twoColumnSearchWindowMultipleValue(driver, Activity_Header_Predictable, Two_Column_Search_Condition, act_SubCode_List);

				}else {
					
					String Activity_Column=String.format(Activity_Name_PAB, Main_Act_Name);
					waitForElement(driver, Activity_Column);
					click(driver,Activity_Column);
					RightClick(driver, Activity_Column);
					waitForElement(driver, Add_item_PAB);
					click(driver,Add_item_PAB);
					twoColumnSearchWindow(driver,Activity_Header_Predictable,Two_Column_Search_Condition,ParentCode_value);
					
					String Parent_Column=String.format(Activity_Name_PAB, ParentCode_value);
					waitForElement(driver, Parent_Column);
					click(driver,Parent_Column);
					RightClick(driver, Parent_Column);
					
					waitForElement(driver, Add_item_PAB);
					click(driver,Add_item_PAB);
					
					twoColumnSearchWindowMultipleValue(driver, Activity_Header_Predictable, Two_Column_Search_Condition, act_SubCode_List);
				}
			}
		}
		
		Step_End(13,
				"click on the required main activity and right click on them and select Add item option and select the check box of the required activity codes and click on the select option.   ",
				test, test1);

		scrollTop(driver);
		Step_Start(14,
				"Then click on the save option in the toolbar and system validates as \"Predictable activity behaviour saved\".Click on the ok option. ",
				test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Popup_Text_Exp);
		String PopupText_Act = getText(driver, popup_Message);

		if (PopupText_Act.equals(Popup_Text_Exp)) {
			System.out.println(
					"Popup Matched  ||   Expected : " + Popup_Text_Exp + "   ||   Actual   : " + PopupText_Act);
			Extent_pass_New(driver,
					"Popup Matched  ||   Expected : " + Popup_Text_Exp + "   ||   Actual   : " + PopupText_Act, test,
					test1);
		} else {
			System.out.println(
					"Popup Not Matched  ||   Expected : " + Popup_Text_Exp + "   ||   Actual   : " + PopupText_Act);
			Extent_fail(driver,
					"Popup Not Matched  ||   Expected : " + Popup_Text_Exp + "   ||   Actual   : " + PopupText_Act,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Template_Numer_Input_PAB);
		String Template_Number_Exp = getAttribute(driver, Template_Numer_Input_PAB, "value");

		Step_End(14,
				"Then click on the save option in the toolbar and system validates as \"Predictable activity behaviour saved\".Click on the ok option. ",
				test, test1);

		Step_Start(15,
				"Then go to Cost activty report and click refresh option. Ensure that Activity number is matched", test,
				test1);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		waitForElement(driver, Refresh_Button_CAR);
		click(driver, Refresh_Button_CAR);

		waitForElement(driver, Contracts_Used_Btn_CAR);
		click(driver, Contracts_Used_Btn_CAR);

		waitForElement(driver, Contracts_Details_tab_CAR);
		waitForElement(driver, Activity_Behaviour_ID_CAR);
		String Activity_ID_Full = getText(driver, Activity_Behaviour_ID_CAR);

		List<String> Activity_ID_Split = splitAndExpand(Activity_ID_Full, ":");
		String Activity_ID_CAR = Activity_ID_Split.get(1);

		if (Template_Number_Exp.equals(Activity_ID_CAR)) {
			System.out.println("Template Number Matched ||   Expected : " + Template_Number_Exp + "  ||   Actual : "
					+ Activity_ID_CAR);
			Extent_pass_New(driver, "Template Number Matched ||   Expected : " + Template_Number_Exp + "  ||   Actual : "
					+ Activity_ID_CAR, test, test1);
		} else {
			System.out.println("Template Number Not Matched ||   Expected : " + Template_Number_Exp + "  ||   Actual : "
					+ Activity_ID_CAR);
			Extent_fail(driver, "Template Number Not Matched ||   Expected : " + Template_Number_Exp
					+ "  ||   Actual : " + Activity_ID_CAR, test, test1);
		}

		waitForElement(driver, Contract_Details_Ok_Btn_CAR);
		click(driver, Contract_Details_Ok_Btn_CAR);

		Step_End(15, "Then go to Cost activty report and click refresh option. Ensure that Activity number is matched",
				test, test1);

		Step_Start(16,
				"Ensure that mapped activty is shown in the predictable reporting tab and select the required activites",
				test, test1);
		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver, Predictable_Reporting_CAR);
		waitForElement(driver, Predictable_Table_CAR);

		waitForElement(driver, MoreOption_Grid);
		click(driver, MoreOption_Grid);

		waitForElement(driver, FilterOption_Menu);
		click(driver, FilterOption_Menu);
		
		for(int p=0;p<mainActivities.size();p++) {
			String Main_Act_Name=mainActivities.get(p);
			waitForElement(driver, Main_Activity_Filter_Input_CAR);
			Newclear(driver, Main_Activity_Filter_Input_CAR);
			sendKeys(driver, Main_Activity_Filter_Input_CAR, Main_Act_Name);
			
			List<String> Activities_names_List=splitAndExpand(subActivities.get(p));
			for(int s=0;s<Activities_names_List.size();s++) {
				String Activities_names_=Activities_names_List.get(s);
				waitForElement(driver, Activity_Name_CAR);
				Newclear(driver, Activity_Name_CAR);
				sendKeys(driver, Activity_Name_CAR, Activities_names_);
				
				String PredictableActivity_Column=String.format(Predictable_Activity_Column_CAR, Activities_names_);
				String MainActivity_Column=String.format(Main_Activity_Column_CAR, Main_Act_Name);
				
				if(isDisplayed(driver, PredictableActivity_Column)&&isDisplayed(driver, MainActivity_Column)) {
					System.out.println("Expected : "+PredictableActivity_Column+" Should Added successfully in the Predicatble Activity Table || Actual : "+PredictableActivity_Column+" Activity Added successfully in the Predicatble Activity Table ");
					Extent_pass_New(driver, "Expected : "+PredictableActivity_Column+" Activity Should Added successfully in the Predicatble Activity Table || Actual : "+PredictableActivity_Column+" Activity Added successfully in the Predicatble Activity Table ", test, test1);
				}else {
					System.out.println("Expected : "+PredictableActivity_Column+" Activity Should Added successfully in the Predicatble Activity Table || Actual : "+PredictableActivity_Column+" Activity not Added successfully in the Predicatble Activity Table ");
					Extent_fail(driver, "Expected : "+PredictableActivity_Column+" Activity Should Added successfully in the Predicatble Activity Table || Actual : "+PredictableActivity_Column+" Activity not Added successfully in the Predicatble Activity Table ", test, test1);
				}
				
				waitForElement(driver, PredictableActivity_Column);
				click(driver, PredictableActivity_Column);
			}
		}

		
		Step_End(16,
				"Ensure that mapped activty is shown in the predictable reporting tab and select the required activites",
				test, test1);

		Step_Start(17,
				"Click on the Unpredictable Reporting tab and Select the required data in the grid by using the check box selection.. ",
				test, test1);
		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver, UnPredictable_Tab_CAR);
		waitForElement(driver, UnPredictable_Table_CAR);

		reArrangeAG_GridColumns(driver, Table_Filter_Headers_Quantity);
		
		waitForElement(driver, More_Grid_UnPredictable_CAR);
		click(driver, More_Grid_UnPredictable_CAR);

		waitForElement(driver, Condition_UnPredictable_CAR);
		click(driver, Condition_UnPredictable_CAR);
		Step_End(17,
				"Click on the Unpredictable Reporting tab and Select the required data in the grid by using the check box selection.. ",
				test, test1);

		Step_Start(18,
				"After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and check whether the activity has any variables in formula column ",
				test, test1);

		waitForElement(driver, Activity_Name_CAR);
		sendKeys(driver, Activity_Name_CAR, Quantity_Add_Column);

		String ActivityColumn_Predictable=String.format(Predictable_Activity_Column_CAR, Quantity_Add_Column);
		waitForElement(driver, ActivityColumn_Predictable);
		String SelectColumn_UnPredictable=String.format(Select_Table_Row_CAR, Quantity_Add_Column);
		waitForDisplay(driver, SelectColumn_UnPredictable);
		jsClick(driver, SelectColumn_UnPredictable);
		
		waitForElement(driver, Quantity_Column_CAR);
		doubleClick(driver, Quantity_Column_CAR);
		waitForElement(driver, quantity_Input_CAR);
		clear(driver, quantity_Input_CAR);
		sendKeys(driver, quantity_Input_CAR, Quantity_Value);
		waitForElement(driver, ActivityColumn_Predictable);
		click(driver,ActivityColumn_Predictable);
		
		waitForElement(driver, Formula_Column_CAR);
		String Formula_Value = getText(driver, Formula_Column_CAR);
		

		if(!Formula_Value.equals("")) {
			
			waitForDisplay(driver, IsPredictable_Check_CAR);
			String predictableCheck=getAttribute1(driver, IsPredictable_Check_CAR, "aria-label");
			if(!predictableCheck.equals("checked")) {
				
				waitForElement(driver, Value_Input_Column_CAR);
				doubleClick(driver, Value_Input_Column_CAR);
				Newclear(driver, Value_Input_Column_CAR);
				sendKeys(driver, Value_Input_CAR, Amount_Value);

				waitForElement(driver, Apply_Button_CAR);
				click(driver, Apply_Button_CAR);
				
				waitForPopup(driver, Popup_Message, Apply_Variable_popup);
				String Popup_Text_Act_val=getText(driver, Popup_Message);
				
				if(Popup_Text_Act_val.equals(Apply_Variable_popup)) {
					System.out.println("Popup Matched  ||   Expected : "+Apply_Variable_popup+"   ||   Actual   : "+Popup_Text_Act_val);
					Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Apply_Variable_popup+"   ||   Actual   : "+Popup_Text_Act_val, test, test1);
				}else {
					System.out.println("Popup Not Matched  ||   Expected : "+Apply_Variable_popup+"   ||   Actual   : "+Popup_Text_Act_val);
					Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Apply_Variable_popup+"   ||   Actual   : "+Popup_Text_Act_val, test, test1);
				}
			}
		}
		Step_End(18,
				"After the selection enter the required quantity value for the selected records in the unpredictable reporting tab and check whether the activity has any variables in formula column ",
				test, test1);
			Step_Start(19, "Click on the tool bar save button,if the selected activity does not contains any formula",
					test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(19, "Click on the tool bar save button,if the selected activity does not contains any formula",
					test, test1);

			Step_Start(21,
					"check whether the system shows the information message as 'Container Activity Report Saved'", test,
					test1);
			waitForPopup(driver, popup_Message, Container_Activity_report_Saved_popup);
			String Popup_Text_Act = getText(driver, popup_Message);

			if (Popup_Text_Act.equals(Container_Activity_report_Saved_popup)) {
				System.out.println("Popup Matched  ||   Expected : " + Container_Activity_report_Saved_popup
						+ "   ||   Actual   : " + Popup_Text_Act);
				Extent_pass_New(driver, "Popup Matched  ||   Expected : " + Container_Activity_report_Saved_popup
						+ "   ||   Actual   : " + Popup_Text_Act, test, test1);
			} else {
				System.out.println("Popup Not Matched  ||   Expected : " + Container_Activity_report_Saved_popup
						+ "   ||   Actual   : " + Popup_Text_Act);
				Extent_fail(driver, "Popup Not Matched  ||   Expected : " + Container_Activity_report_Saved_popup
						+ "   ||   Actual   : " + Popup_Text_Act, test, test1);
			}

			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_End(21, "check whether the system shows the information message as 'Container Activity Report Saved'",
					test, test1);
		
		Extent_completed(tc_Name, test, test1);

	}

}
