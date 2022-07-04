import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Feature("Adatok kilistázása")
public class TestEntertainments extends TestingSetup {
    Entertainments entertainments = null;

    @BeforeEach
    public void createEntertainment() {
        entertainments = new Entertainments(webDriver);
    }

    /**
     * TODO:
     * Test steps:
     * 1. Navigate to the website
     * 2. Count entertainments
     * 3. Verify that all the predefined entertainments are displayed on the page
     */


    @Test
    @DisplayName("Kiadók nevének kilistázása")
    @Description("Az összes kiadó nevének kilistázása")
    @Severity(SeverityLevel.MINOR)
    public void verifyThatAllEntertainmentsAreDisplayed() {
        int expectedLength = 14;
        String[] expectedEntertainmentNames = {
                "Big Hit",
                "Choeun",
                "Cube",
                "Dream Tea",
                "Fantagio",
                "FNC",
                "Hyeyoom",
                "JTM",
                "JYP",
                "N\\A",
                "Pledis",
                "RBW Entertainment",
                "SM",
                "YG"
        };

        entertainments.navigateToPage();
        String[] actualEntertainmentNames = entertainments.getEntertainmentsName();

        Assertions.assertEquals(expectedLength, actualEntertainmentNames.length);
        Assertions.assertArrayEquals(expectedEntertainmentNames, actualEntertainmentNames);
    }
}
