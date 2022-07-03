import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Musics extends PageBase {
    private final String url = "http://forditasokk.probaljaki.hu/zenek/zenek.php";
    private final By musicCard = By.className("kartya");
    private final By cardTitle = By.className("kartya_cim");
    private final By addMusicLink = By.linkText("Zene hozzáadása");
    private final By artistName = By.name("eloado");
    private final By albumTitle = By.name("album");
    private final By songTitle = By.name("dal_cim");
    private final By titleSong = By.name("focimdal");
    private final By addMusicButton = By.name("zene_hozzaad");

    /*
    //*[@class="kartya"]//*[text()="asd"] - verify if the song was added
    //*[@class="kartya_cim"][contains(text(),"Cold Love")] - find a card with this title
     */


    public Musics(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getMusicCards(){
        return webDriver.findElements(musicCard);
    }


}
