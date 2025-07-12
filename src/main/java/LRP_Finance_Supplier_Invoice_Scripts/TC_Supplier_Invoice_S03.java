package LRP_Finance_Supplier_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Supplier_Invoice_S03 extends Keywords{
	public void  Supplier_Invoice_S03(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Supplier_Invoice_S03";
		

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
	LRP_Login(driver, username, pass_word);
	

	moduleNavigate(driver, Field_Names);
	
	Step_Start(1, "Retreive the draft transaction that you going to be confirm", test, test1);
	
	waitForElement(driver, SearchButton_Toolbar);
	click(driver,SearchButton_Toolbar);
	
	
	globalValueSearchWindow(driver, Condition, Select_search_recurring_billing, Transaction_number, "","", "", "");
	
	Step_End(1, "Retreive the draft transaction that you going to be confirm", test, test1);

	
	Step_Start(2, " Click edit on toolbar. ", test, test1);
	
	waitForElement(driver, Edit_Button_toolBar);
	click(driver,Edit_Button_toolBar);
	
	Step_End(2, " Click edit on toolbar.", test, test1);
	Step_Start(3, "Click confirm button.", test, test1);
	
	waitForElement(driver, supplier_conform);
	click(driver,supplier_conform);
	
	Step_End(3, "Click confirm button.", test, test1);
	Step_Start(4, "Click save on toolbar. ", test, test1);
	
	waitForElement(driver, SaveButton_ToolBar);
	click(driver,SaveButton_ToolBar);
	
	Step_End(4, "Click save on toolbar. ", test, test1);
	waitForDisplay(driver, popup_Message_Yes_Button);
	if(isdisplayed(driver, popup_Message_Yes_Button)) {
		click(driver, popup_Message_Yes_Button);
	}
	
	Step_End(4, "Click save on toolbar.", test, test1);
	Step_Start(5, "Now transaction status changed from draft to confirm.", test, test1);
	
	
	waitForPopup(driver, popup_Message,Billing_delete_popup);
	String Actualpopmsg = getText(driver, popup_Message);
	System.out.println(Actualpopmsg);

	if (Billing_delete_popup.equals(Actualpopmsg)) {
		System.out.println("Matched || " + " Expected popup  value should be display in the Suplier invoice Screen : " + Billing_delete_popup+ " || Actual popup Dispaly in the Suplier invoice Screen : " + Actualpopmsg);
		Extent_pass_New(driver, "Matched || " + " Expected popup  value should be display in the Suplier invoice Screen  : " + Billing_delete_popup+ " || Actual popup Dispaly in the Suplier invoice Screen : " + Actualpopmsg, test, test1);
		Extent_call(test, test1, Actualpopmsg);
	} else {
		System.out.println("Not matched || " + " Expected popup  value should be display in the Suplier invoice Screen : " + Billing_delete_popup+ " ||Actual popup Dispaly in the Suplier invoice Screen : " + Actualpopmsg);
		Extent_fail(driver, "Not matched || " + " Expected popup  value should be display in the Suplier invoice Screen  : " + Billing_delete_popup+ " || Actual popup Dispaly in the Suplier invoice Screen : " + Actualpopmsg, test, test1);

	}
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver,popup_Message_Ok_Button);
	Step_End(5, "Now transaction status changed from draft to confirm.", test, test1);

	Step_Start(6, " Confirm transaction should be displayed as  green color in trans number field", test, test1);


	waitForElement(driver, supplier_trans_number);
	String draft_bookingColorCode = getTextBackgroundColor(driver, supplier_trans_number);
	String draft_bookingColor=getColorName(draft_bookingColorCode);
	
	if(draft_bookingColor.equals(trans_num_colour_exp)) {                                                                                                                  
		System.out.println("Matched || " + " Expected : Once , Confirm transaction should be displayed as  green color in trans number field : " + trans_num_colour_exp + " || Actual Once , Confirm transaction is displayed as  green color in trans number field " + draft_bookingColor);            
		Extent_pass_New(driver, "Matched || " + " Expected : Once , Confirm transaction should be displayed as  green color in trans number field : " + trans_num_colour_exp + " || Actual Once , Confirm transaction is displayed as  green color in trans number field" + draft_bookingColor, test, test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected : Once , Confirm transaction should be displayed as  green color in trans number field : " + trans_num_colour_exp + " || Actual Once , Confirm transaction is not displayed as  green color in trans number field: " + draft_bookingColor);        
		Extent_fail(driver, "Not Matched || " + " Expected : Once , Confirm transaction should be displayed as  green color in trans number field : " + trans_num_colour_exp + " || Actual Once , Confirm transaction is not displayed as  green color in trans number field : " + draft_bookingColor, test, test1); 
	} 
	
	
	Step_End(6, " Confirm transaction should be displayed as  green color in trans number field", test, test1);
	Extent_completed(testcase_Name, test, test1);
	
	
}}


