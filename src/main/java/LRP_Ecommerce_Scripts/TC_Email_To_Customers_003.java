package LRP_Ecommerce_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Email_To_Customers_003 extends Keywords {
	public void Email_To_Customers_003(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Email_To_Customers_003";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String AgencyName = Excel_data.get("AgencyName");
		String Subject_Input = Excel_data.get("Subject_Input");
		String Mail_content_Input = Excel_data.get("Mail_content_Input");
		String Mail_Sent_Popup_Exp = Excel_data.get("Mail_Sent_Popup_Exp");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		waitForElement(driver, Search_Input);
		sendKeys(driver, Search_Input, Module_Name);
		waitForElement(driver, ETC_Module_Click);
		click(driver, ETC_Module_Click);
		Step_Start(1, "Select the \"All Customers\" radio button", test, test1);
		waitForElement(driver, ETC_All_Customers_radioButton);
		click(driver, ETC_All_Customers_radioButton);

		Step_End(1, "Select the \"All Customers\" radio button", test, test1);

		Step_Start(2,
				"Ensure that the Customer Master Contacts have an online active status. Emails will be sent to all eligible customers.",
				test, test1);
		waitForElement(driver, ETC_subject_TextField);

		Step_End(2,
				"Ensure that the Customer Master Contacts have an online active status. Emails will be sent to all eligible customers.",
				test, test1);

		Step_Start(3, "Enter the required subject in the subject field", test, test1);
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
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("Not Matched  || Expected Mail Popup :" + Mail_Sent_Popup_Exp + "|| Actual Mail Popup :"
					+ mail_sent_PopupAct);
			Extent_fail(driver, "Not Matched  || Expected Mail Popup :" + Mail_Sent_Popup_Exp + "|| Actual Mail Popup :"
					+ mail_sent_PopupAct, test, test1);
		}

		Step_End(5, "Click the \"Send\" icon to send the email", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}