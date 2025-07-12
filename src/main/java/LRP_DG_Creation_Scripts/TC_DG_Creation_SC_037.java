package LRP_DG_Creation_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_037 extends Keywords {

	public void DG_Creation_SC_037(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		// Value are taken from excel sheet
		String testcase_Name = "TC_DG_Creation_SC_037";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");

		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
		String Request_Sent_Popup = Excel_data.get("Request_Sent_Popup");
		String Cargo_Status = Excel_data.get("Cargo_Status");
		String Exp_partial_accept_popup= Excel_data.get("Exp_partial_accept_popup");
		String Remarks_Input= Excel_data.get("Remarks_Input");
		String Details_Checked_Popup= Excel_data.get("Details_Checked_Popup");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String DG_No_Type = Excel_data.get("DG_No_Type");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);
		
		// Login

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, agencyUser);

//		Module Search
		
		moduleNavigate(driver, DG_Creation_Module);
		
		
		newButton(driver);
		
		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);
	
		waitForPopup(driver, popup_Message,Applied_Popup_Exp);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if(Applied_Popup.equals(Applied_Popup_Exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup, test,test1); 
		} 
	

	waitForElement(driver, DG_Save_Btn);
	safeclick(driver, DG_Save_Btn);
	waitForPopup(driver, popup_Message,Details_Saved_Popup);
	String Saved_Popup = getText(driver, popup_Message);
	System.out.println(Applied_Popup);
	if(Saved_Popup.equals(Details_Saved_Popup)) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup, test,test1);     
		safeclick(driver, popup_Message_Ok_Button);
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup, test,test1); 
	}
	waitForElement(driver, Send_Btn);
	safeclick(driver, Send_Btn);
	
	waitForPopup(driver, popup_Message,Request_Sent_Popup);
	String act_Popup = getText(driver, popup_Message);
	System.out.println(act_Popup);
	if(act_Popup.equals(Request_Sent_Popup)) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity is : " + Request_Sent_Popup + " || Actual Report Activity is : " + act_Popup);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Request_Sent_Popup + " || Actual Report Activity is : " + act_Popup, test,test1);     
		safeclick(driver, popup_Message_Ok_Button);
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity is : " + Request_Sent_Popup + " || Actual Report Activity is : " + act_Popup);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Request_Sent_Popup + " || Actual Report Activity is : " + act_Popup, test,test1); 
	}

	
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
	
	ResetProfile(driver);
	
	moduleNavigate(driver, DG_Creation_Module);
	
	
	waitForElement(driver, SearchButton_Toolbar);
	safeclick(driver, SearchButton_Toolbar);
	
	globalValueSearchWindow(driver, GlobalSearch_Condition, DG_No_Type, generated_DG_Number, "", "", "", "");


	scrollBottom(driver);
	
	waitForElement(driver, Multi_ChkList_Btn);
	safeclick(driver, Multi_ChkList_Btn);
	
	waitForPopup(driver, popup_Message,Details_Checked_Popup);
	String act_Details_Checked_Popup = getText(driver, popup_Message);
	System.out.println(act_Details_Checked_Popup);
	if(act_Details_Checked_Popup.equals(Details_Checked_Popup)) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity is : " + Details_Checked_Popup + " || Actual Report Activity is : " + act_Details_Checked_Popup);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Details_Checked_Popup + " || Actual Report Activity is : " + act_Details_Checked_Popup, test,test1);     
		safeclick(driver, popup_Message_Ok_Button);
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity is : " + Details_Checked_Popup + " || Actual Report Activity is : " + act_Details_Checked_Popup);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Details_Checked_Popup + " || Actual Report Activity is : " + act_Details_Checked_Popup, test,test1); 
	}
	scrollElementToView(driver, DG_Container_Select);
	waitForElement(driver, DG_Container_Select);
	safeclick(driver, DG_Container_Select);
	
	waitForElement(driver, Partial_Accept);
	click(driver, Partial_Accept);
	
	waitForElement(driver, DG_Partial_accept_Input_Filed);
	sendKeys(driver, DG_Partial_accept_Input_Filed, Remarks_Input);
	
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

	
	waitForElement(driver, Mail_Cancel_Btn);
	safeclick(driver, Mail_Cancel_Btn);
	
	waitForElement(driver, cargo_Status);
	String actualCargoStatus=getText(driver, cargo_Status);
	System.out.println(" actualCargoStatus : "+ actualCargoStatus);

	if(actualCargoStatus.equals(Cargo_Status)) {                                                                                                                  
		System.out.println("Matched || " + " Expected Cargo status is : " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus);            
		Extent_pass_New(driver, "Matched || " + " Expected Cargo status is: " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus, test,test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Cargo status is : " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus);        
		Extent_fail(driver, "Not Matched || " + " Expected Cargo status is : " + Cargo_Status + " || Actual Cargo status is : " + actualCargoStatus, test,test1);
	}

}}


