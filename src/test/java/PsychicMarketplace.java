import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import java.util.List;

public class PsychicMarketplace {

    @FindBy(tagName = "li")
    private List<Product> products;

    public String getProductUrl(int productNumber)
    {
        return products.get(productNumber).getUrl();
    }

    public String getProductImgUrl(int productNumer)
    {
        return products.get(productNumer).getImgUrl();
    }

    public int getProductId(int productNumber)
    {
        return products.get(productNumber).getId();
    }

    public void clickProduct(int productNumber)
    {
        products.get(productNumber).clickProduct();
    }

    public  static class Product {
        @FindBy(tagName = "a")
        private WebElement product;
        @FindBy(tagName = "img")
        private WebElement image;

        public String getUrl()
        {
            return product.getAttribute("href");
        }
        public Integer getId()
        {
            String productId = product.getAttribute("href").replaceAll("[https://itcrowd.pl/vop/product/]", "");
            return Integer.parseInt(productId);
        }

        public String getImgUrl()
        {
            return image.getAttribute("src");
        }

        public void clickProduct()
        {
            guardHttp(product).click();
        }
    }
}