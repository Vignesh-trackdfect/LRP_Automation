package LRP_EMS_Movement_Entry_Integrations_Scripts;


import java.util.Map;


import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS055 extends Keywords {

	public void Movement_Entry_Integration_TS055(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Movement_Entry_Integration_TS055";
		
		

		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String lodfActivity55 = Excel_data.get("LodfActivity");
		String service_Popup_Txt = Excel_data.get("service_Popup_Txt");
		String activityDateSingle55 = Excel_data.get("activityDateSingle55");
		String activityTime_Input1 = Excel_data.get("activityTime_Input1");
		String datePicker = Excel_data.get("datePicker");
		
		navigateUrl(driver, url);

		// Login
		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, password);

		// To validate if user given blank service for LODF or DCHF
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

				//Module Search
				moduleNavigate(driver, moduleName);
				
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		// Multiple Equipment Entry

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);

		waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, lodfActivity55);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			if (!activityDateSingle55.equals("")) {
				waitForElement(driver, MultiActivity_Date);
				
				
				if(datePicker.equalsIgnoreCase("Yes")) {
					Extent_call(test, test1, "Entering the date,month & year");
					selectDatePicker(driver, MultiActivity_Date, activityDateSingle55);
						
				}else {
					click(driver, MultiActivity_Date);

					if(activityDateSingle55.contains("-")) {
						String activityDateSingle50_1=activityDateSingle55.replace("-", "/");
						clear(driver,MultiActivity_Date);
					
						sendKeys(driver, MultiActivity_Date, activityDateSingle50_1);
						
					}else {
					clearAndType(driver, MultiActivity_Date, activityDateSingle55);
					
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

			
Step_Start(2, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for service field since it is mandatory field", test, test1);
			
		Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
		allElements.movementEntryAllElements(driver, Excel_data, test, test1);

		waitForElement(driver, service_Textfield_ME);
		click(driver, service_Textfield_ME);
		waitForDisplay(driver, service_Textfield_ME);
		clear(driver, service_Textfield_ME);

		waitForDisplay(driver, location_Textfield_ME);
		scrollElementToCenter(driver, location_Textfield_ME);
		click(driver, location_Textfield_ME);
		

			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);
			
			Step_End(2, "Ensure that system should validate if user try save LODF or DCHF move with all valid details & given blank for service field since it is mandatory field", test, test1);
		Step_Start(3, "Ensure that system should validate as 'Service must be entered'.", test, test1);
			
		waitForPopup(driver, Popup_Message, service_Popup_Txt);
			String service_Popup = getText(driver, Popup_Message);
			if (service_Popup_Txt.equals(service_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + service_Popup_Txt
						+ " || Actual Popup is : " + service_Popup);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + service_Popup_Txt
						+ " || Actual Popup is : " + service_Popup, test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + service_Popup_Txt
						+ " || Actual Popup is : " + service_Popup);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + service_Popup_Txt
						+ " || Actual Popup is : " + service_Popup, test, test1);
				
			}
			Step_End(3, "Ensure that system should validate as 'Service must be entered'.", test, test1);
		
		Extent_completed(testcase_Name, test, test1);

	}
}
