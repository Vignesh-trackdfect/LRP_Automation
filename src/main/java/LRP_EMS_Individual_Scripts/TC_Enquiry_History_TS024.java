package LRP_EMS_Individual_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements_2;
import commonMethods.Keywords;


import locators.Enquiry_History_Locators;

public class TC_Enquiry_History_TS024 extends Keywords{

	public void EnquiryHistoryTS024(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testCase_Name="TC_Enquiry_History_TS024";

		String user_Name = Excel_data.get("Userid");
		String pass_word = Excel_data.get("PassWord");
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
		
		navigateUrl(driver, url);
		Extent_Start(testCase_Name, test, test1);
		//Login	
		LRP_Login(driver, user_Name, pass_word);
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
	}
}
