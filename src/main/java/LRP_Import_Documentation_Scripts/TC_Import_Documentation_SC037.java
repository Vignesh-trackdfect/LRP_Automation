package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC037 extends Keywords {

	public void Import_Documentation_SC037(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
	
	String testcase_Name="TC_Import_Documentation_SC037";
	String Username = Excel_data.get("Username");
	String Password = Excel_data.get("Password");
	String AgencyUser = Excel_data.get("AgencyUser");
	String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
	String BL_Condition = Excel_data.get("BL_Condition");
	String SavedPopup = Excel_data.get("SavedPopup");
	String BL_Status_val = Excel_data.get("BL_Status_val");
	String first_service_data = Excel_data.get("first_service_data");
	String Vessels = Excel_data.get("Vessels");
	String Voyagenumber1 = Excel_data.get("Voyagenumber1");
	String Boundinput = Excel_data.get("Boundinput");
	String portCode = Excel_data.get("portCode");
	String terminalCode = Excel_data.get("terminalCode");
	String BL_Retrive_Option=Excel_data.get("BL_Retrive_Option");
	String select_customers=Excel_data.get("select_customers");
	String Customer_Code_datas=Excel_data.get("Customer_Code_datas");
	String customer_name_datas=Excel_data.get("customer_name_datas");
	String address2_datas=Excel_data.get("address2_datas");
	String address1_datas=Excel_data.get("address1_datas");
	String post_box_no_datas=Excel_data.get("post_box_no_datas");
	String city_datas=Excel_data.get("city_datas");
	String country_datas=Excel_data.get("country_datas");
	String zip_datas=Excel_data.get("zip_datas");
	String phone_datas=Excel_data.get("phone_datas");
	String fax_datas=Excel_data.get("fax_datas");
	String email_datas=Excel_data.get("email_datas");
	String search_by_cust_code=Excel_data.get("search_by_cust_code");
	String headers_to_print=Excel_data.get("headers_to_print");
	String do_you_want_to_delete=Excel_data.get("do_you_want_to_delete");
	String condition_filter = Excel_data.get("condition_filter");
	String delete_confirmation_popup = Excel_data.get("delete_confirmation_popup").trim();
	String deleted_popup_expected = Excel_data.get("deleted_popup_expected").trim();
	String bl_Number = Excel_data.get("bl_Number");
	String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
	String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
	String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
	String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
	String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
	String CustomerCode_Select_Type2=Excel_data.get("CustomerCode_Select_Type2");
	String CustomerCode_Select_Value2=Excel_data.get("CustomerCode_Select_Value2");
	String CustomerCode_Select_Type3=Excel_data.get("CustomerCode_Select_Type3");
	String CustomerCode_Select_Value3=Excel_data.get("CustomerCode_Select_Value3");
	String Country_Code_Header=Excel_data.get("Country_Code_Header");
	String Label_Select_1 = Excel_data.get("Label_Select_1");
	String Label_Select_2 = Excel_data.get("Label_Select_2");
	String Local_Check_Box_Select = Excel_data.get("Local_Check_Box_Select");
	String Transhipment_Check_Box_Select = Excel_data.get("Transhipment_Check_Box_Select");
	String condition=Excel_data.get("condition");
	String pol_Value=Excel_data.get("pol_Value");
	String POL_Search_Header=Excel_data.get("POL_Search_Header");
	String BL_Number_Header=Excel_data.get("BL_Number_Header");
	String select_Option_1 = String.format(DropDown_Select, Label_Select_1);
	String select_Option_2 = String.format(DropDown_Select, Label_Select_2);
	
	
    Extent_Start(testcase_Name, test, test1);
	navigateUrl(driver, url);

	LRP_Login(driver, Username, Password);
	
	verifyMainMenu(driver);
	
	SwitchProfile(driver, AgencyUser);
	
	Step_Start(1, "open the Import Documentation and Retrive the new bill using tool bar search.", test, test1);	

	moduleNavigate(driver, ImportDocumentationModule);

	if(BL_Retrive_Option.equalsIgnoreCase("By_BL")) {
		
		click(driver, SearchButton_Toolbar);
		waitForElement(driver, SearchButton_Toolbar );
	
		globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);
	
	}else if(BL_Retrive_Option.equalsIgnoreCase("By_Service")) {
		
		newButton(driver);
		
		waitForElement(driver, ServiceInput_IMD );
		sendKeys(driver, ServiceInput_IMD , first_service_data);
		
		if(!Vessels.trim().equals("")) {
			waitForElement(driver, grid_vesselcode_IMP_DOC);
			sendKeys(driver, grid_vesselcode_IMP_DOC ,Vessels);
		}
		
		if(!Voyagenumber1.trim().equals("")) {
			waitForElement(driver, grid_voyagecode_IMP_DOC);
			sendKeys(driver, grid_voyagecode_IMP_DOC , Voyagenumber1);
		}
		
		if(!Boundinput.trim().equals("")) {
			waitForElement(driver, grid_bound_IMP_DOC);
			sendKeys(driver, grid_bound_IMP_DOC, Boundinput);
		}
		
		if(!portCode.trim().equals("")) {
			waitForElement(driver, grid_portcodeIMP_DOC);
			sendKeys(driver, grid_portcodeIMP_DOC , portCode);
		}
		
		if(!terminalCode.trim().equals("")) {
			horizontalscroll(driver, grid_scroll, 300);		
			click(driver, grid_terminal_IMP_DOC);
			sendKeys(driver, grid_terminal_IMP_DOC , terminalCode);
		}
		
		waitForElement(driver, Select_Service_Details);
		click(driver, Select_Service_Details);
		
		waitForElement(driver, grid_selectbtn_IMP_DOC);
		click(driver, grid_selectbtn_IMP_DOC);
	
		scrollTop(driver);
		scrollTop(driver);
		if(!pol_Value.trim().equals("")) {
			waitForElement(driver, POLSearch);
			click(driver, POLSearch);
			twoColumnMultipleSearchWindow(driver, POL_Search_Header, condition, pol_Value);
		}
		
		waitForElement(driver, slection_Label_1);
		click(driver, slection_Label_1);
		
		waitForElement(driver, select_Option_1);
		click(driver, select_Option_1);
		
		waitForElement(driver, slection_Label_2);
		click(driver, slection_Label_2);
		
		waitForElement(driver, select_Option_2);
		click(driver, select_Option_2);
		
		
		waitForElement(driver, Show_BL_Button);
		click(driver, Show_BL_Button);
		
		waitForElement(driver, Local_Check_Box);
		checkBox(driver, Local_Check_Box, Local_Check_Box_Select);		
		waitForElement(driver, Transhipment_Check_Box);
		checkBox(driver, Transhipment_Check_Box, Transhipment_Check_Box_Select);
		
		waitForElement(driver, BL_SearchButton_IMP_DOC);
		click(driver, BL_SearchButton_IMP_DOC);
		
		twoColumnMultipleSearchWindow(driver, BL_Number_Header, condition, bl_Number);		
	}
	Step_End(1, "open the Import Documentation and Retrive the new bill using tool bar search.", test, test1);	

	Extent_call(test, test1, "If the BL is already saved, deleteing the BL");
	deleteSavedBL(driver,BL_Status_val,BL_Condition,bl_Number);
	Extent_call(test, test1, "If the BL is already saved, deleteing the BL");

	Step_Start(2, "after retrive the bl,go to the Customers Tab.", test, test1);
	Step_Start(3, "In Customers Tab Respective customer details has to be shown for that Bl in below grid", test, test1);

	waitForElement(driver, Customer_Tab_IMD);
	safeclick(driver, Customer_Tab_IMD);
	waitForElement(driver, Customer_Table_Header);
	Step_End(3, "In Customers Tab Respective customer details has to be shown for that Bl in below grid", test, test1);
	Step_End(2, "after retrive the bl,go to the Customers Tab.", test, test1);
	scrollBottom(driver);
	
	List<String> customers = splitAndExpand(select_customers);
	
	List<String> Customer_Code_data = splitAndExpand(Customer_Code_datas);
	List<String> customer_name_data = splitAndExpand(customer_name_datas);
	List<String> address1_data = splitAndExpand(address1_datas);
	List<String> address2_data = splitAndExpand(address2_datas);
	List<String> post_box_no_data = splitAndExpand(post_box_no_datas);
	List<String> email_data = splitAndExpand(email_datas);
	List<String> fax_data = splitAndExpand(fax_datas);
	List<String> phone_data = splitAndExpand(phone_datas);
	List<String> zip_data = splitAndExpand(zip_datas);
	List<String> country_data = splitAndExpand(country_datas);
	List<String> city_data = splitAndExpand(city_datas);
	for(int i=0;i<customers.size();i++) {
		
		String customer_code = Customer_Code_data.get(i);
		String customer_name = customer_name_data.get(i);
		String address1 = address1_data.get(i);
		String address2 = address2_data.get(i);
		String post_box_no = post_box_no_data.get(i);
		String email = email_data.get(i);
		String fax = fax_data.get(i);
		String phone = phone_data.get(i);
		String zip = zip_data.get(i);
		String country = country_data.get(i);
		String city = city_data.get(i);
		String customer_row_to_click=String.format(Select_Customer_Row_IMD, customers.get(i));
		
		Step_Start(4, "Select and  double click the consignee customer", test, test1);
		Step_Start(5, "customer details fetched in customers field", test, test1);

		waitForElement(driver, customer_row_to_click);
		doubleClick(driver, customer_row_to_click);
		
		waitForElement(driver, customer_textfield);
		if(!verifyElementHasValueAttribute(driver, customer_textfield)) {
			doubleClick(driver, customer_row_to_click);
		}
		Step_End(5, "customer details fetched in customers field", test, test1);
		Step_End(4, "Select and  double click the consignee customer", test, test1);

		Step_Start(6, "Change the customer using search field", test, test1);
		
		//1
		if(customer_code!=null&&!customer_code.trim().equals("")) {
			waitForElement(driver, Customer_Search_Button);
			click(driver, Customer_Search_Button);
			globalValueSearchWindow(driver, BL_Condition, search_by_cust_code, customer_code, CustomerCode_Select_Type2, CustomerCode_Select_Value2, CustomerCode_Select_Type3, CustomerCode_Select_Value3);
		}
		
		//2customer name
		if(customer_name!=null&&!customer_name.trim().equals("")) {
			
			waitForElement(driver, customer_name_textfield);
			clearAndType(driver, customer_name_textfield, customer_name);
		}

		// 3address1
		if (address1!=null&&!address1.trim().equals("")) {
			waitForElement(driver, Customer_Address1_TF);
			clearAndType(driver, Customer_Address1_TF, address1);
		}

		// 4address2
		if (address2!=null&&!address2.trim().equals("")) {
			waitForElement(driver, Customer_Address2_TF);
			clearAndType(driver, Customer_Address2_TF, address2);
		}

		// 5postbox number
		if (post_box_no!=null&&!post_box_no.trim().equals("")) {
			waitForElement(driver, Customer_Po_Box_No);
			clearAndType(driver, Customer_Po_Box_No, post_box_no);
		}

		// 6city
		if(city!=null&&!city.trim().equals("")) {
			waitForElement(driver, Customer_City_TF);
			clearAndType(driver, Customer_City_TF, city);
		}

		//7country
		if(country!=null&&!country.trim().equals("")) {
			waitForElement(driver, Customer_Country_Search_Button);
			click(driver, Customer_Country_Search_Button);
			twoColumnMultipleSearchWindow(driver, Country_Code_Header, condition_filter, country);
		}
		
		//8zip
		if(zip!=null&&!zip.trim().equals("")) {
			waitForElement(driver, Customer_Zip_Code);
			clear(driver, Customer_Zip_Code);
			sendKeys(driver, Customer_Zip_Code, zip);
		}
		
		//9phone
		if(phone!=null&&!phone.trim().equals("")) {
			clear(driver, Customer_Phone_TF);
			sendKeys(driver, Customer_Phone_TF, phone);
		}
			
		//10fax
		if(fax!=null&&!fax.trim().equals("")) {
			clear(driver, Customer_Fax_TF);
			sendKeys(driver, Customer_Fax_TF, fax);
		}
		//11mail
		if(email!=null&&!email.trim().equals("")) {
			clear(driver, Customer_Mail_TF);
			sendKeys(driver, Customer_Mail_TF, email);
		}
		Step_End(6, "Change the customer using search field", test, test1);

		Step_Start(7, "select the customer and add the grid.", test, test1);
		waitForElement(driver, Customer_Edit_Button);
		click(driver, Customer_Edit_Button);
		Step_End(7, "select the customer and add the grid.", test, test1);

	}
	
	scrollTop(driver);
	Step_Start(8, "click the save button in tool bar", test, test1);
	scrollTop(driver);
	waitForElement(driver, SaveButton_ToolBar);
	jsClick(driver, SaveButton_ToolBar);
	Step_End(8, "click the save button  in tool bar", test, test1);
	
	Step_Start(9, "System has popluate the validate import documentation is saved", test, test1);
	waitForPopup(driver, popup_Message, SavedPopup);
	String ImportDocumentationSaved=getText(driver, popup_Message);
	if (SavedPopup.equals(ImportDocumentationSaved)) {
		System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
		System.out.println("***Import Documentation Saved***");
		Extent_pass_New(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,	test1);

	} else {
		System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
		Extent_fail(driver, "NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved,
				test, test1);
	}
	Step_End(9, "System has popluate the validate import documentation is saved", test, test1);
	
	Step_Start(10, "Bl has saved in Import Documentation.", test, test1);
	safeclick(driver, popup_Message_Ok_Button);
	Step_End(10, "Bl has saved in Import Documentation.", test, test1);
	scrollBottom(driver);
	
	Step_Start(11, "Verify that customer code is given via Data sheet that has to verified", test, test1);
	waitForElement(driver, Customer_Table_Header);
	List<Map<String, String>> ID_Customer_Tabledata = getTableData(driver, Customer_Table_Header, Customer_Table_Row);
	List<String> print_headers = splitAndExpand(headers_to_print);
	String CustomerTableFinal=TableDataForReport(driver,ID_Customer_Tabledata,"Customer Table Data",print_headers);
	Extent_pass_New(driver, "Customer Table After update : "+CustomerTableFinal, test, test1);
	for(int i=0;i<customers.size();i++) {
		String ExpCustomerCode=Customer_Code_data.get(i);
		String Actual_CustomerType=getValueByFirstColumnAndHeader(ID_Customer_Tabledata,"Customer Type",customers.get(i),"Customer Code");
		if(ExpCustomerCode!=null&&!ExpCustomerCode.trim().equals("")) {
			if(ExpCustomerCode.equals(Actual_CustomerType)) {
				System.out.println("Matched || Expected : Given Customed code '"+ExpCustomerCode+"' should updated in the Customer Type '"+customers.get(i)+"' || Actual : Given Customer Code '"+ExpCustomerCode+"' is updated in the Customer type '"+customers.get(i)+"' ");
				Extent_pass_New(driver, "Matched || Expected : Given Customed code '"+ExpCustomerCode+"' should updated in the Customer Type '"+customers.get(i)+"' || Actual : Given Customer Code '"+ExpCustomerCode+"' is updated in the Customer type '"+customers.get(i)+"' ", test, test1);
			}else {
				System.out.println("Not Matched || Expected : Given Customed code '"+ExpCustomerCode+"' should updated in the Customer Type '"+customers.get(i)+"' || Actual : Given Customer Code '"+ExpCustomerCode+"' is not updated in the Customer type '"+customers.get(i)+"' ");
				Extent_fail(driver, "Not Matched || Expected : Given Customed code '"+ExpCustomerCode+"' should updated in the Customer Type '"+customers.get(i)+"' || Actual : Given Customer Code '"+ExpCustomerCode+"' is not updated in the Customer type '"+customers.get(i)+"' ", test, test1);
			}
		}
	}
	
	Step_End(11, "Verify that customer code is given via Data sheet that has to verified", test, test1);
	scrollTop(driver);
	Step_Start(12, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);

		waitForDisplay(driver, NewButton_ToolBar);
		if(isdisplayed(driver, NewButton_ToolBar)) {
			System.out.println("Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  New button Should be displayed in the Toolbar ||  Actual : New button is not displayed in the Toolbar", test, test1);
		}
		
		if(isdisplayed(driver, SearchButton_Toolbar)) {
			System.out.println("Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  Search button Should be displayed in the Toolbar ||  Actual : Search button is not displayed in the Toolbar", test, test1);
		}
		
		if(isdisplayed(driver, Edit_Button_toolBar)) {
			System.out.println("Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  Edit button Should be displayed in the Toolbar ||  Actual : Edit button is not displayed in the Toolbar", test, test1);
		}
		
	    if(isdisplayed(driver, Delete_button_toolBar)) {
	    	System.out.println("Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is displayed in the Toolbar");
			Extent_pass_New(driver, "Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is displayed in the Toolbar", test, test1);
		}else {
			System.out.println("Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is not displayed in the Toolbar");
			Extent_fail(driver, "Expected Result :  Delete button Should be displayed in the Toolbar ||  Actual : Delete button is not displayed in the Toolbar", test, test1);
		}
		Step_End(12, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);

		Step_Start(13, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(14, "click the yes and system has validate import dcoumentation is deleted", test, test1);

		if(do_you_want_to_delete.equalsIgnoreCase("yes")) {
			deleteImportDocument(driver, delete_confirmation_popup, deleted_popup_expected);
		}
		Step_End(14, "click the yes and system has validate import dcoumentation is deleted", test, test1);
		Step_End(13, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);

		Extent_completed(testcase_Name, test, test1);
	}
}
