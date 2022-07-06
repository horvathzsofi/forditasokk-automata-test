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

@Feature("Adat vagy adatok törlése")
public class TestMyTranslation extends TestingSetup{
    MyTranslations myTranslations = null;
    Login login = null;

    @BeforeEach
    public void createMyTranslation(){
        myTranslations = new MyTranslations(webDriver);

        // successful login action
        login = new Login(webDriver);
        String username = "felhasznalo";
        String password = "asd";

        login.navigateToPage();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickOnButton();
    }


    @Test
    @DisplayName("Felhasználó által hozzáadott fordítás törlése")
    @Description("Felhasználó által hozzáadott fordítás törlése")
    @Severity(SeverityLevel.NORMAL)
    public void deleteMyTranslation(){
        myTranslations.navigateToPage();
        Allure.addAttachment("Képernyőkép a törlés előtti állapotról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
        String[] beforeDeletingTranslation = myTranslations.getMyTranslations();
        myTranslations.clickOnDeleteLinkFor("Delilah");
        String[] afterDeletingTranslation = myTranslations.getMyTranslations();

        Assertions.assertNotEquals(beforeDeletingTranslation.toString(), afterDeletingTranslation.toString());

        Allure.addAttachment("Képernyőkép a törlés utáni állapotról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }
}
