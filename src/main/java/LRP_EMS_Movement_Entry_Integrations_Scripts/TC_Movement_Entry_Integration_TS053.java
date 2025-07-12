package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;


import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS053 extends Keywords {

	public void Movement_Entry_Integration_TS053(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name = "TC_Movement_Entry_Integration_TS053";
		
		
		

		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String Activity_Move_Txt5 = Excel_data.get("Activity_Move");
		String Equip_Number_Txt5 = Excel_data.get("Equip_Number");
		String Invalid_Terminal_Exp = Excel_data.get("Invalid_Terminal");
		String DatePicker = Excel_data.get("DatePicker");
		String activityDate = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		// Login

		LRP_Login(driver, username, password);

		//// To validate if user given incorrect terminal for DCHF

				//Module Search
				moduleNavigate(driver, moduleName);

		Step_Start(1,
				" try save DCHF move with all valid details & given incorrect terminal which is not matched in booking terminal ",
				test, test1);
		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);

		waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, Activity_Move_Txt5);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);

			if (!activityDate.equals("")) {
				waitForElement(driver, activeDateField_L);
				click(driver, activeDateField_L);

				if (DatePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateField_L, activityDate);

				} else {
					if (DatePicker.contains("-")) {
						String activityDate_1 = activityDate.replace("-", "/");
						clearAndType(driver, activeDateField_L, activityDate_1);

					} else {
						clearAndType(driver, activeDateField_L, activityDate);

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
			waitForElement(driver, eqpNum_Inputfield);
			sendKeys(driver, eqpNum_Inputfield, Equip_Number_Txt5);

			waitForElement(driver, eqpNum_Inputfield);
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(1,
					" try save DCHF move with all valid details & given incorrect terminal which is not matched in booking terminal ",
					test, test1);
			Step_Start(2, "Ensure that system should validate as 'INVALID TERMINAL'.", test, test1);
			waitForPopup(driver, P_Invalid_Terminal_Popup, Invalid_Terminal_Exp);
			String Terminal_Popup = getText(driver, P_Invalid_Terminal_Popup);
			if (Invalid_Terminal_Exp.equals(Terminal_Popup)) {
				System.out.println("Matched || " + " Expected Message is : " + Invalid_Terminal_Exp
						+ " || Actual Message is : " + Terminal_Popup);
				Extent_pass_New(driver, "Matched || " + " Expected Message is : " + Invalid_Terminal_Exp
						+ " || Actual Message is : " + Terminal_Popup, test, test1);
				click(driver, P_Ok_Btn);
			} else {
				System.out.println("Not Matched || " + " Expected Message is : " + Invalid_Terminal_Exp
						+ " || Actual Message is : " + Terminal_Popup);
				Extent_fail(driver, "Not Matched || " + " Expected Message is : " + Invalid_Terminal_Exp
						+ " || Actual Message is : " + Terminal_Popup, test, test1);
				
			}
			Step_End(2, "Ensure that system should validate as 'INVALID TERMINAL'.", test, test1);
			Extent_completed(testcase_Name, test, test1);

	}
}
