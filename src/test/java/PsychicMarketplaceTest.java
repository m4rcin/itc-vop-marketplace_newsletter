import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.jboss.arquillian.junit.Arquillian;
import org.openqa.selenium.WebDriver;


@RunWith(Arquillian.class)
public class PsychicMarketplaceTest {

    @FindBy(xpath = "//*[@id=\"wrap\"]/div[2]/div[4]/div[2]")
    private PsychicMarketplace marketplace;

    @Drone
    WebDriver driver;

    @Test
    public void testMarketplaceProductId()
    {
        //given
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");

        //then
        assertEquals(62, marketplace.getProductId(0));
    }

    @Test
    public void testMarketplaceProductUrl()
    {

        //given
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");

        //then
        assertEquals("https://itcrowd.pl/vop/product/62" , marketplace.getProductUrl(0));
    }

    @Test
    public void testMarketplaceProductImgUrl()
    {
        //given
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");

        //then
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=62", marketplace.getProductImgUrl(0));
    }

    @Test
    public void testMarketplaceProductClick()
    {
        //given
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");
        marketplace.clickProduct(0);

        //then
        assertEquals("https://itcrowd.pl/vop/product/62" , driver.getCurrentUrl());
    }


}
