package StepDefinitions;
import PageObjects.AddUsers;
import PageObjects.WebTables;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import Utilities.TestContext;

import java.util.List;

public class WebTablesSteps {

    TestContext testContext;
    WebTables webTablesPage;
    AddUsers addUsers;

    public WebTablesSteps(TestContext context) {
        testContext = context;
        webTablesPage= testContext.getPageObjectManager().getWebTablesPage();
        addUsers= testContext.getPageObjectManager().getAddUsersPage();
    }
    @When("^Click on add user button$")
    public void clickAddUser() {
        webTablesPage.clickOnButtonAddUser();
    }

    @And("^Enter below user details$")
    public void enterUserDetails(DataTable table) {
        List<List<String>> data = table.asLists();
        addUsers.enterUserDetails(data.get(1));
    }
    @And("^Click on save button$")
    public void clickSaveButtonOnAddUser() {
        addUsers.clickOnSaveButton();
    }

    /*user details example: |firstName|lastName|userName|company|role|email|mobileNumber| */
    @Then("^Verify added user details as below$")
    public void verifyLatestAddedUserDetails(DataTable table) {
                List<List<String>> data = table.asLists();
            List<String> latestUserActualDisplayedDetails = webTablesPage.getUserDetails(data.get(1).get(2));
        for (int i = 0; i < data.get(1).size(); i++) {
            Assert.assertEquals(latestUserActualDisplayedDetails.get(i),data.get(1).get(i));
        }
    }

    @And("^I remove user \"([^\"]*)\"$")
    public void removeUser(String username) {
       webTablesPage.deleteUser(username);
    }
    @And("^I verify user \"([^\"]*)\" should not be displayed on table$")
    public void verifyUserRemoved(String username) {
        Assert.assertTrue(webTablesPage.isUserDeleted(username));
    }
}
