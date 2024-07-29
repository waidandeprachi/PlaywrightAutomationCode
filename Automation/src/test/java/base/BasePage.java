package base;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class BasePage {
    protected static  Page page;

    public BasePage(Page page){
        this.page = page;
    }

    public void pause(int waitTime){
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            //nothing to do
        }
    }

    public static String takeScreenshot(){
        String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return path;
    }

    public static void reloadPage(){
        page.reload();
    }
}
