package LRP_Feeder_Contract_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Feeder_Contract_SC02 extends Keywords {
	public void Feeder_Contract_SC02(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_Excel_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Feeder_Contract_SC02";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Feeder_Contract_Module_Name = Excel_data.get("Feeder_Contract_Module_Name");
		String Vendor_Code_Header = Excel_data.get("Vendor_Code_Header");
		String Vendor_Code_Value = Excel_data.get("Vendor_Code_Value");
		String Conditon = Excel_data.get("Conditon");
		String Vendor_Master_Module_Name = Excel_data.get("Vendor_Master_Module_Name");
		String Global_Condition = Excel_data.get("Global_Condition");
		String Vendor_Code_Header_Filtertype = Excel_data.get("Vendor_Code_Header_Filtertype");
		String FDR_Value = Excel_data.get("FDR_Value");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, username, password);
		verifyMainMenu(driver);

		Step_Start(1, "Enter the  screen name as 'vendor master' in module search field ", test, test1);

		moduleNavigate(driver, Vendor_Master_Module_Name);

		waitForElement(driver, new_Button_VM);
		click(driver, new_Button_VM);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, Global_Condition, Vendor_Code_Header_Filtertype, Vendor_Code_Value, "", "", "",
				"");

		ArrayList<String> TypeOfContractList = new ArrayList<String>();

		List<WebElement> typeOfContracts = listOfElements(driver, Vendor_Master_Type_of_Contract);
		for (int i = 1; i <= typeOfContracts.size(); i++) {
			String type_Of_Contract = String.format(Type_Of_Contract_VM, i);
			String getTypeOfContracts = getText(driver, type_Of_Contract);
			TypeOfContractList.add(getTypeOfContracts);
		}
		boolean presence = false;

		for (int i = 0; i < TypeOfContractList.size(); i++) {
			String actualTypeOfContract = TypeOfContractList.get(i);
			if (actualTypeOfContract.contains(FDR_Value)) {
				System.out.println("Matched || The Expected value should be in Feeder Contract is : " + FDR_Value
						+ "The Actual value in Feeder Contract is : " + actualTypeOfContract);
				Extent_pass_New(driver, "Matched || The Expected value should be in Feeder Contract is : " + FDR_Value
						+ "The Actual value in Feeder Contract is : " + actualTypeOfContract, test, test1);
				presence = true;
			}
		}

		Step_End(1, "Enter the  screen name as 'vendor master' in module search field ", test, test1);

		Step_Start(2, "Enter the  screen name as 'feeder contracts' in module search field.", test, test1);

		moduleNavigate(driver, Feeder_Contract_Module_Name);

		Step_End(2, "Enter the  screen name as 'feeder contracts' in module search field.", test, test1);

		Step_Start(3, "click the search ,It shows Feeder mapped vendors", test, test1);

		waitForElement(driver, FC_Vendor_Search_Button);
		click(driver, FC_Vendor_Search_Button);
		twoColumnSearchWindow(driver, Vendor_Code_Header, Conditon, Vendor_Code_Value);

		waitForElement(driver, FC_Vendor_field);
		String Actual_Vendor_Values = getAttribute(driver, FC_Vendor_field, "value");

		if (Vendor_Code_Value.equals(Actual_Vendor_Values) && presence == true) {
			System.out.println("Matched || The Expected vendor code is : " + Vendor_Code_Value
					+ "  ||  The Actual vendor code is : " + Actual_Vendor_Values);
			Extent_pass_New(driver, "Matched || The Expected vendor code is : " + Vendor_Code_Value
					+ "  ||  The Actual vendor code is : " + Actual_Vendor_Values, test, test1);
		} else {
			System.out.println("Not Matched || The Expected vendor code is : " + Vendor_Code_Value
					+ "  ||  The Actual vendor code is : " + Actual_Vendor_Values);
			Extent_fail(driver, "Not Matched || The Expected vendor code is : " + Vendor_Code_Value
					+ "  ||  The Actual vendor code is : " + Actual_Vendor_Values, test, test1);
		}

		Step_End(3, "click the search ,It shows Feeder mapped vendors", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}
}
