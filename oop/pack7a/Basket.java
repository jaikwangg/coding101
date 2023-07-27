import java.util.ArrayList;

public class Basket {
    private ArrayList<LineItem> items = new ArrayList<>();
    public static int GrandTotal = 0;
    public void showItemsInBasket() {
        System.out.println("This basket contains");
        for (LineItem x : items) {
            System.out.println(x.toString());
        }
        System.out.println();
    }

    public void putInBasket(LineItem item) {
        items.add(item);
        GrandTotal += item.calculateAmount();
    }

    public void printInvoice() { 
        System.out.println("(invoice header)");
        int sum = 0;
        for (LineItem line : items) {
            System.out.println(line.getProduct().getpName() + " x " + line.getQuantity() + " = " + line.calculateAmount());
            sum += line.calculateAmount();
        }
        System.out.println("Total is " + sum + "******");
        System.out.println();
    }

    public void buyNow(LineItem item) {
        putInBasket(item);
        printInvoice();
    }
    public String toString(){
        return String.format("%s",items);
    }
}
