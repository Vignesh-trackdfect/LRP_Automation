package LRP_Booking_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


//check whether in booking, while add MRG Rates system carry forward the carrier Term Correctly
public class TC_Booking_SC082 extends Keywords{
	
	public void Booking_SC082(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC082";
		
		
		


		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String BookingMoudleSearch =Excel_data.get("Search_input");
		String delivery =Excel_data.get("Delivery");
		String Agt =Excel_data.get("AGR_Party");
		String orgin =Excel_data.get("Orgin");
		String agencyUser = Excel_data.get("AgencyUser");
		String Select_Columns = Excel_data.get("Select_Columns");
		String Commodity_Chk_Box_Exp = Excel_data.get("Commodity_Chk_Box");
		String Tar_Chk_Box_Exp = Excel_data.get("Tar_Chk_Box");
		String AFF_Chk_Box_Exp = Excel_data.get("AFF_Chk_Box");
		String Tariff_Input = Excel_data.get("Tariff_Input");
		String rate_no = Excel_data.get("rate_no");
		String Equip_Type = Excel_data.get("Equip_Type");
				
		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);
		Extent_call(test, test1,"********** Switch the Profile - End **********");

		Extent_call(test, test1,"********** Enter Booking Module **********");

		moduleNavigate(driver, BookingMoudleSearch);

		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);

		Step_Start(2, "Enter the POL and POD ",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		tab(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the POL and POD ",test, test1);
		Step_Start(3, "Click Rate button system list the Rates Details", test, test1);
		waitForElement(driver, RatedBtn);
		safeclick(driver, RatedBtn);
		waitForElement(driver, $Rates);
		safeclick(driver, $Rates);

		Step_End(3, "Click Rate button system list the Rates Details", test, test1);

		Step_Start(4, "select the TAR check box ", test, test1);
		waitForElement(driver, Commodity_Chk_Box);
		checkBox(driver, Commodity_Chk_Box,Commodity_Chk_Box_Exp);
		waitForElement(driver, Tar_Chk_Box);
		checkBox(driver, Tar_Chk_Box,Tar_Chk_Box_Exp);
		waitForElement(driver, AFF_Chk_Box);
		checkBox(driver, AFF_Chk_Box,AFF_Chk_Box_Exp);
		waitForElement(driver, Rates_Show_Btn);
		safeclick(driver, Rates_Show_Btn);
		Step_End(4, "select the TAR check box ", test, test1);
		Extent_call(test, test1,"********** Select the Columns in Rates Window  **********");
		
		
		reArrangeAG_GridColumns(driver, Select_Columns);
		
	

		System.out.println("********** Create the condition filter in Rates Window **********");
		Extent_call(test, test1,"********** Create the condition filter in Rates Window **********");
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);
		waitForElement(driver, Rate_Type_Coluomn_Field);
		sendKeys(driver, Rate_Type_Coluomn_Field,Tariff_Input);
		waitForElement(driver, rate_filter_inp);
		sendKeys(driver, rate_filter_inp, rate_no);
		waitForElement(driver, eqp_Type_inp);
		sendKeys(driver, eqp_Type_inp, Equip_Type);
		waitForElement(driver, Carriage_contract);
		String ratescarriageContract = getText(driver, Carriage_contract);
		waitForElement(driver, Rate_No_Select);
		safeclick(driver, Rate_No_Select);
		waitForElement(driver, ok_btn);
		safeclick(driver, ok_btn);
		waitForDisplay(driver, no_schedule_popup);
		if(isdisplayed(driver,no_schedule_popup)) {
			safeclick(driver, popup_Message_Ok_Button);
		}
	
		waitForDisplay(driver, Invalid_date_popup);		
		if(isdisplayed(driver,Invalid_date_popup)) {
			safeclick(driver, Invalid_date_popup_Close);
		}
		Step_Start(8, "system carryfoward the Carriage Term", test, test1);
		waitForElement(driver,carriage_Contract);
		String carriageContract = getAttribute(driver, carriage_Contract,"value");
		if(ratescarriageContract.equals(carriageContract)) {
			System.out.println("Matched || " + " Rates window carriage Contract value is : " + ratescarriageContract + " ||  Actual carriage Contract value is : " + carriageContract);            
			Extent_pass_New(driver, "Matched || " + " Rates window carriage Contract value is : " + ratescarriageContract + " ||  Actual carriage Contract value is : " + carriageContract, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Rates window carriage Contract value is : " + ratescarriageContract + " ||  Actual carriage Contract value is : " + carriageContract);        
			Extent_fail(driver, "Not Matched || " + " Rates window carriage Contract value is : " + ratescarriageContract + " ||  Actual carriage Contract value is : " + carriageContract, test,test1); 
		} 
		Step_End(8, "system carryfoward the Carriage Term", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}
