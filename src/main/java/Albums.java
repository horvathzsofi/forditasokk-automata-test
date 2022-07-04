import org.bouncycastle.x509.PKIXAttrCertChecker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Albums extends PageBase {
    private final String url = "http://forditasokk.probaljaki.hu/albumok/albumok.php";
    private final By card = By.className("kartya");
    private final By albumTitle = By.className("kartya_cim");
    private final By nextPageButton = By.id("kovetkezo");

    public Albums(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        webDriver.navigate().to(url);
    }

    public String[] getAlbumTitles(){
        List<WebElement> albumElements = webDriver.findElements(albumTitle);
        String[] albumTitles = new String[albumElements.size()];

        for (int i = 0; i < albumElements.size(); i++) {
            albumTitles[i] = albumElements.get(i).getText();
        }

        return albumTitles;
    }

    public String getFirstAlbumTitleOnThePage(){
        return webDriver.findElement(card).getText();
    }

    public void clickOnNextPageButton(){
        webDriver.findElement(nextPageButton).click();
    }

    public boolean isNextPageButtonDisplayed(){
        return webDriver.findElement(nextPageButton).isDisplayed();
    }

}
