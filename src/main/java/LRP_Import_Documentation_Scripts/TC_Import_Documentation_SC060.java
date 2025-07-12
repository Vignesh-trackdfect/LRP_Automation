package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC060 extends Keywords{

	public void Import_Documentation_SC060(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC060";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String SavedPopup = Excel_data.get("SavedPopup");
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
		String pol_Value=Excel_data.get("pol_Value");
		String Do_You_Want_Delete = Excel_data.get("Do_You_Want_Delete");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String ConditionFilter = Excel_data.get("ConditionFilter");
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
			Step_Start(3, "Load the BL in search field ", test, test1);

			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

			Step_End(3, "Load the BL in search field ", test, test1);
			Step_Start(4, "All datas has to be shown ", test, test1);
		
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
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
				twoColumnSearchWindow(driver, Pol_Header, ConditionFilter, pol_Value);
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
			twoColumnSearchWindow(driver, BLNumber_Header, BL_Condition, BL_Num);
		}

		Step_End(3, "load the bl in search field", test, test1);
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (house_BL_Status.equalsIgnoreCase("NEW")) {
			Step_Start(4, "click the save in toolbar import documentation module.", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			Step_End(4, "click the save in toolbar import documentation module.", test, test1);
			Step_Start(5, "once saved the import documentation system has validate import documentation is saved.", test, test1);
			waitForPopup(driver, popup_Message, SavedPopup);
			String ImportDocumentationSaved=getText(driver, popup_Message);
			if (SavedPopup.equals(ImportDocumentationSaved)) {
				System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,
						test1);
			} else {
				System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved,
						test, test1);
			}
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);
			Step_End(5, "once saved the import documentation system has validate import documentation is saved.", test, test1);
		}
		
		Step_Start(6, "click the Delivery order  button in Import documenation.(Capture the Name)", test, test1);
		waitForElement(driver, Delivery_Order_Button);
		String Delivery_Order_Button_Text=getText(driver, Delivery_Order_Button);
		click(driver, Delivery_Order_Button);

		Step_End(6, "click the Delivery order  button in Import documenation.(Capture the Name)", test, test1);

		Step_Start(7, "once clicked tht delivery order button ,system has open the delivery order module.(Verify the Same name)", test, test1);
		waitForElement(driver, Delivery_Order_Module_Title_IMP_DOC);
		String Delivery_Order_Frame=getText(driver, Delivery_Order_Module_Title_IMP_DOC);
		if (Delivery_Order_Button_Text.contains(Delivery_Order_Frame)) {
			System.out.println("Matched || Text of the Delivery Order Button : " + Delivery_Order_Button_Text + " || Delivery Order Module Text: " + Delivery_Order_Frame);
			Extent_pass_New(driver, "Matched || Text of the Delivery Order Button : " + Delivery_Order_Button_Text + " || Delivery Order Module Text: " + Delivery_Order_Frame, test,
					test1);
		} else {
			System.out.println("Not Matched || Text of the Delivery Order Button : " + Delivery_Order_Button_Text + " || Delivery Order Module Text: " + Delivery_Order_Frame);
			Extent_fail(driver, "Not Matched || Text of the Delivery Order Button : " + Delivery_Order_Button_Text + " || Delivery Order Module Text: " + Delivery_Order_Frame,
					test, test1);
		}

		Step_End(7, "once clicked tht delivery order button ,system has open the delivery order module.(Verify the Same name)", test, test1);
		Step_Start(8, "once clicked tht Arrival button ,system has open the arrival notice module.(Verify the Same name", test, test1);
		Extent_call(test, test1, "switch to the import documentation");

		Step_Start(9, "switch to the import documentation", test, test1);
		Step_Start(10, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(11, "click the yes and system has validate import dcoumentation is deleted .", test, test1);

		if(Do_You_Want_Delete.equalsIgnoreCase("Yes")) {
			waitForElement(driver, Import_Documentaion_Module_IMP_DOC);
			click(driver, Import_Documentaion_Module_IMP_DOC);
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		
		Step_End(9, "switch to the import documentation", test, test1);
		Step_End(10, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(11, "click the yes and system has validate import dcoumentation is deleted ", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
