package LRP_Arrival_Notice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_023 extends Keywords {
	
	public void Arrival_Notice_TS_023(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		
		String tc_Name = "TC_Arrival_Notice_TS_023";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String arrival_Module_Search = Excel_data.get("Arrival_Module_Search");
		String discharge_Service_Data =Excel_data.get("Discharge_Service_Data");
		String service_data =Excel_data.get("Service_data");
		String vessel =Excel_data.get("Vessel");
		String voyage =Excel_data.get("Voyage");
		String imp_Doc_Module_Search = Excel_data.get("Imp_Doc_Module_Search").trim();
		String BL_Condition = Excel_data.get("BL_Condition");
		String Select_service = Excel_data.get("Select_service");
		String Select_vessels = Excel_data.get("Select_vessels");
		String Select_voyage = Excel_data.get("Select_voyage");
	
	
		
	


		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		// Login to the Application
		

		LRP_Login(driver, username, password);


		// Switch the Profile
		Extent_call(test, test1, "**Switch the Profile Start**");
		Step_Start(1, "Switch agency and open Arrival Notice / Freight Memo Module", test, test1);

		SwitchProfile(driver, agencyUser);


		moduleNavigate(driver, arrival_Module_Search);


		Step_End(1, "Switch agency and open Arrival Notice / Freight Memo Module", test, test1);

		Step_Start(2, "Click on New Button", test, test1);
		newButton(driver);
		Step_End(2, "Click on New Button", test, test1);

		Step_Start(3, "click on by vessel option", test, test1);
		
		waitForElement(driver, by_Vessel_Button_AN);
		click(driver, by_Vessel_Button_AN);
		
		Step_End(3, "click on by vessel option", test, test1);
		Step_Start(4, ".Enter the valid Discharge service", test, test1);
		
		waitForElement(driver, discharge_Srvce_Txtfld_AN);
		sendKeys(driver, discharge_Srvce_Txtfld_AN, discharge_Service_Data);
		
		Step_End(4, ".Enter the valid Discharge service", test, test1);

		Step_Start(5, ".Choose the respective vessel and voyage details ", test, test1);
		waitForElement(driver, overlay_Box);
		sendKeys(driver, overlay_Service_Code_Txtfield, service_data);
		sendKeys(driver, overlay_Vessel_Code_Txtfield, vessel);
		sendKeys(driver, overlay_Voyage_Code_Txtfield, voyage);
		waitForElement(driver, Overlay_panel_First_Click);
		click(driver, Overlay_panel_First_Click);
		waitForElement(driver, Vessel_Select_Btn);
		click(driver, Vessel_Select_Btn);
		Step_End(5, ".Choose the respective vessel and voyage details ", test, test1);

		Step_Start(6, "Click the Show button", test, test1);
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		Step_End(6, "Click the Show button", test, test1);
		
		List<String> hbl_Nums_In_Arr_Table=new ArrayList<String>();

		
		List<WebElement> hbl_Numbers = listOfElements(driver, hbl_Num_Cell_AN);
		
		for(WebElement hbl_Nums_In_Table:hbl_Numbers) {
			
			
			String hbl_Nums = hbl_Nums_In_Table.getText();
			
			hbl_Nums_In_Arr_Table.add(hbl_Nums);
			
		}
		
		System.out.println("hbl numbers present in the table :"+hbl_Nums_In_Arr_Table);
		System.out.println("total records present in the list : "+hbl_Nums_In_Arr_Table.size());
		
	
		moduleNavigate(driver, imp_Doc_Module_Search);
		
		
		

		waitForElement(driver, SearchButton_Toolbar );
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, BL_Condition, Select_service, service_data, Select_vessels,vessel, Select_voyage,voyage);
		
		
		
		scrollTop(driver);

		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		waitForElement(driver, ANfirst_alldropdown);
		click(driver, ANfirst_alldropdown);
		waitForElement(driver, SavedBL_Option);
		click(driver, SavedBL_Option);
		waitForDisplay(driver, ANShowBLButton);
		click(driver, ANShowBLButton);
		
		waitForElement(driver, BlNoSearchButton);
		click(driver, BlNoSearchButton);
		
		
		List<WebElement> bls_In_Import_Doc = listOfElements(driver, saved_Bls);
		
		List<String> bl_Numbers_Final_Check=new ArrayList<String>();

		for(WebElement bl_actual:bls_In_Import_Doc) {
			String bl_Available_In_Import_Doc = bl_actual.getText();
			bl_Numbers_Final_Check.add(bl_Available_In_Import_Doc);
		}
		
		if(hbl_Nums_In_Arr_Table.equals(bl_Numbers_Final_Check)) {
			System.out.println("MATCHED || EXPECTED BLS IN ARRIVAL NOTICE MODULE -> "+hbl_Nums_In_Arr_Table+" || ACTUAL BLS IN IMPORT DOC MODULE -> "+bl_Numbers_Final_Check);
			Extent_pass(driver, "MATCHED || EXPECTED BLS IN ARRIVAL NOTICE MODULE -> "+hbl_Nums_In_Arr_Table+" || ACTUAL BLS IN IMPORT DOC MODULE -> "+bl_Numbers_Final_Check, test, test1);
		}else {
			System.out.println("NOT MATCHED || EXPECTED BLS IN ARRIVAL NOTICE MODULE -> "+hbl_Nums_In_Arr_Table+" || ACTUAL BLS IN IMPORT DOC MODULE -> "+bl_Numbers_Final_Check);
			Extent_fail(driver, "NOT MATCHED || EXPECTED BLS IN ARRIVAL NOTICE MODULE -> "+hbl_Nums_In_Arr_Table+" || ACTUAL BLS IN IMPORT DOC MODULE -> "+bl_Numbers_Final_Check, test, test1);
		}
		
		Extent_completed(tc_Name, test, test1);
	}
	
}
