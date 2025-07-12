package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Movement_Entry_IntegrationTS036 extends Keywords {

	public void invalidFormatIsGivenInEquipmentNo(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Movement_Entry_IntegrationTS036";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String invalidEqpNo = Excel_data.get("InvalidEqpNumber");
		String invalidEqpNoPopup = Excel_data.get("InvalidEquipmentNumberPopup");
		String activitySearch36 = Excel_data.get("Activity");
		String activityDateSingle = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String datePicker = Excel_data.get("DatePicker");
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		
		// Login

	LRP_Login(driver, username, password);

		// To Check Validation if invalid format is given in Equipment no for single
		// entry
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

		
Step_Start(2, "Ensure system should validate if user given invalid format characters in equipment no field", test, test1);
		
		clearAndType(driver, equipmentNoSearchField_L, invalidEqpNo);
		
Step_End(2, "Ensure system should validate if user given invalid format characters in equipment no field", test, test1);
		
		waitForElement(driver, activitySearchFieldInSingle_L);
		sendKeys(driver, activitySearchFieldInSingle_L, activitySearch36);
		waitForElement(driver, autoCompleteValue_ME);
		enter(driver);

		
			if (!activityDateSingle.equals("")) {
				waitForElement(driver, activeDateInSingle_L);

				if (datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle);

				} else {
					click(driver, activeDateInSingle_L);

					if (activityDateSingle.contains("-")) {
						String activityDateSingle_1 = activityDateSingle.replace("-", "/");
						clearAndType(driver, activeDateInSingle_L, activityDateSingle_1);

					} else {
						clearAndType(driver, activeDateInSingle_L, activityDateSingle);

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
		
		Step_Start(3, "clicking the show input field", test, test1);
		waitForElement(driver, showInputSin_L);
		click(driver, showInputSin_L);
		Step_End(3, "clicking the show input field", test, test1);
		
		Step_Start(4, "Ensure that system should validate as 'Invalid Equipment Number. Check Digit is not applicable' when clicked show input fields after providing incorrect container no", test, test1);

		waitForPopup(driver, Popup_Message, invalidEqpNoPopup);

		String actualInvalidEqpNumPopup = getText(driver, Popup_Message);
		if (actualInvalidEqpNumPopup.equals(invalidEqpNoPopup)) {
			System.out.println("Matched || "+invalidEqpNoPopup + " popup is displayed ||" + " Expected Popup : " + invalidEqpNoPopup + " || Actual Popup : "
					+ actualInvalidEqpNumPopup);
			Extent_pass_New(driver, "Matched || "+invalidEqpNoPopup + " popup is displayed ||" + " Expected Popup : " + invalidEqpNoPopup + " || ActualPopup : "
					+ actualInvalidEqpNumPopup, test, test1);
		} else {
			System.out.println("Not matched || "+invalidEqpNoPopup + " popup is not displayed ||" + " Expected Popup : " + invalidEqpNoPopup
					+ " || Actual Popup  is : " + actualInvalidEqpNumPopup);
			Extent_fail(driver, "Not matched || "+invalidEqpNoPopup + " popup is not displayed ||" + " Expected Popup : " + invalidEqpNoPopup
					+ " || Actual Popup : " + actualInvalidEqpNumPopup, test, test1);
		}
		Step_End(4, "Ensure that system should validate as 'Invalid Equipment Number. Check Digit is not applicable' when clicked show input fields after providing incorrect container no", test, test1);
	
		Extent_completed(testCaseName, test, test1);

	
	}
}
