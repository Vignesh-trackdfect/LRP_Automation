package LRP_Commercial_Rate_Request_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Rate_Request_SC12 extends Keywords{

	public void rate_Request_Sc12(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Rate_Request_SC12";
		
		
		


		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String search_module = Excel_data.get("Search_module");
		String delivery=Excel_data.get("Delivery");
		String commodity2=Excel_data.get("commodity2");
		String Eqp_Quantity_Input =Excel_data.get("Eqp_Quantity_Input");
		String DG_checkboxs = Excel_data.get("DG_checkboxs");
		String NOR_checkbox = Excel_data.get("NOR_checkbox");
		String SOC_checkbox = Excel_data.get("SOC_checkbox");
		String OOG_checkbox = Excel_data.get("OOG_checkbox");
		String agencyUser = Excel_data.get("AgencyUser");
		
		String routing_Service = Excel_data.get("Routing_Service");
		String From_Date_Input =Excel_data.get("From_Date_Input");
		String To_Date_Input =Excel_data.get("To_Date_Input");
		String delete_perform =Excel_data.get("Delete_perform");
		String customerCode_Option =Excel_data.get("CustomerCode_Option");
		String condition_Option =Excel_data.get("Condition_Option");
		String customerCode =Excel_data.get("CustomerCode");
		String datePicker =Excel_data.get("DatePicker");
		String service =Excel_data.get("Service");
		String Origin_Input=Excel_data.get("Origin_Input");
		String Commodity_Input_Txt=Excel_data.get("Commodity_Input");
		String Eqp_Type_Input=Excel_data.get("Eqp_Type_Input");	
		String Gross_Weight_Input=Excel_data.get("Gross_Weight_Input");
		String Length_Field_Input=Excel_data.get("Length_Field_Input");
		String Width_Field_Input=Excel_data.get("Width_Field_Input");
		String Height_Field_Input=Excel_data.get("Height_Field_Input");
		String Exp_Det_Days_Input=Excel_data.get("Exp_Det_Days_Input");
		String Imp_Det_Days_Input=Excel_data.get("Imp_Det_Days_Input");
		String Exp_Demmurage_Input=Excel_data.get("Exp_Demmurage_Input");
		String Imp_Demmurage_Input=Excel_data.get("Imp_Demmurage_Input");
		String OFR_Txt_Field_Input=Excel_data.get("OFR_Txt_Field_Input");
		String Req_Submit_Popup_Txt=Excel_data.get("Req_Submit_Popup_Txt");
		String Rate_Req_Submitted_Popup_Txt=Excel_data.get("Rate_Req_Submitted_Popup_Txt");
		String Req_Status_Exp=Excel_data.get("Req_Status_Exp");
		String From_Date_Input_Edit=Excel_data.get("From_Date_Input_Edit");
		String To_Date_Input_Edit=Excel_data.get("To_Date_Input_Edit");
		String search_type2=Excel_data.get("search_type2");
		String input2=Excel_data.get("input2");
		String search_type3=Excel_data.get("search_type3");
		String input3=Excel_data.get("input3");
		String Module_SRR_Gate=Excel_data.get("Module_SRR_Gate");
		String	Pre_Carriage_Radiobtn = Excel_data.get("pre_Carriage_Radiobtn");
		String	On_Carriage_Radiobtn = Excel_data.get("on_Carriage_Radiobtn");
		String	Request_Input=Excel_data.get("Request_Type_Input");
		String Rate_Request_NO= Excel_data.get("Rate_Request_NO");
		String Condition_Value = Excel_data.get("Condition_Value");
		String date_Perform = Excel_data.get("date_Perform");
		String Flexi_CheckBox = Excel_data.get("Flexi_CheckBox");
		String MTY_CheckBox = Excel_data.get("MTY_CheckBox");
		String payment_Mode = Excel_data.get("payment_Mode");
		String Select_type_location = Excel_data.get("Select_type_location");
		String condition = Excel_data.get("condition");
		String payLocation =Excel_data.get("payLocation");
		String tService = Excel_data.get("T_Service");
		String TOS = Excel_data.get("TOS_Option");







		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		//Login

		LRP_Login(driver, username, password);

		//Switch User

		SwitchProfile(driver, agencyUser);

		moduleNavigate(driver, search_module);

		Step_Start(1, "Click on the new button in the toolbar", test, test1);

		waitForElement(driver, Requet_Type);
newButton(driver);

		Step_End(1, "Click on the new button in the toolbar", test, test1);

		waitForElement(driver, Requet_Type);
		click(driver,Requet_Type);
		formatLocatorClick(driver, RequestType, Request_Input);

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

		Step_Start(2, "Enter the customer name", test, test1);


		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);
		globalValueSearchWindow(driver, condition_Option, customerCode_Option, customerCode, search_type2, input2, search_type3, input3);
			rateRequestCustomerExistOption(driver);

			Step_Start(3, "Enter the origin", test, test1);
			waitForElement(driver, Orgin_Input);
			sendKeys(driver, Orgin_Input, Origin_Input);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			Step_End(3, "Enter the origin", test, test1);

			Step_Start(4, "Enter the Delivery", test, test1);
			waitForElement(driver, RR_Delivery_Input_Field);
			sendKeys(driver, RR_Delivery_Input_Field,delivery );
			click(driver, Auto_Panel_First);

			//		click(driver, selectDelivery_name);
			Step_End(4, "Enter the Delivery", test, test1);
			rateRequestDateSelect(driver, date_Perform, datePicker, From_Date_Input, To_Date_Input);
			click(driver, service_Textfield);
			clearAndType(driver, service_Textfield, service);

			Step_Start(5, "Enter the Commodity", test, test1);
			waitForElement(driver, Commodity_Input);
			Newclear(driver, Commodity_Input);
		Actionsendkeys(driver, Commodity_Input, Commodity_Input_Txt);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(5, "Enter the Commodity", test, test1);

			Step_Start(6, "Enter the Equipment type", test, test1);
			waitForElement(driver, Eqp_Type);
			click(driver, Eqp_Type);
			sendKeys(driver, Eqp_Type, Eqp_Type_Input);
			System.out.println("Eqp type:"+Eqp_Type_Input);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(6, "Enter the Equipment type", test, test1);
			Step_Start(7, "Enter the Quantity", test, test1);
			waitForElement(driver, Eqp_Quantity);
			click(driver, Eqp_Quantity);
			Newclear(driver, Eqp_Quantity);
			Actionsendkeys(driver, Eqp_Quantity,Eqp_Quantity_Input );
			Step_End(7, "Enter the Quantity", test, test1);

			Step_Start(8, "Enter the Gross Weight", test, test1);
			waitForElement(driver, RR_Gross_Weight);
			click(driver, RR_Gross_Weight);
			Newclear(driver, RR_Gross_Weight);
			waitForElement(driver, RR_Gross_Weight);
			Actionsendkeys(driver, RR_Gross_Weight, Gross_Weight_Input);
			Step_End(8, "Enter the Gross Weight", test, test1);

			// CheckBox
			waitForElement(driver, DG_checkbox);
			checkBox(driver, DG_checkbox, DG_checkboxs);
			waitForElement(driver, oog_checkbox);
			checkBox(driver, oog_checkbox, OOG_checkbox);
			waitForElement(driver, nor_checkbox); 
			checkBox(driver, nor_checkbox, NOR_checkbox);
			waitForDisplay(driver, flexi_Checkbox_RR);
			if(isdisplayed(driver, flexi_Checkbox_RR)) {
				checkBox(driver, flexi_Checkbox_RR, Flexi_CheckBox);
			}
			waitForDisplay(driver, empty_Checkbox_RR);
			if(isdisplayed(driver, empty_Checkbox_RR)) {
				checkBox(driver, empty_Checkbox_RR, MTY_CheckBox);
			}
			waitForElement(driver, soc_checkbox); 
			checkBox(driver, soc_checkbox, SOC_checkbox);

			if(OOG_checkbox.equalsIgnoreCase("Yes")) {
				waitForElement(driver, OOG_Length_Field);
				sendKeys(driver, OOG_Length_Field,Length_Field_Input );

				waitForElement(driver, OOG_Width_Field);
				sendKeys(driver, OOG_Width_Field, Width_Field_Input);

				waitForElement(driver, OOG_Height_Field);
				sendKeys(driver, OOG_Height_Field,Height_Field_Input );			

				waitForElement(driver, OOG_Ok_Btn);
				click(driver, OOG_Ok_Btn);
			}


			//		//RadioButton
			if(!Pre_Carriage_Radiobtn.equals("")) {
				if(!Pre_Carriage_Radiobtn.equals("")) {
					formatLocatorClick(driver, pre_Carriage_Radiobtn, Pre_Carriage_Radiobtn);
				}
			}
			if(!On_Carriage_Radiobtn.equals("")) {

				if(!On_Carriage_Radiobtn.equals("")) {
					formatLocatorClick(driver, on_Carriage_Radiobtn, On_Carriage_Radiobtn);
				}
			}


			rateRequestRoutingDays(driver, Exp_Det_Days_Input, Imp_Det_Days_Input, Exp_Demmurage_Input, Imp_Demmurage_Input);
			Step_Start(9, "Click routing", test, test1);
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
				sendKeys(driver, Routing_service_TF, routing_Service);
				waitForElement(driver, select_First_Routing);

				doubleClick(driver, select_First_Routing);

			}else {
				Extent_fail(driver, actRoutingFrame+" is not displayed", test,test1);
				System.out.println(actRoutingFrame+" is not displayed");
			}

			Step_End(10, "Select the routing", test, test1);
			rateRequestPaymentMode_Select(driver, payment_Mode,Select_type_location, condition, payLocation);
			Step_Start(11, "Enter the OFR", test, test1);
			waitForElement(driver, OFR_Txt_Field);
			clear(driver, OFR_Txt_Field);
			sendKeys(driver, OFR_Txt_Field, OFR_Txt_Field_Input);
			System.out.println("OFR Value:"+OFR_Txt_Field_Input);
			Step_End(11, "Enter the OFR", test, test1);

			Step_Start(12, "Click Add", test, test1);
			waitForElement(driver, Rate_AddBtn);
			click(driver, Rate_AddBtn);
			Step_End(12, "Click Add", test, test1);

		Step_Start(13, "Double click on the added port pair.", test, test1);
		formatLocatorDoubleClick(driver, portPair, Origin_Input);
		Step_End(13, "Double click on the added port pair.", test, test1);

		//			scrollTop(driver);
		Step_Start(14, "Change the details above added previously", test, test1);
		waitForElement(driver,Rate_edit_btn );
		if(IsElementEnabled(driver, Rate_edit_btn)) {
			System.out.println("Edit button is enabled");
			clear(driver, Commodity_Input);
			Newclear(driver, Commodity_Input);
		Actionsendkeys(driver, Commodity_Input, commodity2);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			rateRequestDateSelect(driver, date_Perform, datePicker, From_Date_Input_Edit, To_Date_Input_Edit);

			Step_End(14, "Change the details above added previously", test, test1);

			Step_Start(15, "Click Edit.", test, test1);

			waitForElement(driver, Rate_edit_btn);
			click(driver, Rate_edit_btn);
			Step_End(15, "Click Edit.", test, test1);
		}
		else {
			System.out.println("Edit button is not enabled");
		}

		waitForElement(driver, Commodity_Input);
		String actualCommodity=getAttribute(driver, Commodity_Input, "value");
		if(actualCommodity.contains(commodity2)) {

			Extent_pass_New(driver, "Matched || Expected Commodity :"+commodity2+" || Actual Commodity : "+actualCommodity, test, test1);
			System.out.println("Matched || Expected Commodity :"+commodity2+" || Actual Commodity : "+actualCommodity);
		}else {
			System.out.println("Not Matched || Expected Commodity :"+commodity2+" || Actual Commodity : "+actualCommodity);
			Extent_fail(driver, "Not Matched || Expected Commodity :"+commodity2+" || Actual Commodity : "+actualCommodity, test, test1);

		}

		waitForElement(driver, From_Date_Field_RR);
		String actualFromDate=getAttribute(driver, From_Date_Field_RR, "value");
		if(actualFromDate.equals(From_Date_Input_Edit)) {

			Extent_pass_New(driver, "Matched || Expected From Date :"+From_Date_Input_Edit+" || Actual From Date : "+actualFromDate, test, test1);
			System.out.println("Matched || Expected From Date :"+From_Date_Input_Edit+" || Actual From Date : "+actualFromDate);
		}else {
			System.out.println("Not Matched || Expected From Date :"+From_Date_Input_Edit+" || Actual From Date : "+actualFromDate);
			Extent_fail(driver, "Not Matched || Expected From Date :"+From_Date_Input_Edit+" || Actual From Date : "+actualFromDate, test, test1);
		}

		waitForElement(driver, To_Date_Field_RR);
		String actualToDate=getAttribute(driver, To_Date_Field_RR, "value");
		System.out.println(actualToDate);
		if(actualToDate.equals(To_Date_Input_Edit)) {

			Extent_pass_New(driver, "Matched || Expected To Date :"+To_Date_Input_Edit+" || Actual To Date : "+actualToDate, test, test1);
			System.out.println("Matched || Expected To Date :"+To_Date_Input_Edit+" || Actual To Date : "+actualToDate);
		}else {
			System.out.println("Not Matched || Expected To Date :"+To_Date_Input_Edit+" || Actual To Date : "+actualToDate);
			Extent_fail(driver, "Not Matched || Expected To Date :"+To_Date_Input_Edit+" || Actual To Date : "+actualToDate, test, test1);
		}

		Step_Start(16, "Click Save button in the tool bar", test, test1);
		waitForElement(driver,SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(16, "Click Save button in the tool bar", test, test1);

		waitForElement(driver, Rate_Sub_Popup_Msg);  

		waitForPopup(driver, Rate_Sub_Popup_Msg, Req_Submit_Popup_Txt);

		String PopUp_Msg=getText(driver, Rate_Sub_Popup_Msg);                                                                                                            
		if(Req_Submit_Popup_Txt.equals(PopUp_Msg)) {                                                                                                                  
			System.out.println("Matched || " + " Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg);            
			Extent_pass_New(driver, "Matched || " + " Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg, test, test1);     
			Step_Start(17, "Click submit", test, test1);
			waitForElement(driver, Rate_SubmitBtn);
			click(driver, Rate_SubmitBtn);
			Step_End(17, "Click submit", test, test1);

			Step_Start(18, "Click Ok", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(18, "Click Ok", test, test1);

		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg);        
			Extent_fail(driver, "Not Matched || " + " Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg, test, test1); 
		} 


		//	waitForElement(driver, Popup_Message);      


		waitForPopup(driver, Popup_Message, Rate_Req_Submitted_Popup_Txt);

		String PopUp_Msg2=getText(driver,Popup_Message);
		System.out.println("PopUp_Msg : "+PopUp_Msg2);   
		if(Rate_Req_Submitted_Popup_Txt.equals(PopUp_Msg2)) {                                                                                                                  
			System.out.println("Matched || " + " Expected : popup message should be shown as : " + Rate_Req_Submitted_Popup_Txt + " || Actual : popup message is shown as : as : " + PopUp_Msg2);            
			Extent_pass_New(driver, "Matched || " + " Expected : popup message should be shown as : " + Rate_Req_Submitted_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg2, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected : popup message should be shown as : " + Rate_Req_Submitted_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg2);        
			Extent_fail(driver, "Not Matched || " + " Expected : popup message should be shown as : " + Rate_Req_Submitted_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg2, test,test1); 
		} 

		waitForElement(driver, Req_No_Txt_Field); 
		String Act_ReqNo=getAttribute(driver, Req_No_Txt_Field, "value");                                                                                                            
		if(!Act_ReqNo.equals("")) {                                                                                                                  
			System.out.println("Matched || " + " The Generated Reference Request No is : "+Act_ReqNo);            
			Extent_pass_New(driver, "Matched || " + " The Generated Reference Request No is : "+Act_ReqNo, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || The Reference Request No is Not Generated");        
			Extent_fail(driver, "Not Matched || The Reference Request No is Not Generated", test,test1); 
		} 
		waitForElement(driver, Request_Status); 
		String act_Req_Status1 = getAttribute(driver, Request_Status,"value");
		if(Req_Status_Exp.equals(act_Req_Status1)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Req_Status_Exp + " || Actual Report Activity is : " + act_Req_Status1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Req_Status_Exp + " || Actual Report Activity is : " + act_Req_Status1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Req_Status_Exp + " || Actual Report Activity is : " + act_Req_Status1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Req_Status_Exp + " || Actual Report Activity is : " + act_Req_Status1, test,test1); 
		} 

		waitForDisplay(driver, Mail_Cancel_button);
		if(isdisplayed(driver, Mail_Cancel_button)) {
		click(driver, Mail_Cancel_button);
		}
		if(delete_perform.equalsIgnoreCase("Yes")) {
			Extent_call(test, test1, "Rate request Delete Started");

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			moduleNavigate(driver, Module_SRR_Gate);

			//SRR Gate

			//Submitted	


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
			sendKeys(driver, filter_Inputfield, Act_ReqNo);
			enter(driver);

			waitForElement(driver, select_Actual_ReqNo);
			String submitted_ReqNum1=getText(driver, select_Actual_ReqNo);
			if(submitted_ReqNum1.equals(Act_ReqNo)) {
				System.out.println("Matched || " + " Expected Value is : " + Act_ReqNo + " || Actual Value is : " + submitted_ReqNum1);
				Extent_pass_New(driver,"Matched || " + " Expected Value is : " + Act_ReqNo + " || ActualValue is : " + submitted_ReqNum1,test,test1);
				Extent_pass_New(driver, Act_ReqNo+"  is submitted", test,test1);
				System.out.println(Act_ReqNo+" is submitted");
				waitForElement(driver, select_Actual_ReqNo);
				click(driver, select_Actual_ReqNo);
				waitForElement(driver, select_Actual_ReqNo);
				RightClick(driver, select_Actual_ReqNo);
				waitForElement(driver, moveTo_Pending);
				click(driver, moveTo_Pending);
				waitForElement(driver, close_Moved_Pending_Popup);
				click(driver, close_Moved_Pending_Popup);
			}else {
				System.out.println("Not matched || " + " Expected Value is : " + Act_ReqNo + " || Actual Value  is : " + submitted_ReqNum1);
				Extent_fail(driver,"Not matched || " + " Expected Value is : " + Act_ReqNo + " || Actual Value is : " + submitted_ReqNum1,test,test1);
				Extent_fail(driver, Act_ReqNo+" Error is not displayed", test,test1);
				System.out.println(Act_ReqNo+" is not submitted");
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
			sendKeys(driver, filter_Inputfield, Act_ReqNo);
			enter(driver);

			waitForElement(driver, select_Actual_ReqNo);
			String pending_ReqNum1=getText(driver, select_Actual_ReqNo);
			if(pending_ReqNum1.equals(Act_ReqNo)) {
				System.out.println("Matched || " + " Expected Value is : " + Act_ReqNo + " || Actual Value is : " + pending_ReqNum1);
				Extent_pass_New(driver,"Matched || " + " Expected Value is : " + Act_ReqNo + " || ActualValue is : " + pending_ReqNum1,test,test1);

				waitForElement(driver, select_Actual_ReqNo);
				click(driver, select_Actual_ReqNo);
				waitForElement(driver, select_Actual_ReqNo);
				doubleClick(driver, select_Actual_ReqNo);

				//added
				waitForElement(driver, cancel_Common_btn);
				click(driver, cancel_Common_btn);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, Condition_Value,Rate_Request_NO,Act_ReqNo,"", "", "","");



				waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);
				waitForElement(driver, delete_Request_Popup);
				click(driver, delete_Request_Popup_Ok);

				waitForElement(driver, comment_Ok_Button);
				click(driver, comment_Ok_Button);

			}else {
				System.out.println("Not matched || " + " Expected Value is : " + Act_ReqNo + " || Actual Value  is : " + pending_ReqNum1);
				Extent_fail(driver,"Not matched || " + " Expected Value is : " + Act_ReqNo + " || Actual Value is : " + pending_ReqNum1,test,test1);
			}	
			Extent_call(test, test1, "Rate request Delete Ended");
			waitForElement(driver, srrGate_Module);
			click(driver, srrGate_Module);
			waitForElement(driver,Close_Current_tab );
			click(driver, Close_Current_tab);
		}
		waitForElement(driver,Close_Current_tab);
		click(driver, Close_Current_tab);
		Extent_completed(testcase_Name, test, test1);



	}
}
