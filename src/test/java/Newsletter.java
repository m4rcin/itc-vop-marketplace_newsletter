import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

public class Newsletter {

    @FindBy(css = "[id='wrap'] div.container div.span3 div.row-fluid > input")  //"btn btn-info pull-right
    private WebElement newsletterInput;

    @FindBy(css = "[id='wrap'] div.container div.span3 div.row-fluid [type='submit']")
    private WebElement newsletterSubmit;

    @FindBy(css = "div.rf-ntf-cnt")
    private WebElement popUp;

    public WebElement getInput()
    {
        return newsletterInput;
    }

    public void setInput(String string)
    {
        newsletterInput.clear(); //.clear() don't clear input
        newsletterInput.clear();
        newsletterInput.sendKeys(string);
    }

    public WebElement getPopUp()
    {
        return popUp;
    }

    public String getPopUpText()
    {
        return popUp.getText();
    }

    public WebElement getSubmit()
    {
        return newsletterSubmit;
    }

    public void clickSignUp()
    {
        guardHttp(newsletterSubmit).click();
    }

    public boolean isPopUpVisible()
    {
        return popUp.isDisplayed();
    }

    public void popUpClick()
    {
        popUp.click();
    }
}
