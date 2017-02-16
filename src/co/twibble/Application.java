package co.twibble;

/**
 * Created by andymccall on 16/02/2017.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final Logger logger =
            LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Entering main()");

        SpringApplication.run(Application.class, args);

        logger.info("Exiting main()");
    }
}
