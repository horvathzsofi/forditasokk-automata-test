import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestEntertainments extends TestingSetup {
    Entertainments entertainments = null;

    @BeforeEach
    public void createEntertainment() {
        entertainments = new Entertainments(webDriver);
    }

    /** TODO:
     * Test steps:
     * 1. Navigate to the website
     * 2. Count entertainments
     * 3. Verify that all the predefined entertainments are displayed on the page
     *
     * Predefined entertainments: Big Hit, Choeun, Cube, Dream Tea, Fantagio, FNC, Hyeyoom, JTM, JYP, N\A, Pledis, RBW Entertainment, SM, YG
     */

    @Test
    public void verifyThatAllEntertainmentsAreDisplayed(){

    }
}
