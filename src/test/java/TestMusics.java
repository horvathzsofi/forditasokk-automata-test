import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Műveletek a Zene oldalon")
public class TestMusics extends TestingSetup {
    Musics musics = null;
    Login login = null;

    @BeforeEach
    public void createMusic() {
        musics = new Musics(webDriver);
        login = new Login(webDriver);
    }

    @Test
    @DisplayName("Új zene hozzáadása az adatbázishoz")
    @Description("Új zene hozzáadása az adatbázishoz")
    @Severity(SeverityLevel.NORMAL)
    public void addNewMusic() {
        String username = "felhasznalo";
        String password = "asd";
        String artistName = "ONEWE";
        String albumTitle = "Planet Nine : Alter Ego";
        String songTitle = "Rain To Be";
        boolean isTitleSong = true;

        login.navigateToPage();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickOnButton();

        musics.navigateToPage();
        int numberOfMusicsBeforeAddingNewOne = musics.getMusicCards().size();
        musics.clickOnAddMusicLink();
        musics.enterArtistName(artistName);
        musics.enterAlbumTitle(albumTitle);
        musics.enterSongTitle(songTitle);
        musics.isThisATitleSong(isTitleSong);
        musics.clickOnAddMusicButton();
        int numberOfMusicsAfterAddingNewOne = musics.getMusicCards().size();

        Assertions.assertNotEquals(numberOfMusicsAfterAddingNewOne, numberOfMusicsBeforeAddingNewOne);
        Assertions.assertTrue(musics.findElementWithTitle(songTitle).isDisplayed());
    }


    @Test
    @DisplayName("Meglévő adat módosítása")
    @Description("Meglévő adat módosítása")
    @Severity(SeverityLevel.NORMAL)
    public void modifyMusicDetails() {
        String username = "felhasznalo";
        String password = "asd";
        String oldSongTitle = "Don't Wanna Cry";
        String newSongTitle = "Baby don't cry";

        login.navigateToPage();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickOnButton();

        musics.navigateToPage();
        int numberOfMusicsBeforeUpdating = musics.getMusicCards().size();
        musics.clickOnMusicCardWithTitle(oldSongTitle);
        musics.clickOnEditMusicLink();
        musics.enterSongTitleToUpdate(newSongTitle);
        musics.clickOnUpdateMusicButton();
        int numberOfMusicsAfterUpdating = musics.getMusicCards().size();

        Assertions.assertEquals(numberOfMusicsBeforeUpdating,numberOfMusicsAfterUpdating);
        Assertions.assertTrue(musics.findElementWithTitle(newSongTitle).isDisplayed());
    }
}
