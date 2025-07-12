package LRP_Commercial_Rate_Request_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Rate_Request_SC17 extends Keywords {

	public void Rate_Request_SC17(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name="TC_Rate_Request_SC17";
		
		
		





		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Field_Names = Excel_data.get("ModuleName");
		String Cust_Code_New = Excel_data.get("Cust_Code_New");
		String Origin1 = Excel_data.get("Origin1");
		String Delivery1 = Excel_data.get("Delivery1");
		String Commodity1 = Excel_data.get("Commodity1");
		String Eqp_type1 = Excel_data.get("Eqp_type1");
		String GrossWeight1 = Excel_data.get("GrossWeight1");
		String Exp_Detention_Days1 = Excel_data.get("Exp_Detention_Days1");
		String Exp_Demurrage1 = Excel_data.get("Exp_Demurrage1");
		String Imp_Detention_Days1 = Excel_data.get("Imp_Detention_Days1");
		String Imp_Demurrage1 = Excel_data.get("Imp_Demurrage1");
		String Ofr_Value2 = Excel_data.get("Ofr_Value2");
		String submit_msg = Excel_data.get("submit_msg");
		String ModuleName1 = Excel_data.get("ModuleName1");
		String status_value = Excel_data.get("status_value");
		String Non_Containerized = Excel_data.get("Non_Containerized");
		String DG_checkboxs = Excel_data.get("DG_checkboxs");
		String NOR_checkbox = Excel_data.get("NOR_checkbox");
		String SOC_checkbox = Excel_data.get("SOC_checkbox");
		String OOG_checkbox = Excel_data.get("OOG_checkbox");
		String location_code = Excel_data.get("location_code");
		String Customer_Code = Excel_data.get("Cust_code");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Condition_Value = Excel_data.get("Condition_Value");
		String From_Date_Input =Excel_data.get("From_Date_Input");
		String datePicker =Excel_data.get("datePicker");
		String To_Date_Input =Excel_data.get("To_Date_Input");
		
		String Eqp_Quantity_Input = Excel_data.get("Eqp_Quantity_Input");
		String Routing_Service = Excel_data.get("Routing_Service");
		String	Pre_Carriage_Radiobtn = Excel_data.get("pre_Carriage_Radiobtn");
		String	On_Carriage_Radiobtn = Excel_data.get("On_Carriage_Radiobtn");
		String do_You_Want_Delete = Excel_data.get("Do_You_Want_Delete").trim();
		String	tService=Excel_data.get("T_Service");
		String	TOS=Excel_data.get("TOS_Option");
		String Rate_Request_NO=Excel_data.get("Rate_Request_NO");
		String search_type2=Excel_data.get("search_type2");
		String input2=Excel_data.get("input2");
		String search_type3=Excel_data.get("search_type3");
		String input3=Excel_data.get("input3");
		String date_Perform = Excel_data.get("date_Perform");
		String Flexi_CheckBox = Excel_data.get("Flexi_CheckBox");
		String MTY_CheckBox = Excel_data.get("MTY_CheckBox");
		String payment_Mode = Excel_data.get("payment_Mode");
		String Select_type_location = Excel_data.get("Select_type_location");
		String condition = Excel_data.get("condition");
		String payLocation =Excel_data.get("payLocation");

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, username, password);

		SwitchProfile(driver, location_code);

		moduleNavigate(driver, Field_Names);
		waitForElement(driver, Requet_Type);
newButton(driver);
		if(!tService.equals("")) {
			waitForElement(driver, tService_Dropdown);
			click(driver, tService_Dropdown);
			formatLocatorClick(driver, DropDown_Select, tService);
		}
		if(!TOS.equals("")) {
			waitForElement(driver, RR_TOS_Dropdown);
			click(driver, RR_TOS_Dropdown);
			formatLocatorClick(driver, DropDown_Select, TOS);
		}
		// Selecting the From Date


		Extent_call(test, test1, "Selecting the FROM DATE");
		rateRequestDateSelect(driver, date_Perform, datePicker, From_Date_Input, To_Date_Input);

		// non containerized radio btn

		if (Non_Containerized.equalsIgnoreCase("YES")) {
			waitForElement(driver, non_containradio_btn);
			safeclick(driver, non_containradio_btn);
		}


		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);

		globalValueSearchWindow(driver, Condition_Value, Customer_Code, Customer_code_Value, search_type2, input2,search_type3, input3);

			rateRequestCustomerExistOption(driver);


			System.out.println("Cust Name Entered");

			waitForElement(driver, Cust_NameInput);
			String Customer= getAttribute(driver, Cust_NameInput, "value");
			System.out.println(Customer);
			waitForElement(driver, Orgin_Input);  
			click(driver, Orgin_Input);
			Actionsendkeys(driver, Orgin_Input, Origin1);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);


			waitForElement(driver, RR_Delivery_Input);
			sendKeys(driver, RR_Delivery_Input, Delivery1);

			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			waitForElement(driver, Commodity_Input);
			Newclear(driver, Commodity_Input);
		Actionsendkeys(driver, Commodity_Input, Commodity1);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			waitForElement(driver, Eqp_Type);
			click(driver, Eqp_Type);
			sendKeys(driver, Eqp_Type, Eqp_type1);
			waitForElement(driver, Eqp_Type_Value);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			waitForElement(driver, Eqp_Quantity);
			click(driver, Eqp_Quantity);
			Newclear(driver, Eqp_Quantity);
			Actionsendkeys(driver, Eqp_Quantity,Eqp_Quantity_Input );
			waitForElement(driver, RR_Gross_Weight);
			click(driver, RR_Gross_Weight);
			Newclear(driver, RR_Gross_Weight);
			Actionsendkeys(driver, RR_Gross_Weight, GrossWeight1);


			//checkboxs


			checkBox(driver, DG_checkbox, DG_checkboxs);

			checkBox(driver, oog_checkbox, OOG_checkbox);

			checkBox(driver, nor_checkbox, NOR_checkbox);
			waitForDisplay(driver, flexi_Checkbox_RR);
			if(isdisplayed(driver, flexi_Checkbox_RR)) {
				checkBox(driver, flexi_Checkbox_RR, Flexi_CheckBox);
			}
			waitForDisplay(driver, empty_Checkbox_RR);
			if(isdisplayed(driver, empty_Checkbox_RR)) {
				checkBox(driver, empty_Checkbox_RR, MTY_CheckBox);
			}

			checkBox(driver, soc_checkbox, SOC_checkbox);

			//Pre Carriage radio btn
			if(!Pre_Carriage_Radiobtn.equals("")) {
				formatLocatorClick(driver, pre_Carriage_Radiobtn, Pre_Carriage_Radiobtn);
			}
			if(!On_Carriage_Radiobtn.equals("")) {
				formatLocatorClick(driver, on_Carriage_Radiobtn, On_Carriage_Radiobtn);
			}

			rateRequestRoutingDays(driver, Exp_Detention_Days1, Imp_Detention_Days1, Exp_Demurrage1, Imp_Demurrage1);

			waitForElement(driver, Routing_Button);
			click(driver, Routing_Button);

			waitForElement(driver, routingSearch_Frame);
			String actRoutingFrame=getText(driver, routingSearch_Frame);
			if(isDisplayed(driver, routingSearch_Frame)) {
				Extent_pass_New(driver, actRoutingFrame+" is displayed", test,test1);
				System.out.println(actRoutingFrame+" is displayed");
				waitForElement(driver, Routing_ToolPannel);
				safeclick(driver, Routing_ToolPannel);
				waitForElement(driver, Routing_condition_Filter);
				safeclick(driver, Routing_condition_Filter);
				waitForElement(driver, Routing_OriginTF);
				sendKeys(driver, Routing_OriginTF, Origin1);
				waitForElement(driver, Routing_service_TF);
				sendKeys(driver, Routing_service_TF, Routing_Service);
				doubleClick(driver, select_First_Routing);

			}else {
				Extent_fail(driver, actRoutingFrame+" is not displayed", test,test1);
				System.out.println(actRoutingFrame+" is not displayed");
			}


			rateRequestPaymentMode_Select(driver, payment_Mode,Select_type_location, condition, payLocation);

			waitForElement(driver, OFR_Txt_Field);
			click(driver, OFR_Txt_Field);
			clear(driver, OFR_Txt_Field);
			sendKeys(driver, OFR_Txt_Field, Ofr_Value2);
			System.out.println("OFR Value:"+Ofr_Value2);
			click(driver, Rate_AddBtn);


			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			waitForPopup(driver, Rate_Sub_Popup_Msg, submit_msg);
			String SaveRate_PopUp4= getText(driver, Rate_Sub_Popup_Msg);
			if(submit_msg.equals(SaveRate_PopUp4)) {
				System.out.println("Matched || Expected value was : "+submit_msg+" || Actual value was : "+SaveRate_PopUp4);
				Extent_pass_New(driver, "Matched || Expected value was : "+submit_msg+" || Actual value was : "+SaveRate_PopUp4, test,test1);
				waitForElement(driver, Rate_SubmitBtn);
				click(driver, Rate_SubmitBtn);
				System.out.println("Submit button clicked");
			}
			else {
				System.out.println("NotMatched || Expected value was : "+submit_msg+" || Actual value was : "+SaveRate_PopUp4);
				Extent_fail(driver,  "NotMatched || Expected value was : "+submit_msg+" || Actual value was : "+SaveRate_PopUp4, test,test1);
			}


			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			System.out.println("Rate Request saved");

			waitForDisplay(driver, Mail_Cancel_button);
		if(isdisplayed(driver, Mail_Cancel_button)) {
		click(driver, Mail_Cancel_button);
		}

			waitForElement(driver, status_Field);

			String status4=getAttribute(driver, status_Field, "value");
			if(status4.equals(status_value)) {
				System.out.println("Rate Request Submitted");
				System.out.println("Matched || Expected value was : "+status_value+" || Actual value was : "+status4);
				Extent_pass_New(driver, "Matched || Expected value was : "+status_value+" || Actual value was : "+status4, test,test1);
			}
			else {
				System.out.println("NotMatched || Expected value was : "+status_value+" || Actual value was : "+status4);
				Extent_fail(driver,  "NotMatched || Expected value was : "+status_value+" || Actual value was : "+status4, test,test1);
			}


			String Value4=getAttribute(driver, reqNo_Textfield, "value");
			System.out.println(Value4);



			//1   
			Step_Start(1, "Click on the search icon in the toolbar", test, test1);


			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver,Condition_Value,Rate_Request_NO,Value4,"","","","");


			Step_End(1, "Click on the search icon in the toolbar", test, test1);


			Step_Start(2, "Click save as icon in the toolbar", test, test1);

			waitForElement(driver, SaveAs_button_toolBar);
			click(driver, SaveAs_button_toolBar);

			Step_End(2, "Click save as icon in the toolbar", test, test1);


			Step_Start(3, "Click yes to enable the rate request in save as mode", test, test1);


			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);


			Step_End(3, "Click yes to enable the rate request in save as mode", test, test1);

			Step_Start(4, "Change the customer in the customer field", test, test1);


			waitForElement(driver, Customer_Name_search_button);
			click(driver, Customer_Name_search_button);

			globalValueSearchWindow(driver, Condition_Value, Customer_Code, Cust_Code_New, search_type2, input2, search_type3, input3);
			rateRequestCustomerExistOption(driver);

			Step_End(4, "Change the customer in the customer field", test, test1);


			Step_Start(5, "Click Save button in the tool bar", test, test1);

			waitForElement(driver,SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar); 

			Step_End(5, "Click Save button in the tool bar", test, test1);

			Step_Start(6, "Click submit", test, test1);

			waitForElement(driver, Rate_SubmitBtn);
			click(driver, Rate_SubmitBtn);

			Step_End(6, "Click submit", test, test1);

			Step_Start(7, "Click Ok", test, test1);

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			waitForDisplay(driver, mail_Cancel_Button);
			if(isdisplayed(driver, mail_Cancel_Button)) {
				click(driver, mail_Cancel_Button);
			}
			waitForElement(driver, reqNo_Textfield);
			String Value=getAttribute(driver, reqNo_Textfield, "value");
			System.out.println(Value);
			Step_End(7, "Click Ok", test, test1);


			waitForElement(driver, Cust_NameInput);
			String New_Customer= getAttribute(driver, Cust_NameInput, "value");
			if(!Customer.equals(New_Customer)) {
				System.out.println("Rate Request Submitted");
				System.out.println("Matched || Expected value was : "+Customer+" || Actual value was : "+New_Customer);
				Extent_pass_New(driver, "Matched || Expected value was : "+Customer+" || Actual value was : "+New_Customer, test,test1);
			}
			else {
				System.out.println("NotMatched || Expected value was : "+Customer+" || Actual value was : "+New_Customer);
				Extent_fail(driver,  "NotMatched || Expected value was : "+Customer+" || Actual value was : "+New_Customer, test,test1);
			}
			Extent_call(test, test1, "Rate request delete starts");

			if(do_You_Want_Delete.equalsIgnoreCase("yes")) {
				Extent_call(test, test1, "Rate request delete starts");
				waitForElement(driver,Close_Current_tab);
				click(driver, Close_Current_tab);

				moduleNavigate(driver, ModuleName1);

				//SRR Gate
				waitForElement(driver, SRR_Req_Type);
				click(driver, SRR_Req_Type);

				waitForElement(driver, All_Req_Type);
				click(driver, All_Req_Type);

				waitForElement(driver, SRR_Refresh_Btn);
				click(driver, SRR_Refresh_Btn);

				waitForElement(driver, submit_RadioButton);
				click(driver, submit_RadioButton);

				waitForElement(driver, menu_Icon_Grid);
				click(driver, menu_Icon_Grid);

				waitForElement(driver, filter_Icon_Grid);
				click(driver, filter_Icon_Grid);

				waitForElement(driver, filter_Inputfield);
				click(driver, filter_Inputfield);
				sendKeys(driver, filter_Inputfield, Value4);
				enter(driver);

				waitForElement(driver, select_Actual_ReqNo);
				String submitted_ReqNum1=getText(driver, select_Actual_ReqNo);
				if(submitted_ReqNum1.equals(Value4)) {
					System.out.println("Matched || " + " Expected Value is : " + Value4 + " || Actual Value is : " + submitted_ReqNum1);
					Extent_pass_New(driver,"Matched || " + " Expected Value is : " + Value4 + " || ActualValue is : " + submitted_ReqNum1,test,test1);
					Extent_pass_New(driver, Value4+"  is submitted", test,test1);
					System.out.println(Value4+" is submitted");
					waitForElement(driver, select_Actual_ReqNo);
					click(driver, select_Actual_ReqNo);
					waitForElement(driver, select_Actual_ReqNo);
					RightClick(driver, select_Actual_ReqNo);
					waitForElement(driver, moveTo_Pending);
					click(driver, moveTo_Pending);
					waitForElement(driver, close_Moved_Pending_Popup);
					click(driver, close_Moved_Pending_Popup);
				}else {
					System.out.println("Not matched || " + " Expected Value is : " + Value4 + " || Actual Value  is : " + submitted_ReqNum1);
					System.out.println(Value4+" is not submitted");
					Extent_fail(driver,"Not matched || " + " Expected Value is : " + Value4 + " || Actual Value is : " + submitted_ReqNum1,test,test1);
				}		
				//Pending	
				waitForElement(driver, pending_RadioButton);
				click(driver, pending_RadioButton);

				waitForElement(driver, menu_Icon_Grid);
				click(driver, menu_Icon_Grid);

				waitForElement(driver, filter_Icon_Grid);
				click(driver, filter_Icon_Grid);

				waitForElement(driver, filter_Inputfield);
				click(driver, filter_Inputfield);
				sendKeys(driver, filter_Inputfield, Value4);
				enter(driver);

				waitForElement(driver, select_Actual_ReqNo);
				String pending_ReqNum1=getText(driver, select_Actual_ReqNo);
				if(pending_ReqNum1.equals(Value4)) {
					System.out.println("Matched || " + " Expected Value is : " + Value4 + " || Actual Value is : " + pending_ReqNum1);
					Extent_pass_New(driver,"Matched || " + " Expected Value is : " + Value4 + " || ActualValue is : " + pending_ReqNum1,test,test1);

					waitForElement(driver, select_Actual_ReqNo);
					click(driver, select_Actual_ReqNo);
					waitForElement(driver, select_Actual_ReqNo);
					doubleClick(driver, select_Actual_ReqNo);	

					//added
					waitForElement(driver, cancel_Common_btn);
					click(driver, cancel_Common_btn);
					waitForElement(driver, SearchButton_Toolbar);
					click(driver, SearchButton_Toolbar);
					globalValueSearchWindow(driver, Condition_Value,Rate_Request_NO,submitted_ReqNum1,"", "", "","");


					waitForElement(driver, Delete_button_toolBar);
					click(driver, Delete_button_toolBar);
					waitForElement(driver, delete_Request_Popup);
					click(driver, delete_Request_Popup_Ok);

					waitForElement(driver, comment_Ok_Button);
					click(driver, comment_Ok_Button);
					waitForElement(driver, Delete_button_toolBar);

					Extent_pass_New(driver, Value4+"  is Deleted", test,test1);
					System.out.println(Value4+" is Deleted");
				}else {
					System.out.println("Not matched || " + " Expected Value is : " + Value4 + " || Actual Value  is : " + pending_ReqNum1);
					System.out.println(Value4+" is not Deleted");
					Extent_fail(driver,"Not matched || " + " Expected Value is : " + Value4 + " || Actual Value is : " + pending_ReqNum1,test,test1);
					Extent_fail(driver, Value4+" is not Deleted", test,test1);
				}	
				Extent_call(test, test1, "Rate request Delete Ended");
				waitForElement(driver, srrGate_Module);
				click(driver, srrGate_Module);
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);
			}
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			moduleNavigate(driver, ModuleName1);

			//SRR Gate


			waitForElement(driver, SRR_Req_Type);
			click(driver, SRR_Req_Type);

			waitForElement(driver, All_Req_Type);
			click(driver, All_Req_Type);

			waitForElement(driver, SRR_Refresh_Btn);
			click(driver, SRR_Refresh_Btn);

			waitForElement(driver, submit_RadioButton);
			click(driver, submit_RadioButton);

			waitForElement(driver, menu_Icon_Grid);
			click(driver, menu_Icon_Grid);

			waitForElement(driver, filter_Icon_Grid);
			click(driver, filter_Icon_Grid);

			waitForElement(driver, filter_Inputfield);
			click(driver, filter_Inputfield);
			sendKeys(driver, filter_Inputfield, Value);
			enter(driver);

			waitForElement(driver, select_Actual_ReqNo);
			String submitted_ReqNum1=getText(driver, select_Actual_ReqNo);
			if(submitted_ReqNum1.equals(Value)) {
				System.out.println("Matched || " + " Expected Value is : " + Value + " || Actual Value is : " + submitted_ReqNum1);
				Extent_pass_New(driver,"Matched || " + " Expected Value is : " + Value + " || ActualValue is : " + submitted_ReqNum1,test,test1);
				Extent_pass_New(driver, Value+"  is submitted", test,test1);
				System.out.println(Value+" is submitted");
				waitForElement(driver, select_Actual_ReqNo);
				click(driver, select_Actual_ReqNo);
				waitForElement(driver, select_Actual_ReqNo);
				RightClick(driver, select_Actual_ReqNo);
				waitForElement(driver, moveTo_Pending);
				click(driver, moveTo_Pending);
				waitForElement(driver, close_Moved_Pending_Popup);
				click(driver, close_Moved_Pending_Popup);
			}else {
				System.out.println("Not matched || " + " Expected Value is : " + Value + " || Actual Value  is : " + submitted_ReqNum1);
				System.out.println(Value+" is not submitted");
				Extent_fail(driver,"Not matched || " + " Expected Value is : " + Value + " || Actual Value is : " + submitted_ReqNum1,test,test1);
				Extent_fail(driver, Value+" Error is not displayed", test,test1);
			}		
			//Pending	
			waitForElement(driver, pending_RadioButton);
			click(driver, pending_RadioButton);

			waitForElement(driver, menu_Icon_Grid);
			click(driver, menu_Icon_Grid);

			waitForElement(driver, filter_Icon_Grid);
			click(driver, filter_Icon_Grid);

			waitForElement(driver, filter_Inputfield);
			click(driver, filter_Inputfield);
			sendKeys(driver, filter_Inputfield, Value);
			enter(driver);

			waitForElement(driver, select_Actual_ReqNo);
			String pending_ReqNum1=getText(driver, select_Actual_ReqNo);
			if(pending_ReqNum1.equals(Value)) {
				System.out.println("Matched || " + " Expected Value is : " + Value + " || Actual Value is : " + pending_ReqNum1);
				Extent_pass_New(driver,"Matched || " + " Expected Value is : " + Value + " || ActualValue is : " + pending_ReqNum1,test,test1);

				waitForElement(driver, select_Actual_ReqNo);
				click(driver, select_Actual_ReqNo);
				waitForElement(driver, select_Actual_ReqNo);
				doubleClick(driver, select_Actual_ReqNo);

				//added
				waitForElement(driver, cancel_Common_btn);
				click(driver, cancel_Common_btn);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, Condition_Value,Rate_Request_NO,pending_ReqNum1,"", "", "","");



				waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);
				waitForElement(driver, delete_Request_Popup);
				click(driver, delete_Request_Popup_Ok);

				waitForElement(driver, comment_Ok_Button);
				click(driver, comment_Ok_Button);
				waitForElement(driver, Delete_button_toolBar);

				Extent_pass_New(driver, Value+"  is Deleted", test,test1);
				System.out.println(Value+" is Deleted");
			}else {
				System.out.println("Not matched || " + " Expected Value is : " + Value + " || Actual Value  is : " + pending_ReqNum1);
				System.out.println(Value+" is not Deleted");
				Extent_fail(driver,"Not matched || " + " Expected Value is : " + Value + " || Actual Value is : " + pending_ReqNum1,test,test1);
				Extent_fail(driver, Value+" is not Deleted", test,test1);
			}	
			Extent_call(test, test1, "Rate request Delete Ended");
			waitForElement(driver, srrGate_Module);
			click(driver, srrGate_Module);
			waitForElement(driver,Close_Current_tab);
			click(driver, Close_Current_tab);
		waitForElement(driver,Close_Current_tab);
		click(driver,Close_Current_tab);
		Extent_call(test, test1, "Rate request delete ended ");

		Extent_completed(testcase_Name, test, test1);


	}
}
