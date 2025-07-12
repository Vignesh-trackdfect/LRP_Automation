package LRP_EMS_Movement_Entry_Integrations_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_IntegrationTS041 extends Keywords {
	//// To validate if user try to save move by given blank in Booking field for SNTS move

	public void blankInBookingField(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Movement_Entry_IntegrationTS041";

		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String bookingNumberMustPopup = Excel_data.get("BookingNumberMustPopup");
		String activitySNTS = Excel_data.get("ActivitySNTS");
		String activityDate = Excel_data.get("ActivityDate");
		String datePicker = Excel_data.get("DatePicker");
		String activityTime_Input1 = Excel_data.get("ActivityTime");
		
		
		navigateUrl(driver, url);


		Extent_Start(testCaseName, test, test1);
		
		// Login

		LRP_Login(driver, username, password);
		
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

		// Multiple Equipment Entry
Step_Start(1, "Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields", test, test1);

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);
		
			waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, activitySNTS);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			if(!activityDate.equals("")) {
			waitForElement(driver, activeDateField_L);
			
			if(datePicker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, activeDateField_L, activityDate);
	
			}else {
				click(driver, activeDateField_L);

				if(activityDate.contains("-")) {
					String activityDate_1=activityDate.replace("-", "/");
					clearAndType(driver, activeDateField_L, activityDate_1);
					
				}else {
				clearAndType(driver, activeDateField_L, activityDate);
				
				}		
			}
			}
		

			if (!activityTime_Input1.equals("")) {
				
				click(driver, activityTimeMultiple);

				
				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);
					
						clearAndType(driver, activityTime_Input, activityTime_Input1);
						System.out.println("activity_Time" + activityTime_Input1);
					
				}
				
				click(driver, activityTime_Close);
			}

			waitForElement(driver, showInputButton);
			click(driver, showInputButton);

			Step_End(1, "Ensure system should allow user to show input details in grid if valid container no is given & clicked show input fields", test, test1);
			Step_Start(2, "Ensure that system should allow to enter valid location & terminal for SNTS move", test, test1);
			
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, Excel_data, test, test1);
			

			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);
		
			Step_End(2, "Ensure that system should allow to enter valid location & terminal for SNTS move", test, test1);
			Step_Start(3, "Ensure that system should validate if user try to save SNTS move by giving blank in booking no field", test, test1);
			Step_Start(4, " Ensure that system should validate as 'Booking Number must be entered'", test, test1);

		waitForPopup(driver, Popup_Message, bookingNumberMustPopup);

			String actualBookingMustPopup = getText(driver, Popup_Message);

			if (actualBookingMustPopup.equals(bookingNumberMustPopup)) {
				System.out.println("Matched || " +bookingNumberMustPopup + " popup is displayed ||"+ " Expected Popup is : " + bookingNumberMustPopup
						+ " || Actual Popup is : " + actualBookingMustPopup);
				Extent_pass_New(driver, "Matched || " +bookingNumberMustPopup + " popup is displayed ||"+ " Expected Popup is : " + bookingNumberMustPopup
						+ " || Actual Popup is : " + actualBookingMustPopup, test, test1);
			} else {
				System.out.println("Not matched || "+bookingNumberMustPopup + " popup is not displayed ||" + " Expected Popup is : " + bookingNumberMustPopup
						+ " || Actual Popup  is : " + actualBookingMustPopup);
				Extent_fail(driver, "Not matched || "+bookingNumberMustPopup + " popup is not displayed ||" + " Expected Popup is : " + bookingNumberMustPopup
						+ " || Actual Popup is : " + actualBookingMustPopup, test, test1);
			}
			Step_End(3, "Ensure that system should validate if user try to save SNTS move by giving blank in booking no field", test, test1);

		Step_End(4, " Ensure that system should validate as 'Booking Number must be entered'", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}
