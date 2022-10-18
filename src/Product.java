public class Product {
    private double price;
    private int nrOfDays;

    public Product(double price, int nrOfDays) {
        this.setPrice(price);
        this.setNrOfDays(nrOfDays);
    }

    public int getNrOfDays() {
        return nrOfDays;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = Math.round(price * 20.0) / 20.0;
    }

    public void setNrOfDays(int nrOfDays) {
        this.nrOfDays = nrOfDays;
    }

    public String toString()
    {
        return "Product: price= "+this.price+", nrOfDays= "+this.nrOfDays;
    }
}
