package LRP_Finance_Receivable_Receipt_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Receivable_Receipt_RR19 extends Keywords {

	public void Receivable_Receipt_RR19(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_Receivable_Receipt_RR19";
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String receivable_Receipt_Module = Excel_data.get("receivable_Receipt_Module");
		String popup_Expected = Excel_data.get("popup_Expected");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Step_Start(1, "Navigate to receivable receipt module", test, test1);

		moduleNavigate(driver, receivable_Receipt_Module);

		Step_End(1, "Navigate to receivable receipt module", test, test1);

		Step_Start(2, "click on last record button", test, test1);

		waitForElement(driver, last_Record_Btn_RR);
		click(driver, last_Record_Btn_RR);

		Step_End(2, "click on last record button", test, test1);

		Step_Start(3, "then click on edit button", test, test1);
		waitForElement(driver, edit_Btn_RR);
		click(driver, edit_Btn_RR);

		Step_End(3, "then click on edit button", test, test1);

		Step_Start(4, "System should show the pop up validation as -Cannot edit", test, test1);

		waitForPopup(driver, popup_Message,popup_Expected);
		String popup_Actual = getText(driver, popup_Message);

		if (popup_Actual.equals(popup_Expected)) {
			
			System.out.println("Matched  || Expected Popup : After click on edit button System should be show the pop up validation as Cannot edit : "+popup_Actual+" || Actual  Popup : Click on edit button System is show the pop up validation as Cannot edit : "+popup_Expected);
			Extent_pass_New(driver,"Matched  ||Expected Popup : After click on edit button System should be show the pop up validation as Cannot edit : "+popup_Actual+" || Actual  Popup : Click on edit button System is show the pop up validation as Cannot edit  : "+popup_Expected, test, test1);

		} else {
			
			System.out.println("Not Matched  || Expected Popup : After click on edit button System should be show the pop up validation as Cannot edit : "+popup_Actual+" || Actual  Popup : Click on edit button System is show the pop up validation as  edit : "+popup_Expected);
			Extent_fail(driver,"Not Matched  ||Expected Popup : After click on edit button System should be show the pop up validation as Cannot edit : "+popup_Actual+" || Actual  Popup : Click on edit button System is show the pop up validation as  edit  : "+popup_Expected, test, test1);

		}

		Step_End(4, "System should show the pop up validation as -Cannot edit", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
