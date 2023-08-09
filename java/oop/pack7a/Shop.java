import java.util.ArrayList;

public class Shop {
    private String name;
    private Catalog catalog = new Catalog();
    private ArrayList<Basket> ordersToday = new ArrayList<>();

    public Shop(String n) {
        name = n;
        catalog.add(new Drink("mix veggies", "refreshing"),22);
        catalog.add(new Drink("lactasoy", "less hungry"), 15);
        catalog.add(new Noodles("mama", "classic"), 9);
        catalog.add(new Noodles("korean", "i can afford"), 33);
        catalog.add(new Noodles("mama", "duplicate"), 11);
        showCatalog();
    }

    private void showCatalog() {
        System.out.printf("Welcome to %s\n",name);
        catalog.showCatalog();
    }

    public Basket newCustomerArrives() {
        return new Basket();
    }

    public LineItem generateLineItem(String pName, int q) {
        Product product = catalog.getProduct(pName);
        int price = catalog.getPrice(pName);
        
        return new LineItem(product, q, price);
    }

    public LineItem generateBuyNowItem(String pName) {
        return generateLineItem(pName, 1);
    }

    public void getPayment(Basket b) {
        ordersToday.add(b);
        System.out.println("I am cashier");
        b.printInvoice();
    }

    public void dailySalesReport() {
        System.out.printf("OrderToday :\n");
        for(Basket b : ordersToday){
            b.printInvoice();
        }
        System.out.printf("Grand Total Today = %d******",Basket.GrandTotal);
    }
}

