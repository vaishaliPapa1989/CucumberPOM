package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;

import static driver.DriverFactory.getDriver;


public class Contact_Steps extends Base_PO {

    private  WebDriver driver = getDriver();


    @Given("I landed on contact page")
    public void i_landed_on_contact_page() {
        // driver.get("https://mail.google.com/");
        navigateTo_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
        driver.getTitle();
    }
    @When("I enter first name")
    public void i_enter_first_name() {
        //driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys("FirstName" + GenerateRandomNumber(8));
        sendKeys(By.xpath("//input[@name=\"first_name\"]"),"FirstName" + GenerateRandomNumber(8));
    }

    @And("I enter last name")
    public void i_enter_last_name() {
        driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("lastName" + GenerateRandomNumber(8));
        WebElement email = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        email.sendKeys("email"+ GenerateRandomNumber(5)+ "@gmail.com");
        email.getText();
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("free text" + GenerateRandomAlphabets(50));
    }
    @Then("I verify I am successfully logged in.")
    public void i_verify_i_am_successfully_logged_in() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value=\"SUBMIT\"]")).click();
        Thread.sleep(4000);
        WebElement message = driver.findElement(By.xpath("//div[@id=\"contact_reply\"]/h1"));
        Assert.assertEquals(message.getText(),"Thank You for your Message!");
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys(firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys(lastName);
    }
    @When("I enter specific email address {word}")
    public void i_enter_specific_email_address(String email) {
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
    }
    @When("I enter specific message {string}")
    public void i_enter_specific_message(String string) {
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys(string);
    }
    @When("I click on submit button")
    public void i_click_on_submit_button() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value=\"SUBMIT\"]")).click();
        Thread.sleep(4000);
    }
    @Then("Successful login should happen.")
    public void successful_login_should_happen() {
        WebElement message = driver.findElement(By.xpath("//div[@id=\"contact_reply\"]/h1"));
        Assert.assertEquals(message.getText(),"Thank You for your Message!");
    }
}
