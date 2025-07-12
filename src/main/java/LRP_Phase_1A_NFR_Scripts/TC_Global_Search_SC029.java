package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Global_Search_SC029 extends Keywords {

	public void Global_Search_SC029(WebDriver driver, ExtentTest test, ExtentTest test1,
			String selected_dataset, Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_Global_Search_SC029";

		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Group_Mapping_Module = Excel_data.get("Group_Mapping_Module");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Search_Name_Header = Excel_data.get("Search_Name_Header");
		String Search_Name_Field = Excel_data.get("Search_Name_Field");
		String Group_Code_Value = Excel_data.get("Group_Code_Value");
		
		
		
		 Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		Step_Start(1, "Open the application.", test, test1);

		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);
		
		Step_End(1, "Open the application.", test, test1);	
		
		Step_Start(2, "Go to the Group Mapping Screen", test, test1);
		
		moduleNavigate(driver, Group_Mapping_Module);
		
		Step_End(2, "Go to the Group Mapping Screen", test, test1);
		
		Step_Start(3, "Click on Global Search icon. and retrived the data using (%)", test, test1);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow1(driver, Search_Condition1, Search_Name_Header, Search_Name_Field,"","","","");
		
		Step_End(3, "Click on Global Search icon. and retrived the data using (%)", test, test1);
		
		Step_Start(4, "Copy Test Value from External Source", test, test1);
		

		String Copy_Group_Code = getText(driver, GroupCode_First_Row);
		System.out.println("Copy_Group_Code is :"+ Copy_Group_Code);
		
		
		formatRightClick(driver, GroupCode_First_Row,Group_Code_Value);
		click(driver, Right_Click_Copy);
		
         Step_Start(5, "Paste the value on cell", test, test1);
		
         waitForElement(driver, GroupCode_Text_Field);
         click(driver, GroupCode_Text_Field);
         Actions action = new Actions(driver);
         action.keyDown(Keys.CONTROL)
               .sendKeys("v")
               .keyUp(Keys.CONTROL)
               .perform();

		
		Step_End(5, "Paste the value on cell", test, test1);
		
      Step_Start(6, "Verify whether pasted data is fileterd on the grid.", test, test1);
		
      String Paste_Group_Code = getText(driver, GroupCode_First_Row);
		System.out.println("Paste_Group_Code is :"+ Paste_Group_Code);
      
      if (Copy_Group_Code.equals(Paste_Group_Code)) {
    	  
    	  System.out.println("Matched || Excepted : The copied Value from the grid is :" +Copy_Group_Code + "  Actual:|| The value pasted in the grid column is :"+Paste_Group_Code);
    	  
    	  Extent_pass_New(driver, "Matched || Excepted : The copied Value from the grid is :" +Copy_Group_Code + " Actual:|| The value pasted in the grid column is :"+Paste_Group_Code, test, test1);
    	  
		
	} else {

		
       System.out.println("NotMatched || Excepted : The copied Value from the grid is :" +Copy_Group_Code + "Actual: || The value pasted in the grid column is :"+Paste_Group_Code);
    	  
    	  Extent_fail(driver, "NotMatched || Excepted : The copied Value from the grid is :" +Copy_Group_Code + "Actual : || The value pasted in the grid column is :"+Paste_Group_Code, test, test1);
    	  
		
		
	}
		
		Step_End(6, "Verify whether pasted data is fileterd on the grid.", test, test1);
		
		Extent_completed(testCaseName, test, test1);

		
	}
	
}
