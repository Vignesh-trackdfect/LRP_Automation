package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC171 extends Keywords{

	public void Contract_Management_System_SC171(WebDriver driver, ExtentTest test, ExtentTest test1,

		String selected_dataset,Map<String, String> Excel_data,String url) {

	String testCaseName = "TC_Contract_Management_System_SC171";
	
	String username = Excel_data.get("username");
	String password = Excel_data.get("password");
	String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
	String Customer_code_Value = Excel_data.get("Customer_code_Value");
	String Internal_Commodity = Excel_data.get("Internal_Commodity");
	String MainSheetName = Excel_data.get("MainSheetName");
	String ImportFilename = Excel_data.get("ImportFilename");
	String Tariffs_of_General_Applicability = Excel_data.get("Tariffs_of_General_Applicability");
	String Contract_saved = Excel_data.get("Contract_saved");
	String Signatory_Name = Excel_data.get("Signatory_Name");
	String Signatory_Title = Excel_data.get("Signatory_Title");
	String MainSheet_option = String.format(SelectMainSheet, MainSheetName);
	String CMS_Carrier_remarks_TextField = Excel_data.get("CMS_Carrier_remarks_TextField");
	String CmS_Upload_Sucess_popup = Excel_data.get("CmS_Upload_Sucess_popup");
	
	Extent_Start(testCaseName, test, test1);

	navigateUrl(driver, url);

	LRP_Login(driver, username, password);

	moduleNavigate(driver, Contract_Management_System_Module);

	Step_Start(1, "select FMC check box", test, test1);

	waitForElement(driver, Contract_Management_System_Fmc);
	click(driver, Contract_Management_System_Fmc);

	Step_End(1, "select FMC check box", test, test1);

	Step_Start(2, "select containerized check box", test, test1);

	waitForElement(driver, Contract_Management_System_Containerized);
	click(driver, Contract_Management_System_Containerized);

	Step_End(2, "select containerized check box", test, test1);

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

	Step_Start(4, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);

	waitForElement(driver, Contract_Management_System_Commodity);
	click(driver, Contract_Management_System_Commodity);

	waitForElement(driver, Contract_Management_System_Internal_Commodity);
	sendKeys(driver, Contract_Management_System_Internal_Commodity, Internal_Commodity);

	String select_Internal_Commmodity = String.format(Contract_Management_System_Commodity_val, Internal_Commodity);
	waitForElement(driver, select_Internal_Commmodity);
	safeclick(driver, select_Internal_Commmodity);

	waitForElement(driver, Contract_Management_System_Internal_Commodity_add);
	click(driver, Contract_Management_System_Internal_Commodity_add);

 	Step_End(4, "swithch to commodity tab and enter the commodity name and click + button.", test, test1);


	Step_Start(5, "switch to port pair tab", test, test1);

	waitForElement(driver, Contract_Management_System_port_pair);
	click(driver, Contract_Management_System_port_pair);

	Step_End(5, "switch to port pair tab", test, test1);

	Step_Start(6, "Import the port pair lanes ", test, test1);

	waitForElement(driver, ImportExcel);
	click(driver, ImportExcel);

	uploadfile_new(driver, ImportInput, ImportFilename);



	

	String ExcelrowCount = rowcountxls(driver, ImportFilename, MainSheetName);

	waitForElement(driver, SelectSheet_dropdown1);
	click(driver, SelectSheet_dropdown1);

	waitForElement(driver, MainSheet_option);
	click(driver, MainSheet_option);

	waitForElement(driver, LoadSheet_Main);
	click(driver, LoadSheet_Main);

	waitForElement(driver, Automap_Yes);
	click(driver, Automap_Yes);

	waitForElement(driver, Upload_Excel);
	click(driver, Upload_Excel);

	scrollBottom(driver);

	waitForElement(driver, PortpairGridCount);
	String gridcount = getText(driver, PortpairGridCount).trim();

	if (gridcount.equals(ExcelrowCount)) {

		System.out.println("All the row values are imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount);
		Extent_pass(driver, "All the row values are imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
	} else {

		System.out.println("Some of the row values are not imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount);
		Extent_pass(driver, "Some of the row values are not imported in the portpair grid || Expected rows : "+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
	}
	Step_End(6, "Import the port pair lanes ", test, test1);
	
	Step_Start(7, "and calculate the routing and surcharge.", test, test1);
	scrollTop(driver);

	


	waitForElement(driver, RouteSch);
	click(driver, RouteSch);
	
	waitForDisplay(driver, RouteSch_Ok);
	jsClick(driver, RouteSch_Ok);
	
	Step_End(7, "and calculate the routing and surcharge.", test, test1);

	scrollTop(driver);
	mouseOverToElement(driver, Contract_Management_System_General);
	waitForElement(driver, Contract_Management_System_General);
	click(driver, Contract_Management_System_General);

	waitForElement(driver, Contract_Management_System_Tariffs_of_General_Applicability);
	sendKeys(driver, Contract_Management_System_Tariffs_of_General_Applicability, Tariffs_of_General_Applicability);

	waitForElement(driver, Contract_Management_System_Signatory_Name);
	sendKeys(driver, Contract_Management_System_Signatory_Name, Signatory_Name);

	waitForElement(driver, Contract_Management_System_Signatory_Title);
	sendKeys(driver, Contract_Management_System_Signatory_Title, Signatory_Title);

	waitForElement(driver, Cari_info_Signatory_Name);
	clear(driver, Cari_info_Signatory_Name);
	sendKeys(driver, Cari_info_Signatory_Name, Signatory_Name);

	waitForElement(driver, Cari_info_Signatory_Title);
	clear(driver, Cari_info_Signatory_Title);
	sendKeys(driver, Cari_info_Signatory_Title, Signatory_Title);

	waitForElement(driver, CMS_Carrier_Remarks_Field);
	sendKeys(driver, CMS_Carrier_Remarks_Field, CMS_Carrier_remarks_TextField);
	
	Step_Start(8, ".and save the contract", test, test1);
	waitForElement(driver, Contract_Management_System_save);
	click(driver, Contract_Management_System_save);
	waitForDisplay(driver, Popup_Message);
	String saved_popup = getText(driver, Popup_Message);
	System.out.println("saved_popup :" + saved_popup);

	if (Contract_saved.equals(saved_popup)) {
		Extent_pass(driver, "Matched || Expected popup value was : " + Contract_saved
				+ " || Actual popup value was is display : " + saved_popup, test, test1);
		System.out.println("Matched || Expected popup value was : " + Contract_saved
				+ " || Actual popup value was is display: " + saved_popup);
	} else {
		System.out.println("Not Matched || Expected popup value was : " + Contract_saved
				+ " || Actual popup value was not display: " + saved_popup);
		Extent_fail(driver, "Not Matched || Expected popup value was : " + Contract_saved
				+ " || Actual popup value was not display: " + saved_popup, test, test1);

	}
	Step_End(8, ".and save the contract", test, test1);
	Step_Start(9, "and click the document option in the toolbar", test, test1);
	waitForElement(driver, Attachement_Button_toolBar);
	click(driver, Attachement_Button_toolBar);
	uploadfile_new(driver, Cms_Select_file, ImportFilename);
	Step_End(9, "and click the document option in the toolbar", test, test1);
	
	Step_Start(10, ".and upload the file.", test, test1);
	waitForElement(driver, Cms_Document_Attachement_upload_bttn);
	click(driver, Cms_Document_Attachement_upload_bttn);
	
	waitForPopup(driver, popup_Message, CmS_Upload_Sucess_popup);
	String upload_popup = getText(driver, popup_Message);
	System.out.println("saved_popup :" + saved_popup);

	if (CmS_Upload_Sucess_popup.equals(upload_popup)) {
		Extent_pass(driver, "Matched || Expected popup value was : " + CmS_Upload_Sucess_popup
				+ " || Actual popup value was is display : " + upload_popup, test, test1);
		System.out.println("Matched || Expected popup value was : " + CmS_Upload_Sucess_popup
				+ " || Actual popup value was is display: " + upload_popup);
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);
		
	} else {
		System.out.println("Not Matched || Expected popup value was : " + CmS_Upload_Sucess_popup
				+ " || Actual popup value was not display: " + upload_popup);
		Extent_fail(driver, "Not Matched || Expected popup value was : " + CmS_Upload_Sucess_popup
				+ " || Actual popup value was not display: " + upload_popup, test, test1);

	}

	waitForElement(driver, Cms_Document_Attachement_File_Name);
	String upload_File_Name = getText(driver, Cms_Document_Attachement_File_Name);
	
	if (ImportFilename.equalsIgnoreCase(upload_File_Name)) {
		System.out.println("Matched || Expected the status  : After Upload the file ,The File Name  should be : "
				+ ImportFilename + " || Actual value : After Upload the file ,The File Name  is : " + upload_File_Name);
		Extent_pass(driver, "Matched || Expected the status  :After Upload the file ,The File Name  should be : "
				+ ImportFilename + " || Actual value is After Upload the file ,The File Name  is : " + upload_File_Name,
				test, test1);

	} else {

		System.out	.println("Not Matched || Expected the status  : After Upload the file ,The File Name  should be : "
						+ ImportFilename + " || Actual value is After Upload the file ,The File Name  is : "
						+ upload_File_Name);
		Extent_fail(driver,
				"Not Matched || Expected the status  : After Upload the file ,The File Name  should be : "
						+ ImportFilename + " || Actual value is After Upload the file ,The File Name is : "
						+ upload_File_Name,
				test, test1);

	}
	Step_Start(10, ".and upload the file.", test, test1);
	Extent_completed(testCaseName, test, test1);
	
	
	
	}
}
