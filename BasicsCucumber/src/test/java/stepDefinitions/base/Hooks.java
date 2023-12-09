package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Timestamp;

import static driver.DriverFactory.cleanup;
import static driver.DriverFactory.getDriver;

public class Hooks {

    public WebDriver driver;

    @Before
    public void setUp() {
        getDriver();

    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario){
        if(scenario.isFailed()){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String currentTimeMillis = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",currentTimeMillis);
        }

    }

    @After

    public void tearDown() {
        cleanup();

    }
}