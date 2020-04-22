package techy.selenium.april.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage extends BasePage{
    //WebDriver driver;
    public LoginPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Login WebElements
    @FindBy(xpath = "(//*[@href='/login'])[1]")
    WebElement loginLink;
    @FindBy(id = "username")
    WebElement enterEmail;
    @FindBy(xpath = "(//*[@id='password'])[1]")
    WebElement enterPassword;
    @FindBy(xpath = "//*[@id='login']/form/button")
    WebElement logInButton;
    @FindBy(xpath = "(//*[@class='dropdown'])[1]")
    WebElement accountLink;
    @FindBy(xpath = "//*[@href='/account']")
    WebElement validationStringElement;
    @FindBy(xpath = "//*[@href='/logout']")
    WebElement logoutLink;

    //Register WebElements

    public void login(String expectedString) throws InterruptedException {
        clickOnElement(loginLink);
        System.out.println("Login link clicked!!! ");
        typeInATextBox(enterEmail, "tauhidechy147@outlook.com");
        typeInATextBox(enterPassword, "Canada143");
        System.out.println("email and Password entered!!! ");
        clickOnElement(logInButton);
        System.out.println("Login button clicked");
        clickOnElement(accountLink);
        Thread.sleep(3000);
        String validationString = validationStringElement.getText();
        Assert.assertEquals(validationString, expectedString);
        //clickOnElement(logoutLink);

    }

    public void loginLogOut(String expectedString) throws InterruptedException {
        login(expectedString);
        clickOnElement(logoutLink);

    }


}