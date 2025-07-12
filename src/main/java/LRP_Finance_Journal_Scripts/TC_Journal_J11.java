package LRP_Finance_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_J11 extends Keywords{
	public void Journal_J11(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Journal_J11";
		// Get data from test data
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String module_Journal = Excel_data.get("Module_Journal");
		String datePicker = Excel_data.get("DatePicker");
		String activity_Date=Excel_data.get("Activity_Date");
		String trans_Date = Excel_data.get("Trans_Date");
		String originalRef = Excel_data.get("OriginalRef");
		String no_Of_Characters = Excel_data.get("No_Of_Characters");

		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);
		// Login
		LRP_Login(driver, username, password);
		//Instead of clicking the first module dropdown , this method select the module name by using excel test data		
		moduleNavigate(driver, module_Journal);
//	Journal
		Extent_cal(test, test1, module_Journal);
		Step_Start(1, "Click new on toolbar", test, test1);
		newButton(driver);
		Step_End(1, "Click new on toolbar", test, test1);
		Step_Start(2, "Select the activity date from the date picker", test, test1);
		waitForElement(driver, activityDate_Field);
		if (datePicker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, activityDate_Field, activity_Date);
		} else {
			clearAndType(driver, activityDate_Field, activity_Date);
			waitForElement(driver, originalRef_Textfield);
			click(driver, originalRef_Textfield);
		}
		Step_End(2, "Select the activity date from the date picker", test, test1);
		Step_Start(3, "Select the Trans date from the date picker.", test, test1);
		waitForElement(driver, transDate_Field);
		if (datePicker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, transDate_Field, trans_Date);
		} else {
			clearAndType(driver, transDate_Field, activity_Date);
			waitForElement(driver, originalRef_Textfield);
			click(driver, originalRef_Textfield);
		}
		Step_End(3, "Select the Trans date from the date picker.", test, test1);
		Step_Start(4, "Enter  Alphanumeric characters or only numerical values whih is more than 46  characters in that OriginalRef field.", test, test1);
		int length=originalRef.length();
		waitForElement(driver, originalRef_Textfield);
		sendKeys(driver, originalRef_Textfield, originalRef);
		waitForElement(driver, description_TextArea_Jnl);
		click(driver, description_TextArea_Jnl);
		waitForElement(driver, originalRef_Textfield);
		String actual_OriginalRef=getAttribute(driver, originalRef_Textfield, "value");
		int actual_Length=actual_OriginalRef.length();
		int expected_No_Of_Characters=Integer.parseInt(no_Of_Characters);
		Step_End(4, "Enter  Alphanumeric characters or only numerical values whih is more than 46  characters in that OriginalRef field.", test, test1);
		Step_Start(5, "It does not allow to enter more than 46 characters ", test, test1);
		if(actual_Length<=expected_No_Of_Characters ) {
			System.out.println("Matched || Expected It does not allow to enter more than "+expected_No_Of_Characters+" characters || \r\n Actual No.of characters of the given Original Ref Number in Excel Data : "+length +" \r\n No.of characters of the Actual Original Ref Number Accepted in Original Ref Number Field : "+actual_Length);
			Extent_pass_New(driver,"Matched || Expected It does not allow to enter more than "+expected_No_Of_Characters+" characters || \r\n Actual No.of characters of the given Original Ref Number in Excel Data : "+length +" \r\n No.of characters of the Actual Original Ref Number Accepted in Original Ref Number Field : "+actual_Length, test, test1);
		}else {
			System.out.println("Not Matched || Expected It does not allow to enter more than "+expected_No_Of_Characters+" characters || \r\n Actual No.of characters of the given Original Ref Number in Excel Data : "+length +" \r\n No.of characters of the Actual Original Ref Number Accepted in Original Ref Number Field : "+actual_Length);
			Extent_fail(driver,"Not Matched || Expected It does not allow to enter more than "+expected_No_Of_Characters+" characters || \r\n Actual No.of characters of the given Original Ref Number in Excel Data : "+length +" \r\n No.of characters of the Actual Original Ref Number Accepted in Original Ref Number Field : "+actual_Length, test, test1);
		}
		Step_End(5, "It does not allow to enter more than 46 characters ", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}