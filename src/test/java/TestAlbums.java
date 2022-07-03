import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestAlbums extends TestingSetup {
    Albums albums = null;

    // create an instance of the Albums page before every @Test
    @BeforeEach
    public void createAlbums(){
        albums = new Albums(webDriver);
    }

    /** TODO: Testing pagination on "Albumok" (Albums) page
     * Test steps:
     * 1. Navigate to the website
     * 2. Save the titles of the albums
     * 3. Click on "Következő oldal" (Next page) button
     * 4. Save the first album's title on the page
     * 5. Check it if the title is not on the previously saved list
     */

    @Test
    public void checkingPaginationNextButton(){

    }
}
