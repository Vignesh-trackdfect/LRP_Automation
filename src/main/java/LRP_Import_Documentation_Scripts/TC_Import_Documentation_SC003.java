package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Import_Documentation_SC003 extends Keywords{
	public void Import_Documentation_SC003(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testCaseName="TC_Import_Documentation_SC003";

		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String AgencyUser =Excel_data.get("AgencyUser");
		String moduleImportDoc = Excel_data.get("moduleImportDoc");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Portcode = Excel_data.get("Portcode");
		String New_Import_Documentation =Excel_data.get("New_Import_Documentation");


		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver,url);

		
		//		Login
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
		
		//Vignesh-> As discussed with Suresh on 17_04_2025, I have Removed the (Step 7) Codes for validating the Service, POL search field, all dropdown fields, and Show BL's button are enabled.

		Step_Start(8, "Enter the valid service.", test, test1);
		Step_Start(9, "Populate the vessel details based on the provided service..", test, test1);
		
		waitForElement(driver, ServiceInput_IMD);
		sendKeys(driver, ServiceInput_IMD, Service);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
		waitForElement(driver, grid_voyagecode_IMP_DOC);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
		waitForElement(driver, grid_bound_IMP_DOC);
		sendKeys(driver, grid_bound_IMP_DOC, Bound);
		
		if(!Portcode.equals("")) {
			waitForElement(driver, grid_scroll);
			scrollUsingElement(driver, grid_scroll);
			horizontalscroll(driver, grid_scroll, 300);
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Portcode);
		}
		
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		waitForElement(driver, ServiceInput_IMD);
		String Service_Actual=getAttribute(driver, ServiceInput_IMD,"value");
		if(Service_Actual.equals(Service)) {
			System.out.println("Matched || Expected Sevice : "+Service +" || Actual Sevice : "+Service_Actual);
			Extent_pass_New(driver, "Matched || Expected Sevice : "+Service +" || Actual Sevice : "+Service_Actual, test, test1);
		}else {
			System.out.println("Not Matched || Expected Sevice : "+Service +" || Actual Sevice : "+Service_Actual);
			Extent_fail(driver, "Not Matched || Expected Sevice : "+Service +" || Actual Sevice : "+Service_Actual, test, test1);
		}

		waitForElement(driver, vesselcode_Field_IMP_DOC);
		String Vessel_Actual=getText(driver, vesselcode_Field_IMP_DOC);
		if(Vessel_Actual.equals(Vessel)) {
			System.out.println("Matched || Expected Vessel : "+Vessel +" || Actual Vessel : "+Vessel_Actual);
			Extent_pass_New(driver, "Matched || Expected Vessel : "+Vessel +" || Actual Vessel : "+Vessel_Actual, test, test1);
		}else {
			System.out.println("Not Matched || Expected Vessel : "+Vessel +" || Actual Vessel : "+Vessel_Actual);
			Extent_fail(driver, "Not Matched || Expected Vessel : "+Vessel +" || Actual Vessel : "+Vessel_Actual, test, test1);
			
		}
		waitForElement(driver, voyagecode_Field_IMP_DOC);
		String Voyage_Actual=getText(driver, voyagecode_Field_IMP_DOC);
		if(Voyage_Actual.equals(Voyage)) {
			System.out.println("Matched || Expected Voyage : "+Voyage +" || Actual Voyage : "+Voyage_Actual);
			Extent_pass_New(driver, "Matched || Expected Voyage : "+Voyage +" || Actual Voyage : "+Voyage_Actual, test, test1);
		}else {
			System.out.println("Not Matched || Expected Voyage : "+Voyage +" || Actual Voyage : "+Voyage_Actual);
			Extent_fail(driver, "Not Matched || Expected Voyage : "+Voyage +" || Actual Voyage : "+Voyage_Actual, test, test1);
			
		}
		waitForElement(driver, bound_Field_IMP_DOC);
		String Bound_Actual=getText(driver, bound_Field_IMP_DOC);
		if(Bound_Actual.equals(Bound)) {
			System.out.println("Matched || Expected Bound : "+Bound +" || Actual Bound : "+Bound_Actual);
			Extent_pass_New(driver, "Matched || Expected Bound : "+Bound +" || Actual Bound : "+Bound_Actual, test, test1);
		}else {
			System.out.println("Not Matched || Expected Bound : "+Bound +" || Actual Bound : "+Bound_Actual);
			Extent_fail(driver, "Not Matched || Expected Bound : "+Bound +" || Actual Bound : "+Bound_Actual, test, test1);
			
		}
		waitForElement(driver, portcode_Field_IMP_DOC);
		String Portcode_Actual=getText(driver, portcode_Field_IMP_DOC);
		if(Portcode_Actual.equals(Portcode)) {
			System.out.println("Matched || Expected Port Code : "+Portcode +" || Actual Port Code : "+Portcode_Actual);
			Extent_pass_New(driver, "Matched || Expected Port Code : "+Portcode +" || Actual Port Code : "+Portcode_Actual, test, test1);
		}else {
			System.out.println("Not Matched || Expected Port Code : "+Portcode +" || Actual Port Code : "+Portcode_Actual);
			Extent_fail(driver, "Not Matched || Expected Port Code : "+Portcode +" || Actual Port Code : "+Portcode_Actual, test, test1);
			
		}

		Step_End(8, "Enter the valid service.", test, test1);
		Step_End(9, "Populate the vessel details based on the provided service.", test, test1);

		Extent_completed(testCaseName, test, test1);
	}
}	
