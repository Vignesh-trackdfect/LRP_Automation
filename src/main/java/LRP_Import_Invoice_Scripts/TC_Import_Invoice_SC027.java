package LRP_Import_Invoice_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Import_Invoice_SC027 extends Keywords {
	public void Import_Invoice_SC027(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Import_Invoice_SC027";
		
		


		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("Field_Names");
		String BL_Number_input = Excel_data.get("BL_Number_input");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Select_Search_Type_Import_Doc = Excel_data.get("Select_Search_Type_Import_Doc");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Already_Exists_Popup = Excel_data.get("Already_Exists_Popup");
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_Start(1, "switch to import agency", test, test1);

		SwitchProfile(driver, AgencyUser);

		Step_End(1, "switch to import agency", test, test1);

		Step_Start(2, "open the import invoice module and click the new button", test, test1);

		moduleNavigate(driver, Field_Names);

		newButton(driver);

		Step_End(2, "open the import invoice module and click the new button", test, test1);

		Step_Start(3, "retrive the bl in bl number search field ", test, test1);

		waitForElement(driver, import_invoice_bl_search);
		click(driver, import_invoice_bl_search);

		globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Number_input, "", "", "", "");

		Step_End(4, "search and select the bl no", test, test1);

		Step_Start(5, "system has validate -Invoice already exist for this bl", test, test1);

		waitForPopup(driver, popup_Message, Already_Exists_Popup);

		String Actual_Exist_Popup = getText(driver, popup_Message);
		System.out.println(Actual_Exist_Popup);
		if (Already_Exists_Popup.equals(Actual_Exist_Popup)) {
			Extent_pass_New(driver,
					"Matched || Expected Popup : " + Already_Exists_Popup + " || Actual Popup : " + Actual_Exist_Popup,
					test, test1);
			System.out.println(
					"Matched || Expected Popup : " + Already_Exists_Popup + " || Actual Popup : " + Actual_Exist_Popup);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched || Expected Popup : " + Already_Exists_Popup + " || Actual Popup : "
					+ Actual_Exist_Popup);
			Extent_fail(driver, "Not Matched || Expected Popup : " + Already_Exists_Popup + " || Actual Popup : "
					+ Actual_Exist_Popup, test, test1);
		}
		Step_End(5, "system has validate -Invoice already exist for this bl", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
