package helpers;

import managers.AppManager;
import org.openqa.selenium.WebElement;
import pages.PageManager;

import java.util.List;

public class UserHelper extends PageManager {

    public UserHelper() {
        super(AppManager.getWebDriver());
    }

    public void userLogin(String name,String pass){
        loginPage.fillUserNameField(name);
        loginPage.fillPasswordField(pass);
        loginPage.clickOnTheLoginButton();
    }

    public List<WebElement> getElementsOnTheLoginPageList(){
        return loginPage.getListOfElementsOnThePageList();
    }

    public WebElement getLoginErrorMessageElement(){
        return loginPage.getLoginErrorMessage();
    }

}
