package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertiesLoaded {
    Properties properties = new Properties();

    public GetPropertiesLoaded(String filePath) {
        try {
            InputStream inputStream = new FileInputStream(filePath);
            try {
                properties.load(inputStream);
            } catch (IOException exception) {
                exception.printStackTrace();
                throw new RuntimeException("failed to load properties file " + filePath);
            }
        }
        catch (FileNotFoundException exception){
            exception.printStackTrace();
            throw new RuntimeException("properties file not found at " + filePath);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
