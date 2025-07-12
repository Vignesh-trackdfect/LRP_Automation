package LRP_DG_Creation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_066 extends Keywords{
	

	public void DG_Creation_SC_066(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_066";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
		String Request_Sent_Popup = Excel_data.get("Request_Sent_Popup");
		String Remarks_Input = Excel_data.get("Remarks_Input");
		String DG_No_Type = Excel_data.get("DG_No_Type");
		String Details_Checked_Popup = Excel_data.get("Details_Checked_Popup");
		String Status_In_Mail = Excel_data.get("Status_In_Mail");
		String Cargo_Status = Excel_data.get("Cargo_Status");
		String Grid_Column = Excel_data.get("Grid_Column");
		String Grid_Status_Value = Excel_data.get("Grid_Status_Value");
		String Expected_Partial_accept_Status = Excel_data.get("Expected_Partial_accept_Status");
		
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		SwitchProfile(driver, AgencyUser);

		moduleNavigate(driver, DG_Creation_Module);

		newButton(driver);

		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_Start(4, "click multi apply  button", test, test1);
		scrollElementToView(driver, Multi_Apply_Btn);
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
		scrollElementToView(driver, DG_Container_Select);

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
		
		waitForElement(driver, cargo_Status);
		String actualCargoStatus=getText(driver, cargo_Status);
		System.out.println(" actualCargoStatus : "+ actualCargoStatus);
		
		
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
		
		
		Step_Start(7,"switch into line agency .", test, test1);

		ResetProfile(driver);
		
		Step_End(7,"switch into line agency .", test, test1);
		Step_Start(8,"click multichecklist", test, test1);
		
		moduleNavigate(driver, DG_Creation_Module);
		
		scrollTop(driver);
		
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, GlobalSearch_Condition, DG_No_Type, generated_DG_Number, "", "", "", "");
		
		scrollBottom(driver);
		
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);

		waitForElement(driver, Multi_ChkList_Btn);
		safeclick(driver, Multi_ChkList_Btn);
		
		waitForPopup(driver, popup_Message,Details_Checked_Popup);
		String actual_Popup = getText(driver, popup_Message);
		System.out.println(actual_Popup);
		if(Details_Checked_Popup.equals(actual_Popup)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Popup is : " + Details_Checked_Popup + " || Actual Popup is : " + actual_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + Details_Checked_Popup + " || Actual Popup is : " + actual_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Popup is : " + Details_Checked_Popup + " || Actual Popup is : " + actual_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Details_Checked_Popup + " || Actual Popup is : " + actual_Popup, test,test1); 
		}
		
		Step_End(8,"click multichecklist", test, test1);
		
		Step_Start(9,"Click partial Accept button", test, test1);

		waitForElement(driver, Partial_Accept);
		safeclick(driver, Partial_Accept);
		
		Step_End(9,"Click partial Reject button.", test, test1);

		waitForElement(driver,Remarks_Area);
		sendKeys(driver, Remarks_Area, Remarks_Input);
		waitForElement(driver, Remarks_Ok);
		safeclick(driver, Remarks_Ok);
		waitForPopup(driver, popup_Message,Expected_Partial_accept_Status);
		String Act_Popup = getText(driver, popup_Message);
	
		if(Act_Popup.equals(Expected_Partial_accept_Status)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Popup is : " + Expected_Partial_accept_Status + " || Actual Popup is : " + Act_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + Expected_Partial_accept_Status + " || Actual Popup is : " + Act_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Popup is : " + Expected_Partial_accept_Status + " || Actual Popup is : " + Act_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Expected_Partial_accept_Status + " || Actual Popup is : " + Act_Popup, test,test1); 
		}
		
		//Mail window
		
				waitForElement(driver, mail_Window_Subject_Textfield);
				String actualMailSubject=getAttribute(driver, mail_Window_Subject_Textfield,"value");
				System.out.println(" actualMailSubject : "+ actualMailSubject);

				if(actualMailSubject.contains(Status_In_Mail)) {                                                                                                                  
					System.out.println("Matched || " + " Expected Subject in mail window is : " + Status_In_Mail + " || Actual Subject in mail window is : " + actualMailSubject);            
					Extent_pass_New(driver, "Matched || " + " Expected Subject in mail window is: " + Status_In_Mail + " || Actual Subject in mail window is : " + actualMailSubject, test,test1);     
				}                                                                                                                                                                        
				else {                                                                                                                                                                   
					System.out.println("Not Matched || " + " Expected Subject in mail window is : " + Status_In_Mail + " || Actual Subject in mail window is : " + actualMailSubject);        
					Extent_fail(driver, "Not Matched || " + " Expected Subject in mail window is : " + Status_In_Mail + " || Actual Subject in mail window is : " + actualMailSubject, test,test1); 
				}
				
				
		waitForElement(driver, Mail_Cancel_Btn);
		safeclick(driver, Mail_Cancel_Btn);
		
		waitForElement(driver, cargo_Status);
		actualCargoStatus=getText(driver, cargo_Status);
		

		if(actualCargoStatus.contains(Cargo_Status)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Cargo status is : " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus);            
			Extent_pass_New(driver, "Matched || " + " Expected Cargo status is: " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Cargo status is : " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus);        
			Extent_fail(driver, "Not Matched || " + " Expected Cargo status is : " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus, test,test1); 
		}
		
		scrollElementToView(driver, DG_Container_Select);

		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);

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
		Extent_completed(testCaseName, test, test1);		
		
		

}
}