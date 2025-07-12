package LRP_Import_Documentation_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC101 extends Keywords{

	public void Import_Documentation_SC101(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC101";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String agencyConfig_Description=Excel_data.get("AgencyConfig_Description");
		String updatedPopup=Excel_data.get("UpdatedPopup");
		String wantToDelete_Popup_IMD = Excel_data.get("WantToDelete_Popup_IMD");
		String deleted_Popup_IMD = Excel_data.get("Deleted_Popup_IMD");
		String saved_Popup_IMD = Excel_data.get("Saved_Popup_IMD");
		String attribute = Excel_data.get("Attribute");
		String value = Excel_data.get("Value");
		String defaultValue= Excel_data.get("DefaultValue");
		String bill_NO = Excel_data.get("Bill_NO");
		String module_Search_Data=Excel_data.get("Module_Search");
		String Select_search_value_import = Excel_data.get("Select_search_value_import");
		String module_AgencyConfiguration = Excel_data.get("Module_AgencyConfiguration");
		String collect_charges_header = Excel_data.get("collect_charges_header");
		String tablename = Excel_data.get("tablename");
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String first_service_data = Excel_data.get("first_service_data");
		String Vessels = Excel_data.get("Vessels");
		String Voyagenumber1 = Excel_data.get("Voyagenumber1");
		String Boundinput = Excel_data.get("Boundinput");
		String portCode = Excel_data.get("portCode");
		String terminalCode = Excel_data.get("terminalCode");
		String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
		String House_BL_Number = Excel_data.get("House_BL_Number");
		String House_BL_Select_Type=Excel_data.get("House_BL_Select_Type");
		String House_BL_Container_Number=Excel_data.get("House_BL_Container_Number");
		String package_Input=Excel_data.get("package_Input");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String reset = Excel_data.get("reset");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Pol_Header = Excel_data.get("Pol_Header");
		String all_Dropdown_1 = Excel_data.get("All_Dropdown_1");
		String all_Dropdown_2 = Excel_data.get("All_Dropdown_2");
		String POL_Loction = Excel_data.get("POL_Loction");
		String conditionFilter=Excel_data.get("ConditionFilter");
		String do_you_want_to_delete=Excel_data.get("do_you_want_to_delete");

		String mater_Bl_DD=String.format(DropDown_Select, bill_NO);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		SwitchProfile(driver, agencyUser);

		// Agency Configuration
		Extent_call(test, test1, "Step no 1 to 4 - Agency Configuration SetUp start");
		List<Boolean> newlyAdded =setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, conditionFilter, agencyUser, attribute, agencyConfig_Description, value);
		Extent_call(test, test1, "Step no 1 to 4 - Agency Configuration SetUp End");

		Step_Start(5, "open the Import Documentation and  Retrieve the  bill using tool bar search.", test, test1);

		moduleNavigate(driver, module_Search_Data);

		if(BL_Retrive_Option.equals("By Service")) {
		
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
			
			if(!POL_Loction.trim().equals("")) {
				scrollTop(driver);
				waitForElement(driver, POLSearch);
				safeclick(driver, POLSearch);
				twoColumnSearchWindow(driver, Pol_Header, conditionFilter, POL_Loction);
			}
	
			waitForElement(driver, all_Dropdown_1_IMD);
			click(driver, all_Dropdown_1_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_1);
			
			waitForElement(driver, all_Dropdown_2_IMD);
			click(driver, all_Dropdown_2_IMD);
			formatLocatorClick(driver, DropDown_Select, all_Dropdown_2);
			
			waitForElement(driver, show_BL_Button_IMD);
			safeclick(driver, show_BL_Button_IMD);
			
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnSearchWindow(driver, BLNumber_Header, conditionFilter, bill_NO);

		}else if(BL_Retrive_Option.equals("By BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition, Select_search_value_import, bill_NO, "", "", "", "");
		}
				
		Step_End(5, "open the Import Documentation and  Retrieve the  bill using tool bar search.", test, test1);

		Extent_call(test, test1, "clicking the house button");
		Step_Start(6, "after retrieve the bl ,Master and House Bl button has available then click the house button.", test, test1);
		waitForElement(driver, House_Button_Imp_DOC);
		deleteSavedBL(driver,master_BL_Status,dropdownCondition,bill_NO);
		waitForElement(driver, House_Button_Imp_DOC);
		click(driver, House_Button_Imp_DOC);
		scrollBottom(driver);
		Step_End(6, "after retrieve the bl ,Master and House Bl button has available then click the house button.", test, test1);
		//Storing HouseBl List, Commodity list, and Split Charges List
		List<String> HouseBL_NewNumbers=splitAndExpand(House_BL_Number);
		List<String> HBL_ContainerList=splitAndExpand(House_BL_Container_Number,"/");
		List<String> HBL_packageList=splitAndExpand(package_Input,"/");
		
		//Getting package Values For each Commodity List
		Map<String,String> Commodity_package=new HashMap<String,String>();
		List<String> Total_CommodityList=splitAndExpand2(House_BL_Container_Number);
		for(int m=0;m<Total_CommodityList.size();m++) {
			String Commodity=Total_CommodityList.get(m);
			String ActPackage=HBL_packageList.get(m);
			Commodity_package.put(Commodity, ActPackage);
		}
		boolean quantityMismatch=false;
		//For each New BL , selecting the New BL and then select the Commmodity
		for(int i=0;i<HouseBL_NewNumbers.size();i++) {
			Step_Start(7, "Enter the HouseblNo and click the add in HBL updation Tab", test, test1);
			waitForElement(driver, House_BL_Field);
			click(driver, House_BL_Field);
			String HBL_Name=HouseBL_NewNumbers.get(i);
			sendKeys(driver, House_BL_Field, HBL_Name);
			click(driver, Add_House_BL_Button);
			Step_End(7, "Enter the HouseblNo and click the add in HBL updation Tab", test, test1);

			Step_Start(8, "we can add more than one house bl.", test, test1);
			Step_Start(9, "select the hosuebl using h.bl.no drop down.", test, test1);
			Step_Start(10, ".select  the check box-container and click the add in Bl Updation Tab.", test, test1);
			Step_Start(11, "After adding the House bl and container it will show the below grid and above hosuebl drop downfield master bill and house bill no has shown.", test, test1);

			waitForElement(driver, HBL_No_DropDown1);
			click(driver, HBL_No_DropDown1);
			String DropDown_Select1 = String.format(ImportDocumentation_Locators.House_No_Select1,HBL_Name);
			waitForElement(driver, DropDown_Select1);
			click(driver, DropDown_Select1);//Selected the new HouseBL
					
			//getting the list of Container list  of each BL Number
			List<String> BL_ContainerNo=splitAndExpand(HBL_ContainerList.get(i));
			//checking if user selecting Container or Commodity 
			if(House_BL_Select_Type.equals("Container")) {
				selectSpecificContainers(driver,BL_ContainerNo);// selecting the checkboxes in the Container List
				waitForElement(driver, Package_Add_Button);
				click(driver, Package_Add_Button);
			}else {
				//Perform loop for selecting the list of Commodity based on the Current BL number
				for(String commodity:BL_ContainerNo) {
					waitForElement(driver, Commodity_Input);
					click(driver, Commodity_Input);
					String HBL_DropDown_Select1 = String.format(DropDown_Select,commodity);
					waitForElement(driver, HBL_DropDown_Select1);
					click(driver,HBL_DropDown_Select1);
							
					waitForElement(driver, Package_Field);
					click(driver, Package_Field);
					clearAndType(driver, Package_Field,Commodity_package.get(commodity));
					String packagevalue=getAttribute(driver, Package_Field, "value");
					if(!packagevalue.equals(Commodity_package.get(commodity))) {
						quantityMismatch=true;
					}
					waitForElement(driver, Package_Add_Button);
					click(driver, Package_Add_Button);
				}
			}
			Step_End(8, "we can add more than one house bl.", test, test1);
			Step_End(9, "select the hosuebl using h.bl.no drop down.", test, test1);
			Step_End(10, ".select  the check box-container and click the add in Bl Updation Tab.", test, test1);
			Step_End(11, "After adding the House bl and container it will show the below grid and above hosuebl drop downfield master bill and house bill no has shown.", test, test1);
			
		}
				
		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status1=getText(driver, BL_status_IMP_DOC);
		scrollTop(driver);
		Step_Start(13, "Click the save button in tool bar ,BL has saved in Import Documentation -System will populate the validate ''Import Documentation is saved.\"", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		if(House_BL_Select_Type.equals("Commodity")) {
			if(quantityMismatch) {
				waitForElement(driver, QuantityMisMatchPopup);
				click(driver,QuantityMisMatchPopup);
			}
		}
		
		while(isdisplayed(driver, popup_Message_Yes_Button)) {
			click1(driver,popup_Message_Yes_Button);
			waitForDisplay(driver, popup_Message_Yes_Button);
		}
		
		if(actual_Master_BL_Status1.equals(master_BL_Status)) {
			waitForPopup(driver, popup_Message, saved_Popup_IMD);
			String actualPopup=getText(driver, popup_Message);
			if(actualPopup.equals(saved_Popup_IMD)) {
				System.out.println("Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup);
				Extent_pass_New(driver, "Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup, test, test1);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+saved_Popup_IMD +" || Actual Popup : "+actualPopup, test, test1);
			}
		}else {
			waitForPopup(driver, popup_Message, updatedPopup);
			String actualPopup=getText(driver, popup_Message);
			if(actualPopup.equals(updatedPopup)) {
				System.out.println("Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup);
				Extent_pass_New(driver, "Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup, test, test1);
				click(driver, popup_Message_Ok_Button);
			}else {
				System.out.println("Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup);
				Extent_fail(driver, "Not Matched || Expected Popup :"+updatedPopup +" || Actual Popup : "+actualPopup, test, test1);
			}
		}
		Step_End(13, "Click the save button in tool bar ,BL has saved in Import Documentation -System will populate the validate ''Import Documentation is saved.\"", test, test1);

		
		Step_Start(14, "select the master bl no in  HBL no drop down field and then go to the collect charge tab agency local charges has  to be shown .", test, test1);
		waitForElement(driver, HBL_No_DropDown);
		click(driver, HBL_No_DropDown);
		click(driver, mater_Bl_DD);

		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);
		if(verifyElementHasText(driver, Collect_Charges_Table_Row)) {
			System.out.println("Expected : collect charges details Should be show || Actual : collect charges details has shown");
			Extent_pass_New(driver, "Expected : collect charges details Should be show || Actual : collect charges details has shown", test, test1);
		}else {
			System.out.println("Expected : collect charges details Should be show || Actual : collect charges details has not shown");
			Extent_fail(driver, "Expected : collect charges details Should be show || Actual : collect charges details has not shown", test, test1);
		}

		waitForElement(driver, Collect_Charges_Table_Header);
		List<Map<String, String>> collect_Charges_Data = getTableData(driver, Collect_Charges_Table_Header, Collect_Charges_Table_Row);
		List<String> charges_table_headers = splitAndExpand(collect_charges_header);
		
		String charges_table = TableDataForReport(driver, collect_Charges_Data, tablename, charges_table_headers);
		Extent_pass_New(driver,"Matched || Expected : \n"+ "<pre>" +charges_table + "</pre>" +"|| Actual : \n"+ "<pre>" +charges_table+ "</pre>"  , test, test1);
		Step_End(14, "select the master bl no in  HBL no drop down field and then go to the collect charge tab agency local charges has  to be shown .", test, test1);
			
		Step_Start(15, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		waitForElement(driver, Delete_button_toolBar);
		Step_End(15, "i.once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		
		Step_Start(16, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_Start(17, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

		scrollTop(driver);
		if(do_you_want_to_delete.equalsIgnoreCase("Yes")) {
			deleteImportDocument(driver, wantToDelete_Popup_IMD, deleted_Popup_IMD);	
		}
		Step_End(16, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_End(17, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

		// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);

		reSetAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, attribute, conditionFilter, agencyUser, agencyConfig_Description, defaultValue, newlyAdded, reset);	

		Extent_completed(testcase_Name, test, test1);
	}
}
