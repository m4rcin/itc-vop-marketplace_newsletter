import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

@RunWith(Arquillian.class)
public class Newsletter {

    @FindBy(css = "[id='wrap'] div.container div.span3 div.row-fluid > input")
    private WebElement newsletterInput;
    @FindBy(className = "btn btn-info pull-right")
    private WebElement newsletterSubmit;
    @FindBy(className = "rf-ntf-cnt")
    private WebElement popUp;


    public WebElement getInput()
    {
        return newsletterInput;
    }
    public WebElement getSubmit()
    {
        return newsletterSubmit;
    }
    public WebElement getPopUp()
    {
        return popUp;
    }
    public void setInput(String string)
    {
        newsletterInput.sendKeys(string);
    }
    public void submit()
    {
        guardHttp(newsletterSubmit).click();
    }
    public String getPopUpText()
    {
        return popUp.getText();
    }
    public void popUpClick()
    {
        guardHttp(popUp).click();
    }
    public boolean isPopUpVisible()
    {
        return popUp.isDisplayed();
    }

}
