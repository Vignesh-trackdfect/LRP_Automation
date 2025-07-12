package LRP_EMS_Integrations_Scripts;


import java.util.Map;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Scale_In_Out_Reference;

public class TC_Scale_In_TS_028_IP extends Keywords {

	public void toslablesserthanfromslab(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name = "TC_Scale_In_TS_028_IP";
		String Username = Excel_data.get("Username");// 1,2,4-6
		String Password = Excel_data.get("Password");
		String Search = Excel_data.get("Search_input");
		String contractnum = Excel_data.get("Contract_No");
		String Slab_CheckBox = Excel_data.get("Slab_CheckBox");
		String Reference_Type = Excel_data.get("Reference_Type");
		String TODAYS = Excel_data.get("TODAYS");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String perdiem = Excel_data.get("Per_Diem");
		String PopUpforsaved = Excel_data.get("PopUpforsaved");
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
		waitForElement(driver, Slab_ChkBox);
		checkBox(driver, Slab_ChkBox, Slab_CheckBox);

		// OPTION OF SELECTING THE CHECK BOX
		waitForElement(driver, AslabboxADD);
		if (isElementAccessible(driver, AslabboxADD)) {
		
			waitForElement(driver, AslabboxADD);
			safeclick(driver, AslabboxADD);
			waitForElement(driver, AslabboxADDTodays);
		
			doubleClick(driver, AslabboxADDTodays);
		
			Actionsendkeys(driver, AslabboxADDTodays, TODAYS);
			
			waitForElement(driver, AslabboxADDperdiem);
			
			doubleClick(driver, AslabboxADDperdiem);
		
			Actionsendkeys(driver, APer_Diem_Input, perdiem);
			waitForElement(driver, AScale_in_pickup_charges);
			safeclick(driver, AScale_in_pickup_charges);
			waitForElement(driver, AslabboxADD);
			safeclick(driver, AslabboxADD);
		} else {
			System.out.println("Slab box was not selected");
		}
		Step_End(1, "Ensure system should allow user to select checkbox for slab''",test, test1);
		Step_Start(2, "Ensure that system should validate when user try to add To slab lesser then From slab'",test, test1);
		Step_Start(3, "Ensure that system should validate as 'Enter the To Slab greater than From Slab for the Sz./Tp'.",test, test1);
		
		waitForPopup(driver, Popup_Message, PopUpforsaved);
		String Actualpopmsg7 = getText(driver, Popup_Message);
		System.out.println(Actualpopmsg7);
		if (PopUpforsaved.equals(Actualpopmsg7)) {
			System.out.println("Matched || " + " Expected popup is : " + PopUpforsaved + " || Actual popup is : "
					+ Actualpopmsg7);
			Extent_pass_New(driver, "Matched || " + " Expected popup is : " + PopUpforsaved + " || Actual popup is : "
					+ Actualpopmsg7, test, test1);
			Extent_call(test, test1, "**popup was shown as*** "+Actualpopmsg7);
		} else {
			System.out.println("Not matched || " + " Expected popup is : " + PopUpforsaved
					+ " || Actual popup is : " + Actualpopmsg7);
			Extent_fail(driver, "Not matched || " + " Expected popup is : " + PopUpforsaved
					+ " || Actual popup is : " + Actualpopmsg7, test, test1);
			
		}
		Step_End(2, "Ensure that system should validate when user try to add To slab lesser then From slab'",test, test1);
		Step_End(3, "Ensure that system should validate as 'Enter the To Slab greater than From Slab for the Sz./Tp'.",test, test1);
		Extent_completed(testcase_Name, test, test1);
		
		
	}

}
