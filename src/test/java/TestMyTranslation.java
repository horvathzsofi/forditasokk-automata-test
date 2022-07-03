import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestMyTranslation extends TestingSetup{
    MyTranslations myTranslations = null;

    @BeforeEach
    public void createMyTranslation(){
        myTranslations = new MyTranslations(webDriver);
    }


    @Test
    public void deleteMyTranslation(){

    }
}
