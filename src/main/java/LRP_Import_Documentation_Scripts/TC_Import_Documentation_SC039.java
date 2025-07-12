package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC039 extends Keywords {

	public void Import_Documentation_SC039(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC039";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String bl_Number = Excel_data.get("bl_Number");
		String SavedPopup = Excel_data.get("SavedPopup");
		String Shipper_Seal_Value = Excel_data.get("Shipper_Seal_Value");
		String Carrier_Seal_Value = Excel_data.get("Carrier_Seal_Value");
		String Date_Picker = Excel_data.get("Date_Picker");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
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
		String Container_Numbers=Excel_data.get("Container_Numbers");
		String Empty_Report_Date=Excel_data.get("Empty_Report_Date");
		String Tran_Movement_Value = Excel_data.get("Tran_Movement_Value");
		String Tran_Movement_Verification_Value = Excel_data.get("Tran_Movement_Verification_Value");
		String Customer_Procedure_Value = Excel_data.get("Customer_Procedure_Value");
		String Do_You_Want_Delete = Excel_data.get("Do_You_Want_Delete");
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String condition_filter=Excel_data.get("condition_filter");
		
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);

		Extent_call(test, test1, "********** Switch the Profile - End **********");	
		Extent_call(test, test1, "********** Enter Import Documentation Module **********");
		Step_Start(1, "open the Import Documentation Retrive the new  bill using tool bar search", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
			
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
			waitForElement(driver, Select_Service_Details);
			click(driver, Select_Service_Details);
			
			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);
			
			scrollTop(driver);
			scrollTop(driver);
			if(!pol_Value.trim().equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, condition_filter, pol_Value);
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

			twoColumnMultipleSearchWindow(driver, BL_Number_Header, condition_filter, bl_Number);	
			
		}
		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status = getText(driver, BL_status_IMP_DOC).trim();
		if (!house_BL_Status.equalsIgnoreCase("NEW")) {
			waitForElement(driver, Edit_Button_toolBar);
			jsClick(driver, Edit_Button_toolBar);
		}
		scrollBottom(driver);
		Step_End(1, "open the Import Documentation Retrive the new  bill using tool bar search", test, test1);
		Step_Start(2, "after retrive the bl,go to the container tab", test, test1);
		waitForElement(driver, Container_Tab_IMD);
		click(driver, Container_Tab_IMD);
		scrollBottom(driver);
		Step_End(2, "after retrive the bl,go to the container tab", test, test1);

		Step_Start(3, "select and double click the container in below grid and change the carrier seal and shipper seal.", test, test1);
		List<String> actual_Containers = splitAndExpand(Container_Numbers);
		List<String> Carrier_Seal_Values = splitAndExpand(Carrier_Seal_Value);
		List<String> Shipper_Seal_Values = splitAndExpand(Shipper_Seal_Value);
		List<String> Empty_Report_Dates = splitAndExpand1(Empty_Report_Date);
		List<String> Tran_Movement_Values = splitAndExpand(Tran_Movement_Value);
		List<String> Tran_Movement_Verification_Values = splitAndExpand(Tran_Movement_Verification_Value);
		List<String> Customer_Procedure_Values = splitAndExpand(Customer_Procedure_Value);
		
		for(int i=0; i<actual_Containers.size();i++) {
			String container = String.format(Container_grid, actual_Containers.get(i));
			waitForElement(driver, container);
			doubleClick(driver, container);
			if(!Empty_Report_Dates.get(i).trim().equals("")) {
				waitForElement(driver, IMD_Empty_Report_Date);
				if (Date_Picker.equalsIgnoreCase("Yes")) {
					selectDatePicker(driver, IMD_Empty_Report_Date, Empty_Report_Dates.get(i));
				} 
			}
			waitForElement(driver, Container_Carrier_Seal_TF);
			click(driver, Container_Carrier_Seal_TF);
			if(Carrier_Seal_Values.get(i)!=null&&!Carrier_Seal_Values.get(i).trim().equals("")) {
				waitForElement(driver, Container_Carrier_Seal_TF);
				clear(driver, Container_Carrier_Seal_TF);
				sendKeys(driver, Container_Carrier_Seal_TF, Carrier_Seal_Values.get(i));
			}
			if(Shipper_Seal_Values.get(i)!=null&&!Shipper_Seal_Values.get(i).trim().equals("")) {
				clear(driver, Container_Shipper_Seal_TF);
				sendKeys(driver, Container_Shipper_Seal_TF, Shipper_Seal_Values.get(i));
			}
			if(Tran_Movement_Values.get(i)!=null&&!Tran_Movement_Values.get(i).trim().equals("")) {
				waitForElement(driver, Trans_Movement_DD);
				click(driver, Trans_Movement_DD);
				String trans_Select = String.format(Tran_Movement_Select, Tran_Movement_Values.get(i));
				waitForElement(driver, trans_Select);
				click(driver, trans_Select);
			}

			//new code written by vignesh as per Suresh request
			if(!Customer_Procedure_Values.isEmpty()&&Customer_Procedure_Values.size()>i) {
				if(Customer_Procedure_Values.get(i)!=null&&!Customer_Procedure_Values.get(i).trim().equals("")) {
					waitForElement(driver, Custom_Procedure_Input_ImpDoc);
					click(driver,Custom_Procedure_Input_ImpDoc);
					formatLocatorClick(driver, DropDown_Select,Customer_Procedure_Values.get(i));
				}
			}
			
			//new code written by vignesh as per Suresh request
			
			Step_End(3, "select and double click the container in below grid and change the carrier seal and shipper seal", test, test1);

			Step_Start(4, "after changed the carrier and shipper seal click the edit button", test, test1);
			waitForElement(driver, Container_Edit_Button);
			click(driver, Container_Edit_Button);

			Step_End(4, "after changed the carrier and shipper seal click the edit button", test, test1);
			Step_Start(5, "after clik the edit button it will added in below grid.", test, test1);
			waitForElement(driver, Container_Table_Row);
			mouseOverToElement(driver, Container_Table_Header);
			List<Map<String, String>> container_Tabledata = getTableData(driver, Container_Table_Header, Container_Table_Row);
			
			if(!Carrier_Seal_Values.get(i).trim().equals("")) {
				String container_carrierSeal =getValueByFirstColumnAndHeader(container_Tabledata, "Equipment Id", actual_Containers.get(i), "Carrier Seal");
				if( Carrier_Seal_Values.get(i).equals(container_carrierSeal)) {
					System.out.println("Matched || Expected value was : " +  Carrier_Seal_Values.get(i) + " || Actual value was : " + container_carrierSeal);
					Extent_pass_New(driver, "Matched || Expected value was : " +  Carrier_Seal_Values.get(i) + " || Actual value was : " + container_carrierSeal, test,
							test1);
				} else {
					System.out.println("NotMatched || Expected value was : " +  Carrier_Seal_Values.get(i) + " || Actual value was : " + container_carrierSeal);
					Extent_fail(driver, "NotMatched || Expected value was : " +  Carrier_Seal_Values.get(i) + " || Actual value was : " + container_carrierSeal,
							test, test1);
				}
			}
			if(!Shipper_Seal_Values.get(i).trim().equals("")) {
				String container_shipperSeal  =getValueByFirstColumnAndHeader(container_Tabledata, "Equipment Id", actual_Containers.get(i), "Shipper Seal");
				if(Shipper_Seal_Values.get(i).equals(container_shipperSeal)) {
					System.out.println("Matched || Expected value was : " + Shipper_Seal_Values.get(i) + " || Actual value was : " + container_shipperSeal);
					Extent_pass_New(driver, "Matched || Expected value was : " + Shipper_Seal_Values.get(i) + " || Actual value was : " + container_shipperSeal, test,
							test1);
				} else {
					System.out.println("NotMatched || Expected value was : " + Shipper_Seal_Values.get(i) + " || Actual value was : " + container_shipperSeal);
					Extent_fail(driver, "NotMatched || Expected value was : " + Shipper_Seal_Values.get(i) + " || Actual value was : " + container_shipperSeal,
							test, test1);
				}
			}
			if(!Tran_Movement_Verification_Values.get(i).trim().equals("")) {
				String container_Tran_Movement_Values  =getValueByFirstColumnAndHeader(container_Tabledata, "Equipment Id", actual_Containers.get(i), "Trans. Movement");
				if(Tran_Movement_Verification_Values.get(i).equals(container_Tran_Movement_Values)) {
					System.out.println("Matched || Expected value was : " + Tran_Movement_Verification_Values.get(i) + " || Actual value was : " + container_Tran_Movement_Values);
					Extent_pass_New(driver, "Matched || Expected value was : " + Tran_Movement_Verification_Values.get(i) + " || Actual value was : " + container_Tran_Movement_Values, test,
							test1);
				} else {
					System.out.println("NotMatched || Expected value was : " + Tran_Movement_Verification_Values.get(i) + " || Actual value was : " + container_Tran_Movement_Values);
					Extent_fail(driver, "NotMatched || Expected value was : " + Tran_Movement_Verification_Values.get(i) + " || Actual value was : " + container_Tran_Movement_Values,
							test, test1);
				}
			}
		}

		Step_End(5, "after clik the edit button it will added in below grid.", test, test1);
		Step_Start(6, "click the save button in Import Documentation.", test, test1);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(6, "click the save button in Import Documentation.", test, test1);
		Step_Start(7, "once saved the import documentation system has validate import documentation is saved.", test, test1);
		waitForPopup(driver, popup_Message, SavedPopup);
		String ImportDocumentationSaved=getText(driver, popup_Message);
		if (SavedPopup.equals(ImportDocumentationSaved)) {
			System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
			System.out.println("***Import Documentation Saved***");
			Extent_pass_New(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,
					test1);

		} else {
			System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved,
					test, test1);
		}
		safeclick(driver, popup_Message_Ok_Button);
		Step_End(7, "once saved the import documentation system has validate import documentation is saved.", test, test1);
	
		Step_Start(8, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(9, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(10, "click the yes and system has validate import dcoumentation is deleted .", test, test1);

		if(Do_You_Want_Delete.equalsIgnoreCase("Yes")) {
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Step_End(8, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_End(9, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(10, "click the yes and system has validate import dcoumentation is deleted .", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}

}
