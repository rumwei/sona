import com.rumwei.enums.DeleteType;
import com.rumwei.util.StringUtilGW;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnitTest {

    @BeforeClass
    public static void beforeTest(){
        System.out.println("UnitTest start");
    }

    @AfterClass
    public static void afterTest(){
        System.out.println("UnitTest end");
    }

    //region StringUtilGW测试
    @Test
    public void StringUtilGWTest(){
        //trimStartOrEnd method
        String in1 = null;
        String in2 = "b&$ib";
        String in3 = "binislfa$&&b";
        String in4 = "nihugyf";
        try{
            Assert.assertEquals(StringUtilGW.trimStartOrEnd(in1, DeleteType.DeleteHeadString,'a'),"");
            Assert.assertEquals(StringUtilGW.trimStartOrEnd(in2, DeleteType.DeleteHeadString,'b','&','$'),"ib");
            Assert.assertEquals(StringUtilGW.trimStartOrEnd(in3, DeleteType.DeleteTailString,'b','&','$'),"binislfa");
            Assert.assertEquals(StringUtilGW.trimStartOrEnd(in4, DeleteType.DeleteTailString,'&','$'),"nihugyf");

        }catch(Exception e){
            e.printStackTrace();
        }



    }

    //endregion

    @Test
    public void test(){
        Assert.assertEquals("hu",new String("hu"));
    }






}
