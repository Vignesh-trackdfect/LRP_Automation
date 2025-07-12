package LRP_DG_Creation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_012 extends Keywords{
	public void DG_Creation_SC_012(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_012";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
		String Request_Sent_Popup = Excel_data.get("Request_Sent_Popup");
		String DG_Gate_Module = Excel_data.get("DG_Gate_Module");
		String date_Picker = Excel_data.get("date_Picker");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String Remarks = Excel_data.get("Remarks");
		String Exp_partial_accept_popup = Excel_data.get("Exp_partial_accept_popup");
		String Partical_Accept = Excel_data.get("Partical_Accept");
		String Grid_Column = Excel_data.get("Grid_Column");
		String Grid_Status_Value = Excel_data.get("Grid_Status_Value");


		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		SwitchProfile(driver, AgencyUser);

		moduleNavigate(driver, DG_Creation_Module);

		newButton(driver);

		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_Start(4, "click multi apply  button", test, test1);
		
		scrollElementToCenter(driver, Multi_Apply_Btn);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
		waitForPopup(driver, popup_Message, Applied_Popup_Exp);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(Applied_Popup_Exp)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp
					+ " || Actual Report Activity is : " + Applied_Popup, test, test1);
		}

		Step_End(4, "click multi apply  button", test, test1);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		Step_Start(5, "Click save button ", test, test1);
		waitForElement(driver, DG_Save_Btn);
		safeclick(driver, DG_Save_Btn);

		waitForPopup(driver, popup_Message, Details_Saved_Popup);
		String Saved_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if (Saved_Popup.equals(Details_Saved_Popup)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Details_Saved_Popup
					+ " || Actual Report Activity is : " + Saved_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Details_Saved_Popup
					+ " || Actual Report Activity is : " + Saved_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup
					+ " || Actual Report Activity is : " + Saved_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup
					+ " || Actual Report Activity is : " + Saved_Popup, test, test1);
		}
		Step_End(5, "Click save button ", test, test1);

		Step_Start(6, "Click sent button.", test, test1);

		waitForElement(driver, Send_Btn);
		safeclick(driver, Send_Btn);
		waitForPopup(driver, popup_Message, Request_Sent_Popup);
		String act_Popup = getText(driver, popup_Message);
		System.out.println(act_Popup);
		if (act_Popup.equals(Request_Sent_Popup)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Request_Sent_Popup
					+ " || Actual Report Activity is : " + act_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Request_Sent_Popup
					+ " || Actual Report Activity is : " + act_Popup, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Request_Sent_Popup
					+ " || Actual Report Activity is : " + act_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Request_Sent_Popup
					+ " || Actual Report Activity is : " + act_Popup, test, test1);
		}
		Step_End(6, "Click sent button.", test, test1);
		waitForElement(driver, Mail_Cancel_Btn);
		safeclick(driver, Mail_Cancel_Btn);

		scrollTop(driver);
		waitForElement(driver, DG_no);
		String generated_DG_Number=getAttribute(driver, DG_no,"value");
		System.out.println(" generated_DG_Number : "+ generated_DG_Number);
		
		if(!generated_DG_Number.equals("")) {
			
			System.out.println("Matched || Expected : DG Number should be generated || Actual : Generated DG Number : "+generated_DG_Number);            
			Extent_pass_New(driver, "Matched || Expected : DG Number should be generated || Actual : Generated DG Number : "+generated_DG_Number, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || Expected : DG Number should be generated || Actual : Generated DG Number : "+generated_DG_Number);        
			Extent_fail(driver, "Not Matched || Expected : DG Number should be generated || Actual : Generated DG Number : "+generated_DG_Number, test,test1);
		}
		Step_Start(7, "switch into line agency", test, test1);

		ResetProfile(driver);
		Step_End(7, "switch into line agency", test, test1);
		Step_Start(8, "open the dg gate module.", test, test1);

		moduleNavigate(driver, DG_Gate_Module);

		Step_End(8, "open the dg gate module.", test, test1);

		Step_Start(9, "select the dg created date and click show button", test, test1);

		scrollTop(driver);
		waitForElement(driver, From_Date_Radio_Btn);
		safeclick(driver, From_Date_Radio_Btn);
		waitForElement(driver, FromDate_Field);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, FromDate_Field, From_Date_Input);
		} else {
			waitForElement(driver, FromDate_Field);
			clearAndType(driver, FromDate_Field, From_Date_Input);
		}

		waitForElement(driver, ToDate_Field);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, ToDate_Field, To_Date_Input);
		} else {
			waitForElement(driver, ToDate_Field);
			clearAndType(driver, ToDate_Field, To_Date_Input);
		}
		waitForElement(driver, DG_Gate_ShowBtn);
		safeclick(driver, DG_Gate_ShowBtn);

		Step_End(9, "select the dg created date and click show button", test, test1);

		Step_Start(10, "double the dg row", test, test1);
		String DG_Select=String.format(DG_Gate_Select_DG, generated_DG_Number);
		waitForElement(driver, DG_Select);
		
		waitForElement(driver, DG_Gate_Grid_Filter_Button);
		safeclick(driver, DG_Gate_Grid_Filter_Button);


		waitForElement(driver, DG_No_Filter_DG_Gate);
		sendKeys(driver, DG_No_Filter_DG_Gate, generated_DG_Number);

		
		doubleClick(driver, DG_Select);
		Step_End(10, "double the dg row", test, test1);
		
		Step_Start(11, "DG module will open", test, test1);
		
		
		Step_Start(12, "select the container in tree", test, test1);
		
		
		scrollElementToCenter(driver, Multi_ChkList_Btn);
		waitForElement(driver, Multi_ChkList_Btn);
		safeclick(driver, Multi_ChkList_Btn);
		Step_End(11, "DG module will open", test, test1);

		
		waitForDisplay(driver, popup_Message_Ok_Button);
		if(isdisplayed(driver, popup_Message_Ok_Button)) {
			safeclick(driver, popup_Message_Ok_Button);
		}
		
		Step_End(12, "select the container in tree", test, test1);

		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		
		waitForElement(driver, DG_Check_list_checkbox);
		checkBox(driver, DG_Check_list_checkbox, "Yes");
		Step_Start(13, "click partial accept button\r\n"	+ "", test, test1);

		waitForElement(driver, Partial_Accept);
		click(driver, Partial_Accept);
		
		waitForElement(driver, DG_Partial_accept_Input_Filed);
		sendKeys(driver, DG_Partial_accept_Input_Filed, Remarks);
		
		waitForElement(driver, Rejected_Remarks_Ok_Button);
		click(driver, Rejected_Remarks_Ok_Button);
		
		waitForPopup(driver, popup_Message, Exp_partial_accept_popup);
		String act_Popup1 = getText(driver, popup_Message);
		System.out.println(act_Popup1);
		if (act_Popup1.contains(Exp_partial_accept_popup)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1, test, test1);
		}
		
		Step_End(13, "click partial accept button\r\n"	+ "", test, test1);


		waitForElement(driver, Mail_Cancel_Btn);
		safeclick(driver, Mail_Cancel_Btn);
		
		waitForElement(driver, cargo_Status);
		String Act_Partial_Accept =getText(driver, cargo_Status);
		
		if(Act_Partial_Accept.contains(Partical_Accept)) {
			System.out.println("Matched || Expected: On clicking the Partial Accept button, the system should change the status to 'Partial Accept'. "  + Partical_Accept +  " || Actual: On clicking the Partial Accept button, the system changes the status to 'Partial Accept'.");
			Extent_pass_New(driver, "Matched || Expected: On clicking the Partial Accept button, the system should change the status to 'Partial Accept'. "  + Partical_Accept +  " || Actual: On clicking the Partial Accept button, the system changes the status to 'Partial Accept'.", test, test1);
		}else {
			System.out.println("Not Matched || Expected: On clicking the Partial Accept button, the system should change the status to 'Partial Accept'. "  + Partical_Accept +  " || Actual: On clicking the Partial Accept button, the system Not changes the status to 'Partial Accept'.");
			Extent_fail(driver, "Not Matched || Expected: On clicking the Partial Accept button, the system should change the status to 'Partial Accept'. "  + Partical_Accept +  " || Actual: On clicking the Partial Accept button, the system Not changes the status to 'Partial Accept'.", test, test1);
		}
		Step_Start(14,"Select the container in tree again .", test, test1);

		scrollElementToView(driver, DG_Container_Select);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		
		Step_End(14,"Select the container in tree again .", test, test1);
		Step_Start(15,"system will change the status in grid.", test, test1);

		waitForElement(driver, grid_Row_DG);
		List<Map<String, String>> grid_Values = getTableData(driver, grid_Column_DG, grid_Row_DG);
		List<String> grid_Status = getValuesByHeader(grid_Values, Grid_Column);
		String actual_Grid_Status=grid_Status.get(0);
		if(actual_Grid_Status.equals(Grid_Status_Value)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Grid Staus is : " + actual_Grid_Status + " || Actual Grid Staus is : " + Grid_Status_Value);            
			Extent_pass_New(driver, "Matched || " + " Expected Grid Staus is: " + actual_Grid_Status + " || Actual Grid Staus is : " + Grid_Status_Value, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Grid Staus is : " + actual_Grid_Status + " || Actual Grid Staus is : " + Grid_Status_Value);        
			Extent_fail(driver, "Not Matched || " + " Expected Grid Staus is : " + actual_Grid_Status + " || Actual Grid Staus is : " + Grid_Status_Value, test,test1); 
		}
		Step_End(15,"system will change the status in grid.", test, test1);

		Extent_completed(testCaseName, test, test1);

	}

}
