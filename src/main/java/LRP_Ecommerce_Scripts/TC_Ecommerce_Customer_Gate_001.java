package LRP_Ecommerce_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecommerce_Customer_Gate_001 extends Keywords {

	public void Ecommerce_Customer_Gate_001(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecommerce_Customer_Gate_001";


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Module_Name = Excel_data.get("Module_Name");
		String GateName = Excel_data.get("GateName");
		String Filter_Headers = Excel_data.get("Filter_Headers");
		String User_Email = Excel_data.get("User_Email");
		String Website = Excel_data.get("Website");
		String EmailURL = Excel_data.get("EmailURL");
		String EmailPassword = Excel_data.get("EmailPassword");
		String Registraction_Confirmation = Excel_data.get("Registraction_Confirmation");
		String Agency_Gate = Excel_data.get("Agency_Gate");
		String User_Code = Excel_data.get("User_Code");
		String Click_Here_Link = Excel_data.get("Click_Here_Link");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		if (!AgencyName.equals("")) {
			SwitchProfile(driver, AgencyName);
		}

		moduleNavigate(driver, Module_Name);

		Step_Start(1, "Click 'Pending with Customer' on the Ecom Customer Gate", test, test1);

		formatLocatorClick(driver, ECG_GateSelection, GateName);

		Step_End(1, "Click 'Pending with Customer' on the Ecom Customer Gate", test, test1);

		Step_Start(2, "The registered customer details will be displayed", test, test1);

		reArrangeAG_GridColumnsNew(driver, AG_Grid_Columns_Button_DW, Filter_Headers);

		waitForElement(driver, ECG_GridFilter);
		click(driver, ECG_GridFilter);

		waitForElement(driver, ECG_UserEmail_Filter);
		sendKeys(driver, ECG_UserEmail_Filter, User_Email);

		if (!User_Code.isEmpty()) {

			waitForElement(driver, ECG_CustomerCode_Filter);
			sendKeys(driver, ECG_CustomerCode_Filter, User_Code);

		}

		waitForDisplay(driver, ECG_Grid_data1);
		if (isdisplayed(driver, ECG_Grid_data1)) {

			System.out.println(
					"Expected result is : The customer details should be available in the Pending with Customer|| Actual result is : The customer details are available in the Pending with Customer");
			Extent_pass_New(driver,
					"Expected result is : The customer details should be available in the Pending with Customer|| Actual result is : The customer details are available in the Pending with Customer",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : The customer details should be available in the Pending with Customer|| Actual result is : The customer details are not available in the Pending with Customer");
			Extent_fail(driver,
					"Expected result is : The customer details should be available in the Pending with Customer|| Actual result is : The customer details are not available in the Pending with Customer",
					test, test1);

		}

		Step_End(2, "The registered customer details will be displayed", test, test1);

		Step_Start(3, "An email will be received from the user's mail ID", test, test1);

		if(Click_Here_Link.equals("")) {
		Email_login(driver, Website, EmailURL, User_Email, EmailPassword);

		if (Website.equals("Outlook")) {

			if (isdisplayed(driver, Outlook_VerficiationEmail)) {

				System.out.println(
						"Expected result is : User should get the verification email  || Actual result is : User got the verification email");
				Extent_pass_New(driver,
						"Expected result is : User should get the verification email  || Actual result is : User got the verification email",
						test, test1);
			} else {
				System.out.println(
						"Expected result is : User should get the verification email  || Actual result is : User did not got the verification email");
				Extent_fail(driver,
						"Expected result is : User should get the verification email  || Actual result is : User did not got the verification email",
						test, test1);
			}

			waitForElement(driver, Outlook_VerficiationEmail);
			click(driver, Outlook_VerficiationEmail);

		} else if (Website.equals("Gmail")) {

			if (isdisplayed(driver, Gmail_VerficiationEmail)) {

				System.out.println(
						"Expected result is : User should get the verification email  || Actual result is : User got the verification email");
				Extent_pass_New(driver,
						"Expected result is : User should get the verification email  || Actual result is : User got the verification email",
						test, test1);
			} else {
				System.out.println(
						"Expected result is : User should get the verification email  || Actual result is : User did not got the verification email");
				Extent_fail(driver,
						"Expected result is : User should get the verification email  || Actual result is : User did not got the verification email",
						test, test1);
			}

			waitForElement(driver, Gmail_VerficiationEmail);
			click(driver, Gmail_VerficiationEmail);
		}

		Step_End(3, "An email will be received from the user's mail ID", test, test1);

		Step_Start(4,
				"When the user clicks the 'Click Here' link in the email, the record will move from 'Pending with Customer to Pending with Agency'",
				test, test1);

		if (Website.equals("Outlook")) {

			waitForElement(driver, Outlook_VerficiationLink);
			click(driver, Outlook_VerficiationLink);

		} else if (Website.equals("Gmail")) {

			waitForElement(driver, Gmail_VerficiationLink);
			click(driver, Gmail_VerficiationLink);
			switchToNextTab(driver);

		}

		}else {
			navigateUrl_NewTab(driver, Click_Here_Link);
		}
		waitForElement(driver, Confirmation_page);
		String Confirmation_Message = getText(driver, Verification_Message_Text).trim();

		if (Confirmation_Message.contains(Registraction_Confirmation.trim())) {

			System.out.println("Matched || Expected Message : "+Registraction_Confirmation+" || Actual Message : "+Confirmation_Message);
			Extent_pass_New(driver,"Matched || Expected Message : "+Registraction_Confirmation+" || Actual Message : "+Confirmation_Message,
					test, test);
		} else {

			System.out.println("Not Matched || Expected Message : "+Registraction_Confirmation+" || Actual Message : "+Confirmation_Message);
			Extent_fail(driver,"Not Matched || Expected Message : "+Registraction_Confirmation+" || Actual Message : "+Confirmation_Message,
					test, test);
		}

		switchtotab(driver, 0);

		formatLocatorClick(driver, ECG_GateSelection, Agency_Gate);

		reArrangeAG_GridColumnsNew(driver, AG_Grid_Columns_Button_DW, Filter_Headers);

		waitForElement(driver, ECG_GridFilter);
		click(driver, ECG_GridFilter);

		waitForElement(driver, ECG_UserEmail_Filter);
		sendKeys(driver, ECG_UserEmail_Filter, User_Email);

		if (!User_Code.isEmpty()) {

			waitForElement(driver, ECG_CustomerCode_Filter);
			sendKeys(driver, ECG_CustomerCode_Filter, User_Code);

		}

		waitForDisplay(driver, ECG_Grid_data1);
		if (isdisplayed(driver, ECG_Grid_data1)) {

			System.out.println(
					"Expected result is : The custome gate should be change dto pending with customer to Pending with Agency || Actual result is : The customer status was changed to Pending with Customer to Pending with Agency");
			Extent_pass_New(driver,
					"Expected result is : The custome gate should be change dto pending with customer to Pending with Agency || Actual result is : The customer status was changed to Pending with Customer to Pending with Agency",
					test, test1);
		} else {

			System.out.println(
					"Expected result is : The custome gate should be change dto pending with customer to Pending with Agency || Actual result is : The customer status was not changed to Pending with Customer to Pending with Agency");
			Extent_fail(driver,
					"Expected result is : The custome gate should be change dto pending with customer to Pending with Agency || Actual result is : The customer status was not changed to Pending with Customer to Pending with Agency",
					test, test1);

		}

		Step_End(4,
				"When the user clicks the 'Click Here' link in the email, the record will move from 'Pending with Customer to Pending with Agency'",
				test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
