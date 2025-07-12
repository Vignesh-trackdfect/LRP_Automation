package LRP_Finance_Billing_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Billing_Invoice_B06 extends Keywords{
	public void  Billing_Invoice_B06(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

	String testcase_Name="TC_Billing_Invoice_B06";


	String username = Excel_data.get("Username");
	String pass_word =Excel_data.get("Password");
	String Field_Names =Excel_data.get("Field_Names");
	String Select_search_recurring_billing = Excel_data.get("Select_search_recurring_billing");
	String Condition =Excel_data.get("Condition");
	String Transaction_number =Excel_data.get("Transaction_number");
	String Billing_delete_popup =Excel_data.get("Billing_updated_popup");
	String trans_num_colour_exp =Excel_data.get("trans_num_colour_exp");
		
	Extent_Start(testcase_Name, test, test1);

	navigateUrl(driver, url);
	//Login
	LRP_Login(driver, username, pass_word);
	verifyMainMenu(driver);

	moduleNavigate(driver, Field_Names);
	Step_Start(1, "Retreive the draft transaction that you going to be confirm", test, test1);
	waitForElement(driver, SearchButton_Toolbar);
	click(driver,SearchButton_Toolbar);
	
	globalValueSearchWindow(driver, Condition, Select_search_recurring_billing, Transaction_number, "", "", "", "");
	Step_End(1, "Retreive the draft transaction that you going to be confirm", test, test1);
	
	Step_Start(2, "Click edit on toolbar.", test, test1);
	waitForElement(driver, Edit_Button_toolBar);
	click(driver,Edit_Button_toolBar);
	Step_End(2, "Click edit on toolbar.", test, test1);
	
	Step_Start(3, " Click confirm button.", test, test1);
	waitForElement(driver, billing_conform);
	click(driver,billing_conform);
	Step_End(3, " Click confirm button.", test, test1);
	Step_Start(4, "Click save on toolbar.", test, test1);
	waitForElement(driver, SaveButton_ToolBar);
	click(driver,SaveButton_ToolBar);
	Step_End(4, "Click save on toolbar.", test, test1);
	Step_Start(5, "Now transaction status changed from draft to confirm.", test, test1);
	
	waitForPopup(driver, popup_Message,Billing_delete_popup);
	String Actualpopmsg = getText(driver, popup_Message);
	
	if (Billing_delete_popup.equals(Actualpopmsg)) {
		System.out.println("Matched || Expected : After click on save button Popup value should be display in the Billing Invoice Screen : " + Billing_delete_popup+ " || Actual : After click on save button Popup value is display in the Billing Invoice Screen :" + Actualpopmsg);
		Extent_pass_New(driver, "Matched || Expected : After click on save button Popup value should be display in the Billing Invoice Screen :" + Billing_delete_popup+ " || Actual : After click on save button Popup value is display in the Billing Invoice Screen :" + Actualpopmsg, test, test1);
		Extent_call(test, test1, Actualpopmsg);
	} else {
		System.out.println("Not matched || Expected : After click on save button Popup value should be display in the Billing Invoice Screen : " + Billing_delete_popup+ " || Actual : After click on save button Popup value is Not display in the Billing Invoice Screen : " + Actualpopmsg);
		Extent_fail(driver, "Not matched ||Expected : After click on save button Popup value should be display in the Billing Invoice Screen :" + Billing_delete_popup+ " || Actual : After click on save button Popup value is Not display in the Billing Invoice Screen : " + Actualpopmsg, test, test1);

	}
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver,popup_Message_Ok_Button);
	Step_End(5, "Now transaction status changed from draft to confirm.", test, test1);

	Step_Start(6, " Confirm transaction should be displayed as  green color in trans number field", test, test1);
	waitForElement(driver, trans_number);
	String trans_num_colour = getTextBackgroundColor(driver, trans_number);

	String Act_Color=getColorName(trans_num_colour);
	
	if (trans_num_colour_exp.equalsIgnoreCase(Act_Color)) {
		System.out.println("Matched ||Expected  : Confirm transaction should be displayed as  green color in trans number field : " + trans_num_colour_exp+ " || Actual Confirm transaction is  displayed as  green color in trans number field : " + Act_Color);
		Extent_pass_New(driver, "Matched || Confirm transaction should be displayed as  green color in trans number field " + trans_num_colour_exp+ " || Actual Confirm transaction is  displayed as  green color in trans number field : " + Act_Color, test, test1);
		Extent_call(test, test1, Actualpopmsg);
	} else {
		System.out.println("Not matched || Confirm transaction should be displayed as  green color in trans number field " + trans_num_colour_exp+ " || Actual Confirm transaction is Not displayed as  green color in trans number field: " + Act_Color);
		Extent_fail(driver, "Not matched ||Confirm transaction should be displayed as  green color in trans number field " + trans_num_colour_exp+ " || Actual Confirm transaction is Not displayed as  green color in trans number field : " + Act_Color, test, test1);
	}
	
	Step_End(6, " Confirm transaction should be displayed as  green color in trans number field", test, test1);
	Extent_completed(testcase_Name, test, test1);
	
	
	
}}

