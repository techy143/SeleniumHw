package techy.selenium.april.pom.hw;


import org.testng.annotations.Test;

public class HomePageTest extends BaseTestClass {

    @Test(priority = 0)
    public void LogInTest() throws InterruptedException {
        logInPage.login("My Profile");

    }

    @Test(priority = 1)
    public void addProductToCardTest() throws InterruptedException {
        homePage.addProductToCart("Checkout");
    }

    @Test (priority = 2)
    public void ShippingPage() throws InterruptedException {
        System.out.println(" =========== Verification items:  ==========");
        iteam.shipping("Shipping details entered");
        System.out.println("Pass");
    }

}