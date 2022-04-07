package util;


import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "correctLoginDataProvider")
    public static Object[][] loginDataProviderMethod() {
        return new Object[][] { { "user1", "pass1" }, { "user2", "pass2" } };
    }

    @DataProvider(name = "incorrectLoginDataProvider")
    public static Object[][] incorrectLoginDataProviderMethod() {
        return new Object[][] { { "user1", "pass1" }};
    }
}
