import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

@RunWith(Arquillian.class)
public class PsychicMarketplace {

    @FindBy(xpath = "//*[@id=\"wrap\"]/div[2]/div[4]/div[2]/div[2]")
    private WebElement productsRowOne;
    @FindBy(xpath = "//*[@id=\"row_8\"]")
    private WebElement productsRowTwo;

    @FindBy(xpath = "//*[@id=\"wrap\"]/div[2]/div[4]/div[2]/div[2]/li[1]/a")
    private WebElement productBox;

    public WebElement getProductBox()
    {
        return productBox;
    }

    public void productBoxClick()
    {
        guardHttp(productBox).click();
    }
}
