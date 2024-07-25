package tests;

import base.BaseTest;
import data.CSVDataStore;
import data.UserDetails;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import page.AdminPage;
import page.HomePage;
import page.LoginPage;
import page.TalentSourcingPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static constant.ConfigValues.automationEmail;
import static constant.ConfigValues.automationPassword;
import static constant.ConfigValues.automationURL1;
import static constant.ConfigValues.csvPath;
import static constant.ConfigValues.csvPath2;
import static constant.ConfigValues.csvPath3;
import static constant.ConfigValues.devEmail;
import static constant.ConfigValues.devPassword;
import static constant.ConfigValues.devUrl;

public class EditProfileDetails extends BaseTest {

    @Test (groups = {"find matching"})
    public void findMatchingCandidateInJobVacancy() throws InterruptedException {
        String vacancy = "QA";
        String result = "QA Engineer";
        List<UserDetails> userDetails = new CSVDataStore().readCsvFile(csvPath2);

        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        TalentSourcingPage talentSourcingPage = new TalentSourcingPage(page);

        loginPage.login(automationURL1, automationEmail, automationPassword);

        //Navigating inside Talent sourcing through more menu
        homePage.clickOnMoreOptions();
        homePage.clickOnTalentSourcing();
        talentSourcingPage.selectOnAllPublishedVacancies();
        talentSourcingPage.searchVacancy(vacancy);
        talentSourcingPage.selectFirstResult(result);
        for(UserDetails user: userDetails){
            talentSourcingPage.selectMatchingCandidate(user.getFull_name());
        }


    }


    @Test (groups = {"edit job"})
    public void editJobTitleOfCandidates() throws InterruptedException {

        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        AdminPage adminPage = new AdminPage(page);

        //Login to application
        loginPage.login(devUrl, devEmail, devPassword);

        //Navigating inside Admin through more menu
        homePage.clickOnMoreOptions();
        homePage.clickOnAdmin();
        adminPage.clickOnAccounts();
        adminPage.clickOnUsers();

        //Reading CSV file
        List<UserDetails> userDetailsList = new CSVDataStore().readCsvFile(csvPath2);
        List<UserDetails> notFoundUsers = new ArrayList<>();

        //Search user and edit its job role
        for (UserDetails user : userDetailsList) {
            adminPage.searchUser(user.getFirst_name());
            if(adminPage.isUserPresentInSearchList(user.getFull_name())){
                Thread.sleep(2000);
                adminPage.clickOnEditUserProfileButton(user.getFull_name());
                assertThat(page.getByText(user.getEmail()));
                adminPage.enterJobRole(user.getJob_title());
                Thread.sleep(1000);
                adminPage.clickOnSaveButton();
            }
            else {
                notFoundUsers.add(user);
                System.out.println("User not found: "+ user.getFirst_name());
            }
        }
    }
}

