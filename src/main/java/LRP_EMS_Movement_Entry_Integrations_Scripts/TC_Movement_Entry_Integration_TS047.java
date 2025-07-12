package LRP_EMS_Movement_Entry_Integrations_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS047 extends Keywords {

	public void Movement_Entry_Integration_TS047(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Movement_Entry_Integration_TS047";
		
		
		

		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String eqpNumLODF47 = Excel_data.get("EqpNumLODF");
		String lodfActivity47 = Excel_data.get("LodfActivity");
		String containerNotAvailableError = Excel_data.get("ContainerNotAvailableError");
		String activityDateSingle47 = Excel_data.get("activityDateSingle47");
		String datePicker = Excel_data.get("datePicker");
		String activityTime_Input1 = Excel_data.get("activityTime_Input1");
		

				navigateUrl(driver, url);

				Extent_Start(testcase_Name, test, test1);

		// Login

		LRP_Login(driver, username, password);

		// To validate if user try to save LODF move without container back update

				//Module Search
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
				moduleNavigate(driver, moduleName);

				Step_End(1, "Enter module name in searchbox & click the module", test, test1);
				Step_Start(2, "Ensure that system should validate if user enter all mandatory field correctly without saving previous SNTS move", test, test1);

		// Movement Entry

		// Single Entry Equipment
			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, eqpNumLODF47);
			
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, lodfActivity47);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
		
			if (!activityDateSingle47.equals("")) {
				waitForElement(driver, activeDateInSingle_L);
				
				
				if(datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle47);

						
						
				}else {
					click(driver, activeDateInSingle_L);

					if(activityDateSingle47.contains("-")) {
						String activityDateSingle_47=activityDateSingle47.replace("-", "/");
						clear(driver,activeDateInSingle_L);
						sendKeys(driver, activeDateInSingle_L, activityDateSingle_47);
						
					}else {
					clearAndType(driver, activeDateInSingle_L, activityDateSingle47);
					
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
		
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, Excel_data, test, test1);
			
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(2, "Ensure that system should validate if user enter all mandatory field correctly without saving previous SNTS move", test, test1);
		Step_Start(3, " Ensure that system should validate as 'Container not available in booking'.", test, test1);

		waitForElement(driver, errorRecordsFrame_L);

			String actualContainerNotAvailError = getText(driver, container_Not_Available_Error);

			if (actualContainerNotAvailError.equals(containerNotAvailableError)) {
				System.out.println("Matched || " + " Expected Message is : " + containerNotAvailableError
						+ " || Actual Message is : " + actualContainerNotAvailError);
				Extent_pass_New(driver, "Matched || " + " Expected Message is : " + containerNotAvailableError
						+ " || Actual Message is : " + actualContainerNotAvailError, test, test1);
			} else {
				System.out.println("Not matched || " + " Expected Message is : " + containerNotAvailableError
						+ " || Actual Message  is : " + actualContainerNotAvailError);
				Extent_fail(driver, "Not matched || " + " Expected Message is : " + containerNotAvailableError
						+ " || Actual Message is : " + actualContainerNotAvailError, test, test1);
			}

			click(driver, okButtonErrorFrame_L);
			
			Step_End(3, " Ensure that system should validate as 'Container not available in booking'.", test, test1);

			Extent_completed(testcase_Name, test, test1);
		
	}
}
