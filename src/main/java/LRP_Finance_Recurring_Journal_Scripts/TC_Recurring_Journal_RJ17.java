package LRP_Finance_Recurring_Journal_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Recurring_Journal_RJ17 extends Keywords{
	public void Recurring_Journal_RJ17(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String testcase_Name="TC_Recurring_Journal_RJ17";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Recurring_Journal_Module = Excel_data.get("Recurring_Journal_Module");
		String Select_search_recurring_journal = Excel_data.get("Select_search_recurring_journal");
		String Condition = Excel_data.get("Condition");
		String Recurring_number = Excel_data.get("Recurring_number");
		String date_Picker = Excel_data.get("date_Picker");
		String From_date = Excel_data.get("From_date");
		String To_date = Excel_data.get("To_date");
		String StatusType = Excel_data.get("StatusType");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, Username, Password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, Recurring_Journal_Module);
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
		}else {
			newButton(driver);
		}
		Step_Start(1, "Click Global search ,serach the recurring no", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Condition, Select_search_recurring_journal, Recurring_number, "", "", "", "");
		Step_End(2, "Select the transactions", test, test1);
		Step_Start(3, "Selected journal appear in recurring journal screen", test, test1);
		waitForElement(driver, Recurring_No_RJ);
		String Recurring_Number=getAttribute(driver, Recurring_No_RJ, "value");
		System.out.println("Recurring Number Selected :"+Recurring_Number);
		Step_End(3, "Selected journal appear in recurring journal screen", test, test1);
		Step_Start(4, "Click Recurring Posting Details Command link option", test, test1);
		waitForElement(driver, Recurring_Posting_Details_Button_RJ);
		click(driver, Recurring_Posting_Details_Button_RJ);
		Step_End(4, "Click Recurring Posting Details Command link option", test, test1);
		Step_Start(5, "Popup window will appear and it showing the Post details", test, test1);
		waitForDisplay(driver, Posting_details_Page_RJ);
		if (isDisplayed(driver, Posting_details_Page_RJ)) {
			System.out.println("Matched || Expected Result is : Posting Details Page Should be Display || Actual Result is : Posting Details Page Displayed");
			Extent_pass_New(driver, "Matched || Expected Result is : Posting Details Page Should be Display || Actual Result is : Posting Details Page Displayed", test, test1);
			click(driver, Posting_details_Page_RJ);
		}else {
			System.out.println("Not Matched || Expected Result is : Posting Details Page Should be Display || Actual Result is : Posting Details Page Not Displayed");
			Extent_fail(driver, "Not Matched || Expected Result is : Posting Details Page Should be Display || Actual Result is : Posting Details Page Not Displayed", test, test1);
		}
		Step_End(5, "Popup window will appear and it showing the Post details", test, test1);
		Step_Start(6, "Click Activity Date radio button and select the \"From date and To date\" from the date picker", test, test1);
		waitForElement(driver, Activity_Date_RadioBtn_RJ);
		click(driver, Activity_Date_RadioBtn_RJ);
		waitForElement(driver, Posting_Details_From_Date_RJ);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, Posting_Details_From_Date_RJ, From_date);
		} else {
			waitForElement(driver, Posting_Details_From_Date_RJ);
			clearAndType(driver, Posting_Details_From_Date_RJ, From_date);
		}
		waitForElement(driver, Posting_Details_to_Date_RJ);
		if (date_Picker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, Posting_Details_to_Date_RJ, To_date);
		} else {
			waitForElement(driver, Posting_Details_to_Date_RJ);
			clearAndType(driver, Posting_Details_to_Date_RJ, To_date);
		}
		Step_End(6, "Click Activity Date radio button and select the \"From date and To date\" from the date picker", test, test1);
		Step_Start(7, " Choose the Post type as OPEN", test, test1);
		waitForElement(driver, Status_Type);
		click(driver, Status_Type);
		String Type = String.format(Select_Type, StatusType);
		waitForElement(driver, Type);
		click(driver, Type);
		waitForElement(driver, Status_Type);
		String Type_Of_Status=getText(driver, Status_Type);
		Step_End(7, " Choose the Post type as OPEN", test, test1);
		Step_Start(8, "Click Show Button", test, test1);
		waitForElement(driver, show_Btn_RJ);
		click(driver, show_Btn_RJ);
		Step_End(8, "Click Show Button", test, test1);
		Step_Start(9, "Recurring JV should be showed which is in Open status", test, test1);
		waitForElement(driver, posting_Details_Grid_Header);
		List<Map<String, String>> table_Data = getTableData(driver, posting_Details_Grid_Header, posting_Details_Grid_Rows);
		List<String> Batch_Status = getValuesByHeader(table_Data, "Batch Status");
		System.out.println("Batch_Staus :"+ Batch_Status);
		for(int i=0;i<Batch_Status.size();i++) {
			if(Type_Of_Status.equalsIgnoreCase(Batch_Status.get(i))) {
				System.out.println("Matched || Batch status Taken From Grid : " + Batch_Status.get(i) + " || Batch Status Selected : " + Type_Of_Status);
				Extent_pass_New(driver,"Matched || Batch status Taken From Grid : " + Batch_Status.get(i) + " || Batch Status Selected : " + Type_Of_Status, test,test1);
			} else {
				System.out.println("Not Matched ||Batch status Taken From Grid : " + Batch_Status.get(i) + " || Batch Status Selected : " + Type_Of_Status);
				Extent_fail(driver,"Not Matched || Batch status Taken From Grid  : " + Batch_Status.get(i) + " ||Batch Status Selected  : " + Type_Of_Status,test, test1);
			}
		}
		Step_End(9, "Recurring JV should be showed which is in Open status", test, test1);
		waitForElement(driver, Clear_button_RJ);
		click(driver, Clear_button_RJ);
		Extent_completed(testcase_Name, test, test1);
	}
}