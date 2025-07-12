package LRP_Import_Documentation_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC033  extends Keywords{
	public void Import_Documentation_SC033(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String testcase_Name="TC_Import_Documentation_SC033";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String bl_Number = Excel_data.get("bl_Number");
		String documentation_Saved_Popup_Exp = Excel_data.get("documentation_Saved_Popup_Exp").trim();
		String house_BL_Status_Exp = Excel_data.get("house_BL_Status_Exp").trim();
		String ID_Table_Headers=Excel_data.get("ID_Charges_Table_Headers");
		String BL_Table_Headers=Excel_data.get("Split_Charges_Table_Headers");
		String ID_Table_Name=Excel_data.get("Collect_Chareges_Table_Name");
		String BL_Table_Name=Excel_data.get("Split_Charges_Table_Name");

		String House_BL_Status_Exp=Excel_data.get("House_BL_Status_Exp");
		String House_BL_Number = Excel_data.get("House_BL_Number");
		String House_BL_Select_Type=Excel_data.get("House_BL_Select_Type");
		String House_BL_Container_Number=Excel_data.get("House_BL_Container_Number");
		String package_Input=Excel_data.get("package_Input");
		String Split_Charge_Code=Excel_data.get("Split_Charge_Code");
		String Split_Charge_Amount_Value=Excel_data.get("Split_Charge_Amount_Value");
		String Split_Charge_Rate_RefNo=Excel_data.get("Split_Charge_Rate_RefNo");

		String Container_Table_Compare_Header=Excel_data.get("Container_Table_Compare_Header");
		String SplitChargeCode_Header=Excel_data.get("SplitChargeCode_Header");
		String SplitChargeAmount_Header =Excel_data.get("SplitChargeAmount_Header");
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
		
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		String condition=Excel_data.get("condition");
		String pol_Value=Excel_data.get("pol_Value");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		Extent_call(test, test1, "********** Switch the Profile - End **********");	
		
		Extent_call(test, test1, "********** Enter Import Documentation Module **********");
		Step_Start(1, "In Import Documentation Retrive the  bill using tool bar search.", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);		

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
		
		Step_End(1, "In Import Documentation Retrive the  bill using tool bar search.", test, test1);
		
		Step_Start(2, "after retrive the bl ,Master and House Bl button has avaliable then click the house button.", test, test1);

		waitForElement(driver, House_Button_Imp_DOC);
		deleteSavedBL(driver,House_BL_Status_Exp,dropdownCondition1,bl_Number);
		waitForElement(driver, House_Button_Imp_DOC);
		click(driver, House_Button_Imp_DOC);
		Step_End(2, "after retrive the bl ,Master and House Bl button has avaliable then click the house button.", test, test1);
		
		//Code modified here by Vignesh on 16_04_2025. In order to allocate same containers with seperate amount into Every House BL.
		scrollBottom(driver);
		//Storing HouseBl List, Commodity list, and Split Charges List
		List<String> HouseBL_NewNumbers=splitAndExpand(House_BL_Number);
		List<String> HBL_ContainerList=splitAndExpand(House_BL_Container_Number,"/");
		List<String> HBL_package_Lists_TestData=splitAndExpand(package_Input,"/");
		
		//Storing the package Value for each Commodity for the Respective House BL
		int count=0;
		Map<String,Map<String,List<String>>> HBL_PackageList= new HashMap<String, Map<String,List<String>>>();
		for(int h=0;h<HouseBL_NewNumbers.size();h++) {
			String HouseBL=HouseBL_NewNumbers.get(h);
			Map<String,List<String>> Commodity_package=new HashMap<String,List<String>>();
			List<String>  Commodity_ID=splitAndExpand(HBL_ContainerList.get(h));
			for(int Cont=0;Cont<Commodity_ID.size();Cont++) {
				String Commodity=Commodity_ID.get(Cont);
				List<String> ActPackage=splitAndExpand(HBL_package_Lists_TestData.get(count));
				Commodity_package.put(Commodity, ActPackage);
				HBL_PackageList.put(HouseBL, Commodity_package);
				count++;
			}
		}
		//Code modified here by Vignesh on 16_04_2025. In order to allocate same containers with seperate amount into Every House BL.
						
		
		Map<String,List<String>> BL_Number_Commodity=new HashMap<String, List<String>>();//Storing the Container List details based on the BL number
		//For each New BL , selecting the New BL and then select the Commmodity
		for(int i=0;i<HouseBL_NewNumbers.size();i++) {
			Step_Start(3, "Enter the HouseblNo and click the add in HBL updation Tab.", test, test1);

			waitForElement(driver, House_BL_Field);
			click(driver, House_BL_Field);
			String HBL_Name=HouseBL_NewNumbers.get(i);
			sendKeys(driver, House_BL_Field, HBL_Name);
			click(driver, Add_House_BL_Button);
			Step_End(3, "Enter the HouseblNo and click the add in HBL updation Tab.", test, test1);

			Step_Start(4, ".we can add more than one hosue bL.", test, test1);
			Step_Start(5, "select the hosuebl using h.bl.no dropdown.", test, test1);
			Step_Start(6, "select the container and commodity using dropdown .", test, test1);
			Step_Start(7, "list the containers for that bl -select the container and add.", test, test1);

			scrollBottom(driver);
			mouseOverToElement(driver, HBL_No_DropDown1);
			waitForElement(driver, HBL_No_DropDown1);
			click(driver, HBL_No_DropDown1);
			String DropDown_Select1 = String.format(ImportDocumentation_Locators.House_No_Select1,HBL_Name);
			waitForElement(driver, DropDown_Select1);
			click(driver, DropDown_Select1);//Selected the new HouseBL
			
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
			Step_End(4, ".we can add more than one hosue bL.", test, test1);
			Step_End(5, "select the hosuebl using h.bl.no dropdown.", test, test1);
			Step_End(6, "select the container and commodity using dropdown .", test, test1);
			Step_End(7, "list the containers for that bl -select the container and add.", test, test1);

		}
		
		Step_Start(8, "After adding the House bl in HBL updation tab.", test, test1);
		Step_Start(9, ".Go to the split charges tab and Select the Chargecode and enter  the amount for that housebill then add in below grid. same as another charge code", test, test1);
		Step_Start(10, "balance amount has shown in first grid .", test, test1);
		
		//Perform loop for Selecting the list of chargeCode Check Box For Each BL number
		waitForElement(driver, Split_Charges_Tab);
		click(driver, Split_Charges_Tab);
		scrollBottom(driver);
		mouseOverToElement(driver, Split_Charges_Table_Header_1);
		waitForElement(driver, Split_Charges_Table_Header_1);
		List<Map<String, String>> split_Chareges_Tabledata1 = getTableData(driver, Split_Charges_Table_Header_1, Split_Charges_Table_Row_1);
		List<String> colHeaders=splitAndExpand(BL_Table_Headers);
		String Expected_table=TableDataForReport(driver, split_Chareges_Tabledata1,BL_Table_Name,colHeaders);
	
		
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
		Step_End(8, "After adding the House bl in HBL updation tab.", test, test1);
		Step_End(9, ".Go to the split charges tab and Select the Chargecode and enter  the amount for that housebill then add in below grid. same as another charge code", test, test1);

		Map<String,Map<String,String>>  BL_SplitChargeAmounts=new HashMap<String,Map<String, String>>();
		for(String hbl_Charge : BL_SplitCharge.keySet()) {
			Step_Start(11, ".select the another housebl ", test, test1);

			waitForElement(driver, HBL_No_DropDown);
			click(driver, HBL_No_DropDown);
			String HouseBL_No_Select = String.format(DropDown_Select,hbl_Charge);
			click(driver, HouseBL_No_Select);
			//Storing the Amount for each Charge Code
			Map<String,String>  chargesAmount=new HashMap<String, String>();
			waitForElement(driver, Split_Charges_Tab);
			click(driver, Split_Charges_Tab);
			Step_End(11, ".select the another housebl ", test, test1);

			Step_Start(12, "select the charge code and enter the amount then add in below grid .same as another charge code", test, test1);
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
			Step_End(12, "select the charge code and enter the amount then add in below grid .same as another charge code", test, test1);
			BL_SplitChargeAmounts.put(hbl_Charge, chargesAmount);//add the BL number and its chargecode&Amount Value
		}
		Step_Start(13, "Save the Import Documentation", test, test1);
		Step_Start(14, "once saved the import documentation system has validate import documentation is saved.", test, test1);

		scrollTop(driver);
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		if(isdisplayed(driver, QuantityMisMatchPopup)) {
			waitForElement(driver, QuantityMisMatchPopup);
			click(driver,QuantityMisMatchPopup);
		}
		
		while(isdisplayed(driver, popup_Message_Yes_Button)) {
			jsClick(driver,popup_Message_Yes_Button);
			waitForDisplay(driver, popup_Message_Yes_Button);
		}
		
		waitForPopup(driver, popup_Message, documentation_Saved_Popup_Exp);
		String documentation_Saved_Popup = getText(driver, popup_Message);
		if (documentation_Saved_Popup_Exp.equals(documentation_Saved_Popup)) {
			System.out.println("Matched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup, test,test1);
			click1(driver, popup_Message_Ok_Button);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + documentation_Saved_Popup_Exp + " || Actual Popup was : " + documentation_Saved_Popup,test, test1);
		}
		Step_End(13, "Save the Import Documentation", test, test1);
		Step_End(14, "once saved the import documentation system has validate import documentation is saved.", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String house_BL_Status=getText(driver, BL_status_IMP_DOC).trim();
		if (house_BL_Status_Exp.equals(house_BL_Status)) {
			System.out.println("Matched || Expected value was : " + house_BL_Status_Exp + " || Actual value was : " + house_BL_Status);
			Extent_pass_New(driver, "Matched || Expected value was : " + house_BL_Status_Exp + " || Actual value was : " + house_BL_Status, test,test1);
		} else {
			System.out.println("NotMatched || Expected value was : " + house_BL_Status_Exp + " || Actual value was : " + house_BL_Status);
			Extent_fail(driver, "NotMatched || Expected value was : " + house_BL_Status_Exp + " || Actual value was : " + house_BL_Status,test, test1);
		}
		
		Step_Start(15, "Verify that Captured charges Must be there under HBL No in the collect charges tab and chage Amount Total Count has to Match .", test, test1);

		//After Saved the changes, Validating the container, commodity and Collection charge tabs values
		for (String hbl_Charge : BL_SplitChargeAmounts.keySet()) {
			waitForElement(driver, HBL_No_DropDown);
			click(driver, HBL_No_DropDown);
			String HouseBL_No_Select = String.format(DropDown_Select,hbl_Charge);
			click(driver, HouseBL_No_Select);
			
			scrollBottom(driver);
			waitForElement(driver, Container_Tab_IMD);
			click(driver, Container_Tab_IMD);
			waitForElement(driver, Container_Table_Header);
			mouseOverToElement(driver, Container_Table_Header);
			//Container tab Validation
			List<Map<String, String>> HBL_Container_Tabledatas = getTableData(driver, Container_Table_Header, Container_Table_Row);
			List<String> ActContainersList=getTableHeaderCellList(HBL_Container_Tabledatas,Container_Table_Compare_Header);
			List<String> ExpContainerList=BL_Number_Commodity.get(hbl_Charge);
			
			if(CompareListvalues(ExpContainerList,ActContainersList)) {
				System.out.println("Passed : Expected Containers updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+ExpContainerList+"  || Act  : "+ActContainersList);
				Extent_pass_New(driver, "Passed : Expected Containers updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+ExpContainerList+"  || Act  : "+ActContainersList, test, test1);
			}else {
				System.out.println("Failed : Expected Containers not updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+ExpContainerList+"  || Act  : "+ActContainersList);
				Extent_fail(driver, "Failed : Expected Containers not updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+ExpContainerList+"  || Act  : "+ActContainersList, test, test1);
			}
			
			//Commodity tab Validation
			waitForElement(driver, Commodity_Tab);
			click(driver, Commodity_Tab);
			waitForElement(driver, Commodity_Table_Header);
			mouseOverToElement(driver, Commodity_Table_Header);
			List<Map<String, String>> HBL_Commodity_Tabledatas = getTableData(driver, Commodity_Table_Header, Commodity_Table_Row);
			List<String> ActCommodityList=getTableHeaderCellList(HBL_Commodity_Tabledatas,Container_Table_Compare_Header);
			if(CompareListvalues(ExpContainerList,ActCommodityList)) {
				System.out.println("Passed || Expected Commodity updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+ExpContainerList+"  || Act  : "+ActCommodityList);
				Extent_pass_New(driver, "Passed || Expected Commodity updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+ExpContainerList+"  || Act  : "+ActCommodityList, test, test1);
			}else {
				System.out.println("Failed || Expected Commodity not updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+ExpContainerList+"  || Act  : "+ActCommodityList);
				Extent_fail(driver, "Failed || Expected Commodity not updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+ExpContainerList+"  || Act  : "+ActCommodityList, test, test1);
			}
			
			//Collect Charges tab Validation
			waitForElement(driver, Collect_Charges_Tab);
			click(driver, Collect_Charges_Tab);
			waitForElement(driver, Collect_Charges_Table_Header);
			mouseOverToElement(driver, Collect_Charges_Table_Header);
			List<Map<String, String>> HBL_CollectionCharges_Tabledatas = getTableData(driver, Collect_Charges_Table_Header, Collect_Charges_Table_Row);
			List<String> headerColumn=splitAndExpand(ID_Table_Headers);
			String HBL_Container_Tabledata = TableDataForReport(driver, HBL_CollectionCharges_Tabledatas,ID_Table_Name,headerColumn);
			Map<String,String> Act_CollectionCharge=getCellValuesByFirstCellValue(HBL_CollectionCharges_Tabledatas,"Type","Manifest",SplitChargeCode_Header,SplitChargeAmount_Header);
			Map<String,String> Exp_CollectionCharge=BL_SplitChargeAmounts.get(hbl_Charge);
			
			if(CompareMapValues1(Exp_CollectionCharge,Act_CollectionCharge)) {
				System.out.println("Passed || Expected Collection Charges updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+Exp_CollectionCharge+"  || Act  : "+Act_CollectionCharge);
				Extent_pass_New(driver, "Passed || Expected Collection Charges updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+Exp_CollectionCharge+"  || Act  : "+Act_CollectionCharge, test, test1);
				Extent_pass_New(driver, "Expected table  : "+Expected_table+" ||  Actual Table  : "+HBL_Container_Tabledata, test, test1);
			}else {
				System.out.println("Failed : Expected Collection Charges not updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+Exp_CollectionCharge+"  || Act  : "+Act_CollectionCharge);
				Extent_fail(driver, "Failed : Expected Collection Charges not updated in the respective House BL  : "+hbl_Charge+" ||  Exp :  "+Exp_CollectionCharge+"  || Act  : "+Act_CollectionCharge, test, test1);
			}
		}
		Step_End(15, "Verify that Captured charges Must be there under HBL No in the collect charges tab and chage Amount Total Count has to Match .", test, test1);

		Step_Start(16,"click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(17,"click the yes and system has validate import dcoumentation is deleted", test, test1);

		if(do_you_want_to_delete.equalsIgnoreCase("Yes")) {
			scrollTop(driver);
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Step_End(17,"click the yes and system has validate import dcoumentation is deleted", test, test1);
		Step_End(16,"click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);

		Extent_completed(testcase_Name, test, test1);
	
	}
}
