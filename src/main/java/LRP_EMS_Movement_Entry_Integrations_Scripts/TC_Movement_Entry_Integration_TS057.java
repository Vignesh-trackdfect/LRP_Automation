package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;


import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS057 extends Keywords {

	public void Movement_Entry_Integration_TS057(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {


		String testcase_Name = "TC_Movement_Entry_Integration_TS057";
		
		
		

		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String lodfActivity57 = Excel_data.get("LodfActivity");
		String Voyage_Popup_Txt = Excel_data.get("Voyage_Popup_Txt");
		String datePicker = Excel_data.get("datePicker");
		String activityDateSingle57 = Excel_data.get("activityDateSingle57");
		String activityTime_Input1 = Excel_data.get("activityTime_Input1");
		
		// Login
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		
		LRP_Login(driver, username, password);
		// To validate if user given blank voyage for LODF or DCHF
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

				//Module Search
				moduleNavigate(driver, moduleName);

		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		// Multiple Equipment Entry

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);

		waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, lodfActivity57);
			waitForDisplay(driver, autoCompleteValue_ME);
			enter(driver);
			
			if (!activityDateSingle57.equals("")) {
				waitForElement(driver, MultiActivity_Date);
				
				
				if(datePicker.equalsIgnoreCase("Yes")) {
					Extent_call(test, test1, "Entering the date,month & year");
					selectDatePicker(driver, MultiActivity_Date, activityDateSingle57);
						
				}else {
					click(driver, MultiActivity_Date);

					if(activityDateSingle57.contains("-")) {
						String activityDateSingle50_1=activityDateSingle57.replace("-", "/");
						clear(driver,MultiActivity_Date);
					
						sendKeys(driver, MultiActivity_Date, activityDateSingle50_1);
						
					}else {
					clearAndType(driver, MultiActivity_Date, activityDateSingle57);
					
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

Step_Start(2, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for voyage field since it is mandatory field", test, test1);
			
		Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
		allElements.movementEntryAllElements(driver, Excel_data, test, test1);

		waitForElement(driver, voyage_Textfield_ME);
		click(driver, voyage_Textfield_ME);
		waitForDisplay(driver, voyage_Textfield_ME);
		clear(driver, voyage_Textfield_ME);

		waitForElement(driver, location_Textfield_ME);
		click(driver, location_Textfield_ME);
		
		Step_End(2, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for voyage field since it is mandatory field", test, test1);
		Step_Start(3, "Ensure that system should validate as 'Voyage must be entered'.", test, test1);
			
			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);
			
			waitForPopup(driver, Popup_Message, Voyage_Popup_Txt);
			String voyage_Popup = getText(driver, Popup_Message);
			if (Voyage_Popup_Txt.equals(voyage_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Voyage_Popup_Txt
						+ " || Actual Popup is : " + voyage_Popup);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Voyage_Popup_Txt
						+ " || Actual Popup is : " + voyage_Popup, test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Voyage_Popup_Txt
						+ " || Actual Popup is : " + voyage_Popup);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Voyage_Popup_Txt
						+ " || Actual Popup is : " + voyage_Popup, test, test1);
			
			}
			
			Step_End(3, "Ensure that system should validate as 'Voyage must be entered'.", test, test1);

			Extent_completed(testcase_Name, test, test1);
	}
}
