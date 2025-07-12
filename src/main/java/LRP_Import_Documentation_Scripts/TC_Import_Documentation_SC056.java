package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC056 extends Keywords {

	public void Import_Documentation_SC056(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC056";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String SavedPopup = Excel_data.get("SavedPopup");
		String Service_Name = Excel_data.get("Service_Name");
		String vesselcode = Excel_data.get("vesselcode");
		String voyagecode = Excel_data.get("voyagecode");
		String bound = Excel_data.get("bound");
		String portcode = Excel_data.get("portcode");
		String terminal = Excel_data.get("terminal");
		String New_Import_Documentation = Excel_data.get("New_Import_Documentation");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String Select_Search_Type_Import_Doc = Excel_data.get("Select_Search_Type_Import_Doc");
		String bl_Number = Excel_data.get("bl_Number");
		String pol_Value = Excel_data.get("pol_Value");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String UpdatedPopup = Excel_data.get("UpdatedPopup");
		String Delete_Perform = Excel_data.get("Delete_Perform");
		String Condition = Excel_data.get("Condition");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String House_BL_Type_Exp = Excel_data.get("House_BL_Type_Exp");
		String ImportDoc_Select_Type2 = Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Value2 = Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Type3 = Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value3 = Excel_data.get("ImportDoc_Select_Value3");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);		
		verifyMainMenu(driver);
		
		Step_Start(1, "switch to agency ", test, test1);
		SwitchProfile(driver, AgencyUser);

		Step_End(1, "switch to agency ", test, test1);

		Step_Start(2, "open the import documentation module", test, test1);	
		
		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(2, "open the import documentation module", test, test1);

		Step_Start(3, "load the bl in search field", test, test1);
		
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {

			Step_Start(4, "Click the Home button", test, test1);
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);

				waitForPopup(driver, popup_Message, New_Import_Documentation);
				String new_import_documentation=getText(driver, popup_Message);
				if(new_import_documentation.equals(New_Import_Documentation)) {
					Extent_pass_New(driver, "Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation, test, test1);
					System.out.println("Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation);
				}else {
					Extent_fail(driver, "Not Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation, test, test1);
					System.out.println("Not Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation);
				}


				waitForElement(driver, popup_Message_Yes_Button);
				safeclick(driver, popup_Message_Yes_Button);
			}



			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service_Name);

			if(!vesselcode.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, vesselcode);
			}
			if(!voyagecode.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, voyagecode);
			}
			if(!bound.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, bound);
			}
			if(!portcode.trim().equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, portcode);
			}
			if(!terminal.trim().equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 300);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, terminal);
			}
			waitForElement(driver, Select_Service_Details);
			click(driver,Select_Service_Details);
			
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);

			scrollTop(driver);
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnSearchWindow(driver, Pol_Header, Condition, pol_Value);
			}
			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			
			waitForElement(driver, select_Option_1);
			click(driver, select_Option_1);
			
			waitForElement(driver, slection_Label_2);
			click(driver, slection_Label_2);
			
			waitForElement(driver, select_Option_2);
			click(driver, select_Option_2);
			
			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);

			waitForElement(driver, BL_Number);
			String Get_BL_Number = getAttribute(driver, BL_Number,"value");
			System.out.println("Get_BL_Number:"+ Get_BL_Number);
	      
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, Condition, bl_Number);

		}
		Step_End(3, "load the bl in search field", test, test1);

		Step_Start(4, "Import Documentation Module has to be open with valid data", test, test1);
		scrollTop(driver);
		
		deleteSavedBL(driver, House_BL_Type_Exp, BL_Condition, bl_Number);
		Step_End(4, "Import Documentation Module has to be open with valid data", test, test1);

		waitForElement(driver, IMD_cargotype);
		String Get_BL_Cargo_Status = getText(driver, IMD_cargotype);
		System.out.println("BL_Cargo_Status:"+ Get_BL_Cargo_Status);
		
		if(Get_BL_Cargo_Status.equalsIgnoreCase("Local")) {
			System.out.println("Expected : BL Cargo Type Should be in 'Local' || Actual : BL Cargo type is 'Local'");
			Extent_pass_New(driver, "Expected : BL Cargo Type Should be in 'Local' || Actual : BL Cargo type is 'Local'", test, test1);
		}else {
			System.out.println("Expected : BL Cargo Type Should be in 'Local' || Actual : BL Cargo type is not 'Local'");
			Extent_fail(driver, "Expected : BL Cargo Type Should be in 'Local' || Actual : BL Cargo type is not 'Local'", test, test1);
		}
		
		Step_Start(5, "Value has to be shown for all tabs and the value refer from BL/MCN", test, test1);
		
		waitForDisplay(driver, Arrival_notice_button);
		if(!IsElementEnabled(driver, Arrival_notice_button)) {
			System.out.println("Expected : Before Saving Import Documentation, Arrival Notice Button Should not enabled || Actual :Before Saving Import Documentation, Arrival Notice Button is not enabled");
			Extent_pass_New(driver, "Expected : Before Saving Import Documentation, Arrival Notice Button Should not enabled || Actual :Before Saving Import Documentation, Arrival Notice Button is not enabled", test,test1);

		} else {
			System.out.println("Expected : Before Saving Import Documentation, Arrival Notice Button Should not enabled || Actual :Before Saving Import Documentation, Arrival Notice Button is enabled");
			Extent_fail(driver, "Expected : Before Saving Import Documentation, Arrival Notice Button Should not enabled || Actual :Before Saving Import Documentation, Arrival Notice Button is enabled", test,test1);
		
		}
		waitForDisplay(driver, Invoice_Button);
		if(!IsElementEnabled(driver, Invoice_Button)) {
			System.out.println("Expected : Before Saving Import Documentation, Import Invoice Button Should not enabled || Actual :Before Saving Import Documentation, Import Invoice Button is not enabled");
			Extent_pass_New(driver, "Expected : Before Saving Import Documentation, Import Invoice Button Should not enabled || Actual :Before Saving Import Documentation, Import Invoice Button is not enabled", test,test1);

		} else {
			System.out.println("Expected : Before Saving Import Documentation, Import Invoice Button Should not enabled || Actual :Before Saving Import Documentation, Import Invoice Button is enabled");
			Extent_fail(driver, "Expected : Before Saving Import Documentation, Import Invoice Button Should not enabled || Actual :Before Saving Import Documentation, Import Invoice Button is enabled", test,test1);
		
		}
		waitForDisplay(driver, Vessel_Info_Button);
		if(!IsElementEnabled(driver, Vessel_Info_Button)) {
			System.out.println("Expected : Before Saving Import Documentation, Vessel Info Button Should not enabled || Actual :Before Saving Import Documentation, Vessel Info Button is not enabled");
			Extent_pass_New(driver, "Expected : Before Saving Import Documentation, Vessel Info Button Should not enabled || Actual :Before Saving Import Documentation, Vessel Info Button is not enabled", test,test1);

		} else {
			System.out.println("Expected : Before Saving Import Documentation, Vessel Info Button Should not enabled || Actual :Before Saving Import Documentation, Vessel Info Button is enabled");
			Extent_fail(driver, "Expected : Before Saving Import Documentation, Vessel Info Button Should not enabled || Actual :Before Saving Import Documentation, Vessel Info Button is enabled", test,test1);
		
		}
		waitForDisplay(driver, Delivery_Order_Button);
		if(!IsElementEnabled(driver, Delivery_Order_Button)) {
			System.out.println("Expected : Before Saving Import Documentation, Delivery_Order Button Should not enabled || Actual :Before Saving Import Documentation, Delivery_Order Button is not enabled");
			Extent_pass_New(driver, "Expected : Before Saving Import Documentation, Delivery_Order Button Should not enabled || Actual :Before Saving Import Documentation, Delivery_Order Button is not enabled", test,test1);

		} else {
			System.out.println("Expected : Before Saving Import Documentation, Delivery_Order Button Should not enabled || Actual :Before Saving Import Documentation, Delivery_Order Button is enabled");
			Extent_fail(driver, "Expected : Before Saving Import Documentation, Delivery_Order Button Should not enabled || Actual :Before Saving Import Documentation, Delivery_Order Button is enabled", test,test1);
		
		}

		Step_End(5, "Value has to be shown for all tabs and the value refer from BL/MCN", test, test1);

		Step_Start(6, "click the save in toolbar import documentation module.", test, test1);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(6, "click the save in toolbar import documentation module.", test, test1);
		Step_Start(7, "once saved the import documentation system has validate import documentation is saved", test, test1);

		waitForPopup(driver, popup_Message, SavedPopup);
		String BL_StatusValue= getText(driver, popup_Message);
		if(BL_StatusValue.equals(SavedPopup)) {
			System.out.println("Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + SavedPopup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + SavedPopup, test,
					test1);
		} else if (BL_StatusValue.equals(UpdatedPopup)) {
			System.out.println("Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + UpdatedPopup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + UpdatedPopup, test,
					test1);
		}else {
			System.out.println("NotMatched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + UpdatedPopup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + BL_StatusValue + " || Actual Popup was : " + UpdatedPopup,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(7, "once saved the import documentation system has validate import documentation is saved", test, test1);

		Step_Start(8, "import documenation module following  button has to be enable. when the import documenation has saved i.Arrival Notice ii.Import Invoice iii.Vessel info iv.Delivery order", test, test1);
		waitForDisplay(driver, Arrival_notice_button);
		if(IsElementEnabled(driver, Arrival_notice_button)) {
			System.out.println("Expected : After Saving Import Documentation, Arrival Notice Button Should be enabled || Actual : After Saving Import Documentation, Arrival Notice Button is enabled");
			Extent_pass_New(driver, "Expected : After Saving Import Documentation, Arrival Notice Button Should be enabled || Actual : After Saving Import Documentation, Arrival Notice Button is enabled", test,test1);

		} else {
			System.out.println("Expected : After Saving Import Documentation, Arrival Notice Button Should be enabled || Actual : After Saving Import Documentation, Arrival Notice Button is not enabled");
			Extent_fail(driver, "Expected : After Saving Import Documentation, Arrival Notice Button Should be enabled || Actual : After Saving Import Documentation, Arrival Notice Button is not enabled", test,test1);
		
		}
		waitForDisplay(driver, Invoice_Button);
		if(IsElementEnabled(driver, Invoice_Button)) {
			System.out.println("Expected : After Saving Import Documentation, Import Invoice Button Should be enabled || Actual : After Saving Import Documentation, Import Invoice Button is enabled");
			Extent_pass_New(driver, "Expected : After Saving Import Documentation, Import Invoice Button Should be enabled || Actual : After Saving Import Documentation, Import Invoice Button is enabled", test,test1);

		} else {
			System.out.println("Expected : After Saving Import Documentation, Import Invoice Button Should be enabled || Actual : After Saving Import Documentation, Import Invoice Button is not enabled");
			Extent_fail(driver, "Expected : After Saving Import Documentation, Import Invoice Button Should be enabled || Actual : After Saving Import Documentation, Import Invoice Button is not enabled", test,test1);
		}
		waitForDisplay(driver, Vessel_Info_Button);
		if(IsElementEnabled(driver, Vessel_Info_Button)) {
			System.out.println("Expected : After Saving Import Documentation, Vessel Info Button Should be enabled || Actual : After Saving Import Documentation, Vessel Info Button is enabled");
			Extent_pass_New(driver, "Expected : After Saving Import Documentation, Vessel Info Button Should be enabled || Actual : After Saving Import Documentation, Vessel Info Button is enabled", test,test1);

		} else {
			System.out.println("Expected : After Saving Import Documentation, Vessel Info Button Should be enabled || Actual : After Saving Import Documentation, Vessel Info Button is not enabled");
			Extent_fail(driver, "Expected : After Saving Import Documentation, Vessel Info Button Should be enabled || Actual : After Saving Import Documentation, Vessel Info Button is not enabled", test,test1);
		}
		waitForDisplay(driver, Delivery_Order_Button);
		if(IsElementEnabled(driver, Delivery_Order_Button)) {
			System.out.println("Expected : After Saving Import Documentation, Delivery_Order Button Should be enabled || Actual : After Saving Import Documentation, Delivery_Order Button is enabled");
			Extent_pass_New(driver, "Expected : After Saving Import Documentation, Delivery_Order Button Should be enabled || Actual : After Saving Import Documentation, Delivery_Order Button is enabled", test,test1);

		} else {
			System.out.println("Expected : After Saving Import Documentation, Delivery_Order Button Should be enabled || Actual : After Saving Import Documentation, Delivery_Order Button is not enabled");
			Extent_fail(driver, "Expected : After Saving Import Documentation, Delivery_Order Button Should be enabled || Actual : After Saving Import Documentation, Delivery_Order Button is not enabled", test,test1);
		}

		Step_End(8, "import documenation module following  button has to be enable. when the import documenation has saved i.Arrival Notice ii.Import Invoice iii.Vessel info iv.Delivery order", test, test1);
		Step_Start(9, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		//
		Step_Start(10, "click the yes and system has validate import dcoumentation is deleted ", test, test1);

		if(Delete_Perform.equalsIgnoreCase("YES")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Step_End(9, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(10, "click the yes and system has validate import dcoumentation is deleted ", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
