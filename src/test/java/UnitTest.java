import com.rumwei.enums.DeleteType;
import com.rumwei.util.StringUtilGW;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class UnitTest {

    @BeforeAll
    public static void beforeTest(){
        System.out.println("UnitTest start");
    }

    @AfterAll
    public static void afterTest(){
        System.out.println("UnitTest end");
    }

    //region StringUtilGW测试
    @Test
    public void StringUtilGWTest(){
        //trimStartOrEnd method
        String in1 = null;
        String in2 = "b&$ib";
        try{
            Assertions.assertEquals(StringUtilGW.trimStartOrEnd(in1, DeleteType.DeleteHeadString,'a'),"");
            Assertions.assertEquals(StringUtilGW.trimStartOrEnd(in2, DeleteType.DeleteHeadString, 'b','&','$'),"ib");
        }catch(Exception e){
            e.printStackTrace();
        }

        //StringToBigDecimal
        String in3 = "1.23";
        //Assertions.assertEquals(new BigDecimal("1.23"),new BigDecimal(1.23));

    }

    //endregion

    @Test
    public void test(){
        Assertions.assertEquals("hu",new String("hu"));
    }






}
