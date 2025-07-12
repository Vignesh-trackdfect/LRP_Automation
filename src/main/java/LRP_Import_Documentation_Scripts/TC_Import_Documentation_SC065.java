package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC065 extends Keywords{
	public void Import_Documentation_SC065(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC065";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String Manifest_Popup = Excel_data.get("Manifest_Popup");
		String Charge_Code_Type = Excel_data.get("Charge_Code_Type");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup").trim();
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String pol_Value=Excel_data.get("pol_Value");
		String Do_You_Want_Delete_Import_Doc=Excel_data.get("Do_You_Want_Delete_Import_Doc");
		String SavedPopup=Excel_data.get("SavedPopup");
		String UpdatedPopup=Excel_data.get("UpdatedPopup");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String ImportDoc_Select_Type2 = Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Value2 = Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Type3 = Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value3 = Excel_data.get("ImportDoc_Select_Value3");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		String Charege_Code_Grid=String.format(ImportDocumentation_Locators.Charege_Code_Grid, Charge_Code_Type);

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyUser);

		Extent_cal(test, test1, ImportDocumentationModule);

		Step_Start(1, "Open Import Documentation module", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);

		Step_End(1, "Open Import Documentation module", test, test1);

		Step_Start(2, "click the Search Button and Load the BL No", test, test1);	
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);


		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if( IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
			
			waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
			String NewImportDocumentation = getText(driver, popup_Message);
			if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
				System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup
						+ " || Actual Popup was : " + NewImportDocumentation);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup
						+ " || Actual Popup was : " + NewImportDocumentation, test, test1);

			} else {
				System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup
						+ " || Actual Popup was : " + NewImportDocumentation);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup
						+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
			}
			waitForElement(driver, popup_Message_Yes_Button);
			safeclick(driver, popup_Message_Yes_Button);
		}
			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service);

			if(!Vessel.trim().equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, Vessel);
			}
			if(!Voyage.trim().equals("")) {
				waitForElement(driver, grid_voyagecode_IMP_DOC);
				sendKeys(driver, grid_voyagecode_IMP_DOC, Voyage);
			}
			if(!Bound.trim().equals("")) {
				waitForElement(driver, grid_bound_IMP_DOC);
				sendKeys(driver, grid_bound_IMP_DOC, Bound);
			}
			if(!Port.trim().equals("")) {
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 100);
				waitForElement(driver, grid_portcodeIMP_DOC);
				sendKeys(driver, grid_portcodeIMP_DOC, Port);
			}
			if(!Terminal.trim().equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 500);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
			}
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			scrollTop(driver);
			scrollTop(driver);
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnSearchWindow(driver, Pol_Header, Condition_Filter, pol_Value);

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

			waitForElement(driver, Local_Check_Box);
			checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
			waitForElement(driver, Transhipment_Check_Box);
			checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);

			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, Condition_Filter, BL_Num);

		}
		Step_End(2, "click the Search Button and Load the BL No", test, test1);
		Step_Start(3, "Go to Collect charges tab", test, test1);
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (!house_BL_Status.equalsIgnoreCase("NEW")) {
			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
		}
		waitForElement(driver,Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);
		scrollBottom(driver);
		Step_End(3, "Go to Collect charges tab", test, test1);
		Step_Start(4, "Pass Any charge code from Excel as Data ", test, test1);
		waitForElement(driver,Charege_Code_Grid);
		click(driver, Charege_Code_Grid);
		Step_End(4, "Pass Any charge code from Excel as Data ", test, test1);
		Step_Start(5, "select the manifest charges and click the remove button", test, test1);
		waitForElement(driver,collectCharges_Remove_Button);
		click(driver, collectCharges_Remove_Button);
		Step_End(5, "select the manifest charges and click the remove button", test, test1);
		Step_Start(6, "system has validate\" Selected Manifest Charges cannot be removed\"", test, test1);
		waitForPopup(driver, popup_Message, Manifest_Popup);
		String Actual_Popup=getText(driver, popup_Message);
		if (Manifest_Popup.equals(Actual_Popup)) {
			System.out.println("Matched || Expected Popup was : " + Manifest_Popup + " || Actual Popup was : " + Actual_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + Manifest_Popup + " || Actual Popup was : " + Actual_Popup, test,test1);
			Step_Start(7, "click ok", test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			Step_Start(7, "click ok", test, test1);
			
		} else {
			System.out.println("NotMatched || Expected Popup was : " + Manifest_Popup + " || Actual Popup was : " + Actual_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + Manifest_Popup + " || Actual Popup was : " + Actual_Popup,test, test1);
		}
		Step_End(6, "system has validate\" Selected Manifest Charges cannot be removed\"", test, test1);
		scrollTop(driver);
		waitForElement(driver,SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_Start(8, "save the import doc\r\n"
				+ "once saved the imp doc then delete the imp doc", test, test1);
		waitForPopup(driver, popup_Message, SavedPopup);
		String ImportDocumentationSaved=getText(driver, popup_Message);
		if (SavedPopup.equals(ImportDocumentationSaved)) {
			System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,
					test1);
		} else if (UpdatedPopup.equals(ImportDocumentationSaved)) {
			System.out.println("Matched || Expected Popup was : " + UpdatedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + UpdatedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,
					test1);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved,
					test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		
		Step_Start(16, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(17, "click the yes and system has validate import dcoumentation is deleted .", test, test1);

		if(Do_You_Want_Delete_Import_Doc.equalsIgnoreCase("Yes")) {
			scrollTop(driver);
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Step_End(16, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(17, "click the yes and system has validate import dcoumentation is deleted .", test, test1);
		
		Extent_completed(testcase_Name, test, test1);
	}
}
