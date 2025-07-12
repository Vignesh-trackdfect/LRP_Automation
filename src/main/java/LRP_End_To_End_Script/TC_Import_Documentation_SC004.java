package LRP_End_To_End_Script;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC004 extends Keywords {
	public void Import_Documentation_SC004(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String testCaseName="TC_Import_Documentation_SC004";

//		String Username = Excel_data.get("Username");
//		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("Export_Agency_Code");
		String BL_Select_Header = Excel_data.get("BL_Select_Header");
		String Service = Excel_data.get("Service_Code_new");
//		String Vessel = Excel_data.get("vesselCode");
//		String Voyage = Excel_data.get("Voyagenumber1");
		String Bound = Excel_data.get("Boundinput");
		String Portcode = Excel_data.get("delivery");
//		String Terminal = Excel_data.get("POD_Terminal_Input_Routing");
//		String New_Import_Documentation = Excel_data.get("New_Import_Documentation");
		String ModuleDischargeReconciliation = Excel_data.get("ModuleDischargeReconciliation");
//		String Label_Select_1 = Excel_data.get("Label_Select_1");
//		String Label_Select_2 = Excel_data.get("Label_Select_2");
//		String pol_Value=Excel_data.get("pol_Value");
		String Label_Select_2_Discharge=Excel_data.get("Label_Select_2_Discharge");
		String BL_Number_box =Excel_data.get("New_BL_Number");
				String Condition=Excel_data.get("Condition");
//		
//		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		
//		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
//		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		String select_Option_3 = String.format(DropDown_Select, Label_Select_2_Discharge);
	

		Extent_Start(testCaseName, test, test1);
//		navigateUrl(driver,url);
//
//		LRP_Login(driver, Username, Password);
//		verifyMainMenu(driver);
//		Switch the Profile
		Step_Start(1, "Switch to agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency.", test, test1);
		moduleNavigate(driver, ModuleDischargeReconciliation);
		newButton(driver);
		waitForElement(driver, DisRecServiceInput_DRL);
		sendKeys(driver, DisRecServiceInput_DRL, Service);
//		waitForElement(driver, grid_vesselcode_IMP_DOC);
//		sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
//		sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
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
		
		waitForElement(driver, droup_select_discharge);
		click(driver, droup_select_discharge);
		waitForElement(driver, select_Option_3);
		click(driver, select_Option_3);
		
		waitForElement(driver, DownloadBLs);
		click(driver, DownloadBLs);

		waitForElement(driver, importDocumentation_Button_DRC);
		click(driver, importDocumentation_Button_DRC);
//		moduleNavigate(driver, moduleImportDoc);
		waitForElement(driver, BL_SearchButton_IMP_DOC);
		click(driver, BL_SearchButton_IMP_DOC);
		twoColumnMultipleSearchWindow(driver, BL_Select_Header, Condition, BL_Number_box);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		//Vignesh-> As discussed with Suresh on 16_04_2025, I have Removed the (Step 3) Codes for validating all the Toolbar functions accessiblity

//		Step_Start(4, "Click the Home button.", test, test1);		
//		waitForDisplay(driver, NewButton_ToolBar);
//		if(IsElementEnabled(driver, NewButton_ToolBar)) {
//			click(driver, NewButton_ToolBar);
//			Step_End(4, "Click the Home button.", test, test1);
//			Step_Start(5,"The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.",
//					test, test1);
//
//			Step_Start(6, "Click the Yes button.", test, test1);
//			waitForPopup(driver, popup_Message, New_Import_Documentation);
//			String new_import_documentation = getText(driver, popup_Message);
//			if (new_import_documentation.equals(New_Import_Documentation)) {
//				System.out.println("Matched || Expected Pop up : " + new_import_documentation + " || Actual Pop up : "
//						+ New_Import_Documentation);
//				Extent_pass_New(driver, "Matched || Expected Pop up : " + new_import_documentation + " || Actual Pop up : "
//						+ New_Import_Documentation, test, test1);
//				waitForElement(driver, popup_Message_Yes_Button);
//				click(driver, popup_Message_Yes_Button);
//			} else {
//				System.out.println("Not Matched || Expected Pop up : " + new_import_documentation + " || Actual Pop up : "
//						+ New_Import_Documentation);
//				Extent_fail(driver, "Not Matched || Expected Pop up : " + new_import_documentation + " || Actual Pop up : "
//						+ New_Import_Documentation, test, test1);
//				
//			}
//			Step_End(5,
//					"The system will validate and prompt: \"Do you want to create a new Import Documentation?\" Select NO or YES.",
//					test, test1);
//			Step_End(6, "Click the Yes button.", test, test1);
//
//			
//		}
//		
		//Vignesh-> As discussed with Suresh on 17_04_2025, I have Removed the (Step 7) Codes for validating the Service, POL search field, all dropdown fields, and Show BL's button are enabled.

//		Step_Start(8, "Enter the valid service.", test, test1);
//		Step_Start(9, "Populate the vessel details based on the provided service..", test, test1);
//		Step_Start(10, "Select the service and vessel details.", test, test1);
//		Step_Start(12, "The respective service and vessel-based BL's will be shown in the import documentation module.",
//				test, test1);
//
//	
//			newButton(driver);
//			
//			waitForElement(driver, ServiceInput_IMD);
//			sendKeys(driver, ServiceInput_IMD, Service);
//
//			if(!Vessel.equals("")) {
//				waitForElement(driver, grid_vesselcode_IMP_DOC);
//				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
//			}
//			if(!Voyage.equals("")) {
//				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
//			}
//			if(!Bound.equals("")) {
//				sendKeys(driver, grid_bound_IMP_DOC, Bound);
//			}
//			if(!Portcode.equals("")) {
//				sendKeys(driver, grid_portcodeIMP_DOC, Portcode);
//			}
//			if(!Terminal.equals("")) {
//				waitForElement(driver, grid_scroll);
//				scrollUsingElement(driver, grid_scroll);
//				horizontalscroll(driver, grid_scroll, 300);
//				click1(driver,grid_terminal_IMP_DOC);
//				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
//			}
//			waitForElement(driver, Select_Service_Details);
//			click(driver, Select_Service_Details);
//			waitForElement(driver, grid_selectbtn_IMP_DOC);
//			click(driver, grid_selectbtn_IMP_DOC);
//			
//			scrollTop(driver);
//			if(!pol_Value.equals("")) {
//				waitForElement(driver, POLSearch);
//				click(driver, POLSearch);
//				twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition_Filter, pol_Value);
//			}
//			
//			Step_End(8, "Enter the valid service.", test, test1);
//			Step_End(9, "Populate the vessel details based on the provided service.", test, test1);
//
//			waitForElement(driver, slection_Label_1);
//			click(driver, slection_Label_1);
//			waitForElement(driver, select_Option_1);
//			click(driver, select_Option_1);
//			
//			waitForElement(driver, slection_Label_2);
//			click(driver, slection_Label_2);
//			waitForElement(driver, select_Option_2);
//			click(driver, select_Option_2);
//			
//			Step_Start(11, "Click the Show BL's button.", test, test1);
//
//			waitForElement(driver, Show_BL_Button);
//			click(driver, Show_BL_Button);
//			Step_End(11, "Click the Show BL's button.", test, test1);
//		
//		Step_End(12, "The respective service and vessel-based BL's will be shown in the import documentation module.",
//				test, test1);
//
	//		
//
////		List<WebElement> blNumbers = listOfElements(driver, BL_Numbers);
//		waitForElement(driver, BL_Numbers);
//		int ID_size = 0;
//		
//		//new lines modified by vignesh on 05.05.2025 , in order scroll and take count of entire table
//		String blRow=String.format(BLNumbers_Rows, ID_size);
//		while(isdisplayed(driver, blRow)) {
//			mouseOverToElement(driver, blRow);
//			ID_size++;
//			blRow=String.format(BLNumbers_Rows, ID_size);
//		}
//			//new lines modified by vignesh on 05.05.2025 , in order scroll and take count of entire table
//		
//		waitForElement(driver, CanceButtonlBLNum);
//		click(driver, CanceButtonlBLNum);
//
//       // Search for Discharge Reconciliation module
//		Step_Start(13, "open the Discharge reconcillation Module.", test, test1);
//		Extent_cal(test, test1, "Discharge Reconciliation");
//		
//		
//		Step_End(15, "Click the Download BL(s) button", test, test1);
//		Step_End(16, "bl has shown in the below grid.", test, test1);
//		
//		//Modified by Vigensh on 16_04_2025 , Here we need to take the unique BL Number Count, then compare that count with import Documentation Module BL Counts.
//		//Also here filter the AG Grid values in Discharge Reconciliation  by using POL Value. If User entered POL value in the input data sheet, then filter the AG Grid otherwise no need to Filter.
//		if(!pol_Value.equals("")) {
//			waitForElement(driver, MoreOption_Grid);
//			click(driver,MoreOption_Grid);
//			
//			waitForElement(driver, FilterOption_Menu);
//			click(driver,FilterOption_Menu);
//			
//			waitForElement(driver, POL_Input_Filter);
//			sendKeys(driver, POL_Input_Filter, pol_Value);
//		}		
//		
//		waitForElement(driver, BL_Number_Columns_DR);
//		Set<String>  BL_Lists_DR_Module=new HashSet<String>();
//		
//		//new lines modified by vignesh on 05.05.2025 , in order scroll and take count of entire table
//		int size_DR=0;
//		String bl_Column_DR=String.format(BL_Numbers_Column_AG_Grid_DR, size_DR);
//		while(isdisplayed(driver, bl_Column_DR)) {
//			mouseOverToElement(driver, bl_Column_DR);
//			String BL_Column_Value=getText(driver, bl_Column_DR);
//			BL_Lists_DR_Module.add(BL_Column_Value);
//			size_DR++;
//			bl_Column_DR=String.format(BL_Numbers_Column_AG_Grid_DR, size_DR);
//		}
//		//new lines modified by vignesh on 05.05.2025 , in order scroll and take count of entire table
//		
//		
//		int BL_Num_Size_DR=BL_Lists_DR_Module.size();
//		System.out.println("BL_Num_Size_DR : "+BL_Num_Size_DR);
//
//		Step_Start(17,
//				"Verify that bl's count should be matched with discharge reconcilitation and Import documentation",
//				test, test1);
//
//		if (ID_size == BL_Num_Size_DR) {
//			System.out.println("Matched || Expected Size : " + ID_size + "  || Actual Size: " + BL_Num_Size_DR);
//			Extent_pass_New(driver, "Matched || Expected Size : " + ID_size + " || Actual Size : " + BL_Num_Size_DR, test, test1);
//		
//		} else {
//			System.out.println("Not Matched || Expected Size : " + ID_size + " || Actual Size : " + BL_Num_Size_DR);
//			Extent_fail(driver, "Not Matched || Expected Size : " + ID_size + " || Actual Size : " + BL_Num_Size_DR, test,
//					test1);
//		}
//		Step_End(17, "Verify that bl's count should be matched with discharge reconcilitation and Import documentation",
//				test, test1);
		//Modified by Vigensh on 16_04_2025 , Here we need to take the unique BL Number Count, then compare that count with import Documentation Module BL Counts.

		Extent_completed(testCaseName, test, test1);

	}
}
