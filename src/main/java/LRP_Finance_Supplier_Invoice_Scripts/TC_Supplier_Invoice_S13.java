package LRP_Finance_Supplier_Invoice_Scripts;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Supplier_Invoice_S13 extends Keywords{
	public void  Supplier_Invoice_S13(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Supplier_Invoice_S13";

		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("Password");
		String Field_Names =Excel_data.get("Field_Names");
		String Select_search_recurring_billing = Excel_data.get("Select_search_recurring_billing");
		String Condition =Excel_data.get("Condition");
		String Transaction_number =Excel_data.get("Transaction_number");


		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, username, pass_word);

		moduleNavigate(driver, Field_Names);
		Step_Start(1, "Click on global search", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		
		Step_End(1, "Click on global search", test, test1);
		Step_Start(2, "Select any transaction", test, test1);
		globalValueSearchWindow1(driver,Condition,Select_search_recurring_billing,Transaction_number,"","","","");
		waitForElement(driver, package_search_input_select);
		String searchvalue = getText(driver, package_search_input_select);
		System.out.println(searchvalue);
		click(driver, package_search_input_select);
		Step_End(2, "Select any transaction", test, test1);
		Step_Start(3, "Double Click and view the transaction.", test, test1);
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
		
		waitForElement(driver, supplier_trans_number);
		String trans_num = getAttribute(driver, supplier_trans_number,"value");
		System.out.println(trans_num);

		if (Transaction_number.equals(searchvalue)&& Transaction_number.equals(trans_num)) {
			System.out.println("Matched || " + " Expected search number is should be display in the Suplier invoice Screen : " + Transaction_number+ " || Actual search number is Dispaly in the Suplier invoice Screen : " + searchvalue+"**after search select inside shown as****"+trans_num);
			Extent_pass_New(driver, "Matched || " + " Expected search number is should be display in the Suplier invoice Screen : " + Transaction_number+ " || Actual search number is Dispaly in the Suplier invoice Screen : " + searchvalue+"**after search select inside shown as****"+trans_num, test, test1);
			Extent_call(test, test1, "Record was retrived correctly using global search");
		} else {
			System.out.println("Not matched || " + " Expected search number is should be display in the Suplier invoice Screen : " + Transaction_number+ " || Actual search number is Dispaly in the Suplier invoice Screen : " + searchvalue+"**after search select inside shown as****"+trans_num);
			Extent_fail(driver, "Not matched || " + " Expected search number is should be display in the Suplier invoice Screen : " + Transaction_number+ " || Actual search number is Dispaly in the Suplier invoice Screen : " + searchvalue+"**after search select inside shown as****"+trans_num, test, test1);

		}
		Step_End(3, "Double Click and view the transaction.", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
