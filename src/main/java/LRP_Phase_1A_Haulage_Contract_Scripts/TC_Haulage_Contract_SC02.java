package LRP_Phase_1A_Haulage_Contract_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Haulage_Contract_SC02 extends Keywords{
	public void Haulage_Contract_SC02(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Haulage_Contract_SC02";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Haulage_Contract_Module_Name = Excel_data.get("Haulage_Contract_Module_Name");
		String Vendor_Master_Module = Excel_data.get("Vendor_Master_Module");
		String Global_Condition = Excel_data.get("Global_Condition");
		String Vendor_Code_Header_Filtertype = Excel_data.get("Vendor_Code_Header_Filtertype");
		String Vendor_Code_Value = Excel_data.get("Vendor_Code_Value");
		String HC_Value = Excel_data.get("HC_Value");




		
		
		

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);
		
		moduleNavigate(driver, Vendor_Master_Module);
		
		waitForElement(driver, new_Button_VM);
		click(driver, new_Button_VM);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Global_Condition, Vendor_Code_Header_Filtertype, Vendor_Code_Value, "", "", "","" );
		
		ArrayList<String> TypeOfContractList=new ArrayList<String>();

		waitForElement(driver, Vendor_Master_Type_of_Contract);
		List<WebElement> typeOfContracts = listOfElements(driver, Vendor_Master_Type_of_Contract);
		for(int i=1;i<=typeOfContracts.size();i++) {
			String type_Of_Contract=String.format(Type_Of_Contract_VM, i);
			String getTypeOfContracts=getText(driver, type_Of_Contract);
			TypeOfContractList.add(getTypeOfContracts);
		}
		

		boolean isMatched = false;

		for (int i = 0; i < TypeOfContractList.size(); i++) {
			String actualTypeOfContract = TypeOfContractList.get(i);
			if (actualTypeOfContract.contains(HC_Value)) {
				System.out.println("Matched || The Expected value should be in Feeder Contract is : " + HC_Value + 
					" The Actual value in Feeder Contract is : " + actualTypeOfContract);
				Extent_pass_New(driver,
					"Matched || The Expected value should be in Feeder Contract is : " + HC_Value +
					" The Actual value in Feeder Contract is : " + actualTypeOfContract, test, test1);

				waitForElement(driver, Close_Current_tab);
				click(driver, Close_Current_tab);

				Step_Start(1, "Enter the  screen name as 'Haulage contracts' in module search field", test, test1);
				moduleNavigate(driver, Haulage_Contract_Module_Name);
				Step_End(1, "Enter the  screen name as 'Haulage contracts' in module search field", test, test1);

				Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);
				waitForElement(driver, Vendor_Search_Button);
				click(driver, Vendor_Search_Button);

				waitForElement(driver, HC_Vendor_code_TF);
				sendKeys(driver, HC_Vendor_code_TF, Vendor_Code_Value);
				Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);

				Step_Start(3, "While click the search ,It shows Haulage mapped vendors", test, test1);
				if (formatLocatorIsDisplayed(driver, HC_Vendor_code_Data, Vendor_Code_Value)) {
					System.out.println("Vendor Code Value is Mapped in Vendor Master " + Vendor_Code_Value);
					Extent_pass_New(driver, "Vendor Code Value is Mapped in Vendor Master " + Vendor_Code_Value, test, test1);
					Step_End(3, "While click the search ,It shows Haulage mapped vendors", test, test1);
				}
				else {
					System.out.println("Vendor Code Value is not  Mapped in Vendor Master " + Vendor_Code_Value);
					Extent_fail(driver, "Vendor Code Value is not  Mapped in Vendor Master " + Vendor_Code_Value, test, test1);
				}
				isMatched = true;
				break;
			}
		}


		if (!isMatched) {
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			Step_Start(1, "Enter the  screen name as 'Haulage contracts' in module search field", test, test1);
			moduleNavigate(driver, Haulage_Contract_Module_Name);
			Step_End(1, "Enter the  screen name as 'Haulage contracts' in module search field", test, test1);

			Step_Start(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);
			waitForElement(driver, Vendor_Search_Button);
			click(driver, Vendor_Search_Button);

			waitForElement(driver, HC_Vendor_code_TF);
			sendKeys(driver, HC_Vendor_code_TF, Vendor_Code_Value);
			Step_End(2, "Click on the vendor code search button and select the required vendor based on vendor master", test, test1);

			
			
			Step_Start(3, "While click the search ,It shows Haulage mapped vendors", test, test1);

			if (!formatLocatorIsDisplayed(driver, HC_Vendor_code_Data, Vendor_Code_Value)) {
				System.out.println("Vendor Code Value is Not Mapped in Vendor Master " + Vendor_Code_Value);
				Extent_pass_New(driver, "Vendor Code Value is Not Mapped in Vendor Master " + Vendor_Code_Value, test, test1);
				Step_End(3, "While click the search ,It shows Haulage mapped vendors", test, test1);

			}else {
				System.out.println("Vendor Code Value is  Mapped in Vendor Master " + Vendor_Code_Value);
				Extent_fail(driver, "Vendor Code Value is  Mapped in Vendor Master " + Vendor_Code_Value, test, test1);
			}
		}

			Extent_completed(testcase_Name, test, test1);
			
		
		
	}

}
