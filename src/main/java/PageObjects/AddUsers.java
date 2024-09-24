package PageObjects;

import Utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class AddUsers {
    private final WebDriver webDriver;

    public AddUsers(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @FindBy(name = "FirstName")
    private WebElement input_FirstName;
    @FindBy(name = "LastName")
    private WebElement input_LastName;
    @FindBy(name = "UserName")
    private WebElement input_UserName;
    @FindBy(name = "Password")
    private WebElement input_Password;
    @FindBy(xpath="//label[text()='Company BBB']//input")
    private WebElement radioButton_CompanyBBB;
    @FindBy(xpath="//label[text()='Company AAA']//input")
    private WebElement radioButton_CompanyAAA;
    @FindBy(name = "RoleId")
    private WebElement select_RoleId;
    @FindBy(name = "Email")
    private WebElement input_Email;
    @FindBy(name = "Mobilephone")
    private WebElement input_Mobilephone;
    @FindBy(css = "button[ng-click='save(user)']")
    private WebElement button_Save;
    @FindBy(css = "button[ng-click='close()']")
    private WebElement button_Close;


    public void enterUserDetails(List<String> userDet) {
        Wait.untilElementIsVisible(webDriver,input_FirstName,10L);
        input_FirstName.sendKeys(userDet.get(0));
        input_LastName.sendKeys(userDet.get(1));
        input_UserName.sendKeys(userDet.get(2));
        input_Password.sendKeys(userDet.get(3));
        if(userDet.get(4).equalsIgnoreCase("Company AAA")){
            radioButton_CompanyAAA.click();
        }else if (userDet.get(4).equalsIgnoreCase("Company BBB")){
            radioButton_CompanyBBB.click();
        }
        Select slt = new Select(select_RoleId);
        slt.selectByVisibleText(userDet.get(5));
        input_Email.sendKeys(userDet.get(6));
        input_Mobilephone.sendKeys(userDet.get(7));

    }
    public void clickOnSaveButton() {
        button_Save.click();
    }
    public void clickOnCloseButton() {
        button_Close.click();
    }
}
