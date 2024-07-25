package database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties properties = new Properties();

    static {
        try(InputStream inputStream = DatabaseConfig.class.getClassLoader().getResourceAsStream("db.properties"))
        {
          if(inputStream == null){
              System.out.println("Unable to find db properties");
              System.exit(1);
          }
          properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDbUrl() {

        return properties.getProperty("db.url");
    }

    public static String getDbUsername() {
        return properties.getProperty("db.username");
    }

    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }
}
