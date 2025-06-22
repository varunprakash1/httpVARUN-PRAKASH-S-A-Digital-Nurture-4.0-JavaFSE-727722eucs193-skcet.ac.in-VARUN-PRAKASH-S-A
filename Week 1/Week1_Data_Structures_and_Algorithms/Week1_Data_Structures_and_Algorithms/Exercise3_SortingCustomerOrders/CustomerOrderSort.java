class Order{
    int orderId;
    String customerName;
    double totalPrice;
    
    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return orderId + " - " + customerName + " - Rs. " + totalPrice;
    }
}

public class CustomerOrderSort {
    public static void bubbleSort(Order[] orders){
        int n = orders.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(orders[j].totalPrice>orders[j+1].totalPrice){
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high){
        if(low<high){
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }
    public static int partition(Order[] orders, int low, int high){
        double pivot = orders[high].totalPrice;
        int i = low-1;

        for(int j=low;j<high;j++){
            if(orders[j].totalPrice < pivot){
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i+1];
        orders[i+1] = orders[high];
        orders[high] = temp;

        return i+1;
    }

    public static void printOrders(String msg, Order[] orders) {
        System.out.println("\n" + msg);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Samrethi", 1500.0),
            new Order(102, "Vishwa", 3500.0),
            new Order(103, "Yokesh", 2200.0),
            new Order(104, "Thulasi", 500.0),
            new Order(105, "Saravanan", 4100.0)
        };

        Order[] bubbleSorted = orders.clone();
        Order[] quickSorted = orders.clone();

        System.out.println();
        bubbleSort(bubbleSorted);
        printOrders("Orders sorted using Bubble Sort (by totalPrice):", bubbleSorted);
        System.out.println();
        quickSort(quickSorted, 0, quickSorted.length - 1);
        printOrders("Orders sorted using Quick Sort (by totalPrice):", quickSorted);
        System.out.println();
    }
}
