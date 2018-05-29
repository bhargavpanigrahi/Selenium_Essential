package utility;

import java.util.Map;

import org.testng.Reporter;

import testCases.Driver;

public class Launcher {
	
	
	public static String remoteFlag, nodeURL, nodePlatform;
	 public static void InvokeLauncher() throws Exception
	 {
	  System.out.println("Driver.java- mainDriver Invoked");
	  HtmlReporter.setUpReportFolder();  
	  ExcelUtils.setExcelFile("C://Users//BHPANI//project//Pega_Automation//TestData//TestData.xlsx","Configuration");
	  String browser=ExcelUtils.getCellData(1,1);
	  String appName=ExcelUtils.getCellData(4,1);
	  String URL=ExcelUtils.getCellData(7,1);
	  
	  ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"RemoteExecution");
	  remoteFlag=ExcelUtils.getCellData(1,1);
	  nodeURL=ExcelUtils.getCellData(2,1);
	  nodePlatform=ExcelUtils.getCellData(3,1);
	  
	  
	  int z1=1;;
	  ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Driver");
	  int tc_row=1;
	 
	  String tc_id="";
	  String tc_name="";
	  String fn_name="";
	  while(z1==1)
	  {
	   String s_Flag = ExcelUtils.getCellData(tc_row,3);
	   if(s_Flag.equals("Yes"))
	   {
	    tc_id=ExcelUtils.getCellData(tc_row,0);
	    tc_name=ExcelUtils.getCellData(tc_row,1);
	    fn_name=ExcelUtils.getCellData(tc_row,2);
	    
	    Map<String, String> dictionary1=FetchTestData.getCurrentTestData(tc_id);
	    System.out.println("Starting Driver" +dictionary1.get("Username"));
	    for(int k=1; k<=FetchTestData.itr_size; k++)
	    {
	     HtmlReporter.testCase_Itr="" + k;
	     HtmlReporter.testCase_ID=tc_id;
	     HtmlReporter.testCase_Name=tc_name;
	     HtmlReporter.testStartTime=CommonUtils.getDate();
	     HtmlReporter.startTime =System.currentTimeMillis();
	          
	     Driver.dictionary=FetchTestData.getCurrentTestData(tc_id);     
	     //for(String key: Driver.dictionary.keySet())
	     //{
	      //System.out.println(key + " - " + Driver.dictionary.get(key));
	     //}
	     //*****************Driver Setup
	     
	     WebDr.openApplication(browser, URL);
	     //WebDr.openApplication(browser, "https://cs1t.wload.barclays.co.uk:23501/bir/feature/loginprocess?execution=e1s1&_t=1465284402264");
	     HtmlReporter.step_no=0;
	     HtmlReporter.tc_no++;
	     //**********************************
	     ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Driver");
	     Reporter.log("<h2>TC - " + tc_name + " (ID - " + tc_id + ") - Starts( Iteration - " + k + ")</h2>");
	     
	     Driver.AppInovker(appName, fn_name);
	     //switch (appName)
	     //{
	      //case "ESP":TestFlowBIR.executeTC(driver, fn_name); break;
	      //default:break;
	     //}
	     
	     
	     if(k==FetchTestData.itr_size)
	     {
	      FetchTestData.data_row=0;
	     }
	     else
	     {
	      FetchTestData.data_row++;
	     }
	     Reporter.log("<h2>TC - " + tc_name + " (ID - " + tc_id + ") - Ends( Iteration - " + k + ")</h2>");
	     try
	     {
	      Driver.driver.quit();
	     }catch(Exception e){}
	     HtmlReporter.testEndTime=CommonUtils.getDate();
	     HtmlReporter.endTime =System.currentTimeMillis();
	     HtmlReporter.testWiseReport();
	     
	    }
	    tc_row++;
	   }
	   else if(ExcelUtils.getCellData(tc_row,3).length()<1)
	   {
	    z1=0;
	   }
	   else
	   {
	    tc_row++;
	   }
	  }
	  HtmlReporter.endTestReport();
	 }


}
