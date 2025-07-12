package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Movement_Entry_IntegrationTS034 extends Keywords {

	public void toValidateForBlankActivity(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Movement_Entry_IntegrationTS034";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String equipmentNum = Excel_data.get("EquipmentNum");
		String selectActivity = Excel_data.get("SelectActivity");

		
		String activityDateSingle34 = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String datePicker = Excel_data.get("DatePicker");
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);
		
		// Login
		LRP_Login(driver, username, password);

		//// To Validate for Blank Activity
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//		Module Search
		moduleNavigate(driver, moduleName);
		
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		// Movement Entry
		Extent_call(test, test1, "Navigating to Movement Entry Page");
		
		waitForDisplay(driver, movementEntryPage_L);
		if (isdisplayed(driver, movementEntryPage_L)) {
			System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
			Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
		} else {
			System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
			Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
		}
		
		
		clearAndType(driver, equipmentNoSearchField_L, equipmentNum);
		
		Step_Start(2, "selecting the date", test, test1);
		
		if (!activityDateSingle34.equals("")) {
			waitForElement(driver, activeDateInSingle_L);

			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, activeDateInSingle_L, activityDateSingle34);

			} else {
				click(driver, activeDateInSingle_L);

				if (activityDateSingle34.contains("-")) {
					String activityDateSingle34_1 = activityDateSingle34.replace("-", "/");
					clearAndType(driver, activeDateInSingle_L, activityDateSingle34_1);

				} else {
					clearAndType(driver, activeDateInSingle_L, activityDateSingle34);

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
		Step_End(2, "selecting the date", test, test1);
		Step_Start(3, "clicking the show input field by giving blank activity field", test, test1);

		waitForElement(driver, showInputFieldsButton_L);
		click(driver, showInputFieldsButton_L);
		Step_End(3, "clicking the show input field by giving blank activity field", test, test1);

		Step_Start(4, "Ensure that system should validate as 'Select Activity'.", test, test1);
		
		waitForPopup(driver, Popup_Message, selectActivity);

		String actualSelectActivityPopup = getText(driver, Popup_Message);
		if (actualSelectActivityPopup.equals(selectActivity)) {
			System.out.println("Matched || "+selectActivity + " popup is displayed" + " || Expected Popup : " + selectActivity + " || Actual Popup : "
					+ actualSelectActivityPopup);
			Extent_pass_New(driver, "Matched || "+selectActivity + " popup is displayed" + " || Expected Popup : " + selectActivity + " || Actual Popup : "
					+ actualSelectActivityPopup, test, test1);
		} else {
			System.out.println("Not matched || "+selectActivity + " popup is not displayed" + " || Expected Popup : " + selectActivity + " || Actual Popup : "
					+ actualSelectActivityPopup);
			Extent_fail(driver, "Not matched || "+selectActivity + " popup is not displayed" + " || Expected Popup : " + selectActivity + " || Actual Popup : "
					+ actualSelectActivityPopup, test, test1);
		}

		Step_End(4, "Ensure that system should validate as 'Select Activity'.", test, test1);
		Extent_completed(testCaseName, test, test1);

	}
}
