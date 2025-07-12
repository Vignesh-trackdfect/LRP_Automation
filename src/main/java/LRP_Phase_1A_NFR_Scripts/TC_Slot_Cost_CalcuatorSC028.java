package LRP_Phase_1A_NFR_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Slot_Cost_CalcuatorSC028 extends Keywords {
	public void Slot_Cost_CalcuatorSC028(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Slot_Cost_CalcuatorSC028";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Slot_Cost_Module = Excel_data.get("Slot_Cost_Module");
		String Action_option = Excel_data.get("Action_option");
		String TEU_Option = Excel_data.get("TEU_Option");
		String TEU_Input = Excel_data.get("TEU_Input");
		String Slot_Updated_Popup = Excel_data.get("Slot_Updated_Popup");

		
		Extent_Start(testcase_Name, test, test1);
		 
		Step_Start(1, "Open the application.", test, test1);

		navigateUrl(driver, url);
		
		Step_End(1, "Open the application.", test, test1);
		
		Step_Start(2, "Go to the Slot Cost Calculator Module where the ag-Grid component is present.", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Slot_Cost_Module);
		
		Step_End(2, "Go to the Slot Cost Calculator Module where the ag-Grid component is present.", test, test1);

		Step_Start(3, "Assert that the grid is visible. By click on action to retrieve data.(MainLine)", test, test1);

		formatLocatorClick(driver, SCC_Action_Button, Action_option);
		
		Step_Start(4, "Navigate to Slot Cost Calculator Tab.", test, test1);

		waitForDisplay(driver, SCC_Slot_Cost_Calculator_Option);
		if(isDisplayed(driver, SCC_Slot_Cost_Calculator_Option)) {
			
			System.out.println("After clicking on 'Action', the Slot Cost Calculator module is displayed successfully.");		
			Extent_pass_New(driver, "After clicking on 'Action', the Slot Cost Calculator module is displayed successfully.",test, test1);

		}else {
			System.out.println("After clicking on 'Action', the Slot Cost Calculator module is displayed successfully.");		
			Extent_fail(driver, "After clicking on 'Action', the Slot Cost Calculator module is displayed successfully.",test, test1);

		}
		waitForElement(driver, SCC_Slot_Cost_Calculator_Option);
		click(driver, SCC_Slot_Cost_Calculator_Option);
		
		Step_End(4, "Navigate to Slot Cost Calculator Tab.", test, test1);

		Step_Start(5, "Click on Edit Option on the tool bar.", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		
		Step_End(5, "Click on Edit Option on the tool bar.", test, test1);

		
		Step_Start(6, "Locate a specific cell(eg: TEU@14MT).", test, test1);

		Step_Start(7, "Simulate double-click or press Enter key on the cell.", test, test1);
		Step_Start(8, "Type a new valid value (eg:112.00) and click enter.", test, test1);

		
		List<String> Act_Row = splitAndExpand(TEU_Option);
		List<String> Act_Input = splitAndExpand(TEU_Input);
		
		
		for (int i = 0; i < Act_Row.size(); i++) {

			formatLocatorDoubleClick(driver, SCC_Teu_Option, Act_Row.get(i));
			
			waitForElement(driver, SCC_Teu_Input_Option);
			sendKeys(driver, SCC_Teu_Input_Option, Act_Input.get(i));
			 enter(driver);

		}
		
	  
		
		Step_End(8, "Type a new valid value (eg:112.00) and click enter.", test, test1);
		Step_End(7, "Simulate double-click or press Enter key on the cell.", test, test1);
		Step_End(6, "Locate a specific cell(eg: TEU@14MT).", test, test1);

		Step_Start(9, "Click save button on the tool bar.", test, test1);

         waitForElement(driver, SaveButton_ToolBar);
         click(driver,SaveButton_ToolBar);
         
 		Step_End(9, "Click save button on the tool bar.", test, test1);
 		
		Step_Start(10, "To Retrive the data whether input is present on respective data.", test, test1);

         
		
 		waitForPopup(driver, popup_Message, Slot_Updated_Popup);
 		String Act_Popup= getText(driver, popup_Message);
 		
 		if(Act_Popup.equals(Slot_Updated_Popup)) {
 			
 			System.out.println("Matched || Expected Popup Message was : " + Slot_Updated_Popup+ " || Actual Popup Message was : " + Act_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup Message was : " + Slot_Updated_Popup	+ " || Actual Popup Message was : " + Act_Popup, test, test1);
 			
 		}else {
 			System.out.println("Matched || Expected Popup Message was : " + Slot_Updated_Popup+ " || Actual Popup Message was : " + Act_Popup);
			Extent_fail(driver, "Matched || Expected Popup Message was : " + Slot_Updated_Popup	+ " || Actual Popup Message was : " + Act_Popup, test, test1);
 			
 		}
 		
 	    waitForElement(driver, popup_Message_Ok_Button);
 	    click(driver, popup_Message_Ok_Button);
 		
 		
 	   waitForElement(driver, SCC_Slot_Cost_Calculator_Option);
	   click(driver, SCC_Slot_Cost_Calculator_Option);
 	   
 		
	   
	   for (int i = 0; i < Act_Row.size(); i++) {

			String act=String.format(SCC_Teu_Option, Act_Row.get(i));
			
			String act_Inputs=getText(driver, act);
			
			if(act_Inputs.equals(Act_Input.get(i))) {
				System.out.println("Matched || Expected value: " + Act_Input.get(i) + " || Actual value: " + act_Inputs);
				Extent_pass_New(driver, "Matched || Expected value: " + Act_Input.get(i) + " || Actual value: " + act_Inputs, test, test1);

			}else {
				System.out.println("Not Matched || Expected value: " + Act_Input.get(i) + " || Actual value: " + act_Inputs);
				Extent_fail(driver, "Not Matched || Expected value: " + Act_Input.get(i) + " || Actual value: " + act_Inputs, test, test1);
				
			}
			

		}
	   
		Step_End(10, "To Retrive the data whether input is present on respective data.", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
	   
 		
}
}