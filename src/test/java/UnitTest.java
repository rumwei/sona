import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class UnitTest {

    @BeforeAll
    public void beforeTest(){
        System.out.println("UnitTest start");
    }

    @AfterAll
    public void afterTest(){
        System.out.println("UnitTest end");
    }






}
