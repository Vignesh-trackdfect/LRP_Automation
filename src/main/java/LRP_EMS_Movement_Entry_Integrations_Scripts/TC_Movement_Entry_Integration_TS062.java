package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS062 extends Keywords {

	public void Movement_Entry_Integration_TS062(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name = "TC_Movement_Entry_Integration_TS062";
		
		
		

		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String activitySUBL = Excel_data.get("ActivitySUBL");
		String releaseReferenceEnteredPopup = Excel_data.get("ReleaseReferenceEnteredPopup");
		String activityDateSingle62 = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String datePicker = Excel_data.get("DatePicker");

		// Login
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		
		LRP_Login(driver, username, password);

		//// To validate if user try to save SUBL without ref no
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

		//Module Search
		moduleNavigate(driver, moduleName);
				
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		// Movement Entry
		
		// Multiple Equipment Entry

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);

		waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, activitySUBL);
			enter(driver);
			waitForElement(driver, activeDateField_L);
			click(driver, activeDateField_L);
			if (!activityDateSingle62.equals("")) {
				waitForElement(driver, activeDateField_L);
				if (datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateField_L, activityDateSingle62);
					
				} else {
					if (activityDateSingle62.contains("-")) {
						String activityDateSingle62_1 = activityDateSingle62.replace("-", "/");
						clearAndType(driver, activeDateField_L, activityDateSingle62_1);

					} else {
						clearAndType(driver, activeDateField_L, activityDateSingle62);

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

		
		Step_Start(2,
				"Ensure that system should validate if user try to save SUBL move by giving blank in release ref field",
				test, test1);
		
		Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
		allElements.movementEntryAllElements(driver, Excel_data, test, test1);
		
		Step_End(2,
				"Ensure that system should validate if user try to save SUBL move by giving blank in release ref field",
				test, test1);
		waitForElement(driver, addButtonMulti_L);
		click(driver, addButtonMulti_L);
		Step_Start(3, " Ensure that system should validate as ' Release Reference must be entered'.", test, test1);
		waitForPopup(driver, Popup_Message, releaseReferenceEnteredPopup);

			String actualReleaseRefPopup = getText(driver, Popup_Message);

			if (actualReleaseRefPopup.equals(releaseReferenceEnteredPopup)) {
				System.out.println("Matched || " + " Expected Popup is : " + releaseReferenceEnteredPopup
						+ " || Actual Popup is : " + actualReleaseRefPopup);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + releaseReferenceEnteredPopup
						+ " || Actual Popup is : " + actualReleaseRefPopup, test, test1);
				Extent_pass_New(driver, releaseReferenceEnteredPopup + " popup is displayed", test, test1);
				System.out.println(releaseReferenceEnteredPopup + " popup is displayed");

			} else {
				System.out.println("Not matched || " + " Expected Popup is : " + releaseReferenceEnteredPopup
						+ " || Actual Popup  is : " + actualReleaseRefPopup);
				Extent_fail(driver, "Not matched || " + " Expected Popup is : " + releaseReferenceEnteredPopup
						+ " || Actual Popup is : " + actualReleaseRefPopup, test, test1);
			}

		Step_End(3, " Ensure that system should validate as ' Release Reference must be entered'.", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
