package LRP_Manifest_Correction_Notes_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TC_Manifest_Correction_Notes_SC10 extends Keywords {
	public void Manifest_Correction_Notes_SC10(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Manifest_Correction_Notes_SC10";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String Manifest_Module = Excel_data.get("Manifest_Module");
		String Print_Option_Select = Excel_data.get("Print_Option_Select");
		String Select_Search_Type_MCN = Excel_data.get("Select_Search_Type_MCN");
		String DropdownCondition = Excel_data.get("DropdownCondition");
		String BL_Number = Excel_data.get("BL_Number");
		String bl_Status = Excel_data.get("bl_Status");
		String Extpected_PDF = Excel_data.get("Extpected_PDF");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch to agency", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to agency", test, test1);
		Step_Start(2, "Open the Manifest Correction Notes module", test, test1);
		moduleNavigate(driver, Manifest_Module);
		Step_End(2, "Open the Manifest Correction Notes module", test, test1);
		Step_Start(3, "Retrieve the BL No. using Local search & save the MCN in Approved status", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		globalValueSearchWindow1(driver,DropdownCondition,Select_Search_Type_MCN,BL_Number,"","","","");
		waitForElement(driver, BL_status);
		sendKeys(driver, BL_status, bl_Status);
		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
		Step_End(3, "Retrieve the BL No. using Local search & save the MCN in Approved status", test, test1);
		Step_Start(4, "Click the print button in master tab.", test, test1);
		waitForElement(driver, Print_Button_toolBar);
		click(driver, Print_Button_toolBar);
		Step_End(4, "Click the print button in master tab.", test, test1);
		Step_Start(5, "Select the BL draft radio button", test, test1);
		String Select_Print_Option = String.format(Print_Option_MCN,Print_Option_Select);
		waitForElement(driver, Select_Print_Option);
		checkBox(driver, Select_Print_Option, "Yes");
		Step_End(5, "Select the BL draft radio button", test, test1);
		Step_Start(6, "Click the print button", test, test1);
		click(driver, MCN_Print);
		Step_End(6, "Click the print button", test, test1);
		Step_Start(7, "System will load the data in print", test, test1);
		switchToFrame(driver, jsp_Iframe);	
		scrollToElement(driver, pdf_Non_Negotiable);
		verticalScroll(driver, pdf_Scroll, -100);
		waitForElement(driver, pdf_Non_Negotiable);
		String Actual_Pdf_Text = getText(driver, pdf_Non_Negotiable);
		if(Extpected_PDF.trim().equals(Actual_Pdf_Text.trim())) {
			System.out.println("Matched || The Expected PDF Text value is : "+Extpected_PDF.trim()+" The Actual PDF Text value is : "+Actual_Pdf_Text.trim());
			Extent_pass_New(driver, "Matched || The Expected PDF Text value is : "+Extpected_PDF.trim()+" The Actual PDF Text value is : "+Actual_Pdf_Text.trim(), test, test1);
		}else {
			System.out.println("Not Matched || The Expected PDF Text value is : "+Extpected_PDF.trim()+" The Actual PDF Text value is : "+Actual_Pdf_Text.trim());
			Extent_fail(driver, "Not Matched || The Expected PDF Text value is : "+Extpected_PDF.trim()+" The Actual PDF Text value is : "+Actual_Pdf_Text.trim(), test, test1);
		}
		Step_End(7, "System will load the data in print", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}