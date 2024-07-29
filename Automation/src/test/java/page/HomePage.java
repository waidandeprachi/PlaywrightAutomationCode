package page;

import base.BasePage;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public void clickOnMoreOptions(){
        page.locator("//button[@aria-label=\"More options and features\"]").click();
    }

    public void clickOnTalentSourcing(){
        page.getByText("Talent Sourcing").click();
    }
    public void clickOnAdmin(){
        page.getByText("Admin").click();
    }

    public void logout(){
        pause(2000);
        page.locator("//div[contains(@class,\"profile\")]").click();
        page.getByText("Sign Out").click();
    }
}
