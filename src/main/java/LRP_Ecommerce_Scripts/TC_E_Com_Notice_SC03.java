package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_E_Com_Notice_SC03 extends Keywords {

	public void E_Com_Notice_SC03(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_E_Com_Notice_SC03";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String title = Excel_data.get("Title");
		String PDF_FileName_Edit = Excel_data.get("PDF_FileName_Edit");
		String Updated_Popup = Excel_data.get("Updated_Popup");
		String Ecommerce_URL = Excel_data.get("Ecommerce_URL");
		String Title_Header = Excel_data.get("Title_Header");
		String Condition = Excel_data.get("Condition");
		String new_Title = Excel_data.get("New_Title");

		String pdf_FilePath_Edit = System.getProperty("user.dir") + "\\uploads\\" + PDF_FileName_Edit + ".pdf";

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Module_Name);

		Step_Start(1, "Click the Toolbar Search.", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		Step_End(1, "Click the Toolbar Search.", test, test1);
		Step_Start(2, "Select the record and double-click it to load the, details into the respective fields.", test,
				test1);

		twoColumnMultipleSearchWindow(driver, Title_Header, Condition, title);

		Step_End(2, "Select the record and double-click it to load the, details into the respective fields.", test,
				test1);
		Step_Start(3, "Make any changes to the Title and File Upload options", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, EN_Title_Textfield);
		Newclear(driver, EN_Title_Textfield);
		waitForElement(driver, EN_Title_Textfield);
		sendKeys(driver, EN_Title_Textfield, new_Title);

//		clearAndType(driver, EN_Title_Textfield, new_Title);

		waitForElement(driver, EN_Browse_Button);

		uploadfile(driver, EN_Pdf_File_Upload, pdf_FilePath_Edit);

		Step_End(3, "Make any changes to the Title and File Upload options", test, test1);

		Step_Start(4, "Click the \"Save\" button.", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(4, "Click the \"Save\" button.", test, test1);
		Step_Start(5, "The updated notice will be displayed in the Ecom Notice menu in eCommerce.", test, test1);

		waitForPopup(driver, popup_Message, Updated_Popup);
		String actual_Popup = getText(driver, popup_Message);

		if (actual_Popup.equals(Updated_Popup)) {
			System.out.println("Matched || Expected Popup Message: " + Updated_Popup + " || Actual Popup Message :"
					+ actual_Popup);
			Extent_pass_New(driver,
					"Matched || Expected Popup Message: " + Updated_Popup + " || Actual Popup Message :" + actual_Popup,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Popup Message: " + Updated_Popup + " || Actual Popup Message :"
					+ actual_Popup);
			Extent_fail(driver, "Not Matched || Expected Popup Message: " + Updated_Popup + " || Actual Popup Message :"
					+ actual_Popup, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		newTab(driver);

		navigateUrl(driver, Ecommerce_URL);

		waitForElement(driver, Ecom_Main_Menu);
		click(driver, Ecom_Main_Menu);

		scrollElementToCenter(driver, Ecom_Main_Menu_Notice_Option);
		waitForElement(driver, Ecom_Main_Menu_Notice_Option);
		jsClick(driver, Ecom_Main_Menu_Notice_Option);

		waitForElement(driver, Ecom_SearchField);
		sendKeys(driver, Ecom_SearchField, new_Title);

		String actual_Title_Row = String.format(Ecom_Notice_Title, new_Title);
		waitForDisplay(driver, Ecom_SearchField);

		if (isDisplayed(driver, actual_Title_Row)) {
			System.out.println(
					"Passed || Expected result is : Updated notice should be displayed in the Ecommerce notice menu || Actual result is : Updated notice is displayed in the Ecommerce notice menu");
			Extent_pass_New(driver,
					"Passed || Expected result is : Updated notice should be displayed in the Ecommerce notice menu || Actual result is : Updated notice is displayed in the Ecommerce notice menu",
					test, test1);
		} else {
			System.out.println(
					"Fail || Expected result is : Updated notice should be displayed in the Ecommerce notice menu || Actual result is : Updated notice is not displayed in the Ecommerce notice menu");
			Extent_fail(driver,
					"Fail || Expected result is : Updated notice should be displayed in the Ecommerce notice menu || Actual result is : Updated notice is not displayed in the Ecommerce notice menu",
					test, test1);
		}

		Step_End(5, "The updated notice will be displayed in the Ecom Notice menu in eCommerce.", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
