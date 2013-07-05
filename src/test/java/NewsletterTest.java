import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(Arquillian.class)
public class NewsletterTest {

    @Drone
    WebDriver driver;

    @Page
    private Newsletter newsletter;

    @Test
    public void testNewsletterDoubleSignUp()
    {
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");
        newsletter.setInput("test123@gmail.com");
        newsletter.clickSignUp();
        newsletter.setInput("test123@gmail.com");
        newsletter.clickSignUp();

        //then
        assertEquals("Sorry, but mail can not be send, try later", newsletter.getPopUpText());
    }

    @Test
    public void testNewsletterEmptyInput()
    {
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");
        newsletter.setInput("");
        newsletter.clickSignUp();

        //then
        assertEquals("Enter your email here to subscribe", newsletter.getPopUpText());
    }

    @Test
    public void testNewsletterPopUpClick()
    {
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");
        newsletter.setInput("");
        newsletter.clickSignUp();
        newsletter.popUpClick();

        //then
        assertFalse(newsletter.isPopUpVisible());
    }

    @Test
    public void testNewsletterValidEmail()
    {
        String randomEmail = UUID.randomUUID().toString() + "@gmail.com";
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");
        newsletter.setInput(randomEmail);
        newsletter.clickSignUp();

        //then
        assertEquals("Your address has been added to subscriber list. Check your email and activate subscription.", newsletter.getPopUpText());
    }

    @Test
    public void testNewsletterWrongEmail()
    {
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");
        newsletter.setInput("aaa");
        newsletter.clickSignUp();

        //then
        assertEquals("not a well-formed email address", newsletter.getPopUpText());
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
        guardHttp(inputNewsletter).clickSignUp();
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
