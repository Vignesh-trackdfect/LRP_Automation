package LRP_EMS_Movement_Entry_Integrations_Scripts;


import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS050 extends Keywords {

	public void Movement_Entry_Integration_TS050(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Movement_Entry_Integration_TS050";
		
		

		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String Activity_Move_Txt2 = Excel_data.get("Activity_Move");
		String Equip_Number_Txt2 = Excel_data.get("Equip_Number");
		String Invalid_Service_Exp = Excel_data.get("Invalid_Service");
		String activityDateSingle50 = Excel_data.get("activityDateSingle50");
		String activityTime_Input1 = Excel_data.get("activityTime_Input1");
		String datePicker = Excel_data.get("datePicker");
		String Invalid_Service_Input = Excel_data.get("Invalid_Service_Input");
		String Invalid_Vessel_Input = Excel_data.get("Invalid_Vessel_Input");
		String Invalid_Voyage_Input = Excel_data.get("Invalid_Voyage_Input");
		
						
		navigateUrl(driver, url);

		// Login
		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, username, password);

		// To validate if user try to save invalid service in LODF
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
		
				//Module Search
				moduleNavigate(driver, moduleName);
				
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);
		
			waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, Activity_Move_Txt2);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);

			
			if (!activityDateSingle50.equals("")) {
				waitForElement(driver, MultiActivity_Date);

				if(datePicker.equalsIgnoreCase("Yes")) {
					Extent_call(test, test1, "Entering the date,month & year");
					selectDatePicker(driver, MultiActivity_Date, activityDateSingle50);
						
				}else {
					click(driver, MultiActivity_Date);

					if(activityDateSingle50.contains("-")) {
						String activityDateSingle50_1=activityDateSingle50.replace("-", "/");
						clear(driver,MultiActivity_Date);
						sendKeys(driver, MultiActivity_Date, activityDateSingle50_1);
						
					}else {
					clearAndType(driver, MultiActivity_Date, activityDateSingle50);
					
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

			waitForDisplay(driver, showInputFieldFrame_L);
			if (isdisplayed(driver, showInputFieldFrame_L)) {
				System.out.println("Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed");
				Extent_pass_New(driver, "Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is displayed", test, test1);
			} else {
				System.out.println("Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed");
				Extent_fail(driver, "Not Matched || Expected : Show input field frame should be displayed || Actual : Show input field frame is not displayed", test, test1);
			}
			
Step_Start(2, " Ensure that system should validate if user try save LODF move with all valid details & given invalid service", test, test1);
			
		Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
		allElements.movementEntryAllElements(driver, Excel_data, test, test1);

		scrollElementToCenter(driver, service_Textfield_ME);
		waitForElement(driver, service_Textfield_ME);
		clearAndType(driver, service_Textfield_ME, Invalid_Service_Input);
		enter(driver);
		
		scrollElementToCenter(driver, vessel_Textfield_ME);
		waitForElement(driver, vessel_Textfield_ME);
		clearAndType(driver, vessel_Textfield_ME, Invalid_Vessel_Input);
		enter(driver);
		
		scrollElementToCenter(driver, voyage_Textfield_ME);
		waitForElement(driver, voyage_Textfield_ME);
		clearAndType(driver, voyage_Textfield_ME, Invalid_Voyage_Input);
		enter(driver);
		
Step_End(2, " Ensure that system should validate if user try save LODF move with all valid details & given invalid service", test, test1);

			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);
			

			waitForElement(driver, selectGridCell_1_L);
			click(driver, selectGridCell_1_L);
			
			sendKeys(driver, eqpNum_Inputfield, Equip_Number_Txt2);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			
			waitForDisplay(driver, forcebtn);
			if(isdisplayed(driver, forcebtn)) {
				click(driver, forcebtn);
			}
			

			Step_Start(3, "Ensure that system should validate as 'Invalid Service'.", test, test1);
			waitForPopup(driver, P_Invalid_Service_Popup, Invalid_Service_Exp);
			String service_Popup = getText(driver, P_Invalid_Service_Popup);
			if (Invalid_Service_Exp.equals(service_Popup)) {
				System.out.println("Matched || " + " Expected Message is : " + Invalid_Service_Exp
						+ " || Actual Message is : " + service_Popup);
				Extent_pass_New(driver, "Matched || " + " Expected Message is : " + Invalid_Service_Exp
						+ " || Actual Message is : " + service_Popup, test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Message is : " + Invalid_Service_Exp
						+ " || Actual Message is : " + service_Popup);
				Extent_fail(driver, "Not Matched || " + " Expected Message is : " + Invalid_Service_Exp
						+ " || Actual Message is : " + service_Popup, test, test1);
				
			}
			Step_End(3, "Ensure that system should validate as 'Invalid Service'.", test, test1);

			click(driver, P_Ok_Btn);

		
		Extent_completed(testcase_Name, test, test1);

	}
}
