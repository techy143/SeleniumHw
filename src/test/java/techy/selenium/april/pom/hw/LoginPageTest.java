package techy.selenium.april.pom.hw;


import org.testng.annotations.Test;

public class LoginPageTest extends BaseTestClass {

    @Test
    public void loginTest() throws InterruptedException {
        System.out.println("Login Page Verification items:    ==========");
        //System.out.println(logInPage.login(""));

        logInPage.loginLogOut("My Profile");
        System.out.println("========= Assertion Passed ======");

    }
}