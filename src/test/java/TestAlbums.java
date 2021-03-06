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
import java.util.Arrays;

@Feature("Több oldalas lista bejárása")
public class TestAlbums extends TestingSetup {
    Albums albums = null;

    @BeforeEach
    public void createAlbums() {
        albums = new Albums(webDriver);
    }

    @Test
    @DisplayName("Lapozás tesztelése az Albumok oldalon")
    @Description("Annak ellenőrzése, hogy a lapozás során változik-e az oldal tartalom")
    @Severity(SeverityLevel.NORMAL)
    public void checkingPaginationChangeContent() {
        albums.navigateTo();
        String[] albumTitles = albums.getAlbumTitles();
        Allure.addAttachment("Képernyőkép a lapozás előtti állapotról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
        albums.clickOnNextPageButton();
        Allure.addAttachment("Képernyőkép a lapozás utáni állapotról", new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
        String firstAlbumOnPage = albums.getFirstAlbumTitleOnThePage();
        boolean notChangedContent = Arrays.asList(albumTitles).contains(firstAlbumOnPage);

        Assertions.assertFalse(notChangedContent);
    }

    @Test
    @DisplayName("Lapozási gomb eltűnésének tesztelése az Albumok oldalon")
    @Description("Lapozási gomb eltűnésének tesztelése az Albumok oldalon")
    @Severity(SeverityLevel.MINOR)
    public void checkingPaginationNextButton() {
        albums.navigateTo();
        boolean nextPageButtonDisplayed = true;
        while (nextPageButtonDisplayed){
            albums.clickOnNextPageButton();
            nextPageButtonDisplayed = albums.isNextPageButtonDisplayed();
        }
        Assertions.assertFalse(nextPageButtonDisplayed);
    }
}
