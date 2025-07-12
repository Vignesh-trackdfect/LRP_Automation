package LRP_EMS_Integrations_Scripts;


import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Scale_In_Out_Reference;

public class TC_Scale_In_TS_030_IP extends Keywords {

	public void Invalidcontractnumber(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		// Value are taken from excel sheet

		String testcase_Name = "TC_Scale_In_TS_030_IP";
		

		
	
		
		String Username = Excel_data.get("Username");// 1,2,4-6

		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String savedpopexp = Excel_data.get("PopUpforsaved");
		
		String Reference_Type = Excel_data.get("Reference_Type");
		
		String Contract_No = Excel_data.get("Contract_No");
		String Scale_Reference_no = Excel_data.get("Scale_Reference_no");
		String ReferenceType_Select =  String.format(Scale_In_Out_Reference.reference_type,Reference_Type); 
		Extent_Start(testcase_Name, test, test1);
		
		
		navigateUrl(driver, url);

		
		// LOGIN
		LRP_Login(driver, Username, Password);
		
		
		moduleNavigate(driver, Search);
		waitForElement(driver, Reference_Type_Field);
		safeclick(driver, Reference_Type_Field);
		
			
			waitForElement(driver, ReferenceType_Select);
			safeclick(driver, ReferenceType_Select);
			Step_Start(1, "Ensure system should allow user to enter scale-in ref",test, test1);
		// Entering Scalin reference
		if (!Scale_Reference_no.equals("")) {
			waitForElement(driver, AScale_in_ref_input);
			safeclick(driver, AScale_in_ref_input);
			sendKeys(driver, AScale_in_ref_input, Scale_Reference_no);
			safeclick(driver, ARemarks_Input);

		}
		Step_End(1, "Ensure system should allow user to enter scale-in ref",test, test1);
		Step_Start(2, "Ensure that system should validate if invalid contract is entered & clicked tab for Contract No. field",test, test1);
// Entering contract number

		waitForElement(driver, AContract_no_input);

		sendKeys(driver, AContract_no_input, Contract_No);
		enter(driver);
		Step_Start(3, " Ensure that system should validate as 'Invalid Supplier Reference'.",test, test1);
		waitForPopup(driver, Popup_Message, savedpopexp);
		String Actualpopmsg9 = getText(driver, Popup_Message);
		System.out.println(Actualpopmsg9);

		if (savedpopexp.equals(Actualpopmsg9)) {
			System.out.println("Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
					+ Actualpopmsg9);
			Extent_pass_New(driver, "Matched || " + " Expected popup is : " + savedpopexp + " || Actual popup is : "
					+ Actualpopmsg9, test, test1);
			
			Extent_call(test, test1, "**popup was shown as*** "+Actualpopmsg9);
		} else {
			System.out.println("Not matched || " + " Expected popup is : " + savedpopexp
					+ " || Actual popup is : " + Actualpopmsg9);
			Extent_fail(driver, "Not matched || " + " Expected popup is : " + savedpopexp
					+ " || Actual popup is : " + Actualpopmsg9, test, test1);
			
		}
		Step_End(2, "Ensure that system should validate if invalid contract is entered & clicked tab for Contract No. field",test, test1);
		Step_End(3, " Ensure that system should validate as 'Invalid Supplier Reference'.",test, test1);
		
		Extent_completed(testcase_Name, test, test1);
	}

}
