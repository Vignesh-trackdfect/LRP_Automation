package LRP_EMS_Integrations_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;



public class TS_EMS_Contract_Registration_13 extends Keywords {

	public void EMS_Contract_Registration_13(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testcase_Name="TS_EMS_Contract_Registration_13";
		
		


		String Username = Excel_data.get("Username");
		String pass_word = Excel_data.get("pass_word");
		String Module_name = Excel_data.get("module_name");
		String Activity_data = Excel_data.get("Activity_data");
		String Equipment_No = Excel_data.get("Equipment_No");
		String Global_SearchField = Excel_data.get("Global_SearchField");
		String PickUpDropoff_LocationSF = Excel_data.get("PickUpDropoff_LocationSF");
		String PickupDropoff_SizetypeSF = Excel_data.get("PickupDropoff_SizetypeSF");
		String module_name1 = Excel_data.get("module_name1");
		String date_Picker = Excel_data.get("DatePicker");
		String Movement_Entry_ActivityDate = Excel_data.get("Movement_Entry_ActivityDate");
		String movement_EntryPopup = Excel_data.get("movement_EntryPopup").trim();
		String Version_Input = Excel_data.get("Version_Input");
		String Carrier_Input = Excel_data.get("Carrier_Input");
		String Version_Search = Excel_data.get("Version_Search");
		String Carrier_Search = Excel_data.get("Carrier_Search");
		String Contract_No_Search = Excel_data.get("Contract_No_Search");
		String condition = Excel_data.get("condition");
		String activityHour = Excel_data.get("activityHour");








		Extent_Start(testcase_Name, test, test1);


		// login
		navigateUrl(driver, url);
		
		LRP_Login(driver, Username, pass_word);

		Extent_call(test, test1, "Enter module name in searchbox & click the module");


		Step_Start(1, "Ensure system should allow user to save ONHI move in movement entry", test, test1);


		moduleNavigate(driver, Module_name);

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForDisplay(driver, multiEntryMovPage_L);

			Step_End(2, "Click the Multiple Equipment Entry tab to proceed.", test, test1);
			Step_Start(3, "Enter the activity code and press Enter.", test, test1);
			
			waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, Activity_data);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			Step_End(3, "Enter the activity code and press Enter.", test, test1);
			Step_Start(4, "Select the required date from the date picker.", test, test1);
			
			waitForElement(driver, activeDateField_L);

			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, activeDateField_L, Movement_Entry_ActivityDate);

			} else {
				if (Movement_Entry_ActivityDate.contains("-")) {
					click(driver, activeDateField_L);

					String activityDate_1 = Movement_Entry_ActivityDate.replace("-", "/");

					clearAndType(driver, activeDateField_L, activityDate_1);

				} else {
					click(driver, activeDateField_L);

					clearAndType(driver, activeDateField_L, Movement_Entry_ActivityDate);

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
			
			List<String> equipment_Number = splitAndExpand(Equipment_No);
			for(int i=0;i<equipment_Number.size();i++) {
				
				Step_Start(7, "Once all required fields are entered, click the Add button.", test, test1);
				
				waitForElement(driver, addButtonMulti_L);
				click(driver, addButtonMulti_L);

				Step_End(7, "Once all required fields are entered, click the Add button.", test, test1);
				Step_Start(8, "Enter a valid container number in the Equipment No. field within the grid.", test, test1);
				
			String equipmentNumber_Add=String.format(equipmentNumber_Grid_Textfield, i);
			String equipmentNumber_Input_Add=String.format(equipmentNumber_Grid_Input_Textfield, i);
			String equipmentNo=equipment_Number.get(i);
			
			waitForElement(driver, equipmentNumber_Add);
			scrollUsingElement(driver, equipmentNumber_Add);
			waitForElement(driver, equipmentNumber_Add);
			click(driver, equipmentNumber_Add);

			waitForElement(driver, equipmentNumber_Input_Add);
			sendKeys(driver, equipmentNumber_Input_Add, equipmentNo);

			Step_End(8, "Enter a valid container number in the Equipment No. field within the grid.", test, test1);

			
			}
			
			Step_Start(9, "Click the Save button. The system should then display a confirmation message indicating that the data has been saved successfully.", test, test1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForDisplay(driver, errorRecordsFrame_L);
			if (isdisplayed(driver, errorRecordsFrame_L)) {
				if (isdisplayed(driver, errorRecApply_L)) {
					click(driver, errorRecApply_L);

				}
				else if (isdisplayed(driver, okButtonErrorFrame_L)) {
					waitForElement(driver, okButtonErrorFrame_L);
					click(driver, okButtonErrorFrame_L);
				}
			

			for(int i=0;i<equipment_Number.size();i++) {
				String equipmentNumber_Gridcell=String.format(equipmentNumber_Gridcell_Value, i);
			
			waitForDisplay(driver, equipmentNumber_Gridcell);
			String actualEqpNumber = getText(driver, equipmentNumber_Gridcell);
			Extent_pass_New(driver, "Actual Equipment Number "+(i+1)+" : "+actualEqpNumber, test, test1);
			}
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			}
			waitForPopup(driver, popup_Message, movement_EntryPopup);
			
				String actText = getText(driver, popup_Message);
				if (actText.equals(movement_EntryPopup)) {
					System.out.println("Matched || " + " Expected Popup is : " + movement_EntryPopup
							+ " || Actual Popup is : " + actText);
					Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + movement_EntryPopup
							+ " || Actual Popup is : " + actText+"<br>"+movement_EntryPopup + " popup is displayed", test, test1);
					click(driver, popup_Message_Ok_Button);
				} else {
					System.out.println("Not matched || " + " Expected Popup is : " + movement_EntryPopup
							+ " || Actual Popup  is : " + actText);

					Extent_fail(driver, "Not matched || " + " Expected Popup is : " + movement_EntryPopup
							+ " || Actual Popup is : " + actText+"<br>"+movement_EntryPopup + " popup is not displayed", test, test1);
				}
		
				Step_End(9, "Click the Save button. The system should then display a confirmation message indicating that the data has been saved successfully.", test, test1);




		moduleNavigate(driver, module_name1);

		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, condition, Contract_No_Search, Global_SearchField, Carrier_Search, Carrier_Input, Version_Search, Version_Input);



		Step_Start(2, "Ensure that system should show pick up actual count correctly once Actual pick up qty selection double safeclick", test, test1);

		safeclick(driver, ScaleIn_OutPage);

		safeclick(driver, pickup_DropOff);

		safeclick(driver, Pickup_LocationSF);
		sendKeys(driver, Pickup_LocationSF, PickUpDropoff_LocationSF);

		safeclick(driver, Pickup_sizetypeSF);
		sendKeys(driver, Pickup_sizetypeSF, PickupDropoff_SizetypeSF);
		waitForElement(driver, PickUpActual_Quantity);
		String Actual3 = getText(driver, PickUpActual_Quantity);
		doubleClick(driver, PickUpActual_Quantity);
		waitForElement(driver, pickup_Actual_Countvalue);

		String Value1 = getText(driver, pickup_Actual_Countvalue);
		String[] Value2 = Value1.split("\\:");
		System.out.println("Splitted string" + Value2[1]);

		if (Actual3.equals(Value2[1])) {
			System.out.println("Matched || Expected value was : " + Actual3 + " || Actual value was : " + Value2[1]);
			Extent_pass_New(driver, "Matched || Expected value was : " + Actual3 + " || Actual value was : " + Value2[1],
					test, test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + Actual3 + " || Actual value was : " + Value2[1]);
			Extent_fail(driver, "NotMatched || Expected value was : " + Actual3 + " || Actual value was : " + Value2[1],
					test, test1);
		}

		Step_End(2, "Ensure that system should show pick up actual count correctly once Actual pick up qty selection double safeclick", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
