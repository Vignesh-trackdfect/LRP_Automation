package LRP_Arrival_Notice_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_009 extends Keywords{
	public void Arrival_Notice_TS_009(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testCaseName = "TC_Arrival_Notice_TS_009";
		
		
		


		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String AgencyUser =Excel_data.get("AgencyUser");
		String moduleImportDoc = Excel_data.get("moduleImportDoc");
		String BL_Condition = Excel_data.get("BL_Condition");
		String Search_Number = Excel_data.get("Search_Number");
		String BL_Num = Excel_data.get("BL_Num");
		String checkBoxStatus = Excel_data.get("AN_CheckBoxStatus");
		String pinkColorCode = Excel_data.get("pinkColorCode");
	

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
		List<String> bl_Nos = splitAndExpand(BL_Num);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, BL_Condition, Search_Number, bl_Nos.get(0), "", "", "", "");
	
		Step_End(3, "Click select button ", test, test1);
		waitForElement(driver, importDoc_RemarksTab );
		click(driver, importDoc_RemarksTab );
		waitForElement(driver, ID_Arrival_Notice_CheckBox);
		String actualStatus=getAttribute(driver, ID_Arrival_Notice_CheckBox, "class");
		if(actualStatus.contains(checkBoxStatus)) {
			
			Extent_pass(driver, "Matched || Expected Result is : Import Documentation Arrival Notice Checkbox should be selected || Actual Result is : Import Documentation Arrival Notice Checkbox is selected", test, test1);
			System.out.println("Matched || Expected Result is : Import Documentation Arrival Notice Checkbox should be selected|| Actual Result is :Import Documentation Arrival Notice Checkbox is selected");
		}else {
			System.out.println("Not Matched || Expected Result is : Import Documentation Arrival Notice Checkbox should be selected || Actual Result is : Import Documentation Arrival Notice Checkbox is not selected");
			Extent_fail(driver,"Not Matched || Expected Result is :Import Documentation Arrival Notice Checkbox should be selected|| Actual Result is : Import Documentation Arrival Notice Checkbox is not selected", test, test1);
		}
		
		
		Step_Start(4, "click arrival notice button", test, test1);
		waitForElement(driver, AN_Arrival_notice_button);
		click(driver, AN_Arrival_notice_button);
		Step_End(4, "click arrival notice button", test, test1);
		Step_Start(5, "Verify the System displayed the saved Arrival Notices in pink colour", test, test1);
		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		click(driver, condition_Filter_AN);

		for(int i=0;i<bl_Nos.size();i++) {
			String bl_Number=bl_Nos.get(i);

			clear(driver, blNumber_Filter_AN);
			sendKeys(driver, blNumber_Filter_AN,bl_Number );
			waitForElement(driver, arrivalNotice_Number);
			String generated_AN_Number=getText(driver, arrivalNotice_Number);
			if(!generated_AN_Number.equals("")) {
				Extent_pass(driver, "Generated Arrival Notice Number : "+generated_AN_Number, test, test1);
				System.out.println("Generated Arrival Notice Number : "+generated_AN_Number);
		
			}

			waitForElement(driver, arrivalNotice_Number_Row);
			String actualColour=getTextBackgroundColor(driver, arrivalNotice_Number_Row);
			String actualColour1=getColorName(actualColour);
		

			if(actualColour1.equalsIgnoreCase(pinkColorCode)) {
				Extent_pass(driver, "Matched || The background color should be shown || The Expected  color shown is : "+pinkColorCode+" || The Actual Row Color shown is : "+actualColour1, test, test1);
				System.out.println("Matched || The background color should be shown  || The Expected color shown is : "+pinkColorCode+" || The Actual Row Color shown is : "+actualColour1);
			}else {
				System.out.println("Not Matched || The background color should be shown || The Expected color shown is : "+pinkColorCode+" || The Actual Row Color shown is : "+actualColour1);
				Extent_fail(driver,"Not Matched || The background color should be shown  || The Expected color shown is : "+pinkColorCode+" || The Actual Row Color shown is : "+actualColour1, test, test1);
			}
		}
		Step_End(5, "Verify the System displayed the saved Arrival Notices in pink colour", test, test1);
		Extent_completed(testCaseName, test, test1);

	}
}	
