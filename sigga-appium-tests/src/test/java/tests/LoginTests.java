package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTests {

    private AndroidDriver<MobileElement> driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setup() throws Exception {
        driver = DriverFactory.createDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void testServidorInvalido() {
        loginPage.selectCustomServer();
        loginPage.enterServer("ABC");
        Assertions.assertTrue(loginPage.getErrorMessage().contains("servidor inválido"));
    }

    @Test
    public void testEmailInvalido() {
        loginPage.selectCustomServer();
        loginPage.enterServer("stg");
        loginPage.enterEmail("email@invalido.com");
        Assertions.assertTrue(loginPage.getErrorMessage().contains("e-mail inválido"));
    }

    @Test
    public void testSenhaInvalida() {
        loginPage.selectCustomServer();
        loginPage.enterServer("stg");
        loginPage.enterEmail("candidato@processoseletivo.com");
        loginPage.enterPassword("12345678");
        Assertions.assertTrue(loginPage.getErrorMessage().contains("senha incorreta"));
    }
}