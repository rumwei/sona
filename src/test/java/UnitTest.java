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


        //split method
        String sample1 = "ni|hao|ma&";
        String sample2 = "ni*hao*ma&";
        String sample3 = "ni+hao+ma&";
        String sample4 = "ni.hao.ma&";
        String sample5 = "ni\\hao\\ma&";
        String sample6 = null;
        try{
            Assert.assertArrayEquals(StringUtilGW.split(sample1,"|"),new String[]{"ni","hao","ma&"});
            Assert.assertArrayEquals(StringUtilGW.split(sample2,"*"),new String[]{"ni","hao","ma&"});
            Assert.assertArrayEquals(StringUtilGW.split(sample3,"+"),new String[]{"ni","hao","ma&"});
            Assert.assertArrayEquals(StringUtilGW.split(sample4,"."),new String[]{"ni","hao","ma&"});
            Assert.assertArrayEquals(StringUtilGW.split(sample5,"\\"),new String[]{"ni","hao","ma&"});
            Assert.assertNull(StringUtilGW.split(sample6,"ni"));
            Assert.assertNull(StringUtilGW.split(sample1,null));

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
