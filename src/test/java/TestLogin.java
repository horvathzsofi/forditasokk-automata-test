import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

@Feature("Bejelentkezés")
@Order(2)
public class TestLogin extends TestingSetup {
    Login login = null;

    private void fillForm(String username, String password){
        login.navigateToPage();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickOnButton();
    }

    @BeforeEach
    public void createLogin() {
        login = new Login(webDriver);
    }

    @Test
    @DisplayName("Sikertelen bejelentkezés")
    @Description("Bejelentkezés tesztelése hibás belépési adatokkal (DT-8 alapján)")
    @Severity(SeverityLevel.CRITICAL)
    public void correctFailedLoginMessage(){
        String username = "veloje";
        String password = "asd";
        fillForm(username, password);
        String actualMessage = login.getErrorMessage();
        String expectedMessage = "Nem megfelelő felhasználónév vagy jelszó.";
        Assertions.assertEquals(expectedMessage, actualMessage);
        Allure.addAttachment("Képernyőkép a sikertelen bejelentkezésről", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }


    @Test
    @DisplayName("Bejelentkezés inaktív fiókba")
    @Description("Bejelentkezés valós belépési adatokkal, nem aktivált fiókba (DT-3 alapján)")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithoutActivatingUserProfile(){
        String username = "Veloje";
        String password = "a";
        fillForm(username, password);
        String actualMessage = login.getErrorMessage();
        String expectedErrorMessage = "A fiókot még nem aktiválták. Nyissa meg e-mail fiókját és kattintson az aktiválás linkjére.";
        Allure.addAttachment("Képernyőkép a sikertelen bejelentkezésről inaktív fiókba", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(expectedErrorMessage, actualMessage);
    }


    // in this case a preregistered user login will happen, so I could show you the login automation successfully
    @Test
    @DisplayName("Sikeres bejelentkezés")
    @Description("Bejelentkezés tesztelése valós belépési adatokkal (DT-1 alapján)")
    @Severity(SeverityLevel.CRITICAL)
    public void successfulLogin() throws InterruptedException {
        String username = "felhasznalo";
        String password = "asd";
        fillForm(username, password);
        Thread.sleep(2000);
        String actual = login.getLoggedInUsername();
        Assertions.assertEquals(username, actual);
        Allure.addAttachment("Képernyőkép a sikeres bejelentkezésről", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }

}
