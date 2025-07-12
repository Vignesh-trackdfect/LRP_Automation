package LRP_Booking_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Booking_SC008 extends Keywords {
	public void Booking_SC008(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String test_Case_Name = "TC_Booking_SC008";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String search_module = Excel_data.get("search_module");
		String agencyUser = Excel_data.get("agencyUser");
		String Templatesavpopexp = Excel_data.get("Templatesavpopexp");
		String Global_Search_Type_1 = Excel_data.get("Global_Search_Type_1");
		String Global_Search_Type_2 = Excel_data.get("Global_Search_Type_2");
		String Global_Search_Type_3 = Excel_data.get("Global_Search_Type_3");
		String Global_Search_Condition = Excel_data.get("Global_Search_Condition");
		String Global_Search_Input_1 = Excel_data.get("Global_Search_Input_1");
		String Global_Search_Input_2 = Excel_data.get("Global_Search_Input_2");
		String Global_Search_Input_3 = Excel_data.get("Global_Search_Input_3");

		Extent_Start(test_Case_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		System.out.println("***Switch the Profile Start ***");
		Extent_call(test, test1,"********** Switch the Profile Start **********");
		SwitchProfile(driver, agencyUser);
		System.out.println("********** Switch the Profile End **********");
		Extent_call(test, test1,"********** Switch the Profile End **********");
		System.out.println("********** Enter Booking Module **********");
		Extent_call(test, test1,"********** Enter Booking Module **********");
		moduleNavigate(driver, search_module);
		Step_Start(1, "Retrive the template saved booking number",test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver,Global_Search_Condition, Global_Search_Type_1, Global_Search_Input_1, Global_Search_Type_2, Global_Search_Input_2,Global_Search_Type_3, Global_Search_Input_3);
		
		Step_End(1, "Retrive the template saved booking number",test, test1);
		Step_Start(2, "click save as button",test, test1);

		waitForElement(driver, SaveAs_button_toolBar);
		safeclick(driver, SaveAs_button_toolBar);

		Step_End(2, "click save as button",test, test1);
		waitForElement(driver, SaveAsYes);
		safeclick(driver, SaveAsYes);
		Step_Start(3, "click save button system generated new book number",test, test1);
		waitForPopup(driver, Popup_Message,Templatesavpopexp);
		String temsavpop=getText(driver, Popup_Message);
		System.out.println(temsavpop);
		if(Templatesavpopexp.equals(temsavpop)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Templatesavpopexp + " || Actual Report Activity is : " + temsavpop);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Templatesavpopexp + " || Actual Report Activity is : " + temsavpop, test,test1);     
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Templatesavpopexp + " || Actual Report Activity is : " + temsavpop);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Templatesavpopexp + " || Actual Report Activity is : " + temsavpop, test,test1); 
		} 
		String savedbookingnumber1=getAttribute(driver, booking_no,"value");
		System.out.println(savedbookingnumber1);
		Extent_pass_New(driver, "Matched || " + " Booking number show AS *****] : " + savedbookingnumber1, test,test1);     
		if(Global_Search_Input_1.equals(savedbookingnumber1)) {                                                                                                                  
			System.out.println("Matched || [ Booking number Should generated different after save as option ] :  Expected Report Activity is : " + Global_Search_Input_1 + " || Actual Report Activity is : " + savedbookingnumber1+" [ Booking number generated different after save as option] ");            
			Extent_fail(driver,"Matched || [ Booking number Should generated different after save as option ] :  Expected Report Activity is : " + Global_Search_Input_1 + " || Actual Report Activity is : " + savedbookingnumber1+" [ Booking number generated different after save as option] ", test,test1); 
		}else {                                                                                                                                                                   
			System.out.println("Not Matched || [ Booking number Should generated different after save as option ] :  Expected Report Activity is : " + Global_Search_Input_1 + " || Actual Report Activity is : " + savedbookingnumber1+" [ Booking number Not generated different after save as option] ");        
			Extent_pass_New(driver,"Not Matched || [ Booking number Should generated different after save as option ] :  Expected Report Activity is : " + Global_Search_Input_1 + " || Actual Report Activity is : " + savedbookingnumber1+" [ Booking number Not generated different after save as option] ", test,test1); 
		} 
		Step_End(3, "click save button system generated new book number",test, test1);
		Extent_completed(test_Case_Name, test, test1);
	}
}
