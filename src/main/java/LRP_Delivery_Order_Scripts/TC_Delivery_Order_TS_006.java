package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_006 extends Keywords{
	public void Delivery_Order_TS_006(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_006";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser=Excel_data.get("AgencyUser");
		String globalSearch_Number=Excel_data.get("GlobalSearch_Number");
		String module_Delivery_Order = Excel_data.get("Module_Delivery_Order");
		String module_Delivery_Order_Reset = Excel_data.get("Module_Delivery_Order_Reset");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition");
		String doStatus = Excel_data.get("DO_Status");
		String status_Filer_Data = Excel_data.get("Status_Filer_Data");
		String remarks = Excel_data.get("Remarks");
		String globalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String globalSearchFilterOption_DO_Reset = Excel_data.get("GlobalSearchFilterOption_DO_Reset");
		String Reset_Option = Excel_data.get("Reset_Option");


		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch the agency ", test, test1);
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Switch the agency ", test, test1);
		Step_Start(2, "open Delivery order Module, click the search button from tool bar", test, test1);
		//	Delivery Order
		moduleNavigate(driver, module_Delivery_Order);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(2, "open Delivery order Module, click the search button from tool bar", test, test1);
		Step_Start(3, "Paste the BLnumber and click on \"\"Select\"\"", test, test1);
		globalValueSearchWindow1(driver, dropdownCondition, globalSearchFilterOption_DO, globalSearch_Number, "", "", "", "");
		Step_End(3, "Paste the BLnumber and click on \"\"Select\"\"", test, test1);
		Step_Start(4, "Scroll right side and filter by \"Open\" in status column", test, test1);
		Step_Start(5, "Double click on the selected grid", test, test1);
		globalValueSearchWindowScrollAndSelect(driver,status_Filter_DO,status_Filer_Data);
		Step_End(5, "Double click on the selected grid", test, test1);
		Step_End(4, "Scroll right side and filter by \"Open\" in status column", test, test1);
		Step_Start(6, "Fetch the BL  and copy the DO number", test, test1);
		waitForElement(driver, deliveryOrderNumber_Textfield);
		String actualDO_Number=getAttribute(driver, deliveryOrderNumber_Textfield,"value");
		Extent_pass_New(driver, "Retrieved DO Number : "+actualDO_Number, test, test1);
		Step_End(6, "Fetch the BL  and copy the DO number", test, test1);
		Step_Start(7, "Tick Print DO check box and click Print button", test, test1);
		waitForElement(driver, Print_DO_Check_Box);
		checkBox(driver, Print_DO_Check_Box, "Yes");
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		Step_End(7, "Tick Print DO check box and click Print button", test, test1);
		Step_Start(8, "Ensure print page should be opened and copy the DO number from PDF which  should be matched with the previous copied DO number", test, test1);
		waitForElement(driver, iFrame);
		switchToFrame(driver, iFrame);
		String actualValue = String.format(DO_Number_PDF, actualDO_Number);
		waitForElement(driver, actualValue);
		String doNumber_PDF=getText(driver, actualValue);
		if(doNumber_PDF.equals(actualDO_Number)) {
			Extent_pass_New(driver, "Matched || DO Number in PDF : "+doNumber_PDF +" || DO Number in Delivery Order : "+actualDO_Number, test, test1);
			System.out.println("Matched || DO Number in PDF : "+doNumber_PDF +" || DO Number in Delivery Order : "+actualDO_Number);
		}else {
			System.out.println("Not Matched || DO Number in PDF : "+doNumber_PDF +" || DO Number in Delivery Order : "+actualDO_Number);
			Extent_fail(driver, "Not Matched || DO Number in PDF : "+doNumber_PDF +" || DO Number in Delivery Order : "+actualDO_Number, test, test1);
		}
		switchToDefaultFrame(driver);
		waitForElement(driver, close_Button_PDF_Viewer);
		click(driver, close_Button_PDF_Viewer);
		Step_End(8, "Ensure print page should be opened and copy the DO number from PDF which  should be matched with the previous copied DO number", test, test1);
		Step_Start(9, "Also capture the  status of Delivery order from Delivery Order screen as \"\"Issued\"\".\"", test, test1);
		waitForElement(driver, DO_Status);
		String actual_Do_Status=getText(driver, DO_Status);
		if(actual_Do_Status.contains(doStatus)) {
			Extent_pass_New(driver, "Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status, test, test1);
			System.out.println("Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status);
		}else {
			System.out.println("Not Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status);
			Extent_fail(driver, "Not Matched || Expected DO Status value is : "+doStatus +" || Actual DO Status value is : "+actual_Do_Status, test, test1);
		}
		Step_End(9, "Also capture the  status of Delivery order from Delivery Order screen as \"\"Issued\"\".\"", test, test1);
		if(Reset_Option.equalsIgnoreCase("Yes")) {
			//		Delivery Order Reset
			Extent_cal(test, test1, module_Delivery_Order_Reset);
			moduleNavigate(driver, module_Delivery_Order_Reset);
			waitForElement(driver, DO_Number_SearchButton);
			click(driver, DO_Number_SearchButton);
			globalValueSearchWindow(driver, dropdownCondition, globalSearchFilterOption_DO_Reset, actualDO_Number, "", "", "", "");
			waitForElement(driver, DO_Reset_Remarks_Area);
			sendKeys(driver, DO_Reset_Remarks_Area, remarks);
			waitForElement(driver, DO_Reset_Button);
			click(driver, DO_Reset_Button);
			waitForPopup(driver, popup_Message,"Delivery Order Reseted");
			click(driver, popup_Message_Ok_Button);
			Extent_completed(testcase_Name, test, test1);
		}
	}

}
