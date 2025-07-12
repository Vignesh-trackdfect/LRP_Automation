package LRP_EMS_Movement_Entry_Integrations_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_IntegrationTS064 extends Keywords {

	public void invalidScaleOutReferenceInRTNL(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Movement_Entry_IntegrationTS064";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String activityRTNL = Excel_data.get("ActivityRTNL");
		String eqpNumberRTNL = Excel_data.get("EqpNumberRTNL");
		String invalidScaleOutReferenceError = Excel_data.get("InvalidScaleOutReferenceError");
		String activityDateSingle64 = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String datePicker = Excel_data.get("DatePicker");
		
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login
		LRP_Login(driver, username, password);
		
		// To validate Invalid Scale out reference in RTNL
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
			sendKeys(driver, activitySearchField_L, activityRTNL);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			if (!activityDateSingle64.equals("")) {
				waitForElement(driver, activeDateField_L);
				if(datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateField_L, activityDateSingle64);
						
				}else {
					if(activityDateSingle64.contains("-")) {
						String activityDateSingle64_1=activityDateSingle64.replace("-", "/");
						clearAndType(driver, activeDateField_L, activityDateSingle64_1);
						
					}else {
					clearAndType(driver, activeDateField_L, activityDateSingle64);
					
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

			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, Excel_data, test, test1);
			
		waitForElement(driver, addButtonMulti_L);
		click(driver, addButtonMulti_L);

		waitForElement(driver, selectGridCell_1_L);
		click(driver, selectGridCell_1_L);
		
		Step_Start(2, "Ensure that system should validate if user try to save RTNL move by giving SUBL ref in RTNL move", test, test1);
		
		waitForDisplay(driver, eqpNum_Inputfield);
		sendKeys(driver, eqpNum_Inputfield, eqpNumberRTNL);
		waitForElement(driver, eqpNum_Inputfield);

		Step_End(2, "Ensure that system should validate if user try to save RTNL move by giving SUBL ref in RTNL move", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_Start(3, "Ensure that system should validate as 'Invalid Scale out reference'.", test, test1);
		
		waitForPopup(driver, invalid_Scale_Out_Error, invalidScaleOutReferenceError);

			String actuainvalidScaleOutError = getText(driver, invalid_Scale_Out_Error);

			if (actuainvalidScaleOutError.equals(invalidScaleOutReferenceError)) {
				System.out.println("Matched || " +invalidScaleOutReferenceError + " Error is displayed ||"+ " Expected Message is : " + invalidScaleOutReferenceError
						+ " || Actual Message is : " + actuainvalidScaleOutError);
				Extent_pass_New(driver, "Matched || " +invalidScaleOutReferenceError + " Error is displayed ||"+ " Expected Message is : " + invalidScaleOutReferenceError
						+ " || Actual Message is : " + actuainvalidScaleOutError, test, test1);
				click(driver, okButtonErrorFrame_L); 
			} else {
				System.out.println("Not matched || "+invalidScaleOutReferenceError + " Error is not displayed ||" + " Expected Message is : " + invalidScaleOutReferenceError
						+ " || Actual Message  is : " + actuainvalidScaleOutError);
				Extent_fail(driver, "Not matched || " +invalidScaleOutReferenceError + " Error is not displayed ||"+ " Expected Message is : " + invalidScaleOutReferenceError
						+ " || Actual Message is : " + actuainvalidScaleOutError, test, test1);
			}

		Step_End(3, "Ensure that system should validate as 'Invalid Scale out reference'.", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}
