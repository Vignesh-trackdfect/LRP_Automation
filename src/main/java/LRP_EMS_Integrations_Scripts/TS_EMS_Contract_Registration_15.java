package LRP_EMS_Integrations_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;



public class TS_EMS_Contract_Registration_15 extends Keywords {

	public void EMS_Contract_Registration_15(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testcase_Name="TS_EMS_Contract_Registration_15";
		
		



		String Username = Excel_data.get("Username");
		String pass_word = Excel_data.get("pass_word");
		String Module_name = Excel_data.get("module_name");
		String Activity_data1 = Excel_data.get("Activity_data1");
		String Location = Excel_data.get("Location");
		String SizeType = Excel_data.get("SizeType");
		String Equipment_Num = Excel_data.get("Equipment_Num");
		String Global_SearchField = Excel_data.get("Global_SearchField");
		String PickUpDropoff_LocationSF = Excel_data.get("PickUpDropoff_LocationSF");
		String PickupDropoff_SizetypeSF = Excel_data.get("PickupDropoff_SizetypeSF");
		String module_name1 = Excel_data.get("module_name1");
		String Return_refno1 = Excel_data.get("Return_refno1");
		String Movement_Entry_ActivityDate = Excel_data.get("Movement_Entry_ActivityDate");
		String movement_EntryPopup = Excel_data.get("movement_EntryPopup").trim();
		String date_Picker = Excel_data.get("date_Picker");
		String Version_Input = Excel_data.get("Version_Input");
		String Carrier_Input = Excel_data.get("Carrier_Input");
		String Version_Search = Excel_data.get("Version_Search");
		String Carrier_Search = Excel_data.get("Carrier_Search");
		String Contract_No_Search = Excel_data.get("Contract_No_Search");
		String condition = Excel_data.get("condition");
		String activityHour = Excel_data.get("activityHour");






		// login
		Extent_Start(testcase_Name, test, test1);


		// login
		navigateUrl(driver, url);
		
		LRP_Login(driver, Username, pass_word);

		Extent_call(test, test1, "Enter module name in searchbox & click the module");

		Step_Start(1, " Ensure system should allow user to save OFHI move in movement entry", test, test1);
		// search module
		moduleNavigate(driver, Module_name);

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForDisplay(driver, multiEntryMovPage_L);

			Step_End(2, "Click the Multiple Equipment Entry tab to proceed.", test, test1);
			Step_Start(3, "Enter the activity code and press Enter.", test, test1);
			
			waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, Activity_data1);
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
			
			List<String> equipment_Number = splitAndExpand(Equipment_Num);
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
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);

			}

//			for(int i=0;i<equipment_Number.size();i++) {
//				String equipmentNumber_Gridcell=String.format(equipmentNumber_Gridcell_Value, i);
//			
//			waitForDisplay(driver, equipmentNumber_Gridcell);
//			String actualEqpNumber = getText(driver, equipmentNumber_Gridcell);
//			Extent_pass_New(driver, "Actual Equipment Number "+(i+1)+" : "+actualEqpNumber, test, test1);
//			}
			
			
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


		Step_Start(2, "Ensure that system should update the Actual Dropoff Quantity in contract registration for Pick up and Drop off Details based on contract or scale-in used in movement", test, test1);

		waitForElement(driver, ScaleIn_OutPage);
		doubleClick(driver, ScaleIn_OutPage);
		waitForElement(driver, ScaleOut_Reference);
		safeclick(driver, ScaleOut_Reference);
		waitForElement(driver, Scaleout_refNo_Tf);
		safeclick(driver, Scaleout_refNo_Tf);
		sendKeys(driver, Scaleout_refNo_Tf, Return_refno1);

		safeclick(driver, Scaleout_Location_Tf);
		sendKeys(driver, Scaleout_Location_Tf, Location);

		safeclick(driver, Scaleout_Sizetyp_Tf);
		sendKeys(driver, Scaleout_Sizetyp_Tf, SizeType);

		waitForElement(driver, scaleout_ActualQunantity);
		String Value4 = getText(driver, scaleout_ActualQunantity);

		safeclick(driver, pickup_DropOff);

		safeclick(driver, Pickup_LocationSF);
		sendKeys(driver, Pickup_LocationSF, PickUpDropoff_LocationSF);

		safeclick(driver, Pickup_sizetypeSF);
		sendKeys(driver, Pickup_sizetypeSF, PickupDropoff_SizetypeSF);

		waitForElement(driver, PickupActual_DropOff_Quantity);
		String Value5 = getText(driver, PickupActual_DropOff_Quantity);

		if (Value4.equals(Value5)) {
			System.out.println("Matched || Expected value was : " + Value4 + " || Actual value was : " + Value5);
			Extent_pass_New(driver, "Matched || Expected value was : " + Value4 + " || Actual value was : " + Value5, test,
					test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + Value4 + " || Actual value was : " + Value5);
			Extent_fail(driver, "NotMatched || Expected value was : " + Value4 + " || Actual value was : " + Value5,
					test, test1);
		}

		Step_End(2, "Ensure that system should update the Actual Dropoff Quantity in contract registration for Pick up and Drop off Details based on contract or scale-in used in movement", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
