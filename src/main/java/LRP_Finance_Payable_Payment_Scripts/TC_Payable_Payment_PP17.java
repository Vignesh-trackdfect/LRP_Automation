package LRP_Finance_Payable_Payment_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Payable_Payment_PP17 extends Keywords{
	
	public void Payable_Payment_PP17(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Payable_Payment_PP17";
		
		
		

		
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Payable_Payment_Module = Excel_data.get("Payable_Payment_Module");
		String GlobalSearchFilterOption_PPT = Excel_data.get("GlobalSearchFilterOption_PPT");
		String Condition = Excel_data.get("Condition");
		String Payable_Payment_Popup = Excel_data.get("Payable_Payment_Popup");
		String Payable_Payment_Number = Excel_data.get("Payable_Payment_Number");
		
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, Username, Password);

		
		moduleNavigate(driver, Payable_Payment_Module);

		Step_Start(1, "Click Global search ,serach the payable payment  no", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		
		globalValueSearchWindow(driver, Condition, GlobalSearchFilterOption_PPT, Payable_Payment_Number, "", "", "", "");
		

		
		Step_End(2, "Select the transactions.", test, test1);
		
		Step_Start(3, "Selected payment appears in payable payment screen", test, test1);
		
		waitForElement(driver, Payment_No_TF_PPT);
		String Payment_No=getAttribute(driver, Payment_No_TF_PPT, "value");
		
		if(Payable_Payment_Number.equals(Payment_No)) {
			
			System.out.println("Matched  || Payment Number Retrived : "+Payable_Payment_Number+" || Payment Number in Payable Payment Screen : "+Payment_No);
			Extent_pass_New(driver,"Matched  || Payment Number Retrived : "+Payable_Payment_Number+" || Payment Number in Payable Payment Screen : "+Payment_No, test, test1);
			
		} else {
			
			System.out.println("Not Matched  || Payment Number Retrived : "+Payable_Payment_Number+" || Payment Number in Payable Payment Screen : "+Payment_No);
			Extent_fail(driver,"Not Matched  || Payment Number Retrived : "+Payable_Payment_Number+" || Payment Number in Payable Payment Screen : "+Payment_No, test, test1);
		}
		
		Step_End(3, "Selected payment appears in payable payment screen", test, test1);
		
		Step_Start(4, "Click edit on toolbar", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		Step_End(4, "Click edit on toolbar", test, test1);
		
		
		Step_Start(5, "System should show the pop up validation as Cannot edit", test, test1);
		
	   waitForPopup(driver, popup_Message, Payable_Payment_Popup);
		String Popup=getText(driver, popup_Message);
		
		if(Payable_Payment_Popup.equals(Popup)) {
			
			System.out.println("Matched  || Expected Popup : After click on edit button System should be show the pop up validation as Cannot edit : "+Payable_Payment_Popup+" || Actual  Popup : Click on edit button System is show the pop up validation as Cannot edit : "+Popup);
			Extent_pass_New(driver,"Matched  ||Expected Popup : After click on edit button System should be show the pop up validation as Cannot edit : "+Payable_Payment_Popup+" || Actual  Popup : Click on edit button System is show the pop up validation as Cannot edit  : "+Popup, test, test1);
		    click(driver, popup_Message_Ok_Button);
		
		} else {
			
			System.out.println("Not Matched  || Expected Popup : After click on edit button System should be show the pop up validation as Cannot edit : "+Payable_Payment_Popup+" || Actual  Popup : Click on edit button System is show the pop up validation as  edit : "+Popup);
			Extent_fail(driver,"Not Matched  ||Expected Popup : After click on edit button System should be show the pop up validation as Cannot edit : "+Payable_Payment_Popup+" || Actual  Popup : Click on edit button System is show the pop up validation as  edit  : "+Popup, test, test1);
		   Step_End(5, "System should show the pop up validation as Cannot edit", test, test1);
		
		}
		Extent_completed(testcase_Name, test, test1);
		
		
	}

}
