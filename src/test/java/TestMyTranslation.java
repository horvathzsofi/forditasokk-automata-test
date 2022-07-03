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

@Feature("Felhasználó által hozzáadtott fordítás törlése")
public class TestMyTranslation extends TestingSetup{
    MyTranslations myTranslations = null;

    @BeforeEach
    public void createMyTranslation(){
        myTranslations = new MyTranslations(webDriver);
    }


    @Test
    @DisplayName("Felhasználó által hozzáadott fordítás törlése")
    @Description("Felhasználó által hozzáadott fordítás törlése")
    @Severity(SeverityLevel.NORMAL)
    public void deleteMyTranslation() throws InterruptedException {
        TestLogin login = new TestLogin();
        login.successfulLogin();
        myTranslations.navigateToPage();
        Allure.addAttachment("Képernyőkép a törlés előtti állapotról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
        String[] beforeDeletingTranslation = myTranslations.getMyTranslations();
        myTranslations.clickOnDeleteLinkFor("Delilah");
        String[] afterDeletingTranslation = myTranslations.getMyTranslations();

        Assertions.assertNotEquals(beforeDeletingTranslation.toString(), afterDeletingTranslation.toString());

        Allure.addAttachment("Képernyőkép a törlés utáni állapotról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
    }
}
