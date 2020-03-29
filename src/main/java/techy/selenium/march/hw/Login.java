package techy.selenium.march.hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) throws Exception{

        logChrome();

    }


    public static void logChrome () throws Exception{
        System.setProperty("webdriver.chrome.driver","/Users/tuhidzmac/Projects/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.broadleafcommerce.org/login");
        System.out.println(driver.getTitle());




        WebElement Email = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/form/div[1]/div/input"));
        Email.clear();
        System.out.println("Box cleared");
        Email.sendKeys("tauhidechy@outlook.com");
        System.out.println("Input Email Address");
        Thread.sleep(3000);



        WebElement Password = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/form/div[2]/div/input"));
        Password.clear();
        System.out.println("Box cleared");
        Password.sendKeys("Canada143");
        System.out.println("Enter ur Password ");
        Thread.sleep(3000);


        WebElement Login = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/form/button"));
        Login.click();
        System.out.println("Click Login Bottom");
        Thread.sleep(3000);

        System.out.println("Login Successfully");

    }

}
