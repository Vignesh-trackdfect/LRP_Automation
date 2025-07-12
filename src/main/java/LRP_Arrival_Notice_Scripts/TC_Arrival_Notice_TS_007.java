package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_007 extends Keywords{
	public void Arrival_Notice_TS_007(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		//		Get data from test data

		String testcase_Name="TC_Arrival_Notice_TS_007";
		
		
		


		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ArrivalNotice_Module = Excel_data.get("ArrivalNotice_Module");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Search_Number = Excel_data.get("Search_Number");
		String BL_Num = Excel_data.get("BL_Num");
		String Headers = Excel_data.get("Headers");
		
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		
		Step_Start(1, "Switch agency and open \"Arrival Notice / Freight Memo\" Module", test, test1);
		SwitchProfile(driver, AgencyUser);


		moduleNavigate(driver, ArrivalNotice_Module);


		Step_End(1, "Switch agency and open \"Arrival Notice / Freight Memo\" Module", test, test1);

	    Step_Start(2, "Click on search icon from tool bar", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
	Step_End(2, "Click on search icon from tool bar", test, test1);
	Step_Start(3, "Enter the Bl number ", test, test1);
	globalValueSearchWindow(driver, BL_Condition, Search_Number, BL_Num, "", "", "", "");
	
	
    Step_End(3, "Enter the Bl number r", test, test1);
    
	Step_Start(4, "Click search and fetch the BL ", test, test1);
	Extent_cal(test, test1, "System showing existing records correctly");	
		waitForElement(driver, arrival_Notice_No_Grid_AN);
		String arrival_Notice_Number=getText(driver, arrival_Notice_No_Grid_AN);
		System.out.println("Arrival Notice No:"+arrival_Notice_Number);
		Extent_pass(driver, "Arrival Notice No:"+arrival_Notice_Number, test, test1);
		
		
		waitForElement(driver, arrival_Notice_No_Grid_AN);
		String hbl_Number=getText(driver, hbl_Number_Grid_AN);
		System.out.println("HBL Number:"+hbl_Number);
		Extent_pass(driver, "HBL Number shows as:"+hbl_Number, test, test1);
		
		
		scrollBottom(driver);
		
		reArrangeAG_GridColumnsNew(driver,AN_coloum_click, Headers);
		
		
		waitForElement(driver, Servivce_Grid_AN);
		String service=getText(driver, Servivce_Grid_AN);
		System.out.println("Service:"+service);
		Extent_pass(driver, "Service shows as:"+service, test, test1);
		waitForElement(driver, vessel_Grid_AN);
		String vessel=getText(driver, vessel_Grid_AN);
		System.out.println("Vessel:"+vessel);
		Extent_pass(driver, "Vessel shows as:"+vessel, test, test1);
		waitForElement(driver, voyage_Grid_AN);
		String voyage=getText(driver, voyage_Grid_AN);
		System.out.println("Voyage:"+voyage);
		Extent_pass(driver, "Voyage shows as:"+voyage, test, test1);

		
		waitForElement(driver, bound_Grid_AN);
		String bound=getText(driver, bound_Grid_AN);
		System.out.println("Bound:"+bound);
		Extent_pass(driver, "Bound shows as:"+bound, test, test1);
		waitForElement(driver, portCode_Grid_AN);
		String portCode=getText(driver, portCode_Grid_AN);
		System.out.println("PortCode:"+portCode);
		Extent_pass(driver, "PortCode shows as:"+portCode, test, test1);
		
		
		waitForElement(driver, pla_Grid_AN);
		String pla=getText(driver, pla_Grid_AN);
		System.out.println("PLA:"+pla);
		Extent_pass(driver, "PLA shows as:"+pla, test, test1);
		
		waitForElement(driver, pol_Grid_AN);
		String pol=getText(driver, pol_Grid_AN);
		System.out.println("POL:"+pol);
		Extent_pass(driver, "POL shows as:"+pol, test, test1);
		waitForElement(driver, pod_Grid_AN);
		String pod=getText(driver, pod_Grid_AN);
		System.out.println("POD:"+pod);
		Extent_pass(driver, "POD shows as:"+pod, test, test1);
		
		
		waitForElement(driver, pld_Grid_AN);
		String pld=getText(driver, pld_Grid_AN);
		System.out.println("PLD:"+pld);
		Extent_pass(driver, "PLD shows as:"+pld, test, test1);
		
		waitForElement(driver, terminal_Grid_AN);
		String terminal=getText(driver, terminal_Grid_AN);
		System.out.println("Terminal:"+terminal);
		Extent_pass(driver, "Terminal shows as:"+terminal, test, test1);
		Step_End(4, "Click search and fetch the BL ", test, test1);
	Extent_cal(test, test1, "System showing existing records correctly");
	Extent_completed(testcase_Name, test, test1);
		
	

			
	}
}


