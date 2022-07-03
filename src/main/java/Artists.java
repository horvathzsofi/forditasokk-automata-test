import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Artists extends PageBase{
    private final String url = "http://forditasokk.probaljaki.hu/eloadok/eloadok.php";
    private final By addNewArtistLink = By.className("muvelet");
    private final By artistName = By.id("eloado");
    private final By entertainment = By.id("kiado");
    private final By addNewArtistButton = By.name("eloado_hozzaad");
    private final By artists = By.className("kartya_cim");

    public Artists(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(){
        webDriver.navigate().to(url);
    }

    public List<WebElement> getAllArtist(){
        return webDriver.findElements(artists);
    }

    public String getArtistName(WebElement element){
        return element.getText();
    }

    public void navigateToAddNewArtistPage(){
        webDriver.findElement(addNewArtistLink).click();
    }

    public void enterArtistName(String testData){
        webDriver.findElement(artistName).sendKeys(testData);
    }

    public void enterEntertainment(String testData){
        webDriver.findElement(entertainment).sendKeys(testData);
    }

    public void clickOnAddNewArtistButton(){
        webDriver.findElement(addNewArtistButton).click();
    }
 }