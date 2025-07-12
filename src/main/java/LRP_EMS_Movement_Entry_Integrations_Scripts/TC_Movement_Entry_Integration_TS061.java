package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS061 extends Keywords {

	public void Movement_Entry_Integration_TS061(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {


		String testcase_Name = "TC_Movement_Entry_Integration_TS061";
		
		
		

		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String invalidPrevMoveEqpNum = Excel_data.get("InvalidPrevMoveEqpNum");
		String invalidPrevMovePopup = Excel_data.get("InvalidPrevMovePopup");
		String activitySALE = Excel_data.get("ActivitySALE");
		String activityDateSingle61 = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String datePicker = Excel_data.get("DatePicker");
		String showAllMoves = Excel_data.get("ShowAllMoves");

		// Login
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		// To validate invalid move if user try to insert in between previous move
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

				//Module Search
				moduleNavigate(driver, moduleName);
				
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		// Movement Entry
		

		// Single Entry Equipment
		waitForElement(driver, singleEntryMovPage_L);
			Step_Start(2,
					"Ensure that system should validate if user try to insert incorrect inetween previous move which is not mapped in sequence group",
					test, test1);
			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, invalidPrevMoveEqpNum);
			Step_End(2,
					"Ensure that system should validate if user try to insert incorrect inetween previous move which is not mapped in sequence group",
					test, test1);
			waitForElement(driver, activitySearchFieldInSingle_L);
			click(driver, activitySearchFieldInSingle_L);
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activitySALE);
			waitForDisplay(driver, autoCompleteValue_ME);
			enter(driver);
			
			waitForElement(driver, activeDateInSingle_L);
			click(driver, activeDateInSingle_L);
			if (!activityDateSingle61.equals("")) {
				waitForElement(driver, activeDateInSingle_L);
				if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateInSingle_L, activityDateSingle61);
					
				} else {
					if (activityDateSingle61.contains("-")) {
						String activityDateSingle61_1 = activityDateSingle61.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDateSingle61_1);

					} else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle61);

					}
				}
			}
			Extent_call(test, test1, "Entering the time data");
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

		Step_Start(3, "Ensure that system should validate as ' Invalid Previous Move'.", test, test1);
	
		waitForPopup(driver, popup_Message, invalidPrevMovePopup);

			String actualInvalidPrevMovePopup = getText(driver, popup_Message);

			if (actualInvalidPrevMovePopup.equals(invalidPrevMovePopup)) {
				System.out.println("Matched || " + " Expected Popup is : " + invalidPrevMovePopup
						+ " || Actual Popup is : " + actualInvalidPrevMovePopup);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + invalidPrevMovePopup
						+ " || Actual Popup is : " + actualInvalidPrevMovePopup, test, test1);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not matched || " + " Expected Popup is : " + invalidPrevMovePopup
						+ " || Actual Popup  is : " + actualInvalidPrevMovePopup);
				Extent_fail(driver, "Not matched || " + " Expected Popup is : " + invalidPrevMovePopup
						+ " || Actual Popup is : " + actualInvalidPrevMovePopup, test, test1);
			}


		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
		click(driver, popup_Message_No_Button);
		}
		
		waitForElement(driver, showAllMoves_CheckBox);
		checkBox(driver, showAllMoves_CheckBox, showAllMoves);
		
		Step_End(3, "Ensure that system should validate as ' Invalid Previous Move'.", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
