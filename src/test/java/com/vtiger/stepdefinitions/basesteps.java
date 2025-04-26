package com.vtiger.stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class basesteps {
    public static WebDriver driver;
    public static Properties prop;
    public static Map<String,Map<String,String>> dt;

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest report;

    public static String ScenarioName;
    public static LoginPage loginpage;
    public static HomePage homepage;
    public static LeadPage leadpage;

    public void initiation() throws FilloException {

        if(prop==null) {
            readproperties();
        }
        if(dt==null)
        {
            readexceldata();
        }
        if(driver==null) {
            launchApp();
        }
    }


    public void launchApp()
    {
        System.out.println("today is saturday");
        if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }else if(prop.getProperty("browser").equalsIgnoreCase("headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }else
        {
            driver = new ChromeDriver();
        }
        report.info("Browser Name "+prop.getProperty("browser"));
        driver.get(prop.getProperty("appUrl"));
        report.info("Application url "+prop.getProperty("appUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implictwait"))));
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        leadpage = new LeadPage(driver);
    }
    public void readproperties()
    {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Configuration/settings.properties");
            prop.load(fis);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void readexceldata() throws FilloException {
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection(System.getProperty("user.dir") + "/src/test/resources/TestData/data.xlsx");
        String strQuery="Select * from Sheet1";
        dt = new HashMap<>();
        Recordset recordset=connection.executeQuery(strQuery);
        List<String> lst = recordset.getFieldNames();

        while(recordset.next()){
            //System.out.println(recordset.getField("Details"));
            Map<String,String> map = new HashMap<>();
            for(int i=1;i<lst.size();i++)
            {
               map.put(lst.get(i).trim(),recordset.getField(lst.get(i).trim()));
            }
            dt.put(recordset.getField("ScanerioName"),map);
        }


        recordset.close();
        connection.close();

        System.out.println(dt);
      //  System.exit(0);

    }


    public void createExtentReport()
    {
        //report_13042025104034.html
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+fileName+".html");
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Automation Test Hub");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User Name", "Rajesh U");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here ");
        // Name of the report
        htmlReporter.config().setReportName("Name of the Report Comes here ");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);

    }
}
