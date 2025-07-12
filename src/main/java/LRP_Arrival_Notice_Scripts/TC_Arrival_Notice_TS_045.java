package LRP_Arrival_Notice_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_045  extends Keywords{
	
	public void Arrival_Notice_TS_045(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
	String testcase_Name="TC_Arrival_Notice_TS_045";
	
	
			


	String Username = Excel_data.get("Username");
	String Password = Excel_data.get("Password");
	String AgencyUser = Excel_data.get("AgencyUser");
	String GlobalConfigurationModule = Excel_data.get("GlobalConfigurationModule");
	String GlobalID = Excel_data.get("GlobalID");
	String GlobalValue = Excel_data.get("GlobalValue");
	String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
	String BL_Condition = Excel_data.get("BL_Condition");
	String Search_Number = Excel_data.get("Search_Number");
	String BL_Num = Excel_data.get("BL_Num");
    String BL_Number_box = Excel_data.get("BL_Number_box");
    String Headers = Excel_data.get("Headers");
	String jsp_Iframe = Excel_data.get("jsp_Iframe");
	
	

	navigateUrl(driver, url);
	Extent_Start(testcase_Name, test, test1);

	LRP_Login(driver, Username, Password);

	SwitchProfile(driver, AgencyUser);

	Step_Start(1, "Switch to agency", test, test1);
	setGlobalConfiguration(driver, GlobalConfigurationModule, GlobalID, GlobalValue);


	

	
	
	Step_Start(2, "Open arrival notice screen", test, test1);

	moduleNavigate(driver, ImportDocumentationModule);

	Step_End(2, "Open arrival notice screen", test, test1);
	Step_Start(3, "Click search , paste the Bl number and fectch the record", test, test1);
waitForElement(driver, SearchButton_Toolbar);
	click(driver, SearchButton_Toolbar);
	
	globalValueSearchWindow(driver, BL_Condition, Search_Number, BL_Num, "","", "","");
	
	
	
	
	
List<String> datas = splitAndExpand(BL_Number_box);
	
	for(String data :datas) {
		String select_checkbox1 =  String.format(Arrival_Notice_Locators.bl_select_box,data); 
		waitForElement(driver, select_checkbox1);
		click(driver, select_checkbox1);
	}
	
	
	reArrangeAG_GridColumnsNew(driver,AN_coloum_click, Headers);
	
	waitForElement(driver, consinee_name_app);
	String consinee1 = getText(driver, consinee_name_app);
	System.out.println(consinee1);
	
	String address1 = getText(driver, Adress1_app);
	System.out.println(address1);
	
	Step_End(3, "Click search , paste the Bl number and fectch the record", test, test1);
	Step_Start(4, "Select the Bl and auction notice button", test, test1);
	waitForElement(driver, auction_Notice_Button_AN);
	click(driver, auction_Notice_Button_AN);
	Step_End(4, "Select the Bl and auction notice button", test, test1);
	Step_Start(5, "Ensure print page should be opened and customer details (Name and address 1) matched with screen.", test, test1);
	driver.switchTo().frame(jsp_Iframe);
	waitForVisibilty(driver, consinee_name);
	String consinee2 = getText(driver, consinee_name);
	System.out.println(consinee2);
	String add1 = getText(driver, Adress1);
	System.out.println(add1);
	
	
	if (consinee1.equals(consinee2)) {
		System.out.println(
				"Matched || Expected value was [Consignee Name taken from Arrival notice]: " + consinee1 + " || Actual value was[Consignee Name taken from Print] : " + consinee2);
		Extent_pass(driver,
				"Matched || Expected value was[Consignee Name taken from Arrival notice] : " + consinee1 + " || Actual value was [Consignee Name taken from Print]: " + consinee2, test,
				test1);

	} else {
		System.out.println(
				"NotMatched || Expected value was[Consignee Name taken from Arrival notice] : " + consinee1 + " || Actual value was [Consignee Name taken from Print]: " + consinee2);
		Extent_fail(driver,
				"NotMatched || Expected value was[Consignee Name taken from Arrival notice] : " + consinee1 + " || Actual value was[Consignee Name taken from Print] : " + consinee2,
				test, test1);
	

	}
	
	
	
	if (address1.equals(add1)) {
		System.out.println(
				"Matched || Expected value was[Consignee Name taken from Arrival notice] : " + address1 + " || Actual value was[Consignee Name taken from Print] : " + add1);
		Extent_pass(driver,
				"Matched || Expected value was[Consignee Name taken from Arrival notice] : " + address1 + " || Actual value was[Consignee Name taken from Print] : " + add1, test,
				test1);

	} else {
		System.out.println(
				"NotMatched || Expected value was[Consignee Name taken from Arrival notice] : " + address1 + " || Actual value was[Consignee Name taken from Print] : " + add1);
		Extent_fail(driver,
				"NotMatched || Expected value was[Consignee Name taken from Arrival notice] : " + address1 + " || Actual value was[Consignee Name taken from Print] : " + add1,
				test, test1);
	

	}
	Step_End(5, "Ensure print page should be opened and customer details (Name and address 1) matched with screen.", test, test1);
	Extent_completed(testcase_Name, test, test1);
	
	}
}
