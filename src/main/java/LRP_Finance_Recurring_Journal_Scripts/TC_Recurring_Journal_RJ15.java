package LRP_Finance_Recurring_Journal_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Recurring_Journal_RJ15 extends Keywords{
	public void Recurring_Journal_RJ15(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String testcase_Name="TC_Recurring_Journal_RJ15";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Recurring_Journal_Module = Excel_data.get("Recurring_Journal_Module");
		String Select_search_recurring_journal = Excel_data.get("Select_search_recurring_journal");
		String Condition = Excel_data.get("Condition");
		String Transaction_number = Excel_data.get("Transaction_number");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, Username, Password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, Recurring_Journal_Module);
		Step_Start(1, "Click new on toolbar", test, test1);
		Step_Start(2, " Pop message will appear . Click yes to continue", test, test1);
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}else {
			newButton(driver);
		}
		Step_End(1, "Click new on toolbar", test, test1);
		Step_End(2, " Pop message will appear . Click yes to continue", test, test1);
		Step_Start(3, "Select the Transaction number using search field ", test, test1);
		waitForElement(driver, Transaction_No_searchBtn_RJ);
		click(driver,Transaction_No_searchBtn_RJ);
		globalValueSearchWindow(driver, Condition, Select_search_recurring_journal, Transaction_number, "", "", "", "");
		Step_End(3, "Select the Transaction number using search field", test, test1);
		Step_Start(4, "Click Review Journal Command Link option", test, test1);
		waitForElement(driver, Review_Journal_Button_RJ);
		click(driver, Review_Journal_Button_RJ);
		Step_End(4, "Click Review Journal Command Link option", test, test1);
		Step_Start(5, "It navigated the Journal module and able to ciew the transaction entry ", test, test1);
		waitForElement(driver, Trans_Number_TF_JNL);
		String Trans_Num=getAttribute(driver, Trans_Number_TF_JNL, "value");
		if(Transaction_number.equals(Trans_Num)) {
			System.out.println("Matched || Transaction Number taken from Recurring Journal is  : " + Transaction_number + " || Transaction Number taken from Journal  is : " + Trans_Num);
			Extent_pass_New(driver,"Matched || Transaction Number taken from Recurring Journal is : " + Transaction_number + " || Transaction Number taken from Recurring Journal is : " + Trans_Num, test,test1);
		} else {
			System.out.println("Not Matched || Transaction Number taken from Recurring Journal is : " + Transaction_number + " || Transaction Number taken from Recurring Journal is : " + Trans_Num);
			Extent_fail(driver,"Not Matched || Transaction Number taken from Recurring Journal is  : " + Transaction_number + " || Transaction Number taken from Recurring Journal is  : " + Trans_Num,test, test1);
		}	
		Step_End(5, "It navigated the Journal module and able to ciew the transaction entry ", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}