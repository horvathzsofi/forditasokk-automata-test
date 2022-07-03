import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration extends PageBase{
    private final String url = "http://forditasokk.probaljaki.hu/felhasznalo/regisztracio.php";
    private final By username = By.xpath("//*[@name=\"felhasznalonev\"]");
    private final By email = By.xpath("//*[@name=\"email\"]");
    private final By password = By.xpath("//*[@type=\"password\"]");
    private final By privacyPolicyCheckbox = By.id("ASZF");
    private final By message = By.className("siker_uzi");
    private final By registrationButton = By.xpath("//*[@name=\"regisztral\"]");
    private final By errorMessageForUsername = By.xpath("//*[@class=\"felhasznalonev\"]//span");
    private final By errorMessageForEmail = By.xpath("//*[@id=\"email\"]//span");

    public Registration(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(){
        webDriver.navigate().to(url);
    }

    public void enterUsername(String testData){
        webDriver.findElement(username).sendKeys(testData);
    }

    public void enterEmail(String testData){
        webDriver.findElement(email).sendKeys(testData);
    }

    public void enterPassword(String testData){
        webDriver.findElement(password).sendKeys(testData);
    }

    public void acceptPrivacyPolicy(boolean accept){
        if(accept){
            webDriver.findElement(privacyPolicyCheckbox).click();
        }
    }

    public void clickOnRegistrationButton(){
        webDriver.findElement(registrationButton).click();
    }

    public boolean getMessage(){
        return webDriver.findElement(message).isDisplayed();
    }

    public String getUsernameErrorMessage(){
        return webDriver.findElement(errorMessageForUsername).getText();
    }

    public String getEmailErrorMessage(){
        return webDriver.findElement(errorMessageForEmail).getText();
    }
}
