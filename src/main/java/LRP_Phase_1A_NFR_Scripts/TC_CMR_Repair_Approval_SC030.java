package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CMR_Repair_Approval_SC030 extends Keywords {

	public void CMR_Repair_Approval_SC030(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_CMR_Repair_Approval_SC030";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Repair_Approval__Module = Excel_data.get("Repair_Approval__Module");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Search_Name_Header = Excel_data.get("Search_Name_Header");
		String Search_Name_Field = Excel_data.get("Search_Name_Field");
		String Template_Name_Input = Excel_data.get("Template_Name_Input");
		String Excepted_Template_Popup = Excel_data.get("Excepted_Template_Popup");

		String New_Template_head = String.format(New_Template_Header, Template_Name_Input);

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Open the application", test, test1);

		LRP_Login(driver, username, pass_word);

		verifyMainMenu(driver);

		Step_End(1, "Open the application", test, test1);

		Step_Start(2, "Go to the Repair approval Screen..", test, test1);

		moduleNavigate(driver, Repair_Approval__Module);

		Step_End(2, " Go to the Repair approval Screen.", test, test1);

		Step_Start(3, "Click on global search and retrive the data", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow(driver, Search_Condition1, Search_Name_Header, Search_Name_Field, "", "", "", "");

		Step_End(3, "Click on global search and retrive the data", test, test1);

		Step_Start(4, "Pin column on ag-grid ex: ISO damage.", test, test1);

		dragAndDrop(driver, CMR_Iso_damage_Column, Click_And_Drag_Field);

		Step_End(4, "Pin column on ag-grid ex: ISO damage", test, test1);

		Step_Start(5, "Click on save template and Enter the name for the template.", test, test1);

		waitForElement(driver, CMR_Main_Grid_Btn);
		click(driver, CMR_Main_Grid_Btn);

		waitForElement(driver, CMR_Save_Template_Btn);
		click(driver, CMR_Save_Template_Btn);

		waitForElement(driver, CMR_Template_Name_Field);
		sendKeys(driver, CMR_Template_Name_Field, Template_Name_Input);

		waitForElement(driver, CMR_Template_Save);
		click(driver, CMR_Template_Save);

		Step_End(5, "Click on save template and Enter the name for the template.", test, test1);

		Step_Start(6, "Verify pop-up like template saved successfully.", test, test1);

		waitForPopup(driver, Popup_Message, Excepted_Template_Popup);

		String Actual_Template_popup = getText(driver, Popup_Message);
		System.out.println("Actual_Template_popup is :" + Actual_Template_popup);

		if (Excepted_Template_Popup.equals(Actual_Template_popup)) {

			System.out.println("Matched || Excepted :Template saved popup is : " + Excepted_Template_Popup
					+ " Actual || template saved popup we get is :" + Actual_Template_popup);

			Extent_pass_New(driver, "Matched || Excepted : Template saved popup is : " + Excepted_Template_Popup
					+ " Actual || template saved popup we get is :" + Actual_Template_popup, test, test1);

		} else {

			System.out.println("NotMatched || Excepted :Template saved popup is : " + Excepted_Template_Popup
					+ " Actual || template saved popup we get is :" + Actual_Template_popup);

			Extent_fail(driver, "NotMatched || Excepted :Template saved popup is : " + Excepted_Template_Popup
					+ " Actual || template saved popup we get is :" + Actual_Template_popup, test, test1);

		}

		Step_End(6, "Verify pop-up like template saved successfully", test, test1);

		Step_Start(7, "Close the module and open again.", test, test1);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		Step_End(7, "Close the module and open again.", test, test1);

		Step_Start(8, "Verify the result showing same template..", test, test1);

		moduleNavigate(driver, Repair_Approval__Module);
		
		waitForElement(driver, New_Template_head);
		String Extract_Template_Name = getText(driver, New_Template_head);

		if (isdisplayed(driver, New_Template_head)) {

			System.out.println("Matched || Excepted : New template which we added  before is : " + Template_Name_Input
					+ "Actual || template name which we get is :" + Extract_Template_Name);

			Extent_pass_New(driver, "Matched || Excepted : New template which we added  before is : " + Template_Name_Input
					+ "Actual || template name which we get is :" + Extract_Template_Name, test, test1);

		} else {

			System.out.println(" NotMatched || Excepted : New template which we added  before is : " + Template_Name_Input
					+ "Actual || template name which we get is :" + Extract_Template_Name);

			Extent_fail(driver, "NotMatched || Excepted : New template which we added  before is : " + Template_Name_Input
					+ "Actual || template name which we get is :" + Extract_Template_Name, test, test1);

		}

		Step_End(8, "Verify the result showing same template.", test, test1);

		Extent_completed(testCaseName, test, test1);
	}
}
