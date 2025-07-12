package LRP_CRO_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_CRO_SC021 extends Keywords {

	public void CRO_SC021(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {

		String testCaseName="TC_CRO_SC021";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("agencyUser");
		String Plugin_config_Module_Name = Excel_data.get("Plugin_config_Module_Name");
		String Plugin_column_Header = Excel_data.get("Plugin_column_Header");
		String Plugin_Condition = Excel_data.get("Plugin_Condition");
		String PluginId_Input = Excel_data.get("PluginId_Input");
		String Enable_Status = Excel_data.get("Enable_Status");
		String CRO_Module_Name = Excel_data.get("CRO_Module_Name");

		Extent_Start(testCaseName, test, test1);
	
		Step_Start(1, "Open the browser", test, test1);
		Step_Start(2, "Enter the test URL", test, test1);
		navigateUrl(driver, url);
		Step_End(1, "Open the browser", test, test1);
		Step_End(2, "Enter the test URL", test, test1);

		Step_Start(3, "Enter valid Username & Password in respective text fields", test, test1);
		Step_Start(4, "Click on Login Button", test, test1);
		LRP_Login(driver, Username, Password);
		
		Step_End(3, "Enter valid Username & Password in respective text fields", test, test1);
		Step_End(4, "Click on Login Button", test, test1);
		
    	Step_Start(6, "Enter Agency code in code search field & Click on Select button", test, test1);

		SwitchProfile(driver, agencyUser);
		Step_End(5, "Click on Switch profile button in home page", test, test1);
		Step_End(6, "Enter Agency code in code search field & Click on Select button", test, test1);
		
		
    	Step_Start(7, "Enter \"plugin configuration\" in 'Search Module' Search search box & Select the module.", test, test1);
    	Step_Start(8, "Search CUN plugin and double click the record.", test, test1);
    	Step_Start(9, "Click edit bitton", test, test1);
    	Step_Start(10, "Change status to false and click save button", test, test1);
    	Step_Start(11, "Updated successfully message shown and click ok button", test, test1);
    	
    	
    	
		setPluginConfig(driver, Plugin_config_Module_Name, Plugin_column_Header, Plugin_Condition, PluginId_Input, Enable_Status);
		moduleNavigate(driver, CRO_Module_Name);
		
    	Step_End(7, "Enter \"plugin configuration\" in 'Search Module' Search search box & Select the module.", test, test1);
    	Step_End(8, "Search CUN plugin and double click the record.", test, test1);
    	Step_End(9, "Click edit bitton", test, test1);
    	Step_End(10, "Change status to false and click save button", test, test1);
    	Step_End(11, "Updated successfully message shown and click ok button", test, test1);
    	

    	Step_Start(12, "Open container release order module", test, test1);
    	Step_Start(13, "Check the By Container No, Type, UNNO, DG Ref No, IMDGClass and NOR options are enabled", test, test1);


		waitForElement(driver, By_Container_No_CRO);
		if(isdisplayed(driver, By_Container_No_CRO)) {
			System.out.println("Expected result is : The By Container number radio button should be displayed  ||  Actual result is : The By Container number radio button is displayed ");
			Extent_pass_New(driver,"Expected result is : The By Container number radio button should be displayed  ||  Actual result is : The By Container number radio button is displayed " , test, test1);
		}

		else
		{
			System.out.println("Expected result is : The By Container number radio button should be displayed  ||  Actual result is : The By Container number radio button is not displayed ");
			Extent_fail(driver, "Expected result is : The By Container number radio button should be displayed  ||  Actual result is : The By Container number radio button is not displayed ", test, test1);
		}


		waitForElement(driver, Type_CRO);

		if(isdisplayed(driver, Type_CRO)) {
			System.out.println("Expected result is : The Type text field should be displayed  ||  Actual result is : The Type text field is displayed ");
			Extent_pass_New(driver,"Expected result is : The Type text field should be displayed  ||  Actual result is : The Type text field is displayed " , test, test1);
		}

		else
		{
			System.out.println("Expected result is : The Type text field should be displayed  ||  Actual result is : The Type text field is not displayed ");
			Extent_fail(driver, "Expected result is : The Type text field should be displayed  ||  Actual result is : The Type text field is not displayed ", test, test1);
		}

		
		waitForElement(driver, DG_Ref_No_CRO);

		if(isdisplayed(driver, DG_Ref_No_CRO)) {
			System.out.println("Expected result is : The DG Ref No field should be displayed  ||  Actual result is : The DG Ref No field is displayed ");
			Extent_pass_New(driver,"Expected result is : The DG Ref No field should be displayed  ||  Actual result is : The DG Ref No field is displayed " , test, test1);
		}

		else
		{
			System.out.println("Expected result is : The DG Ref No field should be displayed  ||  Actual result is : The DG Ref No field is not displayed ");
			Extent_fail(driver, "Expected result is : The DG Ref No field should be displayed  ||  Actual result is : The DG Ref No field is not displayed ", test, test1);
		}

		waitForElement(driver, IMDGClass_CRO);

		if(isdisplayed(driver, IMDGClass_CRO)) {
			System.out.println("Expected result is : The IMDGClass field should be displayed  ||  Actual result is : The IMDGClass field is displayed ");
			Extent_pass_New(driver,"Expected result is : The IMDGClass field should be displayed  ||  Actual result is : The IMDGClass field is displayed " , test, test1);
		}

		else
		{
			System.out.println("Expected result is : The IMDGClass field should be displayed  ||  Actual result is : The IMDGClass field is not displayed ");
			Extent_fail(driver, "Expected result is : The IMDGClass field should be displayed  ||  Actual result is : The IMDGClass field is not displayed ", test, test1);
		}



		waitForElement(driver, NOR_CRO);

		if(isdisplayed(driver, NOR_CRO)) {
			System.out.println("Expected result is : The NOR Checkbox field should be displayed  ||  Actual result is : The NOR Checkbox field is displayed ");
			Extent_pass_New(driver,"Expected result is : The NOR Checkbox field should be displayed  ||  Actual result is : The NOR Checkbox field is displayed " , test, test1);
		}

		else
		{
			System.out.println("Expected result is : The NOR Checkbox field should be displayed  ||  Actual result is : The NOR Checkbox field is not displayed ");
			Extent_fail(driver, "Expected result is : The NOR Checkbox field should be displayed  ||  Actual result is : The NOR Checkbox field is not displayed ", test, test1);
		}


    	Step_End(12, "Open container release order module", test, test1);
    	Step_End(13, "Check the By Container No, Type, UNNO, DG Ref No, IMDGClass and NOR options are enabled", test, test1);

		Extent_completed(testCaseName, test, test1);





	}
}