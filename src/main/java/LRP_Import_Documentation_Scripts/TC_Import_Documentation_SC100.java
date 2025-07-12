package LRP_Import_Documentation_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC100 extends Keywords{

	public void Import_Documentation_SC100(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC100";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
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
		String master_BL_Status=Excel_data.get("Master_BL_Status");
		String conditionFilter=Excel_data.get("ConditionFilter");
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
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String reset = Excel_data.get("reset");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Pol_Header = Excel_data.get("Pol_Header");
		String Split_Charge_Popup = Excel_data.get("Split_Charge_Popup");		
		
		String House_BL_Number = Excel_data.get("House_BL_Number");		
		String House_BL_Select_Type = Excel_data.get("House_BL_Select_Type");		
		String House_BL_Container_Number = Excel_data.get("House_BL_Container_Number");		
		String package_Input = Excel_data.get("package_Input");		
		String Split_Charge_Code = Excel_data.get("Split_Charge_Code");		
		String Split_Charge_Rate_RefNo = Excel_data.get("Split_Charge_Rate_RefNo");		
		String Split_Charge_Amount_Value = Excel_data.get("Split_Charge_Amount_Value");		
		String Split_Charges_Full = Excel_data.get("Split_Charges_Full");		
		String Tables_headers = Excel_data.get("Tables_headers");				

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		SwitchProfile(driver, agencyUser);

		// Agency Configuration
		Extent_call(test, test1, "Step no 1 to 4 - Agency Configuration SetUp start");
		List<Boolean> newlyAdded =setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, Attribute_Search_Column_Header, conditionFilter, agencyUser, attribute, agencyConfig_Description, value);
		Extent_call(test, test1, "Step no 1 to 4 - Agency Configuration SetUp End");

		Step_Start(5, "open the Import Documentation and  Retrieve the  bill using tool bar search.", test, test1);

		moduleNavigate(driver, module_Search_Data);

		if(BL_Retrieve_Option.equals("By Service")) {
		
			newButton(driver);
			
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

		}else if(BL_Retrieve_Option.equals("By BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition, Select_search_value_import, bill_NO, "", "", "", "");
		}
		
		Step_End(5, "open the Import Documentation and  Retrieve the  bill using tool bar search.", test, test1);

		Extent_call(test, test1, "clicking the house button");
		Step_Start(6, "after retrieve the bl ,Master and House Bl button has available then click the house button.", test, test1);
		waitForElement(driver, House_Button_Imp_DOC);
		click(driver, House_Button_Imp_DOC);
		Step_End(6, "after retrieve the bl ,Master and House Bl button has available then click the house button.", test, test1);
		
		waitForElement(driver, HBL_Commodity_Table_Row);
		Map<String,Map<String,List<String>>> HBL_PackageList= getHousBLPackageList(House_BL_Number,House_BL_Container_Number,package_Input);
		List<String> HouseBL_NewNumbers=splitAndExpand(House_BL_Number);
		List<String> HBL_ContainerList=splitAndExpand(House_BL_Container_Number,"/");
		Map<String,List<String>> BL_Number_Commodity=new HashMap<String, List<String>>();//Storing the Container List details based on the BL number
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

			scrollBottom(driver);
			mouseOverToElement(driver, HBL_No_DropDown1);
			waitForElement(driver, HBL_No_DropDown1);
			click(driver, HBL_No_DropDown1);
			String DropDown_Select1 = String.format(ImportDocumentation_Locators.House_No_Select1,HBL_Name);
			waitForElement(driver, DropDown_Select1);
			click(driver, DropDown_Select1);//Selected the new HouseBL
			Step_End(8, "we can add more than one house bl.", test, test1);

			//getting the list of Container list  of each BL Number
			List<String> BL_ContainerNo=splitAndExpand(HBL_ContainerList.get(i));
			BL_Number_Commodity.put(HBL_Name, BL_ContainerNo);
			
			if(House_BL_Select_Type.equals("Container")) {
				selectSpecificContainers(driver,BL_ContainerNo);// selecting the checkboxes in the Container List
				mouseOverToElement(driver, Package_Add_Button);
				waitForElement(driver, Package_Add_Button);
				click(driver, Package_Add_Button);
			}else {
				//Perform loop for selecting the list of Commodity based on the Current BL number
				for(int k=0;k<BL_ContainerNo.size();k++) {
					
					String commodityName=BL_ContainerNo.get(k);
					waitForElement(driver, Commodity_Input_Import);
					click(driver, Commodity_Input_Import);
					String HBL_DropDown_Select1 = String.format(Commodity_Select,commodityName);
					waitForElement(driver, HBL_DropDown_Select1);
					click(driver,HBL_DropDown_Select1);
					
					int packageTotal=0;
					List<String> packagesList=HBL_PackageList.get(HBL_Name).get(commodityName);
					for(int a=0;a<packagesList.size();a++) {
						String packageValue=packagesList.get(a);
						waitForElement(driver, Package_Field);
						click(driver, Package_Field);
						clearAndType(driver, Package_Field,packagesList.get(a));
						waitForDisplay(driver, Package_Add_Button);
						mouseOverToElement(driver, Package_Add_Button);
						click(driver, Package_Add_Button);
						if(isdisplayed(driver, SameCommodityPopup)) {
							click(driver,popup_Message_Yes_Button);
						}
						int val=Integer.parseInt(packageValue);
						packageTotal=packageTotal+val;
					}
				}
			}
			
			Step_End(8, "we can add more than one house bl.", test, test1);
			Step_End(9, "select the hosuebl using h.bl.no drop down.", test, test1);
			Step_End(10, ".select  the check box-container and click the add in Bl Updation Tab.", test, test1);
			Step_End(11, "After adding the House bl and container it will show the below grid and above hosuebl drop downfield master bill and house bill no has shown.", test, test1);

		}
		
		Step_Start(13, "select the master bl no in HBL no drop down field and then go to the collect charge tab agency local charges not  to be shown .\r\n"
				+ ".Save the Import Documentation.\r\n"
				+ ".system has validate -Import Documentation is saved.Ok", test, test1);

		
		scrollTop(driver);
		waitForElement(driver, BL_status_IMP_DOC);
		String actual_Master_BL_Status1=getText(driver, BL_status_IMP_DOC);
		
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		//Getting Split Charges list for each BL number
		Map<String,List<String>>  BL_SplitCharge=new HashMap<String, List<String>>();
		Map<String,List<String>>  BL_SplitChargeRefNo=new HashMap<String, List<String>>();
		Map<String,List<String>>  BL_SplitChargeAmount=new HashMap<String, List<String>>();
		List<String> SplitChargesList=splitAndExpand(Split_Charge_Code,"/");
		List<String> SplitChargesRefNoList=splitAndExpand(Split_Charge_Rate_RefNo,"/");
		List<String> Split_Charge_AmountList=splitAndExpand(Split_Charge_Amount_Value,"/");
		
		for(int i=0;i<HouseBL_NewNumbers.size();i++) { 
			if(i>=SplitChargesList.size()) {
				break;
			}
			List<String> ActSplitCheckBoxes=splitAndExpand(SplitChargesList.get(i),",");
			List<String> ActSplitRefNoBoxes=splitAndExpand(SplitChargesRefNoList.get(i),",");
			List<String> ActSplitRefNoAmounts=splitAndExpand(Split_Charge_AmountList.get(i),",");
			
			BL_SplitCharge.put(HouseBL_NewNumbers.get(i), ActSplitCheckBoxes);
			BL_SplitChargeRefNo.put(HouseBL_NewNumbers.get(i), ActSplitRefNoBoxes);
			BL_SplitChargeAmount.put(HouseBL_NewNumbers.get(i), ActSplitRefNoAmounts);
		}
				
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			waitForElement(driver, popup_Message);
			String Act_SplitChargePopup=getText(driver, popup_Message);
			if(Act_SplitChargePopup.equals(Split_Charge_Popup)) {
				waitForElement(driver, popup_Message_No_Button);
				click(driver,popup_Message_No_Button);
				
				waitForElement(driver, Split_Charges_Tab);
				click(driver, Split_Charges_Tab);
				scrollBottom(driver);
				if(Split_Charges_Full.equalsIgnoreCase("Yes")) {
					waitForElement(driver, Select_All_CheckBox_SplitCharges_ID);
					click(driver,Select_All_CheckBox_SplitCharges_ID);
					
					waitForElement(driver, SplitCharges_Amount_Add_Button);
					click(driver,SplitCharges_Amount_Add_Button);
				}else {
					Map<String,Map<String,String>>  BL_SplitChargeAmounts=new HashMap<String,Map<String, String>>();
					for(String hbl_Charge : BL_SplitCharge.keySet()) {
						waitForElement(driver, HBL_No_DropDown);
						click(driver, HBL_No_DropDown);
						String HouseBL_No_Select = String.format(DropDown_Select,hbl_Charge);
						click(driver, HouseBL_No_Select);
						//Storing the Amount for each Charge Code
						Map<String,String>  chargesAmount=new HashMap<String, String>();
						waitForElement(driver, Split_Charges_Tab);
						click(driver, Split_Charges_Tab);
						//Already we stored the List of Charge code for each BL number, and selecting the Charge code and.
						List<String> splitCheckbox=BL_SplitCharge.get(hbl_Charge);
						List<String>  splitRateRefNumbers=BL_SplitChargeRefNo.get(hbl_Charge);
						List<String>  BL_SplitChargeAmountsList=BL_SplitChargeAmount.get(hbl_Charge);
						
						int ref=0;
						for(String check:splitCheckbox) {
							String RefNo=splitRateRefNumbers.get(ref);
							String Split_Charge_Checkbox = String.format(ImportDocumentation_Locators.Select_SplitCharge,check,RefNo);
							waitForDisplay(driver, Split_Charge_Checkbox);
							click(driver, Split_Charge_Checkbox);
							
							String amount=BL_SplitChargeAmountsList.get(ref);
							waitForElement(driver, SplitCharges_Amount_Field);
							//System.out.println("Amount : "+splitCheckbox.get(check));
							doubleClick(driver, SplitCharges_Amount_Field);
							sendKeys(driver, SplitCharges_Amount_Field, amount);
							waitForElement(driver, SplitCharges_Amount_Add_Button);
							click(driver,SplitCharges_Amount_Add_Button);
							if(isdisplayed(driver, ChargeCodeAlreadyExist)) {
								click(driver,okayButton);
							}
							chargesAmount.put(check, amount);
							ref++;
						}
						
						BL_SplitChargeAmounts.put(hbl_Charge, chargesAmount);//add the BL number and its chargecode&Amount Value
					}
				}
				
				scrollTop(driver);
				waitForElement(driver, SaveButton_ToolBar);
				jsClick(driver, SaveButton_ToolBar);
			}
		}
		
		while(isdisplayed(driver, popup_Message_Yes_Button)) {
			jsClick(driver, popup_Message_Yes_Button);
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
		Step_End(13, "select the master bl no in HBL no drop down field and then go to the collect charge tab agency local charges not  to be shown .\r\n"
				+ ".Save the Import Documentation.\r\n"
				+ ".system has validate -Import Documentation is saved.Ok", test, test1);

		
			waitForElement(driver, HBL_No_DropDown);
			click(driver, HBL_No_DropDown);
			String HouseBL_No_Select = String.format(DropDown_Select,bill_NO);
			click(driver, HouseBL_No_Select);

			waitForElement(driver, Master_Button_IMP);
			click(driver,Master_Button_IMP);
			
			waitForElement(driver, Collect_Charges_Tab);
			click(driver, Collect_Charges_Tab);
			mouseOverToElement(driver, Collect_Charges_Table_Header);
			waitForElement(driver, Collect_Charges_Table_Header);
			List<Map<String, String>> collect_table = getTableData(driver, Collect_Charges_Table_Header, Collect_Charges_Table_Row);
			List<String> type_values = getValuesByHeader(collect_table, "Type");
			List<String> coloum_headd = splitAndExpand(Tables_headers);
			String HBL_Table = TableDataForReport(driver, collect_table,"Collect Charges",coloum_headd);
			boolean agencyPresent=false;
			String Type_Verify="Agency";
			for(String type_value :type_values) {
				if (type_value.equals(Type_Verify)) {
					agencyPresent=true;
					Extent_pass_New(driver," Collect Charges table data : "+ "<pre>" +HBL_Table + "</pre>", test, test1);	
					System.out.println("Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data for the Master BL : "+bill_NO+" || Actual : '"+Type_Verify+"' is present in the Collect Charges table data ");
					Extent_fail(driver, "Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data for the Master BL : "+bill_NO+" || Actual : '"+Type_Verify+"' is present in the Collect Charges table data ", test, test1);
				}
			}
			
			if(agencyPresent!=false) {
				Extent_pass_New(driver," Collect Charges table data : "+ "<pre>" +HBL_Table + "</pre>", test, test1);	
				System.out.println("Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data for the Master BL : "+bill_NO+" || Actual : '"+Type_Verify+"' is not present in the Collect Charges table data ");
				Extent_fail(driver, "Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data for the Master BL : "+bill_NO+" || Actual : '"+Type_Verify+"' is not present in the Collect Charges table data ", test, test1);
			}
		

		Step_Start(13, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_Start(13, "iii.click the yes and system has validate import documentation is deleted .", test, test1);
		if(wantToDelete.equalsIgnoreCase("Yes")){
			deleteImportDocument(driver, wantToDelete_Popup_IMD, deleted_Popup_IMD);
		}
		
		Step_End(13, "ii.click the delete icon and system has validate( Do you want to delete import documentation )?\r\n"
				+ "YES or N0  ", test, test1);
		Step_End(13, "iii.click the yes and system has validate import documentation is deleted .", test, test1);

		// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);
		reSetAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Search_Column_Header, attribute, conditionFilter, agencyUser, agencyConfig_Description, defaultValue, newlyAdded, reset);	

		Extent_completed(testcase_Name, test, test1);
	}
}
