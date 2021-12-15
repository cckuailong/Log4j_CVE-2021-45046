import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class Test {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Test.class);
        ThreadContext.put("myContext", "${java:version}");
        logger.error("1111");
    }

}
