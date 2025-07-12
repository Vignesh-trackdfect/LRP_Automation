package LRP_Import_Documentation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC017 extends Keywords{

	public void Import_Documentation_SC017(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Import_Documentation_SC017";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String GlobalSearchDropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String GlobalSearchFilterOption_IMD = Excel_data.get("GlobalSearchFilterOption_IMD");
		String GlobalSearch_Number = Excel_data.get("GlobalSearch_Number");
		String ImportDoc_Select_Type2 = Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Value2 = Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Type3 = Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value3 = Excel_data.get("ImportDoc_Select_Value3");
		String BL_Type = Excel_data.get("BL_Type");
		String Cargo_Type = Excel_data.get("Cargo_Type");
		String module_BillOfLading=Excel_data.get("Module_BillOfLading");
		String BOL_Select_Type1=Excel_data.get("BOL_Select_Type1");
		String BOL_Select_Type2=Excel_data.get("BOL_Select_Type2");
		String BOL_Select_Value2=Excel_data.get("BOL_Select_Value2");
		String BOL_Select_Type3=Excel_data.get("BOL_Select_Type3");
		String BOL_Select_Value3=Excel_data.get("BOL_Select_Value3");
		String MCN_Module = Excel_data.get("MCN_Module");
		String Select_Search_Type_MCN = Excel_data.get("Select_Search_Type_MCN");
		String MCN_Select_Type2=Excel_data.get("MCN_Select_Type2");
		String MCN_Select_Value2=Excel_data.get("MCN_Select_Value2");
		String MCN_Select_Type3=Excel_data.get("MCN_Select_Type3");
		String MCN_Select_Value3=Excel_data.get("MCN_Select_Value3");
		
		Extent_Start(testCaseName, test, test1);
		// Login
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyUser);

		Extent_cal(test, test1, ImportDocumentationModule);
		
		Step_Start(1, "Open the import documentation module", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(1, "Open the import documentation module", test, test1);

		Step_Start(2, "Click the global search button ", test, test1);

		click(driver, SearchButton_Toolbar);
		waitForElement(driver, SearchButton_Toolbar );
		Step_End(2, "Click the global search button ", test, test1);

		Step_Start(3, "Retrive the BL using Global search ", test, test1);
		globalValueSearchWindow(driver, GlobalSearchDropdownCondition1, GlobalSearchFilterOption_IMD, GlobalSearch_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
		Step_End(3, "Retrive the BL using Global search ", test, test1);

		Step_Start(4, "Verify the BL Cargo Type - based on data sheet ", test, test1);
		waitForElement(driver, Cargo_Type_IMP_DOC);
		String BL_Cargo_Status_Act=getText(driver, Cargo_Type_IMP_DOC);
		
		if(Cargo_Type.equals(BL_Cargo_Status_Act)) {
			System.out.println("Matched || Expected Cargo Status : "+Cargo_Type+"  || Expected Cargo Status : "+BL_Cargo_Status_Act);
			Extent_pass_New(driver, "Matched || Expected Cargo Status : "+Cargo_Type+"  || Expected Cargo Status : "+BL_Cargo_Status_Act, test, test1);
		}else {
			System.out.println("Not Matched || Expected Cargo Status : "+Cargo_Type+"  || Expected Cargo Status : "+BL_Cargo_Status_Act);
			Extent_fail(driver, "Not Matched || Expected Cargo Status : "+Cargo_Type+"  || Expected Cargo Status : "+BL_Cargo_Status_Act, test, test1);
		}
		Step_End(4, "Verify the BL Cargo Type - based on data sheet ", test, test1);

		Step_Start(4, "Verify the BL Status - based on data sheet ", test, test1);

		waitForElement(driver, BL_status_IMP_DOC);
		String BL_Status_Act=getText(driver, BL_status_IMP_DOC);
		
		if(BL_Type.equals(BL_Status_Act)) {
			System.out.println("Matched || Expected BL Status : "+BL_Type+"  || Expected BL Status : "+BL_Status_Act);
			Extent_pass_New(driver, "Matched || Expected BL Status : "+BL_Type+"  || Expected BL Status : "+BL_Status_Act, test, test1);
		}else {
			System.out.println("Not Matched || Expected BL Status : "+BL_Type+"  || Expected BL Status : "+BL_Status_Act);
			Extent_fail(driver, "Not Matched || Expected BL Status : "+BL_Type+"  || Expected BL Status : "+BL_Status_Act, test, test1);
		}
		Step_End(4, "Verify the BL Status - based on data sheet ", test, test1);

		waitForElement(driver, PODLocationId);
		String Import_Document_POD=getText(driver, PODLocationId);
		
		waitForElement(driver, portCode_ImportDoc);
		String Import_Document_PortCode=getText(driver, portCode_ImportDoc);
		
		waitForElement(driver, BL_HBL_Summary_Tab);
		click(driver,BL_HBL_Summary_Tab);
		
		waitForElement(driver, MCN_Text_Field_IMPORT_DOC);
		String MCN_Number = getAttribute(driver, MCN_Text_Field_IMPORT_DOC, "value");
		
		if(Cargo_Type.equalsIgnoreCase("Local")) {
			Extent_call(test, test1, "Check POD is matched BL/MCN if the Import Doc POD and BL/MCN POD matched that is Local shipment.(hard code it)\r\n"
						+ "	Verify Local are matched import doc and BL.");
			if(MCN_Number.equals("")) {
				moduleNavigate(driver, module_BillOfLading);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, GlobalSearchDropdownCondition1, BOL_Select_Type1, GlobalSearch_Number, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOL_Select_Value3);
				waitForElement(driver, PODLocationIdBoL);
				String POD_Value_BL=getText(driver, PODLocationIdBoL);
				
				if(POD_Value_BL.equals(Import_Document_POD)) {
					System.out.println("Matched || Expected : POD Value in Import Documentation and POD Value in Bill of Lading Should be Same when the Cargo Type is 'Local' || Actual : POD Value in Import Documentation and POD Value in Bill of Lading are Same when the Cargo Type is 'Local' || POD Value Imp Doc : "+Import_Document_POD+",  POD in Bill of Lading : "+POD_Value_BL);
					Extent_pass_New(driver, "Matched || Expected : POD Value in Import Documentation and POD Value in Bill of Lading Should be Same when the Cargo Type is 'Local' || Actual : POD Value in Import Documentation and POD Value in Bill of Lading are Same when the Cargo Type is 'Local' || POD Value Imp Doc : "+Import_Document_POD+",  POD in Bill of Lading : "+POD_Value_BL, test, test1);					
				}else {
					System.out.println("Not Matched || Expected : POD Value in Import Documentation and POD Value in Bill of Lading Should be Same when the Cargo Type is 'Local' || Actual : POD Value in Import Documentation and POD Value in Bill of Lading are not Same when the Cargo Type is 'Local' || POD Value Imp Doc : "+Import_Document_POD+",  POD in Bill of Lading : "+POD_Value_BL);
					Extent_fail(driver, "Not Matched || Expected : POD Value in Import Documentation and POD Value in Bill of Lading Should be Same when the Cargo Type is 'Local' || Actual : POD Value in Import Documentation and POD Value in Bill of Lading are not Same when the Cargo Type is 'Local' || POD Value Imp Doc : "+Import_Document_POD+",  POD in Bill of Lading : "+POD_Value_BL, test, test1);					
				}	
			}else {
				scrollTop(driver);
				moduleNavigate(driver, MCN_Module);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, GlobalSearchDropdownCondition1, Select_Search_Type_MCN, MCN_Number, MCN_Select_Type2, MCN_Select_Value2, MCN_Select_Type3, MCN_Select_Value3);
				waitForElement(driver, MCN_POD);
				String POD_Value_MCN=getText(driver, MCN_POD);
				if(POD_Value_MCN.equals(Import_Document_POD)) {
					System.out.println("Matched || Expected : POD Value in Import Documentation and POD Value in MCN module Should be Same when the Cargo Type is 'Local' || Actual : POD Value in Import Documentation and POD Value in MCN module are Same when the Cargo Type is 'Local' || POD Value Imp Doc : "+Import_Document_POD+",  POD in MCN module : "+POD_Value_MCN);
					Extent_pass_New(driver, "Matched || Expected : POD Value in Import Documentation and POD Value in MCN module Should be Same when the Cargo Type is 'Local' || Actual : POD Value in Import Documentation and POD Value in MCN module are Same when the Cargo Type is 'Local' || POD Value Imp Doc : "+Import_Document_POD+",  POD in MCN module : "+POD_Value_MCN, test, test1);					
				}else {
					System.out.println("Not Matched || Expected : POD Value in Import Documentation and POD Value in MCN module Should be Same when the Cargo Type is 'Local' || Actual : POD Value in Import Documentation and POD Value in MCN module are not Same when the Cargo Type is 'Local' || POD Value Imp Doc : "+Import_Document_POD+",  POD in MCN module : "+POD_Value_MCN);
					Extent_fail(driver, "Not Matched || Expected : POD Value in Import Documentation and POD Value in MCN module Should be Same when the Cargo Type is 'Local' || Actual : POD Value in Import Documentation and POD Value in MCN module are not Same when the Cargo Type is 'Local' || POD Value Imp Doc : "+Import_Document_POD+",  POD in MCN module : "+POD_Value_MCN, test, test1);					
				}	
			}
			Extent_call(test, test1, "Check POD is matched BL/MCN if the Import Doc POD and BL/MCN POD matched that is Local shipment.(hard code it)\r\n"
					+ "	Verify Local are matched import doc and BL.");
		}else {
			Extent_call(test, test1, "Check POD is matched BL/MCN if the Import Doc POD and BL/MCN POD matched that is Local shipment.(hard code it)\r\n"
					+ "	Verify Local are matched import doc and BL.");
			if(MCN_Number.equals("")) {
				moduleNavigate(driver, module_BillOfLading);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, GlobalSearchDropdownCondition1, BOL_Select_Type1, GlobalSearch_Number, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOL_Select_Value3);
				waitForElement(driver, PODLocationIdBoL);
				String POD_Value_BL=getText(driver, PODLocationIdBoL);
				if(!POD_Value_BL.equals(Import_Document_PortCode)) {
					System.out.println("Matched || Expected : Portcode Value in Import Documentation and POD Value in Bill of Lading Should not be Same when the Cargo Type is 'Transhipment' || Actual : Portcode Value in Import Documentation and POD Value in Bill of Lading are not Same when the Cargo Type is 'Transhipment' || Portcode Value Imp Doc : "+Import_Document_PortCode+",  POD in Bill of Lading : "+POD_Value_BL);
					Extent_pass_New(driver, "Matched || Expected : Portcode Value in Import Documentation and POD Value in Bill of Lading Should not be Same when the Cargo Type is 'Transhipment' || Actual : Portcode Value in Import Documentation and POD Value in Bill of Lading are not Same when the Cargo Type is 'Transhipment' || Portcode Value Imp Doc : "+Import_Document_PortCode+",  POD in Bill of Lading : "+POD_Value_BL, test, test1);					
				}else {
					System.out.println("Not Matched || Expected : Portcode Value in Import Documentation and POD Value in Bill of Lading Should not be Same when the Cargo Type is 'Transhipment' || Actual : Portcode Value in Import Documentation and POD Value in Bill of Lading are Same when the Cargo Type is 'Transhipment' || Portcode Value Imp Doc : "+Import_Document_PortCode+",  POD in Bill of Lading : "+POD_Value_BL);
					Extent_fail(driver, "Not Matched || Expected : Portcode Value in Import Documentation and POD Value in Bill of Lading Should not be Same when the Cargo Type is 'Transhipment' || Actual : Portcode Value in Import Documentation and POD Value in Bill of Lading are Same when the Cargo Type is 'Transhipment' || Portcode Value Imp Doc : "+Import_Document_PortCode+",  POD in Bill of Lading : "+POD_Value_BL, test, test1);					
				}	
				
			}else {
				
				scrollTop(driver);
				moduleNavigate(driver, MCN_Module);

				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				
				globalValueSearchWindow(driver, GlobalSearchDropdownCondition1, Select_Search_Type_MCN, MCN_Number, MCN_Select_Type2, MCN_Select_Value2, MCN_Select_Type3, MCN_Select_Value3);
				
				waitForElement(driver, MCN_POD);
				String POD_Value_MCN=getText(driver, MCN_POD);
				
				if(!POD_Value_MCN.equals(Import_Document_PortCode)) {
					System.out.println("Matched || Expected : Portcode Value in Import Documentation and POD Value in MCN Module Should not be Same when the Cargo Type is 'Transhipment' || Actual : Portcode Value in Import Documentation and POD Value in MCN Module are not Same when the Cargo Type is 'Transhipment' || Portcode Value Imp Doc : "+Import_Document_PortCode+",  POD in MCN Module : "+POD_Value_MCN);
					Extent_pass_New(driver, "Matched || Expected : Portcode Value in Import Documentation and POD Value in MCN Module Should not be Same when the Cargo Type is 'Transhipment' || Actual : Portcode Value in Import Documentation and POD Value in MCN Module are not Same when the Cargo Type is 'Transhipment' || Portcode Value Imp Doc : "+Import_Document_PortCode+",  POD in MCN Module : "+POD_Value_MCN, test, test1);					
				}else {
					System.out.println("Not Matched || Expected : Portcode Value in Import Documentation and POD Value in MCN Module Should not be Same when the Cargo Type is 'Transhipment' || Actual : Portcode Value in Import Documentation and POD Value in MCN Module are Same when the Cargo Type is 'Transhipment' || Portcode Value Imp Doc : "+Import_Document_PortCode+",  POD in MCN Module : "+POD_Value_MCN);
					Extent_fail(driver, "Not Matched || Expected : Portcode Value in Import Documentation and POD Value in MCN Module Should not be Same when the Cargo Type is 'Transhipment' || Actual : Portcode Value in Import Documentation and POD Value in MCN Module are Same when the Cargo Type is 'Transhipment' || Portcode Value Imp Doc : "+Import_Document_PortCode+",  POD in MCN Module : "+POD_Value_MCN, test, test1);					
				}	
			}
			Extent_call(test, test1, "Check POD is matched BL/MCN if the Import Doc POD and BL/MCN POD matched that is Local shipment.(hard code it)\r\n"
					+ "	Verify Local are matched import doc and BL.");
		}
		
		Extent_completed(testCaseName, test, test1);

	}
}
