package LRP_Commercial_Rate_Request_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Rate_Request_SC24  extends Keywords{

	public void rate_Request_Sc24(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){
		String testcase_Name="TC_Rate_Request_SC24";
		
		


		
		
		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("PassWord");
		String ModuleRateRequest =Excel_data.get("Search_module");
		String Wiyhout_Agency_login_popexp =Excel_data.get("Wiyhout_Agency_login_popexp");


		Extent_Start(testcase_Name, test, test1);


		navigateUrl(driver, url);
		//Login
				LRP_Login(driver, username, pass_word);
				
				//Module search
				moduleNavigate(driver, ModuleRateRequest);
	
		
//	waitForElement(driver, Requet_Type);
newButton(driver);
				scrollTop(driver);
				waitForDisplay(driver, NewButton_ToolBar);
				if(isdisplayed(driver, NewButton_ToolBar)&&isElementEnabled(driver, NewButton_ToolBar)) {
					jsClick(driver, NewButton_ToolBar);
				}		
		waitForPopup(driver,Popup_Message,Wiyhout_Agency_login_popexp);
		String PopUp_Msg=getText(driver, Popup_Message);    
		System.out.println(PopUp_Msg);
		if(Wiyhout_Agency_login_popexp.equals(PopUp_Msg)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : popup message should be shown" + Wiyhout_Agency_login_popexp + " || Actual Report Activity is : popup message is shown : " + PopUp_Msg);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : popup message should be shown " + Wiyhout_Agency_login_popexp + " || Actual Report Activity is : popup message is shown : " + PopUp_Msg, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is :popup message should not be shown " + Wiyhout_Agency_login_popexp + " || Actual Report Activity is :popup message should not be shown: " + PopUp_Msg);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is :popup message should not be shown " + Wiyhout_Agency_login_popexp + " || Actual Report Activity is :popup message should not be shown: " + PopUp_Msg, test,test1); 
			
		} 


		Extent_completed(testcase_Name, test, test1);
	}
}