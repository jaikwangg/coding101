import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<String, Product> productList;
    private Map<String, Integer> priceList;

    public Catalog() {
        productList = new HashMap<>();
        priceList = new HashMap<>();
    }

    public void add(Product product, int price) {
        String productName = product.getpName();
        if (!productList.containsKey(productName)) {
            productList.put(productName, product);
            priceList.put(productName, price);
        }
    }

    public void showCatalog() {
        for (Product product : productList.values()) {
            System.out.println(product.pName + " @ " + priceList.get(product.pName));
        }
        System.out.println();
    }

    public int getPrice(String productName) {
        return priceList.get(productName);
    }

    public Product getProduct(String productName) {
        return productList.get(productName);
    }
}
