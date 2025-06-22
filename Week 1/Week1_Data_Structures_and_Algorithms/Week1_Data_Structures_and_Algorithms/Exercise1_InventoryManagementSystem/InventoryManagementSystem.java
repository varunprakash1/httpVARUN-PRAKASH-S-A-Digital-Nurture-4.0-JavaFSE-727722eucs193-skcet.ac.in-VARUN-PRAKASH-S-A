import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price){
        this.productId=productId;
        this.productName=productName;
        this.quantity=quantity;
        this.price=price;
    }

    public String toString(){
        return productId + " - " + productName + " - Quantity: " + quantity + " - Price: " + price;
    }
}
class Inventory{
    HashMap<Integer, Product> inventoryMap = new HashMap<>();

    public void addProduct(Product p){
        if(inventoryMap.containsKey(p.productId)){
            System.out.println("Product ID already exists!");
        }
        else{
            inventoryMap.put(p.productId, p);
            System.out.println("Product added.");
        }
    }

    public void updateProduct(int productId,int quantity,double price){
        if (inventoryMap.containsKey(productId)) {
            Product p = inventoryMap.get(productId);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated.");
        }
        else{
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId){
        if (inventoryMap.remove(productId)!=null) {
            System.out.println("Product deleted.");
        }
        else {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory(){
        if(inventoryMap.isEmpty()){
            System.out.println("Inventory is empty.");
        }
        else{
            System.out.println("Products in the Inventory");
            for(Product p: inventoryMap.values()){
                System.out.println(p);
            }
        }
    }
}
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Product p1 = new Product(101, "Laptop", 10, 60000.0);
        Product p2 = new Product(102, "Mouse", 50, 500.0);
    
        System.out.println();
        inv.addProduct(p1);
        inv.addProduct(p2);
        System.out.println();
        
        inv.displayInventory();
        System.out.println();

        inv.updateProduct(102, 60, 550.0);
        System.out.println();        

        inv.deleteProduct(101);
        System.out.println();        

        inv.displayInventory();
        System.out.println();        
    }    
}