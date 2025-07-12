package LRP_Commercial_Rate_Request_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Rate_Request_SC20 extends Keywords{


	public void Rate_Request_SC20(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String testCaseName="TC_Rate_Request_SC20";
		String user_Name = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("field_name");	
		String Origin_Input = Excel_data.get("Origin_Input");
		String Delivery_Input1 = Excel_data.get("Dehlivery_Input");
		String commodity = Excel_data.get("Commodity");
		String Eqp_Type_Input = Excel_data.get("Eqp_Type_Input");
		String Gross_Weight_Input = Excel_data.get("Gross_Weight_Input");
		String Exp_Det_Days_Input = Excel_data.get("Exp_Det_Days_Input");
		String Imp_Det_Days_Input = Excel_data.get("Imp_Det_Days_Input");
		String Exp_Demmurage_Input = Excel_data.get("Exp_Demmurage_Input");
		String Imp_Demmurage_Input = Excel_data.get("Imp_Demmurage_Input");
		String ofrGreater = Excel_data.get("OFRGreater");
		String agencyLOC = Excel_data.get("AgencyLOC");
		String wantToSavePopup = Excel_data.get("WantToSavePopup");
		String wantToProceedPopup = Excel_data.get("WantToProceedPopup");
		String submittedPopup = Excel_data.get("SubmittedPopup");
		String gridRequestStatus = Excel_data.get("GridRequestStatus");
		String requestStatus = Excel_data.get("RequestStatus");
		String moduleSRRGate = Excel_data.get("ModuleSRRGate");
		String Non_Containerized = Excel_data.get("Non_Containerized");
		String DG_checkboxs = Excel_data.get("DG_checkboxs");
		String NOR_checkbox = Excel_data.get("NOR_checkbox");
		String SOC_checkbox = Excel_data.get("SOC_checkbox");
		String OOG_checkbox = Excel_data.get("OOG_checkbox");
		String Customer_Code = Excel_data.get("Cust_code");
		String Condition_Value = Excel_data.get("Condition_Value");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String agencyUser = Excel_data.get("agencyUser");
		String Routing_Service = Excel_data.get("Routing_Service");
		String eqp_Quantity_Input = Excel_data.get("Eqp_Quantity_Input");
		String Rate_Request_No = Excel_data.get("Rate_Request_No");
		String DatePicker = Excel_data.get("DatePicker");
		String From_date = Excel_data.get("From_date");
		String To_date = Excel_data.get("To_date");
		String Do_You_Want_Delete = Excel_data.get("Do_You_Want_Delete");
		String service =Excel_data.get("Service");
		String tService = Excel_data.get("T_Service");
		String TOS=Excel_data.get("TOS_Option");
		String Pre_Carriage_Radiobtn = Excel_data.get("pre_Carriage_Radiobtn");
		String On_Carriage_Radiobtn = Excel_data.get("On_Carriage_Radiobtn");
		String Customer_code_Value2 = Excel_data.get("Customer_code_Value2");
		String Customer_code_Value3 = Excel_data.get("Customer_code_Value3");
		String Cust_code2 = Excel_data.get("Cust_code2");
		String Cust_code3 = Excel_data.get("Cust_code3");
		String date_Perform = Excel_data.get("date_Perform");
		String Flexi_CheckBox = Excel_data.get("Flexi_CheckBox");
		String MTY_CheckBox = Excel_data.get("MTY_CheckBox");
		String payment_Mode = Excel_data.get("payment_Mode");
		String Select_type_location = Excel_data.get("Select_type_location");
		String condition = Excel_data.get("condition");
		String payLocation =Excel_data.get("payLocation");

		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);
		//Login


		LRP_Login(driver, user_Name, pass_word);



		//Switch User
		SwitchProfile(driver, agencyUser);

		moduleNavigate(driver, Field_Names);

		Step_Start(1, "Click on the new button in the toolbar", test, test1);
		waitForElement(driver, Requet_Type);
newButton(driver);

		Step_End(1, "Click on the new button in the toolbar", test, test1);
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
		// non containerized radio btn

		if (Non_Containerized.equals("YES")) {
			waitForElement(driver, non_containradio_btn);
			safeclick(driver, non_containradio_btn);
		}


		Step_Start(2, "Enter the customer name", test, test1);

		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);

		globalValueSearchWindow(driver, Condition_Value, Customer_Code, Customer_code_Value, Cust_code2, Customer_code_Value2,Cust_code3, Customer_code_Value3);

			rateRequestCustomerExistOption(driver);
			Step_Start(3, "Enter the origin", test, test1);

			waitForElement(driver, Orgin_Input);
			sendKeys(driver, Orgin_Input, Origin_Input);

			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(3, "Enter the origin", test, test1);

			Step_Start(4, "Enter the Delivery", test, test1);

			waitForElement(driver, Delivery_Input_Field);
			sendKeys(driver, Delivery_Input_Field, Delivery_Input1);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(4, "Enter the Delivery", test, test1);

			Step_Start(5, "Enter the Commodity", test, test1);

			waitForElement(driver, Commodity_Input);
			Newclear(driver, Commodity_Input);
		Actionsendkeys(driver, Commodity_Input, commodity);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(5, "Enter the Commodity", test, test1);

			Step_Start(6, "Enter the rate calculation type", test, test1);


			waitForElement(driver, Eqp_Type);
			click(driver, Eqp_Type);
			sendKeys(driver, Eqp_Type, Eqp_Type_Input);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(6, "Enter the rate calculation type", test, test1);

			Step_Start(7, "Enter the Quantity", test, test1);

			waitForElement(driver, Eqp_Quantity);
			clearAndType(driver, Eqp_Quantity,eqp_Quantity_Input);


			Step_End(7, "Enter the Quantity", test, test1);
			Step_Start(8, "Enter the Gross Weight", test, test1);

			waitForElement(driver, RR_Gross_Weight);
			Newclear(driver, RR_Gross_Weight);
			Actionsendkeys(driver, RR_Gross_Weight, Gross_Weight_Input);

			Step_End(8, "Enter the Gross Weight", test, test1);
			rateRequestDateSelect(driver, date_Perform, DatePicker, From_date, To_date);


			click(driver, service_Textfield);
			clearAndType(driver, service_Textfield, service);

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

			rateRequestRoutingDays(driver, Exp_Det_Days_Input, Imp_Det_Days_Input, Exp_Demmurage_Input, Imp_Demmurage_Input);

			Step_Start(9, "Click routing", test, test1);
			waitForPresenceOfElement(driver, Retrived_Tariff_No);

			String Before_Tarriff_No = getText(driver, Retrived_Tariff_No);
			waitForElement(driver, Routing_Button);
			click(driver, Routing_Button);
			Step_End(9, "Click routing", test, test1);
			Step_Start(10, "Select the routing", test, test1);
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
				sendKeys(driver, Routing_OriginTF, Origin_Input);
				waitForElement(driver, Routing_service_TF);
				sendKeys(driver, Routing_service_TF, Routing_Service);
				waitForElement(driver, select_First_Routing);
				doubleClick(driver, select_First_Routing);
			}else {
				System.out.println(actRoutingFrame+" is not displayed");
				Extent_fail(driver, actRoutingFrame+" is not displayed", test,test1);
			}

			Step_End(10, "Select the routing", test, test1);
			rateRequestPaymentMode_Select(driver, payment_Mode,Select_type_location, condition, payLocation);
			Step_Start(11, "Enter the OFR greater than the tariff", test, test1);


			waitForElement(driver, OFR_Txt_Field);
			click(driver, OFR_Txt_Field);
			clear(driver, OFR_Txt_Field);
			sendKeys(driver, OFR_Txt_Field, ofrGreater);


			Step_End(11, "Enter the OFR greater than the tariff", test, test1);

			Step_Start(12, "Click Add", test, test1);

			waitForElement(driver, Rate_AddBtn);
			click(driver, Rate_AddBtn);

			Step_End(12, "Click Add", test, test1);


			waitForElement(driver, Surcharge_Edit);
			click(driver, Surcharge_Edit);
			Newclear_Type(driver);
			waitForElement(driver, Surcharge_Edit);
			Actionsendkeys(driver, Surcharge_Edit, agencyLOC);
			waitForElement(driver, SurCharge_ApplyBtn);
			click(driver, SurCharge_ApplyBtn);

			Step_Start(13, "Click Save button in the tool bar", test, test1);


			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(13, "Click Save button in the tool bar", test, test1);


			waitForPopup(driver, Rate_Sub_Popup_Msg, wantToSavePopup);

			String actSubmitPopupTar = getText(driver, Rate_Sub_Popup_Msg);
			if (actSubmitPopupTar.equals(wantToSavePopup)) {
				Extent_pass_New(driver, "Matched || Expected : popup message should be shown as : " + wantToSavePopup + " || Actual : popup message is shown as : " + actSubmitPopupTar, test,test1);
				System.out.println("Matched || Expected : popup message should be shown as : " + wantToSavePopup + " || Actual : popup message is shown as : " + actSubmitPopupTar);
				Extent_pass_New(driver, wantToSavePopup + " is displayed", test,test1);
				System.out.println(wantToSavePopup + " is displayed");

				Step_Start(14, "Click submit", test, test1);

				click(driver, Rate_SubmitBtn);

				Step_End(14, "Click submit", test, test1);

			} else {
				System.out.println("Not Matched || Expected :popup message is not shown " + wantToSavePopup + " || Actual : popup message is shown as : " + actSubmitPopupTar);
				System.out.println(wantToSavePopup + " is not displayed");
				extent_fail(driver, wantToSavePopup + " is not displayed", test,test1);
				Extent_fail(driver, "Not Matched || Expected :popup message is not shown " + wantToSavePopup + " || Actual : popup message is shown as : " + actSubmitPopupTar,
						test,test1);
			}

			waitForPopup(driver, popup_Message, wantToProceedPopup);

			String actualProceedPopupTar = getText(driver, popup_Message);
			if (actualProceedPopupTar.equals(wantToProceedPopup)) {
				Extent_pass_New(driver, "Matched || Expected : popup message should be shown as : " + wantToProceedPopup + " || Actual : popup message is shown as : " + actualProceedPopupTar,
						test,test1);
				System.out.println("Matched || Expected : popup message should be shown as : " + wantToProceedPopup + " || Actual : popup message is shown as : " + actualProceedPopupTar);
				Extent_pass_New(driver, wantToProceedPopup + " popup is displayed", test,test1);
				System.out.println(wantToProceedPopup + " popup is displayed");
				Step_Start(15, "Click Ok", test, test1);
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
				Step_End(15, "Click Ok", test, test1);

			} else {
				System.out.println("Not Matched || Expected :popup message is not shown " + wantToProceedPopup + " || Actual : popup message is shown as : " + actualProceedPopupTar);
				System.out.println(wantToProceedPopup + " popup is not displayed");
				extent_fail(driver, wantToProceedPopup + " popup is not displayed", test,test1);
				Extent_fail(driver,"Not Matched || Expected :popup message is not shown " + wantToProceedPopup + " || Actual : popup message is shown as : " + actualProceedPopupTar, test,test1);

			}
			waitForPopup(driver, Popup_Message, submittedPopup);

			String actSubmittedPopupTar = getText(driver, Popup_Message);
			if (actSubmittedPopupTar.contains(submittedPopup)) {
				Extent_pass_New(driver, "Matched || Expected : popup message should be shown as : " + submittedPopup + " || Actual : popup message is shown as : " + actSubmittedPopupTar, test,test1);
				System.out.println("Matched || Expected : popup message should be shown as : " + submittedPopup + " || Actual : popup message is shown as : " + actSubmittedPopupTar);
				Extent_pass_New(driver, submittedPopup + " popup is displayed", test,test1);
				System.out.println(submittedPopup + " popup is displayed");

			} else {

				System.out.println("Not Matched || Expected :popup message is not shown " + submittedPopup + " || Actual : popup message is shown as : " + actSubmittedPopupTar);
				System.out.println(submittedPopup + " popup is not displayed");
				extent_fail(driver, submittedPopup + " popup is not displayed", test,test1);
				Extent_fail(driver, "Not Matched || Expected :popup message is not shown " + submittedPopup + " || Actual : popup message is shown as : " + actSubmittedPopupTar,
						test,test1);
			}

			waitForElement(driver, reqNo_Textfield);
			String actualReqNoTar = getAttribute(driver, reqNo_Textfield, "value");
			System.out.println("Request Number:" + actualReqNoTar);

			if (!actualReqNoTar.equals(null)) {
				Extent_pass_New(driver, "Matched || " + actualReqNoTar + "  is  generated", test,test1);
				System.out.println("Matched || " + actualReqNoTar + "  is  generated");

			} else {
				System.out.println("Not Matched || " + actualReqNoTar + "Request Number  is not generated");
				Extent_fail(driver, "Not Matched || " + actualReqNoTar + "Request Number  is not generated", test,test1);
			}

			////

			waitForElement(driver, Retrived_Tariff_No);
			String afterTariff = getText(driver, Retrived_Tariff_No);

			if (!(afterTariff.equals(Before_Tarriff_No))) {
				System.out.println("Matched || " + " The Retrived Tariff Number is : " + afterTariff);
				Extent_pass_New(driver, "Matched || " + " The Retrived Tariff Number is : " + afterTariff, test,test1);
			} else {
				System.out.println("Not Matched || The Tariff Number is Not  Retrived");
				Extent_fail(driver, "Not Matched || The Tariff Number is Not  Retrived", test,test1);
			}
			waitForElement(driver, RR_Ocean_Freight_Details_Table_Headers);
			List<Map<String, String>> table_Values = getTableData(driver, RR_Ocean_Freight_Details_Table_Headers, RR_Ocean_Freight_Details_Table_Rows);
			String actGridReqStatus = getFirstValueByHeader(table_Values, "Request Status");
			if (actGridReqStatus.equals(gridRequestStatus)) {
				System.out.println("Matched || " + " Expected Request Status in Grid is : " + gridRequestStatus+ " || Actual Request Status in Grid is : " + actGridReqStatus);
				Extent_pass_New(driver, "Matched || " + " Expected Request Status in Grid is : " + gridRequestStatus+ " || Actual Request Status in Grid is : " + actGridReqStatus, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Request Status in Grid is : " + gridRequestStatus+ " || Actual Request Status in Grid is : " + actGridReqStatus);
				Extent_fail(driver, "Not Matched || " + " Expected Request Status in Grid is : " + gridRequestStatus+ " || Actual Request Status in Grid is : " + actGridReqStatus, test,test1);
			}
			waitForElement(driver, Request_Status);
			String actReqStatus = getAttribute(driver, Request_Status, "value");
			if (actReqStatus.equals(requestStatus)) {
				System.out.println("Matched || " + " Expected Request Status is : " + requestStatus+ " || Actual Request Status is : " + actReqStatus);
				Extent_pass_New(driver, "Matched || " + " Expected Request Status is : " + requestStatus+ " || Actual Request Status is : " + actReqStatus, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Request Status is : " + requestStatus+ " || Actual Request Status is : " + actReqStatus);
				Extent_fail(driver, "Not Matched || " + " Expected Request Status is : " + requestStatus+ " || Actual Request Status is : " + actReqStatus, test,test1);
			}
			////
			waitForDisplay(driver, Mail_Cancel_button);
		if(isdisplayed(driver, Mail_Cancel_button)) {
		click(driver, Mail_Cancel_button);
		}

			if(Do_You_Want_Delete.equalsIgnoreCase("Yes")) {
				Extent_call(test, test1, "Rate request Delete Started");
				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);

				moduleNavigate(driver, moduleSRRGate);



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
				waitForElement(driver, filter_Inputfield);
				sendKeys(driver, filter_Inputfield, actualReqNoTar);
				enter(driver);

				waitForElement(driver, select_Actual_ReqNo);
				String submitted_ReqNumTar = getText(driver, select_Actual_ReqNo);
				if (submitted_ReqNumTar.equals(actualReqNoTar)) {
					System.out.println("Matched || " + " Expected Value is : " + actualReqNoTar + " || Actual Value is : "+ submitted_ReqNumTar);
					Extent_pass_New(driver, "Matched || " + " Expected Value is : " + actualReqNoTar + " || ActualValue is : "+ submitted_ReqNumTar, test,test1);
					Extent_pass_New(driver, actualReqNoTar + "  is submitted", test,test1);
					System.out.println(actualReqNoTar + " is submitted");
					waitForElement(driver, select_Actual_ReqNo);
					click(driver, select_Actual_ReqNo);
					waitForElement(driver, select_Actual_ReqNo);
					RightClick(driver, select_Actual_ReqNo);
					waitForElement(driver, moveTo_Pending);
					click(driver, moveTo_Pending);
					waitForElement(driver, close_Moved_Pending_Popup);
					click(driver, close_Moved_Pending_Popup);
				} else {
					System.out.println("Not matched || " + " Expected Value is : " + actualReqNoTar + " || Actual Value  is : "+ submitted_ReqNumTar);
					System.out.println(actualReqNoTar + " is not submitted");
					extent_fail(driver, actualReqNoTar + " Error is not displayed", test,test1);
					Extent_fail(driver, "Not matched || " + " Expected Value is : " + actualReqNoTar + " || Actual Value is : "+ submitted_ReqNumTar, test,test1);
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
				waitForElement(driver, filter_Inputfield);
				sendKeys(driver, filter_Inputfield, actualReqNoTar);
				enter(driver);

				waitForElement(driver, select_Actual_ReqNo);
				String pending_ReqNumTar = getText(driver, select_Actual_ReqNo);
				if (pending_ReqNumTar.equals(actualReqNoTar)) {
					System.out.println("Matched || " + " Expected Value is : " + actualReqNoTar + " || Actual Value is : "+ pending_ReqNumTar);
					Extent_pass_New(driver, "Matched || " + " Expected Value is : " + actualReqNoTar + " || ActualValue is : "+ pending_ReqNumTar, test,test1);
					Extent_pass_New(driver, actualReqNoTar + "  is moved To pending", test,test1);
					System.out.println(actualReqNoTar + " is moved To Deleted");

					click(driver, select_Actual_ReqNo);
					waitForElement(driver, select_Actual_ReqNo);
					doubleClick(driver, select_Actual_ReqNo);
					// added					
					waitForElement(driver, cancel_Common_btn);
					click(driver, cancel_Common_btn);
					waitForElement(driver, SearchButton_Toolbar);
					click(driver, SearchButton_Toolbar);
					globalValueSearchWindow(driver, Condition_Value, Rate_Request_No, actualReqNoTar, "", "", "", "");

					waitForElement(driver, Delete_button_toolBar);
					click(driver, Delete_button_toolBar);

					waitForElement(driver, delete_Request_Popup);
					click(driver, delete_Request_Popup_Ok);

					waitForElement(driver, comment_Ok_Button);
					click(driver, comment_Ok_Button);
				}else {
					System.out.println("Not matched || " + " Expected Value is : " + actualReqNoTar + " || Actual Value  is : "+ pending_ReqNumTar);
					System.out.println(actualReqNoTar + " is not moved To Deleted");
					extent_fail(driver, actualReqNoTar + " Error is not displayed", test,test1);
					Extent_fail(driver, "Not matched || " + " Expected Value is : " + actualReqNoTar + " || Actual Value is : "+ pending_ReqNumTar, test,test1);

				}
				Extent_call(test, test1, "Rate request Delete Ended");
			}
			Extent_completed(testCaseName, test, test1);
	}
}
