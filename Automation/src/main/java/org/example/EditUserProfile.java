package org.example;

import com.microsoft.playwright.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class EditUserProfile {

    public static void main(String[] args) throws IOException, InterruptedException {
//        String emailId = "selenium2@smartcalendar.tlk.hr";
//        String password = "Talentlink.1";
        String emailId = "pwaidande@csod.com";
        String password = "Prachi@11";

        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();


        FileReader fileReader = new FileReader("C:\\Users\\pwaidande\\Downloads\\bulk_user_import_2.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<String, List<String>> userDetails = new HashMap<>();
        String line;
        String[] attributes = bufferedReader.readLine().split(",");
        for(String s: attributes){
            userDetails.put(s,new ArrayList<>());
        }


        //Login to application//
//        page.navigate("https://ompautomationv1.cmnetwork.co");
        page.navigate("https://tmdev.edcastqa.com");
        page.getByPlaceholder("Email").fill(emailId);
        page.getByPlaceholder("Password").fill(password);
        page.locator("//button[@type=\"submit\"]").click();

        //Navigating inside Admin through more menu
        page.locator("//button[@aria-label=\"More options and features\"]").click();
        page.getByText("Admin").click();
        Thread.sleep(5000);
        boolean isExpanded = page.locator("//span[text()=\"Accounts\"]/following-sibling::span[contains(@class,\"toggle-button open\")]").isVisible();
        if(!isExpanded){
            page.getByText("Accounts").click();
        }
        page.getByText("Users").click();

        //Searching for user and editing the job title
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            int j =0;

            for (String s : data) {
                List<String> values = new ArrayList<>();
                values.add(s);
                userDetails.put(attributes[j++],values);
            }
            page.locator("//div[@class=\"rubix-panel\"]//input[@class=\"search__input\"]").fill(userDetails.get(attributes[0]).get(0));
            page.locator("//div[@class=\"rubix-panel\"]//span[contains(@class,\"search-icon\")]").click();
            Locator user = page.locator("//table[contains(@class,\"dataTable\")]/tbody/tr/td/a[contains(text(),\""+ (userDetails.get(attributes[0])).get(0).toString()+"\")]/ancestor::tr/td//*[@title=\"Edit\"]");
            Thread.sleep(5000);
            if(user.isVisible()){
                user.click();
                page.locator("//div/input[@aria-label=\"enter job role\"]").fill(userDetails.get(attributes[7]).get(0));
                Thread.sleep(5000);
                page.getByText("Save").scrollIntoViewIfNeeded();
                page.getByText("Save").click();
                System.out.println();
            }
            else {
                for (Map.Entry<String, List<String>> new_Map : userDetails.entrySet()) {
                    //notFoundUserList.put(new_Map.getKey(), new_Map.getValue());
                    System.out.print(new_Map.getKey() + "|"
                            + new_Map.getValue().get(0));
                }

            }
        }

        page.close();
        playwright.close();
    }

}
