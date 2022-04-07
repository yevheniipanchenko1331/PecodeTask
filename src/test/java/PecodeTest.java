import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.DataProviderClass;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;

public class PecodeTest extends TestBase {

    private static final Logger log = Logger.getLogger(String.valueOf(PecodeTest.class));

    @Test
    public void presentOfElementsTest()
    {
        log.info("navigate to pecodesoftware.com");
        app.getNavigationHelper().goToLink("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");
        log.info("check that all elements on the login page is present");
        app.getUserHelper().getElementsOnTheLoginPageList().forEach(elem -> Assert.assertTrue(elem.isDisplayed()));
    }


    @Test(dataProvider = "incorrectLoginDataProvider", dataProviderClass = DataProviderClass.class)
    public void unsuccessfulLoginErrorMessageTest(String userName, String pass)
    {
        log.info("navigate to pecodesoftware.com");
        app.getNavigationHelper().goToLink("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");
        log.info("login as not existing user");
        app.getUserHelper().userLogin(userName, pass);
        String errorMessage = app.getUserHelper().getLoginErrorMessageElement().getText();
        log.info("Verify that error message is appear");
        Assert.assertEquals(errorMessage,"No account found with that username.");
    }

    @Test(dataProvider = "correctLoginDataProvider", dataProviderClass = DataProviderClass.class)
    public void correctLoginTest(String userName, String pass){
        log.info("navigate to pecodesoftware.com");
        app.getNavigationHelper().goToLink("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");
        log.info("login as existing user");
        app.getUserHelper().userLogin(userName, pass);
        log.info("Verify that error message is not appear");
        Assert.assertFalse(app.getUserHelper().getLoginErrorMessageElement().isDisplayed());
    }
}
