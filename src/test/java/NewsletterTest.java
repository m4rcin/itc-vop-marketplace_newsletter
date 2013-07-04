import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class NewsletterTest {

    @Page
    private Newsletter newsletter;

    @Drone
    WebDriver driver;

    @Before
    public void testInitialization()
    {
        driver.navigate().to("https://itcrowd.pl/vop/");

    }

    @Test
    public void testNewsletterEmptyInput()
    {
        //when
        newsletter.setInput("");
        guardHttp(newsletter).submit();

        //then
        assertEquals("Enter your email here to subscribe", newsletter.getPopUpText());
    }

    @Test
    public void testNewsletterWrongEmail()
    {
        //when
        newsletter.setInput("aaa");
        guardHttp(newsletter).submit();

        //then
        assertEquals("not a well-formed email address", newsletter.getPopUpText());
    }

    @Test
    public void testNewsletterValidEmail()
    {
        //when
        newsletter.setInput("emailik@gmail.com");
        guardHttp(newsletter).submit();

        //then
        assertEquals("Your address has been added to subscriber list. Check your email and activate subscription.", newsletter.getPopUpText());
    }

    @Test
    public void testNewsletterPopUpClick()
    {
        //when
        newsletter.setInput("aaa");
        guardHttp(newsletter).submit();
        guardHttp(newsletter).popUpClick();
        //then
        assertTrue(newsletter.isPopUpVisible());
    }
}


/*
Poprzednie testy, bez uzycia Page Object
    @Test
    public void NewsletterEmptyEmailTest()
    {
        //given

        //when
        driver.get("https://itcrowd.pl/vop/");
        WebElement inputNewsletter = driver.findElement(By.id("j_idt104:i"));
        inputNewsletter.sendKeys("");
        guardHttp(inputNewsletter).submit();
        WebElement PopupInfo = driver.findElement(By.className("rf-ntf-det"));
        String NewsletterStatus = PopupInfo.getText();

        //then
        assertEquals("Enter your email here to subscribe", NewsletterStatus);
    }

    @Test
    public void NewsletterWrongEmailTest()
    {
        //given

        //when
        driver.get("https://itcrowd.pl/vop/");
        WebElement inputNewsletter = driver.findElement(By.id("j_idt104:i"));
        inputNewsletter.sendKeys("aaa");
        WebElement PopupInfo = driver.findElement(By.className("rf-ntf-det"));
        String NewsletterStatus = PopupInfo.getText();

        //then
        assertEquals("not a well-formed email address", NewsletterStatus);
    }
*/
