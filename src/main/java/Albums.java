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

    public List<WebElement> getAlbumTitleWebElements(){
        return webDriver.findElements(albumTitle);
    }

    public String getAlbumTitle(WebElement albumWebElement){
        return albumWebElement.getText();
    }

    public void clickOnNextPageButton(){
        webDriver.findElement(nextPageButton).click();
    }


}
