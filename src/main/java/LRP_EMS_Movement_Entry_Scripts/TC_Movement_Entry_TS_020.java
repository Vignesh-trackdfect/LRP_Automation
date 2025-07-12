package LRP_EMS_Movement_Entry_Scripts;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Movement_Entry_TS_020 extends Keywords {

//	To Delete move in movement entry via multiple entry
	
	public void deleteMoveViaMultipleEntry(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Movement_Entry_TS_020";
//		Get data from excel sheet
		
		
		
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleMovementEntry");
		String multiDeleted = Excel_data.get("MultipleMovEntryDeleted");
		
		String movement_Code = Excel_data.get("Movement_Code");
		String GlobalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String dropdownCondition_Date = Excel_data.get("dropdownCondition_Date");
		String dropdown_Condition = Excel_data.get("Dropdown_Condition");

		String GlobalSearchFilterOption2 = Excel_data.get("GlobalSearchFilterOption2");
		String GlobalSearchFilterOption3= Excel_data.get("GlobalSearchFilterOption3");
		String Search_Input1 = Excel_data.get("RetrieveEqpNo");
		String Search_Input2 = Excel_data.get("Movement_Code");
		String Search_Input3= Excel_data.get("Activity_Date");
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);

		// Login

		LRP_Login(driver, username, password);
		
		Step_Start(1, "Enter the module name in the search box and click on the module", test, test1);
		
		moduleNavigate(driver, moduleName);
		
		Step_End(1, "Enter the module name in the search box and click on the module", test, test1);

		
		// Multiple Equipment Entry
				Step_Start(2, "Select the Multiple Equipment Entry option", test, test1);
				
				waitForElement(driver, multiEntryMovPage_L);
				click(driver, multiEntryMovPage_L);
				
				Step_End(2, "Select the Multiple Equipment Entry option", test, test1);
				
		waitForDisplay(driver, multiEntryMovPage_L);
			
			waitForElement(driver, activitySearchField_L);
	
				Step_Start(3, "Click on the Global Search icon in the toolbar.", test, test1);
				
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				Step_End(3, "Click on the Global Search icon in the toolbar.", test, test1);
				Step_Start(4, "Fill in the required filter fields such as Equipment Number, Movement Code, and Activity Date.", test, test1);

				if (!Search_Input1.equals("")) {
					waitForElement(driver, type_Select1);
					selectByText(driver, type_Select1, GlobalSearchFilterOption1);
					waitForDisplay(driver, type_Select1);
					selectByText(driver, globalSearch_Condition_Dropdown1, dropdown_Condition);
					waitForDisplay(driver, globalSearch_InputTextfield1);
					sendKeys(driver, globalSearch_InputTextfield1, Search_Input1);
				}
				if (!Search_Input2.equals("")) {
					waitForElement(driver, type_Select2);
					selectByText(driver, type_Select2, GlobalSearchFilterOption2);
					waitForDisplay(driver, type_Select2);
					selectByText(driver, globalSearch_Condition_Dropdown2, dropdown_Condition);
					waitForDisplay(driver, globalSearch_InputTextfield2);
					sendKeys(driver, globalSearch_InputTextfield2, Search_Input2);
				}
				if (!Search_Input3.equals("")) {
					waitForElement(driver, type_Select3);
					selectByText(driver, type_Select3, GlobalSearchFilterOption3);
					waitForDisplay(driver, Roe_Date_Condition);
					selectByText(driver, Roe_Date_Condition, dropdownCondition_Date);
					waitForDisplay(driver, Roe_Date_Field);
					sendKeys(driver, Roe_Date_Field, Search_Input3);
				}
				Step_End(4, "Fill in the required filter fields such as Equipment Number, Movement Code, and Activity Date.", test, test1);
				Step_Start(5, "Click the Search button to display the relevant results.", test, test1);

				waitForElement(driver, globalSearch_Frame_SearchButton);
				click(driver, globalSearch_Frame_SearchButton);
				
				waitForElement(driver, SelectButton);
				click(driver, SelectButton);
				elementnotvisible1(driver, SelectButton);
				

				Step_End(5, "Click the Search button to display the relevant results.", test, test1);
			
			Step_Start(6, "Select the rows to delete.", test, test1);

			waitForElement(driver, movementCode_Grid_Filter);
			click(driver, movementCode_Grid_Filter);
			waitForElement(driver, movementCode_Grid_Filter);
			sendKeys(driver, movementCode_Grid_Filter, movement_Code);
			
			Actions actions=new Actions(driver);
			actions.keyDown(Keys.SHIFT).perform();
			waitForDisplay(driver, equipmentDetails_Table_Last_Row);
			scrollElementToCenter(driver, equipmentDetails_Table_Last_Row);
			waitForElement(driver, equipmentDetails_Table_Last_Row);
			click(driver, equipmentDetails_Table_Last_Row);
			actions.keyUp(Keys.SHIFT).perform();
			
			Step_End(6, "Select the rows to delete.", test, test1);
			Step_Start(7, "Right-click on the yellow-highlighted area and choose the Delete option.", test, test1);
			
			waitForElement(driver, equipmentDetails_Grid_First_Row);
			RightClick(driver, equipmentDetails_Grid_First_Row);
			
			waitForElement(driver, multiDeleteOption_L);
			click(driver, multiDeleteOption_L);
			
			Step_End(7, "Right-click on the yellow-highlighted area and choose the Delete option.", test, test1);
			Step_Start(8, "When prompted with the confirmation message \"Are you sure you want to delete the Multiple Movement Entry?\", select Yes.", test, test1);
			
			waitForPopup(driver, popup_Message, multiDeleted);

			if (isDisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);
			}
			Step_End(8, "When prompted with the confirmation message \"Are you sure you want to delete the Multiple Movement Entry?\", select Yes.", test, test1);
			Step_Start(9, "Click OK when the validation message \"Multiple Movement Entry deleted\" appears.", test, test1);

			waitForPopup(driver, popup_Message, multiDeleted);

				String actText1 = getText(driver, popup_Message);
				if (actText1.equals(multiDeleted)) {
					Extent_pass_New(driver, "Matched || Expected Popup : "+multiDeleted + " || Actual Popup : "+actText1, test, test1);
					System.out.println("Matched || Expected Popup : "+multiDeleted + " || Actual Popup : "+actText1);
					click(driver, popup_Message_Ok_Button);
				}else {
					System.out.println("Not Matched || Expected Popup : "+multiDeleted + " || Actual Popup : "+actText1);
					Extent_fail(driver, "Not Matched || Expected Popup : "+multiDeleted + " || Actual Popup : "+actText1, test, test1);
				}
				Step_End(9, "Click OK when the validation message \"Multiple Movement Entry deleted\" appears.", test, test1);
				
		Extent_completed(testCaseName, test, test1);
	}
	
}
