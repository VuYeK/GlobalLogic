package exerciseTwo.base;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Logger;


public class ConnectDB {

    private static volatile ConnectDB instance = null;
    public Connection polaczenie = null;
    public PreparedStatement prepareStmt;
    Logger logger = Logger.getLogger(ConnectDB.class.toString());

    private ConnectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            File file = new File("src/main/resources/exercise2/address_book.sqlite");
            if (file.exists())
                polaczenie = DriverManager.getConnection("jdbc:sqlite:src/main/resources/exercise2/address_book.sqlite");
            else
                polaczenie = DriverManager.getConnection("jdbc:sqlite:../../src/main/resources/exercise2/address_book.sqlite");
            logger.info("DB: Polaczenie z baza danych udane!");
        } catch (Exception e) {
            logger.info("DB: Class error");
            logger.info(e.getMessage());
        }
    }

    /**
     * Singleton ktory tworzy tylko 1 instancje klasy na wszystkich watkach(synchronized).
     */
    public static ConnectDB getInstance() {
        if (instance == null) {
            synchronized (ConnectDB.class) {
                if (instance == null) {
                    instance = new ConnectDB();
                }
            }
        }
        return instance;
    }
}
