package LRP_DG_Creation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_065 extends Keywords{

	public void DG_Creation_SC_065(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data, String url) throws Exception {

	String testCaseName = "TC_DG_Creation_SC_065";
	
	String username = Excel_data.get("Username");
	String pass_word = Excel_data.get("Password");
	String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
	String AgencyUser = Excel_data.get("AgencyUser");
	String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
	String DG_No_Type = Excel_data.get("DG_No_Type");
	String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
	String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
	String Request_Sent_Popup = Excel_data.get("Request_Sent_Popup");
	String Remarks = Excel_data.get("Remarks");
	String Expected_Pending_Status = Excel_data.get("Expected_Pending_Status");
	
	
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
	Step_Start(8, "click multichecklist", test, test1);
	
	moduleNavigate(driver, DG_Creation_Module);
	
	scrollTop(driver);
	
	waitForElement(driver, SearchButton_Toolbar);
	safeclick(driver, SearchButton_Toolbar);
	
	globalValueSearchWindow(driver, GlobalSearch_Condition, DG_No_Type, generated_DG_Number, "", "", "", "");
	
	scrollBottom(driver);
	
	waitForElement(driver, Multi_ChkList_Btn);
	safeclick(driver, Multi_ChkList_Btn);
	
	waitForDisplay(driver, popup_Message_Ok_Button);
	if(isdisplayed(driver, popup_Message_Ok_Button)) {
		safeclick(driver, popup_Message_Ok_Button);
	}
	Step_End(8, "click multichecklist", test, test1);
	
	Step_Start(9, "Click pending button.", test, test1);	
	
	waitForElement(driver, DG_Pending_Button);
	safeclick(driver, DG_Pending_Button);
	
	
	waitForElement(driver, DG_Pending_Remarks);
	sendKeys(driver, DG_Pending_Remarks, Remarks);
	
	waitForElement(driver, Rejected_Remarks_Ok_Button);
	click(driver, Rejected_Remarks_Ok_Button);
	
	waitForPopup(driver, popup_Message, Expected_Pending_Status);
	String act_Popup1 = getText(driver, popup_Message);
	System.out.println(act_Popup1);
	if (act_Popup1.contains(Expected_Pending_Status)) {
		System.out.println("Matched || " + " Expected Report Activity is : " + Expected_Pending_Status+ " || Actual Report Activity is : " + act_Popup1);
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Expected_Pending_Status+ " || Actual Report Activity is : " + act_Popup1, test, test1);
		safeclick(driver, popup_Message_Ok_Button);
	} else {
		System.out.println("Not Matched || " + " Expected Report Activity is : " + Expected_Pending_Status+ " || Actual Report Activity is : " + act_Popup1);
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Expected_Pending_Status+ " || Actual Report Activity is : " + act_Popup1, test, test1);
	}
	
	
	if(isdisplayed(driver, DG_Mail_Screen)) {
		  System.out.println("Not Matched || Expected: Upon clicking the  Pending button, the system should enable the mail window || Actual: Upon clicking the  Pending button, the system enables the mail window.");
		  Extent_pass_New(driver, "Not Matched || Expected: Upon clicking the  Pending button, the system should enable the mail window || Actual: Upon clicking the  Pending button, the system enables the mail window.", test, test1);
		}
	else {
		  System.out.println("Not Matched || Expected: Upon clicking the  Pending button, the system should enable the mail window || Actual: Upon clicking the  Pending button, the system Not enables the mail window.");
		  Extent_fail(driver, "Not Matched || Expected: Upon clicking the  Pending button, the system should enable the mail window || Actual: Upon clicking the  Pending button, the system Not enables the mail window.", test, test1);
	}
	Step_End(9, "Click Approve button.", test, test1);
	
	
	Extent_completed(testCaseName, test, test1);		
	
}
}