import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

@Feature("Regisztráció; Adatkezelési nyilatkozat használata")
@Order(1)
public class TestRegistration extends TestingSetup {
    Registration registration = null;

    @BeforeEach
    public void createRegistration() {
        registration = new Registration(webDriver);
    }

    // this test is disabled: it will show error message with the current test data, because with this data there is a registered user already
    @Disabled
    @Test
    @DisplayName("Sikeres regisztráció")
    @Description("Sikeres regisztráció, mivel mindegyik beviteli mező valid adatot tartalmaz (DT-1 alapján)")
    @Severity(SeverityLevel.CRITICAL)
    public void successfulRegistration() throws InterruptedException {
        String username = "Veloje";
        String email = "bakipo3967@jrvps.com";
        String password = "a";
        boolean accept = true;
        registration.navigateTo();
        registration.enterUsername(username);
        registration.enterEmail(email);
        registration.enterPassword(password);
        registration.acceptPrivacyPolicy(accept);
        registration.clickOnRegistrationButton();

        Thread.sleep(2000);

        boolean messageDisplayed = registration.isMessageDisplayed();
        String expectedMessage = "Az aktiváláshoz szükséges azonosító linket elküldtük a megadott e-mail címre.\n" +
                "Az aktiváláshoz kattints rá, vagy másold a böngésző címsorába.";
        String actualMessage = registration.getMessage();

        Assertions.assertTrue(messageDisplayed);
        Assertions.assertEquals(expectedMessage, actualMessage);

        Allure.addAttachment("Képernyőkép a sikeres regisztrációról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }


    @Test
    @DisplayName("Sikertelen regisztráció")
    @Description("Már regisztrált felhasználónévvel és email címmel történő regisztráció a DT-12 alapján")
    @Severity(SeverityLevel.CRITICAL)
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
