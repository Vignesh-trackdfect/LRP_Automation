package LRP_Cost_Scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
public class TC_Cost_Activity_Report_TS064 extends Keywords {

	public void Cost_Activity_Report_TS064(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS064";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Agency = Excel_data.get("Agency");
		String Service_Tax_Module = Excel_data.get("Service_Tax_Module");
		String Contract_Type_Service_Tax = Excel_data.get("Contract_Type_Service_Tax");
		String Contract_Type_Code_Headers = Excel_data.get("Contract_Type_Code_Headers");
		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String Valid_From_Date_STax = Excel_data.get("Valid_From_Date_STax");
		String Valid_To_Date_STax = Excel_data.get("Valid_To_Date_STax");
		String Port_Filter_Header_STax = Excel_data.get("Port_Filter_Header_STax");
		String Port_Code_Value_STax = Excel_data.get("Port_Code_Value_STax");
		String Terminal_Filter_Header_STax = Excel_data.get("Terminal_Filter_Header_STax");
		String Terminal_Value_STax = Excel_data.get("Terminal_Value_STax");
		String Activity_Code_Service_Tax = Excel_data.get("Activity_Code_Service_Tax");
		String Type_Of_Tax_Values = Excel_data.get("Type_Of_Tax_Values");
		String Charge_Type_Values = Excel_data.get("Charge_Type_Values");
		String Percentage_Values = Excel_data.get("Percentage_Values");
		String Service_Created_Popup = Excel_data.get("Service_Created_Popup");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String Select_Contract_type_Value = Excel_data.get("Select_Contract_type_Value");
		String Select_Mode_type = Excel_data.get("Select_Mode_type");
		String Service_Header = Excel_data.get("Service_Header");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String Port_Header = Excel_data.get("Port_Header");
		String Terminal_Header = Excel_data.get("Terminal_Header");
		String Arrival_Date_Header = Excel_data.get("Arrival_Date_Header");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Arrival_Date_Value = Excel_data.get("Arrival_Date_Value");
		String CAR_Already_Created = Excel_data.get("CAR_Already_Created");
		String Activities_Add_CAR = Excel_data.get("Activities_Add_CAR");
		String Activity_Header_CAR = Excel_data.get("Activity_Header_CAR");
		String EqpType = Excel_data.get("EqpType");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Amount = Excel_data.get("Amount");
		String Quantity = Excel_data.get("Quantity");
		String EqpType_Filter_Header = Excel_data.get("EqpType_Filter_Header");
		String VendorCode_Filter_Header = Excel_data.get("VendorCode_Filter_Header");
		String CAR_Activity_Saved_Popup = Excel_data.get("CAR_Activity_Saved_Popup");
		String MSC_CAR_Table_Headers = Excel_data.get("MSC_CAR_Table_Headers");

		String Want_To_Delete_CAR = Excel_data.get("Want_To_Delete_CAR");
		String Service_Tax_SearchType = Excel_data.get("Service_Tax_SearchType");
		String Service_Tax_Search_Condition = Excel_data.get("Service_Tax_Search_Condition");

		
		Extent_Start(tc_Name, test, test1);

		Step_Start(1,"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		SwitchProfile(driver, Agency);

		Step_End(1,"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		moduleNavigate(driver, Service_Tax_Module);
		
		waitForElement(driver, Type_Search_CAR);
		click(driver, Type_Search_CAR);

		twoColumnSearchWindow(driver, Contract_Type_Code_Headers, Two_Column_Condition, Contract_Type_Service_Tax);

		waitForElement(driver, TaxDate_CAR);
		selectDatePicker(driver, TaxDate_CAR, Valid_From_Date_STax);

		waitForElement(driver, Tax_ValidTo_CAR);
		selectDatePicker(driver, Tax_ValidTo_CAR, Valid_To_Date_STax);

		waitForElement(driver, Tax_Port_Search_CAR);
		click(driver, Tax_Port_Search_CAR);

		twoColumnSearchWindow(driver, Port_Filter_Header_STax, Two_Column_Condition, Port_Code_Value_STax);

		if(!Terminal_Value_STax.trim().equals("")) {
			if (IsElementEnabled(driver, Tax_Terminal_Search_CAR)) {
				waitForElement(driver, Tax_Terminal_Search_CAR);
				click(driver, Tax_Terminal_Search_CAR);
				twoColumnSearchWindow(driver, Terminal_Filter_Header_STax, Two_Column_Condition, Terminal_Value_STax);
			}
		}
		
		waitForElement(driver, Tax_Show_CAR);
		click(driver, Tax_Show_CAR);
		
		List<String>  ActivityCodes=splitAndExpand(Activity_Code_Service_Tax,",");
		List<String> Tax_Type_List=splitAndExpandNew(Type_Of_Tax_Values,"|");
		List<String> Charge_Type_List=splitAndExpandNew(Charge_Type_Values,"|");
		List<String> Percentage_List=splitAndExpandNew(Percentage_Values,"|");

		Map<String,List<String>> TypofTax_details=new HashMap<String, List<String>>();
		Map<String,List<String>> Charge_details=new HashMap<String, List<String>>();
		Map<String,List<String>> Percentage_details=new HashMap<String, List<String>>();

		for(int i=0;i<ActivityCodes.size();i++) {
			String ActCode=ActivityCodes.get(i);
			List<String> taxList=splitAndExpand(Tax_Type_List.get(i),",");
			List<String> ChargeList=splitAndExpand(Charge_Type_List.get(i),",");
			List<String> PercentList=splitAndExpand(Percentage_List.get(i),",");
			TypofTax_details.put(ActCode, taxList);
			Charge_details.put(ActCode, ChargeList);
			Percentage_details.put(ActCode, PercentList);
		}

		waitForElement(driver, ServiceTax_Count);
		String totalcount = getText(driver, ServiceTax_Count);
		 
		for (int i = 0; i < ActivityCodes.size(); i++) {
			
			String Activity_Code_Exp=ActivityCodes.get(i);
			String gridcolumn = String.format(Activity_Code_STax, Activity_Code_Exp);
			
			waitForElement(driver, gridcolumn);
			click(driver,gridcolumn);
			RightClick(driver,gridcolumn);
				
			waitForElement(driver, CreateTax_CAR);
			click(driver, CreateTax_CAR);
			
			List<String> Tax_val=TypofTax_details.get(Activity_Code_Exp);
			List<String> Charge_val=Charge_details.get(Activity_Code_Exp);
			List<String> Percentage_val=Percentage_details.get(Activity_Code_Exp);

			for(int k=0;k<Tax_val.size();k++) {
				if(k!=0) {
					waitForElement(driver, New_tax_button);
					click(driver,New_tax_button);
				}
				
				waitForElement(driver, Tax_Show_CAR);
				String TypeTax_Input=String.format(Type_Of_Tax_Input, k);
				jsClick(driver, TypeTax_Input);

				String giventax = Tax_val.get(k);
				String givenCharge=Charge_val.get(k);
				String Percent=Percentage_val.get(k);
				
				String TypeofTax_Option = String.format(DropDown_Select, giventax);
				waitForElement(driver, TypeofTax_Option);
				click(driver, TypeofTax_Option);

				waitForElement(driver, Tax_Show_CAR);
				String ChargeInput=String.format(Charge_Type_Input_ServiceTax, k);
				jsClick(driver, ChargeInput);

				String ChargeTypes_Option = String.format(DropDown_Select, givenCharge);
				waitForElement(driver, ChargeTypes_Option);
				click(driver, ChargeTypes_Option);

				if (givenCharge.equalsIgnoreCase("Percentage")) {

					waitForElement(driver, Tax_Show_CAR);
					String percentColumn=String.format(Percentage_Column_STax, k);
					jsClick(driver, percentColumn);

					String percentInputColumn=String.format(Percentage_Input_Colum_STax, k);
					sendKeysUsingActions(driver, percentInputColumn, Percent);
				}

				waitForElement(driver, Tax_Show_CAR);
				String Act_Port_Column=String.format(Activity_Column_STax, k);
				jsClick(driver, Act_Port_Column);
				String ActivityOption = String.format(DropDown_Select, Activity_Code_Exp);
				waitForDisplay(driver, ActivityOption);
				if(!isdisplayed(driver, ActivityOption)) {
					jsClick(driver, Act_Port_Column);
				}
				waitForElement(driver, ActivityOption);
				click(driver, ActivityOption);

				waitForElement(driver, Tax_Show_CAR);
				jsClick(driver, TypeOfTax_CAR);
				
			}
			waitForElement(driver, ApplyTax_CAR);
			click(driver, ApplyTax_CAR);
			
			Actions action=new Actions(driver);
			action.keyDown(Keys.CONTROL).build().perform();
			waitForElement(driver, gridcolumn);
			click(driver,gridcolumn);
			action.keyUp(Keys.CONTROL).build().perform();

		}
		
		boolean Removecolumn=false;
		
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		
		for (int i = 0; i < Integer.parseInt(totalcount); i++) {
			String gridcolumn = String.format(ServiceTax_Grid, i);
			waitForElement(driver, gridcolumn);
			String actvitycode = getText(driver, gridcolumn);
			
			if(!ActivityCodes.contains(actvitycode)) {
				click(driver,gridcolumn);
				Removecolumn=true;
			}
			
		}
		action.keyUp(Keys.CONTROL).build().perform();
		
		if(Removecolumn==true) {
			RightClick(driver, Activity1);
			waitForElement(driver, RemoveTax);
			click(driver,RemoveTax);
		}
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Service_Created_Popup);
		String savedpopupMessage = getText(driver, popup_Message);

		if (savedpopupMessage.equals(Service_Created_Popup)) {
			System.out.println("Popup Matched || Expected : "+Service_Created_Popup+" || Actual : "+savedpopupMessage);
			Extent_pass_New(driver, "Popup Matched || Expected : "+Service_Created_Popup+" || Actual : "+savedpopupMessage, test, test1);
		} else {
			System.out.println("Popup Not Matched || Expected : "+Service_Created_Popup+" || Actual : "+savedpopupMessage);
			Extent_fail(driver, "Popup Not Matched || Expected : "+Service_Created_Popup+" || Actual : "+savedpopupMessage, test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, STXNo_CAR);
		String Tx_no = getAttribute(driver, STXNo_CAR, "value");
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		moduleNavigate(driver, Cost_Activity_Report_Module);

		waitForElement(driver, Contract_type);
		click(driver, Contract_type);
		formatLocatorClick(driver, DropDown_Select, Select_Contract_type_Value);

		waitForElement(driver, Select_Mode);
		click(driver, Select_Mode);
		formatLocatorClick(driver, DropDown_Select, Select_Mode_type);

		waitForElement(driver, Service_Search_Btn_CAR);
		click(driver,Service_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Service_Header,Two_Column_Condition,Service_Code);
		
		waitForElement(driver, Vessel_Search_Btn_CAR);
		click(driver,Vessel_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Vessel_Header,Two_Column_Condition,Vessel_Code);
		
		waitForElement(driver, Port_Search_Btn_CAR);
		click(driver,Port_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Port_Header,Two_Column_Condition,Port_Code);
		
		waitForElement(driver, Terminal_Search_Btn_CAR);
		click(driver,Terminal_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Terminal_Header,Two_Column_Condition,Terminal_Code);
		
		
		waitForElement(driver, Arrival_Date_Search_Btn_CAR);
		click(driver,Arrival_Date_Search_Btn_CAR);
		twoColumnSearchWindow(driver,Arrival_Date_Header,Two_Column_Condition,Arrival_Date_Value);

		waitForElement(driver, Show_Button_CAR);
		click(driver,Show_Button_CAR);
		
		if(isdisplayed(driver, popup_Message)) {
			String popup_Act=getText(driver, popup_Message);
			if(CAR_Already_Created.equals(popup_Act)) {
				System.out.println("Expected : CAR should not Already Created for the given inputs || Actual : CAR Already created for the given inputs");
				Extent_FailNew(driver, "Expected : CAR should not Already Created for the given inputs || Actual : CAR Already created for the given inputs", test, test1);
			}else {
				System.out.println("Expected : Popup Should not Displayed when click the CAR Show button || Actual : Popup displayed When click the CAR Show button , Error : "+popup_Act );
				Extent_fail(driver, "Expected : Popup Should not Displayed when click the CAR Show button || Actual : Popup displayed When click the CAR Show button , Error : "+popup_Act , test, test1);
			}
		}
		
		waitForElement(driver, ADD_button_MSC_CAR);
		click(driver, ADD_button_MSC_CAR);
		
		twoColumnSearchWindowMultipleValue(driver,Activity_Header_CAR,Two_Column_Condition,Activities_Add_CAR);
		elementnotvisible1(driver, select_Button);
		List<String> Activities=splitAndExpand(Activities_Add_CAR);
		for(String act:Activities) {
			String UpdatedActivity=String.format(MSC_table_Activity_Column_CAR_New, act);
			if(isDisplayed(driver, UpdatedActivity)) {
				System.out.println("Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is Updated in the Table");
				Extent_pass_New(driver, "Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is Updated in the Table", test, test1);
			}else {
				System.out.println("Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is not Updated in the Table");
				Extent_fail(driver, "Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is not Updated in the Table", test, test1);
			}
		}
		
		List<String> EqpTypeList=splitAndExpand(EqpType);
		List<String> QuantityList=splitAndExpand(Quantity);
		List<String> Vendor_Code_List=splitAndExpand(Vendor_Code);
		List<String> Amount_List=splitAndExpand(Amount);
		
		for(int i=0;i<Activities.size();i++) {
			String UpdatedActivityQuantColumn=String.format(MSC_table_Quantity_Column_CAR_New, Activities.get(i));
			waitForElement(driver, UpdatedActivityQuantColumn);
			doubleClick(driver, UpdatedActivityQuantColumn);
			
			String UpdatedActivityQuan=String.format(MSC_table_Quantity_input_CAR_New, Activities.get(i));
			waitForElement(driver, UpdatedActivityQuan);
			sendKeys(driver, UpdatedActivityQuan, QuantityList.get(i));
			
			formatLocatorClick(driver, MSC_table_Activity_Column_CAR_New, Activities.get(i));
			
			waitForElement(driver, MSC_Equipment_Type_Button_CAR);
			click(driver,MSC_Equipment_Type_Button_CAR);

			twoColumnSearchWindow(driver,EqpType_Filter_Header,Two_Column_Condition,EqpTypeList.get(i));

			String Selected_EqpType=String.format(MSC_Table_EqpType_Column_CAR_New, Activities.get(i));
			waitForElement(driver, Selected_EqpType);
			String Updated_EpqType=getText(driver, Selected_EqpType);
			if(Updated_EpqType.equals(EqpTypeList.get(i))) {
				System.out.println("Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is updated Correctly in the Table");
				Extent_pass_New(driver, "Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is updated Correctly in the Table", test, test1);
			}else {
				System.out.println("Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is not updated Correctly in the Table");
				Extent_fail(driver, "Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is not updated Correctly in the Table", test, test1);
			}
			
			waitForElement(driver, MSC_Vendor_Code_Button_CAR);
			click(driver,MSC_Vendor_Code_Button_CAR);

			twoColumnSearchWindow(driver,VendorCode_Filter_Header,Two_Column_Condition,Vendor_Code_List.get(i));

			String Selected_VendorCode=String.format(MSC_Table_Vendor_Code_Column_CAR_New, Activities.get(i));
			waitForElement(driver, Selected_VendorCode);
			String Updated_VendorCode=getText(driver, Selected_VendorCode);
			if(Updated_VendorCode.equals(Vendor_Code_List.get(i))) {
				System.out.println("Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is updated Correctly in the Table");
				Extent_pass_New(driver, "Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is updated Correctly in the Table", test, test1);
			}else {
				System.out.println("Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is not updated Correctly in the Table");
				Extent_fail(driver, "Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is not updated Correctly in the Table", test, test1);
			}
			
			String Activity_Amount_Col=String.format(MSC_Table_Amount_Column_CAR_New, Activities.get(i));
			waitForElement(driver, Activity_Amount_Col);
			doubleClick(driver,Activity_Amount_Col);
			
			String Activity_Amount_Input=String.format(MSC_Table_Amount_Input_CAR_New, Activities.get(i));
			System.out.println("Amount_List : "+Amount_List.get(i));
			waitForElement(driver, Activity_Amount_Input);
			clear(driver,Activity_Amount_Input);
			waitForElement(driver, Activity_Amount_Input);
			sendKeys(driver, Activity_Amount_Input,Amount_List.get(i));
		    
			formatLocatorClick(driver, MSC_table_Activity_Column_CAR_New, Activities.get(i));
		}
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, CAR_Activity_Saved_Popup);
		String SavePopupmessage = getText(driver, popup_Message);

		if (SavePopupmessage.equals(CAR_Activity_Saved_Popup)) {
			System.out.println("Popup Matched || Expected : " + CAR_Activity_Saved_Popup + " || Actual : " + SavePopupmessage);
			Extent_pass_New(driver,"Popup Matched  || Expected : " + CAR_Activity_Saved_Popup + " || Actual : " + SavePopupmessage, test,
					test1);
		} else {
			System.out.println("Popup Not Matched  || Expected : " + CAR_Activity_Saved_Popup + " || Actual : " + SavePopupmessage);
			Extent_fail(driver,"Popup Not Matched  || Expected : " + CAR_Activity_Saved_Popup + " || Actual : " + SavePopupmessage,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		waitForElement(driver, Tool_Pannel_TF_CAR);
		click(driver,Tool_Pannel_TF_CAR);
		
		waitForElement(driver, FilterOption_Menu);
		click(driver,FilterOption_Menu);
		
		waitForElement(driver,Filterd_Rows_Misc_Grid_CAR);
		reArrangeAG_GridColumns(driver,MSC_CAR_Table_Headers);
		
		for(String act:ActivityCodes) {
			waitForElement(driver, activity_Code_Filter_CAR);
			Newclear(driver, activity_Code_Filter_CAR);
			sendKeys(driver, activity_Code_Filter_CAR, act);
			
			waitForElement(driver, Service_Tax_Filter_Input);
			Newclear(driver, Service_Tax_Filter_Input);
			sendKeys(driver, Service_Tax_Filter_Input, Tx_no);
			
			if(isdisplayed(driver, Filterd_Rows_Misc_Grid_CAR)) {
				System.out.println("Expected : Service Tax '"+Tx_no+"' Should Automatically applied for the Activity '"+act+"' || Actual : Service Tax '"+Tx_no+"' automatically Applied for the Activity "+act);
				Extent_pass_New(driver, "Expected : Service Tax '"+Tx_no+"' Should Automatically applied for the Activity '"+act+"' || Actual : Service Tax '"+Tx_no+"' automatically Applied for the Activity "+act, test, test1);
			}else {
				System.out.println("Expected : Service Tax '"+Tx_no+"' Should Automatically applied for the Activity '"+act+"' || Actual : Service Tax '"+Tx_no+"' not automatically Applied for the Activity "+act);
				Extent_fail(driver, "Expected : Service Tax '"+Tx_no+"' Should Automatically applied for the Activity '"+act+"' || Actual : Service Tax '"+Tx_no+"' not automatically Applied for the Activity "+act, test, test1);
			}
		}
		

		if(Want_To_Delete_CAR.equals("Yes")) {
			
			waitForElement(driver, Delete_button_toolBar);
			click(driver,Delete_button_toolBar);
			
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver,popup_Message_Yes_Button);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
			moduleNavigate(driver, Service_Tax_Module);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver,SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, Service_Tax_Search_Condition, Service_Tax_SearchType,Tx_no,"","","","" );
			
			waitForElement(driver, Delete_button_toolBar);
			click(driver,Delete_button_toolBar);
			
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver,popup_Message_Yes_Button);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
		}

		Extent_completed(tc_Name, test, test1);

		
	}
}
