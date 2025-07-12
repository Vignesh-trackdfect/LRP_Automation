package LRP_DG_Creation_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_001 extends Keywords {

	public void DG_Creation_SC_001(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		// Value are taken from excel sheet
		String testcase_Name = "TC_DG_Creation_SC_001";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Code = Excel_data.get("Agency_Code");
		
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String Expected_DG_Creation_Popup = Excel_data.get("DG_Creation_Popup");


		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		SwitchProfile(driver, Agency_Code);
		moduleNavigate(driver, DG_Creation_Module);
		newButton(driver);
		
		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_Start(4, "select the container in DG tree", test, test1);

		scrollElementToView(driver, DG_Container_Select);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		
		waitForElement(driver, Apply_to_Selected_Containers);
		click(driver, Apply_to_Selected_Containers);
		
		Step_End(4, "select the container in DG tree ", test, test1);
		
		Step_Start(5, "click apply to selected container button", test, test1);
		
		waitForPopup(driver, popup_Message, Expected_DG_Creation_Popup);
		String Actual_DG_Creation_Popup = getText(driver, popup_Message);
		System.out.println("Autual DG Creation Popup : " + Actual_DG_Creation_Popup);

		if (Actual_DG_Creation_Popup.contains(Expected_DG_Creation_Popup)) {
			System.out.println("Matched || Expected popup message was : " + Expected_DG_Creation_Popup
					+ " || Actual popup message was : " + Actual_DG_Creation_Popup);
			Extent_pass(driver, "Matched || Expected popup message was : " + Expected_DG_Creation_Popup
					+ " || Actual popup message was : " + Actual_DG_Creation_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + Expected_DG_Creation_Popup
					+ " || Actual popup message was : " + Actual_DG_Creation_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Expected_DG_Creation_Popup
					+ " || Actual popup message was  : " + Actual_DG_Creation_Popup, test, test1);
		}
		click(driver, popup_Message_Ok_Button);
		Step_End(5, "click apply to selected container button", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
