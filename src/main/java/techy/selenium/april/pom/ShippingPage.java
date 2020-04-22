package techy.selenium.april.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShippingPage extends BasePage {

    WebDriver driver;

    public ShippingPage(WebDriver driver){

        super(driver);

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/label/span[1]")
    WebElement shippingMethod;
    @FindBy(xpath = "(//*[@id= 'fullName'])")
    WebElement fullName;
    @FindBy(xpath = "(//*[@id= 'addressLine1'])")
    WebElement address;
    @FindBy(id = "city")
    WebElement city;

    @FindBy(xpath ="\"/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div/div/div[3]/div[2]/div/select" )
    WebElement state;


    //Select objstate = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div/div/div[3]/div[2]/div/select")));
    //objstate.selectByIndex(32);



    @FindBy (xpath = "(//input[@id='postalCode'])[1]")
    WebElement postalCode;
    @FindBy (xpath = "(//input[@id = 'phonePrimary'])[1]")
    WebElement phoneNumber;

    @FindBy(xpath = "//div[@class ='col-md-12']")
    WebElement validationStringElement;


    // Mehtod for Shipping Details

    public void shipping(String expextedString ) throws InterruptedException {


        clickOnElement(shippingMethod);
        typeInATextBox(fullName,"T Chy");
        typeInATextBox(address,"4678 arnet st");
        typeInATextBox(city,"Falls church");
        Thread.sleep(3000);

        clickOnElement(state);
        Select State = new Select(state);

        typeInATextBox(postalCode,"48231");
        typeInATextBox(phoneNumber,"7462898951");
        Thread.sleep(3000);

        String validationString = validationStringElement.getText();
        Assert.assertEquals(validationString,expextedString);

    }

}
