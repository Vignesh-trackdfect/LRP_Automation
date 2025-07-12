package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC115 extends Keywords{
	
	public void Contract_Management_System_SC115(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
	
		String testCaseName = "TC_Contract_Management_System_SC115";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_Name_Value = Excel_data.get("Customer_Name_Value");
		String Internal_Commodity_Value = Excel_data.get("Internal_Commodity_Value");
		String Two_Column_Search_Condition = Excel_data.get("Two_Column_Search_Condition");
		String Rate_Type_Value = Excel_data.get("Rate_Type_Value");
		String Origin_Value = Excel_data.get("Origin_Value");
		String Delivery_Order_Value = Excel_data.get("Delivery_Order_Value");
		String POL_Value = Excel_data.get("POL_Value");
		String POD_Value = Excel_data.get("POD_Value");
		String OFR_Amount_Value = Excel_data.get("OFR_Amount_Value");
		String Rate_Type_Header = Excel_data.get("Rate_Type_Header");
		String Origin_Code_Header = Excel_data.get("Origin_Code_Header");
		String Delivery_Order_Header = Excel_data.get("Delivery_Order_Header");
		String POL_Header = Excel_data.get("POL_Header");
		String POD_Header = Excel_data.get("POD_Header");
		String Carrier_Info_Validation = Excel_data.get("Carrier_Info_Validation");
		String Tarrif_Of_General_Applicability = Excel_data.get("Tarrif_Of_General_Applicability");
		String Package_Header = Excel_data.get("Package_Header");
		String GrWt = Excel_data.get("GrWt");
		String Length = Excel_data.get("Length");
		String Width = Excel_data.get("Width");
		String Height = Excel_data.get("Height");
		String Quantity = Excel_data.get("Quantity");
		String Package_Description = Excel_data.get("Package_Description");
		
		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		moduleNavigate(driver, Contract_Management_System_Module);	
		
		
		Step_Start(2, "select Non-containerized check box.", test, test1);
		waitForElement(driver, Contract_Management_System_Non_Containerized);
		click(driver, Contract_Management_System_Non_Containerized);		
		Step_End(2, "select Non-containerized check box.", test, test1);

		Step_Start(1, "select FMC check box.", test, test1);
		waitForElement(driver, Contract_Management_System_Fmc);
		click(driver, Contract_Management_System_Fmc);		
		Step_End(1, "select FMC check box.", test, test1);
		
		Step_Start(3, ".Enter the customer name.", test, test1);
		waitForElement(driver, Contract_Management_System_CustomerName);
		sendKeys(driver, Contract_Management_System_CustomerName, Customer_Name_Value);

		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);
		
		waitForDisplay(driver, Contract_Management_System_Exit);
		if (isDisplayed(driver, Contract_Management_System_Exit)) {
			waitForElement(driver, Contract_Management_System_Exit);
			click(driver, Contract_Management_System_Exit);
		} else {
			System.out.println("customer name System Page is not displayed");
		}
		
		Step_End(3, ".Enter the customer name.", test, test1);

		Step_Start(4, "switch to commodity tab and enter the commodity name and click \"+\" button.", test, test1);
		waitForElement(driver, Contract_Management_System_Commodity);
		click(driver, Contract_Management_System_Commodity);

		waitForElement(driver, Contract_Management_System_Internal_Commodity);
		sendKeys(driver, Contract_Management_System_Internal_Commodity, Internal_Commodity_Value);

		String select_Internal_Commmodity = String.format(Contract_Management_System_Commodity_val, Internal_Commodity_Value);
		waitForElement(driver, select_Internal_Commmodity);
		safeclick(driver, select_Internal_Commmodity);
		
		waitForElement(driver, Contract_Management_System_Internal_Commodity_add);
		click(driver, Contract_Management_System_Internal_Commodity_add);		
		Step_End(4, "switch to commodity tab and enter the commodity name and click \"+\" button.", test, test1);

		Step_Start(5, "switch to port pair tab.", test, test1);
		waitForElement(driver, Contract_Management_System_port_pair);
		click(driver, Contract_Management_System_port_pair);		
		Step_End(5, "switch to port pair tab.", test, test1);

		
		Step_Start(6, "add the port pair lanes below main grid", test, test1);

		waitForElement(driver, Rate_type_Search);
		click(driver,Rate_type_Search);
		twoColumnSearchWindow(driver, Rate_Type_Header, Two_Column_Search_Condition, Rate_Type_Value);			
		
		waitForElement(driver, Contract_Management_System_Origin_seach);
		click(driver,Contract_Management_System_Origin_seach);
		twoColumnSearchWindow(driver, Origin_Code_Header, Two_Column_Search_Condition, Origin_Value);
		
		waitForElement(driver, Contract_Management_System_Delivery);
		click(driver, Contract_Management_System_Delivery);
		twoColumnSearchWindow(driver, Delivery_Order_Header, Two_Column_Search_Condition, Delivery_Order_Value);
		
		if(!POL_Value.trim().equals("")) {
			waitForElement(driver, POL_Search_Button_CMS);
			click(driver,POL_Search_Button_CMS);
			twoColumnSearchWindow(driver, POL_Header, Two_Column_Search_Condition, POL_Value);
		}
		
		if(!POD_Value.trim().equals("")) {
			waitForElement(driver, POD_Search_Button_CMS);
			click(driver,POD_Search_Button_CMS);
			twoColumnSearchWindow(driver, POD_Header, Two_Column_Search_Condition, POD_Value);
		}

		waitForElement(driver, Contract_Management_System_OFR);
		sendKeys(driver, Contract_Management_System_OFR, OFR_Amount_Value);
		
		
		waitForElement(driver, AddDimension);
		click(driver, AddDimension);

		waitForElement(driver, GrWt_Input);
		clearAndType(driver, GrWt_Input, GrWt);

		waitForElement(driver, Length_Input);
		click(driver, Length_Input);
		clearAndType(driver, Length_Input, Length);

		waitForElement(driver, Width_Input);
		click(driver, Width_Input);
		clearAndType(driver, Width_Input, Width);

		waitForElement(driver, Height_Input);
		click(driver, Height_Input);
		clearAndType(driver, Height_Input, Height);

		waitForElement(driver, Quantity_Input);
		click(driver, Quantity_Input);
		clearAndType(driver, Quantity_Input, Quantity);

		waitForElement(driver, Package_description);
		click(driver, Height_Input);
		click(driver, Package_description);

		twoColumnSearchWindow(driver, Package_Header, Two_Column_Search_Condition, Package_Description);

		waitForElement(driver, DimensionAdd);
		click(driver, DimensionAdd);

		waitForElement(driver, DimensionOk);
		click(driver, DimensionOk);

		waitForElement(driver, Contract_Management_System_Add);
		click(driver,Contract_Management_System_Add);
		
		Step_End(6, "add the port pair lanes below main grid", test, test1);
		
		Step_Start(7, "without entering the carrier info trying to save", test, test1);
		waitForElement(driver, PortpairGridCount);
		waitForElement(driver, Contract_Management_System_General);
		click(driver,Contract_Management_System_General);
		
		waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
		sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tarrif_Of_General_Applicability);
		
		waitForElement(driver, Cari_info_Signatory_Name);
		Newclear(driver, Cari_info_Signatory_Name);
		
		waitForElement(driver, Cari_info_Signatory_Title);
		Newclear(driver, Cari_info_Signatory_Title);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		
		
		waitForPopup(driver, Popup_Message, Carrier_Info_Validation);
		String Act_Popup=getText(driver, Popup_Message);
		if(Carrier_Info_Validation.equals(Act_Popup)) {
			System.out.println("Popup Macthed || Expected : "+Carrier_Info_Validation+" || Actual : "+Act_Popup);
			Extent_pass_New(driver, "Popup Macthed || Expected : "+Carrier_Info_Validation+" || Actual : "+Act_Popup, test, test1);
		}else {
			System.out.println("Popup Not Macthed || Expected : "+Carrier_Info_Validation+" || Actual : "+Act_Popup);
			Extent_fail(driver, "Popup Not Macthed || Expected : "+Carrier_Info_Validation+" || Actual : "+Act_Popup, test, test1);
		}
		
		Step_End(7, "without entering the carrier info trying to save", test, test1);
		
		Extent_completed(testCaseName, test, test1);	
		
	}
}
