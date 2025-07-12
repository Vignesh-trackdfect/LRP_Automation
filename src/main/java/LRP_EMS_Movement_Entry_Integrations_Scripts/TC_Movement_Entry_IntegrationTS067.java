package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_IntegrationTS067 extends Keywords {
	//// To Validate in Booking if the container & booking size type mismatched

	public void theContainerAndBookingSizeTypeMismatched(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Movement_Entry_IntegrationTS067";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String datePicker = Excel_data.get("datePicker");
		String lodfActivity67 = Excel_data.get("LodfActivity");
		String eqpNumMulti = Excel_data.get("EqpNumMulti");
		String activityDateSingle67 = Excel_data.get("activityDateSingle67");
		String sizeTypeMismatchError = Excel_data.get("SizeTypeMismatchError");
		String activityTime_Input1 = Excel_data.get("activityTime_Input1");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
//		Module Search
		moduleNavigate(driver, moduleName);

		// Movement Entry

		// Multiple Equipment Entry

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);

		waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, lodfActivity67);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			if (!activityDateSingle67.equals("")) {
				waitForElement(driver, MultiActivity_Date);
				if(datePicker.equalsIgnoreCase("Yes")) {
					Extent_call(test, test1, "Entering the date,month & year");
						selectDatePicker(driver, MultiActivity_Date, activityDateSingle67);
				}else {
					if(activityDateSingle67.contains("-")) {
						String activityDateSingle50_1=activityDateSingle67.replace("-", "/");
						clearAndType(driver, MultiActivity_Date, activityDateSingle50_1);
					}else {
					clearAndType(driver, MultiActivity_Date, activityDateSingle67);
					
					}		
				}
			}
			
			if (!activityTime_Input1.equals("")) {
				
				click(driver, activityTimeMultiple);

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
			
			Step_Start(1, " Ensure that system should validate if user try to save LODF move by giving incorrect size/type booking which is not matched the size type of container movement", test, test1);
			
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, Excel_data, test, test1);
			
			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);

			waitForElement(driver, selectGridCell_1_L);
			click(driver, selectGridCell_1_L);
			sendKeys(driver, eqpNum_Inputfield, eqpNumMulti);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

		Step_End(1, " Ensure that system should validate if user try to save LODF move by giving incorrect size/type booking which is not matched the size type of container movement", test, test1);
		Step_Start(2, "Ensure that system should validate as 'Size type mismatch with Booking'.", test, test1);
		
		waitForDisplay(driver, forcebtn);
		if(isdisplayed(driver, forcebtn)) {
			click(driver, forcebtn);
		}

		waitForPopup(driver, sizeType_Mismatch_Error, sizeTypeMismatchError);

			String actualSizeTypeError = getText(driver, sizeType_Mismatch_Error);

			if (actualSizeTypeError.equals(sizeTypeMismatchError)) {
				System.out.println("Matched || " +sizeTypeMismatchError + " Error is displayed ||"+ " Expected Message is : " + sizeTypeMismatchError
						+ " || Actual Message is : " + actualSizeTypeError);
				Extent_pass_New(driver, "Matched || " +sizeTypeMismatchError + " Error is displayed ||"+ " Expected Message is : " + sizeTypeMismatchError
						+ " || Actual Message is : " + actualSizeTypeError, test, test1);
			} else {
				System.out.println("Not matched || "+sizeTypeMismatchError + " Error is not displayed ||" + " Expected Message is : " + sizeTypeMismatchError
						+ " || Actual Message  is : " + actualSizeTypeError);
				Extent_fail(driver, "Not matched || "+sizeTypeMismatchError + " Error is not displayed ||" + " Expected Message is : " + sizeTypeMismatchError
						+ " || Actual Message is : " + actualSizeTypeError, test, test1);
			}
			click(driver, okButtonErrorFrame_L);
			Step_End(2, "Ensure that system should validate as 'Size type mismatch with Booking'.", test, test1);
			Extent_completed(testCaseName, test, test1);
	}
}
