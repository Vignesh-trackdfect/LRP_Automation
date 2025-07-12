package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC054 extends Keywords {

	public void Import_Documentation_SC054(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC054";
		
	String Username = Excel_data.get("Username");
	String Password = Excel_data.get("Password");
	String AgencyUser = Excel_data.get("AgencyUser");
	String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
	String BL_Condition = Excel_data.get("BL_Condition");
	String Manifest_Popup_Value = Excel_data.get("Manifest_Popup_Value");
	String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
	String bl_Number = Excel_data.get("bl_Number");
	String pol_Value = Excel_data.get("pol_Value");
	String Label_Select_2 = Excel_data.get("Label_Select_2");
	String Label_Select_1 = Excel_data.get("Label_Select_1");
	String New_Import_Documentation = Excel_data.get("New_Import_Documentation");
	String Service_Name = Excel_data.get("Service_Name");
	String vesselcode = Excel_data.get("vesselcode");
	String voyagecode = Excel_data.get("voyagecode");
	String bound = Excel_data.get("bound");
	String portcode = Excel_data.get("portcode");
	String terminal = Excel_data.get("terminal");
	String Condition_Filter = Excel_data.get("Condition_Filter");
	
	String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
	String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

	String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
	String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
	String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
	String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
	String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");

	String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
	String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
	
	String POL_Search_Header=Excel_data.get("POL_Search_Header");
	String BL_Number_Header=Excel_data.get("BL_Number_Header");
	
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
		
		globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
		
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
			waitForElement(driver, pol_Text_field);
			twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition_Filter, pol_Value);
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
		
		waitForElement(driver, BL_Number);
		String Get_BL_Number = getAttribute(driver, BL_Number,"value");
		System.out.println("Get_BL_Number:"+ Get_BL_Number);
      
		waitForElement(driver, BL_SearchButton_IMP_DOC);
		click(driver, BL_SearchButton_IMP_DOC);
		twoColumnMultipleSearchWindow(driver, BL_Number_Header, Condition_Filter, bl_Number);	

	}
	
	Step_End(3, "load the bl in search field", test, test1);

	Step_Start(4, "Value has to be shown for all tabs and the value refer from BL/MCN", test, test1);
	waitForElement(driver, BL_status_IMP_DOC);
	String Get_BL_Status = getText(driver, BL_status_IMP_DOC);
	System.out.println("Get_BL_Status:"+ Get_BL_Status);
	Step_End(4, "Value has to be shown for all tabs and the value refer from BL/MCN", test, test1);

	Step_Start(5, "click the save in toolbar import documentation module", test, test1);
	if(Get_BL_Status.equalsIgnoreCase("NEW")){

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		Step_End(5, "click the save in toolbar import documentation module", test, test1);

		Step_Start(6, "System will populate the validaiton Manifest is not closed for this BL", test, test1);
	
		waitForPopup(driver, popup_Message, Manifest_Popup_Value);
		String Manifest_Popup=getText(driver, popup_Message);
		if (Manifest_Popup_Value.equals(Manifest_Popup)) {
			System.out.println("Matched || Expected Popup was : " + Manifest_Popup_Value + " || Actual Popup was : " + Manifest_Popup);
			System.out.println("***Import Documentation Saved***");
			Extent_pass_New(driver, "Matched || Expected Popup was : " + Manifest_Popup_Value + " || Actual Popup was : " + Manifest_Popup, test,
					test1);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + Manifest_Popup_Value + " || Actual Popup was : " + Manifest_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + Manifest_Popup_Value + " || Actual Popup was : " + Manifest_Popup,
					test, test1);
		}
	
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
	
	}else {
		System.out.println("Matched || Expected : Given BL should not be in Saved mode || Actual : Given BL is already Saved" );
		Extent_FailNew(driver, "Matched || Expected : Given BL should not be in Saved mode || Actual : Given BL is already Saved" , test, test1);
	}
	Step_End(6, "System will populate the validaiton Manifest is not closed for this BL", test, test1);
	Extent_completed(testcase_Name, test, test1);

	
	}
}
