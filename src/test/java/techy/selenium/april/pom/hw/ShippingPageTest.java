package techy.selenium.april.pom.hw;

import org.testng.annotations.Test;

public class ShippingPageTest extends BaseTestClass {



    @Test
    public void ShippingPage() throws InterruptedException {
        System.out.println(" =========== Verification items:  ==========");
        iteam.shipping("Shipping details entered");
        System.out.println("Pass");
    }
}
