import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends PageBase{
    private final String url = "http://forditasokk.probaljaki.hu/";
    private final By albumTitle = By.xpath("//*[@class=\"cimke2\"]//a");
    private final By releaseDate = By.xpath("//*[@class=\"cimke4\"]//p");

    protected Home(WebDriver driver) {
        super(driver);
    }

    public void navigateToPage(){
        webDriver.navigate().to(url);
    }

    public String getAlbumTitle(){
        return webDriver.findElement(albumTitle).getText();
    }

    public String getReleaseDate(){
        return webDriver.findElement(releaseDate).getText();
    }
}
