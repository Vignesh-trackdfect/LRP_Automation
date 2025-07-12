package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_IntegrationTS037 extends Keywords {
	
	//// To validate if user try to save move with incorrect location which is not defined in supplier contract

	public void toSaveMoveWithTncorrectLocation(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Movement_Entry_IntegrationTS037";


		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String activitySearch37 = Excel_data.get("Activity");
		String eqpNumber = Excel_data.get("EquipmentNo1");
		String invalidPortCodeError = Excel_data.get("InvalidPortCodeError");
		String invalidSizeTypeError = Excel_data.get("InvalidSize/TypeError");
		
		String activityDateSingle37 = Excel_data.get("ActivityDate");
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

		
		Step_Start(2,"Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields",test, test1);
		
		Extent_call(test, test1, "giving valid container number");
		waitForElement(driver, equipmentNoSearchField_L);
		clearAndType(driver, equipmentNoSearchField_L, eqpNumber);
		
		waitForElement(driver, activitySearchFieldInSingle_L);
		sendKeys(driver, activitySearchFieldInSingle_L, activitySearch37);
		waitForElement(driver, autoCompleteValue_ME);
		enter(driver);
		
		if (!activityDateSingle37.equals("")) {
			waitForElement(driver, activeDateInSingle_L);

			if (datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, activeDateInSingle_L, activityDateSingle37);

			} else {
				click(driver, activeDateInSingle_L);

				if (activityDateSingle37.contains("-")) {
					String activityDateSingle37_1 = activityDateSingle37.replace("-", "/");
					clearAndType(driver, activeDateInSingle_L, activityDateSingle37_1);

				} else {
					clearAndType(driver, activeDateInSingle_L, activityDateSingle37);

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

		Step_Start(3,
				"Ensure that system should validate if user provide incorrect location & terminal which is not mapped in given reference",
				test, test1);
		
		Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
		allElements.movementEntryAllElements(driver, Excel_data, test, test1);
		
		Step_End(3,
				"Ensure that system should validate if user provide incorrect location & terminal which is not mapped in given reference",
				test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_Start(4,
				"Ensure that system should validate as 'Invalid PortCode for this Reference No and Invalid size type for this Reference No",
				test, test1);
		waitForElement(driver, errorRecordsFrame_L);

			String actualPortCodeError = getText(driver, error_Invalid_PortCode);
			String actualSizeTypeError = getText(driver, error_Invalid_size_type);

			if (actualPortCodeError.equalsIgnoreCase(invalidPortCodeError)) {
				System.out.println("Matched || "+invalidPortCodeError + " Error is displayed ||" + " Expected Message : " + invalidPortCodeError
						+ " || Actual Message : " + actualPortCodeError);
				Extent_pass_New(driver, "Matched || "+invalidPortCodeError + " Error is displayed ||" + " Expected Message : " + invalidPortCodeError
						+ " || Actual Message : " + actualPortCodeError, test, test1);
			} else {
				System.out.println("Not matched || "+invalidPortCodeError + " Error is not displayed ||" + " Expected Message : " + invalidPortCodeError
						+ " || Actual Message : " + actualPortCodeError);
				Extent_fail(driver, "Not matched || "+invalidPortCodeError + " Error is not displayed ||" + " Expected Message : " + invalidPortCodeError
						+ " || Actual Message : " + actualPortCodeError, test, test1);
			}
			Extent_call(test, test1, "verifying Invalid size/type for this Reference No'.");
			if (actualSizeTypeError.equalsIgnoreCase(invalidSizeTypeError)) {
				System.out.println("Matched || "+invalidSizeTypeError + " Error is displayed ||" + " Expected Message : " + invalidSizeTypeError
						+ " || Actual Message : " + actualSizeTypeError);
				Extent_pass_New(driver, "Matched || "+invalidSizeTypeError + " Error is displayed ||" + " Expected Message : " + invalidSizeTypeError
						+ " || Actual Message : " + actualSizeTypeError, test, test1);
			} else {
				System.out.println("Not matched || "+invalidSizeTypeError + " Error is not displayed ||" + " Expected Message : " + invalidSizeTypeError
						+ " || Actual Message : " + actualSizeTypeError);
				Extent_fail(driver, "Not matched || "+invalidSizeTypeError + " Error is not displayed ||" + " Expected Message : " + invalidSizeTypeError
						+ " || Actual Message : " + actualSizeTypeError, test, test1);
			}
			click(driver, okButtonErrorFrame_L);

		Step_End(4,
				"Ensure that system should validate as 'Invalid PortCode for this Reference No and Invalid size type for this Reference No",
				test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
