package LRP_Import_Documentation_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.ImportDocumentation_Locators;

public class TC_Import_Documentation_SC031 extends Keywords{
	public void Import_Documentation_SC031(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC031";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String bl_Number = Excel_data.get("bl_Number");
		String documentation_Saved_Popup_Exp = Excel_data.get("documentation_Saved_Popup_Exp").trim();
		String ID_Commodity_Table_Name=Excel_data.get("ID_Commodity_Table_Name");
		String ID__Commodity_Table_Headers=Excel_data.get("ID_Commodity_Table_Headers");
		String HBL_Table_Name=Excel_data.get("HBL_Table_Name");
		String HBL_Table_Headers=Excel_data.get("HBL_Table_Headers");
		String House_BL_Status_Exp=Excel_data.get("House_BL_Status_Exp");
		String House_BL_Number = Excel_data.get("House_BL_Number");
		String House_Commodity_Number = Excel_data.get("House_Commodity_Number");
		String package_Input = Excel_data.get("package_Input");
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
		
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
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
		
		deleteSavedBL(driver,House_BL_Status_Exp,dropdownCondition1,bl_Number);
		
		waitForElement(driver, House_Button_Imp_DOC);
		click(driver, House_Button_Imp_DOC);
		Step_End(2, "after retrive the bl.A. Master and House Bl button has avaliable then click the house button", test, test1);

		//Code modified here by Vignesh on 16_04_2025. In order to allocate same containers with seperate amount into Every House BL.
		scrollBottom(driver);
		List<String> HBL_BL_NumbersList=splitAndExpand(House_BL_Number,",");
		List<String> HBL_CommodityList=splitAndExpand(House_Commodity_Number,"/");
		List<String> HBL_package_Lists_TestData=splitAndExpand(package_Input,"/");
		
		//Storing the package Value for each Commodity for the Respective House BL
		int count=0;
		Map<String,Map<String,List<String>>> HBL_PackageList= new HashMap<String, Map<String,List<String>>>();
		for(int h=0;h<HBL_BL_NumbersList.size();h++) {
			String HouseBL=HBL_BL_NumbersList.get(h);
			Map<String,List<String>> Commodity_package=new HashMap<String,List<String>>();
			List<String>  Commodity_ID=splitAndExpand(HBL_CommodityList.get(h));
			for(int Cont=0;Cont<Commodity_ID.size();Cont++) {
				String Commodity=Commodity_ID.get(Cont);
				List<String> ActPackage=splitAndExpand(HBL_package_Lists_TestData.get(count));
				Commodity_package.put(Commodity, ActPackage);
				HBL_PackageList.put(HouseBL, Commodity_package);
				count++;
			}
		}
		//Code modified here by Vignesh on 16_04_2025. In order to allocate same containers with seperate amount into Every House BL.
				
		//Storing the package Value for each Commodity
		Map<String,Map<String,String>> HBL_Commodity_PackageList=new HashMap<String,Map<String,String>>();
		List<Map<String, String>> HBL_Tabledatas = getTableData(driver, HBL_Commodity_Table_Header, HBL_Commodity_Table_Row);
		List<String> HBL_columnheaders = splitAndExpand(HBL_Table_Headers);
		String HBL_Container_Tabledata = TableDataForReport(driver, HBL_Tabledatas,HBL_Table_Name,HBL_columnheaders);
		
		for(int i=0;i<HBL_BL_NumbersList.size();i++) {
			Step_Start(3, "Enter the HouseblNo and click the add in HBL updation Tab.", test, test1);
			Step_Start(4, "we can add more than one hosue bL.", test, test1);

			String HouseBL=HBL_BL_NumbersList.get(i);
			Map<String,String>  ComomdityPackageExpList=new HashMap<String,String>();
			waitForElement(driver, House_BL_Field);
			click(driver, House_BL_Field);
			sendKeys(driver, House_BL_Field, HouseBL);
			click(driver, Add_House_BL_Button);
			Step_End(3, "Enter the HouseblNo and click the add in HBL updation Tab.", test, test1);
			Step_End(4, "we can add more than one hosue bL.", test, test1);
			
			Step_Start(5, "select the hosuebl using h.bl.no dropdown", test, test1);
			waitForElement(driver, HBL_No_DropDown1);
			mouseOverToElement(driver, HBL_No_DropDown1);
			click(driver, HBL_No_DropDown1);//changed
			String DropDown_Select1 = String.format(ImportDocumentation_Locators.House_No_Select1,HouseBL);
			waitForElement(driver, DropDown_Select1);
			click(driver, DropDown_Select1);
			Step_End(5, "select the hosuebl using h.bl.no dropdown", test, test1);
			List<String> HouseBL_CommodityLists=splitAndExpand(HBL_CommodityList.get(i));
			
			for(int k=0;k<HouseBL_CommodityLists.size();k++) {
				Step_Start(6, "select the container and commodity using dropdown ", test, test1);
				String commodityName=HouseBL_CommodityLists.get(k);
				waitForElement(driver, Commodity_Input_Import);
				click(driver, Commodity_Input_Import);
				String HBL_DropDown_Select1 = String.format(Commodity_Select,commodityName);
				waitForElement(driver, HBL_DropDown_Select1);
				click(driver,HBL_DropDown_Select1);
				Step_End(6, "select the container and commodity using dropdown ", test, test1);
				
				Step_Start(7, "enter the packages and add .same as another house bl ", test, test1);
				int packageTotal=0;
				List<String> packagesList=HBL_PackageList.get(HouseBL).get(commodityName);
				for(int a=0;a<packagesList.size();a++) {
					String packageValue=packagesList.get(a);
					mouseOverToElement(driver, Package_Field);
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
				String TotalPackage=String.valueOf(packageTotal);
				ComomdityPackageExpList.put(commodityName, TotalPackage);
				Step_End(7, "enter the packages and add .same as another house bl ", test, test1);
			}
		    System.out.println("package Added : "+ComomdityPackageExpList );
		    HBL_Commodity_PackageList.put(HouseBL, ComomdityPackageExpList);
		}
		
		Step_Start(8, "After adding the House bl and container then cick the save button in import documentation", test, test1);
	    scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		Step_End(8, "After adding the House bl and container then cick the save button in import documentation", test, test1);
	
		Step_Start(9, "System will validate 'Import Documentation-Balance is not zero. Charge amount is not splitted. Do you want to proceed?' YES OR NO'", test, test1);
		if (isDisplayed(driver, NotMatching_Popup)) {
			String continer_Popup = getText(driver, NotMatching_Popup);
			System.out.println("Matched || Actual Popup Value was : " + continer_Popup);
			Extent_pass_New(driver, "Matched || Actual Popup Value was : " + continer_Popup, test,test1);
			click1(driver, NotMatching_Popup_Yes);
		}
		
		while(isdisplayed(driver, popup_Message_Yes_Button)) {
			click1(driver,popup_Message_Yes_Button);
			waitForDisplay(driver, popup_Message_Yes_Button);
		}
		
		Step_End(9, "System will validate 'Import Documentation-Balance is not zero. Charge amount is not splitted. Do you want to proceed?' YES OR NO'", test, test1);
		
		Step_Start(10, "Click the Yes ,BL has saved in Import Documentation -System will popluate the validate ''Import Documentation is saved", test, test1);

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
		Step_End(10, "Click the Yes ,BL has saved in Import Documentation -System will popluate the validate ''Import Documentation is saved", test, test1);

		Step_Start(11, "Capture the Container No, and Qty Count after saved the Import Doc need to Verify Total Qty Count should match.", test, test1);

		waitForElement(driver, Commodity_Tab);
		click(driver,Commodity_Tab);
		for (String hbl_Number : HBL_Commodity_PackageList.keySet()) {
		    //System.out.println(hbl_Number);
			waitForElement(driver, HBL_No_DropDown);
			click(driver, HBL_No_DropDown);
			String HouseBL_No_Select = String.format(DropDown_Select,hbl_Number);
			click(driver, HouseBL_No_Select);
			waitForElement(driver, Commodity_Tab);
			click(driver, Commodity_Tab);
			scrollBottom(driver);
			waitForElement(driver, Commodity_Table_Header);
			mouseOverToElement(driver, Commodity_Table_Header);
			List<String> columnheaders = splitAndExpand(ID__Commodity_Table_Headers);
			List<Map<String, String>> HBL_Commodity_Tabledatas = getTableData(driver, Commodity_Table_Header, Commodity_Table_Row);
			List<List<String>> Container_tableData_Exp = getValuesByHeaders(HBL_Commodity_Tabledatas,columnheaders);
			String Container_TabledataExp = TableDataForReport1(driver, Container_tableData_Exp,ID_Commodity_Table_Name,columnheaders);
		    
			Map<String,String> Act_QuantityList=getCommodityValue(HBL_Commodity_Tabledatas,columnheaders.get(0),columnheaders.get(1));
			Map<String,String> Exp_QuantityList=HBL_Commodity_PackageList.get(hbl_Number);
			
			if(CompareMapValues(Exp_QuantityList,Act_QuantityList)) {
				System.out.println("  Passed    *********  -> House_BL_Number");
				Extent_pass_New(driver, " Matched  || Expected Quantity updated in the respective House BL  : "+hbl_Number+" ||  Exp :  "+Exp_QuantityList+"  || Act  : "+Act_QuantityList, test, test1);
				Extent_pass_New(driver, "Expected Table : "+HBL_Container_Tabledata+" ||  Actual Table : "+Container_TabledataExp , test, test1);
			}else {
				System.out.println("  Failed    *********  -> House_BL_Number");
				Extent_fail(driver, "Expected Quantity not updated in the respective House BL  : "+hbl_Number+" ||  Exp :  "+Exp_QuantityList+"  || Act  : "+Act_QuantityList, test, test1);
			}
			scrollTop(driver);
		}
		
		Step_End(11, "Capture the Container No, and Qty Count after saved the Import Doc need to Verify Total Qty Count should match.", test, test1);
		Step_Start(12, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(13, "click the yes and system has validate import dcoumentation is deleted ", test, test1);

		if(do_you_want_to_delete.equalsIgnoreCase("Yes")) {
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Step_End(12, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(13, "click the yes and system has validate import dcoumentation is deleted ", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
