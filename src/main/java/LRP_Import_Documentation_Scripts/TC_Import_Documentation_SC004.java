package LRP_Import_Documentation_Scripts;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC004 extends Keywords {
	public void Import_Documentation_SC004(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String testCaseName="TC_Import_Documentation_SC004";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String moduleImportDoc = Excel_data.get("moduleImportDoc");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Portcode = Excel_data.get("Portcode");
		String Terminal = Excel_data.get("Terminal");
		String New_Import_Documentation = Excel_data.get("New_Import_Documentation");
		String ModuleDischargeReconciliation = Excel_data.get("ModuleDischargeReconciliation");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String pol_Value=Excel_data.get("pol_Value");
		String Label_Select_2_Discharge=Excel_data.get("Label_Select_2_Discharge");
		String Condition_Filter=Excel_data.get("Condition_Filter");
		
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver,url);

		LRP_Login(driver, Username, Password);
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		String select_Option_3 = String.format(DropDown_Select, Label_Select_2_Discharge);
	
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
				Extent_pass(driver, "Matched || Expected Pop up : " + new_import_documentation + " || Actual Pop up : "
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
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service);
			Step_End(8, "Enter the valid service.", test, test1);
			
			Step_Start(9, "Populate the vessel details based on the provided service..", test, test1);

			if(!Vessel.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
			}
			if(!Voyage.trim().equals("")) {
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
			}
			if(!Bound.trim().equals("")) {
				sendKeys(driver, grid_bound_IMP_DOC, Bound);
			}
			if(!Portcode.trim().equals("")) {
				sendKeys(driver, grid_portcodeIMP_DOC, Portcode);
			}
			if(!Terminal.trim().equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 300);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
			}
			
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			Step_End(9, "Populate the vessel details based on the provided service..", test, test1);

			Step_Start(10, "POL Search field-based on datasheet", test, test1);
			scrollTop(driver);
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition_Filter, pol_Value);
			}
			Step_End(10, "POL Search field-based on datasheet", test, test1);

			Step_Start(11, "ALL ,SAVED BL AND UNSAVED BL-based on datasset it will set", test, test1);

			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			waitForElement(driver, select_Option_1);
			click(driver, select_Option_1);
			Step_End(11, "ALL ,SAVED BL AND UNSAVED BL-based on datasset it will set", test, test1);

			Step_Start(12, "ALL,LOCAL,TRANS-Based on the dataset it will set", test, test1);
			waitForElement(driver, slection_Label_2);
			click(driver, slection_Label_2);
			waitForElement(driver, select_Option_2);
			click(driver, select_Option_2);
			Step_End(12, "ALL,LOCAL,TRANS-Based on the dataset it will set", test, test1);

			Step_Start(13, "click the showbl 's button", test, test1);
			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);
			Step_End(13, "click the showbl 's button", test, test1);			

			Step_Start(14, "total bill has shown.", test, test1);

		waitForElement(driver, BL_SearchButton_IMP_DOC);
		click(driver, BL_SearchButton_IMP_DOC);
	
//		List<WebElement> blNumbers = listOfElements(driver, BL_Numbers);
		waitForElement(driver, BL_Numbers);
		int ID_size = 0;
		
		//new lines modified by vignesh on 05.05.2025 , in order scroll and take count of entire table
		String blRow=String.format(BLNumbers_Rows, ID_size);
		while(isdisplayed(driver, blRow)) {
			mouseOverToElement(driver, blRow);
			ID_size++;
			blRow=String.format(BLNumbers_Rows, ID_size);
		}
			//new lines modified by vignesh on 05.05.2025 , in order scroll and take count of entire table
		
		waitForElement(driver, CanceButtonlBLNum);
		click(driver, CanceButtonlBLNum);
		Step_End(14, "total bill has shown.", test, test1);

       // Search for Discharge Reconciliation module
		Step_Start(15, "open the Discharge reconcillation Module.Click the new button", test, test1);
		moduleNavigate(driver, ModuleDischargeReconciliation);
		newButton(driver);
		Step_End(15, "open the Discharge reconcillation Module.Click the new button", test, test1);

		Step_Start(16, ".load the same service and vessel details -select the vessel details", test, test1);
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service);
		waitForElement(driver, grid_vesselcode_IMP_DOC);
		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
		sendKeys(driver, grid_bound_IMP_DOC, Bound);
		if(!Portcode.trim().equals("")) {
			waitForElement(driver, grid_scroll);
			scrollUsingElement(driver, grid_scroll);
			horizontalscroll(driver, grid_scroll, 300);
			click1(driver,grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Portcode);
		}
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		Step_End(16, ".load the same service and vessel details -select the vessel details", test, test1);

		Step_Start(17, "plan dropdownfield -value has referred from test data (for eg :all,local,transhipment )", test, test1);
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		Step_End(17, "plan dropdownfield -value has referred from test data (for eg :all,local,transhipment )", test, test1);

		Step_Start(18, "Click the Download BL(s) button", test, test1);
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);
		Step_End(18, "Click the Download BL(s) button", test, test1);
		
		//Modified by Vigensh on 16_04_2025 , Here we need to take the unique BL Number Count, then compare that count with import Documentation Module BL Counts.
		//Also here filter the AG Grid values in Discharge Reconciliation  by using POL Value. If User entered POL value in the input data sheet, then filter the AG Grid otherwise no need to Filter.
		if(!pol_Value.equals("")) {
			waitForElement(driver, MoreOption_Grid);
			click(driver,MoreOption_Grid);
			
			waitForElement(driver, FilterOption_Menu);
			click(driver,FilterOption_Menu);
			
			waitForElement(driver, POL_Input_Filter);
			sendKeys(driver, POL_Input_Filter, pol_Value);
		}		
		Step_Start(19, ".bl has shown in the below grid.", test, test1);
		waitForElement(driver, BL_Number_Columns_DR);
		Set<String>  BL_Lists_DR_Module=new HashSet<String>();

		//new lines modified by vignesh on 05.05.2025 , in order scroll and take count of entire table
		int size_DR=0;
		String bl_Column_DR=String.format(BL_Numbers_Column_AG_Grid_DR, size_DR);
		while(isdisplayed(driver, bl_Column_DR)) {
			mouseOverToElement(driver, bl_Column_DR);
			String BL_Column_Value=getText(driver, bl_Column_DR);
			
			BL_Lists_DR_Module.add(BL_Column_Value);
			size_DR++;
			bl_Column_DR=String.format(BL_Numbers_Column_AG_Grid_DR, size_DR);
		}
		//new lines modified by vignesh on 05.05.2025 , in order scroll and take count of entire table
		Step_End(19, "bl has shown in the below grid.", test, test1);

		
		int BL_Num_Size_DR=BL_Lists_DR_Module.size();
		System.out.println("BL_Num_Size_DR : "+BL_Num_Size_DR);

		Extent_call(test, test1, "Verify that bl's count should be matched with discharge reconcilitation and Import documentation . ");

		if (ID_size == BL_Num_Size_DR) {
			System.out.println("Matched || Expected Size : " + ID_size + "  || Actual Size: " + BL_Num_Size_DR);
			Extent_pass(driver, "Matched || Expected Size : " + ID_size + " || Actual Size : " + BL_Num_Size_DR, test, test1);
		
		} else {
			System.out.println("Not Matched || Expected Size : " + ID_size + " || Actual Size : " + BL_Num_Size_DR);
			Extent_fail(driver, "Not Matched || Expected Size : " + ID_size + " || Actual Size : " + BL_Num_Size_DR, test,
					test1);
		}
		Extent_call(test, test1, "Verify that bl's count should be matched with discharge reconcilitation and Import documentation . ");

		//Modified by Vigensh on 16_04_2025 , Here we need to take the unique BL Number Count, then compare that count with import Documentation Module BL Counts.

		Extent_completed(testCaseName, test, test1);

	}
}
