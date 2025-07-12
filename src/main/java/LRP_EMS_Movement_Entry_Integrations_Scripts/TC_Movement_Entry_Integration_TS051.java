package LRP_EMS_Movement_Entry_Integrations_Scripts;

import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import LRP_EMS_Movement_Entry_Scripts.Movement_Entry_All_Elements;
import commonMethods.Keywords;



public class TC_Movement_Entry_Integration_TS051 extends Keywords {

	public void Movement_Entry_Integration_TS051(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Movement_Entry_Integration_TS051";
		
		
		

		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String Activity_Move_Txt3 = Excel_data.get("Activity_Move");
		String Invalid_Service_Input = Excel_data.get("Invalid_Service_Input");
		String Equip_Number_Txt3 = Excel_data.get("Equip_Number");
		String Invalid_Voyage_Exp = Excel_data.get("Invalid_Voyage");
		String activityDateSingle51 = Excel_data.get("activityDateSingle51");
		String datePicker = Excel_data.get("datePicker");
		String activityTime_Input1 = Excel_data.get("activityTime_Input1");
		String Invalid_Vessel_Input = Excel_data.get("Invalid_Vessel_Input");
		String Invalid_Voyage_Input = Excel_data.get("Invalid_Voyage_Input");
		
				
				navigateUrl(driver, url);

				Extent_Start(testcase_Name, test, test1);
				
		// Login

		LRP_Login(driver, username, password);

		// To validate if user try to save invalid voyage in LODF
				
				//Module Search
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);
				moduleNavigate(driver, moduleName);
				Step_End(1, "Enter module name in searchbox & click the module", test, test1);
				Step_Start(2, "Ensure that system should validate if user try save LODF move with all valid details & given invalid voyage", test, test1);

		waitForElement(driver, multiEntryMovPage_L);
		click(driver, multiEntryMovPage_L);
		waitForElement(driver, multiEntryMovPage_L);

		waitForElement(driver, activitySearchField_L);
			sendKeys(driver, activitySearchField_L, Activity_Move_Txt3);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			if (!activityDateSingle51.equals("")) {
				waitForElement(driver, MultiActivity_Date);
				
				
				if(datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, MultiActivity_Date, activityDateSingle51);
						
				}else {
					click(driver, MultiActivity_Date);

					if(activityDateSingle51.contains("-")) {
						String activityDateSingle50_1=activityDateSingle51.replace("-", "/");
						clear(driver,MultiActivity_Date);
						sendKeys(driver, MultiActivity_Date, activityDateSingle50_1);
						
					}else {
					clearAndType(driver, MultiActivity_Date, activityDateSingle51);
					
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
			
			waitForElement(driver, addButtonMulti_L);
			click(driver, addButtonMulti_L);

			
			waitForElement(driver, selectGridCell_1_L);
			click(driver, selectGridCell_1_L);
			sendKeys(driver, eqpNum_Inputfield, Equip_Number_Txt3);
		
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(2, "Ensure that system should validate if user try save LODF move with all valid details & given invalid voyage", test, test1);
			Step_Start(3, "Ensure that system should validate as 'Invalid voyage'.", test, test1);

			waitForPopup(driver, P_Invalid_Voyage_Popup, Invalid_Voyage_Exp);
			String voyage_Popup = getText(driver, P_Invalid_Voyage_Popup);
			if (Invalid_Voyage_Exp.equals(voyage_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Invalid_Voyage_Exp
						+ " || Actual Popup is : " + voyage_Popup);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Invalid_Voyage_Exp
						+ " || Actual Popup is : " + voyage_Popup, test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Invalid_Voyage_Exp
						+ " || Actual Popup is : " + voyage_Popup);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Invalid_Voyage_Exp
						+ " || Actual Popup is : " + voyage_Popup, test, test1);
				
			}
			click(driver, P_Ok_Btn);

			Step_End(3, "Ensure that system should validate as 'Invalid voyage'.", test, test1);

			Extent_completed(testcase_Name, test, test1);
		

	}
}
