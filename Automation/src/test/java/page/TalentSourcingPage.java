package page;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class TalentSourcingPage extends BasePage {

    public TalentSourcingPage(Page page){
        super(page);
    }

    public void selectOnAllPublishedVacancies(){
        Locator dropdown = page.locator("//option[text()=\"My Published Vacancies\"]/ancestor::select[@class=\"ed-select\"]");
        dropdown.selectOption("All Published Vacancies");
    }

    public void searchVacancy(String vacancyName){
        page.getByPlaceholder("Search Job Vacancies...").fill(vacancyName);
        page.locator("//button[@aria-label=\"Search\"]").click();
    }

    public void selectFirstResult(String result){
        Locator list = page.locator("//div[@class=\"tab-content-sec\"]/descendant::div/a/h6");
        list.getByText(result).nth(0).click();
    }

    public void selectMatchingCandidate(String candidate) throws InterruptedException {
        //scrolling to view matching records
        page.locator(".table-candidate-header > tbody").scrollIntoViewIfNeeded();
        Locator pages = page.locator("//div[@class=\"pagination\"]/button");
        int pageCount = pages.count()-2;

        //search for given name in list and click on that candidates view details
        Locator names = page.locator("//table[@class=\"table-candidate-header\"]//tbody/tr/td/div/div/span[1]");
        for(int i = 1; i<= pageCount; i++){
            List<String> candidateNames = names.allTextContents();
            if(candidateNames.contains(candidate)){
                page.locator("//div/span[text()=\""+ candidate +"\"]/ancestor::tr/td/div/button[@aria-label=\"More\"]").click();
                break;
            }
            pages.getByText(String.valueOf(i)).click();
            Thread.sleep(10000);
        }
    }
}
