package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;

import static driver.DriverFactory.getDriver;

public class Login_Steps extends Base_PO {

  private  WebDriver driver = getDriver();

    @Given("I landed to login page")
    public void i_landed_to_login_page() {
        navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html");


    }

    @When("I enter username {string}")
    public void i_enter_username(String string) {
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(string);
    }

    @And("I enter password {string}")
    public void i_enter_password(String string) {
        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(string);
    }

    @And("I click on submit btn")
    public void i_click_on_submit_btn() {
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    @Then("I validate successful login")
    public void i_validate_successful_login() {
        Alert alert = driver.switchTo().alert();
        System.out.print(alert.getText());
        alert.accept();
    }

    @Then("I validate unsuccessful login")
    public void iValidateUnsuccessfulLogin() {
        Alert alert = driver.switchTo().alert();
        System.out.print(alert.getText());
        String actual = alert.getText();
        Assert.assertEquals(actual,"validation failed");
        alert.accept();
    }

    @Then("I validate message")
    public void iValidateMessage() {
        Alert alert = driver.switchTo().alert();
        System.out.print(alert.getText());
        //String actual = alert.getText();
        //Assert.assertEquals(actual,"validation failed");
        alert.accept();
    }
    }




