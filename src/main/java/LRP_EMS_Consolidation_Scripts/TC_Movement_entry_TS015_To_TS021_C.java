package LRP_EMS_Consolidation_Scripts;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Movement_entry_TS015_To_TS021_C extends Keywords{
	
	public void movemententry15to21 (WebDriver driver,ExtentTest test,ExtentTest test1, String selected_dataset) throws Exception {
		
		String testCaseName15="TC_Movement_Entry_TS_015";
		String File_Path15 = TestNgXml.getfilePath_FromExecution().get(testCaseName15);
		String Sheet_Name15 = TestNgXml.getsheetName_FromExecution().get(testCaseName15);
		String url = TestNgXml.getdatafromExecution().get("TC_Movement_entry_TS015_To_TS021_C");
		Map<String, String> Excel_data15 = Utils.GetAllData(Sheet_Name15, testCaseName15,
				"Dataset" + selected_dataset, File_Path15);
		String username = Excel_data15.get("Username");
		String password = Excel_data15.get("Password");
		
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
					
		boolean ts15=true;
		if(ts15==true) {
		
			String testCaseName="TC_Movement_Entry_TS_015";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName,"Dataset" + selected_dataset, File_Path);
			
			String moduleName = Excel_data.get("ModuleMovementEntry");
			String activityEqpEntry = Excel_data.get("ActivityEqpEntry");
			String eqpNo = Excel_data.get("EquipmentNo");
			String savedPopupText = Excel_data.get("SavedPopup");
			String activityDateSingle = Excel_data.get("ActivityDate");
			String activityHourSingle = Excel_data.get("ActivityHour");
			String datePicker=Excel_data.get("DatePicker");
			String Want_To_Delete = Excel_data.get("Want_To_Delete");

			Extent_Start(testCaseName, test, test1);

			Step_Start(1, "Enter the module name in the search box and click on the corresponding module from the list", test, test1);

//			Module Search
			
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter the module name in the search box and click on the corresponding module from the list", test, test1);
			Step_Start(2, "Input a valid container number in the Equipment No. field.", test, test1);
			// Movement Entry

			// Single Equipment Entry
			waitForDisplay(driver, singleEntryMovPage_L);

				waitForElement(driver, equipmentNoSearchField_L);
				sendKeys(driver, equipmentNoSearchField_L, eqpNo);

				Step_End(2, "Input a valid container number in the Equipment No. field.", test, test1);
				Step_Start(3, "Enter the given activity code in the data sheet and press Enter.", test, test1); 

				
				waitForElement(driver, activitySearchFieldInSingle_L);
				sendKeys(driver, activitySearchFieldInSingle_L, activityEqpEntry);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				Step_End(3, "Enter the given activity code in the data sheet and press Enter.", test, test1);
				Step_Start(4, "Select the appropriate date from the date picker.", test, test1);
				
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
				
				Step_End(4, "Select the appropriate date from the date picker.", test, test1);
				Step_Start(5, "Click \"Show Input Fields\", and if a confirmation prompt appears for the check digit, click \"Yes\" to proceed.", test, test1);

				waitForElement(driver, showInputSin_L);
				click(driver, showInputSin_L);

				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Yes_Button);
					
				}
				
				Step_End(5, "Click \"Show Input Fields\", and if a confirmation prompt appears for the check digit, click \"Yes\" to proceed.", test, test1);
				Step_Start(6, "Based on the provided data sheet, ensure the script fills the fields in the correct sequence.", test, test1);

				
				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, Excel_data, test, test1);
				
				Step_End(6, "Based on the provided data sheet, ensure the script fills the fields in the correct sequence.", test, test1);
				Step_Start(7, "Finally, click the \"Save\" button from the toolbar.", test, test1);

				scrollTop(driver);
				waitForElement(driver, equipmentNoSearchField_L);
				String ActualEqNo = getAttribute(driver, equipmentNoSearchField_L, "value");
				System.out.println("ActualEqNo:" + ActualEqNo);
				
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);

				Step_End(7, "Finally, click the \"Save\" button from the toolbar.", test, test1);
				Step_Start(8, "A \"Single Entry Save\" success message should be displayed upon successful submission.", test, test1);

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
				
				
				Extent_pass_New(driver, "Actual Equipment Number : "+ActualEqNo, test, test1);
				

				Step_End(8, "A \"Single Entry Save\" success message should be displayed upon successful submission.", test, test1);
				
				// Search

				waitForElement(driver, cancel_Common_btn);
				click(driver, cancel_Common_btn);

				newButton(driver);
				
				waitForElement(driver, equipmentNoSearchField_L);
				sendKeys(driver, equipmentNoSearchField_L, ActualEqNo);
				
				waitForElement(driver, showHistoryButton_L);
				click(driver, showHistoryButton_L);
				
				String retrieved_Record=String.format(retrieved_Equipment_Number, ActualEqNo);
				waitForElement(driver, retrieved_Record);

				String actSaved = getText(driver, retrieved_Record);
				if (actSaved.equals(ActualEqNo)) {
					System.out.println("Matched || " + "Single Movement Entry is saved || " + " Expected Equipment Number is : "
							+ ActualEqNo + " || Actual Equipment Number is : " + actSaved);

					Extent_pass_New(driver, "Matched || " + "Single Movement Entry is saved || " + " Expected Equipment Number is : "
							+ ActualEqNo + " || ActualEquipment Number is : " + actSaved+"\r\n"+"Single Movement Entry is saved", test, test1);
				} else {
					System.out.println("Not matched || " + "Single Movement Entry is not saved || "
							+ " Expected Equipment Number is : " + ActualEqNo + " || Actual Equipment Number  is : " + actSaved);

					Extent_fail(driver, "Not matched || " + "Single Movement Entry is not saved ||"
							+ " Expected Equipment Number is : " + ActualEqNo + " || Actual Equipment Number is : " + actSaved+"\r\n"+"Single Movement Entry not saved", test, test1);
				}

				if(Want_To_Delete.equalsIgnoreCase("Yes")) {

				waitForElement(driver, equipmentDetails_Grid_First_Row);
				RightClick(driver, equipmentDetails_Grid_First_Row);
				
				
				waitForElement(driver, deleteOpionSingle_L);
				click(driver, deleteOpionSingle_L);
				
				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message_Yes_Button)) {
					click(driver, popup_Message_Yes_Button);
				}
					
				waitForDisplay(driver, popup_Message);
				if (isdisplayed(driver, popup_Message_Ok_Button)) {
					click(driver, popup_Message_Ok_Button);
				}

				}
			
			Extent_completed(testCaseName, test, test1);
			
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		}
		
		boolean ts16=true;
		
		if(ts16==true) {
			String testCaseName="TC_Movement_Entry_TS_016";

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName,
					"Dataset" + selected_dataset, File_Path);

			String moduleName = Excel_data.get("ModuleMovementEntry");
			String activityEqpEntryMulti = Excel_data.get("ActivityEqpEntry");
			String activityDate = Excel_data.get("ActivityDate");
			String eqpNoMulti_1 = Excel_data.get("EquipmentNumbers");
			String multiSavedPopup = Excel_data.get("MultipleSavedPopup");
			String activityHour = Excel_data.get("ActivityHour");
			String datePicker = Excel_data.get("DatePicker");
			String Want_To_Delete = Excel_data.get("Want_To_Delete");
			String DuplicatedContainer = Excel_data.get("Duplicated_Container");
			String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
			String dropdownCondition = Excel_data.get("DropdownCondition");
			
			Extent_Start(testCaseName, test, test1);
			
			Step_Start(1, "Enter the module name in the search box and click on the desired module.", test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter the module name in the search box and click on the desired module.", test, test1);

			// Multiple Equipment Entry

			Step_Start(2, "Click the Multiple Equipment Entry tab to proceed.", test, test1);
			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);
			waitForDisplay(driver, multiEntryMovPage_L);

				Step_End(2, "Click the Multiple Equipment Entry tab to proceed.", test, test1);
				Step_Start(3, "Enter the activity code and press Enter.", test, test1);
				
				waitForElement(driver, activitySearchField_L);
				sendKeys(driver, activitySearchField_L, activityEqpEntryMulti);
				waitForElement(driver, autoCompleteValue_ME);
				enter(driver);
				
				Step_End(3, "Enter the activity code and press Enter.", test, test1);
				Step_Start(4, "Select the required date from the date picker.", test, test1);
				
				waitForElement(driver, activeDateField_L);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateField_L, activityDate);

				} else {
					if (activityDate.contains("-")) {
						click(driver, activeDateField_L);

						String activityDate_1 = activityDate.replace("-", "/");

						clearAndType(driver, activeDateField_L, activityDate_1);

					} else {
						click(driver, activeDateField_L);

						clearAndType(driver, activeDateField_L, activityDate);

					}
				}

				if (!activityHour.equals("")) {
					waitForElement(driver, activityTimeMultiple);
					click(driver, activityTimeMultiple);

					waitForElement(driver, Calender);
					if (isDisplayed(driver, Calender)) {
						click(driver, activityTime_Input);
						waitForElement(driver, activityTime_Input);

						click(driver, activityTime_Input);
						waitForElement(driver, activity_Time);
						clearAndType(driver, activity_Time, activityHour);
						waitForElement(driver, activityTime_Close);
						click(driver, activityTime_Close);

					}

				} 
				Step_End(4, "Select the required date from the date picker.", test, test1);

				Step_Start(5, "Click the Show Input button to continue.", test, test1);

				waitForElement(driver, showInputButton);
				click(driver, showInputButton);

				Step_End(5, "Click the Show Input button to continue.", test, test1);
				Step_Start(6, "Based on the provided data sheet, ensure the script fills in the fields in the correct sequence.", test, test1);
				
				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, Excel_data, test, test1);
				
				Step_End(6, "Based on the provided data sheet, ensure the script fills in the fields in the correct sequence.", test, test1);
				
				Step_Start(7, "Once all required fields are entered, click the Add button.", test, test1);
				
				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);

				Step_End(7, "Once all required fields are entered, click the Add button.", test, test1);
				Step_Start(8, "Enter a valid container number in the Equipment No. field within the grid.", test, test1);
				
				String equipmentNumber_Add=String.format(equipmentNumber_Grid_Textfield, 0);
				String equipmentNumber_Input_Add=String.format(equipmentNumber_Grid_Input_Textfield, 0);

				waitForElement(driver, equipmentNumber_Add);
				scrollUsingElement(driver, equipmentNumber_Add);
				waitForElement(driver, equipmentNumber_Add);
				click(driver, equipmentNumber_Add);

				StringSelection stringSelection = new StringSelection(eqpNoMulti_1);
		        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		        
		        Actions action = new Actions(driver);
		        
		        waitForElement(driver, equipmentNumber_Input_Add);
				mouseOverToElement(driver, equipmentNumber_Input_Add);
				click(driver, equipmentNumber_Input_Add);
				action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
				enter(driver);
				
				Step_End(8, "Enter a valid container number in the Equipment No. field within the grid.", test, test1);

				List<WebElement> totalRows=new ArrayList<WebElement>();
				ArrayList<String> generated_Eqp_No=new ArrayList<String>();
				
				Step_Start(9, "Click the Save button. The system should then display a confirmation message indicating that the data has been saved successfully.", test, test1);

				scrollTop(driver);
				scrollTop(driver);

				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);

				String duplicated_Container=String.format(Duplicated_Container, DuplicatedContainer);
				waitForDisplay(driver, errorRecordsFrame_L);
				if (isdisplayed(driver, errorRecordsFrame_L)) {
					
					if(isdisplayed(driver, duplicated_Container)) {
						click(driver, errorRecApply_L);
						
						scrollTop(driver);
						waitForElement(driver, SaveButton_ToolBar);
						click(driver, SaveButton_ToolBar);
					}
					
					waitForDisplay(driver, Apply_Check_Digit_Button);
					if (isdisplayed(driver, Apply_Check_Digit_Button)) {
						click(driver, Apply_Check_Digit_Button);

						waitForElement(driver, equipmentDetails_Table_Row);
						totalRows = listOfElements(driver, equipmentDetails_Table_Row);
						
						for(int i=1;i<=totalRows.size();i++) {
							String equipmentNumber_Gridcell=String.format(equipmentDetails_Table_Row_Eqp_No, i);
						
						waitForDisplay(driver, equipmentNumber_Gridcell);
						scrollElementToCenter(driver, equipmentNumber_Gridcell);
						waitForDisplay(driver, equipmentNumber_Gridcell);
						String actualEqpNumber = getText(driver, equipmentNumber_Gridcell);
						Extent_pass_New(driver, "Actual Equipment Number "+(i)+" : "+actualEqpNumber, test, test1);
						generated_Eqp_No.add(actualEqpNumber);
						}
						
					}
					
				
				
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				}else {
					
					waitForElement(driver, equipmentDetails_Table_Row);
					totalRows = listOfElements(driver, equipmentDetails_Table_Row);
					
					for(int i=1;i<=totalRows.size();i++) {
						String equipmentNumber_Gridcell=String.format(equipmentDetails_Table_Row_Eqp_No, i);
					
					waitForDisplay(driver, equipmentNumber_Gridcell);
					scrollElementToCenter(driver, equipmentNumber_Gridcell);
					waitForDisplay(driver, equipmentNumber_Gridcell);
					String actualEqpNumber = getText(driver, equipmentNumber_Gridcell);
					Extent_pass_New(driver, "Actual Equipment Number "+(i)+" : "+actualEqpNumber, test, test1);
					generated_Eqp_No.add(actualEqpNumber);
					}
				}
				waitForPopup(driver, popup_Message, multiSavedPopup);
				
					String actText = getText(driver, popup_Message);
					if (actText.equals(multiSavedPopup)) {
						System.out.println("Matched || " + " Expected Popup is : " + multiSavedPopup
								+ " || Actual Popup is : " + actText);
						Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + multiSavedPopup
								+ " || Actual Popup is : " + actText+"<br>"+multiSavedPopup + " popup is displayed", test, test1);
						click(driver, popup_Message_Ok_Button);
					} else {
						System.out.println("Not matched || " + " Expected Popup is : " + multiSavedPopup
								+ " || Actual Popup  is : " + actText);

						Extent_fail(driver, "Not matched || " + " Expected Popup is : " + multiSavedPopup
								+ " || Actual Popup is : " + actText+"<br>"+multiSavedPopup + " popup is not displayed", test, test1);
					}

				
				Step_End(9, "Click the Save button. The system should then display a confirmation message indicating that the data has been saved successfully.", test, test1);

				if(Want_To_Delete.equalsIgnoreCase("Yes")) {
				for(int i=0;i<totalRows.size();i++) {
				String actual_Eqp_No=generated_Eqp_No.get(i);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, actual_Eqp_No, "", "", "", "");
				
				waitForElement(driver, equipmentDetails_Grid_First_Row);
				RightClick(driver, equipmentDetails_Grid_First_Row);
				
				waitForElement(driver, multiDeleteOption_L);
				click(driver, multiDeleteOption_L);
				

				if (isDisplayed(driver, popup_Message_Yes_Button)) {
					click(driver, popup_Message_Yes_Button);
				}
				if (isDisplayed(driver, popup_Message_Ok_Button)) {
					click(driver, popup_Message_Ok_Button);
				}
				}
				}
			Extent_completed(testCaseName, test, test1);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		
		boolean ts17=true;
		if(ts17==true) {
		
			String testCaseName="TC_Movement_Entry_TS_017";
//			Get data from excel sheet

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName,"Dataset" + selected_dataset, File_Path);

			String eqpNoSingleEdit = Excel_data.get("EquipmentNo");
			String uptadedSinglePopup = Excel_data.get("UpdatedPopup");
			String moduleName = Excel_data.get("ModuleMovementEntry");
			String movement_Code = Excel_data.get("Movement_Code");

			Extent_Start(testCaseName, test, test1);

			Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//			Search module
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter module name in searchbox & click the module", test, test1);

			
			// Movement Entry
			
			Step_Start(2, "Enter the required container number and click on \"Show History\".", test, test1);
			// Single Equipment Entry
			waitForDisplay(driver, singleEntryMovPage_L);

			waitForElement(driver, equipmentNoSearchField_L);
				sendKeys(driver, equipmentNoSearchField_L, eqpNoSingleEdit);

				waitForElement(driver, showHistoryButton_L);
				click(driver, showHistoryButton_L);

				Step_End(2, "Enter the required container number and click on \"Show History\".", test, test1);

				Step_Start(3, "Right-click on the activity code specified in the data sheet.", test, test1);
				
				waitForElement(driver, movementCode_Grid_Filter);
				click(driver, movementCode_Grid_Filter);
				waitForElement(driver, movementCode_Grid_Filter);
				sendKeys(driver, movementCode_Grid_Filter, movement_Code);
				
				
				waitForElement(driver, eqpNoInEqpDetails_L);
				String actSaved = getText(driver, eqpNoInEqpDetails_L);
				if (actSaved.equals(eqpNoSingleEdit)) {
					System.out.println("Matched || " + " Expected Value is : " + eqpNoSingleEdit + " || Actual Value is : "+ actSaved);
					Extent_pass_New(driver,
							"Matched || Equipment number is retrieved || " + " Expected Value is : " + eqpNoSingleEdit + " || ActualValue is : " + actSaved,
							test, test1);

					waitForDisplay(driver, eqpNoInEqpDetails_L);
					RightClick(driver, eqpNoInEqpDetails_L);
					
					Step_End(3, "Right-click on the activity code specified in the data sheet.", test, test1);
					Step_Start(4, "Click the \"Edit\" button to open the activity details.", test, test1);
					
					waitForElement(driver, singleEdit_2);
					click(driver, singleEdit_2);
					
					Step_End(4, "Click the \"Edit\" button to open the activity details.", test, test1);

				} else {
					System.out.println("Not matched || " + " Expected Value is : " + eqpNoSingleEdit
							+ " || Actual Value  is : " + actSaved);
					Extent_fail(driver, "Not matched || Equipment number not retrieved || " + " Expected Value is : " + eqpNoSingleEdit
							+ " || Actual Value is : " + actSaved, test, test1);
				}
				
				Step_Start(5, "Clear the existing data and enter the new values as provided in the data sheet.", test, test1);

				Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
				allElements.movementEntryAllElements(driver, Excel_data, test, test1);
				
				Step_End(5, "Clear the existing data and enter the new values as provided in the data sheet.", test, test1);
				Step_Start(6, "Click \"Save\", and the system should display a confirmation message indicating the update was successful.", test, test1);

				waitForElement(driver, equipmentNoSearchField_L);
				String ActualEqNo = getAttribute(driver, equipmentNoSearchField_L, "value");
				System.out.println("ActualEqNo:" + ActualEqNo);
				
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);

				waitForPopup(driver, popup_Message, uptadedSinglePopup);
				String actPopupText = getText(driver, popup_Message);
				if (actPopupText.equals(uptadedSinglePopup)) {
					System.out.println("Matched || " + " Expected Popup is : " + uptadedSinglePopup
							+ " || Actual Popup is : " + actPopupText);

					Extent_pass_New(driver, "Matched || "+uptadedSinglePopup + " popup is displayed" + " || Expected Popup is : " + uptadedSinglePopup
							+ " || Actual Popup is : " + actPopupText, test, test1);
					click(driver, popup_Message_Ok_Button);

				} else {
					System.out.println("Not matched || " + " Expected Popup is : " + uptadedSinglePopup
							+ " || Actual Popup  is : " + actPopupText);

					Extent_fail(driver, "Not matched || "+uptadedSinglePopup + " popup is not displayed" + "|| Expected Popup is : " + uptadedSinglePopup
							+ " || Actual Popup is : " + actPopupText, test, test1);
				}


				Step_End(6, "Click \"Save\", and the system should display a confirmation message indicating the update was successful.", test, test1);

			Extent_completed(testCaseName, test, test1);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		
		boolean ts18=true;
		if(ts18==true) {

			String testCaseName="TC_Movement_Entry_TS_018";
//			Get data from excel sheet

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName,
					"Dataset" + selected_dataset, File_Path);
			String moduleName = Excel_data.get("ModuleMovementEntry");
			String updatedPopupMulti = Excel_data.get("MultiUpdatedPopup");
			String movement_Code = Excel_data.get("Movement_Code");
			String GlobalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
			String dropdownCondition_Date = Excel_data.get("dropdownCondition_Date");
			String dropdown_Condition = Excel_data.get("Dropdown_Condition");

			String GlobalSearchFilterOption2 = Excel_data.get("GlobalSearchFilterOption2");
			String GlobalSearchFilterOption3= Excel_data.get("GlobalSearchFilterOption3");
			String Search_Input1 = Excel_data.get("RetrieveEqpNo");
			String Search_Input2 = Excel_data.get("Movement_Code");
			String Search_Input3= Excel_data.get("Activity_Date");
			String thirtyTon = Excel_data.get("30Ton");
			String Location = Excel_data.get("Location");
			String Terminal = Excel_data.get("TermDepot");
			String Booking_NO=Excel_data.get("Booking_NO");
			String Bound = Excel_data.get("Bound");
			String CargoWeight = Excel_data.get("CargoWeight");
			String CarrierSeal = Excel_data.get("CarrierSeal");
			String Condition_Input = Excel_data.get("Condition_Input");
			String ConsigneeName = Excel_data.get("ConsigneeName");
			String CSC_Ref_NO = Excel_data.get("CSC_Ref_NO");
			String CSC_Date = Excel_data.get("CSC_Date");
			String CubicCapacity = Excel_data.get("CubicCapacity");
			String Customer = Excel_data.get("Customer");
			String CustomerDate = Excel_data.get("CustomerDate");
			String D_I = Excel_data.get("D/I");
			String D_I_From = Excel_data.get("D_I_From");
			String D_I_To = Excel_data.get("D_I_To");
			String Delivery_Input = Excel_data.get("Delivery_Input");
			String DeliveryDate = Excel_data.get("DeliveryDate");
			String DeliveryService = Excel_data.get("DeliveryService");

			String DEST = Excel_data.get("DEST");
			String Domicile = Excel_data.get("Domicile");
			String Driver = Excel_data.get("Driver");
			String EquipmentStatus = Excel_data.get("EquipmentStatus");
			String F_L_M = Excel_data.get("F_L_M");
			String FleetGroup = Excel_data.get("FleetGroup");
			String ForkPocket = Excel_data.get("ForkPocket");
			String FromService = Excel_data.get("FromService");
			String LinkedGenset = Excel_data.get("LinkedGenset");
			String Genset_PowerpackNo = Excel_data.get("Genset_PowerpackNo");
			String GrossWeight = Excel_data.get("GrossWeight");
			String Haulage = Excel_data.get("Haulage");
			String Haulier = Excel_data.get("Haulier");
			String Height = Excel_data.get("Height");
			String Helper_S = Excel_data.get("Helper_S");
			String IMO = Excel_data.get("IMO");
			String InjectionPort = Excel_data.get("InjectionPort");
			String ISO_Code = Excel_data.get("ISO_Code");
			String LeaseKind = Excel_data.get("LeaseKind");
			String Lessee = Excel_data.get("Lessee");
			String Lessor = Excel_data.get("Lessor");
			String LicenseNo = Excel_data.get("LicenseNo");
			String Maker = Excel_data.get("Maker");
			String manufactureDate = Excel_data.get("ManufactureDate");
			String Material = Excel_data.get("Material");
			String MovementType_Code = Excel_data.get("MovementType_Code");
			String O_H_Input = Excel_data.get("O_H_Input");
			String O_L_Input = Excel_data.get("O_L_Input");
			String O_W_Input = Excel_data.get("O_W_Input");
			String O_W_Amount = Excel_data.get("O_W_Amount");
			String O_W_Ind = Excel_data.get("O_W_Ind");
			String Owned = Excel_data.get("Owned");
			String PayLoad = Excel_data.get("PayLoad");

			String PlateNo = Excel_data.get("PlateNo");
			String pod_Input = Excel_data.get("Pod_Input");
			String pol_Input = Excel_data.get("Pol_Input");
			String PoolCode = Excel_data.get("PoolCode");
			String ReasonCode = Excel_data.get("ReasonCode");
			String Redel_Date = Excel_data.get("Redel_Date");
			String Redel_Place = Excel_data.get("Redel_Place");
			String refNumber= Excel_data.get("RefNumber");
			String release_Ref_No= Excel_data.get("Release_Ref_No");
			String ReturnDate= Excel_data.get("ReturnDate");
			String Return_Place= Excel_data.get("Return_Place");
			String Return_Ref_No= Excel_data.get("Return_Ref_No");
			String Return_to_Fleet= Excel_data.get("Return_to_Fleet");
			String Service= Excel_data.get("Service");
			String To_Service= Excel_data.get("To_Service");
			String Shipper= Excel_data.get("Shipper");
			String ShipperOwned= Excel_data.get("ShipperOwned");
			String ShipperSeal= Excel_data.get("ShipperSeal");
			String ShippingLine= Excel_data.get("ShippingLine");
			String Stopping_Point= Excel_data.get("Stopping_Point");
			String Stowage= Excel_data.get("Stowage");
			String SubLease_Ref= Excel_data.get("SubLease_Ref");
			String SupplierContract= Excel_data.get("SupplierContract");
			String Survey_Date= Excel_data.get("Survey_Date");
			String Surveyor= Excel_data.get("Surveyor");
			String T_S= Excel_data.get("T_S");
			String Tare= Excel_data.get("Tare");
			String TCT= Excel_data.get("TCT");
			String TDN_Number= Excel_data.get("TDN_Number");
			String Temp= Excel_data.get("Temp");
			String TIR= Excel_data.get("TIR");
			String To_Term_Depot= Excel_data.get("To_Term_Depot");
			String To_Place= Excel_data.get("To_Place");

			String Trade= Excel_data.get("Trade");
			String TransportService= Excel_data.get("TransportService");
			String Trucker= Excel_data.get("Trucker");
			String UNNO= Excel_data.get("UNNO");
			String VanLocation= Excel_data.get("VanLocation");
			String Vessel_Input= Excel_data.get("Vessel_Input");
			String VIA= Excel_data.get("VIA");
			String Voyage_Input= Excel_data.get("Voyage_Input");
			String Remarks_Input= Excel_data.get("Remarks_Input");
			String sizeType= Excel_data.get("SizeType");
			String BLNO = Excel_data.get("BLNO");
			
			
			Extent_Start(testCaseName, test, test1);
			
			Step_Start(1, "Enter the module name in the search box and select the corresponding module.", test, test1);

//			Search module
			moduleNavigate(driver, moduleName);
			
			// Movement Entry
			
			Step_End(1, "Enter the module name in the search box and select the module.", test, test1);
			Step_Start(2, "Choose the Multiple Equipment Entry option.", test, test1);
			
			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);

			waitForDisplay(driver, multiEntryMovPage_L);
				
				Step_End(2, "Choose the Multiple Equipment Entry option.", test, test1);
				Step_Start(3, "Click on the Global Search icon in the toolbar", test, test1);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				Step_End(3, "Click on the Global Search icon in the toolbar", test, test1);
				Step_Start(4, "Fill in the required filter fields such as Equipment Number, Movement Code, and Activity Date.", test,test1);
				
				
				if (!Search_Input1.equals("")) {
					waitForElement(driver, type_Select1);
					selectByText(driver, type_Select1, GlobalSearchFilterOption1);
					waitForDisplay(driver, type_Select1);
					selectByText(driver, globalSearch_Condition_Dropdown1, dropdown_Condition);
					waitForDisplay(driver, globalSearch_InputTextfield1);
					sendKeys(driver, globalSearch_InputTextfield1, Search_Input1);
				}
				if (!Search_Input2.equals("")) {
					waitForElement(driver, type_Select2);
					selectByText(driver, type_Select2, GlobalSearchFilterOption2);
					waitForDisplay(driver, type_Select2);
					selectByText(driver, globalSearch_Condition_Dropdown2, dropdown_Condition);
					waitForDisplay(driver, globalSearch_InputTextfield2);
					sendKeys(driver, globalSearch_InputTextfield2, Search_Input2);
				}
				if (!Search_Input3.equals("")) {
					waitForElement(driver, type_Select3);
					selectByText(driver, type_Select3, GlobalSearchFilterOption3);
					waitForDisplay(driver, Roe_Date_Condition);
					selectByText(driver, Roe_Date_Condition, dropdownCondition_Date);
					waitForDisplay(driver, Roe_Date_Field);
					sendKeys(driver, Roe_Date_Field, Search_Input3);
				}
				
				Step_End(4, "Fill in the required filter fields such as Equipment Number, Movement Code, and Activity Date.", test,test1);
				Step_Start(5, "Click the Search button to display the relevant results.", test, test1);
				
				waitForElement(driver, globalSearch_Frame_SearchButton);
				click(driver, globalSearch_Frame_SearchButton);
				
				Step_End(5, "Click the Search button to display the relevant results.", test, test1);

				waitForElement(driver, SelectButton);
				click(driver, SelectButton);
				elementnotvisible1(driver, SelectButton);
				
				Step_Start(6, "Select the rows to edit", test, test1);

					
					waitForElement(driver, movementCode_Grid_Filter);
					click(driver, movementCode_Grid_Filter);
					waitForElement(driver, movementCode_Grid_Filter);
					sendKeys(driver, movementCode_Grid_Filter, movement_Code);
					
					waitForElement(driver, equipmentDetails_Table_Row);
					click(driver, equipmentDetails_Table_Row);
					
					Actions actions=new Actions(driver);
					actions.keyDown(Keys.SHIFT).perform();
					waitForDisplay(driver, equipmentDetails_Table_Last_Row);
					scrollElementToCenter(driver, equipmentDetails_Table_Last_Row);
					waitForElement(driver, equipmentDetails_Table_Last_Row);
					click(driver, equipmentDetails_Table_Last_Row);
					actions.keyUp(Keys.SHIFT).perform();

					Step_End(6, "Select the rows to edit", test, test1);
					Step_Start(7, "Right-click on the yellow-highlighted area and choose the Edit option.", test, test1);
					
					waitForElement(driver, eqpNoInEqpDetails_L);
					RightClick(driver, eqpNoInEqpDetails_L);
					waitForElement(driver, editOption_L);
					click(driver, editOption_L);

					Step_End(7, "Right-click on the yellow-highlighted area and choose the Edit option.", test, test1);
				
				// Edit
				waitForElement(driver, showInputFieldFrame_L);

					String locBefore1 = getAttribute(driver, location_Textfield_ME, "value");
					String termBefore1 = getAttribute(driver, term_Depot_Textfield_ME, "value");
					System.out.println("Location before edit:" + locBefore1);
					System.out.println("Terminal before edit:" + termBefore1);

					Step_Start(8, "Clear the existing data and enter the updated information as per the data sheet.", test, test1);

					Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
					allElements.movementEntryAllElements(driver, Excel_data, test, test1);
					

	// Select required Checkbox to edit
					

					waitForElement(driver, editButtonMultiMove_L);
					click(driver, editButtonMultiMove_L);
					
					waitForElement(driver, selectCheckboxFrame_L);
					if (isDisplayed(driver, selectCheckboxFrame_L)) {
						
						if(!thirtyTon.equals("")) {
							 
							scrollElementToCenter(driver, thirtyDon_CheckBox);
							waitForElement(driver, thirtyDon_CheckBox);
							click(driver, thirtyDon_CheckBox);

							}
						
						if(!Location.equals("")) {
						 
						scrollElementToCenter(driver, activePlaceCheckbox_L);
						waitForElement(driver, activePlaceCheckbox_L);
						click(driver, activePlaceCheckbox_L);

						}
						if(!Terminal.equals("")) {
							 
							scrollElementToCenter(driver, depotCheckbox_L);
							waitForElement(driver, depotCheckbox_L);
							click(driver, depotCheckbox_L);
						}
						
						if(!sizeType.equals("")) {
							 
							scrollElementToCenter(driver, sizeTypeCheckBox_L);
							waitForElement(driver, sizeTypeCheckBox_L);
							click(driver, sizeTypeCheckBox_L);
						}
						if(!ISO_Code.equals("")) {
							 
							scrollElementToCenter(driver, isoCheckBox_L);
							waitForElement(driver, isoCheckBox_L);
							click(driver, isoCheckBox_L);
						}
						if(!LeaseKind.equals("")) {
							 
							scrollElementToCenter(driver, leaseKind_CheckBox);
							waitForElement(driver, leaseKind_CheckBox);
							click(driver, leaseKind_CheckBox);
						}
						if(!Lessor.equals("")) {
							 
							scrollElementToCenter(driver, lessor_CheckBox);
							waitForElement(driver, lessor_CheckBox);
							click(driver, lessor_CheckBox);
						}
						if(!Lessee.equals("")) {
							 
							scrollElementToCenter(driver, lessee_CheckBox);
							waitForElement(driver, lessee_CheckBox);
							click(driver, lessee_CheckBox);
						}
						if(!Remarks_Input.equals("")) {
							 
							scrollElementToCenter(driver, remark_ChecBox);
							waitForElement(driver, remark_ChecBox);
							click(driver, remark_ChecBox);
						}
						if(!release_Ref_No.equals("")) {
							 
							scrollElementToCenter(driver, releaseRefCheckBox_L);
							waitForElement(driver, releaseRefCheckBox_L);
							click(driver, releaseRefCheckBox_L);
						}
						if(!PayLoad.equals("")) {
							 
							scrollElementToCenter(driver, payLoad_Checkbox_L);
							waitForElement(driver, payLoad_Checkbox_L);
							click(driver, payLoad_Checkbox_L);
						}
						if(!GrossWeight.equals("")) {
							 
							scrollElementToCenter(driver, grossWeihgt_Checkbox_L);
							waitForElement(driver, grossWeihgt_Checkbox_L);
							click(driver, grossWeihgt_Checkbox_L);
						}
						if(!SupplierContract.equals("")) {
							 
							scrollElementToCenter(driver, supplierContract_CheckBox);
							waitForElement(driver, supplierContract_CheckBox);
							click(driver, supplierContract_CheckBox);
						}
						if(!manufactureDate.equals("")) {
							 
							scrollElementToCenter(driver, manufactureDate_CheckBox);
							waitForElement(driver, manufactureDate_CheckBox);
							click(driver, manufactureDate_CheckBox);
						}
						if(!refNumber.equals("")) {
							 
							scrollElementToCenter(driver, refNumber_CheckBox);
							waitForElement(driver, refNumber_CheckBox);
							click(driver, refNumber_CheckBox);
						}
						
						
						if(!BLNO.equals("")) {
							 
							scrollElementToCenter(driver, blNo_ChecBox);
							waitForElement(driver, blNo_ChecBox);
							click(driver, blNo_ChecBox);

							}
						
						if(!Booking_NO.equals("")) {
							 
							scrollElementToCenter(driver, Booking_No_Checkbox_L);
							waitForElement(driver, Booking_No_Checkbox_L);
							click(driver, Booking_No_Checkbox_L);

							}
						
						if(!Bound.equals("")) {
							 
							scrollElementToCenter(driver, Bound_Checkbox_L);
							waitForElement(driver, Bound_Checkbox_L);
							click(driver, Bound_Checkbox_L);

							}
						
						if(!CargoWeight.equals("")) {
							 
							scrollElementToCenter(driver, CargoWeight_Checkbox_L);
							waitForElement(driver, CargoWeight_Checkbox_L);
							click(driver, CargoWeight_Checkbox_L);

							}
						
						if(!CargoWeight.equals("")) {
							 
							scrollElementToCenter(driver, Carrier_Seal_Checkbox_L);
							waitForElement(driver, Carrier_Seal_Checkbox_L);
							click(driver, Carrier_Seal_Checkbox_L);

							}
						
						if(!CarrierSeal.equals("")) {
							 
							scrollElementToCenter(driver, releaseRefCheckBox_L);
							waitForElement(driver, releaseRefCheckBox_L);
							click(driver, releaseRefCheckBox_L);
						}
						
						if(!Condition_Input.equals("")) {
							 
							scrollElementToCenter(driver, Condition_Checkbox_L);
							waitForElement(driver, Condition_Checkbox_L);
							click(driver, Condition_Checkbox_L);
						}
						
						if(!ConsigneeName.equals("")) {
							 
							scrollElementToCenter(driver, Consignee_Checkbox_L);
							waitForElement(driver, Consignee_Checkbox_L);
							click(driver, Consignee_Checkbox_L);
						}
						
						if(!CSC_Ref_NO.equals("")) {
							 
							scrollElementToCenter(driver, CSC_Checkbox_L);
							waitForElement(driver, CSC_Checkbox_L);
							click(driver, CSC_Checkbox_L);
						}
						
						if(!CSC_Date.equals("")) {
							 
							scrollElementToCenter(driver, CSC_Date_Checkbox_L);
							waitForElement(driver, CSC_Date_Checkbox_L);
							click(driver, CSC_Date_Checkbox_L);
						}
						
						if(!CubicCapacity.equals("")) {
							 
							scrollElementToCenter(driver, Cubic_Capacity_Checkbox_L);
							waitForElement(driver, Cubic_Capacity_Checkbox_L);
							click(driver, Cubic_Capacity_Checkbox_L);
						}
						if(!Customer.equals("")) {
							 
							scrollElementToCenter(driver, Customer_Checkbox_L);
							waitForElement(driver, Customer_Checkbox_L);
							click(driver, Customer_Checkbox_L);
						}
						
					
						if(!CustomerDate.equals("")) {
							 
							scrollElementToCenter(driver, Customer_Date_Checkbox_L);
							waitForElement(driver, Customer_Date_Checkbox_L);
							click(driver, Customer_Date_Checkbox_L);
						}
						
						if(!D_I.equals("")) {
							 
							scrollElementToCenter(driver, D_I_Checkbox_L);
							waitForElement(driver, D_I_Checkbox_L);
							click(driver, D_I_Checkbox_L);
						}
						
						if(!D_I_From.equals("")) {
							 
							scrollElementToCenter(driver, D_I_From_Checkbox_L);
							waitForElement(driver, D_I_From_Checkbox_L);
							click(driver, D_I_From_Checkbox_L);
						}
						if(!D_I_To.equals("")) {
							 
							scrollElementToCenter(driver, D_I_To_Checkbox_L);
							waitForElement(driver, D_I_To_Checkbox_L);
							click(driver, D_I_To_Checkbox_L);
						}
						if(!Delivery_Input.equals("")) {
							 
							scrollElementToCenter(driver, Delivery_Checkbox_L);
							waitForElement(driver, Delivery_Checkbox_L);
							click(driver, Delivery_Checkbox_L);
						}
						if(!DeliveryDate.equals("")) {
							 
							scrollElementToCenter(driver, Delivery_Date_Checkbox_L);
							waitForElement(driver, Delivery_Date_Checkbox_L);
							click(driver, Delivery_Date_Checkbox_L);
						}
						if(!DeliveryService.equals("")) {
							 
							scrollElementToCenter(driver, Delivery_Service_Checkbox_L);
							waitForElement(driver, Delivery_Service_Checkbox_L);
							click(driver, Delivery_Service_Checkbox_L);
						}
						if(!DEST.equals("")) {
							 
							scrollElementToCenter(driver, Destination_Checkbox_L);
							waitForElement(driver, Destination_Checkbox_L);
							click(driver, Destination_Checkbox_L);
						}
						if(!Domicile.equals("")) {
							 
							scrollElementToCenter(driver, Domicile_Checkbox_L);
							waitForElement(driver, Domicile_Checkbox_L);
							click(driver, Domicile_Checkbox_L);
						}
						if(!Driver.equals("")) {
							 
							scrollElementToCenter(driver, Driver_Checkbox_L);
							waitForElement(driver, Driver_Checkbox_L);
							click(driver, Driver_Checkbox_L);
						}
						if(!EquipmentStatus.equals("")) {
							 
							scrollElementToCenter(driver, Equipment_Status_Checkbox_L);
							waitForElement(driver, Equipment_Status_Checkbox_L);
							click(driver, Equipment_Status_Checkbox_L);
						}
						if(!F_L_M.equals("")) {
							 
							scrollElementToCenter(driver, F_L_M_Checkbox_L);
							waitForElement(driver, F_L_M_Checkbox_L);
							click(driver, F_L_M_Checkbox_L);
						}
						if(!FleetGroup.equals("")) {
							 
							scrollElementToCenter(driver, Fleet_Group_Checkbox_L);
							waitForElement(driver, Fleet_Group_Checkbox_L);
							click(driver, Fleet_Group_Checkbox_L);
						}
						if(!ForkPocket.equals("")) {
							 
							scrollElementToCenter(driver, Fork_Pocket_Checkbox_L);
							waitForElement(driver, Fork_Pocket_Checkbox_L);
							click(driver, Fork_Pocket_Checkbox_L);
						}
						if(!FromService.equals("")) {
							 
							scrollElementToCenter(driver, From_Service_Checkbox_L);
							waitForElement(driver, From_Service_Checkbox_L);
							click(driver, From_Service_Checkbox_L);
						}
						if(!Genset_PowerpackNo.equals("")) {
							 
							scrollElementToCenter(driver, Genset_Number_Checkbox_L);
							waitForElement(driver, Genset_Number_Checkbox_L);
							click(driver, Genset_Number_Checkbox_L);
						}
						if(!Haulage.equals("")) {
							 
							scrollElementToCenter(driver, Haulage_Checkbox_L);
							waitForElement(driver, Haulage_Checkbox_L);
							click(driver, Haulage_Checkbox_L);
						}
						if(!Haulier.equals("")) {
							 
							scrollElementToCenter(driver, Haulier_Checkbox_L);
							waitForElement(driver, Haulier_Checkbox_L);
							click(driver, Haulier_Checkbox_L);
						}
						if(!Height.equals("")) {
							 
							scrollElementToCenter(driver, Height_Checkbox_L);
							waitForElement(driver, Height_Checkbox_L);
							click(driver, Height_Checkbox_L);
						}
						if(!Helper_S.equals("")) {
							 
							scrollElementToCenter(driver, Helper_S_Checkbox_L_Checkbox_L);
							waitForElement(driver, Helper_S_Checkbox_L_Checkbox_L);
							click(driver, Helper_S_Checkbox_L_Checkbox_L);
						}
						if(!InjectionPort.equals("")) {
							 
							scrollElementToCenter(driver, Injection_Port_Checkbox_L);
							waitForElement(driver, Injection_Port_Checkbox_L);
							click(driver, Injection_Port_Checkbox_L);
						}
						if(!IMO.equals("")) {
							 
							scrollElementToCenter(driver, IMO_Checkbox_L);
							waitForElement(driver, IMO_Checkbox_L);
							click(driver, IMO_Checkbox_L);
						}
						if(!LicenseNo.equals("")) {
							 
							scrollElementToCenter(driver, License_No_Checkbox_L);
							waitForElement(driver, License_No_Checkbox_L);
							click(driver, License_No_Checkbox_L);
						}
						if(!LinkedGenset.equals("")) {
							 
							scrollElementToCenter(driver, Linked_Genset_Checkbox_L);
							waitForElement(driver, Linked_Genset_Checkbox_L);
							click(driver, Linked_Genset_Checkbox_L);
						}
						if(!Maker.equals("")) {
							 
							scrollElementToCenter(driver, Maker_Checkbox_L);
							waitForElement(driver, Maker_Checkbox_L);
							click(driver, Maker_Checkbox_L);
						}
						if(!Material.equals("")) {
							 
							scrollElementToCenter(driver, Material_Checkbox_L);
							waitForElement(driver, Material_Checkbox_L);
							click(driver, Material_Checkbox_L);
						}
						if(!MovementType_Code.equals("")) {
							 
							scrollElementToCenter(driver, MovementType_Code_Checkbox_L);
							waitForElement(driver, MovementType_Code_Checkbox_L);
							click(driver, MovementType_Code_Checkbox_L);
						}
						if(!O_H_Input.equals("")) {
							 
							scrollElementToCenter(driver, O_H_Checkbox_L);
							waitForElement(driver, O_H_Checkbox_L);
							click(driver, O_H_Checkbox_L);
						}
						if(!O_L_Input.equals("")) {
							 
							scrollElementToCenter(driver, O_L_Checkbox_L);
							waitForElement(driver, O_L_Checkbox_L);
							click(driver, O_L_Checkbox_L);
						}
						if(!O_W_Input.equals("")) {
							 
							scrollElementToCenter(driver, O_W_Checkbox_L);
							waitForElement(driver, O_W_Checkbox_L);
							click(driver, O_W_Checkbox_L);
						}
						if(!O_W_Amount.equals("")) {
							 
							scrollElementToCenter(driver, O_Weight_Amount_Checkbox_L);
							waitForElement(driver, O_Weight_Amount_Checkbox_L);
							click(driver, O_Weight_Amount_Checkbox_L);
						}if(!O_W_Ind.equals("")) {
							 
							scrollElementToCenter(driver, O_Weight_Indicator_Checkbox_L);
							waitForElement(driver, O_Weight_Indicator_Checkbox_L);
							click(driver, O_Weight_Indicator_Checkbox_L);
						}
						
						if(!Owned.equals("")) {
							 
							scrollElementToCenter(driver, Owned_Checkbox_Lv);
							waitForElement(driver, Owned_Checkbox_Lv);
							click(driver, Owned_Checkbox_Lv);
						}
						if(!PlateNo.equals("")) {
							 
							scrollElementToCenter(driver, Plate_No_Checkbox_L);
							waitForElement(driver, Plate_No_Checkbox_L);
							click(driver, Plate_No_Checkbox_L);
						}
						if(!pod_Input.equals("")) {
							 
							scrollElementToCenter(driver, POD_Checkbox_L);
							waitForElement(driver, POD_Checkbox_L);
							click(driver, POD_Checkbox_L);
						}
						if(!pol_Input.equals("")) {
							 
							scrollElementToCenter(driver, POL_Checkbox_L);
							waitForElement(driver, POL_Checkbox_L);
							click(driver, POL_Checkbox_L);
						}
						if(!PoolCode.equals("")) {
							 
							scrollElementToCenter(driver, PoolCode_Checkbox_L);
							waitForElement(driver, PoolCode_Checkbox_L);
							click(driver, PoolCode_Checkbox_L);
						}
						if(!ReasonCode.equals("")) {
							 
							scrollElementToCenter(driver, Reason_Elimination_Code_Checkbox_L);
							waitForElement(driver, Reason_Elimination_Code_Checkbox_L);
							click(driver, Reason_Elimination_Code_Checkbox_L);
						}
						if(!Redel_Date.equals("")) {
							 
							scrollElementToCenter(driver, Redelivery_Date_Checkbox_L);
							waitForElement(driver, Redelivery_Date_Checkbox_L);
							click(driver, Redelivery_Date_Checkbox_L);
						}
						if(!Redel_Place.equals("")) {
							 
							scrollElementToCenter(driver, Redelivery_Place_Checkbox_L);
							waitForElement(driver, Redelivery_Place_Checkbox_L);
							click(driver, Redelivery_Place_Checkbox_L);
						}
						if(!ReturnDate.equals("")) {
							 
							scrollElementToCenter(driver, Return_Date_Checkbox_L);
							waitForElement(driver, Return_Date_Checkbox_L);
							click(driver, Return_Date_Checkbox_L);
						}
						if(!Return_Place.equals("")) {
							 
							scrollElementToCenter(driver, Return_Place_Checkbox_L);
							waitForElement(driver, Return_Place_Checkbox_L);
							click(driver, Return_Place_Checkbox_L);
						}
						if(!Return_Ref_No.equals("")) {
							 
							scrollElementToCenter(driver, Return_Reference_Checkbox_L);
							waitForElement(driver, Return_Reference_Checkbox_L);
							click(driver, Return_Reference_Checkbox_L);
						}
						if(!Return_to_Fleet.equals("")) {
							 
							scrollElementToCenter(driver, Return_to_Fleet_Checkbox_L);
							waitForElement(driver, Return_to_Fleet_Checkbox_L);
							click(driver, Return_to_Fleet_Checkbox_L);
						}
						if(!Service.equals("")) {
							 
							scrollElementToCenter(driver, Service_Checkbox_L);
							waitForElement(driver, Service_Checkbox_L);
							click(driver, Service_Checkbox_L);
						}
						if(!To_Service.equals("")) {
							 
							scrollElementToCenter(driver, ServiceTO_Checkbox_L);
							waitForElement(driver, ServiceTO_Checkbox_L);
							click(driver, ServiceTO_Checkbox_L);
						}
						if(!Shipper.equals("")) {
							 
							scrollElementToCenter(driver, Shipper_Checkbox_L);
							waitForElement(driver, Shipper_Checkbox_L);
							click(driver, Shipper_Checkbox_L);
						}
						if(!ShipperOwned.equals("")) {
							 
							scrollElementToCenter(driver, Shipper_Owned_Checkbox_L);
							waitForElement(driver, Shipper_Owned_Checkbox_L);
							click(driver, Shipper_Owned_Checkbox_L);
						}
						if(!ShipperSeal.equals("")) {
							 
							scrollElementToCenter(driver, Shipper_Seal_Checkbox_L);
							waitForElement(driver, Shipper_Seal_Checkbox_L);
							click(driver, Shipper_Seal_Checkbox_L);
						}
						if(!ShippingLine.equals("")) {
							 
							scrollElementToCenter(driver, Shipping_Line_Checkbox_L);
							waitForElement(driver, Shipping_Line_Checkbox_L);
							click(driver, Shipping_Line_Checkbox_L);
						}
						if(!Stopping_Point.equals("")) {
							 
							scrollElementToCenter(driver, Stopping_Point_Checkbox_L);
							waitForElement(driver, Stopping_Point_Checkbox_L);
							click(driver, Stopping_Point_Checkbox_L);
						}
						if(!Stowage.equals("")) {
							 
							scrollElementToCenter(driver, Stowage_Checkbox_L);
							waitForElement(driver, Stowage_Checkbox_L);
							click(driver, Stowage_Checkbox_L);
						}
						if(!SubLease_Ref.equals("")) {
							 
							scrollElementToCenter(driver, SubLeaseRefNo_Checkbox_L);
							waitForElement(driver, SubLeaseRefNo_Checkbox_L);
							click(driver, SubLeaseRefNo_Checkbox_L);
						}
						if(!Survey_Date.equals("")) {
							 
							scrollElementToCenter(driver, Survey_date_Checkbox_L);
							waitForElement(driver, Survey_date_Checkbox_L);
							click(driver, Survey_date_Checkbox_L);
						}
						if(!Surveyor.equals("")) {
							 
							scrollElementToCenter(driver, Surveyor_Checkbox_L);
							waitForElement(driver, Surveyor_Checkbox_L);
							click(driver, Surveyor_Checkbox_L);
						}
						if(!T_S.equals("")) {
							 
							scrollElementToCenter(driver, T_S_Checkbox_L);
							waitForElement(driver, T_S_Checkbox_L);
							click(driver, T_S_Checkbox_L);
						}
						if(!Tare.equals("")) {
							 
							scrollElementToCenter(driver, Tare_Checkbox_L);
							waitForElement(driver, Tare_Checkbox_L);
							click(driver, Tare_Checkbox_L);
						}
						if(!TCT.equals("")) {
							 
							scrollElementToCenter(driver, TCT_Checkbox_L);
							waitForElement(driver, TCT_Checkbox_L);
							click(driver, TCT_Checkbox_L);
						}
						if(!TDN_Number.equals("")) {
							 
							scrollElementToCenter(driver, TDN_Number_Checkbox_L);
							waitForElement(driver, TDN_Number_Checkbox_L);
							click(driver, TDN_Number_Checkbox_L);
						}
						if(!Temp.equals("")) {
							 
							scrollElementToCenter(driver, Temp_Checkbox_L);
							waitForElement(driver, Temp_Checkbox_L);
							click(driver, Temp_Checkbox_L);
						}
						if(!TIR.equals("")) {
							 
							scrollElementToCenter(driver, TIR_Checkbox_L);
							waitForElement(driver, TIR_Checkbox_L);
							click(driver, TIR_Checkbox_L);
						}
						if(!To_Place.equals("")) {
							 
							scrollElementToCenter(driver, To_Place_Checkbox_L);
							waitForElement(driver, To_Place_Checkbox_L);
							click(driver, To_Place_Checkbox_L);
						}
						if(!To_Term_Depot.equals("")) {
							 
							scrollElementToCenter(driver, To_Depot_Checkbox_L);
							waitForElement(driver, To_Depot_Checkbox_L);
							click(driver, To_Depot_Checkbox_L);
						}
						
						if(!Trade.equals("")) {
							 
							scrollElementToCenter(driver, Trade_Checkbox_L);
							waitForElement(driver, Trade_Checkbox_L);
							click(driver, Trade_Checkbox_L);
						}
						
						if(!TransportService.equals("")) {
							 
							scrollElementToCenter(driver, Transport_Service_Checkbox_L);
							waitForElement(driver, Transport_Service_Checkbox_L);
							click(driver, Transport_Service_Checkbox_L);
						}
						
						if(!Trucker.equals("")) {
							 
							scrollElementToCenter(driver, Trucker_Checkbox_L);
							waitForElement(driver, Trucker_Checkbox_L);
							click(driver, Trucker_Checkbox_L);
						}
						
						if(!UNNO.equals("")) {
							 
							scrollElementToCenter(driver, UNNO_Checkbox_L);
							waitForElement(driver, UNNO_Checkbox_L);
							click(driver, UNNO_Checkbox_L);
						}
						
						if(!VanLocation.equals("")) {
							 
							scrollElementToCenter(driver, Van_Location_Checkbox_L);
							waitForElement(driver, Van_Location_Checkbox_L);
							click(driver, Van_Location_Checkbox_L);
						}
						
						if(!Vessel_Input.equals("")) {
							 
							scrollElementToCenter(driver, Vessel_Checkbox_L);
							waitForElement(driver, Vessel_Checkbox_L);
							click(driver, Vessel_Checkbox_L);
						}
						
						if(!VIA.equals("")) {
							 
							scrollElementToCenter(driver, VIA_Checkbox_L);
							waitForElement(driver, VIA_Checkbox_L);
							click(driver, VIA_Checkbox_L);
						}
						
						if(!Voyage_Input.equals("")) {
							 
							scrollElementToCenter(driver, Voyage_Checkbox_L);
							waitForElement(driver, Voyage_Checkbox_L);
							click(driver, Voyage_Checkbox_L);
						}
						
						waitForElement(driver, selectCheckboxOk_L);
						click(driver, selectCheckboxOk_L);
					}

					Step_End(8, "Clear the existing data and enter the updated information as per the data sheet.", test, test1);
					Step_Start(9, "Click the Edit button, then click Save.", test, test1);

					waitForElement(driver, verifyActivePlace_L);
					String actActivePlace = getText(driver, verifyActivePlace_L);
					String actDepot = getText(driver, verifyDepot_L);
					System.out.println("Actual Active Place:" + actActivePlace);
					System.out.println("Actual Dpot:" + actDepot);

					scrollTop(driver);
					waitForElement(driver, SaveButton_ToolBar);
					click(driver, SaveButton_ToolBar);

					Step_End(9, "Click the Edit button, then click Save.", test, test1);
					Step_Start(10, "A confirmation message will appear indicating that the data has been successfully updated.", test, test1);

					waitForPopup(driver, popup_Message, updatedPopupMulti);
					String actText = getText(driver, popup_Message);
						if (actText.equals(updatedPopupMulti)) {
							System.out.println("Matched || "+updatedPopupMulti + " popup is displayed" + " Expected Popup is : " + updatedPopupMulti+ " || Actual Popup is : " + actText);
							Extent_pass_New(driver, "Matched || " +updatedPopupMulti + " popup is displayed"+ " Expected Popup is : " + updatedPopupMulti+ " || ActualPopup is : " + actText, test, test1);

							click(driver, popup_Message_Ok_Button);
						} else {
							System.out.println("Not matched || "+updatedPopupMulti + " popup is not displayed" + " Expected Popup is : " + updatedPopupMulti
									+ " || Actual Popup  is : " + actText);
							Extent_fail(driver, "Not matched || "+updatedPopupMulti + " popup is not displayed" + " Expected Popup is : " + updatedPopupMulti
									+ " || Actual Popup is : " + actText, test, test1);
						}

					Step_End(10, "A confirmation message will appear indicating that the data has been successfully updated.", test, test1);

			Extent_completed(testCaseName, test, test1);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		
		boolean ts19=true;
		if(ts19==true) {
			
			String testCaseName="TC_Movement_Entry_TS_019";
//			Get data from excel sheet

			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName,"Dataset" + selected_dataset, File_Path);
			String moduleName = Excel_data.get("ModuleMovementEntry");
			String sureToDeletePopup = Excel_data.get("SureToDeletePopup");
			String eqpNo = Excel_data.get("EquipmentNo");
			String deletedSingle = Excel_data.get("DeletedSingle");
			String movementCode = Excel_data.get("MovementCode");

			Extent_Start(testCaseName, test, test1);
			
			Step_Start(1, "Enter the module name in the search box and click on the module.", test, test1);
			
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter the module name in the search box and click on the module.", test, test1);


			// Single Equipment Entry
			waitForDisplay(driver, singleEntryMovPage_L);
				
				Step_Start(2, "Enter the required container number and click Show History", test, test1);
				waitForElement(driver, equipmentNoSearchField_L);
				sendKeys(driver, equipmentNoSearchField_L, eqpNo);
				
				waitForElement(driver, showHistoryButton_L);
				click(driver, showHistoryButton_L);
				
				Step_End(2, "Enter the required container number and click Show History", test, test1);
				Step_Start(3, "Enter the movement code in the designated column.", test, test1);
				
				waitForElement(driver, eqpNoInEqpDetails_L);
				String actSaved = getText(driver, eqpNoInEqpDetails_L);
				if (actSaved.equals(eqpNo)) {
					System.out.println("Matched || " + "Single Movement Entry is retrieved || " + " Expected Value is : "
							+ eqpNo + " || Actual Value is : " + actSaved);

					Extent_pass_New(driver, "Matched || " + "Single Movement Entry is retrieved || " + " Expected Value is : "
							+ eqpNo + " || Actual Value is : " + actSaved, test, test1);
				} else {
					System.out.println("Not matched || " + "Single Movement Entry is not retrieved || "
							+ " Expected Value is : " + eqpNo + " || Actual Value  is : " + actSaved);

					Extent_fail(driver, "Not matched || " + "Single Movement Entry is not retrieved ||"
							+ " Expected Value is : " + eqpNo + " || Actual Value is : " + actSaved+"<br>"+"Single Movement Entry is not retrieved", test, test1);
				}

				List<String> movement_Code = splitAndExpand(movementCode);
				
				for(int i=0; i<movement_Code.size();i++) {
				
				String movement_Code_Input=movement_Code.get(i);
				
				waitForElement(driver, movementCode_Grid_Filter);
				click(driver, movementCode_Grid_Filter);
				waitForElement(driver, movementCode_Grid_Filter);
				sendKeys(driver, movementCode_Grid_Filter, movement_Code_Input);
				
				Step_End(3, "Enter the movement code in the designated column.", test, test1);
				Step_Start(4, "Once the move is filtered, right-click and select the Delete option", test, test1);
				
				waitForElement(driver, equipmentDetails_Grid_First_Row);
				RightClick(driver, equipmentDetails_Grid_First_Row);
				
				
				waitForElement(driver, deleteOpionSingle_L);
				click(driver, deleteOpionSingle_L);
				
				Step_End(4, "Once the move is filtered, right-click and select the Delete option", test, test1);
				Step_Start(5, "Click Yes on the system pop-up message to confirm the action", test, test1);
				
				waitForPopup(driver, popup_Message, sureToDeletePopup);
				String actConfirmDele = getText(driver, popup_Message);

				if (actConfirmDele.equals(sureToDeletePopup)) {
					Extent_pass_New(driver, "Matched || Expected Popup : "+sureToDeletePopup + " || Actual Popup : "+actConfirmDele, test, test1);
					System.out.println("Matched || Expected Popup : "+sureToDeletePopup + " || Actual Popup : "+actConfirmDele);
					click(driver, popup_Message_Yes_Button);
				}else {
					System.out.println("Not Matched || Expected Popup : "+sureToDeletePopup + " || Actual Popup : "+actConfirmDele);
					Extent_fail(driver, "Not Matched || Expected Popup : "+sureToDeletePopup + " || Actual Popup : "+actConfirmDele, test, test1);
				}
				
				Step_End(5, "Click Yes on the system pop-up message to confirm the action", test, test1);
				Step_Start(6, "A message will appear confirming that the selected container has been deleted", test, test1);

				waitForPopup(driver, popup_Message, deletedSingle);
				String actPopup = getText(driver, popup_Message);

				if (actPopup.equals(deletedSingle)) {
					Extent_pass_New(driver, "Matched || Expected Popup : "+deletedSingle + " || Actual Popup : "+actPopup, test, test1);
					System.out.println("Matched || Expected Popup : "+deletedSingle + " || Actual Popup : "+actPopup);
					click(driver, popup_Message_Ok_Button);
				}else {
					System.out.println("Not Matched || Expected Popup : "+deletedSingle + " || Actual Popup : "+actPopup);
					Extent_fail(driver, "Not Matched || Expected Popup : "+deletedSingle + " || Actual Popup : "+actPopup, test, test1);
				}
				Step_End(6, "A message will appear confirming that the selected container has been deleted", test, test1);

				}
	    
	    waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		}
	
		boolean ts20=true;
		if(ts20==true) {
			String testCaseName="TC_Movement_Entry_TS_020";
//			Get data from excel sheet
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName,"Dataset" + selected_dataset, File_Path);
			String moduleName = Excel_data.get("ModuleMovementEntry");
			String multiDeleted = Excel_data.get("MultipleMovEntryDeleted");
			String movement_Code = Excel_data.get("Movement_Code");
			String GlobalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
			String dropdownCondition_Date = Excel_data.get("dropdownCondition_Date");
			String dropdown_Condition = Excel_data.get("Dropdown_Condition");

			String GlobalSearchFilterOption2 = Excel_data.get("GlobalSearchFilterOption2");
			String GlobalSearchFilterOption3= Excel_data.get("GlobalSearchFilterOption3");
			String Search_Input1 = Excel_data.get("RetrieveEqpNo");
			String Search_Input2 = Excel_data.get("Movement_Code");
			String Search_Input3= Excel_data.get("Activity_Date");
			
			Extent_Start(testCaseName, test, test1);

			Step_Start(1, "Enter the module name in the search box and click on the module", test, test1);
			
			moduleNavigate(driver, moduleName);
			
			Step_End(1, "Enter the module name in the search box and click on the module", test, test1);

			
			// Multiple Equipment Entry
					Step_Start(2, "Select the Multiple Equipment Entry option", test, test1);
					
					waitForElement(driver, multiEntryMovPage_L);
					click(driver, multiEntryMovPage_L);
					
					Step_End(2, "Select the Multiple Equipment Entry option", test, test1);
					
			waitForDisplay(driver, multiEntryMovPage_L);
				
				waitForElement(driver, activitySearchField_L);
		
					Step_Start(3, "Click on the Global Search icon in the toolbar.", test, test1);
					
					waitForElement(driver, SearchButton_Toolbar);
					click(driver, SearchButton_Toolbar);
					
					Step_End(3, "Click on the Global Search icon in the toolbar.", test, test1);
					Step_Start(4, "Fill in the required filter fields such as Equipment Number, Movement Code, and Activity Date.", test, test1);

					if (!Search_Input1.equals("")) {
						waitForElement(driver, type_Select1);
						selectByText(driver, type_Select1, GlobalSearchFilterOption1);
						waitForDisplay(driver, type_Select1);
						selectByText(driver, globalSearch_Condition_Dropdown1, dropdown_Condition);
						waitForDisplay(driver, globalSearch_InputTextfield1);
						sendKeys(driver, globalSearch_InputTextfield1, Search_Input1);
					}
					if (!Search_Input2.equals("")) {
						waitForElement(driver, type_Select2);
						selectByText(driver, type_Select2, GlobalSearchFilterOption2);
						waitForDisplay(driver, type_Select2);
						selectByText(driver, globalSearch_Condition_Dropdown2, dropdown_Condition);
						waitForDisplay(driver, globalSearch_InputTextfield2);
						sendKeys(driver, globalSearch_InputTextfield2, Search_Input2);
					}
					if (!Search_Input3.equals("")) {
						waitForElement(driver, type_Select3);
						selectByText(driver, type_Select3, GlobalSearchFilterOption3);
						waitForDisplay(driver, Roe_Date_Condition);
						selectByText(driver, Roe_Date_Condition, dropdownCondition_Date);
						waitForDisplay(driver, Roe_Date_Field);
						sendKeys(driver, Roe_Date_Field, Search_Input3);
					}
					Step_End(4, "Fill in the required filter fields such as Equipment Number, Movement Code, and Activity Date.", test, test1);
					Step_Start(5, "Click the Search button to display the relevant results.", test, test1);

					waitForElement(driver, globalSearch_Frame_SearchButton);
					click(driver, globalSearch_Frame_SearchButton);
					
					waitForElement(driver, SelectButton);
					click(driver, SelectButton);
					elementnotvisible1(driver, SelectButton);
					

					Step_End(5, "Click the Search button to display the relevant results.", test, test1);
				
				Step_Start(6, "Select the rows to delete.", test, test1);

				waitForElement(driver, movementCode_Grid_Filter);
				click(driver, movementCode_Grid_Filter);
				waitForElement(driver, movementCode_Grid_Filter);
				sendKeys(driver, movementCode_Grid_Filter, movement_Code);
				
				Actions actions=new Actions(driver);
				actions.keyDown(Keys.SHIFT).perform();
				waitForDisplay(driver, equipmentDetails_Table_Last_Row);
				scrollElementToCenter(driver, equipmentDetails_Table_Last_Row);
				waitForElement(driver, equipmentDetails_Table_Last_Row);
				click(driver, equipmentDetails_Table_Last_Row);
				actions.keyUp(Keys.SHIFT).perform();
				
				Step_End(6, "Select the rows to delete.", test, test1);
				Step_Start(7, "Right-click on the yellow-highlighted area and choose the Delete option.", test, test1);
				
				waitForElement(driver, equipmentDetails_Grid_First_Row);
				RightClick(driver, equipmentDetails_Grid_First_Row);
				
				waitForElement(driver, multiDeleteOption_L);
				click(driver, multiDeleteOption_L);
				
				Step_End(7, "Right-click on the yellow-highlighted area and choose the Delete option.", test, test1);
				Step_Start(8, "When prompted with the confirmation message \"Are you sure you want to delete the Multiple Movement Entry?\", select Yes.", test, test1);
				
				waitForPopup(driver, popup_Message, multiDeleted);

				if (isDisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Yes_Button);
				}
				Step_End(8, "When prompted with the confirmation message \"Are you sure you want to delete the Multiple Movement Entry?\", select Yes.", test, test1);
				Step_Start(9, "Click OK when the validation message \"Multiple Movement Entry deleted\" appears.", test, test1);

				waitForPopup(driver, popup_Message, multiDeleted);

					String actText1 = getText(driver, popup_Message);
					if (actText1.equals(multiDeleted)) {
						Extent_pass_New(driver, "Matched || Expected Popup : "+multiDeleted + " || Actual Popup : "+actText1, test, test1);
						System.out.println("Matched || Expected Popup : "+multiDeleted + " || Actual Popup : "+actText1);
						click(driver, popup_Message_Ok_Button);
					}else {
						System.out.println("Not Matched || Expected Popup : "+multiDeleted + " || Actual Popup : "+actText1);
						Extent_fail(driver, "Not Matched || Expected Popup : "+multiDeleted + " || Actual Popup : "+actText1, test, test1);
					}
					Step_End(9, "Click OK when the validation message \"Multiple Movement Entry deleted\" appears.", test, test1);

			Extent_completed(testCaseName, test, test1);
			
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			
		}
		
		boolean ts21=true;
		if(ts21==true) {
			
			String testCaseName="TC_Movement_Entry_TS_021";
//			Get data from excel sheet
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name, testCaseName,"Dataset" + selected_dataset, File_Path);

			String moduleName = Excel_data.get("ModuleMovementEntry");
			String retrieveEqpNo = Excel_data.get("RetrieveEqpNo");
			String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
			String dropdownCondition = Excel_data.get("DropdownCondition");
			String globalSearchFilterOption2 = Excel_data.get("globalSearchFilterOption2");
			String globalSearchFilterOption3 = Excel_data.get("globalSearchFilterOption3");
			String searchValue2 = Excel_data.get("searchValue2");
			String searchValue3 = Excel_data.get("searchValue3");
			
			Extent_Start(testCaseName, test, test1);

//			Module Search
			moduleNavigate(driver, moduleName);
			
			Step_Start(1, "Select Multiple Equipment Entry option", test, test1);
			waitForElement(driver, multiEntryMovPage_L);
			click(driver, multiEntryMovPage_L);

				Step_End(1, "Select Multiple Equipment Entry option", test, test1);
				Step_Start(2, "Click on global search icon option from toolbar", test, test1);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);

				Step_End(2, "Click on global search icon option from toolbar", test, test1);
				Step_Start(3, "Enter required container no on required field", test, test1);
			
				globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption1, retrieveEqpNo, globalSearchFilterOption2, searchValue2, globalSearchFilterOption3, searchValue3);

				waitForElement(driver, eqpNoInEqpDetails_L);
				String actualRetNo2 = getText(driver, eqpNoInEqpDetails_L);
				System.out.println("Actual Eqp No:" + actualRetNo2);
				System.out.println("Expected Eqp No:" + retrieveEqpNo);

				if (actualRetNo2.equals(retrieveEqpNo)) {
					System.out.println("Matched || " + " Expected Value is : " + retrieveEqpNo + " || Actual Value is : "
							+ actualRetNo2);

					Extent_pass_New(driver, "Matched || " + " Expected Value is : " + retrieveEqpNo + " || Actual Value is : "
							+ actualRetNo2+"<br>"+"Multiple Movement Entry retrieved", test, test1);
				} else {
					System.out.println("Not matched || " + " Expected Value is : " + retrieveEqpNo
							+ " || Actual Value  is : " + actualRetNo2);

					Extent_fail(driver, "Not matched || " + " Expected Value is : " + retrieveEqpNo
							+ " || Actual Value is : " + actualRetNo2+"<br>"+"Multiple Movement Entry not retrieved", test, test1);
				}

			Step_End(4, "click search & select the required container to retrieve", test, test1);
			Extent_completed(testCaseName, test, test1);
		}
	}

}
