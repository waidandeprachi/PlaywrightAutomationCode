package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String emailId = "selenium2@smartcalendar.tlk.hr";
        String password = "Talentlink.1";
        String candidate = "Smokey Bear";

        ArrayList<String> arguments  = new ArrayList<>();
        arguments.add("--start--maximized");

        Playwright playwright  = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setArgs(arguments).setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();

        //Login to application
        page.navigate("https://ompautomationv1.cmnetwork.co/sourcing");
        page.getByPlaceholder("Email").fill(emailId);
        page.getByPlaceholder("Password").fill(password);
        page.locator("//button[@type=\"submit\"]").click();

        //Navigating inside talent sourcing through more menu
        page.locator("//button[@aria-label=\"More options and features\"]").click();
        page.getByText("Talent Sourcing").click();

        //modify display filter and search for QA related vacancy
        Locator dropdown = page.locator("//select[@aria-label=\"My Published Vacancies\"]");
        dropdown.selectOption("All Published Vacancies");
        page.getByPlaceholder("Search Job Vacancies...").fill("QA");
        page.locator("//button[@aria-label=\"Search\"]").click();
        page.waitForLoadState(LoadState.LOAD);

        //selecting "QA Engineer" first element of search result
        Locator list = page.locator("//div[@class=\"tab-content-sec\"]/descendant::div/a/h6");
        System.out.println(list.count());
        List<String> results = list.allTextContents();
        System.out.println(results);
        list.getByText("QA Engineer").nth(0).click();
        assertThat(page).hasURL("https://ompautomationv1.cmnetwork.co/sourcing/manage/job_vacancy/restassureJob_2de1fe69d-add1-486c-9b91-e1e5b671fc1e");
        Thread.sleep(10000);

        //scrolling to view matching records
        page.locator(".table-candidate-header > tbody").scrollIntoViewIfNeeded();
        Locator pages = page.locator("//div[@class=\"pagination\"]/button");
        int pageCount = pages.count()-2;

        //search for given name in list and click on that candidates view details
        Locator names = page.locator("//table[@class=\"table-candidate-header\"]//tbody/tr/td/div/div/span[1]");
        for(int i = 1; i<= pageCount; i++){
            List<String> candidateNames = names.allTextContents();
            System.out.println(candidateNames);
            if(candidateNames.contains(candidate)){
                page.locator("//div/span[text()=\""+ candidate +"\"]/ancestor::tr/td/div/button[@aria-label=\"More\"]").click();
                break;
            }
            pages.getByText(String.valueOf(i)).click();
            Thread.sleep(10000);
        }
        Thread.sleep(10000);
        browser.close();
        playwright.close();
    }

}