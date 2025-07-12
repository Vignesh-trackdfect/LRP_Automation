package LRP_Arrival_Notice_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_042 extends Keywords{

	public void Arrival_Notice_TS_042(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		
		String tc_Name="TC_Arrival_Notice_TS_042";
		
		
		

		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String agencyUser =Excel_data.get("AgencyUser");
		String arrival_Module_Search =Excel_data.get("Arrival_Module_Search");
		String bl_Number_Expected =Excel_data.get("Bl_Number_Expected");
		String discharge_Service_Data =Excel_data.get("Discharge_Service_Data");
		String service_data =Excel_data.get("Service_data");
		String vessel =Excel_data.get("Vessel");
		String voyage =Excel_data.get("Voyage");
		
		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);


		//	Switch the Profile
		Extent_call(test, test1,"**Switch the Profile Start**");

		Step_Start(1, " Switch the agency ", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, " Switch the agency ", test, test1);

		Step_Start(2, "open \"Arrival Notice / Freight Memo ", test, test1);

		moduleNavigate(driver, arrival_Module_Search);

		Step_End(2, "open \"Arrival Notice / Freight Memo ", test, test1);

	newButton(driver);
		
		waitForElement(driver, by_Vessel_AN);
		click(driver, by_Vessel_AN);
		
		Step_Start(3, ".Enter the respective service,vessel and voyage and click search", test, test1);
		waitForElement(driver, discharge_Srvce_Txtfld_AN);
		sendKeys(driver, discharge_Srvce_Txtfld_AN, discharge_Service_Data);
		waitForElement(driver, overlay_Box);
		sendKeys(driver, overlay_Service_Code_Txtfield, service_data);
		sendKeys(driver, overlay_Vessel_Code_Txtfield, vessel);
		sendKeys(driver, overlay_Voyage_Code_Txtfield, voyage);
		waitForElement(driver, Overlay_panel_First_Click);
		click(driver, Overlay_panel_First_Click);
		waitForElement(driver, Vessel_Select_Btn);
		click(driver, Vessel_Select_Btn);
		Step_End(3, ".Enter the respective service,vessel and voyage and click search", test, test1);
	
		waitForElement(driver, show_Btn_An);
		click(driver, show_Btn_An);
		
		Step_Start(4, "After fetching BL details click the AG grid option (New pop up window will be opened )", test, test1);
		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		
		Step_End(4, "After fetching BL details click the AG grid option (New pop up window will be opened )", test, test1);

		Step_Start(5, "Click the condition filter icon", test, test1);
		waitForElement(driver, condition_Filter_AN);
		click(driver, condition_Filter_AN);
		
		Step_End(5, "Click the condition filter icon", test, test1);

		Step_Start(6, "Type some corresponding value in that search box", test, test1);
		waitForElement(driver, bl_Number_Input);
		sendKeys(driver, bl_Number_Input,bl_Number_Expected );
		
		waitForElement(driver, collect_Bl_Numbers); 
		String bl_Number_Actual = getText(driver, collect_Bl_Numbers);
		
		if(bl_Number_Actual.equals(bl_Number_Expected)) {
			
			System.out.println("Matched || Expected Bl number : "+bl_Number_Expected+" Actual Bl number : "+bl_Number_Actual);
			Extent_pass(driver, "Matched || Expected Bl number : "+bl_Number_Expected+" Actual Bl number : "+bl_Number_Actual, test, test1);
			System.out.println("System filters and displays the values correctly");
		}else {
			System.out.println("System filters and displays the values incorrectly");
			System.out.println("Not Matched || Expected Bl number : "+bl_Number_Expected+" Actual Bl number : "+bl_Number_Actual);
			Extent_fail(driver, "Not Matched || Expected Bl number : "+bl_Number_Expected+" Actual Bl number : "+bl_Number_Actual, test, test1);
			
		}
		
		Step_End(6, "Type some corresponding value in that search box", test, test1);

		
		Extent_completed(tc_Name, test, test1);
		
		
		
		
		
		
	}
	
}
