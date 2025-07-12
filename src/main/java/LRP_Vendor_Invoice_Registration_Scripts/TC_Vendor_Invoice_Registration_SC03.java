package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Vendor_Invoice_Registration_SC03 extends Keywords {

	public void Vendor_Invoice_Registration_SC03(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testcase_Name = "TC_Vendor_Invoice_Registration_SC03";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Vendor_Invoice_Registration_Module = Excel_data.get("Vendor_Invoice_Registration_Module");
		String agency_User = Excel_data.get("agency_User");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Condition = Excel_data.get("Condition");
		String Vendor_Code_Search_VIR = Excel_data.get("Vendor_Code_Search_VIR");
		String Module_Name = Excel_data.get("Module_Name");
		String Agency_code_Header = Excel_data.get("Agency_code_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Port_code_Value = Excel_data.get("Port_code_Value");
		String Port_Code_Header = Excel_data.get("Port_Code_Header");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		Step_Start(1, "Swith to the Required agency", test, test1);
		SwitchProfile(driver, agency_User);
		Step_End(1, "Swith to the Required agency", test, test1);

		Step_Start(2, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);
		moduleNavigate(driver, Vendor_Invoice_Registration_Module);
		Step_End(2, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);

		Step_Start(3, "Click the Vendor code search ", test, test1);
		waitForElement(driver, Vedor_Code_Search_Button_VIR);
		click(driver, Vedor_Code_Search_Button_VIR);
		Step_End(3, "Click the Vendor code search ", test, test1);

		Step_Start(4, "Select the required vendor", test, test1);
		globalValueSearchWindow(driver, Condition, Vendor_Code_Search_VIR, Vendor_Code, "", "", "", "");
		Step_End(4, "Select the required vendor", test, test1);

		waitForElement(driver, location_code_VIR);
		String Location_code = getAttribute(driver, location_code_VIR, "value");
		Step_Start(5, "Click the Disburse currency dropdown", test, test1);
		waitForElement(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
		click(driver, Vendorinvoice_Disbusse_currency_dd_VIR);
		Step_End(5, "Click the Disburse currency dropdown", test, test1);

		waitForElement(driver, disburse_Currency_Values);
		List<WebElement> disburse_Data = listOfElements(driver, disburse_Currency_Values);

		List<String> disburse_dropdownValues = new ArrayList<>();

		for (WebElement option : disburse_Data) {
			String disburse_Value_VIR = getText1(driver, option).trim();
			if (!disburse_Value_VIR.isEmpty()) {
				disburse_dropdownValues.add(disburse_Value_VIR);
			}
		}
		System.out.println("Currency value in Vendor Invoice Registration Module " + disburse_dropdownValues);

		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);

		moduleNavigate(driver, Module_Name);

		waitForElement(driver, agency_Search_Button_VIDC);
		click(driver, agency_Search_Button_VIDC);
		twoColumnSearchWindow(driver, Agency_code_Header, Condition_Filter, Location_code);

		waitForElement(driver, location_Code_Plus_Button_VIDC);
		click(driver, location_Code_Plus_Button_VIDC);
		twoColumnSearchWindow(driver, Port_Code_Header, Condition_Filter, Port_code_Value);

		waitForElement(driver, agency_code_TF_VIDC);
		sendKeys(driver, agency_code_TF_VIDC, Location_code);

		waitForElement(driver, VIDC_Table_Header);
		List<Map<String, String>> VICDC_Table_Data = getTableData(driver, VIDC_Table_Header, VIDC_Table_Row);
		List<String> CurrencyValues = getValuesByHeader(VICDC_Table_Data, "Currency");
		System.out.println(CurrencyValues);

		List<String> Currency_Value_VM = new ArrayList<>();

		for (String currency : CurrencyValues) {
			Currency_Value_VM.addAll(Arrays.asList(currency.split("~")));
		}

		System.out.println("currency values in Vendor Invoice Disbursement Currency Module: " + Currency_Value_VM);
		Step_Start(6, "It shows the Currency based on the Vendor Invoice/Disbursement currency screen", test, test1);

		containsAllValues(disburse_dropdownValues, Currency_Value_VM);
   
		Step_End(6, "It shows the Currency based on the Vendor Invoice/Disbursement currency screen", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
