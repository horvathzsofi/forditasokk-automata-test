import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

public class TestArtists extends TestingSetup {
    Artists artists = null;
    Login login = null;

    @BeforeEach
    public void createArtists() {
        artists = new Artists(webDriver);
        login = new Login(webDriver);
    }

    /**
     * TODO: Testing entering data repeatedly from data source on "Előadók" (Artist.Artists) page
     * Test steps:
     * 1. Navigate to website
     * 2. Click on "Előadó hozzáadása" (Add artist) link
     * 3. Enter "Előadó neve" (Artist name)
     * 4. Enter "Kiadó neve" (Entertainment name)
     * 5. Click on "Előadó hozzáadása" (Add artist) button
     * 6. Verify that you have successfully added a new artist
     * 7. Repeat the test steps from step 2 until there is no test data
     */


    @ParameterizedTest
    @DisplayName("Ismételt adat bevitel külső adataforrásból")
    @Description("Előre meghatározott előadók hozzáadása csv kiterjesztésű fájlból")
    @Severity(SeverityLevel.NORMAL)
    @CsvFileSource(resources = "/artists.csv", numLinesToSkip = 1)
    public void addArtistsRepeatedly(String artist, String entertainment) {
        String username = "felhasznalo";
        String password = "asd";

        login.navigateToPage();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickOnButton();

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
