package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {

    private AndroidDriver<MobileElement> driver;

    public LoginPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By servidorInput = By.id("com.sigga.eam.empower:id/server_field");
    private By customOption = By.id("com.sigga.eam.empower:id/custom_option");
    private By nextButton = By.id("com.sigga.eam.empower:id/next_btn");

    private By emailField = By.id("com.sigga.eam.empower:id/email_field");
    private By passwordField = By.id("com.sigga.eam.empower:id/password_field");
    private By loginButton = By.id("com.sigga.eam.empower:id/login_btn");

    private By errorMessage = By.id("com.sigga.eam.empower:id/error_message");

    public void selectCustomServer() {
        driver.findElement(customOption).click();
    }

    public void enterServer(String serverName) {
        driver.findElement(servidorInput).sendKeys(serverName);
        driver.findElement(nextButton).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(nextButton).click();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}