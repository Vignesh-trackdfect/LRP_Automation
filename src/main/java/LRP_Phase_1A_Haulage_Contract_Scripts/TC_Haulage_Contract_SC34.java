package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import locators.Import_Invoice_Locators;

public class TC_Haulage_Contract_SC34  extends Keywords{
	public void Haulage_Contract_SC34(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC34";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String condition = Excel_data.get("condition");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String excelFilePath = Excel_data.get("excelFilePath");
		String Sheet_select = Excel_data.get("Sheet_select");
		String Excel_Imported_Popup = Excel_data.get("Excel_Imported_Popup");
		
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		Step_Start(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);

		moduleNavigate(driver, Haulage_Contract_Module_Name);

		Step_End(1, ".Enter the  screen name as 'Haulage contracts' in module search field.", test, test1);

		Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);

		waitForElement(driver, Vendor_Search_Button);
		click(driver, Vendor_Search_Button);


		twoColumnMultipleSearchWindow(driver, Vendor_Code_Header, condition, Vendor_Code);

		Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);

		Step_Start(3, "Click the import excel and select the Excel file and Click upload ", test, test1);
		
		waitForElement(driver, HC_Import_Excel_Button);
		click(driver, HC_Import_Excel_Button);
		
		uploadfile_new(driver, ID_ImportExcel, excelFilePath);

		waitForElement(driver, Aselectexcelfiledroupdown);
		click(driver, Aselectexcelfiledroupdown);
		String select_sheet = String.format(Import_Invoice_Locators.Sheet_sel, Sheet_select);

		waitForElement(driver, select_sheet);
		safeclick(driver, select_sheet);

		waitForElement(driver, Aloadsheet);
		click(driver, Aloadsheet);

		if (isdisplayed(driver, Amapyesbutton)) {
			waitForElement(driver, Amapyesbutton);
			click(driver, Amapyesbutton);
		}

		waitForElement(driver, Auploadfile);
		click(driver, Auploadfile);
		
		
		waitForPopup(driver, popup_Message, Excel_Imported_Popup);
		
		String Excel_Imported_popup_Act =getText(driver, popup_Message);
		
		if(Excel_Imported_Popup.equals(Excel_Imported_popup_Act)) {
			
			System.out.println("Matched || Expected Result is : "+ Excel_Imported_Popup + " ||  Actual Result is : "+ Excel_Imported_popup_Act);
			Extent_pass_New(driver, "Matched || Expected Result is : "+ Excel_Imported_Popup + "||  Actual Result is : "+ Excel_Imported_popup_Act, test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
		}else {
			System.out.println("Not Matched || Expected Result is : "+ Excel_Imported_Popup + " || Actual Result is : "+ Excel_Imported_popup_Act);
			Extent_fail(driver, "Not Matched || Expected Result is : "+ Excel_Imported_Popup + " || Actual Result is : "+ Excel_Imported_popup_Act, test, test1);
		}
		
		Step_End(3, "Click the import excel and select the Excel file and Click upload ", test, test1);
		Extent_completed(testcase_Name, test, test1);
		
	}

}
