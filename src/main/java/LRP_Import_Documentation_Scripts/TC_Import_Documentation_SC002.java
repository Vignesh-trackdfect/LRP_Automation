package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Documentation_SC002 extends Keywords{
	public void Import_Documentation_SC002(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testCaseName="TC_Import_Documentation_SC002";
		

		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String AgencyUser =Excel_data.get("AgencyUser");
		String New_Import_Documentation =Excel_data.get("New_Import_Documentation");
		String moduleImportDoc = Excel_data.get("moduleImportDoc");


		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver,url);

	
		//Login
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
//		Switch the Profile
		Step_Start(1, "Switch to agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency.", test, test1);
		
		Step_Start(2, "Open the import documentation module.", test, test1);
		moduleNavigate(driver, moduleImportDoc);
		Step_End(2, "Open the import documentation module.", test, test1);
	
		//Vignesh-> As discussed with Suresh on 16_04_2025, I have Removed the (Step 3) Codes for validating all the Toolbar functions accessiblity
		
		Step_Start(4, "Click the Home button.", test, test1);		
		waitForDisplay(driver, NewButton_ToolBar);
		if(IsElementEnabled(driver, NewButton_ToolBar)) {
			click(driver, NewButton_ToolBar);
			Step_End(4, "Click the Home button.", test, test1);
			Step_Start(5,"The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.",
					test, test1);

			waitForPopup(driver, popup_Message, New_Import_Documentation);
			String new_import_documentation = getText(driver, popup_Message);
			if (new_import_documentation.equals(New_Import_Documentation)) {
				System.out.println("Matched || Expected Pop up : " + new_import_documentation + " || Actual Pop up : "
						+ New_Import_Documentation);
				Extent_pass_New(driver, "Matched || Expected Pop up : " + new_import_documentation + " || Actual Pop up : "
						+ New_Import_Documentation, test, test1);
				
			} else {
				System.out.println("Not Matched || Expected Pop up : " + new_import_documentation + " || Actual Pop up : "
						+ New_Import_Documentation);
				Extent_fail(driver, "Not Matched || Expected Pop up : " + new_import_documentation + " || Actual Pop up : "
						+ New_Import_Documentation, test, test1);
				
			}
			Step_End(5,
					"The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.",
					test, test1);
			
			Step_Start(6, "Click the Yes button.", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(6, "Click the Yes button.", test, test1);			
		}
		// Verifying Service Input is Enabled	
		Step_Start(7, "The Service, POL search field, all dropdown fields, and Show BL's button are enabled.", test, test1);		 
		waitForElement(driver, ServiceInput_IMD);
		if(IsElementEnabled(driver, ServiceInput_IMD)) {
			System.out.println("Expected Result : Service input Should be Enabled || Actual Result : Service input is Enabled");
			Extent_pass_New(driver, "Expected Result : Service input Should be Enabled || Actual Result : Service input is Enabled", test, test1);
		}else {
			System.out.println("Expected Result : Service input Should be Enabled || Actual Result : Service input is not Enabled");
			Extent_fail(driver, "Expected Result : Service input Should be Enabled || Actual Result : Service input is not Enabled", test, test1);
		}

		// Verifying POL Input is Enabled		
		waitForElement(driver, POLInput);
		if(IsElementEnabled(driver, POLInput)) {
			System.out.println("Expected Result : POL input Should be Enabled || Actual Result : POL input is Enabled");
			Extent_pass_New(driver, "Expected Result : POL input Should be Enabled || Actual Result : POL input is Enabled", test, test1);
		}else {
			System.out.println("Expected Result : POL input Should be Enabled || Actual Result : POL input is not Enabled");
			Extent_fail(driver, "Expected Result : POL input Should be Enabled || Actual Result : POL input is not Enabled", test, test1);
		}
		// Verifying POL Search button is Enabled		
		waitForElement(driver, POLSearch);
		if(IsElementEnabled(driver, POLSearch)) {
			System.out.println("Expected Result : POL Search Should be Enabled || Actual Result : POL Search is Enabled");
			Extent_pass_New(driver, "Expected Result :POL Search Should be Enabled || Actual Result : POL Search is Enabled", test, test1);
		}else {
			System.out.println("Expected Result : POL Search Should be Enabled || Actual Result : POL Search is not Enabled");
			Extent_fail(driver, "Expected Result : POL Search Should be Enabled || Actual Result : POL Search is not Enabled", test, test1);
		}

		// Verifying 1st All Drop down is Enabled		
		waitForElement(driver, AllDD_1);
		if(IsElementEnabled(driver, AllDD_1)) {
			System.out.println("Expected Result : BL Type 'ALL' Button 1 Should be Enabled || Actual Result : BL Type 'ALL' Button 1 is Enabled");
			Extent_pass_New(driver, "Expected Result : BL Type 'ALL' Button 1 Should be Enabled || Actual Result : BL Type 'ALL' Button 1 is Enabled", test, test1);
		}else {
			System.out.println("Expected Result : BL Type 'ALL' Button 1 Should be Enabled || Actual Result : BL Type 'ALL' Button 1 is not Enabled");
			Extent_fail(driver, "Expected Result : BL Type 'ALL' Button 1 Should be Enabled || Actual Result : BL Type 'ALL' Button 1 is not Enabled", test, test1);
		}

		// Verifying 2nd All Drop down is Enabled		
		waitForElement(driver, AllDD_2);
		if(IsElementEnabled(driver, AllDD_2)) {
			System.out.println("Expected Result : BL Type 'ALL' Button 2 Should be Enabled || Actual Result : BL Type 'ALL' Button 2 is Enabled");
			Extent_pass_New(driver, "Expected Result : BL Type 'ALL' Button 2 Should be Enabled || Actual Result : BL Type 'ALL' Button 2 is Enabled", test, test1);
		}else {
			System.out.println("Expected Result : BL Type 'ALL' Button 2 Should be Enabled || Actual Result : BL Type 'ALL' Button 2 is not Enabled");
			Extent_fail(driver, "Expected Result : BL Type 'ALL' Button 2 Should be Enabled || Actual Result : BL Type 'ALL' Button 2 is not Enabled", test, test1);
		}

		// Verifying Show button is enabled		
		waitForElement(driver, Show_BL_Button);
		if(IsElementEnabled(driver, Show_BL_Button)) {
			System.out.println("Expected Result : Show BL button Should be Enabled || Actual Result : Show BL button is Enabled");
			Extent_pass_New(driver, "Expected Result : Show BL button Should be Enabled || Actual Result : Show BL button is Enabled", test, test1);
		}else {
			System.out.println("Expected Result : Show BL button Should be Enabled || Actual Result : Show BL button is not Enabled");
			Extent_fail(driver, "Expected Result : Show BL button Should be Enabled || Actual Result : Show BL button is not Enabled", test, test1);
		}
		Step_End(7, "The Service, POL search field, all dropdown fields, and Show BL's button are enabled.", test, test1);
		Extent_completed(testCaseName, test, test1);
	}

}	
