import java.util.Arrays;
import java.util.Comparator;

class Product{
    int productId;
    String productName;
    String category;
    
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }

}
public class EcommerceSearch {
    public static Product linearSearch(Product[] products, String searchName){
        for(Product p: products){
            if(p.productName.equalsIgnoreCase(searchName))
                return p;
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String searchName){
        int left = 0;
        int right = products.length - 1;

        while(left<=right){
            int mid = (left+right)/2;
            int p = products[mid].productName.compareToIgnoreCase(searchName);

            if (p==0) 
                return products[mid];
            else if(p<0)
                left = mid+1;
            else
                right = mid-1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Saree", "Clothing"),
            new Product(103, "Book", "Stationery"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Bracelet", "Accessories"),
            new Product(106, "Pen", "Stationery")
        };

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println();
        Product resultLinear = linearSearch(products, "Phone");
        System.out.println("Linear Search Result: "+(resultLinear != null ? resultLinear : "Product not found"));
        System.out.println();
        Product resultBinary = binarySearch(products, "Phone");
        System.out.println("Binary Search Result: "+(resultBinary != null ? resultBinary : "Product not found"));
        System.out.println();
    }
}
