package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;


import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS060 extends Keywords {

	public void Movement_Entry_Integration_TS060(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Movement_Entry_Integration_TS060";
		
		
		

		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String invalidNextMoveEqpNum = Excel_data.get("InvalidNextMoveEqpNum");
		String activityOFHI = Excel_data.get("ActivityOFHI");
		String invalidNextMovePopup = Excel_data.get("InvalidNextMovePopup");
		String activityDateSingle60 = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String datePicker = Excel_data.get("DatePicker");
		String showAllMoves = Excel_data.get("ShowAllMoves");

		// Login
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		//// To validate invalid move if user try to insert in between next move
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

				//Module Search
				moduleNavigate(driver, moduleName);
				
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);
		// Movement Entry

		// Single Entry Equipment
		waitForElement(driver, singleEntryMovPage_L);

		Step_Start(2,
					"Ensure that system should validate if user try to insert incorrect inbetween next move which is not mapped in sequence group",
					test, test1);
			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, invalidNextMoveEqpNum);
			Step_End(2,
					"Ensure that system should validate if user try to insert incorrect inbetween next move which is not mapped in sequence group",
					test, test1);
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activityOFHI);
			enter(driver);
			waitForElement(driver, activeDateInSingle_L);
			click(driver, activeDateInSingle_L);
			if (!activityDateSingle60.equals("")) {
				waitForElement(driver, activeDateInSingle_L);
				click(driver, activeDateInSingle_L);

				if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateInSingle_L, activityDateSingle60);
					
				} else {
					if (activityDateSingle60.contains("-")) {
						String activityDateSingle60_1 = activityDateSingle60.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDateSingle60_1);
					} else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle60);

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

		
		Step_Start(3, "Ensure that system should validate as ' Invalid Next Move'.", test, test1);
		waitForPopup(driver, popup_Message, invalidNextMovePopup);

			String actualInvalidNextMovePopup = getText(driver, popup_Message);

			if (actualInvalidNextMovePopup.equals(invalidNextMovePopup)) {
				System.out.println("Matched || " + " Expected Popup is : " + invalidNextMovePopup
						+ " || Actual Popup is : " + actualInvalidNextMovePopup);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + invalidNextMovePopup
						+ " || Actual Popup is : " + actualInvalidNextMovePopup, test, test1);
				click(driver, popup_Message_Ok_Button);
			} else {
				System.out.println("Not matched || " + " Expected Popup is : " + invalidNextMovePopup
						+ " || Actual Popup  is : " + actualInvalidNextMovePopup);
				Extent_fail(driver, "Not matched || " + " Expected Popup is : " + invalidNextMovePopup
						+ " || Actual Popup is : " + actualInvalidNextMovePopup, test, test1);
				
			}

		
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);
		}
		
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_No_Button);
		}
		waitForElement(driver, showAllMoves_CheckBox);
		checkBox(driver, showAllMoves_CheckBox, showAllMoves);

		Step_End(3, "Ensure that system should validate as ' Invalid Next Move'.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
