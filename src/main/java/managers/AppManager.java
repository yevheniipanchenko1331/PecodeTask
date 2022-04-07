package managers;

import helpers.NavigationHelper;
import helpers.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class AppManager {

    private static final Logger log = Logger.getLogger(String.valueOf(AppManager.class));

    private static WebDriver driver;
    private NavigationHelper navigationHelper;
    private UserHelper userHelper;

    AppManager(){
        File chromeDriver = new File("/Users/kuzenka/JavaQa/chromedriver");
        ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();
        ChromeOptions chromeOptions = new ChromeOptions()
                .addArguments("--start-maximized");
        driver = new ChromeDriver(chromeDriverService,chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        userHelper = new UserHelper();
        navigationHelper = new NavigationHelper();
        log.info("chrome web driver started");
    }

    public static WebDriver getWebDriver(){return driver;}
    public UserHelper getUserHelper(){return userHelper;}
    public NavigationHelper getNavigationHelper(){return navigationHelper;}
}
