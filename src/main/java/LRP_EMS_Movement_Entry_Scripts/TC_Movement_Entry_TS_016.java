package LRP_EMS_Movement_Entry_Scripts;

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

import commonMethods.Keywords;



public class TC_Movement_Entry_TS_016 extends Keywords {

//	To Create Moves via Multiple Entry in movement entry

	public void createMovesviaMultipleEntry(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Movement_Entry_TS_016";
//		Get data from excel sheet

		
		
		
		


		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String activityEqpEntryMulti = Excel_data.get("ActivityEqpEntry");
		String activityDate = Excel_data.get("ActivityDate");
		String eqpNoMulti_1 = Excel_data.get("EquipmentNumbers");
		String multiSavedPopup = Excel_data.get("MultipleSavedPopup");
		String activityHour = Excel_data.get("ActivityHour");
		String datePicker = Excel_data.get("DatePicker");
		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String Want_To_Delete = Excel_data.get("Want_To_Delete");
		String DuplicatedContainer = Excel_data.get("Duplicated_Container");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		Step_Start(1, "Enter the module name in the search box and click on the desired module.", test, test1);

//		Module Search
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
	}
	
}
