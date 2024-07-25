package utility;



import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import constant.BrowserName;

import java.util.ArrayList;

public class DriverManager {
    Playwright playwright;

    public BrowserContext initializeBrowser(String browser){
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        playwright = Playwright.create();
        Browser br;
        switch (BrowserName.valueOf(browser)){
            case CHROME:
                br = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
                return br.newContext(new Browser.NewContextOptions().setViewportSize(null));
            case FIREFOX:
                br = playwright.firefox().launch((new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments)));
                return br.newContext(new Browser.NewContextOptions().setViewportSize(null));
            default:
                throw new IllegalStateException("Incorrect browser name:"+browser);
        }

    }

    public void quitSession(){

        playwright.close();
    }
}
