package LRP_EMS_EDI_Code_Mapping_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_EDI_Code_Mapping_SC11 extends Keywords {
	public void EDI_Code_Mapping_SC11(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_Excel_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_EDI_Code_Mapping_SC11";
		// Get data from excel sheet

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String moduleName = Excel_data.get("ModuleName");
		String Partner_ID = Excel_data.get("Partner_ID_Input");
		String Partner_ID_Header = Excel_data.get("Partner_ID_Header");
		String Filter_Condition = Excel_data.get("Filter_Condition");
		String EDI_ID_Header = Excel_data.get("EDI_ID_Header");
		String EDI_ID = Excel_data.get("EDI_ID");
		String ComdtyCode_Header = Excel_data.get("ComdtyCode_Header");
		String ComdtyCode = Excel_data.get("ComdtyCode");
		String EDI_Commodity_Code_Input = Excel_data.get("EDI_Commodity_Code_Input");
		String EDI_Code_Mapping_Popup = Excel_data.get("EDI_Code_Mapping_Popup");

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		verifyMainMenu(driver);

		moduleNavigate(driver, moduleName);

		newButton(driver);

		Step_Start(1, "Click the Commodity_Code_tab", test, test1);

		waitForElement(driver, Commodity_Code_Tab_ECM);
		click(driver, Commodity_Code_Tab_ECM);

		Step_End(1, "Click the Commodity_Code_tab", test, test1);
		Step_Start(2, "Select the partner id ", test, test1);

		waitForElement(driver, Partner_ID_Search);
		click(driver, Partner_ID_Search);

		twoColumnSearchWindow(driver, Partner_ID_Header, Filter_Condition, Partner_ID);

		Step_End(2, "Select the partner id ", test, test1);

		Step_Start(3, "Select the EDI ID ", test, test1);

		waitForElement(driver, EDI_ID_Search);
		click(driver, EDI_ID_Search);

		twoColumnSearchWindow(driver, EDI_ID_Header, Filter_Condition, EDI_ID);
		Step_End(3, "Select the EDI ID ", test, test1);
		Step_Start(4, "Select the any data in Commodity_Code_Search_ECM ", test, test1);

		waitForElement(driver, Commodity_Code_Search_ECM);
		click(driver, Commodity_Code_Search_ECM);

		twoColumnSearchWindow(driver, ComdtyCode_Header, Filter_Condition, ComdtyCode);

		Step_End(4, "Select the any data in Commodity_Code_Search_ECM ", test, test1);

		Step_Start(5, "Enter any data in EDI_Commodity_Code_Input_ECM filed  ", test, test1);

		waitForElement(driver, EDI_Commodity_Code_Input_ECM);
		safeclick(driver, EDI_Commodity_Code_Input_ECM);
		sendKeys(driver, EDI_Commodity_Code_Input_ECM, EDI_Commodity_Code_Input);

		Step_End(5, "Enter any data in EDI_Commodity_Code_Input_ECM filed  ", test, test1);
		Step_Start(6, "Click save button ", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(6, "Click save button ", test, test1);

		Step_Start(7, "Notification popup \"Edi Code Mapping Saved Successfully\" Should able to show ", test, test1);

		waitForPopup(driver, Popup_Message, EDI_Code_Mapping_Popup);
		String Applied_Popup = getText(driver, Popup_Message);
		System.out.println(Applied_Popup);
		if (Applied_Popup.equals(EDI_Code_Mapping_Popup)) {
			System.out.println("Matched || " + " Expected saved popup : " + EDI_Code_Mapping_Popup
					+ " || Actual saved popup : " + Applied_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected saved popup: " + EDI_Code_Mapping_Popup
					+ " || Actual saved popup : " + Applied_Popup, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected saved poup : " + EDI_Code_Mapping_Popup
					+ " || Actual saved poup : " + Applied_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected saved poup : " + EDI_Code_Mapping_Popup
					+ " || Actual saved poup : " + Applied_Popup, test, test1);

		}
		waitForElement(driver, Filter_Button_CommodityCode_ECM);
		click(driver, Filter_Button_CommodityCode_ECM);

		waitForElement(driver, ParterID_Field_ECM);
		safeclick(driver, ParterID_Field_ECM);
		sendKeys(driver, ParterID_Field_ECM, Partner_ID);

		waitForElement(driver, EDI_ID_Field_ECM);
		safeclick(driver, EDI_ID_Field_ECM);
		sendKeys(driver, EDI_ID_Field_ECM, EDI_ID);

		waitForElement(driver, CommodityCode_Field_ECM);
		safeclick(driver, CommodityCode_Field_ECM);
		sendKeys(driver, CommodityCode_Field_ECM, ComdtyCode);

		waitForElement(driver, EDI_CommodityCode_Field_ECM);
		safeclick(driver, EDI_CommodityCode_Field_ECM);
		sendKeys(driver, EDI_CommodityCode_Field_ECM, EDI_Commodity_Code_Input);

		waitForElement(driver, EDI_Code_Mapping_Partner_Id_Value_ECM);
		String Act_partner_id = getText(driver, EDI_Code_Mapping_Partner_Id_Value_ECM);

		if (Act_partner_id.equals(Partner_ID)) {
			System.out.println("Matched || " + " Expected Partner Id verify : " + Partner_ID
					+ " || Actual Partner Id verify : " + Act_partner_id);
			Extent_pass_New(driver, "Matched || " + " Expected Partner Id verify: " + Partner_ID
					+ " || Actual Partner Id verify is : " + Act_partner_id, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Partner Id verify : " + Partner_ID
					+ " || Actual Expected Partner Id verify : " + Act_partner_id);
			Extent_fail(driver, "Not Matched || " + " Expected Partner Id verify: " + Partner_ID
					+ " || Actual Expected Partner Id verify: " + Act_partner_id, test, test1);
		}

		waitForElement(driver, EDI_Code_Mapping_EDI_ID_Value);
		String Act_EDI_ID = getText(driver, EDI_Code_Mapping_EDI_ID_Value);

		if (Act_EDI_ID.equals(EDI_ID)) {
			System.out
					.println("Matched || " + " Expected EDI ID  : " + EDI_ID + " || Actual EDI ID  : : " + Act_EDI_ID);
			Extent_pass_New(driver,
					"Matched || " + " Expected EDI ID : " + EDI_ID + " || Actual EDI ID  : is : " + Act_EDI_ID, test,
					test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI ID  : : " + EDI_ID
					+ " || Actual Expected EDI ID  : : " + Act_EDI_ID);
			Extent_fail(driver, "Not Matched || " + " Expected EDI ID  :: " + EDI_ID + " || Actual Expected EDI ID  :: "
					+ Act_EDI_ID, test, test1);
		}

		waitForElement(driver, CommodityCode_Field_Value_ECM);
		String Act_ComdtyCode = getText(driver, CommodityCode_Field_Value_ECM);

		if (Act_ComdtyCode.equals(ComdtyCode)) {
			System.out.println("Matched || " + " Expected commodityCode  : " + ComdtyCode + " || Actual ComdtyCode  : "
					+ Act_ComdtyCode);
			Extent_pass_New(driver, "Matched || " + " Expected commodityCode : " + ComdtyCode
					+ " || Actual ComdtyCode  is : " + Act_ComdtyCode, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected commodityCode  : " + ComdtyCode
					+ " || Actual commodityCode  : " + Act_ComdtyCode);
			Extent_fail(driver, "Not Matched || " + " Expected commodityCode : " + ComdtyCode
					+ " || Actual commodityCode : " + Act_ComdtyCode, test, test1);
		}

		waitForElement(driver, EDI_CommodityCode_Field_Value_ECM);
		String Act_EDI_Commodity_Code_Input1 = getText(driver, EDI_CommodityCode_Field_Value_ECM);

		if (Act_EDI_Commodity_Code_Input1.equals(EDI_Commodity_Code_Input)) {
			System.out.println("Matched || " + " Expected EDI_Commodity_Code_ : " + EDI_Commodity_Code_Input
					+ " || Actual EDI_Commodity_Code_ : " + Act_EDI_Commodity_Code_Input1);
			Extent_pass_New(driver, "Matched || " + " Expected EDI_Commodity_Code : " + EDI_Commodity_Code_Input
					+ " || Actual EDI_Commodity_Code_  is : " + Act_EDI_Commodity_Code_Input1, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected EDI_Commodity_Code_  : " + EDI_Commodity_Code_Input
					+ " || Actual Expected EDI_Commodity_Code_ : " + Act_EDI_Commodity_Code_Input1);
			Extent_fail(driver,
					"Not Matched || " + " Expected EDI_Commodity_Code_: " + EDI_Commodity_Code_Input
							+ " || Actual Expected EDI_Commodity_Code_Input_ECM : " + Act_EDI_Commodity_Code_Input1,
					test, test1);
		}

		Step_End(7, "Notification popup \"Edi Code Mapping Saved Successfully\" Should able to show ", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
