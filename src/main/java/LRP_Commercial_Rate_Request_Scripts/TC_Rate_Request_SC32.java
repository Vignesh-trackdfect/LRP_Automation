package LRP_Commercial_Rate_Request_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Rate_Request_SC32 extends Keywords {


	public void rate_Request_Sc32(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Rate_Request_SC32";


		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("PassWord");
		String Field_Names =Excel_data.get("ModuleRateRequest");
		String Eqp_Type_Input =Excel_data.get("Eqp_Type_Input");
		String Eqp_Quantity_Input =Excel_data.get("Eqp_Quantity_Input");
		String Gross_Weight_Input =Excel_data.get("Gross_Weight_Input");
		String Exp_Det_Days_Input =Excel_data.get("Exp_Det_Days_Input");
		String Imp_Det_Days_Input =Excel_data.get("Imp_Det_Days_Input");
		String Exp_Demmurage_Input =Excel_data.get("Exp_Demmurage_Input");
		String Imp_Demmurage_Input =Excel_data.get("Imp_Demmurage_Input");
		String origin =Excel_data.get("Origin");
		String delivery =Excel_data.get("Delivery");
		String commodity =Excel_data.get("Commodity");
		String Noscheduleexp =Excel_data.get("Noscheduleexp");
		String DG_checkboxs = Excel_data.get("DG_checkboxs");
		String NOR_checkbox = Excel_data.get("NOR_checkbox");
		String SOC_checkbox = Excel_data.get("SOC_checkbox");
		String OOG_checkbox = Excel_data.get("OOG_checkbox");
		String agencyUser = Excel_data.get("Agency_user");
		String Date_Picker = Excel_data.get("Date_Picker");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Customer_Code = Excel_data.get("Cust_code");
		String Routing_Service=Excel_data.get("Routing_Service");
		String Condition_Value = Excel_data.get("Condition_Value");
		String On_Carriage_Radiobtn = Excel_data.get("On_Carriage_Radiobtn");
		String Pre_Carriage_Radiobtn = Excel_data.get("Pre_Carriage_Radiobtn");
		String tService=Excel_data.get("T_Service");
		String TOS=Excel_data.get("TOS_Option");
		String Customer_code_Value2 = Excel_data.get("Customer_code_Value2");
		String Customer_code_Value3 = Excel_data.get("Customer_code_Value3");
		String Cust_code2 = Excel_data.get("Cust_code2");
		String Cust_code3 = Excel_data.get("Cust_code3");
		String date_Perform = Excel_data.get("date_Perform");
		String Flexi_CheckBox = Excel_data.get("Flexi_CheckBox");
		String MTY_CheckBox = Excel_data.get("MTY_CheckBox");


		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, username, pass_word);
		//Switch User
		SwitchProfile(driver, agencyUser);

		//Module search
		moduleNavigate(driver, Field_Names);

		Step_Start(1, "Click on the new button in the toolbar", test, test1);


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
		Step_End(3, "Select Validity From Date range accordingly in date picker ",test, test1);
		// Selecting the to Date
		Step_Start(4, "-Select Validity To Date range accordingly in date picker ",test, test1);
		rateRequestDateSelect(driver, date_Perform, Date_Picker, From_Date_Input, To_Date_Input);

		Step_End(1, "Click on the new button in the toolbar", test, test1);
		Step_Start(2, "Enter the customer name", test, test1);
		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);


		globalValueSearchWindow(driver, Condition_Value, Customer_Code, Customer_code_Value, Cust_code2, Customer_code_Value2,Cust_code3, Customer_code_Value3);


			rateRequestCustomerExistOption(driver);
			Step_Start(3,"Enter the origin", test, test1);
			waitForElement(driver, Orgin_Input);
			sendKeys(driver, Orgin_Input, origin);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			Step_End(3, "Enter the origin", test, test1);

			Step_Start(4, "Enter the Delivery.", test, test1);
			waitForElement(driver,  RR_Delivery_Input );
			sendKeys(driver,  RR_Delivery_Input , delivery);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			System.out.println("Delivery Value:" + delivery);
			Step_End(4, "Enter the Delivery.", test, test1);
			Step_Start(5, "Enter the Commodity.", test, test1);
			waitForElement(driver, Commodity_Input);
			Newclear(driver, Commodity_Input);
		Actionsendkeys(driver, Commodity_Input, commodity);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			System.out.println("Commodity Value:" + commodity);
			Step_End(5, "Enter the Commodity.", test, test1);
			Step_Start(6, ".Enter the rate calculation type.", test, test1);
			waitForElement(driver, Eqp_Type);
			click(driver, Eqp_Type);
			sendKeys(driver, Eqp_Type, Eqp_Type_Input);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			System.out.println("Eqp type:"+Eqp_Type_Input);
			Step_End(6, "Enter the rate calculation type.", test, test1);
			Step_Start(7, "Enter the Quantity.", test, test1);
			waitForElement(driver, Eqp_Quantity);
			click(driver, Eqp_Quantity);
			Newclear(driver, Eqp_Quantity);
			Actionsendkeys(driver, Eqp_Quantity,Eqp_Quantity_Input );
			Step_End(7, "Enter the Quantity.", test, test1);
			Step_Start(8, "Enter the Gross Weight.", test, test1);

			waitForElement(driver, RR_Gross_Weight);
			Newclear(driver, RR_Gross_Weight);
			Actionsendkeys(driver, RR_Gross_Weight, Gross_Weight_Input);

			Step_End(8, "Enter the Gross Weight.", test, test1);

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
			if(!Pre_Carriage_Radiobtn.equals("")) {
				formatLocatorClick(driver, pre_Carriage_Radiobtn, Pre_Carriage_Radiobtn);
			}

			if(!On_Carriage_Radiobtn.equals("")) {
				formatLocatorClick(driver, on_Carriage_Radiobtn, On_Carriage_Radiobtn);
			}

			rateRequestRoutingDays(driver, Exp_Det_Days_Input, Imp_Det_Days_Input, Exp_Demmurage_Input, Imp_Demmurage_Input);
			Step_Start(9, "Click routing.", test, test1);


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
				sendKeys(driver, Routing_OriginTF, origin);
				waitForElement(driver, Routing_service_TF);
				sendKeys(driver, Routing_service_TF, Routing_Service);
				waitForElement(driver, select_First_Routing);
				doubleClick(driver, select_First_Routing);
			}else {		
				System.out.println(actRoutingFrame+" is not displayed");
				Extent_fail(driver, actRoutingFrame+" is not displayed", test,test1);
			}

			Step_End(10,"Select the routing.", test, test1);



			waitForElement(driver, schedules_Button);
			click(driver, schedules_Button);
			waitForPopup(driver, Popup_Message, Noscheduleexp);
			String PopUp_Msg6=getText(driver, Popup_Message);    
			System.out.println(PopUp_Msg6);
			if(Noscheduleexp.equals(PopUp_Msg6)) {                                                                                                                  
				System.out.println("Matched || " + "Expected : popup message should be shown as : " + Noscheduleexp + " || Actual : popup message is shown as : " + PopUp_Msg6);            
				Extent_pass_New(driver, "Matched || " + "Expected : popup message should be shown as : " + Noscheduleexp + " || Actual : popup message is shown as : " + PopUp_Msg6, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + "Expected : popup message should be shown as : " + Noscheduleexp + " || Actual : popup message is shown as : " + PopUp_Msg6);        
				Extent_fail(driver, "Not Matched || " + "Expected : popup message should be shown as : " + Noscheduleexp + " || Actual : popup message is shown as : " + PopUp_Msg6, test,test1); 

			} 

		Extent_completed(testcase_Name, test, test1);

	}


}

