package constant;

import data.GetPropertiesLoaded;

public class ConfigValues {
    public static final String path = "src/test/resources/config.properties";
    static GetPropertiesLoaded prop = new GetPropertiesLoaded(path);

    public static final String csvPath = prop.getProperty("csv.path");
    public static final String csvPath2 = prop.getProperty("csv.path2");
    public static final String csvPath3 = prop.getProperty("csv.path3");
    public static final String devUrl = prop.getProperty("dev.url");
    public static final String devEmail = prop.getProperty("dev.admin.email");
    public static final String devPassword = prop.getProperty("dev.admin.password");
    public static final String automationURL1 = prop.getProperty("automation.url1");
    public static final String automationURL2 = prop.getProperty("automation.url2");
    public static final String automationEmail = prop.getProperty("automation.emailId");
    public static final String automationPassword = prop.getProperty("automation.password");



}
