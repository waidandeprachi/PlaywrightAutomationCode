package page;

import base.BasePage;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    public LoginPage(Page page){
        super(page);
    }

    public void enterUserId(String userId){
        page.getByPlaceholder("Email").fill(userId);
    }

    public void enterPassword(String password){
        page.getByPlaceholder("Password").fill(password);
    }

    public void clickOnLoginButton(){
        page.locator("//button[@type=\"submit\"]").click();
    }

    public void login(String url, String userId, String password){
        page.navigate(url);
        page.getByPlaceholder("Email").fill(userId);
        page.getByPlaceholder("Password").fill(password);
        page.locator("//button[@type=\"submit\"]").click();
    }

    public boolean isWelcomePageDisplayed(String firstName) {
        pause(2000);
        return  page.locator("//div/h5[contains(text(),\"Hello "+firstName+"\")]").isVisible();
    }

    public void clickOnNextButton() {
        page.getByText("Next").scrollIntoViewIfNeeded();
        page.locator("//div/button[text()=\"Next\"]").click();
    }
}
