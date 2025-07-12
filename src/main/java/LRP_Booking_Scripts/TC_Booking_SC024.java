package LRP_Booking_Scripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Map;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC024 extends Keywords{
	public void Booking_SC024(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC024";

		String Username =Excel_data.get("Username");
		String Password =Excel_data.get("Password");
		String Search =Excel_data.get("Search_input");
		String delivery =Excel_data.get("Delivery");
		String Agt =Excel_data.get("AGR_Party");
		String orgin =Excel_data.get("Orgin");
		String agencyUser = Excel_data.get("AgencyUser");
		String Select_Columns = Excel_data.get("Select_Columns");
		String Commodity_Chk_Box_Exp = Excel_data.get("Commodity_Chk_Box");
		String DG_Chk_Box_Exp = Excel_data.get("DG_Chk_Box");
		String Tar_Chk_Box_Exp = Excel_data.get("Tar_Chk_Box");
		String AFF_Chk_Box_Exp = Excel_data.get("AFF_Chk_Box");
		String Tariff_Input = Excel_data.get("Tariff_Input");

		//locators

		Extent_Start(test_Case_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver, agencyUser);
		Extent_call(test, test1,"********** Switch the Profile  - End **********");
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
		waitForElement(driver, Rate_Type_Coluomn_Field);
		sendKeys(driver, Rate_Type_Coluomn_Field,Tariff_Input);

		Step_Start(4, "select the TAR check box ", test, test1);
		waitForElement(driver, Commodity_Chk_Box);
		checkBox(driver, Commodity_Chk_Box,Commodity_Chk_Box_Exp);
		waitForElement(driver, DG_Chk_Box);
		checkBox(driver, DG_Chk_Box,DG_Chk_Box_Exp);
		waitForElement(driver, Tar_Chk_Box);
		checkBox(driver, Tar_Chk_Box,Tar_Chk_Box_Exp);
		waitForElement(driver, AFF_Chk_Box);
		checkBox(driver, AFF_Chk_Box,AFF_Chk_Box_Exp);
		waitForElement(driver, Rates_Show_Btn);
		safeclick(driver, Rates_Show_Btn);
		Step_End(4, "select the TAR check box ", test, test1);
		Extent_call(test, test1,"********** Select the Columns in Rates Window  **********");
		reArrangeAG_GridColumns(driver, Select_Columns);
		Extent_call(test, test1,"********** Create the condition filter in Rates Window **********");
		waitForElement(driver, rateref_toolbtn);
		safeclick(driver, rateref_toolbtn);

		waitForElement(driver, rateref_cond_filter);
		safeclick(driver, rateref_cond_filter);
		waitForElement(driver, Rate_Type_Coluomn_Field);
		sendKeys(driver, Rate_Type_Coluomn_Field,Tariff_Input);

		waitForElement(driver, Rate_Type_Column);
		Step_Start(5, "system list the TAR Rates details", test, test1);
		Extent_call(test, test1,"********** Step:5 After select the Tariff check box fetch the tariff value from the Rate type column  in Rates Window - Start **********");
		waitForDisplay(driver, RateType_Column_Value);
		if(isDisplayed(driver, RateType_Column_Value)) {
			List<WebElement> comm_Value =listOfElements(driver, Rates_Columns);
			for(int i = 1; i<comm_Value.size();i++) {
				String	tar_Values = String.format(Tar_Values,i);
				String	rate_No =  String.format(Rate_No,i);
				String after_Tariff_Value = getText(driver, tar_Values);
				String after_Rate_No = getText(driver, rate_No);
				if(verifyElementHasText(driver, rate_No)) {
					System.out.println("Matched || The Expected Result is : The Tariff Numbers Should show in the Grid || The Actual Result is : The Tariff value is Showed in the grid. The Grid values are : " + after_Tariff_Value+" || and the Rate number is : "+after_Rate_No);            
					Extent_pass_New(driver,"Matched || The Expected Result is : The Tariff Numbers Should show in the Grid || The Actual Result is : The Tariff value is Showed in the grid. The Grid values are : " + after_Tariff_Value+" || and the Rate number is : "+after_Rate_No, test,test1);
					mouseOverToElement(driver, tar_Values);
					click(driver, tar_Values);
				}else{
					System.out.println("Matched || The Expected Result is : The Tariff Numbers Should show in the Grid || The Actual Result is : Tariff values not Showed in the Grid ");
					Extent_fail(driver,"Matched || The Expected Result is : The Tariff Numbers Should show in the Grid || The Actual Result is : Tariff values not Showed in the Grid ", test,test1);
				}
			}
		}else {                                                                                                                                                                   
			System.out.println("Matched || The Expected Result is : The Tariff Numbers Should show in the Grid || The Actual Result is : Tariff values not Showed in the Grid ") ;        
			Extent_fail(driver,"Matched || The Expected Result is : The Tariff Numbers Should show in the Grid || The Actual Result is : Tariff values not Showed in the Grid ", test,test1); 
		}
		Step_End(5, "system list the TAR Rates details", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}
