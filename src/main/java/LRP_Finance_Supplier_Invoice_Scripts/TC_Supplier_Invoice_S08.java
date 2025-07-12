package LRP_Finance_Supplier_Invoice_Scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Supplier_Invoice_S08 extends Keywords{
	public void  Supplier_Invoice_S08(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Supplier_Invoice_S08";
		

		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("Password");
		String Field_Names =Excel_data.get("Field_Names");
		String Select_search_recurring_billing = Excel_data.get("Select_search_recurring_billing");
		String Condition =Excel_data.get("Condition");
		String Transaction_number =Excel_data.get("Transaction_number");
		String type =Excel_data.get("type");
		String status =Excel_data.get("status");
		
	
	Extent_Start(testcase_Name, test, test1);

	navigateUrl(driver, url);
	//Login
	LRP_Login(driver, username, pass_word);
	
	moduleNavigate(driver, Field_Names);
	
	Step_Start(1, "Click on global search icon in toolbar.", test, test1);
	
	waitForElement(driver, SearchButton_Toolbar);
	click(driver,SearchButton_Toolbar);
	
	Step_End(1, "Click on global search icon in toolbar.", test, test1);
	Step_Start(2, "Now search transaction should be displayed .", test, test1);
	
	waitForElement(driver, type_Select1);
	click(driver,type_Select1);
	Step_End(2, "Now search transaction should be displayed .", test, test1);
	Step_Start(3, "Search Using the below categories"+ "  trans number , document type ,document status ", test, test1);
	selectByText(driver, type_Select1, Select_search_recurring_billing);
	click(driver, globalSearch_Condition_Dropdown1);
	selectByText(driver, globalSearch_Condition_Dropdown1, Condition);
	sendKeys(driver, globalSearch_InputTextfield1,Transaction_number);
	
	waitForElement(driver, global_search_11);
	String search1 = selectedValue(driver, global_search_11);
	System.out.println(search1);


	waitForElement(driver, global_search_2);
	String search2 = selectedValue(driver, global_search_2);
	System.out.println(search2);

	
	waitForElement(driver, global_search_3);
	String search3 = selectedValue(driver, global_search_3);
	System.out.println(search3);
	
	
	if (Select_search_recurring_billing.equals(search1)) {
		System.out.println("Matched || " + " Expected search coloum 1   should be display in the Suplier invoice Screen : " + Select_search_recurring_billing+ " || Actual search coloum 1 Dispaly in the Suplier invoice Screen : " + search1);
		Extent_pass_New(driver, "Matched || " + " Expected search coloum 1  should be display in the Suplier invoice Screen : " + Select_search_recurring_billing+ " || Actual search coloum 1 Dispaly in the Suplier invoice Screen : " + search1, test, test1);
	
	} else {
		System.out.println("Not matched || " + " Expected search coloum 1  should be display in the Suplier invoice Screen: " + Select_search_recurring_billing+ " || Actual search coloum 1 Dispaly in the Suplier invoice Screen : " + search1);
		Extent_fail(driver, "Not matched || " + " Expected search coloum 1 should be display in the Suplier invoice Screen : " + Select_search_recurring_billing+ " || Actual search coloum 1 Dispaly in the Suplier invoice Screen : " + search1, test, test1);

	}

	if (type.equals(search2)) {
		System.out.println("Matched || " + " Expected search coloum 2 should be display in the Suplier invoice Screen : " + type+ " || Actual search coloum 2 Dispaly in the Suplier invoice Screen : " + search2);
		Extent_pass_New(driver, "Matched || " + " Expected search coloum 2 should be display in the Suplier invoice Screen : " + type+ " || Actual search coloum 2 Dispaly in the Suplier invoice Screen : " + search2, test, test1);
	
	} else {
		System.out.println("Not matched || " + " Expected search coloum 2 should be display in the Suplier invoice Screen : " + type+ " || Actual search coloum 2 Dispaly in the Suplier invoice Screen : " + search2);
		Extent_fail(driver, "Not matched || " + " Expected search coloum 2 should be display in the Suplier invoice Screen : " + type+ " || Actual search coloum 2 Dispaly in the Suplier invoice Screen : " + search1, test, test1);

	}
	
	
	
	if (status.equals(search3)) {
		System.out.println("Matched || " + " Expected search coloum 3 should be display in the Suplier invoice Screen  : " + status+ " || Actual search coloum 3 Dispaly in the Suplier invoice Screen : " + search3);
		Extent_pass_New(driver, "Matched || " + " Expected search coloum 3 should be display in the Suplier invoice Screen : " + status+ " || Actual search coloum 3 Dispaly in the Suplier invoice Screen : " + search3, test, test1);
	
	} else {
		System.out.println("Not matched || " + " Expected search coloum 3 should be display in the Suplier invoice Screen : " + status+ " || Actual search coloum 3 Dispaly in the Suplier invoice Screen : " + search3);
		Extent_fail(driver, "Not matched || " + " Expected search coloum 3 should be display in the Suplier invoice Screen : " + status+ " || Actual search coloum 3 Dispaly in the Suplier invoice Screen : " + search3, test, test1);

	}
	
	
	waitForElement(driver, global_search_list);
	String searchlist= getText(driver, global_search_list);
	System.out.println(searchlist);
	List<String> reasons=new ArrayList<String>();
	List<String> list = Arrays.asList(searchlist.split(" "));

    // Print each item in the List
    for (String word : list) {
        System.out.println(word);
        reasons.add(word);
        
    }
	Extent_call(test, test1, "*********In Global search this are the list were present for retriving the records*********"+reasons);
	Step_End(3, "Search Using the below categories"+ "  trans number , document type ,document status ", test, test1);
	
	click(driver, globalSearch_Frame_SearchButton);
	
	Step_Start(4, "Now selected transaction should be displayed in grid .", test, test1);
	waitForElement(driver, package_search_input_select);
	String searchvalue = getText(driver, package_search_input_select);
	System.out.println(searchvalue);
	Extent_call(test, test1, "***In gird search value shown as *****"+searchvalue);
	Step_End(4, "Now selected transaction should be displayed in grid .", test, test1);
	Step_Start(5, "Click on that transaction able to view it", test, test1);
	click(driver, package_search_input_select);
	
	waitForElement(driver, SelectButton);
	click(driver, SelectButton);
	
	waitForElement(driver, supplier_trans_number);
	String trans_num = getAttribute(driver, supplier_trans_number,"value");
	System.out.println(trans_num);
	
	if (Transaction_number.equals(searchvalue)&& Transaction_number.equals(trans_num)) {
		System.out.println("Matched || " + " Expected search number should be display in the Suplier invoice Screen : " + Transaction_number+ " || Actual search number is Dispaly in the Suplier invoice Screen: " + searchvalue+"**after search select inside shown as****"+trans_num);
		Extent_pass_New(driver, "Matched || " + " Expected search number should be display in the Suplier invoice Screen : " + Transaction_number+ " || Actual search number is : " + searchvalue+"**after search select inside shown as****"+trans_num, test, test1);
		Extent_call(test, test1, "Record was retrived correctly using global search");
	} else {
		System.out.println("Not matched || " + " Expected search number number should be display in the Suplier invoice Screen : " + Transaction_number+ " || Actual search number is Dispaly in the Suplier invoice Screen : " + searchvalue+"**after search select inside shown as****"+trans_num);
		Extent_fail(driver, "Not matched || " + " Expected search number number should be display in the Suplier invoice Screen : " + Transaction_number+ " || Actual search number is Dispaly in the Suplier invoice Screen : " + searchvalue+"**after search select inside shown as****"+trans_num, test, test1);

	}
	Step_End(5, "Click on that transaction able to view it", test, test1);
	Extent_completed(testcase_Name, test, test1);
	


}
}
