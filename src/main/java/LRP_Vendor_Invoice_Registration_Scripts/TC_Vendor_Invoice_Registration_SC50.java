package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC50 extends Keywords {

	public void Vendor_Invoice_Registration_SC50(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {


		String testCaseName = "TC_Vendor_Invoice_Registration_SC50";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("Module_Name");
		String searchBy_Vendor = Excel_data.get("SearchBy_Vendor");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String vendorCode = Excel_data.get("VendorCode");
		String Exp_popup = Excel_data.get("Exp_popup");


		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		Step_Start(1, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);

		moduleNavigate(driver, moduleName);

		Step_End(1, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);

		Step_Start(2, "Click the global search ", test, test1);


		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(2, "Click the global search ", test, test1);

		Step_Start(3, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);
		Step_Start(4, "Select the Confirmed Invoice no", test, test1);
		globalValueSearchWindow(driver, dropdownCondition, searchBy_Vendor, vendorCode, "", "", "", "");

		Step_End(3, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);
		Step_End(4, "Select the Confirmed Invoice no", test, test1);

		Step_Start(5, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);

		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);


		waitForPopup(driver, popup_Message, Exp_popup);

		String Act_popup =getText(driver, popup_Message);

		if(Exp_popup.equals(Act_popup)) {
			System.out.println("Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup);
			Extent_pass_New(driver, "Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup, test, test1);
		}else {
			System.out.println("Not Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup);
			Extent_fail(driver, "Not Matched || Expected popup was : " + Exp_popup+ " || Actual popup message was : " + Act_popup, test, test1);
		}

		Step_End(5, "Enter the screen name as a 'Vendor Invoice Registration' in the Search", test, test1);		

		Extent_completed(testCaseName, test, test1);	

	}
}