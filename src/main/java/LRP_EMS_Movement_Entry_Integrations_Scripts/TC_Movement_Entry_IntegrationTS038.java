package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_IntegrationTS038 extends Keywords {
	// To validate if user try to save move with incorrect Release Ref which is not defined in supplier contract

	public void incorrectReleaseRef(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Movement_Entry_IntegrationTS038";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String eqpNumber38 = Excel_data.get("EquipmentNo1");
		String activitySearch38 = Excel_data.get("Activity");
		String invalidReferenceError = Excel_data.get("InvalidReferenceError");
		String activityDateSingle38 = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String datePicker = Excel_data.get("DatePicker");
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

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
		
		Step_Start(2,
				"Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields",
				test, test1);
		waitForElement(driver, equipmentNoSearchField_L);
		clearAndType(driver, equipmentNoSearchField_L, eqpNumber38);
		
		
		waitForElement(driver, activitySearchFieldInSingle_L);
		sendKeys(driver, activitySearchFieldInSingle_L, activitySearch38);
		waitForElement(driver, autoCompleteValue_ME);
		enter(driver);
		
		if (!activityDateSingle38.equals("")) {
			waitForElement(driver, activeDateInSingle_L);

			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, activeDateInSingle_L, activityDateSingle38);

			} else {
				click(driver, activeDateInSingle_L);

				if (activityDateSingle38.contains("-")) {
					String activityDateSingle38_1 = activityDateSingle38.replace("-", "/");
					clearAndType(driver, activeDateInSingle_L, activityDateSingle38_1);

				} else {
					clearAndType(driver, activeDateInSingle_L, activityDateSingle38);

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
		Step_End(2,
				"Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields",
				test, test1);
		waitForDisplay(driver, popup_Message);
		if (isdisplayed(driver, popup_Message)) {
			click(driver, popup_Message_Yes_Button);

			waitForDisplay(driver, showInputFieldFrame_L);
			if (isdisplayed(driver, showInputFieldFrame_L)) {
				System.out.println("Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed");
				Extent_pass_New(driver, "Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed", test, test1);
			}
		}
		
		Step_Start(3, "Ensure that system should allow user to give valid location & terminal", test, test1);
		Step_Start(4, " Ensure that system should validate if user provide incorrect release ref", test, test1);

		Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
		allElements.movementEntryAllElements(driver, Excel_data, test, test1);
		
		Step_End(3, "Ensure that system should allow user to give valid location & terminal", test, test1);
		Step_End(4, " Ensure that system should validate if user provide incorrect release ref", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		waitForElement(driver, errorRecordsFrame_L);

			String actualRefernceNumError = getText(driver, error_Invalid_Reference);
			Step_Start(5, "Ensure that system should validate as 'INVALID REFERENCE NO'", test, test1);
			if (actualRefernceNumError.equalsIgnoreCase(invalidReferenceError)) {
				System.out.println("Matched || "+invalidReferenceError + " Error is displayed ||" + " Expected Popup is : " + invalidReferenceError
						+ " || Actual Popup is : " + actualRefernceNumError);
				Extent_pass_New(driver, "Matched || "+invalidReferenceError + " Error is displayed ||" + " Expected Popup is : " + invalidReferenceError
						+ " || Actual Popup is : " + actualRefernceNumError, test, test1);
				click(driver, okButtonErrorFrame_L);

			} else {
				System.out.println("Not matched || "+invalidReferenceError + " Error is not displayed ||" + " Expected Popup is : " + invalidReferenceError
						+ " || Actual Popup  is : " + actualRefernceNumError);
				Extent_fail(driver, "Not matched || "+invalidReferenceError + " Error is not displayed ||" + " Expected Popup is : " + invalidReferenceError
						+ " || Actual Popup is : " + actualRefernceNumError, test, test1);
			}
			Step_End(5, "Ensure that system should validate as 'INVALID REFERENCE NO'", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
