import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTranslations extends PageBase {
    private final String url = "http://forditasokk.probaljaki.hu/felhasznalo/forditasaim.php";
    private final By deleteTranslationLink = By.linkText("Töröl");
    private final By card = By.className("uj_kartya");
    private String dynamicXpath = "";


    public MyTranslations(WebDriver driver) {
        super(driver);
    }

    public void navigateToPage() {
        webDriver.navigate().to(url);
    }

    private WebElement findItemForDelete(String itemToDelete) {
        dynamicXpath = "//*[text()=\"" + itemToDelete + "\"]/parent::div";
        return webDriver.findElement(By.xpath(dynamicXpath));
    }

    public void clickOnDeleteLinkFor(String deleteThis) {
        findItemForDelete(deleteThis).findElement(deleteTranslationLink).click();
    }

    public String[] getMyTranslations() {
        List<WebElement> myTranslationsList = webDriver.findElements(card);
        String[] myTranslations = new String[myTranslationsList.size()];
        for (int i = 0; i < myTranslations.length; i++) {
            myTranslations[i] = myTranslationsList.get(i).getText();
        }
        return myTranslations;
    }
}
