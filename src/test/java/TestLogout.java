import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestLogout extends TestingSetup{
    Logout logout = null;

    @BeforeEach
    public void createLogout(){
        logout = new Logout(webDriver);
    }

    @Test
    public void successfulLogout(){

    }

}
