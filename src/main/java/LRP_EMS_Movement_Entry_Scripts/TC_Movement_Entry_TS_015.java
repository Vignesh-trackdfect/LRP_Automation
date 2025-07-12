package LRP_EMS_Movement_Entry_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Movement_Entry_TS_015 extends Keywords {

	//	To Create Moves via Single Entry in movement entry

	public void createMovesviaSingleEntry(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_Movement_Entry_TS_015";
		
		
		
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String activityEqpEntry = Excel_data.get("ActivityEqpEntry");
		String eqpNo = Excel_data.get("EquipmentNo");
		String savedPopupText = Excel_data.get("SavedPopup");
		String datePicker=Excel_data.get("DatePicker");
		String activityDateSingle = Excel_data.get("ActivityDate");
		String activityHourSingle = Excel_data.get("ActivityHour");
		String Want_To_Delete = Excel_data.get("Want_To_Delete");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		Step_Start(1, "Enter the module name in the search box and click on the corresponding module from the list", test, test1);

//		Module Search
		
		moduleNavigate(driver, moduleName);
		
		Step_End(1, "Enter the module name in the search box and click on the corresponding module from the list", test, test1);
		Step_Start(2, "Input a valid container number in the Equipment No. field.", test, test1);
		// Movement Entry

		// Single Equipment Entry
		waitForDisplay(driver, singleEntryMovPage_L);

			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, eqpNo);

			Step_End(2, "Input a valid container number in the Equipment No. field.", test, test1);
			Step_Start(3, "Enter the given activity code in the data sheet and press Enter.", test, test1); 

			
			waitForElement(driver, activitySearchFieldInSingle_L);
			sendKeys(driver, activitySearchFieldInSingle_L, activityEqpEntry);
			waitForElement(driver, autoCompleteValue_ME);
			enter(driver);
			
			Step_End(3, "Enter the given activity code in the data sheet and press Enter.", test, test1);
			Step_Start(4, "Select the appropriate date from the date picker.", test, test1);
			
			waitForElement(driver, activeDateInSingle_L);

			if(datePicker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, activeDateInSingle_L, activityDateSingle);
			}else {
				if(activityDateSingle.contains("-")) {
					click(driver, activeDateInSingle_L);
					String activityDateSingle_1=activityDateSingle.replace("-", "/");
					clearAndType(driver, activeDateInSingle_L, activityDateSingle_1);

				}else {
					click(driver, activeDateInSingle_L);
					clearAndType(driver, activeDateInSingle_L, activityDateSingle);
				}		
			}

			if (!activityHourSingle.equals("")) {

				click(driver, activityTime);

				if (isDisplayed(driver, Calender)) {
					click(driver, activityTime_Input);
					waitForElement(driver, activity_Time);
					clearAndType(driver, activity_Time, activityHourSingle);
					waitForElement(driver, activityTime_Close);
					click(driver, activityTime_Close);
				}				

			}
			
			Step_End(4, "Select the appropriate date from the date picker.", test, test1);
			Step_Start(5, "Click \"Show Input Fields\", and if a confirmation prompt appears for the check digit, click \"Yes\" to proceed.", test, test1);

			waitForElement(driver, showInputSin_L);
			click(driver, showInputSin_L);

			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);
				
			}
			
			Step_End(5, "Click \"Show Input Fields\", and if a confirmation prompt appears for the check digit, click \"Yes\" to proceed.", test, test1);
			Step_Start(6, "Based on the provided data sheet, ensure the script fills the fields in the correct sequence.", test, test1);

			
			Movement_Entry_All_Elements allElements=new Movement_Entry_All_Elements();
			allElements.movementEntryAllElements(driver, Excel_data, test, test1);
			
			Step_End(6, "Based on the provided data sheet, ensure the script fills the fields in the correct sequence.", test, test1);
			Step_Start(7, "Finally, click the \"Save\" button from the toolbar.", test, test1);

			scrollTop(driver);
			waitForElement(driver, equipmentNoSearchField_L);
			String ActualEqNo = getAttribute(driver, equipmentNoSearchField_L, "value");
			System.out.println("ActualEqNo:" + ActualEqNo);
			
			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(7, "Finally, click the \"Save\" button from the toolbar.", test, test1);
			Step_Start(8, "A \"Single Entry Save\" success message should be displayed upon successful submission.", test, test1);

			waitForPopup(driver, popup_Message, savedPopupText);
				String actText = getText(driver, popup_Message);
				if (actText.equals(savedPopupText)) {
					System.out.println("Matched || " + " Expected popup is : " + savedPopupText
							+ " || Actual popup is : " + actText);
					Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedPopupText
							+ " || Actualpopup is : " + actText+"\r\n"+savedPopupText + " popup is displayed", test, test1);
					System.out.println(savedPopupText + " popup is displayed");
					click(driver, popup_Message_Ok_Button);

				} else {
					System.out.println("Not matched || " + " Expected popup is : " + savedPopupText
							+ " || Actual popup  is : " + actText);
					System.out.println(savedPopupText + " popup is not displayed");
					Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedPopupText
							+ " || Actual popup is : " + actText+"\r\n"+savedPopupText + " popup is not displayed", test, test1);
				}
			
			
			Extent_pass_New(driver, "Actual Equipment Number : "+ActualEqNo, test, test1);
			

			Step_End(8, "A \"Single Entry Save\" success message should be displayed upon successful submission.", test, test1);
			
			// Search

			waitForElement(driver, cancel_Common_btn);
			click(driver, cancel_Common_btn);

			newButton(driver);
			
			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, ActualEqNo);
			
			waitForElement(driver, showHistoryButton_L);
			click(driver, showHistoryButton_L);
			
			String retrieved_Record=String.format(retrieved_Equipment_Number, ActualEqNo);
			waitForElement(driver, retrieved_Record);

			String actSaved = getText(driver, retrieved_Record);
			if (actSaved.equals(ActualEqNo)) {
				System.out.println("Matched || " + "Single Movement Entry is saved || " + " Expected Equipment Number is : "
						+ ActualEqNo + " || Actual Equipment Number is : " + actSaved);

				Extent_pass_New(driver, "Matched || " + "Single Movement Entry is saved || " + " Expected Equipment Number is : "
						+ ActualEqNo + " || ActualEquipment Number is : " + actSaved+"\r\n"+"Single Movement Entry is saved", test, test1);
			} else {
				System.out.println("Not matched || " + "Single Movement Entry is not saved || "
						+ " Expected Equipment Number is : " + ActualEqNo + " || Actual Equipment Number  is : " + actSaved);

				Extent_fail(driver, "Not matched || " + "Single Movement Entry is not saved ||"
						+ " Expected Equipment Number is : " + ActualEqNo + " || Actual Equipment Number is : " + actSaved+"\r\n"+"Single Movement Entry not saved", test, test1);
			}

			if(Want_To_Delete.equalsIgnoreCase("Yes")) {

			waitForElement(driver, equipmentDetails_Grid_First_Row);
			RightClick(driver, equipmentDetails_Grid_First_Row);
			
			
			waitForElement(driver, deleteOpionSingle_L);
			click(driver, deleteOpionSingle_L);
			
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
				
			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message_Ok_Button)) {
				click(driver, popup_Message_Ok_Button);
			}

			}
		
		Extent_completed(testCaseName, test, test1);
	}

}
