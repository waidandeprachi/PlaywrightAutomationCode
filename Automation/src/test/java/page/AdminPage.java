package page;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AdminPage extends BasePage {
    public AdminPage(Page page) {
        super(page);
    }

    public void clickOnAccounts(){
        boolean isExpanded = page.locator("//span[text()=\"Accounts\"]/following-sibling::span[contains(@class,\"toggle-button open\")]").isVisible();
        if(!isExpanded){
            page.locator("//div[contains(@class,\"sidebar-btn\")]//span[contains(@class,\"rubix-icon\")]").click();
            Locator locator = page.getByText("Accounts");
            locator.click();
        }
    }
    public void clickOnUsers(){
        page.getByText("Users").click();
    }

    public void searchUser(String userName) throws InterruptedException {
        page.locator("//div[@class=\"rubix-panel\"]//input[@class=\"search__input\"]").fill(userName);
        pause(2000);
        page.locator("//div[@class=\"rubix-panel\"]//span[contains(@class,\"search-icon\")]").click();
    }

    public void clickOnEditUserProfileButton(String userName) throws InterruptedException {
        page.waitForLoadState(LoadState.LOAD);
        pause(2000);
        page.locator("//table[contains(@class,\"dataTable\")]/tbody/tr/td/a[(text()=\""+ userName +"\")]/ancestor::tr/td//*[@title=\"Edit\"]").click();
    }

    public void enterJobRole(String role) throws InterruptedException {
        page.waitForLoadState(LoadState.LOAD);
        page.locator("//div[contains(text(),\"Job Title\")]/following-sibling::div/input[@type=\"text\"]").fill(role);
    }

    public void clickOnSaveButton() {
        page.getByText("Save").scrollIntoViewIfNeeded();
        page.getByText("Save").click();
    }

    public boolean isUserPresentInSearchList(String fullName){
        return page.locator("//table[contains(@class,\"dataTable\")]/tbody/tr/td/a[text()=\""+fullName+"\"]").isVisible();
    }
}
