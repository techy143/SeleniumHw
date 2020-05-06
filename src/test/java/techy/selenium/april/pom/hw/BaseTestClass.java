package techy.selenium.april.pom.hw;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import techy.selenium.april.pom.HomePage;
import techy.selenium.april.pom.LoginPage;
import techy.selenium.april.pom.ShippingPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static techy.selenium.april.excel.ReadExcelFile.readExcelToArray;

public class BaseTestClass {


    protected LoginPage logInPage;
    protected HomePage homePage;
    protected ShippingPage iteam;
    public WebDriver driver;
    static String filePath = "/Users/tuhidzmac/My Document/TestData.xlsx";


    @BeforeClass
    public void setUpMethod() {
        initilization();
        logInPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        iteam = new ShippingPage(driver);


    }

    @AfterClass
    public void tearDownMethod() {
        if (driver != null) {
            driver.quit();
        }

    }


    public void initilization() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demo.broadleafcommerce.org/");

    }

    @DataProvider(name = "techy")
    public Object[][] loginData() throws IOException {
        Object[][] arrayObject = readExcelToArray(filePath);
        return arrayObject;

    }
}