package LRP_Ecommerce_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import commonMethods.Keywords;



public class TC_Email_To_Customers_006 extends Keywords {
	public void Email_To_Customers_006(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Email_To_Customers_006";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");
		String Subject_Input = Excel_data.get("Subject_Input");
		String Mail_content_Input = Excel_data.get("Mail_content_Input");
		String Mail_Sent_Popup_Exp = Excel_data.get("Mail_Sent_Popup_Exp");
		String Email_Id_Input = Excel_data.get("Email_Id_Input");
		String Email_Id_Header = Excel_data.get("Email_Id_Header");
		String condition_Filter = Excel_data.get("condition_Filter");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		waitForElement(driver, Search_Input);
		sendKeys(driver, Search_Input, Module_Name);
		waitForElement(driver, ETC_Module_Click);
		click(driver, ETC_Module_Click);
		Step_Start(1, " Select the \"By customer\" radio button", test, test1);
		waitForElement(driver, ETC_By_Mail_RadioButton);
		click(driver, ETC_By_Mail_RadioButton);
		Step_End(1, " Select the \"By customer\" radio button", test, test1);

		Step_Start(2, "Select the customer in customer input box", test, test1);
		waitForElement(driver, ETC_Email_Plus_Button);
		click(driver, ETC_Email_Plus_Button);
		twoColumnSearchWindow(driver, Email_Id_Header, condition_Filter, Email_Id_Input);
		Step_End(2, "Select the customer in customer input box", test, test1);

		Step_Start(3, "Enter the required subject in the subject field", test, test1);
		waitForElement(driver, ETC_subject_TextField);
		sendKeys(driver, ETC_subject_TextField, Subject_Input);
		Step_End(3, "Enter the required subject in the subject field", test, test1);

		Step_Start(4, "Type the required message in the content box", test, test1);
		switchToFrame(driver, ETC_content_Frame);
		sendKeys(driver, ETC_Mail_Content_TF, Mail_content_Input);
		Step_End(4, "Type the required message in the content box", test, test1);

		switchToDefaultFrame(driver);
		Step_Start(5, "Click the \"Send\" icon to send the email", test, test1);
		waitForElement(driver, ETC_Send_Button);
		click(driver, ETC_Send_Button);

		waitForPopup(driver, popup_Message, Mail_Sent_Popup_Exp);
		String mail_sent_PopupAct = getText(driver, popup_Message);
		System.out.println("Mail Popup :" + mail_sent_PopupAct);
		if (Mail_Sent_Popup_Exp.trim().equals(mail_sent_PopupAct)) {
			System.out.println("Matched  || Expected Mail Popup :" + Mail_Sent_Popup_Exp + "|| Actual Mail Popup :"
					+ mail_sent_PopupAct);
			Extent_pass_New(driver, "Matched  || Expected Mail Popup :" + Mail_Sent_Popup_Exp + "|| Actual Mail Popup :"
					+ mail_sent_PopupAct, test, test1);
		} else {
			System.out.println("Not Matched  || Expected Mail Popup :" + Mail_Sent_Popup_Exp + "|| Actual Mail Popup :"
					+ mail_sent_PopupAct);
			Extent_fail(driver, "Not Matched  || Expected Mail Popup :" + Mail_Sent_Popup_Exp + "|| Actual Mail Popup :"
					+ mail_sent_PopupAct, test, test1);
		}
		Step_End(5, "Click the \"Send\" icon to send the email", test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Extent_completed(testcase_Name, test, test1);

	}
}
