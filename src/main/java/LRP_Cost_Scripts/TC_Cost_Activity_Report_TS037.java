package LRP_Cost_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Cost_Activity_Report_TS037 extends Keywords{

	public void  Cost_Activity_Report_TS037(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception{
		
		String tc_Name = "TC_Cost_Activity_Report_TS037";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String AgencyUser = Excel_data.get("AgencyUser");
		
		String CAR_Retrieve_Type = Excel_data.get("CAR_Retrieve_Type");
		String CAR_Retrieve_Condition = Excel_data.get("CAR_Retrieve_Condition");
		String CAR_Number_Retrieve = Excel_data.get("CAR_Number_Retrieve");
		
		String MSC_Headers_Names = Excel_data.get("MSC_Headers_Names");
		
		String Vendor_Invoice_Registration_Module = Excel_data.get("Vendor_Invoice_Registration_Module");
		String Vendor_Code_Filter_Type = Excel_data.get("Vendor_Code_Filter_Type");
		String Vendor_Code_Filter_Condition = Excel_data.get("Vendor_Code_Filter_Condition");
				
		String CAR_Retrieve_Type2 = Excel_data.get("CAR_Retrieve_Type2");
		String CAR_Number_Retrieve_Value2 = Excel_data.get("CAR_Number_Retrieve_Value2");
		String CAR_Retrieve_Type3 = Excel_data.get("CAR_Retrieve_Type3");
		String CAR_Number_Retrieve_Value3 = Excel_data.get("CAR_Number_Retrieve_Value3");
		
		Extent_Start(tc_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		verifyMainMenu(driver);
		Step_Start(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.", test, test1);
		
		Step_Start(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as \"Cost Activity Report\" in module search field.", test, test1);
		
		Step_Start(3, "Click on the global search option which is available in the tool bar", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver,SearchButton_Toolbar);
		Step_End(3, "Click on the global search option which is available in the tool bar", test, test1);
		
		Step_Start(4, "Check whether it opens a new search window. ", test, test1);
		Step_Start(5, "Enter the required CAR No. in the CAR No search field", test, test1);
		Step_Start(6, "Then click on the search button", test, test1);
		Step_Start(7, "System will show the CAR No. and Click on the select button", test, test1);

		globalValueSearchWindow(driver,CAR_Retrieve_Condition,CAR_Retrieve_Type,CAR_Number_Retrieve,CAR_Retrieve_Type2,CAR_Number_Retrieve_Value2,CAR_Retrieve_Type3,CAR_Number_Retrieve_Value3);

		Step_End(7, "System will show the CAR No. and Click on the select button", test, test1);
		Step_End(6, "Then click on the search button", test, test1);
		Step_End(5, "Enter the required CAR No. in the CAR No search field", test, test1);
		Step_End(4, "Check whether it opens a new search window. ", test, test1);

		Step_Start(8, "System will retrieve the CAR. ", test, test1);
		waitForElement(driver, CAR_Number_Input_CAR);
		Step_End(8, "System will retrieve the CAR. ", test, test1);
		
		Step_Start(9, "If the activities are invoiced, the activities will be shown in yellow colour. Then go to vendor invoice registration and click on the global search option. Select the vendor invoice number option.Then enter the required value and click on the search option.Then click on the select option. Ensure that the invoiced quantity,invoice amount in expense report matches with the invoice in the vendor invoice registration ", test, test1);
		waitForElement(driver, MSC_Column_Filt_CAR);
		
		click(driver, MSC_Column_Filt_CAR);
		waitForElement(driver, MSC_Filter_input_CAR);
		jsClick(driver, MSC_SelectAll_Checkbox_CAR);
		
		List<String> ExpensiveTable_Headers=splitAndExpand(MSC_Headers_Names);
		for(String FilterHeader : ExpensiveTable_Headers) {
			waitForElement(driver, MSC_Filter_input_CAR);
			clear(driver, MSC_Filter_input_CAR);
			waitForElement(driver, MSC_Filter_input_CAR);
			sendKeys(driver, MSC_Filter_input_CAR,FilterHeader);
		
			String checkbox=String.format(Select_Column_MSC_CAR,FilterHeader);
			waitForDisplay(driver, checkbox);
			jsClick(driver, checkbox);
		}
		
		jsClick(driver, MSC_Column_Filt_CAR);
	
		waitForElement(driver, MSC_Table_CAR);
		List<Map<String, String>> MSC_TableData = extractTableDataByColumnWithoutScroll(driver, MSC_Table_CAR);
		System.out.println("MSC_TableData : "+MSC_TableData);
		
		List<String> Invoice_NumberColumns=getValuesByHeader(MSC_TableData, "Invoice No");
		List<String> Invoice_AmountColumns=getValuesByHeader(MSC_TableData, "Invoice Amount");
		List<String> Invoice_VendorCodeColumns=getValuesByHeader(MSC_TableData, "Vendor Code");

		Map<String,Double> InVoice_Amounts=new HashMap<String, Double>();
		Map<String,String> InVoice_VendorCode=new HashMap<String, String>();
		
		for(int i=0;i<Invoice_NumberColumns.size();i++) {
			String invoice_Num=Invoice_NumberColumns.get(i);
			double amount_=0;
			if(!invoice_Num.equals("")) {
				String inv_Amount=Invoice_AmountColumns.get(i);
				String ven_Code=Invoice_VendorCodeColumns.get(i);
				String [] AmountValueFull=splitAmount(inv_Amount,"=");
				String Invoice_Amount_MSC=AmountValueFull[1];
				double amount_Num=Double.parseDouble(Invoice_Amount_MSC);
				if(InVoice_Amounts.containsKey(invoice_Num)) {
					amount_=InVoice_Amounts.get(invoice_Num);
				}
				amount_=amount_+amount_Num;
				InVoice_Amounts.put(invoice_Num, amount_);
				InVoice_VendorCode.put(invoice_Num, ven_Code);
			}
		}
		
		moduleNavigate(driver, Vendor_Invoice_Registration_Module);

		for (Map.Entry<String, Double> entry : InVoice_Amounts.entrySet()) {
			String Inv_Num = entry.getKey();
			Double Inv_Amount = entry.getValue();
			String VendorCode=InVoice_VendorCode.get(Inv_Num);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver,SearchButton_Toolbar);
			
			globalValueSearchWindow(driver,Vendor_Code_Filter_Condition,Vendor_Code_Filter_Type,Inv_Num,"","","","");

			waitForElement(driver, Vendor_Invoice_input_VIR);
			String Invoice_Amount_VIR=getAttribute(driver, Vendor_Invoice_input_VIR, "value");
			double Amount_VC=getNumberValue(Invoice_Amount_VIR);
			
			if(Inv_Amount==Amount_VC) {
				System.out.println("Invoice Amount Matched ||  Expected Amount from CAR : "+Inv_Amount+" ||  Actual Amount in Vendor Contract : "+Amount_VC);
				Extent_pass_New(driver, "Invoice Amount Matched ||  Expected Amount from CAR : "+Inv_Amount+" ||  Actual Amount in Vendor Contract : "+Amount_VC, test, test1);
			}else {
				System.out.println("Invoice Amount Not Matched ||  Expected Amount from CAR : "+Inv_Amount+" ||  Actual Amount in Vendor Contract : "+Amount_VC);
				Extent_fail(driver, "Invoice Amount Not Matched ||  Expected Amount from CAR : "+Inv_Amount+" ||  Actual Amount in Vendor Contract : "+Amount_VC, test, test1);
			}
			
			waitForElement(driver, Vendor_Code_Input_VIR);
			String Vendor_Code=getAttribute(driver, Vendor_Code_Input_VIR, "value");
			
			if(VendorCode.equals(Vendor_Code)) {
				System.out.println("Vendor Code Matched ||  Expected from CAR : "+VendorCode+" ||  Actual in Vendor Contract: "+Vendor_Code);
				Extent_pass_New(driver, "Vendor Code Matched ||  Expected from CAR: "+VendorCode+" ||  Actual in Vendor Contract: "+Vendor_Code, test, test1);
			}else {
				System.out.println("Vendor Code Not Matched ||  Expected from CAR: "+VendorCode+" ||  Actual in Vendor Contract: "+Vendor_Code);
				Extent_fail(driver, "Vendor Code Not Matched ||  Expected from CAR : "+VendorCode+" ||  Actual in Vendor Contract: "+Vendor_Code, test, test1);
			}
		}
		
		
		Step_End(9, "If the activities are invoiced, the activities will be shown in yellow colour. Then go to vendor invoice registration and click on the global search option. Select the vendor invoice number option.Then enter the required value and click on the search option.Then click on the select option. Ensure that the invoiced quantity,invoice amount in expense report matches with the invoice in the vendor invoice registration ", test, test1);

		Extent_completed(tc_Name, test, test1);		
		
	}
	
}
