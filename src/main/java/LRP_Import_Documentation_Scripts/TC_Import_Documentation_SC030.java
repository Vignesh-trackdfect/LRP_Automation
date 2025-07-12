package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC030  extends Keywords{
	public void Import_Documentation_SC030(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC030";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String bl_Number = Excel_data.get("bl_Number");
		String documentation_Saved_Popup_Exp = Excel_data.get("documentation_Saved_Popup_Exp").trim();
		String House_BL_Status_Exp = Excel_data.get("House_BL_Status_Exp").trim();
		String House_BL_Saved_Status_Exp = Excel_data.get("House_BL_Saved_Status_Exp").trim();
		String House_BL_Number = Excel_data.get("House_BL_Number");
		String House_BL_Select_All_Container=Excel_data.get("House_BL_Select_All_Container");
		String House_BL_Containers_Select=Excel_data.get("House_BL_Containers_Select");
		//new 
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String do_you_want_to_delete = Excel_data.get("do_you_want_to_delete");
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
		String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
		String condition=Excel_data.get("condition");
		String pol_Value=Excel_data.get("pol_Value");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");	
		
		Extent_call(test, test1, "********** Enter Import Documentation Module **********");
		moduleNavigate(driver, ImportDocumentationModule);

		Step_Start(1, "Open the Import Documentation Retrive the  NEW bill using tool bar search.", test, test1);
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {

			waitForElement(driver, SearchButton_Toolbar );
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, dropdownCondition1, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
				
				newButton(driver);
				waitForElement(driver, ServiceInput_IMD );
				sendKeys(driver, ServiceInput_IMD , first_service_data);
				
				if(!Vessels.trim().equals("")) {
					waitForElement(driver, grid_vesselcode_IMP_DOC);
					sendKeys(driver, grid_vesselcode_IMP_DOC ,Vessels);
				}
				
				if(!Voyagenumber1.trim().equals("")) {
					waitForElement(driver, grid_voyagecode_IMP_DOC);
					sendKeys(driver, grid_voyagecode_IMP_DOC , Voyagenumber1);
				}
				
				if(!Boundinput.trim().equals("")) {
					waitForElement(driver, grid_bound_IMP_DOC);
					sendKeys(driver, grid_bound_IMP_DOC, Boundinput);
				}
				
				if(!portCode.trim().equals("")) {
					waitForElement(driver, grid_portcodeIMP_DOC);
					sendKeys(driver, grid_portcodeIMP_DOC , portCode);
				}
				
				if(!terminalCode.trim().equals("")) {
					horizontalscroll(driver, grid_scroll, 300);		
					click(driver, grid_terminal_IMP_DOC);
					sendKeys(driver, grid_terminal_IMP_DOC , terminalCode);
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
					twoColumnMultipleSearchWindow(driver, POL_Search_Header, condition, pol_Value);
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
				
				twoColumnMultipleSearchWindow(driver, BL_Number_Header, condition, bl_Number);
				
		}

		Step_End(1, "Open the Import Documentation Retrive the  NEW bill using tool bar search.", test, test1);
		
		Step_Start(2, "after retrive the bl ", test, test1);
		deleteSavedBL(driver,House_BL_Status_Exp,dropdownCondition1,bl_Number);
		Step_End(2, "after retrive the bl ", test, test1);
		
		Step_Start(2, "A. Master and House Bl button has avaliable then click the house button", test, test1);
		waitForElement(driver, House_Button_Imp_DOC);
		click(driver, House_Button_Imp_DOC);
		Step_End(2, "A. Master and House Bl button has avaliable then click the house button", test, test1);
		
		scrollBottom(driver);
		
		List<String> HouseBL_NewNumbers=splitAndExpand(House_BL_Number,",");
		List<String> ContainerValues=splitAndExpand(House_BL_Containers_Select,"/");
		Map<String,List<String>> HouseBL_Container=new HashMap<String,List<String>>();
		for(int k=0;k<HouseBL_NewNumbers.size();k++) {
			String HouseBL=HouseBL_NewNumbers.get(k);
			List<String> HouseBLContainer=splitAndExpand(ContainerValues.get(k));
			HouseBL_Container.put(HouseBL, HouseBLContainer);
		}
		
		if(HouseBL_NewNumbers.size()<2) {
			Step_Start(3, "Enter the HouseblNo and click the add in HBL updation Tab", test, test1);
			Step_Start(4, "we can add more than one hosue bL", test, test1);
			List<String> ContainerLists=splitAndExpand2(House_BL_Containers_Select);
			waitForElement(driver, House_BL_Field);
			sendKeys(driver, House_BL_Field, House_BL_Number);
			click(driver, Add_House_BL_Button);
			Step_End(3, "Enter the HouseblNo and click the add in HBL updation Tab", test, test1);
			Step_End(4, "we can add more than one hosue bL", test, test1);
			Step_Start(5, "select the hosuebl using h.bl.no dropdown", test, test1);
			waitForElement(driver, HBL_No_DropDown1);
			mouseOverToElement(driver, HBL_No_DropDown1);
			click(driver, HBL_No_DropDown1);//changed
			String DropDown_Select1 = String.format(ImportDocumentation_Locators.House_No_Select1,House_BL_Number);
			waitForElement(driver, DropDown_Select1);
			click(driver, DropDown_Select1);
			Step_End(5, "select the hosuebl using h.bl.no dropdown", test, test1);
			Step_Start(6, "select  the check box-container and click the add in Hbl Updation Tab", test, test1);
			if(House_BL_Select_All_Container.equals("Yes")) {
				checkBox(driver, HBL_Check_Box, "Yes");		
			}else {
				selectSpecificContainers(driver,ContainerLists);
			}
			mouseOverToElement(driver, Package_Add_Button);
			click(driver, Package_Add_Button);
			waitForElement(driver, HBL_Table_Row);
			Step_End(6, "select  the check box-container and click the add in Hbl Updation Tab", test, test1);

		}else {
			for(int i=0;i<HouseBL_NewNumbers.size();i++) {
				Step_Start(3, "Enter the HouseblNo and click the add in HBL updation Tab", test, test1);
				Step_Start(4, "we can add more than one hosue bL", test, test1);
				String New_BL_Number=HouseBL_NewNumbers.get(i);
				System.out.println("New_BL_Number : "+New_BL_Number);
				waitForElement(driver, House_BL_Field);
				sendKeys(driver, House_BL_Field, New_BL_Number);
				click(driver, Add_House_BL_Button);
				Step_End(3, "Enter the HouseblNo and click the add in HBL updation Tab", test, test1);
				Step_End(4, "we can add more than one hosue bL", test, test1);
				
				Step_Start(5, "select the hosuebl using h.bl.no dropdown", test, test1);
				waitForElement(driver, HBL_No_DropDown1);//changed
				mouseOverToElement(driver, HBL_No_DropDown1);
				click(driver, HBL_No_DropDown1);//changed
				String DropDown_Select1 = String.format(ImportDocumentation_Locators.House_No_Select1,New_BL_Number);
				waitForElement(driver, DropDown_Select1);
				click(driver, DropDown_Select1);
				Step_End(5, "select the hosuebl using h.bl.no dropdown", test, test1);
			
				Step_Start(6, "select  the check box-container and click the add in Hbl Updation Tab", test, test1);
				List<String> BL_Containers=HouseBL_Container.get(New_BL_Number);
				selectSpecificContainers(driver,BL_Containers);
				mouseOverToElement(driver, Package_Add_Button);
				click(driver, Package_Add_Button);
				waitForElement(driver, HBL_Table_Row);
				Step_End(6, "select  the check box-container and click the add in Hbl Updation Tab", test, test1);
			}
		}
		
		Step_Start(7, "After adding the House bl and container then cick the save button in import documentation ", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(7, "After adding the House bl and container then cick the save button in import documentation ", test, test1);
		
		Step_Start(8, "system will validate 'Import Documentation-Balance is not zero. Charge amount is not splitted. Do you want to proceed?' YES OR NO'", test, test1);
		waitForDisplay(driver, popup_Message);
		while(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
			waitForDisplay(driver, popup_Message_Yes_Button);
		}
		Step_End(8, "system will validate 'Import Documentation-Balance is not zero. Charge amount is not splitted. Do you want to proceed?' YES OR NO'", test, test1);
		Step_Start(9, "Click the Yes ,BL has saved in Import Documentation -System will popluate the validate ''Import Documentation is saved", test, test1);
		waitForPopup(driver, popup_Message, documentation_Saved_Popup_Exp);
		String documentation_Saved_Popup = getText(driver, popup_Message);
		if (documentation_Saved_Popup_Exp.equals(documentation_Saved_Popup)) {
			System.out.println("Matched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup, test,test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup,test, test1);
		}
		Step_End(9, "Click the Yes ,BL has saved in Import Documentation -System will popluate the validate ''Import Documentation is saved", test, test1);
		Step_Start(10, "once saved the import documentation system has validate import documentation is saved", test, test1);
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status=getText(driver, BL_status_IMP_DOC).trim();
		if (House_BL_Saved_Status_Exp.equals(house_BL_Status)) {
			System.out.println("Matched || Expected Popup was : " + House_BL_Saved_Status_Exp + " || Actual Popup was : " + house_BL_Status);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + House_BL_Saved_Status_Exp + " || Actual Popup was : " + house_BL_Status, test,test1);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + House_BL_Saved_Status_Exp + " || Actual Popup was : " + house_BL_Status);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + House_BL_Saved_Status_Exp + " || Actual Popup was : " + house_BL_Status,test, test1);
		}
		Step_End(10, "once saved the import documentation system has validate import documentation is saved", test, test1);
		Step_Start(11, "HBL No dropdownfield has shown click the dropdown", test, test1);
		waitForElement(driver, HBL_No_DropDown);
		click(driver, HBL_No_DropDown);
		Step_End(11, "HBL No dropdownfield has shown click the dropdown", test, test1);

		
		Extent_call(test, test1, "house bl no has to be shown-----verify------HBL number Has to shows as Given Earlier");
		List<String> DropDown_Values = new ArrayList<>();
		List<WebElement> dropdown_Values =listOfElements(driver, HouseBL_List);
		for(WebElement dropdown_Value : dropdown_Values) {
			String value = dropdown_Value.getText();
			DropDown_Values.add(value);
		}
		DropDown_Values.remove(0);
		
		if(HouseBL_NewNumbers.equals(DropDown_Values)) {
			System.out.println("Matched || House BL Dropdown Values are : "+DropDown_Values+" || The Actual Newly Added House BL number is : " + HouseBL_NewNumbers);
			Extent_pass_New(driver,"Matched || House BL Dropdown Values are : "+DropDown_Values+" || The Actual Newly Added House BL number is : " + HouseBL_NewNumbers, test,test1);
		} else {
			System.out.println("NotMatched || House BL Dropdown Values are : "+DropDown_Values+" || The Actual Newly Added House BL number is : " + HouseBL_NewNumbers);
			Extent_fail(driver,"NotMatched || House BL Dropdown Values are : "+DropDown_Values+" || The Actual Newly Added House BL number is : " + HouseBL_NewNumbers,test, test1);
		}
		Extent_call(test, test1, "house bl no has to be shown-----verify------HBL number Has to shows as Given Earlier");
	
		Extent_call(test, test1, "Delete the import Documentation");
		if(do_you_want_to_delete.equalsIgnoreCase("YES")){
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Extent_call(test, test1, "Delete the import Documentation");
		
		Extent_completed(testcase_Name, test, test1);
	}
}
