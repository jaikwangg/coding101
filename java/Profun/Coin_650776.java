public class Coin_650776 {
    String colorHead = "red";
    String colorTail = "red";
    int side;

    public Coin_650776() {
        this.side = 1;
    }

    public Coin_650776(int side) {
        this.side = side;
    }

    public String getColor() {
        if(side == 1){
            return colorHead;
        }else{
            return colorTail;
        }
    }

    public void setColor(String color) {
        if(side == 1){
            colorHead = color;
        }else{
            colorTail = color;
        }
    }

    public void flip() {
        if(side == 1){
            side = 2;
        }else{
            side = 1;
        }
    }

    public String toString() {
        return "Coin_650776[side=" + side + ", color=" + getColor() + "]";
    }
}
