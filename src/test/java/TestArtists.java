import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestArtists extends TestingSetup {
    Artists artists = null;

    @BeforeEach
    public void createArtists() {
        artists = new Artists(webDriver);
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


    @Disabled
    @ParameterizedTest
    @CsvFileSource(resources = "/artists.csv", numLinesToSkip = 1)
    public void addArtistsRepeatedly(String artist, String entertainment) {
    }

}
