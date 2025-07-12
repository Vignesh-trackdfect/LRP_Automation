package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC092 extends Keywords{

	public void Contract_Management_System_SC92(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName = "TC_Contract_Management_System_SC092";
		
		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String Eqp_Type = Excel_data.get("Eqp_Type");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Delivery_Header = Excel_data.get("Delivery_Header");
		String Delivery = Excel_data.get("Delivery");
		String OFR = Excel_data.get("OFR");
		String weight = Excel_data.get("weight");
		String GrWt = Excel_data.get("GrWt");
		String Length = Excel_data.get("Length");
		String Width = Excel_data.get("Width");
		String Height = Excel_data.get("Height");
		String Quantity = Excel_data.get("Quantity");
		String Description = Excel_data.get("Description_value");
		String originmissing_popup = Excel_data.get("originmissing_popup");
		
		Extent_Start(testCaseName, test, test1);
		
		navigateUrl(driver, url);
	
		LRP_Login(driver, username, password);
	
		moduleNavigate(driver, Contract_Management_System_Module);
	
	

		Step_Start(1, "select N-FMC check box", test, test1);
		 
		Step_Start(2, "select Non - containerized check box", test, test1);
 
		waitForElement(driver, Contract_Management_System_Non_Containerized);
		click(driver, Contract_Management_System_Non_Containerized);
 
		waitForElement(driver, Contract_Management_System_NFMC);
		click(driver, Contract_Management_System_NFMC);
 
		Step_End(1, "select N-FMC check box", test, test1);
 
		Step_End(2, "select Non containerized check box", test, test1);
		
		Step_Start(3, "Enter the customer name", test, test1);
		
		waitForElement(driver, Contract_Management_System_CustomerName);
		sendKeys(driver, Contract_Management_System_CustomerName, Customer_code_Value);
	
		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);
	
		waitForDisplay(driver, Contract_Management_System_Commodity);
		if (isdisplayed(driver, Contract_Management_System_Exit)) {
			click(driver, Contract_Management_System_Exit);
		} else {
			System.out.println("customer name System Page is not displayed");
		}
	
		Step_End(3, "Enter the customer name", test, test1);
	
		Step_Start(4, "switch to commodity tab and enter the commodity name and click + button.", test, test1);
	
		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);
	
		waitForElement(driver, Contract_Management_System_Internal_Commodity);
		sendKeys(driver, Contract_Management_System_Internal_Commodity, Internal_Commodity);
	
		String select_Internal_Commmodity = String.format(Contract_Management_System_Commodity_val, Internal_Commodity);
		waitForElement(driver, select_Internal_Commmodity);
		safeclick(driver, select_Internal_Commmodity);
	
		waitForElement(driver, Contract_Management_System_Internal_Commodity_add);
		click(driver, Contract_Management_System_Internal_Commodity_add);
	
		Step_End(4, "switch to commodity tab and enter the commodity name and click + button.", test, test1);
	
		Step_Start(5, "switch to port pair tab", test, test1);
		
		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);
	
 
		waitForElement(driver, Contract_Management_System_RateCalc_Type);
		sendKeys(driver, Contract_Management_System_RateCalc_Type, Eqp_Type);
		
		waitForElement(driver, Contract_Management_System_Delivery);
		click(driver, Contract_Management_System_Delivery);

		twoColumnSearchWindow(driver, Delivery_Header, Search_Condition, Delivery);
		
		waitForElement(driver, Contract_Management_System_OFR);
		sendKeys(driver, Contract_Management_System_OFR, OFR);
		
 
 
		waitForElement(driver, Contract_Management_System_Valied_from);
		//isElementEnabled
		if(IsElementEnabled(driver, Contract_Management_System_Valied_from)) {
			waitForElement(driver, Contract_Management_System_Valied_from);
			click(driver, Contract_Management_System_Valied_from);
			
		}else {
			System.out.println("From data is Display");
		}
		
		waitForElement(driver, Contract_Management_System_Valied_to);
		if(IsElementEnabled(driver, Contract_Management_System_Valied_to)) {
			waitForElement(driver, Contract_Management_System_Valied_to);
			click(driver, Contract_Management_System_Valied_to);
			
		}else {
			System.out.println("To data is Display");
		}
		
		waitForElement(driver, Contract_Management_System_weight);
		clearAndType(driver, Contract_Management_System_weight, weight);
 
		waitForElement(driver, Contract_Management_System_Add_Dimensions);
		click(driver, Contract_Management_System_Add_Dimensions);
 
		waitForElement(driver, Contract_Management_System_Gr_wt);
		clearAndType(driver, Contract_Management_System_Gr_wt, GrWt);
        click(driver,Contract_Management_System_Width);
		
		waitForElement(driver, Contract_Management_System_Length);
		clear(driver, Contract_Management_System_Length);
		sendKeys(driver, Contract_Management_System_Length, Length);
 
		waitForElement(driver, Contract_Management_System_Width);
		clear(driver, Contract_Management_System_Width);
		sendKeys(driver, Contract_Management_System_Width, Width);
 
		waitForElement(driver, Contract_Management_System_Height);
		clear(driver, Contract_Management_System_Height);
		sendKeys(driver, Contract_Management_System_Height, Height);
		click(driver,Contract_Management_System_Width);
 
		waitForElement(driver, Contract_Management_System_Quantity);
		clear(driver, Contract_Management_System_Quantity);
		sendKeys(driver, Contract_Management_System_Quantity, Quantity);
		click(driver,Contract_Management_System_Width);
		
		 waitForElement(driver, Contract_Management_System_Add_Dimensions_add_package_Description);
		 click(driver, Contract_Management_System_Add_Dimensions_add_package_Description);
		
		
		 waitForElement(driver, Contract_Management_System_Add_Dimensions_add_package_Description_input);
		 sendKeys(driver, Contract_Management_System_Add_Dimensions_add_package_Description_input, Description);
		
		 waitForElement(driver, RR_firstRow);
		 click(driver, RR_firstRow);
		
		 waitForElement(driver, Contract_Management_System_Origin_select);
		 click(driver, Contract_Management_System_Origin_select);
		
		 waitForElement(driver, Contract_Management_System_Add_Dimensions_add);
		 click(driver, Contract_Management_System_Add_Dimensions_add);
		
		 waitForDisplay(driver, Contract_Management_System_Add_Dimensions_add_ok);
		 waitForElement(driver, Contract_Management_System_Add_Dimensions_add_ok);
		 click(driver, Contract_Management_System_Add_Dimensions_add_ok);
		
		
		Step_End(5, "switch to port pair tab", test, test1);
		
 
		
		Step_Start(6, "without entering the  origin and clicking on add button", test, test1);
 
		waitForElement(driver, Contract_Management_System_Add);
		click(driver, Contract_Management_System_Add);
		
		
		waitForPopup(driver, popup_Message, originmissing_popup);
   		String Popup_Text_Act=getText(driver, popup_Message);
		
		if(Popup_Text_Act.equals(originmissing_popup)) {
			System.out.println("Popup Matched  ||   Expected popup: "+ originmissing_popup+"   ||   Actual popup :  "+ Popup_Text_Act);
			Extent_pass(driver, "Popup Matched  ||   Expected popup: "+ originmissing_popup+"   ||   Actual popup  : "+ Popup_Text_Act, test, test1);
		}else {
			System.out.println("Popup Not Matched  ||   Expected popup:  "+ originmissing_popup+"   ||   Actual popup  : "+ Popup_Text_Act);
			Extent_fail(driver, "Popup Not Matched  ||   Expected popup : "+ originmissing_popup+"   ||   Actual popup  : "+ Popup_Text_Act, test, test1);
		}
			Step_End(6, "without entering the  origin and clicking on add button", test, test1);
			
			
		Extent_completed(testCaseName, test, test1);
		
	
   }
}


