package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



import java.util.List;

public class TC_Import_Documentation_SC040 extends Keywords {

	public void Import_Documentation_SC040(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC040";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");	
		String Module_Search = Excel_data.get("Module_Search");	
		String Customer_Updated_Popup= Excel_data.get("Customer_Updated_Popup");	
		String Delete_Updated_popup = Excel_data.get("Delete_Updated_popup");
		String Delete_Updated_popup_Confirmation = Excel_data.get("Delete_Updated_popup_Confirmation");
		String Equipment_Number = Excel_data.get("Equipment_Number");
		String Carrier_Seal_Value= Excel_data.get("Carrier_Seal_Value");	
		String Shipper_Seal_Value= Excel_data.get("Shipper_Seal_Value");	
		String Customer_Procedure_Value= Excel_data.get("Customer_Procedure_Value");	
		String bl_Number = Excel_data.get("bl_Number");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String master_BL_Status = Excel_data.get("Master_BL_Status");
		String container_Table_Headers = Excel_data.get("Container_Table_Headers");
		String container_Table_Name = Excel_data.get("Container_Table_Name");
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		
		String NewImportDocumentationPopup = Excel_data.get("NewImportDocumentationPopup");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Terminal = Excel_data.get("Terminal");
		String Port = Excel_data.get("Port");
		String all_Dropdown_1 = Excel_data.get("All_Dropdown_1");
		String all_Dropdown_2 = Excel_data.get("All_Dropdown_2");
		String POL_Loction = Excel_data.get("POL_Loction");
		String BL_Retrieve_Option = Excel_data.get("BL_Retrieve_Option");
		String wantToDelete = Excel_data.get("WantToDelete");
		String ConditionFilter = Excel_data.get("ConditionFilter");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		SwitchProfile(driver, agencyUser);

		Step_Start(1, "open the Import Documentation Retrive the SAVED bill using tool bar search.", test, test1);

		moduleNavigate(driver, Module_Search);
		
		if(BL_Retrieve_Option.equals("By Service")) {
			
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
			if(!POL_Loction.trim().equals("")) {
				waitForElement(driver, POLSearch);
				safeclick(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, ConditionFilter, POL_Loction);
			}
			
			waitForElement(driver, all_Dropdown_1_IMD);
			click(driver, all_Dropdown_1_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_1);
			
			waitForElement(driver, all_Dropdown_2_IMD);
			click(driver, all_Dropdown_2_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_2);
		
			waitForElement(driver, Show_BL_Button);
			safeclick(driver, Show_BL_Button);
			
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, ConditionFilter, bl_Number);	
			
		}else if(BL_Retrieve_Option.equals("By BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, dropdownCondition1, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
		
		}	
		
		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status=getText(driver, BL_status_IMP_DOC);
		if(actual_Master_BL_Status.equals(master_BL_Status)) {
			waitForElement(driver, SaveButton_ToolBar);
			jsClick(driver, SaveButton_ToolBar);
			
			waitForPopup(driver, popup_Message,"Import Documentation Saved");
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button);
			
		}
		Step_End(1, "open the Import Documentation Retrive the SAVED bill using tool bar search.", test, test1);

		Step_Start(2, "after retrive the bl,go to the container tab.", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver, Container_Tab_IMD);
		click(driver, Container_Tab_IMD);
		
		Step_End(2, "after retrive the bl,go to the container tab.", test, test1);
		

		//Vignesh, Here i have changed the code from waitfordisplay into waitforElement, in order to avoid the loading issue.
		waitForElement(driver, Container_Table_Header);
		List<Map<String, String>> before_container_Tabledata = getTableDatawithscroll(driver, Container_Table_Header, Container_Table_Row,Container_Table_Scroll, 80, -3600);
		List<String> columnheaders = splitAndExpand(container_Table_Headers);
		String container_Tabledata_before = TableDataForReport(driver, before_container_Tabledata,container_Table_Name,columnheaders);
		List<List<String>> importDocumentation_Container_Table = getValuesByHeaders(before_container_Tabledata, columnheaders);

		List<String> EquipmentNumber = splitAndExpand(Equipment_Number);
		List<String> Carrier_Seal = splitAndExpand(Carrier_Seal_Value);
		List<String> Shipper_Seal = splitAndExpand(Shipper_Seal_Value);
		List<String> Customer_Procedure_Values = splitAndExpand(Customer_Procedure_Value);

		scrollBottom(driver);
		int i=0;
		for(String eqp_No:EquipmentNumber) {
			if(eqp_No!=null&&!eqp_No.trim().equals("")) {
				Step_Start(3, "select and double click the container in below grid and change the carrier seal and shipper seal same as another contaner based on the data sheet.", test, test1);

				String selectContainer_Row=String.format(container_Tab_Row_IMD, eqp_No);
				waitForElement(driver, selectContainer_Row);
				doubleClick(driver, selectContainer_Row);
		
				Step_End(3, "select and double click the container in below grid and change the carrier seal and shipper seal same as another contaner based on the data sheet.", test, test1);

				String carrierSeal_Input=Carrier_Seal.get(i).trim();
				if(!carrierSeal_Input.equals("")) {
					waitForElement(driver, Container_Carrier_Seal_TF);
					Newclear(driver, Container_Carrier_Seal_TF);
					sendKeys(driver, Container_Carrier_Seal_TF, carrierSeal_Input);
				}
				String shipperSeal_Input=Shipper_Seal.get(i).trim();
				
				if(!shipperSeal_Input.equals("")) {
					Newclear(driver, Container_Shipper_Seal_TF);
					sendKeys(driver, Container_Shipper_Seal_TF, shipperSeal_Input);
				}
				
				//new code written by vignesh as per Suresh request
				if(!Customer_Procedure_Values.isEmpty()&&Customer_Procedure_Values.size()>i) {
					if(!Customer_Procedure_Values.get(i).trim().equals("")) {
						waitForElement(driver, Custom_Procedure_Input_ImpDoc);
						click(driver,Custom_Procedure_Input_ImpDoc);
						formatLocatorClick(driver, DropDown_Select,Customer_Procedure_Values.get(i) );
					}
				}
				//new code written by vignesh as per Suresh request
			}
			Step_Start(4, "after changed the carrier and shipper seal click the edit button.", test, test1);
		    
			waitForElement(driver, Container_Edit_Button);
			click(driver, Container_Edit_Button);
		   	
		   	Step_End(4, "after changed the carrier and shipper seal click the edit button.", test, test1);
		   	i++;	
		}
		
		
	   	Step_Start(5, "after clik the edit button it will added in below grid.", test, test1);
	   	
	   	waitForElement(driver, Container_Table_Row);
	   	mouseOverToElement(driver, Container_Table_Row);
	   	List<Map<String, String>> after_container_Tabledata = getTableDatawithscroll(driver, Container_Table_Header, Container_Table_Row,Container_Table_Scroll, 80, -3600);
		String container_Tabledata_after = TableDataForReport(driver, after_container_Tabledata,container_Table_Name,columnheaders);
		List<List<String>> importDocumentation_Container_Table1 = getValuesByHeaders(before_container_Tabledata, columnheaders);

		if(compareTableData(importDocumentation_Container_Table, importDocumentation_Container_Table1)) {
	   		Extent_pass_New(driver, "Passed || Before Editing Container Tab : \n" + "<pre>" +container_Tabledata_before + "</pre>"+"\n" + " || After Editing Container Tab :  \n" + "<pre>" + container_Tabledata_after + "</pre>", test, test1);
		}else {
			Extent_fail(driver, "Failed || Before Editing Container Tab : \n" + "<pre>" +container_Tabledata_before + "</pre>"+"\n" + " || After Editing Container Tab :  \n" + "<pre>" + container_Tabledata_after + "</pre>", test, test1);
		}

	   	Step_End(5, "after clik the edit button it will added in below grid.", test, test1);
	   	Step_Start(6, "click the save button in Import Documentation.", test, test1);

	   	scrollTop(driver);
	   	waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
	   
	   	Step_End(6, "click the save button in Import Documentation.", test, test1);
	   	Step_Start(7, "once saved the import documentation system has validate import documentation is updated", test, test1);
		
		waitForPopup(driver, popup_Message, Customer_Updated_Popup);
		String Cus_Updated_Popup=getText(driver, popup_Message);
		if (Customer_Updated_Popup.equals(Cus_Updated_Popup)) {
			System.out.println("Matched || Expected Popup was : " + Customer_Updated_Popup + " || Actual Popup was : " + Cus_Updated_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + Customer_Updated_Popup + " || Actual Popup was : " + Cus_Updated_Popup, test,
					test1);

		} else {
			System.out.println("NotMatched || Expected Popup was : " + Customer_Updated_Popup + " || Actual Popup was : " + Cus_Updated_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + Customer_Updated_Popup + " || Actual Popup was : " + Cus_Updated_Popup,
					test, test1);
		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
	   	Step_End(7, "once saved the import documentation system has validate import documentation is updated", test, test1);

	   	Extent_call(test, test1, "7A.Verify that Shipper and Carrier Seal has to match with Given Data");
	   	
	   	scrollBottom(driver);
	   	int j=0;
		for(String eqp_No:EquipmentNumber) {
			waitForElement(driver, Container_Table_Header);
			List<Map<String, String>> After_container_Tabledata =getTableDatawithscroll(driver, Container_Table_Header, Container_Table_Row,Container_Table_Scroll, 80, -3600);
		 	String firstcolumnHeader1 = "Equipment Id";
			String firstColumnValue1 = eqp_No; // Example first column value
		 	String After_Carrier_Seal_value = getValueByFirstColumnAndHeader(After_container_Tabledata,firstcolumnHeader1, firstColumnValue1,  "Carrier Seal");
			String After_Shipper_Seal_value = getValueByFirstColumnAndHeader(After_container_Tabledata,firstcolumnHeader1, firstColumnValue1,  "Shipper Seal");
 	
			
			
			if(eqp_No!=null&&!eqp_No.equals(" ")) {

			String carrierSeal_Input=Carrier_Seal.get(j).trim();
			if(!carrierSeal_Input.equals(" ")) {
				if(!carrierSeal_Input.equals(" ")) {
					if(After_Carrier_Seal_value.equals(carrierSeal_Input)) {
				   		System.out.println("Matched || Expected Carrier Seal for "+ eqp_No+" : " + carrierSeal_Input + " || Actual Carrier Seal for "+eqp_No+ ": " + After_Shipper_Seal_value);
						Extent_pass_New(driver, "Matched || Expected Carrier Seal for "+ eqp_No+" : " + carrierSeal_Input + " || Actual Carrier Seal for "+eqp_No+ ": " + After_Shipper_Seal_value, test,
								test1);
	
					} else {
						System.out.println("Not Matched || Expected Carrier Seal for "+ eqp_No+" : " + carrierSeal_Input + " || Actual Carrier Seal for "+eqp_No+ ": " + After_Shipper_Seal_value);
						Extent_fail(driver, "Not Matched || Expected Carrier Seal for "+ eqp_No+" : " + carrierSeal_Input + " || Actual Carrier Seal for "+eqp_No+ ": " + After_Shipper_Seal_value, test,
								test1);
					}
				}
				
			}
			String shipperSeal_Input=Shipper_Seal.get(j).trim();
			if(!shipperSeal_Input.equals(" ")) {
				if(After_Shipper_Seal_value.equals(shipperSeal_Input)) {
			   		System.out.println("Matched || Expected Shipper Seal for "+ eqp_No+" : " + shipperSeal_Input + " || Actual Shipper Seal for "+eqp_No+ ": " + After_Shipper_Seal_value);
					Extent_pass_New(driver, "Matched || Expected Shipper Seal for "+ eqp_No+" : " + shipperSeal_Input + " || Actual Shipper Seal for "+eqp_No+ ": " + After_Shipper_Seal_value, test,
							test1);
	
				} else {
					System.out.println("Not Matched || Expected Shipper Seal for "+ eqp_No+" : " + shipperSeal_Input + " || Actual Shipper Seal for "+eqp_No+ ": " + After_Shipper_Seal_value);
					Extent_fail(driver, "Not Matched || Expected Shipper Seal for "+ eqp_No+" : " + shipperSeal_Input + " || Actual Shipper Seal for "+eqp_No+ ": " + After_Shipper_Seal_value, test,
							test1);
				}
			}
		
		}
			j++;
		}
	   	
	   	scrollTop(driver);
	   	Step_Start(8, "once saved the import documentation new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(9, " click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(10, "click the yes and system has validate import dcoumentation is deleted .)", test, test1);

	   	if(wantToDelete.equalsIgnoreCase("Yes")){			   	
	   		deleteImportDocument(driver, Delete_Updated_popup, Delete_Updated_popup_Confirmation);
	   	}
	   	Step_End(8, "once saved the import documentation new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_End(9, " click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(10, "click the yes and system has validate import dcoumentation is deleted .)", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
