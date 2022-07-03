import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

@Feature("Kijelentkezés")
public class TestLogout extends TestingSetup{
    Logout logout = null;

    @BeforeEach
    public void createLogout(){
        logout = new Logout(webDriver);
    }

    @Test
    @DisplayName("Kijelentkezés tesztelése")
    @Description("Kijelentkezés felhasználói fiókból")
    @Severity(SeverityLevel.CRITICAL)
    public void successfulLogout() throws InterruptedException {
        TestLogin login = new TestLogin();
        login.successfulLogin();
        logout.navigateTo();
        String[] beforeLogoutUserMenu = logout.getUserMenuItems();
        Allure.addAttachment("Képernyőkép a kijelentkezés előtti állapotról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
        logout.clickOnLogoutLink();
        String[] afterLogoutUserMenu = logout.getUserMenuItems();

        Assertions.assertNotEquals(beforeLogoutUserMenu.toString(), afterLogoutUserMenu.toString());

        Allure.addAttachment("Képernyőkép a kijelentkezés előtti állapotról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }

}
