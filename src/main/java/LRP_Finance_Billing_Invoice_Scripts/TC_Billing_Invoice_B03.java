package LRP_Finance_Billing_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Billing_Invoice_B03 extends Keywords {

	public void  Billing_Invoice_B03(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Billing_Invoice_B03";
		
		




		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("Password");
		String Field_Names =Excel_data.get("Field_Names");
		String Select_search_recurring_billing = Excel_data.get("Select_search_recurring_billing");
		String Condition =Excel_data.get("Condition");
		String Transaction_number =Excel_data.get("Transaction_number");
		String Delete_before_pop =Excel_data.get("Delete_before_pop");
		String Billing_delete_popup =Excel_data.get("Billing_delete_popup");
		String trans_num_colour_exp =Excel_data.get("trans_num_colour_exp");
		
	
	
	Extent_Start(testcase_Name, test, test1);

	navigateUrl(driver, url);
	//Login
	LRP_Login(driver, username, pass_word);
	verifyMainMenu(driver);

	moduleNavigate(driver, Field_Names);
	
	Step_Start(1, "Retreive the record that you going to be delete", test, test1);
	waitForElement(driver, SearchButton_Toolbar);
	click(driver,SearchButton_Toolbar);
	globalValueSearchWindow(driver, Condition, Select_search_recurring_billing, Transaction_number, "", "", "", "");
	Step_End(1, "Retreive the record that you going to be delete", test, test1);
	
	Step_Start(2, "Click delete on toolbar", test, test1);
	waitForElement(driver, Delete_button_toolBar);
	click(driver,Delete_button_toolBar);
	Step_End(2, "Click delete on toolbar", test, test1);
	Step_Start(3, "Now the popup  message should be show  .", test, test1);
	waitForPopup(driver, popup_Message,Delete_before_pop);
	String Actualpopmsgbefore = getText(driver, popup_Message);


	if (Delete_before_pop.equals(Actualpopmsgbefore)) {
		System.out.println("Matched ||Expected : After click on delete button Popup value should be display in the Billing Invoice Screen : " + Delete_before_pop+ " ||Actual : After click on save button Popup value is display in the Billing Invoice Screen : " + Actualpopmsgbefore);
		Extent_pass_New(driver, "Matched || Expected : After click on delete button Popup value should be display in the Billing Invoice Screen : " + Delete_before_pop+ " || Actual : After click on save button Popup value is display in the Billing Invoice Screen : " + Actualpopmsgbefore, test, test1);
		Extent_call(test, test1, Delete_before_pop);
	} else {
		System.out.println("Not matched ||Expected : After click on delete button Popup value should be display in the Billing Invoice Screen :" + Delete_before_pop+ " || Actual : After click on save button Popup value is Not display in the Billing Invoice Screen :" + Actualpopmsgbefore);
		Extent_fail(driver, "Not matched ||Expected : After click on delete button Popup value should be display in the Billing Invoice Screen : " + Delete_before_pop+ " || Actual : After click on save button Popup value is Not display in the Billing Invoice Screen : " + Actualpopmsgbefore, test, test1);

	}
	Step_End(3, "Now the popup  message should be show", test, test1);
	Step_Start(4, "Click yes to delete the transactions.", test, test1);
	waitForElement(driver, popup_Message_Yes_Button);
	click(driver,popup_Message_Yes_Button);
	Step_End(4, "Click yes to delete the transactions.", test, test1);
	Step_Start(5, "Now transaction should be deleted and showing validation like billing invoice deleted ..", test, test1);
	waitForPopup(driver, popup_Message,Billing_delete_popup);
	String Actualpopmsg = getText(driver, popup_Message);
	System.out.println(Actualpopmsg);

	if (Billing_delete_popup.equals(Actualpopmsg)) {
		System.out.println("Matched ||Expected :  Now transaction should be deleted and showing validation like billing invoice deleted " + Billing_delete_popup+ " || Actual  Now transaction is deleted and showing validation like billing invoice deleted : " + Actualpopmsg);
		Extent_pass_New(driver, "Matched || Expected :  Now transaction should be deleted and showing validation like billing invoice deleted" + Billing_delete_popup+ " || ActualNow transaction is deleted and showing validation like billing invoice deleted : " + Actualpopmsg, test, test1);
		Extent_call(test, test1, Actualpopmsg);
	} else {
		System.out.println("Not matched || Expected :  Now transaction should be deleted and showing validation like billing invoice deleted " + Billing_delete_popup+ " || Actual Now transaction is deleted and showing validation like billing invoice Not deleted : " + Actualpopmsg);
		Extent_fail(driver, "Not matched ||Expected :  Now transaction should be deleted and showing validation like billing invoice deleted" + Billing_delete_popup+ "  || Actual Now transaction is deleted and showing validation like billing invoice Not deleted : " + Actualpopmsg, test, test1);

	}
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver,popup_Message_Ok_Button);
	Step_End(5, "Now transaction should be deleted and showing validation like billing invoice deleted ..", test, test1);
	Step_Start(6, "The deleted transaction should be in higlighted as red color.", test, test1);
	waitForElement(driver, trans_number);
	String trans_num_colour = getTextBackgroundColor(driver, trans_number);
	System.out.println(trans_num_colour);
	String Act_Color=getColorName(trans_num_colour);
	if (trans_num_colour_exp.equalsIgnoreCase(Act_Color)) {
		System.out.println("Matched || " + " Expected The deleted transaction should be in higlighted as red color : " + trans_num_colour_exp+ " || Actual The deleted transaction in higlighted as red color : " + Act_Color);
		Extent_pass_New(driver, "Matched || " + " Expected The deleted transaction should be in higlighted as red color : " + trans_num_colour_exp+ " || Actual The deleted transaction in higlighted as red color : " + Act_Color, test, test1);
		Extent_call(test, test1, Actualpopmsg);
	} else {
		System.out.println("Not matched || " + " Expected The deleted transaction should be in higlighted as red color : " + trans_num_colour_exp+ " || Actual The deleted transaction in Not higlighted as red color : " + Act_Color);
		Extent_fail(driver, "Not matched || " + " Expected The deleted transaction should be in higlighted as red color : " + trans_num_colour_exp+ " || Actual The deleted transaction in Not higlighted as red color : " + Act_Color, test, test1);

	}
	Step_End(6, "The deleted transaction should be in higlighted as red color.", test, test1);
	Extent_completed(testcase_Name, test, test1);
	
	
	
}}
