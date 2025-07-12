package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Movement_Entry_IntegrationTS042 extends Keywords {
	// To show warning message when user try to save multiple move with same activity date

	public void toSaveMultipleMoveWithSameActivityDate(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Movement_Entry_IntegrationTS042";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String ctrDuplicatedPopup = Excel_data.get("CTRDuplicated");
		String savedEqpNumber = Excel_data.get("SavedEqpNumber");
		String activitySearch42 = Excel_data.get("Activity");
		String datePicker = Excel_data.get("DatePicker");
		
		String activityDateSingle42 = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String showAllMoves = Excel_data.get("ShowAllMoves");

		navigateUrl(driver, url);

		// Login
		Extent_Start(testCaseName, test, test1);

		LRP_Login(driver, username, password);

		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//		Module Search
		moduleNavigate(driver, moduleName);
		
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);
		// Movement Entry
		waitForDisplay(driver, movementEntryPage_L);
		if (isdisplayed(driver, movementEntryPage_L)) {
			System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
			Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
		} else {
			System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
			Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
		}

		waitForElement(driver, equipmentNoSearchField_L);
		clearAndType(driver, equipmentNoSearchField_L, savedEqpNumber);
		waitForElement(driver, activitySearchFieldInSingle_L);
		sendKeys(driver, activitySearchFieldInSingle_L, activitySearch42);
		waitForDisplay(driver, autoCompleteValue_ME);
		enter(driver);

		Step_Start(2,
				" Ensure that system should validate when user try to save multiple move in same acitivty date & time",
				test, test1);
		if (!activityDateSingle42.equals("")) {
			waitForElement(driver, activeDateInSingle_L);

			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, activeDateInSingle_L, activityDateSingle42);

			} else {
				click(driver, activeDateInSingle_L);

				if (activityDateSingle42.contains("-")) {
					String activityDateSingle42_1 = activityDateSingle42.replace("-", "/");
					clearAndType(driver, activeDateInSingle_L, activityDateSingle42_1);

				} else {
					clearAndType(driver, activeDateInSingle_L, activityDateSingle42);

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
		
		Step_End(2,
				" Ensure that system should validate when user try to save multiple move in same acitivty date & time",
				test, test1);

		Extent_call(test, test1, "Clicking on show input field");
		waitForElement(driver, showInputSin_L);
		click(driver, showInputSin_L);
		Step_Start(3,
				"Ensure that system should validate as 'CTR has duplicated date-time activities' when user click on show input fields",
				test, test1);
		waitForPopup(driver, Popup_Message, ctrDuplicatedPopup);

			String actualCTRPopup = getText(driver, Popup_Message);
			Extent_call(test, test1, "Comparing the actual and expected popups");
			if (actualCTRPopup.equals(ctrDuplicatedPopup)) {
				System.out.println("Matched || " +ctrDuplicatedPopup + " popup is displayed ||"+ " Expected Popup is : " + ctrDuplicatedPopup
						+ " || Actual Popup is : " + actualCTRPopup);
				Extent_pass_New(driver, "Matched || " +ctrDuplicatedPopup + " popup is displayed ||"+ " Expected Popup is : " + ctrDuplicatedPopup
						+ " || Actual Popup is : " + actualCTRPopup, test, test1);
			} else {
				System.out.println("Not matched || "+ctrDuplicatedPopup + " popup is not displayed ||" + " Expected Popup is : " + ctrDuplicatedPopup
						+ " || Actual Popup  is : " + actualCTRPopup);
				Extent_fail(driver, "Not matched || " +ctrDuplicatedPopup + " popup is not displayed ||"+ " Expected Popup is : " + ctrDuplicatedPopup
						+ " || Actual Popup is : " + actualCTRPopup, test, test1);
			}
			Step_End(3,
					"Ensure that system should validate as 'CTR has duplicated date-time activities' when user click on show input fields",
					test, test1);

		waitForElement(driver, showAllMoves_CheckBox);
		checkBox(driver, showAllMoves_CheckBox, showAllMoves);

		Extent_completed(testCaseName, test, test1);

	}
}
