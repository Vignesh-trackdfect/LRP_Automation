package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_E_Com_Notice_SC02 extends Keywords {

	public void E_Com_Notice_SC02(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_E_Com_Notice_SC02";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String title = Excel_data.get("Title");
		String PDF_FileName = Excel_data.get("PDF_FileName");
		String Saved_Popup = Excel_data.get("Saved_Popup");
		String Ecommerce_URL = Excel_data.get("Ecommerce_URL");

		String pdf_FilePath = System.getProperty("user.dir") + "\\uploads\\"+PDF_FileName+".pdf";
		
		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Module_Name);

		Step_Start(1, "Enter the title in the Title text field.", test, test1);

		waitForElement(driver, EN_Title_Textfield);
		sendKeys(driver, EN_Title_Textfield, title);

		Step_End(1, "Enter the title in the Title text field.", test, test1);
		Step_Start(2, "Click the Browse button", test, test1);

		waitForElement(driver, EN_Browse_Button);

		Step_End(2, "Click the Browse button", test, test1);
		Step_Start(3, "Select the file and double-click it; the file will be set.", test, test1);

		uploadfile(driver, EN_Pdf_File_Upload, pdf_FilePath);

		Step_End(3, "Select the file and double-click it; the file will be set.", test, test1);

		Step_Start(4, "Click the 'Save' button.", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(4, "Click the \"Save\" button.", test, test1);
		Step_Start(5, "The saved notice will be displayed in the Ecom Notice menu in eCommerce.", test, test1);

		waitForPopup(driver, popup_Message, Saved_Popup);
		String actual_Popup = getText(driver, popup_Message);

		if (actual_Popup.equals(Saved_Popup)) {
			System.out.println(
					"Matched || Expected Popup Message: " + Saved_Popup + " || Actual Popup Message :" + actual_Popup);
			Extent_pass_New(driver,
					"Matched || Expected Popup Message: " + Saved_Popup + " || Actual Popup Message :" + actual_Popup,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Popup Message: " + Saved_Popup + " || Actual Popup Message :"
					+ actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Popup Message: " + Saved_Popup + " || Actual Popup Message :"
					+ actual_Popup, test, test1);
		}

		click(driver, popup_Message_Ok_Button);

		newTab(driver);

		navigateUrl(driver, Ecommerce_URL);

		waitForElement(driver, Ecom_Main_Menu);
		click(driver, Ecom_Main_Menu);

		scrollElementToCenter(driver, Ecom_Main_Menu_Notice_Option);
		waitForElement(driver, Ecom_Main_Menu_Notice_Option);
		jsClick(driver, Ecom_Main_Menu_Notice_Option);

		waitForElement(driver, Ecom_SearchField);
		sendKeys(driver, Ecom_SearchField, title);

		String actual_Title_Row = String.format(Ecom_Notice_Title, title);
		waitForDisplay(driver, Ecom_SearchField);

		if (isDisplayed(driver, actual_Title_Row)) {
			System.out.println(
					"Passed || Expected result is : Saved notice should be displayed in the Ecommerce notice menu || Actual result is : Saved notice is displayed in the Ecommerce notice menu");
			Extent_pass_New(driver,
					"Passed || Expected result is : Saved notice should be displayed in the Ecommerce notice menu || Actual result is : Saved notice is displayed in the Ecommerce notice menu",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : Saved notice should be displayed in the Ecommerce notice menu || Actual result is : Saved notice is not displayed in the Ecommerce notice menu");
			Extent_fail(driver,
					"Fail || Expected result is : Saved notice should be displayed in the Ecommerce notice menu || Actual result is : Saved notice is not displayed in the Ecommerce notice menu",
					test, test1);
		}

		Step_End(5, "The saved notice will be displayed in the Ecom Notice menu in eCommerce.", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
