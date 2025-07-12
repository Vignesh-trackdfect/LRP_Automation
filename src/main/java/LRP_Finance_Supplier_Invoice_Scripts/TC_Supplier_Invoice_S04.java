package LRP_Finance_Supplier_Invoice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Supplier_Invoice_S04  extends Keywords{
	
	public void  Supplier_Invoice_S04(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Supplier_Invoice_S04";
		
		




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

	//Login
	navigateUrl(driver, url);                                                                                                  
	LRP_Login(driver, username, pass_word);


	moduleNavigate(driver, Field_Names);
	Step_Start(1, "Retreive the record that you going to be delete", test, test1);
	
	waitForElement(driver, SearchButton_Toolbar);
	click(driver,SearchButton_Toolbar);
	
	globalValueSearchWindow(driver, Condition, Select_search_recurring_billing, Transaction_number, "","", "", "");

	Step_End(1, "Retreive the record that you going to be delete", test, test1);
	
	Step_Start(2, "Click delete on toolbar", test, test1);
	
	waitForElement(driver, Delete_button_toolBar);
	click(driver,Delete_button_toolBar);
	
	Step_End(2, "Click delete on toolbar", test, test1);
	Step_Start(3, "Now the popup  message should be show  .", test, test1);
	

	waitForPopup(driver, popup_Message,Delete_before_pop);
	
	String Actualpopmsgbefore = getText(driver, popup_Message);
	System.out.println(Actualpopmsgbefore);

	if (Delete_before_pop.equals(Actualpopmsgbefore)) {
		System.out.println("Matched || " + " Expected popup  value should be display in the Suplier invoice Screen : " + Delete_before_pop+ " || Actual popup Dispaly in the Suplier invoice Screen: " + Actualpopmsgbefore);
		Extent_pass_New(driver, "Matched || " + " Expected popup  value should be display in the Suplier invoice Screen: " + Delete_before_pop+ " ||Actual popup Dispaly in the Suplier invoice Screen : " + Actualpopmsgbefore, test, test1);
		Extent_call(test, test1, Delete_before_pop);
	} else {
		System.out.println("Not matched || " + " Expected popup  value should be display in the Suplier invoice Screen: " + Delete_before_pop+ " || Actual popup Dispaly in the Suplier invoice Screen: " + Actualpopmsgbefore);
		Extent_fail(driver, "Not matched || " + "Expected popup  value should be display in the Suplier invoice Screen : " + Delete_before_pop+ " || Actual popup Dispaly in the Suplier invoice Screen : " + Actualpopmsgbefore, test, test1);

	}
	Step_End(3, "Now the popup  message should be show", test, test1);
	Step_Start(4, "Click yes to delete the transactions.", test, test1);
	
	waitForElement(driver, popup_Message_Yes_Button);
	click(driver,popup_Message_Yes_Button);
	
	Step_End(4, "Click yes to delete the transactions.", test, test1);
	Step_Start(5, "Now transaction should be deleted and showing validation like  supplier invoice deleted ..", test, test1);
	

	waitForPopup(driver, popup_Message,Billing_delete_popup);
	String Actualpopmsg = getText(driver, popup_Message);
	System.out.println(Actualpopmsg);

	if (Billing_delete_popup.equals(Actualpopmsg)) {
		System.out.println("Matched || " + " Expected popup  value should be display in the Suplier invoice Screen: : " + Billing_delete_popup+ " || Actual popup value Dispaly in the Suplier invoice Screen  : " + Actualpopmsg);
		Extent_pass_New(driver, "Matched || " + " Expected popup  value should be display in the Suplier invoice Screen: : " + Billing_delete_popup+ " ||Actual popup value Dispaly in the Suplier invoice Screen : " + Actualpopmsg, test, test1);
		Extent_call(test, test1, Actualpopmsg);
	} else {
		System.out.println("Not matched || " + " Expected popup value should be: " + Billing_delete_popup+ " || Actual popup value not Dispaly in the Suplier invoice Screen: " + Actualpopmsg);
		Extent_fail(driver, "Not matched || " + " Expected popup value should be : " + Billing_delete_popup+ " || Actual popup value not Dispaly in the Suplier invoice Screen : " + Actualpopmsg, test, test1);

	}
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver,popup_Message_Ok_Button);
	Step_End(5, "Now transaction should be deleted and showing validation like  supplier invoice deleted . ..", test, test1);
	Step_Start(6, "The deleted transaction should be in higlighted as red color.", test, test1);
	waitForElement(driver, supplier_trans_number);
	

	String trans_num_colour1 = getTextBackgroundColor(driver, supplier_trans_number);
	String trans_num_colour=getColorName(trans_num_colour1);
	
	if(trans_num_colour_exp.equals(trans_num_colour)) {                                                                                                                  
		System.out.println("Matched || " + " Expected : Once  deleted transaction should be in higlighted as red color : " + trans_num_colour_exp + " || Actual : Once  deleted transaction is higlighted as red color : " + trans_num_colour);            
		Extent_pass_New(driver, "Matched || " + " Expected : Once  deleted transaction should be in higlighted as red color  : " + trans_num_colour_exp + " || Actual :Once  deleted transaction is higlighted as red color : " + trans_num_colour, test, test1);     
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected : Once  deleted transaction should be in higlighted as red color : " + trans_num_colour_exp + " || Actual : Once deleted transaction is not higlighted as red color: " + trans_num_colour);        
		Extent_fail(driver, "Not Matched || " + " Expected : Once  deleted transaction should be in higlighted as red color : " + trans_num_colour_exp + " || Actual :Once deleted transaction is not higlighted as red color " + trans_num_colour, test, test1); 
	} 
	
	Step_End(6, "The deleted transaction should be in higlighted as red color.", test, test1);
	Extent_completed(testcase_Name, test, test1);
	
	
}}
