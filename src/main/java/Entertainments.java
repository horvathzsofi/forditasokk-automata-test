import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Entertainments extends PageBase{
    private final String url = "http://forditasokk.probaljaki.hu/kiadok/kiadok.php";
    private final By entertainmentNames = By.className("kartya_cim");

    public Entertainments(WebDriver driver) {
        super(driver);
    }

    public void navigateToPage(){
        webDriver.navigate().to(url);
    }

    public String[] getEntertainmentsName(){
        List<WebElement> entertainmentsElements = webDriver.findElements(entertainmentNames);
        String[] entertainmentNames = new String[entertainmentsElements.size()];

        for (int i = 0; i < entertainmentsElements.size(); i++) {
            entertainmentNames[i] = entertainmentsElements.get(i).getText();
        }

        return entertainmentNames;
    }
}
