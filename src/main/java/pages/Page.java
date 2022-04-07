package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    Page(PageManager pages){
        this.driver = pages.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
