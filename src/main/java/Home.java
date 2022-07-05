import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home extends PageBase {
    private final String url = "http://forditasokk.probaljaki.hu/";
    private final By albumTitle = By.xpath("//*[@class=\"cimke2\"]//a");

    protected Home(WebDriver driver) {
        super(driver);
    }

    public void navigateToPage() {
        webDriver.navigate().to(url);
    }

    public String[] getAlbumTitles() {
        List<WebElement> albumElements = webDriver.findElements(albumTitle);
        String[] albumTitles = new String[albumElements.size()];

        for (int i = 0; i < albumElements.size(); i++) {
            albumTitles[i] = albumElements.get(i).getText();
        }

        return albumTitles;
    }
}
