package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_IntegrationTS065 extends Keywords {

	public void SOCNotAllowedForONHI(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Movement_Entry_IntegrationTS065";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String activityONHI = Excel_data.get("ActivityONHI");
		String sOCNotAllowedError = Excel_data.get("SOCNotAllowedError");
		String equipmentNum65 = Excel_data.get("EquipmentNum");
		String activityDateSingle65 = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String datePicker = Excel_data.get("DatePicker");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);

		//// To validate SOC not allowed for ONHI
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);


		//		Module Search
		moduleNavigate(driver, moduleName);

		// Movement Entry
		waitForDisplay(driver, movementEntryPage_L);
		if (isdisplayed(driver, movementEntryPage_L)) {
			System.out.println("Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed");
			Extent_pass_New(driver, "Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is displayed", test, test1);
		} else {
			System.out.println("Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed");
			Extent_fail(driver, "Not Matched || Expected : Movement Entry Page should be displayed || Actual : Movement Entry Page is not displayed", test, test1);
		}

		Step_End(1, "Enter module name in searchbox & click the module", test, test1);
		Step_Start(2, "try to save ONHI move by giving 'Y' in SOC field", test, test1);
		// Multiple Equipment Entry

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);

		waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, activityONHI);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);

			if (!activityDateSingle65.equals("")) {
				waitForElement(driver, activeDateField_L);
				if(datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateField_L, activityDateSingle65);
					}else {
						if(activityDateSingle65.contains("-")) {
							String activityDateSingle65_1=activityDateSingle65.replace("-", "/");
							clearAndType(driver, activeDateField_L, activityDateSingle65_1);

						}else {
							clearAndType(driver, activeDateField_L, activityDateSingle65);

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

			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, Excel_data, test, test1);
			
			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);

			waitForElement(driver, selectGridCell_1_L);
			click(driver, selectGridCell_1_L);
			waitForElement(driver, searchEqpNoInGrid_1_L);
			sendKeys(driver, searchEqpNoInGrid_1_L, equipmentNum65);


			scrollTop(driver);
			waitForElement(driver, saveButtonMoveEnt_L);
			click(driver, saveButtonMoveEnt_L);

		waitForDisplay(driver, errorRecordsFrame_L);
		if (isDisplayed(driver, errorRecordsFrame_L)) {
			if (isDisplayed(driver, errorRecApply_L)) {
				click(driver, errorRecApply_L);
			} else if (isDisplayed(driver, okButtonErrorFrame_L)) {
				click(driver, okButtonErrorFrame_L);
			}
		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(2, "try to save ONHI move by giving 'Y' in SOC field", test, test1);
		Step_Start(3, "Ensure that system should validate as 'SOC IS NOT ALLOWED FOR ONHIRE'.", test, test1);

		waitForPopup(driver, soc_Not_Allowed_Error2, sOCNotAllowedError);

			String actualSOCNotAllowedError = getText(driver, soc_Not_Allowed_Error2);

			if (actualSOCNotAllowedError.equals(sOCNotAllowedError)) {
				System.out.println("Matched || " +sOCNotAllowedError + " Error is displayed ||"+ " Expected Message is : " + sOCNotAllowedError
						+ " || Actual Message is : " + actualSOCNotAllowedError);
				Extent_pass_New(driver, "Matched || "+sOCNotAllowedError + " Error is displayed ||" + " Expected Message is : " + sOCNotAllowedError
						+ " || Actual Message is : " + actualSOCNotAllowedError, test, test1);
				click(driver, okButtonErrorFrame_L);
			} else {
				System.out.println("Not matched || "+sOCNotAllowedError + " Error is not displayed ||" + " Expected Message is : " + sOCNotAllowedError
						+ " || Actual Message  is : " + actualSOCNotAllowedError);
				Extent_fail(driver, "Not matched || "+sOCNotAllowedError + " Error is not displayed ||" + " Expected Message is : " + sOCNotAllowedError
						+ " || Actual Message is : " + actualSOCNotAllowedError, test, test1);
			}
		Step_End(3, "Ensure that system should validate as 'SOC IS NOT ALLOWED FOR ONHIRE'.", test, test1);
		Extent_completed(testCaseName, test, test1);
	}

}
