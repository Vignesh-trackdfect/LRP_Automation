package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC026 extends Keywords{
	public void Import_Documentation_SC026(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC026";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
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
		String save_All_BL_Popup_Exp = Excel_data.get("save_All_BL_Popup_Exp").trim();
		String documentation_Saved_Popup_Exp = Excel_data.get("documentation_Saved_Popup_Exp").trim();
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String house_BL_Status_Exp = Excel_data.get("house_BL_Status_Exp").trim();
		String saved_BL_Delete = Excel_data.get("saved_BL_Delete").trim();
		String pol_Value=Excel_data.get("pol_Value");
		String ConditionFilter=Excel_data.get("ConditionFilter");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");	
		
		Extent_call(test, test1, "********** Enter Import Documentation Module **********");
		moduleNavigate(driver, ImportDocumentationModule);
		
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
			safeclick(driver, popup_Message_Yes_Button);
		}
		Step_Start(1,"enter  the service in Import Documentation", test, test1);
		waitForElement(driver, ServiceInput_IMD);
		sendKeys(driver, ServiceInput_IMD, Service);
		Step_End(1,"enter  the service in Import Documentation", test, test1);
		Step_Start(2,"once entered the service, System will  auto poplate the  vessel details", test, test1);
		
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
			waitForElement(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC, Port);
		}
		
		if(!Terminal.trim().equals("")) {
			waitForElement(driver, grid_scroll);
			scrollUsingElement(driver, grid_scroll);
			horizontalscroll(driver, grid_scroll, 300);
			click1(driver,grid_terminal_IMP_DOC);
			sendKeys(driver, grid_terminal_IMP_DOC, Terminal);
		}
		Step_End(2,"once entered the service, System will  auto poplate the  vessel details", test, test1);

		Step_Start(3,"select the vessel details and click show Bl's button", test, test1);
		
		waitForElement(driver, Select_Service_Details);
		click(driver, Select_Service_Details);
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
		scrollTop(driver);
		scrollTop(driver);
		if(!pol_Value.trim().equals("")) {
			waitForElement(driver, POLSearch);
			click(driver, POLSearch);
			twoColumnMultipleSearchWindow(driver, POL_Search_Header, ConditionFilter, pol_Value);
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
		
		Step_End(3,"select the vessel details and click show Bl's button", test, test1);
		Step_Start(4,"Once clicked show Bl's button then Bl's has to be shown based on selected service, vessel ,voyage details.", test, test1);
		Step_Start(5,"Select the Local and Transhipment check box and click the Save All Bl's As MasterBL button", test, test1);

		waitForElement(driver, Local_Check_Box);
		checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
		waitForElement(driver, Transhipment_Check_Box);
		checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);
		waitForElement(driver, Transhipment_Check_Box);
		
		waitForElement(driver, Save_All_BL_Button);
		click(driver, Save_All_BL_Button);
		Step_End(4,"Once clicked show Bl's button then Bl's has to be shown based on selected service, vessel ,voyage details.", test, test1);
		Step_End(5,"Select the Local and Transhipment check box and click the Save All Bl's As MasterBL button", test, test1);
		Step_Start(6,"System will populate the validation-''System will save all BLs as Master BL. Do you want to proceed?\" yes or no", test, test1);
			
		waitForPopup(driver, popup_Message, save_All_BL_Popup_Exp);
		String save_All_BL_Popup=getText(driver, popup_Message).trim();
		if (save_All_BL_Popup_Exp.equals(save_All_BL_Popup)) {
			System.out.println("Matched || Expected Popup was : " + save_All_BL_Popup_Exp + " || Actual Popup was : " + save_All_BL_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + save_All_BL_Popup_Exp + " || Actual Popup was : " + save_All_BL_Popup, test,test1);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + save_All_BL_Popup_Exp + " || Actual Popup was : " + save_All_BL_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + save_All_BL_Popup_Exp + " || Actual Popup was : " + save_All_BL_Popup,test, test1);
		}
		Step_End(6,"System will populate the validation-''System will save all BLs as Master BL. Do you want to proceed?\" yes or no", test, test1);
		Step_Start(7,"click the yes then system will populate validate Import Documentation is saved", test, test1);
		Step_Start(8,"all Local and Transhipment bl has saved in import documentation.", test, test1);
		Step_Start(9," once saved the import documentation system has validate import documentation is saved", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		
		waitForPopup(driver, popup_Message, documentation_Saved_Popup_Exp);
		String documentation_Saved_Popup=getText(driver, popup_Message);
		if (documentation_Saved_Popup_Exp.equals(documentation_Saved_Popup)) {
			System.out.println("Matched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup, test,test1);
			click(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup,test, test1);
		}
		
		Set<String> ShipmentCase_BL=new HashSet<String>();
		if(isdisplayed(driver, Shipment_Case_Popup_IMD)) {
			List<WebElement> BL_Shipment=listOfElements(driver, Shipment_Case_BL_Numbers_IMD);
			for(WebElement Ele:BL_Shipment) {
				String ShipmentBL=Ele.getText();
				ShipmentCase_BL.add(ShipmentBL);
			}
			
			while(isdisplayed(driver, Ok_Btn_ShipmentCasePopup_IMD)) {
				waitForElement(driver, Ok_Btn_ShipmentCasePopup_IMD);
				click(driver,Ok_Btn_ShipmentCasePopup_IMD);
			}
			
			System.out.println("After clicking the Save All BL button Popups displayed with this BL Numbers : "+ShipmentCase_BL);
			Extent_pass_New(driver, "After clicking the Save All BL button Popups displayed with this BL Numbers : "+ShipmentCase_BL, test, test1);
		}
		
		Step_End(7,"click the yes then system will populate validate Import Documentation is saved", test, test1);
		Step_End(8,"all Local and Transhipment bl has saved in import documentation.", test, test1);
		Step_End(9,"once saved the import documentation system has validate import documentation is saved", test, test1);

		String BL_LABEL_COUNT=getText(driver, BL_Count);
		int[] BL_CountDisplay=getBlCount(BL_LABEL_COUNT);
		int Endvalue=BL_CountDisplay[1];
		int firstvalue=BL_CountDisplay[0];
		int firstVal=firstvalue;
		try {
			if(firstVal>1) {
				while(firstVal==1) {
					safeclick(driver, Previous_BL_Button);
					waitForDisplay(driver, Previous_BL_Button);
					String BL_LABEL_COUNT1=getText(driver, BL_Count);
					int[] BL_CountDisplay1=getBlCount(BL_LABEL_COUNT1);
					firstVal=BL_CountDisplay1[0];
				}
			}
		}catch(Exception e) {
			
		}
		
		List<String> savedBlValues=new ArrayList<String>();
		for(int k=1;k<Endvalue;k++) {
			waitForElement(driver, BL_status_IMP_DOC);
			String BL_Status_Act=getText(driver, BL_status_IMP_DOC);
			String BL_NumberValue=getAttribute(driver, BL_Number, "value");
			
			if(!ShipmentCase_BL.contains(BL_NumberValue)) {
				if(BL_Status_Act.contains(house_BL_Status_Exp)) {
					System.out.println("House BL Status Matched for "+BL_NumberValue+" || Expected value was : " + house_BL_Status_Exp + " || Actual value was : " + BL_Status_Act);
					Extent_pass_New(driver, "House BL Status Matched for "+BL_NumberValue+" || Expected value was : " + house_BL_Status_Exp + " || Actual value was : " + BL_Status_Act, test,test1);
					savedBlValues.add(BL_NumberValue);
				} else {
					System.out.println("House BL Status Not Matched for "+BL_NumberValue+" || Expected value was : " + house_BL_Status_Exp + " || Actual value was : " + BL_Status_Act);
					Extent_fail(driver, "House BL Status Not Matched for "+BL_NumberValue+" || Expected value was : " + house_BL_Status_Exp + " || Actual value was : " + BL_Status_Act,test, test1);
				}
			}
			waitForElement(driver, Next_BL_Button);
			click(driver,Next_BL_Button);
			
			waitForDisplay(driver, popup_Message_Yes_Button);
			if(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver,popup_Message_Yes_Button);
			}
		}
		
		Extent_pass_New(driver, "Un Saved BL Numbers : "+ShipmentCase_BL, test,test1);
		
		if(saved_BL_Delete.equals("Yes")) {
			for(int k=0;k<savedBlValues.size();k++) {
				Step_Start(10,"once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
				String bl_Number=savedBlValues.get(k);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				waitForElement(driver, globalSearch_Condition_Dropdown1);
				selectByText(driver, globalSearch_Condition_Dropdown1, dropdownCondition1);
				waitForElement(driver, globalSearch_InputTextfield1);
				sendKeys(driver, globalSearch_InputTextfield1,bl_Number);
				waitForElement(driver, globalSearch_Frame_SearchButton);
				click(driver, globalSearch_Frame_SearchButton);
				waitForElement(driver, ClosePopup);
				String retrieved_BL_Number=String.format(retrive_Bl, bl_Number);
				if(isDisplayed(driver, retrieved_BL_Number)) {
					waitForElement(driver, retrieved_BL_Number);
					click(driver, retrieved_BL_Number);
					waitForElement(driver, SelectButton);
					click(driver,SelectButton);
					waitForDisplay(driver, BL_status_IMP_DOC);
					waitForElement(driver, Delete_button_toolBar);
					click(driver,Delete_button_toolBar);
					Step_Start(11,"click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
					waitForElement(driver, popup_Message_Yes_Button);
					click(driver, popup_Message_Yes_Button);
					Step_End(11,"click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
					Step_Start(12,"click the yes and system has validate import dcoumentation is deleted", test, test1);
					waitForElement(driver, popup_Message_Ok_Button);
					click(driver,popup_Message_Ok_Button);
					waitForElement(driver, cancel_Common_btn);
					click(driver, cancel_Common_btn);
					Step_End(12,"click the yes and system has validate import dcoumentation is deleted", test, test1);
				}else {
					Extent_fail(driver, "Expected BL '"+bl_Number+"' is not present After Searched it, Unable to delete the BL Value", test, test1);
					click(driver,ClosePopup);
				}
			}
			Step_End(10,"once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		}
		
		Extent_completed(testcase_Name, test, test1);
	}
}
