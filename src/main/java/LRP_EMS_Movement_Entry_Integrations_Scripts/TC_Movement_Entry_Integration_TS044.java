package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS044 extends Keywords {

	public void Movement_Entry_Integration_TS044(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Movement_Entry_Integration_TS044";
		
		
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String activitySNTS44 = Excel_data.get("ActivitySNTS");
		String invalidPrevLocError = Excel_data.get("InvalidPrevLocPopup");
		String equipmentNumForSNTS = Excel_data.get("EquipmentNumForSNTS");
		String activityDate44=Excel_data.get("ActivityDate");
		String datePicker=Excel_data.get("DatePicker");
		String activityTime_Input1=Excel_data.get("ActivityTime");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);
		// Login

	LRP_Login(driver, username, password);

		//To validate if user try to save SNTS with location not matching with previous move ONHI
		
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
		
		Step_Start(1, "Ensure that system should allow user to enter valid container no in movement entry", test, test1);
		waitForElement(driver, equipmentNoSearchField_L);
		clearAndType(driver, equipmentNoSearchField_L, equipmentNumForSNTS);
		
		Step_End(1, "Ensure that system should allow user to enter valid container no in movement entry", test, test1);
		Step_Start(2, "Ensure that system should validate when user try to enter incorrect location which is not matched with previous location based on sequence group ", test, test1);

		waitForElement(driver, activitySearchFieldInSingle_L);
		sendKeys(driver, activitySearchFieldInSingle_L, activitySNTS44);
		waitForElement(driver, autoCompleteValue_ME);
		enter(driver);
		
		
		if (!activityDate44.equals("")) {
			waitForElement(driver, activeDateInSingle_L);
			
			if(datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, activeDateInSingle_L, activityDate44);
	
					
			}else {
				click(driver, activeDateInSingle_L);

				if(activityDate44.contains("-")) {
					String activityDate44_1=activityDate44.replace("-", "/");
					clearAndType(driver, activeDateInSingle_L, activityDate44_1);
					
				}else {
				clearAndType(driver, activeDateInSingle_L, activityDate44);
				
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
		
		Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
		allElements.movementEntryAllElements(driver, Excel_data, test, test1);
		
		Step_End(2, "Ensure that system should validate when user try to enter incorrect location which is not matched with previous location based on sequence group ", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		Step_Start(3, "Ensure that system should validate as 'INVALID PREV LOCATIONAL ACTIVITY PLACE OR DEPOT\r\n"
				+ " ' due to location not matched bases on movement sequence setup", test, test1);
		waitForPopup(driver, error_Invalid_PrevCode, invalidPrevLocError);
			
			String actualInvalidPrevLocError=getText(driver, error_Invalid_PrevCode);
							
			if(actualInvalidPrevLocError.equals(invalidPrevLocError)) {
				System.out.println("Matched || " + " Expected Message is : " + invalidPrevLocError + " || Actual Message is : " + actualInvalidPrevLocError);
				Extent_pass_New(driver,"Matched || " + " Expected Message is : " + invalidPrevLocError + " || Actual Message is : " + actualInvalidPrevLocError,test,test1);
				click(driver, okButtonErrorFrame_L);	
			}else {
				System.out.println("Not matched || " + " Expected Message is : " + invalidPrevLocError + " || Actual Message  is : " + actualInvalidPrevLocError);
				Extent_fail(driver,"Not matched || " + " Expected Message is : " + invalidPrevLocError + " || Actual Message is : " + actualInvalidPrevLocError,test,test1);
			}			
			Step_End(3, "Ensure that system should validate as 'INVALID PREV LOCATIONAL ACTIVITY PLACE OR DEPOT\r\n"
					+ " ' due to location not matched bases on movement sequence setup", test, test1);
			Extent_completed(testcase_Name, test, test1);

	}
}
