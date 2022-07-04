import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Feature("Több oldalas lista bejárása")
public class TestAlbums extends TestingSetup {
    Albums albums = null;

    // create an instance of the Albums page before every @Test
    @BeforeEach
    public void createAlbums() {
        albums = new Albums(webDriver);
    }

    /**
     * TODO: Testing pagination on "Albumok" (Albums) page
     * Test steps:
     * 1. Navigate to the website
     * 2. Save the titles of the albums
     * 3. Click on "Következő oldal" (Next page) button
     * 4. Save the first album's title on the page
     * 5. Check it if the title is not on the previously saved list
     */


    @Test
    @DisplayName("Lapozás tesztelése az Albumok oldalon")
    @Description("Annak ellenőrzése, hogy a lapozás során változik-e az oldal tartalom")
    @Severity(SeverityLevel.NORMAL)
    public void checkingPaginationChangeContent() {
        albums.navigateTo();
        String[] albumTitles = albums.getAlbumTitles();
        albums.clickOnNextPageButton();
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
        Assertions.assertFalse(albums.isNextPageButtonDisplayed());
    }
}
