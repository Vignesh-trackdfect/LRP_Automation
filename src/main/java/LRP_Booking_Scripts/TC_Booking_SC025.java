package LRP_Booking_Scripts;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Booking_SC025 extends Keywords{
	public void Booking_SC025(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC025";

		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String Search =Excel_data.get("Search_input");
		String Agt =Excel_data.get("AGR_Party");
		String delivery =Excel_data.get("Delivery");
		String orgin =Excel_data.get("Orgin");
		String agencyUser = Excel_data.get("AgencyUser");
		String Select_Columns = Excel_data.get("Select_Columns");
		String Commodity_Chk_Box_Exp = Excel_data.get("Commodity_Chk_Box");
		String DG_Chk_Box_Exp = Excel_data.get("DG_Chk_Box");
		String Tar_Chk_Box_Exp = Excel_data.get("Tar_Chk_Box");
		String DG_Input = Excel_data.get("DG_Input");


		//locators

		Extent_Start(test_Case_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);
		Extent_call(test, test1,"********** Switch the Profile  - End **********");

		System.out.println("********** Enter Booking Module **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		moduleNavigate(driver, Search);
		Step_Start(1, "Enter the Agreement Party",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		tab(driver);
		Step_End(1, "Enter the Agreement Party",test, test1);

		Step_Start(2, "Enter the POL and POD ",test, test1);
		waitForElement(driver, OrginInput);
		sendKeys(driver, OrginInput, orgin);
		keyDown(driver);
		enter(driver);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput, delivery);
		tab(driver);
		Step_End(2, "Enter the POL and POD ",test, test1);
		waitForDisplay(driver, Rate_Grid);
		if(isdisplayed(driver, Rate_Grid)) {
			System.out.println("*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed");            
			Extent_pass_New(driver,"*The Expected Result is : The Rate Lists Should be Shown || The Actual Result is : The Rate Lists are Showed", test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			waitForElement(driver, RatedBtn);
			safeclick(driver, RatedBtn);
			Step_End(2, "Enter the POL and POD and select the Rates using Rates window.",test, test1);
			waitForElement(driver, $Rates);
			safeclick(driver, $Rates);
		} 
		Step_End(3, "Click Rate button system list the Rates Details", test, test1);

		Extent_call(test, test1,"********** Select the Columns in Rates Window  **********");
		reArrangeAG_GridColumns(driver, Select_Columns);

		Extent_call(test, test1,"********** Create the condition filter in Rates Window **********");
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);
		waitForElement(driver, DG_Column_Field);
		sendKeys(driver, DG_Column_Field,DG_Input);
		waitForElement(driver, UnNo_Column_Field);
		safeclick(driver, UnNo_Column_Field);

		Step_Start(4, "select the DG check box ", test, test1);
		waitForElement(driver, Commodity_Chk_Box);
		checkBox(driver, Commodity_Chk_Box,Commodity_Chk_Box_Exp);
		waitForElement(driver, DG_Chk_Box);
		checkBox(driver, DG_Chk_Box,DG_Chk_Box_Exp);
		waitForElement(driver, Tar_Chk_Box);
		checkBox(driver, Tar_Chk_Box,Tar_Chk_Box_Exp);
		waitForElement(driver, Rates_Show_Btn);
		safeclick(driver, Rates_Show_Btn);
		Step_End(4, "select the DG check box ", test, test1);		
		Extent_call(test, test1,"********** Select the Columns in Rates Window **********");
		reArrangeAG_GridColumns(driver, Select_Columns);
		Extent_call(test, test1,"********** Create the condition filter in Rates Window **********");
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);
		waitForElement(driver, DG_Column_Field);
		sendKeys(driver, DG_Column_Field,DG_Input);
		Step_Start(5, "system list the DG details", test, test1);
		Extent_call(test, test1,"********** After select the DG check box fetch DG tariff value from the Rate type column  in Rates Window - Start **********");

		List<WebElement> comm_Value =listOfElements(driver, UnNo_Columns);
		for(int i = 0; i<comm_Value.size();i++) {
			String UnNoValue =String.format(UnNo_Value,(i+1));
			String ImdgValue = String.format(Imdg_Value,(i+1));
			String DGClassValue = String.format(DGClass_Value,(i+1));
			waitForElement(driver, UnNoValue);
			String after_UnNo_Value = getText(driver, UnNoValue);
			waitForElement(driver, ImdgValue);
			String after_Imdg_Value = getText(driver, ImdgValue);
			waitForElement(driver, DGClassValue);
			String after_DGClass_Value = getText(driver, DGClassValue);
			waitForDisplay(driver, UnNoValue);

			if(isDisplayed(driver, UnNoValue)) {
				System.out.println("Matched || Expected Result is : After Selecting the DG Check box The DG values Should Display || Actual Result is : After Selecting the DG Check box The DG values Are Displayed || The UN NO column Value is : "+after_UnNo_Value+" || The IMDG Name column Value is : "+ after_Imdg_Value+" || The DG Class column Value is : "+after_DGClass_Value);            
				Extent_pass_New(driver,"Matched || Expected Result is : After Selecting the DG Check box The DG values Should Display || Actual Result is : After Selecting the DG Check box The DG values Are Displayed || The UN NO column Value is : "+after_UnNo_Value+" || The IMDG Name column Value is : "+ after_Imdg_Value+" || The DG Class column Value is : "+after_DGClass_Value, test,test1);
				mouseOverToElement(driver, UnNoValue);
				click(driver, UnNoValue);
			}else {      
				System.out.println("Not Matched || Expected Result is : After Selecting the DG Check box The DG values Should Display || Actual Result is : After Selecting the DG Check box The DG values Are Not Displayed" );        
				Extent_fail(driver, "Not Matched || Expected Result is : After Selecting the DG Check box The DG values Should Display || Actual Result is : After Selecting the DG Check box The DG values Are Not Displayed", test,test1); 
				break;
			}	
		}
		Step_End(5, "system list the DG details", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}