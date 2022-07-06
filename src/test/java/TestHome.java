import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Feature("Adatok lementése felületről")
public class TestHome extends TestingSetup {
    Home home = null;
    FileHandler fileHandler = null;

    @BeforeEach
    public void createHome() {
        home = new Home(webDriver);
        fileHandler = new FileHandler();
    }


    @Test
    @DisplayName("Adatok kigyűjtése a kezdőlapról")
    @Description("Az oldalon szereplő 10 album címének kigyűjtése egy TXT kiterjesztésű fájlba a kezdőlapról")
    @Severity(SeverityLevel.MINOR)
    public void collectAlbumTitlesFromHomepage() {
        String filePath = "src/test/output/albumsOnHomePage.txt";
        fileHandler.deleteFile(filePath);
        String[] expectedAlbumTitleList = {
                "Planet Nine : Alter Ego",
                "MAP OF THE SOUL : 7",
                "MAP OF THE SOUL : PERSONA",
                "LOVE YOURSELF 結 ‘Answer'",
                "emphas!ze",
                "LOVE YOURSELF 轉 'Tear'",
                "LOVE YOURSELF 承 'Her'",
                "Al1",
                "Stardom",
                "You Never Walk Alone"};
        home.navigateToPage();
        String[] actualAlbumsOnHomePage = home.getAlbumTitles();

        for (String albums : actualAlbumsOnHomePage) {
            fileHandler.writeFile(albums, filePath);
        }

        String result = fileHandler.readFile(filePath);
        String[] albumTitlesFromFile = result.split("\n");

        Assertions.assertEquals(actualAlbumsOnHomePage.length, albumTitlesFromFile.length);
        Assertions.assertArrayEquals(expectedAlbumTitleList, albumTitlesFromFile);
    }
}
