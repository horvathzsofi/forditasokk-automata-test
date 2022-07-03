import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

@Feature("Registration")
public class TestRegistration extends TestingSetup {
    Registration registration = null;

    @BeforeEach
    public void createRegistration() {
        registration = new Registration(webDriver);
    }

    @Test
    @DisplayName("Sikeres regisztráció")
    @Description("Sikeres regisztráció, mivel mindegyik beviteli mező valid adatot tartalmaz (DT-1 alapján)")
    @Severity(SeverityLevel.CRITICAL)
    public void successfulRegistration() throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(TestRegistration.class);
        logger.info("[successfulRegistration] method started.");
        String username = "bakipo3967";
        String email = "bakipo3967@jrvps.com";
        String password = "a";
        boolean accept = true;
        registration.navigateTo();
        logger.info("[successfulRegistration] navigated to registration page.");
        registration.enterUsername(username);
        logger.info("[successfulRegistration] entered username: " + username + ".");
        registration.enterEmail(email);
        logger.info("[successfulRegistration] entered email: " + email + ".");
        registration.enterPassword(password);
        registration.acceptPrivacyPolicy(accept);
        logger.info("[successfulRegistration] accepted Privacy policy: " + accept + ".");
        registration.clickOnRegistrationButton();
        logger.info("[successfulRegistration] clicked on registration button.");

        Thread.sleep(2000);
        Allure.addAttachment("Képernyőkép a sikeres regisztrációról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
        boolean messageDisplayed = registration.isMessageDisplayed();
        String expectedMessage = "Az aktiváláshoz szükséges azonosító linket elküldtük a megadott e-mail címre.\n" +
                "Az aktiváláshoz kattints rá, vagy másold a böngésző címsorába.";
        String actualMessage = registration.getMessage();

        Assertions.assertTrue(messageDisplayed);
        Assertions.assertEquals(expectedMessage, actualMessage);
        logger.info("[successfulRegistration] method finished.");
        Allure.addAttachment("Képernyőkép a sikeres regisztrációról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test
    @DisplayName("Sikertelen regisztráció")
    @Description("Már regisztrált felhasználónévvel és email címmel történő regisztráció a DT-12 alapján")
    @Severity(SeverityLevel.CRITICAL)
    @Disabled
    public void unsuccessfulRegistration() {
        String username = "felhasznalo";
        String email = "demodezso@localhost";
        String password = "a";
        boolean accept = true;
        registration.navigateTo();
        registration.enterUsername(username);
        registration.enterEmail(email);
        registration.enterPassword(password);
        registration.acceptPrivacyPolicy(accept);
        registration.clickOnRegistrationButton();
        String actualEmailErrorMessage = registration.getEmailErrorMessage();
        String actualUsernameErrorMessage = registration.getUsernameErrorMessage();

        //check username error message
        String expectedUsernameMessage = "A(z) " + username + " felhasználónév már foglalt.";
        Assertions.assertEquals(expectedUsernameMessage, actualUsernameErrorMessage);

        //check email error message
        String expectedEmailMessage = "A(z) " + email + " e-mail címmel már regisztráltak.";
        Assertions.assertEquals(expectedEmailMessage, actualEmailErrorMessage);

        Allure.addAttachment("Képernyőkép a sikertelen regisztrációról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }
}
