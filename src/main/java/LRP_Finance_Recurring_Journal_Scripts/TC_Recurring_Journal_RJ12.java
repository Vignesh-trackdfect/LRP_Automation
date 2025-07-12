package LRP_Finance_Recurring_Journal_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Recurring_Journal_RJ12 extends Keywords{
	public void Recurring_Journal_RJ12(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String testcase_Name="TC_Recurring_Journal_RJ12";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Recurring_Journal_Module = Excel_data.get("Recurring_Journal_Module");
		String Select_search_recurring_journal = Excel_data.get("Select_search_recurring_journal");
		String Condition = Excel_data.get("Condition");
		String Transaction_number = Excel_data.get("Transaction_number");
		String date_Picker = Excel_data.get("date_Picker");
		String Start_Date_Input = Excel_data.get("Start_Date_Input");
		String Count_Of_Days = Excel_data.get("Count_Of_Days");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, Username, Password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, Recurring_Journal_Module);
		Step_Start(1, "Click new on toolbar", test, test1);
		Step_Start(2, " Pop message will appear . Click yes to continue", test, test1);
		waitForDisplay(driver, popup_Message);
		if(isDisplayed(driver, popup_Message)) {
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
		Step_End(3, "Select the Transaction number using search field ", test, test1);
		Step_Start(4, " Click Create Batch button . Popup window will appear .", test, test1);
		waitForElement(driver, create_batch);
		click(driver,create_batch);
		Step_End(4, " Click Create Batch button . Popup window will appear .", test, test1);
		Step_Start(5, "Select the DAY option ", test, test1);
		waitForElement(driver, Date_Radio_Button_RJ);
		click(driver, Date_Radio_Button_RJ);
		Step_End(5, "Select the DAY option ", test, test1);
		waitForElement(driver, start_date);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, start_date, Start_Date_Input);
		} else {
			waitForElement(driver, start_date);
			clearAndType(driver, start_date, Start_Date_Input);
		}
		Step_Start(7, "Select No End date option", test, test1);
		waitForElement(driver, No_end_date_radio_button);
		click(driver, No_end_date_radio_button);
		Step_End(7, "Select No End date option", test, test1);
		Step_Start(6, "Enter the  count of days in Every days  text field", test, test1);
		waitForElement(driver, Day_input);
		sendKeys(driver, Day_input, Count_Of_Days);
		Step_End(6, "Enter the  count of days in Every days  text field", test, test1);
		waitForElement(driver, End_Date_RJ);
		String End_Date=getAttribute(driver, End_Date_RJ, "value");
		System.out.println("End_Date:"+End_Date);
		long value = dayCount(Start_Date_Input, End_Date, Count_Of_Days);
		Step_Start(8, "Click Generate Button", test, test1);
		waitForElement(driver, Generate_Button_RJ);
		click(driver, Generate_Button_RJ);
		Step_End(8, "Click Generate Button", test, test1);
		Step_Start(9, "Batch successfully genrated by no end date", test, test1);
		List<WebElement> Recurring_Journal_List = listOfElements(driver, Recurring_Journal_Grid);
		int Batch_Count = Recurring_Journal_List.size();
		System.out.println("Batch Genrated: "+Batch_Count);
		if(value==Batch_Count) {
			System.out.println("Matched || Expected Genrated Batch Count is  : " + value + " || Actual Genrated Batch Count is : " + Batch_Count);
			Extent_pass_New(driver,"Matched || Expected Genrated Batch Count is : " + value + " || Actual Genrated Batch Count is : " + Batch_Count, test,test1);
		} else {
			System.out.println("Not Matched || Expected Genrated Batch Count is : " + value + " || Actual Genrated Batch Count is : " + Batch_Count);
			Extent_fail(driver,"Not Matched || Expected Genrated Batch Count is  : " + value + " || Actual Genrated Batch Count is  : " + Batch_Count,test, test1);
		}
		Step_End(9, "Batch successfully genrated by no end date", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}