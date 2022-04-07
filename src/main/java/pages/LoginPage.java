package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LoginPage extends Page {

    private static final Logger log = Logger.getLogger(String.valueOf(LoginPage.class));

    public LoginPage(PageManager pages){
        super(pages);
    }

    @FindBy(xpath = "//input[@name = 'username']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value = 'Login']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class = 'wrapper']")
    WebElement loginForm;

    @FindBy(xpath = "//img[@id = 'logomini']")
    WebElement logo;

    @FindBy(xpath = "//div[@class = 'wrapper']//h1")
    WebElement loginFormTitle;

    @FindBy(xpath = "(//span[@class = 'help-block'])[1]")
    WebElement loginErrorMessage;

    List<WebElement> elementsOnThePageList = new ArrayList<>();

    public void goToLink(String http){
        driver.get(http);
    }

    public void clickOnTheLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void fillUserNameField(String name){
        wait.until(ExpectedConditions.visibilityOf(userNameField));
        userNameField.sendKeys(name);
    }

    public void fillPasswordField(String pass){
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(pass);
    }

    public List<WebElement> getListOfElementsOnThePageList(){
        elementsOnThePageList.add(loginForm);
        elementsOnThePageList.add(loginButton);
        elementsOnThePageList.add(logo);
        elementsOnThePageList.add(userNameField);
        elementsOnThePageList.add(passwordField);
        elementsOnThePageList.add(loginButton);
        elementsOnThePageList.add(loginFormTitle);
        return elementsOnThePageList;
    }

    public WebElement getLoginErrorMessage(){
        return loginErrorMessage;
    }

}
