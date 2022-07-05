import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Musics extends PageBase {
    private final String url = "http://forditasokk.probaljaki.hu/zenek/zenek.php";
    private final By musicCard = By.className("kartya");
    private final By addMusicLink = By.linkText("Zene hozzáadása");
    private final By artistName = By.name("eloado");
    private final By albumTitle = By.name("album");
    private final By songTitle = By.name("dal_cim");
    private final By itIsATitleSong = By.id("focimdal_igen");
    private final By notATitleSong = By.id("focimdal_nem");
    private final By addMusicButton = By.name("zene_hozzaad");

    private final By editMusicLink = By.linkText("Zene szerkesztése");
    private final By editSongTitle = By.name("zene_cime");
    private final By updateMusicButton = By.name("zene_frissit");


    public Musics(WebDriver driver) {
        super(driver);
    }

    public void navigateToPage() {
        webDriver.navigate().to(url);
    }

    public List<WebElement> getMusicCards() {
        return webDriver.findElements(musicCard);
    }

    public WebElement findElementWithTitle(String musicTitle) {
        String dynamicXpath = "//*[text()=\"" + musicTitle + "\"]/parent::a";
        return webDriver.findElement(By.xpath(dynamicXpath));
    }

    public void clickOnMusicCardWithTitle(String musicTitle) {
        findElementWithTitle(musicTitle).click();
    }

    public void clickOnAddMusicLink() {
        webDriver.findElement(addMusicLink).click();
    }

    public void enterArtistName(String testData) {
        webDriver.findElement(artistName).sendKeys(testData);
    }

    public void enterAlbumTitle(String testData) {
        webDriver.findElement(albumTitle).sendKeys(testData);
    }

    public void enterSongTitle(String testData) {
        webDriver.findElement(songTitle).sendKeys(testData);
    }

    public void isThisATitleSong(boolean testData) {
        if (testData) {
            webDriver.findElement(itIsATitleSong).click();
        } else {
            webDriver.findElement(notATitleSong).click();
        }
    }

    public void clickOnAddMusicButton() {
        webDriver.findElement(addMusicButton).click();
    }

    public void clickOnEditMusicLink() {
        webDriver.findElement(editMusicLink).click();
    }

    public void enterSongTitleToUpdate(String testData) {
        webDriver.findElement(editSongTitle).clear();
        webDriver.findElement(editSongTitle).sendKeys(testData);
    }

    public void clickOnUpdateMusicButton() {
        webDriver.findElement(updateMusicButton).click();
    }
}
