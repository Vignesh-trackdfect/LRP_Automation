package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS052 extends Keywords {

	public void Movement_Entry_Integration_TS052(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Movement_Entry_Integration_TS052";
		
		
		

		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String Activity_Move_Txt4 = Excel_data.get("Activity_Move");
		String Equip_Number_Txt4 = Excel_data.get("Equip_Number");
		String Invalid_Bound_Exp = Excel_data.get("Invalid_Bound");
		String activityDateSingle52 = Excel_data.get("activityDateSingle52");
		String activityTime_Input1 = Excel_data.get("activityTime_Input1");
		String datePicker = Excel_data.get("datePicker");
		
		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);
		// Login
	
		LRP_Login(driver, username, password);

		// To validate if user try to save invalid bound in LODF
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

				//Module Search
				moduleNavigate(driver, moduleName);
				
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);
			waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, Activity_Move_Txt4);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			if (!activityDateSingle52.equals("")) {
				waitForElement(driver, MultiActivity_Date);
				
				if(datePicker.equalsIgnoreCase("Yes")) {
					Extent_call(test, test1, "Entering the date,month & year");
					selectDatePicker(driver, MultiActivity_Date, activityDateSingle52);

				}else {
					click(driver, MultiActivity_Date);

					if(activityDateSingle52.contains("-")) {
						String activityDateSingle50_1=activityDateSingle52.replace("-", "/");
						clear(driver,MultiActivity_Date);
						sendKeys(driver, MultiActivity_Date, activityDateSingle50_1);
						
					}else {
					clearAndType(driver, MultiActivity_Date, activityDateSingle52);
					
					}		
				}
			}
			
			if (!activityTime_Input1.equals("")) {
				
				click(driver, activityTimeMultiple);

				
				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);
					
					Extent_call(test, test1, "Entering the time");
						clearAndType(driver, activityTime_Input, activityTime_Input1);
						System.out.println("activity_Time" + activityTime_Input1);
					
				}
				
				click(driver, activityTime_Close);
			} 
			waitForElement(driver, showInputButton);
			click(driver, showInputButton);

		
Step_Start(2, " Ensure that system should validate if user try save LODF move with all valid details & given invalid bound ", test, test1);

		Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
		allElements.movementEntryAllElements(driver, Excel_data, test, test1);

		waitForElement(driver, addButtonMulti_L);
		click(driver, addButtonMulti_L);
		
		waitForElement(driver, selectGridCell_1_L);
		click(driver, selectGridCell_1_L);
		
		waitForElement(driver, eqpNum_Inputfield);
		sendKeys(driver, eqpNum_Inputfield, Equip_Number_Txt4);
		
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
Step_End(2, " Ensure that system should validate if user try save LODF move with all valid details & given invalid bound ", test, test1);
		
Step_Start(3, " Ensure that system should validate as 'Invalid bound'.", test, test1);
			waitForPopup(driver, P_Invalid_Bound_Popup, Invalid_Bound_Exp);
			String Bound_Popup = getText(driver, P_Invalid_Bound_Popup);
			if (Invalid_Bound_Exp.equals(Bound_Popup)) {
				System.out.println("Matched || " + " Expected Message is : " + Invalid_Bound_Exp
						+ " || Actual Message is : " + Bound_Popup);
				Extent_pass_New(driver, "Matched || " + " Expected Message is : " + Invalid_Bound_Exp
						+ " || Actual Message is : " + Bound_Popup, test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Message is : " + Invalid_Bound_Exp
						+ " || Actual Message is : " + Bound_Popup);
				Extent_fail(driver, "Not Matched || " + " Expected Message is : " + Invalid_Bound_Exp
						+ " || Actual Message is : " + Bound_Popup, test, test1);
				
			}
Step_End(3, " Ensure that system should validate as 'Invalid bound'.", test, test1);
			click(driver, P_Ok_Btn);
		
		Extent_completed(testcase_Name, test, test1);

	}
}
