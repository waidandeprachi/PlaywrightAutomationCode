package tests;

import base.BaseTest;
import data.CSVDataStore;
import data.UserDetails;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static constant.ConfigValues.csvPath3;
import static constant.ConfigValues.devUrl;

public class OnboardUsers extends BaseTest {

    @Test(groups = {"Onboard user"})
    public void onboardUsers() throws InterruptedException {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);

        List<UserDetails> userDetailsList = new CSVDataStore().readCsvFile(csvPath3);
        List<UserDetails> alreadyOnboardedUsers = new ArrayList<>();
        for (UserDetails user : userDetailsList) {
            if (userDetailsList.indexOf(user) > 666) {
                System.out.println(user.getFull_name());
                loginPage.login(devUrl, user.getEmail(), user.getPassword());
                Thread.sleep(1000);
                assertThat(page.getByTitle("onboarding - TM DEV"));
                if (loginPage.isWelcomePageDisplayed(user.getFirst_name())) {
                    loginPage.clickOnNextButton();
                    assertThat(page.getByTitle("Home - TM DEV"));
                    homePage.logout();
                    System.out.println("Onboarded successfully");
                } else {
                    System.out.println("Already onboarded");
                    alreadyOnboardedUsers.add(user);
                    if (page.getByText(user.getFirst_name()).isVisible()) {
                        homePage.logout();
                    }
                }
            }
        }
        System.out.println("\nAlready Onboarded Users ==============");
        for (UserDetails user1 : alreadyOnboardedUsers) {
            System.out.println(user1.getFull_name());
        }
    }
}