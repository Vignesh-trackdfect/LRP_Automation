package LRP_DG_Creation_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_DG_Creation_SC_002 extends Keywords {

	public void DG_Creation_SC_002(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		// Value are taken from excel sheet
		String testcase_Name = "TC_DG_Creation_SC_002";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Code = Excel_data.get("Agency_Code");
		
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String UN_No = Excel_data.get("UN_No");
		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");


		Extent_Start(testcase_Name, test, test1);
		
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		SwitchProfile(driver, Agency_Code);
		moduleNavigate(driver, DG_Creation_Module);
		newButton(driver);
		
		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		scrollElementToView(driver, DG_Container_Select);
		waitForElement(driver, DG_Container_Select);
		safeclick(driver, DG_Container_Select);
		
		Step_Start(4, "click multi apply  button ", test, test1);
		waitForElement(driver, Multiple_Apply_button);
		safeclick(driver, Multiple_Apply_button);
		
		Step_End(4, "click multi apply  button ", test, test1);

		waitForPopup(driver, popup_Message, Applied_Popup_Exp);
		String Actual_DG_Creation_container_Popup = getText(driver, popup_Message);
		System.out.println("Autual DG Creation container Popup : " + Actual_DG_Creation_container_Popup);

		if (Actual_DG_Creation_container_Popup.equals(Applied_Popup_Exp)) {
			System.out.println("Matched || Expected popup message was : " + Applied_Popup_Exp
					+ " || Actual popup message was : " + Actual_DG_Creation_container_Popup);
			Extent_pass(driver, "Matched || Expected popup message was : " + Applied_Popup_Exp
					+ " || Actual popup message was : " + Actual_DG_Creation_container_Popup, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + Applied_Popup_Exp
					+ " || Actual popup message was : " + Actual_DG_Creation_container_Popup);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Applied_Popup_Exp
					+ " || Actual popup message was  : " + Actual_DG_Creation_container_Popup, test, test1);
			
		}
		
		click(driver, popup_Message_Ok_Button);
		
		waitForElement(driver, DG_UN_number_Values_grid);
		String act_Un_number=getText(driver, DG_UN_number_Values_grid);
		
		if(act_Un_number.equals(UN_No)) {
			System.out.println("Matched || " + " Expected UN NO Should be display  : " + UN_No+ " || Actual UN NO is display : " + act_Un_number);
			Extent_pass(driver, "Matched || " + " Expected UN NO Should be display : " + UN_No+ " || Actual UN NO is display : " + act_Un_number, test, test1);
		}else{
			System.out.println("Not Matched || " + " Expected UN NO Should be display  : " + UN_No+ " || Actual UN NO is Not display : " + act_Un_number);
			Extent_fail(driver, "Not Matched || " + " Expected UN NO Should be display  : " + UN_No+ " || Actual UN NO is Not display : " + act_Un_number, test, test1);

	}
		
		Extent_completed(testcase_Name, test, test1);
}}
