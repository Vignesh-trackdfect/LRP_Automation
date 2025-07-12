package LRP_Finance_Journal_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Journal_J10 extends Keywords{
	public void Journal_J10(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Journal_J10";
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String module_Journal = Excel_data.get("Module_Journal");
		String datePicker = Excel_data.get("DatePicker");
		String activity_Date=Excel_data.get("Activity_Date");
		String trans_Date = Excel_data.get("Trans_Date");
		String originalRef = Excel_data.get("OriginalRef");
		String no_Of_Characters = Excel_data.get("No_Of_Characters");
		String description_Input = Excel_data.get("Description_Input");
		String cr_Dr_Option = Excel_data.get("Cr_Dr_Option");
		String nominalName = Excel_data.get("NominalName");
		String amount = Excel_data.get("Amount");
		String currencyCode = Excel_data.get("CurrencyCode");
		String localDescription = Excel_data.get("LocalDescription");
		String transDatePopup = Excel_data.get("TransDatePopup");
		String nominal_Search_Header = Excel_data.get("Nominal_Search_Header");
		String condition = Excel_data.get("Condition");
		String currency_Search_Header = Excel_data.get("Currency_Search_Header");

		StringBuilder year = new StringBuilder();
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
		Step_Start(2, "Select the activity date from the date picker which is less than the transdate", test, test1);
		waitForElement(driver, activityDate_Field);
		click(driver, activityDate_Field);
		if (datePicker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, activityDate_Field, activity_Date);
		} else {
			clearAndType(driver, activityDate_Field, activity_Date);
			waitForElement(driver, originalRef_Textfield);
			click(driver, originalRef_Textfield);
		}
		Step_End(2, "Select the activity date from the date picker which is less than the transdate", test, test1);
		Step_Start(3, "Select the trans date from the date picker which is greater than the activity date ", test, test1);
		waitForElement(driver, transDate_Field);
		click(driver, transDate_Field);
		if (datePicker.equalsIgnoreCase("Yes")) {
			selectDatePicker(driver, transDate_Field, trans_Date);
		} else {
			clearAndType(driver, transDate_Field, trans_Date);
			waitForElement(driver, originalRef_Textfield);
			click(driver, originalRef_Textfield);
		}
		Step_End(3, "Select the trans date from the date picker which is greater than the activity date ", test, test1);
		Step_Start(4, "Enter the  Alphanumeric characters or only numerical values upto (46) characters in that OriginalRef field", test, test1);
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
			System.out.println("Matched || Unable to enter more than "+expected_No_Of_Characters+" characters || \r\n No.of characters of the given Original Ref Number : "+length +" \r\n No.of characters of the Actual Original Ref Number : "+actual_Length);
			Extent_pass_New(driver, "Matched || Unable to enter more than "+expected_No_Of_Characters+" characters || \r\n No.of characters of the given Original Ref Number : "+length +" \r\n No.of characters of the Actual Original Ref Number : "+actual_Length, test, test1);
		}else {
			System.out.println("Not Matched || Able to enter more than "+expected_No_Of_Characters+" characters || \r\n No.of characters of the given Original Ref Number : "+length +" \r\n No.of characters of the Actual Original Ref Number : "+actual_Length);
			Extent_fail(driver, "Not Matched || Able to enter more than "+expected_No_Of_Characters+" characters || \r\n No.of characters of the given Original Ref Number : "+length +" \r\n No.of characters of the Actual Original Ref Number : "+actual_Length, test, test1);
		}
		Step_End(4, "Enter the  Alphanumeric characters or only numerical values upto (46) characters in that OriginalRef field", test, test1);
		Step_Start(5, "Based on your activity date open period will automatically changed", test, test1);
		waitForElement(driver, openPeriod_Dropdown);
		String open_Period_Text = getText(driver, openPeriod_Dropdown);
		if(open_Period_Text.contains(year)) {
			System.out.println("MATCHED || EXPECTED OPEN PERIOD YEAR -> "+year+" ACTUAL OPEN PERIOD YEAR -> "+open_Period_Text);
			Extent_pass_New(driver, "MATCHED || EXPECTED OPEN PERIOD YEAR -> "+year+" ACTUAL OPEN PERIOD YEAR -> "+open_Period_Text, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED OPEN PERIOD YEAR -> "+year+" ACTUAL OPEN PERIOD YEAR -> "+open_Period_Text);
			Extent_fail(driver, "NOT MATCHED || EXPECTED OPEN PERIOD YEAR -> "+year+" ACTUAL OPEN PERIOD YEAR -> "+open_Period_Text, test, test1);
		}
		Step_End(5, "Based on your activity date open period will automatically changed", test, test1);
		Step_Start(6, "Enter Alphanumeric characters in description field", test, test1);
		waitForElement(driver, description_TextArea_Jnl);
		sendKeys(driver, description_TextArea_Jnl, description_Input);
		Step_End(6, "Enter Alphanumeric characters in description field", test, test1);
		Step_Start(7, "Select the dr/cr in that dropdown list", test, test1);
		waitForElement(driver, dr_Cr_Dropdown);
		click(driver, dr_Cr_Dropdown);
		String select_Cr_Dr=String.format(dr_Cr_Dropdown_Option, cr_Dr_Option);
		waitForElement(driver, select_Cr_Dr);
		click(driver, select_Cr_Dr);
		Step_End(7, "Select the dr/cr in that dropdown list", test, test1);
		Step_Start(8, "Click + button to add the nominals in the grid", test, test1);
		waitForElement(driver, dr_Cr_SearchButton);
		click(driver, dr_Cr_SearchButton);	
		twoColumnSearchWindow(driver, nominal_Search_Header, condition, nominalName);
		waitForElement(driver, amountTextfield);
		click(driver, amountTextfield);
		waitForElement(driver, amountTextfield);
		clearAndType(driver, amountTextfield, amount);
		waitForElement(driver, amountTextfield);
		click(driver, localDescription_TextArea);
		waitForElement(driver, currencySearchButton);
		click(driver, currencySearchButton);	
		twoColumnSearchWindow(driver, currency_Search_Header, condition, currencyCode);
		waitForElement(driver, localDescription_TextArea);
		sendKeys(driver, localDescription_TextArea, localDescription);
		waitForElement(driver, add_Button_Journal);
		click(driver, add_Button_Journal);	
		Step_End(8, "Click + button to add the nominals in the grid", test, test1);
		Step_Start(9, "It shows the validation \"Trans date must be less than or equal to the current date\"", test, test1);
		waitForPopup(driver, popup_Message,transDatePopup);
		String actualPopup=getText(driver, popup_Message);
		if(actualPopup.equals(transDatePopup)) {
			System.out.println("Matched || Expected Pop-up value is : "+transDatePopup+" || Actual Pop-up value is : "+actualPopup);
			Extent_pass_New(driver, "Matched || Expected Pop-up value is : "+transDatePopup+" || Actual Pop-up value is : "+actualPopup, test, test1);
			click(driver, popup_Message_Ok_Button);	
		}else {
			System.out.println("Not Matched || Expected Pop-up value is : "+transDatePopup+" || Actual Pop-up value is : "+actualPopup);
			Extent_fail(driver, "Not Matched || Expected Pop-up value is : "+transDatePopup+" || Actual Pop-up value is : "+actualPopup, test, test1);
		}
		Step_End(9, "It shows the validation \"Trans date must be less than or equal to the current date\"", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}