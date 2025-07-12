package LRP_Commercial_Rate_Request_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;




public class TC_Rate_Request_SC16 extends Keywords {


	public void Rate_Request_SC16(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {


		String testcase_Name="TC_Rate_Request_SC16";
		
		
		




		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Field_Names =Excel_data.get("ModuleName");
		String agencyUser = Excel_data.get("Agency_user");
		String Origin = Excel_data.get("Origin");
		String Delivery = Excel_data.get("Delivery");
		String Commodity = Excel_data.get("Commodity");
		String Eqp_type = Excel_data.get("Eqp_type");
		String GrossWeight = Excel_data.get("GrossWeight");
		String Exp_Detention_Days = Excel_data.get("Exp_Detention_Days");
		String Exp_Demurrage = Excel_data.get("Exp_Demurrage");
		String Imp_Detention_Days = Excel_data.get("Imp_Detention_Days");
		String Imp_Demurrage = Excel_data.get("Imp_Demurrage");
		String Ofr_Value = Excel_data.get("Ofr_Value");
		String Loc_Agency = Excel_data.get("Loc_Agency");
		String submit_msg = Excel_data.get("submit_msg");
		String status_value = Excel_data.get("status_value");
		String ModuleName1 = Excel_data.get("ModuleName1");
		String Non_Containerized = Excel_data.get("Non_Containerized");
		String DG_checkboxs = Excel_data.get("DG_checkboxs");
		String NOR_checkbox = Excel_data.get("NOR_checkbox");
		String SOC_checkbox = Excel_data.get("SOC_checkbox");
		String OOG_checkbox = Excel_data.get("OOG_checkbox");
		
		String Routing_Service = Excel_data.get("Routing_Service");
		String Customer_Code = Excel_data.get("Cust_code");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Condition_Value = Excel_data.get("Condition_Value");
		String From_Date_Input =Excel_data.get("From_Date_Input");
		String datePicker =Excel_data.get("datePicker");
		String To_Date_Input =Excel_data.get("To_Date_Input");
		String Eqp_Quantity_Input =Excel_data.get("Eqp_Quantity_Input");
		String do_You_Want_Delete = Excel_data.get("Do_You_Want_Delete").trim();
		String Pre_Carriage_Radiobtn = Excel_data.get("pre_Carriage_Radiobtn");
		String	On_Carriage_Radiobtn = Excel_data.get("On_Carriage_Radiobtn");
		String	tService=Excel_data.get("T_Service");
		String	TOS=Excel_data.get("TOS_Option");
		String search_type2=Excel_data.get("search_type2");
		String input2=Excel_data.get("input2");
		String search_type3=Excel_data.get("search_type3");
		String input3=Excel_data.get("input3");
		String Rate_Request_NO=Excel_data.get("Rate_Request_NO");
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


		//Switch User
		SwitchProfile(driver, agencyUser);

		moduleNavigate(driver, Field_Names);


		Step_Start(1, "Click on the new button in the toolbar", test, test1);

		waitForElement(driver, Requet_Type);
newButton(driver);

		// non containerized radio btn

		if (Non_Containerized.equals("YES")) {
			waitForElement(driver, non_containradio_btn);
			safeclick(driver, non_containradio_btn);
		}

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
		Extent_call(test, test1, "selecting the from date");
		rateRequestDateSelect(driver, date_Perform, datePicker, From_Date_Input, To_Date_Input);

		Step_Start(2, "Enter the customer name", test, test1);

		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);
		globalValueSearchWindow(driver, Condition_Value, Customer_Code, Customer_code_Value, search_type2, input2,search_type3, input3);
			Step_End(2, "Enter the customer name", test, test1);
			rateRequestCustomerExistOption(driver);

			Step_Start(3, "Enter the origin", test, test1);

			waitForElement(driver, Orgin_Input);  
			sendKeys(driver, Orgin_Input, Origin);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			System.out.println("origin Value:"+Origin);

			Step_End(3, "Enter the origin", test, test1);

			Step_Start(4, "Enter the Delivery", test, test1);

			waitForElement(driver, RR_Delivery_Input);
			sendKeys(driver, RR_Delivery_Input, Delivery);

			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			System.out.println("Delivery Value:"+Delivery);

			Step_End(4, "Enter the Delivery", test, test1);

			Step_Start(5, "Enter the Commodity", test, test1);

			waitForElement(driver, Commodity_Input);
			Newclear(driver, Commodity_Input);
		Actionsendkeys(driver, Commodity_Input, Commodity);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			System.out.println("Commodity Value:"+Commodity);

			Step_End(5, "Enter the Commodity", test, test1);

			Step_Start(6, "Enter the rate calculation type", test, test1);

			waitForElement(driver, Eqp_Type);
			click(driver, Eqp_Type);

			sendKeys(driver, Eqp_Type, Eqp_type);
			waitForElement(driver, Eqp_Type_Value);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			System.out.println("Eqp type:"+Eqp_type);

			Step_End(6, "Enter the rate calculation type", test, test1);


			Step_Start(7, "Enter the Quantity", test, test1);
			waitForElement(driver, Eqp_Quantity);
			click(driver, Eqp_Quantity);
			Newclear(driver, Eqp_Quantity);
			Actionsendkeys(driver, Eqp_Quantity,Eqp_Quantity_Input );
			Step_End(7, "Enter the Quantity", test, test1);

			Step_Start(8, "Enter the Gross Weigh", test, test1);

			waitForElement(driver, RR_Gross_Weight);
			click(driver, RR_Gross_Weight);
			clearAndType(driver, RR_Gross_Weight, GrossWeight);
			System.out.println("Gross weight:"+GrossWeight);

			Step_End(8, "Enter the Gross Weigh", test, test1);

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

			rateRequestRoutingDays(driver, Exp_Detention_Days, Imp_Detention_Days, Exp_Demurrage, Imp_Demurrage);

			Step_Start(9, "Click routing", test, test1);

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
				sendKeys(driver, Routing_OriginTF, Origin);
				waitForElement(driver, Routing_service_TF);
				sendKeys(driver, Routing_service_TF, Routing_Service);
				doubleClick(driver, select_First_Routing);

			}else {
				System.out.println(actRoutingFrame+" is not displayed");
				Extent_fail(driver, actRoutingFrame+" is not displayed", test,test1);
			}

			Step_End(10, "Select the routing", test, test1);
			rateRequestPaymentMode_Select(driver, payment_Mode,Select_type_location, condition, payLocation);
			Step_Start(11, "Enter the OFR", test, test1);

			waitForElement(driver, OFR_Txt_Field);
			click(driver, OFR_Txt_Field);
			clear(driver, OFR_Txt_Field);
			sendKeys(driver, OFR_Txt_Field, Ofr_Value);
			System.out.println("OFR Value:"+Ofr_Value);

			Step_End(11, "Enter the OFR", test, test1);

			Step_Start(12, "Click Add.Click on the autorated surcharge in the surcharge table", test, test1);


			click(driver, Rate_AddBtn);

			Step_End(12, "Click Add.Click on the autorated surcharge in the surcharge table", test, test1);

			Step_Start(13, "Enter the surcharge amount in the agency(LOC) column", test, test1);
			waitForElement(driver, Surcharge_Edit);
			click(driver, Surcharge_Edit);
			System.out.println("Column clicked");
			Newclear_Type(driver);
			System.out.println("Cleared");
			waitForElement(driver, Surcharge_Edit);
			Actionsendkeys(driver, Surcharge_Edit, Loc_Agency);
			System.out.println("Value entered");

			Step_End(13, "Enter the surcharge amount in the agency(LOC) column", test, test1);


			Step_Start(14, "click apply button", test, test1);


			waitForElement(driver, SurCharge_ApplyBtn);
			click(driver, SurCharge_ApplyBtn);
			waitForElement(driver, Surcharge);
			String SurCharge_Amount=getText(driver, Surcharge);
			if(Loc_Agency.equals(SurCharge_Amount)) {
				System.out.println("Matched || Expected value was : "+Loc_Agency+" || Actual value was : "+SurCharge_Amount);
				Extent_pass_New(driver, "Matched || Expected value was : "+Loc_Agency+" || Actual value was : "+SurCharge_Amount, test,test1);
			}
			else {
				System.out.println("NotMatched || Expected value was : "+Loc_Agency+" || Actual value was : "+SurCharge_Amount);
				Extent_fail(driver,  "NotMatched || Expected value was : "+Loc_Agency+" || Actual value was : "+SurCharge_Amount, test,test1);
			}
			Step_Start(14, "click apply button", test, test1);

			Step_Start(15, "Click Save button in the tool bar", test, test1);

			waitForElement(driver, surcharge_grid_R);
			waitForElement(driver, surcharge_first_data);
			click(driver, surcharge_first_data);
			System.out.println("surcharge first grid was clicked");
			List<WebElement> grid_data3 = listOfElements(driver, Grid_Data);
			int grid_size3=grid_data3.size();
			System.out.println("size: "+grid_size3);
			int last_data_index3=grid_size3-1;

			System.out.println("grid was scrolled down");
			formatLocatorClick(driver, grid_LastValue, String.valueOf(last_data_index3));
			System.out.println("surcharge last grid was clicked");

			waitForElement(driver, SaveButton_ToolBar);
			safeclick(driver, SaveButton_ToolBar);
			Step_End(15, "Click Save button in the tool bar", test, test1);


			Step_Start(16, "Click submit", test, test1);
			waitForPopup(driver, Rate_Sub_Popup_Msg, submit_msg);
			String SaveRate_PopUp3= getText(driver, Rate_Sub_Popup_Msg);

			if(submit_msg.equals(SaveRate_PopUp3)) {
				System.out.println("Matched || Expected : popup message should be shown as : "+submit_msg+" || Actual :popup message is shown as : "+SaveRate_PopUp3);
				Extent_pass_New(driver, "Matched || EExpected : popup message should be shown as : "+submit_msg+" || Actual :popup message is shown as : "+SaveRate_PopUp3, test,test1);
				waitForElement(driver, Rate_SubmitBtn);
				click(driver, Rate_SubmitBtn);
				System.out.println("Submit button clicked");
			}
			else {
				System.out.println("NotMatched || Expected : popup message should be shown as : "+submit_msg+" || Actual :popup message is shown as : "+SaveRate_PopUp3);
				Extent_fail(driver,  "NotMatched || Expected : popup message should be shown as : "+submit_msg+" || Actual :popup message is shown as : "+SaveRate_PopUp3, test,test1);
			}

			Step_End(16, "Click submit", test, test1);


			Step_Start(17, "Click Ok", test, test1);

			waitForElement(driver,popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			System.out.println("Rate Request saved");



			waitForElement(driver, status_Field);
			String status3=getAttribute(driver, status_Field, "value");
			if(status3.equals(status_value)) {
				System.out.println("Rate Request Submitted");
				System.out.println("Matched || Expected value was : "+status_value+" || Actual value was : "+status3);
				Extent_pass_New(driver, "Matched || Expected value was : "+status_value+" || Actual value was : "+status3, test,test1);
			}
			else {
				System.out.println("NotMatched || Expected value was : "+status_value+" || Actual value was : "+status3);
				Extent_fail(driver,  "NotMatched || Expected value was : "+status_value+" || Actual value was : "+status3, test,test1);
			}

			Step_End(17, "Click Ok", test, test1);
			waitForDisplay(driver, Mail_Cancel_button);
		if(isdisplayed(driver, Mail_Cancel_button)) {
		click(driver, Mail_Cancel_button);
		}
			waitForElement(driver,reqNo_Textfield);
			String Value5=getAttribute(driver, reqNo_Textfield, "value");
			System.out.println("Req.No:"+Value5);


			if(do_You_Want_Delete.equalsIgnoreCase("yes")) {

				Extent_call(test, test1, "Rate request delete starts");
				waitForElement(driver,Close_Current_tab);
				click(driver,Close_Current_tab);

				moduleNavigate(driver, ModuleName1);

				//SRR Gate


				//Submitted	
				waitForElement(driver, submit_RadioButton);
				click(driver, submit_RadioButton);

				waitForElement(driver, menu_Icon_Grid);
				click(driver, menu_Icon_Grid);

				waitForElement(driver, filter_Icon_Grid);
				click(driver, filter_Icon_Grid);

				waitForElement(driver, filter_Inputfield);
				click(driver, filter_Inputfield);
				waitForElement(driver,filter_Inputfield);
				Actionsendkeys(driver, filter_Inputfield, Value5);
				enter(driver);

				waitForElement(driver, select_Actual_ReqNo);
				String submitted_ReqNum5=getText(driver, select_Actual_ReqNo);
				if(submitted_ReqNum5.equals(Value5)) {
					System.out.println("Matched || " + " Expected Value is : " + Value5 + " || Actual Value is : " + submitted_ReqNum5);
					Extent_pass_New(driver,"Matched || " + " Expected Value is : " + Value5 + " || ActualValue is : " + submitted_ReqNum5,test,test1);
					Extent_pass_New(driver, Value5+"  is submitted", test,test1);
					System.out.println(Value5+" is submitted");

					click(driver, select_Actual_ReqNo);
					waitForElement(driver,select_Actual_ReqNo);
					RightClick(driver, select_Actual_ReqNo);
					waitForElement(driver, moveTo_Pending);
					click(driver, moveTo_Pending);
					waitForElement(driver,close_Moved_Pending_Popup);
					click(driver, close_Moved_Pending_Popup);

				}else {
					System.out.println("Not matched || " + " Expected Value is : " + Value5 + " || Actual Value  is : " + submitted_ReqNum5);
					System.out.println(Value5+" is not submitted");
					Extent_fail(driver,"Not matched || " + " Expected Value is : " + Value5 + " || Actual Value is : " + submitted_ReqNum5,test,test1);
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
				waitForElement(driver,filter_Inputfield);
				sendKeys(driver, filter_Inputfield, Value5);
				enter(driver);

				waitForElement(driver, select_Actual_ReqNo);
				String pending_ReqNum5=getText(driver, select_Actual_ReqNo);
				if(pending_ReqNum5.equals(Value5)) {
					System.out.println("Matched || " + " Expected Value is : " + Value5 + " || Actual Value is : " + pending_ReqNum5);
					System.out.println(Value5+" is submitted");
					Extent_pass_New(driver,"Matched || " + " Expected Value is : " + Value5 + " || ActualValue is : " + pending_ReqNum5,test,test1);
					Extent_pass_New(driver, Value5+"  is submitted", test,test1);

					click(driver, select_Actual_ReqNo);
					waitForElement(driver,select_Actual_ReqNo);
					doubleClick(driver, select_Actual_ReqNo);


					//added
					waitForElement(driver, cancel_Common_btn);
					click(driver, cancel_Common_btn);
					waitForElement(driver, SearchButton_Toolbar);
					click(driver, SearchButton_Toolbar);
					globalValueSearchWindow(driver, Condition_Value,Rate_Request_NO,pending_ReqNum5,"", "", "","");




					waitForElement(driver, Delete_button_toolBar);
					click(driver, Delete_button_toolBar);

					waitForElement(driver, delete_Request_Popup);
					click(driver, delete_Request_Popup_Ok);

					waitForElement(driver, comment_Ok_Button);
					click(driver, comment_Ok_Button);


				}else {
					System.out.println("Not matched || " + " Expected Value is : " + Value5 + " || Actual Value  is : " + pending_ReqNum5);
					System.out.println(Value5+" is not submitted");
					Extent_fail(driver,"Not matched || " + " Expected Value is : " + Value5 + " || Actual Value is : " + pending_ReqNum5,test,test1);
				}	

				Extent_call(test, test1, "Rate request delete ends");
			}

			Extent_completed(testcase_Name, test, test1);
	}

}




