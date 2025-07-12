package LRP_EMS_EDI_Configuration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EMS_EDI_Configuration_TS_015 extends Keywords {
	public void EMS_EDI_Configuration_TS_015(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_EMS_EDI_Configuration_TS_015";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Module = Excel_data.get("Module");
		String Partner_ID_input = Excel_data.get("Partner_ID_input");
		String EDI_ID_Input = Excel_data.get("EDI_ID_Input");
		String Movement_Code_input = Excel_data.get("Movement_Code_input");
		String EDI_Movement_Name = Excel_data.get("EDI_Movement_Name");
		String EDI_Movement_Code_Input = Excel_data.get("EDI_Movement_Code_Input");
		String Remove_popup = Excel_data.get("Remove_popup");
		
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
		
		waitForElement(driver, EDI_Status_Movement_Code_Input);
		sendKeys(driver, EDI_Status_Movement_Code_Input,EDI_Movement_Code_Input);
		
		waitForElement(driver, EEC_MovementCode_FilterInput);
		sendKeys(driver, EEC_MovementCode_FilterInput,EDI_Movement_Name);
		
		waitForElement(driver, EDI_Status_EDI_MovementCode_Input);
		sendKeys(driver, EDI_Status_EDI_MovementCode_Input,Movement_Code_input);
		
		
		waitForElement(driver, EDI_Status_Event_select_First_row);
		click(driver, EDI_Status_Event_select_First_row);
		
		Step_End(2, "Select any record from the AG grid", test, test1);
		
		Step_Start(3, "Click the remove button", test, test1);
		
		
		waitForElement(driver, EEC_Status_Event_Remove_Button);
		click(driver, EEC_Status_Event_Remove_Button);
		
		Step_End(3, "Click the remove button", test, test1);
		
		Step_Start(4, "Do you want to remove the row? notification \r\n"+ "popup a been show", test, test1);
		
		waitForPopup(driver, popup_Message, Remove_popup);
		String Act_Popup_Remove = getText(driver, popup_Message);

		if (Remove_popup.equals(Act_Popup_Remove)) {
			System.out.println("Matched || After click on Remove Button the Expected Pop-up value is : " + Remove_popup+ " || After click on Remove Button the Actual Pop-up value is  : " + Act_Popup_Remove);
			Extent_pass_New(driver,"Matched || After click on save Button the Expected Pop-up value is : " + Remove_popup+ " || After click on Remove Button the Actual Pop-up value is  : " + Act_Popup_Remove,test, test1);
		} else {
			System.out.println("Not Matched || After click on Remove Button the Expected Pop-up value is : " + Remove_popup+ " ||After click on Remove Button the Actual Pop-up value is  : " + Act_Popup_Remove);
			Extent_fail(driver,"Not Matched || After click on Remove Button the Expected Pop-up value is : " + Remove_popup+ " ||After click on Remove Button the Actual Pop-up value is  : " + Act_Popup_Remove,
					test, test1);
		}
		
		
		Step_End(4, "Do you want to remove the row? notification \r\n"+ "popup a been show", test, test1);
		
		Step_Start(5, "Click the yes button", test, test1);
		
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		
		Step_End(5, "Click the yes button", test, test1);
		
		Step_Start(6, "Now Movementcode Configuration removed \r\n"+ "popup as been show", test, test1);
		
		
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
		sendKeys(driver, EDI_Status_EDI_MovementCode_Input,Movement_Code_input);
		
		
		if(!isdisplayed(driver, EDI_Status_Event_select_First_row)) {
			System.out.println("Matched ||  Expected result : Given Partener Id,EDI id,Movemonent Code,Movement Name should be Remove in the grid || Actual result : Given Partener Id,EDI id,Movemonent Code,Movement Name  was Removed in the grid");
			Extent_pass_New(driver,"Matched ||  Expected result : Given Partener Id,EDI id,Movemonent Code,Movement Name should be Remove in the grid || Actual result : Given Partener Id,EDI id,Movemonent Code,Movement Name  was Removed in the grid",test, test1);
		}else {
			System.out.println("Not Matched ||  Expected result : Given Partener Id,EDI id,Movemonent Code,Movement Name should be Remove in the grid || Actual result : Given Partener Id,EDI id,Movemonent Code,Movement Name  was Not Removed in the grid");
			Extent_fail(driver,"NOt Matched ||  Expected result : Given Partener Id,EDI id,Movemonent Code,Movement Name should be Remove in the grid || Actual result : Given Partener Id,EDI id,Movemonent Code,Movement Name  was Not Removed in the grid",test, test1);
		}
		
		Step_End(6, "Now Movementcode Configuration removed \r\n"+ "popup as been show", test, test1);
		
		Extent_completed(testcase_Name, test, test1);

	}
}