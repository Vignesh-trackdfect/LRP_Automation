package LRP_EMS_Movement_Entry_Integrations_Scripts;


import java.util.Map;


import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS049 extends Keywords {

	public void Movement_Entry_Integration_TS049(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Movement_Entry_Integration_TS049";
		
		
		

		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String Activity_Move_Txt1 = Excel_data.get("Activity_Move");
		String Equip_Number_Txt1 = Excel_data.get("Equip_Number");
		String Invalid_Activity_Date_Exp = Excel_data.get("Invalid_Activity_Date");
		String activityDateSingle49 = Excel_data.get("activityDateSingle49");
		String datePicker = Excel_data.get("datePicker");
		String activityTime_Input1 = Excel_data.get("activityTime_Input1");
				
				navigateUrl(driver, url);

				Extent_Start(testcase_Name, test, test1);
		// Login

		LRP_Login(driver, username, password);

		// To validate if user try to LODF move with incorrect date

				
				//Module Search
				moduleNavigate(driver, moduleName);

		// Single Entry Equipment
					waitForElement(driver, equipmentNoSearchField_L);
					sendKeys(driver, equipmentNoSearchField_L, Equip_Number_Txt1);
					waitForElement(driver, activitySearchFieldInSingle_L);
					sendKeys(driver, activitySearchFieldInSingle_L, Activity_Move_Txt1);
					waitForElement(driver, autoCompleteValue_ME);
					enter(driver);
					
					if (!activityDateSingle49.equals("")) {
						waitForElement(driver, activeDateInSingle_L);
						
						if(datePicker.equalsIgnoreCase("Yes")) {
							selectDatePicker(driver, activeDateInSingle_L, activityDateSingle49);

								
						}else {
							click(driver, activeDateInSingle_L);

							if(activityDateSingle49.contains("-")) {
								String activityDateSingle_47=activityDateSingle49.replace("-", "/");
								clear(driver,activeDateInSingle_L);
								sendKeys(driver, activeDateInSingle_L, activityDateSingle_47);
								
							}else {
							clearAndType(driver, activeDateInSingle_L, activityDateSingle49);
							
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
			
			Step_Start(2, " Ensure that system should validate as 'Activity Date Should be within Arrival and Departure Date'.", test, test1);

			waitForPopup(driver, P_Invalid_Activity_Date_Popup, Invalid_Activity_Date_Exp);
			String Date_Popup = getText(driver, P_Invalid_Activity_Date_Popup);
			if (Invalid_Activity_Date_Exp.equals(Date_Popup)) {
				System.out.println("Matched || " + " Expected Message is : " + Invalid_Activity_Date_Exp
						+ " || Actual Message is : " + Date_Popup);
				Extent_pass_New(driver, "Matched || " + " Expected Message is : " + Invalid_Activity_Date_Exp
						+ " || Actual Message is : " + Date_Popup, test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Message is : " + Invalid_Activity_Date_Exp
						+ " || Actual Message is : " + Date_Popup);
				Extent_fail(driver, "Not Matched || " + " Expected Message is : " + Invalid_Activity_Date_Exp
						+ " || Actual Message is : " + Date_Popup, test, test1);
			
			}
		
		click(driver, P_Ok_Btn);
		Step_End(2, " Ensure that system should validate as 'Activity Date Should be within Arrival and Departure Date'.", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
