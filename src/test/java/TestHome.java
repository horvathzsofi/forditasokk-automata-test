import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestHome extends TestingSetup{
    Home home = null;

    @BeforeEach
    public void createHome(){
        home = new Home(webDriver);
    }

    /** TODO: Collect albums and their release date from homepage into txt file
     * 1. Navigate to the website
     * 2. Collect albums' title and release date into a txt file
     * 3. Verify that the latest album is the first on the list
     */

    @Disabled
    @Test
    public void collectDataFromHomepage(){
    }
}
