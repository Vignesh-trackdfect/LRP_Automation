package LRP_EMS_Consolidation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements_2;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.Enquiry_History_Locators;

public class TC_Enquiry_History_TS023_to_TS028_C extends Keywords {

	public void Enquiry_History_TS023_to_TS028_C(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset) {
		int j=1;
		if(j==1) {
			String testCase_Name="TC_Enquiry_History_TS023";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String url = TestNgXml.getdatafromExecution().get(testCase_Name);
			String Sheet_Name_023 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);

			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name_023, testCase_Name,"Dataset" + selected_dataset, File_Path);
			String user_Name = Excel_data.get("Userid");
			String pass_word = Excel_data.get("PassWord");
			String Field_Names = Excel_data.get("field_name");
			String equipmentNo_TxtField_Input = Excel_data.get("EquipmentNo_TxtField_Input");
			String Container_Type_Radio_Button = Excel_data.get("Container_Type_Radio_Button");
			String Show_Delete_Chk_Box = Excel_data.get("Show_Delete_Chk_Box");
			String Show_Suppress_Chk_Box = Excel_data.get("Show_Suppress_Chk_Box");
			String Show_Top_Chk_Box = Excel_data.get("Show_Top_Chk_Box");
			String Multi_Top_Chk_Box = Excel_data.get("Multi_Top_Chk_Box");
			String Show_Top_Input = Excel_data.get("Show_Top_Input");
			String equipmentType_Input = Excel_data.get("equipmentType_Input");
			String Multi_Select_Inputs = Excel_data.get("Multi_Select_Inputs");
			String Condition =Excel_data.get("Condition");
			String Filter_Option =Excel_data.get("Filter_Option");
			String two_Column_Search_Header =Excel_data.get("two_Column_Search_Header");
			//Locators
			String Equip_Type_Select = String.format(Enquiry_History_Locators.Equip_Type_Select,  equipmentType_Input); 
			String Radio_Btn_Select = String.format(Enquiry_History_Locators.Radio_Btn_Select,  Container_Type_Radio_Button);

			Extent_Start(testCase_Name, test, test1);
			navigateUrl(driver, url);
			LRP_Login(driver, user_Name, pass_word);

			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			
			waitForElement(driver, Equip_Type_DD);
			safeclick(driver, Equip_Type_DD);
			waitForElement(driver, Equip_Type_Select);
			safeclick(driver, Equip_Type_Select);
			Step_Start(1, "Select Equipment no radio button option to proceed further", test, test1);
			// select Equipment radio button
			waitForElement(driver, Radio_Btn_Select);
			safeclick(driver, Radio_Btn_Select);
			Step_End(1, "Select Equipment no radio button option to proceed further", test, test1);
			waitForElement(driver, P_equip_MultiSelect_CheckBox);
			checkBox(driver, P_equip_MultiSelect_CheckBox, Multi_Top_Chk_Box);
			Step_Start(2, "Enter required container no for Equipment no field", test, test1);
			if (Multi_Top_Chk_Box.equalsIgnoreCase("YES")) {
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs);
				for (String Multi_Sel_Value : Multi_Sel_Values) {
					waitForElement(driver, P_equipment_TxtField);
					safeclick(driver, P_equipment_TxtField);
					sendKeys(driver, P_equipment_TxtField, Multi_Sel_Value);
					waitForElement(driver, P_equipment_SearchIcon);
					safeclick(driver, P_equipment_SearchIcon);
					twoColumnSearchWindow(driver,two_Column_Search_Header,Condition, Multi_Sel_Value);
				}
			} else {
				waitForElement(driver, P_equipment_TxtField);
				safeclick(driver, P_equipment_TxtField);
				sendKeys(driver, P_equipment_TxtField, equipmentNo_TxtField_Input);
				waitForElement(driver, P_equipment_SearchIcon);
				safeclick(driver, P_equipment_SearchIcon);
				twoColumnSearchWindow(driver,two_Column_Search_Header,Condition,equipmentNo_TxtField_Input);
			}
			Step_End(2, "Enter required container no for Equipment no field", test, test1);
			waitForElement(driver, P_show_DltRec_ChkBox);
			checkBox(driver, P_show_DltRec_ChkBox, Show_Delete_Chk_Box);
			waitForElement(driver, P_suppressAct_CheckBox);
			checkBox(driver, P_suppressAct_CheckBox, Show_Suppress_Chk_Box);
			waitForElement(driver, P_Show_Top_CheckBox);
			checkBox(driver, P_Show_Top_CheckBox, Show_Top_Chk_Box);
			if (Show_Top_Chk_Box.equalsIgnoreCase("YES")) {
				waitForElement(driver, P_Show_Top_Field);
				clearAndType(driver, P_Show_Top_Field, Show_Top_Input);
			}
			Step_Start(3, "click show button to get all movement details", test, test1);
			// safeclick show button
			waitForElement(driver, P_show_Btn);
			safeclick(driver, P_show_Btn);
			Step_End(3, "click show button to get all movement details", test, test1);
			Step_Start(4, "movement detail should shown in grid based on Equipment no", test, test1);

			if (Multi_Top_Chk_Box.equalsIgnoreCase("YES")) {
				List<WebElement> total_Values_Grid =listOfElements(driver, Equipment_Number);
				int Grid_Size = total_Values_Grid.size();
				int i = 1;
				// check the movement details
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs);
				int total_Input_Size = Multi_Sel_Values.size();
				for (String Multi_Sel_Value : Multi_Sel_Values) {
					String movement =  String.format(Enquiry_History_Locators.movement_Value,i); 
					waitForElement(driver, movement);
					String movementDetail = getText(driver, movement);
					if (Grid_Size == total_Input_Size) {
						if (Multi_Sel_Value.equalsIgnoreCase(movementDetail)) {
							System.out.println("Matched || " + " Expected Report Activity is : " + Multi_Sel_Value+ " || Actual Report Activity is : " + movementDetail);
							Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Multi_Sel_Value+ " || Actual Report Activity is : " + movementDetail, test, test1);
						} else {
							System.out.println("Not Matched || " + " Expected Report Activity is : " + Multi_Sel_Value+ " || Actual Report Activity is : " + movementDetail);
							Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Multi_Sel_Value+ " || Actual Report Activity is : " + movementDetail, test, test1);
						}
						i++;
					} else {
						System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
						Extent_fail(driver, "Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid", test,test1);
					}
				}
			} else {
				waitForElement(driver, P_Grid_NoOfRetrived);
				String abc=getText(driver, P_Grid_NoOfRetrived);
				System.out.println("abc : "+abc);
				int startIndex=abc.indexOf(':');
				int endIndex=abc.length();
				String numString=abc.substring(startIndex+1, endIndex).trim();
				int numberValue=Integer.parseInt(numString);
				System.out.println("numberValue : "+numberValue);
				int expectednumber =0; 
				for(int i=0;i<=numberValue+numberValue;i++) {
						String movementcode =  String.format(Enquiry_History_Locators.Grid_Movement_Codes,i);
						String movement_Code_text = getTextwithoutfail(driver, movementcode);
						if(!movement_Code_text.contains(Filter_Option) && !movement_Code_text.equals("null")) {
							expectednumber++;
						}else if(movement_Code_text.equals("null")) {
							break;
						}
						mouseOverToElement(driver, movementcode);
						click(driver, movementcode);
				}	
			if(expectednumber==numberValue) {
				System.out.println("Matched || " + " Expected Result is : " + numberValue + " || Actual Result is : " + expectednumber);
				Extent_pass_New(driver, "Matched || " + " Expected Result is : " + numberValue + " || Actual Result  is : " + expectednumber, test,test1);
			}else {
				System.out.println("Not Matched || " + " Expected Result is : " + numberValue + " || Actual Result  is : " + expectednumber);
				Extent_fail(driver, "Not Matched || " + " Expected Result is : " + numberValue + " || Actual Result  is : " + expectednumber, test,test1);
			}
				// check the movement details
				waitForElement(driver, Tool_Bar_EH);
				click(driver, Tool_Bar_EH);
				waitForElement(driver, Condition_Filter_EH);
				click(driver, Condition_Filter_EH);
				waitForElement(driver, Movement_Filter_EH);
				sendKeys(driver, Movement_Filter_EH,Filter_Option);
				waitForElement(driver, P_equipmentNo_Details);
				String movementDetail = getText(driver, P_equipmentNo_Details);
				if (equipmentNo_TxtField_Input.equalsIgnoreCase(movementDetail)) {
					System.out.println("Matched || " + " Expected Result is : " + equipmentNo_TxtField_Input+ " || Actual Result is : " + movementDetail);
					Extent_pass_New(driver, "Matched || " + " Expected Result is : " + equipmentNo_TxtField_Input+ " || Actual Result is : " + movementDetail, test, test1);
				} else {
					System.out.println("Not Matched || " + " Expected Result is : " + equipmentNo_TxtField_Input+ " || Actual Result is : " + movementDetail);
					Extent_fail(driver, "Not Matched || " + " Expected Result is : " + equipmentNo_TxtField_Input+ " || Actual Result is : " + movementDetail, test, test1);
				}
				
			}
			Step_End(4, "movement detail should shown in grid based on Equipment no", test, test1);
			Extent_completed(testCase_Name, test, test1);
			waitForElement(driver, Close_Current_tab);
			click1(driver, Close_Current_tab);
		}


		if(j==1) {
			String testCase_Name="TC_Enquiry_History_TS024";
			String File_Path_024 = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_024 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name_024, testCase_Name, "Dataset"+selected_dataset, File_Path_024);

			String Field_Names = Excel_data.get("field_name");
			String Container_Type_Radio_Button24 = Excel_data.get("Container_Type_Radio_Button");
			String Show_Delete_Chk_Box24 = Excel_data.get("Show_Delete_Chk_Box");
			String Show_Suppress_Chk_Box24 = Excel_data.get("Show_Suppress_Chk_Box");
			String Show_Top_Chk_Box24 = Excel_data.get("Show_Top_Chk_Box");
			String Multi_Select_Chk_Box24 = Excel_data.get("Multi_Top_Chk_Box");
			String Show_Top_Input24 = Excel_data.get("Show_Top_Input");
			String equipmentType_Input24 = Excel_data.get("equipmentType_Input");
			String Multi_Select_Inputs24 = Excel_data.get("Multi_Select_Inputs");
			String eqpNo =Excel_data.get("EquipmentNumber");
			String savedPopupText=Excel_data.get("SavedPopup");
			String activity2 = Excel_data.get("Activity2");
			String movementEntryModule = Excel_data.get("MovementEntryModule");
			String deletedSingle =Excel_data.get("DeletedSingle");
			String Deleted_HighLighted_Color_Txt = Excel_data.get("DeletedMovement_HighLighted_Color");
			String Condition =Excel_data.get("Condition");
			String Filter_Option =Excel_data.get("Filter_Option");
			String two_Column_Search_Header =Excel_data.get("two_Column_Search_Header");

			String activityEqpEntry_1 = Excel_data.get("Activity1");
			String activityEqpEntry_2 = Excel_data.get("Activity2");

			String activityDateSingle = Excel_data.get("ActivityDate");
			String activityHourSingle = Excel_data.get("ActivityHour");
			String activityDateSingle_2 = Excel_data.get("ActivityDate_2");
			String activityHourSingle_2 = Excel_data.get("ActivityHour_2");
			String datePicker=Excel_data.get("DatePicker");
			Extent_Start(testCase_Name, test, test1);
			// Movement Entry
			Extent_call(test, test1, "Enter Movement Entry in searchbox & safeclick the module");
			moduleNavigate(driver, movementEntryModule);

			// Single Entry Equipment
			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, eqpNo);

			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activityEqpEntry_1);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			waitForElement(driver, activeDateInSingle_L);

			if(datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle);
			}else {
				if(activityDateSingle.contains("-")) {
					click(driver, activeDateInSingle_L);
					String activityDateSingle_1=activityDateSingle.replace("-", "/");
					clearAndType(driver, activeDateInSingle_L, activityDateSingle_1);

				}else {
					click(driver, activeDateInSingle_L);
					clearAndType(driver, activeDateInSingle_L, activityDateSingle);
				}		
			}

			if (!activityHourSingle.equals("")) {

				click(driver, activityTime);

				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);
					waitForElement(driver, activity_Time);
					clearAndType(driver, activity_Time, activityHourSingle);
					waitForElement(driver, activityTime_Close);
					click(driver, activityTime_Close);
				}				

			}
			
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);

			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);
				
			}
			
			
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, Excel_data, test, test1);
			
			scrollTop(driver);
			waitForElement(driver, equipmentNoSearchField_L);
			String ActualEqNo = getAttribute(driver, equipmentNoSearchField_L, "value");
			System.out.println("ActualEqNo:" + ActualEqNo);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, savedPopupText);
				String actText = getText(driver, popup_Message);
				if (actText.equals(savedPopupText)) {
					System.out.println("Matched || " + " Expected popup is : " + savedPopupText
							+ " || Actual popup is : " + actText);
					Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedPopupText
							+ " || Actualpopup is : " + actText+"\r\n"+savedPopupText + " popup is displayed", test, test1);
					System.out.println(savedPopupText + " popup is displayed");
					click(driver, popup_Message_Ok_Button);

				} else {
					System.out.println("Not matched || " + " Expected popup is : " + savedPopupText
							+ " || Actual popup  is : " + actText);
					System.out.println(savedPopupText + " popup is not displayed");
					Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedPopupText
							+ " || Actual popup is : " + actText+"\r\n"+savedPopupText + " popup is not displayed", test, test1);
				}

			//Create SNTS Move
			Extent_call(test, test1, "Create Movement Entry");
			
			waitForElement(driver, equipmentNoSearchField_L);
			clearAndType(driver, equipmentNoSearchField_L, eqpNo);

			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activityEqpEntry_2);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			waitForElement(driver, activeDateInSingle_L);

			if(datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle_2);
			}else {
				if(activityDateSingle_2.contains("-")) {
					click(driver, activeDateInSingle_L);
					String activityDateSingle_2_1=activityDateSingle_2.replace("-", "/");
					clearAndType(driver, activeDateInSingle_L, activityDateSingle_2_1);

				}else {
					click(driver, activeDateInSingle_L);
					clearAndType(driver, activeDateInSingle_L, activityDateSingle_2);
				}		
			}

			if (!activityHourSingle_2.equals("")) {

				click(driver, activityTime);

				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);
					waitForElement(driver, activity_Time);
					clearAndType(driver, activity_Time, activityHourSingle_2);
					waitForElement(driver, activityTime_Close);
					click(driver, activityTime_Close);
				}				

			}
			
			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);

			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);
				
			}
			
			Movement_Entry_All_Elements_2 allElements_SNTS=new Movement_Entry_All_Elements_2();
			allElements_SNTS.movementEntryAllElements(driver, Excel_data, test, test1);		

			scrollTop(driver);
			waitForElement(driver, equipmentNoSearchField_L);
			 ActualEqNo = getAttribute(driver, equipmentNoSearchField_L, "value");
			System.out.println("ActualEqNo:" + ActualEqNo);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);


			waitForPopup(driver, popup_Message, savedPopupText);
				actText = getText(driver, popup_Message);
				if (actText.equals(savedPopupText)) {
					System.out.println("Matched || " + " Expected popup is : " + savedPopupText
							+ " || Actual popup is : " + actText);
					Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedPopupText
							+ " || Actualpopup is : " + actText+"\r\n"+savedPopupText + " popup is displayed", test, test1);
					System.out.println(savedPopupText + " popup is displayed");
					click(driver, popup_Message_Ok_Button);

				} else {
					System.out.println("Not matched || " + " Expected popup is : " + savedPopupText
							+ " || Actual popup  is : " + actText);
					System.out.println(savedPopupText + " popup is not displayed");
					Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedPopupText
							+ " || Actual popup is : " + actText+"\r\n"+savedPopupText + " popup is not displayed", test, test1);
				}
				

				scrollTop(driver);
				waitForElement(driver, cancel_Common_btn);
			safeclick(driver, cancel_Common_btn);
			Extent_call(test, test1, "Delete the Movement Entry");
			
			newButton(driver);
			
			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, ActualEqNo);
			waitForElement(driver, showHistoryButton_L);
			safeclick(driver, showHistoryButton_L);
			String grid_element =  String.format(Enquiry_History_Locators.grid_element,  activity2); 
			waitForElement(driver, grid_element);
			RightClick(driver, grid_element);
			waitForElement(driver, deleteOpionSingle_L);
			safeclick(driver, deleteOpionSingle_L);
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				String actConfirmDele = getText(driver, popup_Message);
				Extent_pass_New(driver, actConfirmDele + "popup is displayed", test,test1);
				safeclick(driver, popup_Message_Yes_Button);
			}
			waitForPopup(driver, popup_Message, savedPopupText);
			String actPopup = getText(driver, popup_Message);
			if (actPopup.equals(deletedSingle)) {
				System.out.println("Matched || " + " Expected Popup is : " + deletedSingle + " || Actual Popup is : " + actPopup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + deletedSingle + " || ActualValue is : " + actPopup,test,test1);
			} else {
				System.out.println("Not matched || " + " Expected Popup is : " + deletedSingle+ " || Actual Popup  is : " + actPopup+"<br>"+deletedSingle + " popup is not displayed");
				Extent_fail(driver, "Not matched || " + " Expected Popup is : " + deletedSingle+ " || Actual Popup  is : " + actPopup+"<br>"+deletedSingle + " popup is not displayed", test,test1);
			}
			safeclick(driver, popup_Message_Ok_Button);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			Extent_call(test, test1, "Enter module name in searchbox & safeclick the module");
			//Enter Enquiry History 
			moduleNavigate(driver, Field_Names);
			waitForElement(driver, Equip_Type_DD);
			safeclick(driver, Equip_Type_DD);
			String Equip_Type_Select = String.format(Enquiry_History_Locators.Equip_Type_Select,  equipmentType_Input24); 
			waitForElement(driver, Equip_Type_Select);
			safeclick(driver, Equip_Type_Select);
			String Radio_Btn_Select = String.format(Enquiry_History_Locators.Radio_Btn_Select,  Container_Type_Radio_Button24);
			//select Equipment radio button
			waitForElement(driver, Radio_Btn_Select);
			safeclick(driver, Radio_Btn_Select);

			Step_Start(1, "Enter required container no for Equipment no field", test, test1);
			waitForElement(driver, P_equip_MultiSelect_CheckBox);
			checkBox(driver, P_equip_MultiSelect_CheckBox, Multi_Select_Chk_Box24);
			if(Multi_Select_Chk_Box24.equalsIgnoreCase("YES")){
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs24);
				for(String Multi_Sel_Value : Multi_Sel_Values) {
					waitForElement(driver, P_equipment_TxtField);
					safeclick(driver, P_equipment_TxtField);
					sendKeys(driver, P_equipment_TxtField, Multi_Sel_Value);
					waitForElement(driver, P_equipment_SearchIcon);
					safeclick(driver, P_equipment_SearchIcon);
					twoColumnSearchWindow(driver,two_Column_Search_Header,Condition, Multi_Sel_Value);
				}
			}else {
				waitForElement(driver, P_equipment_TxtField);
				safeclick(driver, P_equipment_TxtField);
				sendKeys(driver, P_equipment_TxtField, ActualEqNo);
				waitForElement(driver, P_equipment_SearchIcon);
				safeclick(driver, P_equipment_SearchIcon);
				twoColumnSearchWindow(driver,two_Column_Search_Header,Condition,ActualEqNo);
			}
			Step_End(1, "Enter required container no for Equipment no field", test, test1);

			Step_Start(2, "safeclick checkbox for show deleted records field", test, test1);
			waitForElement(driver, P_show_DltRec_ChkBox);
			checkBox(driver, P_show_DltRec_ChkBox, Show_Delete_Chk_Box24);
			waitForElement(driver, P_suppressAct_CheckBox);
			checkBox(driver, P_suppressAct_CheckBox, Show_Suppress_Chk_Box24);
			waitForElement(driver, P_Show_Top_CheckBox);
			checkBox(driver, P_Show_Top_CheckBox, Show_Top_Chk_Box24);
			if(Show_Top_Chk_Box24.equals("YES")){
				waitForElement(driver, P_Show_Top_Field);
				clearAndType(driver, P_Show_Top_Field, Show_Top_Input24);
			}
			Step_End(2, "click checkbox for show deleted records field", test, test1);
			Step_Start(3, "click show button to get all movement details", test, test1);

			//click show button
			waitForElement(driver, P_show_Btn);
			safeclick(driver, P_show_Btn);
			Step_End(3, "safeclick show button to get all movement details", test, test1);

			if(Multi_Select_Chk_Box24.equalsIgnoreCase("YES")){
				waitForElement(driver, Equipment_Number);
				List<WebElement> total_Values_Grid =listOfElements(driver, Equipment_Number);
				int Grid_Size = total_Values_Grid.size();
				int i=1;
				// check the movement details
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs24);
				int total_Input_Size = Multi_Sel_Values.size();
				for(String Multi_Sel_Value : Multi_Sel_Values) {
					String movement =  String.format(Enquiry_History_Locators.movement_Value,i); 
					waitForElement(driver, movement);
					String movementDetail=getText(driver, movement);
					if(Grid_Size==total_Input_Size) {
						if(Multi_Sel_Value.equals(movementDetail)) {
							System.out.println("Matched || " + " Expected number is : " + Multi_Sel_Value + " || Actual number is : " + movementDetail);
							Extent_pass_New(driver, "Matched || " + " Expected number is : " + Multi_Sel_Value + " || Actual number is : " + movementDetail, test,test1);
						}
						else {
							System.out.println("Not Matched || " + " Expected number is : " + Multi_Sel_Value + " || Actual number is : " + movementDetail);
							Extent_fail(driver, "Not Matched || " + " Expected number is : " + Multi_Sel_Value + " || Actual number is : " + movementDetail, test,test1);
						}
						i++;
					}else {
						System.out.println("Not Matched || Expected : All the values should be getting into the grid || Actual :  All the values are not getting into the grid");
						Extent_fail(driver, "Not Matched || Expected : All the values should be getting into the grid || Actual :  All the values are not getting into the grid", test,test1);
				}
				}		
			}
			else {
				if(Show_Delete_Chk_Box24.equalsIgnoreCase("Yes")) {
					Step_Start(4, " movement detail should shown in grid along with deleted moves by highlighting in red color", test, test1);
					waitForElement(driver, P_show_DltRec_ChkBox);
					checkBox(driver, P_show_DltRec_ChkBox, Show_Delete_Chk_Box24);
					//safeclick show button
					waitForElement(driver, P_show_Btn);
					safeclick(driver, P_show_Btn);
					String deleted_Value =  String.format(Enquiry_History_Locators.deleted_Value,activity2);
					waitForElement(driver, deleted_Value);
					String deletedHighLight_Code = getTextBackgroundColor(driver, deleted_Value);
					String deletedHighLight = getColorName(deletedHighLight_Code);
					
					String movementDetail1=getText(driver, P_equipmentNo_Details);
					if(movementDetail1.equals(ActualEqNo)) {
						if(Deleted_HighLighted_Color_Txt.equals(deletedHighLight)) {
							System.out.println("Matched || " + " Expected Color is : " + Deleted_HighLighted_Color_Txt + " || Actual Color is : " + deletedHighLight);
							Extent_pass_New(driver, "Matched || " + " Expected Color is : " + Deleted_HighLighted_Color_Txt + " || Actual Color is : " + deletedHighLight, test,test1);
						}
						else {
							System.out.println("Not Matched || " + " Expected Color is : " + Deleted_HighLighted_Color_Txt + " || Actual Color is : " + deletedHighLight);
							Extent_fail(driver, "Not Matched || " + " Expected Color is : " + Deleted_HighLighted_Color_Txt + " || Actual Color is : " + deletedHighLight, test,test1);
						}
					}else {
						System.out.println("Not Matched || " + " Expected Color is : " + ActualEqNo + " || Actual Color is : " + movementDetail1);
						Extent_fail(driver, "Not Matched || " + " Expected Color is : " + ActualEqNo + " || Actual Color is : " + movementDetail1, test,test1);
					}
					waitForElement(driver, P_Grid_NoOfRetrived);
					String ele=getText(driver, P_Grid_NoOfRetrived);
					int startIndex1=ele.indexOf(':');
					int endIndex1=ele.length();
					String numString1=ele.substring(startIndex1+1, endIndex1).trim();
					int numberValue1=Integer.parseInt(numString1);
					List<WebElement> actlisted = listOfElements(driver, Row_List);
					int expectednumber1=actlisted.size()-1;
					if(expectednumber1==numberValue1) {
						System.out.println("Matched || " + " Expected number is : " + expectednumber1 + " || Actual number is : " + numberValue1);
						Extent_pass_New(driver, "Matched || " + " Expected number is : " + expectednumber1 + " || Actual number is : " + numberValue1, test,test1);
					}
					else {
						System.out.println("Not Matched || " + " Expected number is : " + expectednumber1 + " || Actual number is : " + numberValue1);
						Extent_fail(driver, "Not Matched || " + " Expected number is : " + expectednumber1 + " || Actual number is : " + numberValue1, test,test1);
					}
					Step_End(4, " movement detail should shown in grid along with deleted moves by highlighting in red color", test, test1);

				}else {
					// check the movement details
					waitForElement(driver, P_equipmentNo_Details);
					String movementDetail=getText(driver, P_equipmentNo_Details);
					if(eqpNo.equals(movementDetail)) {
						System.out.println("Matched || " + " Expected number is : " + eqpNo + " || Actual number is : " + movementDetail);
						Extent_pass_New(driver, "Matched || " + " Expected number is : " + eqpNo + " || Actual number is : " + movementDetail, test,test1);
					}
					else {
						System.out.println("Not Matched || " + " Expected number is : " + eqpNo + " || Actual number is : " + movementDetail);
						Extent_fail(driver, "Not Matched || " + " Expected number is : " + eqpNo + " || Actual number is : " + movementDetail, test,test1);
					}
					waitForElement(driver, P_Grid_NoOfRetrived);
					String abc=getText(driver, P_Grid_NoOfRetrived);
					System.out.println("abc : "+abc);
					int startIndex=abc.indexOf(':');
					int endIndex=abc.length();
					String numString=abc.substring(startIndex+1, endIndex).trim();
					int numberValue=Integer.parseInt(numString);
					System.out.println("numberValue : "+numberValue);
					int expectednumber =0; 
					for(int i=0;i<=numberValue+numberValue;i++) {
						String movementcode =  String.format(Enquiry_History_Locators.Grid_Movement_Codes,i);
						String movement_Code_text = getTextwithoutfail(driver, movementcode);
						if(!movement_Code_text.contains(Filter_Option) && !movement_Code_text.equals("null")) {
							expectednumber++;
						}else if(movement_Code_text.equals("null")) {
							break;
						}
						mouseOverToElement(driver, movementcode);
						click(driver, movementcode);
					}	
					if(expectednumber==numberValue) {
						System.out.println("Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber);
						Extent_pass_New(driver, "Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber, test,test1);
					}else {
						System.out.println("Not Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber);
						Extent_fail(driver, "Not Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber, test,test1);
					}
				}	
			}
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click1(driver, Close_Current_tab);
		}
		if(j==1) {
			String testCase_Name="TC_Enquiry_History_TS025";
			String File_Path_25 = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_025 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name_025, testCase_Name, "Dataset"+selected_dataset, File_Path_25);

			String Field_Names =Excel_data.get("field_name");
			String equipmentNo_TxtField_Input =Excel_data.get("EquipmentNo_TxtField_Input");
			String Container_Type_Radio_Button =Excel_data.get("Container_Type_Radio_Button");
			String Show_Delete_Chk_Box =Excel_data.get("Show_Delete_Chk_Box");
			String Show_Suppress_Chk_Box =Excel_data.get("Show_Suppress_Chk_Box");
			String Show_Top_Chk_Box =Excel_data.get("Show_Top_Chk_Box");
			String Multi_Top_Chk_Box =Excel_data.get("Multi_Top_Chk_Box");
			String Show_Top_Input =Excel_data.get("Show_Top_Input");
			String equipmentType_Input =Excel_data.get("equipmentType_Input");
			String Multi_Select_Inputs =Excel_data.get("Multi_Select_Inputs");
			String Suppress_HighLighted_Color_Txt =Excel_data.get("Suppress_HighLighted_Color");
			String Condition =Excel_data.get("Condition");
			String two_Column_Search_Header =Excel_data.get("two_Column_Search_Header");

			Extent_Start(testCase_Name, test, test1);

			Extent_call(test, test1, "Enter module name in searchbox & safeclick the module");
			moduleNavigate(driver, Field_Names);
			String Equip_Type_Select = String.format(Enquiry_History_Locators.Equip_Type_Select,  equipmentType_Input); 
			String Radio_Btn_Select = String.format(Enquiry_History_Locators.Radio_Btn_Select,  Container_Type_Radio_Button);
			waitForElement(driver, Equip_Type_DD);
			click(driver, Equip_Type_DD);
			waitForElement(driver, Equip_Type_Select);
			click(driver, Equip_Type_Select);
			//select Equipment radio button
			waitForElement(driver, Radio_Btn_Select);
			click(driver, Radio_Btn_Select);
			Step_Start(1, "Enter required container no for Equipment no field", test, test1);
			waitForElement(driver, P_equip_MultiSelect_CheckBox);
			checkBox(driver, P_equip_MultiSelect_CheckBox, Multi_Top_Chk_Box);
			if(Multi_Top_Chk_Box.equals("YES")){
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs);
				for(String Multi_Sel_Value : Multi_Sel_Values) {
					waitForElement(driver, P_equipment_TxtField);
					click(driver, P_equipment_TxtField);
					sendKeys(driver, P_equipment_TxtField, Multi_Sel_Value);
					waitForElement(driver, P_equipment_SearchIcon);
					click(driver, P_equipment_SearchIcon);
					twoColumnSearchWindow(driver,two_Column_Search_Header,Condition, Multi_Sel_Value);
				}
			}else {
				waitForElement(driver, P_equipment_TxtField);
				click(driver, P_equipment_TxtField);
				sendKeys(driver, P_equipment_TxtField, equipmentNo_TxtField_Input);
				waitForElement(driver, P_equipment_SearchIcon);
				click(driver, P_equipment_SearchIcon);
				twoColumnSearchWindow(driver,two_Column_Search_Header,Condition,equipmentNo_TxtField_Input);
			}
			Step_End(1, "Enter required container no for Equipment no field", test, test1);
			Step_Start(2, "click checkbox for show suppress activities field", test, test1);

			waitForElement(driver, P_show_DltRec_ChkBox);
			checkBox(driver, P_show_DltRec_ChkBox, Show_Delete_Chk_Box);
			waitForElement(driver, P_suppressAct_CheckBox);
			checkBox(driver, P_suppressAct_CheckBox, Show_Suppress_Chk_Box);
			waitForElement(driver, P_Show_Top_CheckBox);
			checkBox(driver, P_Show_Top_CheckBox, Show_Top_Chk_Box);
			if(Show_Top_Chk_Box.equals("YES")){
				waitForElement(driver, P_Show_Top_Field);
				clearAndType(driver, P_Show_Top_Field, Show_Top_Input);
			}
			Step_End(2, "click checkbox for show suppress activities field", test, test1);
			Step_Start(3, "click show button to get all movement details", test, test1);

			//click show button
			waitForElement(driver, P_show_Btn);
			click(driver, P_show_Btn);
			Step_End(3, "click show button to get all movement details", test, test1);

			if(Multi_Top_Chk_Box.equals("YES")){
				List<WebElement> total_Values_Grid =listOfElements(driver, Equipment_Number);
				int Grid_Size = total_Values_Grid.size();
				int i=1;
				// check the movement details
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs);
				int total_Input_Size = Multi_Sel_Values.size();
				for(String Multi_Sel_Value : Multi_Sel_Values) {
					String movement =  String.format(Enquiry_History_Locators.movement_Value,i); 
					waitForElement(driver, movement);
					String movementDetail=getText(driver, movement);
					if(Grid_Size==total_Input_Size) {
						if(Multi_Sel_Value.equals(movementDetail)) {
							System.out.println("Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail);
							Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail, test,test1);
						}
						else {
							System.out.println("Not Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail);
							Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail, test,test1);
						}
						i++;
					}else {
						System.out.println("Not Matched || Expected : All the values should be getting into the grid || Actual :  All the values are not getting into the grid");
						Extent_fail(driver, "Not Matched || Expected : All the values should be getting into the grid || Actual :  All the values are not getting into the grid", test,test1);
				}
				}		
			}
			else {
				Step_Start(4, "movement detail should shown in grid along with transfer moves by highlighting in cyan color", test, test1);

				// check the movement details
				if(Show_Suppress_Chk_Box.equalsIgnoreCase("Yes")) {
					waitForElement(driver, P_suppressAct_CheckBox);
					checkBox(driver, P_suppressAct_CheckBox, Show_Suppress_Chk_Box);
					//click show button
					waitForElement(driver, P_show_Btn);
					click(driver, P_show_Btn);

					waitForElement(driver, CHSC_Value);
					String suppressHighLightColor_Code=getTextBackgroundColor(driver, CHSC_Value);
					String suppressHighLightColor=getColorName(suppressHighLightColor_Code);
					if(Suppress_HighLighted_Color_Txt.equals(suppressHighLightColor)) {
						System.out.println("Matched || " + " Expected color is : " + Suppress_HighLighted_Color_Txt + " || Actual color is Displayed  : " + suppressHighLightColor);
						Extent_pass_New(driver, "Matched || " + " Expected color is : " + Suppress_HighLighted_Color_Txt + " || Actual color is Displayed  : " + suppressHighLightColor, test,test1);
					}
					else {
						System.out.println("Matched || " + " Expected color is : " + Suppress_HighLighted_Color_Txt + " || Actual color is Displayed  : " + suppressHighLightColor);
						Extent_fail(driver, "Matched || " + " Expected color is : " + Suppress_HighLighted_Color_Txt + " || Actual color is Displayed  : " + suppressHighLightColor, test,test1);
					}
					waitForElement(driver, Suppress_Details);
					String movementDetail2=getText(driver, Suppress_Details);
					if(isDisplayed(driver, CHSC_Value)) {
						System.out.println("Matched || Expected : Suppress value should be displayed || Actual : Suppress value is displayed || Suppress value is : " + movementDetail2);
						Extent_pass_New(driver, "Matched || Expected : Suppress value should be displayed || Actual : Suppress value is displayed || Suppress value is : " + movementDetail2, test,test1);
					}
					else {
						System.out.println("Not Matched  || Expected : Suppress value should be displayed || Actual : Suppress value is not displayed ");
						Extent_fail(driver,"Not Matched  || Expected : Suppress value should be displayed || Actual : Suppress value is not displayed ", test,test1);
					}
				}else {
					waitForElement(driver, P_equipmentNo_Details);
					String movementDetail=getText(driver, P_equipmentNo_Details);
					if(equipmentNo_TxtField_Input.equals(movementDetail)) {
						System.out.println("Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail);
						Extent_pass_New(driver, "Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail, test,test1);
					}
					else {
						System.out.println("Not Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail);
						Extent_fail(driver, "Not Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail, test,test1);
					}
					waitForElement(driver, P_Grid_NoOfRetrived);
					String abc=getText(driver, P_Grid_NoOfRetrived);
					int startIndex=abc.indexOf(':');
					int endIndex=abc.length();
					String numString=abc.substring(startIndex+1, endIndex).trim();
					int numberValue=Integer.parseInt(numString);
					List<WebElement> actlist = listOfElements(driver, Row_List);
					int expectednumber=actlist.size()-1;
					if(expectednumber==numberValue) {
						System.out.println("Matched || " + " Expected number is : " + expectednumber + " || Actual number is : " + numberValue);
						Extent_pass_New(driver,"Matched || " + " Expected number is : " + expectednumber + " || Actual number is : " + numberValue, test,test1);
					}else {
						System.out.println("Not Matched || " + " Expected number is : " + expectednumber + " || Actual number is : " + numberValue);
						Extent_fail(driver,"Not Matched || " + " Expected number is : " + expectednumber + " || Actual number is : " + numberValue, test,test1);
					}
				}	
			}
			Step_End(4, "movement detail should shown in grid along with transfer moves by highlighting in cyan color", test, test1);

			Extent_completed(testCase_Name, test, test1);

			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click1(driver, Close_Current_tab);
		}
		if(j==1) {
			String testCase_Name="TC_Enquiry_History_TS026";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_026 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name_026, testCase_Name, "Dataset"+selected_dataset, File_Path);

			String Field_Names = Excel_data.get("field_name");
			String equipmentNo_TxtField_Input = Excel_data.get("equipmentNo_TxtField_Input");
			String Container_Type_Radio_Button = Excel_data.get("Container_Type_Radio_Button");
			String Show_Delete_Chk_Box = Excel_data.get("Show_Delete_Chk_Box");
			String Show_Suppress_Chk_Box = Excel_data.get("Show_Suppress_Chk_Box");
			String Show_Top_Chk_Box = Excel_data.get("Show_Top_Chk_Box");
			String Multi_Top_Chk_Box = Excel_data.get("Multi_Top_Chk_Box");
			String Show_Top_Input = Excel_data.get("Show_Top_Input");
			String equipmentType_Input = Excel_data.get("equipmentType_Input");
			String Multi_Select_Inputs = Excel_data.get("Multi_Select_Inputs");
			String Condition =Excel_data.get("Condition");
			String two_Column_Search_Header =Excel_data.get("two_Column_Search_Header");
			String ColumnHeaders_AG_Grid =Excel_data.get("ColumnHeaders_AG_Grid");

			Extent_Start(testCase_Name, test, test1);

			Extent_call(test, test1, "Enter module name in searchbox & safeclick the module");
			moduleNavigate(driver, Field_Names);

			waitForElement(driver, Equip_Type_DD);
			click(driver, Equip_Type_DD);
			String Equip_Type_Select = String.format(Enquiry_History_Locators.Equip_Type_Select,  equipmentType_Input); 
			String Radio_Btn_Select = String.format(Enquiry_History_Locators.Radio_Btn_Select,  Container_Type_Radio_Button);
			waitForElement(driver, Equip_Type_Select);
			click(driver, Equip_Type_Select);
			//select Equipment radio button
			Step_Start(1, "Select Book no radio button option to proceed further", test, test1);
			waitForElement(driver, Radio_Btn_Select);
			click(driver, Radio_Btn_Select);
			Step_End(1, "Select Book no radio button option to proceed further", test, test1);
			Step_Start(2, "Enter required container no for Book no field", test, test1);
			waitForElement(driver, P_equip_MultiSelect_CheckBox);
			checkBox(driver, P_equip_MultiSelect_CheckBox, Multi_Top_Chk_Box);
			if(Multi_Top_Chk_Box.equals("YES")){
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs);
				for(String Multi_Sel_Value : Multi_Sel_Values) {
					waitForElement(driver, P_equipment_TxtField);
					click(driver, P_equipment_TxtField);
					sendKeys(driver, P_equipment_TxtField, Multi_Sel_Value);
					waitForElement(driver, P_equipment_SearchIcon);
					click(driver, P_equipment_SearchIcon);
					twoColumnSearchWindow(driver,two_Column_Search_Header,Condition, Multi_Sel_Value);
				}
			}else {
				waitForElement(driver, P_equipment_TxtField);
				click(driver, P_equipment_TxtField);
				sendKeys(driver, P_equipment_TxtField, equipmentNo_TxtField_Input);
				waitForElement(driver, P_equipment_SearchIcon);
				click(driver, P_equipment_SearchIcon);
				Step_End(2, "Enter required container no for Book no field", test, test1);
				twoColumnSearchWindow(driver,two_Column_Search_Header,Condition,equipmentNo_TxtField_Input);
			}
			waitForElement(driver, P_show_DltRec_ChkBox);
			checkBox(driver, P_show_DltRec_ChkBox, Show_Delete_Chk_Box);
			waitForElement(driver, P_suppressAct_CheckBox);
			checkBox(driver, P_suppressAct_CheckBox, Show_Suppress_Chk_Box);
			waitForElement(driver, P_Show_Top_CheckBox);
			checkBox(driver, P_Show_Top_CheckBox, Show_Top_Chk_Box);
			if(Show_Top_Chk_Box.equals("YES")){
				waitForElement(driver, P_Show_Top_Field);
				clearAndType(driver, P_Show_Top_Field, Show_Top_Input);
			}
			Step_End(2, "Enter required container no for Book no field", test, test1);

			Step_Start(3, "click show button to get all movement details", test, test1);
			//click show button
			waitForElement(driver, P_show_Btn);
			click(driver, P_show_Btn);
			Step_End(3, "click show button to get all movement details", test, test1);
			Step_Start(4, "movement detail should shown in grid based Booking no", test, test1);
			if(Multi_Top_Chk_Box.equalsIgnoreCase("YES")){
				List<WebElement> total_Values_Grid =listOfElements(driver, Equipment_Number);
				int Grid_Size = total_Values_Grid.size();
				int i=1;
				// check the movement details
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs);
				int total_Input_Size = Multi_Sel_Values.size();
				for(String Multi_Sel_Value : Multi_Sel_Values) {
					String movement =  String.format(Enquiry_History_Locators.movement_Value,i); 
					waitForElement(driver, movement);
					String movementDetail=getText(driver, movement);
					if(Grid_Size==total_Input_Size) {
						if(Multi_Sel_Value.equals(movementDetail)) {
							System.out.println("Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail);
							Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail, test,test1);
						}
						else {
							System.out.println("Not Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail);
							Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail, test,test1);
						}
						i++;
					}else {
						System.out.println("Not Matched || Expected : All the values should be getting into the grid || Actual :  All the values are not getting into the grid");
						Extent_fail(driver, "Not Matched || Expected : All the values should be getting into the grid || Actual :  All the values are not getting into the grid", test,test1);
				}
				}		
			}
			else {
				// check the movement details
				reArrangeAG_GridColumnsWithoutCheckbox(driver, ColumnHeaders_AG_Grid);

				String Booking_value =  String.format(Enquiry_History_Locators.P_bookingNo_Text,equipmentNo_TxtField_Input);
				String movementDetail=getText(driver, Booking_value);
				if(equipmentNo_TxtField_Input.equals(movementDetail)) {
					System.out.println("Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail);
					Extent_pass_New(driver, "Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail, test,test1);
				}
				else {
					System.out.println("Not Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail);
					Extent_fail(driver, "Not Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail, test,test1);
				}
				waitForElement(driver, P_Grid_NoOfRetrived);
				String abc=getText(driver, P_Grid_NoOfRetrived);
				System.out.println("abc : "+abc);
				int startIndex=abc.indexOf(':');
				int endIndex=abc.length();
				String numString=abc.substring(startIndex+1, endIndex).trim();
				int numberValue=Integer.parseInt(numString);
				System.out.println("numberValue : "+numberValue);
				int expectednumber =0; 
				for(int i=0;i<=numberValue+numberValue;i++) {
						String movementcode =  String.format(Enquiry_History_Locators.movementcode,i);
						String movement_Code_text = getTextwithoutfail(driver, movementcode);
						if(movement_Code_text.equals(equipmentNo_TxtField_Input)) {
							expectednumber++;
						}else if(movement_Code_text.equals("null")) {
							break;
						}
						mouseOverToElement(driver, movementcode);
						click(driver, movementcode);
				}	        
			if(expectednumber==numberValue) {
				System.out.println("Matched || " + " Expected number is : " + expectednumber + " || Actual number is : " + numberValue);
				Extent_pass_New(driver, "Matched || " + " Expected number is : " + expectednumber + " || Actual number is : " + numberValue, test,test1);
			}else {
				System.out.println("Not Matched || " + " Expected number is : " + expectednumber + " || Actual number is : " + numberValue);
				Extent_fail(driver, "Not Matched || " + " Expected number is : " + expectednumber + " || Actual number is : " + numberValue, test,test1);
			}
		}
		Step_Start(4, "movement detail should shown in grid based Booking no", test, test1);
		Extent_completed(testCase_Name, test, test1);

			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click1(driver, Close_Current_tab);
		}
		if(j==1) {
			String testCase_Name="TC_Enquiry_History_TS027";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_027 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name_027, testCase_Name, "Dataset"+selected_dataset, File_Path);

			String Field_Names = Excel_data.get("field_name");
			String equipmentNo_TxtField_Input = Excel_data.get("EquipmentNo_TxtField_Input");
			String Container_Type_Radio_Button = Excel_data.get("Container_Type_Radio_Button");
			String Show_Delete_Chk_Box = Excel_data.get("Show_Delete_Chk_Box");
			String Show_Suppress_Chk_Box = Excel_data.get("Show_Suppress_Chk_Box");
			String Show_Top_Chk_Box = Excel_data.get("Show_Top_Chk_Box");
			String Multi_Top_Chk_Box = Excel_data.get("Multi_Top_Chk_Box");
			String Show_Top_Input = Excel_data.get("Show_Top_Input");
			String equipmentType_Input = Excel_data.get("equipmentType_Input");
			String Multi_Select_Inputs = Excel_data.get("Multi_Select_Inputs");
			String Condition =Excel_data.get("Condition");
			String two_Column_Search_Header =Excel_data.get("two_Column_Search_Header");

			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			
			//select Equipment radio button
			Step_Start(1, "Select BL no radio button option to proceed further", test, test1);
			String Equip_Type_Select = String.format(Enquiry_History_Locators.Equip_Type_Select,  equipmentType_Input); 
			String Radio_Btn_Select = String.format(Enquiry_History_Locators.Radio_Btn_Select,  Container_Type_Radio_Button);
			waitForElement(driver, Equip_Type_DD);
			click(driver, Equip_Type_DD);
			waitForElement(driver, Equip_Type_Select);
			click(driver, Equip_Type_Select);
			//select Equipment radio button
			waitForElement(driver, Radio_Btn_Select);
			click(driver, Radio_Btn_Select);
			Step_End(1, "Select BL no radio button option to proceed further", test, test1);
			Step_Start(2, "Enter required container no for BL no field", test, test1);

			waitForElement(driver, P_equip_MultiSelect_CheckBox);
			checkBox(driver, P_equip_MultiSelect_CheckBox, Multi_Top_Chk_Box);
			if(Multi_Top_Chk_Box.equals("YES")){
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs);
				for(String Multi_Sel_Value : Multi_Sel_Values) {
					waitForElement(driver, P_equipment_TxtField);
					click(driver, P_equipment_TxtField);
					sendKeys(driver, P_equipment_TxtField, Multi_Sel_Value);
					waitForElement(driver, P_equipment_SearchIcon);
					click(driver, P_equipment_SearchIcon);
					twoColumnSearchWindow(driver,two_Column_Search_Header,Condition, Multi_Sel_Value);
				}
			}else {
				waitForElement(driver, P_equipment_TxtField);
				click(driver, P_equipment_TxtField);
				sendKeys(driver, P_equipment_TxtField, equipmentNo_TxtField_Input);
				waitForElement(driver, P_equipment_SearchIcon);
				click(driver, P_equipment_SearchIcon);
				twoColumnSearchWindow(driver,two_Column_Search_Header,Condition,equipmentNo_TxtField_Input);
			}
			Step_End(2, "Enter required container no for BL no field", test, test1);

			waitForElement(driver, P_show_DltRec_ChkBox);
			checkBox(driver, P_show_DltRec_ChkBox, Show_Delete_Chk_Box);
			waitForElement(driver, P_suppressAct_CheckBox);
			checkBox(driver, P_suppressAct_CheckBox, Show_Suppress_Chk_Box);
			waitForElement(driver, P_Show_Top_CheckBox);
			checkBox(driver, P_Show_Top_CheckBox, Show_Top_Chk_Box);
			if(Show_Top_Chk_Box.equals("YES")){
				waitForElement(driver, P_Show_Top_Field);
				clearAndType(driver, P_Show_Top_Field, Show_Top_Input);
			}

			Step_Start(3, "click show button to get all movement details", test, test1);
			//click show button
			waitForElement(driver, P_show_Btn);
			click(driver, P_show_Btn);
			Step_End(3, "click show button to get all movement details", test, test1);
			Step_Start(4, "movement detail should shown in grid based BL no", test, test1);
			if(Multi_Top_Chk_Box.equals("YES")){
				List<WebElement> total_Values_Grid =listOfElements(driver, Equipment_Number);
				int Grid_Size = total_Values_Grid.size();
				int i=1;
				// check the movement details
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs);
				int total_Input_Size = Multi_Sel_Values.size();
				for(String Multi_Sel_Value : Multi_Sel_Values) {
					String movement =  String.format(Enquiry_History_Locators.movement_Value,i); 
					waitForElement(driver, movement);
					String movementDetail=getText(driver, movement);
					if(Grid_Size==total_Input_Size) {
						if(Multi_Sel_Value.equals(movementDetail)) {
							System.out.println("Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail);
							Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail, test,test1);
						}
						else {
							System.out.println("Not Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail);
							Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail, test,test1);
						}
						i++;
					}else {
						System.out.println("Not Matched || Expected : All the values should be getting into the grid || Actual :  All the values are not getting into the grid");
						Extent_fail(driver, "Not Matched || Expected : All the values should be getting into the grid || Actual :  All the values are not getting into the grid", test,test1);
				}
				}		
			}else {
				// check the movement details
				waitForElement(driver, P_BLNo_EquipNo);

				String EquipNo=getText(driver, P_BLNo_EquipNo);
				String actTypeNo=getText(driver, P_BLNo_ActType);

				waitForDisplay(driver, P_equipmentNo_Details);
				if(isdisplayed(driver, P_equipmentNo_Details)) {
					System.out.println("Matched || Expected : Movement details should be Shown in grid || Actual : Movement details are Shown in grid based on BL No The EquipmentNo is shown as "+EquipNo+" and The Activity Type is shown as "+actTypeNo);
					Extent_pass_New(driver, "Matched || Expected : Movement details should be Shown in grid || Actual : Movement details are Shown in grid based on BL No The EquipmentNo is shown as "+EquipNo+" and The Activity Type is shown as "+actTypeNo, test,test1);
				}else {
					System.out.println("Not Matched || Expected : Movement details should be Shown in grid || Actual : Movement details are not Shown in grid ");
					Extent_fail(driver, "Not Matched || Expected : Movement details should be Shown in grid || Actual : Movement details are not Shown in grid ", test,test1);
				}
				waitForElement(driver, P_Grid_NoOfRetrived);
				String abc=getText(driver, P_Grid_NoOfRetrived);
				System.out.println("abc : "+abc);
				int startIndex=abc.indexOf(':');
				int endIndex=abc.length();
				String numString=abc.substring(startIndex+1, endIndex).trim();
				int numberValue=Integer.parseInt(numString);
				System.out.println("numberValue : "+numberValue);
				int expectednumber =0; 
				for(int i=0;i<=numberValue+numberValue;i++) {
					String movementcode =  String.format(Enquiry_History_Locators.Grid_Movement_Codes,i);
					String movement_Code_text = getTextwithoutfail(driver, movementcode);
					if(!movement_Code_text.contains("Equipment No:") && !movement_Code_text.equals("null")) {
						expectednumber++;
					}else if(movement_Code_text.equals("null")) {
						break;
					}
					mouseOverToElement(driver, movementcode);
					click(driver, movementcode);
				}	
				if(expectednumber==numberValue) {
					System.out.println("Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber);
					Extent_pass_New(driver, "Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber, test,test1);
				}else {
					System.out.println("Not Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber);
					Extent_fail(driver, "Not Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber, test,test1);
				}

			}
			Step_Start(4, "movement detail should shown in grid based BL no", test, test1);
			Extent_completed(testCase_Name, test, test1);

			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click1(driver, Close_Current_tab);
		}
		if(j==1) {
			String testCase_Name="TC_Enquiry_History_TS028";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_028 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name_028, testCase_Name, "Dataset"+selected_dataset, File_Path);

			String Field_Names = Excel_data.get("field_name");
			String equipmentNo_TxtField_Input = Excel_data.get("EquipmentNo_TxtField_Input");
			String Container_Type_Radio_Button = Excel_data.get("Container_Type_Radio_Button");
			String Show_Delete_Chk_Box = Excel_data.get("Show_Delete_Chk_Box");
			String Show_Suppress_Chk_Box = Excel_data.get("Show_Suppress_Chk_Box");
			String Show_Top_Chk_Box = Excel_data.get("Show_Top_Chk_Box");
			String Multi_Top_Chk_Box = Excel_data.get("Multi_Top_Chk_Box");
			String Show_Top_Input = Excel_data.get("Show_Top_Input");
			String equipmentType_Input = Excel_data.get("equipmentType_Input");
			String Multi_Select_Inputs = Excel_data.get("Multi_Select_Inputs");
			String Filter_Option = Excel_data.get("Filter_Option");
			String Condition =Excel_data.get("Condition");
			String two_Column_Search_Header =Excel_data.get("two_Column_Search_Header");

			Extent_Start(testCase_Name, test, test1);

			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);

			//select Equipment radio button
			Step_Start(1, " Select Equipment no radio button option to proceed further", test, test1);
			String Equip_Type_Select = String.format(Enquiry_History_Locators.Equip_Type_Select,  equipmentType_Input); 
			String Radio_Btn_Select = String.format(Enquiry_History_Locators.Radio_Btn_Select,  Container_Type_Radio_Button);
			waitForElement(driver, Equip_Type_DD);
			click(driver, Equip_Type_DD);
			waitForElement(driver, Equip_Type_Select);
			click(driver, Equip_Type_Select);
			//select Equipment radio button
			waitForElement(driver, Radio_Btn_Select);
			click(driver, Radio_Btn_Select);
			Step_End(1, " Select Equipment no radio button option to proceed further", test, test1);

			Step_Start(2, "Click Multi-Select checkbox to enter multiple equipment", test, test1);
			waitForElement(driver, P_equip_MultiSelect_CheckBox);
			checkBox(driver, P_equip_MultiSelect_CheckBox, Multi_Top_Chk_Box);
			Step_End(2, "Click Multi-Select checkbox to enter multiple equipment", test, test1);
			Step_Start(3, "Enter required container no for Equipment no field", test, test1);

			if(Multi_Top_Chk_Box.equals("YES")){
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs);
				for(String Multi_Sel_Value : Multi_Sel_Values) {
					waitForElement(driver, P_equipment_TxtField);
					click(driver, P_equipment_TxtField);
					sendKeys(driver, P_equipment_TxtField, Multi_Sel_Value);
					waitForElement(driver, P_equipment_SearchIcon);
					click(driver, P_equipment_SearchIcon);
					twoColumnSearchWindow(driver,two_Column_Search_Header,Condition, Multi_Sel_Value);
				}
			}else {
				waitForElement(driver, P_equipment_TxtField);
				click(driver, P_equipment_TxtField);
				sendKeys(driver, P_equipment_TxtField, equipmentNo_TxtField_Input);
				waitForElement(driver, P_equipment_SearchIcon);
				click(driver, P_equipment_SearchIcon);
				twoColumnSearchWindow(driver,two_Column_Search_Header,Condition,equipmentNo_TxtField_Input);
			}
			Step_End(3, "Enter required container no for Equipment no field", test, test1);
			waitForElement(driver, P_show_DltRec_ChkBox);
			checkBox(driver, P_show_DltRec_ChkBox, Show_Delete_Chk_Box);
			waitForElement(driver, P_suppressAct_CheckBox);
			checkBox(driver, P_suppressAct_CheckBox, Show_Suppress_Chk_Box);
			waitForElement(driver, P_Show_Top_CheckBox);
			checkBox(driver, P_Show_Top_CheckBox, Show_Top_Chk_Box);
			if(Show_Top_Chk_Box.equals("YES")){
				waitForElement(driver, P_Show_Top_Field);
				clearAndType(driver, P_Show_Top_Field, Show_Top_Input);
			}
			Step_Start(4, " click show button to get all movement details", test, test1);
			//click show button
			waitForElement(driver, P_show_Btn);
			click(driver, P_show_Btn);
			Step_End(4, "click show button to get all movement details", test, test1);
			Step_Start(5, "movement detail should shown in grid based on Equipment no", test, test1);
			if(Multi_Top_Chk_Box.equals("YES")){
				waitForElement(driver, P_Grid_NoOfRetrived);
				String abc=getText(driver, P_Grid_NoOfRetrived);
				System.out.println("abc : "+abc);
				int startIndex=abc.indexOf(':');
				int endIndex=abc.length();
				String numString=abc.substring(startIndex+1, endIndex).trim();
				int numberValue=Integer.parseInt(numString);
				System.out.println("numberValue : "+numberValue);
				int expectednumber =0; 
				for(int i=0;i<=numberValue+numberValue;i++) {
					String movementcode =  String.format(Enquiry_History_Locators.Grid_Movement_Codes,i);
					String movement_Code_text = getTextwithoutfail(driver, movementcode);
					if(!movement_Code_text.contains("Equipment No:") && !movement_Code_text.equals("null")) {
						expectednumber++;
					}else if(movement_Code_text.equals("null")) {
						break;
					}
					mouseOverToElement(driver, movementcode);
					click(driver, movementcode);
				}	

				waitForElement(driver, Tool_Bar_EH);
				click(driver, Tool_Bar_EH);
				waitForElement(driver, Condition_Filter_EH);
				click(driver, Condition_Filter_EH);
				waitForElement(driver, Movement_Filter_EH);
				sendKeys(driver, Movement_Filter_EH, Filter_Option);
				waitForElement(driver, Equipment_Number);
				List<WebElement> total_Values_Grid =listOfElements(driver, Equipment_Number);
				int Grid_Size = total_Values_Grid.size();
				int i=0;
				// check the movement details
				List<String> Multi_Sel_Values = splitAndExpand(Multi_Select_Inputs);
				int total_Input_Size = Multi_Sel_Values.size();
				for(String Multi_Sel_Value : Multi_Sel_Values) {
					String movement =  String.format(Enquiry_History_Locators.movement_Value,i); 
					waitForElement(driver, movement);
					String movementDetail=getText(driver, movement);
					if(Grid_Size==total_Input_Size) {
						if(Multi_Sel_Value.equals(movementDetail)) {
							System.out.println("Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail);
							Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail, test,test1);
						}else {
							System.out.println("Not Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail);
							Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Multi_Sel_Value + " || Actual Report Activity is : " + movementDetail, test,test1);
						}
						mouseOverToElement(driver, movement);
						click(driver, movement);
						i++;
					}else {
						System.out.println("Not Matched || Expected : All the values should be getting into the grid || Actual :  All the values are not getting into the grid");
						Extent_fail(driver, "Not Matched || Expected : All the values should be getting into the grid || Actual :  All the values are not getting into the grid", test,test1);
				}
				}	
				if(expectednumber==numberValue) {
					System.out.println("Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber);
					Extent_pass_New(driver, "Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber, test,test1);
				}else {
					System.out.println("Not Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber);
					Extent_fail(driver, "Not Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber, test,test1);
				}
			}else {
				waitForElement(driver, P_equipmentNo_Details);
				String movementDetail=getText(driver, P_equipmentNo_Details);
				if(equipmentNo_TxtField_Input.equals(movementDetail)) {
					System.out.println("Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail);
					Extent_pass_New(driver, "Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail, test,test1);
				}else {
					System.out.println("Not Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail);
					Extent_fail(driver, "Not Matched || " + " Expected number is : " + equipmentNo_TxtField_Input + " || Actual number is : " + movementDetail, test,test1);
				}
				waitForElement(driver, P_Grid_NoOfRetrived);
				String abc=getText(driver, P_Grid_NoOfRetrived);
				System.out.println("abc : "+abc);
				int startIndex=abc.indexOf(':');
				int endIndex=abc.length();
				String numString=abc.substring(startIndex+1, endIndex).trim();
				int numberValue=Integer.parseInt(numString);
				System.out.println("numberValue : "+numberValue);
				int expectednumber =0; 
				for(int i=0;i<=numberValue+numberValue;i++) {
					String movementcode =  String.format(Enquiry_History_Locators.Grid_Movement_Codes,i);
					String movement_Code_text = getTextwithoutfail(driver, movementcode);
					if(!movement_Code_text.contains("Equipment No:") && !movement_Code_text.equals("null")) {
						expectednumber++;
					}else if(movement_Code_text.equals("null")) {
						break;
					}
					mouseOverToElement(driver, movementcode);
					click(driver, movementcode);
				}	
				if(expectednumber==numberValue) {
					System.out.println("Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber);
					Extent_pass_New(driver, "Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber, test,test1);
				}else {
					System.out.println("Not Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber);
					Extent_fail(driver, "Not Matched || " + " Expected number is : " + numberValue + " || Actual number is : " + expectednumber, test,test1);
				}
			}
			Step_End(5, "movement detail should shown in grid based on Equipment no", test, test1);
			Extent_completed(testCase_Name, test, test1);
		}
	}
}
