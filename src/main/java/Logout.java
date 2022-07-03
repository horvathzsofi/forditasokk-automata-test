import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Logout extends PageBase{
    private final String url = "http://forditasokk.probaljaki.hu/felhasznalo/forditasaim.php";
    private final By logoutLink = By.className("logout");
    private final By userMenu = By.xpath("//*[@class=\"felhasznalo\"]//a");

    public Logout(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(){
        webDriver.navigate().to(url);
    }

    public void clickOnLogoutLink(){
        webDriver.findElement(logoutLink).click();
    }

    public String[] getUserMenuItems(){
        List<WebElement> userMenuItems = webDriver.findElements(userMenu);
        String[] userMenuLinks = new String[userMenuItems.size()];
        for (int i = 0; i < userMenuItems.size(); i++) {
            userMenuLinks[i] = userMenuItems.get(i).getText();
        }
        return userMenuLinks;
    }
}
