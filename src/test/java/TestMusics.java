import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestMusics extends TestingSetup {
    Musics musics = null;

    @BeforeEach
    public void createMusic() {
        musics = new Musics(webDriver);
    }

    @Test
    public void addNewMusic(){

    }

    @Test
    public void modifyMusicDetails(){
        
    }
}
