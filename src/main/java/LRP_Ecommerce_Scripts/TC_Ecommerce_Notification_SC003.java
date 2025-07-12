package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Notification_SC003 extends Keywords {

	public void Ecommerce_Notification_SC003(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Notification_SC003";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Ecomm_Notification_Module = Excel_data.get("Ecomm_Notification_Module");

		String Select_Customer_Type = Excel_data.get("Select_Customer_Type");
		String Type_Message = Excel_data.get("Type_Message");

		String Ecomm_Success_Notification = Excel_data.get("Ecomm_Success_Notification");
		String Ecommerce_Url = Excel_data.get("Ecommerce_Url");
		String User_name_Value_Ecommerce = Excel_data.get("User_name_Value_Ecommerce");
		String Password_Value_Ecommerce = Excel_data.get("Password_Value_Ecommerce");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyName);
		moduleNavigate(driver, Ecomm_Notification_Module);

		Step_Start(1, "Select the \"All Customers\" radio button.", test, test1);

		String CustomerType_Select = String.format(Select_Customer_Option_EN, Select_Customer_Type);
		waitForElement(driver, CustomerType_Select);
		click(driver, CustomerType_Select);
		Step_End(1, "Select the \"All Customers\" radio button.", test, test1);

		Step_Start(3, "Enter the required message in the message field.", test, test1);
		waitForElement(driver, Message_Input_Area_EN);
		sendKeys(driver, Message_Input_Area_EN, Type_Message);
		Step_End(3, "Enter the required message in the message field.", test, test1);

		Step_Start(4, "Click the \"Send\" icon to send the notification.  ", test, test1);
		waitForElement(driver, Send_Button_EN);
		click(driver, Send_Button_EN);
		Step_End(4, "Click the \"Send\" icon to send the notification.   ", test, test1);

		Step_Start(5, "Notification will be sent to the customer based on the eCommerce system ", test, test1);
		waitForPopup(driver, popup_Message, Ecomm_Success_Notification);
		String Act_Popup = getText(driver, popup_Message);
		if (Act_Popup.equals(Ecomm_Success_Notification)) {
			System.out.println("After Send Message, Popup Matched || Expected : " + Ecomm_Success_Notification
					+ " || Actual : " + Act_Popup);
			Extent_pass_New(driver, "After Send Message, Popup Matched || Expected : " + Ecomm_Success_Notification
					+ " || Actual : " + Act_Popup, test, test1);
		} else {
			System.out.println("After Send Message, Popup Matched || Expected : " + Ecomm_Success_Notification
					+ " || Actual : " + Act_Popup);
			Extent_fail(driver, "After Send Message, Popup Matched || Expected : " + Ecomm_Success_Notification
					+ " || Actual : " + Act_Popup, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_Start(2,
				"Ensure that the Customer Master Contacts have an online active status. Notification will be sent to all eligible customers.",
				test, test1);

		navigateUrl_NewTab(driver, Ecommerce_Url);

		waitForElement(driver, EN_Login_button);
		click(driver, EN_Login_button);

		waitForElement(driver, EN_User_Name);
		sendKeys(driver, EN_User_Name, User_name_Value_Ecommerce);

		waitForElement(driver, EN_Password);
		sendKeys(driver, EN_Password, Password_Value_Ecommerce);

		waitForElement(driver, EN_Login_Button);
		click(driver, EN_Login_Button);

		waitForElementLoading(driver, En_Nofification);
		click(driver, En_Nofification);

		waitForElement(driver, EN_Nofitication_Option);
		String value = getText(driver, EN_Nofitication_Option);

		if (Type_Message.equals(value)) {
			System.out.println("Matched || Expected notification was : " + Type_Message
					+ " || Actual notification was : " + value);
			Extent_pass_New(driver,
					"Matched || Expected notification was: " + Type_Message + " || Actual notification was : " + value,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected notification was : " + Type_Message
					+ " || Actual notification was : " + value);
			Extent_fail(driver, "Not Matched || Expected notification was: " + Type_Message
					+ " || Actual notification was : " + value, test, test1);
		}

		Step_End(2,
				"Ensure that the Customer Master Contacts have an online active status. Notification will be sent to all eligible customers.",
				test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
