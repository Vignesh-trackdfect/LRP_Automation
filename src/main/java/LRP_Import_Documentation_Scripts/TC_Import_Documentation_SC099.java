package LRP_Import_Documentation_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC099 extends Keywords{

	public void Import_Documentation_SC099(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC099";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String BL_Num = Excel_data.get("BL_Num");
		String BL_Condition = Excel_data.get("BL_Condition");
		String SavedPopup = Excel_data.get("SavedPopup");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String description = Excel_data.get("description");
		String value = Excel_data.get("value");
		String House_BL_Number = Excel_data.get("House_BL_Number");
		String House_Commodity_Number = Excel_data.get("House_Commodity_Number");
		String package_Input = Excel_data.get("package_Input");
		String Confguration_Reset = Excel_data.get("Confguration_Reset");
		String attribute = Excel_data.get("Attribute");
		String Select_Search_Type_Import_Doc=Excel_data.get("Select_Search_Type_Import_Doc");
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
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String pol_Value=Excel_data.get("pol_Value");
		String house_Bl_Status = Excel_data.get("house_Bl_Status");
		String Pol_Header = Excel_data.get("Pol_Header");
		String BLNumber_Header = Excel_data.get("BLNumber_Header");
		String Vessel_Name_Input = Excel_data.get("Vessel_Name_Input");
		String Vessel_Name_Search = Excel_data.get("Vessel_Name_Search");
		String Vessel_Code_Input = Excel_data.get("Vessel_Code_Input");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String reset = Excel_data.get("reset");
		String Split_Charge_Popup = Excel_data.get("Split_Charge_Popup");
		String Want_To_Delete_Import_Document = Excel_data.get("Want_To_Delete_Import_Document");
		String wantToDelete_Popup_IMD = Excel_data.get("WantToDelete_Popup_IMD");
		String deleted_Popup_IMD = Excel_data.get("Deleted_Popup_IMD");
		String House_BL_Select_Type = Excel_data.get("House_BL_Select_Type");
		String Split_Charge_Code = Excel_data.get("Split_Charge_Code");		
		String Split_Charge_Rate_RefNo = Excel_data.get("Split_Charge_Rate_RefNo");		
		String Split_Charge_Amount_Value = Excel_data.get("Split_Charge_Amount_Value");		
		String Split_Charges_Full = Excel_data.get("Split_Charges_Full");		
		String Tables_headers = Excel_data.get("Tables_headers");		

		
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		SwitchProfile(driver, AgencyUser);

		// Agency Configuration
		List<Boolean> newlyAdded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition_Filter, AgencyUser, attribute, description, value);

		Step_Start(6, "open the Import Documentation Retrieve the  bill using tool bar search", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);

		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, BL_Num, Vessel_Code_Search, Vessel_Code_Input, Vessel_Name_Search, Vessel_Name_Input);
		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
			waitForDisplay(driver, NewButton_ToolBar);
			if( IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);
			
			waitForPopup(driver, popup_Message, NewImportDocumentationPopup);
			String NewImportDocumentation = getText(driver, popup_Message);
			if (NewImportDocumentationPopup.equals(NewImportDocumentation)) {
				System.out.println("Matched || Expected Popup was : " + NewImportDocumentationPopup+ " || Actual Popup was : " + NewImportDocumentation);
				Extent_pass_New(driver, "Matched || Expected Popup was : " + NewImportDocumentationPopup	+ " || Actual Popup was : " + NewImportDocumentation, test, test1);

			} else {
				System.out.println("NotMatched || Expected Popup was : " + NewImportDocumentationPopup+ " || Actual Popup was : " + NewImportDocumentation);
				Extent_fail(driver, "NotMatched || Expected Popup was : " + NewImportDocumentationPopup	+ " || Actual Popup was : " + NewImportDocumentation, test, test1);
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
		deleteSavedBL(driver,house_Bl_Status,BL_Condition,BL_Num);
		Step_End(6, "open the Import Documentation Retrieve the  bill using tool bar search", test, test1);
		scrollBottom(driver);

		Step_Start(7, "after retrieve the bl ,Master and House Bl button has available then click the house button.", test, test1);
		waitForElement(driver, House_Button_Imp_DOC);
		click(driver, House_Button_Imp_DOC);
		Step_End(7, "after retrieve the bl ,Master and House Bl button has available then click the house button.", test, test1);

		Step_Start(8, "Enter the HouseblNo and click the add in HBL updation Tab", test, test1);
	
		//Code modified here by Vignesh on 16_04_2025. In order to allocate same containers with seperate amount into Every House BL.
		List<String> HBL_BL_NumbersList=splitAndExpand(House_BL_Number);
		List<String> HBL_CommodityList=splitAndExpand(House_Commodity_Number,"/");
		Map<String,Map<String,List<String>>> HBL_PackageList= getHousBLPackageList(House_BL_Number,House_Commodity_Number,package_Input);

		//Code modified here by Vignesh on 16_04_2025. In order to allocate same containers with seperate amount into Every House BL.
		
		scrollBottom(driver);
		scrollBottom(driver);
		Map<String,List<String>> BL_Number_Commodity=new HashMap<String, List<String>>();//Storing the Container List details based on the BL number
		//For each New BL , selecting the New BL and then select the Commmodity
		for(int i=0;i<HBL_BL_NumbersList.size();i++) {
			waitForElement(driver, House_BL_Field);
			click(driver, House_BL_Field);
			String HBL_Name=HBL_BL_NumbersList.get(i);
			sendKeys(driver, House_BL_Field, HBL_Name);
			click(driver, Add_House_BL_Button);
			
			scrollBottom(driver);
			mouseOverToElement(driver, HBL_No_DropDown1);
			waitForElement(driver, HBL_No_DropDown1);
			click(driver, HBL_No_DropDown1);
			String DropDown_Select1 = String.format(ImportDocumentation_Locators.House_No_Select1,HBL_Name);
			waitForElement(driver, DropDown_Select1);
			click(driver, DropDown_Select1);//Selected the new HouseBL
			
			//getting the list of Container list  of each BL Number
			List<String> BL_ContainerNo=splitAndExpand(HBL_CommodityList.get(i));
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
		}

		scrollTop(driver);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);

		//Getting Split Charges list for each BL number
		Map<String,List<String>>  BL_SplitCharge=new HashMap<String, List<String>>();
		Map<String,List<String>>  BL_SplitChargeRefNo=new HashMap<String, List<String>>();
		Map<String,List<String>>  BL_SplitChargeAmount=new HashMap<String, List<String>>();
		List<String> SplitChargesList=splitAndExpand(Split_Charge_Code,"/");
		List<String> SplitChargesRefNoList=splitAndExpand(Split_Charge_Rate_RefNo,"/");
		List<String> Split_Charge_AmountList=splitAndExpand(Split_Charge_Amount_Value,"/");
		
		for(int i=0;i<HBL_BL_NumbersList.size();i++) { 
			if(i>=SplitChargesList.size()) {
				break;
			}
			List<String> ActSplitCheckBoxes=splitAndExpand(SplitChargesList.get(i),",");
			List<String> ActSplitRefNoBoxes=splitAndExpand(SplitChargesRefNoList.get(i),",");
			List<String> ActSplitRefNoAmounts=splitAndExpand(Split_Charge_AmountList.get(i),",");
			
			BL_SplitCharge.put(HBL_BL_NumbersList.get(i), ActSplitCheckBoxes);
			BL_SplitChargeRefNo.put(HBL_BL_NumbersList.get(i), ActSplitRefNoBoxes);
			BL_SplitChargeAmount.put(HBL_BL_NumbersList.get(i), ActSplitRefNoAmounts);
		}
						
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
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		Step_Start(10, "select the hosuebl no in  HBL no drop down field and then go to the collect charge tab agency local charges has  not shown", test, test1);		
		Step_Start(11, "select the hosuebl using h.bl.no drop down", test, test1);
		for(int k=0;k<HBL_BL_NumbersList.size();k++) {
			String House_Bl_Select_=String.format(DropDown_Select, HBL_BL_NumbersList.get(k));

			waitForElement(driver, HBL_No_DropDown);
			click(driver, HBL_No_DropDown);
			click(driver, House_Bl_Select_);
			Step_End(11, "select the hosuebl using h.bl.no drop down", test, test1);

			waitForElement(driver, Collect_Charges_Tab);
			click(driver, Collect_Charges_Tab);
			Step_Start(12, "select the hosuebl no in  HBL no drop down field and then go to the collect charge tab agency local charges has to be shown", test, test1);

			mouseOverToElement(driver, Collect_Charges_Table_Header);
			waitForElement(driver, Collect_Charges_Table_Header);
			List<Map<String, String>> collect_table = getTableData(driver, Collect_Charges_Table_Header, Collect_Charges_Table_Row);
			List<String> type_values = getValuesByHeader(collect_table, "Type");
			List<String> coloum_headd = splitAndExpand(Tables_headers);
			String HBL_Table = TableDataForReport(driver, collect_table,"Collect Charges Table Data",coloum_headd);
			boolean agencyPresent=false;
			String Type_Verify="Agency";
			for(String type_value :type_values) {
				if (Type_Verify.equals(type_value)) {
					agencyPresent=true;
					Extent_pass_New(driver," Collect Charges table data : "+ "<pre>" +HBL_Table + "</pre>", test, test1);	
					System.out.println("Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data || Actual : '"+Type_Verify+"' is present in the Collect Charges table data ");
					Extent_fail(driver, "Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data || Actual : '"+Type_Verify+"' is present in the Collect Charges table data ", test, test1);
				}
			}
			
			if(agencyPresent!=false) {
				Extent_pass_New(driver," Collect Charges table data : "+ "<pre>" +HBL_Table + "</pre>", test, test1);	
				System.out.println("Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data || Actual : '"+Type_Verify+"' is not present in the Collect Charges table data ");
				Extent_fail(driver, "Expected : '"+Type_Verify+"' should not be present in the Collect Charges table data || Actual : '"+Type_Verify+"' is not present in the Collect Charges table data ", test, test1);
			}
		}
		Step_End(12, "select the hosuebl no in  HBL no drop down field and then go to the collect charge tab agency local charges has to be shown", test, test1);

		if(Want_To_Delete_Import_Document.equalsIgnoreCase("Yes")) {
			deleteImportDocument(driver, wantToDelete_Popup_IMD, deleted_Popup_IMD);
		}
		
		scrollTop(driver);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, Condition_Filter, AgencyUser, description, Confguration_Reset, newlyAdded, reset);
	
		Extent_completed(testcase_Name, test, test1);

	}
}
