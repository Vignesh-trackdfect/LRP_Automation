package LRP_EMS_Movement_Entry_Integrations_Scripts;


import java.util.Map;


import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS058 extends Keywords {

	public void Movement_Entry_Integration_TS058(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Movement_Entry_Integration_TS058";
		
		
		



		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String lodfActivity58 = Excel_data.get("LodfActivity");
		String Bound_Popup_Txt = Excel_data.get("Bound_Popup_Txt");
		String activityDateSingle58 = Excel_data.get("activityDateSingle58");
		String activityTime_Input1 = Excel_data.get("activityTime_Input1");
		String datePicker = Excel_data.get("datePicker");

		Extent_Start(testcase_Name, test, test1);
		// Login
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);
		// To validate if user given blank bound for LODF or DCHF
		//Module Search
		moduleNavigate(driver, moduleName);

		// Multiple Equipment Entry

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);

		waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, lodfActivity58);
			waitForDisplay(driver, autoCompleteValue_ME);
			enter(driver);

			if (!activityDateSingle58.equals("")) {
				waitForElement(driver, MultiActivity_Date);
				if(datePicker.equalsIgnoreCase("Yes")) {
					Extent_call(test, test1, "Entering the date,month & year");
						selectDatePicker(driver, MultiActivity_Date, activityDateSingle58);

					}else {
						if(activityDateSingle58.contains("-")) {
							String activityDateSingle50_1=activityDateSingle58.replace("-", "/");
							clear(driver,activeDateInSingle_L);
							sendKeys(driver, activeDateInSingle_L, activityDateSingle50_1);

						}else {
							clearAndType(driver, activeDateInSingle_L, activityDateSingle58);

						}		
					}
			}

			if (!activityTime_Input1.equals("")) {

				click(driver, activityTimeMultiple);


				if (isdisplayed(driver, Calender)) {
					click(driver, activityTime_Input);

					Extent_call(test, test1, "Entering the time");
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

			Step_Start(1, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for bound field since it is mandatory field", test, test1);
			
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, Excel_data, test, test1);
			
			waitForElement(driver, Bound_ME);
			click(driver, Bound_ME);
			waitForDisplay(driver, Bound_ME);
			clear(driver, Bound_ME);

			waitForElement(driver, location_Textfield_ME);
			click(driver, location_Textfield_ME);
			
			Step_End(1, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for bound field since it is mandatory field", test, test1);

			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);

			Step_Start(2, "Ensure that system should validate as 'Bound must be entered'.", test, test1);

			waitForPopup(driver, Popup_Message, Bound_Popup_Txt);
			String bound_Popup = getText(driver, Popup_Message);
			if (Bound_Popup_Txt.equals(bound_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Bound_Popup_Txt
						+ " || Actual Popup is : " + bound_Popup);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Bound_Popup_Txt
						+ " || Actual Popup is : " + bound_Popup, test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Bound_Popup_Txt
						+ " || Actual Popup is : " + bound_Popup);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Bound_Popup_Txt
						+ " || Actual Popup is : " + bound_Popup, test, test1);

			}
			Step_End(2, "Ensure that system should validate as 'Bound must be entered'.", test, test1);
			Extent_completed(testcase_Name, test, test1);
		
	}
}
