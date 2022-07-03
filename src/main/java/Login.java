import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends PageBase{
    private final String url = "http://forditasokk.probaljaki.hu/felhasznalo/bejelentkezes.php";
    private final By username = By.name("felhasznalonev");
    private final By password = By.xpath("//input[@type=\"password\"]");
    private final By button = By.name("bejelentkezes");
    private final By errorMessage = By.className("hiba_uzi");
    private final By loggedInUsername = By.id("felhasznalonev");

    public Login(WebDriver driver) {
        super(driver);
    }

    public void navigateToPage(){
        webDriver.navigate().to(url);
    }

    public void enterUsername(String usernameInput){
        webDriver.findElement(username).sendKeys(usernameInput);
    }

    public void enterPassword(String passwordInput){
        webDriver.findElement(password).sendKeys(passwordInput);
    }

    public void clickOnButton(){
        webDriver.findElement(button).click();
    }

    public String getErrorMessage(){
        return webDriver.findElement(errorMessage).getText();
    }

    public String getLoggedInUsername(){
        return webDriver.findElement(loggedInUsername).getText();
    }

}

