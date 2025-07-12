package LRP_Commercial_Rate_Request_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Rate_Request_SC18 extends Keywords {


	public void Rate_Request_SC18(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {


		String testcase_Name="TC_Rate_Request_SC18";

		String user_Name = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Field_Names = Excel_data.get("field_name");
		String Origin_Input = Excel_data.get("Origin_Input");
		String Delivery_Input1 = Excel_data.get("Dehlivery_Input");
		String Commodity_Input_Txt = Excel_data.get("Commodity_Input");
		String Eqp_Type_Input = Excel_data.get("Eqp_Type_Input");		
		String Eqp_Quantity_Input = Excel_data.get("Eqp_Quantity_Input");
		String Gross_Weight_Input = Excel_data.get("Gross_Weight_Input");
		String Exp_Det_Days_Input = Excel_data.get("Exp_Det_Days_Input");
		String Imp_Det_Days_Input = Excel_data.get("Imp_Det_Days_Input");
		String Exp_Demmurage_Input = Excel_data.get("Exp_Demmurage_Input");
		String Imp_Demmurage_Input = Excel_data.get("Imp_Demmurage_Input");
		String OFR_Txt_Field_Input = Excel_data.get("OFR_Txt_Field_Input");
		String Req_Submit_Popup_Txt = Excel_data.get("Req_Submit_Popup_Txt");
		String Resquest_Saved_Msg = Excel_data.get("Resquest_Saved_Msg");
		String grid_Req_Status_Exp_TC18 = Excel_data.get("grid_Req_Status_Exp_TC18");
		String Req_Status_Exp_TC18 = Excel_data.get("Req_Status_Exp_TC18");
		String AgencyUser = Excel_data.get("AgencyUser");
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
		String To_Date_Input =Excel_data.get("To_Date_Input");
		String Pre_Carriage_Radiobtn = Excel_data.get("pre_Carriage_Radiobtn");
		String On_Carriage_Radiobtn = Excel_data.get("On_Carriage_Radiobtn");
		String tService = Excel_data.get("T_Service");
		String TOS=Excel_data.get("TOS_Option");
		String Customer_code_Value2 = Excel_data.get("Customer_code_Value2");
		String Customer_code_Value3 = Excel_data.get("Customer_code_Value3");
		String Cust_code2 = Excel_data.get("Cust_code2");
		String Cust_code3 = Excel_data.get("Cust_code3");
		String date_Picker = Excel_data.get("date_Picker");
		String date_Perform = Excel_data.get("date_Perform");
		String Flexi_CheckBox = Excel_data.get("Flexi_CheckBox");
		String MTY_CheckBox = Excel_data.get("MTY_CheckBox");
		String payment_Mode = Excel_data.get("payment_Mode");
		String Select_type_location = Excel_data.get("Select_type_location");
		String condition = Excel_data.get("condition");
		String payLocation =Excel_data.get("payLocation");




		navigateUrl(driver, url);
		//Login
		Extent_Start(testcase_Name, test, test1);


		//Login
		LRP_Login(driver, user_Name, pass_word);



		//Switch User
		SwitchProfile(driver, AgencyUser);

		//Module search
		moduleNavigate(driver, Field_Names);

		Step_Start(1, "Click on the new button in the toolbar", test, test1);

		//		
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
		// Selecting the From Date

		Extent_call(test, test1, "selecting from date");
		rateRequestDateSelect(driver, date_Perform, date_Picker, From_Date_Input, To_Date_Input);
		// non containerized radio btn


		if (Non_Containerized.equals("YES")) {
			waitForElement(driver, non_containradio_btn);
			safeclick(driver, non_containradio_btn);
		}

		Step_Start(2, "Enter the customer name", test, test1);


		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);


		globalValueSearchWindow(driver, Condition_Value, Customer_Code, Customer_code_Value, Cust_code2, Customer_code_Value2,Cust_code3, Customer_code_Value3);




		waitForDisplay(driver,Popup_Message);

			rateRequestCustomerExistOption(driver);

			Step_End(2, "Enter the customer name", test, test1);


			Step_Start(3, "Enter the origin", test, test1);

			waitForElement(driver, Orgin_Input);
			sendKeys(driver, Orgin_Input, Origin_Input);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			System.out.println("Origin:"+Origin_Input);

			Step_End(3, "Enter the origin", test, test1);


			Step_Start(4, "Enter the Delivery", test, test1);

			waitForElement(driver, RR_Delivery_Input_Field);
			sendKeys(driver, RR_Delivery_Input_Field, Delivery_Input1);

			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(4, "Enter the Delivery", test, test1);

			Step_Start(5, "Enter the Commodity", test, test1);

			waitForElement(driver, Commodity_Input);
			Newclear(driver, Commodity_Input);
		Actionsendkeys(driver, Commodity_Input, Commodity_Input_Txt);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(5, "Enter the Commodity", test, test1);

			Step_Start(6, "Enter the rate calculation type", test, test1);

			waitForElement(driver, Eqp_Type);
			click(driver, Eqp_Type);
			sendKeys(driver, Eqp_Type, Eqp_Type_Input);
			waitForElement(driver, Eqp_Type_Value);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(6, "Enter the rate calculation type", test, test1);

			Step_Start(7, "Enter the Quantity", test, test1);

			waitForElement(driver, Eqp_Quantity);
			click(driver, Eqp_Quantity);
			Newclear(driver, Eqp_Quantity);
			Actionsendkeys(driver, Eqp_Quantity,Eqp_Quantity_Input );
			Step_End(7, "Enter the Quantity", test, test1);

			Step_Start(8, "Enter the Gross Weight", test, test1);

			waitForElement(driver, RR_Gross_Weight);
			Newclear(driver, RR_Gross_Weight);
			Actionsendkeys(driver, RR_Gross_Weight, Gross_Weight_Input);

			Step_End(8, "Enter the Gross Weight", test, test1);

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

			waitForDisplay(driver, Retrived_Tariff_No);

			String Before_Tarriff_no = getText(driver, Retrived_Tariff_No);

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
				sendKeys(driver, Routing_service_TF, Routing_Service);
				doubleClick(driver, select_First_Routing);

			}else {
				Extent_fail(driver, actRoutingFrame+" is not displayed", test,test1);
				System.out.println(actRoutingFrame+" is not displayed");
			}

			Step_End(10, "Select the routing", test, test1);
			rateRequestPaymentMode_Select(driver, payment_Mode,Select_type_location, condition, payLocation);
			Step_Start(11, "Enter the OFR greater than the tariff", test, test1);

			waitForElement(driver, OFR_Txt_Field);
			click(driver, OFR_Txt_Field);
			clear(driver, OFR_Txt_Field);
			sendKeys(driver, OFR_Txt_Field, OFR_Txt_Field_Input);

			Step_End(11, "Enter the OFR greater than the tariff", test, test1);

			Step_Start(12, "Click Add", test, test1);

			waitForElement(driver, Rate_AddBtn);
			click(driver, Rate_AddBtn);

			Step_End(12, "Click Add", test, test1);

			Step_Start(13, "Click Save button in the tool bar", test, test1);

			waitForElement(driver,SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			Step_End(13, "Click Save button in the tool bar", test, test1);

			//	waitForElement(driver, Rate_Sub_Popup_Msg);    

			waitForPopup(driver, Rate_Sub_Popup_Msg, Req_Submit_Popup_Txt);

			String PopUp_Msg=getText(driver, Rate_Sub_Popup_Msg);                                                                                                            
			if(Req_Submit_Popup_Txt.equals(PopUp_Msg)) {                                                                                                                  
				System.out.println("Matched || " + "Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg);            
				Extent_pass_New(driver, "Matched || " + "Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + "Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg);        
				Extent_fail(driver, "Not Matched || " + "Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg, test,test1); 
			} 

			Step_Start(14, "Click submit", test, test1);

			waitForElement(driver, Rate_SubmitBtn);
			click(driver, Rate_SubmitBtn);

			Step_End(14, "Click submit", test, test1);

			Step_Start(15, "Click Ok", test, test1);

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			Step_End(15, "Click Ok", test, test1);

			//waitForElement(driver, submitted_Popup);    

			waitForPopup(driver, Popup_Message, Resquest_Saved_Msg);

			String PopUp_Msg1=getText(driver, Popup_Message);    
			System.out.println("PopUp_Msg : "+PopUp_Msg1);                                                                                                              
			if(Resquest_Saved_Msg.equals(PopUp_Msg1)) {                                                                                                                  
				System.out.println("Matched || " + "Expected : popup message should be shown as : " + Resquest_Saved_Msg + " || Actual : popup message is shown as : " + PopUp_Msg1);            
				Extent_pass_New(driver, "Matched || " + "Expected : popup message should be shown as : " + Resquest_Saved_Msg + " || Actual : popup message is shown as : " + PopUp_Msg1, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + "Expected : popup message should be shown as : " + Resquest_Saved_Msg + " || Actual : popup message is shown as : " + PopUp_Msg1);        
				Extent_fail(driver, "Not Matched || " + "Expected : popup message should be shown as : " + Resquest_Saved_Msg + " || Actual : popup message is shown as : " + PopUp_Msg1, test,test1); 
			} 

			waitForElement(driver, Req_No_Txt_Field); 
			String Act_Req_No=getAttribute(driver, Req_No_Txt_Field, "value");   
			System.out.println(Act_Req_No);
			waitForElement(driver, Retrived_Tariff_No); 
			String after_Tarriff_no = getText(driver, Retrived_Tariff_No);
			if(!(Before_Tarriff_no.equals(after_Tarriff_no))) {                                                                                                                  
				System.out.println("Matched || " + " The Retrived Tariff Number is : " + after_Tarriff_no);            
				Extent_pass_New(driver,"Matched || " + " The Retrived Tariff Number is : " + after_Tarriff_no, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || The Tariff Number is Not  Retrived");        
				Extent_fail(driver, "Not Matched || The Tariff Number is Not  Retrived", test,test1); 
			} 
			waitForElement(driver, RR_Ocean_Freight_Details_Table_Headers);
			List<Map<String, String>> table_Values = getTableData(driver, RR_Ocean_Freight_Details_Table_Headers, RR_Ocean_Freight_Details_Table_Rows);
			String act_Grid_ReqStatus = getFirstValueByHeader(table_Values, "Request Status");
			if(grid_Req_Status_Exp_TC18.equals(act_Grid_ReqStatus)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity is : " + grid_Req_Status_Exp_TC18 + " || Actual Report Activity is : " + act_Grid_ReqStatus);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + grid_Req_Status_Exp_TC18 + " || Actual Report Activity is : " + act_Grid_ReqStatus, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity is : " + grid_Req_Status_Exp_TC18 + " || Actual Report Activity is : " + act_Grid_ReqStatus);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + grid_Req_Status_Exp_TC18 + " || Actual Report Activity is : " + act_Grid_ReqStatus, test,test1); 
			} 
			waitForElement(driver, Request_Status); 
			String act_Req_Status = getAttribute(driver, Request_Status,"value");
			if(Req_Status_Exp_TC18.equals(act_Req_Status)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity is : " + Req_Status_Exp_TC18 + " || Actual Report Activity is : " + act_Req_Status);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Req_Status_Exp_TC18 + " || Actual Report Activity is : " + act_Req_Status, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity is : " + Req_Status_Exp_TC18 + " || Actual Report Activity is : " + act_Req_Status);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Req_Status_Exp_TC18 + " || Actual Report Activity is : " + act_Req_Status, test,test1); 
			} 
			waitForDisplay(driver, Mail_Cancel_button);
		if(isdisplayed(driver, Mail_Cancel_button)) {
		click(driver, Mail_Cancel_button);
		}

			waitForElement(driver,Close_Current_tab);
			click(driver, Close_Current_tab);

			Extent_completed(testcase_Name, test, test1);

	}	
}
