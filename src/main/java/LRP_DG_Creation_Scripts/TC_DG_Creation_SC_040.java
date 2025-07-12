package LRP_DG_Creation_Scripts;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_DG_Creation_SC_040 extends Keywords {
	public void DG_Creation_SC_040(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset,Map<String, String> Excel_data,String url) {
		//		Get data from excel sheet

		String testCaseName="TC_DG_Creation_SC_040";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");
		String agencyUser = Excel_data.get("AgencyUser");
		String UN_Number_Column_Header = Excel_data.get("UN_Number_Column_Header");
		String booking_number = Excel_data.get("Booking_No_Input");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String globalSearchFilterOption1 = Excel_data.get("GlobalSearchFilterOption1");
		String Column_condition= Excel_data.get("Column_condition");
		String UN_No= Excel_data.get("UN_No");
		String Exp_Unno_Popup = Excel_data.get("Exp_Unno_Popup");
		
		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);
		
		// Login

				LRP_Login(driver, username, password);
				SwitchProfile(driver, agencyUser);
		
        // Module Search
				
				moduleNavigate(driver, DG_Creation_Module);
				
				
				newButton(driver);		
				
				Step_Start(1, "Retrieve the single container  Book number", test, test1);

				waitForElement(driver, Booking_No_Search_DG);
				click(driver, Booking_No_Search_DG);
				globalValueSearchWindow(driver, GlobalSearch_Condition, globalSearchFilterOption1, booking_number, "", "", "", "");
				
				Step_End(1, "Retrieve the single container  Book number", test, test1);

		
				
				Step_Start(2, "Select the unno system cross checked the DG house rules.", test, test1);

				waitForElement(driver, UnNo_Search);
				safeclick(driver, UnNo_Search);
				
				twoColumnSearchWindow(driver, UN_Number_Column_Header, Column_condition, UN_No);
				
				waitForElement(driver, popup_Message);
				String actualUpdatedPopup=getText(driver, popup_Message);
				System.out.println("actualUpdatedPopup:"+actualUpdatedPopup);
				
				if(actualUpdatedPopup.contains(Exp_Unno_Popup)) {                                                                                                                  
					System.out.println("Matched || " + " Expected Popup is : " + Exp_Unno_Popup + " || Actual Popup is : " + actualUpdatedPopup);            
					Extent_pass_New(driver, "Matched || " + " Expected Popup is: " + Exp_Unno_Popup + " || Actual Popup is : " + actualUpdatedPopup, test,test1);     
				
				}                                                                                                                                                                        
				else {       
				
					System.out.println("Not Matched || " + " Expected Popup is : " + Exp_Unno_Popup + " || Actual Popup is : " + actualUpdatedPopup);        
					Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Exp_Unno_Popup + " || Actual Popup is : " + actualUpdatedPopup, test,test1); 
				}
				safeclick(driver, popup_Message_Yes_Button);
				Step_End(2, "Select the unno system cross checked the DG house rules", test, test1);	
				
				
				Extent_completed(testCaseName, test, test1);
				
		
		
}}
