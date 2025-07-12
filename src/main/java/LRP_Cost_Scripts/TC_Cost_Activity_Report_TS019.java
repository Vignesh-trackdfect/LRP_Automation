package LRP_Cost_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS019 extends Keywords{
	
	public void  Cost_Activity_Report_TS019(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS019";
		
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
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String Arrival_Date_Header = Excel_data.get("Arrival_Date_Header");
		String Arrival_Date_Value = Excel_data.get("Arrival_Date_Value");
		
		String UnPredictable_Table_Filter_Headers = Excel_data.get("UnPredictable_Table_Filter_Headers");

		String Popup_Text_Exp = Excel_data.get("Popup_Text_Exp");
		
		String Predictable_Activity_Module = Excel_data.get("Predictable_Activity_Module");
		String Predictable_Select_Type = Excel_data.get("Predictable_Select_Type");
		String Predictable_Select_Codition = Excel_data.get("Predictable_Select_Codition");
		String Main_Activity_Name = Excel_data.get("Main_Activity_Name");
		String Sub_Activity_Name = Excel_data.get("Sub_Activity_Name");
		String Sub_Activities_Codes_PAB = Excel_data.get("Sub_Activities_Codes_PAB");		
		String Activity_Header_Predictable = Excel_data.get("Activity_Header_Predictable");

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
		
		Step_Start(3, "Click on the Service search button and select the required service code.   ", test, test1);
		waitForElement(driver, Service_Search_Btn_CAR);
		click(driver,Service_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Service_Header,Two_Column_Search_Condition,Service_Code);
		Step_End(3, "Click on the Service search button and select the required service code.   ", test, test1);
		
		Step_Start(4, "Click on the Vessel search button and select the required vessel code.  ", test, test1);
		waitForElement(driver, Vessel_Search_Btn_CAR);
		click(driver,Vessel_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Vessel_Header,Two_Column_Search_Condition,Vessel_Code);
		Step_End(4, "Click on the Vessel search button and select the required vessel code.  ", test, test1);
		
		Step_Start(5, "Click on the Port search button and select the required port code.", test, test1);
		waitForElement(driver, Port_Search_Btn_CAR);
		click(driver,Port_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Port_Header,Two_Column_Search_Condition,Port_Code);
		Step_End(5, "Click on the Port search button and select the required port code.", test, test1);
		
		Step_Start(6, "Click on the Terminal search button and select the required terminal code.", test, test1);
		waitForElement(driver, Terminal_Search_Btn_CAR);
		click(driver,Terminal_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Terminal_Header,Two_Column_Search_Condition,Terminal_Code);
		Step_End(6, "Click on the Terminal search button and select the required terminal code.", test, test1);
		
		Step_Start(7, ".Click on the Arrival date search button and select the required date.", test, test1);
		waitForElement(driver, Arrival_Date_Search_Btn_CAR);
		click(driver,Arrival_Date_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Arrival_Date_Header,Two_Column_Search_Condition,Arrival_Date_Value);
		Step_End(7, ".Click on the Arrival date search button and select the required date.", test, test1);
		
		Step_Start(8, "Click on the Show button and Click on the Predictable Reporting tab.", test, test1);
		waitForElement(driver, Show_Button_CAR);
		click(driver,Show_Button_CAR);
		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		
		Step_End(8, "Click on the Show button and Click on the Predictable Reporting tab.", test, test1);
		
		Step_Start(9, "Check whether the required activity is present in the predictable reporting tab. If not click the contract used option. A new window will be opened and can see the activity behaviour template id.Copy the ID number.", test, test1);
		waitForElement(driver, UnPredictable_Tab_CAR);
		click(driver,UnPredictable_Tab_CAR);
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
		//Storing the Sub_Activity Codes for Each Main Actitvity from the test data sheet.
		
		//Storing the Parent code,Main Activity and  Activity code for each Main Activity Name from the Un predictable Table
		for(int i=0;i<mainActivities.size();i++) {
			String MainAct=mainActivities.get(i);
			List<String> sub_ActivitiesList=splitAndExpand(subActivities.get(i));
			
			waitForElement(driver, Main_Activity_Filter_Input_CAR);
			Newclear(driver, Main_Activity_Filter_Input_CAR);
			sendKeys(driver, Main_Activity_Filter_Input_CAR, MainAct);
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
		
		waitForElement(driver, Contracts_Used_Btn_CAR);
		click(driver,Contracts_Used_Btn_CAR);

		waitForElement(driver, Contracts_Details_tab_CAR);
		waitForElement(driver, Activity_Behaviour_ID_CAR);
		String Activity_ID_Full=getText(driver, Activity_Behaviour_ID_CAR);
		
		List<String>  Activity_ID_Split=splitAndExpand(Activity_ID_Full, ":");
		String Activity_ID_CAR=Activity_ID_Split.get(1);
		
		waitForElement(driver, Contract_Details_Ok_Btn_CAR);
		click(driver,Contract_Details_Ok_Btn_CAR);
		Step_End(9, "Check whether the required activity is present in the predictable reporting tab. If not click the contract used option. A new window will be opened and can see the activity behaviour template id.Copy the ID number.", test, test1);

		Step_Start(10, "Then enter the screen name as 'Predictable activity behaviour' in module search field.", test, test1);
		moduleNavigate(driver, Predictable_Activity_Module);
		Step_End(10, "Then enter the screen name as 'Predictable activity behaviour' in module search field.", test, test1);

		Step_Start(11, "Then click the global search option in the toolbar, a new window will be poped out", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(11, "Then click the global search option in the toolbar, a new window will be poped out", test, test1);

		Step_Start(12, "Enter the copied Template ID in the template number field.    ", test, test1);
		Step_Start(13, "Click on the search option.System will show the details    ", test, test1);
		Step_Start(14, "Then click select option.The template number will be retrieved and details will be shown in the AG grid.", test, test1);

		globalValueSearchWindow(driver,Predictable_Select_Codition,Predictable_Select_Type,Activity_ID_CAR,"","","","");
		
		waitForElement(driver, Predictable_Activity_Table_PAB);
		Step_End(14, "Then click select option.The template number will be retrieved and details will be shown in the AG grid.", test, test1);
		Step_End(13, "Click on the search option.System will show the details    ", test, test1);
		Step_End(12, "Enter the copied Template ID in the template number field.    ", test, test1);
		
		Step_Start(15, "Click on the edit option in the toolbar. Then select the required main activty and right click on it and select the add item option. If main activity is required  click on the add main activity and select the required main activity. ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver,Edit_Button_toolBar);
		
		waitForElement(driver, Predictable_Activity_Table_PAB);
		Step_End(15, "Click on the edit option in the toolbar. Then select the required main activty and right click on it and select the add item option. If main activity is required  click on the add main activity and select the required main activity. ", test, test1);
		
		Step_Start(16, "Select the check box of the required activty code under the main activty and click on the select option.Then click save option in the toolbar.System validates as \"Predictable activty behaviour updated\" and click on the ok option. ", test, test1);

		for(int p=0;p<mainActivities.size();p++) {
			String Main_Act_Name=mainActivities.get(p);
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
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
	    
		waitForPopup(driver, popup_Message, Popup_Text_Exp);
		String PopupText_Act=getText(driver, popup_Message);
		
		if(PopupText_Act.equals(Popup_Text_Exp)) {
			System.out.println("Popup Matched  ||   Expected : "+Popup_Text_Exp+"   ||   Actual   : "+PopupText_Act);
			Extent_pass_New(driver, "Popup Matched  ||   Expected : "+Popup_Text_Exp+"   ||   Actual   : "+PopupText_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected : "+Popup_Text_Exp+"   ||   Actual   : "+PopupText_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected : "+Popup_Text_Exp+"   ||   Actual   : "+PopupText_Act, test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		Step_End(16, "Select the check box of the required activty code under the main activty and click on the select option.Then click save option in the toolbar.System validates as \"Predictable activty behaviour updated\" and click on the ok option. ", test, test1);

		Step_Start(17, "Then go to Cost activity report and click refresh option. ", test, test1);
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		waitForElement(driver, Refresh_Button_CAR);
		click(driver,Refresh_Button_CAR);
		Step_End(17, "Then go to Cost activity report and click refresh option. ", test, test1);
		
		Step_Start(18, "Ensure that mapped activty is shown in the predictable reporting tab.   ", test, test1);
		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver,Predictable_Reporting_CAR);
		
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
			}
		}
		
		Step_End(18, "Ensure that mapped activty is shown in the predictable reporting tab.   ", test, test1);
		
		Extent_completed(tc_Name, test, test1);
		
	
	}

}
