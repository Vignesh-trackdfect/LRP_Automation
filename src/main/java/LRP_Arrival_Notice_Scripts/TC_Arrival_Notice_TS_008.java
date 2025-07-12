package LRP_Arrival_Notice_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_008 extends Keywords{
	public void Arrival_Notice_TS_008(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testCaseName = "TC_Arrival_Notice_TS_008";

		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String AgencyUser =Excel_data.get("AgencyUser");
		String moduleImportDoc = Excel_data.get("moduleImportDoc");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Search_Number = Excel_data.get("Search_Number");
		String BL_Num = Excel_data.get("BL_Num");
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		// Login to the Application
		LRP_Login(driver, Username, Password);
		

		//	Switch the Profile
		Step_Start(1, "Switch agency and open Import documentation module", test, test1);
		SwitchProfile(driver, AgencyUser);

		
		moduleNavigate(driver, moduleImportDoc);

		Step_End(1, "Switch agency and open Import documentation module", test, test1);
		Step_Start(2, "Click search button and paste the Bl ", test, test1);
		
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, BL_Condition, Search_Number, BL_Num, "", "", "", "");
		
	
		Step_End(2, "Click search button and paste the Bl ", test, test1);
		Step_Start(3, "Click select button ", test, test1);
	
		Step_End(3, "Click select button ", test, test1);
		waitForElement(driver, AN_servicename);
		String ID_Service_Actual=getAttribute(driver, AN_servicename,"value");
		waitForElement(driver, AN_vesselcode_Field);
		String ID_Vessel_Actual=getText(driver, AN_vesselcode_Field);
		waitForElement(driver, ANvoyagecode_Field);
		String ID_Voyage_Actual=getText(driver, ANvoyagecode_Field);
		waitForElement(driver, AN_bound_Field);
		String ID_Bound_Actual=getText(driver, AN_bound_Field);
		waitForElement(driver, AN_portcode_Field);
		String ID_Portcode_Actual=getText(driver, AN_portcode_Field);
		waitForElement(driver, AN_terminal_Code);
		String ID_Terminal_Code=getText(driver, AN_terminal_Code);
		Step_Start(4, "click arrival notice button", test, test1);
		waitForElement(driver, AN_Arrival_notice_button);
		click(driver, AN_Arrival_notice_button);
		Step_End(4, "click arrival notice button", test, test1);
		Step_Start(5, "System displayed the Bl number which has same vessel and voyage details", test, test1);
		waitForElement(driver, discharge_Service_TF_AN);
		String Arrival_Notice_Service=getAttribute(driver, discharge_Service_TF_AN,"value");
		if(ID_Service_Actual.equals(Arrival_Notice_Service)) {
			Extent_pass(driver, "Matched || Expected Import Documentation Module Sevice Code was : "+ID_Service_Actual +" || Actual Arrival Notice Module Service Code is : "+Arrival_Notice_Service, test, test1);
			System.out.println("Matched || Expected Import Documentation Module Sevice Code was : "+ID_Service_Actual +" || Actual Arrival Notice Module Service Code is : "+Arrival_Notice_Service);
		}else {
			Extent_fail(driver, "Not Matched || Expected Import Documentation Module Sevice Code was : "+ID_Service_Actual +" || Actual Arrival Notice Module Service Code is : "+Arrival_Notice_Service, test, test1);
			System.out.println("Not Matched || Expected Import Documentation Module Sevice Code was : "+ID_Service_Actual +" || Actual Arrival Notice Module Service Code is : "+Arrival_Notice_Service);
		}

		waitForElement(driver, discharge_Vessel_TF_AN);
		String  Arrival_Notice_Vessel=getAttribute(driver, discharge_Vessel_TF_AN,"value");
		if(ID_Vessel_Actual.equals(Arrival_Notice_Vessel)) {
			Extent_pass(driver, "Matched || Expected Import Documentation Module Vessel Code was : "+ID_Vessel_Actual +" || Actual Arrival Notice Module Vessel Code is : "+Arrival_Notice_Vessel, test, test1);
			System.out.println("Matched || Expected Import Documentation Module Vessel Code was : "+ID_Vessel_Actual +" || Actual Arrival Notice Module Vessel Code is : "+Arrival_Notice_Vessel);
		}else {
			Extent_fail(driver, "Not Matched || Expected Import Documentation Module Vessel Code was : "+ID_Vessel_Actual +" || Actual Arrival Notice Module Vessel Code is : "+Arrival_Notice_Vessel, test, test1);
			System.out.println("Not Matched || Expected Import Documentation Module Vessel Code was : "+ID_Vessel_Actual +" || Actual Arrival Notice Module Vessel Code is : "+Arrival_Notice_Vessel);
		}
		waitForElement(driver, discharge_Voyage_TF_AN);
		String  Arrival_Notice_Voyage=getAttribute(driver, discharge_Voyage_TF_AN,"value");
		if(ID_Voyage_Actual.equals(Arrival_Notice_Voyage)) {
			Extent_pass(driver, "Matched || Expected Import Documentation Module Voyage Value was : "+ID_Voyage_Actual +" || Actual Arrival Notice Module Voyage Value is : "+Arrival_Notice_Voyage, test, test1);
			System.out.println("Matched || Expected Import Documentation Module Voyage Value was : "+ID_Voyage_Actual +" || Actual Arrival Notice Module Voyage Value is : "+Arrival_Notice_Voyage);
		}else {
			Extent_fail(driver, "Not Matched || Expected Import Documentation Module Voyage Value was : "+ID_Voyage_Actual +" || Actual Arrival Notice Module Voyage Value is : "+Arrival_Notice_Voyage, test, test1);
			System.out.println("Not Matched || Expected Import Documentation Module Voyage Value was : "+ID_Voyage_Actual +" || Actual Arrival Notice Module Voyage Value is : "+Arrival_Notice_Voyage);
		}
		waitForElement(driver, discharge_Bound_TF_AN);
		String  Arrival_Notice_Bound=getAttribute(driver, discharge_Bound_TF_AN,"value");
		if(ID_Bound_Actual.equals(Arrival_Notice_Bound)) {
			Extent_pass(driver, "Matched || Expected Import Documentation Module Bound Value was : "+ID_Bound_Actual +" || Actual Arrival Notice Module Bound Value is : "+Arrival_Notice_Bound, test, test1);
			System.out.println("Matched || Expected Import Documentation Module Bound Value was : "+ID_Bound_Actual +" || Actual Arrival Notice Module Bound Value is : "+Arrival_Notice_Bound);
		}else {
			Extent_fail(driver, "Not Matched || Expected Import Documentation Module Bound Value was : "+ID_Bound_Actual +" || Actual Arrival Notice Module Bound Value is : "+Arrival_Notice_Bound, test, test1);
			System.out.println("Not Matched || Expected Import Documentation Module Bound Value was : "+ID_Bound_Actual +" || Actual Arrival Notice Module Bound Value is : "+Arrival_Notice_Bound);
		}
		waitForElement(driver, pod_TF_AN);
		String  Arrival_Notice_Portcode=getAttribute(driver, pod_TF_AN,"value");
		if(ID_Portcode_Actual.equals(Arrival_Notice_Portcode)) {
			Extent_pass(driver, "Matched || Expected Import Documentation Module Port Value was : "+ID_Portcode_Actual +" || Actual Arrival Notice Module Port Value is : "+Arrival_Notice_Portcode, test, test1);
			System.out.println("Matched || Expected Import Documentation Module Port Value was : "+ID_Portcode_Actual +" || Actual Arrival Notice Module Port Value is : "+Arrival_Notice_Portcode);
		}else {
			Extent_fail(driver, "Not Matched || Expected Import Documentation Module Port Value was : "+ID_Portcode_Actual +" || Actual Arrival Notice Module Port Value is : "+Arrival_Notice_Portcode, test, test1);
			System.out.println("Not Matched || Expected Import Documentation Module Port Value was : "+ID_Portcode_Actual +" || Actual Arrival Notice Module Port Value is : "+Arrival_Notice_Portcode);
		}
		waitForElement(driver, discharge_Terminal_TF_AN);
		String  Arrival_Notice_Terminal_Code=getAttribute(driver, discharge_Terminal_TF_AN,"value");
		if(ID_Terminal_Code.equals(Arrival_Notice_Terminal_Code)) {
			Extent_pass(driver, "Matched || Expected Import Documentation Module Terminal Value was : "+ID_Terminal_Code +" || Actual Arrival Notice Module Terminal Value is : "+Arrival_Notice_Terminal_Code, test, test1);
			System.out.println("Matched || Expected Import Documentation Module Terminal Value was : "+ID_Terminal_Code +" || Actual Arrival Notice Module Terminal Value is : "+Arrival_Notice_Terminal_Code);
		}else {
			Extent_fail(driver, "Not Matched || Expected Import Documentation Module Terminal Value was : "+ID_Terminal_Code +" || Actual Arrival Notice Module Terminal Value is : "+Arrival_Notice_Terminal_Code, test, test1);
			System.out.println("Not Matched || Expected Import Documentation Module Terminal Value was : "+ID_Terminal_Code +" || Actual Arrival Notice Module Terminal Value is : "+Arrival_Notice_Terminal_Code);
		}
		Step_End(5, "System displayed the Bl number which has same vessel and voyage details", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}	
