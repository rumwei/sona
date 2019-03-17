import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FuncTest {

    public static void main(String[] args){
        String info = "ty";
        int num = 2;
        while (num-- > 0) {
            log.info("info is {} good", info);
            log.debug("debug");
            log.error("error");
            log.warn("warnnew");
        }
        System.err.println("dddd");
        System.out.println("dd");
    }
}
