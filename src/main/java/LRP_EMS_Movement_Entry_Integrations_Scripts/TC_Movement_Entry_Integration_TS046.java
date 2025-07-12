package LRP_EMS_Movement_Entry_Integrations_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS046 extends Keywords {

	public void Movement_Entry_Integration_TS046(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Movement_Entry_Integration_TS046";
		
		

		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String eqpNumLODF46 = Excel_data.get("EqpNumLODF");
		String lodfActivity46 = Excel_data.get("LodfActivity");
		String invalidPortError = Excel_data.get("InvalidPortError");
		String activityDateSingle46 = Excel_data.get("activityDateSingle46");
		String activityTime_Input1 = Excel_data.get("activityTime_Input1");
		String datePicker = Excel_data.get("datePicker");
		

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		// Login

		LRP_Login(driver, username, password);

		// To validate if user given incorrect POD for LODF move
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

				//Module Search
		moduleNavigate(driver, moduleName);
				
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		// Movement Entry

		// Single Entry Equipment
			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, eqpNumLODF46);
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, lodfActivity46);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			
			Extent_call(test, test1, "Entering the Date & Time period");
			if (!activityDateSingle46.equals("")) {
				waitForElement(driver, activeDateInSingle_L);
				
				
				if(datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle46);

						
				}else {
					click(driver, activeDateInSingle_L);

					if(activityDateSingle46.contains("-")) {
						String activityDateSingle46_1=activityDateSingle46.replace("-", "/");
						clear(driver,activeDateInSingle_L);
						sendKeys(driver, activeDateInSingle_L, activityDateSingle46_1);
						
					}else {
					clearAndType(driver, activeDateInSingle_L, activityDateSingle46);
					
					}		
				}
			}
			
			if (!activityTime_Input1.equals("")) {
				waitForElement(driver, activityTime);
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
		

      Step_Start(2, "Ensure that system should validate if the given POD is not connected for the load port & click save after providing all mandatory fields", test, test1);

		Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
		allElements.movementEntryAllElements(driver, Excel_data, test, test1);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(2, "Ensure that system should validate if the given POD is not connected for the load port & click save after providing all mandatory fields", test, test1);
		
      Step_Start(3, "Ensure that system should validate as 'INVALID PORT. VESSEL NOT CALLING'.", test, test1);
		waitForPopup(driver, invalid_Port_Error, invalidPortError);

			String actualInvalidPortError = getText(driver, invalid_Port_Error);

			if (actualInvalidPortError.equals(invalidPortError)) {
				System.out.println("Matched || " + " Expected Message is : " + invalidPortError + " || Actual Message is : "
						+ actualInvalidPortError);
				Extent_pass_New(driver, "Matched || " + " Expected Message is : " + invalidPortError + " || Actual Message is : "
						+ actualInvalidPortError, test, test1);
			} else {
				System.out.println("Not matched || " + " Expected Message is : " + invalidPortError
						+ " || Actual Message  is : " + actualInvalidPortError);
				Extent_fail(driver, "Not matched || " + " Expected Message is : " + invalidPortError
						+ " || Actual Message is : " + actualInvalidPortError, test, test1);
			}
			Step_End(3, "Ensure that system should validate as 'INVALID PORT. VESSEL NOT CALLING'.", test, test1);
		
			click(driver, okButtonErrorFrame_L);
			Extent_completed(testcase_Name, test, test1);

		

	}
}
