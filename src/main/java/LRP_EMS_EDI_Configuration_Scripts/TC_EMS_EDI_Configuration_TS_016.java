package LRP_EMS_EDI_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EMS_EDI_Configuration_TS_016 extends Keywords{
	
	public void EMS_EDI_Configuration_TS_016(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {
		
		String testcase_Name = "TC_EMS_EDI_Configuration_TS_016";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		
		String Partner_ID_input = Excel_data.get("Partner_ID_input");
		String EDI_ID_Input = Excel_data.get("EDI_ID_Input");
		String Movement_Code_input = Excel_data.get("Movement_Code_input");
		String EDI_Movement_Name = Excel_data.get("EDI_Movement_Name");
		String EDI_Movement_Code_Input = Excel_data.get("EDI_Movement_Code_Input");
		String Updated_popup = Excel_data.get("Updated_popup");
		String Update_EDI_Movement_Code = Excel_data.get("Update_EDI_Movement_Code");
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		moduleNavigate(driver, Module);

		Step_Start(1, "Click the status event tab", test, test1);

		waitForElement(driver, EDI_Status_Event_Option);
		click(driver, EDI_Status_Event_Option);

		Step_End(1, "Click the status event tab", test, test1);
		
  	    Step_Start(2, "Select any record from the AG grid", test, test1);
		
		
		waitForElement(driver, EDI_Status_Event_Filter);
		click(driver, EDI_Status_Event_Filter);
		
		waitForElement(driver, EDI_Status_Event_Filter);
		sendKeys(driver, EDI_Status_Partner_Id_Input,Partner_ID_input);
		
		waitForElement(driver, EDI_Status_EDI_Id_Input);
		sendKeys(driver, EDI_Status_EDI_Id_Input,EDI_ID_Input);
		
		waitForElement(driver, EEC_MovementCode_FilterInput);
		sendKeys(driver, EEC_MovementCode_FilterInput,EDI_Movement_Name);
		
		
		waitForElement(driver, EDI_Status_Movement_Code_Input);
		sendKeys(driver, EDI_Status_Movement_Code_Input,EDI_Movement_Code_Input);
		
	
		
		waitForElement(driver, EDI_Status_EDI_MovementCode_Input);
		sendKeys(driver, EDI_Status_EDI_MovementCode_Input,Movement_Code_input);
		
		
		waitForElement(driver, EDI_Status_Event_select_First_row);
		doubleClick(driver, EDI_Status_Event_select_First_row);
		
		Step_End(2, "Select any record from the AG grid", test, test1);
		
		Step_Start(3, "update the EDI Movement Code field data", test, test1);
		
		waitForElement(driver, EEC_Status_Event_Add_Button);
		clear(driver, EEC_Status_Event_Add_Button);
		sendKeys(driver, EEC_Status_Event_Add_Button, Update_EDI_Movement_Code);
		
		Step_End(3, "update the EDI Movement Code field data", test, test1);
		
		
		Step_Start(4, "click the Add button to add in the AG Grid", test, test1);
		
		
		waitForElement(driver, EDI_Status_Add_button);
		click(driver, EDI_Status_Add_button);
		
		
		
		Step_End(4, "click the Add button to add in the AG Grid", test, test1);	
		
		Step_Start(5, "Click the save button to save the changes\r\n"+ "", test, test1);
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		
		
		waitForPopup(driver, popup_Message, Updated_popup);
		String Act_Popup_Updated = getText(driver, popup_Message);

		if (Updated_popup.equals(Act_Popup_Updated)) {
			System.out.println("Matched || After click on save Button the Expected Pop-up message is : " + Updated_popup+ " || After click on save Button the Actual Pop-up message is  : " + Act_Popup_Updated);
			Extent_pass_New(driver,"Matched || After click on save Button the Expected Pop-up message is : " + Updated_popup+ " || After click on save Button the Actual Pop-up message is  : " + Act_Popup_Updated,test, test1);
		} else {
			System.out.println("Not Matched || After click on save Button the Expected Pop-up message is : " + Updated_popup+ " ||After click on save Button the Actual Pop-up message is  : " + Act_Popup_Updated);
			Extent_fail(driver,"Not Matched || After click on save Button the Expected Pop-up message is : " + Updated_popup+ " ||After click on save Button the Actual Pop-up message is  : " + Act_Popup_Updated,
					test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
		
		waitForElement(driver, EDI_Status_Event_Filter);
		click(driver, EDI_Status_Event_Filter);
		
		waitForElement(driver, EDI_Status_Partner_Id_Input);
		sendKeys(driver, EDI_Status_Partner_Id_Input,Partner_ID_input);
		
		waitForElement(driver, EDI_Status_EDI_Id_Input);
		sendKeys(driver, EDI_Status_EDI_Id_Input,EDI_ID_Input);
		
		waitForElement(driver, EDI_Status_Movement_Code_Input);
		sendKeys(driver, EDI_Status_Movement_Code_Input,EDI_Movement_Code_Input);
		
		waitForElement(driver, EEC_MovementCode_FilterInput);
		sendKeys(driver, EEC_MovementCode_FilterInput,EDI_Movement_Name);
		
		waitForElement(driver, EDI_Status_EDI_MovementCode_Input);
		sendKeys(driver, EDI_Status_EDI_MovementCode_Input,Update_EDI_Movement_Code);
		
		
		if(isdisplayed(driver, EDI_Status_Event_select_First_row)) {
			System.out.println("Matched ||  Expected result : Given Partener Id,EDI id,Movemonent Code,Movement Name should be updated in the grid || Actual result : Given Partener Id,EDI id,Movemonent Code,Movement Name  was updated in the grid");
			Extent_pass_New(driver,"Matched ||  Expected result : Given Partener Id,EDI id,Movemonent Code,Movement Name should be updated in the grid || Actual result : Given Partener Id,EDI id,Movemonent Code,Movement Name  was updated in the grid",test, test1);
		}else {
			System.out.println("Not Matched ||  Expected result : Given Partener Id,EDI id,Movemonent Code,Movement Name should be updated in the grid || Actual result : Given Partener Id,EDI id,Movemonent Code,Movement Name  was Not updated in the grid");
			Extent_fail(driver,"NOt Matched ||  Expected result : Given Partener Id,EDI id,Movemonent Code,Movement Name should be updated in the grid || Actual result : Given Partener Id,EDI id,Movemonent Code,Movement Name  was Not updated in the grid",test, test1);
		}
		
		
		Step_End(5, "Click the save button to save the changes\r\n"+ "", test, test1);
		
		
		
		
		Extent_completed(testcase_Name, test, test1);


}
}