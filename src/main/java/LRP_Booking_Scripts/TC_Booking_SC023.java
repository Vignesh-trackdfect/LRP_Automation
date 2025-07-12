package LRP_Booking_Scripts;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


public class TC_Booking_SC023 extends Keywords  {
	public void Booking_SC023(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC023";

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
		Extent_call(test, test1,"********** Before select the commodity check box Fetch the values from commodity column **********");
		String before_Comm_Value = getText(driver, Commodity_Column_Value);
		System.out.println("before_Comm_Value : "+before_Comm_Value);
		Step_Start(4, "select the commodity check box", test, test1);
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
		Step_End(4, "select the commodity check box", test, test1);
		Extent_call(test, test1,"********** Select the Columns in Rates Window  **********");
		reArrangeAG_GridColumns(driver, Select_Columns);
		Step_Start(5, "system list the commodity details", test, test1);
		Extent_call(test, test1,"********** After select the commodity check box Fetch the values from commodity column - Start **********");
		waitForElement(driver, Commodity_Column);
		List<WebElement> comm_Value =listOfElements(driver, Commodity_Column_Value);
		for(WebElement element :comm_Value) {
			String After_Comm_Value = getText1(driver, element);
			if(!before_Comm_Value.equals(After_Comm_Value)) {
				System.out.println("Matched || Expected Before Commodity Value : " + before_Comm_Value + " || Actual After Commodity Value : " + After_Comm_Value);            
				Extent_pass_New(driver, "Matched ||  Expected Before Commodity Value : " + before_Comm_Value + " || Actual After Commodity Value : " + After_Comm_Value, test,test1);
			}else {      
				System.out.println("Not Matched ||  Expected Before Commodity Value : " + before_Comm_Value + " || Actual After Commodity Value : " + After_Comm_Value+"There is no value");        
				Extent_fail(driver, "Not Matched ||  Expected Before Commodity Value : " + before_Comm_Value + " || Actual After Commodity Value : " + After_Comm_Value+"There is no value", test,test1); 
			}
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
			act.click().build().perform();
		}			     
		Extent_call(test, test1,"********** Step:5 After select the commodity check box Fetch the values from commodity column - End **********");
		Step_End(5, "system list the commodity details", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}