import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;


@Feature("Ismételt és sorozatos adatbevitel adatforrásból")
public class TestArtists extends TestingSetup {
    Artists artists = null;
    Login login = null;

    @BeforeEach
    public void createArtists() {
        artists = new Artists(webDriver);

        // successful login action
        login = new Login(webDriver);
        String username = "felhasznalo";
        String password = "asd";

        login.navigateToPage();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickOnButton();

    }

    // the content of the csv file was already added
    @Disabled
    @ParameterizedTest
    @DisplayName("Előadók sorozatos hozzáadása az adatbázishoz külső adatforrásból")
    @Description("Előre meghatározott előadók hozzáadása csv kiterjesztésű fájlból")
    @Severity(SeverityLevel.NORMAL)
    @CsvFileSource(resources = "/artists.csv", numLinesToSkip = 1)
    public void addArtistsRepeatedly(String artist, String entertainment) {
        artists.navigateTo();
        String[] artistNamesBeforeAddingNewOne = artists.getAllArtist();
        artists.navigateToAddNewArtistPage();
        artists.enterArtistName(artist);
        artists.enterEntertainment(entertainment);
        artists.clickOnAddNewArtistButton();

        String[] artistNamesAfterAddingNewOne = artists.getAllArtist();
        boolean isNewArtistWasNotAdded = Arrays.equals(artistNamesBeforeAddingNewOne, artistNamesAfterAddingNewOne);

        Assertions.assertFalse(isNewArtistWasNotAdded);
    }

}
