import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

public class PsychicMarketplace {

    @FindBy(tagName = "li")
    private List<Product> products;

    public int getProductId(int productNumber)
    {
        return products.get(productNumber).getId();
    }

    public String getProductImgUrl(int productNumer)
    {
        return products.get(productNumer).getImgUrl();
    }

    public String getProductUrl(int productNumber)
    {
        return products.get(productNumber).getUrl();
    }

    public void clickProduct(int productNumber)
    {
        products.get(productNumber).clickProduct();
    }

    public static class Product {

        @FindBy(tagName = "img")
        private WebElement image;

        @FindBy(tagName = "a")
        private WebElement product;

        public Integer getId()
        {
            String productId = product.getAttribute("href").replaceAll("[https://itcrowd.pl/vop/product/]", "");
            return Integer.parseInt(productId);
        }

        public String getImgUrl()
        {
            return image.getAttribute("src");
        }

        public String getUrl()
        {
            return product.getAttribute("href");
        }

        public void clickProduct()
        {
            guardHttp(product).click();
        }
    }
}