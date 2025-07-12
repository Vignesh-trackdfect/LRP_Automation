package LRP_Phase_1A_Contract_Management_System;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Contract_Management_System_SC138 extends Keywords {

	public void Contract_Management_System_SC138(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) {

		String testCaseName = "TC_Contract_Management_System_SC138";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Contract_Management_System_Module = Excel_data.get("Contract_Management_System_Module");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Internal_Commodity = Excel_data.get("Internal_Commodity");
		String ImportFilename = Excel_data.get("ImportFilename");
		String MainSheetName = Excel_data.get("MainSheetName");
		String DimensionSheetName = Excel_data.get("DimensionSheetName");
		String Tariffs_of_General_Applicability = Excel_data.get("Tariffs_of_General_Applicability");
		String Signatory_Name = Excel_data.get("Signatory_Name");
		String Signatory_Title = Excel_data.get("Signatory_Title");
		String CMS_Carrier_remarks_TextField = Excel_data.get("CMS_Carrier_remarks_TextField");
		String Contract_saved = Excel_data.get("Contract_saved");
		String Ratenotenotdefined_popup = Excel_data.get("Ratenotenotdefined_popup");

		String MainSheet_option = String.format(SelectMainSheet, MainSheetName);
		String DGheet_option = String.format(SelectDGSheet, DimensionSheetName);

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

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

		waitForDisplay(driver, Contract_Management_System_Exit);
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

		Step_Start(6, ".Import the port pair lanes without selecting rate note number in portpair", test, test1);
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

		waitForElement(driver, ImportExcel_DG);
		click(driver, ImportExcel_DG);

		waitForElement(driver, SelectSheet_dropdown2);
		click(driver, SelectSheet_dropdown2);

		waitForElement(driver, DGheet_option);
		click(driver, DGheet_option);

		waitForElement(driver, LoadSheet_DG);
		click(driver, LoadSheet_DG);

		waitForElement(driver, Automap_Yes);
		click(driver, Automap_Yes);

		waitForElement(driver, Upload_Excel);
		click(driver, Upload_Excel);
		scrollBottom(driver);

		waitForElement(driver, PortpairGridCount);
		String gridcount = getText(driver, PortpairGridCount).trim();

		if (gridcount.equals(ExcelrowCount)) {

			System.out.println("All the row values are imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "All the row values are imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		} else {

			System.out.println("Some of the row values are not imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount);
			Extent_pass(driver, "Some of the row values are not imported in the portpair grid || Expected rows : "
					+ ExcelrowCount + " Actual rows : " + gridcount, test, test1);
		}

		scrollTop(driver);

		Step_End(6, "Import the port pair lanes without selecting rate note number in port pair", test, test1);

		Step_Start(7, "enter the carrier and customer info", test, test1);

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

		Step_End(7, "enter the carrier and customer info", test, test1);

		Step_Start(8, "save the contract without the rate note entered in rate note tab but imported in portpair .",
				test, test1);

		waitForElement(driver, Contract_Management_System_save);
		click(driver, Contract_Management_System_save);

		waitForPopup(driver, Popup_Message, Contract_saved);

		String saved_popup = getText(driver, Popup_Message);
		System.out.println("saved_popup :" + saved_popup);

		if (Contract_saved.equals(saved_popup)) {
			Extent_pass(driver, "Matched || Expected popup value was : " + Contract_saved
					+ " ||  Actual popup value was is display : " + saved_popup, test, test1);
			System.out.println("Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was is display: " + saved_popup);
		} else {
			System.out.println("Not Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was not display: " + saved_popup);
			Extent_fail(driver, "Not Matched || Expected popup value was : " + Contract_saved
					+ " || Actual popup value was not display: " + saved_popup, test, test1);

		}

		waitForElement(driver, Contract_Management_System_Edit);
		click(driver, Contract_Management_System_Edit);

		waitForElement(driver, Contract_Management_System_Approved);
		click(driver, Contract_Management_System_Approved);

		waitForPopup(driver, Popup_Message, Ratenotenotdefined_popup);
		String Popup_Text_Act = getText(driver, Popup_Message);

		if (Popup_Text_Act.equals(Ratenotenotdefined_popup)) {
			System.out.println(
					"Matched || when Non containerized NFMC contract imports lanes with rate number and no rate note entered in the rate note tab , the Expected popup is "
							+ Ratenotenotdefined_popup
							+ "|| when Non containerized NFMC contract imports lanes with rate number  and no rate note entered in the rate note tab , the Actual popup is "
							+ Popup_Text_Act);
			Extent_pass(driver,
					" Matched  || when Non containerized NFMC contract imports lanes with rate number  and no rate note entered in the rate note tab ,the Expected popup is "
							+ Ratenotenotdefined_popup
							+ " || when Non containerized NFMC contract imports lanes with rate number  and no rate note entered in the rate note tab , the Actual popup is "
							+ Popup_Text_Act,
					test, test1);
		} else {
			System.out.println(
					" Not Matched  ||when Non containerized NFMC contract imports lanes with rate number  and no rate note entered in the rate note tab , the Expected popup is "
							+ Ratenotenotdefined_popup
							+ "  ||  when Non containerized NFMC contract imports lanes with rate number  and no rate note entered in the rate note tab , the Acutal popup is "
							+ Popup_Text_Act);
			Extent_fail(driver,
					" Not Matched  || when Non containerized NFMC contract imports lanes with rate number  and no rate note entered in the rate note tab , the Expected popup is"
							+ Ratenotenotdefined_popup
							+ "  ||when Non containerized NFMC contract imports lanes with rate number  and no rate note entered in the rate note tab , the Actual popup is "
							+ Popup_Text_Act,
					test, test1);
		}

		Step_End(8, "save the contract without the rate note entered in rate note tab but imported in portpair.", test,
				test1);
		Extent_completed(testCaseName, test, test1);

	}
}
