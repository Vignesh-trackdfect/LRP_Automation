package LRP_Ecommerce_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Gateway_Validator_034 extends Keywords {

	public void Ecommerce_Gateway_Validator_034(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Gateway_Validator_034";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String Transaction_Type = Excel_data.get("Transaction_Type");
		String Booking_Number = Excel_data.get("Booking_Number");
		String Reference_Number = Excel_data.get("Reference_Number");
		String bl_NumberInput = Excel_data.get("BL_Number");
		String Headers_Verify = Excel_data.get("Headers_Verify");
		String DateCheckbox_Status = Excel_data.get("DateCheckbox_Status");
		String Given_From_Date = Excel_data.get("Given_From_Date");
		String Given_To_Date = Excel_data.get("Given_To_Date");
		String DatePicker = Excel_data.get("DatePicker");
		String Archive_Condition = Excel_data.get("Archive_Condition");
		String NonProcessed_yes = Excel_data.get("NonProcessed_yes");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Module_Name);

		waitForElement(driver, EG_Transaction_type);
		click(driver, EG_Transaction_type);

		waitForDownload(driver, EG_Transaction_type);
		formatLocatorClick(driver, EG_Select_Transaction_type, Transaction_Type);

		if (DateCheckbox_Status.equals("Yes")) {

			checkBox(driver, EG_byDate_Checkbox, DateCheckbox_Status);

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_FromDate_Input);
				selectDatePicker(driver, EG_FromDate_Input, Given_From_Date);

			} else {

				waitForElement(driver, EG_FromDate_Input);
				clear(driver, EG_FromDate_Input);
				sendKeys(driver, EG_FromDate_Input, Given_From_Date);

			}

			if (DatePicker.equals("Yes")) {

				waitForElement(driver, EG_ToDate_Input);
				selectDatePicker(driver, EG_ToDate_Input, Given_To_Date);

			} else {

				waitForElement(driver, EG_ToDate_Input);
				clear(driver, EG_ToDate_Input);
				sendKeys(driver, EG_ToDate_Input, Given_To_Date);

			}

		} else {

			waitForElement(driver, EG_FromDate_Input);

			Given_From_Date = getAttribute(driver, EG_FromDate_Input, "value");
			Given_To_Date = getAttribute(driver, EG_ToDate_Input, "value");

		}

		waitForElement(driver, EG_NonProcessed_Checkbox);
		checkBox(driver, EG_NonProcessed_Checkbox, NonProcessed_yes);

		if (Archive_Condition.equals("Yes")) {

			waitForElement(driver, EG_Archive_Checkbox);
			checkBox(driver, EG_Archive_Checkbox, Archive_Condition);

		}

		if (!Booking_Number.equals("")) {
			waitForElement(driver, EG_BookingNo_input);
			sendKeys(driver, EG_BookingNo_input, Booking_Number);
		}

		if (!Reference_Number.equals("")) {
			waitForElement(driver, EG_ReferenceNo_Input);
			sendKeys(driver, EG_ReferenceNo_Input, Reference_Number);
		}

		if (!bl_NumberInput.equals("")) {
			waitForElement(driver, EG_BLNo_input);
			sendKeys(driver, EG_BLNo_input, bl_NumberInput);
		}

		waitForElement(driver, EG_Refresh);
		click(driver, EG_Refresh);

		waitForElement(driver, EG_Retrieved_Record_AG_Gridcell);
		doubleClick(driver, EG_Retrieved_Record_AG_Gridcell);

		Step_Start(1, "Ecom Booking: Ensure EORI and Type of Person fields are enabled in Booking, SI, and BL.", test,
				test1);

		waitForElement(driver, EBK_Customer_Tab);
		click(driver, EBK_Customer_Tab);

		List<String> headers = splitAndExpand(Headers_Verify);

		boolean precence = false;

		waitForElement(driver, EBK_Customer_Table_Headers);
		List<WebElement> totalHeasers = listOfElements(driver, EBK_Customer_Table_Header_Names);

		for (int i = 0; i < totalHeasers.size(); i++) {

			String actualHeader = totalHeasers.get(i).getText();
			System.out.println("actualHeader : " + actualHeader);

			horizontalscroll(driver, EBK_Customer_Table_Horizontal_scrollbar, 40);
			for (int j = 0; j < headers.size(); j++) {
				if (actualHeader.equals(headers.get(j))) {

					System.out.println("Passed || Expectd : " + headers.get(j) + " column Should be Present || Actual : "+headers.get(j)+" Column is present");
					Extent_pass_New(driver, "Passed || Expectd : " + headers.get(j) + " column Should be Present || Actual : "+headers.get(j)+" Column is present", test, test1);

					precence = true;
				}

			}
		}
		for (int j = 0; j < headers.size(); j++) {
			if (precence == false) {
				System.out.println("Failed || Expectd : " + headers.get(j) + " column Should be Present || Actual : "+headers.get(j)+" Column is not present");
				Extent_fail(driver, "Failed || Expectd : " + headers.get(j) + " column Should be Present || Actual : "+headers.get(j)+" Column is not present", test, test1);

			}
		}

		Step_End(1, "Ecom Booking: Ensure EORI and Type of Person fields are enabled in Booking, SI, and BL.", test,
				test1);
		Extent_completed(testcase_Name, test, test1);
	}

}
