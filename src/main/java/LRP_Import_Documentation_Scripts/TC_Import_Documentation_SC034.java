package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC034 extends Keywords {

	public void Import_Documentation_SC034(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
	
	String testCaseName="TC_Import_Documentation_SC034";
	String Username = Excel_data.get("Username");
	String Password = Excel_data.get("Password");
	String AgencyUser = Excel_data.get("AgencyUser");
	String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
	String BL_Condition = Excel_data.get("BL_Condition");
	String SavedPopup = Excel_data.get("SavedPopup");
	String MarksandNo_Input = Excel_data.get("MarksandNo_Input");
	String Cargo_Description_Input = Excel_data.get("Cargo_Description_Input");
	String Service_Name = Excel_data.get("Service_Name");
	String vesselcode = Excel_data.get("vesselcode");
	String voyagecode = Excel_data.get("voyagecode");
	String bound = Excel_data.get("bound");
	String portcode = Excel_data.get("portcode");
	String terminal = Excel_data.get("terminal");
	String New_Import_Documentation = Excel_data.get("New_Import_Documentation");
	String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
	String bl_Number = Excel_data.get("bl_Number");
	String pol_Value = Excel_data.get("pol_Value");
	String Label_Select_2 = Excel_data.get("Label_Select_2");
	String Label_Select_1 = Excel_data.get("Label_Select_1");
	String UpdatedPopup = Excel_data.get("UpdatedPopup");
	String Condition = Excel_data.get("Condition");
	String Delete_Perform = Excel_data.get("Delete_Perform");
	String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
	String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
	String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
	String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
	String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
	String POL_Search_Header=Excel_data.get("POL_Search_Header");
	String BL_Number_Header=Excel_data.get("BL_Number_Header");
	String Delete_Confirmation_Popup=Excel_data.get("Delete_Confirmation_Popup");
	String Delete_Success_Popup=Excel_data.get("Delete_Success_Popup");

	
	//String Get_BL_Number;
	String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
	String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

	Extent_Start(testCaseName, test, test1);
	//Login
	navigateUrl(driver,url);

	LRP_Login(driver, Username, Password);
	verifyMainMenu(driver);
	
	SwitchProfile(driver, AgencyUser);

    Step_Start(1, "open the In Import Documentation and  Retrive the  bill using tool bar search", test, test1);
	moduleNavigate(driver, ImportDocumentationModule);

	if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
		click(driver, SearchButton_Toolbar);
		waitForElement(driver, SearchButton_Toolbar );
		
		globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

	}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
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
			twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition, pol_Value);
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
		
		waitForElement(driver, BL_SearchButton_IMP_DOC);
		click(driver, BL_SearchButton_IMP_DOC);
		
		twoColumnMultipleSearchWindow(driver, BL_Number_Header, Condition, bl_Number);			

	}

	Step_End(1, "open the In Import Documentation and  Retrive the  bill using tool bar search.", test, test1);
	
	scrollTop(driver);
	waitForElement(driver, BL_status_IMP_DOC);
	String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
	if (!house_BL_Status.equalsIgnoreCase("NEW")) {
		waitForElement(driver, Edit_Button_toolBar);
		jsClick(driver, Edit_Button_toolBar);
	}

	waitForElement(driver, BL_status_IMP_DOC);
	String Get_BL_Status = getText(driver, BL_status_IMP_DOC);
	System.out.println("Get_BL_Status:"+ Get_BL_Status);


	Step_Start(2, "after retrive the bl,go to the BL/HBL Summary Tab", test, test1);
	waitForElement(driver, BL_HBL_Summary_Tab);
	safeclick(driver, BL_HBL_Summary_Tab);
	Step_End(2, "after retrive the bl,go to the BL/HBL Summary Tab", test, test1);
	scrollBottom(driver);
	Step_Start(3, "remove and  enter the value in Marks & No Field.", test, test1);
	if(!MarksandNo_Input.trim().equals("")) {
		waitForElement(driver, Marks_and_No_TextArea);
		Newclear(driver, Marks_and_No_TextArea);
		sendKeys(driver, Marks_and_No_TextArea, MarksandNo_Input);
	}
	Step_End(3, "remove and  enter the value in Marks & No Field.", test, test1);
	
	Step_Start(4, "remove and  enter  the value in Cargo Description.", test, test1);
	if(!Cargo_Description_Input.trim().equals("")) {
		waitForElement(driver, Cargo_Description);
		Newclear(driver, Cargo_Description);
		sendKeys(driver, Cargo_Description, Cargo_Description_Input);
	}
	Step_End(4, "remove and  enter  the value in Cargo Description.", test, test1);
	
	scrollTop(driver);
	Step_Start(5, "click the save button  in tool bar.", test, test1);
	scrollTop(driver);
	waitForElement(driver, SaveButton_ToolBar);
	jsClick(driver, SaveButton_ToolBar);

	Step_End(5, "click the save button  in tool bar.", test, test1);
	
	Step_Start(6, "System has popluate the validate import documentation is saved", test, test1);

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
		
	Step_End(6, "System has popluate the validate import documentation is saved", test, test1);
	Step_Start(7, "Bl has saved in Import Documentation.", test, test1);
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver, popup_Message_Ok_Button);

	scrollBottom(driver);
	Step_End(7, "Bl has saved in Import Documentation.", test, test1);
	
	Step_Start(8, "Marks & No Field and Cargo Description Values has to Match as per the Given Data", test, test1);
	if(!MarksandNo_Input.trim().equals("")) {
		waitForElement(driver, Marks_and_No_TextArea);
		String Updated_MarksAndNo=getText(driver, Marks_and_No_TextArea);
		if((MarksandNo_Input.trim()).equals(Updated_MarksAndNo)) {
			System.out.println("Matched || Expected value was : \n" + MarksandNo_Input + " || Actual value was :  \n" + Updated_MarksAndNo);
			Extent_pass_New(driver, "Matched || Expected value was :  \n" + MarksandNo_Input + " || Actual value was :  \n" + Updated_MarksAndNo, test,
					test1);

		} else {
			System.out.println("NotMatched || Expected value was :  \n" + MarksandNo_Input + " || Actual value was :  \n" + Updated_MarksAndNo);
			Extent_fail(driver, "NotMatched || Expected value was :  \n" + MarksandNo_Input + " || Actual value was :  \n" + Updated_MarksAndNo,
					test, test1);
		}
	}
	
	if(!Cargo_Description_Input.trim().equals("")) {
		waitForElement(driver, Cargo_Description);
		String Updated_Cargo_Description=getText(driver, Cargo_Description);
		if((Cargo_Description_Input.trim()).equals(Updated_Cargo_Description)) {
			System.out.println("Matched || Expected value was :  \n" + Cargo_Description_Input + " || Actual value was :  \n" + Updated_Cargo_Description);
			Extent_pass_New(driver, "Matched || Expected value was :  \n" + Cargo_Description_Input + " || Actual value was :  \n" + Updated_Cargo_Description, test,
					test1);

		} else {
			System.out.println("NotMatched || Expected value was : \n " + Cargo_Description_Input + " || Actual value was : \n " + Updated_Cargo_Description);
			Extent_fail(driver, "NotMatched || Expected value was : \n " + Cargo_Description_Input + " || Actual value was :  \n" + Updated_Cargo_Description,
					test, test1);
		}
	}
	Step_End(8, "Marks & No Field and Cargo Description Values has to Match as per the Given Data", test, test1);

	Step_Start(9, ".click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
	Step_Start(10, "click the yes and system has validate import dcoumentation is deleted .", test, test1);
	
	scrollTop(driver);
	if(Delete_Perform.equalsIgnoreCase("YES")){
		deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
	}
	
	Step_End(9, ".click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
	Step_End(10, "click the yes and system has validate import dcoumentation is deleted .", test, test1);
	
	Extent_completed(testCaseName, test, test1);
	
	}
}
