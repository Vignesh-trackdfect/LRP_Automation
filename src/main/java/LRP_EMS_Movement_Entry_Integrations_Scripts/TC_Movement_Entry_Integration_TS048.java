package LRP_EMS_Movement_Entry_Integrations_Scripts;


import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS048 extends Keywords {

	public void Movement_Entry_Integration_TS048(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Movement_Entry_Integration_TS048";
		
		
		



		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String equipmentNum48 = Excel_data.get("EquipmentNum");
		String activitySearch48 = Excel_data.get("Activity");
		String futureActivityDateError = Excel_data.get("FutureActivityDateError");
		String activityDateSingle48 = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String datePicker = Excel_data.get("DatePicker");
		
		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);
		// Login

		LRP_Login(driver, username, password);
		
		// To validate if user try to save move in future date

				//Module Search
				moduleNavigate(driver, moduleName);

		// Movement Entry
		
		Step_Start(1, "Enter all mandatory field & click save by giving activity date in future for any move", test, test1);
		// Single Entry Equipment

			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, equipmentNum48);
			
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activitySearch48);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			waitForElement(driver, activeDateInSingle_L);
			click(driver, activeDateInSingle_L);

			Extent_call(test, test1, "Entering the Date & Time period");
			if (!activityDateSingle48.equals("")) {
				waitForElement(driver, activeDateInSingle_L);


				if(datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle48);


					}else {
						click(driver, activeDateInSingle_L);

						if(activityDateSingle48.contains("-")) {
							String activityDateSingle48_1=activityDateSingle48.replace("-", "/");

							clearAndType(driver, activeDateInSingle_L, activityDateSingle48_1);

						}else {
							clearAndType(driver, activeDateInSingle_L, activityDateSingle48);

						}		
					}
			}

			if (!activityTime_Input1.equals("")) {

				click(driver, activityTime);


				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);

					clearAndType(driver, activityTime_Input, activityTime_Input1);
					System.out.println("activity_Time" + activityTime_Input1);

				}

				click(driver, activityTime_Close);
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
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

		Step_End(1, "Enter all mandatory field & click save by giving activity date in future for any move", test, test1);
		Step_Start(2, "Ensure that system should validate as 'Activity Date cannot be in future date'.", test, test1);	
		waitForElement(driver, errorRecordsFrame_L);
			String actualFutureDateError = getText(driver, futureDate_Error);

			if (actualFutureDateError.equals(futureActivityDateError)) {
				System.out.println("Matched || " + " Expected Message is : " + futureActivityDateError
						+ " || Actual Message is : " + actualFutureDateError);
				Extent_pass_New(driver, "Matched || " + " Expected Message is : " + futureActivityDateError
						+ " || Actual Message is : " + actualFutureDateError, test, test1);
				click(driver, okButtonErrorFrame_L);
			} else {
				System.out.println("Not matched || " + " Expected Message is : " + futureActivityDateError
						+ " || Actual Message  is : " + actualFutureDateError);
				Extent_fail(driver, "Not matched || " + " Expected Message is : " + futureActivityDateError
						+ " || Actual Message is : " + actualFutureDateError, test, test1);
			}
			Step_End(2, "Ensure that system should validate as 'Activity Date cannot be in future date'.", test, test1);
			Extent_completed(testcase_Name, test, test1);
		
	}
}
