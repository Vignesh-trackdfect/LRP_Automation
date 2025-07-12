package LRP_EMS_Integrations_Scripts;


import java.util.Map;


import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Scale_In_Out_Reference;

public class TC_Scale_In_TS_027_IP extends Keywords {

	public void addandremoveslab(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Scale_In_TS_027_IP";
		String Username = Excel_data.get("Username");// 1,2,4-6
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String contractnum = Excel_data.get("Contract_No");
		String Slab_CheckBox = Excel_data.get("Slab_CheckBox");
		String Reference_Type = Excel_data.get("Reference_Type");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Contract_Number_Search = Excel_data.get("Contract_Number_Search");
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
		
		waitForElement(driver, AContract_no_input);
		waitForElement(driver, AContractNumsearch);
		safeclick(driver, AContractNumsearch);
		waitForElement(driver, Ainputcontractnum);
		twoColumnSearchWindow(driver, Contract_Number_Search, Condition_Filter, contractnum);
		Step_Start(1, "Ensure system should allow user to select checkbox for slab''",test, test1);

		// before selecting the slab box

		waitForElement(driver, Slab_ChkBox);
		if (!isElementAccessible(driver, AslabboxADD)) {
			System.out.println("Expected Result is :Add button in slab should not be enable before selecting the slab box ||Actual Result is :Add button in slab is not  enabled before selecting the slab box");
			Extent_pass_New(driver, "Expected Result is :Add button in slab should not be enable before selecting the slab box ||Actual Result is :Add button in slab is not  enabled before selecting the slab box", test, test1);

		} else {
			System.out.println("Expected Result is :Add button in slab should not be enable before selecting the slab box ||Actual Result is :Add button in slab is  enabled before selecting the slab box");
			Extent_fail(driver, "Expected Result is :Add button in slab should not be enable before selecting the slab box ||Actual Result is :Add button in slab is  enabled before selecting the slab box", test, test1);
			
		}
		if (!isElementAccessible(driver, REMOVEBUTTON)) {
			System.out.println("Expected Result is :Remove button in slab should not be enable before selecting the slab box ||Actual Result is :Remove button in slab is not  enabled before selecting the slab box");
			Extent_pass_New(driver, "Expected Result is :Remove button in slab should not be enable before selecting the slab box ||Actual Result is :Remove button in slab is not  enabled before selecting the slab box", test, test1);

		} else {
			System.out.println("Expected Result is :Remove button in slab should not be enable before selecting the slab box ||Actual Result is :Remove button in slab is  enabled before selecting the slab box");
			Extent_fail(driver, "Expected Result is :Remove button in slab should not be enable before selecting the slab box ||Actual Result is :Remove button in slab is  enabled before selecting the slab box", test, test1);
			
		}
		Step_End(1, "Ensure system should allow user to select checkbox for slab''",test, test1);
		Step_Start(2, "Ensure that system should enable Add & remove button only when Slab checkbox is selected'",test, test1);
// After selecting the slab box

		waitForElement(driver, Slab_ChkBox);
		checkBox(driver, Slab_ChkBox, Slab_CheckBox);
		System.out.println("Slab box Status:" + Slab_CheckBox);
		
		
		
	
		
		
		// OPTION OF SELECTING THE CHECK BOX
		waitForElement(driver, Slab_ChkBox);
		if (isElementAccessible(driver, AslabboxADD)) {
			System.out.println("Expected Result is :Add button in the slab should be enable ||Actual Result is :Add button in the slab is enable");
			Extent_pass_New(driver, "Expected Result is :Add button in the slab should be enable ||Actual Result is :Add button in the slab is enable", test, test1);
		} else {
			System.out.println("Expected Result is :Add button in the slab should be enable ||Actual Result is :Add button in the slab is not enable");
			Extent_fail(driver, "Expected Result is :Add button in the slab should be enable ||Actual Result is :Add button in the slab is not enable", test, test1);
			
		}
		if (isElementAccessible(driver, REMOVEBUTTON)) {
			System.out.println("Expected Result is :Remove button in the slab should be enable ||Actual Result is :Remove button in the slab is enable");
			Extent_pass_New(driver, "Expected Result is :Remove button in the slab should be enable ||Actual Result is :Remove button in the slab is enable", test, test1);
		} else {
			System.out.println("Expected Result is :Remove button in the slab should be enable ||Actual Result is :Remove button in the slab is not enable");
			Extent_fail(driver, "Expected Result is :Remove button in the slab should be enable ||Actual Result is :Remove button in the slab is not enable", test, test1);
			

		}
		Step_End(2, "Ensure that system should enable Add & remove button only when Slab checkbox is selected'",test, test1);
		Extent_completed(testcase_Name, test, test1);
	}

}
