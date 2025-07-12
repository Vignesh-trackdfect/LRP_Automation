package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_098  extends Keywords {
	public void DG_Creation_SC_098(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_DG_Creation_SC_098";
		
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
		String Request_Sent_Popup = Excel_data.get("Request_Sent_Popup");
		String Remarks = Excel_data.get("Remarks_Input");
		String DG_No_Type = Excel_data.get("DG_No_Type");
		String Details_Checked_Popup = Excel_data.get("Details_Checked_Popup");
		String Exp_partial_accept_popup = Excel_data.get("Exp_partial_accept_popup");
		String NumberOfChar = Excel_data.get("NumberOfChar");

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
		
		
		Step_Start(7, "switch into line agenc", test, test1);

		ResetProfile(driver);
		Step_End(7, "switch into line agenc", test, test1);
		Step_Start(8, "click multichecklist", test, test1);
		
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
        Step_Start(9, "Click Approve button.", test, test1);
		
		waitForElement(driver, DG_Accept_button);
		safeclick(driver, DG_Accept_button);
		
		waitForElement(driver, DG_Accept_Remark_Input);
		sendKeys(driver, DG_Accept_Remark_Input, Remarks);
		
		waitForElement(driver, Rejected_Remarks_Ok_Button);
		click(driver, Rejected_Remarks_Ok_Button);
		
		waitForPopup(driver, popup_Message, Exp_partial_accept_popup);
		String act_Popup1 = getText(driver, popup_Message);
		System.out.println(act_Popup1);
		if (act_Popup1.contains(Exp_partial_accept_popup)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1, test, test1);
			safeclick(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Exp_partial_accept_popup
					+ " || Actual Report Activity is : " + act_Popup1, test, test1);
		}
			
		
		waitForElement(driver, Mail_Cancel_Btn);
		safeclick(driver, Mail_Cancel_Btn);
		
		
		waitForElement(driver, DG_Accepted_Remarks_Input);	
		String Act_Accepted =getText(driver, DG_Accepted_Remarks_Input);
		
		int actualLength=Act_Accepted.length();
		int NumberOfCharacters=Integer.parseInt(NumberOfChar);
		
		if(actualLength<=NumberOfCharacters) {
			System.out.println("Matched || Expected No of characters : "+NumberOfCharacters +" || Actual : No of characters : "+actualLength);
			Extent_pass_New(driver, "Matched || Expected No of characters : "+NumberOfCharacters +" || Actual : No of characters : "+actualLength, test, test1);
		}else {
			System.out.println("Not Matched || Expected No of characters : "+NumberOfCharacters +" || Actual : No of characters : "+actualLength);
			Extent_fail(driver, "Not Matched || Expected No of characters : "+NumberOfCharacters +" || Actual : No of characters : "+actualLength, test, test1);
		}
		
	       Step_End(9, "Click Approve button.", test, test1);
		
	   	Extent_completed(testCaseName, test, test1);
		
		
		

}
}