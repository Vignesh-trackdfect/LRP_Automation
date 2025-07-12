package LRP_Phase_1A_Discharge_Reconciliation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Discharge_Reconciliation_MD09C extends Keywords{
	
	
	public void Discharge_Reconciliation_MD09C(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Discharge_Reconciliation_MD09C";


		String username=Excel_data.get("Username");
		String password=Excel_data.get("Password");
		String moduleID=Excel_data.get("Module_ImportDocumentation");
		String agencyUser = Excel_data.get("AgencyUser");
		String Service_Name = Excel_data.get("Service_Name");
		String vesselcode = Excel_data.get("vesselcode");
		String voyagecode = Excel_data.get("voyagecode");
		String bound = Excel_data.get("bound");
		String portcode = Excel_data.get("portcode");
		String terminal = Excel_data.get("terminal");
		String New_Import_Documentation = Excel_data.get("New_Import_Documentation");
		String BL_Retrive_Option = Excel_data.get("BL_Retrive_Option");
		String Select_Search_Type_Import_Doc = Excel_data.get("Select_Search_Type_Import_Doc");
		String bl_Number = Excel_data.get("bl_Number");
		System.out.println(bl_Number);
		String BL_Condition = Excel_data.get("BL_Condition");
		String pol_Value = Excel_data.get("pol_Value");
		String Label_Select_2 = Excel_data.get("Label_Select_2");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String Agency_Config_Module = Excel_data.get("Agency_Config_Module");
		String Agency_code_header = Excel_data.get("Agency_code_header");
		String Attribute_code_header = Excel_data.get("Attribute_code_header");
		String Condition = Excel_data.get("Condition");
		String Attribute = Excel_data.get("Attribute");
		String Description = Excel_data.get("Description");
		String Value = Excel_data.get("Value");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String POL_Search_Header=Excel_data.get("POL_Search_Header");
		String BL_Number_Header=Excel_data.get("BL_Number_Header");
		String Plan_Input=Excel_data.get("Plan_Input");
		String Import_Invoice_Module=Excel_data.get("Import_Invoice_Module");
		String DO_Saved=Excel_data.get("DO_Saved_popup");
		String Delivery_order_Module=Excel_data.get("Delivery_order_Module");
		String Do_BL_Number_Header=Excel_data.get("Do_BL_Number_Header");
		String Discharge_Header=Excel_data.get("Discharge_Header");
		
		
		String Dis_Recon_Module = Excel_data.get("Dis_Recon_Module");
		String invoiceReversedPopup = Excel_data.get("invoiceReversedPopup");
		String invoiceReversalRemarks = Excel_data.get("invoiceReversalRemarks");
		String search_Type_Invoice_Reversal = Excel_data.get("search_Type_Invoice_Reversal");
		String InvoiceReversal_Module = Excel_data.get("InvoiceReversal_Module");

		

		
		
		

		navigateUrl(driver,url);

		//  String Get_BL_Number;
		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
		String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
		String select_Option_3 = String.format(DropDown_Select, Plan_Input);

		Extent_Start(testCaseName, test, test1);
		//		Login

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);
		
		Extent_cal(test, test1, "Checking the visibility of Main menu");

		Step_Start(1, "Switch to agency", test, test1);

		SwitchProfile(driver, agencyUser);

		Step_End(1, "Switch to agency", test, test1);

		Step_Start(2, "Open Import Documentation if not saved click on save button, if already saved go below", test, test1);
	
		moduleNavigate(driver, moduleID);


		//Vignesh-> As discussed with Suresh on 16_04_2025, I have Removed the (Step 3) Codes for validating all the Toolbar functions accessiblity
		
		if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
			click(driver, SearchButton_Toolbar);
			waitForElement(driver, SearchButton_Toolbar );
			
			globalValueSearchWindow(driver, BL_Condition, Select_Search_Type_Import_Doc, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {

			waitForDisplay(driver, NewButton_ToolBar);
			if(IsElementEnabled(driver, NewButton_ToolBar)) {
				click(driver, NewButton_ToolBar);


				waitForPopup(driver, popup_Message, New_Import_Documentation);
				String new_import_documentation=getText(driver, popup_Message);
				if(new_import_documentation.equals(New_Import_Documentation)) {
					System.out.println("Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation);
					Extent_pass(driver, "Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation, test, test1);
				}else {
					System.out.println("Not Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation);
					Extent_fail(driver, "Not Matched || Expected Pop up : "+new_import_documentation +" || Actual Pop up : "+New_Import_Documentation, test, test1);
				}


				waitForElement(driver, popup_Message_Yes_Button);
				safeclick(driver, popup_Message_Yes_Button);
			}



			waitForElement(driver, ServiceInput_IMD);
			sendKeys(driver, ServiceInput_IMD, Service_Name);

			if(!vesselcode.equals("")) {
				waitForElement(driver, grid_vesselcode_IMP_DOC);
				sendKeys(driver, grid_vesselcode_IMP_DOC, vesselcode);
			}
			if(!voyagecode.equals("")) {
				sendKeys(driver, grid_voyagecode_IMP_DOC, voyagecode);
			}
			if(!bound.equals("")) {
				sendKeys(driver, grid_bound_IMP_DOC, bound);
			}
			if(!portcode.equals("")) {
				sendKeys(driver, grid_portcodeIMP_DOC, portcode);
			}
			if(!terminal.equals("")) {
				waitForElement(driver, grid_scroll);
				scrollUsingElement(driver, grid_scroll);
				horizontalscroll(driver, grid_scroll, 300);
				click1(driver,grid_terminal_IMP_DOC);
				sendKeys(driver, grid_terminal_IMP_DOC, terminal);
			}

			waitForElement(driver, Select_Service_Details);
			click(driver,Select_Service_Details);

			waitForElement(driver, grid_selectbtn_IMP_DOC);
			click(driver, grid_selectbtn_IMP_DOC);


			scrollTop(driver);
			if(!pol_Value.equals("")) {
				waitForElement(driver, POLSearch);
				click(driver, POLSearch);
				twoColumnMultipleSearchWindow(driver, POL_Search_Header, Condition, pol_Value);
			}

			waitForElement(driver, slection_Label_1);
			click(driver, slection_Label_1);
			click(driver, select_Option_1);


			waitForElement(driver, slection_Label_2);
			click(driver, slection_Label_2);
			click(driver, select_Option_2);


			Step_Start(14, "Click the Show BL's button", test, test1);
			waitForElement(driver, Show_BL_Button);
			click(driver, Show_BL_Button);


			
	
			waitForElement(driver, BL_SearchButton_IMP_DOC);
			click(driver, BL_SearchButton_IMP_DOC);
			twoColumnMultipleSearchWindow(driver, BL_Number_Header, Condition, bl_Number);

		}
		
	waitForElement(driver, SaveButton_ToolBar);
if(isElementAccessible(driver, SaveButton_ToolBar)) {
	click(driver, SaveButton_ToolBar);
	waitForElement(driver, popup_Message_Ok_Button);
	click(driver, popup_Message_Ok_Button);
}else {
	
	System.out.println("Given Bl Number is already saved");
}
Step_End(2, "Open Import Documentation if not saved click on save button, if already saved go below", test, test1);

Step_Start(2.1, "Go to agency configuration make sure that below configuration is marked as Y,\r\n"
		+ "DWI-Delivery order - Do you want to create DO without invoice\r\n"
		+ "DWR-Delivery order - Do you want to create Do without Receipt\r\n"
		+ "", test, test1);

setAgencyConfiguration(driver, Agency_Config_Module, Agency_code_header, Attribute_code_header, Condition,
		agencyUser, Attribute, Description, Value);

Step_End(2.1, "Go to agency configuration make sure that below configuration is marked as Y,\r\n"
		+ "DWI-Delivery order - Do you want to create DO without invoice\r\n"
		+ "DWR-Delivery order - Do you want to create Do without Receipt\r\n"
		+ "", test, test1);


Step_Start(2.2, "Case-1(If Both Marked as Y)\r\n"
		+ "Open Delivery order and load the BL Number and follow below steps,\r\n"
		+ "", test, test1);



Step_Start(6, " Open Discharge Reconciliation", test, test1);
moduleNavigate(driver, Import_Invoice_Module);
newButton(driver);
Step_End(6, " Open Discharge Reconciliation", test, test1);

waitForDisplay(driver, By_BL_Number_Btn);
click(driver, By_BL_Number_Btn);
waitForElement(driver, bl_Search_Button_IN);
click(driver, bl_Search_Button_IN);

globalValueSearchWindow(driver, BL_Condition, Do_BL_Number_Header, bl_Number, "", "", "", "");

waitForElement(driver, issued_Button);
click(driver, issued_Button);

scrollTop(driver);
waitForElement(driver, SaveButton_ToolBar);
click(driver, SaveButton_ToolBar);
waitForElement(driver, popup_Message_Ok_Button);
click(driver, popup_Message_Ok_Button);


	

moduleNavigate(driver, Delivery_order_Module);
newButton(driver);

waitForElement(driver, DO_Add_Button);
click(driver, DO_Add_Button);
globalValueSearchWindow(driver, BL_Condition, Do_BL_Number_Header, bl_Number, "", "", "", "");
Step_End(8, "Paste the BL, click search, and fetch the record (System fetched the guarantor check details for customer)", test, test1);
Step_Start(9, "Click the 'SHOW' button", test, test1);
waitForElement(driver, DO_Show_Button);
click(driver, DO_Show_Button);
Step_End(2.2, "Case-1(If Both Marked as Y)\r\n"
		+ "Open Delivery order and load the BL Number and follow below steps,\r\n"
		+ "", test, test1);
Step_Start(3, "Select the Container Number and click on save Button", test, test1);

scrollBottom(driver);
waitForElement(driver, select_All_Checkbox_DO);
click(driver, select_All_Checkbox_DO);
scrollTop(driver);
waitForElement(driver, SaveButton_ToolBar);
click(driver, SaveButton_ToolBar);
Step_End(3, "Select the Container Number and click on save Button", test, test1);
Step_Start(4, "system shows Delivery order saved message", test, test1);
waitForPopup(driver,Popup_Message,DO_Saved);
String DO_Saved_Popup=getText(driver, Popup_Message);
if (DO_Saved_Popup.equals(DO_Saved)) {
	System.out.println("Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup);
	Extent_pass(driver,"Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup, test,test1);
} else {
	System.out.println("Not Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is : " + DO_Saved_Popup);
	Extent_fail(driver,"Not Matched || Expected Pop-up value is : " + DO_Saved + " || Actual Pop-up value is  : " + DO_Saved_Popup,test, test1);
}
Step_End(4, "system shows Delivery order saved message", test, test1);

Step_Start(6, " Open Discharge Reconciliation", test, test1);
moduleNavigate(driver, Dis_Recon_Module);
Step_End(6, " Open Discharge Reconciliation", test, test1);


Step_Start(7, "Click on New button if New Button is not Available Go to Next Step", test, test1);
newButton(driver);

Step_Start(8, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);
   
waitForElement(driver, DisRecServiceInput_DRL);
sendKeys(driver, DisRecServiceInput_DRL, Service_Name);

waitForElement(driver, grid_vesselcode_IMP_DOC);
sendKeys(driver, grid_vesselcode_IMP_DOC, vesselcode);

waitForElement(driver, grid_vesselcode_IMP_DOC);
sendKeys(driver, grid_voyagecode_IMP_DOC, voyagecode);

waitForElement(driver, grid_vesselcode_IMP_DOC);
sendKeys(driver, grid_bound_IMP_DOC, bound);

		if(!portcode.equals("")) {
	waitForElement(driver, grid_scroll);
	scrollUsingElement(driver, grid_scroll);
	horizontalscroll(driver, grid_scroll, 300);
	
	click1(driver,grid_portcodeIMP_DOC);
	sendKeys(driver, grid_portcodeIMP_DOC, portcode);
}
waitForElement(driver, grid_selectbtn_IMP_DOC);
click(driver, grid_selectbtn_IMP_DOC);

waitForElement(driver, droup_select_discharge);
click(driver, droup_select_discharge);
Step_End(8, "Enter the service,Vessel, Voyage, Bound, Port and Terminal", test, test1);

Step_Start(9, "Select the Plan as ALL/Local/Transhipment", test, test1);

waitForElement(driver, select_Option_3);
click(driver, select_Option_3);
Step_End(9, "Select the Plan as ALL/Local/Transhipment", test, test1);

Step_Start(10, "Click on Download BL Button.", test, test1);
waitForElement(driver, DownloadBLs);
click(driver, DownloadBLs);
Step_End(10, "Click on Download BL Button.", test, test1);
reArrangeAG_GridColumnsNew(driver, Discharge_recon_cocloum_click, Discharge_Header);
waitForElement(driver, Filter_Button_Re_Con);
click(driver, Filter_Button_Re_Con);
Step_Start(11, "Select the ROW based on BL NO user wanted to check check box,", test, test1);
waitForElement(driver, Bl_Number_input_re_con);
sendKeys(driver, Bl_Number_input_re_con, bl_Number);
Step_End(11, "Select the ROW based on BL NO user wanted to check check box,", test, test1);
Step_Start(12, "Click the Check Box", test, test1);
waitForElement(driver, DO_Hold_Checkbox);
click(driver, DO_Hold_Checkbox);
Step_End(12, "Click the Check Box", test, test1);
Step_Start(13, "Verify that system should not Click the Check Box", test, test1);
if(!isElementAccessible(driver, DO_Hold_Checkbox)) {
	System.out.println("Matched || Expected Result is : DO Hold Checkbox should be disable|| Actual Result is : DO Hold Checkbox is  disable");
	Extent_pass_New(driver, "Matched || Expected Result is : DO Hold Checkbox should be disable|| Actual Result is : DO Hold Checkbox is  disable", test, test1);
}else {

	System.out.println("Matched || Expected Result is : DO Hold Checkbox should be disable || Actual Result is : DO Hold Checkbox is not disable");
	Extent_fail(driver, "Matched || Expected Result is :DO Hold Checkbox should be disable || Actual Result is :DO Hold Checkbox is not disable", test, test1);
}
Step_End(13, "Verify that system should not Click the Check Box", test, test1);
waitForElement(driver, Close_Current_tab);
click(driver, Close_Current_tab);
waitForElement(driver, Delete_button_toolBar);
click(driver, Delete_button_toolBar);
waitForElement(driver, popup_Message_Yes_Button);
click(driver, popup_Message_Yes_Button);
waitForElement(driver, Close_Current_tab);
click(driver, Close_Current_tab);

Step_Start(13, "open the invoice reversal module ", test, test1);
moduleNavigate(driver, InvoiceReversal_Module);
Step_End(13, "open the invoice reversal module ", test, test1);

Step_Start(14, "click the new button", test, test1);

waitForElement(driver, NewButton_ToolBar);
click(driver, NewButton_ToolBar);
Step_End(14, "click the new button", test, test1);

Step_Start(15, "load thesame bl no or invoice no from import invoice in invoice reversal module", test,
		test1);

Step_Start(15, "select the bl no and click the show button", test, test1);

waitForElement(driver, invoiceNo_SearchButton);
click(driver, invoiceNo_SearchButton);

globalValueSearchWindow(driver, BL_Condition, search_Type_Invoice_Reversal, bl_Number, "", "", "",
		"");

waitForElement(driver, invoiceReversal_Show_Button);
click(driver, invoiceReversal_Show_Button);

Step_End(16, "load thesame bl no or invoice no from import invoice in invoice reversal module", test,
		test1);

Step_End(17, "select the bl no and click the show button", test, test1);
Step_Start(18, "in below grid invoice details has to be shown", test, test1);

waitForElement(driver, inv_Reversal_Table_Header);
List<Map<String, String>> invoice_Details_Table = getTableData(driver, inv_Reversal_Table_Header,
		invoiceReversal_Table_Rows);

List<String> invoice_Numbers = getValuesByHeader(invoice_Details_Table, "Invoice No");

System.out.println("INVOICE NUMBERS SHOWN IN THE GRID ARE :" + invoice_Numbers);

Step_End(18, "in below grid invoice details has to be shown", test, test1);

Step_Start(19, "select the invoice no and enter the reversal reason in below grid.", test, test1);

waitForElement(driver, invoiceReversal_Table_Rows);
click(driver, invoiceReversal_Table_Rows);
click(driver, invoiceReversal_Remarks_TextArea);
sendKeys(driver, invoiceReversal_Remarks_TextArea, invoiceReversalRemarks);

Step_End(19, "select the invoice no and enter the reversal reason in below grid.", test, test1);

Step_Start(20, "click the save button", test, test1);

click(driver, SaveButton_ToolBar);

Step_End(20, "click the save button", test, test1);

Step_Start(21, "click yes", test, test1);

waitForDisplay(driver, popup_Message_Yes_Button);

if (isdisplayed(driver, popup_Message_Yes_Button)) {
	click(driver, popup_Message_Yes_Button);
}

Step_End(21, "click yes", test, test1);

Step_Start(22, "system has validate the invoice reversed", test, test1);

waitForPopup(driver, popup_Message, invoiceReversedPopup);

String actualReversedPopup = getText(driver, popup_Message);

if (actualReversedPopup.equals(invoiceReversedPopup)) {
	Extent_pass_New(driver, "Matched || Expected Reveresed Popup : " + invoiceReversedPopup
			+ " Actual Reveresed Popup : " + actualReversedPopup, test, test1);
	System.out.println("Matched || Expected Reveresed Popup : " + invoiceReversedPopup
			+ " Actual Reveresed Popup : " + actualReversedPopup);
	click(driver, popup_Message_Ok_Button);
} else {
	System.out.println("Not Matched || Expected Reveresed Popup : " + invoiceReversedPopup
			+ " Actual Reveresed Popup : " + actualReversedPopup);
	Extent_fail(driver, "Not Matched || Expected Reveresed Popup : " + invoiceReversedPopup
			+ " Actual Reveresed Popup : " + actualReversedPopup, test, test1);
}


	
waitForElement(driver, Delete_button_toolBar);
click(driver, Delete_button_toolBar);
waitForElement(driver, popup_Message_Yes_Button);
click(driver, popup_Message_Yes_Button);
waitForElement(driver, popup_Message_Ok_Button);
click(driver, popup_Message_Ok_Button);























		Extent_completed(testCaseName, test, test1);

	}
}

	
	
	
	


