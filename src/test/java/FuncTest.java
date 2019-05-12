import com.google.common.collect.Lists;
import com.rumwei.base.ComparatorGW;
import com.rumwei.base.ConditionGW;
import com.rumwei.base.ConvertGW;
import com.rumwei.enums.OrderType;
import com.rumwei.util.*;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class FuncTest {

    public static void main(String[] args){

        String sample1 = "ni|hao|ma&";
        String[] sshu = StringUtilGW.split(sample1,"\\");
        String[] standart = sample1.split("\\|");

        String ss = "\\\\"+"*";
        System.out.println(ss);

        List<People> peoples = ListUtilGW.newArrayList();
        peoples.add(new People("hi",23));
        peoples.add(new People("ni",45));
        String coreNum = ListUtilGW.ListEleToString(peoples, "$", new ConvertGW<People, String>() {
            @Nullable
            @Override
            public String apply(@Nullable People var1) {
                return var1.getName();
            }
        });
        System.out.println(coreNum);
    }




}
