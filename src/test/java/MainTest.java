import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MainTest {

    @Disabled
    @Test
    @Timeout(value = 22)
    void mainTestTime() throws Exception {
        String[] str = new String[0];
        Main.main(str);
    }
}