package LRP_Cost_Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
public class TC_Cost_Activity_Report_TS067 extends Keywords {

	public void Cost_Activity_Report_TS067(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS067";
		
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");

		String AgencyUser = Excel_data.get("AgencyUser");
		String Select_Contract_type_Value = Excel_data.get("Select_Contract_type_Value");
		String Select_Mode_type = Excel_data.get("Select_Mode_type");
		String Service_Code = Excel_data.get("Service_Code");
		String Vessel_Code = Excel_data.get("Vessel_Code");
		String Port_Code = Excel_data.get("Port_Code");
		String Terminal_Code = Excel_data.get("Terminal_Code");
		String Service_details_Codition = Excel_data.get("Service_details_Codition");
		String Arrival_Date_Condition = Excel_data.get("Arrival_Date_Condition");
		String Arrival_Date_Value = Excel_data.get("Arrival_Date_Value");

		String Table_Headers_Filter = Excel_data.get("Table_Headers_Filter");
		String Vessel_Module_navigate = Excel_data.get("Vessel_Module_navigate");

		String Service_Header = Excel_data.get("Service_Header");
		String Vessel_Header = Excel_data.get("Vessel_Header");
		String Port_Header = Excel_data.get("Port_Header");
		String Terminal_Header = Excel_data.get("Terminal_Header");
		String Arrival_Date_Header = Excel_data.get("Arrival_Date_Header");

		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);
		LRP_Login(driver, username, password);

		Step_Start(1, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		verifyMainMenu(driver);
		Step_Start(1,
				"Once login to the application and click on switch profile option and select the required agency.",
				test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Once login to the application and click on switch profile option and select the required agency.",
				test, test1);

		Step_Start(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);
		moduleNavigate(driver, Cost_Activity_Report_Module);
		Step_End(2, "Enter the screen name as 'Cost Activity Report' in module search field.", test, test1);

		waitForElement(driver, Contract_Type_Input_CAR);
		click(driver, Contract_Type_Input_CAR);

		String SelectContract = String.format(Select_Contract_Type_CAR, Select_Contract_type_Value);
		waitForElement(driver, SelectContract);
		click(driver, SelectContract);

		waitForElement(driver, Mode_Select_Input_CAR);
		click(driver, Mode_Select_Input_CAR);

		String SelectModeValue = String.format(Select_Mode_type_CAR, Select_Mode_type);
		waitForElement(driver, SelectModeValue);
		click(driver, SelectModeValue);

		Step_Start(3, "Click on the Service search button and select the required service code.", test, test1);
		waitForElement(driver, Service_Search_Btn_CAR);
		click(driver, Service_Search_Btn_CAR);
		twoColumnSearchWindow(driver, Service_Header, Service_details_Codition, Service_Code);
		Step_End(3, "Click on the Service search button and select the required service code.", test, test1);

		Step_Start(4, "Click on the Vessel search button and select the required vessel code.", test, test1);
		waitForElement(driver, Vessel_Search_Btn_CAR);
		click(driver, Vessel_Search_Btn_CAR);
		twoColumnSearchWindow(driver, Vessel_Header, Service_details_Codition, Vessel_Code);
		Step_End(4, "Click on the Vessel search button and select the required vessel code.", test, test1);

		Step_Start(5, "Click on the Port search button and select the required port code.", test, test1);
		waitForElement(driver, Port_Search_Btn_CAR);
		click(driver, Port_Search_Btn_CAR);
		twoColumnSearchWindow(driver, Port_Header, Service_details_Codition, Port_Code);
		Step_End(5, "Click on the Port search button and select the required port code.", test, test1);

		Step_Start(6, "Click on the Terminal search button and select the required terminal code.", test, test1);
		waitForElement(driver, Terminal_Search_Btn_CAR);
		click(driver, Terminal_Search_Btn_CAR);
		twoColumnSearchWindow(driver, Terminal_Header, Service_details_Codition, Terminal_Code);
		Step_End(6, "Click on the Terminal search button and select the required terminal code.", test, test1);

		Step_Start(7, "Click on the Arrival date search button and select the required date. ", test, test1);
		waitForElement(driver, Arrival_Date_Search_Btn_CAR);
		click(driver, Arrival_Date_Search_Btn_CAR);
		twoColumnSearchWindow(driver, Arrival_Date_Header, Arrival_Date_Condition, Arrival_Date_Value);
		Step_End(7, "Click on the Arrival date search button and select the required date. ", test, test1);

		Step_Start(8, ".Click on the Show button and Click on the Predictable Reporting tab ", test, test1);
		waitForElement(driver, Show_Button_CAR);
		click(driver, Show_Button_CAR);

		waitForElement(driver, Predictable_Reporting_CAR);
		click(driver, Predictable_Reporting_CAR);
		waitForElement(driver, Predictable_Table_CAR);

		Step_End(8, ".Click on the Show button and Click on the Predictable Reporting tab ", test, test1);

		Step_Start(9,
				"Get the Formula from the Formula column in selected Activity and check whether the To be reported(Formula) checkbox is selected",
				test, test1);
		
		waitForElement(driver, MoreOption_Grid);
		click(driver,MoreOption_Grid);
		
		waitForElement(driver, FilterOption_Menu);
		click(driver,FilterOption_Menu);
		
		reArrangeAG_GridColumns(driver, Table_Headers_Filter);

		waitForElement(driver, Predictable_Table_CAR);
		
		waitForElement(driver, To_Be_Reported_Filter_CAR);
		sendKeys(driver,To_Be_Reported_Filter_CAR,"True");
		
		waitForElement(driver, Table_Total_Records_CAR);
		
		List<String> ActivityNamesList=new ArrayList<String>();
		List<String> Formula_Values=new ArrayList<String>();

		Map<String,Double> Actvity_Charge=new HashMap<String, Double>();
		
		if(isdisplayed(driver, Predictable_Grid_Cell_CAR)) {
			int a=0;
			boolean formulaReport=true;
			
			while(formulaReport) {
				String Formula_Column=String.format(Formula_Column_AG_Grid_CAR, a);
				if(!isdisplayed(driver, Formula_Column)) {
					formulaReport=false;
					break;
				}
				
				waitForElement(driver, Formula_Column);
				mouseOverToElement(driver, Formula_Column);
				String FormulaValue=getText(driver, Formula_Column);
				
				String ActivityColumn=String.format(ActivityName_Column_CAR, a);
				waitForElement(driver, ActivityColumn);
				String ActName=getText(driver, ActivityColumn);
				
				String ChargeColumn=String.format(Charge_Rate_Column_CAR, a);
				waitForElement(driver, ChargeColumn);
				String ChargeVal=getText(driver, ChargeColumn);
				double ChargeAmount=getNumberValue(ChargeVal);
				
				if(!FormulaValue.equals("")) {
					Formula_Values.add(FormulaValue);
					ActivityNamesList.add(ActName);
					Actvity_Charge.put(ActName, ChargeAmount);
				}
				a++;
			}
			
		}else {
			System.out.println("Expected : Formula with To be reported Column(true) should present || Actual : Formula with To be reported Column(true) is not present for the Given Input ");
			Extent_FailNew(driver, "Expected : Formula with To be reported Column(true) should present || Actual : Formula with To be reported Column(true) is not present for the Given Input ", test, test1);
		}
		
		
		moduleNavigate(driver, Vessel_Module_navigate);
		waitForElement(driver, Vessel_Code_Filter_Input_VSL);
		click(driver, Vessel_Code_Filter_Input_VSL);
		sendKeys(driver, Vessel_Code_Filter_Input_VSL, Vessel_Code);

		waitForElement(driver, Vessel_Code_Action_button_VSL);
		click(driver, Vessel_Code_Action_button_VSL);
		
		Map<String,Double> Exp_Act_Charges=new HashMap<String, Double>();
		int l=0;
		for(String formula:Formula_Values) {
			Set<String>  FormulaCode1=extractVariableNames(formula);
			
			Map<String, Double> variableValues = new HashMap<String, Double>();
			for(String code:FormulaCode1) {
				if(code!=null) {
					String varible_Element = String.format(Get_Varibale_Value_VSL, code);
					waitForElement(driver, varible_Element);
					String Variable_text_value = getAttribute(driver, varible_Element, "value");
					double CodeNumberVal=getNumberValue(Variable_text_value);
					variableValues.put(code, CodeNumberVal);
				}
			}
			String Activity=ActivityNamesList.get(l);
			l++;
			String formulaWithValues = replaceVariables(formula, variableValues);
		    double result = evaluateFormula(formulaWithValues);
		    Exp_Act_Charges.put(Activity, result);
			
		}
		
		waitForElement(driver, Close_Current_tab);
		click(driver,Close_Current_tab);
		
		int k=0;
		for (Map.Entry<String, Double> entry : Actvity_Charge.entrySet()) {
			String expKey = entry.getKey();
			double Act_Charge = entry.getValue();
			
			double Exp_Charge=Exp_Act_Charges.get(expKey);
			
			if(Exp_Charge!=Act_Charge) {
				System.out.println("Not Matched || Expected Charge rate Values for the Activity '"+expKey+"' for the Formula '"+Formula_Values.get(k)+"'  is :"+Exp_Charge+"  || Actual Charge rate is : "+Act_Charge);
				Extent_fail(driver, "Not Matched || Expected Charge rate Values for the Activity '"+expKey+"' for the Formula '"+Formula_Values.get(k)+"'  is :"+Exp_Charge+"  || Actual Charge rate is : "+Act_Charge, test, test1);
			}else {
				System.out.println("Matched || Expected Charge rate Values for the Activity '"+expKey+"' for the Formula '"+Formula_Values.get(k)+"'  is :"+Exp_Charge+"  || Actual Charge rate is : "+Act_Charge);
				Extent_pass_New(driver, "Matched || Expected Charge rate Values for the Activity '"+expKey+"' for the Formula '"+Formula_Values.get(k)+"'  is :"+Exp_Charge+"  || Actual Charge rate is : "+Act_Charge, test, test1);
			}
			k++;
		}
		
		Extent_completed(tc_Name, test, test1);

	}

}
