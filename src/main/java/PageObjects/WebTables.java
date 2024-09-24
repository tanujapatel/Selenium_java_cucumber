package PageObjects;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.ArrayList;
import java.util.List;

public class WebTables {
    private final WebDriver webDriver;

    public WebTables(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

   @FindBy(css = ".btn.ng-scope.ng-binding.btn-primary")
   private WebElement button_OKOnRemoveUserConfirmationDialog;

    @FindBy(css = "button[type='add']")
    private WebElement button_AddUser;

    @FindBy(xpath="//tbody//tr[1]//td")
    private List<WebElement> cells_LatestUser;

    public void clickOnButtonAddUser() {
        Wait.untilElementIsVisible(webDriver,button_AddUser,10L);
       button_AddUser.click();
    }

    public void deleteUser(String username) {
        WebElement button_DeleteUser = webDriver.findElement(By.xpath("//td[3 and text()='"+username+"']//following::button[@ng-click='delUser()']"));
        Wait.untilElementIsVisible(webDriver,button_DeleteUser,10L);
        button_DeleteUser.click();
        button_OKOnRemoveUserConfirmationDialog.click();
    }

    public boolean isUserDeleted(String username) {
        boolean isDeleted = false;
        List<WebElement> row_UserDetail = webDriver.findElements(By.xpath("//td[3 and text()='"+username+"']//parent::tr"));
        if(row_UserDetail.size()==0) isDeleted=true;
        return isDeleted;
    }

    public List<String> getUserDetails(String username) {
        String userPath = "//td[3 and text()='"+username+"']";
        Wait.untilElementIsVisible(webDriver,webDriver.findElement(By.xpath(userPath)),20L);
        List<String> latestUserDetails = new ArrayList<>();
        List<WebElement> userDetElem = webDriver.findElements(By.xpath(userPath+"//parent::tr//td"));
       for(WebElement elem :userDetElem){
           latestUserDetails.add(elem.getText().trim());
        }
       return latestUserDetails;
    }


}
