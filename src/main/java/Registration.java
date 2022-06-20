import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration extends PageBase{
    private final String url = "http://forditasokk.probaljaki.hu/felhasznalo/regisztracio.php";
    private final By username = By.xpath("//*[@name=\"felhasznalonev\"]");
    private final By password = By.xpath("//*[@type=\"password\"]");
    private final By errorMessage = By.xpath("//*[@class=\"hiba_uzi\"]");
    private final By button = By.xpath("//*[@name=\"bejelentkezes\"]");

    public Registration(WebDriver driver) {
        super(driver);
    }


}
