import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;


public class Main {
    public static void main(String[] args) {
        var products = new ArrayList<Product>();
        var pr = new Product(99.92, 0);
        products.add(pr);
        products.add(new Product(100, 20));
        products.add(new Product(197, 50));
        products.add(new Product(49.97, 0));
        products.add(new Product(20000, 90));

        applySortByPriceDesc(products);
        System.out.println(products);

        System.out.print("sum: ");
        System.out.println(getSumOfProducts(products));
        System.out.println(getProductsWithHigherPriceThan100(products));
        System.out.println(getCheapestProduct(products));
        System.out.println(getMostExpensiveProduct(products));



    }

    public static double getSumOfProducts(List<Product> products) {
        double sum = 0;

        for (var product : products)
        {
            sum +=  getDiscountedProductPrice(product);
        }

        return sum;
    }

    public static double getDiscountedProductPrice(Product product) {
        var price = product.getPrice();
        var nrOfDays = product.getNrOfDays();

        if (nrOfDays < 10) {
            return price;
        } else if (nrOfDays < 20) {
            return applyDiscount(price, 10);
        } else {
            return applyDiscount(price, 20);
        }
    }

    public static double applyDiscount (double value , int discountAmount) {
        var resultPrice =  value * (100-discountAmount) / 100;
        return Math.round(resultPrice * 20.0) / 20.0;
    }

    public static List<Product> getProductsWithHigherPriceThan100(List<Product> products) {
        return products.stream()
                .filter(product -> product.getPrice() > 100).toList();
    }

    public static Product getCheapestProduct(List<Product> products) {
        return products.stream().min(Comparator.comparing(Product::getPrice)).orElseThrow(NoSuchElementException::new);
    }

    public static Product getMostExpensiveProduct(List<Product> products){
        return products.stream().max(Comparator.comparing(Product::getPrice)).orElseThrow(NoSuchElementException::new);
    }

    public static void applySortByPriceDesc(List<Product> products){
        products.sort((o1, o2) -> (int) (getDiscountedProductPrice(o2) - getDiscountedProductPrice(o1)));
    }

}