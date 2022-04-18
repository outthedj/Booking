package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private WebDriver driver;
    private static DriverManager instanceOfDriverManager;

    private DriverManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static DriverManager getInstanceOfDriverManager() {
        if (instanceOfDriverManager == null) {
            instanceOfDriverManager = new DriverManager();
        }
        return instanceOfDriverManager;
    }

    public WebDriver getDriver(){
        return driver;
    }
}