package Managers;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;
    private AddUsers addUsers;
    private WebTables webTables;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebTables getWebTablesPage() {

        if (webTables == null) {
            webTables = new WebTables(webDriver);
        }
        return webTables;
    }

    public AddUsers getAddUsersPage() {

        if (addUsers == null) {
            addUsers = new AddUsers(webDriver);
        }
        return addUsers;
    }
}
