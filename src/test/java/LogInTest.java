import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogInTest {

    WebDriver driver;
    WebDriverWait wdwait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }

    public void goToLoginPage() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement loginPageButton = driver.findElement(By.linkText("Test Login Page"));
        loginPageButton.click();

    }

    @Test(priority = 10)
    public void successfulLogin() {

        goToLoginPage();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        submitButton.click();
        WebElement logoutButton = driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));
        WebElement loginTitle = driver.findElement(By.className("post-title"));

        Assert.assertTrue(logoutButton.isDisplayed());
        Assert.assertEquals(loginTitle.getText(), "Logged In Successfully");
    }

    @Test(priority = 20)
    public void unsuccessfulLoginWithInvalidUsername() {

        goToLoginPage();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("pogresan Username");
        passwordField.sendKeys("Password123");
        submitButton.click();

        boolean check = false;
        try {
            check = driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")).isDisplayed();

        } catch (Exception e) {


        }
        WebElement errorMessage = driver.findElement(By.id("error"));

        Assert.assertFalse(check);
        Assert.assertTrue(errorMessage.isDisplayed());

    }

    @Test(priority = 30)
    public void unsuccessfulLoginWithInvalidPassword() {

        goToLoginPage();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("student");
        passwordField.sendKeys("pogresna lozinka");
        submitButton.click();

        boolean check= false;
        try {
            check= driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")).isDisplayed();
        }catch (Exception e){

        }
        Assert.assertFalse(check);

        WebElement errorMessage= driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
    @Test(priority = 40)
    public void unsuccessfulLoginWithEmptyUsernameAndPassword(){
        goToLoginPage();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        boolean check= false;
        try {
            check= driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")).isDisplayed();
        }catch (Exception e){

        }
        Assert.assertFalse(check);

        WebElement errorMessage= driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
    @Test(priority = 50)
    public void unsuccessfulLoginWithEmptyUsernameAndValidPassword(){
        goToLoginPage();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        passwordField.sendKeys("Password123");
        submitButton.click();

        boolean check= false;
        try {
            check= driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")).isDisplayed();
        }catch (Exception e){

        }
        Assert.assertFalse(check);

        WebElement errorMessage= driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }
    @Test(priority = 60)
    public void unsuccessfulLoginWithEmptyPasswordAndValidUsername(){

        goToLoginPage();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("student");
        submitButton.click();

        boolean check= false;
        try {
            check= driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")).isDisplayed();
        }catch (Exception e){

        }
        Assert.assertFalse(check);

        WebElement errorMessage= driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }
    @Test(priority = 70)
    public void unsuccessfulLoginWithInvalidUsernameAndInvalidPassword(){
        goToLoginPage();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("pogresan username");
        passwordField.sendKeys("pogresna lozinka");
        submitButton.click();

        boolean check= false;
        try {
            check= driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")).isDisplayed();
        }catch (Exception e){

        }
        Assert.assertFalse(check);

        WebElement errorMessage= driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }
    @Test(priority = 80)
    public void unsuccessfulLoginWithInvalidUsernameAndEmptyPassword(){

        goToLoginPage();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("pogresan username");
        submitButton.click();

        boolean check= false;
        try {
            check= driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")).isDisplayed();
        }catch (Exception e){

        }
        Assert.assertFalse(check);

        WebElement errorMessage= driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());


    }
    @Test(priority = 90)
    public void unsuccessfulLoginWithEmptyUsernameAndInvalidPassword(){
        goToLoginPage();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        passwordField.sendKeys("pogresna lozinka");
        submitButton.click();

        boolean check= false;
        try {
            check= driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")).isDisplayed();
        }catch (Exception e){

        }
        Assert.assertFalse(check);

        WebElement errorMessage= driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }

}
