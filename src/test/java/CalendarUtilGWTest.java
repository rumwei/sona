import com.rumwei.enums.DateType;
import com.rumwei.util.CalendarUtilGW;
import com.rumwei.util.StringUtilGW;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class CalendarUtilGWTest {



    @Test
    public void test(){

        try{
            Calendar early = StringUtilGW.stringToCalendar("1906-01-01 23:20:98", DateType.YMDHMS);
            Calendar later = StringUtilGW.stringToCalendar("2019-01-01 01:59:98", DateType.YMDHMS);
            Assert.assertEquals(CalendarUtilGW.getDateDaysBetweenDate(early,later),41273);
            Assert.assertEquals(CalendarUtilGW.getDateDaysBetweenDate(later,early),-41273);

            Calendar early1 = StringUtilGW.stringToCalendar("2019-05-01 23:20:98", DateType.YMDHMS);
            Calendar later1 = StringUtilGW.stringToCalendar("2019-05-02 01:59:98", DateType.YMDHMS);
            Assert.assertEquals(CalendarUtilGW.getDateDaysBetweenDate(early1,later1),1);


        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
