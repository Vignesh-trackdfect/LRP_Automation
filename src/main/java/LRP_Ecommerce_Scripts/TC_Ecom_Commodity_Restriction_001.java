package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Ecom_Commodity_Restriction_001 extends Keywords {

	public void Ecom_Commodity_Restriction_001(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Ecom_Commodity_Restriction_001";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Module_Name = Excel_data.get("Module_Name");
		String agencyUser = Excel_data.get("AgencyUser");
		String Commudity_Header = Excel_data.get("Commudity_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String Commudity_Header_value = Excel_data.get("Commudity_Header_value");
		String Commodity_Code = Excel_data.get("Commodity_Code");
		String Commodity_Name = Excel_data.get("Commodity_Name");
		String Saved_popup_Message = Excel_data.get("Saved_popup_Message");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);
		SwitchProfile(driver, agencyUser);

		Step_Start(1, " Enter Ecom commodity restriction in the Module Search to access the module", test, test1);

		moduleNavigate(driver, Module_Name);

		Step_End(1, " Enter Ecom commodity restriction in the Module Search to access the module", test, test1);

		Step_Start(2, "Line and Agency users can access the  Ecom commodity restriction", test, test1);

		waitForElement(driver, ECR_Commodity_Code);
		click(driver, ECR_Commodity_Code);

		waitForElement(driver, ECR_Commodity_Code_Search_Button);
		click(driver, ECR_Commodity_Code_Search_Button);

		twoColumnMultipleSearchWindow(driver, Commudity_Header, Filter_Condition, Commudity_Header_value);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Saved_popup_Message);
		String Act_popup = getText(driver, Popup_Message);

		if (Act_popup.equals(Saved_popup_Message)) {
			System.out.println("Matched || Expected Popup Message was : " + Saved_popup_Message
					+ " || Actual Popup Message was : " + Act_popup);
			Extent_pass_New(driver, "Matched || Expected Popup Message was : " + Saved_popup_Message
					+ " || Actual Popup Message was : " + Act_popup, test, test1);
		} else {
			System.out.println("NotMatched || Expected Popup Message was : " + Saved_popup_Message
					+ " || Actual Popup Message was : " + Act_popup);
			Extent_fail(driver, "NotMatched || Expected Popup Message was : " + Saved_popup_Message
					+ " || Actual Popup Message was : " + Act_popup, test, test1);
		}

		waitForElement(driver, EC_HLC_Refresh_Button);
		click(driver, EC_HLC_Refresh_Button);

		waitForElement(driver, ECR_Commodity_Code_Input_Field);
		sendKeys(driver, ECR_Commodity_Code_Input_Field, Commodity_Code);

		waitForElement(driver, ECR_Commodity_Name_Input_Field);
		sendKeys(driver, ECR_Commodity_Name_Input_Field, Commodity_Name);

		waitForElement(driver, ECR_Grid_Commodity_Code);
		String Act_Commodity_code = getText(driver, ECR_Grid_Commodity_Code);

		if (Act_Commodity_code.equals(Commodity_Code)) {
			System.out.println("Matched || Expected commodity code was : " + Commodity_Code
					+ " || Actual commodity code was : " + Act_Commodity_code);
			Extent_pass_New(driver,
					"Matched || Expected Value was: " + Commodity_Code + " || Actual Value was : " + Act_Commodity_code,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected commodity code was : " + Commodity_Code
					+ " || Actual commodity code was : " + Act_Commodity_code);
			Extent_fail(driver, "Not Matched || Expected commodity code was: " + Commodity_Code
					+ " || Actual commodity code was : " + Act_Commodity_code, test, test1);
		}

		waitForElement(driver, ECR_Grid_Commodity_Name);
		String Act_Commodity_Name = getText(driver, ECR_Grid_Commodity_Name);

		if (Act_Commodity_Name.equals(Commodity_Name)) {
			System.out.println("Matched || Expected commodity Name was : " + Commodity_Name
					+ " || Actual commodity Name was : " + Act_Commodity_Name);
			Extent_pass_New(driver,
					"Matched || Expected Value was: " + Commodity_Name + " || Actual Value was : " + Act_Commodity_Name,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected commodity Name was : " + Commodity_Name
					+ " || Actual commodity Name was : " + Act_Commodity_Name);
			Extent_fail(driver, "Not Matched || Expected commodity Name was: " + Commodity_Name
					+ " || Actual commodity Name was : " + Act_Commodity_Name, test, test1);
		}


		Step_End(2, "Line and Agency users can access the  Ecom insurance acess.", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}