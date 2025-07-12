package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_IntegrationTS063 extends Keywords {
	//// To validate if user try to save with incorrect ref

	public void toSaveWithIncorrectRef(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Movement_Entry_IntegrationTS063";


		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");

		String containerNumTS63 = Excel_data.get("ContainerNumTS63");
		String movementNotAllowedError = Excel_data.get("MovementNotAllowedError");
		String activitySUBL63 = Excel_data.get("ActivitySUBL");
		String activityDateSingle63 = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String datePicker = Excel_data.get("DatePicker");
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);
		
		// Login

		LRP_Login(driver, username, password);

		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
		
//		Module Search
		moduleNavigate(driver, moduleName);

		// Movement Entry
		
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		// Multiple Equipment Entry

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);

		waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, activitySUBL63);
			waitForDisplay(driver, autoCompleteValue_ME);
			enter(driver);
			if (!activityDateSingle63.equals("")) {
				waitForElement(driver, activeDateField_L);
				if (datePicker.equalsIgnoreCase("Yes")) {
					
						selectDatePicker(driver, activeDateField_L, activityDateSingle63);
					
				} else {
					if (activityDateSingle63.contains("-")) {
						String activityDateSingle63_1 = activityDateSingle63.replace("-", "/");
						clearAndType(driver, activeDateField_L, activityDateSingle63_1);

					} else {
						clearAndType(driver, activeDateField_L, activityDateSingle63);

					}
				}
			}

			if (!activityTime_Input1.equals("")) {
				click(driver, activityTimeMultiple);

				waitForElement(driver, Calender);
				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);

					clearAndType(driver, activityTime_Input, activityTime_Input1);
					System.out.println("activity_Time" + activityTime_Input1);

				}
				click(driver, activityTime_Close);
			} else {
				System.out.println("activityTime " + "Input Not Available in test data");
			}
			waitForElement(driver, showInputButton);
			click(driver, showInputButton);
		

			waitForDisplay(driver, showInputFieldFrame_L);
			if (isdisplayed(driver, showInputFieldFrame_L)) {
				System.out.println("Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed");
				Extent_pass_New(driver, "Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed", test, test1);
			}
		Step_Start(2,
				"Ensure that system should validate if user try to save SUBL move by giving supplier ref in release ref field instead of sublease reference",
				test, test1);

		Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
		allElements.movementEntryAllElements(driver, Excel_data, test, test1);
		
		waitForElement(driver, addButtonMulti_L);
		click(driver, addButtonMulti_L);
		
		waitForElement(driver, selectGridCell_1_L);
		click(driver, selectGridCell_1_L);
		
		waitForElement(driver, eqpNum_Inputfield);
		sendKeys(driver, eqpNum_Inputfield, containerNumTS63);
		
		Step_End(2,
				"Ensure that system should validate if user try to save SUBL move by giving supplier ref in release ref field instead of sublease reference",
				test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_Start(3, " Ensure that system should validate as ' This movement is not allowed for the Contract'.", test,
				test1);
		waitForPopup(driver, movemet_Not_Allowed_Error, movementNotAllowedError);

			String actualMoveNotAllowedError = getText(driver, movemet_Not_Allowed_Error);

			if (actualMoveNotAllowedError.equals(movementNotAllowedError)) {
				System.out.println("Matched || "+movementNotAllowedError + " Error is displayed ||" + " Expected Message is : " + movementNotAllowedError
						+ " || Actual Message is : " + actualMoveNotAllowedError);
				Extent_pass_New(driver, "Matched || "+movementNotAllowedError + " Error is displayed ||" + " Expected Message is : " + movementNotAllowedError
						+ " || Actual Message is : " + actualMoveNotAllowedError, test, test1);
				click(driver, okButtonErrorFrame_L);
			} else {
				System.out.println("Not matched || "+movementNotAllowedError + " Error is not displayed ||" + " Expected Message is : " + movementNotAllowedError
						+ " || Actual Message  is : " + actualMoveNotAllowedError);
				Extent_fail(driver, "Not matched || "+movementNotAllowedError + " Error is not displayed ||" + " Expected Message is : " + movementNotAllowedError
						+ " || Actual Message is : " + actualMoveNotAllowedError, test, test1);
			}

		Step_End(3, " Ensure that system should validate as ' This movement is not allowed for the Contract'.", test,
				test1);
		Extent_completed(testCaseName, test, test1);
	}
}
