package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) { // Use webDriver.get() to check if the thread has a driver
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch (getBrowserType()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\BasicsCucumber\\src\\main\\java\\driver\\drivers\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Desktop\\BasicsCucumber\\src\\main\\java\\driver\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static String getBrowserType() {
String browserType = null;
try{
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\user\\Desktop\\BasicsCucumber\\src\\main\\java\\properties\\config.properties");
        properties.load(file);
        browserType=properties.getProperty("browser").toLowerCase().trim();

    }
catch (IOException ex){
    System.out.print(ex.getMessage());
}
return browserType;
    }

    public static void cleanup() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}
