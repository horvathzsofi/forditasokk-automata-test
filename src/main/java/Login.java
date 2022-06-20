import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends PageBase{
    private final String url = "http://forditasokk.probaljaki.hu/felhasznalo/bejelentkezes.php";
    private final By username = By.name("felhasznalonev");
    private final By password = By.xpath("//input[@type=\"password\"]");
    private final By button = By.name("bejelentkezes");
    private final By errorMessage = By.className("hiba_uzi");

    public Login(WebDriver driver) {
        super(driver);
    }

    public void navigateToPage(){
        navigateToPage(url);
    }

    public void enterUsername(String usernameInput){
        userInput(username, usernameInput);
    }
    public void enterPassword(String passwordInput){
        userInput(password, passwordInput);
    }

    public void clickOnButton(){
        clickOnIt(button);
    }

    public String getErrorMessage(){
        return getData(errorMessage);
    }

    public WebElement ErrorMessage(){
        return getElement(errorMessage);
    }

}

