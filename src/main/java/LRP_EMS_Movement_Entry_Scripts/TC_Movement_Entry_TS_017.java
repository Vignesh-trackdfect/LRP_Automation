package LRP_EMS_Movement_Entry_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



//  To Edit & update location and terminal in movement entry via single equipment

public class TC_Movement_Entry_TS_017 extends Keywords {

	public void editUpdateViaSingleEquipment(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Movement_Entry_TS_017";
//		Get data from excel sheet

		
		
		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String movement_Code = Excel_data.get("Movement_Code");
		String eqpNoSingleEdit = Excel_data.get("EquipmentNo");
		String uptadedSinglePopup = Excel_data.get("UpdatedPopup");
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		Step_Start(1, "Enter module name in searchbox & click the module", test, test1);

//	Search module
		moduleNavigate(driver, moduleName);
		
		Step_End(1, "Enter module name in searchbox & click the module", test, test1);

		
		// Movement Entry
		
		Step_Start(2, "Enter the required container number and click on \"Show History\".", test, test1);
		// Single Equipment Entry
		waitForDisplay(driver, singleEntryMovPage_L);

		waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, eqpNoSingleEdit);

			waitForElement(driver, showHistoryButton_L);
			click(driver, showHistoryButton_L);

			Step_End(2, "Enter the required container number and click on \"Show History\".", test, test1);

			Step_Start(3, "Right-click on the activity code specified in the data sheet.", test, test1);
			
			waitForElement(driver, movementCode_Grid_Filter);
			click(driver, movementCode_Grid_Filter);
			waitForElement(driver, movementCode_Grid_Filter);
			sendKeys(driver, movementCode_Grid_Filter, movement_Code);
			
			
			waitForElement(driver, eqpNoInEqpDetails_L);
			String actSaved = getText(driver, eqpNoInEqpDetails_L);
			if (actSaved.equals(eqpNoSingleEdit)) {
				System.out.println("Matched || " + " Expected Value is : " + eqpNoSingleEdit + " || Actual Value is : "+ actSaved);
				Extent_pass_New(driver,
						"Matched || Equipment number is retrieved || " + " Expected Value is : " + eqpNoSingleEdit + " || ActualValue is : " + actSaved,
						test, test1);

				waitForDisplay(driver, eqpNoInEqpDetails_L);
				RightClick(driver, eqpNoInEqpDetails_L);
				
				Step_End(3, "Right-click on the activity code specified in the data sheet.", test, test1);
				Step_Start(4, "Click the \"Edit\" button to open the activity details.", test, test1);
				
				waitForElement(driver, singleEdit_2);
				click(driver, singleEdit_2);
				
				Step_End(4, "Click the \"Edit\" button to open the activity details.", test, test1);

			} else {
				System.out.println("Not matched || " + " Expected Value is : " + eqpNoSingleEdit
						+ " || Actual Value  is : " + actSaved);
				Extent_fail(driver, "Not matched || Equipment number not retrieved || " + " Expected Value is : " + eqpNoSingleEdit
						+ " || Actual Value is : " + actSaved, test, test1);
			}
			
			Step_Start(5, "Clear the existing data and enter the new values as provided in the data sheet.", test, test1);

			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, Excel_data, test, test1);
			
			Step_End(5, "Clear the existing data and enter the new values as provided in the data sheet.", test, test1);
			Step_Start(6, "Click \"Save\", and the system should display a confirmation message indicating the update was successful.", test, test1);

			waitForElement(driver, equipmentNoSearchField_L);
			String ActualEqNo = getAttribute(driver, equipmentNoSearchField_L, "value");
			System.out.println("ActualEqNo:" + ActualEqNo);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, popup_Message, uptadedSinglePopup);
			String actPopupText = getText(driver, popup_Message);
			if (actPopupText.equals(uptadedSinglePopup)) {
				System.out.println("Matched || " + " Expected Popup is : " + uptadedSinglePopup
						+ " || Actual Popup is : " + actPopupText);

				Extent_pass_New(driver, "Matched || "+uptadedSinglePopup + " popup is displayed" + " || Expected Popup is : " + uptadedSinglePopup
						+ " || Actual Popup is : " + actPopupText, test, test1);
				click(driver, popup_Message_Ok_Button);

			} else {
				System.out.println("Not matched || " + " Expected Popup is : " + uptadedSinglePopup
						+ " || Actual Popup  is : " + actPopupText);

				Extent_fail(driver, "Not matched || "+uptadedSinglePopup + " popup is not displayed" + "|| Expected Popup is : " + uptadedSinglePopup
						+ " || Actual Popup is : " + actPopupText, test, test1);
			}


			Step_End(6, "Click \"Save\", and the system should display a confirmation message indicating the update was successful.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
