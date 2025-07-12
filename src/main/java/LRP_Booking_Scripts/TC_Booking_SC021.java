package LRP_Booking_Scripts;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC021 extends Keywords{

	public void Booking_SC021(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC021";
		String Username = Excel_data.get( "Username");
		String Password = Excel_data.get( "Password");
		String Search = Excel_data.get( "Search_input");
		String delivery = Excel_data.get( "Delivery");
		String Agt = Excel_data.get( "AGR_Party");
		String agencyUser = Excel_data.get( "AgencyUser");
		//Locator
		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);

		Extent_call(test, test1,"********** Switch the Profile - Start **********");
		SwitchProfile(driver,agencyUser);

		Extent_call(test, test1,"********** Switch the Profile  - End **********");

		System.out.println("********** Enter Booking Module **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		moduleNavigate(driver, Search);
		Step_Start(1, "Enter the Agr Party Input",test, test1);
		waitForElement(driver, AgrPartyInput);
		sendKeys(driver, AgrPartyInput, Agt);
		keyDown(driver);
		enter(driver); 
		Step_End( 1, "Enter the Agr Party Input",test, test1);
		Step_Start(2, "Enter the PODand enter the Down Arrow ", test, test1);

		waitForElement(driver, DeliveryInput);
		sendKeys(driver, DeliveryInput,delivery );

		keyDown(driver);
		Step_End(2, "Enter the PODand enter the Down Arrow ", test, test1);
		Step_Start(3, "Verify the details", test, test1);
		waitForDisplay(driver, Port_Detail);
		if(isDisplayed(driver,Port_Detail)) {
			System.out.println("Matched || The Expected Result is The Ports Details Should List || The Actual Result is : The Port Details are Listed.");
			Extent_pass_New(driver, "Matched || The Expected Result is The Ports Details Should List || The Actual Result is : The Port Details are Listed.", test,test1);
			List<WebElement> Port_Code = listOfElements(driver, Port_Codes);
			for(WebElement code:Port_Code) {
				System.out.println("********************The Listed Port is "+code.getText()+"********************");
				Extent_pass_New(driver, "********************The Listed Port is "+code.getText()+"********************", test,test1);
			}
			enter(driver);
		}else {
			System.out.println("Not Matched || The Expected Result is The Ports Details Should List || The Actual Result is : The Port Details are Not Listed.");
			Extent_fail(driver, "Not Matched || The Expected Result is The Ports Details Should List || The Actual Result is : The Port Details are Not Listed.", test,test1);
		}
		Step_End(3, "Verify the details", test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}
