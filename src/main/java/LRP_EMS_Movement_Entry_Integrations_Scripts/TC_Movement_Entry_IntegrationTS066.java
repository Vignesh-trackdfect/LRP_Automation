package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_IntegrationTS066 extends Keywords {

	public void sizeTypeMandatory(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Movement_Entry_IntegrationTS066";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String activityONHI66 = Excel_data.get("ActivityONHI");
		String sizeTypeMustPopup = Excel_data.get("SizeTypeMustPopup");
		String activityDateSingle66 = Excel_data.get("ActivityDate");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		String datePicker = Excel_data.get("DatePicker");
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		//// To validate size/type mandatory
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
		
		
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
		
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		// Multiple Equipment Entry

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);

		waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, activityONHI66);
			waitForDisplay(driver, autoCompleteValue_ME);
			enter(driver);

			if (!activityDateSingle66.equals("")) {
				waitForElement(driver, activeDateField_L);
				if(datePicker.equalsIgnoreCase("Yes")) {
						selectDatePicker(driver, activeDateField_L, activityDateSingle66);
						
				}else {
					if(activityDateSingle66.contains("-")) {
						String activityDateSingle66_1=activityDateSingle66.replace("-", "/");
						clearAndType(driver, activeDateField_L, activityDateSingle66_1);
						
					}else {
					clearAndType(driver, activeDateField_L, activityDateSingle66);
					
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
			
			Step_Start(2, "Ensure that system should validate if user try to save ONHI move by giving size/type field as blank", test, test1);
			
			Extent_call(test, test1, "Leaving the size/type as blank");	

			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, Excel_data, test, test1);

		Step_End(2, "Ensure that system should validate if user try to save ONHI move by giving size/type field as blank", test, test1);
		Step_Start(3, "Ensure that system should validate as 'Size/Type must be selected'.", test, test1);

		waitForElement(driver, addButtonMulti_L);
		click(driver, addButtonMulti_L);
		waitForPopup(driver, Popup_Message, sizeTypeMustPopup);

			String actualSizeTypeMustPopup = getText(driver, Popup_Message);

			if (actualSizeTypeMustPopup.equals(sizeTypeMustPopup)) {
				System.out.println("Matched || "+sizeTypeMustPopup + " popup is displayed ||" + " Expected Message is : " + sizeTypeMustPopup
						+ " || Actual Message is : "+sizeTypeMustPopup + " popup is displayed ||" + actualSizeTypeMustPopup);
				Extent_pass_New(driver, "Matched || " + " Expected Message is : " + sizeTypeMustPopup
						+ " || Actual Message is : " + actualSizeTypeMustPopup, test, test1);
			} else {
				System.out.println("Not matched || " +sizeTypeMustPopup + " popup is not displayed ||"+ " Expected Message is : " + sizeTypeMustPopup
						+ " || Actual Message  is : "+sizeTypeMustPopup + " popup is not displayed ||" + actualSizeTypeMustPopup);
				Extent_fail(driver, "Not matched || " + " Expected Message is : " + sizeTypeMustPopup
						+ " || Actual Message is : " + actualSizeTypeMustPopup, test, test1);
			}

		Step_End(3, "Ensure that system should validate as 'Size/Type must be selected'.", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}
