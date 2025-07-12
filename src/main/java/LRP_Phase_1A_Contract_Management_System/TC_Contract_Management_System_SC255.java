package LRP_Phase_1A_Contract_Management_System;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Contract_Management_System_SC255 extends Keywords{


	public void Contract_Management_System_SC255(WebDriver driver, ExtentTest test,ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Contract_Management_System_SC255";
		
		
		String username=Excel_data.get("username");
		String password=Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Contract_Number = Excel_data.get("Contract_Number");
		String Origin_Filter_Input = Excel_data.get("Origin_Filter_Input");
		String Delivery_Filter_Input = Excel_data.get("Delivery_Filter_Input");
		String Equipment_Type_Filter_Input = Excel_data.get("Equipment_Type_Filter_Input");
		String POL_Filter_Input = Excel_data.get("POL_Filter_Input");
		String POD_Filter_Input = Excel_data.get("POD_Filter_Input");
		String Internal_Commodity_Name_Filter_Input = Excel_data.get("Internal_Commodity_Name_Filter_Input");
		String All_in_Rate_Filter_Input = Excel_data.get("All_in_Rate_Filter_Input");
		String Base_Rate_Filter_Input = Excel_data.get("Base_Rate_Filter_Input");
		String Total_Amount_Filter_Input = Excel_data.get("Total_Amount_Filter_Input");
		String SOC_Filter_input = Excel_data.get("SOC_Filter_input");
		String NOR_Filter_input = Excel_data.get("NOR_Filter_input");
		String Expected_Tab_Name = Excel_data.get("Expected_Tab_Name");



		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		moduleNavigate(driver, Contract_Management_System_Module);
		
		Step_Start(1, "select FMC check box", test, test1);
		Step_Start(2, "select containerized check box", test, test1);
 
		waitForElement(driver, Contract_Management_System_Containerized);
		click(driver, Contract_Management_System_Containerized);
 
		waitForElement(driver, Contract_Management_System_Fmc);
		click(driver, Contract_Management_System_Fmc);
 
		Step_End(1, "select  FMC check box", test, test1);
		Step_End(2, "select containerized check box", test, test1);
		
		Step_Start(3, "Enter the customer name", test, test1);

		waitForElement(driver, Contract_Management_System_CustomerName);
		sendKeys(driver, Contract_Management_System_CustomerName, Customer_code_Value);
		
		String select_code=String.format(Select_CustomerCode_value, Customer_code_Value);
		waitForElement(driver, select_code);
		safeclick(driver, select_code);
		
		waitForElement(driver, Contract_Management_System_Exit);
		click(driver, CMS_More_Option_Btn);
		waitForElement(driver, CMS_Condition_Filter_Btn);
		click(driver, CMS_Condition_Filter_Btn);
		
		waitForElement(driver, CMS_Contract_No_Filter);
		click(driver, CMS_Contract_No_Filter);
		sendKeys(driver, CMS_Contract_No_Filter, Contract_Number);
		
		waitForElement(driver, CMS_ProfileGrid_Record_Count);
		String Act_Total_record = getText(driver, CMS_ProfileGrid_Record_Count);
		int Total_Record= Integer.parseInt(Act_Total_record);
		
		List<WebElement> GridData = listOfElements(driver, PreviousRateRequest_Grid_Row);
		
		int GridData_Count = GridData.size();
		
		System.out.println("Grid Data Count : "+GridData_Count);

		if (Total_Record == GridData_Count) {
			System.out.println("Matched || " + " Expected Total_Record_Count verify : " + GridData_Count
					+ " || Actual Total_Record_Count verify : " + Act_Total_record);
			Extent_pass_New(driver, "Matched || " + " Expected Total_Record_Count verify: " + GridData_Count
					+ " || Actual Total_Record_Count verify is : " + Act_Total_record, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Total_Record_Count verify : " + GridData_Count
					+ " || Actual Expected Total_Record_Count verify : " + Act_Total_record);
			Extent_fail(driver, "Not Matched || " + " Expected Total_Record_Count verify: " + GridData_Count
					+ " || Actual Expected Total_Record_Count verify: " + Act_Total_record, test, test1);
		}
		
		waitForElement(driver, CMS_Origin_Filter);
		click(driver, CMS_Origin_Filter);
		sendKeys(driver, CMS_Origin_Filter, Origin_Filter_Input);
		
		
		waitForElement(driver, CMS_Delivery_Filter);
		click(driver, CMS_Delivery_Filter);
		sendKeys(driver, CMS_Delivery_Filter, Delivery_Filter_Input);
		
		
		waitForElement(driver, CMS_Below_Scroll_Btn);
		click(driver, CMS_Below_Scroll_Btn);
		
		waitForElement(driver, CMS_Equipment_Type_Filter);
		click(driver, CMS_Equipment_Type_Filter);
		sendKeys(driver, CMS_Equipment_Type_Filter, Equipment_Type_Filter_Input);
		
		waitForElement(driver, CMS_POL_Filter);
		click(driver, CMS_POL_Filter);
		sendKeys(driver, CMS_POL_Filter, POL_Filter_Input);
		
		waitForElement(driver, CMS_POD_Filter);
		click(driver, CMS_POD_Filter);
		sendKeys(driver, CMS_POD_Filter, POD_Filter_Input);
		
		waitForElement(driver, CMS_Below_Scroll_Btn);
		horizontalscroll(driver, CMS_Below_Scroll_Btn, 1000);
		
		waitForElement(driver, CMS_Internal_Commodity_Name_Filter);
		click(driver, CMS_Internal_Commodity_Name_Filter);
		sendKeys(driver, CMS_Internal_Commodity_Name_Filter, Internal_Commodity_Name_Filter_Input);
		
		waitForElement(driver, CMS_All_In_rate_filter);
		click(driver, CMS_All_In_rate_filter);
		sendKeys(driver, CMS_All_In_rate_filter, All_in_Rate_Filter_Input);
		
		waitForElement(driver, CMS_Base_Rate_Filter);
		click(driver, CMS_Base_Rate_Filter);
		sendKeys(driver, CMS_Base_Rate_Filter, Base_Rate_Filter_Input);
		
		waitForElement(driver, CMS_Below_Scroll_Btn);
		horizontalscroll(driver, CMS_Below_Scroll_Btn, 1000);
		
		
		waitForElement(driver, CMS_Total_Amount_Filter);
		click(driver, CMS_Total_Amount_Filter);
		sendKeys(driver, CMS_Total_Amount_Filter, Total_Amount_Filter_Input);
		
		waitForElement(driver, CMS_SOC_Filter);
		click(driver, CMS_SOC_Filter);
		sendKeys(driver, CMS_SOC_Filter, SOC_Filter_input);
		
		waitForElement(driver, CMS_NOR_Filter);
		click(driver, CMS_NOR_Filter);
		sendKeys(driver, CMS_NOR_Filter, NOR_Filter_input);
		
		
		waitForElement(driver, CMS_ProfileGrid_Record_Count);
		String Final_Act_Total_record = getText(driver, CMS_ProfileGrid_Record_Count);
		
		String[] values = Final_Act_Total_record.split("of");
		String Final_Value = values[0].trim();
		System.out.println("Final total Count : "+Final_Value);
		int Final_Value_count = Integer.parseInt(Final_Value);
		
		List<WebElement> Final_GridData = listOfElements(driver, PreviousRateRequest_Grid_Row);
		int Final_GridData_Count = Final_GridData.size();
		
		System.out.println("Final Grid Data Count : "+Final_GridData_Count);

		if (Final_Value_count == Final_GridData_Count) {
			System.out.println("Matched || " + " Expected Total_Record_Count verify : " + Final_Value_count
					+ " || Actual Total_Record_Count verify : " + Final_GridData_Count);
			Extent_pass_New(driver, "Matched || " + " Expected Total_Record_Count verify: " + Final_Value_count
					+ " || Actual Total_Record_Count verify is : " + Final_GridData_Count, test, test1);

		} else {
			System.out.println("Not Matched || " + " Expected Total_Record_Count verify : " + Final_Value_count
					+ " || Actual Expected Total_Record_Count verify : " + Final_GridData_Count);
			Extent_fail(driver, "Not Matched || " + " Expected Total_Record_Count verify: " + Final_Value_count
					+ " || Actual Expected Total_Record_Count verify: " + Final_GridData_Count, test, test1);
		}
		
		waitForElement(driver, Contract_Management_System_Exit);
		click(driver, Contract_Management_System_Exit);
		
		
		waitForElement(driver, CMS_Customer_Profile_Btn);
		click(driver, CMS_Customer_Profile_Btn);
		
		waitForElement(driver, CMS_Verify_Tab); 
		String Actual_Tab_Name = getText(driver, CMS_Verify_Tab);
		
		if(Actual_Tab_Name.equals(Expected_Tab_Name)) {
			
			System.out.println("Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name);
			Extent_pass_New(driver, "Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name, test, test1);
			
		}else {
			System.out.println("Not Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name);
			Extent_fail(driver, "Not Matched || Excepted tab name : "+Expected_Tab_Name +" Actual tab name : "+Actual_Tab_Name, test, test1);
		}
		
		Step_End(3, "Enter the customer name", test, test1);

		Extent_completed(testCaseName, test, test1);
		
		
		

	}

}


