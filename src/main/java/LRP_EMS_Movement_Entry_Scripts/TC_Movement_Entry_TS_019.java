package LRP_EMS_Movement_Entry_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Movement_Entry_TS_019 extends Keywords {

//	 To Delete move in movement entry via single entry
	
	public void deleteMoveViaSingleEntry(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Movement_Entry_TS_019";
//		Get data from excel sheet

		
		
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String sureToDeletePopup = Excel_data.get("SureToDeletePopup");
		String eqpNo = Excel_data.get("EquipmentNo");
		String deletedSingle = Excel_data.get("DeletedSingle");
		String movementCode = Excel_data.get("MovementCode");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);
		
		
		// Login

		LRP_Login(driver, username, password);
		
		Step_Start(1, "Enter the module name in the search box and click on the module.", test, test1);
		
		moduleNavigate(driver, moduleName);
		
		Step_End(1, "Enter the module name in the search box and click on the module.", test, test1);


		// Single Equipment Entry
		waitForDisplay(driver, singleEntryMovPage_L);
			
			Step_Start(2, "Enter the required container number and click Show History", test, test1);
			waitForElement(driver, equipmentNoSearchField_L);
			sendKeys(driver, equipmentNoSearchField_L, eqpNo);
			
			waitForElement(driver, showHistoryButton_L);
			click(driver, showHistoryButton_L);
			
			Step_End(2, "Enter the required container number and click Show History", test, test1);
			Step_Start(3, "Enter the movement code in the designated column.", test, test1);
			
			waitForElement(driver, eqpNoInEqpDetails_L);
			String actSaved = getText(driver, eqpNoInEqpDetails_L);
			if (actSaved.equals(eqpNo)) {
				System.out.println("Matched || " + "Single Movement Entry is retrieved || " + " Expected Value is : "
						+ eqpNo + " || Actual Value is : " + actSaved);

				Extent_pass_New(driver, "Matched || " + "Single Movement Entry is retrieved || " + " Expected Value is : "
						+ eqpNo + " || Actual Value is : " + actSaved, test, test1);
			} else {
				System.out.println("Not matched || " + "Single Movement Entry is not retrieved || "
						+ " Expected Value is : " + eqpNo + " || Actual Value  is : " + actSaved);

				Extent_fail(driver, "Not matched || " + "Single Movement Entry is not retrieved ||"
						+ " Expected Value is : " + eqpNo + " || Actual Value is : " + actSaved+"<br>"+"Single Movement Entry is not retrieved", test, test1);
			}

			List<String> movement_Code = splitAndExpand(movementCode);
			
			for(int i=0; i<movement_Code.size();i++) {
			
			String movement_Code_Input=movement_Code.get(i);
			
			waitForElement(driver, movementCode_Grid_Filter);
			click(driver, movementCode_Grid_Filter);
			waitForElement(driver, movementCode_Grid_Filter);
			sendKeys(driver, movementCode_Grid_Filter, movement_Code_Input);
			
			Step_End(3, "Enter the movement code in the designated column.", test, test1);
			Step_Start(4, "Once the move is filtered, right-click and select the Delete option", test, test1);
			
			waitForElement(driver, equipmentDetails_Grid_First_Row);
			RightClick(driver, equipmentDetails_Grid_First_Row);
			
			
			waitForElement(driver, deleteOpionSingle_L);
			click(driver, deleteOpionSingle_L);
			
			Step_End(4, "Once the move is filtered, right-click and select the Delete option", test, test1);
			Step_Start(5, "Click Yes on the system pop-up message to confirm the action", test, test1);
			
			waitForPopup(driver, popup_Message, sureToDeletePopup);
			String actConfirmDele = getText(driver, popup_Message);

			if (actConfirmDele.equals(sureToDeletePopup)) {
				Extent_pass_New(driver, "Matched || Expected Popup : "+sureToDeletePopup + " || Actual Popup : "+actConfirmDele, test, test1);
				System.out.println("Matched || Expected Popup : "+sureToDeletePopup + " || Actual Popup : "+actConfirmDele);
				click(driver, popup_Message_Yes_Button);
			}else {
				System.out.println("Not Matched || Expected Popup : "+sureToDeletePopup + " || Actual Popup : "+actConfirmDele);
				Extent_fail(driver, "Not Matched || Expected Popup : "+sureToDeletePopup + " || Actual Popup : "+actConfirmDele, test, test1);
			}
			
			Step_End(5, "Click Yes on the system pop-up message to confirm the action", test, test1);
			Step_Start(6, "A message will appear confirming that the selected container has been deleted", test, test1);

			waitForPopup(driver, popup_Message, deletedSingle);
			String actPopup = getText(driver, popup_Message);

			if (actPopup.equals(deletedSingle)) {
				Extent_pass_New(driver, "Matched || Expected Popup : "+deletedSingle + " || Actual Popup : "+actPopup, test, test1);
				System.out.println("Matched || Expected Popup : "+deletedSingle + " || Actual Popup : "+actPopup);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup : "+deletedSingle + " || Actual Popup : "+actPopup);
				Extent_fail(driver, "Not Matched || Expected Popup : "+deletedSingle + " || Actual Popup : "+actPopup, test, test1);
			}
			Step_End(6, "A message will appear confirming that the selected container has been deleted", test, test1);

			}

	    Extent_completed(testCaseName, test, test1);
	}
	
}
