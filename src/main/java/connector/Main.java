package connector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.rmi.server.UID;
import java.util.UUID;

public class Main {
    private final static Logger logger= LogManager.getLogger(Main.class);

        public static void main(String[] args) {

        Repository repository = new Repository();

        try{
            repository.saveBicycle(UUID.randomUUID(), "large XS", "mark twain");
        } finally {
            logger.info(" log pishet");
            System.out.println("wse horosho");
            repository.close();
        }

    }

}
