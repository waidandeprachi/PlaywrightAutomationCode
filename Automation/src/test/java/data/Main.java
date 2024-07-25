package data;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GetPropertiesLoaded values = new GetPropertiesLoaded("src/test/resources/config.properties");
        System.out.println(values.getProperty("dev.url"));
    }
}
